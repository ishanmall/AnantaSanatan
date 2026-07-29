package com.sanatangyansagar.ui.screens.DurgaSaptshati

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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdhyayaNineScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8E1))
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                val targetId = query.toIntOrNull()
                if (targetId != null) {
                    val targetIndex = adhyayaNineShlokas.indexOfFirst { it.id == targetId }
                    if (targetIndex != -1) {
                        coroutineScope.launch {
                            listState.animateScrollToItem(targetIndex)
                        }
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka (1-20)") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
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
            itemsIndexed(adhyayaNineShlokas) { _, shloka ->
                SaptshatiCard(shloka = shloka)
            }
        }
    }
}

// Top-Level Data List - Adhyaya 9 (Shlokas 1 to 20)
val adhyayaNineShlokas = listOf(
    SaptshatiShloka(
        id = 1,
        sanskrit = "राजोवाच ॥ १ ॥\nविचित्रमिदमाख्यातं भगवन् भवता मम ।\nदेवीमाहात्म्यमीशान रक्तबीजविनाशनम् ॥ २ ॥",
        hindi = """
            (राजा सुरथ का प्रश्न): "राजा सुरथ ने कहा: हे भगवन! आपने मुझे देवी के माहात्म्य की यह अत्यंत विचित्र कथा सुनाई है।"
            "विशेष रूप से रक्तबीज के वध का यह वृत्तांत सुनकर मेरा मन विस्मय और कौतूहल से भर गया है।"
            "राजा यहाँ एक जिज्ञासु शिष्य का प्रतीक है जो अज्ञान के विनाश की प्रक्रिया को समझना चाहता है।"
            "रक्तबीज (विचारों का लूप) का मरना इंसान के लिए सबसे कठिन मानसिक विजय मानी जाती है।"
            "विचित्र (Strange) शब्द यह बताता है कि सत्य के काम करने का तरीका हमारी बुद्धि से परे है।"
            "राजा अब आगे की कथा सुनने के लिए पूरी तरह से मानसिक रूप से तैयार हो चुके हैं।"
            "जब हम सत्य को सुनते हैं, तो हमारे अंदर की 'पुरानी कोडिंग' धीरे-धीरे टूटने लगती है।"
            "यह श्लोक गुरु और शिष्य के बीच के उस गहरे संवाद को दर्शाता है जहाँ ज्ञान का आदान-प्रदान होता है।"
            "सुरथ (भटकता हुआ मन) अब उस 'शांति' की ओर बढ़ रहा है जो शुम्भ-निशुम्भ के मरने के बाद मिलेगी।"
            "यहीं से उस महायुद्ध के अंतिम अध्याय की भूमिका तैयार होती है जो ममता (निशुम्भ) का अंत करेगी।"
        """.trimIndent(),
        english = """
            (King Suratha's Inquiry): "King Suratha said: O Lord! You have narrated this exceptionally strange and divine history of the Goddess."
            "Specifically, hearing the account of Raktabija's annihilation has filled my mind with absolute wonder and curiosity."
            "The King serves as the symbol of a dedicated seeker attempting to decode the process of destroying ignorance."
            "The death of Raktabija (The Loop of Thought) is considered the most difficult psychological victory for a human."
            "The word 'Strange' implies that the functioning of Absolute Truth is mathematically beyond human logic."
            "The King is now perfectly mentally prepared to absorb the subsequent chapters of this cosmic epic."
            "Whenever we actively listen to Truth, our internal 'Old Programming' begins to systematically dissolve."
            "This verse illustrates the profound dialogue between the Master and the Seeker where Wisdom flows."
            "Suratha (The Wandering Mind) is now moving toward that Peace which manifests after the death of Attachment."
            "Right here, the stage is set for the final battle that will permanently terminate the illusion of 'Mine'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 2,
        sanskrit = "भूयश्चेच्छाम्यहं श्रोतुं रक्तबीजे निपातिते ।\nचकार शुम्भो यत्कर्म निशुम्भश्चातिकोपनः ॥ ३ ॥",
        hindi = """
            (आगे सुनने की इच्छा): "राजा ने आगे कहा: 'रक्तबीज के मारे जाने पर, उस अत्यंत क्रोधी निशुम्भ और शुम्भ ने क्या किया?'"
            "'मैं उनके उस अगले कदम और कर्म को विस्तार से फिर से (भूयः) सुनने की इच्छा रखता हूँ'।"
            "अहंकार (शुम्भ) और ममता (निशुम्भ) जब अपने सबसे बड़े रक्षक को खो देते हैं, तो वे बौखला जाते हैं।"
            "राजा यह जानना चाहते हैं कि बुराई अपनी हार के बाद किस तरह रिएक्ट (React) करती है।"
            "अतिकोपन (Extremely angry) होना यह बताता है कि निशुम्भ अब अपना मानसिक संतुलन खो चुका था।"
            "जब हमारी 'ममता' (Attachment) पर चोट लगती है, तो हमें सबसे ज़्यादा दर्द और गुस्सा आता है।"
            "यह जिज्ञासा हमें यह सिखाती है कि अज्ञान की परतों को एक-एक करके ही समझा जा सकता है।"
            "साधना में जब एक बाधा (रक्तबीज) हटती है, तो अगली बाधा (निशुम्भ) और भी उग्र होकर सामने आती है।"
            "राजा का 'भूयः श्रोतुं' (फिर से सुनना) उनकी सत्य के प्रति गहरी तड़प और समर्पण को दर्शाता है।"
            "अब महर्षि मेधा उस भयंकर प्रतिशोध की कथा शुरू करेंगे जो असुरों ने देवी के विरुद्ध रचा था।"
        """.trimIndent(),
        english = """
            (Desire to Hear Further): "The King continued: 'After Raktabija was slaughtered, what did the exceptionally enraged Nishumbha and Shumbha do?'"
            "'I deeply desire to hear again (Bhuyah) about their subsequent actions and the karma they executed'."
            "When Arrogance (Shumbha) and Attachment (Nishumbha) lose their greatest defender, they enter a state of panic."
            "The King wishes to understand exactly how evil reacts psychologicaly after its primary defense is pulverized."
            "The term 'Atikopanah' (Extremely angry) proves that Nishumbha had completely lost his mental equilibrium."
            "When our 'Attachment' (Mine-ness) is directly attacked, it triggers the absolute highest level of internal rage."
            "This curiosity teaches us that the layers of ignorance can only be understood and removed systematically."
            "In spiritual practice, when one barrier (Raktabija) is removed, the next (Nishumbha) appears more fierce."
            "The King's request to 'Hear Again' demonstrates his intense thirst for Truth and his absolute surrender."
            "Now the Sage Medha will initiate the account of the terrifying revenge planned by the demons against the Divine."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 3,
        sanskrit = "ऋषिरुवाच ॥ ४ ॥\nचकार कोपमतुलं रक्तबीजे निपातिते ।\nनिशुम्भः शुम्भश्चैव तस्मिन् पातिते ॥ ५ ॥",
        hindi = """
            (असुरों का अतुलनीय क्रोध): "ऋषि मेधा ने कहा: रक्तबीज को इस प्रकार मरा हुआ देखकर, शुम्भ और निशुम्भ का क्रोध अतुलनीय हो गया।"
            "वे दोनों उस महा-असुर के पतन से इतने दुखी और क्रोधित थे कि उनके विवेक का सूरज पूरी तरह डूब गया।"
            "'अतुलं कोपम्' (Incomparable Anger) वह आग है जो इंसान को खुद ही जलाने के लिए काफी होती है।"
            "रक्तबीज उनके लिए केवल एक सैनिक नहीं, बल्कि उनकी 'अजेयता' (Invincibility) का सबसे बड़ा भ्रम था।"
            "जब हमारा सबसे गहरा भ्रम (Illusion) टूटता है, तो हमारा अहंकार (शुम्भ) आग बबूला हो उठता है।"
            "अहंकार को अपनी हार बर्दाश्त नहीं होती, इसलिए वह अब और भी ज़्यादा 'डिस्ट्रक्टिव' (Destructive) होने वाला है।"
            "शुम्भ और निशुम्भ का एक साथ क्रोधित होना 'कर्ता' और 'भोक्ता' के एक साथ दुखी होने का प्रतीक है।"
            "यह श्लोक अज्ञान की उस छटपटाहट को दिखाता है जो अपनी मौत को बहुत करीब देख रही है।"
            "क्रोध में आकर लिया गया कोई भी निर्णय हमेशा विनाशकारी (Catastrophic) ही साबित होता है।"
            "अब ये दोनों भाई अपनी पूरी ताक़त झोंक कर देवी के ऊपर सीधा प्रहार करने की योजना बनाएंगे।"
        """.trimIndent(),
        english = """
            (Incomparable Wrath of demons): "Sage Medha said: Witnessing Raktabija slaughtered, the wrath of Shumbha and Nishumbha became incomparable."
            "The fall of that mega-demon left them so distressed and enraged that their rational wisdom was entirely eclipsed."
            "'Atulam Kopam' (Incomparable Wrath) is that internal fire which is sufficient to incinerate the self first."
            "Raktabija was zero ordinary soldier for them; he was the greatest anchor of their delusion of invincibility."
            "Exactly when our deepest Illusion is shattered, our central Arrogance (Shumbha) flares up in absolute rage."
            "Ego mathematically cannot tolerate defeat; therefore, it is officially preparing to become even more 'Destructive'."
            "The simultaneous anger of Shumbha and Nishumbha represents the suffering of the 'Doer' and the 'Possessor'."
            "This verse illustrates the desperate struggle of ignorance as it perceives its own imminent cosmic death."
            "Any decision executed in a state of extreme wrath is mathematically destined to prove entirely Catastrophic."
            "Now these two brothers will pool their entire cosmic force to launch a direct assault upon the Goddess."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 4,
        sanskrit = "मृधे रक्तबीजे निपातिते हते चण्डमुण्डयोः ।\nसेनासु च क्षयितासु शुम्भश्च कोपमागतः ॥ ६ ॥",
        hindi = """
            (शुम्भ का प्रलयंकारी गुस्सा): "युद्ध में रक्तबीज के गिरने और चण्ड-मुण्ड के मारे जाने के बाद जब सेना पूरी तरह खत्म हो गई।"
            "तो दैत्यराज शुम्भ के भीतर एक प्रलयंकारी और बेकाबू क्रोध (कोपमागतः) जागृत हो उठा।"
            "शुम्भ यहाँ 'अहंकार का राजा' है, जो अब तक अपने सेनापतियों के पीछे छुपकर बैठा था।"
            "जब बाहरी सुरक्षा कवच (सेना और सेनापति) टूट जाते हैं, तो इंसान का 'मूल विकार' सीधे मैदान में आता है।"
            "कोपमागतः (क्रोध में आना) यह दर्शाता है कि अब अहंकार ने अपनी सारी गरिमा (Dignity) खो दी है।"
            "अहंकार को लगता है कि उसकी सत्ता को चुनौती देने वाली इस शक्ति (देवी) को वह खुद ही खत्म कर देगा।"
            "यह उस 'एक्स्ट्रीम पैनिक' (Extreme Panic) की स्थिति है जहाँ इंसान खुद ही आग में कूदने को तैयार हो जाता है।"
            "सत्य की एक जीत (रक्तबीज वध) ने अज्ञान के हज़ारों सालों के घमंड को एक पल में हिला दिया था।"
            "शुम्भ का यह गुस्सा उसकी ताकत नहीं, बल्कि उसकी 'कमज़ोरी' का सबसे बड़ा प्रमाण है।"
            "अब शुम्भ अपनी पूरी सेना के अवशेषों को समेटकर अंतिम संघर्ष के लिए रणभूमि की ओर कूच करेगा।"
        """.trimIndent(),
        english = """
            (Shumbha's Apocalyptic Rage): "After Raktabija fell in battle and Chanda-Munda were slaughtered, his army was completely annihilated."
            "At that specific moment, an uncontrollable and apocalyptic wrath (Kopamagatah) awakened within the Demon King Shumbha."
            "Shumbha represents the 'King of Arrogance' who, until now, was safely hidden behind his various commanders."
            "When the external defensive layers (army and generals) shatter, the 'Core Vice' is forced onto the battlefield."
            "The phrase 'Kopamagatah' proves that the Ego has now officially lost its remaining psychological dignity."
            "Arrogance falsely believes it can personally eliminate the power (Goddess) that challenged its supreme authority."
            "This reflects that state of 'Extreme Panic' where a human is ready to jump into the fire of self-destruction."
            "A single victory of Truth (Raktabija's death) had shaken thousands of years of ignorance in one split-second."
            "Shumbha's rage is mathematically zero proof of strength; it is the absolute greatest evidence of his fragility."
            "Now Shumbha will consolidate the remnants of his forces and march toward the field for the ultimate struggle."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 5,
        sanskrit = "ततः प्रमथानीकमवलोक्य निपातितम् ।\nनिशुम्भमग्रतः कृत्वा दैत्यराजो विनिर्जगाम ॥ ७ ॥",
        hindi = """
            (निशुम्भ का नेतृत्व): "अपनी सेना का विनाश देखकर, दैत्यराज शुम्भ ने अपने भाई 'निशुम्भ' को आगे (अग्रतः) किया।"
            "और वे दोनों महा-असुर अपनी बची हुई विशाल सेना के साथ रणभूमि की ओर निकल पड़े (विनिर्जगाम)।"
            "निशुम्भ 'ममता' (Attachment) का प्रतीक है—वह भावना जो कहती है 'यह सब मेरा है'।"
            "अहंकार (शुम्भ) हमेशा ममता (निशुम्भ) को अपना सबसे मज़बूत ढाल (Shield) बनाकर आगे रखता है।"
            "इंसान अपनी चीज़ों और रिश्तों से इतना जुड़ा होता है कि वह उन्हें बचाने के लिए किसी भी हद तक जा सकता है।"
            "निशुम्भ का 'अग्रतः' (सबसे आगे) होना यह बताता है कि मोह ही युद्ध की सबसे पहली पंक्ति (Frontline) है।"
            "जब हम मोह (Attachment) में होते हैं, तभी हम सत्य से लड़ने की हिम्मत कर पाते हैं।"
            "विनिर्जगाम (निकल पड़ना)—यह अज्ञान की वह अंतिम यात्रा है जिसका गंतव्य (Destination) केवल मृत्यु है।"
            "शुम्भ और निशुम्भ का यह जोड़ा इंसान के 'मैं' (I) और 'मेरा' (Mine) का सबसे सटीक चित्रण है।"
            "अब चेतना की तलवार इन दोनों भाइयों (विकारों) के सिर काटने के लिए पूरी तरह तैयार थी।"
        """.trimIndent(),
        english = """
            (Nishumbha takes the Lead): "Witnessing the total destruction of his army, Shumbha placed his brother 'Nishumbha' at the front (Agratah)."
            "And both mega-demons, with their remaining colossal forces, departed (Vinirjagama) toward the cosmic battlefield."
            "Nishumbha symbolizes 'Attachment' (Mamata)—the specific psychological frequency that claims 'This is all Mine'."
            "Arrogance (Shumbha) perpetually utilizes Attachment (Nishumbha) as its absolute strongest defensive shield."
            "A human is so deeply entangled in his possessions and relationships that he goes to any extreme to protect them."
            "Nishumbha being at the 'Front' indicates that emotional attachment is the first line of defense in psychological war."
            "Strictly when we are trapped in Attachment do we possess the deluded courage to actively fight the Truth."
            "The departure (Vinirjagama) marks the absolute final journey of ignorance whose only destination is death."
            "The pair of Shumbha and Nishumbha flawlessly represents the human concepts of 'I' and 'Mine' in their toxic format."
            "The sword of Consciousness was now perfectly prepared to sever the heads of these two brothers (Vices) forever."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 6,
        sanskrit = "तस्याग्रतस्तथा काली शूलविदारणदारुणा ।\nमुष्टिप्रहारैश्च परे पतिता धरणीतले ॥ ८ ॥",
        hindi = """
            (काली का संहारक रूप): "असुरों के सामने माता काली अपने 'त्रिशूल' से उनके शरीरों को चीरती हुई (विदारण) खड़ी थीं।"
            "वे अपने 'मुक्कों' (Fists) के भयंकर प्रहार से राक्षसों को ज़मीन (धरणीतले) पर सुला रही थीं।"
            "काली यहाँ 'संहार' (Destruction) की वह शक्ति हैं जो अज्ञान को रत्ती भर भी सांस लेने का मौका नहीं देतीं।"
            "त्रिशूल का प्रहार इंसान के तीन शरीरों (स्थूल, सूक्ष्म, कारण) की अशुद्धियों को काटने का प्रतीक है।"
            "मुष्टिप्रहार (मुक्का) देवी के उस 'रॉ पराक्रम' को दिखाता है जिसे कोई भी लॉजिक या ढाल नहीं रोक सकती।"
            "जब इंसान अपने मोह (निशुम्भ) से लड़ता है, तो उसे 'काली' जैसी निर्दयी और तीव्र ऊर्जा की ज़रूरत होती है।"
            "अज्ञान को केवल प्रार्थना से नहीं, बल्कि 'प्रचंड प्रहार' (Direct Action) से ही मिटाया जा सकता है।"
            "रणभूमि में काली का होना यह संदेश है कि बुराई के लिए अब 'मर्सी' (Mercy) का समय खत्म हो चुका है।"
            "धरणीतले (ज़मीन पर) गिरना अहंकार के झूठे ऊँचेपन के पूरी तरह ज़मींदोज़ होने का प्रतीक है।"
            "काली की हर चोट अज्ञान के उस साम्राज्य की नींव को हिला रही थी जो शुम्भ ने बनाया था।"
        """.trimIndent(),
        english = """
            (Kali's Destructive Format): "Standing before the demons, Mother Kali was aggressively ripping through their bodies with Her 'Trident'."
            "She was slamming the monsters to the ground (Dharanitale) utilizing the terrifying brute force of Her 'Fists'."
            "Kali represents the power of 'Annihilation' which grants zero breathing space to deep-seated cosmic ignorance."
            "The strike of the Trident symbolizes severing the impurities across the three human bodies (Physical, Subtle, Causal)."
            "Striking with Fists showcases the 'Raw Power' of the Goddess which no logic or shield can mathematically block."
            "When a human fights his internal Attachment (Nishumbha), he strictly requires a ruthless and intense energy like Kali."
            "Ignorance cannot be erased through prayer alone; it mathematically demands absolute 'Direct Action' and impact."
            "Kali's presence on the field is a cosmic signal that the hour of 'Mercy' for evil is now permanently over."
            "Falling to the ground represents the total collapse of the Ego's perceived and false psychological height."
            "Every blow from Kali was systematically shattering the foundation of the empire that Shumbha had constructed."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 7,
        sanskrit = "ततः समुत्पत्य गजं चकार मुष्टिना हतम् ।\nस पपात महीं देवी मुष्टिनाभिहतो गजः ॥ ९ ॥",
        hindi = """
            (हाथी का पतन): "माता ने एक विशाल हाथी के ऊपर छलांग लगाई और अपने 'मुक्के' (मुष्टिना) के एक ही प्रहार से उसे मार गिराया।"
            "वह हाथी देवी के उस भयंकर प्रहार को सहन नहीं कर सका और तुरंत 'धरती' (महीं) पर गिर पड़ा।"
            "हाथी (Elephant) इंसान के 'भारीपन' (Heaviness) और 'तामसिक अहंकार' (Tamasic Ego) का प्रतीक है।"
            "जब हम आलस या पुरानी ज़िद्दी आदतों (हाथी) के वश में होते हैं, तो हम आध्यात्मिक मार्ग पर नहीं चल पाते।"
            "मुक्के का प्रहार (Fist Strike) उस 'अचानक जागृति' (Sudden Awakening) को दर्शाता है जो आलस को तोड़ देती है।"
            "देवी का हाथी को मारना यह सिद्ध करता है कि सत्य के सामने 'संख्या' या 'आकार' (Size) का कोई महत्व नहीं है।"
            "इंसान जिसे अपनी सबसे बड़ी 'सुरक्षा' (हाथी) मानता है, चेतना के लिए वह महज़ एक खिलौना है।"
            "महीं (ज़मीन) पर गिरना यह बताता है कि भारी से भारी अज्ञान भी अंततः मिट्टी में ही मिलता है।"
            "यह दृश्य असुरों के आत्मविश्वास पर एक बहुत बड़ी मानसिक चोट (Psychological Blow) थी।"
            "अब अज्ञान का वह 'भारी आधार' खत्म हो चुका था और युद्ध अब और भी तीव्र होने वाला था।"
        """.trimIndent(),
        english = """
            (Collapse of the Elephant): "The Goddess leaped upon a colossal elephant and slaughtered it utilizing a single blow of Her 'Fist' (Mushtina)."
            "That massive elephant could mathematically zero percent endure Her terrifying strike and instantaneously dropped to the earth (Mahim)."
            "The Elephant flawlessly symbolizes human 'Heaviness', lethargy, and 'Tamasic Arrogance' in its solid format."
            "When we are enslaved by laziness or stubborn habits (The Elephant), we are incapable of spiritual movement."
            "Striking with a Fist represents that 'Sudden Awakening' of consciousness which shatters mental inertia instantly."
            "Killing the elephant proves that before Absolute Truth, neither 'Quantity' nor 'Physical Size' holds any value."
            "What a human perceives as his ultimate 'Security' (The Elephant) is merely a cheap toy for the Divine Power."
            "Dropping to the ground signifies that even the heaviest forms of ignorance ultimately dissolve into common dirt."
            "This specific visual served as a massive psychological blow to the self-confidence of the demonic army."
            "The 'Heavy Foundation' of ignorance was now destroyed, making the cosmic war exponentially more intense."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 8,
        sanskrit = "निशुम्भस्तु ततः क्रुद्धः प्राह देवीं मुहुर्मुहुः ।\nकिं करोषि रणे मूढे मा स्म भूस्त्वं भयाकुला ॥ १० ॥",
        hindi = """
            (निशुम्भ का उपहास): "निशुम्भ ने क्रोधित होकर देवी से बार-बार (मुहुर्मुहुः) कहा: 'अरे मूढ़! तू युद्ध में ये क्या कर रही है?'"
            "'तू डरे मत (मा स्म भूस्त्वं भयाकुला), मैं तुझे अभी अपनी ताकत का स्वाद चखाता हूँ'।"
            "निशुम्भ (ममता/मोह) यहाँ देवी को 'मूढ़' (मूर्ख) कह रहा है—यह अज्ञान का सबसे बड़ा विरोधाभास है।"
            "जब इंसान अपने मोह में अंधा होता है, तो उसे 'सत्य' ही बेवकूफी और नासमझी भरा लगता है।"
            "वह देवी को 'डर' (Fear) छोड़ने को कह रहा है, जबकि वह खुद अंदर से मौत के खौफ से कांप रहा था।"
            "अहंकार हमेशा दूसरों को वह उपदेश देता है जिसकी उसे खुद सबसे ज़्यादा ज़रूरत होती है।"
            "मुहुर्मुहुः (बार-बार बोलना) यह दर्शाता है कि निशुम्भ अपनी घबराहट को 'शोर' (Noise) के पीछे छिपा रहा है।"
            "ममता जब खतरे में होती है, तो वह 'तर्क' छोड़कर 'बदतमीजी' और 'उपहास' (Mockery) पर उतर आती है।"
            "निशुम्भ को अभी भी यह भ्रम है कि वह एक 'स्त्री' से लड़ रहा है, साक्षात् शक्ति से नहीं।"
            "उसकी ये बातें उसके विनाश के ताबूत में आखिरी कील साबित होने वाली थीं।"
        """.trimIndent(),
        english = """
            (Nishumbha's Mockery): "Enraged, Nishumbha repeatedly (Muhur-muhuh) spoke to the Goddess: 'O Foolish one! What exactly are You doing in battle?'"
            "'Do zero be filled with terror (Bhayakula); I shall now demonstrate my absolute raw power to You'."
            "Nishumbha (Attachment) addresses the Goddess as 'Mudha' (Fool)—this is the greatest paradox of ignorance."
            "When a human is blinded by attachment, Absolute Truth appears illogical, foolish, and nonsensical to him."
            "He advises the Goddess to abandon 'Fear' while he himself was trembling internally from the fear of death."
            "Arrogance perpetually preaches to others exactly those virtues which it itself desperately lacks in reality."
            "The repetition (Muhur-muhuh) proves that Nishumbha was attempting to hide his anxiety behind 'Loud Noise'."
            "When Attachment is threatened, it abandons logic and resorts to 'Insults' and superficial 'Cosmic Mockery'."
            "Nishumbha still deludes himself into thinking he is fighting a 'Woman' rather than the absolute Primal Power."
            "These arrogant words were destined to be the final nails in the coffin of his own absolute annihilation."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 9,
        sanskrit = "एवमुक्त्वा शरान् तीक्ष्णान् निशुम्भः समरे मुहुः ।\nववर्ष चण्डिकां कोपाद् यथा मेरुं तोयवाहकाः ॥ ११ ॥",
        hindi = """
            (तीरों की वर्षा): "ऐसा कहकर निशुम्भ ने युद्ध में बार-बार अपने तीखे बाणों की माता चण्डिका पर वर्षा की।"
            "वह क्रोध (कोपाद्) में इतने तीर चला रहा था, जैसे बादल सुमेरु पर्वत पर मूसलाधार बारिश करते हैं।"
            "निशुम्भ के ये 'बाण' इंसान के वे 'कड़वे बोल' और 'नकारात्मक विचार' हैं जो ममता से पैदा होते हैं।"
            "बादलों (तोयवाहकाः) की उपमा यह बताती है कि बुराई के पास तर्कों की कोई कमी नहीं होती, वह झड़ी लगा देती है।"
            "लेकिन यहाँ देवी की तुलना 'सुमेरु' (Mount Meru) से की गई है, जो ब्रह्मांड का अचल केंद्र (Axis) है।"
            "चाहे कितनी भी भयंकर बारिश (विचार) हो जाए, पहाड़ कभी अपनी जगह से नहीं हिलता।"
            "जब आप अपनी 'उच्च चेतना' (मेरु) में स्थित होते हैं, तो दुनिया की कोई भी गाली या चोट आपको विचलित नहीं कर सकती।"
            "निशुम्भ अपनी पूरी ऊर्जा खर्च कर रहा था, पर वह साक्षात् 'शांति' पर वार करने की कोशिश कर रहा था।"
            "अहंकार को लगता है कि वह अपने 'एग्रेसिव' व्यवहार से सत्य को झुका देगा, पर यह उसका भ्रम है।"
            "यह दृश्य अज्ञान की उस 'फ्रस्ट्रेशन' को दिखाता है जो सत्य की स्थिरता के सामने लाचार है।"
        """.trimIndent(),
        english = """
            (Rain of Arrows): "Having spoken thus, Nishumbha repeatedly rained sharp arrows upon Goddess Chandika in the battle."
            "Driven by wrath (Kopad), he fired weapons like storm-clouds executing a torrential downpour upon Mount Meru."
            "These 'Arrows' of Nishumbha represent the 'Bitter Words' and 'Negative Projections' born from deep attachment."
            "The comparison to storm-clouds proves that evil possesses an endless supply of toxic arguments and fallacies."
            "However, the Goddess is compared to 'Meru', the absolute unmovable central Axis of the entire universe."
            "Regardless of how violent the torrential rain (thoughts) is, the mountain mathematically never shifts its position."
            "When you are rooted in your 'Higher Consciousness' (Meru), zero worldly insults can successfully distract you."
            "Nishumbha was exhausting his vital energy desperately attempting to wound absolute 'Stillness' itself."
            "Arrogance falsely believes that its 'Aggressive' behavior will force Truth to bow, which is a major hallucination."
            "This scene illustrates the 'Frustration' of ignorance which is helpless before the stability of the Truth."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 10,
        sanskrit = "तस्य तान् सायकैस्तीक्ष्णैः सद्यः छित्त्वा तु चण्डिका ।\nजघान चतुरः सद्यस्तुरगान् बाणपातिनैः ॥ १२ ॥",
        hindi = """
            (देवी का पलटवार): "माता चण्डिका ने तुरंत (सद्यः) अपने तीखे बाणों से निशुम्भ के उन सभी तीरों को काट डाला।"
            "और अगले ही क्षण माता ने अपने अचूक निशानों से उसके 'चारों घोड़ों' (चतुरः तुरगान्) को मार गिराया।"
            "घोड़े (Horses) इंसान के 'मन' की उन चार दिशाओं और गतियों का प्रतीक हैं जो उसे दुनिया में दौड़ाती हैं।"
            "जब तक मन (घोड़े) ज़िंदा है, अहंकार का रथ (व्यक्तित्व) भागता रहेगा और मुसीबतें पैदा करेगा।"
            "देवी ने सबसे पहले उस 'गति' (Momentum) को ही काट दिया जो अज्ञान को पावर दे रही थी।"
            "यह 'सर्जिकल स्ट्राइक' (Surgical Strike) दिखाती है कि सत्य बुराई के 'सपोर्ट सिस्टम' पर सबसे पहले वार करता है।"
            "बिना घोड़ों के, निशुम्भ का वह भारी रथ अब रणभूमि में महज़ एक लकड़ी का टुकड़ा बनकर रह गया था।"
            "यह इंसान की उस स्थिति का प्रतीक है जब उसके पास अपनी बुराई को जारी रखने के लिए कोई 'साधन' (Means) नहीं बचता।"
            "माता की गति इतनी तेज़ थी कि निशुम्भ को अपनी हार का अहसास होने का मौका भी नहीं मिला।"
            "अब अज्ञान पूरी तरह से 'डिसेबल्ड' (Disabled) हो चुका था और पैदल लड़ने को मजबूर था।"
        """.trimIndent(),
        english = """
            (The Divine Counter-Strike): "Goddess Chandika instantaneously (Sadyah) severed all of Nishumbha's arrows utilizing Her own sharp missiles."
            "And in the very next microsecond, She slaughtered his 'Four Horses' (Chaturah Turagan) with Her infallible aim."
            "Horses symbolize the four fundamental directions and velocities of the 'Human Mind' that race toward the world."
            "As long as the mind (Horses) remains active, the chariot of Arrogance (Personality) will continue to create chaos."
            "The Goddess primarily severed that specific 'Cosmic Momentum' which was powering the demonic ignorance."
            "This 'Surgical Strike' proves that Absolute Truth first attacks and destroys the 'Support System' of evil."
            "Without the horses, Nishumbha's heavy chariot was now merely a useless piece of wood in the battlefield."
            "This symbolizes the human condition when one lacks the 'Means' or resources to continue their toxic behavior."
            "The Mother's velocity was so exceptional that Nishumbha had zero time to even comprehend his strategic failure."
            "Now ignorance was completely 'Disabled' and was forcefully compelled to fight purely on foot."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 11,
        sanskrit = "चिच्छेद च धनुः सद्यो निशुम्भस्यातिवेगवान् ।\nततो जग्राह शूलं स कोपादरुणलोचनः ॥ १३ ॥",
        hindi = """
            (धनुष का कटना): "देवी ने अत्यंत तेज़ी से निशुम्भ के 'धनुष' को भी काटकर टुकड़े-टुकड़े कर दिया।"
            "धनुष कट जाने पर वह राक्षस क्रोध से 'लाल आँखें' (अरुणलोचनः) करके एक भयंकर 'शूल' (भाला) उठा लाया।"
            "धनुष (Bow) इंसान के 'इंटेलिजेंस' और 'प्लानिंग' का प्रतीक है—देवी ने उसके सोचने का तरीका ही ब्लॉक कर दिया।"
            "जब अज्ञान का मुख्य हथियार (लॉजिक) टूटता है, तो वह और भी ज़्यादा 'खूंखार' (Violent) हो जाता है।"
            "अरुणलोचन (Red Eyes) उस पागलपन का प्रतीक है जहाँ इंसान गुस्से में अपना ही नुकसान करने लगता है।"
            "शूल (Spear) एक 'वन-पॉइंटेड' नफरत है, जिसे लेकर वह अब सीधे देवी की ओर झपटा।"
            "यह दिखाता है कि जैसे-जैसे अहंकार हारता है, उसका व्यवहार और भी ज़्यादा 'कच्चा' (Raw) और 'जंगली' होता जाता है।"
            "देवी ने उसे निहत्था करने की कोशिश की, पर उसने अपनी 'ज़िद' (शूल) को नहीं छोड़ा।"
            "अहंकारी मन एक गलती पकड़े जाने पर उसे सुधारने के बजाय दूसरा 'भयानक झूठ' गढ़ता है।"
            "अब युद्ध का यह चरण 'अस्त्र' से निकलकर 'शारीरिक बल' की ओर बढ़ रहा था।"
        """.trimIndent(),
        english = """
            (Severing the Bow): "The Goddess rapidly severed Nishumbha's 'Bow' into pieces with an exceptionally high-velocity strike."
            "With his bow destroyed, that demon, possessing 'Blood-red eyes' (Arunalochana), aggressively seized a terrifying 'Spear'."
            "The Bow symbolizes human 'Intelligence' and 'Planning'—the Goddess permanently blocked his strategic thought-process."
            "When the primary weapon (Logic) of ignorance shatters, it becomes exponentially more 'Violent' and reactive."
            "Red Eyes represent that absolute madness where a human, consumed by rage, initiates his own destruction."
            "The Spear (Shula) represents 'One-pointed Hatred', which he now utilized to charge directly at the Goddess."
            "This proves that as the Ego loses, its behavior becomes increasingly 'Raw', 'Unrefined', and animalistic."
            "The Goddess attempted to disarm him, but he refused to relinquish his 'Stubbornness' (The Spear)."
            "An arrogant mind, instead of self-correcting after a failure, fabricates a 'Terrifying Lie' to defend itself."
            "The war was now transitioning from 'Ranged Weaponry' toward absolute 'Raw Physical Force'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 12,
        sanskrit = "चिक्षेप च सुतप्तं तत्तेजसा भद्रकालिम् ।\nभद्रकाल्यां महाशूलं ज्वालामालमिवोत्थितम् ॥ १४ ॥",
        hindi = """
            (भाले का प्रहार): "उस राक्षस ने उस आग की तरह धधकते हुए (सुतप्तं) महा-शूल को माता भद्रकाली पर पूरी ताक़त से फेंका।"
            "वह भाला हवा में उड़ता हुआ ऐसा लग रहा था, मानो आग की भयंकर ज्वालाएं (ज्वालामालम्) आकाश से गिर रही हों।"
            "निशुम्भ ने अपनी पूरी 'नेगेटिव एनर्जी' (सुतप्तं तेजः) उस एक भाले में झोंक दी थी।"
            "यह भाला इंसान के उस 'चरम द्वेष' (Extreme Hatred) का प्रतीक है जो किसी को पूरी तरह जला देना चाहता है।"
            "यहाँ देवी को 'भद्रकाली' कहा गया है, जो 'समय और न्याय' (Time and Justice) की अधिष्ठात्री हैं।"
            "अज्ञान ने अपनी आखिरी आग सीधे 'काल' (Time) पर फेंकी है, जो उसकी सबसे बड़ी बेवकूफी है।"
            "ज्वालामालम् (आग की लपटें) यह दर्शाती हैं कि बुराई का अंतिम वार हमेशा बहुत डरावना और विनाशकारी दिखता है।"
            "लेकिन भद्रकाली वह शून्यता हैं जो करोड़ों सूर्यों की गर्मी को भी अपने अंदर समा सकती हैं।"
            "यह दृश्य अहंकार की उस 'हताशा' को दिखाता है जहाँ वह सब कुछ खत्म कर देना चाहता है।"
            "परंतु सत्य के कवच को भेदना किसी भी अस्त्र के लिए मुमकिन नहीं था।"
        """.trimIndent(),
        english = """
            (The Lethal Throw): "That demon hurled that 'Blazing fire-like' (Sutaptam) massive spear at Mother Bhadrakali with total brute force."
            "Flying through the air, that spear appeared identically like a 'Mountain of flames' (Jvalamalam) falling from the sky."
            "Nishumbha had successfully infused his absolute 'Negative Energy' into that singular lethal weapon."
            "This spear symbolizes human 'Extreme Hatred' which desperately desires to incinerate the opponent completely."
            "The Goddess is addressed as 'Bhadrakali', the mistress of 'Time and Cosmic Justice', in this specific context."
            "Ignorance has hurled its final fire directly at 'Time' (Kali), which is mathematically its absolute peak stupidity."
            "The 'Ferry of Flames' proves that the final strike of evil always appears exceptionally terrifying and apocalyptic."
            "However, Bhadrakali is that infinite Void capable of absorbing the heat of millions of suns simultaneously."
            "This scene illustrates the 'Desperation' of the Ego where it seeks to execute total destruction before its end."
            "But piercing the armor of Absolute Truth was a mathematical impossibility for any worldly weapon."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 13,
        sanskrit = "दृष्ट्वा तदापतच्छूलं देवी शूलममुञ्चत ।\nतेन तच्छतधा शूलं स च भस्मीकृतोऽसुरः ॥ १५ ॥",
        hindi = """
            (शूल का नाश): "अपनी ओर आते हुए उस आग उगलते भाले को देखकर, देवी ने अपना अमोघ 'शूल' (त्रिशूल) चला दिया।"
            "देवी के उस त्रिशूल ने राक्षस के भाले को हवा में ही 'सौ टुकड़ों' (शतधा) में काटकर चकनाचूर कर दिया।"
            "और साथ ही उसी प्रहार से निशुम्भ की शक्ति का वह 'अहंकारी स्वरूप' (असुर) भी भस्म हो गया।"
            "यह 'क्वांटम स्ट्राइक' (Quantum Strike) है—सत्य ने अज्ञान के हथियार को जड़ से ही मिटा दिया।"
            "सौ टुकड़े (100 pieces) होना यह बताता है कि झूठ के हज़ारों तर्क भी सत्य के एक वार के सामने नहीं टिक सकते।"
            "जब चेतना का त्रिशूल (सत्व, रज, तम) सक्रिय होता है, तो हर नेगेटिव विचार राख (भस्म) बन जाता है।"
            "देवी ने न केवल हथियार को रोका, बल्कि उस हथियार को चलाने वाली 'नीयत' (Intention) को भी मार दिया।"
            "निशुम्भ अब पूरी तरह से 'शक्तिहीन' (Powerless) महसूस करने लगा था क्योंकि उसका सबसे घातक अस्त्र भी फेल हो गया।"
            "यह श्लोक सिद्ध करता है कि बुराई की आग सत्य की एक किरण से भी शांत हो जाती है।"
            "युद्ध का मैदान अब अज्ञान की राख से भर रहा था, जो शुद्धि का संकेत था।"
        """.trimIndent(),
        english = """
            (Destruction of the Spear): "Visually witnessing the fire-spitting spear approaching Her, the Goddess unleashed Her invincible 'Trident'."
            "That Trident shattered the demon's spear into 'One Hundred Pieces' (Shatadha) cleanly in mid-air."
            "And simultaneously, that arrogant 'Demonic Manifestation' of power was reduced to ashes by the same strike."
            "This is a 'Quantum Strike'—where Absolute Truth erases the very essence and existence of the weapon of ignorance."
            "The 'Hundred Pieces' prove that thousands of false arguments mathematically fail against a singular blow of Truth."
            "Exactly when the Trident of Consciousness (Mastery over Gunas) activates, every negative thought is incinerated."
            "The Goddess did zero to just block the weapon; She effectively executed the 'Intention' behind that weapon."
            "Nishumbha now felt entirely 'Powerless' as his absolute most lethal asset was rendered mathematically zero."
            "This verse proves that the fire of evil is instantaneously pacified strictly by a single ray of Truth."
            "The battlefield was now filling with the ashes of ignorance, signaling the arrival of total purification."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 14,
        sanskrit = "महिषासुरसेनानौ निहते वीर्यशालिनि ।\nआजगाम गजारूढश्चामरस्त्रिदशार्दनः ॥ १६ ॥",
        hindi = """
            (चामर का प्रवेश): "जब सेनापति और रक्तबीज जैसे वीर मारे गए, तो देवताओं को सताने वाला दूसरा महा-असुर 'चामर' आया।"
            "वह एक विशाल 'हाथी' (गजारूढः) पर सवार होकर अत्यंत घमंड के साथ देवी से लड़ने के लिए आ पहुँचा।"
            "चामर (Chamara) वह 'भारी अज्ञान' है जो अपनी भारी-भरकम ताकत से दूसरों को कुचलना चाहता है।"
            "हाथी यहाँ 'मानसिक जड़ता' और 'ठोस अहंकार' का प्रतीक है, जो बदलाव को स्वीकार नहीं करता।"
            "जब 'ममता' (निशुम्भ) कमज़ोर पड़ती है, तो वह अपने 'भारीपन' (चामर) को आगे कर देती है।"
            "त्रिदशार्दनः (देवताओं को दुख देने वाला)—यह वह डिप्रेशन है जो हमारे सात्विक गुणों को धीरे-धीरे घोंट देता है।"
            "अहंकार को लगता है कि वह अपनी 'विशालता' (Size) दिखाकर देवी को डरा लेगा।"
            "अज्ञानी मन हमेशा भारी और दिखावटी चीज़ों (हाथी) पर बहुत ज़्यादा भरोसा करता है।"
            "परंतु वह भूल गया है कि जो देवी अस्त्रों को निगल सकती हैं, उनके लिए यह हाथी महज़ एक मच्छर के बराबर है।"
            "रणभूमि में अब एक और 'असंभव' लगने वाले युद्ध की शुरुआत होने जा रही थी।"
        """.trimIndent(),
        english = """
            (The Entry of Chamara): "After the powerful commanders were slaughtered, the demon 'Chamara', the tormentor of Gods, arrived."
            "He marched forward with extreme pride, perfectly seated upon a 'Colossal Elephant' (Gajarudhah) to fight the Goddess."
            "Chamara represents that 'Heavy Ignorance' which seeks to crush everything through its massive physical force."
            "The Elephant symbolizes 'Mental Inertia' and 'Solid Arrogance' that strictly refuses to adapt or change."
            "When 'Attachment' (Nishumbha) weakens, it deploys its absolute 'Heaviness' (Chamara) to sustain its dominance."
            "The term 'Tridashardanah' indicates the depression that systematically suffocates our internal pure virtues."
            "The Ego falsely deludes itself into thinking that a display of 'Size' will successfully terrorize the Goddess."
            "The ignorant mind perpetually places excessive trust in massive and showy external objects (The Elephant)."
            "However, he ignores that for the Goddess who devours cosmic weapons, this elephant is mathematically a gnat."
            "Another battle that appeared 'Impossible' to the worldly mind was now preparing to launch."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 15,
        sanskrit = "सोऽपि शक्तिं मुमोचाथ देव्यास्तामम्बिका द्रुतम् ।\nहुङ्कारेणैव ताम्भस्मीकृत्य सा भूमलेऽपातयत् ॥ १७ ॥",
        hindi = """
            (हुंकार से भस्म होना): "चामर ने आते ही अपनी विनाशकारी 'शक्ति' (भाला) माता चण्डिका पर पूरी ताक़त से फेंक दी।"
            "परंतु माता अम्बिका ने केवल एक भयंकर 'हुं' (Humkara) का उच्चारण किया और वह अस्त्र हवा में ही भस्म हो गया!"
            "यह श्लोक 'शब्द की शक्ति' (Power of Sound/Vibration) का सबसे बड़ा वैज्ञानिक प्रमाण है।"
            "'हुंकार' तन्त्र में वह 'अग्नि बीज' है जो किसी भी भौतिक पदार्थ को एक सेकंड में डी-मटेरियलाइज़ कर सकता है।"
            "देवी ने कोई शस्त्र नहीं उठाया, केवल अपनी 'साँस' की ध्वनि से उस भारी प्रहार को ज़ीरो (Zero) कर दिया।"
            "जब आपका 'फोकस' (Focus) इतना तीव्र होता है, तो समस्या आपके पास पहुँचने से पहले ही शांत हो जाती है।"
            "चामर का वह 'भारी हथियार' अब महज़ ज़मीन पर गिरी हुई राख (Ashes) बन चुका था।"
            "यह दिखाता है कि 'चेतना' (Consciousness) के सामने 'मैटर' (Matter) हमेशा हार जाता है।"
            "असुर यह देखकर सन्न रह गया कि उसकी सबसे बड़ी ताकत एक 'आवाज़' के सामने कुछ भी नहीं थी।"
            "अज्ञान का यह घमंड भी अब धूल में मिल चुका था और मौत का साया गहराने लगा था।"
        """.trimIndent(),
        english = """
            (Incinerated by Humkara): "Upon arrival, Chamara hurled his destructive 'Shakti' spear at Mother Chandika with absolute raw force."
            "However, Mother Ambika merely uttered a single terrifying 'Hum' (Humkara), and that weapon was incinerated in mid-air!"
            "This verse serves as the absolute greatest scientific evidence of the 'Power of Vibration' (Shabda-Shakti)."
            "'Humkara' is the exact Fire-Seed Mantra capable of De-materializing any physical object in a single split-second."
            "The Goddess lifted zero weapons; She reduced that massive assault to absolute Zero strictly utilizing Her Breath."
            "When your mental 'Focus' is exceptionally intense, the problem is pacified before it ever reaches your proximity."
            "Chamara's 'Heavy Weapon' was now nothing more than a pile of ashes (Bhasma) dropped dead to the ground."
            "This flawlessly demonstrates that 'Matter' is perpetually defeated when confronted by 'Infinite Consciousness'."
            "The demon was paralyzed upon realizing that his greatest strength was mathematically zero against a mere Sound."
            "The pride of ignorance was once again reduced to dust as the shadow of death began to deepen."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 16,
        sanskrit = "भग्नायां शक्तौ शूलं स चिक्षेप क्रोधाकुलः ।\nतदपि सा देवी छित्त्वा बाणैरुपातयत् ॥ १८ ॥",
        hindi = """
            (शूल का कटना): "अपनी शक्ति को इस प्रकार भस्म होते देखकर, चामर 'क्रोध से पागल' (क्रोधाकुलः) हो गया।"
            "उसने अपना दूसरा भयंकर अस्त्र 'शूल' (त्रिशूल) देवी पर फेंका, पर माता ने उसे अपने 'बाणों' से काट गिराया।"
            "क्रोध में आकर लिया गया दूसरा कदम भी पहले से ज़्यादा 'कमज़ोर' और 'गलत' साबित हुआ।"
            "जब अज्ञान का पहला प्लान फेल होता है, तो वह बिना सोचे-समझे 'रिएक्शन' (Reaction) देने लगता है।"
            "देवी के 'बाण' (Arrows) यहाँ 'तीक्ष्ण विवेक' का प्रतीक हैं जो हर भ्रम को बीच से ही काट देते हैं।"
            "निशुम्भ की सेना के ये वार अब माता के लिए महज़ एक 'खेल' (Game) की तरह थे।"
            "अहंकार (चामर) अब पूरी तरह से 'सुरक्षाहीन' (Defenseless) महसूस कर रहा था।"
            "इंसान जब अपनी 'ममता' और 'जड़ता' में फँसता है, तो वह इसी तरह बेअसर वार करता रहता है।"
            "सत्य की तलवार और बाण हर बार उसके घमंड को ज़मीन पर पटक देते हैं।"
            "रणभूमि अब अज्ञान की हार के दस्तावेज़ों (टूटे हुए अस्त्रों) से पूरी तरह भर चुकी थी।"
        """.trimIndent(),
        english = """
            (Severing the Spear): "Witnessing his weapon incinerated, Chamara became 'Insane with Rage' (Krodhakulah) and lost all balance."
            "He hurled his second terrifying 'Spear', but the Mother cleanly severed it utilizing Her precise 'Arrows'."
            "The second step taken in blind wrath proved mathematically even 'Weaker' and more incorrect than the first."
            "When the primary plan of ignorance fails, it initiates impulsive 'Reactions' instead of calculated strategies."
            "The Goddess's 'Arrows' symbolize 'Sharp Wisdom' that slices through every rising delusion in mid-air."
            "The strikes from Nishumbha's forces were now strictly merely a 'Cosmic Game' for the Supreme Mother."
            "Arrogance (Chamara) was now starting to feel entirely and purely 'Defenseless' against the Divine Power."
            "When a human is trapped in 'Attachment' and 'Inertia', he continues to make these ineffective mental strikes."
            "The sword and arrows of Truth consistently slam his pride straight back to the absolute dirt ground."
            "The battlefield was now saturated with the documentation of ignorance's defeat (shattered weapons)."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 17,
        sanskrit = "ततः सिंहः समुत्पत्य गजकुम्भान्तरे स्थितः ।\nबाहुयुद्धेन तेनोच्चैश्चचार सुरशत्रुणा ॥ १९ ॥",
        hindi = """
            (सिंह का आक्रमण): "तभी माता का सिंह उछलकर सीधे उस हाथी के 'मस्तक' (गंडस्थल) पर जा बैठा।"
            "वहाँ बैठकर उस शेर ने उस महा-राक्षस चामर के साथ भयंकर 'बाहुयुद्ध' (Wrestling) करना शुरू किया।"
            "सिंह साक्षात् 'धर्म' है, जो हमेशा अज्ञान के 'दिमाग' (मस्तक) पर सीधा प्रहार करता है।"
            "हाथी 'भारीपन' और 'डिप्रेशन' का प्रतीक है, जिसे अब साहस (शेर) कुचल रहा था।"
            "बाहुयुद्ध (Hand-to-hand combat) यह दिखाता है कि सत्य और असत्य का संघर्ष अब बहुत 'निजी' और गहरा हो गया है।"
            "शेर का हाथी पर चढ़ना मतलब इंसान के 'साहस' का उसके 'डर' के ऊपर पूरी तरह से हावी हो जाना।"
            "जब आप अपनी अच्छी प्रवृत्तियों (Lion) को जागृत करते हैं, तो वे खुद ही बुराई का गला पकड़ लेती हैं।"
            "चामर (अज्ञान) अब अपनी 'विशालता' के बावजूद शेर के पंजों में पूरी तरह से फंस चुका था।"
            "यह दृश्य ईगो के उस 'फिजिकल सप्रेशन' को दिखाता है जहाँ वह अब कहीं भाग नहीं सकता।"
            "रणभूमि अब प्रलयंकारी गर्जनाओं से गूँज रही थी और जीत का पल बहुत करीब था।"
        """.trimIndent(),
        english = """
            (The Lion's Assault): "Then the Mother's Lion leaped and landed directly upon the exact 'Forehead' of that colossal elephant."
            "Seated there, the Lion initiated a terrifying 'Wrestling match' (Bahu-yuddha) with the mega-demon Chamara."
            "The Lion is the literal manifestation of 'Dharma', which perpetually strikes at the 'Head' of ignorance."
            "The Elephant symbolizes 'Heaviness' and 'Depression', now being pulverized by human Courage (The Lion)."
            "Wrestling shows that the conflict between Truth and Lies has now become exceptionally 'Personal' and deep."
            "The Lion mounting the elephant signifies Courage achieving total and absolute Domination over internal fear."
            "When You awaken Your virtuous tendencies (The Lion), they independently seize the throat of Your vices."
            "Chamara (Ignorance), despite his massive size, was now completely trapped within the Lion's sharp claws."
            "This scene illustrates the 'Physical Suppression' of the Ego where it possesses mathematically zero escape routes."
            "The battlefield resonated with apocalyptic roars as the moment of final victory drew exceptionally close."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 18,
        sanskrit = "युध्यमानौ ततस्तौ तु तस्मान्नागान्महीतलम् ।\nनिपेततुः सम्मरब्धौ प्रहारैरतिदारुणैः ॥ २० ॥",
        hindi = """
            (ज़मीन पर गिरना): "वे दोनों (सिंह और असुर) लड़ते-लड़ते उस हाथी के ऊपर से नीचे 'धरती' (महीतलम्) पर आ गिरे।"
            "नीचे गिरकर भी वे एक-दूसरे पर अत्यंत भयंकर और खौफनाक प्रहार (प्रहारैरतिदारुणैः) करते रहे।"
            "हाथी से नीचे गिरना मतलब अज्ञान का अपनी 'झूठी ऊँचाई' (False Status) से नीचे आ जाना।"
            "अहंकार हमेशा खुद को दूसरों से ऊपर समझता है, पर हकीकत उसे 'ज़मीन' पर ले आती है।"
            "सच्चाई और झूठ की लड़ाई कभी 'सॉफ्ट' (Soft) नहीं होती; इसमें भयंकर तोड़-फोड़ (दारुण प्रहार) मचती है।"
            "जब आप अपनी किसी पुरानी और गहरी बुरी आदत को छोड़ते हैं, तो मन के अंदर ऐसा ही युद्ध चलता है।"
            "सिंह (धर्म) ने चामर (अहंकार) को उसकी जड़ों से उखाड़ कर 'ग्राउंड' (Ground) कर दिया था।"
            "अब अज्ञान के पास भागने के लिए न कोई सिंहासन बचा था और न ही कोई ऊँचा स्थान।"
            "वे दोनों रणभूमि की धूल में गुंथे हुए थे, जहाँ केवल 'सर्वश्रेष्ठ' (Survival of the holiest) ही बच सकता था।"
            "यह दृश्य अहंकार के उस 'अंतिम संघर्ष' को दिखाता है जहाँ वह पूरी तरह नंगा और बेबस है।"
        """.trimIndent(),
        english = """
            (Falling to the Earth): "While fighting, both the Lion and the demon dropped from the elephant onto the 'Earth' (Mahitalam)."
            "Even on the ground, they continued executing exceptionally terrifying and severe physical blows (Atidarunaih)."
            "Falling from the elephant symbolizes ignorance losing its 'False Height' and perceived psychological superiority."
            "Arrogance perpetually views itself as elevated, but Reality eventually drags it back to the absolute 'Ground'."
            "The battle between Truth and Lies is mathematically zero 'Soft' event; it involves massive internal destruction."
            "When You attempt to relinquish an ancient and deep toxic habit, Your mind experiences exactly this war."
            "The Lion (Dharma) had successfully uprooted Chamara (Arrogance) and 'Grounded' him in the absolute Reality."
            "Now ignorance possessed zero thrones and zero high ground to hide its pathetic and fragile existence."
            "They were locked in the dirt of the battlefield, where strictly only the 'Holiest' could mathematically survive."
            "This visual illustrates the 'Final Struggle' of the Ego where it stands completely exposed and helpless."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 19,
        sanskrit = "ततस्तु वेगात्खमुत्पत्य निपत्य च मृगारिणा ।\nकरप्रहारेण शिरश्चामरस्य पृथक्कृतम् ॥ २१ ॥",
        hindi = """
            (चामर का वध): "तब उस सिंह (मृगारिणा) ने अत्यंत तेज़ी से 'आकाश' (खम्) की ओर एक लंबी छलांग लगाई।"
            "और फिर वापस नीचे गिरते हुए (निपत्य), उसने अपने पंजों के एक ही प्रहार से उस असुर का सिर काट दिया!"
            "सिर का कटना मतलब 'थॉट प्रोसेस' (Thought Process) का शरीर से हमेशा के लिए अलग हो जाना।"
            "सिंह ने बिना किसी हथियार के, केवल अपने 'शुद्ध साहस' (Action) से अज्ञान के मस्तक को धड़ से अलग किया।"
            "छलांग लगाना यह दर्शाता है कि सत्य हमेशा 'उच्च दृष्टिकोण' (Higher Perspective) से प्रहार करता है।"
            "जब साहस (शेर) अपने चरम पर पहुँचता है, तो वह असंभव लगने वाली बुराई को भी एक सेकंड में खत्म कर देता है।"
            "चामर (भारी अहंकार) अब रणभूमि की धूल में बेजान होकर गिर पड़ा था और उसका साम्राज्य खत्म हो गया।"
            "धर्म की यह 'क्लीन विक्ट्री' (Clean Victory) थी जहाँ उसने बुराई की 'सोच' को ही मार दिया।"
            "अहंकार के दो सबसे बड़े रक्षक (धूम्रलोचन और चामर) अब इतिहास के पन्नों में दफन हो चुके थे।"
            "देवी के गणों ने जय-जयकार की, क्योंकि अब केवल शुम्भ और निशुम्भ ही बाकी बचे थे।"
        """.trimIndent(),
        english = """
            (The Slaughter of Chamara): "Then the Lion (Mregarina) took a high-velocity leap toward the absolute high 'Sky' (Kham)."
            "And while crashing back down (Nipatya), he severed the demon's head utilizing a single strike of his powerful paw!"
            "Severing the head translates to the permanent separation of the 'Corrupted Thought Process' from the physical body."
            "The Lion utilized zero worldly weapons; He used strictly 'Pure Courage' to disconnect the source of ignorance."
            "Leaping into the sky demonstrates that Truth perpetually delivers its strikes from a 'Higher Perspective' of consciousness."
            "When human Courage reaches its absolute peak, it annihilates seemingly immortal evil in a single split-second."
            "Chamara (Heavy Arrogance) now lay lifeless in the dirt of the battlefield, his empire permanently finished."
            "This was a 'Clean Victory' for Dharma, where it successfully slaughtered the very 'Foundation' of evil thinking."
            "The two greatest defenders of the Ego (Dhumralochana and Chamara) were now buried in the abyss of history."
            "The divine troops roared in triumph, as now only the core pillars Shumbha and Nishumbha remained."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 20,
        sanskrit = "उदग्रश्च रणे देव्या शिलावृक्षादिभिर्हतः ।\nदन्तमुष्टितलैश्चैव करालश्च निपातितः ॥ २२ ॥",
        hindi = """
            (उदग्र और कराल का वध): "देवी ने युद्ध में 'उदग्र' को शिलाओं (पत्थरों) और वृक्षों के प्रहार से मार गिराया।"
            "तथा 'कराल' नामक राक्षस को अपने दाँतों, मुक्कों और थप्पड़ों के प्रहार से ज़मीन पर सुला दिया।"
            "शिला और वृक्ष 'प्रकृति' (Nature) के उन तत्वों का प्रतीक हैं जो इंसान के घमंड को तोड़ते हैं।"
            "उदग्र (Arrogance) को मारने के लिए देवी को किसी दिव्य अस्त्र की ज़रूरत नहीं पड़ी, महज़ एक 'पत्थर' (हकीकत) काफी था।"
            "कराल (Wrath) को देवी ने अपने हाथों (Physical Action) से शांत किया, जो 'इंद्रिय नियंत्रण' का प्रतीक है।"
            "यह दिखाता है कि प्रकृति के साधारण रूपों में भी अज्ञान को कुचलने की अपार और अजेय शक्ति होती है।"
            "मुक्कों और थप्पड़ों का प्रयोग देवी के उस 'डायरेक्ट और रॉ' पराक्रम को दर्शाता है जो बुराई को झकझोर देता है।"
            "सत्य जब हमारे करीब आता है, तो वह किसी थप्पड़ की तरह हमें अपनी गलतियों का कड़वा अहसास कराता है।"
            "इन छोटे असुरों का मरना मन की 'डिटॉक्सिंग' (Detoxification) की पूरी प्रक्रिया का एक हिस्सा था।"
            "अब अज्ञान की हर छोटी शाखा (Branch) काटी जा चुकी थी, केवल मुख्य जड़ (Root) ही बाकी थी।"
        """.trimIndent(),
        english = """
            (Death of Udagra and Karala): "The Goddess killed 'Udagra' utilizing heavy stones and massive trees during the battle."
            "She also slammed the demon 'Karala' to the ground utilizing Her teeth, fists, and powerful slaps."
            "Stones and Trees symbolize the raw elements of 'Mother Nature' that eventually break down human pride."
            "To eliminate Udagra (Arrogance), the Goddess required zero divine weaponry; a mere 'Stone' (Reality) was sufficient."
            "Karala (Wrath) was silenced by the Goddess's hands, symbolizing absolute 'Sensory Mastery' and control."
            "This proves that even the simplest forms of Nature possess the capacity to pulverize colossal psychological distortions."
            "Using fists and slaps highlights the 'Direct and Raw' valor of the Goddess which violently shakes the core of evil."
            "When Truth approaches us, it often delivers a psychological slap to make us acknowledge our toxic mistakes."
            "The slaughter of these minor demons was an integral part of the complete 'Detoxification' of the human mind."
            "Every minor branch of ignorance had now been successfully severed, leaving strictly only the absolute main root."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 21,
        sanskrit = "भ्रुकुटीकुटिलात्तस्या ललाटफलकाद्द्रुतम् ।\nकाली करालवक्त्रान्तर्दुर्दर्शदशनोज्ज्वला ॥ २१ ॥",
        hindi = """
            (काली का प्राकट्य): "देवी के मस्तक (ललाट) की टेढ़ी भौंहों से अचानक माता काली का प्राकट्य हुआ।"
            "उनका मुख अत्यंत डरावना था और उनके दाँत बिजली की तरह चमक रहे थे।"
            "काली यहाँ उस 'परम विवेक' का प्रतीक हैं जो अज्ञान के अंधकार को निगल जाता है।"
            "मस्तक से निकलना यह दर्शाता है कि यह शक्ति हमारी 'उच्च बुद्धि' (Intuition) से पैदा होती है।"
            "जब ममता (निशुम्भ) बहुत ज़िद्दी हो जाती है, तो उसे मारने के लिए काली जैसी उग्र ऊर्जा चाहिए।"
            "असुर उनके चेहरे की भयानक चमक को देख पाने में भी पूरी तरह असमर्थ थे।"
            "यह स्वरूप अज्ञानी के लिए खौफ है, पर सत्य के साधक के लिए यह परम सुरक्षा है।"
            "देवी ने अब अपने सबसे घातक अस्त्र (काली) को युद्ध के मैदान में उतार दिया था।"
            "अहंकार को लगा था कि वह एक स्त्री से लड़ रहा है, पर अब उसका सामना साक्षात् 'काल' से था।"
            "यह श्लोक अज्ञान के अंत की उस प्रक्रिया को शुरू करता है जिसे कोई रोक नहीं सकता।"
        """.trimIndent(),
        english = """
            (The Emergence of Kali): "Directly from the Goddess's forehead with twisted eyebrows, Mother Kali manifested instantaneously."
            "Her face was exceptionally terrifying, and Her teeth gleamed like apocalyptic lightning."
            "Kali represents that 'Supreme Wisdom' which successfully devours the absolute darkness of ignorance."
            "Emerging from the forehead proves that this power originates from our 'Higher Intuition' (Ajna)."
            "When Attachment (Nishumbha) becomes stubborn, it requires a fierce energy like Kali to terminate it."
            "The demons were entirely incapable of even gazing at the terrifying radiance of Her divine face."
            "This format is absolute terror for the ignorant, but represents total security for the seeker of Truth."
            "The Goddess had now deployed Her most lethal cosmic weapon (Kali) into the heat of battle."
            "Arrogance deluded itself thinking it fought a woman, but it now faced Absolute Time/Death (Kaala)."
            "This verse initiates the irreversible process of the absolute annihilation of deep-seated ignorance."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 22,
        sanskrit = "विचित्रखट्वाङ्गधरा नरमालाविभूषणा ।\nद्वीपिचर्मपरीधाना शुष्कमांसातिभैरवा ॥ २२ ॥",
        hindi = """
            (काली का स्वरूप): "वे विचित्र खट्वांग धारण किए हुए थीं और उनके गले में मुण्डों की माला शोभा दे रही थी।"
            "उन्होंने बाघ की खाल पहनी थी और उनका शरीर सूखे मांस के कारण अत्यंत डरावना लग रहा था।"
            "खट्वांग (Skull-staff) यह याद दिलाता है कि मृत्यु ही इस नश्वर संसार का एकमात्र अंतिम सत्य है।"
            "नरमुंडों की माला 'वर्णमाला' का प्रतीक है, जो देवी को सभी शब्दों और ज्ञान की स्वामिनी बनाती है।"
            "बाघ की खाल (Tiger Skin) अहंकार को मारकर उसे वस्त्र बनाने की अजेय शक्ति का प्रतीक है।"
            "शुष्क मांस (Dried Flesh) यह दर्शाता है कि देवी सांसारिक भोगों और इच्छाओं से पूरी तरह मुक्त हैं।"
            "वे 'विशुद्ध वैराग्य' (Absolute Detachment) का साकार रूप हैं, जिसमें कोई भौतिक आकर्षण नहीं है।"
            "अज्ञान जिस सुंदरता को भोगना चाहता था, वह अब साक्षात् 'वैराग्य और मृत्यु' बन चुकी थी।"
            "यह रूप इंसान के अंदर के उन मोह-बंधनों को तोड़ने के लिए है जो उसे सत्य से दूर रखते हैं।"
            "असुरों के लिए यह दृश्य उनकी अपनी चिता सजने के पहले का सबसे खौफनाक संकेत था।"
        """.trimIndent(),
        english = """
            (The Form of Kali): "She held a strange skull-staff and was adorned with a massive garland of severed heads."
            "Draped in a tiger skin, Her skeletal frame appeared exceptionally terrifying due to dried flesh."
            "The Khatvanga (Skull-staff) serves as a cosmic reminder that 'Death' is the only permanent reality."
            "The garland of skulls symbolizes the 'Alphabets', making Her the mistress of all cosmic knowledge."
            "The tiger skin represents Her power to slaughter the raw 'Ego' and wear it as a trophy."
            "Dried flesh proves that the Goddess is completely liberated from all worldly cravings and consumption."
            "She is the physical embodiment of 'Absolute Detachment', possessing zero traces of material attraction."
            "The beauty that ignorance wished to possess had now transformed into literal 'Detachment and Death'."
            "This form is designed to shatter the chains of attachment that keep humans away from Reality."
            "For the demons, this visual was the most horrifying signal of their impending and certain end."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 23,
        sanskrit = "अतिविस्तारवदना जिह्वललनभीषणा ।\nनिमग्नारक्तनयना नादापूरितदिङ्मुखा ॥ २३ ॥",
        hindi = """
            (भयानक मुख और गर्जना): "उनका मुख बहुत बड़ा था और उनकी लाल जीभ बाहर लपलपा रही थी जो खौफ पैदा करती थी।"
            "उनकी आँखें अंदर धंसी हुई और बिल्कुल लाल थीं, और उनकी गर्जना से दिशाएं गूंज रही थीं।"
            "विशाल मुख 'कॉस्मिक शून्यता' (Void) का प्रतीक है जो अंततः हर चीज़ को खुद में निगल लेगी।"
            "लपलपाती जीभ (Tongue) अज्ञान के 'रक्त' (कर्मों) को सोखने की उस तीव्र इच्छा का प्रतीक है।"
            "लाल आँखें उस 'परम फोकस' को दिखाती हैं जो बुराई को जड़ से खत्म करने के लिए केंद्रित है।"
            "उनकी गर्जना (Roar) साक्षात् 'नाद' है जो अज्ञान के मानसिक सुरक्षा चक्र को एक पल में तोड़ देती है।"
            "यह ध्वनि शत्रुओं के कानों में मौत के संगीत की तरह गूंज रही थी और उन्हें डरा रही थी।"
            "दिशाओं का गूंजना यह बताता है कि सत्य की शक्ति से छुपने के लिए कोई भी जगह नहीं बची है।"
            "काली का यह प्रचंड रूप इंसान के 'प्राइमल फियर' (Primal Fear) को जाग्रत करने वाला है।"
            "रणभूमि अब केवल देवी के अट्टहास और असुरों के डर से पूरी तरह भर चुकी थी।"
        """.trimIndent(),
        english = """
            (Fierce Face and Roar): "Her mouth was stretched wide, and Her lolling tongue created an atmosphere of absolute terror."
            "With sunken blood-red eyes and a roar that filled the directions, She appeared apocalyptically fierce."
            "The wide mouth symbolizes the 'Cosmic Void' that will eventually consume the entire manifested universe."
            "The lolling tongue represents the active fire of 'Rajoguna' ready to absorb the karmas of evil."
            "Deep red eyes illustrate the 'Ultimate Focus' required to systematically uproot all deep-seated vices."
            "Her Roar is the primordial 'Nada' that shatters the psychological defense mechanisms of thick ignorance."
            "This sound resonated in the ears of the enemies like the terrifying music of impending doom."
            "Filling the directions implies that zero space remains in the cosmos to hide from the Truth."
            "This fierce format of Kali is designed to awaken and then dissolve the human 'Primal Fear'."
            "The battlefield was now saturated exclusively with Kali's laughter and the demons' desperation."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 24,
        sanskrit = "सा वेगेनाभिपतिता घातयन्ती महासुरान् ।\nसैन्ये तत्र सुरारीणामभक्षयत तद्बलम् ॥ २४ ॥",
        hindi = """
            (असुर सेना का भक्षण): "वे काली अत्यंत वेग से असुरों की सेना पर टूट पड़ीं और महा-असुरों का वध करने लगीं।"
            "देवताओं के उन शत्रुओं की उस विशाल सेना को वे कच्चा ही चबा-चबाकर खाने लगीं।"
            "काली (समय) जब प्रहार करती है, तो वह किसी तर्क या समझौते का इंतज़ार बिल्कुल नहीं करती।"
            "असुरों को 'खाना' (Eating) अज्ञान को चेतना में वापस 'अब्ज़ॉर्ब' (Absorb) करने की प्रक्रिया है।"
            "जब सत्य बुराई को खा जाता है, तभी इंसान का मन वास्तव में पूरी तरह 'शुद्ध' हो पाता है।"
            "अत्यंत वेग (Speed) यह बताता है कि काल की गति को रोकना किसी भी शक्ति के लिए असंभव है।"
            "सेना का भक्षण करना मतलब इंसान के हज़ारों नेगेटिव विचारों को एक साथ डिलीट कर देना।"
            "राक्षस अब अपनी संख्या बल के बावजूद काली के मुख में समाते जा रहे थे जैसे पतंगे आग में।"
            "यह दृश्य अहंकार के उस पूरे साम्राज्य के पूर्ण विनाश (Annihilation) का जीवंत चित्रण है।"
            "अब अज्ञान का जो शोर था, वह काली की पाचन शक्ति (Digestion) में शांत होता जा रहा था।"
        """.trimIndent(),
        english = """
            (Devouring the Army): "Kali pounced upon the demonic army with exceptional speed and initiated the slaughter."
            "She began chewing and devouring the massive forces of the enemies of the Gods raw."
            "When Kali (Time) strikes, She mathematically waits for zero logic or diplomatic negotiations."
            "Devouring the demons symbolizes the process of 'Absorbing' ignorance back into pure consciousness."
            "Only when Truth consumes evil does the human mind achieve absolute and total 'Purification'."
            "Extreme velocity proves that the momentum of Time cannot be halted by any cosmic force."
            "Devouring the army represents the simultaneous deletion of thousands of negative thought patterns."
            "The demons, despite their numbers, were falling into Kali's mouth like moths into a flame."
            "This scene is a vivid illustration of the 'Total Annihilation' of the empire of arrogance."
            "The noise of ignorance was now being silenced within the digestive fire of the Divine Mother."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 25,
        sanskrit = "पार्ष्णिग्राहाङ्कुशग्राहयोधघण्टासमन्वितान् ।\nसमादायैकहस्तेन मुखे चिक्षेप वारणान् ॥ २५ ॥",
        hindi = """
            (हाथियों का अंत): "उन्होंने महावतों, घंटों और रक्षकों सहित विशाल हाथियों को एक ही हाथ से पकड़ लिया।"
            "और उन सबको एक साथ उठाकर अपने विशाल मुख में निगलने के लिए फेंक दिया।"
            "हाथी (Elephant) इंसान के 'भारी अहंकार' और 'जड़ता' (Mental Inertia) का सबसे बड़ा प्रतीक है।"
            "महावत और रक्षक वे 'कुतर्क' हैं जो उस अहंकार को बचाने की कोशिश करते रहते हैं।"
            "माता ने हाथी और उसके पूरे सपोर्ट सिस्टम को एक ही झटके में खत्म कर दिया।"
            "एक हाथ से हाथी उठाना महाकाली की उस असीमित और अकल्पनीय शक्ति का प्रमाण है।"
            "यह दिखाता है कि जब 'समय' (काली) प्रहार करता है, तो वह बुराई की जड़ को ही उखाड़ देता है। "
            "अज्ञान ने जिस चीज़ को अपनी ढाल माना था, वह देवी के लिए महज़ एक 'निवाला' (Bite) थी।"
            "यह दृश्य अहंकार के उन सभी भारी तर्कों को कुचलने की प्रक्रिया है जो हमें सत्य से रोकते हैं।"
            "रणभूमि अब अज्ञान के इन भारी मलबों से धीरे-धीरे पूरी तरह मुक्त होती जा रही थी।"
        """.trimIndent(),
        english = """
            (Swallowing the Elephants): "She grabbed colossal elephants along with their drivers, bells, and warrior guards with one hand."
            "And She tossed all of them simultaneously into Her massive mouth to be swallowed instantly."
            "The Elephant symbolizes a human's 'Heavy Ego' and stubborn 'Mental Inertia' that resists change."
            "The drivers and guards represent the 'False Logics' utilized to defend and sustain that ego."
            "The Mother eliminated the elephant and its entire support system in a single coordinated movement."
            "Lifting an elephant with one hand proves the 'Infinite and Unimaginable Strength' of Mahakali."
            "This proves that when 'Time' (Kali) strikes, it uproots the very foundation of demonic ignorance."
            "What the Ego perceived as its greatest shield was strictly merely a 'Bite' for the Goddess."
            "This visual represents crushing the heavy arguments of arrogance that prevent us from seeing Truth."
            "The battlefield was now being systematically liberated from the heavy debris of thick ignorance."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 26,
        sanskrit = "तथैव योधं तुरगै रथं सारथिना सह ।\nनिक्षिप्य वक्त्रे दशनैश्चर्वयत्यतिभैरवम् ॥ २६ ॥",
        hindi = """
            (रथ और घोड़ों का विनाश): "उन्होंने घोड़ों सहित योद्धाओं और सारथी सहित पूरे रथ को अपने मुख में डाल लिया।"
            "और उन सबको अपने भयानक दाँतों के बीच रखकर अत्यंत डरावने तरीके से चबाना शुरू किया।"
            "घोड़े (Horses) इंसान की उन 'बेलगाम इन्द्रियों' का प्रतीक हैं जो उसे दुनिया में भटकाती हैं।"
            "रथ (Chariot) मन के उस 'ढांचे' को दर्शाता है जिस पर बैठकर अहंकार सवारी करता है।"
            "सारथी (Driver) उस 'भ्रष्ट बुद्धि' का प्रतीक है जो गलत दिशा में रथ को ले जाती है।"
            "काली का इन सबको चबाना मतलब इंसान के 'गलत थॉट प्रोसेस' का पूरी तरह क्रैश हो जाना।"
            "दाँतों से चबाने की आवाज़ अज्ञान के लिए ब्रह्मांड की सबसे खौफनाक चेतावनी थी।"
            "अहंकार को लगता था कि उसकी मशीनरी उसे बचा लेगी, पर काल के आगे सब बेकार है।"
            "यह श्लोक अज्ञान के 'मैकेनिज्म' (Mechanism) को ही पूरी तरह नष्ट करने की प्रक्रिया है।"
            "अब अज्ञान के पास भागने या बचने का कोई भी भौतिक साधन शेष नहीं बचा था।"
        """.trimIndent(),
        english = """
            (Destruction of Chariots): "She tossed warriors with their horses and chariots with their drivers into Her mouth."
            "She began chewing them between Her terrifying teeth in a highly horrifying and brutal manner."
            "Horses symbolize the 'Uncontrolled Senses' that lead a human astray into worldly illusions."
            "The Chariot represents the 'Mental Framework' upon which the toxic Ego rides and operates."
            "The Driver symbolizes the 'Corrupted Intellect' that steers the personality in the wrong direction."
            "Kali chewing them translates to the total and absolute 'Crash' of a human's wrong thought process."
            "The sound of Her teeth was the absolute most terrifying cosmic warning to the forces of ignorance."
            "Arrogance falsely believed its machinery would protect it, but nothing survives absolute Time."
            "This verse describes the process of destroying the very 'Mechanism' through which ignorance functions."
            "Now ignorance possessed mathematically zero physical means to escape or sustain its survival."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 27,
        sanskrit = "एकं जग्राह केशेषु ग्रीवायामथ चापरम् ।\nपादेनाक्रम्य चैवान्यमुरसान्यमपोथयत् ॥ २७ ॥",
        hindi = """
            (विनाश का तांडव): "किसी को बालों से पकड़ा, किसी की गर्दन दबोची, किसी को पैर से कुचला और किसी को छाती से पटक दिया।"
            "यह महाकाली का वह 'प्रलयंकारी नृत्य' है जहाँ वे शरीर के हर अंग से अज्ञान का संहार कर रही हैं।"
            "बालों से पकड़ना मतलब ईगो के 'झूठे सम्मान' (False Dignity) को पूरी तरह धूल में मिला देना।"
            "गर्दन दबोचना (Choking) उस 'अकड़' को तोड़ने का प्रतीक है जहाँ से अहंकार सांस लेता है।"
            "पैर से कुचलना बुराई को उसकी सबसे 'नीची और असली जगह' (Reality) पर ले आने का संकेत है।"
            "छाती का प्रहार 'हृदय की ऊर्जा' से उस नफरत को दूर फेंकना है जो राक्षसों के अंदर भरी थी।"
            "देवी अब किसी अस्त्र की मोहताज नहीं थीं; उनका पूरा अस्तित्व ही अज्ञान के लिए काल बन गया था।"
            "यह दृश्य दर्शाता है कि जब सत्य जागता है, तो वह 'अनप्रिडिक्टेबल' और अत्यंत शक्तिशाली होता है।"
            "असुरों के पास अब सोचने का भी समय नहीं था, वे केवल मौत का अनुभव कर रहे थे।"
            "यह 'ममता' (निशुम्भ) के साम्राज्य के पतन का सबसे भीषण और अंतिम दृश्य था।"
        """.trimIndent(),
        english = """
            (The Dance of Destruction): "She grabbed some by hair, choked others by neck, crushed some with feet, and slammed others with Her chest."
            "This is Mahakali's 'Apocalyptic Dance' where She utilizes every limb to systematically annihilate ignorance."
            "Grabbing by hair symbolizes reducing the 'False Dignity' of the toxic ego perfectly to zero."
            "Choking the neck represents shattering that 'Stiffness' from which human arrogance draws its life."
            "Crushing with feet signifies dragging evil down to its 'Lowest and True Reality' on the ground."
            "The strike of the chest represents repelling hatred utilizing the absolute raw energy of the 'Heart'."
            "The Goddess required zero weapons now; Her entire existence had become the instrument of Death."
            "This visual proves that when Truth awakens, it is fundamentally Unpredictable and omnipotent."
            "The demons possessed zero time to even think; they were strictly experiencing their absolute end."
            "This was the most fierce and final scene of the total collapse of Nishumbha's empire of Attachment."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 28,
        sanskrit = "तैर्मुक्तानि च शस्त्राणि महास्त्राणि तथासुरैः ।\nमुखेन जग्राह रुषा दशनैर्मथितान्यपि ॥ २८ ॥",
        hindi = """
            (हथियारों का भक्षण): "असुरों ने जो भी शस्त्र और महा-अस्त्र फेंके, माता ने उन्हें अपने मुख में पकड़कर दाँतों से पीस दिया।"
            "राक्षसों के अस्त्र इंसान के उन 'तर्कों' (Logics) और 'बहानेबाज़ी' के प्रतीक हैं जो वे खुद को बचाने के लिए करते हैं।"
            "अहंकार जब घिरता है, तो वह बहुत पैनी और तीखी बातें (शस्त्र) फेंकता है ताकि सत्य को डैमेज कर सके।"
            "परंतु काल (काली) के लिए इंसान के ये सारे तर्क और चालाकियां महज़ एक 'मज़ाक' के समान हैं।"
            "हथियारों को मुंह में पकड़ना यह सिद्ध करता है कि देवी का कोई भी 'बाहरी चोट' कुछ नहीं बिगाड़ सकती।"
            "लोहे के अस्त्रों को दाँतों से चबाना अज्ञान के 'सर्वाइवल मैकेनिज्म' को पूरी तरह क्रैश करने जैसा है।"
            "जब आप सत्य में स्थित होते हैं, तो दूसरों की गालियां या प्रहार आपके लिए केवल 'भोजन' बन जाते हैं।"
            "असुर यह देखकर पूरी तरह टूट गए कि उनका सबसे घातक वार भी देवी के लिए केवल एक 'निवाला' था।"
            "युद्ध अब केवल 'संहार' नहीं, बल्कि अज्ञान के पूर्ण 'एसिमिलेशन' (Assimilation) में बदल चुका था।"
            "सत्य ने अज्ञान के हर 'आउटपुट' को अपने अंदर समेट कर ब्रह्मांड को साफ करना शुरू कर दिया था।"
        """.trimIndent(),
        english = """
            (Devouring the Weapons): "Whatever weapons the demons hurled, the Mother caught them in Her mouth and pulverized them with Her teeth."
            "Demonic weapons symbolize those 'Logics' and 'Excuses' humans utilize to defend their toxic behavior."
            "When trapped, Arrogance hurls sharp and piercing arguments strictly to damage the Absolute Truth."
            "However, for Time (Kali), all these human justifications and cunning maneuvers are merely a pathetic joke."
            "Catching weapons in Her mouth proves that zero 'External Injury' can successfully affect the Divine."
            "Chewing iron weapons represents the total crashing of the 'Survival Mechanism' of deep ignorance."
            "When you are rooted in Truth, the insults or strikes of others strictly become 'Nourishment' for your growth."
            "The demons were shattered upon realizing that their most lethal blow was merely a 'Bite' for the Goddess."
            "The war had transitioned from mere slaughter to the total 'Assimilation' of ignorance into the Divine."
            "Truth was now absorbing every 'Output' of evil to systematically and permanently cleanse the cosmos."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 29,
        sanskrit = "बलिनां तद् बलं सर्वमसुराणां दुरात्मनाम् ।\nममर्दाभक्षयच्चान्यान् अन्यांश्चाताडयत्तथा ॥ २९ ॥",
        hindi = """
            (संपूर्ण विनाश): "उन्होंने उन दुरात्मा असुरों के पूरे बल को कुचल दिया, कुछ को खा लिया और कुछ को पीटकर मार डाला।"
            "यह श्लोक 'कंप्लीट क्लेंज़िंग' (Complete Cleansing) का अंतिम स्टेटमेंट है—काली ने कुछ भी बाकी नहीं छोड़ा।"
            "कुचलना (Crushing) उस अज्ञान के लिए है जो बहुत भारी, पुराना और ज़िद्दी (Stubborn) हो चुका था।"
            "खाना (Eating) उस अज्ञान के लिए है जिसे देवी ने अपनी ऊर्जा में वापस खींचकर 'न्यूट्रल' (Neutral) कर दिया।"
            "और पीटना (Striking) उस बुराई के लिए है जिसे खत्म होने से पहले एक 'कड़ा सबक' देने की ज़रूरत थी।"
            "देवी ने हर विकार (राक्षस) को उसके स्वभाव के हिसाब से सबसे 'सटीक अंत' (Precise End) प्रदान किया।"
            "चण्ड और मुण्ड अब अपनी आँखों के सामने अपनी हज़ारों सालों की मेहनत को राख होते देख रहे थे।"
            "यह दिखाता है कि बुराई चाहे कितनी भी बड़ी क्यों न हो, सत्य के एक प्रहार से वह शून्य हो जाती है।"
            "रणभूमि अब अशुद्धियों से मुक्त हो रही थी और शांति की नई लहर के लिए तैयार हो रही थी।"
            "अहंकार के सभी सहायक अब मर चुके थे, अब केवल मुख्य राक्षसों की बारी थी।"
        """.trimIndent(),
        english = """
            (Complete Destruction): "She crushed the entire strength of those wicked demons, devouring some and battering others to death."
            "This verse serves as the absolute final statement of 'Complete Cleansing'—Kali spared zero remnants of evil."
            "Crushing is the remedy for that ignorance which had become exceptionally heavy, ancient, and stubborn."
            "Devouring is for that specific ignorance which the Goddess pulled back into Her energy to make it 'Neutral'."
            "Striking represents the necessity of delivering a 'Harsh Lesson' to evil before its final termination."
            "The Goddess provided the most 'Precise End' to every mental distortion based on its specific nature."
            "Chanda and Munda were witnessing thousands of years of their accumulated pride turning into ashes."
            "This proves that regardless of the scale of evil, it is reduced to zero by a single strike of Truth."
            "The battlefield was being liberated from impurities and prepared for a brand-new wave of peace."
            "All supporters of Arrogance were now dead; it was finally time for the core demons to face justice."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 30,
        sanskrit = "असिना निहताः केचित् केचित् खट्वाङ्गताडिताः ।\nजग्मुर्विनाशं दैत्येन्द्रा दन्तग्राविपातिताः ॥ ३० ॥",
        hindi = """
            (विनाश के विविध मार्ग): "कई दैत्य तलवार से कटे, कई खट्वांग से पिटे और कई दाँतों के प्रहार से विनाश को प्राप्त हुए।"
            "यह अज्ञान की 'थ्री-लेयर डेथ' (Three-layer Death) को बहुत ही वैज्ञानिक तरीके से दर्शाता है।"
            "तलवार (Wisdom) 'सटीक समझ' है जो ईगो के उन हिस्सों को काटती है जिन्हें समझाया जा सकता है।"
            "खट्वांग (Brute Force) उन विकारों को तोड़ता है जो तर्क नहीं मानते, केवल 'चोट' से ही समझते हैं।"
            "दाँतों का प्रहार 'काल' का वह चक्र है जो हर पुरानी चीज़ को तोड़कर नया बनाने के लिए मजबूर करता है।"
            "असुरों ने जिस शारीरिक बल का घमंड किया था, वह इन प्रहारों के सामने कागज़ की तरह फट गया।"
            "यह श्लोक सिखाता है कि सत्य के पास हर तरह की बुराई का एक 'स्पेशल इलाज' (Special Treatment) होता है।"
            "रणभूमि अब अज्ञान की राख से भर चुकी थी, जहाँ से अब नया सृजन (Creation) होना संभव था।"
            "चण्ड का गुस्सा अब अपनी आखिरी हद को पार कर गया था और वह खुद आगे बढ़ा।"
            "अब युद्ध का वह हिस्सा शुरू होने वाला था जहाँ सेनापतियों का सीधा अंत होगा।"
        """.trimIndent(),
        english = """
            (Diverse Paths of Ruin): "Demons were slaughtered by the sword, battered by the staff, and pulverized by the strike of Her teeth."
            "This scientifically illustrates the 'Three-layer Death' of deep-seated cosmic and human ignorance."
            "The Sword (Wisdom) is 'Precise Understanding' that severs those parts of the Ego that can be reasoned with."
            "The Khatvanga (Brute Force) shatters those vices that reject logic and only respond to 'Hard Impact'."
            "Striking with teeth is the 'Cycle of Time' that forces every ancient thing to dissolve and be reborn."
            "The physical power the demons boasted about tore like common paper when confronted by these divine strikes."
            "This verse teaches that Absolute Truth possesses a 'Special Treatment' for every unique manifestation of evil."
            "The battlefield was now saturated with the ashes of ignorance, making room for a brand-new Creation."
            "Chanda's wrath had now crossed its final limit, forcing him to step forward into the line of fire."
            "The segment of the war where the primary commanders meet their direct end was now officially initiating."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 31,
        sanskrit = "क्षणेन तद्बलं सर्वं निपातं दृष्ट्वा दारुणम् ।\nअभ्यधावत चण्डोऽसौ कालीमभिमुखां रणे ॥ ३१ ॥",
        hindi = """
            (चण्ड का अंतिम प्रहार): "अपनी पूरी सेना को पल भर में नष्ट होते देख चण्ड पागलों की तरह काली की ओर झपटा।"
            "वह अब 'आमने-सामने' (Face-to-face) की लड़ाई के लिए अपनी पूरी शक्ति लगाकर दौड़ रहा था।"
            "चण्ड (Anger) का यह अंतिम प्रयास उसकी 'डेस्परेशन' (Desperation) और हार की छटपटाहट का प्रतीक है।"
            "जब गुस्सा हारता है, तो वह बहुत ज़्यादा हिंसक और 'अनप्रिडिक्टेबल' (Unpredictable) हो जाता है।"
            "वह काली को मारने के लिए आगे बढ़ा, यह भूलकर कि वह साक्षात् 'मौत' के गले मिलने जा रहा है।"
            "यह वह स्थिति है जहाँ अहंकार अपनी आखिरी सांस तक सत्य को स्वीकार नहीं करना चाहता।"
            "अभिमुखां (सामने आना)—सत्य के सामने आना ही अज्ञान के मिटने की पहली और अंतिम शर्त है।"
            "चण्ड को लगा कि वह अपने 'रॉ एंगर' से महाकाली को डरा देगा, जो उसकी सबसे बड़ी मूर्खता थी।"
            "अब ब्रह्मांड की सबसे बड़ी 'डिस्ट्रक्टिव एनर्जी' का मिलन उसके अपने स्रोत (Source) से होने वाला था।"
            "यह युद्ध अब अपने सबसे रोमांचक और निर्णायक (Decisive) मोड़ पर पहुँच चुका था।"
        """.trimIndent(),
        english = """
            (Chanda's Final Charge): "Witnessing his entire army annihilated in a moment, Chanda lunged toward Kali like a maniac."
            "He was sprinting with his total residual strength for a direct 'Face-to-Face' physical confrontation."
            "This final attempt by Chanda (Anger) symbolizes his 'Desperation' and the frantic struggle of a losing ego."
            "When wrath is defeated, it becomes exceptionally violent and completely 'Unpredictable' in its final moves."
            "He advanced to kill Kali, entirely forgetting that he was walking into the absolute embrace of 'Death'."
            "This represents the stage where Arrogance refuses to accept Reality until its very final breath."
            "Coming 'Face-to-Face' (Abhimukham) is the primary and absolute condition for the termination of ignorance."
            "Chanda deluded himself thinking his 'Raw Anger' could terrorize Mahakali, which was his greatest blunder."
            "The absolute largest 'Destructive Energy' of the cosmos was now moving to meet its absolute Source."
            "The war had now successfully reached its most thrilling and absolute Decisive turning point."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 32,
        sanskrit = "शरवर्षैर्महाभीमैर्भीमाक्षीं तां महासुरः ।\nछादयामास चक्रैश्च मुण्डः क्षिप्तैः सहस्रशः ॥ ३२ ॥",
        hindi = """
            (मुण्ड की हताशा): "मुण्ड ने भी हज़ारों चक्र और बाण चलाकर देवी की भयानक आँखों को ढकने की कोशिश की।"
            "वह चाहता था कि देवी की 'दृष्टि' (Vision) रुक जाए ताकि वह उनके करीब पहुँच सके।"
            "मुण्ड (Headless Stupidity) हमेशा सत्य के 'देखने' की क्षमता पर हमला करना चाहता है।"
            "जब इंसान की बुद्धि मरती है, तो वह सबसे पहले 'सच्चाई' से अपनी आँखें मूंदने की कोशिश करता है।"
            "हज़ारों चक्र (Discus) इंसान के वे 'भ्रमित विचार' हैं जो असली समस्या को ओझल करना चाहते हैं।"
            "छादयामास (ढक देना)—अज्ञान हमेशा सत्य को परदों (Layers) के पीछे छिपाने की कोशिश करता है।"
            "परंतु वे मूर्ख भूल गए कि वे जिस पर वार कर रहे हैं, वह खुद 'अनंत आकाश' (Space) है।"
            "आकाश को कभी भी बाणों या चक्रों से ढका नहीं जा सकता, वह हमेशा अछूता (Untouched) रहता है।"
            "मुण्ड का यह हमला केवल उसके 'डर' को दिखा रहा था, उसकी ताकत को नहीं।"
            "अब देवी की हंसी इन हज़ारों हथियारों को धूल में मिलाने के लिए तैयार थी।"
        """.trimIndent(),
        english = """
            (Munda's Desperation): "Munda also attempted to cover the Goddess's terrifying eyes utilizing thousands of discus and arrows."
            "He desperately desired to block Her 'Vision' so he could approach Her without being incinerated."
            "Munda (Headless Stupidity) perpetually targets the capacity of Truth to 'See' and perceive the world."
            "When human intellect fails, its first reaction is to try and blind its own eyes from the 'Reality'."
            "Thousands of Discus represent those 'Confused Thoughts' that aim to cloud the absolute central issue."
            "To 'Cover' (Chhadayamasa) implies that ignorance always seeks to hide Truth behind various deceptive layers."
            "However, the fools forgot that the entity they were attacking is the absolute 'Infinite Space' (Void)."
            "Space can mathematically never be covered by arrows or objects; it remains perpetually Untouched."
            "Munda's assault was merely a display of his internal 'Fear' rather than actual military strength."
            "The Goddess's laughter was now preparing to reduce these thousands of weapons into common dust."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 33,
        sanskrit = "तानि चक्राण्यनेकानि विशमानानि तन्मुखम् ।\nरेजुर्यथार्काबम्बानि सुबहूनि घनोदरम् ॥ ३३ ॥",
        hindi = """
            (अस्त्रों का विलीनीकरण): "मुण्ड के वे चक्र देवी के मुख में ऐसे समा रहे थे जैसे काले बादलों में हज़ारों सूरज विलीन हो जाते हैं।"
            "यह दृश्य काली की उस 'अनंत गहराई' को दिखाता है जिसे कोई भी भौतिक चीज़ भर नहीं सकती।"
            "चक्र (Logics) कितने भी तेज़ और चमकदार हों, वे सत्य की शून्यता (Void) के आगे महज़ खिलौने हैं।"
            "जैसे घने काले बादल सूरज की सारी रोशनी को सोख लेते हैं और उसे अंधेरे में बदल देते हैं।"
            "वैसे ही महाकाली ने अज्ञान के हर 'तर्क' को अपने अंदर सोखकर उसे 'शांत' (Quiet) कर दिया।"
            "ईगो को लगा था कि उसका वार बहुत प्रभावी (Effective) होगा, पर वह केवल एक 'निवाला' बन गया।"
            "यह श्लोक 'कॉस्मिक डाइजेशन' (Cosmic Digestion) का प्रतीक है—नेगेटिविटी को पॉजिटिविटी में बदलना।"
            "जब आप भगवान को सब कुछ समर्पित करते हैं, तो वे आपके दुखों को भी अपनी शक्ति बना लेते हैं।"
            "असुर यह देखकर सन्न रह गए कि उनकी सबसे बड़ी ताकत अब देवी के शरीर का हिस्सा बन चुकी थी।"
            "अब मुण्ड के पास लड़ने के लिए कुछ नहीं बचा था, सिवाय अपनी मौत के इंतज़ार के।"
        """.trimIndent(),
        english = """
            (Merging of Weapons): "Munda's discus were entering Her mouth like thousands of suns vanishing into dark storm clouds."
            "This visual illustrates Kali's 'Infinite Depth' which can never be filled by any physical object."
            "Regardless of how fast or brilliant the Discus (Logics) are, they are toys before the Void of Truth."
            "Just as dense black clouds absorb all the solar light and transform it into absolute darkness."
            "Mahakali absorbed every 'Argument' of ignorance within Herself and rendered them perfectly 'Quiet'."
            "The Ego assumed its strike would be Effective, but it became merely a microscopic 'Bite' for Her."
            "This verse symbolizes 'Cosmic Digestion'—the unique capacity to transform negativity into pure power."
            "When You surrender everything to the Divine, She transforms even Your sorrows into Her own strength."
            "The demons were paralyzed upon seeing their greatest strength becoming a part of the Goddess's being."
            "Munda was now left with zero resources to fight, possessing strictly zero options other than death."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 34,
        sanskrit = "ततो जहासातिरुषा भीमं भैरवनादिनी ।\nकाली करालवक्त्रान्तर्दुर्दर्शदशनोज्ज्वला ॥ ३४ ॥",
        hindi = """
            (काली का अट्टहास): "तब अत्यंत क्रोध में भरकर भयंकर गर्जना करने वाली काली ज़ोर-ज़ोर से हंसने लगीं।"
            "उनके भयानक मुख के भीतर के दाँत बिजली की तरह चमक रहे थे जिन्हें देखना भी मुश्किल था।"
            "यह हंसी (Laughter) अहंकार के उस 'भ्रम' को तोड़ने के लिए थी जहाँ वह खुद को अजेय मानता था।"
            "जब अज्ञान अपनी पूरी ताकत लगा ले और सत्य को खरोंच भी न आए, तो सत्य केवल 'हंसता' है।"
            "दाँतों का चमकना (Gleaming Teeth) यह संकेत है कि वे अब बुराई को पीसने के लिए तैयार हैं।"
            "अहंकार को सबसे ज़्यादा दर्द तब होता है जब उसका 'मज़ाक' उड़ाया जाए या उसे इग्नोर किया जाए।"
            "काली की यह हंसी चण्ड और मुण्ड के मनोवैज्ञानिक पतन का आखिरी सायरन (Siren) थी।"
            "वे अब समझ चुके थे कि वे किसी इंसान से नहीं, बल्कि साक्षात् 'प्रलय' से टकरा गए हैं।"
            "हंसी की यह ध्वनि राक्षसों के आत्मविश्वास को पूरी तरह से चकनाचूर करने वाली थी।"
            "अब केवल अंतिम प्रहार बाकी था जो इस अध्याय का समापन करने वाला था।"
        """.trimIndent(),
        english = """
            (Kali's Apocalyptic Laughter): "Then, filled with extreme wrath and roaring fiercely, Kali initiated a terrifying laugh."
            "Inside Her horrifying mouth, Her teeth gleamed like lightning, making them impossible to gaze upon."
            "This 'Laughter' was designed to shatter the Ego's 'Illusion' of being absolutely invincible and supreme."
            "When ignorance exerts total force and Truth remains untouched, Truth simply 'Laughs' at the futility."
            "The gleaming of teeth (Ujjwala) acts as a cosmic signal that She is now ready to pulverize the evil."
            "The Ego suffers the most when it is 'Mocked' or when its perceived power is completely Ignored."
            "Kali's laughter served as the final psychological siren for the total downfall of Chanda and Munda."
            "They finally realized that they had collided zero with a human, but strictly with 'Absolute Destruction'."
            "The vibration of this laugh was destined to completely pulverize the demons' remaining self-confidence."
            "Only the final physical strike now remained to officially conclude this chapter of the cosmic war."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 35,
        sanskrit = "उत्थाय च महासिंहं देवी चण्डमधावत ।\nगृहीत्वा चास्य केशेषु शिरस्तेनासिनाच्छिनत् ॥ ३५ ॥",
        hindi = """
            (चण्ड का वध): "माता काली अपने महान सिंह पर सवार होकर चण्ड की ओर बहुत तेज़ी से दौड़ीं।"
            "उन्होंने चण्ड को उसके बालों से पकड़ लिया और अपनी तलवार से उसका सिर धड़ से अलग कर दिया।"
            "चण्ड (Anger) का अंत बालों से पकड़कर करना यह दिखाता है कि उसका सारा घमंड कुचल दिया गया।"
            "सिर का कटना (Decapitation) इंसान के 'झूठे ईगो' के केंद्र को हमेशा के लिए डिलीट करने का प्रतीक है।"
            "जब साहस (शेर) और वैराग्य (काली) मिलते हैं, तो गुस्से (चण्ड) की कोई हैसियत नहीं बचती।"
            "तलवार वह 'तीक्ष्ण समझ' है जो एक ही झटके में अज्ञान के मस्तक को काट कर फेंक देती है।"
            "चण्ड का मरना मतलब इंसान के अंदर जलने वाली वह नफरत की आग हमेशा के लिए बुझ जाना।"
            "देवी ने यह वध बहुत ही 'क्लीन' (Clean) तरीके से किया, जो उनकी सुप्रीम मास्टरी को दिखाता है।"
            "अहंकार का पहला मुख्य खंभा अब रणभूमि की धूल में बेजान होकर गिर चुका था।"
            "यह जीत केवल एक राक्षस की नहीं, बल्कि 'क्रोध' के ऊपर 'शांति' की सबसे बड़ी विजय थी।"
        """.trimIndent(),
        english = """
            (The Slaughter of Chanda): "Kali, mounted upon Her majestic Lion, charged toward Chanda with exceptional and terrifying speed."
            "She grabbed Chanda by his hair and cleanly severed his head utilizing Her blazing sharp sword."
            "Ending Chanda (Anger) by grabbing his hair proves that his entire pride was successfully crushed."
            "Decapitation symbolizes the permanent 'Deletion' of the toxic Ego's central processing hub in the mind."
            "When Courage (Lion) and Detachment (Kali) unite, Anger (Chanda) possesses zero capacity to survive."
            "The Sword is that 'Sharp Understanding' which slices through the head of ignorance in one split-second."
            "The death of Chanda implies that the fire of hatred within a human is now extinguished forever."
            "The Goddess executed this slaughter in a very 'Clean' manner, demonstrating Her absolute Supreme Mastery."
            "The first primary pillar of Arrogance now lay lifeless and defeated in the dirt of the battlefield."
            "This victory was zero merely over a demon, but represented the ultimate triumph of 'Peace' over 'Wrath'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 36,
        sanskrit = "अथ मुण्डोऽभ्यधावत्तां दृष्ट्वा चण्डं निपातितम् ।\nतमपपातयद्भूमौ सा खड्गाभिहतं रुषा ॥ ३६ ॥",
        hindi = """
            (मुण्ड का वध): "चण्ड को गिरा हुआ देख मुण्ड पागलों की तरह आगे बढ़ा, पर देवी ने उसे भी तलवार से काट दिया।"
            "मुण्ड (Headless Stupidity) हमेशा चण्ड (Anger) के पीछे-पीछे ही अपनी जान गंवाने के लिए आता है।"
            "जब इंसान का गुस्सा (चण्ड) हारता है, तो उसकी बची-कुची 'मूर्खता' (मुण्ड) भी खुद को बचाने की कोशिश करती है।"
            "परंतु देवी ने अत्यंत क्रोध (रुषा) में उसे भी वही सज़ा दी जो चण्ड को मिली थी।"
            "एक ही तलवार से दोनों का मरना यह सिद्ध करता है कि क्रोध और मूर्खता एक ही सिक्के के दो पहलू हैं।"
            "ज़मीन पर गिरना (Dharanitale) अज्ञान के उस साम्राज्य के पूरी तरह 'कोलैप्स' (Collapse) होने का प्रतीक है।"
            "मुण्ड का अंत यह बताता है कि बिना विवेक के कोई भी ताकत लंबे समय तक टिक नहीं सकती।"
            "देवी की तलवार ने अब अज्ञान के दोनों बड़े 'एन्टेना' (Antennas) काट दिए थे जो शुम्भ को पावर दे रहे थे।"
            "रणभूमि अब इन दोनों महा-असुरों के लहू से लाल हो चुकी थी और सन्नाटा छा गया था।"
            "यह दृश्य ईगो के लिए सबसे बड़ा 'ट्रॉमा' था, जिससे वह कभी उबर नहीं पाया।"
        """.trimIndent(),
        english = """
            (The Slaughter of Munda): "Seeing Chanda fallen, Munda lunged like a maniac, but the Goddess severed him too with Her sword."
            "Munda (Headless Stupidity) perpetually follows Chanda (Anger) only to eventually meet his own certain death."
            "When human wrath (Chanda) is defeated, the remaining 'Stupidity' (Munda) attempts a desperate survival move."
            "However, the Goddess, consumed by absolute wrath, granted him the exact same punishment as his brother."
            "Both dying by the same sword proves that Anger and Stupidity are two sides of the same toxic coin."
            "Falling to the ground symbolizes the absolute 'Collapse' of the entire empire built by deep ignorance."
            "The end of Munda teaches that zero power can mathematically survive long-term without the presence of Wisdom."
            "The Goddess's sword had now severed the two major 'Antennas' of ignorance that powered Shumbha's ego."
            "The battlefield was now blood-soaked and silent, marking the end of these two colossal demonic entities."
            "This visual was the ultimate 'Trauma' for the Ego, from which it was mathematically destined never to recover."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 37,
        sanskrit = "हतशेषं ततः सैन्यं दृष्ट्वा चण्डं निपातितम् ।\nमुण्डं च सुमहावीर्यं दिशो भेजे भयातुरम् ॥ ३७ ॥",
        hindi = """
            (सेना का पलायन): "चण्ड और मुण्ड जैसे अजेय वीरों को मरा हुआ देख बची हुई असुर सेना डर के मारे भाग खड़ी हुई।"
            "वे 'भयातुर' (आतंकित) होकर अपनी जान बचाने के लिए चारों दिशाओं (दिशो) में पागलों की तरह दौड़ने लगे।"
            "यह दिखाता है कि अज्ञान के विचार (सेना) केवल तब तक टिकते हैं जब तक उनका 'भ्रम' (लीडर) ज़िंदा है।"
            "जैसे ही सत्य का प्रकाश मुख्य अज्ञान को मारता है, हज़ारों छोटे-छोटे नेगेटिव विचार खुद ही भाग जाते हैं।"
            "बुराई की सबसे बड़ी कमजोरी उसका 'डर' है, जो जीत के समय तो छुप जाता है पर हारते वक्त बाहर आ जाता है।"
            "दिशो भेजे (दिशाओं में भागना)—मन अब अज्ञान के उस एक केंद्र (Center) से टूटकर बिखर रहा था।"
            "यह वह मानसिक 'रिलीफ' है जब इंसान अपनी किसी पुरानी बुरी लत (Addiction) से आज़ाद महसूस करता है।"
            "राक्षसों का भागना यह प्रमाणित करता है कि सत्य के सामने 'क्वांटिटी' (Quantity) की कोई औकात नहीं होती।"
            "अब रणभूमि पूरी तरह से उन राक्षसों से खाली हो चुकी थी जो देवताओं को सता रहे थे।"
            "केवल शांति का वह मौन बचा था जो अगले बड़े चमत्कार (Naming) की प्रतीक्षा कर रहा था।"
        """.trimIndent(),
        english = """
            (The Army Flees): "Visually witnessing their invincible leaders Chanda and Munda slaughtered, the remaining army fled in terror."
            "Consumed by absolute panic (Bhayaturam), they sprinted blindly in all directions to save their pathetic lives."
            "This proves that thoughts of ignorance (the army) only survive as long as their primary 'Illusion' is intact."
            "The exact moment the light of Truth kills the core ignorance, thousands of minor negative thoughts flee."
            "The greatest weakness of evil is its internal 'Fear', which is hidden during victory but exposed during defeat."
            "Fleeing in all directions implies the mind was now disintegrating from its central point of ignorance."
            "This represents the psychological 'Relief' felt when a human feels liberated from an old toxic addiction."
            "The fleeing demons prove that before the Absolute Truth, 'Quantity' holds zero mathematical value or status."
            "The battlefield was now completely emptied of the monsters that had been tormenting the divine virtues."
            "Only a profound and silent peace remained, awaiting the absolute final cosmic miracle of the naming ceremony."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 38,
        sanskrit = "शिरश्चण्डस्य काली च गृहीत्वा मुण्डमेव च ।\nप्राह प्रचण्डाट्टहासमिश्रमभ्येत्य चण्डिकाम् ॥ ३८ ॥",
        hindi = """
            (काली का समर्पण): "काली ने चण्ड और मुण्ड के कटे हुए सिरों को हाथ में उठाया और चण्डिका के पास जाकर ज़ोर से हंसी।"
            "उन्होंने उन सिरों को माता चण्डिका (अम्बिका) को एक 'भेंट' की तरह समर्पित किया और अपनी जीत की सूचना दी।"
            "यह 'एक्शन' (काली) का 'चेतना' (अम्बिका) के साथ उस परम मिलन का प्रतीक है जहाँ काम पूरा होता है।"
            "कटे हुए सिर 'अहंकार के विनाश' के प्रतीक हैं, जिन्हें अब ईश्वर के चरणों में रख दिया गया है।"
            "प्रचण्ड अट्टहास (Loud Laughter) उस 'विशुद्ध आनंद' को दर्शाता है जो बुराई के खात्मे के बाद महसूस होता है।"
            "काली को इस जीत का कोई घमंड नहीं है, वे केवल अपनी ड्यूटी पूरी करके अपनी मालकिन के पास लौटी हैं।"
            "यह दृश्य हमें सिखाता है कि अपनी हर सफलता का श्रेय (Credit) उस 'परम शक्ति' को देना चाहिए।"
            "जब हम अपनी जीत को समर्पित कर देते हैं, तभी हम 'अहंकार' के अगले हमले से सुरक्षित रह पाते हैं।"
            "अम्बिका और काली अब एक साथ खड़ी थीं, जो ब्रह्मांड की सबसे बड़ी 'पावर-कपल' (Power Couple) लग रही थीं।"
            "अब अज्ञान का वह काला अध्याय हमेशा के लिए बंद होने वाला था।"
        """.trimIndent(),
        english = """
            (Kali's Surrender): "Kali lifted the severed heads of Chanda and Munda and approached Chandika with a thunderous laugh."
            "She offered those heads as a 'Gift' to Mother Chandika (Ambika) and formally reported Her absolute victory."
            "This symbolizes the ultimate union of 'Action' (Kali) with 'Consciousness' (Ambika) upon completing a task."
            "The severed heads are trophies of the 'Destruction of Ego', now placed at the feet of the Divine Power."
            "The thunderous laugh (Attahasa) represents the 'Pure Bliss' experienced after the termination of all evil."
            "Kali holds zero personal pride for this victory; She simply fulfilled Her duty and returned to Her source."
            "This scene teaches us that the 'Credit' for every success must be dedicated strictly to the Supreme Energy."
            "When we surrender our victories, we remain perpetually safe from the next potential attack of arrogance."
            "Ambika and Kali stood together now, appearing as the absolute greatest 'Power Duo' in the entire cosmos."
            "The dark chapter of ignorance was now officially being closed forever with this divine interaction."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 39,
        sanskrit = "मया तवात्रोपहृतौ चण्डमुण्डौ महापशू ।\nयुद्धयज्ञे स्वयं शुम्भं निशुम्भं च हनिष्यसि ॥ ३९ ॥",
        hindi = """
            (काली का वचन): "काली ने कहा: 'मैंने चण्ड और मुण्ड नामक इन दो 'महापशुओं' को मार गिराया है और उन्हें आपको भेंट किया है'।"
            "'अब इस 'युद्ध-यज्ञ' में आप स्वयं शुम्भ और निशुम्भ का संहार करेंगी और ब्रह्मांड को आज़ाद करेंगी'।"
            "यहाँ चण्ड और मुण्ड को 'महापशु' (Beasts) कहा गया है, जो इंसान की पाश्विक वृत्तियों (Animalistic Vices) का प्रतीक है।"
            "तन्त्र में 'युद्ध-यज्ञ' का अर्थ है कि बुराई से लड़ना भी भगवान की सेवा और एक पवित्र पूजा के समान है।"
            "काली बता रही हैं कि उन्होंने 'क्रोध' और 'मूर्खता' को मार दिया है, पर 'अहंकार' को तो केवल 'आत्मज्ञान' ही मारेगा।"
            "शुम्भ और निशुम्भ (I and Mine) का अंत केवल सुप्रीम चेतना (अम्बिका) के सीधे प्रहार से ही संभव है।"
            "यह श्लोक 'डिवीजन ऑफ लेबर' (Division of Labor) का एक दिव्य उदाहरण है—हर शक्ति का अपना रोल होता है।"
            "काली ने अपना काम पूरा कर दिया है और अब वे अगली बड़ी घटना के लिए रास्ता बना रही हैं।"
            "असुरों का आधार अब खत्म हो चुका है, अब केवल उनके राजाओं का सीधा पतन बाकी था।"
            "सत्य की यह यात्रा अब अपने सबसे ऊंचे और अंतिम शिखर की ओर बढ़ रही थी।"
        """.trimIndent(),
        english = """
            (Kali's Statement): "Kali said: 'I have slaughtered these two 'Great Beasts' named Chanda and Munda and offered them to You'."
            "'Now in this 'War-Sacrifice', You shall personally destroy Shumbha and Nishumbha to liberate the universe'."
            "Addressing them as 'Great Beasts' (Mahapashu) symbolizes the unrefined animalistic tendencies within humans."
            "In Tantra, the 'War-Sacrifice' implies that fighting evil is strictly equivalent to a holy ritual of worship."
            "Kali explains She has killed 'Anger' and 'Stupidity', but the 'Ego' requires the strike of 'Self-Realization'."
            "The end of Shumbha and Nishumbha (I and Mine) is only possible through the direct strike of Supreme Awareness."
            "This verse is a divine example of the 'Division of Labor'—every cosmic power has a specific role to play."
            "Kali has successfully completed Her mission and is now clearing the path for the absolute final miracle."
            "The foundation of the demons is destroyed; only the direct collapse of their kings now remains."
            "This journey of Truth was now ascending toward its absolute highest and final cosmic peak."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 40,
        sanskrit = "ऋषिरुवाच ॥ ४० ॥\nतावानीतौ ततो दृष्ट्वा चण्डमुण्डौ महासुरौ ।\nउवाच कालीं कल्याणी ललितं चण्डिका वचः ॥ ४० ॥",
        hindi = """
            (चण्डिका का मधुर वचन): "ऋषि मेधा ने कहा: चण्ड और मुण्ड के कटे हुए सिरों को देखकर कल्याणमयी चण्डिका ने काली से बहुत प्रेम से कहा।"
            "अम्बिका (सुप्रीम पीस) और काली (सुप्रीम विनाश) के बीच का यह संवाद 'सृष्टि और प्रलय' का मिलन है।"
            "कल्याणमयी (Kalyani) शब्द यह बताता है कि यह भीषण वध भी अंततः दुनिया के कल्याण के लिए ही था।"
            "देवी चण्डिका ने खून और सिरों को देखकर कोई घृणा नहीं की, क्योंकि वे 'अद्वैत' (Non-dual) स्थिति में हैं।"
            "वे जानती हैं कि जो आज मरा है, वह केवल एक 'भ्रम' था, असली आत्मा तो कभी मरती ही नहीं।"
            "काली को प्यार से संबोधित करना यह दिखाता है कि भगवान अपने उग्र रूप को भी उतना ही प्रेम करते हैं।"
            "युद्ध के मैदान में इस मधुरता का होना यह सिद्ध करता है कि सत्य हमेशा 'स्थिर' (Stable) और आनंदित रहता है।"
            "अब चण्डिका अपनी उस उग्र शक्ति को वह नाम देने वाली थीं जो युगों-युगों तक गूंजता रहेगा।"
            "यह क्षण एक 'टाइटल सेरेमनी' (Title Ceremony) की तरह था जहाँ वीरता को सम्मानित किया जा रहा था।"
            "पूरे ब्रह्मांड की ऊर्जा अब एक बिंदु पर केंद्रित होकर इस नए नाम का इंतज़ार कर रही थी।"
        """.trimIndent(),
        english = """
            (Chandika's Sweet Words): "The Sage said: Seeing the heads of Chanda and Munda, the benevolent Chandika spoke lovingly to Kali."
            "This dialogue between Ambika (Supreme Peace) and Kali (Supreme Destruction) is the union of Creation and Dissolution."
            "The term 'Kalyani' proves that even this fierce slaughter was executed strictly for the ultimate global welfare."
            "Goddess Chandika felt zero disgust upon seeing blood and severed heads, as She exists in 'Non-duality'."
            "She realizes that what died today was merely an 'Illusion', whereas the authentic Soul is eternally immortal."
            "Addressing Kali affectionately proves that the Divine loves its fierce aspects as much as its gentle ones."
            "Maintaining this sweetness in a battlefield confirms that Truth remains perpetually 'Stable' and blissful."
            "Now Chandika was preparing to grant Her fierce energy that name which would resonate through the ages."
            "This moment was identical to a 'Cosmic Title Ceremony' where raw valor was being officially honored."
            "The entire energy of the universe was now concentrated on one point, awaiting this brand-new nomenclature."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 41,
        sanskrit = "यस्माच्चण्डं च मुण्डं च गृहीत्वा त्वमुपागता ।\nचामुण्डेति ततो लोके ख्याता देवि भविष्यसि ॥ ४१ ॥\n\n(इति श्रीमार्कण्डेयपुराणे सावर्णिके मन्वन्तरे देवीमाहात्म्ये चण्डमुण्डवधो नाम सप्तमोऽध्यायः ॥ ७ ॥)",
        hindi = """
            (चामुण्डा नामकरण और समापन): "चण्डिका ने कहा: 'चूँकि तुम चण्ड और मुण्ड को मारकर मेरे पास आई हो, इसलिए तुम 'चामुण्डा' कहलाओगी'।"
            "यहीं पर 'चण्ड-मुण्ड वध' नामक दुर्गा सप्तशती का सातवां अध्याय पूरी तरह संपन्न होता है।"
            "'चामुण्डा' (Chamunda) नाम 'क्रोध और मूर्खता के पूर्ण विनाश' का सबसे बड़ा और शक्तिशाली मंत्र बन गया।"
            "यह नाम हमें याद दिलाता है कि जब हम अपने विकारों को मारते हैं, तो हमें एक नई दिव्य पहचान मिलती है।"
            "चामुण्डा वह शक्ति है जो इंसान के दिमाग के हर नेगेटिव कोने को एक ही झटके में साफ कर देती है।"
            "इस अध्याय का अंत अज्ञान की बाहरी परतों के पूरी तरह कट जाने की आधिकारिक घोषणा है।"
            "अब मार्ग साफ हो चुका है और 'रक्तबीज' का वह महायुद्ध शुरू होने वाला है जो ध्यान का सबसे कठिन लेवल है।"
            "सत्य की जय हो और अज्ञान का हमेशा के लिए सर्वनाश हो—यही इस अध्याय का मूल संदेश है।"
            "साधक अब इस मंत्र (चामुण्डा) की शक्ति के साथ अपने जीवन के अगले बड़े युद्ध के लिए तैयार है।"
            "यहीं पर मार्कण्डेय पुराण की यह दिव्य कथा अपने एक बहुत ही महत्वपूर्ण पड़ाव को पार कर लेती है।"
        """.trimIndent(),
        english = """
            (The Naming of Chamunda and Conclusion): "Chandika declared: 'Since You brought me the heads of Chanda and Munda, You shall be known as 'Chamunda''."
            "Right here, the Seventh Chapter of the text, named 'The Slaughter of Chanda and Munda', successfully concludes."
            "The name 'Chamunda' became the absolute greatest and most powerful mantra for the total destruction of Anger."
            "This name reminds us that when we successfully slaughter our internal vices, we achieve a new Divine Identity."
            "Chamunda is that cosmic power which cleanses every negative corner of the human brain in a single split-second."
            "The conclusion of this chapter is the formal announcement that the outer layers of ignorance are severed."
            "The path is cleared, and the war against 'Raktabija' (multiplying thoughts) is officially preparing to launch."
            "Victory to Truth and the permanent annihilation of ignorance—this is the absolute core message of this chapter."
            "The practitioner is now equipped with the power of 'Chamunda' to face the absolute next major battle of life."
            "Right here, this divine history from the Markandeya Purana successfully crosses an exceptionally critical milestone."
        """.trimIndent()
    )
)