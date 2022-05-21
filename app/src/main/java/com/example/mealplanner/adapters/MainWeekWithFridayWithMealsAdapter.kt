package com.example.mealplanner.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.R
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.data.models.relations.WeekWithFridayWithMeals
import com.example.mealplanner.databinding.SectionRowBinding

class MainWeekWithFridayWithMealsAdapter : ListAdapter<WeekWithFridayWithMeals, MainWeekWithFridayWithMealsAdapter.FridayWeekViewHolder>(FridayWeekComparator()) {

    inner class FridayWeekViewHolder(private val binding: SectionRowBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(s: WeekWithFridayWithMeals){
            binding.textViewSectionName.visibility= View.GONE
            val weekName = "week "+ s.week.weekId
            binding.textViewSectionName.text = weekName
            binding.textViewWeekDay.text = "Friday"
            binding.btnDeleteWeek.visibility = View.GONE
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
    override fun onBindViewHolder(holder: FridayWeekViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
        holder.bindBreakfast(currentItem.friday[position].meals[0])
        holder.bindLunch(currentItem.friday[position].meals[1])
        holder.bindDinner(currentItem.friday[position].meals[2])
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