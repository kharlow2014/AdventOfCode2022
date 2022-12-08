package days

import DayOfCode

sealed class Day8(override val problem: Problem) : DayOfCode(Day.EIGHT, problem) {

    override val dataFileName: String
        get() = "/8.data"

    class Problem1 : Day8(Problem.ONE) {
        override fun solve(): String {
            val input = readLines().map { line -> line.map { it.digitToInt() } }
            return input.foldIndexed(0) { row, acc, list ->
                acc + list.mapIndexed { column, item ->
                    if (row == 0 || row == input.size - 1) {
                        1
                    } else if (column == 0 || column == input[0].size - 1) {
                        1
                    } else {
                        if (item > list.subList(0, column).maxOf { it }) {
                            1
                        } else if (item > list.subList(column + 1, list.size).maxOf { it }) {
                            1
                        } else if (item > input.column(column).subList(0, row).maxOf { it }) {
                            1
                        } else if (item > input.column(column).subList(row + 1, list.size).maxOf { it }) {
                            1
                        } else {
                            0
                        }
                    }
                }.sum()
            }.toString()
        }
    }

    class Problem2 : Day8(Problem.TWO) {
        override fun solve(): String {
            val input = readLines().map { line -> line.map { it.digitToInt() } }
            return input.flatMapIndexed { row, list ->
                list.mapIndexed { column, item ->
                    if (column == 0 || row == 0) {
                        0
                    } else {
                        var left = 0
                        run {
                            list.subList(0, column).reversed().forEach {
                                left++
                                if (item <= it) return@run
                            }
                        }
                        var right = 0
                        run {
                            list.subList(column + 1, list.size).forEach { 
                                right++
                                if (item <= it) return@run
                            }
                        }
                        var up = 0
                        run {
                            input.column(column).subList(0, row).reversed().forEach { 
                                up++
                                if (item <= it) return@run
                            }
                        }
                        var down = 0
                        run {
                            input.column(column).subList(row + 1, list.size).forEach { 
                                down++
                                if (item <= it) return@run
                            }
                        }
                        right * left * up * down
                    }
                }
            }.maxOf { it }.toString()
        }
    }

    fun <T> List<List<T>>.column(column: Int): List<T> {
        return this.map { it[column] }
    }
}
