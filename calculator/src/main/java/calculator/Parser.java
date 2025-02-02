package calculator;

public class Parser {

  private String expression;

  // TODO: Add error handling for invalid expressions
  // TODO: Move split logic to constructor

  public Parser(String expression) {
    this.expression = expression;
  }

  public String parseOperator() {
    String[] parts = expression.split(" ");
    return parts[1];
  }

  public Double[] parseOperand() {
    String[] parts = expression.split(" ");
    double a = Double.parseDouble(parts[0]);
    double b = Double.parseDouble(parts[2]);
    Double[] operands = { a, b };
    return operands;
  }
}
