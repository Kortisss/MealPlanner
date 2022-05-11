package com.example.mealplanner.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.relations.WeekWithWednesdayWithMeals
import com.example.mealplanner.databinding.SectionRowBinding

class MainWeekWithWednesdayWithMealsAdapter : ListAdapter<WeekWithWednesdayWithMeals,MainWeekWithWednesdayWithMealsAdapter.WednesdayViewHolder>(WednesdayWeekComparator()) {
    inner class WednesdayViewHolder(private val binding: SectionRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(s: WeekWithWednesdayWithMeals){
            binding.textViewSectionName.visibility= View.GONE
            val weekName = "week "+ s.week.weekId
            binding.textViewSectionName.text = weekName
            binding.childRecyclerView.adapter = ChildWeekWithWednesdayWithMealsAdapter(s.wednesday)
        }
    }

    class WednesdayWeekComparator : DiffUtil.ItemCallback<WeekWithWednesdayWithMeals>() {
        override fun areItemsTheSame(
            oldItem: WeekWithWednesdayWithMeals,
            newItem: WeekWithWednesdayWithMeals
        ) = oldItem.week.weekId == newItem.week.weekId

        override fun areContentsTheSame(
            oldItem: WeekWithWednesdayWithMeals,
            newItem: WeekWithWednesdayWithMeals
        ) = oldItem == newItem

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainWeekWithWednesdayWithMealsAdapter.WednesdayViewHolder {
        return WednesdayViewHolder(SectionRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(
        holder: MainWeekWithWednesdayWithMealsAdapter.WednesdayViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }
}