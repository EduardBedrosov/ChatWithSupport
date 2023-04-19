package com.example.chatwithsupport.ui.adapter
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.RecyclerView
//import com.example.chatwithsupport.databinding.ItemMeBinding
//import com.example.chatwithsupport.databinding.ItemToMeBinding
//import com.example.chatwithsupport.models.MessageModel
//
//class MessageListAdapter3(private val _userId: Int?) : BasePagedAdapter<MessageModel>(DiffCallback()) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return when (viewType) {
//            LEFT_TEXT -> LeftTextViewHolder(ItemToMeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
////            RIGHT_TEXT -> RightTextViewHolder(ItemMeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
//            else -> RightTextViewHolder(ItemMeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
//        }
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        when (getItemViewType(position)) {
//            LEFT_TEXT -> (holder as LeftTextViewHolder).bind(getItem(position))
//            RIGHT_TEXT -> (holder as RightTextViewHolder).bind(getItem(position))
//        }
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        val item = getItem(position)
//
//         if(isSentFromMe(item?.senderId)) {
//            if(item?.message != null) {
//                return LEFT_TEXT
//            }
//        } else if(item?.message != null) {
//             return RIGHT_TEXT
//         }
//        return 0
//
//    }
//
//    private class DiffCallback : DiffUtil.ItemCallback<MessageModel>() {
//
//        override fun areItemsTheSame(oldItem: MessageModel, newItem: MessageModel): Boolean {
//            return oldItem.senderId == newItem.senderId
//        }
//        override fun areContentsTheSame(oldItem: MessageModel, newItem: MessageModel): Boolean {
//            return oldItem == newItem
//        }
//    }
//
//    private fun isSentFromMe(senderId: Int?): Boolean {
//        return _userId != senderId
//    }
//
//    companion object {
//        const val LEFT_TEXT = 1
//        const val RIGHT_TEXT = 2
//    }
//}
