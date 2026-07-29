package com.sanatangyansagar.ui.screens.DurgaMaa

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

// 1. Data Model
data class ShapVimochanShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

// 2. Main Screen Composable
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrahmadiShapVimochanamScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFBF7))
    ) {
        // Search Bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                val shlokaNumber = query.toIntOrNull()
                // Validates if the number is between 1 and 7
                if (shlokaNumber != null && shlokaNumber in 1..7) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-7)") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        // Shloka List
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(shapVimochanList) { _, shloka ->
                ShapVimochanShlokaCard(shloka = shloka)
            }
        }
    }
}

// 3. Shloka Card Composable
@Composable
fun ShapVimochanShlokaCard(shloka: ShapVimochanShloka) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Shloka ${shloka.id}",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(0xFFD84315)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = shloka.sanskrit,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "हिन्दी अर्थ:",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1565C0)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = shloka.hindi, fontSize = 14.sp, lineHeight = 22.sp)
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "English Meaning:",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = shloka.english, fontSize = 14.sp, lineHeight = 22.sp)
        }
    }
}

// 4. Data List (Exactly 7 Steps/Shlokas of Shapa Vimochanam)
val shapVimochanList: List<ShapVimochanShloka> = listOf(
    ShapVimochanShloka(
        id = 1,
        sanskrit = "ॐ ह्रीं श्रीं क्लीं श्रीं सप्तशति चण्डिके उत्कीलनं कुरु कुरु स्वाहा ॥",
        hindi = """
            ॐ, ह्रीं, श्रीं, क्लीं, श्रीं—इन बीज मन्त्रों के साथ मैं चण्डिका सप्तशती के उत्कीलन की प्रार्थना करता हूँ।
            'उत्कीलन' का अर्थ है उन आध्यात्मिक कीलों या अवरोधों को हटाना जो मन्त्रों की शक्ति को ढके हुए हैं।
            यह मन्त्र सप्तशती पाठ की ऊर्जा को मुक्त करने के लिए भगवान शिव की आज्ञा के समान है।
            बीज मन्त्रों का प्रयोग साधक की चेतना को उच्च आयामों से जोड़ने के लिए किया जाता है।
            इसके जप से पाठ में आने वाली अदृश्य बाधाएं दूर होती हैं और मन्त्र फलदायी बनते हैं।
            साधक माँ चण्डिका से आग्रह करता है कि वे ज्ञान के इस गुप्त भंडार के द्वार उसके लिए खोल दें।
        """.trimIndent(),
        english = """
            Om, Hreem, Shreem, Kleem, Shreem—with these seed mantras, I invoke the unlocking of the Saptashati.
            'Utkilanam' refers to removing the spiritual bolts that keep the mantra's powers hidden from the common eye.
            This mantra acts as a divine command to release the latent energy of the sacred text for the practitioner.
            The Beeja mantras (seed sounds) are used to align the seeker's consciousness with cosmic vibrations.
            Chanting this clears invisible hurdles and ensures the recitation yields its intended spiritual fruit.
            The seeker implores Mother Chandika to open the gates of this secret repository of wisdom.
        """.trimIndent()
    ),
    ShapVimochanShloka(
        id = 2,
        sanskrit = "ॐ ह्रीं श्रीं वशिष्ठशापविमुक्तायै ह्रीं श्रीं सप्तशति चण्डिकायै नमः ॥",
        hindi = """
            ॐ, ह्रीं, श्रीं—मैं उस चण्डिका सप्तशती को नमन करता हूँ जो महर्षि वशिष्ठ के शाप से मुक्त है।
            पौराणिक मान्यताओं के अनुसार, ऋषियों ने मन्त्रों के दुरुपयोग को रोकने के लिए उन पर नियंत्रण लगाया था।
            वशिष्ठ जी का शाप एक प्रकार का आध्यात्मिक अनुशासन है जिसे यह मन्त्र पूरी तरह से हटा देता है।
            बिना शाप-मुक्ति के मन्त्रों का प्रभाव क्षीण रहता है, इसलिए यह प्रक्रिया अत्यंत अनिवार्य मानी गई है।
            माँ चण्डिका का यह स्वरूप साधक को ऋषियों के अनुशासन के भीतर रखते हुए भी पूर्ण फल प्रदान करता है।
            यह श्लोक गुरु-शिष्य परंपरा और ऋषियों के प्रति सम्मान व्यक्त करते हुए कृपा की याचना करता है।
        """.trimIndent(),
        english = """
            Om, Hreem, Shreem—I bow to Mother Chandika Saptashati, now liberated from the curse of Sage Vashistha.
            According to tradition, great sages placed constraints on mantras to prevent their unethical exploitation.
            The curse of Vashistha represents a spiritual discipline that this specific mantra effectively dissolves.
            Without lifting these curses, the impact of the chants remains dormant or highly restricted.
            This form of Mother Chandika allows the seeker to receive results while remaining within lineage protocols.
            This verse expresses reverence for the sages while requesting the removal of all ancient restrictions.
        """.trimIndent()
    ),
    ShapVimochanShloka(
        id = 3,
        sanskrit = "ॐ ह्रीं श्रीं विश्वामित्रशापविमुक्तायै ह्रीं श्रीं सप्तशति चण्डिकायै नमः ॥",
        hindi = """
            ॐ, ह्रीं, श्रीं—मैं उस चण्डिका सप्तशती को प्रणाम करता हूँ जो महर्षि विश्वामित्र के शाप से मुक्त है।
            विश्वामित्र जी का शाप मन्त्रों की उग्रता और उनकी तीव्रता को नियंत्रित करने के लिए माना जाता है।
            यह मन्त्र उस तीव्रता को साधक के लिए सुलभ और कल्याणकारी बनाने के लिए अनिवार्य है।
            शाप-मुक्ति की यह क्रिया साधक के हृदय में विश्वास जगाती है कि माँ की शक्ति अब उस पर कृपा करेगी।
            माँ चण्डिका यहाँ बाधाओं को तोड़कर सत्य के प्रकाश को साधक के जीवन में प्रवेश करने देती हैं।
            यह प्रक्रिया सिद्ध करती है कि मन्त्रों का वास्तविक स्वामी केवल वह है जो श्रद्धा और विधि से चलता है।
        """.trimIndent(),
        english = """
            Om, Hreem, Shreem—I prostrate before Mother Chandika Saptashati, freed from the curse of Sage Vishvamitra.
            Vishvamitra’s curse is said to regulate the extreme intensity and fierce nature of these potent mantras.
            This chant is necessary to make that divine intensity accessible and beneficial for the common practitioner.
            The act of curse-removal instills faith that the Mother’s power will now shower grace upon the seeker.
            Mother Chandika here breaks through barriers, allowing the light of truth to enter the devotee's life.
            This process proves that the true master of mantras is the one who walks the path of faith and ritual.
        """.trimIndent()
    ),
    ShapVimochanShloka(
        id = 4,
        sanskrit = "ॐ ह्रीं श्रीं ब्रह्मशापविमुक्तायै ह्रीं श्रीं सप्तशति चण्डिकायै नमः ॥",
        hindi = """
            ॐ, ह्रीं, श्रीं—मैं उस चण्डिका सप्तशती को नमन करता हूँ जो स्वयं ब्रह्मा जी के शाप से मुक्त है।
            ब्रह्म-शाप का अर्थ है वह परम अवरोध जो सृष्टि के रचयिता द्वारा मन्त्रों की गोपनीयता हेतु लगाया गया।
            यह मन्त्र उस सर्वोच्च अवरोध को हटाकर साधक को माँ की परा-शक्ति से सीधे जुड़ने का मार्ग देता है।
            जब ब्रह्मा जी का शाप हट जाता है, तो सप्तशती का हर अक्षर साक्षात् जाग्रत देवता बन जाता है।
            यह साधक को ब्रह्मांडीय चेतना के उच्च स्तर पर ले जाने वाली एक अत्यंत प्रभावशाली प्रक्रिया है।
            माँ चण्डिका का आशीर्वाद अब किसी भी ब्रह्मा-दण्ड या शाप से बाधित नहीं हो सकता।
        """.trimIndent(),
        english = """
            Om, Hreem, Shreem—I bow to Mother Chandika Saptashati, liberated from the curse of Lord Brahma.
            The curse of Brahma implies the ultimate barrier placed by the Creator to safeguard the secrecy of mantras.
            This mantra removes that supreme obstacle, allowing the seeker to connect directly with the Mother’s power.
            Once Brahma’s curse is lifted, every syllable of the Saptashati becomes a living, awakened deity.
            This is a highly potent process that elevates the practitioner to higher levels of cosmic consciousness.
            Mother Chandika’s blessing can no longer be hindered by any creative mandate or ancient cosmic seal.
        """.trimIndent()
    ),
    ShapVimochanShloka(
        id = 5,
        sanskrit = "ॐ श्रीं श्रीं क्लीं श्रीं ह्रीं सप्तशति चण्डिके शापोद्धारं कुरु कुरु स्वाहा ॥",
        hindi = """
            ॐ, श्रीं, श्रीं, क्लीं, श्रीं, ह्रीं—इन महान बीज मन्त्रों द्वारा मैं सप्तशती के समस्त शापों का उद्धार करता हूँ।
            'शापोद्धार' का अर्थ है शाप रूपी बोझ को पूरी तरह से उतार देना और मन्त्रों को पूर्ण शुद्ध करना।
            यह श्लोक एक सामूहिक शुद्धि (Mass Purification) की तरह है जो पिछले सभी शापों के अवशेष मिटा देता है।
            इसके जप से सप्तशती का पाठ अमृत के समान पवित्र और फल देने वाला बन जाता है।
            साधक यहाँ पूरी तरह माँ के चरणों में समर्पित होकर अपनी आध्यात्मिक बाधाओं के अंत की घोषणा करता है।
            स्वाहा शब्द के साथ हम अपने अज्ञान और अयोग्यता की आहुति माँ की दिव्य अग्नि में देते हैं।
        """.trimIndent(),
        english = """
            Om, Shreem, Shreem, Kleem, Shreem, Hreem—through these great seeds, I uplift the Saptashati from all curses.
            'Shapoddhara' means to completely lift the burden of curses and fully purify the sacred mantras.
            This verse acts as a mass purification, erasing the lingering remains of all previous ancient restrictions.
            Chanting this makes the Saptashati recitation as pure and life-giving as divine nectar.
            The seeker, fully surrendered at the Mother’s feet, declares the end of all his spiritual obstructions.
            With the word 'Svaha', we offer our ignorance and inadequacies into the divine fire of the Mother.
        """.trimIndent()
    ),
    ShapVimochanShloka(
        id = 6,
        sanskrit = "ॐ ह्रीं श्रीं क्लीं श्रीं सप्तशति चण्डिके मन्त्रशक्तिं प्रकाशय प्रकाशय स्वाहा ॥",
        hindi = """
            हे माँ सप्तशती चण्डिके! इन दिव्य बीजों के प्रभाव से मेरे पाठ की मन्त्र-शक्ति को प्रकाशित करें।
            'प्रकाशय' का अर्थ है उस छिपी हुई अलौकिक शक्ति को मेरे हृदय और जीवन में साक्षात् प्रकट करना।
            जब शाप हट जाते हैं, तब मन्त्रों का प्रकाश साधक के भीतर ज्ञान और ऊर्जा बनकर फूट पड़ता है।
            यह श्लोक माँ से प्रार्थना है कि वे मन्त्रों को केवल शब्द न रहने दें, बल्कि उन्हें जाग्रत शक्ति बना दें।
            जैसे सूर्य के उदय होने पर अंधेरा मिटता है, वैसे ही मन्त्र शक्ति के प्रकाश से अज्ञान का नाश होता है।
            यह प्रार्थना साधक के पाठ को एक यांत्रिक क्रिया से बदलकर एक जीवंत अनुभव में रूपांतरित कर देती है।
        """.trimIndent(),
        english = """
            O Mother Saptashati Chandika! By the power of these divine seeds, illuminate the mantra-force within my path.
            'Prakashaya' means to manifest that hidden supernatural power directly within the seeker's heart and life.
            Once the curses are gone, the radiance of the mantras bursts forth as wisdom and raw energy inside.
            This verse is a plea to the Mother to ensure the mantras are not just dead words, but living forces.
            Just as the sun’s rise dispels darkness, the light of mantra-shakti annihilates all inner ignorance.
            This prayer transforms the recitation from a mechanical act into a vibrant, living spiritual experience.
        """.trimIndent()
    ),
    ShapVimochanShloka(
        id = 7,
        sanskrit = "इति ब्रह्मादि शापविमोचनं सम्पूर्णम् ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
        hindi = """
            (समापन): इस प्रकार ब्रह्मा आदि देवताओं और ऋषियों द्वारा दिए गए शापों के विमोचन की प्रक्रिया पूर्ण हुई।
            अब यह सप्तशती पाठ सभी बंधनों से मुक्त है और साधक को मनचाहा फल देने के लिए तैयार है।
            ॐ शांति, शांति, शांति!—यह पाठ साधक के शारीरिक, मानसिक और आध्यात्मिक ताप को शांत करने वाला है।
            यहाँ शाप-मुक्ति का कार्य सिद्ध हुआ, जिससे साधक के भीतर गहरा आत्मविश्वास और भक्ति जाग्रत होती है।
            माँ दुर्गा की कृपा अब बिना किसी रुकावट के भक्त पर एक अखंड धारा की तरह प्रवाहित होने लगेगी।
            यह प्रक्रिया हमें सिखाती है कि विनम्रता और सही विधि ही ईश्वरीय कृपा पाने का सबसे सरल मार्ग है।
        """.trimIndent(),
        english = """
            (Conclusion): Thus ends the process of liberating the text from the curses of Brahma and other deities.
            The Saptashati is now free from all shackles and ready to grant the seeker his desired spiritual fruits.
            Om Peace, Peace, Peace!—this chant stills the physical, mental, and spiritual agitations of the devotee.
            The mission of curse-liberation is perfected here, awakening deep self-confidence and devotion within.
            The grace of Mother Durga will now flow towards the devotee as an uninterrupted, divine stream.
            This entire process teaches us that humility and proper method are the simplest ways to earn divine grace.
        """.trimIndent()
    )
)