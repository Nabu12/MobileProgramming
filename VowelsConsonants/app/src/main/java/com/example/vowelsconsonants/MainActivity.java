package com.example.vowelsconsonants;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String inputString = "Hello, World!";
        TextView vowelsTextView = findViewById(R.id.vowelsTextView);
        TextView consonantsTextView = findViewById(R.id.consonantsTextView);

        // Convert input string to lowercase
        inputString = inputString.toLowerCase();

        // Initialize variables to hold vowels and consonants
        String vowels = "";
        String consonants = "";

        // Iterate over each character in the input string
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);

            // Check if character is a vowel
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels += c;
            }
            // Check if character is a consonant
            else if (c >= 'b' && c <= 'z') {
                consonants += c;
            }
        }

        // Display the vowels and consonants in separate text views
        vowelsTextView.setText(vowels);
        consonantsTextView.setText(consonants);
    }
}
