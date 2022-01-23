package com.example.kotlin1hw3recycler.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin1hw3recycler.databinding.ActivityMainBinding
import com.example.kotlin1hw3recycler.ui.adapters.RamAdapter

class MainActivity : AppCompatActivity(), RamAdapter.OnClick {
    private lateinit var adapter: RamAdapter
    private lateinit var binding: ActivityMainBinding
    private val img = mutableListOf<String>()
    private val list = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        shareData()
    }

    private fun shareData() {
        binding.btnSend.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(KEY_SEND, list)
            startActivity(intent)
        }
    }

    private fun init() {
        adapter = RamAdapter(fillList())
        adapter.onClickListener(this)
        binding.recyclerView.adapter = adapter
    }

    private fun fillList(): MutableList<String> {
        (0..4).forEach { _ ->
            img.add("https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/Mercedes-Logo.svg/1200px-Mercedes-Logo.svg.png")
            img.add("https://автолого.рф/wp-content/uploads/bmw-logo-2020-grey.png")
        }
        return img
    }

    override fun onClicked(position: String) {
        list.add(position)
    }

    override fun onRemove(position: String) {
        list.remove(position)
    }

    companion object {
        const val KEY_SEND = "key"
    }
}
