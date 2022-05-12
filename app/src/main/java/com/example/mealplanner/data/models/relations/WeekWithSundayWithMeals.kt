package com.example.mealplanner.data.models.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.mealplanner.data.models.Sunday
import com.example.mealplanner.data.models.Week

data class WeekWithSundayWithMeals (
    @Embedded val week: Week,
    @Relation(
        entity = Sunday::class,
        parentColumn = "weekId",
        entityColumn = "sundayId",
    )
    val sunday: List<SundayWithMeals>
        )