package com.example.mealplanner.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.relations.WeekWithTuesdayWithMeals
import com.example.mealplanner.databinding.SectionRowBinding

class MainWeekWithTuesdayWithMealsAdapter : ListAdapter<WeekWithTuesdayWithMeals, MainWeekWithTuesdayWithMealsAdapter.TuesdayWeekViewHolder>(TuesdayWeekComparator()) {

    inner class TuesdayWeekViewHolder(private val binding: SectionRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(s: WeekWithTuesdayWithMeals){
            val weekName = "week "+ s.week.weekId
            binding.textViewSectionName.text = weekName
            binding.childRecyclerView.adapter = ChildWeekWithTuesdayWithMealsAdapter(s.tuesday)
        }
    }
    override fun onBindViewHolder(holder: TuesdayWeekViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TuesdayWeekViewHolder {
        return TuesdayWeekViewHolder(SectionRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    class TuesdayWeekComparator : DiffUtil.ItemCallback<WeekWithTuesdayWithMeals>() {
        override fun areItemsTheSame(
            oldItem: WeekWithTuesdayWithMeals,
            newItem: WeekWithTuesdayWithMeals
        ) = oldItem.week.weekId == newItem.week.weekId
        override fun areContentsTheSame(
            oldItem: WeekWithTuesdayWithMeals,
            newItem: WeekWithTuesdayWithMeals
        ) = oldItem == newItem
    }




}