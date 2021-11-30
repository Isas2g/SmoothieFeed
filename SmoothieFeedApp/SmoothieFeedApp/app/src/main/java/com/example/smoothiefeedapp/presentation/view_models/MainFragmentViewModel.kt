package com.example.smoothiefeedapp.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smoothiefeedapp.domain.enteties.PostsDetox
import com.example.smoothiefeedapp.domain.enteties.TimeDetox
import com.example.smoothiefeedapp.presentation.items.NewsItem
import com.example.smoothiefeedapp.domain.use_cases.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlin.math.abs

class MainFragmentViewModel(
    private val getNewsListUseCase: GetNewsListUseCase,
    val getPostsDetoxUseCase: GetDetoxUseCase,
    val getTimeDetoxUseCase: GetDetoxUseCase,
    private val deletePostsDetoxUseCase: DeleteDetoxUseCase,
    private val deleteTimeDetoxUseCase: DeleteDetoxUseCase,
    private val loadNewsListUseCase: LoadNewsListUseCase
) : ViewModel() {
    private var countItemsOnPage = DEFAULT_COUNT_OF_ITEMS
    private var maxPostsCount = 0
    private var latestWatchedPostsCount = 0

    private val mainFragmentItemsMutStateFlow = MutableStateFlow<List<NewsItem>?>(null)
    private val timeDetoxIsChosenMutStateFlow = MutableStateFlow(false)

    private val tokenIsAddedMutStateFlow = MutableStateFlow<String?>(null)

    private val remainingTimeMutStateFlow = MutableStateFlow<Long?>(null)
    private val remainingPostsMutStateFlow = MutableStateFlow<Int?>(null)

    private val loadIsDoneMutStateFlow = MutableSharedFlow<Boolean>(0)

    val newsItemsObserver: Flow<List<NewsItem>?>
        get() = mainFragmentItemsMutStateFlow

    val remainingTimeObserver: Flow<Long?>
        get() = remainingTimeMutStateFlow

    val remainingPostsObserver: Flow<Int?>
        get() = remainingPostsMutStateFlow

    val loadIsDoneObserver: Flow<Boolean>
        get() = loadIsDoneMutStateFlow

    init {
        viewModelScope.launch(Dispatchers.IO) {
            launch {
                getPostsDetoxUseCase().collect { detox ->
                    if (detox != null && detox is PostsDetox) {
                        remainingPostsMutStateFlow.emit(detox.posts!!)
                        maxPostsCount = detox.posts
                        timeDetoxIsChosenMutStateFlow.emit(false)
                        getNextItems()
                    }
                }
            }
            launch {
                getTimeDetoxUseCase().collect { detox ->
                    if (detox != null && detox is TimeDetox) {
                        remainingTimeMutStateFlow.emit(detox.time!!)
                        timeDetoxIsChosenMutStateFlow.emit(true)
                        startTimer(detox.time)
                        getNextItems()
                    }
                }
            }
            launch {
                getNewsListUseCase().collect { newsList ->
                    val oldItems = mainFragmentItemsMutStateFlow.value ?: emptyList()
                    val remainingTime = remainingTimeMutStateFlow.value

                    if (!newsList.isNullOrEmpty()) {
                        if (timeDetoxIsChosenMutStateFlow.value) {
                            if (remainingTime ?: 0 > 0) {
                                mainFragmentItemsMutStateFlow.emit(
                                    oldItems + newsList
                                        .map { news ->
                                            NewsItem(news)
                                        }
                                )
                            }
                        } else if (oldItems.size < maxPostsCount) {
                            if (oldItems.size + DEFAULT_COUNT_OF_ITEMS > maxPostsCount) {
                                countItemsOnPage = abs(oldItems.size - maxPostsCount)
                                mainFragmentItemsMutStateFlow.emit(
                                    oldItems + newsList
                                        .map { news ->
                                            NewsItem(news)
                                        }
                                )
                            } else {
                                mainFragmentItemsMutStateFlow.emit(
                                    oldItems + newsList
                                        .map { news ->
                                            NewsItem(news)
                                        }
                                )
                            }
                        }
                        loadIsDoneMutStateFlow.emit(true)
                    }
                }
            }
        }
    }

    fun cleanAllChosenDetoxes() {
        viewModelScope.launch(Dispatchers.IO) {
            launch {
                deletePostsDetoxUseCase()
            }
            launch {
                deleteTimeDetoxUseCase()
            }
        }
    }

    private fun startTimer(time: Long) {
        viewModelScope.launch {
            tokenIsAddedMutStateFlow.collect {
                if (it != null) {
                    if (remainingTimeMutStateFlow.value != null) {
                        repeat((time / 1000).toInt()) {
                            remainingTimeMutStateFlow.emit(remainingTimeMutStateFlow.value!! - 1000)
                            delay(1000)
                        }
                    }
                }
            }
        }
    }

    fun getNextItems() {
        viewModelScope.launch(Dispatchers.IO) {
            loadNewsListUseCase()
        }
    }

    fun countPosts(watchedPosts: Int) {
        if (remainingPostsMutStateFlow.value != null) {
            viewModelScope.launch(Dispatchers.IO) {
                if (watchedPosts > latestWatchedPostsCount && !timeDetoxIsChosenMutStateFlow.value) {
                    remainingPostsMutStateFlow.emit(remainingPostsMutStateFlow.value!! - watchedPosts + latestWatchedPostsCount)
                    latestWatchedPostsCount = watchedPosts
                }
            }
        }

    }

    companion object {
        const val DEFAULT_COUNT_OF_ITEMS = 10
    }
}