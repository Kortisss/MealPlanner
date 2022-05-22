package com.example.mealplanner.repository

import androidx.annotation.WorkerThread
import com.example.mealplanner.dao.MealDao
import com.example.mealplanner.data.models.*
import com.example.mealplanner.data.models.relations.*

import kotlinx.coroutines.flow.Flow

class MealRepository(private val mealDao: MealDao) { //repository is connected only to MealDao
    //get
    val allWeeks = mealDao.getWeeks()
    val allMeals = mealDao.getMeals()
    fun loadWeekWithMealsById(id: Long?) = mealDao.getWeekWithMealsById(id!!)

    fun loadWeekWithMondayWithMealsById(id:Long?) = mealDao.getWeekWithMondayWithMealsById(id!!)
    fun loadWeekWithTuesdayWithMealsById(id:Long?) = mealDao.getWeekWithTuesdayWithMealsById(id!!)
    fun loadWeekWithWednesdayWithMealsById(id:Long?) = mealDao.getWeekWithWednesdayWithMealsById(id!!)
    fun loadWeekWithThursdayWithMealsById(id:Long?) = mealDao.getWeekWithThursdayWithMealsById(id!!)
    fun loadWeekWithFridayWithMealsById(id:Long?) = mealDao.getWeekWithFridayWithMealsById(id!!)
    fun loadWeekWithSaturdayWithMealsById(id:Long?) = mealDao.getWeekWithSaturdayWithMealsById(id!!)
    fun loadWeekWithSundayWithMealsById(id:Long?) = mealDao.getWeekWithSundayWithMealsById(id!!)

    val loadLastMondayId = mealDao.getLastMondayId()
    val loadLastTuesdayId = mealDao.getLastTuesdayId()
    val loadLastWednesdayId = mealDao.getLastWednesdayId()
    val loadLastThursdayId = mealDao.getLastThursdayId()
    val loadLastFridayId = mealDao.getLastFridayId()
    val loadLastSaturdayId = mealDao.getLastSaturdayId()
    val loadLastSundayId = mealDao.getLastSundayId()

    val loadLastWeekId = mealDao.getLastWeekId()

    //insert
    @Suppress
    @WorkerThread
    suspend fun insertWholeWeek(
        mondayMeals: List<MondayMealCrossRef>,
        tuesdayMeals: List<TuesdayMealCrossRef>,
        wednesdayMeals: List<WednesdayMealCrossRef>,
        thursdayMeals: List<ThursdayMealCrossRef>,
        fridayMeals: List<FridayMealCrossRef>,
        saturdayMeals: List<SaturdayMealCrossRef>,
        sundayMeals: List<SundayMealCrossRef>
    ){
        mealDao.insertWholeWeek(mondayMeals, tuesdayMeals, wednesdayMeals, thursdayMeals, fridayMeals, saturdayMeals, sundayMeals)
    }
    @Suppress
    @WorkerThread
    suspend fun insertAllMondayMealsCrossRef(mondayMeals: List<MondayMealCrossRef>){
        mealDao.insertAllMondayMealCrossRef(mondayMeals)
    }

    @Suppress
    @WorkerThread
    suspend fun insertDayweeks(monday: Monday, tuesday: Tuesday, wednesday: Wednesday, thursday: Thursday, friday: Friday, saturday: Saturday, sunday: Sunday){
        mealDao.insert(monday)
        mealDao.insert(tuesday)
        mealDao.insert(wednesday)
        mealDao.insert(thursday)
        mealDao.insert(friday)
        mealDao.insert(saturday)
        mealDao.insert(sunday)
    }
    @Suppress
    @WorkerThread
    suspend fun insert(week : Week){
        mealDao.insert(week)
    }

    @Suppress
    @WorkerThread
    suspend fun insert(meal: Meal){
        mealDao.insert(meal)
    }

    @Suppress
    @WorkerThread
    suspend fun deleteMonday(monday: Monday){
        mealDao.deleteMonday()
    }
    @Suppress
    @WorkerThread
    suspend fun deleteMealById(meal: Meal){
        mealDao.deleteMealById(meal)
    }

    @Suppress
    @WorkerThread
    suspend fun deleteWholeWeek(id: Long){
        mealDao.deleteWholeWeek(id)
    }
}