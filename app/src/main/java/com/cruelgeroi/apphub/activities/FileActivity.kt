package com.cruelgeroi.apphub.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.*
import com.cruelgeroi.apphub.R
import java.math.BigInteger

class FileActivity : AppCompatActivity() {
    private var button: Button? = null
    private var progressBar: ProgressBar? = null
    private var editText: EditText? = null
    private var textView: TextView? = null
    private var res: BigInteger? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file)

        button = findViewById(R.id.calc_btn)
        progressBar = findViewById(R.id.progress_bar)
        editText = findViewById(R.id.editText)

        textView = findViewById(R.id.result_view)
        textView?.movementMethod = ScrollingMovementMethod()

        button?.setOnClickListener {
            progressBar?.visibility = View.VISIBLE
            Thread {
                var prevEditTextResult = ""
                var editTextResult = editText?.text.toString()

                textView?.text = ""
                if (prevEditTextResult == editTextResult) {
                    Handler(Looper.getMainLooper()).post {
                        progressBar?.visibility = View.VISIBLE
                        Toast.makeText(applicationContext, "Already calculated this number", Toast.LENGTH_SHORT)
                    }
                } else prevEditTextResult = editTextResult

                var editTextResultInt = editTextResult.toInt()

                res = getFactorial(editTextResultInt)
                Handler(Looper.getMainLooper()).post {
                    progressBar?.visibility = View.INVISIBLE
                    textView?.text = res.toString()
                }
            }.run()
        }

    }

    private fun getFactorial(f: Int): BigInteger {
        var result = BigInteger("1")
        var bigInteger: BigInteger?
        for (i in 1..f) {
            bigInteger = BigInteger(i.toString() + "")
            result = result.multiply(bigInteger)
        }
        return result
    }
}