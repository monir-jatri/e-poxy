package com.soyaeeb.epoxy.ui.controller


import com.airbnb.epoxy.EpoxyController
import com.soyaeeb.epoxy.R
import com.soyaeeb.epoxy.databinding.AddTaskItemBinding
import com.soyaeeb.epoxy.helper.ViewBindingKotlinModel
import com.soyaeeb.epoxy.ui.model.AddTaskModel

class AddTaskController : EpoxyController() {

    private var addTaskList: List<AddTaskModel> = emptyList()

    fun submitAddTaskList(taskList: List<AddTaskModel>) {
        this.addTaskList =  taskList
    }

    override fun buildModels() {
        addTaskList.forEach { task ->
            AddTaskEPoxyModel(addTaskModel = task)
                .id(task.id)
                .addTo(this)
        }
    }
}

data class AddTaskEPoxyModel(
    val addTaskModel: AddTaskModel
): ViewBindingKotlinModel<AddTaskItemBinding>(R.layout.add_task_item){
    override fun AddTaskItemBinding.bind() {
        authorNameTv.text = addTaskModel.author_name
        titleTv.text = addTaskModel.title
    }
}

