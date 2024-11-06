package store

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PromotionTest {
    
    @Test
    fun `프로모션은 이름, 구매 수량, 증정 수량, 시작 날짜, 종료 날짜를 가진다`() {
        val promotion = Promotion("탄산2+1", 2, 1, "2024-01-01", "2024-12-31")

        assertEquals(promotion.getName(), "탄산2+1")
        assertEquals(promotion.getBuy(), 2)
        assertEquals(promotion.getGet(), 1)
        assertEquals(promotion.getStartDate(), "2024-01-01")
        assertEquals(promotion.getEndDate(), "2024-12-31")
    }
}