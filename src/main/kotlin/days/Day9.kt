package days

import DayOfCode
import kotlin.math.abs

sealed class Day9(override val problem: Problem) : DayOfCode(Day.NINE, problem) {

    override val dataFileName: String
        get() = "/9.data"

    class Problem1 : Day9(Problem.ONE) {
        override fun solve(): String {
            var head = Pair(0, 0)
            val tail = mutableListOf(Pair(0, 0))
            readLines().forEach {
                val d = it.split(" ")[1].toInt()
                for (i in 0 until d) {
                    head = when (it[0]) {
                        'U' -> Pair(head.first, head.second + 1)
                        'D' -> Pair(head.first, head.second - 1)
                        'L' -> Pair(head.first - 1, head.second)
                        'R' -> Pair(head.first + 1, head.second)
                        else -> Pair(0, 0)
                    }
                    val oldTail = tail.last()
                    tail.add(when {
                        head.first - oldTail.first > 1 -> Pair(head.first - 1, head.second)
                        oldTail.first - head.first > 1 -> Pair(head.first + 1, head.second)
                        head.second - oldTail.second > 1 -> Pair(head.first, head.second - 1)
                        oldTail.second - head.second > 1 -> Pair(head.first, head.second + 1)
                        else -> oldTail
                    })
                }
            }
            return tail.toSet().size.toString()
        }
    }

    class Problem2 : Day9(Problem.TWO) {
        override fun solve(): String {
            val knots = mutableListOf(Pair(0, 0), Pair(0, 0), Pair(0, 0), Pair(0, 0), Pair(0, 0), Pair(0, 0), Pair(0, 0), Pair(0, 0), Pair(0, 0), Pair(0, 0))
            val tail = mutableListOf(Pair(0, 0))
            readLines().forEach {
                val d = it.split(" ")[1].toInt()
                for (x in 0 until d) {
                    knots.forEachIndexed { i, knot ->
                        if (i == 0) {
                            knots[i] = when (it[0]) {
                                'U' -> Pair(knot.first, knot.second + 1)
                                'D' -> Pair(knot.first, knot.second - 1)
                                'L' -> Pair(knot.first - 1, knot.second)
                                'R' -> Pair(knot.first + 1, knot.second)
                                else -> Pair(0, 0)
                            }
                        } else {
                            val last = knots[i - 1]
                            knots[i] = when {
                                last.first - knot.first > 1 && last.second - knot.second > 1 -> Pair(last.first - 1, last.second - 1) // ru
                                last.first - knot.first > 1 && knot.second - last.second > 1 -> Pair(last.first - 1, last.second + 1) // rd
                                knot.first - last.first > 1 && last.second - knot.second > 1 -> Pair(last.first + 1, last.second - 1) // lu
                                knot.first - last.first > 1 && knot.second - last.second > 1 -> Pair(last.first + 1, last.second + 1) // ld
                                last.first - knot.first > 1 -> Pair(last.first - 1, last.second) // r
                                knot.first - last.first > 1 -> Pair(last.first + 1, last.second) // l
                                last.second - knot.second > 1 -> Pair(last.first, last.second - 1) // u
                                knot.second - last.second > 1 -> Pair(last.first, last.second + 1) // d
                                else -> knots[i]
                            }
                        }
                        if (i == knots.size - 1) {
                            tail.add(knots[i])
                        }
                    }
                }
                println()
            }
            return tail.toSet().size.toString()
        }
    }

    fun distanceToTail(head: Pair<Int, Int>, tail: Pair<Int, Int>): Pair<Int, Int> {
        return Pair(head.first - tail.first, head.second - tail.second)
    }
}
