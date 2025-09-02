package com.ayaan.speakgenie.presentation.profilescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import speakgenie.composeapp.generated.resources.Res
import com.ayaan.speakgenie.presentation.navigation.components.BottomNavigationBar
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import speakgenie.composeapp.generated.resources.avatar
import speakgenie.composeapp.generated.resources.dice
import speakgenie.composeapp.generated.resources.gift
import speakgenie.composeapp.generated.resources.profileCrown
import speakgenie.composeapp.generated.resources.rightArrow
import speakgenie.composeapp.generated.resources.smile
import speakgenie.composeapp.generated.resources.trophy

@Composable
fun ProfileScreen(navController: NavController= rememberNavController()) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            // Profile Image
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFFFE4EC)),
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
                text = "Ayesha",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Stats Section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ProfileStatCard("79%", "Accuracy", Color(0xFFDAF1FF), Color(0xFF2196F3))
                ProfileStatCard("7", "Lesson", Color(0xFFE9FCEF), Color(0xFF4CAF50))
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ProfileStatCard("45 mins", "Time Spent", Color(0xFFFFEBEE), Color(0xFFE91E63))
                ProfileStatCard("45", "XP Points", Color(0xFFFFF8E1), Color(0xFFFF9800))
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Options Section
            ProfileOptionCard("Manage Membership", "Account Status: Premium", Res.drawable.profileCrown, Color(0xFFFFA726))
            ProfileOptionCard("Student Report", "", Res.drawable.trophy, Color(0xFFFFC107))
            ProfileOptionCard("Leaderboard", "", Res.drawable.dice, Color(0xFF9E9E9E))
            ProfileOptionCard("Personal Information", "", Res.drawable.smile, Color(0xFFFFC107))
            ProfileOptionCard("Invite Friends", "", Res.drawable.gift, Color(0xFFE91E63))
        }
    }
}

@Composable
fun ProfileStatCard(value: String, label: String, bgColor: Color, textColor: Color) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .height(80.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = value, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = textColor)
            Text(text = label, fontSize = 14.sp, color = textColor)
        }
    }
}

@Composable
fun ProfileOptionCard(title: String, subtitle: String, icon: DrawableResource, iconColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(iconColor.copy(alpha = 0.2f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                tint = iconColor,
                modifier = Modifier.size(22.dp)
            )
        }


        Spacer(modifier = Modifier.width(16.dp))


        Column(modifier = Modifier.weight(1f)) {
            Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color.Black)
            if (subtitle.isNotEmpty()) {
                Text(text = subtitle, fontSize = 12.sp, color = Color.Gray)
            }
        }


        Icon(
            painter = painterResource(Res.drawable.rightArrow),
            contentDescription = null,
            tint = Color.Gray
        )
    }
}