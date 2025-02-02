package calculator.operations;

public class Addition extends Operation {

  public Addition() {
  }

  @Override
  public double operate(double a, double b) {
    return a + b;
  }
}
