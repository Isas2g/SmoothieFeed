package com.example.smoothiefeedapp.data.network

import com.example.smoothiefeedapp.data.network.entities.Photo
import com.example.smoothiefeedapp.data.network.entities.User
import com.example.smoothiefeedapp.data.network.entities.Wall
import com.example.smoothiefeedapp.data.network.entities.WallItem
import com.example.smoothiefeedapp.data.network.entities.news.NewsItem
import com.example.smoothiefeedapp.data.network.entities.news.NewsPhotoUrl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class VKNetworkingRepository(
    private val token: String
) {

    fun getCurrentUser(): Flow<User> = flow {
        emit(VKNetworking.VKApi.getCurrentUser(token).response ?: User(0, "null", "null"))
    }


    fun getWallPosts(): Flow<List<List<Photo>>> = flow {
        emit(VKNetworking.VKApi.getWallItems(token).response.items.map { wallItem ->
            wallItem.attachments
        })
    }

    fun getNewsItems(): Flow<List<NewsItem>?> = flow {
//        VKNetworking.VKApi.getNews(token).response.items?.map { newsItem ->
//            newsItem.attachments?.map { newsAttachments ->
//                emit(newsAttachments.photo?.sizes)
//            }
//        }

        emit(VKNetworking.VKApi.getNews(token).response.items)
    }
}