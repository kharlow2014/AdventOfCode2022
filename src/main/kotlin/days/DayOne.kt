package days

import DayOfCode

// https://adventofcode.com/2022/day/1

sealed class DayOne(override val problem: Problem) : DayOfCode(Day.ONE, problem) {
    override val dataFileName: String
        get() = "/one.data"

    class ProblemOne : DayOne(Problem.ONE) {

        override fun solve(): String {
            return "${getTotalCalorieCountPerElf().first()}"
        }
    }

    class ProblemTwo : DayOne(Problem.TWO) {
        override fun solve(): String {
            return "${getTotalCalorieCountPerElf().take(3).sum()}"
        }
    }

    fun getTotalCalorieCountPerElf(): List<Int> {
        val foodItemsByElf = mutableListOf<MutableList<Int>>(mutableListOf())
        this::class.java.getResourceAsStream(dataFileName).bufferedReader().readLines().forEach {
            if (it.isBlank()) {
                foodItemsByElf.add(mutableListOf())
            } else {
                foodItemsByElf.last().add(it.toInt())
            }
        }
        return foodItemsByElf.map { it.sum() }.sortedDescending()
    }
}
