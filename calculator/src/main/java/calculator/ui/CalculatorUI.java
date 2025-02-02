package calculator.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CalculatorUI extends Application {

  @Override
  public void start(Stage primaryStage) {

    String[][] buttonLayout = {
        { "^", "√", "C", "*" },
        { "1", "2", "3", "/" },
        { "4", "5", "6", "-" },
        { "7", "8", "9", "+" },
        { "+/-", "0", ".", "=" }
    };
    GridPane root = new GridPane();

    TextField field = new TextField();
    field.setMinSize(200, 50);
    root.add(field, 0, 0, 4, 1);

    GridPane buttonGrid = new GridPane();
    for (int row = 0; row < buttonLayout.length; row++) {
      for (int col = 0; col < buttonLayout[row].length; col++) {
        String label = buttonLayout[row][col];
        Button btn = createButton(label);
        btn.setMinSize(50, 50); // Set button size
        buttonGrid.add(btn, col, row); // Add to GridPane at (col, row)
      }
    }
    root.add(buttonGrid, 0, 1, 4, 4);

    Scene scene = new Scene(root, 200, 300);

    primaryStage.setTitle("Java Calculator");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private Button createButton(String label) {
    Button button = new Button(label);
    button.setOnAction(event -> System.out.println(label));
    return button;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
