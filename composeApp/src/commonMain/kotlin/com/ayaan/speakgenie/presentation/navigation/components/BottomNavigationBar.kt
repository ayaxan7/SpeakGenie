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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ayaan.speakgenie.presentation.navigation.Screen
import speakgenie.composeapp.generated.resources.Home
import speakgenie.composeapp.generated.resources.Learn
import speakgenie.composeapp.generated.resources.Premium
import speakgenie.composeapp.generated.resources.Res

@Composable
fun BottomNavigationBar(navController: NavController = rememberNavController()) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

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
                isSelected = currentRoute == Screen.Home.route,
                onClick = {
                    if (currentRoute != Screen.Home.route) {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Home.route) { inclusive = true }
                        }
                    }
                }
            )
            BottomNavItem(
                icon = Res.drawable.Learn,
                label = "Learn",
                isSelected = currentRoute == Screen.Learn.route,
                onClick = {
                    if (currentRoute != Screen.Learn.route) {
                        navController.navigate(Screen.Learn.route) {
                            popUpTo(Screen.Home.route)
                        }
                    }
                }
            )
            BottomNavItem(
                icon = Res.drawable.Premium,
                label = "Membership",
                isSelected = currentRoute == Screen.Membership.route,
                onClick = {
                    if (currentRoute != Screen.Membership.route) {
                        navController.navigate(Screen.Membership.route) {
                            popUpTo(Screen.Home.route)
                        }
                    }
                }
            )
            BottomNavItem(
                icon = Icons.Default.Person,
                label = "Profile",
                isSelected = currentRoute == Screen.Profile.route,
                onClick = {
                    if (currentRoute != Screen.Profile.route) {
                        navController.navigate(Screen.Profile.route) {
                            popUpTo(Screen.Home.route)
                        }
                    }
                }
            )
        }
    }
}
