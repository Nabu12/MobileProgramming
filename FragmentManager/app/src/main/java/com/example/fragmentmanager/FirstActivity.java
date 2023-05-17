package com.example.fragmentmanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FirstActivity extends FragmentActivity {
    Button btnFirst, btnSecond;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        btnFirst = findViewById(R.id.btnFirst);
        btnSecond = findViewById(R.id.btnSecond);
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Fragment1();
                FragmentManager manager =fragment.getFragmentManager();

                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.myfragment,fragment);
            }
        });
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Fragment2();
                FragmentManager manager =fragment.getFragmentManager();

                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.myfragment,fragment);
                transaction.replace(R.id.myfragment,fragment);
                transaction.commit();
            }
        });
    }
}
