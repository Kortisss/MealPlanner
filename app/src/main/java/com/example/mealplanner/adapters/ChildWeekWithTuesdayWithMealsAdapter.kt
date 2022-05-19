package com.example.mealplanner.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.relations.TuesdayWithMeals
import com.example.mealplanner.databinding.InnerSectionRowBinding

class ChildWeekWithTuesdayWithMealsAdapter(private val list:List<TuesdayWithMeals>) : RecyclerView.Adapter<ChildWeekWithTuesdayWithMealsAdapter.TuesdayViewHolder>() {
    inner class TuesdayViewHolder(private val binding: InnerSectionRowBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(s: TuesdayWithMeals){
            binding.textViewSectionName.text = "Tuesday"
            binding.childRecyclerView.adapter = ChildRecyclerAdapter(s.meals)
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TuesdayViewHolder {
        return TuesdayViewHolder(InnerSectionRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(
        holder: TuesdayViewHolder,
        position: Int
    ) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}