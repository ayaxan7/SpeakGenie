package com.ayaan.speakgenie.data

data class Lesson(
    val id: Int,
    val title: String,
    val isCompleted: Boolean = false,
    val isCurrent: Boolean = false,
    val isLocked: Boolean = false
)
