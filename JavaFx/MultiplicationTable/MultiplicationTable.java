package MultiplicationTable;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MultiplicationTable extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Label to display the multiplication table
        Label tableLabel = new Label();

        // Generate the multiplication table and store it as a string
        StringBuilder table = new StringBuilder();
        for (int i = 1; i <= 10; i++) {  // Outer loop for rows (1 to 10)
            for (int j = 1; j <= 10; j++) {  // Inner loop for columns (1 to 10)
                table.append(i * j).append("\t");  // Multiply and add to the table
            }
            table.append("\n");  // New line after each row
        }

        // Set the table as the text for the label
        tableLabel.setText(table.toString());

        // Layout
        StackPane root = new StackPane();
        root.getChildren().add(tableLabel);

        // Scene setup
        Scene scene = new Scene(root, 400, 400);

        // Stage setup
        primaryStage.setScene(scene);
        primaryStage.setTitle("Multiplication Table");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
