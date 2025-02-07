package calculator.operations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdditionTest {
  private Addition additionOperator;

  @BeforeEach
  public void setUp() {
    additionOperator = new Addition();
  }

  @Test
  public void AdditionWithPositives() {
    double result = additionOperator.operate(5.2, 10.3);
    double expectedResult = 15.5;
    assertTrue(result == expectedResult);
  }

  @Test
  public void AdditionWithNegative() {
    double result = additionOperator.operate(5.9, -10.9);
    double expectedResult = -5.0;
    assertTrue(result == expectedResult);
  }

  @Test
  public void AdditionWithZero() {
    double result = additionOperator.operate(5.2, 0.0);
    double expectedResult = 5.2;
    assertTrue(result == expectedResult);
  }
}
