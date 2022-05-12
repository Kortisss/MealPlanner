package com.example.mealplanner.data.models.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.data.models.Week
import com.example.mealplanner.data.models.WeekMealCrossRef
//todo: toDelete
data class WeekWithMeals (
        @Embedded val week: Week,
        @Relation(
                parentColumn = "weekId",
                entityColumn = "mealId",
                associateBy = Junction(WeekMealCrossRef::class)
        )
        val meals: List<Meal>
)