package calculator.operations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MultiplicationTest {
  private Multiplication multiplicationOperator;

  @BeforeEach
  public void setUp() {
    multiplicationOperator = new Multiplication();
  }

  @Test
  public void MultiplicationWithPositives() {
    double result = multiplicationOperator.operate(5.2, 10.3);
    double expectedResult = 53.56;
    assertTrue(result == expectedResult);
  }

  @Test
  public void MultiplicationWithNegative() {
    double result = multiplicationOperator.operate(3.0, -10.0);
    double expectedResult = -30.0;
    assertTrue(result == expectedResult);
  }

  @Test
  public void MultiplicationWithZero() {
    double result = multiplicationOperator.operate(5.2, 0.0);
    double expectedResult = 0.0;
    assertTrue(result == expectedResult);
  }
}
