package com.example.data.chore

import com.example.data.chore.datasource.realtimedatabase.definition.RemoteRealTimeDataSource
import com.example.data.chore.datasource.realtimedatabase.model.AssignedChoreRespond
import com.example.domain.chore.dto.AssignedChoreRespondD
import com.example.domain.chore.dto.ChoreRespondD
import com.example.domain.chore.model.ResultChores
import com.example.domain.chore.repositories.ChoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ChoreRepositoryImpl @Inject constructor(
    private val remoteRealTimeDataSource: RemoteRealTimeDataSource
) : ChoreRepository {

    override suspend fun getChores(email: String): Flow<ResultChores<AssignedChoreRespondD, Exception>> {
        return remoteRealTimeDataSource.getUserChores(email)
            .map { resultChores ->
                when (resultChores) {
                    is ResultChores.Success -> {
                        ResultChores.Success(resultChores.value.toAssignedChoreRespondD())
                    }
                    is ResultChores.Error -> {
                        resultChores
                    }
                }
            }
    }

    override suspend fun testFlow(email: String): Flow<AssignedChoreRespondD> {

        return remoteRealTimeDataSource
            .testFlow(email).map { it ->
                it.toAssignedChoreRespondD()
            }
    }

}