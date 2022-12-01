import days.DayOne

val problems: List<DayOfCode> = listOf(
    DayOne.ProblemOne(),
    DayOne.ProblemTwo()
)

fun main(args: Array<String>) {
    val results = problems.map { Runner.run(it) }
    results.forEach {
        println("Day: ${it.day}\nProblem: ${it.problem}")
        println("${it.answer}\nruntime: ${it.runtime} \n")
    }
}