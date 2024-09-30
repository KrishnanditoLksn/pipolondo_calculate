package app.ditodev.pipolondo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val _res = MutableLiveData<Int>()
    val  res  : LiveData<Int> get() = _res

    fun calculateSum(number1: String, number2: String) {
        _res.value = number1.toInt() + number2.toInt()
    }

    fun calculateKurang(number1: String, number2: String) {
        _res.value = number1.toInt() - number2.toInt()
    }

    fun calculateBagi(number1: String, number2: String) {
        _res.value = number1.toInt() / number2.toInt()
    }

    fun calculateKali(number1: String, number2: String) {
        _res.value = number1.toInt() * number2.toInt()
    }
}