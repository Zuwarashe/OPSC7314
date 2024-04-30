package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    private lateinit var projectsArrayList : ArrayList<Projects>

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

    }
}