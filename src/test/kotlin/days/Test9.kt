package days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Test9 {

    @Test
    fun problem1() {
        val day = Day9.Problem1()

        val result = day.solve()

        Assertions.assertEquals("88", result)
    }

    @Test
    fun problem2() {
        val day = Day9.Problem2()

        val result = day.solve()

        Assertions.assertEquals("36", result)
    }
}
