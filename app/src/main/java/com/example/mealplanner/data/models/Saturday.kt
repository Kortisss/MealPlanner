package com.example.mealplanner.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Saturday (
    @PrimaryKey(autoGenerate = true) val saturdayId :Long = 0
        )