package com.example.smoothiefeedapp.data.network

import android.util.Log
import com.example.smoothiefeedapp.data.key_value.DatastoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import timber.log.Timber

object VKNetworking {
    private const val BASE_URL = "https://api.vk.com/method/"

    private fun buildOkHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .addNetworkInterceptor(
                HttpLoggingInterceptor { httpMessage ->
                    Timber.e(httpMessage)
                }
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
        return okHttpClientBuilder.build()
    }

    private var retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(buildOkHttpClient())
        .build()

    val VKApi: VKApi
        get() = retrofit.create()
}