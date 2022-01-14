package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private RelativeLayout currentLayout;
    private Button button1, button2, button3, button4, button5, button6, button7, button8, transition;
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
        transition = findViewById(R.id.transition_button);

        //Layouts
        currentLayout = findViewById(R.id.main_layout);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(button1.getText());
                currentLayout.setBackgroundResource(R.color.black);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(button2.getText());
                currentLayout.setBackgroundResource(R.color.orange_yellow);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(button3.getText());
                Log.i("blue_button", "Button BLUE pressed");
                currentLayout.setBackgroundResource(R.color.blue);

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(button4.getText());
                currentLayout.setBackgroundResource(R.color.green);

            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(button5.getText());
                currentLayout.setBackgroundResource(R.color.purple_200);

            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(button6.getText());
                currentLayout.setBackgroundResource(R.color.red);

            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(button7.getText());
                currentLayout.setBackgroundResource(R.color.orange);

            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(button8.getText());
                currentLayout.setBackgroundResource(R.color.yellow);

            }
        });
        transition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(".FileActivity");
                startActivity(intent);
            }
        });
        Gen gen = new Gen(5, 759867894783946.87436784668);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(gen.sum());
        Log.i("###Gen", arrayList.toString());

        //end
    }


    public void reset(View view) {
        currentLayout = (RelativeLayout) findViewById(R.id.main_layout);
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