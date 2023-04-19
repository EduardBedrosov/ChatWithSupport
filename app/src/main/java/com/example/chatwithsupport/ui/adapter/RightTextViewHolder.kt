package com.example.chatwithsupport.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.chatwithsupport.databinding.ItemMeBinding
import com.example.chatwithsupport.models.MessageModel

class RightTextViewHolder(private val binding: ItemMeBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(data: MessageModel?) {
        data?.let {
            binding.apply {
                textGchatMessageMe.text = data.message
            }
        }
    }
}