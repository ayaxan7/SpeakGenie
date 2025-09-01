package com.ayaan.speakgenie.presentation.navigation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigationBar() {
    Surface(
        modifier = Modifier.fillMaxWidth(), color = Color.White, shadowElevation = 8.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            BottomNavItem(
                icon = Icons.Default.Home, label = "Home", isSelected = true
            )
            BottomNavItem(
                icon = Icons.Default.Star, label = "Learn", isSelected = false
            )
            BottomNavItem(
                icon = Icons.Default.Star, // Replace with membership icon
                label = "Membership", isSelected = false
            )
            BottomNavItem(
                icon = Icons.Default.Person, label = "Profile", isSelected = false
            )
        }
    }
}