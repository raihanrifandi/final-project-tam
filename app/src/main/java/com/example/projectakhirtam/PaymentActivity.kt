package com.example.projectakhirtam

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentActivity(navController: NavController) {
    var selectedPaymentMethod by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Payment") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(8.dp)
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
            ) {
                DoctorInfoSection()
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Payment Method", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Spacer(modifier = Modifier.height(8.dp))

                // Gopay Option
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .background(Color(0xFFF0F0F0), shape = RoundedCornerShape(8.dp))
                        .clickable { selectedPaymentMethod = "Gopay" }
                        .padding(16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.gopay),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text("Gopay", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        Text("Saldo: Rp729.000", fontSize = 14.sp)
                    }
                    RadioButton(
                        selected = selectedPaymentMethod == "Gopay",
                        onClick = { selectedPaymentMethod = "Gopay" }
                    )
                }

                // Dana Option
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .background(Color(0xFFF0F0F0), shape = RoundedCornerShape(8.dp))
                        .clickable { selectedPaymentMethod = "Dana" }
                        .padding(16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.dana),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text("Dana", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        Text("Saldo: Rp50.000", fontSize = 14.sp)
                    }
                    RadioButton(
                        selected = selectedPaymentMethod == "Dana",
                        onClick = { selectedPaymentMethod = "Dana" }
                    )
                }

                // OVO Option
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .background(Color(0xFFF0F0F0), shape = RoundedCornerShape(8.dp))
                        .clickable { selectedPaymentMethod = "OVO" }
                        .padding(16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ovo),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text("OVO", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        Text("Saldo: Rp50.000", fontSize = 14.sp)
                    }
                    RadioButton(
                        selected = selectedPaymentMethod == "OVO",
                        onClick = { selectedPaymentMethod = "OVO" }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Details Transaction", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Spacer(modifier = Modifier.height(8.dp))
                TransactionDetails(selectedPaymentMethod)
                Spacer(modifier = Modifier.height(64.dp))
                Button(
                    onClick = { navController.navigate("chat") },
                    enabled = selectedPaymentMethod != null,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedPaymentMethod != null) Color(0xFF204194) else Color.Gray
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Confirm", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    )
}

@Composable
fun DoctorInfoSection() {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.dokter),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .background(Color.White, shape = RoundedCornerShape(32.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text("Dr. Adhim Pandega", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text("RSUD Abdoel Moeloek", color = Color(0xFF204194), fontSize = 14.sp)
                Text("8 Years experience     Price : Rp.50.000", fontSize = 14.sp)
                Text("60 minutes session", fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun TransactionDetails(selectedPaymentMethod: String?) {
    Column {
        TransactionDetailRow("Consultation Fee", "Rp50.000")
        TransactionDetailRow("Additional Fee", "Rp5.000")
        TransactionDetailRow("Payment Method", selectedPaymentMethod ?: "Not selected")
        Spacer(modifier = Modifier.height(8.dp))
        TransactionDetailRow("Total Cost", "Rp55.000", fontWeight = FontWeight.Bold)
    }
}

@Composable
fun TransactionDetailRow(label: String, value: String, fontWeight: FontWeight = FontWeight.Normal) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, fontWeight = fontWeight, fontSize = 16.sp)
        Text(value, fontWeight = fontWeight, fontSize = 16.sp)
    }
}