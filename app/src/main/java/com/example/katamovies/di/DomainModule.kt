package com.example.katamovies.di

import com.example.data.chore.ChoreRepositoryImpl
import com.example.domain.chore.repositories.ChoreRepository
import com.example.domain.chore.usecase.GetChoreUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun getChoreUseCase(
        choreRepository: ChoreRepository
    ): GetChoreUseCase {
       return GetChoreUseCase(choreRepository)
    }
}