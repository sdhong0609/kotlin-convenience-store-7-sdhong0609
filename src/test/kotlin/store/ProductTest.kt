package store

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import store.model.Product
import store.model.Promotion

class ProductTest {

    @Test
    fun `상품은 이름, 가격, 재고 수량, 프로모션을 가진다`() {
        val product = Product("콜라", 1000, 10, Promotion("탄산2+1", 2, 1, "2024-01-01", "2024-12-31"))
        val promotion = product.promotion

        assertEquals(product.name, "콜라")
        assertEquals(product.price, 1000)
        assertEquals(product.quantity, 10)
        assertEquals(promotion?.name, "탄산2+1")
        assertEquals(promotion?.buy, 2)
        assertEquals(promotion?.get, 1)
        assertEquals(promotion?.startDate, "2024-01-01")
        assertEquals(promotion?.endDate, "2024-12-31")
    }

    @Test
    fun `상품의 프로모션은 없을 수도 있는데 이것은 일반 재고를 의미한다`() {
        val product = Product("콜라", 1000, 10, null)

        assertEquals(product.name, "콜라")
        assertEquals(product.price, 1000)
        assertEquals(product.quantity, 10)
        assertEquals(product.promotion, null)
    }
}