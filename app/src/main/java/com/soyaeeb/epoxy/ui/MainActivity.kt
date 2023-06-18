package com.soyaeeb.epoxy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.soyaeeb.epoxy.R
import com.soyaeeb.epoxy.databinding.ActivityMainBinding
import com.soyaeeb.epoxy.ui.controller.AddTaskController
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var addTaskController: AddTaskController

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        addTaskController = AddTaskController()
        binding.addTaskRv.setControllerAndBuildModels(addTaskController)
        binding.addTaskRv.adapter = addTaskController.adapter


        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.addTaskState.collect {
                    addTaskController.submitAddTaskList(taskList = it)
                    addTaskController.requestModelBuild()
                }
            }
        }

    }
}