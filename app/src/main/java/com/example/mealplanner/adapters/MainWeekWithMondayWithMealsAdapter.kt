package com.example.mealplanner.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.R
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.data.models.relations.MondayWithMeals
import com.example.mealplanner.data.models.relations.WeekWithMondayWithMeals
import com.example.mealplanner.databinding.SectionRowBinding
import com.example.mealplanner.ui.home.AddMealDialogFragment
import com.example.mealplanner.ui.home.HomeFragment
import com.example.mealplanner.ui.home.HomeViewModel

class MainWeekWithMondayWithMealsAdapter(private val onClickListener: OnClickListener, private val viewModel: HomeViewModel) : ListAdapter<WeekWithMondayWithMeals,MainWeekWithMondayWithMealsAdapter.WeekViewHolder>(MondayWeekComparator()) {
    inner class WeekViewHolder(private val binding: SectionRowBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(s: WeekWithMondayWithMeals){
            val weekName = "week "+ s.week.weekId
            binding.textViewSectionName.textAlignment= View.TEXT_ALIGNMENT_CENTER
            binding.textViewSectionName.text = weekName
            binding.textViewWeekDay.text = "Monday"
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

//        val btnAddMeal = binding.btnAddMeal
          val btnDeleteWeek = binding.btnDeleteWeek
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainWeekWithMondayWithMealsAdapter.WeekViewHolder {
        return WeekViewHolder(SectionRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(
        holder: MainWeekWithMondayWithMealsAdapter.WeekViewHolder,
        position: Int
    ) {
        val currentItem = getItem(position)
//        holder.btnAddMeal.setOnClickListener{onClickListener.onClick(currentItem)}
        holder.btnDeleteWeek.setOnClickListener{
            viewModel.deleteWholeWeek(currentItem.week.weekId)

        }
        holder.bind(currentItem)

        holder.bindBreakfast(currentItem.monday[position].meals[0])
        holder.bindLunch(currentItem.monday[position].meals[1])
        holder.bindDinner(currentItem.monday[position].meals[2])
    }
    class MondayWeekComparator : DiffUtil.ItemCallback<WeekWithMondayWithMeals>() {
        override fun areItemsTheSame(
            oldItem: WeekWithMondayWithMeals,
            newItem: WeekWithMondayWithMeals
        ) = oldItem.week.weekId == newItem.week.weekId
        override fun areContentsTheSame(
            oldItem: WeekWithMondayWithMeals,
            newItem: WeekWithMondayWithMeals
        ) = oldItem == newItem
    }
    class OnClickListener(val clickListener: (result: WeekWithMondayWithMeals) -> Unit) {
        fun onClick(result: WeekWithMondayWithMeals) = clickListener(result)
    }
}