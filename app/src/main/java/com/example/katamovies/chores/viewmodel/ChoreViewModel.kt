package com.example.katamovies.chores.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.chore.dto.ChoreRespondD
import com.example.domain.chore.usecase.GetChoreUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChoreViewModel @Inject constructor(
    private val choreUseCase: GetChoreUseCase
) : ViewModel(){

    private val _choreState : MutableStateFlow<ChoreRespondD>
    = MutableStateFlow(ChoreRespondD())

    val choreRespondD = _choreState.asStateFlow()

    fun getChores(email: String){
        viewModelScope.launch {
            choreUseCase.getChore(email).collect{
                val test = it
            }
        }

    }
}