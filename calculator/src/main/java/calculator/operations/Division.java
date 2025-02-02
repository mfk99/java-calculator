package calculator.operations;

public class Division extends Operation {

  public Division() {
  }

  @Override
  public double operate(double a, double b) {
    return a / b;
  }
}