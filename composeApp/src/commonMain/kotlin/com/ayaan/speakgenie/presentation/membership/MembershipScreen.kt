package com.ayaan.speakgenie.presentation.membership
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ayaan.speakgenie.data.Lesson
import com.ayaan.speakgenie.presentation.homescreen.components.HeaderSection
import com.ayaan.speakgenie.presentation.homescreen.components.LessonItem
import com.ayaan.speakgenie.presentation.homescreen.components.RecentQuizCard
import com.ayaan.speakgenie.presentation.navigation.components.BottomNavigationBar
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import speakgenie.composeapp.generated.resources.Res
import speakgenie.composeapp.generated.resources.boy
import speakgenie.composeapp.generated.resources.crown
import speakgenie.composeapp.generated.resources.it1
import speakgenie.composeapp.generated.resources.it2
import speakgenie.composeapp.generated.resources.it3
import speakgenie.composeapp.generated.resources.it4
import speakgenie.composeapp.generated.resources.it5
import speakgenie.composeapp.generated.resources.list

@Composable
fun MembershipScreen(navController: NavController = rememberNavController()) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color(0xFF00B894))
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            // Crown Icon
            Icon(
                painter = painterResource(Res.drawable.crown),
                contentDescription = "Crown",
                tint = Color.Yellow,
                modifier = Modifier.size(48.dp)
            )

            Text(
                text = "Go Premium",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 8.dp)
            )

            Text(
                text = "Learn Like Never Before!",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 4.dp)
            )

            Text(
                text = "Start Your Journey for Just ₹250/- month",
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 2.dp, bottom = 16.dp)
            )
            val icons: Map<DrawableResource, String> = mapOf(
                Res.drawable.it1 to "24/7 Personal AI Tutor",
                Res.drawable.it2 to "Personalized Learning Journey",
                Res.drawable.it3 to "Unlimited Lessons & Practice",
                Res.drawable.it4 to "Master 100+ Real-Life Scenarios",
                Res.drawable.it5 to "AI-Powered Feedback for Fluency"
            )

            icons.forEach { (icon, text) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
//                    Icon(
//                        painter = painterResource(icon),
//                        contentDescription = text,
//                        tint = Color.White,
//                        modifier = Modifier.size(24.dp)
//                    )
                    Image(
                        painter = painterResource(icon),
                        contentDescription = "Bullet",
                        modifier = Modifier.size(20.dp),
                        contentScale = ContentScale.Fit
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = text,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Membership Plan section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
                        // 6 Month Plan
                        PlanCard(
                            title = "6 Month Plan",
                            price = "₹1800",
                            oldPrice = "₹2100",
                            monthly = "₹300/-"
                        )

                        // Annual Plan
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
                        onClick = { /* TODO: Handle Upgrade */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00B894))
                    ) {
                        Text(
                            text = "Upgrade to Premium",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "By Upgrading you agree to our Terms of use & Privacy Policy",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun PlanCard(
    title: String,
    price: String,
    oldPrice: String,
    monthly: String,
    mostPopular: Boolean = false
) {
    Box(
        modifier = Modifier
            .width(150.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .border(1.dp, Color.LightGray, RoundedCornerShape(16.dp))
            .padding(12.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            if (mostPopular) {
                Text(
                    text = "Most Popular",
                    fontSize = 12.sp,
                    color = Color.White,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF00B894))
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                )
                Spacer(modifier = Modifier.height(6.dp))
            }

            Text(text = title, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = price, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Text(
                text = oldPrice,
                fontSize = 12.sp,
                color = Color.Gray,
                textDecoration = TextDecoration.LineThrough
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Monthly $monthly", fontSize = 12.sp, color = Color.Gray)
        }
    }
}
