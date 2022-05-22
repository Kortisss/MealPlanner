package com.example.mealplanner.ui.home

import android.graphics.Canvas
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mealplanner.R
import com.example.mealplanner.adapters.MealsAdapter
import com.example.mealplanner.databinding.FragmentMealsGridBinding


class MealsGridFragment: Fragment(R.layout.fragment_meals_grid) {

    private var _binding: FragmentMealsGridBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMealsGridBinding.inflate(inflater, container, false)
        val mealAdapter = MealsAdapter()
        homeViewModel.allMeals.observe(viewLifecycleOwner){
            mealAdapter.submitList(it)
        binding.apply {
            recyclerViewMeals.apply {
                adapter = mealAdapter
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                ItemTouchHelper(
                    object : ItemTouchHelper.SimpleCallback(
                        0, ItemTouchHelper.LEFT
                    ) {
                        override fun onMove(
                            recyclerView: RecyclerView,
                            viewHolder: ViewHolder, target: ViewHolder
                        ): Boolean {
                            return false
                        }

                        override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
                            if (homeViewModel.allWeeks.value!!.isNotEmpty()){
                                Toast.makeText(requireContext(), "Delete all previous plans before deleting meals!", Toast.LENGTH_SHORT).show()
                                val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.fragment_container_view) as NavHostFragment
                                val navController = navHostFragment.navController
                                navController.navigate(R.id.homeFragment)
                                return
                            }
                            val position = viewHolder.absoluteAdapterPosition
                            val item = mealAdapter.currentList[position]

                            homeViewModel.deleteMealById(item)
                        }
                    }).attachToRecyclerView(this)

                }
            }
        }
        binding.btnAddMealItem.setOnClickListener{
            val dialogFragment = InsertMealDialogFragment(homeViewModel)
            dialogFragment.show(childFragmentManager,"addMealDialogFragment")
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}