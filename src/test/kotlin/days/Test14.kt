package days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Test14 {

    @Test
    fun problem1() {
        val day = Day14.Problem1()

        val result = day.solve()

        Assertions.assertEquals("24", result)
    }

    @Test
    fun problem2() {
        val day = Day14.Problem2()

        val result = day.solve()

        Assertions.assertEquals("93", result)
    }
}
