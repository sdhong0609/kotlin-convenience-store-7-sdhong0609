package store.model.file

import camp.nextstep.edu.missionutils.DateTimes
import store.model.Promotion
import java.io.File
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class PromotionsFile {

    private fun readFile(): List<String> {
        return File("src/main/resources/promotions.md").readLines().drop(1)
    }

    fun mapToPromotions(): List<Promotion> {
        return readFile().map { it.toPromotion() }
    }

    private fun String.toPromotion(): Promotion {
        val (name, buy, get, startDate, endDate) = this.split(',')
        val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val startLocalDate = LocalDate.parse(startDate, dateTimeFormatter)
        val endLocalDate = LocalDate.parse(endDate, dateTimeFormatter)
        return Promotion(name, buy.toInt(), get.toInt(), startLocalDate, endLocalDate)
    }
}
