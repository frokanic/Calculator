package com.dji.calculator.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dji.calculator.presentation.calculator_screen.CalculatorFragment
import com.dji.calculator.R
import com.dji.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CalculatorFragment())
                .commit()
        }
    }
}