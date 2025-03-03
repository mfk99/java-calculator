package calculator.operations;

/**
 * A class used to perform square root.
 * A subclass of Operation.
 */
public class SquareRoot extends Operation {

  /**
   * The default constructor
   */
  public SquareRoot() {
  }

  /**
   * A method to find the square root of a number.
   * 
   * @param a the number
   * @param b not used
   * @return the square root of the number
   */
  @Override
  public double operate(double a, double b) {
    if (a < 0.0) {
      throw new ArithmeticException("Cannot take square root of a negative number");
    }
    a = Math.sqrt(a);
    return a;
  }
}
