package com.example.mealplanner.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tuesday (
    @PrimaryKey(autoGenerate = false) val tuesdayId :Long = 0
        )