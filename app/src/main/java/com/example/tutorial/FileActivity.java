package com.example.tutorial;

import static java.lang.Thread.State.NEW;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.math.BigInteger;

public class FileActivity extends AppCompatActivity {
    private Button button;
    private ProgressBar progressBar;
    private EditText editText;
    private TextView textView;
    private BigInteger res;
    private FloatingActionButton transition;
    private short threadsNeededToBeCreated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        button = findViewById(R.id.calc_btn);
        progressBar = findViewById(R.id.progress_bar);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.result_view);

        textView.setMovementMethod(new ScrollingMovementMethod());



        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String editTextResult = editText.getText().toString();
                int editTextResultInt = Integer.parseInt(editTextResult);
                //TODO: HANDLER как только хэндлер выполнит часть работы с факториалом то он добавит этот результат в бигинтеджер
                res = getFactorial(editTextResultInt);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.INVISIBLE);
                        textView.setText(res + "");
                    }
                });
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                if (thread.getState() == NEW){
                    thread.start();
                }
                else{
                    thread.run();
                }
            }
        });
    }
    public static BigInteger getFactorial(int f) {
        BigInteger result = new BigInteger("1");
        BigInteger bigInteger = new BigInteger("1");
        for (int i = 1; i <= f; i++) {
            bigInteger = new BigInteger(i + "");
            result = result.multiply(new BigInteger(i + ""));
        }
        return result;
    }
}
