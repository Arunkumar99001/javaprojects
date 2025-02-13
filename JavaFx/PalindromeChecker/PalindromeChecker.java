package PalindromeChecker;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PalindromeChecker extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Control for the label to show instructions
        Label instructionLabel = new Label("Enter a string to check if it is a palindrome:");

        // TextField to input the string
        TextField inputField = new TextField();
        inputField.setPromptText("Enter a string");

        // Label to show the result (whether the input is a palindrome or not)
        Label resultLabel = new Label();

        // Button to check if the input string is a palindrome
        Button checkButton = new Button("Check Palindrome");

        // Button action to check if the string is a palindrome
        checkButton.setOnAction(e -> {
            // Get the string entered by the user
            String input = inputField.getText().replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // Remove non-alphanumeric characters and convert to lowercase
            String reversed = new StringBuilder(input).reverse().toString();  // Reverse the input string

            // Check if the original string is equal to the reversed string
            if (input.equals(reversed)) {
                resultLabel.setText(input + " is a palindrome.");
            } else {
                resultLabel.setText(input + " is not a palindrome.");
            }
        });

        // Layout for the controls
        StackPane root = new StackPane();
        root.getChildren().addAll(instructionLabel, inputField, checkButton, resultLabel);

        // Adjust positions of the controls to make them look neat
        inputField.setTranslateY(-50);
        checkButton.setTranslateY(50);
        resultLabel.setTranslateY(100);

        // Scene setup
        Scene scene = new Scene(root, 500, 300);

        // Stage setup
        primaryStage.setScene(scene);
        primaryStage.setTitle("Palindrome Checker");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
