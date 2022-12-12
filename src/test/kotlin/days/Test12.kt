package days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Test12 {
    
    @Test
    fun problem1() {
        val day = Day12.Problem1()
        
        val result = day.solve()
        
        Assertions.assertEquals("31", result)
    }
    
    @Test
    fun problem2() {
        val day = Day12.Problem2()
        
        val result = day.solve()
        
        Assertions.assertEquals("29", result)
    }
}
