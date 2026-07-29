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

// Data Model
data class SubalaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubalaUpanishadScreen() {
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
                if (shlokaNumber != null && shlokaNumber in 1..16) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Khanda Number (1-16)") },
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
            itemsIndexed(subalaShlokasList) { _, shloka ->
                SubalaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun SubalaShlokaCard(shloka: SubalaShloka) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Khanda ${shloka.id}",
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

val subalaShlokasList: List<SubalaShloka> = listOf(
    SubalaShloka(
        id = 1,
        sanskrit = "अथ खलु सुबालो ब्रह्मलोकमगच्छत् । उवाच च तमासीनं किं तदासीदिति । स होवाच न सन्नासन्न सदसदिति ॥ १ ॥",
        hindi = """
            (सुबाल उपनिषद का आरंभ): महर्षि सुबाल परम ज्ञान की खोज में साक्षात् ब्रह्मलोक गए और उन्होंने वहाँ विराजमान ब्रह्मा जी से पूछा।
            "हे भगवन्! इस सृष्टि के निर्माण से पहले, बिल्कुल शुरुआत में यहाँ वास्तव में क्या था?" (किं तदासीदिति)।
            ब्रह्मा जी ने अत्यंत गहराई से उत्तर दिया: "सृष्टि से पहले न तो कोई 'सत्' (अस्तित्व/होना) था, और न ही 'असत्' (न होना) था।"
            "और न ही यहाँ इन दोनों (सत् और असत्) का कोई मिला-जुला रूप (सदसद्) ही मौजूद था।"
            "वहाँ केवल एक भयंकर अंधकार (तमस) था, जिसमें से सबसे पहले वह एक 'परम पुरुष' (ईश्वर) प्रकट हुआ।"
            यह श्लोक सृष्टि की उत्पत्ति (Big Bang से भी पहले की अवस्था) का अत्यंत गहरा वैज्ञानिक और दार्शनिक वर्णन है।
            जब समय (Time), स्थान (Space), और पदार्थ (Matter) कुछ भी नहीं था, तब केवल एक 'अव्यक्त शून्यता' (Unmanifested void) मौजूद थी।
            हम अक्सर सोचते हैं कि भगवान ने दुनिया किसी बाहरी 'मटेरियल' (Material) से बनाई है; पर उपनिषद कहता है कि शुरुआत में कुछ था ही नहीं।
            यहाँ 'तमस' का अर्थ कोई शैतानी बुराई नहीं है, बल्कि वह रहस्यमयी 'डार्क एनर्जी' (Dark Energy) है जिसमें ब्रह्मांड के सारे बीज गहरी नींद में सोए हुए थे।
            यह उपनिषद हमें भौतिक दुनिया के शोर से निकालकर सीधे उस 'कारण-अवस्था' (Causal State) में ले जाता है जहाँ से सब कुछ पैदा हुआ है।
        """.trimIndent(),
        english = """
            (The beginning of Subala Upanishad): Sage Subala, in his profound quest for supreme wisdom, went directly to Brahmaloka and asked Lord Brahma residing there.
            "O Supreme Lord! Exactly what existed here in the absolute beginning, long before the creation of this universe?" (Kim tadasititi).
            Lord Brahma profoundly answered: "Before creation, there was absolutely neither 'Sat' (Existence) nor 'Asat' (Non-existence)."
            "Nor was there even a mixture of these two (Sadasad) existing anywhere in the cosmos."
            "There was exclusively a terrifying, absolute darkness (Tamas), from which that 'Supreme Person' (God) first miraculously manifested Himself."
            This phenomenal verse provides an exceptionally deep scientific and philosophical description of the absolute beginning (the state even before the Big Bang).
            Exactly when absolutely no Time, Space, or physical Matter existed, only a pure, absolute 'Unmanifested Void' perfectly existed.
            We frequently falsely assume that God manufactured the world out of some existing external physical 'Material'; but the Upanishad declares there was zero material initially.
            Here, 'Tamas' absolutely does not mean evil, but that highly mysterious, primordial dark energy (Dark Energy) where all seeds of the cosmos slept deeply.
            This magnificent Upanishad aggressively pulls us out of the physical world's noise and takes us straight into that absolute 'Causal State' from which everything was born.
        """.trimIndent()
    ),
    SubalaShloka(
        id = 2,
        sanskrit = "तस्याण्डस्यार्धं कपालं भूमिर्भवति । अर्धं कपालमाकाशं भवति । ततो भूतानि सृज्यन्ते ॥ २ ॥",
        hindi = """
            (ब्रह्मांड की रचना): उस परम पुरुष ने सबसे पहले एक अत्यंत विशाल और तेजोमय 'ब्रह्मांडीय अंडा' (Cosmic Egg / हिरण्यगर्भ) उत्पन्न किया।
            उस महा-अंडे के टूटने पर, उसके नीचे का आधा हिस्सा (कपालं) यह 'भूमि' (Earth/धरती) बन गया।
            और उस अंडे के ऊपर का आधा हिस्सा (कपालं) यह असीम 'आकाश' (Sky/स्वर्ग) बन गया।
            उसके बाद उसी परम शक्ति से पांचों महाभूत (पृथ्वी, जल, अग्नि, वायु, आकाश) और सभी दिशाओं की रचना (सृज्यन्ते) हुई।
            यह श्लोक प्राचीन भारतीय कॉस्मोलॉजी (Cosmology) का वह प्रसिद्ध 'हिरण्यगर्भ' (Golden Womb) सिद्धांत है जो आधुनिक विज्ञान (Big Bang Theory) से बिल्कुल मेल खाता है।
            ब्रह्मांड की शुरुआत एक अत्यंत सघन (Dense) और गर्म बिंदु (अंडा) से हुई थी, जिसके फटने से यह पूरा यूनिवर्स (Universe) फैल गया।
            आधा हिस्सा धरती (Matter) बना और आधा हिस्सा आकाश (Space) बना; यह जड़ (Mass) और खाली जगह (Space) का परफेक्ट बैलेंस (Balance) है।
            दुनिया किसी जादू की छड़ी घुमाकर नहीं बनी; यह एक अत्यंत क्रमिक (Sequential) और साइंटिफिक प्रक्रिया से गुजरी है।
            ब्रह्मा जी समझा रहे हैं कि यह दुनिया जो हमें इतनी ठोस और पक्की लगती है, वह असल में एक टूटे हुए अंडे का छिलका मात्र है।
            इस ज्ञान का उद्देश्य यह है कि हम इस नाशवान दुनिया (छिलके) से अपना मोह छोड़कर उस 'परम पुरुष' से जुड़ें जिसने इस अंडे को बनाया था।
        """.trimIndent(),
        english = """
            (The precise creation of the universe): That Supreme Person absolute first produced an exceptionally massive, highly radiant 'Cosmic Egg' (Hiranyagarbha).
            Upon the violent bursting of that massive egg, its lower half-shell (Kapalam) flawlessly became this 'Earth' (Bhumi / solid ground).
            And the exact upper half-shell (Kapalam) of that cosmic egg perfectly expanded to become this infinite 'Sky' (Space / Heaven).
            Immediately after that, strictly from that same supreme power, the five gross elements and absolutely all directions were systematically created (Srijyante).
            This spectacular verse is the highly famous 'Hiranyagarbha' (Golden Womb) theory of ancient Indian Cosmology, matching perfectly with the modern Big Bang Theory.
            The universe's creation rigorously began from an exceptionally dense and terrifyingly hot single point (Egg), the violent explosion of which expanded into this entire universe.
            Half became the Earth (solid Matter) and half became the Sky (empty Space); this represents the perfect, absolute Balance of Mass and Space.
            The world was absolutely not manufactured by casually waving a magic wand; it strictly underwent an exceptionally Sequential and highly Scientific biological process.
            Lord Brahma is profoundly explaining that this entire world, which feels incredibly solid to us, is in absolute reality merely the broken shell of a cosmic egg.
            The absolute supreme purpose of this wisdom is to force us to drop our toxic attachment to this perishable shell and connect strictly to the 'Supreme Person' who created it.
        """.trimIndent()
    ),
    SubalaShloka(
        id = 3,
        sanskrit = "नारायणाद् ब्रह्मा जायते । नारायणाद्रुद्रो जायते । नारायणादिन्द्रो जायते । नारायणात्प्रजापतयः ॥ ३ ॥",
        hindi = """
            (सभी देवताओं का मूल स्रोत): इस संपूर्ण ब्रह्मांड में साक्षात् भगवान 'नारायण' (विष्णु/परब्रह्म) से ही सृष्टि के रचयिता 'ब्रह्मा' उत्पन्न (जायते) होते हैं।
            उसी एक नारायण से ही संहार के देवता 'रुद्र' (शिव) की उत्पत्ति (जायते) होती है।
            उसी परम नारायण से ही देवताओं के राजा 'इंद्र' (इन्द्रो) का जन्म होता है।
            और उसी नारायण से ही संपूर्ण प्रजा को उत्पन्न करने वाले सभी 'प्रजापति' (Prajapatis) पैदा होते हैं।
            यह श्लोक किसी 'संप्रदाय' (Sect) को बढ़ावा नहीं दे रहा है; यहाँ 'नारायण' का अर्थ वह असीम, निराकार 'सुप्रीम चेतना' (Supreme Consciousness) है।
            हम अज्ञानवश ब्रह्मा, विष्णु और महेश को अलग-अलग देवता मानकर आपस में लड़ते हैं।
            पर उपनिषद स्पष्ट करता है कि ये सब केवल उसी एक 'नारायण' (अंतिम सत्य) की अलग-अलग किरणें (Rays) मात्र हैं।
            जैसे एक ही बिजली (Electricity) से पंखा, फ्रिज और टीवी तीनों चलते हैं, वैसे ही एक ही नारायण से ये सभी देवता अपना-अपना काम कर रहे हैं।
            यह श्लोक अद्वैत दर्शन (Non-duality) का वह सबसे बड़ा डिक्लेरेशन (Declaration) है जो इंसान के मन से 'अनेकता' (Multiplicity) के भ्रम को हमेशा के लिए मिटा देता है।
            जब सब कुछ उसी एक से पैदा हुआ है, तो हमें भी उसी एक परम सत्य (नारायण) की ही शरण लेनी चाहिए, क्योंकि बाकी सब तो उसके कर्मचारी (Servants) हैं।
        """.trimIndent(),
        english = """
            (The absolute root source of all Gods): In this entire cosmos, it is strictly and exclusively from Lord 'Narayana' (Supreme Brahman) that 'Brahma', the creator, is born (Jayate).
            It is exactly from that exact same one Narayana that 'Rudra' (Shiva), the god of destruction, is successfully produced (Jayate).
            It is solely from that supreme Narayana that 'Indra', the mighty king of all celestial gods, takes his birth.
            And it is exclusively from that exact Narayana alone that absolutely all the 'Prajapatis' (the grand progenitors of all creatures) are perfectly born.
            This magnificent verse is absolutely not heavily promoting any specific religious 'Sect'; here, 'Narayana' strictly means that infinite, formless 'Supreme Consciousness'.
            Out of thick, blinding ignorance, we falsely consider Brahma, Vishnu, and Shiva as completely separate deities and violently fight among ourselves.
            But the Upanishad explicitly clarifies that absolutely all of them are merely different shining Rays of that exact same one 'Narayana' (Ultimate Truth).
            Just exactly as a single current of Electricity effortlessly runs the fan, fridge, and TV, similarly, from one single Narayana, all these gods powerfully perform their respective duties.
            This verse is the absolute greatest Declaration of Advaita philosophy (Non-duality) that permanently annihilates the blinding illusion of 'Multiplicity' from the human mind forever.
            When absolutely everything is born exclusively from that One, we must ruthlessly take absolute refuge solely in that One Supreme Truth (Narayana), because everyone else is merely His servant.
        """.trimIndent()
    ),
    SubalaShloka(
        id = 4,
        sanskrit = "तन्मध्ये हृदयपुण्डरीकं च । तस्मिन्दश नाड्यो भवन्ति । तासां मध्ये सुषिराः ॥ ४ ॥",
        hindi = """
            (हृदय और नाड़ियों का शरीर-विज्ञान): मनुष्य के इस भौतिक शरीर के बिल्कुल बीचोबीच (तन्मध्ये) एक अत्यंत पवित्र 'हृदय-कमल' (हृदयपुण्डरीकं / Heart-Lotus) स्थित है।
            उस दिव्य हृदय-कमल के भीतर मुख्य रूप से 'दस नाड़ियां' (दश नाड्यो / Ten primary energy channels) निकलती हैं।
            उन दस नाड़ियों के बिल्कुल मध्य (बीच) में अत्यंत सूक्ष्म और रहस्यमयी 'सुषिर' (छोटे-छोटे छिद्र / Microscopic cavities) मौजूद हैं।
            (इन्हीं छिद्रों से होकर प्राण ऊर्जा और चेतना पूरे शरीर में यात्रा करती है)।
            सुबाल उपनिषद यहाँ कॉस्मोलॉजी (Cosmology) से सीधे 'ह्यूमन एनाटॉमी' (Human Anatomy) में गोता लगाता है।
            हमारे सीने में धड़कने वाला दिल केवल खून पंप (Pump) करने की एक मशीन नहीं है; योग के अनुसार यह हमारी चेतना (Consciousness) का हेडक्वार्टर (Headquarter) है।
            इस हृदय से निकलने वाली ये 'दस नाड़ियां' (जैसे इड़ा, पिंगला, सुषुम्ना आदि) हमारे नर्वस सिस्टम (Nervous system) के सबसे बड़े हाईवे (Highways) हैं।
            यह कोई कल्पना नहीं है; जब योगी गहरे ध्यान में जाता है, तो उसे ये नाड़ियां प्रकाश की चमकती हुई तारों (Glowing wires) की तरह साफ दिखाई देती हैं।
            उन नाड़ियों के अंदर जो 'सुषिर' (खाली जगह) है, वहीं पर 'परमात्मा' (नारायण) एक गवाह (Witness) की तरह चुपचाप बैठा है।
            साधक को बाहर की दुनिया की सैर बंद करके अपनी साँसों के रास्ते इन्हीं नाड़ियों के अंदर सफर करना होता है, ताकि वह उस 'हृदय-कमल' के मालिक (ईश्वर) से मिल सके।
        """.trimIndent(),
        english = """
            (The strict physiology of the heart and Nadis): Exactly right in the absolute center of this physical human body (Tanmadhye) is situated a highly sacred 'Heart-Lotus' (Hridayapundarikam).
            Strictly within that divine heart-lotus, exactly 'Ten primary Nadis' (Dasha Nadyo / main energy channels) flawlessly originate and actively extend outwards.
            Exactly right in the absolute middle of those ten powerful Nadis exist exceedingly subtle and highly mystical 'Sushiras' (Microscopic holes / subtle cavities).
            (It is strictly through these highly microscopic cavities that the vital Prana energy and pure consciousness actively travel throughout the entire body).
            The Subala Upanishad profoundly dives directly from grand Cosmology straight into microscopic 'Human Anatomy' right here.
            The physical heart beating aggressively in our chest is absolutely not merely a biological blood-pumping machine; according to Yoga, it is the ultimate Headquarter of our Consciousness.
            These exact 'Ten Nadis' originating strictly from this heart (like Ida, Pingala, Sushumna) are the absolute biggest super-Highways of our entire internal Nervous System.
            This is absolutely no cheap imagination; when a master Yogi enters extremely deep meditation, he clearly sees these Nadis exactly like brilliantly glowing wires of solid light.
            Exactly inside the 'Sushira' (empty space) perfectly within those Nadis, the 'Supreme Lord' (Narayana) sits perfectly quietly strictly as a silent Witness.
            The sincere seeker must aggressively stop touring the external physical world and travel strictly inside these exact Nadis via the breath, to successfully meet the Master of that 'Heart-Lotus' (God).
        """.trimIndent()
    ),
    SubalaShloka(
        id = 5,
        sanskrit = "प्राणोऽपानः समान उदानो व्यानश्चेति । एते पञ्च वायवो हृदि तिष्ठन्ति ॥ ५ ॥",
        hindi = """
            (पञ्च प्राणों का वर्णन): मनुष्य के उस हृदय-कमल और नाड़ियों में मुख्य रूप से पाँच प्रकार की 'वायु' (प्राण ऊर्जा / Vital breaths) हमेशा निवास करती हैं।
            उनके नाम हैं: 1. प्राण (भीतर जाने वाली साँस), 2. अपान (नीचे की ओर जाने वाली ऊर्जा), 3. समान (पेट में पाचन करने वाली ऊर्जा)।
            4. उदान (गले से ऊपर जाने वाली ऊर्जा), और 5. व्यान (खून के साथ पूरे शरीर में दौड़ने वाली ऊर्जा)।
            ये पाँचों प्रकार के 'वायु' (वायवो) मूल रूप से मनुष्य के 'हृदय' (हृदि) में ही टिके हुए (तिष्ठन्ति) हैं और वहीं से पूरे शरीर को कंट्रोल (Control) करते हैं।
            यह श्लोक शरीर को जिंदा रखने वाले 'इंजन' (Engine) के 5 सबसे जरूरी पुर्जों का वर्णन कर रहा है।
            हम सोचते हैं कि हम खाना खाने से ज़िंदा हैं, पर असल में हम इन 'पाँच प्राणों' के कारण ज़िंदा हैं।
            हृदय (Heart) केवल खून नहीं फेंकता, वह इन 5 प्राणों का मेन स्विचबोर्ड (Main switchboard) है।
            जब इंसान को हार्ट अटैक (Heart attack) आता है, तो असल में खून नहीं, बल्कि ये 'पञ्च प्राण' अपनी जगह छोड़कर बाहर भाग जाते हैं।
            योगी प्राणायाम के द्वारा इन पाँचों हवाओं (Winds) को अपने 100% कंट्रोल में ले लेता है; वह अपान को नीचे नहीं जाने देता और प्राण को बाहर नहीं जाने देता।
            जब ये पाँचों प्राण हृदय में पूरी तरह शांत होकर एक जगह रुक जाते हैं, तो शरीर लोहे का बन जाता है और इंसान को साक्षात् 'समाधि' का अनुभव होता है।
        """.trimIndent(),
        english = """
            (Description of the Pancha-Pranas): Exactly within that sacred heart-lotus and the subtle Nadis, exactly five specific types of 'Vayu' (Vital Prana energies / winds) perpetually reside.
            Their exact names are: 1. Prana (the inward-moving breath), 2. Apana (the violently downward-moving energy), 3. Samana (the balancing digestive energy in the stomach).
            4. Udana (the upward-moving energy in the throat), and 5. Vyana (the omnipresent energy continuously rushing throughout the entire body with the blood).
            Absolutely all these five specific 'Winds' (Vayavo) are fundamentally anchored and firmly established (Tishthanti) strictly within the human 'Heart' (Hridi), actively controlling the entire body from there.
            This magnificent verse accurately describes the 5 absolute most crucial components of the massive 'Engine' keeping the physical body actively alive.
            We falsely and arrogantly assume we are alive simply because we eat food, but in absolute reality, we are alive exclusively because of these 'Five Pranas'.
            The Heart absolutely does not merely pump physical blood; it is the absolute Main Switchboard for all these 5 vital cosmic energies.
            When a human suffers a massive Heart Attack, it is not merely blood stopping, but these 'Pancha-Pranas' aggressively abandoning their posts and rushing violently out of the body.
            A master Yogi, strictly through intense Pranayama, brings absolutely all five of these Winds under his 100% flawless Control; he fiercely prevents Apana from escaping down and Prana from escaping out.
            When absolutely all five Pranas become perfectly still and locked entirely in the heart, the physical body becomes as unbreakable as steel, and the human flawlessly experiences direct 'Samadhi'.
        """.trimIndent()
    ),
    SubalaShloka(
        id = 6,
        sanskrit = "चक्षुश्च द्रष्टव्यं च नारायणः । श्रोत्रं च श्रोतव्यं च नारायणः । घ्राणं च घ्रातव्यं च नारायणः ॥ ६ ॥",
        hindi = """
            (नारायण की सर्वव्यापकता): यह देखने वाली 'आँख' (चक्षुश्च) भी साक्षात् भगवान नारायण ही है, और जो दृश्य 'देखा जा रहा है' (द्रष्टव्यं), वह भी नारायण ही है।
            यह सुनने वाला 'कान' (श्रोत्रं) भी साक्षात् नारायण है, और जो शब्द या आवाज़ 'सुनी जा रही है' (श्रोतोव्यं), वह भी स्वयं नारायण ही है।
            यह सूँघने वाली 'नाक' (घ्राणं) भी नारायण ही है, और जो सुगंध 'सूँघी जा रही है' (घ्रातव्यं), वह भी केवल और केवल नारायण (परमात्मा) ही है।
            यह श्लोक अद्वैत (Non-duality) की सबसे बड़ी और सबसे शानदार घोषणा है, जो इंसान के होश उड़ा देती है!
            हम हमेशा सोचते हैं कि "मैं (Subject) दुनिया (Object) को देख रहा हूँ"; हम इन दोनों को बिल्कुल अलग मानते हैं।
            पर उपनिषद कहता है: तुम्हारी आँखें कोई हाड़-मांस का टुकड़ा नहीं हैं, तुम्हारी आँख बनकर साक्षात् 'भगवान' ही इस दुनिया को देख रहा है।
            और जो सामने पहाड़ या इंसान खड़ा है, वह भी कोई पत्थर या मिट्टी नहीं, वह भी साक्षात् 'भगवान' ही है जो दृश्य (Scenery) का रूप लेकर खड़ा है।
            यानी देखने वाला भी भगवान, और जो देखा जा रहा है वह भी भगवान! फिर बीच में यह घमंडी 'मैं' (Ego) कहाँ से आ गया?
            जब साधक को यह समझ आ जाता है कि "यहाँ मेरे अलावा सब कुछ नारायण ही है, और मैं खुद भी नारायण हूँ", तो उसकी सारी नफरत और डर एक सेकंड में जलकर राख हो जाते हैं।
            यह 'पूर्ण एकात्मता' (Absolute Oneness) का वह परम ज्ञान है जो दुनिया के हर कण को एक पवित्र मंदिर (Temple) में बदल देता है।
        """.trimIndent(),
        english = """
            (The Absolute Omnipresence of Narayana): This physical seeing 'Eye' (Chakshushcha) itself is directly Lord Narayana, and whatever specific scene is 'being actively seen' (Drashtavyam) is also strictly Narayana alone.
            This physical hearing 'Ear' (Shrotram) itself is the direct embodiment of Narayana, and whatever word or loud sound is 'being actively heard' (Shrotavyam) is also exactly Narayana Himself.
            This smelling 'Nose' (Ghranam) itself is perfectly Narayana, and absolutely whatever fragrance is 'being actively smelled' (Ghratavyam) is solely and exclusively Narayana (the Supreme Lord) alone.
            This phenomenal verse is the absolute greatest and most spectacular declaration of Advaita (Non-duality), completely blowing the limited human mind away!
            We perpetually falsely assume that "I (the Subject) am actively seeing the world (the Object)"; we foolishly consider these two to be completely separated.
            But the Upanishad fiercely declares: your eyes are absolutely not mere pieces of flesh; it is the direct, living 'God' Himself who has flawlessly become your eyes and is seeing this world.
            And the massive mountain or human standing directly before you is absolutely not mere stone or dirt; it is exactly 'God' Himself standing flawlessly in the form of that Scenery.
            Meaning, the absolute Seer is God, and the absolute Seen is also God! Then from where exactly did this arrogant, toxic 'I' (Ego) sneak in between?
            When the seeker profoundly realizes that "Absolutely everything here is exclusively Narayana, and I myself am also Narayana," absolutely all his hatred and terrifying fear burn to ashes in a single second.
            This is the supreme wisdom of 'Absolute Oneness' that flawlessly transforms every single microscopic atom of the world directly into a highly sacred Temple.
        """.trimIndent()
    ),
    SubalaShloka(
        id = 7,
        sanskrit = "यः पृथिव्यां तिष्ठन् पृथिव्या अन्तरः । यं पृथिवी न वेद यस्य पृथिवी शरीरम् । यो पृथिवीमन्तरो यमयति स एष सर्वभूतान्तरात्मापहतपाप्मा दिव्यो देव एको नारायणः ॥ ७ ॥",
        hindi = """
            (अन्तर्यामी ब्राह्मण का रहस्य): जो परमात्मा इस 'पृथ्वी' (धरती) में रहता है (तिष्ठन्), फिर भी जो इस पृथ्वी से पूरी तरह अलग और इसके भीतर (अन्तरः) है।
            जिस परमात्मा को यह पृथ्वी खुद भी बिल्कुल नहीं जानती (न वेद), और यह पूरी पृथ्वी जिसका केवल एक 'शरीर' मात्र है।
            जो इस पृथ्वी के बिल्कुल भीतर बैठकर उसे पूरी तरह से नियंत्रित (कंट्रोल / यमयति) करता है।
            वही एकमात्र परमात्मा सभी प्राणियों की साक्षात् 'अंतरात्मा' है, जो सभी पापों से पूरी तरह मुक्त (अपहतपाप्मा), अत्यंत दिव्य और एकमात्र (एको) भगवान 'नारायण' है।
            यह श्लोक 'बृहदारण्यक उपनिषद' के अत्यंत प्रसिद्ध 'अंतर्यामी ब्राह्मण' की ही गूंज है।
            लोग पूछते हैं कि "भगवान कहाँ है?" उपनिषद जवाब देता है: भगवान इस धरती के कण-कण के 'अंदर' (Core) बैठा है।
            धरती कोई निर्जीव (Dead) पत्थर नहीं है; यह साक्षात् भगवान का ही एक 'शरीर' है, और भगवान इस धरती का 'आत्मा' (Soul) है।
            जैसे आपके शरीर के अंदर आत्मा है पर शरीर (हाथ-पैर) उस आत्मा को देख नहीं सकता (न वेद); वैसे ही धरती (और हम सब) अपने अंदर बैठे उस भगवान को देख नहीं पाते।
            वह भगवान किसी डंडे से दुनिया को नहीं चलाता; वह 'अंदर' (अन्तरो) बैठकर इस पूरी गैलेक्सी (Galaxy) के नियमों (Gravity, orbits) को कंट्रोल (यमयति) कर रहा है।
            वह परम पवित्र (अपहतपाप्मा) है; दुनिया में चाहे कितने भी पाप हों, उस नारायण को कोई पाप या गंदगी कभी छू नहीं सकती।
        """.trimIndent(),
        english = """
            (The secret of the Antaryami Brahmana): That Supreme Lord who flawlessly resides (Tishthan) inside this 'Earth' (Prithvi), yet who remains completely distinct and flawlessly entirely inside (Antarah) the earth.
            That exact God whom the earth herself absolutely does not know or perceive (Na veda), and this entire massive earth is merely just a physical 'Body' (Shariram) of His.
            He who, sitting absolutely perfectly inside this earth, ruthlessly and flawlessly controls and operates it entirely (Yamayati).
            That one single Supreme Lord is the direct, living 'Inner Soul' (Antaratma) of absolutely all beings; He is completely totally free from absolutely all sins (Apahatapapma), exceptionally divine, and the One and only (Eko) Lord 'Narayana'.
            This magnificent verse is the exact, flawless echo of the exceptionally famous 'Antaryami Brahmana' from the Brihadaranyaka Upanishad.
            Ignorant people foolishly ask, "Where exactly is God?" The Upanishad powerfully answers: God sits flawlessly right in the absolute 'Core' of every single atom of this earth.
            The earth is absolutely not a dead, lifeless rock; it is the direct physical 'Body' of God Himself, and God is the absolute pure 'Soul' of this earth.
            Just exactly as the Soul resides perfectly inside your body, yet your physical body (hands/feet) simply cannot see that Soul (Na veda); similarly, the earth (and all of us) completely fail to see that God sitting exactly inside us.
            That God absolutely does not run the world using a physical stick; He sits perfectly 'Inside' (Antaro) and flawlessly Controls (Yamayati) absolutely all the complex laws (Gravity, orbits) of this entire Galaxy.
            He is supremely pure (Apahatapapma); no matter how many terrifying sins exist in the world, absolutely zero sin or filthy dirt can ever possibly touch that pure Narayana.
        """.trimIndent()
    ),
    SubalaShloka(
        id = 8,
        sanskrit = "योऽक्षरे तिष्ठन्नक्षरादन्तरः । यमक्षरं न वेद यस्याक्षरं शरीरम् । योऽक्षरमन्तरो यमयति स एष सर्वभूतान्तरात्मापहतपाप्मा दिव्यो देव एको नारायणः ॥ ८ ॥",
        hindi = """
            (अन्तर्यामी का ज्ञान जारी है): जो परमात्मा उस 'अक्षर' (अविनाशी जीवात्मा / Individual Soul) के भीतर स्थित (तिष्ठन्) है, फिर भी जो उस जीवात्मा से पूरी तरह अलग और उसके बिल्कुल भीतर (अन्तरः) है।
            जिस परमात्मा को वह जीवात्मा खुद भी बिल्कुल नहीं जानती (न वेद), और वह जीवात्मा भी जिसका केवल एक 'शरीर' मात्र है।
            जो उस जीवात्मा के भी बिल्कुल भीतर बैठकर उसे पूरी तरह से नियंत्रित (यमयति) करता है।
            वही एकमात्र परमात्मा सभी प्राणियों की साक्षात् 'अंतरात्मा' है, जो सभी पापों से पूरी तरह मुक्त (अपहतपाप्मा), अत्यंत दिव्य और एकमात्र (एको) भगवान 'नारायण' है।
            पिछले श्लोक में भगवान को धरती (Matter) का कंट्रोलर (Controller) बताया गया था; पर यह श्लोक उससे भी 100 गुना ज्यादा गहरा है!
            हम वेदान्त में पढ़ते हैं कि "आत्मा ही सब कुछ है" (अक्षर)। पर यह श्लोक कहता है कि भगवान उस 'आत्मा' के भी 'अंदर' (Core of the core) बैठा हुआ है!
            हमारा यह घमंडी जीव (Individual soul) भी भगवान नहीं है; यह जीव तो केवल भगवान का पहना हुआ एक 'कपड़ा' (शरीर) मात्र है!
            जीव (हम) जीवन भर सोचते हैं कि "मैं अपनी मर्जी से काम कर रहा हूँ।" पर अंदर से वह नारायण ही इस जीव को कंट्रोल (यमयति) कर रहा है।
            हमारी आत्मा (अक्षर) उस भगवान को इसलिए नहीं देख पाती (न वेद) क्योंकि वह भगवान आत्मा की भी आत्मा (अंतरात्मा) है (आँख खुद को कैसे देखेगी?)।
            यह श्लोक इंसान के उस आखिरी 'अहंकार' को भी पूरी तरह कुचल देता है जो सोचता है कि "मैं (जीव) ही ईश्वर हूँ"; असली ईश्वर तो वह नारायण है जो सबका 'मालिक' है।
        """.trimIndent(),
        english = """
            (The knowledge of the Antaryami continues): That Supreme Lord who flawlessly resides (Tishthan) precisely inside that 'Akshara' (the imperishable individual Soul), yet who is completely distinct from and flawlessly entirely inside (Antarah) that Soul.
            That exact God whom the individual soul herself absolutely does not know or perceive (Na veda), and that soul itself is merely just a subtle 'Body' (Shariram) of His.
            He who, sitting absolutely perfectly inside that exact soul, ruthlessly and flawlessly controls and operates it entirely (Yamayati).
            That one single Supreme Lord is the direct, living 'Inner Soul' (Antaratma) of absolutely all beings; He is completely totally free from absolutely all sins (Apahatapapma), exceptionally divine, and the One and only (Eko) Lord 'Narayana'.
            In the absolute previous verse, God was powerfully declared the ultimate Controller of the Earth (Matter); but this magnificent verse is 100 times deeper!
            We constantly read in Vedanta that "The Soul is absolutely everything" (Akshara). But this verse fiercely declares that God sits flawlessly exactly 'Inside' (Core of the core) even that very 'Soul'!
            This deeply arrogant Jiva (Individual soul) of ours is absolutely not God; this Jiva is merely a cheap 'Garment' (Body) actively worn by God Himself!
            The Jiva (we) foolishly spends its entire life arrogantly thinking, "I am acting entirely out of my own free will." But from deep inside, it is strictly Narayana flawlessly Controlling (Yamayati) this very Jiva.
            Our Soul (Akshara) absolutely fails to see (Na veda) that God strictly because that God is the absolute Soul of the soul (Antaratma) (How can the eye possibly see itself?).
            This phenomenal verse totally and ruthlessly crushes even the absolute final 'Ego' of a human who arrogantly thinks "I (the Jiva) am God"; the real, true God is exclusively that Narayana who is the absolute 'Master' of all.
        """.trimIndent()
    ),
    SubalaShloka(
        id = 9,
        sanskrit = "अथ खलु स एष प्रलयकाले... पृथिव्यप्सु प्रलीयते । आपस्तेजसि प्रलीयन्ते । तेजो वायौ प्रलीयते । वायुराकाशे प्रलीयते ॥ ९ ॥",
        hindi = """
            (अब ब्रह्मांडीय प्रलय / Cosmic Dissolution का वर्णन शुरू होता है): इसके बाद (अथ खलु), जब इस संपूर्ण संसार का भयंकर 'प्रलय-काल' (Time of absolute destruction) आता है।
            तब सबसे पहले यह अत्यंत ठोस 'पृथ्वी' (Earth / Matter) पूरी तरह से पिघल कर 'जल' (Water) तत्व में विलीन (प्रलीयते) हो जाती है।
            वह सारा 'जल' तत्व पूरी तरह सूख कर 'अग्नि' (तेज / Fire) तत्व में समाकर विलीन हो जाता है।
            वह भयंकर 'अग्नि' भी अंततः पूरी तरह शांत होकर 'वायु' (Air) तत्व में विलीन हो जाती है।
            और अंत में, वह 'वायु' तत्व भी उस असीम और खाली 'आकाश' (Space) तत्व में जाकर पूरी तरह से गायब (प्रलीयते) हो जाता है।
            यह श्लोक सृष्टि के खत्म होने (Reverse Big Bang / Big Crunch) का बिल्कुल सटीक और वैज्ञानिक (Scientific) नक्शा (Map) है।
            विज्ञान कहता है कि जब दुनिया खत्म होगी, तो सारे ठोस ग्रह (Solid planets / पृथ्वी) पिघल कर लिक्विड या गैस (जल) बन जाएंगे।
            फिर वो गैस भयंकर रूप से जलकर केवल एक शुद्ध 'एनर्जी और हीट' (तेज / अग्नि) में बदल जाएगी।
            वह आग भी जब ठंडी होगी, तो केवल एक भयंकर 'तूफान या रेडिएशन' (वायु) बचेगा; और अंत में वह रेडिएशन भी उस खाली और असीम 'स्पेस' (आकाश) में पूरी तरह से खो जाएगा।
            योगी इस 'महा-प्रलय' का इंतज़ार नहीं करता; वह ध्यान में अपनी आँखें बंद करके 'अपने ही शरीर' (पृथ्वी) को इसी तरह स्टेप-बाय-स्टेप (Step-by-step) आकाश में विलीन कर देता है (इसे लय योग कहते हैं)।
        """.trimIndent(),
        english = """
            (Now the profound description of Cosmic Dissolution begins): Thereafter (Atha khalu), exactly when the terrifying 'Pralaya-Kala' (Time of absolute cosmic destruction) of this entire vast world finally arrives.
            Then, absolute first, this exceptionally solid 'Earth' (Matter / Prithvi) melts completely and dissolves perfectly (Praliyate) entirely into the 'Water' (Apsu) element.
            All that massive 'Water' element completely dries up and flawlessly merges and dissolves entirely into the blazing 'Fire' (Tejas) element.
            That terrifying, blazing 'Fire' also ultimately calms down completely and flawlessly dissolves entirely into the 'Air' (Vayu) element.
            And ultimately, that subtle 'Air' element also flawlessly vanishes and dissolves entirely (Praliyate) directly into that infinite, empty 'Space' (Akasha) element.
            This magnificent verse provides an absolutely exact, highly Scientific, and flawless Map of the end of creation (Reverse Big Bang / The Big Crunch).
            Modern Science explicitly states that when the world ends, all solid planets (Earth) will violently melt into liquid or gas (Water).
            Then that gas will violently ignite and burn, flawlessly transforming into absolutely pure 'Energy and Heat' (Fire).
            When even that intense fire completely cools, exclusively a terrifying 'Cosmic storm or Radiation' (Air) will safely remain; and ultimately, even that radiation will become completely lost in the empty, infinite 'Space' (Akasha).
            A master Yogi absolutely does not wait for this physical 'Maha-Pralaya'; he closes his eyes in deep meditation and flawlessly dissolves 'his very own physical body' (Earth) step-by-step completely into Space (This is profoundly called Laya Yoga).
        """.trimIndent()
    ),
    SubalaShloka(
        id = 10,
        sanskrit = "आकाशमिन्द्रियेषु । इन्द्रियाणि तन्मात्रासु । तन्मात्राणि भूतादौ । भूतादिर्महति । महानव्यक्ते । अव्यक्तमक्षरे । अक्षरं तमसि । तमः परे देव एकीभवति ॥ १० ॥",
        hindi = """
            (प्रलय की अंतिम और सबसे गहरी अवस्था): वह असीम 'आकाश' (Space) भी हमारी 'इंद्रियों' (Senses) में विलीन हो जाता है।
            इंद्रियां 'तन्मात्राओं' (5 Frequencies) में, और तन्मात्राएं 'भूतादि' (अहंकार / Ego) में विलीन हो जाती हैं।
            वह 'अहंकार' ब्रह्मांडीय बुद्धि 'महत्तत्त्व' (Mahat) में, और महत्तत्त्व मूल 'अव्यक्त' (प्रकृति/माया) में लीन हो जाता है।
            वह 'अव्यक्त' प्रकृति 'अक्षर' (अविनाशी जीवात्मा) में, और वह 'अक्षर' उस परम 'तमस' (Dark Energy / मूल अंधकार) में लीन हो जाता है।
            और सबसे अंत में, वह भयंकर 'तमस' (अंधकार) उस परम श्रेष्ठ, एकमात्र (एको) दिव्य देव (परमात्मा / नारायण) में मिलकर पूरी तरह से एक (एकीभवति) हो जाता है (वहाँ कुछ भी बाकी नहीं बचता)।
            यह श्लोक वेदान्त के 'लय योग' का सबसे बड़ा और सबसे गहरा सुपर-सीक्रेट (Super-secret) है।
            यहाँ आकर स्पेस (Space/आकाश) भी खत्म हो जाता है! स्पेस कहाँ खत्म होता है? इंसान के दिमाग (अहंकार) में! क्योंकि जब इंसान ही नहीं तो 'जगह' (Space) का अहसास किसे होगा?
            अहंकार भी जब पिघलता है, तो वह सीधा ब्रह्मांड की प्रकृति (माया) में सो जाता है।
            पर उपनिषद कहता है कि यात्रा प्रकृति पर भी नहीं रुकती; वह माया भी आत्मा (अक्षर) में विलीन होती है।
            और अंत में वह आत्मा (अक्षर) उस 'परम तमस' (वह अंधेरा जहाँ से सृष्टि शुरू हुई थी, श्लोक 1) को पार करते हुए सीधे साक्षात् नारायण में घुलकर 100% गायब (एकीभवति) हो जाती है।
            यहाँ 'द एंड' (The End) है; इसके आगे न कोई विज्ञान है, न कोई शब्द है, और न ही कोई दुनिया; बस केवल एक भगवान है।
        """.trimIndent(),
        english = """
            (The absolute final and deepest stage of Dissolution): That boundless, infinite 'Space' (Akasha) also flawlessly dissolves completely into our physical 'Senses' (Indriyeshu).
            The senses dissolve completely into the 'Tanmatras' (5 Frequencies), and the Tanmatras flawlessly dissolve directly into 'Bhutadi' (Ego / Ahankara).
            That 'Ego' seamlessly melts perfectly into the Cosmic Intellect 'Mahat-tattva', and the Mahat flawlessly dissolves entirely into the root 'Avyakta' (Unmanifested Prakriti/Maya).
            That 'Avyakta' Prakriti perfectly dissolves into the 'Akshara' (Imperishable Soul), and that 'Akshara' perfectly dissolves strictly into that supreme 'Tamas' (Primordial Dark Energy).
            And at the absolute very end, that terrifying 'Tamas' (Darkness) seamlessly merges and becomes completely, flawlessly One (Ekibhavati) exclusively with that Supreme, absolute only (Eko) Divine Lord (Narayana) (absolutely nothing remains left over there).
            This phenomenal verse is the absolute greatest and deepest Super-Secret of Vedanta's 'Laya Yoga'.
            Upon reaching here, even Space (Akasha) itself is completely destroyed! Where exactly does Space end? Strictly inside the human brain (Ego)! Because if the human doesn't exist, who exactly will feel 'Space'?
            When even the ego violently melts, it drops fast asleep straight into the cosmos's Prakriti (Maya).
            But the Upanishad fiercely declares the journey absolutely does not stop even at Prakriti; that Maya also flawlessly dissolves into the Soul (Akshara).
            And ultimately, that Soul violently pierces that 'Supreme Tamas' (the exact primordial darkness from which creation began, Verse 1) and flawlessly melts 100% into Narayana (Ekibhavati).
            This is exactly 'The End'; beyond this point, there is absolutely no science, zero words, and no world whatsoever; there is strictly exclusively only one God.
        """.trimIndent()
    ),
    SubalaShloka(
        id = 11,
        sanskrit = "अस्थूलमनण्वह्रस्वमदीर्घमलोहितमस्नेहमच्छायमतमोऽवाय्वनाकाशमसङ्गमस्पर्शमगन्धमरसमचक्षुष्कमश्रोत्रमवागमनोऽतेजस्कमप्राणममुखममात्रमन्तरं बाह्यं न तदश्नाति किञ्चन न तदश्नाति कश्चन ॥ ११ ॥",
        hindi = """
            (बृहदारण्यक उपनिषद 3.8.8 का साक्षात् प्रमाण / परब्रह्म का असली स्वरूप): वह परब्रह्म न तो स्थूल (मोटा/बड़ा) है और न ही वह अणु (पतला/छोटा) है। वह न तो ह्रस्व (नाटा) है और न ही दीर्घ (लंबा) है।
            वह न तो लाल रंग (लोहित) का है, न उसमें कोई तरल (स्नेह/पानी) है; उसकी कोई परछाईं (छाया) नहीं है, और वह अंधकार (तमस) भी नहीं है।
            वह न तो वायु (हवा) है, न आकाश (Space) है; वह किसी से चिपका (असंग) नहीं है, और उसे छुआ (अस्पर्श) भी नहीं जा सकता।
            उसका कोई गंध (Smell) या रस (Taste) नहीं है; उसकी कोई आँख (चक्षु), कान (श्रोत्र), वाणी (वाक्) या मन (मनो) भी बिल्कुल नहीं है।
            वह बिना आग (तेज), बिना श्वास (प्राण), बिना मुँह (मुख) और बिना किसी माप (मात्रा) के है; उसका कोई अंदर (अंतर) या बाहर (बाह्य) नहीं है।
            वह परमात्मा किसी भी चीज़ को नहीं खाता (अश्नाति), और दुनिया की कोई भी चीज़ उस परमात्मा को कभी नहीं खा सकती (नष्ट नहीं कर सकती)।
            यह श्लोक वेदान्त की 'नेति-नेति' (यह नहीं, यह नहीं) प्रक्रिया का सबसे बड़ा और सबसे खूंखार (Fiercest) डिक्लेरेशन (Declaration) है।
            इंसान भगवान को एक आकार (मोटा, लंबा, आँखों वाला) देने की कोशिश करता है; पर उपनिषद हर एक फिजिकल क्वालिटी (Physical quality) को एक-एक करके काट कर फेंक देता है।
            भगवान कोई 'चीज़' या 'इंसान' है ही नहीं! वह तो बस एक असीम, निराकार 'अस्तित्व' (Existence) है जो हमारे सारे लॉजिक (Logic) को फ़ेल कर देता है।
            उसे कोई दुनियावी चीज़ नष्ट (खा) नहीं सकती; वही एकमात्र सत्य है जो हमेशा से था, है और रहेगा।
        """.trimIndent(),
        english = """
            (Direct proof from Brihadaranyaka Upanishad 3.8.8 / The exact true nature of Supreme Brahman): That Supreme Brahman is absolutely neither gross (Asthulam/large) nor is He atomic (Anu/microscopic). He is absolutely neither short (Hrasvam) nor is He long (Dirgham).
            He is absolutely not red-colored (Lohitam), nor does He contain any fluidity (Sneha/moisture); He possesses absolutely zero shadow (Chayam), and He is definitely not darkness (Tamas) either.
            He is absolutely neither Air (Vayu) nor Space (Akasha); He is completely unattached (Asangam) to anything, and He is absolutely untouchable (Asparsham).
            He possesses absolutely zero Smell (Gandha) or Taste (Rasam); He absolutely has no physical eyes (Chakshu), no ears (Shrotram), no speech (Vak), and strictly no mind (Mano) whatsoever.
            He is completely without fire (Tejas), without breath (Pranam), without a mouth (Mukham), and entirely without any measurement (Matram); He possesses absolutely no inside (Antaram) or outside (Bahyam).
            That Supreme Lord absolutely never eats (Ashnati) anything whatsoever, and absolutely no object in the entire universe can ever possibly eat (destroy) Him.
            This spectacular verse is the absolute greatest and fiercest Declaration of Vedanta's extreme 'Neti-Neti' (Not this, Not this) philosophical process.
            Humans desperately attempt to forcefully assign a physical shape (fat, tall, having eyes) to God; but the Upanishad ruthlessly slices off and throws away absolutely every single Physical Quality one by one.
            God is absolutely not a 'Thing' or a 'Human' at all! He is simply a boundless, formless absolute 'Existence' that completely and utterly Fails all our human Logic.
            Absolutely no worldly object can ever possibly destroy (eat) Him; He is the one and only absolute Truth that always was, is, and will forever be.
        """.trimIndent()
    ),
    SubalaShloka(
        id = 12,
        sanskrit = "चक्षुश्च द्रष्टव्यं च नारायणः ... य इदं सुबालोपनिषदं वेदीते स सर्वपापैः प्रमुच्यते ॥ १२ ॥",
        hindi = """
            (नारायण ही सब कुछ है और फलश्रुति): (उपनिषद फिर से दोहराता है कि) यह देखने वाली 'आँख' भी साक्षात् नारायण है, और जो दृश्य 'देखा जा रहा है', वह भी नारायण ही है।
            (अर्थात संसार का हर एक कण, हर एक क्रिया और हर एक विचार केवल उसी एक भगवान का ही रूप है)।
            जो कोई भी मुमुक्षु (मोक्ष चाहने वाला) इस अत्यंत पवित्र और रहस्यमयी 'सुबाल उपनिषद' (सुबालोपनिषदं) के इस परम ज्ञान को भलीभांति जान (वेदीते) लेता है।
            वह मनुष्य अपने जन्म-जन्मांतरों के 'सभी प्रकार के भयंकर पापों' से हमेशा के लिए पूरी तरह मुक्त (सर्वपापैः प्रमुच्यते) हो जाता है।
            यह श्लोक अद्वैत ज्ञान की सबसे बड़ी 'गारंटी' (Guarantee) देता है।
            पाप (Sin) तब होता है जब इंसान अज्ञान में फँसकर दूसरों को नुकसान पहुँचाता है; पर जब उसे हर चीज़ में 'नारायण' ही दिखने लगा, तो पाप कहाँ से आएगा?
            पाप अज्ञान के अंधेरे में पैदा होने वाला कीड़ा है; सुबाल उपनिषद का ज्ञान वह सूर्य है जो इस कीड़े को एक सेकंड में भस्म कर देता है।
            इसे 'जानने' (वेदीते) का मतलब केवल किताब पढ़ना नहीं है; इसका मतलब है प्रलय (लय) की उस प्रक्रिया को अपने ही ध्यान में उतार कर उस 'परम तमस' को पार करना।
            जब इंसान को यह समझ आ जाता है कि "मैं वो शरीर नहीं जो पैदा हुआ था, मैं तो वो नारायण हूँ जो प्रलय के बाद भी बचेगा।"
            तो मौत का डर हमेशा के लिए खत्म हो जाता है और वही असली आज़ादी (मुक्ति) है।
        """.trimIndent(),
        english = """
            (Narayana is absolutely everything and the Phala Shruti): (The Upanishad powerfully reiterates that) This physical seeing 'Eye' itself is directly Narayana, and absolutely whatever specific scene is 'being actively seen' is also strictly Narayana alone.
            (Meaning, absolutely every single microscopic atom, every single action, and every single thought in the world is exclusively the exact manifestation of that one God alone).
            Whosoever sincere seeker (intensely desiring Moksha) thoroughly knows and profoundly understands (Vedite) this supreme wisdom of this highly sacred and deeply mystical 'Subala Upanishad' (Subalopanishadam).
            That specific human being becomes completely and permanently liberated (Sarvapapaih pramuchyate) from absolutely 'all types of terrifying sins' accumulated over millions of past lifetimes forever.
            This phenomenal verse explicitly delivers the absolute greatest 'Guarantee' of Advaita wisdom.
            Sin brutally occurs exclusively when a human, trapped helplessly in thick ignorance, ruthlessly harms others; but when he clearly begins seeing 'Narayana' in absolutely everything, from where will sin possibly arise?
            Sin is merely a filthy worm breeding strictly in the dark of ignorance; the supreme wisdom of the Subala Upanishad is the blazing sun that burns this worm to ashes in a single second.
            'Knowing' (Vedite) this absolutely does not mean merely reading a cheap book; it profoundly means actively downloading that strict process of cosmic dissolution (Laya) directly into your own meditation and flawlessly crossing that 'Supreme Tamas'.
            When a human perfectly understands that "I am absolutely not this physical body that was born, I am exactly that Narayana who will permanently survive even after the ultimate cosmic dissolution."
            Then the terrifying fear of death is permanently annihilated forever, and that alone is true, absolute freedom (Liberation).
        """.trimIndent()
    ),
    SubalaShloka(
        id = 13,
        sanskrit = "अन्नमयं हि सोम्य मनः आपोमयः प्राणस्तेजोमयी वागिति । तस्मादन्नं न निन्द्यात् तद्व्रतम् ॥ १३ ॥",
        hindi = """
            (भोजन और प्राण का विज्ञान / छान्दोग्य उपनिषद 6.5.4): महर्षि कहते हैं: "हे सौम्य (प्रिय शिष्य)! यह मनुष्य का 'मन' (Mind) मुख्य रूप से 'अन्न' (Food / भोजन) से ही बना हुआ (अन्नमयं) है।"
            "यह जो हमारे भीतर का 'प्राण' (Vital energy) है, वह पूरी तरह से 'जल' (Water / आपोमयः) से बना हुआ है; और हमारी जो 'वाणी' (Speech/आवाज़) है, वह 'अग्नि' (तेज/Heat) से बनी हुई (तेजोमयी) है।"
            "चूँकि हमारे जीवन का सबसे बड़ा आधार (मन) इसी अन्न पर टिका है, इसलिए (तस्मात्) मनुष्य को कभी भी अन्न (भोजन) की 'निंदा' (अपमान / न निन्द्यात्) बिल्कुल नहीं करनी चाहिए।"
            "अन्न का कभी अपमान न करना—यही एक सच्चे साधक का सबसे बड़ा 'व्रत' (Vow/नियम) होना चाहिए।"
            यह श्लोक प्राचीन भारतीय 'डाइटेटिक्स' (Dietetics) और अध्यात्म का सबसे गहरा 'माइंड-बॉडी कनेक्शन' (Mind-Body Connection) बताता है।
            हम जो भी खाना खाते हैं, उसका सबसे सूक्ष्म हिस्सा (Subtlest part) जाकर सीधा हमारा 'दिमाग' (Mind) और हमारे 'विचार' बनाता है (जैसा खाए अन्न, वैसा होए मन)।
            अगर हम गंदा या हिंसक (मांस/शराब) खाना खाते हैं, तो हमारे विचार भी गंदे और क्रूर हो जाते हैं, जिससे ध्यान (Meditation) कभी नहीं लग सकता।
            पानी कम पीने से प्राण (Energy) सूख जाते हैं, और अग्नि तत्व के बिना इंसान बोल (Speech) नहीं सकता।
            खाने की थाली को देखकर मुँह सिकोड़ना या उसे कूड़े में फेंकना (निंदा करना) प्रकृति का सबसे बड़ा अपमान है, क्योंकि उसी खाने से हमारा 'सॉफ्टवेयर' (मन) चल रहा है।
            एक योगी हमेशा खाने को भगवान का प्रसाद मानकर, पूरी इज़्ज़त के साथ ही उसे ग्रहण करता है।
        """.trimIndent(),
        english = """
            (The profound science of Food and Prana / Chandogya Upanishad 6.5.4): The great Sage declares: "O gentle disciple (Somya)! This human 'Mind' (Manas) is fundamentally and strictly manufactured entirely from 'Food' (Annamayam)."
            "This vital 'Prana' (life-energy) actively flowing within us is completely made entirely of 'Water' (Apomayah); and our very 'Speech' (Vak/voice) is flawlessly constructed purely of 'Fire' (Tejomayi/heat)."
            "Strictly because the absolute greatest foundation of our entire life (the mind) rests entirely upon this very food, therefore (Tasmat), a human must absolutely never, ever 'Condemn' or insult (Na nindyat) food (Anna) in any way."
            "Absolutely never insulting or disrespecting food—this alone must be the absolute greatest, unbreakable 'Vow' (Vratam / strict rule) of a true, sincere seeker."
            This spectacular verse profoundly reveals ancient Indian 'Dietetics' and the absolute deepest, most flawless 'Mind-Body Connection' in spirituality.
            Absolutely whatever specific food we eat, its incredibly subtlest part (essence) goes straight up and flawlessly manufactures our 'Brain' (Mind) and our exact 'Thoughts' (You are exactly what you eat).
            If we aggressively consume dirty or violently cruel food (meat/alcohol), our thoughts instantly become terribly filthy and cruel, making deep meditation (Dhyana) absolutely impossible forever.
            Drinking insufficient water aggressively dries up the vital Prana (Energy), and completely without the Fire element, a human simply cannot produce Speech.
            Wrinkling one's nose in disgust looking at a plate of food or ruthlessly throwing it into the garbage (Condemning it) is Nature's absolute greatest insult, purely because our entire 'Software' (Mind) is actively running strictly on that exact food.
            A true master Yogi absolutely always treats his food strictly as God's sacred Prasada and consumes it exclusively with absolute, flawless respect.
        """.trimIndent()
    ),
    SubalaShloka(
        id = 14,
        sanskrit = "तदन्तर्गतं ज्योतिरमृतं ब्रह्म । यस्मिन्निदं सर्वं प्रोतं पट इव तन्तुषु ॥ १४ ॥",
        hindi = """
            उस मनुष्य के हृदय और सभी तत्वों के बिल्कुल भीतर (तदन्तर्गतं) वह परम 'ज्योति' (Supreme Light) स्थित है, जो साक्षात् 'अमृत' (अविनाशी) और परम 'ब्रह्म' (ईश्वर) है।
            जिस प्रकार एक कपड़े (पट) के भीतर उसके सारे धागे (तन्तुषु) एक-दूसरे में पूरी तरह से गुंथे (प्रोतं) हुए और बुने हुए होते हैं (धागों के बिना कपड़े का कोई वजूद नहीं)।
            ठीक उसी प्रकार (इव), यह पूरा का पूरा दिखाई देने वाला ब्रह्मांड (सर्वं) उसी एक परम ज्योति (ब्रह्म) के भीतर पूरी तरह से गुंथा हुआ और उसी पर टिका हुआ (प्रोतं) है।
            यह श्लोक ईश्वर की सर्वव्यापकता (Omnipresence) को समझाने के लिए वेदान्त का एक बहुत ही शानदार और आसान 'टेक्सटाइल' (Textile) का उदाहरण (Metaphor) देता है।
            जब हम एक शर्ट (Shirt) को देखते हैं, तो हमें लगता है कि शर्ट एक 'ठोस' चीज़ है; पर अगर हम ध्यान से देखें, तो वह शर्ट कुछ नहीं है, केवल 'धागों' का एक ताना-बाना है।
            अगर धागों को निकाल लिया जाए, तो शर्ट का कोई वजूद ही नहीं बचेगा!
            उसी तरह, हम इस दुनिया को एक ठोस और पक्की चीज़ मानते हैं; पर उपनिषद कहता है कि दुनिया नाम की कोई चीज़ है ही नहीं, यह केवल भगवान (ज्योति) के धागों से बुना हुआ एक कपड़ा है।
            भगवान इस दुनिया के 'अंदर' नहीं बैठा है, बल्कि भगवान ही वह 'धागा' (Material) है जिससे यह पूरी दुनिया बनी है!
            जब योगी ध्यान की गहराई में उतरता है, तो उसे दुनिया का कपड़ा नहीं दिखता, उसे केवल वह चमकता हुआ 'अमर धागा' (ज्योति / ब्रह्म) दिखाई देता है।
            यही वह अंतिम दर्शन (Ultimate Vision) है जो इंसान के मन से दुनिया की सारी अहमियत (Value) को खत्म करके केवल ईश्वर में फिक्स (Fix) कर देता है।
        """.trimIndent(),
        english = """
            Exactly and deeply hidden directly inside (Tadantargatam) that human's heart and all elements is flawlessly situated that Supreme 'Light' (Jyoti), which is the direct, living 'Amrita' (Immortal) and the Supreme 'Brahman' (God).
            Just exactly as inside a piece of solid cloth (Pata), absolutely all its individual threads (Tantushu) are flawlessly, tightly interwoven and woven together (Protam) (completely without the threads, the cloth has absolutely zero existence).
            In the precise same flawless manner (Iva), this entire, massive visible cosmos (Sarvam) is completely, tightly interwoven and perfectly suspended (Protam) strictly and entirely within that one single Supreme Light (Brahman).
            This magnificent verse provides an exceptionally brilliant and easily comprehensible 'Textile' Metaphor from Vedanta to flawlessly explain God's absolute Omnipresence.
            When we casually look at a physical Shirt, we falsely assume the shirt is a solid 'Thing'; but if we observe closely, the shirt is absolutely nothing but a complex, tight weave of mere 'Threads'.
            If the threads are aggressively pulled out, the physical existence of the shirt will be permanently annihilated!
            Similarly, we stubbornly consider this massive world to be a highly solid, permanent thing; but the Upanishad fiercely declares that there is absolutely no such thing as the world, it is merely a cloth woven entirely of God's (Jyoti's) threads.
            God is absolutely not sitting securely 'Inside' this world, rather God Himself is the exact raw 'Thread' (Material) from which this entire colossal world is perfectly manufactured!
            When the master Yogi descends exceptionally deep into meditation, he absolutely does not see the cheap cloth of the world, he clearly sees exclusively that brilliantly shining 'Immortal Thread' (Jyoti / Brahman).
            This is exactly that absolute Ultimate Vision which flawlessly destroys all the fake Value of the world from the human mind and Fixes it permanently and strictly upon God alone.
        """.trimIndent()
    ),
    SubalaShloka(
        id = 15,
        sanskrit = "ज्ञानाग्निर्दहति कर्माणि तूलाग्निवत् । नास्त्यपुनरावृत्तिस्तस्य यो ब्रह्म वेद ॥ १५ ॥",
        hindi = """
            जिस प्रकार भयंकर आग (अग्नि) रूई के एक बहुत बड़े पहाड़ (तूलाग्निवत् / Cotton) को भी पलक झपकते ही जलाकर पूरी तरह राख कर देती है।
            ठीक उसी प्रकार, आत्म-साक्षात्कार रूपी 'ज्ञान की अग्नि' (ज्ञानाग्निः) इंसान के करोड़ों जन्मों के संचित 'सभी कर्मों' (पाप और पुण्य दोनों / कर्माणि) को एक सेकंड में पूरी तरह जलाकर भस्म कर (दहति) देती है।
            और जो कोई भी ज्ञानी पुरुष उस साक्षात् 'परम ब्रह्म' को यथार्थ रूप में 'जान' (वेद) लेता है।
            उस ज्ञानी महापुरुष का इस दुख भरे संसार में फिर कभी भी 'पुनरावृत्ति' (लौटना / दोबारा जन्म लेना / Rebirth) बिल्कुल भी नहीं होता (नास्त्यपुनरावृत्तिः)।
            यह श्लोक 'कर्म के कानून' (Law of Karma) को हैक (Hack) करने का सबसे बड़ा और इकलौता सीक्रेट (Secret) है।
            इंसान सोचता है कि "मैंने इतने पाप किए हैं, मुझे तो 100 जन्म नर्क में सड़ना पड़ेगा।"
            पर उपनिषद दिलासा देता है: तुम्हारे पाप चाहे रूई के पहाड़ जितने बड़े और डरावने हों, रूई की अपनी कोई औकात नहीं होती; आग की एक छोटी सी चिंगारी उस पूरे पहाड़ को 1 सेकंड में राख कर सकती है!
            'मैं शरीर नहीं, मैं ब्रह्म हूँ'—यह समझ (ज्ञान) ही वह भयंकर चिंगारी (ज्ञानाग्नि) है जो कर्मों के सारे बैंक-अकाउंट (Bank account) को परमानेंट डिलीट (Permanently delete) कर देती है।
            जब कर्म (Account) ही नहीं बचे, तो इंसान दोबारा जन्म लेकर धरती पर किस चीज़ का कर्ज़ा चुकाने आएगा?
            इसलिए ज्ञान के उदय होते ही, जन्म और मरण की यह भयंकर मशीन हमेशा के लिए रुक जाती है और इंसान साक्षात् भगवान हो जाता है।
        """.trimIndent(),
        english = """
            Just exactly as a terrifying, blazing fire (Agni) flawlessly and instantly burns even a colossal, massive mountain of raw cotton (Tulagnivat) completely to ashes in a mere blink of an eye.
            In the precise same flawless manner, the intense 'Fire of Wisdom' (Jnanagnih / Self-realization) completely and violently burns to absolute ashes (Dahati) 'Absolutely All Karmas' (both horrific sins and high merits / Karmani) accumulated over millions of past lifetimes in a single second.
            And whosoever magnificent, enlightened sage genuinely and flawlessly 'Knows' and directly realizes (Veda) that Supreme 'Brahman' in absolute reality.
            For that colossal, great sage, there is absolutely no 'Punaravritti' (Return / Rebirth) whatsoever back into this miserable, sorrowful world ever again (Nastyapunaravrittih).
            This phenomenal verse explicitly reveals the absolute greatest and solitary Secret to perfectly Hack the terrifying, unbreakable 'Law of Karma'.
            A human being helplessly thinks, "I have committed so many horrific sins, I will definitely have to rot in hell for 100 consecutive lifetimes."
            But the Upanishad provides supreme comfort: no matter if your dark sins are as massive and terrifying as a mountain of cotton, cotton has absolutely zero real strength; one tiny spark of fire can burn that entire mountain to ashes in exactly 1 second!
            'I am absolutely not the body, I am Brahman'—this profound understanding (Wisdom) is exactly that terrifying spark (Jnanagni) that Permanently Deletes the entire massive Bank Account of all karmas forever.
            When absolutely zero Karma (Account) remains left, exactly what heavy debt would the human return to pay by taking rebirth on earth?
            Therefore, the exact split-second absolute Wisdom dawns, this terrifying, brutal machine of birth and death stops completely forever, and the human literally becomes God Himself.
        """.trimIndent()
    ),
    SubalaShloka(
        id = 16,
        sanskrit = "य इदं सुबालोपनिषदं वेदीते स ब्रह्मलोकमवाप्नोति स ब्रह्मलोकमवाप्नोति । इत्युपनिषत् । ॐ शान्तिः शान्तिः शान्तिः ॥ १६ ॥",
        hindi = """
            (उपनिषद की परम फलश्रुति और अंतिम समापन): जो भी मुमुक्षु (मोक्ष की तीव्र इच्छा रखने वाला) साधक इस महान 'सुबाल उपनिषद' के इस परम रहस्य को भलीभांति जान और समझ (वेदीते) लेता है।
            वह मनुष्य अपने शरीर को छोड़ने के बाद निश्चित रूप से उस परम प्रकाशमय 'ब्रह्मलोक' (परब्रह्म के सर्वोच्च पद) को हमेशा के लिए प्राप्त (अवाप्नोति) कर लेता है।
            (निश्चितता और गारंटी दर्शाने के लिए श्रुति इसे दोबारा दोहराती है): "हाँ, वह निश्चित रूप से ब्रह्मलोक को ही प्राप्त करता है!" (स ब्रह्मलोकमवाप्नोति)।
            यहीं पर यह अत्यंत पवित्र और महान 'सुबाल उपनिषद' पूर्ण रूप से संपन्न (इत्युपनिषत्) होता है।
            ॐ शांतिः शांतिः शांतिः! (हमारे शरीर, मन और असीम आत्मा में उस नारायण की परम और अखंड शांति हमेशा के लिए स्थापित हो)।
            यहाँ 'ब्रह्मलोक' का मतलब आसमान में तैरता हुआ कोई महलों वाला शहर (City) नहीं है; ब्रह्मलोक का असली मतलब है 'ब्रह्म की अवस्था' (The State of Supreme Consciousness)।
            यह अवस्था वह है जहाँ न कोई डर है, न कोई वासना है, और न ही कोई दूसरा (Duality) है; इंसान खुद ही भगवान (नारायण) की गद्दी पर बैठ जाता है।
            सुबाल उपनिषद ने हमें जीरो (Tamas / बिग बैंग से पहले) से लेकर हमारे शरीर के बनने (अंडा), और फिर ध्यान के द्वारा उस शरीर को वापस जीरो (लय) में पिघलाने का पूरा मास्टर-प्लान (Master-plan) दे दिया है।
            जो इस साइंस (Science) को केवल पढ़ता नहीं, बल्कि ध्यान में 'जीता' (वेदीते) है, उसे दुनिया की कोई भी ताकत मोक्ष पाने से नहीं रोक सकती।
            यह सनातन धर्म का वह सबसे शक्तिशाली ब्रह्मांडीय विज्ञान है जो इंसान को धरती के कीचड़ से उठाकर सीधे अनंत आसमान का राजा बना देता है।
        """.trimIndent(),
        english = """
            (The supreme Phala Shruti and absolute final Conclusion of the Upanishad): Whosoever sincere seeker (intensely desiring Moksha) thoroughly knows and profoundly understands (Vedite) the supreme secret of this magnificent 'Subala Upanishad' (Subalopanishadam).
            That specific human being, immediately after shedding his physical body, undoubtedly and flawlessly permanently attains (Avapnoti) that absolute supreme, brilliantly radiant 'Brahmaloka' (the highest state of the Supreme Lord).
            (Strictly to demonstrate absolute certainty and a foolproof Ironclad Guarantee, the Shruti violently repeats it twice): "Yes, he undoubtedly and certainly attains Brahmaloka!" (Sa Brahmalokamavapnoti).
            Right exactly here, this exceptionally highly mystical, sacred, and magnificent 'Subala Upanishad' perfectly and auspiciously achieves absolute completion (Ityupanishat).
            OM Peace, Peace, Peace! (May the supreme, infinite, and unbroken peace of that Narayana be permanently established within our physical body, restless mind, and immortal soul forever).
            Here, 'Brahmaloka' absolutely does not mean a cheap physical city with golden palaces floating in the sky; the absolute real meaning of Brahmaloka is 'The State of Supreme Consciousness'.
            This is exactly that supreme state where there is absolutely no fear, absolutely zero lust, and absolutely no 'Other' (Duality); the human himself sits flawlessly on the absolute throne of God (Narayana).
            The Subala Upanishad has profoundly handed us the complete, flawless Master-Plan ranging entirely from Zero (Tamas / before the Big Bang) to the exact creation of our body (Egg), and then ruthlessly melting that body completely back into Zero (Laya) strictly through deep meditation.
            He who absolutely does not merely read this magnificent Science, but actively 'Lives' (Vedite) it deeply in meditation, absolutely no power in the entire world can ever stop him from attaining Moksha.
            This is undeniably Sanatana Dharma's absolute most terrifyingly powerful Cosmic Science that violently pulls a human out of the earth's filthy mud and instantly crowns him the undisputed King of the infinite sky.
        """.trimIndent()
    )
)