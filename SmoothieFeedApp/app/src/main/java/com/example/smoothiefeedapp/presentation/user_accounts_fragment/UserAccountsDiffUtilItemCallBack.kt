package com.example.smoothiefeedapp.presentation.user_accounts_fragment

import androidx.recyclerview.widget.DiffUtil

class UserAccountsDiffUtilItemCallBack: DiffUtil.ItemCallback<UserAccountsItem>() {
    override fun areItemsTheSame(oldItem: UserAccountsItem, newItem: UserAccountsItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: UserAccountsItem,
        newItem: UserAccountsItem
    ): Boolean {
        return oldItem.firstName == newItem.firstName
    }
}