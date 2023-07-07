package com.jetbrains.kmm.androidApp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.jetbrains.kmm.shared.Greeting
import com.jetbrains.kmm.shared.Calculator
import android.widget.TextView
import com.jetbrains.androidApp.R
import com.jetbrains.kmm.androidApp.presenter.GreetingPresenter
import org.koin.android.ext.android.inject

//create instance of greeting() Without DI
fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

    //create instance of GreetingPresenter using DI
    private val presenter: GreetingPresenter by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv1: TextView = findViewById(R.id.textView1)
        val tv2: TextView = findViewById(R.id.textView2)

        tv1.text = greet()
        tv2.text = presenter.sayHello()

        val numATV: EditText = findViewById(R.id.editTextNumberDecimalA)
        val numBTV: EditText = findViewById(R.id.editTextNumberDecimalB)

        val sumTV: TextView = findViewById(R.id.textViewSum)

        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                try {
                    val numA = Integer.parseInt(numATV.text.toString())
                    val numB = Integer.parseInt(numBTV.text.toString())
                    sumTV.text = "= " + Calculator.sum(numA, numB).toString()
                } catch (e: NumberFormatException) {
                    sumTV.text = "= 🤔"
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }

        numATV.addTextChangedListener(textWatcher)
        numBTV.addTextChangedListener(textWatcher)

    }
}
