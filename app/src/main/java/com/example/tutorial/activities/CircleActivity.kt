package com.example.tutorial.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tutorial.ui.MovementView

class CircleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MovementView(this))
    }
}