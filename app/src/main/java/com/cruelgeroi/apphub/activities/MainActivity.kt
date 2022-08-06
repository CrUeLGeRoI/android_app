package com.cruelgeroi.apphub.activities

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.LinearLayout
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Toolbar
import com.cruelgeroi.apphub.R

class MainActivity : AppCompatActivity() {

    private lateinit var mIntent:Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initializing
        var toolbar:androidx.appcompat.widget.Toolbar? = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
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