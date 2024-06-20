package com.example.projectakhirtam

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConsultActivity(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Konsultasi Online") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
            ) {
                item {
                    val containerColor = Color(0xFFF0F0F0)
                    TextField(
                        value = "",
                        onValueChange = {},
                        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                        placeholder = { Text("Contoh: Dr. Sigma Mewing") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = containerColor,
                            unfocusedContainerColor = containerColor,
                            disabledContainerColor = containerColor,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                        )
                    )
                }
                items(4) { index ->
                    when (index) {
                        0 -> DoctorCard(
                            name = "Dr. Adhim Pandega",
                            speciality = "RSUD Abdoel Moeloek",
                            experience = "10 Years experience",
                            rating = 87,
                            patientStories = 69,
                            fee = 50000,
                            time = "10:00 AM tomorrow",
                            isAvailable = true,
                            navController = navController
                        )
                        1 -> DoctorCard(
                            name = "Dr. Boyke",
                            speciality = "RS Bhayangkara",
                            experience = "7 Years experience",
                            rating = 57,
                            patientStories = 76,
                            fee = 30000,
                            time = "09:00 AM tomorrow",
                            isAvailable = true,
                            navController = navController
                        )
                        2 -> DoctorCard(
                            name = "Dr. Kai Cenat",
                            speciality = "RS Ohio",
                            experience = "6 Years experience",
                            rating = 83,
                            patientStories = 50,
                            fee = 60000,
                            time = "08:00 AM tomorrow",
                            isAvailable = false,
                            navController = navController
                        )
                        3 -> DoctorCard(
                            name = "Dr. Skibidi Toilet",
                            speciality = "RS Advent",
                            experience = "5 Years experience",
                            rating = 80,
                            patientStories = 49,
                            fee = 55000,
                            time = "09:00 AM tomorrow",
                            isAvailable = true,
                            navController = navController
                        )
                    }
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorCard(
    name: String,
    speciality: String,
    experience: String,
    rating: Int,
    patientStories: Int,
    fee: Int,
    time: String,
    isAvailable: Boolean,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .padding(end = 16.dp),
                    contentScale = ContentScale.Fit
                )
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text(text = speciality, color = Color(0xFF204194), fontWeight = FontWeight.Bold)
                    Text(text = experience, color = Color.Gray)
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .background(Color(0xFF00A672), shape = RoundedCornerShape(50))
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "$rating%", fontWeight = FontWeight.Bold, color = Color(0xFF00A672))
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .background(Color(0xFF00A672), shape = RoundedCornerShape(50))
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "$patientStories Patient", color = Color.Gray)
                    }
                }
                IconButton(onClick = { /* Add to favorites */ }) {
                    Icon(Icons.Default.FavoriteBorder, contentDescription = null, tint = Color.Gray)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Text(text = "Rp. $fee", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color(0xFF204194))
                    Text(text = time, color = Color.Gray, fontWeight = FontWeight.Bold)
                }
                if (isAvailable) {
                    Button(
                        onClick = { navController.navigate("booking") },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFBB901))
                    ) {
                        Text("Chat Now")
                    }
                } else {
                    Button(
                        onClick = { /* Handle busy */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                    ) {
                        Text("Busy")
                    }
                }
            }
        }
    }
}
