package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewEmployeeActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employee);

        recyclerView = findViewById(R.id.recyclerView); // Corrected method name
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        List<EmployeeModel> employeeModels = databaseHelper.getEmployeeList();
        if(employeeModels.size()>0){
            EmployeeAdapter employeeAdapter = new  EmployeeAdapter(employeeModels,ViewEmployeeActivity.this);
            recyclerView.setAdapter(employeeAdapter);

        }else{
            Toast.makeText(this,"There is no employee in the database",Toast.LENGTH_SHORT).show();
        }
    }
}
