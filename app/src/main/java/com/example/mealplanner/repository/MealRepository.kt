package com.example.mealplanner.repository

import androidx.annotation.WorkerThread
import com.example.mealplanner.dao.MealDao
import com.example.mealplanner.data.models.Meal
import kotlinx.coroutines.flow.Flow

class MealRepository(private val mealDao:MealDao) { //repository is connected only to MealDao
    val allMeals: Flow<List<Meal>> = mealDao.getMeals()

    @Suppress
    @WorkerThread
    suspend fun insert(meal:Meal){
        mealDao.insert(meal)
    }
}