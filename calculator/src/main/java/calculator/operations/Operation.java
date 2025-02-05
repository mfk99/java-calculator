package calculator.operations;

/**
 * A superclass for all operations.
 */
public abstract class Operation {
  /**
   * An abstract method to perform an operation on two numbers.
   * 
   * @param a the first number
   * @param b the second number
   * @return the result of the operation
   */
  public abstract double operate(double a, double b);

}
