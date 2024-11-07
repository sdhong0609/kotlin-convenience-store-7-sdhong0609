package store

import store.model.Promotion
import java.io.File

class PromotionsFile {

    fun readFile(): List<String> {
        return File("src/main/resources/promotions.md").readLines().drop(1)
    }

    fun mapToPromotions(rawPromotions: List<String>): List<Promotion> {
        return rawPromotions.map { it.toPromotion() }
    }

    private fun String.toPromotion(): Promotion {
        val (name, quantity, price, startDate, endDate) = this.split(',')
        return Promotion(name, quantity.toInt(), price.toInt(), startDate, endDate)
    }
}
