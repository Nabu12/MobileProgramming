package com.nischalstha9.lab10passingdatabetweenintent;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.annotation.Nullable;

public class form extends Activity {
    Button submitBtn;
    EditText FullName;
    RadioGroup GenderGroup;
    RadioButton Gender;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.form);

        Spinner spinner = (Spinner) findViewById(R.id.select);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.selectItems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        submitBtn = (Button)findViewById(R.id.submitBtn);
        FullName = (EditText)findViewById(R.id.fullnameInput);
        GenderGroup = (RadioGroup) findViewById(R.id.GenderrdGroup);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = FullName.getText().toString();
                int SelectedGenderId = GenderGroup.getCheckedRadioButtonId();
                Gender = (RadioButton) findViewById(SelectedGenderId);
                String gender = Gender.getText().toString();
                Intent report = new Intent(getApplicationContext(), report.class);
                report.putExtra("FullName", name);
                report.putExtra("Gender", gender);
                startActivity(report);
            }
        });

    }
}
