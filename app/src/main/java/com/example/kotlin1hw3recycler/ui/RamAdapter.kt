package com.example.kotlin1hw3recycler.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin1hw3recycler.R
import com.example.kotlin1hw3recycler.databinding.ItemRamBinding
import com.example.kotlin1hw3recycler.extension.load

class RamAdapter(private val list: MutableList<String>) :
    RecyclerView.Adapter<RamAdapter.ViewHolder>() {

    private lateinit var onClick: onItemClickListener

    interface onItemClickListener {
        fun onClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        onClick = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ram, parent, false)
        return ViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }


    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRamBinding.bind(itemView)

        init {
            itemView.setOnClickListener {
                listener.onClick(adapterPosition)
                if (binding.transparentView.visibility == View.GONE) {
                    binding.transparentView.visibility = View.VISIBLE
                }
            }

        }

        fun onBind(raw: String) = with(binding) {
            ivRam.load(raw)
        }
    }
}