package com.example.prime;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputNumber;
    private Button checkButton;

    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_number);

        inputNumber = findViewById(R.id.input_number);
        checkButton = findViewById(R.id.check_button);
        resultText = findViewById(R.id.result_text);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = Integer.parseInt((inputNumber.getText().toString()));
                if(isPrime(number)) {
                    resultText.setText(number + "is a prime number");
                }else {
                    resultText.setText(number+" is not prime number");
                }
                }
            });
        }
        public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for (int i=2;i<= Math.sqrt(n);i++){
            if (n%i==0){
                return  false;
            }
            }
            return true;
    }
}





