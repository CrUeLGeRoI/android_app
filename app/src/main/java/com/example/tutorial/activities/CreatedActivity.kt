package com.example.tutorial.activities;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import com.example.tutorial.R;

public class CreatedActivity extends AppCompatActivity {

    private static final String TAG = "CreatedActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_created);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        RelativeLayout layout = findViewById(R.id.createdActivityLayout);

        if (bundle != null){
            int color = bundle.getInt("COLOR_OF_ELEMENT");
            layout.setBackgroundColor(color);
        }

        Log.d(TAG, "onCreate: created");
    }
}