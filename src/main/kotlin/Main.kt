import days.*

val problems: List<DayOfCode> = listOf(
    Day1.Problem1(),
    Day1.Problem2(),
    Day2.Problem1(),
    Day2.Problem2(),
    Day3.Problem1(),
    Day3.Problem2(),
    Day4.Problem1(),
    Day4.Problem2(),
    Day5.Problem1(),
    Day5.Problem2(),
    Day6.Problem1(),
    Day6.Problem2(),
    Day7.Problem1(),
    Day7.Problem2(),
    Day8.Problem1(),
    Day8.Problem2(),
    Day9.Problem1(),
    Day9.Problem2(),
    Day10.Problem1(),
    Day10.Problem2(),
    Day11.Problem1()
)

fun main(args: Array<String>) {
    val runClean = true
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
    DirtySolutions.day5()
    DirtySolutions.day6()
}
