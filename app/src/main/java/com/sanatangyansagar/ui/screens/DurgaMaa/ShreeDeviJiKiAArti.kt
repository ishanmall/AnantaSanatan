package com.sanatangyansagar.ui.screens.DurgaMaa

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShreeDeviJiKiAartiScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFBF7))
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Main Header
                Text(
                    text = "श्री देवी जी की आरती",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp,
                    color = Color(0xFFD84315),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // 1. AARTI LYRICS (HINDI)
                Text(
                    text = "अम्बे तू है जगदम्बे काली, जय दुर्गे खप्पर वाली ।\n" +
                            "तेरे ही गुण गावें भारती, ओ मैया हम सब उतारें तेरी आरती ॥\n\n" +
                            "तेरे भक्त जनों पर माता भीड़ पड़ी है भारी ।\n" +
                            "दानव दल पर टूट पड़ो माँ करके सिंह सवारी ॥\n" +
                            "सौ-सौ सिंहों से तू बलशाली, अष्ट भुजाओं वाली ।\n" +
                            "दुष्टों को तू ही ललकारती, ओ मैया हम सब उतारें तेरी आरती ॥\n\n" +
                            "माँ बेटे का है इस जग में बड़ा ही निर्मल नाता ।\n" +
                            "पूत कपूत सुने हैं पर ना माता सुनी कुमाता ॥\n" +
                            "सब पर करुणा दर्शाने वाली, अमृत बरसाने वाली ।\n" +
                            "दुखियों के दुखड़े निवारती, ओ मैया हम सब उतारें तेरी आरती ॥\n\n" +
                            "नहीं मांगते धन और दौलत, न चांदी न सोना ।\n" +
                            "हम तो मांगें तेरे चरणों में छोटा सा कोना ॥\n" +
                            "सबकी बिगड़ी बनाने वाली, लाज बचाने वाली ।\n" +
                            "सतियों के सत को संवारती, ओ मैया हम सब उतारें तेरी आरती ॥\n\n" +
                            "चरण शरण में खड़े तुम्हारी, ले पूजा की थाली ।\n" +
                            "वरद हस्त सर पर रख दो माँ, संकट हरने वाली ॥\n" +
                            "माँ भर दो झोली खाली, ओ री मैया झोली खाली ।\n" +
                            "भक्तों की नैया तू ही तारती, ओ मैया हम सब उतारें तेरी आरती ॥",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black,
                    lineHeight = 28.sp
                )

                HorizontalDivider(color = Color.LightGray, thickness = 1.dp)

                // 2. HINDI MEANING SECTION
                Text(
                    text = "हिन्दी अर्थ:",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp,
                    color = Color(0xFF1565C0)
                )

                Text(
                    text = "हे माता अम्बे! आप ही आदि-शक्ति जगदम्बा और महाकाली हैं। दुष्टों का संहार करने वाली माता दुर्गा, आपकी जय हो। पूरी पृथ्वी और देवगण आपकी महिमा गाते हैं। हे माता! आपके भक्तों पर जब भी संकट आता है, आप सिंह पर सवार होकर शत्रुओं का नाश करती हैं।\n\n" +
                            "संसार में माँ-बेटे का रिश्ता सबसे पवित्र है; पुत्र बुरा हो सकता है पर माँ कभी दयाहीन नहीं होती। हम आपसे धन या सोना नहीं मांगते, बस आपके चरणों में थोड़ी सी जगह मांगते हैं। आप सबकी लाज रखने वाली और बिगड़े काम बनाने वाली हैं। हम पूजा की थाली लेकर खड़े हैं, अपनी कृपा से हमारे जीवन के संकट हर लें।",
                    fontSize = 16.sp,
                    color = Color(0xFF424242),
                    lineHeight = 24.sp
                )

                HorizontalDivider(color = Color.LightGray, thickness = 1.dp)

                // 3. ENGLISH LINE-BY-LINE TRANSLATION
                Text(
                    text = "English Translation:",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp,
                    color = Color(0xFF2E7D32)
                )

                Text(
                    text = "Ambe Tu Hai Jagdambe Kali | Jai Durge Khappar Wali\n" +
                            "O Mother Ambe! You are the Mother of the Universe and the fierce Kali. Victory to You, O Durga, who carries the skull-bowl.\n\n" +
                            "Tere Hi Gun Gaavein Bharati | O Maiya Hum Sab Utaarein Teri Aarti\n" +
                            "All of creation sings Your praises; O Mother, we all perform Your sacred Aarti.\n\n" +
                            "Tere Bhakt Jano Par Mata | Bheed Padi Hai Bhaari\n" +
                            "O Mother! Your devotees are surrounded by heavy troubles and crises.\n\n" +
                            "Danav Dal Par Toot Pado Maa | Karke Singh Sawari\n" +
                            "Manifest now, riding Your lion, and pounce upon the demonic forces to destroy them.\n\n" +
                            "Sau-Sau Singho Se Tu Balshali | Asht Bhujaon Wali\n" +
                            "You are more powerful than a hundred lions, the one with eight mighty arms.\n\n" +
                            "Maa Bete Ka Hai Is Jag Mein | Bada Hi Nirmal Naata\n" +
                            "In this world, the bond between a mother and son is the most pure and sacred.\n\n" +
                            "Poot Kapoot Sune Hain Par Na | Mata Suni Kumata\n" +
                            "We have heard of bad sons, but never have we heard of a mother who is heartless toward her child.\n\n" +
                            "Nahi Maangte Dhan Aur Daulat | Na Chaandi Na Sona\n" +
                            "We do not ask for worldly wealth, nor do we ask for silver or gold.\n\n" +
                            "Hum To Maangein Tere Charano Mein | Chhota Sa Kona\n" +
                            "We only beg for a small corner at Your divine and holy feet.\n\n" +
                            "Sabki Bigdi Banane Wali | Laj Bachane Wali\n" +
                            "You are the one who fixes what is broken and protects the dignity of everyone.\n\n" +
                            "Charan Sharan Mein Khade Tumhari | Le Pooja Ki Thaali\n" +
                            "We stand in the shelter of Your feet, carrying the plate of worship.\n\n" +
                            "Varad Hast Sar Par Rakh Do Maa | Sankat Harne Wali\n" +
                            "Place Your hand of blessing upon our heads, O Mother, You who remove all dangers.\n\n" +
                            "Bhakto Ki Naiya Tu Hi Taarti | O Maiya Hum Sab Utaarein Teri Aarti\n" +
                            "Only You can steer the boat of Your devotees across the ocean of life; we perform Your Aarti.",
                    fontSize = 15.sp,
                    color = Color(0xFF424242),
                    lineHeight = 22.sp
                )
            }
        }
    }
}