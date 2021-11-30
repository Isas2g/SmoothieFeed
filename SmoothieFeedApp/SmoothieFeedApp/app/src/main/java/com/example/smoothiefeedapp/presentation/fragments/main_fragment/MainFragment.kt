package com.example.smoothiefeedapp.presentation.fragments.main_fragment

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.smoothiefeedapp.R
import com.example.smoothiefeedapp.databinding.FragmentMainBinding
import com.example.smoothiefeedapp.presentation.utils.PaginationScrollListener
import com.example.smoothiefeedapp.presentation.view_models.MainFragmentViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    private val viewModel: MainFragmentViewModel by viewModel()
    private val mainAdapter = MainFragmentAdapter()

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            viewModel.cleanAllChosenDetoxes()
            requireActivity().finish()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        requireActivity().onBackPressedDispatcher.addCallback(onBackPressedCallback)
        binding.mainFragBvManageAccounts.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToUserAccountsFragment())
        }
        initRV()
        bindViewModel()
    }

    private fun bindViewModel() {
        with(viewModel) {
            viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
                viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    launch {
                        newsItemsObserver.collect { listUsersAccounts ->
                            if (!listUsersAccounts.isNullOrEmpty()) {
                                binding.mainFragTvDontAuthorizeMessage.visibility = View.GONE
                                mainAdapter.submitList(listUsersAccounts)
                            } else {
                                binding.mainFragTvDontAuthorizeMessage.visibility = View.VISIBLE
                            }
                        }
                    }
                    launch {
                        getPostsDetoxUseCase().collect { postsDetox ->
                            if (postsDetox == null) {
                                getTimeDetoxUseCase().collect { timeDetox ->
                                    if (timeDetox == null) {
                                        findNavController().navigate(MainFragmentDirections.actionMainFragmentToChooseDetoxDialogue())
                                    }
                                }
                            }
                        }
                    }
                    launch {
                        remainingPostsObserver.collect { remainingPosts ->
                            if (remainingPosts != null) {
                                with(binding) {
                                    mainFragTvDetoxTitle.text = "Remaining posts:"
                                    mainFragTvCounter.text = remainingPosts.toString()
                                }
                            }
                        }
                    }
                    launch {
                        remainingTimeObserver
                            .collect { remainingTime ->
                                if (remainingTime != null) {
                                    val date = Date(remainingTime)
                                    val formatter = SimpleDateFormat("HH:mm:ss")
                                    formatter.timeZone = TimeZone.getTimeZone("UTC")
                                    with(binding) {
                                        mainFragTvDetoxTitle.text = "Remaining time:"
                                        mainFragTvCounter.text = formatter.format(date)
                                    }
                                }

                            }
                    }
                }

            }
        }
    }

    private fun initRV() {
        with(binding.mainFragRvPosts) {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            addOnScrollListener(PaginationScrollListener(
                layoutManager = layoutManager as LinearLayoutManager,
                newsIsLoad = viewModel.loadIsDoneObserver,
                getNewItems = { viewModel.getNextItems() },
                countOfWatchedItems = { countOfWatchedItems ->
                    viewModel.countPosts(countOfWatchedItems)
                }
            ))
        }
    }

    override fun onDestroyView() {
        onBackPressedCallback.remove()
        super.onDestroyView()
    }
}