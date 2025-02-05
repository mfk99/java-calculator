package calculator.controller;

import calculator.Parser;
import calculator.logic.CalculatorLogic;
import javafx.scene.control.TextField;

public class CalculatorController {

  public CalculatorController() {
  }

  public static void handleOperatorInput(TextField field, String operator) {
    if (operator.equals("C")) {
      field.clear();
    } else if (operator.equals("²√")) {
      String expression = field.getText();
      expression = "²√ " + expression;
      field.setText(expression);
    } else if (operator.equals("=")) {
      try {
        String expression = field.getText();
        Parser parser = new Parser(expression);
        String parsedOperator = parser.parseOperator();
        Double[] parsedOperands = parser.parseOperand();
        double result = CalculatorLogic.calculate(parsedOperands[0], parsedOperands[1], parsedOperator);
        formatAndInsertResult(result, field);
      } catch (IllegalArgumentException | ArithmeticException e) {
        System.out.println("Error: " + e.getMessage());
        field.setText("ERR");
      }
    } else {
      field.appendText(" " + operator + " ");
    }
  }

  public static void handleSymbolInput(TextField field, String symbol) {
    field.appendText(symbol);
  }

  public static void formatAndInsertResult(double result, TextField field) {
    boolean roundable = result == Math.floor(result);
    if (roundable) {
      field.setText(String.valueOf((int) result));
      return;
    }
    field.setText(String.valueOf(result));
  }
}
