package com.example.kotlin1hw3recycler.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin1hw3recycler.databinding.ActivitySecondBinding
import com.example.kotlin1hw3recycler.ui.adapters.RamAdapter

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acceptData()
        backButton()
    }

    private fun backButton() {
        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun acceptData() {
        val list = intent.getStringArrayListExtra(MainActivity.KEY_SEND)
        binding.recyclerView2.adapter = list?.let { RamAdapter(it) }
    }
}