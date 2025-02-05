package calculator.ui;

import calculator.controller.CalculatorController;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ButtonFactory {

  // String[][] buttonLayOut = {
  // { "^", "²√", "C", "*" },
  // { "1", "2", "3", "/" },
  // { "4", "5", "6", "-" },
  // { "7", "8", "9", "+" },
  // { "π", "0", ".", "=" } };

  public static GridPane createButtonGrid(TextField field) {
    GridPane buttonGrid = new GridPane();
    createSymbolInputButtons(buttonGrid, field);
    createOperatorInputButtons(buttonGrid, field);
    return buttonGrid;
  }

  private static void createSymbolInputButtons(GridPane buttonGrid, TextField field) {
    String[][] symbolInputs = {
        { "1", "2", "3" },
        { "4", "5", "6" },
        { "7", "8", "9" },
        { "π", "0", "." } };
    for (int i = 0; i < symbolInputs.length; i++) {
      for (int j = 0; j < symbolInputs[i].length; j++) {
        String symbol = symbolInputs[i][j];
        Button button = new Button(symbol);
        button.setMinSize(50, 50);
        button.setOnAction(event -> CalculatorController.handleSymbolInput(field, symbol));
        buttonGrid.add(button, j, i + 1);
      }
    }
  }

  private static void createOperatorInputButtons(GridPane buttonGrid, TextField field) {
    String[] basicArithmeticOperators = { "*", "/", "-", "+", "=" };
    String[] miscOperators = { "^", "²√", "C" };
    for (int i = 0; i < basicArithmeticOperators.length; i++) {
      String operator = basicArithmeticOperators[i];
      Button button = new Button(operator);
      button.setMinSize(50, 50);
      button.setOnAction(event -> CalculatorController.handleOperatorInput(field, operator));
      buttonGrid.add(button, 3, i);
    }

    for (int i = 0; i < miscOperators.length; i++) {
      String operator = miscOperators[i];
      Button button = new Button(operator);
      button.setMinSize(50, 50);
      button.setOnAction(event -> CalculatorController.handleOperatorInput(field, operator));
      buttonGrid.add(button, i, 0);
    }
  }

}
