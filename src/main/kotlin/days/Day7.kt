package days

import DayOfCode

sealed class Day7(override val problem: Problem) : DayOfCode(Day.SEVEN, problem) {

    override val dataFileName: String
        get() = "/7.data"

    class Problem1 : Day7(Problem.ONE) {
        override fun solve(): Long {
            return readLines().fold(Structure.Directory("/")) { acc, s ->
                val split = s.split(" ")
                when {
                    s == "$ ls" -> acc
                    s == "$ cd .." -> acc.up()!!
                    s == "$ cd /" -> acc.home()
                    split[1] == "cd" -> acc.navigateTo(split[2])
                    split[0] == "dir" -> acc.add(Structure.Directory(split[1], acc))
                    else -> acc.add(Structure.File(split[1], split[0].toLong()))
                }
            }.home().getStructuresWithSizes().sumOf { if (it.second < 100000) it.second else 0L }
        }
    }

    class Problem2 : Day7(Problem.TWO) {
        override fun solve(): Long {
            val data = readLines().fold(Structure.Directory("/")) { acc, s ->
                val split = s.split(" ")
                when {
                    s == "$ ls" -> acc
                    s == "$ cd .." -> acc.up()!!
                    s == "$ cd /" -> acc.home()
                    split[1] == "cd" -> acc.navigateTo(split[2])
                    split[0] == "dir" -> acc.add(Structure.Directory(split[1], acc))
                    else -> acc.add(Structure.File(split[1], split[0].toLong()))
                }
            }.home()
            return data.getStructuresWithSizes().sortedBy { it.second }.first { data.size - it.second < 40000000 }.second
        }
    }

    sealed class Structure {

        abstract val title: String
        abstract val size: Long

        data class Directory(override val title: String, private val parent: Directory? = null) : Structure() {

            private val _structures: MutableList<Structure> = mutableListOf()
            override val size: Long
                get() = _structures.sumOf { it.size }

            fun add(structure: Structure): Directory {
                _structures.add(structure)
                return this
            }

            fun up(): Directory? {
                return parent
            }

            fun home(): Directory {
                var home = this
                while (home.up() != null) {
                    home = home.up()!!
                }
                return home
            }

            fun navigateTo(title: String): Directory {
                return _structures.first { it.title == title } as Directory
            }

            fun getStructuresWithSizes(): List<Pair<String, Long>> {
                return _structures.fold(mutableListOf(Pair(this.title, this.size))) { acc, structure ->
                    if (structure is Directory) acc.addAll(structure.getStructuresWithSizes())
                    acc
                }
            }
        }

        data class File(override val title: String, override val size: Long) : Structure()
    }
}
