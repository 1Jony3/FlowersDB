package com.example.flowersdb.model.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flowersdb.databinding.ItemFlowersBinding
import com.example.flowersdb.model.database.FlowersInfoTuple

class FlowersAdapter: RecyclerView.Adapter<FlowersAdapter.FlowersHolder>() {

    var flowers: List<FlowersInfoTuple> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowersHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFlowersBinding.inflate(inflater, parent, false)

        return FlowersHolder(binding)    }

    override fun onBindViewHolder(holder: FlowersHolder, position: Int) {
        val flower = flowers[position]
        with(holder.binding){
            nameFlowers.text = flower.flowerName
            age.text = "${flower.flowerAge} month"
            family.text = flower.familyName
        }
    }

    override fun getItemCount() = flowers.size

    class FlowersHolder(val binding: ItemFlowersBinding): RecyclerView.ViewHolder(binding.root)
}