package com.example.mealplanner.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal_table")
data class Meal (
    val name: String,
    //@ColumnInfo(name = "ingredients")val ingredients: List<Ingredients>
    val sectionCreatorId: Int, //relation to Section entity
    @PrimaryKey(autoGenerate = true) val mealId: Int = 0
)

