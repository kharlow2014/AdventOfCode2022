
object DirtySolutions {
    fun day1() {
        readText("/1.data").split("\n\n").map { it.split("\n").sumOf { s -> s.toInt() } }.sortedDescending().run { println("${this[0]} ${this.take(3).sum()}") }
    }

    fun day2() {
        val map = mapOf("A X" to (4 to 3), "A Y" to (8 to 4), "A Z" to (3 to 8), "B X" to (1 to 1), "B Y" to (5 to 5), "B Z" to (9 to 9), "C X" to (7 to 2), "C Y" to (2 to 6), "C Z" to (6 to 7))
        readLines("/2.data").map { map[it]!! }.run { println("${this.sumOf { it.first }} ${this.sumOf { it.second }}") }
    }

    fun day3() {
        print(readLines("/3.data").sumOf { items -> items.toList().let { chars -> chars.subList(0, (chars.size + 1) / 2).intersect(chars.subList((chars.size + 1) / 2, chars.size).toSet()) }.first().let { char -> if (char.isUpperCase()) char.code - 38 else char.code - 96 } }.toString())
        println(readLines("/3.data").chunked(3) { chunks -> chunks.map { it.toSet() } }.sumOf { chunk -> ((chunk[0] intersect chunk[1]) intersect chunk[2]).first().let { char -> if (char.isUpperCase()) char.code - 38 else char.code - 96 } }.toString())
    }

    fun day4() {
        readLines("/4.data").flatMap { line -> line.split(",", "-").map { it.toInt() } }.chunked(4) { Pair((it[0] >= it[2] && it[1] <= it[3]) || (it[0] <= it[2] && it[1] >= it[3]), (it[1] >= it[2] && it[0] <= it[3]) || (it[1] <= it[2] && it[0] >= it[3])) }.run { println("${this.sumOf { if (it.first) 1L else 0 }} ${this.sumOf { if (it.second) 1L else 0 }}") }
    }
    
    fun day5() {
        val input = readText("/5.data")
        println()
    }
    
    fun day6() {
        val solve: (Int) -> Int = { l -> readText("/6.data").windowed(l).foldIndexed(0) { i, a, c -> if (c.toSet().size == l && a == 0) i + l else a } }
        println("${solve(4)} ${solve(14)}")
    }

    private fun readLines(fileName: String): List<String> = this::class.java.getResourceAsStream(fileName).bufferedReader().readLines()
    private fun readText(fileName: String): String = this::class.java.getResourceAsStream(fileName).bufferedReader().readText()
}
