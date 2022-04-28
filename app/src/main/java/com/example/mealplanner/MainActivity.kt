package com.example.mealplanner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mealplanner.databinding.ActivityMainBinding
import com.example.mealplanner.ui.home.HomeViewModelFactory


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun getDefaultViewModelProviderFactory(): HomeViewModelFactory {
        return HomeViewModelFactory((application as MealsApplication).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}