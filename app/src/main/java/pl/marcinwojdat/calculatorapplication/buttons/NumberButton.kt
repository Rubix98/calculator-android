package pl.marcinwojdat.calculatorapplication.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import pl.marcinwojdat.calculatorapplication.CalculatorAction

@Composable
fun NumberButton(
    symbol: String,
    onClick: (CalculatorAction) -> Unit,
    modifier: Modifier = Modifier
) {
    CalculatorButton(
        symbol = symbol,
        onClick = {onClick(CalculatorAction.Number(symbol.toInt()))},
        modifier = Modifier.background(color = Color.DarkGray).then(modifier)
    )
}