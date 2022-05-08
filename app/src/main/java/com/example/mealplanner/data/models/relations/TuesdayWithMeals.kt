package com.example.mealplanner.data.models.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.data.models.Tuesday
import com.example.mealplanner.data.models.TuesdayMealCrossRef

data class TuesdayWithMeals (
    @Embedded val tuesday: Tuesday,
    @Relation(
        parentColumn = "tuesdayId",
        entityColumn = "mealId",
        associateBy = Junction(TuesdayMealCrossRef::class)
    ) val meals: List<Meal>
)