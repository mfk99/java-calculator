package calculator.ui;

import javafx.application.Application;
import javafx.scene.Scene;
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

    GridPane buttonGrid = ButtonFactory.createButtonGrid(field);
    root.add(buttonGrid, 0, 1, 4, 4);
    Scene scene = new Scene(root, 200, 300);
    primaryStage.setTitle("Java Calculator");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void launchUI(String[] args) {
    launch(args);
  }
}
