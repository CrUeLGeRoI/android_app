package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
            textView.setText(button5.getText());
            currentLayout.setBackgroundResource(R.color.purple_200);

        });
        button6.setOnClickListener(v -> {
            textView.setText(button6.getText());
            currentLayout.setBackgroundResource(R.color.red);

        });
        button7.setOnClickListener(v -> {
            textView.setText(button7.getText());
            currentLayout.setBackgroundResource(R.color.orange);

        });
        button8.setOnClickListener(v -> {
            textView.setText(button8.getText());
            currentLayout.setBackgroundResource(R.color.yellow);

        });

        //end
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