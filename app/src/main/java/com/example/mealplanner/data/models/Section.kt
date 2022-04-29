package com.example.mealplanner.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "section_table")
data class Section(
    @PrimaryKey(autoGenerate = true) val sectionId: Int,
    val sectionName: String
)

