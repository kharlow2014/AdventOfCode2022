package days

import DayOfCode

sealed class Day6(override val problem: Problem) : DayOfCode(Day.SIX, problem) {

    override val dataFileName: String
        get() = "/6.data"
    
    class Problem1(private val input: String? = null) : Day6(Problem.ONE) {
        override fun solve(): String {
            return solve(input ?: readText(), 4).toString()
        }
    }

    class Problem2(private val input: String? = null) : Day6(Problem.TWO) {
        override fun solve(): String {
            return solve(input ?: readText(), 14).toString()
        }
    }
    
    protected val solve: (String, Int) -> Int = { input, length ->
        input.windowed(length).foldIndexed(0) { index, acc, string ->
            if (string.toSet().size == length && acc == 0) index + length else acc
        }
    }
}
