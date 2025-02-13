package EvenorOdd;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class EvenOrOdd extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Label for title
        Label titleLabel = new Label("Even or Odd Checker");

        // TextField for user to enter a number
        TextField numberInput = new TextField();
        numberInput.setPromptText("Enter a number");
        numberInput.setStyle("-fx-padding: 10px; -fx-font-size: 14px;");

        // Button to trigger the check
        Button checkButton = new Button("Check Even or Odd");
        checkButton.setStyle("-fx-padding: 10px 20px; -fx-font-size: 14px;");
        checkButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");

        // Label to display the result (Even or Odd)
        Label resultLabel = new Label();
        resultLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");


        checkButton.setOnAction(e -> {
            try {
                // Get the number entered in the TextField
                int number = Integer.parseInt(numberInput.getText());

                // Check if the number is even or odd
                if (number % 2 == 0) {
                    resultLabel.setText(number + " is an Even number.");
                } else {
                    resultLabel.setText(number + " is an Odd number.");
                }
            } catch (NumberFormatException ex) {
                // If the input is not a valid number, show error message
                resultLabel.setText("Please enter a valid number.");
            }
        });

        // Layout using VBox (with vertical spacing)
        VBox root = new VBox(20);
        root.setStyle("-fx-background-color: gray");
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(titleLabel, numberInput, checkButton, resultLabel);

        // Scene
        Scene scene = new Scene(root, 500, 400);

        // Stage setup
        primaryStage.setScene(scene);
        primaryStage.setTitle("Even or Odd");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
