package store

import store.model.file.PromotionsFile
import store.view.InputView
import store.view.OutputView

fun main() {
    val convenienceStoreController = ConvenienceStoreController(
        outputView = OutputView(),
        inputView = InputView(),
        promotionsFile = PromotionsFile()
    )
    convenienceStoreController.run()
}
