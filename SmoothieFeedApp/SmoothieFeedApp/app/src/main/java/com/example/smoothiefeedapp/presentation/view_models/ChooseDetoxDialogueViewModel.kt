package com.example.smoothiefeedapp.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smoothiefeedapp.domain.enteties.PostsDetox
import com.example.smoothiefeedapp.domain.enteties.TimeDetox
import com.example.smoothiefeedapp.domain.use_cases.GetDetoxUseCase
import com.example.smoothiefeedapp.domain.use_cases.SavePostsDetoxUseCase
import com.example.smoothiefeedapp.domain.use_cases.SaveTimeDetoxUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ChooseDetoxDialogueViewModel(
    private val savePostsDetoxUseCase: SavePostsDetoxUseCase,
    private val saveTimeDetoxUseCase: SaveTimeDetoxUseCase,
    val getPostsDetoxUseCase: GetDetoxUseCase,
    val getTimeDetoxUseCase: GetDetoxUseCase
) : ViewModel() {

    private val chosenDetoxWasSavedMutStateFlow = MutableStateFlow(false)

    val chosenDetoxWasSavedObserver: Flow<Boolean>
        get() = chosenDetoxWasSavedMutStateFlow

    fun setDetox(whichChosen: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                when (whichChosen) {
                    1 -> savePostsDetoxUseCase(PostsDetox(50))
                    2 -> saveTimeDetoxUseCase(TimeDetox(7200000))
                    3 -> savePostsDetoxUseCase(PostsDetox(30))
                    4 -> saveTimeDetoxUseCase(TimeDetox(3600000))
                    5 -> savePostsDetoxUseCase(PostsDetox(10))
                    6 -> saveTimeDetoxUseCase(TimeDetox(1800000))
                }
            }

        }
    }
}