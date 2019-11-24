package com.hariobudiharjo.destiny.Activity

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.hariobudiharjo.destiny.Adapter.MessageAdapter
import com.hariobudiharjo.destiny.Model.messageModel
import com.hariobudiharjo.destiny.R
import com.hariobudiharjo.destiny.Utils.App
import kotlinx.android.synthetic.main.activity_chat_bot.*
import org.json.JSONObject
import java.util.*

class ChatBotActivity : AppCompatActivity() {
    private lateinit var adapter: MessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_bot)

        messageList.layoutManager = LinearLayoutManager(this)
        adapter = MessageAdapter(this)
        messageList.adapter = adapter

        btnSend.setOnClickListener {
            if(txtMessage.text.isNotEmpty()) {
                val message = messageModel(
                    "chatbot",
                    txtMessage.text.toString(),
                    Calendar.getInstance().timeInMillis
                )
                adapter.addMessage(message)

                val messagebot = messageModel(
                    "hario",
                    txtMessage.text.toString(),
                    Calendar.getInstance().timeInMillis
                )
                adapter.addMessage(messagebot)

            } else {
                Toast.makeText(applicationContext,"Message should not be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun resetInput() {
        // Clean text box
        txtMessage.text.clear()

        // Hide keyboard
        val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(currentFocus!!.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    private fun setupPusher(nama:String,message:String,time:Long) {
            val message = messageModel(
                nama,
                message,
                time
            )

            runOnUiThread {
                adapter.addMessage(message)
                // scroll the RecyclerView to the last added element
                messageList.scrollToPosition(adapter.itemCount - 1);
            }
    }
}
