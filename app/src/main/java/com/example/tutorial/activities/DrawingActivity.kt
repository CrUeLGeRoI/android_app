package com.example.tutorial.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tutorial.ui.DrawView

class DrawingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(DrawView(this))
    }
}