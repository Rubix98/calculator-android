package pl.marcinwojdat.calculatorapplication.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import pl.marcinwojdat.calculatorapplication.CalculatorAction
import pl.marcinwojdat.calculatorapplication.CalculatorOperation
import pl.marcinwojdat.calculatorapplication.CalculatorOperation.Add
import pl.marcinwojdat.calculatorapplication.CalculatorOperation.Divide
import pl.marcinwojdat.calculatorapplication.CalculatorOperation.Multiply
import pl.marcinwojdat.calculatorapplication.CalculatorOperation.Substract

@Composable
fun OperationButton(
    symbol: String,
    onClick: (CalculatorAction) -> Unit,
    modifier: Modifier = Modifier
) {
    CalculatorButton(
        symbol = symbol,
        onClick = {onClick(CalculatorAction.Operation(getOperationFromSymbol(symbol)))},
        modifier = modifier.background(color = Color(255, 165, 0))
    )
}

 fun getOperationFromSymbol(symbol: String): CalculatorOperation {
    when(symbol) {
        "+" -> Add
        "-" -> Substract
        "*" -> Multiply
        "/" -> Divide
    }
    throw RuntimeException("Unsupported operation")
}