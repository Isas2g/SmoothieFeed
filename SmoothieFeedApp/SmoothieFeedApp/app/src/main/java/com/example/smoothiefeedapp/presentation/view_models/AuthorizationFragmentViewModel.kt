package com.example.smoothiefeedapp.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smoothiefeedapp.domain.use_cases.GetVKUserUseCase
import com.example.smoothiefeedapp.domain.use_cases.ListenTokenChangesUseCase
import com.example.smoothiefeedapp.domain.use_cases.LoadVKUserUseCase
import com.example.smoothiefeedapp.domain.use_cases.SaveTokenUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AuthorizationFragmentViewModel(
    private val saveTokenUseCase: SaveTokenUseCase,
    private val listenTokenChangesUseCase: ListenTokenChangesUseCase,
    private val loadVKUserUseCase: LoadVKUserUseCase,
    val getVKUserUseCase: GetVKUserUseCase
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            listenTokenChangesUseCase("vk").collect { token ->
                if (token != null) {
                    loadVKUserUseCase()
                }
            }
        }

    }

    fun getVKUrl(): String {
        return "https://oauth.vk.com/authorize?client_id=8003222&display=mobile&redirect_uri=https://oauth.vk.com/blank.html&scope=friends+offline+wall&response_type=token&v=5.131"
    }

    fun saveVKToken(stringWithToken: String?, socialNetworkingName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            saveTokenUseCase(stringWithToken ?: "", socialNetworkingName)
        }
    }
}