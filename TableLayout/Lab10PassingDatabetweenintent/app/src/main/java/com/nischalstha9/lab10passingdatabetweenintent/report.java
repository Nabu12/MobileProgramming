package com.nischalstha9.lab10passingdatabetweenintent;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class report extends Activity {
    TextView FullName;
    TextView Gender;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);

        FullName = (TextView)findViewById(R.id.fullNameValueView);
        Gender = (TextView)findViewById(R.id.GenderValueView);
        Intent form = getIntent();
        String fullNameValueSubmitted = getIntent().getStringExtra("FullName");
        String genderValueSubmitted = getIntent().getStringExtra("Gender");
        FullName.setText(fullNameValueSubmitted);
        Gender.setText(genderValueSubmitted);

    }
}

