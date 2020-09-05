package com.example.my_interview_task_websocket.adapter;

import android.app.Activity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.my_interview_task_websocket.R;
import com.example.my_interview_task_websocket.model.Employee;

import java.util.List;

public class MyListAdapter extends ArrayAdapter<Employee> {

    private final Activity context;
    private final List<Employee> employees;


    public MyListAdapter(Activity context, List<Employee> employees) {
        super(context, R.layout.mylist);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.employees=employees;

    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.subtitle);
        LinearLayout layout = (LinearLayout) rowView.findViewById(R.id.layout);

        layout.setTag(position);

        titleText.setText(employees.get(position).getName());

        subtitleText.setText(employees.get(position).getEid());

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = (int) view.getTag();

                Employee selectedEmp = employees.get(pos);

                Log.d("selectedEmp",selectedEmp.getName());
            }
        });

        return rowView;

    };
}