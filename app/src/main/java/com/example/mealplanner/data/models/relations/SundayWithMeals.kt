package com.example.mealplanner.data.models.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.data.models.Sunday
import com.example.mealplanner.data.models.SundayMealCrossRef

data class SundayWithMeals (
    @Embedded val sunday: Sunday,
    @Relation(
        parentColumn = "sundayId",
        entityColumn = "mealId",
        associateBy = Junction(SundayMealCrossRef::class)
    ) val meals: List<Meal>
        )