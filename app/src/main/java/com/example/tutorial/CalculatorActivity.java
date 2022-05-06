package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {



    private EditText editTextFirstNum, editTextSecondNum;
    private RadioButton plus, minus, divide, multiply;
    private Button calculate_result;
    private TextView resultTextView;
    private Handler handler;
    private char operation;
    private short counter;
    private final float TEXT_SIZE = 0f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);



        editTextFirstNum = findViewById(R.id.editTextFirstNum);
        editTextSecondNum = findViewById(R.id.editTextSecondNum);

        plus = findViewById(R.id.radioButtonPlus);
        plus.setOnClickListener(radioButtonClickListener);

        minus = findViewById(R.id.radioButtonMinus);
        minus.setOnClickListener(radioButtonClickListener);


        divide = findViewById(R.id.radioButtonDivide);
        divide.setOnClickListener(radioButtonClickListener);


        multiply = findViewById(R.id.radioButtonMultiply);
        multiply.setOnClickListener(radioButtonClickListener);


        calculate_result = findViewById(R.id.buttonCalculateResult);


        resultTextView = findViewById(R.id.resultTextView);

        handler = new Handler();

        switch (getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) {
            case Configuration.UI_MODE_NIGHT_YES:
                resultTextView.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                break;
            case Configuration.UI_MODE_NIGHT_NO:
                break;
        }




        calculate_result.setOnClickListener(v -> {
            Toast toast;
            if (TextUtils.isEmpty(editTextFirstNum.getText().toString()) || TextUtils.isEmpty(editTextSecondNum.getText().toString())){
                toast = Toast.makeText(getApplicationContext(), "One of numbers is null.", Toast.LENGTH_SHORT);
                toast.show();
            }
            else if (Float.parseFloat(editTextSecondNum.getText().toString()) == 0f && operation == '/'){
                toast = Toast.makeText(getApplicationContext(), "Can\'t divide by zero", Toast.LENGTH_SHORT);
                toast.show();
            }
            else if (counter == 0){
                toast = Toast.makeText(getApplicationContext(), "Didn\'t chose an operation", Toast.LENGTH_SHORT);
                toast.show();
            }
            else {
                counter = 1;
                new Thread(new Runnable() {
                    boolean isPrime = false;
                    @Override
                    public void run() {
                        float first_num, second_num, res;


                        first_num = Float.parseFloat(editTextFirstNum.getText().toString());
                        second_num = Float.parseFloat(editTextSecondNum.getText().toString());

                        res = getCalculatedResult(first_num, second_num, operation);
                        if (res % 1 == 0){
                            isPrime = true;
                        }


                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (isPrime){
                                    long resLong = (long) res;
                                    Log.d("####", String.valueOf(resLong));
                                    resultTextView.setText(resLong + "");
                                    isPrime = false;
                                }
                                else {
                                    Log.d("####", String.valueOf(res));
                                    resultTextView.setText(res + "");
                                }
                            }
                        });
                    }
                }).run();
            }

        });


    }

    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            counter++;
            RadioButton rb = (RadioButton) v;
            switch (rb.getId()) {
                case R.id.radioButtonPlus: operation = '+';
                    break;
                case R.id.radioButtonMinus: operation = '-';
                    break;
                case R.id.radioButtonDivide: operation = '/';
                    break;
                case R.id.radioButtonMultiply: operation = '*';
                    break;
                default:
                    break;
            }
        }
    };


    private float getCalculatedResult(float a, float b, char operation) {
        float result = 0f;

        switch (operation){
            case '+': result = a + b;
                break;
            case '-': result = a - b;
                break;
            case '/': result = a / b;
                break;
            case '*': result = a * b;
                break;
        }
        return result;
    }
}