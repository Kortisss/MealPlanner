package com.example.mealplanner.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.relations.WeekWithSaturdayWithMeals
import com.example.mealplanner.databinding.SectionRowBinding

class MainWeekWithSaturdayWithMealsAdapter : ListAdapter<WeekWithSaturdayWithMeals, MainWeekWithSaturdayWithMealsAdapter.SaturdayWeekViewHolder>(SaturdayWeekComparator()) {

    inner class SaturdayWeekViewHolder(private val binding: SectionRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(s: WeekWithSaturdayWithMeals){
            binding.textViewSectionName.visibility= View.GONE
            val weekName = "week "+ s.week.weekId
            binding.textViewSectionName.text = weekName
            binding.childRecyclerView.adapter = ChildWeekWithSaturdayWithMealsAdapter(s.saturday)
        }
    }
    override fun onBindViewHolder(holder: SaturdayWeekViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SaturdayWeekViewHolder {
        return SaturdayWeekViewHolder(SectionRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    class SaturdayWeekComparator : DiffUtil.ItemCallback<WeekWithSaturdayWithMeals>() {
        override fun areItemsTheSame(
            oldItem: WeekWithSaturdayWithMeals,
            newItem: WeekWithSaturdayWithMeals
        ) = oldItem.week.weekId == newItem.week.weekId
        override fun areContentsTheSame(
            oldItem: WeekWithSaturdayWithMeals,
            newItem: WeekWithSaturdayWithMeals
        ) = oldItem == newItem
    }
}