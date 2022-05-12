package com.example.mealplanner.data.models

import androidx.room.Entity

@Entity(primaryKeys = ["saturdayId","mealId"])
data class SaturdayMealCrossRef (
    val saturdayId : Long,
    val mealId : Long
)