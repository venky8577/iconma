package com.example.my_interview_task_websocket.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.my_interview_task_websocket.R;
import com.example.my_interview_task_websocket.model.Employee;

import java.util.List;

public class EmployeeRegisterActivity extends AppCompatActivity {
private EditText fNameEdittext,lNameEdittext,idEdittext;
    private String selectedDepartment="Technical Team";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         fNameEdittext =(EditText)findViewById(R.id.fNameEdittext);
         lNameEdittext =(EditText)findViewById(R.id.lNameEdittext);
         idEdittext =(EditText)findViewById(R.id.idEdittext);
         Button register =(Button)findViewById(R.id.register);
         Button employees =(Button)findViewById(R.id.employees);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapterView.getContext(),
                        "OnItemSelectedListener : " + adapterView.getItemAtPosition(i).toString(),
                        Toast.LENGTH_SHORT).show();
                Log.d("selectedValue",adapterView.getItemAtPosition(i).toString());

                selectedDepartment = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        employees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent i =new Intent(EmployeeRegisterActivity.this,EmployeesList.class);
startActivity(i);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //idEdittext.setText("venky");
                if(!fNameEdittext.getText().toString().equals("")){
                    if(!lNameEdittext.getText().toString().equals("")){
                    if(!idEdittext.getText().toString().equals("")){
                        //Toast.makeText(EmployeeRegisterActivity.this, idEdittext.getText().toString(), Toast.LENGTH_SHORT).show();
                        Log.d("selectedValue",idEdittext.getText().toString());

                        List<Employee> employees = Employee.listAll(Employee.class);
if(employees!=null && employees.size()>0){
    for(Employee emp1: employees) {
        if (emp1.getEid().equals(idEdittext.getText().toString())) {
            Toast.makeText(EmployeeRegisterActivity.this, "Employee id existed", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Employee emp = new Employee();
            emp.setName(fNameEdittext.getText().toString());
            emp.setLastName(lNameEdittext.getText().toString());
            emp.setEid(idEdittext.getText().toString());
            if (selectedDepartment != null)
                emp.setTeam(selectedDepartment);
            emp.setId(Long.parseLong(idEdittext.getText().toString()));
            emp.save();


            dialogBox();
            return;
        }
    }
}

                        else{
    Employee emp = new Employee();
    emp.setName(fNameEdittext.getText().toString());
    emp.setLastName(lNameEdittext.getText().toString());
    emp.setEid(idEdittext.getText().toString());
    if (selectedDepartment != null)
        emp.setTeam(selectedDepartment);
    emp.setId(Long.parseLong(idEdittext.getText().toString()));
    emp.save();


    dialogBox();
                        }





                    }
                    else
                    {
                        idEdittext.setError("Please select id");

                    }

                    }
                    else{
                        lNameEdittext.setError("Please select last name");

                    }
                }
                else{
                    fNameEdittext.setError("Please select first name");
                }
            }

            private void dialogBox() {
                // Create the object of
                // AlertDialog Builder class
                AlertDialog.Builder builder
                        = new AlertDialog
                        .Builder(EmployeeRegisterActivity.this);

                // Set the message show for the Alert time
                builder.setMessage("Employee Added");

                // Set Alert Title
                builder.setTitle("");

                // Set Cancelable false
                // for when the user clicks on the outside
                // the Dialog Box then it will remain show
                builder.setCancelable(false);

                // Set the positive button with yes name
                // OnClickListener method is use of
                // DialogInterface interface.

                builder
                        .setPositiveButton(
                                "Ok",
                                new DialogInterface
                                        .OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which)
                                    {

                                       fNameEdittext.setText("");
                                       lNameEdittext.setText("");
                                       idEdittext.setText("");
                                       dialog.cancel();
                                       //finish();
                                    }
                                });

                // Create the Alert dialog
                AlertDialog alertDialog = builder.create();

                // Show the Alert Dialog box
                alertDialog.show();
            }
        });


    }
}
