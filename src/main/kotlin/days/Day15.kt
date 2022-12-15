package days

import DayOfCode
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

sealed class Day15(override val problem: Problem) : DayOfCode(day = Day.FIFTEEN, problem = problem) {

    override val dataFileName: String
        get() = "/15.data"
    
    class Problem1(private val y: Int = 2000000) : Day15(Problem.ONE) {
        override fun solve(): String {
            val sensors = Sensors(readLines())
            val minColumn = sensors.sensorMap.values.minOf { it.minPointCoveredAtY(y).first }
            val maxColumn = sensors.sensorMap.values.maxOf { it.maxPointCoveredAtY(y).first }
            var currentPair = minColumn to y
            var count: Int = 0
            while (currentPair.first <= maxColumn) {
                val coveredBySensor = sensors.coveredBySensor(currentPair)
                if (coveredBySensor != null) {
                    val maxColumnCovered = coveredBySensor.maxPointCoveredAtY(currentPair.second)
                    count += maxColumnCovered.first - currentPair.first + 1
                    count -= sensors.sensorsOnRow(currentPair.second, currentPair.first, maxColumnCovered.first).size
                    count -= sensors.beaconsOnRow(currentPair.second, currentPair.first, maxColumnCovered.first).size
                    currentPair = maxColumnCovered
                }
                currentPair = currentPair.copy(first = currentPair.first + 1)
            }
            return count.toString()
        }
    }

    class Problem2(private val min: Int = 0, private val max: Int = 4000000) : Day15(Problem.TWO) {
        override fun solve(): String {
            val notCovered = notCoveredPair()
            return (notCovered.first.toLong() * 4000000 + notCovered.second.toLong()).toString()
        }
        
        private fun notCoveredPair(): Pair<Int, Int> {
            val sensors = Sensors(readLines())
            for (y in min..max) {
                var currentPair = Pair(0, y)
                while (currentPair.first <= max) {
                    val coveredBySensor = sensors.coveredBySensor(currentPair)
                    if (coveredBySensor != null) {
                        currentPair = coveredBySensor.maxPointCoveredAtY(currentPair.second)
                        currentPair = currentPair.copy(first = currentPair.first + 1)
                    } else {
                        return currentPair
                    }
                }
            }
            return Pair(0, 0)
        }
    }

    data class Sensor(val s: Pair<Int, Int>, val b: Pair<Int, Int>) {
        val d = distanceTo(b)
        
        fun distanceTo(o: Pair<Int, Int>): Int = abs(s.first - o.first) + abs(s.second - o.second)
        fun covers(o: Pair<Int, Int>): Boolean = d >= distanceTo(o)
        fun maxPointCoveredAtY(y: Int) = Pair(s.first + abs(d - abs(y - s.second)), y)
        fun minPointCoveredAtY(y: Int) = Pair(s.first - abs(d - abs(y - s.second)), y)
    }
    
    class Sensors(input: List<String>) {
        val beacons: Set<Pair<Int, Int>>
        val sensorMap: Map<Pair<Int, Int>, Sensor>
        
        fun sensorsOnRow(row: Int, minColumn: Int, maxColumn: Int): List<Sensor> {
            return sensorMap.values.filter { it.s.second == row && it.s.first >= minColumn &&  it.s.first <= maxColumn }
        }
        
        fun beaconsOnRow(row: Int, minColumn: Int, maxColumn: Int): List<Pair<Int, Int>> {
            return beacons.filter { it.second == row && it.first >= minColumn && it.first <= maxColumn }
        }
        
        fun coveredBySensor(pair: Pair<Int, Int>): Sensor? {
            return sensorMap.values.find { it.covers(pair) }
        }
        
        init {
            val regex = Regex("-?\\d+")
            sensorMap = input.map { s ->
                regex.findAll(s).map { it.value.toInt() }.toList()
            }.map {
                Sensor(it[0] to it[1], it[2] to it[3])
            }.associateBy { it.s }
            beacons = sensorMap.values.map { it.b }.toSet()
        }
    }
}
