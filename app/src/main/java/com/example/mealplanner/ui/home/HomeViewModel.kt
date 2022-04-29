package com.example.mealplanner.ui.home

import androidx.lifecycle.*
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.data.models.Section
import com.example.mealplanner.data.models.SectionWithMeals
import com.example.mealplanner.repository.MealRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class HomeViewModel(private val repository: MealRepository) : ViewModel() {
    //mealsRepo
    val allMeals: LiveData<List<Meal>> = repository.allMeals.asLiveData()

    fun insert(meal:Meal) = viewModelScope.launch {
        repository.insert(meal)
    }
    //sectionRepo
    val sectionMeals: LiveData<List<SectionWithMeals>> = repository.sectionMeals.asLiveData()
    fun insert(section: Section) = viewModelScope.launch {
        repository.insert(section)
    }

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