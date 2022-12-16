package days

import DayOfCode

sealed class Day10(override val problem: Problem) : DayOfCode(day = Day.TEN, problem = problem) {

    override val dataFileName: String
        get() = "/10.data"

    class Problem1 : Day10(Problem.ONE) {
        override fun solve(): Int {
            var d: Int? = null
            var cycle = 0
            var x = 1
            val out =  readLines().fold(0) { out, s ->
                cycle++
                x += (d ?: 0)
                if (s != "noop") {
                    d = s.split(" ")[1].toInt()
                    cycle++
                } else {
                    d = null
                }
                val o = if ((cycle - 20) % 40 == 0)
                    cycle * x
                else if (s.split(" ")[0] == "addx" && (cycle - 21) % 40 == 0)
                    (cycle - 1) * x
                else
                    0
                out + o
            }
            return out
        }
    }

    class Problem2 : Day10(Problem.TWO) {
        override fun solve(): String {
            val input = readLines().flatMap {
                if (it == "noop") {
                    listOf(0)
                } else {
                    listOf(0, it.split(" ")[1].toInt())
                }
            }
            var x = 1
            return input.foldIndexed("") { index, acc, i ->
                var sc = if (x in (index % 40)-1..(index % 40)+1) {
                    "$acc#"
                } else {
                    "$acc."
                }
                if ((index + 1) % 40 == 0) sc += "\n"
                x += i
                sc
            }
        }
    }
}
