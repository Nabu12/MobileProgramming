package com.example.multiplicationtable;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class Multiple extends Activity {
    Button genBtn;
    EditText num;
    TextView result;
    String resultValue = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiple);

        genBtn = (Button) findViewById(R.id.genBtn);
        num = (EditText) findViewById(R.id.number);
        result = (TextView) findViewById(R.id.result);

        genBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int number = Integer.parseInt(num.getText().toString());
                    for (int i = 1; i <= 20; i++) {
                        String str = number + " X " + i + " = " + (number * i) + "\n";
                        resultValue += str;
                    }
                    result.setText(resultValue);
                }catch (Exception e){
                    Toast.makeText(Multiple.this, "Enter Valid Number input", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
