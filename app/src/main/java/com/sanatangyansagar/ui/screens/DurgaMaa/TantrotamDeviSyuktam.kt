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
data class TantroktamDeviShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

// 2. Main Screen Composable
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TantroktamDeviSuktamScreen() {
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
                // Validates if the number is between 1 and 28
                if (shlokaNumber != null && shlokaNumber in 1..28) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Verse Number (1-28)") },
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
            itemsIndexed(tantroktamDeviList) { _, shloka ->
                DeviSuktaCard(shloka = shloka)
            }
        }
    }
}

// 3. Shloka Card Composable
@Composable
fun DeviSuktaCard(shloka: TantroktamDeviShloka) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Verse ${shloka.id}",
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

// 4. Data List (Exactly 28 Sections for Tantroktam Devi Suktam)
val tantroktamDeviList: List<TantroktamDeviShloka> = listOf(
    TantroktamDeviShloka(
        id = 1,
        sanskrit = "नमो देव्यै महादेव्यै शिवायै सततं नमः । नमः प्रकृत्यै भद्रायै नियताः प्रणताः स्म ताम् ॥ १ ॥",
        hindi = """
            देवी को नमस्कार है, महादेवी को नमस्कार है। कल्याणमयी शिवा को सर्वदा नमस्कार है।
            प्रकृति और भद्रा (मंगलमयी) देवी को नमस्कार है। हम नियमपूर्वक उन्हें प्रणाम करते हैं।
            यह स्तोत्र का मंगलाचरण है, जहाँ देवता माँ के परम पावन और अजेय स्वरूप की वंदना करते हैं।
            शिवा होने के कारण वे ही समस्त शुभता का आधार हैं और प्रकृति होने के कारण वे ही सृष्टि का विस्तार हैं।
            नियमपूर्वक प्रणाम करने का अर्थ है माँ के प्रति हमारा अनुशासन और अटूट श्रद्धा।
            यह श्लोक साधक के हृदय में भक्ति की नींव रखता है और उसे उच्च शक्तियों से जोड़ता है।
        """.trimIndent(),
        english = """
            Salutations to the Goddess, to the Great Goddess! Salutations always to Shiva, the Auspicious One.
            Salutations to Prakriti (Nature) and Bhadra (the Gentle One). We bow to Her with absolute resolve.
            This is the opening of the hymn where deities praise the Mother's most holy and invincible form.
            As Shiva, She is the foundation of all goodness; as Prakriti, She is the expansion of the universe.
            Bowing with resolve implies our discipline and unwavering faith toward the Divine Mother.
            This verse lays the foundation of devotion in the seeker's heart and connects them to higher powers.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 2,
        sanskrit = "रौद्रायै नमो नित्यायै गौर्यै धात्र्यै नमो नमः । ज्योत्स्नायै चेन्दुरूपिण्यै सुखायै सततं नमः ॥ २ ॥",
        hindi = """
            भयानक (रौद्र) रूप वाली और नित्य रहने वाली देवी को नमस्कार है। गौरी और धात्री (पालन करने वाली) को बार-बार नमस्कार है।
            चंद्रमा के समान प्रकाश देने वाली, सुख और आनंद के स्वरूप वाली माँ को निरंतर प्रणाम है।
            माँ जहाँ दुष्टों के लिए रौद्र हैं, वहीं अपने भक्तों के लिए चंद्रमा की चाँदनी जैसी सुखद हैं।
            वे धात्री हैं—यानी पूरे ब्रह्मांड का पालन-पोषण एक माँ की ममता के साथ करती हैं।
            ज्योति और सुख माँ के वे गुण हैं जो हमारे जीवन के गहरे अंधकार को मिटाकर शांति भर देते हैं।
            यह श्लोक माँ के विपरीत गुणों—संहार और पालन—के अद्भुत संतुलन को दर्शाता है।
        """.trimIndent(),
        english = """
            Salutations to Her who is fierce (Raudra) and eternal! Salutations again and again to Gauri and Dhatri.
            Salutations always to the Mother who is like moonlight, providing happiness and absolute bliss.
            While She is fierce toward the wicked, She is as pleasant as moonlight for Her true devotees.
            She is Dhatri—the one who nourishes and sustains the entire cosmos with a mother's love.
            Radiance and Bliss are the attributes of the Mother that erase deep darkness and fill life with peace.
            This verse illustrates the marvelous balance between Her opposing qualities of destruction and preservation.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 3,
        sanskrit = "कल्याण्यै प्रणतां वृद्धयै सिद्ध्यै कुर्मो नमो नमः । नैर्ऋत्यै भूभृतां लक्ष्म्यै शर्वाण्यै ते नमो नमः ॥ ३ ॥",
        hindi = """
            कल्याण करने वाली, वृद्धि (उन्नति) और सिद्धि (पूर्णता) प्रदान करने वाली देवी को हम प्रणाम करते हैं।
            विपत्ति (नैर्ऋति), राजाओं की लक्ष्मी और भगवान शिव की पत्नी शर्वाणी को बार-बार नमस्कार है।
            सिद्धि और वृद्धि माँ की वे शक्तियां हैं जो साधक को भौतिक और आध्यात्मिक सफलता दिलाती हैं।
            माँ केवल सुख में ही नहीं, बल्कि 'नैर्ऋति' (दुख/मृत्यु) के रूप में भी सत्य का बोध कराती हैं।
            लक्ष्मी के रूप में वे ऐश्वर्य प्रदान करती हैं और शर्वाणी के रूप में वे ही परम ज्ञान की दात्री हैं।
            यह श्लोक माँ की व्याप्ति को जीवन के हर उतार-चढ़ाव और हर सफलता के पीछे स्थापित करता है।
        """.trimIndent(),
        english = """
            We bow to the Goddess who bestows welfare, growth (Vriddhi), and absolute perfection (Siddhi).
            Salutations again and again to Nairriti (Misfortune/Death), to the Lakshmi of kings, and to Sharvani.
            Siddhi and Vriddhi are the Mother's powers that grant the seeker both material and spiritual success.
            The Mother manifests not just in joy, but also as 'Nairriti' to remind us of the transient nature of life.
            As Lakshmi, She grants opulence, and as Sharvani (Shiva's consort), She is the giver of supreme wisdom.
            This verse establishes Her presence behind every rise and fall, and every success in human life.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 4,
        sanskrit = "दुर्गायै दुर्गपारायै सारायै सर्वकारिण्यै । ख्यात्यै तथैव कृष्णायै धूम्रायै सततं नमः ॥ ४ ॥",
        hindi = """
            दुर्गा (कठिनाइयों को दूर करने वाली), दुर्गपारा (संकटों से पार लगाने वाली) और सबकी मूल शक्ति को नमस्कार है।
            प्रसिद्धि (ख्याति), कृष्ण और धूम्र (धुंधले) वर्ण वाली माँ को निरंतर नमस्कार है।
            'दुर्गपारा' का अर्थ है वह शक्ति जो हमें भवसागर के थपेड़ों से सुरक्षित किनारे तक पहुँचाती है।
            माँ केवल सुंदर रूपों में ही नहीं, बल्कि धूम्र (धुआं) जैसे रहस्यमयी रूपों में भी व्याप्त हैं।
            संसार में जो भी 'ख्याति' या नाम है, वह वास्तव में माँ की ही चेतना का एक छोटा सा अंश है।
            यह श्लोक माँ की उन शक्तियों की वंदना करता है जो हमें कठिन से कठिन परिस्थितियों में रास्ता दिखाती हैं।
        """.trimIndent(),
        english = """
            Salutations to Durga (Destroyer of difficulties), Durgapara (Who carries us across crises), and the Primal Cause.
            Salutations always to the Mother who is Fame (Khyati), dark-hued (Krishna), and smoke-colored (Dhumra).
            'Durgapara' refers to the energy that safely delivers us to the shore across the ocean of existence.
            The Mother manifests not just in beautiful forms, but also in mysterious forms like smoke (Dhumra).
            Any 'Khyati' or fame existing in the world is actually a tiny fragment of Her vast consciousness.
            This verse praises the Mother's powers that guide us through the most difficult and trying circumstances.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 5,
        sanskrit = "अतिसौम्यातिरौद्रायै नतास्तस्यै नमो नमः । नमो जगत्प्रतिष्ठायै देव्यै कृत्यै नमो नमः ॥ ५ ॥",
        hindi = """
            जो अत्यंत सौम्य (कोमल) भी हैं और अत्यंत रौद्र (भयानक) भी, उन देवी को बार-बार नमस्कार है।
            जगत की आधारशिला (प्रतिष्ठा) और कर्म (कृति) स्वरूप वाली देवी को बार-बार प्रणाम है।
            माँ का कोमल रूप भक्तों को शांति देता है, जबकि उनका भयानक रूप अधर्म का विनाश करता है।
            वे ही 'कृति' हैं—यानी संसार में होने वाली हर क्रिया और हर सृजन उन्हीं की शक्ति से संभव है।
            संसार जहाँ टिका है, वह 'प्रतिष्ठा' (स्थिरता) भी साक्षात् माँ दुर्गा का ही स्वरूप है।
            यह श्लोक हमें याद दिलाता है कि माँ ही इस दृश्य और अदृश्य ब्रह्मांड की असली शक्ति और आधार हैं।
        """.trimIndent(),
        english = """
            Salutations again and again to the Goddess who is exceedingly gentle and exceedingly fierce!
            Salutations to the Goddess who is the foundation of the world (Pratishtha) and Action (Kriti) itself.
            Her gentle form grants peace to devotees, while Her fierce form annihilates unrighteousness.
            She is 'Kriti'—meaning every action and every creation in the world is possible only through Her power.
            The very stability (Pratishtha) on which the world rests is a direct manifestation of Mother Durga.
            This verse reminds us that the Mother is the actual power and foundation of this visible and invisible universe.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 6,
        sanskrit = "या देवी सर्वभूतेषु विष्णुमायेति शब्दिता । नमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ ६ ॥",
        hindi = """
            जो देवी समस्त प्राणियों में 'विष्णुमाया' के नाम से कही जाती हैं, उन्हें बार-बार नमस्कार है।
            विष्णुमाया वह शक्ति है जो इस संसार के खेल (लीला) को संभव बनाती है और हमें मोह में बाँधती है।
            लेकिन जब हम उन्हें नमन करते हैं, तो वही माया ज्ञान बनकर हमें मुक्त भी करती है।
            यह 'नमस्तस्यै' की श्रृंखला यहाँ से शुरू होती है, जो माँ की सर्वव्यापकता को सिद्ध करती है।
            प्राणियों के भीतर जो भी आकर्षण और जीवन की ललक है, वह माँ की इसी माया का प्रभाव है।
            साधक यहाँ माँ के उस रहस्यमयी प्रभाव को स्वीकार करता है जो पूरे ब्रह्मांड को संचालित करता है।
        """.trimIndent(),
        english = """
            Salutations again and again to the Goddess who in all beings is called 'Vishnumaya'.
            Vishnumaya is the power that makes the play (Lila) of this world possible and binds us in illusion.
            However, when we bow to Her, that same Maya transforms into wisdom and liberates us.
            This series of 'Namastasyai' begins here, proving the Mother's absolute omnipresence.
            Any attraction or urge for life within beings is the direct influence of this Maya of the Mother.
            The seeker here acknowledges the mysterious influence of the Mother that governs the entire cosmos.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 7,
        sanskrit = "या देवी सर्वभूतेषु चेतनेत्यभिधीयते । नमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ ७ ॥",
        hindi = """
            जो देवी समस्त प्राणियों में 'चेतना' (Consciousness) के रूप में जानी जाती हैं, उन्हें बार-बार नमस्कार है।
            चेतना ही वह तत्व है जो निर्जीव और सजीव के बीच का अंतर स्पष्ट करता है; माँ ही वह प्राण-शक्ति हैं।
            हमारे भीतर जो 'मैं हूँ' का भाव और समझने की शक्ति है, वह माँ का ही साक्षात् स्वरूप है।
            बिना माँ की इस चेतना के, यह शरीर केवल मिट्टी का एक ढेर मात्र रह जाता है।
            यह श्लोक हमें सिखाता है कि ईश्वर कहीं दूर नहीं, बल्कि हमारे ही भीतर जीवन बनकर धड़क रहे हैं।
            माँ को चेतना के रूप में पूजना ही आत्म-साक्षात्कार की दिशा में सबसे बड़ा और पहला कदम है।
        """.trimIndent(),
        english = """
            Salutations again and again to the Goddess who in all beings is known as 'Consciousness' (Chetana).
            Consciousness is the element that distinguishes the living from the non-living; the Mother is that life-force.
            The sense of 'I am' and the power of understanding within us are direct manifestations of the Mother.
            Without this consciousness of the Mother, this body remains merely a heap of inanimate clay.
            This verse teaches us that God is not far away, but is pulsating within us as the very essence of life.
            Worshiping the Mother as Consciousness is the greatest and first step toward self-realization.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 8,
        sanskrit = "या देवी सर्वभूतेषु बुद्धिरूपेण संस्थिता । नमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ ८ ॥",
        hindi = """
            जो देवी समस्त प्राणियों में 'बुद्धि' (Intellect) के रूप में स्थित हैं, उन्हें बार-बार नमस्कार है।
            बुद्धि वह दिव्य यंत्र है जो हमें सही और गलत, सत्य और असत्य के बीच भेद करना सिखाता है।
            हमारी सोचने, निर्णय लेने और ज्ञान प्राप्त करने की क्षमता माँ की ही दी हुई एक अनमोल भेंट है।
            जब बुद्धि माँ के चरणों में समर्पित होती है, तब वह 'प्रज्ञा' (Higher Wisdom) में बदल जाती है।
            यह श्लोक हमें अपनी बुद्धि का उपयोग धर्म और लोक-कल्याण के लिए करने की प्रेरणा देता है।
            माँ को बुद्धि के रूप में पूजने से साधक का मन भ्रमों से मुक्त होकर सत्य के प्रकाश की ओर बढ़ता है।
        """.trimIndent(),
        english = """
            Salutations again and again to the Goddess who in all beings is established as 'Intellect' (Buddhi).
            Intellect is the divine instrument that teaches us to distinguish between right and wrong, truth and untruth.
            Our capacity to think, decide, and acquire knowledge is a priceless gift bestowed by the Mother.
            When the intellect is surrendered at the Mother's feet, it transforms into 'Pragya' (Higher Wisdom).
            This verse inspires us to use our intellect for the sake of Righteousness (Dharma) and public welfare.
            Worshiping the Mother as Intellect frees the seeker's mind from delusions and leads toward the light of Truth.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 9,
        sanskrit = "या देवी सर्वभूतेषु निद्रारूपेण संस्थिता । नमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ ९ ॥",
        hindi = """
            जो देवी समस्त प्राणियों में 'निद्रा' (Sleep) के रूप में स्थित हैं, उन्हें बार-बार नमस्कार है।
            निद्रा केवल थकान मिटाने का साधन नहीं, बल्कि माँ की वह गोद है जहाँ जीव अपने सारे दुख भूल जाता है।
            यह वह समय है जब माँ जीव को फिर से ताज़ा और ऊर्जावान बनाने के लिए उसे अपने भीतर समेट लेती हैं।
            माँ का यह रूप बताता है कि शांति और विश्राम भी उनकी असीम करुणा का ही एक हिस्सा हैं।
            गहरी नींद में हम अनजाने में ही माँ की उस परा-शक्ति के संपर्क में होते हैं जो हमें जीवन देती है।
            यह श्लोक हमें सिखाता है कि प्रकृति की हर लय (Rhythm), यहाँ तक कि सोना भी, ईश्वरीय विधान है।
        """.trimIndent(),
        english = """
            Salutations again and again to the Goddess who in all beings is established as 'Sleep' (Nidra).
            Sleep is not just a means to remove fatigue, but the Mother's lap where the soul forgets all its miseries.
            It is the time when the Mother gathers the being into Herself to refresh and re-energize them.
            This form reveals that peace and rest are also integral parts of Her boundless compassion.
            In deep sleep, we are unconsciously in contact with the Mother's supreme power that grants life.
            This verse teaches us that every rhythm of nature, even sleeping, is a divine ordinance.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 10,
        sanskrit = "या देवी सर्वभूतेषु क्षुधारूपेण संस्थिता । नमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ १० ॥",
        hindi = """
            जो देवी समस्त प्राणियों में 'क्षुधा' (Hunger) के रूप में स्थित हैं, उन्हें बार-बार नमस्कार है।
            भूख केवल पेट की नहीं, बल्कि जीवन जीने और आगे बढ़ने की वह तड़प है जो हमें गतिशील रखती है।
            यह माँ की वह शक्ति है जो हमें कर्म करने के लिए प्रेरित करती है ताकि हम अपना अस्तित्व बचा सकें।
            माँ यहाँ भूख के रूप में भी पूजनीय हैं, क्योंकि वही हमें संसार के संघर्षों के प्रति जाग्रत रखती हैं।
            यह श्लोक हमें सिखाता है कि हमारे शरीर की हर प्राकृतिक आवश्यकता के पीछे माँ की ही ऊर्जा कार्य कर रही है।
            जब हम अपनी भूख को माँ का स्वरूप मानते हैं, तो अन्न ग्रहण करना भी एक पवित्र यज्ञ बन जाता है।
        """.trimIndent(),
        english = """
            Salutations again and again to the Goddess who in all beings is established as 'Hunger' (Kshudha).
            Hunger is not just of the stomach, but that longing to live and move forward that keeps us dynamic.
            It is the Mother's power that motivates us to act so that we may preserve our existence.
            The Mother is worshipable even as hunger, for She keeps us alert to the struggles of the world.
            This verse teaches us that behind every natural need of our body, it is the Mother's energy operating.
            When we view our hunger as a form of the Mother, consuming food transforms into a sacred sacrifice.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 11,
        sanskrit = "या देवी सर्वभूतेषु छायारूपेण संस्थिता । नमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ ११ ॥",
        hindi = """
            जो देवी समस्त प्राणियों में 'छाया' (Reflection/Shadow) के रूप में स्थित हैं, उन्हें बार-बार नमस्कार है।
            छाया का अर्थ है माँ की वह शीतलता और सुरक्षा जो हमें जीवन की कड़ी धूप (कष्टों) से बचाती है।
            यह हमारे 'आभामंडल' (Aura) का भी प्रतीक है जो माँ की शक्ति से प्रकाशित और सुरक्षित रहता है।
            जैसे परछाई हमेशा साथ रहती है, वैसे ही माँ की करुणा भक्त का कभी भी साथ नहीं छोड़ती।
            छाया यह भी संकेत देती है कि यह पूरा दृश्य जगत माँ की उस अदृश्य विराट शक्ति का केवल एक प्रतिबिंब है।
            यह श्लोक हमें माँ के साथ एक अत्यंत व्यक्तिगत और अटूट संबंध महसूस करने की प्रेरणा देता है।
        """.trimIndent(),
        english = """
            Salutations again and again to the Goddess who in all beings is established as 'Shadow' (Chhaya).
            Shadow signifies the Mother's coolness and protection that shields us from the scorching sun of life's trials.
            It is also a symbol of our 'Aura' which remains illuminated and protected by the Mother's power.
            Just as a shadow stays with us, the Mother's compassion never ever leaves the side of the devotee.
            Shadow also hints that this visible world is merely a reflection of the Mother's invisible, vast power.
            This verse inspires us to feel an extremely personal and unbreakable connection with the Mother.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 12,
        sanskrit = "या देवी सर्वभूतेषु शक्तिरूपेण संस्थिता । नमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ १२ ॥",
        hindi = """
            जो देवी समस्त प्राणियों में 'शक्ति' (Power/Energy) के रूप में स्थित हैं, उन्हें बार-बार नमस्कार है।
            शक्ति ही वह मूल तत्व है जो परमाणु से लेकर आकाशगंगाओं तक हर चीज को गति प्रदान करता है।
            हमारे भीतर काम करने, बोलने और यहाँ तक कि सोचने की जो ऊर्जा है, वह साक्षात् माँ दुर्गा ही हैं।
            बिना शक्ति के ज्ञान भी असमर्थ है; माँ ही वह बल हैं जो हमारे संकल्पों को सफलता में बदलता है।
            यह श्लोक हमें अपनी आंतरिक शक्तियों को पहचान कर उन्हें धर्म की सेवा में लगाने का संदेश देता है।
            माँ को शक्ति के रूप में पूजने से साधक के भीतर अदम्य साहस और आत्मविश्वास का संचार होता है।
        """.trimIndent(),
        english = """
            Salutations again and again to the Goddess who in all beings is established as 'Power' (Shakti).
            Power is the primordial element that grants motion to everything, from atoms to great galaxies.
            The energy within us to act, speak, and even think is directly Mother Durga Herself.
            Without power, even wisdom is helpless; the Mother is the strength that turns resolves into success.
            This verse sends a message to recognize our inner powers and dedicate them to the service of Dharma.
            Worshiping the Mother as Power instills invincible courage and self-confidence within the seeker.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 13,
        sanskrit = "या देवी सर्वभूतेषु तृष्णारूपेण संस्थिता । नमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ १३ ॥",
        hindi = """
            जो देवी समस्त प्राणियों में 'तृष्णा' (Thirst/Desire) के रूप में स्थित हैं, उन्हें बार-बार नमस्कार है।
            तृष्णा वह प्यास है जो हमें पूर्णता की तलाश में आगे बढ़ाती है; यह जीवन का एक अनिवार्य हिस्सा है।
            यद्यपि भौतिक तृष्णा बंधन का कारण है, लेकिन ईश्वर को पाने की तृष्णा ही मोक्ष का मार्ग खोलती है।
            माँ यहाँ इच्छा के रूप में भी पूजनीय हैं क्योंकि वही हमें अनुभव और विकास की ओर ले जाती हैं।
            यह श्लोक हमें अपनी इच्छाओं को परिष्कृत करने और उन्हें परमात्मा की ओर मोड़ने की शिक्षा देता है।
            जब हमारी तृष्णा माँ के दर्शन की प्यास बन जाती है, तब सांसारिक दुख स्वतः ही समाप्त होने लगते हैं।
        """.trimIndent(),
        english = """
            Salutations again and again to the Goddess who in all beings is established as 'Thirst' (Trishna).
            Thirst is the longing that moves us forward in search of completeness; it is an essential part of life.
            While worldly thirst leads to bondage, the thirst for the Divine is what opens the gates of liberation.
            The Mother is worshipable even as desire because She is the one leading us toward experience and growth.
            This verse teaches us to refine our desires and turn them toward the Supreme Consciousness.
            When our thirst becomes a longing for the Mother’s vision, worldly sorrows spontaneously begin to end.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 14,
        sanskrit = "या देवी सर्वभूतेषु क्षान्तिरूपेण संस्थिता । नमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ १४ ॥",
        hindi = """
            जो देवी समस्त प्राणियों में 'क्षान्ति' (Forgiveness/Patience) के रूप में स्थित हैं, उन्हें बार-बार नमस्कार है।
            क्षमा और धैर्य ही वे गुण हैं जो मनुष्य को पशुता से ऊपर उठाकर देवत्व की श्रेणी में ले आते हैं।
            दूसरों की गलतियों को भुला देना और विपरीत समय में शांत रहना माँ की ही दी हुई सबसे बड़ी शक्ति है।
            माँ स्वयं क्षमा की मूरत हैं, जो अपने बच्चों के हजारों अपराधों को एक पल में माफ कर देती हैं।
            यह श्लोक हमें सिखाता है कि प्रतिशोध से बड़ा धर्म क्षमा है, जो हमारे हृदय को शुद्ध और हल्का बनाता है।
            माँ को क्षमा के रूप में पूजने से हमारे भीतर करुणा और सहनशीलता का दिव्य गुण विकसित होता है।
        """.trimIndent(),
        english = """
            Salutations again and again to the Goddess who in all beings is established as 'Forgiveness' (Kshanti).
            Forgiveness and patience are the attributes that elevate a human from animality to the realm of divinity.
            Forgetting others' mistakes and staying calm in adverse times is the greatest power bestowed by the Mother.
            The Mother Herself is the embodiment of forgiveness, pardoning thousands of Her children's sins in an instant.
            This verse teaches us that forgiveness is a greater duty than revenge, making our hearts pure and light.
            Worshiping the Mother as Forgiveness develops the divine qualities of compassion and tolerance within us.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 15,
        sanskrit = "या देवी सर्वभूतेषु जातिरूपेण संस्थिता । नमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ १५ ॥",
        hindi = """
            जो देवी समस्त प्राणियों में 'जाति' (Genus/Existence) के रूप में स्थित हैं, उन्हें बार-बार नमस्कार है।
            यहाँ 'जाति' का अर्थ जन्म या वर्ग नहीं, बल्कि हर जीव की अपनी विशिष्ट प्रकृति और अस्तित्व का मूल है।
            सृष्टि की हर प्रजाति और हर रूप में माँ का ही एक विशेष गुण और उनकी सुंदरता प्रकट हो रही है।
            माँ ही वह सूत्र हैं जो अलग-अलग दिखने वाले जीवों को एक ही ब्रह्मांडीय परिवार में पिरोकर रखती हैं।
            यह श्लोक हमें हर प्राणी के अस्तित्व का सम्मान करने और उनमें एक ही ईश्वरीय चेतना देखने की प्रेरणा देता है।
            माँ को जाति के रूप में पूजना यह स्वीकार करना है कि विविधता में भी केवल एक ही शक्ति काम कर रही है।
        """.trimIndent(),
        english = """
            Salutations again and again to the Goddess who in all beings is established as 'Genus' (Jati).
            'Jati' here does not mean caste, but the specific nature and the core of the existence of every being.
            In every species and every form of creation, a unique attribute and beauty of the Mother are revealed.
            The Mother is the thread that binds seemingly different beings together into a single cosmic family.
            This verse inspires us to respect the existence of every creature and see the same divine consciousness in all.
            Worshiping the Mother as 'Jati' is to acknowledge that within diversity, only one singular power is at work.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 16,
        sanskrit = "या देवी सर्वभूतेषु लज्जारूपेण संस्थिता । नमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ १६ ॥",
        hindi = """
            जो देवी समस्त प्राणियों में 'लज्जा' (Modesty/Dignity) के रूप में स्थित हैं, उन्हें बार-बार नमस्कार है।
            लज्जा वह आंतरिक अंकुश है जो हमें गलत कार्यों को करने से रोकता है और हमारी मर्यादा की रक्षा करता है।
            यह केवल संकोच नहीं, बल्कि एक आध्यात्मिक गहराई है जो हमारे चरित्र को सुंदर और सम्मानित बनाती है।
            माँ का यह रूप हमें सिखाता है कि आत्म-सम्मान और विनम्रता ही एक सभ्य जीवन के असली आधार हैं।
            यह श्लोक हमें अपनी नैतिकता (Ethics) और शालीनता को माँ के आशीर्वाद के रूप में देखने की प्रेरणा देता है।
            जब हम अपनी मर्यादा को माँ का स्वरूप मानते हैं, तब हमारा आचरण स्वतः ही पवित्र और प्रेरणादायक बन जाता है।
        """.trimIndent(),
        english = """
            Salutations again and again to the Goddess who in all beings is established as 'Modesty' (Lajja).
            Modesty is the internal restraint that prevents us from doing wrong and protects our dignity.
            It is not mere hesitation, but a spiritual depth that makes our character beautiful and respected.
            This form of the Mother teaches us that self-respect and humility are the true foundations of a civilized life.
            This verse inspires us to view our ethics and grace as direct blessings from the Mother.
            When we consider our dignity as a manifestation of the Mother, our conduct spontaneously becomes holy and inspiring.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 17,
        sanskrit = "या देवी सर्वभूतेषु शान्तिरूपेण संस्थिता । नमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ १७ ॥",
        hindi = """
            जो देवी समस्त प्राणियों में 'शान्ति' (Peace) के रूप में स्थित हैं, उन्हें बार-बार नमस्कार है।
            शांति ही वह परम सुख है जिसे पाने के लिए हर जीव दिन-रात संघर्ष और प्रयास करता रहता है।
            यह शांति बाहरी शोर के थमने से नहीं, बल्कि माँ की करुणा के हृदय में उतरने से प्राप्त होती है।
            माँ ही वह शीतल छाँव हैं जहाँ पहुँचने के बाद मन के सभी द्वंद्व और अशांति हमेशा के लिए मिट जाते हैं।
            यह श्लोक हमें अपने भीतर उस शांत केंद्र (Still Point) को खोजने की प्रेरणा देता है जहाँ माँ का वास है।
            माँ को शांति के रूप में पूजने से साधक का जीवन संतुलित, गंभीर और अत्यंत आनंदमयी बन जाता है।
        """.trimIndent(),
        english = """
            Salutations again and again to the Goddess who in all beings is established as 'Peace' (Shanti).
            Peace is the ultimate happiness that every being struggles and strives for day and night.
            This peace is not attained by the stopping of external noise, but by the Mother's mercy entering the heart.
            The Mother is the cool shade where all mental conflicts and restlessness dissolve forever.
            This verse inspires us to find that quiet center (Still Point) within ourselves where the Mother resides.
            Worshiping the Mother as Peace makes the seeker's life balanced, profound, and exceedingly blissful.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 18,
        sanskrit = "या देवी सर्वभूतेषु श्रद्धारूपेण संस्थिता । नमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ १८ ॥",
        hindi = """
            जो देवी समस्त प्राणियों में 'श्रद्धा' (Faith/Devotion) के रूप में स्थित हैं, उन्हें बार-बार नमस्कार है।
            श्रद्धा वह दिव्य ज्योति है जो अंधेरे रास्तों में भी हमें ईश्वर की उपस्थिति का भरोसा दिलाती रहती है।
            बिना श्रद्धा के ज्ञान भार बन जाता है; माँ ही वह विश्वास हैं जो असंभव को भी संभव बना देता है।
            माँ का यह रूप साधक के हृदय को कोमल और भक्ति से भरपूर बनाता है ताकि वह सत्य को ग्रहण कर सके।
            यह श्लोक हमें सिखाता है कि हमारी प्रार्थनाओं की शक्ति केवल हमारी गहरी और अडिग श्रद्धा में छिपी है।
            माँ को श्रद्धा के रूप में पूजने से हमारा ईश्वर के साथ संबंध अटूट और अत्यंत प्रेमपूर्ण बन जाता है।
        """.trimIndent(),
        english = """
            Salutations again and again to the Goddess who in all beings is established as 'Faith' (Shraddha).
            Faith is the divine light that keeps us assured of God's presence even on the darkest paths.
            Without faith, knowledge becomes a burden; the Mother is the trust that makes even the impossible possible.
            This form of the Mother makes the seeker's heart gentle and full of devotion to receive the Truth.
            This verse teaches us that the power of our prayers lies solely within our deep and unwavering faith.
            Worshiping the Mother as Faith makes our relationship with God unbreakable and exceedingly loving.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 19,
        sanskrit = "या देवी सर्वभूतेषु कान्तिरूपेण संस्थिता । नमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ १९ ॥",
        hindi = """
            जो देवी समस्त प्राणियों में 'कान्ति' (Luster/Radiance) के रूप में स्थित हैं, उन्हें बार-बार नमस्कार है।
            कान्ति केवल बाहरी चमक नहीं, बल्कि वह आंतरिक तेज है जो एक पवित्र और सत्यनिष्ठ जीवन से आता है।
            यह माँ की वह दिव्य आभा है जो भक्त के चेहरे और आँखों से साक्षात् झलकने लगती है।
            जब हम माँ के प्रकाश में जीते हैं, तब हमारा पूरा व्यक्तित्व दूसरों के लिए प्रेरणा और आकर्षण बन जाता है।
            यह श्लोक हमें अपनी आत्मा के उस मूल प्रकाश को पहचानने की प्रेरणा देता है जो कभी कम नहीं होता।
            माँ को कान्ति के रूप में पूजने से साधक का मन और शरीर दोनों ईश्वरीय ऊर्जा से जगमगा उठते हैं।
        """.trimIndent(),
        english = """
            Salutations again and again to the Goddess who in all beings is established as 'Radiance' (Kanti).
            Radiance is not just external shine, but the internal brilliance that comes from a pure and truthful life.
            It is the divine aura of the Mother that directly reflects from the face and eyes of a true devotee.
            When we live in the Mother's light, our entire persona becomes an inspiration and attraction for others.
            This verse inspires us to recognize that primordial light of our soul that never ever diminishes.
            Worshiping the Mother as Radiance makes both the seeker's mind and body glow with divine energy.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 20,
        sanskrit = "या देवी सर्वभूतेषु लक्ष्मीरूपेण संस्थिता । नमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ २० ॥",
        hindi = """
            जो देवी समस्त प्राणियों में 'लक्ष्मी' (Prosperity/Grace) के रूप में स्थित हैं, उन्हें बार-बार नमस्कार है।
            लक्ष्मी का अर्थ केवल धन नहीं, बल्कि वह शुभता और वैभव है जो हमारे जीवन को समृद्ध और सुंदर बनाता है।
            माँ ही वह श्री-शक्ति हैं जो हमें न केवल साधन देती हैं, बल्कि उनका सही उपयोग करने का विवेक भी देती हैं।
            जहाँ स्वच्छता, परिश्रम और धर्म का वास होता है, वहाँ माँ लक्ष्मी के रूप में स्वयं विराजती हैं।
            यह श्लोक हमें सिखाता है कि संसार का हर ऐश्वर्य वास्तव में माँ की ही कृपा का एक दृश्य स्वरूप है।
            माँ को लक्ष्मी के रूप में पूजने से जीवन में दरिद्रता का नाश होता है और चहुंओर शुभता का विस्तार होता है।
        """.trimIndent(),
        english = """
            Salutations again and again to the Goddess who in all beings is established as 'Lakshmi' (Prosperity).
            Lakshmi means not just wealth, but the auspiciousness and grace that make our lives rich and beautiful.
            The Mother is the Shri-shakti who grants us resources and the wisdom to use them correctly.
            Where there is cleanliness, hard work, and righteousness, the Mother resides Herself as Lakshmi.
            This verse teaches us that every opulence in the world is actually a visible form of the Mother's grace.
            Worshiping the Mother as Lakshmi destroys poverty and expands auspiciousness in all directions of life.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 21,
        sanskrit = "या देवी सर्वभूतेषु वृत्तिरूपेण संस्थिता । नमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ २१ ॥",
        hindi = """
            जो देवी समस्त प्राणियों में 'वृत्ति' (Tendency/Livelihood) के रूप में स्थित हैं, उन्हें बार-बार नमस्कार है।
            वृत्ति हमारे जीने का ढंग और हमारे काम करने के स्वभाव का वह सूक्ष्म हिस्सा है जो हमें जीवित रखता है।
            यह माँ की वह शक्ति है जो हमें समाज में अपना स्थान बनाने और अपने कर्तव्यों को पूरा करने की प्रेरणा देती है।
            माँ यहाँ हमारे 'करियर' और हमारी योग्यताओं के रूप में भी पूजनीय हैं, क्योंकि वही हमारी जीविका हैं।
            यह श्लोक हमें सिखाता है कि हमारा हर काम, चाहे वह छोटा हो या बड़ा, माँ की ही शक्ति का एक विस्तार है।
            जब हम अपनी वृत्ति (पेशे) को माँ का स्वरूप मानते हैं, तो हमारा हर कर्म साक्षात् ईश्वरीय पूजा बन जाता है।
        """.trimIndent(),
        english = """
            Salutations again and again to the Goddess who in all beings is established as 'Tendency' (Vritti).
            Vritti is the subtle part of our livelihood and nature that keeps us alive and active in the world.
            It is the Mother's power that inspires us to find our place in society and fulfill our sacred duties.
            The Mother is worshipable even as our career and skills, for She is our very sustenance.
            This verse teaches us that our every work, whether small or large, is an extension of the Mother's power.
            When we view our profession (Vritti) as a form of the Mother, our every action becomes direct divine worship.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 22,
        sanskrit = "या देवी सर्वभूतेषु स्मृतिरूपेण संस्थिता । नमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ २२ ॥",
        hindi = """
            जो देवी समस्त प्राणियों में 'स्मृति' (Memory) के रूप में स्थित हैं, उन्हें बार-बार नमस्कार है।
            स्मृति वह दिव्य संदूक है जहाँ हमारे अनुभव, ज्ञान और माँ की यादें सुरक्षित रहती हैं।
            बिना याददाश्त के इंसान का अस्तित्व ही खत्म हो जाता है; माँ ही वह सूत्र हैं जो हमारे अतीत को वर्तमान से जोड़ती हैं।
            माँ का यह रूप हमें अपने गुरुओं, माता-पिता और ईश्वर के उपकारों को हमेशा याद रखने की शक्ति देता है।
            यह श्लोक हमें अपनी चेतना को माँ की याद (स्मरण) में डुबोने और उसे पवित्र बनाए रखने की प्रेरणा देता है।
            माँ को स्मृति के रूप में पूजने से साधक का मन अशुद्ध विचारों को भुलाकर केवल सत्य को याद रखने में समर्थ होता है।
        """.trimIndent(),
        english = """
            Salutations again and again to the Goddess who in all beings is established as 'Memory' (Smriti).
            Memory is the divine treasure-chest where our experiences, knowledge, and memories of the Mother stay safe.
            Without memory, a human's very existence collapses; the Mother is the thread linking our past to our present.
            This form of the Mother grants us the power to eternally remember the favors of gurus, parents, and God.
            This verse inspires us to immerse our consciousness in the remembrance of the Mother and keep it holy.
            Worshiping the Mother as Memory enables the seeker to forget impure thoughts and remember only the Truth.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 23,
        sanskrit = "या देवी सर्वभूतेषु दयारूपेण संस्थिता । नमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ २३ ॥",
        hindi = """
            जो देवी समस्त प्राणियों में 'दया' (Compassion) के रूप में स्थित हैं, उन्हें बार-बार नमस्कार है।
            दया वह सर्वोच्च मानवीय गुण है जो हमें दूसरों के दुख को समझने और उसे दूर करने के लिए प्रेरित करता है।
            माँ स्वयं दया का सागर हैं, जो बिना किसी शर्त के पूरी सृष्टि पर अपना प्रेम और करुणा बरसाती रहती हैं।
            जहाँ दया है वहाँ अधर्म नहीं हो सकता; माँ ही वह कोमलता हैं जो कठोर से कठोर हृदय को भी पिघला देती हैं।
            यह श्लोक हमें अपने भीतर परोपकार और सेवा का भाव जगाने के लिए माँ की शक्ति का आह्वान करने की प्रेरणा देता है।
            माँ को दया के रूप में पूजने से साधक का हृदय विशाल होता है और वह समस्त ब्रह्मांड को अपना परिवार मानने लगता है।
        """.trimIndent(),
        english = """
            Salutations again and again to the Goddess who in all beings is established as 'Compassion' (Daya).
            Compassion is the supreme human quality that inspires us to understand and alleviate the suffering of others.
            The Mother Herself is an ocean of mercy, unconditionally showering Her love and grace upon all creation.
            Where there is compassion, unrighteousness cannot exist; the Mother is the tenderness that melts even the hardest hearts.
            This verse inspires us to call upon the Mother's power to awaken the spirit of altruism and service within us.
            Worshiping the Mother as Compassion expands the seeker's heart, leading them to view the cosmos as their family.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 24,
        sanskrit = "या देवी सर्वभूतेषु तुष्टिरूपेण संस्थिता । नमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ २४ ॥",
        hindi = """
            जो देवी समस्त प्राणियों में 'तुष्टि' (Contentment) के रूप में स्थित हैं, उन्हें बार-बार नमस्कार है।
            तुष्टि वह मानसिक शांति और संतोष है जो हमें यह महसूस कराती है कि माँ की कृपा से हमारे पास सब कुछ पर्याप्त है।
            बिना संतोष के करोड़ों की संपत्ति भी दरिद्रता के समान है; माँ ही वह तृप्ति हैं जो मन की दौड़ को शांत करती हैं।
            यह माँ की वह शक्ति है जो हमें वर्तमान पल का आनंद लेने और ईश्वर की मर्जी में खुश रहने का वरदान देती है।
            यह श्लोक हमें सिखाता है कि असली अमीरी बैंक बैलेंस में नहीं, बल्कि माँ के दिए हुए संतोषी मन में छिपी है।
            माँ को तुष्टि के रूप में पूजने से साधक का जीवन ईर्ष्या और लालच से मुक्त होकर अत्यंत शांत और सुखी हो जाता है।
        """.trimIndent(),
        english = """
            Salutations again and again to the Goddess who in all beings is established as 'Contentment' (Tushti).
            Contentment is the mental peace that makes us feel that by the Mother's grace, we have everything we need.
            Without contentment, even millions are like poverty; the Mother is the satisfaction that stills the restless mind.
            It is the Mother's power that grants us the boon to enjoy the present moment and be happy in God's will.
            This verse teaches us that true wealth lies not in bank balances, but in the contented mind gifted by the Mother.
            Worshiping the Mother as Contentment frees the seeker's life from jealousy and greed, making it peaceful and happy.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 25,
        sanskrit = "या देवी सर्वभूतेषु मातृरूपेण संस्थिता । नमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ २५ ॥",
        hindi = """
            जो देवी समस्त प्राणियों में 'मातृ' (Mother) के रूप में स्थित हैं, उन्हें बार-बार नमस्कार है।
            यह माँ का सबसे कोमल और सबसे शक्तिशाली रूप है, जो बिना किसी स्वार्थ के केवल देना और रक्षा करना जानती हैं।
            संसार की हर माँ में साक्षात् माँ दुर्गा की ही ममता का एक छोटा सा अंश प्रवाहित हो रहा है।
            माँ ही वह सुरक्षा कवच हैं जो अपने बच्चों के लिए किसी भी बाधा या शत्रु से टकराने की ताकत रखती हैं।
            यह श्लोक हमें पूरी सृष्टि को माँ के स्वरूप के रूप में देखने और हर स्त्री का आदर करने की महान शिक्षा देता है।
            माँ को मातृ-रूप में पूजना ही भक्ति का सबसे सरल मार्ग है, क्योंकि माँ अपने बच्चे की हर पुकार को तुरंत सुनती हैं।
        """.trimIndent(),
        english = """
            Salutations again and again to the Goddess who in all beings is established as 'Mother' (Matri).
            This is the Mother's gentlest yet most powerful form, which only knows how to give and protect selflessly.
            In every mother in the world, a tiny fragment of Mother Durga's own maternal love is flowing directly.
            The Mother is the protective shield possessing the strength to face any obstacle or enemy for Her children.
            This verse gives the great teaching of viewing the entire creation as the Mother and respecting every woman.
            Worshiping the Mother as 'Mother' is the simplest path of devotion, for She hears Her child's every call instantly.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 26,
        sanskrit = "या देवी सर्वभूतेषु भ्रान्तिरूपेण संस्थिता । नमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ २६ ॥",
        hindi = """
            जो देवी समस्त प्राणियों में 'भ्रान्ति' (Delusion/Error) के रूप में स्थित हैं, उन्हें बार-बार नमस्कार है।
            भ्रान्ति वह पर्दा है जो हमें सत्य देखने से रोकता है, लेकिन यह भी माँ की माया का ही एक हिस्सा है ताकि खेल चलता रहे।
            जब हम अज्ञान में होते हैं, तब भी हम माँ की ही शक्ति के अधीन होते हैं, जो हमें धीरे-धीरे अनुभव से ज्ञान की ओर ले जाती है।
            माँ यहाँ भ्रम के रूप में भी पूजनीय हैं क्योंकि वही हमारे अहंकार को तोड़कर हमें वास्तविकता का बोध कराती हैं।
            यह श्लोक हमें सिखाता है कि हमारी गलतियाँ और हमारे भ्रम भी माँ के उस महान प्रशिक्षण (Training) का एक हिस्सा हैं।
            माँ को भ्रान्ति के रूप में नमन करने का अर्थ है यह प्रार्थना करना कि वे इस भ्रम को हटाकर हमें अपना वास्तविक दर्शन कराएं।
        """.trimIndent(),
        english = """
            Salutations again and again to the Goddess who in all beings is established as 'Delusion' (Bhranti).
            Delusion is the veil that prevents us from seeing the Truth, yet it is a part of Her Maya to keep the play going.
            Even in ignorance, we are under Her power, which gradually leads us through experience toward wisdom.
            The Mother is worshipable even as delusion, for She is the one who shatters our ego to grant us a sense of reality.
            This verse teaches us that our errors and delusions are also part of Her grand spiritual training for the soul.
            Bowing to Her as Delusion is a prayer to remove this veil and grant us the direct vision of Her true Self.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 27,
        sanskrit = "इन्द्रियाणामधिष्ठात्री भूतानां चाखिलेषु या । भूतेषु सततं तस्यै व्याप्तिदेव्यै नमो नमः ॥ २७ ॥",
        hindi = """
            जो समस्त इंद्रियों की अधिष्ठात्री (स्वामिनी) हैं और जो सभी प्राणियों में हमेशा व्याप्त रहती हैं।
            उन सबमें समाई हुई सर्वव्यापक 'व्याप्ति' देवी को मेरा बार-बार नमस्कार है।
            हमारी इंद्रियाँ (आँख, कान आदि) माँ की ही शक्ति से देख और सुन पाती हैं; वे ही इनकी असली संचालिका हैं।
            व्याप्ति का अर्थ है वह ऊर्जा जो कण-कण में मौजूद है, जिसके बिना कुछ भी अस्तित्व में नहीं रह सकता।
            यह श्लोक माँ की सर्वव्यापकता (Omnipresence) पर मुहर लगाता है कि वे ही इस ब्रह्मांड की इकलौती रूह हैं।
            साधक यहाँ अनुभव करता है कि वह जिस भी चीज को छूता या देखता है, वह साक्षात् माँ का ही एक विस्तार है।
        """.trimIndent(),
        english = """
            Salutations again and again to the Vyapti-Devi (All-pervading Goddess) who governs the senses of all beings.
            She is the sovereign of the senses and remains eternally pervasive within every single creature.
            Our senses (eyes, ears, etc.) can only see and hear through Her power; She is their actual Director.
            'Vyapti' means the energy present in every atom, without which nothing can possibly remain in existence.
            This verse confirms Her absolute omnipresence, stating that She is the singular soul of the entire universe.
            The seeker here experiences that whatever they touch or see is directly an extension of the Divine Mother.
        """.trimIndent()
    ),
    TantroktamDeviShloka(
        id = 28,
        sanskrit = "चितिरूपेण या कृत्स्नमेतद्व्याप्य स्थिता जगत् । नमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ २८ ॥\nइति तन्त्रोक्तं देवीसूक्तं सम्पूर्णम् ॥",
        hindi = """
            जो देवी 'चिति' (शुद्ध चेतना) के रूप में इस संपूर्ण जगत को व्याप्त करके स्थित हैं।
            उन परम चेतना स्वरूप देवी को बार-बार नमस्कार है।
            चिति वह प्रकाश है जो न कभी पैदा होता है और न कभी मरता है; यह ब्रह्मांड का शाश्वत सत्य है।
            इस श्लोक के साथ स्तोत्र का समापन होता है, जो हमें याद दिलाता है कि अंततः सब कुछ उसी एक प्रकाश में विलीन है।
            माँ की शरण में जाना ही जीवन का अंतिम लक्ष्य और परम शांति का एकमात्र मार्ग है।
            ॥ इस प्रकार तन्त्रोक्त देवीसूक्त सम्पूर्ण हुआ ॥
        """.trimIndent(),
        english = """
            Salutations again and again to the Goddess who pervades this entire world in the form of 'Chiti' (Pure Consciousness).
            To that Supreme Consciousness, I offer my salutations again and again.
            'Chiti' is the light that is never ever born and never dies; it is the eternal truth of the entire cosmos.
            The hymn concludes with this verse, reminding us that ultimately, everything merges back into that singular Light.
            Seeking refuge in the Mother is the final goal of life and the only path to absolute, supreme peace.
            || Thus ends the Tantroktam Devi Suktam ||
        """.trimIndent()
    )
)