package com.example.fibonacci;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class fibonacci extends Activity {
    TextView fibonaciTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fibonaciTextView=findViewById(R.id.fibonaciTextView);
        int limit=10;

        String fibonacciSeries = getFibonacciSeries(limit);
        fibonaciTextView.setText(fibonacciSeries);
    }

    private String getFibonacciSeries(int limit) {
        StringBuilder sb = new StringBuilder();

        int a = 0, b = 1;

        while (a <= limit) {
            sb.append(a).append(" ");

            int sum = a + b;
            a = b;
            b = sum;
        }

        return sb.toString();


    }
}
