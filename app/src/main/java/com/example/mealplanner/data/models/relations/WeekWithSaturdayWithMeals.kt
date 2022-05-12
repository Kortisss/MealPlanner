package com.example.mealplanner.data.models.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.mealplanner.data.models.Saturday
import com.example.mealplanner.data.models.Week

data class WeekWithSaturdayWithMeals (
    @Embedded val week: Week,
    @Relation(
        entity = Saturday::class,
        parentColumn = "weekId",
        entityColumn = "saturdayId",
    )
    val saturday: List<SaturdayWithMeals>
        )