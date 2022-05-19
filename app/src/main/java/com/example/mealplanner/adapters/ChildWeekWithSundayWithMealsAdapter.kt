package com.example.mealplanner.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.relations.SundayWithMeals
import com.example.mealplanner.databinding.InnerSectionRowBinding

class ChildWeekWithSundayWithMealsAdapter(private val list:List<SundayWithMeals>) : RecyclerView.Adapter<ChildWeekWithSundayWithMealsAdapter.SundayViewHolder>() {
    inner class SundayViewHolder(private val binding: InnerSectionRowBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(s: SundayWithMeals){
            binding.textViewSectionName.text = "Sunday"
            binding.childRecyclerView.adapter = ChildRecyclerAdapter(s.meals)
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SundayViewHolder {
        return SundayViewHolder(InnerSectionRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(
        holder: SundayViewHolder,
        position: Int
    ) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}