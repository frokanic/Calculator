package com.example.calculatorapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.calculatorapp.R
import com.example.calculatorapp.databinding.FragmentStandardBinding


class StandardFragment : Fragment(R.layout.fragment_standard) {

    private lateinit var binding: FragmentStandardBinding
    lateinit var viewModel: FragmentViewModel
    val prevOrp = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStandardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        keyboard()
    }

    fun updateSystems(hex: String, oct: String, dec: String) {
        binding.tvHex.text = hex
        binding.tvHex.text = oct
        binding.tvHex.text = dec
    }

    fun clearTvPreResult() {
        binding.tvPreResult.text = " "
    }

    fun checkPreviousOperator(opr: String): Array<String> {
        when (prevOrp) {
            "+" -> binding.result.text = viewModel.sum(
                binding.result.text.toString().toDouble(),
                binding.tvPreResult.text.toString().toDouble()
            ).toString()
            "-" -> binding.result.text = viewModel.subtract(
                binding.result.text.toString().toDouble(),
                binding.tvPreResult.text.toString().toDouble()
            ).toString()
            "*" -> binding.result.text = viewModel.multiply(
                binding.result.text.toString().toDouble(),
                binding.tvPreResult.text.toString().toDouble()
            ).toString()
            "/" -> binding.result.text = viewModel.divide(
                binding.result.text.toString().toDouble(),
                binding.tvPreResult.text.toString().toDouble()
            ).toString()
            "=" -> binding.result.text = ""
        }
        clearTvPreResult()


        val hex = viewModel.toHex(binding.result.text.toString().toDouble())
        val oct = viewModel.toOct(binding.result.text.toString().toDouble())
        val bin = viewModel.toBin(binding.result.text.toString().toDouble())
        val systemsArray = arrayOf(hex, oct, bin)

        binding.tvPreResult.text = ""
        //prevOrp = newOpr

        return systemsArray
    }


    fun keyboard() {

        //Numbers
        binding.num1.setOnClickListener {
            binding.tvPreResult.text = binding.tvPreResult.text.toString() + "1"
        }
        binding.num2.setOnClickListener {
            binding.tvPreResult.text = binding.tvPreResult.text.toString() + "2"
        }
        binding.num3.setOnClickListener {
            binding.tvPreResult.text = binding.tvPreResult.text.toString() + "3"
        }
        binding.num4.setOnClickListener {
            binding.tvPreResult.text = binding.tvPreResult.text.toString() + "4"
        }
        binding.num5.setOnClickListener {
            binding.tvPreResult.text = binding.tvPreResult.text.toString() + "5"
        }
        binding.num6.setOnClickListener {
            binding.tvPreResult.text = binding.tvPreResult.text.toString() + "6"
        }
        binding.num7.setOnClickListener {
            binding.tvPreResult.text = binding.tvPreResult.text.toString() + "7"
        }
        binding.num8.setOnClickListener {
            binding.tvPreResult.text = binding.tvPreResult.text.toString() + "8"
        }
        binding.num9.setOnClickListener {
            binding.tvPreResult.text = binding.tvPreResult.text.toString() + "9"
        }
        binding.num0.setOnClickListener {
            binding.tvPreResult.text = binding.tvPreResult.text.toString() + "0"
        }


        //Operations
        binding.add.setOnClickListener {
            val check = checkPreviousOperator(binding.add.text.toString())
            updateSystems(check[0], check[1], check[2])
        }
        binding.minus.setOnClickListener {
            val check = checkPreviousOperator(binding.minus.text.toString())
            updateSystems(check[0], check[1], check[2])
        }
        binding.times.setOnClickListener {
            val check = checkPreviousOperator(binding.times.text.toString())
            updateSystems(check[0], check[1], check[2])
        }
        binding.btnDiv.setOnClickListener {
            val check = checkPreviousOperator(binding.btnDiv.text.toString())
            updateSystems(check[0], check[1], check[2])
        }
        binding.equals.setOnClickListener {
            val check = checkPreviousOperator(binding.equals.text.toString())
            updateSystems(check[0], check[1], check[2])
        }
        binding.btnPlusMinus.setOnClickListener {
            binding.tvPreResult.text = viewModel.changeSign(binding.tvPreResult.toString().toDouble()).toString()    //btmText = changeSign(nm.toDouble())
        }
        binding.btnClear.setOnClickListener {
            //if bottom exists, clear it, if not, clear top
        }


        //Change screen
        binding.btnSwapScreens.setOnClickListener {
            findNavController().navigate(
                R.id.action_standard2_to_scientific
            )
        }




    }
}