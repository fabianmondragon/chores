package com.example.katamovies.chores.fragment

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.domain.chore.dto.AssignedChoreRespondD
import com.example.domain.chore.dto.ChoreRespondD
import com.example.katamovies.chores.screen.ScreenChore
import com.example.katamovies.chores.viewmodel.ChoreViewModel

@Composable
fun ChoreFragment (
    navController: NavController,
    choreViewModel: ChoreViewModel = hiltViewModel(),
    email: String
){
    choreViewModel.getChores(email)
    val chores by choreViewModel.choreRespondD.collectAsState(initial = AssignedChoreRespondD())
    ScreenChore( email, chores)
}


