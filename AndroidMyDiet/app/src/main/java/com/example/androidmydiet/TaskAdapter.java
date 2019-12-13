package com.example.androidmydiet;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {
    List<Task> listTask = new ArrayList();
    OnItemListener listener;

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout,parent,false);
        return new TaskHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
        Task task = listTask.get(position);
        holder.txt_task.setText(task.getContent());
    }

    @Override
    public int getItemCount() {
        return listTask.size();
    }

    class TaskHolder extends RecyclerView.ViewHolder{
        TextView txt_task;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);
            txt_task = itemView.findViewById(R.id.txt_task);
        }
    }

    interface OnItemListener {
        void onDeleteClicked(int position);
    }


}
