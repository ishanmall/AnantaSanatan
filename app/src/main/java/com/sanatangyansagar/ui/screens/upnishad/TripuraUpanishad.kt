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
data class TripuraShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

// 2. Main Screen Composable
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TripuraUpanishadScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFBF7))
    ) {
        // Search Bar Code
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                val shlokaNumber = query.toIntOrNull()
                // Validates if the number is between 1 and 16
                if (shlokaNumber != null && shlokaNumber in 1..16) {
                    coroutineScope.launch {
                        // Smoothly scrolls to the exact Shloka
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-16)") },
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
            itemsIndexed(tripuraShlokasList) { _, shloka ->
                TripuraShlokaCard(shloka = shloka)
            }
        }
    }
}

// 3. Shloka Card Composable
@Composable
fun TripuraShlokaCard(shloka: TripuraShloka) {
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
val tripuraShlokasList: List<TripuraShloka> = listOf(
    TripuraShloka(
        id = 1,
        sanskrit = "तिस्रः पुरो हि त्रिपथो विमर्शे तास्वक्षराक्षरावसथे ऋतम् । आधाय शास्त्राणि विजह्युराशां यदा तदा प्रापुरुत्तमं पदम् ॥ १ ॥",
        hindi = """
            (त्रिपुरा उपनिषद का आरंभ): इस ब्रह्मांड में मुख्य रूप से 'तीन पुर' (तिस्रः पुरो / तीन शहर या तीन अवस्थाएं - जाग्रत, स्वप्न, सुषुप्ति) विद्यमान हैं।
            इन तीनों पुरों को पार करने के लिए तीन अत्यंत रहस्यमयी 'मार्ग' (त्रिपथो / ज्ञान, कर्म, और भक्ति) हैं।
            इन तीनों पुरों और मार्गों की परम अधिष्ठात्री देवी साक्षात् 'त्रिपुरा सुंदरी' हैं, जो इन सबके भीतर 'विमर्श' (सृष्टि की चेतना) रूप में विराजमान हैं।
            वे माता उन सभी 'अक्षर' (अविनाशी आत्मा) और 'क्षर' (नाशवान शरीर) के बीच परम सत्य (ऋतम्) के रूप में स्थित हैं।
            जब सच्चे साधक और ज्ञानी जन सभी बाहरी 'शास्त्रों' (Shaastras) के शब्दों का केवल रट्टा मारना छोड़कर माता के असली स्वरूप को अपने हृदय में धारण (आधाय) कर लेते हैं।
            और जब वे इस संसार की सभी प्रकार की 'आशाओं' और भौतिक वासनाओं (आशां) को पूरी तरह से त्याग (विजह्युः) देते हैं।
            केवल और केवल तभी (यदा तदा) वे योगी उस सबसे 'उत्तम पद' (परम मोक्ष / Supreme State) को हमेशा के लिए प्राप्त (प्रापुः) कर लेते हैं।
            यह श्लोक श्री विद्या (Sri Vidya) और तन्त्र शास्त्र का सबसे महान उद्घाटन करता है।
            माता 'त्रिपुरा' कोई साधारण देवी नहीं हैं; वे ब्रह्मा, विष्णु और शिव से भी पहले की वह 'सुपर-कॉन्शसनेस' (Super-consciousness) हैं जिसने इन तीनों पुरों को बनाया है।
            उनको बाहर ढूँढने के बजाय, अपने ही भीतर वासनाओं का अंत करके खोजना ही सबसे बड़ा तन्त्र और सबसे बड़ा मोक्ष है।
        """.trimIndent(),
        english = """
            (The profound beginning of Tripura Upanishad): In this massive cosmos, there explicitly exist exactly 'Three Cities' (Tisrah puro / three realms or states: waking, dreaming, deep sleep).
            To successfully cross these three cities, there strictly exist three highly mystical 'Paths' (Tripatho / the paths of Will, Knowledge, and Action).
            The absolute supreme sovereign Goddess of all these three cities and paths is the direct 'Tripura Sundari', who flawlessly presides as 'Vimarsha' (dynamic cosmic consciousness).
            That Supreme Divine Mother sits perfectly established as the ultimate Truth (Ritam) existing exactly between the 'Akshara' (imperishable soul) and 'Kshara' (perishable body).
            Exactly when true seekers and master Yogis completely stop blindly memorizing the dead words of external 'Scriptures' (Shastrani) and profoundly absorb the Mother's true essence into their hearts.
            And strictly when they ruthlessly, violently abandon and drop (Vijahyuh) absolutely all worldly 'Hopes', toxic lusts, and material desires (Asham) forever.
            Only, and strictly only then (Yada tada), do those magnificent Yogis successfully attain (Prapuh) that absolute 'Supreme State' (Uttamam Padam / Moksha) for all eternity.
            This spectacular verse initiates the absolute greatest revelation of 'Sri Vidya' (the highest esoteric science) and Tantra Shastra.
            Mother 'Tripura' is absolutely no ordinary deity; She is that exact primordial 'Super-Consciousness' existing long before Brahma, Vishnu, and Shiva, who effortlessly created these three cities.
            Instead of searching for Her physically outside, ruthlessly ending all desires and finding Her directly inside is the absolute greatest Tantra and ultimate Liberation.
        """.trimIndent()
    ),
    TripuraShloka(
        id = 2,
        sanskrit = "नव योनयो नव चक्राणि दीदध्रुर्नव योगा नव योगीश्वरीश्च । नवानामष्टौ वसवः संस्थिताश्च तपोभिरग्रे शिवमाश्रयामि ॥ २ ॥",
        hindi = """
            (श्री चक्र / Sri Yantra का परम रहस्य): इस संपूर्ण ब्रह्मांड की रचना 'नौ योनियों' (नव योनयो / नौ मूल त्रिकोण) से हुई है जो श्री चक्र का निर्माण करते हैं।
            (इनमें से 4 शिव के त्रिकोण हैं जो ऊपर की ओर हैं, और 5 शक्ति के त्रिकोण हैं जो नीचे की ओर हैं, जो आपस में मिलकर श्री चक्र बनाते हैं)।
            ये नौ त्रिकोण मिलकर नौ महा-चक्रों (नव चक्राणि / आवरणों) को धारण (दीदध्रुः) करते हैं, जो नौ योगों और नौ परम 'योगीश्वरियों' (देवियों) के साक्षात् निवास स्थान हैं।
            इन नौ चक्रों के बिल्कुल मध्य में (केंद्र में) आठ 'वसु' (अष्टौ वसवः / अष्टकोण) पूरी तरह से स्थापित और स्थित (संस्थिताश्च) हैं।
            इन सभी चक्रों और देवियों के परम केंद्र में (अग्रे), बिंदु रूप में साक्षात् 'परम शिव' विराजमान हैं; मैं अपनी अत्यंत घोर तपस्या (तपोभिः) के द्वारा उन्हीं शिव और शक्ति का आश्रय (आश्रयामि) लेता हूँ।
            यह श्लोक सनातन धर्म की सबसे एडवांस ज्योमेट्री (Advanced Sacred Geometry), यानी 'श्री यन्त्र' का पूरा ब्लूप्रिंट (Blueprint) दे रहा है।
            श्री चक्र कोई आम चित्र नहीं है; यह यूनिवर्स (Universe) की सबसे परफेक्ट (Perfect) मैथमेटिकल कोडिंग (Mathematical coding) है।
            जब इंसान का शरीर (जो खुद 9 दरवाजों का शहर है) इस श्री चक्र की ऊर्जा के साथ ध्यान (तपस्या) द्वारा कनेक्ट (Connect) होता है।
            तो उसके अंदर सोई हुई कुण्डलिनी शक्ति जाग उठती है और नौ चक्रों को पार करती हुई सीधा सहस्रार में बैठे 'शिव' से मिल जाती है।
            तन्त्र में बाहर खींचे गए चक्र पर नहीं, बल्कि अपने ही शरीर के अंदर के इन 'नौ योगों' पर ध्यान लगाकर मोक्ष पाया जाता है।
        """.trimIndent(),
        english = """
            (The absolute supreme secret of Sri Chakra / Sri Yantra): This entire massive cosmos is manufactured exactly from 'Nine Yonis' (Nava yonayo / nine primordial root triangles) which perfectly construct the Sri Chakra.
            (Among these, 4 are Shiva's upward-pointing triangles, and 5 are Shakti's downward-pointing triangles, interlocking violently to form the Sri Yantra).
            These nine intersecting triangles flawlessly hold and sustain (Didadhruh) the nine Maha-Chakras (Nava chakrani / the 9 cosmic enclosures), which are the direct physical abodes of the nine Yogas and nine supreme 'Yogishvaris' (Goddesses).
            Exactly right in the center of these nine massive chakras, the eight 'Vasus' (Ashtau vasavah / the eight-petaled lotus) are firmly and permanently established (Samsthitashcha).
            At the absolute, ultimate core and pinnacle (Agre) of all these chakras and goddesses, the 'Supreme Shiva' sits perfectly as the Bindu (Central Point); strictly through my extreme penance (Tapobhih), I take absolute refuge (Ashrayami) in that Shiva-Shakti.
            This spectacular verse explicitly provides the complete, flawless Blueprint of Sanatana Dharma's absolute most 'Advanced Sacred Geometry', the 'Sri Yantra'.
            The Sri Chakra is absolutely no ordinary drawing; it is the absolute most Perfect Mathematical Coding of the entire Universe.
            When the human body (which itself is a city of 9 physical doors) flawlessly Connects with the raw energy of this Sri Chakra strictly through deep meditation (Tapasya).
            The sleeping Kundalini Shakti violently awakens inside him, piercing through the nine chakras and merging directly with 'Shiva' seated flawlessly in the Sahasrara.
            In Tantra, absolute Moksha is attained not merely by staring at an externally drawn Chakra, but by meditating fiercely on these 'Nine Yogas' existing directly inside one's own body.
        """.trimIndent()
    ),
    TripuraShloka(
        id = 3,
        sanskrit = "एकाक आसीत्प्रथमा सवित्री सा कामधुक् सा ससृजेण्डमण्डम् । तस्यां जाता त्रिवृता सा सुदीप्तिः सा कामधुक् सा ससृजेण्डमण्डम् ॥ ३ ॥",
        hindi = """
            (सृष्टि का निर्माण कैसे हुआ?): सृष्टि की बिल्कुल शुरुआत में केवल और केवल वह 'एक' (एकाक) परम शक्ति (माता त्रिपुरा) ही अकेली विद्यमान थी (आसीत्)।
            वही माता संसार की सबसे 'प्रथमा' (First) और 'सवित्री' (Savitri / सब कुछ उत्पन्न करने वाली जननी) है।
            वही परम माता साक्षात् 'कामधुक्' (Kamadhuk / सभी की सभी इच्छाओं और कामनाओं को पूर्ण करने वाली कामधेनु) है; उसी ने इस अत्यंत विशाल 'ब्रह्मांड' (अण्डमण्डम् / Cosmic Egg) को रचा (ससृजे) है।
            उस एक माता के भीतर से ही 'त्रिवृता' (सत्व, रज, तम—इन तीन गुणों से युक्त) अत्यंत भयंकर और प्रकाशमान ऊर्जा (सुदीप्तिः) उत्पन्न (जाता) हुई।
            (श्रुति इस सत्य को पक्का करने के लिए दोबारा दोहराती है): "हाँ! वही माता सभी कामनाओं को पूर्ण करने वाली 'कामधुक्' है, और केवल उसी ने इस पूरे ब्रह्मांड को रचा है!"
            यह श्लोक अद्वैत वेदान्त और तन्त्र (शाक्त परम्परा) का वह सबसे बड़ा धमाका (Explosion) है जहाँ 'ईश्वर' को एक 'परम माता' के रूप में देखा गया है।
            जब कोई ग्रह, तारे या इंसान नहीं थे, तब वह 'एक' चेतना (Mother Consciousness) शून्य में मौजूद थी।
            उसी माता ने अपने ही भीतर से इस पूरे ब्रह्मांड रूपी 'अंडे' (Cosmic Egg) को बिल्कुल वैसे ही जन्म दिया, जैसे एक माँ बच्चे को जन्म देती है।
            'कामधुक्' का मतलब है कि दुनिया की कोई भी इच्छा (पैसे से लेकर मोक्ष तक) उस माता की मर्जी के बिना पूरी हो ही नहीं सकती।
            हम उस माँ के ही बच्चे हैं; जो साधक इस ब्रह्मांड को उस माँ का 'शरीर' मानकर प्रेम करता है, उसे माता तुरंत अपनी गोद (मोक्ष) में उठा लेती है।
        """.trimIndent(),
        english = """
            (Exactly how was creation manufactured?): At the absolute very beginning of creation, strictly and exclusively that 'One' (Ekaka) Supreme Power (Mother Tripura) existed entirely alone (Asit).
            That exact Mother is undeniably the absolute 'Prathama' (First) and 'Savitri' (the ultimate Progenitor / Mother who gives birth to absolutely everything).
            That Supreme Mother is the direct, living 'Kamadhuk' (the cosmic wish-fulfilling cow who flawlessly satisfies all desires); She alone actively manufactured and created (Sasrije) this colossal, massive 'Universe' (Andamandam / Cosmic Egg).
            From strictly inside that exact one Mother, a terrifyingly brilliant and radiant cosmic energy (Sudiptih) possessing exactly 'Trivrita' (the three gunas: Sattva, Rajas, Tamas) was flawlessly born (Jata).
            (The Shruti violently repeats this to provide an ironclad confirmation): "Yes! That exact Mother is the wish-fulfilling 'Kamadhuk', and She alone manufactured this entire cosmic egg!"
            This phenomenal verse is the absolute greatest Explosion of Advaita Vedanta and Tantra (Shakta tradition), where 'God' is profoundly realized strictly as a 'Supreme Mother'.
            When absolutely zero planets, stars, or humans existed, that 'One' Mother Consciousness existed flawlessly alone in the infinite void.
            That exact Mother miraculously gave birth to this entire massive universe (Cosmic Egg) strictly out of Her own self, exactly just as a physical mother gives birth to a child.
            'Kamadhuk' profoundly means that absolutely no desire in the world (from cheap money to ultimate Moksha) can ever possibly be fulfilled completely without that Mother's explicit permission.
            We are literally the exact children of that Mother; that seeker who fiercely loves this entire cosmos considering it the Mother's physical 'Body', the Mother instantly lifts him directly into Her lap (Moksha).
        """.trimIndent()
    ),
    TripuraShloka(
        id = 4,
        sanskrit = "एका मातुः प्रविशन्ती सवित्री सा कामधुक् सा ससृजेण्डमण्डम् । तस्यां जाता त्रिवृता सा सुदीप्तिः सा कामधुक् सा ससृजेण्डमण्डम् ॥ ४ ॥",
        hindi = """
            (माता का कण-कण में प्रवेश): वह एक और अकेली (एका) माता, जो इस संपूर्ण जगत की उत्पन्नकर्त्री (सवित्री) है, वह ब्रह्मांड को बनाने के बाद उसी के कण-कण में 'प्रवेश' (प्रविशन्ती / Enter) कर गई।
            (अर्थात भगवान केवल दुनिया बनाकर आसमान में नहीं बैठे, वे दुनिया के हर एटम / Atom के अंदर घुस गए हैं)।
            (श्रुति उसी मंत्र को तीसरी बार दोहराती है): "वही माता साक्षात् सभी कामनाओं को पूर्ण करने वाली 'कामधुक्' है, और उसी ने इस विशाल ब्रह्मांड को रचा (ससृजेण्डमण्डम्) है।"
            "उसी माता से तीन गुणों वाली (त्रिवृता) अत्यंत प्रकाशमान ऊर्जा उत्पन्न हुई; हाँ, वही कामधुक् है जिसने इस संसार को रचा है।"
            यह श्लोक ईश्वर की सर्वव्यापकता (Omnipresence) का सबसे बड़ा 'तन्त्रात्मक' (Tantric) प्रमाण है।
            अज्ञानी लोग सोचते हैं कि भगवान दुनिया को बनाकर एक 'फैक्ट्री-मालिक' की तरह कहीं दूर बैठकर उसे चला रहे हैं।
            पर त्रिपुरा उपनिषद कहता है: नहीं! माँ ने दुनिया बनाई और फिर वह खुद 'प्रविशन्ती' (Enter) होकर इस दुनिया का 'कण-कण' (पेड़, पत्थर, इंसान) बन गई!
            जो शरीर तुम्हारे पास है, जो हवा तुम ले रहे हो, वह सब साक्षात् 'त्रिपुरा माता' ही है।
            जब साधक को यह 'सुदीप्ति' (ज्ञान का भयंकर प्रकाश) मिलता है, तो उसे दुनिया में कोई दुश्मन या पराया नहीं दिखता; उसे हर चीज़ में माँ की धड़कन महसूस होती है।
            इस सत्य को बार-बार दोहराने का मतलब है कि इंसान के दिमाग में 'अद्वैत' का यह हथौड़ा इतनी जोर से लगे कि उसका सारा अहंकार (Ego) टूट जाए।
        """.trimIndent(),
        english = """
            (The Mother's flawless entry into every atom): That exactly One and solitary (Eka) Mother, who is the absolute ultimate Creator (Savitri) of this cosmos, exactly after manufacturing the universe, flawlessly 'Entered' (Pravishanti) right into every single microscopic atom of it.
            (Meaning, God absolutely did not merely create the world and sit idly in the sky; She flawlessly penetrated directly into the core of every single Atom).
            (The Shruti violently repeats the exact mantra for the third time): "That exact Mother is the direct wish-fulfilling 'Kamadhuk', and She alone manufactured this colossal cosmic egg (Sasrije-andamandam)."
            "From Her alone the brilliantly radiant energy possessing three gunas (Trivrita) was born; Yes, She is the Kamadhuk who created this world."
            This spectacular verse is the absolute greatest 'Tantric' proof of God's flawless Omnipresence in the entire universe.
            Ignorant fools falsely assume that God manufactured the world and is operating it like a disconnected 'Factory-Owner' sitting far away.
            But the Tripura Upanishad fiercely declares: No! The Mother created the massive world and then She Herself actively 'Pravishanti' (Entered) and literally became every single atom (tree, stone, human) of this world!
            The exact physical body you possess, the very air you breathe, is absolutely nothing but the direct 'Mother Tripura' Herself.
            When the seeker attains this 'Sudipti' (the terrifying, blinding light of wisdom), he sees absolutely zero enemies or aliens in the world; he literally feels the Mother's heartbeat pulsing inside everything.
            Repeating this absolute truth multiple times profoundly ensures that the heavy hammer of 'Advaita' strikes the human brain so violently that his entire Ego is permanently shattered to pieces.
        """.trimIndent()
    ),
    TripuraShloka(
        id = 5,
        sanskrit = "बालां बालां तत्र पश्यन्ति धीराः पूर्वस्य रूपं यदविन्दतोग्रे । तेन त्रिवर्गां परमां महतीं सुदीप्तिं तां कामधुक् सा ससृजेण्डमण्डम् ॥ ५ ॥",
        hindi = """
            (बाला सुंदरी का रहस्य): अत्यंत धीर (धीर / धैर्यवान और परम ज्ञानी) पुरुष अपनी आत्मा के भीतर उस माता को एक 'अत्यंत युवा और सुंदर कन्या' (बालां बालां / बाला त्रिपुरसुंदरी) के रूप में साक्षात् देखते (पश्यन्ति) हैं।
            यह 'बाला' (Bala) माता का वही सबसे पुराना, आदि और मूल स्वरूप (पूर्वस्य रूपं) है, जिसे सृष्टि के बिल्कुल आरंभ (अग्रे) में ब्रह्मा आदि देवताओं ने सबसे पहले अनुभव (अविन्दत) किया था।
            उसी 'बाला' रूप के द्वारा माता ने अपने भीतर से 'त्रिवर्ग' (धर्म, अर्थ, और काम) देने वाली परम (परमां), अत्यंत महान (महतीं) और प्रकाशमान (सुदीप्तिं) ऊर्जा को प्रकट किया।
            "हाँ, वही कामधुक् (इच्छाएं पूरी करने वाली माँ) है जिसने इस पूरे ब्रह्मांड को रचा है!"
            तन्त्र में माता त्रिपुरा सुंदरी के तीन मुख्य रूप हैं: 1. बाला (8-9 साल की कन्या), 2. पञ्चदशी (युवा), और 3. षोडशी (परम राजराजेश्वरी)।
            यहाँ ज्ञानी 'धीर' लोग माता को 'बाला' (Bala) के रूप में देखते हैं। बाला का मतलब है वह जो हमेशा 'फ्रेश' (Fresh), ऊर्जा से भरी और मासूम है।
            सृष्टि कितनी भी पुरानी हो जाए, भगवान (सत्य) हमेशा 'जवान' (बाला) ही रहता है; वह कभी बूढ़ा नहीं होता!
            जो साधक उस 'बाला' ऊर्जा को अपने आज्ञा चक्र में महसूस कर लेता है, उसे जीवन के तीनों वर्ग (धर्म, अर्थ/पैसा, और काम/सुख) बिना माँगे ही मिल जाते हैं।
            परन्तु अंत में वह यह जान जाता है कि यह पूरा ब्रह्मांड केवल उसी एक छोटी सी 'बाला' (चेतना) का एक भयंकर खेल (Play) है।
            वह योगी इस खेल को समझकर मौत के डर को हमेशा के लिए पार कर जाता है।
        """.trimIndent(),
        english = """
            (The supreme secret of Bala Sundari): The exceptionally patient, profoundly wise, and enlightened sages (Dhirah) flawlessly see and vividly perceive (Pashyanti) that Mother strictly inside their own soul exactly as an 'Exceptionally young, beautiful girl' (Balam balam / Bala Tripurasundari).
            This 'Bala' (young girl) is the absolute oldest, primordial, and most original form (Purvasya rupam) of the Mother, which the gods like Brahma first directly experienced (Avindata) exactly at the absolute beginning (Agre) of creation.
            Strictly through that exact 'Bala' form, the Mother flawlessly manifested the supreme (Paramam), exceptionally massive (Mahatim), and terrifyingly radiant (Sudiptim) energy that actively grants the 'Trivarga' (Dharma, Wealth, and Pleasure).
            "Yes, She is the Kamadhuk (wish-fulfilling Mother) who alone manufactured this entire massive universe!"
            In highly advanced Tantra, Mother Tripura Sundari has exactly three primary forms: 1. Bala (an 8-9 year old girl), 2. Panchadasi (a young woman), and 3. Shodashi (the supreme Queen of Queens).
            Here, the enlightened 'Dhiras' clearly perceive the Mother strictly as 'Bala'. Bala profoundly means she who is perpetually 'Fresh', violently bursting with energy, and absolutely innocent.
            No matter how incredibly ancient the physical creation becomes, God (The Truth) remains permanently and eternally 'Young' (Bala); God absolutely never grows old!
            That sincere seeker who flawlessly feels that 'Bala' energy directly inside his Ajna Chakra effortlessly receives all three categories of life (Dharma, Wealth, and Pleasure) completely without even asking.
            But ultimately, he flawlessly realizes that this entire colossal universe is merely a terrifying, massive Play of exactly that one tiny 'Bala' (Pure Consciousness).
            Understanding this cosmic game flawlessly, that master Yogi permanently crosses completely beyond the terrifying fear of death forever.
        """.trimIndent()
    ),
    TripuraShloka(
        id = 6,
        sanskrit = "यस्यां त्रिपूर्वा पथि विन्दते कामः ककाराद्या वृण्वते मातृकाभिः । तस्यां जाता त्रिवृता सा सुदीप्तिः... ॥ ६ ॥",
        hindi = """
            (काम-कला और पञ्चदशी विद्या का रहस्य): जिस परम 'त्रिपुरा' (त्रिपूर्वा) माता के मार्ग (पथि) पर चलने से साक्षात् 'कामेश्वर' (परम शिव / कामः) भी परम आनंद को प्राप्त (विन्दते) करते हैं।
            वह परम विद्या जो 'क' कार (K-syllable / ककाराद्या) से शुरू होती है, और जो सभी ५० मातृकाओं (मातृकाभिः / संस्कृत की 50 ध्वनियों और अक्षरों) को अपने भीतर पूरी तरह समेटे (वृण्वते) हुए है।
            उसी एक माता के भीतर से ही 'त्रिवृता' (तीनों लोकों को धारण करने वाली) वह अत्यंत भयंकर और प्रकाशमान ऊर्जा (सुदीप्तिः) उत्पन्न (जाता) हुई।
            "हाँ, वही कामधुक् माता है जिसने इस पूरे ब्रह्मांड (अण्डमण्डम्) को रचा है!"
            यह श्लोक श्री विद्या तन्त्र के सबसे बड़े 'पासवर्ड' (Password) यानी 'पञ्चदशी मंत्र' (Panchadasi Mantra) का साक्षात् संकेत (Code) है।
            श्री विद्या का सबसे शक्तिशाली 15 अक्षरों का मंत्र 'क' अक्षर (क-ए-ई-ल-ह्रीं...) से शुरू होता है (ककाराद्या)।
            यह मंत्र कोई साधारण शब्द नहीं है; इसके अंदर पूरी संस्कृत वर्णमाला (50 मातृकाएं) और ब्रह्मांड के सारे साउंड-फ्रीक्वेंसी (Sound frequencies) छिपे हुए हैं।
            जब साधक इस 'क' कार विद्या का सही गुरु से ज्ञान लेकर ध्यान करता है, तो उसके शरीर के सारे चक्र एक साथ भड़क उठते हैं (सुदीप्ति)।
            यही वह परम मार्ग है जिस पर चलकर खुद भगवान शिव (कामेश्वर) ने माता शक्ति के साथ मिलकर इस दुनिया को रचा और आनंद लिया।
            बिना इस 'ककाराद्या' (कादी विद्या) के, श्री चक्र का रहस्य और शिव-शक्ति का मिलन (अद्वैत) कभी भी 100% सिद्ध नहीं हो सकता।
        """.trimIndent(),
        english = """
            (The supreme secret of Kama-Kala and Panchadasi Vidya): Strictly by walking upon the highly sacred path (Pathi) of that supreme Mother 'Tripura' (Tripurva), even Lord 'Kameshvara' (Supreme Shiva / Kamah) directly attains (Vindate) absolute, infinite bliss.
            That absolute supreme Vidya (knowledge/mantra) which explicitly begins with the exact syllable 'Ka' (Kakaradya), and which flawlessly encapsulates and completely envelops (Vrinvate) absolutely all 50 'Matrikas' (the 50 sacred syllables of Sanskrit) entirely within itself.
            From strictly inside that exact one Mother, the 'Trivrita' (holding the three worlds) terrifyingly brilliant and radiant cosmic energy (Sudiptih) was flawlessly born (Jata).
            "Yes, She is the Kamadhuk Mother who alone manufactured this entire massive universe (Andamandam)!"
            This phenomenal verse is the direct, highly classified 'Code' revealing Sri Vidya Tantra's absolute greatest 'Password', the 'Panchadasi Mantra'.
            The absolute most terrifyingly powerful 15-syllable mantra of Sri Vidya explicitly begins exactly with the syllable 'Ka' (Ka-E-I-La-Hreem...) (Kakaradya).
            This mantra is absolutely no ordinary human word; perfectly hidden inside it is the entire Sanskrit alphabet (50 Matrikas) and absolutely all Sound Frequencies of the entire cosmos.
            When a sincere seeker receives this specific 'Ka' Vidya from a true Guru and fiercely meditates on it, absolutely all his bodily chakras violently ignite simultaneously (Sudipti).
            This is exactly that supreme path walking upon which Lord Shiva (Kameshvara) Himself united flawlessly with Mother Shakti to create and enjoy this world.
            Completely without this 'Kakaradya' (Kadi Vidya), the absolute secret of the Sri Chakra and the flawless union of Shiva and Shakti (Advaita) can absolutely never be 100% perfected.
        """.trimIndent()
    ),
    TripuraShloka(
        id = 7,
        sanskrit = "तत्सदुच्यते यत्त्रिकं बिन्दुपीठे कामान्निधाय स्रजमाबध्न ईडे । स एतद्विमानं भानवीयं प्रविश्य ततस्तु देवः सवितारमाहुः ॥ ७ ॥",
        hindi = """
            (बिन्दु पीठ और शिव-शक्ति मिलन): वह जो 'त्रिक' (Trikam / तीन बिंदुओं वाला परम काम-कला रूप) है, जो श्री चक्र के सबसे बीच के 'बिंदु पीठ' (Bindu-Pithe / केंद्र) में स्थापित है, उसी को परम 'सत्' (सत्य / तत्सदुच्यते) कहा जाता है।
            साधक को चाहिए कि वह अपनी सभी कामनाओं (कामान्) को उसी बिंदु पीठ पर रख दे (निधाय) और माला (स्रजम्) धारण करके उस परम माता की स्तुति (ईडे) करे।
            वह साक्षात् परम देव (शिव) उसी 'भानवीय' (भानवीयं / सूर्य के समान प्रकाशमान) 'विमान' (श्री चक्र रूपी अंतरिक्ष यान / शरीर) में प्रवेश करके (प्रविश्य) ही।
            इस पूरी सृष्टि को उत्पन्न करते हैं; इसीलिए महान ज्ञानी लोग उन शिव-शक्ति के मिलन को ही 'सविता' (सवितारमाहुः / पूरे ब्रह्मांड का सूर्य या रचयिता) कहते हैं।
            यह श्लोक 'श्री चक्र' के सबसे अंदरूनी और भयंकर सीक्रेट (Secret) 'बिंदु' (Dot) का पर्दाफाश करता है।
            श्री चक्र के बीचोबीच जो एक छोटा सा लाल बिंदु (बिंदु पीठ) है, वह कोई आम निशान नहीं है; वह एक 'सुपरमैसिव ब्लैक होल' (Supermassive black hole) की तरह है जहाँ शिव और शक्ति 100% एक (अद्वैत) हो चुके हैं।
            उसी बिंदु से यह पूरा 'विमान' (हमारा शरीर और यह पूरा ब्रह्मांड) उत्पन्न हुआ है।
            जब योगी ध्यान के द्वारा अपनी चेतना को दुनिया से खींचकर अपने आज्ञा चक्र या हृदय के उस 'बिंदु' पर टिकाता है, तो वह सीधा भगवान की 'कंट्रोल रूम' (Control Room) में घुस जाता है।
            वहाँ पहुँचकर उसे कोई अलग से पूजा नहीं करनी पड़ती; उसका अस्तित्व ही भगवान का प्रकाश (भानवीयं) बन जाता है।
            उसी बिंदु में घुसने के बाद इंसान का 'ईगो' (Ego) मर जाता है और वह खुद इस दुनिया का रचयिता (सविता) बन जाता है।
        """.trimIndent(),
        english = """
            (The Bindu Pitha and the union of Shiva-Shakti): That absolute 'Trikam' (the supreme three-dotted form of Kama-Kala) which is perfectly established exactly in the 'Bindu-Pithe' (the absolute central Dot) of the Sri Chakra, is profoundly declared as the ultimate 'Sat' (The Absolute Truth / Tatsaduchyate).
            The sincere seeker must ruthlessly place and surrender absolutely all his desires (Kaman) directly upon that Bindu Pitha (Nidhaya) and, wearing a sacred garland (Srajam), fiercely praise (Ide) that Supreme Mother.
            That direct Supreme Lord (Shiva) flawlessly enters (Pravishya) perfectly into that exact 'Bhanaviyam' (brilliantly radiant exactly like the blazing Sun) 'Vimanam' (the cosmic spaceship of Sri Chakra / human body).
            And actively creates this entire cosmos from there; this is precisely why the exceptionally great sages confidently call that flawless union of Shiva-Shakti the 'Savitri' (Savitaramahuh / the absolute Sun and Creator of the entire universe).
            This spectacular verse aggressively exposes the absolute innermost and terrifying Secret of the 'Sri Chakra'—the 'Bindu' (Central Dot).
            The tiny red dot (Bindu Pitha) existing exactly in the absolute center of the Sri Chakra is absolutely no ordinary mark; it acts exactly like a 'Supermassive Black Hole' where Shiva and Shakti have flawlessly become 100% One (Advaita).
            It is strictly from that single dot that this entire 'Vimana' (our physical body and this colossal universe) was violently born.
            When a master Yogi aggressively pulls his consciousness from the external world and anchors it strictly on that 'Bindu' in his Ajna Chakra or heart, he instantly hacks directly into God's absolute 'Control Room'.
            Upon successfully reaching there, he requires absolutely zero separate external worship; his very existence flawlessly becomes the blinding light of God (Bhanaviyam).
            Exactly after entering that specific Bindu, the human 'Ego' permanently dies, and he himself flawlessly becomes the absolute Creator (Savitri) of this entire world.
        """.trimIndent()
    ),
    TripuraShloka(
        id = 8,
        sanskrit = "तमेकमूर्ध्वं त्रिविधं ततोऽधो द्वयोरधोऽर्धं स्फुरितं त्रिधा च । एतादृशं कामकलास्वरूपं य एवं वेद स शिवो भवति ॥ ८ ॥",
        hindi = """
            (परम काम-कला यंत्र का स्वरूप): वह परम बिंदु वास्तव में 'एक' (तमेकम्) ही है। वह बिंदु ऊपर की ओर (ऊर्ध्वं) एक है, और उससे नीचे की ओर (ततोऽधो) तीन प्रकार (त्रिविधं) से विभाजित होता है।
            उन दोनों (ऊपर और नीचे के बिंदुओं) के और भी नीचे आधा भाग (द्वयोरधोऽर्धं) और भी तीन प्रकार से (त्रिधा च) चमकता और स्फुरित (स्फुरितं / Pulsates) होता है।
            (यह तीन बिन्दुओं और अर्धचंद्र का अत्यंत रहस्यमयी कॉम्बिनेशन है जो माता त्रिपुरसुंदरी का मूल यंत्र है)।
            इसी प्रकार का जो यह परम रहस्यमयी और भयंकर 'काम-कला का साक्षात् स्वरूप' (कामकलास्वरूपं) है।
            जो भी साधक इस काम-कला के असली विज्ञान को यथार्थ रूप में 'जान' (वेद) लेता है, वह कोई साधारण इंसान नहीं रहता, वह निश्चित रूप से 'साक्षात् शिव ही हो जाता है' (स शिवो भवति)।
            यह श्लोक तन्त्र विज्ञान का सबसे बड़ा 'जी-कोड' (G-Code / God Code) है, जिसे 'काम-कला' (Kama-Kala) कहते हैं।
            यह कोई कामुकता (Lust) की बात नहीं है! काम का अर्थ है शिव (इच्छा) और कला का अर्थ है शक्ति (Creation)। यह वह पहला डिज़ाइन (Design) है जिससे यूनिवर्स (Universe) बना है।
            इस डिज़ाइन में ऊपर एक लाल बिंदु है (शिव), उसके नीचे दो सफेद बिंदु हैं (शक्ति), और उसके नीचे एक आधा चाँद (हर्द-कला) है जिससे सारी दुनिया (मैटर / Matter) बनी है।
            जब योगी ध्यान में इस ज्योमेट्री (Geometry) को अपने मूलाधार से लेकर सहस्रार तक चमकता (Pulsating) हुआ देखता है।
            तो उसके दिमाग के सारे ताले (Locks) टूट जाते हैं, और वह इंसान की जेल से निकलकर साक्षात् 100% 'शिव' (ब्रह्मांड का राजा) बन जाता है।
        """.trimIndent(),
        english = """
            (The supreme structure of the Kama-Kala Yantra): That absolute supreme Bindu is in reality strictly 'One' (Tamekam). That dot is single at the top (Urdhvam), and exactly below it (Tato'dho), it perfectly divides into three exact types (Trividham).
            And exactly below both of those (the top and bottom dots), a half-portion (Dvayoradho'rdham) brilliantly shines and aggressively pulsates (Sphuritam) in three distinct ways once again (Tridha cha).
            (This is the exceptionally highly mystical combination of three specific dots and a half-moon, which is the absolute root Yantra of Mother Tripurasundari).
            Exactly such is the exceptionally mystical, terrifying, and direct 'True form of Kama-Kala' (Kamalasvarupam).
            Whosoever sincere seeker profoundly 'Knows' and flawlessly realizes (Veda) the actual science of this Kama-Kala in absolute reality, he absolutely no longer remains a mere ordinary human; he undoubtedly 'literally becomes Shiva Himself' (Sa shivo bhavati).
            This phenomenal verse is Tantra science's absolute greatest 'G-Code' (God Code), profoundly known exactly as 'Kama-Kala'.
            This is absolutely not a cheap discussion about worldly Lust! Kama profoundly means Shiva (Supreme Will) and Kala exactly means Shakti (Active Creation). This is the absolute first Design from which the entire Universe was violently manufactured.
            In this highly advanced design, there is exactly one red dot at the top (Shiva), exactly two white dots below it (Shakti), and a half-moon below that (Harda-Kala) from which absolutely all physical Matter is formed.
            When the master Yogi flawlessly sees this exact Geometry brilliantly flashing and aggressively Pulsating directly from his Muladhara straight up to his Sahasrara in deep meditation.
            Absolutely all the heavy locks of his brain violently shatter, and brutally escaping the pathetic human jail, he flawlessly and literally becomes 100% 'Shiva' (The absolute King of the cosmos).
        """.trimIndent()
    ),
    TripuraShloka(
        id = 9,
        sanskrit = "तत्सदुच्यते यत्त्रिकं ... त्रिभिरक्षरैः शिवो भवति ॥ ९ ॥",
        hindi = """
            (तीन अक्षरों का परम रहस्य): तन्त्र शास्त्रों में जो 'सत्' (परम सत्य) कहा गया है, वह उसी तीन बिन्दुओं वाले 'त्रिक' (Trikam) में छिपा है।
            (श्री विद्या का पञ्चदशी मंत्र तीन कूटों / भागों में बंटा है: वाग्भव कूट, कामराज कूट, और शक्ति कूट)।
            जो साधक इस महामंत्र के 'इन तीन अक्षरों' (त्रिभिरक्षरैः / तीन खण्डों या तीन बीजों) का अपने ध्यान में 100% परफेक्शन (Perfection) के साथ एकीकरण कर लेता है।
            वह योगी निश्चित रूप से सभी बंधनों को काटकर 'साक्षात् शिव' (परमात्मा) ही हो जाता है (शिवो भवति)।
            श्री विद्या तन्त्र में माता का मंत्र एक लंबी ट्रेन (Train) की तरह है, जिसे तीन डिब्बों (Three Sections / कूट) में बाँटा गया है।
            पहला हिस्सा इंसान के गले (Throat) तक काम करता है, दूसरा हिस्सा सीने (Heart) में आग लगाता है, और तीसरा हिस्सा सीधे दिमाग (Third Eye) में ब्लास्ट (Blast) करता है।
            जब योगी इन तीनों (त्रिभिरक्षरैः) हिस्सों को एक साथ अलाइन (Align) कर लेता है, तो उसकी पूरी 'रीढ़ की हड्डी' (Spine) एक लेज़र बीम (Laser beam) की तरह चमक उठती है।
            यह कोई अंधविश्वास (Superstition) नहीं है; यह इंसान के नर्वस सिस्टम (Nervous system) को भगवान की फ्रीक्वेंसी (Frequency) के साथ जोड़ने का सबसे एडवांस 'हैकिंग कोड' (Hacking code) है।
            जब यह कोड सही तरीके से रन (Run) हो जाता है, तो इंसान का छोटा सा 'ईगो' (Ego) हमेशा के लिए डिलीट (Delete) हो जाता है।
            और वह मिट्टी का इंसान उसी पल ब्रह्मांड का साक्षात् मालिक (शिव) बन जाता है; यही वेदान्त और तन्त्र का अंतिम लक्ष्य है।
        """.trimIndent(),
        english = """
            (The supreme secret of the Three Syllables/Sections): That which is explicitly declared as 'Sat' (Absolute Truth) in Tantra Shastras is flawlessly hidden strictly inside that precise three-dotted 'Trikam'.
            (The 15-syllable Panchadasi mantra of Sri Vidya is strictly divided into exactly three Kutas / sections: Vagbhava Kuta, Kamaraja Kuta, and Shakti Kuta).
            That sincere seeker who flawlessly unifies and completely masters 'These three exact syllables/sections' (Tribhiraksharaih / three parts or three seeds) with 100% absolute Perfection strictly in his deep meditation.
            That magnificent Yogi undoubtedly and certainly slashes all terrifying bonds and literally becomes 'Shiva Himself' (the Supreme Lord) (Shivo bhavati).
            In Sri Vidya Tantra, the Mother's massive mantra is exactly like a highly advanced Train, strictly divided into three precise compartments (Three Sections / Kutas).
            The absolute first section violently operates strictly up to the human Throat, the precise second section sets the Heart completely on fire, and the final third section Blasts violently straight into the Brain (Third Eye).
            When the master Yogi flawlessly Aligns absolutely all three of these (Tribhiraksharaih) sections simultaneously, his entire 'Spinal Cord' (Spine) violently lights up exactly like a blinding Laser Beam.
            This is absolutely no cheap Superstition; it is the absolute most Advanced 'Hacking Code' designed strictly to flawlessly connect the human Nervous System directly with God's ultimate Frequency.
            Exactly when this highly complex code is Run perfectly, the tiny, toxic human 'Ego' is permanently and irrevocably Deleted forever.
            And that exact human made of cheap dirt instantly and flawlessly becomes the direct Master of the universe (Shiva) in that very split-second; this is the absolute ultimate target of both Vedanta and Tantra.
        """.trimIndent()
    ),
    TripuraShloka(
        id = 10,
        sanskrit = "यो ह वा एतां त्रिपुरामक्षरैः पञ्चदशभिः पदैर्ज्ञात्वा शिवो भवति । तस्याः पदं पञ्चदशाक्षरं भवति ॥ १० ॥",
        hindi = """
            (पञ्चदशी मंत्र का साक्षात् प्रमाण): "जो कोई भी साधक (यो ह वा) इस परम 'त्रिपुरा' (माता महात्रिपुरसुंदरी) की साक्षात् विद्या को।"
            "उनके 'पंद्रह अक्षरों' (अक्षरैः पञ्चदशभिः) वाले उस परम शक्तिशाली महामंत्र (पञ्चदशी विद्या) के पदों (पदैः) के द्वारा यथार्थ रूप में जान और अनुभव (ज्ञात्वा) कर लेता है।"
            "वह साधक निश्चित रूप से मृत्यु और अज्ञान को पार करके 'साक्षात् शिव' ही हो जाता है (शिवो भवति)।"
            "उस माता त्रिपुरा का जो सबसे परम और गुप्त स्वरूप (पदं) है, वह इसी 'पंद्रह अक्षरों' (पञ्चदशाक्षरं भवति) वाले मंत्र में पूरी तरह से समाया हुआ है।"
            यहाँ उपनिषद दुनिया के सबसे बड़े और 'गोपनीय' मंत्र का स्पष्ट ऐलान कर रहा है—'पञ्चदशी विद्या' (The 15-Syllable Mantra)।
            (क-ए-ई-ल-ह्रीं, ह-स-क-ह-ल-ह्रीं, स-क-ल-ह्रीं—ये वे 15 अक्षर हैं जो श्री विद्या का हृदय हैं)।
            ये 15 अक्षर 15 'तिथियों' (Days of the moon) के प्रतीक हैं; ये इंसान के शरीर की पूरी टाइमलाइन (Timeline) और बायोलॉजिकल क्लॉक (Biological clock) को कंट्रोल करते हैं।
            जब योगी इस 15 अक्षरों के 'पासवर्ड' को अपने चक्रों पर घुमाता है, तो उसका शरीर जो समय (Time) का गुलाम था, वह 'टाइमलेस' (Timeless / अमर) हो जाता है।
            त्रिपुरा माता कहीं आसमान में नहीं बैठी हैं; उनका असली शरीर (Physical Body) यह 15 अक्षरों का मंत्र ही है (तस्याः पदं पञ्चदशाक्षरं)!
            जो इस मंत्र को केवल जबान से नहीं, बल्कि अपनी कुण्डलिनी से जपता है, वह रातों-रात इंसान से साक्षात् शिव (भगवान) बन जाता है।
        """.trimIndent(),
        english = """
            (The direct absolute proof of the Panchadasi Mantra): "Whosoever sincere seeker (Yo ha va) truly, profoundly knows and flawlessly directly experiences (Jnatva) the absolute supreme science of this 'Tripura' (Mother Mahatripurasundari)."
            "Strictly and exclusively through the highly precise syllables (Padaih) of Her exceptionally powerful, terrifying 'Fifteen-Syllable' (Aksharaih panchadashabhih) Maha-Mantra (Panchadasi Vidya)."
            "That magnificent seeker undoubtedly and certainly violently crosses completely beyond terrifying death and dark ignorance, and literally becomes 'Shiva Himself' (Shivo bhavati)."
            "The absolute most supreme and highly classified state and true form (Padam) of that Mother Tripura is completely and perfectly contained entirely within this exact 'Fifteen-Syllable' (Panchadashaksharam bhavati) mantra alone."
            Here, the Upanishad is making a crystal-clear, bold declaration of the world's absolute greatest and most 'Highly Classified' mantra—the 'Panchadasi Vidya' (The 15-Syllable Mantra).
            (Ka-E-I-La-Hreem, Ha-Sa-Ka-Ha-La-Hreem, Sa-Ka-La-Hreem—these exact 15 syllables are the absolute beating heart of Sri Vidya).
            These 15 syllables flawlessly symbolize the exactly 15 'Tithis' (lunar days); they aggressively and flawlessly control the entire Timeline and biological clock of the human body.
            When the master Yogi flawlessly spins this 15-syllable 'Password' directly on his bodily chakras, his physical body which was a pathetic slave to Time, instantly becomes perfectly 'Timeless' (Immortal).
            Mother Tripura is absolutely not sitting lazily in some distant physical sky; Her actual, real Physical Body is exactly this 15-syllable mantra itself (Tasyah padam panchadashaksharam)!
            He who chants this mantra absolutely not merely with a cheap physical tongue, but aggressively with his awakened Kundalini, seamlessly transforms overnight from a pathetic human directly into Shiva (God) Himself.
        """.trimIndent()
    ),
    TripuraShloka(
        id = 11,
        sanskrit = "ह्रीं-कारत्रय-सम्पुटां नववर्णां तामुपास्य महात्रिपुरां शिवो भवति ॥ ११ ॥",
        hindi = """
            (ह्रीं बीज का विस्फोट): उस परम पञ्चदशी विद्या में जो तीन 'ह्रीं' (ह्रीं-कारत्रय) बीज लगे हुए हैं, वे इस पूरे मंत्र को एक अभेद्य कवच (सम्पुटां / Capsule) की तरह सुरक्षित रखते हैं।
            (श्री विद्या के तीन खण्डों के अंत में 'ह्रीं' आता है)।
            जो साधक इन बीजों और नौ अक्षरों/आवरणों (नववर्णां) के परम रहस्य को जानकर।
            उस 'महा-त्रिपुरा' (Maha-Tripura) माता की अत्यंत गहराई से उपासना (ध्यान / उपास्य) करता है।
            वह साधक निश्चित रूप से इस माया के भयंकर जाल को तोड़कर 'साक्षात् शिव ही हो जाता है' (शिवो भवति)।
            'ह्रीं' (Hreem) कोई आम शब्द नहीं है; तन्त्र में इसे 'माया बीज' या 'भुवनेश्वरी बीज' कहते हैं। यह वह 'डायनामाइट' (Dynamite) है जो इंसान के सारे दुखों को उड़ा देता है।
            जब यह 'ह्रीं' मंत्र में तीन बार (ह्रीं-कारत्रय) आता है, तो यह जाग्रत, स्वप्न और सुषुप्ति—तीनों अवस्थाओं की माया को एक साथ काट देता है।
            मन्त्र के ये बीज (Seeds) इंसान के नर्वस सिस्टम (Nervous System) में एक भयंकर 'हीट' (Heat/गर्मी) पैदा करते हैं, जिससे कुण्डलिनी साँप की तरह खड़ी हो जाती है।
            जब वह कुण्डलिनी 9 चक्रों (नववर्णां) को भेदती हुई दिमाग (सहस्रार) में शिव से मिलती है, तो उसे 'महात्रिपुरा की उपासना' कहते हैं।
            इस प्रोसेस (Process) के बाद इंसान की कोई 'इच्छा' या 'डर' बाकी नहीं रहता; वह खुद ब्रह्मांड का मालिक (शिव) बन जाता है।
        """.trimIndent(),
        english = """
            (The explosive power of the Hreem seed): Within that supreme Panchadasi Vidya, the exactly three 'Hreem' (Hreem-karatraya) seeds permanently installed within it strictly protect and flawlessly encapsulate this entire massive mantra exactly like an impenetrable armor (Samputam / Capsule).
            (The syllable 'Hreem' flawlessly appears exactly at the absolute end of all three sections of Sri Vidya).
            That sincere seeker who flawlessly knows and perfectly realizes the absolute supreme secret of these powerful seeds and the nine syllables/enclosures (Navavarnam).
            And exceptionally deeply worships and aggressively meditates (Upasya) directly upon that supreme 'Maha-Tripura' (Great Tripura) Mother.
            That magnificent seeker undoubtedly and certainly violently shatters the terrifying web of Maya and 'literally becomes Shiva Himself' (Shivo bhavati).
            'Hreem' is absolutely no ordinary human word; in advanced Tantra, it is fiercely called the 'Maya Bija' or 'Bhuvaneshwari Bija'. It is the exact explosive 'Dynamite' that violently blows away all human sorrows.
            Exactly when this 'Hreem' appears perfectly three times (Hreem-karatraya) in the mantra, it simultaneously and ruthlessly slashes the thick Maya of all three states: waking, dreaming, and deep sleep.
            These terrifying cosmic Seeds of the mantra actively generate an exceptionally fierce, blazing 'Heat' directly inside the human Nervous System, aggressively forcing the Kundalini to violently stand up exactly like a massive snake.
            When that explosive Kundalini ruthlessly pierces the 9 chakras (Navavarnam) and flawlessly meets Shiva directly in the brain (Sahasrara), it is profoundly called the ultimate 'Worship of Maha-Tripura'.
            Exactly after this terrifying biological Process, absolutely no 'Desire' or 'Fear' remains left in the human; he himself flawlessly becomes the absolute Master of the cosmos (Shiva).
        """.trimIndent()
    ),
    TripuraShloka(
        id = 12,
        sanskrit = "कामो योनिः कमला वज्रपाणिर्गुहा हसा मातरिश्वाभ्रमिन्द्रः । पुनर्गुहा सकला मायया च पुरूच्येषा विश्वमातादि-विद्या ॥ १२ ॥",
        hindi = """
            (पञ्चदशी मंत्र का सबसे बड़ा और गुप्त श्लोक - The Master Code): "काम (क), योनि (ए), कमला (ई), वज्रपाणि (ल), गुहा (ह्रीं)।"
            "ह-स (ह, स), मातरिश्वा (क), अभ्र (ह), इन्द्र (ल), और पुनः गुहा (ह्रीं)।"
            "स-क-ल (स, क, ल), और अंत में फिर से माया (ह्रीं)।"
            "(क-ए-ई-ल-ह्रीं, ह-स-क-ह-ल-ह्रीं, स-क-ल-ह्रीं)। यह जो पंद्रह अक्षरों वाली अत्यंत गुप्त और महान विद्या है, जो बहुत से रूपों में व्याप्त (पुरूची) है।"
            "यही 'विश्वमाता' (पूरे ब्रह्मांड की असली माँ) की साक्षात् 'आदि-विद्या' (सबसे पहली और मूल विद्या / विश्वमातादि-विद्या) है।"
            यह श्लोक सनातन धर्म के पूरे तन्त्र शास्त्र का सबसे बड़ा 'हैकिंग कोड' (Hacking Code) है! उपनिषद ने सीधे 15 अक्षर नहीं लिखे, उन्हें 'कोड-वर्ड्स' (Code-words) में छिपा दिया!
            काम (क) से लेकर माया (ह्रीं) तक—यह श्री विद्या (कादी विद्या) का 100% सटीक और पक्का फॉर्मूला (Formula) है।
            प्राचीन काल में यह मंत्र इतना खतरनाक (Powerful) माना जाता था कि ऋषि इसे सीधे किसी किताब में नहीं लिखते थे, ताकि कोई पापी या अज्ञानी इसका गलत इस्तेमाल न कर ले।
            इसलिए इसे देवताओं के नामों (काम, इन्द्र, वज्रपाणि) में एन्क्रिप्ट (Encrypt) कर दिया गया।
            यह 15 अक्षरों की 'आदि-विद्या' (Original Science) इंसान के दिमाग के 15 अलग-अलग हिस्सों को टारगेट (Target) करती है।
            जो गुरु के मुख से इस 'कोड' को डिकोड (Decode) करके जपता है, वह इंसान एक साधारण जीव से उठकर पूरे ब्रह्मांड का 'सोर्स कोड' (Source Code) हैक कर लेता है।
        """.trimIndent(),
        english = """
            (The absolute greatest and most highly classified verse of the Panchadasi Mantra - The Master Code): "Kama (Ka), Yoni (E), Kamala (I), Vajrapani (La), Guha (Hreem)."
            "Ha-Sa (Ha, Sa), Matarishva (Ka), Abhra (Ha), Indra (La), and again Guha (Hreem)."
            "Sa-Ka-La (Sa, Ka, La), and ultimately again Maya (Hreem)."
            "(Ka-E-I-La-Hreem, Ha-Sa-Ka-Ha-La-Hreem, Sa-Ka-La-Hreem). This exceptionally highly classified, supreme fifteen-syllable Vidya, which flawlessly pervades entirely in multiple cosmic forms (Puruchi)."
            "This exactly, and strictly this alone, is the direct 'Adi-Vidya' (The absolute First, Original, and Root Science / Vishvamatadi-vidya) of the 'Vishvamata' (the actual, real Mother of the entire universe)."
            This spectacular verse is undeniably the absolute biggest, ultimate 'Hacking Code' of Sanatana Dharma's entire Tantra Shastra! The Upanishad absolutely did not write the 15 syllables directly; it flawlessly hid them tightly in highly encrypted 'Code-words'!
            From Kama (Ka) straight up to Maya (Hreem)—this is the 100% exact, flawlessly accurate, and infallible Formula of Sri Vidya (Kadi Vidya).
            In ancient times, this specific mantra was considered so terrifyingly Powerful that the greatest sages absolutely never wrote it directly in any physical book, strictly ensuring absolutely no sinner or ignorant fool could ever maliciously misuse it.
            Therefore, it was aggressively and flawlessly Encrypted completely into the complex names of gods (Kama, Indra, Vajrapani).
            This 15-syllable 'Adi-Vidya' (Original Science) aggressively Targets exactly 15 distinct, highly critical sections of the human brain simultaneously.
            He who successfully Decodes this exact 'Code' directly from a true Guru's mouth and fiercely chants it, violently rises from being a pathetic creature to flawlessly hacking the absolute 'Source Code' of the entire universe.
        """.trimIndent()
    ),
    TripuraShloka(
        id = 13,
        sanskrit = "षष्ठं सप्तममथ वह्निसारथिमस्यामूलत्रिकमादेशयन्तः । कथ्यं कविं कल्पकमाकमं ते तं देवं साक्षादमृतत्वमापुः ॥ १३ ॥",
        hindi = """
            (मन्त्र का गुप्त ध्यान): जो अत्यंत ज्ञानी साधक इस आदि-विद्या के छठे (षष्ठं), सातवें (सप्तमम्) और आठवें (वह्निसारथिम्) अक्षरों को।
            तथा इस पूरी विद्या के 'मूल त्रिक' (शुरुआती तीन बीजों या त्रिकोणों / मूलत्रिकम्) को अत्यंत गहराई से अपने भीतर स्थापित (आदेशयन्तः / ध्यान) करते हैं।
            वे साधक उस परम देव (परमात्मा/तं देवं) को, जो सभी के द्वारा स्तुति करने योग्य (कथ्यं), सबका रचयिता (कविं), सब कुछ बनाने वाला (कल्पकम्), और सबसे महान (आकमं) है, साक्षात् रूप से जान लेते हैं।
            और उस परम सत्य को जानकर वे योगी 'साक्षात् अमरता' (पूर्ण मोक्ष / अमृतत्वम्) को हमेशा के लिए प्राप्त (आपुः) कर लेते हैं।
            इस श्लोक में श्री विद्या मंत्र के सबसे 'हीट जनरेटिंग' (Heat generating / वह्निसारथि) अक्षरों पर ध्यान करने की तकनीक (Technique) बताई गई है।
            मन्त्र का छठा और सातवां अक्षर (ह-स) इंसान के सीने (अनाहत चक्र) में स्थित भावनाओं (Emotions) को कंट्रोल करता है।
            और आठवां अक्षर 'क' (वह्निसारथि / अग्नि का साथी) इंसान के अंदर एक ऐसी 'आध्यात्मिक आग' (Spiritual Fire) लगा देता है जो उसके सारे पुराने डिप्रेशन (Depression) और डर को जला देती है।
            जब योगी इस 'त्रिक' (3 भागों) को अपनी रीढ़ की हड्डी में एक्टिवेट (Activate) कर लेता है, तो उसे भगवान कोई बाहरी मूर्ति नहीं लगते।
            उसे साक्षात् यह अहसास होता है कि "मैं खुद ही वह 'कवि' (Creator) हूँ जिसने इस दुनिया की कविता लिखी है!"
            इस भयंकर और डायरेक्ट (Direct) ज्ञान के मिलते ही मौत का सारा डर खत्म हो जाता है और इंसान 100% 'अमर' (अमृतत्वम्) हो जाता है।
        """.trimIndent(),
        english = """
            (The highly classified meditation of the Mantra): Those exceptionally wise and enlightened seekers who profoundly establish and intensely meditate (Adeshayantah) upon the exact sixth (Shashtam), seventh (Saptamam), and eighth (Vahnisarathim) syllables of this Adi-Vidya.
            Along with the absolute 'Mula Trikam' (the three primordial root seeds or core triangles) of this entire supreme science directly inside themselves.
            Those magnificent seekers flawlessly and directly realize that Supreme Lord (Tam Devam), who is supremely worthy of all absolute praise (Kathyam), the ultimate Author of all (Kavim), the absolute Creator of everything (Kalpakam), and the greatest of all (Akamam).
            And strictly by profoundly realizing that Absolute Truth, those master Yogis flawlessly and permanently attain 'Direct Immortality' (Absolute Moksha / Amritatvam) forever (Apuh).
            This spectacular verse explicitly reveals the highly advanced Technique of intensely meditating on the absolute most 'Heat-Generating' (Vahnisarathi) syllables of the Sri Vidya mantra.
            The exact sixth and seventh syllables (Ha-Sa) aggressively and flawlessly control the chaotic emotions firmly seated in the human chest (Anahata Chakra).
            And the exact eighth syllable 'Ka' (Vahnisarathi / the direct companion of blazing fire) violently ignites exactly such a terrifying 'Spiritual Fire' inside the human that it burns absolutely all his old depression and fear to ashes.
            When the master Yogi successfully Activates this 'Trikam' (3 sections) completely within his own spinal cord, God absolutely no longer appears as a cheap external idol to him.
            He attains the direct, explosive realization that "I myself am exactly that 'Kavi' (Creator) who flawlessly wrote the poetry of this entire world!"
            The exact split-second this terrifying and strictly Direct wisdom is attained, absolutely all fear of death is permanently annihilated, and the human becomes 100% literally 'Immortal' (Amritatvam).
        """.trimIndent()
    ),
    TripuraShloka(
        id = 14,
        sanskrit = "भाव्यं सार्धं त्रिभिरर्धैश्च बिन्दुभिर्भावातीतं शून्यमस्याः पदं च । तत्तुर्यं पदं च पञ्चमं च तत्तुर्यं पदं च पञ्चमं च ॥ १४ ॥",
        hindi = """
            (नाद-बिंदु और तुरीय अवस्था): इस विद्या की परम उपासना में साधक को साढ़े तीन (सार्धं त्रिभिः) मात्राओं वाले प्रणव (ॐ) और उसके ऊपर स्थित 'बिंदुओं' (अर्धैश्च बिन्दुभिः) का अत्यंत गहराई से ध्यान (भाव्यं) करना चाहिए।
            उन बिंदुओं से भी ऊपर, जो अवस्था 'भाव' (संसार के सभी विचारों और कल्पनाओं) से पूरी तरह से अतीत (परे / भावातीतं) है, और जो परम 'शून्य' (Void / पूर्ण खालीपन) है, वही माता का सबसे परम और असली 'पद' (स्थान / पदं च) है।
            वह परम शून्य स्थान ही साक्षात् 'तुरीय' (Turiya / चौथी और सबसे ऊँची चेतना) अवस्था है।
            और वही तुरीय अवस्था अंततः 'पञ्चम' (तुरीयातीत / पाँचवीं और अंतिम मोक्ष की अवस्था) में बदल जाती है (तत्तुर्यं पदं च पञ्चमं च)।
            तन्त्र में ध्वनि (Sound) का विज्ञान बहुत सूक्ष्म है। जब हम 'ॐ' या 'ह्रीं' बोलते हैं, तो जो आख़िरी 'म्म्म्म' (Humming sound) होता है, उसे 'नाद' और 'बिंदु' कहते हैं।
            वह आवाज़ धीरे-धीरे कम होकर एक 'सन्नाटे' (Silence) में गायब हो जाती है।
            उपनिषद कहता है कि उस सन्नाटे को ही माता का असली घर (शून्य / Void) जानो! वह शून्य डिप्रेशन (Depression) वाला खालीपन नहीं है; वह एक ऐसा भरा हुआ सन्नाटा है जहाँ दुनिया का कोई भी शोर (विचार) नहीं पहुँच सकता (भावातीत)।
            जब आपका दिमाग उस शून्य में टिक जाता है, तो आप जाग्रत, स्वप्न और सुषुप्ति—तीनों अवस्थाओं को पार करके चौथी 'तुरीय' अवस्था में पहुँच जाते हैं।
            और जब वह तुरीय अवस्था भी पक्की हो जाती है, तो इंसान पाँचवीं अवस्था (तुरीयातीत) में पहुँचकर 100% भगवान ही बन जाता है; उसके बाद कोई यात्रा बाकी नहीं रहती।
        """.trimIndent(),
        english = """
            (Nada-Bindu and the Turiya State): In the absolute supreme worship of this Vidya, the sincere seeker must exceptionally deeply meditate (Bhavyam) upon the exact three-and-a-half (Sardham tribhih) moras (measures) of the Pranava (OM) and the highly subtle 'Bindus' (dots/sound-fading) firmly situated right above it (Ardhayshcha bindubhih).
            Exactly infinitely above those subtle bindus, that absolute state which is completely and flawlessly beyond (Atitam) all 'Bhava' (all worldly thoughts, feelings, and cosmic imaginations / Bhavatitam), and which is the absolute supreme 'Shunya' (Void / perfect emptiness), that exactly is the Mother's absolute highest and truest 'Pada' (Abode / state / Padam cha).
            That exact supreme void state is the direct 'Turiya' (the fourth and absolute highest consciousness) state.
            And that exact Turiya state ultimately and flawlessly transforms perfectly into the 'Panchamam' (Turiyatita / the fifth, absolute final state of Moksha) (Tatturyam padam cha panchamam cha).
            In advanced Tantra, the profound science of Sound is exceptionally subtle. When we loudly chant 'OM' or 'Hreem', the absolute final fading 'Mmmm' (Humming sound) is rigorously called 'Nada' and 'Bindu'.
            That physical sound slowly, mathematically diminishes and vanishes completely into absolute 'Silence' (Sannata).
            The Upanishad fiercely commands: Know that exact flawless Silence to be the Mother's actual, real home (Shunya / Void)! That void is absolutely not the cheap emptiness of depression; it is exactly such a heavily dense silence where absolutely zero worldly noise (thoughts) can ever possibly reach (Bhavatita).
            Exactly when your highly restless brain perfectly anchors in that Shunya, you ruthlessly cross waking, dreaming, and deep sleep entirely, and instantly reach the fourth 'Turiya' state.
            And when even that Turiya state permanently solidifies, the human reaches the fifth state (Turiyatita) and literally becomes 100% God Himself; absolutely no spiritual journey remains left after that.
        """.trimIndent()
    ),
    TripuraShloka(
        id = 15,
        sanskrit = "खण्डान् पञ्च पदानि पञ्चाशदक्षराणि । एतदधीते स सर्ववेदाधीतो भवति स सर्वतीर्थेषु स्नातो भवति स सर्वयज्ञेषु यष्टो भवति ॥ १५ ॥",
        hindi = """
            (पञ्चदशी और मातृकाओं का महाफल): जो भी महान साधक माता की इस परम विद्या को, जो 'पाँच खण्डों' (खण्डान् पञ्च) और पंद्रह पदों (पञ्चाशदक्षराणि / पञ्चदशी या पचास मातृकाओं) में विभाजित है, पूरी तरह से जान और 'अध्ययन' (एतदधीते) कर लेता है।
            वह साधक निश्चित रूप से ऐसा हो जाता है मानो उसने दुनिया के 'सभी वेदों का पूरी तरह से अध्ययन' (सर्ववेदाधीतो) कर लिया हो (भवति)।
            वह ऐसा परम पवित्र हो जाता है मानो उसने दुनिया के 'सभी पवित्र तीर्थों' में जाकर साक्षात् 'स्नान' (सर्वतीर्थेषु स्नातो) कर लिया हो।
            और उसे वह परम फल मिलता है जो दुनिया के 'सभी बड़े-बड़े महा-यज्ञों' (सर्वयज्ञेषु) को सफलता पूर्वक संपन्न (यष्टो) करने वाले को मिलता है।
            यह श्लोक 'श्री विद्या' की ताकत की सबसे बड़ी 'गारंटी' (Guarantee) दे रहा है।
            आम इंसान जिंदगी भर इस पंडित के पास जाता है, उस नदी में नहाता है, और बड़े-बड़े यज्ञों में पैसा बर्बाद करता है, सिर्फ यह सोचकर कि उसके पाप धुल जाएंगे।
            पर त्रिपुरा उपनिषद डंके की चोट पर कहता है: तुम्हें कहीं जाने की जरूरत नहीं है!
            अगर तुमने केवल इस एक 'पञ्चदशी' मंत्र के 15 अक्षरों को और अपने शरीर के चक्रों को सही तरीके से ध्यान में (अध्ययन) एक्टिवेट (Activate) कर लिया।
            तो तुम्हारे शरीर के अंदर ही सारे वेद पढ़ लिए गए, सारी गंगा नदियों का स्नान हो गया, और सारे यज्ञ पूरे हो गए!
            क्योकि जो भगवान पूरे ब्रह्मांड में है, जब वह तुम्हारे दिमाग (सहस्रार) में ही प्रकट हो गया, तो बाहर की किसी भी चीज़ की क्या औकात बची?
        """.trimIndent(),
        english = """
            (The supreme massive fruit of Panchadasi and Matrikas): Whosoever magnificent seeker thoroughly knows and perfectly 'Studies' (Etadadhite) this absolute supreme Vidya of the Mother, which is flawlessly divided exactly into 'Five Sections' (Khandan pancha) and fifteen terms (Panchashadaksharani / Panchadasi or the fifty Sanskrit alphabets).
            That sincere seeker undoubtedly and certainly becomes exactly as if he has successfully and 'Completely studied absolutely all the Vedas' existing in the entire world (Sarvavedadhito bhavati).
            He becomes so exceptionally, supremely pure exactly as if he had physically traveled to and directly 'Bathed' flawlessly in absolutely 'All the sacred pilgrimages' of the entire world (Sarvatirtheshu snato bhavati).
            And he effortlessly attains exactly that absolute supreme fruit which is strictly acquired by successfully completing absolutely 'All massive, grand Maha-Yajnas' (Sarvayajneshu yashto bhavati) in existence.
            This spectacular verse provides the absolute greatest, ironclad 'Guarantee' of the terrifying raw power of 'Sri Vidya'.
            An ordinary, pathetic human spends his entire miserable life frantically running to this specific priest, violently bathing in that physical river, and wasting massive wealth on grand Yajnas, strictly thinking his heavy sins will magically wash away.
            But the Tripura Upanishad fiercely and boldly declares: You absolutely do not need to physically go anywhere!
            If you simply and flawlessly Activate exactly the 15 syllables of this single 'Panchadasi' mantra and your bodily chakras perfectly in deep meditation (Adhite).
            Then absolutely all the Vedas have been completely read, all holy Ganges rivers have been perfectly bathed in, and all massive Yajnas have been successfully completed strictly right inside your very own physical body!
            Because when that exact God who operates the entire massive cosmos literally manifests directly inside your own brain (Sahasrara), what exact value does absolutely any external physical object possess anymore?
        """.trimIndent()
    ),
    TripuraShloka(
        id = 16,
        sanskrit = "एतं मन्त्रं यो वेत्ति स त्रैलोक्यं जयति स त्रैलोक्यं जयति इत्युपनिषत् । ॐ शान्तिः शान्तिः शान्तिः ॥ १६ ॥",
        hindi = """
            (त्रिपुरा उपनिषद की परम फलश्रुति और समापन): "जो कोई भी भाग्यशाली और मुमुक्षु साधक इस परम 'पञ्चदशी महामन्त्र' (एतं मन्त्रं) को यथार्थ रूप में 'जान' (यो वेत्ति / अनुभव कर) लेता है।"
            "वह मनुष्य निश्चित रूप से इस पूरे 'त्रैलोक्य' (तीनों लोकों—स्वर्ग, पृथ्वी, और पाताल) को पूरी तरह से 'जीत' (जयति) लेता है!"
            (इस बात की 100% गारंटी और पूर्ण निश्चितता देने के लिए श्रुति इसे दोबारा अत्यंत ज़ोर देकर दोहराती है): "हाँ! वह निश्चित रूप से तीनों लोकों को पूरी तरह जीत लेता है!" (स त्रैलोक्यं जयति)।
            यहीं पर श्री विद्या और तन्त्र शास्त्र का यह अत्यंत गुप्त, परम पवित्र और महान खजाना 'त्रिपुरा उपनिषद' पूर्ण रूप से और अत्यंत शुभता के साथ संपन्न (इत्युपनिषत्) होता है।
            ॐ शांतिः शांतिः शांतिः! (माता महात्रिपुरसुंदरी की परम और अखंड शांति हमारे शरीर, मन और असीम आत्मा में हमेशा के लिए स्थापित हो)।
            यहाँ तीनों लोकों को 'जीतने' (जयति) का मतलब कोई फिजिकल (Physical) युद्ध लड़कर राजा बनना नहीं है!
            स्वर्ग (सुख), पृथ्वी (कर्म), और पाताल (दुख)—ये तीनों इंसान के 'दिमाग' (Mind) की ही तीन अलग-अलग अवस्थाएं (States) हैं।
            जब साधक इस 15 अक्षरों वाले श्री विद्या मंत्र के द्वारा अपने अहंकार (Ego) को पूरी तरह भस्म कर देता है, तो वह इन तीनों अवस्थाओं (सुख-दुख) से 100% ऊपर उठ जाता है।
            जब दुनिया की कोई भी चीज़—चाहे वह स्वर्ग का लालच हो या पाताल का डर—उसे हिला नहीं सकती, तो इसका सीधा मतलब है कि उसने इस पूरे ब्रह्मांड (त्रैलोक्य) को 'जीत' लिया है!
            वह इंसान एक लाचार जीव की जेल से आज़ाद होकर साक्षात् 'शिव' बन जाता है, और यही सनातन धर्म का सबसे बड़ा और आख़िरी वादा है।
        """.trimIndent(),
        english = """
            (The supreme Phala Shruti and absolute final Conclusion of Tripura Upanishad): "Whosoever fortunate and sincere seeker truly 'Knows' and directly experiences (Yo vetti) this absolute supreme 'Panchadasi Maha-Mantra' (Etam mantram) in actual reality."
            "That specific human being undoubtedly, certainly, and flawlessly 'Conquers' (Jayati) this entire massive 'Trailokya' (the three worlds—Heaven, Earth, and the Netherworld) completely!"
            (Strictly to demonstrate absolute, flawless certainty and to provide a 100% Ironclad Guarantee, the Shruti violently and aggressively repeats it twice): "Yes! He undoubtedly and certainly conquers all three worlds entirely!" (Sa trailokyam jayati).
            Right exactly here, this exceptionally highly classified, supreme, and profoundly sacred treasure of Sri Vidya and Tantra Shastra, the 'Tripura Upanishad', perfectly and auspiciously achieves absolute completion (Ityupanishat).
            OM Peace, Peace, Peace! (May the supreme, infinite, and unbroken peace of Mother Mahatripurasundari be permanently established within our physical body, restless mind, and immortal soul forever).
            Here, 'Conquering' (Jayati) the three massive worlds absolutely does not mean aggressively fighting a physical war and becoming a cheap political king!
            Heaven (Joy), Earth (Action), and Netherworld (Sorrow)—these exact three are strictly just three distinct physical States of the human 'Mind' itself.
            When the master Yogi violently burns his toxic Ego to absolute ashes strictly through this 15-syllable Sri Vidya mantra, he flawlessly and 100% rises infinitely above all these three states (joy and sorrow).
            Exactly when absolutely nothing in the world—neither the intense greed for heaven nor the terrifying fear of hell—can ever possibly shake him, it explicitly means he has permanently 'Conquered' this entire cosmos (Trailokya)!
            That human flawlessly escapes the pathetic jail of a helpless creature and seamlessly transforms literally into 'Shiva' Himself, and this is undeniably Sanatana Dharma's absolute greatest and final promise.
        """.trimIndent()
    )
)