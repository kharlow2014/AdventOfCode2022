package days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Test2 {

    @Test
    fun testOne() {
        val day = Day2.Problem1()

        val result = day.solve()

        Assertions.assertEquals("15", result)
    }

    @Test
    fun testTwo() {
        val day = Day2.Problem2()

        val result = day.solve()

        Assertions.assertEquals("12", result)
    }
}
