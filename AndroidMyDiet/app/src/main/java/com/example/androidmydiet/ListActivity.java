package com.example.androidmydiet;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;

public class ListActivity extends AppCompatActivity {
    TaskDatabase db;
    RecyclerView recyclerView;
    TaskAdapter adapter;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        db = Room.databaseBuilder(getApplicationContext(),
                TaskDatabase.class, "database-name").build();

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, AddListActivity.class);
                startActivity(intent);
            }
        });

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                final List<Task> tasks = db.taskDao().getAll();
                Log.i("Tags", "size "+tasks.size() );

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        display(tasks);
                    }
                });
                return null;
            }
        }.execute();

    }

    public  void display(List<Task> tasks){
        recyclerView = findViewById(R.id.re_task);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new TaskAdapter();
        adapter.listTask = tasks;
        recyclerView.setAdapter(adapter);

    }
}
