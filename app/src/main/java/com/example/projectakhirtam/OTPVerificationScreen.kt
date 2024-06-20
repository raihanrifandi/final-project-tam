package com.example.autenticationapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun OTPVerificationScreen(navController: NavHostController) {
    var otpCode by remember { mutableStateOf("") }
    var timer by remember { mutableStateOf(330) } // 5 minutes 30 seconds

    LaunchedEffect(key1 = timer) {
        if (timer > 0) {
            delay(1000L)
            timer -= 1
        }
    }

    val minutes = timer / 60
    val seconds = timer % 60

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
            // Judul
            Text(
                text = "Verifikasi Kode OTP",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF003366), // Sesuaikan warna teks sesuai dengan gambar
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Deskripsi
            Text(
                text = "Satu langkah lagi, untuk dapat\nmenggunakan akun Anda kembali",
                fontSize = 16.sp,
                color = Color(0xFF003366), // Sesuaikan warna teks sesuai dengan gambar
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Spacer untuk jarak
            Spacer(modifier = Modifier.height(16.dp))

            // Gambar gembok
            val lockImage: Painter = painterResource(id = R.drawable.teenyicons_password_solid) // Sesuaikan dengan resource gambar Anda
            Image(
                painter = lockImage,
                contentDescription = "Lock Image",
                modifier = Modifier
                    .size(150.dp) // Sesuaikan dengan ukuran gambar Anda
                    .padding(vertical = 16.dp)
            )

            // Deskripsi bawah
            Text(
                text = "Masukkan Kode OTP yang telah dikirimkan\nke email hello.neuternal@gmail.com",
                fontSize = 14.sp,
                color = Color(0xFF003366), // Sesuaikan warna teks sesuai dengan gambar
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Spacer untuk jarak
            Spacer(modifier = Modifier.height(16.dp))

            // Input Fields
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                repeat(4) { index ->
                    OutlinedTextField(
                        value = if (otpCode.length > index) otpCode[index].toString() else "",
                        onValueChange = { value ->
                            if (value.length <= 1) {
                                val newOtpCode = otpCode.toCharArray().toMutableList()
                                if (index < otpCode.length) newOtpCode[index] = value.singleOrNull() ?: ' '
                                else newOtpCode.add(value.singleOrNull() ?: ' ')
                                otpCode = newOtpCode.joinToString("")
                            }
                        },
                        label = { },
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                    )
                }
            }

            // Timer
            Text(
                text = "Kode OTP akan kadaluarsa dalam %02d:%02d".format(minutes, seconds),
                fontSize = 14.sp,
                color = Color(0xFF003366), // Sesuaikan warna teks sesuai dengan gambar
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Spacer untuk jarak
            Spacer(modifier = Modifier.height(16.dp))

            // Tombol Kirim
            Button(
                onClick = { navController.navigate("reset_password") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFD700)), // Warna kuning
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Text(
                    text = "Kirim",
                    color = Color(0xFF003366), // Sesuaikan warna teks sesuai dengan gambar
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Link untuk mengirim ulang kode OTP
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Kirim Ulang Kode OTP",
                fontSize = 14.sp,
                color = Color(0xFF003366), // Sesuaikan warna teks sesuai dengan gambar
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .clickable {
                        // TODO: Handle resend OTP action
                    }
                    .padding(vertical = 8.dp)
            )
        }
    }
}