package com.example.mealplanner.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.data.models.relations.WeekWithThursdayWithMeals
import com.example.mealplanner.databinding.SectionRowBinding

class MainWeekWithThursdayWithMealsAdapter : ListAdapter<WeekWithThursdayWithMeals,MainWeekWithThursdayWithMealsAdapter.ThursdayWeekViewHolder>(ThursdayWeekComparator()) {

    inner class ThursdayWeekViewHolder(private val binding: SectionRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(s: WeekWithThursdayWithMeals){
            binding.textViewSectionName.visibility= View.GONE
            val weekName = "week "+ s.week.weekId
            binding.textViewSectionName.text = weekName
            //binding.childRecyclerView.adapter = ChildWeekWithThursdayWithMealsAdapter(s.thursday)
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
        val currentItem = getItem(position)
        holder.bind(currentItem)
        holder.bindBreakfast(currentItem.thursday[position].meals[0])
        holder.bindLunch(currentItem.thursday[position].meals[1])
        holder.bindDinner(currentItem.thursday[position].meals[2])
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