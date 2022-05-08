package com.example.mealplanner.data.models.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.data.models.Monday
import com.example.mealplanner.data.models.MondayMealCrossRef

data class MondayWithMeals (
    @Embedded val monday: Monday,
    @Relation(
        parentColumn = "mondayId",
        entityColumn = "mealId",
        associateBy = Junction(MondayMealCrossRef::class)
    )
    val meals: List<Meal>
)