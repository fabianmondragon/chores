package com.example.data.chore.datasource.realtimedatabase.dto

data class ScheduleRTDB(
    val completed: Boolean = false,
    val day: String = "",
    val schedule_date: String = "",
    val schedule_id: Int = -1
)