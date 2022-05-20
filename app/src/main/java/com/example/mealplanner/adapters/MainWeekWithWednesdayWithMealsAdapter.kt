package com.example.mealplanner.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.data.models.relations.WeekWithWednesdayWithMeals
import com.example.mealplanner.databinding.SectionRowBinding

class MainWeekWithWednesdayWithMealsAdapter : ListAdapter<WeekWithWednesdayWithMeals,MainWeekWithWednesdayWithMealsAdapter.WednesdayViewHolder>(WednesdayWeekComparator()) {
    inner class WednesdayViewHolder(private val binding: SectionRowBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(s: WeekWithWednesdayWithMeals){
            binding.textViewSectionName.visibility= View.GONE
            val weekName = "week "+ s.week.weekId
            binding.textViewSectionName.text = weekName
            binding.textViewWeekDay.text = "Wednesday"
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
        val currentItem = getItem(position)
        holder.bind(currentItem)
        holder.bindBreakfast(currentItem.wednesday[position].meals[0])
        holder.bindLunch(currentItem.wednesday[position].meals[1])
        holder.bindDinner(currentItem.wednesday[position].meals[2])
    }
}