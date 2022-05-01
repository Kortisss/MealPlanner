package com.example.mealplanner.dao

import androidx.room.*
import com.example.mealplanner.data.models.WeekAndSection
import com.example.mealplanner.data.models.Weeks
import kotlinx.coroutines.flow.Flow

@Dao
interface WeekDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(weeks: Weeks)

    @Query("DELETE FROM weeks_table")
    suspend fun deleteAll()
}