package store

class Product(
    private val name: String,
    private val price: Int,
    private val quantity: Int,
    private val promotion: Promotion?
) {
    fun getName() = name
    fun getPrice() = price
    fun getQuantity() = quantity
    fun getPromotion() = promotion
}