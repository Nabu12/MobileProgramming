package com.example.datareceivingfromremoteserver;
import android.annotation.SuppressLint;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class MainActivity extends AppCompatActivity {
    Button  displayButton;
    TextView dataTextView;
    String server_url = "http://192.168.1.181/Mobileprogramming/retrieve_data.php"; // Remove the space in the URL

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayButton = findViewById(R.id.displayButton);
        dataTextView = findViewById(R.id.dataTextView);

        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.GET, server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONArray jsonArray = new JSONArray(response);

                                    // Clear the dataDisplay StringBuilder before appending new data
                                    StringBuilder dataDisplay = new StringBuilder();

                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                                        String name = jsonObject.getString("name");
                                        String email = jsonObject.getString("email");
                                        dataDisplay.append("Name: ").append(name).append(", Email: ").append(email).append("\n");
                                    }

                                    dataTextView.setText(dataDisplay.toString());

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Toast.makeText(MainActivity.this, "Error parsing JSON", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Some error found...", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                });

                Mysingleton.getInstance(MainActivity.this).addTorequestque(stringRequest);
            }
        });

    }
}
