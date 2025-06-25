package com.example.calculator.repo

class CalculatorRepository {
    fun calculateResult(userInput: String): Double {
        val partsOfUserInput = userInput.trim().split(" ")

        if (partsOfUserInput.size != 3) {
            return userInput.toDouble()
        }

        val inputNumber1 = partsOfUserInput[0].toDouble()
        val userOperator = partsOfUserInput[1]
        val inputNumber2 = partsOfUserInput[2].toDouble()

        val calculatedResult = when (userOperator) {
            "+" -> inputNumber1 + inputNumber2
            "-" -> inputNumber1 - inputNumber2
            "*" -> inputNumber1 * inputNumber2
            "/" -> inputNumber1 / inputNumber2
            else -> Double.NaN
        }

        return calculatedResult
    }
    }
