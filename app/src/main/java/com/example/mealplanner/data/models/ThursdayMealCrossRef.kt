package com.example.mealplanner.data.models

import androidx.room.Entity

@Entity(primaryKeys = ["thursdayId","mealId"])
data class ThursdayMealCrossRef (
    val thursdayId : Long,
    val mealId : Long
        )