package com.example.mealplanner.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.*
import com.example.mealplanner.data.models.*
import com.example.mealplanner.data.models.relations.*
import com.example.mealplanner.repository.MealRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: MealRepository) : ViewModel() {
    val allWeeks: LiveData<List<Week>> = repository.allWeeks.asLiveData()
    val allMeals: LiveData<List<Meal>> = repository.allMeals.asLiveData()
    val lastWeekId: LiveData<Long> = repository.loadLastWeekId.asLiveData()
    val setWeekToDisplay = MutableLiveData<Long>().apply { value = 1 }
    val lastMondayId: LiveData<Long> = repository.loadLastMondayId.asLiveData()
    val lastTuesdayId: LiveData<Long> = repository.loadLastTuesdayId.asLiveData()
    val lastWednesdayId: LiveData<Long> = repository.loadLastWednesdayId.asLiveData()
    val lastThursdayId: LiveData<Long> = repository.loadLastThursdayId.asLiveData()
    val lastFridayId: LiveData<Long> = repository.loadLastFridayId.asLiveData()
    val lastSaturdayId: LiveData<Long> = repository.loadLastSaturdayId.asLiveData()
    val lastSundayId: LiveData<Long> = repository.loadLastSundayId.asLiveData()

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

    fun insertAllMondayMeals(mondayMeals: List<MondayMealCrossRef>) = viewModelScope.launch {
        repository.insertAllMondayMealsCrossRef(mondayMeals)
    }
    fun insertWholeWeek(mondayMeals: List<MondayMealCrossRef>, tuesdayMeals: List<TuesdayMealCrossRef>,
                        wednesdayMeals: List<WednesdayMealCrossRef>, thursdayMeals: List<ThursdayMealCrossRef>,
                        fridayMeals: List<FridayMealCrossRef>, saturdayMeals: List<SaturdayMealCrossRef>,
                        sundayMeals: List<SundayMealCrossRef>) = viewModelScope.launch {
            repository.insertWholeWeek(mondayMeals,tuesdayMeals,wednesdayMeals,thursdayMeals,fridayMeals,saturdayMeals,sundayMeals)
    }
    fun insertDayweeks(monday: Monday,tuesday: Tuesday,wednesday: Wednesday,thursday: Thursday,friday: Friday,saturday: Saturday,sunday: Sunday) = viewModelScope.launch {
        repository.insertDayweeks(monday, tuesday, wednesday, thursday, friday, saturday, sunday)
    }
    fun insertOneWeek(week: Week) = viewModelScope.launch {
        repository.insert(week)
    }

    fun deleteMonday(monday: Monday) = viewModelScope.launch {
        repository.deleteMonday(monday)
    }
    fun deleteWholeWeek(id: Long) = viewModelScope.launch {
        repository.deleteWholeWeek(id)
    }
//    fun deleteWeekWithMondayWithMeals(week: Week, mondayMealCrossRef: List<MondayMealCrossRef>) = viewModelScope.launch {
//        repository.deleteWeekWithMondayWithMeals(week, mondayMealCrossRef)
//    }
//    -----------------example-----------------
//    fun insert(week: Week) = viewModelScope.launch {
//        repository.insert(week)
//    }
//    fun insert(monday: Monday) = viewModelScope.launch {
//            repository.insert(monday)
//    }
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