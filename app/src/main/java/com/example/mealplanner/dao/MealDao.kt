package com.example.mealplanner.dao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mealplanner.data.models.Meal
import kotlinx.coroutines.flow.Flow

@Dao
interface MealDao {
    @Query("Select * from meal_table")
    fun getMeals(): Flow<List<Meal>>//to observe data changes, later converted to live data

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(meal: Meal)

    @Query("DELETE FROM meal_table")
    suspend fun deleteAll()
}