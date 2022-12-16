package days

import DayOfCode

sealed class Day3(override val problem: Problem) : DayOfCode(day = Day.THREE, problem = problem) {
    override val dataFileName: String
        get() = "/3.data"

    class Problem1 : Day3(Problem.ONE) {
        override fun solve(): Int {
            return readLines().sumOf { items ->
                RuckSack(items).duplicate.priority()
            }
        }
    }

    class Problem2 : Day3(Problem.TWO) {
        override fun solve(): Int {
            return readLines().chunked(3) { chunk -> ElfGroup(chunk) }.sumOf { group -> group.badge.priority() }
        }
    }

    data class RuckSack(private val input: String) {
        private val items = input.toList()
        val itemSet = items.toSet()
        private val midPoint = (items.size + 1) / 2
        private val first = items.subList(0, midPoint).toSet()
        private val second = items.subList(midPoint, items.size).toSet()
        val duplicate = (first intersect second).first()
    }

    data class ElfGroup(private val elfGroup: List<String>) {
        private val elf1RuckSack = RuckSack(elfGroup[0])
        private val elf2RuckSack = RuckSack(elfGroup[1])
        private val elf3RuckSack = RuckSack(elfGroup[2])
        val badge = ((elf1RuckSack.itemSet intersect elf2RuckSack.itemSet) intersect elf3RuckSack.itemSet).first()
    }

    fun Char.priority(): Int {
        return if (this.isUpperCase()) {
            this.code - 38
        } else {
            this.code -96
        }
    }
}
