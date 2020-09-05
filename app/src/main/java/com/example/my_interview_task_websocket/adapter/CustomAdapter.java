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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.my_interview_task_websocket.R;
import com.example.my_interview_task_websocket.activity.EmployeesDetails;
import com.example.my_interview_task_websocket.model.Employee;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapter implements ListAdapter {
    List<Employee> arrayList;
    Context context;
    public CustomAdapter(Context context, List<Employee> arrayList) {
        this.arrayList=arrayList;
        this.context=context;
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
            Button questions = (Button) convertView.findViewById(R.id.questions);
            LinearLayout layout = (LinearLayout) convertView.findViewById(R.id.layout);
            questions.setVisibility(View.VISIBLE);
            layout.setTag(position);
            questions.setTag(position);

            titleText.setText(arrayList.get(position).getName());

            subtitleText.setText(arrayList.get(position).getEid());



            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = Integer.parseInt(String.valueOf(view.getTag()));
                    Employee selectedEmp = arrayList.get(pos);

                    Log.d("selectedEmp",selectedEmp.getName());
                    Intent i =new Intent(context, EmployeesDetails.class);
                    i.putExtra("from","hr");
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("selectedEmp",selectedEmp);
                    i.putExtras(bundle);
                    context.startActivity(i);

                }
            });

            questions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = Integer.parseInt(String.valueOf(view.getTag()));
                    Employee selectedEmp = arrayList.get(pos);

                    Log.d("selectedEmp",selectedEmp.getName());
                    Intent i =new Intent(context, EmployeesDetails.class);
                    i.putExtra("from","hr");
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("selectedEmp",selectedEmp);
                    i.putExtras(bundle);
                    context.startActivity(i);

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
