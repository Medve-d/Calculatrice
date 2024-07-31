package fr.nikolai.calculatrice;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField display;

    private double num1 = 0;
    private String operator = "";
    private boolean start = true;

    @FXML
    private void processNumbers(javafx.event.ActionEvent event) {
        if (start) {
            display.setText("");
            start = false;
        }

        String value = ((javafx.scene.control.Button) event.getSource()).getText();
        display.setText(display.getText() + value);
    }

    @FXML
    private void processOperators(javafx.event.ActionEvent event) {
        String value = ((javafx.scene.control.Button) event.getSource()).getText();

        if (!value.equals("=")) {
            if (!operator.isEmpty()) return;

            operator = value;
            num1 = Double.parseDouble(display.getText());
            display.setText("");
        } else {
            if (operator.isEmpty()) return;

            double num2 = Double.parseDouble(display.getText());
            double result = calculate(num1, num2, operator);
            display.setText(String.valueOf(result));
            operator = "";
            start = true;
        }
    }

    private double calculate(double a, double b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) return 0;
                return a / b;
            default:
                return 0;
        }
    }

    @FXML
    private void clearDisplay(javafx.event.ActionEvent event) {
        display.setText("");
        operator = "";
        start = true;
    }
}
