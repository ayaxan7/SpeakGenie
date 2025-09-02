package com.ayaan.speakgenie.presentation.membership

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ayaan.speakgenie.presentation.membership.components.FeatureCard
import com.ayaan.speakgenie.presentation.membership.components.MembershipSection
import com.ayaan.speakgenie.presentation.membership.data.FeatureItem
import com.ayaan.speakgenie.presentation.navigation.components.BottomNavigationBar
import org.jetbrains.compose.resources.painterResource
import speakgenie.composeapp.generated.resources.Res
import speakgenie.composeapp.generated.resources.crown
import speakgenie.composeapp.generated.resources.gopremium
import speakgenie.composeapp.generated.resources.it1
import speakgenie.composeapp.generated.resources.it2
import speakgenie.composeapp.generated.resources.it3
import speakgenie.composeapp.generated.resources.it4
import speakgenie.composeapp.generated.resources.it5

@Composable
fun MembershipScreen(navController: NavController = rememberNavController()) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }) { innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize().background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0xFF11D677), Color(0xFF139F5C))
                    )
                ).padding(innerPadding)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(20.dp))

                Image(
                    painter = painterResource(Res.drawable.crown),
                    contentDescription = "Crown",
                    modifier = Modifier.size(48.dp),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(4.dp))

                Image(
                    painter = painterResource(Res.drawable.gopremium),
                    contentDescription = "Go Premium",
                    modifier = Modifier.fillMaxWidth(0.94f).height(78.dp),
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.height(20.dp))
                LazyColumn(
                    modifier = Modifier.fillMaxWidth().height(250.dp).padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    val features = listOf(
                        FeatureItem(Res.drawable.it1, "24/7 Personal AI Tutor"),
                        FeatureItem(Res.drawable.it2, "Personalized Learning Journey"),
                        FeatureItem(Res.drawable.it3, "Unlimited Lessons & Practice"),
                        FeatureItem(Res.drawable.it4, "Master 100+ Real-Life Scenarios"),
                        FeatureItem(Res.drawable.it5, "AI-Powered Feedback for Fluency")
                    )

                    items(features) { feature ->
                        FeatureCard(feature)
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                MembershipSection()
            }
        }
    }
}



