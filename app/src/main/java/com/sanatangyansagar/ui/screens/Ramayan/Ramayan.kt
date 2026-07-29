package com.sanatangyansagar.ui.screens.Ramayan

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
fun Ramayan(navController: NavController) {

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
                        text = "सम्पूर्ण वाल्मीकि रामायण",
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
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(ramayanKandas) { kand ->
                KandCard(
                    kand = kand,
                    gradientColors = gradientColors,
                    onClick = {
                        if (kand.route.isNotEmpty()) {
                            navController.navigate(kand.route)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun KandCard(
    kand: RamayanKand,
    gradientColors: List<Color>,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = kand.route.isNotEmpty()) { onClick() },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    if (kand.route.isNotEmpty()) Brush.horizontalGradient(colors = gradientColors)
                    else Brush.horizontalGradient(listOf(Color.Gray, Color.LightGray)) // Greyed out if coming soon
                )
                .padding(24.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Column {
                Text(
                    text = kand.sanskritTitle,
                    color = Color.White.copy(alpha = 0.85f),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = kand.title,
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                if (kand.route.isEmpty()) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "शीघ्र उपलब्ध (Coming Soon)",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .background(Color.Black.copy(alpha = 0.3f), RoundedCornerShape(4.dp))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }
        }
    }
}

// Data Model for the Kandas
data class RamayanKand(
    val title: String,
    val sanskritTitle: String,
    val route: String
)

// List of all 7 Kandas of the Ramayana
val ramayanKandas = listOf(
    RamayanKand(
        title = "बालकाण्ड",
        sanskritTitle = "Bala Kanda (Childhood Episode)",
        route = Screens.BaalKandMenu.route
    )
)