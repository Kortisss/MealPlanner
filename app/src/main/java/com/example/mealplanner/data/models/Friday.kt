package com.example.mealplanner.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Friday (
        @PrimaryKey(autoGenerate = false) val fridayId :Long = 0
        )