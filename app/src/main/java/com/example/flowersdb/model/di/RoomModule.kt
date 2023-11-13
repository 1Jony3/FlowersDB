package com.example.flowersdb.model.di

import android.content.Context
import androidx.room.Room
import com.example.flowersdb.model.database.AppDatabase
import com.example.flowersdb.model.database.FlowersDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase{
        return Room.databaseBuilder(context, AppDatabase::class.java, "database.db")
            .build()
    }

    @Provides
    fun provideFlowersDao(appDatabase: AppDatabase): FlowersDao{
        return appDatabase.getFlowersDao()
    }
}