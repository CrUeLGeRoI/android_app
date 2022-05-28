package com.example.tutorial.activities

import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial.ui.ColorsOfRainbowAdapter.OnAdapterClickListener
import com.example.tutorial.ColorsOfRainbow
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.os.Bundle
import com.example.tutorial.R
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tutorial.ui.ColorsOfRainbowAdapter
import androidx.recyclerview.widget.DefaultItemAnimator
import android.content.ContentValues
import android.content.Intent
import android.util.Log
import com.example.tutorial.activities.CreatedActivity
import java.util.ArrayList

class RecyclerActivity : AppCompatActivity(), OnAdapterClickListener {

    private var colorsOfRainbowArrayList: ArrayList<ColorsOfRainbow>? = null
    private var recyclerView: RecyclerView? = null
    private var numTextView: TextView? = null
    private var colorNameTextView: TextView? = null
    private val numbers = shortArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    private val colorsName = arrayOf(
        "Красный",
        "Желтый",
        "Синий",
        "Зеленый",
        "Серый",
        "Фиолетовый",
        "Бирюзовый",
        "Белый"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val colors = intArrayOf(
            ContextCompat.getColor(this, R.color.red),
            ContextCompat.getColor(this, R.color.yellow),
            ContextCompat.getColor(this, R.color.blue),
            ContextCompat.getColor(this, R.color.green),
            ContextCompat.getColor(this, R.color.grey),
            ContextCompat.getColor(this, R.color.purple),
            ContextCompat.getColor(this, R.color.teal_700),
            ContextCompat.getColor(this, R.color.white)
        )

        recyclerView = findViewById(R.id.recyclerView)
        numTextView = findViewById(R.id.numTextView)
        colorNameTextView = findViewById(R.id.colorNameTextView)
        colorsOfRainbowArrayList = ArrayList()

        for (i in 0..7) {
            colorsOfRainbowArrayList!!.add(ColorsOfRainbow(numbers[i], colorsName[i], colors[i]))
        }

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        val adapter = ColorsOfRainbowAdapter(colorsOfRainbowArrayList!!, this)

        recyclerView?.layoutManager = layoutManager
        recyclerView?.itemAnimator = DefaultItemAnimator()
        recyclerView?.adapter = adapter
    }

    override fun onAdapterClick(position: Int) {
        Log.d(ContentValues.TAG, "onAdapterClick: clicked")
        val intent = Intent(this, CreatedActivity::class.java)
        intent.putExtra("COLOR_OF_ELEMENT", colorsOfRainbowArrayList!![position].color)
        startActivity(intent)
    }
}