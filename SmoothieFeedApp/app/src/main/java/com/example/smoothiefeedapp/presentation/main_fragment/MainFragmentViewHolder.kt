package com.example.smoothiefeedapp.presentation.main_fragment

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.smoothiefeedapp.R
import com.example.smoothiefeedapp.databinding.ItemAuthorizationBinding
import com.example.smoothiefeedapp.databinding.ItemWallBinding

class MainFragmentViewHolder(
    private val binding: ItemWallBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MainFragmentItem){
        Glide.with(binding.root)
            .load(item.photoUrl)
            .into(binding.itemWallPreviewIv)
    }
}