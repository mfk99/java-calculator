package calculator.operations;

public class Exponent extends Operation {

  public Exponent() {
  }

  public double operate(double a, double b) {
    return Math.pow(a, b);
  }
}
