package com.example.chatsapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatsapp.R
import com.example.chatsapp.data.Chat
import com.example.chatsapp.utils.Const.RECEIVE_ID
import com.example.chatsapp.utils.Const.SEND_ID
import kotlinx.android.synthetic.main.chat_item.view.*

class ChatAdapter : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {
    var chatsList = mutableListOf<Chat>()
    inner class ChatViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        init{
            itemView.setOnClickListener{
                chatsList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return ChatViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.chat_item,parent,false))
    }
    override fun getItemCount(): Int {
        return chatsList.size
    }
    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val currentChat = chatsList[position]
        when (currentChat.id) {
            SEND_ID -> { holder.itemView.sendTv.apply {
                    text = currentChat.chat
                    visibility = View.VISIBLE
                }
                holder.itemView.receiveTv.visibility = View.GONE
            }
            RECEIVE_ID -> { holder.itemView.receiveTv.apply {
                    text = currentChat.chat
                    visibility = View.VISIBLE
                }
                holder.itemView.sendTv.visibility = View.GONE
            }
        }
    }
    fun insertChat(chat: Chat) {
        this.chatsList.add(chat)
        notifyItemInserted(chatsList.size)
    }
}