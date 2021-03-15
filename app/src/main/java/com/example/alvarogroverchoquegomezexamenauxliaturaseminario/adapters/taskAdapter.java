package com.example.alvarogroverchoquegomezexamenauxliaturaseminario.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.alvarogroverchoquegomezexamenauxliaturaseminario.R;

import java.util.ArrayList;

public class taskAdapter extends BaseAdapter {
    private ArrayList<structTask> listTasks;
    private Context contextM;

    public taskAdapter(ArrayList<structTask> data, Context contextM) {
        listTasks = data;
        this.contextM = contextM;
    }

    @Override
    public int getCount() {
        return listTasks.size();
    }

    @Override
    public Object getItem(int position) {
        return listTasks.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(contextM).inflate(R.layout.itemtask,null);
        TextView taskTitle = (TextView) view.findViewById(R.id.taskTitle);
        TextView taskDescription = (TextView) view.findViewById(R.id.taskDescription);
        taskTitle.setText(listTasks.get(i).getTitle());
        taskDescription.setText(listTasks.get(i).getDescription()+" bs");
        return view;
    }
}
