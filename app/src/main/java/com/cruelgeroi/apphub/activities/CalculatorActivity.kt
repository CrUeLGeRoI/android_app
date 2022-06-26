package com.cruelgeroi.apphub.activities

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.content.ContextCompat
import android.text.TextUtils
import android.util.Log
import android.widget.*
import com.cruelgeroi.apphub.R

class CalculatorActivity : AppCompatActivity() {

    private var mRadioGroup: RadioGroup? = null
    private var editTextFirstNum: EditText? = null
    private var editTextSecondNum: EditText? = null
    private var calculateResult: Button? = null
    private var resultTextView: TextView? = null

    private var operation = '0'




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        var counter: Short = 0


        mRadioGroup = findViewById(R.id.operationsRadioGroup)
        mRadioGroup?.setOnCheckedChangeListener { _, optionId ->
            run {
                counter++
                when (optionId) {
                    R.id.radioButtonPlus -> operation = '+'
                    R.id.radioButtonMinus -> operation = '-'
                    R.id.radioButtonDivide -> operation = '/'
                    R.id.radioButtonMultiply -> operation = '*'
                }
            }
        }

        editTextFirstNum = findViewById(R.id.editTextFirstNum)
        editTextSecondNum = findViewById(R.id.editTextSecondNum)


        calculateResult = findViewById(R.id.buttonCalculateResult)
        resultTextView = findViewById(R.id.resultTextView)


        when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_YES -> resultTextView?.setTextColor(ContextCompat.getColor(applicationContext, R.color.white))
            Configuration.UI_MODE_NIGHT_NO -> {}
        }

        calculateResult?.setOnClickListener{
            if (TextUtils.isEmpty(editTextFirstNum?.text.toString()) || TextUtils.isEmpty(editTextSecondNum?.text.toString())) {
                Toast.makeText(applicationContext, "One of numbers is null.", Toast.LENGTH_SHORT).show()
            }
            else if (editTextSecondNum?.text.toString().toFloat() == 0f && operation == '/') {
                Toast.makeText(applicationContext, "Can\'t divide by zero", Toast.LENGTH_SHORT).show()
            }
            else if (counter.toInt() == 0) {
                Toast.makeText(applicationContext, "Didn\'t chose an operation", Toast.LENGTH_SHORT).show()
            }
            else {
                Thread(object : Runnable {
                    var isPrime = false
                    override fun run() {
                        val firstNum: Float = editTextFirstNum?.text.toString().toFloat()
                        val secondNum: Float = editTextSecondNum?.text.toString().toFloat()
                        val res: Float = getCalculatedResult(firstNum, secondNum, operation)
                        if (res % 1 == 0f) {
                            isPrime = true
                        }
                        Handler(Looper.getMainLooper()).post {
                            if (isPrime) {
                                val resLong = res.toLong()
                                Log.d("####", resLong.toString())
                                resultTextView?.text = resLong.toString() + ""
                                isPrime = false
                            } else {
                                Log.d("####", res.toString())
                                resultTextView?.text = res.toString() + ""
                            }
                        }
                    }
                }).run()
            }
        }
    }



    private fun getCalculatedResult(a: Float, b: Float, operation: Char): Float {
        var result = 0f
        when (operation) {
            '+' -> result = a + b
            '-' -> result = a - b
            '/' -> result = a / b
            '*' -> result = a * b
        }
        return result
    }
}