package com.example.recyclerview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView courseRV;
    // ArrayList for storing data
    private ArrayList<CourseModel> courseModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courseRV = findViewById(R.id.idRVCourse);
        // Create a new ArrayList and add data to it.
        courseModelArrayList = new ArrayList<>();
        courseModelArrayList.add(new CourseModel("Java", 4, R.drawable.java_p));
        courseModelArrayList.add(new CourseModel("HTML", 3, R.drawable.html));
        courseModelArrayList.add(new CourseModel("C++ Course", 4, R.drawable.c_plus_plus));
        courseModelArrayList.add(new CourseModel("C#", 4, R.drawable.csharp));
        courseModelArrayList.add(new CourseModel("CSS", 4, R.drawable.css));
        courseModelArrayList.add(new CourseModel("C Language", 4, R.drawable.c_language));

        // Initialize the adapter and pass the ArrayList to it.
        CourseAdapter courseAdapter = new CourseAdapter(this, courseModelArrayList);

        // Set a LinearLayoutManager for the RecyclerView.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        courseRV.setLayoutManager(linearLayoutManager);

        // Set the adapter to the RecyclerView.
        courseRV.setAdapter(courseAdapter);
    }
}
