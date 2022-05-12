package com.example.mealplanner.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
//todo: toDelete
@Entity(primaryKeys = ["mealId","weekId"])
data class WeekMealCrossRef (
    val mealId:Long,
    val weekId:Long
)