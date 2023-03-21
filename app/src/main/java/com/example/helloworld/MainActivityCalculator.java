package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityCalculator extends AppCompatActivity {

    private TextView textView;
    private EditText inputText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculator);
        textView = findViewById(R.id.textViewCalculatorResult);
        inputText = findViewById(R.id.inputTextCalculator);
    }
    public void CalculatorClearBtnPressed(View view) {
        inputText.setText("");
    }

    public void CalculatorNumberBtnPressed(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String currentText = inputText.getText().toString();
        inputText.setText(currentText + buttonText);
    }
    public void CalculatorOperatorBtnPressed(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String currentText = inputText.getText().toString();

        switch (buttonText) {
            case "+":
            case "-":
            case "x":
            case "/":
                inputText.setText(currentText + " " + buttonText + " ");
                break;
            default:
                // Do nothing if button is not an operator
                break;
        }
    }

    public void CalculatorResultEqualsBtnPressed(View view){
        String inputExpression = inputText.getText().toString();
        String[] operands = inputExpression.split(" ");

        if (operands.length != 3) {
            // Invalid expression, handle error
            return;
        }

        double operand1 = Double.parseDouble(operands[0]);
        double operand2 = Double.parseDouble(operands[2]);
        double result = 0.0;

        switch (operands[1]) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "x":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;
            default:
                // Invalid operator, handle error
                return;
        }

        textView.setText(String.valueOf(result));
    }

}