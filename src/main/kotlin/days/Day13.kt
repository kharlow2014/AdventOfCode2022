package days

import DayOfCode
import kotlin.math.min

sealed class Day13(override val problem: Problem) : DayOfCode(day = Day.THIRTEEN, problem = problem) {

    override val dataFileName: String
        get() = "/13.data"
    
    class Problem1 : Day13(Problem.ONE) {
        override fun solve(): Int {
            var result = 0
            val pairs = readText().split("\n\n").map { 
                val split = it.split("\n")
                Pair(PacketData.fromString(split[0]), PacketData.fromString(split[1]))
            }
            pairs.forEachIndexed { index, pair -> if (pair.first < pair.second) result += index + 1 }
            return result
        }
    }

    class Problem2 : Day13(Problem.TWO) {
        override fun solve(): Int {
            val div1 = PacketData.fromString("[[2]]")
            val div2 = PacketData.fromString("[[6]]")
            val data = (readText().split("\n\n", "\n").map { PacketData.fromString(it) } + listOf(div1, div2)).sorted()
            return ((data.indexOf(div1) + 1) * (data.indexOf(div2) + 1))
        }
    }
    
    sealed class PacketData : Comparable<PacketData> {
        
        data class PacketInt(val d: Int) : PacketData() {
            companion object {
                @JvmStatic
                fun fromString(input: String): PacketInt = PacketInt(input.toInt())
            }
        }
        
        data class PacketList(val d: List<PacketData>) : PacketData() {
            companion object {
                @JvmStatic
                fun fromString(input: String): PacketList {
                    if (input[0] == '[' && input[1] == ']') return PacketList(listOf())
                    val d = splitString(input)
                    return PacketList(d.map { if (it[0] == '[') fromString(it) else PacketInt.fromString(it) })
                }
                
                private fun splitString(input: String): List<String> {
                    val ss = input.substring(1, input.length - 1)
                    val result = mutableListOf<String>()
                    var s = 0
                    var e = ss.length - 1
                    while (s < ss.length) {
                        if (ss[s] == '[') {
                            var bCount = 0
                            for (i in s..ss.length) {
                                if (ss[i] == '[') bCount++
                                if (ss[i] == ']') bCount--
                                if (bCount == 0) {
                                    e = i + 1
                                    break
                                }
                            }
                        } else {
                            for (i in s..ss.length)
                                if (i == ss.length || ss[i] == ',') {
                                    e = i
                                    break
                                }
                        }
                        result.add(ss.substring(s, e))
                        s = e + 1
                    }
                    return result
                }
            }
        }

        override fun compareTo(other: PacketData): Int {
            when {
                this is PacketInt && other is PacketInt -> return if (this.d < other.d) -1 else if (this.d == other.d) 0 else 1
                this is PacketList && other is PacketList -> {
                    for (i in 0 until min(this.d.size, other.d.size)) {
                        if (this.d[i] < other.d[i]) return -1
                        if (this.d[i] > other.d[i]) return 1
                    }
                    return if (this.d.size < other.d.size) -1 else if (this.d.size == other.d.size) 0 else 1
                }
                this is PacketInt && other is PacketList -> return PacketList(listOf(this)).compareTo(other)
                this is PacketList && other is PacketInt -> return this.compareTo(PacketList(listOf(other)))
                else -> throw UnsupportedOperationException("Types could not be compared")
            }
        }
        
        companion object {
            @JvmStatic
            fun fromString(input: String): PacketData = PacketList.fromString(input)
        }
    }
}
