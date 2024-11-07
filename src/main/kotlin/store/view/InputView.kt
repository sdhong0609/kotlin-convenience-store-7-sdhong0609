package store.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readBuyProducts(): String {
        return Console.readLine()
    }

    fun readYesOrNo(): String {
        return Console.readLine()
    }
}