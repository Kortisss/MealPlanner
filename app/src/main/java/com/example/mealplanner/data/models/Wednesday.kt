package com.example.mealplanner.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Wednesday (
    @PrimaryKey(autoGenerate = true) val wednesdayId :Long = 0
        )