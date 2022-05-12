package com.example.mealplanner.data.models.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.mealplanner.data.models.Thursday
import com.example.mealplanner.data.models.Week

data class WeekWithThursdayWithMeals (
    @Embedded val week: Week,
    @Relation(
        entity = Thursday::class,
        parentColumn = "weekId",
        entityColumn = "thursdayId",
    )
    val thursday: List<ThursdayWithMeals>
)