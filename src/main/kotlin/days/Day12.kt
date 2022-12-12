package days

import DayOfCode
import java.util.ArrayDeque
import java.util.Queue

sealed class Day12(override val problem: Problem) : DayOfCode(day = Day.TWELVE, problem = problem) {

    override val dataFileName: String
        get() = "/12.data"
    
    class Problem1 : Day12(Problem.ONE) {
        override fun solve(): String {
            val maze = Maze(readLines())
            return maze.findFromSpecifiedStart().toString()
        }
    }
    
    class Problem2 : Day12(Problem.TWO) {
        override fun solve(): String {
            val maze = Maze(readLines())
            return maze.findShortestFromAny().toString()
        }
    }

    data class Maze(private val input: List<String>) {

        private val codeMap = input.map { line -> line.map { it.code }.toMutableList() }
        private val start = findAndReplace('S'.code, 'a'.code)
        private val end = findAndReplace('E'.code, 'z'.code)

        private fun findAndReplace(find: Int, replace: Int) : Pair<Int, Int> {
            codeMap.forEachIndexed { i, r ->
                r.forEachIndexed { j, item ->
                    if (item == find) {
                        codeMap[i][j] = replace
                        return Pair(i, j)
                    }
                }
            }
            return Pair(0, 0)
        }

        private fun isValid(visited: List<List<Boolean>>, fRow: Int, fCol: Int, tRow: Int, tCol: Int): Boolean {
            return (tRow >= 0) && (tRow < codeMap.size) && (tCol >= 0) && (tCol < codeMap[0].size) && (codeMap[tRow][tCol] - codeMap[fRow][fCol] <= 1) && !visited[tRow][tCol]
        }
        
        fun findFromSpecifiedStart(): Int {
            return findShortest(start.first, start.second)
        }
        
        fun findShortestFromAny(): Int {
            val routes = codeMap.flatMapIndexed { i, row ->
                row.mapIndexedNotNull { j, it -> 
                    if (it == 'a'.code) {
                        findShortest(i, j)
                    } else {
                        null
                    }
                }
            }
            return routes.minOf { it }
        }
        
        private fun findShortest(startRow: Int, startCol: Int): Int {
            var i = startRow
            var j = startCol
            
            val x = end.first
            val y = end.second
            
            val q: Queue<Node> = ArrayDeque()

            val visited = codeMap.map { row -> row.map { false }.toMutableList() }
            
            visited[i][j] = true
            q.add(Node(i, j, 0))
            var min = Int.MAX_VALUE
            while (!q.isEmpty()) {
                val node = q.poll()
                i = node.x
                j = node.y
                val dist = node.distance
                
                if (i == x && j == y) {
                    min = dist
                    break
                }
                
                for (k in 0 until 4) {
                    if (isValid(visited, i, j, i + row[k], j + col[k])) {
                        visited[i + row[k]][j + col[k]] = true
                        q.add(Node(i + row[k], j + col[k], dist + 1))
                    }
                }
            }
            
            return min
        }

        data class Node(val x: Int, val y: Int, val distance: Int)
        
        companion object {
            private val row = listOf(-1, 0, 0, 1)
            private val col = listOf(0, -1, 1, 0)
        }
    }
    
    data class BadMaze(private val input: List<String>) {
        private val codeMap = input.map { line -> line.map { it.code }.toMutableList() }
        private val start = find(83)
        private val end = find(69)
        
        init {
            codeMap.forEachIndexed { i, r ->
                r.forEachIndexed { j, it -> 
                    if (it == 83) {
                        codeMap[i][j] = 97
                    }
                    if (it == 69) {
                        codeMap[i][j] = 122
                    }
                }
            }
        }
        
        private fun find(code: Int) : Pair<Int, Int> {
            codeMap.forEachIndexed { i, r ->
                r.forEachIndexed { j, item ->
                    if (item == code) {
                        return Pair(i, j)
                    }
                }
            }
            return Pair(0, 0)
        }
        
        fun solve(): Int {
            return solve(listOf(), start)
        }
        
        private fun solve(path: List<Pair<Int, Int>>, next: Pair<Int, Int>) : Int {
            val min = listOf(left(path, next), right(path, next), up(path, next), down(path, next)).minOf { it }
            return if (min == Int.MAX_VALUE) {
                Int.MAX_VALUE
            } else {
                min
            }
        }
        
        private fun left(path: List<Pair<Int, Int>>, next: Pair<Int, Int>): Int {
            var left = Int.MAX_VALUE
            if (!path.contains(next.left()) && next.left().second >= 0) {
                if (codeMap[next.left().first][next.left().second] - codeMap[next.first][next.second] <= 1) {
                    if (next.left() == end) {
                        return path.size + 1
                    }
                    left = solve(path + next, next.left())
                }
            }
            return left
        }
        
        private fun right(path: List<Pair<Int, Int>>, next: Pair<Int, Int>): Int {
            var right = Int.MAX_VALUE
            if (!path.contains(next.right()) && next.right().second < codeMap[0].size) {
                if (codeMap[next.right().first][next.right().second] - codeMap[next.first][next.second] <= 1) {
                    if (next.right() == end) {
                        return path.size + 1
                    }
                    right = solve(path + next, next.right())
                }
            }
            return right
        }
        
        private fun up(path: List<Pair<Int, Int>>, next: Pair<Int, Int>): Int {
            var up = Int.MAX_VALUE
            if (!path.contains(next.up()) && next.up().first >= 0) {
                if (codeMap[next.up().first][next.up().second] - codeMap[next.first][next.second] <= 1) {
                    if (next.up() == end) {
                        return path.size + 1
                    }
                    up = solve(path + next, next.up())
                }
            }
            return up
        }
        
        private fun down(path: List<Pair<Int, Int>>, next: Pair<Int, Int>): Int {
            var down = Int.MAX_VALUE
            if (!path.contains(next.down()) && next.down().first < codeMap.size) {
                if (codeMap[next.down().first][next.down().second] - codeMap[next.first][next.second] <= 1) {
                    if (next.down() == end) {
                        return path.size + 1
                    }
                    down = solve(path + next, next.down())
                }
            }
            return down
        }
        
        private fun Pair<Int, Int>.left() = Pair(this.first, this.second - 1)
        private fun Pair<Int, Int>.right() = Pair(this.first, this.second + 1)
        private fun Pair<Int, Int>.up() = Pair(this.first - 1, this.second)
        private fun Pair<Int, Int>.down() = Pair(this.first + 1, this.second)
    }
}
