package com.example.flowersdb.model.database

import androidx.room.ColumnInfo

data class FlowersInfoTuple(
    val id: Long,
    @ColumnInfo(name = "flower_name") val flowerName: String,
    @ColumnInfo(name = "flower_age") val flowerAge: Int,
    @ColumnInfo(name = "family_name") val familyName: String,

)
