package com.example.androidmydiet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class AddListActivity extends AppCompatActivity {
    Button btnCreate;
    EditText editText;
    TaskDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);
        btnCreate = findViewById(R.id.btnCreate);
        editText = findViewById(R.id.editText);
        db = Room.databaseBuilder(getApplicationContext(),
                TaskDatabase.class, "database-name").build();
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... voids) {

                        @SuppressLint("WrongThread") Task task = new Task(String.valueOf(editText.getText()));
                        db.taskDao().insert(task);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(AddListActivity.this, ListActivity.class);
                                startActivity(intent);
                            }
                        });

                        return null;
                    }
                }.execute();
            }
        });


    }
}
