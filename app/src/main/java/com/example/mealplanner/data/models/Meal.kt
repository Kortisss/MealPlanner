package com.example.mealplanner.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.VersionedParcelize

@Entity(tableName = "meal_table")
class Meal (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    //@ColumnInfo(name = "ingredients")val ingredients: List<Ingredients>
)

