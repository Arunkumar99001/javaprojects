package HelloWorld;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a Label with border around text
        Label label = new Label("Hello, JavaFX!");
        label.setStyle("-fx-border-color: black; -fx-padding: 10;");

        // Create a layout container (StackPane)
        StackPane root = new StackPane();
        root.getChildren().add(label);  // Add label to the layout

        // Set the background color of the layout container (StackPane)
        root.setStyle("-fx-background-color: lightblue;");

        // Create a Scene and set the root container (StackPane)
        Scene scene = new Scene(root, 300, 250);

        // Set the stage (window) title and scene
        primaryStage.setTitle("JavaFX Hello World!");
        primaryStage.setScene(scene);

        // Show the stage (window)
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
