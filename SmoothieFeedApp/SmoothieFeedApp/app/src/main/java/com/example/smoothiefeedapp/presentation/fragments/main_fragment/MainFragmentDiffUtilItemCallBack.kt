package com.example.smoothiefeedapp.presentation.fragments.main_fragment

import androidx.recyclerview.widget.DiffUtil
import com.example.smoothiefeedapp.presentation.items.NewsItem

class MainFragmentDiffUtilItemCallBack: DiffUtil.ItemCallback<NewsItem>() {
    override fun areItemsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: NewsItem,
        newItem: NewsItem
    ): Boolean {
        return oldItem.news.id == newItem.news.id
    }
}