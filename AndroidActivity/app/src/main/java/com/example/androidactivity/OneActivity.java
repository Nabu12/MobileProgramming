package com.example.androidactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class OneActivity extends AppCompatActivity {
    TextView question1;
    Button next_Activity_button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        next_Activity_button=(Button) findViewById(R.id.first_activity_button);
        question1=(TextView) findViewById(R.id.question_id);
        question1.setText("Q 1-How to pass the data between activities in Android?\n"
        +"\n"
        +"Ans-Intent");
        next_Activity_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent=new Intent (OneActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
