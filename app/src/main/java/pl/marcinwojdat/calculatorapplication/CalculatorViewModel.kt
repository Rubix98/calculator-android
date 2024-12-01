package pl.marcinwojdat.calculatorapplication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {
        when(action) {
            CalculatorAction.Calculate -> TODO()
            CalculatorAction.Clear -> TODO()
            CalculatorAction.Decimal -> TODO()
            CalculatorAction.Delete -> TODO()
            is CalculatorAction.Number -> TODO()
            is CalculatorAction.Operation -> TODO()
        }
    }
}