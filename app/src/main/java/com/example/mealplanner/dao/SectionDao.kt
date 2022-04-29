package com.example.mealplanner.dao

import androidx.room.*
import com.example.mealplanner.data.models.Section
import com.example.mealplanner.data.models.SectionWithMeals
import kotlinx.coroutines.flow.Flow

@Dao
interface SectionDao {
    //@Query("Select * from section_table")
    //fun getSections(): Flow<List<SectionWithMeals>>//to observe data changes, later converted to live data

    @Transaction
    @Query("SELECT * FROM section_table")
    fun getSectionWithMeals(): Flow<List<SectionWithMeals>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(section: Section)

    @Query("DELETE FROM section_table")
    suspend fun deleteAll()
}