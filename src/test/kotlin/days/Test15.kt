package days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Test15 {
    
    @Test
    fun problem1() {
        val day = Day15.Problem1(10)
        
        val result = day.solve()
        
        Assertions.assertEquals("26", result)
    }
    
    @Test
    fun problem2() {
        val day = Day15.Problem2(min = 0, max = 20)
        
        val result = day.solve()
        
        Assertions.assertEquals("56000011", result)
    }
}