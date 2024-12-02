package pl.marcinwojdat.calculatorapplication.components.buttons

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pl.marcinwojdat.calculatorapplication.CalculatorAction
import pl.marcinwojdat.calculatorapplication.ui.theme.NumberButtonColor

@Composable
fun NumberButton(
    symbol: String,
    onClick: (CalculatorAction) -> Unit,
    modifier: Modifier = Modifier
) {
    CalculatorButton(
        symbol = symbol,
        onClick = {onClick(CalculatorAction.Number(symbol))},
        modifier = Modifier.background(color = NumberButtonColor).then(modifier)
    )
}