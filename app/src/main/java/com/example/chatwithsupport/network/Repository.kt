package com.example.chatwithsupport.network

import com.example.chatwithsupport.models.MessageModel
import java.lang.Exception

class Repository(private val apiService: APIService) {
    suspend fun getMessage(): UseCaseResult<MessageModel> =
        try {
            val result = apiService.getMessage()
            UseCaseResult.Success(result)
        } catch (ex: Exception) {
            UseCaseResult.Error(ex)
        }
}