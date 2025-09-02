package com.ayaan.speakgenie.presentation.profilescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProfileStatCard(icon: DrawableResource, value: String, label: String, bgColor: Color, textColor: Color) {
    Card(
        modifier = Modifier.width(160.dp).height(80.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = value, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = textColor)
            Row{
                Image(
                    painter = painterResource(icon),
                    contentDescription = label,
                    modifier = Modifier.padding(end = 8.dp).size(20.dp)
                )
                Text(text = label, fontSize = 14.sp, color = textColor, fontWeight = FontWeight.Bold)
            }
        }
    }
}