package com.example.mindmateai.ViewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ChatViewModel : ViewModel() {

    var text = mutableStateOf("")
    var messages = mutableStateListOf<Pair<String, Boolean>>()

    fun sendMessage() {

        val userText = text.value

        if (userText.isNotEmpty()) {

            messages.add(Pair(userText, true))

            // Fake AI Reply (Later we can add Real API)
            messages.add(
                Pair(
                    "AI Reply for: $userText",
                    false
                )
            )

            text.value = ""
        }
    }
}