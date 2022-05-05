package com.example.mealplanner

import android.app.Application
import com.example.mealplanner.data.MealsRoomDatabase
import com.example.mealplanner.repository.MealRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MealsApplication : Application(){
    private val applicationScope = CoroutineScope(SupervisorJob())
    private val database by lazy { MealsRoomDatabase.getDatabase(this,applicationScope) } //creating only one instance of repository in app
    val repository by lazy { MealRepository(database.mealDao()) }
}