package com.example.tutorial;

import static java.lang.Integer.toHexString;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor sensor;
    private TextView textView;
    private double currentLux;
    private double maxLux;
    private RelativeLayout layout;
    private int tempColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        textView = findViewById(R.id.sensorTextView);
        layout = findViewById(R.id.sensorLayout);


        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener((SensorEventListener) this, sensor, SensorManager.SENSOR_DELAY_FASTEST);


    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if( event.sensor.getType() == Sensor.TYPE_LIGHT)
        {
            currentLux = event.values[0];
            if (currentLux > maxLux)
                maxLux = currentLux;
        }
        textView.setText(currentLux + "");
        try {
            layout.setBackgroundColor(Color.parseColor("#" + toHexString((int) currentLux) + toHexString((int) maxLux) + toHexString((int) (maxLux - currentLux))));

        }catch (Exception e){
            Log.e("#####", e.getStackTrace().toString());
        }//TODO: check hash for existing for this color
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener((SensorEventListener) this);
    }
}