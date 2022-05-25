package com.example.tutorial.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tutorial.ui.DrawView;

public class DrawingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }
}