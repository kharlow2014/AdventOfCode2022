
object DirtySolutions {
    fun dayOne() {
        readText("/one.data").split("\n\n").map { it.split("\n").sumOf { s -> s.toInt() } }.sortedDescending().run { println("${this[0]} ${this.take(3).sum()}") }
    }

    fun dayTwo() {
        val map = mapOf("A X" to Pair(4, 3), "A Y" to Pair(8, 4), "A Z" to Pair(3, 8), "B X" to Pair(1, 1), "B Y" to Pair(5, 5), "B Z" to Pair(9, 9), "C X" to Pair(7, 2), "C Y" to Pair(2, 6), "C Z" to Pair(6, 7))
        readLines("/two.data").map { map[it]!!.first to map[it]!!.second }.run { println("${this.sumOf { it.first }} ${this.sumOf { it.second }}") }
    }

    private fun readLines(fileName: String): List<String> = this::class.java.getResourceAsStream(fileName).bufferedReader().readLines()
    private fun readText(fileName: String): String = this::class.java.getResourceAsStream(fileName).bufferedReader().readText()
}
