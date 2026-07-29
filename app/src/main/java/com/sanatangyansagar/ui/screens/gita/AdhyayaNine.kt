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
fun AdhyayaNine() {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var searchQuery by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    fun performSearch() {
        val shlokaNum = searchQuery.toIntOrNull()
        if (shlokaNum != null) {
            val targetIndex = adhyayaNineShlokas.indexOfFirst { it.id == shlokaNum }
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
            label = { Text("Search Shloka Number (1 - 34)") },
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
            itemsIndexed(adhyayaNineShlokas) { _, shloka ->
                // Using the ShlokaCard defined in AdhyayaOne.kt to avoid duplicate errors
                ShlokaCard(shloka)
            }
        }
    }
}

// ALL 34 Shlokas for Chapter 9
val adhyayaNineShlokas = listOf(
    Shloka(
        id = 1,
        sanskrit = """
            श्रीभगवानुवाच |
            इदं तु ते गुह्यतमं प्रवक्ष्याम्यनसूयवे |
            ज्ञानं विज्ञानसहितं यज्ज्ञात्वा मोक्ष्यसेऽशुभात् || १ ||
        """.trimIndent(),
        hindi = """
            श्री भगवान ने कहा: हे अर्जुन! चूँकि तुम मुझमें बिल्कुल भी दोष नहीं निकालते (मुझसे ईर्ष्या नहीं करते / अनसूयवे), इसलिए मैं तुम्हें यह सबसे परम गोपनीय रहस्य (गुह्यतमं) बताऊँगा।
            मैं तुम्हें इस साक्षात् अनुभव वाले 'विज्ञान' (अनुभव) सहित उस 'ज्ञान' (थ्योरी) का उपदेश दूँगा, जिसे जानकर तुम इस संसार के सभी अशुभ (दुःखों और जन्म-मरण) से हमेशा के लिए मुक्त (मोक्ष्यसे) हो जाओगे।
            नौवें अध्याय (राजविद्या राजगुह्य योग) की शुरुआत में भगवान श्रीकृष्ण एक बहुत बड़ा 'लॉक' (Lock) खोल रहे हैं।
            गीता का यह ज्ञान ब्रह्मांड का सबसे बड़ा 'क्लासिफाइड सीक्रेट' (Classified Secret / गुह्यतमं) है। यह कोई आम पब्लिक इंफॉर्मेशन (Public Information) नहीं है जिसे हर किसी को दे दिया जाए।
            भगवान कहते हैं कि मैं यह टॉप-सीक्रेट (Top-Secret) तुम्हें क्यों बता रहा हूँ? इसका पासवर्ड क्या है?
            पासवर्ड है: 'अनसूयवे' (Zero Envy / ईर्ष्या न करना)।
            साधारण इंसान जब ईश्वर की महानता के बारे में सुनता है, तो उसका ईगो (Ego) हर्ट होता है और वह भगवान में गलतियां (Fault-finding) निकालने लगता है कि "भगवान खुद अपनी तारीफ क्यों कर रहे हैं?" 
            लेकिन अर्जुन का दिल बिल्कुल साफ है। वह भगवान की महानता सुनकर जलता नहीं, बल्कि खुश होता है। 
            जब शिष्य के मन से 'ईर्ष्या' (जलन) का वायरस पूरी तरह खत्म हो जाता है, केवल और केवल तभी भगवान अपना सबसे गहरा राज़ (कि भगवान को प्रेम से कैसे पाया जाए) उसके दिमाग में डाउनलोड (Download) करते हैं।
        """.trimIndent(),
        english = """
            The Supreme Personality of Godhead declared: My dear Arjuna, because you are completely free from envy and never find fault in Me (Anasuyave), I shall now impart unto you this absolute most confidential, deeply hidden knowledge and secret (Guhyatamam).
            I will reveal both the theoretical knowledge (Jnanam) and the absolute practical realization of it (Vijnana-sahitam), knowing which you shall be completely freed and eternally liberated from the miseries of material existence (Mokshyase 'shubhat).
            At the spectacular dawn of the Ninth Chapter, Lord Sri Krishna is officially unlocking the absolute most 'Highly Classified Cosmic Secret' (Guhyatamam) of the entire universe.
            This profound spiritual science is absolutely not cheap public information meant to be randomly broadcasted to the ignorant masses. The Lord explicitly reveals the exact 'Master-Password' required to access this data.
            The Password is: 'Anasuyave' (Possessing Absolute Zero Envy).
            When a toxic, arrogant mortal hears about the staggering supremacy and majestic powers of God, his fragile ego is instantly bruised, and he begins aggressively finding faults, thinking, "Why is God so arrogantly praising Himself?"
            But Arjuna's heart is immaculately pure. He absolutely does not burn with jealousy; instead, he rejoices upon hearing the Lord's glories. 
            The Supreme Lord declares that only when the toxic virus of 'Envy' is completely deleted from a human's hard drive, does God officially initiate the download of His ultimate, most intimate secret (Pure Devotion) into that soul, which permanently liberates him from the matrix ('Mokshyase ashubhat').
        """.trimIndent()
    ),
    Shloka(
        id = 2,
        sanskrit = """
            राजविद्या राजगुह्यं पवित्रमिदमुत्तमम् |
            प्रत्यक्षावगमं धर्म्यं सुसुखं कर्तुमव्ययम् || २ ||
        """.trimIndent(),
        hindi = """
            यह (जो ज्ञान मैं तुम्हें देने जा रहा हूँ) सभी विद्याओं का राजा (राजविद्या) है, सभी रहस्यों का राजा (राजगुह्यं) है, और यह अत्यंत पवित्र (पवित्रम्) तथा उत्तम है।
            यह साक्षात् प्रत्यक्ष अनुभव (Practical Realization / प्रत्यक्षावगमं) कराने वाला है, यह धर्म के बिल्कुल अनुकूल (धर्म्यं) है, इसका आचरण करना (इसे करना) बहुत ही आसान और सुखदायक (सुसुखं कर्तुम्) है, और यह कभी नष्ट न होने वाला (अव्ययम्) है।
            यह श्लोक 'भक्तियोग' (Devotional Service) का सबसे शानदार 'सर्टिफिकेट' (Certificate) है। भगवान अपने इस रास्ते (भक्ति) की 6 सबसे बड़ी सुपर-क्वालिटीज़ (Super-qualities) बता रहे हैं:
            १. 'राजविद्या': दुनिया में मेडिकल, इंजीनियरिंग जैसी हज़ारों विद्याएं हैं, लेकिन यह आत्मज्ञान उन सब साइंस (Science) का 'राजा' है।
            २. 'राजगुह्यं': यह सीक्रेट्स का भी सीक्रेट है (The King of Secrets)।
            ३. 'पवित्रम्': यह पापी से पापी इंसान को भी एक सेकंड में शुद्ध कर देता है।
            ४. 'प्रत्यक्षावगमं': यह कोई अंधी आस्था (Blind faith) नहीं है। जब आप भक्ति करते हैं, तो आपको भगवान की प्रेजेंस (Presence) का डायरेक्ट और प्रैक्टिकल अनुभव (Direct Experience) इसी लाइफ में होने लगता है।
            ५. 'सुसुखं कर्तुम्': यह सबसे बेहतरीन पॉइंट है! दूसरे योगों में इंसान को भूखा रहना पड़ता है या सिर के बल खड़ा होना पड़ता है। लेकिन भक्ति (जैसे भगवान को प्रेम से खाना खिलाना, कीर्तन करना) करने में बहुत 'मज़ा' (Joyful/सुसुखं) आता है।
            ६. 'अव्ययम्': एक बार भक्ति का अकाउंट खुल गया, तो वह कभी एक्सपायर (Expire/नष्ट) नहीं होता, वह हमेशा के लिए रहता है।
        """.trimIndent(),
        english = """
            This knowledge is the absolute King of Education (Raja-vidya), the most profound King of all secrets (Raja-guhyam), and the purest, most supreme of all knowledge (Pavitram idam uttamam).
            It provides direct, practical perception and experiential realization of the self (Pratyakshavagamam); it is the perfection of all religion (Dharmyam); it is extremely joyful and wonderfully easy to perform (Su-sukham kartum), and it is entirely everlasting and imperishable (Avyayam).
            This spectacular verse serves as the absolute, ultimate 'Cosmic Certificate of Authentication' for the path of 'Bhakti Yoga' (Pure Devotion). The Lord lists its 6 staggeringly supreme qualities:
            1. 'Raja-vidya': There are millions of material sciences like quantum physics and medicine, but this spiritual science is officially the absolute undisputed 'King of all Knowledge'.
            2. 'Raja-guhyam': It is the ultimate King of all highly classified secrets.
            3. 'Pavitram': It acts as a titanium-grade purifier, capable of instantly cleansing the most horrific sinner.
            4. 'Pratyakshavagamam': This is absolutely NOT a path of blind, dogmatic faith. When you execute this Yoga, you tangibly, practically, and directly 'Experience' God's presence in real-time, right here in this biological life.
            5. 'Su-sukham kartum': This is the ultimate Game-Changer! Other mystic paths demand brutal physical torture, extreme fasting, and holding the breath. But Bhakti (like singing, dancing, and offering delicious food to God with love) is incredibly joyful, ecstatic, and blissfully 'Easy to perform'.
            6. 'Avyayam': Once this eternal spiritual bank account is opened, it absolutely never expires, degrades, or perishes.
        """.trimIndent()
    ),
    Shloka(
        id = 3,
        sanskrit = """
            अश्रद्दधानाः पुरुषा धर्मस्यास्य परन्तप |
            अप्राप्य मां निवर्तन्ते मृत्युसंसारवर्त्मनि || ३ ||
        """.trimIndent(),
        hindi = """
            हे परन्तप (शत्रुओं को तपाने वाले अर्जुन)! जो मनुष्य इस परम धर्म (भक्ति के मार्ग) में बिल्कुल भी श्रद्धा (विश्वास) नहीं रखते (अश्रद्दधानाः पुरुषाः)...
            वे मुझे (ईश्वर को) प्राप्त नहीं कर पाते (अप्राप्य मां), और इस मृत्यु-रूपी संसार के भयंकर चक्र (जन्म और मरण के रास्ते) में ही बार-बार लौटकर आते रहते हैं (निवर्तन्ते मृत्युसंसारवर्त्मनि)।
            ज्ञान की महिमा बताने के बाद, श्रीकृष्ण एक बहुत ही कड़वी और डरावनी चेतावनी (Warning) दे रहे हैं।
            यह इतना आसान और सुखदायक रास्ता है, फिर भी सब लोग इसमें क्यों नहीं आते? इसका कारण है: 'अश्रद्धा' (Lack of Faith / शक)।
            कुछ लोग अपने बौद्धिक अहंकार (Intellectual Ego) में इतने अंधे होते हैं कि वे कहते हैं, "भला भगवान को प्यार करने से या केवल उनका नाम जपने से मोक्ष कैसे मिल सकता है? यह तो अंधविश्वास है!" 
            भगवान ऐसे 'अश्रद्दधानाः' (डाउट करने वाले और श्रद्धाहीन) लोगों पर अपना अंतिम फैसला सुनाते हैं। वे कहते हैं कि ऐसे अहंकारी लोग मुझे कभी नहीं पा सकते।
            और जो ईश्वर को नहीं पा सका, उसका क्या होता है? प्रकृति उसे कॉलर से पकड़कर 'मृत्यु-संसार-वर्त्मनि' (The terrifying cycle of birth, disease, old age, and death) में वापस धकेल देती है।
            जब तक इंसान का 'शक' खत्म नहीं होता और वह 100% 'श्रद्धा' (Faith) के साथ ईश्वर के सामने नहीं झुकता, वह इस भयंकर मैट्रिक्स (Matrix) के कोल्हू में बार-बार पिसता ही रहेगा।
        """.trimIndent(),
        english = """
            O conqueror of enemies (Parantapa)! Those ordinary men who are entirely faithless and possess absolutely no trust in this supreme path of devotional service (Ashraddadhanah purushah)...
            can absolutely never achieve Me (Aprapya mam), O Arjuna. Therefore, they inevitably and violently fall back into the terrifying, continuous cycle of birth and death in this material world (Nivartante mrityu-samsara-vartmani).
            After highly glorifying the beautiful path of devotion, Sri Krishna issues a brutally terrifying, cold-blooded cosmic warning.
            If this path is so joyful and easy, why doesn't the entire human race adopt it? The single fatal roadblock is: 'Ashraddha' (Absolute lack of Faith / Toxic Skepticism).
            Many arrogant intellectuals, blinded by their massive egos and tiny logic, mockingly claim: "How can simply chanting God's name or serving Him with love grant ultimate liberation? This is just cheap, mythological superstition!"
            The Supreme Lord delivers His absolute final verdict upon such 'Ashraddadhanah' (faithless, cynical skeptics). He declares they will absolutely never, ever attain Him.
            And what is the horrifying destiny of those who fail to attain God? Material nature violently grabs them by the throat and ruthlessly throws them right back into the 'Mrityu-samsara-vartmani' (The horrific, inescapable meat-grinder of continuous birth, disease, old age, and brutal death).
            Until a human forcefully deletes his toxic skepticism and surrenders with 100% titanium 'Faith', he will perpetually rot and respawn inside this agonizing matrix forever.
        """.trimIndent()
    ),
    Shloka(
        id = 4,
        sanskrit = """
            मया ततमिदं सर्वं जगदव्यक्तमूर्तिना |
            मत्स्थानि सर्वभूतानि न चाहं तेष्ववस्थितः || ४ ||
        """.trimIndent(),
        hindi = """
            यह पूरा का पूरा ब्रह्मांड (सर्वं जगत्) मेरे इस 'अव्यक्त' (निराकार / न दिखाई देने वाले) स्वरूप के द्वारा पूरी तरह से व्याप्त (भरा हुआ / Pervaded) है।
            संसार के सभी प्राणी और वस्तुएं (सर्वभूतानि) केवल मुझमें ही स्थित हैं (मत्स्थानि), परंतु मैं (ईश्वर) उनके अंदर स्थित नहीं हूँ (न चाहं तेष्ववस्थितः)।
            यह श्लोक 'क्वांटम अध्यात्म' (Quantum Spirituality) का सबसे भयंकर और दिमाग घुमा देने वाला (Mind-bending) रहस्य है! भगवान अपनी 'अचिन्त्य शक्ति' (Inconceivable Power) बता रहे हैं।
            १. 'मया ततमिदं सर्वं': जिस तरह हवा पूरे आसमान में फैली है, उसी तरह भगवान का 'अव्यक्त' (Invisible/Wi-Fi) रूप इस ब्रह्मांड के हर परमाणु (Atom) में फैला हुआ है।
            २. 'मत्स्थानि सर्वभूतानि': यह ब्रह्मांड कोई आज़ाद जगह नहीं है; सारे ग्रह, गैलेक्सी और हम इंसान भगवान के ही विशाल शरीर के अंदर मौजूद हैं।
            लेकिन तीसरी लाइन इंसान का दिमाग हिला देती है: "न चाहं तेष्ववस्थितः" (लेकिन मैं उनके अंदर नहीं हूँ!)।
            इसका क्या मतलब है? अगर सब कुछ भगवान में है, तो भगवान उनके अंदर क्यों नहीं हैं?
            इसका मतलब है 'अनासक्ति' (Absolute Detachment)। जिस तरह एक राजा के राज्य में सारी प्रजा राजा के अधीन (राजा में) होती है, लेकिन राजा हर इंसान के घर में जाकर नहीं बैठता (वह स्वतंत्र है)।
            उसी तरह, भगवान इस गंदी और भौतिक दुनिया को 'सपोर्ट' (Support) तो कर रहे हैं, लेकिन वे खुद इस भौतिक दुनिया से 100% डिटैच (Detached/अलग) और स्वतंत्र हैं। भौतिक दुनिया के किसी भी दुःख या पाप का असर भगवान पर नहीं पड़ता।
        """.trimIndent(),
        english = """
            By Me, in My unmanifested, invisible form (Avyakta-murtina), this entire universe is completely pervaded and saturated (Maya tatam idam sarvam).
            Absolutely all living entities and cosmic manifestations are situated entirely within Me (Mat-sthani sarva-bhutani), but I am absolutely not situated within them (Na chaham teshv avasthitah).
            This verse is the absolute pinnacle of mind-bending 'Quantum Spirituality' and mystical cosmic engineering! The Lord is revealing the staggering paradox of His 'Inconceivable Power'.
            1. 'Maya tatam idam sarvam': Just as the invisible Wi-Fi signal saturates an entire room, the Lord's 'Avyakta' (Invisible/Unmanifest) energy completely, flawlessly pervades and penetrates every single microscopic atom of this multiverse.
            2. 'Mat-sthani sarva-bhutani': This physical universe is absolutely not floating randomly in empty space; billions of galaxies and living entities are suspended and resting perfectly inside the infinite body of God.
            But the third line completely short-circuits human logic: "Na chaham teshv avasthitah" (Yet, I am absolutely NOT situated in them!).
            What does this staggering paradox mean? If everything rests in God, how is God not in them?
            It signifies 'Absolute, Titanium Detachment'. Imagine a billionaire CEO; the entire mega-corporation rests on his authority (in him), but the CEO does not personally sit inside the filthy factory machines (he is entirely independent and separate).
            Similarly, the Supreme Lord effortlessly supports and sustains the entire toxic material matrix, yet He remains 100% completely 'Unplugged', detached, and physically aloof from it. The dirt, miseries, and sins of the matrix absolutely never touch His supreme transcendental form.
        """.trimIndent()
    ),
    Shloka(
        id = 5,
        sanskrit = """
            न च मत्स्थानि भूतानि पश्य मे योगमैश्वरम् |
            भूतभृन्न च भूतस्थो ममात्मा भूतभावनः || ५ ||
        """.trimIndent(),
        hindi = """
            और वास्तव में (गहराई से देखा जाए तो) ये सभी प्राणी मुझमें स्थित भी नहीं हैं! तुम मेरे इस अकल्पनीय 'ईश्वरीय योग' (जादुई शक्ति / योगमैश्वरम्) को देखो!
            मैं सभी प्राणियों को धारण करने वाला (बनाए रखने वाला / भूतभृत्) और सभी प्राणियों को उत्पन्न करने वाला (भूतभावनः) हूँ, फिर भी मेरी आत्मा वास्तव में उन प्राणियों में स्थित नहीं है (न च भूतस्थो)।
            अगर 4था श्लोक आपके लिए कन्फ्यूज़िंग (Confusing) था, तो यह श्लोक एक और बड़ा आध्यात्मिक 'धमाका' (Explosion) है!
            भगवान पिछले श्लोक में कहते हैं "सब कुछ मेरे अंदर है।" और अब इस श्लोक की पहली ही लाइन में कहते हैं: "न च मत्स्थानि भूतानि" (सच्चाई तो यह है कि ये प्राणी मेरे अंदर भी नहीं हैं!)
            यह कोई भूल-चूक नहीं है; श्रीकृष्ण हँसते हुए कह रहे हैं: "पश्य मे योगमैश्वरम्" (मेरी इस जादूगरी और ईश्वरीय शक्ति को देखो!)
            भगवान समझा रहे हैं कि भौतिक चीज़ों (ग्रहों, तारों) का 'आध्यात्मिक ईश्वर' (Spiritual God) के साथ कोई सीधा फिजिकल कनेक्शन (Physical connection) हो ही नहीं सकता।
            जैसे किसी सपने (Dream) में आप एक बहुत बड़ा पहाड़ देखते हैं। वह पहाड़ आपके ही दिमाग (मुझमें) से पैदा हुआ है, लेकिन जब आप जागते हैं तो क्या वह पहाड़ सच में आपके दिमाग के अंदर होता है? नहीं!
            उसी तरह, भगवान इस पूरी सृष्टि को पैदा करते हैं (भूतभावनः) और उसे चलाते हैं (भूतभृत्), लेकिन उनका स्वरूप इतना 'विशुद्ध और आध्यात्मिक' है कि इस भौतिक दुनिया की कोई भी चीज़ उन्हें छू तक नहीं सकती। वे सब कुछ करते हुए भी 100% 'शून्य और निर्लिप्त' (Completely Aloof) रहते हैं।
        """.trimIndent(),
        english = """
            And yet, in absolute reality, everything that is created does not even rest in Me (Na cha mat-sthani bhutani)! Just behold My unimaginable, supreme mystic opulence and divine magic (Pashya me yogam aishvaram)!
            Although I am the absolute maintainer and sustainer of all living entities (Bhuta-bhrit), and although I am the original creator of everything (Bhuta-bhavanah), My actual Self is completely aloof and absolutely not situated within this cosmic manifestation (Na cha bhuta-stho mamatma).
            If Verse 4 temporarily melted your brain, this spectacular verse detonates an absolute spiritual Nuclear Explosion!
            In the previous verse, the Lord declared, "Everything rests in Me." And now, in the very first line here, He dramatically contradicts it: "Na cha mat-sthani bhutani" (Actually, in absolute truth, these entities do NOT even rest in Me!)
            This is absolutely not a mistake; Sri Krishna is smiling and declaring: "Pashya me yogam aishvaram" (Behold the staggering, mind-bending paradox of My ultimate Mystic Opulence!)
            The Lord is explaining that a dead, physical entity (like a planet or a human body) cannot possibly have a direct, tangible, physical connection with the 100% pure spiritual Supreme Lord.
            Imagine you generate a massive mountain inside a Dream. That mountain exists entirely within your brain, but when you wake up, is there actually a physical mountain inside your skull? NO!
            Similarly, the Lord violently engineers (Bhuta-bhavanah) and flawlessly sustains (Bhuta-bhrit) the entire material matrix, yet His transcendental form is so staggeringly pure that this dirty physical universe cannot touch Him. He executes everything while remaining 100% utterly Aloof and Detached.
        """.trimIndent()
    ),
    Shloka(
        id = 6,
        sanskrit = """
            यथाकाशस्थितो नित्यं वायुः सर्वत्रगो महान् |
            तथा सर्वाणि भूतानि मत्स्थानीत्युपधारय || ६ ||
        """.trimIndent(),
        hindi = """
            जिस प्रकार हर जगह (सर्वत्र) बहने वाली यह महान और भयंकर हवा (वायुः) हमेशा आकाश (स्पेस / Space) के भीतर ही स्थित रहती है (आकाशस्थितो नित्यं)...
            ठीक उसी प्रकार तुम यह जान लो (उपधारय) कि ब्रह्मांड के सभी प्राणी और सारी भौतिक सृष्टि केवल मुझमें ही स्थित (मत्स्थानि) है (फिर भी मैं उनसे अलग हूँ)।
            अर्जुन (और हमारे) दिमाग की नसें पिछले श्लोकों के "मैं सब में हूँ, पर मैं उनमें नहीं हूँ" वाले रहस्य को समझ नहीं पा रही थीं। 
            इसलिए भगवान इस अकल्पनीय (Inconceivable) साइंस को दुनिया के सबसे शानदार और परफेक्ट (Perfect) उदाहरण से समझाते हैं।
            भगवान कहते हैं, "ज़रा आकाश (Space/Vacuum) को देखो।" अंतरिक्ष (Space) के अंदर ही करोड़ों मील की रफ़्तार से भयंकर तूफानी हवाएं (वायु) चलती हैं। हवा आकाश के बाहर नहीं जा सकती, वह हमेशा आकाश के 'अंदर' ही रहती है।
            लेकिन क्या वह भयंकर हवा आकाश (Space) को हिला पाती है? क्या हवा की धूल से आकाश गंदा होता है? बिल्कुल नहीं! आकाश इतना 'सूक्ष्म' (Subtle) और 'अनासक्त' (Detached) है कि तूफानी हवा उसके अंदर रहते हुए भी उसे छू तक नहीं पाती। आकाश हमेशा अछूता और स्थिर रहता है।
            बिल्कुल इसी तरह, यह करोड़ों गैलेक्सी (Galaxies), देवता और इंसान रूपी 'तूफानी हवा' मुझ परमेश्वर रूपी 'आकाश' के अंदर ही पैदा होती है और उड़ती है। लेकिन इस भौतिक दुनिया के किसी भी तूफान, पाप या प्रलय का मुझ (भगवान) पर 1% भी असर नहीं पड़ता। मैं हमेशा अछूता रहता हूँ।
        """.trimIndent(),
        english = """
            Understand this absolutely clearly: just as the mighty, massive wind, blowing everywhere without limit (Vayuh sarvatra-go mahan), constantly rests entirely within the vast, empty sky or ether (Yathakasha-sthito nityam)...
            in the exact same perfect manner, you should know definitively that all created beings and cosmic manifestations rest flawlessly entirely within Me (Tatha sarvani bhutani mat-sthani ity upadharaya).
            Arjuna's human brain (and ours) was likely completely short-circuiting trying to decode the massive cosmic paradox of the previous verses ("I hold everything, but I am in nothing").
            Therefore, the Lord graciously delivers the absolute most spectacularly flawless and easily understandable physical analogy in the universe to decode this high-level physics.
            The Lord instructs: "Look at the massive Vacuum of Space (Akasha)." Inside this infinite Space, terrifying, violently powerful hurricane winds (Vayu) blow relentlessly at thousands of miles per hour. The wind absolutely cannot exit space; it exists 100% strictly 'Inside' Space.
            But does that violent, destructive wind ever successfully shake, scratch, or dirty the actual Space? Absolutely Not! Space is so incredibly 'Subtle' and 'Detached' that the raging wind exists inside it without ever actually touching it. Space remains completely unbothered, pure, and neutral.
            In the exact same way, this chaotic, roaring 'Hurricane' of billions of galaxies, humans, and demigods physically exists and spins directly inside the infinite 'Space' of My Supreme Body. Yet, absolutely none of their toxic sins, destructive wars, or planetary annihilations can ever affect Me even 1%. I remain infinitely untouched.
        """.trimIndent()
    ),
    Shloka(
        id = 7,
        sanskrit = """
            सर्वभूतानि कौन्तेय प्रकृतिं यान्ति मामिकाम् |
            कल्पक्षये पुनस्तानि कल्पादौ विसृजाम्यहम् || ७ ||
        """.trimIndent(),
        hindi = """
            हे कुन्तीपुत्र (कौन्तेय)! 'कल्प' (ब्रह्मा के जीवन का एक चक्र) के पूर्ण रूप से समाप्त होने पर (कल्पक्षये / महाप्रलय के समय), ब्रह्मांड के सभी प्राणी मेरी इस 'प्रकृति' (मूल भौतिक ऊर्जा) में ही विलीन (वापस समा) हो जाते हैं (यान्ति मामिकाम्)।
            और फिर जब नए कल्प की शुरुआत (कल्पादौ / सृष्टि का समय) होती है, तो मैं उन सभी प्राणियों को दोबारा उनकी पुरानी अवस्था के अनुसार उत्पन्न (पैदा) करता हूँ (विसृजाम्यहम्)।
            भगवान श्रीकृष्ण यहाँ ब्रह्मांड के 'रीसाइक्लिंग सिस्टम' (Universal Recycling System / Big Bang & Big Crunch) का पूरा टाइम-टेबल (Timetable) बता रहे हैं।
            यह भौतिक दुनिया एक 'लूप' (Loop) में चलती है। 'कल्पक्षय' का मतलब है वह भयंकर 'महाप्रलय' (Doomsday) जब ब्रह्मा जी का समय पूरा हो जाता है। 
            उस महाप्रलय में यह पूरी दुनिया—सारे इंसान, जानवर, चाँद-तारे, और यहाँ तक कि स्वर्ग के देवता भी—पूरी तरह नष्ट हो जाते हैं और भगवान की उस अदृश्य 'मूल प्रकृति' (Dark Matter / डार्क एनर्जी) में एक 'ज़िप फाइल' (Zip file) की तरह कंप्रेस (Compress) होकर सो जाते हैं।
            करोड़ों साल बाद, जब भगवान फिर से दुनिया बनाने का फैसला करते हैं ('कल्पादौ'), तो वे कोई नया मटेरियल (Material) इस्तेमाल नहीं करते।
            वे उसी पुरानी 'ज़िप फाइल' को दोबारा खोलते हैं (विसृजामि)। जिस आत्मा ने पिछले जन्म में जो भी कर्म (पाप/पुण्य) किए थे, भगवान उसे बिल्कुल उसी कर्म के हिसाब से दोबारा नया शरीर देकर इस मैट्रिक्स (Matrix) में वापस भेज देते हैं। यह क्रिएशन और डिस्ट्रक्शन (Creation & Destruction) का कभी न रुकने वाला ऑटोमैटिक चक्र है।
        """.trimIndent(),
        english = """
            O son of Kunti (Kaunteya), at the exact end of each millennium (Kalpa-kshaye / the ultimate cosmic annihilation), absolutely all material manifestations and living entities enter directly into My original, unmanifested material nature (Prakritim yanti mamikam).
            And again, at the absolute beginning of the next millennium (Kalpadau / the new creation), by My supreme potency, I once again massively manifest and recreate them all (Punas tani visrijamy aham).
            Lord Sri Krishna is explicitly decoding the absolute, terrifying 'Universal Recycling System' (The cosmic loop of the Big Bang and Big Crunch) here.
            This physical matrix operates strictly on an infinite, automated Loop. 'Kalpa-kshaye' refers to the horrific 'Ultimate Doomsday' when Lord Brahma's massive lifespan officially expires.
            During this violent annihilation, absolutely everything—all humans, apex predators, stars, galaxies, and even the powerful celestial demigods—are brutally vaporized and 'Compressed' exactly like a Zip-file into God's invisible, dormant 'Original Material Nature' (Dark Energy / Prakriti), where they sleep in suspended animation.
            Billions of years later, when the Supreme Lord flips the switch to restart the Matrix ('Kalpadau'), He absolutely does not create new random souls.
            He simply 'Unzips' and extracts that exact same dormant file (Visrijami). According to the exact strict karmic data (sins and merits) accumulated by the soul before the previous Doomsday, the Lord automatically manufactures and assigns them a new biological body, throwing them forcefully back into the rat race. This is the inescapable, eternal cycle of cosmic recycling.
        """.trimIndent()
    ),
    Shloka(
        id = 8,
        sanskrit = """
            प्रकृतिं स्वामवष्टभ्य विसृजामि पुनः पुनः |
            भूतग्राममिमं कृत्स्नमवशं प्रकृतेर्वशात् || ८ ||
        """.trimIndent(),
        hindi = """
            मैं अपनी ही इस भौतिक प्रकृति (माया/मूल शक्ति) को अपने पूर्ण नियंत्रण में रखकर (स्वामवष्टभ्य)...
            प्रकृति के गुणों के कारण पूरी तरह से 'विवश और लाचार' (अवशं) हुए, प्राणियों के इस पूरे के पूरे विशाल समूह (कृत्स्नम् भूतग्रामम्) को उनके कर्मों के अनुसार बार-बार (पुनः पुनः) उत्पन्न (पैदा) करता हूँ (विसृजामि)।
            यह श्लोक इंसान के अहंकार (Ego) को एक बार फिर से ज़मीन पर पटक देता है। इंसान सोचता है कि "मैं बहुत आज़ाद हूँ, मैं जो चाहूँ वो बन सकता हूँ।"
            लेकिन भगवान सच्चाई बताते हैं। वे कहते हैं कि जब मैं नई दुनिया (Creation) बनाता हूँ, तो इंसान की कोई मर्ज़ी (Choice) नहीं चलती!
            यह पूरा का पूरा 'भूतग्राम' (हम सारे जीवों का झुंड) पूरी तरह से 'अवश' (Helpless / बेबस और लाचार) है। क्यों? "प्रकृतेर्वशात्" (क्योंकि हम अपने ही पिछले जन्मों के कर्मों और प्रकृति के गुणों के गुलाम हैं)।
            अगर किसी ने पिछले जन्म में बहुत पाप किए हैं, तो वह लाख चाहे, उसे इस जन्म में राजा नहीं बनाया जाएगा। प्रकृति उसे खींचकर एक सूअर या कीड़े के शरीर में जबरदस्ती डाल देगी।
            भगवान कहते हैं, "मैं अपनी माया (प्रकृति) को कमांड (Command / अवष्टभ्य) देता हूँ, और वह मशीन तुम सब आत्माओं को तुम्हारे कर्मों के हिसाब से नए-नए शरीरों में बार-बार ('पुनः पुनः') पैक करके धरती पर फेंकती रहती है।"
            हम सब इस विशाल 'कर्म की मशीन' के अंदर केवल एक लाचार कच्चा माल (Raw Material) हैं। इस मशीन से बाहर निकलने का सिर्फ एक रास्ता है—भगवान की शरणागति!
        """.trimIndent(),
        english = """
            Completely taking hold of and entering into My own material nature (Prakritim svam avashtabhya), I repeatedly, again and again (Punah punah), manifest and create...
            this entire vast cosmic multitude of living entities (Bhutagramam imam kritsnam), who are completely helpless and violently forced (Avasham) to take birth by the iron-clad laws and force of material nature (Prakriter vashat).
            This phenomenally brutal verse violently grabs human arrogance by the throat and smashes it into the dirt. An ignorant mortal heavily hallucinates, "I am a totally free, independent entity; I can be whatever I want."
            The Lord brutally exposes the terrifying reality. He declares that during the mass re-creation of the universe, humans have absolutely ZERO 'Free Will' or choice regarding their destiny!
            This entire massive swarm of billions of souls ('Bhutagramam') is completely, pathetically 'Avasham' (100% Helpless, paralyzed, and totally powerless). Why? "Prakriter vashat" (Because they are heavily enslaved and handcuffed by the inescapable algorithms of their own past Karma and the modes of nature).
            If a human committed horrific, toxic sins in his previous life, even if he aggressively screams to be born as a billionaire, the system will ruthlessly ignore his cries and forcefully shove his soul into the biological body of a pig or a cockroach.
            The Lord asserts, "I simply press the launch button, issuing a supreme command ('Avashtabhya') to My automated Maya software. That massive machine then ruthlessly processes your karmic data, forcefully packaging you into new biological bodies, and violently spits you back out onto earth 'Punah punah' (Again and again in an endless loop)."
            We are nothing but helpless, processed raw material trapped inside this colossal Karmic Meat-Grinder. The absolute only Emergency Exit from this nightmare is 100% surrender to the Creator of the machine!
        """.trimIndent()
    ),
    Shloka(
        id = 9,
        sanskrit = """
            न च मां तानि कर्माणि निबध्नन्ति धनञ्जय |
            उदासीनवदासीनमसक्तं तेषु कर्मसु || ९ ||
        """.trimIndent(),
        hindi = """
            हे धनञ्जय (अर्जुन)! सृष्टि को बनाने और मिटाने के ये भयंकर कर्म मुझे (भगवान को) बिल्कुल भी नहीं बांधते (न निबध्नन्ति)।
            क्योंकि मैं उन सभी कर्मों में किसी भी प्रकार की आसक्ति या स्वार्थ नहीं रखता (असक्तं), और मैं एक 'उदासीन' (Neutral / तटस्थ दर्शक) की तरह उन कर्मों से पूरी तरह अलग होकर स्थित रहता हूँ (उदासीनवदासीनम्)।
            यहाँ अर्जुन के (या हमारे) दिमाग में एक बहुत बड़ा 'लॉजिकल सवाल' (Logical Question) आ सकता है: "हे कृष्ण! आप कहते हैं कि जो भी कर्म करता है, वह कर्म के बंधन में फँस जाता है। आप करोड़ों ब्रह्मांड बनाते हैं, अरबों लोगों को मारते हैं (प्रलय में)। तो क्या आपको इतने बड़े कर्मों का पाप या बंधन नहीं लगता?"
            भगवान इस डाउट (Doubt) को 100% क्लियर (Clear) करते हैं।
            वे कहते हैं कि कर्म कभी किसी को नहीं बांधता; कर्म के पीछे जो 'स्वार्थ और ईगो' (Attachment / आसक्ति) होता है, वह इंसान को बांधता है।
            जब भगवान यह दुनिया बनाते हैं, तो उनका इसमें 0% स्वार्थ होता है ('असक्तं')। वे दुनिया इसलिए नहीं बनाते कि उन्हें इंसानों से कोई फायदा चाहिए। 
            वे तो एक 'उदासीन' (Neutral Judge / अंपायर) की तरह अपनी कुर्सी पर बैठे रहते हैं। जैसे एक जज जब किसी अपराधी को फांसी की सज़ा सुनाता है, तो जज को हत्या का पाप नहीं लगता, क्योंकि वह यह काम अपनी दुश्मनी (Attachment) से नहीं, बल्कि एक न्यूट्रल 'ड्यूटी' (Neutral Duty) की तरह कर रहा है।
            बिल्कुल उसी तरह, भगवान ब्रह्मांड के सारे भयंकर काम (Creation & Destruction) करते हुए भी हमेशा 'कर्मों के बंधन' से पूरी तरह आज़ाद और पवित्र रहते हैं।
        """.trimIndent(),
        english = """
            O Dhananjaya (Arjuna)! Absolutely none of these massive cosmic activities and karmic creations ever bind or entangle Me in any way (Na cha mam tani karmani nibadhnanti).
            Because I remain completely unattached to all these fruitive activities (Asaktam teshu karmasu), seated entirely as though neutral, detached, and completely indifferent (Udasina-vad asinam).
            A massive, incredibly logical counter-question could effortlessly pop into a human brain here: "O Krishna! You established a strict law that whoever executes massive action gets heavily bound by karmic reactions. You actively engineer billions of galaxies and ruthlessly slaughter trillions of entities during Doomsday. Doesn't that terrifyingly massive karma bind YOU?"
            The Lord flawlessly and surgically destroys this doubt here.
            He establishes that 'Physical Action' itself possesses zero binding power; it is the toxic, selfish 'Ego and Attachment' hidden behind the action that acts as the real binding glue.
            When the Supreme Lord engineers this entire multiverse, He has exactly 0% personal, selfish agenda or craving ('Asaktam') involved. He absolutely does not create humanity to extract some pathetic benefit from them.
            He officially operates exactly like an 'Udasina' (A 100% Neutral, emotionless Supreme Judge). Just as a Supreme Court Judge who officially sentences a serial killer to the death penalty absolutely does not incur the sin of murder (because he executes it purely out of neutral duty, zero personal hatred), the Lord remains flawlessly pure.
            Thus, despite executing the most terrifyingly massive cosmic actions of ultimate Creation and Annihilation, God remains eternally immune, untangled, and 100% Karma-free.
        """.trimIndent()
    ),
    Shloka(
        id = 10,
        sanskrit = """
            मयाध्यक्षेण प्रकृतिः सूयते सचराचरम् |
            हेतुनानेन कौन्तेय जगद्विपरिवर्तते || १० ||
        """.trimIndent(),
        hindi = """
            हे कुन्तीपुत्र (कौन्तेय)! मेरी अध्यक्षता (सुपरविज़न / Under My Direction) में ही यह भौतिक प्रकृति (माया) इस संपूर्ण चर (चलने वाले) और अचर (न चलने वाले) जगत (दुनिया) को रचती है (पैदा करती है)।
            और इसी कारण से (मेरे ही निर्देश के कारण) यह संपूर्ण ब्रह्मांड बार-बार घूमता (परिवर्तित / नष्ट और पैदा) होता रहता है।
            यह श्लोक विज्ञान (Science) और अध्यात्म (Spirituality) के बीच के सबसे बड़े झगड़े को हमेशा के लिए सुलझा देता है।
            आधुनिक विज्ञान (Modern Science) कहता है कि दुनिया अपने-आप बनी है (Big Bang), प्रकृति के नियमों से सब कुछ ऑटोमैटिक (Automatic) चल रहा है, और इसके पीछे कोई भगवान नहीं है।
            श्रीकृष्ण विज्ञान की इस बात को 50% सही मानते हैं! वे कहते हैं: "हाँ, प्रकृति (Nature / Physics / Biology) ही इंसानों, ग्रहों और तारों को बना रही है। सारा 'फिजिकल काम' (Physical work) मशीन (प्रकृति) ही कर रही है।"
            लेकिन भगवान आगे जो कहते हैं, वह विज्ञान को अंधा साबित कर देता है। भगवान कहते हैं, "मयाध्यक्षेण"—यह अंधी मशीन (प्रकृति) अपने-आप कैसे डिसाइड (Decide) कर रही है कि सेब के बीज से सेब ही निकलेगा, आम नहीं? यह परफेक्ट ऑर्डर (Perfect Order) कैसे चल रहा है?
            क्योंकि इस अंधी मशीन (प्रकृति) के ऊपर मैं एक 'अध्यक्ष' (CEO / Director / Superintendent) की तरह खड़ा हूँ! मेरी देख-रेख और मेरे ही बनाए सॉफ्टवेयर (Software) के कारण यह प्रकृति इतनी परफेक्शन (Perfection) के साथ काम कर रही है और यह ब्रह्मांड का चक्र ('विपरिवर्तते') बिना रुके चल रहा है।
            प्रकृति केवल एक 3D प्रिंटर (3D Printer) है, लेकिन उस प्रिंटर में कमांड (Command) ईश्वर ही दे रहे हैं।
        """.trimIndent(),
        english = """
            This entire material nature (Prakritih), which flawlessly produces all moving and non-moving beings (Suyate sa-characharam), is working strictly under My absolute direction and supreme supervision (Mayadhyakshena).
            And it is precisely by this exact fundamental rule and underlying reason (Hetunanena), O son of Kunti, that this entire cosmic manifestation is continuously created, annihilated, and kept in motion (Jagad viparivartate).
            This spectacular verse permanently and flawlessly resolves the absolute greatest, age-old war between 'Atheistic Science' and 'Spirituality'.
            Modern empirical science arrogantly claims: "The universe was created automatically via a random Big Bang; the laws of physics and biology run everything like a blind, automated machine. There is absolutely no God behind the curtain."
            Lord Sri Krishna actually officially validates this scientific claim as 50% true! He acknowledges: "Yes, Material Nature (Physics/Biology) is indeed the physical machinery manufacturing the planets, humans, and stars. The 'Physical Labor' is completely executed by the Machine (Prakriti)."
            But the Lord drops a massive nuclear bombshell that exposes science's fatal blind spot: "Mayadhyakshena"—How exactly is this blind, dead, brainless machine (Nature) calculating with such staggering, mathematical precision that an apple seed will strictly produce an apple tree and not a dog? How is this hyper-complex cosmic order maintained?
            Because standing directly above this blind machine is ME, acting as the absolute 'Adhyaksha' (The Supreme Superintendent / The Ultimate CEO)! It is exclusively because of My flawless oversight, direction, and invisible software that this dead matter (Prakriti) operates with such terrifying perfection, keeping the massive universal wheel relentlessly spinning ('Viparivartate').
            Nature is merely a gigantic, blind 3D-Printer; but the Supreme Lord is the Master Architect typing the actual commands into the computer.
        """.trimIndent()
    ),
    Shloka(
        id = 11,
        sanskrit = """
            अवजानन्ति मां मूढा मानुषीं तनुमाश्रितम् |
            परं भावमजानन्तो मम भूतमहेश्वरम् || ११ ||
        """.trimIndent(),
        hindi = """
            जब मैं (ईश्वर) मनुष्य का शरीर (मानुषीं तनुम्) धारण करके इस पृथ्वी पर अवतार लेता हूँ, तो मूर्ख लोग (मूढाः) मेरा तिरस्कार (अपमान / अवजानन्ति) करते हैं (मुझे केवल एक साधारण इंसान मान लेते हैं)।
            क्योंकि वे सम्पूर्ण प्राणियों के 'महान ईश्वर' (Supreme Lord / भूतमहेश्वरम्) वाले मेरे उस परम और सबसे ऊँचे ईश्वरीय स्वरूप (परं भावम्) को बिल्कुल नहीं जानते (अजानन्तो)।
            यह भगवद्गीता के सबसे तीखे और इंसानी बेवकूफी (Human Stupidity) पर वार करने वाले श्लोकों में से एक है। 
            जब साक्षात् भगवान (श्रीकृष्ण) महाभारत के समय धरती पर मौजूद थे, तो दुर्योधन, शिशुपाल और कौरवों ने उनकी कोई रिस्पेक्ट (Respect) क्यों नहीं की? उन्होंने भगवान को गालियां क्यों दीं?
            भगवान उन्हें बहुत ही क्लियर (Clear) शब्द देते हैं: 'मूढाः' (महामूर्ख / Total Fools)।
            भगवान कहते हैं कि मेरा शरीर कोई हाड़-मांस का साधारण इंसान नहीं है, बल्कि मैंने अपनी दया से तुम इंसानों को ज्ञान देने के लिए इंसान जैसा रूप (Human Form) लिया है।
            लेकिन ये मूर्ख लोग (मूढाः) मेरी इस 'सिम्पलीसिटी' (Simplicity / सरलता) को मेरी 'कमज़ोरी' समझ लेते हैं। वे सोचते हैं, "अरे, यह कृष्ण तो हमारे साथ खाता है, सारथी बनकर रथ चलाता है, यह भगवान कैसे हो सकता है?"
            चूँकि उनका दिमाग बहुत छोटा है, इसलिए वे मेरे उस 'परं भाव' (Supreme Cosmic Identity) को देख ही नहीं पाते कि यह साधारण सा दिखने वाला कृष्ण ही असल में 'भूतमहेश्वरम्' (पूरे ब्रह्मांड और करोड़ों गैलेक्सीज़ का सुप्रीम बॉस) है। 
            आज भी जो लोग कृष्ण को केवल एक चालाक राजनीतिज्ञ या सिर्फ एक ऐतिहासिक पुरुष मानते हैं, भगवान उन्हें सीधे 'मूर्ख' (मूढ़) की कैटेगरी (Category) में डालते हैं।
        """.trimIndent(),
        english = """
            Fools, completely deriding and mocking Me (Avajananti mam mudha), deeply misunderstand Me when I descend in this seemingly ordinary human form (Manushim tanum ashritam).
            They absolutely do not know and blindly ignore My supreme, transcendental nature (Param bhavam ajananto) as the absolute Supreme Lord and ultimate proprietor of all that be (Mama bhuta-maheshvaram).
            This is one of the most incredibly sharp, brutally direct verses in the Gita, aggressively attacking the absolute pinnacle of 'Human Stupidity' and materialistic arrogance.
            When the Supreme Lord (Sri Krishna) was physically walking the earth during the Mahabharata, why did toxic tyrants like Duryodhana and Shishupala absolutely fail to respect Him? Why did they hurl filthy insults at the Creator of the universe?
            The Lord accurately brands them with a highly precise clinical term: 'Mudhas' (Colossal, brainless Fools).
            The Lord explains: My body is absolutely not constructed from cheap biological meat and bones. Out of My infinite compassion, I have purposefully masked My terrifying, blinding cosmic majesty into a sweet, approachable 'Human Form' just so I can intimately interact with you.
            But these idiotic 'Mudhas' tragically mistake My supreme 'Simplicity and Humility' for biological 'Weakness'. They arrogantly laugh, "Oh look, this Krishna eats with us and works as a petty chariot driver; how on earth can He be God?"
            Because their toxic brains are microscopic, they suffer a total inability to perceive My 'Param Bhavam' (Supreme Cosmic Reality)—that this seemingly sweet, ordinary boy is literally the 'Bhuta-maheshvaram' (The undisputed, terrifying Supreme Boss and owner of trillions of galaxies).
            Even today, any arrogant "historian" or "scholar" who reduces Lord Krishna to merely a clever diplomat or a mythical hero is officially classified by God Himself in the pathetic category of a 'Mudha'.
        """.trimIndent()
    ),
    Shloka(
        id = 12,
        sanskrit = """
            मोघाशा मोघकर्माणो मोघज्ञाना विचेतसः |
            राक्षसीमासुरीं चैव प्रकृतिं मोहिनीं श्रिताः || १२ ||
        """.trimIndent(),
        hindi = """
            जो लोग इस प्रकार मुझे (ईश्वर को) साधारण इंसान मानकर मेरा अपमान करते हैं, उनकी सारी आशाएं (उम्मीदें) व्यर्थ हैं (मोघाशा), उनके सारे कर्म (मेहनत) व्यर्थ हैं (मोघकर्माणो), और उनका सारा ज्ञान (पढ़ाई-लिखाई) भी पूरी तरह व्यर्थ (मोघज्ञाना) है।
            वे लोग जिनका विवेक पूरी तरह मर चुका है (विचेतसः), ऐसे भटके हुए लोग राक्षसों और असुरों (Demons) जैसी भयंकर और मोह में डालने वाली (मोहिनीं) आसुरी प्रकृति को ही धारण करते हैं (श्रिताः)।
            यह श्लोक उन लोगों का 'फाइनल रिज़ल्ट' (Final Result / कड़वा अंत) बताता है जिनका ज़िक्र पिछले श्लोक (मूढ़) में किया गया था।
            जो इंसान भगवान की सत्ता (Authority) को मानने से इनकार कर देता है और अपने अहंकार में अंधा होकर कहता है कि "मैं ही दुनिया का बॉस हूँ, भगवान कुछ नहीं होता," भगवान उसके पूरे वजूद पर तीन 'कैंसिल स्टैम्प' (Cancel Stamps) लगा देते हैं:
            १. 'मोघाशा': उसकी जिंदगी की सारी उम्मीदें (कि मैं बहुत अमीर बनूँगा, हमेशा सुखी रहूँगा) अंततः मिट्टी में मिल जाती हैं। मौत और समय उसकी सारी आशाओं को चकनाचूर कर देते हैं।
            २. 'मोघकर्माणो': वह दिन-रात जो गधों की तरह मेहनत करके महल बनाता है, उसका वह सारा 'कर्म' एक दिन ज़ीरो (व्यर्थ) हो जाता है, क्योंकि वह खाली हाथ ही नर्क में जाता है।
            ३. 'मोघज्ञाना': उसने दुनिया की चाहे कितनी भी बड़ी डिग्री (PhD) क्यों न ली हो, अगर उसने दुनिया बनाने वाले (ईश्वर) को ही नहीं जाना, तो उसका वह सारा 'ज्ञान' कूड़ा (Garbage) है।
            ऐसे 'विचेतसः' (Without common sense / बेवकूफ) लोग असल में बाहर से इंसान दिखते हैं, लेकिन अंदर से उनका सॉफ्टवेयर (Software) 'राक्षसों' (जो केवल दूसरों का खून चूसना जानते हैं) और 'असुरों' (जो भगवान से नफरत करते हैं) वाला होता है। वे जीवन भर धोखा ही खाते हैं।
        """.trimIndent(),
        english = """
            Those who are thus completely bewildered and deeply deluded are attracted entirely by demonic and atheistic views (Rakshasim asurim chaiva prakritim mohinim shritah).
            In that heavily deluded and foolish condition, all their hopes for liberation are entirely baffled and crushed (Moghasha), all their massive fruitive activities are completely defeated and useless (Mogha-karmano), and all their extensive culture of knowledge is totally reduced to zero and baffled (Mogha-jnana vichetasah).
            This terrifying verse officially issues the absolute 'Final Verdict' and catastrophic destiny of those arrogant fools (Mudhas) diagnosed in the previous verse.
            When a toxic, arrogant human violently rejects the supreme authority of God, blindly declaring, "I am the supreme boss of my life; God is a fake myth," the Supreme Lord aggressively stamps three massive 'REJECTED' cosmic seals onto his entire existence:
            1. 'Moghasha': Absolutely every single one of his desperate 'Hopes' (hallucinating that he will be eternally happy, a billionaire, and immune to death) will be brutally crushed and shattered into dust by the unforgiving force of Time.
            2. 'Mogha-karmano': He may hustle blindly for 18 hours a day, sweat blood to build a corporate empire, but 100% of his massive 'Karma' (Action) is completely 'Baffled and Useless'. He will die empty-handed and plummet straight into hell.
            3. 'Mogha-jnana': He might arrogantly flaunt prestigious PhDs and Nobel prizes, but if his tiny brain completely failed to decode the actual Creator of the universe, his entire massive library of 'Knowledge' is officially certified as worthless, pathetic 'Garbage'.
            Such 'Vichetasah' (Humans operating with absolute zero true intelligence) may physically wear human skin, but their internal psychological software has been completely hacked by 'Rakshasas' (Demons who violently exploit others) and 'Asuras' (Atheists who passionately hate God). Their entire existence is a tragic, pathetic failure.
        """.trimIndent()
    ),
    Shloka(
        id = 13,
        sanskrit = """
            महात्मानस्तु मां पार्थ दैवीं प्रकृतिमाश्रिताः |
            भजन्त्यनन्यमनसो ज्ञात्वा भूतादिमव्ययम् || १३ ||
        """.trimIndent(),
        hindi = """
            परंतु हे पार्थ (अर्जुन)! जो महान आत्मा वाले (महात्मानः) लोग हैं, वे मेरी 'दैवी प्रकृति' (Divine Nature / ईश्वरीय शक्ति) के आश्रय में रहते हैं (दैवीं प्रकृतिमाश्रिताः)।
            वे मुझे इस संपूर्ण सृष्टि का मूल कारण (उत्पत्ति का स्रोत / भूतादिम्) और अविनाशी (अव्ययम्) परमेश्वर जानकर, एकनिष्ठ मन से (यानी बिना किसी दूसरी ओर ध्यान भटकाए / अनन्यमनसो) निरंतर मेरा ही भजन (भक्ति/प्रेम) करते हैं (भजन्ति)।
            पिछले दो श्लोकों में 'मूर्खों' (Demons) की बेवकूफी बताने के बाद, अब भगवान इस श्लोक में 'सुपर-हीरोज़' (Super-heroes / महात्मनों) की प्रोफाइल (Profile) बता रहे हैं।
            'महात्मा' (Great Soul) वह नहीं है जो केवल अच्छे कपड़े पहनता है या दाढ़ी बढ़ा लेता है। महात्मा वह है जिसने अपनी 'चेतना' (Consciousness) को बहुत ऊँचा उठा लिया है।
            मूर्ख लोग राक्षसी प्रकृति (माया और लालच) के गुलाम होते हैं, लेकिन महात्माओं ने अपना कनेक्शन माया से काटकर सीधा 'दैवी प्रकृति' (भगवान की डिवाइन एनर्जी / योगमाया) से जोड़ लिया है। वे ईश्वर के प्रोटेक्शन (Protection / आश्रय) में रहते हैं।
            उन्हें यह 100% क्लियर (Clear) हो चुका है कि यह दुनिया किसी बिग-बैंग (Big-Bang) से नहीं बनी; वे जान गए हैं कि 'भूतादिम् अव्ययम्'—अर्थात् कृष्ण ही सब चीज़ों की 'स्टार्टिंग-पॉइंट' (Starting Point / मूल कारण) हैं और कभी न मिटने वाले ईश्वर हैं।
            जब इंसान को यह परम सत्य पता चल जाता है, तो उसका मन 'अनन्य' (Un-deviated / एक ही जगह लॉक) हो जाता है। वह दुनिया की फालतू चीज़ों (पैसे, नाम) में अपना टाइम वेस्ट (Waste) नहीं करता; उसका पूरा 24 घंटे का फोकस केवल और केवल भगवान से 'प्रेम' (भजन) करने में लग जाता है।
        """.trimIndent(),
        english = """
            O son of Pritha (Partha)! Those who are absolutely not deluded, the great and truly exalted souls (Mahatmanas tu), are permanently strictly situated under the direct protection of the divine, spiritual nature (Daivim prakritim ashritah).
            They are fully and relentlessly engaged in My pure devotional service and worship with absolute, undeviating minds (Bhajanty ananya-manaso), perfectly knowing Me to be the absolute original, inexhaustible Supreme Personality of Godhead (Jnatva bhutadim avyayam).
            After brutally roasting the toxic 'Demons' in the previous two verses, the Lord now brilliantly highlights the exact psychological profile of the spiritual 'Super-Heroes' (The Mahatmas).
            A 'Mahatma' (Great Soul) is absolutely not defined by his long beard, fake ascetic robes, or massive political following. A Mahatma is strictly defined by his elevated, titanium-grade 'Consciousness'.
            While ignorant fools are hopelessly enslaved by the demonic, material matrix (Maya and greed), these elite Mahatmas have completely severed that toxic connection and plugged themselves directly into the 'Daivi Prakriti' (God's pure, internal, Divine Energy / Yogamaya). They live entirely under God's VIP protection.
            Their intelligence has successfully decoded the ultimate truth: They flawlessly know ('Jnatva') that Sri Krishna is 'Bhutadim Avyayam'—the absolute, original 'Starting Point' (Source Code) of all creation and the indestructible Supreme Lord, completely overriding the random 'Big Bang' theory.
            Once a human directly accesses this staggering ultimate truth, his mind instantly becomes 'Ananya-manaso' (100% Locked, laser-focused, with zero deviation). He stops wasting his precious life chasing cheap earthly garbage (money/clout) and fiercely engages his entire existence 24/7 purely in ecstatic, loving 'Devotion' (Bhajanti) to the Supreme Lord.
        """.trimIndent()
    ),
    Shloka(
        id = 14,
        sanskrit = """
            सततं कीर्तयन्तो मां यतन्तश्च दृढव्रताः |
            नमस्यन्तश्च मां भक्त्या नित्ययुक्ता उपासते || १४ ||
        """.trimIndent(),
        hindi = """
            वे दृढ़ निश्चय वाले (दृढव्रताः) महात्मा हमेशा (सततम्) मेरे नाम और गुणों का कीर्तन (गुणगान / कीर्तयन्तो) करते रहते हैं, और मुझे प्राप्त करने के लिए लगातार सच्चा प्रयास (यतन्तः) करते रहते हैं।
            वे मुझे अत्यंत प्रेम और भक्ति के साथ बार-बार प्रणाम (नमस्यन्तः) करते हैं, और हमेशा मेरे ही ध्यान में पूरी तरह जुड़े रहकर (नित्ययुक्ता) मेरी उपासना (उपासते / पूजा) करते हैं।
            पिछले श्लोक में भगवान ने बताया कि 'महात्मा' (Great Soul) कौन है; इस श्लोक में भगवान बता रहे हैं कि वह महात्मा 24 घंटे करता क्या है (उसका रूटीन/Routine क्या है)!
            भक्ति कोई ऐसा काम नहीं है जिसे रविवार को 10 मिनट मंदिर में जाकर पूरा कर लिया जाए। एक सच्चे महात्मा की भक्ति 'सततम्' (24/7 / Non-stop) होती है।
            १. 'कीर्तयन्तो': उसका मुँह हमेशा भगवान के नाम, उनकी लीलाओं और उनकी महानता की बातें करने में (कीर्तन में) लगा रहता है। वह दुनिया की फालतू गॉसिप (Gossip) नहीं करता।
            २. 'यतन्तः दृढव्रताः': वह कोई आलसी इंसान नहीं है जो सिर्फ हाथ पर हाथ धरे बैठा रहे। वह 'दृढ़व्रती' (Titanium determination वाला) होता है। चाहे जितनी भी भयंकर मुसीबतें आएं, वह भगवान को पाने के लिए पागलों की तरह 100% 'मेहनत' (यतन्तः / Endeavor) करता है।
            ३. 'नमस्यन्तः': उसका अहंकार (Ego) पूरी तरह से ज़ीरो (Zero) हो चुका है, इसलिए वह हर समय भगवान के सामने (और हर जीव में भगवान को देखकर) अंदर ही अंदर झुकता (प्रणाम करता) रहता है।
            ४. 'नित्ययुक्ता': उसका मन परमानेंटली (Permanently) भगवान के वाई-फाई (Wi-Fi) से जुड़ा (युक्त) रहता है। इस तरह की 'एक्सट्रीम' (Extreme) और पागलपन की हद तक जाने वाली भक्ति करने वाला ही वास्तव में 'महात्मा' कहलाता है।
        """.trimIndent(),
        english = """
            Always continuously chanting My supreme glories (Satatam kirtayanto mam), heavily endeavoring with absolute, unbreakable, titanium determination (Yatantash cha dridha-vratah)...
            and constantly bowing down before Me with deep, intense love (Namasyantash cha mam bhaktya), these great souls perpetually worship Me and remain permanently united with Me in devotion (Nitya-yukta upasate).
            In the previous verse, the Lord defined exactly WHO a 'Mahatma' (Great Soul) is; in this spectacular verse, He practically reveals exactly WHAT that Mahatma does 24/7 (His daily operating routine)!
            True devotion is absolutely not a pathetic, 10-minute weekend hobby executed mechanically inside a church or temple. A genuine Mahatma's devotion operates 'Satatam' (24/7, relentlessly, Non-stop).
            1. 'Kirtayanto': His mouth and vocal cords are completely hijacked by divine love; he constantly broadcasts, sings, and loudly preaches the staggering glories, names, and pastimes of the Supreme Lord. He has absolutely zero bandwidth for toxic worldly gossip.
            2. 'Yatantah Dridha-vratah': He is absolutely not a lazy, passive dreamer. He possesses 'Dridha-vratah' (Unbreakable, military-grade titanium determination). No matter how violently the material matrix attacks him, he fiercely and aggressively 'Endeavors' (Yatantah) with 100% brute force to serve and please God.
            3. 'Namasyantah': His toxic false ego has been completely brutally assassinated and reduced to Zero. Therefore, his natural default state is to constantly, humbly bow down internally (and externally) before God in pure love (Bhakti).
            4. 'Nitya-yukta': His consciousness is permanently, eternally plugged straight into God's cosmic Wi-Fi. A human being who fiercely executes this level of 'Extreme', obsessive, unadulterated devotion is the absolute definition of a true 'Mahatma'.
        """.trimIndent()
    ),
    Shloka(
        id = 15,
        sanskrit = """
            ज्ञानयज्ञेन चाप्यन्ये यजन्तो मामुपासते |
            एकत्वेन पृथक्त्वेन बहुधा विश्वतोमुखम् || १५ ||
        """.trimIndent(),
        hindi = """
            इन (भक्तों) के अलावा, कुछ अन्य (ज्ञानी) लोग 'ज्ञान-यज्ञ' (आध्यात्मिक ज्ञान के द्वारा) मेरी पूजा और उपासना (यजन्तो मामुपासते) करते हैं।
            इन ज्ञानियों में से कुछ मुझे खुद से 'अभेद' (एक ही / एकत्वेन) मानकर पूजते हैं; कुछ मुझे 'स्वामी-सेवक' के रूप में (अलग / पृथक्त्वेन) मानकर पूजते हैं; और कुछ लोग मुझे इस ब्रह्मांड के 'विश्वरूप' (विश्वतोमुखम्) में अनेक प्रकार से (बहुधा) पूजते हैं।
            भगवान श्रीकृष्ण यहाँ बताते हैं कि जो लोग 14वें श्लोक वाली 'प्योर भक्ति' (Pure Devotion) नहीं कर पाते, वे भी भगवान को पूजते हैं, लेकिन उनका तरीका 'ज्ञान' (Knowledge/Philosophy) का होता है।
            ऐसे लोग फूल-अगरबत्ती से नहीं, बल्कि अपनी 'बुद्धि' (ज्ञान-यज्ञ) से भगवान को समझने की कोशिश करते हैं। भगवान ऐसे 'ज्ञान-योगियों' को तीन कैटेगरी (Categories) में बाँटते हैं:
            १. 'एकत्वेन' (अद्वैतवादी / Monists): ये सबसे ऊँचे दर्जे के ज्ञानी हैं जो सोचते हैं कि "मैं और भगवान अलग नहीं हैं, हम एक ही हैं (Aham Brahmasmi)।" वे भगवान को अपने भीतर ही ढूँढते हैं।
            २. 'पृथक्त्वेन' (द्वैतवादी / Dualists): ये वो ज्ञानी हैं जो सोचते हैं कि "भगवान बहुत महान (Master) हैं और मैं उनका बहुत छोटा सा अंश (Servant) हूँ।" वे भगवान को अलग मानकर उनकी महानता की पूजा करते हैं।
            ३. 'बहुधा विश्वतोमुखम्' (विश्वरूप / Pantheists): ये वो लोग हैं जिनका ज्ञान अभी बहुत कम है। वे भगवान को सीधे नहीं समझ पाते, इसलिए वे इस पूरी 'प्रकृति' (ब्रह्मांड, पहाड़, सूरज, पेड़) को ही भगवान का रूप ('विश्वरूप') मानकर उसकी पूजा करते हैं।
            भगवान कहते हैं कि ये तीनों प्रकार के ज्ञानी भी वास्तव में 'मेरी' (श्रीकृष्ण की) ही पूजा कर रहे हैं, बस उनका समझने का लेवल (Level) अलग-अलग है।
        """.trimIndent(),
        english = """
            And others, who intensively engage in the cultivation of absolute spiritual knowledge (Jnana-yajnena chapy anye), actively worship Me as the Supreme Lord (Yajanto mam upasate).
            They worship Me either as the one, indivisible, non-dual truth (Ekatvena), or as the Supreme Master separate from themselves (Prithaktvena), or in My diverse, majestic universal form which is manifested in all directions (Bahudha vishvato-mukham).
            Lord Sri Krishna acknowledges that not everyone is instantly capable of executing the 'Pure, Unalloyed Devotion' described in the previous verse. Many highly intellectual seekers approach God exclusively through the severe, analytical path of 'Philosophy and Knowledge' (Jnana-yajna).
            These philosophers do not worship using flowers or incense; they aggressively worship God by using their razor-sharp 'Intelligence' to decode the cosmos. The Lord expertly categorizes these 'Jnana-Yogis' into three distinct groups:
            1. 'Ekatvena' (The Monists / Advaitins): These are the most advanced among the philosophers. They fiercely meditate on the absolute concept of 'Oneness', realizing: "I am absolutely not different from God; the Supreme Soul and my soul are qualitatively one" (Aham Brahmasmi). They worship God within.
            2. 'Prithaktvena' (The Dualists): These intellectuals fully recognize a clear, distinct separation. They firmly believe: "God is the Infinite, Supreme Master, and I am His infinitesimal, eternal servant." They worship His staggering greatness as a separate entity.
            3. 'Bahudha Vishvato-mukham' (The Pantheists / Universalists): This is the lowest tier of philosophers. Because their intelligence cannot comprehend a personal God, they look at the gigantic, physical Universe (the mountains, the sun, the galaxies) and worship this entire massive cosmic machine as the 'Universal Form' of God.
            The Lord graciously validates all three: Regardless of which specific intellectual angle they attack from, they are ultimately, directly worshipping 'ME' (Sri Krishna), just operating at different levels of realization.
        """.trimIndent()
    ),
    Shloka(
        id = 16,
        sanskrit = """
            अहं क्रतुरहं यज्ञः स्वधाहमहमौषधम् |
            मन्त्रोऽहमहमेवाज्यमहमग्निरहं हुतम् || १६ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 16 से 19 तक भगवान अपनी 'सर्वव्यापकता' बताते हैं)
            मैं ही 'क्रतु' (वैदिक कर्मकांड) हूँ, मैं ही 'यज्ञ' (स्मार्त यज्ञ) हूँ, मैं ही पितरों को दिया जाने वाला अन्न (स्वधा) हूँ, और मैं ही रोगों को दूर करने वाली 'औषधि' (जड़ी-बूटी या अन्न) हूँ।
            मैं ही पवित्र 'मंत्र' हूँ, मैं ही 'घृत' (यज्ञ में डाला जाने वाला घी) हूँ, मैं ही यज्ञ की 'अग्नि' (आग) हूँ, और मैं ही उस अग्नि में दी जाने वाली 'आहुति' (हवन की क्रिया) हूँ।
            पिछले श्लोक में भगवान ने बताया था कि कुछ लोग पूरे 'ब्रह्मांड' (विश्वरूप) को ही भगवान मानकर पूजते हैं। अब भगवान श्रीकृष्ण साबित कर रहे हैं कि "हाँ, इस ब्रह्मांड में जो कुछ भी है, वह सब मैं ही हूँ!"
            हिन्दू धर्म में 'यज्ञ' (हवन) को सबसे बड़ा और पवित्र काम माना जाता है। भगवान यहाँ उस पूरे यज्ञ को ही 'डिकोड' (Decode) करके बता रहे हैं कि यज्ञ का हर एक पुर्जा (Component) साक्षात् कृष्ण ही हैं।
            जो नियम या विधि ('क्रतु' और 'यज्ञ') हम करते हैं—वह मैं हूँ। 
            पूर्वजों को जो 'स्वधा' (अन्न/पिंडदान) दिया जाता है—वह मैं हूँ।
            बीमारी ठीक करने के लिए या खाने के लिए जो 'औषधि' (Medicine/अन्न) है—वह मैं हूँ।
            पंडित जी जो 'मंत्र' पढ़ते हैं—वह आवाज़ भी मैं हूँ।
            जो शुद्ध 'घी' (आज्यम्) आग में डाला जाता है—वह घी मैं हूँ।
            जिस 'अग्नि' में घी डलता है—वह आग भी मैं हूँ।
            और जो अर्पण करने का 'एक्शन' (हुतम्) है—वह क्रिया भी मैं ही हूँ।
            भगवान कह रहे हैं कि जब इस दुनिया की हर चीज़ ('मैटर' और 'एक्शन' दोनों) भगवान की ही शक्ति से बनी है, तो फिर भगवान से अलग क्या है? कुछ भी नहीं! सब कुछ ईश्वर ही है।
        """.trimIndent(),
        english = """
            (Verses 16 to 19 describe the Lord's absolute Universal Omnipresence)
            I am the Vedic ritual (Kratu), I am the actual sacrifice (Yajna), I am the offering specifically made to the ancestors (Svadha), and I am the healing herb and all life-sustaining medicine (Aushadham).
            I am the transcendental, sacred chant/mantra (Mantrah), I am the clarified butter offered in the fire (Ajyam), I am the blazing fire itself (Agnir), and I am the very act of making the offering (Hutam).
            In the previous verse, the Lord mentioned that some philosophers worship the entire massive 'Universe' as God. Now, Lord Sri Krishna is aggressively proving that statement: "Yes, absolutely everything in this cosmic matrix is literally ME!"
            In Vedic culture, the grand 'Yajna' (Fire Sacrifice) is considered the absolute highest, most sacred interaction with the cosmos. The Lord surgically decodes the entire Yajna, proving that every single microscopic component of it is practically a manifestation of Krishna Himself.
            The actual Vedic rituals and rules ('Kratu' & 'Yajna')—That is Me.
            The specific oblation ('Svadha') offered to maintain departed ancestors—That is Me.
            The 'Aushadham' (life-saving herbs, food, and medicine) that cures biological diseases—That is Me.
            The incredibly powerful sound vibrations of the sacred 'Mantra' chanted by the priest—That sound is Me.
            The pure, clarified butter ('Ajyam') poured into the flames—That physical liquid is Me.
            The roaring, blazing 'Fire' (Agni) that consumes the offering—That fire is Me.
            And the very physical 'Action' of pouring the offering (Hutam)—That action is also Me.
            The Lord is dropping a staggering philosophical nuke: When absolutely every single atom of 'Matter' and every single vector of 'Action' is manufactured exclusively from God's energy, what on earth exists outside of God? Absolutely Nothing! Everything IS God.
        """.trimIndent()
    ),
    Shloka(
        id = 17,
        sanskrit = """
            पिताहमस्य जगतो माता धाता पितामहः |
            वेद्यं पवित्रमोङ्कार ऋक्साम यजुरेव च || १७ ||
        """.trimIndent(),
        hindi = """
            मैं ही इस संपूर्ण जगत (ब्रह्मांड) का पिता (Father) हूँ, मैं ही इसकी माता (Mother) हूँ, मैं ही इसका पालन-पोषण करने वाला (धाता / Sustainer) हूँ, और मैं ही इसका पितामह (Grandfather / दादा) हूँ।
            मैं ही एकमात्र 'जानने योग्य' परम सत्य (वेद्यं) हूँ, मैं ही सबको शुद्ध करने वाला (पवित्रम्) हूँ; मैं ही परम 'ॐ' (ओम् / ओंकार) हूँ, और मैं ही 'ऋग्वेद', 'सामवेद' और 'यजुर्वेद' हूँ।
            भगवान श्रीकृष्ण यहाँ इंसान के सबसे गहरे 'इमोशनल' (Emotional) और 'स्पिरिचुअल' (Spiritual) रिश्तों को अपने साथ जोड़ रहे हैं।
            दुनिया में एक बच्चे के लिए उसके माँ-बाप ही उसके भगवान होते हैं, जो उसे पैदा करते हैं और पालते हैं।
            लेकिन भगवान कहते हैं: "तुम्हारे असली माता-पिता कौन हैं? तुम्हारे ये भौतिक माता-पिता तो सिर्फ इस एक जन्म के लिए हैं। लेकिन इस पूरे ब्रह्मांड और तुम्हारी आत्मा का असली, परमानेंट 'पिता' (जिन्होंने बीज डाला) और 'माता' (जिन्होंने प्रकृति रूप में आकार दिया) केवल मैं हूँ!"
            भगवान ही हमारे दादा ('पितामहः') हैं (क्योंकि भगवान ने ब्रह्मा को पैदा किया, और ब्रह्मा ने दुनिया को)। भगवान ही हम सबको भोजन देकर पालते हैं ('धाता')। यानी हमारा असली परिवार (Family) केवल ईश्वर है।
            दुनिया में पढ़ने या रिसर्च (Research) करने के लिए करोड़ों किताबें हैं, लेकिन भगवान कहते हैं कि ब्रह्मांड में केवल एक ही चीज़ है जो असल में 'जानने के लायक' ('वेद्यं') है, और वह मैं हूँ।
            मैं ही ब्रह्मांड का सबसे बड़ा प्यूरिफायर (पवित्रम्) हूँ, जो सारे पाप धो देता है। ब्रह्मांड की पहली ध्वनि 'ॐ' मैं हूँ, और दुनिया के सबसे महान ज्ञान के भंडार (ऋग, साम और यजुर्वेद) भी साक्षात् मैं ही हूँ।
        """.trimIndent(),
        english = """
            I am the absolute Father of this entire cosmic universe (Pita aham asya jagato), the Mother (Mata), the supreme support and sustainer (Dhata), and the Grandfather (Pitamahah).
            I am the absolute, only ultimate object of knowledge worth knowing (Vedyam); I am the supreme purifier (Pavitram); I am the transcendental syllable OM (Omkara), and I am undeniably the Rig, Sama, and Yajur Vedas themselves.
            Lord Sri Krishna is profoundly and aggressively absorbing humanity's deepest, most fundamental 'Emotional' and 'Spiritual' relationships directly into Himself here.
            In the material world, a child views his biological parents as supreme gods who created and endlessly sustain him.
            But the Lord drops a massive reality check: "Who exactly are your true parents? Your biological parents are merely temporary caretakers hired for this one fleeting lifetime. But the absolute, original, eternal 'Father' (who injected the spiritual seed) and the 'Mother' (the material nature that formed your body) of this entire multiverse is exclusively ME!"
            The Lord is our ultimate 'Grandfather' ('Pitamahah' - because God birthed Brahma, and Brahma engineered the planets). God is the supreme 'Dhata' (The cosmic provider who feeds every ant and elephant). Meaning, our true, eternal 'Family' is God alone.
            There are billions of academic books and subjects to research on earth, but the Lord declares that there is officially only ONE absolute truth in the entire cosmos actually worth 'Knowing' ('Vedyam'), and that is ME.
            I am the universe's ultimate titanium Purifier ('Pavitram') that incinerates all sin. I am the very first, terrifyingly powerful cosmic sound vibration 'OM', and I am the literal manifestation of the world's most staggeringly profound libraries of knowledge (the Rig, Sama, and Yajur Vedas).
        """.trimIndent()
    ),
    Shloka(
        id = 18,
        sanskrit = """
            गतिर्भर्ता प्रभुः साक्षी निवासः शरणं सुहृत् |
            प्रभवः प्रलयः स्थानं निधानं बीजमव्ययम् || १८ ||
        """.trimIndent(),
        hindi = """
            मैं ही सबकी 'गति' (अंतिम लक्ष्य / Destination) हूँ; मैं ही सबका 'भर्ता' (पालन करने वाला) हूँ; मैं ही 'प्रभु' (सबका मालिक / Master) हूँ; और मैं ही सबका 'साक्षी' (सब कुछ देखने वाला गवाह / Witness) हूँ।
            मैं ही सबका 'निवास' (रहने की जगह) हूँ; मैं ही परम 'शरण' (Protection) हूँ; मैं ही सबका 'सुहृत्' (बिना स्वार्थ के प्यार करने वाला सबसे अच्छा दोस्त) हूँ।
            मैं ही इस सृष्टि की उत्पत्ति (प्रभवः) हूँ; मैं ही इसका विनाश (प्रलयः) हूँ; मैं ही इसका आधार या ठहराव (स्थानं) हूँ; मैं ही इसका खजाना (निधानं) हूँ; और मैं ही वह 'अविनाशी बीज' (अव्ययम् बीजम्) हूँ (जिससे सब कुछ पैदा होता है)।
            भगवान श्रीकृष्ण यहाँ अपनी सर्वोच्चता और सर्वव्यापकता को 12 अत्यंत ही पावरफुल और राजसी (Majestic) टाइटल (Titles) देकर स्थापित कर रहे हैं।
            आप दुनिया में कहीं भी भाग लें, आप भगवान के इन 12 दायरों से बाहर नहीं जा सकते:
            १. 'गति': आप चाहे जिस रास्ते पर चलें, आपकी यात्रा का एंड-पॉइंट (End-point) केवल ईश्वर है।
            २. 'प्रभु और साक्षी': भगवान केवल दूर बैठे बॉस नहीं हैं। वे आपके दिल में 'साक्षी' (CCTV Camera) की तरह बैठे हैं और आपके हर एक अच्छे-बुरे विचार को लाइव (Live) देख रहे हैं।
            ३. 'शरणं और सुहृत्': जब दुनिया की सारी पुलिस, पैसा और परिवार आपको धोखा दे दे, तब भगवान ही आपकी अंतिम 'शरण' (Safe-house) हैं। और वे आपके ऐसे 'बेस्ट फ्रेंड' (सुहृत्) हैं जो बदले में आपसे कुछ नहीं मांगते।
            ४. 'बीजमव्ययम्': दुनिया का हर बीज (Seed) एक पेड़ बनकर मर जाता है। लेकिन भगवान वह जादुई और 'अविनाशी बीज' हैं, जिससे अरबों ब्रह्मांड पैदा होते हैं, फिर भी वह बीज कभी खत्म या कमज़ोर नहीं होता।
        """.trimIndent(),
        english = """
            I am the ultimate goal and supreme destination (Gatih); the sustainer and maintainer (Bharta); the absolute Master (Prabhuh); the silent, ever-present witness (Sakshi); the eternal abode (Nivasah); the supreme refuge and shelter (Sharanam); and the most intimate, selfless true friend (Suhrid).
            I am the absolute creation (Prabhavah) and the ultimate annihilation (Pralayah); I am the basis and resting place of everything (Sthanam); I am the supreme resting receptacle and treasure-house (Nidhanam); and I am the eternal, indestructible, original seed of all existence (Bijam avyayam).
            Lord Sri Krishna is officially cementing His staggering Absolute Supremacy by claiming 12 overwhelmingly powerful, majestic, and terrifying 'Cosmic Titles' here.
            No matter how fast or far you run in the multiverse, it is mathematically impossible to escape these 12 dimensions of God:
            1. 'Gatih': No matter which chaotic path you frantically run on, the absolute 'End-Point' and final destination of your soul's billion-year journey is strictly ME.
            2. 'Prabhu & Sakshi': God is absolutely not a blind, distant CEO. He is the 'Sakshi'—a flawless, unhackable 'CCTV Camera' installed directly inside your heart, recording every single toxic and pure thought you generate in real-time.
            3. 'Sharanam & Suhrid': When the world's greatest doctors, billionaires, and your own family brutally abandon you, God is the absolute final 'Safe-House' (Sharanam). He is your 'Best Friend' (Suhrid) who relentlessly loves you with zero selfish expectations.
            4. 'Bijam Avyayam': Every biological seed on earth eventually sprouts, rots, and dies. But God is the terrifying, magical 'Indestructible Seed'. He constantly explodes and sprouts billions of massive galaxies from Himself, yet He absolutely never diminishes, weakens, or dies.
        """.trimIndent()
    ),
    Shloka(
        id = 19,
        sanskrit = """
            तपाम्यहमहं वर्षं निगृह्णाम्युत्सृजामि च |
            अमृतं चैव मृत्युश्च सदसच्चाहमर्जुन || १९ ||
        """.trimIndent(),
        hindi = """
            हे अर्जुन! मैं ही सूर्य के रूप में इस पूरी दुनिया को 'तपाता' (गर्मी देता / तपामि) हूँ; मैं ही पानी को सोखता हूँ (निगृह्णामि) और फिर मैं ही उसे 'वर्षा' (बारिश / वर्षं) के रूप में धरती पर बरसाता (उत्सृजामि) हूँ।
            मैं ही 'अमृत' (अमरता / जीवन) हूँ; और मैं ही साक्षात् 'मृत्यु' (मौत) हूँ! हे अर्जुन! जो 'सत्' (सच्चा और हमेशा रहने वाला / आत्मा) है, वह भी मैं हूँ; और जो 'असत्' (झूठा और नाशवान / भौतिक संसार) है, वह भी मैं ही हूँ।
            भगवान श्रीकृष्ण यहाँ इस बात का अंतिम और सबसे बड़ा सबूत दे रहे हैं कि इस ब्रह्मांड में जो कुछ भी 'अच्छा' या 'बुरा' दिखता है, वह सब एक ही सोर्स (Source / ईश्वर) से आ रहा है।
            लोग सोचते हैं कि भगवान केवल अच्छी चीज़ों (फूल, जीवन) में हैं, और बुरी चीज़ें (मौत, सूखा) किसी शैतान का काम हैं। भगवान इस गलतफहमी को एक झटके में तोड़ देते हैं।
            वे कहते हैं, प्रकृति का पूरा 'वॉटर-साइकिल' (Water-cycle) मैं चला रहा हूँ। मैं ही सूरज बनकर तपता हूँ और समुद्र का पानी सोखता हूँ, और फिर मैं ही बादल बनकर बारिश करता हूँ।
            "अमृतं चैव मृत्युश्च": इंसान जीवन (अमृत) को प्यार करता है और मौत से नफरत करता है। लेकिन भगवान मुस्कुरा कर कहते हैं, "जब कोई जन्म लेता है, तो वह जीवन मैं हूँ; और जब कोई मरता है, तो जो 'मौत' (Death) आकर उसका शरीर छीन लेती है, वह मौत भी साक्षात् मैं ही हूँ!" (जैसे 11वें अध्याय में भगवान अपना विकराल काल-रूप दिखाएंगे)।
            आत्मा (सत्) जो कभी नहीं मरती, वह भी भगवान है; और यह शरीर (असत्) जो राख बन जाएगा, यह भी भगवान की ही एनर्जी (Energy) है। भगवान के सिवा दुनिया में कुछ 'है' ही नहीं (All is ONE)।
        """.trimIndent(),
        english = """
            O Arjuna! As the sun, I give blazing heat (Tapamy aham), and it is I who forcefully withhold (Nigrihnami) and send forth the abundant rain (Varsham utsrijami cha).
            I am eternal immortality and life (Amritam), and I am also the terrifying personification of Death (Mrityush cha). Both the eternal spirit (Sat) and the temporary, perishable matter (Asat) are entirely Me, O Arjuna.
            Lord Sri Krishna is dropping the absolute, ultimate, mind-shattering proof here that absolutely EVERYTHING in the cosmos—whether humanity labels it as 'Good' or 'Horrific'—radiates exclusively from ONE singular Source (God).
            Ignorant humans childishly hallucinate that God only exists in beautiful things (flowers, cute babies, life), and that horrific things (droughts, brutal death) are the work of some evil 'Devil'. The Lord violently destroys this naive illusion in one stroke.
            He declares: I am the sole engineer running the entire global 'Water-Cycle'. I manifest as the blazing Sun to scorch the earth and aggressively evaporate the oceans, and then I manifest as the dark clouds to pour down the monsoon rains.
            "Amritam chaiva mrityush cha": Humans passionately love 'Life' (Amritam) and are paralyzed with terror at 'Death' (Mrityu). But the Lord chillingly smiles and declares, "When a baby is born, that vibrant Life is ME. And when the Grim Reaper arrives to violently rip the soul out of a rotting body, that terrifying 'Death' is also literally ME!" (He will physically prove this in Chapter 11 as the all-devouring Time).
            The immortal Soul (Sat) that never dies is God's energy; and the decaying biological body (Asat) that turns to ash is also God's energy. Absolutely ZERO exists outside of God (All is ONE).
        """.trimIndent()
    ),
    Shloka(
        id = 20,
        sanskrit = """
            त्रैविद्या मां सोमपाः पूतपापा यज्ञैरिष्ट्वा स्वर्गतिं प्रार्थयन्ते |
            ते पुण्यमासाद्य सुरेन्द्रलोकमश्नन्ति दिव्यान्दिवि देवभोगान् || २० ||
        """.trimIndent(),
        hindi = """
            (श्लोक 20 और 21 एक साथ जुड़े हैं)
            जो लोग तीनों वेदों (ऋग्वेद, सामवेद, यजुर्वेद) में बताए गए सकाम कर्मकांडों (Trai-vidya) का पालन करते हैं, जो सोम-रस (यज्ञ का प्रसाद) पीकर अपने पापों को पवित्र (पूतपापा) कर लेते हैं...
            वे लोग यज्ञों के द्वारा मेरी ही पूजा (इष्ट्वा) करके बदले में स्वर्ग जाने की प्रार्थना (स्वर्गतिं प्रार्थयन्ते) करते हैं।
            वे लोग अपने पुण्यों के फलस्वरूप देवताओं के राजा इंद्र के स्वर्गलोक (सुरेन्द्रलोकम्) को प्राप्त करके, वहाँ स्वर्ग में देवताओं के अत्यंत दिव्य और अलौकिक सुखों को भोगते हैं (अश्नन्ति देवभोगान्)।
            भगवान श्रीकृष्ण ने पिछले 6 श्लोकों में अपनी महानता बताई। अब वे बता रहे हैं कि इतने महान भगवान को छोड़कर लोग छोटी-छोटी चीज़ों (स्वर्ग) के पीछे कैसे भागते हैं।
            हिन्दू धर्म में एक बहुत बड़ी 'इल्यूज़न' (Illusion / भ्रांति) है—'स्वर्ग' (Heaven)।
            कुछ पंडित और विद्वान (त्रैविद्या) जो वेदों को तो बहुत अच्छी तरह पढ़ते हैं, लेकिन उनका मकसद भगवान का प्रेम (मोक्ष) पाना नहीं होता। उनका मकसद होता है 'स्वर्ग के मजे लूटना'।
            वे भयंकर यज्ञ करते हैं, सोम-रस (एक पवित्र पेय) पीकर अपने सारे पाप धो लेते हैं ('पूतपापा')। वे पूजा तो इनडायरेक्टली (Indirectly) कृष्ण की ही कर रहे हैं, लेकिन उनकी 'డిमांड' (Demand/प्रार्थना) बहुत छोटी है: "हे भगवान! मुझे मोक्ष नहीं चाहिए, मुझे इंद्र का स्वर्गलोक दे दो।"
            भगवान भी तथास्तु (तथास्तु) कह देते हैं। भगवान उन्हें 'सुरेन्द्रलोक' (The VIP Planet of Indra) का वीज़ा (Visa) दे देते हैं। वहाँ वे लोग हज़ारों साल तक अप्सराओं, अमृत और अकल्पनीय सुखों (दिव्य भोग) का मज़ा लूटते हैं। 
            यह सुनने में बहुत अच्छा लगता है, है ना? लेकिन इसका 'कड़वा अंत' (Bitter ending) भगवान अगले श्लोक में बताते हैं!
        """.trimIndent(),
        english = """
            (Verses 20 and 21 are directly connected)
            Those who strictly study the three Vedas (Trai-vidya) and deeply drink the soma juice, completely purifying themselves of all sinful reactions (Puta-papah)...
            worship Me indirectly by executing massive sacrifices, but they selfishly pray only for the specific goal of attaining the heavenly planets (Svargatim prarthayante).
            Consequently, by virtue of their massive pious reactions, they successfully reach the supreme, opulent planet of Indra, the king of heaven (Surendra-lokam), and there they intensely enjoy the unimaginably ecstatic, divine delights of the celestial demigods (Ashnanti divyan divi deva-bhogan).
            After brilliantly establishing His staggering, terrifying Cosmic Supremacy in the previous 6 verses, Lord Sri Krishna now exposes how ignorant humans tragically bypass the Supreme Lord just to chase cheap, temporary material toys (Heaven).
            There is a massive, highly toxic 'Illusion' deeply embedded in religious culture: The lust for 'Heaven' (Svarga).
            Certain highly educated priests and scholars (Trai-vidyā) memorize the Vedas flawlessly, but their ultimate goal is absolutely NOT pure love for God (Moksha). Their greedy objective is strictly 'Extracting maximum celestial enjoyment'.
            They execute incredibly expensive Yajnas and drink the sacred Soma beverage, effectively washing away all their sins ('Puta-papa'). They are technically worshiping Krishna (as He is the Lord of Yajna), but their arrogant 'Demand' is pathetically cheap: "O Lord! Keep Your Moksha; just give me a VIP ticket to Indra's Heaven."
            The Lord grants their wish. He issues them a golden visa to 'Surendra-loka' (The Elite Planet of Indra). There, they violently indulge in staggering, mind-blowing celestial luxuries, nectar, and superhuman sensory pleasures ('Deva-bhogan') for thousands of years.
            This sounds like the ultimate success, right? But the Lord drops the brutally dark 'Catch' and tragic ending in the very next verse!
        """.trimIndent()
    ),
    Shloka(
        id = 21,
        sanskrit = """
            ते तं भुक्त्वा स्वर्गलोकं विशालं क्षीणे पुण्ये मर्त्यलोकं विशन्ति |
            एवं त्रयीधर्ममनुप्रपन्ना गतागतं कामकामा लभन्ते || २१ ||
        """.trimIndent(),
        hindi = """
            वे उस विशाल स्वर्गलोक के असीम सुखों को (हज़ारों साल तक) भोगकर (भुक्त्वा), जब उनके पुण्यों का सारा बैलेंस (पुण्ये) पूरी तरह खत्म (क्षीणे) हो जाता है, तो वे वापस इसी मृत्युलोक (दुःखों से भरी धरती) में गिर पड़ते हैं (विशन्ति)।
            इस प्रकार, केवल तीनों वेदों के कर्मकांडों (त्रयीधर्मम्) का सहारा लेने वाले और सांसारिक सुखों की लालसा (कामकामा) रखने वाले ये लोग, बार-बार बस 'आने-जाने' (गतागतं / जन्म और मरण) के चक्कर को ही प्राप्त करते हैं।
            यह श्लोक 'स्वर्ग' (Heaven) के सबसे बड़े 'स्कैम' (Scam/धोखे) का पर्दाफाश करता है।
            श्रीकृष्ण बता रहे हैं कि स्वर्ग कोई 'परमानेंट सेटलमेंट' (Permanent Settlement) नहीं है; वह एक बहुत महंगे 'हॉलिडे रिज़ॉर्ट' (Holiday Resort) की तरह है।
            जब इंसान अच्छे कर्म (पुण्य) करता है, तो वह अपने 'कर्म-अकाउंट' (Karma-Account) में बहुत सारा बैलेंस (Balance) जमा कर लेता है। उसी बैलेंस के दम पर वह स्वर्गलोक ('विशालं') का मज़ा लूटता है।
            लेकिन जैसे ही उसके पुण्यों का बैलेंस ज़ीरो (0) होता है ('क्षीणे पुण्ये'), स्वर्ग के देवता उसे एक सेकंड भी वहाँ रुकने नहीं देते। वे उसे लात मारकर वापस इसी नर्क जैसी धरती ('मर्त्यलोकं' / जहाँ मौत होती है) पर धकेल देते हैं!
            और धरती पर आकर उसे फिर से किसी माँ के पेट में उल्टा लटकना पड़ता है, फिर से बीमारियां सहनी पड़ती हैं और मरना पड़ता है।
            जो लोग केवल सुखों के भूखे ('कामकामा') हैं और वेदों की सकाम पूजा ('त्रयीधर्म') करते हैं, वे एक 'यो-यो' (Yo-yo) या पेंडुलम (Pendulum) की तरह हमेशा स्वर्ग से धरती और धरती से स्वर्ग के बीच 'आते-जाते' (गतागतं) रहते हैं। उन्हें कभी शांति या आज़ादी नहीं मिलती। 
            स्वर्ग की चाहत वास्तव में एक बहुत बड़ी बेवकूफी है।
        """.trimIndent(),
        english = """
            After they have intensely enjoyed those staggeringly vast celestial heavenly sense pleasures (Tam bhuktva svarga-lokam vishalam), and when the massive results of their pious activities are completely exhausted to zero (Kshine punye), they are violently thrown back down to this mortal earth (Martya-lokam vishanti).
            Thus, those who strictly follow the ritualistic principles of the three Vedas (Trayi-dharmam anuprapanna), blindly desiring mere sense gratification (Kama-kama), achieve absolutely nothing but the pathetic, endless cycle of repeatedly going up and coming down (Gatagatam labhante).
            This spectacular verse brutally exposes and shatters the absolute biggest 'Cosmic Scam' in existence: The Illusion of 'Heaven' (Svarga).
            Sri Krishna explicitly clarifies that Heaven is absolutely NOT a 'Permanent Residence'; it operates exactly like an outrageously expensive, ultra-luxury 'Holiday Resort'.
            When a human executes massive pious acts, he accumulates a staggering balance in his 'Karmic Bank Account'. Using that exact cash, he purchases a VIP vacation to the vast heavenly planets ('Vishalam').
            But the exact microsecond his pious bank balance hits ZERO ('Kshine punye'), the celestial demigods aggressively evict him without a moment's hesitation. They ruthlessly boot his soul right back down into this miserable, rotting earth ('Martya-lokam' - The planet of Death)!
            Upon crashing back to earth, he is violently forced to hang upside down in a mother's womb again, suffer brutal diseases, and die all over again.
            Those who are 'Kama-kama' (blindly, rabidly hungry for cheap sensory thrills) and mechanically follow the Vedic rituals ('Trayi-dharmam') are reduced to pathetic, cosmic 'Yo-Yos'. They swing endlessly up to heaven and down to earth ('Gatagatam' - going and coming) for billions of years. They NEVER achieve actual freedom or peace. Lusting for heaven is the height of spiritual stupidity.
        """.trimIndent()
    ),
    Shloka(
        id = 22,
        sanskrit = """
            अनन्याश्चिन्तयन्तो मां ये जनाः पर्युपासते |
            तेषां नित्याभियुक्तानां योगक्षेमं वहाम्यहम् || २२ ||
        """.trimIndent(),
        hindi = """
            परंतु जो लोग अनन्य भाव से (किसी और का विचार न करते हुए / अनन्याः) मेरा (परमेश्वर का) ही निरंतर चिंतन (चिन्तयन्तो) करते हैं और मेरी ही भली-भांति निष्काम उपासना (पर्युपासते) करते हैं...
            ऐसे हर समय मुझसे पूरी तरह जुड़े हुए (नित्याभियुक्तानां) उन भक्तों का 'योग' (जो उनके पास नहीं है, वह उन्हें देना) और 'क्षेम' (जो उनके पास है, उसकी रक्षा करना) मैं स्वयं वहन करता हूँ (अर्थात् मैं खुद उनके योग-क्षेम की जिम्मेदारी उठाता हूँ - वहाम्यहम्)।
            यह भगवद्गीता का सबसे प्रसिद्ध, सबसे 'कम्फर्टिंग' (Comforting / सुकून देने वाला) और भगवान का सबसे बड़ा 'गारंटी कार्ड' (Guarantee Card) है!
            पिछले श्लोकों में भगवान ने कहा था कि जो लोग 'स्वर्ग' या 'पैसे' के लिए पूजा करते हैं, वे धक्के खाते हैं। तो फिर एक आम इंसान डरेगा कि "अगर मैं भगवान से पैसे या घर नहीं मांगूंगा, तो मेरा परिवार कैसे चलेगा?"
            भगवान श्रीकृष्ण यहाँ इस ब्रह्मांड की सबसे बड़ी 'इंश्योरेंस पॉलिसी' (Insurance Policy) साइन (Sign) करते हैं!
            वे कहते हैं कि जो भक्त 'अनन्य' है—यानी जो केवल मुझसे प्यार करता है, जो मुझसे कोई 'बिज़नेस डील' (Business deal) नहीं करता, और अपना पूरा मन मुझ पर छोड़ देता है...
            मैं, यह ब्रह्मांड का सुप्रीम बॉस, उस भक्त का 'कूरियर बॉय' (Courier boy) और 'सिक्योरिटी गार्ड' (Security guard) बन जाता हूँ!
            'योग': उस भक्त को जीवन जीने के लिए जिस भी चीज़ की ज़रूरत होती है (रोटी, पैसा, ज्ञान), वह मैं खुद उसके घर तक पहुँचाता हूँ।
            'क्षेम': और जो कुछ उसके पास पहले से है, उसकी मैं खुद पहरेदार बनकर रक्षा करता हूँ।
            शर्त सिर्फ एक है: तुम्हें अपनी 'टेंशन' (Tension) छोड़नी होगी और 100% मुझ पर डिपेंड (Dependent) होना पड़ेगा। जब तुम मेरी चिंता करोगे, तो मैं तुम्हारी चिंता करूँगा!
        """.trimIndent(),
        english = """
            But those who exclusively, flawlessly worship Me with pure devotion, meditating solely on My transcendental form completely without deviation (Ananyash chintayanto mam ye janah paryupasate)...
            for such extremely pure devotees who are permanently, eternally united with Me in love (Tesham nityabhiyuktanam), I personally carry what they lack (Yoga), and I personally preserve and protect what they currently have (Kshemam vahami aham).
            This is undisputedly the most famous, most universally comforting, and the absolute greatest 'Cosmic Guarantee Card' issued in the entire Bhagavad Gita!
            In the previous verses, the Lord proved that those who selfishly worship God begging for 'Heaven' or 'Money' get ruthlessly kicked back to earth. A mortal would logically panic: "If I don't beg God for money, health, or food, how on earth will my family survive?"
            Lord Sri Krishna instantly signs the absolute Ultimate 'Universal Insurance Policy' right here!
            He declares: If a devotee is 'Ananya'—meaning he possesses ZERO 'Plan B', he does absolutely no cheap business deals with Me, and he 100% blindly, passionately surrenders his entire consciousness to Me...
            I, the terrifying Supreme CEO of the Multiverse, personally step down to become that devotee's personal 'Courier Boy' and heavily-armed 'Security Guard'!
            'Yoga' (To provide what is lacking): Whatever essential necessities that devotee needs to survive (food, shelter, transcendental knowledge), I personally deliver it directly to his doorstep.
            'Kshema' (To protect what is possessed): And whatever little he already owns, I act as an impenetrable titanium shield to forcefully protect it from destruction.
            There is strictly only ONE condition: You must violently drop all your toxic anxiety and become 100% utterly dependent on Me. If you take care of My worship, I will personally take care of your life!
        """.trimIndent()
    ),
    Shloka(
        id = 23,
        sanskrit = """
            येऽप्यन्यदेवताभक्ता यजन्ते श्रद्धयान्विताः |
            तेऽपि मामेव कौन्तेय यजन्त्यविधिपूर्वकम् || २३ ||
        """.trimIndent(),
        hindi = """
            हे कुन्तीपुत्र (कौन्तेय)! जो लोग पूर्ण श्रद्धा और विश्वास से युक्त होकर (श्रद्धयान्विताः) 'अन्य देवताओं' (जैसे इंद्र, शिव, सूर्य आदि) के भक्त बनकर उनकी पूजा (यजन्ते) करते हैं...
            वे लोग भी वास्तव में (इनडायरेक्टली) 'मेरी ही' पूजा कर रहे हैं (मामेव यजन्ति), परंतु उनकी यह पूजा बिना सही विधि (नियम) के, अज्ञानता-पूर्वक (अविधिपूर्वकम्) की गई है।
            यह श्लोक 'मल्टीपल गॉड्स' (Multiple Gods / बहुत सारे देवी-देवताओं) के कंफ्यूजन को पूरी तरह से साफ कर देता है।
            अक्सर लोग बहस करते हैं कि हम किस भगवान की पूजा करें? शिव जी की, माता रानी की, या सूर्य की?
            भगवान श्रीकृष्ण मुस्कुराते हुए कहते हैं कि इस ब्रह्मांड में 'मेरे (सुप्रीम गॉड) सिवा' और कुछ है ही नहीं। इसलिए तुम चाहे जिस भी देवी-देवता के आगे अगरबत्ती जलाओ या माथा टेको, वह सारी पूजा अंततः 'मुझ तक' (परमेश्वर तक) ही पहुँचती है! 
            (जैसे पेड़ की किसी भी पत्ती या डाली पर पानी डालो, वह अंततः पेड़ की 'जड़' तक ही जाता है)।
            लेकिन फिर श्रीकृष्ण एक बहुत बड़ा शब्द इस्तेमाल करते हैं: "अविधिपूर्वकम्" (Wrong Method / गलत तरीका)।
            वे कहते हैं कि देवताओं की पूजा करना गलत या पाप नहीं है, लेकिन यह एक 'अज्ञानी और टेढ़ा तरीका' है।
            अगर आपको पेड़ हरा-भरा करना है, तो पत्तियों पर पानी डालना बेवकूफी है; आपको सीधा 'जड़' (Root / यानी परमेश्वर कृष्ण) में पानी डालना चाहिए, जिससे पेड़ के सारे पत्ते (सारे देवता) अपने-आप तृप्त हो जाएंगे। 
            देवताओं की पूजा करने से आपका काम तो हो जाएगा, लेकिन आपको 'मोक्ष' (Liberation) नहीं मिलेगा, क्योंकि आपने 'सिस्टम' (विधि) को नहीं समझा।
        """.trimIndent(),
        english = """
            O son of Kunti (Kaunteya)! Even those who are firmly devoted to other, various demigods (Anyadevata-bhakta) and who worship them with immense faith and sincerity (Yajante shraddhayanvitah)...
            actually worship only Me alone (Te 'pi mam eva yajanti), O Arjuna, but they do so by a completely wrong, ignorant, and unauthorized method (Avidhi-purvakam).
            This spectacular verse permanently and flawlessly destroys the massive global confusion surrounding 'Polytheism' (Worshipping multiple Gods).
            Ignorant humans constantly fight and fiercely debate: "Which specific God should we worship? Shiva, Durga, or Surya?"
            Lord Sri Krishna drops a mind-bending truth: There is absolutely NOTHING in this entire multiverse that exists outside of ME (The Supreme Lord). Therefore, no matter which localized celestial Demigod you bow down to or offer incense to, that worship ultimately and inevitably reaches 'ME' alone!
            (Exactly like pouring water on any random leaf or branch of a massive tree; the water ultimately has to reach the singular 'Root' of the tree).
            BUT, Sri Krishna deploys a massive, highly critical caveat: "Avidhi-purvakam" (It is the entirely Wrong, unauthorized Method).
            He clarifies that worshipping demigods is not a demonic sin, but it is an incredibly 'Foolish, unscientific, and highly inefficient method'.
            If you desperately want to nourish a massive tree, spraying water on individual leaves (the demigods) is absolute idiocy; you must violently pour water directly onto the 'Root' (The Supreme Lord Krishna), which instantly and automatically satisfies every single leaf on the tree.
            Worshipping demigods might successfully grant you cheap, temporary money, but it will absolutely never grant you eternal 'Moksha' (Liberation), because you arrogantly bypassed the correct, official operating 'System' (Vidhi) of the cosmos.
        """.trimIndent()
    ),
    Shloka(
        id = 24,
        sanskrit = """
            अहं हि सर्वयज्ञानां भोक्ता च प्रभुरेव च |
            न तु मामभिजानन्ति तत्त्वेनातश्च्यवन्ति ते || २४ ||
        """.trimIndent(),
        hindi = """
            क्योंकि इस संपूर्ण ब्रह्मांड में होने वाले सभी यज्ञों (पूजाओं और कर्मों) का एकमात्र 'भोक्ता' (आनंद लेने वाला / Ultimate Enjoyer) और 'प्रभु' (एकमात्र मालिक / Supreme Master) केवल मैं ही हूँ (अहं हि)।
            परंतु वे (देवताओं की पूजा करने वाले अज्ञानी लोग) मेरे इस 'परम ईश्वरीय स्वरूप' को तत्त्व से (सच्चाई से / गहराई से) नहीं जानते (न तु मामभिजानन्ति तत्त्वेन)...
            और इसी अज्ञान के कारण वे परम शांति और मोक्ष से नीचे गिर जाते हैं (पुनर्जन्म के चक्र में फँस जाते हैं / अतश्च्यवन्ति ते)।
            पिछले श्लोक में भगवान ने बताया था कि देवताओं की पूजा 'गलत तरीका' (अविधिपूर्वकम्) क्यों है। इस श्लोक में वे उसका 'लॉजिकल कारण' (Logical Reason) दे रहे हैं।
            दुनिया में आप कोई भी यज्ञ (हवन), दान, या मेहनत करें, उस पूरी मेहनत का फाइनल रिज़ल्ट (Final Profit) केवल और केवल ब्रह्मांड के सुप्रीम बॉस (ईश्वर/कृष्ण) के अकाउंट में ही जाता है ('अहं हि भोक्ता च प्रभुः')।
            देवताओं के पास खुद का कुछ भी 'कंज्यूम' (Consume / भोगने) की ताकत नहीं है, वे केवल टैक्स कलेक्टर्स (Tax Collectors) हैं जो सारा टैक्स सीधे राजा (परमेश्वर) को पहुँचाते हैं।
            लेकिन जो मूर्ख लोग देवताओं से मांगते हैं, वे यह सोचते हैं कि "यह देवता ही सुप्रीम है, यही सब कुछ दे रहा है।"
            भगवान कहते हैं: "न तु मामभिजानन्ति"—उनका यह अज्ञान (कि वे मुझे सुप्रीम बॉस नहीं मानते) ही उनकी बर्बादी का कारण बनता है।
            चूँकि वे असली सोर्स (Root/भगवान) को नहीं पकड़ते, इसलिए उन्हें मोक्ष (परमानेंट आज़ादी) नहीं मिलता। वे स्वर्ग का छोटा सा सुख भोगते हैं और फिर वापस धरती के दुःखों में 'गिर पड़ते हैं' (च्यवन्ति / Fall down)।
        """.trimIndent(),
        english = """
            For I am the absolute, exclusive, singular enjoyer (Bhokta) and the ultimate supreme Master (Prabhur eva cha) of all sacrifices and rituals in the entire universe (Sarva-yajnanam).
            But those who are ignorant absolutely fail to recognize My true, supreme transcendental nature in reality (Na tu mam abhijananti tattvena)...
            and solely because of this massive ignorance, they tragically fall down into the miserable cycle of birth and death (Atash chyavanti te).
            In the previous verse, the Lord declared demigod worship as the 'Wrong Method' (Avidhi-purvakam). In this verse, He provides the devastatingly precise 'Logical Reason' why.
            No matter what massive sacrifice, charity, or intense religious ritual you perform anywhere in the universe, 100% of the final profit and ultimate enjoyment of that action goes directly and exclusively into the personal bank account of the Supreme Boss (Krishna)—("Aham hi bhokta cha prabhu").
            The celestial Demigods possess absolutely zero independent power to 'Consume' or enjoy anything; they operate strictly as cosmic Tax Collectors who immediately forward all revenue to the Ultimate Emperor (God).
            But foolish mortals who aggressively worship demigods dangerously hallucinate, "This specific demigod is the Supreme God; he is the ultimate giver."
            The Lord bluntly states: "Na tu mam abhijananti"—This specific, toxic ignorance (their arrogant failure to recognize ME as the Ultimate Boss) is the exact biological root cause of their cosmic ruin.
            Because they foolishly fail to connect with the Absolute 'Source/Root' (God), they are strictly denied eternal Moksha (Liberation). They briefly taste cheap heavenly pleasures and then violently 'Fall Down' (Chyavanti) right back into the horrific meat-grinder of earthly rebirth.
        """.trimIndent()
    ),
    Shloka(
        id = 25,
        sanskrit = """
            यान्ति देवव्रता देवान्पितॄन्यान्ति पितृव्रताः |
            भूतानि यान्ति भूतेज्या यान्ति मद्याजिनोऽपि माम् || २५ ||
        """.trimIndent(),
        hindi = """
            जो लोग देवताओं की पूजा करते हैं (देवव्रताः), वे मरने के बाद देवताओं के लोकों (स्वर्ग) में जाते हैं (यान्ति देवान्); जो लोग अपने पूर्वजों (पितरों) की पूजा करते हैं, वे पितृलोक में जाते हैं (पितॄन्यान्ति)।
            जो लोग भूत-प्रेतों और निचली आत्माओं की पूजा करते हैं (भूतेज्याः), वे मरने के बाद उन्हीं भूतों के लोकों में जाते हैं; परंतु जो लोग 'मेरी' (परमेश्वर की) पूजा और भक्ति करते हैं (मद्याजिनो), वे निश्चित रूप से 'मुझे ही' (मेरे परम धाम वैकुंठ को) प्राप्त होते हैं (यान्ति माम्)।
            यह श्लोक 'लॉ ऑफ अट्रैक्शन' (Law of Attraction) और 'आफ्टरलाइफ' (Afterlife / मृत्यु के बाद की दुनिया) का सबसे क्रिस्टल-क्लियर (Crystal-clear) और मैथमेटिकल (Mathematical) नियम है।
            ब्रह्मांड का नियम बहुत सीधा है: "तुम जो बोओगे, वही काटोगे। तुम जिसकी पूजा करोगे, मरने के बाद तुम उसी के पास जाओगे!"
            १. अगर आप देवताओं (इंद्र, सूर्य) की पूजा करेंगे, तो आप स्वर्ग जाएंगे। (जहाँ से वापस लौटना पड़ता है)।
            २. अगर आप अपने मरे हुए रिश्तेदारों (पितरों/श्राद्ध) में बहुत अटैच (Attached) रहेंगे, तो आप 'पितृलोक' जाएंगे।
            ३. सबसे भयानक: अगर आप काले-जादू (Black Magic) और भूत-प्रेतों की पूजा करेंगे, तो आप मरने के बाद 'भूत' (Ghost) बन जाएंगे और उसी अंधकार की दुनिया में भटकेंगे।
            ४. लेकिन अगर आप 100% अपना प्यार और फोकस (Focus) 'मुझ पर' (परमेश्वर कृष्ण पर) रखेंगे, तो आप सीधा मेरे 'सुप्रीम हेडक्वार्टर' (वैकुंठ) में आएंगे!
            श्रीकृष्ण कह रहे हैं कि जब इंसान के पास 'परमेश्वर' को पाने और हमेशा के लिए आज़ाद होने का रास्ता खुला है, तो वह इन छोटी-मोटी और खौफनाक जगहों (स्वर्ग या भूतलोक) का टिकट क्यों खरीद रहा है? यह इंसान की सबसे बड़ी मूर्खता है।
        """.trimIndent(),
        english = """
            Those who strictly worship the demigods will take birth among the demigods in heaven (Yanti deva-vrata devan); those who exclusively worship their ancestors go to the ancestors' planets (Pitri-vratah).
            Those who foolishly worship ghosts and evil spirits will take birth among such beings (Bhutani yanti bhutejya); but those who exclusively worship Me with pure devotion will undoubtedly live with Me in My eternal abode (Yanti mad-yajino 'pi mam).
            This verse delivers the absolute, crystal-clear, and brutally mathematical 'Law of Attraction' and the undeniable science of the 'Afterlife'.
            The cosmic algorithm is staggeringly simple: "You reap exactly what you sow. You will be forcefully transported to exactly whomever you worship!"
            1. If you aggressively worship the celestial demigods (Indra, Surya), your soul will be transported to Heaven (from which you will inevitably be violently kicked out later).
            2. If you are deeply, toxically attached to worshiping your dead relatives and ancestors, your soul will be routed to 'Pitri-loka' (the planet of ancestors).
            3. The most horrifying reality: If you engage in dark arts, black magic, and the worship of ghosts and evil spirits, upon death, your soul will be violently degraded into a 'Ghost' and forced to eternally wander in those terrifying, pitch-black dimensions.
            4. BUT, if you focus 100% of your pure, unadulterated love exclusively on 'ME' (The Supreme Lord Krishna), you will get a direct, VIP, non-stop flight straight into My 'Supreme Headquarters' (Vaikuntha), never to return!
            Sri Krishna is highlighting the absolute peak of human stupidity: When a human possesses the golden opportunity to attain the Ultimate Supreme God and eternal freedom, why on earth is he buying cheap, temporary tickets to highly inferior or terrifying destinations like heaven or ghost-realms?
        """.trimIndent()
    ),
    Shloka(
        id = 26,
        sanskrit = """
            पत्रं पुष्पं फलं तोयं यो मे भक्त्या प्रयच्छति |
            तदहं भक्त्युपहृतमश्नामि प्रयतात्मनः || २६ ||
        """.trimIndent(),
        hindi = """
            जो कोई भी भक्त अत्यंत शुद्ध मन और प्रेम (भक्ति) के साथ मुझे केवल एक 'पत्ता' (तुलसी का), एक 'फूल', एक 'फल', या यहाँ तक कि केवल थोड़ा सा 'जल' (पानी) भी अर्पण करता है (प्रयच्छति)...
            उस शुद्ध अंतःकरण वाले प्रेमी भक्त (प्रयतात्मनः) के द्वारा उस भक्ति और प्रेम से चढ़ाए गए (भक्त्युपहृतम्) उस तुच्छ से उपहार को भी, मैं साक्षात् प्रकट होकर बड़े प्रेम से 'खाता हूँ' (स्वीकार करता हूँ / अश्नामि)।
            यह पूरी भगवद्गीता का सबसे 'मीठा' (Sweetest) और भगवान की असीम दया को दर्शाने वाला श्लोक है।
            दुनिया के लोगों को लगता है कि भगवान को खुश करने के लिए करोड़ों का सोना, बड़े-बड़े यज्ञ, और भारी-भरकम संस्कृत के मंत्र चाहिए। भगवान इस बात को 100% खारिज (Reject) करते हैं।
            भगवान कहते हैं: "मैं पूरे ब्रह्मांड का मालिक हूँ, मुझे तुम्हारे पैसों या सोने की कोई भूख नहीं है! मुझे केवल एक चीज़ की भूख है—'भक्ति' (LOVE)!"
            अगर कोई दुनिया का सबसे गरीब इंसान, जिसके पास भगवान को चढ़ाने के लिए कुछ भी नहीं है, अगर वह रोते हुए और पूरे प्यार से भगवान को सिर्फ एक 'पत्ता', 'फूल' या एक 'चम्मच पानी' भी दे दे...
            तो भगवान (जो पूरे ब्रह्मांड को खाते हैं) उस पानी को दुनिया का सबसे स्वादिष्ट छप्पन-भोग मानकर बड़े चाव से 'खा' (अश्नामि) लेते हैं!
            भगवान उस चीज़ (Object) को नहीं देखते, भगवान उस चीज़ के पीछे छिपी हुई इंसान की 'भावना' (Emotion/Love) को देखते हैं।
            'ईश्वर को पाना दुनिया का सबसे आसान काम है', अगर आपके दिल में सच्चा प्रेम है।
        """.trimIndent(),
        english = """
            If any pure devotee offers Me with deep, unalloyed love and devotion (Bhaktya) a simple leaf (Patram), a flower (Pushpam), a fruit (Phalam), or even just a little water (Toyam)...
            I will accept it, and I will personally and joyfully eat (Ashnami) that offering from a person of pure consciousness (Prayatatmanah), because it was brought to Me with pure love (Bhakty-upahritam).
            This is universally celebrated as the absolute 'Sweetest', most incredibly touching, and overwhelmingly merciful verse in the entire Bhagavad Gita.
            Ignorant mortals foolishly hallucinate that pleasing the Supreme Creator requires donating billions in solid gold, executing massively expensive sacrifices, and chanting highly complex Sanskrit mantras. The Lord violently 100% rejects this corporate mindset.
            The Lord declares: "I am the undisputed Owner of billions of galaxies; I am absolutely NOT hungry for your cheap earthly cash or gold! I possess exactly one, singular, infinite hunger—the hunger for 'PURE LOVE' (Bhakti)!"
            If the absolute poorest human on earth, who possesses absolutely zero wealth, simply cries tears of pure love and tenderly offers God a single random 'Leaf', a 'Flower', or even just a 'Spoonful of regular Water'...
            The Supreme Lord (who effortlessly devours entire universes during Doomsday) eagerly steps down and actively, joyfully 'EATS' (Ashnami) that microscopic offering, treating it like the most spectacular, multi-course universal feast!
            God absolutely does NOT audit the material value of the 'Object' offered; God exclusively audits the raw, explosive 'Emotion and Love' hidden behind the offering.
            'Attaining God is mathematically the easiest task in the universe', provided your heart is saturated with 100% pure love.
        """.trimIndent()
    ),
    Shloka(
        id = 27,
        sanskrit = """
            यत्करोषि यदश्नासि यज्जुहोषि ददासि यत् |
            यत्तपस्यसि कौन्तेय तत्कुरुष्व मदर्पणम् || २७ ||
        """.trimIndent(),
        hindi = """
            हे कुन्तीपुत्र (कौन्तेय)! तुम जो कुछ भी कर्म करते हो (यत्करोषि), तुम जो कुछ भी खाते हो (यदश्नासि), तुम जो भी हवन (यज्ञ) करते हो (यज्जुहोषि), तुम जो कुछ भी दान देते हो (ददासि यत्)...
            और तुम जो भी तपस्या (मेहनत/कष्ट) करते हो (यत्तपस्यसि), हे अर्जुन! उन सब कर्मों को (और उनके फलों को) तुम 'मुझे ही अर्पण' कर दो (तत्कुरुष्व मदर्पणम्)।
            यह श्लोक 'कर्मयोग और भक्तियोग' का सबसे महान और 'प्रैक्टिकल शॉर्टकट' (Practical Shortcut) है!
            भगवान जानते हैं कि हर इंसान 24 घंटे बैठकर माला नहीं जप सकता। इंसान को ऑफिस जाना है, खाना खाना है, और परिवार चलाना है।
            इसलिए भगवान एक ऐसा जादुई फॉर्मूला (Magic Formula) देते हैं जिससे इंसान का हर आम काम 'भक्ति' (Worship) में बदल जाएगा!
            भगवान कहते हैं, "तुम्हें अपना काम छोड़ने की कोई ज़रूरत नहीं है। तुम ऑफिस में काम करते हो? उस काम को 'मेरे लिए' (ईश्वर की सेवा मानकर) करो। तुम खाना खाते हो? खाने से पहले वह खाना 'मुझे ऑफर' (भोग लगाओ) करो, फिर प्रसाद समझकर खाओ। तुम जो भी दान या मेहनत (तपस्या) करते हो, उसके क्रेडिट (Credit) को अपने ईगो (Ego) पर मत लो, वह क्रेडिट 'मेरे अकाउंट' (मदर्पणम्) में ट्रांसफर कर दो।"
            जब इंसान अपनी पूरी ज़िंदगी, अपनी हर छोटी-बड़ी एक्टिविटी (Activity) को भगवान के नाम पर 'डेडिकेट' (Dedicate/समर्पित) कर देता है, तो उसकी पूरी की पूरी 24 घंटे की ज़िंदगी ही एक 'यज्ञ' बन जाती है।
            फिर उसे अलग से पूजा करने की ज़रूरत नहीं पड़ती; उसका साँस लेना भी ईश्वर की पूजा बन जाता है!
        """.trimIndent(),
        english = """
            O son of Kunti (Kaunteya)! Whatever massive actions you perform (Yat karoshi), whatever food you eat (Yad ashnasi), whatever you offer in sacrifice (Yaj juhoshi), whatever charity you give away (Dadasi yat)...
            and whatever severe austerities and penances you perform (Yat tapasyasi)—do all that, O Arjuna, strictly and entirely as an offering unto Me (Tat kurushva mad-arpanam).
            This spectacular verse is the absolute greatest, most genius 'Practical Shortcut' and Life-Hack merging Karma Yoga perfectly with Bhakti Yoga!
            The Supreme Lord perfectly knows that an ordinary human being cannot physically sit in a temple chanting mantras 24/7. A human must aggressively run a corporate office, eat daily meals, and sustain a family.
            Therefore, the Lord drops an absolute Magic Formula that instantly upgrades every single mundane, ordinary human action into supreme 'Divine Worship' (Bhakti)!
            The Lord commands: "You absolutely do not need to quit your job or abandon your life. You aggressively hustle at the office? Execute that exact work purely as a 'Service to ME'. You eat daily meals? Simply 'Offer' that exact food to Me first, and then consume it as divine Prasadam. Whatever massive charity or brutal hard work (Tapasya) you execute, absolutely do not claim the toxic credit for your own ego; instantly endorse and 'Transfer' all that credit directly into MY Bank Account (Mad-arpanam)."
            When a human being officially and legally 'Dedicates' his entire 24-hour existence and every single microscopic activity exclusively to God, his entire biological life instantly transforms into one giant, continuous 'Yajna' (Sacrifice).
            He absolutely no longer needs to perform separate, mechanical rituals; his very act of breathing automatically becomes the highest form of worshiping the Supreme Lord!
        """.trimIndent()
    ),
    Shloka(
        id = 28,
        sanskrit = """
            शुभाशुभफलैरेवं मोक्ष्यसे कर्मबन्धनैः |
            संन्यासयोगयुक्तात्मा विमुक्तो मामुपैष्यसि || २८ ||
        """.trimIndent(),
        hindi = """
            इस प्रकार (अपने सभी कर्मों को मुझे अर्पण करने से), तुम अच्छे (पुण्य/शुभ) और बुरे (पाप/अशुभ) फलों को देने वाले 'कर्मों के भयंकर बंधनों' से हमेशा के लिए पूरी तरह मुक्त हो जाओगे (मोक्ष्यसे कर्मबन्धनैः)।
            और अपने मन को इस 'संन्यास-योग' (कर्मों के फलों का त्याग) में पूरी तरह स्थिर (युक्तात्मा) करके, तुम पूरी तरह से आज़ाद (विमुक्तो) होकर अंततः 'सीधे मुझे ही प्राप्त' हो जाओगे (मामुपैष्यसि)।
            यह पिछले श्लोक (27) में बताए गए 'कर्मों को भगवान को अर्पण करने' वाले फॉर्मूले का 'फाइनल रिज़ल्ट' (Final Result) है!
            भगवान गारंटी देते हैं कि अगर तुम अपनी ज़िंदगी का हर काम 'मदर्पणम्' (भगवान के लिए) करते हो, तो तुम्हारे ऊपर से 'लॉ ऑफ कर्मा' (Law of Karma) पूरी तरह से डी-एक्टिवेट (De-activate / खत्म) हो जाता है!
            दुनिया में अच्छे काम (शुभ) तुम्हें 'सोने की जंजीर' (स्वर्ग) में बांधते हैं, और बुरे काम (अशुभ) तुम्हें 'लोहे की जंजीर' (नर्क) में बांधते हैं। लेकिन जब तुम काम खुद के लिए कर ही नहीं रहे, तो तुम्हारे अकाउंट में न पाप जुड़ेगा न पुण्य!
            तुम इन दोनों 'बन्धनैः' (कर्मों के जाल) से 100% मुक्त ('मोक्ष्यसे') हो जाओगे।
            यही असली 'संन्यास' है। संन्यास का मतलब कपड़े छोड़कर भागना नहीं है; संन्यास का मतलब है "काम करते हुए भी उसके फलों (Results) को त्याग देना।"
            जब इंसान का माइंडसेट (Mindset) ऐसा हो जाता है, तो वह इसी ज़िंदगी में 'विमुक्त' (Live-Liberated / जीते-जी आज़ाद) हो जाता है, और मरने के बाद वह सीधा भगवान की गोद ('मामुपैष्यसि') में जाकर बैठ जाता है।
        """.trimIndent(),
        english = """
            In this exact way (by offering all your works to Me), you shall be utterly and eternally freed from the terrifying bondage of karma and its auspicious (Shubha) and inauspicious (Ashubha) results (Mokshyase karma-bandhanaih).
            With your mind perfectly, firmly fixed on Me in this specific principle of renunciation (Sannyasa-yoga-yuktatma), you shall become completely, flawlessly liberated (Vimukto) and will undoubtedly come directly to Me (Mam upaishyasi).
            This phenomenal verse declares the absolute 'Final Result' and the staggering cosmic reward for executing the 'Offer everything to God' master-formula from the previous Verse 27!
            The Lord gives a titanium guarantee: If you officially register every single action of your life entirely for God ('Mad-arpanam'), the crushing, inescapable 'Law of Karma' is instantly and permanently De-Activated for you!
            In the material matrix, 'Good' deeds (Shubha) bind you with 'Chains of solid Gold' (forcing you to heaven), and 'Evil' deeds (Ashubha) bind you with 'Chains of rusty Iron' (forcing you to hell). But when you are executing actions with absolutely zero personal selfishness, the matrix cannot deposit a single drop of sin or merit into your karmic account!
            You become 100% 'Hacked' and freed ('Mokshyase') from BOTH these suffocating karmic chains.
            This is the absolute true definition of 'Sannyasa'. Renunciation absolutely does not mean throwing away your clothes and running to a cave; it strictly means "Executing intense action while violently abandoning any toxic claim over the results."
            When a human successfully installs this specific mindset, he becomes 'Vimukto' (A Live-Liberated entity) right in this very life, and the exact second his biological heart stops, he shoots straight like a laser beam into the very lap of the Supreme Lord ('Mam upaishyasi').
        """.trimIndent()
    ),
    Shloka(
        id = 29,
        sanskrit = """
            समोऽहं सर्वभूतेषु न मे द्वेष्योऽस्ति न प्रियः |
            ये भजन्ति तु मां भक्त्या मयि ते तेषु चाप्यहम् || २९ ||
        """.trimIndent(),
        hindi = """
            मैं (परमेश्वर) ब्रह्मांड के सभी प्राणियों के लिए बिल्कुल एक समान (बराबर / समोऽहं) हूँ। न तो कोई मेरा दुश्मन (द्वेष्य) है, और न ही कोई मेरा विशेष प्रिय (दोस्त) है।
            परंतु! जो लोग अत्यंत प्रेम और 'भक्ति' के साथ मेरी पूजा (भजन) करते हैं (ये भजन्ति तु मां भक्त्या), वे हमेशा मुझमें ही स्थित रहते हैं (मयि ते), और मैं भी साक्षात् उनके हृदय में हमेशा के लिए स्थित हो जाता हूँ (तेषु चाप्यहम्)।
            यह श्लोक भगवान के 'परम न्याय' (Absolute Justice) और उनके 'असीम प्रेम' (Infinite Love) का सबसे शानदार संतुलन (Balance) है।
            लोग अक्सर कहते हैं कि "भगवान भेदभाव करते हैं; वो किसी को अमीर और किसी को गरीब क्यों बनाते हैं?"
            भगवान स्पष्ट कहते हैं: "समोऽहं सर्वभूतेषु" (मैं 100% न्यूट्रल / Neutral हूँ)। मेरे लिए एक चींटी, एक आतंकवादी, और एक राजा बिल्कुल बराबर हैं। मैं किसी से नफरत ('द्वेष्य') नहीं करता और किसी का फेवर ('प्रिय') नहीं लेता। जो जैसा कर्म करता है, प्रकृति उसे वैसा फल दे देती है।
            लेकिन अगली ही लाइन में भगवान एक बहुत बड़ा 'ट्विस्ट' (Twist) देते हैं!
            "परंतु (तु)... जो मुझे 'भक्ति' (Unconditional Love) करता है, उसके लिए रूल (Rule) बदल जाता है!"
            जब कोई भक्त अपना पूरा दिल निकालकर भगवान के कदमों में रख देता है, तो भगवान न्यूट्रल (Neutral) नहीं रह पाते। वे एक 'मैग्नेट' (Magnet) की तरह उस भक्त के दिल में खिंचे चले आते हैं। 
            भगवान कहते हैं: "वह भक्त 24 घंटे मेरे विचारों में डूबा रहता है ('मयि ते'), और बदले में मैं अपनी सारी ताकत और प्यार के साथ उसके दिल में जाकर परमानेंटली (Permanently) बैठ जाता हूँ ('तेषु चाप्यहम्')!" 
            यह भेदभाव नहीं है, यह प्रेम का 'रेसिप्रोकेशन' (Reciprocation / बराबरी का व्यवहार) है।
        """.trimIndent(),
        english = """
            I envy absolutely no one, nor am I partial to anyone. I am flawlessly and entirely equal to all living beings in the universe (Samo 'ham sarva-bhuteshu, na me dveshyo 'sti na priyah).
            BUT! Whoever renders pure transcendental service unto Me in devotion (Ye bhajanti tu mam bhaktya) is always existing directly within Me as a friend (Mayi te), and I am also permanently existing as a friend directly within him (Teshu chapy aham).
            This is one of the most staggeringly profound verses in the Gita, displaying the absolute perfect, flawless balance between God's 'Absolute, Uncompromising Justice' and His 'Infinite, Intoxicating Love'.
            Ignorant humans aggressively complain: "God is highly biased and partial; why does He make some people billionaires and others starving beggars?"
            The Supreme Lord bluntly answers: "Samo 'ham sarva-bhuteshu" (I am 100% completely, coldly Neutral). To Me, a microscopic ant, a brutal serial killer, and a massive emperor are absolutely mathematically equal. I hate absolutely no one ('Dveshya') and I blindly favor no one ('Priya'). Material nature simply dispenses strict karmic reactions based precisely on human actions.
            But in the very next line, the Lord drops a massive, universe-altering 'Twist'!
            "BUT (Tu)... for the rare soul who violently loves Me with pure 'Bhakti' (Unconditional Devotion), the cosmic rules are instantly overridden!"
            When a pure devotee violently rips out his own heart and lovingly surrenders it at God's feet, the Supreme Lord absolutely cannot remain a cold, neutral judge. He is magnetically, irresistibly dragged directly into that devotee's heart.
            The Lord passionately declares: "Because that devotee is submerged 24/7 in thoughts of Me ('Mayi te'), in perfect reciprocation, I take My entire infinite cosmic majesty and permanently sit directly inside his very heart ('Teshu chapy aham')!"
            This is absolutely NOT 'Bias' or partiality; it is the ultimate, flawless 'Reciprocation' of pure, unadulterated Love.
        """.trimIndent()
    ),
    Shloka(
        id = 30,
        sanskrit = """
            अपि चेत्सुदुराचारो भजते मामनन्यभाक् |
            साधुरेव स मन्तव्यः सम्यग्व्यवसितो हि सः || ३० ||
        """.trimIndent(),
        hindi = """
            यदि कोई अत्यंत दुराचारी (दुनिया का सबसे भयंकर और नीच पापी / सुदुराचारो) व्यक्ति भी, अगर अनन्य भाव से (बिना किसी और की शरण में गए / 100% फोकस के साथ) मेरी भक्ति (पूजा/भजन) करने लग जाए...
            तो उस इंसान को एक 'परम साधु' (महान संत / साधुरेव) ही मानना चाहिए! क्योंकि उसने मेरी शरण में आने का बिल्कुल सही और पक्का निश्चय (सम्यग्व्यवसितो) कर लिया है।
            यह भगवद्गीता का सबसे 'क्रांतिकारी' (Revolutionary), समाज को हिला देने वाला और 'होप' (Hope/उम्मीद) से भरा श्लोक है!
            समाज का नियम है कि अगर कोई इंसान बहुत बड़ा क्रिमिनल (Criminal), हत्यारा या पापी है, तो समाज उसे हमेशा के लिए 'खराब' (Cancel) मान लेता है।
            लेकिन भगवान श्रीकृष्ण की अदालत (Court) का नियम बिल्कुल अलग है! भगवान कहते हैं: "अपि चेत् सुदुराचारो" (अगर दुनिया का सबसे गिरा हुआ, सबसे गंदा और महापापी इंसान भी है...)
            अगर वह अपने सारे पाप छोड़कर एक दिन 100% समर्पण के साथ ('अनन्यभाक्') रोते हुए मेरी शरण में आ जाए और मेरी भक्ति शुरू कर दे...
            तो भगवान दुनिया को एक कड़ा ऑर्डर (Strict Order) देते हैं: "अब तुम उसे पापी नहीं कहोगे! आज से वह मेरी नज़र में एक महान 'साधु' (Saint) बन चुका है ('साधुरेव स मन्तव्यः')!"
            क्यों? क्योंकि भगवान उसका भूतकाल (Past) नहीं देखते; भगवान उसका 'वर्तमान निश्चय' (Present Resolution / सम्यग्व्यवसितो) देखते हैं कि उसने दुनिया की सारी बुराइयां छोड़कर सीधे ईश्वर का रास्ता चुन लिया है।
            यह श्लोक साबित करता है कि हर पापी का एक भविष्य (Future) होता है, और ईश्वर की माफी इंसान के पापों से करोड़ों गुना बड़ी है।
        """.trimIndent(),
        english = """
            Even if a person has committed the absolute most horrific, abominable, and terrifyingly wicked actions (Api chet su-duracharo), if he instantly engages in My pure devotional service without the slightest deviation (Bhajate mam ananya-bhak)...
            he is to be officially and unconditionally considered a highly elevated saint (Sadhur eva sa mantavyah)! Because his intelligence and determination are now perfectly, resolutely fixed upon the right path (Samyag vyavasito hi sah).
            This is undeniably the absolute most 'Revolutionary', society-shattering, and overwhelmingly 'Hope-giving' verse in the entire Bhagavad Gita!
            The toxic human society operates on a brutal cancel-culture: if a man is a known, horrific criminal, murderer, or massive sinner, society permanently brands him as unredeemable trash and cancels him forever.
            But the Supreme Court of Lord Sri Krishna operates on a spectacularly different law! The Lord declares: "Api chet su-duracharo" (Even if a human is officially the absolute most degraded, filthy, and violently horrific sinner in the entire universe...)
            If one day he violently drops his entire toxic lifestyle, falls to his knees weeping with 100% absolute, un-deviating surrender ('Ananya-bhak'), and begins pure devotional service to Me...
            The Supreme Lord issues a strict, non-negotiable command to the entire universe: "You will absolutely NEVER call him a sinner again! From this exact microsecond, in My official judgment, he is completely transformed into an elite, highly elevated 'SAINT' ('Sadhur eva sa mantavyah')!"
            Why? Because God absolutely does NOT audit a man's rotting, dead 'Past'; God exclusively looks at his 'Present Titanium Determination' ('Samyag vyavasito'). He has made the flawless, supreme decision to abandon the dark matrix and choose God.
            This spectacular verse powerfully proves that every sinner has a glorious future, and the blinding power of God's forgiveness is infinitely greater than the darkest human sin.
        """.trimIndent()
    ),
    Shloka(
        id = 31,
        sanskrit = """
            क्षिप्रं भवति धर्मात्मा शश्वच्छान्तिं निगच्छति |
            कौन्तेय प्रतिजानीहि न मे भक्तः प्रणश्यति || ३१ ||
        """.trimIndent(),
        hindi = """
            (मेरी भक्ति शुरू करते ही) वह महापापी व्यक्ति बहुत ही जल्द (क्षिप्रं) अत्यंत पवित्र 'धर्मात्मा' बन जाता है, और हमेशा रहने वाली परम शांति (शश्वच्छान्तिं) को प्राप्त कर लेता है।
            हे कुन्तीपुत्र अर्जुन (कौन्तेय)! तुम पूरी दुनिया के सामने यह डंके की चोट पर (खुलकर) प्रतिज्ञा कर दो (प्रतिजानीहि) कि "मेरे (भगवान के) सच्चे भक्त का कभी भी विनाश (पतन) नहीं होता" (न मे भक्तः प्रणश्यति)।
            यह भगवद्गीता का सबसे 'रोमांचक' (Goosebumps-inducing) और भगवान का सबसे 'अग्रेसिव प्रॉमिस' (Aggressive Promise) है!
            पिछले श्लोक में सवाल था कि क्या एक पापी सच में साधु बन सकता है? भगवान कहते हैं: "क्षिप्रं" (वह 10 साल में नहीं, बल्कि 'तुरंत/Flash' में एक शुद्ध धर्मात्मा बन जाता है)। ईश्वर का प्रेम उसके सारे पापों के कीटाणुओं को एक सेकंड में जलाकर उसे वो 'परम शांति' देता है जो बड़े-बड़े योगियों को नहीं मिलती।
            लेकिन इस श्लोक की दूसरी लाइन तो इतिहास (History) का सबसे बड़ा मास्टरपीस (Masterpiece) है!
            श्रीकृष्ण खुद प्रतिज्ञा नहीं करते; वे अर्जुन को ऑर्डर (Order) देते हैं: "कौन्तेय प्रतिजानीहि" (अर्जुन! तुम जाकर पूरे ब्रह्मांड में यह अनाउंसमेंट / Announcement कर दो कि कृष्ण के भक्त का कभी नाश नहीं होता!)।
            भगवान ने अर्जुन से यह घोषणा क्यों करवाई? क्योंकि भगवान कभी-कभी अपने भक्तों की रक्षा के लिए अपने ही नियम तोड़ देते हैं (जैसे महाभारत में उन्होंने हथियार न उठाने की अपनी प्रतिज्ञा तोड़ दी थी)। लेकिन भगवान अपने 'भक्त की प्रतिज्ञा' (Devotee's Promise) को कभी टूटने नहीं देते। 
            इसलिए भगवान ने अर्जुन से कहलवाया, ताकि ब्रह्मांड का कोई भी राक्षस या दुःख यह बात सुन ले कि "जो भगवान की शरण में है, उसका इस दुनिया और अगली दुनिया में 100% कोई बाल भी बांका नहीं कर सकता।"
        """.trimIndent(),
        english = """
            He very quickly and instantaneously becomes highly righteous and perfectly virtuous (Kshipram bhavati dharmatma), and he attains everlasting, supreme, unshakeable peace (Shashvach-chantim nigacchati).
            O son of Kunti (Kaunteya), boldly and loudly declare it to the entire world (Pratijanihi) that My pure devotee is absolutely never, ever vanquished or destroyed (Na me bhaktah pranashyati)!
            This is universally celebrated as the absolute most 'Goosebumps-inducing', thrilling, and staggeringly 'Aggressive Promise' from the Supreme Lord in the entire Gita!
            Regarding the horrific sinner from the previous verse, society might doubt: Can he really change? The Lord declares: "Kshipram" (He absolutely does not take 10 years; he instantaneously, in a blinding flash, transforms into a flawlessly pure, righteous saint). The explosive power of God's love instantly incinerates his toxic past, granting him an 'Eternal Peace' that even elite yogis struggle to find.
            But the second half of this verse is an absolute, historical Masterpiece!
            Sri Krishna deliberately does NOT make this promise Himself; He aggressively commands Arjuna: "Kaunteya pratijanihi" (Arjuna! Go out there, grab a megaphone, and boldly Announce to the entire multiverse that Krishna's devotee is absolutely indestructible!).
            Why on earth did the Lord force Arjuna to declare this? Because the Supreme Lord, out of infinite love, will sometimes joyfully break His own personal vows just to protect His devotee (just as He broke His vow of not lifting a weapon to protect Arjuna from Bhishma). But God will NEVER, EVER allow His 'Devotee's Promise' to be broken.
            By making Arjuna declare it, the Lord issued an absolute, irrevocable, titanium Cosmic Guarantee: "Any soul who genuinely surrenders to ME is 100% bulletproof. Absolutely no demon, no tragedy, and no force in the multiverse can ever destroy My devotee."
        """.trimIndent()
    ),
    Shloka(
        id = 32,
        sanskrit = """
            मां हि पार्थ व्यपाश्रित्य येऽपि स्युः पापयोनयः |
            स्त्रियो वैश्यास्तथा शूद्रास्तेऽपि यान्ति परां गतिम् || ३२ ||
        """.trimIndent(),
        hindi = """
            हे पार्थ! क्योंकि जो लोग मेरी पूरी तरह से शरण लेते हैं (मां हि व्यपाश्रित्य), वे भले ही पाप-योनियों (नीची जातियों या पाप के माहौल) में जन्म लेने वाले हों (येऽपि स्युः पापयोनयः)...
            या फिर वे स्त्रियां (स्त्रियो), वैश्य (व्यापारी वर्ग), और शूद्र (मज़दूर वर्ग) ही क्यों न हों, वे सभी निश्चित रूप से सर्वोच्च 'परम गति' (मोक्ष और मेरे परम धाम) को ही प्राप्त होते हैं (तेऽपि यान्ति परां गतिम्)।
            यह श्लोक सनातन धर्म का सबसे बड़ा 'सोशल रिफॉर्म' (Social Reform / सामाजिक क्रांति) है। भगवान श्रीकृष्ण ने समाज के सारे भेदभावों (Discrimination) को एक झटके में उखाड़ कर फेंक दिया है।
            प्राचीन काल में कुछ घमंडी और अज्ञानी लोगों ने यह झूठा नियम बना लिया था कि "मोक्ष केवल उच्च जाति के पढ़े-लिखे ब्राह्मणों को ही मिल सकता है।"
            श्रीकृष्ण इस बकवास को पूरी तरह से खारिज करते हैं।
            वे डंके की चोट पर कहते हैं कि भगवान के 'वैकुंठ' (Supreme Abode) का वीज़ा (Visa) किसी जाति, जेंडर (Gender), या डिग्री (Degree) पर निर्भर नहीं करता।
            चाहे कोई इंसान किसी 'पाप-योनि' (चोर-डाकुओं या अज्ञानियों के घर) में ही क्यों न पैदा हुआ हो; चाहे वह कोई स्त्री हो (जिन्हें पुराने समाज में वेदों से दूर रखा जाता था); चाहे वह कोई दिन-रात व्यापार करने वाला वैश्य हो; या कोई अनपढ़ और गरीब मज़दूर (शूद्र) हो...
            अगर उस इंसान के दिल में मेरे लिए 100% सच्चा प्यार है और वह पूरी तरह 'मेरी शरण' (व्यपाश्रित्य) में आ गया है... तो दुनिया का कोई भी नियम उसे रोक नहीं सकता। वह सीधे सबसे ऊँची अवस्था (परां गतिम् / मोक्ष) को प्राप्त करेगा!
            भगवान के दरबार में केवल 'भक्ति' (Love) चलती है, इंसान का बायोलॉजिकल शरीर (Biological body) या उसका 'स्टेटस' (Status) नहीं।
        """.trimIndent(),
        english = """
            O son of Pritha (Partha), those who take absolute and supreme shelter in Me (Mam hi vyapashritya), even though they may be born of lower, sinful, or degraded conditions (Ye 'pi syuh papa-yonayah)...
            and even if they are women (Striyo), merchants (Vaishyas), or ordinary manual workers (Shudras), they all without exception flawlessly attain the absolute highest, supreme destination (Te 'pi yanti param gatim).
            This spectacular verse is undeniably the absolute greatest, most explosive 'Social Reform' and manifesto of universal spiritual equality in the history of Sanatana Dharma. Lord Sri Krishna violently tears down every single toxic wall of social discrimination in one stroke.
            In ancient times, highly arrogant and ignorant priestly classes had manufactured a completely fake, toxic narrative: "Ultimate Moksha (Liberation) is an exclusive VIP club strictly reserved only for highly educated, upper-caste male Brahmanas."
            Sri Krishna completely annihilates this arrogant nonsense into dust.
            He loudly and boldly declares that the absolute 'Visa' to enter God's Supreme Headquarters (Vaikuntha) absolutely does NOT depend on a human's biological gender, DNA, economic caste, or university degrees.
            Even if a human is biologically born into the most degraded, horrific family of criminals and sinners ('Papa-yonayah'); even if they are a woman (who were tragically barred from reading Vedas by corrupt society); even if they are busy, profit-driven merchants (Vaishyas); or completely uneducated, poor manual laborers (Shudras)...
            If that specific human possesses 100% pure, explosive 'Love' in their heart and takes absolute, unyielding 'Shelter' (Vyapashritya) exclusively at My feet... absolutely no corrupt societal law can stop them. They will shoot straight like a laser beam to the absolute Supreme Destination ('Param gatim' / Moksha)!
            In the Supreme Court of God, the absolute ONLY currency accepted is 'Pure Devotion' (Love), absolutely never the temporary biological body or social status.
        """.trimIndent()
    ),
    Shloka(
        id = 33,
        sanskrit = """
            किं पुनर्ब्राह्मणाः पुण्या भक्ता राजर्षयस्तथा |
            अनित्यमसुखं लोकमिमं प्राप्य भजस्व माम् || ३३ ||
        """.trimIndent(),
        hindi = """
            तो फिर उन अत्यंत पवित्र ब्राह्मणों और भक्त राजर्षियों (राजा जो ऋषि के समान हैं) के लिए तो कहना ही क्या है (कि वे मुझे प्राप्त करेंगे या नहीं)!
            इसलिए, इस नाशवान (टेंपरेरी / अनित्यम्) और सुख-रहित (दुःख से भरे / असुखं) मनुष्य लोक (पृथ्वी) को प्राप्त करके, तुम केवल मेरी ही निरंतर भक्ति (भजस्व माम्) करो।
            पिछले श्लोक में भगवान ने कहा था कि अगर सबसे गिरे हुए और अनपढ़ लोग भी भक्ति करें, तो वे भी परम गति (मोक्ष) पा लेते हैं। 
            अब भगवान एक बहुत ही लॉजिकल (Logical) बात कहते हैं: "किं पुनर्..." (तो फिर उनका तो कहना ही क्या है!)।
            यानी जब एक पापी या अनपढ़ व्यक्ति भी मेरे प्यार से स्वर्ग से भी ऊपर (वैकुंठ) पहुँच सकता है, तो फिर जो इंसान जन्म से ही पवित्र ब्राह्मण है, या जो अर्जुन की तरह एक महान, ज्ञानी 'राजर्षि' (पवित्र राजा) है, अगर वह मेरी भक्ति करे, तो उसके मोक्ष पाने में तो रत्ती भर भी कोई शक हो ही नहीं सकता! उसकी सफलता तो 1000% गारंटीड (Guaranteed) है।
            इसके बाद भगवान इस पूरी दुनिया का सबसे कड़वा और 'फाइनल कंक्लूजन' (Final Conclusion) देते हैं।
            वे कहते हैं कि इंसान सोचता है वह इस धरती पर एन्जॉय (Enjoy) करने आया है। लेकिन भगवान इस धरती ('लोकमिमं') के दो ठप्पे (Stamps) लगाते हैं:
            १. 'अनित्यम्' (Temporary): यहाँ तुम्हारी जवानी, तुम्हारा पैसा, तुम्हारे रिश्तेदार—सब कुछ एक दिन मिट जाएगा।
            २. 'असुखं' (Joyless/Miserable): यहाँ जो 'सुख' दिखता है, वह एक भ्रम (Trap) है; यहाँ का असली रूप केवल 'दुःख' है।
            इसलिए भगवान अर्जुन (और हम सबको) चेतावनी देते हैं: "जब तुम्हें किस्मत से यह मनुष्य का शरीर मिल ही गया है, तो इस टेंपरेरी और दुःखों से भरी दुनिया में अपना टाइम वेस्ट (Time waste) मत करो। तुरंत सब कुछ छोड़कर केवल 'मेरी भक्ति' (भजस्व माम्) में लग जाओ, ताकि तुम यहाँ से हमेशा के लिए बचकर निकल सको!"
        """.trimIndent(),
        english = """
            How much more certain, then, is the supreme destination for the highly pure, righteous Brahmanas and the devoted, saintly kings (Kim punar brahmanah punyah bhakta rajarshayas tatha)!
            Therefore, having achieved this temporary, highly transient (Anityam), and completely miserable, joyless material world (Asukham lokam imam prapya), instantly engage yourself in My pure loving devotion (Bhajasva mam).
            In the previous verse, the Lord guaranteed that even the most uneducated, degraded outcasts effortlessly attain ultimate Moksha if they simply execute pure devotion. 
            Now, the Lord drops an incredibly potent logical statement: "Kim punar..." (How much more certain is it, then!).
            Meaning: If even a horrific sinner or a totally uneducated laborer can rocket past heaven straight into God's eternal Kingdom purely through love, then if a highly cultured, born-pure Brahmana or an elite, saintly king like Arjuna (Rajarshi) executes that exact same devotion, his ultimate liberation is absolutely, 1000% mathematically Guaranteed without a microscopic shadow of a doubt!
            Following this, the Supreme Lord delivers the absolute most bitter, brutal, and 'Final Conclusion' regarding human existence.
            Ignorant humans fiercely hallucinate that they were born on this earth to 'Enjoy' life. The Lord brutally stamps this earthly matrix ('Lokam imam') with two terrifying reality-checks:
            1. 'Anityam' (Strictly Temporary): Every single thing here—your youthful beauty, your billion-dollar empire, your beloved family—is decaying every second and will violently expire.
            2. 'Asukham' (Joyless/Miserable): The 'Happiness' you hallucinate here is a toxic trap; the absolute default, biological operating system of this planet is pure, unadulterated 'Misery'.
            Therefore, the Lord issues an aggressive, life-saving warning to Arjuna (and all of humanity): "Since you have luckily obtained this rare human body, absolutely DO NOT waste your ticking timeline chasing garbage in this temporary, miserable nightmare. Instantly drop all toxic illusions and urgently engage in My pure loving devotion ('Bhajasva mam') so you can permanently hack and escape this matrix forever!"
        """.trimIndent()
    ),
    Shloka(
        id = 34,
        sanskrit = """
            मन्मना भव मद्भक्तो मद्याजी मां नमस्कुरु |
            मामेवैष्यसि युक्त्वैवमात्मानं मत्परायणः || ३४ ||
        """.trimIndent(),
        hindi = """
            तुम हमेशा अपने मन को केवल मुझमें ही लगाओ (मन्मना भव), मेरे ही परम भक्त बनो (मद्भक्तो), मेरी ही पूजा करो (मद्याजी), और केवल मुझे ही प्रणाम करो (मां नमस्कुरु)।
            इस प्रकार अपनी आत्मा (मन और शरीर) को पूरी तरह से मुझमें लगाकर (युक्त्वैवमात्मानं), और मुझे ही अपना सर्वोच्च और अंतिम लक्ष्य मानकर (मत्परायणः), तुम निश्चित रूप से 'मुझे ही प्राप्त' होगे (मामेवैष्यसि)।
            यह नौवें अध्याय (राजविद्या राजगुह्य योग) का अत्यंत ही शानदार, राजसी (Majestic) और सबसे महत्वपूर्ण 'ग्रैंड फिनाले' (Grand Finale) श्लोक है!
            भगवान श्रीकृष्ण यहाँ पूरे 'भक्तियोग' का सबसे आसान और सबसे शक्तिशाली '4-स्टेप मास्टर फॉर्मूला' (4-Step Master Formula) दे रहे हैं:
            १. 'मन्मना भव' (Mind): सबसे पहले अपने भागते हुए दिमाग को कंट्रोल करो और 24 घंटे उसमें केवल 'मेरा' (कृष्ण का) ही विचार चलने दो। 
            २. 'मद्भक्तो' (Heart): केवल दिमाग से काम नहीं चलेगा, अपने 'दिल' से मुझसे बेइंतहा प्यार करो। मेरे सच्चे 'भक्त' बनो।
            ३. 'मद्याजी' (Action): तुम्हारे शरीर का हर काम, हर ड्यूटी (Duty) और हर पूजा (यज्ञ) केवल 'मेरे लिए' (मुझे खुश करने के लिए) होनी चाहिए।
            ४. 'मां नमस्कुरु' (Ego): अपने झूठे घमंड (अहंकार) को पूरी तरह कुचल दो और हमेशा मेरे सामने (और मेरे बनाए हर जीव के सामने) विनम्र होकर झुकना (प्रणाम करना) सीखो।
            जब इंसान का दिमाग, दिल, शरीर और अहंकार—ये चारों चीजें 100% पूरी तरह से 'कृष्ण' पर लॉक (Lock) हो जाती हैं (मत्परायणः), तो दुनिया की कोई भी माया उसे रोक नहीं सकती।
            भगवान अर्जुन को एक खुली और पक्की गारंटी (Cosmic Guarantee) देते हैं: "मामेवैष्यसि" (तुम हर हाल में, बिना किसी शक के, इस दुःखों की मैट्रिक्स को तोड़कर सीधा 'मुझ तक' पहुँच जाओगे)। 
            यही गीता का सबसे परम और गोपनीय रहस्य है!
        """.trimIndent(),
        english = """
            Engage your mind constantly in continually thinking of Me (Man-mana bhava), become My pure, unalloyed devotee (Mad-bhakto), offer all your worship and sacrifices entirely to Me (Mad-yaji), and offer your humble obeisances solely unto Me (Mam namaskuru).
            Being completely and flawlessly absorbed in Me in this way (Yuktvai vam atmanam), and making Me your absolute, supreme, and ultimate goal (Mat-parayanah), you will undoubtedly and certainly come directly to Me (Mam evaishyasi).
            This is the incredibly spectacular, breathtakingly majestic, and absolute 'Grand Finale' verse of the Ninth Chapter (The Yoga of Supreme Mystic Knowledge)!
            Lord Sri Krishna is dropping the absolute, ultimate '4-Step Master Formula' of Bhakti Yoga here, explicitly detailing exactly how to hack the universe and attain God:
            1. 'Man-mana bhava' (The Mind): First, violently arrest your wildly chaotic, flickering brain and force it to constantly, 24/7, run the exclusive thought of 'ME' (Krishna) in the background.
            2. 'Mad-bhakto' (The Heart): Mechanical thinking is not enough; you must aggressively flood your heart with explosive, unadulterated 'Love' and become My pure, dedicated devotee.
            3. 'Mad-yaji' (The Physical Actions): Every single physical action, duty, and sacrifice your biological body executes must be directed entirely and exclusively for MY pleasure.
            4. 'Mam namaskuru' (The Ego): Ruthlessly slaughter your bloated, toxic false ego, and constantly bow down in extreme humility before Me (and before all living beings as My parts).
            When a human being successfully takes his Mind, his Heart, his Actions, and his Ego, and 'Locks' all four of them 100% permanently onto the Supreme Lord ('Mat-parayanah'), absolutely no force in the material matrix can stop him.
            The Supreme Lord issues an iron-clad, irreversible Cosmic Guarantee: "Mam evaishyasi" (You will violently shatter this miserable physical matrix and unquestionably, mathematically guarantee your direct entry into My eternal Kingdom). 
            This is the absolute, most confidential, supreme secret of the entire Bhagavad Gita!
        """.trimIndent()
    )
)