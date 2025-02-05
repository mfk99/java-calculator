package calculator.operations;

/**
 * A class used to perform subtraction.
 * A subclass of Operation.
 */
public class Subtraction extends Operation {

  public Subtraction() {
  }

  /**
   * A method to subtract two numbers.
   * 
   * @param a the first number
   * @param b the second number
   * @return the difference of the two numbers
   */
  @Override
  public double operate(double a, double b) {
    return a - b;
  }
}
