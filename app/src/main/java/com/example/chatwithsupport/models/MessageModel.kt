package com.example.chatwithsupport.models

data class MessageModel(
    val message: String?,
    val senderId: Int?,
    val createdAt: String,
    val name: String?
//    val userId: Int = -1
//    var isNotSent: Boolean = false,
)