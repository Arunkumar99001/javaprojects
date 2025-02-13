package Fibonacci;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Fibonacci extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Control
        Label resultLabel = new Label("Enter a number to calculate Fibonacci:");

        TextField inputField = new TextField();
        inputField.setPromptText("Enter a number");

        Button calculateButton = new Button("Calculate Fibonacci");

        // Event handler for the button
        calculateButton.setOnAction(e -> {
            try {
                // Get the number from the TextField
                int number = Integer.parseInt(inputField.getText());

                // Calculate the Fibonacci sequence
                if (number < 0) {
                    resultLabel.setText("Please enter a positive number.");
                } else {
                    int fibonacci = fibonacci(number);
                    resultLabel.setText("Fibonacci of " + number + " is: " + fibonacci);
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number.");
            }
        });

        // Layout
        StackPane root = new StackPane();
        root.getChildren().addAll(inputField, calculateButton, resultLabel);

        // Scene
        Scene scene = new Scene(root, 500, 300);

        // Position controls
        inputField.setTranslateY(-50);
        calculateButton.setTranslateY(0);
        resultLabel.setTranslateY(50);

        // Stage setup
        primaryStage.setScene(scene);
        primaryStage.setTitle("Fibonacci Calculator");
        primaryStage.show();
    }

    // Method to calculate Fibonacci number
    private int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int a = 0, b = 1;
            for (int i = 2; i <= n; i++) {
                int temp = a + b;
                a = b;
                b = temp;
            }
            return b;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
