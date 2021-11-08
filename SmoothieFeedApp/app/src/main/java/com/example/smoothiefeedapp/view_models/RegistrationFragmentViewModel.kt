package com.example.smoothiefeedapp.view_models

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RegistrationFragmentViewModel : ViewModel() {
    private val usernameMutStateFlow = MutableStateFlow<String?>(null)
    private val emailMutStateFlow = MutableStateFlow<String?>(null)
    private val firstPasswordMutStateFlow = MutableStateFlow<String?>(null)
    private val secondPasswordMutStateFlow = MutableStateFlow<String?>(null)

    private val usernameIsCorrectMutStateFlow = MutableStateFlow<Boolean?>(null)
    private val emailIsCorrectMutStateFlow = MutableStateFlow<Boolean?>(null)
    private val firstPasswordIsCorrectMutStateFlow = MutableStateFlow<Boolean?>(null)
    private val secondPasswordIsCorrectMutStateFlow = MutableStateFlow<Boolean?>(null)
    private val allFieldsIsCorrectMutStateFlow = MutableStateFlow<Boolean?>(null)

    private var jobForAllFields: Job? = null

    val usernameObserver: Flow<String?>
        get() = usernameMutStateFlow
    val emailObserver: Flow<String?>
        get() = emailMutStateFlow
    val firstPasswordObserver: Flow<String?>
        get() = firstPasswordMutStateFlow
    val secondPasswordObserver: Flow<String?>
        get() = secondPasswordMutStateFlow

    val usernameIsCorrectObserver: Flow<Boolean?>
        get() = usernameIsCorrectMutStateFlow
    val emailIsCorrectObserver: Flow<Boolean?>
        get() = emailIsCorrectMutStateFlow
    val firstPasswordIsCorrectObserver: Flow<Boolean?>
        get() = firstPasswordIsCorrectMutStateFlow
    val secondPasswordIsCorrectObserver: Flow<Boolean?>
        get() = secondPasswordIsCorrectMutStateFlow
    val allFieldsIsCorrectObserver: Flow<Boolean?>
        get() = allFieldsIsCorrectMutStateFlow

    fun saveUsername(username: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            usernameMutStateFlow.emit(username)
            usernameIsCorrectMutStateFlow.emit(!username.isNullOrEmpty())
            checkAllFields()
        }
    }

    fun saveEmail(email: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            emailMutStateFlow.emit(email)
            emailIsCorrectMutStateFlow.emit(Patterns.EMAIL_ADDRESS.matcher(email ?: "").matches())
            checkAllFields()
        }
    }

    fun saveFirstPassword(firstPassword: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            firstPasswordMutStateFlow.emit(firstPassword)
            firstPasswordIsCorrectMutStateFlow.emit(!firstPassword.isNullOrEmpty())
            checkAllFields()
        }
    }

    fun saveSecondPassword(secondPassword: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            secondPasswordMutStateFlow.emit(secondPassword)
            secondPasswordIsCorrectMutStateFlow.emit(!secondPassword.isNullOrEmpty())
            checkAllFields()
        }
    }

    fun firstAndSecondPasswordAreSame(): Boolean =
        firstPasswordMutStateFlow.value == secondPasswordMutStateFlow.value

    private fun checkAllFields() {
        jobForAllFields?.cancel()
        jobForAllFields = viewModelScope.launch(Dispatchers.IO) {
            allFieldsIsCorrectMutStateFlow.emit(
                usernameIsCorrectMutStateFlow.value == true &&
                        emailIsCorrectMutStateFlow.value == true &&
                        firstPasswordIsCorrectMutStateFlow.value == true &&
                        secondPasswordIsCorrectMutStateFlow.value == true &&
                        firstAndSecondPasswordAreSame()
            )
        }
    }

}