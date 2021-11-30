package com.example.smoothiefeedapp.presentation.fragments.main_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.smoothiefeedapp.databinding.ItemNewsBinding
import com.example.smoothiefeedapp.presentation.items.NewsItem

class MainFragmentAdapter : ListAdapter<NewsItem, MainFragmentViewHolder>(
    MainFragmentDiffUtilItemCallBack()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainFragmentViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        binding.root.layoutParams = RecyclerView.LayoutParams(
//            parent.width,
//            parent.height * 3 / 4
////        RecyclerView.LayoutParams.WRAP_CONTENT
//        ).apply {
//            bottomMargin = 16
//        }
        return MainFragmentViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MainFragmentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}