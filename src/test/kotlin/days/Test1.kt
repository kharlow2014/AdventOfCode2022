package days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Test1 {
    @Test
    fun testOne() {
        val day = Day1.Problem1()

        val result = day.solve()

        Assertions.assertEquals("24000", result)
    }

    @Test
    fun testTwo() {
        val day = Day1.Problem2()

        val result = day.solve()

        Assertions.assertEquals("45000", result)
    }
}
