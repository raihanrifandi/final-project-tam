@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.forumpage_neuternal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.forumpage_neuternal.ui.theme.BlueGradient
import com.example.forumpage_neuternal.ui.theme.GrayWhite

@Composable
fun ForumPage1(navController: NavController, modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // ===================================  Navbar Atas  ===================================
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(210.dp)
//                .background(color = Color.Yellow)
        ) {
            Image(
                painter = painterResource(id = R.drawable.navbar_2),
                contentDescription = null,
                modifier = modifier,
                contentScale = ContentScale.FillWidth
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(x = (0).dp, y = (40).dp)
                    .height(160.dp)
//                .background(color = Color.Black)
            ) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.profil_navbar_icon),
                        contentDescription = null,
                        modifier = modifier
                            .offset(x = (28).dp, y = (0).dp)
                            .width(50.dp),
                        contentScale = ContentScale.FillWidth
                    )

                    val annotatedString = buildAnnotatedString {
                        pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
                        append("Hi, Msbree")
                    }

                    Column {

                        Text(
                            text = annotatedString,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.White,
                            modifier = modifier
                                .offset(x = (50).dp, y = (0).dp),
                            textAlign = TextAlign.Center
                        )

                        Text(
                            text = "Selamat Pagi",
                            fontWeight = FontWeight.Medium,
                            fontSize = 13.sp,
                            color = Color.White,
                            modifier = modifier
                                .offset(x = (50).dp, y = (0).dp),
                            textAlign = TextAlign.Center
                        )

                        var text by rememberSaveable { mutableStateOf("") }
                        TextField(
                            value = "Cari Diskusi, Riwayat Diskusi, ...   ", onValueChange = {},
                            trailingIcon = {
                                Image(
                                    painter = painterResource(id = R.drawable.search_icon),
                                    contentDescription = null,
                                    modifier = modifier
                                        .offset(x = (-5).dp, y = (0).dp)
                                        .width(35.dp)
                                        .padding(end = 6.dp)
                                )
                            },

                            colors = TextFieldDefaults.textFieldColors(
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                cursorColor = Color.Black,
                            ),

                            modifier = Modifier
                                .padding(top = 25.dp)
                                .padding(start = 15.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .background(color = Color.White),

//                            placeholder = {
//                                Text("Cari Diskusi, Riwayat Diskusi, ...   ")
//                            }

                        )
                    }

                    Image(
                        painter = painterResource(id = R.drawable.notif_icon),
                        contentDescription = null,
                        modifier = modifier
                            .offset(x = (-2).dp, y = (2).dp)
                            .width(40.dp),
                        contentScale = ContentScale.FillWidth
                    )
                }
            }
        }

        // ===================================  Isi  ===================================
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(430.dp)
                .offset(x = (0).dp, y = (-15).dp)
//                .background(color = Color.Gray)
        ) {
            Column {
                Text(
                    text = "Forum Diskusi",
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    color = BlueGradient,
                    modifier = modifier
                        .offset(x = (20).dp, y = (0).dp),
                    textAlign = TextAlign.Center
                )

                Image(
                    painter = painterResource(id = R.drawable.bg_b__topik),
                    contentDescription = null,
                    modifier = modifier
                        .offset(x = (20).dp, y = (10).dp)
                        .width(408.dp),
                    contentScale = ContentScale.FillWidth
                )
            }

            Box(
                modifier = modifier
                    .width(408.dp)
                    .height(339.dp)
                    .offset(x = (20).dp, y = (43).dp)
//                    .background(color = Color.Gray)
            ) {
                Row {
                    Column {
                        Text(
                            text = "Berdasarkan Topik",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = BlueGradient,
                            modifier = modifier
                                .offset(x = (20).dp, y = (15).dp),
                            textAlign = TextAlign.Center
                        )

                        Box(
                            modifier = Modifier
                                .offset(x = (15).dp, y = (25).dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.topik_1),
                                contentDescription = null,
                                modifier = modifier
                                    .offset(x = (0).dp, y = (0).dp)
                                    .width(180.dp),
                                contentScale = ContentScale.FillWidth
                            )

                            Button(
                                modifier = Modifier
                                    .height(80.dp)
                                    .width(170.5.dp)
                                    .offset(x = (5).dp, y = (4).dp),
                                shape = RoundedCornerShape(10.dp),
                                enabled = true,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = BlueGradient
                                ),
                                onClick = { }
                            ) {
                                Text(
                                    text = "TIPS & TRIK\n" +
                                            " MERAWAT",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .offset(x = (15).dp, y = (30).dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.topik_3),
                                contentDescription = null,
                                modifier = modifier
                                    .offset(x = (0).dp, y = (0).dp)
                                    .width(180.dp),
                                contentScale = ContentScale.FillWidth
                            )

                            Button(
                                modifier = Modifier
                                    .height(80.dp)
                                    .width(170.5.dp)
                                    .offset(x = (5).dp, y = (4).dp),
                                shape = RoundedCornerShape(10.dp),
                                enabled = true,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = BlueGradient
                                ),
                                onClick = { }
                            ) {
                                Text(
                                    text = "KONTROL EMOSI\n" +
                                            "    DAN STRESS",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .offset(x = (15).dp, y = (35).dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.topik_5),
                                contentDescription = null,
                                modifier = modifier
                                    .offset(x = (0).dp, y = (0).dp)
                                    .width(180.dp),
                                contentScale = ContentScale.FillWidth
                            )

                            Button(
                                modifier = Modifier
                                    .height(80.dp)
                                    .width(170.5.dp)
                                    .offset(x = (5).dp, y = (4).dp),
                                shape = RoundedCornerShape(10.dp),
                                enabled = true,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = BlueGradient
                                ),
                                onClick = { }
                            ) {
                                Text(
                                    text = "NUTRISI DAN\n" +
                                            " KESEHATAN",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }

                    Column {
                        Box(
                            modifier = Modifier
                                .offset(x = (32).dp, y = (49).dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.topik_2),
                                contentDescription = null,
                                modifier = modifier
                                    .offset(x = (0).dp, y = (0).dp)
                                    .width(180.dp),
                                contentScale = ContentScale.FillWidth
                            )

                            Button(
                                modifier = Modifier
                                    .height(80.dp)
                                    .width(170.5.dp)
                                    .offset(x = (5).dp, y = (4).dp),
                                shape = RoundedCornerShape(10.dp),
                                enabled = true,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = BlueGradient
                                ),
                                onClick = {navController.navigate("forum_page_2")}
                            ) {
                                Text(
                                    text = "ORANG\n" +
                                            "HILANG",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .offset(x = (32).dp, y = (54).dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.topik_4),
                                contentDescription = null,
                                modifier = modifier
                                    .offset(x = (0).dp, y = (0).dp)
                                    .width(180.dp),
                                contentScale = ContentScale.FillWidth
                            )

                            Button(
                                modifier = Modifier
                                    .height(80.dp)
                                    .width(170.5.dp)
                                    .offset(x = (5).dp, y = (4).dp),
                                shape = RoundedCornerShape(10.dp),
                                enabled = true,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = BlueGradient
                                ),
                                onClick = { }
                            ) {
                                Text(
                                    text = "AKTIVITAS\n" +
                                            "   HARIAN",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .offset(x = (32).dp, y = (59).dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.topik_6),
                                contentDescription = null,
                                modifier = modifier
                                    .offset(x = (0).dp, y = (0).dp)
                                    .width(180.dp),
                                contentScale = ContentScale.FillWidth
                            )

                            Button(
                                modifier = Modifier
                                    .height(80.dp)
                                    .width(170.5.dp)
                                    .offset(x = (5).dp, y = (4).dp),
                                shape = RoundedCornerShape(10.dp),
                                enabled = true,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = BlueGradient
                                ),
                                onClick = { }
                            ) {
                                Text(
                                    text = "    TOPIK BARU\n" +
                                            "SEGERA HADIR...",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(245.dp)
                .offset(x = (0).dp, y = (-20).dp)
//                .background(color = Color.Green)
        ) {
            Column {
                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(35.dp)
//                        .background(color = Color.Black)
                ) {
                    Text(
                        text = "Hubungi Bila Menemukan",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = BlueGradient,
                        modifier = modifier
                            .offset(x = (20).dp, y = (0).dp),
                        textAlign = TextAlign.Center
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
//                        .background(color = Color.Blue)
                        .padding(start = 20.dp)
                ) {
                    Box(
                        modifier = modifier
                            .width(125.dp)
                            .height(193.dp)
                            .clip(RoundedCornerShape(10.dp))
//                            .background(color = GrayWhite)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.isi_hub__bm),
                            contentDescription = null,
                            modifier = modifier
                                .padding(start = 0.dp)
                                .width(125.dp),
                            contentScale = ContentScale.FillWidth
                        )

                        Box(
                            modifier = modifier
                                .width(125.dp)
                                .height(193.dp)
                                .padding(start = 0.dp)
                                .clip(RoundedCornerShape(10.dp))
//                                .background(color = GrayWhite)
                        ) {
                            Column {
                                Text(
                                    text = "Now Printing...",
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 12.sp,
                                    color = BlueGradient,
                                    modifier = modifier
                                        .offset(x = (18).dp, y = (55).dp),
                                    textAlign = TextAlign.Center
                                )

                                Row(
                                    modifier = modifier
                                        .padding(start = 7.dp, top = 108.dp)
                                        .width(110.dp)
                                        .height(34.dp)
//                                        .background(color = Color.Green)
//                                        .offset(x = (10).dp, y = (108).dp)
                                ) {
                                    Box(
                                        modifier = modifier
                                            .width(28.dp)
                                            .height(28.dp)
                                            .padding(start = 0.dp)
//                                            .clip(RoundedCornerShape(10.dp))
//                                            .background(color = GrayWhite)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.bg_profil),
                                            contentDescription = null,
                                            modifier = modifier
                                                .padding(start = 0.dp, top = 0.dp)
//                                            .offset(x = (0).dp, y = (0).dp)
                                                .width(28.dp),
//                                        contentScale = ContentScale.FillWidth
                                        )
                                    }

                                    Column(
                                        modifier = modifier
                                            .padding(start = 6.dp)
//                                            .background(color = Color.White)
                                            .width(76.dp)
                                            .height(40.dp),
                                        verticalArrangement = Arrangement.Top,
                                    ) {
                                        Box(
                                            modifier = modifier
                                                .width(76.dp)
                                                .height(17.dp)
                                                .padding(start = 0.dp)
//                                            .background(color = Color.Black)
                                        ) {
                                            Text(
                                                text = "A****a P****i",
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 10.sp,
                                                color = BlueGradient,
                                                modifier = modifier
                                                    .padding(horizontal = 0.dp)
                                                    .offset(x = (0).dp, y = (-5).dp),
                                                textAlign = TextAlign.Center
                                            )
                                        }

                                        Box(
                                            modifier = modifier
                                                .width(76.dp)
                                                .height(20.dp)
//                                                .padding(top = 1.dp)
//                                                .background(color = Color.Yellow)
                                        ) {
                                            Text(
                                                text = "Topik > Orang Hilang",
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 5.sp,
                                                color = BlueGradient,
                                                modifier = modifier
                                                    .padding(horizontal = 0.dp)
                                                    .offset(x = (0).dp, y = (-10).dp),
                                                textAlign = TextAlign.Center
                                            )
                                        }

                                    }
                                }

                                Row(
                                    modifier = modifier
                                        .offset(x = (2).dp, y = (0).dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .height(26.dp)
                                            .width(38.dp)
//                                        .background(color = Color.Black)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.chat_icon),
                                            contentDescription = null,
                                            modifier = modifier
                                                .offset(x = (12.5).dp, y = (6).dp)
                                                .width(13.dp),
                                            contentScale = ContentScale.FillWidth
                                        )

                                        Button(
                                            modifier = Modifier
                                                .height(25.dp)
                                                .width(38.dp),
                                            shape = RoundedCornerShape(8.dp),
                                            enabled = true,
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color.Transparent,
                                                contentColor = BlueGradient
                                            ),
                                            onClick = { }
                                        ) {
                                        }

                                    }

                                    Box(
                                        modifier = Modifier
                                            .height(26.dp)
                                            .width(45.dp)
//                                        .background(color = Color.Black)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.image_icon),
                                            contentDescription = null,
                                            modifier = modifier
                                                .offset(x = (15.5).dp, y = (6).dp)
                                                .width(12.5.dp),
                                            contentScale = ContentScale.FillWidth
                                        )

                                        Button(
                                            modifier = Modifier
                                                .height(25.dp)
                                                .width(43.dp),
                                            shape = RoundedCornerShape(5.dp),
                                            enabled = true,
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color.Transparent,
                                                contentColor = BlueGradient
                                            ),
                                            onClick = { }
                                        ) {
                                        }

                                    }

                                    Box(
                                        modifier = Modifier
                                            .height(26.dp)
                                            .width(38.dp)
//                                        .background(color = Color.Black)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.maps_icon),
                                            contentDescription = null,
                                            modifier = modifier
                                                .offset(x = (10.5).dp, y = (6).dp)
                                                .width(13.dp),
                                            contentScale = ContentScale.FillWidth
                                        )

                                        Button(
                                            modifier = Modifier
                                                .offset(x = (-2).dp)
                                                .height(25.dp)
                                                .width(38.dp),
                                            shape = RoundedCornerShape(8.dp),
                                            enabled = true,
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color.Transparent,
                                                contentColor = BlueGradient
                                            ),
                                            onClick = { }
                                        ) {
                                        }

                                    }
                                }
                            }
                        }
                    }

                    Box(
                        modifier = modifier
                            .width(125.dp)
                            .height(193.dp)
                            .offset(x = (20).dp, y = (0).dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = GrayWhite)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.isi_hub__bm),
                            contentDescription = null,
                            modifier = modifier
                                .padding(start = 0.dp)
                                .width(125.dp),
                            contentScale = ContentScale.FillWidth
                        )

                        Box(
                            modifier = modifier
                                .width(125.dp)
                                .height(193.dp)
                                .padding(start = 0.dp)
                                .clip(RoundedCornerShape(10.dp))
//                                .background(color = GrayWhite)
                        ) {
                            Column {
                                Text(
                                    text = "Now Printing...",
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 12.sp,
                                    color = BlueGradient,
                                    modifier = modifier
                                        .offset(x = (18).dp, y = (55).dp),
                                    textAlign = TextAlign.Center
                                )

                                Row(
                                    modifier = modifier
                                        .padding(start = 7.dp, top = 108.dp)
                                        .width(110.dp)
                                        .height(34.dp)
//                                        .background(color = Color.Green)
//                                        .offset(x = (10).dp, y = (108).dp)
                                ) {
                                    Box(
                                        modifier = modifier
                                            .width(28.dp)
                                            .height(28.dp)
                                            .padding(start = 0.dp)
//                                            .clip(RoundedCornerShape(10.dp))
//                                            .background(color = GrayWhite)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.bg_profil),
                                            contentDescription = null,
                                            modifier = modifier
                                                .padding(start = 0.dp, top = 0.dp)
//                                            .offset(x = (0).dp, y = (0).dp)
                                                .width(28.dp),
//                                        contentScale = ContentScale.FillWidth
                                        )
                                    }

                                    Column(
                                        modifier = modifier
                                            .padding(start = 6.dp)
//                                            .background(color = Color.White)
                                            .width(76.dp)
                                            .height(40.dp),
                                        verticalArrangement = Arrangement.Top,
                                    ) {
                                        Box(
                                            modifier = modifier
                                                .width(76.dp)
                                                .height(17.dp)
                                                .padding(start = 0.dp)
//                                            .background(color = Color.Black)
                                        ) {
                                            Text(
                                                text = "A****a P****i",
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 10.sp,
                                                color = BlueGradient,
                                                modifier = modifier
                                                    .padding(horizontal = 0.dp)
                                                    .offset(x = (0).dp, y = (-5).dp),
                                                textAlign = TextAlign.Center
                                            )
                                        }

                                        Box(
                                            modifier = modifier
                                                .width(76.dp)
                                                .height(20.dp)
//                                                .padding(top = 1.dp)
//                                                .background(color = Color.Yellow)
                                        ) {
                                            Text(
                                                text = "Topik > Orang Hilang",
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 5.sp,
                                                color = BlueGradient,
                                                modifier = modifier
                                                    .padding(horizontal = 0.dp)
                                                    .offset(x = (0).dp, y = (-10).dp),
                                                textAlign = TextAlign.Center
                                            )
                                        }

                                    }
                                }

                                Row(
                                    modifier = modifier
                                        .offset(x = (2).dp, y = (0).dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .height(26.dp)
                                            .width(38.dp)
//                                        .background(color = Color.Black)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.chat_icon),
                                            contentDescription = null,
                                            modifier = modifier
                                                .offset(x = (12.5).dp, y = (6).dp)
                                                .width(13.dp),
                                            contentScale = ContentScale.FillWidth
                                        )

                                        Button(
                                            modifier = Modifier
                                                .height(25.dp)
                                                .width(38.dp),
                                            shape = RoundedCornerShape(8.dp),
                                            enabled = true,
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color.Transparent,
                                                contentColor = BlueGradient
                                            ),
                                            onClick = { }
                                        ) {
                                        }

                                    }

                                    Box(
                                        modifier = Modifier
                                            .height(26.dp)
                                            .width(45.dp)
//                                        .background(color = Color.Black)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.image_icon),
                                            contentDescription = null,
                                            modifier = modifier
                                                .offset(x = (15.5).dp, y = (6).dp)
                                                .width(12.5.dp),
                                            contentScale = ContentScale.FillWidth
                                        )

                                        Button(
                                            modifier = Modifier
                                                .height(25.dp)
                                                .width(43.dp),
                                            shape = RoundedCornerShape(5.dp),
                                            enabled = true,
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color.Transparent,
                                                contentColor = BlueGradient
                                            ),
                                            onClick = { }
                                        ) {
                                        }

                                    }

                                    Box(
                                        modifier = Modifier
                                            .height(26.dp)
                                            .width(38.dp)
//                                        .background(color = Color.Black)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.maps_icon),
                                            contentDescription = null,
                                            modifier = modifier
                                                .offset(x = (10.5).dp, y = (6).dp)
                                                .width(13.dp),
                                            contentScale = ContentScale.FillWidth
                                        )

                                        Button(
                                            modifier = Modifier
                                                .offset(x = (-2).dp)
                                                .height(25.dp)
                                                .width(38.dp),
                                            shape = RoundedCornerShape(8.dp),
                                            enabled = true,
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color.Transparent,
                                                contentColor = BlueGradient
                                            ),
                                            onClick = { }
                                        ) {
                                        }

                                    }
                                }
                            }
                        }
                    }

                    Box(
                        modifier = modifier
                            .width(125.dp)
                            .height(193.dp)
                            .offset(x = (40).dp, y = (0).dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = GrayWhite)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.isi_hub__bm),
                            contentDescription = null,
                            modifier = modifier
                                .padding(start = 0.dp)
                                .width(125.dp),
                            contentScale = ContentScale.FillWidth
                        )

                        Box(
                            modifier = modifier
                                .width(125.dp)
                                .height(193.dp)
                                .padding(start = 0.dp)
                                .clip(RoundedCornerShape(10.dp))
//                                .background(color = GrayWhite)
                        ) {
                            Column {
                                Text(
                                    text = "Now Printing...",
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 12.sp,
                                    color = BlueGradient,
                                    modifier = modifier
                                        .offset(x = (18).dp, y = (55).dp),
                                    textAlign = TextAlign.Center
                                )

                                Row(
                                    modifier = modifier
                                        .padding(start = 7.dp, top = 108.dp)
                                        .width(110.dp)
                                        .height(34.dp)
//                                        .background(color = Color.Green)
//                                        .offset(x = (10).dp, y = (108).dp)
                                ) {
                                    Box(
                                        modifier = modifier
                                            .width(28.dp)
                                            .height(28.dp)
                                            .padding(start = 0.dp)
//                                            .clip(RoundedCornerShape(10.dp))
//                                            .background(color = GrayWhite)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.bg_profil),
                                            contentDescription = null,
                                            modifier = modifier
                                                .padding(start = 0.dp, top = 0.dp)
//                                            .offset(x = (0).dp, y = (0).dp)
                                                .width(28.dp),
//                                        contentScale = ContentScale.FillWidth
                                        )
                                    }

                                    Column(
                                        modifier = modifier
                                            .padding(start = 6.dp)
//                                            .background(color = Color.White)
                                            .width(76.dp)
                                            .height(40.dp),
                                        verticalArrangement = Arrangement.Top,
                                    ) {
                                        Box(
                                            modifier = modifier
                                                .width(76.dp)
                                                .height(17.dp)
                                                .padding(start = 0.dp)
//                                            .background(color = Color.Black)
                                        ) {
                                            Text(
                                                text = "A****a P****i",
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 10.sp,
                                                color = BlueGradient,
                                                modifier = modifier
                                                    .padding(horizontal = 0.dp)
                                                    .offset(x = (0).dp, y = (-5).dp),
                                                textAlign = TextAlign.Center
                                            )
                                        }

                                        Box(
                                            modifier = modifier
                                                .width(76.dp)
                                                .height(20.dp)
//                                                .padding(top = 1.dp)
//                                                .background(color = Color.Yellow)
                                        ) {
                                            Text(
                                                text = "Topik > Orang Hilang",
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 5.sp,
                                                color = BlueGradient,
                                                modifier = modifier
                                                    .padding(horizontal = 0.dp)
                                                    .offset(x = (0).dp, y = (-10).dp),
                                                textAlign = TextAlign.Center
                                            )
                                        }

                                    }
                                }

                                Row(
                                    modifier = modifier
                                        .offset(x = (2).dp, y = (0).dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .height(26.dp)
                                            .width(38.dp)
//                                        .background(color = Color.Black)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.chat_icon),
                                            contentDescription = null,
                                            modifier = modifier
                                                .offset(x = (12.5).dp, y = (6).dp)
                                                .width(13.dp),
                                            contentScale = ContentScale.FillWidth
                                        )

                                        Button(
                                            modifier = Modifier
                                                .height(25.dp)
                                                .width(38.dp),
                                            shape = RoundedCornerShape(8.dp),
                                            enabled = true,
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color.Transparent,
                                                contentColor = BlueGradient
                                            ),
                                            onClick = { }
                                        ) {
                                        }

                                    }

                                    Box(
                                        modifier = Modifier
                                            .height(26.dp)
                                            .width(45.dp)
//                                        .background(color = Color.Black)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.image_icon),
                                            contentDescription = null,
                                            modifier = modifier
                                                .offset(x = (15.5).dp, y = (6).dp)
                                                .width(12.5.dp),
                                            contentScale = ContentScale.FillWidth
                                        )

                                        Button(
                                            modifier = Modifier
                                                .height(25.dp)
                                                .width(43.dp),
                                            shape = RoundedCornerShape(5.dp),
                                            enabled = true,
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color.Transparent,
                                                contentColor = BlueGradient
                                            ),
                                            onClick = { }
                                        ) {
                                        }

                                    }

                                    Box(
                                        modifier = Modifier
                                            .height(26.dp)
                                            .width(38.dp)
//                                        .background(color = Color.Black)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.maps_icon),
                                            contentDescription = null,
                                            modifier = modifier
                                                .offset(x = (10.5).dp, y = (6).dp)
                                                .width(13.dp),
                                            contentScale = ContentScale.FillWidth
                                        )

                                        Button(
                                            modifier = Modifier
                                                .offset(x = (-2).dp)
                                                .height(25.dp)
                                                .width(38.dp),
                                            shape = RoundedCornerShape(8.dp),
                                            enabled = true,
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color.Transparent,
                                                contentColor = BlueGradient
                                            ),
                                            onClick = { }
                                        ) {
                                        }

                                    }
                                }
                            }
                        }
                    }
                }

            }
        }

        // ===================================  Navbar Menu ===================================
        Box(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight(Alignment.Top)
                .offset(x = (0).dp, y = (0).dp)
                .background(color = Color.Black)
        ) {
            Box(
                modifier = modifier
                    .width(448.dp)
                    .wrapContentHeight(Alignment.Top)
                    .offset(x = (0).dp, y = (1).dp)
                    .background(color = Color.Gray)
                    .clip(RoundedCornerShape(20.dp))
            ) {
//            Image(
//                painter = painterResource(id = R.drawable.bg_bar),
//                contentDescription = null,
//                modifier = modifier
//                    .offset(x = (0).dp, y = (0).dp)
//                    .fillMaxWidth()
//                    .height(IntrinsicSize.Max),
//                contentScale = ContentScale.Crop
//                )

                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .offset(x = (0).dp, y = (2).dp)
//                .background(color = Color.Blue)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Button(
                            modifier = Modifier
                                .height(100.dp)
                                .width(112.dp),
                            shape = RoundedCornerShape(topStart = 10.dp, topEnd = 0.dp),
                            enabled = true,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White,
                                contentColor = BlueGradient
                            ),
                            onClick = { }
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally // Center content horizontally
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.beranda_icon),
                                    contentDescription = "Home Icon",
                                    modifier = Modifier.size(37.dp)
                                )
//                            Spacer(modifier = Modifier.height(1.5.dp)) // Add spacing between icon and text
                                Text(text = "Beranda")
                            }
                        }

                        Button(
                            modifier = Modifier
                                .height(95.dp)
                                .width(112.dp),
                            shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp),
                            enabled = true,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White,
                                contentColor = BlueGradient
                            ),
                            onClick = { }
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally // Center content horizontally
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.aktivitas_icon),
                                    contentDescription = "Aktivitas Icon",
                                    modifier = Modifier.size(31.dp)
                                )
//                            Spacer(modifier = Modifier.height(3.dp)) // Add spacing between icon and text
                                Text(text = "Aktivitas", modifier = Modifier.offset(y = (2.5).dp))
                            }
                        }

                        Button(
                            modifier = Modifier
                                .height(100.dp)
                                .width(112.dp),
                            shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp),
                            enabled = true,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White,
                                contentColor = BlueGradient,
                            ),
                            onClick = { }
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally // Center content horizontally
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.forum_active_icon),
                                    contentDescription = "Home Forum",
                                    modifier = Modifier.size(35.dp)
                                        .offset(x = (0).dp, y = (-4.5).dp),
                                    tint = Color.Unspecified
                                )
//                            Spacer(modifier = Modifier.height(0.dp)) // Add spacing between icon and text
                                Text(text = "Forum", modifier = Modifier.offset(y = (1).dp))
                            }
                        }

                        Button(
                            modifier = Modifier
                                .height(100.dp)
                                .width(112.dp),
                            shape = RoundedCornerShape(topStart = 0.dp, topEnd = 10.dp),
                            enabled = true,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White,
                                contentColor = BlueGradient
                            ),
                            onClick = { }
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally // Center content horizontally
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.profil_icon),
                                    contentDescription = "Home Profil",
                                    modifier = Modifier.size(37.dp).offset(y = (-3.5).dp)
                                )
//                            Spacer(modifier = Modifier.height(2.dp)) // Add spacing between icon and text
                                Text(text = "Profil")
                            }
                        }
                    }
                }
            }
        }
    }
}