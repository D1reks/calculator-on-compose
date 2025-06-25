package com.example.calculator.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.calculator.model.CalculatorState
import com.example.calculator.repo.CalculatorRepository

class CalculatorViewModel : ViewModel() {
    private val calculatorRepository = CalculatorRepository()
    private val _calculatorState = mutableStateOf(CalculatorState())

    val calculatorState: State<CalculatorState> = _calculatorState

    fun onButtonClicked(buttonText: String) {
        when {
            buttonText in listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".") -> appendInput(buttonText)
            buttonText in listOf("+", "-", "*", "/") -> appendOperator(buttonText)
            buttonText == "=" -> calculateResult()
        }
    }

    private fun appendInput(input: String) {
        _calculatorState.value = _calculatorState.value.copy(input = _calculatorState.value.input + input)
    }

    private fun appendOperator(operator: String) {
        if (_calculatorState.value.input.isNotEmpty() && _calculatorState.value.input.last().toString() !in listOf("+", "-", "*", "/")) {
            _calculatorState.value = _calculatorState.value.copy(input = _calculatorState.value.input + " $operator ")
        }
    }

    private fun calculateResult() {
        val result = calculatorRepository.calculateResult(_calculatorState.value.input)
        _calculatorState.value = _calculatorState.value.copy(result = result, input = "")
    }
}


