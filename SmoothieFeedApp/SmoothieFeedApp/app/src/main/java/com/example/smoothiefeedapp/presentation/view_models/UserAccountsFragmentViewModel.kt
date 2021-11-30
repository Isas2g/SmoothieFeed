package com.example.smoothiefeedapp.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.example.smoothiefeedapp.data.repositories.api.VKNetworkingRepository
import com.example.smoothiefeedapp.presentation.items.UserAccountsItem
import com.example.smoothiefeedapp.domain.use_cases.GetVKUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UserAccountsFragmentViewModel(
    private val getVKUserUseCase: GetVKUserUseCase
) : ViewModel() {

    private val authItemsMutStateFlow = MutableStateFlow<List<UserAccountsItem>?>(null)

    val authItemsObserver: Flow<List<UserAccountsItem>?>
        get() = authItemsMutStateFlow

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getVKUserUseCase().collect { usersList ->
                authItemsMutStateFlow.emit(usersList.map { user ->
                    UserAccountsItem(
                        firstName = user.firstName,
                        lastName = user.lastName
                    )
                })
            }
        }
    }
}