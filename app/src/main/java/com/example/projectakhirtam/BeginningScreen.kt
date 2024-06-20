package com.example.autenticationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.autenticationapp.ui.theme.AutenticationAppTheme
import kotlinx.coroutines.delay

@Composable
fun BeginningScreen(navController: NavHostController) {
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
            )

            // Deskripsi

            Text(
                text = "Pilih Daftar Akun untuk pertama kali menggunakan,\n" +
                        "Masuk untuk masuk kedalam akun Anda",
                fontSize = 13.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 100.dp)
            )

            // Spacer untuk jarak
            Spacer(modifier = Modifier.height(16.dp))

            // Tombol Daftar Akun
            Button(
                onClick = { navController.navigate("register") }, // Navigasi ke layar Register
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF005BBB)), // Warna biru
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Text(
                    text = "Daftar Akun",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Spacer untuk jarak
            Spacer(modifier = Modifier.height(16.dp))

            // Tombol Masuk
            Button(
                onClick = { navController.navigate("login") }, // Navigasi ke layar Login
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .border(
                        width = 2.dp,
                        color = Color(0xFF005BBB),
                        shape = RoundedCornerShape(24.dp)
                    )
            ) {
                Text(
                    text = "Masuk",
                    color = Color(0xFF005BBB),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}