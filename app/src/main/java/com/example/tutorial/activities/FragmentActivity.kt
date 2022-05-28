package com.example.tutorial.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.tutorial.R

class FragmentActivity : AppCompatActivity() {
    private var buttonBlack: Button? = null
    private var buttonCat: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        buttonBlack = findViewById(R.id.blank_fragment_button)
        buttonCat = findViewById(R.id.cat_fragment_button)
    }
}