package com.example.form;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);
        EditText nameEditText=(EditText) findViewById(R.id.names);
        String names=nameEditText.getText().toString();
        EditText currentWeightEditText=(EditText) findViewById(R.id.current_weight);
        String currentWeight=currentWeightEditText.getText().toString();
        EditText heightEditText = (EditText) findViewById(R.id.height);
        String height = heightEditText.getText().toString();
        EditText goalWeightEditText = (EditText) findViewById(R.id.goal_weight);
        String goal_weight = goalWeightEditText.getText().toString();
        EditText ageEditText = (EditText) findViewById(R.id.age);
        String age = ageEditText.getText().toString();
        EditText phoneEditText = (EditText) findViewById(R.id.names);
        String phone = phoneEditText.getText().toString();
        EditText addressEditText = (EditText) findViewById(R.id.names);
        String address = addressEditText.getText().toString();


    }
    public void radioButtonhandler(View view) {

        // Decide what happens when a user clicks on a button
    }

    public void submitbuttonHandler(View view) {
        //Decide what happens when the user clicks the submit button
    }
}

