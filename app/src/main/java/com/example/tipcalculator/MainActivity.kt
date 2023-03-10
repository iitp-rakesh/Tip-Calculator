package com.example.tipcalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val outlinedTextField: TextInputLayout = findViewById(R.id.outlinedTextField)
        val result: TextView = findViewById(R.id.tip_amount)
        findViewById<Button>(R.id.Button).setOnClickListener {
            result.text = "Tip Amount: "
            val inputText = outlinedTextField.editText?.text.toString()
            val tipPercentage =
                when (findViewById<RadioButton>(findViewById<RadioGroup>(R.id.radioGroup).checkedRadioButtonId).text) {
                    "Amazing(20%)" -> .20
                    "Better(15%)" -> .15
                    else -> .10
                }
            if(findViewById<Switch>(R.id.Switch).isChecked)
                result.append(kotlin.math.ceil(inputText.toFloat() * tipPercentage).toString())
            else
                result.append((inputText.toFloat() * tipPercentage).toString())
        }
    }
}
