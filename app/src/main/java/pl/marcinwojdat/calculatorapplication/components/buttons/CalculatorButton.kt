package pl.marcinwojdat.calculatorapplication.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.marcinwojdat.calculatorapplication.ui.theme.FunctionButtonColor
import pl.marcinwojdat.calculatorapplication.ui.theme.TextColor

@Composable
fun CalculatorButton(
    symbol: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clickable { onClick() }
            .clip(RoundedCornerShape(20.dp))
            .background(color = FunctionButtonColor)
            .then(modifier)
    ) {
        Text(
            text = symbol,
            fontSize = 40.sp,
            color = TextColor
        )
    }
}