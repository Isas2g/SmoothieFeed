package com.example.smoothiefeedapp.presentation.main_fragment

import androidx.recyclerview.widget.DiffUtil

class MainFragmentDiffUtilItemCallBack: DiffUtil.ItemCallback<MainFragmentItem>() {
    override fun areItemsTheSame(oldItem: MainFragmentItem, newItem: MainFragmentItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: MainFragmentItem,
        newItem: MainFragmentItem
    ): Boolean {
        return oldItem.id == newItem.id
    }
}