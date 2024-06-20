package com.example.projectakhirtam

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.projectakhirtam.ui.theme.ProjectAkhirTAMTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingActivity(navController: NavController) {
    var selectedDate by remember { mutableStateOf<String?>(null) }
    var selectedTime by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Booking") },
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
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                // Doctor Information Section
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                        .background(Brush.verticalGradient(listOf(Color(0xFF204194), Color(0xFF4B75D7))))
                        .padding(16.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column {
                                Text(
                                    "Dr. Adhim Pandega",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                                Text(
                                    "RSUD Abdoel Moeloek",
                                    fontSize = 16.sp,
                                    color = Color.White
                                )
                            }
                            Image(
                                painter = painterResource(id = R.drawable.dokterprofile),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(80.dp)
                                    .clip(RoundedCornerShape(2.dp))
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            StatisticItem(iconRes = R.drawable.ic_patients, stat = "700+", label = "Patients")
                            StatisticItem(iconRes = R.drawable.ic_experience, stat = "10+", label = "Years expert")
                            StatisticItem(iconRes = R.drawable.ic_rating, stat = "5.0", label = "Rating")
                            StatisticItem(iconRes = R.drawable.ic_reviews, stat = "400+", label = "Reviews")
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "About",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                )
                Text(
                    text = "Dr. Adam Junior is a highly esteemed psychiatrist with over 9 years of experience in the field of mental health. He has been recognized for his ...",
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
                Text(
                    text = "Read More",
                    fontSize = 14.sp,
                    color = Color(0xFF204194),
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Date",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    DateOption("03", "Wed", selectedDate) { selectedDate = it }
                    DateOption("04", "Thu", selectedDate) { selectedDate = it }
                    DateOption("05", "Fri", selectedDate) { selectedDate = it }
                    DateOption("06", "Sun", selectedDate) { selectedDate = it }
                    DateOption("07", "Mon", selectedDate) { selectedDate = it }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Time",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    TimeOption("09.00", selectedTime) { selectedTime = it }
                    TimeOption("11.00", selectedTime) { selectedTime = it }
                    TimeOption("13.00", selectedTime) { selectedTime = it }
                    TimeOption("15.00", selectedTime) { selectedTime = it }
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = { navController.navigate("payment") },
                    enabled = selectedDate != null && selectedTime != null,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedDate != null && selectedTime != null) Color(0xFF204194) else Color.Gray
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .height(50.dp)
                ) {
                    Text("Book Appointment", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    )
}

@Composable
fun StatisticItem(iconRes: Int, stat: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(stat, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White)
        Text(label, fontSize = 12.sp, color = Color.White)
    }
}

@Composable
fun DateOption(day: String, dayOfWeek: String, selectedDate: String?, onSelect: (String) -> Unit) {
    val isSelected = selectedDate == day
    Column(
        modifier = Modifier
            .width(60.dp)
            .clickable { onSelect(day) }
            .background(if (isSelected) Color(0xFF204194) else Color(0xFFF0F0F0), RoundedCornerShape(8.dp))
            .padding(vertical = 8.dp, horizontal = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(day, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = if (isSelected) Color.White else Color.Black)
        Text(dayOfWeek, fontSize = 14.sp, color = if (isSelected) Color.White else Color.Black)
    }
}

@Composable
fun TimeOption(time: String, selectedTime: String?, onSelect: (String) -> Unit) {
    val isSelected = selectedTime == time
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(80.dp)
            .clickable { onSelect(time) }
            .background(if (isSelected) Color(0xFF204194) else Color(0xFFF0F0F0), RoundedCornerShape(8.dp))
            .padding(vertical = 8.dp)
    ) {
        Text(time, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = if (isSelected) Color.White else Color.Black)
    }
}

