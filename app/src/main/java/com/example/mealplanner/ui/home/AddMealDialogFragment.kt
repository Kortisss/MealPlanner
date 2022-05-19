package com.example.mealplanner.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.viewModelScope
import com.example.mealplanner.R
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.data.models.MondayMealCrossRef
import com.example.mealplanner.data.models.relations.WeekWithMondayWithMeals

class AddMealDialogFragment(
    private val mealList: List<Meal>,
    private val click: WeekWithMondayWithMeals,
    private val homeViewModel: HomeViewModel
) : DialogFragment() {
    private lateinit var spinner: Spinner
    private lateinit var btnOK: Button

    private lateinit var choosedMeal: Meal
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_meal_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mealNameList = mealList.map { s -> s.name }

        val adapterMealList = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            mealNameList
        )
        spinner = view.findViewById(R.id.spinnerMeals)
        spinner.adapter = adapterMealList
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                Toast.makeText(requireContext(), mealList[position].name, Toast.LENGTH_SHORT).show()
                choosedMeal = mealList[position]
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        btnOK = view.findViewById(R.id.btnAccept)
        btnOK.setOnClickListener{
            homeViewModel.insertAllMondayMeals(listOf(MondayMealCrossRef(click.week.weekId,choosedMeal.mealId)))
            dismiss()
        }

    }
            //

    companion object {
        const val TAG = "AddMealDiaglogFragment"
    }
}