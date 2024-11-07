package store.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SelectedProductTest {

    @Test
    fun `사용자가 구매할 상품은 이름과 수량을 가진다`() {
        val selectedProduct = SelectedProduct("콜라", 2)

        assertThat(selectedProduct.name).isEqualTo("콜라")
        assertThat(selectedProduct.quantity).isEqualTo(2)
    }
}
