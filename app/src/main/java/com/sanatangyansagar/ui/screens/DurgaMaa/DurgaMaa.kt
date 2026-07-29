package com.sanatangyansagar.ui.screens.DurgaMaa

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sanatangyansagar.R

/**
 * DURGA MAA MENU SCREEN
 * Displays a 9:16 portrait header and a list of all Durga Maa related texts.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DurgaMaaScreen(navController: NavController) {
    // Standardized list of all items in the package
    val durgaMaaItems = listOf(
        DurgaScreenItem("श्री दुर्गा चालीसा", "ShreeDurgaChalisa"),
        DurgaScreenItem("श्री अम्बे जी की आरती", "ShreeAmbaJiKIAarti"),
        DurgaScreenItem("श्री देवी जी की आरती", "ShreeDeviJiKiAarti"),
        DurgaScreenItem("अर्गला स्तोत्रम", "ArgalaStrotam"),
        DurgaScreenItem("कीलक स्तोत्रम", "KilakStrotam"),
        DurgaScreenItem("अथ देवकवचम्", "AthDevaKvacham"),
        DurgaScreenItem("ब्रह्मादि शापविमोचनम्", "BrahmadiShapVimochanam"),
        DurgaScreenItem("सप्तशती न्यास:", "ShaptSatiNyashah"),
        DurgaScreenItem("ऋग्वेदोक्तं रात्रिसूक्तम्", "RigVedoktamRatriSuktam"),
        DurgaScreenItem("तन्त्रोक्तं रात्रिसूक्तम्", "TantroktamVedoktamRatriSuktam"),
        DurgaScreenItem("ऋग्वेदोक्तं देवीसूक्तम्", "RigVedyotamDeviSyuktam"),
        DurgaScreenItem("तन्त्रोक्तं देवीसूक्तम्", "TantrotamDeviSyuktam"),
        DurgaScreenItem("दुर्गा अष्टोत्तर शतनाम", "SHREEDURGAASTOTTARSATNAAMSTOTRAM"),
        DurgaScreenItem("क्षमा प्रार्थना", "SchamaPrathna")
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("माँ दुर्गा", fontWeight = FontWeight.ExtraBold, fontSize = 22.sp) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFFFFEBEE))
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFDFBF7))
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // 1. Portrait Header Image (9:16 ratio)
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(9f / 16f)
                        .padding(bottom = 8.dp),
                    shape = RoundedCornerShape(24.dp),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.kwkvhda551rmt0cwsnttjgmpyw),
                        contentDescription = "Durga Maa Portrait",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            // 2. The Alternating List
            itemsIndexed(durgaMaaItems) { index, item ->
                val isPink = index % 2 == 0
                val cardColor = if (isPink) Color(0xFFFCE4EC) else Color(0xFFE3F2FD)
                val accentColor = if (isPink) Color(0xFFC2185B) else Color(0xFF1976D2)

                DurgaSelectionCard(
                    item = item,
                    backgroundColor = cardColor,
                    textColor = accentColor,
                    onClick = { navController.navigate(item.route) }
                )
            }

            item { Spacer(modifier = Modifier.height(20.dp)) }
        }
    }
}

@Composable
fun DurgaSelectionCard(
    item: DurgaScreenItem,
    backgroundColor: Color,
    textColor: Color,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 22.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = textColor
            )
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = textColor.copy(alpha = 0.6f)
            )
        }
    }
}

data class DurgaScreenItem(val title: String, val route: String)