package days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Test8 {
    
    @Test
    fun problem1() {
        val day = Day8.Problem1()
        
        val result = day.solve()
        
        Assertions.assertEquals("21", result)
    }
    
    @Test
    fun problem2() {
        val day = Day8.Problem2()
        
        val result = day.solve()
        
        Assertions.assertEquals("8", result)
    }
}
