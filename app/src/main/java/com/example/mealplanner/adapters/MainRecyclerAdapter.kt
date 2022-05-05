package com.example.mealplanner.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.relations.WeekWithMeals
import com.example.mealplanner.databinding.SectionRowBinding

class MainRecyclerAdapter : ListAdapter<WeekWithMeals,MainRecyclerAdapter.MainViewHolder>(SectionComparator()) {
    inner class MainViewHolder(private val binding: SectionRowBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(s: WeekWithMeals){
            //val weekDaysList = arrayOf("","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
            val weekName = "week" + s.week.weekId
            binding.textViewSectionName.text = weekName
            binding.childRecyclerView.adapter = ChildRecyclerAdapter(s.meals)
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainRecyclerAdapter.MainViewHolder {
        val binding = SectionRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainRecyclerAdapter.MainViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    class SectionComparator : DiffUtil.ItemCallback<WeekWithMeals>() {
        override fun areItemsTheSame(oldItem: WeekWithMeals, newItem: WeekWithMeals) =
            oldItem.week.weekId == newItem.week.weekId
        override fun areContentsTheSame(oldItem: WeekWithMeals, newItem: WeekWithMeals) =
            oldItem == newItem
    }
}