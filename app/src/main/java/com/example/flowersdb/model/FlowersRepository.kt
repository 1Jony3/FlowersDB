package com.example.flowersdb.model

import com.example.flowersdb.model.database.FlowersDao
import com.example.flowersdb.model.database.entities.FlowersDbEntity
import com.example.flowersdb.model.database.FlowersInfoTuple
import com.example.flowersdb.model.database.entities.FamilyDbEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FlowersRepository @Inject constructor(
    override var flowersDao: FlowersDao
): Repository {

    override suspend fun insertNewFlowerData(flowersDbEntity: FlowersDbEntity) {
        withContext(Dispatchers.IO) {
            flowersDao.insertNewFlowersData(flowersDbEntity)
        }
    }

    override suspend fun insertNewFamilyData(familyDbEntity: FamilyDbEntity) {
        withContext(Dispatchers.IO) {
            flowersDao.insertNewFamilyData(familyDbEntity)
        }
    }

    override suspend fun getAllFlowerData(): List<FlowersInfoTuple> {
        return withContext(Dispatchers.IO) {
            return@withContext flowersDao.getAllFlowerData()
        }
    }

    override suspend fun getAllFamilyData(): List<FamilyDbEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun removeFlowerDataById(id: Long) {
        withContext(Dispatchers.IO) {
            flowersDao.deleteFlowersDataByID(id)
        }
    }
}