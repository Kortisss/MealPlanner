package com.example.mealplanner.adapters
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.adapters.MealListAdapter.*
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.databinding.MealItemBinding

class MealListAdapter: ListAdapter<Meal, MealViewHolder>(MealComparator()) {
    inner class MealViewHolder(private val binding: MealItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(meal:Meal){
            binding.textViewMealId.text = meal.mealId.toString()
            binding.textViewMealName.text = meal.name
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        return MealViewHolder(MealItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,false))
    }
    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    class MealComparator:DiffUtil.ItemCallback<Meal>() {
        override fun areItemsTheSame(oldItem: Meal, newItem: Meal) =
            oldItem.mealId == newItem.mealId
        override fun areContentsTheSame(oldItem: Meal, newItem: Meal) =
            oldItem.name == newItem.name
    }
}