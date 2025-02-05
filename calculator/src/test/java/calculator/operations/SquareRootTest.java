package calculator.operations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SquareRootTest {
  private SquareRoot squareRootOperator;

  @BeforeEach
  public void setUp() {
    squareRootOperator = new SquareRoot();
  }

  @Test
  public void SquareRootPositiveWholeNumber() {
    double result = squareRootOperator.operate(81.0, 0.0);
    double expectedResult = 9.0;
    assertTrue(result == expectedResult);
  }

  @Test
  public void SquareRootPositiveDecimal() {
    double result = squareRootOperator.operate(6.25, 0.0);
    double expectedResult = 2.5;
    assertTrue(result == expectedResult);
  }

  @Test
  public void SquareRootOfZero() {
    double result = squareRootOperator.operate(0.0, 0.0);
    double expectedResult = 0.0;
    assertTrue(result == expectedResult);
  }

  @Test
  public void NegativeSquareRootThrowsError() {
    assertThrows(ArithmeticException.class, () -> squareRootOperator.operate(-1.0, 0.0));
  }
}
