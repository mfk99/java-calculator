package calculator.operations;

/**
 * A class used to perform multiplication.
 * A subclass of Operation.
 */
public class Multiplication extends Operation {

  public Multiplication() {
  }

  /**
   * A method to multiply two numbers.
   * 
   * @param a the first number
   * @param b the second number
   * @return the product of the two numbers
   */
  @Override
  public double operate(double a, double b) {
    return a * b;
  }
}
