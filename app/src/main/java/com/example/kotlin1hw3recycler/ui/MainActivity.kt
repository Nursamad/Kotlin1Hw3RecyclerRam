package com.example.kotlin1hw3recycler.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin1hw3recycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var adapter:RamAdapter
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
        }
    }

    private fun fillList(): MutableList<String> {
        (0..20).forEach { _ -> img.add("https://www.meme-arsenal.com/memes/8a6bd2a9a562d83741b68f2c7caaaa40.jpg") }
        return img
    }
}
