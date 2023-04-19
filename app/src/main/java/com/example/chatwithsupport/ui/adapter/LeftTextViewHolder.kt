package com.example.chatwithsupport.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.chatwithsupport.databinding.ItemToMeBinding
import com.example.chatwithsupport.models.MessageModel

class LeftTextViewHolder(private val binding: ItemToMeBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: MessageModel?) {
        binding.apply {
            if (data != null) {
                textGchatMessageOther.text = data.message
            }
        }
    }
}