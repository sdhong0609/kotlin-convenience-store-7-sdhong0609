package store.model

class Inventory(
    private var products: List<Product>
) {
    fun getProducts() = products

    fun minusQuantity(productName: String, quantity: Int) {
        products = products.map {
            if (it.name == productName) {
                Product(it.name, it.price, it.quantity - quantity, it.promotion)
            } else {
                it
            }
        }
    }
}