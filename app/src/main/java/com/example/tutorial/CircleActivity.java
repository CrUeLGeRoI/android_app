package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CircleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MovementView(this));
    }
}