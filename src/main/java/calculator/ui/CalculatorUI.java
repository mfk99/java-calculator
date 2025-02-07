package calculator.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * A class for the calculator UI.
 * 
 * @see javafx.application.Application
 * @see javafx.stage.Stage
 * @see javafx.scene.Scene
 * @see javafx.scene.layout.GridPane
 * @see javafx.scene.control.TextField
 */
public class CalculatorUI extends Application {

  /**
   * The scene which is shown in the UI.
   * Required for testFX.
   */
  private Scene scene;

  /**
   * Starts the JavaFX UI.
   * 
   * @param primaryStage the primary stage for the application
   */
  @Override
  public void start(Stage primaryStage) {

    GridPane root = new GridPane();

    TextField field = new TextField();
    field.setMinSize(200, 50);
    root.add(field, 0, 0, 4, 1);

    GridPane buttonGrid = ButtonFactory.createButtonGrid(field);
    root.add(buttonGrid, 0, 1, 4, 4);
    scene = new Scene(root, 200, 300);
    primaryStage.setTitle("Java Calculator");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * Returns the scene which is shown in the UI.
   * Availability is required for testFX.
   */
  public Scene getScene() {
    return scene;
  }
}
