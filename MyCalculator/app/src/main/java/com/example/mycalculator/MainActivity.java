package com.example.mycalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MainActivity extends Activity implements View.OnClickListener {

    Button zero, one, two, three, four, five, six, seven, eight, nine;

    Button ac, equals, dot, plus, minus, multiply, divide, opBr, clBr;

    TextView solutionView;

    String SolutionText = "0";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        solutionView = findViewById(R.id.solution_tv);

        zero = (Button) findViewById(R.id.button_0);
        one = (Button) findViewById(R.id.button_1);
        two = (Button) findViewById(R.id.button_2);
        three = (Button) findViewById(R.id.button_3);
        four = (Button) findViewById(R.id.button_4);
        five = (Button) findViewById(R.id.button_5);
        six = (Button) findViewById(R.id.button_6);
        seven = (Button) findViewById(R.id.button_7);
        eight = (Button) findViewById(R.id.button_8);
        nine = (Button) findViewById(R.id.button_9);

        ac = (Button) findViewById(R.id.button_ac);
        equals = (Button) findViewById(R.id.button_equals);
        dot = (Button) findViewById(R.id.button_dot);
        plus = (Button) findViewById(R.id.button_plus);
        minus = (Button) findViewById(R.id.button_minus);
        multiply = (Button) findViewById(R.id.button_multiply);
        divide = (Button) findViewById(R.id.button_divide);
        opBr = (Button) findViewById(R.id.button_open_bracket);
        clBr = (Button) findViewById(R.id.button_close_bracket);

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);

        ac.setOnClickListener(this);
        equals.setOnClickListener(this);
        dot.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        opBr.setOnClickListener(this);
        clBr.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        switch (v.getId()) {
            case R.id.button_ac:
                SolutionText = "0";
                break;
            case R.id.button_equals:
                try{
                    SolutionText = Double.toString(Evaluate.eval(SolutionText));
                }catch (Exception e){
                    SolutionText = "Syntax Err";
                }
                break;
            default:
                if (SolutionText == "0"){
                    SolutionText = "";
                }
                SolutionText += btn.getText().toString();
                break;
        }
        solutionView.setText(SolutionText);
    }

}
