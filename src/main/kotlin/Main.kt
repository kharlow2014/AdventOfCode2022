import days.Day1
import days.Day2
import days.Day3
import days.Day4

val problems: List<DayOfCode> = listOf(
    Day1.Problem1(),
    Day1.Problem2(),
    Day2.Problem1(),
    Day2.Problem2(),
    Day3.Problem1(),
    Day3.Problem2(),
    Day4.Problem1(),
    Day4.Problem2()
)

fun main(args: Array<String>) {
    val runClean = false
    if (runClean) runClean() else runDirty()
}

fun runClean() {
    val results = problems.map { Runner.run(it) }
    results.forEach {
        println("Day: ${it.day}\nProblem: ${it.problem}")
        println("Answer: ${it.answer}\nruntime: ${it.runtime} \n")
    }
}

fun runDirty() {
    DirtySolutions.day1()
    DirtySolutions.day2()
    DirtySolutions.day3()
    DirtySolutions.day4()
}
