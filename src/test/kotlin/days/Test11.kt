package days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Test11 {

    @Test
    fun problem1() {
        val day = Day11.Problem1()

        val result = day.solve()

        Assertions.assertEquals("10605", result)
    }
    
    @Test
    fun problem2() {
        val day = Day11.Problem2()
        
        val result = day.solve()
        
        Assertions.assertEquals("2713310158", result)
    }
}