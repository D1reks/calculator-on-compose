package com.example.calculator.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculator.model.Calculator

class CalculatorViewModel : ViewModel() {
    private val _calculatorState = mutableStateOf(Calculator())

    //val calculatorState: Thread.State<Calculator> = _calculatorState

    fun appendInput(input: String) {
        _calculatorState.value = _calculatorState.value.copy(input = _calculatorState.value.input + input)
    }

    fun clearInput() {
        _calculatorState.value = _calculatorState.value.copy(input = "")
    }


}