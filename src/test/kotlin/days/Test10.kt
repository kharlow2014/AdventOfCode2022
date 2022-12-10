package days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Test10 {

    @Test
    fun problem1() {
        val day = Day10.Problem1()

        val result = day.solve()

        Assertions.assertEquals("13140", result)
    }

    @Test
    fun problem2() {
        val day = Day10.Problem2()

        val result = day.solve()

        Assertions.assertEquals("##..##..##..##..##..##..##..##..##..##..\n" +
                "###...###...###...###...###...###...###.\n" +
                "####....####....####....####....####....\n" +
                "#####.....#####.....#####.....#####.....\n" +
                "######......######......######......####\n" +
                "#######.......#######.......#######.....\n", result)
    }
}
