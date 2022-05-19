package com.example.mealplanner.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.relations.FridayWithMeals
import com.example.mealplanner.databinding.InnerSectionRowBinding
import com.example.mealplanner.databinding.SectionRowBinding

class ChildWeekWithFridayWithMealsAdapter(private val list:List<FridayWithMeals>) : RecyclerView.Adapter<ChildWeekWithFridayWithMealsAdapter.FridayViewHolder>() {
    inner class FridayViewHolder(private val binding: InnerSectionRowBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(s: FridayWithMeals){
            binding.textViewSectionName.text = "Friday"
            binding.childRecyclerView.adapter = ChildRecyclerAdapter(s.meals)
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FridayViewHolder {
        return FridayViewHolder(InnerSectionRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(
        holder: FridayViewHolder,
        position: Int
    ) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}