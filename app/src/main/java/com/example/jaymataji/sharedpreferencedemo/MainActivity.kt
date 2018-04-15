package com.example.jaymataji.sharedpreferencedemo

import android.content.Context
import android.content.Intent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtNo = this.findViewById(R.id.txtNo) as TextView
        val btnRegister = findViewById(R.id.btnRegister) as Button

        val sharedPreferences = applicationContext.getSharedPreferences("file1", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        val s = sharedPreferences.getString("number", null)

        if (s == null) {

            btnRegister.setOnClickListener {

                editor.putString("number", txtNo.getText().toString())
                editor.commit()

                Toast.makeText(this@MainActivity, "Registred Successfully", Toast.LENGTH_SHORT).show()

                startActivity(Intent(this@MainActivity, WelcomeActivity::class.java))
                finish()
            }
        } else {
            startActivity(Intent(this@MainActivity, WelcomeActivity::class.java))
            finish()
        }
    }
}

