package com.example.mealplanner.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "weekAndSection_table")
class WeekAndSection (
    val sectionId: Int,

    @PrimaryKey(autoGenerate = true) val id: Int
)