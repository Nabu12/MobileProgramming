package com.example.fibonacci;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private Button generateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
        generateButton = findViewById(R.id.generateButton);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Generate the Fibonacci series
                int limit = 10; // Change this to the desired limit
                String series = generateFibonacciSeries(limit);

                // Display the Fibonacci series
                resultTextView.setText(series);
            }
        });
    }

    private String generateFibonacciSeries(int limit) {
        StringBuilder series = new StringBuilder();
        int n1 = 0, n2 = 1;

        series.append(n1).append(", "); // Append the first two numbers

        for (int i = 2; i < limit; i++) {
            int next = n1 + n2;
            series.append(next).append(", ");
            n1 = n2;
            n2 = next;
        }

        series.deleteCharAt(series.length() - 2); // Remove the trailing comma and space
        return series.toString();
    }
}
