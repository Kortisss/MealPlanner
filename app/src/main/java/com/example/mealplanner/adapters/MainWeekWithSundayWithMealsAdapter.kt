package com.example.mealplanner.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.relations.WeekWithSundayWithMeals
import com.example.mealplanner.databinding.SectionRowBinding

class MainWeekWithSundayWithMealsAdapter : ListAdapter<WeekWithSundayWithMeals, MainWeekWithSundayWithMealsAdapter.SundayWeekViewHolder>(SundayWeekComparator()) {

    inner class SundayWeekViewHolder(private val binding: SectionRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(s: WeekWithSundayWithMeals){
            binding.textViewSectionName.visibility= View.GONE
            val weekName = "week "+ s.week.weekId
            binding.textViewSectionName.text = weekName
            binding.childRecyclerView.adapter = ChildWeekWithSundayWithMealsAdapter(s.sunday)
        }
    }
    override fun onBindViewHolder(holder: SundayWeekViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SundayWeekViewHolder {
        return SundayWeekViewHolder(SectionRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    class SundayWeekComparator : DiffUtil.ItemCallback<WeekWithSundayWithMeals>() {
        override fun areItemsTheSame(
            oldItem: WeekWithSundayWithMeals,
            newItem: WeekWithSundayWithMeals
        ) = oldItem.week.weekId == newItem.week.weekId
        override fun areContentsTheSame(
            oldItem: WeekWithSundayWithMeals,
            newItem: WeekWithSundayWithMeals
        ) = oldItem == newItem
    }
}