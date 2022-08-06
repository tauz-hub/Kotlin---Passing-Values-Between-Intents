package com.tauaferreira.calculatebmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var mCheckBoxAllow = false;

    fun onButtonCalculateClick(){

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val editTextHeight = findViewById<EditText>(R.id.editTextHeight)
        val editTextWeight = findViewById<EditText>(R.id.editTextWeight)
        val allow = findViewById<CheckBox>(R.id.checkBoxAllow)

        val name =editTextName.text.toString().uppercase()
        val password = editTextPassword.text.toString()

        val height = editTextHeight.text.toString().toDouble()
        val weight = editTextWeight.text.toString().toDouble()

        val bmi = weight / Math.pow(height, 2.0)

        val intentBmi = Intent(this@MainActivity, SecondActivity::class.java)
        intentBmi.putExtra("EXTRA_NAME", name)
        intentBmi.putExtra("EXTRA_PASSWORD", password)
        intentBmi.putExtra("EXTRA_ALTURA", height)
        intentBmi.putExtra("EXTRA_PESO", weight)
        intentBmi.putExtra("EXTRA_ALLOW", allow.isChecked)
        intentBmi.putExtra("EXTRA_BMI", bmi.toString())

        startActivity(intentBmi)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mEditTextName = findViewById<EditText>(R.id.editTextName)
        val mEditTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val mButtonConfirm = findViewById<Button>(R.id.buttonConfirm)

        mButtonConfirm.setOnClickListener() {
            var name = mEditTextName.text.toString().uppercase()
            var password = mEditTextPassword.text.toString()


            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra("EXTRA_NAME", name)
            intent.putExtra("EXTRA_PASSWORD", password)
            intent.putExtra("EXTRA_ALTURA", 0.00)
            intent.putExtra("EXTRA_PESO", 0)
            intent.putExtra("EXTRA_ALLOW", false)

            startActivity(intent)
        }
        val mButtonAlert: Button = findViewById(R.id.buttonAlert)

        mButtonAlert.setOnClickListener() {
            Toast.makeText(this, "Botão de Aviso foi tocado", Toast.LENGTH_SHORT).show()
        }

        val mButtonCalculate: Button = findViewById(R.id.buttonCalculate)
        mButtonCalculate.setOnClickListener() {
            onButtonCalculateClick()
        }
    }
}