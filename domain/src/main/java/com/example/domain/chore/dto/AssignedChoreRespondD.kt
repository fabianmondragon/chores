package com.example.domain.chore.dto

data class AssignedChoreRespondD(
    val infoUserRespondD: InfoUserRespondD = InfoUserRespondD(),
    val listOfChore: List<ChoreRespondD> = listOf(),
    val listSchedule: List<ScheduleRespondD> = listOf()
)
