package com.example.mealplanner.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Thursday (
    @PrimaryKey(autoGenerate = true) val thursdayId :Long = 0
)