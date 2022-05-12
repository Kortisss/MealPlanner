package com.example.mealplanner.data.models.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.mealplanner.data.models.Friday
import com.example.mealplanner.data.models.FridayMealCrossRef
import com.example.mealplanner.data.models.Meal

data class FridayWithMeals (
    @Embedded val friday: Friday,
    @Relation(
        parentColumn = "fridayId",
        entityColumn = "mealId",
        associateBy = Junction(FridayMealCrossRef::class)
    ) val meals: List<Meal>
        )