package com.example.mealplanner.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Sunday (
    @PrimaryKey(autoGenerate = true) val sundayId :Long = 0
        )