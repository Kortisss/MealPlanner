package com.example.mealplanner.repository

import androidx.annotation.WorkerThread
import com.example.mealplanner.dao.MealDao
import com.example.mealplanner.data.models.*
import com.example.mealplanner.data.models.relations.MealWithWeek
import com.example.mealplanner.data.models.relations.ThursdayWithMeals
import com.example.mealplanner.data.models.relations.WeekWithMeals
import com.example.mealplanner.data.models.relations.WeekWithSundayWithMeals

import kotlinx.coroutines.flow.Flow

class MealRepository(private val mealDao: MealDao) { //repository is connected only to MealDao
    //get
    val allWeeks = mealDao.getWeeks()
    fun loadWeekWithMealsById(id: Long?) = mealDao.getWeekWithMealsById(id!!)

    fun loadWeekWithMondayWithMealsById(id:Long?) = mealDao.getWeekWithMondayWithMealsById(id!!)
    fun loadWeekWithTuesdayWithMealsById(id:Long?) = mealDao.getWeekWithTuesdayWithMealsById(id!!)
    fun loadWeekWithWednesdayWithMealsById(id:Long?) = mealDao.getWeekWithWednesdayWithMealsById(id!!)
    fun loadWeekWithThursdayWithMealsById(id:Long?) = mealDao.getWeekWithThursdayWithMealsById(id!!)
    fun loadWeekWithFridayWithMealsById(id:Long?) = mealDao.getWeekWithFridayWithMealsById(id!!)
    fun loadWeekWithSaturdayWithMealsById(id:Long?) = mealDao.getWeekWithSaturdayWithMealsById(id!!)
    fun loadWeekWithSundayWithMealsById(id:Long?) = mealDao.getWeekWithSundayWithMealsById(id!!)

    //insert
    @Suppress
    @WorkerThread
    suspend fun insert(week : Week){
        mealDao.insert(week)
    }
    @Suppress
    @WorkerThread
    suspend fun insert(monday: Monday){
        mealDao.insert(monday)
    }
    @Suppress
    @WorkerThread
    suspend fun insert(tuesday: Tuesday){
        mealDao.insert(tuesday)
    }
    @Suppress
    @WorkerThread
    suspend fun insert(wednesday: Wednesday){
        mealDao.insert(wednesday)
    }
    @Suppress
    @WorkerThread
    suspend fun insert(thursday: Thursday){
        mealDao.insert(thursday)
    }
    @Suppress
    @WorkerThread
    suspend fun insert(friday: Friday){
        mealDao.insert(friday)
    }
    @Suppress
    @WorkerThread
    suspend fun insert(saturday: Saturday){
        mealDao.insert(saturday)
    }
    @Suppress
    @WorkerThread
    suspend fun insert(sunday: Sunday){
        mealDao.insert(sunday)
    }

    @Suppress
    @WorkerThread
    suspend fun insert(mondayMealCrossRef: MondayMealCrossRef){
        mealDao.insert(mondayMealCrossRef)
    }
    @Suppress
    @WorkerThread
    suspend fun insert(tuesdayMealCrossRef: TuesdayMealCrossRef){
        mealDao.insert(tuesdayMealCrossRef)
    }
    @Suppress
    @WorkerThread
    suspend fun insert(wednesdayMealCrossRef: WednesdayMealCrossRef){
        mealDao.insert(wednesdayMealCrossRef)
    }
    @Suppress
    @WorkerThread
    suspend fun insert(thursdayMealCrossRef: ThursdayMealCrossRef){
        mealDao.insert(thursdayMealCrossRef)
    }
    @Suppress
    @WorkerThread
    suspend fun insert(fridayMealCrossRef: FridayMealCrossRef){
        mealDao.insert(fridayMealCrossRef)
    }
    @Suppress
    @WorkerThread
    suspend fun insert(saturdayMealCrossRef: SaturdayMealCrossRef){
        mealDao.insert(saturdayMealCrossRef)
    }
    @Suppress
    @WorkerThread
    suspend fun insert(sundayMealCrossRef: SundayMealCrossRef){
        mealDao.insert(sundayMealCrossRef)
    }

}