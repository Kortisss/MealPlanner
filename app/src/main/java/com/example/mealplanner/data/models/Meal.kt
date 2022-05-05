package com.example.mealplanner.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Meal (
    val name: String,
    @PrimaryKey(autoGenerate = true) val mealId: Long = 0
)