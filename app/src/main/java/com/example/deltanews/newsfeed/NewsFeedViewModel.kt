package com.example.deltanews.newsfeed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deltanews.NewsFeedItem

class NewsFeedViewModel : ViewModel() {
    val repository = NewsFeedRepository()
    private val _newsFeedLiveData = MutableLiveData<List<NewsFeedItem>>()
    val newsfeedliveData : LiveData<List<NewsFeedItem>> = _newsFeedLiveData
    fun fetchNewFeed(){
        repository.fetchNewsFeed(_newsFeedLiveData)
    }
}
