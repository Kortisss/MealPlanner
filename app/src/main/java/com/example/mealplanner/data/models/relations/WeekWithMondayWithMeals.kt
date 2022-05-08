package com.example.mealplanner.data.models.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.mealplanner.data.models.Monday
import com.example.mealplanner.data.models.Week

data class WeekWithMondayWithMeals (
    @Embedded val week: Week,
    @Relation(
        entity = Monday::class,
        parentColumn = "weekId",
        entityColumn = "mondayId",
    )
    val monday: List<MondayWithMeals>
)