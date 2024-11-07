package store

import store.view.OutputView

class ConvenienceStoreController {

    fun run() {
        val outputView = OutputView()
        outputView.printGreetings()
        outputView.printProductsInstructions()

        val promotionFile = PromotionsFile()
        val promotions = promotionFile.mapToPromotions(promotionFile.readFile())

        val productsFile = ProductsFile(promotions)
        productsFile.updateFile()
        val products = productsFile.mapToProducts(productsFile.readFile())
        outputView.printProducts(products)
    }
}