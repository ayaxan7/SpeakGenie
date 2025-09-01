package com.ayaan.speakgenie.presentation.homescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "☀️", fontSize = 20.sp
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "Good Morning", color = Color.White, fontSize = 16.sp
                )
            }
            Text(
                "Ayesha", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier.background(
                    Color.White.copy(alpha = 0.2f), RoundedCornerShape(20.dp)
                ).padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Text(
                    "💎", fontSize = 16.sp
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    "30", color = Color.White, fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                "PRO",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.background(
                    Color(0xFFFF7043),
                    RoundedCornerShape(20.dp)
                ).padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}