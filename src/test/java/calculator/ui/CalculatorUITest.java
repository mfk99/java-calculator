package calculator.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class CalculatorUITest extends ApplicationTest {

  private CalculatorUI ui = new CalculatorUI();
  private Parent rootNode;

  @Override
  public void start(Stage stage) {
    ui.start(stage);
  }

  @BeforeEach
  public void setUp() {
    rootNode = ui.getScene().getRoot();
  }

  @Test
  public void TextFieldIsVisible() {
    TextField field = from(rootNode).lookup(".text-field").queryAs(TextField.class);
    assertTrue(field.isVisible());
  }

  @Test
  public void TextFieldCanBeWrittenTo() {
    TextField field = from(rootNode).lookup(".text-field").queryAs(TextField.class);
    String expression = "1 + 1";
    field.appendText(expression);
    String insertedValue = field.getText();
    assertEquals(expression, insertedValue);
  }

  @Test
  public void TextFieldUpdatesToResult() {
    TextField field = from(rootNode).lookup(".text-field").queryAs(TextField.class);
    String expression = "1 + 1";
    field.appendText(expression);
    Button button = from(rootNode).lookup("=").queryAs(Button.class);
    clickOn(button);
    String expectedValue = "2";
    String result = field.getText();
    assertEquals(expectedValue, result);
  }

  @Test
  public void InputButtonsFunctionCorrectly() {
    TextField field = from(rootNode).lookup(".text-field").queryAs(TextField.class);
    Button nineButton = from(rootNode).lookup("9").queryAs(Button.class);
    Button exponentButton = from(rootNode).lookup("^").queryAs(Button.class);
    Button twoButton = from(rootNode).lookup("2").queryAs(Button.class);
    Button equalsButton = from(rootNode).lookup("=").queryAs(Button.class);
    clickOn(nineButton);
    clickOn(exponentButton);
    clickOn(twoButton);
    clickOn(equalsButton);
    String expectedValue = "81";
    String result = field.getText();
    assertEquals(expectedValue, result);
  }

  @Test
  public void ErrorMessageDeliveredCorrectly() {
    TextField field = from(rootNode).lookup(".text-field").queryAs(TextField.class);
    Button zeroButton = from(rootNode).lookup("0").queryAs(Button.class);
    Button sqrtButton = from(rootNode).lookup("²√").queryAs(Button.class);
    Button oneButton = from(rootNode).lookup("1").queryAs(Button.class);
    Button equalsButton = from(rootNode).lookup("=").queryAs(Button.class);
    clickOn(zeroButton);
    clickOn(sqrtButton);
    clickOn(sqrtButton);
    clickOn(oneButton);
    clickOn(equalsButton);
    String expectedValue = "ERR";
    String result = field.getText();
    assertEquals(expectedValue, result);
  }

}
