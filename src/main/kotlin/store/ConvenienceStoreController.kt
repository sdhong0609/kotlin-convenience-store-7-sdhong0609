package store

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
        productsFile.updateFile()
        val products = productsFile.mapToProducts(productsFile.readFile())
        outputView.printProducts(products)
    }
}