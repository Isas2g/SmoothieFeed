package com.example.smoothiefeedapp.data.network

import com.example.smoothiefeedapp.data.network.entities.UserResponse
import com.example.smoothiefeedapp.data.network.entities.WallResponse
import com.example.smoothiefeedapp.data.network.entities.news.NewsResponse
import com.example.smoothiefeedapp.data.network.entities.news.ResponseDefault
import retrofit2.http.GET
import retrofit2.http.Query

interface VKApi {

    @GET("account.getProfileInfo?")
    suspend fun getCurrentUser(
        @Query("access_token") token: String,
        @Query("v") v: String = "5.131"
    ): UserResponse

    @GET("wall.get?")
    suspend fun getWallItems(
        @Query("access_token") token: String,
        @Query("v") v: String = "5.131"
    ): WallResponse

    @GET("newsfeed.get?")
    suspend fun getNews(
        @Query("access_token") token: String,
        @Query("v") v: String = "5.131",
        @Query("filters") filter: String = "posts", // just for mvp, change after
        @Query("count") count: Int = 10
    ): ResponseDefault

}