package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    private EditText inputText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        inputText = findViewById(R.id.inputText);
    }

    public void helloWorldBtnPressed(View view){
        textView.setText(inputText.getText().toString());
    }
    public void goToCalculatorBtnPressed(View view){
        startActivity(new Intent(MainActivity.this, MainActivityCalculator.class));
    }
    public void goToListBtnPressed(View view){
        startActivity(new Intent(MainActivity.this, MainActivityListView.class));
    }
}