package com.example.oddeven;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputNumber;
    private Button checkButton;
    private Button resetButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.input_number);
        checkButton = findViewById(R.id.check_button);
        resetButton = findViewById(R.id.reset_button);
        resultText = findViewById(R.id.result_text);

        checkButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.check_button) {
            String inputString = inputNumber.getText().toString();

            if (!inputString.isEmpty()) {
                int number = Integer.parseInt(inputString);

                if (number % 2 == 0) {
                    resultText.setText(number + " is even.");
                } else {
                    resultText.setText(number + " is odd.");
                }
            } else {
                resultText.setText("Please enter a number.");
            }
        } else if (v.getId() == R.id.reset_button) {
            inputNumber.setText("");
            resultText.setText("");
        }
    }
}
