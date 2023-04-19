package com.example.chatwithsupport.ui.adapter

import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BasePagedAdapter<T : Any>(diffUtil: DiffUtil.ItemCallback<T>) : PagingDataAdapter<T, RecyclerView.ViewHolder>(diffUtil)