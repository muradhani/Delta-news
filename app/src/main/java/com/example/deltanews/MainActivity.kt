package com.example.deltanews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.deltanews.databinding.ActivityMainBinding
import com.example.deltanews.newsfeed.NewsFeedRecyclerViewAdapter
import com.example.deltanews.newsfeed.NewsFeedViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.textOnScreen = "hellommm"
//        binding.tv.postDelayed({
//            binding.textOnScreen = "hello again!"
//        },2_000)
        val viewModel : NewsFeedViewModel = ViewModelProvider(this)[NewsFeedViewModel::class.java]
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        val newsFeedAdapter = NewsFeedRecyclerViewAdapter()
        binding.recycleView.adapter=newsFeedAdapter
        viewModel.fetchNewFeed()

        viewModel.newsfeedliveData.observe(this){newsFeedItems->
            newsFeedAdapter.setItems(newsFeedItems)
        }
    }
}