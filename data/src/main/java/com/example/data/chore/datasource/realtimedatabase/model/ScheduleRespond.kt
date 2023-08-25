package com.example.data.chore.datasource.realtimedatabase.model

data class ScheduleRespond(
    val scheduleId: Int = -1,
    val completed: Boolean = false,
    val day: String = "",
    val scheduleDate: String = "",
)