package com.example.data.chore.datasource.realtimedatabase.model

data class AssignedChoreRespond(
    var infoUser: InfoUserRespond = InfoUserRespond(),
    val listOfChore: MutableList<ChoreRespond> = mutableListOf(),
    val listSchedule: MutableList<ScheduleRespond> = mutableListOf()
)



