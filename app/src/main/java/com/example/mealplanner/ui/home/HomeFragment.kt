package com.example.mealplanner.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealplanner.R
import com.example.mealplanner.adapters.*
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var mealList: List<Meal>

    private val homeViewModel: HomeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        homeViewModel.allWeeks.observe(viewLifecycleOwner){
            val weeksAdapter = WeeksAdapter(it, WeeksAdapter.OnClickListener{ click ->
                homeViewModel.setWeekToDisplay.value = click.weekId
                lifecycleScope.launch(){
                    homeViewModel.weekById.let { homeViewModel.getWeekWithMeals(click.weekId) }
                    homeViewModel.weekWithMondayWithMeals.let { homeViewModel.getWeekWithMondayWithMeals(click.weekId) }
                    homeViewModel.weekWithTuesdayWithMeals.let { homeViewModel.getWeekWithTuesdayWithMeals(click.weekId) }
                    homeViewModel.weekWithWednesdayWithMeals.let { homeViewModel.getWeekWithWednesdayWithMeals(click.weekId) }
                    homeViewModel.weekWithThursdayWithMeals.let { homeViewModel.getWeekWithThursdayWithMeals(click.weekId) }
                    homeViewModel.weekWithFridayWithMeals.let { homeViewModel.getWeekWithFridayWithMeals(click.weekId) }
                    homeViewModel.weekWithSaturdayWithMeals.let { homeViewModel.getWeekWithSaturdayWithMeals(click.weekId) }
                    homeViewModel.weekWithSundayWithMeals.let { homeViewModel.getWeekWithSundayWithMeals(click.weekId) }
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
        homeViewModel.allMeals.observe(viewLifecycleOwner){
            mealList = it
        }
        homeViewModel.weekWithMondayWithMeals.observe(viewLifecycleOwner){
            val weekWithMondayAdapter = MainWeekWithMondayWithMealsAdapter(MainWeekWithMondayWithMealsAdapter.OnClickListener{ click ->

                val dialogFragment = AddMealDialogFragment(mealList,click,homeViewModel)
                dialogFragment.show(childFragmentManager,"addMealDialogFragment")
            },homeViewModel)

            weekWithMondayAdapter.submitList(it)
            binding.apply {
                recyclerViewOfMondayMeals.apply {
                    adapter = weekWithMondayAdapter
                    layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
                    //this.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
                }
            }
        }
        homeViewModel.weekWithTuesdayWithMeals.observe(viewLifecycleOwner){
            val weekWithTuesdayAdapter = MainWeekWithTuesdayWithMealsAdapter()
            weekWithTuesdayAdapter.submitList(it)
            binding.apply {
                recyclerViewOfTuesdayMeals.apply {
                    adapter = weekWithTuesdayAdapter
                    layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
                }
            }
        }
        homeViewModel.weekWithWednesdayWithMeals.observe(viewLifecycleOwner){
            val weekWithWednesdayAdapter = MainWeekWithWednesdayWithMealsAdapter()
            weekWithWednesdayAdapter.submitList(it)
            binding.apply {
                recyclerViewOfWednesdayMeals.apply {
                    adapter = weekWithWednesdayAdapter
                    layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
                }
            }
        }
        homeViewModel.weekWithThursdayWithMeals.observe(viewLifecycleOwner){
            val weekWithThursdayAdapter = MainWeekWithThursdayWithMealsAdapter()
            weekWithThursdayAdapter.submitList(it)
            binding.apply {
                recyclerViewOfThursdayMeals.apply {
                    adapter = weekWithThursdayAdapter
                    layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
                }
            }
        }
        homeViewModel.weekWithFridayWithMeals.observe(viewLifecycleOwner){
            val weekWithFridayAdapter = MainWeekWithFridayWithMealsAdapter()
            weekWithFridayAdapter.submitList(it)
            binding.apply {
                recyclerViewOfFridayMeals.apply {
                    adapter = weekWithFridayAdapter
                    layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
                }
            }
        }
        homeViewModel.weekWithSaturdayWithMeals.observe(viewLifecycleOwner){
            val weekWithSaturdayAdapter = MainWeekWithSaturdayWithMealsAdapter()
            weekWithSaturdayAdapter.submitList(it)
            binding.apply {
                recyclerViewOfSaturdayMeals.apply {
                    adapter = weekWithSaturdayAdapter
                    layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
                }
            }
        }
        homeViewModel.weekWithSundayWithMeals.observe(viewLifecycleOwner){
            val weekWithSundayAdapter = MainWeekWithSundayWithMealsAdapter()
            weekWithSundayAdapter.submitList(it)
            binding.apply {
                recyclerViewOfSundayMeals.apply {
                    adapter = weekWithSundayAdapter
                    layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
                }
            }
        }
        binding.addWeekButton.setOnClickListener{
            val dialogFragment = AddWeekDialogFragment(mealList,homeViewModel)
            dialogFragment.show(childFragmentManager,"addWeekDialogFragment")
        }

        binding.editWeekButton.setOnClickListener{
            Toast.makeText(requireContext(), "klik", Toast.LENGTH_SHORT).show()
            val progressDialog = ProgressDialogFragment()
            progressDialog.show(childFragmentManager,"progressDialogFragment")
        }
        
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}