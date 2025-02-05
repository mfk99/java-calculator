package calculator;

/**
 * A class used to parse inputs of the calculator.
 */
public class Parser {

  /**
   * The expression to be parsed.
   */
  private String expression;

  /**
   * The constructor method.
   * Removes extra spaces from the expression.
   * 
   * @param expression the expression to be parsed
   */
  public Parser(String expression) {
    expression = expression.strip();
    while (expression.contains("  ")) {
      expression = expression.replace("  ", " ");
    }
    this.expression = expression;
  }

  /**
   * A method to parse the operator in the expression.
   * 
   * @return the operator in the expression
   */
  public String parseOperator() {
    if (expression.isEmpty()) {
      throw new IllegalArgumentException("Empty expression");
    }
    if (expression.contains("+"))
      return "+";
    if (expression.contains("-"))
      return "-";
    if (expression.contains("*"))
      return "*";
    if (expression.contains("/"))
      return "/";
    if (expression.contains("^"))
      return "^";
    if (expression.contains("²√"))
      return "²√";

    throw new IllegalArgumentException("Invalid operator: " + expression);
  }

  /**
   * Attempts to parse the operands in the expression.
   * Throws an exception if the length of the expression is invalid.
   * 
   * @return a list of operands in the expression
   */
  public Double[] parseOperand() {
    try {
      String[] parts = expression.split(" ");
      if (expression.contains("²√")) {
        if (parts.length != 2)
          throw new IllegalArgumentException("Square root requires exactly one operand.");
        return new Double[] { Double.parseDouble(parts[1]), 0.0 }; // Dummy second operand
      } else if (parts.length != 3) {
        throw new IllegalArgumentException("Invalid format. Expected: number operator number");
      }
      Double[] operands = { 0.0, 0.0 };
      if (parts[0].equals("π")) {
        operands[0] = Math.PI;
      } else {
        operands[0] = Double.parseDouble(parts[0]);
      }
      if (parts[2].equals("π")) {
        operands[1] = Math.PI;
      } else {
        operands[1] = Double.parseDouble(parts[2]);
      }
      return operands;
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Invalid number format: " + expression);
    }
  }
}
