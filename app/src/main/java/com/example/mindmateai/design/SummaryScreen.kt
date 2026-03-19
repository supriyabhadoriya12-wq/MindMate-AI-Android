package com.example.mindmateai.design

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SummaryScreen (){
    var inputText by remember { mutableStateOf("") }
    var summaryText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F172A))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "AI Notes Summarizer",
            color = Color.White,
            fontSize = 26.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = inputText,
            onValueChange = { inputText = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Paste your notes here...") }
        )

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {
                summaryText = if (inputText.length > 60)
                    inputText.take(60) + "..."
                else inputText
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Generate Summary")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.DarkGray
            )
        ) {
            Text(
                text = summaryText,
                modifier = Modifier.padding(16.dp),
                color = Color.White
            )
        }
    }
}