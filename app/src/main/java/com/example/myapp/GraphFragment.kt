package com.example.myapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.viewbinding.ViewBindings
import com.example.myapp.databinding.FragmentGraphBinding



class GraphFragment : Fragment()  {
    //part 1
    private lateinit var binding: FragmentGraphBinding
    private lateinit var goalViewModel: GoalViewModel
    //part 1
    private lateinit var goalsListView: ListView
    private lateinit var goalsAdapter: ArrayAdapter<String>
    private val goalList = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        binding = FragmentGraphBinding.inflate(inflater, container, false)
        val name = binding.taskName.text.toString()
        goalViewModel = ViewModelProvider(this).get(GoalViewModel::class.java)
        /*
        goalsAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            goalList
        )

        val rootView = binding.root


        goalsAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            goalList
        )

        binding.goalsListView.adapter = goalsAdapter

        binding.newTaskButton.setOnClickListener {
            val newGoalSheet = NewGoalSheet()
            newGoalSheet.setOnGoalAddedListener(this)
            newGoalSheet.show(parentFragmentManager, "NewGoalSheet")
            //showNewGoalSheet()
        }
        */
        binding.newTaskButton.setOnClickListener{
            NewGoalSheet(null ).show(requireActivity().supportFragmentManager, "newTaskTag")
        }
        /*

        goalViewModel = ViewModelProvider(this).get(GoalViewModel::class.java)
        goalViewModel.taskItems.observe(viewLifecycleOwner){newName ->

        }
        goalsListView = binding.goalsListView

        goalsListView = rootView.findViewById(R.id.goalsListView)
        val items = arrayOf("WorkOut", "Meeting")
        val goalsList = mutableListOf<String>()
        //val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, goalsList)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, items)
        goalsListView.adapter = adapter

        val newGoalSheet = NewGoalSheet()
        newGoalSheet.setOnGoalAddedListener(this)

        */
        goalViewModel.taskItems.observe(viewLifecycleOwner){
            binding.taskName.text = String.format("Task Name: %s", it)
        }
        return binding.root
        //return rootView
    }
    /*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goalViewModel.name.observe(viewLifecycleOwner) { newName ->
            //binding.taskName.text = "Task Name: $newName"
        }
        /*
        binding.newTaskButton.setOnClickListener {
            val newGoalSheet = NewGoalSheet()
            //newGoalSheet.setTargetFragment(this, REQUEST_CODE_NEW_GOAL)
            newGoalSheet.show(parentFragmentManager, "NewGoalSheet")
        }
        */
    }

    override fun onGoalAdded(goal: String) {
        /*
        val adapter = goalsListView.adapter as? ArrayAdapter<String>
        adapter?.add(goal)
        adapter?.notifyDataSetChanged()
        */
        goalList.add(goal)
        goalsAdapter.notifyDataSetChanged()
    }

    private fun showNewGoalSheet() {
        val newGoalSheet = NewGoalSheet()
        newGoalSheet.setTargetFragment(this, 0)
        newGoalSheet.show(parentFragmentManager, "newGoalSheet")
    }
    */


}

