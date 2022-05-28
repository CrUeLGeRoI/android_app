package com.example.tutorial.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tutorial.R;
import com.example.tutorial.db.NotesContract;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private LinearLayout currentLayout;
    private Button button1, button2, button3, button4, button5, button6, button7, button8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextViews
        textView = findViewById(R.id.hello_world);

        //Buttons
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);

        //Layouts
        currentLayout = findViewById(R.id.main_layout);

        button1.setOnClickListener(v -> {
            Intent intent = new Intent(".FileActivity");
            startActivity(intent);
        });
        button2.setOnClickListener(v -> {
            Intent intent = new Intent(".SensorActivity");
            startActivity(intent);
        });
        button3.setOnClickListener(v -> {
            Intent intent = new Intent(".FragmentActivity");
            startActivity(intent);
        });
        button4.setOnClickListener(v -> {
            Intent intent = new Intent(".DrawingActivity");
            startActivity(intent);
        });
        button5.setOnClickListener(v -> {
            Intent intent = new Intent(".CircleActivity");
            startActivity(intent);
        });
        button6.setOnClickListener(v -> {
            Intent intent = new Intent(".CalculatorActivity");
            startActivity(intent);
        });
        button7.setOnClickListener(v -> {
            Intent intent = new Intent(".RecyclerActivity");
            startActivity(intent);
        });
        button8.setOnClickListener(v -> {
            textView.setText(button8.getText());
            currentLayout.setBackgroundResource(R.color.yellow);
        });

        insert();
        select();
        //end
    }

    private void insert() {
        ContentResolver contentResolver = getContentResolver();

        ContentValues contentValues = new ContentValues();
        contentValues.put(NotesContract.Notes.COLUMN_TITLE, "Заголовок заметки");
        contentValues.put(NotesContract.Notes.COLUMN_NOTE, "Текст заметки");
        contentValues.put(NotesContract.Notes.COLUMN_CREATED_TS, System.currentTimeMillis());
        contentValues.put(NotesContract.Notes.COLUMN_UPDATED_TS, System.currentTimeMillis());

        Uri uri = contentResolver.insert(NotesContract.Notes.URI, contentValues);
        Log.i("DATABASE", "URI: " + uri);
    }

    private void select() {
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(
                NotesContract.Notes.URI, // URI
                NotesContract.Notes.LIST_PROJECTION, // Столбцы
                null, // Параметры выборки
                null, // Аргументы выборки
                null // Сортировка по умолчанию
        );
        Log.i("DATABASE", "Count: " + cursor.getCount());
        cursor.close();
    }

    public void reset(View view) {
        currentLayout = (LinearLayout) findViewById(R.id.main_layout);
        textView.setText(R.string.hello);
        Log.i("Hello_world", "Hello pressed");
        currentLayout.setBackgroundResource(R.color.white);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LifeActivity###", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LifeActivity###", "onResume");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LifeActivity###", "onStop");
        textView.setText("World!!!!!!!!");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LifeActivity###", "onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LifeActivity###", "OnCreate");
    }

}