package com.example.smoothiefeedapp.presentation.fragments.user_accounts_fragment

import androidx.recyclerview.widget.RecyclerView
import com.example.smoothiefeedapp.R
import com.example.smoothiefeedapp.databinding.ItemAuthorizationBinding
import com.example.smoothiefeedapp.presentation.items.UserAccountsItem

class UserAccountsViewHolder(
    private val binding: ItemAuthorizationBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: UserAccountsItem){
        binding.itemAuthTvFirstName.text = item.firstName
        binding.itemAuthTvLastName.text = item.lastName
        binding.itemAuthIvSnIcon.setImageResource(R.drawable.vk_icon)
    }
}