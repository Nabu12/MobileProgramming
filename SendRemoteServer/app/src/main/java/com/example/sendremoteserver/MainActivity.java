package com.example.sendremoteserver;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText Name, Email;
    String server_url = "http://192.168.1.181/Mobileprogramming/user_data.php"; // Remove the space in the URL
    AlertDialog.Builder builder;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        Name = findViewById(R.id.name1);
        Email = findViewById(R.id.email1);
        builder = new AlertDialog.Builder(MainActivity.this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name, email;
                name = Name.getText().toString();
                email = Email.getText().toString();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        builder.setTitle("Server Response");
                        builder.setMessage("Response: " + response);
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Name.setText("");
                                Email.setText("");
                            }
                        });

                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Some error found...", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> Params = new HashMap<>();
                        Params.put("name", name);
                        Params.put("email", email);
                        return Params;
                    }
                };
                Mysingleton.getInstance(MainActivity.this).addTorequestque(stringRequest);
            }
        });
    }
}
