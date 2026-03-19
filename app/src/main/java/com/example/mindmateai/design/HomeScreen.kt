package com.example.mindmateai.design

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController? = null) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF141E30), Color(0xFF243B55))
                )
            ),
        contentAlignment = Alignment.Center
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = "MindMate AI",
                color = Color.White,
                fontSize = 32.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .clickable { navController?.navigate("chat") },
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = "AI Chat",
                    modifier = Modifier.padding(30.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .clickable { navController?.navigate("summary") },
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = "Summarize Notes",
                    modifier = Modifier.padding(30.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}