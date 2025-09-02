package com.ayaan.speakgenie.presentation.profilescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ayaan.speakgenie.presentation.navigation.components.BottomNavigationBar
import com.ayaan.speakgenie.presentation.profilescreen.components.ProfileOptionCard
import com.ayaan.speakgenie.presentation.profilescreen.components.ProfileStatCard
import com.ayaan.speakgenie.presentation.profilescreen.data.ProfileOption
import org.jetbrains.compose.resources.painterResource
import speakgenie.composeapp.generated.resources.Accuracy
import speakgenie.composeapp.generated.resources.Res
import speakgenie.composeapp.generated.resources.Time
import speakgenie.composeapp.generated.resources.XPPoints
import speakgenie.composeapp.generated.resources.avatar
import speakgenie.composeapp.generated.resources.dice
import speakgenie.composeapp.generated.resources.gift
import speakgenie.composeapp.generated.resources.lessonIcon
import speakgenie.composeapp.generated.resources.menu
import speakgenie.composeapp.generated.resources.profileCrown
import speakgenie.composeapp.generated.resources.smile
import speakgenie.composeapp.generated.resources.trophy

@Composable
fun ProfileScreen(navController: NavController = rememberNavController()) {
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier.fillMaxWidth().padding(16.dp).background(Color.White),
                contentAlignment = Alignment.TopEnd
            ) {
                Image(
                    painter = painterResource(Res.drawable.menu),
                    contentDescription = "Menu Avatar",
                    modifier = Modifier.size(36.dp).clip(CircleShape).clickable {
                        // Handle profile image click
                    },
                    contentScale = ContentScale.Crop
                )
            }
        },
        bottomBar = { BottomNavigationBar(navController) },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize()
                .background(Color.White), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            // Profile Image
            Box(
                modifier = Modifier.size(100.dp).clip(CircleShape).background(Color(0xFFFFE4EC)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(Res.drawable.avatar),
                    contentDescription = "Profile Avatar",
                    modifier = Modifier.size(80.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Ayesha", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.Black
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Stats Section
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ProfileStatCard(
                    icon = Res.drawable.Accuracy,
                    "79%",
                    "Accuracy",
                    Color(0xFFDAF1FF),
                    Color(0xFF2196F3)
                )
                ProfileStatCard(
                    icon = Res.drawable.lessonIcon,
                    "7",
                    "Lesson",
                    Color(0xFFE9FCEF),
                    Color(0xFF4CAF50)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ProfileStatCard(
                    icon = Res.drawable.Time,
                    "45 mins",
                    "Time Spent",
                    Color(0xFFFFEBEE),
                    Color(0xFFE91E63)
                )
                ProfileStatCard(
                    icon = Res.drawable.XPPoints,
                    "45",
                    "XP Points",
                    Color(0xFFFFF8E1),
                    Color(0xFFFF9800)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            val options = listOf(
                ProfileOption(
                    "Manage Membership",
                    "Account Status: Premium",
                    Res.drawable.profileCrown,
                    Color(0xFFFFA726)
                ),
                ProfileOption(
                    "Student Report",
                    "", Res.drawable.trophy,
                    Color(0xFFFFC107)
                ),
                ProfileOption(
                    "Leaderboard",
                    "",
                    Res.drawable.dice,
                    Color(0xFF9E9E9E)
                ),
                ProfileOption("Personal Information", "", Res.drawable.smile, Color(0xFFFFC107)),
                ProfileOption("Invite Friends", "", Res.drawable.gift, Color(0xFFE91E63))
            )
            // Options Section
            LazyColumn {
                items(options) { option ->
                    ProfileOptionCard(
                        title = option.title,
                        subtitle = option.subtitle,
                        icon = option.icon,
                        iconColor = option.iconColor
                    )
                }
            }
        }
    }
}