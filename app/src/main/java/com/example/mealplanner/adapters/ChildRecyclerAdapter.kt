package com.example.mealplanner.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.Meal
import com.example.mealplanner.databinding.SectionItemBinding

class ChildRecyclerAdapter(private val list: List<Meal>) : RecyclerView.Adapter<ChildRecyclerAdapter.ChildViewHolder>() {

    inner class ChildViewHolder(private val binding: SectionItemBinding) : RecyclerView.ViewHolder(binding.root) {
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
    ): ChildRecyclerAdapter.ChildViewHolder {
        val binding = SectionItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ChildViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChildRecyclerAdapter.ChildViewHolder, position: Int) {
        holder.bindBreakfast(list[0])
        holder.bindLunch(list[1])
        holder.bindDinner(list[2])
    }

    override fun getItemCount() = list.size
}