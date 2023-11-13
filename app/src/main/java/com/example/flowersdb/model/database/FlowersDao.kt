package com.example.flowersdb.model.database

import androidx.room.*
import com.example.flowersdb.model.database.entities.FamilyDbEntity
import com.example.flowersdb.model.database.entities.FlowersDbEntity
import javax.inject.Singleton

@Singleton
@Dao
interface FlowersDao {

    @Insert(entity = FlowersDbEntity::class)
    fun insertNewFlowersData(flower: FlowersDbEntity)

    @Insert(entity = FamilyDbEntity::class)
    fun insertNewFamilyData(family: FamilyDbEntity)

    @Query("SELECT flowers.id, flower_name, flower_age, family_name FROM flowers\n" +
            "INNER JOIN family ON flowers.family_id = family.id;"
    )
    fun getAllFlowerData(): List<FlowersInfoTuple>

    @Query("SELECT * FROM family")
    fun getAllFamilyData(): List<FamilyDbEntity>

    @Query ("DELETE FROM flowers WHERE id = :flowerID")
    fun deleteFlowersDataByID(flowerID: Long)
}