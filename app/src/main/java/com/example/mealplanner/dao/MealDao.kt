package com.example.mealplanner.dao

import androidx.room.*
import com.example.mealplanner.data.models.*
import com.example.mealplanner.data.models.relations.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MealDao {
    //get
    @Transaction//todo: toDelete
    @Query("Select * from Week")//todo: toDelete
    fun getWeekWithMeals(): Flow<List<WeekWithMeals>>//todo: toDelete
    @Transaction//todo: toDelete
    @Query("SELECT * FROM Week WHERE weekId = :id")//todo: toDelete
    fun getWeekWithMealsById(id: Long): Flow<List<WeekWithMeals>>//todo: toDelete
    @Transaction//to delete
    @Query("Select * from Meal")//todo: toDelete
    fun getMealWithWeek(): Flow<List<MealWithWeek>>//todo: toDelete

    @Transaction
    @Query("select * from Week")
    fun getWeeks(): Flow<List<Week>>

    @Transaction
    @Query("Select * from Week where weekId = :id")
    fun getWeekWithMondayWithMealsById(id: Long): Flow<List<WeekWithMondayWithMeals>>
    @Transaction
    @Query("Select * from Week where weekId = :id")
    fun getWeekWithTuesdayWithMealsById(id: Long): Flow<List<WeekWithTuesdayWithMeals>>
    @Transaction
    @Query("Select * from Week where weekId = :id")
    fun getWeekWithWednesdayWithMealsById(id: Long): Flow<List<WeekWithWednesdayWithMeals>>
    @Transaction
    @Query("Select * from Week where weekId = :id")
    fun getWeekWithThursdayWithMealsById(id: Long): Flow<List<WeekWithThursdayWithMeals>>
    @Transaction
    @Query("Select * from Week where weekId = :id")
    fun getWeekWithFridayWithMealsById(id: Long): Flow<List<WeekWithFridayWithMeals>>
    @Transaction
    @Query("Select * from Week where weekId = :id")
    fun getWeekWithSaturdayWithMealsById(id: Long): Flow<List<WeekWithSaturdayWithMeals>>
    @Transaction
    @Query("Select * from Week where weekId = :id")
    fun getWeekWithSundayWithMealsById(id: Long): Flow<List<WeekWithSundayWithMeals>>


    //insert
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertWholeWeek(week:Week,
                                MondayMeals: List<MondayMealCrossRef>,
                                wednesdayMeals: List<WednesdayMealCrossRef>,
                                thursdayMeals: List<ThursdayMealCrossRef>,
                                friday: List<FridayMealCrossRef>,
                                saturday: List<SaturdayMealCrossRef>,
                                sunday: List<SundayMealCrossRef>
    )

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(meal: Meal)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(week: Week)

    @Insert(onConflict = OnConflictStrategy.IGNORE)//todo: toDelete
    suspend fun insert(weekMealCrossRef: WeekMealCrossRef)//todo: toDelete

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(mondayMealCrossRef: MondayMealCrossRef)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(tuesdayMealCrossRef: TuesdayMealCrossRef)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(wednesdayMealCrossRef: WednesdayMealCrossRef)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(thursdayMealCrossRef: ThursdayMealCrossRef)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(fridayMealCrossRef: FridayMealCrossRef)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(saturdayMealCrossRef: SaturdayMealCrossRef)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(sundayMealCrossRef: SundayMealCrossRef)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(monday: Monday)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(tuesday: Tuesday)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(wednesday: Wednesday)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(thursday: Thursday)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(friday: Friday)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(saturday: Saturday)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(sunday: Sunday)



    //delete
    @Query("DELETE FROM Meal")
    suspend fun deleteMeal()
    @Query("DELETE FROM Week")
    suspend fun deleteWeek()

    @Query("DELETE FROM WeekMealCrossRef")//todo: toDelete
    suspend fun deleteWeekMealCrossRef()//todo: toDelete
    @Query("DELETE FROM MondayMealCrossRef")
    suspend fun deleteMondayMealCrossRef()
    @Query("DELETE FROM TuesdayMealCrossRef")
    suspend fun deleteTuesdayMealCrossRef()
    @Query("DELETE FROM WednesdayMealCrossRef")
    suspend fun deleteWednesdayMealCrossRef()
    @Query("DELETE FROM ThursdayMealCrossRef")
    suspend fun deleteThursdayMealCrossRef()
    @Query("DELETE FROM FridayMealCrossRef")
    suspend fun deleteFridayMealCrossRef()
    @Query("DELETE FROM SaturdayMealCrossRef")
    suspend fun deleteSaturdayMealCrossRef()
    @Query("DELETE FROM SundayMealCrossRef")
    suspend fun deleteSundayMealCrossRef()

    @Query("DELETE FROM Monday")
    suspend fun deleteMonday()
    @Query("DELETE FROM Tuesday")
    suspend fun deleteTuesday()
    @Query("DELETE FROM Wednesday")
    suspend fun deleteWednesday()
    @Query("DELETE FROM Thursday")
    suspend fun deleteThursday()
    @Query("DELETE FROM Friday")
    suspend fun deleteFriday()
    @Query("DELETE FROM Saturday")
    suspend fun deleteSaturday()
    @Query("DELETE FROM Sunday")
    suspend fun deleteSunday()

    //update
}