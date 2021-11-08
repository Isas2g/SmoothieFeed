package com.example.smoothiefeedapp.view_models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.smoothiefeedapp.MainApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class AuthorizationFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val dataStoreRepository = getApplication<MainApplication>().datastoreRepository

    val tokenChangesObserver: Flow<String?>
    get() = dataStoreRepository.observeVKTokenChanges()

    fun getVKUrl(): String {
        return "https://oauth.vk.com/authorize?client_id=7988410&display=mobile&redirect_uri=https://oauth.vk.com/blank.html&scope=friends+offline+wall&response_type=token&v=5.131"
    }

    fun saveVKToken(token: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            dataStoreRepository.saveVKToken(token)
        }
    }
}