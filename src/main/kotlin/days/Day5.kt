package days

import DayOfCode

sealed class Day5(override val problem: Problem) : DayOfCode(day = Day.FIVE, problem) {

    override val dataFileName: String
        get() = "/5.data"

    class Problem1 : Day5(Problem.ONE) {
        override fun solve(): String {
            val cratesWithInstructions = CratesWithInstructions(readText())
            val cratesAfterMoves = cratesWithInstructions.executeInstructions9000()
            return cratesAfterMoves.state.fold(mutableListOf<Char>()) { acc, column ->
                acc.addAll(column.takeLast(1))
                acc
            }.joinToString(separator = "")
        }
    }

    class Problem2 : Day5(Problem.TWO) {
        override fun solve(): String {

            val cratesWithInstructions = CratesWithInstructions(readText())
            val cratesAfterMoves = cratesWithInstructions.executeInstructions9001()
            return cratesAfterMoves.state.fold(mutableListOf<Char>()) { acc, column ->
                acc.addAll(column.takeLast(1))
                acc
            }.joinToString(separator = "")
        }
    }
    
    data class CratesWithInstructions(private val input: String) {
        private val split = input.split("\n\n")
        private val crates = Crates(split[0])
        private val instructions = split[1].split("\n").map { Instruction(it) }
        
        fun executeInstructions9000(): Crates {
            instructions.forEach { 
                crates.executeInstruction9000(it)
            }
            return crates
        }
        
        fun executeInstructions9001(): Crates {
            instructions.forEach { 
                crates.executeInstruction9001(it)
            }
            return crates
        }
    }

    data class Crates(private val input: String) {
        private val columnCount: Int
        private val split = input.split("\n").reversed()
        private val _state: MutableList<MutableList<Char>>
        val state: List<List<Char>>
            get() = _state
        
        init {
            columnCount = split[0].trim().split("\\s+".toRegex()).last().toInt()
            _state = split.foldIndexed(mutableListOf()) { index, acc, string ->
                for (i in 0 until columnCount) {
                    if (index == 0) {
                        acc.add(mutableListOf())
                    } else {
                        val crate = string[4 * i + 1]
                        if (crate != ' ') {
                            acc[i].add(crate)
                        }
                    }
                }
                acc
            }
        }
        
        fun executeInstruction9000(instruction: Instruction) {
            for (i in 0 until instruction.numberToMove) {
                _state[instruction.toColumn].add(_state[instruction.fromColumn].removeLast())
            }
        }
        
        fun executeInstruction9001(instruction: Instruction) {
            val removeIndex = _state[instruction.fromColumn].size - instruction.numberToMove
            for (i in 0 until instruction.numberToMove) {
                _state[instruction.toColumn].add(_state[instruction.fromColumn].removeAt(removeIndex))
            }
        }
    }

    data class Instruction(private val input: String) {
        private val split = input.split("move ", " from ", " to ")
        val numberToMove = split[1].toInt()
        val fromColumn = split[2].toInt() - 1
        val toColumn = split[3].toInt() - 1
    }
}
