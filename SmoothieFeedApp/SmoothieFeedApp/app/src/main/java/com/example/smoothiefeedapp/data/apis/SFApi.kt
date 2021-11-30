package com.example.smoothiefeedapp.data.apis

import com.example.smoothiefeedapp.data.enteties.api.SFToken
import retrofit2.http.POST
import retrofit2.http.Query

interface SFApi {
    @POST("api/v1/users/create/")
    suspend fun createUser(
        @Query("email") email: String,
        @Query("username") userName: String,
        @Query("password") password: String
    )

    @POST("auth/jwt/create")
    suspend fun authUser(
        @Query("username") userName: String,
        @Query("password") password: String
    ): SFToken
}