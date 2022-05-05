package com.example.mealplanner.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealplanner.R
import com.example.mealplanner.adapters.MainRecyclerAdapter
import com.example.mealplanner.adapters.MealListAdapter
import com.example.mealplanner.adapters.WeeksAdapter
import com.example.mealplanner.data.models.Week
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


        //val mealsAdapter = MealListAdapter()
        val sectionMainAdapter = MainRecyclerAdapter()
        binding.apply {
            recyclerViewOfMealsBySection.apply {
                adapter = sectionMainAdapter
                layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
                this.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
            }
        }
        homeViewModel.allWeeks.observe(viewLifecycleOwner){
            val weeksAdapter = WeeksAdapter(it, WeeksAdapter.OnClickListener{ click ->
                Toast.makeText(requireContext(),click.weekId.toString(), Toast.LENGTH_SHORT).show()
            })
            binding.apply {
                recyclerViewOfWeeks.apply {
                    adapter = weeksAdapter
                    layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
                }
            }
        }

        homeViewModel.allWeeksWithMeals.observe(viewLifecycleOwner){sections ->
            sections.let {
                sectionMainAdapter.submitList(it)
            }
        }
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}