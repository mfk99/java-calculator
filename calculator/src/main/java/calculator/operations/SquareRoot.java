package calculator.operations;

public class SquareRoot extends Operation {

  public SquareRoot() {
  }

  @Override
  public double operate(double a, double b) {
    a = Math.sqrt(a);
    return a;
  }
}
