package com.example.myapp

import android.app.TimePickerDialog
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.myapp.databinding.FragmentNewGoalSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import java.sql.Time
import java.time.LocalTime


//class NewGoalSheet (var taskItem: TaskItem?)  : BottomSheetDialogFragment()
class NewGoalSheet (var taskItem: TaskItem?)  : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewGoalSheetBinding
    private lateinit var goalViewModel: GoalViewModel
    private var dueTime: LocalTime? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        if (taskItem != null)
        {
            binding.taskTitle.text = "Edit Task"
            val editable = Editable.Factory.getInstance()
            binding.taskname.text = editable.newEditable(taskItem!!.name)

        }
        else
        {
            binding.taskTitle.text = "New Task"
        }
        goalViewModel = ViewModelProvider(activity).get(GoalViewModel::class.java)
        binding.saveButton.setOnClickListener {
            saveAction()

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewGoalSheetBinding.inflate(inflater,container,false)
        return binding.root
    }
    private fun saveAction()
    {
        val name = binding.taskname.text.toString()
        if(taskItem == null)
        {
            val newTask = TaskItem(name,dueTime,null)
            goalViewModel.addTaskItem(newTask)
        }
        else
        {
            goalViewModel.updateTaskItem(taskItem!!.id, name, dueTime)
        }
        binding.taskname.setText("")
        view?.postDelayed({ dismiss() }, 1000)

    }
    //part 2
    /*
    private fun showSaveConfirmation( goal: String) {
        Snackbar.make(binding.root, "Goal saved!  $goal", Snackbar.LENGTH_SHORT).show()
        listener?.onGoalAdded(goal)
    }


    interface OnGoalAddedListener {
        fun onGoalAdded(goal: String)
    }

    private var listener: OnGoalAddedListener? = null
    fun setOnGoalAddedListener(graphFragment: GraphFragment) {
        this.listener = listener
    }
    */
}