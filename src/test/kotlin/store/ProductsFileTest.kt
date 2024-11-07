package store

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ProductsFileTest {

    private val productFile = ProductsFile(PromotionsFile().mapToPromotions(PromotionsFile().readFile()))

    @BeforeEach
    fun setUp() {
        productFile.initFile()
    }

    @Test
    fun `파일에서 상품 목록을 읽어온다`() {
        val rawProducts = productFile.readFile()

        assertEquals(
            listOf(
                "콜라,1000,10,탄산2+1",
                "콜라,1000,10,null",
                "사이다,1000,8,탄산2+1",
                "사이다,1000,7,null",
                "오렌지주스,1800,9,MD추천상품",
                "탄산수,1200,5,탄산2+1",
                "물,500,10,null",
                "비타민워터,1500,6,null",
                "감자칩,1500,5,반짝할인",
                "감자칩,1500,5,null",
                "초코바,1200,5,MD추천상품",
                "초코바,1200,5,null",
                "에너지바,2000,5,null",
                "정식도시락,6400,8,null",
                "컵라면,1700,1,MD추천상품",
                "컵라면,1700,10,null"
            ), rawProducts
        )
    }

    @Test
    fun `상품 목록에 프로모션 재고는 존재하지만 일반 재고가 존재하지 않는 경우에는 일반 재고를 0으로 설정하여 상품 목록을 업데이트한다`() {
        assertEquals(
            listOf(
                listOf("콜라", "1000", "10", "탄산2+1"),
                listOf("콜라", "1000", "10", "null"),
                listOf("사이다", "1000", "8", "탄산2+1"),
                listOf("사이다", "1000", "7", "null"),
                listOf("오렌지주스", "1800", "9", "MD추천상품"),
                listOf("오렌지주스", "1800", "0", "null"),
                listOf("탄산수", "1200", "5", "탄산2+1"),
                listOf("탄산수", "1200", "0", "null"),
                listOf("물", "500", "10", "null"),
                listOf("비타민워터", "1500", "6", "null"),
                listOf("감자칩", "1500", "5", "반짝할인"),
                listOf("감자칩", "1500", "5", "null"),
                listOf("초코바", "1200", "5", "MD추천상품"),
                listOf("초코바", "1200", "5", "null"),
                listOf("에너지바", "2000", "5", "null"),
                listOf("정식도시락", "6400", "8", "null"),
                listOf("컵라면", "1700", "1", "MD추천상품"),
                listOf("컵라면", "1700", "10", "null")
            ), productFile.updatedProducts()
        )
    }

    @Test
    fun `업데이트한 상품 목록을 파일에 저장 후 읽어온다`() {
        productFile.updateFile()

        assertEquals(
            listOf(
                "콜라,1000,10,탄산2+1",
                "콜라,1000,10,null",
                "사이다,1000,8,탄산2+1",
                "사이다,1000,7,null",
                "오렌지주스,1800,9,MD추천상품",
                "오렌지주스,1800,0,null",
                "탄산수,1200,5,탄산2+1",
                "탄산수,1200,0,null",
                "물,500,10,null",
                "비타민워터,1500,6,null",
                "감자칩,1500,5,반짝할인",
                "감자칩,1500,5,null",
                "초코바,1200,5,MD추천상품",
                "초코바,1200,5,null",
                "에너지바,2000,5,null",
                "정식도시락,6400,8,null",
                "컵라면,1700,1,MD추천상품",
                "컵라면,1700,10,null"
            ), productFile.readFile()
        )
    }
}