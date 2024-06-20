package com.example.projectakhirtam

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

// Tombol backnya nanti bisa diarahin ke home atau section khusus message

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatActivity(navController: NavController) {
    var message by remember { mutableStateOf(TextFieldValue("")) }
    var messages by remember { mutableStateOf(listOf<Pair<Boolean, String>>()) } // Pair to differentiate between user (true) and doctor (false)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = "Back",
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Image(
                            painter = painterResource(id = R.drawable.dokterprofile),
                            contentDescription = "Doctor",
                            modifier = Modifier
                                .size(42.dp)
                                .clip(CircleShape)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text("Dr. Adhim Pandega", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                            Text("60 Minutes Session", fontSize = 12.sp, color = Color.Gray)
                        }
                    }
                },
                actions = {
                    IconButton(onClick = { /* Handle call action */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.call),
                            modifier = Modifier
                                .size(16.dp),
                            contentDescription = "Call"
                        )
                    }
                },
                modifier = Modifier.background(Color.White)
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF4F4F4))
                    .padding(padding)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                ) {
                    items(messages) { messagePair ->
                        if (messagePair.first) {
                            UserMessage(messagePair.second)
                        } else {
                            DoctorMessage(messagePair.second)
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .background(Color.White, RoundedCornerShape(16.dp)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BasicTextField(
                        value = message,
                        onValueChange = { message = it },
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Send),
                        keyboardActions = KeyboardActions(
                            onSend = {
                                if (message.text.isNotBlank()) {
                                    messages = messages + (true to message.text)
                                    message = TextFieldValue("")
                                    // Simulate doctor's response
                                    messages = messages + (false to "Thank you for your message. Dr. Adhim will reply shortly.")
                                }
                            }
                        ),
                        textStyle = LocalTextStyle.current.copy(fontSize = 16.sp)
                    )
                    IconButton(onClick = {
                        if (message.text.isNotBlank()) {
                            messages = messages + (true to message.text)
                            message = TextFieldValue("")
                            // Simulate doctor's response
                            messages = messages + (false to "Thank you for your message. Dr. Adhim will reply shortly.")
                        }
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.send),
                            modifier = Modifier
                                .size(16.dp),
                            contentDescription = "Send"
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun UserMessage(message: String) {
    Box(
        contentAlignment = Alignment.CenterEnd,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(
            text = message,
            modifier = Modifier
                .background(Color(0xFFE0E0E0), RoundedCornerShape(8.dp))
                .padding(8.dp)
        )
    }
}

@Composable
fun DoctorMessage(message: String) {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(
            text = message,
            modifier = Modifier
                .background(Color(0xFFF0F0F0), RoundedCornerShape(8.dp))
                .padding(8.dp)
        )
    }
}