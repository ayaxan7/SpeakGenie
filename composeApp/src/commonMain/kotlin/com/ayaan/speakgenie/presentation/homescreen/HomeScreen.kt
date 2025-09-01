package com.ayaan.speakgenie.presentation.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ayaan.speakgenie.data.Lesson
import com.ayaan.speakgenie.presentation.homescreen.components.HeaderSection
import com.ayaan.speakgenie.presentation.homescreen.components.LessonItem
import com.ayaan.speakgenie.presentation.homescreen.components.RecentQuizCard
import com.ayaan.speakgenie.presentation.navigation.components.BottomNavigationBar
import org.jetbrains.compose.resources.painterResource
import speakgenie.composeapp.generated.resources.Res
import speakgenie.composeapp.generated.resources.boy

@Composable
fun HomeScreen(navController: NavController = rememberNavController()) {
    val lessons = listOf(
        Lesson(1, "Introduction", isCompleted = true, isCurrent = false, isLocked = false),
        Lesson(2, "Basics of Greeting", isCompleted = false, isCurrent = true, isLocked = false),
        Lesson(3, "Roleplay", isCompleted = false, isCurrent = false, isLocked = true),
        Lesson(4, "Talk with AI Teacher", isCompleted = false, isCurrent = false, isLocked = true),
        Lesson(5, "Common Phrases", isCompleted = false, isCurrent = false, isLocked = true)
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize().background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF4CAF50), Color(0xFF2E7D32)
                    )
                )
            )
        ) {
            // Top Section with Greeting and Stats
            HeaderSection()

            // Recent Quiz Card
            RecentQuizCard()

            // Main Content Area
            Box(
                modifier = Modifier.fillMaxSize().background(
                    Color.White, RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp).padding(bottom = 80.dp) // Add bottom padding for nav bar
                ) {
                    // Main Image - Boy image expanded to fill the whole box
                    Image(
                        painter = painterResource(Res.drawable.boy),
                        contentDescription = "Main Illustration",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth().height(180.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Greeting Conversations Section
                    Text(
                        "Greetings Conversations",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Lessons List
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        items(lessons) { lesson ->
                            LessonItem(lesson = lesson)
                        }
                    }
                }
            }
        }

        // Bottom Navigation - positioned at the bottom of the screen
        Box(
            modifier = Modifier.fillMaxWidth()
                .align(androidx.compose.ui.Alignment.BottomCenter)
        ) {
            BottomNavigationBar()
        }
    }
}