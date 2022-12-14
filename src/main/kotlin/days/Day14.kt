package days

import DayOfCode
import kotlin.math.max
import kotlin.math.min

sealed class Day14(override val problem: DayOfCode.Problem) : DayOfCode(day = Day.FOURTEEN, problem = problem) {

    override val dataFileName: String
        get() = "/14.data"

    class Problem1 : Day14(Problem.ONE) {
        override fun solve(): String {
            val map = RockMap.Chasm(readLines())
            return map.dropSand().toString()
        }
    }

    class Problem2 : Day14(Problem.TWO) {
        override fun solve(): String {
            val map = RockMap.Floor(readLines())
            return map.dropSand().toString()
        }
    }

    data class RockLine(private val input: String) {
        // Pair
        val points = input.split(" -> ").map {
            val ss = it.split(",")
            Pair(ss[0].toInt(), ss[1].toInt())
        }
    }

    sealed class RockMap(input: List<String>) {

        protected val rockLines = input.map { RockLine(it) }
        protected open val minX = rockLines.minOf { d -> d.points.minOf { it.first } }
        protected open val maxX = rockLines.maxOf { d -> d.points.maxOf { it.first } }
        protected open val minY = 0
        protected open val maxY = rockLines.maxOf { d -> d.points.maxOf { it.second } }
        protected val map: MutableList<MutableList<Boolean?>> = mutableListOf()
        private val sandStart = Pair(500, 0)

        private fun printMap() {
            map.forEach { y ->
                y.forEach {
                    when (it) {
                        null -> print(".")
                        true -> print("#")
                        else -> print("o")
                    }
                }
                println()
            }
            println()
        }

        fun dropSand(print: Boolean = false): Int {
            var n = 0
            while(dropSand(sandStart)) {
                n++
            }
            if (print) printMap()
            return n
        }

        private fun dropSand(point: Pair<Int, Int>): Boolean {
            return when {
                point.second - minY + 1 > map.size - 1 -> false
                map[point.second - minY + 1][point.first - minX] == null -> dropSand(Pair(point.first, point.second + 1))
                point.first - minX - 1 < 0 -> false
                map[point.second - minY + 1][point.first - minX - 1] == null -> dropSand(Pair(point.first - 1, point.second + 1))
                point.first - minX + 1 > map[0].size - 1 -> false
                map[point.second - minY + 1][point.first - minX + 1] == null -> dropSand(Pair(point.first + 1, point.second + 1))
                map[point.second - minY][point.first - minX] == false -> false
                else -> {
                    map[point.second - minY][point.first - minX] = false
                    true
                }
            }
        }

        class Chasm(input: List<String>) : RockMap(input) {
            init {
                for (i in minY..maxY) {
                    val l = mutableListOf<Boolean?>()
                    for (j in minX..maxX) {
                        l.add(null)
                    }
                    map.add(l)
                }

                rockLines.forEach {
                    it.points.forEachIndexed { index, pair ->
                        if (index == 0) {
                            map[pair.second - minY][pair.first - minX] = true
                        } else {
                            if (it.points[index - 1].second - pair.second != 0) {
                                for (i in (min(it.points[index - 1].second, pair.second) - minY)..(max(it.points[index - 1].second, pair.second) - minY)) {
                                    map[i][pair.first - minX] = true
                                }
                            }
                            if (it.points[index - 1].first - pair.first != 0) {
                                for (i in (min(it.points[index - 1].first, pair.first) - minX)..(max(it.points[index - 1].first, pair.first) - minX)) {
                                    map[pair.second - minY][i] = true
                                }
                            }
                        }
                    }
                }
            }
        }

        class Floor(input: List<String>) : RockMap(input) {
            override val minX: Int = 0
            override val maxX: Int = 1000
            override val maxY: Int = super.maxY + 2

            init {
                for (i in minY..maxY) {
                    val l = mutableListOf<Boolean?>()
                    for (j in minX..maxX) {
                        if (i == maxY) {
                            l.add(true)
                        } else {
                            l.add(null)
                        }
                    }
                    map.add(l)
                }

                rockLines.forEach {
                    it.points.forEachIndexed { index, pair ->
                        if (index == 0) {
                            map[pair.second - minY][pair.first - minX] = true
                        } else {
                            if (it.points[index - 1].second - pair.second != 0) {
                                for (i in (min(it.points[index - 1].second, pair.second) - minY)..(max(it.points[index - 1].second, pair.second) - minY)) {
                                    map[i][pair.first - minX] = true
                                }
                            }
                            if (it.points[index - 1].first - pair.first != 0) {
                                for (i in (min(it.points[index - 1].first, pair.first) - minX)..(max(it.points[index - 1].first, pair.first) - minX)) {
                                    map[pair.second - minY][i] = true
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
