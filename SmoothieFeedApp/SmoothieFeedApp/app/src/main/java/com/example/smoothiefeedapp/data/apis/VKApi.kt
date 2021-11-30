package com.example.smoothiefeedapp.data.apis

import com.example.smoothiefeedapp.data.enteties.api.user.UserResponse
import com.example.smoothiefeedapp.data.enteties.api.wall.WallResponse
import com.example.smoothiefeedapp.data.enteties.api.news.ResponseDefault
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
        @Query("filters") filter: String = "post", // just for mvp, change after
        @Query("count") count: Int = 10,
        @Query("start_from") startFrom: String = ""
    ): ResponseDefault

}