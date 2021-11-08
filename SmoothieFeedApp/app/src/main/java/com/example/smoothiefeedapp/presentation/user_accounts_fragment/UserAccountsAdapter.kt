package com.example.smoothiefeedapp.presentation.user_accounts_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.smoothiefeedapp.databinding.ItemAuthorizationBinding

class UserAccountsAdapter: ListAdapter<UserAccountsItem, UserAccountsViewHolder>(UserAccountsDiffUtilItemCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAccountsViewHolder =
        UserAccountsViewHolder(ItemAuthorizationBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: UserAccountsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}