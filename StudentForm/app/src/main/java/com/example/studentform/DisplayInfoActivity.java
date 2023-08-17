package com.example.studentform;


// DisplayInfoActivity.java
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayInfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_info);

        // Get student information from the intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String firstName = extras.getString("first_name");
            String lastName = extras.getString("last_name");
            String studentClass = extras.getString("class");
            String rollNumber = extras.getString("roll_number");
            String address = extras.getString("address");
            String gender = extras.getString("gender");

            // Display student information
            TextView tvFullName = findViewById(R.id.tv_full_name);
            tvFullName.setText("Name: " + firstName + " " + lastName);

            TextView tvClassRoll = findViewById(R.id.tv_class_roll);
            tvClassRoll.setText("Class: " + studentClass + ", Roll Number: " + rollNumber);

            TextView tvAddress = findViewById(R.id.tv_address);
            tvAddress.setText("Address: " + address);

            TextView tvGender = findViewById(R.id.tv_gender);
            tvGender.setText("Gender: " + gender);
        }
    }
}

