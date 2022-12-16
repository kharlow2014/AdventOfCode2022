package days

import DayOfCode

sealed class Day2(override val problem: Problem) : DayOfCode(day = Day.TWO, problem = problem) {

    override val dataFileName: String
        get() = "/2.data"

    class Problem1 : Day2(Problem.ONE) {
        override fun solve(): Int =
            readLines().map {
                getPlayForInput(it[0]) to getPlayForInput(it[2])
            }.sumOf { it.second.scoreWhenPlayedAgainst(it.first) }
    }

    class Problem2 : Day2(Problem.TWO) {
        override fun solve(): Int =
            readLines().map {
                val opponentsChoice = getPlayForInput(it[0])
                opponentsChoice to opponentsChoice.responseForOutcome(it[2])
            }.sumOf { it.second.scoreWhenPlayedAgainst(it.first) }
    }

    protected fun getPlayForInput(input: Char): RockPaperScissors = when (input) {
        'A', 'X' -> RockPaperScissors.Rock()
        'B', 'Y' -> RockPaperScissors.Paper()
        'C', 'Z' -> RockPaperScissors.Scissors()
        else -> throw UnsupportedOperationException("Unsupported input: $input")
    }

    protected sealed class RockPaperScissors(open val points: Int) {

        abstract fun scoreWhenPlayedAgainst(opponentsChoice: RockPaperScissors): Int
        abstract fun responseForOutcome(outcome: Char): RockPaperScissors

        open class Rock : RockPaperScissors(1) {
            override fun scoreWhenPlayedAgainst(opponentsChoice: RockPaperScissors): Int = when (opponentsChoice) {
                is Rock -> TIE + points
                is Paper -> LOSS + points
                is Scissors -> WIN + points
            }

            override fun responseForOutcome(outcome: Char) = when (outcome) {
                'X' -> Scissors()
                'Y' -> Rock()
                'Z' -> Paper()
                else -> throw UnsupportedOperationException("Unsupported outcome: $outcome")
            }
        }

        open class Paper : RockPaperScissors(2) {
            override fun scoreWhenPlayedAgainst(opponentsChoice: RockPaperScissors): Int = when (opponentsChoice) {
                is Rock -> WIN + points
                is Paper -> TIE + points
                is Scissors -> LOSS + points
            }

            override fun responseForOutcome(outcome: Char) = when (outcome) {
                'X' -> Rock()
                'Y' -> Paper()
                'Z' -> Scissors()
                else -> throw UnsupportedOperationException()
            }
        }

        open class Scissors : RockPaperScissors(3) {
            override fun scoreWhenPlayedAgainst(opponentsChoice: RockPaperScissors): Int = when (opponentsChoice) {
                is Rock -> LOSS + points
                is Paper -> WIN + points
                is Scissors -> TIE + points
            }

            override fun responseForOutcome(outcome: Char) = when (outcome) {
                'X' -> Paper()
                'Y' -> Scissors()
                'Z' -> Rock()
                else -> throw UnsupportedOperationException()
            }
        }

        companion object {
            const val LOSS = 0
            const val TIE = 3
            const val WIN = 6
        }
    }
}
