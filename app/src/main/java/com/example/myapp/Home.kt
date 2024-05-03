package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp.databinding.ActivityHomeBinding
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    private lateinit var projectsArrayList : ArrayList<Projects>
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId= intArrayOf(
            R.drawable.a, R.drawable.b, R.drawable.c,R.drawable.d,R.drawable.e
        )

        val name = arrayOf(
            "zuwa",
            "manneng",
            "dylan",
            "courtney",
            "susan"
        )

        val description = arrayOf(
            "project 1","project 2","project 3","project 4","project 5"
        )

        projectsArrayList = ArrayList()

        for(i in name.indices){
            val project = Projects(name[i],description[i],imageId[i])
            projectsArrayList.add(project)
        }

        binding.listview.isClickable = true
        binding.listview.adapter = MyAdapter(this,projectsArrayList)
        binding.listview.setOnItemClickListener { parent, view, position, id ->

            val name = name[position]
            val description = description[position]
            val imageId = imageId[position]

            val i = Intent(this,ProjectDetails::class.java)
            i.putExtra("name",name)
           // i.putExtra("name",name)
        //    startActivity(i)


        }

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