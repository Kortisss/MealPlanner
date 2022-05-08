package com.example.mealplanner.ui.home

import androidx.lifecycle.*
import com.example.mealplanner.data.models.Week
import com.example.mealplanner.data.models.relations.WeekWithMeals
import com.example.mealplanner.data.models.relations.WeekWithMondayWithMeals
import com.example.mealplanner.repository.MealRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.toCollection
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: MealRepository) : ViewModel() {
    //mealsRepo
    val allWeeksWithMeals: LiveData<List<WeekWithMeals>> = repository.allWeeksWithMeals.asLiveData()
    //val allMealWithWeek: LiveData<List<MealWithWeek>> = repository.allMealWithWeek.asLiveData()
    val allWeeks: LiveData<List<Week>> = repository.allWeeks.asLiveData()
    //val weekWithMondayWithMeals: LiveData<List<WeekWithMondayWithMeals>> = repository.weekWithMondayWithMeals.asLiveData()
    val setWeekToDisplay = MutableLiveData<Long>().apply { value = 1 }

    private var _weekById = MutableLiveData<List<WeekWithMeals>>()
    var weekById : LiveData<List<WeekWithMeals>> = _weekById
    fun getWeekWithMeals(id: Long) = viewModelScope.launch() {
        _weekById.value = repository.loadWeekWithMealsById(id).first()
    }
    private var _weekWithMondayWithMeals = MutableLiveData<List<WeekWithMondayWithMeals>>()
    var weekWithMondayWithMeals : LiveData<List<WeekWithMondayWithMeals>> = _weekWithMondayWithMeals
    fun getWeekWithMondayWithMeals(id: Long) = viewModelScope.launch {
        _weekWithMondayWithMeals.value = repository.loadWeekWithMondayWithMealsById(id).first()
    }




    //fun insert(week: Week) = viewModelScope.launch {
    //    repository.insert(week)
    //}
  //  fun insert(monday: Monday) = viewModelScope.launch {
  //          repository.insert(monday)
  //  }
}
class HomeViewModelFactory(private val repository: MealRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}