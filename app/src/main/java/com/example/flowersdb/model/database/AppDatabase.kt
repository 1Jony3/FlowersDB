package com.example.flowersdb.model.database

import androidx.room.*
import com.example.flowersdb.model.database.entities.FamilyDbEntity
import com.example.flowersdb.model.database.entities.FlowersDbEntity

@Database(
    version = 1,
    entities = [
        FamilyDbEntity::class,
        FlowersDbEntity::class
    ]
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getFlowersDao(): FlowersDao
}