package com.example.tutorial.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tutorial.ui.MovementView;

public class CircleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MovementView(this));
    }
}