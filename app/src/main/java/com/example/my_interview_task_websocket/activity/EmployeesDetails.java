package com.example.my_interview_task_websocket.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.my_interview_task_websocket.R;
import com.example.my_interview_task_websocket.adapter.CustomAdapter;
import com.example.my_interview_task_websocket.adapter.IMethodCaller;
import com.example.my_interview_task_websocket.adapter.QuestionAdapter;
import com.example.my_interview_task_websocket.model.Employee;
import com.example.my_interview_task_websocket.model.Questions;

import java.util.ArrayList;
import java.util.List;

public class EmployeesDetails extends AppCompatActivity implements IMethodCaller {
    private Employee employee;
    private ListView list;
    private EditText fNameEdittext;
    private TextView question;
    ArrayList<Questions> que;
    private List<Questions> allQuestions;
    private List<Questions> questions =new ArrayList<>();
    private String from;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emplye_detail);
         employee = (Employee) getIntent().getSerializableExtra("selectedEmp");
         allQuestions = Questions.listAll(Questions.class);
         from = getIntent().getStringExtra("from");

        TextView titleText = (TextView) findViewById(R.id.title);
        TextView subtitleText = (TextView) findViewById(R.id.subtitle);
         question = (TextView) findViewById(R.id.question);
        Button askQuestion = (Button) findViewById(R.id.askQuestion);
         fNameEdittext = (EditText) findViewById(R.id.fNameEdittext);
         list=(ListView)findViewById(R.id.list);

        fNameEdittext.setVisibility(View.GONE);
        question.setVisibility(View.GONE);
        if(from.equals("hr")){
for(int i=0;i<allQuestions.size();i++){
    if(allQuestions.get(i).getEid().equals(employee.getEid())){
        questions.add(allQuestions.get(i));
    }
}

            if(questions!=null&&questions.size()>0){
                QuestionAdapter adapter=new QuestionAdapter(this, questions,from);
                list.setAdapter(adapter);
            }
            fNameEdittext.setVisibility(View.GONE);
            askQuestion.setVisibility(View.GONE);
            question.setVisibility(View.GONE);
        }
        else{

fromEmployee();

        }
if(employee.getName()!=null)
        titleText.setText(employee.getName());
        if(employee.getLastName()!=null)
        subtitleText.setText(employee.getLastName());



        askQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
if(!fNameEdittext.getText().toString().equals("")){

    Questions value = new Questions();
    value.setQuestion(fNameEdittext.getText().toString());
    value.setEid(employee.getEid());
    value.save();
    List<Questions> temp = new ArrayList<>();
    questions =new ArrayList<>();
     allQuestions = Questions.listAll(Questions.class);
    for(int i=0;i<allQuestions.size();i++){
        if(allQuestions.get(i).getEid().equals(employee.getEid())){
            questions.add(allQuestions.get(i));
        }
    }
    if(questions!=null&&questions.size()>0){
        QuestionAdapter adapter = new QuestionAdapter(EmployeesDetails.this, questions,from);
        list.setAdapter(adapter);
    }

}
else{
    fNameEdittext.setError("Please enter question");

}

                List<Employee> employees = Employee.listAll(Employee.class);
                Log.d("saved Value", String.valueOf(employees.get(0).getName()));
            }
        });

    }

     public void setadapter() {
         questions =new ArrayList<>();

         allQuestions = Questions.listAll(Questions.class);
         for(int i=0;i<allQuestions.size();i++){
             if(allQuestions.get(i).getEid().equals(employee.getEid())){
                 questions.add(allQuestions.get(i));
             }
         }
         if(questions!=null&&questions.size()>0){
            QuestionAdapter adapter=new QuestionAdapter(this, questions,from);
            list.setAdapter(adapter);
        }
    }

    private void fromEmployee() {
        questions =new ArrayList<>();

        for(int i=0;i<allQuestions.size();i++){
            if(allQuestions.get(i).getEid().equals(employee.getEid())){
                questions.add(allQuestions.get(i));
            }
        }
        if(questions!=null&&questions.size()>0){
            QuestionAdapter adapter=new QuestionAdapter(this, questions,from);
            list.setAdapter(adapter);
        }
        fNameEdittext.setVisibility(View.VISIBLE);
        question.setVisibility(View.VISIBLE);
    }


}
