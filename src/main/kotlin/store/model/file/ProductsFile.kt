package store.model.file

import store.model.Product
import store.model.Promotion
import java.io.File

class ProductsFile(
    private val promotions: List<Promotion>
) {

    private fun readFile(): List<String> {
        return File("src/main/resources/products.md").readLines().drop(1)
    }

    private fun updatedRawProducts(): List<String> {
        val products = readFile().map { it.split(",") }
        val updatedProducts = mutableListOf<List<String>>()

        products.indices.forEach { i ->
            updatedProducts.add(products[i])
            if (products[i][3] != "null") {
                if (i == products.lastIndex || products[i][0] != products[i + 1][0]) {
                    updatedProducts.add(listOf(products[i][0], products[i][1], "0", "null"))
                }
            }
        }
        return updatedProducts.map { it.joinToString(",") }
    }

    fun mapToProducts(): List<Product> {
        val rawProducts = updatedRawProducts()
        return rawProducts.map { rawProduct ->
            val product = rawProduct.split(",")
            val (name, price, quantity, promotionName) = product
            val promotion = promotions.find { it.name == promotionName }

            Product(name, price.toInt(), quantity.toInt(), promotion)
        }
    }
}