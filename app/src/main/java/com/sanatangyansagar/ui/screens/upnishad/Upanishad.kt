package com.sanatangyansagar.ui.screens.upnishad

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
fun UpanishadScreen(navController: NavController) {
    // Shared Pink and Blue Gradient
    val pinkBlueGradient = remember {
        Brush.horizontalGradient(
            colors = listOf(Color(0xFFFFD9E8), Color(0xFFD9EFFF))
        )
    }
    val upanishadsList = remember {
        listOf(
            UpanishadItem("Adhyatma Upanishad", Screens.AdhyatmaUpanishad.route),
            UpanishadItem("Advaita Upanishad", Screens.AdvaitaUpanishad.route),
            UpanishadItem("Adwayataraka Upanishad", Screens.AdwayatarakaUpanishad.route),
            UpanishadItem("Aitareya Upanishad", Screens.AitareyaUpanishad.route),
            UpanishadItem("Akshi Upanishad", Screens.AkshiUpanishad.route),
            UpanishadItem("Amritabindu Upanishad", Screens.AmritabinduUpanishad.route),
            UpanishadItem("AmritaNada Upanishad", Screens.AmritaNadaUpanishad.route),
            UpanishadItem("Annapurna Upanishad", Screens.AnnapurnaUpanishad.route),
            UpanishadItem("Aruni Upanishad", Screens.AruniUpanishad.route),
            UpanishadItem("Atharvashikha Upanishad", Screens.AtharvashikhaUpanishad.route),
            UpanishadItem("Atharvashiras Upanishad", Screens.AtharvashirasUpanishad.route),
            UpanishadItem("Atmaprabodha Upanishad", Screens.AtmaprabodhaUpanishad.route),
            UpanishadItem("Atma Upanishad", Screens.AtmaUpanishad.route),
            UpanishadItem("Avadhuta Upanishad", Screens.AvadhutaUpanishad.route),
            UpanishadItem("Avyakta Upanishad", Screens.AvyaktaUpanishad.route),
            UpanishadItem("Bahvricha Upanishad", Screens.BahvrichaUpanishad.route),
            UpanishadItem("Bhikshuka Upanishad", Screens.BhikshukaUpanishad.route),
            UpanishadItem("Brahma Upanishad", Screens.BrahmaUpanishad.route),
            UpanishadItem("Brahmabindu Upanishad", Screens.BrahmabinduUpanishad.route),
            UpanishadItem("Brahmopanishad", Screens.Brahmopanishad.route),
            UpanishadItem("BrihadJabala Upanishad", Screens.BrihadJabalaUpanishad.route),
            UpanishadItem("Dakshinamurti Upanishad", Screens.DakshinamurtiUpanishad.route),
            UpanishadItem("Dattatreya Upanishad", Screens.DattatreyaUpanishad.route),
            UpanishadItem("Devi Upanishad", Screens.DeviUpanishad.route),
            UpanishadItem("Dhyana Upanishad", Screens.DhyanaUpanishad.route),
            UpanishadItem("Dhyanabindu Upanishad", Screens.DhyanabinduUpanishad.route),
            UpanishadItem("Ekakshara Upanishad", Screens.EkaksharaUpanishad.route),
            UpanishadItem("Ganapati Atharvashirsha", Screens.GanapatiAtharvashirsha.route),
            UpanishadItem("Ganesha Upanishad", Screens.GaneshaUpanishad.route),
            UpanishadItem("Garbha Upanishad", Screens.GarbhaUpanishad.route),
            UpanishadItem("Garuda Upanishad", Screens.GarudaUpanishad.route),
            UpanishadItem("Gayatri Upanishad", Screens.GayatriUpanishad.route),
            UpanishadItem("Hamsa Upanishad", Screens.HamsaUpanishad.route),
            UpanishadItem("Hayagriva Upanishad", Screens.HayagrivaUpanishad.route),
            UpanishadItem("Isha Upanishad", Screens.IshaUpanishad.route),
            UpanishadItem("Jabala Upanishad", Screens.JabalaUpanishad.route),
            UpanishadItem("Kaivalya Upanishad", Screens.KaivalyaUpanishad.route),
            UpanishadItem("Kalagnirudra Upanishad", Screens.KalagnirudraUpanishad.route),
            UpanishadItem("KaliSantarana Upanishad", Screens.KaliSantaranaUpanishad.route),
            UpanishadItem("Katha Upanishad", Screens.KathaUpanishad.route),
            UpanishadItem("Kena Upanishad", Screens.KenaUpanishad.route),
            UpanishadItem("Krishna Upanishad", Screens.KrishnaUpanishad.route),
            UpanishadItem("Kundika Upanishad", Screens.KundikaUpanishad.route),
            UpanishadItem("Maha Upanishad", Screens.MahaUpanishad.route),
            UpanishadItem("Mahavakya Upanishad", Screens.MahavakyaUpanishad.route),
            UpanishadItem("Maitreya Upanishad", Screens.MaitreyaUpanishad.route),
            UpanishadItem("Maitreyi Upanishad", Screens.MaitreyiUpanishad.route),
            UpanishadItem("Mandukya Upanishad", Screens.MandukyaUpanishad.route),
            UpanishadItem("Mudgala Upanishad", Screens.MudgalaUpanishad.route),
            UpanishadItem("Mundaka Upanishad", Screens.MundakaUpanishad.route),
            UpanishadItem("Nadabindu Upanishad", Screens.NadabinduUpanishad.route),
            UpanishadItem("Narayan Upanishad", Screens.NarayanUpanishad.route),
            UpanishadItem("Niralamba Upanishad", Screens.NiralambaUpanishad.route),
            UpanishadItem("Nirvana Upanishad", Screens.NirvanaUpanishad.route),
            UpanishadItem("Paingala Upanishad", Screens.PaingalaUpanishad.route),
            UpanishadItem("Panchabrahma Upanishad", Screens.PanchabrahmaUpanishad.route),
            UpanishadItem("Paramahamsa Upanishad", Screens.ParamahamsaUpanishad.route),
            UpanishadItem("Parabrahma Upanishad", Screens.ParabrahmaUpanishad.route), // Added
            UpanishadItem("Pashupata Upanishad", Screens.PashupataUpanishad.route),
            UpanishadItem("Pranagnihotra Upanishad", Screens.PranagnihotraUpanishad.route),
            UpanishadItem("Prashna Upanishad", Screens.PrashnaUpanishad.route),
            UpanishadItem("Ram Rahasya Upanishad", Screens.RamRahasyaUpanishad.route),
            UpanishadItem("RudraHridaya Upanishad", Screens.RudraHridayaUpanishad.route),
            UpanishadItem("RudrakshaJabala Upanishad", Screens.RudrakshaJabalaUpanishad.route),
            UpanishadItem("Sannyasa Upanishad", Screens.SannyasaUpanishad.route),
            UpanishadItem("Sariraka Upanishad", Screens.SarirakaUpanishad.route),
            UpanishadItem("Sarvasara Upanishad", Screens.SarvasaraUpanishad.route),
            UpanishadItem("SaubhagyaLakshmi Upanishad", Screens.SaubhagyaLakshmiUpanishad.route),
            UpanishadItem("Savitri Upanishad", Screens.SavitriUpanishad.route),
            UpanishadItem("Shatyayaniya Upanishad", Screens.ShatyayaniyaUpanishad.route),
            UpanishadItem("Sharabha Upanishad", Screens.SharabhaUpanishad.route),
            UpanishadItem("Shukarahasya Upanishad", Screens.ShukarahasyaUpanishad.route), // Added
            UpanishadItem("Shvetashvatara Upanishad", Screens.ShvetashvataraUpanishad.route),
            UpanishadItem("Sita Upanishad", Screens.SitaUpanishad.route),
            UpanishadItem("Skanda Upanishad", Screens.SkandaUpanishad.route),
            UpanishadItem("Subala Upanishad", Screens.SubalaUpanishad.route),
            UpanishadItem("Surya Upanishad", Screens.SuryaUpanishad.route),
            UpanishadItem("Taittiriya Upanishad", Screens.TaittiriyaUpanishad.route),
            UpanishadItem("Tarasara Upanishad", Screens.TarasaraUpanishad.route),
            UpanishadItem("Tejobindu Upanishad", Screens.TejobinduUpanishad.route),
            UpanishadItem("Tripura Upanishad", Screens.TripuraUpanishad.route),
            UpanishadItem("Tripuratapini Upanishad", Screens.TripuratapiniUpanishad.route),
            UpanishadItem("Turiyatita Upanishad", Screens.TuriyatitaUpanishad.route),
            UpanishadItem("Vajrasuchi Upanishad", Screens.VajrasuchiUpanishad.route),
            UpanishadItem("Vasudeva Upanishad", Screens.VasudevaUpanishad.route)
        )
    }

    Scaffold(
        containerColor = Color(0xFFF8F9FA),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("SANATAN GYAN SAGAR", fontWeight = FontWeight.ExtraBold, color = Color(0xFF1A237E), fontSize = 18.sp)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back", tint = Color(0xFF1A237E))
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.White)
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 1. HEADER IMAGE SECTION (Restored to 9:16)
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(9f / 16f) // Full Portrait Ratio
                            .clip(RoundedCornerShape(24.dp))
                            .border(1.dp, Color(0xFF1A237E).copy(alpha = 0.1f), RoundedCornerShape(24.dp))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable._en2kda5txrmy0cwsj08pbhpsm),
                            contentDescription = "Ancient Upanishads",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        "ॐ शान्ति",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF1A237E)
                    )
                }
            }

            // 2. Importance Card (Premium Navy)
            item { UpanishadImportanceCard() }

            // 3. Section Header
            item {
                Text(
                    text = "EXPLORE SCRIPTURES",
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Gray,
                    letterSpacing = 1.2.sp,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            // 4. Upanishad List Items
            items(upanishadsList) { upanishad ->
                UpanishadItemCard(upanishad, pinkBlueGradient) {
                    navController.navigate(upanishad.route)
                }
            }
        }
    }
}

@Composable
fun UpanishadItemCard(
    item: UpanishadItem,
    gradient: Brush,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp) // Slightly shorter now that subtitle is gone
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

                Text(
                    text = item.title,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF1A237E),
                    fontSize = 17.sp,
                    modifier = Modifier.weight(1f)
                )

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
fun UpanishadImportanceCard() {
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
                "भारतीय दर्शन और संस्कृति के दिव्य आधार स्तंभ।",
                "आत्मा और परमात्मा की एकता का साक्षात् बोध।",
                "अज्ञान का नाश और चित्त की परम शुद्धि।",
                "ऋषियों द्वारा प्राप्त मोक्ष प्रदान करने वाली परा-विद्या।"
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

data class UpanishadItem(
    val title: String,
    val route: Any
)