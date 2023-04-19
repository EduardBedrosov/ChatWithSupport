package com.example.chatwithsupport.models

data class UserMessageModel(
    val userMessage: String?,
    val userId: Int = -1,
//    val isSupport: Boolean = false
)