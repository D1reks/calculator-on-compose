package com.example.calculator.viewmodel


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

class Calculator {
    private val operations = mapOf(
        "+" to AdditionOperation(),
        "-" to SubtractionOperation(),
        "*" to MultiplicationOperation(),
        "/" to DivisionOperation()
    )

    fun calculateResult(input: String): Double {
        val parts = input.trim().split(" ")

        if (parts.size != 3) {
            return input.toDouble()
        }

        val num1 = parts[0].toDouble()
        val operator = parts[1]
        val num2 = parts[2].toDouble()

        val operation = operations[operator] ?: return Double.NaN

        return operation.executeOperation(num1, num2)
    }
}



