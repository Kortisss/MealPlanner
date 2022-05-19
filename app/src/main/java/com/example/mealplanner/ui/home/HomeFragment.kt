package com.example.mealplanner.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealplanner.R
import com.example.mealplanner.adapters.*
import com.example.mealplanner.data.models.*
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
        //val mealsAdapter = MealListAdapter()

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
            })

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

//            inserting one day of the week
//            homeViewModel.insertDayweeks(Monday(), Tuesday(), Wednesday(), Thursday(),
//                Friday(), Saturday(), Sunday()
//            )
//            getting last id after btn click , added dayweeks
//
//            inserting  week + lists with meals
//            homeViewModel.insertOneWeek(Week("tydzień " + homeViewModel.lastWeekId.value!! +" opis"))
//            homeViewModel.insertAllMondayMeals(listOf(
//                MondayMealCrossRef(freshMondayId,1),
//                MondayMealCrossRef(freshMondayId,2),
//                MondayMealCrossRef(freshMondayId,3),
//            ))
//            homeViewModel.insertWholeWeek(
//                listOf(MondayMealCrossRef(freshMondayId,2),MondayMealCrossRef(freshMondayId,5),MondayMealCrossRef(freshMondayId,1)),
//                listOf(TuesdayMealCrossRef(freshTuesdayId,3),TuesdayMealCrossRef(freshTuesdayId,2),TuesdayMealCrossRef(freshTuesdayId,4)),
//                listOf(WednesdayMealCrossRef(freshWednesdayId,4),WednesdayMealCrossRef(freshWednesdayId,1),WednesdayMealCrossRef(freshWednesdayId,2)),
//                listOf(ThursdayMealCrossRef(freshThursdayId,1),ThursdayMealCrossRef(freshThursdayId,5),ThursdayMealCrossRef(freshThursdayId,6)),
//                listOf(FridayMealCrossRef(freshFridayId,2),FridayMealCrossRef(freshFridayId,5),FridayMealCrossRef(freshFridayId,1)),
//                listOf(SaturdayMealCrossRef(freshSaturdayId,4), SaturdayMealCrossRef(freshSaturdayId,6), SaturdayMealCrossRef(freshSaturdayId,1)),
//                listOf(SundayMealCrossRef(freshSundayId,1), SundayMealCrossRef(freshSundayId,2),SundayMealCrossRef(freshSundayId,5))
//                )
//        }
//            homeViewModel.lastMondayId.observe(viewLifecycleOwner){
//                freshMondayId = it + 1
//            }
//            homeViewModel.lastTuesdayId.observe(viewLifecycleOwner){
//                freshTuesdayId = it + 1
//            }
//            homeViewModel.lastWednesdayId.observe(viewLifecycleOwner){
//                freshWednesdayId = it + 1
//            }
//            homeViewModel.lastThursdayId.observe(viewLifecycleOwner){
//                freshThursdayId = it+ 1
//            }
//            homeViewModel.lastFridayId.observe(viewLifecycleOwner){
//                freshFridayId = it + 1
//            }
//            homeViewModel.lastSaturdayId.observe(viewLifecycleOwner){
//                freshSaturdayId = it + 1
//            }
//            homeViewModel.lastSundayId.observe(viewLifecycleOwner){
//                freshSundayId = it + 1
//            }
//            homeViewModel.lastWeekId.observe(viewLifecycleOwner){
//
//                           }
//
        }

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}