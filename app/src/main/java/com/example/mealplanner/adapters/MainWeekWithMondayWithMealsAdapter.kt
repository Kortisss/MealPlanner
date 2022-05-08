package com.example.mealplanner.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.relations.WeekWithMondayWithMeals
import com.example.mealplanner.databinding.SectionRowBinding

class MainWeekWithMondayWithMealsAdapter : ListAdapter<WeekWithMondayWithMeals,MainWeekWithMondayWithMealsAdapter.WeekViewHolder>(MondayWeekComparator()) {

    inner class WeekViewHolder(private val binding: SectionRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(s: WeekWithMondayWithMeals){
            val weekName = "week "+ s.week.weekId
            binding.textViewSectionName.text = weekName
            binding.childRecyclerView.adapter = ChildWeekWithMondayWithMealsAdapter(s.monday)
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainWeekWithMondayWithMealsAdapter.WeekViewHolder {
        return WeekViewHolder(SectionRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(
        holder: MainWeekWithMondayWithMealsAdapter.WeekViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }
    class MondayWeekComparator : DiffUtil.ItemCallback<WeekWithMondayWithMeals>() {
        override fun areItemsTheSame(
            oldItem: WeekWithMondayWithMeals,
            newItem: WeekWithMondayWithMeals
        ) = oldItem.week.weekId == newItem.week.weekId
        override fun areContentsTheSame(
            oldItem: WeekWithMondayWithMeals,
            newItem: WeekWithMondayWithMeals
        ) = oldItem == newItem
    }
}