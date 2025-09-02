package com.ayaan.speakgenie.presentation.membership.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun TermsAndPrivacyText() {
    val annotatedText: AnnotatedString = buildAnnotatedString {
        append("By Upgrading you agree to our ")

        withStyle(style = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)) {
            append("Terms of use ")
        }

        append("& ")

        withStyle(style = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)) {
            append("Privacy Policy")
        }
    }

    Text(
        text = annotatedText,
        fontSize = 12.sp,
        color = Color.Gray,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}
