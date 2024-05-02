package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var usernameInput : EditText
    lateinit var passwordInput : EditText
    lateinit var loginBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        usernameInput = findViewById(R.id.username_input)
        passwordInput = findViewById(R.id.password_input)
        loginBtn = findViewById(R.id.login_btn)

        loginBtn.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            if (validationInput(username, password)){
                showSuccess();
                val intent = Intent(this, Navigation::class.java)
                startActivity(intent)
            }
            else{
                showError();
            }
            /*val intent = Intent(this, Register::class.java)
            startActivity(intent)*/
        }
    }

    private fun validationInput(username:String, password:String) : Boolean {
        return username.isNotBlank() && password.isNotBlank()
    }

    private fun showError(){
        Toast.makeText(this, "Please Enter Valid Data", Toast.LENGTH_LONG).show()
    }

    private fun showSuccess(){
        Toast.makeText(this, "You have logged in successfully", Toast.LENGTH_LONG).show()
    }
}
