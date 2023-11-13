package com.example.flowersdb.model.database.entities

data class Flower(
    val flowersName: String,
    val flowersAge: Int,
    val familyId: Long
) {
    fun toFlowerDbEntity(): FlowersDbEntity = FlowersDbEntity(
        id = 0,
        flowerName = flowersName,
        flowerAge = flowersAge,
        familyId = familyId
    )
}