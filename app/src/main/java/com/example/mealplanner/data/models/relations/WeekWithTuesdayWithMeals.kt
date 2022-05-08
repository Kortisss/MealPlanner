package com.example.mealplanner.data.models.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.mealplanner.data.models.Tuesday
import com.example.mealplanner.data.models.Week

data class WeekWithTuesdayWithMeals (
    @Embedded val week: Week,
    @Relation(
        entity = Tuesday::class,
        parentColumn = "weekId",
        entityColumn = "tuesdayId",
    )
    val tuesday: List<TuesdayWithMeals>
)