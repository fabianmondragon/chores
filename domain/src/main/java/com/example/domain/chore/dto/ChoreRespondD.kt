package com.example.domain.chore.dto

data class ChoreRespondD(
    val choreId: Int = -1,
    val choreName: String = "" ,
    val description: String = "",
    val schedule: List<String> = listOf()
)
