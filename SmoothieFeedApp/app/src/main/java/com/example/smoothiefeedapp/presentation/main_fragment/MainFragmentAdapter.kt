package com.example.smoothiefeedapp.presentation.main_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.smoothiefeedapp.databinding.ItemAuthorizationBinding
import com.example.smoothiefeedapp.databinding.ItemWallBinding

class MainFragmentAdapter: ListAdapter<MainFragmentItem, MainFragmentViewHolder>(MainFragmentDiffUtilItemCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainFragmentViewHolder =
        MainFragmentViewHolder(ItemWallBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: MainFragmentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}