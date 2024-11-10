package store

import store.model.Inventory
import store.model.Product
import store.model.SelectedProduct
import store.model.file.ProductsFile
import store.model.file.PromotionsFile
import store.view.InputView
import store.view.OutputView

class ConvenienceStoreController(
    private val outputView: OutputView,
    private val inputView: InputView,
    private val promotionsFile: PromotionsFile
) {

    fun run() {
        outputView.printGreetings()
        outputView.printProductsInstructions()

        val promotions = promotionsFile.mapToPromotions()

        val productsFile = ProductsFile(promotions)
        val inventory = Inventory(productsFile.mapToProducts())
        var products = inventory.getProducts()
        outputView.printProducts(products)

        outputView.printBuyInstructions()
        val selectedProducts = requestSelectedProducts()

        var membershipDiscount: Int = 0

        selectedProducts.forEach { selectedProduct ->
            val (selectedName, selectedQuantity) = selectedProduct
            if (products.find { product -> product.name == selectedName } == null) {
                throw IllegalArgumentException("[ERROR] 존재하지 않는 상품입니다. 다시 입력해 주세요.")
            }

            val promotionProduct = products.find { product ->
                product.name == selectedName && product.hasPromotion()
            }
            val normalProduct = products.find { product ->
                product.name == selectedName && !product.hasPromotion()
            }

            val hasPromotionProduct = promotionProduct != null

            if (promotionProduct != null) { // 프로모션 제품이 목록에 존재한다면
                // 프로모션 기간 중이라면
                // 프로모션 기간 중이 아니라면
            } else { // 프로모션 제품이 목록에 존재하지 않는다면
                // 일반 재고만으로 계산
                if (normalProduct != null) {
                    if (selectedQuantity > normalProduct.quantity) {
                        throw IllegalArgumentException("[ERROR] 재고 수량을 초과하여 구매할 수 없습니다. 다시 입력해 주세요.")
                    } else {
                        val yesOrNo = inputView.readYesOrNo().trim()
                        if (yesOrNo != "Y" && yesOrNo != "N") {
                            throw IllegalArgumentException("[ERROR] Y 혹은 N만 입력 가능합니다. 다시 입력해 주세요.")
                        }
                        inventory.minusQuantity(selectedName, selectedQuantity)
                        products = inventory.getProducts()
                        if (yesOrNo == "Y") {
                            normalProduct.price * selectedQuantity
                        } else {

                        }
                    }
                }
            }
        }
    }

    private fun requestSelectedProducts(): List<SelectedProduct> {
        val rawSelectedProducts = inputView.readSelectedProducts()
        return try {
            validateSelectedProducts(rawSelectedProducts)
            println()
            rawSelectedProducts
                .trim()
                .replace("[", "").replace("]", "")
                .split(",")
                .map {
                    it.split("-")
                }
                .map {
                    SelectedProduct(it[0], it[1].toInt())
                }
        } catch (e: IllegalArgumentException) {
            println(e.message)
            println()
            requestSelectedProducts()
        }
    }

    private fun validateSelectedProducts(rawSelectedProducts: String) {
        val split: List<String> = rawSelectedProducts.trim().split(',')
        split.forEach {
            if (!it.startsWith('[') || !it.endsWith(']')) {
                throw IllegalArgumentException("[ERROR] 올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요.")
            }
            if (!it.contains('-')) {
                throw IllegalArgumentException("[ERROR] 올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요.")
            }
            if (it.replace("[", "").replace("]", "").split('-')[1].toIntOrNull() == null) {
                throw IllegalArgumentException("[ERROR] 올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요.")
            }
        }
    }
}