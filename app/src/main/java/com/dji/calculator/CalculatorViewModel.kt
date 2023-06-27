package com.dji.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    private val _calculatorResult = MutableLiveData<String>()
    val calculatorResult: LiveData<String> get() = _calculatorResult

    private var number1: String = ""
    private var number2: String = ""
    private var operator: Operator? = null
    private var currentNumber: String = ""

    enum class Operator {
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION
    }

    fun add() {
        handleOperator(Operator.ADDITION)
    }

    fun subtract() {
        handleOperator(Operator.SUBTRACTION)
    }

    fun multiply() {
        handleOperator(Operator.MULTIPLICATION)
    }

    fun divide() {
        handleOperator(Operator.DIVISION)
    }

    fun appendDecimal() {
        if (operator == null && number1.isNotEmpty() && !number1.contains(".")) {
            number1 += "."
            _calculatorResult.value = number1
        } else if (operator != null && !number2.contains(".")) {
            if (number2.isNotEmpty()) {
                number2 += "."
                _calculatorResult.value = "$number1 ${getOperatorSymbol(operator)} $number2"
            } else {
                _calculatorResult.value = "$number1 ${getOperatorSymbol(operator)} 0."
                number2 = "0."
            }
        }
    }


    fun changeSign() {
        if (operator == null && number1.isNotEmpty()) {
            number1 = if (number1.startsWith("-")) number1.substring(1) else "-$number1"
            _calculatorResult.value = number1
        } else if (operator != null && number2.isNotEmpty()) {
            number2 = if (number2.startsWith("-")) number2.substring(1) else "-$number2"
            _calculatorResult.value = "$number1 ${getOperatorSymbol(operator)} $number2"
        }
    }

    fun delete() {
        if (operator == null && number1.isNotEmpty()) {
            if (number1 == "-" || (number1.startsWith("-") && number1.length == 2)) {
                number1 = ""
            } else {
                number1 = number1.dropLast(1)
            }
            _calculatorResult.value = number1
        } else if (operator != null && number2.isNotEmpty()) {
            if (number2 == "-" || (number2.startsWith("-") && number2.length == 2)) {
                number2 = ""
            } else {
                number2 = number2.dropLast(1)
            }
            _calculatorResult.value = "$number1 ${getOperatorSymbol(operator)} $number2"
        } else if (operator != null && number2.isEmpty()) {
            operator = null
            _calculatorResult.value = number1
        }
    }

    fun clear() {
        number1 = ""
        number2 = ""
        operator = null
        currentNumber = ""
        _calculatorResult.value = ""
    }

    fun calculate() {
        if (number1.isNotEmpty() && number2.isNotEmpty() && operator != null) {
            performPreviousAction()
        }
        _calculatorResult.value = number1
        currentNumber = ""
    }

    private fun handleOperator(op: Operator) {
        if (number1.isNotEmpty()) {
            if (number2.isNotEmpty()) {
                performPreviousAction()
            }
            operator = op
            _calculatorResult.value = "$number1 ${getOperatorSymbol(op)}"
        }
    }

    private fun performPreviousAction() {
        if (number1 == "-" || number2 == "-") {
            return
        }

        val num1 = number1.toDouble()
        val num2 = number2.toDouble()
        number1 = when (operator) {
            Operator.ADDITION -> (num1 + num2).toString()
            Operator.SUBTRACTION -> (num1 - num2).toString()
            Operator.MULTIPLICATION -> (num1 * num2).toString()
            Operator.DIVISION -> if (num2 != 0.0) (num1 / num2).toString() else "Error"
            else -> number1
        }
        number2 = ""
        operator = null
    }

    fun appendDigit(digit: String) {
        if (_calculatorResult.value == "Error") {
            clear()
        }

        if (operator == null) {
            number1 += digit
            _calculatorResult.value = number1
        } else {
            number2 += digit
            _calculatorResult.value = "$number1 ${getOperatorSymbol(operator)} $number2"
        }
    }

    private fun getOperatorSymbol(operator: Operator?): String {
        return when (operator) {
            Operator.ADDITION -> "+"
            Operator.SUBTRACTION -> "-"
            Operator.MULTIPLICATION -> "*"
            Operator.DIVISION -> "/"
            else -> ""
        }
    }
}
