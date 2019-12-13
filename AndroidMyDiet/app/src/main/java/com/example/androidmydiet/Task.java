package com.example.androidmydiet;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Task {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String content;

    public Task (String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}