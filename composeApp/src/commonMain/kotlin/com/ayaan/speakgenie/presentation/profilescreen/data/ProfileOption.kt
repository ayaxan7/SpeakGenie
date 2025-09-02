package com.ayaan.speakgenie.presentation.profilescreen.data

import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.DrawableResource

data class ProfileOption(
    val title: String,
    val subtitle: String,
    val icon: DrawableResource,
    val iconColor: Color
)