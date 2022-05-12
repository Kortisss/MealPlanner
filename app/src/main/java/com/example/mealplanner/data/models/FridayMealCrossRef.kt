package com.example.mealplanner.data.models

import androidx.room.Entity

@Entity(primaryKeys = ["fridayId","mealId"])
data class FridayMealCrossRef (
        val fridayId : Long,
        val mealId : Long
        )