package com.example.mealplanner.data.models

import androidx.room.Entity

@Entity(primaryKeys = ["sundayId","mealId"])
data class SundayMealCrossRef (
    val sundayId : Long,
    val mealId : Long
)