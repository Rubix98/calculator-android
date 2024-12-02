package pl.marcinwojdat.calculatorapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import pl.marcinwojdat.calculatorapplication.ui.theme.CalculatorApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val calculatorViewModel = ViewModelProvider(this)[CalculatorViewModel::class]

        setContent {
            CalculatorApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Calculator(
                        calculatorState = calculatorViewModel.state,
                        onAction = calculatorViewModel::onAction,
                        modifier = Modifier.padding(innerPadding).fillMaxSize()
                    )
                    ErrorToast(calculatorViewModel)
                }
            }
        }
    }
}