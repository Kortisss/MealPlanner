package com.example.mealplanner.data.models

import androidx.room.Entity

@Entity(primaryKeys = ["mondayId","mealId"])
data class MondayMealCrossRef (
    val mondayId:Long,
    val mealId:Long
        )