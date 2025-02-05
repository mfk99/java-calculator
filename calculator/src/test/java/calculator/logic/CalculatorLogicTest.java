package calculator.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorLogicTest {
  private double a;
  private double b;
  private String operator;

  @BeforeEach
  public void setUp() {
    a = 1.0;
    b = 100.0;
    operator = "-";
  }

  @Test
  public void LogicReturnsResultForValidParameters() {
    Double result = CalculatorLogic.calculate(a, b, operator);
    Double expectedResult = -99.0;
    assertEquals(result, expectedResult);
  }

  @Test
  public void MissingOperatorThrowsException() {
    assertThrows(IllegalArgumentException.class, () -> CalculatorLogic.calculate(a, b, ""));
  }

  @Test
  public void InvalidOperatorThrowsException() {
    assertThrows(IllegalArgumentException.class, () -> CalculatorLogic.calculate(a, b, "log"));
  }
}