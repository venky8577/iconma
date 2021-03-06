package com.example.my_interview_task_websocket.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.my_interview_task_websocket.R;
import com.example.my_interview_task_websocket.activity.EmployeesDetails;
import com.example.my_interview_task_websocket.model.Employee;
import com.example.my_interview_task_websocket.model.Questions;

import java.util.List;

public class QuestionAdapter implements ListAdapter {
    private final String from;
    List<Questions> arrayList;
    Context context;
    public QuestionAdapter(Context context, List<Questions> arrayList,String from) {
        this.arrayList=arrayList;
        this.context=context;
        this.from=from;
    }
    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }
    @Override
    public boolean isEnabled(int position) {
        return true;
    }
    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
    }
    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public boolean hasStableIds() {
        return false;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView =layoutInflater.inflate(R.layout.mylist, null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            TextView titleText = (TextView) convertView.findViewById(R.id.title);
            TextView subtitleText = (TextView) convertView.findViewById(R.id.subtitle);
            Button response = (Button) convertView.findViewById(R.id.response);
            final EditText fNameEdittext = (EditText) convertView.findViewById(R.id.fNameEdittext);
            LinearLayout layout = (LinearLayout) convertView.findViewById(R.id.layout);

            response.setTag(position);

            titleText.setText(arrayList.get(position).getQuestion());
if(arrayList.get(position).getAnswer()!=null )
{
    fNameEdittext.setVisibility(View.GONE);

    subtitleText.setText(arrayList.get(position).getAnswer());
}
else{
    if(from.equals("hr")){
        fNameEdittext.setVisibility(View.VISIBLE);

        response.setVisibility(View.VISIBLE);
    }
    else{
        fNameEdittext.setVisibility(View.GONE);

        response.setVisibility(View.GONE);
    }

}
            response.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = Integer.parseInt(String.valueOf(view.getTag()));
                    fNameEdittext.setVisibility(View.VISIBLE);

//                    Book book = Book.findById(Book.class, 1);
//                    book.title = "updated title here"; // modify the values
//                    book.edition = "3rd edition";
//                    book.save(); /

                    if(!fNameEdittext.getText().toString().equals("")){
                        Questions value = Questions.findById(Questions.class, arrayList.get(pos).getId());
                        value.setAnswer(fNameEdittext.getText().toString());
                        value.save();

                        List<Questions> questions = Questions.listAll(Questions.class);
arrayList = questions;

                        if (context instanceof IMethodCaller) {
                            ((IMethodCaller) context).setadapter();
                        }
                    }
                    else{
                        fNameEdittext.setError("Please enter answer");
                    }

                }
            });

        }
        return convertView;
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @Override
    public int getViewTypeCount() {
        return arrayList.size();
    }
    @Override
    public boolean isEmpty() {
        return false;
    }
}
