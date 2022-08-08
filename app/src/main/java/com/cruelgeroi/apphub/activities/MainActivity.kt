package com.cruelgeroi.apphub.activities

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.cruelgeroi.apphub.R
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {


    private lateinit var mIntent:Intent
    private lateinit var mEditText: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initializing
        val toolbar:androidx.appcompat.widget.Toolbar? = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_activity_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item?.itemId){
            R.id.secret_button -> {
                val dialogFragment = CustomDialogFragment()
                dialogFragment.show(supportFragmentManager, "custom")
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }

    }

    fun onClickBtn(v: View?) {
        when(v?.id){
            R.id.button -> {
                startSelectedActivity(".FileActivity")
            }
            R.id.button2 -> {
                startSelectedActivity(".SensorActivity")
            }
            R.id.button3 -> {
                startSelectedActivity(".FragmentActivity")
            }
            R.id.button4 -> {
                startSelectedActivity(".DrawingActivity")
            }
            R.id.button5 -> {
                startSelectedActivity(".CircleActivity")
            }
            R.id.button6 -> {
                startSelectedActivity(".CalculatorActivity")
            }
            R.id.button7 -> {
                startSelectedActivity(".RecyclerActivity")
            }
            R.id.button8 -> {
                startSelectedActivity(".DatabaseActivity")
            }
        }
    }

    private fun startSelectedActivity(selectedIntent: String){
        mIntent = Intent(selectedIntent)
        startActivity(mIntent)
    }

    class CustomDialogFragment : DialogFragment() {
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val requiredPassword:String? = getString(R.string.secret_password)
            val mIntent = Intent(".SecretActivity")

            val builder = AlertDialog.Builder(activity, R.style.AlertDialogTheme)
            val inflater = requireActivity().layoutInflater

            val dialogView = inflater.inflate(R.layout.dialog_secret, null)
            val passwordEditText = dialogView.findViewById<TextInputEditText>(R.id.secret_password_et)

            return builder
                .setTitle(R.string.secret_dialog_title)
                .setView(dialogView)
                .setPositiveButton(R.string.dialog_positive_button_text,
                    DialogInterface.OnClickListener { dialog, id ->
                        var password:String? = passwordEditText.text.toString()
                        if (requiredPassword == password) startActivity(mIntent)
                        else Toast
                            .makeText(inflater.context, "Its not working. Required password: '$requiredPassword'. Given password: '$password' ", Toast.LENGTH_SHORT)
                            .show()
                    })
                .setNegativeButton(R.string.dialog_negative_button_text,
                    DialogInterface.OnClickListener { dialog, id ->
                        dialog.dismiss()
                    })
                .create()
        }
    }
}