package com.example.myapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import java.time.LocalTime
import java.util.*


class GoalViewModel : ViewModel()
{

    var taskItems = MutableLiveData<MutableList<TaskItem>>()

    init {
        taskItems.value = mutableListOf()
    }

    fun addTaskItem(newTask: TaskItem)
    {
        val list = taskItems.value
        list!!.add(newTask)
        taskItems.postValue(list)
    }

    fun updateTaskItem(id: UUID, name: String , dueTime: LocalTime?)
    {
        val list = taskItems.value
        val task = list!!.find { it.id == id }
        task?.let {
            task.name = name
            task.dueTime = dueTime
            taskItems.postValue(list)
        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setCompleted(taskItem: TaskItem)
    {
        val list = taskItems.value
        //val task = list!!.find { it.id == taskItem.id }!!
        val task = list!!.find { it.id == taskItem.id }
        task?.let{
            if (task.completedDate == null)
                task.completedDate = LocalDate.now()
            taskItems.postValue(list)
        }

    }


}