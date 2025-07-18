package com.example.calculator.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.calculator.viewmodel.CalculatorViewModel
import androidx.compose.ui.unit.dp

@Composable
fun CalculatorScreen(calculatorViewModel: CalculatorViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Result: ${calculatorViewModel.calculatorState.value.result}")

        val calculatorButtons = listOf(
            listOf("7", "8", "9", "/"),
            listOf("4", "5", "6", "*"),
            listOf("1", "2", "3", "-"),
            listOf("0", ".", "=", "+")
        )

        calculatorButtons.forEach { row ->
            Row {
                row.forEach { buttonText ->
                    CalculatorButton(buttonText = buttonText, buttonColor = Color.Gray) {
                        calculatorViewModel.onButtonClicked(buttonText)
                    }
                }
            }
        }
    }
}

@Composable
fun CalculatorButton(buttonText: String, buttonColor: Color, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = buttonText, color = Color.Red)
    }
}
