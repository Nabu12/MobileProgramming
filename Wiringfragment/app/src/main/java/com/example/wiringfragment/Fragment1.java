package com.example.wiringfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Fragment1 extends Fragment {
    EditText editFirst,editSecond;
    Button btnCalculate;
    TextView textResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
View view = inflater.inflate(R.layout.fragment1,container,false);
   editFirst =view.findViewById(R.id.editFirst);
   editSecond =view.findViewById(R.id.editSecond);
   btnCalculate=view.findViewById(R.id.btnCalculate);
   textResult =view.findViewById(R.id.textResult);
  btnCalculate.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          int first,second,result;
          first = Integer.parseInt(editFirst.getText().toString());
          second = Integer.parseInt(editSecond.getText().toString());
          result= first+second;
          textResult.setText("Result"+result);
      }
  });
  return  view;
    }
}
