package com.ayaan.speakgenie.presentation.membership.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayaan.speakgenie.presentation.membership.data.FeatureItem
import org.jetbrains.compose.resources.painterResource

@Composable
fun FeatureCard(feature: FeatureItem) {
    Box(
        modifier = Modifier.fillMaxWidth().shadow(6.dp, RoundedCornerShape(12.dp), clip = false)
            .clip(RoundedCornerShape(12.dp)).background(Color(0xFF0DBA67))
            .padding(vertical = 12.dp, horizontal = 25.dp), contentAlignment = Alignment.CenterStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(feature.icon),
                contentDescription = null,
                modifier = Modifier.size(22.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = feature.text,
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.Start
            )
        }
    }
}