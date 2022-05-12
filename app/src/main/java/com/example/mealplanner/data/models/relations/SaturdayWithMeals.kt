package com.example.mealplanner.data.models.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.data.models.Saturday
import com.example.mealplanner.data.models.SaturdayMealCrossRef

data class SaturdayWithMeals (
    @Embedded val saturday: Saturday,
    @Relation(
        parentColumn = "saturdayId",
        entityColumn = "mealId",
        associateBy = Junction(SaturdayMealCrossRef::class)
    ) val meals: List<Meal>
        )