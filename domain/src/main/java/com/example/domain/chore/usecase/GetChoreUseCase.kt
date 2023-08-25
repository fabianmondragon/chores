package com.example.domain.chore.usecase

import com.example.domain.chore.dto.AssignedChoreRespondD
import com.example.domain.chore.dto.ChoreRespondD
import com.example.domain.chore.model.ResultChores
import com.example.domain.chore.repositories.ChoreRepository
import kotlinx.coroutines.flow.Flow

class GetChoreUseCase (private val choreRepository: ChoreRepository) {

    suspend fun getChore(email: String): Flow<ResultChores<AssignedChoreRespondD, Exception>> {
        return choreRepository.getChores(email)
    }

    suspend fun testFlow(email: String): Flow<AssignedChoreRespondD> {
        return choreRepository.testFlow(email)
    }
}