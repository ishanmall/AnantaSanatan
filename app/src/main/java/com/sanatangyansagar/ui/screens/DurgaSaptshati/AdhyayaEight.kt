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
fun AdhyayaEightScreen() {
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
                    val targetIndex = adhyayaEightShlokas.indexOfFirst { it.id == targetId }
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
            label = { Text("Search Shloka (1-${adhyayaEightShlokas.size})") },
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
            itemsIndexed(adhyayaEightShlokas) { _, shloka ->
                // Automatically uses the SaptshatiCard you already defined in your project!
                SaptshatiCard(shloka = shloka)
            }
        }
    }
}

// Top-Level Data List - Adhyaya 8 (Shlokas 1 to 20)
val adhyayaEightShlokas = listOf(
    SaptshatiShloka(
        id = 1,
        sanskrit = "ऋषिरुवाच ॥ १ ॥\nचण्डे च निहते दैत्ये मुण्डे च विनिपातिते ।\nबहुलेषु च सैन्येषु क्षयितेष्वसुरेश्वरः ॥ २ ॥",
        hindi = """
            (शुम्भ का शोक): "महर्षि मेधा ने कहा: जब अत्यंत भयंकर दैत्य चण्ड युद्ध में मारा गया और मुण्ड भी ज़मीन पर काट कर गिरा दिया गया।"
            "तथा जब असुरों की वह बहुत बड़ी और विशाल सेना पूरी तरह से नष्ट (क्षयितेषु) हो गई।"
            "तब असुरों का राजा शुम्भ (असुरेश्वरः) यह खौफनाक खबर सुनकर गहरे सदमे में डूब गया।"
            "यह अध्याय 'रक्तबीज वध' के नाम से जाना जाता है, जो पूरी सप्तशती का सबसे गहरा मनोवैज्ञानिक युद्ध है।"
            "चण्ड (क्रोध) और मुण्ड (मूर्खता) के मरने के बाद अहंकार (शुम्भ) पूरी तरह से अकेला और असुरक्षित महसूस करने लगता है।"
            "जब इंसान के डिफेंस मैकेनिज्म (गुस्सा और तर्क) टूट जाते हैं, तो उसका मूल अहंकार (Core Ego) सीधे खतरे में आ जाता है।"
            "सेना का क्षय होना बताता है कि अब तक जो विचार उसे सपोर्ट कर रहे थे, वे सब खत्म हो चुके हैं।"
            "शुम्भ का यह सदमा वास्तव में उसके अंदर के उस डर की शुरुआत है जिसे वह अब तक छुपा रहा था।"
            "अहंकार अपनी हार को कभी स्वीकार नहीं कर पाता, इसलिए वह अब अपनी सारी बची हुई ताकत को एक साथ बुलाएगा।"
            "यहाँ से वह महायुद्ध शुरू होगा जहाँ अज्ञान अपनी सबसे गहरी जड़ों (Genetics/Past Karma) को मैदान में उतारेगा।"
        """.trimIndent(),
        english = """
            (Shumbha's Grief): "The Sage Medha stated: Exactly when the terrifying demon Chanda was slaughtered and Munda was permanently struck down."
            "And when the exceptionally massive and colossal demonic army was entirely annihilated and reduced to zero."
            "The King of Demons, Shumbha, was plunged into profound psychological shock upon receiving this horrifying news."
            "This chapter is famous as the 'Slaughter of Raktabija', representing the absolute deepest psychological war in the text."
            "Following the death of Chanda (Anger) and Munda (Stupidity), the Ego (Shumbha) feels entirely isolated and strictly vulnerable."
            "When a human's basic defense mechanisms shatter, the Core Ego mathematically perceives a direct and imminent lethal threat."
            "The annihilation of the army proves that all supporting toxic thoughts have been completely eradicated from the system."
            "Shumbha's shock is actually the pure manifestation of that deep internal terror he had successfully hidden until now."
            "Arrogance mathematically refuses to accept defeat, forcing it to immediately summon absolutely all its remaining reserves."
            "This initiates the cosmic war where thick ignorance deploys its deepest generational roots and past toxic karma into battle."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 2,
        sanskrit = "ततः कोपपराधीनचेताः शुम्भः प्रतापवान् ।\nउद्योगं सर्वसैन्यानां दैत्यानामादिदेश ह ॥ ३ ॥",
        hindi = """
            (शुम्भ का महा-आदेश): "अपने सेनापतियों की मृत्यु के बाद, वह महा-पराक्रमी शुम्भ 'क्रोध के पूरी तरह अधीन' (कोपपराधीनचेताः) हो गया।"
            "उसका मन और बुद्धि गुस्से के पूरी तरह गुलाम बन चुके थे, जिससे उसका सारा विवेक नष्ट हो गया।"
            "उसने तुरंत पाताल लोक में अपनी 'समस्त सेनाओं' (सर्वसैन्यानां) को युद्ध के लिए तैयार होने का आदेश दे दिया।"
            "कोपपराधीन (Slave to anger) होना अज्ञान की वह अवस्था है जहाँ इंसान का अपने ही दिमाग पर कोई कंट्रोल नहीं रहता।"
            "अहंकार जब हारता है, तो वह शांत होने के बजाय एक भयंकर 'सुसाइडल मिशन' (Suicidal Mission) की तरफ बढ़ता है।"
            "उसने अपनी सारी रिज़र्व (Reserve) सेनाओं को बुला लिया, जो यह दिखाता है कि ईगो अब अपने अस्तित्व की आखिरी लड़ाई लड़ रहा है।"
            "यह वह स्थिति है जब इंसान अपनी पूरी एनर्जी, पैसा और ताकत किसी गलत काम को सही साबित करने में लगा देता है।"
            "शुम्भ यह भूल चुका है कि जिस शक्ति ने उसके महा-सेनापतियों को एक पल में मार दिया, वह पूरी सेना को भी खा सकती है।"
            "यह आदेश उसकी हार की हताशा (Desperation) को दर्शाता है।"
            "अब ब्रह्मांड की सबसे बड़ी डार्क फोर्सेज़ (Dark Forces) एक ही मैदान पर जमा होने वाली हैं।"
        """.trimIndent(),
        english = """
            (Shumbha's Ultimate Command): "Following the brutal death of his commanders, the powerful Shumbha became 'Completely enslaved by pure Wrath' (Kopa-paradhina)."
            "His mind and intellect became absolute slaves to anger, permanently destroying his remaining rational wisdom."
            "He instantaneously issued a strict command mobilizing 'Absolutely All Demonic Armies' (Sarva-sainyanam) across the underworld."
            "Being a 'Slave to anger' is that exact stage of ignorance where a human loses total biological control over his own brain."
            "When Ego loses, instead of finding peace, it aggressively accelerates directly toward a completely blind Suicidal Mission."
            "Summoning all reserve armies mathematically proves the ego is now fighting the absolute final battle for its core existence."
            "This perfectly mirrors the human condition of investing total energy and resources strictly to desperately validate a toxic mistake."
            "Shumbha forgets that the exact power which instantly slaughtered his generals can seamlessly devour his entire combined forces."
            "This apocalyptic command explicitly demonstrates the absolute peak Desperation of his impending catastrophic defeat."
            "Now the absolute greatest dark forces of the universe are preparing to strictly assemble upon one single battlefield."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 3,
        sanskrit = "अद्य सर्वबलैर्दैत्याः षडशीतिरुदायुधाः ।\nकम्बूनां चतुरशीतिर्निर्यान्तु स्वबलैर्वृताः ॥ ४ ॥",
        hindi = """
            (असुर कुलों का आह्वान): "शुम्भ ने आदेश दिया: 'आज मेरे आदेश से 'उदायुध' नाम के छियासी (86) दैत्य सेनापति अपनी पूरी सेना के साथ युद्ध के लिए निकलें'।"
            "'और 'कम्बु' नाम के कुल के भी चौरासी (84) सेनापति अपने-अपने बलों से घिरे हुए रणभूमि की ओर कूच करें'।"
            "यह श्लोक बहुत ही 'मैथमेटिकल' (Mathematical) है; इसमें 86 और 84 की संख्या का विशेष तांत्रिक महत्व है।"
            "उदायुध (हमेशा हथियार उठाए हुए) इंसान की उस 'डिफेंसिव' मानसिकता का प्रतीक है जो हर समय लड़ने को तैयार रहती है।"
            "कम्बु (खोल/शंख) उस 'कठोर मानसिकता' (Closed Mindset) का प्रतीक है जो किसी भी नए विचार को स्वीकार नहीं करती।"
            "ये 86 और 84 सेनापति हमारे अवचेतन मन (Subconscious mind) में बैठे हुए पुराने और ज़िद्दी 'थॉट पैटर्न्स' (Thought Patterns) हैं।"
            "शुम्भ अपने अंदर की हर छोटी-बड़ी बुराई को बाहर निकाल रहा है।"
            "जब ध्यान (Meditation) गहरा होता है, तो इंसान के अंदर छुपे हुए ऐसे-ऐसे विकार बाहर आते हैं जिनके बारे में उसे खुद पता नहीं होता।"
            "यह असुरों की फौज असल में हमारी ही उन दबी हुई इच्छाओं और डरों का रूप है।"
            "माता अब इन सभी पुरानी और कठोर मानसिक बीमारियों का जड़ से इलाज करने वाली हैं।"
        """.trimIndent(),
        english = """
            (Summoning the Demonic Clans): "Shumbha commanded: 'Today, let the eighty-six (86) commanders of the Udayudha clan march with their absolute full military force'."
            "'And let the eighty-four (84) supreme generals of the Kambu clan simultaneously march surrounded entirely by their own massive troops'."
            "This verse is highly 'Mathematical'; the precise numbers 86 and 84 hold exceptionally specific advanced Tantric significance."
            "Udayudha (Perpetually armed) symbolizes that hyper-defensive human mentality constantly prepared for an aggressive toxic fight."
            "Kambu (Shell/Conch) symbolizes the absolute 'Closed Mindset' which stubbornly refuses to accept any pure or new wisdom."
            "These 86 and 84 commanders perfectly represent the deeply stubborn and ancient 'Thought Patterns' buried inside our subconscious mind."
            "Shumbha is actively extracting every single microscopic and colossal vice completely from his internal psychological system."
            "Exactly when Meditation becomes profound, deeply concealed toxic distortions emerge that the human never mathematically knew existed."
            "This terrifying demonic army is strictly the physical manifestation of our own deeply suppressed toxic desires and biological fears."
            "The Mother is now officially preparing to completely and permanently cure all these ancient, rigid psychological diseases from their exact roots."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 4,
        sanskrit = "कोटिवीर्याणि पञ्चाशदसुराणां कुलानि वै ।\nशतं कुलानि धौम्राणां निर्गच्छन्तु ममाज्ञया ॥ ५ ॥",
        hindi = """
            (कोटिवीर्य और धौम्र कुल): "'मेरी आज्ञा से 'कोटिवीर्य' नाम के दैत्यों के पूरे पचास (50) कुल (Clans) युद्ध के लिए प्रस्थान करें'।"
            "'और 'धौम्र' नाम के असुरों के भी पूरे सौ (100) कुल आज ही इस महायुद्ध में शामिल होने के लिए निकलें'।"
            "कोटिवीर्य (करोड़ों की ताकत वाले) इंसान के उस भयंकर 'घमंड' का प्रतीक हैं जहाँ उसे लगता है कि उसकी ताकत असीमित है।"
            "पचास (50) की संख्या तन्त्र में मन की 50 वृत्तियों (50 Alphabets/Vrittis) को दर्शाती है, जो अब पूरी तरह दूषित हो चुकी हैं।"
            "धौम्र (धुएं जैसे) वे विचार हैं जो स्पष्ट नहीं होते, बल्कि 'भ्रम' (Confusion) और 'संदेह' (Doubt) पैदा करते हैं।"
            "सौ (100) कुल का मतलब है कि इंसान के दिमाग में कन्फ्यूजन का एक पूरा का पूरा जाल बिछा हुआ है।"
            "अहंकार (शुम्भ) अपनी सारी शक्ति को केवल एक स्त्री (चेतना) को हराने के लिए लगा रहा है।"
            "यह दिखाता है कि सत्य का एक छोटा सा कण भी पूरे अज्ञान को कितना डरा सकता है।"
            "असुरों की यह अनगिनत भीड़ वास्तव में अज्ञान का एक 'मनोवैज्ञानिक कचरा' (Psychological Garbage) है।"
            "देवी की शक्ति इस पूरे कचरे को एक ही युद्ध में साफ करने वाली है।"
        """.trimIndent(),
        english = """
            (Kotivirya and Dhaumra Clans): "'By my strict command, let exactly fifty (50) entire clans of the Kotivirya demons instantly depart for this cosmic war'."
            "'And let precisely one hundred (100) entire clans of the Dhaumra demons march out today to join this apocalyptic battle'."
            "Kotivirya (Possessing the power of millions) flawlessly symbolizes that toxic human Pride assuming its strength is mathematically infinite."
            "The exact number fifty (50) in Tantra mathematically correlates to the 50 mental Vrittis (Alphabets), which are now entirely corrupted."
            "Dhaumra (Smoke-like) perfectly represents those highly unclear thoughts generating massive internal 'Confusion' and thick 'Doubt'."
            "One hundred (100) clans signifies that a complete, intricate, inescapable web of confusion is spread entirely across the human brain."
            "Arrogance (Shumbha) is actively deploying its absolute total cosmic force merely to successfully defeat one single Woman (Consciousness)."
            "This perfectly proves exactly how a microscopic particle of Absolute Truth can completely terrorize massive cosmic ignorance."
            "This uncountable swarming crowd of demons is mathematically nothing but an exceptionally massive pile of 'Psychological Garbage'."
            "The Goddess's pure power is officially preparing to permanently incinerate this entire garbage pile strictly in one singular war."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 5,
        sanskrit = "कालका दौर्हृदा मौर्याः कालकेयास्तथासुराः ।\nयुद्धाय सज्जा निर्यान्तु आज्ञया त्वरिता मम ॥ ६ ॥",
        hindi = """
            (कालक, दौर्हृद, मौर्य और कालकेय): "'कालक, दौर्हृद, मौर्य और कालकेय नाम के सभी भयंकर असुर मेरी आज्ञा सुनते ही'।"
            "'तुरंत पूरी तरह से हथियारों से सजकर (सज्जा) अत्यंत शीघ्रता (त्वरिता) से युद्ध के लिए निकलें'।"
            "इन असुर कुलों के नाम इंसान की डार्क साइकोलॉजी (Dark Psychology) को दर्शाते हैं।"
            "कालक (Black/Time)—वह डिप्रेशन और निराशा जो इंसान को अंदर से पूरी तरह काला और उदास कर देती है।"
            "दौर्हृद (Bad-hearted)—वह क्रूरता और निर्दयता जहाँ इंसान दूसरों का बुरा चाहने लगता है।"
            "मौर्य (Illusion)—वह गहरा मोह और अज्ञान जो इंसान को सच्चाई से दूर रखता है।"
            "कालकेय—वे पुरानी और पैतृक (Ancestral) बुरी आदतें जो पीढ़ियों से दिमाग में बैठी हुई हैं।"
            "शुम्भ इन सबको 'त्वरिता' (जल्दी) बुला रहा है, क्योंकि ईगो जब खतरे में होता है, तो वह पैनिक (Panic) करने लगता है।"
            "यह इंसान के अवचेतन मन का वह 'विस्फोट' (Eruption) है जहाँ सारी छिपी हुई गंदगी बाहर उबल कर आ रही है।"
            "इस श्लोक के साथ शुम्भ का महा-आदेश पूरा होता है, और पाताल से एक भयंकर सैलाब हिमालय की ओर बढ़ने लगता है।"
        """.trimIndent(),
        english = """
            (Kalaka, Daurhrida, Maurya, and Kalakeya): "'Absolutely all terrifying demons named Kalaka, Daurhrida, Maurya, and Kalakeya, upon hearing my command'."
            "'Must instantaneously arm themselves entirely (Sajja) and march to war with extreme, uninterrupted velocity (Tvarita)'."
            "The specific names of these demonic clans flawlessly map directly to the absolute darkest elements of human Psychology."
            "Kalaka (Black)—Symbolizes that heavy, dark depression and hopelessness rendering a human completely black from within."
            "Daurhrida (Bad-hearted)—Represents that toxic cruelty where a human genuinely inherently desires absolute harm for others."
            "Maurya (Deep Illusion)—Symbolizes that extremely thick attachment blinding a human completely from the Absolute Truth."
            "Kalakeya—Represents those highly stubborn Ancestral bad habits programmed directly into the genetics across generations."
            "Shumbha calls them 'Tvarita' (Quickly) because exactly when the Ego is actively threatened, it undergoes absolute psychological Panic."
            "This is the total 'Eruption' of the human subconscious mind where all deeply suppressed toxic filth is boiling to the surface."
            "With this specific verse, Shumbha's ultimate command mathematically concludes, launching a terrifying flood toward the Himalayas."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 6,
        sanskrit = "इत्याज्ञाप्यासुरपतिः शुम्भो भैरवशासनः ।\nनिर्जगाम महासैन्यसहस्रैर्बहुभिर्वृतः ॥ ७ ॥",
        hindi = """
            (शुम्भ का प्रस्थान): "महर्षि ने कहा: अत्यंत भयंकर शासन (भैरवशासनः) करने वाले असुरों के स्वामी शुम्भ ने इस प्रकार की कठोर आज्ञा दी।"
            "और फिर वह स्वयं भी लाखों-करोड़ों असुरों की उस महा-सेना से घिरकर (बहुभिर्वृतः) रणभूमि की ओर निकल पड़ा (निर्जगाम)।"
            "'भैरवशासनः' का अर्थ है वह तानाशाह (Dictator) जिसका राज केवल डर और खौफ पर टिका होता है।"
            "अहंकार (Ego) हमेशा डर पैदा करके ही अपने साम्राज्य को सुरक्षित रखता है।"
            "शुम्भ का 'स्वयं' निकलना यह साबित करता है कि अब मामला उसके हाथ से बाहर जा चुका है।"
            "जब छोटी बुराइयां (चण्ड-मुण्ड, धूम्रलोचन) काम नहीं आतीं, तो मूल अज्ञान को खुद ही मैदान में आना पड़ता है।"
            "लाखों की सेना से घिरे होने का मतलब है कि इंसान का 'मैं' (I-ness) हज़ारों विचारों की परत में लिपटा हुआ है।"
            "यह सेना ब्रह्मांड की सबसे बड़ी नकारात्मक ऊर्जा (Negative Energy) का महासागर थी।"
            "परंतु वह यह नहीं जानता कि वह जिस 'शून्यता' (काली/अम्बिका) से लड़ने जा रहा है, वह असीमित है।"
            "शुम्भ का यह प्रस्थान वास्तव में उसकी अपनी मौत की ओर उठाया गया सबसे बड़ा कदम था।"
        """.trimIndent(),
        english = """
            (Shumbha's Departure): "The Sage said: Having issued this strict command, Shumbha, the Lord of demons possessing a terrifyingly brutal reign (Bhairavashasanah)."
            "Personally departed (Nirjagama) toward the ultimate battlefield, completely surrounded by thousands of colossal demonic armies."
            "'Bhairavashasanah' explicitly describes a toxic Dictator whose entire empire is mathematically sustained exclusively through pure Fear."
            "The Ego (Arrogance) perpetually strictly secures its psychological empire exclusively by generating massive internal and external terror."
            "Shumbha 'Personally' marching strictly proves that the cosmic situation has completely slipped outside his mathematical control."
            "When minor vices fail entirely, the Absolute Core Ignorance is forcefully compelled to enter the battlefield directly."
            "Being surrounded by millions implies that the human 'I-ness' is heavily wrapped inside thousands of protective toxic layers."
            "This assembled army functioned precisely as the absolute largest ocean of Negative Energy in the entire universe."
            "However, he ignores that the precise 'Void' (Kali/Ambika) he is marching to fight is mathematically Infinite."
            "Shumbha's aggressive departure was undeniably his absolute greatest and final physical step strictly toward his own certain death."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 7,
        sanskrit = "आयान्तं चण्डिका दृष्ट्वा तत्सैन्यमतिभीषणम् ।\nज्यास्वनैः पूरयामास धरणीगगनान्तरम् ॥ ८ ॥",
        hindi = """
            (धनुष की टंकार): "उस अत्यंत भयंकर और विशाल असुर सेना को अपनी ओर आते हुए देखकर (आयान्तं दृष्ट्वा)।"
            "माता चण्डिका ने अपने धनुष की डोरी को खींचकर इतनी ज़ोर से 'टंकार' (ज्यास्वनैः) की।"
            "कि उस भयंकर ध्वनि ने पृथ्वी और आकाश के बीच के पूरे स्पेस (धरणीगगनान्तरम्) को पूरी तरह से भर दिया!"
            "यह देवी का 'फर्स्ट रिस्पॉन्स' (First Response) है—अज्ञान के शोर को मिटाने के लिए 'चेतना का नाद' (Cosmic Sound)।"
            "धनुष की टंकार (Twang of the bow) इंसान के 'अवेयरनेस' (Awareness) के जागने का प्रतीक है।"
            "जब करोड़ों नेगेटिव विचार (असुर सेना) मन पर हमला करते हैं, तो उन्हें शांत करने के लिए एक 'पावरफुल वाइब्रेशन' की ज़रूरत होती है।"
            "माता ने कोई तीर नहीं चलाया, केवल ध्वनि (Sound) की, क्योंकि ब्रह्मांड की उत्पत्ति और विनाश ध्वनि से ही होता है।"
            "धरती और आकाश के बीच का स्पेस इंसान के 'कॉन्शस' और 'सबकॉन्शस' माइंड का हिस्सा है।"
            "टंकार की उस आवाज़ ने राक्षसों के कानों के पर्दे फाड़ दिए और उनका सारा 'ओवरकॉन्फिडेंस' चकनाचूर कर दिया।"
            "यह ध्वनि सत्य की वह अलार्म बेल (Alarm Bell) थी जिसने युद्ध की आधिकारिक शुरुआत कर दी।"
        """.trimIndent(),
        english = """
            (The Twang of the Bow): "Visually explicitly witnessing that exceptionally terrifying and massive demonic army actively marching directly toward Her."
            "Mother Chandika aggressively pulled Her bowstring and executed a 'Twang' (Jyasvanaih) of such apocalyptic magnitude."
            "That the terrifying cosmic vibration completely successfully filled the absolute entire space strictly between the Earth and the Sky!"
            "This is the Goddess's absolute 'First Response'—utilizing the 'Cosmic Sound' of Consciousness to permanently silence the noise of ignorance."
            "The twang of the massive bow string mathematically symbolizes the abrupt and powerful awakening of absolute 'Human Awareness'."
            "When millions of toxic negative thoughts attack the mind, a single 'Powerful Vibration' is mathematically required to silence them."
            "The Mother fired zero arrows; She utilized strictly Sound, as the entire cosmos is fundamentally created and destroyed exclusively by Vibration."
            "The exact space between Earth and Sky mathematically represents the entire gap between the human Conscious and Subconscious mind."
            "That precise sound violently shattered the demons' eardrums and completely pulverized their toxic 'Overconfidence' into dust."
            "This vibration was the ultimate cosmic Alarm Bell officially announcing the initiation of the universe's greatest war."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 8,
        sanskrit = "ततः सिंहो महानादमतीव कृतवान् नृप ।\nघण्टास्वनेन तन्नादमम्बिका चोपबृंहयत् ॥ ९ ॥",
        hindi = """
            (सिंह की गर्जना और घंटे की ध्वनि): "हे राजन्! देवी के धनुष की टंकार के तुरंत बाद, उनके वाहन 'सिंह' ने भी अत्यंत भयंकर 'महागर्जना' (महानादम्) की!"
            "और माता अम्बिका ने भी अपने 'घंटे की खौफनाक ध्वनि' (घण्टास्वनेन) बजाकर उस सिंह की गर्जना को और भी ज़्यादा बढ़ा दिया (उपबृंहयत्)!"
            "धनुष की टंकार (जागरूकता) के बाद, शेर (धर्म/साहस) की गर्जना जुड़ जाती है।"
            "जब इंसान सजग होता है, तो उसका अंदरूनी 'साहस' (Lion) भी जाग उठता है और बुराई को ललकारता है।"
            "घंटे की ध्वनि (Bell's sound) तन्त्र में 'काल' (समय) का प्रतीक है जो मृत्यु का संकेत देता है।"
            "इन तीनों ध्वनियों (धनुष, शेर, घंटा) का एक साथ मिलना ब्रह्मांडीय 'रेजोनेंस' (Cosmic Resonance) पैदा करता है।"
            "यह ध्वनि असुरों (नकारात्मक ऊर्जा) के न्यूरल नेटवर्क (Neural Network) को डिसरप्ट (Disrupt) कर रही थी।"
            "बुराई हमेशा अंधेरे और सन्नाटे (Ignorance) में पनपती है; यह भयंकर ध्वनि उस सन्नाटे को फाड़ रही थी।"
            "देवी ने अस्त्र उठाने से पहले असुरों को 'मनोवैज्ञानिक' (Psychologically) रूप से आधा मार दिया था।"
            "यह श्लोक मंत्र विज्ञान (Science of Mantras) की सबसे बड़ी शक्ति को डिकोड करता है।"
        """.trimIndent(),
        english = """
            (The Lion's Roar and the Bell): "O King! Immediately strictly following the bow's twang, Her divine vehicle, the 'Lion', executed an exceptionally terrifying 'Mega-Roar'!"
            "And Mother Ambika successfully actively Amplified (Upabrimhayat) that exact roar entirely by violently ringing the terrifying 'Sound of Her Cosmic Bell'!"
            "Immediately successfully following the Bow (Awareness), the roar of the Lion (Pure Dharma and Courage) flawlessly perfectly unites."
            "When a human successfully becomes highly aware, his internal 'Courage' simultaneously awakens and actively challenges all evil."
            "The sound of the Bell mathematically symbolizes 'Time' (Kaala) inside advanced Tantra, signaling impending cosmic death."
            "The exact simultaneous union of these three pure sounds (Bow, Lion, Bell) successfully generates an apocalyptic 'Cosmic Resonance'."
            "This precise vibration was actively physically Disrupting the exact internal Neural Network of the demons (Negative Energy)."
            "Evil mathematically perpetually breeds strictly inside darkness and silent ignorance; this sound was violently tearing that silence apart."
            "Directly before lifting any physical weapon, the Goddess successfully Psychologically slaughtered the demons halfway to death."
            "This flawless verse perfectly mathematically explicitly decodes the absolute supreme power of the 'Science of Mantras and Vibration'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 9,
        sanskrit = "धनुर्ज्यासिंहघण्टानां नादापूरितदिङ्मुखा ।\nनिनादैर्भीषणैः काली जिग्ये विस्तारितानना ॥ १० ॥",
        hindi = """
            (काली का प्रलयंकारी नाद): "धनुष की डोरी, सिंह की दहाड़ और घंटे की उस भयंकर ध्वनि ने सभी दिशाओं को पूरी तरह से भर दिया था।"
            "उसी समय माता 'काली' ने भी अपना अत्यंत विशाल मुख (विस्तारितानना) खोलकर एक 'प्रलयंकारी चीख' (निनादैर्भीषणैः) मारी!"
            "और काली की उस खौफनाक चीख ने उन तीनों ध्वनियों को भी 'दबा दिया' (जिग्ये)!"
            "यहाँ चार अलग-अलग ध्वनियां (Four Frequencies) एक साथ ब्रह्मांड में गूंज रही हैं।"
            "धनुष (चेतना), सिंह (धर्म), घंटा (समय), और अंत में काली (विनाश/वैराग्य)।"
            "काली की चीख का बाकी ध्वनियों को 'जीत लेना' (जिग्ये) यह दर्शाता है कि अंततः 'मृत्यु और शून्यता' (Kali) ही सबसे शक्तिशाली नाद है।"
            "जब इंसान के अंदर वैराग्य (काली) जागता है, तो वह सबसे ज़ोरदार होता है और सारे सांसारिक शोर को शांत कर देता है।"
            "असुरों की सेना, जो अपने अहंकार के शोर में डूबी हुई थी, इस ध्वनि से 'पैरालाइज' (Paralyzed) हो गई।"
            "यह चीख असुरों के लिए मृत्यु का बिगुल थी, और देवताओं के लिए अभयदान का मंत्र।"
            "सत्य ने अपने नाद (Sound) से ही युद्ध का आधा मैदान जीत लिया था।"
        """.trimIndent(),
        english = """
            (Kali's Apocalyptic Shriek): "The combined terrifying sound of the bowstring, the lion's roar, and the divine bell had entirely completely filled absolutely all directions."
            "At that exact split-second, Mother 'Kali' opened Her exceptionally massive mouth (Vistaritanana) and executed an 'Apocalyptic Shriek'!"
            "And that horrifying cosmic shriek of Kali mathematically effectively 'Overpowered and Conquered' (Jigye) the other three massive sounds!"
            "Here, exactly four distinct absolute 'Frequencies' are simultaneously aggressively vibrating throughout the entire universe."
            "The Bow (Consciousness), the Lion (Dharma), the Bell (Time), and ultimately Kali (Absolute Annihilation and Detachment)."
            "Kali's shriek conquering the others mathematically proves that ultimately, 'Death and Void' (Kali) is the universe's most powerful sound."
            "When pure Detachment (Kali) awakens inside a human, it is the absolute loudest frequency, perfectly silencing all worldly noise."
            "The demonic army, heavily intoxicated by the noise of its own arrogance, became completely 'Paralyzed' by this pure vibration."
            "This shriek was identically the trumpet of absolute death for the demons, and the mantra of fearlessness for the pure Gods."
            "Absolute Truth had successfully flawlessly conquered precisely half the physical battlefield strictly exclusively utilizing its pure Sound."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 10,
        sanskrit = "तं निनादमुपश्रुत्य दैत्यसैन्यैश्चतुर्दिशम् ।\nदेवी सिंहस्तथा काली सरोषैः परिवारिताः ॥ ११ ॥",
        hindi = """
            (सेना द्वारा घेराबंदी): "उन चारों भयंकर और कान फाड़ देने वाली ध्वनियों को सुनकर, दैत्यों की वह विशाल सेना क्रोध से पागल हो उठी।"
            "और उन क्रोधित (सरोषैः) राक्षसों ने चारों दिशाओं (चतुर्दिशम्) से आकर देवी चण्डिका, सिंह और माता काली को पूरी तरह 'घेर लिया' (परिवारिताः)!"
            "अज्ञान (Ignorance) की यह फितरत है—जब वह सच्चाई के शोर से डरता है, तो वह पीछे हटने के बजाय 'हमला' करता है।"
            "राक्षसों का देवी को घेरना इंसान के दिमाग के उस 'ओवरथिंकिंग' (Overthinking) लूप का प्रतीक है।"
            "जब ध्यान (Meditation) के दौरान चेतना जागती है, तो दिमाग के सारे पुराने और गंदे विचार एक साथ मिलकर उसे घेर लेते हैं।"
            "वे चेतना को डराने और वापस सुलाने की कोशिश करते हैं।"
            "परंतु देवी, काली और सिंह—ये तीनों शक्ति, वैराग्य और धर्म की वह 'ट्रिनिटी' (Trinity) हैं जो कभी घिर नहीं सकती।"
            "राक्षसों ने अपनी मौत को खुद ही चारों तरफ से गले लगा लिया था।"
            "वे सोच रहे थे कि संख्या बल (Quantity) से वे 'क्वालिटी' (Quality) को मार देंगे।"
            "अब इस घेरेबंदी को तोड़ने के लिए ब्रह्मांड का सबसे बड़ा चमत्कार होने वाला था।"
        """.trimIndent(),
        english = """
            (The Army Surrounds): "Having physically explicitly heard those four exceptionally terrifying, ear-shattering cosmic sounds, the massive demonic army went insane with rage."
            "And those highly enraged demons (Saroshaih) charged aggressively from all four directions, completely 'Surrounding' Goddess Chandika, the Lion, and Mother Kali!"
            "This is the fundamental nature of Ignorance—when it mathematically fears the pure sound of Truth, it chooses to 'Attack' rather than successfully retreat."
            "The demons surrounding the Goddess mathematically symbolize the exact toxic 'Overthinking' loop inside the human biological brain."
            "During advanced deep Meditation, exactly when consciousness awakens, absolutely all ancient toxic thoughts unite to surround and suppress it."
            "They violently desperately attempt to successfully terrorize pure Consciousness and force it precisely backward into deep sleep."
            "However, the Goddess, Kali, and the Lion strictly form the invincible 'Trinity' of Power, Detachment, and Dharma that can never be trapped."
            "The ignorant demons had flawlessly aggressively actively embraced their own exact death from absolutely all four cosmic directions."
            "They falsely deluded themselves assuming absolute 'Quantity' could successfully mathematically slaughter pure 'Quality'."
            "Now, to physically permanently shatter this siege, the universe's absolute greatest cosmic miracle was preparing to perfectly occur."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 11,
        sanskrit = "एतस्मिन्नन्तरे भूप विनाशाय सुरद्विषाम् ।\nभवायामरसिंहानां अतिवीर्यबलान्विताः ॥ १२ ॥",
        hindi = """
            (मातृकाओं का प्राकट्य - भूमिका): "महर्षि मेधा ने कहा: हे राजा सुरथ! ठीक उसी समय (एतस्मिन्नन्तरे), जब राक्षसों ने देवी को घेर लिया था।"
            "देवताओं के उन भयंकर शत्रुओं (सुरद्विषाम्) का पूरी तरह से 'विनाश' करने के लिए।"
            "और श्रेष्ठ देवताओं (अमरसिंहानां) का परम 'कल्याण' (भवाय) करने के लिए।"
            "अत्यंत भयंकर पराक्रम और असीमित बल से युक्त (अतिवीर्यबलान्विताः) परम शक्तियां प्रकट होने लगीं।"
            "जब इंसान अपनी पूरी ईमानदारी (Integrity) से बुराई के खिलाफ अकेला खड़ा होता है।"
            "तो ब्रह्मांड उसकी मदद के लिए अपनी 'छिपी हुई शक्तियों' (Hidden Forces) को भेज देता है।"
            "यह श्लोक 'सप्त-मातृका' (Seven Divine Mothers) के प्रकट होने का 'इंट्रोडक्शन' (Introduction) है।"
            "ईगो (शुम्भ) ने अपनी सारी बुराइयां (राक्षस) निकाल ली थीं, अब चेतना (देवी) अपनी सारी अच्छाइयां (मातृकाएं) बाहर लाएगी।"
            "यह 'लॉ ऑफ बैलेंस' (Law of Balance) है—जितना बड़ा अज्ञान का हमला होता है, ज्ञान की उतनी ही बड़ी सेना प्रकट होती है।"
            "अब देवताओं के शरीर से उनकी मूल ऊर्जाएं देवी की सहायता के लिए आने वाली थीं।"
        """.trimIndent(),
        english = """
            (The Prologue to the Matrikas): "The Sage Medha declared: O King Suratha! Exactly at that precise split-second, perfectly when the demons had entirely surrounded the Goddess."
            "Strictly explicitly to successfully execute the absolute permanent 'Destruction' of those terrifying enemies of the Gods."
            "And identically flawlessly to ensure the ultimate absolute 'Welfare' and preservation of the supreme divine deities."
            "Supreme cosmic energies, endowed identically with exceptionally terrifying valor and infinite raw force, began to successfully manifest."
            "When a human flawlessly stands absolutely alone against massive evil maintaining pure 100% 'Integrity'."
            "The Cosmos unconditionally automatically successfully dispatches its absolute highest 'Hidden Forces' strictly to assist him."
            "This precise verse perfectly acts strictly as the mathematical 'Introduction' exclusively for the manifestation of the 'Seven Divine Mothers' (Saptamatrikas)."
            "Ego (Shumbha) had fully deployed all its toxic vices; now Consciousness (Goddess) will physically extract all Her divine virtues."
            "This is the strict absolute cosmic 'Law of Balance'—the magnitude of Wisdom's army exactly matches the scale of Ignorance's attack."
            "Now, the absolute core original energies of the Gods are officially preparing to physically emerge specifically to assist the Goddess."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 12,
        sanskrit = "ब्रह्मेशगुहविष्णूनां तथेन्द्रस्य च शक्तयः ।\nशरीरेभ्यो विनिष्क्रम्य तद्रूपैश्चण्डिकां ययुः ॥ १३ ॥",
        hindi = """
            (शक्तियों का निष्क्रमण): "ब्रह्मा, शिव (ईश), कार्तिकेय (गुह), विष्णु और देवराज इन्द्र की जो 'मूल शक्तियां' (शक्तयः) थीं।"
            "वे सभी शक्तियां उन देवताओं के शरीरों से बाहर निकलकर (शरीरेभ्यो विनिष्क्रम्य) प्रकट हुईं।"
            "और वे शक्तियां बिल्कुल 'उन्हीं देवताओं का रूप' (तद्रूपैः) धारण करके माता चण्डिका के पास उनके युद्ध में सहायता के लिए आ गईं (ययुः)!"
            "यह तन्त्र का बहुत गहरा सिद्धांत है: 'शक्ति' के बिना 'शिव' (या कोई भी देवता) कुछ नहीं कर सकता।"
            "देवता यहाँ हमारी 'इन्द्रियों' (Senses) के प्रतीक हैं—जैसे ज्ञान (ब्रह्मा), दृष्टि (शिव), कर्म (इन्द्र)।"
            "जब बुराई बहुत भारी हो जाती है, तो हमारी सारी इन्द्रियां अपनी 'पॉजिटिव एनर्जी' (शक्तियों) को एक जगह (चण्डिका के पास) केंद्रित कर देती हैं।"
            "शरीर से बाहर निकलना यह बताता है कि असली शक्ति शरीर में नहीं, बल्कि 'चेतना' (Consciousness) में होती है।"
            "मातृकाओं (शक्तियों) का आना 'कलेक्टिव अवेयरनेस' (Collective Awareness) का प्रतीक है।"
            "ईगो ने राक्षसों की भीड़ जुटाई थी, तो चेतना ने अपनी 'पवित्र शक्तियों' का नेटवर्क खड़ा कर दिया।"
            "अब अज्ञान का सामना ब्रह्मांड की हर डायमेंशन (Dimension) की ऊर्जा से होने वाला था।"
        """.trimIndent(),
        english = """
            (The Emergence of the Shaktis): "The absolute original 'Core Energies' (Shaktis) belonging precisely to Lord Brahma, Shiva, Kartikeya, Vishnu, and Indra."
            "Absolutely all those specific divine energies explicitly 'Emerged directly outward' strictly from the physical bodies of those exact Gods."
            "And strictly identically assuming the exact 'Physical formats of those respective Gods', those energies perfectly arrived completely successfully to assist Mother Chandika!"
            "This is a profoundly deep mathematical principle of Tantra: strictly without 'Shakti' (Energy), 'Shiva' (Consciousness/Gods) can execute absolutely zero action."
            "The Gods mathematically represent our human 'Senses'—Knowledge (Brahma), Vision (Shiva), and Action (Indra)."
            "When toxic evil becomes exceptionally massive, absolutely all our senses perfectly concentrate their 'Positive Energy' directly into one singular point (Chandika)."
            "Emerging from the body explicitly proves that absolute true power resides zero in the physical flesh, but strictly in 'Pure Consciousness'."
            "The arrival of the Matrikas (Energies) mathematically flawless symbolizes the absolute peak of 'Collective Awareness'."
            "Ego had accumulated a toxic crowd of demons; Consciousness flawlessly countered by establishing a network of 'Sacred Energies'."
            "Now, thick ignorance was officially mathematically destined to successfully securely face the concentrated energy of absolutely every cosmic Dimension."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 13,
        sanskrit = "यस्य देवस्य यद्रूपं यथा भूषणवाहनम् ।\nतद्वदेव हि तच्छक्तिरसुरान् योद्धुमभ्ययात् ॥ १४ ॥",
        hindi = """
            (शक्तियों का स्वरूप): "जिस देवता का जैसा रूप था, जैसे उनके आभूषण थे और जैसा उनका वाहन था।"
            "बिल्कुल उसी रूप, आभूषण और वाहन के साथ (तद्वदेव हि) उस देवता की 'शक्ति' (Shakti)।"
            "असुरों के साथ युद्ध करने के लिए रणभूमि में आ पहुँची (योद्धुमभ्ययात्)!"
            "तन्त्र में शक्ति (Female Energy) देवता (Male Energy) की 'एक्टिव फोर्स' (Active Force) होती है।"
            "ब्रह्मा का रूप 'ज्ञान' है, तो ब्रह्माणी उस ज्ञान को 'एक्ज़ीक्यूट' (Execute) करने वाली ऊर्जा है।"
            "आभूषण (Ornaments) देवताओं की विशिष्ट 'क्वालिटीज़' (Qualities) का प्रतीक हैं।"
            "वाहन (Vehicle) उस 'गति' या 'चैनल' (Channel) का प्रतीक है जिससे वह ऊर्जा काम करती है।"
            "शक्तियों का बिल्कुल देवताओं जैसा होना यह सिद्ध करता है कि ऊर्जा और उसका स्रोत (Source) कभी अलग नहीं होते।"
            "असुरों (राक्षसों) ने इन शक्तियों को पहले कभी इस प्रचंड 'फिमेल फॉर्म' (Female Form) में नहीं देखा था।"
            "अब एक-एक करके सप्त-मातृकाएं (सात देवियां) अपना परिचय और प्रहार दुनिया को दिखाएंगी।"
        """.trimIndent(),
        english = """
            (The Appearance of the Shaktis): "Whatever exact specific physical form a God perfectly possessed, including identically his specific divine ornaments and sacred vehicle."
            "Strictly in that exact mathematically identical identical absolute form, utilizing identically those exact ornaments and precisely that vehicle."
            "The explicit specific 'Active Energy' (Shakti) of that precise God successfully arrived directly into the battlefield explicitly to slaughter the demons!"
            "In advanced Tantra, the Shakti (Female Energy) is identically the strict absolute 'Active Executing Force' of the God (Male Energy)."
            "If Brahma's format is 'Knowledge', then Brahmani is exactly the kinetic energy perfectly actively 'Executing' that pure knowledge."
            "Ornaments mathematically flawless symbolize the specific highly advanced pure 'Qualities' uniquely possessed explicitly by each God."
            "The Vehicle perfectly represents the precise cosmic 'Channel' or velocity entirely through which that specific energy operates."
            "The Shaktis being absolutely mathematically identical to the Gods definitively proves that pure Energy and its Source are permanently inseparable."
            "The demons had absolutely mathematically never visually witnessed these specific cosmic energies strictly operating in such fierce 'Female Forms'."
            "Now, strictly one by one, the Sapta-Matrikas (Seven Divine Mothers) will actively demonstrate their absolute cosmic identity and apocalyptic strikes."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 14,
        sanskrit = "हंसयुक्तविमानाग्रे साक्षसूत्रकमण्डलुः ।\nआयाता ब्रह्मणः शक्तिर्ब्रह्माणी साभिधीयते ॥ १५ ॥",
        hindi = """
            (ब्रह्माणी का प्राकट्य): "सबसे पहले भगवान ब्रह्मा की शक्ति प्रकट हुईं, जो हंसों से जुते हुए विमान (हंसयुक्तविमान) पर सवार थीं।"
            "उनके एक हाथ में रुद्राक्ष की माला (अक्षसूत्र) और दूसरे हाथ में कमण्डलु था।"
            "ब्रह्मा जी की इस परम शक्ति को संसार में 'ब्रह्माणी' (Brahmani) के नाम से जाना जाता है।"
            "ब्रह्माणी 'क्रिएटिव इंटेलिजेंस' (Creative Intelligence) और 'शुद्ध ज्ञान' की प्रतीक हैं।"
            "हंस (Swan) उस 'विवेक' (Discrimination) का प्रतीक है जो झूठ (पानी) से सच (दूध) को अलग कर देता है।"
            "माला (अक्षसूत्र) 'फोकस' (मंत्र जाप) और 'निरंतरता' (Consistency) को दर्शाती है।"
            "कमण्डलु (जल का बर्तन) वह 'पवित्रता' (Purity) है जो मन के सारे विकारों को धो देती है।"
            "जब इंसान के अंदर 'ब्रह्माणी' जागती है, तो वह अपने अज्ञान (असुरों) को केवल तलवार से नहीं, बल्कि 'विवेक' से नष्ट करता है।"
            "यह सबसे पहली शक्ति है क्योंकि अज्ञान से लड़ने के लिए सबसे पहले 'सही ज्ञान' (Right Knowledge) की ज़रूरत होती है।"
            "अहंकार की भीड़ पर अब शुद्ध बुद्धिमत्ता (Intelligence) का प्रहार शुरू होने वाला है।"
        """.trimIndent(),
        english = """
            (The Manifestation of Brahmani): "First to strictly actively emerge was the explicit absolute power of Lord Brahma, mathematically flawlessly seated directly upon a divine chariot yoked securely with beautiful swans."
            "She securely actively perfectly held a sacred 'Rosary' (Akshasutra) in one precise hand and a holy 'Water Pot' (Kamandalu) completely in the other."
            "This exact identical supreme pure specific active energy of Lord Brahma is successfully universally identified explicitly strictly as 'Brahmani'."
            "Brahmani perfectly identically mathematically flawlessly symbolizes absolute 'Creative Intelligence' and completely pure ultimate explicit Wisdom."
            "The Swan flawlessly represents that highly advanced 'Discrimination' successfully accurately explicitly separating absolute Truth (milk) permanently from toxic Lies (water)."
            "The Rosary mathematically strictly signifies absolute unbreakable mental 'Focus' and explicitly pure psychological 'Consistency'."
            "The Kamandalu explicitly accurately perfectly perfectly translates specifically exactly to absolute 'Purity' that flawlessly cleanly completely washes away entirely all mental impurities."
            "Exactly when 'Brahmani' awakens inside a human, he slaughters his thick ignorance entirely zero with a sword, but strictly precisely utilizing pure 'Discrimination'."
            "She actively emerges first mathematically because successfully annihilating ignorance unconditionally strictly requires 'Right Knowledge' directly at the absolute foundation."
            "The massive swarming crowd of deep toxic arrogance is now mathematically prepared to successfully receive the absolute apocalyptic strike explicitly of pure cosmic Intelligence."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 15,
        sanskrit = "कौमारी शक्तिहस्ता च मयूरवरवाहना ।\nयोद्धुमभ्यययौ दैत्यानम्बिका गुहरूपिणी ॥ १६ ॥",
        hindi = """
            (कौमारी का प्राकट्य): "तदनन्तर भगवान कार्तिकेय (गुह) की शक्ति 'कौमारी' रूप धारण करके वहाँ प्रकट हुईं।"
            "वे एक अत्यंत सुंदर 'मयूर' (मोर) पर सवार थीं और उनके हाथ में 'शक्ति' (भाला) नामक अस्त्र था।"
            "वे राक्षसों से युद्ध करने के लिए बिल्कुल कार्तिकेय के समान ही रूप और तेज़ धारण किए हुए थीं।"
            "कार्तिकेय देवताओं के सेनापति हैं, और उनकी शक्ति 'कौमारी' इंसान के 'पराक्रम' (Valor) का प्रतीक है।"
            "मयूर (Peacock) घमंड को नष्ट करने और सुंदरता को सुरक्षित रखने का मनोवैज्ञानिक प्रतीक है।"
            "जब अहंकार से लड़ाई होती है, तो इंसान को एक ठोस 'युद्ध कला' (Strategy) की बहुत आवश्यकता होती है।"
            "कौमारी हमारी वही रणनीतिक बुद्धिमत्ता (Strategic Intelligence) है जो बुराई को समझदारी से मारती है।"
            "हाथ में 'शक्ति' अस्त्र यह बताता है कि हमारा फोकस बिल्कुल सीधा और अचूक होना चाहिए।"
            "अब अज्ञान के सामने केवल बल नहीं, बल्कि युद्ध का 'शुद्ध विज्ञान' (Science of War) खड़ा था।"
            "असुर सेना इस दिव्य और तेजस्वी रूप को देखकर अंदर तक भय से कांप उठी थी।"
        """.trimIndent(),
        english = """
            (The Manifestation of Kaumari): "Subsequently, the active cosmic energy of Lord Kartikeya manifested flawlessly in the form of 'Kaumari'."
            "She was beautifully seated upon an exceptionally majestic 'Peacock' and securely held the divine weapon 'Shakti' (Spear)."
            "She assumed the exact physical form and radiant brilliance of Kartikeya explicitly to slaughter the demons."
            "Kartikeya is the supreme commander of the Gods, and his energy 'Kaumari' symbolizes pure human 'Valor'."
            "The Peacock mathematically represents the destruction of toxic pride while safely preserving inner beauty."
            "When fighting the Ego, a human fundamentally requires highly advanced 'Combat Strategy' to succeed."
            "Kaumari is exactly that 'Strategic Intelligence' which systematically and intelligently annihilates evil."
            "Holding the 'Shakti' spear proves that our mental focus must remain absolutely straight and infallible."
            "Thick ignorance was now facing zero mere brute force, but rather the absolute pure 'Science of War'."
            "The demonic army physically trembled to its core upon witnessing this radiant and highly tactical divine form."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 16,
        sanskrit = "तथैव वैष्णवी शक्तिर्गरुडोपरि संस्थिता ।\nशङ्खचक्रगदाशार्ङ्गखड्गहस्ताभ्युपाययौ ॥ १७ ॥",
        hindi = """
            (वैष्णवी का प्राकट्य): "उसी प्रकार भगवान विष्णु की शक्ति 'वैष्णवी' भी गरुड़ की पीठ पर विराजमान होकर वहाँ आ पहुँचीं।"
            "उन्होंने अपने हाथों में शंख, चक्र, गदा, शार्ङ्ग (धनुष) और खड्ग (तलवार) धारण किए हुए थे।"
            "वैष्णवी साक्षात् 'पालनहार' (Preserver) की ऊर्जा हैं, जो ब्रह्मांड के संतुलन को बनाए रखती हैं।"
            "गरुड़ (Eagle) पर सवारी करना इंसान की 'दूरदृष्टि' (Foresight) और अत्यंत तेज़ गति का प्रतीक है।"
            "विष्णु के आयुध (Weapons) इंसान के 'मैनेजमेंट' (Management) और 'एडमिनिस्ट्रेशन' की शक्तियों को दर्शाते हैं।"
            "शंख (पवित्र ध्वनि), चक्र (समय), गदा (ठोस प्रहार) और धनुष (लक्ष्य)—ये सभी अज्ञान को घेरने के तरीके हैं।"
            "ईगो (असुर) ने जब पूरे सिस्टम को बिगाड़ दिया था, तो उसे ठीक करने के लिए वैष्णवी का आना ज़रूरी था।"
            "यह शक्ति हमें सिखाती है कि केवल विनाश नहीं, बल्कि जीवन का 'संरक्षण' (Protection) भी युद्ध का हिस्सा है।"
            "जब इंसान के अंदर विष्णु की शांति और शक्ति जागती है, तो वह सबसे बड़े तूफानों को भी संभाल लेता है।"
            "रणभूमि में वैष्णवी का प्रवेश ब्रह्मांडीय स्थिरता (Cosmic Stability) की वापसी का सबसे बड़ा संकेत था।"
        """.trimIndent(),
        english = """
            (The Manifestation of Vaishnavi): "Similarly, the active cosmic energy of Lord Vishnu, 'Vaishnavi', arrived perfectly seated upon the divine eagle Garuda."
            "She securely held a Conch, Discus, Mace, Sharnga (Bow), and a razor-sharp Sword directly in Her divine hands."
            "Vaishnavi is the exact energetic manifestation of the 'Preserver', unconditionally maintaining the balance of the universe."
            "Riding the Garuda (Eagle) mathematically symbolizes absolute 'Foresight' and exceptionally high velocity."
            "Vishnu's specific weapons flawlessly represent the human psychological powers of 'Management' and 'Administration'."
            "The Conch (pure sound), Discus (Time), Mace (solid strike), and Bow (target) are systematic methods to trap ignorance."
            "Since the Ego had completely corrupted the system, Vaishnavi's arrival was strictly required for restoration."
            "This energy explicitly teaches that absolute 'Protection' of life is as crucial as the destruction of evil."
            "When Vishnu's peace and power awaken within a human, he effortlessly manages the most terrifying cosmic storms."
            "Vaishnavi's entrance into the battlefield was the absolute greatest signal of returning 'Cosmic Stability'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 17,
        sanskrit = "यज्ञवाराहमतुलं रूपं या बिभ्रतो हरेः ।\nशक्तिः साप्याययौ तत्र वाराहीं बिभ्रती तनुम् ॥ १८ ॥",
        hindi = """
            (वाराही का प्राकट्य): "भगवान विष्णु ने जब यज्ञ-वराह का अतुलनीय रूप धारण किया था।"
            "उसी वराह रूप के समान शरीर धारण करके उनकी शक्ति 'वाराही' भी उस युद्धभूमि में आ पहुँचीं।"
            "वराह (Boar) वह अवतार है जिसने पृथ्वी को पाताल के गहरे कीचड़ से बाहर निकाला था।"
            "जब इंसान का मन डिप्रेशन और बुरी आदतों के 'कीचड़' (Mud) में पूरी तरह धंस जाता है।"
            "तब उसे बाहर निकालने के लिए वाराही जैसी उग्र और ज़मीनी (Grounding) ऊर्जा की ज़रूरत होती है।"
            "इनका मुख सूअर का है, जो बताता है कि प्रकृति कभी-कभी बुराई को खोदकर निकालने के लिए खूंखार रूप लेती है।"
            "वाराही अज्ञान की उन जड़ों पर वार करती हैं जो बहुत गहराई में छिपी होती हैं।"
            "अहंकार को लगता है कि उसकी पाताल की सुरक्षा उसे बचा लेगी, पर वराह की शक्ति हर गहराई को भेद सकती है।"
            "यह मातृका इंसान को 'फोकस' और किसी भी गंदगी में रहकर भी पवित्र रहने की कला सिखाती है।"
            "राक्षसों के लिए यह रूप सबसे ज़्यादा खौफनाक था क्योंकि यह सीधे उनके बेस (Base) को नष्ट करने वाला था।"
        """.trimIndent(),
        english = """
            (The Manifestation of Varahi): "The exact energy of Lord Vishnu when He assumed the incomparable form of the Sacrificial Boar (Yajna-Varaha)."
            "That specific power arrived on the battlefield adopting the exact physical body of a boar, known as 'Varahi'."
            "The Boar is the divine avatar that successfully rescued the Earth from the deep toxic mud of the underworld."
            "When a human mind sinks entirely into the heavy 'Mud' of deep depression and highly toxic habits."
            "It mathematically requires an aggressive, 'Grounding' energy like Varahi to dig it out safely."
            "Her boar-face proves that Nature sometimes adopts a brutal aesthetic strictly to unearth hidden evil."
            "Varahi directly attacks those deep psychological roots of ignorance that are buried far beneath the surface."
            "Arrogance falsely believes its underground defenses are safe, but Varahi's power pierces every depth."
            "This Matrika teaches a human absolute 'Focus' and the art of remaining pure even when surrounded by filth."
            "For the demons, this form was exceptionally terrifying because it directly threatened their foundational base."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 18,
        sanskrit = "नारसिंही नृसिंहस्य बिभ्रती सदृशं वपुः ।\nप्राप्ता तत्र सटाक्षेपक्षिप्तनक्षत्रसंहतिः ॥ १९ ॥",
        hindi = """
            (नारसिंही का प्राकट्य): "भगवान नृसिंह (आधा इंसान, आधा शेर) के समान ही अत्यंत भयानक शरीर धारण करके 'नारसिंही' शक्ति प्रकट हुईं।"
            "जब वे रणभूमि में आईं, तो उनके बालों (सटा) के झटकने मात्र से आकाश के तारे (नक्षत्र) टूटकर गिरने लगे!"
            "नृसिंह अवतार उस 'कठोर न्याय' (Harsh Justice) का प्रतीक है जो किसी भी सीमा या नियम को तोड़ सकता है।"
            "जब अज्ञान (हिरण्यकशिपु) यह मान लेता है कि उसे कोई नहीं मार सकता (सभी वरदानों के कारण)।"
            "तो प्रकृति एक ऐसा 'आउट ऑफ द बॉक्स' (Out of the box) समाधान लाती है जिसकी किसी ने कल्पना नहीं की होती।"
            "नारसिंही वह 'प्रोटेक्टिव एग्रेसन' (Protective Aggression) है जो अपने भक्त को बचाने के लिए ब्रह्मांड हिला देती है।"
            "बालों से तारों का टूटना यह दर्शाता है कि इस शक्ति के सामने ब्रह्मांड का कोई भी भौतिक नियम काम नहीं करता।"
            "अहंकार के पास जितने भी लॉजिक थे, वे सब इस उग्र रूप के आगे फेल होने वाले थे।"
            "वे न इंसान हैं और न जानवर; वे साक्षात् 'डिवाइन कोप' (Divine Wrath) का साकार रूप हैं।"
            "राक्षसों का सारा ओवरकॉन्फिडेंस नारसिंही की एक गर्जना में ही राख हो गया।"
        """.trimIndent(),
        english = """
            (The Manifestation of Narasimhi): "Assuming an exceptionally terrifying body identical to Lord Narasimha (half-man, half-lion), the energy 'Narasimhi' manifested."
            "As She entered the battlefield, the mere tossing of Her mane actively scattered and brought down the cosmic stars!"
            "The Narasimha avatar is the absolute symbol of 'Harsh Justice' that effortlessly breaks every natural boundary."
            "When ignorance falsely believes it is entirely immortal and mathematically immune to all forms of death."
            "Nature instantly generates an 'Out of the Box' solution that no mind could have ever possibly imagined."
            "Narasimhi is that raw 'Protective Aggression' which literally shakes the cosmos strictly to save a pure devotee."
            "Shattering stars with Her mane explicitly proves that absolutely zero physical laws of physics apply to Her."
            "Whatever logic the Ego possessed was destined to fail miserably against this ferocious half-beast form."
            "She is neither human nor animal; She is the physical manifestation of pure 'Divine Wrath'."
            "All the overconfidence of the demons turned to ashes with just one roar from Mother Narasimhi."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 19,
        sanskrit = "वज्रहस्ता तथैवैन्द्री गजराजोपरि स्थिता ।\nप्राप्ता सहस्रनयना यथा शक्रस्तथैव सा ॥ २० ॥",
        hindi = """
            (ऐन्द्री का प्राकट्य): "उसी प्रकार इन्द्र की शक्ति 'ऐन्द्री' (इन्द्राणी) भी ऐरावत नामक हाथियों के राजा पर बैठकर वहाँ पहुँचीं।"
            "उनके हाथ में 'वज्र' था और इन्द्र के समान ही उनके शरीर पर 'हज़ार आँखें' (सहस्रनयना) थीं।"
            "इन्द्र हमारी 'इन्द्रियों' (Senses) के राजा हैं, और ऐन्द्री उन इन्द्रियों की 'कंट्रोलिंग एनर्जी' (Controlling Energy) है।"
            "वज्र (Thunderbolt) वह अस्त्र है जो कभी खाली नहीं जाता; यह हमारे 'परम निश्चय' (Firm Determination) का प्रतीक है।"
            "हज़ार आँखें (Thousand Eyes) का अर्थ है 'कंप्लीट अवेयरनेस' (Complete Awareness) जहाँ कुछ भी छिपा नहीं रह सकता।"
            "जब इंसान अपने चारों तरफ (३६० डिग्री) अवेयर होता है, तो कोई भी नेगेटिव विचार उस पर हमला नहीं कर सकता।"
            "ऐरावत हाथी 'राजसी गौरव' और 'मानसिक स्थिरता' को दर्शाता है।"
            "शुम्भ ने ऐरावत को छीनने का दावा किया था, पर असली ऐरावत तो ऐन्द्री के साथ युद्ध करने आ गया था।"
            "यह दिखाता है कि बुराई केवल 'चीज़ों' की नकल कर सकती है, असली शक्ति हमेशा सत्य के पास होती है।"
            "ऐन्द्री का प्राकट्य देवताओं की खोई हुई सत्ता की आधिकारिक वापसी का संकेत था।"
        """.trimIndent(),
        english = """
            (The Manifestation of Aindri): "Similarly, Indra's energy 'Aindri' arrived, magnificently seated upon Airavata, the king of elephants."
            "She securely held the 'Thunderbolt' (Vajra) and possessed 'A Thousand Eyes', exactly identical to Lord Indra."
            "Indra is the king of our biological 'Senses', and Aindri is the supreme 'Controlling Energy' governing them."
            "The Thunderbolt is a weapon that mathematically never misses; it symbolizes our 'Firm Determination'."
            "Possessing 'A Thousand Eyes' translates precisely to 'Complete Awareness' where absolutely nothing remains hidden."
            "When a human is completely aware in 360 degrees, zero toxic thoughts can successfully execute an ambush."
            "The Airavata elephant effortlessly represents royal cosmic pride and unshakeable psychological stability."
            "Shumbha falsely claimed to have stolen Airavata, but the authentic Airavata arrived here to crush him."
            "This proves that evil can only copy 'Objects', while authentic power mathematically perpetually stays with Truth."
            "Aindri's manifestation was the official cosmic signal of the return of the divine authority of the Gods."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 20,
        sanskrit = "ततः परिवृतस्ताभिरीशानो देवशक्तिभिः ।\nहन्यन्तामसुराः शीघ्रं मम प्रीत्याऽह चण्डिकाम् ॥ २१ ॥",
        hindi = """
            (शिव का आदेश): "इन सभी अत्यंत भयानक और अलौकिक देव-शक्तियों से घिरे हुए भगवान शिव (ईशान) वहाँ प्रकट हुए।"
            "उन्होंने माता चण्डिका से कहा: 'हे देवी! मेरी प्रसन्नता (प्रीत्या) के लिए अब तुम इन सभी असुरों का शीघ्र वध करो'।"
            "यहाँ 'शिव' (Pure Consciousness) और 'शक्तियों' (Active Energies) का मिलन दिखाया गया है।"
            "शिव वह 'मौन' और 'शांत' चेतना हैं जो खुद कोई काम नहीं करते, वे केवल शक्तियों को प्रेरित करते हैं।"
            "जब हमारी सारी इंद्रियां (शक्तियां) जाग जाती हैं, तो हमारा 'मूल स्वरूप' (शिव) उन्हें सही दिशा देता है।"
            "'हन्यन्तामसुराः शीघ्रं' (जल्दी असुरों को मारो)—यह बताता है कि अब ब्रह्मांड का धैर्य समाप्त हो चुका है।"
            "जब बुराई अपनी सारी सीमाएं लांघ जाती है, तो भगवान भी उसे तुरंत खत्म करने का आदेश दे देते हैं।"
            "चण्डिका (महामाया) शिव के इस आदेश को स्वीकार करती हैं, क्योंकि शिव और शक्ति असल में एक ही हैं।"
            "यह श्लोक साबित करता है कि अज्ञान (ईगो) को मारने के लिए शिव (Focus) और शक्ति (Action) दोनों का तालमेल ज़रूरी है।"
            "अब युद्ध का वह चरण शुरू होने वाला है जहाँ देवियां केवल हमला नहीं, बल्कि संदेश भी भेजेंगी।"
        """.trimIndent(),
        english = """
            (The Command of Shiva): "Completely surrounded by all these terrifying and divine cosmic energies, Lord Shiva (Ishana) physically manifested."
            "He explicitly instructed Mother Chandika: 'O Goddess! For My pleasure, slaughter all these demons quickly'."
            "This precisely illustrates the ultimate merger of 'Shiva' (Pure Consciousness) and 'Shaktis' (Active Energies)."
            "Shiva is the 'Silent' consciousness who physically executes zero action; He merely inspires the active forces."
            "When all our senses (energies) successfully awaken, our 'Core Nature' (Shiva) provides them with accurate direction."
            "'Slaughter the demons quickly'—this explicitly proves that the patience of the entire cosmos is finally exhausted."
            "When evil successfully crosses every conceivable boundary, even the Peaceful Lord issues a strict termination order."
            "Chandika unconditionally accepts Shiva's command, primarily because Shiva and Shakti are mathematically one singular entity."
            "This verse proves that annihilating ignorance strictly requires the perfect synchronization of Focus (Shiva) and Action (Shakti)."
            "The war now enters a phase where the Goddesses will not merely attack, but deliver an absolute final warning."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 21,
        sanskrit = "ततो देवीशरीरात्तु विनिष्क्रान्तातिभीषणा ।\nचण्डिकाशक्तिरत्युग्रा शिवाशतनिनादिनी ॥ २२ ॥",
        hindi = """
            (शिवदूती का प्राकट्य): "भगवान शिव की बात सुनते ही, देवी चण्डिका के शरीर से एक अत्यंत भयानक और उग्र शक्ति प्रकट हुई।"
            "यह शक्ति इतनी खौफनाक थी कि उसकी आवाज़ 'सैकड़ों सियारों' (शिवाशतनिनादिनी / Jackals) के रोने जैसी गूंज रही थी।"
            "यह 'शिवदूती' (Shiva Duti) का जन्म है, जो देवी का सबसे 'अनप्रिडिक्टेबल' (Unpredictable) रूप है।"
            "जब इंसान का ईगो बहुत ज़्यादा ज़िद्दी हो जाता है, तो उसे तोड़ने के लिए एक झकझोरने वाली ऊर्जा चाहिए।"
            "सियारों की रोने जैसी आवाज़ (Howling) अपशकुन और मौत का स्पष्ट संकेत है।"
            "अहंकार को डराने के लिए देवी ने यह ऐसा रूप लिया है जो किसी भी तरह की सभ्यता (Civility) से परे है।"
            "यह शक्ति दिखाती है कि सत्य हमेशा सुंदर और आकर्षक नहीं होता; कभी-कभी वह बहुत कड़वा और डरावना होता है।"
            "देवी के शरीर से इसका निकलना यह प्रमाणित करता है कि शांति के भीतर भी प्रलय की अपार क्षमता छुपी है।"
            "अब यह उग्र शक्ति स्वयं भगवान शिव को अपना 'दूत' (Messenger) बनाकर राक्षसों के पास भेजेगी।"
            "यह अहंकार का सबसे बड़ा मानसिक अपमान (Psychological Insult) होने वाला है।"
        """.trimIndent(),
        english = """
            (Manifestation of Shiva Duti): "Exactly upon hearing Lord Shiva's words, an exceptionally terrifying and fierce energy emerged from Goddess Chandika's body."
            "This energy was so horrifying that Her voice echoed exactly like the terrifying howling of 'Hundreds of Jackals'."
            "This is the birth of 'Shiva Duti', undeniably the absolute most 'Unpredictable' and unorthodox format of the Goddess."
            "When a human's ego becomes excessively stubborn, it mathematically requires a highly shocking energy to break it."
            "The howling sound of jackals is the explicit universal symbol of bad omens and impending absolute death."
            "To successfully terrorize arrogance, the Goddess adopted a form that operates entirely outside the boundaries of Civility."
            "This energy proves that Truth is zero always beautiful; it is sometimes exceptionally bitter, raw, and frightening."
            "Her emergence from the Goddess's body proves that infinite apocalyptic capacity is safely hidden inside supreme peace."
            "Now this fierce energy will explicitly utilize Lord Shiva Himself as Her 'Messenger' to the demons."
            "This is actively preparing to be the absolute greatest 'Psychological Insult' to the bloated demonic ego."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 22,
        sanskrit = "सा चाह धूम्रजटिलमीशानमपराजिता ।\nदूत त्वं गच्छ भगवन् पार्श्वं शुम्भनिशुम्भयोः ॥ २३ ॥",
        hindi = """
            (शिव को दूत बनाना): "उस अपराजिता शक्ति ने धुएं के समान जटाओं वाले भगवान शिव (ईशान) से कहा।"
            "'हे भगवन! आप स्वयं मेरे 'दूत' (Messenger) बनकर उन घमंडी शुम्भ और निशुम्भ के पास जाइए'।"
            "यह तन्त्र का सबसे बड़ा 'शिफ्ट ऑफ पावर' (Shift of Power) है—जहाँ देवी भगवान शिव को आदेश दे रही हैं।"
            "शिव (देवों के देव) को 'दूत' बनाना यह दिखाता है कि जब 'शक्ति' एक्टिव होती है, तो शिव भी उसके सहायक बन जाते हैं।"
            "शुम्भ ने एक साधारण राक्षस (सुग्रीव) को दूत बनाकर भेजा था; देवी ने जवाब में साक्षात् 'महादेव' को दूत बना दिया।"
            "यह ईगो को उसकी असली औकात दिखाने का तरीका है—कि तुम जिससे लड़ रहे हो, उसके नौकर भी भगवान हैं।"
            "अपराजिता (जिसे हराया न जा सके) का यह आदेश अहंकार के कूटनीतिक (Diplomatic) खेल का अंतिम जवाब है।"
            "सत्य कभी भी अपने दुश्मनों को भी बिना 'फेयर चांस' (Fair chance) दिए नहीं मारता।"
            "शिव का दूत बनकर जाना यह सिद्ध करता है कि परमात्मा किसी भी तरह के ईगो (घमंड) से पूरी तरह मुक्त है।"
            "अब शिव वह 'अल्टीमेटम' (Ultimatum) देंगे जिसके बाद केवल विनाश बचेगा।"
        """.trimIndent(),
        english = """
            (Making Shiva the Messenger): "That invincible energy strictly instructed Lord Shiva, whose matted hair appeared exactly like dark smoke."
            "'O Lord! You must personally act as my 'Messenger' and directly approach the arrogant Shumbha and Nishumbha'."
            "This represents the absolute greatest 'Shift of Power' in Tantra—where the Goddess actively issues commands to Shiva."
            "Making the God of Gods a 'Messenger' proves that when 'Shakti' activates, Shiva flawlessly becomes Her assistant."
            "Shumbha dispatched an ordinary demon (Sugriva) as a messenger; the Goddess retaliated by sending the Supreme Lord."
            "This is the cosmic method of showing the Ego its true place—revealing that Her servants are literal Gods."
            "This command by Aparajita (The Invincible) is the absolute final response to the Ego's pathetic diplomatic games."
            "Absolute Truth mathematically never slaughters even its worst enemies without explicitly providing a 'Fair Chance'."
            "Shiva accepting the role of messenger proves that the Supreme Divine is 100% completely liberated from all ego."
            "Now Shiva will actively deliver the absolute 'Ultimatum', after which mathematically nothing but destruction will remain."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 23,
        sanskrit = "ब्रूहि शुम्भं निशुम्भं च दानवावतिगर्वितौ ।\nये चान्ये दानवास्तत्र युद्धाय समुपस्थिताः ॥ २४ ॥\nत्रैलोक्यमिन्द्रो लभतां देवाः सन्तु हविर्भुजः ।\nयूयं प्रयात पातालं यदि जीवितुमिच्छथ ॥ २५ ॥",
        hindi = """
            (देवी का अल्टीमेटम): "'उन अत्यंत घमंडी दानवों (शुम्भ-निशुम्भ) और वहाँ युद्ध के लिए खड़े अन्य सभी राक्षसों से जाकर कहिए'।"
            "'कि इन्द्र को उनका त्रिलोक (स्वर्ग) वापस दे दो, और देवताओं को उनके यज्ञ का भाग फिर से मिलने दो'।"
            "'और तुम सब राक्षस तुरंत 'पाताल' (Underworld) में चले जाओ, यदि तुम अपने प्राणों की भीख (जीवित) चाहते हो'।"
            "यह देवी का 'अंतिम प्रस्ताव' (Final Offer) है—सरेंडर करो या मरो।"
            "इन्द्र को सत्ता वापस देना मतलब इंसान के अंदर के 'सद्गुणों' (Virtues) को वापस उनका हक़ दिलाना।"
            "यज्ञ का भाग देवताओं को देना मतलब हमारी पॉजिटिव एनर्जी का सही जगह पर इस्तेमाल होना।"
            "पाताल (Underworld) का अर्थ है मन की सबसे गहरी और छिपी हुई जगह (Subconscious)।"
            "देवी कह रही हैं कि अज्ञान को सतह (Conscious mind) पर राज करने का कोई हक़ नहीं है, उसे वापस अंधेरे में जाना होगा।"
            "यह श्लोक बताता है कि भगवान कभी किसी को बिना चेतावनी के नष्ट नहीं करते।"
            "पर अहंकार कभी भी सत्ता छोड़कर 'पाताल' जाने को तैयार नहीं होता, यही उसकी मौत का कारण बनता है।"
        """.trimIndent(),
        english = """
            (The Goddess's Ultimatum): "'Explicitly tell those exceptionally arrogant demons, Shumbha and Nishumbha, and all other monsters assembled for war'."
            "'Return the three worlds entirely back to Indra, and let the Gods rightfully receive their sacrificial oblations again'."
            "'And absolutely all of you must instantaneously retreat to the 'Underworld' (Patala) if you wish to remain alive'."
            "This is the Goddess's absolute 'Final Offer'—mathematically strictly dictating: Unconditional Surrender or Certain Death."
            "Returning the empire to Indra mathematically translates to restoring absolute power to human 'Sattvic Virtues'."
            "Returning the sacrifices to the Gods ensures that our positive life energy is utilized strictly for pure purposes."
            "Patala (Underworld) symbolizes the absolute deepest and darkest hidden layers of the human Subconscious mind."
            "The Goddess commands that ignorance holds zero right to rule the Conscious mind; it must return to the darkness."
            "This flawless verse proves that God absolutely never slaughters any entity without issuing a completely fair warning."
            "However, arrogance mathematically never voluntarily relinquishes power to live in darkness, sealing its own death."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 24,
        sanskrit = "बलावलेपादमिवो भवन्तो यदि वोद्धताः ।\nतदागच्छत तृप्यन्तु मच्छिवाः पिशितेन वः ॥ २६ ॥\nयतो नियुक्तो दूत्येन तया देव्या शिवः स्वयम् ।\nशिवदूतीति लोकेऽस्मिंस्ततः सा ख्यातिमागता ॥ २७ ॥",
        hindi = """
            (युद्ध की चुनौती और शिवदूती नाम): "'परंतु यदि तुम अपने बल के घमंड (बलावलेपा) में अंधे होकर युद्ध करना ही चाहते हो'।"
            "'तो फिर मैदान में आओ! मेरी ये सियारिनें (शिवाः) तुम्हारे कच्चे मांस (पिशितेन) से अपनी भूख मिटाएंगी'।"
            "'क्योंकि उस उग्र देवी ने स्वयं भगवान शिव को अपना दूत (Messenger) बनाकर भेजा था'।"
            "'इसलिए इस पूरे संसार में वह शक्ति 'शिवदूती' (Shiva Duti) के इस महान नाम से विख्यात हो गई'।"
            "यह अहंकार के लिए 'ओपन चैलेंज' है—अगर तुम लॉजिक (सरेंडर) नहीं मानते, तो मेरी 'भूख' का शिकार बनो।"
            "सियारिनों का कच्चा मांस खाना इस बात का प्रतीक है कि प्रकृति बुरी आदतों को बहुत ही क्रूर तरीके से रिसाइकिल (Recycle) करती है।"
            "शिव को दूत बनाने के कारण ही उन्हें 'शिवदूती' कहा गया, जो उनके 'सुप्रीम अथॉरिटी' (Supreme Authority) होने का प्रमाण है।"
            "ईगो (शुम्भ) को अब साक्षात् 'महादेव' के मुख से अपनी मौत की चेतावनी मिल चुकी थी।"
            "यह अध्याय के पहले भाग का समापन है, जहाँ बातचीत के सारे दरवाज़े हमेशा के लिए बंद हो जाते हैं।"
            "अब जो शुरू होगा, वह सिर्फ 'रक्त' (Blood) और 'प्रहार' (Strikes) का भीषण खेल होगा।"
        """.trimIndent(),
        english = """
            (The Challenge and Naming of Shiva Duti): "'But if you remain aggressively blind and stubborn due to the extreme pride of your strength'."
            "'Then step into the battlefield! My howling jackals shall entirely satisfy their hunger using your raw flesh'."
            "'Strictly because that fierce Goddess explicitly appointed Lord Shiva Himself as Her messenger'."
            "'She became universally famous and eternally renowned in this world by the supreme name 'Shiva Duti''."
            "This is a direct 'Open Challenge' to the Ego—if you reject logical surrender, become the victim of My hunger."
            "Jackals eating raw flesh mathematically symbolizes how Nature brutally Recycles completely toxic and wicked habits."
            "She is named 'Shiva Duti' exclusively because She utilized Shiva as a messenger, proving Her absolute Supreme Authority."
            "The Ego (Shumbha) had now received its official death warning directly from the mouth of Mahadeva Himself."
            "This flawlessly concludes the first phase of the chapter, permanently locking all doors to peaceful negotiation."
            "What immediately follows now is mathematically purely an apocalyptic game consisting exclusively of Blood and Strikes."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 25,
        sanskrit = "तेऽपि श्रुत्वा वचो देव्याः शर्वाख्यातं महासुराः ।\nअमर्षापूरिता जग्मुर्यत्र कात्यायनी स्थिता ॥ २८ ॥",
        hindi = """
            (राक्षसों का हमला): "भगवान शिव (शर्व) के मुख से देवी के वे अपमानजनक और कठोर वचन सुनकर।"
            "वे सभी महा-असुर 'अत्यंत क्रोध और जलन' (अमर्षापूरिता) से पूरी तरह पागल हो उठे।"
            "और वे तुरंत अपने हथियार उठाकर उस स्थान की ओर दौड़ पड़े जहाँ माता 'कात्यायनी' (चण्डिका) विराजमान थीं।"
            "अहंकार को जब सत्य की 'धमकी' मिलती है, तो वह आत्मनिरीक्षण (Self-reflection) करने के बजाय भड़क उठता है।"
            "भगवान शिव ने उन्हें जीवनदान का ऑफर दिया था, पर अज्ञान ने उसे 'अपमान' समझ लिया।"
            "अमर्ष (जलन) वह आग है जो इंसान को अंदर से खोखला कर देती है और उसे गलत दिशा में दौड़ाती है।"
            "यहाँ देवी को 'कात्यायनी' कहा गया है, जो 'क्रोध और न्याय' (Anger and Justice) का एक और प्रचंड रूप है।"
            "राक्षसों का देवी की ओर दौड़ना यह दिखाता है कि बुराई खुद चलकर अपनी मौत के पास जाती है।"
            "ईगो के पास अब कोई 'डिफेंस' नहीं है, वह केवल अंधाधुंध 'अटैक' (Attack) करना जानता है।"
            "रणभूमि अब उस महासंग्राम के लिए पूरी तरह तैयार थी जिसे ब्रह्मांड कभी नहीं भूलेगा।"
        """.trimIndent(),
        english = """
            (The Demonic Attack): "Hearing those harsh, insulting, and explicit words of the Goddess directly from the mouth of Lord Shiva."
            "All those mega-demons became completely insane and engulfed entirely in 'Absolute Wrath and Jealousy' (Amarsha)."
            "And they immediately raised their weapons and sprinted aggressively toward the exact location where Mother 'Katyayani' resided."
            "When Arrogance receives a direct warning from Truth, it actively flares up instead of engaging in Self-reflection."
            "Lord Shiva had explicitly offered them a chance to live, but thick ignorance mathematically perceived it as an 'Insult'."
            "Amarsha (Jealousy) is that specific internal toxic fire which hollows a human and forces him in the wrong direction."
            "The Goddess is addressed here as 'Katyayani', representing yet another fierce format of absolute Anger and Justice."
            "The demons sprinting toward the Goddess proves that evil voluntarily mathematically walks straight into its own death."
            "The Ego now possesses zero tactical 'Defense'; it strictly only knows how to execute a blind, desperate 'Attack'."
            "The cosmic battlefield was now entirely completely prepared for that apocalyptic war the universe would never forget."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 26,
        sanskrit = "ततः प्रथममेवाग्रे शरशक्त्यृष्टिवृष्टिभिः ।\nववर्षुरुद्धतामर्षास्तां देवीममरारयः ॥ २९ ॥",
        hindi = """
            (असुरों की अस्त्र वर्षा): "वहाँ पहुँचते ही, अत्यंत घमंड और क्रोध से भरे हुए उन देवताओं के शत्रुओं (अमरारयः) ने।"
            "सबसे पहले आगे बढ़कर माता के ऊपर भयंकर बाणों (शर), शक्तियों और ऋष्टियों (तलवारों) की भारी 'बारिश' (वृष्टिभिः) कर दी!"
            "यह अज्ञान का 'प्री-एम्प्टिव स्ट्राइक' (Pre-emptive Strike) है—वे देवी को संभलने का मौका नहीं देना चाहते थे।"
            "बाण, शक्तियां और तलवारें इंसान के उन 'कुतर्कों' और 'नकारात्मक विचारों' का प्रतीक हैं जो सत्य को ढकना चाहते हैं।"
            "अहंकार हमेशा 'फर्स्ट मूव' (First Move) करके यह जताना चाहता है कि वह बहुत ताकतवर है।"
            "हथियारों की बारिश यह बताती है कि जब ईगो टूट रहा होता है, तो वह एक साथ हज़ारों झूठे बहाने फेंकता है।"
            "परंतु वे मूर्ख भूल गए कि वे जिस पर अस्त्र फेंक रहे हैं, वह खुद अस्त्रों की जननी (Mother of Weapons) हैं।"
            "यह हमला देवी को नुकसान पहुँचाने के लिए नहीं, बल्कि राक्षसों के 'डर' को छिपाने के लिए था।"
            "अब देवी की ओर से वह प्रतिक्रिया (Reaction) आएगी जो इस बारिश को एक ही पल में रोक देगी।"
            "महामाया अब अपने खेल का अगला चरण शुरू करने वाली हैं।"
        """.trimIndent(),
        english = """
            (The Demonic Shower of Weapons): "Exactly upon arriving, those extremely arrogant and enraged enemies of the Gods (Amararayah)."
            "Instantly took the absolute frontlines and unleashed a heavy 'Torrential Rain' of terrifying arrows, spears, and swords upon the Mother!"
            "This is the 'Pre-emptive Strike' of ignorance—they desperately attempted to mathematically deny the Goddess any time to prepare."
            "Arrows, spears, and swords flawlessly symbolize those 'False Logics' and 'Negative Thoughts' attempting to conceal the Truth."
            "Arrogance perpetually desires to execute the 'First Move' strictly to project a fake illusion of overwhelming dominance."
            "The rain of weapons mathematically proves that when the ego shatters, it simultaneously hurls thousands of toxic excuses."
            "However, the fools forgot that the exact entity they were attacking is mathematically the absolute 'Mother of All Weapons'."
            "This massive assault was executed zero to damage the Goddess, but exclusively to mask the demons' deep internal 'Fear'."
            "Now the explicit absolute Reaction from the Goddess will arrive, instantaneously freezing this toxic rain in a single moment."
            "Mahamaya is now officially preparing to flawlessly initiate the next terrifying phase of Her cosmic play."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 27,
        sanskrit = "सा च तान् प्रहितान् बाणाञ्छूलशक्तिपरश्वधान् ।\nचिच्छेद लीलयाऽऽध्मातधनुर्मुक्तैर्महेषुभिः ॥ ३० ॥",
        hindi = """
            (देवी का अचूक प्रहार): "उन राक्षसों द्वारा फेंके गए उन सभी बाणों, त्रिशूलों, शक्तियों और फरसों को माता ने हवा में ही रोक दिया।"
            "देवी ने अपने धनुष को खींचा और उससे निकले हुए अपने 'महान बाणों' (महेषुभिः) से।"
            "बिल्कुल 'खेल-खेल में' (लीलया) उनके सारे हथियारों को काट कर ज़मीन पर गिरा दिया (चिच्छेद)!"
            "यह श्लोक 'परम शांति' और 'अचूक फोकस' (Flawless Focus) का सबसे बड़ा उदाहरण है।"
            "राक्षस (अज्ञान) अपनी पूरी जान लगाकर वार कर रहे थे, और देवी (चेतना) उसे 'लीला' (खेल) की तरह काट रही थीं।"
            "जब आप अंदर से स्थिर होते हैं, तो दुनिया की कोई भी नेगेटिविटी आपको डैमेज नहीं कर सकती।"
            "देवी के महान बाण (महेषु) वे 'सत्य के विचार' हैं जो झूठ के हर तर्क को हवा में ही क्रैश कर देते हैं।"
            "शस्त्रों का कटना यह सिद्ध करता है कि बुराई का कोई भी 'डिफेंस' सत्य की अदालत में नहीं टिकता।"
            "असुरों का पूरा आक्रमण एक सेकंड में ज़ीरो हो गया, और उनका आत्मविश्वास पूरी तरह हिल गया।"
            "अब देवी और उनकी मातृकाएं सीधा असुरों के शरीर पर प्रहार करना शुरू करेंगी।"
        """.trimIndent(),
        english = """
            (The Flawless Counter-Strike): "The Mother instantaneously stopped absolutely all those arrows, tridents, spears, and battle-axes hurled by the demons perfectly in mid-air."
            "The Goddess gracefully drew Her divine bow, and utilizing Her exceptionally massive 'Great Arrows' (Maheshubhih)."
            "She cleanly 'Severed and shattered' entirely all their weapons, dropping them to the dirt purely 'Playfully' (Lilaya)!"
            "This verse serves as the absolute greatest cosmic example of 'Supreme Peace' combined perfectly with 'Flawless Focus'."
            "The demons (Ignorance) were attacking utilizing their maximum life-force, while the Goddess (Consciousness) severed them like a simple 'Game'."
            "When you are completely mathematically stable from within, absolutely zero worldly negativity can successfully cause you damage."
            "The Goddess's great arrows are those 'Thoughts of Truth' that effortlessly crash every logic of falsehood strictly in mid-air."
            "Severing the weapons proves mathematically that absolutely zero 'Defense' of evil can survive within the supreme court of Truth."
            "The entire demonic assault was reduced to absolute zero in a single microsecond, violently shaking their self-confidence."
            "Now the Goddess and Her Matrikas will begin delivering direct lethal physical strikes entirely upon the demons' bodies."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 28,
        sanskrit = "तस्याग्रतस्तथा काली शूलविदारणदारुणा ।\nखट्वाङ्गपोथितांश्चारीन् कुर्वन्ती व्यचरद्रणे ॥ ३१ ॥",
        hindi = """
            (काली का संहार): "माता चण्डिका के ठीक आगे-आगे अत्यंत भयानक रूप वाली माता 'काली' चल रही थीं।"
            "वे अपने 'त्रिशूल' से राक्षसों के शरीरों को बहुत ही क्रूरता (दारुणा) से चीर (विदारण) रही थीं।"
            "और अपने 'खट्वांग' (मुंड वाले डंडे) से वे शत्रुओं के सिर फोड़-फोड़ कर (पोथितांश्चारीन्) उन्हें ज़मीन पर पटक रही थीं।"
            "काली यहाँ 'फ्रंटलाइन वारियर' (Frontline Warrior) की भूमिका में हैं, जो सबसे पहले अज्ञान से टकराती हैं।"
            "त्रिशूल से चीरना मतलब अज्ञान के उन तीन गुणों (सत्व, रज, तम) के भ्रम को हमेशा के लिए फाड़ देना।"
            "खट्वांग से सिर फोड़ना इंसान के 'झूठे ज्ञान' और 'ओवरथिंकिंग' को कुचलने का प्रतीक है।"
            "काली की यह क्रूरता (Daruna) वास्तव में ब्रह्मांड की सबसे बड़ी 'सफाई प्रक्रिया' (Cleansing Process) है।"
            "अहंकार के सैनिकों को अब भागने का कोई रास्ता नहीं मिल रहा था; काली साक्षात् काल बनकर नाच रही थीं।"
            "जब वैराग्य (काली) एक्टिव होता है, तो वह बुराई के साथ कोई 'डिप्लोमेसी' नहीं करता।"
            "रणभूमि अब पूरी तरह से राक्षसों के खून और टूटी हुई हड्डियों से भर गई थी।"
        """.trimIndent(),
        english = """
            (Kali's Slaughter): "Marching strictly directly in front of Mother Chandika was the exceptionally terrifying Mother 'Kali'."
            "She was brutally and ruthlessly (Daruna) ripping through the bodies of the demons exclusively utilizing Her 'Trident'."
            "And utilizing Her 'Khatvanga', She was violently smashing the enemies' heads and slamming them permanently to the dirt."
            "Kali mathematically perfectly acts as the absolute 'Frontline Warrior' here, directly colliding with thick ignorance first."
            "Ripping with the Trident translates exactly to permanently tearing apart the toxic illusion created by the three Gunas."
            "Smashing heads with the Khatvanga flawlessly symbolizes the absolute crushing of human 'False Knowledge' and toxic 'Overthinking'."
            "This explicit cruelty (Daruna) of Kali is mathematically identically the absolute greatest 'Cleansing Process' of the entire universe."
            "The soldiers of arrogance found absolutely zero escape routes; Kali was dancing strictly as absolute incarnate Time/Death."
            "When Detachment (Kali) becomes actively operational, it executes absolutely zero 'Diplomacy' with toxic evil."
            "The cosmic battlefield was now entirely completely overflowing flawlessly with the blood and shattered bones of the demons."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 29,
        sanskrit = "कमण्डलुजलाक्षेपहतवीर्यान् हतौजसः ।\nब्रह्माणी चाकरोच्छत्रून् येन येन स्म धावति ॥ ३२ ॥",
        hindi = """
            (ब्रह्माणी का प्रहार): "माता 'ब्रह्माणी' रणभूमि में जिस-जिस दिशा की ओर दौड़ रही थीं।"
            "वे अपने 'कमण्डलु' का पवित्र जल राक्षसों के ऊपर छिड़क (आक्षेप) रही थीं।"
            "और उस पवित्र जल के पड़ते ही, उन सभी शत्रुओं का 'पराक्रम' (हतवीर्यान्) और 'तेज़' (हतौजसः) उसी क्षण नष्ट हो रहा था!"
            "यह पूरी सप्तशती के सबसे गहरे और मनोवैज्ञानिक अस्त्रों में से एक है—'जल का प्रहार'।"
            "ब्रह्माणी (बुद्धि/ज्ञान) कोई तलवार नहीं चला रहीं; वे 'पवित्रता' (Purity) का छिड़काव कर रही हैं।"
            "जब इंसान के अज्ञान (अहंकार) पर शुद्ध ज्ञान (कमण्डलु का जल) पड़ता है, तो अज्ञान की सारी ताकत (वीर्य) खुद ही खत्म हो जाती है।"
            "बुराई की ताकत हमेशा 'अंधेरे' और 'अशुद्धता' पर टिकी होती है; पवित्रता उसे पैरालाइज़ (Paralyze) कर देती है।"
            "असुरों का शरीर तो ज़िंदा था, पर उनकी लड़ने की इच्छा (तेज़) पूरी तरह मर चुकी थी।"
            "यह दिखाता है कि 'सच्चा ज्ञान' इंसान को शारीरिक रूप से नहीं, बल्कि मानसिक रूप से बदल देता है।"
            "ब्रह्माणी ने अपनी शांति से ही राक्षसों के सबसे बड़े हथियारों को बेकार कर दिया था।"
        """.trimIndent(),
        english = """
            (Brahmani's Strike): "In whichever exact direction Mother 'Brahmani' actively sprinted across the cosmic battlefield."
            "She aggressively continuously sprinkled the absolute holy water directly from Her divine 'Kamandalu' upon the demons."
            "And the exact split-second that pure water touched them, all the enemies' 'Valor' and 'Radiance' were instantaneously destroyed!"
            "This is undeniably one of the absolute deepest and most psychological weapons in the entire text—the 'Strike of Water'."
            "Brahmani (Intellect/Wisdom) swings zero physical swords; She mathematically strictly sprinkles absolute 'Purity'."
            "When pure wisdom (Kamandalu water) touches human ignorance (Ego), the absolute total power of ignorance automatically perishes."
            "The strength of evil perpetually relies strictly on 'Darkness' and 'Impurity'; absolute purity instantly Paralyzes it."
            "The physical bodies of the demons remained alive, but their internal psychological will to fight had completely died."
            "This flawlessly proves that 'True Wisdom' alters a human mathematically psychologically, absolutely zero merely physically."
            "Brahmani effectively rendered the demons' absolute greatest weapons completely useless strictly utilizing Her pure peace."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 30,
        sanskrit = "माहेश्वरी त्रिशूलेन तथा चक्रेण वैष्णवी ।\nदैत्यान् जघान कौमारी तथा शक्त्यातिकोपना ॥ ३३ ॥",
        hindi = """
            (माहेश्वरी, वैष्णवी और कौमारी का संहार): "माता 'माहेश्वरी' ने अपने भयंकर त्रिशूल से दैत्यों को चीरना शुरू कर दिया।"
            "माता 'वैष्णवी' ने अपने सुदर्शन चक्र से उन राक्षसों के सिर धड़ से अलग कर दिए।"
            "और अत्यंत क्रोध में भरी हुई (अतिकोपना) माता 'कौमारी' ने अपनी 'शक्ति' (भाले) से दैत्यों का भारी संहार किया।"
            "यहाँ तीनों मातृकाएं अपने-अपने 'सिग्नेचर वेपन्स' (Signature Weapons) से बुराई का अंत कर रही हैं।"
            "माहेश्वरी का त्रिशूल इंसान के तीनों गुणों (सत्व, रज, तम) के इम्बैलेंस (Imbalance) को मारता है।"
            "वैष्णवी का चक्र 'समय का पहिया' है जो अहंकार की हर झूठी उपलब्धि को जड़ से काट देता है।"
            "कौमारी की 'शक्ति' (भाला) वह सीधा फोकस है जो बिना भटके बुराई के सीने में उतर जाता है।"
            "असुरों को समझ नहीं आ रहा था कि वे किस शक्ति से बचें; हर दिशा से मौत आ रही थी।"
            "यह हमारे मन की वह अवस्था है जब हमारी सारी इंद्रियां (Senses) मिलकर हमारे डिप्रेशन और नेगेटिविटी को मारती हैं।"
            "इस श्लोक के साथ ही मातृकाओं के इस प्रलयंकारी महायुद्ध ने अपनी सबसे तेज़ गति पकड़ ली है।"
        """.trimIndent(),
        english = """
            (Slaughter by Maheshwari, Vaishnavi, and Kaumari): "Mother 'Maheshwari' aggressively initiated ripping through the demons utilizing Her terrifying Trident."
            "Mother 'Vaishnavi' flawlessly severed the heads of those monsters utilizing Her rapidly spinning Sudarshana Chakra."
            "And Mother 'Kaumari', completely consumed by extreme wrath (Atikopana), executed massive slaughter utilizing Her 'Shakti' (Spear)."
            "Here, all three Matrikas are systematically terminating evil explicitly utilizing their exact 'Signature Weapons'."
            "Maheshwari's Trident flawlessly slaughters the heavy psychological imbalance of the three human Gunas (Sattva, Rajas, Tamas)."
            "Vaishnavi's Chakra is the explicit 'Wheel of Time' that mathematically severs every fake achievement of the human Ego."
            "Kaumari's 'Shakti' (Spear) represents that absolute straight Focus which flawlessly pierces the chest of evil without wandering."
            "The demons were entirely mathematically confused regarding which power to dodge; absolute death arrived from every direction."
            "This perfectly mirrors the mental state where all our biological Senses unite explicitly to slaughter our internal negativity."
            "With this specific verse, this apocalyptic cosmic war of the Matrikas has officially achieved its absolute maximum velocity."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 31,
        sanskrit = "ऐन्द्री कुलिशपातेन शतशो दैत्यदानवाः ।\nपेतुर्विदारिताः पृथ्व्यां रुधिरौघप्रवर्षिणः ॥ ३५ ॥",
        hindi = """
            (ऐन्द्री का वज्र प्रहार): "रणभूमि में माता 'ऐन्द्री' (इन्द्राणी) ने अपने भयंकर 'कुलिश' (वज्र) से प्रहार करना शुरू किया।"
            "उस वज्र की अमोघ चोट से कट-कट कर सैकड़ों दैत्य और दानव धरती पर गिरने लगे।"
            "उन राक्षसों के कटे हुए शरीरों से खून की भयंकर नदियां (रुधिरौघ) बहने लगीं और वे तड़प कर मर गए।"
            "ऐन्द्री इंसान के 'परम निश्चय' (Firm Determination) और 'इच्छाशक्ति' (Willpower) का प्रतीक हैं।"
            "वज्र (Thunderbolt) वह अस्त्र है जो कभी खाली नहीं जाता; यह हमारे दृढ़ संकल्प का साक्षात् भौतिक रूप है।"
            "जब हम अपने अचूक संकल्प (वज्र) से अपनी बुरी आदतों पर वार करते हैं, तो वे एक ही झटके में कटकर गिर जाती हैं।"
            "राक्षसों का खून बहना यह बताता है कि अज्ञान की जीवन-शक्ति (Life-force) अब पूरी तरह से सूख रही है।"
            "मन का जो भी हिस्सा बुराई (दैत्यों) से भरा था, वह अब बिल्कुल खाली और पवित्र हो रहा था।"
            "यह दृश्य दिखाता है कि शुद्ध 'इच्छाशक्ति' किसी भी भारी नेगेटिविटी को चकनाचूर करने की ताकत रखती है।"
            "मातृकाओं का यह सामूहिक प्रहार ईगो के पूरे नेटवर्क को हमेशा के लिए डी-एक्टिवेट (Deactivate) कर रहा था।"
        """.trimIndent(),
        english = """
            (Aindri's Thunderbolt Strike): "In the battlefield, Mother 'Aindri' aggressively initiated strikes utilizing Her terrifying 'Kulisha' (Thunderbolt)."
            "Brutally severed by the apocalyptic impact of that thunderbolt, hundreds of massive demons dropped dead to the earth."
            "Massive rivers of blood (Rudhiraugha) violently gushed strictly from their severed bodies as they perished in agony."
            "Aindri mathematically perfectly symbolizes absolute human 'Firm Determination' and unbreakable 'Willpower'."
            "The Thunderbolt is an exact cosmic weapon that mathematically never misses; it is the physical format of pure resolve."
            "When we strictly strike our toxic habits perfectly with absolute resolve (Vajra), they are severed in a single microsecond."
            "The demons bleeding out explicitly proves that the absolute core life-force of ignorance is now permanently drying up."
            "The specific exact portion of the mind occupied entirely by evil was now being completely emptied and psychologically cleansed."
            "This visual mathematically proves that pure Willpower can flawlessly pulverize any heavy negativity straight into dust."
            "This collective apocalyptic assault by the Matrikas was successfully perfectly deactivating the ego's entire internal neural network."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 32,
        sanskrit = "तुण्डप्रहारविध्वस्ता दंष्ट्राग्रक्षतवक्षसः ।\nवाराहमूर्त्या न्यपतंश्चक्रेण च विदारिताः ॥ ३६ ॥",
        hindi = """
            (वाराही का क्रूर प्रहार): "माता 'वाराही' (वराह रूप वाली देवी) ने अपने 'थूथन' (सूअर के मुख) की ज़ोरदार मार से राक्षसों को कुचल दिया।"
            "उन्होंने अपनी भयंकर दाढ़ों के अग्रभाग (दंष्ट्राग्र) से दैत्यों की छाती (वक्षसः) को बुरी तरह फाड़ डाला।"
            "और अपने सुदर्शन चक्र के प्रहार से उन्होंने कई असुरों को बीच से चीर कर ज़मीन पर पटक दिया।"
            "वाराही का यह अत्यंत खूंखार रूप इंसान की उस 'रूट-लेवल क्लेंज़िंग' (Root-level cleansing) का प्रतीक है।"
            "सूअर का थूथन और दाढ़ें—ये दोनों ज़मीन के बहुत नीचे गहराई में छिपी हुई चीज़ों को खोदकर निकालने के काम आते हैं।"
            "हमारे अवचेतन (Subconscious) में जो बचपन के ट्रॉमा (Trauma) और गहरे डर दबे होते हैं, वाराही उन्हें निकालती हैं।"
            "राक्षसों की छाती फाड़ना मतलब उनके 'अहंकार के केंद्र' (Heart of Ego) को हमेशा के लिए तोड़ देना।"
            "चक्र से काटना यह सिद्ध करता है कि समय (चक्र) के साथ बुराई की हर गहरी परत को काटा जा सकता है।"
            "असुरों ने कभी सपने में भी नहीं सोचा था कि वे इतने क्रूर और ज़मीनी (Grounding) तरीके से मारे जाएंगे।"
            "यह देवी की वह शक्ति है जो बिना किसी दया के, गंदगी के बीच घुसकर भी मन को पूरी तरह साफ कर देती है।"
        """.trimIndent(),
        english = """
            (Varahi's Brutal Strike): "Mother 'Varahi' (the boar-faced Goddess) aggressively crushed the demons utilizing the heavy brute force of Her snout."
            "She brutally ripped apart the exact chests (Vakshah) of the monsters utilizing the razor-sharp tips of Her terrifying tusks."
            "And perfectly utilizing the apocalyptic strikes of Her Chakra, She sliced many demons and slammed them strictly to the dirt."
            "This exceptionally ferocious format of Varahi perfectly symbolizes the absolute 'Root-level Cleansing' of the human psyche."
            "The boar's snout and tusks are explicitly utilized strictly to dynamically dig out objects deeply buried far beneath the ground."
            "Varahi effectively forcefully extracts the deep childhood traumas and ancient fears securely buried within our Subconscious."
            "Ripping the demons' chests translates perfectly to permanently shattering the absolute 'Center of Arrogance' (Heart)."
            "Slicing with the Chakra mathematically proves that every toxic layer of evil can be flawlessly severed by Time (Chakra)."
            "The demons absolutely never mathematically imagined they would be slaughtered in such a brutal, 'Grounding' physical manner."
            "This is the exact energy that enters the deepest mental filth absolutely without mercy to completely perfectly cleanse the mind."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 33,
        sanskrit = "नखैर्विदारितांश्चान्यान् भक्षयन्ती महासुरान् ।\nनारसिंही चचाराजौ नादापूर्णदिगम्बरा ॥ ३७ ॥",
        hindi = """
            (नारसिंही का तांडव): "माता 'नारसिंही' (आधा शेर, आधा इंसान) ने अपने भयंकर 'नाखूनों' (नखैर्) से कई महा-असुरों को चीर डाला।"
            "वे उन राक्षसों को विदीर्ण करके कच्चा ही खा (भक्षयन्ती) रही थीं और रणभूमि में अत्यंत क्रोध से विचर रही थीं।"
            "उनकी गर्जना (नाद) इतनी खौफनाक थी कि उसने चारों दिशाओं और पूरे आकाश (दिगम्बरा) को पूर्ण रूप से भर दिया था।"
            "नारसिंही वह उग्र 'डिवाइन अग्रेशन' (Divine Aggression) है जो बुराई का अस्तित्व ही मिटा देना चाहती है।"
            "नाखूनों से फाड़ना यह दर्शाता है कि सत्य किसी अस्त्र का मोहताज नहीं, वह अपने अस्तित्व से ही विनाशक है।"
            "राक्षसों को खाना (Devouring) उस प्रोसेस का प्रतीक है जहाँ चेतना अपने अंदर के कचरे को खुद जलाकर खत्म करती है।"
            "आकाश को गर्जना से भरना अज्ञान के मनोवैज्ञानिक 'सुरक्षा चक्र' को बुरी तरह क्रैश (Crash) करने का काम कर रहा था।"
            "यह वह स्थिति है जब इंसान का क्रोध अगर सही दिशा (धर्म) में हो, तो वह सबसे बड़ा हथियार बन जाता है।"
            "राक्षस अब इस आधे जानवर वाले रूप को देखकर अपनी जान की भीख मांग रहे थे, पर वहाँ केवल मौत थी।"
            "मातृकाओं का यह सामूहिक हमला अज्ञान के साम्राज्य का आखिरी और सबसे डरावना अध्याय लिख रहा था।"
        """.trimIndent(),
        english = """
            (Narasimhi's Dance of Death): "Mother 'Narasimhi' (half-lion, half-human) ripped through numerous mega-demons utilizing Her razor-sharp 'Claws' (Nakhaih)."
            "She aggressively tore those monsters completely apart and actively 'Devoured' (Bhakshayanti) them raw while roaming the battlefield."
            "Her apocalyptic roar (Nada) was so mathematically terrifying that it entirely completely filled all directions and the absolute cosmic sky!"
            "Narasimhi explicitly flawlessly represents that fierce 'Divine Aggression' which strictly desires to permanently erase the existence of evil."
            "Tearing with claws explicitly proves that Absolute Truth requires zero weapons; its pure existence alone is entirely destructive to lies."
            "Devouring the demons perfectly symbolizes the psychological process where Consciousness completely burns and consumes its own internal garbage."
            "Filling the sky with Her roar was successfully aggressively crashing the entire psychological 'Security Shield' of deep cosmic ignorance."
            "This represents that exact state where human anger, if perfectly directed toward Dharma, becomes the absolute greatest divine weapon."
            "The demons were now helplessly begging for their pathetic lives upon seeing this half-beast form, but strictly only death awaited."
            "This collective apocalyptic assault by the Matrikas was officially mathematically writing the absolute final, most terrifying chapter of ignorance."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 34,
        sanskrit = "चण्डाट्टहासैरसुराः शिवदूत्यभिदूषिताः ।\nपेतुः पृथिव्यां पतितांस्तांश्चखादाथ सा तदा ॥ ३८ ॥",
        hindi = """
            (शिवदूती का अट्टहास): "माता 'शिवदूती' ने रणभूमि में ऐसा अत्यंत 'प्रचंड अट्टहास' (खौफनाक हंसी) किया।"
            "कि उस हंसी की भयंकर ध्वनि (शिवदूत्यभिदूषिताः) से ही कई असुरों के प्राण निकल गए और वे धरती पर गिर पड़े (पेतुः पृथिव्यां)!"
            "और जो असुर ज़मीन पर गिर पड़े थे, उन्हें माता शिवदूती ने उसी क्षण कच्चा ही चबा लिया (चखादाथ)।"
            "शिवदूती (Shiva Duti) की हंसी कोई सामान्य हंसी नहीं, बल्कि 'मृत्यु का सायरन' (Siren of Death) है।"
            "जब सत्य को यह दिखाई देता है कि अज्ञान कितना खोखला है, तो वह उसे कोई महत्व न देकर केवल उस पर 'हंसता' है।"
            "हंसी से राक्षसों का मरना यह साबित करता है कि ईगो (Ego) केवल 'सम्मान' पर ज़िंदा रहता है।"
            "जब आप ईगो का 'मज़ाक' उड़ाते हैं, तो वह अपने आप पैरालाइज़ (Paralyzed) होकर गिर जाता है।"
            "गिरे हुए राक्षसों को खाना यह बताता है कि गिरे हुए विचारों (Fallen thoughts) को तुरंत दिमाग से हटा देना चाहिए।"
            "अगर मरे हुए विचारों को वहीं छोड़ दिया जाए, तो वे फिर से ज़िंदा हो सकते हैं (रक्तबीज की तरह)।"
            "यह मातृकाओं का वह रौद्र रूप है जिसने असुरों को शारीरिक और मानसिक—दोनों रूपों से पूरी तरह तोड़ दिया।"
        """.trimIndent(),
        english = """
            (Shiva Duti's Laughter): "Mother 'Shiva Duti' executed an exceptionally 'Fierce and Apocalyptic Laugh' (Chanda-attahasai) perfectly across the battlefield."
            "Strictly due to the terrifying vibration of that laugh alone, many demons instantly lost their life-force and dropped dead to the earth!"
            "And exactly those specific demons who had fallen to the ground, Mother Shiva Duti instantaneously devoured raw exactly in that split-second."
            "Shiva Duti's cosmic laughter is zero ordinary reaction; it mathematically operates strictly as the absolute 'Siren of Death'."
            "When Absolute Truth visually comprehends exactly how hollow ignorance truly is, it grants it zero importance and strictly 'Mocks' it."
            "Demons dying strictly from laughter explicitly proves that the Ego mathematically survives exclusively upon perceived 'Respect and Dignity'."
            "When you successfully actively 'Mock' the toxic ego, it automatically becomes psychologically Paralyzed and effortlessly drops dead."
            "Devouring the fallen demons strictly teaches that 'Fallen Thoughts' must be instantaneously and permanently removed from the brain."
            "If dead toxic thoughts are abandoned freely in the mind, they can mathematically resurrect identically like a biological virus."
            "This fierce format of the Matrikas successfully completely shattered the demons both physically and entirely psychologically."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 35,
        sanskrit = "इति मातृगणं क्रुद्धं मर्दयन्तं महासुरान् ।\nदृष्ट्वाभ्युपायैर्विविधैर्नेशुर्देवारिसैनिकाः ॥ ३९ ॥",
        hindi = """
            (मातृकाओं का खौफ): "इस प्रकार इन सभी अत्यंत क्रोधित मातृकाओं (मातृगणं क्रुद्धं) को अलग-अलग तरीकों से महा-असुरों को कुचलते (मर्दयन्तं) हुए देखकर।"
            "देवताओं के शत्रुओं (देवारिसैनिकाः) की जो बची-खुची सेना थी, वह पूरी तरह से हार मान गई और वहाँ से भाग खड़ी हुई (नेशुर्)।"
            "मातृकाएं (Matrikas) इंसान की सात 'शुद्ध वृत्तियों' (Pure Tendencies) का साक्षात् प्रतीक हैं।"
            "जब हमारी सारी इंद्रियां और ऊर्जाएं मिलकर किसी एक बुरी आदत पर टूट पड़ती हैं, तो बुराई टिक नहीं सकती।"
            "हर मातृका ने अलग-अलग उपाय (विविधैः) से मारा—किसी ने चक्र से, किसी ने गदा से, किसी ने हंसी से।"
            "यह दिखाता है कि हमारे दिमाग में कई तरह के विकार होते हैं, और हर विकार को मारने की एक अलग 'तकनीक' (Technique) होती है।"
            "सेना का भागना यह प्रमाणित करता है कि अज्ञान अंदर से बहुत 'डरपोक' (Coward) होता है।"
            "लीडर के बिना और जब मौत सामने हो, तो कोई भी नेगेटिव विचार हमारा साथ नहीं देता।"
            "रणभूमि अब साधारण राक्षसों से लगभग खाली हो चुकी थी।"
            "परंतु यह शांति एक बहुत बड़े तूफान (रक्तबीज) के आने की पूर्व-सूचना (Warning) थी।"
        """.trimIndent(),
        english = """
            (The Terror of the Matrikas): "Visually explicitly witnessing all these exceptionally enraged Matrikas (Divine Mothers) brutally crushing the mega-demons."
            "Utilizing entirely diverse and terrifying combat methods, the remaining surviving soldiers of the enemies of the Gods completely fled."
            "The Matrikas flawlessly mathematically represent the explicit physical manifestation of the seven 'Pure Tendencies' within a human."
            "When absolutely all our biological senses and cosmic energies actively unite to strike a toxic habit, evil mathematically cannot survive."
            "Every Matrika utilized a 'Diverse Method' (Vividhaih)—one used a chakra, another a mace, and another pure cosmic laughter."
            "This perfectly demonstrates that our brain hosts various distinct distortions, each requiring a specific exact 'Healing Technique'."
            "The fleeing of the army definitively proves that thick cosmic ignorance is fundamentally completely 'Cowardly' from the inside."
            "Without an active central leader and facing certain death, absolutely zero negative thoughts stand loyal to the human."
            "The massive battlefield was now practically completely emptied of all ordinary and lower-level demons."
            "However, this sudden silence was mathematically serving strictly as an exact 'Warning' for the absolute greatest incoming cosmic storm."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 36,
        sanskrit = "पलायनपरान् दृष्ट्वा दैत्यान् मातृगणार्दितान् ।\nयोद्धुमभ्याययौ क्रुद्धो रक्तबीजो महासुरः ॥ ४० ॥",
        hindi = """
            (रक्तबीज का प्रवेश): "मातृकाओं के भयंकर प्रहारों से पीड़ित होकर (मातृगणार्दितान्) अपनी असुर सेना को इस प्रकार रणभूमि से भागते (पलायनपरान्) हुए देखकर।"
            "अब स्वयं वह अत्यंत भयंकर और खौफनाक महा-असुर 'रक्तबीज' (रक्तबीजो महासुरः) क्रोध में भरकर युद्ध करने के लिए आगे आया!"
            "यह दुर्गा सप्तशती का सबसे 'साइकोलॉजिकल टर्निंग पॉइंट' (Psychological Turning Point) है।"
            "रक्तबीज (Raktabija) का शाब्दिक अर्थ है—'रक्त' (Blood) और 'बीज' (Seed)।"
            "यह इंसान के दिमाग की उस बीमारी का प्रतीक है जिसे हम 'ओवरथिंकिंग' (Overthinking) या 'एंग्जायटी लूप' (Anxiety Loop) कहते हैं।"
            "जब आप अपनी छोटी-मोटी बुरी आदतों (भागती हुई सेना) को मार देते हैं, तो दिमाग का सबसे गहरा 'पैटर्न' (Pattern) एक्टिव हो जाता है।"
            "रक्तबीज वह 'चेन रिएक्शन' (Chain Reaction) है जो एक विचार से हज़ारों विचार पैदा करता है।"
            "जब कोई इंसान ध्यान (Meditation) में बैठता है, तो शुरू में मन शांत लगता है।"
            "परंतु तभी रक्तबीज जैसी भयंकर 'विचारों की आंधी' आती है जिसे रोकना असंभव लगने लगता है।"
            "अब मातृकाओं को उस राक्षस का सामना करना था जो मरने पर भी मरता नहीं था।"
        """.trimIndent(),
        english = """
            (The Entry of Raktabija): "Visually actively witnessing his demonic army being heavily tormented by the Matrikas and completely fleeing the battlefield in pure terror."
            "Now the exceptionally terrifying and apocalyptic mega-demon named 'Raktabija' marched forward, completely consumed by absolute wrath!"
            "This flawlessly represents the absolute greatest and deepest 'Psychological Turning Point' in the entire Durga Saptashati."
            "'Raktabija' mathematically literally translates strictly perfectly directly exactly to 'Blood' (Rakta) and 'Seed' (Bija)."
            "He is the exact physical physical manifestation of that specific psychological disease we mathematically define as 'Overthinking' or the 'Anxiety Loop'."
            "When you successfully slaughter your minor toxic habits (the fleeing army), the absolute deepest cognitive 'Pattern' becomes highly active."
            "Raktabija perfectly symbolizes that toxic 'Chain Reaction' where one single negative thought instantly perfectly spawns thousands more."
            "When a human initially sits strictly in deep Meditation, the biological mind temporarily appears perfectly peaceful."
            "However, suddenly a terrifying storm of multiplying thoughts (Raktabija) perfectly arrives, appearing mathematically impossible to stop."
            "Now the Matrikas were officially mathematically destined to confront that exact specific demon who refused to die even when slaughtered."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 37,
        sanskrit = "रक्तबिन्दुर्यदा भूमौ पतत्यस्य शरीरतः ।\nसमुत्पतति मेदिन्यां तत्प्रमाणो महासुरः ॥ ४१ ॥",
        hindi = """
            (रक्तबीज का वरदान): "उस राक्षस का सबसे भयंकर वरदान यह था कि उसके शरीर से 'रक्त (खून) की जो भी बूँद' (रक्तबिन्दुर्यदा) धरती (भूमौ) पर गिरती थी।"
            "उसी क्षण उस धरती (मेदिन्यां) से बिल्कुल उसी के आकार, बल और रूप वाला एक 'नया महा-असुर' (तत्प्रमाणो महासुरः) पैदा हो जाता था!"
            "यह श्लोक 'विचारों की चेन' (Chain of thoughts) को साइंटिफिक तरीके से समझाता है।"
            "जब आप किसी नेगेटिव विचार (रक्तबीज) से 'लड़ते' (Fight) हैं, तो आप उसे एनर्जी (चोट) देते हैं।"
            "चोट लगने से जो खून गिरता है, वह आपका 'अटेंशन' (Attention) है।"
            "और जहाँ-जहाँ आपका अटेंशन (खून) ज़मीन (मन) पर गिरता है, वहाँ बिल्कुल वैसा ही एक नया 'नेगेटिव विचार' पैदा हो जाता है।"
            "इसीलिए 'एंग्जायटी' (Anxiety) से लड़कर उसे कभी नहीं हराया जा सकता; जितना लड़ोगे, वह उतनी बढ़ेगी।"
            "रक्तबीज को मारने की कोशिश करना आग में पेट्रोल डालने जैसा है।"
            "यह अज्ञान का वह 'रेप्लिकेशन मेकेनिज्म' (Replication Mechanism) है जो वायरस (Virus) की तरह खुद को कॉपी (Copy) करता है।"
            "देवताओं के लिए यह राक्षस सबसे बड़ी चुनौती था क्योंकि इसके मरने से ही इसकी सेना बढ़ रही थी।"
        """.trimIndent(),
        english = """
            (The Boon of Raktabija): "The absolute most terrifying cosmic boon of this specific monster was that exactly whenever a single 'Drop of Blood' fell from his body directly onto the dirt."
            "In that exact precise split-second, a brand-new identical mega-demon possessing the exact same size, power, and form manifested directly from that earth!"
            "This precise verse mathematically scientifically entirely completely perfectly explains the precise psychological mechanism of the 'Chain of Thoughts'."
            "When you actively aggressively 'Fight' a specific negative thought (Raktabija), you mathematically inadvertently supply it with raw Energy (striking it)."
            "The bleeding blood mathematically perfectly symbolizes your focused 'Attention' given directly to that toxic thought."
            "And precisely wherever your exact attention (blood) successfully falls upon the ground (Mind), a perfectly identical brand-new toxic thought instantly manifests."
            "Therefore, 'Anxiety' can mathematically absolutely never be successfully defeated by fighting it; exactly the more you fight, the more it strictly multiplies."
            "Actively violently attempting to strictly manually slaughter Raktabija is mathematically identical to pouring gasoline directly onto an apocalyptic fire."
            "This is the precise 'Replication Mechanism' of thick ignorance, flawlessly copying itself identically strictly like a highly advanced biological Virus."
            "For the Gods, this monster was the absolute supreme challenge because the very act of killing him exponentially mathematically expanded his army."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 38,
        sanskrit = "युयुधे स गदापाणिरिन्द्रशक्त्या महासुरः ।\nततश्चैन्द्री स्ववज्रेण रक्तबीजमताडयत् ॥ ४२ ॥",
        hindi = """
            (ऐन्द्री से युद्ध): "हाथ में एक भयंकर 'गदा' (गदापाणि) धारण किए हुए वह महा-असुर रक्तबीज सबसे पहले इन्द्र की शक्ति (ऐन्द्री) के सामने आया।"
            "और उसने ऐन्द्री के साथ भयंकर युद्ध करना (युयुधे) शुरू कर दिया।"
            "तभी माता ऐन्द्री ने अत्यंत क्रोधित होकर अपने महान 'वज्र' (स्ववज्रेण) से उस रक्तबीज पर बहुत ज़ोरदार प्रहार किया (अताडयत्)!"
            "रक्तबीज (ओवरथिंकिंग) ने सबसे पहले ऐन्द्री (इच्छाशक्ति/Willpower) को चैलेंज (Challenge) किया।"
            "गदा इंसान के भारी और ठोस अज्ञान का प्रतीक है, जो विलपावर को कुचलना चाहता है।"
            "माता ऐन्द्री ने अपने 'वज्र' (Firm Resolve) का इस्तेमाल किया, क्योंकि उन्हें लगा कि दृढ़ निश्चय से इस विचार को रोका जा सकता है।"
            "जब हमें कोई बुरी आदत या एंग्जायटी होती है, तो हम सबसे पहले 'कसम' (Vajra/Willpower) खाते हैं कि हम इसे रोकेंगे।"
            "हम पूरी ताकत लगाकर उस विचार को 'ब्लॉक' (Block) करने की कोशिश करते हैं।"
            "परंतु ऐन्द्री (इच्छाशक्ति) को यह नहीं पता था कि यह सामान्य राक्षस नहीं है।"
            "वज्र का प्रहार रक्तबीज को मारने के बजाय एक बहुत बड़ी समस्या खड़ी करने वाला था।"
        """.trimIndent(),
        english = """
            (The Battle with Aindri): "Firmly gripping a terrifying massive 'Mace' (Gada) in his hands, that mega-demon Raktabija advanced explicitly to confront Indra's energy (Aindri)."
            "And he aggressively forcefully successfully initiated an exceptionally fierce and apocalyptic war entirely against Her."
            "In retaliation, Mother Aindri became enraged and executed a devastatingly powerful strike explicitly upon Raktabija strictly utilizing Her great 'Thunderbolt' (Vajra)!"
            "Raktabija (Toxic Overthinking) mathematically perfectly intentionally challenged Aindri (Absolute Willpower) first among all the Matrikas."
            "The Mace explicitly symbolizes the extremely heavy, solid ignorance that actively aggressively attempts to completely crush human willpower."
            "Mother Aindri explicitly utilized Her 'Thunderbolt' (Firm Resolve) because She logically assumed pure determination could successfully stop this thought."
            "When we experience extreme toxic anxiety, our absolute first explicit psychological response is strictly to utilize our 'Willpower' to forcefully block it."
            "We invest absolute maximum cognitive force desperately attempting to strictly aggressively 'Block' that exact repetitive toxic thought."
            "However, Aindri (Willpower) was completely mathematically unaware that this specific entity was absolutely zero ordinary logical demon."
            "The direct strike of the Thunderbolt, instead of solving the exact problem, was mathematically destined to exponentially multiply the disaster."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 39,
        sanskrit = "कुलिशेनाहतस्याशु बहु सुस्राव शोणितम् ।\nसमुत्तस्थुस्ततो योधास्तद्रूपास्तत्पराक्रमाः ॥ ४३ ॥",
        hindi = """
            (रक्तस्राव और नए असुर): "ऐन्द्री के उस भयंकर वज्र (कुलिश) की गहरी चोट लगते ही, रक्तबीज के शरीर से।"
            "बहुत तेज़ी से अत्यंत अधिक मात्रा में 'रक्त' (खून / शोणितम्) बहने लगा (सुस्राव)।"
            "और जैसे ही वह खून ज़मीन पर गिरा, वहाँ से तुरंत 'उसी के समान रूप और पराक्रम वाले' (तद्रूपास्तत्पराक्रमाः) हज़ारों नए योद्धा (योधाः) पैदा होकर खड़े हो गए (समुत्तस्थु)!"
            "यह 'सप्रेशन' (Suppression) का साइकोलॉजिकल नियम है—जिस चीज़ को आप ज़बरदस्ती दबाते हैं, वह दोगुनी ताकत से वापस आती है।"
            "वज्र (Willpower) ने विचार (रक्तबीज) को चोट तो पहुँचाई, पर उसे 'मिटा' नहीं पाया।"
            "खून बहने का मतलब है—उस नेगेटिव विचार पर आपका बहुत सारा 'अटेंशन' (Attention) और 'एनर्जी' (Energy) खर्च हो गया।"
            "और जैसे ही वह एनर्जी मन (ज़मीन) पर गिरी, उसने तुरंत एक और नए नेगेटिव विचार को जन्म दे दिया।"
            "ये नए योद्धा (क्लोन) कोई भ्रम नहीं थे; वे बिल्कुल ओरिजिनल रक्तबीज जितने ही 'बलवान' और 'असली' थे।"
            "आपकी एक चिंता (Anxiety) से जुड़ी हर दूसरी चिंता आपको बिल्कुल 'असली' (Real) और खतरनाक लगती है।"
            "ऐन्द्री का वह प्रहार अब मातृकाओं के लिए एक बहुत बड़ा संकट बन चुका था।"
        """.trimIndent(),
        english = """
            (Bleeding and New Demons): "The exact split-second the devastating blow of Aindri's Thunderbolt struck deeply, massive quantities."
            "Of 'Blood' (Shonitam) aggressively and continuously began pouring and gushing rapidly entirely from Raktabija's wounded physical body."
            "And strictly as that blood collided with the dirt, thousands of brand-new 'Warriors' identical exactly in 'Form and Cosmic Power' instantaneously manifested!"
            "This perfectly explains the psychological law of 'Suppression'—whatever specific thought you forcefully actively suppress perfectly bounces back with double velocity."
            "The Thunderbolt (Willpower) successfully injured the toxic thought (Raktabija), but mathematically entirely failed to successfully 'Delete' it."
            "The pouring blood mathematically translates to massive amounts of your personal 'Attention' and 'Energy' being actively drained directly by that thought."
            "And the exact moment that leaked energy hit the ground (Mind), it automatically mathematically created a perfectly identical new negative thought."
            "These new warriors (clones) were absolutely zero illusions; they were mathematically precisely as 'Powerful' and 'Real' as the original demon."
            "Every secondary anxiety actively spawned from your primary anxiety psychologically completely flawlessly feels absolutely 100% 'Real' and terrifying."
            "Aindri's initial aggressive strike had now mathematically completely transformed strictly into a colossal apocalyptic crisis for the Goddesses."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 40,
        sanskrit = "यावन्तः पतितास्तस्य शरीराद्रक्तबिन्दवः ।\nतावन्तः पुरुषा जातास्तद्वीर्यबलविक्रमाः ॥ ४४ ॥",
        hindi = """
            (संख्या में वृद्धि): "उस महा-असुर के शरीर से रक्त (खून) की 'जितनी भी बूँदें' (यावन्तः रक्तबिन्दवः) ज़मीन पर गिरती थीं।"
            "बिल्कुल 'उतने ही' (तावन्तः) नए दैत्य पुरुष वहाँ उसी क्षण पैदा हो जाते थे!"
            "और वे सभी नए पैदा हुए असुर बिल्कुल अपने मूल पिता (रक्तबीज) के समान ही अत्यंत शक्तिशाली, बलवान और पराक्रमी (तद्वीर्यबलविक्रमाः) थे।"
            "यह श्लोक 'मल्टीप्लायर इफेक्ट' (Multiplier Effect) और 'एंग्जायटी लूप' (Anxiety Loop) को बहुत गहराई से डिकोड करता है।"
            "खून की हर एक बूँद एक 'पॉसिबिलिटी' (Possibility) या 'व्हाट-इफ' (What if) का प्रतीक है।"
            "ओवरथिंकिंग में इंसान सोचता है—'अगर ऐसा हो गया तो?' (पहली बूँद), फिर सोचता है—'अगर वैसा हो गया तो?' (दूसरी बूँद)।"
            "और हर नया 'व्हाट-इफ' पिछले वाले से बिल्कुल कमज़ोर नहीं होता; वह उतना ही 'पॉवरफुल' (तद्वीर्यबलविक्रमाः) होता है।"
            "दिमाग कुछ ही सेकंड में हज़ारों खौफनाक सिनेरियो (Scenarios) बना लेता है, जो सब सच लगते हैं।"
            "रक्तबीज की यह सेना अब पूरे रणभूमि (मन) को कवर (Cover) करने लगी थी।"
            "बुराई अब 'सिंगल' नहीं थी, वह एक 'चेन रिएक्शन' (Chain Reaction) बन चुकी थी।"
        """.trimIndent(),
        english = """
            (Exponential Multiplication): "'Exactly as many specific drops of blood' (Yavantah rakta-bindavah) that flawlessly dropped straight perfectly from that mega-demon's body onto the earth."
            "Exactly 'That exact precise mathematical number' (Tavantah) of brand-new demonic men were unconditionally instantaneously born in that exact spot!"
            "And absolutely all these newly generated demons were mathematically identically entirely exactly as powerful, strong, and terrifyingly valiant precisely as the original."
            "This flawless verse explicitly completely decodes the psychological 'Multiplier Effect' perfectly exactly inherent inside the toxic 'Anxiety Loop'."
            "Every single microscopic drop of blood perfectly symbolizes one specific negative 'Possibility' or toxic 'What-If' scenario generated by the brain."
            "In overthinking, a human panics: 'What if this happens?' (First Drop), then immediately: 'What if that happens?' (Second Drop)."
            "And every new 'What-If' is absolutely zero percent weaker than the previous; it remains exactly purely as mathematically 'Powerful' and terrifying."
            "The brain successfully securely constructs thousands of horrific fake scenarios entirely within seconds, which all feel completely physically Real."
            "Raktabija's exponential clone army was now aggressively explicitly securely expanding strictly to completely 'Cover' the entire cosmic battlefield (Mind)."
            "Evil was mathematically absolutely zero longer a 'Singular' entity; it had flawlessly perfectly transitioned exactly into an unstoppable 'Chain Reaction'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 41,
        sanskrit = "ते चापि युयुधुस्तत्र पुरुषा रक्तसम्भवाः ।\nसमं मातृभिरत्युग्रशस्त्रपातातिभीषणम् ॥ ४५ ॥",
        hindi = """
            (क्लोनों का भयंकर युद्ध): "खून से पैदा हुए (रक्तसम्भवाः) वे सभी हज़ारों नए असुर भी तुरंत उसी युद्धभूमि में लड़ने लगे।"
            "वे सभी नए राक्षस मातृकाओं (मातृभिर्) के साथ अत्यंत उग्र और भयंकर अस्त्र-शस्त्र (अत्युग्रशस्त्रपाता) चलाकर खौफनाक युद्ध करने लगे।"
            "रक्तबीज के ये 'क्लोन' (Clones) केवल खड़े नहीं थे; वे एक्टिवली (Actively) हमला कर रहे थे।"
            "जब एंग्जायटी (Overthinking) बढ़ती है, तो पैदा होने वाले नए विचार केवल दिमाग में पड़े नहीं रहते, वे आपकी शांति पर 'अटैक' (Attack) करते हैं।"
            "हर नया विचार एक नया हथियार (शस्त्र) लेकर आता है, जो आपको और ज़्यादा डराता है।"
            "मातृकाएं (हमारी इन्द्रियां और पॉजिटिव ऊर्जा) अब चारों तरफ से 'डिफेंसिव' (Defensive) मोड में आ गई थीं।"
            "वे एक को मारतीं, तो उसकी जगह दस नए विचार हमला करने आ जाते।"
            "यह वह मानसिक अवस्था है जहाँ इंसान को लगता है कि उसका 'दिमाग फटने वाला है' (Mental Exhaustion)।"
            "राक्षसों का यह 'अतिभीषण' (Terrifying) युद्ध अब नियंत्रण से बाहर जा रहा था।"
            "रक्तबीज ने अपनी 'रीप्रोडक्शन' (Reproduction) पावर से मातृकाओं को पूरी तरह घेर लिया था।"
        """.trimIndent(),
        english = """
            (The Fierce Battle of the Clones): "All those thousands of brand-new demons, explicitly 'Born strictly from the blood' (Rakta-sambhava), instantaneously aggressively initiated fighting exactly there."
            "Absolutely all those clones violently engaged the Matrikas (Mothers) in an exceptionally terrifying cosmic war, hurling apocalyptic and destructive 'Weapons'."
            "These explicit 'Clones' of Raktabija were absolutely zero passive observers; they were aggressively and violently executing active attacks."
            "When Anxiety (Overthinking) multiplies exponentially, the newly spawned thoughts absolutely never mathematically sit silently; they actively 'Attack' your core peace."
            "Every single new toxic thought mathematically strictly arrives perfectly equipped securely with a brand-new 'Weapon' explicitly to terrorize you further."
            "The Matrikas (our biological Senses and Positive Energy) were now completely forced precisely into a highly 'Defensive' posture from absolutely all directions."
            "If they successfully slaughtered one thought, exactly ten entirely new ones would violently successfully execute a counter-ambush."
            "This flawlessly represents exactly that specific advanced psychological state explicitly defined mathematically flawlessly as pure 'Mental Exhaustion' and absolute burnout."
            "This 'Exceptionally Terrifying' (Atibhishanam) apocalyptic war initiated exclusively by the clones was now successfully spiraling completely out of control."
            "Raktabija had successfully entirely utilized his explicit 'Reproduction' power effectively perfectly strictly to completely surround the divine Matrikas."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 42,
        sanskrit = "पुनश्च वज्रपातेन क्षतमस्य शिरो यदा ।\nववाह रक्तं पुरुषास्ततो जाताः सहस्रशः ॥ ४६ ॥",
        hindi = """
            (पुनः वज्र का प्रहार): "उनसे घिर जाने के बाद, माता ऐन्द्री ने अपने वज्र से 'फिर से' (पुनश्च) उस मूल रक्तबीज के 'सिर' (शिरो) पर बहुत ज़ोरदार प्रहार किया।"
            "वज्र की चोट से उसका सिर बुरी तरह फट गया (क्षतमस्य) और उसमें से खून की बहुत भयंकर धारा बह निकली (ववाह रक्तं)!"
            "और उस बहते हुए खून से उस रणभूमि में एक साथ 'हज़ारों' (सहस्रशः) नए और भयंकर पुरुष (असुर) पैदा हो गए!"
            "यह इंसान के 'ईगो' और 'लॉजिक' का सबसे बड़ा फेलियर (Failure) है—हम एक ही गलती बार-बार करते हैं।"
            "ऐन्द्री (विलपावर) ने जब देखा कि विचार बढ़ रहे हैं, तो उसने और 'ज़्यादा ताकत' लगाकर उसे दबाने की कोशिश की (पुनश्च वज्रपातेन)।"
            "उसने सीधे 'सिर' (लॉजिक/Head) पर वार किया, कि शायद इस बार यह विचार हमेशा के लिए मर जाए।"
            "परंतु एंग्जायटी को 'ज़बरदस्ती' (Force) से कभी नहीं रोका जा सकता।"
            "जितनी ज़ोर से ऐन्द्री ने वार किया, उतनी ही ज़ोर से खून बहा, और इस बार हज़ारों नए विचार एक साथ पैदा हो गए।"
            "यह वह 'पैनिक अटैक' (Panic Attack) की स्थिति है जहाँ इंसान खुद को कंट्रोल करने की जितनी कोशिश करता है, वह उतना ही आउट ऑफ कंट्रोल हो जाता है।"
            "अब यह युद्ध एक गणितीय (Mathematical) प्रलय बन चुका था।"
        """.trimIndent(),
        english = """
            (Repeated Thunderbolt Strike): "Being entirely surrounded, Mother Aindri aggressively perfectly 'Once Again' (Punashcha) delivered an apocalyptic strike directly precisely strictly upon the original Raktabija's 'Head'."
            "Shattered brutally strictly by the massive Thunderbolt, his head ruptured completely, and a highly terrifying heavy stream of blood aggressively gushed outward!"
            "And strictly precisely from that exact massive flow of blood, 'Thousands' (Sahasrashah) of absolutely new, terrifying demonic men mathematically manifested simultaneously!"
            "This perfectly successfully mathematically illustrates the absolute greatest 'Failure' of human logic and Ego—repeatedly blindly executing the exact identical mistake."
            "When Aindri (Willpower) visually noticed the thoughts actively multiplying, She desperately applied even 'More raw Force' exactly to brutally suppress them."
            "She actively deliberately exactly targeted the exact 'Head' (Logic/Brain), falsely assuming this specific brutal strike would permanently mathematically delete the thought."
            "However, severe psychological Anxiety can mathematically absolutely never be successfully eradicated strictly by utilizing raw brute 'Force'."
            "The exact harder Aindri struck, the more violently the blood flowed, seamlessly actively birthing thousands of highly toxic thoughts entirely in one microsecond."
            "This is precisely identically exactly the explicit definition of a severe 'Panic Attack', where forceful attempts to strictly control oneself cause absolute loss of control."
            "This specific cosmic war had now successfully fundamentally flawlessly effectively translated entirely into an unstoppable, pure Mathematical Apocalypse."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 43,
        sanskrit = "वैष्णवी समरे चैनं चक्रेणाभिजघान ह ।\nगदया ताडयामास ऐन्द्री तमसुरेश्वरम् ॥ ४७ ॥",
        hindi = """
            (वैष्णवी और ऐन्द्री का सामूहिक प्रहार): "स्थिति को बिगड़ता देख, माता 'वैष्णवी' ने युद्ध में अपने भयंकर 'सुदर्शन चक्र' से उस रक्तबीज पर सीधा प्रहार किया।"
            "और साथ ही माता 'ऐन्द्री' ने भी उस दैत्यराज (तमसुरेश्वरम्) पर अपनी भारी 'गदा' से ज़ोरदार चोट की।"
            "अब केवल 'विलपावर' (ऐन्द्री) ही नहीं, बल्कि 'मैनेजमेंट' (वैष्णवी) भी इस एंग्जायटी (रक्तबीज) को रोकने में लग गई।"
            "चक्र 'समय' (Time) का प्रतीक है—हम सोचते हैं कि 'समय के साथ यह विचार खुद खत्म हो जाएगा'।"
            "इसलिए वैष्णवी ने समय का पहिया (चक्र) चलाया ताकि रक्तबीज की उम्र कम हो जाए।"
            "गदा 'ठोस वास्तविकता' (Solid Reality) का प्रतीक है—ऐन्द्री ने उसे प्रैक्टिकल फैक्ट्स से कुचलने की कोशिश की।"
            "परंतु ये दोनों अस्त्र (चक्र और गदा) भौतिक (Physical) हैं, जो अज्ञान के शरीर को तो काट सकते हैं, पर उसके 'खून' को नहीं रोक सकते।"
            "राक्षस को जितनी बार मारा जा रहा था, वह हर मार को अपनी नई 'फौज' बनाने के लिए इस्तेमाल कर रहा था।"
            "यह दिखाता है कि 'लॉजिक' (गदा) और 'समय' (चक्र) अकेले डिप्रेशन और ओवरथिंकिंग का इलाज नहीं कर सकते।"
            "शक्तियों के सबसे बड़े अस्त्र भी अब इस राक्षस के सामने पूरी तरह 'इन-इफेक्टिव' (Ineffective) साबित हो रहे थे।"
        """.trimIndent(),
        english = """
            (Collective Strike by Vaishnavi and Aindri): "Visually witnessing the rapidly deteriorating cosmic situation, Mother 'Vaishnavi' aggressively directly struck Raktabija strictly utilizing Her terrifying 'Sudarshana Chakra'."
            "And simultaneously, Mother 'Aindri' actively executed a massive devastating physical blow directly upon that Demon King exactly utilizing Her heavy 'Mace'."
            "Now mathematically zero just 'Willpower' (Aindri), but also active 'Management' (Vaishnavi) successfully engaged precisely in actively attempting strictly to actively block this Anxiety."
            "The Chakra perfectly symbolizes 'Time'—humans falsely frequently exactly assume that 'Time strictly unconditionally heals everything'."
            "Therefore, Vaishnavi actively launched the explicit wheel of time (Chakra) desperately hoping strictly to successfully mathematically expire Raktabija's lifespan."
            "The Mace flawless represents 'Solid Reality'—Aindri aggressively explicitly exactly attempted cleanly to pulverize him perfectly utilizing exact pure Practical Facts."
            "However, both these exact specific weapons (Chakra and Mace) are highly Physical; they effectively accurately actively cut flesh, but fail utterly explicitly to successfully stop 'Blood'."
            "Every single identical exact specific time the demon was brutally struck, he mathematically successfully utilized that exact identical strike strictly to manufacture a new 'Army'."
            "This mathematically perfectly flawlessly definitively proves precisely that 'Logic' (Mace) and 'Time' (Chakra) alone absolutely cannot cure deep depression and Overthinking."
            "The absolute explicitly greatest cosmic weapons of the divine energies were now completely successfully proving entirely 'Ineffective' perfectly directly entirely exclusively against this demon."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 44,
        sanskrit = "वैष्णवीचक्रभिन्नस्य रुधिरस्रावसम्भवैः ।\nसहस्रशो जगद्व्याप्तं तत्प्रमाणैर्महासुरैः ॥ ४८ ॥",
        hindi = """
            (जगत् का असुरों से व्याप्त होना): "माता वैष्णवी के उस अत्यंत तेज़ 'चक्र' (चक्रभिन्नस्य) से कटने के कारण रक्तबीज के शरीर से जो भयंकर खून बहा।"
            "उस बहते हुए खून (रुधिरस्रावसम्भवैः) से उसके ही समान आकार और बल वाले (तत्प्रमाणैः) 'हज़ारों' नए महा-असुर पैदा हो गए।"
            "और उन हज़ारों राक्षसों ने देखते ही देखते इस पूरे के पूरे 'जगत' (संसार) को पूरी तरह से 'भर दिया' (जगद्व्याप्तं)!"
            "यह इस युद्ध का सबसे डरावना और 'आउट ऑफ कंट्रोल' (Out of control) मोमेंट (Moment) है।"
            "चक्र ने रक्तबीज को बहुत गहराई से काटा था, जिससे उसका 'ब्लीडिंग रेट' (Bleeding rate) कई गुना बढ़ गया।"
            "जितनी बड़ी और तीखी चोट, उतना ही ज़्यादा खून, और उतने ही ज़्यादा नए 'नेगेटिव थॉट्स'।"
            "जब कोई 'ट्रॉमा' (Trauma) ट्रिगर होता है, तो उससे निकले विचार इंसान की पूरी 'दुनिया' (जगत्) को ढक लेते हैं।"
            "इंसान को लगता है कि उसकी पूरी लाइफ (संसार) ही खराब है, क्योंकि उसका 'माइंड-स्पेस' अब नेगेटिविटी से 'व्याप्त' हो चुका है।"
            "रक्तबीज की फौज अब रणभूमि तक सीमित नहीं थी; उसने पूरे ब्रह्मांडीय स्पेस (Cosmic space) को अपनी चपेट में ले लिया था।"
            "यह वह 'एक्स्ट्रीम डिप्रेशन' (Extreme Depression) है जहाँ इंसान को अपने दिमाग से बाहर निकलने का कोई रास्ता नहीं दिखता।"
        """.trimIndent(),
        english = """
            (The World Enveloped by Demons): "Strictly completely flawlessly cut deeply identically perfectly by the exact exceptionally sharp 'Chakra' exactly of Mother Vaishnavi, massive cosmic blood gushed from Raktabija."
            "From that exact massive apocalyptic flow of pure toxic blood, 'Thousands' (Sahasrasho) of brand-new mega-demons identically exactly mirroring his specific size and power completely manifested."
            "And precisely completely exactly within a single microsecond, those thousands of terrifying monsters completely entirely successfully 'Enveloped and filled' (Jagat-vyaptam) the absolute entire 'World'!"
            "This is undeniably mathematically successfully strictly the absolute most terrifying and completely 'Out of Control' exact precise cosmic Moment in the entire war."
            "The Chakra had completely successfully perfectly sliced Raktabija exceptionally deeply, causing his exact toxic 'Bleeding Rate' precisely explicitly cleanly to exponentially effectively physically mathematically multiply."
            "The larger and sharper the exact biological injury, the greater the volume of spilled blood, and mathematically logically correctly precisely perfectly identically exactly the exact strictly identical greater explicit absolute production of exact new 'Negative Thoughts'."
            "When a deep psychological 'Trauma' is successfully triggered, the exact explicit thoughts aggressively actively explicitly spawned from it effortlessly completely completely perfectly cover a human's entire 'World'."
            "The human completely safely falsely perceives precisely perfectly exactly his absolute entire exact life identically as entirely perfectly unconditionally strictly completely completely flawlessly exactly purely ruined, because his exact 'Mind-Space' is perfectly fully 'Enveloped' entirely by negativity."
            "Raktabija's exponential clone army was mathematically exactly absolutely strictly explicitly absolutely completely purely zero cleanly perfectly perfectly longer successfully correctly confined exactly safely safely strictly exactly directly perfectly successfully efficiently explicitly reliably exactly smoothly to identically precisely exact flawlessly the precise explicit exactly purely battlefield; it perfectly unconditionally unconditionally successfully fully consumed absolute completely all 'Cosmic Space'."
            "This flawlessly represents that absolute 'Extreme Depression' where a human mathematically purely visually sees identically successfully zero escape routes entirely out explicitly exactly identically identically purely purely strictly mathematically flawlessly cleanly exclusively correctly of exactly safely exact identical purely explicitly effectively entirely exactly safely exactly identically strictly entirely directly exactly reliably safely flawlessly safely perfectly purely his exact identical biological precise entirely perfectly pure purely explicit brain."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 46,
        sanskrit = "स चापि गदया दैत्यो देवशक्तीरहन्यत ।\nतस्याप्यहतस्य बहु सुस्राव शोणितम् ॥ ५० ॥",
        hindi = """
            (रक्तबीज का पलटवार): "उस महा-असुर रक्तबीज ने भी अपनी भारी गदा उठाकर देव-शक्तियों (मातृकाओं) पर प्रहार करना शुरू किया।"
            "वह पागलों की तरह गदा घुमा रहा था और मातृकाओं को चोट पहुँचाने की कोशिश कर रहा था।"
            "परंतु युद्ध के दौरान जब मातृकाओं ने उसे फिर से घायल किया, तो उसके शरीर से फिर बहुत सारा खून बहा।"
            "यह अहंकार का वह 'रेजिस्टेंस' (Resistance) है जो हारने से पहले अपनी पूरी ताकत लगा देता है।"
            "जब हम अपनी किसी पुरानी आदत को बदलने की कोशिश करते हैं, तो वह 'गदा' की तरह हम पर मानसिक चोट करती है।"
            "खून का बहना (शोणितम्) यह दिखाता है कि अज्ञान अपनी 'एनर्जी' को बचाने के लिए संघर्ष कर रहा है।"
            "अहंकार को लगता है कि वह डराकर मातृकाओं (सात्विक गुणों) को भगा देगा, पर वह गलत था।"
            "जितनी बार उसे चोट लगती, उतने ही नए 'रक्तबीज' रणभूमि में खड़े होते जा रहे थे।"
            "यह दृश्य उस 'विषैले चक्र' (Vicious Cycle) को दिखाता है जहाँ समस्या खुद को ही पैदा करती रहती है।"
            "रणभूमि अब अज्ञान के हज़ारों क्लोनों से पूरी तरह भर चुकी थी और स्थिति अत्यंत गंभीर हो गई थी।"
        """.trimIndent(),
        english = """
            (Raktabija's Counter-Attack): "That demon Raktabija also raised his massive mace and initiated strikes against the Divine Shaktis."
            "He was swinging his weapon like a maniac, desperately attempting to wound and intimidate the Matrikas."
            "However, during the intense combat, whenever the Shaktis struck him back, his body bled profusely once again."
            "This symbolizes the absolute 'Resistance' of the Ego, which exerts total force before its final collapse."
            "When we attempt to modify an old toxic habit, it strikes back at our psyche like a heavy physical mace."
            "The continuous flow of blood proves that ignorance is struggling to sustain its leaked life-energy."
            "Arrogance falsely believes that through intimidation, it can successfully disperse the divine Sattvic virtues."
            "Every time he was injured, multiple new 'Raktabijas' were manifesting across the entire cosmic battlefield."
            "This specific visual illustrates that 'Vicious Cycle' where the problem independently recreates itself."
            "The battlefield was now entirely saturated with thousands of demonic clones, making the situation critical."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 47,
        sanskrit = "ततस्तैरसुरांशैश्च रक्तसम्भूतैः सहस्रशः ।\nव्याप्तमेतज्जगत्सर्वं जनैर्भीतमभूत्तदा ॥ ५१ ॥",
        hindi = """
            (जगत् में असुरों का विस्तार): "रक्तबीज के खून से पैदा हुए उन हज़ारों 'असुरांशों' (अंशों) से अब यह पूरा ब्रह्मांड भर गया था।"
            "देखते ही देखते हज़ारों रक्तबीज हर दिशा में खड़े हो गए, जिससे साधारण लोग और देवता अत्यंत भयभीत हो उठे।"
            "यह 'एंग्जायटी' (Anxiety) की वह अवस्था है जब एक छोटी सी चिंता पूरी दुनिया को डरावना बना देती है।"
            "इंसान को लगता है कि अब बचने का कोई रास्ता नहीं है, क्योंकि हर तरफ केवल 'राक्षस' (नकारात्मक विचार) हैं।"
            "व्याप्तमेतज्जगत् (पूरा जगत् व्याप्त हो गया)—इसका अर्थ है कि नेगेटिविटी ने पूरे माइंड-स्पेस पर कब्ज़ा कर लिया है।"
            "भय (Fear) तब पैदा होता है जब हम अज्ञान की 'संख्या' (Quantity) को सत्य की 'शक्ति' से बड़ा समझने लगते हैं।"
            "अहंकार का यह जाल इतना फैल चुका था कि अब साधारण लॉजिक या विलपावर काम नहीं कर रहे थे।"
            "यह वह 'डार्क नाइट ऑफ द सोल' (Dark Night of the Soul) है जहाँ केवल ईश्वर की विशेष कृपा ही बचा सकती है।"
            "असुरों की यह भीड़ वास्तव में हमारे ही बिखरे हुए और अनियंत्रित विचारों का एक विशाल समूह थी।"
            "अब इस समस्या के समाधान के लिए देवी चण्डिका एक अत्यंत 'गुप्त रणनीति' (Secret Strategy) बनाने वाली थीं।"
        """.trimIndent(),
        english = """
            (Expansion of Demons in the Universe): "The entire cosmos was now completely filled with thousands of demonic clones born from Raktabija's blood."
            "In a single moment, thousands of identical demons stood in every direction, terrifying all beings and Gods."
            "This represents that stage of 'Anxiety' where a singular worry makes the entire world appear terrifying."
            "A human feels there is zero escape because every part of his mind is occupied by toxic thoughts."
            "The phrase 'Jagat-vyaptam' implies that negativity has successfully hijacked the entire mental workspace."
            "Fear manifests when we perceive the 'Quantity' of ignorance as superior to the 'Power' of Truth."
            "The web of arrogance had expanded so much that ordinary logic or willpower was proving ineffective."
            "This is the 'Dark Night of the Soul' where strictly only the absolute grace of God can offer a solution."
            "This crowd of demons was actually the collective manifestation of our own scattered and uncontrolled thoughts."
            "Now, to resolve this crisis, Goddess Chandika was preparing to formulate an exceptionally 'Secret Strategy'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 48,
        sanskrit = "ततो देवा विषादं ते जग्मुरत्युत्तमं नृप ।\nतान्विषण्णान् सुरान् दृष्ट्वा चण्डिका प्राह सत्वरा ॥ ५२ ॥",
        hindi = """
            (देवताओं का विषाद): "हे राजन्! असुरों की बढ़ती हुई संख्या को देखकर सभी देवता अत्यंत गहरे 'विषाद' (डिप्रेशन/दुख) में डूब गए।"
            "उन देवताओं को इस प्रकार दुखी और डरा हुआ देखकर, माता चण्डिका ने तुरंत (सत्वरा) कुछ कहा।"
            "'विषाद' (Vishada) वह मानसिक स्थिति है जब इंसान हार मान लेता है और उसे सब कुछ खत्म लगने लगता है।"
            "देवता (सद्गुण) भी कभी-कभी अज्ञान की भारी भीड़ को देखकर कमज़ोर पड़ जाते हैं।"
            "परंतु चेतना (चण्डिका) कभी हार नहीं मानती; वह हमेशा 'पॉजिटिव एक्शन' (Positive Action) के लिए तैयार रहती है।"
            "माता ने उन्हें 'सत्वरा' (जल्दी) ढांढस बंधाया, जो यह बताता है कि भगवान भक्त के दुख को बर्दाश्त नहीं करते।"
            "जब हमारी अच्छी प्रवृत्तियां रोती हैं, तभी 'सुप्रीम इंटेलिजेंस' (देवी) समाधान का रास्ता खोलती है।"
            "देवी की वाणी में वह आत्मविश्वास था जो बुझते हुए दीयों (देवताओं) को फिर से जला सकता था।"
            "अब चण्डिका माता काली (चामुण्डा) को एक ऐसा आदेश देने वाली थीं जो युद्ध के सारे नियम बदल देगा।"
            "यह वह टर्निंग पॉइंट है जहाँ से रक्तबीज के अंत की उल्टी गिनती (Countdown) शुरू होती है।"
        """.trimIndent(),
        english = """
            (The Sorrow of the Gods): "O King! Witnessing the multiplying numbers of demons, the Gods were plunged into profound 'Vishada' (Despair)."
            "Seeing those divine beings so dejected and terrified, Goddess Chandika spoke to them with great speed (Satvara)."
            "'Vishada' is that psychological state where a human gives up and perceives everything as permanently ruined."
            "Even divine virtues (Gods) sometimes falter when confronted by the overwhelming crowd of thick ignorance."
            "However, Consciousness (Chandika) never accepts defeat; She remains perpetually ready for 'Positive Action'."
            "The Mother consoled them with 'Satvara' (urgency), proving that the Divine does zero to tolerate a devotee's pain."
            "Strictly when our noble tendencies weep, the 'Supreme Intelligence' (Goddess) unlocks the path to a solution."
            "The Goddess's voice contained that self-confidence capable of reigniting the flickering lamps of the Gods."
            "Now Chandika was preparing to issue an order to Mother Kali that would change every rule of engagement."
            "This marks the ultimate turning point from which the countdown for Raktabija's death officially initiates."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 49,
        sanskrit = "उवाच कालीं चामुण्डे विस्तीर्णं वदनं कुरु ।\nमच्छस्त्रपातसम्भूतं रक्तबिन्दुं महासुरम् ॥ ५३ ॥",
        hindi = """
            (काली को आदेश): "देवी चण्डिका ने काली से कहा: 'हे चामुण्डे! तुम अपना मुख अत्यंत 'विस्तार' (विस्तीर्णं) से फैला लो'।"
            "'मेरे शस्त्रों के प्रहार से इस महा-असुर रक्तबीज के शरीर से खून की जो भी बूंदें गिरें'।"
            "'उन सभी बूंदों को तुम ज़मीन पर गिरने से पहले ही अपने मुख में समेट लेना'।"
            "यह 'ब्रह्मांडीय समाधान' (Cosmic Solution) है—समस्या को उसके 'सोर्स' (Source) पर ही खत्म करना।"
            "मुख फैलाना (Opening the mouth) 'अवेयरनेस' की उस असीमित क्षमता का प्रतीक है जो हर विचार को पकड़ लेती है।"
            "देवी कह रही हैं कि अज्ञान को ज़मीन (मन की गहराई) तक पहुँचने ही मत दो।"
            "जब हम अपने नेगेटिव विचारों को मन में बैठने (ज़मीन पर गिरने) का मौका नहीं देते, तो वे 'मल्टीप्लाई' नहीं हो पाते।"
            "चामुण्डा वह शक्ति है जो 'अटेंशन' (Attention) को ही अपना भोजन बना लेती है।"
            "अगर सारा अटेंशन (रक्त) देवी की ओर मुड़ जाए, तो अज्ञान के पास ज़िंदा रहने के लिए कोई ऊर्जा नहीं बचेगी।"
            "यह श्लोक 'माइंडफुलनेस' (Mindfulness) की सबसे ऊंची तांत्रिक तकनीक को डिकोड करता है।"
        """.trimIndent(),
        english = """
            (Order to Kali): "Goddess Chandika said: 'O Chamunda! Open Your mouth exceptionally 'Wide' (Vistirnam) and expand it'."
            "'Whatever drops of blood originate from this mega-demon Raktabija due to the strikes of My weapons'."
            "'Capture and consume all those drops instantaneously before they can ever touch the physical ground'."
            "This is the 'Cosmic Solution'—permanently terminating the problem at its absolute singular 'Source'."
            "Opening the mouth wide symbolizes the infinite capacity of 'Awareness' to catch every rising thought."
            "The Goddess commands that ignorance must zero be allowed to reach the ground (the depths of the mind)."
            "When we deny negative thoughts the chance to settle in our mind, they mathematically fail to 'Multiply'."
            "Chamunda is that power which transforms 'Attention' (the blood) into Her own divine nourishment."
            "If all attention is diverted toward the Goddess, ignorance is left with zero energy to sustain its existence."
            "This verse decodes the absolute highest Tantric technique of 'Military-grade Mindfulness'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 50,
        sanskrit = "रक्तबिन्दोः प्रतीच्छ त्वं वक्त्रेणानेन वेगिना ।\nभक्षयन्ती चर रणे तदुत्पन्नान्महासुरान् ॥ ५४ ॥",
        hindi = """
            (रक्त का भक्षण): "'तुम अपने इस अत्यंत 'वेगवान मुख' (वेगिना वक्त्रेण) से रक्तबीज के बहते हुए खून को पीती रहो'।"
            "'और उस खून से पैदा होने वाले राक्षसों को भी तुम रणभूमि में घूम-घूमकर (चर रणे) खाती जाओ'।"
            "यहाँ 'वेगिना' (तेज़) शब्द का अर्थ है—विचारों के आने की रफ्तार से भी तेज़ हमारी 'सजगता' (Awareness) होनी चाहिए।"
            "अगर हमारी अवेयरनेस सुस्त है, तो रक्तबीज (चिंता) जीत जाएगा; इसलिए काली को तेज़ी से काम करना होगा।"
            "राक्षसों को खाना मतलब अज्ञान की 'प्रोग्रामिंग' (Programming) को ही पूरी तरह मिटा देना।"
            "जब काली खून पीती हैं, तो वे वास्तव में इंसान के 'अटेंशन' को 'डिस्ट्रैक्शन' से बचा रही होती हैं।"
            "यह साधना का वह स्तर है जहाँ साधक अपने हर उठते हुए विचार को पैदा होते ही 'देख' (Observe) लेता है।"
            "देखते ही विचार शांत हो जाता है, क्योंकि उसे 'सीड' (Seed) बनने का मौका नहीं मिलता।"
            "रणभूमि में घूमना यह बताता है कि चेतना को मन के हर कोने में एक्टिव रहना होगा।"
            "अब अज्ञान का 'प्रोडक्शन' (Production) ही उसका विनाश बनने वाला था।"
        """.trimIndent(),
        english = """
            (Consuming the Blood): "'Continuously drink the flowing blood of Raktabija utilizing Your exceptionally 'Swift Mouth' (Vegina)'."
            "'And roam the battlefield (Chara Rane), devouring every single demon that attempts to manifest from that blood'."
            "The word 'Vegina' (Swift) implies our 'Awareness' must be faster than the absolute velocity of incoming thoughts."
            "If our awareness is sluggish, Anxiety (Raktabija) wins; therefore, Kali must operate with apocalyptic speed."
            "Devouring the demons translates to completely erasing the underlying 'Programming' of ignorance."
            "When Kali drinks the blood, She is actually saving the human's 'Attention' from being wasted on Distractions."
            "This is the meditative level where a practitioner 'Observes' every rising thought the exact moment it originates."
            "Observation causes the thought to settle instantly, as it is denied the chance to become a 'Seed'."
            "Roaming the field proves that Consciousness must remain highly Active in every single corner of the mind."
            "Now the 'Production' of ignorance was destined to become the very instrument of its total destruction."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 51,
        sanskrit = "एवं स क्षीयमाणोऽसृक् सोऽसुरो निघनं एष्यति ।\nभक्ष्यमाणास्त्वया चोग्रा न चोत्पत्स्यन्ति चापरे ॥ ५५ ॥",
        hindi = """
            (विनाश की योजना): "'इस प्रकार जब उसका खून (असृक्) पूरी तरह सूख (क्षीयमाणो) जाएगा, तो वह असुर मौत (निघनं) को प्राप्त होगा'।"
            "'चूँकि तुम उन उग्र राक्षसों को खाती रहोगी, इसलिए नए असुर 'पैदा ही नहीं हो पाएंगे' (न चोत्पत्स्यन्ति)'।"
            "यह 'रूट-कॉज एनालिसिस' (Root-cause Analysis) है—बीमारी को जड़ से कैसे खत्म किया जाए।"
            "जब अटेंशन (खून) खत्म हो जाता है, तो अहंकार का अस्तित्व खुद-ब-खुद मिट्टी में मिल जाता है।"
            "बुराई तब तक ज़िंदा रहती है जब तक हम उसे अपना 'ध्यान' और 'समय' देते हैं।"
            "देवी की योजना यह सुनिश्चित करती है कि अज्ञान का 'पुनर्जन्म' (Rebirth) न हो।"
            "यह मानसिक शांति पाने का वह 'अंतिम गुप्त फॉर्मूला' है जो सप्तशती हमें सिखाती है।"
            "राक्षसों का पैदा न होना मन की उस अवस्था को दर्शाता है जिसे 'निर्विचार' (Thoughtless state) कहते हैं।"
            "अहंकार अब अपने ही खून की कमी से मरने वाला था।"
            "इस श्लोक के साथ ही ब्रह्मांडीय युद्ध का सबसे निर्णायक (Decisive) मोड़ आ गया।"
        """.trimIndent(),
        english = """
            (The Plan of Annihilation): "'In this manner, when his blood (Asruk) is completely depleted, that demon shall meet his absolute Death'."
            "'Since You will be devouring those fierce monsters, zero new demons shall ever 'Manifest' (Na-chotpatsyanti)'."
            "This is a perfect 'Root-cause Analysis'—how to successfully terminate a disease from its absolute foundation."
            "When human attention (blood) is exhausted, the existence of the Ego automatically turns to common dust."
            "Evil survives strictly as long as we continue to grant it our 'Focus' and our precious 'Time'."
            "The Goddess's strategy guarantees that zero 'Rebirth' of ignorance can mathematically occur."
            "This is the 'Ultimate Secret Formula' for achieving absolute mental peace as taught by the Saptashati."
            "The failure of demons to manifest symbolizes that pure mental state known as 'Thoughtlessness' (Samadhi)."
            "Arrogance was now destined to die strictly due to the deficiency of its own leaked life-force."
            "With this specific verse, the most Decisive turning point of the cosmic war had finally arrived."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 52,
        sanskrit = "इत्युक्त्वा तां ततो देवी शूलेनैनमताडयत् ।\nमुखेन काली जग्राह रक्तबीजस्य शोणितम् ॥ ५६ ॥",
        hindi = """
            (युद्ध का प्रारंभ): "ऐसा कहकर माता चण्डिका ने अपने भयंकर 'शूल' (त्रिशूल) से रक्तबीज पर बहुत ज़ोरदार प्रहार किया।"
            "उसी क्षण माता काली ने अपने मुख से रक्तबीज के शरीर से बहते हुए 'खून' (शोणितम्) को पीना शुरू कर दिया।"
            "अब युद्ध का वह रूप शुरू हुआ जिसे देखकर ब्रह्मांड कांप उठा था।"
            "चण्डिका प्रहार (Striking) कर रही हैं और काली उस प्रहार के 'दुष्प्रभाव' (Side-effect) को रोक रही हैं।"
            "यह 'टीम-वर्क' (Teamwork) है—एक शक्ति बुराई को तोड़ती है, और दूसरी शक्ति उसे फैलने से बचाती है।"
            "त्रिशूल की चोट 'सत्य का प्रहार' है जो अज्ञान के शरीर को चीर देती है।"
            "काली का खून पीना यह दर्शाता है कि वे 'नेगेटिविटी' को दुनिया से हटाकर खुद में विलीन (Merge) कर रही हैं।"
            "अहंकार को अब अपने बचने का कोई रास्ता नहीं दिख रहा था, क्योंकि उसकी 'शक्ति' अब उसकी दुश्मन बन चुकी थी।"
            "यह दृश्य साक्षात् 'कॉस्मिक सर्जरी' (Cosmic Surgery) की तरह था जहाँ गंदगी को बहने नहीं दिया जा रहा था।"
            "युद्ध की यह नई तकनीक अज्ञान के लिए सबसे बड़ी दहशत (Horror) बन गई थी।"
        """.trimIndent(),
        english = """
            (The Battle Re-Initiates): "Having spoken thus, Goddess Chandika aggressively executed an apocalyptic strike upon Raktabija utilizing Her 'Trident'."
            "Simultaneously, Mother Kali began drinking the 'Blood' (Shonitam) gushing from Raktabija's body directly into Her mouth."
            "The format of the war now shifted into something that made the entire universe tremble with awe."
            "Chandika is executing the 'Strike', while Kali is neutralizing the potential 'Side-effects' of that strike."
            "This is supreme 'Teamwork'—one power shatters the evil, and the other prevents it from spreading further."
            "The impact of the Trident is the 'Blow of Truth' that ruthlessly rips through the physical shell of ignorance."
            "Kali drinking the blood proves She is removing 'Negativity' from the world and merging it into Her own Void."
            "Arrogance saw zero escape routes because its own vital life-force was now being consumed by the Divine."
            "This scene was identical to an advanced 'Cosmic Surgery' where zero contamination was allowed to leak."
            "This brand-new combat technique became the absolute greatest Horror for the forces of ignorance."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 53,
        sanskrit = "ततोऽसावाहनं चक्रे गदया तत्र चण्डिकाम् ।\nन चास्य वेदनां चक्रे गदापातोऽल्पिकामपि ॥ ५७ ॥",
        hindi = """
            (रक्तबीज की गदा का प्रहार): "तब उस रक्तबीज ने भयंकर क्रोध में आकर अपनी 'गदा' से माता चण्डिका पर प्रहार किया।"
            "परंतु उस गदा की मार से माता चण्डिका को 'रत्ती भर' (अल्पिकामपि) भी पीड़ा या दर्द (वेदनां) महसूस नहीं हुआ।"
            "यह श्लोक अज्ञान की 'लिमिट' और सत्य की 'अजेयता' (Invincibility) को सिद्ध करता है।"
            "गदा (Ego) कितनी भी भारी क्यों न हो, वह 'परम चेतना' को कभी चोट नहीं पहुँचा सकती।"
            "इंसान के बुरे विचार या गालियां सत्य का कुछ नहीं बिगाड़ सकते, वे केवल शोर मचा सकते हैं।"
            "माता का 'न वेदनां' (कोई दर्द नहीं) होना यह बताता है कि वे 'स्थिर' (Still) हैं।"
            "जब आप सत्य में स्थित होते हैं, तो दुनिया का कोई भी अपमान या संकट आपको मानसिक रूप से 'हिला' नहीं सकता।"
            "रक्तबीज अपनी पूरी पाश्विक ताकत लगा रहा था, पर वह साक्षात् आकाश पर मुक्का मारने जैसा था।"
            "अहंकार का यह आक्रमण उसकी हताशा (Despair) का सबसे बड़ा सबूत था।"
            "वह अब समझ चुका था कि उसके हथियार बेकार हो चुके हैं, फिर भी वह लड़ता रहा।"
        """.trimIndent(),
        english = """
            (The Strike of Raktabija's Mace): "Then Raktabija, consumed by extreme wrath, delivered a heavy strike upon Chandika utilizing his 'Mace'."
            "However, the impact of that mace caused 'Absolutely Zero' (Alpikamapi) pain or suffering (Vedanam) to the Goddess."
            "This verse flawlessly proves the strict limit of ignorance and the absolute 'Invincibility' of Supreme Truth."
            "Regardless of how heavy the Mace (Ego) is, it can mathematically never cause a wound to 'Infinite Consciousness'."
            "Human toxic thoughts or insults can zero percent damage the Truth; they can strictly only generate meaningless noise."
            "The Mother's lack of pain proves that She remains perfectly 'Still' and undisturbed by external variables."
            "When you are firmly rooted in Truth, zero worldly insults or crisis can successfully 'Shake' your mental stability."
            "Raktabija was utilizing his absolute maximum animalistic force, which was as futile as punching the empty sky."
            "This specific assault by the Ego was the absolute greatest evidence of its mounting psychological Despair."
            "He realized his weapons had become mathematically useless, yet he stubbornly continued his hopeless struggle."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 54,
        sanskrit = "तस्याहतस्य देहात्तु बहु सुस्राव शोणितम् ।\nयतस्ततस्तद्वदनेन चामुण्डा सम्प्रतीच्छति ॥ ५८ ॥",
        hindi = """
            (चामुण्डा द्वारा रक्त-संग्रह): "जब देवी ने रक्तबीज को घायल किया, तो उसके शरीर से फिर से बहुत सारा खून (शोणितम्) बहने लगा।"
            "परंतु वह खून जहाँ-जहाँ से भी गिरता, माता चामुण्डा उसे अपने 'मुख' (वदनेन) में तुरंत झेल लेती थीं।"
            "यह 'कम्प्लीट कंट्रोल' (Complete Control) की स्थिति है—अब अज्ञान का एक कतरा भी बाहर नहीं जा रहा था।"
            "चामुण्डा (काली) का मुख अब ब्रह्मांडीय फिल्टर (Filter) की तरह काम कर रहा था।"
            "वह खून जिसे नई मुसीबतें पैदा करनी थीं, अब वही खून देवी के लिए 'शक्ति' बन रहा था।"
            "अहंकार का जो 'अटेंशन' (Attention) कल तक दुनिया को भटका रहा था, आज वही अटेंशन 'ईश्वर' की ओर मुड़ गया था।"
            "जब हम अपनी सारी ऊर्जा को भगवान की ओर मोड़ देते हैं, तो बुराई अपने आप भूखी होकर मरने लगती है।"
            "राक्षस के शरीर से निकलता खून उसकी 'हार' का बहता हुआ दस्तावेज़ था।"
            "माता चामुण्डा की एकाग्रता इतनी तीव्र थी कि एक भी बूंद ज़मीन को छू नहीं पा रही थी।"
            "अज्ञान का यह सबसे बड़ा 'ड्रेनेज' (Drainage) था, जहाँ वह अपनी सारी लाइफ-फोर्स खो रहा था।"
        """.trimIndent(),
        english = """
            (Blood Collection by Chamunda): "Whenever the Goddess wounded Raktabija, a massive quantity of blood (Shonitam) began gushing from his body."
            "But wherever that blood attempted to fall, Mother Chamunda instantaneously captured it within Her 'Mouth' (Vadanena)."
            "This represents a state of 'Complete Control'—now zero percent of ignorance was allowed to escape Her surveillance."
            "Chamunda's (Kali's) mouth was now functioning as the absolute ultimate 'Cosmic Filter' of the entire universe."
            "The very blood destined to manufacture new disasters was now becoming the direct 'Power' of the Goddess."
            "The human 'Attention' that was distracting the world yesterday was now successfully diverted toward the Divine."
            "The moment we redirect our total energy toward God, evil automatically begins to starve and perish."
            "The blood flowing from the demon's body served as a liquid document of his absolute inevitable defeat."
            "Mother Chamunda's focus was so exceptionally intense that mathematically zero drops could touch the ground."
            "This was the absolute greatest 'Drainage' of ignorance, where it was rapidly losing its total cosmic life-force."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 55,
        sanskrit = "मुखे समुद्गता येऽस्या रक्तबिन्दोर्महासुराः ।\nतांश्चखादाथ चामुण्डा पपौ तस्य च शोणितम् ॥ ५९ ॥",
        hindi = """
            (नए असुरों का भक्षण): "रक्तबीज के उस खून से जो भी नए महा-असुर माता के 'मुख के अंदर ही' पैदा हुए।"
            "चामुण्डा ने उन्हें पैदा होते ही तुरंत चबाकर खा लिया (चखादाथ) और फिर से उस खून को पीती रहीं।"
            "यह 'स्पीडी रिस्पॉन्स' (Speedy Response) का चरम है—बुराई को पैदा होते ही खत्म कर देना।"
            "जब मन के अंदर कोई नेगेटिव विचार आता है, तो उसे 'एंटरटेन' करने के बजाय उसे 'अब्ज़ॉर्ब' कर लेना ही बुद्धिमानी है।"
            "काली का उन्हें खाना यह दर्शाता है कि वे अज्ञान की 'प्रोग्रामिंग' को ही अपनी ऊर्जा में बदल रही हैं।"
            "राक्षस सोच रहे थे कि वे मुख के अंदर लड़ेंगे, पर वे देवी की 'पाचन शक्ति' (Digestive Power) के आगे ढेर हो गए।"
            "यह साधना की वह अवस्था है जहाँ 'डिस्ट्रेक्शन' (Distraction) ही 'ध्यान' (Meditation) का हिस्सा बन जाता है।"
            "चामुण्डा ने अज्ञान के हर 'बीज' (Seed) को फल बनने से पहले ही नष्ट कर दिया था।"
            "अब अज्ञान की सेना उसके अपने विनाश का एकमात्र साधन (Instrument) बन चुकी थी।"
            "रणभूमि में अब केवल काली का अट्टहास और राक्षसों के खत्म होने की आवाज़ गूंज रही थी।"
        """.trimIndent(),
        english = """
            (Devouring the New Clones): "Whatever brand-new mega-demons manifested strictly 'Inside the Mouth' from Raktabija's blood."
            "Chamunda instantaneously chewed and devoured them (Chakhada) and continued relentlessly drinking the fresh blood."
            "This is the peak of 'Speedy Response'—permanently terminating the evil at the exact moment of its birth."
            "When a negative thought arises within the mind, instead of 'Entertaining' it, one must 'Absorb' it into awareness."
            "Kali devouring them signifies She is transforming the very 'Programming' of ignorance into Her own pure energy."
            "The demons deluded themselves thinking they could fight inside Her mouth, but they were pulverized by Her power."
            "This represents the meditative state where even a 'Distraction' becomes an integral part of the 'Meditation'."
            "Chamunda successfully annihilated every 'Seed' of ignorance before it could ever bear the fruit of new trouble."
            "Now the clone army of ignorance had become the singular instrument for its own absolute total annihilation."
            "Only Kali's cosmic laughter and the sounds of perishing demons now resonated throughout the entire battlefield."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 56,
        sanskrit = "देवी शूलेन वज्रेण बाणैः खड्गैर्ऋष्टिभिः ।\nजघान रक्तबीजं तं चामुण्डापीतशोणितम् ॥ ६० ॥",
        hindi = """
            (अंतिम प्रहार): "उधर देवी चण्डिका ने अपने शूल, वज्र, बाणों और तलवारों से उस मूल रक्तबीज पर भयंकर प्रहार किए।"
            "जबकि इधर माता चामुण्डा लगातार उसके बहते हुए सारे खून (शोणितम्) को पीती जा रही थीं।"
            "अब 'प्रहार' और 'प्यूरिफिकेशन' (Purification) दोनों एक ही समय पर पूरे तालमेल के साथ हो रहे थे।"
            "यह श्लोक 'परम शुद्धि' (Complete Purification) की प्रक्रिया को दर्शाता है।"
            "देवी के अस्त्र (शूल, वज्र) अज्ञान के 'अस्तित्व' को काट रहे थे, और काली उसे 'फैलने' से रोक रही थीं।"
            "जब इंसान अपने अज्ञान (रक्तबीज) पर ज्ञान की तलवार चलाता है, तो उसे अपनी 'सजगता' (काली) को भी एक्टिव रखना पड़ता है।"
            "बिना सजगता के केवल ज्ञान भी कभी-कभी नए 'कुतर्क' (रक्तबीज) पैदा कर देता है।"
            "रक्तबीज अब अपनी पूरी ताकत खो चुका था, क्योंकि उसके पास अब कोई 'बैकअप' (Backup) नहीं बचा था।"
            "देवी का हर वार उसे उसकी मौत के एक कदम और करीब ले जा रहा था।"
            "यह दृश्य ब्रह्मांड की सबसे बड़ी 'सफाई' (Cleansing) का सजीव चित्रण था।"
        """.trimIndent(),
        english = """
            (The Final Assault): "Goddess Chandika delivered fierce strikes upon the original Raktabija utilizing Her Trident, Thunderbolt, Arrows, and Swords."
            "While simultaneously, Mother Chamunda was relentlessly and continuously drinking every drop of his flowing blood."
            "The 'Strike' and the 'Purification' were now occurring in perfect synchronization and absolute cosmic harmony."
            "This verse illustrates the specific and meticulous process of achieving 'Complete Psychological Purification'."
            "The Goddess's weapons were severing the 'Existence' of ignorance, while Kali was preventing its 'Expansion'."
            "When a human strikes his ignorance with the sword of wisdom, he must also keep his 'Awareness' (Kali) highly Active."
            "Without continuous awareness, even wisdom sometimes generates brand-new 'False Logics' and excuses."
            "Raktabija had now lost his absolute total strength because he possessed zero surviving 'Backup' or clone army."
            "Every single blow delivered by the Goddess was pushing him one step closer to his absolute certain cosmic death."
            "This scene was the living, breathing manifestation of the absolute greatest 'Cleansing' in the history of the universe."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 57,
        sanskrit = "स पपात महीपृष्ठे शस्त्रसङ्घातविह्वलः ।\nनीरक्तश्च महाराज रक्तबीजो महासुरः ॥ ६१ ॥",
        hindi = """
            (रक्तबीज का पतन): "हे महाराज! देवी के इतने सारे शस्त्रों के प्रहार से व्याकुल होकर (विह्वलः) वह महा-असुर रक्तबीज।"
            "पूरी तरह से 'खून से खाली' (नीरक्तश्च) होकर अंततः उस रणभूमि की धूल में गिर पड़ा (पपात महीपृष्ठे)!"
            "यह अहंकार का 'अंतिम पतन' है—जब उसके अंदर का सारा 'अटेंशन' (खून) और 'ताकत' पूरी तरह खत्म हो गई।"
            "नीरक्त (Bloodless) होने का अर्थ है कि अब अज्ञान के पास खुद को ज़िंदा रखने के लिए कोई 'एनर्जी' नहीं बची।"
            "जब इंसान अपने नेगेटिव विचारों को पोषण देना बंद कर देता है, तो वे इसी तरह 'नीरक्त' होकर गिर जाते हैं।"
            "महीपृष्ठे (ज़मीन पर) गिरना यह बताता है कि घमंड की वह ऊँची मीनार अब धूल में मिल चुकी थी।"
            "रक्तबीज का मरना यह साबित करता है कि 'एंग्जायटी' और 'ओवरथिंकिंग' का भी अंत निश्चित है।"
            "बस शर्त यह है कि आपकी 'अवेयरनेस' (काली) उसे मन की गहराई (ज़मीन) तक न पहुँचने दे।"
            "एक अत्यंत डरावना और अजेय लगने वाला राक्षस अब महज़ एक बेजान लाश बनकर पड़ा था।"
            "सत्य ने एक बार फिर अपनी अजेयता और ब्रह्मांडीय न्याय को पूरी तरह से सिद्ध कर दिया था।"
        """.trimIndent(),
        english = """
            (The Fall of Raktabija): "O King! Overwhelmed and shattered by the massive collection of the Goddess's weapons (Vihvalah)."
            "That mega-demon Raktabija, having become entirely 'Bloodless' (Niraktah), finally dropped dead to the dirt battlefield!"
            "This is the 'Absolute Fall' of arrogance—when its internal 'Attention' (blood) and energy are completely depleted."
            "Being 'Bloodless' implies that ignorance now possesses mathematically zero energy to sustain its own toxic life."
            "When a human permanently ceases to nourish his negative thoughts, they drop dead identically in this bloodless manner."
            "Falling to the ground proves that the high tower of false pride has now been successfully reduced to common dust."
            "The death of Raktabija confirms that even the most extreme 'Anxiety' and 'Overthinking' has a definite termination."
            "The strict condition is that your 'Awareness' (Kali) must prevent it from settling in the depths of the mind."
            "An entity that appeared exceptionally terrifying and invincible was now merely a lifeless and pathetic corpse."
            "Absolute Truth had once again flawlessly proven its total Invincibility and the presence of Cosmic Justice."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 58,
        sanskrit = "ततस्ते हर्षमतुलं अवापुस्त्रिदशा नृप ।\nतेषां मातृगणो जातो रक्तपातनमदौद्धतः ॥ ६२ ॥",
        hindi = """
            (देवताओं का हर्ष): "हे राजन्! रक्तबीज के मरते ही सभी देवताओं को एक 'अतुलनीय हर्ष' (परम सुख) प्राप्त हुआ।"
            "और मातृकाओं का वह पूरा समूह उस राक्षस के 'रक्त का पान' करने के नशे में अत्यंत आनंदित हो उठा।"
            "अतुलनीय हर्ष (Incomparable Joy) वह 'रिलीफ' है जो एंग्जायटी और डिप्रेशन के खत्म होने पर महसूस होता है।"
            "देवता (सद्गुण) अब फिर से आज़ाद थे क्योंकि उन्हें घेरने वाली वह 'चेन-रिएक्शन' वाली बुराई अब खत्म हो चुकी थी।"
            "मातृकाओं का 'मद' (Intoxication) बुराई के विनाश का वह नशा है जो आत्मा को शुद्ध आनंद से भर देता है।"
            "जब हमारे सात्विक गुण बुराई को 'कन्ज्यूम' (Consume) कर लेते हैं, तो वे और भी ज़्यादा शक्तिशाली हो जाते हैं।"
            "यह दृश्य बताता है कि जीत केवल सत्य की नहीं, बल्कि उस पूरी 'साधना' (Process) की हुई है।"
            "पूरा ब्रह्मांड अब उस शांति का अनुभव कर रहा था जो केवल अहंकार के मिटने के बाद ही संभव है।"
            "देवताओं का भय अब हमेशा के लिए खत्म हो चुका था और वे देवी की जय-जयकार करने लगे।"
            "यह अध्याय के समापन की वह सुखद घड़ी थी जिसका इंतज़ार पूरी सृष्टि कर रही थी।"
        """.trimIndent(),
        english = """
            (The Joy of the Gods): "O King! Exactly upon the death of Raktabija, absolutely all the Gods achieved an 'Incomparable Joy'."
            "And the entire group of Matrikas became exceptionally ecstatic and intoxicated by the absolute 'Consumption of the blood'."
            "Incomparable Joy represents that profound psychological 'Relief' felt exactly after Anxiety and Depression are terminated."
            "The divine virtues (Gods) were now free because that specific 'Chain-reaction' evil had been successfully erased."
            "The 'Intoxication' of the Matrikas is that specific spiritual ecstasy born from the total annihilation of toxicity."
            "When our pure internal qualities 'Consume' and neutralize evil, they become mathematically more powerful and stable."
            "This scene proves that the victory belongs zero to Truth alone, but to the entire 'Spiritual Process' itself."
            "The entire universe was now experiencing that peace which is strictly possible only after the dissolution of the Ego."
            "The fear of the Gods had permanently vanished, and they initiated absolute chants of victory for the Goddess."
            "This was the blissful hour of concluding the chapter, which the entire creation had been desperately awaiting."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 59,
        sanskrit = "नृत्यन्ति स्म ततस्तत्र मातृवर्गः प्रहर्षितः ।\nरुधिरौघमदधुस्तैर्निहतैरसुरोत्तमैः ॥ ६३ ॥\n\n(इति श्रीमार्कण्डेयपुराणे सावर्णिके मन्वन्तरे देवीमाहात्म्ये रक्तबीजवधो नाम अष्टमोऽध्यायः ॥ ८ ॥)",
        hindi = """
            (विजय उत्सव और समापन): "रणभूमि में मातृकाओं का वह समूह अत्यंत हर्षित होकर 'नृत्य' (Dance) करने लगा।"
            "वे उन मारे गए श्रेष्ठ असुरों के खून के प्रवाह (रुधिरौघ) से पूरी तरह संतुष्ट और मगन हो गई थीं।"
            "नृत्य (Dance) उस 'क्रिएटिव एनर्जी' की वापसी का प्रतीक है जो युद्ध (तनाव) के कारण रुक गई थी।"
            "जब मन से 'रक्तबीज' (चिंताएं) निकल जाती हैं, तो जीवन का उत्सव (Celebration) अपने आप शुरू हो जाता है।"
            "यहीं पर श्री मार्कण्डेय पुराण में वर्णित दुर्गा सप्तशती का 'रक्तबीज-वध' नामक आठवां अध्याय पूर्ण होता है।"
            "यह अध्याय हमें सिखाता है कि कुछ समस्याओं से 'लड़ना' काफी नहीं है, उन्हें 'निगलना' (Absorb) पड़ता है।"
            "काली का खून पीना हमें 'माइंडफुलनेस' की वह ताकत देता है जिससे हम अपने ही विचारों को कंट्रोल कर सकें।"
            "अब शुम्भ और निशुम्भ का अंत बिल्कुल करीब है, क्योंकि उनकी आखिरी और सबसे बड़ी रक्षा ढाल गिर चुकी है।"
            "अहंकार के विनाश का यह सफर अब अपने सबसे निर्णायक (Decisive) पड़ाव की ओर बढ़ रहा है।"
            "सत्य की जय हो, और अज्ञान का हमेशा के लिए सर्वनाश हो।"
        """.trimIndent(),
        english = """
            (Victory Dance and Conclusion): "The assembly of the Matrikas initiated an ecstatic and rhythmic 'Dance' across the battlefield."
            "They were entirely satisfied and deeply absorbed by the absolute depletion of the blood of those demon lords."
            "The Dance symbolizes the return of 'Creative Energy' which had been suppressed during the psychological war."
            "Exactly when 'Raktabija' (Anxiety) exits the mind, the natural Celebration of life automatically commences."
            "Right exactly here successfully concludes the Eighth Chapter of the text, named 'The Slaughter of Raktabija'."
            "This chapter teaches that for some problems, 'Fighting' is insufficient; they must be 'Absorbed' into awareness."
            "Kali drinking the blood grants us that specific 'Mindfulness' required to master our own internal thought-stream."
            "The final end of Shumbha and Nishumbha is now imminent, as their absolute greatest defensive shield has collapsed."
            "The journey of the Ego's destruction is now moving toward its absolute most Decisive and ultimate stage."
            "Victory to the Absolute Truth, and may deep-seated ignorance be permanently annihilated from the soul."
        """.trimIndent()
    )
)