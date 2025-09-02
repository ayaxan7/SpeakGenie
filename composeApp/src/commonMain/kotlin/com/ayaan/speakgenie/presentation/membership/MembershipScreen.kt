package com.ayaan.speakgenie.presentation.membership

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ayaan.speakgenie.presentation.membership.components.PlanCard
import com.ayaan.speakgenie.presentation.membership.components.TermsAndPrivacyText
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
import androidx.compose.ui.draw.shadow
@Composable
fun MembershipScreen(navController: NavController = rememberNavController()) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF11D677))
                .padding(innerPadding)
        ) {
            // Scrollable green content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 200.dp), // leave space for white section
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
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

                val features = listOf(
                    FeatureItem(Res.drawable.it1, "24/7 Personal AI Tutor"),
                    FeatureItem(Res.drawable.it2, "Personalized Learning Journey"),
                    FeatureItem(Res.drawable.it3, "Unlimited Lessons & Practice"),
                    FeatureItem(Res.drawable.it4, "Master 100+ Real-Life Scenarios"),
                    FeatureItem(Res.drawable.it5, "AI-Powered Feedback for Fluency")
                )
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .height(250.dp), // 👈 control height of scrollable area
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(features) { feature ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .shadow(6.dp, RoundedCornerShape(12.dp), clip = false)
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFF0DBA67))
                                .padding(vertical = 12.dp, horizontal = 16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource(feature.icon),
                                    contentDescription = null,
                                    modifier = Modifier.size(22.dp),
                                    contentScale = ContentScale.Fit
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = feature.text,
                                    fontSize = 14.sp,
                                    color = Color.White,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }

            // White membership section pinned to bottom
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter) // pin to bottom
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.verticalScroll(rememberScrollState())) {
                    Text(
                        text = "Membership Plan",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        PlanCard(
                            title = "6 Month Plan",
                            price = "₹1800",
                            oldPrice = "₹2100",
                            monthly = "₹300/-"
                        )

                        PlanCard(
                            title = "Annual Plan",
                            price = "₹3000",
                            oldPrice = "₹6000",
                            monthly = "₹250/-",
                            mostPopular = true
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = { /* TODO */ },
                        modifier = Modifier.fillMaxWidth(.85f).height(50.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF11D677))
                    ) {
                        Text(
                            text = "Upgrade to Premium", color = Color.White, fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    TermsAndPrivacyText()
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}
