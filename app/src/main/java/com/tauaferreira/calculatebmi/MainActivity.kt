package com.tauaferreira.calculatebmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var mCheckBoxAllow = false;

    fun onButtonCalculateClick(){

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mEditTextName = findViewById<EditText>(R.id.editTextName)
        val mEditTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val mButtonConfirm = findViewById<Button>(R.id.buttonConfirm)

        mButtonConfirm.setOnClickListener(){
            var name =mEditTextName.text.toString().uppercase()
            var password = mEditTextPassword.text.toString()



            val intent = Intent (this, SecondActivity::class.java)

            intent.putExtra("EXTRA_NAME", name)
            intent.putExtra("EXTRA_PASSWORD", password)
            intent.putExtra("EXTRA_ALTURA", 0.00)
            intent.putExtra("EXTRA_PESO", 0)
            intent.putExtra("EXTRA_ALLOW", false)

            startActivity(intent)


        }
        val mButtonAlert : Button = findViewById(R.id.buttonAlert)

        mButtonAlert.setOnClickListener(){
            Toast.makeText(this,"Botão de Aviso foi tocado", Toast.LENGTH_SHORT).show()

        }

        val mButtonCalculate:Button = findViewById(R.id.buttonCalculate)



    }
}