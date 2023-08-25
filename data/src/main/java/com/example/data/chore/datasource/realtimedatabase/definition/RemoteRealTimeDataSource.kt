package com.example.data.chore.datasource.realtimedatabase.definition

import com.example.data.chore.datasource.realtimedatabase.model.AssignedChoreRespond
import com.example.domain.chore.model.ResultChores
import kotlinx.coroutines.flow.Flow

interface RemoteRealTimeDataSource {

    suspend fun getUserChores(email: String):  Flow<ResultChores<AssignedChoreRespond, Exception>>

    suspend fun testFlow(email: String): Flow<AssignedChoreRespond>
}