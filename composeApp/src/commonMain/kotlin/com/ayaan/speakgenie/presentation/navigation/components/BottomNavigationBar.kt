package com.ayaan.speakgenie.presentation.navigation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import speakgenie.composeapp.generated.resources.Home
import speakgenie.composeapp.generated.resources.Learn
import speakgenie.composeapp.generated.resources.Premium
import speakgenie.composeapp.generated.resources.Res
import speakgenie.composeapp.generated.resources.profile
@Composable
fun BottomNavigationBar() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White, // Changed from Color.Black to Color.White
        shadowElevation = 8.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            BottomNavItem(
                icon = Res.drawable.Home, // Your actual home icon drawable
                label = "Home",
                isSelected = true
            )
            BottomNavItem(
                icon = Res.drawable.Learn, // Your actual learn icon drawable
                label = "Learn",
                isSelected = false
            )
            BottomNavItem(
                icon = Res.drawable.Premium, // Your actual membership icon drawable
                label = "Membership",
                isSelected = false
            )
            BottomNavItem(
                icon = Res.drawable.profile, // Your actual profile icon drawable
                label = "Profile",
                isSelected = false
            )
        }
    }
}