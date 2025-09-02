package com.ayaan.speakgenie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        enableEdgeToEdge(
//            statusBarStyle = SystemBarStyle.auto(
//                lightScrim = Color(0xFF4CAF50).toArgb(),
//                darkScrim = Color(0xFF4CAF50).toArgb()
//            ),
//            navigationBarStyle = SystemBarStyle.auto(
//                lightScrim = Color(0xFF4CAF50).toArgb(),
//                darkScrim = Color(0xFF4CAF50).toArgb()
//            )
//        )
        super.onCreate(savedInstanceState)

        setContent {
            val systemUiController = rememberSystemUiController()
            systemUiController.setSystemBarsColor(
                color = Color(0xFF4CAF50)
            )
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}