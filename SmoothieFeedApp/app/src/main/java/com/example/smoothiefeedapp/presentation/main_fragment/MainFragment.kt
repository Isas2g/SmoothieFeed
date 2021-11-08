package com.example.smoothiefeedapp.presentation.main_fragment

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
import com.example.smoothiefeedapp.databinding.FragmentMainBinding
import com.example.smoothiefeedapp.view_models.MainFragmentViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainFragment: Fragment(R.layout.fragment_main) {
    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    private val viewModel: MainFragmentViewModel by viewModels()
    private val mainAdapter = MainFragmentAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.mainFragBvManageAccounts.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToUserAccountsFragment())
        }
        initRV()
        bindViewModel()
    }

    private fun bindViewModel(){
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                launch {
                    viewModel.mainFragmentItemsObserver.collect { listUsersAccounts ->
                        if(!listUsersAccounts.isNullOrEmpty()){
                            mainAdapter.submitList(listUsersAccounts)
                        }
                    }
                }
            }

        }
    }

    private fun initRV(){
        with(binding.mainFragRvPosts){
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        }
    }
}