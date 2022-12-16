package days

import DayOfCode
import java.util.UUID

sealed class Day11(override val problem: Problem) : DayOfCode(day = Day.ELEVEN, problem = problem) {

    override val dataFileName: String
        get() = "/11.data"

    class Problem1 : Day11(Problem.ONE) {
        override fun solve(): Long {
            val group = MonkeyGroup(readText())
            group.rounds(20)
            return group.monkeyBusiness()
        }
    }
    
    class Problem2 : Day11(Problem.TWO) {
        override fun solve(): Long {
            val group = MonkeyGroup(readText(), false)
            group.rounds(10000)
            return group.monkeyBusiness()
        }
    }

    data class MonkeyGroup(private val input: String, private val worryDecreased: Boolean = true) {
        
        private val monkeys = regex.findAll(input).toList().map { Monkey(it) }
        private val modFactor = monkeys.map { it.divider }.reduce { acc, d -> acc * d }

        fun rounds(num: Int) {
            for (i in 0 until num) {
                monkeys.forEach { monkey ->
                    while (monkey.items.isNotEmpty()) {
                        val item = if (worryDecreased) monkey.calmingInspect(modFactor) else monkey.worryingInspect(modFactor)
                        val pass = monkey.test(item)
                        monkeys.first { it.id == pass.second }.items.add(pass.first)
                    }
                }
            }
        }
        
        fun monkeyBusiness(): Long {
            val sorted = monkeys.sortedByDescending { it.inspectedCount }
            return (sorted[0].inspectedCount.toLong() * sorted[1].inspectedCount.toLong())
        }

        companion object {
            val regex = "Monkey (\\d):\\n\\s+Starting items: ((\\d+)(,\\s*\\d+)*)\\n\\s*Operation: new = (\\w+) ([*+]) (\\w+)\\n\\s+Test: divisible by (\\d+)\\n\\s+If true: throw to monkey (\\d+)\\n\\s+If false: throw to monkey (\\d+)".toRegex()
        }
    }

    data class Monkey(private val match: MatchResult) {

        val id: Int = match.groupValues[1].toInt()
        val items: MutableList<Item> = match.groupValues[2].split(", ").map { Item(it.toLong()) }.toMutableList()
        val calmingInspect: (Long) -> Item
        val worryingInspect: (Long) -> Item
        val divider = match.groupValues[8].toLong()
        private val trueMonkey = match.groupValues[9].toInt()
        private val falseMonkey = match.groupValues[10].toInt()
        var inspectedCount = 0

        init {
            calmingInspect = {
                inspectedCount++
                val item = items[0].apply { worry %= it }
                items.remove(item)
                val a = if (match.groupValues[5] == "old") item.worry else match.groupValues[5].toLong()
                val b = if (match.groupValues[7] == "old") item.worry else match.groupValues[7].toLong()
                if (match.groupValues[6] == "+") item.apply { worry = (a + b) / 3L } else item.apply { worry = (a * b) / 3L }
            }
            worryingInspect = {
                inspectedCount++
                val item = items[0].apply { worry %= it }
                items.remove(item)
                val a = if (match.groupValues[5] == "old") item.worry else match.groupValues[5].toLong()
                val b = if (match.groupValues[7] == "old") item.worry else match.groupValues[7].toLong()
                if (match.groupValues[6] == "+") item.apply { worry = a + b } else item.apply { worry = a * b }
            }
        }
        
        fun test(item: Item): Pair<Item, Int> {
            return if (item.worry % divider == 0L) {
                item to trueMonkey
            } else {
                item to falseMonkey
            }
        }
    }

    data class Item(var worry: Long, private val id: UUID = UUID.randomUUID())

}
