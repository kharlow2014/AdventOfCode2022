import days.*

val problems: List<DayOfCode> = listOf(
//    Day1.Problem1(),
//    Day1.Problem2(),
//    Day2.Problem1(),
//    Day2.Problem2(),
//    Day3.Problem1(),
//    Day3.Problem2(),
//    Day4.Problem1(),
//    Day4.Problem2(),
//    Day5.Problem1(),
//    Day5.Problem2(),
//    Day6.Problem1(),
//    Day6.Problem2(),
//    Day7.Problem1(),
//    Day7.Problem2(),
//    Day8.Problem1(),
//    Day8.Problem2(),
//    Day9.Problem1(),
//    Day9.Problem2(),
//    Day10.Problem1(),
//    Day10.Problem2(),
//    Day11.Problem1(),
//    Day11.Problem2(),
//    Day12.Problem1(),
//    Day12.Problem2(),
//    Day13.Problem1(),
//    Day13.Problem2(),
//    Day14.Problem1(),
    Day14.Problem2()
)

fun main(args: Array<String>) {
    val runClean = true
    if (runClean) runClean() else runDirty()
}

fun runClean() {
    problems.forEach { problem ->
        val result = Runner.run(problem)
        println("Day: ${result.day}")
        println("Problem: ${result.problem}")
        println("Answer: ${result.answer}")
        println("runtime: ${result.runtime}")
        println()
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
