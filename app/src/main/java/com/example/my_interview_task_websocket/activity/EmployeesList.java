package com.example.my_interview_task_websocket.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.my_interview_task_websocket.R;
import com.example.my_interview_task_websocket.adapter.CustomAdapter;
import com.example.my_interview_task_websocket.adapter.MyListAdapter;
import com.example.my_interview_task_websocket.model.Employee;

import java.util.List;

public class EmployeesList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_emplyees);
        ListView list=(ListView)findViewById(R.id.list);
        TextView value=(TextView)findViewById(R.id.value);
        List<Employee> employees = Employee.listAll(Employee.class);
       // Log.d("saved Value", String.valueOf(employees.get(0).getName()));

       if(employees.size()>0){
           value.setVisibility(View.GONE);
           CustomAdapter adapter=new CustomAdapter(this, employees);
           list.setAdapter(adapter);
       }
       else{
           value.setVisibility(View.VISIBLE);
           value.setText("No employees added");

       }

    }



}
