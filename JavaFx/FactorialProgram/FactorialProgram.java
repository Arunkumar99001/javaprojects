package FactorialProgram;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FactorialProgram extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //-----Control-------
        // Label to show result
        Label resultLabel = new Label("Enter a number to calculate factorial:");

        // TextField to input number
        TextField inputField = new TextField();
        inputField.setPromptText("Enter a number");

        // Button to calculate factorial
        Button calculateButton = new Button("Calculate Factorial");

        // Event handler for the button
        calculateButton.setOnAction(e -> {
            try {
                // Get the number from the TextField
                int number = Integer.parseInt(inputField.getText());

                // Calculate the factorial
                int factorial = 1;
                for (int i = 1; i <= number; i++) {
                    factorial *= i;
                }

                // Display the result
                resultLabel.setText("Factorial of " + number + " is: " + factorial);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number.");
            }
        });

        // ---------------------Layout-------------
        StackPane root = new StackPane();
        root.getChildren().addAll(inputField, calculateButton, resultLabel);

        // -------------------Scene------------------
        Scene scene = new Scene(root, 500, 300);

        // Position the controls better (using VBox or GridPane could help but StackPane will work too)
        inputField.setTranslateY(-50); // Move TextField up a bit
        calculateButton.setTranslateY(0); // Keep the button near the TextField
        resultLabel.setTranslateY(50);  // Move result label down a bit

        // ----------------------------------Stage setup--------------------------------
        primaryStage.setScene(scene);
        primaryStage.setTitle("Factorial Calculator");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
