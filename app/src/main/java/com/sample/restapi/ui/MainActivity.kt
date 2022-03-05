package com.sample.restapi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.restapi.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var myAdapter: TvShowAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showList()
        showData()
    }

    private fun showData() {
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.tvShow.observe(this) {
            myAdapter.tvShows = it
        }
    }

    private fun showList() {
        myAdapter = TvShowAdapter()
        binding.mainList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = myAdapter
        }
    }
}