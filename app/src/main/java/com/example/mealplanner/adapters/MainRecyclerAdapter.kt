package com.example.mealplanner.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.SectionWithMeals
import com.example.mealplanner.databinding.SectionRowBinding

class MainRecyclerAdapter : ListAdapter<SectionWithMeals,MainRecyclerAdapter.MainViewHolder>(SectionComparator()) {
    inner class MainViewHolder(private val binding: SectionRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(s: SectionWithMeals){
            binding.textViewSectionName.text = s.section.sectionName
            binding.childRecyclerView.adapter = ChildRecyclerAdapter(s.sections)
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainRecyclerAdapter.MainViewHolder {
        val binding = SectionRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainRecyclerAdapter.MainViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    class SectionComparator : DiffUtil.ItemCallback<SectionWithMeals>() {
        override fun areItemsTheSame(oldItem: SectionWithMeals, newItem: SectionWithMeals) =
            oldItem.section.sectionId == newItem.section.sectionId
        override fun areContentsTheSame(oldItem: SectionWithMeals, newItem: SectionWithMeals) =
            oldItem == newItem
    }
}