package com.example.kotlin1hw3recycler.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin1hw3recycler.R
import com.example.kotlin1hw3recycler.databinding.ItemRamBinding
import com.example.kotlin1hw3recycler.extension.load

class RamAdapter(private val list: MutableList<String>) : RecyclerView.Adapter<RamAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ram, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRamBinding.bind(itemView)
        fun onBind(raw: String) = with(binding) {
            ivRam.load(raw)
        }
    }
}