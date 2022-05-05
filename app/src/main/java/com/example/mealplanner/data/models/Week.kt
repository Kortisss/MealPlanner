package com.example.mealplanner.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Week (
    val description: String,

    @PrimaryKey(autoGenerate = true) val weekId: Long = 0
)