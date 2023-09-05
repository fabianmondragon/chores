package com.example.domain.chore.dto

import java.util.*

data class ScheduleRespondD(
    val scheduleId: Int = -1,
    val completed: Boolean = false,
    val day: String = "",
    val scheduleDate: Date? = null
)
