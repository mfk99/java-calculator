package calculator.logic;

import calculator.operations.Operation;
import calculator.operations.SquareRoot;
import calculator.operations.Addition;
import calculator.operations.Division;
import calculator.operations.Exponent;
import calculator.operations.Multiplication;
import calculator.operations.Subtraction;

/**
 * A class used to calculate the result of an expression.
 */
public class CalculatorLogic {
  private static Operation addition = new Addition();
  private static Operation subtraction = new Subtraction();
  private static Operation multiplication = new Multiplication();
  private static Operation division = new Division();
  private static Operation exponent = new Exponent();
  private static Operation squareRoot = new SquareRoot();

  /**
   * The default constructor method.
   */
  public CalculatorLogic() {
  }

  /**
   * A method to calculate the result of an expression.
   * Throws an exception if the operator is not supported or provided.
   * 
   * @param a        the first operand
   * @param b        the second operand
   * @param operator the operator
   * @return the result of the expression
   */
  public static double calculate(double a, double b, String operator) {
    switch (operator) {
      case "+":
        return addition.operate(a, b);
      case "-":
        return subtraction.operate(a, b);
      case "*":
        return multiplication.operate(a, b);
      case "/":
        if (b == 0)
          throw new ArithmeticException("Cannot divide by zero");
        return division.operate(a, b);
      case "^":
        return exponent.operate(a, b);
      case "²√":
        if (a < 0)
          throw new ArithmeticException("Cannot take square root of a negative number");
        return squareRoot.operate(a, b);
      default:
        throw new IllegalArgumentException("Invalid operator");
    }
  }
}
