package store.model.file

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import store.model.Promotion

class PromotionsFileTest {

    @Test
    fun `파일에서 프로모션 목록을 읽어온다`() {
        val promotions = PromotionsFile().readFile()

        assertEquals(
            listOf(
                "탄산2+1,2,1,2024-01-01,2024-12-31",
                "MD추천상품,1,1,2024-01-01,2024-12-31",
                "반짝할인,1,1,2024-11-01,2024-11-30"
            ), promotions
        )
    }

    @Test
    fun `읽어온 프로모션 목록을 Promotion 객체로 변환한다`() {
        val promotionsFile = PromotionsFile()
        val promotions = promotionsFile.mapToPromotions(promotionsFile.readFile())

        assertEquals(
            listOf(
                Promotion("탄산2+1", 2, 1, "2024-01-01", "2024-12-31"),
                Promotion("MD추천상품", 1, 1, "2024-01-01", "2024-12-31"),
                Promotion("반짝할인", 1, 1, "2024-11-01", "2024-11-30")
            ), promotions
        )
    }
}