package com.example.mealplanner.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.relations.ThursdayWithMeals
import com.example.mealplanner.databinding.SectionRowBinding

class ChildWeekWithThursdayWithMealsAdapter(private val list:List<ThursdayWithMeals>) : RecyclerView.Adapter<ChildWeekWithThursdayWithMealsAdapter.ThursdayViewHolder>() {
    inner class ThursdayViewHolder(private val binding: SectionRowBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(s: ThursdayWithMeals){
            binding.textViewSectionName.text = "Thursday"
            binding.childRecyclerView.adapter = ChildRecyclerAdapter(s.meals)
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ThursdayViewHolder {
        return ThursdayViewHolder(SectionRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(
        holder: ThursdayViewHolder,
        position: Int
    ) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}