package calculator.logic;

import javafx.scene.control.TextField;

/**
 * Controller class for the calculator application.
 * Handles the input from the user and updates the UI accordingly.
 * 
 * @author Matti Kähkönen
 */
public class CalculatorController {

  /**
   * Default constructor.
   */
  public CalculatorController() {
  }

  /**
   * Handles the input from the user when an operator button is pressed.
   * This includes the operators [ *, /, -, +, =, ^, ²√, C].
   * Appends to, prepends to, displays the result or clears the input field
   * accordingly.
   * 
   * @param field    The text field where the input is displayed
   * @param operator The operator that was pressed
   */
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

  /**
   * Handles the input from the user when a symbol button is pressed.
   * More straightforward than the operator input.
   * 
   * @param field  The text ieled where the input is displayed
   * @param symbol The symbol that was pressed
   */
  public static void handleSymbolInput(TextField field, String symbol) {
    field.appendText(symbol);
  }

  /**
   * Formats the result and inserts it into the text field.
   * Checks if the result can be formatted as an integer without loss of
   * information.
   * 
   * @param result The result of the calculation
   * @param field  The field where the result is displayed
   */
  public static void formatAndInsertResult(double result, TextField field) {
    boolean roundable = result == Math.floor(result);
    if (roundable) {
      field.setText(String.valueOf((int) result));
      return;
    }
    field.setText(String.valueOf(result));
  }
}
