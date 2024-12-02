package pl.marcinwojdat.calculatorapplication.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import pl.marcinwojdat.calculatorapplication.CalculatorViewModel

@Composable
fun ErrorToast(viewModel: CalculatorViewModel) {
    val context = LocalContext.current
    val errorMessage = viewModel.errorMessage

    LaunchedEffect(errorMessage) {
        errorMessage?.let {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            viewModel.clearErrorMessage()
        }
    }
}