package com.dji.calculator.presentation.calculator_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dji.calculator.databinding.FragmentCalculatorBinding


class CalculatorFragment : Fragment() {

    private lateinit var binding: FragmentCalculatorBinding
    private lateinit var viewModel: CalculatorViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)

        setupCalculator()

        observeCalculatorResult()
    }

    private fun setupCalculator() {
        // Set up button click listeners
        binding.btnClear.setOnClickListener {
            viewModel.clear()
        }

        binding.btnDelete.setOnClickListener {
            viewModel.delete()
        }

        binding.btnPlusMinus.setOnClickListener {
            viewModel.changeSign()
        }

        binding.btnDivide.setOnClickListener {
            viewModel.divide()
        }

        binding.btnMultiply.setOnClickListener {
            viewModel.multiply()
        }

        binding.btnMinus.setOnClickListener {
            viewModel.subtract()
        }

        binding.btnPlus.setOnClickListener {
            viewModel.add()
        }

        binding.btnEquals.setOnClickListener {
            viewModel.calculate()
        }

        binding.btnDot.setOnClickListener {
            viewModel.appendDecimal()
        }

        binding.btn0.setOnClickListener {
            viewModel.appendDigit("0")
        }

        binding.btn1.setOnClickListener {
            viewModel.appendDigit("1")
        }

        binding.btn2.setOnClickListener {
            viewModel.appendDigit("2")
        }

        binding.btn3.setOnClickListener {
            viewModel.appendDigit("3")
        }

        binding.btn4.setOnClickListener {
            viewModel.appendDigit("4")
        }

        binding.btn5.setOnClickListener {
            viewModel.appendDigit("5")
        }

        binding.btn6.setOnClickListener {
            viewModel.appendDigit("6")
        }

        binding.btn7.setOnClickListener {
            viewModel.appendDigit("7")
        }

        binding.btn8.setOnClickListener {
            viewModel.appendDigit("8")
        }

        binding.btn9.setOnClickListener {
            viewModel.appendDigit("9")
        }
    }

    private fun observeCalculatorResult() {
        viewModel.calculatorResult.observe(viewLifecycleOwner) { result ->
            binding.tvResult.text = result
        }
    }

}