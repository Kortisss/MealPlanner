package com.example.mealplanner.data.models

import androidx.room.Entity

@Entity(primaryKeys = ["wednesdayId","mealId"])
data class WednesdayMealCrossRef (
    val wednesdayId : Long,
    val mealId : Long
)