package com.sanatangyansagar.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.HistoryEdu
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sanatangyansagar.Navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    // Signature Devotional Gradients (Pink and Blue Theme)
    val pinkBlueGradient = Brush.horizontalGradient(
        listOf(Color(0xFFFFD9E8), Color(0xFFD9EFFF))
    )

    val comingSoonGradient = Brush.horizontalGradient(
        listOf(Color(0xFFF1F3F4), Color(0xFFE8EAED))
    )

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
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // 1. HERO SECTION: SPIRITUAL QUOTE
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(24.dp))
                        .background(pinkBlueGradient)
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            "असतो मा सद्गमय। तमसो मा ज्योतिर्गमय।",
                            color = Color(0xFF1A237E),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "Lead us from ignorance to truth.",
                            color = Color(0xFF455A64),
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            // 2. THE SUPREME TRUTH SECTION
            item {
                SectionHeader("THE SUPREME TRUTH")
            }

            item {
                HomeMenuCard(
                    title = "Divine Origins",
                    subtitle = "Who are Mahadev, Vishnu & Brahma?",
                    icon = Icons.Default.SelfImprovement,
                    gradient = pinkBlueGradient
                ) {
                    navController.navigate(Screens.GodDetail.route)
                }
            }

            // 3. SACRED SCRIPTURES SECTION
            item {
                SectionHeader("SACRED SCRIPTURES")
            }

            // Bhagavad Gita
            item {
                HomeMenuCard(
                    title = "Shrimad Bhagavad Gita",
                    subtitle = "The divine song of Lord Krishna",
                    icon = Icons.Default.AutoStories,
                    gradient = pinkBlueGradient
                ) {
                    navController.navigate(Screens.GeetaMenu.route)
                }
            }

            // Ramayana
            item {
                HomeMenuCard(
                    title = "Valmiki Ramayana",
                    subtitle = "The epic saga of Lord Rama",
                    icon = Icons.Default.HistoryEdu,
                    gradient = pinkBlueGradient
                ) {
                    navController.navigate(Screens.RamayanMenu.route)
                }
            }

            // Samveda (NOW ACTIVE)
            item {
                HomeMenuCard(
                    title = "Samveda Samhita",
                    subtitle = "The Veda of Melodies & Chants",
                    icon = Icons.Default.MusicNote,
                    gradient = pinkBlueGradient
                ) {
                    navController.navigate(Screens.SamvedaHub.route)
                }
            }

            // Durga Saptashati
            item {
                HomeMenuCard(
                    title = "Durga Saptashati",
                    subtitle = "The 13 Chapters (Adhyayas) of Glory",
                    icon = Icons.Default.HistoryEdu,
                    gradient = pinkBlueGradient
                ) {
                    navController.navigate(Screens.DurgaShapshatiMenu.route)
                }
            }

            // Durga Maa Bhakti
            item {
                HomeMenuCard(
                    title = "Durga Maa Bhakti",
                    subtitle = "Chalisa, Aarti, Stotram & Suktam",
                    icon = Icons.Default.HistoryEdu,
                    gradient = pinkBlueGradient
                ) {
                    navController.navigate(Screens.DurgaMaaMenu.route)
                }
            }

            // Upanishads
            item {
                HomeMenuCard(
                    title = "Upanishads",
                    subtitle = "The philosophy of the Soul",
                    icon = Icons.Default.Book,
                    gradient = pinkBlueGradient
                ) {
                    navController.navigate(Screens.UpanishadDashboard.route)
                }
            }

            // 4. FUTURE WISDOM SECTION
            item {
                SectionHeader("FUTURE WISDOM")
            }

            item {
                HomeMenuCard(
                    title = "Rigveda, Yajurveda & Atharvaveda",
                    subtitle = "In Preparation",
                    icon = Icons.Default.Book,
                    gradient = comingSoonGradient,
                    isActive = false
                ) {}
            }

            item {
                HomeMenuCard(
                    title = "Puranas",
                    subtitle = "In Preparation",
                    icon = Icons.Default.Book,
                    gradient = comingSoonGradient,
                    isActive = false
                ) {}
            }
        }
    }
}

/**
 * Common Section Header for Home Screen
 */
@Composable
fun SectionHeader(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.ExtraBold,
        color = Color.Gray,
        letterSpacing = 1.2.sp,
        fontSize = 12.sp,
        modifier = Modifier.padding(start = 8.dp, top = 8.dp)
    )
}

/**
 * Reusable Menu Card Composable
 * Defined outside HomeScreen to solve Unresolved Reference errors
 */
@Composable
fun HomeMenuCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    gradient: Brush,
    isActive: Boolean = true,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(95.dp)
            .clip(RoundedCornerShape(22.dp))
            .clickable(enabled = isActive) { onClick() },
        elevation = CardDefaults.cardElevation(if (isActive) 3.dp else 0.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
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
                        .size(50.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(Color.White.copy(alpha = 0.5f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = if (isActive) Color(0xFF1A237E) else Color.Gray,
                        modifier = Modifier.size(28.dp)
                    )
                }

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.ExtraBold,
                        color = if (isActive) Color(0xFF1A237E) else Color.Gray,
                        fontSize = 17.sp
                    )
                    Text(
                        text = subtitle,
                        fontSize = 13.sp,
                        color = Color(0xFF455A64),
                        fontWeight = FontWeight.Medium
                    )
                }

                if (isActive) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                        contentDescription = null,
                        tint = Color(0xFF1A237E).copy(alpha = 0.3f),
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}