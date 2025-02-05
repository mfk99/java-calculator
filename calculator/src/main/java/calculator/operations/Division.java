package calculator.operations;

/**
 * A class used to perform division.
 * A subclass of Operation.
 */
public class Division extends Operation {

  /**
   * The default constructor
   */
  public Division() {
  }

  /**
   * A method to divide two numbers.
   * 
   * @param a the first number
   * @param b the second number
   * @return the result of the division
   */
  @Override
  public double operate(double a, double b) {
    if (b == 0.0) {
      throw new ArithmeticException("Cannot divide by zero");
    }
    return a / b;
  }
}