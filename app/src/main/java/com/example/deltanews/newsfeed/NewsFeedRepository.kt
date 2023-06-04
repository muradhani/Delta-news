package com.example.deltanews.newsfeed

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.deltanews.NewsFeedItem
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class NewsFeedRepository {
    val database = FirebaseDatabase.getInstance()
    val myref = database.getReference("news_feed").orderByChild("_rank")
    fun fetchNewsFeed(liveData: MutableLiveData<List<NewsFeedItem>>) {
        myref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                //Log.i("SNAPSHOT",snapshot.value.toString())
                val newsFeedItems:List<NewsFeedItem> = snapshot.children.map {
                        dataSnapshot ->
                    dataSnapshot.getValue(NewsFeedItem::class.java)!!
                }
                liveData.postValue(newsFeedItems)
                Log.i("ITEMS",newsFeedItems.toString())

            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }




}