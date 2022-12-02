import days.DayOne
import days.DayTwo

val problems: List<DayOfCode> = listOf(
    DayOne.ProblemOne(),
    DayOne.ProblemTwo(),
    DayTwo.ProblemOne(),
    DayTwo.ProblemTwo()
)

fun main(args: Array<String>) {
    val runClean = false
    if (runClean) runClean() else runDirty()
}

fun runClean() {
    val results = problems.map { Runner.run(it) }
    results.forEach {
        println("Day: ${it.day}\nProblem: ${it.problem}")
        println("${it.answer}\nruntime: ${it.runtime} \n")
    }
}

fun runDirty() {
    DirtySolutions.dayOne()
    DirtySolutions.dayTwo()
}
