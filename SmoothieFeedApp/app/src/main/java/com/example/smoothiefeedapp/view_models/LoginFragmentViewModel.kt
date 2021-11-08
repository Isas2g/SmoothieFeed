package com.example.smoothiefeedapp.view_models

import android.app.Application
import android.util.Patterns
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smoothiefeedapp.MainApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class LoginFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val emailMutableStateFlow = MutableStateFlow<String?>(null)
    private val passwordMutableStateFlow = MutableStateFlow<String?>(null)
    private val emailIsCorrectMutStateFlow = MutableStateFlow<Boolean?>(null)
    private val passwordIsCorrectMutStateFlow = MutableStateFlow<Boolean?>(null)
    private val allFieldsIsCorrectMutStateFlow = MutableStateFlow<Boolean?>(null)

    private val datastoreRepository = getApplication<MainApplication>().datastoreRepository

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

    val userIsLoggedObserver: Flow<Boolean?> = datastoreRepository.observeUserLogging()

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
            datastoreRepository.userIsLogged(true)
        }
    }
}