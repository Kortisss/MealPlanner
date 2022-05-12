package com.example.mealplanner.ui.home

import androidx.lifecycle.*
import com.example.mealplanner.data.models.Week
import com.example.mealplanner.data.models.relations.*
import com.example.mealplanner.repository.MealRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.toCollection
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: MealRepository) : ViewModel() {
    val allWeeks: LiveData<List<Week>> = repository.allWeeks.asLiveData()
    val setWeekToDisplay = MutableLiveData<Long>().apply { value = 1 }

    private var _weekById = MutableLiveData<List<WeekWithMeals>>()
    var weekById : LiveData<List<WeekWithMeals>> = _weekById
    fun getWeekWithMeals(id: Long) = viewModelScope.launch() {
        _weekById.value = repository.loadWeekWithMealsById(id).first()
    }
    //weekWithMonday
    private var _weekWithMondayWithMeals = MutableLiveData<List<WeekWithMondayWithMeals>>()
    var weekWithMondayWithMeals : LiveData<List<WeekWithMondayWithMeals>> = _weekWithMondayWithMeals
    fun getWeekWithMondayWithMeals(id: Long) = viewModelScope.launch {
        _weekWithMondayWithMeals.value = repository.loadWeekWithMondayWithMealsById(id).first()
    }
    //weekWithTuesday
    private var _weekWithTuesdayWithMeals = MutableLiveData<List<WeekWithTuesdayWithMeals>>()
    var weekWithTuesdayWithMeals: LiveData<List<WeekWithTuesdayWithMeals>> = _weekWithTuesdayWithMeals
    fun getWeekWithTuesdayWithMeals(id: Long) = viewModelScope.launch {
        _weekWithTuesdayWithMeals.value = repository.loadWeekWithTuesdayWithMealsById(id).first()
    }
    //weekWithWednesday
    private var _weekWithWednesdayWithMeals = MutableLiveData<List<WeekWithWednesdayWithMeals>>()
    var weekWithWednesdayWithMeals: LiveData<List<WeekWithWednesdayWithMeals>> = _weekWithWednesdayWithMeals
    fun getWeekWithWednesdayWithMeals(id: Long) = viewModelScope.launch {
        _weekWithWednesdayWithMeals.value = repository.loadWeekWithWednesdayWithMealsById(id).first()
    }
    //weekWithThursday
    private var _weekWithThursdayWithMeals = MutableLiveData<List<WeekWithThursdayWithMeals>>()
    var weekWithThursdayWithMeals: LiveData<List<WeekWithThursdayWithMeals>> = _weekWithThursdayWithMeals
    fun getWeekWithThursdayWithMeals(id: Long) = viewModelScope.launch {
        _weekWithThursdayWithMeals.value = repository.loadWeekWithThursdayWithMealsById(id).first()
    }
    //weekWithFriday
    private var _weekWithFridayWithMeals = MutableLiveData<List<WeekWithFridayWithMeals>>()
    var weekWithFridayWithMeals: LiveData<List<WeekWithFridayWithMeals>> = _weekWithFridayWithMeals
    fun getWeekWithFridayWithMeals(id: Long) = viewModelScope.launch {
        _weekWithFridayWithMeals.value = repository.loadWeekWithFridayWithMealsById(id).first()
    }
    //weekWithSaturday
    private var _weekWithSaturdayWithMeals = MutableLiveData<List<WeekWithSaturdayWithMeals>>()
    var weekWithSaturdayWithMeals: LiveData<List<WeekWithSaturdayWithMeals>> = _weekWithSaturdayWithMeals
    fun getWeekWithSaturdayWithMeals(id: Long) = viewModelScope.launch {
        _weekWithSaturdayWithMeals.value = repository.loadWeekWithSaturdayWithMealsById(id).first()
    }
    //weekWithSunday
    private var _weekWithSundayWithMeals = MutableLiveData<List<WeekWithSundayWithMeals>>()
    var weekWithSundayWithMeals: LiveData<List<WeekWithSundayWithMeals>> = _weekWithSundayWithMeals
    fun getWeekWithSundayWithMeals(id: Long) = viewModelScope.launch {
        _weekWithSundayWithMeals.value = repository.loadWeekWithSundayWithMealsById(id).first()
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