package ReverseString;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ReverseString extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Controls
        Label resultLabel = new Label("Enter a string to reverse:");
        TextField inputField = new TextField();
        inputField.setPromptText("Enter a string");

        Button reverseButton = new Button("Reverse String");

        // Event handler for button click
        reverseButton.setOnAction(e -> {
            try {
                // Get the input string
                String inputString = inputField.getText();

                // Reverse the string using a loop
                String reversedString = reverse(inputString);

                // Display the reversed string
                resultLabel.setText("Reversed String: " + reversedString);
            } catch (Exception ex) {
                resultLabel.setText("Error reversing string.");
            }
        });

        // Layout
        StackPane root = new StackPane();
        root.getChildren().addAll(inputField, reverseButton, resultLabel);

        // Scene setup
        Scene scene = new Scene(root, 500, 300);

        // Position controls
        inputField.setTranslateY(-50);
        reverseButton.setTranslateY(0);
        resultLabel.setTranslateY(50);

        // Stage setup
        primaryStage.setScene(scene);
        primaryStage.setTitle("String Reversal");
        primaryStage.show();
    }

    // Method to reverse a string using a loop
    private String reverse(String input) {
        String reversed = "";
        // Loop through the string in reverse order
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        return reversed;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
