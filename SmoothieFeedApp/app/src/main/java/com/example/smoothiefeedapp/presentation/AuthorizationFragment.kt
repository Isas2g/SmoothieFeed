package com.example.smoothiefeedapp.presentation

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.smoothiefeedapp.R
import com.example.smoothiefeedapp.databinding.FragmentAuthorizationBinding
import com.example.smoothiefeedapp.view_models.AuthorizationFragmentViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.launch
import timber.log.Timber

class AuthorizationFragment: Fragment(R.layout.fragment_authorization) {
    private val binding: FragmentAuthorizationBinding by viewBinding(FragmentAuthorizationBinding::bind)
    private val viewModel: AuthorizationFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setWebView()
        bindViewModel()
    }

    private fun setWebView() {
        with(binding.authFragWebView) {
            loadUrl(viewModel.getVKUrl())
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                    if (url.startsWith("https://oauth.vk.com/blank"))
                        viewModel.saveVKToken(url)
                    return false
                }
            }
        }
    }

    private fun bindViewModel(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                launch {
                    viewModel.tokenChangesObserver
                        .drop(0)//for first demonstration auth change in process
                        .collect { token ->
                        if (token!=null){
                            requireActivity().onBackPressed()
                        }
                    }
                }
            }
        }
    }
}