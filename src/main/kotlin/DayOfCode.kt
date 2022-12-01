abstract class DayOfCode(val day: Day, open val problem: Problem) {

    abstract val dataFileName: String
    abstract fun solve(): String

    enum class Day {
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        ELEVEN,
        TWELVE,
        THIRTEEN,
        FOURTEEN,
        FIFTEEN,
        SIXTEEN,
        SEVENTEEN,
        EIGHTEEN,
        NINETEEN,
        TWENTY,
        TWENTY_ONE,
        TWENTY_TWO,
        TWENTY_THREE,
        TWENTY_FOUR,
        TWENTY_FIVE
    }

    enum class Problem {
        ONE, TWO
    }
}
