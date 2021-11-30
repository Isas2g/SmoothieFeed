package com.example.smoothiefeedapp.presentation.view_models

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smoothiefeedapp.domain.use_cases.AuthSFUserUseCase
import com.example.smoothiefeedapp.domain.use_cases.GetSFUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class LoginFragmentViewModel(
    private val authSFUserUseCase: AuthSFUserUseCase,
    val getSFUserChangesUseCase: GetSFUserUseCase
) : ViewModel() {
    private val emailMutableStateFlow = MutableStateFlow<String?>(null)
    private val passwordMutableStateFlow = MutableStateFlow<String?>(null)
    private val emailIsCorrectMutStateFlow = MutableStateFlow<Boolean?>(null)
    private val passwordIsCorrectMutStateFlow = MutableStateFlow<Boolean?>(null)
    private val allFieldsIsCorrectMutStateFlow = MutableStateFlow<Boolean?>(null)

    private var jobForAllFields: Job? = null

    val emailObserver: Flow<String?>
        get() = emailMutableStateFlow

    val passwordObserver: Flow<String?>
        get() = passwordMutableStateFlow

    val emailIsCorrectObserver: Flow<Boolean?>
        get() = emailIsCorrectMutStateFlow

    val passwordIsCorrectObserver: Flow<Boolean?>
        get() = passwordIsCorrectMutStateFlow

    val allFieldIsCorrectObserver: Flow<Boolean?>
        get() = allFieldsIsCorrectMutStateFlow

    private fun checkEmail(email: String?): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email ?: "").matches()

    private fun checkPassword(password: String?): Boolean =
        !password.isNullOrEmpty()

    fun saveEmail(email: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            emailIsCorrectMutStateFlow.emit(checkEmail(email))
            emailMutableStateFlow.emit(email)
            checkAllFieldsIsCorrect()
        }
    }

    fun savePassword(password: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            passwordIsCorrectMutStateFlow.emit(checkPassword(password))
            passwordMutableStateFlow.emit(password)
            checkAllFieldsIsCorrect()
        }
    }

    private fun checkAllFieldsIsCorrect() {
        jobForAllFields?.cancel()
        jobForAllFields = viewModelScope.launch(Dispatchers.IO) {
            allFieldsIsCorrectMutStateFlow.emit(
                emailIsCorrectMutStateFlow.value == true && passwordIsCorrectMutStateFlow.value == true
            )
        }
    }

    fun logIn(){
        viewModelScope.launch {
            authSFUserUseCase(emailMutableStateFlow.value!!, passwordMutableStateFlow.value!!)
        }
    }
}