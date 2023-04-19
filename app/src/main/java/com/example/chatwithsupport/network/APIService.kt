package com.example.chatwithsupport.network

import com.example.chatwithsupport.models.MessageModel
import retrofit2.http.GET

interface APIService {
    @GET("ENDPOINT")
    suspend fun getMessage(): MessageModel
}