package com.example.domain.chore.repositories

import com.example.domain.chore.dto.AssignedChoreRespondD
import com.example.domain.chore.dto.ChoreRespondD
import com.example.domain.chore.model.ResultChores
import kotlinx.coroutines.flow.Flow

interface ChoreRepository {

    suspend fun getChores(email: String): Flow<ResultChores<AssignedChoreRespondD, Exception>>
    suspend fun testFlow(email: String): Flow<AssignedChoreRespondD>
}