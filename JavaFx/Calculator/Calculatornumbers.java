package Calculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculatornumbers extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Label
        Label label = new Label("Calculate two numbers");

        // TextFields for input
        TextField textfieldOne = new TextField();
        textfieldOne.setPromptText("Enter first number");

        TextField textFieldTwo = new TextField();
        textFieldTwo.setPromptText("Enter second number");

        // Label to show the result
        Label resultLabel = new Label();

        // Buttons to perform the calculation
        Button addbtn = new Button("ADD");
        Button subBtn = new Button("SUB");
        Button multbtn = new Button("MULT");
        Button divbtn = new Button("DIV");

        // Button event handlers for operations
        addbtn.setOnAction(e -> performCalculation("ADD", textfieldOne, textFieldTwo, resultLabel));
        subBtn.setOnAction(e -> performCalculation("SUB", textfieldOne, textFieldTwo, resultLabel));
        multbtn.setOnAction(e -> performCalculation("MULT", textfieldOne, textFieldTwo, resultLabel));
        divbtn.setOnAction(e -> performCalculation("DIV", textfieldOne, textFieldTwo, resultLabel));

        // Layout using VBox (vertical layout) for text fields and result
        VBox vbox = new VBox(5, label, textfieldOne, textFieldTwo, resultLabel);
        vbox.setStyle("-fx-padding: 20px;");

        // HBox layout for buttons (horizontal layout for operation buttons)
        HBox hbox = new HBox(5, addbtn, subBtn, multbtn, divbtn);
        hbox.setStyle("-fx-padding: 20px;");

        // Combine VBox and HBox into the main layout
        VBox mainLayout = new VBox(5, vbox, hbox);
        mainLayout.setStyle("-fx-padding: 20px;");

        // Scene
        Scene scene = new Scene(mainLayout, 400, 300);

        // Set the window title
        primaryStage.setTitle("Calculator");

        // Make the window resizable
        primaryStage.setResizable(true);

        // Set the scene and show the stage
        primaryStage.setScene(scene);

        // Center the window on the screen
        primaryStage.centerOnScreen();

        primaryStage.show();
    }

    private void performCalculation(String operation, TextField textfieldOne, TextField textFieldTwo, Label resultLabel) {
        try {
            double num1 = Double.parseDouble(textfieldOne.getText());
            double num2 = Double.parseDouble(textFieldTwo.getText());
            double result = 0;
            String resultText = "";

            switch (operation) {
                case "ADD":
                    result = num1 + num2;
                    resultText = "Result: " + result;
                    break;
                case "SUB":
                    result = num1 - num2;
                    resultText = "Result: " + result;
                    break;
                case "MULT":
                    result = num1 * num2;
                    resultText = "Result: " + result;
                    break;
                case "DIV":
                    if (num2 != 0) {
                        result = num1 / num2;
                        resultText = "Result: " + result;
                    } else {
                        resultText = "Cannot divide by zero.";
                    }
                    break;
                default:
                    resultText = "Please select an operation.";
            }

            resultLabel.setText(resultText);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid numbers.");
        }
    }
}
