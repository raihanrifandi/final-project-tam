package com.example.autenticationapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun BuatUlangPasswordScreen(navController: NavHostController) {
    var showDialog by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Title
            Text(
                text = "Buat Ulang Password",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF005BBB),
                textAlign = TextAlign.Center
            )

            // Subtitle
            Text(
                text = "Buat ulang password Anda",
                fontSize = 16.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Spacer
            Spacer(modifier = Modifier.height(16.dp))

            // Password Image
            val passwordImage = painterResource(id = R.drawable.ic_round_password) // Replace with your password image resource
            Image(
                painter = passwordImage,
                contentDescription = "Password Image",
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 16.dp)
            )

            // Instruction Text
            Text(
                text = "Masukkan Password baru Anda pada kolom dibawah",
                fontSize = 14.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Spacer
            Spacer(modifier = Modifier.height(16.dp))

            // Input Fields
            val newPassword = remember { mutableStateOf("") }
            val confirmNewPassword = remember { mutableStateOf("") }

            OutlinedTextField(
                value = newPassword.value,
                onValueChange = { newPassword.value = it },
                label = { Text(text = "Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            )

            OutlinedTextField(
                value = confirmNewPassword.value,
                onValueChange = { confirmNewPassword.value = it },
                label = { Text(text = "Ulangi Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            )

            // Spacer
            Spacer(modifier = Modifier.height(16.dp))

            // Kirim Button
            Button(
                onClick = { showDialog = true },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107)), // Warna kuning
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Text(
                    text = "Kirim",
                    color = Color(0xFF005BBB),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {showDialog = false},
            title = { Text("Konfirmasi") },
            text = { Text("Apakah Anda yakin dengan password baru tersebut?") },
            confirmButton = {
                Button(
                    onClick = { navController.navigate("login") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFD700)) // Warna kuning
                ) {
                    Text("Ya", color = Color.Black)
                }
            },
            dismissButton = {
                Button(
                    onClick = { showDialog = false },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF005BBB)) // Warna biru
                ) {
                    Text("Tidak", color = Color.White)
                }
            }
        )
    }
}