package com.example.mealplanner.data.models.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.mealplanner.data.models.*

data class ThursdayWithMeals (
    @Embedded val thursday: Thursday,
    @Relation(
        parentColumn = "thursdayId",
        entityColumn = "mealId",
        associateBy = Junction(ThursdayMealCrossRef::class)
    ) val meals: List<Meal>
        )