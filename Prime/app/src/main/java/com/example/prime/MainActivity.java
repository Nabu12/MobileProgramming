package com.example.prime;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText numberEditText;
    private Button checkButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_number);

        numberEditText = findViewById(R.id.numberEditText);
        checkButton = findViewById(R.id.check_button);
        resultTextView = findViewById(R.id.result_text);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputString = numberEditText.getText().toString();

                try {
                    int number = Integer.parseInt(inputString);
                    boolean isPrime = isPrimeNumber(number);

                    if (isPrime) {
                        resultTextView.setText(number + " is a prime number");
                    } else {
                        resultTextView.setText(number + " is not a prime number");
                    }
                } catch (NumberFormatException e) {
                    resultTextView.setText("Invalid input");
                }
            }
        });
    }

    private boolean isPrimeNumber(int number) {
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
