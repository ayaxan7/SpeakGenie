package com.ayaan.speakgenie

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform