package com.example.mealplanner.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.relations.WeekWithThursdayWithMeals
import com.example.mealplanner.databinding.SectionRowBinding

class MainWeekWithThursdayWithMealsAdapter : ListAdapter<WeekWithThursdayWithMeals,MainWeekWithThursdayWithMealsAdapter.ThursdayWeekViewHolder>(ThursdayWeekComparator()) {

    inner class ThursdayWeekViewHolder(private val binding: SectionRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(s: WeekWithThursdayWithMeals){
            binding.textViewSectionName.visibility= View.GONE
            val weekName = "week "+ s.week.weekId
            binding.textViewSectionName.text = weekName
            binding.childRecyclerView.adapter = ChildWeekWithThursdayWithMealsAdapter(s.thursday)
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainWeekWithThursdayWithMealsAdapter.ThursdayWeekViewHolder {
        return ThursdayWeekViewHolder(SectionRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(
        holder: MainWeekWithThursdayWithMealsAdapter.ThursdayWeekViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }
    class ThursdayWeekComparator : DiffUtil.ItemCallback<WeekWithThursdayWithMeals>() {
        override fun areItemsTheSame(
            oldItem: WeekWithThursdayWithMeals,
            newItem: WeekWithThursdayWithMeals
        ) = oldItem.week.weekId == newItem.week.weekId
        override fun areContentsTheSame(
            oldItem: WeekWithThursdayWithMeals,
            newItem: WeekWithThursdayWithMeals
        ) = oldItem == newItem
    }
}