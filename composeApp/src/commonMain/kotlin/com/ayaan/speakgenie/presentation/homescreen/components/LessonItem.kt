package com.ayaan.speakgenie.presentation.homescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayaan.speakgenie.data.Lesson
import org.jetbrains.compose.resources.painterResource
import speakgenie.composeapp.generated.resources.LockedPlay
import speakgenie.composeapp.generated.resources.OngoingImage
import speakgenie.composeapp.generated.resources.Res
import speakgenie.composeapp.generated.resources.completedLesson
@Composable
fun LessonItem(
    lesson: Lesson, selectedLessonId: Int? = null, // Add parameter to track selected lesson
    onClick: (Int) -> Unit = {}
) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable {
            if (!lesson.isLocked) {
                onClick(lesson.id)
            }
        }, colors = CardDefaults.cardColors(
            containerColor = if (lesson.isCurrent) Color(0xFFE8F5E8) else Color.White
        ), border = if (lesson.isCurrent) {
            androidx.compose.foundation.BorderStroke(2.dp, Color(0xFF4CAF50))
        } else null, elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Status Icon
//                Box(
//                    modifier = Modifier.size(40.dp).clip(CircleShape).background(
//                        when {
//                            lesson.isCompleted -> Color(0xFFDDF6EA)
//                            lesson.isCurrent -> Color(0xFF4CAF50)
//                            lesson.isLocked -> Color.Gray
//                            else -> Color.LightGray
//                        }
//                    ), contentAlignment = Alignment.Center
//                ) {
//                    when {
//                        lesson.isCompleted -> {}
//                        lesson.isLocked -> {
//                            Image(
//                                painter = painterResource(Res.drawable.lockedplay),
//                                contentDescription = "Locked",
//                                modifier = Modifier.size(20.dp),
//                            )
//                        }
//
//                        else -> {
//
//                        }
//                    }
//                }
                if(!lesson.isCompleted && !lesson.isLocked) {
                    Image(
                        painter = painterResource(Res.drawable.OngoingImage),
                        contentDescription = "PlayIcon",
                        modifier = Modifier.size(56.dp).padding(start = 8.dp)
                    )
                }
                if(lesson.isCompleted){
                    Image(
                        painter = painterResource(Res.drawable.completedLesson),
                        contentDescription = "PlayIcon",
                        modifier = Modifier.size(56.dp).padding(start = 8.dp)
                    )
                }
                if(lesson.isLocked){
                    Image(
                        painter = painterResource(Res.drawable.LockedPlay),
                        contentDescription = "PlayIcon",
                        modifier = Modifier.size(56.dp).padding(start = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                // Lesson Info
                Column {
                    Text(
                        text = lesson.title,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                    Text(
                        text = when {
                            lesson.isCompleted -> "Completed"
                            lesson.isCurrent -> "In Progress"
                            lesson.isLocked -> "Locked"
                            else -> "Not Started"
                        }, fontSize = 12.sp, color = Color.Gray
                    )
                }
            }

            // Action Button - Only appears when this lesson is selected and not locked
            if (!lesson.isLocked && selectedLessonId == lesson.id) {
                Button(
                    onClick = { onClick(lesson.id) }, colors = ButtonDefaults.buttonColors(
                        containerColor = when {
                            lesson.isCompleted -> Color(0xFF2E7D32) // Dark green for completed
                            lesson.isCurrent -> Color(0xFF4CAF50)   // Regular green for current
                            else -> Color(0xFF66BB6A)               // Light green for not started
                        }
                    ), modifier = Modifier.height(36.dp)
                ) {
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = when {
                            lesson.isCompleted -> "RESTART"
                            else -> "START"
                        }, color = Color.White, fontSize = 14.sp
                    )
                }
            }
        }
    }
}