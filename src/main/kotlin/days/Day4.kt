package days

import DayOfCode

sealed class Day4(override val problem: Problem) : DayOfCode(day = Day.FOUR, problem = problem) {

    override val dataFileName: String
        get() = "/4.data"

    class Problem1 : Day4(Problem.ONE) {
        override fun solve(): String {
            return readLines().flatMap { line -> line.split(",", "-").map { it.toInt() } }.chunked(4) { if ((it[0] >= it[2] && it[1] <= it[3]) || (it[0] <= it[2] && it[1] >= it[3])) 1 else 0 }.sum().toString()
        }
    }

    class Problem2 : Day4(Problem.TWO) {
        override fun solve(): String {
            return readLines().flatMap { line -> line.split(",", "-").map { it.toInt() } }.chunked(4) { if ((it[1] >= it[2] && it[0] <= it[3]) || (it[1] <= it[2] && it[0] >= it[3])) 1 else 0 }.sum().toString()
        }
    }
}
