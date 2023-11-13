package com.example.flowersdb.model.di

import com.example.flowersdb.model.FlowersRepository
import com.example.flowersdb.model.Repository
import com.example.flowersdb.model.database.AppDatabase
import com.example.flowersdb.model.database.FlowersDao
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    @Binds
    abstract fun bindFlowersRepository(
        flowersRepository: FlowersRepository
    ): Repository
}