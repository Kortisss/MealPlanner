package com.example.mealplanner.data.models.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.data.models.Week
import com.example.mealplanner.data.models.WeekMealCrossRef

data class MealWithWeek (
    @Embedded val meal: Meal,
    @Relation(
        parentColumn = "mealId",
        entityColumn = "weekId",
        associateBy = Junction(WeekMealCrossRef::class)
    )
    val week: List<Week>
)