package com.example.tutorial.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.tutorial.R;

public class FragmentActivity extends AppCompatActivity {
    private Button button_blank, button_cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        button_blank = findViewById(R.id.blank_fragment_button);
        button_cat = findViewById(R.id.cat_fragment_button);
    }
}