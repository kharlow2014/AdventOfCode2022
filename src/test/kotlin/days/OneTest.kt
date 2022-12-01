package days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class OneTest {
    @Test
    fun testOne() {
        val day = DayOne.ProblemOne()

        val result = day.solve()

        Assertions.assertEquals("24000", result)
    }

    @Test
    fun testTwo() {
        val day = DayOne.ProblemTwo()

        val result = day.solve()

        Assertions.assertEquals("45000", result)
    }
}
