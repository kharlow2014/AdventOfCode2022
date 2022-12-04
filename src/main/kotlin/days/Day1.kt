package days

import DayOfCode

// https://adventofcode.com/2022/day/1

sealed class Day1(override val problem: Problem) : DayOfCode(Day.ONE, problem) {
    override val dataFileName: String
        get() = "/1.data"

    class Problem1 : Day1(Problem.ONE) {

        override fun solve(): String {
            return "${getTotalCalorieCountPerElf().first()}"
        }
    }

    class Problem2 : Day1(Problem.TWO) {
        override fun solve(): String {
            return "${getTotalCalorieCountPerElf().take(3).sum()}"
        }
    }

    fun getTotalCalorieCountPerElf(): List<Int> {
        val foodItemsByElf = mutableListOf<MutableList<Int>>(mutableListOf())
        readLines().forEach {
            if (it.isBlank()) {
                foodItemsByElf.add(mutableListOf())
            } else {
                foodItemsByElf.last().add(it.toInt())
            }
        }
        return foodItemsByElf.map { it.sum() }.sortedDescending()
    }
}
