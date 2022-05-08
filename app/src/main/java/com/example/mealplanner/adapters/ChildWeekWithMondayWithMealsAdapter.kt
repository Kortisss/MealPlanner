package com.example.mealplanner.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.relations.MondayWithMeals
import com.example.mealplanner.databinding.SectionRowBinding

class ChildWeekWithMondayWithMealsAdapter(private val list: List<MondayWithMeals>) : RecyclerView.Adapter<ChildWeekWithMondayWithMealsAdapter.MondayViewHolder>() {
    inner class MondayViewHolder(private val binding: SectionRowBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(s: MondayWithMeals){
            binding.textViewSectionName.text = "Monday"
            binding.childRecyclerView.adapter = ChildRecyclerAdapter(s.meals)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MondayViewHolder {
        return MondayViewHolder(SectionRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: MondayViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}