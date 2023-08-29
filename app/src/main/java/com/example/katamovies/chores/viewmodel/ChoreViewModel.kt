package com.example.katamovies.chores.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.chore.dto.AssignedChoreRespondD
import com.example.domain.chore.dto.ChoreRespondD
import com.example.domain.chore.model.ResultChores
import com.example.domain.chore.usecase.GetChoreUseCase
import com.example.katamovies.di.IoDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChoreViewModel @Inject constructor(
    private val choreUseCase: GetChoreUseCase,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel(){

    private val _choreState : MutableStateFlow<AssignedChoreRespondD>
    = MutableStateFlow(AssignedChoreRespondD())

    val choreRespondD = _choreState.asStateFlow()

    fun getChores(email: String){
        viewModelScope.launch(dispatcher) {
            choreUseCase.getChore(email).collect{
                when (it){
                    is ResultChores.Success -> {
                        _choreState.value = it.value
                    }
                    is ResultChores.Error -> {

                    }
                }
            }
        }

    }
}