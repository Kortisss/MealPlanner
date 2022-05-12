package com.example.mealplanner.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.relations.WeekWithFridayWithMeals
import com.example.mealplanner.databinding.SectionRowBinding

class MainWeekWithFridayWithMealsAdapter : ListAdapter<WeekWithFridayWithMeals, MainWeekWithFridayWithMealsAdapter.FridayWeekViewHolder>(FridayWeekComparator()) {

    inner class FridayWeekViewHolder(private val binding: SectionRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(s: WeekWithFridayWithMeals){
            binding.textViewSectionName.visibility= View.GONE
            val weekName = "week "+ s.week.weekId
            binding.textViewSectionName.text = weekName
            binding.childRecyclerView.adapter = ChildWeekWithFridayWithMealsAdapter(s.friday)
        }
    }
    override fun onBindViewHolder(holder: FridayWeekViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FridayWeekViewHolder {
        return FridayWeekViewHolder(SectionRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    class FridayWeekComparator : DiffUtil.ItemCallback<WeekWithFridayWithMeals>() {
        override fun areItemsTheSame(
            oldItem: WeekWithFridayWithMeals,
            newItem: WeekWithFridayWithMeals
        ) = oldItem.week.weekId == newItem.week.weekId
        override fun areContentsTheSame(
            oldItem: WeekWithFridayWithMeals,
            newItem: WeekWithFridayWithMeals
        ) = oldItem == newItem
    }
}