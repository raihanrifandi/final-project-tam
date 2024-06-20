@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.forumpage_neuternal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.forumpage_neuternal.ui.theme.ForumPageNeuternalTheme
import com.example.forumpage_neuternal.ui.theme.GrayWhite

@Composable
fun ForumPage2(navController: NavController, modifier: Modifier) {
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
                .height(150.dp)
//                .background(color = Color.Yellow)
        ) {
            Image(
                painter = painterResource(id = R.drawable.navbar_v2),
                contentDescription = null,
                modifier = modifier,
                contentScale = ContentScale.FillWidth
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(x = (0).dp, y = (40).dp)
                    .height(60.dp)
//                .background(color = Color.Black)
            ) {
                Row {
                    Box(
                        modifier = modifier
                            .width(55.dp)
                            .height(55.dp)
                            .offset(x = (5).dp, y = (0).dp)
//                            .background(color = Color.Gray)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.back_icon),
                            contentDescription = null,
                            modifier = modifier
                                .offset(x = (15).dp, y = (0).dp)
                                .width(55.dp),
                            contentScale = ContentScale.FillWidth
                        )

                        Button(
                            modifier = Modifier
                                .height(46.dp)
                                .width(46.dp)
                                .offset(x = (15).dp, y = (0).dp),
                            shape = RoundedCornerShape(30.dp),
                            enabled = true,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = BlueGradient
                            ),
                            onClick = {navController.navigate("forum_page1")}
                        ) {
                        }
                    }

                    var text by remember { mutableStateOf("") }
                    TextField(
                        value = text, onValueChange = { newText -> text = newText },
                        trailingIcon = {
                            Image(
                                painter = painterResource(id = R.drawable.search_icon),
                                contentDescription = null,
                                modifier = modifier
                                    .offset(x = (-5).dp, y = (0).dp)
                                    .width(28.dp)
                                    .padding(end = 6.dp)
                            )
                        },

                        colors = TextFieldDefaults.textFieldColors(
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            cursorColor = Color.Black,
                        ),

                        modifier = Modifier
                            .padding(start = 30.dp, top = 2.dp)
                            .height(40.dp)
                            .clip(RoundedCornerShape(40.dp))
                            .background(color = Color.White))

                    Image(
                        painter = painterResource(id = R.drawable.notif_icon),
                        contentDescription = null,
                        modifier = modifier
                            .offset(x = (19).dp, y = (2).dp)
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
                .height(405.dp)
                .offset(x = (0).dp, y = (0).dp)
//                .background(color = Color.Gray)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg_topik_2),
                contentDescription = null,
                modifier = modifier
                    .offset(x = (0).dp, y = (0).dp)
                    .width(448.dp),
                contentScale = ContentScale.FillWidth
            )

            Column {
                Text(
                    text = "Orang Hilang",
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    color = Color.White,
                    modifier = modifier
                        .offset(x = (20).dp, y = (20).dp),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Topik > Orang Hilang",
                    fontWeight = FontWeight.Medium,
                    fontSize = 13.sp,
                    color = Color.White,
                    modifier = modifier
                        .offset(x = (20).dp, y = (23).dp),
                    textAlign = TextAlign.Center
                )
            }

            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(330.dp)
                    .offset(x = (0).dp, y = (100).dp)
//                    .background(color = Color.Yellow)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bg_b__topik_2),
                    contentDescription = null,
                    modifier = modifier
                        .offset(x = (0).dp, y = (0).dp)
                        .width(448.dp),
                    contentScale = ContentScale.FillWidth
                )

                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(245.dp)
                        .offset(x = (0).dp, y = (20).dp)
//                        .background(color = Color.Green)
                ) {
                    Column {
                        Box(
                            modifier = modifier
                                .fillMaxWidth()
                                .height(35.dp)
//                        .background(color = Color.Black)
                        ) {
                            Text(
                                text = "Diskusi Populer",
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
                                    painter = painterResource(id = R.drawable.isi_hub__bm_2),
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
                                            text = "Mohon Bantuannya!!!\n" +
                                                    "Sunarboy, umur 76.\n" +
                                                    "Ciri-ciri:\n" +
                                                    "Pakaian, baju kotak-\n" +
                                                    "kotak hijau cel...",
                                            fontWeight = FontWeight.Medium,
                                            fontSize = 9.sp,
                                            color = BlueGradient,
                                            modifier = modifier
                                                .offset(x = (15).dp, y = (8).dp),
                                            textAlign = TextAlign.Left
                                        )

                                        Row(
                                            modifier = modifier
                                                .padding(start = 7.dp, top = 12.dp)
                                                .width(110.dp)
                                                .height(36.dp)
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
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically // Align icon and text vertically
                                                ) {
                                                    Image(
                                                        painter = painterResource(id = R.drawable.chat_icon),
                                                        contentDescription = null,
                                                        modifier = Modifier
                                                            .padding(start = 6.dp, top = 0.2.dp)
//                                                            .offset(x = (15.5).dp, y = (6).dp)
                                                            .size(13.dp),
                                                        contentScale = ContentScale.FillWidth
                                                    )
                                                    Spacer(modifier = Modifier.width(3.dp)) // Add spacing between icon and text
                                                    Text(
                                                        text = "32", // Your text here
                                                        fontSize = 8.sp,
                                                        modifier = Modifier
                                                            .padding(top = 0.2.dp),// Adjust font size as needed
                                                        color = BlueGradient
                                                    )
                                                }

                                                Button(
                                                    modifier = Modifier
                                                        .height(25.dp)
                                                        .width(38.dp), // Adjust width as needed
                                                    shape = RoundedCornerShape(
                                                        topStart = 8.dp,
                                                        bottomStart = 8.dp,
                                                        topEnd = 1.dp,
                                                        bottomEnd = 1.dp
                                                    ),
                                                    enabled = true,
                                                    colors =ButtonDefaults.buttonColors(
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
                                                    .width(83.dp)
//                                        .background(color = Color.Black)
                                            ) {
                                                Text(
                                                    text = "Balas disini...", // Your text here
                                                    fontSize = 8.sp,
                                                    modifier = Modifier
                                                        .padding(start = 7.dp, top = 0.2.dp),// Adjust font size as needed
                                                    color = BlueGradient
                                                )

                                                Button(
                                                    modifier = Modifier
                                                        .height(25.dp)
                                                        .width(83.dp),
                                                    shape = RoundedCornerShape(
                                                        topStart = 1.dp,
                                                        bottomStart = 1.dp,
                                                        topEnd = 8.dp,
                                                        bottomEnd = 8.dp
                                                    ),
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
//                            .background(color = GrayWhite)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.isi_hub__bm_2),
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
                                            text = "Mohon Bantuannya!!!\n" +
                                                    "Sunarboy, umur 76.\n" +
                                                    "Ciri-ciri:\n" +
                                                    "Pakaian, baju kotak-\n" +
                                                    "kotak hijau cel...",
                                            fontWeight = FontWeight.Medium,
                                            fontSize = 9.sp,
                                            color = BlueGradient,
                                            modifier = modifier
                                                .offset(x = (15).dp, y = (8).dp),
                                            textAlign = TextAlign.Left
                                        )

                                        Row(
                                            modifier = modifier
                                                .padding(start = 7.dp, top = 12.dp)
                                                .width(110.dp)
                                                .height(36.dp)
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
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically // Align icon and text vertically
                                                ) {
                                                    Image(
                                                        painter = painterResource(id = R.drawable.chat_icon),
                                                        contentDescription = null,
                                                        modifier = Modifier
                                                            .padding(start = 6.dp, top = 0.2.dp)
//                                                            .offset(x = (15.5).dp, y = (6).dp)
                                                            .size(13.dp),
                                                        contentScale = ContentScale.FillWidth
                                                    )
                                                    Spacer(modifier = Modifier.width(3.dp)) // Add spacing between icon and text
                                                    Text(
                                                        text = "32", // Your text here
                                                        fontSize = 8.sp,
                                                        modifier = Modifier
                                                            .padding(top = 0.2.dp),// Adjust font size as needed
                                                        color = BlueGradient
                                                    )
                                                }

                                                Button(
                                                    modifier = Modifier
                                                        .height(25.dp)
                                                        .width(38.dp), // Adjust width as needed
                                                    shape = RoundedCornerShape(
                                                        topStart = 8.dp,
                                                        bottomStart = 8.dp,
                                                        topEnd = 1.dp,
                                                        bottomEnd = 1.dp
                                                    ),
                                                    enabled = true,
                                                    colors =ButtonDefaults.buttonColors(
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
                                                    .width(83.dp)
//                                        .background(color = Color.Black)
                                            ) {
                                                Text(
                                                    text = "Balas disini...", // Your text here
                                                    fontSize = 8.sp,
                                                    modifier = Modifier
                                                        .padding(start = 7.dp, top = 0.2.dp),// Adjust font size as needed
                                                    color = BlueGradient
                                                )

                                                Button(
                                                    modifier = Modifier
                                                        .height(25.dp)
                                                        .width(83.dp),
                                                    shape = RoundedCornerShape(
                                                        topStart = 1.dp,
                                                        bottomStart = 1.dp,
                                                        topEnd = 8.dp,
                                                        bottomEnd = 8.dp
                                                    ),
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
//                            .background(color = GrayWhite)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.isi_hub__bm_2),
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
                                            text = "Mohon Bantuannya!!!\n" +
                                                    "Sunarboy, umur 76.\n" +
                                                    "Ciri-ciri:\n" +
                                                    "Pakaian, baju kotak-\n" +
                                                    "kotak hijau cel...",
                                            fontWeight = FontWeight.Medium,
                                            fontSize = 9.sp,
                                            color = BlueGradient,
                                            modifier = modifier
                                                .offset(x = (15).dp, y = (8).dp),
                                            textAlign = TextAlign.Left
                                        )

                                        Row(
                                            modifier = modifier
                                                .padding(start = 7.dp, top = 12.dp)
                                                .width(110.dp)
                                                .height(36.dp)
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
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically // Align icon and text vertically
                                                ) {
                                                    Image(
                                                        painter = painterResource(id = R.drawable.chat_icon),
                                                        contentDescription = null,
                                                        modifier = Modifier
                                                            .padding(start = 6.dp, top = 0.2.dp)
//                                                            .offset(x = (15.5).dp, y = (6).dp)
                                                            .size(13.dp),
                                                        contentScale = ContentScale.FillWidth
                                                    )
                                                    Spacer(modifier = Modifier.width(3.dp)) // Add spacing between icon and text
                                                    Text(
                                                        text = "32", // Your text here
                                                        fontSize = 8.sp,
                                                        modifier = Modifier
                                                            .padding(top = 0.2.dp),// Adjust font size as needed
                                                        color = BlueGradient
                                                    )
                                                }

                                                Button(
                                                    modifier = Modifier
                                                        .height(25.dp)
                                                        .width(38.dp), // Adjust width as needed
                                                    shape = RoundedCornerShape(
                                                        topStart = 8.dp,
                                                        bottomStart = 8.dp,
                                                        topEnd = 1.dp,
                                                        bottomEnd = 1.dp
                                                    ),
                                                    enabled = true,
                                                    colors =ButtonDefaults.buttonColors(
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
                                                    .width(83.dp)
//                                        .background(color = Color.Black)
                                            ) {
                                                Text(
                                                    text = "Balas disini...", // Your text here
                                                    fontSize = 8.sp,
                                                    modifier = Modifier
                                                        .padding(start = 7.dp, top = 0.2.dp),// Adjust font size as needed
                                                    color = BlueGradient
                                                )

                                                Button(
                                                    modifier = Modifier
                                                        .height(25.dp)
                                                        .width(83.dp),
                                                    shape = RoundedCornerShape(
                                                        topStart = 1.dp,
                                                        bottomStart = 1.dp,
                                                        topEnd = 8.dp,
                                                        bottomEnd = 8.dp
                                                    ),
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

            }
        }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(330.dp)
                .offset(x = (0).dp, y = (0).dp)
//                .background(color = Color.Green)
        ) {
            Column {

                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(30.dp)
                        .offset(x = (0).dp, y = (0).dp)
//                        .background(color = Color.Green)
                ) {
                    Text(
                        text = "Diskusi Terbaru",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = BlueGradient,
                        modifier = modifier
                            .offset(x = (20).dp, y = (0).dp),
                        textAlign = TextAlign.Center
                    )
                }

                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .offset(x = (0).dp, y = (0).dp)
//                        .background(color = Color.Yellow)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.tambah_diskusi),
                        contentDescription = null,
                        modifier = Modifier,
                        contentScale = ContentScale.FillWidth
                    )

                    Box(
                        modifier = modifier
                            .fillMaxWidth()
                            .height(65.dp)
                            .offset(x = (0).dp, y = (6).dp)
//                            .background(color = Color.Green)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically // Align icon and text vertically
                        ) {
                            Box(
                                modifier = modifier
                                    .width(40.dp)
                                    .height(40.dp)
                                    .offset(x = (20).dp, y = (12).dp)
//                                    .background(color = Color.Green)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.profil_navbar_icon),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(40.dp)
                                )
                            }

                            Box(
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(352.dp)
                                    .offset(x = (40).dp, y = (12).dp)
//                                    .background(color = Color.Cyan)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.kolom_tambah_diskusi),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(352.dp)
                                )

                            }

                        }
                    }

                    Box(
                        modifier = modifier
                            .fillMaxWidth()
                            .height(128.dp)
                            .offset(x = (0).dp, y = (72).dp)
                            .background(color = Color.Blue)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.diskusi),
                            contentDescription = null,
                            modifier = Modifier,
                            contentScale = ContentScale.FillWidth
                        )
                    }

                    Box(
                        modifier = modifier
                            .fillMaxWidth()
                            .height(128.dp)
                            .offset(x = (0).dp, y = (200).dp)
//                            .background(color = Color.Blue)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.balasan_diskusi),
                            contentDescription = null,
                            modifier = Modifier,
                            contentScale = ContentScale.FillWidth
                        )
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
                    .clip(RoundedCornerShape(0.dp))
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

