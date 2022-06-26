package com.cruelgeroi.apphub.activities

import android.graphics.Color
import android.hardware.Sensor
import androidx.appcompat.app.AppCompatActivity
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.widget.TextView
import android.widget.RelativeLayout
import android.os.Bundle
import android.hardware.SensorEvent
import android.util.Log
import com.cruelgeroi.apphub.R

class SensorActivity : AppCompatActivity(), SensorEventListener {
    private var sensorManager: SensorManager? = null
    private var sensor: Sensor? = null
    private var textView: TextView? = null
    private var currentLux = 0.0
    private var maxLux = 0.0
    private var layout: RelativeLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor)
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        textView = findViewById(R.id.sensorTextView)

        layout = findViewById(R.id.sensorLayout)

        sensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_LIGHT)

        sensorManager!!.registerListener(this as SensorEventListener, sensor, SensorManager.SENSOR_DELAY_FASTEST)
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type == Sensor.TYPE_LIGHT) {
            currentLux = event.values[0].toDouble()
            if (currentLux > maxLux) maxLux = currentLux
        }
        var color = "#" + Integer.toHexString(currentLux.toInt()) + Integer.toHexString(maxLux.toInt()) + Integer.toHexString((Math.random() * 100).toInt())
        Log.d("####", color)
        if (color.length == 7) {
            layout!!.setBackgroundColor(Color.parseColor(color))
        } else if (color.length > 7) {
            val decimal = color.length - 7
            color = color.substring(0, color.length - decimal)
            layout!!.setBackgroundColor(Color.parseColor(color))
        }
        textView!!.text = currentLux.toString() + ""
    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}
    override fun onPause() {
        super.onPause()
        sensorManager!!.unregisterListener(this as SensorEventListener)
    }
}