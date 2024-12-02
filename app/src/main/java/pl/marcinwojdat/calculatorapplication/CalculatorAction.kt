package pl.marcinwojdat.calculatorapplication

sealed class CalculatorAction {
    data class Number(val number: String): CalculatorAction()
    data class Operation(val operation: CalculatorOperation): CalculatorAction()
    object Clear: CalculatorAction()
    object Delete: CalculatorAction()
    object Decimal: CalculatorAction()
    object Calculate: CalculatorAction()
}