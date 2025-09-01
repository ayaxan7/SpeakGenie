package com.ayaan.speakgenie.data
data class Lesson(
    val id: Int,
    val title: String,
    val isCompleted: Boolean,
    val isCurrent: Boolean,
    val isLocked: Boolean
)