package com.example.mealplanner.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.relations.WednesdayWithMeals
import com.example.mealplanner.databinding.InnerSectionRowBinding

class ChildWeekWithWednesdayWithMealsAdapter(private val list:List<WednesdayWithMeals>) :
    RecyclerView.Adapter<ChildWeekWithWednesdayWithMealsAdapter.WednesdayViewHolder>() {
    class WednesdayViewHolder(private val binding: InnerSectionRowBinding) :RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(s: WednesdayWithMeals){
            binding.textViewSectionName.text = "Wednesday"
            binding.childRecyclerView.adapter = ChildRecyclerAdapter(s.meals)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WednesdayViewHolder {
        return WednesdayViewHolder(InnerSectionRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: WednesdayViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}