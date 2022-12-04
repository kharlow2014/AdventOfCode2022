package days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Test3 {

    @Test
    fun test1() {
        val day = Day3.Problem1()

        val result = day.solve()

        Assertions.assertEquals("157", result)
    }

    @Test

    fun test2() {
        val day = Day3.Problem2()

        val result = day.solve()

        Assertions.assertEquals("70", result)
    }
}
