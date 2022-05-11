package com.example.mealplanner.repository

import androidx.annotation.WorkerThread
import com.example.mealplanner.dao.MealDao
import com.example.mealplanner.data.models.Week
import com.example.mealplanner.data.models.relations.MealWithWeek
import com.example.mealplanner.data.models.relations.WeekWithMeals

import kotlinx.coroutines.flow.Flow

class MealRepository(private val mealDao: MealDao) { //repository is connected only to MealDao

    val allWeeksWithMeals = mealDao.getWeekWithMeals()
    val allMealWithWeek = mealDao.getMealWithWeek()
    val allWeeks = mealDao.getWeeks()
    fun loadWeekWithMealsById(id: Long?) = mealDao.getWeekWithMealsById(id!!)
    fun loadWeekWithMondayWithMealsById(id:Long?) = mealDao.getWeekWithMondayWithMealsById(id!!)
    fun loadWeekWithTuesdayWithMealsById(id:Long?) = mealDao.getWeekWithTuesdayWithMealsById(id!!)
    fun loadWeekWithWednesdayWithMealsById(id:Long?) = mealDao.getWeekWithWednesdayWithMealsById(id!!)

    @Suppress
    @WorkerThread
    suspend fun insert(week : Week){
        mealDao.insert(week)
    }

}