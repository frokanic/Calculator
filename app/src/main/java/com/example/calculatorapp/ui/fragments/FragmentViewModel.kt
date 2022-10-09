package com.example.calculatorapp.ui.fragments

import androidx.lifecycle.ViewModel
import com.example.calculatorapp.util.Constants
import java.lang.Long
import kotlin.math.pow

class FragmentViewModel: ViewModel() {

    val e = Constants.e
    val pi = Constants.pi








    //For Calculations


    fun sum(num1: Double, num2: Double): Double {
        return num1 + num2
    }

    fun subtract(num1: Double, num2: Double): Double {
        return num1 - num2
    }

    fun multiply(num1: Double, num2: Double): Double {
        return num1 * num2
    }

    fun divide(num1: Double, num2: Double): Double {
        return num1 / num2
    }

    fun changeSign(num: Double): Double {
        return num * (-1)
    }

    fun log(num: Double): Double {
        return Math.log(num)
    }

    fun ln(num: Double): Double {
        return ln(num)
    }

    fun pow(num: Double, pwr: Int): Double {
        return num.pow(pwr)
    }

    fun sqrt(num: Double): Double {
        return sqrt(num)
    }

    fun factorial(num: Int): Int {
        var result = 1
        for (numb in 2..num) result *= numb
        return result
    }

    fun inverse(num: Double): Double {
        return pow(num, -1)
    }

    fun percentage(num: Double): Double {
        return num / 100
    }

    fun toHex(num: Double): String {
        return Long.parseLong(num.toString(), 16).toString()
    }

    fun toOct(num: Double): String {
        return Long.parseLong(num.toString(), 8).toString()
    }

    fun toBin(num: Double): String {
        return Long.parseLong(num.toString(), 2).toString()
    }



}