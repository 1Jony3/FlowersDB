package com.example.flowersdb.model.database.entities

data class Family(
    val familyName: String
) {
    fun toFamilyDbEntity(): FamilyDbEntity = FamilyDbEntity(
        id = 0,
        familyName = familyName
    )
}
