package com.dji.calculator

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dji.calculator.presentation.calculator_screen.CalculatorViewModel
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

class CalculatorViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: CalculatorViewModel

    @Before
    fun setup() {
        viewModel = CalculatorViewModel()
    }

    @Test
    fun `append single digit`() {
        viewModel.appendDigit("1")
        assertEquals("1", viewModel.calculatorResult.value)
    }

    @Test
    fun `append multiple digits`() {
        viewModel.appendDigit("1")
        viewModel.appendDigit("2")
        viewModel.appendDigit("3")
        assertEquals("123", viewModel.calculatorResult.value)
    }

    @Test
    fun `append decimal to a number`() {
        viewModel.appendDigit("1")
        viewModel.appendDecimal()
        assertEquals("1.", viewModel.calculatorResult.value)
    }

    @Test
    fun `perform simple addition`() {
        viewModel.appendDigit("2")
        viewModel.add()
        viewModel.appendDigit("3")
        viewModel.calculate()
        assertEquals("5.0", viewModel.calculatorResult.value)
    }

    @Test
    fun `perform simple subtraction`() {
        viewModel.appendDigit("5")
        viewModel.subtract()
        viewModel.appendDigit("3")
        viewModel.calculate()
        assertEquals("2.0", viewModel.calculatorResult.value)
    }

    @Test
    fun `perform simple multiplication`() {
        viewModel.appendDigit("3")
        viewModel.multiply()
        viewModel.appendDigit("4")
        viewModel.calculate()
        assertEquals("12.0", viewModel.calculatorResult.value)
    }

    @Test
    fun `perform simple division`() {
        viewModel.appendDigit("8")
        viewModel.divide()
        viewModel.appendDigit("2")
        viewModel.calculate()
        assertEquals("4.0", viewModel.calculatorResult.value)
    }

    @Test
    fun `test clear operation`() {
        viewModel.appendDigit("1")
        viewModel.clear()
        assertEquals("", viewModel.calculatorResult.value)
    }

    @Test
    fun `change sign of a number`() {
        viewModel.appendDigit("2")
        viewModel.changeSign()
        assertEquals("-2", viewModel.calculatorResult.value)
    }

    @Test
    fun `delete a digit from a number`() {
        viewModel.appendDigit("1")
        viewModel.appendDigit("2")
        viewModel.delete()
        assertEquals("1", viewModel.calculatorResult.value)
    }
}
