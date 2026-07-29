package com.sanatangyansagar.ui.screens.gita

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
fun Geeta(navController: NavController) {
    val pinkBlueGradient = remember {
        Brush.horizontalGradient(
            colors = listOf(Color(0xFFFFD9E8), Color(0xFFD9EFFF))
        )
    }

    val chapters = remember {
        listOf(
            GitaChapter("Adhyaya 1", "Arjuna Vishada Yoga", Screens.AdhyayaOne.route),
            GitaChapter("Adhyaya 2", "Sankhya Yoga", Screens.AdhyayaTwo.route),
            GitaChapter("Adhyaya 3", "Karma Yoga", Screens.AdhyayaThree.route),
            GitaChapter("Adhyaya 4", "Jnana Karma Sannyasa Yoga", Screens.AdhyayaFour.route),
            GitaChapter("Adhyaya 5", "Karma Sannyasa Yoga", Screens.AdhyayaFive.route),
            GitaChapter("Adhyaya 6", "Dhyana Yoga", Screens.AdhyayaSix.route),
            GitaChapter("Adhyaya 7", "Jnana Vijnana Yoga", Screens.AdhyayaSeven.route),
            GitaChapter("Adhyaya 8", "Akshara Brahma Yoga", Screens.AdhyayaEight.route),
            GitaChapter("Adhyaya 9", "Raja Vidya Raja Guhya Yoga", Screens.AdhyayaNine.route),
            GitaChapter("Adhyaya 10", "Vibhuti Yoga", Screens.AdhyayaTen.route),
            GitaChapter("Adhyaya 11", "Vishwaroopa Darshana Yoga", Screens.AdhyayaEleven.route),
            GitaChapter("Adhyaya 12", "Bhakti Yoga", Screens.AdhyayaTwelve.route),
            GitaChapter("Adhyaya 13", "Kshetra-Kshetrajna Vibhaga Yoga", Screens.AdhyayaThirteen.route),
            GitaChapter("Adhyaya 14", "Gunatraya Vibhaga Yoga", Screens.AdhyayaFourteen.route),
            GitaChapter("Adhyaya 15", "Purushottama Yoga", Screens.AdhyayaFifteen.route),
            GitaChapter("Adhyaya 16", "Daivasura Sampad Vibhaga Yoga", Screens.AdhyayaSixteen.route),
            GitaChapter("Adhyaya 17", "Shraddhatraya Vibhaga Yoga", Screens.AdhyayaSeventeen.route),
            GitaChapter("Adhyaya 18", "Moksha Sannyasa Yoga", Screens.AdhyayaEighteen.route)
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
                        letterSpacing = 1.5.sp,
                        fontSize = 18.sp
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
            // 1. HEADER IMAGE (Back to 9:16 Aspect Ratio)
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(9f / 16f) // Restored your original tall ratio
                            .clip(RoundedCornerShape(24.dp))
                            .border(1.dp, Color(0xFF1A237E).copy(alpha = 0.1f), RoundedCornerShape(24.dp))
                    ) {
                        Image(
                            painter = painterResource(R.drawable._9k0s9ypexrmw0cwshr863nqwr),
                            contentDescription = "Lord Krishna and Arjuna",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        "हरे कृष्ण",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF1A237E)
                    )
                }
            }

            // 2. IMPORTANCE CARD
            item { GitaImportanceCard() }

            // 3. ADHYAYAS SECTION
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

            items(chapters) { chapter ->
                GitaChapterCard(chapter, pinkBlueGradient) {
                    navController.navigate(chapter.route)
                }
            }
        }
    }
}

@Composable
fun GitaChapterCard(
    chapter: GitaChapter,
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
                        fontWeight = FontWeight.Medium
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
fun GitaImportanceCard() {
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
                "जीवन की हर कठिन परिस्थिति में सही मार्गदर्शन।",
                "आत्मा की अमरता का बोध और भय का नाश।",
                "निष्काम कर्म करने की दिव्य प्रेरणा।",
                "तनाव मुक्त जीवन और मन की परम शांति।"
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

data class GitaChapter(
    val number: String,
    val title: String,
    val route: Any
)