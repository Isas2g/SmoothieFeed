package com.example.smoothiefeedapp.presentation.fragments.user_accounts_fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.smoothiefeedapp.R
import com.example.smoothiefeedapp.databinding.FragmentUserAccountsBinding
import com.example.smoothiefeedapp.presentation.view_models.UserAccountsFragmentViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class UserAccountsFragment: Fragment(R.layout.fragment_user_accounts) {
    private val binding: FragmentUserAccountsBinding by viewBinding(FragmentUserAccountsBinding::bind)
    private val viewModel: UserAccountsFragmentViewModel  by viewModel()
    private val authorizationAdapter = UserAccountsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRV()
        binding.authFragFbAddAccount.setOnClickListener {
            findNavController().navigate(UserAccountsFragmentDirections.actionUserAccountsFragmentToAuthorizationFragment())
        }
        bindViewModel()
    }

    private fun bindViewModel(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                launch {
                    viewModel.authItemsObserver.collect { listUsersAccounts ->
                        if(!listUsersAccounts.isNullOrEmpty()){
                            authorizationAdapter.submitList(listUsersAccounts)
                        }
                    }
                }
            }

        }
    }

    private fun initRV(){
        with(binding.authFragRv){
            adapter = authorizationAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        }
    }
}