package com.example.calculator.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.calculator.viewmodel.CalculatorViewModel
import androidx.compose.runtime.remember

@Composable
fun CalculatorScreen(calculatorViewModel: CalculatorViewModel) {
    val calculatorState = remember { calculatorViewModel.calculatorState.value }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Result: ${calculatorState.result}")

        TextField(
            value = calculatorState.input,
            onValueChange = { calculatorViewModel.appendInput(it) },
            label = { Text("Enter expression") }
        )

        Button(onClick = { calculatorViewModel.calculateResult() }) {
            Text("Calculate")
        }
    }
}

