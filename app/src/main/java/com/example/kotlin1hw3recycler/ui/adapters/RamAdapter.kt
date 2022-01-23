package com.example.kotlin1hw3recycler.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin1hw3recycler.databinding.ItemRamBinding
import com.example.kotlin1hw3recycler.extension.load

class RamAdapter(private val list: MutableList<String>) :
    RecyclerView.Adapter<RamAdapter.ViewHolder>() {

    private lateinit var onClick: OnClick

    fun onClickListener(onClick: OnClick) {
        this.onClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemRamBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(private var binding: ItemRamBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(ram: String) = with(binding) {
            ivRam.load(ram)
            itemView.setOnClickListener {
                if (transparentView.visibility == View.GONE) {
                    transparentView.visibility = View.VISIBLE
                    onClick.onClicked(ram)
                } else{
                    binding.transparentView.visibility = View.GONE
                onClick.onRemove(ram)
            }
        }
    }
}

    interface OnClick {
        fun onClicked(position: String)
        fun onRemove(position: String)
    }
}


