package com.example.calculator.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.calculator.model.CalculatorState
import com.example.calculator.repo.CalculatorRepository


interface Operation {
    fun executeOperation(num1: Double, num2: Double): Double
}

class AdditionOperation : Operation {
    override fun executeOperation(num1: Double, num2: Double): Double {
        return num1 + num2
    }
}

class SubtractionOperation : Operation {
    override fun executeOperation(num1: Double, num2: Double): Double {
        return num1 - num2
    }
}

class MultiplicationOperation : Operation {
    override fun executeOperation(num1: Double, num2: Double): Double {
        return num1 * num2
    }
}

class DivisionOperation : Operation {
    override fun executeOperation(num1: Double, num2: Double): Double {
        return num1 / num2
    }
}

class CalculatorViewModel : ViewModel() {
    private val calculatorRepository = CalculatorRepository()
    private val _calculatorState = mutableStateOf(CalculatorState())

    val calculatorState: State<CalculatorState> = _calculatorState

    fun appendInput(input: String) {
        _calculatorState.value = _calculatorState.value.copy(input = _calculatorState.value.input + input)
    }

    fun clearInput() {
        _calculatorState.value = _calculatorState.value.copy(input = "")
    }

    fun calculateResult() {
        val result = calculatorRepository.calculateResult(_calculatorState.value.input)
        _calculatorState.value = _calculatorState.value.copy(result = result, input = "")
    }
}

