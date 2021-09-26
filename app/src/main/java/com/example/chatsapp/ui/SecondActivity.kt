package com.example.chatsapp.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatsapp.R
import com.example.chatsapp.data.Chat
import com.example.chatsapp.utils.BotChatting
import com.example.chatsapp.utils.Const.OPEN_GOOGLE
import com.example.chatsapp.utils.Const.OPEN_SEARCH
import com.example.chatsapp.utils.Const.RECEIVE_ID
import com.example.chatsapp.utils.Const.SEND_ID
import com.example.chatsapp.utils.Time
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.coroutines.*

class SecondActivity : AppCompatActivity() {
    private val TAG = "SecondActivity"
    private lateinit var chatAdapter:ChatAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        recyclerView()

        clickEvents()

        customChat("Hi, how can I help?")
    }
    private fun clickEvents() {
        sendBtn.setOnClickListener {
            sendChat()
        }
        chatEt.setOnClickListener {
            GlobalScope.launch {
                delay(100)
                withContext(Dispatchers.Main) {
                    chatRv.scrollToPosition(chatAdapter.itemCount - 1)
                }
            }
        }
    }
    private fun recyclerView() {
        chatAdapter = ChatAdapter()
        chatRv.adapter = chatAdapter
        chatRv.layoutManager = LinearLayoutManager(applicationContext)

    }
    private fun sendChat() {
        val chat = chatEt.text.toString()
        val timeStamp = Time.timeStamp()
        if (chat.isNotEmpty()) {
            chatEt.setText("")
            chatAdapter.insertChat(Chat(chat, SEND_ID, timeStamp))
            chatRv.scrollToPosition(chatAdapter.itemCount - 1)
            botChatting(chat)
        }
    }
    private fun botChatting(chat: String) {
        val timeStamp = Time.timeStamp()
        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) {
                val chatting = BotChatting.basicChatting(chat)
                chatAdapter.insertChat(Chat(chatting, RECEIVE_ID, timeStamp))
                chatRv.scrollToPosition(chatAdapter.itemCount - 1)
                when (chatting) {
                    OPEN_GOOGLE -> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.google.com/")
                        startActivity(site)
                    }
                    OPEN_SEARCH -> {
                        val site = Intent(Intent.ACTION_VIEW)
                        val searchTerm: String? = chat.substringAfterLast("search")
                        site.data = Uri.parse("https://www.google.com/search?&q=$searchTerm")
                        startActivity(site)
                    }

                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) {
                chatRv.scrollToPosition(chatAdapter.itemCount - 1)
            }
        }
    }

    private fun customChat(chat: String) {

        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) {
                val timeStamp = Time.timeStamp()
                chatAdapter.insertChat(Chat(chat, RECEIVE_ID, timeStamp))
                chatRv.scrollToPosition(chatAdapter.itemCount - 1)
            }
        }

    }
}


