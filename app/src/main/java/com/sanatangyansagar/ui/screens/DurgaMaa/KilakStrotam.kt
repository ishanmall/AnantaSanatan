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
data class KilakShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

// 2. Main Screen Composable
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KilakStrotamScreen() {
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
                // Validates if the number is between 1 and 14
                if (shlokaNumber != null && shlokaNumber in 1..14) {
                    coroutineScope.launch {
                        // Smoothly scrolls to the exact Shloka
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-14)") },
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
            itemsIndexed(kilakShlokasList) { _, shloka ->
                KilakShlokaCard(shloka = shloka)
            }
        }
    }
}

// 3. Shloka Card Composable
@Composable
fun KilakShlokaCard(shloka: KilakShloka) {
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
// 4. Data List (Exactly 14 Shlokas of Kilak Stotram with Detailed Translations)
val kilakShlokasList: List<KilakShloka> = listOf(
    KilakShloka(
        id = 1,
        sanskrit = "ॐ अस्य श्रीकीलकस्तोत्रमन्त्रस्य शिव ऋषिः, अनुष्टुप् छन्दः, श्रीमहासस्वती देवता, श्रीजगदम्बाप्रीतये सप्तशतीपाठाङ्गत्वेन जपे विनियोगः ॥\nॐ विशुद्धज्ञानदेहाय त्रिवेदीदिव्यचक्षुषे । श्रेयःप्राप्तिनिमित्ताय नमः सोमार्धधारिणे ॥ १ ॥",
        hindi = """
            (विनियोग): इस पवित्र कीलक स्तोत्र के ऋषि भगवान शिव हैं और इसकी अधिष्ठात्री देवी माँ महासरस्वती हैं। 
            इसका पाठ भगवती जगदम्बा की प्रसन्नता और दुर्गा सप्तशती के मन्त्रों की शक्ति जाग्रत करने के लिए किया जाता है।
            (श्लोक १): मैं उन भगवान शिव को प्रणाम करता हूँ जिनका स्वरूप साक्षात् शुद्ध ज्ञान का पुंज है।
            वे अपने मस्तक पर अर्धचन्द्र धारण करते हैं और तीनों वेद (ऋग्, यजुर्, साम) ही उनके दिव्य नेत्र हैं।
            वे ही संसार के समस्त सुखों, कल्याण और मोक्ष की प्राप्ति के एकमात्र परम कारण और आधार हैं।
            उनका सान्निध्य साधक के अज्ञान को मिटाकर उसे परम पद की ओर ले जाने वाला है।
        """.trimIndent(),
        english = """
            (Viniyoga): Lord Shiva is the Sage of this sacred Kilak Stotram, and the presiding Deity is Sri Mahasaraswati. 
            It is practiced as an essential part of the Saptashati to win the grace of Mother Jagadamba.
            (Shloka 1): I bow to Lord Shiva, the embodiment of pure, untainted consciousness and wisdom.
            He bears the crescent moon upon His brow, and the three Vedas constitute His divine vision.
            He is the prime cause and source for attaining ultimate welfare, prosperity, and spiritual liberation.
            His presence dissolves the darkness of ignorance and aligns the seeker with the highest truth.
        """.trimIndent()
    ),
    KilakShloka(
        id = 2,
        sanskrit = "सर्वमेतद्विजानीयान्मन्त्राणामपि कीलकम् । सोऽपि क्षेममवाप्नोति सततं जाप्यतत्परः ॥ २ ॥",
        hindi = """
            जो मनुष्य दुर्गा सप्तशती के इन गोपनीय मन्त्रों के 'कीलक' (ताले) के रहस्य को गहराई से समझ लेता है,
            अर्थात यह जान लेता है कि भगवान शिव ने इन मन्त्रों की शक्ति को सुरक्षित रखने के लिए उन्हें कीलित किया है,
            वही साधक वास्तव में इन मन्त्रों का फल प्राप्त करने का अधिकारी होता है।
            जो व्यक्ति एकाग्र होकर इस कीलक स्तोत्र का निरंतर जप और मनन करता है,
            माँ भगवती की कृपा से उसे जीवन के हर क्षेत्र में सुरक्षा, शांति और परम कल्याण (क्षेम) प्राप्त होता है।
            यह कीलक ही वह माध्यम है जो सप्तशती के गुप्त आध्यात्मिक खजाने के द्वार खोलता है।
        """.trimIndent(),
        english = """
            One who deeply understands the mystery of the 'Kilak' (the spiritual lock) of these mantras,
            Realizing why Lord Shiva secured their immense power to prevent misuse by the unworthy,
            Truly becomes eligible to reap the divine fruits of the Saptashati recitation.
            A seeker who is constantly devoted to the chanting and contemplation of this Kilak Stotram,
            Attains absolute security, inner peace, and perfect well-being (Kshema) by the Mother's grace.
            This Kilak acts as the bridge that connects the devotee to the guarded spiritual treasures of the Goddess.
        """.trimIndent()
    ),
    KilakShloka(
        id = 3,
        sanskrit = "सिद्ध्यन्त्युच्चाटनादीनि कर्माणि सकलान्यपि । एतेन स्तुवतां देवीं स्तोत्रमात्रेण सिद्ध्यति ॥ ३ ॥",
        hindi = """
            जो भक्त केवल इस कीलक स्तोत्र के द्वारा माँ भगवती की प्रेमपूर्वक स्तुति करता है, 
            उसके जीवन के 'उच्चाटन' (नकारात्मक शक्तियों का विनाश) जैसे सभी कठिन कार्य सिद्ध हो जाते हैं।
            साधक के मार्ग में आने वाली समस्त बाधाएं, चाहे वे बाहरी हों या आंतरिक, स्वतः ही शांत होने लगती हैं।
            यह स्तोत्र इतना प्रभावशाली है कि इसके पाठ मात्र से देवी की असीम करुणा जाग्रत हो जाती है।
            बिना किसी विशेष बाहरी अनुष्ठान के भी भक्त अपनी आध्यात्मिक और सांसारिक मनोकामनाएं पूर्ण कर लेता है।
            माँ की शक्ति का यह दिव्य प्रवाह साधक के जीवन को सफलताओं और सिद्धियों से भर देता है।
        """.trimIndent(),
        english = """
            For the devotee who praises Goddess Bhagavati through this Kilak Stotram with love, 
            All difficult tasks like 'Uchchatana' (the eradication of evil forces) are perfectly accomplished.
            Every obstacle standing in the seeker's path, whether external or internal, begins to dissolve.
            This hymn is so potent that its mere recitation awakens the infinite compassion of the Mother.
            Even without complex rituals, the devotee succeeds in fulfilling both spiritual and worldly desires.
            This divine flow of energy ensures that the life of the practitioner is filled with success and perfections.
        """.trimIndent()
    ),
    KilakShloka(
        id = 4,
        sanskrit = "न मन्त्रो नौषधं तत्र न किञ्चिदपि विद्यते । विना जाप्येन सिद्ध्येत सर्वमुच्चाटनादिकम् ॥ ४ ॥",
        hindi = """
            इस स्तोत्र का पाठ करने वाले साधक को सिद्धि प्राप्त करने के लिए किसी अन्य मन्त्र की आवश्यकता नहीं होती।
            उसे अपनी रक्षा या समस्याओं के समाधान के लिए किसी विशेष औषधि या बाहरी उपाय की खोज नहीं करनी पड़ती।
            केवल इस कीलक स्तोत्र के श्रद्धापूर्वक जप करने मात्र से ही उच्चाटन आदि सभी दुष्कर कार्य सिद्ध हो जाते हैं।
            यह मन्त्र स्वयं में पूर्ण है और साधक के चारों ओर सुरक्षा का एक अभेद्य घेरा बना देता है।
            यह सिद्ध करता है कि सच्ची भक्ति और इस दिव्य पाठ का आश्रय ही हर संकट का अंतिम समाधान है।
            ईश्वर पर अटूट विश्वास ही वह परम शक्ति है जो बिना किसी अन्य साधन के असंभव को संभव बना देती है।
        """.trimIndent(),
        english = """
            A seeker who recites this hymn requires no other specialized mantras to attain spiritual success.
            He does not need to search for mystical medicines or external rituals to find protection or solutions.
            Merely through the faithful chanting of this Kilak Stotram, all massive tasks are flawlessly achieved.
            This stotram is self-sufficient, creating an impenetrable field of protection around the practitioner.
            It proves that sincere devotion and reliance on this divine text are the ultimate remedies for all crises.
            Unwavering faith in the Divine is the power that makes the impossible possible without any other aid.
        """.trimIndent()
    ),
    KilakShloka(
        id = 5,
        sanskrit = "समग्रान्यपि सिद्ध्यन्ति लोकशङ्कामिमां हरः । कृत्वा निमन्त्रयामास सर्वमेवमिदं शुभम् ॥ ५ ॥",
        hindi = """
            संसार के लोगों के मन में अक्सर यह शंका रहती है कि क्या केवल एक स्तोत्र से सब कुछ सिद्ध हो सकता है।
            मनुष्य की इसी स्वाभाविक शंका को दूर करने के लिए भगवान शिव ने सप्तशती की शक्ति को 'कीलित' (Locked) किया।
            उन्होंने यह व्यवस्था दी कि जो इस कीलक रहस्य को समझेगा, वही इसके शुभ और कल्याणकारी फलों को प्राप्त करेगा।
            शिव जी ने मन्त्रों की गोपनीयता को सुरक्षित रखने के लिए उन्हें कीलों (Locks) के माध्यम से नियंत्रित किया है।
            यह सुनिश्चित करता है कि साधक पूरी श्रद्धा, नियम और शुद्ध हृदय के साथ ही इस साधना में प्रवेश करे।
            जब यह ताला खुलता है, तब सप्तशती का पाठ साधक के जीवन के लिए परम मंगलकारी और शुभ बन जाता है।
        """.trimIndent(),
        english = """
            Worldly people often doubt whether a single hymn can truly grant all types of spiritual success.
            To address this human doubt, Lord Shiva 'locked' (Kilita) the raw power of the Durga Saptashati.
            He ordained that only those who understand this Kilak mystery shall reap its auspicious benefits.
            Lord Shiva secured the mantras with these spiritual locks to preserve their sanctity and secrecy.
            This ensures that the seeker enters this practice with absolute faith and a purified heart.
            Once this lock is released, the Saptashati recitation becomes profoundly transformative and beneficial.
        """.trimIndent()
    ),
    KilakShloka(
        id = 6,
        sanskrit = "स्तोत्रं वै चण्डिकायास्तु तच्च गुप्तं चकार सः । समाप्तिर्न च पुण्यस्य तां यथावन्नियन्त्रणाम् ॥ ६ ॥",
        hindi = """
            भगवान शिव ने माता चण्डिका की महिमा से भरे इस सप्तशती स्तोत्र को अत्यंत गुप्त (Secret) रखा था।
            उन्होंने इसे कीलित किया ताकि इसकी महाशक्ति केवल उन्हीं को मिले जो इसके वास्तविक पात्र हैं।
            जो साधक भगवान शिव द्वारा बताए गए नियमों और उत्कीलन विधि के अनुसार इसका श्रद्धा से पाठ करता है,
            उसके द्वारा अर्जित किए गए पुण्यों का कभी क्षय (विनाश) नहीं होता; वे पुण्य सदैव बढ़ते रहते हैं।
            विधिपूर्वक किया गया यह पाठ साधक के संचित कर्मों को शुद्ध कर उसे अक्षय पुण्य का भागी बनाता है।
            यह दिव्य नियंत्रण ही मन्त्रों की शक्ति को बिखरने से रोकता है और उसे साधक के भीतर केंद्रित करता है।
        """.trimIndent(),
        english = """
            Lord Shiva kept this Saptashati hymn, filled with Mother Chandika's glory, highly classified and secret.
            He locked it so that its immense cosmic power is revealed only to those who are truly deserving.
            The seeker who recites it with faith, following the rules and unlocking methods prescribed by Shiva,
            Finds that the spiritual merits (Punya) earned through this practice never diminish or expire.
            Reciting with the correct method purifies accumulated karmas and grants inexhaustible divine wealth.
            This sacred restriction prevents the leakage of energy and focuses it within the heart of the practitioner.
        """.trimIndent()
    ),
    KilakShloka(
        id = 7,
        sanskrit = "सोऽपि क्षेममवाप्नोति सर्वमेव न संशयः । कृष्णायां वा चतुर्दश्यामष्टम्यां वा समाहितः ॥ ७ ॥",
        hindi = """
            जो भक्त कृष्ण पक्ष की चतुर्दशी या अष्टमी जैसी अत्यंत प्रभावी तिथियों को माँ की उपासना करता है,
            और अपना मन पूरी तरह एकाग्र (समाहित) करके देवी के चरणों में अपना सर्वस्व अर्पण कर देता है,
            वह साधक निश्चित रूप से जीवन के सभी भयों से मुक्त होकर परम कल्याण और सुरक्षा (क्षेम) प्राप्त करता है।
            इसमें किसी भी प्रकार का कोई संशय या संदेह करने का लेश मात्र भी स्थान नहीं है।
            ये तिथियाँ विशेष ऊर्जा से भरी होती हैं, जिनमें की गई साधना का फल कई गुना बढ़कर मिलता है।
            माँ अपने शरणागत भक्त की रक्षा का उत्तरदायित्व स्वयं लेती हैं और उसे निर्भय बना देती हैं।
        """.trimIndent(),
        english = """
            The devotee who worships the Mother on potent dates like the 14th or 8th day of the dark fortnight,
            And surrenders his entire existence at Her feet with a deeply concentrated and stilled mind (Samahita),
            Undoubtedly attains supreme well-being, absolute protection, and lasting peace in his life.
            There is not even a shred of doubt or uncertainty regarding this divine law of protection.
            These specific lunar dates are charged with energy that amplifies the results of one's spiritual efforts.
            The Mother personally assumes responsibility for the seeker's safety and makes him entirely fearless.
        """.trimIndent()
    ),
    KilakShloka(
        id = 8,
        sanskrit = "ददाति प्रतिगृह्णाति नान्यथैषा प्रसीदति । इत्थं रूपेण कीलेन महादेवेन कीलितम् ॥ ८ ॥",
        hindi = """
            माँ भगवती केवल उस भक्त पर प्रसन्न होती हैं जो अपना सब कुछ (अहंकार सहित) उन्हें समर्पित कर देता है।
            और फिर जो कुछ भी उसे जीवन में मिलता है, उसे माता का प्रसाद समझकर ही विनम्रता से ग्रहण करता है।
            समर्पण और कृतज्ञता के बिना माँ की वास्तविक प्रसन्नता और कृपा प्राप्त करना असंभव है।
            भगवान महादेव ने सप्तशती के मन्त्रों को इसी समर्पण रूपी 'कील' (ताले) के द्वारा पूरी तरह सुरक्षित किया है।
            यह ताला केवल 'अहंकार' के मिटने और 'प्रेम' के जाग्रत होने पर ही स्वतः खुल जाता है।
            यही वह गुप्त कुंजी है जो साधक को देवी की अनंत शक्तियों और वरदानों का स्वामी बनाती है।
        """.trimIndent(),
        english = """
            Goddess Bhagavati is pleased only with the devotee who surrenders everything, including his ego, to Her.
            He then accepts whatever life offers strictly as Her divine grace or Prasad, with total humility.
            Without unconditional surrender and gratitude, it is impossible to attain Her true pleasure and grace.
            Lord Mahadeva has secured the Saptashati mantras with this exact 'Kilak' (lock) of ego-dissolution.
            This lock releases automatically only when individual pride vanishes and pure divine love awakens.
            This is the secret key that grants the practitioner access to the infinite powers and boons of the Devi.
        """.trimIndent()
    ),
    KilakShloka(
        id = 9,
        sanskrit = "यो निष्कीलां विधायैनां नित्यं जपति संस्फुटम् । स सिद्धः स गणः सोऽपि गन्धर्वो जायते नरः ॥ ९ ॥",
        hindi = """
            जो मनुष्य इस कीलक स्तोत्र के पाठ से सप्तशती को 'निष्कील' (Unlock) करके प्रतिदिन स्पष्ट पाठ करता है,
            वह इसी नश्वर शरीर में रहते हुए भी एक साक्षात् 'सिद्ध' पुरुष की अवस्था को प्राप्त कर लेता है।
            वह भगवान शिव का प्रिय 'गण' बन जाता है और उसकी आभा गंधर्वों के समान दिव्य और मनमोहक हो जाती है।
            स्पष्ट उच्चारण (संस्फुटम्) के साथ किया गया जप साधक की ध्वनि ऊर्जा को ब्रह्मांड से जोड़ देता है।
            ऐसा व्यक्ति जहाँ भी जाता है, वहाँ शांति, तेज और दिव्यता का स्वतः ही प्रसार होने लगता है।
            यह पाठ मनुष्य की साधारण चेतना को देवत्व की श्रेणी में ऊँचा उठाने की अद्भुत क्षमता रखता है।
        """.trimIndent(),
        english = """
            The person who 'unlocks' (Nishkila) the Saptashati via this hymn and recites it daily with clarity,
            Attains the exalted status of an enlightened 'Siddha' even while living in this mortal body.
            He becomes a beloved Gana (attendant) of Lord Shiva, radiating a divine, Gandharva-like aura.
            Chanting with perfect and clear pronunciation (Samshphutam) aligns one's vibration with the cosmos.
            Such an individual naturally spreads peace, brilliance, and divinity wherever he chooses to go.
            This practice possesses the incredible power to elevate ordinary human consciousness into the realm of divinity.
        """.trimIndent()
    ),
    KilakShloka(
        id = 10,
        sanskrit = "न चैवाप्यटतस्तस्य भयं क्वापीह जायते । नापमृत्युवशं याति मृतो मोक्षमवाप्नुयात् ॥ १० ॥",
        hindi = """
            माँ की शक्ति से सुरक्षित वह साधक इस पृथ्वी पर कहीं भी विचरण करे, उसे कभी कोई भय नहीं सताता।
            नकारात्मक शक्तियाँ, हिंसक जीव या शत्रु उसे देखकर स्वयं ही अपना मार्ग बदल लेते हैं।
            वह कभी भी 'अपमृत्यु' (अकाल या अनचाही मौत) का ग्रास नहीं बनता और सदैव सुरक्षित रहता है।
            और जब उसका जीवन पूर्ण होता है, तो वह बिना किसी कष्ट के सीधा परम मोक्ष (मुक्ति) को प्राप्त करता है।
            यह कवच साधक के चारों ओर एक सुरक्षा घेरा बनाता है जो मृत्यु के भय को भी जड़ से मिटा देता है।
            जीते-जी निर्भयता और मृत्यु के पश्चात शाश्वत शांति—यही इस महान पाठ का अंतिम और अमोघ फल है।
        """.trimIndent(),
        english = """
            A seeker protected by the Mother's power feels no fear, no matter where he travels on this earth.
            Negative energies, violent creatures, or enemies instinctively turn away at the sight of such a person.
            He is permanently shielded from 'Apamrityu' (untimely or accidental death), staying safe under Her care.
            When his earthly journey concludes, he effortlessly attains ultimate liberation (Moksha) from the cycle.
            This armor creates a protective sphere that uproots even the deepest fear of death from the subconscious.
            Fearlessness in life and eternal peace after death are the final and infallible fruits of this great hymn.
        """.trimIndent()
    ),
    KilakShloka(
        id = 11,
        sanskrit = "ज्ञात्वा प्रारभ्य कुर्वीत न कुर्वाणो विनश्यति । ततो ज्ञात्वैव सम्पूर्णमिदं प्रारभ्यते बुधैः ॥ ११ ॥",
        hindi = """
            सप्तशती के पाठ को इस 'उत्कीलन' (ताला खोलने) के रहस्य को पूरी तरह जानने के बाद ही शुरू करना चाहिए।
            जो मनुष्य अज्ञान या अहंकार वश इसे जाने बिना सीधा पाठ करता है, उसका आध्यात्मिक पतन (नाश) हो जाता है।
            अधूरा ज्ञान और विधिहीन साधना अक्सर लाभ की जगह मानसिक विक्षेप या हानि का कारण बन सकती है।
            इसीलिए जो अत्यंत बुद्धिमान और तत्वज्ञानी (बुध) साधक हैं, वे पहले इस कीलक रहस्य को सिद्ध करते हैं।
            पूरी विधि और समझ के साथ शुरू किया गया कार्य ही पूर्णता (संपूर्णता) और अभीष्ट फल प्रदान करता है।
            यह श्लोक साधना में अनुशासन, धैर्य और सही मार्गदर्शन के महत्व को बहुत गहराई से रेखांकित करता है।
        """.trimIndent(),
        english = """
            One must commence the Saptashati recitation only after fully mastering the secret of this 'Utkilana' (unlocking).
            A person who acts out of ignorance or ego, bypassing these rules, invites his own spiritual downfall and ruin.
            Incomplete knowledge and undisciplined practice can often lead to mental instability or spiritual loss.
            Therefore, exceptionally wise and enlightened seekers (Budha) first perfect this Kilak mystery.
            Tasks initiated with complete understanding and proper method always lead to total fulfillment and success.
            This verse deeply highlights the absolute necessity of discipline, patience, and correct guidance in spiritual life.
        """.trimIndent()
    ),
    KilakShloka(
        id = 12,
        sanskrit = "सौभाग्यादि च यत्किञ्चिद् दृश्यते ललनाजने । तत्सर्वं तत्प्रसादेन तेन जाप्यमिदं शुभम् ॥ १२ ॥",
        hindi = """
            संसार की समस्त स्त्रियों में जो भी सौंदर्य, सौभाग्य, शालीनता और कान्ति दिखाई देती है, वह माँ का ही अंश है।
            वह सब कुछ केवल और केवल उन्हीं करुणामयी भगवती माता की असीम कृपा (प्रसाद) का ही प्रतिफल है।
            स्त्री रूप साक्षात् प्रकृति का रूप है, और माँ ही उस प्रकृति की आधारभूत शक्ति और चेतना हैं।
            अतः अपने जीवन में शुभता, सौंदर्य और दिव्य सौभाग्य को आकर्षित करने के लिए इस स्तोत्र का जप अनिवार्य है।
            यह पाठ साधक की दृष्टि को शुद्ध करता है ताकि वह हर स्त्री और हर रूप में उसी एक जगदम्बा को देख सके।
            माँ के चरणों की धूल ही वह पारस है जो साधारण जीवन को भी सौभाग्यशाली और प्रकाशमान बना देती है।
        """.trimIndent(),
        english = """
            Whatever beauty, grace, good fortune, and brilliance are seen in the women of this world, they reflect the Mother.
            All such divine attributes are strictly the result of the infinite grace (Prasada) of that compassionate Goddess.
            The feminine form is a direct manifestation of Prakriti, and the Mother is the core power and consciousness of it.
            Thus, to attract auspiciousness, inner beauty, and divine luck into one's life, chanting this hymn is essential.
            This practice purifies the seeker's vision, enabling him to see the same Jagadamba in every woman and every form.
            The dust of the Mother's feet is the philosopher's stone that turns an ordinary life into one of radiant fortune.
        """.trimIndent()
    ),
    KilakShloka(
        id = 13,
        sanskrit = "शनैस्तु जप्यमानेऽस्मिन् स्तोत्रे सम्पत्तिरुच्चकैः । भवत्येव समग्रापि ततः प्रारभ्यमेव तत् ॥ १३ ॥",
        hindi = """
            यदि कोई साधक इस स्तोत्र का अत्यंत धीमी आवाज़ (शनैः) या शांत मन से जप करता है, तो भी उसे महान फल मिलता है।
            उसे जीवन में उच्च कोटि की भौतिक और आध्यात्मिक संपत्ति (सम्पत्तिरुच्चकैः) निश्चित रूप से प्राप्त होती है।
            जप की गति से अधिक साधक के हृदय की भाव-शुद्धि और एकाग्रता महत्वपूर्ण मानी गई है।
            यह स्तोत्र इतना जागृत है कि इसका सूक्ष्म प्रभाव भी साधक के भाग्य को पूरी तरह से बदलने की क्षमता रखता है।
            चूँकि यह पाठ हर स्थिति में कल्याणकारी और सफलता देने वाला है, इसलिए इसे बिना देरी किए अवश्य शुरू करना चाहिए।
            माँ की शरण में धीरे से बढ़ाया गया एक छोटा कदम भी भक्त को अनंत सिद्धियों और सुखों का स्वामी बना देता है।
        """.trimIndent(),
        english = """
            Even if a seeker chants this hymn very slowly (Shanaih), softly, or with a quiet mind, he attains great results.
            He undoubtedly acquires the highest grade of both material and spiritual wealth (Sampattiruchchakaih).
            The purity of intent and concentration in the heart are far more vital than the speed or loudness of the chant.
            This stotram is so spiritually charged that even its subtle influence can completely rewrite the seeker's destiny.
            Since this text is unfailingly beneficial and guarantees success, one must initiate its practice without delay.
            Even a small, quiet step taken toward the Mother's refuge makes the devotee the master of infinite perfections.
        """.trimIndent()
    ),
    KilakShloka(
        id = 14,
        sanskrit = "ऐश्वर्यं तत्प्रसादेन सौभाग्यारोग्यसम्पदः । शत्रुहानिः परो मोक्षः स्तूयते सा न किं जनैः ॥ १४ ॥\nइति श्रीभगवतीकीलकस्तोत्रं समाप्तम् ॥",
        hindi = """
            (अंतिम श्लोक): जिस दयालु माँ की कृपा से असीम ऐश्वर्य, सौभाग्य, आरोग्य, और अथाह धन-संपत्ति सहज ही मिल जाती है।
            जिनके स्मरण मात्र से भीतरी और बाहरी शत्रुओं का नाश हो जाता है और अंततः परम 'मोक्ष' का द्वार खुल जाता है।
            ऐसी सर्वशक्तिमान और करुणामयी जगदम्बा की स्तुति और पूजा भला संसार के लोगों को क्यों नहीं करनी चाहिए?
            अर्थात हर जीव का यह परम कर्तव्य है कि वह उस माँ की महिमा का गान करे और उनके चरणों में विश्राम पाए।
            यहाँ माँ भगवती का 'कीलक स्तोत्र' पूर्ण होता है, जो साधक को पूर्णता और मुक्ति की गारंटी देता है।
            माँ का आशीर्वाद ही वह परम सत्य है जो इस नश्वर संसार को आनंदमय और दिव्य बना देता है। ॐ शांति।
        """.trimIndent(),
        english = """
            (Final Shloka): By whose grace one effortlessly attains limitless opulence, good fortune, health, and vast wealth.
            Whose remembrance annihilates all inner and outer enemies and ultimately flings open the gates of supreme 'Moksha'.
            Why should such an omnipotent and compassionate Mother of the Universe not be praised and worshiped by everyone?
            It is the prime duty of every living being to sing Her glories and find eternal rest at Her divine lotus feet.
            Here, the 'Kilak Stotram' of Goddess Bhagavati reaches completion, offering a guarantee of perfection and liberation.
            The Mother's blessing is the ultimate truth that transforms this transient world into one of divine bliss. Om Peace.
        """.trimIndent()
    )
)