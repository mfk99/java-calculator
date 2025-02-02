package calculator.operations;

public class SquareRoot extends Operation {

  public SquareRoot() {
  }

  @Override
  public double operate(double a, double b) {
    for (int i = 1; i < b; i++) {
      a = Math.sqrt(a);
    }
    return a;
  }
}
