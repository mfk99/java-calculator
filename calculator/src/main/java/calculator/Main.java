package calculator;

import calculator.ui.CalculatorUI;
import javafx.application.Application;

/**
 * Main class used as an entry point for the application.
 * Launches the JavaFX UI.
 * 
 * @author Matti Kähkönen
 */
public class Main {
    /**
     * The main function, which launches the UI.
     * 
     * @param args the list of command line arguments
     */
    public static void main(String[] args) {
        Application.launch(CalculatorUI.class, args);
    }
}
