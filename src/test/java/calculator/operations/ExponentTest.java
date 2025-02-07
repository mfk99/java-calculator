package calculator.operations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExponentTest {
  private Exponent exponentOperator;

  @BeforeEach
  public void setUp() {
    exponentOperator = new Exponent();
  }

  @Test
  public void ExponentPositiveWholeNumber() {
    double result = exponentOperator.operate(9.0, 2.0);
    double expectedResult = 81.0;
    assertTrue(result == expectedResult);
  }

  @Test
  public void ExponentPositiveDecimal() {
    double result = exponentOperator.operate(2.5, 2.0);
    double expectedResult = 6.25;
    assertTrue(result == expectedResult);
  }

  @Test
  public void ExponentOfZero() {
    double result = exponentOperator.operate(25.0, 0.0);
    double expectedResult = 1.0;
    assertTrue(result == expectedResult);
  }

  @Test
  public void ExponentWithNegative() {
    double result = exponentOperator.operate(8.0, -1.0);
    double expectedResult = 0.125;
    assertTrue(result == expectedResult);
  }
}
