package com.example.mealplanner.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

data class SectionWithMeals (
    @Embedded val section : Section,
    @Relation(
        parentColumn = "sectionId",
        entityColumn = "sectionCreatorId"
    )
    val sections: List<Meal>,
)