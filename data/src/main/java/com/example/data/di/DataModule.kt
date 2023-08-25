package com.example.data.di

import com.example.data.chore.ChoreRepositoryImpl
import com.example.data.chore.datasource.realtimedatabase.RealTimeRemoteDataSourceImp
import com.example.data.chore.datasource.realtimedatabase.definition.RemoteRealTimeDataSource
import com.example.domain.chore.repositories.ChoreRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindChoreRepository(
        choreRepositoryImpl: ChoreRepositoryImpl
    ): ChoreRepository

    @Binds
    fun bindRemoteRealTimeDataSource(
        realTimeRemoteDataSourceImp: RealTimeRemoteDataSourceImp
    ): RemoteRealTimeDataSource
}