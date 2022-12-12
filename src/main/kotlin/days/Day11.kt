package days

import DayOfCode

sealed class Day11(override val problem: Problem) : DayOfCode(day = Day.ELEVEN, problem = problem) {

    override val dataFileName: String
        get() = "/11.data"

    class Problem1 : Day11(Problem.ONE) {
        override fun solve(): String {
            val monkeys = Monkey.regex.findAll(readText()).map {
                Monkey(it)
            }
            return monkeys.toString()
        }
    }

    data class Monkey(private val match: MatchResult) {

        val id: Int
        val items = mutableListOf<Item>()
        val operation: (Item) -> Item
        val test: (Item) -> Int

        init {
            id = match.groupValues[1].toInt()
            println(match.groupValues[2])
            operation = { item ->
                val a = if (match.groupValues[3] == "old") item.worry else match.groupValues[3].toInt()
                val b = if (match.groupValues[5] == "old") item.worry else match.groupValues[5].toInt()
                if (match.groupValues[4] == "+") {
                    item.apply { worry = a + b }
                } else {
                    item.apply { worry = a * b }
                }
            }
            test = { item ->
                if (item.worry / match.groupValues[6].toInt() == 0) {
                    match.groupValues[7].toInt()
                } else {
                    match.groupValues[8].toInt()
                }
            }
        }


        companion object {
            val regex = "Monkey :(\\d):\\n\\s+Starting items: ((\\d+),(\\s*\\d+)*)\\s+Operation: new = (\\w+) ([*+]) (\\w+)\\n\\s+Test: divisible by (\\d+)\\n\\s+If true: throw to monkey (\\d)\\n\\s+If false: throw to monkey (\\d)".toRegex()
        }
    }

    data class Item(var worry: Int)

}
