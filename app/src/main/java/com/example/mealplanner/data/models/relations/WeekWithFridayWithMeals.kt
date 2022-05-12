package com.example.mealplanner.data.models.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.mealplanner.data.models.Friday
import com.example.mealplanner.data.models.Week

data class WeekWithFridayWithMeals (
    @Embedded val week: Week,
    @Relation(
        entity = Friday::class,
        parentColumn = "weekId",
        entityColumn = "fridayId",
    )
    val friday: List<FridayWithMeals>
        )