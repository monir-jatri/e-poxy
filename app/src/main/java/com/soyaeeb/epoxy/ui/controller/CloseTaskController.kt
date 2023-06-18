package com.soyaeeb.epoxy.ui.controller

import com.airbnb.epoxy.EpoxyController
import com.soyaeeb.epoxy.R
import com.soyaeeb.epoxy.databinding.CloseTaskItemBinding
import com.soyaeeb.epoxy.helper.ViewBindingKotlinModel
import com.soyaeeb.epoxy.ui.model.CloseTaskModel

class CloseTaskController : EpoxyController() {

    private var closeTaskList: List<CloseTaskModel> = emptyList()

    fun submitCloseTaskList(closeTaskList: List<CloseTaskModel>){
        this.closeTaskList = closeTaskList
    }

    override fun buildModels() {
        closeTaskList.forEach { task ->
            CloseTaskEPoxyModel(closeTaskModel = task)
                .id(task.id)
                .addTo(this)
        }
    }
}

data class CloseTaskEPoxyModel(
    val closeTaskModel: CloseTaskModel
): ViewBindingKotlinModel<CloseTaskItemBinding>(R.layout.add_task_item){
    override fun CloseTaskItemBinding.bind() {
        closeTaskIv.setImageDrawable(closeTaskModel.taskIcon)
        closeTaskTitleTv.text = closeTaskModel.closeTaskTitle
        closeTaskActionTv.text = closeTaskModel.actionCloseTask
    }
}