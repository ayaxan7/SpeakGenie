package com.ayaan.speakgenie.presentation.learnscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ayaan.speakgenie.presentation.navigation.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import speakgenie.composeapp.generated.resources.*

@Composable
fun LearnScreen(navController: NavController = rememberNavController()) {
    val toast = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(horizontal = 20.dp, vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Back arrow
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            navController.navigate(Screen.Home.route) {
                                popUpTo(Screen.Home.route) { inclusive = true }
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(Res.drawable.Back),
                        contentDescription = "Back Arrow",
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "AI Chatbot",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.weight(1f))

                // Empty space to balance the back button
                Spacer(modifier = Modifier.size(40.dp))
            }
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                // AI Avatar
                Box(
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.CenterHorizontally)
                        .clip(CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(Res.drawable.aiAvatar),
                        contentDescription = "AI Avatar",
                        modifier = Modifier
                            .size(160.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFDEB887))
                    )
                }

                Spacer(modifier = Modifier.height(40.dp))

                // AI Message bubble
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.aichat),
                            contentDescription = "AI Avatar",
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Box(
                        modifier = Modifier
                            .background(Color(0xFFF5F5F5), RoundedCornerShape(16.dp))
                            .padding(16.dp)
                    ) {
                        Column {
                            Text(
                                text = "Hello.👋 I'm Genie your AI Tutor",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.Black
                            )
                            Text(
                                text = "You can ask me any questions.",
                                fontSize = 16.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(top = 4.dp)
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Row {
                                Image(
                                    painter = painterResource(Res.drawable.voicegreen),
                                    contentDescription = "Sound Icon",
                                    modifier = Modifier
                                        .size(32.dp)
                                        .clip(CircleShape)
                                        .clickable { }
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                Image(
                                    painter = painterResource(Res.drawable.translate),
                                    contentDescription = "Translate Icon",
                                    modifier = Modifier
                                        .size(32.dp)
                                        .clip(CircleShape)
                                        .clickable { }
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // User message bubble
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color(0xFFB8E6B8), RoundedCornerShape(16.dp))
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Suggest me some cool idioms\nto talk with friends",
                            fontSize = 16.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Start
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // AI response message
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.aichat),
                            contentDescription = "AI Avatar",
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Box(
                        modifier = Modifier
                            .background(Color(0xFFF5F5F5), RoundedCornerShape(16.dp))
                            .padding(16.dp)
                    ) {
                        Column {
                            Text(
                                text = "Sure! Here are some cool and short idioms you can use while chatting with friends:",
                                fontSize = 16.sp,
                                color = Color.Black
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                Text("1. Spill the tea – Share the gossip", fontSize = 16.sp)
                                Text("2. Break a leg – Good luck!", fontSize = 16.sp)
                                Text("3. Piece of cake – Very easy", fontSize = 16.sp)
                                Text("4. Hit the sack – Go to sleep", fontSize = 16.sp)
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            Row {
                                Image(
                                    painter = painterResource(Res.drawable.voicegray),
                                    contentDescription = "Sound Icon",
                                    modifier = Modifier
                                        .size(32.dp)
                                        .clip(CircleShape)
                                        .clickable { }
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                Image(
                                    painter = painterResource(Res.drawable.translate),
                                    contentDescription = "Translate Icon",
                                    modifier = Modifier
                                        .size(32.dp)
                                        .clip(CircleShape)
                                        .clickable { }
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))

                // Bottom section with voice input
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (toast.value) {
                        Box(
                            modifier = Modifier
                                .background(Color(0xFF424242), RoundedCornerShape(24.dp))
                                .clickable { }
                                .padding(horizontal = 24.dp, vertical = 12.dp)
                        ) {
                            Text(
                                text = "Tap to Speak",
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Box(
                        modifier = Modifier
                            .size(75.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .clickable {
                                scope.launch {
                                    toast.value = true
                                    delay(1000)
                                    toast.value = false
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.mic),
                            contentDescription = "Microphone Icon",
                            modifier = Modifier.size(72.dp)
                        )
                    }
                }
            }
        }
    }
}