package days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Test4 {

    @Test
    fun problem1() {
        val day = Day4.Problem1()

        val result = day.solve()

        Assertions.assertEquals("2", result)
    }

    @Test
    fun problem2() {
        val day = Day4.Problem2()

        val result = day.solve()

        Assertions.assertEquals("4", result)
    }
}
