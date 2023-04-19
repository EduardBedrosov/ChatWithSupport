package com.example.chatwithsupport.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chatwithsupport.R
import com.example.chatwithsupport.models.MessageModel
import com.example.chatwithsupport.utils.formatDateTime


class MessageListAdapter(private val messageList: List<MessageModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int = messageList.size

    // Determines the appropriate ViewType according to the sender of the message.
//    override fun getItemViewType(position: Int): Int {
//        val message: UserMessage = mMessageList[position] as UserMessage
//        return if (message.getSender().getUserId().equals(SendBird.getCurrentUser().getUserId())) {
//            // If the current user is the sender of the message
//            VIEW_TYPE_MESSAGE_SENT
//        } else {
//            // If some other user sent the message
//            VIEW_TYPE_MESSAGE_RECEIVED
//        }
//    }

    override fun getItemViewType(position: Int): Int {
        val item = messageList[position]

        if (isSentFromMe(item.senderId)) {
            if (item.message != null) {
                return LEFT_TEXT
            }
        } else if (item.message != null) {
            return RIGHT_TEXT
        }
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        return if (viewType == VIEW_TYPE_MESSAGE_SENT) {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_me, parent, false)
            SentMessageHolder(view)
        } else {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_to_me, parent, false)
            ReceivedMessageHolder(view)
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val messageModel: MessageModel = messageList[position]
        when (holder.itemViewType) {
            VIEW_TYPE_MESSAGE_SENT -> (holder as SentMessageHolder?)?.bind(messageModel)
            VIEW_TYPE_MESSAGE_RECEIVED -> (holder as ReceivedMessageHolder?)?.bind(messageModel)
        }
    }

    private inner class SentMessageHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var messageText: TextView
        var timeText: TextView
        fun bind(messageModel: MessageModel) {
            messageText.text = messageModel.message

            // Format the stored timestamp into a readable String using method.
            timeText.text = formatDateTime(messageModel.createdAt.toLong())
        }

        init {
            messageText = itemView.findViewById(R.id.text_gchat_message_me)
            timeText = itemView.findViewById(R.id.text_gchat_timestamp_me)
        }
    }

    private inner class ReceivedMessageHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var messageText: TextView
        var timeText: TextView
        var nameText: TextView
        fun bind(messageModel: MessageModel) {
            messageText.text = messageModel.message

            // Format the stored timestamp into a readable String using method.
            timeText.text = formatDateTime(messageModel.createdAt.toLong())
            nameText.text = messageModel.name

        }

        init {
            messageText = itemView.findViewById(R.id.text_gchat_message_other)
            timeText = itemView.findViewById(R.id.text_gchat_timestamp_other)
            nameText = itemView.findViewById(R.id.text_gchat_user_other)
        }
    }

    private fun isSentFromMe(senderId: Int?): Boolean {
        return USER_ID == senderId
    }

    companion object {
        private const val USER_ID = -1
        private const val VIEW_TYPE_MESSAGE_SENT = 1
        private const val VIEW_TYPE_MESSAGE_RECEIVED = 2
        private const val LEFT_TEXT = 1
        private const val RIGHT_TEXT = 2
    }
}