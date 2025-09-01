package com.ayaan.speakgenie.presentation.homescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayaan.speakgenie.data.Lesson

@Composable
fun LessonItem(lesson: Lesson) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (lesson.isCurrent) Color(0xFFE8F5E8) else Color.White
        ),
        border = if (lesson.isCurrent) {
            androidx.compose.foundation.BorderStroke(2.dp, Color(0xFF4CAF50))
        } else null
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Play button or status indicator
            Box(
                modifier = Modifier.size(48.dp).background(
                        when {
                            lesson.isCompleted -> Color(0xFF4CAF50)
                            lesson.isCurrent -> Color(0xFF4CAF50)
                            else -> Color(0xFFE0E0E0)
                        }, CircleShape
                    ), contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow, contentDescription = null, tint = when {
                        lesson.isCompleted || lesson.isCurrent -> Color.White
                        else -> Color.Gray
                    }
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Lesson content
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    "Lesson ${lesson.id}", fontSize = 14.sp, color = Color.Gray
                )
                Text(
                    lesson.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = if (lesson.isLocked) Color.Gray else Color.Black
                )
            }

            // Right side indicators
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (lesson.isCurrent) {
                    Surface(
                        modifier = Modifier.background(Color(0xFF2E7D32), RoundedCornerShape(20.dp))
                            .padding(horizontal = 16.dp, vertical = 6.dp)
                    ) {
                        Text(
                            "Start",
                            color = Color.White,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.background(Color.Transparent)
                        )
                    }
                } else if (lesson.isCompleted) {
                    Box(
                        modifier = Modifier.size(24.dp).background(Color(0xFF4CAF50), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "✓", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}