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

class Register : AppCompatActivity() {
    //private lateinit var binding: ActivityMainBinding

    lateinit var firstnameInput: EditText
    lateinit var lastnameInput: EditText
    lateinit var usernameInput: EditText
    lateinit var firstpasswordInput: EditText
    lateinit var secondpasswordInput: EditText
    lateinit var registerBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_register)

        firstnameInput = findViewById(R.id.firstname_input)
        lastnameInput = findViewById(R.id.lastname_input)
        usernameInput = findViewById(R.id.user_input)
        firstpasswordInput = findViewById(R.id.password1_input)
        secondpasswordInput = findViewById(R.id.password2_input)
        registerBtn = findViewById(R.id.register_btn)

        registerBtn.setOnClickListener {
            var stringFirstname = firstnameInput.text.toString()
            var stringLastname = lastnameInput.text.toString()
            var stringUsername = usernameInput.text.toString()
            var stringPassword1 = firstpasswordInput.text.toString()
            var stringPassword2 = secondpasswordInput.text.toString()

            if (validationInput(stringFirstname, stringLastname, stringUsername,
                    stringPassword1, stringPassword2)){
                showSuccess();
                val intent = Intent(this, Navigation::class.java)
                startActivity(intent)
            }
            else{
                showError();
            }
        }

    }

    private fun validationInput(firstname:String, lastname:String, username:String,
                                pass1:String, pass2:String) : Boolean {
        return firstname.isNotBlank() && lastname.isNotBlank() && username.isNotBlank()
                && pass1.length >= 6 && pass2.length >= 6
    }

    private fun showError(){
        Toast.makeText(this, "Please Enter Valid Data", Toast.LENGTH_LONG).show()
    }

    private fun showSuccess(){
        Toast.makeText(this, "You have logged in successfully", Toast.LENGTH_LONG).show()
    }
}