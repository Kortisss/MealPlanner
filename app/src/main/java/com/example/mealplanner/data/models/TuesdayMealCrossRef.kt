package com.example.mealplanner.data.models

import androidx.room.Entity

@Entity(primaryKeys = ["tuesdayId","mealId"])
data class TuesdayMealCrossRef (
    val tuesdayId : Long,
    val mealId : Long
        )