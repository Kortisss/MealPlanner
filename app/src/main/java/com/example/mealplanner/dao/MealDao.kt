package com.example.mealplanner.dao

import androidx.room.*
import com.example.mealplanner.data.models.*
import com.example.mealplanner.data.models.relations.MealWithWeek
import com.example.mealplanner.data.models.relations.WeekWithMeals
import com.example.mealplanner.data.models.relations.WeekWithMondayWithMeals
import kotlinx.coroutines.flow.Flow

@Dao
interface MealDao {
    //get
    @Transaction
    @Query("Select * from Week")
    fun getWeekWithMeals(): Flow<List<WeekWithMeals>>

    @Transaction
    @Query("SELECT * FROM Week WHERE weekId = :id")
    fun getWeekWithMealsById(id: Long): Flow<List<WeekWithMeals>>

    @Transaction
    @Query("Select * from Meal")
    fun getMealWithWeek(): Flow<List<MealWithWeek>>

    @Transaction
    @Query("select * from Week")
    fun getWeeks(): Flow<List<Week>>

    @Transaction
    @Query("Select * from Week where weekId = :id")
    fun getWeekWithMondayWithMealsById(id: Long): Flow<List<WeekWithMondayWithMeals>>


    //insert
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(meal: Meal)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(week: Week)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(weekMealCrossRef: WeekMealCrossRef)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(mondayMealCrossRef: MondayMealCrossRef)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(monday: Monday)

    //delete
    @Query("DELETE FROM Meal")
    suspend fun deleteMeal()

    @Query("DELETE FROM Week")
    suspend fun deleteWeek()

    @Query("DELETE FROM WeekMealCrossRef")
    suspend fun deleteWeekMealCrossRef()

    @Query("DELETE FROM MondayMealCrossRef")
    suspend fun deleteMondayMealCrossRef()

    @Query("DELETE FROM Monday")
    suspend fun deleteMonday()
}