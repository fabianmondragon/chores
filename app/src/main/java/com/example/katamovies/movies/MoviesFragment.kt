package com.example.katamovies.movies

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun MoviesFragment (
    navController: NavController,
    moviesViewModel: MoviesViewModel = hiltViewModel()
){
    moviesViewModel.getMovies()
}