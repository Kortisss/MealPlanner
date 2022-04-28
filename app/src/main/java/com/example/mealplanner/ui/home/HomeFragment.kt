package com.example.mealplanner.ui.home

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealplanner.MealsApplication
import com.example.mealplanner.R
import com.example.mealplanner.adapters.MealListAdapter
import com.example.mealplanner.adapters.WeeksAdapter
import com.example.mealplanner.data.models.Weeks
import com.example.mealplanner.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val nameList : MutableList<Weeks> = mutableListOf()
        nameList.add(Weeks("week1"))
        nameList.add(Weeks("week2"))
        nameList.add(Weeks("week3"))
        nameList.add(Weeks("week3"))
        nameList.add(Weeks("week3"))
        nameList.add(Weeks("week3"))
        nameList.add(Weeks("week3"))
        nameList.add(Weeks("week3"))

        val weeksAdapter = WeeksAdapter(nameList, WeeksAdapter.OnClickListener{ click ->
            Toast.makeText(requireContext(),click.name, Toast.LENGTH_SHORT).show()
        })
        val mealsAdapter = MealListAdapter()
        binding.apply {
            recyclerViewOfWeeks.apply {
                adapter = weeksAdapter
                layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            }
        }

        binding.apply {
            recyclerViewOfMeals.apply {
                adapter = mealsAdapter
                layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            }
        }
        homeViewModel.allMeals.observe(viewLifecycleOwner){meals ->
            meals.let { mealsAdapter.submitList(it) }
        }

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}