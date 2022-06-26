package com.cruelgeroi.apphub.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cruelgeroi.apphub.ui.MovementView

class CircleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MovementView(this))
    }
}