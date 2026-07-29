package com.sanatangyansagar.ui.screens.DurgaSaptshati

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sanatangyansagar.Navigation.Screens
import com.sanatangyansagar.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DurgaSapshati(navController: NavController) {
    // Shared Gradient remembered for performance
    val pinkBlueGradient = remember {
        Brush.horizontalGradient(
            colors = listOf(Color(0xFFFFD9E8), Color(0xFFD9EFFF))
        )
    }

    val chapters = remember {
        listOf(
            SaptshatiChapter("Adhyaya 1", "Madhu Kaitabha Vadha", Screens.DurgaShapshatiAdhyayaOne.route),
            SaptshatiChapter("Adhyaya 2", "Mahishasura Sainya Vadha", Screens.DurgaShapshatiAdhyayaTwo.route),
            SaptshatiChapter("Adhyaya 3", "Mahishasura Vadha", Screens.DurgaShapshatiAdhyayaThree.route),
            SaptshatiChapter("Adhyaya 4", "Devi Stuti (Shakradi Stuti)", Screens.DurgaShapshatiAdhyayaFour.route),
            SaptshatiChapter("Adhyaya 5", "Devi-Doota Samvada", Screens.DurgaShapshatiAdhyayaFive.route),
            SaptshatiChapter("Adhyaya 6", "Dhumralochana Vadha", Screens.DurgaShapshatiAdhyayaSix.route),
            SaptshatiChapter("Adhyaya 7", "Chanda Munda Vadha", Screens.DurgaShapshatiAdhyayaSeven.route),
            SaptshatiChapter("Adhyaya 8", "Raktabija Vadha", Screens.DurgaShapshatiAdhyayaEight.route),
            SaptshatiChapter("Adhyaya 9", "Nishumbha Vadha", Screens.DurgaShapshatiAdhyayaNine.route),
            SaptshatiChapter("Adhyaya 10", "Shumbha Vadha", Screens.DurgaShapshatiAdhyayaTen.route),
            SaptshatiChapter("Adhyaya 11", "Narayani Stuti", Screens.DurgaShapshatiAdhyayaEleven.route),
            SaptshatiChapter("Adhyaya 12", "Phalashruti", Screens.DurgaShapshatiAdhyayaTwelve.route),
            SaptshatiChapter("Adhyaya 13", "Suratha and Vaishya Boons", Screens.DurgaShapshatiAdhyayaThirteen.route)
        )
    }

    Scaffold(
        containerColor = Color(0xFFF8F9FA),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "SANATAN GYAN SAGAR",
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF1A237E),
                        fontSize = 18.sp,
                        letterSpacing = 1.5.sp
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.White)
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            // 1. HEADER IMAGE (Fixed back to 9:16 Aspect Ratio)
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(9f / 16f) // Full Portrait Ratio restored
                            .clip(RoundedCornerShape(24.dp))
                            .border(1.dp, Color(0xFF1A237E).copy(alpha = 0.1f), RoundedCornerShape(24.dp))
                    ) {
                        Image(
                            painter = painterResource(R.drawable.mwvk83j0wxrmw0cwshrs8ek6pc),
                            contentDescription = "Maa Durga",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        "जय माता दी",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF1A237E)
                    )
                }
            }

            // 2. Importance Card (Premium Navy Style)
            item { SaptshatiImportanceCard() }

            // 3. Section Header
            item {
                Text(
                    text = "ADHYAYAS / अध्याय",
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Gray,
                    letterSpacing = 1.2.sp,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            // 4. Chapter List (Consistent Pink-Blue Cards)
            items(chapters) { chapter ->
                SaptshatiChapterCard(chapter, pinkBlueGradient) {
                    navController.navigate(chapter.route)
                }
            }
        }
    }
}

@Composable
fun SaptshatiChapterCard(
    chapter: SaptshatiChapter,
    gradient: Brush,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient)
                .padding(horizontal = 20.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Circular Icon Background
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(Color.White.copy(alpha = 0.5f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.AutoStories,
                        contentDescription = null,
                        tint = Color(0xFF1A237E),
                        modifier = Modifier.size(24.dp)
                    )
                }

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = chapter.number,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF1A237E),
                        fontSize = 17.sp
                    )
                    Text(
                        text = chapter.title,
                        fontSize = 13.sp,
                        color = Color(0xFF455A64),
                        fontWeight = FontWeight.Medium,
                        maxLines = 1
                    )
                }

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                    contentDescription = null,
                    tint = Color(0xFF1A237E).copy(alpha = 0.3f),
                    modifier = Modifier.size(14.dp)
                )
            }
        }
    }
}

@Composable
fun SaptshatiImportanceCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A237E)),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFFFD9E8), modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Importance / महत्व", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }

            Spacer(modifier = Modifier.height(12.dp))

            val points = listOf(
                "शक्ति की आराधना का सबसे प्रभावशाली ग्रंथ।",
                "नकारात्मक ऊर्जा और भय का नाश करता है।",
                "मानसिक शक्ति और आत्म-विश्वास में वृद्धि।",
                "जीवन की बाधाओं को दूर कर सुख प्रदान करता है।"
            )

            points.forEach { point ->
                Text(
                    text = "• $point",
                    fontSize = 13.sp,
                    lineHeight = 20.sp,
                    modifier = Modifier.padding(vertical = 4.dp),
                    color = Color(0xFFD9EFFF),
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

data class SaptshatiChapter(
    val number: String,
    val title: String,
    val route: Any
)