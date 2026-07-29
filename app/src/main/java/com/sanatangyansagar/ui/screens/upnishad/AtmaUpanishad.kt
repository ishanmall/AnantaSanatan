package com.sanatangyansagar.ui.screens.upnishad

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
data class AtmaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

// 2. Main Screen Composable
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AtmaUpanishadScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFBF7))
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                val shlokaNumber = query.toIntOrNull()
                // Validates if the number is between 1 and 3
                if (shlokaNumber != null && shlokaNumber in 1..3) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-3)") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(atmaShlokasList) { _, shloka ->
                AtmaShlokaCard(shloka = shloka)
            }
        }
    }
}

// 3. Shloka Card Composable
@Composable
fun AtmaShlokaCard(shloka: AtmaShloka) {
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
            Text(text = shloka.hindi, fontSize = 14.sp, lineHeight = 20.sp)
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "English Meaning:",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = shloka.english, fontSize = 14.sp, lineHeight = 20.sp)
        }
    }
}

// 4. Data List (Top-Level)
val atmaShlokasList: List<AtmaShloka> = listOf(
    AtmaShloka(
        id = 1,
        sanskrit = "अथ अङ्गिरास्त्रिविधः पुरुषोऽजायतात्मैवान्तरात्मा परमात्मा चेति । तत्र त्वक्चर्ममांसरोमाङ्गुष्ठान्यङ्गुल्यः पृष्ठवंशो नखगुल्फोदरनाभिमैढ्रकट्यूरु-कपोलश्रोत्रभ्रूललाटबाहुपार्श्वशिरोऽक्षयः । एष बाह्यात्मा नाम ॥ १ ॥",
        hindi = """
            महर्षि अङ्गिरा कहते हैं कि पुरुष (इंसान) वास्तव में तीन स्तरों पर उत्पन्न होता है।
            ये तीन स्तर हैं—बाह्य-आत्मा (शरीर), अंतरात्मा (मन/बुद्धि), और परमात्मा (शुद्ध चैतन्य)।
            बाह्य-आत्मा वह है जो त्वचा, चर्म, मांस, बाल, अँगूठे, उंगलियों और पीठ की हड्डी से बना है।
            नाखून, टखने, पेट, नाभि, कमर, जांघ, गाल, कान, भौंहें और ललाट भी इसी का हिस्सा हैं।
            हाथ, पसलियां, सिर और आँखें—ये सभी भौतिक अंग मिलकर 'बाह्य-आत्मा' कहलाते हैं।
            यह श्लोक शरीर विज्ञान (Anatomy) को आत्मा के सबसे सतही स्तर के रूप में परिभाषित करता है।
            हम जिसे अपना 'मैं' समझते हैं, वह अक्सर केवल यही हड्डियों और मांस का ढांचा होता है।
            उपनिषद हमें यह याद दिलाता है कि यह बाहरी रूप केवल एक आवरण (Cover) मात्र है।
            जैसे कपड़े बदलने से इंसान नहीं बदलता, वैसे ही शरीर के बदलाव से आत्मा नहीं बदलती।
            अध्यात्म की पहली सीढ़ी यह जानना है कि 'मैं यह भौतिक शरीर (बाह्य-आत्मा) नहीं हूँ'।
        """.trimIndent(),
        english = """
            Sage Angiras declares that the Person (Purusha) manifests in three distinct ways or layers.
            These three categories are the External Self, the Inner Self, and the Supreme Self.
            The 'External Self' (Bahyatma) consists of the skin, dermis, flesh, hair, thumbs, and fingers.
            It includes the spinal cord, nails, ankles, stomach, navel, waist, thighs, and cheeks.
            The ears, eyebrows, forehead, arms, ribs, head, and eyes are also parts of this layer.
            All these physical organs and skeletal structures together are named the External Self.
            This verse defines anatomy as the most superficial layer of human existence and identity.
            What we usually call 'I' is often just this temporary framework of bones and tissues.
            The Upanishad reminds us that this physical form is merely an outer covering or sheath.
            Just as changing clothes doesn't change the person, bodily changes don't affect the core.
            The first step in spirituality is realizing: 'I am not this physical body (Bahyatma)'.
        """.trimIndent()
    ),
    AtmaShloka(
        id = 2,
        sanskrit = "अथान्तरात्मा नाम पृथिवी सलिलमग्निर्वायुराकाशमिच्छाद्वेषसुखदुःखकाममोहविकल्पादिस्मृतिलिङ्ग उदात्तानुदात्तह्रस्वदीर्घप्लुतस्वरितखञ्जकुब्ज-बधिरमूकह्रस्वत्वगन्ध-रस-रूप-स्पर्श-शब्द-गुणव्यतिकरः । एषोऽन्तरात्मा नाम ॥ २ ॥",
        hindi = """
            अब 'अंतरात्मा' का वर्णन है जो पृथ्वी, जल, अग्नि, वायु और आकाश के सूक्ष्म अंशों से बना है।
            इसमें इच्छा, द्वेष, सुख, दुख, काम (वासना), मोह और कल्पना जैसे मानसिक गुण शामिल हैं।
            स्मृति (Memory), तर्क, और वाणी के विभिन्न स्वर (उदात्त, दीर्घ आदि) भी इसी के अंग हैं।
            सुनने की क्षमता, स्वाद, रूप, गंध और स्पर्श का अहसास करने वाला मन भी यही है।
            लंगड़ापन, बहरापन या गूंगापन जैसे विकार भी अंतरात्मा (सूक्ष्म शरीर) के स्तर पर ही होते हैं।
            यह श्लोक हमारे मनोवैज्ञानिक और सूक्ष्म शरीर (Subtle Body) की पूरी व्याख्या करता है।
            बाहरी शरीर के पीछे जो सोचने और महसूस करने वाली मशीन है, वह 'अंतरात्मा' कहलाती है।
            हमारी यादें और भावनाएं इसी परत में संचित रहती हैं जो एक जन्म से दूसरे में जाती हैं।
            भले ही यह शरीर से श्रेष्ठ है, लेकिन यह भी अंतिम सत्य नहीं है क्योंकि यह बदलता रहता है।
            साधक को शरीर के बाद अपने मन और विचारों (अंतरात्मा) को भी साक्षी भाव से देखना चाहिए।
        """.trimIndent(),
        english = """
            Now described is the 'Inner Self' (Antaratma), formed from the subtle elements of nature.
            It comprises desire, aversion, pleasure, pain, lust, delusion, and mental constructs.
            Memory, reasoning, and the various musical or vocal intonations belong to this layer.
            It is the mind that perceives taste, form, smell, touch, and sound through the senses.
            Conditionings like deafness, muteness, or physical deformities are perceived at this level.
            This verse provides a comprehensive map of our psychological and subtle energy body.
            The thinking and feeling machine operating behind the physical body is the Inner Self.
            Our memories and emotional patterns are stored in this sheath, traveling across births.
            Although superior to the body, it is still not the ultimate Truth as it is subject to change.
            A seeker must learn to observe even their thoughts and emotions (Antaratma) as a witness.
        """.trimIndent()
    ),
    AtmaShloka(
        id = 3,
        sanskrit = "अथ परमात्मा नाम योऽप्राणोऽमना अतीन्द्रियो निष्कलो निरञ्जनो निर्विकल्पो निराख्यातो निरुपाधिको निर्गुणो निष्प्रपञ्चो निरुत्थानो निर्लेपो निर्द्वन्द्वो निरालम्बो नीरोगो निष्क्रियो न जायते न म्रियते न शुष्यति न क्लिद्यति न दह्यते न कम्पते न भिद्यते न च्छिद्यते निर्गुणः साक्षीभूतः शुद्धो निरवयवात्मा केवलः सूक्ष्मो ममात्मा परमात्मा ॥ ३ ॥",
        hindi = """
            अब सबसे अंतिम और सर्वोच्च सत्य 'परमात्मा' का वर्णन किया जाता है।
            परमात्मा वह है जिसमें न प्राण है, न मन है, और जो सभी इंद्रियों से पूरी तरह परे (अतीन्द्रिय) है।
            वह कलारहित (निष्कलो), दाग-रहित (निरञ्जनो), विकार-रहित और बिना किसी नाम या उपाधि (निराख्यातो) के है।
            वह परम शुद्ध है—न पैदा होता है (न जायते), न मरता है (न म्रियते), न सूखता है, न गलता है और न ही आग उसे जला सकती है।
            उसे न तो काटा जा सकता है (न च्छिद्यते) और न ही भेदा जा सकता है; वह तीनों गुणों (सत्व, रज, तम) से परे 'निर्गुण' है।
            वह इस पूरे ब्रह्मांड का केवल एक अचल 'साक्षी' (Witness) मात्र है, जो पूरी तरह शुद्ध और अकेला (केवलः) है।
            बाहरी शरीर (बाह्य-आत्मा) मर जाता है, मन (अंतरात्मा) बदलता रहता है, लेकिन यह परमात्मा हमेशा अमर और स्थिर रहता है।
            अध्यात्म का अंतिम लक्ष्य इस बात का साक्षात् अनुभव करना है कि 'मैं शरीर या मन नहीं, बल्कि यही अमर परमात्मा हूँ'।
            जब साधक इस परम शून्यता और शुद्धता को अपने भीतर पा लेता है, तो उसके लिए जन्म-मरण का चक्र हमेशा के लिए समाप्त हो जाता है।
            यही आत्म-उपनिषद का सबसे महान और अंतिम रहस्य है।
        """.trimIndent(),
        english = """
            Now the absolute highest and ultimate truth, the 'Supreme Self' (Paramatma), is profoundly described.
            Paramatma is exactly that which possesses no physical breath, no restless mind, and exists infinitely beyond all senses (Atindriya).
            It is completely indivisible (Nishkala), flawlessly unstained (Niranjana), absolutely formless, and totally beyond all worldly titles or names.
            It is supremely pure—it is never born (Na jayate), never dies (Na mriyate), never dries up, never decays, and fire can absolutely never burn it.
            It can never be violently cut (Na chidyate) nor pierced; it is 'Nirguna', completely devoid of the three attributes (Sattva, Rajas, Tamas).
            It exists strictly as the motionless, unshakeable 'Witness' (Sakshi) of this entire massive cosmos, eternally pure and totally solitary (Kevala).
            The physical external body (Bahyatma) rots and dies, the internal mind (Antaratma) constantly fluctuates, but this Paramatma remains flawlessly immortal and static forever.
            The absolute final goal of spirituality is to directly experience the terrifying truth: 'I am not the body or mind, but strictly this immortal Paramatma'.
            When the seeker successfully discovers this supreme void and purity inside himself, the pathetic cycle of birth and death is permanently annihilated for him.
            This is the absolute greatest and final secret of the Atma Upanishad.
        """.trimIndent()
    )
)