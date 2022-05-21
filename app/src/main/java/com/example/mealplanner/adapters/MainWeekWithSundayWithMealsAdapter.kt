package com.example.mealplanner.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.data.models.relations.WeekWithSundayWithMeals
import com.example.mealplanner.databinding.SectionRowBinding

class MainWeekWithSundayWithMealsAdapter : ListAdapter<WeekWithSundayWithMeals, MainWeekWithSundayWithMealsAdapter.SundayWeekViewHolder>(SundayWeekComparator()) {

    inner class SundayWeekViewHolder(private val binding: SectionRowBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(s: WeekWithSundayWithMeals){
            binding.textViewSectionName.visibility= View.GONE
            val weekName = "week "+ s.week.weekId
            binding.textViewSectionName.text = weekName
            //binding.childRecyclerView.adapter = ChildWeekWithSundayWithMealsAdapter(s.sunday)
            binding.textViewWeekDay.text = "Sunday"
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
    override fun onBindViewHolder(holder: SundayWeekViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
        holder.bindBreakfast(currentItem.sunday[position].meals[0])
        holder.bindLunch(currentItem.sunday[position].meals[1])
        holder.bindDinner(currentItem.sunday[position].meals[2])
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