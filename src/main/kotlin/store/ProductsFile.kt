package store

import java.io.File

class ProductsFile {

    fun readFile(): List<String> {
        return File("src/main/resources/products.md").readLines().drop(1)
    }

    private fun writeFile(content: String) {
        File("src/main/resources/products.md").writeText(content)
    }

    fun updatedProducts(): List<List<String>> {
        val products = readFile().map { it.split(",") }
        val updatedProducts = mutableListOf<List<String>>()

        products.indices.forEach { i ->
            updatedProducts.add(products[i])
            if (products[i][3] != "null") {
                if (i == products.lastIndex || products[i][0] != products[i + 1][0]) {
                    updatedProducts.add(listOf(products[i][0], products[i][1], "0", "null"))
                }
            }
        }
        return updatedProducts
    }

    fun updateFile() {
        writeFile("name,price,quantity,promotion\n" + updatedProducts().joinToString("\n") { it.joinToString(",") } + "\n")
    }

    fun initFile() {
        writeFile(
            "name,price,quantity,promotion\n" +
                    "콜라,1000,10,탄산2+1\n" +
                    "콜라,1000,10,null\n" +
                    "사이다,1000,8,탄산2+1\n" +
                    "사이다,1000,7,null\n" +
                    "오렌지주스,1800,9,MD추천상품\n" +
                    "탄산수,1200,5,탄산2+1\n" +
                    "물,500,10,null\n" +
                    "비타민워터,1500,6,null\n" +
                    "감자칩,1500,5,반짝할인\n" +
                    "감자칩,1500,5,null\n" +
                    "초코바,1200,5,MD추천상품\n" +
                    "초코바,1200,5,null\n" +
                    "에너지바,2000,5,null\n" +
                    "정식도시락,6400,8,null\n" +
                    "컵라면,1700,1,MD추천상품\n" +
                    "컵라면,1700,10,null\n"
        )
    }
}