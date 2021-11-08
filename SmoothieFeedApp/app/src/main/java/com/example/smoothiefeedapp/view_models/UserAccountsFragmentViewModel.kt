package com.example.smoothiefeedapp.view_models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smoothiefeedapp.MainApplication
import com.example.smoothiefeedapp.data.key_value.DatastoreRepository
import com.example.smoothiefeedapp.data.locale.UserRepository
import com.example.smoothiefeedapp.data.network.VKNetworkingRepository
import com.example.smoothiefeedapp.presentation.user_accounts_fragment.UserAccountsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UserAccountsFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var vkNetworkingRepository: VKNetworkingRepository
    private val datastoreRepository = getApplication<MainApplication>().datastoreRepository
    private val userRepository = UserRepository()

    private val authItemsMutStateFlow = MutableStateFlow<List<UserAccountsItem>?>(null)

    val authItemsObserver: Flow<List<UserAccountsItem>?>
        get() = authItemsMutStateFlow

    init {
        viewModelScope.launch(Dispatchers.IO) {
            datastoreRepository.observeVKTokenChanges()
                .collect { vkToken ->
                    if (!vkToken.isNullOrEmpty()) {
                        vkNetworkingRepository = VKNetworkingRepository(vkToken)
                        vkNetworkingRepository.getCurrentUser().collect { currentUser ->
                            authItemsMutStateFlow.emit(listOf(UserAccountsItem(
                                firstName = currentUser.firstName,
                                lastName = currentUser.lastName
                            )))
                        }
                    }
                }
        }
    }

    private fun getListAuthorizationItems() {
        viewModelScope.launch(Dispatchers.IO) {
            authItemsMutStateFlow.emit(
                listOf(
//                AuthorizationItem(),
//                AuthorizationItem(),
//                AuthorizationItem()
                )
            )
        }
    }
}