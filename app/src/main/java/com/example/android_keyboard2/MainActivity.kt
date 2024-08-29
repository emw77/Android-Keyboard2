package com.example.android_keyboard2;

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.example.android_keyboard2.ChatActivity
import com.example.android_keyboard2.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Set the layout for the main activity

        // Find the button by its ID and set up a click listener
        val buttonOpenChat = findViewById<Button>(R.id.button_open_chat)
        buttonOpenChat.setOnClickListener {
            // Intent to start the ChatActivity
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent) // Start the ChatActivity
        }
    }
}
