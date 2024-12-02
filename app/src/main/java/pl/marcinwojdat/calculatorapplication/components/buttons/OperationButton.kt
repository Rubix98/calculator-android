package pl.marcinwojdat.calculatorapplication.components.buttons

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pl.marcinwojdat.calculatorapplication.CalculatorAction
import pl.marcinwojdat.calculatorapplication.CalculatorOperation
import pl.marcinwojdat.calculatorapplication.CalculatorOperation.Add
import pl.marcinwojdat.calculatorapplication.CalculatorOperation.Divide
import pl.marcinwojdat.calculatorapplication.CalculatorOperation.Multiply
import pl.marcinwojdat.calculatorapplication.CalculatorOperation.Substract
import pl.marcinwojdat.calculatorapplication.ui.theme.OperatorButtonColor

@Composable
fun OperationButton(
    symbol: String,
    onClick: (CalculatorAction) -> Unit,
    modifier: Modifier = Modifier
) {
    CalculatorButton(
        symbol = symbol,
        onClick = {onClick(CalculatorAction.Operation(getOperationFromSymbol(symbol)))},
        modifier = Modifier.background(color = OperatorButtonColor).then(modifier)
    )
}

 fun getOperationFromSymbol(symbol: String): CalculatorOperation {
    when(symbol) {
        "+" -> return Add
        "-" -> return Substract
        "*" -> return Multiply
        "/" -> return Divide
    }
    throw RuntimeException("Unsupported operation")
}