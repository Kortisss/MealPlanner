package com.example.mealplanner.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weeks_table")
data class Weeks (
    val name:String,
    @PrimaryKey(autoGenerate = true) val weekId: Long = 0
)