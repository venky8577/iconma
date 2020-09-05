package com.example.my_interview_task_websocket.ui.login;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my_interview_task_websocket.activity.EmployeeRegisterActivity;
import com.example.my_interview_task_websocket.R;
import com.example.my_interview_task_websocket.activity.EmployeesDetails;
import com.example.my_interview_task_websocket.model.Employee;

import java.util.List;

public class LoginActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);




        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Employee> employees = Employee.listAll(Employee.class);


                if(usernameEditText.getText().toString().equals("hr")&& passwordEditText.getText().toString().equals("123")){

                    Intent i= new Intent (LoginActivity.this, EmployeeRegisterActivity.class);
                    startActivity(i);
                }
                else{
                    if(employees.size()>0){
                        if(usernameEditText.getText().toString()!=""){
                            if(passwordEditText.getText().toString()!="") {
                                for(Employee emp: employees){
                                    if(emp.getName().equals(usernameEditText.getText().toString()) && emp.getEid().equals(passwordEditText.getText().toString())){
                                        Intent i= new Intent (LoginActivity.this, EmployeesDetails.class);
                                        Bundle bundle = new Bundle();
                                        bundle.putSerializable("selectedEmp",emp);
                                        i.putExtra("from","employee");
                                        i.putExtras(bundle);
                                        startActivity(i);
                                        return;
                                    }
                                }
                            }
                            else{
                                passwordEditText.setError("please enter user name");

                            }
                        }
                        else{
                            usernameEditText.setError("please enter user name");
                        }
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Not Registered with us", Toast.LENGTH_SHORT).show();

                    }
                }




            }
        });
    }

}
