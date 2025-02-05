package calculator.operations;

/**
 * A class used to perform exponentiation.
 * A subclass of Operation.
 */
public class Exponent extends Operation {

  public Exponent() {
  }

  /**
   * A method to raise a number to a power.
   * 
   * @param a the base
   * @param b the exponent
   * @return the result of the exponentiation
   */
  @Override
  public double operate(double a, double b) {
    return Math.pow(a, b);
  }
}
