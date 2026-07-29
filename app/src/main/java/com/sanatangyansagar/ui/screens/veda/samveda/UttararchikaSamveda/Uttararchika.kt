package com.sanatangyansagar.ui.screens.veda.samveda.UttararchikaSamveda

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Color Palette: Divine Pink & Serene Blue
val DivinePink = Color(0xFFF06292)
val SereneBlue = Color(0xFF1E88E5)
val BackgroundGradient = Brush.verticalGradient(
    colors = listOf(Color(0xFFE3F2FD), Color(0xFFFCE4EC))
)

data class AdhyayaItem(val id: Int, val title: String, val subtitle: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UttararchikaScreen(onAdhyayaClick: (Int) -> Unit) {
    val adhyayas = listOf(
        AdhyayaItem(1, "प्रथम अध्याय", "The Descent of Agni"),
        AdhyayaItem(2, "द्वितीय अध्याय", "Refining the Soma"),
        AdhyayaItem(3, "तृतीय अध्याय", "The Strength of Indra"),
        AdhyayaItem(4, "चतुर्थ अध्याय", "Hymns of the Maruts"),
        AdhyayaItem(5, "पंचम अध्याय", "Sacred Rituals"),
        AdhyayaItem(6, "षष्ठ अध्याय", "The Flow of Nectar"),
        AdhyayaItem(7, "सप्तम अध्याय", "Stabilization of Mind"),
        AdhyayaItem(8, "अष्टम अध्याय", "Sovereignty of Soul"),
        AdhyayaItem(9, "नवम अध्याय", "The Solar Abode")
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "सामवेद - उत्तरार्चिक",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = SereneBlue
                )
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(BackgroundGradient)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(adhyayas) { adhyaya ->
                    AdhyayaCard(adhyaya, onAdhyayaClick)
                }
            }
        }
    }
}

@Composable
fun AdhyayaCard(adhyaya: AdhyayaItem, onClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(adhyaya.id) },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(DivinePink, RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.MenuBook,
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = adhyaya.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = SereneBlue
                )
                Text(
                    text = adhyaya.subtitle,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }
}