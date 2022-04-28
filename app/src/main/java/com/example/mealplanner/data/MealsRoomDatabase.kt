package com.example.mealplanner.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mealplanner.dao.MealDao
import com.example.mealplanner.data.models.Meal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Meal::class], version = 1)
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
                populateDatabase(database.mealDao())
            }
            }
        }
        suspend fun populateDatabase(mealDao: MealDao){
            mealDao.deleteAll()
            mealDao.insert(Meal(1,"kurczak z ryżem"))
            mealDao.insert(Meal(2,"sałatka warzywna"))
            mealDao.insert(Meal(3,"pączek"))
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
