package calculator;

import calculator.operations.Operation;
import calculator.operations.SquareRoot;
import calculator.operations.Addition;
import calculator.operations.Division;
import calculator.operations.Exponent;
import calculator.operations.Multiplication;
import calculator.operations.Subtraction;

public class Calculator {
  private Operation addition;
  private Operation subtraction;
  private Operation multiplication;
  private Operation division;
  private Operation exponent;
  private Operation squareRoot;

  public Calculator() {
    this.addition = new Addition();
    this.subtraction = new Subtraction();
    this.multiplication = new Multiplication();
    this.division = new Division();
    this.exponent = new Exponent();
    this.squareRoot = new SquareRoot();
  }

  public double calculate(double a, double b, String operator) {
    switch (operator) {
      case "+":
        return addition.operate(a, b);
      case "-":
        return subtraction.operate(a, b);
      case "*":
        return multiplication.operate(a, b);
      case "/":
        return division.operate(a, b);
      case "^":
        return exponent.operate(a, b);
      case "sqrt":
        return squareRoot.operate(a, b);
      default:
        throw new IllegalArgumentException("Invalid operator");
    }
  }
}
