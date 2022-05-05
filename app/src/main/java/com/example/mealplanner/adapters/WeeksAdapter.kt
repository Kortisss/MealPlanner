package com.example.mealplanner.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanner.data.models.Week
import com.example.mealplanner.databinding.WeeksItemBinding

class WeeksAdapter(private val list : List<Week>, private val onClickListener: OnClickListener): RecyclerView.Adapter<WeeksAdapter.WeeksHolder>() {

    inner class WeeksHolder(private val binding: WeeksItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(s: Week){
            val weekName = "week" + s.weekId
            binding.textView.text = weekName
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeeksHolder {
        val binding = WeeksItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return WeeksHolder(binding)
    }
    override fun onBindViewHolder(holder: WeeksHolder, position: Int) {
        holder.itemView.setOnClickListener{onClickListener.onClick(list[position])}
        holder.bind(list[position])
    }
    override fun getItemCount() = list.size

    class OnClickListener(val clickListener: (item: Week) -> Unit) {
        fun onClick(item: Week) = clickListener(item)
    }
}
