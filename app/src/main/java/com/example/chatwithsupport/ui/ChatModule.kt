package com.example.chatwithsupport.ui

import com.example.chatwithsupport.network.APIService
import com.example.chatwithsupport.network.Repository
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://https://eduardbedrosov.zendesk.com//"

val CHAT_MODULE = module {
    single {
        Repository(get())
    }

    viewModel { ChatViewModel(get() ) }

    single {
        createWebService<APIService>(
            okHttpClient = createHttpClient(),
            baseUrl = BASE_URL
        )
    }
}

fun createHttpClient(
): OkHttpClient {
    val client = OkHttpClient.Builder()
    client.apply {
        retryOnConnectionFailure(true)
        followRedirects(true)
        followSslRedirects(true)
        connectTimeout(30, TimeUnit.SECONDS)
        readTimeout(30, TimeUnit.SECONDS)
        writeTimeout(30, TimeUnit.SECONDS)
    }
    return client.build()
}

inline fun <reified T> createWebService(
    okHttpClient: OkHttpClient,
    baseUrl: String
): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .client(okHttpClient)
        .build()
    return retrofit.create(T::class.java)
}