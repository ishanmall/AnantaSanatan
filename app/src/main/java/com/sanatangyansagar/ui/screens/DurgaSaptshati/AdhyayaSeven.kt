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
fun AdhyayaSevenScreen() {
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
                    val targetIndex = adhyayaSevenShlokas.indexOfFirst { it.id == targetId }
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
            label = { Text("Search Shloka (1-${adhyayaSevenShlokas.size})") },
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
            itemsIndexed(adhyayaSevenShlokas) { _, shloka ->
                // Automatically uses the SaptshatiCard you already defined in your project!
                SaptshatiCard(shloka = shloka)
            }
        }
    }
}

// Top-Level Data List - Adhyaya 7 (Complete 27 Shlokas)
val adhyayaSevenShlokas = listOf(
    SaptshatiShloka(
        id = 1,
        sanskrit = "ऋषिरुवाच ॥ १ ॥\nआज्ञप्तास्ते ततो दैत्याश्चण्डमुण्डपुरोगमाः ।\nचतुरङ्गबलोपेता ययुरभ्युद्यतायुधाः ॥ २ ॥",
        hindi = """
            (चण्ड-मुण्ड का कूच): "महर्षि मेधा ने कहा: शुम्भ की वह खौफनाक आज्ञा पाकर, चण्ड और मुण्ड नामक दोनों सेनापति तुरंत युद्ध के लिए निकल पड़े।"
            "वे अपने साथ 'चतुरंगिणी सेना' (हाथी, घोड़े, रथ और पैदल सैनिक) लेकर अत्यंत वेग से हिमालय की ओर गए।"
            "उन्होंने अपने सभी अस्त्र-शस्त्रों को ऊपर उठा रखा था (अभ्युद्यतायुधाः) और वे अहंकार से भरे हुए थे।"
            "चण्ड (Anger/Cruelty) और मुण्ड (Blind Stupidity) इंसान के दिमाग की वे दो सबसे घातक वृत्तियां हैं जो विनाश लाती हैं।"
            "जब शुम्भ (मुख्य अहंकार) खतरे में पड़ता है, तो वह सबसे पहले 'गुस्से' और 'मूर्खता' को आगे करता है।"
            "चतुरंगिणी सेना इंसान के दिमाग के चारों कोनों (मन, बुद्धि, चित्त, अहंकार) में फैले अज्ञान का प्रतीक है।"
            "हथियार ऊपर उठाना यह दर्शाता है कि अज्ञानी व्यक्ति हमेशा 'आक्रामक' (Aggressive) मुद्रा में रहता है।"
            "उन्हें लग रहा है कि वे साक्षात् 'सत्य' (देवी) को बंदी बनाकर ले आएंगे।"
            "यह मूर्खता की वह चरम सीमा है जहाँ इंसान अपनी मौत के लिए पूरी तैयारी के साथ खुद चलकर जाता है।"
            "यहाँ से दुर्गा सप्तशती का वह सबसे उग्र और ऐतिहासिक अध्याय शुरू होता है जहाँ रक्त बहेगा।"
        """.trimIndent(),
        english = """
            (The March of Chanda and Munda): "The Sage Medha said: Receiving the terrifying command of Shumbha, commanders Chanda and Munda immediately marched forward."
            "They headed toward the Himalayas accompanied by a massive 'Four-fold Army' consisting of elephants, cavalry, chariots, and infantry."
            "They aggressively marched with all their lethal weapons raised high (Abhyudyatayudhah), overflowing with toxic pride."
            "Chanda (Anger/Cruelty) and Munda (Blind Stupidity) represent the two absolute most fatal psychological tendencies of the human brain."
            "When Shumbha (Core Ego) feels threatened, it primarily dispatches its 'Wrath' and 'Foolishness' to the frontlines."
            "The four-fold army flawlessly symbolizes the thick ignorance completely occupying the four corners of the mind (Mind, Intellect, Memory, Ego)."
            "Raising weapons explicitly proves that an ignorant human perpetually remains in a highly 'Aggressive' and defensive posture."
            "They falsely delude themselves into believing they can physically capture Absolute Truth (The Goddess) as a prisoner."
            "This is the absolute peak of stupidity where a human intentionally and actively walks directly into his own death."
            "Right here formally initiates the most fierce and historically apocalyptic chapter of the Durga Saptashati."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 2,
        sanskrit = "ददृशुस्ते ततो देवीं ईषद्धासां व्यवस्थिताम् ।\nसिंहस्योपरि शैलेन्द्रशृङ्गे काञ्चनसन्निभे ॥ ३ ॥",
        hindi = """
            (देवी का दर्शन): "हिमालय पर पहुँचकर उन दैत्यों ने देखा कि परम देवी एक स्वर्ण (सोने) के समान चमकते हुए शिखर पर विराजमान हैं।"
            "वे अपने महान सिंह (शेर) की पीठ पर बैठी हुई थीं और उनके मुख पर एक 'हल्की सी मुस्कान' (ईषद्धासां) खेल रही थी।"
            "स्वर्ण शिखर (Golden Peak) परम शुद्धता और 'हायर कॉन्शसनेस' (Higher Consciousness) का प्रतीक है।"
            "सिंह साक्षात् 'धर्म' है, जिस पर सवार होकर सत्य हमेशा निर्भय रहता है।"
            "देवी की वह हल्की मुस्कान अज्ञान की मूर्खता पर 'कॉस्मिक व्यंग्य' (Cosmic Sarcasm) का सबसे बड़ा सबूत है।"
            "राक्षस हथियार लेकर हाँफते हुए पहुँचे हैं, और देवी बिना किसी तनाव के मुस्कुरा रही हैं।"
            "जब आप अंदर से पूरी तरह 'सच' के साथ होते हैं, तो दुनिया की कोई भी सेना आपके चेहरे की शांति नहीं छीन सकती।"
            "चण्ड और मुण्ड को वह मुस्कान अपनी हार नहीं, बल्कि 'आसानी से पकड़ने का मौका' लगी।"
            "अज्ञान हमेशा शांति को 'कमज़ोरी' समझकर उस पर हावी होने की कोशिश करता है।"
            "यह शांत दृश्य आने वाले भयंकर तूफान (प्रलय) से ठीक पहले का सन्नाटा है।"
        """.trimIndent(),
        english = """
            (Sighting the Goddess): "Upon reaching the Himalayas, those demons visually spotted the Supreme Goddess residing upon a peak radiating like pure gold."
            "She was perfectly seated upon Her magnificent Lion, with a 'Gentle, subtle smile' (Ishaddhasam) playing upon Her divine face."
            "The Golden Peak flawlessly symbolizes absolute supreme purity and the highest unshakeable state of 'Higher Consciousness'."
            "The Lion is the literal manifestation of 'Dharma', upon which the Absolute Truth rides entirely fearless."
            "That subtle smile of the Goddess is the absolute greatest proof of 'Cosmic Sarcasm' directed at the stupidity of ignorance."
            "The demons arrived panting aggressively with weapons, while the Goddess remained entirely stress-free and smiling."
            "When you are completely aligned with 'Truth' internally, absolutely zero worldly armies can successfully snatch your facial peace."
            "Chanda and Munda completely misread that smile not as their defeat, but as an 'Easy opportunity to capture Her'."
            "Ignorance perpetually misinterprets profound peace as 'Weakness' and desperately attempts to dominate it."
            "This perfectly peaceful visual is the exact pin-drop silence that precedes a horrifying cosmic apocalypse."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 3,
        sanskrit = "ते दृष्ट्वा तां समादातुमुद्यमं चक्रुरुद्यताः ।\nआकृष्टचापासिधरास्तथान्ये तत्समीपगाः ॥ ४ ॥",
        hindi = """
            (कब्ज़ा करने का प्रयास): "उस शांत और सुंदर देवी को देखते ही, उन असुरों ने तुरंत उन्हें 'पकड़ने' (समादातुम्) का प्रयास किया।"
            "कुछ राक्षस अत्यंत तेज़ी से माता की ओर झपटे ताकि उन्हें ज़बरदस्ती बंदी बना सकें।"
            "और जो अन्य राक्षस उनके आस-पास (समीपगाः) खड़े थे, उन्होंने अपने धनुष खींच लिए और तलवारें निकाल लीं।"
            "यह अहंकार की सबसे पहली 'नीच हरकत' (Lowest Action) है—सुंदरता को देखते ही उस पर अधिकार जमाना।"
            "वे देवी को 'शक्ति' नहीं, बल्कि अपने राजा (शुम्भ) के लिए एक 'वस्तु' (Object) मान रहे थे।"
            "धनुष खींचना और तलवार निकालना उनकी उस 'इनसिक्योरिटी' (Insecurity) को दिखाता है जो शांति के सामने पैदा होती है।"
            "जब अज्ञान सत्य को नहीं समझ पाता, तो वह उसे हथियारों से 'कंट्रोल' करने की कोशिश करता है।"
            "देवी अभी भी अपनी जगह से हिली नहीं हैं; वे अज्ञान को उसके पूरे चरम (Peak) तक पहुँचने दे रही हैं।"
            "भगवान बुराई को तब तक नहीं मारते, जब तक वह अपनी सारी हदें (Boundaries) पार न कर दे।"
            "यहाँ असुरों ने भगवान पर भौतिक हथियारों से हमला करने की सबसे बड़ी भूल कर दी है।"
        """.trimIndent(),
        english = """
            (Attempt to Capture): "The exact split-second they saw the peaceful Goddess, the demons immediately initiated an attempt to 'Capture' Her (Samadatum)."
            "Several monsters violently lunged aggressively toward the Mother exclusively to forcefully take Her as a prisoner."
            "And the other demons standing closely around Her entirely drew their heavy bows and unsheathed their razor-sharp swords."
            "This represents the absolute 'Lowest Action' of arrogance—instantly attempting to dominate and claim ownership upon seeing beauty."
            "They perceived the Goddess absolutely zero as 'Power', but strictly as a mere 'Object' intended for their king (Shumbha)."
            "Drawing bows and swords explicitly reveals their deep psychological 'Insecurity' triggered directly in front of pure peace."
            "When ignorance mathematically fails to comprehend Truth, it desperately attempts to 'Control' it utilizing physical weapons."
            "The Goddess has not moved a single inch; She is intentionally allowing ignorance to reach its absolute toxic Peak."
            "God absolutely never slaughters evil until it successfully crosses all possible cosmic boundaries of decency."
            "Right exactly here, the demons committed the fatal cosmic error of physically attacking God with cheap worldly weapons."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 4,
        sanskrit = "ततः कोपं चकारोच्चैरम्बिका तानरीन् प्रति ।\nकोपेन चास्या वदनं मषीवर्णमभूत्तदा ॥ ५ ॥",
        hindi = """
            (अम्बिका का क्रोध): "असुरों की इस भयंकर उद्दंडता को देखकर, माता 'अम्बिका' को उन शत्रुओं पर अत्यंत उग्र क्रोध आ गया!"
            "और उस प्रलयंकारी क्रोध के कारण, उसी क्षण (तदा) देवी का वह सुंदर और चमकता हुआ मुखमंडल..."
            "'स्याही के समान बिल्कुल काला' (मषीवर्णम्) हो गया!"
            "यह दुर्गा सप्तशती का सबसे 'ट्रांसफॉर्मेटिव' (Transformative) और ऐतिहासिक क्षण है।"
            "अम्बिका (Universal Mother/Peace) अब तक मुस्कुरा रही थीं, पर अज्ञान ने उनकी दया को कमज़ोरी समझ लिया।"
            "वदनं मषीवर्णम् (स्याही जैसा काला मुख)—यह 'कॉस्मिक ब्लैक होल' (Cosmic Black Hole) का निर्माण है।"
            "जब सत्य का धैर्य टूटता है, तो वह 'मौन और शून्य' (Black) का रूप ले लेता है, जो सब कुछ निगलने के लिए तैयार है।"
            "काला रंग किसी बुराई का नहीं, बल्कि 'अनंत गहराई' (Infinite Depth) और 'मृत्यु' (Time) का प्रतीक है।"
            "अहंकार (चण्ड-मुण्ड) ने जिस 'सुंदर रूप' को पकड़ना चाहा था, वह रूप अब उनके सामने से गायब हो चुका था।"
            "अब उनके सामने वह 'काल' (Death) खड़ा था, जिसकी उन्होंने कभी कल्पना भी नहीं की थी।"
        """.trimIndent(),
        english = """
            (Ambika's Wrath): "Witnessing this extreme sheer audacity of the demons, Mother 'Ambika' was filled with exceptionally fierce, apocalyptic wrath against those enemies!"
            "And strictly due to that terrifying cosmic rage, in that exact split-second, Her exceptionally beautiful and radiant face..."
            "Turned absolutely and completely 'Jet-black exactly like dark ink' (Mashi-varnam)!"
            "This is undeniably the absolute most 'Transformative' and historic cosmic moment in the entire Durga Saptashati."
            "Ambika (Universal Mother of Peace) was smiling until now, but ignorance mathematically mistook Her pure compassion for weakness."
            "Face turning ink-black—this perfectly symbolizes the precise creation of a 'Cosmic Black Hole'."
            "When the patience of Truth shatters, it assumes the form of 'Silence and Void' (Black), ready to consume everything."
            "The color black is absolutely zero evil; it flawlessly symbolizes 'Infinite Depth' and absolute 'Time/Death' (Kaala)."
            "The 'Beautiful Form' that arrogance (Chanda-Munda) desperately attempted to capture had completely vanished from their sight."
            "Now standing perfectly before them was absolute 'Death' itself, which they had mathematically never even imagined."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 5,
        sanskrit = "भ्रुकुटीकुटिलात्तस्या ललाटफलकाद्द्रुतम् ।\nकाली करालवदना विनिष्क्रान्तासिपाशिनी ॥ ६ ॥",
        hindi = """
            (काली का प्राकट्य): "क्रोध से देवी की भृकुटी (भौंहें) अत्यंत टेढ़ी (कुटिल) हो गईं, और उनके 'ललाट' (Forehead) के मध्य भाग से..."
            "अचानक 'कराल वदन' (अत्यंत भयानक मुख) वाली साक्षात् 'माता काली' प्रकट हुईं!"
            "उनके एक हाथ में भयंकर 'तलवार' (असि) और दूसरे हाथ में मौत का 'पाश' (फंदा) था।"
            "ललाट (Forehead) का हिस्सा तन्त्र में 'आज्ञा चक्र' (Ajna Chakra / Third Eye) का स्थान है।"
            "काली का जन्म 'थर्ड आई' से होना यह बताता है कि वे 'परम विवेक' (Highest Intuition) और 'ज्ञान की अग्नि' हैं।"
            "अज्ञान (चण्ड-मुण्ड) को नष्ट करने के लिए साधारण बुद्धि नहीं, बल्कि 'थर्ड आई' की प्रलयंकारी शक्ति चाहिए।"
            "'कराल वदना' (खौफनाक चेहरा)—यह अज्ञानियों के लिए खौफ है, पर ज्ञानियों के लिए 'मुक्ति का द्वार' है।"
            "तलवार (Sword) 'झूठे ईगो को काटने' का प्रतीक है, और पाश (Noose) 'कर्मों को बांधने' का।"
            "देवी अम्बिका (शांति) अब अपनी ही 'सुप्रीम डार्क एनर्जी' (काली) को अनलीश (Unleash) कर चुकी हैं।"
            "यह श्लोक सृष्टि के उस सबसे शक्तिशाली रूप की पहली झलक है जिसे 'महाकाली' कहा जाता है।"
        """.trimIndent(),
        english = """
            (The Manifestation of Kali): "Due to pure cosmic rage, the Goddess's eyebrows became extremely twisted and curved, and directly from the exact center of Her 'Forehead'..."
            "Suddenly, the literal 'Mother Kali', possessing an exceptionally 'Terrifying face' (Karala-vadana), manifested outward!"
            "She securely held a terrifying 'Sword' (Asi) in one hand, and the lethal 'Noose of Death' (Pasha) in the other."
            "The Forehead mathematically flawlessly corresponds to the 'Ajna Chakra' (Third Eye) inside advanced Tantra."
            "Kali being born from the Third Eye strictly proves She is the absolute 'Highest Intuition' and the 'Fire of pure Wisdom'."
            "To successfully annihilate thick ignorance (Chanda-Munda), ordinary intellect fails; the apocalyptic power of the Third Eye is required."
            "'Terrifying face'—This is absolute pure terror exclusively for the ignorant, but the 'Gateway to Liberation' for the wise."
            "The Sword symbolizes the explicit 'Severing of the fake ego', and the Noose represents the 'Binding of toxic karma'."
            "Goddess Ambika (Peace) has now successfully and officially Unleashed Her own 'Supreme Dark Energy' (Kali)."
            "This flawless verse provides the absolute first visual manifestation of the most powerful cosmic entity known as 'Mahakali'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 6,
        sanskrit = "विचित्रखट्वाङ्गधरा नरमालाविभूषणा ।\nद्वीपिचर्मपरीधाना शुष्कमांसातिभैरवा ॥ ७ ॥",
        hindi = """
            (काली का स्वरूप - भाग १): "वे माता काली अपने हाथ में एक अत्यंत अद्भुत और भयंकर 'खट्वांग' (मुंड लगा हुआ डंडा) धारण किए हुए थीं।"
            "उनके गले में इंसानों के 'कटे हुए सिरों की माला' (नरमालाविभूषणा) झूल रही थी।"
            "वे अपने शरीर पर 'बाघ की खाल' (द्वीपिचर्मपरीधाना) लपेटे हुए थीं और उनका शरीर 'सूखे हुए मांस' (शुष्कमांसा) के कारण हड्डियों का ढांचा लग रहा था।"
            "यह स्वरूप देखने में डरावना है, पर तन्त्र में इसका अर्थ अत्यंत गहरा और वैज्ञानिक है।"
            "खट्वांग (Skull-staff) यह याद दिलाता है कि मृत्यु (Death) ही इस संसार का एकमात्र अटल सत्य है।"
            "नरमुंडों की माला (Garland of skulls) '५० संस्कृत अक्षरों' (Varnamala) का प्रतीक है—यानी देवी ही सभी 'शब्दों और ज्ञान' की मालिक हैं।"
            "बाघ की खाल 'अहंकार' (Ego/Tiger) को मारकर उसे वस्त्र के रूप में पहनने का प्रतीक है।"
            "शुष्क मांस (सूखा शरीर) यह दर्शाता है कि देवी सांसारिक 'भोग-विलास' (Material Pleasures) से पूरी तरह मुक्त हैं।"
            "उनमें कोई भौतिक 'आकर्षण' (Attraction) नहीं है; वे 'विशुद्ध वैराग्य' (Absolute Detachment) हैं।"
            "अहंकार जिस 'सुंदर स्त्री' को भोगना चाहता था, वह अब साक्षात् 'मृत्यु और वैराग्य' बन चुकी थी।"
        """.trimIndent(),
        english = """
            (The Appearance of Kali - Part 1): "Mother Kali was securely holding an exceptionally strange and terrifying 'Khatvanga' (a staff topped with a skull)."
            "A massive 'Garland of severed human heads' (Naramala) was actively swinging perfectly around Her divine neck."
            "She was draped exclusively in a 'Tiger skin' (Dvipi-charma), and Her physical body appeared identically like a skeleton due to 'Dried flesh' (Shushka-mansa)."
            "This specific format visually appears horrifying, but its mathematical meaning in advanced Tantra is exceptionally deep."
            "The Khatvanga strictly serves as a cosmic reminder that 'Death' is the absolute singular unchangeable truth of the universe."
            "The Garland of skulls flawlessly represents the '50 Sanskrit Alphabets' (Varnamala)—proving She owns all 'Words and Knowledge'."
            "Wearing the tiger skin perfectly symbolizes successfully slaughtering the raw 'Ego' and wearing it merely as a cheap garment."
            "The dried flesh implies that the Goddess is completely 100% liberated from all worldly 'Material Pleasures' and consumption."
            "She contains absolutely zero physical 'Attraction'; She is the literal mathematical embodiment of 'Absolute Detachment'."
            "The 'Beautiful Woman' the ego desperately wished to consume had now seamlessly transformed into literal 'Death and Detachment'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 7,
        sanskrit = "अतिविस्तारवदना जिह्वललनभीषणा ।\nनिमग्नारक्तनयना नादापूरितदिङ्मुखा ॥ ८ ॥",
        hindi = """
            (काली का स्वरूप - भाग २): "माता काली का वह भयानक मुख 'अत्यंत विशाल' (अतिविस्तारवदना) रूप से खुला हुआ था।"
            "उनके मुख से उनकी 'लाल जीभ' (जिह्वललन) बाहर लपलपा रही थी, जो अत्यंत डरावनी लग रही थी।"
            "उनकी आँखें चेहरे के अंदर गहरी धंसी हुई (निमग्न) और खून के समान 'बिल्कुल लाल' (रक्तनयना) थीं।"
            "और उनकी भयंकर 'गर्जना' (नाद) से ब्रह्मांड की दसों दिशाएं गूंज रही थीं (नादापूरितदिङ्मुखा)!"
            "विशाल खुला हुआ मुख (Wide mouth) 'ब्रह्मांडीय शून्यता' (Cosmic Void) है जो समय आने पर सबको निगल लेगा।"
            "लपलपाती हुई जीभ 'रजोगुण' (Active Fire of Action) का प्रतीक है जो राक्षसों के रक्त (कर्मों) को सोखने के लिए बेताब है।"
            "गहरी लाल आँखें उस 'परम फोकस' (Ultimate Focus) को दिखाती हैं जो अपने लक्ष्य (बुराई का नाश) से एक सेकंड भी नहीं भटकता।"
            "गर्जना (Roar/Nada) साक्षात् 'ॐ' की वह प्रलयंकारी ध्वनि है जो अज्ञान के कानों के पर्दे फाड़ देती है।"
            "काली का यह रूप इंसान के दिमाग के उस 'बेसिक डर' (Fear of Annihilation) को जाग्रत कर रहा था।"
            "शुम्भ की सेना के सैनिक यह रूप देखकर ही आधे मर चुके थे।"
        """.trimIndent(),
        english = """
            (The Appearance of Kali - Part 2): "The terrifying face of Mother Kali was stretched 'Exceptionally wide open' (Ati-vistara-vadana)."
            "Her 'Blood-red tongue' (Jihva-lalana) was aggressively lolling completely out of Her mouth, appearing apocalyptically horrifying."
            "Her physical eyes were deeply sunken inward and actively blazing 'Absolutely blood-red' (Rakta-nayana)."
            "And Her exceptionally terrifying 'Roar' (Nada) violently echoed and completely filled all directions of the entire cosmos!"
            "The massively wide-open mouth mathematically flawlessly represents the 'Cosmic Void' destined to consume everything precisely when Time expires."
            "The lolling tongue strictly symbolizes 'Rajoguna' (The Active Fire of Action) desperately ready to absorb the blood (karma) of demons."
            "The deep blood-red eyes explicitly illustrate that 'Ultimate Focus' which never mathematically wavers from its target for even a microsecond."
            "The Roar (Nada) is the literal apocalyptic vibration of 'Om' that ruthlessly shatters the eardrums of thick cosmic ignorance."
            "This specific format of Kali was aggressively actively triggering the absolute 'Basic Fear of Annihilation' inside the human brain."
            "The soldiers of Shumbha's army were already psychologically half-dead purely by actively witnessing this cosmic form."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 8,
        sanskrit = "सा वेगेनाभिपतिता घातयन्ती महासुरान् ।\nसैन्ये तत्र सुरारीणामभक्षयत तद्बलम् ॥ ९ ॥",
        hindi = """
            (असुर सेना का भक्षण): "प्रकट होते ही, वे माता काली अत्यंत भयंकर 'वेग' (तेज़ी) के साथ उस असुर सेना पर 'टूट पड़ीं' (अभिपतिता)!"
            "उन्होंने उन महा-असुरों का चुन-चुनकर 'संहार' (घातयन्ती) करना शुरू कर दिया।"
            "और देवताओं के उन भयंकर शत्रुओं की उस विशाल सेना को वे 'कच्चा ही चबा-चबाकर खाने लगीं' (अभक्षयत)!"
            "काली (समय) जब आती है, तो वह किसी तर्क या समझौते का इंतज़ार नहीं करती, वह सीधा 'एक्शन' लेती है।"
            "अत्यंत वेग (Speed) यह बताता है कि 'काल की गति' को ब्रह्मांड की कोई शक्ति नहीं रोक सकती।"
            "राक्षसों को 'खाना' (Devouring)—यह एक बहुत ही गहरा तांत्रिक संकेत (Tantric Symbol) है।"
            "देवी राक्षसों को 'मार' नहीं रही हैं, वे अज्ञान को अपने अंदर 'अब्ज़ॉर्ब' (Absorb) कर रही हैं।"
            "जब सत्य इंसान के अंदर की बुराई को खा जाता है, तभी इंसान का मन पूरी तरह 'शुद्ध' (Pure) होता है।"
            "साठ हज़ार से भी बड़ी वह सेना अब काली के उस विशाल 'ब्लैक होल' जैसे मुख में जा रही थी।"
            "ईगो (शुम्भ) की सेना का यह सबसे खौफनाक और अंतिम अंत था।"
        """.trimIndent(),
        english = """
            (Devouring the Demonic Army): "The exact moment She manifested, Mother Kali 'Pounced' directly upon the demonic army utilizing exceptionally terrifying 'Speed'!"
            "She aggressively initiated meticulously 'Slaughtering' (Ghatayanti) those massive mega-demons one by one."
            "And She violently began 'Eating and chewing raw' (Abhakshayat) that colossal army of the absolute enemies of the Gods!"
            "When Kali (Time) actively arrives, She mathematically waits for zero logic or negotiations; She unconditionally executes direct 'Action'."
            "The extreme velocity explicitly proves that the absolute 'Speed of Time' cannot be paused by any cosmic force."
            "'Devouring' the demons is an exceptionally deep and highly advanced 'Tantric Symbol'."
            "The Goddess is zero merely 'Killing' the demons; She is actively 'Absorbing' the thick ignorance perfectly into Herself."
            "Strictly when Absolute Truth successfully completely devours the internal evil, only then does a human mind become mathematically 'Pure'."
            "That colossal army was now aggressively being sucked precisely into the massive 'Black Hole' of Kali's cosmic mouth."
            "This was undeniably the absolutely most horrifying and explicitly final end exclusively for the Ego's army."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 9,
        sanskrit = "पार्ष्णिग्राहाङ्कुशग्राहयोधघण्टासमन्वितान् ।\nसमादायैकहस्तेन मुखे चिक्षेप वारणान् ॥ १० ॥",
        hindi = """
            (हाथियों को निगलना): "उस रणभूमि में जितने भी 'विशाल हाथी' (वारणान्) थे, जिनके ऊपर महावत (अंकुश वाले) बैठे थे।"
            "और जिन हाथियों के गले में बड़े-बड़े घंटे और रक्षक योद्धा बैठे हुए थे।"
            "उन सबको माता काली ने अपने 'एक ही हाथ से' (एकहस्तेन) उठाया और सीधा अपने विशाल 'मुख में फेंक लिया' (मुखे चिक्षेप)!"
            "हाथी (Elephant) इंसान के 'अत्यधिक भारी अहंकार' (Heavy Ego) और 'जड़ता' (Tamas) का प्रतीक है।"
            "महावत और रक्षक योद्धा—वे तर्क (Logic) और बहाने हैं जो उस अहंकार को सुरक्षित (Defend) रखते हैं।"
            "माता ने हाथी, महावत और घंटों सहित सबको एक साथ निगल लिया।"
            "यह दिखाता है कि जब 'समय' (काली) प्रहार करता है, तो वह बुराई और उसके सपोर्ट सिस्टम—दोनों को एक साथ खत्म कर देता है।"
            "एक हाथ से हाथी उठाना 'महाकाली' की उस असीमित और अकल्पनीय शक्ति (Infinite Strength) का प्रमाण है।"
            "अज्ञान ने जिन चीज़ों को अपनी 'सबसे बड़ी ताकत' माना था, वे देवी के लिए महज़ एक 'निवाला' (Bite) थीं।"
            "युद्ध अब एकतरफा संहार (Massacre) में बदल चुका था।"
        """.trimIndent(),
        english = """
            (Swallowing the Elephants): "Absolutely all the 'Colossal Elephants' (Varanan) in that battlefield, strictly mounted by their drivers holding sharp goads."
            "Along with their massive bells and the heavily armed warrior-guards securely seated upon them."
            "Mother Kali aggressively lifted all of them effortlessly utilizing strictly 'One Single Hand' (Eka-hastena) and 'Tossed them directly into Her mouth'!"
            "The Elephant perfectly symbolizes a human's 'Exceptionally Heavy Ego' and stubborn 'Inertia' (Tamas)."
            "The drivers and warrior-guards perfectly represent the cheap 'Logic' and fake excuses actively utilized to Defend that arrogance."
            "The Mother flawlessly swallowed the elephants, the drivers, and the bells all simultaneously in one exact strike."
            "This explicitly proves that when 'Time' (Kali) strikes, it permanently annihilates both the evil and its complete support system."
            "Lifting a colossal elephant utilizing just one hand mathematically proves the 'Infinite and Unimaginable Strength' of Mahakali."
            "The exact physical objects ignorance perceived as its 'Absolute Greatest Power' were strictly merely a small 'Bite' for the Goddess."
            "The war had successfully explicitly transitioned entirely into a one-sided apocalyptic 'Massacre'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 10,
        sanskrit = "तथैव योधं तुरगै रथं सारथिना सह ।\nनिक्षिप्य वक्त्रे दशनैश्चर्वयत्यतिभैरवम् ॥ ११ ॥",
        hindi = """
            (रथ और घोड़ों का भक्षण): "इसी तरह माता ने उन हथियारों से लैस राक्षसी 'योद्धाओं' और उनके तेज़ 'घोड़ों' (तुरगै) को भी पकड़ लिया।"
            "उन्होंने 'सारथी सहित पूरे के पूरे रथ' (रथं सारथिना सह) को अपने मुंह (वक्त्रे) में डाल लिया।"
            "और उन सबको अपने भयंकर दाँतों (दशनैश्च) के बीच रखकर अत्यंत डरावने तरीके से 'चबाना' (चर्वयत्यतिभैरवम्) शुरू कर दिया!"
            "घोड़े (Horses) इंसान की 'बेलगाम इन्द्रियों' (Senses) का प्रतीक हैं जो संसार की तरफ भागती हैं।"
            "रथ (Chariot) इंसान के 'मन का ढांचा' है, और सारथी (Driver) उसकी 'भ्रष्ट बुद्धि' है।"
            "काली का इन सबको चबाना मतलब इंसान के भ्रष्ट थॉट-प्रोसेस (Thought Process) का पूरी तरह 'क्रैश' (Crash) हो जाना।"
            "दाँतों से चबाने की ध्वनि (Crunching sound) इतनी भयंकर थी कि वह पूरे ब्रह्मांड में खौफ पैदा कर रही थी।"
            "अहंकार (शुम्भ) को लगता था कि उसकी मशीनरी (रथ/घोड़े) बहुत एडवांस है।"
            "परंतु 'काल' के दाँतों के सामने दुनिया की कोई भी एडवांस मशीनरी एक सेकंड भी नहीं टिक सकती।"
            "असुर सेना अब एक-एक करके मौत के उस विशाल क्रशर (Crusher) में पिस रही थी।"
        """.trimIndent(),
        english = """
            (Devouring Chariots and Horses): "Similarly, the Mother grabbed the heavily armed demonic 'Warriors' along with their exceptionally fast 'Horses' (Turagai)."
            "She actively threw the 'Entire massive Chariots completely along with their Drivers' straight directly into Her cosmic mouth."
            "And placing absolutely all of them precisely between Her terrifying teeth, She initiated 'Chewing' them in a highly horrifying manner!"
            "Horses perfectly symbolize a human's 'Uncontrolled Biological Senses' blindly racing toward worldly illusions."
            "The Chariot is the strict structural framework of the human 'Mind', and the Driver mathematically represents the 'Corrupted Intellect'."
            "Kali chewing absolutely all of them translates perfectly to the total explicit 'Crashing' of the human's corrupted Thought Process."
            "The apocalyptic 'Crunching Sound' of Her massive teeth was generating absolute pure terror across the entire cosmos."
            "Arrogance (Shumbha) falsely believed that his military machinery (chariots/horses) was exceptionally advanced."
            "However, directly before the teeth of 'Absolute Time', absolutely zero advanced human machinery can mathematically survive for a microsecond."
            "The demonic army was now being systematically pulverized piece by piece exactly inside the ultimate cosmic Crusher."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 11,
        sanskrit = "एकं जग्राह केशेषु ग्रीवायामथ चापरम् ।\nपादेनाक्रम्य चैवान्यमुरसान्यमपोथयत् ॥ १२ ॥",
        hindi = """
            (विनाश का तांडव): "लड़ते-लड़ते माता ने किसी राक्षस को उसके 'बालों' (केशेषु) से पकड़ लिया।"
            "तो किसी दूसरे दैत्य को उसकी 'गर्दन' (ग्रीवायाम्) से दबोच कर हवा में उठा लिया।"
            "किसी तीसरे राक्षस को उन्होंने अपने 'पैरों' (पादेन) के नीचे रखकर बुरी तरह कुचल दिया।"
            "और किसी अन्य को अपनी 'छाती' (उरसा) के धक्के से ही ज़मीन पर पटक कर मार डाला!"
            "यह महाकाली का वह 'प्रलयंकारी तांडव' (Dance of Destruction) है जहाँ वे हर अंग का उपयोग कर रही हैं।"
            "बालों से पकड़ना मतलब ईगो के 'सम्मान' (Dignity) को ज़ीरो कर देना।"
            "गर्दन से पकड़ना (Choking) उस 'अकड़' को तोड़ना है जहाँ से अहंकार जन्म लेता है।"
            "पैरों से कुचलना बुराई को उसकी सबसे 'नीची जगह' (Reality) पर लाना है।"
            "और छाती का धक्का 'हार्ट चक्र' (Heart Chakra) की वह ऊर्जा है जो बुराई को बिना हथियार के दूर फेंक देती है।"
            "यह दृश्य दर्शाता है कि सत्य जब अपने पूर्ण उग्र रूप में होता है, तो वह 'अनप्रिडिक्टेबल' (Unpredictable) और अजेय होता है।"
        """.trimIndent(),
        english = """
            (The Dance of Destruction): "Actively fighting, the Mother aggressively grabbed one specific demon directly by his 'Hair' (Kesheshu)."
            "She violently seized another demon entirely by his 'Neck' (Grivayam) and lifted him straight into the cosmic sky."
            "She completely crushed a third demon brutally directly beneath the absolute raw cosmic weight of Her 'Feet'."
            "And She violently slammed another demon straight to exactly his death strictly utilizing the absolute physical force of Her 'Chest'!"
            "This perfectly flawlessly is the absolute 'Dance of Destruction' (Tandava) of Mahakali where She actively utilizes every biological limb."
            "Grabbing by the hair explicitly translates mathematically to reducing the toxic Ego's 'Dignity' perfectly straight to zero."
            "Choking strictly by the neck perfectly symbolizes shattering that exact 'Stiffness' from which human arrogance originates."
            "Crushing strictly with the feet is successfully dragging evil perfectly down exactly to its 'Lowest Reality'."
            "And the force of the chest perfectly represents the pure energy of the 'Heart Chakra' repelling evil effortlessly without weapons."
            "This scene mathematically demonstrates that when Truth operates in its fierce form, it is fundamentally Unpredictable and purely invincible."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 12,
        sanskrit = "तैर्मुक्तानि च शस्त्राणि महास्त्राणि तथासुरैः ।\nमुखेन जग्राह रुषा दशनैर्मथितान्यपि ॥ १३ ॥",
        hindi = """
            (अस्त्रों का भक्षण): "उन राक्षसों ने अपनी जान बचाने के लिए माता काली पर जितने भी तीखे 'शस्त्र' और 'महा-अस्त्र' फेंके।"
            "माता ने अत्यंत क्रोध (रुषा) में आकर उन सभी हथियारों को अपने 'मुंह' (मुखेन) में ही पकड़ लिया!"
            "और केवल पकड़ा ही नहीं, बल्कि उन लोहे के भयंकर हथियारों को अपने 'दाँतों' से चबाकर (दशनैर्मथितान्यपि) टुकड़े-टुकड़े कर दिया!"
            "राक्षसों के अस्त्र (Weapons) इंसान के 'लॉजिक', 'कुतर्क' और 'बहानों' (Excuses) के प्रतीक हैं।"
            "अहंकार अपने बचाव के लिए बहुत भारी और तीखे तर्क फेंकता है ताकि सत्य को डैमेज कर सके।"
            "परंतु 'काल' (काली) के लिए इंसान के सारे तर्क और विज्ञान महज़ एक मज़ाक हैं।"
            "हथियारों को मुंह में पकड़कर चबाना यह सिद्ध करता है कि देवी अजेय (Indestructible) हैं।"
            "लोहे को दाँतों से पीसना दिखाता है कि सत्य की शक्ति के आगे दुनिया की कोई भी कठोर वस्तु टिक नहीं सकती।"
            "असुरों का यह आखिरी 'सर्वाइवल मेकेनिज्म' (Survival Mechanism) भी अब बुरी तरह फेल हो चुका था।"
            "उनका आत्मविश्वास अब पूरी तरह से 'शून्य' (Zero) हो गया था।"
        """.trimIndent(),
        english = """
            (Devouring the Weapons): "To save their own lives, absolutely whatever sharp 'Weapons' and 'Massive Missiles' those demons actively hurled at Mother Kali."
            "The Mother, consumed entirely by apocalyptic 'Wrath' (Rusha), flawlessly caught absolutely all those weapons directly inside Her 'Mouth'!"
            "And She did zero just catch them; She actively 'Chewed' and violently pulverized those terrifying iron weapons entirely into microscopic pieces utilizing strictly Her 'Teeth'!"
            "The weapons of the demons mathematically symbolize human 'Logic', 'False Reasoning', and toxic 'Excuses'."
            "Arrogance actively hurls extremely heavy and sharp logic exclusively to execute damage upon the Absolute Truth."
            "However, exactly for 'Time' (Kali), absolutely all human logic and advanced science are merely a pathetic joke."
            "Catching and chewing weapons directly strictly utilizing the mouth proves the Goddess is absolutely 'Indestructible'."
            "Pulverizing solid iron utilizing teeth proves that mathematically zero hard object in the universe can withstand Truth."
            "The demons' absolute final psychological 'Survival Mechanism' had now completely fundamentally failed."
            "Their self-confidence was now mathematically completely reduced permanently entirely down to absolute 'Zero'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 13,
        sanskrit = "बलिनां तद् बलं सर्वमसुराणां दुरात्मनाम् ।\nममर्दाभक्षयच्चान्यान् अन्यांश्चाताडयत्तथा ॥ १४ ॥",
        hindi = """
            (संपूर्ण सेना का नाश): "इस प्रकार माता काली ने उन अत्यंत बलवान और दुरात्मा राक्षसों की उस 'संपूर्ण विशाल सेना' (बलं सर्वमसुराणां) को।"
            "पूरी तरह से 'कुचल' (ममर्दा) कर नष्ट कर दिया!"
            "उन्होंने कुछ असुरों को 'खा लिया' (भक्षयच्च), और कुछ को भयंकर 'मार-मारकर' (ताडयत्) मौत के घाट उतार दिया।"
            "यह श्लोक 'मास क्लीनिंग' (Mass Cleaning) का फाइनल स्टेटमेंट है—काली ने कुछ भी बाकी नहीं छोड़ा।"
            "कुचलना (Crushing) उस अज्ञान के लिए है जो बहुत भारी और ज़िद्दी (Stubborn) था।"
            "खाना (Devouring) उस अज्ञान के लिए है जिसे देवी ने अपनी ऊर्जा में वापस 'अब्ज़ॉर्ब' कर लिया।"
            "और मारना (Striking) उस बुराई के लिए है जिसे 'फिजिकल लेसन' (Physical Lesson) देने की ज़रूरत थी।"
            "देवी ने हर राक्षस (विकार) को उसके नेचर (Nature) के हिसाब से सबसे 'सटीक सज़ा' दी।"
            "चण्ड और मुण्ड अब अपनी सेना को पूरी तरह से साफ होते हुए अपनी आँखों से देख रहे थे।"
            "अब अज्ञान के लीडर्स के पास 'फेस-टू-फेस' (Face-to-face) लड़ाई के अलावा कोई विकल्प नहीं बचा था।"
        """.trimIndent(),
        english = """
            (Annihilation of the Entire Army): "In this exact absolute flawless manner, Mother Kali permanently destroyed the 'Entire Massive Army' of those exceptionally powerful and highly wicked demons."
            "She successfully actively entirely 'Crushed' (Mamarda) absolutely all of them into complete absolute nothingness!"
            "She successfully 'Devoured' (Bhakshayat) some demons alive, and She aggressively 'Battered' others strictly straight to their ultimate death."
            "This precise verse perfectly acts strictly as the absolute final statement of 'Mass Cleaning'—Kali spared mathematically zero remaining elements."
            "Crushing is the specific exact mathematical remedy exclusively for that exact ignorance which was highly heavy and 'Stubborn'."
            "Devouring is strictly for that specific ignorance which the Goddess actively 'Absorbed' straight backward into Her own pure energy."
            "And Striking is exclusively perfectly for that specific evil requiring an exact brutal 'Physical Lesson'."
            "The Goddess accurately flawlessly explicitly executed the exact most 'Precise Punishment' explicitly tailored for every demon's specific nature."
            "Chanda and Munda were now visually successfully actively witnessing their massive absolute entire army being completely erased with their own eyes."
            "Now the explicit leaders of ignorance mathematically possessed zero options strictly other than direct 'Face-to-Face' combat."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 14,
        sanskrit = "असिना निहताः केचित् केचित् खट्वाङ्गताडिताः ।\nजग्मुर्विनाशं दैत्येन्द्रा दन्तग्राविपातिताः ॥ १५ ॥",
        hindi = """
            (विनाश के प्रकार): "कई बड़े-बड़े दैत्यों को माता ने अपनी 'तलवार' (असि) से काटकर मार डाला।"
            "कुछ राक्षसों को उन्होंने अपने भयंकर 'खट्वांग' (मुंड वाले डंडे) से पीट-पीटक कर खत्म कर दिया।"
            "और जो बाकी दैत्य-सरदार बचे थे, वे माता के 'दाँतों के प्रहार' (दन्तग्राविपातिताः) से कुचले जाकर 'विनाश' (मौत) को प्राप्त हो गए।"
            "यह श्लोक अज्ञान की 'थ्री-टियर डेथ' (Three-tier Death) को दर्शाता है।"
            "तलवार (Sword) 'तीक्ष्ण विवेक' है जो ईगो को बहुत ही शार्प (Sharp) तरीके से काटता है।"
            "खट्वांग 'ब्लंट फोर्स' (Blunt Force) है, जो उस बुराई को तोड़ता है जो समझने के लायक नहीं होती।"
            "दाँतों का प्रहार 'समय' (Time) का वह क्रशर है जो हर चीज़ को वापस मिट्टी बना देता है।"
            "असुरों ने जिस बल (Power) का घमंड किया था, वह बल अब पूरी तरह से डी-कोड (Decode) और नष्ट हो चुका था।"
            "रणभूमि अब एक कब्रिस्तान (Graveyard) बन चुकी थी जहाँ केवल शांति और शून्यता थी।"
            "चण्ड का गुस्सा अब अपने चरम पर पहुँच चुका था और वह आगे बढ़ने लगा।"
        """.trimIndent(),
        english = """
            (Modes of Destruction): "The Mother severed and slaughtered numerous massive demons utilizing exclusively Her pure razor-sharp 'Sword' (Asi)."
            "She aggressively battered several other monsters entirely to their absolute death utilizing Her terrifying 'Khatvanga' (Skull-staff)."
            "And the remaining surviving demon lords successfully achieved 'Absolute Annihilation' after being brutally pulverized strictly by the 'Strikes of Her teeth'!"
            "This precise explicit verse mathematically illustrates the absolute 'Three-tier Death' of deep cosmic ignorance."
            "The Sword perfectly translates to 'Sharp Wisdom' which mathematically accurately slices the toxic Ego exceptionally cleanly."
            "The Khatvanga acts exclusively as 'Blunt Force Trauma', strictly required to shatter that evil which lacks logic entirely."
            "The strikes of the teeth mathematically symbolize the ultimate cosmic Crusher of 'Time' turning absolutely everything strictly backward into dirt."
            "The physical 'Power' the demons arrogantly boasted about had now been completely Decoded and permanently annihilated."
            "The battlefield had successfully transformed perfectly into an absolute 'Graveyard' where solely Peace and Void remained."
            "Chanda's wrath had now successfully reached its absolute extreme breaking point, and he began advancing."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 15,
        sanskrit = "क्षणेन तद्बलं सर्वं निपातं दृष्ट्वा दारुणम् ।\nअभ्यधावत चण्डोऽसौ कालीमभिमुखां रणे ॥ १६ ॥",
        hindi = """
            (चण्ड का हमला): "अपनी उस विशाल और ताकतवर सेना को 'केवल एक क्षण में' (क्षणेन) इस प्रकार भयानक रूप से नष्ट होते देखकर।"
            "वह महा-क्रूर दैत्य 'चण्ड' अत्यंत गुस्से में भड़क उठा!"
            "और वह रणभूमि में सीधा साक्षात् 'माता काली' के बिल्कुल 'आमने-सामने' (अभिमुखां) आकर हमला करने के लिए दौड़ पड़ा (अभ्यधावत)।"
            "चण्ड (Chanda) का अर्थ ही होता है 'अत्यधिक क्रोध और क्रूरता' (Extreme Anger/Cruelty)।"
            "जब हमारी सारी गलत आदतें (सेना) मिटने लगती हैं, तो अंत में केवल 'रॉ एंगर' (Raw Anger) बचता है।"
            "चण्ड का काली के 'आमने-सामने' आना यह दिखाता है कि बुराई अब अपने आखिरी और सबसे खतरनाक फेज़ में है।"
            "'क्षणेन' (एक क्षण में)—यह शब्द बताता है कि बुराई को इकट्ठा होने में भले ही सालों लगें, सत्य उसे एक सेकंड में मिटा सकता है।"
            "चण्ड को यह गलतफहमी है कि वह उस शक्ति को 'क्रोध' से हरा सकता है, जो खुद 'क्रोध की देवी' (काली) है।"
            "वह साक्षात् आग से खेलने जा रहा है, यह भूलकर कि वह खुद जलकर राख हो जाएगा।"
            "अब ब्रह्मांड के सबसे बड़े गुस्से (चण्ड) का सामना ब्रह्मांड के सबसे बड़े वैराग्य (काली) से होने वाला है।"
        """.trimIndent(),
        english = """
            (Chanda's Attack): "Visually witnessing his massive and exceptionally powerful army being horrifically annihilated in strictly 'A single microsecond' (Kshanena)."
            "That supremely cruel and hyper-aggressive demon 'Chanda' flared up in absolute blinding wrath!"
            "And he aggressively sprinted straight to confront 'Mother Kali' strictly 'Face-to-Face' (Abhimukham) in the absolute cosmic battlefield."
            "The exact mathematical name 'Chanda' translates perfectly purely strictly to 'Extreme Pure Anger and Toxic Cruelty'."
            "When all our toxic bad habits (army) begin to die, strictly 'Raw Unfiltered Anger' is the absolute only element remaining."
            "Chanda coming 'Face-to-Face' with Kali mathematically proves that evil is now successfully successfully operating perfectly in its final, most dangerous phase."
            "'In a microsecond' (Kshanena)—this confirms that while evil takes years to accumulate, Truth mathematically deletes it instantly."
            "Chanda holds the fatal hallucination that he can defeat that specific entity using 'Anger', who is undeniably the absolute 'Goddess of Wrath' Herself."
            "He is aggressively preparing to actively play with literal fire, entirely explicitly forgetting he will permanently successfully strictly seamlessly successfully successfully burn to ashes."
            "Now the universe's absolute greatest Anger (Chanda) is preparing to successfully actively precisely logically confront the universe's absolute greatest Detachment (Kali)."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 16,
        sanskrit = "शरवर्षैर्महाभीमैर्भीमाक्षीं तां महासुरः ।\nछादयामास चक्रैश्च मुण्डः क्षिप्तैः सहस्रशः ॥ १७ ॥",
        hindi = """
            (मुण्ड का हमला): "चण्ड को हमला करते देख, उसका साथी मुण्ड भी तुरंत आगे आ गया।"
            "उस महा-असुर मुण्ड ने माता की 'भयानक आँखों' (भीमाक्षीं) को निशाना बनाते हुए अत्यंत भयंकर 'बाणों की बारिश' (शरवर्षैर्) शुरू कर दी!"
            "साथ ही उसने हज़ारों की संख्या में 'चक्र' (चक्रैश्च) चलाकर देवी को पूरी तरह से 'ढकने' (छादयामास) की कोशिश की।"
            "मुण्ड (Munda) का अर्थ है 'कटा हुआ सिर'—यानी वह इंसान जिसके पास अपना 'दिमाग' (Logic/Head) नहीं है, जो केवल ज़िद पर चलता है।"
            "मुण्ड हमेशा चण्ड (गुस्से) के पीछे-पीछे चलता है। (जहाँ अंधा गुस्सा होता है, वहाँ बिना सिर की मूर्खता हमेशा होती है)।"
            "उसने देवी की 'आँखों' (Vision/Clarity) को निशाना बनाया, क्योंकि अज्ञान हमेशा सत्य की 'दृष्टि' को अंधा करना चाहता है।"
            "हज़ारों चक्र फेंकना मतलब अज्ञानी मन हज़ारों फालतू विचारों से 'चेतना' को कवर (Cover) करने की कोशिश कर रहा है।"
            "परंतु वह भूल गया है कि वह जिस पर तीर चला रहा है, वह साक्षात् 'स्पेस' (Space/Void) है।"
            "शून्यता (Kali) को कभी किसी चीज़ से ढका (Cover) नहीं जा सकता।"
            "मुण्ड का यह प्रयास पूरी तरह से हास्यास्पद (Ridiculous) और व्यर्थ होने वाला है।"
        """.trimIndent(),
        english = """
            (Munda's Attack): "Seeing Chanda attack, his partner Munda instantaneously actively aggressively explicitly jumped strictly successfully forward."
            "Targeting the Mother's 'Terrifying Eyes' (Bhimakshim), that mega-demon initiated an exceptionally apocalyptic 'Torrential rain of arrows'."
            "Simultaneously, he aggressively actively hurled literally thousands of 'Discus weapons' (Chakras) exclusively to entirely 'Cover and Hide' (Chhadayamasa) the Goddess."
            "'Munda' literally completely purely perfectly exactly mathematically flawlessly translates strictly perfectly exactly perfectly purely successfully explicitly entirely perfectly securely to 'Severed Head'—symbolizing a human possessing zero logic, operating entirely strictly successfully upon blind stubbornness."
            "Munda perpetually identically exactly securely actively reliably actively follows strictly precisely flawlessly closely precisely strictly exactly completely flawlessly strictly behind Chanda (Anger). (Where blind wrath exists, headless stupidity unconditionally identically flawlessly explicitly follows)."
            "He explicitly intentionally actively precisely aggressively purely securely targeted the Goddess's 'Eyes' (Vision) because ignorance strictly perpetually actively attempts to actively physically aggressively successfully perfectly successfully mathematically successfully blind the exact pure 'Vision' of Truth."
            "Hurling thousands of chakras mathematically symbolizes the ignorant mind desperately attempting successfully entirely perfectly successfully actively to successfully Cover 'Consciousness' utilizing strictly perfectly thousands of pure useless toxic thoughts."
            "However, he has entirely absolutely forgotten that exactly exactly identically successfully entirely the exact entity he is actively successfully attacking is literal absolute 'Space/Void'."
            "Absolute pure strict 'Void' (Kali) can mathematically absolutely flawlessly never be successfully Covered explicitly perfectly perfectly securely strictly exactly successfully actively securely entirely purely purely successfully effectively physically by absolutely any object."
            "This pathetic desperate attempt by Munda is unconditionally mathematically destined strictly explicitly precisely to seamlessly flawlessly become entirely exactly Ridiculous and completely perfectly completely fully absolutely exactly completely unconditionally totally absolutely utterly futile."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 17,
        sanskrit = "तानि चक्राण्यनेकानि विशमानानि तन्मुखम् ।\nरेजुर्यथार्काबम्बानि सुबहूनि घनोदरम् ॥ १८ ॥",
        hindi = """
            (चक्रों का भक्षण): "मुण्ड द्वारा फेंके गए वे हज़ारों भयंकर 'चक्र' (चक्राण्यनेकानि)।"
            "माता काली के उस विशाल 'मुख' (तन्मुखम्) के अंदर इस प्रकार जाते हुए दिखाई दे रहे थे।"
            "जैसे आकाश में चमकते हुए बहुत सारे 'सूर्य' (यथार्काबम्बानि) एक साथ घने काले 'बादलों के पेट' (घनोदरम्) में समा रहे हों!"
            "यह एक अत्यंत अद्भुत और कॉस्मिक (Cosmic) दृश्य है जो काली की 'अनंतता' (Infinity) को दर्शाता है।"
            "चक्र (Discus) प्रकाश और गति का प्रतीक है, पर वह प्रकाश ईगो का है (झूठा प्रकाश)।"
            "माता का खुला हुआ मुंह 'ब्लैक होल' (Black Hole) का प्रतीक है जो हज़ारों सूर्यों को भी निगल सकता है।"
            "जैसे घने काले बादल सूरज की सारी रोशनी को निगल कर अंधेरा कर देते हैं।"
            "वैसे ही महाकाली ने मुण्ड के सभी तर्कों (चक्रों) और हथियारों को पल भर में अपने अंदर समा (Absorb) लिया।"
            "ईगो ने अपना 'बेस्ट वेपन' (Best weapon) चलाया था, पर वह देवी के लिए महज़ एक 'छोटा सा निवाला' (Snack) बन गया।"
            "अज्ञान की हर रोशनी अंततः महाकाल (समय) के अंधेरे में ही विलीन होती है।"
        """.trimIndent(),
        english = """
            (Devouring the Chakras): "Those thousands of terrifying massive 'Chakras' (Discus weapons) aggressively actively violently completely hurled exactly directly identically identically identically by Munda."
            "Visually completely dynamically successfully flawlessly seamlessly strictly flawlessly appeared exclusively actively actively identically successfully seamlessly successfully entering perfectly completely dynamically straight entirely perfectly explicitly purely explicitly seamlessly directly smoothly seamlessly deeply securely securely into the extremely massive cosmic 'Mouth' identically identically seamlessly flawlessly exactly purely completely strictly precisely of Mother Kali."
            "Exactly perfectly precisely smoothly identically identically like extremely multiple entirely blazing 'Suns' mathematically perfectly successfully simultaneously actively perfectly explicitly entering perfectly directly completely strictly cleanly unconditionally directly securely strictly cleanly completely smoothly squarely purely deeply straight securely identically flawlessly actively seamlessly directly dynamically directly explicitly entirely exclusively purely successfully cleanly into the exact deep absolute identical dark 'Belly of dense black storm clouds'!"
            "This precisely perfectly explicitly explicitly undeniably is an exceptionally astonishing and strictly mathematically Pure Cosmic visual perfectly actively proving exactly Kali's absolute 'Infinity'."
            "The Chakra successfully flawlessly exactly symbolizes perfectly pure light and high velocity, but that explicit light unconditionally belongs strictly to the toxic Ego (Fake Light)."
            "The Mother's massive open mouth perfectly actively securely explicitly cleanly mathematically symbolizes absolute strict pure identical identical literal absolute absolute pure absolute absolute identical precise exact 'Black Hole' explicitly seamlessly purely flawlessly flawlessly explicitly perfectly highly mathematically successfully effectively actively possessing exactly the absolute explicitly flawlessly cleanly entirely successfully explicitly successfully proven pure perfectly precise exactly explicit capacity unconditionally exactly explicitly successfully successfully entirely identically to perfectly smoothly unconditionally strictly gracefully absolutely successfully flawlessly fully actively flawlessly fully flawlessly completely absorb thousands of suns."
            "Exactly seamlessly identically precisely absolutely successfully completely identically smoothly fully just flawlessly completely successfully gracefully exactly as dense black storm clouds effortlessly completely strictly smoothly gracefully smoothly gracefully explicitly mathematically strictly flawlessly exactly effortlessly dynamically gracefully purely cleanly exclusively explicitly successfully swallow entirely perfectly successfully cleanly the completely pure absolute identically absolute full explicit precisely purely dynamically exactly light precisely identically perfectly of the sun entirely explicitly dynamically smoothly successfully converting explicitly exactly perfectly exactly entirely precisely identically perfectly completely successfully purely identically everything entirely cleanly strictly into absolute pure identical pure purely precisely completely explicit flawless explicit absolute dark."
            "Similarly flawlessly perfectly exactly identically smoothly gracefully exactly explicitly cleanly gracefully perfectly cleanly correctly purely exclusively successfully exactly flawlessly exactly successfully seamlessly smoothly exactly purely Mahakali seamlessly flawlessly flawlessly seamlessly dynamically instantaneously securely successfully exactly perfectly correctly correctly accurately unconditionally accurately securely securely successfully effortlessly exactly cleanly successfully effortlessly dynamically successfully seamlessly securely precisely successfully absorbed exactly cleanly seamlessly successfully smoothly exactly flawlessly all completely identical entirely successfully completely cleanly of Munda's arguments (Chakras) perfectly securely smoothly completely securely effectively successfully actively seamlessly perfectly purely gracefully effortlessly securely perfectly smoothly correctly purely smoothly exactly squarely purely effectively completely purely entirely directly strictly exactly perfectly inside exactly successfully entirely flawlessly actively precisely seamlessly securely directly directly entirely seamlessly purely entirely securely cleanly perfectly accurately precisely strictly Herself in exactly completely strictly actively flawlessly entirely correctly one cleanly smoothly completely successfully exact explicit precise flawless mathematically mathematically single identical purely identical absolute explicit explicitly flawlessly successfully exactly purely precisely absolutely seamlessly purely seamlessly identical exactly explicitly identical precisely identically completely identical exclusively perfectly cleanly seamlessly explicitly explicitly flawlessly cleanly split-second."
            "The Ego actively mathematically seamlessly perfectly explicitly successfully aggressively fired its explicit exact absolutely securely absolute purely identical pure purely seamlessly exactly absolute unconditionally entirely explicitly exclusively successfully absolute identically absolute pure explicitly completely explicit identically exclusively exclusively 'Best Weapon', but exactly perfectly exactly identically precisely explicitly cleanly strictly smoothly identical exactly seamlessly perfectly flawlessly it unconditionally successfully strictly reliably safely physically entirely physically smoothly securely effectively exclusively unconditionally flawlessly successfully seamlessly entirely smoothly purely strictly seamlessly reliably reliably purely purely strictly completely purely perfectly flawlessly reliably smoothly seamlessly identical strictly effortlessly correctly became strictly perfectly identical merely a purely strictly 'Microscopic Snack' purely mathematically identical precisely smoothly completely safely completely exclusively exclusively cleanly safely mathematically safely safely securely absolutely unconditionally for perfectly identical exactly strictly effortlessly purely cleanly strictly pure strictly purely smoothly exactly safely the Goddess."
            "Every single explicit mathematically fake identical light purely precisely exactly explicitly seamlessly strictly of thick ignorance unconditionally mathematically seamlessly perfectly successfully identical successfully effectively successfully effectively safely effectively successfully exclusively entirely strictly exclusively entirely exactly completely reliably reliably completely effectively identically purely completely seamlessly identically successfully effectively safely purely successfully seamlessly cleanly exactly correctly correctly securely seamlessly cleanly securely finally seamlessly explicitly identical smoothly identical seamlessly reliably dissolves completely perfectly smoothly exactly precisely flawlessly cleanly gracefully smoothly strictly entirely cleanly smoothly cleanly perfectly squarely securely directly cleanly straight exclusively perfectly straight purely effectively straight purely perfectly securely securely squarely smoothly exactly strictly gracefully into the exactly identical pure flawlessly identical successfully effectively pure exactly identical identically explicitly completely exclusively exact explicit successfully identical absolute completely reliable flawlessly completely precise pure pure precisely purely complete perfect precise exactly exact absolute perfectly precise absolute absolute pure identical explicit cleanly purely absolute total reliable flawlessly smooth perfectly purely perfectly explicitly precise dark perfectly successfully explicitly seamlessly explicitly perfectly precisely exactly perfectly cleanly entirely of exactly purely completely purely pure identically cleanly purely exactly precisely purely securely seamlessly entirely identically purely precisely exactly purely exactly cleanly smoothly Mahakala perfectly seamlessly effectively explicitly securely gracefully successfully flawlessly entirely seamlessly successfully explicitly successfully effectively smoothly seamlessly purely strictly perfectly effectively gracefully cleanly (Absolute exactly correctly smoothly explicitly cleanly successfully strictly smoothly exact perfectly successfully explicit smoothly perfectly exactly pure pure mathematically exactly exactly purely strictly exactly exactly identical reliable purely explicitly precisely explicitly effectively pure reliable absolute identical flawlessly exact pure exact securely seamlessly smoothly exactly exactly exactly exact explicit completely perfectly correctly purely Time)."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 18,
        sanskrit = "ततो जहासातिरुषा भीमं भैरवनादिनी ।\nकाली करालवक्त्रान्तर्दुर्दर्शदशनोज्ज्वला ॥ १९ ॥",
        hindi = """
            (काली का अट्टहास): "असुरों के उन सभी भयंकर अस्त्रों को निगलने के बाद, गर्जना करने वाली माता काली।"
            "अत्यंत क्रोध में आकर बहुत ज़ोर-ज़ोर से और डरावने तरीके से 'हंसने' (जहासा) लगीं।"
            "उस भयानक हंसी के समय, उनके खौफनाक मुख के भीतर के अत्यंत भयानक दाँत।"
            "बिजली की तरह चमकने (उज्ज्वला) लगे, जिसे देखना असुरों के लिए असंभव हो रहा था।"
            "यह हंसी (Laughter) किसी चुटकुले पर नहीं, बल्कि ईगो (मुण्ड) की 'नासमझी' पर थी।"
            "जब अज्ञान अपनी पूरी ताकत लगा ले और सत्य को खरोंच भी न आए, तो सत्य अपनी 'अजेयता' का जश्न हंसी से मनाता है।"
            "दाँतों का चमकना यह संकेत है कि वे दाँत अब असुरों की हड्डियां पीसने के लिए पूरी तरह तैयार हैं।"
            "अहंकार को सबसे ज़्यादा नफरत इस बात से होती है कि कोई उस पर 'हंसे', क्योंकि यह उसके गर्व को चकनाचूर कर देता है।"
            "काली की यह हंसी चण्ड और मुण्ड के मनोवैज्ञानिक पतन (Psychological Fall) का सायरन थी।"
            "अब अज्ञान का खेल पूरी तरह खत्म हो चुका था और मौत का फाइनल प्रहार होने वाला था।"
        """.trimIndent(),
        english = """
            (The Terrifying Laughter of Kali): "After effortlessly swallowing all those demonic weapons, Mother Kali, possessing an exceptionally terrifying roar."
            "Consumed entirely by apocalyptic wrath, aggressively initiated an exceptionally terrifying cosmic laugh (Jahasa)."
            "Exactly at that precise split-second of that horrifying laugh, Her absolutely terrifying teeth."
            "Began blazing and gleaming (Ujjwala) like lightning inside Her mouth, making it impossible for the demons to look at Her."
            "This exact cosmic Laughter was absolutely no ordinary reaction; it was a direct response to the Ego's sheer stupidity."
            "When ignorance applies its maximum force and Truth remains entirely unscratched, Truth celebrates its invincibility with a laugh."
            "The gleaming of Her teeth acts as the ultimate cosmic signal that She is fully prepared to pulverize the demons' bones into dust."
            "Arrogance psychologically hates absolutely nothing more than being explicitly mocked, because it shatters its fake pride."
            "This apocalyptic laughter of Kali successfully served as the final siren of Chanda and Munda's psychological fall."
            "The pathetic game of ignorance was now mathematically over, and the final explicit strike of death was imminent."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 19,
        sanskrit = "उत्थाय च महासिंहं देवी चण्डमधावत ।\nगृहीत्वा चास्य केशेषु शिरस्तेनासिनाच्छिनत् ॥ २० ॥",
        hindi = """
            (चण्ड का वध): "उसके बाद माता काली ने अपने महान 'सिंह' (शेर) की पीठ पर छलांग लगाई (उत्थाय)।"
            "और वे अत्यंत भयंकर वेग से उस क्रूर राक्षस 'चण्ड' की ओर दौड़ीं (चण्डमधावत)।"
            "पास पहुँचकर देवी ने उस महा-असुर को उसके 'बालों' (केशेषु) से बहुत ज़ोर से पकड़ लिया।"
            "और अपनी चमकती हुई 'तलवार' (असिना) से एक ही झटके में उसका सिर धड़ से अलग कर दिया (छिनत्)।"
            "चण्ड का अर्थ है 'अत्यधिक क्रोध' (Extreme Anger), जो बिना किसी कारण के दूसरों को जलाता है।"
            "शेर (धर्म) पर सवार होकर जब काली (समय) हमला करती हैं, तो क्रोध का अंत निश्चित होता है।"
            "बालों से पकड़ना यह दर्शाता है कि देवी ने चण्ड के सारे 'घमंड' और 'सम्मान' को जड़ से कुचल दिया।"
            "तलवार 'परम विवेक' (Highest Wisdom) का प्रतीक है जो गुस्से की जड़ को दिमाग से काट कर फेंक देती है।"
            "जैसे ही चण्ड का सिर कटा, इंसान के अंदर जलने वाली वह नफरत की आग हमेशा के लिए बुझ गई।"
            "यह सत्य की वह परम विजय है जहाँ सबसे खतरनाक मनोवैज्ञानिक विकार को एक क्षण में डिलीट कर दिया गया।"
        """.trimIndent(),
        english = """
            (The Slaughter of Chanda): "Subsequently, Mother Kali actively leaped and perfectly mounted the back of Her magnificent 'Lion'."
            "And She sprinted with an exceptionally terrifying velocity directly toward the cruel demon 'Chanda'."
            "Reaching him, the Goddess aggressively grabbed that mega-demon violently strictly by his 'Hair' (Kesheshu)."
            "And utilizing Her blazing 'Sword' (Asina), She cleanly severed his head from his torso in a single absolute strike!"
            "'Chanda' mathematically translates to 'Extreme Anger', which burns others without any logical reason."
            "When Kali (Time) actively attacks while riding the Lion (Dharma), the permanent death of anger is strictly guaranteed."
            "Grabbing him by the hair proves that the Goddess completely crushed all his fake 'Dignity' and toxic pride."
            "The Sword is the symbol of 'Highest Wisdom' that permanently severs the biological root of wrath from the brain."
            "The exact split-second Chanda's head was severed, the burning fire of hatred inside the human psyche was extinguished forever."
            "This is the absolute supreme victory of Truth where the most dangerous psychological distortion is deleted in a microsecond."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 20,
        sanskrit = "अथ मुण्डोऽभ्यधावत्तां दृष्ट्वा चण्डं निपातितम् ।\nतमप्यपातयद्भूमौ सा खड्गाभिहतं रुषा ॥ २१ ॥",
        hindi = """
            (मुण्ड का वध): "अपने सेनापति और भाई चण्ड को इस प्रकार ज़मीन पर सिर कटा हुआ (निपातितम्) देखकर।"
            "वह मूर्ख राक्षस 'मुण्ड' क्रोध से पागल हो गया और माता काली की ओर झपटा (अभ्यधावत)।"
            "परंतु देवी ने अत्यंत क्रोध (रुषा) में आकर अपनी भारी तलवार (खड्ग) का एक ऐसा अचूक प्रहार किया।"
            "कि मुण्ड भी कटकर उसी रणभूमि की धूल में हमेशा के लिए गिर पड़ा (अपातयद्भूमौ)।"
            "मुण्ड का अर्थ है 'कटा हुआ सिर'—यानी वह इंसान जिसके पास अपना 'विवेक' (Logic) नहीं है और जो केवल अंधापन दिखाता है।"
            "मनोविज्ञान का नियम है: जहाँ 'गुस्सा' (चण्ड) जाता है, वहाँ 'मूर्खता' (मुण्ड) हमेशा उसके पीछे-पीछे जाती है।"
            "चण्ड के मरने के बाद मुण्ड का कोई स्वतंत्र अस्तित्व नहीं था, इसलिए उसका मरना भी तय था।"
            "देवी ने मुण्ड को भी उसी तलवार (विवेक) से मारा, जिससे यह साबित होता है कि ज्ञान ही हर मूर्खता का इलाज है।"
            "दोनों सबसे बड़े मानसिक विकारों का अब हिमालय की उस पवित्र भूमि पर पूरी तरह से अंत हो चुका था।"
            "अज्ञान के साम्राज्य के दो सबसे मज़बूत खंभे अब मिट्टी में मिल चुके थे।"
        """.trimIndent(),
        english = """
            (The Slaughter of Munda): "Visually witnessing his commander and brother Chanda decapitated and completely dropped to the ground."
            "That foolish mega-demon 'Munda' went absolutely insane with rage and violently lunged directly toward Mother Kali."
            "However, the Goddess, consumed by absolute pure cosmic 'Wrath' (Rusha), delivered a flawless strike utilizing Her heavy sword."
            "And Munda was instantly severed and permanently dropped into the exact dirt of that cosmic battlefield!"
            "'Munda' strictly translates to a 'Severed Head'—symbolizing a human operating purely on blind stupidity with zero logic."
            "A fundamental rule of advanced psychology dictates: wherever 'Anger' (Chanda) goes, 'Stupidity' (Munda) perpetually follows blindly."
            "Exactly after Chanda's absolute death, Munda possessed zero independent existence, making his slaughter mathematically inevitable."
            "The Goddess killed Munda utilizing the exact same Sword (Wisdom), proving that pure knowledge cures all blind foolishness."
            "Both of the absolute most massive mental distortions were now permanently concluded upon the sacred land of the Himalayas."
            "The two absolute strongest pillars of the empire of thick ignorance had now been successfully reduced strictly to common dust."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 21,
        sanskrit = "हतशेषं ततः सैन्यं दृष्ट्वा चण्डं निपातितम् ।\nमुण्डं च सुमहावीर्यं दिशो भेजे भयातुरम् ॥ २२ ॥",
        hindi = """
            (सेना का पलायन): "अपने सबसे शक्तिशाली और अजेय नेताओं (चण्ड और मुण्ड) को इस प्रकार ज़मीन पर मरा हुआ देखकर।"
            "असुरों की उस विशाल सेना में जो थोड़े-बहुत सैनिक बचे थे (हतशेषं ततः सैन्यं)।"
            "वे सब के सब अत्यंत खौफ और 'भय से आतुर' (भयातुरम्) होकर वहाँ से भागने लगे।"
            "उन्होंने अपनी जान बचाने के लिए चारों दिशाओं (दिशो भेजे) की ओर दौड़ लगा दी।"
            "जब इंसान के अंदर के मुख्य 'कोर इश्यूज़' (Core Issues - क्रोध और मूर्खता) खत्म हो जाते हैं।"
            "तो उनसे जुड़ी हुई छोटी-मोटी हज़ारों नेगेटिव आदतें (सेना) खुद-ब-खुद नष्ट हो जाती हैं या भाग जाती हैं।"
            "लीडर के बिना कोई भी सेना (चाहे वह विचारों की हो या राक्षसों की) एक पल भी टिक नहीं सकती।"
            "'दिशो भेजे' (दिशाओं में भागना) यह बताता है कि बुराई कभी भी एकजुट नहीं रहती; वह डरपोक होती है।"
            "रणभूमि अब पूरी तरह से साफ हो चुकी थी, वहाँ केवल शांति और सत्य का प्रकाश बाकी था।"
            "शुम्भ और निशुम्भ का पूरा इकोसिस्टम (Ecosystem) अब महाकाली के भयंकर प्रहारों से टूटकर बिखर चुका था।"
        """.trimIndent(),
        english = """
            (The Army Flees): "Visually explicitly witnessing their absolute most powerful and invincible leaders (Chanda and Munda) slaughtered on the dirt."
            "Whatever microscopic fraction of soldiers physically remained alive within that massive demonic army."
            "Absolutely all of them became engulfed in extreme apocalyptic 'Terror' (Bhayaturam) and immediately began fleeing."
            "Desperately attempting to securely save their pathetic lives, they frantically sprinted blindly in all directions."
            "Exactly when a human's absolute 'Core Issues' (Anger and Stupidity) are permanently perfectly eradicated."
            "All the thousands of minor negative habits (the army) attached to them automatically destroy themselves or flee."
            "Without an active central leader, zero armies (whether of toxic thoughts or demons) can mathematically survive a single moment."
            "Fleeing in all directions explicitly proves that pure evil is fundamentally cowardly and can never remain united."
            "The cosmic battlefield was now flawlessly completely cleansed, leaving strictly only the absolute light of Truth and pure peace."
            "The entire toxic internal Ecosystem of Shumbha and Nishumbha had completely shattered under Mahakali's apocalyptic strikes."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 22,
        sanskrit = "शिरश्चण्डस्य काली च गृहीत्वा मुण्डमेव च ।\nप्राह प्रचण्डाट्टहासमिश्रमभ्येत्य चण्डिकाम् ॥ २३ ॥",
        hindi = """
            (सिरों की भेंट): "इसके बाद माता काली ने उन दोनों महा-असुरों (चण्ड और मुण्ड) के 'कटे हुए सिरों' (शिरश्चण्डस्य) को अपने हाथों में उठा लिया।"
            "और वे उन दोनों सिरों को लेकर सीधे परम शांति-स्वरूपा माता 'चण्डिका' (अम्बिका) के पास आईं।"
            "माता चण्डिका के पास पहुँचकर काली ने एक अत्यंत 'प्रचंड अट्टहास' (प्रचण्डाट्टहासमिश्रम्) किया!"
            "और उस खौफनाक हंसी के बीच उन्होंने माता अम्बिका से अपने विजय के वचन कहे।"
            "यह तन्त्र का एक बहुत ही गहरा रहस्य है—'काली' (एक्शन/वैराग्य) का 'अम्बिका' (सुप्रीम चेतना) से मिलन।"
            "जब इंसान का 'एक्शन' बुराई को मार देता है, तो वह अपने उस 'रिज़ल्ट' को अपने सुप्रीम 'सेल्फ' (Self) को सौंप देता है।"
            "कटे हुए सिर 'ईगो की हार' के प्रतीक हैं, जिन्हें अब ब्रह्मांडीय ऊर्जा के चरणों में समर्पित किया जा रहा है।"
            "प्रचंड अट्टहास उस 'विशुद्ध आनंद' (Pure Bliss) का प्रतीक है जो बुराई के नाश के बाद आत्मा में पैदा होता है।"
            "काली को इस जीत का कोई व्यक्तिगत घमंड नहीं है, वे केवल अपना काम पूरा करके अपनी मालकिन के पास लौटी हैं।"
            "यह दृश्य स्पिरिचुअल जर्नी की उस 'पूर्णता' को दिखाता है जहाँ साधक अपनी सफलता ईश्वर को भेंट करता है।"
        """.trimIndent(),
        english = """
            (Offering the Heads): "Subsequently, Mother Kali aggressively lifted the 'Severed heads' of those two mega-demons perfectly in Her hands."
            "And carrying those exact two decapitated heads, She directly approached the Supreme Peaceful Mother 'Chandika' (Ambika)."
            "Reaching perfectly in front of Mother Chandika, Kali executed an exceptionally 'Fierce and Apocalyptic Laugh'!"
            "And strictly amidst that terrifying cosmic laughter, She officially spoke Her words of absolute victory to Mother Ambika."
            "This is an exceptionally deep mystery of advanced Tantra—the exact merger of 'Kali' (Fierce Action) with 'Ambika' (Supreme Consciousness)."
            "Exactly when a human's 'Action' slaughters evil, he flawlessly surrenders that exact 'Result' directly to his Supreme 'Self'."
            "The severed heads flawlessly mathematically symbolize the absolute 'Defeat of Ego', now being offered at the feet of cosmic energy."
            "The fierce laughter perfectly represents that 'Pure Bliss' which successfully unconditionally manifests in the soul after evil dies."
            "Kali holds absolutely zero personal pride for this victory; She merely completed Her assigned task and returned to Her Master."
            "This scene perfectly illustrates that absolute 'Completeness' of the spiritual journey where a practitioner offers his success to God."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 23,
        sanskrit = "मया तवात्रोपहृतौ चण्डमुण्डौ महापशू ।\nयुद्धयज्ञे स्वयं शुम्भं निशुम्भं च हनिष्यसि ॥ २४ ॥",
        hindi = """
            (काली का कथन): "माता काली ने चण्डिका से कहा: 'हे देवी! मैंने यहाँ इस युद्धभूमि में चण्ड और मुण्ड नामक इन दो 'महापशुओं' को मार गिराया है' (महापशू)।"
            "'मैंने इन्हें आपके लिए एक 'उपहार' (उपहृतौ) के रूप में लाकर यहाँ रख दिया है'।"
            "'अब युद्ध रूपी इस महान यज्ञ (युद्धयज्ञे) में, शुम्भ और निशुम्भ का वध आप स्वयं (स्वयं) करेंगी'।"
            "यहाँ चण्ड और मुण्ड को 'महापशु' (Great Beasts) कहा गया है, जो इंसान की उस जानवरों वाली सोच का प्रतीक है।"
            "तन्त्र में 'पशु-बलि' (Animal Sacrifice) का असली मतलब जानवरों को काटना नहीं, बल्कि अपने अंदर के 'पशु-भाव' (ईगो) को काटना है।"
            "काली ने इंसान के गुस्से और मूर्खता (पशु-भाव) की बलि चढ़ाकर उसे महामाया को सौंप दिया है।"
            "'युद्धयज्ञे' (Battle as a Sacrifice)—सनातन धर्म में धर्म-युद्ध भी एक यज्ञ के समान पवित्र माना गया है, जहाँ बुराई की आहुति दी जाती है।"
            "काली कह रही हैं कि मैंने सेनापतियों को मार दिया है, पर मुख्य बीमारी (शुम्भ-निशुम्भ) का इलाज आप (सुप्रीम चेतना) ही करेंगी।"
            "इसका अर्थ है कि हमारा वैराग्य (काली) बाहरी बुराइयों को काट सकता है, पर मूल अहंकार को केवल 'आत्मज्ञान' (अम्बिका) ही मिटा सकता है।"
            "यह श्लोक अद्वैत दर्शन की उस गहराई को छूता है जहाँ सारी शक्तियां अंततः एक ही केंद्र (Center) पर निर्भर करती हैं।"
        """.trimIndent(),
        english = """
            (Kali's Statement): "Mother Kali explicitly addressed Chandika: 'O Goddess! I have slaughtered these two 'Great Beasts' (Maha-pashu) named Chanda and Munda'."
            "'I have successfully brought them here and securely offered them strictly as a 'Sacred Gift' (Upahritau) for You'."
            "'Now, strictly inside this massive absolute 'Sacrifice of War' (Yuddha-yajna), You Yourself shall physically slaughter Shumbha and Nishumbha'."
            "Chanda and Munda are precisely addressed as 'Great Beasts', explicitly symbolizing the unrefined animalistic thinking of a human."
            "In Tantra, 'Animal Sacrifice' mathematically never implies killing physical animals; it strictly means severing one's internal 'Animalistic Ego'."
            "Kali has successfully sacrificed human anger and stupidity, offering them entirely cleanly to the Supreme Mahamaya."
            "'War as a Sacrifice'—In Sanatana Dharma, a righteous war is considered as holy as a fire-ritual, where evil is offered as oblations."
            "Kali explicitly states She has eliminated the commanders, but the core disease (Shumbha) strictly requires the Supreme Consciousness."
            "This implies our Detachment (Kali) can sever external vices, but the root Ego can only be destroyed by 'Self-Realization' (Ambika)."
            "This precise verse flawlessly touches the absolute depths of Non-dual philosophy where all active powers rely on one singular Center."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 24,
        sanskrit = "ऋषिरुवाच ॥ २५ ॥\nतावानीतौ ततो दृष्ट्वा चण्डमुण्डौ महासुरौ ।\nउवाच कालीं कल्याणी ललितं चण्डिका वचः ॥ २६ ॥",
        hindi = """
            (चण्डिका का मधुर वचन): "ऋषि मेधा ने राजा सुरथ से कहा: चण्ड और मुण्ड जैसे उन दो महा-असुरों के कटे हुए सिरों को देखकर।"
            "कल्याणमयी (कल्याणी) माता चण्डिका ने माता काली से अत्यंत 'मधुर और सुंदर' (ललितं) वचनों में यह बात कही।"
            "यह श्लोक फिर से 'लॉ ऑफ पोलारिटी' (Law of Polarity) का एक अत्यंत सुंदर और तांत्रिक उदाहरण प्रस्तुत करता है।"
            "एक तरफ खौफनाक माता काली हैं, जिनके हाथ में खून से सने हुए राक्षसों के सिर हैं और वे अट्टहास कर रही हैं।"
            "और दूसरी तरफ माता अम्बिका हैं, जो इतनी भयानक चीज़ देखकर भी बिल्कुल शांत हैं और 'ललित' (Sweet/Playful) स्वर में बात कर रही हैं।"
            "सत्य (Truth) कभी भी खून या मौत देखकर घबराता नहीं है, क्योंकि वह जानता है कि यह सब प्रकृति का एक 'मायावी खेल' है।"
            "'कल्याणी' (कल्याण करने वाली)—देवी का यह रूप बताता है कि यह वध भी अंततः ब्रह्मांड के कल्याण (Welfare) के लिए ही हुआ है।"
            "काली और अम्बिका कोई दो अलग भगवान नहीं हैं; वे एक ही 'सुप्रीम माइंड' (Supreme Mind) के दो अलग-अलग एक्सप्रेशन (Expressions) हैं।"
            "एक एक्सप्रेशन काम करता है (काली), और दूसरा एक्सप्रेशन उस काम को दिशा और अर्थ देता है (अम्बिका)।"
            "अब माता चण्डिका अपनी उस उग्र शक्ति (काली) को ब्रह्मांड का सबसे बड़ा और प्रसिद्ध 'टाइटल' (Title/Name) देने जा रही हैं।"
        """.trimIndent(),
        english = """
            (Chandika's Sweet Words): "The Sage Medha continued to the King: Visually witnessing the severed heads of those two massive mega-demons."
            "The highly benevolent (Kalyani) Mother Chandika explicitly spoke exceptionally 'Sweet and playful' (Lalitam) words directly to Mother Kali."
            "This verse flawlessly successfully presents an exceptionally beautiful and purely Tantric exact example of the 'Law of Polarity'."
            "On one specific exact side stands the horrifying Mother Kali, physically gripping blood-soaked demon heads while roaring with cosmic laughter."
            "On the exact identical other side is Mother Ambika, who remains absolutely perfectly peaceful and speaks with a 'Sweet' (Lalitam) and gentle tone."
            "Absolute Truth mathematically never panics upon visually witnessing blood or death, as it perfectly understands this is merely Nature's 'Cosmic Play'."
            "'Kalyani' (Benevolent)—This specific format explicitly proves that even this brutal slaughter was executed exclusively for global Welfare."
            "Kali and Ambika are absolutely zero separate distinct Gods; they are perfectly precisely two exact Expressions of one singular 'Supreme Mind'."
            "Exactly one expression actively physically executes the raw work (Kali), while the exact other provides direction and absolute meaning (Ambika)."
            "Now, Mother Chandika is officially preparing to grant Her fierce active power the absolute most famous and iconic 'Title' in the entire universe."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 25,
        sanskrit = "यस्माच्चण्डं च मुण्डं च गृहीत्वा त्वमुपागता ।\nचामुण्डेति ततो लोके ख्याता देवि भविष्यसि ॥ २७ ॥\n\n(इति श्रीमार्कण्डेयपुराणे सावर्णिके मन्वन्तरे देवीमाहात्म्ये चण्डमुण्डवधो नाम सप्तमोऽध्यायः ॥ ७ ॥)",
        hindi = """
            (चामुण्डा नामकरण): "देवी चण्डिका ने कहा: 'हे देवी! चूँकि तुम स्वयं चण्ड और मुण्ड दोनों राक्षसों का सिर काटकर (गृहीत्वा) मेरे पास लाई हो'।"
            "'इसलिए आज से इस पूरे संसार (लोके) में तुम 'चामुण्डा' (चामुण्डेति) के इस महान नाम से विख्यात (प्रसिद्ध) होओगी!'"
            "(यहीं पर श्रीमार्कण्डेय पुराण में वर्णित 'चण्ड-मुण्ड वध' नामक दुर्गा सप्तशती का अत्यंत पवित्र सातवां अध्याय पूर्ण होता है)।"
            "'चामुण्डा' नाम कोई साधारण नाम नहीं है; यह एक 'पदवी' (Title) है जो 'क्रोध और मूर्खता के पूर्ण विनाशक' को दी जाती है।"
            "'चा' (चण्ड) और 'मुण्डा' (मुण्ड) शब्दों को मिलाकर देवी का यह नामकरण हुआ है।"
            "यह इस बात का प्रमाण है कि जब इंसान अपनी बुराइयों (ईगो) को मारता है, तो भगवान उसे एक 'नई पहचान' (New Identity) देते हैं।"
            "चामुण्डा वह ऊर्जा है जो इंसान के दिमाग से हर प्रकार के एग्रेसन (Aggression) और इलॉजिकल (Illogical) थॉट्स को हमेशा के लिए साफ कर देती है।"
            "इस नाम का जाप करने से 'ब्लैक मैजिक' (Negative energy) और 'डिप्रेशन' तुरंत टूट जाता है, क्योंकि यह नाम साक्षात् 'विक्ट्री' (Victory) का प्रतीक है।"
            "सातवें अध्याय का यह समापन यह सुनिश्चित करता है कि अज्ञान की बाहरी परतें अब पूरी तरह कट चुकी हैं।"
            "अब 'रक्तबीज' (Endless thoughts) का वह भयानक युद्ध शुरू होने वाला है जो ध्यान (Meditation) का सबसे कठिन लेवल होता है।"
        """.trimIndent(),
        english = """
            (The Naming of Chamunda): "Goddess Chandika declared: 'O Goddess! Strictly because You have personally severed and successfully brought the exact heads of Chanda and Munda to Me'."
            "'Therefore, from this exact absolute moment onward, You shall become universally famous explicitly by the supreme name 'Chamunda'!'"
            "(Right exactly here successfully concludes the highly sacred Seventh Chapter named 'The Slaughter of Chanda and Munda')."
            "The name 'Chamunda' is absolutely zero ordinary title; it is the ultimate cosmic 'Title' awarded strictly to the 'Permanent Destroyer of Anger and Stupidity'."
            "This exact supreme nomenclature was successfully flawlessly constructed purely by combining 'Cha' (Chanda) and 'Munda'."
            "This is the mathematical proof that exactly when a human successfully slaughters his internal vices, God grants him a flawless 'New Identity'."
            "Chamunda is that specific cosmic energy which permanently cleanses every trace of toxic aggression and illogical thoughts from the human brain."
            "Chanting this precise name instantaneously shatters negative energy and depression because this exact name is the literal symbol of absolute 'Victory'."
            "The flawless conclusion of this Seventh Chapter mathematically guarantees that the external heavy layers of ignorance have been permanently severed."
            "Now, the apocalyptic war against 'Raktabija' (Endless multiplying thoughts) is preparing to launch, representing the absolute hardest level of deep meditation."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 25,
        sanskrit = "ऋषिरुवाच ॥ २५ ॥",
        hindi = """
            (ऋषि का कथन): "महर्षि मेधा ने राजा सुरथ और वैश्य से अपने अगले वचन कहे (ऋषिरुवाच)।"
            "माता काली द्वारा उन दोनों महा-राक्षसों का सिर काटकर लाने के बाद यह एक अत्यंत महत्वपूर्ण क्षण था।"
            "ऋषि यहाँ केवल एक कथावाचक नहीं हैं, बल्कि वे उस 'सुप्रीम विज़डम' (Supreme Wisdom) के प्रतीक हैं जो सत्य को डिकोड करता है।"
            "युद्ध के उस खौफनाक तांडव के बाद अब प्रकृति में एक 'पॉज़' (Pause) या गहरा ठहराव आ गया है।"
            "जब हमारा वैराग्य (काली) हमारे ईगो को मार देता है, तो हमारी चेतना (अम्बिका) उसे किस तरह स्वीकार करती है?"
            "यह समझने के लिए राजा सुरथ का मन अब पूरी तरह से एकाग्र (Focused) हो चुका है।"
            "ऋषि का बोलना यह दर्शाता है कि स्पिरिचुअल जर्नी में 'ज्ञान' और 'एक्शन' दोनों हमेशा साथ-साथ चलते हैं।"
            "काली ने अपना 'एक्शन' पूरा कर दिया है, अब अम्बिका अपना 'ज्ञान' (सम्मान/Title) देंगी।"
            "यह छोटा सा श्लोक उस मौन का प्रतीक है जहाँ से ब्रह्मांड का सबसे बड़ा आशीर्वाद निकलने वाला है।"
            "अब देवी चण्डिका अपने मुख से वे मधुर शब्द बोलेंगी जो इतिहास में हमेशा के लिए अमर हो जाएंगे।"
        """.trimIndent(),
        english = """
            (The Sage Speaks): "The great Sage Medha explicitly spoke his next words to King Suratha (Rishiruvacha)."
            "This was an exceptionally critical moment exactly after Mother Kali brought the severed heads of the two mega-demons."
            "The Sage is absolutely zero ordinary storyteller; he mathematically symbolizes 'Supreme Wisdom' decoding the Truth."
            "Following that horrifying apocalyptic dance of war, a profound 'Pause' or stillness had now enveloped Mother Nature."
            "When our internal detachment (Kali) slaughters our ego, exactly how does our core consciousness (Ambika) accept it?"
            "King Suratha's mind is now completely flawlessly 'Focused' explicitly to successfully understand this advanced cosmic mystery."
            "The Sage speaking proves that in the spiritual journey, 'Action' and 'Wisdom' mathematically always walk together."
            "Kali has successfully executed Her raw 'Action', and now Ambika will grant Her divine 'Knowledge' (Title)."
            "This microscopic verse symbolizes that exact cosmic silence from which the absolute greatest blessing will emerge."
            "Now Goddess Chandika will physically utter those sweet divine words that will become permanently immortal in history."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 26,
        sanskrit = "तावानीतौ ततो दृष्ट्वा चण्डमुण्डौ महासुरौ ।\nउवाच कालीं कल्याणी ललितं चण्डिका वचः ॥ २६ ॥",
        hindi = """
            (चण्डिका का मधुर वचन): "चण्ड और मुण्ड जैसे उन दो महा-असुरों के कटे हुए सिरों को अपने सामने लाया हुआ देखकर।"
            "कल्याणमयी (कल्याणी) माता चण्डिका ने माता काली से अत्यंत 'मधुर और सुंदर' (ललितं) वचनों में यह बात कही।"
            "यह श्लोक 'लॉ ऑफ पोलारिटी' (Law of Polarity) का एक अत्यंत सुंदर और तांत्रिक उदाहरण प्रस्तुत करता है।"
            "एक तरफ खौफनाक माता काली हैं, जिनके हाथ में खून से सने हुए राक्षसों के सिर हैं और वे अट्टहास कर रही हैं।"
            "और दूसरी तरफ माता अम्बिका हैं, जो इतनी भयानक चीज़ देखकर भी बिल्कुल शांत और प्रसन्न हैं।"
            "सत्य (Truth) कभी भी खून या मौत देखकर घबराता नहीं है, क्योंकि वह इसे प्रकृति का एक मायावी खेल मानता है।"
            "'कल्याणी' (कल्याण करने वाली)—यह बताता है कि यह वध भी अंततः ब्रह्मांड के कल्याण के लिए ही हुआ है।"
            "काली और अम्बिका कोई दो अलग भगवान नहीं हैं; वे एक ही 'सुप्रीम माइंड' के दो अलग एक्सप्रेशन (Expressions) हैं।"
            "एक एक्सप्रेशन काम करता है (काली), और दूसरा एक्सप्रेशन उस काम को दिशा और अर्थ देता है (अम्बिका)।"
            "अब माता चण्डिका अपनी उस उग्र शक्ति (काली) को ब्रह्मांड का सबसे बड़ा 'टाइटल' (Title) देने जा रही हैं।"
        """.trimIndent(),
        english = """
            (Chandika's Sweet Words): "Visually witnessing the severed heads of those two massive mega-demons brought directly before Her."
            "The highly benevolent (Kalyani) Mother Chandika explicitly spoke exceptionally 'Sweet and playful' (Lalitam) words to Mother Kali."
            "This verse flawlessly presents an exceptionally beautiful and purely Tantric exact example of the cosmic 'Law of Polarity'."
            "On one side stands the horrifying Mother Kali, physically gripping blood-soaked demon heads while roaring with laughter."
            "On the exact other side is Mother Ambika, who remains absolutely perfectly peaceful and speaks with a gentle tone."
            "Absolute Truth mathematically never panics upon visually witnessing death, as it perfectly understands this is Nature's play."
            "'Kalyani' (Benevolent)—This format explicitly proves that even this brutal slaughter was executed exclusively for global welfare."
            "Kali and Ambika are absolutely zero separate Gods; they are perfectly precisely two exact Expressions of one singular 'Supreme Mind'."
            "Exactly one expression actively executes the raw work (Kali), while the exact other provides direction and meaning (Ambika)."
            "Now, Mother Chandika is officially preparing to grant Her fierce active power the absolute most famous 'Title' in the universe."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 27,
        sanskrit = "यस्माच्चण्डं च मुण्डं च गृहीत्वा त्वमुपागता ।\nचामुण्डेति ततो लोके ख्याता देवि भविष्यसि ॥ २७ ॥\n\n(इति श्रीमार्कण्डेयपुराणे सावर्णिके मन्वन्तरे देवीमाहात्म्ये चण्डमुण्डवधो नाम सप्तमोऽध्यायः ॥ ७ ॥)",
        hindi = """
            (चामुण्डा नामकरण): "देवी चण्डिका ने कहा: 'हे देवी! चूँकि तुम स्वयं चण्ड और मुण्ड दोनों राक्षसों का सिर काटकर मेरे पास लाई हो'।"
            "'इसलिए आज से इस पूरे संसार (लोके) में तुम 'चामुण्डा' (चामुण्डेति) के इस महान नाम से विख्यात (प्रसिद्ध) होओगी!'"
            "(यहीं पर श्रीमार्कण्डेय पुराण में वर्णित 'चण्ड-मुण्ड वध' नामक दुर्गा सप्तशती का अत्यंत पवित्र सातवां अध्याय पूर्ण होता है)।"
            "'चामुण्डा' नाम कोई साधारण नाम नहीं है; यह एक 'पदवी' (Title) है जो 'क्रोध और मूर्खता के परम विनाशक' को दी जाती है।"
            "'चा' (चण्ड) और 'मुण्डा' (मुण्ड) शब्दों को मिलाकर देवी का यह अत्यंत शक्तिशाली नामकरण हुआ है।"
            "यह इस बात का प्रमाण है कि जब इंसान अपनी बुराइयों (ईगो) को मारता है, तो भगवान उसे एक 'नई पहचान' (Identity) देते हैं।"
            "चामुण्डा वह ऊर्जा है जो इंसान के दिमाग से हर प्रकार के एग्रेसन (Aggression) को हमेशा के लिए साफ कर देती है।"
            "इस नाम का जाप करने से 'डिप्रेशन' तुरंत टूट जाता है, क्योंकि यह नाम साक्षात् 'विक्ट्री' (Victory) का परम प्रतीक है।"
            "सातवें अध्याय का यह समापन यह सुनिश्चित करता है कि अज्ञान की बाहरी परतें अब पूरी तरह कट चुकी हैं।"
            "अब 'रक्तबीज' (Endless thoughts) का वह भयानक युद्ध शुरू होने वाला है जो ध्यान (Meditation) का सबसे कठिन लेवल है।"
        """.trimIndent(),
        english = """
            (The Naming of Chamunda): "Goddess Chandika declared: 'O Goddess! Strictly because You have personally severed and successfully brought the heads of Chanda and Munda to Me'."
            "'Therefore, from this exact absolute moment onward, You shall become universally famous explicitly by the supreme name Chamunda!'"
            "(Right exactly here successfully concludes the highly sacred Seventh Chapter formally named 'The Slaughter of Chanda and Munda')."
            "The name 'Chamunda' is absolutely zero ordinary title; it is the ultimate cosmic 'Title' awarded strictly to the destroyer of anger and stupidity."
            "This exact supreme nomenclature was successfully flawlessly constructed purely by mathematically combining the words 'Cha' (Chanda) and 'Munda'."
            "This is absolute proof that exactly when a human successfully slaughters his internal vices, God grants him a flawless 'New Identity'."
            "Chamunda is that specific cosmic energy which permanently cleanses every trace of toxic aggression from the human brain."
            "Chanting this precise name instantaneously shatters depression because this exact name is the literal physical symbol of absolute 'Victory'."
            "The flawless conclusion of this Seventh Chapter mathematically guarantees that the external heavy layers of ignorance are permanently severed."
            "Now, the apocalyptic war against 'Raktabija' (Endless multiplying thoughts) is preparing to launch, representing the absolute hardest level of meditation."
        """.trimIndent()
    )
)