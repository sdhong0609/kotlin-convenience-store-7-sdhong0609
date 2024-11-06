package store

class Promotion(
    private val name: String,
    private val buy: Int,
    private val get: Int,
    private val startDate: String,
    private val endDate: String
) {
    fun getName() = name
    fun getBuy() = buy
    fun getGet() = get
    fun getStartDate() = startDate
    fun getEndDate() = endDate
}