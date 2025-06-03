package com.example.genrationcheckapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private var yearInput: EditText? = null
    private var gentxt: TextView? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        yearInput = findViewById(R.id.yearInput)
        gentxt = findViewById(R.id.genText)

        val btnCheck = findViewById<Button>(R.id.btncheck)
        val btnClear =findViewById<Button>(R.id.clearBtn)
        val btnExit = findViewById<Button>(R.id.exitBtn)



        btnCheck.setOnClickListener {
            checkGeneration()

        }
        btnClear.setOnClickListener {
            yearInput?.text?.clear()
            gentxt?.text = ""
        }
        btnExit.setOnClickListener{
            finishAffinity()
            exitProcess(status = 0)
        }


    }



    private fun checkGeneration() {

        val year = yearInput?.text.toString().trim().toIntOrNull()
        when (year) {

            in 1901..1924 -> gentxt?.text = "the greatest genration"
            in 1925..1945 -> gentxt?.text = "the silent genration"
            in 1946..1964 -> gentxt?.text = "the baby boomer genration"
            in 1965..1980 -> gentxt?.text = "genratin X"
            in 1981..1994 -> gentxt?.text = "millenials"
            in 1995..2012 -> gentxt?.text = "genration Z"
            in 2013..2025 -> gentxt?.text = "genration Alpha"


            else -> {
                gentxt?.text = "Please Enter Valid Year!"
            }


        }


    }
}
