package com.example.mindmateai.design

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mindmateai.ViewModel.ChatViewModel


@Composable
fun ChatScreen(vm: ChatViewModel = viewModel()) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF111111))
    ) {

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(10.dp)
        ) {

            items(vm.messages) { msg ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                    colors = CardDefaults.cardColors(
                        containerColor =
                            if (msg.second) Color(0xFF5F2EEA)
                            else Color.DarkGray
                    )
                ) {

                    Text(
                        text = msg.first,
                        modifier = Modifier.padding(14.dp),
                        color = Color.White
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {

            TextField(
                value = vm.text.value,
                onValueChange = { vm.text.value = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Ask AI...") }
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = { vm.sendMessage() }
            ) {
                Text("Send")
            }
        }
    }
}