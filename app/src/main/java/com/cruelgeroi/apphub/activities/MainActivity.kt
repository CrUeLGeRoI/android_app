package com.cruelgeroi.apphub.activities

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.LinearLayout
import android.os.Bundle
import android.content.Intent
import android.view.View
import com.cruelgeroi.apphub.R

class MainActivity : AppCompatActivity() {

    private var textView: TextView? = null
    private var currentLayout: LinearLayout? = null
    private var mIntent:Intent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initializing

        textView = findViewById(R.id.hello_world)
        currentLayout = findViewById(R.id.main_layout)

    }

    fun onClickBtn(v: View?) {
        when(v?.id){
            R.id.button -> {
                startSelectedActivity(".FileActivity")
            }
            R.id.button2 -> {
                startSelectedActivity(".SensorActivity")
            }
            R.id.button3 -> {
                startSelectedActivity(".FragmentActivity")
            }
            R.id.button4 -> {
                startSelectedActivity(".DrawingActivity")
            }
            R.id.button5 -> {
                startSelectedActivity(".CircleActivity")
            }
            R.id.button6 -> {
                startSelectedActivity(".CalculatorActivity")
            }
            R.id.button7 -> {
                startSelectedActivity(".RecyclerActivity")
            }
            R.id.button8 -> {
                startSelectedActivity(".DatabaseActivity")
            }
        }
    }

    private fun startSelectedActivity(selectedIntent: String){
        mIntent = Intent(selectedIntent)
        startActivity(mIntent)
    }
}