package pl.marcinwojdat.calculatorapplication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {
    var state by mutableStateOf("")
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun onAction(action: CalculatorAction) {
        when(action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Operation -> enterOperation(action.operation)
            CalculatorAction.Decimal -> enterDecimal()
            CalculatorAction.Clear -> clear()
            CalculatorAction.Delete -> deleteLastCharacter()
            CalculatorAction.Calculate -> calculate()
        }
    }

    private fun enterNumber(number: Int) { // TODO: zmienić typ number na String
        state += number.toString()
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (isLastCharacterAnOperation() || isLastCharacterADot()) {
            deleteLastCharacter()
        }
        state += operation.symbol
    }

    private fun enterDecimal() {
        if (canDotBePlaced()) {
            state += "."
        }
    }

    private fun clear() {
        state = ""
    }

    private fun deleteLastCharacter() {
        state = state.dropLast(1)
    }

    private fun calculate() {
        try {
            state = CalculatorService().calculate(state).toString()
        } catch (e: RuntimeException) {
            errorMessage = "W tym kalkulatorze nie dzielimy przez 0"
            state = ""
        }
    }

    fun clearErrorMessage() {
        errorMessage = null
    }

    private fun isLastCharacterADot(): Boolean {
        return state.isNotEmpty() && state.last() == '.'
    }

    private fun isLastCharacterADigit(): Boolean {
        return state.isNotEmpty() && state.last().isDigit()
    }

    private fun isLastCharacterAnOperation(): Boolean {
        return state.isNotEmpty() && charArrayOf('+', '-', '*', '/').contains(state.last())
    }

    private fun canDotBePlaced(): Boolean {
        val lastDotPosition = state.lastIndexOf('.')
        val lastOperationPosition = state.lastIndexOfAny(charArrayOf('+', '-', '*', '/'))
        return isLastCharacterADigit() && lastDotPosition <= lastOperationPosition
    }
}