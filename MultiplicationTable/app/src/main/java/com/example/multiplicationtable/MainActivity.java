package com.example.multiplicationtable;


import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView multiplicationTableTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        multiplicationTableTextView =findViewById(R.id.multiplication_table_text_view);

        // Generate the multiplication table and set it to the TextView
        String multiplicationTable = generateMultiplicationTable();
        multiplicationTableTextView.setText(multiplicationTable);
    }

    private String generateMultiplicationTable() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                int result = i * j;
                sb.append(i).append(" x ").append(j).append(" = ").append(result).append("\n");
            }
            sb.append("\n"); // Add a newline after each row
        }

        return sb.toString();
    }
}
