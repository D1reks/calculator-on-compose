package com.example.calculator.repo

class CalculatorRepository {
    fun calculateResult(input: String): Double {
        val parts = input.trim().split(" ")

        if (parts.size != 3) {
            return input.toDouble()
        }

        val num1 = parts[0].toDouble()
        val operator = parts[1]
        val num2 = parts[2].toDouble()

        val result = when (operator) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> num1 / num2
            else -> Double.NaN
        }

        return result
    }
    }
