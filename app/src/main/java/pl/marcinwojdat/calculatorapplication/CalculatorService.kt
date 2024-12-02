package pl.marcinwojdat.calculatorapplication

class CalculatorService {
    init {
        System.loadLibrary("calculatorservice")
    }

    external fun calculate(arg: String): Double;
}
