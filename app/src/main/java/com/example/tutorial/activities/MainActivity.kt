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
    private var mIntent:Intent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initializing

        textView = findViewById(R.id.hello_world)
        currentLayout = findViewById(R.id.main_layout)

        insert()
        select()
        //end
    }

    fun onClickBtn(v: View?) {
        when(v?.id){
            R.id.button -> {
                mIntent = Intent(".FileActivity")
                startActivity(mIntent)
            }
            R.id.button2 -> {
                mIntent = Intent(".SensorActivity")
                startActivity(mIntent)
            }
            R.id.button3 -> {
                mIntent = Intent(".FragmentActivity")
                startActivity(mIntent)
            }
            R.id.button4 -> {
                mIntent = Intent(".DrawingActivity")
                startActivity(mIntent)
            }
            R.id.button5 -> {
                mIntent = Intent(".CircleActivity")
                startActivity(mIntent)
            }
            R.id.button6 -> {
                mIntent = Intent(".CalculatorActivity")
                startActivity(mIntent)
            }
            R.id.button7 -> {
                mIntent = Intent(".RecyclerActivity")
                startActivity(mIntent)
            }
            R.id.button8 -> {
                textView!!.text = "8"
                currentLayout?.setBackgroundResource(R.color.yellow)
            }
        }
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