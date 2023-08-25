package com.example.data.chore.datasource.realtimedatabase

import com.example.data.chore.datasource.realtimedatabase.definition.RemoteRealTimeDataSource
import com.example.data.chore.datasource.realtimedatabase.dto.*
import com.example.data.chore.datasource.realtimedatabase.model.AssignedChoreRespond
import com.example.data.chore.datasource.realtimedatabase.model.ChoreRespond
import com.example.data.chore.datasource.realtimedatabase.model.InfoUserRespond
import com.example.data.chore.datasource.realtimedatabase.model.ScheduleRespond
import com.example.domain.chore.model.ResultChores
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class RealTimeRemoteDataSourceImp @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase
) : RemoteRealTimeDataSource {


    override suspend fun getUserChores(email: String): Flow<ResultChores<AssignedChoreRespond, Exception>> {

        try {
            val dataSnapshot = firebaseDatabase.reference.get().await()

            val listIdentifiers = getIdentifiers(dataSnapshot, email)
            val assignedChoreRespond = AssignedChoreRespond()

            val user = getUser(email, dataSnapshot)
            assignedChoreRespond.infoUser = InfoUserRespond(email, username = user.username)

            listIdentifiers.forEach { it ->
                val chore = getChore(it.chore_id, dataSnapshot)
                val schedule = getSchedule(it.schedule_id, dataSnapshot)

                chore.let {
                    assignedChoreRespond
                        .listOfChore.add(
                            ChoreRespond(
                                it.chore_id, it.chore_name, it.description
                            )
                        )
                }
                schedule.let {
                    assignedChoreRespond
                        .listSchedule
                        .add(
                            ScheduleRespond(
                                completed = it.completed,
                                scheduleId = it.schedule_id,
                                day = it.day,
                                scheduleDate = it.schedule_date
                            )
                        )
                }
            }
            return flow {
                emit(ResultChores.Success(assignedChoreRespond))
            }
        } catch (exception: Exception) {
            return flow {
                emit(ResultChores.Error(exception))
            }
        }
    }

    override suspend fun testFlow(email: String): Flow<AssignedChoreRespond> {
        return flow {
            emit(AssignedChoreRespond(InfoUserRespond("aklsdjf", "aklsjdf")))
        }
    }


    private fun getIdentifiers(dataSnapshot: DataSnapshot, email: String): List<UserChoreRTDB> {
        return dataSnapshot.child("user_chores")
            .children
            .mapNotNull { it.getValue(UserChoreRTDB::class.java) }.filter { it.email == email }
    }


    private fun getChore(choreId: Int, dataSnapshot: DataSnapshot): ChoreRTDB {

        return dataSnapshot.child("chores")
            .children
            .mapNotNull { it.getValue(ChoreRTDB::class.java) }
            .first { it.chore_id == choreId }

    }

    private fun getSchedule(scheduleId: Int, dataSnapshot: DataSnapshot): ScheduleRTDB {

        return dataSnapshot.child("schedules")
            .children
            .mapNotNull { it.getValue(ScheduleRTDB::class.java) }
            .first { it.schedule_id == scheduleId }
    }

    private fun getUser(email: String, dataSnapshot: DataSnapshot): UserRTDB {

        return dataSnapshot.child("users")
            .children
            .mapNotNull { it.getValue(UserRTDB::class.java) }
            .first { it.email == email }
    }
}




