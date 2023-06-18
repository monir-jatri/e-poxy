package com.soyaeeb.epoxy.ui.model

import android.graphics.drawable.Drawable

data class CloseTaskModel(
    val id: Int,
    var taskIcon: Drawable,
    val closeTaskTitle: String,
    val actionCloseTask: String
)
