package com.example.deltanews.newsfeed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deltanews.NewsFeedItem
import com.example.deltanews.R
import com.example.deltanews.databinding.NewsHolderItemBinding

class NewsFeedRecyclerViewAdapter :RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private val newsFeedItems = mutableListOf<NewsFeedItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsFeedItemViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return newsFeedItems.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NewsFeedItemViewHolder).onBind(newsFeedItems[position])
    }
    fun setItems(newsFeedItems: List<NewsFeedItem>){
        this.newsFeedItems.clear()
        this.newsFeedItems.addAll(newsFeedItems)
        notifyDataSetChanged()
    }

    inner class NewsFeedItemViewHolder(parent: ViewGroup):RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.news_holder_item,parent,false)
    ){
        private val binding = NewsHolderItemBinding.bind(itemView)
        fun onBind(newsFeedItem: NewsFeedItem){
            binding.newsFeedTitle.text = newsFeedItem.title
            binding.newsFeedDescription.text = newsFeedItem.decription
        }
    }

}