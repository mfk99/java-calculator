package calculator.operations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SubtractionTest {
  private Subtraction subtractionOperator;

  @BeforeEach
  public void setUp() {
    subtractionOperator = new Subtraction();
  }

  @Test
  public void SubtractionWithPositives() {
    double result = subtractionOperator.operate(10.0, 5.3);
    double expectedResult = 4.7;
    assertTrue(result == expectedResult);
  }

  @Test
  public void SubtractionWithNegative() {
    double result = subtractionOperator.operate(5.2, -10.3);
    double expectedResult = 15.5;
    assertTrue(result == expectedResult);
  }

  @Test
  public void SubtractionWithNegatives() {
    double result = subtractionOperator.operate(-1.9, -1.4);
    double expectedResult = -0.5;
    assertTrue(result == expectedResult);
  }

  @Test
  public void SubtractionWithZero() {
    double result = subtractionOperator.operate(-15.2, 0.0);
    double expectedResult = -15.2;
    assertTrue(result == expectedResult);
  }
}
