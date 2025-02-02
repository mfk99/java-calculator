package calculator;

public class Parser {

  private String expression;

  // TODO: Move split logic to constructor

  public Parser(String expression) {
    this.expression = expression;
  }

  public String parseOperator() {
    if (expression.isEmpty()) {
      throw new IllegalArgumentException("Empty expression");
    }
    String[] parts = expression.split(" ");
    return parts[1];
  }

  public Double[] parseOperand() {
    try {
      String[] parts = expression.split(" ");
      if (parts.length != 3)
        throw new IllegalArgumentException("Invalid format. Expected: number operator number");
      double a = Double.parseDouble(parts[0]);
      double b = Double.parseDouble(parts[2]);
      Double[] operands = { a, b };
      return operands;
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Invalid number format: " + expression);
    }
  }
}
