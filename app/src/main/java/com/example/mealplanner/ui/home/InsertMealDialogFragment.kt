package com.example.mealplanner.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.databinding.InsertMealDialogFragmentBinding

class InsertMealDialogFragment(private val homeViewModel: HomeViewModel) :DialogFragment() {

    private var _binding: InsertMealDialogFragmentBinding? = null
    private val binding get() = _binding!!
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = InsertMealDialogFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editTextMealName
        binding.buttonAddMeal.setOnClickListener{
            if (binding.editTextMealName.text.matches(Regex(""))){
                Toast.makeText(requireContext(), "Fill in the blanks!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            homeViewModel.insertMeal(Meal(binding.editTextMealName.text.toString()))
            dismiss()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}