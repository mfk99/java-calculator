package calculator;

import calculator.ui.CalculatorUI;

public class App {
    private Calculator calculator;
    private CalculatorUI ui;

    public App() {
        this.calculator = new Calculator();
        this.ui = new CalculatorUI();
    }

    public static void launch(String[] args) {
        CalculatorUI.launchUI(args); // Launch JavaFX UI
    }
}
