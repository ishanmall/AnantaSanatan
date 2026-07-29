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
fun AdhyayaFiveScreen() {
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
                    val targetIndex = adhyayaFiveShlokas.indexOfFirst { it.id == targetId }
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
            label = { Text("Search Shloka (1-${adhyayaFiveShlokas.size})") },
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
            itemsIndexed(adhyayaFiveShlokas) { _, shloka ->
                SaptshatiCard(shloka = shloka)
            }
        }
    }
}

// Top-Level Data List - Adhyaya 5 (Shlokas 1 to 10)
val adhyayaFiveShlokas = listOf(
    SaptshatiShloka(
        id = 1,
        sanskrit = "ऋषिरुवाच ॥ १ ॥\nपुरा शुम्भनिशुम्भाभ्यामसुराभ्यां शचीपतेः ।\nत्रैलोक्यं यज्ञभागाश्च हृता मदबलाश्रयात् ॥ २ ॥",
        hindi = """
            (शुम्भ-निशुम्भ का उदय): "ऋषि मेधा ने कहा: हे राजन्! प्राचीन काल में शुम्भ और निशुम्भ नामक दो महा-असुरों ने।"
            "अपनी शक्ति और अहंकार के नशे (मदबलाश्रयात्) में आकर इन्द्र (शचीपति) का सर्वस्व छीन लिया था।"
            "उन्होंने देवताओं से न केवल उनकी सत्ता छीनी, बल्कि उनके यज्ञों का भाग भी हड़प लिया।"
            "पूरे तीनों लोकों पर उन दोनों का क्रूर और निरंकुश शासन स्थापित हो गया था।"
            "यह अध्याय 'अहंकार' और 'ममता' (I and Mine) के नए मनोवैज्ञानिक युद्ध को दर्शाता है।"
            "शुम्भ वह अहंकार है जो खुद को कर्ता समझता है, और निशुम्भ वह मोह है जो हर चीज़ पर कब्ज़ा चाहता है।"
            "जब ये दोनों प्रवृत्तियां हावी होती हैं, तो इंसान के अंदर के दिव्य गुण (देवता) कमज़ोर पड़ जाते हैं।"
            "यज्ञ भाग छीनना मतलब इंसान की अच्छी ऊर्जा का गलत आदतों द्वारा सोख लिया जाना है।"
            "अब चेतना की शांति पूरी तरह भंग हो चुकी है और अज्ञान का साम्राज्य फैल चुका है।"
            "यह स्थिति उस मानसिक अंधेरे की है जहाँ इंसान अपनी आत्मा की आवाज़ सुनना बंद कर देता है।"
        """.trimIndent(),
        english = """
            (The Rise of Shumbha and Nishumbha): "The Sage declared: O King! In the ancient cosmic past, two mega-demons named Shumbha and Nishumbha."
            "Driven by the extreme intoxication of their own power (Mada), they violently seized the empire of Indra."
            "They ruthlessly snatched the celestial portions of fire-rituals that rightfully belonged to the Gods."
            "Their absolute and cruel dominance was firmly established across the entire three worlds."
            "This chapter introduces a new psychological war against the illusions of 'I' and 'Mine'."
            "Shumbha represents the primary Arrogance of the doer, while Nishumbha represents the attachment of possession."
            "When these two tendencies dominate, a human's internal divine virtues (Gods) become powerless."
            "Snatching the ritual portions symbolizes toxic habits consuming a human's positive life energy."
            "The peace of consciousness is now completely shattered, replaced by the empire of thick ignorance."
            "This represents a mental darkness where the human ceases to hear the subtle voice of the soul."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 2,
        sanskrit = "तावेव सूर्यतां तद्वदधिकारं तथैन्दवम् ।\nकौबेरमथ याम्यं च चक्राते वरुणस्य च ॥ ३ ॥",
        hindi = """
            (शक्तियों का अपहरण): "उन दोनों असुरों ने सूर्य, चंद्रमा, कुबेर, यम और वरुण के अधिकारों को भी छीन लिया।"
            "उन्होंने प्रकृति की उन सभी शक्तियों पर अपना कब्जा कर लिया जो ब्रह्मांड का संचालन करती हैं।"
            "अब प्रकाश, शीतलता, धन, न्याय और जल—सब कुछ असुरों के नियंत्रण में आ गया था।"
            "यह दृश्य दर्शाता है कि जब अहंकार (ईगो) बहुत बड़ा हो जाता है, तो वह पूरी पर्सनालिटी को हाइजैक कर लेता है।"
            "सूर्य हमारी 'दृष्टि' है और चंद्रमा हमारा 'मन' है, जो अब अज्ञान के गुलाम बन चुके थे।"
            "कुबेर (संपत्ति) और यम (अनुशासन) का राक्षसों के हाथ में होना जीवन के असंतुलन का प्रतीक है।"
            "जब बुद्धि भ्रष्ट होती है, तो इंसान की सारी नेचुरल पावर्स उसके विनाश का कारण बनने लगती हैं।"
            "अहंकार चाहता है कि वह ईश्वर की तरह हर चीज़ को कंट्रोल करे, जो कि असंभव है।"
            "प्रकृति का नियम टूट चुका था और चारों ओर केवल अव्यवस्था (Chaos) का माहौल था।"
            "देवता अब अपने ही अस्तित्व को बचाने के लिए दर-दर भटकने को मजबूर हो गए थे।"
        """.trimIndent(),
        english = """
            (Abduction of Powers): "Those two demons seized the divine authority of the Sun, the Moon, Kubera, Yama, and Varuna."
            "They forcefully took control over all natural forces that govern the operations of the entire universe."
            "Light, coolness, wealth, justice, and water—everything was now strictly under demonic surveillance."
            "This visually proves that when the Ego becomes colossal, it effectively hijacks the entire human personality."
            "The Sun symbolizes our 'Vision' and the Moon represents our 'Mind', both now enslaved by ignorance."
            "Having Kubera (wealth) and Yama (discipline) under demonic grip represents total internal imbalance."
            "When intellect is corrupted, all natural human powers start contributing to one's own self-destruction."
            "The toxic ego desperately desires to control every variable like God, which is mathematically impossible."
            "The natural law was shattered, leading to an environment of absolute and terrifying cosmic Chaos."
            "The divine virtues were now forced to wander aimlessly just to preserve their core existence."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 3,
        sanskrit = "तावेव पवनार्धं च चकरतुर्वह्निकर्म च ।\nततो देवा विनिधूता भ्रष्टराज्याः पराजिताः ॥ ४ ॥",
        hindi = """
            (वायु और अग्नि पर कब्ज़ा): "उन असुरों ने वायु (पवन) और अग्नि (वह्नि) के कार्यों को भी अपने अधीन कर लिया।"
            "इस प्रकार सभी देवताओं का राज्य छीन लिया गया और वे बुरी तरह पराजित होकर स्वर्ग से निकाल दिए गए।"
            "अधिकार छिन जाने के कारण वे इधर-उधर भटकने लगे और अत्यंत दुखी रहने लगे।"
            "वायु हमारी 'सांस' (प्राण) है और अग्नि हमारी 'जठराग्नि' (डाइजेशन और विचार की चमक) है।"
            "जब नकारात्मकता गहरी होती है, तो इंसान का प्राण-प्रवाह और उसकी वैचारिक अग्नि दोनों दूषित हो जाती हैं।"
            "पराजित देवता उस स्थिति का प्रतीक हैं जहाँ इंसान की अच्छाई पूरी तरह 'डिप्रेस' (Depress) हो जाती है।"
            "अहंकार ने स्वर्ग (मन की ऊँचाई) पर कब्ज़ा कर लिया और शांति को ज़मीन पर धकेल दिया।"
            "यह श्लोक उस चरम लाचारी को दिखाता है जहाँ इंसान अपनी बुरी आदतों के आगे घुटने टेक देता है।"
            "जब सिस्टम का हर हिस्सा (इंद्रियां) फेल हो जाता है, तब केवल एक ही रास्ता बचता है।"
            "वह रास्ता है अपनी मूल शक्ति (Origin) की ओर वापस लौटना और प्रार्थना करना।"
        """.trimIndent(),
        english = """
            (Control over Air and Fire): "The demons even dominated the functions of the wind (Vayu) and the fire (Agni)."
            "Thus, all the Gods were stripped of their kingdoms, brutally defeated, and expelled from heaven."
            "Having lost their authority, they began wandering aimlessly, engulfed in extreme psychological sorrow."
            "Wind symbolizes our 'Life-breath' (Prana) and Fire represents our 'Internal Glow' and digestion of thoughts."
            "When negativity deepens, a human's life-force and intellectual clarity both become heavily contaminated."
            "The defeated Gods represent a state where human goodness becomes entirely and purely Depressed."
            "Arrogance captured the 'Heaven' of high-vibration thinking and pushed peace into the dirt."
            "This verse demonstrates that extreme helplessness where a human surrenders to his own bad habits."
            "When every component of the biological system (senses) fails, strictly only one path remains."
            "That path is to return to the absolute Origin of power and initiate a sincere prayer."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 4,
        sanskrit = "निर्धूतास्ते महाभागास्तैरसुरैर्गणपुङ्गवाः ।\nविचिन्तयन्ति तां देवीं हताधिकाराः पराजिताः ॥ ५ ॥",
        hindi = """
            (देवी का स्मरण): "असुरों द्वारा निकाले गए वे महान देवता और श्रेष्ठ गण अत्यंत चिंतित हो उठे।"
            "अपनी सत्ता और अधिकार खोने के बाद, उन्होंने उस परम देवी का स्मरण करना शुरू किया।"
            "उन्हें याद आया कि कैसे माता ने पहले भी उनकी रक्षा की थी और महिषासुर का संहार किया था।"
            "यही इंसान की 'अवेयरनेस' (Awareness) के जागने का क्षण है, जब वह संकट में अपनी जड़ों को याद करता है।"
            "देवताओं का विचिन्तन (Contemplation) यह बताता है कि समाधान हमेशा चेतना के पास ही होता है।"
            "जब बाहरी दुनिया (सत्ता) हाथ से निकल जाती है, तभी इंसान अंदर की ओर (Inward) देखना शुरू करता है।"
            "हार (Defeat) अक्सर अहंकार को तोड़ने और भक्ति को जगाने के लिए एक आवश्यक औषधि की तरह काम करती है।"
            "वे अब समझ चुके थे कि उनकी अपनी ताकत इन राक्षसों (गहरे विकारों) के सामने बहुत कम है।"
            "स्मरण करना केवल एक विचार नहीं, बल्कि एक 'संकल्प' है जो खोई हुई शक्ति को वापस बुलाता है।"
            "चेतना के इस मोड़ पर ही उद्धार की पहली किरण दिखाई देने लगती है।"
        """.trimIndent(),
        english = """
            (Remembering the Goddess): "Expelled by the demons, those great Gods and noble beings became deeply worried."
            "Having lost their status and authority, they began to intensely meditate upon the Supreme Goddess."
            "They recalled how the Mother had previously protected them and annihilated Mahishasura."
            "This is the exact moment of awakening 'Awareness', when a human remembers his roots during a crisis."
            "The 'Contemplation' (Vichintayana) of the Gods proves that the solution always resides within consciousness."
            "Only when the external world (power) slips away does a human truly begin to look Inward."
            "Defeat often functions as a necessary medicine to shatter the ego and awaken pure devotion."
            "They now realized that their independent strength was insufficient against these deep mental distortions."
            "Remembering is not just a thought, but a 'Cosmic Resolve' that summons back lost power."
            "At this specific turning point of consciousness, the first ray of salvation begins to manifest."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 5,
        sanskrit = "पुनश्च गौरीदेहात्सा समुद्भूता यथाभवत् ।\nवधाय दुष्टदैत्यानां तथा शुम्भनिशुम्भयोः ॥ ६ ॥",
        hindi = """
            (वरदान की याद): "उन्हें देवी का वह वचन याद आया कि 'जब भी तुम संकट में मुझे याद करोगे, मैं प्रकट हो जाऊंगी'।"
            "माता ने स्वयं कहा था कि वह दुष्ट राक्षसों और शुम्भ-निशुम्भ का संहार करने के लिए अवतार लेंगी।"
            "देवताओं को वह आश्वासन याद आया जो माता ने पिछले युद्ध के अंत में उन्हें दिया था।"
            "यह श्लोक 'ईश्वर के वादे' (Divine Promise) पर अटूट विश्वास का प्रतीक है।"
            "इंसान के अंदर जो 'ज्ञान' (Gauri) है, उसी से मुक्ति की शक्ति (Kaushiki) का जन्म होना तय है।"
            "जब हम अपनी शुद्धता (Purity) पर फोकस करते हैं, तो हमारे संकटों का अंत होना शुरू हो जाता है।"
            "शुम्भ-निशुम्भ का वध केवल एक कहानी नहीं, बल्कि 'अहंकार' की मृत्यु की भविष्यवाणी है।"
            "देवी का 'पुनश्च' (फिर से) प्रकट होना यह बताता है कि सत्य कभी हारता नहीं, वह बस समय का इंतज़ार करता है।"
            "देवताओं का यह विश्वास ही उन्हें हिमालय की ओर ले जाने का मुख्य कारण बना।"
            "सच्ची प्रार्थना तभी सफल होती है जब उसमें पुराने अनुभवों का 'फेथ' (Faith) शामिल हो।"
        """.trimIndent(),
        english = """
            (Recalling the Boon): "They recalled the Goddess's word: 'Whenever you remember Me in crisis, I shall manifest'."
            "The Mother Herself had declared She would take form to destroy Shumbha and Nishumbha."
            "The Gods remembered the unshakeable assurance given by the Mother at the end of the previous war."
            "This verse symbolizes absolute trust in the 'Divine Promise' during the darkest times."
            "From the 'Wisdom' (Gauri) within a human, the power of liberation (Kaushiki) is destined to be born."
            "Exactly when we focus on our internal Purity, the termination of our crisis begins to accelerate."
            "The slaughter of Shumbha-Nishumbha is not just a story, but a prophecy of the Ego's inevitable death."
            "The Goddess manifesting 'Again' (Punashcha) proves that Truth never loses; it simply awaits the right time."
            "This unshakeable faith was the primary reason that led the Gods towards the high Himalayas."
            "A true prayer succeeds strictly when it incorporates the 'Faith' derived from previous spiritual experiences."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 6,
        sanskrit = "इति कृत्व मतिं देवा हिमवन्तं नगेश्वरम् ।\nजग्मुस्तत्र ततो देवीं विष्णुमायां प्रतुष्टुवुः ॥ ७ ॥",
        hindi = """
            (हिमालय गमन): "ऐसा विचार करके सभी देवता पर्वतों के राजा 'हिमालय' (हिमवन्तं) की ओर चल पड़े।"
            "वहाँ पहुँचकर उन्होंने उस परम देवी 'विष्णुमाया' की अत्यंत भावपूर्ण स्तुति करना प्रारंभ किया।"
            "हिमालय यहाँ 'स्थिरता' (Stability) और 'उच्च चेतना' (Higher Consciousness) का प्रतीक है।"
            "जब मन बहुत अशांत होता है, तो उसे शांत करने के लिए 'हिमालय' जैसी मानसिक स्थिरता की ज़रूरत होती है।"
            "पर्वतों के राजा के पास जाना मतलब अपनी बुद्धि को सांसारिक शोर से ऊपर उठाना है।"
            "विष्णुमाया वह शक्ति है जो पूरे ब्रह्मांड को अपने वश में रखती है और सत्य को छिपाती भी है।"
            "देवता अब उस माया के परदे को हटाकर सत्य का दर्शन करना चाहते हैं।"
            "हिमालय की गुफाएं हमारे 'हृदय की गहराई' का प्रतीक हैं जहाँ भगवान का निवास होता है।"
            "प्रार्थना की शुरुआत हमेशा एक शांत और पवित्र स्थान (Environment) से होनी चाहिए।"
            "देवताओं का यह सामूहिक प्रयास ब्रह्मांडीय ऊर्जा को खींचने का एक शक्तिशाली तरीका है।"
        """.trimIndent(),
        english = """
            (Journey to the Himalayas): "Having made this firm resolution, all the Gods traveled towards the 'Himalayas', the king of mountains."
            "Reaching there, they initiated a profoundly emotional praise of the Supreme Goddess 'Vishnumaya'."
            "The Himalayas flawlessly symbolize absolute 'Stability' and the reach of 'Higher Consciousness'."
            "When the mind is extremely disturbed, it requires the mental stability of the Himalayas to find peace."
            "Approaching the king of mountains translates to elevating one's intellect above worldly noise."
            "Vishnumaya is that cosmic energy that governs the entire universe and simultaneously veils the Truth."
            "The Gods now desperately desire to pierce through that veil of Maya to perceive the Ultimate Reality."
            "The caves of the Himalayas represent the 'Depths of the Heart' where the Divine perpetually resides."
            "The initiation of any prayer should strictly happen in a peaceful and sacred internal Environment."
            "This collective effort of the Gods is a highly powerful method to summon absolute cosmic energy."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 7,
        sanskrit = "देवा ऊचुः ॥ ८ ॥\nनमो देव्यै महादेव्यै शिवायै सततं नमः ।\nनमः प्रकृत्यै भद्रायै नियताः प्रणताः स्म ताम् ॥ ९ ॥",
        hindi = """
            (अपराजिता स्तुति का प्रारंभ): "देवताओं ने कहा: उस परम देवी को नमस्कार है, उस महादेवी को मेरा बारंबार नमस्कार है।"
            "कल्याण करने वाली 'शिवा' देवी को हम सदा प्रणाम करते हैं।"
            "उन मूल प्रकृति और मंगल करने वाली भद्रा को हमारा नमस्कार है, हम नियमपूर्वक उन्हें प्रणाम करते हैं।"
            "यहाँ से 'नमो देव्यै' मंत्र की शुरुआत होती है, जो 'सरेंडर' का सबसे बड़ा महामंत्र है।"
            "महादेवी वह हैं जिनसे बड़ा ब्रह्मांड में और कोई तत्व नहीं है।"
            "'शिवा' का अर्थ है जो परम शांत और शुभ है, जो हर स्थिति में हमारा भला ही करती है।"
            "प्रकृति (Nature) ही वह जननी है जो हमें जीवन देती है, इसलिए उसके प्रति कृतज्ञता ज़रूरी है।"
            "'नियताः प्रणताः'—यह बताता है कि देवताओं का प्रणाम 'कैजुअल' नहीं, बल्कि 'डिसिप्लिन' (Discipline) के साथ है।"
            "बिना अनुशासन के की गई कोई भी प्रार्थना कभी भी प्रभावी (Effective) नहीं हो सकती।"
            "देवी के इन नामों का उच्चारण ही मन की सारी गंदगी को साफ़ करने के लिए काफी है।"
        """.trimIndent(),
        english = """
            (Beginning of Aparajita Stuti): "The Gods prayed: Salutations to the Goddess, salutations to the Great Goddess repeatedly."
            "We perpetually bow down to the Goddess 'Shiva', the absolute embodiment of pure welfare."
            "Salutations to the Root Nature and the auspicious 'Bhadra'; we bow to Her with strict discipline."
            "Right here initiates the 'Namo Devyai' mantra, the absolute greatest chant of total Surrender."
            "Mahadevi is that Supreme Entity beyond which absolutely zero elements exist in the entire cosmos."
            "'Shiva' strictly translates to that which is absolute peace and auspicious, doing good in every situation."
            "Nature (Prakriti) is the universal mother granting us life, making gratitude towards Her essential."
            "'Niyatah Pranatah' proves that the Gods' salutation is zero casual act; it is a disciplined spiritual ritual."
            "Any prayer executed without strict internal Discipline can mathematically never be truly effective."
            "The mere pronunciation of these divine names is enough to cleanse all mental impurities instantly."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 8,
        sanskrit = "रौद्रायै नमो नित्यायै गौर्यै धात्र्यै नमो नमः ।\nज्योत्स्नायै चेन्दुरूपिण्यै सुखायै सततं नमः ॥ १० ॥",
        hindi = """
            (रौद्रा और गौरी): "भयानक रूप वाली रौद्रा को नमस्कार है, नित्य (परमानेंट) रहने वाली देवी को प्रणाम है।"
            "माता गौरी और इस जगत को धारण करने वाली धात्री को बार-बार नमस्कार है।"
            "चांदनी के समान शीतलता देने वाली और चंद्रमा का रूप धारण करने वाली देवी को हमारा प्रणाम है।"
            "हमेशा 'सुख' (Bliss) प्रदान करने वाली उन जगन्माता को हम निरंतर नमन करते हैं।"
            "यह श्लोक विरोधाभासों (Opposites) को बैलेंस करता है: 'रौद्रा' (उग्र) और 'गौरी' (शांत)।"
            "सत्य कभी-कभी कड़वा और भयानक (रौद्रा) होता है, और कभी-कभी अत्यंत सुंदर (गौरी) होता है।"
            "धात्री वह ऊर्जा है जो हमें टूटने से बचाती है और हमारे अस्तित्व को 'होल्ड' (Hold) करती है।"
            "चंद्रमा (इन्दुरूपिण्यै) मन की शांति का प्रतीक है, जो डिप्रेशन की आग को बुझा देता है।"
            "असली 'सुख' केवल बाहरी चीज़ों में नहीं, बल्कि चेतना की उस 'ज्योत्स्ना' (चांदनी) में है।"
            "जब हम इन रूपों को प्रणाम करते हैं, तो हमारे अंदर के दोनों पक्ष—उग्र और शांत—बैलेंस हो जाते हैं।"
        """.trimIndent(),
        english = """
            (Raudra and Gauri): "Salutations to Raudra (the fierce form), and to the Goddess who is Eternal and permanent."
            "Repeated salutations to Mother Gauri and to Dhatri, the absolute sustainer of this entire world."
            "We bow to the Goddess who provides moonlight-like coolness and who assumes the form of the Moon."
            "We continuously bow to the Universal Mother who perpetually grants absolute 'Bliss' (Sukha)."
            "This verse perfectly balances the Opposites: 'Raudra' (fierce) and 'Gauri' (peaceful)."
            "Truth is sometimes bitter and terrifying (Raudra), and sometimes exceptionally beautiful (Gauri)."
            "Dhatri is that cosmic energy that prevents us from breaking and 'Holds' our core existence together."
            "The Moon (Indu-rupini) symbolizes the peace of mind that extinguishes the fire of toxic depression."
            "Genuine 'Bliss' exists zero in external objects, but strictly in the 'Moonlight' of pure consciousness."
            "By bowing to these forms, both our internal aspects—the fierce and the calm—become mathematically balanced."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 9,
        sanskrit = "कल्याण्यै प्रणतां वृद्ध्यै सिद्ध्यै कुर्मो नमो नमः ।\nनैर्ऋत्यै भूभृतां लक्ष्म्यै शर्वाण्यै ते नमो नमः ॥ ११ ॥",
        hindi = """
            (कल्याणी और समृद्धि): "कल्याण करने वाली कल्याणी को प्रणाम है, वृद्धि (Growth) और सिद्धि (Success) को हमारा नमस्कार है।"
            "राजाओं की लक्ष्मी (ऐश्वर्य) और भगवान शिव की पत्नी शर्वाणी को हम बार-बार प्रणाम करते हैं।"
            "यहाँ 'सिद्धि' का अर्थ केवल जादू नहीं, बल्कि किसी भी काम को पूर्णता (Perfection) तक पहुँचाना है।"
            "देवी ही वह शक्ति हैं जो हमारे प्रयासों को 'रिजल्ट' (Result) में बदलती हैं।"
            "लक्ष्मी यहाँ केवल पैसा नहीं है, बल्कि वह 'ग्रेस' (Grace) है जो एक लीडर या राजा के व्यक्तित्व में होती है।"
            "शर्वाणी वह शक्ति है जो विनाश के देवता (शर्व/शिव) को भी 'क्रिएशन' (Creation) के लिए प्रेरित करती है।"
            "कल्याणी का अर्थ है कि ब्रह्मांड का हर मूवमेंट अंततः हमारे 'भले' के लिए ही हो रहा है।"
            "जब हम 'वृद्धि' को प्रणाम करते हैं, तो हम अपने जीवन में 'प्रगति' (Progress) के द्वार खोल देते हैं।"
            "यह श्लोक इंसान की मैटेरियल और स्पिरिचुअल दोनों तरह की ऊंचाइयों को कवर करता है।"
            "ईगो के बिना जो ऐश्वर्य प्राप्त होता है, वह टिकाऊ और पवित्र होता है।"
        """.trimIndent(),
        english = """
            (Kalyani and Prosperity): "We bow to Kalyani (the benevolent), and to Vriddhi (Growth) and Siddhi (Success)."
            "Repeated salutations to the Lakshmi (glory) of kings and to Sharvani, the divine power of Lord Shiva."
            "Here, 'Siddhi' does not merely mean magic, but the capacity to bring any task to absolute 'Perfection'."
            "The Goddess is that singular power that transforms our human efforts into concrete 'Results'."
            "Lakshmi is zero merely physical cash; she is that divine 'Grace' present in a leader's personality."
            "Sharvani is the energy that inspires even the God of Destruction (Sharva) towards 'Creation'."
            "Kalyani implies that every microscopic movement of the universe is ultimately for our 'Welfare'."
            "By bowing to 'Vriddhi' (Growth), we actively open the cosmic doors for 'Progress' in our life."
            "This verse covers both the Material and Spiritual heights achievable by a human being."
            "Prosperity achieved without toxic ego is perpetually stable, holy, and truly fulfilling."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 10,
        sanskrit = "दुर्गायै दुर्गपारायै सारायै सर्वकारिण्यै ।\nख्यात्यै तथैव कृष्णायै धूम्रायै सततं नमः ॥ १२ ॥",
        hindi = """
            (दुर्गा और धूम्रा): "दुर्गा (संकट हरने वाली) और दुर्गम बाधाओं से पार लगाने वाली देवी को हमारा नमस्कार है।"
            "सबकी मूल कारण (सारायै) और सब कुछ करने वाली (सर्वकारिण्यै) माता को प्रणाम है।"
            "प्रसिद्धि (ख्याति), कृष्ण रूप (गहनता) और धूम्रा (धुएं जैसा रहस्यमयी रूप) को हमारा सतत नमन है।"
            "दुर्गा वह 'किलर इंस्टिंक्ट' है जो हमारे अंदर के डर और बाधाओं को जड़ से उखाड़ देती है।"
            "'सारायै' का अर्थ है ब्रह्मांड का वह 'तत्व' जिसके बिना कुछ भी अस्तित्व में नहीं रह सकता।"
            "ख्याति (Fame) इंसान के अच्छे कर्मों की सुगन्ध है, जो देवी की कृपा से ही फैलती है।"
            "'कृष्णा' वह गहराई है जो हमें जीवन के रहस्यों को समझने में मदद करती है।"
            "'धूम्रा' (Smoky) वह रहस्यमयी माया है जिसे भेदना केवल ज्ञान (विवेक) से ही संभव है।"
            "यह श्लोक हमें सिखाता है कि जीवन के उजले और धुंधले—दोनों पक्षों में एक ही शक्ति काम कर रही है।"
            "जब हम 'सर्वकारिण्यै' को मान लेते हैं, तो हमारा 'कर्ता-भाव' (Doership) हमेशा के लिए खत्म हो जाता है।"
        """.trimIndent(),
        english = """
            (Durga and Dhumra): "Salutations to Durga (destroyer of crisis) and the one who helps cross impossible obstacles."
            "Bows to the Mother who is the core Essence (Sara) and the absolute Doer of everything (Sarvakarini)."
            "Continuous salutations to Khyati (Fame), Krishna (Deep Intensity), and Dhumra (the Smoky mysterious form)."
            "Durga is that 'Killer Instinct' which uproots all our internal fears and worldly barriers."
            "'Sara' means the absolute fundamental 'Element' without which nothing can mathematically exist."
            "Khyati (Fame) is the fragrance of a human's good deeds, spreading strictly through Her grace."
            "'Krishna' represents the profound Depth required to successfully understand the mysteries of life."
            "'Dhumra' (Smoky) symbolizes the mysterious veil of Maya that strictly requires Wisdom to pierce."
            "This verse teaches that in both the bright and the blurry aspects of life, a singular power operates."
            "By accepting Her as the 'Absolute Doer' (Sarvakarini), our false 'Doership' (Ego) dies forever."
        """.trimIndent()
    ),
        SaptshatiShloka(
            id = 11,
            sanskrit = "अतिसौम्यातिरौद्रायै नतास्तस्यै नमो नमः ।\nनमो जगत्प्रतिष्ठायै देव्यै कृत्यै नमो नमः ॥ १३ ॥",
            hindi = """
            (सौम्य और रौद्र): "जो देवी अत्यंत सुंदर (अतिसौम्य) और अत्यंत भयानक (अतिरौद्र) दोनों हैं, उन्हें हमारा प्रणाम है।"
            "जो इस संपूर्ण जगत की आधारशिला (प्रतिष्ठा) हैं, उन भगवती को हम बार-बार नमस्कार करते हैं।"
            "सृष्टि की रचना करने वाली 'कृति' (Action) के रूप में भी साक्षात् आप ही विराजमान हैं।"
            "यह श्लोक बताता है कि परमात्मा केवल 'लाइट' (Light) नहीं है, वह 'डार्कनेस' (Darkness) का भी स्वामी है।"
            "अतिसौम्य रूप हमें शांति देता है, जबकि अतिरौद्र रूप हमारे विकारों को डराकर नष्ट करता है।"
            "बिना 'प्रतिष्ठा' (Foundation) के कोई भी विचार या वस्तु टिक नहीं सकती; देवी ही वह ग्लोबल फोर्स है।"
            "इंसान के कर्म (कृति) भी तभी सफल होते हैं जब वह अपनी चेतना को देवी से जोड़ लेता है।"
            "सत्य के ये दोनों विपरीत रूप ही ब्रह्मांड को पूरी तरह से 'बैलेंस' (Balance) रखते हैं।"
            "जब हम दोनों रूपों को स्वीकार करते हैं, तो हमारे मन से 'पसंद-नापसंद' का द्वंद्व खत्म हो जाता है।"
            "देवी को 'कृति' कहना यह दर्शाता है कि हर छोटा-बड़ा कार्य अंततः उन्हीं की शक्ति से हो रहा है।"
        """.trimIndent(),
            english = """
            (Gentle and Fierce Forms): "We bow to the Goddess who is simultaneously extremely gentle and exceptionally terrifying."
            "Salutations to the Supreme Mother who serves as the unshakeable foundation of the entire universe."
            "Repeated bows to the Divine Energy who manifests as 'Kriti', the primordial power of all action."
            "This verse reveals that the Divine is the Master of both the creative light and destructive shadows."
            "Her gentle form grants us inner peace, while Her fierce form strikes terror into our internal vices."
            "Without a solid 'Foundation' (Pratishtha), zero thoughts or physical objects can maintain their existence."
            "Human actions (Kriti) achieve true success only when they are aligned with the source of Cosmic Energy."
            "These two polar opposite formats are essential for maintaining the absolute equilibrium of the cosmos."
            "By accepting both beauty and terror, a practitioner transcends the mental conflict of likes and dislikes."
            "Addressing Her as 'Kriti' proves that every movement in the world is powered by Her singular force."
        """.trimIndent()
        ),
SaptshatiShloka(
id = 12,
sanskrit = "या देवी सर्वभूतेषु विष्णुमायेति शब्दिता ।\nनमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ १४-१६ ॥",
hindi = """
            (विष्णुमाया रूप): "जो देवी सभी प्राणियों में 'विष्णुमाया' के नाम से जानी जाती हैं, उन्हें मेरा नमस्कार है।"
            "उन भगवती को बार-बार नमस्कार है, उन्हें कोटि-कोटि प्रणाम है।"
            "(यह मंत्र तीन बार 'नमस्तस्यै' कहकर पूर्ण समर्पण को दर्शाता है)।"
            "विष्णुमाया वह शक्ति है जो हमें इस संसार के मोह-जाल (Illusion) में बांधकर रखती है।"
            "जब तक हम माया के वश में हैं, हमें सत्य दिखाई नहीं देता और हम ईगो में फंसे रहते हैं।"
            "परंतु यही माया जब प्रसन्न होती है, तो वही हमें ज्ञान का मार्ग भी दिखाती है।"
            "सभी प्राणियों (सर्वभूतेषु) में होने का अर्थ है कि यह भ्रम हर जीवित कोशिका का हिस्सा है।"
            "प्रणाम करना (Namastasye) अहंकार को मिटाने और उस मायावी शक्ति को स्वीकार करने की प्रक्रिया है।"
            "बिना इस शक्ति के स्वीकार के, कोई भी इंसान वास्तविकता (Reality) को कभी नहीं समझ सकता।"
            "यह मंत्र साधक को अपनी मानसिक सीमाओं को पहचान कर उनसे ऊपर उठने की प्रेरणा देता है।"
        """.trimIndent(),
english = """
            (The Form of Illusion): "To the Goddess who is present in all living beings as 'Vishnumaya', I offer my salutations."
            "I bow to Her again and again, offering my absolute and unconditional reverence to the Supreme Mother."
            "The triple repetition of 'Namastasye' symbolizes total surrender of the body, mind, and soul."
            "Vishnumaya is the cosmic energy that keeps us bound within the intricate web of worldly Illusion."
            "As long as we are under Her spell, we remain blind to Truth and trapped within the ego."
            "Yet, when this same energy is pleased, She becomes the catalyst that unlocks the gates of Wisdom."
            "Being present in 'All Beings' implies that this deceptive power is woven into every biological cell."
            "The act of bowing is a psychological exercise to dissolve arrogance and acknowledge the Cosmic Play."
            "Without recognizing the veil of Maya, a human can never truly perceive the underlying Ultimate Reality."
            "This mantra inspires the practitioner to identify mental limitations and successfully transcend them forever."
        """.trimIndent()
),
SaptshatiShloka(
id = 13,
sanskrit = "या देवी सर्वभूतेषु चेतनेत्यभिधीयते ।\nनमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ १७-१९ ॥",
hindi = """
            (चेतना रूप): "जो देवी समस्त प्राणियों में 'चेतना' (Consciousness) के रूप में स्थित हैं, उन्हें मेरा नमस्कार है।"
            "उन आदि-शक्ति को बार-बार प्रणाम है, उन्हें निरंतर नमस्कार है।"
            "चेतना वह 'अवेयरनेस' है जिसके कारण हम जीवित होने का अनुभव करते हैं।"
            "बिना इस चेतना के, हमारा शरीर महज़ मिट्टी का एक ढेर और निर्जीव पदार्थ है।"
            "देवी ही वह 'ऑब्जर्वर' (Observer) हैं जो हमारे अंदर बैठकर दुनिया का अनुभव कर रही हैं।"
            "जब हम खुद को शरीर के बजाय इस चेतना से जोड़ते हैं, तो हम अमरता को प्राप्त होते हैं।"
            "यह शक्ति ही हमें सोचने, महसूस करने और निर्णय लेने की क्षमता प्रदान करती है।"
            "साधना का अर्थ है अपनी 'बिखरी हुई चेतना' को वापस समेट कर केंद्र में लाना।"
            "इस मंत्र का जाप करने से मानसिक एकाग्रता (Focus) और आत्म-बोध की शक्ति बढ़ती है।"
            "हम उस परम चेतना को नमन करते हैं जो हर पल हमारे भीतर जीवंत रूप में मौजूद है।"
        """.trimIndent(),
english = """
            (The Form of Consciousness): "To the Goddess who resides in all beings as 'Chetana' (Consciousness), I bow repeatedly."
            "Salutations to Her again and again; I offer my constant and deepest respect to the Divine Mother."
            "Chetana is the fundamental 'Awareness' that allows us to experience the phenomenon of being alive."
            "Without this divine spark of consciousness, the human body is merely a heap of inanimate matter."
            "The Goddess is the internal 'Observer' who experiences the world through our biological senses."
            "When we identify with this Consciousness rather than the physical body, we achieve spiritual immortality."
            "This energy grants us the essential capacity to think, feel, and make conscious life decisions."
            "Spiritual practice involves consolidating our 'Scattered Awareness' back into its central divine source."
            "Chanting this mantra enhances mental focus and strengthens the inner power of self-realization."
            "We revere that Supreme Consciousness which remains vibrantly alive within us at every single moment."
        """.trimIndent()
),
SaptshatiShloka(
id = 14,
sanskrit = "या देवी सर्वभूतेषु बुद्धिरूपेण संस्थिता ।\nनमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ २०-२२ ॥",
hindi = """
            (बुद्धि रूप): "जो देवी सभी प्राणियों में 'बुद्धि' (Intellect) के रूप में स्थित हैं, उन्हें मेरा नमस्कार है।"
            "उन ज्ञान-स्वरूपा माता को बार-बार प्रणाम है, उन्हें सदा नमस्कार है।"
            "बुद्धि वह 'डिस्क्रिमिनेशन' (Discrimination) है जो सही और गलत के बीच अंतर करना सिखाती है।"
            "जब हमारी बुद्धि सात्विक होती है, तो हम जीवन में सही फैसले लेते हैं और शांति पाते हैं।"
            "परंतु जब यही बुद्धि ईगो (Ego) से ढक जाती है, तो इंसान विनाश के मार्ग पर चल पड़ता है।"
            "देवी ही हमारे दिमाग की वह 'प्रोसेसिंग पावर' हैं जो सूचनाओं को ज्ञान में बदलती हैं।"
            "बुद्धि का शुद्ध होना ही 'एनलाइटनमेंट' (Enlightenment) की पहली सीढ़ी है।"
            "हम माता से प्रार्थना करते हैं कि वे हमारी बुद्धि को हमेशा 'सत्य' की ओर प्रेरित रखें।"
            "यह मंत्र पढ़ने से निर्णय लेने की क्षमता (Decision Making) और क्लैरिटी बढ़ती है।"
            "अहंकार बुद्धि को अंधा करता है, पर देवी की कृपा उसे फिर से दिव्य और चमकदार बनाती है।"
        """.trimIndent(),
english = """
            (The Form of Intellect): "To the Goddess who resides in all beings as 'Buddhi' (Intellect), I offer my salutations."
            "I bow to Her again and again, forever honoring the Mother who is the embodiment of Wisdom."
            "Buddhi is that sharp faculty of 'Discrimination' which enables us to distinguish truth from falsehood."
            "When our intellect is pure, we make righteous life decisions and achieve lasting internal peace."
            "However, when this same intellect is clouded by Ego, a human unknowingly chooses the path of ruin."
            "The Goddess is the 'Processing Power' of our brain that transforms raw data into meaningful wisdom."
            "The purification of the intellect is undeniably the first critical step toward absolute Enlightenment."
            "We pray that the Mother perpetually guides our intelligence toward the ultimate path of Truth."
            "Reciting this mantra improves decision-making capabilities and grants profound mental clarity."
            "Arrogance blinds the intellect, but the Goddess's grace restores its divine and luminous nature."
        """.trimIndent()
),
SaptshatiShloka(
id = 15,
sanskrit = "या देवी सर्वभूतेषु निद्रारूपेण संस्थिता ।\nनमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ २३-२५ ॥",
hindi = """
            (निद्रा रूप): "जो देवी समस्त प्राणियों में 'निद्रा' (Sleep) के रूप में स्थित हैं, उन्हें मेरा नमस्कार है।"
            "उन शांति-स्वरूपा माता को बार-बार प्रणाम है, उन्हें निरंतर नमस्कार है।"
            "निद्रा केवल थकान दूर करने का साधन नहीं, बल्कि 'अनकॉन्शियस' (Unconscious) से जुड़ने का पल है।"
            "नींद में हमारा अहंकार (Ego) अस्थायी रूप से मर जाता है और हम अपनी जड़ों से जुड़ते हैं।"
            "देवी ही वह शक्ति हैं जो गहरी नींद (Deep Sleep) में हमारे शरीर और मन को 'हील' (Heal) करती हैं।"
            "जो लोग सो नहीं पाते (Insomnia), उनके पास चेतना की इस 'शांति' का अभाव होता है।"
            "निद्रा हमें सिखाती है कि अंततः हमें अपनी सारी सक्रियता को 'शून्य' में विलीन करना है।"
            "यह मंत्र मन को शांत करने और तनाव (Stress) को कम करने के लिए अत्यंत प्रभावशाली है।"
            "देवी का निद्रा रूप वह 'कॉस्मिक रेस्ट' है जहाँ सारा ब्रह्मांड अपनी थकान मिटाता है।"
            "हम उस शक्ति को नमन करते हैं जो हमें हर रात परम विश्राम और नई ऊर्जा प्रदान करती है।"
        """.trimIndent(),
english = """
            (The Form of Sleep): "To the Goddess who resides in all beings as 'Nidra' (Sleep), I bow repeatedly."
            "Salutations to Her again and again; I offer my constant reverence to the Mother of Peace."
            "Sleep is zero mere tool for physical rest; it is the moment we reconnect with the Unconscious."
            "In deep sleep, our toxic Ego temporarily dissolves, allowing us to merge back into our root source."
            "The Goddess is that healing force who restores our body and mind during the hours of darkness."
            "Those suffering from sleeplessness essentially lack access to this specific peaceful format of Chetana."
            "Nidra teaches us that all worldly activity must ultimately dissolve back into the absolute Void."
            "This mantra is exceptionally effective for calming the agitated mind and reducing daily stress."
            "Her form as Sleep represents that 'Cosmic Rest' where the entire universe finds its total solace."
            "We bow to the power that grants us profound rest and recharges our existence every single night."
        """.trimIndent()
),
SaptshatiShloka(
id = 16,
sanskrit = "या देवी सर्वभूतेषु क्षुधारूपेण संस्थिता ।\nनमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ २६-२८ ॥",
hindi = """
            (क्षुधा रूप): "जो देवी सभी प्राणियों में 'क्षुधा' (Hunger) के रूप में स्थित हैं, उन्हें मेरा नमस्कार है।"
            "उन आदि-शक्ति को बार-बार प्रणाम है, उन्हें निरंतर नमस्कार है।"
            "क्षुधा केवल पेट की भूख नहीं, बल्कि 'कुछ पाने की तड़प' (Desire) का भी प्रतीक है।"
            "यही वह 'ड्राइविंग फोर्स' (Driving Force) है जो हमें कर्म करने और जीवित रहने के लिए प्रेरित करती है।"
            "बिना भूख के कोई भी प्राणी विकास (Evolution) की दिशा में आगे नहीं बढ़ सकता।"
            "देवी ही हमारे अंदर वह 'अग्नि' हैं जो निरंतर नई ऊर्जा और अनुभवों की मांग करती है।"
            "जब यह भूख ज्ञान की होती है, तो यह 'जिज्ञासा' बनकर मोक्ष का मार्ग प्रशस्त करती है।"
            "परंतु जब यह केवल वासना की होती है, तो यह इंसान को दुखों के जाल में फँसा देती है।"
            "हम माता को भूख के रूप में पूजते हैं क्योंकि वह हमें 'एक्सपेंशन' (Expansion) के लिए तैयार करती हैं।"
            "यह मंत्र हमारी इच्छाओं को शुद्ध करने और उन्हें सही दिशा देने में मदद करता है।"
        """.trimIndent(),
english = """
            (The Form of Hunger): "To the Goddess who resides in all beings as 'Kshudha' (Hunger), I offer my salutations."
            "I bow to Her again and again, forever honoring the fundamental driving force of existence."
            "Hunger is zero mere physical requirement; it symbolizes the deep internal 'Desire' to achieve."
            "This is the essential 'Driving Force' that motivates every creature to work and survive."
            "Without the presence of hunger, absolutely no living being could move toward Evolution."
            "The Goddess is that internal 'Fire' which continuously demands new energy and life experiences."
            "When this hunger targets knowledge, it becomes 'Curiosity' leading directly toward Liberation."
            "However, if it targets only sensory lust, it traps the human within an endless web of sorrow."
            "We worship Her as Hunger because She prepares our core consciousness for infinite Expansion."
            "This mantra helps in purifying our desires and successfully directing them toward righteous goals."
        """.trimIndent()
),
SaptshatiShloka(
id = 17,
sanskrit = "या देवी सर्वभूतेषु छायारूपेण संस्थिता ।\nनमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ २९-३१ ॥",
hindi = """
            (छाया रूप): "जो देवी समस्त प्राणियों में 'छाया' (Shadow/Reflection) के रूप में स्थित हैं, उन्हें मेरा नमस्कार है।"
            "उन जगन्माता को बार-बार प्रणाम है, उन्हें कोटि-कोटि नमस्कार है।"
            "छाया वह 'प्रतिबिंब' है जो असली वस्तु के बिना अस्तित्व में नहीं रह सकती।"
            "यह संसार और हमारा अहंकार उस परम सत्य की महज़ एक 'छाया' (Reflection) मात्र है।"
            "देवी ही वह प्रकाश हैं जिससे यह छाया पैदा होती है, और वही इस छाया का आधार भी हैं।"
            "छाया का अर्थ 'प्रोटेक्शन' (Protection) भी है—माता की कृपा हमें दुनिया की धूप से बचाती है।"
            "जैसे परछाई हमेशा हमारे साथ रहती है, वैसे ही ईश्वरीय शक्ति हमसे कभी अलग नहीं होती।"
            "हम अक्सर छाया (Maya) को ही असली समझ लेते हैं, यही हमारे अज्ञान का सबसे बड़ा कारण है।"
            "इस मंत्र का ध्यान करने से इंसान को 'असली और नकली' के बीच का भेद समझ आने लगता है।"
            "हम उस छाया-स्वरूपा देवी को नमन करते हैं जो हर पल हमारे साथ एक अदृश्य साथी की तरह हैं।"
        """.trimIndent(),
english = """
            (The Form of Shadow): "To the Goddess who resides in all beings as 'Chhaya' (Shadow/Reflection), I bow repeatedly."
            "Salutations to Her again and again; I offer my deepest respect to the Mother of all Reflections."
            "A shadow is a 'Reflection' that possesses zero independent existence without the original object."
            "This entire world and our personal Ego are merely 'Shadows' of the ultimate Supreme Truth."
            "The Goddess is the Light that generates this shadow and the foundation that supports its being."
            "Chhaya also signifies 'Protection'—Her divine grace shields us from the harsh heat of life's struggles."
            "Just as a shadow never leaves its source, the Divine Power is never separated from us."
            "We frequently mistake the shadow (Maya) for reality, which is the root cause of our ignorance."
            "Meditating on this mantra allows a human to distinguish between the 'Real' and the 'Illusory'."
            "We revere the Shadow-form Goddess who stays with us perpetually like an invisible cosmic companion."
        """.trimIndent()
),
SaptshatiShloka(
id = 18,
sanskrit = "या देवी सर्वभूतेषु शक्तिरूपेण संस्थिता ।\nनमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ ३२-३४ ॥",
hindi = """
            (शक्ति रूप): "जो देवी सभी प्राणियों में 'शक्ति' (Power/Energy) के रूप में स्थित हैं, उन्हें मेरा नमस्कार है।"
            "उन सामर्थ्य-स्वरूपा माता को बार-बार प्रणाम है, उन्हें सदा नमस्कार है।"
            "शक्ति वह 'पोटेंशियल' (Potential) है जो किसी भी काम को करने के लिए ज़रूरी है।"
            "ब्रह्मांड की हर हरकत, अणु (Atom) से लेकर आकाशगंगा तक, इसी शक्ति का परिणाम है।"
            "हमारे अंदर की इच्छा-शक्ति, क्रिया-शक्ति और ज्ञान-शक्ति—ये तीनों देवी के ही रूप हैं।"
            "बिना शक्ति के शिव (शुद्ध चेतना) भी 'शव' (Dead) के समान माने जाते हैं।"
            "यह मंत्र इंसान के आत्म-विश्वास (Self-confidence) और आंतरिक बल को जाग्रत करने वाला है।"
            "जब हम कमज़ोर महसूस करते हैं, तो यह मंत्र हमें सीधे 'सोर्स' से ऊर्जा दिलाने में मदद करता है।"
            "शक्ति का सही उपयोग ही इंसान को पशु से देवता की ओर ले जा सकता है।"
            "हम उस अनंत ऊर्जा को नमन करते हैं जो पूरे ब्रह्मांड का संचालन कर रही है।"
        """.trimIndent(),
english = """
            (The Form of Power): "To the Goddess who resides in all beings as 'Shakti' (Power/Energy), I offer my salutations."
            "I bow to Her again and again, honoring the Mother who is the absolute embodiment of Capacity."
            "Shakti is the essential 'Potential' required to successfully execute any physical or mental task."
            "Every movement in the cosmos, from the smallest Atom to the largest Galaxy, is a result of Her."
            "The powers of Will, Action, and Knowledge within us are strictly different formats of this Goddess."
            "Without Shakti, even Shiva (Pure Consciousness) is considered mathematically equivalent to a corpse."
            "This mantra is designed to awaken a human's Self-confidence and deep internal spiritual strength."
            "Whenever we feel weak, this chant helps us pull raw energy directly from the Cosmic Source."
            "The righteous utilization of power is what elevates a human from animalistic to divine nature."
            "We bow to the infinite Energy that perpetually governs and animates the entire universe."
        """.trimIndent()
),
SaptshatiShloka(
id = 19,
sanskrit = "या देवी सर्वभूतेषु तृष्णारूपेण संस्थिता ।\nनमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ ३५-३७ ॥",
hindi = """
            (तृष्णा रूप): "जो देवी समस्त प्राणियों में 'तृष्णा' (Thirst/Craving) के रूप में स्थित हैं, उन्हें मेरा नमस्कार है।"
            "उन आदि-शक्ति को बार-बार प्रणाम है, उन्हें निरंतर नमस्कार है।"
            "तृष्णा वह 'प्यास' है जो हमें कभी संतुष्ट नहीं होने देती और आगे दौड़ने पर मजबूर करती है।"
            "यह विकास की जननी भी है और दुखों का कारण भी, यह सब हमारी दिशा पर निर्भर करता है।"
            "अगर हमें ईश्वर को पाने की तृष्णा है, तो यही प्यास हमें मोक्ष तक ले जाएगी।"
            "परंतु अगर यह प्यास केवल दुनियावी भोगों की है, तो यह हमें कभी न खत्म होने वाली बेचैनी देगी।"
            "देवी ही वह 'अधूरीपन' का एहसास हैं जो हमें पूर्णता (Perfection) की तलाश करने के लिए प्रेरित करता है।"
            "साधना का उद्देश्य तृष्णा को मारना नहीं, बल्कि उसे 'पवित्र' (Purify) करना है।"
            "इस मंत्र का जाप करने से इंसान को अपनी अनियंत्रित इच्छाओं पर नियंत्रण पाने में मदद मिलती है।"
            "हम उस शक्ति को नमन करते हैं जो हमारी आत्मा को निरंतर कुछ श्रेष्ठ खोजने के लिए उकसाती है।"
        """.trimIndent(),
english = """
            (The Form of Thirst): "To the Goddess who resides in all beings as 'Trishna' (Thirst/Cravings), I bow repeatedly."
            "Salutations to Her again and again; I offer my constant reverence to the Mother of Desires."
            "Trishna is that internal 'Thirst' which prevents satisfaction and forces us to keep running forward."
            "It is simultaneously the mother of progress and the cause of sorrow, depending on our direction."
            "If we possess a thirst for the Divine, this specific craving will lead us toward absolute Liberation."
            "However, if this thirst is for temporary worldly pleasures, it grants only perpetual restlessness."
            "The Goddess is that sense of 'Incompleteness' which motivates us to seek absolute cosmic Perfection."
            "The goal of spiritual practice is zero destruction of thirst, but rather its total Purification."
            "Chanting this mantra assists a human in gaining control over impulsive and uncontrolled desires."
            "We revere the power that continuously prompts our soul to search for something truly superior."
        """.trimIndent()
),
SaptshatiShloka(
id = 20,
sanskrit = "या देवी सर्वभूतेषु क्षान्तिरूपेण संस्थिता ।\nनमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ ३८-४० ॥",
hindi = """
            (क्षान्ति रूप): "जो देवी सभी प्राणियों में 'क्षान्ति' (Forgiveness/Patience) के रूप में स्थित हैं, उन्हें मेरा नमस्कार है।"
            "उन शांति-स्वरूपा माता को बार-बार प्रणाम है, उन्हें सदा नमस्कार है।"
            "क्षान्ति वह 'क्षमा' है जो इंसान को गुस्से और नफरत के ज़हर से बचाती है।"
            "यह वह 'धैर्य' है जो हमें जीवन की मुश्किल परिस्थितियों में टूटने नहीं देता।"
            "देवी ही वह 'कूलिंग इफेक्ट' (Cooling Effect) हैं जो हमारे उत्तेजित मन को शांत करती हैं।"
            "क्षमा करना कमज़ोरी नहीं, बल्कि दुनिया की सबसे बड़ी और कठिन 'शक्ति' है।"
            "जब हम दूसरों को माफ करते हैं, तो हम खुद को उनके प्रति पाल रखी नफरत से आज़ाद करते हैं।"
            "यह मंत्र हमारे स्वभाव में कोमलता और सहनशीलता (Tolerance) विकसित करने के लिए अद्भुत है।"
            "सच्चा साधक वही है जिसके पास असीम ज्ञान के साथ असीम 'धैर्य' भी हो।"
            "हम उस करुणामयी शक्ति को नमन करते हैं जो हमें एक बेहतर और शांत इंसान बनाती है।"
        """.trimIndent(),
english = """
            (The Form of Forgiveness): "To the Goddess who resides in all beings as 'Kshanti' (Forgiveness/Patience), I offer my salutations."
            "I bow to Her again and again, forever honoring the Mother who is the embodiment of Patience."
            "Kshanti is the power of 'Forgiveness' that protects a human from the toxic poison of anger."
            "It is the internal 'Patience' that prevents us from breaking during extremely difficult life situations."
            "The Goddess is that divine 'Cooling Effect' which successfully pacifies our agitated mental state."
            "Practicing forgiveness is zero weakness; it is the absolute greatest and most difficult human power."
            "When we forgive others, we essentially liberate ourselves from the hatred we held against them."
            "This mantra is miraculous for developing gentleness and unshakeable Tolerance within one's nature."
            "A true spiritual practitioner is defined by possessing both infinite wisdom and infinite 'Patience'."
            "We bow to the compassionate energy that transforms us into superior and peaceful human beings."
        """.trimIndent()
),
SaptshatiShloka(
id = 21,
sanskrit = "या देवी सर्वभूतेषु जातिरूपेण संस्थिता ।\nनमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ ४१-४३ ॥",
hindi = """
            (जाति रूप): "जो देवी सभी प्राणियों में 'जाति' (Lineage/Origin) के रूप में स्थित हैं, उन्हें मेरा नमस्कार है।"
            "उन आदि-शक्ति को बार-बार प्रणाम है, उन्हें निरंतर नमस्कार है।"
            "जाति यहाँ सामाजिक भेदभाव नहीं, बल्कि हमारे 'मूल स्वभाव' (Genetic/Soul Origin) का प्रतीक है।"
            "हर जीव अपने साथ एक विशेष गुण और पहचान (Identity) लेकर पैदा होता है, वह देवी ही हैं।"
            "यह वह 'कलेक्शन' (Collection) है जो हमें एक विशेष प्रजाति या समूह का हिस्सा बनाता है।"
            "देवी ही वह धागा हैं जो एक ही तरह के जीवों को एक सूत्र में पिरोकर रखती हैं।"
            "इंसान की 'जड़ें' (Roots) और उसका गौरव इसी शक्ति से परिभाषित होता है।"
            "जब हम अपनी जाति (असली पहचान) को पहचानते हैं, तो हम अपनी शक्तियों का सही उपयोग कर पाते हैं।"
            "यह मंत्र हमें अपनी जड़ों के प्रति कृतज्ञ रहने और अपनी विशिष्टता को समझने की प्रेरणा देता है।"
            "हम उस शक्ति को नमन करते हैं जो हर जीव को उसकी अनूठी पहचान प्रदान करती है।"
        """.trimIndent(),
english = """
            (The Form of Origin): "To the Goddess who resides in all beings as 'Jati' (Lineage/Origin), I bow repeatedly."
            "Salutations to Her again and again; I offer my constant respect to the Mother of all Lineages."
            "Jati here is zero social discrimination; it symbolizes our 'Original Nature' and Soul Origin."
            "Every creature is born with a specific trait and identity, which is purely a manifestation of the Goddess."
            "This represents the 'Collection' of traits that makes us part of a particular species or group."
            "The Goddess is the invisible thread that binds similar living beings into a unified cosmic pattern."
            "A human's 'Roots' and his inherent pride are strictly defined and supported by this energy."
            "When we successfully recognize our true Jati (Authentic Identity), we can utilize our powers effectively."
            "This mantra inspires us to remain grateful to our roots and understand our unique individuality."
            "We bow to the power that grants every living creature its distinct and unique cosmic identity."
        """.trimIndent()
),
SaptshatiShloka(
id = 22,
sanskrit = "या देवी सर्वभूतेषु लज्जारूपेण संस्थिता ।\nनमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ ४४-४६ ॥",
hindi = """
            (लज्जा रूप): "जो देवी समस्त प्राणियों में 'लज्जा' (Modesty/Conscience) के रूप में स्थित हैं, उन्हें मेरा नमस्कार है।"
            "उन मर्यादित स्वरूपा माता को बार-बार प्रणाम है, उन्हें सदा नमस्कार है।"
            "लज्जा कमज़ोरी नहीं, बल्कि वह 'आंतरिक बाउंड्री' है जो हमें गलत काम करने से रोकती है।"
            "यह हमारी 'अंतरात्मा की आवाज़' (Conscience) है जो हमें बताती है कि क्या सही है और क्या गलत।"
            "जिस इंसान के अंदर लज्जा मर जाती है, वह पशु से भी बदतर व्यवहार करने लगता है।"
            "देवी ही वह 'चेक एंड बैलेंस' (Check and Balance) हैं जो हमारे व्यवहार को सभ्य और पवित्र बनाती हैं।"
            "यह शक्ति हमें अपनी मर्यादा में रहने और दूसरों का सम्मान करने की सीख देती है।"
            "साधना के मार्ग पर 'नैतिकता' (Ethics) बनाए रखने के लिए यह ऊर्जा अत्यंत आवश्यक है।"
            "इस मंत्र का जाप करने से मन में शुद्ध विचार और चरित्र की मजबूती (Strength of character) आती है।"
            "हम उस लज्जा-स्वरूपा देवी को नमन करते हैं जो हमें एक संस्कारी और मर्यादित जीवन जीने की शक्ति देती हैं।"
        """.trimIndent(),
english = """
            (The Form of Modesty): "To the Goddess who resides in all beings as 'Lajja' (Modesty/Conscience), I offer my salutations."
            "I bow to Her again and again, honoring the Mother who is the embodiment of Graceful Boundaries."
            "Lajja is zero weakness; it is the 'Internal Boundary' that prevents us from committing unethical acts."
            "It represents our 'Conscience'—the subtle voice that accurately guides us between right and wrong."
            "The moment modesty dies within a human, he begins to behave in a manner worse than animals."
            "The Goddess is that 'Check and Balance' system that keeps our social behavior civil and holy."
            "This energy teaches us to strictly remain within our limits and respect the dignity of others."
            "To maintain 'Ethics' on the spiritual path, the presence of this energy is mathematically essential."
            "Reciting this mantra generates pure thoughts and enhances the absolute Strength of one's character."
            "We bow to the Modesty-form Goddess who empowers us to live a cultured and dignified life."
        """.trimIndent()
),
SaptshatiShloka(
id = 23,
sanskrit = "या देवी सर्वभूतेषु शान्तिरूपेण संस्थिता ।\nनमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ ४७-४९ ॥",
hindi = """
            (शान्ति रूप): "जो देवी सभी प्राणियों में 'शान्ति' (Peace) के रूप में स्थित हैं, उन्हें मेरा नमस्कार है।"
            "उन परम शांत स्वरूपा माता को बार-बार प्रणाम है, उन्हें निरंतर नमस्कार है।"
            "शान्ति वह 'स्थिरता' है जहाँ मन के सारे तूफान थम जाते हैं और केवल आनंद बचता है।"
            "यह वह अवस्था है जहाँ न कोई डर है, न कोई इच्छा और न ही कोई तनाव (Stress)।"
            "देवी ही वह 'साइलेंस' (Silence) हैं जो हमारे शोर भरे दिमाग के पीछे हमेशा मौजूद रहती हैं।"
            "असली शांति बाहर की परिस्थितियों में नहीं, बल्कि अंदर की चेतना के संतुलन में है।"
            "जब हम इस मंत्र का जाप करते हैं, तो हमारे दिमाग की एंग्जायटी और हलचल कम होने लगती है।"
            "शान्ति ही वह उपजाऊ ज़मीन है जहाँ ज्ञान का बीज अंकुरित (Germinate) हो सकता है।"
            "बिना इस आंतरिक शान्ति के, दुनिया की सारी सफलताएं और पैसा महज़ एक बोझ की तरह हैं।"
            "हम उस शान्ति-स्वरूपा शक्ति को नमन करते हैं जो हमारे जीवन को सुखद और संतुलित बनाती है।"
        """.trimIndent(),
english = """
            (The Form of Peace): "To the Goddess who resides in all beings as 'Shanti' (Peace), I bow repeatedly."
            "Salutations to Her again and again; I offer my deepest respect to the Mother of infinite Stillness."
            "Peace is that specific 'Stability' where all mental storms subside and only pure Bliss remains."
            "It is a psychological state characterized by zero fear, zero obsessive desire, and zero stress."
            "The Goddess is the eternal 'Silence' that perpetually exists behind the noise of our thinking mind."
            "Genuine peace is zero dependent on external situations; it exists strictly in internal balance."
            "When we chant this mantra, the anxiety and chaotic vibrations of our brain begin to settle."
            "Peace serves as the fertile ground where the seeds of Wisdom can successfully Germinate."
            "Without this internal tranquility, all worldly success and wealth feel like an exhausting burden."
            "We bow to the Peace-form Energy that makes our existence pleasant, harmonious, and balanced."
        """.trimIndent()
),
SaptshatiShloka(
id = 24,
sanskrit = "या देवी सर्वभूतेषु श्रद्धारूपेण संस्थिता ।\nनमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ ५०-५२ ॥",
hindi = """
            (श्रद्धा रूप): "जो देवी समस्त प्राणियों में 'श्रद्धा' (Faith/Devotion) के रूप में स्थित हैं, उन्हें मेरा नमस्कार है।"
            "उन अटूट विश्वास स्वरूपा माता को बार-बार प्रणाम है, उन्हें सदा नमस्कार है।"
            "श्रद्धा वह 'भरोसा' है जो हमें नामुमकिन को मुमकिन करने की हिम्मत देता है।"
            "बिना श्रद्धा के कोई भी साधना, रिश्ता या काम कभी सफल नहीं हो सकता।"
            "देवी ही वह 'इनविजिबल सपोर्ट' हैं जो हमें गिरने पर फिर से खड़ा होने की प्रेरणा देती हैं।"
            "श्रद्धा का अर्थ आँख बंद करके मानना नहीं, बल्कि उस परम सत्य को दिल से महसूस करना है।"
            "जब हमारी श्रद्धा डगमगाती है, तो हमारा पूरा जीवन अस्थिर (Unstable) हो जाता है।"
            "यह मंत्र हमारे आत्मविश्वास को बढ़ाने और ईश्वर के प्रति प्रेम को गहरा करने के लिए है।"
            "श्रद्धा ही वह शक्ति है जो 'ईगो' (Logic) को पार करके 'लव' (Miracle) तक ले जाती है।"
            "हम उस श्रद्धा-स्वरूपा भगवती को नमन करते हैं जो हमारे जीवन की सबसे बड़ी ताकत हैं।"
        """.trimIndent(),
english = """
            (The Form of Faith): "To the Goddess who resides in all beings as 'Shraddha' (Faith/Devotion), I offer my salutations."
            "I bow to Her again and again, forever honoring the Mother who is the embodiment of unshakeable Trust."
            "Shraddha is the 'Faith' that grants us the courage to achieve what seems mathematically impossible."
            "Without faith, absolutely zero spiritual practice, relationship, or task can ever be successful."
            "The Goddess is that 'Invisible Support' who inspires us to stand up again after every failure."
            "Faith does not mean blind belief; it means deeply feeling the Ultimate Truth with one's heart."
            "The moment our faith wavers, our entire life becomes psychologically unstable and chaotic."
            "This mantra is utilized to boost self-confidence and deepen one's pure love toward the Divine."
            "Shraddha is the power that transcends narrow Logic (Ego) to reach the realm of Miracles (Love)."
            "We bow to the Faith-form Goddess who is unconditionally the absolute greatest strength of our lives."
        """.trimIndent()
),
SaptshatiShloka(
id = 25,
sanskrit = "या देवी सर्वभूतेषु कान्तिरूपेण संस्थिता ।\nनमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ ५३-५५ ॥",
hindi = """
            (कान्ति रूप): "जो देवी सभी प्राणियों में 'कान्ति' (Radiance/Beauty) के रूप में स्थित हैं, उन्हें मेरा नमस्कार है।"
            "उन प्रकाश-स्वरूपा माता को बार-बार प्रणाम है, उन्हें निरंतर नमस्कार है।"
            "कान्ति वह 'चमक' है जो केवल चेहरे पर नहीं, बल्कि एक शुद्ध चरित्र (Character) से पैदा होती है।"
            "जब इंसान का मन साफ़ होता है, तो उसकी आँखों और व्यक्तित्व में एक अलग ही आकर्षण (Aura) आ जाता है।"
            "देवी ही वह 'नूर' हैं जो हर जीव के भीतर उसकी दिव्यता को प्रकट करती हैं।"
            "यह चमक सुंदरता से कहीं ज़्यादा 'पवित्रता' (Purity) का परिचय देती है।"
            "कान्ति का अर्थ है अपने अंदर के अंधेरे को मिटाकर प्रकाश को बाहर आने देना।"
            "यह मंत्र व्यक्तित्व के विकास (Personality Development) और ओज बढ़ाने के लिए बहुत शक्तिशाली है।"
            "जिसके पास देवी की कान्ति है, उसके पास दुनिया की सबसे बड़ी और स्थायी सुंदरता है।"
            "हम उस दीप्तिमान शक्ति को नमन करते हैं जो हमें अंदर और बाहर दोनों तरफ से चमकदार बनाती है।"
        """.trimIndent(),
english = """
            (The Form of Radiance): "To the Goddess who resides in all beings as 'Kanti' (Radiance/Beauty), I bow repeatedly."
            "Salutations to Her again and again; I offer my constant respect to the Mother of Divine Glow."
            "Kanti is the 'Radiance' that originates not just from the face, but from a perfectly pure Character."
            "When a human's mind is clean, his eyes and entire personality radiate a unique and powerful Aura."
            "The Goddess is the internal 'Light' that reveals the divinity hidden within every living creature."
            "This glow introduces 'Purity' to the world rather than just superficial physical attractiveness."
            "Radiance implies destroying one's internal darkness to allow the inner light to shine outward."
            "This mantra is highly effective for personality development and enhancing one's spiritual magnetism."
            "Whoever possesses the grace of Kanti, successfully holds the most permanent beauty in existence."
            "We revere the Luminous Power that makes us brilliant and shining both internally and externally."
        """.trimIndent()
),
    SaptshatiShloka(
        id = 26,
        sanskrit = "या देवी सर्वभूतेषु लक्ष्मीरूपेण संस्थिता ।\nनमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ ५६-५८ ॥",
        hindi = """
            (लक्ष्मी रूप): "जो देवी सभी प्राणियों में 'लक्ष्मी' (Prosperity/Grace) के रूप में स्थित हैं, उन्हें मेरा नमस्कार है।"
            "उन ऐश्वर्य-स्वरूपा माता को बार-बार प्रणाम है, उन्हें सदा नमस्कार है।"
            "लक्ष्मी यहाँ केवल धन-दौलत नहीं, बल्कि जीवन की 'समृद्धि' और 'गरिमा' का प्रतीक है।"
            "जब हमारे जीवन में ग्रेस (Grace) और शुभता आती है, तो वह देवी का ही रूप होता है।"
            "देवी ही वह शक्ति हैं जो हमारे प्रयासों को भौतिक और आध्यात्मिक सफलता में बदलती हैं।"
            "सच्ची लक्ष्मी वह है जो इंसान को उदार (Generous) बनाती है, न कि लालची।"
            "यह मंत्र दरिद्रता और मानसिक कंगाली को दूर करने के लिए अत्यंत प्रभावशाली है।"
            "जिस पर लक्ष्मी की कृपा होती है, उसका व्यक्तित्व स्वतः ही आकर्षक और प्रभावशाली हो जाता है।"
            "हम उस शक्ति को नमन करते हैं जो हमारे जीवन को अभावों से मुक्त कर पूर्णता प्रदान करती है।"
            "लक्ष्मी रूप में देवी हमें सिखाती हैं कि धन का सही उपयोग ही मोक्ष का मार्ग प्रशस्त करता है।"
        """.trimIndent(),
        english = """
            (The Form of Lakshmi): "To the Goddess who resides in all beings as 'Lakshmi' (Prosperity/Grace), I offer my salutations."
            "I bow to Her again and again, forever honoring the Mother who is the absolute embodiment of Abundance."
            "Lakshmi here is zero mere physical currency; She symbolizes the 'Grace' and 'Dignity' of human life."
            "Whenever auspiciousness and beauty manifest in our existence, it is strictly a reflection of the Goddess."
            "The Goddess is the singular energy that transforms human labor into concrete material and spiritual success."
            "True Lakshmi is that which makes a human generous and philanthropic rather than narrow-minded or greedy."
            "This mantra is exceptionally powerful for eradicating both financial poverty and the 'Poverty of Thought'."
            "Whoever receives the grace of Lakshmi, their personality automatically becomes magnetic and highly influential."
            "We bow to the power that liberates our life from scarcity and grants us absolute cosmic fulfillment."
            "As Lakshmi, the Mother teaches us that the righteous utilization of wealth leads directly to spiritual freedom."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 27,
        sanskrit = "या देवी सर्वभूतेषु वृत्तिरूपेण संस्थिता ।\nनमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ ५९-६१ ॥",
        hindi = """
            (वृत्ति रूप): "जो देवी समस्त प्राणियों में 'वृत्ति' (Occupation/Mental Tendency) के रूप में स्थित हैं, उन्हें मेरा नमस्कार है।"
            "उन आदि-शक्ति को बार-बार प्रणाम है, उन्हें निरंतर नमस्कार है।"
            "वृत्ति वह 'आजीविका' है जिससे हम अपना जीवन चलाते हैं और वह 'स्वभाव' भी है जिससे हम सोचते हैं।"
            "हमारे काम करने का तरीका और हमारी मानसिक प्रवृत्तियां—ये दोनों ही देवी के रूप हैं।"
            "देवी ही वह प्रेरणा हैं जो हमें अपने लक्ष्यों की ओर बढ़ने और कर्म करने की शक्ति देती हैं।"
            "जब हमारी वृत्ति शुद्ध होती है, तो हमारा काम ही हमारी 'पूजा' (Worship) बन जाता है।"
            "गलत आदतों और नकारात्मक सोच को बदलना ही 'वृत्ति का शोधन' करना कहलाता है।"
            "यह मंत्र करियर में स्पष्टता लाने और मानसिक भटकाव को कम करने के लिए बहुत उपयोगी है।"
            "हम उस शक्ति को नमन करते हैं जो हमें सही कर्म और सही दिशा चुनने में मदद करती है।"
            "वृत्ति रूप में देवी हमें सिखाती हैं कि कर्म ही पूजा है और नियत ही सफलता का आधार है।"
        """.trimIndent(),
        english = """
            (The Form of Occupation): "To the Goddess who resides in all beings as 'Vritti' (Tendency/Occupation), I bow repeatedly."
            "Salutations to Her again and again; I offer my constant respect to the Mother of all Actions."
            "Vritti symbolizes the 'Livelihood' through which we survive and the 'Mental Tendencies' through which we function."
            "The specific manner in which we work and our underlying psychological habits are strictly different formats of the Goddess."
            "The Goddess is the internal inspiration that empowers us to move toward our goals and execute our duties."
            "When our Vritti is purified and selfless, our daily work systematically transforms into a form of divine Worship."
            "Modifying negative habits and toxic thought patterns is what masters define as the 'Refining of Vritti'."
            "This mantra is highly effective for gaining career clarity and reducing impulsive mental distractions."
            "We bow to the power that assists us in choosing the righteous path and the correct direction in life."
            "As Vritti, the Mother teaches that Action is Prayer and pure Intention is the unshakeable foundation of success."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 28,
        sanskrit = "या देवी सर्वभूतेषु स्मृतिरूपेण संस्थिता ।\nनमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ ६२-६४ ॥",
        hindi = """
            (स्मृति रूप): "जो देवी सभी प्राणियों में 'स्मृति' (Memory) के रूप में स्थित हैं, उन्हें मेरा नमस्कार है।"
            "उन ज्ञान-स्वरूपा माता को बार-बार प्रणाम है, उन्हें सदा नमस्कार है।"
            "स्मृति वह 'याददाश्त' है जो हमें अपने अतीत के अनुभवों से सीखने और आगे बढ़ने में मदद करती है।"
            "बिना स्मृति के, इंसान न तो भाषा सीख सकता है और न ही अपनी पहचान (Identity) बना सकता है।"
            "देवी ही हमारे दिमाग की वह 'लाइब्रेरी' हैं जहाँ सारा ब्रह्मांडीय ज्ञान सुरक्षित रहता है।"
            "जब हम अपने असली स्वरूप (Self) को भूल जाते हैं, तो देवी ही हमें 'स्मरण' (Remembrance) कराती हैं।"
            "बुरी यादों (Trauma) को मिटाना और अच्छी सीख को संजोना ही स्मृति की असली शक्ति है।"
            "यह मंत्र याददाश्त बढ़ाने और मानसिक क्लैरिटी के लिए विद्यार्थियों और साधकों के लिए श्रेष्ठ है।"
            "हम उस शक्ति को नमन करते हैं जो हमें सत्य को याद रखने और भ्रम को भुलाने की क्षमता देती है।"
            "स्मृति रूप में देवी हमें अपनी दिव्य जड़ों और असली आत्मा के स्वरूप की याद दिलाती रहती हैं।"
        """.trimIndent(),
        english = """
            (The Form of Memory): "To the Goddess who resides in all beings as 'Smriti' (Memory), I offer my salutations."
            "I bow to Her again and again, forever honoring the Mother who preserves the records of existence."
            "Smriti is the 'Memory' that enables us to learn from past experiences and evolve into the future."
            "Without the faculty of memory, a human can neither learn language nor construct a personal Identity."
            "The Goddess is the internal 'Library' of our brain where absolutely all cosmic knowledge is securely stored."
            "Whenever we forget our true Self, it is the Goddess who grants us the 'Remembrance' of our divinity."
            "Erasing toxic memories (Trauma) and cherishing righteous wisdom is the ultimate application of Smriti power."
            "This mantra is miraculous for students and meditators looking to enhance retention and mental clarity."
            "We bow to the power that grants us the capacity to remember the Truth and permanently forget the illusion."
            "As Smriti, the Mother continuously reminds us of our divine origin and the eternal nature of the soul."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 29,
        sanskrit = "या देवी सर्वभूतेषु दयारूपेण संस्थिता ।\nनमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ ६५-६७ ॥",
        hindi = """
            (दया रूप): "जो देवी समस्त प्राणियों में 'दया' (Compassion) के रूप में स्थित हैं, उन्हें मेरा नमस्कार है।"
            "उन करुणामयी माता को बार-बार प्रणाम है, उन्हें निरंतर नमस्कार है।"
            "दया वह 'पवित्र भावना' है जो हमें दूसरों के दुःख को समझने और उसे दूर करने की प्रेरणा देती है।"
            "यह वह शक्ति है जो इंसान को कठोर होने से बचाती है और उसके हृदय को कोमल बनाती है।"
            "देवी ही वह 'अनकंडीशनल लव' (Unconditional Love) हैं जो ब्रह्मांड के हर जीव के प्रति सहानुभूति रखती हैं।"
            "सच्ची दया वह है जो बिना किसी स्वार्थ के, केवल निस्वार्थ सेवा के भाव से पैदा होती है।"
            "जब हम दयालु होते हैं, तो हम साक्षात् देवी के सबसे करीब पहुँच जाते हैं।"
            "यह मंत्र हृदय को शुद्ध करने और नफरत के ज़हर को प्रेम में बदलने के लिए अत्यंत प्रभावशाली है।"
            "हम उस शक्ति को नमन करते हैं जो हमें एक संवेदनशील और मानवीय प्राणी बनने में मदद करती है।"
            "दया रूप में देवी हमें सिखाती हैं कि दूसरों की सेवा ही ईश्वर की सबसे बड़ी आराधना है।"
        """.trimIndent(),
        english = """
            (The Form of Compassion): "To the Goddess who resides in all beings as 'Daya' (Compassion), I bow repeatedly."
            "Salutations to Her again and again; I offer my constant reverence to the Mother of infinite Mercy."
            "Daya is that 'Sacred Emotion' which motivates us to understand and alleviate the suffering of others."
            "It is the internal power that prevents a human from becoming rigid and keeps the core heart tender."
            "The Goddess is that 'Unconditional Love' which holds empathy for every microscopic creature in the cosmos."
            "Genuine compassion is zero self-interest; it originates strictly from the intent of selfless service."
            "The moment we practice compassion, we successfully reach the absolute closest proximity to the Divine."
            "This mantra is exceptionally effective for purifying the heart and transforming the poison of hate into love."
            "We bow to the power that assists us in becoming sensitive, empathetic, and superior human beings."
            "As Daya, the Mother teaches us that serving others is the absolute highest form of worshipping God."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 30,
        sanskrit = "या देवी सर्वभूतेषु तुष्टिरूपेण संस्थिता ।\nनमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ ६८-७० ॥",
        hindi = """
            (तुष्टि रूप): "जो देवी सभी प्राणियों में 'तुष्टि' (Satisfaction/Contentment) के रूप में स्थित हैं, उन्हें मेरा नमस्कार है।"
            "उन संतोष-स्वरूपा माता को बार-बार प्रणाम है, उन्हें सदा नमस्कार है।"
            "तुष्टि वह 'गहरी संतुष्टि' है जो इंसान को भाग-दौड़ भरी दुनिया में ठहराव और शांति प्रदान करती है।"
            "बिना इस संतुष्टि के, अरबपति होने पर भी इंसान भिखारी की तरह हमेशा और ज़्यादा की तलाश में रहता है।"
            "देवी ही वह 'आंतरिक सुख' हैं जो हमें महसूस कराती हैं कि हमारे पास जो है, वह पर्याप्त है।"
            "जब मन में तुष्टि आती है, तो लालच (Greed) और ईर्ष्या (Jealousy) हमेशा के लिए खत्म हो जाते हैं।"
            "यह मंत्र एंग्जायटी को दूर करने और मानसिक शांति प्राप्त करने के लिए रामबाण औषधि है।"
            "संतुष्टि ही वह उपजाऊ ज़मीन है जहाँ असली आध्यात्मिक विकास और ध्यान संभव होता है।"
            "हम उस शक्ति को नमन करते हैं जो हमारे मन को स्थिर और हर हाल में खुश रहने की शक्ति देती है।"
            "तुष्टि रूप में देवी हमें सिखाती हैं कि असली अमीरी बैंक बैलेंस में नहीं, बल्कि मन के संतोष में है।"
        """.trimIndent(),
        english = """
            (The Form of Contentment): "To the Goddess who resides in all beings as 'Tushti' (Satisfaction/Contentment), I offer my salutations."
            "I bow to Her again and again, honoring the Mother who is the absolute source of internal Peace."
            "Tushti represents that 'Deep Contentment' which grants a human stillness in a chaotic and restless world."
            "Without this satisfaction, even a billionaire lives like a beggar, perpetually hunting for more."
            "The Goddess is that 'Internal Joy' which makes us realize that what we currently possess is perfectly enough."
            "Exactly when Contentment enters the mind, Greed and Jealousy are permanently eradicated from the system."
            "This mantra functions as a sovereign medicine for curing anxiety and achieving profound mental tranquility."
            "Contentment serves as the fertile ground where genuine spiritual progress and meditation become possible."
            "We bow to the power that stabilizes our mind and empowers us to remain blissful in every situation."
            "As Tushti, the Mother teaches that true wealth exists zero in bank balances, but strictly in mental peace."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 31,
        sanskrit = "या देवी सर्वभूतेषु मातृरूपेण संस्थिता ।\nनमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ ७१-७३ ॥",
        hindi = """
            (मातृ रूप): "जो देवी समस्त प्राणियों में 'माता' (Mother) के रूप में स्थित हैं, उन्हें मेरा नमस्कार है।"
            "उन ममता-स्वरूपा भगवती को बार-बार प्रणाम है, उन्हें निरंतर नमस्कार है।"
            "माता वह 'सृजन शक्ति' है जो जीवन को जन्म देती है और उसका बिना किसी शर्त के पालन-पोषण करती है।"
            "हर जीव के भीतर जो सुरक्षा और पोषण (Nurturing) की भावना है, वह साक्षात् देवी का ही रूप है।"
            "देवी ही वह 'अल्टीमेट मदर' हैं जिनका प्रेम पूरी सृष्टि को एक परिवार की तरह बांध कर रखता है।"
            "यह वह शक्ति है जो हमारी गलतियों को माफ करती है और हमें हमेशा सही रास्ते पर लौटने का मौका देती है।"
            "जब हम देवी को माता के रूप में पुकारते हैं, तो हमारा 'डर' पूरी तरह खत्म हो जाता है और सुरक्षा का भाव आता है।"
            "यह मंत्र पारिवारिक संबंधों को सुधारने और हृदय में पवित्र ममता जगाने के लिए अत्यंत श्रेष्ठ है।"
            "हम उस शक्ति को नमन करते हैं जो हमें इस संसार में सुरक्षा, प्रेम और पोषण प्रदान करती है।"
            "मातृ रूप में देवी हमें सिखाती हैं कि प्रेम ही ब्रह्मांड की सबसे बड़ी और पवित्र शक्ति है।"
        """.trimIndent(),
        english = """
            (The Form of Mother): "To the Goddess who resides in all beings as 'Matri' (Mother), I bow repeatedly."
            "Salutations to Her again and again; I offer my constant reverence to the Mother of all Life."
            "The Mother symbolizes that 'Creative Power' which births life and sustains it with zero conditions."
            "The instinct of protection and nurturing within every living creature is strictly a manifestation of the Goddess."
            "The Goddess is the 'Ultimate Mother' whose infinite love binds the entire cosmos into a single family."
            "It is this specific energy that forgives our flaws and consistently grants us a chance to reform."
            "The moment we address Her as Mother, our 'Fear' vanishes and is replaced by a profound sense of security."
            "This mantra is superior for improving family relationships and awakening sacred affection in the heart."
            "We bow to the power that grants us unshakeable safety, unconditional love, and nourishment in this world."
            "As Matri, the Mother teaches that Love is undeniably the absolute greatest and holiest force in the universe."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 32,
        sanskrit = "या देवी सर्वभूतेषु भ्रान्तिरूपेण संस्थिता ।\nनमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ ७४-७६ ॥",
        hindi = """
            (भ्रान्ति रूप): "जो देवी सभी प्राणियों में 'भ्रान्ति' (Confusion/Illusion) के रूप में स्थित हैं, उन्हें मेरा नमस्कार है।"
            "उन माया-स्वरूपा माता को बार-बार प्रणाम है, उन्हें सदा नमस्कार है।"
            "भ्रान्ति वह 'कन्फ्यूजन' है जो हमें सत्य को देखने से रोकता है और हमें गलत को सही समझने पर मजबूर करता है।"
            "यह वह परदा है जो हमारी बुद्धि के ऊपर तब गिरता है जब हमारा अहंकार बहुत ज़्यादा बढ़ जाता है।"
            "देवी ही वह 'माया' हैं जो हमें इस संसार के खेल में उलझाए रखती हैं ताकि हम अनुभव ले सकें।"
            "परंतु जब हम इस शक्ति को पहचान लेते हैं, तो वही भ्रान्ति 'विवेक' (Wisdom) में बदल जाती है।"
            "बिना इस 'भ्रम' के, संसार का यह नाटक (Cosmic Drama) कभी चल ही नहीं सकता था।"
            "यह मंत्र मानसिक अस्पष्टता को दूर करने और मोह-माया के जालों को काटने के लिए बहुत शक्तिशाली है।"
            "हम उस शक्ति को नमन करते हैं जो हमें भटकने के बाद वापस सही रास्ते पर लाने की क्षमता रखती है।"
            "भ्रान्ति रूप में देवी हमें याद दिलाती हैं कि यह संसार महज़ एक सपना है, और जागना ही असली लक्ष्य है।"
        """.trimIndent(),
        english = """
            (The Form of Delusion): "To the Goddess who resides in all beings as 'Bhranti' (Confusion/Illusion), I offer my salutations."
            "I bow to Her again and again, honoring the Mother who creates the cosmic play of appearances."
            "Bhranti is the 'Confusion' that prevents us from seeing Truth and makes us mistake the temporary for the eternal."
            "It is the veil that drops over our intellect specifically when our personal arrogance exceeds its limits."
            "The Goddess is that 'Maya' who keeps us entangled in the game of the world so that we may gather experiences."
            "However, the moment we recognize this power, that same confusion systematically transforms into pure Wisdom."
            "Without this 'Delusion', the absolute Cosmic Drama of existence could mathematically never function."
            "This mantra is highly potent for eradicating mental fog and cutting through the intricate webs of attachment."
            "We bow to the power that holds the capacity to bring us back to the righteous path after we wander."
            "As Bhranti, the Mother reminds us that this world is merely a dream, and Awakening is the only true goal."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 33,
        sanskrit = "इन्द्रियाणामधिष्ठात्री भूतानां चाखिलेषु या ।\nभूतेषु सततं तस्यै व्याप्तिदेव्यै नमो नमः ॥ ७७ ॥",
        hindi = """
            (इन्द्रियों की अधिष्ठात्री): "जो देवी सभी प्राणियों की समस्त इन्द्रियों की 'अधिष्ठात्री' (Controler/Mistress) हैं।"
            "और जो इस पूरे ब्रह्मांड के पंच-भूतों (आकाश, वायु, अग्नि, जल, पृथ्वी) में निरंतर व्याप्त हैं।"
            "उन सर्वव्यापक 'व्याप्ति' देवी को हमारा बार-बार नमस्कार है, उन्हें बार-बार प्रणाम है।"
            "यह श्लोक बताता है कि हमारी इन्द्रियां स्वतंत्र नहीं हैं; उनके पीछे एक दिव्य शक्ति काम कर रही है।"
            "आंखों के देखने की ताकत और कानों के सुनने की क्षमता—सब उसी एक चेतना का विस्तार हैं।"
            "देवी ही वह 'अदृश्य ऑपरेटर' हैं जो हमारे शरीर रूपी मशीन की हर इन्द्रिय को चलाती हैं।"
            "व्याप्ति (Pervasiveness) का अर्थ है कि ब्रह्मांड का कोई भी कोना ऐसा नहीं है जहाँ वह मौजूद न हों।"
            "जब हम अपनी इन्द्रियों को देवी को समर्पित कर देते हैं, तो हमारा हर अनुभव 'पवित्र' (Sacred) हो जाता है।
            यह मंत्र इन्द्रियों पर नियंत्रण पाने और भगवान की मौजूदगी को हर जगह महसूस करने के लिए अद्भुत है।"
            "हम उस सर्वव्यापी चेतना को नमन करते हैं जो हमारे हर अंग और परमाणु में बसी हुई है।"
        """.trimIndent(),
        english = """
            (The Mistress of Senses): "To the Goddess who is the absolute 'Mistress' (Adhishthatri) of the senses of all living beings."
            "And who is perpetually pervading the five fundamental elements across the entire universe."
            "To that all-pervasive Goddess of 'Vyapti' (Pervasion), I bow again and again; salutations to Her."
            "This verse reveals that our senses are zero independent; a divine power operates strictly behind them."
            "The power of vision in our eyes and the capacity of hearing in our ears are mere extensions of Her."
            "The Goddess is the 'Invisible Operator' who runs every sensory hardware of our biological machine."
            "Vyapti implies that there exists mathematically zero corner in the cosmos where She is absent."
            "Exactly when we surrender our sensory activities to the Goddess, every experience becomes profoundly Sacred."
            "This mantra is miraculous for gaining mastery over the senses and perceiving God in every object."
            "We revere the omnipresent Consciousness that resides within our every organ, cell, and atom."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 34,
        sanskrit = "चितिरूपेण या कृत्स्नमेतद् व्याप्य स्थिता जगत् ।\nनमस्तस्यै नमस्तस्यै नमस्तस्यै नमो नमः ॥ ७८-८० ॥",
        hindi = """
            (चिति रूप): "जो देवी साक्षात् 'चिति' (Pure Intelligence/Energy) के रूप में इस संपूर्ण जगत को व्याप्त करके स्थित हैं।"
            "उन भगवती को बार-बार नमस्कार है, उन्हें कोटि-कोटि प्रणाम है।"
            "चिति वह 'अल्टीमेट इंटेलिजेंस' है जो पूरे ब्रह्मांड के सिस्टम को एक परफेक्ट ऑर्डर में चलाती है।"
            "यह वह ऊर्जा है जो मृत पदार्थ में भी 'वाइब्रेशन' (Vibration) और जीवन पैदा करती है।"
            "पूरा ब्रह्मांड महज़ एक विचार (Thought) है जो इस चिति-शक्ति के समुद्र में तैर रहा है।"
            "देवी ही वह 'प्रकाश' हैं जिसमें यह सारा संसार दिखाई देता है और महसूस होता है।"
            "जब हम इस चिति रूप को प्रणाम करते हैं, तो हम अपनी व्यक्तिगत बुद्धि को ब्रह्मांडीय बुद्धि से जोड़ लेते हैं।"
            "यह मंत्र अद्वैत (Non-duality) का अनुभव कराने वाला है—जहाँ 'मैं' और 'परमात्मा' एक हो जाते हैं।"
            "हम उस अनंत चेतना को नमन करते हैं जिसके बिना इस ब्रह्मांड का कोई अस्तित्व ही नहीं होता।"
            "चिति रूप में देवी हमें सिखाती हैं कि सब कुछ ऊर्जा है और हम सब उसी का हिस्सा हैं।"
        """.trimIndent(),
        english = """
            (The Form of Pure Intelligence): "To the Goddess who resides as 'Chiti' (Pure Intelligence/Energy), pervading this entire world."
            "I bow to Her again and again; salutations to the Supreme Mother of infinite Intelligence."
            "Chiti is the 'Ultimate Intelligence' that governs the complex systems of the universe in perfect order."
            "It is the specific energy that generates 'Vibration' and life even within seemingly inanimate matter."
            "The entire universe is merely a cosmic thought floating within the vast ocean of this Chiti power."
            "The Goddess is the eternal 'Light' in which this entire world is observed and experienced."
            "By bowing to this Chiti format, we successfully link our personal intellect with the Cosmic Mind."
            "This mantra facilitates the experience of Non-duality, where the 'Self' and 'God' become one."
            "We bow to the infinite Awareness without which this entire universe would hold zero existence."
            "As Chiti, the Mother teaches us that everything is Energy and we are all microscopic parts of it."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 35,
        sanskrit = "स्तुता सुरैः पूर्वमभीष्टसंश्रयात् तथा सुरेन्द्रेण दिनेषु सेविता ।\nकरोतु सा नः शुभहेतुरीश्वरी शुभानि भद्राण्यभिहन्तु चापदः ॥ ८१ ॥",
        hindi = """
            (शुभ की प्रार्थना): "जिन देवी की स्तुति पूर्व काल में देवताओं ने अपनी इच्छाओं की पूर्ति के लिए की थी।"
            "और इन्द्र ने भी अपनी सत्ता वापस पाने के लिए जिनकी कई दिनों तक निरंतर सेवा और पूजा की।"
            "वे ही कल्याण करने वाली ईश्वरी हमारा मंगल (शुभ) करें और हमारी सभी विपत्तियों का नाश करें।"
            "यह श्लोक 'परम्परा' (Tradition) और 'निरंतरता' का महत्व समझाता है।"
            "देवी ने हमेशा देवताओं (अच्छाई) की रक्षा की है, इसलिए हमें उन पर पूरा भरोसा करना चाहिए।"
            "'शुभहेतु' का अर्थ है कि देवी ही हमारे जीवन में होने वाली हर अच्छी घटना का एकमात्र कारण हैं।"
            "विपत्तियां (Disasters) हमारे ईगो के कारण आती हैं, और माता उन्हें मिटाने के लिए हमेशा तैयार रहती हैं।"
            "जब हम पुराने संतों और देवताओं के पदचिन्हों पर चलते हैं, तो हमारी प्रार्थना जल्दी सुनी जाती है।"
            "यह मंत्र जीवन में 'पॉजिटिविटी' (Positivity) लाने और सुरक्षा ग्रिड बनाने के लिए अत्यंत शक्तिशाली है।"
            "हम उस भगवती से प्रार्थना करते हैं कि वे हमारे विचारों और कर्मों को हमेशा पवित्र और शुभ बनाए रखें।"
        """.trimIndent(),
        english = """
            (Prayer for Auspiciousness): "The Goddess who was praised by the Gods in the past to fulfill their sacred desires."
            "And who was served and worshipped by Indra for many days to regain his lost celestial empire."
            "May that benevolent Ishwari grant us total welfare and ruthlessly destroy all our worldly calamities."
            "This verse emphasizes the absolute importance of 'Tradition' and 'Consistency' in spiritual practice."
            "The Mother has perpetually protected the divine virtues, therefore our trust in Her must be unshakeable."
            "'Shubha-hetu' implies that the Goddess is the singular underlying cause of every good event in our life."
            "Calamities (Disasters) strictly originate from our ego, and the Mother is perpetually ready to delete them."
            "When we follow the spiritual footsteps of ancient Sages and Gods, our prayers gain cosmic velocity."
            "This mantra is exceptionally potent for attracting 'Positivity' and establishing a security grid."
            "We pray to the Supreme Mother to perpetually keep our thoughts and actions holy, pure, and auspicious."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 36,
        sanskrit = "या साम्प्रतं चोद्धतदैत्यतापितैर्- अस्माभिरीशा च सुरैर्नमस्यते ।\nया च स्मृता तत्क्षणमेव हन्ति नः सर्वापदो भक्तिविनम्रमूर्तिभिः ॥ ८२ ॥",
        hindi = """
            (तत्काल रक्षा): "वही ईश्वरी (देवी), जिन्हें आज हम दुष्ट दैत्यों से पीड़ित होकर भक्तिपूर्वक प्रणाम कर रहे हैं।"
            "और जो केवल एक बार 'स्मरण' (याद) करने मात्र से ही हमारी सभी विपत्तियों का उसी क्षण नाश कर देती हैं।"
            "वे परम भगवती हम पर प्रसन्न होकर हमारे सभी दुखों और संकटों को हमेशा के लिए मिटा दें।"
            "यहाँ 'तत्क्षण' (Instantly) शब्द पर ध्यान दें—चेतना के पास समय (Time) की कोई सीमा नहीं है।"
            "जब पुकार सच्ची होती है, तो मदद आने में एक सेकंड की भी देरी नहीं होती।"
            "देवता यहाँ अपनी 'विनम्रता' (Humility) को अपनी सबसे बड़ी ताकत के रूप में इस्तेमाल कर रहे हैं।"
            "अहंकारी इंसान कभी देवी को 'याद' नहीं कर पाता, इसलिए वह अपने संकटों में ही फँसा रहता है।"
            "परंतु जो झुकना (विनम्रमूर्ति) जानता है, उसे पूरा ब्रह्मांड रास्ता देने के लिए तैयार रहता है।"
            "यह मंत्र इमरजेंसी (Emergency) में मानसिक बल और सुरक्षा प्राप्त करने के लिए सबसे तेज़ काम करता है।"
            "हम उस शक्ति को नमन करते हैं जो हमारी एक पुकार पर अपना सब कुछ छोड़कर रक्षा के लिए आ जाती है।"
        """.trimIndent(),
        english = """
            (Instant Protection): "The same Ishwari, to whom we, tormented by demons, now bow with absolute pure devotion."
            "And who, by the mere act of 'Remembrance', instantaneously destroys all our calamities in a single split-second."
            "May that Supreme Goddess be pleased and permanently erase all our psychological sorrows and crisis."
            "Focus on the word 'Tat-kshanam' (Instantly)—Consciousness functions mathematically beyond the limits of Time."
            "When the internal call is authentic and deep, divine assistance arrives with zero cosmic delay."
            "The Gods are utilizing their 'Humility' (Vinamra-murti) right here as their absolute greatest spiritual weapon."
            "An arrogant human can mathematically never genuinely 'Remember' God, thus he remains trapped in his own hell."
            "But for the human who knows how to bow, the entire universe stands ready to clear his path."
            "This mantra works at the highest velocity for gaining mental strength and safety during emergencies."
            "We bow to the power that abandons everything else to protect us the exact moment we call from the core."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 37,
        sanskrit = "ऋषिरुवाच ॥ ८३ ॥\nइति प्रणामादिभिरादरेण कृतेन देवैर्भगवती तदानीम् ।\nपार्वत्यभ्यायान्नु विमज्जन्ती स्रोतसि जाह्नव्याः ॥ ८४ ॥",
        hindi = """
            (पार्वती का आगमन): "ऋषि मेधा ने कहा: जब देवताओं ने इस प्रकार बड़े आदर के साथ माता को प्रणाम और प्रार्थना की।"
            "तो ठीक उसी समय (तदानीम्) माता 'पार्वती' वहाँ गंगा जी के पवित्र जल में स्नान करने के लिए आईं।"
            "यहाँ से कथा में एक बहुत बड़ा चमत्कार और नया मोड़ (Twist) आने वाला है।"
            "गंगा (जाह्नव्याः) यहाँ 'शुद्धता' और 'ज्ञान' की निरंतर बहने वाली धारा का प्रतीक है।"
            "पार्वती का स्नान करना यह दर्शाता है कि ज्ञान प्राप्त करने के लिए मन का 'पवित्र' होना आवश्यक है।"
            "देवता पहाड़ पर बैठकर रो रहे थे, और शांति (पार्वती) खुद उनके पास चलकर आ रही थी।"
            "यह दिखाता है कि जब आपकी प्रार्थना सच्ची होती है, तो ईश्वरीय शक्ति आपके करीब आने लगती है।"
            "पार्वती वह 'कोमल और सांसारिक' रूप है जिसे हम सब जानते और प्यार करते हैं।"
            "परंतु इस कोमलता के भीतर ही वह 'महाशक्ति' छिपी है जो शुम्भ-निशुम्भ का संहार करेगी।"
            "अब प्रकृति का वह रहस्य खुलने वाला है जहाँ एक रूप से दूसरा रूप (अवतार) प्रकट होगा।"
        """.trimIndent(),
        english = """
            (The Arrival of Parvati): "The Sage stated: Exactly when the Gods performed these respectful salutations and prayers."
            "At that specific moment, Mother 'Parvati' arrived there strictly to bathe in the holy waters of the Ganges."
            "This marks a massive cosmic miracle and a significant psychological 'Twist' in the narrative."
            "The Ganges (Jahnavi) symbolizes the eternal, continuous flow of 'Purity' and 'Spiritual Knowledge'."
            "Parvati's act of bathing represents that the 'Purification' of the mind is essential to receive higher wisdom."
            "While the Gods were weeping on the peak, Peace (Parvati) was independently walking directly toward them."
            "This proves that when your prayer is authentic, the Divine Energy begins its movement toward your consciousness."
            "Parvati represents the 'Gentle and Relatable' format of the Goddess that we all recognize and love."
            "However, hidden within this softness is that 'Mega-power' destined to annihilate Shumbha and Nishumbha."
            "Now the secret of Nature is about to be unveiled, where one divine form manifests from another."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 38,
        sanskrit = "साऽब्रवीत्तान् सुरान् सुभ्रूर्भवद्भिः स्तूयतेऽत्र का ।\nशरीरकोषतश्चास्याः समुद्भूताऽब्रवीच्छिवा ॥ ८५ ॥",
        hindi = """
            (पार्वती का प्रश्न और शिवा का उदय): "सुंदर भौंहों वाली माता पार्वती ने उन देवताओं से पूछा—'आप यहाँ किसकी स्तुति कर रहे हैं?'"
            "उनके इतना कहते ही, स्वयं माता पार्वती के 'शरीर के कोष' (Cells/Body) से एक दूसरी दिव्य देवी प्रकट हुईं।"
            "उन प्रकट हुई देवी ने ही (जिन्हें 'शिवा' या 'कौशिकी' कहा गया) देवताओं के प्रश्न का उत्तर दिया।"
            "यह तन्त्र का सबसे रहस्यमयी दृश्य है—एक देवी के शरीर के अंदर से दूसरी देवी का निकलना।"
            "पार्वती यहाँ 'प्रकृति' हैं और उनके अंदर से निकलने वाली 'कौशिकी' वह 'परम ज्ञान' है जो अज्ञान को मारेगा।"
            "पार्वती का खुद पूछना कि 'तुम किसकी स्तुति कर रहे हो'—यह एक लीला है जो यह दिखाती है कि भगवान खुद भक्त को अपनी ओर खींचते हैं।"
            "'शरीरकोष' (Body Sheath) का अर्थ है कि हमारे अंदर भी एक से ज़्यादा लेयर्स (Layers) और शक्तियां मौजूद हैं।"
            "जब संकट आता है, तो हमारी बाहरी शांति (पार्वती) के भीतर से एक उग्र शक्ति (शिवा) का जन्म होता है।"
            "अब वह उग्र चेतना सामने आ चुकी है जो राक्षसों के साथ अंतिम युद्ध लड़ेगी।"
            "यह श्लोक अवतार (Manifestation) की प्रक्रिया को बहुत ही वैज्ञानिक तरीके से स्पष्ट करता है।"
        """.trimIndent(),
        english = """
            (The Question and Emergence of Shiva): "Mother Parvati with beautiful eyebrows asked the Gods—'Who is being praised by you here?'"
            "The moment She spoke, another divine Goddess instantaneously emerged from Mother Parvati's own 'Body Sheath'."
            "That newly manifested Goddess (named 'Shiva' or 'Kaushiki') Herself answered the question of the Gods."
            "This is the most mysterious visual in Tantra—the manifestation of one Divine Entity from within another."
            "Parvati represents 'Nature', and 'Kaushiki' emerging from Her is that 'Supreme Wisdom' destined to slaughter ignorance."
            "Parvati's question ('Who are you praising?') is a cosmic play proving that God independently draws the devotee closer."
            "'Sharira-kosha' implies that multiple psychological layers and powers perpetually exist within our own biological system."
            "During a crisis, from within our external calm (Parvati), an intense destructive power (Shiva) is born to protect us."
            "The fierce consciousness has now stepped out into the open to fight the final apocalyptic war against the demons."
            "This verse explains the exact scientific and cosmic process of 'Manifestation' with absolute precision."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 39,
        sanskrit = "स्तोत्रं ममैतद् क्रियते शुम्भदैत्यनिराकृतैः ।\nदेवैः समेतैः समरे निशुम्भेन पराजितैः ॥ ८६ ॥",
        hindi = """
            (कौशिकी का उत्तर): "शरीर से प्रकट हुई उस देवी (कौशिकी) ने कहा: 'शुम्भ और निशुम्भ से पराजित होकर ये देवता मेरी ही स्तुति कर रहे हैं'।"
            "'ये दुष्ट राक्षसों द्वारा सताए गए हैं और युद्ध में अपनी सत्ता खो चुके हैं, इसलिए ये मुझे वापस बुला रहे हैं'।"
            "यह श्लोक 'सेल्फ-अवेयरनेस' (Self-awareness) का चरम है—देवी खुद अपनी पहचान बता रही हैं।"
            "वे कह रही हैं कि मैं ही वह शक्ति हूँ जो अज्ञान (शुम्भ-निशुम्भ) का नाश करने के लिए पैदा हुई हूँ।"
            "शुम्भ (अहंकार) और निशुम्भ (ममता) के कारण जब इंसान की अच्छी प्रवृत्तियां (देवता) तड़पती हैं, तभी 'ज्ञान' का जन्म होता है।"
            "बिना संघर्ष के कभी भी 'कौशिकी' (उच्च चेतना) का प्रकटीकरण नहीं होता।"
            "देवी का यह कहना कि 'ये मेरी ही स्तुति कर रहे हैं'—यह बताता है कि हर सच्ची पुकार अंततः एक ही जगह पहुँचती है।"
            "राक्षसों द्वारा 'निराकृत' (अपमानित) होना देवताओं के लिए एक आशीर्वाद बन गया क्योंकि उन्हें साक्षात् शिवा मिल गईं।"
            "हमारे जीवन की मुश्किलें भी हमें उसी 'परम शक्ति' के पास ले जाने का एक बहाना होती हैं।"
            "अब युद्ध का मैदान तैयार है और कौशिकी अपने प्रचंड रूप में राक्षसों का सामना करने के लिए तैयार हैं।"
        """.trimIndent(),
        english = """
            (The Answer of Kaushiki): "The newly emerged Goddess (Kaushiki) said: 'Defeated by Shumbha and Nishumbha, these Gods are praising Me'."
            "'They have been tormented by the wicked demons and have lost their cosmic authority, thus they are summoning Me'."
            "This verse represents the peak of 'Self-awareness'—the Goddess Herself is confirming Her divine identity."
            "She is explicitly stating that She is the singular power born to annihilate deep-seated ignorance (Shumbha-Nishumbha)."
            "When the virtuous tendencies (Gods) suffer due to 'Arrogance' and 'Attachment', only then is 'Wisdom' born."
            "The manifestation of 'Kaushiki' (Higher Consciousness) can mathematically never occur without a previous struggle."
            "The Goddess's statement ('They are praising Me') proves that every authentic prayer reaching the cosmos hits the same source."
            "Being 'Humiliated' by the demons became a blessing for the Gods, as it resulted in the physical arrival of the Divine."
            "The extreme difficulties in our human life are merely excuses designed to drive us back to that 'Ultimate Power'."
            "The cosmic battlefield is now perfectly set, and Kaushiki is ready to confront the demonic forces in Her fierce form."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 40,
        sanskrit = "शरीरकोषतस्तस्या विनिर्गताम्बिका ।\nकौशिकीति समस्तेषु लोकेषु परिगीयते ॥ ८७ ॥",
        hindi = """
            (कौशिकी का नाम): "माता पार्वती के शरीर-कोष (त्वचा) से प्रकट होने के कारण, उन भगवती का नाम 'कौशिकी' पड़ा।"
            "आज संपूर्ण लोकों में उन्हीं परम देवी का 'कौशिकी' के नाम से गुणगान किया जाता है।"
            "तन्त्र में 'कोष' का अर्थ होता है वह 'आवरण' (Cover) जो सत्य को ढके रहता है।"
            "जब यह आवरण (Ego/Body) हटता है, तो उसके अंदर से शुद्ध चेतना (कौशिकी) बाहर आती है।"
            "कौशिकी का अर्थ है वह ऊर्जा जो हमारे 'अस्तित्व के गहरे रहस्यों' (Cells) से निकलती है।"
            "वे साक्षात् 'ब्लैक होल' (Black Hole) की तरह हैं—अत्यंत शक्तिशाली और अंधकार को निगलने वाली।"
            "उनके प्रकट होते ही माता पार्वती का रंग एकदम काला (काली) हो गया।"
            "यह दिखाता है कि ज्ञान (कौशिकी) के निकलते ही, प्रकृति (पार्वती) वापस अपने 'मूल और मौन' रूप में लौट जाती है।"
            "नाम का 'परिगीयते' (गाया जाना) यह बताता है कि यह शक्ति हर साधक के भीतर गूंजती है।"
            "कौशिकी का जन्म ही शुम्भ और निशुम्भ के साम्राज्य के अंत की आधिकारिक घोषणा है।"
        """.trimIndent(),
        english = """
            (The Name of Kaushiki): "Since She manifested strictly from the 'Body Sheath' (Cells) of Mother Parvati, She is known as 'Kaushiki'."
            "In all the worlds, that Supreme Goddess is now perpetually celebrated and sung as 'Kaushiki'."
            "In Tantra, 'Kosha' symbolizes the 'Cover' or veil that masks the ultimate inner Truth."
            "The moment this veil (Ego/Body-identification) is removed, the pure Radiance (Kaushiki) steps out."
            "Kaushiki refers to that energy which originates from the absolute 'Deepest Mysteries' of our core existence."
            "She is mathematically identical to a 'Black Hole'—immensely powerful and capable of consuming all darkness."
            "Upon Her emergence, Mother Parvati's complexion turned entirely jet-black (becoming Kalika)."
            "This demonstrates that once Wisdom (Kaushiki) manifests, Nature (Parvati) returns to its 'Original and Silent' state."
            "The singing of Her name ('Parigiyate') proves that this power vibrates within every advanced spiritual practitioner."
            "The birth of Kaushiki is officially the formal cosmic announcement of the end of Shumbha and Nishumbha's reign."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 41,
        sanskrit = "तस्यां विनिर्गतायां तु कृष्णाऽभूत्साऽपि पार्वती ।\nकालीति नाम्ना ययौ सा हिमवन्तं कृताश्रया ॥ ८८ ॥",
        hindi = """
            (कालिका का जन्म): "कौशिकी के बाहर निकलते ही, माता पार्वती का शरीर एकदम 'कृष्ण' (काला) हो गया।"
            "अब वे 'काली' (या कालिका) के नाम से प्रसिद्ध हुईं और हिमालय पर्वत पर अपना निवास बनाकर रहने लगीं।"
            "यह श्लोक 'लाइट' (कौशिकी) और 'डार्कनेस' (काली) के रहस्य को समझाता है।"
            "जब ज्ञान (प्रकाश) बाहर आता है, तो उसके पीछे एक गहरा 'मौन और वैराग्य' (काला रंग) छूट जाता है।"
            "काली यहाँ उस 'शून्यता' (Emptiness) का प्रतीक हैं जिसमें सारा ब्रह्मांड समाया हुआ है।"
            "हिमालय (कृताश्रया) पर रहना यह बताता है कि यह शक्ति अत्यंत 'स्थिर' (Unmovable) और 'उच्च' (High) है।"
            "इंसान के अंदर जब अहंकार मरता है, तो उसके स्वभाव में एक गहरा और गंभीर वैराग्य (काली) आता है।"
            "काली वह 'समय' (Time) है जो हर चीज़ को खा जाता है, और कौशिकी वह 'चेतना' है जो सब कुछ जानती है।"
            "अब ब्रह्मांड की दो सबसे बड़ी शक्तियां एक साथ एक्टिव हो चुकी हैं।"
            "राक्षसों का काल (Death) अब उनके बिल्कुल करीब पहुँच चुका है।"
        """.trimIndent(),
        english = """
            (Birth of Kalika): "The moment Kaushiki emerged, Mother Parvati's physical body turned entirely 'Krishna' (Jet-black)."
            "She became famous by the name 'Kali', establishing Her sacred residence upon the high Himalayas."
            "This verse explains the profound relationship between 'Light' (Kaushiki) and 'Darkness' (Kali)."
            "When Wisdom (Light) steps out, it leaves behind a deep state of 'Silence and Detachment' (The Black Hue)."
            "Kali here symbolizes that absolute 'Emptiness' (Void) in which the entire cosmos is perpetually contained."
            "Residing on the Himalayas proves that this energy is immensely 'Stable' and belongs to the 'Highest' dimensions."
            "When the ego dies within a human, his nature assumes a deep and solemn state of detachment (Kali)."
            "Kali is 'Time' that eventually consumes everything, and Kaushiki is 'Consciousness' that knows everything."
            "The two absolute greatest cosmic forces are now simultaneously active and fully operational."
            "The 'Time of Death' for the demonic forces has now successfully reached their absolute doorstep."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 42,
        sanskrit = "ततोऽम्बिकां परं रूपं बिभ्राणां सुमनोहरम् ।\nददर्श चण्डो मुण्डश्च भृत्यौ शुम्भनिशुम्भयोः ॥ ८९ ॥",
        hindi = """
            (चण्ड-मुण्ड का आगमन): "इसके बाद, शुम्भ और निशुम्भ के दो सेवक 'चण्ड' और 'मुण्ड' ने उस परम देवी को देखा।"
            "माता उस समय कौशिकी के रूप में अत्यंत सुंदर और 'मनमोहक' (सुमनोहरम्) स्वरूप धारण किए हुए थीं।"
            "चण्ड और मुण्ड यहाँ इंसान के 'गलत विचारों' और 'लालच' (Greed) के जासूसों का प्रतीक हैं।"
            "वे बुराई के वे भृत्य (नौकर) हैं जो हमेशा अच्छी चीज़ों पर अपनी गंदी नज़र रखते हैं।"
            "देवी की सुंदरता (Manoharam) यहाँ अज्ञान को 'आकर्षित' (Attract) करने के लिए है ताकि उसका अंत हो सके।"
            "जब इंसान के अंदर सच्चाई (देवी) प्रकट होती है, तो उसका ईगो (शुम्भ) तुरंत चौकन्ना हो जाता है।"
            "वह अपने जासूसों (चण्ड-मुण्ड) को भेजता है ताकि वह उस शक्ति को 'कंट्रोल' या 'भोग' सके।"
            "सुमनोहर रूप यह बताता है कि सत्य देखने में बहुत प्यारा लगता है, पर अज्ञानी के लिए वह जानलेवा होता है।"
            "अहंकार हमेशा सुंदरता को कब्ज़ा करना चाहता है, उसे 'जीना' (Experience) नहीं जानता।"
            "यहीं से उस जाल की शुरुआत होती है जिसमें शुम्भ और निशुम्भ खुद फंसने वाले हैं।"
        """.trimIndent(),
        english = """
            (Arrival of Chanda and Munda): "Subsequently, the two servants of Shumbha and Nishumbha, named 'Chanda' and 'Munda', spotted the Goddess."
            "At that time, the Mother as Kaushiki assumed an exceptionally beautiful and 'Enchanting' (Manoharam) form."
            "Chanda and Munda symbolize the internal 'Detectives' of toxic greed and manipulative thought patterns."
            "They are the servants of evil who perpetually cast a predatory gaze upon all pure and beautiful objects."
            "The Goddess's immense beauty is intentionally displayed to 'Attract' ignorance toward its own inevitable end."
            "The exact moment Truth (Goddess) manifests within a human, his toxic Ego (Shumbha) becomes hyper-alert."
            "It dispatches its scouts (Chanda-Munda) to either 'Control' that power or 'Consume' it for its own sake."
            "Her enchanting form proves that Truth appears delightful, but for the ignorant, it is mathematically lethal."
            "Arrogance perpetually seeks to 'Possess' beauty rather than successfully 'Experiencing' its pure divinity."
            "This marks the initiation of the cosmic trap in which Shumbha and Nishumbha are destined to be caught."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 43,
        sanskrit = "ताभ्यां शुम्भाय चाख्याता साऽतीव सुमनोहरा ।\nकाप्यस्ते स्त्री महाराज भासयन्ती हिमाचलम् ॥ ९० ॥",
        hindi = """
            (शुम्भ को रिपोर्ट): "उन दोनों (चण्ड-मुण्ड) ने जाकर अपने राजा शुम्भ को बताया—'हे महाराज! वहाँ हिमालय पर एक अत्यंत सुंदर स्त्री है'।"
            "'वह स्त्री इतनी मनोहर और तेजस्वी है कि वह अपने प्रकाश से पूरे 'हिमाचल' (पर्वत) को चमका रही है'।"
            "'आज तक हमने ऐसी अद्भुत और दिव्य सुंदरता पहले कभी नहीं देखी'।"
            "यह इंसान के 'लोभ' (Greed) का पहला चरण है—दूसरों की चीज़ों को देखकर उनकी रिपोर्टिंग करना।"
            "चण्ड-मुण्ड को देवी में 'शक्ति' नहीं, केवल 'स्त्री' (Object) दिखाई दी, यही अज्ञान का सबसे बड़ा प्रमाण है।"
            "जब इंसान सत्य को केवल एक 'वस्तु' (Product) समझता है, तो वह उसके विनाश का कारण बनता है।"
            "'भासयन्ती' (Shining) का अर्थ है कि सत्य को छिपाया नहीं जा सकता, वह अपनी मौजूदगी से माहौल बदल देता है।"
            "अहंकार (शुम्भ) को जैसे ही पता चलता है कि कुछ बहुत कीमती चीज़ उपलब्ध है, वह उसे पाने के लिए तड़प उठता है।"
            "यह 'महाराज' शब्द शुम्भ के उस भ्रम को दर्शाता है जहाँ उसे लगता है कि वह पूरी दुनिया का मालिक है।"
            "अज्ञान अब सुंदरता को 'भोगने' की योजना बनाने लगा है।"
        """.trimIndent(),
        english = """
            (Reporting to Shumbha): "Those two (Chanda-Munda) approached their king Shumbha and reported—'O King! There is an incredibly beautiful woman on the Himalayas'."
            "'That woman is so enchanting and radiant that She is illuminating the entire 'Himachal' (Mountain) with Her light'."
            "'In our entire existence, we have absolutely never witnessed such an astonishing and divine beauty before'."
            "This represents the first stage of human 'Greed'—observing external objects and reporting them to the ego."
            "Chanda and Munda perceived the Goddess as a mere 'Woman' (Object) rather than 'Power', proving their thick ignorance."
            "When a human views Truth merely as a 'Product' to be acquired, it inevitably results in his total destruction."
            "'Bhasayanti' (Shining) implies that Truth cannot be concealed; its mere presence alters the entire environment."
            "The Ego (Shumbha) begins to crave possession the exact moment it realizes something valuable is accessible."
            "Addressing him as 'Maharaj' reflects Shumbha's delusion where he falsely believes he owns the entire cosmos."
            "Ignorance is now actively formulating a plan to 'Consume' the divine beauty for its personal pleasure."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 44,
        sanskrit = "नैव तादृक् क्वचित् रूपं दृष्टं केनचिदुत्तमम् ।\nज्ञायतां काप्यसौ देवी गृह्यतां चासुरेश्वर ॥ ९१ ॥",
        hindi = """
            (कब्ज़ा करने की सलाह): "चण्ड-मुण्ड ने आगे कहा: 'हे असुरेश्वर! ऐसी उत्तम सुंदरता दुनिया में किसी ने कभी नहीं देखी होगी'।"
            "'आप पता लगाइए कि वह दिव्य देवी कौन है? और उसे अपने अधिकार में कर लीजिए'।"
            "'वह स्त्री आपके ही महल की शोभा बढ़ाने के योग्य है, उसे यहाँ ले आइए'।"
            "यह 'ईगो का मैनिपुलेशन' (Ego Manipulation) है जहाँ छोटी बुराइयां बड़ी बुराई को उकसाती हैं।"
            "अहंकार को लगता है कि दुनिया की हर 'उत्तम' (Best) चीज़ केवल उसी के पास होनी चाहिए।"
            "'गृह्यतां' (Grab/Take) शब्द इंसान की उस प्रवृत्ति को दिखाता है जहाँ वह प्रेम नहीं, बल्कि कब्ज़ा करना चाहता है।"
            "जब हम किसी चीज़ की सुंदरता से प्रभावित होकर उसे 'छीनना' चाहते हैं, तो हम राक्षस बन जाते हैं।"
            "असुरेश्वर (शुम्भ) को लगा कि वह भगवान की शक्ति (देवी) को भी अपना गुलाम बना सकता है।"
            "यह वह भ्रम है जो हर उस इंसान को होता है जिसे अपनी ताकत या पैसे पर बहुत ज़्यादा घमंड हो।"
            "अब अज्ञान अपने ही पतन (Fall) की तैयारी की तरफ पहला कदम बढ़ा चुका है।"
        """.trimIndent(),
        english = """
            (Advice to Seize): "Chanda and Munda continued: 'O King of Demons! Such supreme beauty has never been seen by anyone in existence'."
            "'You must investigate exactly who this divine Goddess is and bring Her under your absolute control'."
            "'That woman is perfectly worthy of adorning your palace; She must be brought here immediately'."
            "This is the 'Manipulation of Ego', where minor vices actively provoke a larger, central toxic obsession."
            "Arrogance falsely assumes that every 'Supreme' (Uttamam) object in the world must belong exclusively to it."
            "The word 'Grihyatam' (Seize/Grab) reveals the human tendency of seeking possession rather than pure love."
            "The exact moment we desire to 'Snatch' something due to its beauty, we transform into a demonic entity."
            "Shumbha (Asureshwara) deluded himself into thinking he could enslave the very Power of God (Goddess)."
            "This is the same illusion experienced by any human who is excessively intoxicated by their wealth or status."
            "Ignorance has now successfully taken the first step toward its own inevitable and total cosmic Fall."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 45,
        sanskrit = "स्त्रीरत्नमतिचार्वङ्गी द्योतयन्ती दिशस्त्विषा ।\nसा तु तिष्ठति दैत्येन्द्र तां भवान् द्रष्टुमर्हति ॥ ९२ ॥",
        hindi = """
            (स्त्री-रत्न): "उन्होंने कहा: 'हे दैत्यराज! वह स्त्री-रत्न है, जिसके अंग अत्यंत सुंदर हैं और जिसकी कांति चारों दिशाओं को प्रकाशित कर रही है'।"
            "'वह अभी हिमालय पर ही मौजूद है, आपको स्वयं चलकर उसे देखना चाहिए'।"
            "यहाँ देवी को 'स्त्री-रत्न' (Jewel among women) कहकर संबोधित किया गया है।"
            "अहंकार हर चीज़ को एक 'रत्न' या 'संपत्ति' (Asset) की तरह देखता है, चाहे वह इंसान हो या ज्ञान।"
            "'अतिचार्वङ्गी' (Perfect Limbs) का अर्थ है कि अज्ञान केवल बाहरी सुंदरता (External looks) पर ही अटका रहता है।"
            "वह उस रोशनी (त्विषा) को तो देख पा रहे हैं, पर उस रोशनी के पीछे की 'मृत्यु' को नहीं देख पा रहे।"
            "सत्य (देवी) जब प्रकट होता है, तो वह इतना चमकता है कि उसे छिपाना असंभव है।"
            "शुम्भ को 'दैत्येन्द्र' (Indra of demons) कहकर उकसाना उसकी असुरक्षा (Insecurity) को कम करने के लिए है।"
            "अहंकार को हमेशा अपनी तारीफ सुनना पसंद होता है, ताकि वह अपने गलत फैसलों को सही मान सके।"
            "देवी अब उस शिकार (Prey) की तरह दिख रही हैं, जो वास्तव में शिकारी (Hunter) है।"
        """.trimIndent(),
        english = """
            (The Jewel of a Woman): "They said: 'O Demon King! She is a jewel among women, with perfect features illuminating all directions'."
            "'She is currently residing on the Himalayas; You rightfully deserve to go and see Her for yourself'."
            "Here, the Goddess is addressed as 'Stri-ratna' (A Jewel among women) by the demonic messengers."
            "Arrogance perceives everything—be it a human or wisdom—strictly as a 'Jewel' or a material 'Asset'."
            "'Aticharvangi' (Beautiful limbs) proves that ignorance remains perpetually stuck on external physical appearances."
            "They are capable of seeing the Radiance (Tvisha), but they are blind to the 'Death' hidden behind that light."
            "When Truth (Goddess) manifests, it shines so intensely that concealing it is mathematically impossible."
            "Addressing Shumbha as 'Daityendra' is a manipulative tactic to soothe his underlying cosmic Insecurity."
            "Ego perpetually craves flattery to validate its impulsive and righteous-sounding wrong decisions."
            "The Goddess currently appears as the 'Prey', while in reality, She is the absolute ultimate 'Hunter'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 46,
        sanskrit = "यानि रत्नानि मणयो गजादीनि च ते गृहे ।\nत्रैलोक्ये तु समस्तानि सम्प्रतीह मया विभो ॥ ९३ ॥",
        hindi = """
            (संपत्ति का बखान): "चण्ड-मुण्ड ने कहा: 'हे प्रभु! आपके घर में तो तीनों लोकों के सबसे श्रेष्ठ रत्न, मणियां और हाथी मौजूद हैं'।"
            "'पूरे ब्रह्मांड की सबसे कीमती चीज़ें तो अभी आपके ही कब्ज़े में हैं'।"
            "यह श्लोक उस 'कलेक्शन' (Collection) को दिखाता है जो एक अहंकारी व्यक्ति ने अपनी ताकत से इकट्ठा किया होता है।"
            "अहंकार को अपनी 'लिस्ट' (List) बहुत पसंद होती है—मेरे पास क्या-क्या है (Possessions)।"
            "रत्न, मणियां और हाथी इंसान की सफलता, बुद्धि और शक्ति के भौतिक प्रतीक (Physical Symbols) हैं।"
            "परंतु अज्ञानी इंसान यह भूल जाता है कि ये सब 'बाहरी' (External) चीज़ें हैं, जो कभी भी छिन सकती हैं।"
            "शुम्भ को यह याद दिलाया जा रहा है कि वह 'विभो' (Powerful) है, ताकि उसे अपनी अजेयता का भ्रम बना रहे।"
            "जब हमें अपनी पिछली सफलताओं की याद दिलाई जाती है, तो हम अपनी अगली गलती करने के लिए और ज़्यादा उतावले हो जाते हैं।"
            "तीनों लोकों पर कब्ज़ा होना यह बताता है कि ईगो ने हमारी सारी इंद्रियों और मन को पूरी तरह कंट्रोल कर लिया है।"
            "अब केवल एक ही चीज़ की कमी थी, जो उन राक्षसों ने अब ढूंढ ली थी।"
        """.trimIndent(),
        english = """
            (Description of Wealth): "Chanda and Munda said: 'O Lord! Your palace already contains the finest jewels, gems, and elephants of all three worlds'."
            "'Strictly all the most precious objects of the entire cosmos are currently under Your absolute possession'."
            "This verse illustrates the 'Collection' of trophies that an arrogant person accumulates through brute force."
            "The Ego loves its 'List' of accomplishments—the constant mental tally of its worldly Possessions."
            "Jewels, gems, and elephants are physical Symbols of a human's success, intelligence, and raw power."
            "However, the ignorant human entirely forgets that these are 'External' objects that can be snatched away instantly."
            "Shumbha is reminded that he is 'Vibho' (All-powerful) to sustain his delusion of absolute invincibility."
            "When we are reminded of our past successes, we become aggressively impatient to commit our next major mistake."
            "Possessing all three worlds implies that the Ego has completely hijacked all our senses and mental faculties."
            "There was strictly only one piece missing from his collection, which the demons had now successfully found."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 47,
        sanskrit = "ऐरावतः समानीतो गजरत्नं पुरन्दरात् ।\nपारिजाततरुश्चायं तथैवोच्चैःश्रवा हयः ॥ ९४ ॥",
        hindi = """
            (छीनी हुई चीज़ों की सूची): "चण्ड-मुण्ड ने गिनाया: 'आपने इन्द्र (पुरन्दरात्) से गजों में रत्न 'ऐरावत हाथी' को छीन लिया है'।"
            "'स्वर्ग का दिव्य 'पारिजात वृक्ष' और घोड़ों में श्रेष्ठ 'उच्चैःश्रवा' घोड़ा भी अब आपके ही पास है'।"
            "यह श्लोक 'अहंकार की लूट' (Loot of Ego) का विवरण है।"
            "ऐरावत 'मानसिक शक्ति' का प्रतीक है, पारिजात 'इच्छा पूर्ति' का और उच्चैःश्रवा 'विचारों की गति' का।"
            "जब बुराई (शुम्भ) हावी होती है, तो वह हमारी अच्छी यादों, सपनों और तेज़ बुद्धि—सब पर अपना ठप्पा लगा देती है।"
            "इंसान को लगता है कि उसने अपनी मेहनत से ये सब पाया है, पर वास्तव में उसने इन्हें 'इन्द्र' (सद्गुणों) से छीना होता है।"
            "ये तीनों चीज़ें 'दुर्लभ' (Rare) हैं, और अहंकार केवल दुर्लभ चीज़ों को ही अपना बनाना चाहता है।"
            "शुम्भ के पास सब कुछ था, पर शांति (देवी) नहीं थी, और यही उसकी सबसे बड़ी कमजोरी थी।"
            "चीज़ों को 'समानीतः' (इकट्ठा करना) ही अज्ञान की सबसे बड़ी हॉबी (Hobby) है।"
            "परंतु चीज़ें पास होने से इंसान 'बड़ा' नहीं होता, उसका चरित्र (Character) उसे बड़ा बनाता है।"
        """.trimIndent(),
        english = """
            (List of Seized Objects): "Chanda-Munda listed: 'You have snatched the jewel among elephants, 'Airavata', from Indra himself'."
            "'The divine 'Parijata Tree' of heaven and the greatest horse 'Uchhaishrava' are also now in Your control'."
            "This verse provides a detailed ledger of the 'Loot of the Ego' across the spiritual dimensions."
            "Airavata symbolizes 'Mental Strength', Parijata represents 'Wish Fulfillment', and Uchhaishrava is the 'Speed of Thought'."
            "When evil (Shumbha) dominates, it forcefully claims ownership over our good memories, dreams, and intellect."
            "A human falsely assumes he earned these through merit, while in reality, he snatched them from his inner 'Indra' (Virtues)."
            "These three objects are 'Rare', and arrogance perpetually targets only the most exclusive items to feed its pride."
            "Shumbha possessed everything material, but lacked 'Peace' (Goddess), which was his absolute greatest weakness."
            "The act of 'Samanitah' (Accumulating) is the primary hobby of deep-seated cosmic ignorance."
            "However, possessing objects does zero to make a human 'Great'; strictly only Character defines true greatness."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 48,
        sanskrit = "विमानं हंससंयुक्तमेतत्तिष्ठति ते अङ्गण ।\nरत्नभूतं विनिर्गतं यदासीद् वेधसो गृहात् ॥ ९५ ॥",
        hindi = """
            (ब्रह्मा का विमान): "चण्ड-मुण्ड बोले: 'महाराज! हंसों से जुता हुआ वह दिव्य विमान (हंससंयुक्तम्) भी अब आपके आंगन में खड़ा है'।"
            "'जो पहले ब्रह्मा जी (वेधसो) के पास था और पूरे ब्रह्मांड में एक अद्भुत रत्न के समान था'।"
            "हंस 'विवेक' (Discrimination) का प्रतीक है—वह जो दूध और पानी को अलग कर देता है।"
            "जब अहंकार (शुम्भ) बहुत शक्तिशाली हो जाता है, तो वह इंसान के 'विवेक' (हंस विमान) को भी अपनी कैद में कर लेता है।"
            "अब इंसान अपनी बुद्धि का इस्तेमाल केवल खुद को सही साबित करने और दूसरों को दबाने के लिए करता है।"
            "ब्रह्मा जी का विमान 'सृजनात्मकता' (Creativity) का प्रतीक है, जो अब अज्ञान के 'आंगन' (Grip) में है।"
            "यह दृश्य बताता है कि कैसे बुराई हमारी सबसे पवित्र शक्तियों को भी अपने फायदे के लिए इस्तेमाल करने लगती है।"
            "अहंकार को लगता है कि वह अब 'क्रिएटर' (Creator) के बराबर पहुँच गया है।"
            "पर विमान होने का मतलब यह नहीं कि आप 'उड़ना' (Fly) जानते हैं, उसे चलाने के लिए 'पात्रता' (Eligibility) चाहिए।"
            "शुम्भ की लिस्ट अब पूरी होने वाली है, बस अंतिम आहुति बाकी है।"
        """.trimIndent(),
        english = """
            (Brahma's Chariot): "Chanda-Munda stated: 'O King! That divine aerial vehicle yoked with swans also stands in Your courtyard'."
            "'Which previously belonged to Lord Brahma and was considered a unique jewel across the entire universe'."
            "The Swan (Hamsa) symbolizes the power of 'Discrimination'—the capacity to separate Truth from Falsehood."
            "Exactly when Arrogance (Shumbha) becomes omnipotent, it imprisons even the human's 'Wisdom' (The Swan Chariot)."
            "Now, the human utilizes his intellect strictly to validate himself and aggressively suppress others."
            "Lord Brahma's chariot represents 'Creativity', which is now trapped within the 'Courtyard' (Grip) of ignorance."
            "This scene demonstrates how evil begins to exploit even our most sacred internal powers for personal gain."
            "The toxic Ego falsely believes it has now achieved the status of the absolute 'Creator' (Brahma)."
            "But possessing a chariot does zero to mean you know how to 'Fly'; flying strictly requires spiritual 'Eligibility'."
            "Shumbha's inventory of seized assets is reaching its limit; only the final offering remains missing."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 49,
        sanskrit = "निधिरेष महापद्मः समानीतो धनेश्वरात् ।\nकिञ्जल्किनीं ददौ चाब्धिर्मलानामम्लानपङ्कजाम् ॥ ९६ ॥",
        hindi = """
            (कुबेर की निधि और समुद्र का उपहार): "चण्ड-मुण्ड ने कहा: 'आपने कुबेर (धनेश्वरात्) से 'महापद्म' नामक महान निधि को भी जीत लिया है'।"
            "'और समुद्र (अब्धिः) ने आपको कभी न कुम्हलाने वाले कमलों की माला 'किंजल्किनी' भेंट की है'।"
            "महापद्म निधि 'असीमित ऊर्जा' (Infinite Energy) और संसाधनों का प्रतीक है।"
            "कमलों की माला (किंजल्किनी) उस 'सुंदरता' का प्रतीक है जो अज्ञान (समुद्र) ने मजबूरी में अहंकार को दी है।"
            "शुम्भ ने प्रकृति (समुद्र) और धन (कुबेर) दोनों को अपना गुलाम बना लिया था।"
            "जब इंसान के पास बहुत पैसा और रिसोर्स (निधि) होते हैं, तो उसे लगता है कि वह अमर (Immortal) हो गया है।"
            "परंतु ये 'अम्लान' (कभी न मुरझाने वाले) कमल भी शुम्भ के विनाश को नहीं रोक सकते।"
            "यह श्लोक दिखाता है कि अहंकार ने जीवन के हर सुंदर और कीमती हिस्से पर अपना अधिकार जमा लिया है।"
            "वह अब दुनिया का सबसे अमीर और ताकतवर व्यक्ति बन चुका है, पर उसकी आत्मा अभी भी भूखी है।"
            "यही वह 'मिसिंग लिंक' (Missing Link) है जिसे वह अब देवी में देख रहा है।"
        """.trimIndent(),
        english = """
            (Kubera's Treasure and Ocean's Gift): "Chanda-Munda added: 'You have seized the great treasure named 'Mahapadma' from Kubera himself'."
            "'And the Ocean has offered You 'Kinshalkini', the garland of lotuses that strictly never fade'."
            "The Mahapadma Treasure symbolizes 'Infinite Energy' and the absolute peak of worldly resources."
            "The garland (Kinshalkini) represents that 'Beauty' which Nature (Ocean) offered to the ego out of compulsion."
            "Shumbha had successfully enslaved both the forces of Nature (Ocean) and Wealth (Kubera)."
            "When a human possesses excessive money and resources, he deludes himself into thinking he is physically Immortal."
            "However, even these 'Unfading' (Amlana) lotuses cannot mathematically prevent Shumbha's upcoming annihilation."
            "This verse proves that Arrogance has established total dominance over every beautiful part of existence."
            "He has become the wealthiest and most powerful entity in the world, yet his soul remains desperately hungry."
            "This hunger is the 'Missing Link' that he now desperately seeks to satisfy through the Goddess."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 50,
        sanskrit = "छत्रं ते वारुणं गेहे काञ्चनस्त्रावि तिष्ठति ।\nतथायं स्यन्दनवरो यः पुरासीत् प्रजापतेः ॥ ९७ ॥",
        hindi = """
            (वरुण का छत्र और प्रजापति का रथ): "चण्ड-मुण्ड ने सूची पूरी की: 'वरुण देव का वह छत्र (छाता) जो सोने की वर्षा करता है, आपके महल में है'।"
            "'और प्रजापति का वह सबसे श्रेष्ठ रथ (स्यन्दनवरो) भी अब आपकी ही सवारी के लिए तैयार खड़ा है'।"
            "छत्र (Umbrella) 'सुरक्षा' (Protection) और 'सम्मान' का प्रतीक है—शुम्भ को लगता है कि वह अब पूरी तरह सुरक्षित है।"
            "वरुण जल के देवता हैं, उनका छत्र इंसान की 'भावनात्मक सुरक्षा' (Emotional Security) का प्रतीक है।"
            "प्रजापति का रथ उस 'ड्राइविंग फोर्स' का प्रतीक है जो सृष्टि को आगे बढ़ाती है।"
            "जब अहंकार ये सब पा लेता है, तो उसे लगता है कि अब उससे ऊपर ब्रह्मांड में कोई नहीं है।"
            "वह अब खुद को 'प्रजापति' (ब्रह्मांड का पिता) समझने की गलती कर रहा है।"
            "यह श्लोक अज्ञान के 'चरम शिखर' (The Absolute Peak) को दर्शाता है।"
            "शुम्भ के पास अब सब कुछ है—इन्द्र की ताकत, ब्रह्मा का विवेक, कुबेर का धन और वरुण की सुरक्षा।"
            "परंतु जिसके पास 'देवी' (सत्य) नहीं है, उसके पास वास्तव में कुछ भी नहीं है।"
        """.trimIndent(),
        english = """
            (Varuna's Canopy and Prajapati's Chariot): "Chanda-Munda finished: 'Varuna's divine canopy that showers gold is now inside Your palace'."
            "'And the supreme chariot of Prajapati also stands ready exclusively for Your personal travel'."
            "The Canopy (Umbrella) symbolizes absolute 'Protection' and 'Honor'—Shumbha feels he is now totally invincible."
            "Varuna is the Lord of Water; his canopy represents a human's ultimate 'Emotional Security'."
            "Prajapati's Chariot symbolizes the fundamental 'Driving Force' that propels the entire creation forward."
            "Exactly when Ego acquires all these assets, it falsely assumes that zero power exists above it in the cosmos."
            "He is now committing the fatal mistake of perceiving himself as 'Prajapati' (The Father of the Universe)."
            "This specific verse demonstrates the absolute 'Extreme Peak' of human and cosmic ignorance."
            "Shumbha now holds everything—Indra's power, Brahma's wisdom, Kubera's wealth, and Varuna's security."
            "However, the human who does zero possess 'The Goddess' (Truth), mathematically possesses absolutely nothing."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 51,
        sanskrit = "मृत्योः शक्त्याख्यां गदां तद्वदादत्तं पाशमेव च ।\nसमस्तं रत्नजातं च निशुम्भस्याब्धिजा विभो ॥ ९८ ॥",
        hindi = """
            (यम की गदा और निशुम्भ का वैभव): "चण्ड-मुण्ड ने कहा: 'हे विभो! आपने साक्षात् मृत्यु के देवता यम की 'शक्ति' नामक गदा छीन ली है'।"
            "'वरुण का वह अमोघ पाश भी अब आपके ही अधीन है, जिससे आप किसी को भी बांध सकते हैं'।"
            "'और समुद्र से उत्पन्न होने वाले जितने भी रत्न और मणियां हैं, उन पर अब निशुम्भ का अधिकार है'।"
            "यम की गदा 'अनुशासन' और 'मृत्यु के भय' का प्रतीक है, जिस पर अब अहंकार ने कब्ज़ा कर लिया है।"
            "जब इंसान का ईगो बहुत बढ़ जाता है, तो उसे मौत का डर भी लगना बंद हो जाता है (झूठी निडरता)।"
            "वरुण का पाश 'नियंत्रण' का प्रतीक है—अहंकार अब दूसरों की स्वतंत्रता को बांधने की ताकत रखता है।"
            "निशुम्भ (ममता) के पास समुद्र के सारे रत्न होने का अर्थ है कि मोह ने सारी सुंदरता को जकड़ लिया है।"
            "इंसान को लगता है कि वह इन अस्त्रों से ब्रह्मांड को कंट्रोल कर सकता है, पर वह खुद अपनी माया में फंस जाता है।"
            "यह श्लोक अज्ञान के उस साम्राज्य को पूरा करता है जहाँ धर्म के सारे उपकरण अब अधर्म के हाथ में हैं।"
            "जब शक्ति का स्रोत बदल जाता है, तो पूरी सृष्टि में केवल अहंकार का ही शोर सुनाई देने लगता है। "
        """.trimIndent(),
        english = """
            (Yama's Mace and Nishumbha's Glory): "Chanda-Munda reported: 'O Lord! You have seized the heavy mace named 'Shakti' from the God of Death, Yama'."
            "'Varuna's invincible noose is also under Your command, granting You the power to bind anyone at will'."
            "'And absolutely all the jewels and treasures born from the ocean are now under the possession of Nishumbha'."
            "Yama's mace symbolizes 'Discipline' and the 'Fear of Death', which have now been hijacked by the Ego."
            "When a human's ego expands excessively, he loses the natural healthy fear of death, creating a false sense of invincibility."
            "Varuna's noose represents 'Control'—arrogance now holds the capacity to bind the freedom of others."
            "Nishumbha (Attachment) possessing ocean gems implies that obsessive possession has gripped all worldly beauty."
            "A human falsely assumes he can control the cosmos with these tools, while he actually entangles himself deeper in Maya."
            "This verse completes the map of an ignorant empire where all tools of Dharma are in the hands of Adharma."
            "When the source of power shifts to the ego, only the noise of arrogance resonates throughout the entire creation."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 52,
        sanskrit = "अग्निरपि ददौ तुभ्यं वाससी द्वे विशुद्धके ।\nएवं दैत्येन्द्र रत्नानि समस्तान्याहृतानि ते ॥ ९९ ॥",
        hindi = """
            (अग्नि के वस्त्र और निष्कर्ष): "उन्होंने सूची समाप्त की: 'अग्नि देव ने भी आपको दो अत्यंत पवित्र और दिव्य वस्त्र भेंट किए हैं'।"
            "'हे दैत्यराज! इस प्रकार ब्रह्मांड की जितनी भी श्रेष्ठ वस्तुएं और रत्न थे, वे सब अब आपके पास आ चुके हैं'।"
            "अग्नि के वस्त्र 'तेज़' और 'पवित्रता' के प्रतीक हैं, जिन्हें अब अहंकार ने ओढ़ लिया है।"
            "अहंकारी व्यक्ति अक्सर खुद को बहुत 'पवित्र' और 'सही' दिखाने का ढोंग करता है (आध्यात्मिक अहंकार)।"
            "जब इंसान खुद को सही मान लेता है, तो वह सुधार की सारी संभावनाओं को हमेशा के लिए बंद कर देता है।"
            "रत्नानि समस्तान्याहृतानि—शुम्भ अब दुनिया का सबसे 'सफल' व्यक्ति महसूस कर रहा है क्योंकि उसके पास सब कुछ है।"
            "परंतु यह सफलता महज़ एक 'कलेक्शन' है, इसमें आत्मा की संतुष्टि का कोई स्थान नहीं है।"
            "चण्ड-मुण्ड का यह रिपोर्ट देना शुम्भ के अहंकार को उस बिंदु तक ले जाना है जहाँ से पतन निश्चित है।"
            "जब लिस्ट पूरी हो जाती है, तो इंसान को लगता है कि अब उसे और कुछ नहीं चाहिए, सिवाय 'परम सुख' के।"
            "यही वह क्षण है जब अहंकार उस 'शक्ति' (देवी) को पाना चाहता है जो उसे वास्तव में कभी नहीं मिल सकती।"
        """.trimIndent(),
        english = """
            (Fire's Raiment and Conclusion): "They concluded the list: 'The God of Fire has also offered You two exceptionally pure and divine garments'."
            "'O Demon King! In this manner, every single precious object and jewel of the cosmos has been gathered by You'."
            "The garments of Fire symbolize 'Radiance' and 'Purity', which have now been assumed as a mask by the Ego."
            "An arrogant person often pretends to be extremely 'Pure' and 'Righteous' to validate his toxic actions."
            "When a human considers himself absolutely right, he permanently shuts down all possibilities of self-improvement."
            "By gathering all jewels, Shumbha now feels like the absolute most 'Successful' entity in existence."
            "However, this success is merely a physical 'Collection'; it holds zero space for actual soulful fulfillment."
            "The reporting by Chanda-Munda pushes Shumbha's ego to that specific peak from which a fall is mathematically certain."
            "Once the material list is complete, the human mind feels it requires nothing more except 'Supreme Bliss'."
            "This is the exact moment when Arrogance desires to possess that 'Power' (Goddess) which can never be enslaved."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 53,
        sanskrit = "स्त्रीरत्नमेषा कल्याणी त्वया कस्मान्न गृह्यते ।\nसा तु चित्रं प्रभावैः स्वैर्भासयन्ती हिमाचलम् ॥ १०० ॥",
        hindi = """
            (देवी को रत्न कहना): "चण्ड-मुण्ड ने उकसाया: 'तो फिर वह कल्याणी स्त्री-रत्न आपके द्वारा क्यों नहीं अपनाया जा रहा?'"
            "'वह तो अपने अद्भुत और दिव्य प्रभावों से पूरे हिमालय पर्वत को प्रकाशित कर रही है'।"
            "यहाँ 'कल्याणी' शब्द का प्रयोग मज़ाक जैसा है—वे उसके असली मंगलकारी स्वरूप को पहचान ही नहीं पाए।"
            "अज्ञान हमेशा सत्य को केवल एक 'रत्न' (Asset) समझता है जिसे अपनी तिजोरी में बंद किया जा सके।"
            "अहंकार को लगता है कि अगर मेरे पास सब कुछ है, तो यह सुंदर शक्ति (देवी) भी मेरे ही पास होनी चाहिए।"
            "हिमाचल को प्रकाशित करना (Bhasayanti) यह बताता है कि ज्ञान कभी छुपकर नहीं रहता, वह खुद को ज़ाहिर कर देता है। "
            "इंसान जब अपनी सफलताओं को गिनता है, तो वह 'सबसे कीमती' चीज़ (शांति) की कमी महसूस करने लगता है।"
            "चण्ड-मुण्ड यहाँ 'लोभ' की उस आग को भड़का रहे हैं जो शुम्भ को उसके विनाश की ओर ले जाएगी।"
            "यह श्लोक दिखाता है कि कैसे बुरी प्रवृत्तियां इंसान को गलत रास्ते पर जाने के लिए तर्क (Logic) देती हैं।"
            "अहंकार अब उस रोशनी की तरफ दौड़ने वाला है जो वास्तव में उसे जलाने वाली आग है।"
        """.trimIndent(),
        english = """
            (Calling the Goddess a Jewel): "Chanda-Munda provoked: 'Then why is that auspicious jewel of a woman not being seized by You?'"
            "'She is illuminating the entire Himalayas with Her astonishing and divine cosmic influence'."
            "Using the word 'Kalyani' (Benevolent) is ironic here—they utterly failed to recognize Her true divine nature."
            "Ignorance perpetually mistakes Absolute Truth for a mere 'Jewel' (Asset) to be locked in a private vault."
            "Arrogance assumes that since it possesses everything else, this beautiful power (Goddess) must also be its slave."
            "Illuminating the mountain (Bhasayanti) proves that Wisdom never remains hidden; it naturally reveals its presence."
            "When a human counts his material successes, he begins to feel the desperate lack of the 'Most Precious' thing: Peace."
            "Chanda and Munda are fanning the flames of 'Greed' that will lead Shumbha directly toward his annihilation."
            "This verse demonstrates how toxic inner tendencies provide false logic to push a human toward ruin."
            "Arrogance is now preparing to run toward that Light which is actually the fire destined to incinerate it."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 54,
        sanskrit = "दृष्टैव सा त्वया देवी रूपं चास्या मनोहरम् ।\nयथा तद् द्योतितं देव दिशो दश च भासा ॥ १०१ ॥",
        hindi = """
            (रूप का वर्णन): "उन्होंने आगे कहा: 'हे राजन्! आपको स्वयं चलकर उस देवी और उनके मनमोहक रूप को देखना चाहिए'।"
            "'उनकी देह की कांति से दसों दिशाएं एक साथ प्रकाशित हो रही हैं'।"
            "दशों दिशाओं (Dasha Disha) का प्रकाशित होना चेतना की 'सर्वव्यापकता' का भौतिक संकेत है।"
            "अज्ञान को केवल 'चमक' (Brightness) दिखाई देती है, उसके पीछे की 'गहराई' (Depth) नहीं।"
            "अहंकार हमेशा बाहरी दिखावे और आकर्षण (Physical Attraction) की ओर खिंचा चला जाता है।"
            "चण्ड-मुण्ड की रिपोर्टिंग शुम्भ के मन में एक ऐसी 'इमेज' बना रही है जो उसे बेचैन कर देगी।"
            "जब हम सत्य को केवल उसकी चमक के लिए पाना चाहते हैं, तो हम उसे कभी समझ नहीं पाते।"
            "सत्य का प्रकाश दसों दिशाओं में फैलने का मतलब है कि अब अज्ञान के छुपने के लिए कोई जगह नहीं बची है।"
            "शुम्भ को लग रहा है कि वह उसे 'देखने' जा रहा है, पर असल में वह अपनी 'मौत' का सामना करने जा रहा है।"
            "यह श्लोक अज्ञानी मन की उस उत्सुकता को दर्शाता है जो विनाशकारी साबित होने वाली है।"
        """.trimIndent(),
        english = """
            (Description of Form): "They continued: 'O King! You must personally go and witness that Goddess and Her enchanting form'."
            "'The radiance of Her body is illuminating all the ten directions simultaneously'."
            "The illumination of 'Ten Directions' is a physical indicator of the absolute Omnipresence of Consciousness."
            "Ignorance only perceives the 'Brightness' (Radiance) but remains blind to the underlying 'Depth' (Wisdom)."
            "Arrogance is perpetually drawn toward external appearances and superficial physical attractions."
            "The reporting by Chanda-Munda is constructing a mental image in Shumbha that will make him restless."
            "When we desire Truth only for its external glory, we mathematically fail to ever comprehend its essence."
            "Truth spreading in all directions implies that zero space now remains for ignorance to hide in the cosmos."
            "Shumbha believes he is going to 'Witness' beauty, while he is actually moving to confront his own 'Death'."
            "This verse illustrates the fatal curiosity of an ignorant mind that is destined to prove destructive."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 55,
        sanskrit = "सा त्वया गृह्यतां देव सर्वामरमयि प्रभो ।\nइति चण्डमुण्डाभ्यां प्रयुक्तोऽथ स दैत्यराट् ॥ १०२ ॥",
        hindi = """
            (गृह्यतां - अपनाने का सुझाव): "चण्ड-मुण्ड ने अपनी बात पूरी की: 'हे प्रभो! वह साक्षात् देवमयी है, उसे आप अवश्य अपनी पत्नी बना लें'।"
            "महर्षि मेधा ने कहा: 'चण्ड और मुण्ड के इन वचनों को सुनकर वह दैत्यराज शुम्भ अत्यंत उत्सुक हो उठा'।"
            "यहाँ 'गृह्यतां' (Grab it) शब्द अज्ञान की उस मानसिकता को दिखाता है जो हर सुंदर चीज़ को 'प्रॉपर्टी' (Property) समझती है।"
            "अहंकार प्रेम करना नहीं जानता, वह केवल 'अधिकार' (Ownership) जमाना जानता है।"
            "शुम्भ को 'दैत्यराट्' (King of Demons) कहकर संबोधित करना उसके झूठे गौरव को हवा देना है।"
            "जब इंसान अपने आस-पास के चाटुकारों (Flatterers) की बात सुनता है, तो वह अपनी बुद्धि खो बैठता है।"
            "शुम्भ को लगा कि वह ब्रह्मांड की 'प्राइमल एनर्जी' (देवी) को भी अपनी दासी बना सकता है।"
            "यह उस भ्रम का चरम है जहाँ जीव खुद को 'ईश्वर' से भी ऊपर समझने लगता है।"
            "चण्ड-मुण्ड की बातों ने शुम्भ के भीतर छिपी हुई 'वासना' (Lust) और 'घमंड' को पूरी तरह सक्रिय कर दिया।"
            "अब शुम्भ ने देवी के पास अपना संदेश भेजने का मन बना लिया है।"
        """.trimIndent(),
        english = """
            (Suggestion to Seize): "Chanda-Munda concluded: 'O Lord! She is the essence of divinity; You must certainly make Her Yours'."
            "The Sage Medha said: 'Upon hearing these words from Chanda and Munda, the Demon King Shumbha became extremely curious'."
            "The word 'Grihyatam' (Seize/Grab) reveals the ignorant mindset that treats every beautiful object as 'Property'."
            "Arrogance does zero to understand Love; it strictly knows how to establish absolute 'Ownership'."
            "Addressing Shumbha as 'Daityarat' (King of Demons) serves to fuel his false pride and grandiosity."
            "When a human listens to sycophants and flatterers around him, he loses his fundamental power of discernment."
            "Shumbha deluded himself into thinking he could enslave even the 'Primal Energy' (Goddess) of the universe."
            "This is the peak of delusion where the individual self starts perceiving itself as superior to the Divine."
            "The words of Chanda-Munda fully activated the latent 'Lust' and 'Arrogance' residing within Shumbha."
            "Now Shumbha has firmly resolved to send his messenger to the Goddess with a formal proposal."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 56,
        sanskrit = "प्रेषयामास सुग्रीवं दूतं देव्या महासुरम् ।\nइति चेति च वक्तव्या सा गत्वा वचनान्मम ॥ १०३ ॥",
        hindi = """
            (सुग्रीव दूत की नियुक्ति): "तब शुम्भ ने 'सुग्रीव' नामक एक महान असुर को दूत बनाकर देवी के पास भेजने का निश्चय किया।"
            "शुम्भ ने दूत को आदेश दिया: 'वहाँ जाओ और मेरी आज्ञा से उस देवी से यह और वह (तर्कपूर्ण) बातें कहना'।"
            "सुग्रीव यहाँ 'तर्क' (Logic) और 'डिप्लोमेसी' (Diplomacy) का प्रतीक है—अहंकार पहले प्यार से समझाना चाहता है।"
            "शुम्भ सीधा युद्ध नहीं करना चाहता, वह चाहता है कि सत्य (देवी) खुद उसके सामने सरेंडर कर दे।"
            "'इति चेति'—इसका अर्थ है कि शुम्भ ने दूत को पूरी ट्रेनिंग दी कि उसे क्या और कैसे बोलना है।"
            "अहंकार बहुत चतुर (Cunning) होता है; वह अपनी मांगों को बहुत ही मीठे शब्दों में पेश करता है।"
            "सुग्रीव का अर्थ है 'जिसका गला सुंदर हो', यानी जो बहुत मीठी और प्रभावशाली बातें कर सकता हो।"
            "जब अज्ञान किसी को लुभाना चाहता है, तो वह 'तर्क' (Reasoning) का सहारा लेता है।"
            "शुम्भ को पूरा विश्वास है कि उसकी दौलत और ताकत की बातें सुनकर देवी मान जाएंगी।"
            "यह श्लोक उस 'ईगो-डिप्लोमेसी' (Ego Diplomacy) की शुरुआत है जो अंततः फेल होने वाली है।"
        """.trimIndent(),
        english = """
            (Appointment of Sugriva): "Then Shumbha decided to dispatch a great demon named 'Sugriva' as a messenger to the Goddess."
            "Shumbha commanded the messenger: 'Go there and, by my order, speak these specific logical words to Her'."
            "Sugriva symbolizes 'Logic' and 'Diplomacy'—arrogance first attempts to persuade through manipulation."
            "Shumbha does zero to desire direct war; he wants Truth (Goddess) to voluntarily surrender to him."
            "'Iti Cheti' implies that Shumbha provided rigorous training to the messenger on what and how to speak."
            "Arrogance is exceptionally Cunning; it presents its demands utilizing very sweet and sophisticated vocabulary."
            "The name Sugriva translates to 'one with a beautiful throat', signifying someone who speaks persuasively."
            "When ignorance seeks to lure someone, it heavily relies on 'Reasoning' and logical fallacies."
            "Shumbha is entirely confident that hearing about his wealth and power will convince the Goddess to yield."
            "This verse marks the initiation of 'Ego Diplomacy', which is mathematically destined to fail."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 57,
        sanskrit = "यथा चाभ्येति प्रीत्या सा तथा कार्यं त्वया लघु ।\nस तत्र गत्वा यत्रास्ते देवी धरणीपृष्ठ उज्ज्वले ॥ १०४ ॥",
        hindi = """
            (दूत को निर्देश): "शुम्भ ने कहा: 'तुम ऐसा उपाय करना जिससे वह देवी जल्दी (लघु) और प्रेमपूर्वक (प्रीत्या) मेरे पास आ जाएं'।"
            "'वह दूत सुग्रीव तुरंत वहाँ गया जहाँ पृथ्वी के एक अत्यंत उज्ज्वल स्थान पर देवी विराजमान थीं'।"
            "अहंकार चाहता है कि सब कुछ उसकी 'शर्तों' पर और 'आसानी' से हो जाए।"
            "शुम्भ को लगता है कि वह देवी के प्रेम (Preetya) को 'खरीद' सकता है या अपनी बातों से 'प्रभावित' कर सकता है।"
            "धरणीपृष्ठ उज्ज्वले—माता पृथ्वी के उस स्थान पर हैं जो अत्यंत 'उज्ज्वल' (Pure/Radiant) है।"
            "सत्य हमेशा ऊँचाई और शुद्धता के स्थान पर ही टिकता है, जहाँ अज्ञान का प्रवेश कठिन है।"
            "सुग्रीव (तर्क) वहाँ पहुँच तो गया, पर वह उस 'उज्ज्वलता' को समझ नहीं पाया।"
            "दूत का काम संदेश पहुँचाना है, पर यहाँ दूत खुद भी देवी के तेज़ से भयभीत होने वाला है।"
            "अहंकार जब सत्य के क्षेत्र में प्रवेश करता है, तो उसकी सारी चालाकी धरी की धरी रह जाती है।"
            "अब सुग्रीव अपना वह भाषण शुरू करेगा जो शुम्भ ने उसे रटाया है।"
        """.trimIndent(),
        english = """
            (Instructions to the Messenger): "Shumbha said: 'Act in a manner so that She approaches me quickly (Laghu) and affectionately (Preetya)'."
            "'That messenger Sugriva immediately traveled to the spot where the Goddess resided on a radiant part of the earth'."
            "Arrogance demands that everything should happen according to its 'Terms' and with total 'Ease'."
            "Shumbha deludes himself into thinking he can 'Buy' the Goddess's affection or 'Impress' Her with words."
            "The phrase 'Dharani-prishthe Ujjwale' indicates the Goddess is in a location of absolute 'Radiance' and Purity."
            "Truth perpetually resides in a state of high vibration and purity, where ignorance struggles to enter."
            "Sugriva (Logic) successfully reached the location, but he was incapable of comprehending that 'Radiance'."
            "The messenger's job is to deliver data, but here the messenger himself will be terrified by the Divine glow."
            "When arrogance enters the territory of Truth, all its sophisticated cunningness becomes mathematically useless."
            "Now Sugriva is officially preparing to deliver the scripted speech that Shumbha has memorized for him."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 58,
        sanskrit = "जगाद मधुरां वाचं सप्रश्रयमतिश्लक्ष्णाम् ।\nदूत उवाच ॥ १०५ ॥",
        hindi = """
            (मधुर वाणी): "वहाँ पहुँचकर उस दूत ने अत्यंत 'मधुर' (मधुरां), 'विनम्र' (सप्रश्रय) और 'कोमल' (अतिश्लक्ष्णाम्) वाणी में बोलना शुरू किया।"
            "दूत सुग्रीव ने कहा: (देवी को लुभाने के लिए उसने अपने स्वर में बहुत मिठास भर ली थी)।"
            "यह 'मैनिपुलेशन' (Manipulation) की कला है—जब कड़वी बात को शहद में लपेट कर कहा जाता है।"
            "सुग्रीव जानता है कि वह साक्षात् शक्ति से बात कर रहा है, इसलिए वह उसे गुस्सा नहीं दिलाना चाहता।"
            "विनम्रता (Humility) यहाँ सच्ची नहीं है, बल्कि यह एक 'रणनीति' (Strategy) का हिस्सा है।"
            "अहंकार अक्सर शुरुआत में बहुत 'हम्बल' (Humble) होने का नाटक करता है ताकि सामने वाले का 'गार्ड' (Guard) गिर जाए।"
            "वह देवी को 'इम्प्रेस' करने की कोशिश कर रहा है ताकि वह बिना युद्ध के ही महल में चलने को तैयार हो जाएं।"
            "यह श्लोक सिखाता है कि मीठी बातें करने वाला हर व्यक्ति आपका शुभचिंतक नहीं होता।"
            "कभी-कभी सबसे खतरनाक इरादे सबसे सुंदर शब्दों के पीछे छिपे होते हैं।"
            "अब सुग्रीव शुम्भ का वह परिचय देगा जो घमंड और ऐश्वर्य से भरा हुआ है।"
        """.trimIndent(),
        english = """
            (Sweet Speech): "Upon arriving, the messenger began to speak in an exceptionally 'Sweet', 'Respectful', and 'Smooth' voice."
            "Messenger Sugriva said: (He infused extreme sweetness into his tone strictly to charm and lure the Goddess)."
            "This represents the peak art of 'Manipulation'—when a bitter intention is wrapped in layers of linguistic honey."
            "Sugriva realizes he is addressing the Primal Power, so he carefully avoids triggering any immediate wrath."
            "The displayed humility is zero percent authentic; it is strictly a component of a larger deceptive 'Strategy'."
            "Arrogance frequently pretends to be 'Humble' in the beginning strictly to make the opponent drop their 'Guard'."
            "He is desperately attempting to 'Impress' the Goddess so She agrees to enter the palace without resistance."
            "This verse teaches that not every individual speaking sweet words is necessarily your genuine well-wisher."
            "Sometimes the absolute most dangerous intentions are concealed behind the absolute most beautiful vocabulary."
            "Now Sugriva will present Shumbha's introduction, which is overflowing with pride and material glory."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 59,
        sanskrit = "देवि दैत्येश्वरः शुम्भस्त्रैलोक्ये परमेश्वरः ।\nदूतोऽहं प्रेषितस्तेन त्वत्सकाशमिहागतः ॥ १०६ ॥",
        hindi = """
            (शुम्भ का परिचय): "दूत ने कहा: 'हे देवी! दैत्यों के राजा शुम्भ इस समय तीनों लोकों के 'परमेश्वर' (Supreme Lord) हैं'।"
            "'मैं उन्हीं का भेजा हुआ दूत हूँ और आपकी सेवा में यहाँ हिमालय पर उपस्थित हुआ हूँ'।"
            "यहाँ 'परमेश्वर' शब्द का प्रयोग शुम्भ के उस महा-भ्रम (Mega-Delusion) को दिखाता है जहाँ वह खुद को भगवान समझने लगा है।"
            "अहंकार हमेशा खुद को 'सेंटर ऑफ द यूनिवर्स' (Center of the universe) मानता है।"
            "शुम्भ ने अपनी ताकत से दुनिया जीती है, इसलिए उसे लगता है कि वह अब 'ईश्वर' के बराबर है।"
            "दूत यह जताना चाहता है कि वह किसी मामूली इंसान का नहीं, बल्कि 'ब्रह्मांड के मालिक' का संदेश लाया है।"
            "यह 'स्टेटस' (Status) का धौंस जमाना है—ताकि देवी उस नाम को सुनकर ही प्रभावित हो जाएं।"
            "जब इंसान के पास बहुत सत्ता आती है, तो वह भूल जाता है कि उसके ऊपर भी कोई अजेय शक्ति है।"
            "सुग्रीव की बातों में शुम्भ का वह घमंड साफ झलक रहा है जो विनाश का कारण बनता है।"
            "वह देवी को एक 'वस्तु' की तरह देख रहा है जो शुम्भ के संग्रह (Collection) में होनी चाहिए।"
        """.trimIndent(),
        english = """
            (Introduction of Shumbha): "The messenger said: 'O Goddess! Shumbha, the King of Demons, is currently the Supreme Lord of the three worlds'."
            "'I am the messenger dispatched by him, and I have arrived here in Your presence to deliver his word'."
            "The use of the word 'Parameshwara' (Supreme Lord) reveals Shumbha's Mega-Delusion of being equivalent to God."
            "Arrogance perpetually perceives itself as the absolute 'Center of the Universe'."
            "Shumbha has conquered the physical world through brute force, leading him to believe he is now Omnipotent."
            "The messenger intends to project that he carries the word of the 'Cosmic Master' rather than an ordinary entity."
            "This is a tactic of 'Status Intimidation'—aiming to impress the Goddess through the sheer weight of a name."
            "When a human acquires excessive power, he entirely forgets that an invincible power perpetually exists above him."
            "Sugriva's speech clearly reflects the toxic pride of Shumbha which inevitably results in a total fall."
            "He views the Goddess as a mere 'Object' that rightfully belongs in Shumbha's inventory of trophies."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 60,
        sanskrit = "अव्याहताज्ञः सर्वासु यः सदा देवयोनिषु ।\nनिर्जिताखिलदैत्यारिः स यदाह शृणुष्व तत् ॥ १०७ ॥",
        hindi = """
            (शुम्भ की अजेयता): "उसने आगे कहा: 'शुम्भ की आज्ञा को कोई टाल नहीं सकता (अव्याहताज्ञः), यहाँ तक कि देवता भी उनके वश में हैं'।"
            "'उन्होंने अपने सभी दुश्मनों (देवताओं) को पूरी तरह से जीत लिया है; अब आप सुनिए कि उन्होंने आपके लिए क्या कहा है'।"
            "शुम्भ का यह दावा कि उसकी आज्ञा 'अव्याहत' (Unstoppable) है, उसकी तानाशाही (Dictatorship) को दर्शाता है।"
            "जब ईगो को लगता है कि कोई उसे चैलेंज नहीं कर सकता, तो वह 'अंधा' (Blind) हो जाता है।"
            "देवताओं को जीतना मतलब इंसान के अंदर की अच्छी प्रवृत्तियों का अहंकार द्वारा कुचल दिया जाना।"
            "सुग्रीव यहाँ देवी को 'डरा' भी रहा है और 'लुभा' भी रहा है—कि इतने शक्तिशाली राजा की बात ध्यान से सुनो।"
            "'शृणुष्व' (Listen)—यह शब्द शुम्भ के उस घमंड को दिखाता है जहाँ वह दूसरों को केवल सुनने का आदेश देता है।"
            "वह यह भूल गया है कि वह जिस 'मौन' शक्ति के सामने खड़ा है, वह उसकी आज्ञाओं का स्रोत (Source) है।"
            "अहंकार को अपनी जीत पर इतना भरोसा है कि वह हार की कल्पना भी नहीं कर सकता।"
            "अब सुग्रीव वह 'प्रस्ताव' रखेगा जो शुम्भ ने विशेष रूप से देवी के लिए तैयार किया है।"
        """.trimIndent(),
        english = """
            (Shumbha's Invincibility): "He continued: 'Shumbha's command is unstoppable (Avyahatajnah); even the divine beings are under his control'."
            "'He has completely conquered all his enemies; now please listen carefully to what he has explicitly stated for You'."
            "Shumbha's claim that his command is 'Unstoppable' perfectly illustrates his psychological state of Dictatorship."
            "The exact moment the Ego believes zero challenges can exist against it, it becomes spiritually Blind."
            "Conquering the Gods symbolizes the suppression of a human's virtuous tendencies by their personal arrogance."
            "Sugriva is simultaneously 'Intimidating' and 'Luring' the Goddess—suggesting She must pay attention to such a king."
            "The command 'Listen' (Shrunushva) reflects Shumbha's pride where he only knows how to issue orders to others."
            "He has entirely forgotten that the Silent Power he stands before is the singular Source of all commands."
            "Arrogance is so deeply invested in its past victories that it mathematically cannot conceive of its own defeat."
            "Now Sugriva is officially preparing to present the 'Proposal' that Shumbha has specifically tailored for Her."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 61,
        sanskrit = "मम त्रैलोक्यमखिलं मम देवा वशानुगाः ।\nयज्ञभागानहं सर्वानुपाश्नामि पृथक् पृथक् ॥ १०८ ॥",
        hindi = """
            (शुम्भ का घमंड - 'मम'): "शुम्भ का संदेश था: 'यह संपूर्ण तीनों लोक 'मेरा' (मम) है, और सभी देवता मेरे इशारों पर चलते हैं'।"
            "'यज्ञों के जितने भी श्रेष्ठ भाग हैं, उन्हें अब मैं अकेला ही अलग-अलग भोगता हूँ'।"
            "यहाँ 'मम' (मेरा) शब्द का बार-बार आना 'ममता' और 'अहंकार' (Possessiveness) का सबसे बड़ा सबूत है।"
            "अज्ञान की सबसे बड़ी बीमारी यही है कि वह हर चीज़ पर 'मेरा' का ठप्पा लगाना चाहता है।"
            "देवताओं का 'वशानुगाः' (गुलाम) होना मतलब इंसान के सात्विक गुणों का ईगो के नीचे दब जाना।"
            "यज्ञ भाग भोगना (Upashnami) इंसान की 'पवित्र ऊर्जा' (Pure Energy) का अहंकार द्वारा गलत इस्तेमाल करना है।"
            "शुम्भ को लगता है कि वह अब ब्रह्मांड का नया 'भगवान' बन गया है क्योंकि वह सब कुछ भोग रहा है।"
            "यह वह भ्रम है जहाँ इंसान सफलता के नशे में यह भूल जाता है कि वह प्रकृति का एक छोटा सा हिस्सा है।"
            "शुम्भ अपनी 'पावर' का प्रदर्शन करके देवी को यह जताना चाहता है कि वह उससे बड़ा कोई नहीं है।"
            "यह घमंडी भाषण वास्तव में उसकी 'इनसिक्योरिटी' (Insecurity) को छिपाने की एक कोशिश है।"
        """.trimIndent(),
        english = """
            (Shumbha's Pride - 'Mine'): "Shumbha's message was: 'This entire cosmos is 'Mine' (Mama), and all the Gods follow my commands'."
            "'I independently consume all the supreme portions of the fire-rituals that used to belong to the deities'."
            "The repetitive use of the word 'Mama' (Mine) is the absolute proof of extreme Possessiveness and Arrogance."
            "The primary disease of ignorance is the desperate psychological need to label everything as 'Mine'."
            "Having the Gods as 'Slaves' symbolizes the suppression of Sattvic virtues under the heavy weight of the ego."
            "Consuming ritual portions (Upashnami) represents the misappropriation of a human's 'Sacred Energy' by the ego."
            "Shumbha deludes himself into thinking he is the new 'God' of the universe because he consumes everything."
            "This is the illusion where a human, intoxicated by success, forgets he is merely a microscopic part of Nature."
            "By displaying his absolute power, Shumbha wants to convince the Goddess that zero entity is superior to him."
            "This arrogant speech is actually a desperate psychological attempt to conceal his underlying cosmic Insecurity."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 62,
        sanskrit = "त्रैलोक्ये वररत्नानि समस्तान्यपि मम च ।\nतथैव गजरत्नं च हृतमैरावतं मया ॥ १०९ ॥",
        hindi = """
            (रत्नों पर कब्ज़ा): "'तीनों लोकों में जितने भी श्रेष्ठ रत्न (Best things) हैं, वे सब के सब अब मेरे ही कब्ज़े में हैं'।"
            "'इन्द्र का वह प्रसिद्ध गजरत्न 'ऐरावत' भी मैंने अपनी ताकत से छीन लिया है'।"
            "अहंकार हमेशा 'रत्नों' (Trophies) का भूखा होता है; वह केवल श्रेष्ठ चीज़ों पर कब्ज़ा करना चाहता है।"
            "ऐरावत 'मेंटल स्ट्रेंथ' (Mental Strength) का प्रतीक है—शुम्भ कहता है कि अब मेरी मानसिक शक्ति सबसे ज़्यादा है।"
            "जब इंसान के पास बहुत पैसा और रुतबा होता है, तो वह अपनी 'लिस्ट' (Inventory) दिखाकर दूसरों को दबाना चाहता है।"
            "शुम्भ को लगता है कि उसकी ये छीनी हुई चीज़ें उसकी अपनी 'कमाई' हैं।"
            "वह यह नहीं समझ पा रहा कि जो चीज़ 'छीनी' गई है, वह कभी भी वापस 'छीनी' जा सकती है।"
            "अहंकार को अपनी संपत्तियों पर बहुत नाज़ है, जो वास्तव में उसके विनाश का कारण बनने वाली हैं।"
            "वह देवी को यह संकेत दे रहा है कि 'तुम भी एक रत्न हो, और रत्नों पर मेरा अधिकार है'।"
            "यह श्लोक अज्ञान की उस 'मैटेरियलिस्टिक' (Materialistic) सोच को दिखाता है जो हर चीज़ को वस्तु मानती है।"
        """.trimIndent(),
        english = """
            (Possession of Jewels): "'Whatever supreme jewels (Best things) exist across the three worlds, they are all under my possession'."
            "'I have also forcefully snatched the famous jewel among elephants, 'Airavata', from the King of Gods'."
            "Arrogance is perpetually hungry for 'Trophies'; it exclusively desires to own the absolute best objects."
            "Airavata symbolizes 'Mental Strength'—Shumbha claims that his mental power is now superior to everyone."
            "When a human possesses excessive wealth and status, he attempts to suppress others by showcasing his Inventory."
            "Shumbha falsely believes that these snatched objects are his own permanent 'Achievements'."
            "He fails to comprehend that whatever has been 'Snatched' can be mathematically 'Snatched Back' at any moment."
            "The Ego takes immense pride in its possessions, which are actually acting as the anchors for its destruction."
            "He is signaling to the Goddess: 'You too are a jewel, and I hold the absolute right over all jewels'."
            "This verse illustrates the 'Materialistic' mindset of ignorance that perceives everything as a commodity."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 63,
        sanskrit = "क्षीरोदमथनोद्भूतमश्वरत्नं च चोच्चैःश्रवसम् ।\nतथा च रत्नानि मणयो देवादिषु च यानि वै ॥ ११० ॥",
        hindi = """
            (उच्चैःश्रवा और अन्य रत्न): "'समुद्र मंथन से निकला हुआ वह दिव्य अश्वरत्न 'उच्चैःश्रवा' भी अब मेरा ही वाहन है'।"
            "'देवताओं और महर्षियों के पास जो भी कीमती मणियां और रत्न थे, वे सब अब मेरे ही घर की शोभा बढ़ा रहे हैं'।"
            "उच्चैःश्रवा 'विचारों की गति' और 'इन्द्रियों के वेग' का प्रतीक है, जिस पर अब अहंकार का लगाम है।"
            "जब इंसान बहुत ताकतवर होता है, तो उसके विचार भी बहुत तेज़ और आक्रामक (Aggressive) हो जाते हैं।"
            "शुम्भ को अपनी 'कलेक्शन' (Collection) पर इतना घमंड है कि वह खुद को सृष्टि का मालिक मान चुका है।"
            "रत्नों का ज़िक्र करना देवी को यह प्रलोभन (Temptation) देना है कि 'मेरे पास आओगी तो ये सब तुम्हारा होगा'।"
            "अहंकार को लगता है कि हर व्यक्ति (यहाँ तक कि भगवान भी) 'लालच' से वश में किया जा सकता है।"
            "यह शुम्भ की सबसे बड़ी मनोवैज्ञानिक भूल है—वह चेतना (देवी) को लालच दे रहा है।"
            "सत्य कभी भी भौतिक सुखों (रत्नों) के लिए समझौता नहीं करता।"
            "शुम्भ का यह भाषण उसकी बेवकूफी और आने वाली मौत का सीधा संकेत है।"
        """.trimIndent(),
        english = """
            (Uchhaishrava and Other Gems): "'The divine jewel among horses, 'Uchhaishrava', born from the cosmic ocean, is now my vehicle'."
            "'Absolutely all the precious gems and jewels that once belonged to Gods and Sages now adorn my palace'."
            "Uchhaishrava symbolizes the 'Speed of Thought' and 'Sensory Velocity', now reigned in by the Ego."
            "When a human is extremely powerful, his thoughts become exceptionally fast, aggressive, and dominant."
            "Shumbha is so intoxicated by his 'Collection' that he has declared himself the absolute Master of Creation."
            "Mentioning these jewels is an attempt to offer 'Temptation' to the Goddess: 'Join me and all this is Yours'."
            "Arrogance falsely believes that every being (even God) can be controlled through 'Greed'."
            "This is Shumbha's absolute greatest psychological blunder—attempting to bribe Consciousness with material trash."
            "Absolute Truth mathematically never compromises its integrity for temporary material pleasures (Jewels)."
            "Shumbha's speech is a direct indicator of his mounting stupidity and his impending cosmic death."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 64,
        sanskrit = "तानि तानि मया दैत्येन्द्र प्रेषितानि गृहे मम ।\nविमानं हंससंयुक्तं यदासीद् वेधसो गृहात् ॥ १११ ॥",
        hindi = """
            (ब्रह्मा का विमान): "'हे देवी! वे सभी दिव्य वस्तुएं मेरे महल में सुरक्षित हैं; यहाँ तक कि ब्रह्मा जी का वह हंसों वाला विमान भी अब मेरा है'।"
            "'मैंने उन सभी श्रेष्ठ चीज़ों को चुन-चुनकर अपने पास इकट्ठा कर लिया है'।"
            "ब्रह्मा का विमान 'क्रिएटिविटी' और 'हायर इंटेलिजेंस' (Higher Intelligence) का प्रतीक है।"
            "जब अहंकार रचनात्मकता (Creativity) को कैद कर लेता है, तो इंसान अपनी कला का उपयोग सिर्फ अपने घमंड के लिए करता है।"
            "हंसों वाला विमान (Hamsa) यह बताता है कि शुम्भ ने 'विवेक' (Discrimination) को भी अपना गुलाम बना लिया है।"
            "अब शुम्भ की बुद्धि वही सोचती है जो उसका अहंकार उसे सोचने को कहता है।"
            "वह देवी को यह जताना चाहता है कि उसके पास 'स्वर्ग' से भी ज़्यादा सुख-सुविधाएं हैं।"
            "अहंकारी इंसान हमेशा अपनी 'एसेट्स' (Assets) दिखाकर दूसरों का दिल जीतना चाहता है।"
            "शुम्भ को पूरा भरोसा है कि उसकी ये आलीशान ज़िंदगी देवी को प्रभावित (Impress) कर देगी।"
            "परंतु वह नहीं जानता कि देवी खुद उन सभी सुखों की जननी (Creator) हैं, उन्हें इन चीज़ों की ज़रूरत नहीं।"
        """.trimIndent(),
        english = """
            (Brahma's Chariot): "'O Goddess! All those divine objects are secured in my palace; even Brahma's swan-yoked chariot is now mine'."
            "'I have meticulously selected and gathered every supreme object of the universe under my roof'."
            "Brahma's chariot symbolizes 'Creativity' and 'Higher Intelligence', which are now hijacked by Shumbha."
            "When Arrogance imprisons creativity, the human utilizes his artistic talents strictly to fuel his personal pride."
            "The Swan-chariot (Hamsa) proves that Shumbha has successfully enslaved even the power of 'Discrimination'."
            "Now, Shumbha's intellect only processes data that validates and feeds his central toxic ego."
            "He wants to convince the Goddess that his palace offers more luxury than even the highest 'Heaven'."
            "An arrogant human perpetually seeks to win others over by showcasing his high-value 'Assets'."
            "Shumbha is entirely confident that his luxurious lifestyle will successfully Impress the Goddess."
            "However, he ignores that the Goddess is the absolute Mother (Creator) of all joys; She requires zero material objects."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 65,
        sanskrit = "निधिरेष महापद्मः समानीतो धनेश्वरात् ।\nकिञ्जल्किनीं ददौ चाब्धिर्मलानामम्लानपङ्कजाम् ॥ ११२ ॥",
        hindi = """
            (कुबेर की निधि): "'मैंने धन के देवता कुबेर से उनकी सबसे बड़ी 'महापद्म' नामक निधि को भी जीत लिया है'।"
            "'और समुद्र ने मुझे कभी न मुरझाने वाले दिव्य कमलों की माला 'किंजल्किनी' भेंट स्वरूप दी है'।"
            "महापद्म निधि 'असीमित धन' और 'रिसोर्स' का प्रतीक है—शुम्भ अब खुद को दुनिया का सबसे अमीर व्यक्ति मान रहा है।"
            "जब इंसान के पास बहुत पैसा आ जाता है, तो उसे लगता है कि वह भगवान से भी कुछ 'नेगोशिएट' (Negotiate) कर सकता है।"
            "कमलों की माला (Flowers) सुंदरता का प्रतीक है, जिसे शुम्भ ने प्रकृति से 'ज़बरदस्ती' (Forcefully) लिया है।"
            "अहंकार जब प्रकृति को दबाता है, तो वह उसके सौंदर्य (Beauty) को भी अपना गुलाम बना लेता है।"
            "शुम्भ अपनी 'दौलत' और 'शोहरत' का पूरा ब्यौरा देवी के सामने रख रहा है।"
            "वह सोच रहा है कि इन कीमती चीज़ों की चमक में देवी का 'विवेक' खो जाएगा।"
            "अहंकारी मन हमेशा यह सोचता है कि हर चीज़ की एक 'कीमत' (Price) होती है।"
            "परंतु शांति और सत्य की कोई कीमत नहीं लगाई जा सकती; वे केवल 'पात्रता' (Eligibility) से मिलते हैं।"
        """.trimIndent(),
        english = """
            (Kubera's Wealth): "'I have conquered even the God of Wealth, Kubera, and seized his greatest treasure, 'Mahapadma'."
            "'The Ocean itself has offered me 'Kinshalkini', a divine garland of lotuses that never fade'."
            "The Mahapadma treasure symbolizes 'Infinite Wealth' and resources—Shumbha considers himself the wealthiest entity."
            "When a human possesses excessive money, he falsely believes he can successfully 'Negotiate' with God."
            "The garland of lotuses represents Beauty, which Shumbha has 'Forcefully' extracted from Mother Nature."
            "Exactly when Arrogance suppresses Nature, it enslaves even Her inherent aesthetic and beauty."
            "Shumbha is presenting a complete audit of his 'Wealth' and 'Fame' directly before the Supreme Goddess."
            "He assumes that in the blinding glow of these precious objects, the Goddess's 'Wisdom' will falter."
            "The arrogant mind perpetually operates on the assumption that everything in existence has a 'Price'."
            "However, Peace and Truth are mathematically Priceless; they are achieved strictly through spiritual 'Eligibility'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 66,
        sanskrit = "छत्रं ते वारुणं गेहे काञ्चनस्त्रावि तिष्ठति ।\nतथायं स्यन्दनवरो यः पुरासीत् प्रजापतेः ॥ ११३ ॥",
        hindi = """
            (वरुण का छत्र और प्रजापति का रथ): "'वरुण देव का वह सोने की वर्षा करने वाला दिव्य छत्र (छाता) भी अब मेरे ही महल में है'।"
            "'और प्रजापति (ब्रह्मा) का वह सबसे श्रेष्ठ रथ भी अब मेरी ही सवारी के लिए तैयार खड़ा है'।"
            "छत्र 'सुरक्षा' (Security) और 'हाई स्टेटस' का प्रतीक है—शुम्भ को लगता है कि वह अब पूरी तरह सुरक्षित है।"
            "जब इंसान के पास बहुत ताकत आती है, तो वह अपनी 'सुरक्षा' के लिए बड़े-बड़े इंतजाम करता है (छत्र)।"
            "प्रजापति का रथ 'ब्रह्मांडीय गति' का प्रतीक है—अहंकार अब खुद को सृष्टि का संचालक (Driver) समझ रहा है।"
            "शुम्भ की यह लिस्ट अज्ञान के उस 'चरम शिखर' (Extreme Peak) को दर्शाती है जहाँ वह सब कुछ अपना मान चुका है।"
            "वह देवी को बता रहा है कि—'मेरे पास सुरक्षा भी है, स्टेटस भी है और कंट्रोल भी है'।"
            "अज्ञानी मन हमेशा अपनी 'बाहरी उपलब्धियों' (External Achievements) पर बहुत ज़्यादा गर्व करता है।"
            "वह भूल जाता है कि ये सब चीज़ें केवल 'किराए' की हैं, जो समय आने पर वापस ले ली जाएंगी।"
            "अब शुम्भ अपना मुख्य प्रपोज़ल (Proposal) देवी के सामने रखने वाला है।"
        """.trimIndent(),
        english = """
            (Varuna's Canopy and Prajapati's Chariot): "'Varuna's divine canopy that showers gold is currently inside my magnificent palace'."
            "'And the supreme chariot that once belonged to Prajapati (the Creator) now stands ready for my travel'."
            "The Canopy symbolizes absolute 'Security' and 'High Status'—Shumbha feels he is now totally invincible."
            "When a human acquires excessive power, he creates massive arrangements (Canopy) strictly for his personal safety."
            "Prajapati's chariot represents 'Cosmic Momentum'—the Ego now perceives itself as the driver of the entire universe."
            "This inventory of Shumbha illustrates the 'Extreme Peak' of ignorance where everything is claimed as personal property."
            "He is signaling to the Goddess: 'I successfully possess total security, extreme status, and absolute control'."
            "The ignorant mind perpetually takes excessive pride in its 'External Achievements' and temporary assets."
            "He entirely forgets that these objects are merely 'On Lease' from Nature and will be withdrawn by Time."
            "Now Shumbha is officially preparing to present his primary Proposal directly to the Supreme Goddess."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 67,
        sanskrit = "मृत्योः शक्त्याख्यां गदां तद्वदादत्तं पाशमेव च ।\nसमस्तं रत्नजातं च निशुम्भस्याब्धिजा विभो ॥ ११४ ॥",
        hindi = """
            (यम का अस्त्र और रत्नों का समूह): "'हे देवी! हमने यमराज की 'शक्ति' नामक गदा और वरुण का पाश भी जीत लिया है'।"
            "'और समुद्र से उत्पन्न होने वाले रत्नों का जो समूह है, वह सब अब मेरे भाई निशुम्भ के पास है'।"
            "यम की गदा 'मृत्यु' का प्रतीक है—शुम्भ यह कह रहा है कि हमने मौत पर भी जीत हासिल कर ली है।"
            "यह अहंकार का 'अमरत्व का भ्रम' (Delusion of Immortality) है जो हर ताकतवर इंसान को होता है।"
            "वरुण का पाश 'क़ानून' और 'बंधन' का प्रतीक है—अहंकार अब खुद ही क़ानून बन चुका है।"
            "निशुम्भ (ममता) के पास रत्नों का होना यह बताता है कि 'अटैचमेंट' (Attachment) ही सारी सुंदर चीज़ों को जकड़ता है।"
            "शुम्भ देवी को यह एहसास दिलाना चाहता है कि वह दुनिया के सबसे बड़े 'पावरफुल परिवार' का हिस्सा बन सकती हैं।"
            "जब अज्ञान किसी को आकर्षित करना चाहता है, तो वह अपनी 'नेटवर्थ' (Net worth) का प्रदर्शन करता है।"
            "वह देवी को केवल एक 'स्त्री' मानकर उसे अपने ऐश्वर्य से डराना और लुभाना चाहता है।"
            "यह श्लोक अज्ञानी मन की उस 'सौदेबाज़ी' (Bargaining) को दिखाता है जो वह सत्य के साथ करना चाहता है। "
        """.trimIndent(),
        english = """
            (Yama's Weapon and Group of Jewels): "'O Goddess! We have conquered Yama's mace named 'Shakti' and also seized Varuna's noose'."
            "'And the entire collection of jewels born from the ocean is currently with my brother Nishumbha'."
            "Yama's mace symbolizes 'Death'—Shumbha is effectively claiming that he has successfully conquered mortality."
            "This is the 'Delusion of Immortality' which frequently traps every human intoxicated by temporary worldly power."
            "Varuna's noose represents 'Law' and 'Binding'—Arrogance has now declared itself as the absolute singular law."
            "Nishumbha (Attachment) owning the jewels proves that 'Obsessive Greed' always grips onto beautiful objects."
            "Shumbha wants the Goddess to realize She can become part of the absolute most 'Powerful Family' in the cosmos."
            "When ignorance seeks to attract something, it relentlessly displays its financial 'Net Worth' and resources."
            "He perceives the Goddess merely as a 'Woman' and attempts to simultaneously intimidate and lure Her."
            "This verse illustrates the desperate 'Bargaining' that an ignorant mind attempts to execute with the Truth."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 68,
        sanskrit = "आग्नेयमपि शुद्धं च वाससी द्वे मया हृते ।\nएवं दैत्येन्द्र रत्नानि समस्तान्याहृतानि मे ॥ ११५ ॥",
        hindi = """
            (अग्नि के वस्त्र और घमंड): "'अग्नि देव के वे दो अत्यंत पवित्र और शुद्ध वस्त्र भी अब मेरे ही पास हैं'।"
            "'इस प्रकार, हे देवी! ब्रह्मांड के जितने भी रत्न और श्रेष्ठ वस्तुएं हैं, वे सब 'मैंने' (Me) छीन ली हैं'।"
            "अग्नि के वस्त्र 'शुद्धता' (Purity) का प्रतीक हैं—शुम्भ यह ढोंग कर रहा है कि वह बहुत पवित्र है।"
            "अहंकारी व्यक्ति अपनी गलतियों को हमेशा 'सच्चाई' और 'पवित्रता' के लेप से ढकता है।"
            "'मे' (Me) शब्द का प्रयोग शुम्भ के उस 'कर्ता-भाव' (Doership) को दिखाता है जो उसे विनाश की ओर ले जाएगा।"
            "वह अपनी 'लूट' (Loot) को अपनी 'उपलब्धि' (Achievement) समझ रहा है, यही अज्ञान है।"
            "शुम्भ को लगता है कि अब उसके पास 'सब कुछ' है, इसलिए वह अब 'पूर्ण' (Perfect) हो गया है।"
            "यह श्लोक इंसान की उस स्टेज को दिखाता है जहाँ वह अपनी चीज़ों के पीछे अपनी 'अकेली आत्मा' को भूल जाता है।"
            "दूत सुग्रीव ने अब शुम्भ के वैभव का पूरा चित्र देवी के सामने खींच दिया है।"
            "अब वह दूत शुम्भ का असली 'प्रपोज़ल' (The Offer) देवी के सामने रखने जा रहा है।"
        """.trimIndent(),
        english = """
            (Garments of Fire and Pride): "'Even those two exceptionally holy and pure garments of Agni are currently under my possession'."
            "'In this manner, O Goddess! I have forcefully snatched absolutely all the jewels and supreme objects of the universe'."
            "Garments of Fire symbolize 'Purity'—Shumbha is pretending to be a highly righteous and holy entity."
            "An arrogant person perpetually covers his toxic mistakes using the masks of 'Truth' and 'Sanctity'."
            "The repetitive use of the word 'Me' illustrates Shumbha's fatal 'Sense of Doership' (Ego)."
            "He mistakes his cosmic 'Loot' for a personal 'Achievement', which is the absolute definition of ignorance."
            "Shumbha deludes himself into thinking he now possesses 'Everything', and is therefore mathematically 'Perfect'."
            "This verse shows the human stage where a person entirely forgets his soul behind his wall of material assets."
            "Messenger Sugriva has now successfully painted a complete picture of Shumbha's material glory before the Goddess."
            "Now the messenger is officially preparing to present Shumbha's primary 'Offer' (Proposal) to Her."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 69,
        sanskrit = "त्वं तु स्त्रीरत्नभूतासि सम्प्रतीह मया विभो ।\nसा त्वं मामुपतिष्ठस्व यतः स्त्रीरत्नभाग् वयम् ॥ ११६ ॥",
        hindi = """
            (विवाह का प्रस्ताव): "'हे देवी! आप इस समय पूरे ब्रह्मांड में 'स्त्री-रत्न' (Jewel) के समान सबसे सुंदर और श्रेष्ठ हैं'।"
            "'चूँकि मैं सभी रत्नों का अकेला मालिक हूँ, इसलिए आपको भी मेरे पास ही आना चाहिए और मेरी सेवा करनी चाहिए'।"
            "यह ईगो (Ego) का सबसे घिनौना और 'ऑब्जेक्टिव' (Objective) नज़रिया है—हर चीज़ को रत्न समझना।"
            "शुम्भ देवी को 'शक्ति' (Power) नहीं, बल्कि एक 'वस्तु' (Object) की तरह देख रहा है जिसे वह 'कलेक्ट' करना चाहता है।"
            "वह कहता है—'यतः स्त्रीरत्नभाग् वयम्' (चूँकि मैं रत्नों का भोगी हूँ)—यह उसके चरम विलासी स्वभाव को दिखाता है।"
            "अहंकार को लगता है कि दुनिया की हर सुंदर चीज़ केवल उसके 'उपभोग' (Consumption) के लिए बनी है।"
            "वह देवी को 'शांति' या 'मुक्ति' नहीं, बल्कि अपने महल की एक 'सजावट' बनाना चाहता है।"
            "इंसान जब अपनी बुद्धि खो देता है, तो वह 'परमात्मा' से भी सेवा (Service) लेने की इच्छा करने लगता है।"
            "शुम्भ का यह प्रपोज़ल वास्तव में उसकी 'मौत का निमंत्रण' (Invitation to Death) है।"
            "सत्य के साथ सौदेबाजी करने की यह कोशिश अहंकार के अंत की आधिकारिक शुरुआत है।"
        """.trimIndent(),
        english = """
            (The Marriage Proposal): "'O Goddess! You are currently the absolute 'Jewel' (Stri-ratna) of beauty and excellence in this entire universe'."
            "'Since I am the singular master of all jewels, You must rightfully come to me and serve me as my queen'."
            "This represents the most repulsive and 'Objective' perspective of the Ego—viewing everything as a commodity."
            "Shumbha does zero to perceive the Goddess as 'Power'; he sees Her as an 'Object' he desperately wants to 'Collect'."
            "He says—'Since I consume all jewels'—revealing his absolute extreme hedonistic and toxic nature."
            "Arrogance falsely assumes that every beautiful thing in the world is created strictly for its personal 'Consumption'."
            "He desires to make the Goddess a 'Decoration' in his palace rather than seeking 'Peace' or 'Liberation' from Her."
            "When a human loses his spiritual intellect, he begins to desire 'Service' from even the Supreme Divine."
            "This proposal by Shumbha is actually an 'Invitation to his own Death', though he is too blind to see it."
            "This attempt to bargain with Absolute Truth marks the formal cosmic beginning of the Ego's final destruction."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 70,
        sanskrit = "मां वा ममानुजं वापि निशुम्भमुरुविक्रमम् ।\nभज त्वं चञ्चलापाङ्गि रत्नभूतासि वै यतः ॥ ११७ ॥",
        hindi = """
            (विकल्प देना): "'हे चंचल आँखों वाली (सुंदर) देवी! आप या तो मुझे चुनें, या मेरे अत्यंत पराक्रमी भाई निशुम्भ को चुन लें'।"
            "'क्योंकि आप स्वयं एक 'रत्न' हैं, और रत्नों का स्थान केवल हमारे जैसे श्रेष्ठ वीरों के पास ही होना चाहिए'।"
            "शुम्भ यहाँ देवी को 'चॉइस' (Choice) दे रहा है, जैसे वह कोई सामान बेच रहा हो (सेल्समैन एटीट्यूड)।"
            "वह देवी को 'चञ्चलापाङ्गि' कहकर लुभाने की कोशिश कर रहा है, जो अज्ञान के सतहीपन (Superficiality) को दिखाता है।"
            "अहंकार को लगता है कि वह और उसका भाई (अहंकार और ममता) ही दुनिया के सबसे 'योग्य' पुरुष हैं।"
            "वह देवी को अपने महल की 'प्रॉपर्टी' बनाने के लिए किसी भी भाई को चुनने का ऑफर दे रहा है।"
            "यह श्लोक अज्ञानी मन की उस 'मूर्खता' को दिखाता है जहाँ वह ईश्वर को भी अपने 'विकल्पों' में रखना चाहता है।"
            "शुम्भ के लिए देवी की 'आध्यात्मिक शक्ति' का कोई मूल्य नहीं है, उसे केवल उनका 'बाहरी रूप' चाहिए।"
            "वह समझता है कि उसकी 'ताकत' (विक्रम) देवी को प्रभावित करने के लिए काफी है।"
            "यह अहंकार का वह 'ओवरकॉन्फिडेंस' है जो उसे विनाश के गड्ढे में गिराने वाला है।"
        """.trimIndent(),
        english = """
            (Offering a Choice): "'O beautiful Goddess with flickering eyes! You may choose either me, or my exceptionally powerful brother Nishumbha'."
            "'Since You are a 'Jewel', Your place must strictly be only with supreme heroes like us'."
            "Shumbha is offering a 'Choice' to the Goddess as if he is selling a product (The Salesman Attitude)."
            "By calling Her 'Chanchalapangi' (flickering-eyed), he displays the extreme superficiality of an ignorant mind."
            "The Ego falsely believes that it and its brother (Arrogance and Attachment) are the most 'Eligible' entities in the world."
            "He is offering any of the brothers as a partner strictly to make the Goddess his palace 'Property'."
            "This verse demonstrates the absolute 'Stupidity' of an ignorant mind that wants to put God inside its 'Options'."
            "For Shumbha, the Goddess's spiritual power holds zero value; he exclusively craves Her 'External Form'."
            "He believes that his raw 'Brute Force' (Vikrama) is more than sufficient to impress and win over the Divine."
            "This is the 'Overconfidence' of the ego that is preparing to throw it into the pit of total annihilation."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 71,
        sanskrit = "परमैश्वर्यमतुलं प्राप्स्यसे मत्परिग्रहात् ।\nएतद् बुद्ध्या समालोच्य मत्परिग्रहतां व्रज ॥ ११८ ॥",
        hindi = """
            (प्रलोभन): "'मुझसे विवाह करने पर (मत्परिग्रहात्) आपको वह अतुलनीय और परम 'ऐश्वर्य' प्राप्त होगा जिसकी कोई सीमा नहीं है'।"
            "'अपनी बुद्धि से इस बात पर अच्छी तरह विचार (समालोच्य) कीजिए और तुरंत मेरी शरण में आ जाइए'।"
            "शुम्भ यहाँ देवी को 'फायदे' (Benefits) गिना रहा है, जैसे कोई बिजनेस डील (Business Deal) हो रही हो।"
            "अहंकार हमेशा सोचता है कि वह सबको 'खरीद' सकता है या 'ऐश्वर्य' का लालच देकर अपना बना सकता है।"
            "वह देवी को 'बुद्धि' (Intelligence) का उपयोग करने को कह रहा है, पर खुद की बुद्धि पूरी तरह भ्रष्ट हो चुकी है।"
            "सच्चा ऐश्वर्य (Divinity) तो देवी से ही आता है, पर शुम्भ उन्हें अपना ही ऐश्वर्य देने का 'ऑफर' दे रहा है।"
            "यह वैसा ही है जैसे कोई समुद्र को एक बाल्टी पानी देने का वादा करे—अत्यंत हास्यास्पद (Ridiculous)।"
            "अज्ञानी मन यह कभी नहीं समझ पाता कि शांति और मुक्ति किसी 'रिश्ते' या 'सौदे' से नहीं मिलती।"
            "शुम्भ का यह प्रलोभन उसे देवी की नज़रों में और भी ज़्यादा 'मूर्ख' और 'पात्र' (Slaughterable) बना रहा है।"
            "अब दूत की बातें खत्म हो चुकी हैं और देवी का जवाब आने वाला है जो पूरे पासे पलट देगा।"
        """.trimIndent(),
        english = """
            (The Temptation): "'By marrying me, You will achieve that incomparable and supreme 'Glory' which has absolutely zero limits'."
            "'Consider this deeply Utilizing Your intellect and instantaneously accept my hand in marriage'."
            "Shumbha is listing the 'Benefits' to the Goddess as if they are negotiating a corporate Business Deal."
            "Arrogance perpetually assumes that everyone can be 'Purchased' or won over using the lure of material glory."
            "He asks the Goddess to use Her 'Intellect', while his own intellect is completely and purely corrupted."
            "True Glory (Divinity) actually originates from the Goddess, yet Shumbha is 'Offering' Her Her own power."
            "This is identically like promising to offer a bucket of water to the entire Ocean—utterly Ridiculous and pathetic."
            "The ignorant mind never comprehends that Peace and Liberation cannot be achieved through a 'Transaction'."
            "This temptation makes Shumbha appear even more 'Foolish' and 'Eligible for slaughter' in the eyes of Truth."
            "The messenger's speech has concluded, and now the Goddess's reply is preparing to flip the entire cosmic script."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 72,
        sanskrit = "ऋषिरुवाच ॥ ११९ ॥\nइत्युक्ता सा तदा देवी गम्भीरान्तःस्मिता जगौ ।\nदुर्गा भगवती भद्रा ययेदं धार्यते जगत् ॥ १२० ॥",
        hindi = """
            (देवी की मुस्कान): "ऋषि मेधा ने कहा: दूत की इन मूर्खतापूर्ण बातों को सुनकर, भगवती दुर्गा के चेहरे पर एक 'गहरी मुस्कान' (गम्भीरान्तःस्मिता) आ गई।"
            "वे ही भगवती 'भद्रा' (कल्याणकारी) हैं, जिन्होंने इस संपूर्ण ब्रह्मांड को अपने भीतर धारण (धार्यते) कर रखा है।"
            "यहाँ 'गम्भीर अन्तःस्मिता' (Deep inner smile) का अर्थ है—वह हंसी जो अज्ञान की बेवकूफी पर आती है।"
            "देवी को गुस्सा नहीं आया, बल्कि उन्हें शुम्भ की छोटी सोच पर 'तरस' और 'हंसी' आई।"
            "यह वह 'कॉस्मिक साइलेंस' (Cosmic Silence) है जो किसी भी शोर भरे तर्क का सबसे बड़ा उत्तर होता है।"
            "माता को यहाँ 'दुर्गा' कहा गया है, जो यह संकेत है कि अब राक्षसों के लिए यह किला (Durg) अभेद्य होने वाला है।"
            "वे 'भद्रा' हैं, यानी वे जो कुछ भी करेंगी (यहाँ तक कि वध भी), वह अंततः ब्रह्मांड के भले के लिए ही होगा।"
            "वह शक्ति जो पूरे 'जगत' को संभालती है, उसे एक छोटा सा असुर 'ऐश्वर्य' का लालच दे रहा था!"
            "देवी का जवाब अब दुनिया को यह सिखाएगा कि 'सत्य' कभी भी 'अहंकार' के सामने नहीं झुकता।"
            "युद्ध का मानसिक आधार अब यहाँ से तैयार होना शुरू हो गया है।"
        """.trimIndent(),
        english = """
            (The Goddess's Smile): "The Sage Medha said: Hearing these foolish words of the messenger, a 'Deep Inner Smile' appeared on the face of Goddess Durga."
            "She is the Supreme 'Bhadra' (Benevolent One) who perpetually sustains and holds this entire universe within Her."
            "The 'Gambhira-antah-smita' (Deep inner smile) represents that divine amusement at the sheer stupidity of ignorance."
            "The Goddess did zero to feel angry; instead, She felt 'Pity' and 'Amusement' at Shumbha's narrow-minded thinking."
            "This is the 'Cosmic Silence' which acts as the absolute greatest response to any noisy or logical argument."
            "Addressing Her as 'Durga' signals that Her internal fortress is now going to be impenetrable for the demons."
            "She is 'Bhadra', implying that whatever action She takes (even slaughter) is ultimately for the global welfare."
            "The Power that sustains the entire 'Universe' was being bribed with material glory by a microscopic demon!"
            "The Goddess's response will now teach the world that 'Truth' mathematically never bows down before 'Arrogance'."
            "The psychological foundation for the final cosmic war is officially being constructed from this moment onward."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 73,
        sanskrit = "देव्युवाच ॥ १२१ ॥\nसत्यमुक्तं त्वया नात्र मिथ्या किञ्चित्त्वयोदितम् ।\nगोप्ता त्रैलोक्यपतिः शुम्भो निशुम्भश्चापि तादृशः ॥ १२२ ॥",
        hindi = """
            (देवी का जवाब): "देवी ने बहुत ही गम्भीरता से कहा: 'हे दूत! तुमने जो कुछ भी कहा है, वह बिल्कुल 'सत्य' (True) है; इसमें कुछ भी झूठ नहीं है'।"
            "'शुम्भ वास्तव में तीनों लोकों का स्वामी और रक्षक (गोप्ता) है, और निशुम्भ भी वैसा ही महा-पराक्रमी है'।"
            "यहाँ देवी की 'डिप्लोमेसी' (Diplomacy) देखिए—वे पहले दुश्मन की ताकत को 'स्वीकार' (Acknowledge) कर रही हैं।"
            "यह एक 'मास्टर-स्ट्रोक' है: जब आप किसी मूर्ख की तारीफ करते हैं, तो उसका अहंकार और ज़्यादा फूल जाता है।"
            "देवी यह जता रही हैं कि मुझे तुम्हारी दौलत और ताकत की सारी जानकारी मिल गई है।"
            "सत्य को स्वीकार करना कमज़ोरी नहीं, बल्कि सामने वाले के भ्रम को और गहरा करने की एक चाल है।"
            "शुम्भ को 'त्रैलोक्यपति' (Lord of 3 worlds) कहना यह दर्शाता है कि देवी उसके 'भौतिक सत्य' को मान रही हैं।"
            "परंतु वे अभी वह 'अंतिम सत्य' (Final Truth) बोलने वाली हैं जो शुम्भ के पैरों के नीचे से ज़मीन खिसका देगा।"
            "देवी का स्वर अत्यंत शांत है, जो उनकी 'अजेय शक्ति' (Invincible Power) का प्रमाण है।"
            "अब वे उस 'प्रतिज्ञा' (Vow) के बारे में बताएंगी जिसने इस विवाह को असंभव बना दिया है।"
        """.trimIndent(),
        english = """
            (The Goddess's Reply): "The Goddess spoke with absolute gravity: 'O Messenger! Whatever You have stated is entirely 'True'; there is zero falsehood in Your words'."
            "'Shumbha is indeed the master and protector (Gopta) of the three worlds, and Nishumbha is equally powerful'."
            "Observe the Goddess's 'Diplomacy' here—She first 'Acknowledges' and validates the enemy's perceived strength."
            "This is a 'Master-stroke': when You flatter a fool's arrogance, his ego expands and his guard drops even further."
            "The Goddess is signaling that She has received all the data regarding Shumbha's wealth and military power."
            "Acknowledging the relative truth is zero weakness; it is a tactic to deepen the opponent's existing delusion."
            "Calling Shumbha 'Trailokyapatih' implies that She recognizes his 'Material Reality' and worldly dominance."
            "However, She is officially preparing to utter that 'Ultimate Truth' which will shatter Shumbha's foundation."
            "The Goddess's voice remains exceptionally calm, which is the absolute proof of Her 'Invincible Power'."
            "Now She will reveal that specific 'Vow' (Pratijna) which has made this marriage proposal mathematically impossible."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 74,
        sanskrit = "किन्त्वत्र यत्प्रतिज्ञातं मिथ्या तत् क्रियते कथम् ।\nश्रूयतामल्पबुद्धित्वात् प्रतिज्ञा या कृता पुरा ॥ १२३ ॥",
        hindi = """
            (देवी की प्रतिज्ञा): "'परंतु मैंने पहले ही एक 'प्रतिज्ञा' (Vow) कर ली है, और मैं उसे 'झूठा' (False) कैसे कर सकती हूँ?'"
            "'अपनी 'अल्प-बुद्धि' (नासमझी) के कारण मैंने बहुत पहले एक ऐसी शर्त रखी थी, जिसे अब तुम सुनो'।"
            "यहाँ देवी खुद को 'अल्प-बुद्धि' (Less intelligent) कह रही हैं—यह उनकी महानता और व्यंग्य (Sarcasm) है।"
            "वे शुम्भ को यह संदेश दे रही हैं कि—'तुम तो बहुत बुद्धिमान हो, पर मैंने एक बेवकूफी भरी शर्त मान ली है'।"
            "अहंकार को यह सुनकर और भी ज़्यादा घमंड होगा कि देवी उससे 'कम' समझदार हैं।"
            "परंतु वह 'प्रतिज्ञा' वास्तव में अज्ञान के लिए एक 'डेथ ट्रैप' (Death Trap) है।"
            "सत्य कभी भी अपनी बात से पीछे नहीं हटता, चाहे सामने कितनी भी बड़ी ताकत क्यों न हो।"
            "यह श्लोक 'इंटीग्रिटी' (Integrity) का प्रतीक है—अपनी बात पर अड़े रहना।"
            "देवी अब वह शर्त बताएंगी जो यह तय करेगी कि शुम्भ उनका पति बनेगा या उनकी तलवार का शिकार।"
            "तर्क (सुग्रीव) अब इस 'प्रतिज्ञा' के सामने पूरी तरह से लाचार होने वाला है।"
        """.trimIndent(),
        english = """
            (The Goddess's Vow): "'However, I have already taken a 'Vow' (Pratijna), and how can I possibly make it 'False' or break it?'"
            "'Due to my 'Lessened Intelligence' (Alpabuddhitva), I established a strict condition long ago; listen to it now'."
            "The Goddess is calling Herself 'Less Intelligent'—this is a display of supreme Humility mixed with lethal Sarcasm."
            "She is signaling to Shumbha: 'You are exceptionally wise, but I have committed to a foolish condition'."
            "Hearing this will inflate the Ego's pride even further, as it perceives itself as superior to the Divine mind."
            "However, that 'Vow' is actually a military-grade 'Death Trap' designed specifically for ignorance."
            "Absolute Truth never retreats from its word, regardless of how colossal the opposing force appears to be."
            "This verse symbolizes absolute 'Integrity'—the unshakeable adherence to one's fundamental principles."
            "The Goddess will now state the condition that decides if Shumbha becomes Her consort or Her victim."
            "Logic (Sugriva) is about to become entirely and purely helpless in front of this unshakeable 'Vow'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 75,
        sanskrit = "यो मां जयति सङ्ग्रामे यो मे दर्पं व्यपोहति ।\nयो मे प्रतिबलो लोके स मे भर्ता भविष्यति ॥ १२४ ॥",
        hindi = """
            (असंभव शर्त): "'जो मुझे 'युद्ध' (Battle) में जीत लेगा, जो मेरे 'घमंड' (दर्पं) को पूरी तरह चूर-चूर कर देगा'।"
            "'और जो इस संसार में मेरी शक्ति के 'बराबर' (प्रतिबलो) होगा, वही मेरा 'पति' (भर्ता) बन पाएगा'।"
            "यह पूरी सप्तशती की सबसे चुनौतीपूर्ण (Challenging) और 'पावरफुल' लाइन है!"
            "देवी कह रही हैं कि मुझे पाने के लिए मुझे 'हराना' (Conquer) होगा—जो कि ब्रह्मांड में असंभव है।"
            "चेतना (Consciousness) को कोई जीत नहीं सकता, उसे केवल 'सरेंडर' करके पाया जा सकता है।"
            "शुम्भ 'रत्नों' और 'दौलत' की बात कर रहा था, और देवी 'युद्ध' और 'ताकत' की बात कर रही हैं।"
            "यह अहंकार के लिए एक सीधा 'ओपन चैलेंज' (Open Challenge) है—अगर तुम इतने बड़े हो, तो लड़कर दिखाओ।"
            "यहाँ 'दर्प' (Pride) शब्द का प्रयोग व्यंग्य है; देवी का कोई घमंड नहीं है, वे खुद ही 'परम सत्य' हैं।"
            "शुम्भ को लगा था कि वह 'शादी' का प्रस्ताव दे रहा है, पर देवी ने उसे 'युद्ध' का न्योता दे दिया।"
            "यह शर्त अज्ञान के उस भ्रम को तोड़ती है कि भगवान को 'लालच' या 'डिप्लोमेसी' से पाया जा सकता है।"
        """.trimIndent(),
        english = """
            (The Impossible Condition): "'He who successfully 'Defeats' me in battle, he who entirely shatters my 'Pride' (Darpa)'."
            "'And he who stands 'Equal' (Pratibala) to my power in this world, only he shall become my 'Husband'."
            "This is undeniably the most challenging, provocative, and 'Powerful' line in the entire Durga Saptashati!"
            "The Goddess declares that to possess Her, one must 'Conquer' Her—which is mathematically impossible in the cosmos."
            "Consciousness can never be defeated or owned; it can strictly only be attained through total 'Surrender'."
            "Shumbha was negotiating with 'Jewels' and 'Wealth', but the Goddess responded with 'War' and 'Raw Power'."
            "This is a direct 'Open Challenge' to the Ego: 'If you are truly supreme, prove it through direct confrontation'."
            "The use of the word 'Darpa' (Pride) is ironic; the Goddess has zero pride, She IS the absolute Supreme Truth."
            "Shumbha thought he was sending a 'Wedding Proposal', but the Goddess returned an 'Invitation to a Massacre'."
            "This condition shatters the ignorance that assumes God can be controlled through 'Greed' or 'Diplomacy'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 76,
        sanskrit = "तदागच्छतु शुम्भोऽत्र निशुम्भो वा महासुरः ।\nजित्वा मां किंचिरेणात्र पाणिं गृह्णातु मे लघु ॥ १२५ ॥",
        hindi = """
            (युद्ध का निमंत्रण): "'इसलिए, अब शुम्भ या वह महा-असुर निशुम्भ स्वयं यहाँ रणभूमि में आ जाएं'।"
            "'वे मुझे यहाँ युद्ध में जीत लें और फिर बिना किसी देरी (लघु) के मेरा हाथ थाम लें'।"
            "देवी की वाणी में अब साक्षात् 'काल' (Death) की गूंज सुनाई दे रही है।"
            "वे शुम्भ को अपने महल से बाहर निकलकर 'सच्चाई' का सामना करने के लिए उकसा रही हैं।"
            "अहंकार हमेशा पर्दे के पीछे (महल में) छुपकर आदेश देता है, वह कभी 'आमने-सामने' की लड़ाई नहीं चाहता।"
            "परंतु चेतना उसे मजबूर कर रही है कि वह अपनी सुरक्षा की बाउंड्री (Comfort Zone) से बाहर आए।"
            "'जित्वा मां' (मुझे जीतकर)—यह वह असंभव मिशन है जो शुम्भ के अंत का कारण बनेगा।"
            "देवी ने सुग्रीव (तर्क) के सारे रटे-रटाए भाषण को एक ही झटके में कबाड़ (Trash) बना दिया।"
            "अब अज्ञान के पास केवल दो ही रास्ते बचे हैं: या तो वह सरेंडर करे, या फिर मौत को चुने।"
            "यह श्लोक 'सत्य की निर्भयता' (Fearlessness of Truth) का प्रतीक है।"
        """.trimIndent(),
        english = """
            (Invitation to Battle): "'Therefore, let Shumbha or that mega-demon Nishumbha personally arrive here in the battlefield'."
            "'Let them defeat me in war right here and then, without any delay (Laghu), hold my hand in marriage'."
            "The absolute voice of 'Time/Death' (Kaala) is now resonating clearly within the Goddess's speech."
            "She is provoking Shumbha to step out of his palace and confront the 'Ultimate Reality' face-to-face."
            "Arrogance perpetually issues commands from behind the scenes (the palace); it avoids 'Direct' confrontation with Truth."
            "However, Consciousness is forcing him to exit his boundary of security and enter his Comfort Zone's end."
            "'After defeating Me'—this is the impossible cosmic mission that will result in Shumbha's total annihilation."
            "The Goddess has instantaneously turned Sugriva's (Logic's) entire scripted speech into useless 'Trash'."
            "Now ignorance is left with strictly only two options: total unconditional surrender or certain death."
            "This verse serves as the absolute symbol of the 'Fearlessness' inherent in the Supreme Truth."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 77,
        sanskrit = "दूत उवाच ॥ १२६ ॥\nगर्वितोऽसि न मैवं त्वं देवि ब्रूहि ममाग्रतः ।\nत्रैलोक्ये कः पुमानन्यः शुम्भनिशुम्भयोः पुरः ॥ १२७ ॥",
        hindi = """
            (दूत का पलटवार): "दूत सुग्रीव ने गुस्से में कहा: 'हे देवी! आप बहुत घमंडी (गर्वितो) हो गई हैं, मेरे सामने ऐसी बातें मत कीजिए'।"
            "'इन तीनों लोकों में ऐसा कौन पुरुष है, जो शुम्भ और निशुम्भ के सामने टिकने की हिम्मत कर सके?'"
            "सुग्रीव का गुस्सा यह दिखाता है कि जब 'तर्क' (Logic) फेल होता है, तो वह 'बदतमीजी' पर उतर आता है।"
            "उसे देवी की शांति और शक्ति 'घमंड' (Pride) लग रही है, क्योंकि अज्ञानी कभी 'आत्म-विश्वास' को समझ नहीं पाता।"
            "वह शुम्भ और निशुम्भ को 'सबसे महान' साबित करने की कोशिश कर रहा है, जो उसकी वफादारी नहीं बल्कि उसका 'डर' है।"
            "ईगो (शुम्भ) को जैसे ही चैलेंज मिलता है, उसका दूत (विचार) भड़क उठता है।"
            "सुग्रीव को लग रहा है कि वह एक कमज़ोर स्त्री को डराकर चुप करा देगा।"
            "यह वह स्टेज है जहाँ अज्ञान सत्य को 'अंडर-एस्टीमेट' (Underestimate) करने की सबसे बड़ी गलती करता है।"
            "दूत का 'मैवं त्वं' (ऐसा मत कहो) कहना यह बताता है कि अहंकार कभी भी 'सत्य' को सुनना नहीं चाहता।"
            "अहंकार को केवल अपनी 'जी-हज़ूरी' और 'तारीफ' ही पसंद आती है।"
        """.trimIndent(),
        english = """
            (The Messenger's Retaliation): "Messenger Sugriva replied in anger: 'O Goddess! You have become too arrogant; do zero to speak like this before me'."
            "'Who exists in these three worlds as a man who can dare to stand before Shumbha and Nishumbha?'"
            "Sugriva's anger proves that when 'Logic' fails, it immediately resorts to 'Abusive and aggressive behavior'."
            "He mistakes the Goddess's unshakeable power for 'Arrogance', as the ignorant never comprehend true 'Self-confidence'."
            "He is desperately trying to prove Shumbha and Nishumbha as 'The Greatest', which reflects his own deep 'Fear'."
            "The exact moment the Ego (Shumbha) is challenged, its messenger (Thought) begins to flare up with rage."
            "Sugriva deludes himself into thinking he can silence and intimidate a seemingly 'Weak Woman'."
            "This is the stage where ignorance commits the fatal error of 'Underestimating' the absolute Supreme Truth."
            "The messenger's demand 'Do zero to say this' proves that Arrogance is mathematically incapable of hearing Truth."
            "Toxic arrogance exclusively craves 'Validation' and constant 'Flattery' to sustain its fragile existence."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 78,
        sanskrit = "अन्येषामपि दैत्यानां सर्वे देवा न संयुगे ।\nतिष्ठन्ति सम्मुखे देवि किं पुनः स्त्री त्वमेकिनी ॥ १२८ ॥",
        hindi = """
            (कमज़ोरी का अहसास कराना): "'हे देवी! जब बाकी साधारण दैत्यों के सामने भी सारे देवता युद्ध में नहीं टिक पाते'।"
            "'तो फिर आप तो एक 'अकेली स्त्री' (स्त्री त्वमेकिनी) हैं, आप शुम्भ के सामने कैसे खड़ी हो पाएंगी?'"
            "सुग्रीव यहाँ 'जेंडर-बायस' (Gender Bias) और 'संख्या बल' (Numbers) का इस्तेमाल करके देवी को कमज़ोर महसूस करा रहा है।"
            "अहंकार हमेशा 'क्वांटिटी' (Quantity) पर भरोसा करता है, जबकि सत्य 'क्वालिटी' (Quality) और 'पावर' पर।"
            "उसे लग रहा है कि एक अकेली नारी (सत्य) राक्षसों की उस बड़ी फौज (झूठ के अंबार) का मुकाबला नहीं कर पाएगी।"
            "यह श्लोक उस 'बुलिंग' (Bullying) का प्रतीक है जो अक्सर दुनिया सच्चाई के साथ करती है।"
            "दुनिया कहती है—'तुम अकेले क्या बदल लोगे? देखो कितनी बुराई है!'—सुग्रीव भी यही कह रहा है।"
            "वह भूल गया है कि एक 'चिंगारी' पूरे जंगल को जलाने के लिए काफी होती है, चाहे जंगल कितना भी बड़ा हो।"
            "अज्ञान केवल 'भीड़' (Crowd) देखता है, जबकि चेतना 'अकेली' होकर भी पूरी सृष्टि पर भारी होती है। "
            "सुग्रीव की यह सोच उसकी बुद्धि के 'अंधेपन' का सबसे बड़ा प्रमाण है।"
        """.trimIndent(),
        english = """
            (Focusing on Weakness): "'O Goddess! When all the Gods cannot even stand before our ordinary demons in battle'."
            "'How can You, a 'Lone Woman' (Stri-tvamekini), possibly survive against a giant like Shumbha?'"
            "Sugriva is utilizing 'Gender Bias' and the 'Power of Numbers' to make the Goddess feel psychologically weak."
            "Arrogance perpetually relies on 'Quantity' (Numbers), whereas Truth functions purely on 'Quality' and 'Willpower'."
            "He believes that a single woman (Truth) can mathematically never defeat a massive demonic army (Pile of Lies)."
            "This verse symbolizes the 'Bullying' that the worldly mind frequently executes against a person of integrity."
            "The world asks: 'What can you alone change? Look at the massive evil!'—Sugriva is echoing the same sentiment."
            "He has forgotten that a singular 'Spark' is sufficient to incinerate an entire forest, regardless of the forest's size."
            "Ignorance exclusively sees the 'Crowd', while Consciousness, even when 'Alone', outweighs the entire creation."
            "This specific line of reasoning by Sugriva serves as the absolute proof of his total intellectual 'Blindness'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 79,
        sanskrit = "इन्द्राद्याः सकला देवास्तस्थुर्यैषां न संयुगे ।\nशुम्भादीनां कथं तेषां स्त्री प्रपास्यसि सम्मुखम् ॥ १२९ ॥",
        hindi = """
            (इन्द्र का उदाहरण): "'जिन शुम्भ-निशुम्भ के सामने इन्द्र जैसे शक्तिशाली देवता भी युद्ध में नहीं टिक सके'।"
            "'उनके सामने आप जैसी कोमल स्त्री भला कैसे मुकाबला कर पाएगी?'"
            "सुग्रीव यहाँ 'अतीत' (Past) के उदाहरण देकर देवी का 'मनोबल' (Morale) तोड़ने की कोशिश कर रहा है।"
            "वह कह रहा है कि—'जब बड़े-बड़े हार गए, तो तुम क्या चीज़ हो?'—यही अज्ञान का सबसे पुराना हथियार है।"
            "अहंकार हमेशा दूसरों की 'हार' (Failures) को दिखाकर अपनी 'अजेयता' साबित करना चाहता है।"
            "वह यह नहीं समझ पा रहा कि इन्द्र (इंद्रियां) हार सकते हैं, पर इन्द्रियों की 'स्वामिनी' (देवी) कभी नहीं हार सकती।"
            "जब इंसान अपने 'मन के विकारों' से लड़ता है, तो उसे अक्सर अपनी पुरानी हार याद दिलाई जाती है।"
            "परंतु 'नया संकल्प' (Goddess) पुराने किसी भी फेलियर (Indra) से कहीं ज़्यादा शक्तिशाली होता है।"
            "सुग्रीव की यह तुलना (Comparison) पूरी तरह से गलत और सतही है।"
            "अज्ञान अब अपनी 'लिमिट' (Limit) क्रॉस कर रहा है, और देवी का धैर्य अब खत्म होने वाला है।"
        """.trimIndent(),
        english = """
            (Example of Indra): "'When even powerful Gods like Indra could zero percent withstand Shumbha and Nishumbha in war'."
            "'How can a gentle woman like You possibly face them in a direct physical confrontation?'"
            "Sugriva is attempting to shatter the Goddess's 'Morale' by presenting examples of 'Past Failures' of the Gods."
            "He argues: 'If the giants have failed, what can You achieve?'—this is the oldest psychological weapon of ignorance."
            "Arrogance perpetually uses the 'Failures' of others to validate its own perceived state of invincibility."
            "He fails to comprehend that while Indra (Senses) can be defeated, the 'Mistress of Senses' (Goddess) is invincible."
            "When a human fights his 'Internal Vices', his mind frequently reminds him of his previous unsuccessful attempts."
            "However, a 'New Resolve' (Goddess) is mathematically infinitely more powerful than any historical Failure (Indra)."
            "Sugriva's logic of 'Comparison' is fundamentally flawed, superficial, and purely based on material data."
            "Ignorance is now crossing its absolute cosmic 'Limit', and the Goddess's patience is reaching its end."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 80,
        sanskrit = "सा त्वं गच्छ मयैवोक्ता शुम्भनिशुम्भयोः अन्तिकम् ।\nकेशाकर्षणनिर्धूतगौरवा मा गमिष्यसि ॥ १३० ॥",
        hindi = """
            (अपमान की धमकी): "'इसलिए मेरी बात मानिए और अभी मेरे साथ शुम्भ-निशुम्भ के पास चलिए'।"
            "'वरना आपको वहाँ 'बाल पकड़कर' (केशाकर्षण) घसीटते हुए ले जाया जाएगा, जिससे आपका सारा गौरव (Gaurava) धूल में मिल जाएगा'।"
            "यह अहंकार का 'असली चेहरा' है—जब मिठास काम नहीं आती, तो वह 'हिंसा' और 'अपमान' पर उतर आता है।"
            "बाल पकड़ना (Hair pulling) किसी भी स्त्री के लिए सबसे बड़ा अपमान माना जाता है, सुग्रीव वही धमकी दे रहा है।"
            "अहंकार हमेशा दूसरों की 'गरिमा' (Dignity) को चोट पहुँचाकर उन्हें अपने वश में करना चाहता है।"
            "वह देवी को डरा रहा है कि—'अगर प्यार से नहीं चलीं, तो बेइज्जती (Insult) सहनी पड़ेगी'।"
            "यह श्लोक उस 'टॉक्सिक मर्दानगी' (Toxic Masculinity) का प्रतीक है जो अज्ञान और घमंड से पैदा होती है।"
            "सुग्रीव को लग रहा है कि वह 'शक्ति' (Power) को डरा सकता है, जो कि उसकी सबसे बड़ी बेवकूफी है।"
            "जब बुराई अपनी सारी मर्यादाएं (Boundaries) तोड़ देती है, तभी उसका 'सर्वनाश' शुरू होता है।"
            "अब दूत ने अपनी मौत का वारंट खुद ही साइन कर दिया है; देवी का जवाब अब प्रलय जैसा होगा।"
        """.trimIndent(),
        english = """
            (Threat of Humiliation): "'Therefore, listen to my words and accompany me to Shumbha and Nishumbha immediately'."
            "'Otherwise, You will be dragged there by Your 'Hair' (Kesha-karshana), and all Your dignity will be reduced to dust'."
            "This is the 'True Face' of Arrogance—when sweetness fails, it immediately resorts to 'Violence' and 'Insult'."
            "Pulling the hair is considered the ultimate humiliation for a woman; Sugriva is issuing exactly that threat."
            "Arrogance perpetually seeks to control others by attacking and wounding their personal 'Dignity'."
            "He is terrorizing the Goddess: 'If You do zero go voluntarily, You shall face a public and brutal Insult'."
            "This verse symbolizes the 'Toxic Masculinity' and raw brute force born from deep ignorance and pride."
            "Sugriva deludes himself into thinking he can frighten 'Absolute Power', which is his greatest cosmic stupidity."
            "The exact moment evil shatters all 'Boundaries' of decency, its total annihilation officially initiates."
            "The messenger has officially signed his own death warrant; the Goddess's response will now be apocalyptic."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 81,
        sanskrit = "देव्युवाच ॥ १३१ ॥\nएवमेतद् बली शुम्भो निशुम्भश्चापि तादृशः ।\nकिं करोमि प्रतिज्ञा मे यदनालोचिता पुरा ॥ १३२ ॥",
        hindi = """
            (देवी का विनम्र उत्तर): "देवी ने मुस्कराते हुए कहा: 'इसमें कोई संदेह नहीं कि शुम्भ अत्यंत बलवान है और निशुम्भ भी वैसा ही है'।"
            "'परंतु मैं क्या करूँ? मैंने बिना सोचे-विचारे ही बहुत पहले वह प्रतिज्ञा (Vow) कर ली थी'।"
            "यहाँ देवी की 'लीला' (Divine Play) अपने चरम पर है—वे शत्रु को चने के झाड़ पर चढ़ा रही हैं।"
            "वे शुम्भ की ताकत को स्वीकार कर रही हैं ताकि उसका 'अहंकार' और भी अधिक फूल जाए।"
            "जब कोई विनाश के करीब होता है, तो सत्य उसे उसकी कल्पना के अनुसार ही उत्तर देता है।"
            "माता का खुद को 'असहाय' (Helpless) दिखाना वास्तव में अज्ञान को अपनी बाउंड्री से बाहर खींचना है।"
            "अहंकार को लगता है कि उसने देवी को डरा दिया है, पर असल में वह खुद उनके जाल में फँस रहा है।"
            "यह श्लोक सिखाता है कि सत्य कभी शोर नहीं मचाता, वह बड़ी ही चतुराई से अपना काम करता है।"
            "देवी की प्रतिज्ञा कोई गलती नहीं, बल्कि ब्रह्मांड के नियमों का एक अटूट हिस्सा है।"
            "अब अज्ञान (शुम्भ) को इस 'प्रतिज्ञा' की कीमत अपनी जान देकर चुकानी होगी।"
        """.trimIndent(),
        english = """
            (The Goddess's Humble Reply): "The Goddess smiled and said: 'There is no doubt that Shumbha is extremely powerful, and Nishumbha is equally so'."
            "'But what can I possibly do? I made that unshakeable Vow long ago without thinking deeply about it'."
            "The Goddess's 'Leela' (Divine Play) is at its peak here—She is effectively boosting the enemy's pride."
            "She acknowledges Shumbha's physical strength strictly to make his toxic Ego expand even further."
            "When someone is close to destruction, Absolute Truth responds to them according to their own delusions."
            "The Mother appearing 'Helpless' is actually a tactic to draw ignorance out of its comfort zone."
            "Arrogance deludes itself into thinking it has frightened the Goddess, while it is actually falling into Her trap."
            "This verse teaches that Truth does zero to shout; it executes its cosmic task with absolute sophistication."
            "The Goddess's Vow is zero mistake; it is an unshakeable component of the fundamental cosmic laws."
            "Now ignorance (Shumbha) will mathematically have to pay the price of this Vow with his absolute life."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 82,
        sanskrit = "स त्वं गच्छ मयोक्तं ते यदेतत् सर्वमादृतः ।\nतदाचक्ष्व सुरेन्द्रायामुराणां पतये लघु ॥ १३३ ॥",
        hindi = """
            (दूत को वापस भेजना): "'इसलिए हे दूत! तुम वापस जाओ और मैंने तुमसे जो कुछ भी कहा है, उसे पूरी तरह आदर के साथ सुनो'।"
            "'और दैत्यों के उस राजा शुम्भ से जाकर मेरा यह सारा संदेश बहुत जल्दी (लघु) कह देना'।"
            "देवी अब दूत सुग्रीव के साथ अपनी बातचीत को औपचारिक रूप से 'समाप्त' (Terminate) कर रही हैं।"
            "वे उसे 'आदर' (Respect) के साथ अपनी बात सुनाने को कह रही हैं, जो उनके उच्च चरित्र का प्रमाण है।"
            "सत्य कभी भी दूत (Messenger) का अपमान नहीं करता, चाहे वह दूत किसी राक्षस का ही क्यों न हो।"
            "वे शुम्भ को 'सुरेन्द्राय' (दैत्यों का इन्द्र) कहकर व्यंग्य कर रही हैं, क्योंकि असली इन्द्र तो उनकी शरण में हैं।"
            "संदेश को 'लघु' (जल्दी) पहुँचाने का अर्थ है कि अब युद्ध की घड़ी बहुत पास आ चुकी है।"
            "अहंकार को सत्य की चेतावनी मिल चुकी है, अब फैसला उसे करना है कि वह क्या चुनेगा।"
            "देवी की वाणी में वह शांति है जो आने वाले महा-तूफान (Cosmic Storm) का संकेत दे रही है।"
            "दूत के जाने के साथ ही, शांतिपूर्वक बातचीत के सारे रास्ते अब हमेशा के लिए बंद हो चुके हैं।"
        """.trimIndent(),
        english = """
            (Sending the Messenger Back): "'Therefore O Messenger! Go back and listen to everything I have said to You with full respect'."
            "'And convey this entire message of Mine to that King of Demons, Shumbha, very quickly (Laghu)'."
            "The Goddess is now formally 'Terminating' Her conversation with the messenger Sugriva."
            "She asks him to listen with 'Respect' (Adritah), proving Her supreme divine character and ethics."
            "Truth mathematically never insults a mere Messenger, even if that messenger serves absolute evil."
            "She uses the term 'Surendra' ironically for Shumbha, as the actual Indra is already seeking Her protection."
            "Demanding the message be delivered 'Quickly' implies that the hour of the final war is extremely close."
            "Arrogance has received the formal warning of Truth; it must now decide its own tragic fate."
            "The Goddess's voice holds that specific silence which signals the approach of an apocalyptic Cosmic Storm."
            "With the departure of the messenger, absolutely all roads for peaceful negotiation are now permanently closed."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 83,
        sanskrit = "यथोचितं विधास्यत्येव स हि जानाति यत् क्षमम् ॥ १३४ ॥\nऋषिरुवाच ॥ १३५ ॥",
        hindi = """
            (अंतिम निर्णय): "देवी ने बात खत्म की: 'शुम्भ जो उचित (यथोचितं) समझेगा, वही करेगा, क्योंकि वह जानता है कि उसके लिए क्या सही है'।"
            "महर्षि मेधा ने आगे कहा: (देवी की यह बात सुनकर वह दूत सुग्रीव वहाँ से चुपचाप चला गया)।"
            "देवी यहाँ शुम्भ को 'फ्री-विल' (Free Will) दे रही हैं—इंसान अपनी मौत का रास्ता खुद चुनता है।"
            "'यथोचितं' का अर्थ है कि अहंकार अपनी बुद्धि के हिसाब से ही रिएक्ट (React) करेगा, जो कि हमेशा गलत होता है।"
            "भगवान कभी किसी को बुरा बनने के लिए मजबूर नहीं करते, वे बस उसे अपनी चॉइस का फल भोगने देते हैं।"
            "ऋषि का हस्तक्षेप (Rishiruvacha) यह बताता है कि अब कथा का एक अध्याय बंद हो रहा है और युद्ध शुरू होने वाला है।"
            "दूत का जाना उस शांति का अंत है जो अब तक हिमालय के वातावरण में बनी हुई थी।"
            "यह श्लोक अज्ञान के उस अंधेपन को दिखाता है जहाँ वह सही सलाह को अपमान समझकर ठुकरा देता है।"
            "सत्य ने अपना पक्ष रख दिया है, अब क्रिया और प्रतिक्रिया (Action and Reaction) का खेल शुरू होगा।"
            "अहंकार अब अपने विनाश के लिए खुद ही 'ट्रिगर' (Trigger) दबाने वाला है।"
        """.trimIndent(),
        english = """
            (The Final Decision): "The Goddess concluded: 'Shumbha shall act as he deems Appropriate (Yathochitam), for he knows his own capacity'."
            "The Sage Medha continued: (Having heard this, the messenger Sugriva silently departed from that location)."
            "The Goddess is granting Shumbha 'Free Will'—proving that a human chooses their own path to destruction."
            "'Yathochitam' implies that Arrogance will React strictly according to its corrupted intellect, which is always fatal."
            "God never forces anyone to be evil; He simply allows them to experience the results of their own Choices."
            "The transition by the Sage (Rishiruvacha) signals that one chapter of dialogue is closing and war is imminent."
            "The departure of the messenger marks the end of the peace that had previously filled the Himalayas."
            "This verse demonstrates the blindness of ignorance which rejects righteous advice by mistaking it for insult."
            "Truth has stated its position; now the cosmic game of Action and Reaction shall officially commence."
            "Arrogance is now preparing to independently pull the 'Trigger' of its own total annihilation."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 84,
        sanskrit = "इत्युक्तः स तदा दूतो निर्वेदात् प्रतिनृत्य च ।\nस दैत्यराजमासाद्य सर्वमाख्यातवान् नृप ॥ १३६ ॥",
        hindi = """
            (दूत की वापसी): "ऋषि बोले: हे राजन्! देवी की ये बातें सुनकर वह दूत सुग्रीव अत्यंत 'निर्वेद' (चिंता/अपमान) के साथ वहाँ से लौटा।"
            "वह दैत्यराज शुम्भ के पास पहुँचा और उसने देवी द्वारा कही गई एक-एक बात विस्तार से बता दी।"
            "'निर्वेद' का अर्थ है वह मानसिक पीड़ा जब आपकी चालाकी और तर्क पूरी तरह फेल हो जाते हैं।"
            "दूत को समझ आ गया था कि यह स्त्री कोई साधारण मानवी नहीं है, बल्कि साक्षात् मृत्यु है।"
            "अहंकार का दूत जब वापस महल पहुँचता है, तो वह अपने साथ 'डर' (Fear) की वाइब्रेशन लेकर आता है।"
            "उसने 'सर्वमाख्यातवान्' (सब कुछ कह दिया)—मतलब उसने देवी की उस असंभव शर्त को शुम्भ के सामने रख दिया।"
            "यह रिपोर्ट शुम्भ के अहंकार के घाव पर नमक छिड़कने जैसा काम करने वाली थी।"
            "जब सत्य की बात अहंकार तक पहुँचती है, तो वह उसे सुधारने के बजाय और ज़्यादा भड़क उठता है।"
            "महल का वातावरण अब बदल चुका था; अब वहां कूटनीति नहीं, केवल प्रतिशोध (Revenge) की बातें होंगी।"
            "शुम्भ की मौत का काउंटडाउन (Countdown) अब इसी श्लोक से शुरू हो चुका है।"
        """.trimIndent(),
        english = """
            (Return of the Messenger): "The Sage said: O King! Hearing the Goddess's words, the messenger Sugriva returned with a sense of 'Nirveda' (frustration/insult)."
            "He approached the Demon King Shumbha and narrated every single word spoken by the Goddess in great detail."
            "'Nirveda' represents that psychological pain experienced when one's cunning logic and arguments fail completely."
            "The messenger had realized that this Woman was zero ordinary human, but rather Absolute Death manifested."
            "When the messenger of arrogance returns to the palace, he carries the vibrations of 'Fear' with him."
            "He 'Narrated everything' (Sarvam-akhyatavan)—placing the Goddess's impossible condition directly before Shumbha."
            "This specific report was destined to act like salt on the open wounds of Shumbha's toxic ego."
            "When the words of Truth reach Arrogance, it does zero to self-correct; it simply flares up with rage."
            "The environment of the palace had shifted; diplomacy was dead, replaced entirely by thoughts of Revenge."
            "The countdown to Shumbha's cosmic death has officially initiated right here in this specific verse."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 85,
        sanskrit = "तस्य तद्वचनं श्रुत्वा दूतोक्तं स महासुरः ।\nसक्रोधः प्राह दैत्यानामधिपं धूम्रलोचनम् ॥ १३७ ॥",
        hindi = """
            (धूम्रलोचन को आदेश): "दूत के मुख से देवी की वे बातें सुनकर वह महा-असुर शुम्भ क्रोध से भड़क उठा।"
            "उसने अत्यंत गुस्से में आकर दैत्यों के सेनापति 'धूम्रलोचन' को अपने पास बुलाया और उसे आदेश दिया।"
            "यहाँ से युद्ध का 'प्रथम चरण' (First Phase) शुरू होता है, जहाँ शुम्भ खुद नहीं जाता, बल्कि अपने सेनापति को भेजता है।"
            "धूम्रलोचन (Dhumralochana) का शाब्दिक अर्थ है 'जिसकी आँखों में धुआं भरा हो' (Smoky-eyed)।"
            "यह इंसान के उस 'अज्ञान' का प्रतीक है जिसे सत्य दिखाई नहीं देता, केवल धुआं (भ्रम) दिखाई देता है।"
            "अहंकार हमेशा सबसे पहले अपने 'भ्रम' (धूम्रलोचन) को सत्य (देवी) को मिटाने के लिए भेजता है।"
            "शुम्भ का 'सक्रोध' (क्रोधित) होना यह बताता है कि उसका मानसिक संतुलन अब पूरी तरह खो चुका है।"
            "जब इंसान गुस्से में फैसले लेता है, तो वह अपनी हार की नींव खुद ही रख देता है।"
            "धूम्रलोचन को आदेश देना मतलब अपने अज्ञान को और गहरा करने की कोशिश करना है।"
            "अब विनाशकारी शक्तियों का तांडव शुरू होने वाला है जो अंततः देवी के हाथों शांत होगा।"
        """.trimIndent(),
        english = """
            (Order to Dhumralochana): "Upon hearing the words delivered by the messenger, the mega-demon Shumbha erupted in a violent blaze of rage."
            "In extreme anger, he summoned the demonic commander 'Dhumralochana' and issued a direct military command."
            "This marks the initiation of the 'First Phase' of war, where Shumbha does zero to go personally, but sends a general."
            "'Dhumralochana' literally translates to 'One with smoke-filled eyes' (Smoky-eyed)."
            "He flawlessly symbolizes that 'Ignorance' in a human which cannot see Truth, perceiving only smoke and delusion."
            "Arrogance perpetually dispatches its 'Delusion' (Dhumralochana) first to attempt to annihilate the Truth (Goddess)."
            "Shumbha being 'Sakrodhah' (Enraged) proves that his psychological stability has been completely shattered."
            "When a human makes decisions in a state of wrath, he independently constructs the foundation of his own defeat."
            "Commanding Dhumralochana represents a desperate attempt to deepen one's own ignorance and denial."
            "Now the dance of destructive forces is about to begin, which will ultimately be silenced by the Goddess."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 86,
        sanskrit = "हे धूम्रलोचनाशु त्वं स्वसैन्यपरिवारितः ।\nतामानय बलाद् दुष्टां केशाकर्षणविह्वलाम् ॥ १३८ ॥",
        hindi = """
            (पकड़ कर लाने का हुक्म): "शुम्भ ने चिल्लाकर कहा: 'हे धूम्रलोचन! तू अभी अपनी विशाल सेना के साथ वहाँ जा'।"
            "'और उस दुष्ट स्त्री को उसके 'बाल पकड़कर' (केशाकर्षण) घसीटते हुए ज़बरदस्ती (बलाद्) मेरे पास लेकर आ'।"
            "यह अहंकार का 'चरम पतन' है—जहाँ वह शक्ति को 'अपमानित' करने का सपना देख रहा है।"
            "बाल पकड़ना (Kesha-karshana) इंसान की मर्यादा और सम्मान को पूरी तरह कुचलने का प्रतीक है।"
            "अहंकार को लगता है कि वह 'बलाद्' (ताकत) से सत्य को अपना गुलाम बना सकता है।"
            "धूम्रलोचन को सेना के साथ भेजना यह दिखाता है कि अज्ञान हमेशा 'भीड़' (Crowd) के पीछे छुपकर वार करता है।"
            "शुम्भ देवी को 'दुष्टा' कह रहा है, जो यह साबित करता है कि अज्ञानी को सत्य हमेशा कड़वा और बुरा ही लगता है।"
            "यह आदेश शुम्भ की असुरक्षा और उसके पागलपन का सबसे बड़ा दस्तावेज़ है।"
            "जब इंसान अपनी सीमाएं भूलकर देवी (पवित्रता) पर हाथ डालने की कोशिश करता है, तो उसका काल निश्चित हो जाता है। "
            "अब अज्ञान का यह 'धुआं' (धूम्रलोचन) महामाया की ज्वाला से टकराने जा रहा है।"
        """.trimIndent(),
        english = """
            (Command to Capture): "Shumbha shouted: 'O Dhumralochana! Go there right now, surrounded by your massive demonic army'."
            "'And bring that wicked woman to me by Force (Balad), dragging Her by Her 'Hair' (Kesha-karshana) till She is helpless'."
            "This represents the 'Extreme Fall' of arrogance—where it dreams of publicly Humiliating the Supreme Power."
            "Pulling the hair symbolizes the total crushing of human dignity, integrity, and sacred boundaries."
            "Arrogance deludes itself into thinking that through 'Brute Force' (Balad), it can enslave the Absolute Truth."
            "Sending Dhumralochana with an army proves that ignorance perpetually hides behind a 'Crowd' to execute its strikes."
            "Shumbha calling the Goddess 'Wicked' proves that to the ignorant mind, Truth perpetually appears bitter and evil."
            "This command is the ultimate document of Shumbha's cosmic insecurity and his descending madness."
            "Exactly when a human forgets his limits and attempts to violate Purity (Goddess), his death becomes mathematically certain."
            "Now this 'Smoke' of ignorance (Dhumralochana) is moving to collide with the absolute Blaze of Mahamaya."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 87,
        sanskrit = "तत्परित्राणदः कश्चिद् यदि वोत्तिष्ठति अपरः ।\nस हन्तव्योऽमरो वापि यक्षो गन्धर्व एव वा ॥ १३९ ॥",
        hindi = """
            (विरोधियों को खत्म करने का आदेश): "शुम्भ ने आगे कहा: 'यदि उसकी रक्षा (परित्राणदः) के लिए कोई दूसरा खड़ा हो जाए'।"
            "'चाहे वह देवता (अमरो) हो, यक्ष हो या गन्धर्व—उसे भी तुरंत मार डालना'।"
            "अहंकार अब पूरी तरह से 'डिस्ट्रक्टिव मोड' (Destructive Mode) में आ चुका है।"
            "वह किसी भी ऐसी शक्ति को बर्दाश्त नहीं करना चाहता जो सत्य (देवी) का साथ दे।"
            "देवता, यक्ष और गन्धर्व हमारे अंदर के 'शुभ विचारों' और 'कलात्मकता' के प्रतीक हैं।"
            "अहंकार चाहता है कि इंसान के अंदर की हर अच्छी चीज़ को जड़ से खत्म कर दिया जाए।"
            "शुम्भ को लगता है कि उसकी ताकत के सामने ब्रह्मांड की कोई भी शक्ति टिक नहीं पाएगी।"
            "यह श्लोक उस 'आइसोलेशन' (Isolation) को दिखाता है जहाँ बुराई सबको डराकर अकेला कर देना चाहती है।"
            "परंतु वह मूर्ख नहीं जानता कि जो सबका आधार है, उसकी रक्षा के लिए किसी और की ज़रूरत नहीं होती।"
            "शुम्भ की यह धमकी वास्तव में उसकी अपनी मौत की गूंज है।"
        """.trimIndent(),
        english = """
            (Command to Annihilate Supporters): "Shumbha added: 'If anyone else stands up for Her protection (Paritranadah)'."
            "'Whether it be a God (Amara), a Yaksha, or a Gandharva—slaughter them instantaneously without mercy'."
            "Arrogance has now successfully entered its absolute 'Total Destruction Mode'."
            "It refuses to tolerate any cosmic force that aligns itself with the Absolute Truth (Goddess)."
            "Gods, Yakshas, and Gandharvas symbolize our 'Auspicious Thoughts' and internal 'Creativity'."
            "Arrogance desires to permanently uproot and destroy every single positive trait within the human system."
            "Shumbha falsely believes that zero power in the entire universe can withstand his concentrated brute force."
            "This verse illustrates the tactic of 'Isolation' where evil attempts to frighten everyone into submission."
            "However, the fool ignores that the one who is the Foundation of all requires zero external protection."
            "Shumbha's lethal threat is actually acting as the echo of his own impending cosmic death."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 88,
        sanskrit = "ऋषिरुवाच ॥ १४० ॥\nतेनाज्ञप्तस्ततः सोऽपि दैत्यो धूम्रलोचनः ।\nययौ सैन्येन महता वृतः षष्ट्या सहस्रकैः ॥ १४१ ॥",
        hindi = """
            (धूम्रलोचन का कूच): "महर्षि मेधा ने कहा: शुम्भ की आज्ञा पाकर वह दैत्य धूम्रलोचन तुरंत वहाँ से चल पड़ा।"
            "वह अपने साथ 'साठ हज़ार' (षष्ट्या सहस्रकैः) असुरों की एक विशाल सेना लेकर हिमालय की ओर गया।"
            "साठ हज़ार की सेना इंसान के दिमाग में चलने वाले उन हज़ारों 'भ्रमित विचारों' (Confused Thoughts) का प्रतीक है।"
            "धूम्रलोचन (धुआं) हमेशा 'संख्या' (Quantity) पर भरोसा करता है क्योंकि उसके पास 'क्वालिटी' (Quality) नहीं है।"
            "जब इंसान के अंदर अज्ञान जागता है, तो वह एक-दो नहीं, बल्कि हज़ारों तर्क लेकर सच्चाई पर हमला करता है।"
            "हिमालय की ओर जाना मतलब ऊँची चेतना (Higher Consciousness) को कुचलने का एक नाकाम प्रयास।"
            "असुरों की भीड़ उस 'शोर' (Noise) की तरह है जो मन की शांति को भंग करना चाहती है।"
            "शुम्भ के आदेश का पालन करना यह दिखाता है कि अज्ञान हमेशा अहंकार का गुलाम बनकर काम करता है।"
            "साठ हज़ार सैनिक उस 'अहंकार के नेटवर्क' को दर्शाते हैं जिसने पूरे मन को घेर लिया है।"
            "अब युद्ध का वह क्षण आ गया है जहाँ संख्या बल का सामना 'दिव्य शक्ति' से होने वाला है।"
        """.trimIndent(),
        english = """
            (Dhumralochana's March): "The Sage Medha said: Receiving Shumbha's command, that demon Dhumralochana immediately marched forward."
            "He headed toward the Himalayas surrounded by a colossal army of 'Sixty Thousand' (Shashtya-sahasrakaih) demons."
            "The army of sixty thousand symbolizes the thousands of 'Confused Thoughts' that swarm a human mind."
            "Dhumralochana (The Smoke) perpetually relies on 'Quantity' because he lacks the 'Quality' of Truth."
            "When ignorance awakens within a human, it does zero to attack with one logic, but with thousands of fallacies."
            "Marching toward the Himalayas represents a futile attempt to crush the state of Higher Consciousness."
            "The crowd of demons is like the mental 'Noise' that desperately seeks to shatter absolute inner peace."
            "Following Shumbha's order proves that ignorance always operates as a pathetic slave to the central ego."
            "Sixty thousand soldiers illustrate the 'Network of Arrogance' that has successfully surrounded the entire mind."
            "The moment of battle has arrived where raw numbers will finally confront the absolute singular Divine Power."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 89,
        sanskrit = "स दृष्ट्वा तां ततो देवीं हिमवन्तं व्यवस्थिताम् ।\nजगादोच्चैः प्रयाहीति शुम्भनिशुम्भयोः अन्तिकम् ॥ १४२ ॥",
        hindi = """
            (धूम्रलोचन की दहाड़): "हिमालय पर विराजमान उस परम देवी को देखकर धूम्रलोचन ने ज़ोर से चिल्लाकर कहा।"
            "'अरे! तू अभी इसी वक्त शुम्भ और निशुम्भ के पास 'चल' (प्रयाहीति)'।"
            "धूम्रलोचन की आँखों में धुआं है, इसलिए वह देवी के 'तेज़' को देखकर भी डरा नहीं।"
            "अज्ञानी व्यक्ति साक्षात् विनाश को सामने देखकर भी अपनी 'अकड़' (Attitude) नहीं छोड़ता।"
            "'जगाद उच्चैः' (ज़ोर से चिल्लाना)—शोर मचाना कमज़ोर मन की निशानी है जो अपनी ताकत साबित करना चाहता है।"
            "वह देवी को 'आदेश' दे रहा है, जो कि ब्रह्मांड का सबसे बड़ा मज़ाक (Cosmic Joke) है।"
            "अहंकार को लगता है कि उसकी आवाज़ की ऊँचाई सत्य को झुका सकती है।"
            "वह देवी को केवल एक 'पकड़ी जाने वाली वस्तु' समझ रहा है, जो शुम्भ के पास जानी चाहिए।"
            "यह श्लोक उस 'अंधे साहस' (Blind Courage) का प्रतीक है जो केवल मूर्खता से पैदा होता है।"
            "धूम्रलोचन ने अपनी पहली और आखिरी गलती कर दी है—उसने शक्ति को ललकारा है।"
        """.trimIndent(),
        english = """
            (Dhumralochana's Shout): "Spotting the Supreme Goddess residing upon the Himalayas, Dhumralochana shouted with extreme arrogance."
            "'Hey You! Depart right this exact moment (Prayahiti) to the presence of Shumbha and Nishumbha'."
            "Dhumralochana has smoke in his eyes, which is why he failed to be terrified even by the Goddess's Radiance."
            "An ignorant person does zero to abandon his 'Stiffness' even when facing absolute certain destruction."
            "Shouting loudly ('Jagada-uchhaih') is a sign of a weak mind attempting to prove its non-existent dominance."
            "He is issuing a 'Command' to the Goddess, which is undeniably the absolute greatest Cosmic Joke in existence."
            "Arrogance falsely believes that the volume of its voice can successfully force Absolute Truth to bow."
            "He perceives the Goddess as a mere 'Object to be Captured' who rightfully belongs to Shumbha's palace."
            "This verse symbolizes that 'Blind Courage' which originates strictly from deep-seated intellectual stupidity."
            "Dhumralochana has successfully committed his first and final mistake—he has challenged the Primal Power."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 90,
        sanskrit = "न चेत्प्रीत्या भवती मदभर्तारमुपैष्यति ।\nततो बलान्नयाम्येतां केशाकर्षणविह्वलाम् ॥ १४३ ॥",
        hindi = """
            (धमकी का दोहराव): "'यदि तू प्रेमपूर्वक मेरे स्वामी (शुम्भ) के पास नहीं चलेगी'।"
            "'तो मैं तुझे यहाँ से 'बाल पकड़कर' घसीटते हुए और 'बलपूर्वक' (बलान्नयामि) उठा ले जाऊंगा'।"
            "धूम्रलोचन वही भाषा बोल रहा है जो उसके मालिक शुम्भ ने उसे सिखाई थी।"
            "यह दिखाता है कि अज्ञान के विचार (Thought) हमेशा अहंकार (Ego) की ही कॉपी (Copy) होते हैं।"
            "'न चेत् प्रीत्या' (यदि प्रेम से नहीं)—बुराई के लिए प्रेम का अर्थ केवल 'गुलामी स्वीकार करना' होता है।"
            "ज़बरदस्ती ले जाने की धमकी देना इंसान की उस 'पाश्विक वृत्ति' (Brutal Instinct) को दर्शाता है।"
            "जब कोई तर्क काम नहीं आता, तो अज्ञान 'हिंसा' (Violence) का सहारा लेने की कोशिश करता है।"
            "धूम्रलोचन को पूरा भरोसा है कि वह अपनी साठ हज़ार की सेना के दम पर देवी को डरा लेगा।"
            "वह यह भूल गया है कि वह उस माँ को धमकी दे रहा है जो एक पल में पूरे ब्रह्मांड को भस्म कर सकती है।"
            "यह अहंकार का वह 'ओवरकॉन्फिडेंस' है जो उसे सीधी मौत के मुंह में ले जा रहा है।"
        """.trimIndent(),
        english = """
            (Repeated Threat): "'If You do zero go affectionately to my master (Shumbha) voluntarily'."
            "'Then I shall forcefully (Balannayami) carry You away, dragging You by Your hair until You are shattered'."
            "Dhumralochana is repeating the exact linguistic patterns taught to him by his master Shumbha."
            "This proves that the thoughts of ignorance are merely pathetic 'Copies' of the central toxic ego."
            "'If not by love'—For evil, the word 'Love' strictly translates to 'Total Unconditional Slavery'."
            "Threatening to take Her by force reveals the absolute 'Brutal Instinct' inherent in a corrupted mind."
            "When all logical reasoning fails, thick ignorance desperately attempts to utilize 'Violence' to succeed."
            "Dhumralochana is entirely confident that his sixty thousand soldiers can successfully terrorize the Goddess."
            "He has forgotten that he is threatening the Mother who can incinerate the entire cosmos in a split-second."
            "This represents the fatal 'Overconfidence' of arrogance that is driving it straight into the mouth of death."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 91,
        sanskrit = "देव्युवाच ॥ १४४ ॥\nदैत्येश्वरेण प्रहितो बली बलसमन्वितः ।\nयद्येवं बलवान् कश्चित् ततः किं करवाण्यहम् ॥ १४५ ॥",
        hindi = """
            (देवी का रहस्यमयी उत्तर): "देवी ने बहुत ही शांति से कहा: 'अरे! तू तो दैत्यराज का भेजा हुआ अत्यंत बलशाली (बली) और शक्तिशाली योद्धा है'।"
            "'यदि तू वास्तव में इतना बलवान है और तेरे साथ इतनी बड़ी सेना है, तो फिर मैं 'अकेली' क्या कर सकती हूँ?'"
            "देवी यहाँ फिर से 'विनम्रता' का नाटक कर रही हैं, जिसे अज्ञानी कभी डिकोड नहीं कर पाएगा।"
            "वे धूम्रलोचन को यह महसूस करा रही हैं कि वह बहुत 'बड़ा' और 'ताकतवर' है।"
            "तन्त्र में इसे 'शत्रु का अहंकार बढ़ाना' कहते हैं, ताकि वह असावधान (Careless) हो जाए।"
            "माता का 'किं करवाण्यहम्' (मैं क्या कर सकती हूँ) कहना उस खौफनाक शांति की तरह है जो प्रलय से पहले आती है।"
            "सत्य कभी भी मूर्ख से बहस नहीं करता, वह उसे उसकी ही मूर्खता में और गहरा डूबने देता है। "
            "धूम्रलोचन को लग रहा है कि देवी ने 'हार मान ली' है, जो उसकी सबसे बड़ी गलतफहमी है।"
            "सत्य की 'नरमी' (Softness) ही अज्ञान के लिए सबसे खतरनाक जाल (Trap) साबित होने वाली है।"
            "अब देवी वह प्रहार करेंगी जो धूम्रलोचन के अस्तित्व को ही मिटा देगा।"
        """.trimIndent(),
        english = """
            (The Goddess's Mysterious Response): "The Goddess spoke with absolute calm: 'Oh! You are a powerful warrior dispatched by the Demon King himself'."
            "'If You are indeed so powerful and possess such a massive army, then what can I, 'Alone', possibly do?'"
            "The Goddess is playing the role of 'Humility' once again, which ignorance can mathematically never decode."
            "She is making Dhumralochana feel exceptionally 'Large' and 'Invincible' in his own mind."
            "In advanced Tantra, this is called 'Inflating the Enemy's Ego' to make them psychologically Careless."
            "Her question 'What can I do?' is like that terrifying silence that perpetually precedes a cosmic apocalypse."
            "Truth never argues with a fool; it simply allows the fool to drown deeper in his own non-existent logic."
            "Dhumralochana deludes himself into thinking that the Goddess has 'Surrendered', which is his final hallucination."
            "The 'Softness' of Absolute Truth is destined to prove as the most lethal Trap for thick ignorance."
            "Now the Goddess is officially preparing to execute that strike which will delete Dhumralochana's existence."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 92,
        sanskrit = "ऋषिरुवाच ॥ १४६ ॥\nइत्युक्तः सोऽभ्यधावत्तां असुरो धूम्रलोचनः ।\nहुङ्कारेणैव तं भस्म सा चकाराम्बिका तदा ॥ १४७ ॥",
        hindi = """
            (हुंकार से भस्म होना): "ऋषि मेधा ने कहा: देवी के ऐसा कहते ही, वह असुर धूम्रलोचन उन्हें पकड़ने के लिए पागलों की तरह 'दौड़ पड़ा'।"
            "परंतु साक्षात् अम्बिका ने केवल एक भयंकर 'हुं' (Humkara) का उच्चारण किया और वह असुर 'उसी क्षण' जलकर 'राख' (भस्म) हो गया!"
            "यह पूरी सप्तशती के सबसे 'मिरेकुलस' (Miraculous) और 'पावरफुल' क्षणों में से एक है!"
            "देवी ने न कोई तलवार चलाई, न कोई तीर—उन्होंने केवल अपनी 'आवाज़' (Vibration) का उपयोग किया।"
            "'हुंकार' तन्त्र में वह अग्नि बीज है जो किसी भी भौतिक पदार्थ को एक सेकंड में डी-मटेरियलाइज़ (De-materialize) कर सकता है।"
            "धूम्रलोचन (भ्रम) का अंत केवल 'हुंकार' (चेतना की गर्जना) से ही संभव है।"
            "जब इंसान 'मौन' होकर अपने अंदर की दिव्य ध्वनि सुनता है, तो उसका सारा अज्ञान (धुआं) राख बन जाता है।"
            "अहंकार की साठ हज़ार की सेना देखती रह गई और उनका लीडर एक आवाज़ से 'डिलीट' हो गया।"
            "यह श्लोक सिद्ध करता है कि 'मैटर' (Matter) हमेशा 'माइंड' (Consciousness) के अधीन होता है।"
            "अज्ञान का धुआं अब सत्य की अग्नि में हमेशा के लिए विलीन हो चुका है।"
        """.trimIndent(),
        english = """
            (Incinerated by Humkara): "The Sage said: The moment the Goddess spoke, that demon Dhumralochana aggressively 'Sprinted' to capture Her."
            "However, Mother Ambika merely uttered a single terrifying sound of 'Hum' (Humkara), and that demon turned to 'Ashes' instantly!"
            "This is undeniably one of the most 'Miraculous' and 'Powerful' moments inside the entire Durga Saptashati!"
            "The Goddess utilized zero swords and zero arrows—She exclusively utilized the power of Her 'Vibration' (Sound)."
            "'Humkara' is the exact Fire Seed Mantra capable of De-materializing any physical object in a single split-second."
            "The destruction of Dhumralochana (Delusion) is strictly possible only through the 'Roar of Consciousness'."
            "When a human attains 'Silence' and hears his internal divine sound, all his thick ignorance (smoke) turns to ashes."
            "The army of sixty thousand stood paralyzed as their leader was 'Deleted' by a mere vibration of air."
            "This specific verse proves that physical 'Matter' is perpetually the slave of Supreme 'Consciousness'."
            "The smoke of ignorance has now been permanently absorbed into the absolute fire of Truth."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 93,
        sanskrit = "अथ क्रुद्धं महासैन्यमसुराणां तथाम्बिका ।\nववर्ष सायकैस्तीक्ष्णैस्तथा शक्तिपरश्वधैः ॥ १४८ ॥",
        hindi = """
            (सेना पर प्रहार): "अपने सेनापति को राख होते देखकर, राक्षसों की वह 'विशाल सेना' भयंकर क्रोध (क्रुद्धं) में आ गई।"
            "तब माता अम्बिका ने उन पर तीखे 'बाणों', 'शक्तियों' और 'फरसों' (परश्वधैः) की मूसलाधार बारिश कर दी!"
            "जब अज्ञान का 'लीडर' मरता है, तो उसके पीछे के 'विचार' (सेना) अनियंत्रित और हिंसक हो जाते हैं।"
            "देवी अब केवल एक को नहीं, बल्कि अज्ञान के उस पूरे 'सिस्टम' (System) पर प्रहार कर रही हैं।"
            "बाण (Arrows) फोकस का प्रतीक हैं, और फरसा (Axe) जड़ों को काटने का प्रतीक है।"
            "चेतना अब उन सभी हज़ारों नकारात्मक विचारों को एक साथ 'क्लीन' (Clean) कर रही है।"
            "राक्षसों का क्रोध उनकी लाचारी का सबूत है—वे समझ चुके हैं कि वे किसी अजेय शक्ति से लड़ रहे हैं।"
            "मूसलाधार बारिश की तरह अस्त्रों का गिरना यह बताता है कि सत्य का प्रहार 'अटूट' (Incessant) होता है।"
            "जब शुद्धि की प्रक्रिया (Cleansing) शुरू होती है, तो कोई भी विकार बच नहीं पाता।"
            "अम्बिका अब रणभूमि में साक्षात् प्रलयंकारी अग्नि की तरह नाच रही हैं।"
        """.trimIndent(),
        english = """
            (Assault on the Army): "Seeing their commander reduced to ashes, that 'Massive Army' of demons erupted in absolute destructive Wrath."
            "Then Mother Ambika unleashed a torrential rain of sharp 'Arrows', 'Spears', and 'Battle-axes' (Parashvadha) upon them!"
            "Exactly when the 'Leader' of ignorance dies, the associated 'Thoughts' (the army) become uncontrolled and violent."
            "The Goddess is now attacking zero singular entity, but the entire underlying 'System' of thick ignorance."
            "Arrows symbolize absolute Focus, while the Battle-axe represents the power to Uproot the source of evil."
            "Consciousness is now simultaneously 'Cleaning' all those thousands of negative psychological patterns."
            "The wrath of the demons is the proof of their helplessness—they realize they are fighting an invincible power."
            "The rain-like fall of weapons proves that the strike of Absolute Truth is perpetually 'Incessant' and unavoidable."
            "Once the process of spiritual 'Cleansing' initiates, mathematically zero mental distortions can survive."
            "Ambika is now dancing in the battlefield like the absolute primary fire of a cosmic apocalypse."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 94,
        sanskrit = "ततः खड्गप्रहारैश्च छिन्नबाहुशिरोधराः ।\nतथान्ये च रणे मुक्ताः केशाकर्षणविह्वलाः ॥ १४९ ॥",
        hindi = """
            (भयंकर वध): "देवी की तलवार के प्रहारों से उन असुरों की 'बाहु' (भुजाएं) और 'मस्तक' (सिर) कट-कट कर ज़मीन पर गिरने लगे।"
            "कई राक्षसों के बाल पकड़कर माता ने उन्हें हवा में घुमाया और ज़मीन पर पटक कर मार डाला।"
            "यहाँ देवी वही 'केशाकर्षण' (बाल पकड़ना) वापस कर रही हैं जिसकी धमकी शुम्भ ने दी थी।"
            "यह 'कर्मों का हिसाब' (Karmic Retribution) है—जो तुम दूसरों के साथ करोगे, वही तुम्हारे साथ होगा।"
            "भुजाओं का कटना मतलब 'काम करने की गलत शक्ति' का छिन जाना।"
            "सिर का कटना मतलब 'गलत थॉट प्रोसेस' (Wrong Intelligence) का हमेशा के लिए अंत होना।"
            "रणभूमि अब अज्ञान के मलबे से भर चुकी थी, जहाँ एक-एक करके सारे विकार मिटाए जा रहे थे।"
            "देवी की तलवार (विवेक) इतनी तेज़ है कि वह भ्रम की सबसे गहरी परतों को भी चीर देती है।"
            "अहंकार की सेना अब अपनी मौत के मंज़र को अपनी आँखों से देख रही थी।"
            "सत्य का यह उग्र रूप अज्ञान को डराने के लिए नहीं, बल्कि उसे 'आज़ाद' (Liberate) करने के लिए है।"
        """.trimIndent(),
        english = """
            (The Terrifying Slaughter): "By the strikes of the Goddess's sword, the 'Arms' and 'Heads' of those demons were severed and dropped to the dirt."
            "Mother grabbed many demons by their hair, swung them in the air, and slammed them to their absolute death."
            "Here, the Goddess is returning the exact same 'Hair-pulling' (Kesha-karshana) that Shumbha had previously threatened."
            "This represents the absolute law of 'Karmic Retribution'—whatever You intend for others, You shall receive."
            "Severing the arms symbolizes the total loss of the 'Power to execute wrong actions'."
            "Severing the heads represents the permanent end of the 'Corrupted Thought Process' and toxic intelligence."
            "The battlefield was now filled with the debris of ignorance, where every distortion was being systematically erased."
            "The Goddess's sword (Wisdom) is so exceptionally sharp that it pierces the deepest layers of delusion."
            "The army of arrogance was now witnessing its own brutal annihilation with its own terrified eyes."
            "This fierce format of Truth is intended zero to terrorize, but strictly to 'Liberate' from the cycle of ignorance."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 95,
        sanskrit = "तथा परे च मथिताः शूलाग्रेण विदारिताः ।\nमुष्टिप्रहारैश्च परे पतिता धरणीतले ॥ १५० ॥",
        hindi = """
            (गदा और मुक्कों से वध): "कई असुरों को माता ने अपने त्रिशूल की नोक (शूलाग्रेण) से चीर कर रख दिया।"
            "बाकी बचे हुए राक्षसों को देवी ने अपने 'मुक्कों' (Fists) के भयंकर प्रहार से ज़मीन पर सुला दिया।"
            "त्रिशूल की नोक 'पिन-पॉइंट एक्यूरेसी' (Pin-point accuracy) का प्रतीक है—हर बुराई का खास इलाज।"
            "मुक्कों से मारना (Fist strikes) देवी के उस 'रा' (Raw) और 'फिजिकल' पराक्रम को दिखाता है जिसे अज्ञान सह नहीं सकता।"
            "जब शब्द और तर्क खत्म हो जाते हैं, तो चेतना अपने प्रचंड 'एक्शन' (Action) से काम लेती है।"
            "धरणीतले (धरती पर) गिरना अहंकार के पूर्ण 'पतन' (Fall) का प्रतीक है।"
            "असुरों को कुचलना यह बताता है कि सत्य के सामने झूठ की हैसियत महज़ मिट्टी जैसी है।"
            "देवी के हाथ अब अज्ञान को पूरी तरह से 'मथ' (Churn) रहे थे, ताकि उसमें से गंदगी बाहर निकल सके।"
            "हर मुक्का इंसान की एक 'बुरी आदत' को तोड़ने वाली चोट है।"
            "रणभूमि अब धीरे-धीरे अशुद्धियों से मुक्त होती जा रही थी।"
        """.trimIndent(),
        english = """
            (Death by Trident and Fists): "The Mother ripped through many demons utilizing the sharp tip of Her Trident (Shulagrena)."
            "The remaining monsters were ruthlessly slammed to the dirt by the terrifying force of Her absolute 'Fists'."
            "The tip of the Trident symbolizes 'Pin-point Accuracy'—a specific divine remedy for every specific mental vice."
            "Striking with Fists showcases the 'Raw' and 'Physical' power of the Goddess which ignorance cannot withstand."
            "When words and logic are exhausted, Consciousness takes charge through its absolute 'Raw Action'."
            "Falling to the ground (Dharanitale) symbolizes the absolute total 'Fall' of human and cosmic arrogance."
            "Pulverizing the demons proves that before the Truth, lies hold zero value except that of common dirt."
            "The Goddess's hands were now 'Churning' (Mathitah) through ignorance to extract all toxic impurities."
            "Every fist-strike represents a psychological blow destined to break an old and 'Stubborn Habit'."
            "The battlefield was gradually becoming free from all forms of psychological and cosmic impurities."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 96,
        sanskrit = "दन्तप्रहारैश्च परे चूर्णितास्ते महासुराः ।\nएवं ननाश तत्सैन्यमसुराणां तदम्बिका ॥ १५१ ॥",
        hindi = """
            (दाँतों से चूर्ण करना): "देवी ने कई महा-असुरों को अपने 'दाँतों' से चबाकर पूरी तरह 'चूर्ण' (Dust) कर दिया।"
            "इस प्रकार माता अम्बिका ने उस पूरी की पूरी असुर सेना का नामो-निशान मिटा दिया।"
            "दाँतों से चबाना (Danta-prahara) तन्त्र में 'काल' (Time) का प्रतीक है जो हर चीज़ को निगल जाता है।"
            "समय के दाँत इतने मज़बूत होते हैं कि वे बड़े से बड़े अज्ञान और ईगो को पीस कर रख देते हैं।"
            "अम्बिका का यह रूप 'संहार' (Annihilation) की उस स्टेज को दिखाता है जहाँ कुछ भी शेष नहीं बचता।"
            "'ननाश' (नष्ट होना)—अब साठ हज़ार की वह भीड़ ज़ीरो (Zero) हो चुकी थी।"
            "संख्या बल (Quantity) कभी भी अजेय चेतना (Quality) के सामने टिक नहीं सका।"
            "अहंकार की पहली सुरक्षा दीवार (धूम्रलोचन और सेना) अब पूरी तरह ढह चुकी थी।"
            "यह श्लोक अज्ञान के पूर्ण 'क्लीन-अप' (Clean-up) की घोषणा करता है।"
            "अब शुम्भ के पास खबर पहुँचने वाली है कि उसका 'भ्रम' राख बन चुका है।"
        """.trimIndent(),
        english = """
            (Pulverized by Teeth): "The Goddess chewed and pulverized several mega-demons into fine 'Dust' utilizing Her teeth."
            "In this manner, Mother Ambika successfully erased every trace of that entire demonic army from existence."
            "Chewing with teeth (Danta-prahara) symbolizes the absolute power of 'Time' (Kaala) which consumes everything."
            "The teeth of Time are so exceptionally strong that they pulverize even the most colossal ignorance and ego."
            "This format of Ambika illustrates that stage of 'Annihilation' where absolutely nothing remains behind."
            "'Nanasha' (Perished)—The crowd of sixty thousand has now been successfully reduced to mathematical zero."
            "The power of numbers (Quantity) could mathematically never stand against Invincible Consciousness (Quality)."
            "The first defensive wall of Arrogance (Dhumralochana and his army) has now completely collapsed."
            "This verse formally announces the total 'Clean-up' of ignorance from the cosmic battlefield."
            "Now the news is about to reach Shumbha that his primary 'Delusion' has been reduced to ashes."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 97,
        sanskrit = "ऋषिरुवाच ॥ १५२ ॥\nततोऽम्बिकां परां रूपं बिभ्राणां सुमनोहरम् ।\nददर्श चण्डो मुण्डश्च भृत्यौ शुम्भनिशुम्भयोः ॥ १५३ ॥",
        hindi = """
            (चण्ड-मुण्ड का पुनरागमन): "महर्षि ने कहा: इसके बाद शुम्भ और निशुम्भ के मुख्य सेवक 'चण्ड' और 'मुण्ड' ने फिर से देवी को देखा।"
            "माता उस समय भी अपने अत्यंत सुंदर और 'मनमोहक' (सुमनोहरम्) रूप में हिमालय पर विराजमान थीं।"
            "युद्ध के बाद भी देवी की सुंदरता और शांति का 'भंग' न होना यह बताता है कि सत्य कभी थकता नहीं।"
            "चण्ड (गुस्सा) और मुण्ड (मूर्खता) अज्ञान के वे दो खंभे हैं जो अभी भी सुरक्षित बचे थे।"
            "वे देवी को फिर से एक 'वस्तु' (Product) की तरह देख रहे हैं, जो उनकी सबसे बड़ी भूल है।"
            "जब इंसान अपनी पहली हार (धूम्रलोचन) से नहीं सीखता, तो वह अपनी मौत को और पास बुला लेता है।"
            "सुमनोहर रूप अज्ञान को 'ललचाने' का एक दिव्य जाल है, ताकि बुराई खुद चलकर अंत तक पहुँच जाए।"
            "अहंकार की नज़र हमेशा 'सतही' (Superficial) होती है, वह गहराई को कभी नहीं देख पाती।"
            "चण्ड-मुण्ड अब शुम्भ को वह खबर देंगे जो पूरे पाताल लोक को हिला देगी।"
            "युद्ध का 'दूसरा चरण' (Second Phase) अब यहाँ से शुरू होने वाला है।"
        """.trimIndent(),
        english = """
            (The Return of Chanda and Munda): "The Sage said: Subsequently, the primary servants of Shumbha and Nishumbha, 'Chanda' and 'Munda', spotted the Goddess again."
            "The Mother was still residing upon the Himalayas in Her exceptionally beautiful and 'Enchanting' (Manoharam) form."
            "The fact that Her beauty and peace remain 'Undisturbed' even after a massacre proves that Truth never fatigues."
            "Chanda (Anger) and Munda (Stupidity) are the two pillars of ignorance that still remained intact."
            "They perceive the Goddess again as a mere 'Object' to be possessed, which is their fatal psychological error."
            "When a human fails to learn from his first defeat (Dhumralochana), he accelerates his own final death."
            "The enchanting form is a divine trap designed to 'Lure' evil toward its absolute logical conclusion."
            "The gaze of Arrogance is perpetually 'Superficial'; it is mathematically incapable of perceiving Depth."
            "Chanda and Munda will now deliver the news that is destined to shake the entire demonic realm."
            "The 'Second Phase' of the cosmic war is officially preparing to launch from this moment onward."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 98,
        sanskrit = "ताभ्यां शुम्भाय चाख्याता साऽतीव सुमनोहरा ।\nकाप्यस्ते स्त्री महाराज भासयन्ती हिमाचलम् ॥ १५४ ॥",
        hindi = """
            (शुम्भ को रिपोर्टिंग): "उन्होंने जाकर शुम्भ से कहा: 'हे महाराज! वह अत्यंत सुंदर स्त्री अभी भी वहीं हिमालय को चमका रही है'।"
            "'धूम्रलोचन और उसकी सेना का तो विनाश हो गया, पर वह स्त्री अभी भी वैसी ही शांत और तेजस्वी है'।"
            "अहंकार अपनी हार की खबर सुनकर और भी ज़्यादा 'ऑब्सेस्ड' (Obsessed) हो जाता है।"
            "शुम्भ को लग रहा है कि जो चीज़ इतनी ताकतवर (धूम्रलोचन) को मार सकती है, वह कितनी 'कीमती' होगी।"
            "अज्ञानी मन 'शक्ति' की कीमत केवल उसे 'कब्ज़ा' करने के लिए लगाता है, 'सीखने' के लिए नहीं।"
            "हिमाचल को चमकाना (Bhasayanti) यह संकेत है कि सत्य का प्रकाश अज्ञान की हर सेना पर भारी है।"
            "चण्ड-मुण्ड यहाँ 'आग में घी' डालने का काम कर रहे हैं, ताकि शुम्भ अपना आपा खो दे।"
            "अहंकार अक्सर अपनी हार का बदला लेने के लिए अपनी पूरी ताकत दांव पर लगा देता है।"
            "वह स्त्री (देवी) अब शुम्भ के लिए केवल एक 'इच्छा' नहीं, बल्कि एक 'चुनौती' बन चुकी है।"
            "यह श्लोक अज्ञान के उस पागलपन को दिखाता है जो मौत को सामने देखकर भी नहीं रुकता।"
        """.trimIndent(),
        english = """
            (Reporting to Shumbha): "They reported to Shumbha: 'O King! That exceptionally beautiful woman is still illuminating the Himalayas'."
            "'Dhumralochana and his army have perished, yet that woman remains as peaceful and radiant as before'."
            "Arrogance becomes even more 'Obsessed' upon hearing the news of its own initial defeat."
            "Shumbha falsely assumes that an entity capable of killing someone as powerful as Dhumralochana must be 'Extremely Valuable'."
            "The ignorant mind values 'Power' only to 'Possess' it, never to 'Learn' or grow from it."
            "Illuminating the mountain (Bhasayanti) signals that the light of Truth outweighs any army of ignorance."
            "Chanda and Munda are effectively 'Adding fuel to the fire', making Shumbha lose his psychological balance."
            "Ego often bets its entire existence strictly to avenge a minor loss of its perceived pride."
            "That Woman (Goddess) has now transformed from a mere 'Desire' into a lethal 'Challenge' for Shumbha."
            "This verse illustrates the madness of ignorance that refuses to halt even when facing certain death."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 99,
        sanskrit = "नैव तादृक् क्वचित् रूपं दृष्टं केनचिदुत्तमम् ।\nज्ञायतां काप्यसौ देवी गृह्यतां चासुरेश्वर ॥ १५५ ॥",
        hindi = """
            (लालच और सुझाव): "'हे असुरेश्वर! ऐसी उत्तम सुंदरता दुनिया में किसी ने कभी नहीं देखी होगी, आप इसे प्राप्त करें'।"
            "'आप पता लगाइए कि वह दिव्य शक्ति कौन है और उसे अपने अधिकार में कर लीजिए'।"
            "चण्ड-मुण्ड शुम्भ के 'लालच' को उस बिंदु तक ले जा रहे हैं जहाँ से वापसी मुमकिन नहीं है।"
            "अहंकार को हमेशा 'बेस्ट' (Best) चीज़ चाहिए होती है, चाहे वह उसके विनाश का कारण ही क्यों न हो।"
            "'ज्ञायतां' (पता लगाओ)—अहंकार सत्य को 'समझना' नहीं, बल्कि उसे 'इन्वेस्टिगेट' (Investigate) करना चाहता है।"
            "बुराई हमेशा पवित्रता को अपनी 'प्रॉपर्टी' (Property) बनाने का सपना देखती है।"
            "शुम्भ को लगा कि वह ब्रह्मांड की 'प्राइमल एनर्जी' को अपनी तिजोरी में बंद कर सकता है।"
            "यह उस भ्रम का चरम है जहाँ जीव खुद को 'क्रिएटर' से भी ऊपर समझने लगता है।"
            "जब इंसान अपने आस-पास के चाटुकारों की बात सुनता है, तो वह अपनी मौत को न्योता देता है।"
            "अब शुम्भ अपनी पूरी ताकत के साथ देवी पर हमला करने की योजना बनाने लगा है।"
        """.trimIndent(),
        english = """
            (Greed and Suggestion): "'O King of Demons! Such supreme beauty has never been witnessed by anyone; You must acquire Her'."
            "'Investigate exactly who that divine power is and bring Her under Your absolute dominance'."
            "Chanda and Munda are pushing Shumbha's 'Greed' to the point of no return across the cosmic scale."
            "Arrogance perpetually demands the 'Best' (Uttamam) objects, even if they act as the catalyst for its ruin."
            "'Identify Her'—Ego does zero to seek 'Understanding' of Truth, but rather desires to 'Investigate' and control it."
            "Evil perpetually dreams of transforming absolute Purity into its personal material 'Property'."
            "Shumbha deluded himself into thinking he could lock the 'Primal Energy' of the universe in his vault."
            "This is the peak of delusion where the individual self starts perceiving itself as superior to the Creator."
            "When a human listens to sycophants around him, he is effectively issuing an invitation to his own death."
            "Now Shumbha is actively planning to launch a full-scale assault on the Goddess with his entire strength."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 100,
        sanskrit = "स्त्रीरत्नमतिचार्वङ्गी द्योतयन्ती दिशस्त्विषा ।\nसा तु तिष्ठति दैत्येन्द्र तां भवान् द्रष्टुमर्हति ॥ १५६ ॥",
        hindi = """
            (स्त्री-रत्न का प्रलोभन): "'वह स्त्री-रत्न है, जिसके अंग अत्यंत सुंदर हैं और जिसकी कांति चारों दिशाओं को प्रकाशित कर रही है'।"
            "'वह अभी हिमालय पर ही मौजूद है, आपको स्वयं चलकर उसे देखना और प्राप्त करना चाहिए'।"
            "यहाँ देवी को फिर से 'स्त्री-रत्न' (Jewel among women) कहा गया है, जो अज्ञान के सतहीपन को दिखाता है।"
            "अहंकार हर कीमती चीज़ को एक 'रत्न' या 'संपत्ति' (Asset) की तरह देखता है।"
            "'अतिचार्वङ्गी' (Perfect features) का अर्थ है कि अज्ञान केवल बाहरी 'पैकेजिंग' पर ही अटका रहता है।"
            "वे उस रोशनी (त्विषा) को तो देख पा रहे हैं, पर उस रोशनी के पीछे की 'प्रलयंकारी शक्ति' को नहीं देख पा रहे।"
            "सत्य (देवी) जब प्रकट होता है, तो वह इतना चमकता है कि उसे अनदेखा करना असंभव है।"
            "शुम्भ को 'दैत्येन्द्र' (दैत्यों का राजा) कहकर उकसाना उसकी असुरक्षा को दबाने के लिए है।"
            "अहंकार को हमेशा अपनी तारीफ और 'एलिजिबिलिटी' (Eligibility) सुनना पसंद होता है।"
            "देवी अब उस शिकार की तरह दिख रही हैं, जो वास्तव में पूरी असुर सेना का संहारक (Slayer) है।"
        """.trimIndent(),
        english = """
            (Temptation of the Jewel): "'She is a jewel among women, with perfect features illuminating all directions with Her glow'."
            "'She is currently residing on the Himalayas; You rightfully deserve to go, see, and possess Her'."
            "The Goddess is addressed again as 'Stri-ratna' (Jewel), highlighting the extreme superficiality of ignorance."
            "Arrogance perceives every valuable thing strictly as a 'Jewel' or a material 'Asset' to be owned."
            "'Aticharvangi' (Perfect features) proves that ignorance remains perpetually stuck on external 'Packaging'."
            "They can observe the Radiance (Tvisha), but are blind to the 'Apocalyptic Power' hidden behind that light."
            "When Truth (Goddess) manifests, it shines so intensely that ignoring it becomes mathematically impossible."
            "Addressing Shumbha as 'Daityendra' is a manipulative tactic to soothe his underlying cosmic insecurity."
            "Ego perpetually craves to hear about its own 'Eligibility' to possess the finest things in existence."
            "The Goddess currently appears as a 'Target', while in reality, She is the absolute Slayer of the entire demonic army."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 101,
        sanskrit = "यानि रत्नानि मणयो गजादीनि च ते गृहे ।\nत्रैलोक्ये तु समस्तानि सम्प्रतीह मया विभो ॥ १५७ ॥",
        hindi = """
            (संपत्ति का ऑडिट): "'हे प्रभु! आपके महल में तो तीनों लोकों के सबसे श्रेष्ठ रत्न, मणियां और गज (हाथी) मौजूद हैं'।"
            "'ब्रह्मांड की हर कीमती चीज़ पर अभी आपका ही अधिकार है, यह सब मैंने अपनी आँखों से देखा है'।"
            "चण्ड-मुण्ड शुम्भ की 'नेटवर्थ' (Net worth) का ऑडिट पेश कर रहे हैं ताकि वह खुद को सबसे बड़ा माने।"
            "अहंकार को अपनी 'संपत्तियों' (Possessions) की लिस्ट सुनना बहुत पसंद होता है।"
            "रत्न और मणियां इंसान की 'सफलता' के भौतिक प्रतीक हैं, जो उसे अंधी खुशी देते हैं।"
            "परंतु अज्ञानी इंसान यह भूल जाता है कि ये सब 'बाहरी' चीज़ें हैं, जो आत्मा को कभी शांति नहीं दे सकतीं।"
            "शुम्भ को 'विभो' (शक्तिशाली) कहकर पुकारना उसके उस भ्रम को और मज़बूत करता है कि वह अजेय है।"
            "जब हमें अपनी पिछली जीत याद दिलाई जाती है, तो हम अपनी अगली और सबसे बड़ी हार की तैयारी करते हैं।"
            "तीनों लोकों पर कब्ज़ा होना यह बताता है कि ईगो ने हमारी पूरी चेतना को हाइजैक कर लिया है।"
            "अब केवल एक ही चीज़ की कमी थी, जिसे चण्ड-मुण्ड ने शुम्भ के लिए 'अनिवार्य' (Mandatory) बना दिया था।"
        """.trimIndent(),
        english = """
            (Audit of Assets): "'O Lord! Your palace already contains the finest jewels, gems, and elephants of all three worlds'."
            "'Every precious object of the cosmos is currently under Your authority; I have witnessed this with my own eyes'."
            "Chanda and Munda are presenting an audit of Shumbha's 'Net Worth' strictly to inflate his self-importance."
            "Arrogance perpetually craves to hear the list of its worldly 'Possessions' to validate its existence."
            "Jewels and gems are physical symbols of human 'Success' that grant a deceptive and hollow joy."
            "However, the ignorant human forgets that these are 'External' objects that can mathematically never grant peace."
            "Addressing him as 'Vibho' (Powerful) reinforces Shumbha's delusion that he is absolutely invincible."
            "When we are reminded of our past victories, we often unconsciously prepare for our absolute greatest defeat."
            "Possessing three worlds implies that the Ego has completely hijacked the entire human consciousness."
            "There was strictly only one piece missing, which Chanda and Munda made 'Mandatory' for Shumbha to acquire."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 102,
        sanskrit = "ऐरावतः समानीतो गजरत्नं पुरन्दरात् ।\nपारिजाततरुश्चायं तथैवोच्चैःश्रवा हयः ॥ १५८ ॥",
        hindi = """
            (इन्द्र के रत्नों की सूची): "'आपने इन्द्र से गजों में श्रेष्ठ 'ऐरावत हाथी' को पहले ही छीन लिया है'।"
            "'स्वर्ग का वह दिव्य 'पारिजात वृक्ष' और घोड़ों में सबसे तेज़ 'उच्चैःश्रवा' घोड़ा भी अब आपका ही है'।"
            "ऐरावत 'मानसिक शक्ति' का प्रतीक है, पारिजात 'इच्छाओं' का और उच्चैःश्रवा 'विचारों के वेग' का।"
            "जब अहंकार (शुम्भ) हावी होता है, तो वह हमारी यादों, सपनों और तेज़ बुद्धि—सब पर कब्ज़ा कर लेता है।"
            "इंसान को लगता है कि उसने अपनी मेहनत से यह सब पाया है, पर वास्तव में उसने इसे अपनी 'शुद्धता' से छीना होता है।"
            "ये तीनों चीज़ें 'दुर्लभ' (Rare) हैं, और अहंकार केवल दुर्लभ चीज़ों को ही अपना 'मेडल' बनाना चाहता है।"
            "शुम्भ के पास 'स्वर्ग' का सारा वैभव था, पर उसके पास वह 'शांति' नहीं थी जो देवी के पास है।"
            "छीनी हुई चीज़ों का घमंड करना अज्ञान का सबसे निचला स्तर (Lowest Level) है।"
            "वह यह नहीं समझ पा रहा कि जो चीज़ 'छीनी' गई है, वह 'प्रकृति' के नियम के अनुसार वापस भी ली जाएगी।"
            "अहंकार की यह इन्वेंट्री (Inventory) अब उसके विनाश की वज़ह बनने वाली है।"
        """.trimIndent(),
        english = """
            (Inventory of Indra's Jewels): "'You have already snatched the jewel among elephants, 'Airavata', from Indra himself'."
            "'The divine 'Parijata Tree' and the fastest celestial horse 'Uchhaishrava' are also now Your properties'."
            "Airavata symbolizes 'Mental Power', Parijata represents 'Desires', and Uchhaishrava is the 'Velocity of Thought'."
            "When Arrogance (Shumbha) dominates, it claims ownership over our memories, dreams, and intellectual speed."
            "A human falsely believes he earned these through merit, while he actually snatched them from his own 'Purity'."
            "These three objects are 'Rare', and arrogance perpetually seeks to turn rare objects into its personal 'Medals'."
            "Shumbha held all the glory of 'Heaven', yet lacked the absolute 'Peace' that resides with the Goddess."
            "Taking pride in snatched possessions is the absolute 'Lowest Level' of human and cosmic ignorance."
            "He fails to comprehend that whatever is 'Snatched' will be mathematically 'Reclaimed' by the laws of Nature."
            "This inventory of the Ego is now officially transforming into the primary catalyst for its destruction."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 103,
        sanskrit = "विमानं हंससंयुक्तमेतत्तिष्ठति ते अङ्गण ।\nरत्नभूतं विनिर्गतं यदासीद् वेधसो गृहात् ॥ १५९ ॥",
        hindi = """
            (ब्रह्मा का विमान): "'महाराज! हंसों से जुता हुआ वह दिव्य विमान भी अब आपके आंगन में खड़ा है'।"
            "'जो पहले ब्रह्मा जी (वेधसो) के पास था और पूरे ब्रह्मांड में एक अद्भुत रत्न के समान माना जाता था'।"
            "हंस 'विवेक' (Discrimination) का प्रतीक है—जो सही और गलत को अलग कर देता है।"
            "जब अहंकार (शुम्भ) बहुत शक्तिशाली हो जाता है, तो वह इंसान के 'विवेक' को भी अपनी कैद में कर लेता है।"
            "अब इंसान की बुद्धि वही सोचती है जो उसका घमंड उसे सोचने के लिए मजबूर करता है।"
            "ब्रह्मा जी का विमान 'सृजनात्मकता' का प्रतीक है, जो अब अज्ञान के 'आंगन' (कंट्रोल) में है।"
            "यह दृश्य बताता है कि कैसे बुराई हमारी सबसे पवित्र शक्तियों को भी अपने फायदे के लिए यूज़ करती है।"
            "अहंकार को लगता है कि वह अब 'क्रिएटर' (Creator) के बराबर पहुँच गया है और सब कुछ उसका है।"
            "पर विमान होने का मतलब यह नहीं कि आप 'उड़ना' जानते हैं, उसे चलाने के लिए 'पात्रता' चाहिए।"
            "शुम्भ की लिस्ट अब पूरी होने वाली है, बस अंतिम प्रहार की तैयारी बाकी है।"
        """.trimIndent(),
        english = """
            (Brahma's Chariot): "'O King! That divine aerial vehicle yoked with swans also stands in Your private courtyard'."
            "'Which previously belonged to Brahma and was considered a unique cosmic jewel across the universe'."
            "The Swan (Hamsa) symbolizes 'Discrimination'—the capacity to separate Truth from Falsehood."
            "When Arrogance (Shumbha) becomes omnipotent, it effectively imprisons the human's 'Wisdom' (The Swan Chariot)."
            "Now, the human intellect only processes data that validates and feeds its own central toxic pride."
            "Brahma's chariot represents 'Creativity', which is now trapped within the 'Courtyard' (Grip) of ignorance."
            "This scene demonstrates how evil exploits even our most sacred internal powers for personal material gain."
            "The Ego falsely believes it has achieved the status of the 'Creator' and owns every dimension of reality."
            "But possessing a chariot does zero to mean you know how to 'Fly'; flying requires spiritual 'Eligibility'."
            "Shumbha's inventory is reaching its absolute limit; the stage is set for the final apocalyptic strike."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 104,
        sanskrit = "निधिरेष महापद्मः समानीतो धनेश्वरात् ।\nकिञ्जल्किनीं ददौ चाब्धिर्मलानामम्लानपङ्कजाम् ॥ १६० ॥",
        hindi = """
            (कुबेर की निधि): "'आपने धन के देवता कुबेर से उनकी सबसे बड़ी 'महापद्म' नामक निधि को भी जीत लिया है'।"
            "'और समुद्र ने आपको कभी न मुरझाने वाले कमलों की माला 'किंजल्किनी' भेंट स्वरूप दी है'।"
            "महापद्म निधि 'असीमित धन' और 'रिसोर्स' का प्रतीक है—शुम्भ अब खुद को ब्रह्मांड का सबसे अमीर व्यक्ति मानता है।"
            "जब इंसान के पास बहुत पैसा आ जाता है, तो उसे लगता है कि वह भगवान से भी 'नेगोशिएट' कर सकता है।"
            "कमलों की माला सुंदरता का प्रतीक है, जिसे शुम्भ ने प्रकृति (समुद्र) से 'ज़बरदस्ती' लिया है।"
            "अहंकार जब प्रकृति को दबाता है, तो वह उसके 'सौंदर्य' (Beauty) को भी अपना गुलाम बना लेता है।"
            "शुम्भ अपनी 'दौलत' और 'शोहरत' का पूरा ब्यौरा देवी के सामने (चण्ड-मुण्ड के जरिए) रख रहा है।"
            "वह सोच रहा है कि इन कीमती चीज़ों की चमक में देवी का 'विवेक' खो जाएगा और वे मान जाएंगी।"
            "अज्ञानी मन हमेशा यह सोचता है कि हर चीज़ की एक 'कीमत' (Price) लगाई जा सकती है।"
            "परंतु शांति और सत्य की कोई कीमत नहीं होती; वे केवल 'शुद्ध मन' से ही प्राप्त होते हैं।"
        """.trimIndent(),
        english = """
            (Kubera's Wealth): "'You have conquered the God of Wealth, Kubera, and seized his greatest treasure, 'Mahapadma'."
            "'The Ocean has offered You 'Kinshalkini', a divine garland of lotuses that mathematically never fade'."
            "The Mahapadma treasure symbolizes 'Infinite Wealth' and resources—Shumbha considers himself the richest entity."
            "When a human possesses excessive money, he falsely believes he can successfully 'Negotiate' with the Divine."
            "The garland represents Beauty, which Shumbha has 'Forcefully' extracted from the forces of Mother Nature."
            "Exactly when Arrogance suppresses Nature, it enslaves even Her inherent aesthetics and cosmic beauty."
            "Shumbha is presenting a complete audit of his 'Wealth' to the Goddess through his messengers."
            "He assumes that in the blinding glow of these objects, the Goddess's 'Wisdom' will falter and She will yield."
            "The arrogant mind perpetually operates on the assumption that everything in existence has a 'Price Tag'."
            "However, Peace and Truth are Priceless; they can strictly only be attained through a 'Purified Mind'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 105,
        sanskrit = "छत्रं ते वारुणं गेहे काञ्चनस्त्रावि तिष्ठति ।\nतथायं स्यन्दनवरो यः पुरासीत् प्रजापतेः ॥ १६१ ॥",
        hindi = """
            (वरुण का छत्र): "'वरुण देव का वह सोने की वर्षा करने वाला दिव्य छत्र भी अब आपके ही महल में मौजूद है'।"
            "'और प्रजापति (ब्रह्मांड के रचयिता) का वह सबसे श्रेष्ठ रथ भी अब आपकी ही सवारी के लिए तैयार है'।"
            "छत्र (Umbrella) 'सुरक्षा' और 'हाई स्टेटस' का प्रतीक है—शुम्भ को लगता है कि वह अब पूरी तरह से 'सेफ' है।"
            "जब इंसान के पास बहुत ताकत आती है, तो वह अपनी 'प्रोटेक्शन' के लिए अभेद्य इंतजाम करता है।"
            "प्रजापति का रथ 'सृष्टि की गति' का प्रतीक है—अहंकार अब खुद को ब्रह्मांड का 'ड्राइवर' समझ रहा है।"
            "शुम्भ की यह लिस्ट अज्ञान के उस 'पीक' (Peak) को दर्शाती है जहाँ वह सब कुछ अपना मान चुका है।"
            "वह देवी को यह संदेश दे रहा है कि—'मेरे पास सुरक्षा भी है, स्टेटस भी है और कंट्रोल भी है'।"
            "अज्ञानी मन अपनी 'बाहरी उपलब्धियों' पर इतना गर्व करता है कि वह अपनी 'आंतरिक कंगाली' भूल जाता है।"
            "वह भूल जाता है कि ये सब संपत्तियां समय के साथ बदल जाएंगी और उसे अकेला छोड़ देंगी।"
            "अब शुम्भ अपना मुख्य 'प्रपोज़ल' (Proposal) देवी के सामने (दूत के जरिए) रखने वाला है।"
        """.trimIndent(),
        english = """
            (Varuna's Canopy): "'Varuna's divine canopy that showers gold is currently residing inside Your magnificent palace'."
            "'And the supreme chariot that once belonged to Prajapati now stands ready for Your personal travel'."
            "The Canopy symbolizes absolute 'Security' and 'High Status'—Shumbha feels he is now totally 'Safe'."
            "When a human acquires excessive power, he creates massive arrangements (Canopy) for his personal Protection."
            "Prajapati's chariot represents 'Cosmic Momentum'—the Ego now perceives itself as the driver of the universe."
            "This inventory of Shumbha illustrates the 'Peak' of ignorance where everything is claimed as personal property."
            "He is signaling to the Goddess: 'I successfully possess total security, extreme status, and absolute control'."
            "The ignorant mind takes so much pride in 'External Assets' that it entirely forgets its 'Internal Poverty'."
            "He forgets that these possessions will change over time and eventually leave him entirely alone."
            "Now Shumbha is officially preparing to present his primary 'Proposal' to the Goddess through the messenger."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 106,
        sanskrit = "मृत्योः शक्त्याख्यां गदां तद्वदादत्तं पाशमेव च ।\nसमस्तं रत्नजातं च निशुम्भस्याब्धिजा विभो ॥ १६२ ॥",
        hindi = """
            (यम की गदा): "'हमने यमराज की 'शक्ति' नामक गदा और वरुण का अमोघ पाश भी अपनी ताकत से जीत लिया है'।"
            "'और समुद्र से उत्पन्न होने वाले सभी रत्नों का जो समूह है, वह अब मेरे भाई निशुम्भ के अधिकार में है'।"
            "यम की गदा 'मृत्यु' का प्रतीक है—अहंकार दावा कर रहा है कि उसने 'मौत' को भी अपने वश में कर लिया है।"
            "यह वह 'अमरता का भ्रम' है जो हर तानाशाह को उसकी मौत से ठीक पहले होता है।"
            "वरुण का पाश 'बंधन' का प्रतीक है—अहंकार अब दूसरों की आज़ादी को बांधने का हक़ जमा रहा है।"
            "निशुम्भ (ममता) के पास रत्नों का होना बताता है कि 'अटैचमेंट' ही सारी सुंदर चीज़ों को जकड़ कर रखता है।"
            "शुम्भ देवी को यह समझाना चाहता है कि वह दुनिया के सबसे 'पावरफुल परिवार' का हिस्सा बन सकती हैं।"
            "जब अज्ञान किसी को लुभाना चाहता है, तो वह अपनी 'दौलत और रुतबे' का प्रदर्शन करता है।"
            "वह देवी को केवल एक 'वस्तु' मानकर उसे अपने ऐश्वर्य से प्रभावित (Impress) करना चाहता है।"
            "यह श्लोक अज्ञानी मन की उस 'बार्गेनिंग' (Bargaining) को दिखाता है जो वह सत्य के साथ करना चाहता है।"
        """.trimIndent(),
        english = """
            (Yama's Mace): "'We have conquered Yama's mace named 'Shakti' and seized Varuna's absolute cosmic noose'."
            "'And the entire collection of jewels born from the ocean is currently with my brother Nishumbha'."
            "Yama's mace symbolizes 'Death'—the Ego is effectively claiming it has conquered 'Mortality' itself."
            "This is the 'Delusion of Immortality' that traps every dictator exactly before their ultimate downfall."
            "Varuna's noose represents 'Binding'—arrogance now claims the right to restrict the freedom of others."
            "Nishumbha (Attachment) owning the jewels proves that 'Obsessive Greed' always grips onto beautiful objects."
            "Shumbha wants the Goddess to realize She can join the absolute most 'Powerful Family' in the cosmos."
            "When ignorance seeks to lure someone, it relentlessly displays its financial 'Wealth and Status'."
            "He perceives the Goddess as a mere 'Commodity' and attempts to Impress Her with his material glory."
            "This verse illustrates the desperate 'Bargaining' that an ignorant mind attempts to execute with Truth."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 107,
        sanskrit = "आग्नेयमपि शुद्धं च वाससी द्वे मया हृते ।\nएवं दैत्येन्द्र रत्नानि समस्तानि हृतानि मे ॥ १६३ ॥",
        hindi = """
            (अग्नि के वस्त्र और घमंड): "'अग्नि देव के वे दो अत्यंत पवित्र और शुद्ध वस्त्र भी अब मेरे ही पास सुरक्षित हैं'।"
            "'इस प्रकार, हे देवी! ब्रह्मांड के जितने भी रत्न और श्रेष्ठ वस्तुएं हैं, वे सब 'मैंने' (Me) छीन ली हैं'।"
            "अग्नि के वस्त्र 'पवित्रता' (Purity) का प्रतीक हैं—शुम्भ यह ढोंग कर रहा है कि वह बहुत 'सही' और 'नेक' है।"
            "अहंकारी व्यक्ति अपनी गलतियों को हमेशा 'सच्चाई' के झूठे मुखौटे से ढकने की कोशिश करता है।"
            "'मे' (Me) शब्द का बार-बार आना शुम्भ के उस 'कर्ता-भाव' (Doership) को दिखाता है जो उसके पतन का कारण है।"
            "वह अपनी 'लूट' (Loot) को अपनी 'महानता' समझ रहा है, यही अज्ञान का सबसे बड़ा प्रमाण है।"
            "शुम्भ को लगता है कि अब उसके पास 'सब कुछ' है, इसलिए वह अब दुनिया में 'सुप्रीम' हो गया है।"
            "यह श्लोक उस मानसिक अवस्था को दिखाता है जहाँ इंसान अपनी भौतिक वस्तुओं के पीछे अपनी आत्मा को खो देता है।"
            "दूत सुग्रीव ने अब शुम्भ के वैभव का पूरा चित्र देवी के सामने बड़े विस्तार से रख दिया है।"
            "अब वह दूत शुम्भ का असली 'प्रपोज़ल' (Proposal) देवी के सामने रखने की हिम्मत करेगा।"
        """.trimIndent(),
        english = """
            (Garments of Fire and Pride): "'Even those two exceptionally holy and pure garments of Agni are currently under my possession'."
            "'In this manner, O Goddess! I have forcefully snatched absolutely all the jewels and supreme objects of the universe'."
            "Garments of Fire symbolize 'Purity'—Shumbha is pretending to be a highly righteous and holy entity."
            "An arrogant person perpetually covers his toxic mistakes using the masks of 'Truth' and 'Sanctity'."
            "The repetitive use of the word 'Me' illustrates Shumbha's fatal 'Sense of Doership' (Ego)."
            "He mistakes his cosmic 'Loot' for a personal 'Greatness', which is the absolute definition of ignorance."
            "Shumbha deludes himself into thinking he now possesses 'Everything', and is therefore the 'Supreme' entity."
            "This verse shows the mental state where a human entirely loses his soul behind his wall of material assets."
            "Messenger Sugriva has now successfully painted a complete picture of Shumbha's material glory before the Goddess."
            "Now the messenger is officially preparing to present Shumbha's primary 'Proposal' to Her."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 108,
        sanskrit = "त्वं तु स्त्रीरत्नभूतासि सम्प्रतीह मया विभो ।\nसा त्वं मामुपतिष्ठस्व यतः स्त्रीरत्नभाग् वयम् ॥ १६४ ॥",
        hindi = """
            (विवाह का प्रस्ताव): "'हे देवी! आप इस समय पूरे ब्रह्मांड में 'स्त्री-रत्न' के समान सबसे सुंदर और श्रेष्ठ हैं'।"
            "'चूँकि मैं सभी रत्नों का अकेला मालिक हूँ, इसलिए आपको भी मेरे पास ही आना चाहिए और मेरी सेवा करनी चाहिए'।"
            "यह ईगो (Ego) का सबसे घिनौना नज़रिया है—हर अनमोल चीज़ को 'रत्न' (Commodity) समझना।"
            "शुम्भ देवी को 'शक्ति' (Power) नहीं, बल्कि एक 'वस्तु' (Object) की तरह देख रहा है जिसे वह 'कलेक्ट' करना चाहता है।"
            "वह कहता है—'यतः स्त्रीरत्नभाग् वयम्' (मैं रत्नों का उपभोग करने वाला हूँ)—यह उसके विलासी स्वभाव को दिखाता है।"
            "अहंकार को लगता है कि दुनिया की हर सुंदर चीज़ केवल उसके 'इस्तेमाल' के लिए बनी है।"
            "वह देवी को 'शांति' या 'मुक्ति' के लिए नहीं, बल्कि अपने महल की 'सजावट' के लिए बुला रहा है।"
            "इंसान जब अपनी बुद्धि खो देता है, तो वह 'परमात्मा' से भी अपनी सेवा लेने की इच्छा करने लगता है।"
            "शुम्भ का यह प्रपोज़ल वास्तव में उसकी 'मौत का निमंत्रण' (Invitation to Death) है।"
            "सत्य के साथ सौदेबाजी करने की यह कोशिश अहंकार के अंत की आधिकारिक शुरुआत है।"
        """.trimIndent(),
        english = """
            (The Marriage Proposal): "'O Goddess! You are currently the absolute 'Jewel' (Stri-ratna) of beauty in this entire universe'."
            "'Since I am the singular master of all jewels, You must rightfully come to me and serve me as my queen'."
            "This represents the most repulsive perspective of the Ego—viewing everything as a mere 'Commodity'."
            "Shumbha does zero to perceive the Goddess as 'Power'; he sees Her as an 'Object' he wants to 'Collect'."
            "He says—'Since I consume all jewels'—revealing his absolute extreme hedonistic and toxic nature."
            "Arrogance falsely assumes that every beautiful thing in the world is created strictly for its personal 'Use'."
            "He desires to make the Goddess a 'Decoration' in his palace rather than seeking 'Liberation' from Her."
            "When a human loses his spiritual intellect, he begins to desire 'Service' from even the Supreme Divine."
            "This proposal by Shumbha is actually an 'Invitation to his own Death', though he is too blind to see it."
            "This attempt to bargain with Absolute Truth marks the formal cosmic beginning of the Ego's final destruction."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 109,
        sanskrit = "मां वा ममानुजं वापि निशुम्भमुरुविक्रमम् ।\nभज त्वं चञ्चलापाङ्गि रत्नभूतासि वै यतः ॥ १६५ ॥",
        hindi = """
            (विकल्प देना): "'हे चंचल आँखों वाली देवी! आप या तो मुझे चुनें, या मेरे अत्यंत पराक्रमी भाई निशुम्भ को चुन लें'।"
            "'क्योंकि आप स्वयं एक 'रत्न' हैं, और रत्नों का स्थान केवल हमारे जैसे श्रेष्ठ वीरों के पास ही होना चाहिए'।"
            "शुम्भ यहाँ देवी को 'चॉइस' (Choice) दे रहा है, जैसे वह कोई सामान बेच रहा हो (सेल्समैन एटीट्यूड)।"
            "वह देवी को 'चञ्चलापाङ्गि' कहकर लुभाने की कोशिश कर रहा है, जो अज्ञान के सतहीपन (Superficiality) को दिखाता है।"
            "अहंकार को लगता है कि वह और उसका भाई (अहंकार और ममता) ही दुनिया के सबसे 'योग्य' पात्र हैं।"
            "वह देवी को अपने महल की 'प्रॉपर्टी' बनाने के लिए किसी भी भाई को चुनने का ऑफर दे रहा है।"
            "यह श्लोक अज्ञानी मन की उस 'मूर्खता' को दिखाता है जहाँ वह ईश्वर को भी अपने 'विकल्पों' में रखना चाहता है।"
            "शुम्भ के लिए देवी की 'आध्यात्मिक शक्ति' का कोई मूल्य नहीं है, उसे केवल उनका 'बाहरी रूप' चाहिए।"
            "वह समझता है कि उसकी 'ताकत' (विक्रम) देवी को प्रभावित करने के लिए काफी है।"
            "यह अहंकार का वह 'ओवरकॉन्फिडेंस' है जो उसे विनाश के गड्ढे में गिराने वाला है।"
        """.trimIndent(),
        english = """
            (Offering a Choice): "'O Goddess with flickering eyes! You may choose either me, or my powerful brother Nishumbha'."
            "'Since You are a 'Jewel', Your place must strictly be with supreme warriors like us'."
            "Shumbha is offering a 'Choice' to the Goddess as if he is selling a product (The Salesman Attitude)."
            "By calling Her 'Chanchalapangi', he displays the extreme superficiality of his ignorant mind."
            "The Ego falsely believes that it and its brother (Arrogance and Attachment) are the most 'Eligible' beings."
            "He is offering any of the brothers as a partner strictly to make the Goddess his palace 'Property'."
            "This verse demonstrates the absolute 'Stupidity' of an ignorant mind that wants to put God inside its 'Options'."
            "For Shumbha, the Goddess's spiritual power holds zero value; he exclusively craves Her 'External Form'."
            "He believes that his raw 'Brute Force' (Vikrama) is more than sufficient to win over the Divine."
            "This is the 'Overconfidence' of the ego that is preparing to throw it into the pit of total annihilation."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 110,
        sanskrit = "परमैश्वर्यमतुलं प्राप्स्यसे मत्परिग्रहात् ।\nएतद् बुद्ध्या समालोच्य मत्परिग्रहतां व्रज ॥ १६६ ॥",
        hindi = """
            (अंतिम प्रलोभन): "'मुझसे जुड़ने पर (मत्परिग्रहात्) आपको वह अतुलनीय ऐश्वर्य प्राप्त होगा जिसकी कोई सीमा नहीं है'।"
            "'अपनी बुद्धि से इस बात पर अच्छी तरह विचार कीजिए और तुरंत मेरी शरण में आ जाइए'।"
            "शुम्भ यहाँ देवी को 'फायदे' गिना रहा है, जैसे कोई बिजनेस डील (Business Deal) हो रही हो।"
            "अहंकार हमेशा सोचता है कि वह सबको 'खरीद' सकता है या लालच देकर अपना बना सकता है।"
            "वह देवी को 'बुद्धि' (Intelligence) का उपयोग करने को कह रहा है, पर खुद की बुद्धि पूरी तरह भ्रष्ट हो चुकी है।"
            "सच्चा ऐश्वर्य तो देवी से ही आता है, पर शुम्भ उन्हें अपना ही ऐश्वर्य देने का 'ऑफर' दे रहा है।"
            "यह वैसा ही है जैसे कोई सूरज को एक मोमबत्ती देने का वादा करे—अत्यंत हास्यास्पद (Ridiculous)।"
            "अज्ञानी मन यह कभी नहीं समझ पाता कि शांति और मुक्ति किसी 'रिश्ते' या 'सौदे' से नहीं मिलती।"
            "शुम्भ का यह प्रलोभन उसे देवी की नज़रों में और भी ज़्यादा 'मूर्ख' और 'पात्र' बना रहा है।"
            "अब दूत की बातें खत्म हो चुकी हैं और देवी का जवाब आने वाला है जो पूरे पासे पलट देगा।"
        """.trimIndent(),
        english = """
            (The Final Temptation): "'By accepting me, You will achieve that incomparable glory which has absolutely zero limits'."
            "'Consider this deeply Utilizing Your intellect and instantaneously accept my hand in marriage'."
            "Shumbha is listing the 'Benefits' to the Goddess as if they are negotiating a corporate Business Deal."
            "Arrogance perpetually assumes that everyone can be 'Purchased' or won over using the lure of material glory."
            "He asks the Goddess to use Her 'Intellect', while his own intellect is completely and purely corrupted."
            "True Glory (Divinity) actually originates from the Goddess, yet Shumbha is 'Offering' Her Her own power."
            "This is identically like promising to offer a candle to the entire Sun—utterly Ridiculous and pathetic."
            "The ignorant mind never comprehends that Peace and Liberation cannot be achieved through a 'Transaction'."
            "This temptation makes Shumbha appear even more 'Foolish' and 'Eligible for slaughter' in the eyes of Truth."
            "The messenger's speech has concluded, and now the Goddess's reply is preparing to flip the cosmic script."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 111,
        sanskrit = "ऋषिरुवाच ॥ १६७ ॥\nइत्युक्ता सा तदा देवी गम्भीरान्तःस्मिता जगौ ।\nदुर्गा भगवती भद्रा ययेदं धार्यते जगत् ॥ १६८ ॥",
        hindi = """
            (देवी की मुस्कान): "ऋषि मेधा ने कहा: दूत की इन मूर्खतापूर्ण बातों को सुनकर, भगवती दुर्गा के चेहरे पर एक 'गहरी मुस्कान' आ गई।"
            "वे ही भगवती 'भद्रा' (कल्याणकारी) हैं, जिन्होंने इस संपूर्ण ब्रह्मांड को अपने भीतर धारण (धार्यते) कर रखा है।"
            "यहाँ 'गम्भीर अन्तःस्मिता' (Deep inner smile) का अर्थ है—वह हंसी जो अज्ञान की बेवकूफी पर आती है।"
            "देवी को गुस्सा नहीं आया, बल्कि उन्हें शुम्भ की छोटी सोच पर 'तरस' और 'हंसी' आई।"
            "यह वह 'कॉस्मिक साइलेंस' (Cosmic Silence) है जो किसी भी शोर भरे तर्क का सबसे बड़ा उत्तर होता है।"
            "माता को यहाँ 'दुर्गा' कहा गया है, जो यह संकेत है कि अब राक्षसों के लिए यह किला अभेद्य होने वाला है।"
            "वे 'भद्रा' हैं, यानी वे जो कुछ भी करेंगी, वह अंततः ब्रह्मांड के कल्याण के लिए ही होगा।"
            "वह शक्ति जो पूरे 'जगत' को संभालती है, उसे एक छोटा सा असुर भौतिक 'ऐश्वर्य' का लालच दे रहा था!"
            "देवी का जवाब अब दुनिया को यह सिखाएगा कि 'सत्य' कभी भी 'अहंकार' के सामने नहीं झुकता।"
            "युद्ध का मानसिक आधार अब यहाँ से तैयार होना शुरू हो गया है।"
        """.trimIndent(),
        english = """
            (The Goddess's Smile): "The Sage Medha said: Hearing these foolish words of the messenger, a 'Deep Inner Smile' appeared on the face of Goddess Durga."
            "She is the Supreme 'Bhadra' (Benevolent One) who perpetually sustains and holds this entire universe within Her."
            "The 'Gambhira-antah-smita' (Deep inner smile) represents that divine amusement at the sheer stupidity of ignorance."
            "The Goddess did zero to feel angry; instead, She felt 'Pity' and 'Amusement' at Shumbha's narrow-minded thinking."
            "This is the 'Cosmic Silence' which acts as the absolute greatest response to any noisy or logical argument."
            "Addressing Her as 'Durga' signals that Her internal fortress is now going to be impenetrable for the demons."
            "She is 'Bhadra', implying that whatever action She takes is ultimately for the global welfare."
            "The Power that sustains the entire 'Universe' was being bribed with material glory by a microscopic demon!"
            "The Goddess's response will now teach the world that 'Truth' mathematically never bows down before 'Arrogance'."
            "The psychological foundation for the final cosmic war is officially being constructed from this moment onward."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 112,
        sanskrit = "देव्युवाच ॥ १६९ ॥\nसत्यमुक्तं त्वया नात्र मिथ्या किञ्चित्त्वयोदितम् ।\nगोप्ता त्रैलोक्यपतिः शुम्भो निशुम्भश्चापि तादृशः ॥ १७० ॥",
        hindi = """
            (सत्य की स्वीकृति): "देवी ने बहुत ही गम्भीरता से कहा: 'हे दूत! तुमने जो कुछ भी कहा है, वह बिल्कुल 'सत्य' है; इसमें कुछ भी झूठ नहीं है'।"
            "'शुम्भ वास्तव में तीनों लोकों का स्वामी और रक्षक (गोप्ता) है, और निशुम्भ भी वैसा ही महा-पराक्रमी है'।"
            "यहाँ देवी की 'डिप्लोमेसी' देखिए—वे पहले दुश्मन की ताकत को 'स्वीकार' (Acknowledge) कर रही हैं।"
            "यह एक मास्टर-स्ट्रोक है: जब आप किसी मूर्ख की तारीफ करते हैं, तो उसका अहंकार और ज़्यादा फूल जाता है।"
            "देवी यह जता रही हैं कि मुझे तुम्हारी दौलत और ताकत की सारी जानकारी मिल गई है।"
            "सत्य को स्वीकार करना कमज़ोरी नहीं, बल्कि सामने वाले के भ्रम को और गहरा करने की एक चाल है।"
            "शुम्भ को 'त्रैलोक्यपति' कहना यह दर्शाता है कि देवी उसके 'भौतिक सत्य' को मान रही हैं।"
            "परंतु वे अभी वह 'अंतिम सत्य' (Final Truth) बोलने वाली हैं जो शुम्भ के पैरों के नीचे से ज़मीन खिसका देगा।"
            "देवी का स्वर अत्यंत शांत है, जो उनकी 'अजेय शक्ति' (Invincible Power) का प्रमाण है।"
            "अब वे उस 'प्रतिज्ञा' के बारे में बताएंगी जिसने इस विवाह को असंभव बना दिया है।"
        """.trimIndent(),
        english = """
            (Acknowledging the Relative Truth): "The Goddess spoke with absolute gravity: 'O Messenger! Whatever You have stated is entirely 'True'; there is zero falsehood in Your words'."
            "'Shumbha is indeed the master and protector (Gopta) of the three worlds, and Nishumbha is equally powerful'."
            "Observe the Goddess's 'Cosmic Diplomacy' here—She first 'Acknowledges' and validates the enemy's perceived strength."
            "This is a 'Master-stroke': when You flatter a fool's arrogance, his ego expands and his guard drops even further."
            "The Goddess is signaling that She has received all the data regarding Shumbha's wealth and military power."
            "Acknowledging the relative truth is zero weakness; it is a tactic to deepen the opponent's existing delusion."
            "Calling Shumbha 'Trailokyapatih' implies that She recognizes his 'Material Reality' and worldly dominance."
            "However, She is officially preparing to utter that 'Ultimate Truth' which will shatter Shumbha's foundation."
            "The Goddess's voice remains exceptionally calm, which is the absolute proof of Her 'Invincible Power'."
            "Now She will reveal that specific 'Vow' (Pratijna) which has made this marriage proposal mathematically impossible."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 113,
        sanskrit = "किन्त्वत्र यत्प्रतिज्ञातं मिथ्या तत् क्रियते कथम् ।\nश्रूयतामल्पबुद्धित्वात् प्रतिज्ञा या कृता पुरा ॥ १७१ ॥",
        hindi = """
            (देवी की प्रतिज्ञा): "'परंतु मैंने पहले ही एक 'प्रतिज्ञा' (Vow) कर ली है, और मैं उसे 'झूठा' (False) कैसे कर सकती हूँ?'"
            "'अपनी 'अल्प-बुद्धि' (नासमझी) के कारण मैंने बहुत पहले एक ऐसी शर्त रखी थी, जिसे अब तुम सुनो'।"
            "यहाँ देवी खुद को 'अल्प-बुद्धि' (Less intelligent) कह रही हैं—यह उनकी महानता और व्यंग्य (Sarcasm) है।"
            "वे शुम्भ को यह संदेश दे रही हैं कि—'तुम तो बहुत बुद्धिमान हो, पर मैंने एक बेवकूफी भरी शर्त मान ली है'।"
            "अहंकार को यह सुनकर और भी ज़्यादा घमंड होगा कि देवी उससे 'कम' समझदार हैं।"
            "परंतु वह 'प्रतिज्ञा' वास्तव में अज्ञान के लिए एक 'डेथ ट्रैप' (Death Trap) है।"
            "सत्य कभी भी अपनी बात से पीछे नहीं हटता, चाहे सामने कितनी भी बड़ी ताकत क्यों न हो।"
            "यह श्लोक 'इंटीग्रिटी' (Integrity) का प्रतीक है—अपनी बात पर अड़े रहना।"
            "देवी अब वह शर्त बताएंगी जो यह तय करेगी कि शुम्भ उनका पति बनेगा या उनकी तलवार का शिकार।"
            "तर्क (सुग्रीव) अब इस 'प्रतिज्ञा' के सामने पूरी तरह से लाचार होने वाला है।"
        """.trimIndent(),
        english = """
            (The Irrevocable Vow): "'However, I have already taken a 'Vow' (Pratijna), and how can I possibly make it 'False' or break it?'"
            "'Due to my 'Lessened Intelligence' (Alpabuddhitva), I established a strict condition long ago; listen to it now'."
            "The Goddess is calling Herself 'Less Intelligent'—this is a display of supreme Humility mixed with lethal Sarcasm."
            "She is signaling to Shumbha: 'You are exceptionally wise, but I have committed to a foolish condition'."
            "Hearing this will inflate the Ego's pride even further, as it perceives itself as superior to the Divine mind."
            "However, that 'Vow' is actually a military-grade 'Death Trap' designed specifically for ignorance."
            "Absolute Truth never retreats from its word, regardless of how colossal the opposing force appears to be."
            "This verse symbolizes absolute 'Integrity'—the unshakeable adherence to one's fundamental principles."
            "The Goddess will now state the condition that decides if Shumbha becomes Her consort or Her victim."
            "Logic (Sugriva) is about to become entirely and purely helpless in front of this unshakeable 'Vow'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 114,
        sanskrit = "यो मां जयति सङ्ग्रामे यो मे दर्पं व्यपोहति ।\nयो मे प्रतिबलो लोके स मे भर्ता भविष्यति ॥ १७२ ॥",
        hindi = """
            (असंभव शर्त): "'जो मुझे 'युद्ध' (Battle) में जीत लेगा, जो मेरे 'घमंड' (दर्पं) को पूरी तरह चूर-चूर कर देगा'।"
            "'और जो इस संसार में मेरी शक्ति के 'बराबर' (प्रतिबलो) होगा, वही मेरा 'पति' (भर्ता) बन पाएगा'।"
            "यह पूरी सप्तशती की सबसे चुनौतीपूर्ण (Challenging) और 'पावरफुल' लाइन है!"
            "देवी कह रही हैं कि मुझे पाने के लिए मुझे 'हराना' (Conquer) होगा—जो कि ब्रह्मांड में असंभव है।"
            "चेतना (Consciousness) को कोई जीत नहीं सकता, उसे केवल 'सरेंडर' करके पाया जा सकता है।"
            "शुम्भ 'रत्नों' और 'दौलत' की बात कर रहा था, और देवी 'युद्ध' और 'ताकत' की बात कर रही हैं।"
            "यह अहंकार के लिए एक सीधा 'ओपन चैलेंज' (Open Challenge) है—अगर तुम इतने बड़े हो, तो लड़कर दिखाओ।"
            "यहाँ 'दर्प' (Pride) शब्द का प्रयोग व्यंग्य है; देवी का कोई घमंड नहीं है, वे खुद ही 'परम सत्य' हैं।"
            "शुम्भ को लगा था कि वह 'शादी' का प्रस्ताव दे रहा है, पर देवी ने उसे 'युद्ध' का न्योता दे दिया।"
            "यह शर्त अज्ञान के उस भ्रम को तोड़ती है कि भगवान को 'लालच' से पाया जा सकता है।"
        """.trimIndent(),
        english = """
            (The Open Challenge): "'He who successfully 'Defeats' me in battle, he who entirely shatters my 'Pride' (Darpa)'."
            "'And he who stands 'Equal' (Pratibala) to my power in this world, only he shall become my 'Husband'."
            "This is undeniably the most challenging, provocative, and 'Powerful' line in the entire Durga Saptashati!"
            "The Goddess declares that to possess Her, one must 'Conquer' Her—which is mathematically impossible."
            "Consciousness can never be defeated or owned; it can strictly only be attained through total 'Surrender'."
            "Shumbha was negotiating with 'Jewels' and 'Wealth', but the Goddess responded with 'War' and 'Raw Power'."
            "This is a direct 'Open Challenge' to the Ego: 'If you are truly supreme, prove it through direct confrontation'."
            "The use of the word 'Darpa' (Pride) is ironic; the Goddess has zero pride, She IS the absolute Supreme Truth."
            "Shumbha thought he was sending a 'Wedding Proposal', but the Goddess returned an 'Invitation to a Massacre'."
            "This condition shatters the ignorance that assumes God can be controlled through 'Greed' or 'Diplomacy'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 115,
        sanskrit = "तदागच्छतु शुम्भोऽत्र निशुम्भो वा महासुरः ।\nजित्वा मां किंचिरेणात्र पाणिं गृह्णातु मे लघु ॥ १७३ ॥",
        hindi = """
            (युद्ध का निमंत्रण): "'इसलिए, अब शुम्भ या वह महा-असुर निशुम्भ स्वयं यहाँ रणभूमि में आ जाएं'।"
            "'वे मुझे यहाँ युद्ध में जीत लें और फिर बिना किसी देरी (लघु) के मेरा हाथ थाम लें'।"
            "देवी की वाणी में अब साक्षात् 'काल' (Death) की गूंज सुनाई दे रही है।"
            "वे शुम्भ को अपने महल से बाहर निकलकर 'सच्चाई' का सामना करने के लिए उकसा रही हैं।"
            "अहंकार हमेशा पर्दे के पीछे (महल में) छुपकर आदेश देता है, वह कभी 'आमने-सामने' की लड़ाई नहीं चाहता।"
            "परंतु चेतना उसे मजबूर कर रही है कि वह अपनी सुरक्षा की बाउंड्री (Comfort Zone) से बाहर आए।"
            "'जित्वा मां' (मुझे जीतकर)—यह वह असंभव मिशन है जो शुम्भ के अंत का कारण बनेगा।"
            "देवी ने सुग्रीव (तर्क) के सारे रटे-रटाए भाषण को एक ही झटके में 'कबाड़' बना दिया।"
            "अब अज्ञान के पास केवल दो ही रास्ते बचे हैं: या तो वह सरेंडर करे, या फिर मौत को चुने।"
            "यह श्लोक 'सत्य की निर्भयता' (Fearlessness of Truth) का प्रतीक है।"
        """.trimIndent(),
        english = """
            (Invitation to Combat): "'Therefore, let Shumbha or that mega-demon Nishumbha personally arrive here in the battlefield'."
            "'Let them defeat me in war right here and then, without any delay (Laghu), hold my hand in marriage'."
            "The absolute voice of 'Time/Death' (Kaala) is now resonating clearly within the Goddess's speech."
            "She is provoking Shumbha to step out of his palace and confront the 'Ultimate Reality' face-to-face."
            "Arrogance perpetually issues commands from behind the scenes; it avoids 'Direct' confrontation with Truth."
            "However, Consciousness is forcing him to exit his boundary of security and enter the open field."
            "'After defeating Me'—this is the impossible cosmic mission that will result in Shumbha's total annihilation."
            "The Goddess has instantaneously turned Sugriva's (Logic's) entire scripted speech into useless garbage."
            "Now ignorance is left with strictly only two options: total unconditional surrender or certain death."
            "This verse serves as the absolute symbol of the 'Fearlessness' inherent in the Supreme Truth."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 116,
        sanskrit = "दूत उवाच ॥ १७४ ॥\nगर्वितोऽसि न मैवं त्वं देवि ब्रूहि ममाग्रतः ।\nत्रैलोक्ये कः पुमानन्यः शुम्भनिशुम्भयोः पुरः ॥ १७५ ॥",
        hindi = """
            (दूत का क्रोध): "दूत सुग्रीव ने गुस्से में कहा: 'हे देवी! आप बहुत घमंडी (गर्वितो) हो गई हैं, मेरे सामने ऐसी बातें मत कीजिए'।"
            "'इन तीनों लोकों में ऐसा कौन पुरुष है, जो शुम्भ और निशुम्भ के सामने टिकने की हिम्मत कर सके?'"
            "सुग्रीव का गुस्सा यह दिखाता है कि जब 'तर्क' (Logic) फेल होता है, तो वह 'बदतमीजी' पर उतर आता है।"
            "उसे देवी की शांति और शक्ति 'घमंड' लग रही है, क्योंकि अज्ञानी कभी 'आत्म-विश्वास' को समझ नहीं पाता।"
            "वह शुम्भ और निशुम्भ को 'सबसे महान' साबित करने की कोशिश कर रहा है, जो उसकी वफादारी नहीं बल्कि उसका 'डर' है।"
            "ईगो (शुम्भ) को जैसे ही चैलेंज मिलता है, उसका दूत (विचार) भड़क उठता है।"
            "सुग्रीव को लग रहा है कि वह एक कमज़ोर स्त्री को डराकर चुप करा देगा।"
            "यह वह स्टेज है जहाँ अज्ञान सत्य को 'अंडर-एस्टीमेट' (Underestimate) करने की सबसे बड़ी गलती करता है।"
            "दूत का 'मैवं त्वं' (ऐसा मत कहो) कहना यह बताता है कि अहंकार कभी भी 'सत्य' को सुनना नहीं चाहता।"
            "अहंकार को केवल अपनी 'जी-हज़ूरी' और 'तारीफ' ही पसंद आती है।"
        """.trimIndent(),
        english = """
            (Messenger's Reaction): "Messenger Sugriva replied in anger: 'O Goddess! You have become too arrogant; do zero to speak like this before me'."
            "'Who exists in these three worlds as a man who can dare to stand before Shumbha and Nishumbha?'"
            "Sugriva's anger proves that when 'Logic' fails, it immediately resorts to aggressive and defensive behavior."
            "He mistakes the Goddess's unshakeable power for 'Arrogance', as the ignorant never comprehend true 'Self-confidence'."
            "He is desperately trying to prove Shumbha and Nishumbha as 'The Greatest', reflecting his own deep 'Fear'."
            "The exact moment the Ego (Shumbha) is challenged, its messenger (Thought) begins to flare up with rage."
            "Sugriva deludes himself into thinking he can silence and intimidate a seemingly 'Weak Woman'."
            "This is the stage where ignorance commits the fatal error of 'Underestimating' the absolute Supreme Truth."
            "The messenger's demand 'Do zero to say this' proves that Arrogance is mathematically incapable of hearing Truth."
            "Toxic arrogance exclusively craves 'Validation' and constant 'Flattery' to sustain its fragile existence."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 117,
        sanskrit = "अन्येषामपि दैत्यानां सर्वे देवा न संयुगे ।\nतिष्ठन्ति सम्मुखे देवि किं पुनः स्त्री त्वमेकिनी ॥ १७६ ॥",
        hindi = """
            (संख्या का भ्रम): "'हे देवी! जब बाकी साधारण दैत्यों के सामने भी सारे देवता युद्ध में नहीं टिक पाते'।"
            "'तो फिर आप तो एक 'अकेली स्त्री' हैं, आप शुम्भ के सामने कैसे खड़ी हो पाएंगी?'"
            "सुग्रीव यहाँ 'जेंडर-बायस' और 'संख्या बल' (Numbers) का इस्तेमाल करके देवी को कमज़ोर महसूस करा रहा है।"
            "अहंकार हमेशा 'क्वांटिटी' पर भरोसा करता है, जबकि सत्य 'क्वालिटी' और 'पावर' पर।"
            "उसे लग रहा है कि एक अकेली नारी राक्षसों की उस बड़ी फौज (झूठ के अंबार) का मुकाबला नहीं कर पाएगी।"
            "यह श्लोक उस 'बुलिंग' (Bullying) का प्रतीक है जो अक्सर दुनिया सच्चाई के साथ करती है।"
            "दुनिया कहती है—'तुम अकेले क्या बदल लोगे? देखो कितनी बुराई है!'—सुग्रीव भी यही कह रहा है।"
            "वह भूल गया है कि एक 'चिंगारी' पूरे जंगल को जलाने के लिए काफी होती है, चाहे जंगल कितना भी बड़ा हो।"
            "अज्ञान केवल 'भीड़' देखता है, जबकि चेतना 'अकेली' होकर भी पूरी सृष्टि पर भारी होती है।"
            "सुग्रीव की यह सोच उसकी बुद्धि के 'अंधेपन' का सबसे बड़ा प्रमाण है।"
        """.trimIndent(),
        english = """
            (The Illusion of Numbers): "'O Goddess! When all the Gods cannot even stand before our ordinary demons in battle'."
            "'How can You, a 'Lone Woman', possibly survive against a giant like Shumbha?'"
            "Sugriva is utilizing 'Gender Bias' and 'Power of Numbers' to make the Goddess feel psychologically weak."
            "Arrogance perpetually relies on 'Quantity' (Numbers), whereas Truth functions purely on 'Quality'."
            "He believes that a single woman can mathematically never defeat a massive demonic army."
            "This verse symbolizes the 'Bullying' that the worldly mind frequently executes against a person of integrity."
            "The world asks: 'What can you alone change? Look at the massive evil!'—Sugriva echoes the same sentiment."
            "He has forgotten that a singular 'Spark' is sufficient to incinerate an entire forest."
            "Ignorance exclusively sees the 'Crowd', while Consciousness, even when 'Alone', outweighs the entire creation."
            "This specific line of reasoning by Sugriva serves as the absolute proof of his total intellectual blindness."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 118,
        sanskrit = "इन्द्राद्याः सकला देवास्तस्थुर्यैषां न संयुगे ।\nशुम्भादीनां कथं तेषां स्त्री प्रपास्यसि सम्मुखम् ॥ १७७ ॥",
        hindi = """
            (इन्द्र का उदाहरण): "'जिन शुम्भ-निशुम्भ के सामने इन्द्र जैसे शक्तिशाली देवता भी युद्ध में नहीं टिक सके'।"
            "'उनके सामने आप जैसी कोमल स्त्री भला कैसे मुकाबला कर पाएगी?'"
            "सुग्रीव यहाँ 'अतीत' (Past) के उदाहरण देकर देवी का 'मनोबल' तोड़ने की कोशिश कर रहा है।"
            "वह कह रहा है कि—'जब बड़े-बड़े हार गए, तो तुम क्या चीज़ हो?'—यही अज्ञान का सबसे पुराना हथियार है।"
            "अहंकार हमेशा दूसरों की 'हार' को दिखाकर अपनी 'अजेयता' साबित करना चाहता है।"
            "वह यह नहीं समझ पा रहा कि इन्द्र (इंद्रियां) हार सकते हैं, पर इन्द्रियों की 'स्वामिनी' कभी नहीं हार सकती।"
            "जब इंसान अपने 'मन के विकारों' से लड़ता है, तो उसे अक्सर अपनी पुरानी हार याद दिलाई जाती है।"
            "परंतु 'नया संकल्प' (Goddess) पुराने किसी भी फेलियर से कहीं ज़्यादा शक्तिशाली होता है।"
            "सुग्रीव की यह तुलना (Comparison) पूरी तरह से गलत और सतही है।"
            "अज्ञान अब अपनी 'लिमिट' क्रॉस कर रहा है, और देवी का धैर्य अब खत्म होने वाला है।"
        """.trimIndent(),
        english = """
            (Psychological Intimidation): "'When even powerful Gods like Indra could zero percent withstand Shumbha and Nishumbha in war'."
            "'How can a gentle woman like You possibly face them in a direct physical confrontation?'"
            "Sugriva is attempting to shatter the Goddess's 'Morale' by presenting examples of 'Past Failures'."
            "He argues: 'If the giants have failed, what can You achieve?'—the oldest psychological weapon of ignorance."
            "Arrogance perpetually uses the 'Failures' of others to validate its own perceived state of invincibility."
            "He fails to comprehend that while Indra (Senses) can be defeated, the 'Mistress of Senses' is invincible."
            "When a human fights his 'Internal Vices', his mind frequently reminds him of his previous unsuccessful attempts."
            "However, a 'New Resolve' (Goddess) is mathematically infinitely more powerful than any historical failure."
            "Sugriva's logic of 'Comparison' is fundamentally flawed, superficial, and purely based on material data."
            "Ignorance is now crossing its absolute cosmic limit, and the Goddess's patience is reaching its end."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 119,
        sanskrit = "सा त्वं गच्छ मयैवोक्ता शुम्भनिशुम्भयोः अन्तिकम् ।\nकेशाकर्षणनिर्धूतगौरवा मा गमिष्यसि ॥ १७८ ॥",
        hindi = """
            (अंतिम धमकी): "'इसलिए मेरी बात मानिए और अभी मेरे साथ शुम्भ-निशुम्भ के पास चलिए'।"
            "'वरना आपको वहाँ 'बाल पकड़कर' (केशाकर्षण) घसीटते हुए ले जाया जाएगा, जिससे आपका सारा गौरव धूल में मिल जाएगा'।"
            "यह अहंकार का असली चेहरा है—जब मिठास काम नहीं आती, तो वह 'हिंसा' और 'अपमान' पर उतर आता है।"
            "बाल पकड़ना (Hair pulling) किसी भी स्त्री के लिए सबसे बड़ा अपमान माना जाता है, सुग्रीव वही धमकी दे रहा है।"
            "अहंकार हमेशा दूसरों की 'गरिमा' (Dignity) को चोट पहुँचाकर उन्हें अपने वश में करना चाहता है।"
            "वह देवी को डरा रहा है कि—'अगर प्यार से नहीं चलीं, तो बेइज्जती सहनी पड़ेगी'।"
            "यह श्लोक उस 'टॉक्सिक माइंडसेट' का प्रतीक है जो अज्ञान और घमंड से पैदा होता है।"
            "सुग्रीव को लग रहा है कि वह 'शक्ति' (Power) को डरा सकता है, जो कि उसकी सबसे बड़ी बेवकूफी है।"
            "जब बुराई अपनी सारी मर्यादाएं तोड़ देती है, तभी उसका 'सर्वनाश' शुरू होता है।"
            "अब दूत ने अपनी मौत का वारंट खुद ही साइन कर दिया है; देवी का जवाब अब प्रलय जैसा होगा।"
        """.trimIndent(),
        english = """
            (The Face of Violence): "'Therefore, listen to my words and accompany me to Shumbha and Nishumbha immediately'."
            "'Otherwise, You will be dragged there by Your 'Hair', and all Your dignity will be reduced to dust'."
            "This is the 'True Face' of Arrogance—when sweetness fails, it immediately resorts to violence and insult."
            "Pulling the hair symbolizes the total crushing of human dignity and sacred boundaries."
            "Arrogance perpetually seeks to control others by attacking and wounding their personal 'Dignity'."
            "He is terrorizing the Goddess: 'If You do zero go voluntarily, You shall face a public and brutal insult'."
            "This verse symbolizes the 'Toxic Mindset' and raw brute force born from deep ignorance."
            "Sugriva deludes himself into thinking he can frighten 'Absolute Power', which is his greatest cosmic stupidity."
            "The exact moment evil shatters all 'Boundaries' of decency, its total annihilation officially initiates."
            "The messenger has officially signed his own death warrant; the Goddess's response will now be apocalyptic."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 120,
        sanskrit = "देव्युवाच ॥ १७९ ॥\nएवमेतद् बली शुम्भो निशुम्भश्चापि तादृशः ।\nकिं करोमि प्रतिज्ञा मे यदनालोचिता पुरा ॥ १८० ॥",
        hindi = """
            (देवी का विनम्र उत्तर): "देवी ने मुस्कराते हुए कहा: 'इसमें कोई संदेह नहीं कि शुम्भ अत्यंत बलवान है और निशुम्भ भी वैसा ही है'।"
            "'परंतु मैं क्या करूँ? मैंने बिना सोच-विचार किए ही बहुत पहले वह 'प्रतिज्ञा' (Vow) कर ली थी'।"
            "यहाँ देवी की 'लीला' (Divine Play) अपने चरम पर है—वे शत्रु को चने के झाड़ पर चढ़ा रही हैं।"
            "वे शुम्भ की ताकत को स्वीकार कर रही हैं ताकि उसका 'अहंकार' और भी अधिक फूल जाए।"
            "जब कोई विनाश के करीब होता है, तो सत्य उसे उसकी कल्पना के अनुसार ही उत्तर देता है।"
            "माता का खुद को 'असहाय' दिखाना वास्तव में अज्ञान को अपनी बाउंड्री से बाहर खींचना है।"
            "अहंकार को लग रहा है कि उसने देवी को डरा दिया है, पर असल में वह खुद उनके जाल में फँस रहा है।"
            "यह श्लोक सिखाता है कि सत्य कभी शोर नहीं मचाता, वह बड़ी ही चतुराई से अपना काम करता है।"
            "देवी की प्रतिज्ञा कोई गलती नहीं, बल्कि ब्रह्मांड के नियमों का एक अटूट हिस्सा है।"
            "अब अज्ञान (शुम्भ) को इस 'प्रतिज्ञा' की कीमत अपनी जान देकर चुकानी होगी।"
        """.trimIndent(),
        english = """
            (The Goddess's Final Reply): "The Goddess smiled and said: 'There is no doubt that Shumbha is extremely powerful, and Nishumbha is equally so'."
            "'But what can I possibly do? I made that unshakeable 'Vow' long ago without thinking deeply about it'."
            "The Goddess's 'Leela' is at its peak here—She is effectively boosting the enemy's pride."
            "She acknowledges Shumbha's physical strength strictly to make his toxic Ego expand even further."
            "When someone is close to destruction, Absolute Truth responds to them according to their own delusions."
            "The Mother appearing 'Helpless' is actually a tactic to draw ignorance out of its comfort zone."
            "Arrogance deludes itself into thinking it has frightened the Goddess, while it is actually falling into Her trap."
            "This verse teaches that Truth does zero to shout; it executes its cosmic task with absolute sophistication."
            "The Goddess's Vow is zero mistake; it is an unshakeable component of the fundamental cosmic laws."
            "Now ignorance (Shumbha) will mathematically have to pay the price of this Vow with his absolute life."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 121,
        sanskrit = "स त्वं गच्छ मयोक्तं ते यदेतत् सर्वमादृतः ।\nतदाचक्ष्व सुरेन्द्रायामुराणां पतये लघु ॥ १८१ ॥",
        hindi = """
            (दूत की विदाई): "'इसलिए हे दूत! तुम वापस जाओ और मैंने तुमसे जो कुछ भी कहा है, उसे पूरी तरह ध्यान से सुनो'।"
            "'और दैत्यों के उस राजा शुम्भ से जाकर मेरा यह सारा संदेश बहुत जल्दी (लघु) कह देना'।"
            "देवी अब दूत सुग्रीव के साथ अपनी बातचीत को औपचारिक रूप से समाप्त कर रही हैं।"
            "वे उसे 'आदर' के साथ अपनी बात सुनाने को कह रही हैं, जो उनके उच्च चरित्र का प्रमाण है।"
            "सत्य कभी भी दूत (Messenger) का अपमान नहीं करता, चाहे वह दूत किसी राक्षस का ही क्यों न हो।"
            "वे शुम्भ को 'सुरेन्द्राय' (दैत्यों का इन्द्र) कहकर व्यंग्य कर रही हैं, क्योंकि असली इन्द्र तो उनकी शरण में हैं।"
            "संदेश को 'लघु' पहुँचाने का अर्थ है कि अब युद्ध की घड़ी बहुत पास आ चुकी है।"
            "अहंकार को सत्य की चेतावनी मिल चुकी है, अब फैसला उसे करना है कि वह क्या चुनेगा।"
            "देवी की वाणी में वह शांति है जो आने वाले महा-तूफान का संकेत दे रही है।"
            "दूत के जाने के साथ ही, शांतिपूर्वक बातचीत के सारे रास्ते अब हमेशा के लिए बंद हो चुके हैं।"
        """.trimIndent(),
        english = """
            (Dismissing the Messenger): "'Therefore O Messenger! Go back and listen to everything I have said to You with full attention'."
            "'And convey this entire message of Mine to that King of Demons, Shumbha, very quickly (Laghu)'."
            "The Goddess is now formally terminating Her conversation with the messenger Sugriva."
            "She asks him to listen with 'Respect', proving Her supreme divine character and ethical conduct."
            "Truth mathematically never insults a mere Messenger, even if that messenger serves absolute evil."
            "She uses the term 'Surendra' ironically for Shumbha, as the actual Indra is already seeking Her protection."
            "Demanding the message be delivered 'Quickly' implies that the hour of the final war is extremely close."
            "Arrogance has received the formal warning of Truth; it must now decide its own tragic fate."
            "The Goddess's voice holds that specific silence which signals the approach of an apocalyptic cosmic storm."
            "With the departure of the messenger, all roads for peaceful negotiation are now permanently closed."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 122,
        sanskrit = "यथोचितं विधास्यत्येव स हि जानाति यत् क्षमम् ॥ १८२ ॥\nऋषिरुवाच ॥ १८३ ॥",
        hindi = """
            (अंतिम निर्णय): "देवी ने बात खत्म की: 'शुम्भ जो उचित समझेगा, वही करेगा, क्योंकि वह अपनी क्षमता (क्षमम्) जानता है'।"
            "महर्षि मेधा ने आगे कहा: (देवी की यह बात सुनकर वह दूत सुग्रीव वहाँ से चुपचाप चला गया)।"
            "देवी यहाँ शुम्भ को 'फ्री-विल' दे रही हैं—इंसान अपनी मौत का रास्ता खुद चुनता है।"
            "अहंकार अपनी बुद्धि के हिसाब से ही रिएक्ट करेगा, जो कि हमेशा गलत और आत्मघाती होता है।"
            "भगवान कभी किसी को बुरा बनने के लिए मजबूर नहीं करते, वे बस उसे अपनी चॉइस का फल भोगने देते हैं।"
            "ऋषि का हस्तक्षेप यह बताता है कि अब कथा का एक अध्याय बंद हो रहा है और युद्ध शुरू होने वाला है।"
            "दूत का जाना उस 'शांति' का अंत है जो अब तक हिमालय के वातावरण में बनी हुई थी।"
            "यह श्लोक अज्ञान के उस अंधेपन को दिखाता है जहाँ वह सही सलाह को अपमान समझकर ठुकरा देता है।"
            "सत्य ने अपना पक्ष रख दिया है, अब क्रिया और प्रतिक्रिया का भीषण खेल शुरू होगा।"
            "अहंकार अब अपने विनाश के लिए खुद ही ट्रिगर दबाने वाला है।"
        """.trimIndent(),
        english = """
            (The Choice of Free Will): "The Goddess concluded: 'Shumbha shall act as he deems fit, for he knows his own Capacity (Kshamam)'."
            "The Sage Medha continued: (Having heard this, the messenger Sugriva departed from that location)."
            "The Goddess is granting Shumbha 'Free Will'—proving that a human chooses their own path to destruction."
            "Arrogance reacts strictly according to its corrupted intellect, which is always fatal and suicidal."
            "God never forces anyone to be evil; He simply allows them to experience the results of their own choices."
            "The transition by the Sage signals that one chapter of dialogue is closing and war is imminent."
            "The departure of the messenger marks the end of the peace that had previously filled the Himalayas."
            "This verse demonstrates the blindness of ignorance which rejects righteous advice as an insult."
            "Truth has stated its position; now the fierce cosmic game of Action and Reaction shall commence."
            "Arrogance is now preparing to independently pull the trigger of its own total annihilation."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 123,
        sanskrit = "इत्युक्तः स तदा दूतो निर्वेदात् प्रतिनृत्य च ।\nस दैत्यराजमासाद्य सर्वमाख्यातवान् नृप ॥ १८४ ॥",
        hindi = """
            (दूत की वापसी): "ऋषि बोले: हे राजन्! देवी की ये बातें सुनकर वह दूत सुग्रीव अपमान (निर्वेदात्) के साथ वहाँ से लौटा।"
            "वह दैत्यराज शुम्भ के पास पहुँचा और उसने देवी द्वारा कही गई एक-एक बात विस्तार से बता दी।"
            "'निर्वेद' का अर्थ है वह मानसिक पीड़ा जब आपकी चालाकी और तर्क पूरी तरह फेल हो जाते हैं।"
            "दूत को समझ आ गया था कि यह स्त्री कोई साधारण मानवी नहीं है, बल्कि साक्षात् मृत्यु है।"
            "अहंकार का दूत जब वापस महल पहुँचता है, तो वह अपने साथ 'डर' (Fear) की वाइब्रेशन लेकर आता है।"
            "उसने 'सर्वमाख्यातवान्'—मतलब उसने देवी की उस असंभव 'चुनौती' को शुम्भ के सामने रख दिया।"
            "यह रिपोर्ट शुम्भ के अहंकार के घाव पर नमक छिड़कने जैसा काम करने वाली थी।"
            "जब सत्य की बात अहंकार तक पहुँचती है, तो वह उसे सुधारने के बजाय और ज़्यादा भड़क उठता है।"
            "महल का वातावरण अब बदल चुका था; अब वहां कूटनीति नहीं, केवल प्रतिशोध की बातें होंगी।"
            "शुम्भ की मौत का काउंटडाउन (Countdown) अब इसी श्लोक से शुरू हो चुका है।"
        """.trimIndent(),
        english = """
            (Reporting to the Palace): "The Sage said: O King! Hearing the Goddess's words, the messenger Sugriva returned with a sense of insult (Nirvedat)."
            "He approached the Demon King Shumbha and narrated every single word spoken by the Goddess in detail."
            "'Nirveda' represents that psychological pain experienced when one's cunning logic fails completely."
            "The messenger had realized that this Woman was zero ordinary human, but rather Absolute Death."
            "When the messenger of arrogance returns to the palace, he carries the vibrations of 'Fear' with him."
            "He 'Narrated everything'—placing the Goddess's impossible 'Challenge' directly before Shumbha."
            "This specific report was destined to act like salt on the open wounds of Shumbha's toxic ego."
            "When the words of Truth reach Arrogance, it does zero to self-correct; it simply flares up with rage."
            "The environment of the palace had shifted; diplomacy was dead, replaced entirely by thoughts of Revenge."
            "The countdown to Shumbha's cosmic death has officially initiated right here in this specific verse."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 124,
        sanskrit = "तस्य तद्वचनं श्रुत्वा दूतोक्तं स महासुरः ।\nसक्रोधः प्राह दैत्यानामधिपं धूम्रलोचनम् ॥ १८५ ॥",
        hindi = """
            (धूम्रलोचन को आदेश): "दूत के मुख से देवी की वे बातें सुनकर वह महा-असुर शुम्भ क्रोध से भड़क उठा।"
            "उसने अत्यंत गुस्से में आकर दैत्यों के सेनापति 'धूम्रलोचन' को अपने पास बुलाया और उसे आदेश दिया।"
            "यहाँ से युद्ध का 'प्रथम चरण' शुरू होता है, जहाँ शुम्भ खुद नहीं जाता, बल्कि अपने सेनापति को भेजता है।"
            "धूम्रलोचन (Dhumralochana) का अर्थ है 'जिसकी आँखों में धुआं भरा हो' (Smoky-eyed)।"
            "यह इंसान के उस 'अज्ञान' का प्रतीक है जिसे सत्य दिखाई नहीं देता, केवल भ्रम (धुआं) दिखाई देता है।"
            "अहंकार हमेशा सबसे पहले अपने 'भ्रम' (धूम्रलोचन) को सत्य (देवी) को मिटाने के लिए भेजता है।"
            "शुम्भ का 'सक्रोध' (क्रोधित) होना यह बताता है कि उसका मानसिक संतुलन अब पूरी तरह खो चुका है।"
            "जब इंसान गुस्से में फैसले लेता है, तो वह अपनी हार की नींव खुद ही रख देता है।"
            "धूम्रलोचन को आदेश देना मतलब अपने अज्ञान को और गहरा करने की कोशिश करना है।"
            "अब विनाशकारी शक्तियों का तांडव शुरू होने वाला है जो अंततः देवी के हाथों शांत होगा।"
        """.trimIndent(),
        english = """
            (Mobilizing Delusion): "Upon hearing the words delivered by the messenger, the mega-demon Shumbha erupted in a violent blaze of rage."
            "In extreme anger, he summoned the demonic commander 'Dhumralochana' and issued a direct military command."
            "This marks the initiation of the 'First Phase' of war, where Shumbha does zero to go personally."
            "'Dhumralochana' literally translates to 'One with smoke-filled eyes' (Smoky-eyed)."
            "He flawlessly symbolizes that 'Ignorance' which cannot see Truth, perceiving only smoke and delusion."
            "Arrogance perpetually dispatches its 'Delusion' first to attempt to annihilate the Absolute Truth."
            "Shumbha being 'Sakrodhah' (Enraged) proves that his psychological stability has been completely shattered."
            "When a human makes decisions in a state of wrath, he independently constructs the foundation of his defeat."
            "Commanding Dhumralochana represents a desperate attempt to deepen one's own ignorance and denial."
            "Now the dance of destructive forces is about to begin, which will ultimately be silenced by the Goddess."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 125,
        sanskrit = "हे धूम्रलोचनाशु त्वं स्वसैन्यपरिवारितः ।\nतामानय बलाद् दुष्टां केशाकर्षणविह्वलाम् ॥ १८६ ॥",
        hindi = """
            (पकड़ कर लाने का हुक्म): "शुम्भ ने चिल्लाकर कहा: 'हे धूम्रलोचन! तू अभी अपनी विशाल सेना के साथ वहाँ जा'।"
            "'और उस दुष्ट स्त्री को उसके 'बाल पकड़कर' घसीटते हुए ज़बरदस्ती (बलाद्) मेरे पास लेकर आ'।"
            "यह अहंकार का 'चरम पतन' है—जहाँ वह शक्ति को अपमानित करने का सपना देख रहा है।"
            "बाल पकड़ना इंसान की मर्यादा और सम्मान को पूरी तरह कुचलने का प्रतीक है।"
            "अहंकार को लगता है कि वह 'बलाद्' (ताकत) से सत्य को अपना गुलाम बना सकता है।"
            "धूम्रलोचन को सेना के साथ भेजना यह दिखाता है कि अज्ञान हमेशा 'भीड़' के पीछे छुपकर वार करता है।"
            "शुम्भ देवी को 'दुष्टा' कह रहा है, जो यह साबित करता है कि अज्ञानी को सत्य हमेशा कड़वा ही लगता है।"
            "यह आदेश शुम्भ की असुरक्षा और उसके पागलपन का सबसे बड़ा दस्तावेज़ है।"
            "जब इंसान अपनी सीमाएं भूलकर देवी (पवित्रता) पर हाथ डालता है, तो उसका काल निश्चित हो जाता है।"
            "अब अज्ञान का यह 'धुआं' महामाया की ज्वाला से टकराने जा रहा है।"
        """.trimIndent(),
        english = """
            (The Desperate Command): "Shumbha shouted: 'O Dhumralochana! Go there right now, surrounded by your massive demonic army'."
            "'And bring that wicked woman to me by Force (Balad), dragging Her by Her 'Hair' till She is helpless'."
            "This represents the 'Extreme Fall' of arrogance—where it dreams of publicly Humiliating the Supreme Power."
            "Pulling the hair symbolizes the total crushing of human dignity, integrity, and sacred boundaries."
            "Arrogance deludes itself into thinking that through 'Brute Force' (Balad), it can enslave the Truth."
            "Sending Dhumralochana with an army proves that ignorance perpetually hides behind a 'Crowd' to execute strikes."
            "Shumbha calling the Goddess 'Wicked' proves that to the ignorant mind, Truth perpetually appears evil."
            "This command is the ultimate document of Shumbha's cosmic insecurity and his descending madness."
            "Exactly when a human forgets his limits and attempts to violate Purity, his death becomes certain."
            "Now this 'Smoke' of ignorance (Dhumralochana) is moving to collide with the absolute Blaze of Mahamaya."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 126,
        sanskrit = "तत्परित्राणदः कश्चिद् यदि वोत्तिष्ठति अपरः ।\nस हन्तव्योऽमरो वापि यक्षो गन्धर्व एव वा ॥ १८७ ॥",
        hindi = """
            (विरोधियों का संहार): "शुम्भ ने आगे कहा: 'यदि उसकी रक्षा (परित्राणदः) के लिए कोई दूसरा खड़ा हो जाए'।"
            "'चाहे वह देवता हो, यक्ष हो या गन्धर्व—उसे भी तुरंत मार डालना'।"
            "अहंकार अब पूरी तरह से 'टोटल डिस्ट्रक्शन मोड' में आ चुका है।"
            "वह किसी भी ऐसी शक्ति को बर्दाश्त नहीं करना चाहता जो सत्य (देवी) का साथ दे।"
            "देवता, यक्ष और गन्धर्व हमारे अंदर के 'शुभ विचारों' और 'कलात्मकता' के प्रतीक हैं।"
            "अहंकार चाहता है कि इंसान के अंदर की हर अच्छी चीज़ को जड़ से खत्म कर दिया जाए।"
            "शुम्भ को लगता है कि उसकी ताकत के सामने ब्रह्मांड की कोई भी शक्ति टिक नहीं पाएगी।"
            "यह श्लोक उस 'आइसोलेशन' को दिखाता है जहाँ बुराई सबको डराकर अकेला कर देना चाहती है।"
            "परंतु वह मूर्ख नहीं जानता कि जो सबका आधार है, उसकी रक्षा के लिए किसी और की ज़रूरत नहीं होती।"
            "शुम्भ की यह धमकी वास्तव में उसकी अपनी मौत की गूंज है।"
        """.trimIndent(),
        english = """
            (Destroying Supporters): "Shumbha added: 'If anyone else stands up for Her protection (Paritranadah)'."
            "'Whether it be a God, a Yaksha, or a Gandharva—slaughter them instantaneously without mercy'."
            "Arrogance has now successfully entered its absolute 'Total Destruction Mode'."
            "It refuses to tolerate any cosmic force that aligns itself with the Absolute Truth (Goddess)."
            "Gods, Yakshas, and Gandharvas symbolize our 'Auspicious Thoughts' and internal 'Creativity'."
            "Arrogance desires to permanently uproot and destroy every positive trait within the human system."
            "Shumbha falsely believes that zero power in the universe can withstand his concentrated brute force."
            "This verse illustrates the tactic of 'Isolation' where evil attempts to frighten everyone into submission."
            "However, the fool ignores that the one who is the Foundation of all requires zero external protection."
            "Shumbha's lethal threat is actually acting as the echo of his own impending cosmic death."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 127,
        sanskrit = "ऋषिरुवाच ॥ १८८ ॥\nतेनाज्ञप्तस्ततः सोऽपि दैत्यो धूम्रलोचनः ।\nययौ सैन्येन महता वृतः षष्ट्या सहस्रकैः ॥ १८९ ॥",
        hindi = """
            (सेना का कूच): "महर्षि मेधा ने कहा: शुम्भ की आज्ञा पाकर वह दैत्य धूम्रलोचन तुरंत वहाँ से चल पड़ा।"
            "वह अपने साथ 'साठ हज़ार' (षष्ट्या सहस्रकैः) असुरों की एक विशाल सेना लेकर हिमालय की ओर गया।"
            "साठ हज़ार की सेना इंसान के दिमाग में चलने वाले उन 'भ्रमित विचारों' का प्रतीक है।"
            "धूम्रलोचन (धुआं) हमेशा 'संख्या' पर भरोसा करता है क्योंकि उसके पास 'क्वालिटी' नहीं है।"
            "जब इंसान के अंदर अज्ञान जागता है, तो वह एक-दो नहीं, बल्कि हज़ारों कुतर्क लेकर सच्चाई पर हमला करता है।"
            "हिमालय की ओर जाना मतलब ऊँची चेतना (Higher Consciousness) को कुचलने का एक नाकाम प्रयास।"
            "असुरों की भीड़ उस 'शोर' की तरह है जो मन की शांति को भंग करना चाहती है।"
            "शुम्भ के आदेश का पालन करना यह दिखाता है कि अज्ञान हमेशा अहंकार का गुलाम बनकर काम करता है।"
            "साठ हज़ार सैनिक उस 'अहंकार के नेटवर्क' को दर्शाते हैं जिसने पूरे मन को घेर लिया है।"
            "अब युद्ध का वह क्षण आ गया है जहाँ संख्या बल का सामना 'दिव्य शक्ति' से होने वाला है।"
        """.trimIndent(),
        english = """
            (March of Ignorance): "The Sage Medha said: Receiving Shumbha's command, that demon Dhumralochana immediately marched forward."
            "He headed toward the Himalayas surrounded by a colossal army of 'Sixty Thousand' demons."
            "The army of sixty thousand symbolizes the thousands of 'Confused Thoughts' that swarm a human mind."
            "Dhumralochana (The Smoke) perpetually relies on 'Quantity' because he lacks the 'Quality' of Truth."
            "When ignorance awakens, it does zero to attack with one logic, but with thousands of fallacies."
            "Marching toward the Himalayas represents a futile attempt to crush the state of Higher Consciousness."
            "The crowd of demons is like the mental 'Noise' that desperately seeks to shatter absolute inner peace."
            "Following Shumbha's order proves that ignorance always operates as a pathetic slave to the central ego."
            "Sixty thousand soldiers illustrate the 'Network of Arrogance' that has successfully surrounded the mind."
            "The moment of battle has arrived where raw numbers will finally confront the absolute Divine Power."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 128,
        sanskrit = "स दृष्ट्वा तां ततो देवीं हिमवन्तं व्यवस्थिताम् ।\nजगादोच्चैः प्रयाहीति शुम्भनिशुम्भयोः अन्तिकम् ॥ १९० ॥",
        hindi = """
            (धूम्रलोचन की दहाड़): "हिमालय पर विराजमान उस परम देवी को देखकर धूम्रलोचन ने ज़ोर से चिल्लाकर कहा।"
            "'अरे! तू अभी इसी वक्त शुम्भ और निशुम्भ के पास 'चल' (प्रयाहीति)'।"
            "धूम्रलोचन की आँखों में धुआं है, इसलिए वह देवी के 'तेज़' को देखकर भी डरा नहीं।"
            "अज्ञानी व्यक्ति साक्षात् विनाश को सामने देखकर भी अपनी 'अकड़' (Attitude) नहीं छोड़ता।"
            "'जगाद उच्चैः' (ज़ोर से चिल्लाना)—शोर मचाना कमज़ोर मन की निशानी है जो अपनी ताकत साबित करना चाहता है।"
            "वह देवी को 'आदेश' दे रहा है, जो कि ब्रह्मांड का सबसे बड़ा मज़ाक (Cosmic Joke) है।"
            "अहंकार को लगता है कि उसकी आवाज़ की ऊँचाई सत्य को झुका सकती है।"
            "वह देवी को केवल एक 'पकड़ी जाने वाली वस्तु' समझ रहा है, जो शुम्भ के पास जानी चाहिए।"
            "यह श्लोक उस 'अंधे साहस' का प्रतीक है जो केवल मूर्खता से पैदा होता है।"
            "धूम्रलोचन ने अपनी पहली और आखिरी गलती कर दी है—उसने शक्ति को ललकारा है।"
        """.trimIndent(),
        english = """
            (The Final Roar of Delusion): "Spotting the Supreme Goddess residing upon the Himalayas, Dhumralochana shouted with extreme arrogance."
            "'Hey You! Depart right this exact moment to the presence of Shumbha and Nishumbha'."
            "Dhumralochana has smoke in his eyes, which is why he failed to be terrified even by the divine radiance."
            "An ignorant person does zero to abandon his 'Stiffness' even when facing absolute certain destruction."
            "Shouting loudly is a sign of a weak mind attempting to prove its non-existent dominance."
            "He is issuing a 'Command' to the Goddess, which is undeniably the greatest Cosmic Joke in existence."
            "Arrogance falsely believes that the volume of its voice can successfully force Truth to bow."
            "He perceives the Goddess as a mere 'Object to be Captured' who belongs to Shumbha's palace."
            "This verse symbolizes that 'Blind Courage' which originates strictly from deep-seated stupidity."
            "Dhumralochana has successfully committed his final mistake—he has challenged the Primal Power."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 129,
        sanskrit = "न चेत्प्रीत्या भवती मदभर्तारमुपैष्यति ।\nततो बलान्नयाम्येतां केशाकर्षणविह्वलाम् ॥ १९१ ॥",
        hindi = """
            (अंतिम चुनौती): "'यदि तू प्रेमपूर्वक मेरे स्वामी (शुम्भ) के पास नहीं चलेगी'।"
            "'तो मैं तुझे यहाँ से 'बाल पकड़कर' घसीटते हुए और 'बलपूर्वक' (बलान्नयामि) उठा ले जाऊंगा'।"
            "धूम्रलोचन वही भाषा बोल रहा है जो उसके मालिक शुम्भ ने उसे सिखाई थी।"
            "यह दिखाता है कि अज्ञान के विचार (Thought) हमेशा अहंकार (Ego) की ही कॉपी (Copy) होते हैं।"
            "बुराई के लिए प्रेम का अर्थ केवल 'गुलामी स्वीकार करना' होता है।"
            "ज़बरदस्ती ले जाने की धमकी देना इंसान की उस 'पाश्विक वृत्ति' को दर्शाता है।"
            "जब कोई तर्क काम नहीं आता, तो अज्ञान 'हिंसा' (Violence) का सहारा लेने की कोशिश करता है।"
            "धूम्रलोचन को पूरा भरोसा है कि वह अपनी सेना के दम पर देवी को डरा लेगा।"
            "वह यह भूल गया है कि वह उस माँ को धमकी दे रहा है जो एक पल में ब्रह्मांड को भस्म कर सकती है।"
            "यह अहंकार का वह 'ओवरकॉन्फिडेंस' है जो उसे सीधी मौत के मुंह में ले जा रहा है।"
        """.trimIndent(),
        english = """
            (The Fatal Threat): "'If You do zero go affectionately to my master Shumbha voluntarily'."
            "'Then I shall forcefully (Balannayami) carry You away, dragging You by Your hair'."
            "Dhumralochana is repeating the exact patterns taught to him by his master Shumbha."
            "This proves that the thoughts of ignorance are merely pathetic 'Copies' of the central ego."
            "For evil, the word 'Love' strictly translates to 'Total Unconditional Slavery'."
            "Threatening to take Her by force reveals the absolute 'Brutal Instinct' inherent in a corrupted mind."
            "When all logic fails, thick ignorance desperately attempts to utilize 'Violence' to succeed."
            "Dhumralochana is entirely confident that his army can successfully terrorize the Goddess."
            "He has forgotten that he is threatening the Mother who can incinerate the cosmos in a split-second."
            "This represents the fatal 'Overconfidence' of arrogance that is driving it straight into death."
        """.trimIndent()
    )
)