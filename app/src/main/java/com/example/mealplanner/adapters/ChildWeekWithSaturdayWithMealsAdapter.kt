package com.example.mealplanner.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.relations.SaturdayWithMeals
import com.example.mealplanner.databinding.InnerSectionRowBinding

class ChildWeekWithSaturdayWithMealsAdapter(private val list:List<SaturdayWithMeals>) : RecyclerView.Adapter<ChildWeekWithSaturdayWithMealsAdapter.SaturdayViewHolder>() {
    inner class SaturdayViewHolder(private val binding: InnerSectionRowBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(s: SaturdayWithMeals){
            binding.textViewSectionName.text = "Saturday"
            binding.childRecyclerView.adapter = ChildRecyclerAdapter(s.meals)
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SaturdayViewHolder {
        return SaturdayViewHolder(InnerSectionRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(
        holder: SaturdayViewHolder,
        position: Int
    ) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}