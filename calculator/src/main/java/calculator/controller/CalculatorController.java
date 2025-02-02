package calculator.controller;

import calculator.Parser;
import calculator.logic.CalculatorLogic;
import javafx.scene.control.TextField;

public class CalculatorController {

  public CalculatorController() {
  }

  public static void handleOperator(TextField field, String operator) {
    if (operator.equals("C")) {
      field.clear();
    } else if (operator.equals("=")) {
      try {
        String expression = field.getText();
        Parser parser = new Parser(expression);
        String parsedOperator = parser.parseOperator();
        Double[] parsedOperands = parser.parseOperand();
        double result = CalculatorLogic.calculate(parsedOperands[0], parsedOperands[1], parsedOperator);
        field.setText(String.valueOf(result));
      } catch (IllegalArgumentException | ArithmeticException e) {
        field.setText("Error: " + e.getMessage());
      }
    } else {
      field.appendText(" " + operator + " ");
    }
  }
}
