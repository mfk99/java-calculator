package calculator.operations;

/**
 * A class used to perform addition.
 * A subclass of Operation.
 */
public class Addition extends Operation {

  public Addition() {
  }

  /**
   * A method to add two numbers.
   * 
   * @param a the first number
   * @param b the second number
   * @return the sum of the two numbers
   */
  @Override
  public double operate(double a, double b) {
    return a + b;
  }
}
