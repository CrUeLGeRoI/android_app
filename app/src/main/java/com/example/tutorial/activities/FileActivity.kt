package com.example.tutorial.activities;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.example.tutorial.R;

import java.math.BigInteger;

public class FileActivity extends AppCompatActivity {
    private Button button;
    private ProgressBar progressBar;
    private EditText editText;
    private TextView textView;
    private BigInteger res;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        button = findViewById(R.id.calc_btn);
        progressBar = findViewById(R.id.progress_bar);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.result_view);

        textView.setMovementMethod(new ScrollingMovementMethod());

        handler = new Handler();



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String prevEditTextResult = "";
                        String editTextResult = editText.getText().toString();
                        textView.setText("");

                        if(prevEditTextResult == editTextResult){
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    Toast toast;
                                    progressBar.setVisibility(View.VISIBLE);
                                    toast = Toast.makeText(getBaseContext(), "Already calculated this number", Toast.LENGTH_SHORT);
                                    toast.show();
                                }
                            });
                        }
                        else prevEditTextResult = editTextResult;

                        int editTextResultInt = Integer.parseInt(editTextResult);

                        res = getFactorial(editTextResultInt);

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setVisibility(View.INVISIBLE);
                                textView.setText(res.toString());
                            }
                        });
                    }
                }).run();
            }
        });
    }
    public static BigInteger getFactorial(int f) {
        BigInteger result = new BigInteger("1");
        BigInteger bigInteger;
        for (int i = 1; i <= f; i++) {
            bigInteger = new BigInteger(i + "");
            result = result.multiply(bigInteger);
        }
        return result;
    }
}
