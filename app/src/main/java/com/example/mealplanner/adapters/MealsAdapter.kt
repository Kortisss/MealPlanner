package com.example.mealplanner.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.databinding.MealListBinding

class MealsAdapter: ListAdapter<Meal, MealsAdapter.ImageViewHolder>(DiffCallback()) {
    class ImageViewHolder(private val binding: MealListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(s: Meal){
             binding.tvMealName.text = s.name
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = MealListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currentItem = getItem(position)

        holder.bind(currentItem)

    }

    class DiffCallback : DiffUtil.ItemCallback<Meal>() {
        override fun areItemsTheSame(oldItem: Meal, newItem: Meal) =
            oldItem.mealId == newItem.mealId
        override fun areContentsTheSame(oldItem: Meal, newItem: Meal) =
            oldItem == newItem
    }
}