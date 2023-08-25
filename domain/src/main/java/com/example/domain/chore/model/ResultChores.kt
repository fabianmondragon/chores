package com.example.domain.chore.model

import com.example.domain.register.ResultMovies

sealed class ResultChores<out T, out E> {
    data class Success<T>(val value: T) : ResultChores<T, Nothing>()
    data class Error<E>(val error: E) : ResultChores<Nothing, E>()
}
