package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import java.math.BigInteger;

public class FileActivity extends AppCompatActivity {
    private Button button;
    private ProgressBar progressBar;
    private EditText editText;
    private TextView textView;
    private BigInteger res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        button = findViewById(R.id.calc_btn);
        progressBar = findViewById(R.id.progress_bar);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.result_view);
        textView.setMovementMethod(new ScrollingMovementMethod());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String editTextResult = editText.getText().toString();
                        res = getFactorial(Integer.parseInt(editTextResult.toString()));
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setVisibility(View.GONE);
                                textView.setText(res + "");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }).start();
                progressBar.setVisibility(View.VISIBLE);
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