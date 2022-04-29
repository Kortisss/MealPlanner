package com.example.mealplanner.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mealplanner.dao.MealDao
import com.example.mealplanner.dao.SectionDao
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.data.models.Section
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Meal::class, Section::class], version = 1)
abstract class MealsRoomDatabase : RoomDatabase() {
    abstract fun mealDao(): MealDao
    abstract fun sectionDao(): SectionDao
    //callback for adding stuff to database
    private class MealsDatabaseCallback(
        private val scope: CoroutineScope
    ):RoomDatabase.Callback(){
        override fun onCreate(database: SupportSQLiteDatabase) {
            super.onCreate(database)
            INSTANCE?.let {
                database -> scope.launch {
                populateMeal(database.mealDao())
                populateSection(database.sectionDao())
                }
            }
        }
        suspend fun populateMeal(mealDao: MealDao){
            mealDao.deleteAll()
            mealDao.insert(Meal("kurczak z ryżem",0)) //0 - brak przyisania , 1:7 - pon,wt,śr,czw,pt,sob,nd
            mealDao.insert(Meal("sałatka warzywna",1))
            mealDao.insert(Meal("pączek",2))
            mealDao.insert(Meal("sałatka",3))
            mealDao.insert(Meal("jabłko",4))
            mealDao.insert(Meal("banan",5))
            mealDao.insert(Meal("banan",5))
            mealDao.insert(Meal("banan",6))
            mealDao.insert(Meal("ciatko",6))
            mealDao.insert(Meal("banan",7))
        }
        suspend fun populateSection(sectionDao: SectionDao){
            sectionDao.deleteAll()
            sectionDao.insert(Section(1,"Monday"))
            sectionDao.insert(Section(2,"Tuesday"))
            sectionDao.insert(Section(3,"Wednesday"))
            sectionDao.insert(Section(4,"Thursday"))
            sectionDao.insert(Section(5,"Friday"))
            sectionDao.insert(Section(6,"Saturday"))
            sectionDao.insert(Section(7,"Sunday"))
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
