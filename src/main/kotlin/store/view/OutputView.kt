package store.view

import store.Product

class OutputView {

    fun printGreetings() {
        println("안녕하세요. W편의점입니다.")
    }

    fun printProductsInstructions() {
        println("현재 보유하고 있는 상품입니다.")
        println()
    }

    fun printProducts(products: List<Product>) {
        products.forEach { printProduct(it) }
    }

    private fun printProduct(product: Product) {
        val name = product.getName()
        val price = product.getPrice()
        val quantity = if (product.hasQuantity()) "${product.getQuantity()}개" else "재고 없음"
        val promotionName = if (product.isPromotionAvailable()) product.getPromotion()?.name else ""

        println("- $name ${formatPrice(price)} $quantity $promotionName")
    }

    private fun formatPrice(price: Int): String {
        return String.format("%,d원", price)
    }

    fun printBuyInstructions() {
        println("구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])")
    }

    fun printPromotionInstructions(productName: String, promotionGetCount: Int) {
        println("현재 ${productName}은(는) ${promotionGetCount}개를 무료로 더 받을 수 있습니다. 추가하시겠습니까? (Y/N)")
    }

    fun printNonPromotionInstructions(productName: String, nonPromotionCount: Int) {
        println("현재 $productName ${nonPromotionCount}개는 프로모션 할인이 적용되지 않습니다. 그래도 구매하시겠습니까? (Y/N)")
    }

    fun printMembershipInstructions() {
        println("멤버십 할인을 받으시겠습니까? (Y/N)")
    }

    fun printReceipt(buyProducts: List<Product>, getProducts: List<Product>) {
        println("==============W 편의점================")
        println("상품명\t\t수량\t금액")
        buyProducts.forEach {
            println("${it.getName()}\t\t${it.getQuantity()}\t${formatPrice(it.getPrice() * it.getQuantity())}")
        }
        println("=============증\t정===============")
        getProducts.forEach {
            println("${it.getName()}\t\t${it.getQuantity()}")
        }
        println("====================================")
        println("총구매액\t\t${buyProducts.sumOf { it.getQuantity() }}\t${formatPrice(buyProducts.sumOf { it.getPrice() * it.getQuantity() })}")
        println("행사할인\t\t\t${formatPrice(-1000)}")
        println("멤버십할인\t\t\t${formatPrice(-3000)}")
        println("내실돈\t\t\t ${formatPrice(buyProducts.sumOf { it.getPrice() * it.getQuantity() } - 1000 - 3000)}")
        println()
    }

    fun printMoreBuyInstructions() {
        println("감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)")
    }
}
