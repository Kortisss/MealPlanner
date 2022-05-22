package com.example.mealplanner

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
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

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        //Remove notification bar
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //noActionBar
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        setContentView(binding.root)
    }
}