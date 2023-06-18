package com.soyaeeb.epoxy.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soyaeeb.epoxy.ui.model.AddTaskModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _addTaskState = MutableStateFlow<List<AddTaskModel>>(emptyList())
    val addTaskState = _addTaskState.asStateFlow()


    init {
        populateTaskList()
    }

    private fun populateTaskList(){
        viewModelScope.launch {
            val taskList = listOf(
                AddTaskModel(id= 0,imageUrl = "", author_name = "Team", title = "Audio & Video"),
                AddTaskModel(id= 1,imageUrl = "", author_name = "Marcus", title = "Video Creater"),
                AddTaskModel(id= 2,imageUrl = "", author_name = "Francis", title = "Audio Engineer"),
                AddTaskModel(id= 3,imageUrl = "", author_name = "Smith", title = "Software Engineer"),
                AddTaskModel(id= 4,imageUrl = "", author_name = "Jon", title = "Animator"),
                AddTaskModel(id= 5,imageUrl = "", author_name = "Paul", title = "Musician"),
                AddTaskModel(id= 6,imageUrl = "", author_name = "Watson", title = "Web Engineer"),
                AddTaskModel(id= 7,imageUrl = "", author_name = "Cam Wright", title = "Musician"),
                AddTaskModel(id= 8,imageUrl = "", author_name = "Mike Flip", title = "Software Developer")
            )
            _addTaskState.value = taskList
        }
    }
}