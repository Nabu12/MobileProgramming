package com.example.androidactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
public class SecondActivity extends AppCompatActivity {
    TextView question2;
    Button next_button, previous_button;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        next_button = (Button)findViewById(R.id.second_activity_next_button);
        previous_button = (Button)findViewById(R.id.second_activity_previous_button);
        question2 = (TextView)findViewById(R.id.question2_id);
        question2.setText("Q 2 - What is ADB in android?\n"
                + "\n"
                + "Ans- Android Debug Bridge");
        View.OnClickListener onClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        };
        next_button.setOnClickListener (new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
        previous_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(SecondActivity.this, OneActivity.class);
                startActivity(intent);
            }
        });
    }
}



