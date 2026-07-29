package com.sanatangyansagar.ui.screens.veda.samveda

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Centralized Theme Colors
val DivinePink = Color(0xFFF06292)
val SereneBlue = Color(0xFF1E88E5)
val SoftPinkBg = Color(0xFFFCE4EC)
val SoftBlueBg = Color(0xFFE3F2FD)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SamvedaHubScreen(
    onPurvarchikaClick: () -> Unit,
    onUttararchikaClick: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "सामवेद संहिता",
                        fontWeight = FontWeight.Black,
                        letterSpacing = 1.sp,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = SereneBlue
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(
                    Brush.verticalGradient(
                        listOf(SoftBlueBg, SoftPinkBg)
                    )
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Introductory Header
            Text(
                text = "सामान्यावेदो गानवेदः",
                modifier = Modifier.padding(top = 24.dp),
                style = MaterialTheme.typography.headlineSmall,
                color = SereneBlue,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "The Veda of Melodies and Chants",
                modifier = Modifier.padding(bottom = 32.dp),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.DarkGray
            )

            // Selection Cards
            SamvedaMainCard(
                title = "पूर्वार्चिक",
                subtitle = "Initial collection of hymns focused on Agni, Indra, and Soma.",
                icon = Icons.Default.MusicNote,
                accentColor = SereneBlue,
                onClick = onPurvarchikaClick
            )

            Spacer(modifier = Modifier.height(20.dp))

            SamvedaMainCard(
                title = "उत्तरार्चिक",
                subtitle = "The sequel containing 9 Adhyayas used in complex sacrificial rituals.",
                icon = Icons.Default.LibraryBooks,
                accentColor = DivinePink,
                onClick = onUttararchikaClick
            )

            Spacer(modifier = Modifier.weight(1f))

            // App Branding footer
            Text(
                text = "Sanatan Gyansagar",
                modifier = Modifier.padding(bottom = 16.dp),
                fontSize = 12.sp,
                color = DivinePink.copy(alpha = 0.6f),
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun SamvedaMainCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    accentColor: Color,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.92f)
            .height(140.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icon Section
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(100.dp)
                    .background(
                        Brush.linearGradient(
                            listOf(accentColor, accentColor.copy(alpha = 0.7f))
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(45.dp)
                )
            }

            // Text Section
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = accentColor
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = subtitle,
                    fontSize = 13.sp,
                    lineHeight = 18.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}