package com.example.myapp

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.view.LayoutInflater
import android.app.Activity


class MyAdapter(private val context : Activity,private val arrayList: ArrayList<Projects>) : ArrayAdapter<Projects>(context,
    R.layout.list_item,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View= inflater.inflate(R.layout.list_item, null)

        val projectImage : ImageView = view.findViewById(R.id.project_image)
        val projectName : TextView = view.findViewById(R.id.project_title)
        val projectDes : TextView = view.findViewById(R.id.project_description)

        projectImage.setImageResource(arrayList[position].ImageId)
        projectName.text = arrayList[position].name
        projectDes.text = arrayList[position].description

        return view
    }
}