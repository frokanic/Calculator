package com.example.calculatorapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.calculatorapp.R
import com.example.calculatorapp.databinding.ActivityMainBinding
import com.example.calculatorapp.databinding.FragmentScientificBinding
import com.example.calculatorapp.databinding.FragmentStandardBinding

class ScientificFragment : Fragment(R.layout.fragment_scientific) {

    private lateinit var binding: FragmentScientificBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScientificBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}