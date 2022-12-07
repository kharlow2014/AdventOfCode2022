package days

import DirtySolutions
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Test6 {
    
    @Test
    fun problem1test1() {
        val day = Day6.Problem1("mjqjpqmgbljsphdztnvjfqwrcgsmlb")
        
        val result = day.solve()
        
        Assertions.assertEquals("7", result)
    }
    
    @Test
    fun problem1test2() {
        val day = Day6.Problem1("bvwbjplbgvbhsrlpgdmjqwftvncz")

        val result = day.solve()

        Assertions.assertEquals("5", result)
    }

    @Test
    fun problem1test3() {
        val day = Day6.Problem1("nppdvjthqldpwncqszvftbrmjlhg")

        val result = day.solve()

        Assertions.assertEquals("6", result)
    }

    @Test
    fun problem1test4() {
        val day = Day6.Problem1("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg")

        val result = day.solve()

        Assertions.assertEquals("10", result)
    }

    @Test
    fun problem1test5() {
        val day = Day6.Problem1("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")

        val result = day.solve()

        Assertions.assertEquals("11", result)
    }
    
    @Test
    fun problem2Test1() {
        val day = Day6.Problem2("mjqjpqmgbljsphdztnvjfqwrcgsmlb")
        
        val result = day.solve()
        
        Assertions.assertEquals("19", result)
    }

    @Test
    fun problem2Test2() {
        val day = Day6.Problem2("bvwbjplbgvbhsrlpgdmjqwftvncz")

        val result = day.solve()

        Assertions.assertEquals("23", result)
    }

    @Test
    fun problem2Test3() {
        val day = Day6.Problem2("nppdvjthqldpwncqszvftbrmjlhg")

        val result = day.solve()

        Assertions.assertEquals("23", result)
    }

    @Test
    fun problem2Test4() {
        val day = Day6.Problem2("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg")

        val result = day.solve()

        Assertions.assertEquals("29", result)
    }

    @Test
    fun problem2Test5() {
        val day = Day6.Problem2("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")

        val result = day.solve()

        Assertions.assertEquals("26", result)
    }
    
    @Test
    fun dirtyTest() {
        DirtySolutions.day6()
        
        Assertions.assertEquals("0", "0")
    }
}
