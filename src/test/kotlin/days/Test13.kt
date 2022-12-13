package days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Test13 {
    
    @Test
    fun problem1() {
        val day = Day13.Problem1()
        
        val result = day.solve()
        
        Assertions.assertEquals("13", result)
    }
    
    @Test
    fun problem2() {
        val day = Day13.Problem2()
        
        val result = day.solve()
        
        Assertions.assertEquals("140", result)
    }
}
