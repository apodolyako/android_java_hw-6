package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Notes note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNote();
    }

    private void initNote() {
        Notes note1 = new Notes("20.06.2021", "Решение для дз5", "Какая-то запись");
        Notes note2 = new Notes("23.06.2021", "Список дел на завтра", "Какая-то запись");
        Notes note3 = new Notes("27.06.2021", "Решение для дз5", "Какая-то запись");
        Notes note4 = new Notes("27.06.2021", "Решение для дз5", "Какая-то запись");
        Notes note5 = new Notes("27.06.2021", "Решение для дз5", "Какая-то запись");

    }
}