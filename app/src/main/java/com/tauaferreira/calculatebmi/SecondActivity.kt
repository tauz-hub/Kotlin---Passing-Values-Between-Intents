package com.tauaferreira.calculatebmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var intent = intent;
        val name = intent.getStringExtra("EXTRA_NAME")
        val password = intent.getStringExtra("EXTRA_PASSWORD")
        val allow: Boolean = intent.getBooleanExtra("EXTRA_ALLOW",false)
        val mTextViewResult : TextView = findViewById(R.id.textViewResult)

        if(allow){
            val bmi = intent.getStringExtra("EXTRA_BMI")

            mTextViewResult.setText("$name your BMI is $bmi")
            return
        }

        mTextViewResult.setText("$name a sua senha é $password")
    }
}