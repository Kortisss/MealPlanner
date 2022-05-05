package com.example.mealplanner.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(primaryKeys = ["mealId","weekId"])
data class WeekMealCrossRef (
    val mealId:Long,
    val weekId:Long
)