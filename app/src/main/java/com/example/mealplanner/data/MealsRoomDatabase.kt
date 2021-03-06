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
            mealDao.insert(Meal("jab??ko"))
            mealDao.insert(Meal("marchewka"))
            mealDao.insert(Meal("groszek"))
            mealDao.insert(Meal("kasza"))
            mealDao.insert(Meal("tu??czyk"))

            //monday
            mealDao.insert(Monday(0))
            mealDao.insertAllMondayMealCrossRef(listOf(MondayMealCrossRef(0,1),
                MondayMealCrossRef(0,2), MondayMealCrossRef(0,3)
                )
            )
            //tuesday
            mealDao.insert(Tuesday(0))
            mealDao.insert(TuesdayMealCrossRef(0,1))
            mealDao.insert(TuesdayMealCrossRef(0,2))
            mealDao.insert(TuesdayMealCrossRef(0,3))
            //wednesday
            mealDao.insert(Wednesday(0))
            mealDao.insert(WednesdayMealCrossRef(0,1))
            mealDao.insert(WednesdayMealCrossRef(0,5))
            mealDao.insert(WednesdayMealCrossRef(0,4))
            //thursday
            mealDao.insert(Thursday(0))
            mealDao.insert(ThursdayMealCrossRef(0,4))
            mealDao.insert(ThursdayMealCrossRef(0,2))
            mealDao.insert(ThursdayMealCrossRef(0,6))
            //friday
            mealDao.insert(Friday(0))
            mealDao.insert(FridayMealCrossRef(0,1))
            mealDao.insert(FridayMealCrossRef(0,2))
            mealDao.insert(FridayMealCrossRef(0,3))
            //saturday
            mealDao.insert(Saturday(0))
            mealDao.insert(SaturdayMealCrossRef(0,3))
            mealDao.insert(SaturdayMealCrossRef(0,2))
            mealDao.insert(SaturdayMealCrossRef(0,1))
            //sunday
            mealDao.insert(Sunday(0))
            mealDao.insert(SundayMealCrossRef(0,3))
            mealDao.insert(SundayMealCrossRef(0,6))
            mealDao.insert(SundayMealCrossRef(0,5))
            //week
            mealDao.insert(Week("dania na 1 tydzie??",0))

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
