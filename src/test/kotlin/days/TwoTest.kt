package days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TwoTest {

    @Test
    fun testOne() {
        val day = DayTwo.ProblemOne()

        val result = day.solve()

        Assertions.assertEquals("15", result)
    }

    @Test
    fun testTwo() {
        val day = DayTwo.ProblemTwo()

        val result = day.solve()

        Assertions.assertEquals("12", result)
    }
}
