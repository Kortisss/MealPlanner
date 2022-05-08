package com.example.mealplanner.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Monday (
    @PrimaryKey(autoGenerate = true) val mondayId :Long = 0
        )