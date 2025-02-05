package calculator.ui;

import calculator.logic.CalculatorController;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * A factory class for creating buttons for the calculator UI.
 * 
 * @see CalculatorUI
 * @see CalculatorController
 * @see TextField
 * @see Button
 * @see GridPane
 * @see javafx.scene.layout.GridPane
 * @see javafx.scene.control.TextField
 * @see javafx.scene.control.Button
 */
public class ButtonFactory {

  /**
   * Creates a grid of buttons for the calculator UI.
   * 
   * The complete button grid consists of the following buttons:
   * [^, ²√, C, *]
   * [1, 2, 3, /]
   * [4, 5, 6, -]
   * [7, 8, 9, +]
   * [π, 0, ., =]
   * 
   * @param field The text field where the input is displayed
   * @return a complete grid of buttons
   */
  public static GridPane createButtonGrid(TextField field) {
    GridPane buttonGrid = new GridPane();
    createSymbolInputButtons(buttonGrid, field);
    createOperatorInputButtons(buttonGrid, field);
    return buttonGrid;
  }

  /**
   * Creates the symbol input buttons for the calculator UI.
   * 
   * @param buttonGrid The grid where the buttons are added
   * @param field      The text field where the input is displayed
   */
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

  /**
   * Creates the operator input buttons for the calculator UI.
   * 
   * @param buttonGrid The grid where the buttons are added
   * @param field      The text field where the input is displayed
   */
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
