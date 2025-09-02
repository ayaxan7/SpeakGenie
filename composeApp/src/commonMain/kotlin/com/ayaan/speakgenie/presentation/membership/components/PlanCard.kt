package com.ayaan.speakgenie.presentation.membership.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

@Composable
fun PlanCard(
    title: String,
    price: String,
    oldPrice: String,
    monthly: String,
    mostPopular: Boolean = false
) {
    val borderColor = if (mostPopular) Color(0xFF19C472) else Color.LightGray

    Box(contentAlignment = Alignment.TopCenter) {
        // Card with border + content
        Box(
            modifier = Modifier
                .width(150.dp)
                .border(3.5.dp, borderColor, RoundedCornerShape(16.dp))
                .background(Color.White, RoundedCornerShape(16.dp))
                .padding(top = 24.dp, bottom = 12.dp, start = 12.dp, end = 12.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = title, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = price, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = oldPrice,
                        fontSize = 12.sp,
                        color = Color.Gray,
                        textDecoration = TextDecoration.LineThrough
                    )
                }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Monthly $monthly", fontSize = 12.sp, color = Color.Gray)
            }
        }

        // Floating badge ABOVE border
        if (mostPopular) {
            Text(
                text = "Most Popular",
                fontSize = 12.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x= (-13).dp,y = (-10).dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(borderColor)
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            )
        }
    }
}