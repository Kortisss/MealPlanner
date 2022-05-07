package com.example.mealplanner.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealplanner.R
import com.example.mealplanner.adapters.MainRecyclerAdapter
import com.example.mealplanner.adapters.MealListAdapter
import com.example.mealplanner.adapters.WeeksAdapter
import com.example.mealplanner.data.models.Week
import com.example.mealplanner.databinding.FragmentHomeBinding
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

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

        homeViewModel.allWeeks.observe(viewLifecycleOwner){
            val weeksAdapter = WeeksAdapter(it, WeeksAdapter.OnClickListener{ click ->
                homeViewModel.setWeekToDisplay.value = click.weekId
                lifecycleScope.launch(){
                    homeViewModel.weekById.let { homeViewModel.getWeekWithMeals(click.weekId) }
                }


                Toast.makeText(requireContext(),click.weekId.toString(), Toast.LENGTH_SHORT).show()


            })
            binding.apply {
                recyclerViewOfWeeks.apply {
                    adapter = weeksAdapter
                    layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
                }
            }
        }

        homeViewModel.weekById.observe(viewLifecycleOwner){
            val sectionMainAdapter = MainRecyclerAdapter()

            sectionMainAdapter.submitList(it)

            binding.apply {
                recyclerViewOfMealsBySection.apply {
                    adapter = sectionMainAdapter
                    layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
                    this.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
                }
            }
        }
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}