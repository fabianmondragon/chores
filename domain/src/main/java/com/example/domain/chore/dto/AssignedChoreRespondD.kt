package com.example.domain.chore.dto

data class AssignedChoreRespondD(
    val infoUserRespondD: InfoUserRespondD,
    val listOfChore: List<ChoreRespondD>,
    val listSchedule: List<ScheduleRespondD>
)
