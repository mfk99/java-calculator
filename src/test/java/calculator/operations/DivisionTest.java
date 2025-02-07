package calculator.operations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DivisionTest {
  private Division divisionOperator;

  @BeforeEach
  public void setUp() {
    divisionOperator = new Division();
  }

  @Test
  public void DivisionWithPositives() {
    double result = divisionOperator.operate(6.4, 0.8);
    double expectedResult = 8.0;
    assertTrue(result == expectedResult);
  }

  @Test
  public void DivisionWithNegatives() {
    double result = divisionOperator.operate(-3.0, -1.5);
    double expectedResult = 2.0;
    assertTrue(result == expectedResult);
  }

  @Test
  public void DividingZero() {
    double result = divisionOperator.operate(0.0, 1.0);
    double expectedResult = 0.0;
    assertTrue(result == expectedResult);
  }

  @Test
  public void DivisionWithZeroThrowsError() {
    assertThrows(ArithmeticException.class, () -> divisionOperator.operate(5.2, 0.0));
  }
}
