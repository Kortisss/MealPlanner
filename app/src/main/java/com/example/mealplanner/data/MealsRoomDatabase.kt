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
        WeekMealCrossRef::class,//todo: toDelete
        Monday::class,
        MondayMealCrossRef::class,
        Tuesday::class,
        TuesdayMealCrossRef::class,
        Wednesday::class,
        WednesdayMealCrossRef::class,
        Thursday::class,
        ThursdayMealCrossRef::class,
        Friday::class,
        FridayMealCrossRef::class,
        Saturday::class,
        SaturdayMealCrossRef::class,
        Sunday::class,
        SundayMealCrossRef::class
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
            mealDao.deleteWeekMealCrossRef()//todo: toDelete

            mealDao.deleteMondayMealCrossRef()
            mealDao.deleteTuesdayMealCrossRef()
            mealDao.deleteWednesdayMealCrossRef()
            mealDao.deleteThursdayMealCrossRef()
            mealDao.deleteFridayMealCrossRef()
            mealDao.deleteSaturdayMealCrossRef()
            mealDao.deleteSundayMealCrossRef()
            mealDao.deleteMonday()
            mealDao.deleteTuesday()
            mealDao.deleteWednesday()
            mealDao.deleteThursday()
            mealDao.deleteFriday()
            mealDao.deleteSaturday()
            mealDao.deleteSunday()

            //meal
            mealDao.insert(Meal("kurczak"))
            mealDao.insert(Meal("jabłko"))
            mealDao.insert(Meal("marchewka"))
            mealDao.insert(Meal("groszek"))
            mealDao.insert(Meal("kasza"))
            mealDao.insert(Meal("tuńczyk"))

            //monday
            mealDao.insert(Monday(1))
            mealDao.insertAllMondayMealCrossRef(listOf(MondayMealCrossRef(1,1),
                MondayMealCrossRef(1,2), MondayMealCrossRef(1,3)
                )
            )
            //tuesday
            mealDao.insert(Tuesday(1))
            mealDao.insert(TuesdayMealCrossRef(1,1))
            mealDao.insert(TuesdayMealCrossRef(1,2))
            mealDao.insert(TuesdayMealCrossRef(1,3))
            //wednesday
            mealDao.insert(Wednesday(1))
            mealDao.insert(WednesdayMealCrossRef(1,1))
            mealDao.insert(WednesdayMealCrossRef(1,5))
            mealDao.insert(WednesdayMealCrossRef(1,4))
            //thursday
            mealDao.insert(Thursday(1))
            mealDao.insert(ThursdayMealCrossRef(1,4))
            mealDao.insert(ThursdayMealCrossRef(1,2))
            mealDao.insert(ThursdayMealCrossRef(1,6))
            //friday
            mealDao.insert(Friday(1))
            mealDao.insert(FridayMealCrossRef(1,1))
            mealDao.insert(FridayMealCrossRef(1,2))
            mealDao.insert(FridayMealCrossRef(1,3))
            //saturday
            mealDao.insert(Saturday(1))
            mealDao.insert(SaturdayMealCrossRef(1,3))
            mealDao.insert(SaturdayMealCrossRef(1,2))
            mealDao.insert(SaturdayMealCrossRef(1,1))
            //sunday
            mealDao.insert(Sunday(1))
            mealDao.insert(SundayMealCrossRef(1,3))
            mealDao.insert(SundayMealCrossRef(1,6))
            mealDao.insert(SundayMealCrossRef(1,5))
            //week
            mealDao.insert(Week("dania na 1 tydzień"))

        /*


            mealDao.insert(WeekMealCrossRef(1,1))
            mealDao.insert(WeekMealCrossRef(2,1))
            mealDao.insert(WeekMealCrossRef(3,1))
            mealDao.insert(WeekMealCrossRef(3,2))
            mealDao.insert(WeekMealCrossRef(2,2))
            mealDao.insert(WeekMealCrossRef(1,3))
            mealDao.insert(WeekMealCrossRef(2,3))
        */
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
