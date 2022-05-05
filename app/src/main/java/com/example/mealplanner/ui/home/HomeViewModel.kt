package com.example.mealplanner.ui.home

import androidx.lifecycle.*
import com.example.mealplanner.data.models.Week
import com.example.mealplanner.data.models.relations.MealWithWeek
import com.example.mealplanner.data.models.relations.WeekWithMeals
import com.example.mealplanner.repository.MealRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: MealRepository) : ViewModel() {
    //mealsRepo
    val allWeeksWithMeals: LiveData<List<WeekWithMeals>> = repository.allWeeksWithMeals.asLiveData()
    //val allMealWithWeek: LiveData<List<MealWithWeek>> = repository.allMealWithWeek.asLiveData()
    val allWeeks: LiveData<List<Week>> = repository.allWeeks.asLiveData()

    fun insert(week: Week) = viewModelScope.launch {
        repository.insert(week)
    }

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