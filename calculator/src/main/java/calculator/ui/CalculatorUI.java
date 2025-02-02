package calculator.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorUI extends Application {

  @Override
  public void start(Stage primaryStage) {

    GridPane root = new GridPane();

    TextField field = new TextField();
    field.setMinSize(200, 50);
    root.add(field, 0, 0, 4, 1);

    GridPane buttonGrid = createButtonGrid(field);
    root.add(buttonGrid, 0, 1, 4, 4);
    Scene scene = new Scene(root, 200, 300);
    primaryStage.setTitle("Java Calculator");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private GridPane createButtonGrid(TextField field) {
    GridPane buttonGrid = new GridPane();
    createIntegerButtons(buttonGrid, field);
    createOperatorButtons(buttonGrid, field);
    return buttonGrid;
  }

  private void createIntegerButtons(GridPane buttonGrid, TextField field) {
    for (int i = 0; i < 9; i++) {
      int x = i % 3;
      int y = i / 3;
      Button btn = createIntegerInputButton(i + 1, field);
      buttonGrid.add(btn, x, y + 1);
    }
    Button zeroButton = createIntegerInputButton(0, field);
    buttonGrid.add(zeroButton, 1, 4);
  }

  private Button createIntegerInputButton(int num, TextField field) {
    Button button = new Button(Integer.toString(num));
    button.setMinSize(50, 50);
    button.setOnAction(event -> field.appendText(Integer.toString(num)));
    return button;
  }

  private void createOperatorButtons(GridPane buttonGrid, TextField field) {

    String[] operators = { "*", "/", "-", "+" };
    String[] topRowOperators = { "^", "√", "C" };
    String[] bottomRowOperators = { "+/-", ".", "=" };

    int x = 0;
    for (String operator : operators) {
      Button operatorButton = createOperatorInputButton(operator, field);
      buttonGrid.add(operatorButton, 3, x);
      x++;
    }

    int y = 0;
    for (String operator : topRowOperators) {
      Button operatorButton = createOperatorInputButton(operator, field);
      buttonGrid.add(operatorButton, y, 0);
      y++;
    }

    y = 0;
    for (String operator : bottomRowOperators) {
      Button operatorButton = createOperatorInputButton(operator, field);
      buttonGrid.add(operatorButton, y, 4);
      if (operator.equals("+/-")) {
        y++;
      }
      y++;
    }

  }

  private Button createOperatorInputButton(String label, TextField field) {
    Button button = new Button(label);
    button.setMinSize(50, 50);
    button.setOnAction(event -> field.appendText(" " + label + " "));
    return button;
  }

  public static void launchUI(String[] args) {
    launch(args);
  }
}
