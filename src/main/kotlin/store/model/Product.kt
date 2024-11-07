package store.model

class Product(
    val name: String,
    val price: Int,
    val quantity: Int,
    val promotion: Promotion?
) {
    fun hasQuantity() = quantity > 0
    fun isPromotionAvailable() = promotion != null
}