package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Register : AppCompatActivity() {

    lateinit var firstnameInput : EditText
    lateinit var lastnameInput : EditText
    lateinit var usernameInput : EditText
    lateinit var firstpasswordInput : EditText
    lateinit var secondpasswordInput : EditText
    lateinit var registerBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        registerBtn = findViewById(R.id.register_btn)

        registerBtn.setOnClickListener{
            val intent = Intent(this,Navigation::class.java )
            startActivity(intent)
        }
    }
}