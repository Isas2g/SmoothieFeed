package com.example.smoothiefeedapp.view_models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.smoothiefeedapp.MainApplication
import com.example.smoothiefeedapp.data.network.VKNetworkingRepository
import com.example.smoothiefeedapp.data.network.entities.news.NewsPhotoUrl
import com.example.smoothiefeedapp.presentation.main_fragment.MainFragmentItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var vkNetworkingRepository: VKNetworkingRepository
    private val datastoreRepository = getApplication<MainApplication>().datastoreRepository

    private val mainFragmentItemsMutStateFlow = MutableStateFlow<List<MainFragmentItem>?>(null)

    val mainFragmentItemsObserver: Flow<List<MainFragmentItem>?>
        get() = mainFragmentItemsMutStateFlow

    init {
        viewModelScope.launch(Dispatchers.IO) {
            datastoreRepository.observeVKTokenChanges()
                .collect { vkToken ->
                    if (!vkToken.isNullOrEmpty()) {
                        vkNetworkingRepository = VKNetworkingRepository(vkToken)
                        vkNetworkingRepository.getNewsItems().collect { listNewsItems ->

                            val addedList = mutableListOf<MainFragmentItem>()

                            listNewsItems?.forEach { newsItem ->
                                val newsAttachment = newsItem.attachments?.get(0)
                                if (newsAttachment!=null) {
                                    val lastPhotoUrl = newsAttachment.photo?.sizes?.last()
                                    addedList.add(
                                        MainFragmentItem(
                                            id = Random(100).nextInt(),
                                            photoUrl = lastPhotoUrl?.url ?: ""
                                        )
                                    )
                                }
                            }

                            mainFragmentItemsMutStateFlow.emit(addedList)

//                            val neededUrl = listNewsPhotoUrl.find { it.type == "y" }
//                            mainFragmentItemsMutStateFlow.emit(
//                                listOf(
//                                    MainFragmentItem(
//                                        id = Random(100).nextInt(),
//                                        photoUrl = neededUrl?.url ?: ""
//                                    )
//                                )
//
//                            )
//                            mainFragmentItemsMutStateFlow.emit(
//                                listOf(MainFragmentItem(
//                                    id = Random(100).nextInt(),
//                                    photoUrl = (listNewsPhotoUrl?.last() ?: NewsPhotoUrl("")).url ?: ""
//                                ))

//                                listNewsPhotoUrl.map {
//                                    if (it.type == "y") {
//                                        MainFragmentItem(
//                                            id = Random(100).nextInt(),
//                                            photoUrl = it.url
//                                        )
//                                    } else {
//                                        MainFragmentItem(
//                                            id = Random(100).nextInt(),
//                                            photoUrl = ""
//                                        )
//                                    }
//                                }
//                            )
                        }
                    }
                }
        }
    }
}