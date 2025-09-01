package com.ayaan.speakgenie

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.ayaan.speakgenie.presentation.navigation.AppNavigation
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        AppNavigation()
    }
}