package com.example.mealplanner.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.data.models.relations.WeekWithTuesdayWithMeals
import com.example.mealplanner.databinding.SectionRowBinding

class MainWeekWithTuesdayWithMealsAdapter : ListAdapter<WeekWithTuesdayWithMeals, MainWeekWithTuesdayWithMealsAdapter.TuesdayWeekViewHolder>(TuesdayWeekComparator()) {

    inner class TuesdayWeekViewHolder(private val binding: SectionRowBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(s: WeekWithTuesdayWithMeals){
            binding.textViewSectionName.visibility=View.GONE
            binding.textViewWeekDay.text = "Tuesday"
        }
        fun bindBreakfast(s: Meal){
            binding.textViewItemSection.text = s.name
        }
        fun bindLunch(s: Meal){
            binding.textViewItemSection2.text = s.name
        }
        fun bindDinner(s: Meal){
            binding.textViewItemSection3.text = s.name
        }

    }
    override fun onBindViewHolder(holder: TuesdayWeekViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
        holder.bindBreakfast(currentItem.tuesday[position].meals[0])
        holder.bindLunch(currentItem.tuesday[position].meals[1])
        holder.bindDinner(currentItem.tuesday[position].meals[2])
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