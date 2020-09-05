package com.example.departlibrary;

import android.util.Log;

import java.util.List;

public class EmployeeRegister {
    public static void employeeRegister(String userName, String selectedDepartment,String idEdittext){
                    //Toast.makeText(EmployeeRegisterActivity.this, idEdittext.getText().toString(), Toast.LENGTH_SHORT).show();


                            Employee emp = new Employee();
                            emp.setName(userName);
                            emp.setEid(idEdittext);
                            if (selectedDepartment != null)
                                emp.setTeam(selectedDepartment);
                            emp.setId(Long.parseLong(idEdittext));
                            emp.save();
                    }

                    public static List<Employee> getEmployees(){
                        List<Employee> employees = Employee.listAll(Employee.class);
return employees;
                    }
}
