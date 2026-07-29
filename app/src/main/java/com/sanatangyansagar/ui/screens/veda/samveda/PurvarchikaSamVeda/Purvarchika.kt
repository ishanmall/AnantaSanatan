package com.sanatangyansagar.ui.screens.veda.samveda.PurvarchikaSamVeda

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
fun Purvarchika(navController: NavController) {

    // Pink and Blue Theme Colors (BaalKand Style)
    val backgroundColor = Color(0xFFFDF0F5) // Very Light Pink Background
    val topBarColor = Color(0xFFE91E63)    // Vibrant Pink
    val gradientColors = listOf(
        Color(0xFFE91E63), // Pink
        Color(0xFF2196F3)  // Blue
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "सामवेद - पूर्वार्चिक",
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
            // Mapping all 6 Adhyayas
            items(purvarchikaAdhyayas) { adhyaya ->
                PurvarchikaCard(
                    adhyaya = adhyaya,
                    gradientColors = gradientColors,
                    onClick = { navController.navigate(adhyaya.route) }
                )
            }
        }
    }
}

@Composable
fun PurvarchikaCard(
    adhyaya: PurvarchikaItem,
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
                    text = adhyaya.number,
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = adhyaya.title,
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

// Internal Data Model for the Purvarchika Hub
data class PurvarchikaItem(
    val number: String,
    val title: String,
    val route: String
)

// List of the 6 Adhyayas
val purvarchikaAdhyayas = listOf(
    PurvarchikaItem(
        number = "प्रथम अध्याय (Adhyaya 1)",
        title = "आग्नेय पर्व (Agneya Parva)",
        route = Screens.PurvarchikaAdhyayaOne.route
    ),
    PurvarchikaItem(
        number = "द्वितीय अध्याय (Adhyaya 2)",
        title = "ऐन्द्र पर्व (Aindra Parva)",
        route = Screens.PurvarchikaAdhyayaTwo.route
    ),
    PurvarchikaItem(
        number = "तृतीय अध्याय (Adhyaya 3)",
        title = "पवमान पर्व (Pavamana Parva)",
        route = Screens.PurvarchikaAdhyayaThree.route
    ),
    PurvarchikaItem(
        number = "चतुर्थ अध्याय (Adhyaya 4)",
        title = "आरण्यक पर्व (Aranyaka Parva)",
        route = Screens.PurvarchikaAdhyayaFour.route
    ),
    PurvarchikaItem(
        number = "पंचम अध्याय (Adhyaya 5)",
        title = "ऐन्द्र पर्व - उत्तर (Aindra Parva - II)",
        route = Screens.PurvarchikaAdhyayaFive.route
    ),
    PurvarchikaItem(
        number = "षष्ठ अध्याय (Adhyaya 6)",
        title = "उपसंहार पर्व (Purvarchika Conclusion)",
        route = Screens.PurvarchikaAdhyayaSix.route
    )
)