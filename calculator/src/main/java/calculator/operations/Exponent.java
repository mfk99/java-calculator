package calculator.operations;

public class Exponent extends Operation {

  public Exponent() {
  }

  @Override
  public double operate(double a, double b) {
    return Math.pow(a, b);
  }
}
