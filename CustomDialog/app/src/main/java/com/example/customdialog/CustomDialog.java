package com.example.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class CustomDialog {

    private Context context;
    private Dialog dialog;
    private EditText editTextUsername, editTextPassword;

    public CustomDialog(Context context) {
        this.context = context;
    }

    public void showDialog() {
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setCancelable(false);

        editTextUsername = dialog.findViewById(R.id.username);
        editTextPassword = dialog.findViewById(R.id.password);

        Button buttonCancel = dialog.findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Button buttonSignIn = dialog.findViewById(R.id.buttonSignIn);
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Add your sign-in logic here

                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
