package com.example.palindromecheckerapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button checkButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        checkButton = findViewById(R.id.checkButton);
        resultTextView = findViewById(R.id.resultTextView);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString();

                if (TextUtils.isEmpty(input)) {
                    resultTextView.setText("Please enter a value");
                    return;
                }

                String reversed = new StringBuilder(input).reverse().toString();

                if (input.equalsIgnoreCase(reversed)) {
                    resultTextView.setText("Palindrome");
                } else {
                    resultTextView.setText("Not a palindrome");
                }
            }
        });
    }
}
