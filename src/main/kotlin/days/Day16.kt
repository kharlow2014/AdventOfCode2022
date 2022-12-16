package days

import DayOfCode
import kotlin.math.max

sealed class Day16(override val problem: Problem) : DayOfCode(day = Day.SIXTEEN, problem = problem) {

    override val dataFileName: String
        get() = "/16.data"

    class Problem1 : Day16(Problem.ONE) {
        override fun solve(): Int {
            val valves = Valves(readText())
            return valves.maxFlow
        }
    }

    class Problem2 : Day16(Problem.TWO) {
        override fun solve(): Any {
            val valves = Valves(readText(), totalTime = 26, partTwo = true)
            return valves.maxFlow
        }
    }

    data class Valve(val name: String, val flowRate: Int, val destinations: List<String>)

    class Valves(val input: String, private var totalTime: Int = 30, partTwo: Boolean = false) {
        private val valves: List<Valve>
        private val valveMap: Map<String, Valve>
        private val shortestPaths: Map<String, Map<String, Int>>
        private val valvesWithFlow: Set<Valve>
        var maxFlow = 0

        init {
            val regex = Regex("Valve (\\w+) has flow rate=(\\d+); tunnels? leads? to valves? ((\\w+)(, \\w+)*)")
            val matches = regex.findAll(input)
            valves = matches.map { Valve(it.groupValues[1], it.groupValues[2].toInt(), it.groupValues[3].split(", ")) }
                .toList()
            valveMap = valves.associateBy { it.name }
            valvesWithFlow = valveMap.values.filter { it.flowRate != 0 }.toSet()
            shortestPaths =
                floydWarshall(valves.associate { it.name to it.destinations.associateWith { 1 }.toMutableMap() }
                    .toMutableMap())
            dfs(currFlow = 0, currentValue = "AA", visited = emptySet(), time = 0, partTwo = partTwo)
        }

        fun dfs(currFlow: Int, currentValue: String, visited: Set<String>, time: Int, partTwo: Boolean) {
            maxFlow = max(maxFlow, currFlow)
            for ((valve, dist) in shortestPaths[currentValue]!!) {
                if (!visited.contains(valve) && time + dist + 1 < totalTime) {
                    dfs(
                        currFlow + (totalTime - time - dist - 1) * valveMap[valve]?.flowRate!!, 
                        valve,
                        visited.union(listOf(valve)),
                        time + dist + 1,
                        partTwo
                    )
                }
            }
            if (partTwo) dfs(currFlow, "AA", visited, 0, false)
        }

        private fun floydWarshall(shortestPaths: MutableMap<String, MutableMap<String, Int>>): MutableMap<String, MutableMap<String, Int>> {
            for (k in shortestPaths.keys) {
                for (i in shortestPaths.keys) {
                    for (j in shortestPaths.keys) {
                        val ik = shortestPaths[i]?.get(k) ?: 9999
                        val kj = shortestPaths[k]?.get(j) ?: 9999
                        val ij = shortestPaths[i]?.get(j) ?: 9999
                        if (ik + kj < ij)
                            shortestPaths[i]?.set(j, ik + kj)
                    }
                }
            }
            shortestPaths.values.forEach {
                it.keys.map { key -> if (valveMap[key]?.flowRate == 0) key else "" }
                    .forEach { toRemove -> if (toRemove != "") it.remove(toRemove) }
            }
            return shortestPaths
        }
    }
}
