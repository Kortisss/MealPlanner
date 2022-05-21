package com.example.mealplanner.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Thursday (
    @PrimaryKey(autoGenerate = false) val thursdayId :Long = 0
)