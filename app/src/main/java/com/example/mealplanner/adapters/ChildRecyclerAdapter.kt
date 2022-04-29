package com.example.mealplanner.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.databinding.SectionItemBinding

class ChildRecyclerAdapter(private val list: List<Meal>) : RecyclerView.Adapter<ChildRecyclerAdapter.ChildViewHolder>() {
    inner class ChildViewHolder(private val binding: SectionItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(s: Meal){
            binding.textViewItemSection.text = s.name
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChildRecyclerAdapter.ChildViewHolder {
        val binding = SectionItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ChildViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChildRecyclerAdapter.ChildViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}