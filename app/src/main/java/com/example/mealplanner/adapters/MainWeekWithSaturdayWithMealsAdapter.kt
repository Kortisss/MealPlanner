package com.example.mealplanner.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.data.models.relations.WeekWithSaturdayWithMeals
import com.example.mealplanner.databinding.SectionRowBinding

class MainWeekWithSaturdayWithMealsAdapter : ListAdapter<WeekWithSaturdayWithMeals, MainWeekWithSaturdayWithMealsAdapter.SaturdayWeekViewHolder>(SaturdayWeekComparator()) {

    inner class SaturdayWeekViewHolder(private val binding: SectionRowBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(s: WeekWithSaturdayWithMeals){
            binding.textViewSectionName.visibility= View.GONE
            val weekName = "week "+ s.week.weekId
            binding.textViewSectionName.text = weekName
            //binding.childRecyclerView.adapter = ChildWeekWithSaturdayWithMealsAdapter(s.saturday)
            binding.textViewWeekDay.text = "Saturday"
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
    override fun onBindViewHolder(holder: SaturdayWeekViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
        holder.bindBreakfast(currentItem.saturday[position].meals[0])
        holder.bindLunch(currentItem.saturday[position].meals[1])
        holder.bindDinner(currentItem.saturday[position].meals[2])
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