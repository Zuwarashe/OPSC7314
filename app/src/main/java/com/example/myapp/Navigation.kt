package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Navigation : AppCompatActivity() {

    lateinit var homeBtn : Button
    lateinit var profileBtn : Button
    lateinit var listBtn : Button
    lateinit var addBtn : Button
    lateinit var graphBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_navigation)

        homeBtn = findViewById(R.id.home_btn)
        profileBtn = findViewById(R.id.profile_btn)
        listBtn = findViewById(R.id.list_btn)
        addBtn = findViewById(R.id.add_btn)
        graphBtn = findViewById(R.id.graph_btn)


        homeBtn.setOnClickListener {

            val intent = Intent(this,Home::class.java )
            startActivity(intent)
        }
    }
    private fun  replaceFragment(fragment: Fragment){
        //supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }

}