package calculator.logic;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParserTest {
  private String expression = "115.0 + 225.0";
  private Parser baselineParser;

  @BeforeEach
  public void setUp() {
    baselineParser = new Parser(expression);
  }

  @Test
  public void BaseLineParsesOperatorCorrectly() {
    String operator = baselineParser.parseOperator();
    String expectedOperator = "+";
    assertEquals(operator, expectedOperator);
  }

  @Test
  public void BaseLineParsesOperandsCorrectly() {
    Double[] operands = baselineParser.parseOperand();
    Double[] expectedOperands = { 115.0, 225.0 };
    assertArrayEquals(operands, expectedOperands);
  }

  @Test
  public void OperatorParsingMatchesWithExtraWhiteSpaces() {
    String poorlyFormattedExpression = " 115.0   +     225.0    ";
    Parser poorlyFormattedParser = new Parser(poorlyFormattedExpression);
    String expectedOperator = baselineParser.parseOperator();
    String operator = poorlyFormattedParser.parseOperator();
    assertEquals(operator, expectedOperator);
  }

  @Test
  public void OperandParsingMatchesWithExtraWhiteSpaces() {
    String poorlyFormattedExpression = " 115.0   +     225.0    ";
    Parser poorlyFormattedParser = new Parser(poorlyFormattedExpression);
    Double[] expectedOperands = baselineParser.parseOperand();
    Double[] operands = poorlyFormattedParser.parseOperand();
    assertArrayEquals(operands, expectedOperands);
  }

  @Test
  public void ParsingMissingOperandThrowsException() {
    String missingOperandIllegalExpression = "   +     225.0    ";
    Parser illegalParser = new Parser(missingOperandIllegalExpression);
    assertThrows(IllegalArgumentException.class, () -> illegalParser.parseOperand());
  }

  @Test
  public void ParsingMissingOperatorThrowsException() {
    String missingOperatorIllegalExpression = "   1.0    225.0    ";
    Parser illegalParser = new Parser(missingOperatorIllegalExpression);
    assertThrows(IllegalArgumentException.class, () -> illegalParser.parseOperand());
  }

  @Test
  public void ParsingBlankExpressionThrowsException() {
    Parser illegalParser = new Parser("");
    assertThrows(IllegalArgumentException.class, () -> illegalParser.parseOperand());
  }

  @Test
  public void SquareRootHasTwoOperandsThrowsException() {
    String expression = "2 ²√ 81";
    Parser parser = new Parser(expression);
    assertThrows(IllegalArgumentException.class, () -> parser.parseOperand());
  }
}
