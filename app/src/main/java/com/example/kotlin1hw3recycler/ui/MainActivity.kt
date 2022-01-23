package com.example.kotlin1hw3recycler.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin1hw3recycler.R
import com.example.kotlin1hw3recycler.databinding.ActivityMainBinding
import com.example.kotlin1hw3recycler.extension.showToast

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RamAdapter
    private lateinit var binding: ActivityMainBinding
    private val img = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

    }

    private fun init() {
        binding.apply {
            adapter = RamAdapter(fillList())
            recyclerView.adapter = adapter
                adapter.setOnItemClickListener(object : RamAdapter.onItemClickListener {
                    override fun onClick(position: Int) {
                       showToast(getString(R.string.added))
                    }
                })
        }
    }

    private fun fillList(): MutableList<String> {
        (0..4).forEach { _ ->
            img.add("https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/Mercedes-Logo.svg/1200px-Mercedes-Logo.svg.png")
            img.add("https://автолого.рф/wp-content/uploads/bmw-logo-2020-grey.png")

        }
        return img
    }
}
