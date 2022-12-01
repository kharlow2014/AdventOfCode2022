package days

import DayOfCode

// https://adventofcode.com/2022/day/1

sealed class DayOne(override val problem: Problem) : DayOfCode(Day.ONE, problem) {
    override val dataFileName: String
        get() = "/one.data"

    class ProblemOne : DayOne(Problem.ONE) {

        override fun solve(): String {
            val input = this::class.java.getResourceAsStream(dataFileName).bufferedReader().readLines()
            val totalCaloriesByElf = getTotalCalorieCountPerElf(input)
            val maxCalories = totalCaloriesByElf.maxOrNull() ?: 0
            return "$maxCalories"
        }
    }

    class ProblemTwo : DayOne(Problem.TWO) {
        override fun solve(): String {
            val input = this::class.java.getResourceAsStream(dataFileName).bufferedReader().readLines()
            val totalCaloriesByElf = getTotalCalorieCountPerElf(input)
            val maxCalories = totalCaloriesByElf.take(3).sum()
            return "$maxCalories"
        }
    }

    fun getTotalCalorieCountPerElf(input: List<String>): List<Int> {
        val foodItemsByElf = mutableListOf<List<Int>>()
        var foodItemsForCurrentElf = mutableListOf<Int>()

        input.forEachIndexed { index, item ->
            if (index == input.size - 1) {
                foodItemsForCurrentElf.add(item.toInt())
                foodItemsByElf.add(foodItemsForCurrentElf)
            } else if (item.isNotBlank()) {
                foodItemsForCurrentElf.add(item.toInt())
            } else {
                foodItemsByElf.add(foodItemsForCurrentElf)
                foodItemsForCurrentElf = mutableListOf()
            }
        }
        return foodItemsByElf.map { it.sum() }.sortedDescending()
    }
}
