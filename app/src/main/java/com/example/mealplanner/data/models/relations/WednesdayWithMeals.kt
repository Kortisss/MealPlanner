package com.example.mealplanner.data.models.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.data.models.Wednesday
import com.example.mealplanner.data.models.WednesdayMealCrossRef


data class WednesdayWithMeals (
    @Embedded val wednesday: Wednesday,
    @Relation(
        parentColumn = "wednesdayId",
        entityColumn = "mealId",
        associateBy = Junction(WednesdayMealCrossRef::class)
    ) val meals: List<Meal>
)