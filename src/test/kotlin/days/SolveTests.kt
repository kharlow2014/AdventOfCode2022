package days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SolveTests {
    @Test
    fun oneOne() {
        val day = Day1.Problem1()

        val result = day.solve()

        Assertions.assertEquals(24000, result)
    }

    @Test
    fun oneTwo() {
        val day = Day1.Problem2()

        val result = day.solve()

        Assertions.assertEquals(45000, result)
    }
    
    @Test
    fun twoOne() {
        val day = Day2.Problem1()

        val result = day.solve()

        Assertions.assertEquals(15, result)
    }

    @Test
    fun twoTwo() {
        val day = Day2.Problem2()

        val result = day.solve()

        Assertions.assertEquals(12, result)
    }

    @Test
    fun threeOne() {
        val day = Day3.Problem1()

        val result = day.solve()

        Assertions.assertEquals(157, result)
    }

    @Test
    fun threeTwo() {
        val day = Day3.Problem2()

        val result = day.solve()

        Assertions.assertEquals(70, result)
    }
    
    @Test
    fun fourOne() {
        val day = Day4.Problem1()

        val result = day.solve()

        Assertions.assertEquals(2, result)
    }

    @Test
    fun fourTwo() {
        val day = Day4.Problem2()

        val result = day.solve()

        Assertions.assertEquals(4, result)
    }
    
    @Test
    fun fiveOne() {
        val day = Day5.Problem1()

        val result = day.solve()

        Assertions.assertEquals("CMZ", result)
    }

    @Test
    fun fiveTwo() {
        val day = Day5.Problem2()

        val result = day.solve()

        Assertions.assertEquals("MCD", result)
    }

    @Test
    fun sixOneOne() {
        val day = Day6.Problem1("mjqjpqmgbljsphdztnvjfqwrcgsmlb")

        val result = day.solve()

        Assertions.assertEquals(7, result)
    }

    @Test
    fun sixOneTwo() {
        val day = Day6.Problem1("bvwbjplbgvbhsrlpgdmjqwftvncz")

        val result = day.solve()

        Assertions.assertEquals(5, result)
    }

    @Test
    fun sixOneThree() {
        val day = Day6.Problem1("nppdvjthqldpwncqszvftbrmjlhg")

        val result = day.solve()

        Assertions.assertEquals(6, result)
    }

    @Test
    fun sixOneFour() {
        val day = Day6.Problem1("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg")

        val result = day.solve()

        Assertions.assertEquals(10, result)
    }

    @Test
    fun sixOneFive() {
        val day = Day6.Problem1("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")

        val result = day.solve()

        Assertions.assertEquals(11, result)
    }

    @Test
    fun sixTwoOne() {
        val day = Day6.Problem2("mjqjpqmgbljsphdztnvjfqwrcgsmlb")

        val result = day.solve()

        Assertions.assertEquals(19, result)
    }

    @Test
    fun sixTwoTwo() {
        val day = Day6.Problem2("bvwbjplbgvbhsrlpgdmjqwftvncz")

        val result = day.solve()

        Assertions.assertEquals(23, result)
    }

    @Test
    fun sixTwoThree() {
        val day = Day6.Problem2("nppdvjthqldpwncqszvftbrmjlhg")

        val result = day.solve()

        Assertions.assertEquals(23, result)
    }

    @Test
    fun sixTwoFour() {
        val day = Day6.Problem2("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg")

        val result = day.solve()

        Assertions.assertEquals(29, result)
    }

    @Test
    fun sixTwoFive() {
        val day = Day6.Problem2("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")

        val result = day.solve()

        Assertions.assertEquals(26, result)
    }

    @Test
    fun sevenOne() {
        val day = Day7.Problem1()

        val result = day.solve()

        Assertions.assertEquals(95437, result)
    }

    @Test
    fun sevenTwo() {
        val day = Day7.Problem2()

        val result = day.solve()

        Assertions.assertEquals(24933642, result)
    }

    @Test
    fun eightOne() {
        val day = Day8.Problem1()

        val result = day.solve()

        Assertions.assertEquals(21, result)
    }

    @Test
    fun eightTwo() {
        val day = Day8.Problem2()

        val result = day.solve()

        Assertions.assertEquals(8, result)
    }

    @Test
    fun nineOne() {
        val day = Day9.Problem1()

        val result = day.solve()

        Assertions.assertEquals(88, result)
    }

    @Test
    fun nineTwo() {
        val day = Day9.Problem2()

        val result = day.solve()

        Assertions.assertEquals(36, result)
    }

    @Test
    fun tenOne() {
        val day = Day10.Problem1()

        val result = day.solve()

        Assertions.assertEquals(13140, result)
    }

    @Test
    fun tenTwo() {
        val day = Day10.Problem2()

        val result = day.solve()

        Assertions.assertEquals(
            "##..##..##..##..##..##..##..##..##..##..\n" +
                    "###...###...###...###...###...###...###.\n" +
                    "####....####....####....####....####....\n" +
                    "#####.....#####.....#####.....#####.....\n" +
                    "######......######......######......####\n" +
                    "#######.......#######.......#######.....\n", result
        )
    }

    @Test
    fun elevenOne() {
        val day = Day11.Problem1()

        val result = day.solve()

        Assertions.assertEquals(10605L, result)
    }

    @Test
    fun elevenTwo() {
        val day = Day11.Problem2()

        val result = day.solve()

        Assertions.assertEquals(2713310158L, result)
    }

    @Test
    fun twelveOne() {
        val day = Day12.Problem1()

        val result = day.solve()

        Assertions.assertEquals(31, result)
    }

    @Test
    fun twelveTwo() {
        val day = Day12.Problem2()

        val result = day.solve()

        Assertions.assertEquals(29, result)
    }

    @Test
    fun thirteenOne() {
        val day = Day13.Problem1()

        val result = day.solve()

        Assertions.assertEquals(13, result)
    }

    @Test
    fun thirteenTwo() {
        val day = Day13.Problem2()

        val result = day.solve()

        Assertions.assertEquals(140, result)
    }

    @Test
    fun fourteenOne() {
        val day = Day14.Problem1()

        val result = day.solve()

        Assertions.assertEquals(24, result)
    }

    @Test
    fun fourteenTwo() {
        val day = Day14.Problem2()

        val result = day.solve()

        Assertions.assertEquals(93, result)
    }

    @Test
    fun fifteenOne() {
        val day = Day15.Problem1(10)

        val result = day.solve()

        Assertions.assertEquals(26, result)
    }

    @Test
    fun fifteenTwo() {
        val day = Day15.Problem2(min = 0, max = 20)

        val result = day.solve()

        Assertions.assertEquals(56000011L, result)
    }
    
    @Test
    fun sixteenOne() {
        val day = Day16.Problem1()
        
        val result = day.solve()
        
        Assertions.assertEquals(1651, result)
    }
    
    @Test
    fun sixteenTwo() {
        val day = Day16.Problem2()
        
        val result = day.solve()
        
        Assertions.assertEquals(1707, result)
    }
}