package days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Test5 {

    @Test
    fun problem1() {
        val day = Day5.Problem1()

        val result = day.solve()

        Assertions.assertEquals("CMZ", result)
    }

    @Test
    fun problem2() {
        val day = Day5.Problem2()

        val result = day.solve()

        Assertions.assertEquals("MCD", result)
    }
}
