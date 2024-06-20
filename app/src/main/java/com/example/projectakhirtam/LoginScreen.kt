package com.example.autenticationapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun LoginScreen(navController: NavHostController) {
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
            // Logo
            val logo: Painter = painterResource(id = R.drawable.neuternal) // Sesuaikan dengan resource logo Anda
            Image(
                painter = logo,
                contentDescription = "Logo",
                modifier = Modifier
                    .size(200.dp) // Sesuaikan dengan ukuran logo Anda
                    .padding(bottom = 16.dp)
            )

            // Deskripsi
            Text(
                text = "Bersama Melawan Lupa, Merawat dengan Penuh Cinta",
                fontSize = 16.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Spacer untuk jarak
            Spacer(modifier = Modifier.height(16.dp))

            // Input Fields
            val emailOrPhone = remember { mutableStateOf("") }
            val password = remember { mutableStateOf("") }

            OutlinedTextField(
                value = emailOrPhone.value,
                onValueChange = { emailOrPhone.value = it },
                label = { Text(text = "No. Telp/Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            )

            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text(text = "Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            )

            // Link Lupa Password
            Text(
                text = "Lupa password?",
                fontSize = 14.sp,
                color = Color.Blue,
                textAlign = TextAlign.Right,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { navController.navigate("forgot_password")  }
            )

            // Spacer untuk jarak
            Spacer(modifier = Modifier.height(16.dp))

            // Tombol Masuk
            Button(
                onClick = { /* TODO: Handle Masuk action */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF005BBB)), // Warna biru
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Text(
                    text = "Masuk",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Link Daftar Akun
            Text(
                text = "Belum punya Akun? Daftar disini",
                fontSize = 14.sp,
                color = Color.Blue,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { navController.navigate("register") }
            )
        }
    }
}