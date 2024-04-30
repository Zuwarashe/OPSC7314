package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Navigation : AppCompatActivity() {

   private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_navigation)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { MenuItem ->
            when(MenuItem.itemId){
                R.id.home_icon ->{


                    val intent = Intent(this, Home::class.java)
                    startActivity(intent)
                    true
                //    replaceFragment(HomeFragment())
                //    true
                }

                R.id.line_icon ->{
                    replaceFragment(ViewsFragment())
                    true
                }

                R.id.add_icon ->{
                    Toast.makeText(this,"yeah neh", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.graph_icon ->{
                    replaceFragment(GraphFragment())
                    true
                }

                R.id.profile_icon ->{
                    replaceFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }
        replaceFragment(HomeFragment())


    }
    private fun  replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }

}