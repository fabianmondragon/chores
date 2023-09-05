package com.example.data.chore

import com.example.data.chore.datasource.realtimedatabase.model.AssignedChoreRespond
import com.example.data.chore.datasource.realtimedatabase.model.ChoreRespond
import com.example.data.chore.datasource.realtimedatabase.model.InfoUserRespond
import com.example.data.chore.datasource.realtimedatabase.model.ScheduleRespond
import com.example.data.utils.transformToDate
import com.example.domain.chore.dto.AssignedChoreRespondD
import com.example.domain.chore.dto.ChoreRespondD
import com.example.domain.chore.dto.InfoUserRespondD
import com.example.domain.chore.dto.ScheduleRespondD


fun AssignedChoreRespond.toAssignedChoreRespondD(): AssignedChoreRespondD {
    return AssignedChoreRespondD(
        infoUserRespondD = this.infoUser.toInfoUserRespondD(),
        listOfChore = this.listOfChore.toListChoreRespondDomain(),
        listSchedule = this.listSchedule.toListScheduleRespondDomain()
    )
}

private fun InfoUserRespond.toInfoUserRespondD(): InfoUserRespondD {
    return InfoUserRespondD(
        email = this.email,
        username = this.username
    )
}


private fun List<ChoreRespond>.toListChoreRespondDomain(): List<ChoreRespondD> {
    val list: MutableList<ChoreRespondD> = mutableListOf()
    this.forEach {
        list.add(
            ChoreRespondD(
                choreId = it.choreId,
                choreName = it.choreName,
                description = it.description,
            )
        )
    }
    return list
}

private fun List<ScheduleRespond>.toListScheduleRespondDomain(): MutableList<ScheduleRespondD> {
    val list: MutableList<ScheduleRespondD> = mutableListOf()
    this.forEach {
        list.add(
            ScheduleRespondD(
                scheduleId = it.scheduleId,
                completed = it.completed,
                day = it.day,
                scheduleDate = it.scheduleDate.transformToDate(),
            )
        )
    }
    return list
}


