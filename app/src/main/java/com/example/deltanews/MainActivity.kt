package com.example.deltanews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.deltanews.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

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
        val viewModel :NewsFeedViewModel = ViewModelProvider(this)[NewsFeedViewModel::class.java]
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
    }
}