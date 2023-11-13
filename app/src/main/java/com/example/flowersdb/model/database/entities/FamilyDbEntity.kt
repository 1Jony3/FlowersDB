package com.example.flowersdb.model.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "family")
data class FamilyDbEntity(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "family_name") val familyName: String
)
