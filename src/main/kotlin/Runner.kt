object Runner {

    fun run(dayOfCode: DayOfCode): Solution {
        Stopwatch.start()
        val result = dayOfCode.solve()
        Stopwatch.stop()
        return Solution(
            day = dayOfCode.day,
            problem = dayOfCode.problem,
            answer = result,
            runtime = Stopwatch.read()
        )
    }
}
