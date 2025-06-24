package com.example.calculator.model

data class Calculator(
    var currentResult: String = "0",
    var currentInput: String = ""
) {
    // добавление ввода пользователя
    fun appendInput(input: String) {
        currentInput += input
    }

    // очистка ввода
    fun clearInput() {
        currentInput = ""
    }

    // вычисление результата
    fun calculateResult() {
    }
}