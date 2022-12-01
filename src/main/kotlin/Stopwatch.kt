object Stopwatch {

    private var isStopped = true
    private var startTime: Long? = null
    private var endTime: Long? = null

    fun start() {
        isStopped = false
        startTime = System.currentTimeMillis()
    }

    fun stop() {
        endTime = System.currentTimeMillis()
        isStopped = true
    }

    fun read(): Long {
        val start = startTime
        val end = if (isStopped) endTime else null
        return when {
            start != null && end != null -> end - start
            start != null -> System.currentTimeMillis() - start
            else -> 0L
        }
    }
}
