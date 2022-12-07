package days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Test7 {

    @Test
    fun problem1() {
        val day = Day7.Problem1()

        val result = day.solve()

        Assertions.assertEquals("95437", result)
    }

    @Test
    fun problem2() {
        val day = Day7.Problem2()

        val result = day.solve()

        Assertions.assertEquals("24933642", result)
    }
}
