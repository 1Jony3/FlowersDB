package com.example.flowersdb.model

import com.example.flowersdb.model.database.FlowersDao
import com.example.flowersdb.model.database.FlowersInfoTuple
import com.example.flowersdb.model.database.entities.FamilyDbEntity
import com.example.flowersdb.model.database.entities.FlowersDbEntity


interface Repository {
    var flowersDao: FlowersDao
    suspend fun insertNewFlowerData(flowersDbEntity: FlowersDbEntity)
    suspend fun insertNewFamilyData(familyDbEntity: FamilyDbEntity)
    suspend fun getAllFlowerData(): List<FlowersInfoTuple>
    suspend fun getAllFamilyData(): List<FamilyDbEntity>
    suspend fun removeFlowerDataById(id: Long)
}