package com.example.calculator.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.calculator.ui.theme.CalculatorTheme
import com.example.calculator.viewmodel.CalculatorViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            myCalculator()
        }
    }
}

@Composable
fun myCalculator() {

    CalculatorScreen(calculatorViewModel = CalculatorViewModel())
}