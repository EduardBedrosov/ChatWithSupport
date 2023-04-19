package com.example.chatwithsupport.utils

import android.text.format.DateUtils.isToday
import java.text.SimpleDateFormat
import java.util.Locale

    fun formatDateTime(timeInMillis: Long): String? {
        return if (isToday(timeInMillis)) {
            formatTime(timeInMillis)
        } else {
            formatDate(timeInMillis)
        }
    }

    private fun formatTime(timeInMillis: Long): String? {
        val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        return dateFormat.format(timeInMillis)
    }

    private fun formatDate(timeInMillis: Long): String? {
        val dateFormat = SimpleDateFormat("MMMM dd", Locale.getDefault())
        return dateFormat.format(timeInMillis)
    }