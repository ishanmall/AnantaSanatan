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
fun AdhyayaTwelve() {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var searchQuery by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    fun performSearch() {
        val shlokaNum = searchQuery.toIntOrNull()
        if (shlokaNum != null) {
            val targetIndex = adhyayaTwelveShlokas.indexOfFirst { it.id == shlokaNum }
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
            label = { Text("Search Shloka Number (1 - 20)") },
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
            itemsIndexed(adhyayaTwelveShlokas) { _, shloka ->
                // Using the ShlokaCard defined in AdhyayaOne.kt to avoid duplicate errors
                ShlokaCard(shloka)
            }
        }
    }
}

// ALL 20 Shlokas for Chapter 12
val adhyayaTwelveShlokas = listOf(
    Shloka(
        id = 1,
        sanskrit = """
            अर्जुन उवाच |
            एवं सततयुक्ता ये भक्तास्त्वां पर्युपासते |
            ये चाप्यक्षरमव्यक्तं तेषां के योगवित्तमाः || १ ||
        """.trimIndent(),
        hindi = """
            अर्जुन ने पूछा: हे कृष्ण! जो भक्त इस प्रकार निरंतर आपके (साकार/Personal) रूप में लगकर अत्यंत प्रेम से आपकी उपासना करते हैं (सततयुक्ता ये भक्ताः)...
            और दूसरे वे लोग जो आपके 'अक्षर' (अविनाशी) और 'अव्यक्त' (निराकार / Formless Energy) रूप की पूजा करते हैं, उन दोनों में से किसे योग का सबसे उत्तम जानकार (योगवित्तमाः / Best Yogi) माना जाता है?
            ग्यारहवें अध्याय में भगवान का 'विश्वरूप' देखने के बाद अर्जुन अब दुनिया का सबसे बड़ा और सबसे पुराना आध्यात्मिक डिबेट (Spiritual Debate) श्रीकृष्ण के सामने रख रहे हैं: "साकार बनाम निराकार" (Personal God vs Formless Energy)।
            दुनिया में दो तरह के साधक हैं:
            १. 'सगुण उपासक' (Devotees): जो भगवान के एक बहुत ही प्यारे, साकार रूप (जैसे कृष्ण, राम) से एक इंसान की तरह 'लव-रिलेशनशिप' (Love Relationship) बनाते हैं। वे रोते हैं, भगवान को खाना खिलाते हैं, और हमेशा उनके ध्यान में (सततयुक्ता) रहते हैं।
            २. 'निर्गुण उपासक' (Impersonalists/ज्ञानयोगी): जो लोग मूर्तियों को नहीं मानते। वे कहते हैं कि ईश्वर एक 'यूनिवर्सल एनर्जी' (Universal Energy/अव्यक्त), एक कॉस्मिक लाइट (Cosmic Light/अक्षर) या 'शून्य' है, जिसे देखा या छुआ नहीं जा सकता। वे कठोर ध्यान करते हैं।
            अर्जुन सीधे पूछते हैं: "इन दोनों में से आपका 'फेवरेट' (Favorite) कौन है? दोनों में से ज्यादा 'परफेक्ट' और टॉप-क्लास (Top-class) का योगी कौन है?" भगवान इसका बिल्कुल सीधा जवाब अगले श्लोक में देते हैं।
        """.trimIndent(),
        english = """
            Arjuna intelligently inquired: O Krishna! Which are considered to be the most perfect and supreme in yoga (Yoga-vittamah)—those pure devotees who are always constantly engaged in worshiping Your personal form with love (Satata-yukta ye bhaktas)...
            or those who worship Your unmanifested, formless, and indestructible, impersonal feature (Ye chapi aksharam avyaktam)?
            Following the apocalyptic revelation of the Universal Form in Chapter 11, Arjuna now officially introduces the absolute greatest, oldest, and most fiercely debated spiritual controversy in the history of theology: "Personal God vs. Formless Energy" (Saguna vs. Nirguna).
            There are fundamentally two categories of transcendentalists in the matrix:
            1. The 'Devotees' (Bhakti Yogis): Who fiercely establish an intimate, highly personal, emotional 'Love Relationship' with a specific Form of God (like Krishna). They lovingly sing, serve, and remain 24/7 constantly plugged into His personal form ('Satata-yukta').
            2. The 'Impersonalists' (Jnana Yogis): Who aggressively reject forms and deities, theorizing that the Ultimate Truth is an invisible, formless, emotionless 'Cosmic Energy', a blinding white light, or a void ('Aksharam Avyaktam').
            Arjuna fires a direct, point-blank question to the Supreme Lord: "Who is officially Your 'Favorite'? Between these two camps, who is legally certified as the absolute 'Best and Most Perfect Yogi' (Yoga-vittamah)?" The Lord drops His brutal, unambiguous verdict in the very next verse.
        """.trimIndent()
    ),
    Shloka(
        id = 2,
        sanskrit = """
            श्रीभगवानुवाच |
            मय्यावेश्य मनो ये मां नित्ययुक्ता उपासते |
            श्रद्धया परयोपेतास्ते मे युक्ततमा मताः || २ ||
        """.trimIndent(),
        hindi = """
            श्री भगवान ने कहा: जो लोग अपने मन को पूरी तरह मुझमें (मेरे साकार रूप में) स्थिर करके (मय्यावेश्य मनो), हमेशा मुझसे जुड़े रहकर (नित्ययुक्ता) मेरी उपासना करते हैं...
            और जो अत्यंत गहरी और परम 'श्रद्धा' (परयोपेताः श्रद्धया) से युक्त हैं, वे ही मेरी नज़र में सबसे 'सर्वश्रेष्ठ योगी' (युक्ततमाः) माने गए हैं (मे मताः)।
            भगवान श्रीकृष्ण ने बिना किसी डिप्लोमेसी (Diplomacy) के अपना सीधा और 'फाइनल वर्डिक्ट' (Final Verdict) दे दिया!
            वे कहते हैं कि जो भक्त मेरे इस दो-हाथों वाले 'साकार' (Personal) रूप से प्यार करते हैं, वे ही नंबर 1 (युक्ततमाः / The Ultimate Best) हैं।
            क्यों? क्योंकि इंसान का मन किसी 'शून्य' (Void) या 'एनर्जी' (Energy) से प्यार नहीं कर सकता। इंसान को प्यार करने के लिए एक 'पर्सनालिटी' (Personality / व्यक्ति) चाहिए जो मुस्कुरा सके, जो बात कर सके, और जो दर्द में गले लगा सके।
            भगवान कहते हैं कि जो भक्त अपने दिमाग ('मनो') को पूरी तरह मेरे प्यार में 'लॉक' (आवेश्य) कर देता है, और जिसके अंदर 100% सॉलिड 'श्रद्धा' (Faith) होती है, वह मुझसे सबसे ज्यादा इंटिमेट (Intimate / करीब) होता है।
            निराकार की पूजा करने वाले बहुत महान हो सकते हैं, लेकिन वे मेरे 'भक्त' नहीं, बल्कि 'साधक' होते हैं। और जो मेरा भक्त है, वही मेरे लिए सबसे 'परफेक्ट' है!
        """.trimIndent(),
        english = """
            The Supreme Personality of Godhead officially declared: Those who completely and firmly fix their minds upon My personal form (Mayy aveshya mano ye mam) and who are always constantly engaged in worshiping Me (Nitya-yukta upasate)...
            endowed with absolute, supreme, transcendental faith (Shraddhaya parayopetas)—they are officially considered by Me to be the absolute most perfect and supreme in yoga (Te me yuktatama matah).
            Lord Sri Krishna delivers His absolute, undisputed 'Final Verdict' with zero diplomacy and zero ambiguity!
            He bluntly declares that the pure devotees who aggressively lock their love onto His sweet, personal, two-armed form are officially ranked as 'Number 1' (Yuktatamah / The Ultimate Best).
            Why? Because human psychology is biologically incapable of falling deeply in romantic 'Love' with a blank void, a mathematical equation, or a massive ball of formless, invisible 'Energy'. Human consciousness desperately requires a reciprocating 'Personality' who can smile, speak, and embrace them.
            The Lord asserts that a devotee who violently forcefully 'Hacks' and 'Locks' (Aveshya) his mind permanently into a state of pure love for Him, armed with 100% titanium 'Faith' (Shraddha), achieves the highest possible cosmic intimacy.
            Those who meditate on the formless void might be incredibly elite scholars, but they are merely 'Practitioners', whereas the lover of His personal form is His intimate 'Companion'. The Devotee wins the ultimate crown.
        """.trimIndent()
    ),
    Shloka(
        id = 3,
        sanskrit = """
            ये त्वक्षरमनिर्देश्यमव्यक्तं पर्युपासते |
            सर्वत्रगमचिन्त्यं च कूटस्थमचलं ध्रुवम् || ३ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 3 और 4 एक ही विचार हैं)
            परंतु जो लोग अपनी सभी इन्द्रियों को पूरी तरह वश में करके, हर जगह समान बुद्धि (समबुद्धयः) रखते हुए, और सभी प्राणियों के कल्याण में लगे रहकर (सर्वभूतहिते रताः)...
            उस 'अक्षर' (कभी नष्ट न होने वाले), 'अनिर्देश्य' (जिसके बारे में कुछ बताया न जा सके), 'अव्यक्त' (जो दिखाई न दे), 'सर्वत्रग' (हर जगह फैले हुए), 'अचिन्त्य' (सोच से परे), 'कूटस्थ' (निर्विकार), 'अचल' और 'ध्रुव' (स्थिर) परमेश्वर (निराकार ब्रह्म) की भली-भांति उपासना (पर्युपासते) करते हैं...
            (उनका क्या होता है, यह अगले श्लोक में है)।
            भगवान अब अर्जुन के दूसरे सवाल (निराकार/Formless Energy की पूजा करने वालों) का जवाब दे रहे हैं।
            भगवान किसी की मेहनत को बेकार नहीं कहते। वे निराकार (Formless) ब्रह्म की 8 भयंकर क्वालिटीज़ (Qualities) बताते हैं, जिन पर ज्ञानी लोग ध्यान लगाते हैं:
            १. 'अक्षर' (Indestructible), २. 'अनिर्देश्य' (Indescribable - जिसे शब्दों में न कहा जा सके), ३. 'अव्यक्त' (Invisible), ४. 'सर्वत्रग' (Omnipresent - वाई-फाई की तरह हर जगह), ५. 'अचिन्त्य' (Unthinkable - दिमाग से बाहर), ६. 'कूटस्थ' (Unchanging - जैसे लोहार की निहाई जिस पर चोट पड़े तो भी वह नहीं बदलती), ७. 'अचल' (Immovable), ८. 'ध्रुव' (Fixed/Permanent)।
            जो लोग इस डरावनी और अकल्पनीय 'डार्क एनर्जी/लाइट' (Cosmic Light) पर ध्यान लगाते हैं, उनके लिए भगवान ने 3 बहुत कड़ी शर्तें (Conditions) रखी हैं: इन्द्रियों पर 100% कंट्रोल, सबमें एक समान बुद्धि, और 24/7 दुनिया की भलाई करना। अगर वे यह सब करते हैं, तो उन्हें क्या मिलता है? अगला श्लोक देखिए।
        """.trimIndent(),
        english = """
            (Verses 3 and 4 form a continuous statement)
            But those who fully and completely worship the unmanifested, that which lies infinitely beyond the perception of the senses (Avyaktam paryupasate), the all-pervading (Sarvatra-gam), inconceivable (Achintyam), unchanging and fixed (Kuta-stham), immovable (Achalam), and eternal imperishable reality (Aksharam dhruvam)...
            by successfully controlling all the various senses, remaining entirely equal-minded to everyone, and fiercely engaging in the absolute welfare of all living entities... (their destination is revealed in the next verse).
            The Lord now systematically addresses Arjuna's second category: The Impersonalists who aggressively meditate on the 'Formless Cosmic Energy' (Nirguna Brahman).
            The Lord absolutely does not disrespect their brutal hustle. He lists the 8 terrifying, mind-bending attributes of the Formless Absolute they meditate upon:
            1. 'Aksharam' (Indestructible), 2. 'Anirdeshyam' (Indescribable - cannot be restricted by human vocabulary), 3. 'Avyaktam' (Completely Invisible), 4. 'Sarvatra-gam' (Omnipresent, saturating the matrix like a Wi-Fi signal), 5. 'Achintyam' (Inconceivable to a 3-pound biological brain), 6. 'Kuta-stham' (Unchanging - like a blacksmith's anvil that takes heavy hits but never mutates), 7. 'Achalam' (Immovable), 8. 'Dhruvam' (Eternally Fixed).
            To successfully execute this horrific meditation, the Lord lays down 3 excruciatingly strict conditions for these Yogis: 100% brutal lockdown of physical senses, flawless equal vision towards all, and relentless 24/7 dedication to global welfare. If they survive this torture, what is their reward? See the next verse.
        """.trimIndent()
    ),
    Shloka(
        id = 4,
        sanskrit = """
            सन्नियम्येन्द्रियग्रामं सर्वत्र समबुद्धयः |
            ते प्राप्नुवन्ति मामेव सर्वभूतहिते रताः || ४ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 3 के बाद)... अपनी सभी इन्द्रियों के समूह को अच्छी तरह वश में करके (सन्नियम्येन्द्रियग्रामं), सब जगह समान बुद्धि वाले (सर्वत्र समबुद्धयः), और सम्पूर्ण प्राणियों के हित (भलाई) में लगे हुए (सर्वभूतहिते रताः) वे ज्ञानी योगी भी...
            अंततः "मुझे ही प्राप्त करते हैं" (ते प्राप्नुवन्ति मामेव)!
            भगवान यहाँ बहुत बड़ी 'ब्रॉड-माइंडेडनेस' (Broad-mindedness / विशाल हृदय) दिखाते हैं! वे यह नहीं कहते कि जो लोग 'निराकार' (Formless) की पूजा करते हैं, वे नर्क में जाएंगे या उनका रास्ता गलत है।
            श्रीकृष्ण स्पष्ट कहते हैं कि: "चाहे तुम मुझे एक खूबसूरत इंसान (कृष्ण) के रूप में प्यार करो, या तुम मुझे एक 'अदृश्य शक्ति' (Invisible Energy) मानकर ध्यान करो... अगर तुम्हारी नीयत साफ है और तुम कड़ी मेहनत कर रहे हो, तो अंत में तुम 'मुझ तक ही' (मामेव) पहुँचोगे।"
            (जैसे कोई इंसान सीढ़ियों से छत पर जाए, और कोई लिफ्ट से जाए; दोनों छत पर ही पहुँचेंगे)।
            लेकिन भगवान ने यहाँ उन निराकार योगियों के लिए 3 बहुत ही खतरनाक 'फिल्टर' (Filters / शर्तें) लगा दिए हैं:
            १. 'सन्नियम्येन्द्रियग्रामं': उन्हें अपनी इन्द्रियों पर 100% मिलिट्री-ग्रेड (Military-grade) कंट्रोल चाहिए।
            २. 'समबुद्धयः': उन्हें चींटी और हाथी, दोस्त और दुश्मन सब एक जैसे दिखने चाहिए (Zero bias)।
            ३. 'सर्वभूतहिते रताः': उन्हें दुनिया के हर जीव की निस्वार्थ सेवा करनी होगी।
            अगर इन तीन शर्तों में एक भी फेल (Fail) हुई, तो निराकार का साधक गिर जाएगा। इसलिए यह रास्ता सही तो है, लेकिन बहुत 'मुश्किल' है (जैसा भगवान अगले श्लोक में बता रहे हैं)।
        """.trimIndent(),
        english = """
            (Continuing from Verse 3)... By perfectly and rigorously controlling the entire network of all the senses (Sanniyamyendriya-gramam), by maintaining absolute, flawless equanimity and equal vision toward everyone (Sarvatra sama-buddhayah), and by continuously engaging in the supreme welfare of all living entities (Sarva-bhuta-hite ratah)...
            such highly elevated impersonalists absolutely achieve ME and ME ALONE in the end (Te prapnuvanti mam eva).
            The Supreme Lord exhibits staggering, infinite 'Broad-mindedness' and cosmic inclusivity here! He absolutely does not declare that those who meditate on the 'Formless Void' are demonic sinners doomed to hell.
            Sri Krishna unequivocally states: "Whether you approach Me through intimate romantic love as a personal deity (Krishna), or whether you aggressively meditate on Me as a terrifying, invisible, formless 'Quantum Energy'... if your discipline is genuine, you will mathematically, ultimately crash into 'ME ALONE' (Mam eva)."
            (Just as one man takes the stairs and another takes an elevator; both eventually hit the exact same roof).
            HOWEVER, the Lord deliberately installs 3 highly lethal, almost biologically impossible 'Filters' (Conditions) for these Impersonal Yogis:
            1. 'Sanniyamyendriya-gramam': They must enforce a 100% brutal, military-grade lockdown on their wild sensory network.
            2. 'Sama-buddhayah': Their brains must be completely wiped of all biases; they must view a serial killer and a saint with exact equality.
            3. 'Sarva-bhuta-hite ratah': They must aggressively dedicate their entire existence to the selfless welfare of all creatures.
            If they fail even a microsecond in these 3 impossible conditions, their spiritual system crashes. This path is genuine, but terrifyingly difficult (as exposed in the next verse).
        """.trimIndent()
    ),
    Shloka(
        id = 5,
        sanskrit = """
            क्लेशोऽधिकतरस्तेषामव्यक्तासक्तचेतसाम् |
            अव्यक्ता हि गतिर्दुःखं देहवद्भिरवाप्यते || ५ ||
        """.trimIndent(),
        hindi = """
            जिन लोगों का मन उस 'अव्यक्त' (निराकार / Formless) ब्रह्म में आसक्त (लगा हुआ) है, उनके लिए इस मार्ग में क्लेश (कष्ट / Struggle) बहुत अधिक (अधिकतरः) है।
            क्योंकि 'देहधारियों' (जिनके पास भौतिक शरीर है / देहवद्भिः) के द्वारा उस अव्यक्त (निराकार) गति (लक्ष्य) को प्राप्त करना अत्यंत ही दुःख और कठिनाई (दुःखं) से भरा हुआ है।
            यह श्लोक 'ह्यूमन साइकोलॉजी' (Human Psychology / मानव मनोविज्ञान) का सबसे बड़ा मास्टरपीस (Masterpiece) है! भगवान बता रहे हैं कि 'निराकार' (Formless) की पूजा करना इतना खतरनाक और थका देने वाला क्यों है।
            भगवान कहते हैं, "क्लेशोऽधिकतरः" (इस रास्ते पर सिरदर्द और स्ट्रगल बहुत ज्यादा है!)। क्यों? 
            क्योंकि इंसान एक 'देहधारी' (Embodied soul) है। हमारे पास एक फिजिकल बॉडी (Physical body), आँखें, कान और भावनाएं (Emotions) हैं। हमारा दिमाग हमेशा 'फॉर्म' (Form/आकार) और 'चेहरों' (Faces) को प्रोसेस (Process) करने के लिए बना है। हम अपनी माँ के चेहरे से प्यार कर सकते हैं, लेकिन 'हवा' या 'स्पेस' (Vacuum) से प्यार नहीं कर सकते।
            तो जब एक इंसान (जिसके पास रूप है) किसी 'बिना रूप वाली' (अव्यक्त) चीज़ पर ज़बरदस्ती अपना दिमाग फोकस (Focus) करने की कोशिश करता है, तो उसका दिमाग क्रैश (Crash) हो जाता है। 
            उसे अपनी इन्द्रियों को ज़बरदस्ती मारना पड़ता है। यह उसके 'नेचर' (Nature) के बिल्कुल खिलाफ (Unnatural) है। इस ज़बरदस्ती में इंसान को 'दुःख' (Frustration/Depression) ही मिलता है।
            इसलिए भगवान कहते हैं कि शरीर वाले इंसानों के लिए मेरे 'साकार' (Personal/सुंदर) रूप से प्यार करना बहुत आसान और मज़ेदार है, जबकि निराकार का रास्ता सिर्फ और सिर्फ 'कष्ट' है।
        """.trimIndent(),
        english = """
            For those whose minds are deeply attached to the unmanifested, impersonal, and formless feature of the Supreme (Avyaktasakta-chetasam), advancement is incredibly troublesome, highly distressing, and full of extreme struggle (Klesho 'dhikataras tesham).
            To make absolute progress in that unmanifested discipline is exceedingly difficult and agonizingly painful (Duhkham) for those who are embodied in physical material bodies (Dehavadbhir avapyate).
            This verse is an absolute, staggering masterpiece of 'Human Psychology' and biological reality! The Lord flawlessly explains exactly why meditating on a 'Formless Energy' (Nirguna Brahman) is a highly toxic, exhausting, and psychologically damaging path.
            The Lord explicitly declares, "Klesho 'dhikatarah" (This path guarantees incredibly high levels of headache, friction, and brutal struggle!). Why?
            Because a human is 'Dehavadbhir' (An embodied entity). Our biological operating system comes pre-installed with physical eyes, ears, and high-intensity emotional software. Our brains are biologically hardwired to process 'Forms', 'Faces', and 'Relationships'. You can passionately love your mother's face, but you cannot romantically hug 'Empty Space' or 'Vacuum'.
            When a biological human (possessing form and emotion) tries to forcefully lock his brain onto a 'Formless, Invisible, Emotionless Void' (Avyakta), his psychological software violently crashes. 
            He has to brutally suppress and torture his natural senses. This is a highly 'Unnatural' violation of his biology. This forced, dry suppression breeds immense frustration and 'Duhkha' (misery/depression).
            Therefore, for entities trapped in physical bodies, loving the beautiful, reciprocating, 'Personal Form' of Krishna is exceptionally joyful and easy, whereas chasing the formless void is purely a self-inflicted torture.
        """.trimIndent()
    ),
    Shloka(
        id = 6,
        sanskrit = """
            ये तु सर्वाणि कर्माणि मयि संन्यस्य मत्पराः |
            अनन्येनैव योगेन मां ध्यायन्त उपासते || ६ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 6 और 7 एक ही बात का हिस्सा हैं)
            परंतु जो लोग (मेरे भक्त) अपने सभी कर्मों को पूरी तरह से मुझमें अर्पण करके (मयि संन्यस्य), और केवल मुझे ही अपना परम लक्ष्य मानकर (मत्पराः)...
            बिना किसी अन्य भटकाव के (अनन्येनैव), केवल भक्तियोग के द्वारा मेरा ध्यान करते हुए मेरी ही उपासना (पूजा) करते हैं (मां ध्यायन्त उपासते)...
            निराकार की मुश्किलें बताने के बाद, अब भगवान श्रीकृष्ण अपने 'भक्तों' (जो उनके साकार रूप से प्यार करते हैं) की लाइफस्टाइल (Lifestyle) बता रहे हैं।
            एक सच्चा भक्त कोई बहुत बड़ी और दर्दनाक तपस्या नहीं करता। उसका रास्ता बहुत 'स्मूद' (Smooth) और प्यारा होता है। वह केवल 3 काम करता है:
            १. 'सर्वाणि कर्माणि मयि संन्यस्य': वह ऑफिस जाता है, बच्चों को पालता है, लेकिन उन सारे कर्मों का रिज़ल्ट (पैसे/क्रेडिट) भगवान के चरणों में 'गिफ्ट' (Gift) कर देता है।
            २. 'मत्पराः': उसका अल्टीमेट बॉस (Ultimate Boss) और लक्ष्य केवल ईश्वर है।
            ३. 'अनन्येनैव योगेन': वह भगवान की पूजा किसी लालच (कि मुझे गाड़ी मिल जाए) से नहीं करता; वह केवल 'शुद्ध प्यार' (Unmixed devotion) से करता है।
            जब भक्त इतना प्यार देता है, तो भगवान उसके लिए क्या करते हैं? इसका ब्रह्मांड का सबसे शानदार 'प्रॉमिस' (Promise) अगले श्लोक में है!
        """.trimIndent(),
        english = """
            (Verses 6 and 7 form a continuous thought)
            But as for those pure devotees who completely dedicate and surrender all their actions entirely unto Me (Ye tu sarvani karmani mayi sannyasya), making Me their absolute, supreme, and ultimate goal (Mat-parah)...
            and who constantly worship Me and deeply meditate upon Me with exclusive, pure, unalloyed, unswerving devotion (Ananyenaiva yogena mam dhyayanta upasate)...
            After diagnosing the brutal torture of the impersonal, formless path, Lord Sri Krishna now vividly outlines the beautiful, effortless, and ecstatic 'Lifestyle' of His pure devotees (who worship His Personal Form).
            A genuine devotee absolutely does not execute bone-crushing, painful austerities. His operating system is incredibly 'Smooth' and fueled entirely by love. He flawlessly executes 3 simple steps:
            1. 'Sarvani karmani mayi sannyasya': He fiercely hustles at his corporate job and raises his family, but he takes the entire 'Credit/Profit' generated from those actions and wraps it up as a beautiful 'Gift', placing it entirely at God's lotus feet.
            2. 'Mat-parah': God is officially recognized as his singular, Ultimate Boss and exclusive life-goal.
            3. 'Ananyenaiva yogena': He absolutely does not worship God to extract cheap material bribes (like a new car or promotion). He operates strictly on 'Unmixed, Pure Devotion' (Love for the sake of Love).
            When a tiny human outputs this staggering level of pure Love, what massive cosmic action does the Supreme Lord execute in return? The ultimate, spine-chilling 'Cosmic Promise' drops in the very next verse!
        """.trimIndent()
    ),
    Shloka(
        id = 7,
        sanskrit = """
            तेषामहं समुद्धर्ता मृत्युसंसारसागरात् |
            भवामि नचिरात्पार्थ मय्यावेशितचेतसाम् || ७ ||
        """.trimIndent(),
        hindi = """
            हे पार्थ (अर्जुन)! जिन भक्तों ने अपने चित्त (मन और चेतना) को पूरी तरह से मुझमें ही लगा दिया है (मय्यावेशितचेतसाम्)...
            उन भक्तों का मैं इस मृत्यु-रूपी संसार के भयंकर सागर से (मृत्युसंसारसागरात्), बहुत ही जल्द (बिना देर किए / नचिरात्) स्वयं उद्धार करने वाला (समुद्धर्ता) बन जाता हूँ!
            यह भगवद्गीता का सबसे 'रोमांचक' (Goosebumps-inducing) और भगवान का सबसे बड़ा 'गारंटी कार्ड' (Guarantee Card) है!
            भगवान कहते हैं कि जो इंसान (भक्त) अपना दिमाग (चेतना) 100% मेरे ऊपर 'लॉक' (आवेशित) कर देता है, उसे अपनी मुक्ति (Moksha) के लिए खुद हाथ-पैर मारने की कोई ज़रूरत नहीं है!
            यह दुनिया कोई छोटी नदी नहीं है; यह 'मृत्यु-संसार-सागर' (The Ocean of Death and Rebirth) है, जिसमें भयंकर शार्क (बीमारियां, बुढ़ापा, धोखा) घूम रही हैं। एक इंसान खुद तैरकर इस समंदर को कभी पार नहीं कर सकता।
            इसलिए भगवान एक बहुत बड़ा ऐलान करते हैं: "तेषामहं समुद्धर्ता" (उन भक्तों का उद्धार मैं 'खुद' / Personally करता हूँ!)। 
            जब कोई बच्चा समंदर में डूब रहा होता है, तो क्या वह खुद तैरकर बाहर आता है? नहीं! उसका शक्तिशाली पिता एक हेलीकॉप्टर (Helicopter) या जहाज़ लेकर आता है और उसे अपने हाथों से खींचकर निकाल लेता है। 
            ठीक वैसे ही, जो भक्त भगवान को पुकारता है, ब्रह्मांड का मालिक अपना सिंहासन छोड़कर खुद ('समुद्धर्ता') आता है और उस भक्त को मौत के इस दलदल से 'नचिरात्' (Instantaneously / तुरंत) बाहर निकालकर वैकुंठ ले जाता है। भगवान अपने भक्त का 'रेस्क्यू-ऑपरेटर' (Rescue-operator) बन जाते हैं!
        """.trimIndent(),
        english = """
            O son of Pritha (Partha)! For those pure devotees whose minds and consciousness are entirely locked and fixed upon Me (Mayy aveshita-chetasam)...
            I Myself personally and swiftly become their ultimate deliverer and supreme savior (Tesham aham samuddharta), rescuing them instantaneously and without delay (Na chirat) from this terrifying, deadly ocean of birth and death (Mrityu-samsara-sagarat)!
            This is universally celebrated as the absolute most 'Goosebumps-inducing', thrilling, and spectacularly comforting 'Cosmic Guarantee Card' issued by the Supreme Lord!
            The Lord officially declares that a devotee who permanently 'Locks' (Aveshita) 100% of his brain's bandwidth and consciousness onto God absolutely does NOT need to desperately paddle and struggle to achieve his own liberation (Moksha)!
            This material matrix is absolutely not a shallow swimming pool; it is the 'Mrityu-samsara-sagara' (The Infinite, Apocalyptic Ocean of Death and Rebirth), heavily infested with toxic predators (diseases, aging, betrayals). A puny human simply cannot swim across it using his pathetic biological strength.
            Therefore, the Supreme Lord makes a staggering cosmic announcement: "Tesham aham samuddharta" (I MYSELF Personally become their ultimate Savior and Rescue-Operator!).
            When a tiny toddler is violently drowning in a raging, storm-hit ocean, does he analytically swim to shore? NO! His massive, powerful Father swoops down in a rescue chopper and physically yanks him out of the water.
            Exactly like that, when a pure devotee cries out, the Supreme CEO of the Multiverse leaves His eternal throne, personally descends, and 'Na Chirat' (Instantaneously / in a flash) yanks that soul out of this rotting death-trap, airlifting him directly to Vaikuntha!
        """.trimIndent()
    ),
    Shloka(
        id = 8,
        sanskrit = """
            मय्येव मन आधत्स्व मयि बुद्धिं निवेशय |
            निवसिष्यसि मय्येव अत ऊर्ध्वं न संशयः || ८ ||
        """.trimIndent(),
        hindi = """
            (यहाँ से भगवान 'भक्ति की सीढ़ी' / The Step-Ladder of Devotion शुरू करते हैं - यह 'प्लान ए' / Plan A है)
            तुम केवल मुझमें ही अपने मन को पूरी तरह लगाओ (फिक्स करो / मय्येव मन आधत्स्व), और अपनी बुद्धि (Intelligence) को भी मुझमें ही पूरी तरह लगा दो (मयि बुद्धिं निवेशय)।
            ऐसा करने से, तुम इस शरीर को छोड़ने के बाद (अत ऊर्ध्वं) निश्चित रूप से 'मुझमें ही' (ईश्वर के हृदय / धाम में) निवास करोगे (निवसिष्यसि)। इसमें रत्ती भर भी कोई संशय (शक / Doubt) नहीं है (न संशयः)।
            भगवान श्रीकृष्ण अब एक बहुत ही मास्टर-क्लास 'गाइड' (Master-class Guide / साइकोलॉजिस्ट) की तरह इंसान के दिमाग को हैक (Hack) करने के 4 अलग-अलग लेवल (Levels) बता रहे हैं।
            यह सबसे टॉप लेवल (Top Level / Plan A) है: "100% माइंड एंड इंटेलेक्ट सरेंडर" (Mind and Intellect Surrender)।
            भगवान कहते हैं, "हे अर्जुन! अपना 'मन' (जो इमोशंस/Emotions का घर है) मुझे दे दो, यानी मुझसे 100% प्यार करो। और अपनी 'बुद्धि' (जो लॉजिक/Logic का घर है) भी मुझे दे दो, यानी यह पक्का मान लो कि कृष्ण ही सुप्रीम भगवान हैं।"
            अगर इंसान का 'इमोशनल' दिमाग (Heart) और 'लॉजिकल' दिमाग (Brain) दोनों एक साथ 100% भगवान पर 'लॉक' (Lock / आधत्स्व) हो जाएं, तो इंसान का कनेक्शन इस दुनिया से कट जाता है।
            भगवान एक स्टैम्प पेपर पर गारंटी देते हैं: "न संशयः" (100% Guaranteed)! "अगर तुम ऐसा कर पाए, तो तुम इसी पल से वैकुंठ में ही जी रहे हो, और मरने के बाद हमेशा के लिए मेरे ही अंदर समा जाओगे।"
            लेकिन भगवान जानते हैं कि हर इंसान (हम और आप) का दिमाग इतना पावरफुल नहीं होता कि वह 24 घंटे भगवान पर टिका रहे। इसलिए भगवान अगले श्लोक में 'प्लान बी' (Plan B) देते हैं!
        """.trimIndent(),
        english = """
            (Here begins the 'Step-Ladder of Devotion' - This is the Ultimate 'Plan A')
            Just forcefully fix your entire mind exclusively upon Me alone (Mayy eva mana adhatsva), and intensely engage all your intelligence entirely in Me (Mayi buddhim niveshaya).
            Thus, you will undoubtedly and eternally live directly within Me (Nivasishyasi mayy eva) hereafter (Ata urdhvam). Of this, there is absolutely zero doubt (Na samshayah).
            Lord Sri Krishna now operates exactly like an elite, master-class 'Spiritual Psychologist', meticulously unveiling 4 distinct, decreasing 'Levels' (Hacks) to capture the human brain.
            This is the absolute Top-Tier, Platinum Level (Plan A): "100% Absolute Mind and Intellect Surrender."
            The Lord commands, "O Arjuna! Hand over your 'Mind' (the volatile seat of emotions and desires) entirely to Me; love Me 100%. And simultaneously, hand over your razor-sharp 'Intelligence' (the rigid seat of logic and rationality) entirely to Me; firmly calculate and accept that I am the Ultimate Truth."
            When both the 'Emotional Heart' and the 'Logical Brain' are aggressively and simultaneously 'Locked' (Adhatsva) exclusively onto the Supreme Lord, the human's Wi-Fi connection to the toxic material matrix is permanently severed.
            The Lord issues a signed, titanium cosmic guarantee: "Na Samshayah" (100% Mathematically Guaranteed without a microscopic doubt)! "If you successfully execute this, you are officially residing in Vaikuntha right now, and after death, you will live permanently inside Me."
            However, the Lord perfectly knows that normal humans possess severely degraded, flickering bandwidth that cannot stay locked on God 24/7. Therefore, He beautifully offers 'Plan B' in the very next verse!
        """.trimIndent()
    ),
    Shloka(
        id = 9,
        sanskrit = """
            अथ चित्तं समाधातुं न शक्नोषि मयि स्थिरम् |
            अभ्यासयोगेन ततो मामिच्छाप्तुं धनञ्जय || ९ ||
        """.trimIndent(),
        hindi = """
            ('प्लान बी' / Plan B): परंतु हे धनञ्जय! यदि तुम अपने चित्त (मन) को पूरी तरह से एक जगह स्थिर करके मुझमें टिकाने में समर्थ नहीं हो (न शक्नोषि मयि स्थिरम्)...
            तो फिर तुम 'अभ्यास-योग' (बार-बार अभ्यास करने की प्रक्रिया / Practice) के द्वारा मुझे प्राप्त करने की इच्छा (कोशिश) करो (मामिच्छाप्तुम्)।
            भगवान बहुत दयालु हैं। वे जानते हैं कि श्लोक 8 वाला 'प्लान ए' (Plan A) हम जैसे आम और चंचल लोगों के बस का नहीं है। मन बार-बार ऑफिस, इंस्टाग्राम, या वासना की तरफ भाग जाता है।
            तो भगवान कहते हैं, "कोई बात नहीं! अगर तुम अपना मन 100% मुझ पर फिक्स (Fix/स्थिर) 'नहीं' कर सकते (न शक्नोषि), तो तुम फेल (Fail) नहीं हुए हो। तुम 'प्लान बी' पर आ जाओ!"
            प्लान बी क्या है? 'अभ्यास योग' (The Yoga of relentless Practice)।
            अभ्यास का मतलब है 'कोशिश करना' (Trying)। भगवान कहते हैं कि तुम बस मुझे पाने की 'इच्छा' (Desire / इच्छाप्तुं) रखो। जब तुम ध्यान करने बैठो या काम करो, और तुम्हारा मन भाग जाए, तो उसे डांटो मत। उसे बस पकड़ कर दोबारा मेरी तरफ ले आओ।
            अगर दिन में 100 बार मन भागे, तो 100 बार उसे खींचकर वापस लाओ। इस 'प्रैक्टिस' (Practice) को ही 'अभ्यास योग' कहते हैं। 
            भगवान रिजल्ट (Result) नहीं देखते, वे इंसान की 'नीयत और कोशिश' (Intention & Effort) देखते हैं। जो इंसान बार-बार हार कर भी फिर से मन को भगवान में लगाने की कोशिश कर रहा है, भगवान कहते हैं कि वह भी मुझे पा लेगा।
            अगर अभ्यास भी नहीं हो पा रहा है, तो भगवान अगले श्लोक में 'प्लान सी' (Plan C) देते हैं!
        """.trimIndent(),
        english = """
            ('Plan B'): But my dear Arjuna, O winner of wealth (Dhananjaya), if you are simply unable to permanently fix your mind steadily and exclusively upon Me without deviation (Atha chittam samadhatum na shaknoshi mayi sthiram)...
            then you must attempt to thoroughly follow the regulative principles of 'Bhakti-Yoga' and continuous practice (Abhyasa-yogena), and in this way, fiercely develop a burning desire to attain Me (Mam icchapturn).
            The Supreme Lord is unfathomably compassionate. He mathematically knows that 'Plan A' (from Verse 8) is practically impossible for highly degraded, easily distracted modern humans. The biological mind will inevitably, violently escape towards corporate stress, social media, or lust.
            So the Lord comforts us: "Do not panic! If you absolutely 'Cannot' (Na shaknoshi) lock your mind permanently onto Me like a titanium statue, you are NOT disqualified! Simply downgrade to 'Plan B'!"
            What exactly is Plan B? 'Abhyasa Yoga' (The Yoga of Relentless, Brutal Practice).
            Abhyasa means 'Fiercely Trying'. The Lord demands: Just keep the burning 'Desire' (Iccham) to attain Me alive. When you sit to meditate or execute your duty, and your rogue mind violently runs away, do not brutally curse yourself. Just actively grab it by the collar and forcefully drag it back to Me.
            If the mind escapes 1,000 times a day, you must ruthlessly drag it back 1,000 times. This grueling, repetitive tug-of-war is officially termed 'Abhyasa Yoga' (Practice).
            God does not audit your final perfection; He audits your raw 'Effort and Intention'. The practitioner who consistently fails but relentlessly tries again is guaranteed to attain Him.
            But what if even 'Practice' is too hard? The Lord drops 'Plan C' in the next verse!
        """.trimIndent()
    ),
    Shloka(
        id = 10,
        sanskrit = """
            अभ्यासेऽप्यसमर्थोऽसि मत्कर्मपरमो भव |
            मदर्थमपि कर्माणि कुर्वन्सिद्धिमवाप्स्यसि || १० ||
        """.trimIndent(),
        hindi = """
            ('प्लान सी' / Plan C): और यदि तुम इस 'अभ्यास' (बार-बार मन को लगाने की कोशिश) को करने में भी पूरी तरह असमर्थ (नाकाम / असमर्थोऽसि) हो...
            तो तुम केवल मेरे लिए ही (मेरे निमित्त) सारे कर्म करने वाले बन जाओ (मत्कर्मपरमो भव)। इस प्रकार केवल मेरे लिए (मदर्थम्) कर्मों (ड्यूटियों) को करते हुए भी, तुम निश्चित रूप से 'परम सिद्धि' (मोक्ष) को प्राप्त कर लोगे (सिद्धिमवाप्स्यसि)।
            भगवान का 'कस्टमर सपोर्ट' (Customer Support / दयालुता) यहाँ अपनी चरम सीमा पर है!
            भगवान कहते हैं, "अगर तुम्हारा मन इतना चंचल और ज़िद्दी है कि तुम 'अभ्यास' (मेडिटेशन की प्रैक्टिस) भी नहीं कर पा रहे हो ('असमर्थोऽसि'), तो भी डरो मत! मेरे पास 'प्लान सी' (Plan C) भी है!"
            अगर तुम ध्यान में आँखें बंद करके नहीं बैठ सकते, तो मत बैठो। उठो और 'एक्शन' (Action/काम) करो। लेकिन वो काम (जॉब, बिज़नेस, युद्ध) खुद के लिए या अपने ईगो (Ego) के लिए मत करो।
            "मत्कर्मपरमो भव"—उस काम को मेरी (ईश्वर की) सेवा समझकर करो। मंदिर के बाहर जूते साफ करने से लेकर किसी बहुत बड़ी कंपनी का सीईओ (CEO) बनने तक—अगर तुम अपने काम को "भगवान का काम" (Working for God / मदर्थम्) मानकर पूरी ईमानदारी से करोगे, तो तुम्हारा वह 'ऑफिस वर्क' (Office work) ही तुम्हारी 'समाधि' बन जाएगा!
            भगवान एक बहुत बड़ी गारंटी देते हैं कि जो इंसान सिर्फ मेरे लिए 'कर्म' करता है, उसे भी बिल्कुल वही टॉप-क्लास 'परम सिद्धि' (सिद्धिमवाप्स्यसि / Liberation) मिलेगी जो बड़े-बड़े ध्यान करने वाले योगियों को मिलती है।
        """.trimIndent(),
        english = """
            ('Plan C'): And if you are so incredibly restless that you are completely unable to even execute this repetitive practice of yoga (Abhyase 'py asamartho 'si)...
            then simply try to dedicate and execute absolutely all your actions and work entirely for Me (Mat-karma-paramo bhava). For even by meticulously executing your ordinary worldly duties purely on My behalf (Mad-artham api karmani kurvan), you will undoubtedly achieve the absolute, supreme perfection (Siddhim avapsyasi).
            The Supreme Lord's infinite cosmic 'Customer Support' and compassion hit their absolute peak here!
            The Lord assures: "If your biological brain is so incredibly hyperactive and corrupted that you are pathetically 'Incapable' (Asamartho 'si) of even attempting 'Abhyasa' (basic repetitive meditation), DO NOT PANIC! I have an ultimate 'Plan C' for you!"
            If you simply cannot sit still with your eyes closed, then don't! Get up, enter the matrix, and execute explosive 'Action'. But do absolutely NOT execute that action (corporate job, business, or war) to feed your toxic ego or bank account.
            "Mat-karma-paramo bhava"—Execute that exact same heavy workload strictly as a direct 'Service to ME'. From mopping the floor of a hospital to running a trillion-dollar multinational empire as CEO—if you operate with the titanium conviction that "I am doing this specifically as God's work" (Mad-artham), your chaotic 'Office Grind' instantly transforms into the highest 'Trance' (Samadhi)!
            The Lord drops a spectacular guarantee: A human who merely 'Works' furiously for God attains the exact same 'Supreme Perfection' (Siddhim avapsyasi / Liberation) as the elite Yogi meditating silently in a Himalayan cave.
        """.trimIndent()
    ),
    Shloka(
        id = 11,
        sanskrit = """
            अथैतदप्यशक्तोऽसि कर्तुं मद्योगमाश्रितः |
            सर्वकर्मफलत्यागं ततः कुरु यतात्मवान् || ११ ||
        """.trimIndent(),
        hindi = """
            ('प्लान डी' / Plan D - The Final Option): और यदि तुम मेरी शरण (मद्योगम्) में रहकर 'केवल मेरे लिए कर्म' (प्लान सी) करने में भी पूरी तरह असमर्थ हो (अशक्तोऽसि कर्तुम्)...
            तो फिर तुम अपने मन और बुद्धि पर संयम रखते हुए (यतात्मवान्), अपने द्वारा किए जाने वाले सभी कर्मों के 'फलों का त्याग' (सर्वकर्मफलत्यागं) कर दो (ततः कुरु)।
            यह भगवान का सबसे आखिरी और सबसे 'यूनिवर्सल' (Universal / सबके लिए) रास्ता है! (The Ultimate Safety Net)।
            भगवान कहते हैं, "मैं जानता हूँ कि कुछ इंसान इतने ज्यादा स्वार्थी और 'रिज़ल्ट-ओरिएंटेड' (Result-oriented) होते हैं कि वे कोई भी काम भगवान के लिए (प्लान सी) नहीं कर सकते। उन्हें अपना पैसा और सक्सेस ही सबसे प्यारा होता है।"
            "अगर तुम उस कैटेगरी ('अशक्तोऽसि') में आते हो, तो तुम अपने लिए ही काम करो, अपने परिवार के लिए काम करो! लेकिन एक छोटा सा काम करो—"
            "सर्व-कर्म-फल-त्यागं"—यानी तुम जो भी काम कर रहे हो, उसके 'रिज़ल्ट' (Result / फल) से जो आसक्ति (Attachment) है, उसे छोड़ दो।
            इसका मतलब यह नहीं है कि सैलरी (Salary) लेना छोड़ दो। इसका मतलब है कि जब तुम पूरी मेहनत कर लो, तो रिज़ल्ट को अपने ईगो (Ego) से मत जोड़ो। अगर फायदा हो तो अहंकार मत करो, और अगर नुकसान हो तो डिप्रेशन में मत जाओ। उस रिज़ल्ट को यूनिवर्स (Universe/प्रकृति) की मर्ज़ी मानकर 'त्याग' दो (Let it go)।
            अगर इंसान केवल 'रिज़ल्ट की टेंशन' (Anxiety of the fruit) छोड़ दे, तो भी उसका मन शांत हो जाएगा और वह धीरे-धीरे अध्यात्म के रास्ते पर ऊपर चढ़ जाएगा।
        """.trimIndent(),
        english = """
            ('Plan D' - The Final Fallback Option): If, however, you are completely unable to act in this consciousness of dedicating your work to Me (Athaitad apy ashakto 'si kartum mad-yogam ashritah)...
            then you must simply try to act and execute your duties while completely renouncing and surrendering all the fruits and results of your actions (Sarva-karma-phala-tyagam tatah kuru), keeping yourself entirely situated in the self (Yatatma-van).
            This is the Lord's absolute final, foolproof 'Universal Safety Net' and the most accessible 'Plan D' for the lowest-level humans!
            The Lord diagnoses: "I perfectly know that some humans are so toxically selfish and obsessively 'Result-Oriented' that it is psychologically impossible for them to work exclusively for God's pleasure (Plan C). They are too violently addicted to their own wealth and personal success."
            "If you tragically fall into that lowest category ('Ashakto si'), then fine! Work furiously for your own self and your own family! But execute just one tiny psychological hack—"
            "Sarva-karma-phala-tyagam"—Meaning, whatever heavy action you execute, violently amputate and abandon your toxic, psychological 'Attachment' to the final 'Result' (Fruit).
            This absolutely does not mean throwing your hard-earned salary into the ocean. It profoundly means: Once you have invested 100% brutal effort, disconnect your 'Ego' from the outcome. If massive success arrives, do not explode with arrogance; if devastating failure strikes, do not collapse into depression. Mentally 'Renounce' (Let go of) the result, accepting it as the Universe's will.
            If a human simply drops the 'Toxic Anxiety of the Future Result', his brain instantly achieves peace, and he will gradually, automatically elevate to the higher spiritual platforms.
        """.trimIndent()
    ),
    Shloka(
        id = 12,
        sanskrit = """
            श्रेयो हि ज्ञानमभ्यासाज्ज्ञानाद्ध्यानं विशिष्यते |
            ध्यानात्कर्मफलत्यागस्त्यागाच्छान्तिरनन्तरम् || १२ ||
        """.trimIndent(),
        hindi = """
            (बिना समझे किए गए) 'अभ्यास' (Practice) से (शास्त्रों का) 'ज्ञान' बहुत श्रेष्ठ (श्रेयः) है; और किताबी ज्ञान से परमात्मा का 'ध्यान' (Meditation) करना अधिक श्रेष्ठ (विशिष्यते) है;
            परंतु ध्यान से भी 'कर्मों के फलों का त्याग' (कर्मफलत्यागः / श्लोक 11 वाला नियम) सबसे अधिक श्रेष्ठ है; क्योंकि इस प्रकार के 'त्याग' से इंसान को 'तत्काल' (उसी समय / अनन्तरम्) परम 'शांति' (शान्तिः) प्राप्त हो जाती है।
            यह श्लोक पिछले 4 श्लोकों (प्लान A, B, C, D) का 'कन्क्लूज़न' (Conclusion / निष्कर्ष) है। 
            भगवान श्रीकृष्ण यहाँ 'कर्मफल त्याग' (Renunciation of Results) को सबसे बड़ा 'शॉर्टकट' (Shortcut) और सबसे पावरफुल हथियार घोषित कर रहे हैं!
            भगवान एक हायरार्की (Hierarchy / क्रम) बनाते हैं:
            १. अगर कोई इंसान बिना समझे केवल मैकेनिकल (Mechanical) तरीके से 'अभ्यास' (पूजा-पाठ) कर रहा है, तो उससे बेहतर वह इंसान है जो 'ज्ञान' (किताबें) पढ़कर सच्चाई समझने की कोशिश कर रहा है।
            २. लेकिन जो केवल किताबें पढ़ रहा है ('ज्ञान'), उससे बेहतर वह इंसान है जो आँखें बंद करके ईश्वर का 'ध्यान' कर रहा है, क्योंकि वह प्रैक्टिकल कर रहा है।
            ३. लेकिन सबसे बड़ा धमाका! 'ध्यान' करने वाले योगी से भी करोड़ों गुना बेहतर वह इंसान है जो दुनिया के बीच रहकर काम करता है, लेकिन 'कर्म के फलों का त्याग' (Zero Attachment to Results) कर देता है!
            क्यों? क्योंकि ध्यान लगाने में सालों लग जाते हैं शांति पाने के लिए। लेकिन जो इंसान अभी इसी वक्त अपने काम के रिज़ल्ट की टेंशन (Tension) और लालच छोड़ दे, उसे 10 साल इंतज़ार नहीं करना पड़ता! "त्यागाच्छान्तिरनन्तरम्"—त्याग करते ही 'अगले ही सेकंड' (Instantly) उसके दिमाग में एक भयंकर 'शांति' (Ultimate Peace) छा जाती है। 'टेंशन फ्री' होना ही सबसे बड़ी समाधि है।
        """.trimIndent(),
        english = """
            If you absolutely cannot take to this practice, then immediately engage yourself in the cultivation of knowledge. Better (Shreyo) than mechanical practice (Abhyasa) is transcendental knowledge (Jnanam). Better than dry knowledge is deep meditation (Jnanad dhyanam vishishyate).
            And infinitely far better than meditation is the absolute, total renunciation of the fruits of your actions (Dhyanat karma-phala-tyagas); because by such profound renunciation, one instantly and immediately achieves supreme, unshakeable peace (Tyagach chantir anantaram).
            This spectacular verse serves as the absolute, mind-blowing 'Conclusion' to the 4 Step-Ladders (Plans A, B, C, D) detailed in the previous verses.
            Lord Sri Krishna officially crowns 'Karma-Phala-Tyaga' (The absolute renunciation of results) as the ultimate 'Shortcut' and the most staggeringly powerful psychological weapon in the universe!
            The Lord establishes a strict cosmic Hierarchy:
            1. If a human is merely executing blind, robotic, mechanical rituals ('Abhyasa') without any understanding, the human who aggressively studies and cultivates true 'Knowledge' (Jnana) is far superior.
            2. But the intellectual who merely memorizes books ('Jnana') is vastly inferior to the active practitioner who closes his eyes and dives into deep 'Meditation' (Dhyana).
            3. BUT THE ULTIMATE PLOT TWIST! Infinitely, exponentially superior even to the elite meditating Yogi is the active human living in society who violently executes 'Karma-Phala-Tyaga' (Absolute Zero Attachment to the Results of his hard work)!
            Why? Because an ascetic meditating in a cave might take 40 years to achieve a flicker of peace. But a corporate warrior who instantly, right now, completely drops all toxic anxiety and greed for his future promotion or wealth does not have to wait a single day! "Tyagach chantir anantaram"—The exact microsecond he renounces the fruit, a blinding, ultimate 'Peace' (Shanti) instantaneously crashes into his brain. Becoming 100% 'Anxiety-Free' is the highest truest form of Samadhi.
        """.trimIndent()
    ),
    Shloka(
        id = 13,
        sanskrit = """
            अद्वेष्टा सर्वभूतानां मैत्रः करुण एव च |
            निर्ममो निरहङ्कारः समदुःखसुखः क्षमी || १३ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 13 से 19 तक भगवान अपने 'सबसे प्यारे भक्त' के 35 लक्षण बता रहे हैं)
            जो मनुष्य संसार के किसी भी प्राणी से द्वेष (नफरत) नहीं करता (अद्वेष्टा सर्वभूतानां), जो सभी का पक्का 'मित्र' (दोस्त) है (मैत्रः), और जो सभी के प्रति दयालु (करुण) है...
            जो ममता से पूरी तरह मुक्त (निर्ममो / यह मेरा है, ऐसा भाव न होना) है, जो अहंकार (घमंड) से पूरी तरह मुक्त (निरहङ्कारः) है, जो सुख और दुःख दोनों में बिल्कुल एक समान (समदुःखसुखः) रहता है, और जो क्षमा करने वाला (क्षमी / Forgiving) है... (वह मुझे बहुत प्रिय है)।
            भक्ति की सीढ़ी बताने के बाद, अब भगवान श्रीकृष्ण दुनिया के सामने एक 'परफेक्ट ह्यूमन बीइंग' (The Perfect Human Being / परम भक्त) की 'प्रोफाइल' (Profile) रख रहे हैं।
            भगवान को कैसा इंसान पसंद है? जो बहुत पूजा करता हो? नहीं! भगवान को वो इंसान पसंद है जिसका कैरेक्टर (Character) हीरे जैसा साफ हो।
            १. 'अद्वेष्टा' & 'मैत्रः': दुनिया चाहे उसे कितनी भी गालियां दे, वह किसी से नफरत (Hate) नहीं करता। वह एक खूंखार जानवर या अपने सबसे बड़े दुश्मन का भी 'दोस्त' और 'भला चाहने वाला' होता है।
            २. 'करुण': जब वह किसी को दुःख में देखता है, तो मज़ाक नहीं उड़ाता, बल्कि उसकी मदद के लिए पिघल जाता है (Compassion)।
            ३. 'निर्ममो निरहङ्कारः': उसके पास चाहे अरबों की संपत्ति हो, लेकिन वह खुद को उसका 'मालिक' (Owner) नहीं, बल्कि एक 'केयरटेकर' (Caretaker) मानता है। उसमें 'मैं बहुत बड़ा आदमी हूँ' वाला ईगो (Ego) ज़ीरो होता है।
            ४. 'समदुःखसुखः क्षमी': जब उसके साथ बहुत अच्छा होता है तो वह उछलता नहीं, और जब कोई उसका बहुत बड़ा नुकसान कर दे, तो वह बदला (Revenge) लेने के बजाय उसे 'क्षमा' (माफ़) कर देता है। यही 'ईश्वरीय गुण' हैं!
        """.trimIndent(),
        english = """
            (From Verse 13 to 19, the Lord describes the 35 ultimate qualities of His most beloved devotee)
            One who is completely devoid of hatred and absolutely nonenvious toward any living entity (Adveshta sarva-bhutanam), who is a profoundly kind and friendly well-wisher to all (Maitrah), and who is fiercely compassionate (Karuna eva cha)...
            who is entirely free from all false claims of proprietorship (Nirmamo - nothing is 'mine'), who is utterly devoid of false ego (Nirankarah), who remains absolutely equal in both extreme happiness and deep distress (Sama-duhkha-sukhah), and who is always highly forgiving (Kshami)... (he is very dear to Me).
            After outlining the mechanical steps to devotion, Lord Sri Krishna now drops the absolute, ultimate 'Psychological Profile' of the "Perfect Human Being" (The Supreme Devotee) for the world to see.
            What exact kind of human does God actually love? Someone who performs 10-hour mechanical rituals? NO! God exclusively loves humans whose 'Character' is as flawless as a polished diamond.
            1. 'Adveshta & Maitrah': Even if the toxic matrix brutally abuses and attacks him, he harbors mathematically ZERO 'Hatred' in his heart. He acts as the absolute best 'Friend' and well-wisher to everyone, including a bloodthirsty predator or his most bitter earthly enemy.
            2. 'Karuna': When he witnesses the brutal suffering of others, he does not arrogantly mock them; his heart instantly melts with explosive 'Compassion' to actively rescue them.
            3. 'Nirmamo Nirankarah': He might legally control a billion-dollar empire, but he strictly considers himself merely an unpaid 'Caretaker', never the 'Owner'. The toxic disease of "I am a massive, important CEO" (Ego) is completely eradicated from his software.
            4. 'Sama-duhkha-sukhah Kshami': He remains a motionless titanium rock during both massive lottery wins and catastrophic bankruptcies. And when a toxic enemy causes him immense personal damage, instead of seeking violent, petty 'Revenge', he unleashes the godlike superpower of absolute 'Forgiveness' (Kshama). These are literal traits of God.
        """.trimIndent()
    ),
    Shloka(
        id = 14,
        sanskrit = """
            सन्तुष्टः सततं योगी यतात्मा दृढनिश्चयः |
            मय्यर्पितमनोबुद्धिर्यो मद्भक्तः स मे प्रियः || १४ ||
        """.trimIndent(),
        hindi = """
            जो योगी हमेशा (हर परिस्थिति में) पूरी तरह संतुष्ट (सन्तुष्टः सततं) रहता है, जिसने अपने मन और शरीर को पूरी तरह वश में कर लिया है (यतात्मा), जिसका भगवान के प्रति निश्चय (भरोसा) एकदम पक्का (चट्टान जैसा) है (दृढनिश्चयः)...
            और जिसने अपना मन और अपनी बुद्धि पूरी तरह से केवल मुझमें ही अर्पण (फिक्स) कर दी है (मय्यर्पितमनोबुद्धिः), ऐसा वह मेरा परम भक्त (मद्भक्तः) मुझे बहुत ही अधिक प्रिय है (स मे प्रियः)।
            यह भक्त की इंटरनल साइकोलॉजी (Internal Psychology / मानसिक अवस्था) का सबसे परफेक्ट (Perfect) वर्णन है।
            १. 'सन्तुष्टः सततं': दुनिया का इंसान हमेशा 'और चाहिए, और चाहिए' (More and more) की बीमारी में रोता रहता है। लेकिन यह भक्त 'सुपर-सैटिस्फाइड' (Super-satisfied) होता है। अगर उसे रूखी-सूखी रोटी मिले, तो भी वह मुस्कुराकर उसे भगवान का प्रसाद मानकर खाता है। वह 'परिस्थिति' (Situation) का गुलाम नहीं होता।
            २. 'यतात्मा': उसका शरीर और मन एक बहुत ही ट्रेंड आर्मी-कमांडो (Trained Army-commando) की तरह उसके पूरे कंट्रोल में होते हैं। वह अपनी वासनाओं के आगे कभी घुटने नहीं टेकता।
            ३. 'दृढनिश्चयः': अगर पूरी दुनिया भी आकर उससे कहे कि "तेरा भगवान फेक (Fake) है," तो भी उसका 'विश्वास' एक मिलीमीटर भी नहीं हिलता। वह अपने रास्ते पर जिद्दी (Titanium-willed) होता है।
            ४. 'मय्यर्पितमनोबुद्धिः': वह कोई भी डिसीजन (Decision) अपनी छोटी सी बुद्धि से नहीं लेता। उसने अपना 'दिमाग और दिल' (Mind and Intellect) पूरी तरह ईश्वर के 'सॉफ्टवेयर' (Software) पर अपलोड (Upload) कर दिया है।
            भगवान एक पिता की तरह बहुत गर्व से कहते हैं: "जिस इंसान में ये क्वालिटीज़ हैं, वह मुझे दुनिया में सबसे ज्यादा प्यारा ('मे प्रियः') है!"
        """.trimIndent(),
        english = """
            That mystic yogi who is always perfectly, consistently, and entirely satisfied under all possible circumstances (Santushtah satatam yogi), whose mind and self are brutally self-controlled (Yatatma), who is armed with absolute, unshakeable determination (Dridha-nishchayah)...
            and whose mind and intelligence are completely, fully dedicated, surrendered, and uploaded onto Me alone (Mayy arpita-mano-buddhir)—such a pure, flawless devotee of Mine is exceptionally and incredibly dear to Me (Yo mad-bhaktah sa me priyah).
            This verse delivers the absolute, perfect description of the 'Internal Psychology' and operating system of God's favorite human.
            1. 'Santushtah satatam': An ignorant mortal is permanently infected with the toxic, cancerous disease of "I need more, more, more!" and cries 24/7. But this elite devotee is 'Super-Satisfied'. Even if the matrix throws him absolute garbage or dry bread, he smiles and joyfully consumes it as God's mercy. He is absolutely NOT a pathetic slave to external 'Situations'.
            2. 'Yatatma': His physical biological body and wildly fluctuating mind are disciplined and subjugated exactly like a highly trained, elite military Black-Ops Commando. He absolutely never drops to his knees before cheap biological lust or cravings.
            3. 'Dridha-nishchayah': Even if the entire global population screams at him that "Your God is a fake myth," his titanium 'Faith' absolutely does not vibrate even a single microscopic millimeter. He possesses a terrifyingly stubborn, unstoppable determination.
            4. 'Mayy arpita-mano-buddhir': He executes absolutely zero major life decisions using his own puny, flawed biological intelligence. He has actively and 100% 'Uploaded' his entire 'Heart and Brain' directly onto God's divine cosmic Software.
            The Supreme Lord declares with immense, bursting, fatherly pride: "Any human being successfully running this specific psychological software is officially My absolute favorite entity in the multiverse ('Me Priyah')!"
        """.trimIndent()
    ),
    Shloka(
        id = 15,
        sanskrit = """
            यस्मान्नोद्विजते लोको लोकान्नोद्विजते च यः |
            हर्षामर्षभयोद्वेगैर्मुक्तो यः स च मे प्रियः || १५ ||
        """.trimIndent(),
        hindi = """
            जिस मनुष्य से दुनिया का कोई भी जीव कभी घबराता या परेशान नहीं होता (यस्मान्नोद्विजते लोको), और जो खुद भी दुनिया के किसी भी प्राणी से कभी घबराता या परेशान नहीं होता (लोकान्नोद्विजते च यः)...
            तथा जो सांसारिक खुशी (हर्ष), ईर्ष्या/जलन (अमर्ष), डर (भय), और घबराहट/बेचैनी (उद्वेग) से पूरी तरह मुक्त (आज़ाद) हो चुका है (हर्षामर्षभयोद्वेगैर्मुक्तो यः), वह भक्त मुझे अत्यंत प्रिय है (स च मे प्रियः)।
            यह श्लोक एक इंसान की 'सोशल और इमोशनल इंटेलिजेंस' (Social and Emotional Intelligence) का सबसे ऊँचा 'बेंचमार्क' (Benchmark) है!
            १. 'यस्मान्नोद्विजते लोको': आज की दुनिया में बॉस अपने एम्प्लॉईज़ (Employees) को डराता है, ताकतवर इंसान कमजोर को डराता है। लोग ऐसे इंसान से दूर भागते हैं जो 'टॉक्सिक' (Toxic) हो। लेकिन भगवान का सच्चा भक्त एक 'सेफ ज़ोन' (Safe Zone) होता है। एक जानवर या एक छोटा बच्चा भी उसके पास आकर सुरक्षित (Safe) और रिलैक्स (Relax) महसूस करता है। उसकी मौजूदगी से किसी को 'टेंशन' या 'खौफ' नहीं होता।
            २. 'लोकान्नोद्विजते': दूसरी तरफ, चाहे दुनिया उसे कितनी भी गालियां दे, चाहे हालात कितने भी खराब हो जाएं, वह भक्त भी दुनिया वालों से 'फ्रस्ट्रेट' (Frustrate) या परेशान नहीं होता। उसका 'पीस ऑफ माइंड' (Peace of Mind) कोई चुरा नहीं सकता।
            ३. वह 4 भयंकर दिमागी बीमारियों से पूरी तरह आज़ाद (मुक्त) है: 'हर्ष' (लॉटरी लगने पर खुशी से पागल होना), 'अमर्ष' (पड़ोसी की नई कार देखकर जलना), 'भय' (नौकरी जाने या मौत का खौफ), और 'उद्वेग' (भविष्य की ओवरथिंकिंग/Overthinking या एंग्ज़ायटी/Anxiety)।
            जिस इंसान का 'ऑरा' (Aura) इतना शांत और पावरफुल (Powerful) हो गया है, भगवान कहते हैं, "मुझे उससे बहुत प्यार है!"
        """.trimIndent(),
        english = """
            He by whom absolutely no one in the world is ever put into difficulty, agitated, or terrified (Yasman nodvijate loko), and who himself is never agitated, frustrated, or terrified by anyone in the world (Lokan nodvijate cha yah)...
            and who is completely and eternally freed from worldly, ecstatic joy (Harsha), bitter envy and anger (Amarsha), paralyzing fear (Bhaya), and crippling anxiety (Udvegair mukto yah)—that pure devotee is exceptionally dear to Me (Sa cha me priyah).
            This spectacular verse establishes the absolute highest, supreme 'Benchmark' for a human being's 'Social and Emotional Intelligence' in the universe!
            1. 'Yasman nodvijate loko': In the modern, toxic corporate matrix, arrogant bosses terrify their employees, and the strong ruthlessly bully the weak. Normal humans aggressively flee from 'Toxic' personalities. But a genuine, pure devotee of God is a walking, breathing 'Absolute Safe Zone'. Even a stray animal or a terrified child instantly feels a profound, soothing safety and relaxation in his very presence. His aura generates absolute zero 'Stress' or 'Terror' for anyone.
            2. 'Lokan nodvijate': On the exact flip side, no matter how brutally the world insults him, abuses him, or attacks him, that elite devotee absolutely NEVER gets 'Frustrated', agitated, or disturbed by the ignorant masses. Absolutely no human on earth possesses the power to hijack his internal 'Peace of Mind'.
            3. He is completely, permanently cured of the 4 most lethal psychological diseases: 'Harsha' (losing his mind in arrogant euphoria upon winning a lottery), 'Amarsha' (burning with toxic jealousy seeing a neighbor's new luxury car), 'Bhaya' (the paralyzing terror of getting fired or dying), and 'Udvega' (crippling, panic-inducing anxiety and overthinking about the future).
            The Lord declares: "A human whose 'Aura' has become this staggeringly peaceful and powerful is My absolute favorite!"
        """.trimIndent()
    ),
    Shloka(
        id = 16,
        sanskrit = """
            अनपेक्षः शुचिर्दक्ष उदासीनो गतव्यथः |
            सर्वारम्भपरित्यागी यो मद्भक्तः स मे प्रियः || १६ ||
        """.trimIndent(),
        hindi = """
            मेरा वह भक्त जो किसी भी सांसारिक वस्तु या व्यक्ति से कोई उम्मीद या अपेक्षा नहीं रखता (अनपेक्षः), जो बाहर और भीतर से पूरी तरह पवित्र है (शुचिः), जो अपने सभी कार्यों में अत्यंत चतुर/कुशल (दक्षः) है...
            जो दुनिया के झमेलों से तटस्थ (न्यूट्रल / उदासीनो) रहता है, जिसके सभी मानसिक संताप और चिंताएं मिट चुकी हैं (गतव्यथः), और जिसने सभी स्वार्थी नए कामों (प्रोजेक्ट्स) की शुरुआत का पूरी तरह त्याग कर दिया है (सर्वारम्भपरित्यागी)... ऐसा भक्त मुझे बहुत प्रिय है।
            भगवान यहाँ एक भक्त की 'प्रोफेशनल और पर्सनल' (Professional & Personal) क्वालिटीज़ (Qualities) बता रहे हैं!
            १. 'अनपेक्षः' (Zero Expectations): इंसान सबसे ज्यादा दुःखी क्यों होता है? क्योंकि वह लोगों से 'उम्मीदें' (Expectations) रखता है ("मैंने इसके लिए इतना किया, इसने मुझे थैंक्यू भी नहीं कहा")। भक्त की किसी से कोई 'एक्सपेक्टेशन' नहीं होती, वह केवल अपना फर्ज़ निभाता है।
            २. 'शुचिः': वह रोज़ नहाकर शरीर साफ रखता है (बाहरी शुद्धि), और किसी के लिए बुरा नहीं सोचता (भीतरी शुद्धि)।
            ३. 'दक्षः' (Expert): यह बहुत ज़रूरी है! भक्त का मतलब कोई बेवकूफ या 'लूज़र' (Loser) नहीं है। वह अपने काम (चाहे बिज़नेस हो या कोडिंग) में दुनिया का सबसे 'शार्प और एक्सपर्ट' (Sharp & Expert) इंसान होता है। वह हर काम परफेक्शन (Perfection) के साथ करता है।
            ४. 'उदासीनो गतव्यथः': ऑफिस में पॉलिटिक्स (Politics) चल रही हो या समाज में लड़ाई, वह न्यूट्रल (Neutral/अंपायर की तरह) रहता है। वह फालतू की 'व्यथा' (टेंशन) नहीं पालता।
            ५. 'सर्वारम्भपरित्यागी': वह अपने ईगो (Ego) को चमकाने के लिए फालतू के नए-नए 'स्टार्टअप्स' (Startups / झमेले) शुरू नहीं करता। वह केवल वही काम करता है जो भगवान और समाज के लिए ज़रूरी है।
            ऐसा सुपर-बैलेंस्ड (Super-balanced) इंसान भगवान का सबसे चहेता है।
        """.trimIndent(),
        english = """
            My devotee who is completely free from all material expectations and totally independent of external circumstances (Anapekshah), who is impeccably clean and pure both inwardly and outwardly (Shuchir), who is highly expert and incredibly skilled in everything he does (Dakshah)...
            who is entirely completely neutral, unattached, and indifferent (Udasino), who is permanently freed from all mental pains and terrifying anxieties (Gata-vyathah), and who has completely renounced all selfish, ego-driven endeavors and massive new projects (Sarvarambha-parityagi)... such a pure devotee is exceptionally dear to Me.
            The Lord is brilliantly mapping out the ultimate 'Professional and Personal' qualities of an elite Devotee here!
            1. 'Anapekshah' (Zero Expectations): Why is an ordinary human constantly miserable? Because he is violently infected with the disease of 'Expectations' ("I sacrificed so much for him, and he didn't even say Thank You!"). The devotee legally expects absolutely NOTHING from anyone; he simply executes his duty flawlessly and moves on.
            2. 'Shuchih': He takes daily showers to maintain immaculate physical hygiene (outer purity) and harbors absolutely zero toxic thoughts or jealousy toward anyone (inner purity).
            3. 'Dakshah' (Expert/Genius): This is critically important! A devotee is absolutely NOT a pathetic, incompetent 'Loser' or a fool. Whether it is coding software or running a business, he is the absolute sharpest, most highly 'Expert' and competent professional in the room. He executes every task with titanium perfection.
            4. 'Udasino gata-vyathah': Whether brutal office politics are raging or society is fighting, he remains totally 'Neutral' (like a detached Supreme Court Judge). He refuses to carry any toxic 'Vyatha' (pain/stress/baggage) in his brain.
            5. 'Sarvarambha-parityagi': He completely stops furiously launching massive, stressful new 'Startups' or material projects purely to inflate his own ego and bank account. He only initiates actions that strictly serve God and humanity.
            A human being possessing this staggering level of balance is God's absolute favorite.
        """.trimIndent()
    ),
    Shloka(
        id = 17,
        sanskrit = """
            यो न हृष्यति न द्वेष्टि न शोचति न काङ्क्षति |
            शुभाशुभपरित्यागी भक्तिमान्यः स मे प्रियः || १७ ||
        """.trimIndent(),
        hindi = """
            जो मनुष्य (किसी मनपसंद चीज़ के मिलने पर) कभी अत्यधिक हर्षित (खुशी से पागल) नहीं होता (यो न हृष्यति), जो (बुरी चीज़ से) कभी घृणा या द्वेष नहीं करता (न द्वेष्टि)...
            जो (कुछ खो जाने पर) कभी शोक (दुःख/रोना) नहीं करता (न शोचति), जो (भविष्य के लिए किसी चीज़ की) कोई लालसा या इच्छा नहीं रखता (न काङ्क्षति)...
            और जिसने सभी 'शुभ' (अच्छे) और 'अशुभ' (बुरे) कर्मों के फलों का पूरी तरह से त्याग कर दिया है (शुभाशुभपरित्यागी), ऐसा वह अत्यंत भक्ति से भरा हुआ मनुष्य (भक्तिमान्) मुझे बहुत ही अधिक प्रिय है (स मे प्रियः)।
            यह श्लोक 'इमोशनल स्टेबिलिटी' (Emotional Stability / भावनाओं पर नियंत्रण) का अल्टीमेट चीट-कोड (Ultimate Cheat-code) है।
            आम इंसान का रिमोट कंट्रोल (Remote Control) दुनिया (परिस्थितियों) के हाथ में होता है।
            १. 'न हृष्यति': अगर उसे 1 करोड़ की लॉटरी लग जाए, तो वह 'हृष्यति' (पार्टी करता है, घमंड में फूल जाता है)। लेकिन भक्त शांत रहता है (क्योंकि वह जानता है पैसा आज है, कल नहीं होगा)।
            २. 'न द्वेष्टि': अगर रास्ते में बहुत गंदा कीचड़ आ जाए या कोई उसे गाली दे, तो वह 'द्वेष' (नफरत/गुस्सा) नहीं करता। वह उसे भी भगवान का एक टेस्ट (Test) मानता है।
            ३. 'न शोचति': अगर उसका बिज़नेस डूब जाए या कोई अपना मर जाए, तो वह आम इंसान की तरह छाती पीट कर 'शोक' (डिप्रेशन) नहीं करता, क्योंकि उसे पता है कि सब कुछ टेंपरेरी (Temporary) है।
            ४. 'न काङ्क्षति': उसे कल क्या होगा, मुझे कौन सी नई चीज़ खरीदनी है, इसकी कोई 'डिमांड' (Demand/लालसा) नहीं होती।
            और सबसे बड़ी बात, वह 'शुभाशुभपरित्यागी' होता है—वह इस बात की गणित (Math) लगाना छोड़ देता है कि "मुझे इस काम से पुण्य (शुभ) मिलेगा या पाप (अशुभ)।" वह अपना सब कुछ, अपना अच्छा और बुरा दोनों, पूरी तरह से भगवान के अकाउंट (Account) में 'डिपॉज़िट' (Deposit) कर देता है और एकदम 'फ्री' (Free) हो जाता है।
        """.trimIndent(),
        english = """
            He who absolutely never rejoices or becomes arrogantly elated upon gaining something pleasant (Yo na hrishyati), who absolutely never resents, hates, or despises anything unpleasant (Na dveshti)...
            who never laments, cries, or falls into grief upon losing something (Na shochati), who never intensely desires or hungers for things he does not possess (Na kankshati)...
            and who has completely totally renounced both all auspicious (Shubha) and inauspicious (Ashubha) things, completely abandoning all karmic reactions—such a devotee (Bhaktiman) is exceptionally dear to Me.
            This spectacular verse is the absolute 'Ultimate Cheat-code' for titanium-grade 'Emotional Stability'.
            An ordinary, ignorant mortal has completely handed over the 'Remote Control' of his emotions to the external, chaotic world.
            1. 'Na hrishyati': If an ordinary man wins a massive million-dollar lottery, he violently 'Hrishyati' (throws arrogant parties, becoming bloated with toxic pride). But the elite devotee remains stone-cold calm (because he scientifically knows this wealth is highly temporary).
            2. 'Na dveshti': If someone hurls toxic insults at him or he encounters filth, he absolutely does not generate 'Dvesha' (violent hatred/rage). He objectively treats it as a mere passing test from God.
            3. 'Na shochati': If his massive corporate empire violently crashes into bankruptcy, he absolutely does not 'Shochati' (beat his chest, cry bitterly, or spiral into severe clinical depression), because he perfectly knows everything in this matrix has a strict expiration date.
            4. 'Na kankshati': He possesses absolutely zero desperate, toxic 'Demands' or pathetic cravings for future acquisitions.
            And the ultimate plot twist: He is a 'Shubhashubha-parityagi'—He completely violently stops doing the pathetic mental mathematics of "Will this specific action give me pious merit (Shubha) or sin (Ashubha)?" He takes his entire existence, both the good and the bad, and seamlessly 'Deposits' it directly into God's ultimate bank account, becoming 100% utterly 'Free' from all karmic anxiety.
        """.trimIndent()
    ),
    Shloka(
        id = 18,
        sanskrit = """
            समः शत्रौ च मित्रे च तथा मानापमानयोः |
            शीतोष्णसुखदुःखेषु समः सङ्गविवर्जितः || १८ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 18 और 19 एक ही विचार हैं)
            जो मनुष्य अपने परम शत्रु (दुश्मन / शत्रौ) और अपने सबसे पक्के मित्र (दोस्त / मित्रे) के प्रति बिल्कुल एक समान (बराबर / समः) भाव रखता है; तथा जो समाज में मिलने वाले बहुत बड़े सम्मान (मान) और भारी बेइज़्जती (अपमान) में भी बिल्कुल एक समान (समः) रहता है...
            जो मौसम की सर्दी (शीत) और गर्मी (उष्ण) में, तथा जीवन के सुख और दुःख (सुखदुःखेषु) में हमेशा एक समान (बैलेंस्ड) रहता है, और जो सभी प्रकार की सांसारिक आसक्तियों (लगाव / Attachments) से पूरी तरह मुक्त (सङ्गविवर्जितः) हो चुका है...
            यह दुनिया के हर इंसान का सबसे बड़ा 'साइकोलॉजिकल टेस्ट' (Psychological Test) है। 
            भगवान कहते हैं कि मेरा प्यारा भक्त वह है जिसका 'बैलेंस' (Balance) दुनिया की कोई भी एक्सट्रीम सिचुएशन (Extreme Situation) नहीं बिगाड़ सकती।
            १. 'शत्रौ च मित्रे': अगर आपका दोस्त आपके घर आए, तो आप बहुत खुश होते हैं। अगर आपका दुश्मन सामने आ जाए, तो आपका खून खौलने लगता है। लेकिन भक्त का 'हार्ट-रेट' (Heart-rate) दोनों को देखकर बिल्कुल एक जैसा (Normal) रहता है! क्योंकि वह जानता है कि दोनों के अंदर एक ही कृष्ण बैठे हैं।
            २. 'मानापमानयोः': अगर कोई आपको 'सर-सर' (Sir) कहे और आपकी तारीफ करे, तो ईगो (Ego) बढ़ता है। अगर कोई आपको भरी महफिल में थप्पड़ मार दे (अपमान), तो आप सुसाइड (Suicide) तक सोच लेते हैं। लेकिन भक्त के लिए 'तारीफ' और 'गाली' दोनों महज़ कुछ 'साउंड-वेव्स' (Sound-waves/आवाज़) हैं। वह दोनों में 'समः' (Neutral) रहता है।
            ३. 'शीतोष्णसुखदुःखेषु': चाहे ए.सी. (AC) वाला कमरा हो या चिलचिलाती धूप; चाहे सब कुछ अच्छा चल रहा हो या सब बर्बाद हो गया हो... वह भक्त हमेशा 'सङ्गविवर्जितः' (Detached) रहता है। वह एक 'लोटस-लीफ' (Lotus-leaf / कमल के पत्ते) की तरह किसी भी चीज़ से नहीं चिपकता।
        """.trimIndent(),
        english = """
            (Verses 18 and 19 form a continuous description)
            He who acts and remains absolutely completely equal (Samah) towards both his most bitter, lethal enemy (Shatrau) and his most beloved, intimate friend (Mitre cha); and who remains exactly the same in the face of the highest grand honor (Mana) and the most brutal public dishonor and humiliation (Apamanayoh)...
            who remains perfectly balanced and unaffected in the extremes of freezing cold (Shita) and scorching heat (Ushna), as well as in extreme happiness and devastating distress (Sukha-duhkheshu); and who is utterly, entirely free from all contaminating, toxic worldly attachments (Sanga-vivarjitah)...
            This is the absolute ultimate 'Psychological Stress-Test' for any human being in existence.
            The Supreme Lord declares that His most beloved devotee is one whose 'Equilibrium' (Balance) absolutely cannot be shattered by any 'Extreme Situation' the matrix throws at him.
            1. 'Shatrau cha mitre': If your best friend visits you, you explode with joy. If your most lethal enemy appears, your blood violently boils. But the elite devotee's 'Heart-rate' remains exactly identically flat (Normal) upon seeing both! Because he scientifically knows that the exact same Krishna resides inside the hearts of both.
            2. 'Manapamanayoh': If society falsely worships you and showers you with prestigious awards (Honor), your ego dangerously inflates. If society aggressively cancels you and publicly slaps you (Dishonor), you spiral into suicidal depression. But to the Master Yogi, 'Praise' and 'Insults' are biologically nothing more than empty, meaningless 'Sound-waves' passing through the air. He remains 100% 'Samah' (Neutral) in both.
            3. 'Shitoshna-sukha-duhkheshu': Whether he is relaxing in a luxury AC mansion or burning in the scorching desert sun; whether his life is a billionaire's dream or a total apocalyptic disaster... the devotee remains permanently 'Sanga-vivarjitah' (100% Detached). Like an un-wettable 'Lotus-Leaf', absolutely no worldly extreme ever sticks to his mind.
        """.trimIndent()
    ),
    Shloka(
        id = 19,
        sanskrit = """
            तुल्यनिन्दास्तुतिर्मौनी सन्तुष्टो येन केनचित् |
            अनिकेतः स्थिरमतिर्भक्तिमान्मे प्रियो नरः || १९ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 18 के बाद)... जो इंसान अपनी निंदा (बुराई/गाली) और स्तुति (तारीफ) दोनों को बिल्कुल एक समान (तुल्य) समझता है; जो हमेशा 'मौन' (शांत / कम बोलने वाला / मौनी) रहता है; जिसे जीने के लिए जो कुछ भी (येन केनचित्) मिल जाए, वह उसी में पूरी तरह संतुष्ट (सन्तुष्टो) रहता है...
            जिसका इस दुनिया में कोई अपना पक्का घर या मकान नहीं है (अनिकेतः - यानी जो किसी प्रॉपर्टी से अटैच नहीं है), जिसकी बुद्धि परमात्मा में पूरी तरह स्थिर (अटल / स्थिरमतिः) हो चुकी है, ऐसा वह परम भक्ति से युक्त (भक्तिमान्) मनुष्य मुझे बहुत ही अधिक प्रिय है (मे प्रियो नरः)।
            यहाँ भगवान भक्त के 5 और 'सुपर-ह्यूमन' (Super-human) लक्षण बता रहे हैं:
            १. 'तुल्यनिन्दास्तुतिः': अगर कोई उसकी बुराई करे या कोई उसकी मूर्ति बनाकर पूजे, उसे दोनों ही बातों से कोई फर्क नहीं पड़ता। वह दोनों को 'बराबर' (तुल्य) मानता है।
            २. 'मौनी': वह फालतू की बकवास, डिबेट (Debate), या गॉसिप (Gossip) नहीं करता। वह केवल तभी बोलता है जब ज़रूरत होती है। उसका दिमाग 'साइलेंट मोड' (Silent mode) पर होता है।
            ३. 'सन्तुष्टो येन केनचित्': अगर उसे खाने को 56 भोग मिलें, तो भी खुश; और अगर 2 दिन तक भूखा रहना पड़े, तो भी वह भगवान से शिकायत नहीं करता। जो मिल जाए, उसी में "थैंक गॉड" (Thank God / सन्तुष्टो) कहता है।
            ४. 'अनिकेतः': 'निकेत' का अर्थ है घर/मकान। इसका मतलब यह नहीं है कि भक्त होमलेस (Homeless / बेघर) होता है। इसका मतलब है कि वह अपने करोड़ों के बंगले को भी 'अपना' नहीं मानता; वह जानता है कि यह शरीर और घर केवल कुछ सालों के किराए का मकान है। उसकी उस 'ईंट और पत्थर' से कोई अटैचमेंट नहीं होती।
            ५. 'स्थिरमतिः': उसका दिमाग एक पहाड़ की तरह 'फिक्स्ड' (Fixed) होता है। 
            जब ये सारी क्वालिटीज़ किसी इंसान में आ जाती हैं, तो भगवान खुद आकर उसे 'आई लव यू' (I Love You / मे प्रियः) बोलते हैं!
        """.trimIndent(),
        english = """
            (Continuing from Verse 18)... He who considers both vicious defamation and high praise to be completely equal and the same (Tulya-ninda-stutir), who is silent and highly thoughtful (Mauni), who is fully and perfectly satisfied with absolutely whatever comes to him by the grace of God (Santushto yena kenachit)...
            who possesses no toxic attachment to any permanent residence or property (Aniketah), whose intelligence is firmly and permanently fixed upon the Supreme Truth (Sthira-matir), and who is deeply engaged in pure devotional service (Bhaktiman)—such a spectacular human being is extremely dear to Me (Me priyo narah).
            Here, the Lord lists 5 more incredible, 'Super-Human' characteristics of an elite devotee:
            1. 'Tulya-ninda-stutih': If the entire world brutally cancels him and hurls toxic abuse, or if they blindly worship him and build statues of him, he processes both events as mathematically 'Equal' (Tulya). It does not affect his internal software.
            2. 'Mauni': He absolutely refuses to engage in cheap, toxic gossip, arrogant debates, or useless chatter. He operates primarily on 'Silent Mode' (Mauni), only speaking when it adds profound spiritual value.
            3. 'Santushto yena kenachit': If he is served a 56-course luxury gourmet meal, he is happy; if he is violently forced to starve for two days on the street, he absolutely does not complain to God. He is 100% 'Super-Satisfied' with whatever the universe randomly throws at him.
            4. 'Aniketah': 'Niketa' literally means a physical house/mansion. This absolutely does NOT mean the devotee must sleep on the sidewalk like a homeless beggar. It profoundly means that even if he lives in a $100 Million mega-mansion, he views it merely as a temporary, rented hotel room. He has ZERO toxic, possessive attachment to those dead bricks and concrete.
            5. 'Sthira-matir': His brain is 'Fixed' like an immovable mountain.
            When a human successfully installs all these staggering qualities, the Supreme Lord Himself steps down to officially declare, "I LOVE YOU! (Me Priyo Narah)!"
        """.trimIndent()
    ),
    Shloka(
        id = 20,
        sanskrit = """
            ये तु धर्म्यामृतमिदं यथोक्तं पर्युपासते |
            श्रद्दधाना मत्परमा भक्तास्तेऽतीव मे प्रियाः || २० ||
        """.trimIndent(),
        hindi = """
            परंतु जो भक्त इस ऊपर बताए गए (यथोक्तं) 'धर्म रूपी अमृत' (धर्म्यामृतम् - भक्ति के इन 35 दिव्य लक्षणों) का पूरी निष्ठा और श्रद्धा के साथ (श्रद्दधाना) पालन करते हैं (पर्युपासते)...
            और जो केवल 'मुझे' (परमेश्वर को) ही अपना परम और अंतिम लक्ष्य मानते हैं (मत्परमाः), वे भक्त (भक्ताः) मुझे 'अत्यंत ही ज्यादा' (अतीव) प्रिय हैं (तेऽतीव मे प्रियाः)।
            यह बारहवें अध्याय (भक्तियोग) का शानदार 'ग्रैंड फिनाले' (Grand Finale) श्लोक है!
            भगवान श्रीकृष्ण ने श्लोक 13 से लेकर 19 तक अपने 'परफेक्ट भक्त' की 35 सबसे शानदार क्वालिटीज़ (जैसे- दयालु होना, क्षमा करना, अहंकार न करना, सुख-दुःख में समान रहना) बताई थीं।
            भगवान इन 35 क्वालिटीज़ को एक बहुत ही खूबसूरत नाम देते हैं: "धर्म्यामृतम्" (धर्म का अमृत / The Nectar of Dharma)। दुनिया के बाकी सारे ज्ञान और नियम सूखे (Dry) हो सकते हैं, लेकिन यह जो 'भक्ति और अच्छे कैरेक्टर' (Character) का ज्ञान है, यह साक्षात् 'अमृत' है। जो इसे पी लेता है, वह अमर हो जाता है।
            भगवान कंक्लूड (Conclude) करते हैं: "अगर कोई इंसान पूरी 'श्रद्धा' के साथ इन सारे नियमों को अपनी ज़िंदगी में उतार लेता है (केवल पढ़ता नहीं, बल्कि जीता है), और जो अपने जीवन का इकलौता मकसद (मत्परमाः) केवल मुझे (ईश्वर) ही बना लेता है..."
            "तो ऐसे इंसान के लिए मेरा प्यार कोई नॉर्मल (Normal) प्यार नहीं होता। वह भक्त मुझे 'अतीव' (Ateeva - Extremely / असीमित रूप से / हदों को पार करके) प्यारा हो जाता है!" 
            भगवान यह गारंटी दे रहे हैं कि अगर आप अपना कैरेक्टर (Character) भगवान के बताए अनुसार बना लें, तो भगवान खुद आपके प्यार में पागल हो जाएंगे!
            यहाँ गीता का 'हृदय' (Heart) माना जाने वाला 'भक्तियोग' नामक बारहवाँ अध्याय पूर्ण होता है।
        """.trimIndent(),
        english = """
            But those devotees who completely and flawlessly adopt and follow this imperishable, nectar-like path of pure devotional religion (Dharmyamritam idam) exactly as I have prescribed it above (Yathoktam paryupasate)...
            who engage themselves with absolute, supreme faith (Shraddhadhana), totally making Me their absolute ultimate and supreme goal (Mat-parama)—those specific devotees (Bhaktah) are exceedingly, overwhelmingly, and infinitely dear to Me (Te 'tiva me priyah).
            This is the spectacular, breathtaking, and absolute 'Grand Finale' verse of the Twelfth Chapter (Bhakti Yoga)!
            From Verse 13 to 19, Lord Sri Krishna beautifully laid out the 35 ultimate, staggering qualities of His 'Perfect Devotee' (being compassionate, forgiving, egoless, and completely balanced in joy and tragedy).
            The Lord officially bestows a majestic, beautiful title upon this specific list of 35 qualities: "Dharmyamritam" (The Absolute Nectar of Immortal Dharma). While other worldly rules and dry philosophies might be incredibly boring and lifeless, this specific science of 'Bhakti and Flawless Character' is literal, liquid 'Immortality' (Nectar). Whoever drinks it becomes eternal.
            The Lord emphatically Concludes: "If a human being successfully downloads and actually executes these rules in his daily life with 100% titanium 'Faith' (Shraddhadhana), and if he brutally makes ME his absolute, singular ultimate target (Mat-parama)..."
            "Then My love for him is absolutely NOT just ordinary, casual love. That specific devotee becomes 'Ativa' (Overwhelmingly, Exceedingly, Infinitely beyond all limits) dear to Me!"
            The Supreme Lord is officially guaranteeing that if you forcefully upgrade your internal character to match His exact criteria, God Himself will fall madly, infinitely in love with you!
            Here flawlessly concludes the Twelfth Chapter, Bhakti Yoga, officially recognized as the absolute 'Beating Heart' of the Bhagavad Gita.
        """.trimIndent()
    )
)