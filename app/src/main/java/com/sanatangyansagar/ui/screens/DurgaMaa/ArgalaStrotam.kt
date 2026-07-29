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
data class ArgalaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

// 2. Main Screen Composable
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArgalaStrotamScreen() {
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
                // Validates if the number is between 1 and 27
                if (shlokaNumber != null && shlokaNumber in 1..27) {
                    coroutineScope.launch {
                        // Smoothly scrolls to the exact Shloka
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-27)") },
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
            itemsIndexed(argalaShlokasList) { _, shloka ->
                ArgalaShlokaCard(shloka = shloka)
            }
        }
    }
}

// 3. Shloka Card Composable
@Composable
fun ArgalaShlokaCard(shloka: ArgalaShloka) {
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
val argalaShlokasList: List<ArgalaShloka> = listOf(
    ArgalaShloka(
        id = 1,
        sanskrit = "ॐ अस्य श्रीअर्गलास्तोत्रमन्त्रस्य विष्णुर्ऋषिः, अनुष्टुप् छन्दः, श्रीमहालक्ष्मीर्देवता, श्रीजगदम्बाप्रीतये सप्तशतीपाठाङ्गत्वेन जपे विनियोगः ॥",
        hindi = """
            (विनियोग): इस परम पावन श्री अर्गला स्तोत्र मन्त्र के दृष्टा ऋषि भगवान विष्णु हैं। 
            इसका छंद 'अनुष्टुप्' है और इसकी मुख्य अधिष्ठात्री देवी साक्षात् 'श्री महालक्ष्मी' हैं। 
            श्री जगदम्बा की असीम प्रसन्नता और कृपा प्राप्त करने के लिए इसे सप्तशती पाठ के एक अनिवार्य अंग के रूप में जपा जाता है।
            'अर्गला' का शाब्दिक अर्थ 'कुंडी' या 'अवरोध' होता है; यह स्तोत्र अज्ञान के उस ताले को खोलता है,
            जो मनुष्य और देवी की अनंत शक्ति के बीच बाधा बना हुआ है। इसके पाठ से साधक की आध्यात्मिक यात्रा निर्बाध होती है।
            यह मन्त्रों का वह समूह है जो सप्तशती के महान फल को प्राप्त करने का मार्ग प्रशस्त करता है।
        """.trimIndent(),
        english = """
            (Invocation): Lord Vishnu is the seer (Rishi) of this sacred Sri Argala Stotram mantra. 
            The poetic meter is 'Anushtup', and the presiding Supreme Deity is 'Goddess Mahalakshmi'. 
            It is performed as a vital part of the Durga Saptashati recitation to win the grace of the Mother of the Universe.
            'Argala' means a 'bolt' or 'latch'; this stotram serves as the key to unlock the spiritual barriers,
            allowing the seeker to access the profound power and secrets hidden within the Saptashati text.
            By reciting this, one prepares the heart and mind to receive the divine blessings of Mother Durga.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 2,
        sanskrit = "ॐ नमश्चण्डिकायै ॥ मार्कण्डेय उवाच ।\nॐ जयन्ती मङ्गला काली भद्रकाली कपालिनी । दुर्गा क्षमा शिवा धात्री स्वाहा स्वधा नमोऽस्तु ते ॥",
        hindi = """
            ॐ, माता चण्डिका को सादर प्रणाम। महर्षि मार्कण्डेय माता के आठ नामों की महिमा गाते हैं:
            हे जयन्ती (विजयी), मङ्गला (कल्याणकारिणी), काली (समय की स्वामिनी) और भद्रकाली (सौम्य रक्षक)! 
            हे कपालिनी (अज्ञान को हरने वाली), दुर्गा (कठिनाइयों का नाश करने वाली), क्षमा और शिवा (अत्यंत शुभ)! 
            आप ही धात्री (जगत की जननी), स्वाहा और स्वधा (यज्ञों का आधार) हैं; आपको मेरा बारंबार नमस्कार है।
            इन नामों का उच्चारण मात्र ही साधक के चारों ओर सुरक्षा का एक दिव्य घेरा बना देता है।
            माँ का यह स्वरूप सृष्टि के हर सकारात्मक और संहारक पक्ष को अपने भीतर समेटे हुए है।
            यह प्रार्थना जीवन के सभी अमंगलों को दूर कर सौभाग्य और शांति का संचार करने वाली है।
        """.trimIndent(),
        english = """
            Om, salutations to Mother Chandika. Sage Markandeya invokes the Goddess through Her diverse forms:
            O Jayanti (Victorious), Mangala (Auspicious), Kali (Devourer of Time), and Bhadrakali (Noble Protector)!
            O Kapalini (Bearer of skulls/remover of ego), Durga (Savior from perils), Kshama (Forgiveness), and Shiva (Pure)!
            You are Dhatri (Sustainer), Svaha (Sacrificial fire), and Svadha (Ancestral oblation); I bow to You eternally.
            These names represent the various cosmic functions of the Mother as both a creator and a destroyer.
            Chanting this verse creates a spiritual shield that guards the devotee against all external and internal fears.
            It is a profound acknowledgment of Her presence in every sacred ritual and natural law.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 3,
        sanskrit = "जय त्वं देवि चामुण्डे जय भूतार्तिहारिणि । जय सर्वगते देवि कालरात्रि नमोऽस्तु ते ॥",
        hindi = """
            हे चण्ड-मुण्ड का नाश करने वाली देवी चामुण्डे! आपकी जय हो, आप हमारे अज्ञान को मिटाने वाली हैं।
            हे समस्त प्राणियों की पीड़ाओं और दुखों (भूतार्ति) को हरने वाली कृपालु माता! आपकी जय हो।
            हे चराचर जगत में व्याप्त रहने वाली सर्वव्यापी देवी! हे कालरात्रि, आपकी जय हो, मैं आपको प्रणाम करता हूँ।
            कालरात्रि का अर्थ है अज्ञान का अंधकार मिटाने वाली वह महाशक्ति, जो प्रलय के समय भी स्थिर रहती है।
            माँ का यह रूप दुखों के सागर से पार लगाने वाली उस महान ऊर्जा का प्रतीक है, जिसे शत्रु नहीं हरा सकते।
            यह श्लोक हृदय में अदम्य साहस और आत्मविश्वास का संचार करता है कि माँ हर संकट में साथ हैं।
            सर्वगते शब्द यह सिद्ध करता है कि माँ से दूर कोई स्थान नहीं है, वे हर पल हमारे साथ स्थित हैं।
        """.trimIndent(),
        english = """
            O Goddess Chamunda, slayer of the demons Chanda and Munda! Victory to You, the destroyer of darkness.
            O Mother who compassionately removes the agonies (Bhutarti) of all living beings! Victory to You.
            O All-pervading Goddess who exists everywhere! O Kalaratri (Dark Night of Dissolution), I bow to You.
            Kalaratri represents the supreme power that annihilates ignorance and remains steady even during cosmic dissolution.
            This form of the Mother is the energy that steers the devotee across the ocean of worldly miseries.
            Reciting this instill deep courage, reminding the seeker that the Mother’s protection is omnipresent.
            The term 'Sarvagate' emphasizes Her presence in every atom, ensuring that no devotee is ever alone.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 4,
        sanskrit = "मधु कैटभविद्रावि विधातृवरदे नमः । रूपं देहि जयं देहि यशो देहि द्विषो जहि ॥",
        hindi = """
            हे मधु और कैटभ नामक महादैत्यों का संहार करने वाली और ब्रह्मा जी को वरदान देने वाली देवी! आपको प्रणाम है।
            हे माँ! मुझे 'रूप' (आत्म-ज्ञान और आंतरिक सुंदरता) दें और हर संघर्ष में 'जय' (पूर्ण विजय) प्रदान करें।
            मुझे 'यश' (सच्ची कीर्ति) प्रदान करें और मेरे भीतर छिपे काम-क्रोध आदि शत्रुओं (द्विषो) का नाश करें।
            अर्गला स्तोत्र की यह मुख्य टेक (रूपं देहि...) साधक की आध्यात्मिक और भौतिक समृद्धि की सामूहिक मांग है।
            यहाँ 'शत्रु' का अर्थ बाहरी दुश्मनों से अधिक हमारे अपने मन के वे विकार हैं जो हमें सत्य से दूर रखते हैं।
            ब्रह्मा जी को वरदान देने का अर्थ है कि माँ ही समस्त ज्ञान और सृजन की मूल संचालिका हैं।
            यह प्रार्थना हमें आत्मविश्वास देती है कि माँ की कृपा से हम अपनी कमियों पर विजय प्राप्त कर सकते हैं।
        """.trimIndent(),
        english = """
            O Mother, the slayer of demons Madhu and Kaitabha, and the bestower of boons to Lord Brahma! I bow to You.
            O Mother! Grant me 'Rupam' (spiritual beauty/wisdom) and 'Jayam' (victory in all endeavors).
            Grant me 'Yashas' (noble fame) and destroy the 'Dvisho' (the enemies/vices) residing within me.
            This refrain is a collective prayer for both spiritual enlightenment and material success.
            The 'enemies' referred to here are primarily the inner vices like lust, anger, and ego that hinder growth.
            By granting boons to Brahma, She is established as the source of all creative intelligence in the cosmos.
            This verse empowers the seeker to conquer personal weaknesses and rise toward divine glory.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 5,
        sanskrit = "महिषासुरनिर्णाशि भक्तानां सुखदे नमः । रूपं देहि जयं देहि यशो देहि द्विषो जहि ॥",
        hindi = """
            हे महिषासुर जैसे भयंकर अहंकारी दानव का नाश करने वाली और भक्तों को परम सुख देने वाली माता! आपको नमस्कार है।
            हे देवी! आप मुझे आत्मिक तेज (रूप), जीवन के पथ पर विजय (जय), और दिव्य कीर्ति (यश) प्रदान करें।
            मेरे अज्ञान और तामसिक प्रवृत्तियों रूपी शत्रुओं का संहार करें ताकि मैं आपके प्रकाश में जी सकूँ।
            महिषासुर वह तामसिक वृत्ति है जो स्वयं को ईश्वर से बड़ा समझने की भूल करती है; माँ उसे नष्ट करती हैं।
            भक्तों को सुख देने का अर्थ है उन्हें उस शाश्वत आनंद से जोड़ना जो संसार के उतार-चढ़ाव से परे है।
            यह प्रार्थना हमें याद दिलाती है कि जब हम माँ की शरण में होते हैं, तो बड़े से बड़ा संकट भी टिक नहीं सकता।
            माँ का आशीर्वाद ही वह बल है जो हमारे जीवन के हर अंधकारमय पक्ष को उजाले में बदल देता है।
        """.trimIndent(),
        english = """
            O Destroyer of the demon Mahishasura and the bestower of happiness upon devotees! Salutations to You.
            O Goddess! Grant me spiritual radiance (Rupam), victory over life's trials (Jayam), and divine fame (Yashas).
            Slay the enemies of my soul—my ignorance and negative tendencies—so that I may live in Your light.
            Mahishasura symbolizes the dark ego that mistakes itself for being supreme; the Mother ruthlessly crushes it.
            Bestowing happiness means connecting the devotee to that eternal bliss which is beyond worldly changes.
            This prayer reminds us that in Her refuge, no crisis is too large to be overcome by Her divine intervention.
            Her blessing is the singular force that transforms every dark corner of our existence into brilliance.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 6,
        sanskrit = "रक्तबीजवधे देवि चण्डमुण्डविनाशिनि । रूपं देहि जयं देहि यशो देहि द्विषो जहि ॥",
        hindi = """
            हे रक्तबीज जैसे अजेय असुर का वध करने वाली और चण्ड-मुण्ड को समूल नष्ट करने वाली देवी! आपको प्रणाम है।
            रक्तबीज हमारे अनियंत्रित विचारों और वासनाओं का प्रतीक है; माँ उन्हें अपनी शक्ति से शांत कर देती हैं।
            हे माता! मुझे सद्गुणों का रूप दें, मुझे मन पर विजय दें, मुझे यश दें और मेरे शत्रुओं का नाश करें।
            चण्ड और मुण्ड हमारे भीतर के द्वेष और कलह के प्रतीक हैं, जिनका अंत माँ की करुणा से ही संभव है।
            यह श्लोक साधक को मानसिक स्थिरता और विचारों की शुद्धि के लिए माँ का आह्वान करने की प्रेरणा देता है।
            माँ की संहारक शक्ति वास्तव में साधक के लिए निर्माण की शक्ति है, जो गंदगी साफ कर सत्य को सजाती है।
            जब हमारे विचार शुद्ध होते हैं, तभी हम माँ के वास्तविक 'रूप' और 'जय' को अनुभव करने के योग्य बनते हैं।
        """.trimIndent(),
        english = """
            O Goddess who executed the invincible demon Raktabija and destroyed Chanda and Munda! Salutations to You.
            Raktabija symbolizes uncontrolled thoughts and desires; the Mother pacifies them with Her divine power.
            O Mother! Grant me the form of virtues, victory over my mind, noble fame, and destroy my internal enemies.
            Chanda and Munda represent the malice and discord within us, which can only be ended by Her mercy.
            This verse inspires the seeker to call upon the Mother for mental stability and the purification of thoughts.
            Her destructive power is actually a creative force for the seeker, clearing debris to establish Truth.
            Only when our thoughts are purified do we become truly worthy of experiencing Her divine form and victory.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 7,
        sanskrit = "शुम्भस्यैव निशुम्भस्य धूम्राक्षस्य च मर्दिनि । रूपं देहि जयं देहि यशो देहि द्विषो जहि ॥",
        hindi = """
            हे शुम्भ, निशुम्भ और धूम्राक्ष जैसे भयंकर राक्षसों का मर्दन करने वाली माता! मैं आपकी शरण में हूँ।
            शुम्भ और निशुम्भ हमारे भीतर के 'मैं' और 'मेरा' के भारी अहंकार के प्रतीक हैं, जो हमें बांधे रखते हैं।
            हे देवी! आप मुझे आत्मिक रूप, पूर्ण विजय और दिव्य यश दें, और मेरे शत्रुओं का पूरी तरह नाश करें।
            धूम्राक्ष वह धुंधली दृष्टि है जो सत्य को नहीं देख पाती; माँ उस धुंध को हटाकर हमें स्पष्टता देती हैं।
            माँ का यह उग्र स्वरूप साधक के जीवन से भय को निकालकर उसे अजेय वीरता और शांति प्रदान करता है।
            यह प्रार्थना हमें सिखाती है कि अहंकार का नाश ही ईश्वर तक पहुँचने का सबसे सीधा और सफल मार्ग है।
            माँ की कृपा से हमारे व्यक्तित्व में वह तेज आता है जो किसी भी बाहरी शक्ति से कभी भी दबाया नहीं जा सकता।
        """.trimIndent(),
        english = """
            O Mother who crushed the terrifying demons Shumbha, Nishumbha, and Dhumraksha! I take refuge in You.
            Shumbha and Nishumbha represent the heavy ego of 'I' and 'Mine' that keeps the soul in bondage.
            O Goddess! Grant me spiritual form, absolute victory, and divine fame, and destroy my enemies completely.
            Dhumraksha symbolizes blurred vision/delusion; the Mother clears that smoke to grant us absolute clarity.
            Her fierce form removes fear from the life of the seeker, replacing it with invincible courage and peace.
            This prayer teaches us that the destruction of ego is the most direct and successful path to the Divine.
            By Her grace, our persona gains a radiance that cannot be suppressed by any external force or negativity.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 8,
        sanskrit = "वन्दिताङ्घ्रियुगे देवि सर्वसौभाग्यदायिनि । रूपं देहि जयं देहि यशो देहि द्विषो जहि ॥",
        hindi = """
            हे देवी! आपके दोनों पवित्र चरणों की वंदना पूरा ब्रह्मांड करता है; आप सभी प्रकार के सौभाग्य को देने वाली हैं।
            सौभाग्य का अर्थ केवल धन नहीं, बल्कि मानसिक शांति, अच्छे संबंध और ईश्वर के प्रति अटूट प्रेम भी है।
            हे माँ! मुझे उत्तम रूप, अचल विजय और पवित्र यश प्रदान करें, और मेरे अज्ञान रूपी शत्रुओं का संहार करें।
            माँ के चरणों में झुकने से मनुष्य का अहंकार मिटता है और उसे वह शक्ति मिलती है जो उसे महान बनाती है।
            यह श्लोक सौभाग्य की उस उच्चतम अवस्था की मांग है जहाँ साधक को कुछ और पाने की इच्छा नहीं रहती।
            माँ के चरणों की धूल ही वह अमृत है जो साधारण मनुष्य के जीवन को भी असाधारण और दिव्य बना देती है।
            जब हम माँ के चरणों में समर्पित होते हैं, तो संसार की सभी बाधाएं हमारे लिए मार्ग बन जाती हैं।
        """.trimIndent(),
        english = """
            O Goddess! Your twin lotus feet are worshiped by the entire cosmos; You bestower all types of good fortune.
            Good fortune (Saubhagya) is not just wealth, but mental peace, noble relationships, and love for the Divine.
            O Mother! Grant me an excellent form, steady victory, and holy fame, and slay the enemies of my ignorance.
            Bowing at Her feet dissolves pride and grants the seeker the inner strength required to achieve greatness.
            This verse is a plea for that ultimate state of fortune where the seeker feels completely fulfilled and at peace.
            The dust of the Mother’s feet is the nectar that transforms an ordinary life into something extraordinary and divine.
            When we surrender at Her feet, all the obstacles of the world eventually turn into pathways for our success.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 9,
        sanskrit = "अचिन्त्यरूपचरिते सर्वशत्रुविनाशिनि । रूपं देहि जयं देहि यशो देहि द्विषो जहि ॥",
        hindi = """
            हे माता! आपका दिव्य रूप और आपके अद्भुत चरित्र (लीलाएं) मानव बुद्धि की कल्पना से परे (अचिन्त्य) हैं।
            हे भक्तों के सभी प्रकार के बाहरी और भीतरी शत्रुओं का समूल नाश करने वाली माँ! आपको मेरा नमन है।
            हे देवी! आप मुझे आत्म-ज्ञान का रूप, संघर्षों में विजय और श्रेष्ठ यश दें, और मेरे शत्रुओं का विनाश करें।
            अचिन्त्य होने का अर्थ है कि माँ की शक्ति को शब्दों में नहीं, केवल हृदय के अनुभव से ही समझा जा सकता है।
            माँ का चरित्र हमें सिखाता है कि सत्य के लिए लड़ना और बुराई को मिटाना ही जीवन का सबसे बड़ा धर्म है।
            यह श्लोक हमें असीम और रहस्यमयी ईश्वरीय शक्ति के प्रति श्रद्धा रखने और उससे जुड़ने की प्रेरणा देता है।
            जब हम माँ की असीमित शक्ति को स्वीकार करते हैं, तो हमारे भीतर का छोटा 'मैं' समाप्त होकर 'विराट' बन जाता है।
        """.trimIndent(),
        english = """
            O Mother! Your divine form and extraordinary actions are beyond the grasp of human intellect (Achintya).
            O Slayer of all internal and external enemies of Your devotees! I offer my humble salutations to You.
            O Goddess! Grant me the form of self-knowledge, victory in my struggles, noble fame, and slay my enemies.
            'Achintya' implies that Her power cannot be described in words; it can only be felt through heart-felt experience.
            Her life-story teaches us that fighting for the Truth and eradicating evil is the highest duty of existence.
            This verse inspires the seeker to have deep faith in and connect with the mysterious, infinite divine power.
            When we acknowledge Her boundless strength, our small limited self dissolves to become part of the Infinite.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 10,
        sanskrit = "नतेभ्यः सर्वदा भक्त्या चण्डिके दुरितापहे । रूपं देहि जयं देहि यशो देहि द्विषो जहि ॥",
        hindi = """
            हे चण्डिके! जो भक्त प्रेम और भक्ति के साथ हमेशा आपके सामने झुकते हैं, आप उनके सभी दुखों को हरने वाली हैं।
            दुरित (पाप और कष्ट) को हरने वाली माँ! आप अपने शरणागत भक्तों के जीवन को अज्ञान के कीचड़ से बाहर निकालती हैं।
            हे माँ! आप मुझे आध्यात्मिक रूप, अजेय जीत और पवित्र यश दें, और मेरे शत्रुओं का पूरी तरह नाश करें।
            झुकने (नत) का अर्थ यहाँ केवल शारीरिक झुकना नहीं, बल्कि अहंकार का पूर्ण समर्पण और माँ पर अटूट भरोसा है।
            जब भक्त पूरी तरह झुक जाता है, तो माँ की करुणा का झरना उस पर अपने आप और निरंतर बहने लगता है।
            यह प्रार्थना हमें विनम्रता सिखाती है, क्योंकि विनम्र हृदय में ही ईश्वरीय ज्ञान का बीज अंकुरित हो सकता है।
            माँ का आशीर्वाद ही वह मरहम है जो जीवन के पुराने से पुराने घावों और पापों को पूरी तरह ठीक कर देता है।
        """.trimIndent(),
        english = """
            O Chandika! To those devotees who always bow before You with love, You are the remover of all miseries.
            O Mother who clears away sins (Durita)! You rescue Your surrendered followers from the mire of ignorance.
            O Mother! Grant me spiritual form, invincible victory, and sacred fame, and destroy my enemies entirely.
            Bowing (Nata) here does not just mean physical prostration, but the total surrender of ego and absolute trust.
            When a devotee truly bows down, the fountain of Mother’s compassion automatically flows upon them.
            This prayer teaches us humility, for it is only in a humble heart that the seed of divine wisdom can sprout.
            Her blessing is the ultimate balm that completely heals the oldest wounds of life and wipes away all past sins.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 11,
        sanskrit = "स्तुवद्भ्यो भक्तिपूर्वं त्वां चण्डिके व्याधिनाशिनि । रूपं देहि जयं देहि यशो देहि द्विषो जहि ॥",
        hindi = """
            हे चण्डिके! जो भी भक्त पूरी श्रद्धा के साथ आपकी स्तुति करते हैं, आप उनके शारीरिक और मानसिक रोगों का नाश करती हैं।
            व्याधि (बीमारी) केवल शरीर की नहीं, बल्कि मन के तनाव, ईर्ष्या और लोभ की भी होती है; माँ उन सबको मिटा देती हैं।
            हे माता! मुझे सद्गुणों का रूप, जीवन में जय और महान यश दें, और मेरे अज्ञान रूपी शत्रुओं का संहार करें।
            माँ की स्तुति करना हमारे हृदय को शुद्ध करता है और हमें उस परम स्वास्थ्य से जोड़ता है जो आत्मा का स्वभाव है।
            जब मन शांत और निरोग होता है, तभी हम जीवन के असली उद्देश्य को समझ पाते हैं और उसे प्राप्त कर सकते हैं।
            यह श्लोक माँ को एक 'दिव्य चिकित्सक' के रूप में देखता है जो हमारे अस्तित्व के हर स्तर पर हमें स्वस्थ करती हैं।
            माँ की ऊर्जा हमारे भीतर एक ऐसी जीवनी शक्ति भर देती है जो किसी भी बाहरी रोग या बाधा से हमें बचाती है।
        """.trimIndent(),
        english = """
            O Chandika! To those who praise You with absolute faith, You are the annihilator of all ailments and diseases.
            Ailments (Vyadhi) are not just physical; they include mental stress, jealousy, and greed—the Mother ends them all.
            O Mother! Grant me the form of virtues, victory in life, and great fame, and slaughter my enemies of ignorance.
            Praising the Mother purifies our hearts and connects us to that supreme health which is the soul's natural state.
            Only when the mind is calm and disease-free can we understand and achieve the real purpose of human life.
            This verse views the Mother as the 'Divine Physician' who heals us at every level of our earthly existence.
            Her energy fills us with a life-force that guards us against any external disease or psychological obstacle.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 12,
        sanskrit = "चण्डिके सततं ये त्वामर्चयन्तीह भक्तितः । रूपं देहि जयं देहि यशो देहि द्विषो जहि ॥",
        hindi = """
            हे चण्डिके! जो भी भक्त इस संसार में निरंतर (सतत) प्रेम और भक्ति के साथ आपकी अर्चना और पूजा करते हैं।
            (माँ उन पर अपनी ममतामयी छाया हमेशा बनाए रखती हैं और उन्हें कभी भी अकेला नहीं छोड़तीं)।
            हे माता! मुझे दिव्य रूप, हर मोड़ पर विजय और उज्ज्वल यश दें, और मेरे भीतरी शत्रुओं का पूरी तरह नाश करें।
            सतत अर्चना का अर्थ है माँ को केवल मंदिर में नहीं, बल्कि अपने हर काम और हर सांस में याद रखना।
            निरंतरता ही साधना की वह कुंजी है जो भक्त के हृदय को ईश्वर का स्थायी निवास स्थान बना देती है।
            यह प्रार्थना हमें अनुशासन और धैर्य सिखाती है कि भक्ति कोई एक दिन का काम नहीं, बल्कि जीवन जीने का तरीका है।
            माँ का निरंतर स्मरण ही वह सुरक्षा चक्र है जिसे दुनिया की कोई भी नकारात्मक शक्ति कभी भेद नहीं सकती।
        """.trimIndent(),
        english = """
            O Chandika! Whosoever in this world continuously (Satatam) worships You with immense love and devotion.
            (The Mother always keeps them under Her maternal shadow and never leaves them to struggle alone).
            O Mother! Grant me divine form, victory at every turn, and bright fame, and destroy my inner enemies entirely.
            Continuous worship (Archana) means remembering the Mother not just in a temple, but in every task and breath.
            Consistency is the spiritual key that transforms the devotee’s heart into a permanent dwelling for the Divine.
            This prayer teaches us discipline and patience—that devotion is not a one-day act, but a way of living life.
            Constant remembrance of the Mother is the protective shield that no negative force in the world can ever pierce.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 13,
        sanskrit = "देहि सौभाग्यमारोग्यं देहि मे परमं सुखम् । रूपं देहि जयं देहि यशो देहि द्विषो जहि ॥",
        hindi = """
            हे माता! आप मुझे जीवन का परम सौभाग्य, पूर्ण स्वास्थ्य (आरोग्य) और वह अविनाशी परम सुख प्रदान करें।
            परम सुख वह है जो इंद्रियों के भोगों से नहीं, बल्कि आत्मा के परमात्मा से मिलन से उत्पन्न होता है।
            हे देवी! आप मुझे आत्मिक रूप, अचल विजय और निर्मल यश दें, और मेरे शत्रुओं का पूरी तरह अंत करें।
            सौभाग्य और आरोग्य के बिना जीवन संघर्ष बन जाता है; माँ इन दोनों को देकर साधक का मार्ग सुगम बनाती हैं।
            यह श्लोक सर्वांगीण उन्नति (Overall growth) की प्रार्थना है जहाँ शरीर, मन और आत्मा—तीनों का कल्याण माँगा गया है।
            जब हमारे पास माँ का दिया हुआ सुख होता है, तो बाहरी परिस्थितियां हमें कभी भी दुखी या विचलित नहीं कर सकतीं।
            माँ की कृपा ही वह शक्ति है जो एक साधारण जीवन को भी उत्सव और आनंद के महाकुंभ में बदल देती है।
        """.trimIndent(),
        english = """
            O Mother! Grant me supreme good fortune, perfect health (Arogya), and that imperishable supreme happiness.
            Supreme happiness is not derived from sensory pleasures, but from the soul’s union with the Divine Consciousness.
            O Goddess! Grant me spiritual form, steady victory, and spotless fame, and put a permanent end to my enemies.
            Without fortune and health, life becomes a struggle; the Mother grants these to make the seeker's path smooth.
            This verse is a prayer for holistic growth—seeking the welfare of the body, mind, and soul simultaneously.
            When we possess the joy bestowed by the Mother, external circumstances can never make us miserable or disturbed.
            Her grace is the singular power that transforms an ordinary life into a grand celebration of divine bliss.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 14,
        sanskrit = "विधेहि द्विषतां नाशं विधेहि बलमुच्चकैः । रूपं देहि जयं देहि यशो देहि द्विषो जहि ॥",
        hindi = """
            हे माता! आप मेरे सभी आंतरिक और बाहरी शत्रुओं का पूर्ण नाश करें और मेरे भीतर असीमित आत्म-बल (उच्चकैः बलम्) जाग्रत करें।
            सच्चा बल वह है जो हमें विपरीत परिस्थितियों में भी टूटने नहीं देता और सत्य के मार्ग पर अडिग खड़ा रखता है।
            हे देवी! मुझे आध्यात्मिक रूप, हर क्षेत्र में विजय और पावन यश दें, और मेरे दुर्गुणों रूपी शत्रुओं का संहार करें।
            शत्रुओं का नाश करने का अर्थ है हमारे उन विकारों का मरना जो हमें क्रोध और नफरत से भर देते हैं।
            'उच्चकैः बलम्' की मांग हमें याद दिलाती है कि बिना शक्ति के ज्ञान भी अधूरा है; माँ हमें शक्ति और ज्ञान दोनों देती हैं।
            यह प्रार्थना साधक को ऊर्जा से भर देती है और उसे जीवन की चुनौतियों से लड़ने के लिए मानसिक रूप से तैयार करती है।
            माँ का दिया हुआ बल ही वह अदृश्य कवच है जो हमें बुराई से लड़ने और अच्छाई को बचाने की ताकत देता है।
        """.trimIndent(),
        english = """
            O Mother! Bring about the total destruction of my inner and outer enemies and awaken unlimited soul-force within me.
            True strength (Uchhakaih Balam) is that which prevents us from breaking under pressure and keeps us on the path of Truth.
            O Goddess! Grant me spiritual form, victory in all fields, and sacred fame, and slay my enemies of vice.
            Destroying enemies means the death of those flaws within us that fill our hearts with anger and hatred.
            Asking for 'Supreme Strength' reminds us that wisdom without power is incomplete; the Mother grants both.
            This prayer energizes the seeker, mentally preparing them to face and conquer the various challenges of life.
            The strength bestowed by the Mother is the invisible armor that empowers us to fight evil and protect goodness.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 15,
        sanskrit = "विधेहि देवि कल्याणं विधेहि परमां श्रियम् । रूपं देहि जयं देहि यशो देहि द्विषो जहि ॥",
        hindi = """
            हे देवी! आप मेरा परम कल्याण करें और मुझे सर्वोच्च 'श्री' (धन, वैभव और आध्यात्मिक संपदा) प्रदान करें।
            कल्याण का अर्थ है वह सब कुछ जो मेरी आत्मा की उन्नति के लिए आवश्यक है और मुझे मुक्ति की ओर ले जाए।
            हे माँ! आप मुझे दिव्य रूप, हर बाधा पर विजय और महान यश दें, और मेरे शत्रुओं का पूरी तरह नाश करें।
            'परमां श्रियम्' केवल भौतिक संपदा नहीं है, बल्कि वह आंतरिक समृद्धि है जो मनुष्य को उदार और महान बनाती है।
            माँ का विधान हमेशा हमारे लिए शुभ होता है, चाहे वह हमें तुरंत समझ आए या न आए; माँ हमेशा हमारा भला करती हैं।
            यह श्लोक हमें विश्वास दिलाता है कि माँ हमारी भौतिक और आध्यात्मिक—दोनों जरूरतों को पूरी तरह से जानती और भरती हैं।
            जब कल्याण का मार्ग माँ तय करती हैं, तो सफलता और शांति हमारे जीवन का एक स्थायी हिस्सा बन जाते हैं।
        """.trimIndent(),
        english = """
            O Goddess! Ordain my ultimate welfare and bestow upon me the supreme 'Shri' (wealth, opulence, and spiritual assets).
            Welfare (Kalyanam) means everything that is necessary for the soul's evolution and leads one toward final liberation.
            O Mother! Grant me divine form, victory over every obstacle, and immense fame, and destroy my enemies entirely.
            'Parama Shri' is not just material wealth, but that inner richness which makes a human being generous and great.
            The Mother's ordainment is always auspicious for us, whether we understand it immediately or not; She always does us good.
            This verse assures the seeker that the Mother fully knows and fulfills both our physical and spiritual requirements.
            When the path of welfare is decided by the Mother, success and peace become a permanent part of our existence.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 16,
        sanskrit = "सुरासुरशिरोरत्ननिघृष्टचरणेऽम्बिके । रूपं देहि जयं देहि यशो देहि द्विषो जहि ॥",
        hindi = """
            हे अम्बिके! आपके चरण इतने पावन हैं कि देवता और दानव जब झुकते हैं, तो उनके मुकुटों के रत्न आपके चरणों को स्पर्श करते हैं।
            (अर्थात आप इस ब्रह्मांड की सबसे ऊँची सत्ता हैं, जिनके सामने बड़ी से बड़ी ताकतें भी अपना सिर झुकाती हैं)।
            ऐसी परम सत्ता! आप मुझे आत्मिक रूप, अजेय जीत और दिव्य यश प्रदान करें, और मेरे अज्ञान रूपी शत्रुओं का संहार करें।
            देवताओं और असुरों का झुकना यह सिद्ध करता है कि माँ की शक्ति सृष्टि के हर सृजनात्मक और संहारक पक्ष से ऊपर है।
            यह श्लोक हमें सिखाता है कि जो माँ की शरण में आता है, उसे संसार के किसी भी राजा या शक्ति से डरने की जरूरत नहीं है।
            माँ के चरणों की सेवा ही वह सर्वोच्च पद है जिसे पाकर मनुष्य जन्म-मृत्यु के सभी चक्रों से हमेशा के लिए मुक्त हो जाता है।
            यह प्रार्थना भक्त के हृदय में स्वाभिमान और शक्ति का संचार करती है कि वह उस सर्वोच्च माँ का संतान है।
        """.trimIndent(),
        english = """
            O Ambika! Your feet are so sacred that when gods and demons bow, the gems of their crowns touch Your divine feet.
            (Meaning You are the ultimate authority of this cosmos, before whom even the mightiest powers must surrender).
            O Supreme Authority! Grant me spiritual form, invincible victory, and divine fame, and slaughter my enemies of ignorance.
            The bowing of both gods and demons proves that Her power transcends every creative and destructive aspect of existence.
            This verse teaches us that one who takes refuge in the Mother need not fear any worldly ruler or earthly power.
            Serving Her feet is the highest status, attaining which a human is freed from all cycles of birth and death forever.
            This prayer instills self-respect and strength in the heart of the devotee, knowing they are the child of the Supreme Mother.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 17,
        sanskrit = "विद्यावन्तं यशस्वन्तं लक्ष्मीवन्तं जनं कुरु । रूपं देहि जयं देहि यशो देहि द्विषो जहि ॥",
        hindi = """
            हे माता! आप मुझे विद्या से युक्त (बुद्धिमान), यश से युक्त (सम्मानित) और लक्ष्मी से युक्त (संपन्न) बना दें।
            विद्या वह है जो हमें अज्ञान से मुक्त करे, और लक्ष्मी वह है जो हमारे जीवन को मंगलमय और परोपकारी बनाए।
            हे देवी! आप मुझे दिव्य रूप, जीवन के संघर्षों में जय और उत्तम यश दें, और मेरे शत्रुओं का विनाश करें।
            यह श्लोक 'सार्थक जीवन' की तीन सबसे बड़ी आवश्यकताओं—ज्ञान, सम्मान और समृद्धि—की संतुलित प्रार्थना है।
            बिना विद्या के धन व्यर्थ है, और बिना लक्ष्मी के ज्ञान का प्रचार कठिन है; माँ हमें इन सबका पूर्ण संगम प्रदान करती हैं।
            जब हम माँ के 'जन' (सेवक) बन जाते हैं, तो ये सभी सिद्धियां हमारे पीछे-पीछे छाया की तरह चलने लगती हैं।
            माँ की कृपा से हम न केवल खुद सफल होते हैं, बल्कि दूसरों के जीवन को भी प्रकाशमान करने के योग्य बन जाते हैं।
        """.trimIndent(),
        english = """
            O Mother! Make me wise (Vidyavantam), honored (Yashasvantam), and prosperous (Lakshmivantam).
            Wisdom is that which frees us from ignorance, and Prosperity is that which makes our lives auspicious and philanthropic.
            O Goddess! Grant me divine form, victory in life’s struggles, and excellent fame, and destroy my enemies.
            This verse is a balanced prayer for the three greatest needs of a meaningful life: Knowledge, Respect, and Wealth.
            Wealth without wisdom is hollow, and wisdom without resources is hard to spread; the Mother grants a perfect blend of all.
            When we become Her 'Jana' (humble servants), all these perfections follow us like a faithful shadow.
            By Her grace, we do not just achieve personal success but also become capable of illuminating the lives of others.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 18,
        sanskrit = "प्रचण्डदैत्यदर्पघ्ने चण्डिके प्रणताय मे । रूपं देहि जयं देहि यशो देहि द्विषो जहि ॥",
        hindi = """
            हे भयंकर दैत्यों के दर्प (अहंकार) को कुचलने वाली माता चण्डिके! मैं आपके चरणों में पूरी तरह से शरणागत (प्रणत) हूँ।
            अहंकार वह दीवार है जो हमें ईश्वर से अलग करती है; माँ उस दीवार को गिराकर हमें सत्य से मिला देती हैं।
            हे माँ! आप मुझे आध्यात्मिक रूप, विजय का वरदान और पावन यश दें, और मेरे विकारों रूपी शत्रुओं का संहार करें।
            प्रचण्ड दैत्य हमारे वे पुराने संस्कार और आदतें हैं जो हमें सुधारने नहीं देते; माँ उन्हें समूल नष्ट कर देती हैं।
            प्रणत होने का अर्थ है यह मान लेना कि "हे प्रभु, मैं कुछ नहीं हूँ, आप ही सब कुछ हैं।" यही मुक्ति की शुरुआत है।
            यह प्रार्थना हमें गर्व और घमंड से बचाकर ईश्वर की असीम शक्ति के प्रति कृतज्ञता और समर्पण करना सिखाती है।
            माँ की कृपा ही वह अग्नि है जो हमारे भीतर के तामसिक अहंकार को जलाकर हमें सोने की तरह शुद्ध बना देती है।
        """.trimIndent(),
        english = """
            O Mother Chandika, who crushes the pride (Darpa) of fierce demons! I am completely surrendered at Your lotus feet.
            Ego is the wall that separates us from God; the Mother tears down that wall to unite us with the Ultimate Truth.
            O Mother! Grant me spiritual form, the boon of victory, and holy fame, and slaughter my enemies of vice.
            'Fierce demons' represent our deep-seated negative samskaras and habits that resist change; the Mother uproots them.
            Surrendering (Pranata) means accepting: "O Lord, I am nothing, You are everything." This is the beginning of liberation.
            This prayer saves us from pride and teaches us to offer gratitude and surrender to the infinite cosmic power.
            Her grace is the sacred fire that incinerates our dark ego, transforming us into something as pure as gold.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 19,
        sanskrit = "चतुर्भुजे चतुर्वक्त्रसंस्तुते परमेश्वरि । रूपं देहि जयं देहि यशो देहि द्विषो जहि ॥",
        hindi = """
            हे चार भुजाओं वाली और चार मुख वाले ब्रह्मा जी द्वारा निरंतर स्तुति की जाने वाली परमेश्वरी! आपको मेरा प्रणाम है।
            चार भुजाएं चार दिशाओं और चारों वेदों की शक्ति का प्रतीक हैं, जो आपके पूर्ण नियंत्रण में हैं।
            हे माँ! मुझे दिव्य रूप, हर कदम पर जय और पवित्र यश दें, और मेरे अज्ञान रूपी शत्रुओं का पूरी तरह संहार करें।
            ब्रह्मा जी द्वारा स्तुति करने का अर्थ है कि माँ ही पूरी सृष्टि की बुद्धिमत्ता (Intelligence) का वास्तविक स्रोत हैं।
            परमेश्वरी होने का अर्थ है कि आप ही वह अंतिम सत्ता हैं जिससे सभी देवी-देवता अपनी-अपनी शक्ति प्राप्त करते हैं।
            यह श्लोक हमें माँ की विराट और सर्वोच्च स्थिति का बोध कराकर हमारे मन को भक्ति की ऊंचाइयों पर ले जाता है।
            जब हम उस सर्वोच्च शक्ति का ध्यान करते हैं, तो हमारे जीवन की छोटी-छोटी समस्याएं और बाधाएं अपने आप समाप्त हो जाती हैं।
        """.trimIndent(),
        english = """
            O Four-armed Goddess, continuously praised by the four-faced Lord Brahma! Salutations to You, O Parameshwari.
            The four arms symbolize control over the four directions and the power of the four Vedas, which are under Your command.
            O Mother! Grant me divine form, victory at every step, and sacred fame, and slaughter my enemies of ignorance entirely.
            Being praised by Brahma implies that the Mother is the actual source of all creative intelligence in the entire cosmos.
            Being 'Parameshwari' means You are the ultimate authority from whom all other deities derive their specific powers.
            This verse elevates the seeker’s mind to the heights of devotion by realizing Her vast and supreme position.
            When we meditate on that absolute highest power, the small problems and obstacles of our life dissolve automatically.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 20,
        sanskrit = "कृष्णेन संस्तुते देवि शश्वद्भक्त्या सदाम्बिके । रूपं देहि जयं देहि यशो देहि द्विषो जहि ॥",
        hindi = """
            हे अम्बिके! भगवान श्री कृष्ण भी पूरी श्रद्धा और अटूट भक्ति के साथ हमेशा (शश्वद्) आपकी स्तुति और वंदना करते हैं।
            यह सिद्ध करता है कि आप ही वह योगमाया हैं जो भगवान विष्णु के अवतारों को भी उनके कार्यों में सहायता प्रदान करती हैं।
            हे देवी! मुझे आध्यात्मिक रूप, विजय का वरदान और श्रेष्ठ यश दें, और मेरे शत्रुओं का पूरी तरह नाश करें।
            भगवान कृष्ण की भक्ति का उल्लेख यह बताता है कि माँ की शक्ति ही धर्म की रक्षा और अधर्म के नाश का असली आधार है।
            यह श्लोक हमें सिखाता है कि जब स्वयं भगवान माँ की पूजा करते हैं, तो मनुष्य के लिए तो यह परम सौभाग्य की बात है।
            माँ की कृपा से ही मनुष्य के जीवन में वह 'कृष्ण-तत्व' (आनंद और कर्मयोग) जाग्रत होता है जो उसे सफल बनाता है।
            यह प्रार्थना हमारे भीतर भक्ति के बीज को गहरा करती है और हमें सर्वोच्च सत्य के और भी करीब ले जाती है।
        """.trimIndent(),
        english = """
            O Ambika! Even Lord Sri Krishna always praises and worships You with absolute faith and eternal (Shashvat) devotion.
            This proves that You are the Yogamaya who assists even the incarnations of Lord Vishnu in their cosmic missions.
            O Goddess! Grant me spiritual form, the boon of victory, and excellent fame, and destroy my enemies entirely.
            Mentioning Krishna's devotion shows that Mother’s power is the true basis for protecting Dharma and ending evil.
            This verse teaches us that if God Himself worships the Mother, it is a matter of supreme fortune for a human to do so.
            By Her grace alone, the 'Krishna-principle' (bliss and selfless action) awakens within a person, leading to success.
            This prayer deepens the seed of devotion within us and brings us closer to the absolute, ultimate Truth.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 21,
        sanskrit = "हिमाचलसुतानाथसंस्तुते परमेश्वरि । रूपं देहि जयं देहि यशो देहि द्विषो जहि ॥",
        hindi = """
            हे परमेश्वरि! पर्वतराज हिमालय की पुत्री माता पार्वती के स्वामी स्वयं भगवान शिव (हिमाचल-सुता-नाथ) आपकी स्तुति करते हैं।
            (अर्थात आप स्वयं शिव की भी आत्मा और उनकी मूल शक्ति—आदिशक्ति—हैं)।
            हे देवी! मुझे दिव्य रूप, अजेय जीत और पवित्र यश दें, और मेरे दुर्गुणों रूपी शत्रुओं का संहार करें।
            शिव और शक्ति का मिलन ही ब्रह्मांड का आधार है; माँ के बिना शिव भी 'शव' के समान हैं, यह तन्त्र का गूढ़ रहस्य है।
            माँ की वंदना साक्षात् महादेव द्वारा किया जाना यह बताता है कि माँ ही मोक्ष और ज्ञान की अंतिम दात्री हैं।
            यह श्लोक साधक को पूर्णता और संतुलन का बोध कराता है, जहाँ शक्ति का सही उपयोग कल्याण के लिए होता है।
            जब हम माँ को शिव की शक्ति के रूप में पूजते हैं, तो हमारे जीवन में स्थिरता (शिव) और गति (शक्ति) का अद्भुत संगम होता है।
        """.trimIndent(),
        english = """
            O Parameshwari! Even the Lord of the daughter of the Himalayas (Lord Shiva) eternally sings Your supreme praises.
            (Meaning You are the very soul and the primordial power—Adi-Shakti—of Lord Shiva himself).
            O Goddess! Grant me divine form, invincible victory, and sacred fame, and slaughter my enemies of vice.
            The union of Shiva and Shakti is the foundation of the cosmos; without Shakti, Shiva is like a 'corpse' (Shava).
            The fact that Mahadeva worships Her shows that She is the ultimate bestower of liberation and cosmic wisdom.
            This verse provides the seeker with a sense of completeness and balance, where power is used for total welfare.
            Worshiping Her as Shiva's power brings an amazing harmony of stillness (Shiva) and dynamic energy (Shakti) into our lives.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 22,
        sanskrit = "इन्द्राणीपतिसद्भावपूजिते परमेश्वरि । रूपं देहि जयं देहि यशो देहि द्विषो जहि ॥",
        hindi = """
            हे परमेश्वरि! इंद्राणी के पति स्वर्ग के राजा देवराज इन्द्र भी अत्यंत सच्चे और पवित्र भाव के साथ आपकी पूजा करते हैं।
            आप स्वर्ग के ऐश्वर्य की स्वामिनी हैं और बड़े से बड़े देवताओं के सिंहासन की रक्षा भी आप ही करती हैं।
            हे माता! मुझे आध्यात्मिक रूप, विजय का वरदान और दिव्य यश दें, और मेरे शत्रुओं का पूरी तरह अंत करें।
            इन्द्र का पूजन यह बताता है कि संसार की कोई भी सफलता या पद माँ की कृपा के बिना सुरक्षित नहीं रह सकता।
            सद्भाव (सच्चा भाव) ही वह इकलौती मुद्रा है जिससे माँ का प्रेम और उनका आशीर्वाद खरीदा जा सकता है।
            यह प्रार्थना हमें याद दिलाती है कि सत्ता और अधिकार तभी सार्थक हैं जब वे माँ के चरणों में समर्पित हों।
            माँ की कृपा से ही मनुष्य के जीवन में वह 'राजयोग' आता है जहाँ वह राजा की तरह जीता है पर आसक्त नहीं होता।
        """.trimIndent(),
        english = """
            O Parameshwari! Even the husband of Indrani, King Indra of Heaven, worships You with absolute true and pure intent.
            You are the sovereign of celestial opulence and the guardian of even the highest thrones of the major gods.
            O Mother! Grant me spiritual form, the boon of victory, and divine fame, and put a permanent end to my enemies.
            Indra’s worship signifies that no success or position in the world can remain secure without the Mother’s grace.
            'Sadbhava' (pure intent) is the only currency with which Her divine love and absolute blessings can be earned.
            This prayer reminds us that power and authority are meaningful only when they are surrendered at Her lotus feet.
            By Her grace alone, one attains 'Rajyoga'—where one lives like a king but remains completely detached within.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 23,
        sanskrit = "देवि प्रचण्डदोर्दण्डदैत्यदर्पविनाशिनि । रूपं देहि जयं देहि यशो देहि द्विषो जहि ॥",
        hindi = """
            हे अपनी भुजाओं के प्रचंड बल पर घमंड करने वाले दैत्यों के अहंकार को नष्ट करने वाली माता! आपको मेरा नमस्कार है।
            भुजाओं का बल (Physical power) जब अहंकार बन जाता है, तो वह विनाश का कारण बनता है; माँ उस भ्रम को तोड़ देती हैं।
            हे देवी! मुझे दिव्य रूप, हर बाधा पर विजय और उज्ज्वल यश दें, और मेरे भीतर के अज्ञान का पूरी तरह नाश करें।
            दर्प (Pride) वह पर्दा है जो हमें अपनी सीमाओं को देखने नहीं देता; माँ उस पर्दे को फाड़कर हमें वास्तविकता दिखाती हैं।
            माँ का यह स्वरूप हमें सिखाता है कि असली ताकत शरीर में नहीं, बल्कि उस 'चेतना' में है जो शरीर को चलाती है।
            यह प्रार्थना साधक को सिखाती है कि वह अपनी सफलताओं पर घमंड न करें, बल्कि उन्हें माँ की कृपा का फल मानें।
            जब हम माँ की शक्ति को स्वीकार करते हैं, तो हमारा अपना बल भी दिव्य होकर धर्म की रक्षा के काम आता है।
        """.trimIndent(),
        english = """
            O Mother who shatters the pride of demons who boasted of the fierce strength of their massive arms! I bow to You.
            Physical power, when transformed into arrogance, leads to ruin; the Mother shatters that dangerous delusion.
            O Goddess! Grant me divine form, victory over every obstacle, and bright fame, and destroy the ignorance within me.
            'Darpa' (Pride) is the veil that prevents us from seeing our limitations; She tears that veil to show us reality.
            This form teaches us that true strength resides not in the physical body, but in the 'Consciousness' that drives it.
            This prayer teaches the seeker not to be arrogant about personal successes but to see them as fruits of Her grace.
            When we acknowledge Her power, our own strength becomes divine and is utilized for the protection of Dharma.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 24,
        sanskrit = "देवि भक्तजनोद्दामदत्तानन्दोदयेऽम्बिके । रूपं देहि जयं देहि यशो देहि द्विषो जहि ॥",
        hindi = """
            हे देवी! हे अम्बिके! आप अपने भक्तों के हृदय में असीम और प्रबल (उद्दाम) आनंद का उदय करने वाली परम माता हैं।
            सच्चा आनंद वह है जो बिना किसी कारण के होता है और जो कभी घटता नहीं; माँ वही आनंद अपने भक्तों को देती हैं।
            हे माँ! मुझे आध्यात्मिक रूप, अजेय जीत और दिव्य यश प्रदान करें, और मेरे शत्रुओं का पूरी तरह संहार करें।
            माँ का भक्त कभी उदास या निराश नहीं रह सकता, क्योंकि माँ की उपस्थिति ही उसके लिए सबसे बड़ा उत्सव है।
            'आनंदोदय' का अर्थ है कि माँ हमारे भीतर के उस सोते हुए आनंद को जगा देती हैं जो पहले से वहाँ मौजूद था।
            यह प्रार्थना हमें उस परम सुख की ओर ले जाती है जिसे पाने के बाद दुनिया की कोई भी वस्तु फीकी लगने लगती है।
            जब हम माँ के प्रेम में खो जाते हैं, तो हमारा पूरा अस्तित्व ही आनंद की एक सुंदर लहर बन जाता है।
        """.trimIndent(),
        english = """
            O Goddess! O Ambika! You are the supreme Mother who causes the rise of boundless and intense bliss in Your devotees.
            True bliss (Ananda) is that which occurs without a worldly reason and never diminishes; She grants exactly that.
            O Mother! Grant me spiritual form, invincible victory, and divine fame, and slaughter my enemies entirely.
            A devotee of the Mother can never remain dejected or hopeless, for Her very presence is a grand celebration.
            'Anandodaya' implies that She awakens that dormant bliss within us which was already present in our soul.
            This prayer leads us toward that supreme joy, after attaining which all worldly objects seem pale and insignificant.
            When we are lost in Her divine love, our entire existence transforms into a beautiful, rhythmic wave of bliss.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 25,
        sanskrit = "पत्नीं मनोरमां देहि मनोवृत्तानुसारिणीम् । तारिणीं दुर्गसंसारसागरस्य कुलोद्भवाम् ॥",
        hindi = """
            (साधक की प्रार्थना): हे माता! मुझे मन को भाने वाली ऐसी जीवनसाथी दें, जो मेरी भावनाओं और विचारों को समझने वाली हो।
            जो उत्तम कुल के संस्कारों से युक्त हो और जो इस कठिन संसार रूपी सागर को पार कराने में मेरी सच्ची साथी बने।
            यह श्लोक केवल एक पत्नी की मांग नहीं है, बल्कि एक 'आध्यात्मिक साझेदारी' (Spiritual partnership) की प्रार्थना है।
            जीवन का सफर तभी सुखद होता है जब साथ चलने वाला व्यक्ति हमें हमारे आध्यात्मिक लक्ष्य के करीब ले जाए।
            'तारिणी' शब्द बताता है कि एक अच्छा जीवनसाथी हमारे मोक्ष के मार्ग में सबसे बड़ा सहायक और रक्षक हो सकता है।
            माँ से यह मांग करना यह दर्शाता है कि हमारे परिवार और रिश्तों का आधार भी माँ की कृपा और आशीर्वाद ही है।
            यह प्रार्थना हमें रिश्तों में पवित्रता, समझ और ईश्वर के प्रति सामूहिक समर्पण की महत्ता को बहुत गहराई से सिखाती है।
        """.trimIndent(),
        english = """
            (The seeker's prayer): O Mother! Grant me a life-partner who is pleasing to the mind and follows my inner mental leanings.
            Who is born of a noble lineage and who acts as a savior, helping me cross this difficult ocean of worldly existence.
            This verse is not merely a request for a spouse, but a prayer for a true 'Spiritual Partnership' in life.
            The journey of life is only blissful when the one walking with us brings us closer to our ultimate spiritual goal.
            The word 'Tarini' suggests that a noble partner can be the greatest guide and protector on the path to liberation.
            Seeking this from the Mother shows that the foundation of our family and relationships is Her grace and blessing.
            This prayer deeply teaches us the importance of purity, understanding, and collective surrender to God in relationships.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 26,
        sanskrit = "इदं स्तोत्रं पठित्वा तु महास्तोत्रं पठेन्नरः । स तु सप्तशतीसंख्यावरमाप्नोति सम्पदाम् ॥",
        hindi = """
            (फलश्रुति): जो मनुष्य पहले इस अर्गला स्तोत्र का पाठ करता है और उसके बाद दुर्गा सप्तशती रूपी महास्तोत्र का पाठ करता है।
            वह साधक सप्तशती के मन्त्रों की संख्या के समान ही (अर्थात अनंत) श्रेष्ठ वरदानों और संपत्तियों को प्राप्त कर लेता है।
            अर्गला स्तोत्र वह भूमिका है जो हमारे हृदय को सप्तशती की महाशक्ति को ग्रहण करने के लिए पूरी तरह तैयार करती है।
            यह श्लोक हमें साधना के सही क्रम और अनुशासन का महत्व समझाता है कि हर महान कार्य की एक आवश्यक तैयारी होती है।
            माँ की संपत्ति केवल सोना-चांदी नहीं, बल्कि संतोष, विवेक और ईश्वर के प्रति अटूट प्रेम की वह दौलत है जो कभी खत्म नहीं होती।
            जब हम विधिपूर्वक माँ की आराधना करते हैं, तो माँ का आशीर्वाद हमारे जीवन के हर आयाम में साक्षात् झलकने लगता है।
            यह वादा हमें धैर्य और विश्वास के साथ अपनी साधना को पूर्ण करने के लिए निरंतर और गहराई से प्रोत्साहित करता है।
        """.trimIndent(),
        english = """
            (Result): The person who first recites this Argala Stotram and then proceeds to recite the great Durga Saptashati...
            Attains supreme boons and wealth equivalent to the number of mantras in the Saptashati (which is infinite).
            The Argala Stotram is the prerequisite that prepares the heart to receive the massive power of the Saptashati.
            This verse teaches us the importance of correct sequence and discipline in practice—every great act needs preparation.
            The Mother’s wealth is not just gold or silver, but the riches of contentment, wisdom, and eternal divine love.
            When we worship Her with the correct method, Her blessings manifest vividly in every single dimension of our life.
            This promise encourages the seeker to complete their spiritual practice with patience, depth, and total faith.
        """.trimIndent()
    ),
    ArgalaShloka(
        id = 27,
        sanskrit = "इति श्रीमार्कण्डेयपुराणे अर्गलास्तोत्रं सम्पूर्णम् ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
        hindi = """
            (समापन): इस प्रकार श्री मार्कण्डेय पुराण में वर्णित यह परम पावन 'अर्गला स्तोत्र' अपनी पूर्णता को प्राप्त होता है।
            ॐ शांति, शांति, शांति! माता दुर्गा की असीम कृपा से हमारे शरीर, मन और आत्मा के सभी कष्ट पूर्ण रूप से शांत हों।
            स्तोत्र का पूर्ण होना केवल शब्दों का अंत नहीं, बल्कि साधक के भीतर एक नई आध्यात्मिक चेतना का उदय और विकास है।
            यह शांति पाठ हमें याद दिलाता है कि सारी साधना का अंतिम लक्ष्य अपने भीतर और ब्रह्मांड में अखंड शांति स्थापित करना है।
            अर्गला स्तोत्र के पाठ के बाद हमारा हृदय उस महादेवी के स्वागत के लिए तैयार है, जो समस्त जगत की स्वामिनी हैं।
            माँ भगवती की कृपा हम सब पर सदैव एक अभेद्य सुरक्षा कवच बनकर बनी रहे और हमारा जीवन मंगलमय हो।
            यहीं पर ताला खुल चुका है, अब साधक सप्तशती के अगाध और दिव्य ज्ञान-सागर में डुबकी लगाने के लिए पूरी तरह स्वतंत्र है।
        """.trimIndent(),
        english = """
            (Conclusion): Thus, the profoundly sacred 'Argala Stotram' from the Sri Markandeya Purana reaches its completion.
            Om Peace, Peace, Peace! By the grace of Mother Durga, may all afflictions of our body, mind, and soul be stilled.
            The completion of the stotram is not just the end of words, but the rise of a new spiritual consciousness within.
            This peace chant reminds us that the ultimate goal of all spiritual practice is to establish unbroken peace within.
            After reciting Argala, our heart is ready to welcome the Great Goddess, the absolute sovereign of the entire universe.
            May the Mother's grace always remain a protective shield for us all, making our lives auspicious and divine.
            The bolt is now unlatched; the seeker is now free to dive into the deep and divine ocean of the Durga Saptashati.
        """.trimIndent()
    )
)