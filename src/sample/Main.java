package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main driver class for RPS
 * @author anagalacticRuby
 */
public class Main extends Application {

  /**
   * The starting method of the program.
   *
   * <p> This method will run upon execution of the program and loads the stage for fx elements.</p>
   *
   * @param primaryStage The initial stage. There only needs to be one!
   * @throws Exception The method will throw an IllegalStateException if the stage is shown on another thread
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 700, 300));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
