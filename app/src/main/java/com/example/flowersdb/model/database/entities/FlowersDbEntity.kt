package com.example.flowersdb.model.database.entities

import androidx.room.*

@Entity(
    tableName = "flowers",
    indices = [Index("id")],
    foreignKeys = [
        ForeignKey(
            entity = FamilyDbEntity::class,
            parentColumns = ["id"],
            childColumns = ["family_id"]
        )
    ]

)
data class FlowersDbEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "flower_name") val flowerName: String,
    @ColumnInfo(name = "flower_age") val flowerAge: Int,
    @ColumnInfo(name = "family_id") val familyId: Long
)
