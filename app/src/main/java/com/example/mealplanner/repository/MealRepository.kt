package com.example.mealplanner.repository

import androidx.annotation.WorkerThread
import com.example.mealplanner.dao.MealDao
import com.example.mealplanner.dao.SectionDao
import com.example.mealplanner.dao.WeekDao
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.data.models.Section
import com.example.mealplanner.data.models.SectionWithMeals

import kotlinx.coroutines.flow.Flow

class MealRepository(private val mealDao:MealDao, private val sectionDao: SectionDao,private val weekDao: WeekDao) { //repository is connected only to MealDao
    //Meals Repo
    val allMeals: Flow<List<Meal>> = mealDao.getMeals()

    @Suppress
    @WorkerThread
    suspend fun insert(meal:Meal){
        mealDao.insert(meal)
    }
    //Section Repo
    val sectionMeals: Flow<List<SectionWithMeals>> = sectionDao.getSectionWithMeals()
    @Suppress
    @WorkerThread
    suspend fun insert(section: Section){
        sectionDao.insert(section)
    }

    //weeks Repo

    //val allWeeks: Flow<List<WeekAndSection>> = weekDao.getWeekWithSection()
}