package code.maman13.ex2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController  {
    // initial values
    Float firstValue = 0f;
    int operation = -1;

    @FXML
    private Button minus;

    @FXML
    private Button nine;

    @FXML
    private Button mult;

    @FXML
    private Button one;

    @FXML
    private TextField display;

    @FXML
    private Button clear;

    @FXML
    private Button six;
    
    @FXML
    private Button seven;

    @FXML
    private Label label;

    @FXML
    private Button two;

    @FXML
    private Button three;

    @FXML
    private Button plus;

    @FXML
    private Button eight;

    @FXML
    private Button zero;

    @FXML
    private Button div;

    @FXML
    private Button four;

    @FXML
    private Button equals;

    @FXML
    private Button five;

    @FXML
    void handleButtonAction(ActionEvent event) {
        // numbers choise
        if (event.getSource() == one) {
            display.setText(display.getText() + "1");
        } else if (event.getSource() == two) {
            display.setText(display.getText() + "2");
        } else if (event.getSource() == three) {
            display.setText(display.getText() + "3");
        } else if (event.getSource() == four) {
            display.setText(display.getText() + "4");
        } else if (event.getSource() == five) {
            display.setText(display.getText() + "5");
        } else if (event.getSource() == six) {
            display.setText(display.getText() + "6");
        } else if (event.getSource() == seven) {
            display.setText(display.getText() + "7");
        } else if (event.getSource() == eight) {
            display.setText(display.getText() + "8");
        } else if (event.getSource() == nine) {
            display.setText(display.getText() + "9");
        } else if (event.getSource() == zero) {
            display.setText(display.getText() + "0");
        } else if (event.getSource() == clear) {
            display.setText("");

        // operation
        } else if (event.getSource() == plus) {
            firstValue = Float.parseFloat(display.getText());
            operation = 1; // Addition
            display.setText("");
        } else if (event.getSource() == minus) {
            firstValue = Float.parseFloat(display.getText());
            operation = 2; // Substraction
            display.setText("");
        } else if (event.getSource() == mult) {
            firstValue = Float.parseFloat(display.getText());
            operation = 3; // Mul
            display.setText("");
        } else if (event.getSource() == div) {
            firstValue = Float.parseFloat(display.getText());
            operation = 4; // Division
            display.setText("");
        } else if (event.getSource() == equals) {
            // perform operation

            Float secondValue = Float.parseFloat(display.getText());
            switch (operation) {
                case 1: // Addition
                    Float ans = firstValue + secondValue;
                    display.setText(String.valueOf(ans));
                    break;
                case 2: // Subtraction
                    ans = firstValue - secondValue;
                    display.setText(String.valueOf(ans));
                    break;
                case 3: // Mul
                    ans = firstValue * secondValue;
                    display.setText(String.valueOf(ans));
                    break;
                case 4: // Div
                    ans = 0f;
                    try {
                        ans = firstValue / secondValue;
                    } catch (Exception e) {
                        display.setText("Division by zero");
                    }
                    display.setText(String.valueOf(ans));
                    break;
            }
        }
    }


}
