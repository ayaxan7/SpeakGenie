package com.ayaan.speakgenie.presentation.navigation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import speakgenie.composeapp.generated.resources.Home
import speakgenie.composeapp.generated.resources.Learn
import speakgenie.composeapp.generated.resources.Premium
import speakgenie.composeapp.generated.resources.Res

@Composable
fun BottomNavigationBar() {
    var selectedIndex by remember { mutableStateOf(0) }

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        shadowElevation = 8.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            BottomNavItem(
                icon = Res.drawable.Home,
                label = "Home",
                isSelected = selectedIndex == 0,
                onClick = { selectedIndex = 0 }
            )
            BottomNavItem(
                icon = Res.drawable.Learn,
                label = "Learn",
                isSelected = selectedIndex == 1,
                onClick = { selectedIndex = 1 }
            )
            BottomNavItem(
                icon = Res.drawable.Premium,
                label = "Membership",
                isSelected = selectedIndex == 2,
                onClick = { selectedIndex = 2 }
            )
            BottomNavItem(
                icon = Icons.Default.Person,
                label = "Profile",
                isSelected = selectedIndex == 3,
                onClick = { selectedIndex = 3 }
            )
        }
    }
}
