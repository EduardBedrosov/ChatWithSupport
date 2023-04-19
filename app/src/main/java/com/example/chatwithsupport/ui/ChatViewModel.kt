package com.example.chatwithsupport.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatwithsupport.models.MessageModel
import com.example.chatwithsupport.network.Repository
import com.example.chatwithsupport.network.UseCaseResult
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class ChatViewModel(private val repo: Repository): ViewModel() {

//    private val parentJob = Job()
//    private val coroutineContext: CoroutineContext
//        get() = parentJob + Dispatchers.IO
//    private val scope: CoroutineScope by lazy { CoroutineScope(coroutineContext) }

    private val _data = MutableLiveData<List<MessageModel>>()
    val data: LiveData<List<MessageModel>> = _data

    private val listItems = mutableListOf<MessageModel>()

    fun myMessage(message: MessageModel) {
        listItems.add(message)
        _data.value = listItems
    }

    fun otherMessage() {

//        viewModelScope.launch {
            _data.value = listItems
//            val result = withContext(Dispatchers.IO) {
//                repo.getMessage()
//            }
//
//            when(result) {
//                is UseCaseResult.Success -> {
//                    _data.value = result.data
//                }
//                is UseCaseResult.Error -> {
//                    // inch vor error
//                }
//            }
//        }
    }



//    override val coroutineContext: CoroutineContext
//        get() = Job() + Dispatchers.IO

}