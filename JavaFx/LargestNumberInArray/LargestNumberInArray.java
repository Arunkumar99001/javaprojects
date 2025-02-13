package LargestNumberInArray;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LargestNumberInArray extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Controls
        Label label = new Label("Enter numbers separated by spaces to find the largest one:");
        TextField inputField = new TextField();
        inputField.setPromptText("Enter numbers");

        Button checkButton = new Button("Find Largest");
        Label resultLabel = new Label();

        // Event handler for the button
        checkButton.setOnAction(e -> {
            try {
                // Get input from the user, split it into an array of strings
                String input = inputField.getText();
                String[] inputArray = input.split(" "); // Split by spaces
                int[] numbers = new int[inputArray.length];

                // Convert the array of strings to an array of integers
                for (int i = 0; i < inputArray.length; i++) {
                    numbers[i] = Integer.parseInt(inputArray[i]);
                }

                // Find the largest number in the array
                int largest = numbers[0]; // Assume the first number is the largest initially
                for (int i = 1; i < numbers.length; i++) {
                    if (numbers[i] > largest) {
                        largest = numbers[i];
                    }
                }

                // Display the largest number
                resultLabel.setText("The largest number is: " + largest);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid integers.");
            }
        });

        // Layout
        StackPane root = new StackPane();
        root.getChildren().addAll(label, inputField, checkButton, resultLabel);

        // Adjust positions of the controls to make them look neat
        inputField.setTranslateY(-50);
        checkButton.setTranslateY(100);
        resultLabel.setTranslateY(50);

        // Scene setup
        Scene scene = new Scene(root, 500, 300);

        // Stage setup
        primaryStage.setScene(scene);
        primaryStage.setTitle("Find Largest Number");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
