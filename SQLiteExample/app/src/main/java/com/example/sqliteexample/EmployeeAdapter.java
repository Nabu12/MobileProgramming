package com.example.sqliteexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    List<EmployeeModel> employee;
    Context context;
    DatabaseHelper databaseHelper;

    public EmployeeAdapter(List<EmployeeModel> employee, Context context) {
        this.employee = employee;
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.employee_item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final EmployeeModel employeeModel = employee.get(position);
        holder.TextViewID.setText(Integer.toString(employeeModel.getId()));
        holder.editText_Name.setText(employeeModel.getName());
        holder.editText_Email.setText(employeeModel.getEmail());

        // Set click listeners for the edit and delete buttons
        holder.button_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle edit button click
                // You can implement the edit functionality here
            }
        });

        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle delete button click
                // You can implement the delete functionality here
            }
        });
    }

    @Override
    public int getItemCount() {
        return employee.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView TextViewID;
        EditText editText_Name;
        EditText editText_Email;
        Button button_edit;
        Button button_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TextViewID = itemView.findViewById(R.id.text_id);
            editText_Name = itemView.findViewById(R.id.edittext_name);
            editText_Email = itemView.findViewById(R.id.edittext_email);
            button_edit = itemView.findViewById(R.id.button_edit);
            button_delete = itemView.findViewById(R.id.button_delete);
        }
    }
}
