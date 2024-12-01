package pl.marcinwojdat.calculatorapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.marcinwojdat.calculatorapplication.buttons.CalculatorButton
import pl.marcinwojdat.calculatorapplication.buttons.NumberButton
import pl.marcinwojdat.calculatorapplication.buttons.OperationButton

@Composable
fun Calculator(
    calculatorState: String,
    onAction: (CalculatorAction) -> Unit,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp
) {
    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = calculatorState,
                textAlign = TextAlign.End,
                fontSize = 80.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
                modifier = Modifier.fillMaxWidth()
            ) {
                CalculatorButton(symbol = "C", onClick = {onAction(CalculatorAction.Clear)}, modifier = Modifier.weight(2f).aspectRatio(2f))
                CalculatorButton(symbol = "Del", onClick = {onAction(CalculatorAction.Delete)}, modifier = Modifier.weight(1f).aspectRatio(1f), )
                OperationButton(symbol = "/", onClick = onAction, modifier = Modifier.weight(1f).aspectRatio(1f))
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
                modifier = Modifier.fillMaxWidth()
            ) {
                NumberButton(symbol = "7", onClick = onAction, modifier = Modifier.weight(1f).aspectRatio(1f))
                NumberButton(symbol = "8", onClick = onAction, modifier = Modifier.weight(1f).aspectRatio(1f))
                NumberButton(symbol = "9", onClick = onAction, modifier = Modifier.weight(1f).aspectRatio(1f))
                OperationButton(symbol = "*", onClick = onAction, modifier = Modifier.weight(1f).aspectRatio(1f))
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
                modifier = Modifier.fillMaxWidth()
            ) {
                NumberButton(symbol = "4", onClick = onAction, modifier = Modifier.weight(1f).aspectRatio(1f))
                NumberButton(symbol = "5", onClick = onAction, modifier = Modifier.weight(1f).aspectRatio(1f))
                NumberButton(symbol = "6", onClick = onAction, modifier = Modifier.weight(1f).aspectRatio(1f))
                OperationButton(symbol = "-", onClick = onAction, modifier = Modifier.weight(1f).aspectRatio(1f))
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
                modifier = Modifier.fillMaxWidth()
            ) {
                NumberButton(symbol = "1", onClick = onAction, modifier = Modifier.weight(1f).aspectRatio(1f))
                NumberButton(symbol = "2", onClick = onAction, modifier = Modifier.weight(1f).aspectRatio(1f))
                NumberButton(symbol = "3", onClick = onAction, modifier = Modifier.weight(1f).aspectRatio(1f))
                OperationButton(symbol = "+", onClick = onAction, modifier = Modifier.weight(1f).aspectRatio(1f))
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
                modifier = Modifier.fillMaxWidth()
            ) {
                NumberButton(symbol = "0", onClick = onAction, modifier = Modifier.weight(2f).aspectRatio(2f))
                CalculatorButton(symbol = ".", onClick = {onAction(CalculatorAction.Decimal)}, modifier = Modifier.weight(1f).aspectRatio(1f))
                CalculatorButton(symbol = "=", onClick = {onAction(CalculatorAction.Calculate)}, modifier = Modifier.weight(1f).aspectRatio(1f).background(color = Color(255, 165, 0)))
            }
        }
    }

}