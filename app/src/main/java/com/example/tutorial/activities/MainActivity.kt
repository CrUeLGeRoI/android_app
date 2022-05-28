package com.example.tutorial.activities

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.LinearLayout
import android.os.Bundle
import com.example.tutorial.R
import android.content.Intent
import android.content.ContentResolver
import android.content.ContentValues
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.tutorial.db.NotesContract

class MainActivity : AppCompatActivity() {
    private var textView: TextView? = null
    private var currentLayout: LinearLayout? = null
    private var button1: Button? = null
    private var button2: Button? = null
    private var button3: Button? = null
    private var button4: Button? = null
    private var button5: Button? = null
    private var button6: Button? = null
    private var button7: Button? = null
    private var button8: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TextViews
        textView = findViewById(R.id.hello_world)

        //Buttons
        button1 = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)

        //Layouts
        currentLayout = findViewById(R.id.main_layout)
        button1?.setOnClickListener {
            val intent = Intent(".FileActivity")
            startActivity(intent)
        }
        button2?.setOnClickListener {
            val intent = Intent(".SensorActivity")
            startActivity(intent)
        }
        button3?.setOnClickListener {
            val intent = Intent(".FragmentActivity")
            startActivity(intent)
        }
        button4?.setOnClickListener {
            val intent = Intent(".DrawingActivity")
            startActivity(intent)
        }
        button5?.setOnClickListener {
            val intent = Intent(".CircleActivity")
            startActivity(intent)
        }
        button6?.setOnClickListener {
            val intent = Intent(".CalculatorActivity")
            startActivity(intent)
        }
        button7?.setOnClickListener {
            val intent = Intent(".RecyclerActivity")
            startActivity(intent)
        }
        button8?.setOnClickListener {
            textView!!.text = button8?.text
            currentLayout?.setBackgroundResource(R.color.yellow)
        }
        insert()
        select()
        //end
    }

    private fun insert() {
        val contentResolver = contentResolver
        val contentValues = ContentValues()
        contentValues.put(NotesContract.Notes.COLUMN_TITLE, "Заголовок заметки")
        contentValues.put(NotesContract.Notes.COLUMN_NOTE, "Текст заметки")
        contentValues.put(NotesContract.Notes.COLUMN_CREATED_TS, System.currentTimeMillis())
        contentValues.put(NotesContract.Notes.COLUMN_UPDATED_TS, System.currentTimeMillis())
        val uri = contentResolver.insert(NotesContract.Notes.URI, contentValues)
        Log.i("DATABASE", "URI: $uri")
    }

    private fun select() {
        val contentResolver = contentResolver
        val cursor = contentResolver.query(
                NotesContract.Notes.URI,  // URI
                NotesContract.Notes.LIST_PROJECTION,  // Столбцы
                null,  // Параметры выборки
                null,  // Аргументы выборки
                null // Сортировка по умолчанию
        )
        Log.i("DATABASE", "Count: " + cursor!!.count)
        cursor.close()
    }

    fun reset(view: View?) {
        currentLayout = findViewById<View>(R.id.main_layout) as LinearLayout
        textView!!.setText(R.string.hello)
        Log.i("Hello_world", "Hello pressed")
        currentLayout!!.setBackgroundResource(R.color.white)
    }

    override fun onStart() {
        super.onStart()
        Log.i("LifeActivity###", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LifeActivity###", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.i("LifeActivity###", "onStop")
        textView!!.text = "World!!!!!!!!"
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("LifeActivity###", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LifeActivity###", "OnCreate")
    }
}