package com.sanatangyansagar.ui.screens.gita

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun AdhyayaEight() {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var searchQuery by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    fun performSearch() {
        val shlokaNum = searchQuery.toIntOrNull()
        if (shlokaNum != null) {
            val targetIndex = adhyayaEightShlokas.indexOfFirst { it.id == shlokaNum }
            if (targetIndex != -1) {
                coroutineScope.launch {
                    listState.animateScrollToItem(targetIndex)
                }
                keyboardController?.hide()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // The fully functional Search Bar!
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search Shloka Number (1 - 28)") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = { performSearch() }
            ),
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { performSearch() }) {
                    Icon(Icons.Default.Search, contentDescription = "Jump to Shloka")
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // The Scrollable List
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(adhyayaEightShlokas) { _, shloka ->
                ShlokaCard(shloka)
            }
        }
    }
}

// ALL 28 Shlokas for Chapter 8
val adhyayaEightShlokas = listOf(
    Shloka(
        id = 1,
        sanskrit = """
            अर्जुन उवाच |
            किं तद्ब्रह्म किमध्यात्मं किं कर्म पुरुषोत्तम |
            अधिभूतं च किं प्रोक्तमधिदैवं किमुच्यते || १ ||
        """.trimIndent(),
        hindi = """
            अर्जुन ने पूछा: हे पुरुषोत्तम (श्रीकृष्ण)! वह 'ब्रह्म' (Brahman) क्या है? 'अध्यात्म' (Adhyatma) क्या है? और 'कर्म' (Karma) क्या है?
            तथा 'अधिभूत' (Adhibhuta) नाम से क्या कहा गया है, और 'अधिदैव' (Adhidaiva) किसे कहते हैं?
            आठवें अध्याय (अक्षरब्रह्म योग) की शुरुआत अर्जुन के अत्यंत तीव्र और तकनीकी (Technical) सवालों से होती है।
            सातवें अध्याय के बिल्कुल अंत (श्लोक 29-30) में भगवान श्रीकृष्ण ने कुछ बहुत ही भारी और रहस्यमयी शब्दों का इस्तेमाल किया था (ब्रह्म, अध्यात्म, कर्म, अधिभूत, अधिदैव)।
            अर्जुन एक अत्यंत बुद्धिमान शिष्य की तरह उन शब्दों को पकड़ लेते हैं और तुरंत उनका स्पष्ट अर्थ जानना चाहते हैं।
            वे भगवान को 'पुरुषोत्तम' (सभी पुरुषों/जीवों में सबसे श्रेष्ठ) कहकर संबोधित करते हैं, क्योंकि इन ब्रह्मांडीय रहस्यों का डिकोडिंग (Decoding) केवल इस सृष्टि का रचयिता ही कर सकता है।
            अर्जुन यह जानना चाहते हैं कि इस पूरे ब्रह्मांड का 'फ्रेमवर्क' (Framework) क्या है? भगवान का भौतिक दुनिया, आत्माओं और देवताओं के साथ क्या संबंध है?
            यह श्लोक एक जिज्ञासु शिष्य के तेज दिमाग को दर्शाता है जो किसी भी बात को बिना पूरी तरह समझे आगे नहीं बढ़ना चाहता।
        """.trimIndent(),
        english = """
            Arjuna intelligently inquired: O Supreme Person (Purushottama)! What exactly is Brahman? What is the self (Adhyatma)? And what are fruitive activities (Karma)?
            What is this material manifestation (Adhibhuta), and what are the demigods (Adhidaiva)? Please clearly explain this to me.
            The Eighth Chapter (Akshara Brahma Yoga) initiates with an incredibly rapid, highly technical rapid-fire sequence of questions from Arjuna.
            At the absolute tail-end of the Seventh Chapter (Verses 29-30), Lord Sri Krishna had deliberately dropped several highly complex, heavily encrypted philosophical terms (Brahman, Adhyatma, Karma, Adhibhuta, Adhidaiva).
            Operating like a brilliant spiritual scientist, Arjuna aggressively catches these terms and immediately demands their exact, clinical definitions.
            He addresses the Lord as 'Purushottama' (The Absolute Supreme Person), acknowledging that only the Supreme Architect of the cosmos possesses the security clearance to decode these universal secrets.
            Arjuna desperately wants to understand the absolute 'Framework' of reality: What exactly is the working relationship between the physical universe, the eternal souls, the celestial managers, and God?
            This verse perfectly demonstrates the razor-sharp intelligence of a genuine disciple who absolutely refuses to blindly accept jargon without a crystal-clear understanding.
        """.trimIndent()
    ),
    Shloka(
        id = 2,
        sanskrit = """
            अधियज्ञः कथं कोऽत्र देहेऽस्मिन्मधुसूदन |
            प्रयाणकाले च कथं ज्ञेयोऽसि नियतात्मभिः || २ ||
        """.trimIndent(),
        hindi = """
            हे मधुसूदन! यहाँ इस शरीर में 'अधियज्ञ' (यज्ञों का भोक्ता/ईश्वर) कौन है और वह कैसे स्थित है?
            और सबसे महत्वपूर्ण बात, जिन लोगों ने अपने मन को वश में कर लिया है (नियतात्मभिः), वे अपने जीवन के अंतिम क्षण (मृत्यु के समय / प्रयाणकाले) में आपको किस प्रकार जान पाते हैं?
            अर्जुन अपने प्रश्नों की लिस्ट में दो और अत्यंत गंभीर सवाल जोड़ते हैं।
            पहला सवाल: शरीर के अंदर भगवान का क्या रोल (Role) है? क्या भगवान केवल आसमान में हैं, या मेरे शरीर रूपी मशीन के अंदर भी उनका कोई 'कंट्रोल रूम' (Control Room / अधियज्ञ) है?
            दूसरा सवाल (जो पूरी मानव जाति का सबसे बड़ा और खौफनाक सवाल है): 'मृत्यु के समय क्या होता है?' (प्रयाणकाले)।
            मौत का दर्द इतना भयंकर होता है कि बड़े-बड़े शूरवीरों और ज्ञानियों का दिमाग सुन्न (Blank) हो जाता है। शरीर का सारा सिस्टम शटडाउन (Shut down) होने लगता है।
            अर्जुन पूछ रहे हैं कि उस खौफनाक और दर्दनाक अंतिम क्षण में, जब इंसान अपना खुद का नाम तक भूल जाता है, तब वह भगवान को (आपको) कैसे याद रख सकता है?
            यह भगवद्गीता का सबसे 'प्रैक्टिकल' (Practical) सवाल है, क्योंकि जीवन की सारी तपस्या और ज्ञान का अंतिम टेस्ट (Final Exam) केवल मृत्यु के उसी क्षण पर निर्भर करता है।
        """.trimIndent(),
        english = """
            O Madhusudana! Who exactly is the Lord of sacrifice (Adhiyajna), and how does He live within this very physical body?
            And most importantly, how can those engaged in pure devotional service and who have controlled their minds (Niyatatmabhih) possibly remember and know You at the exact, terrifying time of death (Prayana-kale)?
            Arjuna adds two extremely heavy, deeply critical questions to his rapid-fire list.
            First: What is God's exact function inside the biological body? Is God merely sitting light-years away in the sky, or does He operate a secret 'Control Room' (Adhiyajna) directly inside my physical flesh?
            Second (which is the absolute most terrifying, universal question of all humanity): 'What exactly happens at the precise moment of Death?' (Prayana-kale).
            The agonizing trauma of physical death is so horrific and violently painful that the brains of even elite warriors and massive scholars completely crash into a blank void. The entire biological system enters a catastrophic shutdown.
            Arjuna desperately asks: In that blindingly horrific, agonizing final microsecond, when a human forgets his own name, how on earth can he possibly retain the mental focus required to remember YOU?
            This is the absolute most 'Practical' question in the Gita, because the entire 'Final Exam' of a human's lifetime of spiritual practice depends 100% exclusively on what he thinks of at the exact moment of death.
        """.trimIndent()
    ),
    Shloka(
        id = 3,
        sanskrit = """
            श्रीभगवानुवाच |
            अक्षरं ब्रह्म परमं स्वभावोऽध्यात्ममुच्यते |
            भूतभावोद्भवकरो विसर्गः कर्मसञ्ज्ञितः || ३ ||
        """.trimIndent(),
        hindi = """
            श्री भगवान ने कहा: जिसका कभी विनाश नहीं होता, वह परम सत्य 'अक्षर' ही 'ब्रह्म' (Brahman) है; और उस ब्रह्म का जो अपना मूल स्वभाव है, उसे 'अध्यात्म' (Adhyatma/आत्मा) कहा जाता है।
            जीवों के भौतिक शरीरों (भूतभाव) को उत्पन्न करने वाली जो विसर्ग (सृष्टि या त्याग) की प्रक्रिया है, उसी को 'कर्म' (Karma) कहा जाता है।
            भगवान श्रीकृष्ण यहाँ एक-एक करके अर्जुन के सवालों का डिकोडिंग (Decoding) शुरू कर रहे हैं।
            १. 'ब्रह्म': दुनिया में हर चीज़ टूटती है और मरती है (क्षर)। लेकिन जो चीज़ कभी नहीं मरती, जो इंडिस्ट्रक्टिबल (Indestructible/अक्षर) है, वही 'परम ब्रह्म' (The Supreme Truth/ईश्वर) है।
            २. 'अध्यात्म': उस परम ब्रह्म का जो असली 'स्वभाव' (Nature) है, उसे अध्यात्म (या जीवात्मा) कहते हैं। जैसे आग का स्वभाव गरमाहट है, वैसे ही आत्मा का स्वभाव भगवान की सेवा करना (Spiritual Nature) है।
            ३. 'कर्म': यह सबसे रोचक परिभाषा है। साधारण इंसान 'नौकरी' को कर्म मानता है। लेकिन भगवान कहते हैं कि वह प्रक्रिया (विसर्ग/Action) जिसके कारण आत्माओं को नए-नए भौतिक 'शरीर' (भूतभाव) मिलते हैं (यानी पुनर्जन्म होता है), वह 'कर्म' है।
            अर्थात्, जो एक्शन (Action) आपको इस दुनिया की 'मैट्रिक्स' (Matrix) में नए शरीर और दुःख पैदा करने पर मजबूर कर दे, वह भौतिक 'कर्म' है।
        """.trimIndent(),
        english = """
            The Supreme Personality of Godhead explicitly answered: The indestructible, transcendental living entity is called Brahman, and his eternal nature is called Adhyatma (the Self).
            Action pertaining to the development of the material bodies of the living entities is called Karma (fruitive activities).
            Lord Sri Krishna systematically begins the clinical 'Decoding' of Arjuna's highly technical questions one by one.
            1. 'Brahman': Everything in this material universe decays, rots, and dies (Kshara). But that supreme, ultimate entity which is 100% imperishable and completely 'Indestructible' (Akshara) is the 'Supreme Brahman' (God/The pure soul).
            2. 'Adhyatma': The inherent, eternal, default 'Nature' (Svabhava) of that Brahman is called Adhyatma. Just as the inherent nature of fire is heat and light, the inherent spiritual nature of the soul is to be eternally connected to God.
            3. 'Karma': This is a mind-bending definition. Ignorant mortals think "going to the office" is karma. But the Lord declares that the specific creative action (Visargah) which forces eternal souls to develop and generate new physical, biological 'Bodies' (reincarnation) within this material matrix is technically called 'Karma'.
            Meaning: Any toxic action that manufactures your next physical body and forcefully keeps you trapped in the cycle of birth and death is material Karma.
        """.trimIndent()
    ),
    Shloka(
        id = 4,
        sanskrit = """
            अधिभूतं क्षरो भावः पुरुषश्चाधिदैवतम् |
            अधियज्ञोऽहमेवात्र देहे देहभृतां वर || ४ ||
        """.trimIndent(),
        hindi = """
            हे देहधारियों में श्रेष्ठ अर्जुन (देहभृतां वर)! लगातार नष्ट होने वाली (क्षर) भौतिक प्रकृति को ही 'अधिभूत' (Adhibhuta) कहा जाता है; और ब्रह्मांड के सभी देवताओं का जो विराट पुरुष (ईश्वर का विराट रूप) है, उसे 'अधिदैव' (Adhidaiva) कहा जाता है।
            और हे अर्जुन! इस शरीर के भीतर जो यज्ञों का भोक्ता (परमात्मा) है, वह 'अधियज्ञ' साक्षात् मैं (कृष्ण) ही हूँ।
            भगवान श्रीकृष्ण यहाँ ब्रह्मांड के बाकी बचे हुए 3 सवालों के जवाब दे रहे हैं।
            १. 'अधिभूत': इस दुनिया की हर वह भौतिक चीज़ जो लगातार बदल रही है, सड़ रही है और मिट रही है ('क्षर भावः' / जैसे हमारा शरीर, ग्रह, पेड़-पौधे), उसे अधिभूत (Physical Nature) कहते हैं।
            २. 'अधिदैव': ब्रह्मांड को चलाने वाले सारे देवताओं (जैसे सूर्य, इंद्र, ब्रह्मा) की जो कलेक्टिव (Collective/संयुक्त) शक्ति है—यानी भगवान का वह विशाल ब्रह्मांडीय रूप (Universal Form/पुरुष)—उसे अधिदैव कहते हैं।
            ३. 'अधियज्ञ' (सबसे बड़ा रहस्य): अर्जुन ने पूछा था कि शरीर के अंदर भगवान कहाँ हैं? श्रीकृष्ण कहते हैं, "अधियज्ञोऽहमेवात्र देहे" (इस भौतिक शरीर के अंदर तुम्हारे दिल में 'परमात्मा/Super-soul' के रूप में मैं खुद बैठा हूँ)।
            इंसान सोचता है कि वह अपने शरीर का अकेला मालिक है, लेकिन भगवान कहते हैं कि मैं 24 घंटे तुम्हारे दिल में बैठकर तुम्हारे सारे कर्मों (यज्ञों) को नोट (Note) कर रहा हूँ और उन्हें शक्ति दे रहा हूँ। तुम एक सेकंड के लिए भी मेरे बिना साँस नहीं ले सकते।
        """.trimIndent(),
        english = """
            O best of the embodied beings (Arjuna)! The physical nature, which is constantly changing and perishable (Ksharah bhavah), is called Adhibhuta (the material manifestation). The universal form of the Lord, which includes all the demigods, is called Adhidaiva.
            And I Myself, residing as the Supersoul within the heart of every embodied being, am the ultimate Lord of sacrifice (Adhiyajna).
            Lord Sri Krishna provides the absolute, clinical definitions for the remaining 3 cosmic entities.
            1. 'Adhibhuta': Absolutely everything in this material universe that is constantly mutating, decaying, and inevitably destined for destruction ('Kshara bhavah' / like our biological bodies, stars, and planets) is termed Adhibhuta (Physical Nature).
            2. 'Adhidaiva': The collective, supreme administrative authority of all cosmic demigods (like the Sun, Indra, Brahma)—which is essentially the staggering, gigantic Universal Form (Purusha) of the Lord—is termed Adhidaiva.
            3. 'Adhiyajna' (The Greatest Secret): Arjuna explicitly asked, "Where exactly is God located inside the body?" Sri Krishna drops a massive truth bomb: "Adhiyajno 'ham evatra dehe" (I Myself am physically and spiritually sitting right inside the core of your heart as the 'Paramatma' / Supersoul).
            Ignorant humans arrogantly hallucinate that they are the absolute owners of their bodies. But the Lord reveals that He is sitting deep inside your heart 24/7, witnessing, auditing, and powering every single action (Yajna) you perform. You cannot take a single breath without His direct sanction.
        """.trimIndent()
    ),
    Shloka(
        id = 5,
        sanskrit = """
            अन्तकाले च मामेव स्मरन्मुक्त्वा कलेवरम् |
            यः प्रयाति स मद्भावं याति नास्त्यत्र संशयः || ५ ||
        """.trimIndent(),
        hindi = """
            और जो मनुष्य अपने जीवन के बिल्कुल अंतिम क्षण (मृत्यु के समय / अन्तकाले) में, केवल मेरा ही (मामेव) स्मरण करते हुए अपने इस शरीर (कलेवरम्) को त्यागता है...
            वह मनुष्य निश्चित रूप से मेरे ही साक्षात् ईश्वरीय स्वरूप (मद्भावं) को प्राप्त होता है। इसमें रत्ती भर भी कोई संदेह (संशय) नहीं है।
            यह श्लोक 'विज्ञान ऑफ डेथ' (Science of Death / मृत्यु का विज्ञान) का सबसे बड़ा और सबसे शक्तिशाली नियम (Rule) है।
            मरते समय इंसान का दिमाग बहुत भयंकर पीड़ा और भ्रम (Confusion) में होता है। उस समय उसे अपनी प्रॉपर्टी, बच्चे, या अपनी अधूरी इच्छाएं याद आती हैं।
            लेकिन भगवान एक बहुत बड़ी और साफ 'गारंटी' (Guarantee) देते हैं: "अगर कोई इंसान अपनी आखिरी साँस (Last Breath) छोड़ते समय किसी भी तरह, केवल मुझे (ईश्वर को) याद कर ले, तो वह सीधा 'मद्भावं' (My nature / मेरे वैकुंठ धाम) में आ जाएगा।"
            यह कोई जुआ (Gamble) या शायद (Probably) वाली बात नहीं है। श्रीकृष्ण इसे 'नास्त्यत्र संशयः' (100% Guaranteed without a single doubt) कहकर स्टैम्प (Stamp) लगा देते हैं।
            लेकिन यहाँ एक 'कैच' (Catch/पेंच) है: मौत कब आएगी, यह किसी को नहीं पता। और जिस चीज़ की आदत आपने पूरी ज़िंदगी (70 साल) डाली है (जैसे पैसे के बारे में सोचना), वही चीज़ मौत के खौफनाक समय पर अपने-आप दिमाग में आएगी। 
            इसलिए आखिरी पल में भगवान को याद करने के लिए, पूरी ज़िंदगी भगवान को याद करने की 'ट्रेनिंग' (Training) करनी पड़ती है।
        """.trimIndent(),
        english = """
            And whoever, at the exact, terrifying moment of death (Anta-kale), quits his physical body (Kalevaram) remembering Me and Me alone (Mam eva smaran)...
            at once perfectly attains My supreme, divine nature (Mad-bhavam). Of this, there is absolutely no doubt whatsoever (Nasty atra samshayah).
            This spectacular verse establishes the absolute, ultimate 'Science of Death' and the supreme Hack for exiting the matrix.
            At the exact moment of physical death, the human brain undergoes horrific trauma, excruciating pain, and blinding confusion. During that catastrophic system failure, ordinary humans desperately remember their bank accounts, unfulfilled lust, or screaming family members.
            But the Supreme Lord issues an iron-clad, massive 'Cosmic Guarantee': "If a human being, while exhaling his absolute final breath, somehow manages to exclusively remember ME, his soul bypasses everything and instantly shoots straight into 'Mad-bhavam' (My eternal, divine Kingdom / Vaikuntha)."
            This is absolutely not a gamble or a probability. Sri Krishna officially stamps it with "Nasty atra samshayah" (100% mathematically guaranteed, zero doubts).
            But there is a massive 'Catch': No one knows the exact timestamp of their death. Furthermore, whatever toxic habit you have intensely practiced for 70 years (like obsessing over money) is exactly what will violently surface in your brain during the panic of death.
            Therefore, to successfully execute this ultimate 'Death-Hack', one must fiercely train and program his brain to remember God every single day of his life.
        """.trimIndent()
    ),
    Shloka(
        id = 6,
        sanskrit = """
            यं यं वापि स्मरन्भावं त्यजत्यन्ते कलेवरम् |
            तं तमेवैति कौन्तेय सदा तद्भावभावितः || ६ ||
        """.trimIndent(),
        hindi = """
            हे कुन्तीपुत्र (कौन्तेय)! मनुष्य अपने अंत समय (मृत्यु के समय) में जिस-जिस भी भाव (अवस्था, वस्तु या प्राणी) का स्मरण (याद) करते हुए अपने शरीर को त्यागता है...
            वह मनुष्य अपने अगले जन्म में निश्चित रूप से उसी भाव (उसी योनि या शरीर) को ही प्राप्त होता है, क्योंकि उसने जीवन भर उसी भाव का चिंतन (सदा तद्भावभावितः) किया है।
            यह श्लोक पुनर्जन्म (Reincarnation) का सबसे 'कठोर और साइंटिफिक नियम' (Strict Scientific Law) है।
            मरते समय इंसान का दिमाग एक 'सर्च इंजन' (Search Engine) की तरह काम करता है। आखिरी साँस लेते समय आप जिस भी चीज़ के बारे में सबसे गहराई से सोचेंगे, प्रकृति (Nature) आपको अगला जन्म बिल्कुल वैसा ही दे देगी।
            अगर कोई इंसान मरते समय अपने पालतू कुत्ते के बारे में बहुत प्यार या चिंता से सोच रहा है, तो नियम के अनुसार ('तं तमेवैति') उसे अगला जन्म एक कुत्ते के रूप में ही मिलेगा (जैसे राजा भरत को हिरण का जन्म मिला था)।
            अगर कोई मरते समय अपनी पत्नी या पैसों के बारे में सोचता है, तो वह भूत-प्रेत या किसी ऐसी योनि में जाएगा जहाँ वह उन चीजों के आस-पास रह सके।
            भगवान कहते हैं, "सदा तद्भावभावितः"—यानी मौत के समय वही चीज़ याद आती है, जिसके बारे में तुमने पूरी जिंदगी सबसे ज्यादा सोचा है। तुम मौत के वक्त अपने दिमाग को 'धोखा' (Cheat) नहीं दे सकते।
            तुम्हारी 'लास्ट थॉट' (Last Thought) ही तुम्हारा 'नेक्स्ट डेस्टिनेशन' (Next Destination) तय करती है।
        """.trimIndent(),
        english = """
            Whatever specific state of being (Yam yam vapi smaran bhavam) one vividly remembers when he quits his physical body at the time of death (Tyajaty ante kalevaram)...
            that exactly and certainly is the specific state he will attain in his next life (Tam tam evaiti), O son of Kunti, because of his constant and lifelong absorption in that specific thought (Sada tad-bhava-bhavitah).
            This verse reveals the absolute, terrifyingly strict 'Scientific Law of Reincarnation' and karmic destination.
            At the exact microsecond of death, the human brain operates exactly like a cosmic 'Search Engine'. Whatever specific thought, object, or entity your consciousness is most deeply locked onto during that final breath, Material Nature instantly registers it and manufactures your next biological body exactly matching that frequency.
            If an overly attached human dies frantically worrying about his pet dog, the strict algorithm ('Tam tam evaiti') dictates that his soul will be instantly downloaded into the body of a dog in his next birth (as happened to the legendary King Bharata with a deer).
            If a man dies obsessing over his hidden wealth, he might be reborn as a snake guarding that treasure.
            The Lord drops a brutal truth: "Sada tad-bhava-bhavitah"—Meaning, the final thought at death is absolutely not a random accident. You will invariably remember only that specific thing which you have practiced obsessing over your entire life. You absolutely cannot 'Cheat' your subconscious mind at the hour of panic.
            Your 'Last Thought' exclusively determines your 'Next Destination'.
        """.trimIndent()
    ),
    Shloka(
        id = 7,
        sanskrit = """
            तस्मात्सर्वेषु कालेषु मामनुस्मर युध्य च |
            मय्यर्पितमनोबुद्धिर्मामेवैष्यस्यसंशयम् || ७ ||
        """.trimIndent(),
        hindi = """
            इसलिए (चूँकि मृत्यु का समय निश्चित नहीं है), तुम सभी समयों (हमेशा / सर्वेषु कालेषु) में निरंतर मेरा (परमात्मा का) स्मरण (ध्यान) करो, और साथ ही अपना युद्ध (कर्तव्य) भी करो (युध्य च)।
            इस प्रकार अपने मन और बुद्धि को पूरी तरह मुझमें अर्पण करके (मय्यर्पितमनोबुद्धिः), तुम निश्चित रूप से (असंशयम्) मुझे ही प्राप्त करोगे।
            भगवान श्रीकृष्ण यहाँ पूरी भगवद्गीता का सबसे 'व्यावहारिक और मास्टर फॉर्मूला' (Ultimate Master Formula) दे रहे हैं।
            चूँकि मृत्यु कभी भी, कहीं भी आ सकती है (एक्सीडेंट, हार्ट अटैक), इसलिए इंसान आखिरी दिन का इंतज़ार नहीं कर सकता। भगवान कहते हैं, "सर्वेषु कालेषु" (24/7 हर समय मेरा स्मरण करो)।
            लेकिन क्या इसका मतलब है कि काम छोड़कर मंदिर में बैठ जाओ? भगवान ज़ोर देकर कहते हैं: "युध्य च!" (युद्ध भी करो!)।
            यह कोई आम आदेश नहीं है; यह 'मल्टी-टास्किंग' (Spiritual Multi-tasking) का सर्वोच्च रूप है। बाहर से तुम्हारे हाथ दुनिया का सबसे खतरनाक और फोकस (Focus) वाला काम (युद्ध/जॉब) कर रहे हों, लेकिन तुम्हारा अंदरूनी 'मन और बुद्धि' (Mind and Intelligence) 100% ईश्वर पर 'अपलोड/अर्पित' (Uploaded/Arpit) होना चाहिए।
            जो व्यक्ति इस तरह से काम करता है (हाथ काम में, और दिल राम में), उसे भगवान खुद स्टैम्प पेपर पर लिखकर गारंटी (असंशयम् - बिना किसी शक के) देते हैं कि "मरने के बाद तुम सीधे मेरे पास ही आओगे।"
            कर्तव्य और भक्ति एक दूसरे के दुश्मन नहीं हैं, बल्कि वे एक ही सिक्के के दो पहलू हैं।
        """.trimIndent(),
        english = """
            Therefore (since the time of death is highly uncertain), you should always and at all times think of Me in the form of Krishna (Sarveshu kaleshu mam anusmara) and simultaneously carry out your prescribed duty of fighting (Yudhya cha).
            With your mind and your intelligence completely dedicated, surrendered, and uploaded onto Me (Mayy arpita-mano-buddhir), you will undoubtedly and flawlessly attain Me (Mam evaishyasy asamshayam).
            Lord Sri Krishna delivers the absolute 'Ultimate Master Formula' and the most pragmatic instruction of the entire Bhagavad Gita right here.
            Since physical death is a highly unpredictable stealth assassin (car crash, sudden heart failure), a human absolutely cannot foolishly wait until his deathbed to start meditating. The Lord commands: "Sarveshu kaleshu" (You must run My remembrance as a background app in your brain 24/7).
            But does this mean violently abandoning your career to hide in a monastery? The Lord aggressively commands: "YUDHYA CHA!" (AND FIGHT!).
            This is the supreme, elite level of 'Spiritual Multi-tasking'. Externally, your physical hands and brain must execute the most highly complex, dangerous, and focus-demanding corporate or martial duties in the matrix. But internally, your 'Mind and Intelligence' must be 100% seamlessly 'Uploaded' and locked onto the Supreme Lord.
            To the superhuman who successfully executes this split-consciousness (Hands engaged in the world, Heart engaged in God), the Supreme Lord issues an iron-clad, signed cosmic guarantee ('Asamshayam' - zero doubts): "You will bypass the matrix and attain ME instantly upon death."
            Hardcore worldly duty and pure devotion are absolutely not enemies; they are the ultimate winning combination.
        """.trimIndent()
    ),
    Shloka(
        id = 8,
        sanskrit = """
            अभ्यासयोगयुक्तेन चेतसा नान्यगामिना |
            परमं पुरुषं दिव्यं याति पार्थानुचिन्तयन् || ८ ||
        """.trimIndent(),
        hindi = """
            हे पार्थ! जो मनुष्य निरंतर 'अभ्यास' (Practice) रूपी योग में लगा हुआ है, और जिसका चित्त (मन) भगवान के सिवा किसी भी अन्य ओर नहीं भटकता (नान्यगामिना)...
            वह मनुष्य लगातार उसी परम दिव्य पुरुष (परमात्मा) का ही चिंतन (अनुचिन्तयन्) करता हुआ, अंततः उसी परमेश्वर को प्राप्त कर लेता है (याति)।
            पिछले श्लोक में भगवान ने कहा था "मन मुझमें लगाओ"। अब अर्जुन या कोई भी इंसान पूछ सकता है कि "मन तो बहुत भागता है, उसे एक जगह (भगवान पर) कैसे टिकाएं?"
            भगवान इसका एक ही वैज्ञानिक (Scientific) उपाय बताते हैं: 'अभ्यास योग' (The Yoga of Constant Practice)।
            मन का नेचर (Nature) है भटकना ('नान्यगामिना' का उल्टा)। वह पैसे, सेक्स और टीवी की तरफ भागेगा। लेकिन आपको क्या करना है? आपको उसे बार-बार घसीट कर वापस 'परम दिव्य पुरुष' (Supreme Divine God) के ध्यान पर लाना है।
            यह बिल्कुल जिम (Gym) में वजन उठाने जैसा है। पहली बार में 100 किलो नहीं उठेगा, लेकिन महीनों के 'अभ्यास' से आपकी मेंटल मसल (Mental Muscle) इतनी मजबूत हो जाएगी कि मन भगवान को छोड़कर कहीं और जाएगा ही नहीं ('नान्यगामिना')।
            जिसका मन इस तरह से प्रोग्राम (Program) हो जाता है कि वह सोते-जागते केवल ईश्वर का ही डीप-थिंकिंग (Deep-thinking / अनुचिन्तयन्) करता है, वह इंसान मृत्यु के बाद 100% उसी दिव्य परमेश्वर की अवस्था में प्रवेश कर जाता है। 'अभ्यास' ही सफलता की इकलौती चाबी है।
        """.trimIndent(),
        english = """
            He who constantly meditates on the Supreme Personality of Godhead, his mind deeply engaged in the unwavering practice of remembering Me (Abhyasa-yoga-yuktena), and whose consciousness absolutely never strays or deviates to any other path or object (Nanya-gamina)...
            O Partha, that person, constantly contemplating and intensely remembering Him (Anuchintayan), is guaranteed to attain that Supreme Divine Person (Paramam purusham divyam yati).
            In the previous verse, the Lord demanded, "Keep your mind fixed on Me." A natural human reaction is: "But my mind violently rebels and runs everywhere; how do I actually fix it?"
            The Lord provides the absolute, sole scientific methodology to achieve this: 'Abhyasa Yoga' (The Yoga of Relentless, Brutal Practice).
            The default factory setting of the human brain is to wander rapidly towards cheap dopamine (social media, lust, greed). But what must you do? You must violently drag it back by the collar and forcefully lock it onto the 'Supreme Divine Person', thousands of times a day.
            This is exactly like lifting heavy iron in a gym. You will fail initially, but through sheer, relentless 'Abhyasa' (Repetitive Practice), your neurological pathways will physically rewire, building a titanium mental muscle that absolutely refuses to deviate to any worldly garbage ('Nanya-gamina').
            A human who successfully programs his brain to constantly run this deep, background meditation ('Anuchintayan') on God, 24/7 without a single glitch, effortlessly shoots straight into the eternal dimension of the Supreme Divine Lord upon death. 'Relentless Practice' is the ultimate master-key.
        """.trimIndent()
    ),
    Shloka(
        id = 9,
        sanskrit = """
            कविं पुराणमनुशासितारमणोरणीयांसमनुस्मरेद्यः |
            सर्वस्य धातारमचिन्त्यरूपमादित्यवर्णं तमसः परस्तात् || ९ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 9 और 10 एक ही विचार हैं)
            जो मनुष्य उस परमेश्वर का स्मरण (ध्यान) करता है जो 'कवि' (सर्वज्ञ / सब कुछ जानने वाले) हैं, 'पुराण' (सबसे प्राचीन / अनादि) हैं, 'अनुशासिता' (पूरे ब्रह्मांड को कंट्रोल करने वाले) हैं, जो 'अणु से भी अत्यंत छोटे' (सूक्ष्म) हैं...
            जो सभी प्राणियों को धारण करने वाले (धाता / Sustainer) हैं, जिनका रूप 'अचिन्त्य' (मनुष्य की सोच से परे) है, और जो 'आदित्यवर्ण' (सूर्य के समान तेज वाले) तथा अज्ञान रूपी 'अंधकार (तमस) से पूरी तरह परे' (परस्तात्) हैं...
            भगवान श्रीकृष्ण यहाँ 'मेडिटेशन का ऑब्जेक्ट' (The Object of Meditation) दे रहे हैं। जब आप आँखें बंद करें, तो आपको भगवान के बारे में क्या सोचना है? यह श्लोक भगवान का सबसे शानदार '3D प्रोफ़ाइल' (3D Profile) है!
            १. 'कविं': वे कोई साधारण शक्ति नहीं, बल्कि परम ज्ञानी हैं, जो भूत-भविष्य सब जानते हैं।
            २. 'पुराणम्': वे बिग-बैंग (Big Bang) से भी बहुत पहले के हैं, उनका कोई जन्म नहीं है।
            ३. 'अनुशासितारम्': वे ब्रह्मांड के सुप्रीम डिक्टेटर/कंट्रोलर (Supreme Dictator/Controller) हैं; उनके बिना एक पत्ता भी नहीं हिलता।
            ४. 'अणोरणीयांसम्': वे इतने 'माइक्रोस्कोपिक' (Microscopic) हैं कि एटम (Atom/अणु) के भी अंदर घुस सकते हैं, फिर भी...
            ५. 'सर्वस्य धातारम्': वे इतने विशाल हैं कि पूरे ब्रह्मांड के खरबों ग्रहों को होल्ड (Hold / धारण) किए हुए हैं।
            ६. 'अचिन्त्यरूपम्': आपका 100 ग्राम का दिमाग उनके रूप की कल्पना भी नहीं कर सकता।
            ७. 'आदित्यवर्णं तमसः परस्तात्': वे 1000 सूर्यों से भी ज्यादा चमकदार हैं, और उनके आस-पास अज्ञानता या माया (Darkness/तमस) का 0% वजूद है। 
            जब योगी इस अकल्पनीय और डरावनी (Awe-inspiring) प्रोफाइल पर अपना दिमाग लॉक (Lock) कर लेता है, तो दुनिया की छोटी-मोटी चीज़ें उसे कैसे डरा सकती हैं?
        """.trimIndent(),
        english = """
            (Verses 9 and 10 form a continuous thought)
            One should deeply meditate upon the Supreme Person as the one who knows absolutely everything (Kavim), who is the oldest, primeval original person (Puranam), who is the supreme controller and dictator of the cosmos (Anushasitaram), who is smaller than the smallest atom (Anor aniyamsam)...
            who is the supreme maintainer and sustainer of absolutely everything (Sarvasya dhataram), whose actual form is completely inconceivable and beyond human imagination (Achintya-rupam), and who is brilliantly luminous exactly like the blinding sun (Aditya-varnam), completely and utterly transcendental to all material darkness and illusion (Tamasah parastat)...
            Lord Sri Krishna is explicitly delivering the absolute 'Ultimate Object of Meditation' here. When you shut your eyes to meditate, what exactly are the specifications of the God you must focus on? This verse is God's staggeringly majestic '3D Cosmic Profile'!
            1. 'Kavim': He is not just a blind force; He is the Omniscient Mastermind who knows every single quantum particle's history.
            2. 'Puranam': He existed eternally long before the Big Bang; He has zero beginning.
            3. 'Anushasitaram': He is the absolute, undisputed Supreme Controller. Gravity and physics only work because He orders them to.
            4. 'Anor aniyamsam': He is so incredibly Microscopic that He comfortably sits directly inside the nucleus of a single atom, yet...
            5. 'Sarvasya dhataram': He is so gigantically massive that He effortlessly suspends billions of galaxies in the vacuum of space.
            6. 'Achintya-rupam': Your pathetic, three-pound biological brain lacks the capacity to even partially imagine His true, terrifyingly beautiful form.
            7. 'Aditya-varnam Tamasah Parastat': He radiates blinding, radioactive light stronger than a billion supernovas, existing in a dimension absolutely untouched by the toxic darkness (Tamas) of the material matrix.
            When a Yogi aggressively locks his consciousness onto this awe-inspiring, staggering profile, how can cheap, petty worldly problems ever affect him again?
        """.trimIndent()
    ),
    Shloka(
        id = 10,
        sanskrit = """
            प्रयाणकाले मनसाचलेन भक्त्या युक्तो योगबलेन चैव |
            भ्रुवोर्मध्ये प्राणमावेश्य सम्यक् स तं परं पुरुषमुपैति दिव्यम् || १० ||
        """.trimIndent(),
        hindi = """
            (श्लोक 9 का शेष)... वह योगी मृत्यु के समय (प्रयाणकाले), अपने पूरी तरह से अचल (स्थिर) मन से, सच्ची भक्ति से युक्त होकर (भक्त्या युक्तो), और योग की शक्ति (योगबलेन) के द्वारा...
            अपने प्राणों (जीवन वायु) को दोनों भौंहों के बीच (आज्ञा चक्र में) भली-भांति स्थापित करके (भ्रुवोर्मध्ये प्राणमावेश्य सम्यक्), उसी परम दिव्य पुरुष (परमात्मा) को निश्चित रूप से प्राप्त कर लेता है (उपैति)।
            यह श्लोक एक एडवांस योगी (Advanced Yogi) की मृत्यु का सबसे रहस्यमयी और 'क्लीनिकल' (Clinical) विवरण (Description) है।
            साधारण इंसान की मौत के समय उसकी साँसें बेकाबू हो जाती हैं और वह डर से तड़पता है। लेकिन एक मास्टर योगी (Master Yogi) की मौत एक 'प्रीमियम एग्ज़िट' (Premium Exit) की तरह होती है।
            मौत के उस खौफनाक समय ('प्रयाणकाले') में, वह योगी बिल्कुल नहीं घबराता। उसका मन एकदम 'अचल' (Rock-solid/स्थिर) होता है।
            वह अपनी पूरी जिंदगी की 'योग की शक्ति' (योगबलेन) और ईश्वर के प्रति 'गहरे प्यार' (भक्त्या) का इस्तेमाल करता है।
            वह अपनी चेतना और प्राण-वायु (Life-force) को शरीर के निचले हिस्सों से खींचकर, पूरी सटीकता के साथ दोनों भौंहों के बीच (थर्ड आई / Ajna Chakra) में ला कर 'लॉक' (Lock / आवेश्य) कर देता है।
            जब योगी इस भयंकर फोकस (Focus) और परफेक्शन (Perfection) के साथ अपनी इच्छा से शरीर छोड़ता है, तो वह किसी भूत-प्रेत या स्वर्ग की योनि में नहीं भटकता। वह एक रॉकेट (Rocket) की तरह सीधे 'परम दिव्य पुरुष' (The Supreme Divine God) के पास पहुँच जाता है और हमेशा के लिए मुक्त हो जाता है।
        """.trimIndent(),
        english = """
            (Continuing from Verse 9)... Whoever, at the exact, terrifying time of death (Prayana-kale), with a completely unmoving, titanium-fixed mind (Manasachalena), being fully armed with deep devotion (Bhaktya yukto), and utilizing the absolute, raw power of his lifelong yoga practice (Yoga-balena chaiva)...
            flawlessly and forcefully establishes his vital life-air (Prana) exactly between his two eyebrows (Bhruvor madhye pranam aveshya samyak), that elite yogi undoubtedly attains the Supreme Divine Personality of Godhead (Sa tam param purusham upaiti divyam).
            This spectacular verse provides the absolute most classified, highly 'Clinical' description of how an Ultra-Advanced Yogi executes his final exit from the biological matrix.
            When an ordinary mortal dies, his breathing becomes chaotic, his biological system crashes, and he dies screaming in blinding terror. But a Grandmaster Yogi's death is a highly calculated, 'Premium VIP Exit'.
            At that horrifying hour of death ('Prayana-kale'), the Yogi absolutely does not panic. His mind remains 'Achala' (frozen, rock-solid, and completely unshaken).
            He aggressively deploys the sheer, raw 'Superpower of his lifelong Yoga' (Yoga-balena) fused with the explosive power of his deep 'Love for God' (Bhaktya).
            He systematically and violently pulls his life-force (Prana) upwards from the lower chakras of his biological body and flawlessly 'Locks' it directly between his two eyebrows (The Third Eye / Ajna Chakra).
            By consciously and forcefully ejecting his soul from the physical body with such terrifying, laser-sharp focus, he completely bypasses the lower dimensions and shoots directly like an uninterceptable missile straight to the 'Supreme Divine Person' (God), achieving absolute, eternal liberation.
        """.trimIndent()
    ),
    Shloka(
        id = 11,
        sanskrit = """
            यदक्षरं वेदविदो वदन्ति विशन्ति यद्यतयो वीतरागाः |
            यदिच्छन्तो ब्रह्मचर्यं चरन्ति तत्ते पदं सङ्ग्रहेण प्रवक्ष्ये || ११ ||
        """.trimIndent(),
        hindi = """
            वेदों को जानने वाले महान विद्वान (वेदविदः) जिसे 'अक्षर' (अविनाशी / कभी नष्ट न होने वाला) कहते हैं; और सांसारिक इच्छाओं से पूरी तरह मुक्त (वीतरागाः) संन्यासी (यतयः) जिसमें प्रवेश करते हैं (विशन्ति)...
            तथा जिस परम पद को पाने की इच्छा से साधक लोग 'ब्रह्मचर्य' के अत्यंत कठोर व्रत का पालन करते हैं; उस 'परम पद' (Ultimate State/Destination) को मैं तुम्हें अब संक्षेप (Short/Summary) में बताऊँगा (प्रवक्ष्ये)।
            यहाँ भगवान श्रीकृष्ण अर्जुन को ब्रह्मांड के सबसे महान और सीक्रेट (Secret) 'डेस्टिनेशन' (Destination / परम पद) के बारे में बताने से पहले एक बहुत बड़ा 'बिल्ड-अप' (Build-up) दे रहे हैं।
            वे बता रहे हैं कि जिस पते (Address) के बारे में मैं तुम्हें बताने जा रहा हूँ, वह कोई आम जगह नहीं है:
            १. वेदों के सबसे बड़े साइंटिस्ट (वेदविदः) अपनी पूरी जिंदगी की रिसर्च (Research) के बाद उसे 'अक्षर' (Indestructible) कहते हैं। यानी वह जगह कभी किसी प्रलय (Doomsday) में खत्म नहीं होती।
            २. दुनिया के बड़े-बड़े संन्यासी, जिन्होंने अपनी सारी वासनाओं और फैमिली (Family) का मोह ('वीतराग') खत्म कर दिया है, वे अपना घर छोड़कर केवल उसी जगह (मुक्ति) में 'एंट्री' (प्रवेश) पाने के लिए पागलों की तरह तपस्या करते हैं।
            ३. और उस एक चीज़ को पाने के लिए लोग अपनी पूरी जिंदगी 'ब्रह्मचर्य' (Celibacy) का अत्यंत कठोर और दर्दनाक व्रत पालते हैं, ताकि उनकी ऊर्जा (Energy) वेस्ट (Waste) न हो।
            इतना महान और मुश्किल है वह लक्ष्य! भगवान कहते हैं कि वह परम रहस्य मैं तुम्हें अब बहुत ही सिंपल और 'शॉर्ट' (संक्षेप) रूप में समझाने जा रहा हूँ कि वहाँ तक कैसे पहुँचते हैं।
        """.trimIndent(),
        english = """
            That supreme destination which great scholars and knowers of the Vedas (Veda-vido) describe as the Imperishable (Yad aksharam); into which the great, highly elevated ascetics who are completely freed from all worldly attachments (Yatayo vita-ragah) enter...
            and deeply desiring which, sincere practitioners strictly vow to practice severe celibacy (Brahmacharyam charanti); that ultimate, supreme state (Tat padam) I shall now explain to you briefly and in summary (Samgrahena pravakshye).
            Here, Lord Sri Krishna is engineering a massive, hype-inducing 'Build-up' before officially dropping the highly classified coordinates of the absolute greatest 'Destination' in the multiverse.
            He is warning Arjuna that the specific address He is about to reveal is absolutely not a cheap tourist spot:
            1. The absolute most elite scientists of the Vedas (Veda-vidah), after a lifetime of rigorous cosmic research, officially classify this destination as 'Aksharam' (The Indestructible). Meaning, even when the entire universe is violently annihilated in a Doomsday event, this place remains perfectly intact.
            2. The greatest, most hardcore monks and ascetics, who have violently slaughtered every single toxic attachment to money and family ('Vita-raga'), sacrifice their entire lives purely to gain 'Entry' (Vishanti) into this one specific dimension.
            3. And solely to achieve this staggering goal, highly dedicated practitioners voluntarily subject themselves to the unimaginably brutal, lifelong discipline of 'Brahmacharya' (Absolute Celibacy), hoarding their biological energy to launch their souls upward.
            Such is the terrifying majesty of this Ultimate Target! The Lord graciously promises: "I am now going to give you the ultimate 'Short-Cut' summary (Samgrahena) of exactly how to hack your way into that Supreme Dimension."
        """.trimIndent()
    ),
    Shloka(
        id = 12,
        sanskrit = """
            सर्वद्वाराणि संयम्य मनो हृदि निरुध्य च |
            मूर्ध्न्याधायात्मनः प्राणमास्थितो योगधारणाम् || १२ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 12 और 13 एक ही प्रक्रिया हैं)
            शरीर के सभी दरवाज़ों (इन्द्रियों) को पूरी तरह से बंद (कंट्रोल) करके (सर्वद्वाराणि संयम्य), अपने चंचल मन को अपने हृदय में पूरी तरह रोककर (मनो हृदि निरुध्य च)...
            और अपने प्राणों (जीवन शक्ति) को अपने मस्तक (सिर के सबसे ऊपरी हिस्से) में स्थापित करके (मूर्ध्न्याधायात्मनः प्राणम्), पूरी तरह से 'योग-धारणा' (समाधि की अवस्था) में दृढ़ता से स्थित होकर (आस्थितो)...
            भगवान अब पिछले श्लोक में किया गया अपना वादा पूरा कर रहे हैं और उस परम पद तक पहुँचने की एग्ज़ैक्ट टेक्निक (Exact Technique) बता रहे हैं (यह अष्टांग योग की सबसे भयंकर प्रक्रिया है)।
            १. 'सर्वद्वाराणि संयम्य': शरीर में नौ (9) छेद (दरवाजे) हैं (आँखें, कान, नाक आदि)। बाहर की दुनिया इन्हीं दरवाजों से अंदर आती है। योगी को सबसे पहले एक लोहे के शटर (Shutter) की तरह अपनी सभी इन्द्रियों को बाहरी दुनिया से 100% 'लॉक' (Lock / संयम्य) कर देना होता है। कुछ भी देखना, सुनना या महसूस करना बंद!
            २. 'मनो हृदि निरुध्य': दरवाजे बंद करने के बाद, जो मन अंदर उछल-कूद कर रहा है, उसे खींचकर अपने हृदय (Heart/आत्मा के स्थान) में एक कैदी की तरह 'कैद' (निरुद्ध / Block) कर दो।
            ३. 'मूर्ध्न्याधायात्मनः प्राणम्': फिर अपनी सांसों (प्राणों) और चेतना को नीचे से ऊपर की तरफ खींचो और उसे अपने सिर के बिल्कुल टॉप (Top/सहस्रार चक्र) पर ले जाकर फिक्स (Fix) कर दो।
            जब इंसान अपने शरीर और मन को इस तरह से 100% हैक (Hack) और फ्रीज़ (Freeze) कर लेता है, तो वह 'योग-धारणा' (Ultimate Trance) में पहुँच जाता है। आगे क्या होता है? अगले श्लोक में देखिए।
        """.trimIndent(),
        english = """
            (Verses 12 and 13 form a continuous process)
            The yogic situation is achieved by completely shutting all the doors of the physical senses (Sarva-dvarani samyamya), violently locking and confining the restless mind exclusively within the heart (Mano hridi nirudhya cha)...
            and powerfully drawing and fixing the life-air to the absolute top of the head (Murdhny adhaya atmanah pranam). Thus, one becomes flawlessly and solidly established in the ultimate trance of yoga (Ashthito yoga-dharanam).
            The Lord is now fulfilling His massive promise from the previous verse, revealing the exact, hardcore, step-by-step 'Execution Technique' to hack into the supreme dimension (This is the most severe process of Ashtanga Yoga).
            1. 'Sarva-dvarani samyamya': The biological machine has exactly nine holes (doors) connecting it to the matrix (eyes, ears, etc.). The Yogi must first act like an iron blast-door, brutally locking down 100% of all sensory inputs. Zero seeing, zero hearing, zero feeling!
            2. 'Mano hridi nirudhya': Once the external blast-doors are sealed, the wildly flickering mind trapped inside must be violently arrested, dragged down, and permanently 'Imprisoned' (Nirudhya) inside the heart (the seat of the soul).
            3. 'Murdhny adhaya atmanah pranam': Then, the Yogi must forcefully pump and elevate his biological life-force (Prana) straight up from the lower chakras, locking it aggressively at the absolute peak crown of his skull (Sahasrara Chakra).
            When a human successfully executes this terrifying, 100% absolute 'System Override' and freezes his biological state, he enters 'Yoga-dharana' (The Ultimate Trance). What happens next? The climax is in the next verse.
        """.trimIndent()
    ),
    Shloka(
        id = 13,
        sanskrit = """
            ओमित्येकाक्षरं ब्रह्म व्याहरन्मामनुस्मरन् |
            यः प्रयाति त्यजन्देहं स याति परमां गतिम् || १३ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 12 के बाद)... इस प्रकार योग-धारणा में स्थित होकर, जो मनुष्य परम ब्रह्म के साक्षात् स्वरूप, 'ॐ' (ओम्) इस एक अक्षर (शब्द) का बार-बार उच्चारण (व्याहरन्) करता है...
            और साथ ही मेरा (श्रीकृष्ण का) निरंतर स्मरण (अनुस्मरन्) करते हुए अपने इस भौतिक शरीर को त्यागता है (त्यजन्देहं), वह मनुष्य निश्चित रूप से उस 'परम गति' (मोक्ष या ईश्वर के धाम) को प्राप्त हो जाता है (याति परमां गतिम्)।
            यह अष्टांग योग (मेडिटेशन) के द्वारा 'बॉडी को एग्जिट' (Exiting the Body) करने का फाइनल (Final) और अल्टीमेट (Ultimate) स्टेप है!
            जब योगी ने (पिछले श्लोक में) अपने सारे दरवाजे बंद कर लिए और प्राणों को सिर पर चढ़ा लिया, तो अंतिम क्षण में उसे क्या करना है?
            उसे अपनी ज़ुबान से या मन ही मन ब्रह्मांड के सबसे शक्तिशाली और मूल पासवर्ड (Master-Password) 'ॐ' (OM) का उच्चारण (व्याहरन्) करना है। 'ॐ' कोई साधारण शब्द नहीं है; यह 'ब्रह्म' (ईश्वर) का ही 'साउंड अवतार' (Sound Representation) है।
            लेकिन केवल 'ॐ' जपना काफी नहीं है! ॐ का जाप करते हुए उसके दिमाग में किसका विचार होना चाहिए? भगवान कहते हैं: "मामनुस्मरन्" (केवल और केवल 'मेरा' यानी श्रीकृष्ण का ही ध्यान होना चाहिए)।
            जब एक योगी 100% फोकस (Focus) के साथ ॐ का साउंड-वाइब्रेशन (Sound-vibration) और भगवान का चित्र (Image) अपने मन में रखकर अपनी आखिरी साँस छोड़ता है...
            तो वह सीधा इस भौतिक मैट्रिक्स (Physical Matrix) को तोड़कर 'परम गति' (The Ultimate Highest Destination / वैकुंठ) में प्रवेश कर जाता है, जहाँ से उसे वापस जन्म लेने की कोई जरूरत नहीं पड़ती।
        """.trimIndent(),
        english = """
            (Continuing from Verse 12)... Situated in this absolute yogic trance, one who vibrates and continually chants the supreme syllable of Brahman, 'OM' (Om ity ekaksharam brahma vyaharan)...
            and while exclusively, intensely remembering Me, the Supreme Personality of Godhead (Mam anusmaran), violently quits his physical body (Yah prayati tyajan deham), he undeniably and instantly achieves the absolute supreme destination (Sa yati paramam gatim).
            This is the absolute, explosive 'Final Step' of forcefully 'Exiting the Biological Machine' through elite Ashtanga Yoga!
            Once the Yogi has successfully locked down all sensory doors and pushed his life-force to the skull (in the previous verse), what must he execute in the final microsecond of life?
            He must actively vibrate or mentally chant the universe's ultimate, most terrifyingly powerful 'Master-Password'—'OM'. The syllable 'OM' is absolutely not a random word; it is the literal 'Sound-Avatar' (vibrational representation) of the Supreme Brahman.
            But merely chanting 'OM' is incomplete! While vibrating OM, what exact image must dominate his brain? The Lord commands: "Mam anusmaran" (He must be exclusively, intensely, and 100% laser-focused on remembering ME, the Supreme Lord).
            When a Yogi flawlessly combines the raw cosmic frequency of 'OM' with the absolute visualization of God, and uses that immense power to eject his soul from the rotting physical body...
            He violently shatters the material matrix and is instantly uploaded into the 'Paramam Gatim' (The Absolute Highest Destination / Vaikuntha), guaranteeing he will never respawn in this miserable world again.
        """.trimIndent()
    ),
    Shloka(
        id = 14,
        sanskrit = """
            अनन्यचेताः सततं यो मां स्मरति नित्यशः |
            तस्याहं सुलभः पार्थ नित्ययुक्तस्य योगिनः || १४ ||
        """.trimIndent(),
        hindi = """
            हे पार्थ! जो मनुष्य बिना किसी दूसरे विचार के (अनन्यचेताः / 100% सिंगल माइंडेड होकर), मुझे हमेशा (सततम्) और रोज़ाना (नित्यशः) निरंतर याद (स्मरण) करता रहता है...
            उस हमेशा मुझमें ही लगे रहने वाले (नित्ययुक्तस्य) भक्त (योगी) के लिए मैं बहुत ही आसानी से प्राप्त होने वाला (सुलभः) हूँ।
            पिछले 2-3 श्लोकों में भगवान ने 'अष्टांग योग' (सांसों को रोकना, प्राणों को सिर पर चढ़ाना) का जो भयंकर और मुश्किल तरीका बताया था, उसे सुनकर कोई भी आम इंसान डर सकता है कि "यह तो मेरे बस की बात ही नहीं है! क्या मैं कभी भगवान को नहीं पा सकूँगा?"
            भगवान श्रीकृष्ण यहाँ अपने भक्तों के लिए दुनिया का सबसे बड़ा 'डिस्काउंट' (Discount) और सबसे आसान 'शॉर्टकट' (Shortcut) दे रहे हैं—'भक्तियोग' (Bhakti Yoga)।
            वे कहते हैं कि तुम्हें अपनी सांसों को रोकने (प्राणायाम) या हिमालय जाने की कोई ज़रूरत नहीं है!
            शर्त सिर्फ इतनी है: "अनन्यचेताः सततम्"—तुम्हारा दिमाग 'अनन्य' होना चाहिए, यानी भगवान के सिवा कोई 'प्लान बी' (Plan B / पैसा, जन्नत, स्वर्ग) नहीं होना चाहिए। तुम ऑफिस में हो, गाड़ी चला रहे हो, या खाना खा रहे हो, बस मुझे 24/7 (नित्यशः) प्यार से याद करते रहो।
            जो भक्त इस तरह प्यार से दिन-रात मेरा नाम लेता है ('नित्ययुक्त'), उसके लिए मुझे पाना 'सुलभ' (Su-labha / Extremely Easy) हो जाता है।
            बड़े-बड़े तपस्वियों को भगवान को पाने के लिए जन्मों तक हड्डियों को गलाना पड़ता है, लेकिन एक सच्चे प्रेमी (भक्त) के लिए भगवान खुद दौड़कर बहुत 'आसानी' से आ जाते हैं।
        """.trimIndent(),
        english = """
            O son of Pritha (Partha)! For one who always, continuously remembers Me without deviation or single separate thought (Ananya-chetah satatam yo mam smarati nityashah)...
            I am exceptionally, incredibly easy to obtain (Tasyaham su-labhah), precisely because of his constant, unyielding engagement in My pure devotional service (Nitya-yuktasya yoginah).
            In the preceding verses, the Lord described the terrifying, impossibly difficult, hardcore mechanical process of 'Ashtanga Yoga' (paralyzing the breath, forcing the life-air to the skull). Hearing this, any normal human would panic: "This is biologically impossible for me! Will I never attain God?"
            Lord Sri Krishna instantly drops the universe's most massive 'Discount' and the ultimate, easiest 'Cheat-Code' exclusively for His devotees—'Bhakti Yoga' (Pure Devotion).
            He declares: You absolutely do not need to violently stop your breath or freeze in a Himalayan cave!
            There is only one strict condition: "Ananya-chetah satatam"—Your brain must be 'Un-deviating'. You must hold absolutely zero 'Plan B' (no toxic desires for wealth or heaven). Whether you are typing in an office, driving a car, or eating, just continuously, lovingly run My remembrance 24/7 (Nityashah) in the background of your mind.
            For a devotee who permanently plugs his consciousness into Me through pure love ('Nitya-yukta'), I make Myself 'Su-labhah' (Staggeringly, Exceptionally Easy to acquire).
            While hardcore ascetics violently torture their bodies for lifetimes trying to force their way to God, the Supreme Lord Himself rushes effortlessly and easily to embrace a pure, loving devotee.
        """.trimIndent()
    ),
    Shloka(
        id = 15,
        sanskrit = """
            मामुपेत्य पुनर्जन्म दुःखालयमशाश्वतम् |
            नाप्नुवन्ति महात्मानः संसिद्धिं परमां गताः || १५ ||
        """.trimIndent(),
        hindi = """
            मुझे प्राप्त कर लेने के बाद (मामुपेत्य), वे महान आत्माएं (महात्मानः) जो योग की सर्वोच्च पूर्णता (संसिद्धिं परमां) को प्राप्त कर चुकी हैं...
            वे इस संसार में, जो कि दुःखों का घर (दुःखालयम्) है और पूरी तरह से नाशवान (अशाश्वतम्) है, कभी भी दोबारा जन्म (पुनर्जन्म) नहीं लेती हैं (नाप्नुवन्ति)।
            यह भगवद्गीता का सबसे 'ब्रूटली ऑनेस्ट' (Brutally Honest / कड़वा सच बताने वाला) और दुनिया की वास्तविकता (Reality) को डिकोड (Decode) करने वाला श्लोक है।
            हम इंसान सोचते हैं कि "यह दुनिया बहुत खूबसूरत है, अगर मेरे पास बहुत पैसा और एक अच्छा घर आ जाए तो मैं यहाँ हमेशा के लिए खुश रहूँगा।"
            भगवान इस दुनिया का जो 'सर्टिफिकेट' (Certificate) देते हैं, वह हमारी सोच से बिल्कुल उल्टा है! भगवान इस दुनिया को दो 'टाइटल' (Titles) देते हैं:
            १. 'दुःखालयम्' (The House of Misery): जैसे 'पुस्तकालय' में किताबें होती हैं, वैसे ही इस भौतिक दुनिया (धरती) का 'डिफॉल्ट नेचर' (Default Nature) ही दुःख, बीमारियां और स्ट्रेस (Stress) है। यहाँ कोई परमानेंट खुश रह ही नहीं सकता।
            २. 'अशाश्वतम्' (Temporary): अगर आपको कोई सुख मिल भी जाए, तो वह 'अशाश्वत' है; यानी वह एक दिन (मौत या समय के साथ) 100% आपसे छिन जाएगा और आपको रुलाएगा।
            भगवान कहते हैं कि जो 'महात्मा' (महान सिद्ध योगी) इस 'सिम्युलेशन' (Simulation/धोखे) को समझ जाते हैं, वे मुझे (ईश्वर को) प्राप्त कर लेते हैं। 
            और जो मुझे पा लेता है, वह इस नर्क जैसी, दुःखों से भरी और टेंपरेरी दुनिया ('दुःखालयमशाश्वतम्') में दोबारा कभी जन्म लेने की मूर्खता नहीं करता। उसका 'पुनर्जन्म' हमेशा के लिए कैंसिल (Cancel) हो जाता है।
        """.trimIndent(),
        english = """
            After having flawlessly attained Me (Mam upetya), the great, enlightened souls (Mahatmanah), being situated in the absolute highest perfection of life (Samsiddhim paramam gatah)...
            absolutely never again take birth (Punarjanma napnuvanti) in this material world, which is officially certified as a place full of miseries (Duhkhalayam) and completely temporary (Ashashvatam).
            This is undeniably the most 'Brutally Honest', matrix-shattering verse in the entire Bhagavad Gita, surgically decoding the dark, absolute reality of material existence.
            Ignorant mortals fiercely hallucinate: "This physical world is wonderfully beautiful; if I just acquire a billion dollars and a mansion, I will be eternally happy right here."
            The Supreme Creator violently shreds this pathetic illusion, officially issuing a horrifying 'Cosmic Certificate' to this material universe with two terrifying Titles:
            1. 'Duhkhalayam' (The Official House of Misery): Just as a library is a house of books, the fundamental, default operating system of this physical universe is purely designed to generate disease, anxiety, aging, and brutal suffering. Permanent happiness here is biologically impossible.
            2. 'Ashashvatam' (Strictly Temporary): Even if you accidentally extract a tiny drop of joy or wealth, it is 'Ashashvatam'; it has a strict expiration date. The unforgiving laws of Time and Death will 100% rip it away from you, leaving you in agonizing grief.
            The Lord declares that the elite 'Mahatmas' (Supreme Yogis) who crack this toxic simulation successfully attain ME.
            And once a soul reaches God's eternal dimension, it never, ever makes the horrific mistake of respawning (taking rebirth) back into this pathetic, rotting, temporary nightmare called the material world. Its cycle of suffering is permanently deleted.
        """.trimIndent()
    ),
    Shloka(
        id = 16,
        sanskrit = """
            आब्रह्मभुवनाल्लोकाः पुनरावर्तिनोऽर्जुन |
            मामुपेत्य तु कौन्तेय पुनर्जन्म न विद्यते || १६ ||
        """.trimIndent(),
        hindi = """
            हे अर्जुन! इस ब्रह्मांड के सबसे ऊँचे 'ब्रह्मलोक' (ब्रह्मा जी के लोक) से लेकर सबसे नीचे के लोक (पाताल) तक, सभी लोक ऐसे हैं जहाँ से जीवों को दोबारा लौटकर (धरती पर जन्म लेने) आना ही पड़ता है (पुनरावर्तिनः)।
            परंतु हे कुन्तीपुत्र! केवल मुझे (मेरे परम धाम/वैकुंठ) को प्राप्त कर लेने (मामुपेत्य) के बाद ही मनुष्य का कभी पुनर्जन्म (दोबारा जन्म) नहीं होता (पुनर्जन्म न विद्यते)।
            अर्जुन या कोई भी इंसान पूछ सकता है कि "अगर यह धरती दुःखों का घर है, तो मैं अच्छे कर्म करके 'स्वर्ग' (Heaven) या सबसे ऊँचे 'ब्रह्मलोक' चला जाऊंगा। वहाँ तो मज़ा ही मज़ा है!"
            भगवान श्रीकृष्ण इंसान की इस सबसे बड़ी 'फैंटेसी' (Fantasy / गलतफहमी) को तोड़ रहे हैं।
            वे कहते हैं कि तुम चाहे बहुत बड़े पुण्य करके इस ब्रह्मांड के सबसे 'प्रीमियम वीआईपी प्लैनेट' (Premium VIP Planet / ब्रह्मलोक) पर क्यों न चले जाओ, तुम्हारी वह जगह 'परमानेंट' (Permanent) नहीं है! 
            स्वर्ग या ब्रह्मलोक केवल एक फाइव-स्टार होटल (Five-star Hotel) की तरह हैं। जब तक तुम्हारे बैंक अकाउंट में 'पुण्य' (Pious Karma) का बैलेंस है, तुम वहाँ मज़े करोगे। जैसे ही बैलेंस ज़ीरो होगा, तुम्हें लात मारकर वापस इसी दुःखों से भरी धरती (मृत्युलोक) पर फेंक दिया जाएगा ('पुनरावर्तिनः')। ब्रह्मांड का कोई भी कोना सुरक्षित या हमेशा रहने वाला नहीं है।
            सुरक्षित (Safe) जगह केवल एक ही है—'भगवान का अपना घर' (वैकुंठ)। जो व्यक्ति पुण्य के बजाय 'भक्ति' करके सीधे मेरे पास (मामुपेत्य) आ जाता है, उसका 'वीज़ा' (Visa) कभी एक्सपायर (Expire) नहीं होता। उसका इस दुनिया में दोबारा जन्म लेना 100% कैंसिल हो जाता है।
        """.trimIndent(),
        english = """
            From the absolute highest planet in the material universe (Brahmaloka) down to the very lowest, all are simply places of misery wherein repeated birth and death take place (Punar-avartinah), O Arjuna.
            But O son of Kunti, one who flawlessly attains My supreme abode (Mam upetya) absolutely never, ever takes birth again (Punarjanma na vidyate).
            An ignorant human might logically argue: "If this earth is a toxic house of misery, I will simply execute massive pious acts and relocate to 'Heaven' or the highest celestial planet 'Brahmaloka'. Surely, I will be safe and enjoy eternally there!"
            Lord Sri Krishna violently shatters this ultimate human 'Fantasy' and cosmic misconception here.
            He declares that even if you accumulate staggering amounts of pious karma and successfully immigrate to the absolute highest 'Premium VIP Planet' in the universe (Brahmaloka), your stay is absolutely NOT 'Permanent'!
            Heaven and Brahmaloka operate exactly like ultra-expensive Five-Star Hotels. As long as your karmic bank account holds a massive balance of 'Punya' (Pious credits), you enjoy celestial luxuries. But the exact microsecond your balance hits Zero, you are ruthlessly evicted and violently thrown right back down into this miserable earthly matrix ('Punar-avartinah'). Absolutely no corner of this material universe is safe or eternal.
            There is exactly ONE 'Absolute Safe Zone'—God's Personal Headquarters (Vaikuntha). A devotee who bypasses karma, executes pure Bhakti, and comes directly to ME (Mam upetya) receives an Eternal, Infinite 'Visa' that never expires. His forced reincarnation into this miserable matrix is permanently canceled 100%.
        """.trimIndent()
    ),
    Shloka(
        id = 17,
        sanskrit = """
            सहस्रयुगपर्यन्तमहर्यद्ब्रह्मणो विदुः |
            रात्रिं युगसहस्रान्तां तेऽहोरात्रविदो जनाः || १७ ||
        """.trimIndent(),
        hindi = """
            जो मनुष्य यह अच्छी तरह जानते हैं (विदुः) कि ब्रह्मा जी का एक दिन (अहर्) 'एक हजार चतुर्युगों' (सहस्रयुगपर्यन्तम्) के बराबर होता है...
            और ब्रह्मा जी की एक रात (रात्रिं) भी 'एक हजार चतुर्युगों' (युगसहस्रान्तां) तक चलने वाली होती है; वास्तव में वे ही लोग 'दिन और रात' के असली रहस्य को जानने वाले (अहोरात्रविदः) हैं।
            यह श्लोक 'कॉस्मिक टाइम-स्केल' (Cosmic Time-scale / ब्रह्मांडीय समय की गणना) का सबसे दिमाग घुमा देने वाला (Mind-boggling) विज्ञान है।
            हम इंसान अपने 24 घंटे के दिन और 100 साल की उम्र को बहुत बड़ा मानते हैं। भगवान हमारे इस 'घमंड' को ब्रह्मांड के 'क्रिएटर' (ब्रह्मा जी) की उम्र बताकर तोड़ रहे हैं।
            एक 'चतुर्युग' (सतयुग, त्रेता, द्वापर और कलियुग मिलाकर) में 43 लाख 20 हजार (4.32 Million) मानवीय वर्ष होते हैं।
            श्रीकृष्ण बताते हैं कि जब ऐसे 'एक हज़ार' चतुर्युग (यानी 4 अरब 32 करोड़ / 4.32 Billion वर्ष) बीत जाते हैं, तब जाकर ब्रह्मा जी का सिर्फ 'एक दिन' (Day/सुबह से शाम) पूरा होता है!
            और उनकी 'एक रात' भी 4.32 Billion वर्षों की होती है। (आधुनिक विज्ञान भी पृथ्वी की उम्र लगभग 4.5 अरब साल बताता है, जो ब्रह्मा के एक दिन के बराबर है!)
            जो 'योगी' समय की इस भयंकर और विशाल कैलकुलेशन (Calculation) को समझ लेता है, उसे समझ आ जाता है कि इंसान की 100 साल की ज़िंदगी ब्रह्मांड के लिए एक सेकंड (Microsecond) के बराबर भी नहीं है।
            तब इंसान का सारा घमंड और पैसे का लालच टूट जाता है, क्योंकि उसे पता चल जाता है कि यह दुनिया कितनी छोटी और 'टेंपरेरी' (Temporary) है। असली ज्ञानी ('अहोरात्रविदः') वही है जो इस महा-समय को समझता है।
        """.trimIndent(),
        english = """
            By absolute human calculation, a single thousand cycles of the four yugas strictly comprise just one day of Lord Brahma (Sahasra-yuga-paryantam ahar yad brahmano).
            And his single night also continues for exactly the same duration of one thousand yugas (Ratrim yuga-sahasrantam). Only those persons who perfectly know this staggering reality genuinely understand what 'Day and Night' actually mean (Te 'ho-ratra-vido janah).
            This spectacular verse drops the absolute most mind-boggling, terrifyingly vast 'Cosmic Time-Scale' (Vedic Cosmology) capable of completely shattering human comprehension.
            Arrogant humans foolishly consider their pathetic 24-hour day and tiny 100-year lifespan to be incredibly massive. The Lord brutally crushes this human ego by revealing the lifespan of the universe's chief engineer (Lord Brahma).
            One single 'Maha-Yuga' (the combined duration of Satya, Treta, Dvapara, and Kali yugas) equals exactly 4,320,000 (4.32 Million) earthly years.
            Sri Krishna reveals that when exactly 'One Thousand' such Maha-Yugas pass (which equals 4.32 BILLION human years), that merely constitutes just 'ONE 12-hour DAY' (morning to evening) in the life of Lord Brahma!
            And his 'One Night' lasts for another identical 4.32 Billion years. (Strikingly, modern astrophysics estimates the earth's age at roughly 4.5 billion years, mirroring a single day of Brahma!)
            An elite 'Yogi' who successfully processes this horrific, astronomical mathematical calculation instantly realizes that a 100-year human life is not even a microscopic fraction of a millisecond in the cosmic scheme.
            This realization instantly slaughters all human arrogance, billionaire greed, and toxic ego, proving how pathetically 'Temporary' this matrix is. The true master ('Aho-ratra-vidah') is the one who grasps this terrifying reality of Cosmic Time.
        """.trimIndent()
    ),
    Shloka(
        id = 18,
        sanskrit = """
            अव्यक्ताद्व्यक्तयः सर्वाः प्रभवन्त्यहरागमे |
            रात्र्यागमे प्रलीयन्ते तत्रैवाव्यक्तसञ्ज्ञके || १८ ||
        """.trimIndent(),
        hindi = """
            ब्रह्मा जी के 'दिन' की शुरुआत (अहरागमे) होते ही, सभी चराचर प्राणी और वस्तुएं (सर्वाः व्यक्तयः) उस 'अव्यक्त' (निराकार/Unmanifest) अवस्था से प्रकट (पैदा/प्रभवन्ति) हो जाते हैं।
            और जैसे ही ब्रह्मा जी की 'रात' (रात्र्यागमे) आती है, वे सभी प्राणी और यह पूरी सृष्टि वापस उसी 'अव्यक्त' नामक अवस्था में विलीन होकर नष्ट (प्रलीयन्ते) हो जाती है।
            पिछले श्लोक में भगवान ने ब्रह्मा जी का दिन और रात (4.32 बिलियन साल का) बताया था। अब भगवान बता रहे हैं कि उस दिन और रात में होता क्या है! यह सृष्टि के 'क्रिएशन और डिस्ट्रक्शन' (Creation and Destruction / बिग-बैंग और बिग-क्रंच) का विज्ञान है।
            १. 'अहरागमे' (दिन की शुरुआत / Big Bang): जब ब्रह्मा जी जागते हैं (उनका दिन शुरू होता है), तो जो कुछ भी 'अव्यक्त' (छुपा हुआ / Energy form) था, वह 'व्यक्त' (Physical form) हो जाता है। सारे ग्रह, इंसान, जानवर, पहाड़ अचानक प्रकट हो जाते हैं और अपनी जिंदगी जीने लगते हैं।
            २. 'रात्र्यागमे' (रात की शुरुआत / Big Crunch): 4.32 बिलियन साल बाद जब ब्रह्मा जी सो जाते हैं (उनकी रात होती है), तो एक भयंकर प्रलय (Destruction) आता है।
            इस प्रलय में यह पूरी की पूरी भौतिक दुनिया (शहर, इंसान, तारे) पूरी तरह नष्ट (प्रलीयन्ते) हो जाती है और वापस उसी डार्क-एनर्जी (Dark Energy / 'अव्यक्त') में समा कर अदृश्य हो जाती है।
            यानी यह दुनिया कोई परमानेंट जगह नहीं है; यह रोज़ (ब्रह्मा के दिन में) बनती है और रोज़ (ब्रह्मा की रात में) मिट जाती है। यह एक कभी न खत्म होने वाला लूप (Loop) है।
        """.trimIndent(),
        english = """
            At the exact beginning of Brahma's day (Ahar-agame), absolutely all living entities and material manifestations become completely manifest and spring forth from the unmanifest state (Avyaktad vyaktayah sarvah prabhavanti).
            And exactly at the arrival of Brahma's night (Ratry-agame), all these manifestations are completely annihilated and merge entirely back into the exact same unmanifest state (Praliyante tatraivavyakta-sanjnake).
            In the previous verse, the Lord established Brahma's staggering 4.32 billion-year day and night. Now, He brilliantly explains exactly what violent cosmic events occur during that cycle! This is the ultimate Vedic science of 'Creation and Annihilation' (The Big Bang and Big Crunch).
            1. 'Ahar-agame' (The Dawn of Brahma's Day / The Big Bang): The exact microsecond Lord Brahma wakes up, absolutely everything that was stored in an invisible, dormant energy state ('Avyakta' / Unmanifest) aggressively explodes into physical 'Vyakta' (Manifest) forms. Galaxies, stars, mountains, and billions of living entities suddenly pop into biological existence and begin their timeline.
            2. 'Ratry-agame' (The Dawn of Brahma's Night / The Big Crunch): After 4.32 Billion years, when Brahma goes to sleep, a terrifying, massive, universal annihilation (Pralaya) triggers.
            During this horrific doomsday, this entire physical matrix (cities, humans, solar systems) is brutally dissolved and violently collapses back into that exact same invisible, dormant 'Dark Energy' state ('Avyakta').
            Meaning: This universe is absolutely NOT a permanent structure; it is biologically assembled every single morning (Brahma's day) and violently annihilated every single night. It is a terrifying, inescapable cosmic Loop.
        """.trimIndent()
    ),
    Shloka(
        id = 19,
        sanskrit = """
            भूतग्रामः स एवायं भूत्वा भूत्वा प्रलीयते |
            रात्र्यागमेऽवशः पार्थ प्रभवत्यहरागमे || १९ ||
        """.trimIndent(),
        hindi = """
            हे पार्थ (अर्जुन)! प्राणियों का वही यह विशाल समूह (भूतग्रामः), जो बार-बार जन्म लेता है (भूत्वा भूत्वा), वह प्रकृति के नियमों के सामने पूरी तरह विवश (मजबूर/अवशः) होकर...
            ब्रह्मा की रात आने पर (रात्र्यागमे) अपने-आप नष्ट (प्रलीयते) हो जाता है, और फिर ब्रह्मा का दिन आने पर (अहरागमे) वह विवश होकर दोबारा प्रकट (पैदा/प्रभवति) हो जाता है।
            यह श्लोक इंसान की 'फ्री विल' (Free Will / आज़ादी) के अहंकार को पूरी तरह से चकनाचूर कर देता है।
            हम इंसान सोचते हैं कि हम अपनी ज़िंदगी के 'मास्टर' (Master) हैं; हम जो चाहें कर सकते हैं। लेकिन श्रीकृष्ण एक बहुत ही डरावनी हकीकत (Harsh Reality) बताते हैं।
            वे कहते हैं कि जीवों का यह जो पूरा झुंड ('भूतग्रामः' / इंसान, जानवर आदि) है, यह प्रकृति की एक मशीन में फँसा हुआ है।
            हम सब 'अवशः' (Helpless / पूरी तरह से मजबूर) हैं! जब ब्रह्मा का दिन होता है, तो हमें जबरदस्ती भौतिक शरीर दे दिया जाता है और हम दुनिया में दौड़ने लगते हैं।
            और जब ब्रह्मा की रात होती है, तो हमारी सारी दौलत, अहंकार और शरीर को बलपूर्वक (without our permission) मिटाकर हमें डार्कनेस (Darkness / प्रलय) में फेंक दिया जाता है।
            "भूत्वा भूत्वा प्रलीयते"—यह जन्म लेने और मरने का भयंकर चक्र करोड़ों-अरबों बार चल चुका है और आगे भी चलता रहेगा। हम इस मशीन के अंदर फँसे हुए पूरी तरह 'बेबस' (Helpless) कीड़े-मकोड़ों की तरह हैं।
            इस भयंकर लूप (Loop) से बाहर निकलने का एकमात्र रास्ता वह है जो भगवान अगले श्लोक में बताने जा रहे हैं।
        """.trimIndent(),
        english = """
            Again and again, whenever Brahma's day arrives, this exact same vast multitude of living entities (Bhuta-gramah) repeatedly comes into physical being (Bhutva bhutva)...
            and upon the arrival of Brahma's night (Ratry-agame), they are all helplessly, forcefully annihilated (Praliyate avashah), O Partha, only to manifest and be created yet again when the next day arrives (Prabhavaty ahar-agame).
            This terrifying verse violently shatters and completely crushes the arrogant human illusion of 'Free Will' and absolute independence.
            We ignorant mortals heavily hallucinate that we are the 'Masters' of our own destiny; that we control our lives and properties. But Sri Krishna exposes a deeply horrifying cosmic reality.
            He declares that this entire massive swarm of billions of living entities ('Bhuta-gramah' / humans, animals, demigods) is hopelessly trapped inside an inescapable, mechanical cosmic meat-grinder.
            We are all entirely 'Avashah' (100% Helpless and Powerless)! When Brahma's day begins, we are forcefully shoved into biological bodies without our permission, forced to run the rat race.
            And when Brahma's night triggers, our massive bank accounts, huge egos, and physical bodies are brutally and automatically vaporized (Pralaya), throwing us violently back into dormant darkness.
            "Bhutva bhutva praliyate"—This horrific, repetitive cycle of being forcefully born and violently slaughtered has occurred billions of times and will relentlessly continue forever. Inside this Matrix, we are as totally 'Helpless' as pathetic insects.
            The absolute, solitary exit door to hack and escape this terrifying Loop is exactly what the Lord reveals in the very next verse.
        """.trimIndent()
    ),
    Shloka(
        id = 20,
        sanskrit = """
            परस्तस्मात्तु भावोऽन्योऽव्यक्तोऽव्यक्तात्सनातनः |
            यः स सर्वेषु भूतेषु नश्यत्सु न विनश्यति || २० ||
        """.trimIndent(),
        hindi = """
            परंतु इस 'अव्यक्त' (प्रकृति/डार्क एनर्जी जहाँ सृष्टि मिट जाती है) से भी बहुत परे (परः), एक अन्य (दूसरा / अन्यो), कभी न दिखने वाला (अव्यक्तो) और सनातन (हमेशा रहने वाला / सनातनः) ईश्वरीय 'भाव' (अस्तित्व/स्थान) है।
            वह परम स्थान ऐसा है कि जब ब्रह्मा के लोक सहित सभी प्राणियों और लोकों का पूरी तरह विनाश (नश्यत्सु) हो जाता है, तब भी उस परम धाम का कभी विनाश नहीं होता (न विनश्यति)।
            पिछले श्लोक के डरावने सच (प्रलय) को बताने के बाद, भगवान अब इस ब्रह्मांड से बाहर निकलने का 'एग्ज़िट डोर' (Exit Door) और सबसे बड़ा रहस्य खोल रहे हैं।
            ब्रह्मा की रात में जो प्रलय होता है, उसमें सारा भौतिक ब्रह्मांड (Material Universe) 'अव्यक्त' (Invisible energy) में बदल जाता है। इंसान सोचता है कि शायद यही ब्रह्मांड का 'एंड' (End) है।
            लेकिन श्रीकृष्ण एक 'सुपर-डायमेंशन' (Super-Dimension) की बात करते हैं: "परस्तस्मात्"—उस भौतिक 'अव्यक्त' अंधेरे के भी बहुत ऊपर (Beyond), एक दूसरी (अन्य) दुनिया (Spiritual World) मौजूद है।
            वह दुनिया 'सनातन' (Eternal) है। वह न कभी बनती है, न कभी मिटती है।
            जब ब्रह्मा का दिन खत्म होता है और सारे ग्रह, गैलेक्सी (Galaxies), तारे और जीव-जंतु प्रलय में पूरी तरह नष्ट ('नश्यत्सु') हो जाते हैं...
            तब भी वह ईश्वरीय स्थान (भगवान का वैकुंठ धाम) अपनी जगह पर 100% सुरक्षित और वैसा का वैसा ही खड़ा रहता है ('न विनश्यति')। उस दुनिया पर समय (Time) या प्रलय (Doomsday) का कोई असर नहीं होता। वह स्थान भगवान का असली 'घर' है।
        """.trimIndent(),
        english = """
            Yet there is another, entirely unmanifest nature and distinct dimension (Bhavo 'nyo 'vyaktah), which is completely eternal (Sanatanah) and is situated infinitely far beyond (Paras tasmat) this material unmanifested state.
            That supreme, absolute destiny and spiritual realm absolutely never perishes (Na vinashyati), even when all living entities and this entire material universe are completely annihilated (Sarveshu bhuteshu nashyatsu).
            After terrifyingly establishing the brutal reality of cosmic annihilation (Pralaya) in the previous verse, the Lord now brilliantly rips open the ultimate 'Exit Door' and reveals the greatest, highly classified secret beyond the Matrix.
            During Brahma's night, the entire physical universe violently collapses into a dark, invisible energy state (Material 'Avyakta'). Ignorant scientists assume this dark void is the absolute 'End' of existence.
            But Sri Krishna introduces a staggering 'Super-Dimension': "Paras tasmat"—Existing infinitely, infinitely far 'Beyond' that physical dark matter, there exists an entirely different, 'Anti-Material' (Spiritual) World.
            That dimension is strictly 'Sanatanah' (Eternal). It was never biologically created, and it can never be physically destroyed.
            When the cosmic timer hits zero, and every single galaxy, star, black hole, and living entity is violently vaporized and completely annihilated ('Nashyatsu') during the universal Doomsday...
            That transcendental dimension (Vaikuntha / The Kingdom of God) remains 100% perfectly intact, untouched, and utterly indestructible ('Na vinashyati'). The destructive force of Time itself has absolute zero access to that realm. That is God's ultimate 'Home'.
        """.trimIndent()
    ),
    Shloka(
        id = 21,
        sanskrit = """
            अव्यक्तोऽक्षर इत्युक्तस्तमाहुः परमां गतिम् |
            यं प्राप्य न निवर्तन्ते तद्धाम परमं मम || २१ ||
        """.trimIndent(),
        hindi = """
            जिसे वेदों में 'अव्यक्त' (जो इन्द्रियों से न दिखे) और 'अक्षर' (जिसका कभी विनाश न हो) कहा गया है, तथा उसी स्थान को ज्ञानी लोग 'परम गति' (सबसे ऊँचा लक्ष्य) कहते हैं...
            जिस परम स्थान को एक बार प्राप्त कर लेने के बाद (यं प्राप्य), जीव वापस इस दुःखों से भरे संसार में कभी लौटकर नहीं आता (न निवर्तन्ते), वही (तद्) मेरा 'परम धाम' (मेरा असली घर / Supreme Abode) है।
            भगवान श्रीकृष्ण यहाँ अपने उस 'सनातन घर' (वैकुंठ/गोलोक) का सटीक एड्रेस (Exact Address/Description) और उसकी सबसे बड़ी खासियत (Specialty) बता रहे हैं।
            वेदों के बड़े-बड़े साइंटिस्ट (ऋषि) उस जगह को 'अक्षर' (Indestructible - जो प्रलय में भी नहीं टूटता) कहते हैं। इसे हमारी इन भौतिक आँखों या टेलिस्कोप (Telescope) से नहीं देखा जा सकता (इसलिए यह 'अव्यक्त' है)।
            यह आत्मा की यात्रा का अंतिम और सबसे बड़ा 'स्टॉप' (Destination / परम गति) है। इसके ऊपर जाने के लिए और कुछ नहीं है।
            और उस जगह की सबसे बड़ी गारंटी (Guarantee) क्या है? 
            "यं प्राप्य न निवर्तन्ते"—दुनिया में आप चाहे स्वर्ग जाएं, अमेरिका जाएं, या किसी बड़े पद पर जाएं, आपको एक दिन वहाँ से वापस लौटना (गिरना) पड़ता है।
            लेकिन अगर कोई इंसान भक्ति के द्वारा भगवान के उस 'परम धाम' (Supreme Abode) में एक बार 'एंट्री' (Entry) मार ले, तो उसका इस 3D मैट्रिक्स (जन्म-मरण और दुःख के संसार) से हमेशा के लिए कनेक्शन कट जाता है। उसे कभी भी वापस धरती पर जन्म लेने नहीं आना पड़ता (न निवर्तन्ते)।
        """.trimIndent(),
        english = """
            That supreme destination which the Vedantists describe as completely unmanifest and absolutely infallible (Avyakto 'kshara), that which is officially known as the ultimate, supreme destination (Paramam gatim)...
            and that exact place from which, having once successfully attained it, a soul absolutely never, ever returns to this material world (Yam prapya na nivartante)—that specific dimension is My supreme, absolute eternal abode (Tad dhama paramam mama).
            Lord Sri Krishna is exclusively revealing the exact coordinates, description, and the ultimate, staggering 'Specialty' of His own personal 'Eternal Headquarters' (Vaikuntha/Goloka).
            The most elite, hardcore scientists of the Vedas officially classify that specific dimension as 'Akshara' (The Absolute Indestructible—a realm that survives even the violent collapse of the multiverse). It is completely invisible to our primitive biological eyes and the most powerful space telescopes (thus, 'Avyakta').
            It is the absolute final, ultimate 'Stop' for the soul's journey (Paramam gatim). There is absolutely nothing higher or beyond it in existence.
            And what is the ultimate, massive Cosmic Guarantee of this place?
            "Yam prapya na nivartante"—In this material matrix, whether you immigrate to America, become a billionaire CEO, or even reach the celestial Heaven, you are 100% mathematically guaranteed to eventually fall back down (return) one day.
            But if a human soul successfully executes pure devotion and secures 'Entry' into the Lord's 'Supreme Abode' (Paramam Dhama) even once, his connection to this toxic 3D matrix (the cycle of birth, disease, and death) is permanently and violently severed. He absolutely never, ever respawns or returns to this miserable earth again (Na nivartante).
        """.trimIndent()
    ),
    Shloka(
        id = 22,
        sanskrit = """
            पुरुषः स परः पार्थ भक्त्या लभ्यस्त्वनन्यया |
            यस्यान्तःस्थानि भूतानि येन सर्वमिदं ततम् || २२ ||
        """.trimIndent(),
        hindi = """
            हे पार्थ (अर्जुन)! जिस परमेश्वर के भीतर (अंतः) यह संपूर्ण प्राणी (सारा ब्रह्मांड) स्थित हैं, और जिस परमेश्वर के द्वारा यह पूरा चराचर जगत 'व्याप्त' (पूरी तरह से भरा हुआ / Pervaded) है...
            वह सबसे महान और 'परम पुरुष' (परमात्मा / स परः पुरुषः) केवल और केवल 'अनन्य भक्ति' (100% बिना किसी स्वार्थ के शुद्ध प्रेम / भक्त्या अनन्यया) के द्वारा ही प्राप्त (लभ्यः) किया जा सकता है।
            भगवान श्रीकृष्ण यहाँ उस 'परम धाम' तक पहुँचने का एकमात्र 'वीज़ा' (Visa/पासवर्ड) बता रहे हैं।
            सबसे पहले भगवान अपनी विराट सत्ता (Cosmic magnitude) बताते हैं: 
            १. "यस्यान्तःस्थानि भूतानि"—ये सारे ग्रह, तारे और करोड़ों जीव कहाँ रहते हैं? वे सब उस 'परम पुरुष' (भगवान) के शरीर के अंदर एक छोटे से हिस्से में स्थित हैं।
            २. "येन सर्वमिदं ततम्"—और वह भगवान इतना विशाल है कि वह इस पूरे ब्रह्मांड के ज़र्रे-ज़र्रे (कण-कण) में पूरी तरह से 'ततम्' (फैला हुआ/All-pervading) है।
            इतने विशाल, इतने डरावने और इतने महान 'ईश्वर' को एक छोटा सा इंसान कैसे पा सकता है? क्या बहुत सारा पैसा दान करके? या हिमालय में हज़ारों साल भूखे रहकर?
            भगवान इस सबका खंडन करते हुए एक बहुत ही सिंपल और पावरफुल शर्त (Condition) रखते हैं: "भक्त्या लभ्यस्त्वनन्यया" (मैं केवल अनन्य भक्ति से ही मिलता हूँ)।
            'अनन्य' का मतलब है No other focus (कोई दूसरा नहीं)। जब भक्त भगवान को छोड़कर किसी और देवी-देवता, पैसे, या मोक्ष की भी लालसा नहीं रखता, और केवल 'प्यार' (Love/भक्ति) के आंसू बहाता है, तो ब्रह्मांड का वह सबसे विशाल ईश्वर उस छोटे से भक्त का गुलाम बन जाता है और उसे बहुत आसानी से 'प्राप्त' (लभ्यः) हो जाता है।
        """.trimIndent(),
        english = """
            O son of Pritha (Partha)! The Supreme Personality of Godhead, who is greater than all (Purushah sa parah), within whom all living entities constantly exist (Yasyantah-sthani bhutani) and by whom this entire cosmic manifestation is thoroughly pervaded (Yena sarvam idam tatam)...
            can be achieved and successfully attained exclusively and strictly by unalloyed, 100% pure devotion and unmixed love alone (Bhaktya labhyas tv ananyaya).
            Lord Sri Krishna is dropping the absolute, exclusive 'Visa' (The Master-Password) required to hack into that Supreme Abode mentioned in the previous verse.
            First, the Lord establishes His staggering, terrifying Cosmic Magnitude:
            1. "Yasyantah-sthani bhutani"—Where exactly do these billions of galaxies, black holes, and living entities reside? They all float safely right inside a tiny fraction of the 'Supreme Person's' (God's) infinite body.
            2. "Yena sarvam idam tatam"—And that God is so unimaginably vast that He simultaneously physically and spiritually 'Pervades' (is omnipresent within) every single microscopic atom of this multiverse.
            How on earth can a tiny, pathetic mortal human ever possibly reach or conquer such a terrifyingly massive, infinite God? By donating billions to charity? By starving in a freezing Himalayan cave for 10,000 years?
            The Lord violently rejects all mechanical methods and lays down one staggeringly simple, yet immensely powerful Condition: "Bhaktya labhyas tv ananyaya" (I am obtainable strictly and exclusively through Unalloyed Devotion).
            'Ananya' profoundly means "Absolutely Zero Alternative Focus". When a devotee brutally rejects begging for money, heavenly pleasures, or even liberation, and simply weeps tears of pure, unadulterated 'Love' (Bhakti), that gigantic, infinite Creator of the cosmos happily becomes the submissive slave of that tiny devotee and is effortlessly 'Attained' (Labhyah).
        """.trimIndent()
    ),
    Shloka(
        id = 23,
        sanskrit = """
            यत्र काले त्वनावृत्तिमावृत्तिं चैव योगिनः |
            प्रयाता यान्ति तं कालं वक्ष्यामि भरतर्षभ || २३ ||
        """.trimIndent(),
        hindi = """
            हे भरतवंशियों में श्रेष्ठ (भरतर्षभ)! अब मैं तुम्हें उस विशेष 'काल' (समय / Time/Path) का वर्णन करूँगा, जिस काल में शरीर त्यागकर गए हुए (प्रयाता) योगियों को 'अनावृत्ति' (कभी वापस न लौटना / मोक्ष) प्राप्त होती है...
            और जिस काल में शरीर छोड़ने पर योगियों को 'आवृत्ति' (संसार में दोबारा जन्म लेने के लिए लौटना) प्राप्त होती है। मैं उन दोनों कालों (रास्तों) को तुम्हें बताऊँगा (तं कालं वक्ष्यामि)।
            यह श्लोक एक बहुत ही रहस्यमयी और गुप्त 'आध्यात्मिक विज्ञान' (Mystical Science of Death) की प्रस्तावना (Introduction) है। 
            भगवान श्रीकृष्ण यहाँ 'आत्मा की एग्ज़िट टाइमिंग' (Exit Timing of the Soul) के बारे में बताने जा रहे हैं।
            साधारण इंसान की मौत एक्सीडेंट (Accident) या बीमारी से अचानक होती है, उसे समय का कोई पता नहीं होता। लेकिन जो 'योगी' होते हैं, वे अपनी मौत (शरीर छोड़ने का समय) खुद चुनते हैं।
            भगवान अर्जुन को बता रहे हैं कि ब्रह्मांड में दो प्रकार के 'अदृश्य रास्ते' (Mystical Paths / काल) मौजूद हैं:
            १. 'अनावृत्ति' का रास्ता: अगर कोई सिद्ध योगी एक विशेष और शुभ समय (या प्रकाश के मार्ग) से शरीर छोड़ता है, तो वह सीधा भगवान के घर पहुँच जाता है और उसे दोबारा जन्म नहीं लेना पड़ता (No return)।
            २. 'आवृत्ति' का रास्ता: लेकिन अगर कोई योगी (जिसने पूर्ण सिद्धि नहीं पाई है) दूसरे अशुभ समय (या अंधकार के मार्ग) से शरीर छोड़ता है, तो वह स्वर्ग जाकर कुछ दिन मजे करता है, लेकिन उसे फिर से धरती पर जन्म लेने के लिए 'वापस' (Return) आना पड़ता है।
            श्रीकृष्ण अब अगले श्लोकों में इन दोनों 'रास्तों' (रूट मैप / Route Map) का बिल्कुल स्पष्ट रहस्य खोलने जा रहे हैं।
        """.trimIndent(),
        english = """
            O best of the Bharatas (Bharatarshabha)! I shall now explicitly explain to you the different specific times and mystical paths (Kalam vakshyami) at which passing away from this world...
            the great mystic yogis (Yoginah prayata) either achieve absolute liberation with no return (Anavrittim) or are forced to return to this material world to take rebirth (Avrittim chaiva).
            This verse serves as the staggering introduction to an extremely classified, deeply mystical 'Spiritual Science of Death' and cosmic navigation.
            Lord Sri Krishna is preparing to decode the absolute 'Exit Timings and Departure Routes of the Soul'.
            An ordinary, ignorant mortal dies violently and suddenly through disease or a random accident; he has absolutely zero control over his departure time. But highly elite 'Yogis' consciously and surgically select their exact moment of death.
            The Lord informs Arjuna that there are exactly two specific 'Invisible Mystical Routes' (Kalam) hardwired into the cosmos:
            1. The Path of 'Anavrittim' (No Return): If a perfected Yogi ejects his soul from the biological body during a highly specific, auspicious cosmic window (the path of light), his soul shoots straight past the matrix into God's eternal kingdom, permanently guaranteeing 'No Return' (Moksha).
            2. The Path of 'Avrittim' (Return): However, if a Yogi (who has not achieved 100% absolute perfection) exits the body during a different, inauspicious cosmic window (the path of darkness), he travels to the heavenly planets, enjoys temporarily, but is forcefully booted back down to earth to take 'Rebirth' (Return).
            Sri Krishna is now about to brutally expose the exact, highly classified 'Route Maps' for these two specific paths in the upcoming verses.
        """.trimIndent()
    ),
    Shloka(
        id = 24,
        sanskrit = """
            अग्निर्ज्योतिरहः शुक्लः षण्मासा उत्तरायणम् |
            तत्र प्रयाता गच्छन्ति ब्रह्म ब्रह्मविदो जनाः || २४ ||
        """.trimIndent(),
        hindi = """
            जिस मार्ग में 'अग्नि' (आग) का प्रकाश है, 'ज्योति' (रोशनी) है, 'दिन' (अहः) का समय है, 'शुक्ल पक्ष' (चाँदनी रात वाले 15 दिन) का समय है, और सूर्य के 'उत्तरायण' (उत्तरी दिशा में जाने वाले) छह महीने (षण्मासा) का समय है...
            उस प्रकाशमय मार्ग (शुभ काल) से शरीर त्यागकर गए हुए (तत्र प्रयाता) परब्रह्म को जानने वाले (ब्रह्मविदो) योगी जन सीधे 'ब्रह्म' (परमात्मा) को प्राप्त होते हैं (मोक्ष पा लेते हैं)।
            यह 'अनावृत्ति' (No Return / मोक्ष) के रास्ते का 'रूट मैप' (Route Map) है, जिसे शास्त्रों में 'देवयान मार्ग' (Path of Light) कहा जाता है।
            भगवान श्रीकृष्ण यहाँ समय के कुछ विशेष देवताओं (Deities of Time) का ज़िक्र कर रहे हैं। अग्नि, दिन, शुक्ल पक्ष और उत्तरायण—ये केवल समय या मौसम नहीं हैं, ये ब्रह्मांड के वो देवता (Guides) हैं जो आत्मा को गाइड करके ऊपर ले जाते हैं।
            इस पूरे श्लोक में एक कॉमन थीम (Common Theme) है: 'प्रकाश' (Light/रोशनी)। अग्नि में रोशनी है, दिन में रोशनी है, शुक्ल पक्ष (जब चाँद बढ़ता है) में रोशनी है, और उत्तरायण (जब सूर्य उत्तर में होता है और दिन बड़े होते हैं) में बहुत रोशनी होती है।
            रोशनी 'ज्ञान' और 'चेतना' (Consciousness) का प्रतीक है।
            जो 'ब्रह्मवित्' (ईश्वर को जानने वाला सच्चा ज्ञानी) योगी है, वह अपनी इच्छा से शरीर छोड़ने के लिए इसी 'प्रकाश वाले समय' को चुनता है (जैसे भीष्म पितामह ने बाणों की शय्या पर उत्तरायण का इंतज़ार किया था)।
            जब योगी इस 'लाइट' (Light) के रास्ते से अपनी आत्मा को शरीर से बाहर निकालता है, तो ये सभी प्रकाश के देवता उसे 'एस्कॉर्ट' (Escort / सम्मान के साथ) करके सीधे भगवान के परम धाम (ब्रह्म) तक छोड़ देते हैं, जहाँ से वह कभी लौटकर नहीं आता।
        """.trimIndent(),
        english = """
            Those highly advanced souls who know the Supreme Brahman (Brahma-vido janah), passing away from this world during the influence of the fiery god of light (Agnir jyotir), during the auspicious moment of the day (Ahah), during the fortnight of the waxing moon (Shuklah)...
            and during the specific six months when the sun travels in the north (Shan-masa uttarayanam), they attain the Supreme Brahman and absolute liberation (Gacchanti brahma tatra prayata).
            This is the highly classified 'Route Map' for the path of 'Anavrittim' (No Return / Moksha), officially known in Vedic astrophysics as the 'Devayana Marga' (The Path of Light).
            Lord Sri Krishna is explicitly mentioning the highly powerful presiding Demigods of Cosmic Time (Deities of Time) here. Fire, Day, the Waxing Moon, and Uttarayana are absolutely not mere blind timezones or weather patterns; they are highly conscious celestial Demigods (Guides) appointed to escort pure souls upwards.
            There is one dominant, blazing 'Common Theme' connecting this entire verse: 'Light' (Prakasha). Fire generates light, Day is filled with light, the Waxing Moon (Shukla Paksha) increases light, and Uttarayana (the 6-month northern path of the sun) maximizes light.
            'Light' is the ultimate cosmic symbol for Supreme 'Knowledge' and pure 'Consciousness'.
            An elite 'Brahma-vit' (A master who flawlessly knows God) consciously and medically chooses this specific 'Illuminated Time Window' to eject his soul from his biological machine (exactly as the legendary Grandsire Bhishma agonized on a bed of arrows strictly waiting for the Uttarayana to arrive).
            When the Yogi launches his soul through this specific 'Path of Light', these celestial deities of illumination officially 'Escort' him like a VIP directly into the Supreme Brahman (The Kingdom of God), guaranteeing he never returns.
        """.trimIndent()
    ),
    Shloka(
        id = 25,
        sanskrit = """
            धूमो रात्रिस्तथा कृष्णः षण्मासा दक्षिणायनम् |
            तत्र चान्द्रमसं ज्योतिर्योगी प्राप्य निवर्तते || २५ ||
        """.trimIndent(),
        hindi = """
            जिस मार्ग में 'धुआं' (अंधकार) है, 'रात' (रात्रिः) का समय है, 'कृष्ण पक्ष' (अंधेरी रात वाले 15 दिन) का समय है, और सूर्य के 'दक्षिणायन' (दक्षिणी दिशा में जाने वाले) छह महीने (षण्मासा) का समय है...
            उस अंधकारमय मार्ग से शरीर त्यागकर गया हुआ सकाम योगी (जो कर्मों के फल चाहता है), वह चंद्रमा की दिव्य ज्योति (स्वर्ग लोक के सुखों) को प्राप्त करके, (पुण्य खत्म होने पर) वापस इस संसार में लौट आता है (निवर्तते)।
            यह 'आवृत्ति' (Return / वापस लौटने) के रास्ते का 'रूट मैप' है, जिसे शास्त्रों में 'पितृयान मार्ग' (Path of Darkness) कहा जाता है।
            यह श्लोक पिछले श्लोक (मार्ग) का बिल्कुल उल्टा (Opposite) है। 
            यहाँ की कॉमन थीम (Theme) है: 'अंधकार' (Darkness / धुआं, रात, कृष्ण पक्ष, दक्षिणायन जब दिन छोटे होते हैं)। अंधकार 'अज्ञान' (Ignorance) और भौतिक 'आसक्ति' (Material Attachment) का प्रतीक है।
            यह मार्ग उन योगियों (कर्मकांडियों) के लिए है जिन्होंने बहुत पुण्य किए, समाज सेवा की, लेकिन उनके मन में एक 'लालच' था कि "मरने के बाद मुझे 'स्वर्ग' का सुख मिले।" उन्हें 'मोक्ष' (ईश्वर) नहीं चाहिए था।
            जब ऐसा स्वार्थी योगी शरीर छोड़ता है, तो अंधकार के देवता उसकी आत्मा को एस्कॉर्ट (Escort) करके 'चंद्रलोक' (चाँद की ज्योति / स्वर्ग) में ले जाते हैं। वहाँ वह योगी बहुत लंबे समय तक स्वर्ग की सुंदर अप्सराओं और सुखों का मज़ा लूटता है।
            लेकिन चूँकि यह रास्ता 'धुएं' (Smoke/Illusion) का है, इसलिए यह परमानेंट (Permanent) नहीं है। जैसे ही उसके पुण्य का बैंक बैलेंस (Bank Balance) खत्म होता है, उसे स्वर्ग से लात मारकर वापस इसी धरती (जन्म-मरण) पर भेज दिया जाता है ('निवर्तते')। वह आज़ाद नहीं हो पाता।
        """.trimIndent(),
        english = """
            The mystic yogi who passes away from this world during the path of smoke (Dhumo), during the dark night (Ratris), during the dark fortnight of the waning moon (Krishnah)...
            and during the specific six months when the sun passes to the south (Shan-masa dakshinayanam), strictly reaches the heavenly moon planet (Tatra chandramasam jyotir prapya), but eventually has to return back to earth (Nivartate).
            This is the classified 'Route Map' for the path of 'Avrittim' (Forced Return / Reincarnation), officially known in Vedic science as the 'Pitriyana Marga' (The Path of Darkness/Smoke).
            This verse is the exact, mathematical 'Opposite' of the previous verse.
            The dominant, overarching 'Theme' here is: 'Darkness' (Smoke, Night, Waning Moon, Dakshinayana when days are intensely short). Darkness is the ultimate cosmic symbol for 'Ignorance' and toxic 'Material Attachment'.
            This specific route is strictly designated for those fruitive Yogis (Karma-kandis) who executed massive pious charities and extreme social welfare, but harbored a greedy, toxic 'Lust' inside their brains, demanding, "I want to enjoy the celestial luxuries of 'Heaven' after death." They absolutely did not want God or Moksha.
            When such a materially attached Yogi drops his physical body, the celestial deities of darkness physically escort his soul to the 'Chandraloka' (The Lunar Light / Upper Heavenly planets). There, the Yogi violently indulges in staggering celestial luxuries and sensory pleasures for a massive duration.
            But because this path is fundamentally built on 'Smoke' (Illusion/Imperfection), it is absolutely NOT Permanent. The exact microsecond his karmic 'Bank Balance' of piety hits zero, he is ruthlessly evicted from heaven and violently booted back down to this miserable earth to take rebirth ('Nivartate'). He completely fails to achieve true liberation.
        """.trimIndent()
    ),
    Shloka(
        id = 26,
        sanskrit = """
            शुक्लकृष्णे गती ह्येते जगतः शाश्वते मते |
            एकया यात्यनावृत्तिमन्ययावर्तते पुनः || २६ ||
        """.trimIndent(),
        hindi = """
            वैदिक मत (ज्ञान) के अनुसार, इस संसार (जगत) से बाहर जाने के ये 'शुक्ल' (प्रकाश/सफेद) और 'कृष्ण' (अंधकार/काला) नामक दो ही मार्ग अनादि काल से 'शाश्वत' (Eternal / हमेशा रहने वाले) माने गए हैं।
            इनमें से एक मार्ग (शुक्ल/प्रकाश) से जाने वाला व्यक्ति उस परम गति को प्राप्त करता है जहाँ से उसे 'वापस नहीं लौटना पड़ता' (अनावृत्तिम्); और दूसरे मार्ग (कृष्ण/अंधकार) से जाने वाला व्यक्ति फिर से इसी संसार में 'वापस लौट आता है' (आवर्तते पुनः)।
            भगवान श्रीकृष्ण यहाँ पिछले दो श्लोकों का 'फाइनल समरी' (Final Summary) दे रहे हैं।
            वे स्पष्ट करते हैं कि इस पूरे ब्रह्मांडीय सिस्टम (Cosmic Matrix) से 'चेक-आउट' (Check-out/निकलने) करने के केवल दो ही पक्के (शाश्वत) 'हाइवे' (Highways) हैं। यह कोई नई बात नहीं है, यह ब्रह्मांड के बनने के समय से ही सेट (Set) नियम है।
            १. 'शुक्ल गति' (The White/Light Path): यह उन ज्ञानियों और भक्तों का रास्ता है जिन्होंने अपना मन 100% साफ कर लिया है। वे इस 'लाइट' (प्रकाश) के रास्ते से जाते हैं और 'मोक्ष' (अनावृत्ति) पा लेते हैं। गेम ओवर (Game Over), हमेशा के लिए आज़ादी!
            २. 'कृष्ण गति' (The Black/Dark Path): यह उन लोगों का रास्ता है जिनके दिल में अभी भी दुनिया की वासनाओं का 'कालापन' (धुआं) बाकी है। वे स्वर्ग तक तो जाते हैं, लेकिन वासना के चुंबक (Magnet) के कारण उन्हें वापस इसी धरती पर घसीट लिया जाता है ('पुनः आवर्तते')।
            इंसान को जीते-जी यह तय करना होता है कि उसे मौत के बाद कौन सा 'हाइवे' पकड़ना है—लाइट वाला जो ईश्वर तक जाता है, या डार्कनेस वाला जो वापस धरती पर लाता है।
        """.trimIndent(),
        english = """
            According to the absolute Vedic opinion, there are exactly two universally eternal (Shashvate) ways of passing from this material world (Jagatah)—one in pure light (Shukla) and one in dense darkness (Krishne).
            When a soul strictly departs by the path of light, he absolutely does not come back (Ekaya yaty anavrittim); but when one departs by the path of darkness, he is forcefully compelled to return to this world again (Anyayavartate punah).
            Lord Sri Krishna is providing the absolute 'Final Executive Summary' of the two previous highly complex verses here.
            He explicitly clarifies that in the entire Cosmic Matrix, there are exactly two, permanently fixed ('Shashvate' - Eternal) 'Cosmic Highways' designed for 'Checking-out' (Exiting) the material universe. This is not a new theory; it is a fundamental law hardwired into the universe since creation.
            1. 'Shukla Gati' (The White/Light Path): This is the exclusive, VIP route strictly reserved for those elite, fully illuminated sages and pure devotees whose minds are 100% scrubbed clean of all material dirt. They travel via this blazing 'Light' and successfully hack the matrix, achieving absolute 'Moksha' (Anavrittim). Game Over; Eternal Freedom!
            2. 'Krishna Gati' (The Black/Dark Path): This is the toxic route for those practitioners who still harbor the 'Black' smoke of lingering material lust and desires deep inside their hearts. They manage to travel up to Heaven, but because the toxic magnet of lust still exists in their core, they are violently dragged right back down to this miserable earth ('Punah avartate').
            A human being must aggressively and consciously decide, while he is biologically alive, exactly which 'Highway' his soul will take after physical death—the blazing Light leading to God, or the toxic Darkness looping back to the Matrix.
        """.trimIndent()
    ),
    Shloka(
        id = 27,
        sanskrit = """
            नैते सृती पार्थ जानन्योगी मुह्यति कश्चन |
            तस्मात्सर्वेषु कालेषु योगयुक्तो भवार्जुन || २७ ||
        """.trimIndent(),
        hindi = """
            हे पार्थ (अर्जुन)! इन दोनों रास्तों (प्रकाश और अंधकार के मार्गों) के परम रहस्य को भली-भांति जानने वाला (जानन्) कोई भी 'योगी' कभी भी मोह (भ्रम या चिंता) में नहीं पड़ता (न मुह्यति)।
            इसलिए, हे अर्जुन! तुम सभी कालों में (हमेशा / सर्वेषु कालेषु) 'योगयुक्त' (मुझमें मन लगाकर योग में स्थित) हो जाओ (योगयुक्तो भव)।
            ये दोनों रास्ते (दिन-रात, उत्तरायण-दक्षिणायन) सुनने में बहुत डरावने लग सकते हैं। अर्जुन सोच सकते थे: "अगर मेरी मौत गलती से रात में या दक्षिणायन में हो गई, तो क्या मैं वापस धरती पर गिर जाऊंगा?"
            भगवान श्रीकृष्ण यहाँ उस डर को 100% खत्म कर रहे हैं!
            वे कहते हैं कि जो 'सच्चा योगी' (भक्त) होता है, वह इन रास्तों के टेक्निकल (Technical) चक्कर में नहीं पड़ता। वह 'मोह' (Panic/Confusion) में नहीं आता कि "अरे, अभी तो रात है, मुझे अभी नहीं मरना चाहिए!"
            क्यों? क्योंकि योगी का कनेक्शन सूरज या चाँद से नहीं, बल्कि सीधे 'ईश्वर' (मुझसे) होता है। जो 24 घंटे भगवान से प्यार करता है, भगवान खुद उसकी आत्मा का जीपीएस (GPS) बन जाते हैं और उसे सही रास्ते (शुक्ल गति) से ही ले जाते हैं, चाहे उसकी मौत आधी रात को ही क्यों न हो।
            इसलिए भगवान सबसे बड़ा प्रैक्टिकल (Practical) ऑर्डर देते हैं: "तस्मात्... योगयुक्तो भवार्जुन!" (तुम मौत की टाइमिंग और रास्तों की चिंता छोड़ दो। तुम्हारा काम केवल एक है—तुम हर समय, 24/7 केवल मेरी भक्ति (योग) में लगे रहो)। 
            भक्ति करने वाले को मौत के समय किसी 'शुभ मुहूर्त' (Auspicious Time) का इंतज़ार नहीं करना पड़ता; भगवान खुद उसकी रक्षा करते हैं।
        """.trimIndent(),
        english = """
            O son of Pritha (Partha)! Although perfectly knowing these two distinct mystical paths (Ete sriti janan), a pure devotee or yogi is absolutely never bewildered or thrown into panic (Na muhyati kashchana).
            Therefore, O Arjuna, I command you to be always, at all times and in all circumstances, steadfastly fixed in pure devotional yoga (Tasmad sarveshu kaleshu yoga-yukto bhava).
            Hearing about these two complex paths (Day vs. Night, Light vs. Smoke) could easily trigger severe paranoia. Arjuna might logically panic: "What if I accidentally get killed in the middle of a dark night or during Dakshinayana? Will I be catastrophically booted back to earth?"
            Lord Sri Krishna violently annihilates that paralyzing fear right here! 100%.
            He declares that a 'True Yogi' (A pure, unalloyed devotee) absolutely never suffers a panic attack or falls into 'Bewilderment' (Moham) obsessing over these highly technical astronomical timetables. He does not scream, "Oh no, it's pitch dark outside, I must not die right now!"
            Why? Because a pure devotee's absolute connection is NOT with the biological Sun or Moon; his direct, unbreakable fiber-optic connection is solely with the 'Supreme Lord'. For a human who loves God 24/7, God Himself personally overrides the matrix, physically acting as the soul's Ultimate GPS, violently pulling him up through the 'Path of Light' even if he biologically dies at midnight during a hurricane.
            Therefore, the Lord issues the ultimate, highly practical Master-Command: "Tasmad... Yoga-yukto bhavarjuna!" (Stop obsessing over the astronomical timing of your death. You have exactly one supreme job—keep your consciousness permanently, 24/7 locked entirely into pure devotion/Yoga towards ME).
            A pure devotee absolutely never needs to pathetically wait for an 'Auspicious Astrological Window' to die; the Supreme Lord personally hacks the system to rescue him.
        """.trimIndent()
    ),
    Shloka(
        id = 28,
        sanskrit = """
            वेदेषु यज्ञेषु तपःसु चैव दानेषु यत्पुण्यफलं प्रदिष्टम् |
            अत्येति तत्सर्वमिदं विदित्वा योगी परं स्थानमुपैति चाद्यम् || २८ ||
        """.trimIndent(),
        hindi = """
            वेदों के पढ़ने (अध्ययन) में, बड़े-बड़े यज्ञों को करने में, कठोर तपस्याओं (तपःसु) में और भारी दान (दानेषु) देने में जो-जो 'पुण्यफल' (Pious results/स्वर्ग आदि) शास्त्रों में बताए गए हैं...
            मेरा 'योगी' (भक्त) इस रहस्य (कि ईश्वर ही सब कुछ हैं) को तत्त्व से जानकर (विदित्वा), उन सभी पुण्यों के फलों का आसानी से अतिक्रमण कर जाता है (अत्येति / उन सबको पीछे छोड़ देता है)।
            और वह योगी अंततः उस सबसे प्राचीन (आद्यम् / Original) 'परम स्थान' (परम धाम / Supreme Abode) को निश्चित रूप से प्राप्त कर लेता है (उपैति)।
            यह आठवें अध्याय (अक्षरब्रह्म योग) का शानदार और अत्यंत ही पावरफुल 'ग्रैंड फिनाले' (Grand Finale) श्लोक है!
            दुनिया के लोग भगवान को खुश करने के लिए क्या-क्या नहीं करते? कोई 20 साल तक वेदों के भारी श्लोक रटता है, कोई करोड़ों रुपए खर्च करके 'यज्ञ' और 'दान' करता है, और कोई हिमालय की बर्फ में 'तपस्या' करके अपनी हड्डियां गलता है।
            इन सब भारी-भरकम और मुश्किल कामों का रिज़ल्ट (पुण्यफल) क्या है? 'स्वर्ग' (जहाँ से वापस लौटना पड़ता है)।
            लेकिन भगवान श्रीकृष्ण कहते हैं कि जो इंसान केवल एक छोटा सा काम करता है—यानी मेरे इस 'सीक्रेट' (Secret/गीता के ज्ञान) को समझकर, केवल प्यार से मेरी 'भक्ति' (योग) करता है...
            वह योगी उन सारे वेदों, यज्ञों और तपस्याओं के पुण्यों (Bank Balance) को एक ही छलांग में पार कर जाता है ('अत्येति')! उसे सारे यज्ञों का फल फ्री (Free) में एक ही जगह (ईश्वर के प्रेम में) मिल जाता है।
            वह स्वर्ग जैसी टेंपररी (Temporary) जगह नहीं जाता, बल्कि वह सीधा उस 'परम स्थान' (वैकुंठ) में वीआईपी एंट्री (VIP Entry) लेता है, जो इस ब्रह्मांड के बनने से भी पहले का (आद्यम् / Original) घर है। 
            इस प्रकार, शुद्ध भक्ति ही दुनिया का सबसे बड़ा शॉर्टकट (Shortcut) और सबसे महान उपलब्धि (Achievement) है।
        """.trimIndent(),
        english = """
            A person who accepts the path of pure devotional service and yoga is absolutely not bereft of the pious results (Punya-phalam) derived from studying the Vedas (Vedeshu), performing austere sacrifices (Yajneshu), undergoing severe austerities (Tapahsu), or giving massively in charity (Daneshu).
            By simply and profoundly understanding this supreme secret (Idam viditva), the yogi easily surpasses and transcends all those fruitive results entirely (Atyeti tat sarvam), and he directly attains the original, supreme, absolute abode (Param sthanam upaiti chadyam).
            This is the spectacular, explosive, and infinitely powerful 'Grand Finale' verse of the Eighth Chapter (Akshara Brahma Yoga)!
            Ignorant mortals perform unimaginably painful and heavily expensive tasks attempting to please the heavens. Some aggressively memorize massive volumes of Sanskrit Vedas for decades; some spend billions of dollars executing massive 'Yajnas' and 'Charity'; and others brutally torture their physical bodies in the freezing Himalayas doing 'Austerities'.
            What is the absolute final, grand result (Punya-phala) of all this agonizing labor? 'Heaven' (A highly temporary vacation spot from which they will be violently booted back to earth).
            But Lord Sri Krishna drops the ultimate cheat-code: A human being who executes just ONE simple task—profoundly understanding this 'Supreme Secret' of the Gita and simply loving ME through pure 'Bhakti' (Yoga)...
            That Yogi flawlessly and effortlessly LEAPFROGS and totally surpasses ('Atyeti') the accumulated pious bank balances of all those scholars, philanthropists, and ascetics combined in a single jump! He acquires 100% of all their results automatically, for 'Free', packed entirely within his devotion.
            He absolutely bypasses the cheap, temporary dimension of Heaven and gets a direct, VIP, non-stop flight straight into the 'Param Sthanam' (The Absolute Supreme Abode / Vaikuntha), which is the 'Adyam' (The Original, Primeval Home existing long before the Big Bang).
            Thus, it is proven that Pure Devotion is the universe's ultimate Shortcut and its most majestic, supreme Achievement.
        """.trimIndent()
    )
)