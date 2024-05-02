package com.example.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class ViewsFragment : Fragment() {

    private lateinit var editTextProjectName: EditText
    private lateinit var editTextProjectDescription: EditText
    private lateinit var editTextDate: EditText
    private lateinit var editTextStartTime: EditText
    private lateinit var editTextEndTime: EditText
    private lateinit var btnAddImage: Button
    private lateinit var spinnerCategory: Spinner
    private lateinit var btnAddNew: Button
    private lateinit var btnCreateEntry: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_views, container, false)

        // Initialize views
        editTextProjectName = view.findViewById(R.id.editTextProjectName)
        editTextProjectDescription = view.findViewById(R.id.editTextProjectDescription)
        editTextDate = view.findViewById(R.id.editTextDate)
        editTextStartTime = view.findViewById(R.id.editTextStartTime)
        editTextEndTime = view.findViewById(R.id.editTextEndTime)
        btnAddImage = view.findViewById(R.id.btnAddImage)
        spinnerCategory = view.findViewById(R.id.spinnerCategory)
        btnAddNew = view.findViewById(R.id.btnAddNew)
        btnCreateEntry = view.findViewById(R.id.btnCreateEntry)

        // Set up spinner
        val categories = arrayOf("Category 1", "Category 2", "Category 3")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCategory.adapter = adapter

        // Button click listeners
        btnAddNew.setOnClickListener {
            clearForm()
        }

        btnCreateEntry.setOnClickListener {
            // Retrieve data from form fields
            val projectName = editTextProjectName.text.toString()
            val projectDescription = editTextProjectDescription.text.toString()
            val date = editTextDate.text.toString()
            val startTime = editTextStartTime.text.toString()
            val endTime = editTextEndTime.text.toString()
            val category = spinnerCategory.selectedItem.toString()

            // Perform any further processing (e.g., validation, saving data)
            // For now, let's just log the data
            println("Project Name: $projectName")
            println("Project Description: $projectDescription")
            println("Date: $date")
            println("Start Time: $startTime")
            println("End Time: $endTime")
            println("Category: $category")
        }

        return view
    }

    private fun clearForm() {
        editTextProjectName.setText("")
        editTextProjectDescription.setText("")
        editTextDate.setText("")
        editTextStartTime.setText("")
        editTextEndTime.setText("")
        spinnerCategory.setSelection(0)
    }
}
