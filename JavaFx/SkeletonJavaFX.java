import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Pos; // To center the label

public class SkeletonJavaFX extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Control (Label)
        Label label = new Label("Demo text change!");
        label.setStyle("-fx-font-size: 18px; -fx-text-fill: black;"); // Optional styling for the label

        // Layout (HBox with centered content)
        HBox hbox = new HBox(20); // Spacing between components
        hbox.setAlignment(Pos.CENTER); // Center the label horizontally
        hbox.getChildren().add(label);

        // Scene with a fixed size
        Scene scene = new Scene(hbox, 300, 200); // Width: 300px, Height: 200px

        // Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("SkeletonJavaFX");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
