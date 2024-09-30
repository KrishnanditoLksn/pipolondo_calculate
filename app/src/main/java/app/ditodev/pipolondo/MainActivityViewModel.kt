package app.ditodev.pipolondo

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var res = 0

    fun calculateSum(number1: String, number2: String) {
        res = number1.toInt() + number2.toInt()
    }

    fun calculateKurang(number1: String, number2: String) {
        res = number1.toInt() - number2.toInt()
    }

    fun calculateBagi(number1: String, number2: String) {
        res = number1.toInt() / number2.toInt()
    }

    fun calculateKali(number1: String, number2: String) {
        res = number1.toInt() * number2.toInt()
    }
}