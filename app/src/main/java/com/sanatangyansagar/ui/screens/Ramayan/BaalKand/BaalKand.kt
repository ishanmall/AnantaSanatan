package com.sanatangyansagar.ui.screens.Ramayan.BaalKand

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sanatangyansagar.Navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaalKand(navController: NavController) {

    // Pink and Blue Theme Colors
    val backgroundColor = Color(0xFFFDF0F5) // Very Light Pink Background
    val topBarColor = Color(0xFFE91E63) // Vibrant Pink
    val gradientColors = listOf(
        Color(0xFFE91E63), // Pink
        Color(0xFF2196F3)  // Blue
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "बालकाण्ड (वाल्मीकि रामायण)",
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 22.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = topBarColor
                )
            )
        },
        containerColor = backgroundColor
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(baalKandChapters) { chapter ->
                ChapterCard(
                    chapter = chapter,
                    gradientColors = gradientColors,
                    onClick = { navController.navigate(chapter.route) }
                )
            }
        }
    }
}

@Composable
fun ChapterCard(
    chapter: BaalKandChapter,
    gradientColors: List<Color>,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.horizontalGradient(colors = gradientColors))
                .padding(20.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Column {
                Text(
                    text = chapter.sargaNumber,
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = chapter.title,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

// Data Model for the Menu
data class BaalKandChapter(
    val sargaNumber: String,
    val title: String,
    val route: Any
)

// List of Chapters (Sargas 1 to 11)
val baalKandChapters = listOf(
    BaalKandChapter(
        sargaNumber = "प्रथम सर्ग (Sarga 1)",
        title = "मूल रामायण (संक्षिप्त कथा)",
        route = Screens.BaalKandSargaOne.route
    ),
    BaalKandChapter(
        sargaNumber = "द्वितीय सर्ग (Sarga 2)",
        title = "क्रौंच वध एवं श्लोक उत्पत्ति",
        route = Screens.BaalKandSargaTwo.route
    ),
    BaalKandChapter(
        sargaNumber = "तृतीय सर्ग (Sarga 3)",
        title = "रामायण का ध्यान और सार",
        route = Screens.BaalKandSargaThree.route
    ),
    BaalKandChapter(
        sargaNumber = "चतुर्थ सर्ग (Sarga 4)",
        title = "कुश-लव द्वारा रामायण गान",
        route = Screens.BaalKandSargaFour.route
    ),
    BaalKandChapter(
        sargaNumber = "पंचम सर्ग (Sarga 5)",
        title = "अयोध्या वैभव वर्णन",
        route = Screens.BaalKandSargaFive.route
    ),
    BaalKandChapter(
        sargaNumber = "षष्ठ सर्ग (Sarga 6)",
        title = "सचिव एवं प्रशासन वर्णन",
        route = Screens.BaalKandSargaSix.route
    ),
    BaalKandChapter(
        sargaNumber = "सप्तम सर्ग (Sarga 7)",
        title = "अमात्य वर्णन",
        route = Screens.BaalKandSargaSeven.route
    ),
    BaalKandChapter(
        sargaNumber = "अष्टम सर्ग (Sarga 8)",
        title = "सुमन्त्र की गुप्त मंत्रणा",
        route = Screens.BaalKandSargaEight.route
    ),
    BaalKandChapter(
        sargaNumber = "नवम सर्ग (Sarga 9)",
        title = "ऋष्यशृंग उपाख्यान",
        route = Screens.BaalKandSargaNine.route
    ),
    BaalKandChapter(
        sargaNumber = "दशम सर्ग (Sarga 10)",
        title = "दशरथ की अंग देश यात्रा",
        route = Screens.BaalKandSargaTen.route
    ),
    BaalKandChapter(
        sargaNumber = "एकादश सर्ग (Sarga 11)",
        title = "यज्ञ की तैयारी",
        route = Screens.BaalKandSargaEleven.route
    )
)