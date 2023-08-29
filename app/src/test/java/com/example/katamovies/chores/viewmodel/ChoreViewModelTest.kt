package com.example.katamovies.chores.viewmodel

import com.example.domain.chore.dto.AssignedChoreRespondD
import com.example.domain.chore.dto.InfoUserRespondD
import com.example.domain.chore.model.ResultChores
import com.example.domain.chore.usecase.GetChoreUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext


@ExperimentalCoroutinesApi
class ChoreViewModelTest{

    private lateinit var choreViewModel: ChoreViewModel
    lateinit var choreUseCase: GetChoreUseCase
    lateinit var testDispatcher: TestDispatcher


    @Before
    fun setup(){
        choreUseCase = mockk()
        testDispatcher = StandardTestDispatcher()
        choreViewModel = ChoreViewModel(choreUseCase, testDispatcher)
    }

    @Test
    fun `test getChores with success result` () {
        // given
        val emailToTest = "yyy@gmail.com"
        val result = ResultChores.Success(provideAssignedChore())
        coEvery { choreUseCase.getChore(emailToTest) } returns flowOf(result)

        // when
        choreViewModel.getChores(emailToTest)
        testDispatcher.scheduler.advanceUntilIdle()

        // then
        assertEquals(choreViewModel.choreRespondD.value.infoUserRespondD.email,emailToTest)

    }

    private fun provideAssignedChore()= AssignedChoreRespondD(
            InfoUserRespondD(email ="yyy@gmail.com"),
            listOf(),
            listOf()
        )

}
