package PrimeNumberChecker;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IsThisPrime extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create Label, TextField, and Button
        Label label = new Label("Prime Number Check");
        TextField textfield = new TextField();
        textfield.setPromptText("Enter a number");

        Button check = new Button("Check");

        // Label to show result
        Label resultLabel = new Label();

        // Event handler for the check button
        check.setOnAction(e -> {
            try {
                int number = Integer.parseInt(textfield.getText());
                String result = isPrime(number) ? "Prime" : "Not Prime";
                resultLabel.setText("Entered number: " + number + " is " + result);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number.");
            }
        });

        // Layout using VBox (vertical layout)
        VBox vbox = new VBox(10, label, textfield, check, resultLabel);
        vbox.setStyle("-fx-padding: 20px;");

        // Scene
        Scene scene = new Scene(vbox, 500, 300);

        // Stage setup
        primaryStage.setScene(scene);
        primaryStage.setTitle("Prime Number Checker");
        primaryStage.show();
    }

    // Method to check if the number is prime
    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
