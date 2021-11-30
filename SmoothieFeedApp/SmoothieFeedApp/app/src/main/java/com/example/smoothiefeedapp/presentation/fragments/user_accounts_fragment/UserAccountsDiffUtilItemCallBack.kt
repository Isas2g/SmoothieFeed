package com.example.smoothiefeedapp.presentation.fragments.user_accounts_fragment

import androidx.recyclerview.widget.DiffUtil
import com.example.smoothiefeedapp.presentation.items.UserAccountsItem

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