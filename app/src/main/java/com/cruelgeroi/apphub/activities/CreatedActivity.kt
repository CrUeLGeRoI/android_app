package com.cruelgeroi.apphub.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout
import com.cruelgeroi.apphub.R

class CreatedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_created)
        val intent = intent
        val bundle = intent.extras
        val layout = findViewById<RelativeLayout>(R.id.createdActivityLayout)
        if (bundle != null) {
            val color = bundle.getInt("COLOR_OF_ELEMENT")
            layout.setBackgroundColor(color)
        }
        Log.d(TAG, "onCreate: created")
    }

    companion object {
        private const val TAG = "CreatedActivity"
    }
}