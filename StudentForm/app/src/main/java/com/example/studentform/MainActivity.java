package com.example.studentform;

// MainActivity.java
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    private EditText editFirstName, editLastName, editClass, editRollNumber, editAddress;
    private RadioGroup radioGroupGender;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editFirstName = findViewById(R.id.edit_first_name);
        editLastName = findViewById(R.id.edit_last_name);
        editClass = findViewById(R.id.edit_class);
        editRollNumber = findViewById(R.id.edit_roll_number);
        editAddress = findViewById(R.id.edit_address);
        radioGroupGender = findViewById(R.id.radio_group_gender);
        btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Read user input
                String firstName = editFirstName.getText().toString();
                String lastName = editLastName.getText().toString();
                String studentClass = editClass.getText().toString();
                String rollNumber = editRollNumber.getText().toString();
                String address = editAddress.getText().toString();
                String gender = ((RadioButton) findViewById(radioGroupGender.getCheckedRadioButtonId())).getText().toString();

                // Create intent to switch to DisplayInfoActivity
                Intent intent = new Intent(MainActivity.this, DisplayInfoActivity.class);

                // Pass student information to the DisplayInfoActivity
                intent.putExtra("first_name", firstName);
                intent.putExtra("last_name", lastName);
                intent.putExtra("class", studentClass);
                intent.putExtra("roll_number", rollNumber);
                intent.putExtra("address", address);
                intent.putExtra("gender", gender);

                // Start the new activity
                startActivity(intent);
            }
        });
    }
}
