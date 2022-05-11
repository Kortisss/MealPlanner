package com.example.mealplanner.data.models.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.mealplanner.data.models.Wednesday
import com.example.mealplanner.data.models.Week

data class WeekWithWednesdayWithMeals (
    @Embedded val week: Week,
    @Relation(
        entity = Wednesday::class,
        parentColumn = "weekId",
        entityColumn = "wednesdayId",
    )
    val wednesday: List<WednesdayWithMeals>
)