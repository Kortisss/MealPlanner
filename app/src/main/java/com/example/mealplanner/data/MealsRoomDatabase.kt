package com.example.mealplanner.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mealplanner.dao.MealDao
import com.example.mealplanner.data.models.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [
        Week::class,
        Meal::class,
        WeekMealCrossRef::class
    ],
    version = 1
)

abstract class MealsRoomDatabase : RoomDatabase() {

    abstract fun mealDao(): MealDao

    //callback for adding stuff to database
    private class MealsDatabaseCallback(
        private val scope: CoroutineScope
    ):RoomDatabase.Callback(){
        override fun onCreate(database: SupportSQLiteDatabase) {
            super.onCreate(database)
            INSTANCE?.let {
                database -> scope.launch {
                    populateMonday(database.mealDao())
                }
            }
        }
        suspend fun populateMonday(mealDao: MealDao){
            mealDao.deleteWeek()
            mealDao.deleteMeal()
            mealDao.deleteWeekMealCrossRef()

            mealDao.insert(Meal("kurczak"))
            mealDao.insert(Meal("jabłko"))
            mealDao.insert(Meal("marchewka"))
            mealDao.insert(Meal("groszek"))

            mealDao.insert(Week("dania na 1 tydzień"))
            mealDao.insert(Week("dania na 2 tydzień"))
            mealDao.insert(Week("dania na 3 tydzień"))

            mealDao.insert(WeekMealCrossRef(1,1))
            mealDao.insert(WeekMealCrossRef(2,1))
            mealDao.insert(WeekMealCrossRef(3,1))
            mealDao.insert(WeekMealCrossRef(3,2))
            mealDao.insert(WeekMealCrossRef(2,2))
            mealDao.insert(WeekMealCrossRef(1,3))
            mealDao.insert(WeekMealCrossRef(2,3))

        }
    }
    //instance of db
    companion object{
        @Volatile
        private var INSTANCE: MealsRoomDatabase? = null

        fun getDatabase(context: Context,scope: CoroutineScope): MealsRoomDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MealsRoomDatabase::class.java,
                    "Meals_database"
                ).addCallback(MealsDatabaseCallback(scope)).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
