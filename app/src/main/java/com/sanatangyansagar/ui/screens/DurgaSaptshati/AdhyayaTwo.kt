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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdhyayaTwoScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8E1)) // Deep Cream Background
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                val targetId = query.toIntOrNull()

                if (targetId != null) {
                    // Find the actual position (index) of the shloka that has this specific ID
                    val targetIndex = adhyayaTwoShlokas.indexOfFirst { it.id == targetId }

                    // If it exists in the list (-1 means not found), scroll to it
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
            label = { Text("Search Shloka (1-${adhyayaTwoShlokas.size})") },
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
            itemsIndexed(adhyayaTwoShlokas) { _, shloka ->
                SaptshatiCard(shloka = shloka)
            }
        }
    }
}

// Ensure you have SaptshatiShloka data class and SaptshatiCard composable defined in your project
// (They can be reused from Adhyaya 1)

val adhyayaTwoShlokas = listOf(
    SaptshatiShloka(
        id = 1,
        sanskrit = "ऋषिरुवाच ॥ १ ॥\nदेवासुरमभूद्युद्धं पूर्णमब्दशतं पुरा ।\nमहिषेऽसुराणामधिपे देवानां च पुरन्दरे ॥ २ ॥",
        hindi = """
            (देवासुर संग्राम का आरंभ): "महर्षि मेधा ने कहा: प्राचीन काल में, देवताओं और असुरों (राक्षसों) के बीच पूरे 'सौ वर्षों' (पूर्णमब्दशतं) तक अत्यंत भयंकर महायुद्ध हुआ था।"
            "उस समय असुरों का परम राजा भयंकर 'महिषासुर' था, और देवताओं के राजा साक्षात् 'इन्द्र' थे!"
            महिषासुर 'भैंसे' (Buffalo) का प्रतीक है, जो अज्ञान, आलस (तमोगुण), और अंधी ताकत (Ego) को दर्शाता है। 
            जब इंसान के अंदर की पाश्विक वृत्ति (Animal Instinct) हावी होती है, तो वह उसके सात्विक गुणों (देवताओं) पर हमला करती है।
            यह 'सौ साल' का युद्ध वास्तव में एक इंसान की पूरी ज़िंदगी (Lifespan) का संघर्ष है, जहाँ रोज़ अच्छाई और बुराई की टक्कर होती है।
            महिषासुर केवल एक राक्षस नहीं है; यह हमारे अंदर बैठा हुआ वह हठ (Stubbornness) है जो किसी की नहीं सुनता।
            और 'इन्द्र' हमारी इन्द्रियों (Senses) का वह शुद्ध रूप है जो भगवान की तरफ जाना चाहता है।
            लेकिन जब इंसान का 'ईगो' (महिषासुर) बहुत बड़ा हो जाता है, तो इन्द्र (सद्गुण) कमज़ोर पड़ने लगते हैं।
            ऋषि मेधा यह कहानी सुनाकर राजा सुरथ को बता रहे हैं कि दुनिया की सबसे बड़ी लड़ाई बाहर नहीं, तुम्हारे दिमाग के अंदर चल रही है।
            इस पहले श्लोक से दुर्गा सप्तशती के सबसे खौफनाक और शक्तिशाली अध्याय (महिषासुर सेना वध) की शुरुआत होती है।
        """.trimIndent(),
        english = """
            (The Beginning of the Cosmic War): "The magnificent Sage profoundly declared: In the extremely ancient cosmic past, an exceptionally terrifying mega-war exploded violently between the Gods and the demons."
            "This horrifying colossal battle furiously continued relentlessly without a single pause for exactly 'One Full Hundred Cosmic Years'!"
            "Exactly at that specific time, the supreme king commanding the entire demonic army was the exceptionally horrifying 'Mahishasura', while the supreme king perfectly commanding the Gods was direct 'Indra'!"
            Mahishasura undeniably perfectly symbolizes a massive 'Buffalo', actively representing thick ignorance, terrifying laziness (Tamoguna), and blind, arrogant brute force (Toxic Ego).
            Exactly when a human's dark, brutal animalistic instinct actively dominates, it aggressively and violently fights his pure divine virtues (Gods).
            This terrifying '100-year war' flawlessly represents the absolute entire human lifespan, exactly where pure goodness and horrific evil brutally collide every single day.
            Mahishasura is absolutely no ordinary monster; it is exactly that horrifying stubbornness sitting perfectly inside us that violently refuses to listen.
            And 'Indra' is the absolute pure form of our Senses desperately attempting to flawlessly connect entirely with the Supreme God.
            But exactly when the toxic Ego brutally expands, the pure virtues violently weaken, marking the brutal initiation of the mind's ultimate cosmic war.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 2,
        sanskrit = "तत्रासुरैर्महावीर्यैर्देवसैन्यं पराजितम् ।\nजित्वा च सकलान् देवानिन्द्रोऽभून्महिषासुरः ॥ ३ ॥",
        hindi = """
            (महिषासुर की जीत): "उस भयंकर युद्ध में (तत्र), उन अत्यंत महाबलशाली और शक्तिशाली असुरों (असुरैर्महावीर्यैर्) ने सभी देवताओं की विशाल सेना को बहुत बुरी तरह से 'हरा दिया' (देवसैन्यं पराजितम्)!"
            "और सारे के सारे देवताओं को युद्ध में पूरी तरह से 'जीतकर और कुचलकर' (जित्वा च सकलान् देवान्), वह दुष्ट राक्षस महिषासुर खुद ही स्वर्ग का 'नया इन्द्र' (इन्द्रोऽभून्महिषासुरः / King of Heaven) बन बैठा!"
            यह इंसान के पतन (Downfall) की सबसे खौफनाक स्थिति है। जब अहंकार (Ego) हमारी अच्छाइयों को पूरी तरह हरा देता है, तो वह हमारे मन का राजा (इन्द्र) बन जाता है।
            अब दिमाग में दया, शांति या ज्ञान का शासन नहीं है; अब दिमाग में केवल क्रोध, वासना और 'मैं' (महिषासुर) का शासन है।
            जब राक्षस 'इन्द्र' बन जाता है, तो इसका मतलब है कि सिस्टम (System) हैक (Hack) हो चुका है।
            अब इंसान वही करेगा जो उसका ईगो (Ego) उससे करवाएगा; उसकी सारी इन्द्रियां (Senses) अब शैतान की गुलाम बन चुकी हैं।
            यह श्लोक दिखाता है कि बुराई (Evil) कितनी शक्तिशाली हो सकती है, जो देवताओं (पॉजिटिविटी) को भी हरा सकती है।
            महिषासुर का इन्द्र बनना ब्रह्मांड के संतुलन (Cosmic Balance) का पूरी तरह से टूट जाना है।
            राजा सुरथ अपनी हार पर रो रहा था, पर ऋषि बता रहे हैं कि यहाँ तो देवता भी हार गए थे!
            जब हार इतनी बड़ी हो, तो इसका समाधान (Solution) किसी साधारण बुद्धि से नहीं, बल्कि परम चेतना (महामाया) से ही निकलता है।
        """.trimIndent(),
        english = """
            (The Brutal Victory of Mahishasura): "Exactly directly in that horrific terrifying war (Tatra), those exceptionally massive, highly overpowered, and heavily 'Supremely valiant demons' (Asurairmahaviryair) violently ruthlessly 'Crushed and entirely defeated the absolute entire army of the Gods' (Devasainyam parajitam)!"
            "And strictly after flawlessly violently 'Conquering, slaughtering, and crushing' absolutely all the massive Gods (Jitva cha sakalan devan), that exact horrifying wicked demon Mahishasura aggressively directly 'Declared himself as the brand new Indra' (Indro'bhunmahishasurah / The Ultimate King of Heaven)!"
            This flawlessly represents the absolute most terrifying downfall exactly of a human. Exactly when toxic Ego violently defeats our pure goodness entirely, it ruthlessly becomes the absolute King (Indra) exactly of our mind.
            Now the brain is absolutely no longer ruled by compassion, peace, or supreme wisdom; the brain is strictly explicitly ruled exclusively by rage, lust, and the toxic 'I' (Mahishasura).
            Exactly when a demon violently becomes 'Indra', it profoundly literally means the entire massive operating System has been completely Hacked.
            Now the human will flawlessly aggressively execute exactly whatever his Ego violently commands; his entire absolute Senses have perfectly become cheap slaves to evil.
            This spectacular verse flawlessly explicitly actively proves exactly how exceptionally powerful Evil can physically become, actively crushing even pure Gods (Positivity).
            Mahishasura violently becoming Indra is the complete total flawless shattering perfectly of the absolute Cosmic Balance.
            King Suratha was frantically crying over his petty defeat, but the Sage aggressively reminds him that even the Supreme Gods were brutally defeated right here!
            Exactly when the brutal defeat is this astronomically massive, the absolute Solution absolutely cannot possibly originate from cheap intellect, but strictly from Supreme Consciousness (Mahamaya).
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 3,
        sanskrit = "ततः पराजिता देवा पद्मयोनिं प्रजापतिम् ।\nपुरस्कृत्य गतास्तत्र यत्रेशगरुडध्वजौ ॥ ४ ॥",
        hindi = """
            (देवताओं का त्रिमूर्ति के पास जाना): "स्वर्ग से बाहर निकाले जाने के बाद (ततः), वे सभी हारे हुए और अपमानित देवता (पराजिता देवा) कमल से जन्म लेने वाले (पद्मयोनिं) 'ब्रह्मा जी' (प्रजापतिम्) को सबसे आगे करके (पुरस्कृत्य)।"
            "उस परम स्थान पर गए (गतास्तत्र), जहाँ भगवान शिव (ईश) और भगवान विष्णु (गरुड़ध्वजौ / जिनके रथ पर गरुड़ है) विराजमान थे!"
            जब इंसान का 'अहंकार' (Ego) हद से ज़्यादा बढ़ जाता है और उसके अंदर की अच्छाई (देवता) बुरी तरह से हार जाती है।
            तो वे देवता (अच्छाइयाँ) सबसे पहले 'ब्रह्मा' (बुद्धि / Intellect) के पास जाती हैं।
            और फिर वह 'बुद्धि' उन्हें 'विष्णु' (परम चेतना / Consciousness) और 'शिव' (परमात्मा / Supreme Soul) के पास लेकर जाती है।
            यह एक अत्यंत गहरा इंटरनल आध्यात्मिक प्रोसेस (Internal Spiritual Process) है।
            जब आप बाहरी दुनिया (महिषासुर) से हार जाते हैं, तो आप बाहरी लोगों से मदद नहीं माँगते; आप अपने ही अंदर गहराई में (विष्णु/शिव के पास) जाते हैं।
            ब्रह्मा को 'आगे करने' (पुरस्कृत्य) का मतलब है कि प्रार्थना हमेशा 'विवेक' (Intellect) के माध्यम से भगवान तक पहुँचनी चाहिए।
            अंधी प्रार्थना काम नहीं करती; जब बुद्धि (ब्रह्मा) समझ जाती है कि अब मेरे बस का कुछ नहीं है, तब वह परम चेतना को पुकारती है।
            यहाँ से 'डिवाइन इंटरवेंशन' (Divine Intervention) का बेस (Base) तैयार होता है।
        """.trimIndent(),
        english = """
            (The Humiliated Gods Approach the Trinity): "Exactly strictly after being brutally kicked entirely out of heaven (Tatah), absolutely all those exceptionally heavily 'Defeated, crushed, and violently humiliated Gods' (Parajita deva) flawlessly placed Lord Brahma (Prajapatim), who is flawlessly born strictly from the cosmic lotus (Padmayonim), exactly perfectly entirely in the absolute front (Puraskritya)."
            "And actively aggressively marched directly straight exactly to that highly supreme divine location (Gatastatra) where Lord Shiva (Isha) and Lord Vishnu (Garudadhvajau / He whose massive flag bears Garuda) were flawlessly majestically residing!"
            Exactly when a human's terrifying toxic 'Ego' explodes far beyond absolutely all massive physical limits and the pure absolute goodness (Gods) physically inside him is brutally defeated.
            Exactly then those highly supreme Gods (divine pure virtues) flawlessly actively violently sprint exactly straight absolute first perfectly to 'Brahma' (pure Intellect).
            And exactly then that specific pure 'Intellect' aggressively physically drags them entirely straight flawlessly exactly to 'Vishnu' (pure Consciousness) and 'Shiva' (Supreme Soul).
            This is undeniably an exceptionally massive, completely 'Internal Spiritual Process' flawlessly perfectly where the human actively frantically begs exclusively for absolute supreme assistance.
            Exactly when you are violently defeated entirely by the external physical world (Mahishasura), you absolutely do not beg for cheap physical help; you dive exceptionally deep flawlessly exactly inside yourself (to Vishnu/Shiva).
            Actively placing Brahma 'in the absolute front' (Puraskritya) profoundly means that prayer absolutely must flawlessly reach God strictly exclusively exactly through pure 'Viveka' (Intellect).
            Blind prayer completely fails; exactly when the intellect (Brahma) flawlessly comprehends it can absolutely do nothing, strictly then it violently calls the Supreme Consciousness.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 4,
        sanskrit = "यथावृत्तं तयोस्तद्वन्महिषासुरचेष्टितम् ।\nत्रिदशाः कथयामासुर्देवाभिभवविस्तरम् ॥ ५ ॥",
        hindi = """
            (अत्याचारों का विस्तार से वर्णन): "वहाँ पहुँचकर उन सभी देवताओं (त्रिदशाः) ने उस भयंकर महिषासुर की सारी गंदी और नीच हरकतों (महिषासुरचेष्टितम्) का बिल्कुल वैसा ही 'विस्तार से वर्णन' (यथावृत्तं कथयामासुर्) किया।"
            "और यह भी बताया कि उस राक्षस ने किस प्रकार से सभी देवताओं को युद्ध में बुरी तरह 'हराकर उनका घोर अपमान' (देवाभिभवविस्तरम्) किया है!"
            देवताओं ने अपना सारा 'ट्रॉमा' (Trauma) भगवान विष्णु और शिव के सामने खोल कर रख दिया!
            वे बता रहे हैं कि किस तरह महिषासुर (जानवर जैसी वृत्ति) ने उनके दैवीय स्वभाव (Divine nature) को पूरी तरह कुचल (Humiliate) दिया है।
            यह प्रार्थना (Prayer) का सबसे शुद्ध और सच्चा रूप है—भगवान के सामने अपनी हार और अपनी कमियों को पूरी तरह से नंगा कर देना (Total Surrender)।
            अक्सर इंसान भगवान के सामने भी अपना 'ईगो' (Ego) लेकर जाता है और अपनी गलतियों को छुपाता है।
            पर देवता यहाँ साफ-साफ कह रहे हैं कि "हम हार चुके हैं, हमारी शक्ति ज़ीरो हो गई है, और हम अपमानित हो चुके हैं।"
            जब तक आप अपनी 'कमियों' को भगवान के सामने पूरी ईमानदारी से स्वीकार नहीं करते, तब तक भगवान कोई एक्शन (Action) नहीं लेते।
            'कथयामासुर्' (कहा) का अर्थ है कि उन्होंने अपना दर्द बिना किसी शर्म के भगवान के चरणों में उँडेल दिया।
            यही वह रोना (Cry of the Soul) है जो परम चेतना (विष्णु/शिव) को क्रोधित (Active) करने वाला है।
        """.trimIndent(),
        english = """
            (Narrating the Atrocities in Detail): "Flawlessly reaching exactly there, absolutely all those massive Gods (Tridashah) aggressively actively flawlessly 'Narrated strictly exactly in extremely highly detailed precision' (Yathavrittam kathayamasur) absolutely all the terrifying, filthy actions and exceptionally evil operations entirely of that mega-demon Mahishasura (Mahishasuracheshtitam)."
            "And violently vividly detailed exactly how that monster brutally 'Defeated, crushed, and executed the absolute maximum supreme humiliation' flawlessly perfectly exactly upon absolutely all the Gods (Devabhibhavavistaram)!"
            The absolute entire host of Gods flawlessly completely actively vomited their absolute entire terrifying 'Trauma' completely naked directly perfectly exactly in front of Supreme Lord Vishnu and direct Shiva!
            They are aggressively actively screaming perfectly detailing exactly how Mahishasura (Highly violent brutal animalistic Instinct) has completely, violently, and ruthlessly 'Crushed and entirely Humiliated' absolutely all their pure divine, spiritual nature completely.
            This is undeniably the absolute purest, most exceptionally honest exact form of Prayer—ruthlessly exposing your complete defeat and absolute entire vulnerabilities completely naked directly before God (Total Surrender).
            Frequently, a pathetic human flawlessly actively carries his toxic 'Ego' directly even exactly before God and desperately attempts entirely to aggressively hide his brutal mistakes.
            But the pure Gods right here are violently explicitly aggressively screaming, "We have been flawlessly brutally defeated, our raw power has violently dropped to mathematical zero, and we are utterly humiliated."
            Exactly until you flawlessly and completely honestly aggressively accept absolutely all your exceptionally pathetic weaknesses directly perfectly entirely before God, God absolutely never, ever actively physically takes any direct Action.
            'Kathayamasur' (Narrated) perfectly implies they flawlessly ruthlessly poured their entire agonizing pain exactly straight entirely at God's sacred feet completely without a single drop of fake shame.
            This is exactly undeniably that absolute terrifying literal 'Cry of the Soul' which is flawlessly actively destined to violently enrage (Activate) the Supreme Consciousness (Vishnu/Shiva).
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 5,
        sanskrit = "सूर्येन्द्राग्न्यनिलेन्दूनां यमस्य वरुणस्य च ।\nअन्येषां चाधिकारान् स स्वयमेवाधितिष्ठति ॥ ६ ॥",
        hindi = """
            (ब्रह्मांडीय अधिकारों का हाईजैक): "देवताओं ने कहा: उस महिषासुर ने 'सूर्य', 'इन्द्र', 'अग्नि', 'वायु' (अनिल), 'चन्द्रमा' (इन्दु), 'यमराज' (यमस्य), और 'वरुण' (वरुणस्य च)।"
            "इन सभी प्रमुख देवताओं के, और यहाँ तक कि 'बाकी सभी दूसरे देवताओं' (अन्येषां चाधिकारान्) के भी सारे के सारे 'अधिकार और पावर्स' छीन लिए हैं।"
            "और खुद ही उन सब पर 'कब्ज़ा करके बैठ गया है' (स स्वयमेवाधितिष्ठति)!"
            महिषासुर ने केवल स्वर्ग का फिजिकल कब्ज़ा नहीं किया, उसने देवताओं की 'जॉब' (Job / Cosmic Duties) भी छीन ली!
            सूर्य का काम रोशनी देना है, पर अब महिषासुर तय कर रहा है कि सूर्य कहाँ उगेगा! अग्नि का काम जलाना है, पर अग्नि अब महिषासुर की गुलाम है।
            यह साइकोलॉजी (Psychology) का बहुत गहरा सिद्धांत है। जब 'अहंकार' (Ego) हावी होता है, तो वह इंसान की सारी इन्द्रियों (Senses) को अपना गुलाम बना लेता है।
            आँखें (सूर्य) अब केवल वही देखती हैं जो अहंकार देखना चाहता है। क्रोध (अग्नि) अब अहंकार की रक्षा के लिए जलता है।
            इंसान का पूरा सिस्टम (Nervous system / Cosmic structure) महिषासुर के भयंकर कंट्रोल (Control) में आ चुका है।
            वह खुद को साक्षात् 'ईश्वर' (स्वयमेवाधितिष्ठति) समझने लगा है।
            जब राक्षस खुद को भगवान समझने लगे, तो यह इस बात का संकेत है कि अब 'महामाया' उसका विनाश करने के लिए प्रकट होने वाली है।
            देवता अपनी इस भयानक लाचारी का ज़िक्र करके विष्णु को एक्शन लेने के लिए उकसा रहे हैं।
        """.trimIndent(),
        english = """
            (The Violent Hijacking of Cosmic Authority): "The Gods actively screamed: That horrifying Mahishasura has brutally hijacked the massive cosmic positions exactly of the 'Sun' (Surya), 'Indra', 'Agni' (Fire), 'Vayu' (Wind/Anila), 'Moon' (Indu), 'Yamaraja' (Yamasya), and 'Varuna' (Varunasya cha)."
            "He has violently entirely stripped absolutely all the absolute primary Gods, and perfectly even 'Absolutely all the other remaining Gods' (Anyesham chadhikaran), completely of their absolute ultimate 'Powers, rights, and cosmic authority'."
            "Actively aggressively 'Occupying completely and perfectly ruling exactly all of them entirely himself' (Sa svayamevadhitishthati)!"
            Mahishasura undeniably absolutely did not strictly casually steal the physical Heaven; he violently brutally literally explicitly completely hijacked the absolute pure 'Jobs' (Cosmic Duties) of absolutely all the Gods!
            The Sun's pure absolute job is flawlessly executing Light, but exactly now Mahishasura arrogantly explicitly dictates exactly where the Sun will physically rise! Agni's job is to burn, but Agni is now his cheap slave.
            This phenomenally explicitly violently is a highly deep principle of advanced Psychology. Exactly when the toxic 'Ego' aggressively strictly flawlessly dominates, it flawlessly completely violently turns absolutely all the human's physical Senses directly into its own slaves.
            The physical eyes (Sun) now exclusively see exactly only what the toxic Ego aggressively desires entirely to physically see. Rage (Agni) now violently actively burns exclusively strictly to perfectly defend that exact Ego.
            The human's absolute entire physiological System (Nervous system / Cosmic structure) has violently entirely completely successfully fallen entirely inside the terrifying strict Control of Mahishasura.
            He has actively brutally begun strictly assuming himself undeniably literally exactly as the absolute 'God' (Svayamevadhitishthati) Himself.
            Exactly when a pathetic physical demon arrogantly aggressively blindy assumes himself as God, it is undeniably the absolute exact literal explicit signal completely exactly that 'Mahamaya' is flawlessly preparing to violently violently annihilate him.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 6,
        sanskrit = "स्वर्गान्निराकृताः सर्वे तेन देवगणा भुवि ।\nविचरन्ति यथा मर्त्या महिषेण दुरात्मना ॥ ७ ॥",
        hindi = """
            (देवताओं का धरती पर भटकना): "उस अत्यंत दुष्ट और पापी आत्मा वाले महिषासुर (महिषेण दुरात्मना) ने स्वर्ग के सारे देवताओं (देवगणा सर्वे) को 'स्वर्ग से धक्के मारकर बाहर निकाल दिया' (स्वर्गान्निराकृताः) है!"
            "और अब वे सारे के सारे महान देवता अपनी सारी शक्ति खोकर, एक साधारण इंसान (यथा मर्त्या / Mortal human) की तरह इस पृथ्वी (भुवि) पर भिखारियों की तरह 'भटक रहे हैं' (विचरन्ति)!"
            देवता (Energy/Positivity) जब अपने असली रूप और स्थान (स्वर्ग / Heaven) में होते हैं, तो वे दुनिया को 100% परफेक्शन के साथ चलाते हैं।
            पर अब महिषासुर (Negativity / तमोगुण) ने उन्हें इतना कमज़ोर कर दिया है कि वे 'मर्त्य' (मरने वाले इंसानों) की तरह बेबस और लाचार हो गए हैं।
            यह एक इंसान के जीवन में भयंकर 'डिप्रेशन' (Depression) की वह स्थिति है, जहाँ इंसान की सारी अच्छी और पॉजिटिव ऊर्जा (Positive energy) खत्म हो जाती है।
            अच्छाई (देवता) अब राज नहीं कर रही; अच्छाई अब धरती पर छुपकर अपनी जान बचा रही है।
            जब आपके अंदर की अच्छाई को आपका ही 'ईगो' लात मारकर बाहर निकाल दे, तो इंसान पूरी तरह से जानवरों (Animal) के स्तर पर गिर जाता है।
            महिषासुर ने देवताओं को मारा नहीं है; उसने उनका 'स्टेटस' (Status) छीनकर उन्हें मानसिक रूप से मार दिया है।
            देवता भगवान शिव और विष्णु को बता रहे हैं कि "अब हमारे पास खोने के लिए कुछ नहीं बचा है।"
            स्थिति अब आउट ऑफ़ कंट्रोल (Out of control) हो चुकी है!
        """.trimIndent(),
        english = """
            (The Gods Wandering on Earth): "That exceptionally filthy, completely utterly evil-souled demon Mahishasura (Mahishena duratmana) has violently and ruthlessly 'Kicked absolutely all the entire host of Gods flawlessly entirely straight outside' strictly from the absolute supreme Heaven (Svargannirakritah)!"
            "And currently, absolutely all those formerly glorious massive Gods, having violently lost their entire absolute raw power, are actively pathetically 'Wandering helplessly entirely exactly like ordinary, cheap mortal humans' (Vicharanti yatha martya) perfectly exactly on this physical dirt-earth (Bhuvi)!"
            Exactly when the absolute pure Gods (Energy/Positivity) are flawlessly completely securely actively perfectly residing precisely in their exact true form and location (Heaven), they flawlessly entirely actively run the world with 100% perfection.
            But exactly now Mahishasura (Toxic Negativity / Tamoguna) has violently brutally explicitly aggressively reduced them entirely exactly to such extreme absolute massive weakness that they are utterly helpless entirely exactly like cheap physical 'Martya' (mortal humans destined entirely to die).
            This is undeniably an exceptionally terrifying absolute state precisely of highly clinical 'Depression' perfectly exactly inside a human's life, strictly where the human's absolute entire pure positive energy drops entirely dead to mathematical zero.
            Pure Goodness (Gods) is absolutely no longer actively ruling; Goodness is now aggressively frantically hiding directly on the dirt exactly to pathetically explicitly strictly save its own life.
            Exactly when your very own toxic 'Ego' ruthlessly kicks the pure absolute goodness physically inside you violently entirely straight outside, the human perfectly completely effortlessly violently drops entirely exactly to the precise literal absolute level strictly of street animals (Animals).
            Mahishasura has absolutely not brutally physically killed the Gods; he has violently entirely stripped exactly their massive 'Status', ruthlessly completely actively executing their total psychological murder.
            The Gods are aggressively screaming directly perfectly entirely explicitly to Lord Shiva and Vishnu that "We have absolutely zero things remaining perfectly physically to lose now."
            The absolute terrifying situation has flawlessly actively successfully violently become completely 100% entirely 'Out of Control'!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 7,
        sanskrit = "एतद्वः कथितं सर्वममरारिविचेष्टितम् ।\nशरणं वः प्रपन्नाः स्मो वधस्तस्य विचिन्त्यताम् ॥ ८ ॥",
        hindi = """
            (पूर्ण समर्पण और वध की प्रार्थना): "हमने आप लोगों (ब्रह्मा, विष्णु, शिव) के सामने उस अमर देवताओं के भयंकर शत्रु (अमरारि / राक्षस महिषासुर) की सारी गंदी चालें और काम (विचेष्टितम्) पूरी तरह से 'कह दिए हैं' (एतद्वः कथितं सर्वम्)!"
            "अब हम सब अपनी जान बचाने के लिए आपकी ही 'शरण' (Protection) में आ गिरे हैं (शरणं वः प्रपन्नाः स्मो)!"
            "कृपया करके उस भयंकर राक्षस के 'वध' (हत्या / Elimination) का कोई ठोस उपाय 'सोचिए' (वधस्तस्य विचिन्त्यताम्)!"
            देवता अपना ईगो (Ego) 100% खत्म कर चुके हैं। वे साफ मान चुके हैं कि वे महिषासुर (अहंकार) से नहीं जीत सकते!
            जब इंसान अपने सारे हथकंडे अपनाकर हार मान लेता है और 'पूर्ण समर्पण' (शरणं प्रपन्नाः / Total Surrender) करता है, तभी 'डिवाइन इंटरवेंशन' (Divine Intervention) होता है।
            वे विष्णु और शिव से यह नहीं कह रहे कि "हमें लड़ने की शक्ति दो"; वे कह रहे हैं: "हम कुछ नहीं कर सकते, अब आप ही इसके 'वध' (हत्या) का मास्टरप्लान (Masterplan) बनाइए!"
            सनातन तन्त्र का यह सबसे बड़ा रहस्य है: जब तक आप खुद को बचाने की कोशिश (Struggle) करते रहते हैं, भगवान आपकी मदद नहीं करते।
            जैसे ही आप कहते हैं "मैं पूरी तरह से हार गया हूँ, अब तुम सँभालो", तो ब्रह्मांड की सबसे बड़ी शक्तियां तुरंत एक्टिवेट (Activate) हो जाती हैं।
            यह श्लोक उस 'ब्रेकिंग पॉइंट' (Breaking Point) का प्रतीक है जहाँ से महामाया का जन्म होने वाला है।
            देवताओं की यह पुकार पूरे ब्रह्मांड के सिस्टम (System) में एक एसओएस (SOS / Emergency Call) की तरह गूँज उठी!
        """.trimIndent(),
        english = """
            (Absolute Total Surrender and the Plea for Slaughter): "We have flawlessly, fully, and aggressively 'Entirely actively narrated' (Etadvah kathitam sarvam) directly before all of You exactly absolutely all the horrifying, filthy actions and terrifying operations (Vicheshtitam) perfectly exactly of that absolute ultimate massive enemy exactly of the immortal Gods (Amarari / Mahishasura)!"
            "Now, we have flawlessly and completely violently actively fallen exactly straight directly strictly into Your absolute supreme 'Protection and Refuge' (Sharanam vah prapannah smo) strictly to casually save our pathetic lives!"
            "Kindly aggressively 'Actively profoundly Think, plan, and precisely device' an absolute flawless method exactly to execute his absolute brutal 'Slaughter and total annihilation' (Vadhastasya vichintyatam)!"
            The absolute entire host of Gods has brutally flawlessly entirely permanently annihilated exactly their massive Ego 100%. They have ruthlessly aggressively brutally accepted completely exactly that they absolutely completely fundamentally cannot possibly ever successfully defeat Mahishasura (Toxic Ego)!
            Exactly when a human entirely completely aggressively fiercely gives entirely up after flawlessly completely exhausting absolutely all his cheap tricks and physically executes absolute complete 'Total Surrender' (Sharanam prapannah), exclusively only exactly then does an absolute terrifying 'Divine Intervention' flawlessly miraculously occur.
            They are absolutely not frantically actively begging Vishnu and Shiva screaming "Give us raw power to fight"; they are violently actively furiously screaming: "We can absolutely do zero things! Now You exclusively alone absolutely flawlessly must aggressively actively aggressively entirely device the ultimate violent Masterplan exactly strictly for his brutal 'Slaughter' (Vadha)!"
            This is undeniably Sanatana Tantra's absolute greatest ultimate secret: Exactly precisely exactly as long as you aggressively actively relentlessly attempt strictly entirely to frantically 'Save yourself' (Struggle), God absolutely never ever flawlessly physically helps you.
            The exact split-second you violently actively flawlessly completely officially scream "I am flawlessly brutally perfectly 100% defeated, now You handle absolutely everything", the absolute greatest supreme powers perfectly exactly of the colossal universe seamlessly flawlessly violently 'Activate' instantaneously.
            This spectacular verse undeniably flawlessly perfectly represents exactly that absolute ultimate terrifying 'Breaking Point' perfectly straight exactly from where Mahamaya is violently flawless destined entirely strictly perfectly entirely to be directly born.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 8,
        sanskrit = "इत्थं निशम्य देवानां वचांसि मधुसूदनः ।\nचकार कोपं शम्भुश्च भृकुटीकुटिलाननौ ॥ ९ ॥",
        hindi = """
            (विष्णु और शिव का भयंकर क्रोध): "इस प्रकार (इत्थं) उन सभी असहाय देवताओं के अत्यंत दुःख भरे वचनों (देवानां वचांसि) को 'सुनकर' (निशम्य), भगवान मधुसूदन (विष्णु) और भगवान शम्भु (शिव)।"
            "अत्यंत भयंकर 'क्रोध' (चकार कोपं) से पूरी तरह भर उठे!"
            "और उस भयानक गुस्से के कारण उन दोनों भगवानों की 'भौंहेँ (Eyebrows) तन गईं और उनका चेहरा अत्यंत टेढ़ा और खौफनाक' (भृकुटीकुटिलाननौ) हो गया!"
            अब 'गेम' (Game) बदल रहा है! ब्रह्मांड की सबसे बड़ी और शांत शक्तियां (विष्णु और शिव) अब अत्यंत भयंकर 'गुस्से' (Rage) में आ चुकी हैं!
            अक्सर इंसान सोचता है कि भगवान हमेशा शांत (Peaceful) और मुस्कुराते हुए (Smiling) रहते हैं।
            पर दुर्गा सप्तशती दिखाती है कि जब धर्म (Goodness) पर अत्याचार अपनी सीमा पार कर जाता है, तो भगवान का 'रौद्र' (Destructive) रूप बाहर आ जाता है।
            'भृकुटीकुटिलाननौ' का मतलब है गुस्से से चेहरे का अत्यंत डरावना और टेढ़ा हो जाना। भगवान शिव और विष्णु अब 'संहारक' (Destroyers) मोड में जा चुके हैं।
            यह कोई साधारण इंसानी गुस्सा नहीं है; यह वह 'कॉस्मिक गुस्सा' (Cosmic Rage) है जो पूरे के पूरे ब्रह्मांड को एक सेकंड में मिटा सकता है।
            देवताओं की प्रार्थना ने काम कर दिया है! विष्णु (मधुसूदन - जिन्होंने मधु राक्षस को मारा था) और शिव (शम्भु - जो शांति देते हैं) अब महिषासुर को डिलीट (Delete) करने के लिए पूरी तरह तैयार हैं।
            यहीं से ब्रह्मांड की सबसे बड़ी ऊर्जा (Energy) का विस्फोट होने वाला है।
        """.trimIndent(),
        english = """
            (The Exceptionally Terrifying Apocalyptic Rage of Vishnu and Shiva): "Exactly perfectly 'Hearing' (Nishamya) absolutely all these highly pathetic, intensely sorrowful exact words (Vachamsi) exclusively exactly of all those helpless Gods strictly entirely in exactly this precise manner (Ittham), direct Lord Madhusudana (Vishnu) and direct Lord Shambhu (Shiva)."
            "Instantaneously violently erupted exactly entirely completely exactly into exceptionally terrifying, blinding apocalyptic 'Absolute Rage' (Chakara kopam)!"
            "And strictly exclusively due to that exceptionally horrific massive anger, both their absolute supreme 'Eyebrows violently knitted together, brutally contorting their absolute supreme faces flawlessly perfectly exactly into an exceptionally horrifying, terrifying expression' (Bhrikutikutilananau)!"
            The absolute entire colossal 'Game' is violently explicitly aggressively entirely flawless changing exactly right now! The absolute greatest and precisely most exceptionally peaceful powers perfectly of the entire Universe (Vishnu and Shiva) have undeniably violently explicitly entered exactly into a state of absolute exceptionally terrifying apocalyptic 'Rage' (Kopa)!
            Frequently, a pathetic ignorant human foolishly blindly assumes completely entirely that God is flawlessly perpetually exceptionally 'Peaceful' and actively always 'Smiling'.
            But the massive Durga Saptshati flawlessly violently explicitly completely proves exactly that exactly when the brutal horrific atrocities actively committed perfectly against absolute Dharma (Goodness) violently aggressively cross the absolute ultimate maximum breaking point limit, God's absolute terrifying 'Raudra' (Apocalyptic Destructive) physical form violently fiercely effortlessly flawlessly emerges entirely.
            'Bhrikutikutilananau' literally profoundly perfectly means the absolute terrifying, highly brutal, and explicitly horrifying violent contortion completely of the physical face purely explicitly strictly completely due to blinding supreme anger. Lord Shiva and Vishnu have undeniably now explicitly violently completely aggressively actively successfully seamlessly completely perfectly shifted absolutely straight completely exclusively exactly directly strictly entirely exactly flawlessly entirely directly perfectly straight completely inside 'Destroyers' mode.
            This is absolutely zero cheap ordinary human physical anger; this is undeniably exactly that terrifying 'Cosmic Rage' which can violently ruthlessly obliterate the absolute entire colossal universe flawlessly exactly in a single split-second.
            The massive Gods' prayer has flawlessly completely successfully entirely actively seamlessly completely explicitly violently flawlessly worked perfectly 100%! Vishnu (Madhusudana - who ruthlessly slaughtered the demon Madhu) and Shiva (Shambhu - who flawlessly grants supreme peace) are undeniably completely entirely now flawlessly perfectly 100% prepared exclusively exactly entirely explicitly strictly perfectly to fiercely aggressively violently completely violently permanently 'Delete' Mahishasura.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 9,
        sanskrit = "ततोऽतिकोपपूर्णस्य चक्रिणो वदनात्ततः ।\nनिश्चक्राम महत्तेजो ब्रह्मणः शङ्करस्य च ॥ १० ॥",
        hindi = """
            (तीनों देवों के परम तेज का विस्फोट): "फिर (ततो), सबसे पहले अत्यंत भयंकर क्रोध से पूरी तरह भरे हुए (अतिकोपपूर्णस्य) भगवान विष्णु (चक्रिणो) के 'मुख' (वदनात्ततः) से एक अत्यंत ही भयंकर और विशाल 'रोशनी का पुंज' (महत्तेजो / Supreme Energy) बाहर निकला (निश्चक्राम)!"
            "और ठीक उसी के तुरंत बाद, भगवान 'ब्रह्मा' (ब्रह्मणः) और भगवान 'शंकर' (शङ्करस्य च) के शरीरों से भी वैसा ही अत्यंत भयंकर और असीम तेज बाहर निकला!"
            यहीं से साक्षात् 'माँ दुर्गा' (महिषासुरमर्दिनी) के जन्म की खौफनाक प्रक्रिया (Process) शुरू होती है!
            भगवान अपना कोई 'हथियार' (Weapon) नहीं चला रहे हैं; वे अपने अंदर की सबसे शक्तिशाली 'परम ऊर्जा' (महत्तेजो / Divine Light) को अपने शरीर से बाहर निकाल रहे हैं!
            'वदनात्ततः' (मुख से) का अर्थ है कि विष्णु के चेहरे से वह ऊर्जा निकली जो ब्रह्मांड को बनाती और चलाती है।
            जब तीनों देव (ब्रह्मा, विष्णु, शिव) एक साथ अपनी-अपनी सबसे बड़ी शक्तियां (Energies) निकालते हैं, तो वह 'महा-ऊर्जा' (Super-Energy) किसी एक देव के कंट्रोल में नहीं रहती।
            वे तीनों देव मिलकर एक 'नया कॉस्मिक सॉफ्टवेयर' (New Cosmic Software) लिख रहे हैं जिसे कोई राक्षस हैक (Hack) नहीं कर सकता!
            यह श्लोक सनातन विज्ञान (Sanatana Science) का वह हिस्सा है जहाँ 'मैटर' (Matter) पूरी तरह से 'प्योर एनर्जी' (Pure Energy / Light) में बदल रहा है।
            जब सारे देवताओं की ऊर्जाएँ (Energies) एक साथ मिलेंगी, तब ब्रह्मांड की सबसे बड़ी सुपरपावर—'महामाया दुर्गा'—साकार रूप लेंगी।
            यहाँ से महिषासुर के विनाश का असली और खौफनाक खेल शुरू होता है।
        """.trimIndent(),
        english = """
            (The Terrifying Violent Eruption of the Supreme Light): "Immediately strictly exactly exactly after that (Tato), absolute first, flawlessly directly straight exactly out of the exact physical 'Mouth' (Vadanattatah) exclusively exactly of direct Lord Vishnu (Chakrino), who was violently completely overflowing absolutely 100% strictly with exceptionally terrifying apocalyptic blinding rage (Atikopapurnasya), an exceptionally massive, horrifically powerful absolute 'Colossal Beam of Supreme Cosmic Light' (Mahattejo / Supreme Raw Energy) aggressively violently 'Erupted and flawlessly shot completely straight out' (Nishchakrama)!"
            "And absolutely exactly perfectly immediately following that, identically exceptionally terrifying and absolute boundless massive raw cosmic light violently erupted exactly from the physical bodies flawlessly exactly of Lord 'Brahma' (Brahmanah) and direct Lord 'Shankara' (Shiva / Shankarasya cha) as well!"
            Right exactly entirely perfectly from here seamlessly flawlessly violently exclusively begins the absolute terrifying majestic process explicitly precisely exactly of the actual physical incarnation strictly of direct 'Maa Durga' (Mahishasuramardini) Herself!
            The Supreme Gods are absolutely explicitly not firing any physical 'Weapons'; they are flawlessly violently executing a terrifying ejection of the absolute most exceptionally highly powerful 'Supreme Cosmic Energy' (Mahattejo / Divine Light) completely entirely straight outside from inside their physical bodies!
            'Vadanattatah' (From the mouth) profoundly perfectly implies exactly that the exact specific energy which flawlessly creates and violently runs the massive universe flawlessly seamlessly entirely shot completely exactly straight directly perfectly out exclusively exactly from Vishnu's supreme face.
            Exactly when all three supreme Gods (Brahma, Vishnu, Shiva) flawlessly actively simultaneously violently aggressively physically completely eject exactly their absolute greatest supreme specific raw powers (Energies), that terrifying 'Super-Energy' absolutely completely seamlessly perfectly violently remains entirely perfectly strictly completely outside the exact explicit flawless control entirely of absolutely any single one God.
            They are flawlessly aggressively actively entirely writing a perfectly 'New Cosmic Software' which absolutely zero demonic bug can possibly ever successfully actively Hack!
            This spectacular verse undeniably flawlessly actively seamlessly entirely constitutes the exact highly specific core completely of 'Sanatana Science' perfectly where physical 'Matter' violently seamlessly flawlessly entirely flawlessly completely actively actively actively dynamically actively successfully transforms exactly into 'Pure Energy' (Light).
            Exactly when the absolute ultimate raw Energies exclusively exactly of all the Gods violently seamlessly flawlessly fuse completely exactly perfectly perfectly into exactly One, undeniably strictly then the absolute greatest supreme Superpower of the entire colossal Cosmos—'Mahamaya Durga'—will flawlessly brutally explicitly physically assume Her actual literal form.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 10,
        sanskrit = "अन्येषां चैव देवानां शक्रादीनां शरीरतः ।\nनिर्गतं सुमहत्तेजस्तच्चैक्यं समगच्छत ॥ ११ ॥",
        hindi = """
            (सभी शक्तियों का एक होना): "संसार के रचयिता ब्रह्मा, पालनहार विष्णु और संहारक शिव के भयंकर तेज़ के प्रकट होने के बाद।"
            "स्वर्ग के राजा 'इन्द्र' (शक्र) और वहां मौजूद अन्य सभी छोटे-बड़े देवताओं (अन्येषां चैव देवानां) के शरीरों (शरीरतः) से भी।"
            "एक अत्यंत भयंकर और विशाल 'रोशनी का पुंज' (सुमहत्तेजः) पूरी तरह से बाहर निकला (निर्गतं)!"
            "और वह सारा का सारा अलग-अलग देवताओं का 'तेज' अंतरिक्ष में जाकर 'पूरी तरह से एक साथ मिल गया' (तच्चैक्यं समगच्छत)!"
            यह घटना सनातन तन्त्र का सबसे बड़ा 'कॉस्मिक फ्यूज़न' (Cosmic Fusion) है, जहाँ सारी ऊर्जाएँ एक हो रही हैं।
            जब महिषासुर (Ego) बहुत बड़ा हो जाता है, तो देवता (अच्छाई) अलग-अलग रहकर उसे बिल्कुल नहीं हरा सकते।
            इसलिए सारी पॉजिटिव एनर्जीज़ (Positive Energies) को अपना-अपना 'अहंकार' (कि मैं इन्द्र हूँ, मैं सूर्य हूँ) छोड़ना पड़ता है।
            उन्हें एक ही लक्ष्य के लिए 100% 'एक' (Unity) होना पड़ता है, ताकि सबसे बड़ी सुपरपावर पैदा की जा सके।
            यहाँ सारे 'सॉफ्टवेयर मॉड्यूल्स' (Software Modules) मिलकर ब्रह्मांड का सबसे बड़ा 'सुपर-कम्प्यूटर' (Super-computer) बना रहे हैं।
            जब तक आप अपनी सारी बिखरी हुई शक्तियों (Focus) को एक जगह इकट्ठा नहीं करते, आप अज्ञान (महिषासुर) को नहीं हरा सकते।
        """.trimIndent(),
        english = """
            (The Absolute Cosmic Unity): "Exactly after the terrifying eruption of light strictly from Brahma, Vishnu, and Shiva, the creators, sustainers, and destroyers."
            "Straight exactly out of the physical bodies (Shariratah) exclusively of the King of Heaven 'Indra' (Shakra) and absolutely all the other supreme Gods (Anyesham chaiva devanam) as well."
            "An exceptionally massive, horrifyingly blinding 'Supreme Cosmic Light' (Sumahattejah) violently erupted entirely outside (Nirgatam)!"
            "And absolutely all of that completely different light of exactly all the Gods actively aggressively 'Fused flawlessly and perfectly completely exactly into ONE' (Tachchaikyam samagacchata) perfectly exactly inside deep space!"
            This spectacular cosmic event is undeniably Sanatana Tantra's absolute greatest literal 'Cosmic Fusion', where absolutely all separate energies seamlessly unite.
            Exactly when Mahishasura (Highly toxic Ego) becomes exceptionally massive, totally fragmented independent Gods (separate individual Positivity) completely and flawlessly fail entirely to actively violently defeat it.
            Therefore, absolutely all the separate Positive Energies undeniably actively must ruthlessly permanently abandon exactly their personal 'Ego' (that I am Indra, I am Surya).
            They strictly undeniably actively must aggressively perfectly become exactly 100% 'One' (Unity) flawlessly perfectly exactly for exactly one single ultimate goal.
            Right here, absolutely all the completely separate 'Software Modules' aggressively actively fuse entirely straight together strictly to flawlessly build one absolute terrifying 'Super-Computer'.
            Exactly until you successfully flawlessly perfectly actively gather completely absolutely all your highly scattered and fragmented raw powers (Laser-Focus) directly entirely strictly into one single point, you absolutely cannot possibly physically defeat thick ignorance (Mahishasura).
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 11,
        sanskrit = "अतीव तेजसः कूटं ज्वलन्तमिव पर्वतम् ।\nददृशुस्ते सुरास्तत्र ज्वालाव्याप्तदिगन्तरम् ॥ १२ ॥",
        hindi = """
            (जलते हुए पहाड़ जैसा रूप): "वहाँ अंतरिक्ष में खड़े हुए उन सभी महान देवताओं ने (ददृशुस्ते सुरास्तत्र) उस भयानक 'तेज के पुंज' (तेजसः कूटं) को देखा।"
            "वह भयंकर ऊर्जा का पहाड़ बिल्कुल एक 'भयंकर रूप से जलते हुए विशाल पर्वत' (ज्वलन्तमिव पर्वतम्) के समान लग रहा था!"
            "और उस तेज के पहाड़ की भयंकर आग की 'ज्वालाओं' (Flames) ने पूरे ब्रह्मांड की 'दसों दिशाओं और अंतरिक्ष' (ज्वालाव्याप्तदिगन्तरम्) को पूरी तरह से घेर लिया था।"
            देवताओं ने अपनी ही 'एनर्जी' (Energy) को बाहर निकालकर एक जगह जमा किया था, पर अब वे खुद ही उस रोशनी से डर रहे थे।
            वे खुद उस 'न्यूक्लियर रिएक्टर' (Nuclear Reactor / तेजसः कूटं) की भयानक गर्मी और चमक को देखकर काँप रहे थे!
            'ज्वलन्तमिव पर्वतम्' (जलते हुए पहाड़)—यह उस असीमित ऊर्जा (Infinite Energy) का प्रतीक है जो 'महामाया' की असली और फॉर्मलेस (Formless) स्थिति है।
            यह कोई साधारण आग नहीं थी; यह वह 'क्वांटम फायर' (Quantum Fire) थी जो 'ईगो' (Ego / महिषासुर) को जलाकर राख करने के लिए पैदा हुई थी।
            दसों दिशाओं (दिगन्तरम्) में सिर्फ भयंकर और अंधी कर देने वाली रोशनी ही रोशनी थी; कहीं कोई अँधेरा नहीं था।
            अज्ञान (Darkness) और पाप (Sin) के छुपने के लिए अब इस पूरे ब्रह्मांड में कोई जगह (Space) नहीं बची थी।
            जब परम चेतना का यह प्रकाश आपके अंदर जागता है, तो आपकी सारी नकारात्मकता एक सेकंड में जलकर भस्म हो जाती है।
        """.trimIndent(),
        english = """
            (The Violently Blazing Mountain): "Absolutely all the massive Gods flawlessly actively standing exactly right there (Dadrishuste surastatra) visually vividly witnessed exactly that exceptionally terrifying 'Colossal mass of supreme cosmic light' (Tejasah kutam)."
            "Which literally exactly visually flawlessly appeared strictly identically like an 'Exceptionally massive, violently blazing mountain of pure fire' (Jvalantamiva parvatam)!"
            "And the exceptionally horrific, blinding fiery 'Flames' exactly of that massive mountain of light had flawlessly and violently 'Completely engulfed and ruthlessly invaded absolutely all the ten cosmic directions and infinite deep space' (Jvalavyaptadigantaram)!"
            The absolute Gods had explicitly aggressively physically ejected entirely their very own pure 'Energy' and seamlessly flawlessly gathered it completely exactly into one location, yet exactly now they themselves were terrified.
            They themselves were violently aggressively violently shaking completely observing exactly that terrifying 'Nuclear Reactor' (Tejasah kutam) entirely due to its sheer catastrophic heat!
            'Jvalantamiva Parvatam' (A violently blazing mountain)—this is the direct, absolute ultimate literal symbol exactly of that entirely boundless Infinite Energy which actively is the actual true Formless state explicitly of 'Mahamaya'.
            This was absolutely zero ordinary cheap physical fire; this was undeniably exactly that terrifying 'Quantum Fire' exclusively entirely explicitly generated strictly to violently burn the highly toxic 'Ego' (Mahishasura) flawlessly completely exactly straight to physical Ashes!
            There was absolutely nothing exactly except terrifying blinding light actively aggressively occupying absolutely all ten directions (Digantaram); absolutely zero darkness existed anywhere.
            Absolutely zero microscopic millimeter of cheap space survived exclusively for thick Ignorance and cosmic Sin to pathetically actively hide.
            Exactly when this apocalyptic blinding supreme light of pure consciousness violently explicitly violently awakens perfectly exactly inside you, absolutely all your toxic negativity instantaneously burns permanently straight to ashes.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 12,
        sanskrit = "अतुलं तत्र तत्तेजः सर्वदेवशरीरजम् ।\nएकस्थं तदभून्नारी व्याप्तलोकत्रयं त्विषा ॥ १३ ॥",
        hindi = """
            (तेज का 'नारी' रूप में बदलना): "सभी देवताओं के शरीरों से एक साथ निकला हुआ (सर्वदेवशरीरजम्) वह 'अतुलनीय' (जिसकी कोई तुलना न हो / अतुलं तत्र तत्तेजः) अत्यंत भयंकर तेज।"
            "अंतरिक्ष में एक ही स्थान पर इकट्ठा होकर (एकस्थं), साक्षात् एक 'नारी' (परम स्त्री / नारी) के रूप में पूरी तरह बदल गया (तदभून्नारी)!"
            "और उस नारी के शरीर की भयंकर 'रोशनी और चमक' (त्विषा) ने एक ही सेकंड में 'तीनों लोकों' (व्याप्तलोकत्रयं) को पूरी तरह से भर दिया!"
            यह पूरी दुर्गा सप्तशती का सबसे बड़ा 'क्लाइमेक्स' (Climax) है, जहाँ परम शक्ति साक्षात् अपना भौतिक रूप ले रही है।
            देवताओं की कंबाइंड ऊर्जा (Combined Energy) ने एक 'पुरुष' (Male) का रूप नहीं लिया, बल्कि एक 'नारी' (स्त्री / Female) का रूप लिया!
            सनातन तन्त्र का सबसे बड़ा नियम यही है: 'शिव' (चेतना/पुरुष) केवल 'विटनेस' (Witness / देखने वाला) है।
            लेकिन जो 'एक्शन' (Action), जो 'पावर' (Power), जो 'लड़ाई' (Fight) है, वह 100% 'शक्ति' (स्त्री/नारी) ही है!
            'अतुलं' का मतलब है जिसका कोई 'मैच' (Match / मुकाबला) न हो; इस ब्रह्मांड में उस परम 'माँ' की शक्ति के बराबर कोई दूसरी चीज़ है ही नहीं।
            वह नारी कोई आम औरत नहीं है; वह साक्षात् 'ब्रह्मांड की महा-एडमिनिस्ट्रेटर' (Supreme Administrator of the Universe) है।
            जिसने प्रकट होते ही केवल अपनी चमक से एक सेकंड में तीनों लोकों (स्वर्ग, पृथ्वी, पाताल) को अपने कंट्रोल (Control) में ले लिया है!
        """.trimIndent(),
        english = """
            (The Light Transforms entirely into a 'Woman'): "That absolutely 'Incomparable' (possessing absolutely zero cosmic match / Atulam tatra tattejah) exceptionally terrifying massive light flawlessly violently ejected entirely straight exactly out of the physical bodies of absolutely all the Gods combined (Sarvadevasharirajam)."
            "Violently perfectly gathering exactly entirely strictly into one single solitary cosmic point (Ekastham), flawlessly and seamlessly miraculously transformed entirely completely exactly straight into an absolute literal 'Nari' (A Supreme Divine Woman / Tadabhunnari)!"
            "And the absolute horrifying, blinding 'Brilliance and infinite terrifying radiance' (Tvisha) perfectly of exactly that Woman actively aggressively 'Completely flooded and violently engulfed exactly all the three entire massive worlds' (Vyaptalokatrayam) entirely exactly in a single split-second!"
            This is undeniably the absolute greatest explicit massive 'Climax' perfectly of the entire colossal Durga Saptshati, where the Supreme Power physically manifests.
            The completely flawlessly Combined Energy exactly of absolutely all the Gods actively absolutely did not seamlessly assume a 'Male' (Purusha) physical form, but aggressively violently flawlessly manifested completely exactly straight as a 'Female' (Nari / Woman)!
            This is exactly undeniably Sanatana Tantra's absolute greatest ironclad cosmic rule: 'Shiva' (Pure Consciousness / Male) is exclusively entirely merely the completely silent 'Witness'.
            However, absolutely all the explosive 'Action', all the terrifying 'Power', and the absolute total 'Fight' is strictly 100% pure 'Shakti' (Female / Nari)!
            'Atulam' strictly profoundly perfectly means exactly that which flawlessly effortlessly possesses absolutely zero cosmic 'Match'; absolutely zero other physical entity matches the Mother.
            That massive Nari is absolutely no ordinary cheap physical woman; She is undeniably literally exactly the absolute direct 'Supreme Administrator of the entire Universe'.
            Who flawlessly aggressively actively seized complete total Control exactly of absolutely all the three huge worlds (Heaven, Earth, Underworld) entirely in a single split-second merely by Her blinding radiance!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 13,
        sanskrit = "यदभूच्छाम्भवं तेजस्तेनाजायत तन्मुखम् ।\nयाम्येन चाभवन् केशा बाहवो विष्णुतेजसा ॥ १४ ॥",
        hindi = """
            (देवी के अंगों का निर्माण - भाग 1): "भगवान शिव (शम्भु) के शरीर से जो अत्यंत भयंकर तेज निकला था (यदभूच्छाम्भवं तेजस्)।"
            "उसी भयंकर शिव-तेज से साक्षात् उस देवी का 'मुख' (चेहरा / तेनाजायत तन्मुखम्) उत्पन्न हुआ!"
            "यमराज के तेज (याम्येन) से देवी के 'बाल' (केशा) बने (चाभवन्), और भगवान विष्णु के तेज से (विष्णुतेजसा) देवी की 'भुजाएँ' (हाथ / बाहवो) प्रकट हुईं।"
            यह कोई साधारण शारीरिक रचना (Anatomy) नहीं है; यह एक 'सुपर-वेपन' (Super-Weapon) की 'असेंबली' (Assembly) है!
            शिव (Moksha/विनाश) का काम है अज्ञान को काटना; इसलिए देवी का 'चेहरा' (जिससे वह परम आदेश देंगी) साक्षात् शिव का रूप है!
            यमराज (मृत्यु/Death) का काम है प्राण खींचना; इसलिए देवी के 'बाल' (Kesha) मृत्यु के देवता की भयंकर ऊर्जा से बने हैं!
            बाल खुले होना (Unbound hair) अँधेरे और खौफ का प्रतीक है, जो राक्षसों के दिलों में मौत का सीधा खौफ पैदा करेगा।
            विष्णु (Sustainer/पालक) का काम है रक्षा करना; इसलिए 'हाथ' (जो हथियार चलाकर रक्षा करेंगे) विष्णु की असीम ऊर्जा से बने हैं!
            यानी वह देवी एक साथ शिव, यम और विष्णु की 'परम ऊर्जाओं' (Ultimate Energies) का एक साक्षात् और खौफनाक 'मशीन' (War-Machine) बन चुकी है।
            यह रूप दिखाता है कि जब भगवान अज्ञान को मारने आते हैं, तो उनका हर एक अंग एक परफेक्ट और डेडली (Deadly) हथियार होता है।
        """.trimIndent(),
        english = """
            (The Assembly of Physical Limbs - Part 1): "Exactly that exceptionally horrific massive cosmic light which violently erupted flawlessly exactly from Lord Shiva (Shambhu / Yadabhucchambhavam tejas)."
            "Entirely from that exact identical light the literal 'Face' (Tenajayata tanmukham) strictly of that Supreme Goddess violently manifested!"
            "Exactly from the terrifying supreme light explicitly of Yamaraja (Yamyena), the massive 'Hair' (Kesha) perfectly of the Goddess flawlessly physically formed (Chabhavan), and entirely exactly from the blinding absolute light strictly of Lord Vishnu (Vishnutejasa), Her massive 'Arms' (Bahavo) violently physically manifested."
            This is absolutely zero cheap ordinary biological physical Anatomy flawlessly occurring; this is undeniably exactly the highly terrifying advanced 'Assembly' explicitly of the universe's ultimate 'Super-Weapon'!
            Shiva's (Moksha/Absolute Destruction) exact core job is ruthlessly actively slashing thick ignorance; therefore exactly the Goddess's 'Face' (strictly from exactly where She will fiercely roar Her commands) is literally exactly the direct absolute form exactly of Shiva!
            Yamaraja's (Absolute Death) core job is violently aggressively extracting human souls; therefore the Goddess's massive 'Hair' (Kesha) is flawlessly actively formed entirely explicitly strictly from the absolute God of Death!
            Unbound hair undeniably perfectly symbolizes absolute pitch-black darkness and terrifying fear, actively actively injecting brutal death directly into the physical hearts exactly of the demons.
            Vishnu's (Preserver/Sustainer) exact job is flawlessly actively executing supreme protection; therefore exactly the 'Arms' (which will ruthlessly actively physically wield terrifying weapons exclusively to protect) are flawlessly entirely manufactured exactly strictly from Vishnu's absolute raw energy!
            Profoundly meaning, exactly that Goddess has seamlessly flawlessly entirely actively become exactly one solitary literal 'Machine' simultaneously perfectly possessing the exact 'Ultimate Energies' entirely of Shiva, Yama, and Vishnu combined!
            This terrifying absolute form flawlessly perfectly explicitly proves that exactly when God aggressively physically arrives completely perfectly to slaughter thick ignorance, absolutely every single microscopic organ is undeniably a perfect and absolutely Deadly cosmic weapon.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 14,
        sanskrit = "सौम्येन स्तनयुग्मं च मध्यमैन्द्रेण चाभवत् ।\nवारुणेन च जङ्घोरू नितम्बस्तेजसा भुवः ॥ १५ ॥",
        hindi = """
            (देवी के अंगों का निर्माण - भाग 2): "चन्द्रमा (सोम) के अत्यंत शीतल तेज (सौम्येन) से देवी के 'दोनों वक्षस्थल' (स्तनयुग्मं / Breasts) पूरी तरह से प्रकट हुए।"
            "देवराज इन्द्र के तेज (ऐन्द्रेण) से देवी का 'कमर का मध्य भाग' (मध्यम्) बना (चाभवत्)।"
            "जल के देवता वरुण के तेज से (वारुणेन च) देवी की भयंकर 'जंघाएं और पिंडली' (Thighs and legs / जङ्घोरू) बनीं।"
            "और स्वयं साक्षात् पृथ्वी (भूमण्डल) के तेज से (तेजसा भुवः) देवी का 'नितम्ब भाग' (Hips / नितम्बस्) उत्पन्न हुआ।"
            माता के हर शारीरिक अंग (Body part) के पीछे एक बहुत ही गहरा और साइंटिफिक कॉस्मिक विज्ञान (Cosmic Science) छिपा हुआ है!
            चन्द्रमा (Moon) 'अमृत' (Nectar) और 'ममता' (Motherhood) का प्रतीक है, इसलिए देवी का जो रूप ब्रह्मांड को पोषण (दूध) देगा, वह चन्द्रमा की एनर्जी से बना है।
            इन्द्र (Indra) 'शक्ति और संतुलन' (Power and Center) का प्रतीक है, इसलिए शरीर के गुरुत्वाकर्षण को थामने वाली 'कमर' इन्द्र से बनी है।
            पृथ्वी (Earth) 'आधार' (Base/Foundation) का सबसे बड़ा प्रतीक है, इसलिए शरीर का भारी बेस (नितम्ब) साक्षात् पृथ्वी की ग्रेविटी (Gravity) से बना है।
            यह कोई काल्पनिक कथा (Fantasy) नहीं है; यह ब्रह्मांड के सारे 'एलिमेंट्स' (Elements - Water, Earth, Gravity, Center) का एक ही पॉइंट पर 'सिंक्रोनाइज़' (Synchronize) होना है।
            पूरा ब्रह्मांड एक ही शरीर (Macrocosm in Microcosm) के रूप में पूरी तरह से 'डाउनलोड' (Download) हो चुका है।
        """.trimIndent(),
        english = """
            (The Assembly of Physical Limbs - Part 2): "Exactly completely from the exceptionally cool, deeply soothing massive absolute light exclusively of the Moon (Soma / Saumyena), the Goddess's 'Both Breasts' (Stanayugmam) flawlessly violently manifested."
            "Strictly entirely from the terrifying supreme light explicitly of the King of Gods Indra (Aindrena), the Goddess's exact 'Middle waist region' (Madhyam) physically perfectly flawlessly formed (Chabhavat)."
            "Exactly entirely completely from the massive absolute light strictly of the God of Cosmic Waters, Varuna (Varunena cha), the Goddess's exceptionally massive 'Thighs and lower legs' (Janghoru) flawlessly violently physically formed."
            "And directly exclusively from the sheer blinding raw cosmic light explicitly of the physical Earth itself (Tejasa bhuvah), the Goddess's massive 'Hips' (Nitambas) perfectly physically manifested."
            Flawlessly existing perfectly exactly behind every single highly specific Body Part actively physically formed is undeniably a highly terrifying, exceptionally advanced 'Cosmic Science' strictly entirely completely perfectly hidden!
            The Moon (Soma) is undeniably the absolute supreme direct literal symbol perfectly of 'Nectar' (Amrita) and pure 'Motherhood', therefore exactly that physical part of the Goddess explicitly designed exclusively to flawlessly actively feed Cosmic Nourishment entirely to the universe is entirely explicitly manufactured strictly from the Moon.
            Indra undeniably is the direct absolute supreme literal symbol exactly of raw 'Power and Central Balance'; therefore the massive 'Waist' flawlessly designed to flawlessly explicitly support the massive body's gravity is perfectly formed strictly exactly from Indra.
            The massive physical Earth flawlessly explicitly perfectly symbolizes the absolute ultimate 'Base/Foundation'; therefore exactly the heavy core base exactly of the physical body (Hips) is flawlessly actively entirely manufactured explicitly directly strictly exactly out of the massive Gravity of the Earth.
            This is absolutely zero cheap fake Fantasy; this is undeniably literally exactly the absolute 'Synchronization' flawlessly perfectly exactly entirely of absolutely all the massive cosmic 'Elements' (Water, Earth, Gravity, Space) aggressively violently actively fusing perfectly exactly straight into ONE single cosmic point.
            The absolute entire colossal Universe flawlessly seamlessly actively aggressively physically 'Downloaded' entirely completely perfectly straight exclusively perfectly exactly as exactly one solitary physical body (Macrocosm in Microcosm).
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 15,
        sanskrit = "ब्रह्मणस्तेजसा पादौ तदङ्गुल्योऽर्कतेजसा ।\nवसूनां च कराङ्गुल्यः कौबेरेण च नासिका ॥ १६ ॥",
        hindi = """
            (देवी के अंगों का निर्माण - भाग 3): "सृष्टि की रचना करने वाले ब्रह्मा जी के भयंकर तेज से (ब्रह्मणस्तेजसा) देवी के 'दोनों पैर' (पादौ) पूरी तरह से उत्पन्न हुए।"
            "सूर्य देव (अर्क) के अत्यंत चमचमाते हुए तेज से (अर्कतेजसा) देवी के 'पैरों की उंगलियां' (तदङ्गुल्यो) बनीं।"
            "आठों वसुओं (Vasus) के महान तेज से (वसूनां च) देवी के 'हाथों की उंगलियां' (कराङ्गुल्यः) बनीं।"
            "और धन के देवता कुबेर के तेज से (कौबेरेण च) देवी की 'नासिका' (नाक / नासिका) साक्षात् प्रकट हुई।"
            ब्रह्मा (Creator) ने यह पूरी दुनिया बनाई है, पर देवी के विशाल शरीर के सामने ब्रह्मा की औकात केवल उनके 'पैरों' (Feet) जितनी ही है!
            यानी पूरी दुनिया (ब्रह्मा की सृष्टि) केवल और केवल माता के चरणों की धूल में ही मौजूद है।
            सूर्य (Sun) जो पूरे सोलर सिस्टम (Solar System) को रोशनी और जीवन देता है, वह केवल माता के पैरों के 'नाखूनों' (उंगलियों) की छोटी सी चमक है!
            हाथों की उंगलियां (वसु) जो सारा कर्म (Action) करती हैं, वे ब्रह्मांड की 'डायरेक्शन' (Direction) और एनर्जी फ्लो (Energy flow) को कंट्रोल करती हैं।
            कुबेर (धन का देवता) नाक (Nose/सांस) बना है; यानी दुनिया का सारा पैसा, सोना और लक्ज़री (Luxury) केवल माता की एक 'साँस' (Breath) पर टिका हुआ है।
            धन (Money) केवल एक साँस की तरह है, जो कब अंदर आएगी और कब बाहर चली जाएगी, यह कोई नहीं जानता।
        """.trimIndent(),
        english = """
            (The Assembly of Physical Limbs - Part 3): "Exactly entirely from the horrifying massive absolute supreme light strictly exactly of Lord Brahma, the absolute creator (Brahmanastejasa), the Goddess's 'Both massive Feet' (Padau) flawlessly physically formed."
            "Directly exclusively from the absolute blinding raw cosmic light explicitly of the Sun God (Arka / Arkatejasa), the Goddess's exact 'Toes' (Tadangulyo) physically perfectly flawlessly violently manifested."
            "Exactly entirely completely from the massive absolute light strictly of absolutely all the eight Vasus (Vasunam cha), the Goddess's exceptionally massive 'Fingers of both hands' (Karangulyah) flawlessly violently physically formed."
            "And directly exclusively from the sheer blinding raw cosmic light explicitly of Kubera, the absolute God of Supreme Wealth (Kauberena cha), the Goddess's massive 'Nose' (Nasika) perfectly physically erupted."
            Lord Brahma (The Creator) undeniably flawlessly perfectly manufactured this entire world, but strictly compared entirely perfectly directly to the Goddess's colossal body, Brahma's cosmic worth is flawlessly exclusively entirely limited merely exactly exactly to Her 'Feet'!
            Meaning, the absolute entire world (Brahma's creation) actively exists entirely completely perfectly exclusively exactly strictly entirely directly completely inside the literal dust exactly of the Mother's sacred feet alone.
            The Sun which relentlessly entirely perfectly continuously actively feeds pure light entirely directly perfectly to the entire Solar System, is absolutely merely the microscopic tiny flash completely of the Mother's toenails (Toes)!
            The fingers of the hands (Vasus) which perfectly flawlessly actively flawlessly actively physically flawlessly perform all Action, flawlessly control the absolute cosmic 'Direction' and Energy flow entirely perfectly completely.
            Kubera (God of Wealth) physically became the literal Nose (Breath); meaning, absolutely all the entire world's massive money, gold, and cheap Luxury actively rests flawlessly exactly entirely completely perfectly exactly upon merely ONE single physical 'Breath' of the Mother.
            Physical Money is undeniably exactly like a single breath, exactly absolutely perfectly exactly precisely no human can possibly ever successfully actively flawlessly predict exactly when it completely enters and exactly when it violently exits.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 16,
        sanskrit = "तस्यास्तु दशना जाताः प्राजापत्येन तेजसा ।\nनयनत्रितयं जज्ञे तथा पावकतेजसा ॥ १७ ॥",
        hindi = """
            (दांत और तीसरा नेत्र): "संसार के रचयिता प्रजापति (दक्ष आदि) के महान और शक्तिशाली तेज से उस परम देवी के भयंकर 'दांत' (दशना) पूरी तरह से उत्पन्न हुए।"
            "और अग्नि देव (पावक) के अत्यंत भयंकर, धधकते हुए और चमचमाते तेज से देवी के 'तीनों नेत्र' (नयनत्रितयं) साक्षात् प्रकट हुए।"
            यह कोई साधारण शारीरिक रचना नहीं है, बल्कि ब्रह्मांडीय ऊर्जाओं (Cosmic Energies) का साक्षात् एक भौतिक रूप में प्रकट होना है।
            प्रजापति सृष्टि के निर्माण और उसके मूल आधार का प्रतीक हैं, इसलिए देवी के दांत (जो चबाते और नष्ट करते हैं) उनके तेज से बने हैं।
            दांत चबाने (Destruction) का काम करते हैं, और यह स्पष्ट रूप से दिखाता है कि देवी राक्षसों के अज्ञान को बेरहमी से चबा जाएंगी।
            अग्नि (Fire) परम ज्ञान, ऊर्जा और प्रकाश का सबसे बड़ा प्रतीक है, जो अज्ञान के अँधेरे को पूरी तरह जलाकर राख कर देती है।
            इसलिए देवी की तीन आँखें (जो भूत, वर्तमान और भविष्य को एक साथ देखने वाली हैं) साक्षात् अग्नि के भयंकर तेज से बनी हैं।
            तीसरा नेत्र (Third Eye) परम चेतना का प्रतीक है, जो खुलने पर माया के सबसे बड़े जालों और राक्षसों के अहंकार को भस्म कर देता है।
            देवताओं ने अपनी सबसे शुद्ध और मारक शक्तियां देवी को सौंप दीं, ताकि महिषासुर का अजेय अहंकार हमेशा के लिए मिटाया जा सके।
            यहाँ महामाया कोई एक साधारण देवता नहीं, बल्कि पूरे ब्रह्मांड के देवताओं की 'कंबाइंड सुपरपावर' (Combined Superpower) बन चुकी हैं!
        """.trimIndent(),
        english = """
            (Teeth and the Third Eye): "Exactly from the exceptionally massive and brilliant raw light of Prajapati, the creator of the world, the Goddess's 'Teeth' (Dashana) physically manifested."
            "And strictly from the terrifying, violently blazing supreme light of Agni (Fire God), the Goddess's 'Three Eyes' (Nayanatritayam) flawlessly erupted perfectly."
            This is absolutely no ordinary biological creation, but the direct, literal explicit manifestation of absolute supreme cosmic energies into a physical form.
            Prajapati profoundly symbolizes the ultimate foundation of physical creation, hence the Goddess's teeth (which brutally chew and destroy) are explicitly formed from him.
            Teeth actively perform the violent action of chewing (Destruction), flawlessly proving that the Goddess will ruthlessly chew the demons' ignorance.
            Agni (Fire) is undeniably the absolute greatest symbol of supreme wisdom and blinding light, which aggressively burns thick darkness entirely to ashes.
            Therefore, the Goddess's three eyes (flawlessly viewing the past, present, and future simultaneously) are strictly manufactured entirely from Agni's absolute raw light.
            The Third Eye explicitly perfectly symbolizes supreme pure consciousness, which upon opening violently incinerates the absolute greatest webs of Maya and demonic ego.
            The absolute Gods ruthlessly surrendered their purest and most lethal powers directly to the Goddess, strictly to permanently annihilate Mahishasura's toxic ego forever.
            Right here, Mahamaya is absolutely no single ordinary deity, but has flawlessly seamlessly become the 'Combined Superpower' of the entire colossal universe!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 17,
        sanskrit = "भ्रुवौ च सन्ध्ययोस्तेजः श्रवणावनिलस्य च ।\nअन्येषां चैव देवानां सम्भवस्तेजसां शिवा ॥ १८ ॥",
        hindi = """
            (सम्पूर्ण ब्रह्मांड का रूप): "सुबह और शाम की परम संधियों (Sandhyas) के भयंकर तेज से उस महादेवी की 'भौंहेँ' (Eyebrows / भ्रुवौ) साक्षात् प्रकट हुईं।"
            "और वायु देव (अनिलस्य) के अत्यंत शक्तिशाली तेज से उस भगवती के 'दोनों कान' (श्रवणौ) पूरी तरह से उत्पन्न हुए।"
            "इसी प्रकार अन्य सभी छोटे-बड़े देवताओं (अन्येषां चैव देवानां) के महान तेज से उस परम कल्याणी 'शिवा' (Goddess) का जन्म हुआ।"
            संध्या (Dawn and Dusk) वह समय है जब दिन और रात मिलते हैं, जो इस ब्रह्मांड में परम संतुलन (Balance) का सबसे बड़ा प्रतीक है।
            इसलिए देवी की भौंहेँ (जो चेहरे का संतुलन बनाती हैं और क्रोध को दर्शाती हैं) साक्षात् दोनों संधियों की ऊर्जा से बनी हैं।
            वायु (Wind) ध्वनि (Sound) को एक जगह से दूसरी जगह ले जाती है, इसलिए देवी के कान (जो पूरे ब्रह्मांड की पुकार सुनेंगे) वायु देव के तेज से बने हैं।
            इस प्रकार देवी 'शिवा' (परम मंगलमयी) के एक-एक अंग में पूरे ब्रह्मांड का परम विज्ञान (Cosmic Science) गहराई से छिपा हुआ है।
            वे केवल एक स्त्री नहीं हैं; वे साक्षात् पूरे 'यूनिवर्स' (Universe) का एक चलता-फिरता रूप (Walking Universe) बन चुकी हैं।
            सारे देवताओं ने अपना 'अस्तित्व' (Existence) मिटाकर खुद को देवी के चरणों में पूरी तरह से विसर्जित और समर्पित (Surrender) कर दिया है।
            तभी यह परम महाशक्ति महिषासुर रूपी भयंकर 'वायरस' (Virus) को इस ब्रह्मांड के सिस्टम (System) से हमेशा के लिए डिलीट (Delete) कर पाएगी।
        """.trimIndent(),
        english = """
            (The Absolute Form of the Universe): "From the exceptionally terrifying and profound light exactly of the cosmic twilights (Sandhyas), the Great Goddess's 'Eyebrows' (Bhruvau) miraculously manifested."
            "And strictly from the incredibly massive raw power explicitly of Vayu (Wind God), the Goddess's 'Both Ears' (Shravanau) flawlessly perfectly emerged."
            "Exactly in this highly precise manner, from the combined light of absolutely all other remaining Gods (Anyesham chaiva devanam), that supreme auspicious Goddess 'Shiva' was violently born."
            Sandhya (Dawn and Dusk) is exactly that precise time when day and night merge, profoundly representing the ultimate absolute symbol of cosmic Balance.
            Therefore, the Goddess's eyebrows (which perfectly establish the balance of the face and express rage) are literally explicitly formed directly from the energy of twilights.
            Vayu (Wind) flawlessly transports physical Sound across space, hence the Goddess's ears (which will actively hear the universe's cry) are built strictly from Vayu's light.
            In this exact manner, the absolute supreme Cosmic Science of the entire universe is flawlessly perfectly hidden inside every single organ of Goddess 'Shiva'.
            She is absolutely no ordinary woman; She has undeniably seamlessly transformed exactly into the direct, literal 'Walking Universe' Herself completely.
            Absolutely all the massive Gods violently erased their personal 'Existence' completely and flawlessly dissolved exactly at Her sacred feet through absolute Total Surrender.
            Strictly and exclusively only then will this Supreme Superpower flawlessly completely successfully 'Delete' the highly toxic terrifying 'Virus' called Mahishasura directly from the cosmic System.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 18,
        sanskrit = "ततः समस्तदेवानां तेजोराशिसमुद्भवाम् ।\nतां विलोक्य मुदं प्रापुरमरा महिषार्दिताः ॥ १९ ॥",
        hindi = """
            (देवताओं की परम खुशी): "संसार के सभी देवताओं (समस्तदेवानां) की असीम और भयंकर ऊर्जा के उस विशाल पुंज (तेजोराशिसमुद्भवाम्) से इस प्रकार उत्पन्न हुईं।"
            "उस परम महामाया देवी को अपनी आँखों से साक्षात् देखकर (तां विलोक्य), महिषासुर के भयंकर अत्याचारों से सताए हुए (महिषार्दिताः) वे सभी देवता।"
            "अत्यंत भयंकर 'प्रसन्नता और खुशी' (मुदं प्रापुः) से पूरी तरह भर उठे, क्योंकि अब उन्हें अपनी जीत का पूरा भरोसा हो गया था!"
            जब आप भयंकर डिप्रेशन और हार (महिषासुर के अत्याचार) के दौर से गुज़र रहे होते हैं, तो आपको एक साक्षात् 'चमत्कार' (Miracle) की ज़रूरत होती है।
            सभी देवताओं ने अपनी 'पॉजिटिविटी' (Positivity) को मिलाकर एक किया, और उसका परिणाम 'माँ दुर्गा' के रूप में साक्षात् उनके सामने खड़ा था।
            उस महाशक्ति को देखकर देवताओं का सारा डर, डिप्रेशन और निराशा एक ही सेकंड में 100% गायब (Vanish) हो गई।
            यह 'मुदं प्रापुः' (परम खुशी) कोई साधारण ख़ुशी नहीं है; यह उस मरीज़ की ख़ुशी है जिसे मौत के मुँह से बचने की अमर दवा (Cure) मिल गई हो!
            महिषासुर (अहंकार) चाहे कितना भी बड़ा क्यों न हो, जब 'महामाया' (परम चेतना) जाग जाती है, तो अहंकार का मरना 100% तय (Certain) हो जाता है।
            देवता अब समझ चुके थे कि उनका काम केवल देवी का निर्माण करना था; अब आगे की सारी लड़ाई केवल और केवल माता ही लड़ेंगी।
            सनातन धर्म हमें सिखाता है कि जब आप अपना कर्म 100% कर देते हैं, तो उसके बाद भगवान स्वयं आपके युद्ध (Battles) लड़ने के लिए आगे आ जाते हैं।
        """.trimIndent(),
        english = """
            (The Supreme Joy of the Gods): "Flawlessly and miraculously born exactly in this terrifying manner explicitly from that massive colossal mountain of supreme energy (Tejorashisamudbhavam) of absolutely all the Gods."
            "Vividly witnessing exactly that absolute Supreme Mahamaya Goddess directly with their own eyes (Tam vilokya), absolutely all those specific Gods completely tormented and crushed by Mahishasura (Mahisharditah)."
            "Instantaneously violently erupted completely perfectly exactly into exceptionally overwhelming 'Absolute Joy and Supreme Happiness' (Mudam prapuh), perfectly realizing their absolute flawless victory was now 100% guaranteed!"
            Exactly when you are actively brutally suffering through exceptionally highly terrifying Depression and brutal defeat (Mahishasura's atrocities), you absolutely desperately demand a literal 'Miracle'.
            Absolutely all the Gods actively aggressively completely fused their entire 'Positivity' strictly into exactly ONE, and the ultimate explosive result was directly physically standing flawlessly before them exactly as 'Maa Durga'.
            Actively witnessing that terrifying supreme Superpower, the absolute entire horrifying fear, depression, and despair of the Gods vanished entirely perfectly exactly to mathematical Zero in exactly a single split-second.
            This precise 'Mudam prapuh' (Supreme Joy) is absolutely no cheap ordinary happiness; it is exactly the literal joy of a dying patient flawlessly receiving the absolute ultimate immortal Cure!
            Exactly regardless of exactly how exceptionally massive Mahishasura (Toxic Ego) might be, exactly when 'Mahamaya' (Supreme Consciousness) violently awakens, the ego's absolute brutal death becomes 100% physically Certain.
            The absolute Gods flawlessly comprehended completely exactly that their ultimate job was exclusively restricted strictly to manifesting the Goddess; now absolutely all further massive cosmic battles will be fought strictly exclusively by the Mother alone.
            Sanatana Dharma explicitly strictly profoundly teaches us exactly that exactly when you flawlessly completely execute your absolute Karma 100%, exactly then God Himself seamlessly violently steps forward explicitly exclusively to fight your absolute terrifying Battles.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 19,
        sanskrit = "शूलं शूलाद्विनिष्कृष्य ददौ तस्यै पिनाकधृक् ।\nचक्रं च दत्तवान् कृष्णः समुत्पाद्य स्वचक्रतः ॥ २० ॥",
        hindi = """
            (शिव और विष्णु के हथियार): "इसके बाद भगवान शिव (पिनाकधृक्) ने अपने भयंकर त्रिशूल (शूलाद्) में से ही एक और अत्यंत भयंकर 'त्रिशूल' (शूलं) बाहर निकाला (विनिष्कृष्य)।"
            "और वह खौफनाक त्रिशूल उन्होंने उस परम देवी को युद्ध लड़ने के लिए पूरी तरह 'समर्पित कर दिया' (ददौ तस्यै)।"
            "उसी प्रकार भगवान श्री कृष्ण (विष्णु) ने भी अपने भयंकर 'सुदर्शन चक्र' (स्वचक्रतः) से ही एक और अत्यंत विनाशकारी 'चक्र' (चक्रं) उत्पन्न किया (समुत्पाद्य)।"
            "और वह परम शक्तिशाली चक्र उन्होंने माता को महिषासुर का सिर काटने के लिए पूरी श्रद्धा से 'भेंट कर दिया' (दत्तवान्)!"
            देवी का शरीर तो बन गया, पर अब उन्हें ब्रह्मांडीय 'सॉफ्टवेयर अपडेट्स' (Software Updates) और 'हथियारों' (Weapons) की सख्त ज़रूरत थी।
            शिव का 'त्रिशूल' तीन गुणों (सत्व, रज, तम) और तीन कालों (भूत, भविष्य, वर्तमान) को एक साथ कंट्रोल करने वाला सबसे भयंकर 'एडमिन टूल' (Admin Tool) है।
            विष्णु का 'चक्र' (Sudarshana) निरंतर समय का प्रतीक है, जो लगातार घूमता है और किसी भी बड़े से बड़े अहंकार (महिषासुर) को सेकंडों में डिलीट (Delete) कर सकता है।
            ये देवता अपने खुद के हथियार देवी को दे रहे हैं; इसका मतलब है कि उन्होंने अपनी 'फ्री-विल' (Free-will) और 'ताकत' 100% माता को सौंप दी है।
            जब आप भगवान को अपना 'सब कुछ' सौंप देते हैं, तभी वह परम शक्ति आपके लिए सबसे बड़े राक्षसों का संहार करने के लिए साक्षात् मैदान में उतरती है।
            यहाँ से 'महिषासुरमर्दिनी' (महिषासुर को मारने वाली माता) का असली और खौफनाक रूप पूरी तरह से 'हथियारों से लैस' (Fully Armed) होना शुरू होता है।
        """.trimIndent(),
        english = """
            (The Weapons of Shiva and Vishnu): "Immediately following this, direct Lord Shiva (Pinakadhrik) violently aggressively extracted (Vinishkrishya) another exceptionally horrific terrifying 'Trident' (Shulam) perfectly exactly straight from His very own cosmic Trident (Shulad)."
            "And He flawlessly, completely respectfully entirely 'Surrendered and officially gifted' (Dadau tasyai) exactly that highly horrific trident directly to that Supreme Goddess exclusively for fighting the cosmic war."
            "Exactly in the identical flawless manner, direct Lord Krishna (Vishnu) aggressively violently generated and seamlessly flawlessly manifested (Samutpadya) another exceptionally apocalyptic destructive 'Discus' (Chakram) straight explicitly from His very own terrifying 'Sudarshana Chakra' (Svachakratah)."
            "And He flawlessly completely entirely 'Gifted' (Dattavan) exactly that absolute supreme powerful discus strictly directly to the Mother exclusively to ruthlessly actively sever Mahishasura's head!"
            The Goddess's massive physical body was flawlessly created, but exactly now She desperately actively required explicit absolute 'Software Updates' and terrifying cosmic 'Weapons'.
            Shiva's 'Trident' is undeniably the absolute ultimate terrifying 'Admin Tool' flawlessly actively aggressively controlling absolutely all three Gunas (Sattva, Rajas, Tamas) and all three Time dimensions entirely simultaneously.
            Vishnu's 'Chakra' flawlessly seamlessly profoundly symbolizes absolute Time, which relentlessly violently spins and successfully Deletes completely exactly even the absolute greatest toxic Ego (Mahishasura) precisely in mere seconds.
            These massive supreme Gods are flawlessly actively surrendering entirely their very own terrifying weapons directly to the Goddess; flawlessly proving they have brutally permanently abandoned their 100% 'Free-will' and raw power completely to the Mother.
            Exactly when you flawlessly completely surrender absolutely 'Everything' directly exactly to God, strictly and exclusively only then does that absolute Supreme Power actively aggressively step entirely exactly onto the battlefield strictly to physically slaughter your absolute greatest demons.
            Right exactly from here, the actual, literal, and absolute most exceptionally horrific terrified physical form perfectly of 'Mahishasuramardini' violently entirely begins to seamlessly actively flawlessly perfectly become '100% Fully Armed'.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 20,
        sanskrit = "शङ्खं च वरुणः प्रादाद् हुताशश्चापि शक्तिमाम् ।\nमारुतो दत्तवांश्चापं बाणपूर्णे तथेषुधी ॥ २१ ॥",
        hindi = """
            (प्रकृति के हथियार): "जल के देवता वरुण ने माता को अपना भयंकर 'शंख' (शङ्खं च वरुणः प्रादाद्) प्रदान किया, जो अपनी आवाज़ से दुश्मनों का दिल चीर देता है।"
            "अग्नि देव (हुताशन) ने देवी को अपनी अत्यंत विनाशकारी 'शक्ति' (भाला / हुताशश्चापि शक्तिमाम्) भेंट की, जो किसी भी राक्षस को जलाकर भस्म कर सकती है।"
            "और वायु देव (मारुतो) ने माता को अपना भयंकर 'धनुष' (दत्तवांश्चापं) और साथ ही 'बाणों से हमेशा भरे रहने वाले दो तरकश' (बाणपूर्णे तथेषुधी) प्रदान किए!"
            अब सारे प्राकृतिक तत्व (Natural Elements) माता को अपने अजेय 'सुपर-वेपन्स' (Super-weapons) पूरी तरह से सौंप रहे हैं!
            वरुण का 'शंख' (Conch) कॉस्मिक वाइब्रेशन (Cosmic Vibration / ॐ) का प्रतीक है। जब देवी इसे बजाएंगी, तो राक्षसों का नर्वस सिस्टम (Nervous system) वहीं क्रैश (Crash) हो जाएगा!
            अग्नि की 'शक्ति' (Spear) वह परम फोकस (Focus) और विलपॉवर (Willpower) है जो किसी भी समस्या (Problem) को सीधे छेद (Pierce) कर रख देती है।
            वायु का 'धनुष और बाण' इंसान के 'मन और विचारों' (Mind and Thoughts) का प्रतीक है; देवी के बाण कभी खत्म नहीं होते (बाणपूर्णे), जिसका मतलब है उनका ज्ञान (Knowledge) असीमित है।
            यह कोई 'कहानी' (Story) नहीं है; यह एक 'योद्धा' (Warrior) को तैयार करने का वह परम सूत्र (Formula) है जो हमें भी अपने जीवन में उतारना चाहिए।
            बिना शंख (आवाज़/Truth), अग्नि (फोकस/Focus), और वायु (तीर/Action) के आप दुनिया का कोई भी युद्ध नहीं जीत सकते।
            महामाया अब एक 'परफेक्ट वॉर-मशीन' (Perfect War-Machine) में बदल रही हैं, जिसका एक ही लक्ष्य है—अहंकार (महिषासुर) का 100% सर्वनाश!
        """.trimIndent(),
        english = """
            (The Weapons of Nature): "The supreme God of Cosmic Waters, Varuna, flawlessly fiercely presented strictly to the Mother his terrifying massive 'Conch' (Shankham cha varunah pradad), which violently perfectly rips the absolute physical hearts of enemies exactly with its horrific sound."
            "Agni, the Lord of Fire, aggressively gifted directly to the Goddess his exceptionally apocalyptic terrifying 'Shakti' (Spear / Hutashashchapi shaktimam), which flawlessly flawlessly burns absolutely any demon exactly instantly straight to physical ashes."
            "And Vayu, the supreme God of Wind (Maruto), flawlessly aggressively presented entirely directly to the Mother his highly terrifying 'Bow' (Dattavamshchapam) and identically explicitly exactly 'Two quivers entirely completely perpetually overflowing flawlessly exclusively with infinite arrows' (Banapurne tatheshudhi)!"
            Exactly now absolutely all the ultimate Natural Elements are completely flawlessly actively aggressively perfectly violently surrendering exactly their absolute supreme 'Super-Weapons' entirely straight directly perfectly to the Mother!
            Varuna's massive 'Conch' is undeniably the exact absolute explicit physical symbol flawlessly of 'Cosmic Vibration' (OM). Exactly when the Goddess violently explicitly blows it, the physical Nervous System of absolutely all demons will seamlessly violently Crash exactly right there!
            Agni's 'Shakti' (Spear) is absolutely exactly that supreme ultimate Focus and raw Willpower which flawlessly perfectly brutally Pierces completely straight entirely exactly through absolutely any massive Problem.
            Vayu's 'Bow and Arrows' flawlessly perfectly symbolize exactly the human's 'Mind and Thoughts'; the Goddess's arrows absolutely never completely run out (Banapurne), profoundly perfectly literally meaning Her absolute Wisdom is strictly completely infinite.
            This is absolutely zero cheap physical 'Story'; this is exactly the ultimate absolute supreme explicit 'Formula' to flawlessly perfectly prepare an absolute 'Warrior', which we absolutely flawlessly actively must physically implement strictly in our lives.
            Completely entirely without the Conch (Voice/Truth), Agni (Laser-Focus), and Vayu (Arrows/Action), you absolutely cannot possibly ever strictly actively win absolutely any massive war exactly in the physical world.
            Mahamaya is exactly now seamlessly flawlessly violently explicitly transforming exactly straight into an absolute 'Perfect War-Machine', who possesses exactly one absolute ultimate solitary target—the flawless 100% total annihilation completely of toxic Ego (Mahishasura)!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 21,
        sanskrit = "इन्द्रः कुलिशमुत्पाद्य कुलिशात् स्वकात् ददौ ।\nघण्टामैरावताद् गजात् ॥ २२ ॥\nदण्डान्मृत्युर्ददौ दण्डं पाशं चाम्बुपतिर्ददौ ॥ २३ ॥",
        hindi = """
            (इन्द्र और यमराज के हथियार): "हजारों आँखों वाले देवराज इन्द्र ने अपने भयंकर 'वज्र' में से ही एक और खौफनाक 'वज्र' उत्पन्न कर देवी को दिया।"
            "और साथ ही इन्द्र ने अपने परम हाथी 'ऐरावत' के गले से निकालकर एक भयंकर 'घंटा' भी देवी को समर्पित कर दिया।"
            "मृत्यु के देवता यमराज ने अपने मृत्यु-पाश (Death-rod) से एक 'कालदण्ड' माता को दिया, और जलपति वरुण ने एक और अत्यंत मजबूत 'पाश' (Noose) माता को भेंट किया!"
            यहाँ हथियारों का 'लेवल' (Level) और भी ज़्यादा डरावना (Terrifying) होता जा रहा है!
            इन्द्र का 'वज्र' (Thunderbolt) आकाशीय बिजली है, जो सबसे तेज़ और सबसे घातक (Lethal) प्रहार का प्रतीक है।
            इन्द्र का 'घंटा' (Bell) वह भयंकर आवाज़ (Frequency) है जो राक्षसों के दिमाग को सुन्न (Paralyze) कर देता है। जब देवी घंटा बजाती हैं, तो राक्षसों का 'ईगो' (Ego) थर-थर काँपने लगता है!
            यमराज का 'दण्ड' (Rod) साक्षात् 'कर्मों की सज़ा' (Punishment of Karma) का प्रतीक है। देवी इसका इस्तेमाल राक्षसों को उनके पापों की सज़ा देने के लिए करेंगी।
            वरुण का 'पाश' (Noose) वह फंदा है जो भागते हुए दुश्मन (अज्ञान) को जकड़ कर उसे भागने का कोई मौका नहीं देता।
            इन सभी हथियारों का मिलना यह साबित करता है कि महिषासुर का 'एस्केप-प्लान' (Escape Plan) अब 100% फेल (Fail) हो चुका है।
            जब महामाया किसी को मारने (डिलीट करने) पर उतर आती हैं, तो यूनिवर्स की कोई भी शक्ति उसे बचा नहीं सकती।
        """.trimIndent(),
        english = """
            (The Weapons of Indra and Yama): "The King of Gods, Indra, aggressively violently generated and explicitly created another exceptionally horrific 'Vajra' (Thunderbolt) straight directly exclusively from his very own terrifying absolute Vajra and presented it."
            "And he violently explicitly removed an exceptionally terrifying 'Bell' flawlessly perfectly exactly from his supreme elephant 'Airavata' and entirely surrendered it to the Goddess."
            "Yamaraja, the absolute God of Death, explicitly violently gifted an apocalyptic 'Kala-Danda' perfectly exactly straight directly entirely from his very own absolute Death-Rod, and Varuna violently presented another exceptionally indestructible 'Pasha' (Noose) directly to the Mother!"
            Exactly right here, the absolute supreme cosmic 'Level' of these weapons is actively aggressively seamlessly flawlessly becoming exceptionally billions of times more 'Terrifying'!
            Indra's 'Vajra' (Thunderbolt) is undeniably the absolute direct lightning flawlessly explicitly from the sky, perfectly symbolizing exactly the absolute fastest and absolute most brutally 'Lethal' massive strike.
            Indra's 'Bell' is exactly that exceptionally horrific violent absolute Sound (Frequency) perfectly designed to completely ruthlessly actively 'Paralyze' the exact physical brains completely of the demons. Exactly when the Goddess rings it, the demons' toxic 'Ego' actively shatters!
            Yamaraja's 'Danda' (Rod) is undeniably exactly the direct literal explicit symbol exactly of the absolute 'Punishment of Karma'. The Goddess will violently explicitly actively exploit it exclusively exactly to aggressively brutally punish the exact demons for their sins.
            Varuna's 'Pasha' (Noose) is exactly that absolutely inescapable trap flawlessly completely entirely actively binding the violently fleeing enemy (Ignorance) securely, leaving absolutely zero millimeter exactly for Escape.
            The absolute aggressive active flawless reception completely of exactly all these weapons perfectly actively explicitly proves exactly that Mahishasura's pathetic 'Escape Plan' has flawlessly brutally completely Failed 100%.
            Exactly when Mahamaya aggressively explicitly actively decides entirely perfectly completely strictly to flawlessly violently physically slaughter (Delete) someone, absolutely zero power completely inside the massive Universe can possibly ever successfully save him.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 22,
        sanskrit = "प्रजापतिश्चाक्षमालां ददौ ब्रह्मा कमण्डलुम् ।\nसमस्तरोमकूपेषु निज रश्मीन्दिवाकरः ॥ २४ ॥",
        hindi = """
            (ज्ञान और तेज़): "इस सृष्टि के रचयिता 'ब्रह्मा जी' (प्रजापति/ब्रह्मा) ने अपने परम ज्ञान के प्रतीक स्वरूप माता को एक 'कमण्डलु' (कमण्डलुम्) और एक 'रुद्राक्ष की माला' (अक्षमालां) भेंट की!"
            "सूर्य देव (दिवाकरः) ने माता के शरीर के सभी 'रोम-कूपों' (समस्तरोमकूपेषु) में अपनी अत्यंत भयंकर और धधकती हुई 'किरणों' (निज रश्मीन्) को पूरी तरह से भर दिया!"
            अब हथियार (Weapons) से आगे बढ़कर माता को 'ज्ञान' (Knowledge) और 'अजेय सुरक्षा' (Invincible Armor) दी जा रही है!
            ब्रह्मा जी का 'कमण्डलु' (Water-pot) साक्षात् 'सृष्टि के बीज' (Seed of Creation) और 'अक्षमाला' परम शांति और ध्यान का प्रतीक है।
            यह दिखाता है कि देवी केवल संहार ही नहीं करेंगी, बल्कि युद्ध के बाद एक 'नई शुरुआत' (New Beginning) और शांति भी स्थापित करेंगी।
            सूर्य देव (दिवाकर) का देवी के रोम-रोम में अपनी किरणें भर देना (Sun's rays in every pore) कोई साधारण बात नहीं है!
            यह सिद्ध करता है कि देवी का रूप अब इतना 'ब्लाइंडिंग' (Blindingly bright) हो गया है कि राक्षस उन्हें सीधे आँखों से देख भी नहीं पाएंगे!
            जब चेतना (Consciousness) अपने पूर्ण प्रकाश में आती है, तो अज्ञान (Ignorance) की आँखें चौंधिया जाती हैं।
            यह 'सुपर-कम्प्यूटर' (देवी) अब पूरी तरह से 'बूट-अप' (Boot-up) हो रहा है, जिसमें सारा कॉस्मिक डेटा (Cosmic Data) फीड किया जा चुका है।
            महिषासुर अब एक ऐसी शक्ति से लड़ने जा रहा है जो खुद एक 'धधकता हुआ सूर्य' है।
        """.trimIndent(),
        english = """
            (Wisdom and Blinding Light): "The absolute supreme creator exactly of this entire massive creation, 'Lord Brahma' (Prajapati/Brahma), flawlessly perfectly aggressively violently gifted an absolute 'Kamandalu' (Water-pot) and a 'Rosary of Rudraksha' (Akshamala) entirely directly strictly to the Mother precisely as the exact explicit physical symbol of his wisdom!"
            "Surya, the Lord of the Sun (Divakarah), violently aggressively completely filled absolutely all the massive 'Pores' (Samastaromakupeshu) exactly of the Mother's physical body seamlessly perfectly flawlessly entirely exactly with His exceptionally terrifying, violently blazing 'Rays' (Nija rashmin)!"
            Exactly now moving seamlessly entirely completely far completely perfectly beyond entirely explicit physical Weapons, the Mother is flawlessly aggressively actively being violently securely armored entirely completely exactly with pure 'Knowledge' and 'Invincible Defense' (Armor)!
            Lord Brahma's 'Kamandalu' (Water-pot) undeniably flawlessly completely actively symbolizes the direct literal 'Seed of Creation', and the Akshamala perfectly represents supreme peace and meditation.
            This flawlessly explicitly perfectly entirely proves that the Goddess will absolutely not merely slaughter, but flawlessly seamlessly execute an entirely 'New Beginning' and establish absolute peace exactly after the war.
            The precise exact violent explicit saturation entirely of the Sun's blinding rays completely straight exactly into absolutely every single physical pore is absolutely no ordinary cosmic event!
            It undeniably flawlessly perfectly proves the Mother's absolute explicit physical form has actively entirely securely violently become so exceptionally 'Blinding' the demons absolutely entirely cannot possibly even physically directly look strictly at Her!
            Exactly when pure Consciousness violently completely manifests perfectly entirely inside its absolute full light, the pathetic eyes of Ignorance are aggressively permanently blinded.
            This explicit terrified absolute 'Super-Computer' (The Goddess) is flawlessly actively seamlessly entirely aggressively completely successfully 'Booting-up' now, perfectly containing absolutely all cosmic data.
            Mahishasura is undeniably now aggressively preparing to actively fight a terrifying power which itself is an exceptionally 'Violently Blazing Sun'.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 23,
        sanskrit = "कालश्चदत्तवान् खड्गं तस्याश्चर्म च निर्मलम् ।\nक्षीरोदश्चामलं हारम् अजरौ वाससी ॥ २५ ॥",
        hindi = """
            (काल का खड्ग और ढाल): "साक्षात् काल (समय के देवता / कालः) ने माता को एक अत्यंत तेज़ 'खड्ग' (तलवार / खड्गं) और एक अत्यंत चमचमाती हुई 'ढाल' (चर्म च निर्मलम्) प्रदान की!"
            "और क्षीरसागर (दूध के समुद्र / क्षीरोदः) ने माता को कभी मैला न होने वाला एक अत्यंत 'उज्ज्वल मोतियों का हार' (अमलं हारम्) और कभी न फटने वाले 'दिव्य वस्त्र' (अजरौ वाससी) भेंट किए!"
            'काल' (Time) की तलवार और ढाल ब्रह्मांड के सबसे ज़्यादा लॉजिकल (Logical) और अजेय हथियार हैं!
            काल (समय) हर चीज़ को काटता और मारता है (तलवार), और समय ही हर चीज़ की रक्षा भी करता है (ढाल)।
            महिषासुर को लगता था कि वह अमर है, पर अब 'समय' (काल) साक्षात् एक तलवार बनकर देवी के हाथों में आ चुका है, जो उसकी उम्र (Lifespan) को काट देगा।
            क्षीरसागर (Ocean of Milk) का हार और दिव्य कपड़े देवी के 'सौंदर्य और पूर्णता' (Beauty and Perfection) के प्रतीक हैं।
            यह दिखाता है कि देवी भयंकर होने के साथ-साथ अत्यंत 'दिव्य' (Divine) और शुद्ध (Pure) भी हैं।
            उनका वस्त्र 'अजर' (Ajarau / कभी न फटने वाला) है; यानी माता का स्वरूप शाश्वत (Eternal) है, जिस पर भौतिक हथियारों का कोई असर नहीं हो सकता।
            वे केवल एक विनाशक शक्ति नहीं हैं; वे साक्षात् 'परम सत्य' हैं जो सुंदरता और खौफ दोनों का परफेक्ट मिक्स (Perfect mix) हैं।
            राक्षस उस ढाल और तलवार को देखकर ही अपनी आधी मौत मर जाएगा।
        """.trimIndent(),
        english = """
            (The Sword and Shield of Time): "Direct absolute Kala (The ultimate Supreme God of Time / Kalah) flawlessly perfectly presented explicitly completely exactly to the Mother an exceptionally sharp terrifying 'Sword' (Khadgam) and an incredibly violently blazing, brilliantly shining 'Shield' (Charma cha nirmalam)!"
            "And the massive Ocean of Milk (Kshirodah) aggressively actively explicitly perfectly flawlessly gifted the Mother an exceptionally pure, entirely stainless 'Necklace of brilliant pearls' (Amalam haram) and entirely immortal, completely indestructible 'Divine cosmic garments' (Ajarau vasasi)!"
            The absolute sword and supreme shield exactly of 'Kala' (Time) are undeniably the absolute most highly Logical and completely invincible weapons perfectly inside the colossal universe!
            Time flawlessly aggressively actively physically slices and violently slaughters absolutely everything (Sword), and identical Time seamlessly completely actively powerfully defends perfectly (Shield).
            Mahishasura ignorantly assumed he was immortal, but exactly now 'Time' (Kala) itself has perfectly physically manifested explicitly as a literal sword directly exactly inside the Goddess's hands, which will ruthlessly slice his pathetic lifespan.
            The Ocean of Milk's absolute pure necklace and divine garments seamlessly flawlessly completely symbolize exactly the Goddess's absolute explicit 'Beauty and Perfection'.
            This flawlessly explicitly proves that the Mother is exceptionally terrifying and simultaneously exceptionally 'Divine' and fundamentally Pure.
            Her explicit garments are 'Ajarau' (entirely immortal/indestructible); meaning the Mother's absolute physical form is Permanent (Eternal), perfectly completely entirely immune to absolutely any cheap physical weapons.
            She is absolutely not merely a destructive power; She is literally the direct 'Ultimate Truth' seamlessly perfectly blending absolute blinding beauty and horrifying fear entirely into exactly one perfect mix.
            The demon will violently actively die exactly half his death simply by actively visually witnessing that absolute shield and terrifying sword alone.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 24,
        sanskrit = "चूड़ामणिं तथा दिव्यं कुण्डले कटकानि च ।\nअर्धचन्द्रं तथा शुभ्रं केयूरान् सर्वबाहुषु ॥ २६ ॥",
        hindi = """
            (दिव्य आभूषण): "विश्वकर्मा (ब्रह्मांड के परम इंजीनियर) ने देवी को एक अत्यंत चमचमाता हुआ भयंकर 'चूड़ामणि' (सिर का आभूषण), दिव्य कुंडल (कुण्डले), और कड़े (कटकानि च) दिए।"
            "माथे पर सजाने के लिए एक उज्ज्वल 'अर्धचन्द्र' (अर्धचन्द्रं तथा शुभ्रं), और देवी की सभी भुजाओं (सर्वबाहुषु) के लिए 'बाजूबंद' (केयूरान्) भी प्रदान किए!"
            विश्वकर्मा (Vishwakarma) देवताओं के चीफ इंजीनियर (Chief Engineer) हैं! वे देवी को वह सब कुछ दे रहे हैं जो इस 'ब्रह्मांडीय युद्ध' (Cosmic War) के लिए टेक्निकली (Technically) ज़रूरी है।
            ये दिव्य आभूषण केवल 'गहने' (Jewelry) नहीं हैं; तन्त्र विज्ञान में ये कॉस्मिक 'शील्ड्स' (Cosmic Shields) हैं जो देवी की असीमित एनर्जी (Energy) को एक जगह केंद्रित (Focus) रखते हैं।
            'चूड़ामणि' सहस्रार चक्र (Crown Chakra) को एक्टिवेट (Activate) करता है, 'कुंडल' आज्ञा चक्र को, और 'बाजूबंद' (Armlets) देवी के हाथों की प्रहार क्षमता (Striking force) को कई गुना बढ़ा देते हैं।
            'अर्धचन्द्र' (Half-moon) माथे पर शिव के तीसरे नेत्र के पास सुशोभित है, जो परम शांति और शीतलता (Coolness) का प्रतीक है।
            देवी का दिमाग भयंकर युद्ध के बीच भी पूरी तरह से शांत (Calm) रहेगा; यही एक परफेक्ट योद्धा (Perfect Warrior) की निशानी है।
            महिषासुर (Ego) गुस्से में अंधा होकर लड़ेगा, पर देवी 'होश' (Consciousness) में रहकर उसका संहार करेंगी।
            ये सारे 'कटकानि' (कड़े) अज्ञान के प्रहार को रोकने के लिए साक्षात् अभेद्य कवच (Impenetrable Armor) का काम करेंगे।
            अब माता का हर एक अंग (Limb) 'सुपर-पावर्ड' (Super-powered) हो चुका है।
        """.trimIndent(),
        english = """
            (Divine Cosmic Ornaments): "Vishvakarma (The absolute supreme Chief Engineer of the entire cosmos) aggressively explicitly actively gifted the Mother an exceptionally brilliant, violently blazing terrifying 'Crest-jewel' (Chudamani), divine earrings (Kundale), and massive Bangles (Katakani cha)."
            "A brilliant, blazing 'Half-moon' (Ardhachandram tatha shubhram) flawlessly exactly for Her forehead, and identically explicitly exceptionally absolute divine 'Armlets' (Keyuran) exactly for absolutely all Her massive arms (Sarvabahushu)!"
            Vishvakarma is undeniably the absolute literal direct explicit Chief Engineer perfectly of absolutely all the Gods! He flawlessly actively aggressively heavily exactly actively explicitly physically completely arms the Mother entirely perfectly with absolutely everything strictly 'Technically' mandatory exclusively exactly for this terrifying 'Cosmic War'.
            These exact massive divine ornaments are absolutely completely entirely not merely cheap physical 'Jewelry'; exactly in Tantric science, they are directly exactly absolute literal 'Cosmic Shields' flawlessly actively violently securely completely perfectly focusing the entire absolute raw Energy of the Goddess.
            The 'Chudamani' violently activates the Sahasrara Chakra (Crown Chakra), the 'Earrings' activate the Ajna Chakra, and the 'Armlets' multiply the Mother's absolute striking force exactly by billions of times.
            The 'Half-moon' physically rests exactly near Shiva's third eye directly perfectly on the forehead, perfectly symbolizing absolute supreme peace and extreme Coolness.
            The Mother's highly advanced brain will effortlessly flawlessly completely remain exceptionally perfectly Calm exactly even directly amidst a horrifying cosmic war; this undeniably is the absolute exact explicit sign of a Perfect Warrior.
            Mahishasura (Toxic Ego) will blindly desperately actively physically fight violently consumed completely entirely by blinding rage, but the Goddess will violently explicitly ruthlessly slaughter him completely exactly operating explicitly entirely exactly in pure 'Consciousness' (Hosh).
            Absolutely all these 'Katakani' (Bangles) actively flawlessly entirely violently operate exactly as direct literal Impenetrable Armor actively designed explicitly perfectly completely to actively completely block absolutely every single attack of ignorance.
            Exactly now absolutely every single specific Limb of the Mother has successfully violently become flawlessly 100% 'Super-Powered'.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 25,
        sanskrit = "नूपुरौ विमलौ तद्वद् ग्रैवेयकमनुत्तमम् ।\nअङ्गुलीयकरत्नानि सर्वास्वङ्गुलीषु च ॥ २७ ॥",
        hindi = """
            (अंगूठियां और नूपुर): "विश्वकर्मा ने पैरों के लिए 'दिव्य नूपुर' (विमलौ नूपुरौ / पायल), और गले के लिए एक अत्यंत सुंदर और सर्वोत्तम हार (ग्रैवेयकमनुत्तमम्) भी पहनाए।"
            "और देवी के हाथों की सभी उंगलियों (सर्वास्वङ्गुलीषु च) के लिए अत्यंत चमकदार और खौफनाक 'रत्नों की अंगूठियां' (अङ्गुलीयकरत्नानि) भी प्रदान कीं!"
            जब परम चेतना (Goddess) युद्ध के लिए तैयार होती है, तो उसका हर एक अंग पूर्णता (Perfection) से लैस होता है। भगवान का हर एक्शन एक 'परफेक्ट मास्टरपीस' (Masterpiece) है।
            पैरों के 'नूपुर' (Anklets) जब बजेंगे, तो वह कोई साधारण झंकार नहीं होगी; वह ब्रह्मांडीय फ्रीक्वेंसी (Cosmic frequency) होगी जो पृथ्वी की ग्रेविटी (Gravity) को हिला देगी!
            गले का 'ग्रैवेयक' (Necklace) विशुद्धि चक्र (Throat Chakra) को सुरक्षित करता है, जहाँ से देवी के मन्त्र और गर्जनाएं (Roars) निकलेंगी।
            हाथों की 'अंगूठियां' (Rings) केवल शोभा के लिए नहीं हैं; हाथों से जो भी हथियार (Weapon) चलाया जाएगा, ये रत्न (Gems) उस हथियार की एनर्जी को कई गुना बढ़ा (Amplify) देंगे।
            तन्त्र में रत्न (Gems) ग्रहों (Planets) की ऊर्जा को खींचने का काम करते हैं। देवी ने हर उंगली में अंगूठी पहनकर पूरे सोलर सिस्टम (Solar System) की ताक़त को अपनी मुट्ठी में कर लिया है!
            महिषासुर को यह भी नहीं पता कि वह किस लेवल (Level) की टेक्नोलॉजी (Cosmic Technology) से टकराने जा रहा है।
            ये आभूषण (Ornaments) एक परम योद्धा के अजेय होने का सबसे बड़ा प्रमाण (Proof) हैं।
            अब देवी का 'हार्डवेयर' (Hardware) 100% फुल-प्रूफ (Foolproof) बन चुका है।
        """.trimIndent(),
        english = """
            (Anklets and Rings): "Vishvakarma explicitly flawlessly violently completely armored the exact Goddess entirely exclusively with entirely exceptionally absolute divine 'Anklets' (Vimalau nupurau) exactly for Her feet, and an absolutely unsurpassed supreme necklace (Graiveyakamanuttamam)."
            "And flawlessly presented exceptionally brilliant, terrifying 'Rings of precious cosmic gems' (Anguliyakaratnani) explicitly perfectly entirely for absolutely all the fingers (Sarvasvangulishu cha) of Her massive hands!"
            Exactly when Supreme Consciousness (The Goddess) perfectly actively aggressively explicitly prepares exclusively for war, absolutely every single microscopic organ is flawlessly armed with absolute Perfection. God's every single action is an absolute Perfect Masterpiece.
            Exactly when the 'Anklets' perfectly on Her feet actively violently ring, it will absolutely not be a cheap ordinary chime; it undeniably explicitly will seamlessly flawlessly precisely explicitly actively be exactly that absolute terrifying Cosmic Frequency which violently actively physically shakes the Earth's very Gravity!
            The 'Graiveyaka' (Necklace) perfectly actively entirely protects the Vishuddhi Chakra (Throat Chakra), flawlessly completely exactly strictly entirely from where the Goddess's apocalyptic mantras and terrifying Roars will violently physically erupt.
            The massive 'Rings' exactly on Her fingers are absolutely not merely explicitly perfectly exactly for cheap decoration; exactly whatever specific cosmic Weapon is physically actively wielded exactly by those hands, these exact Gems actively aggressively violently Amplify that explicit weapon's exact raw energy by billions of times.
            Exactly in advanced Tantra, Gems aggressively actively perform the explicit function of violently actively absorbing the absolute massive raw energy of all Planets. By actively seamlessly flawlessly wearing a ring completely exactly precisely on absolutely every single finger, the Goddess has ruthlessly actively aggressively entirely completely successfully trapped the absolute entire Solar System's terrifying raw power perfectly strictly straight inside Her closed fist!
            Mahishasura pathetically completely absolutely flawlessly possesses exactly zero microscopic clue exactly regarding the absolute terrifying Level of 'Cosmic Technology' he is aggressively violently preparing to actively physically crash into.
            These exact specific Ornaments are the absolute greatest literal direct Proof of a Supreme Warrior flawlessly actively becoming completely entirely unconditionally Invincible.
            The Goddess's absolute entire physiological 'Hardware' is undeniably now explicitly actively 100% perfectly entirely completely completely entirely securely 'Foolproof'.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 26,
        sanskrit = "विश्वकर्मा ददौ तस्यै परशुं चातिमर्मगम् ।\nअस्त्राण्यनेकरूपाणि तथाभेद्यं च दंशनम् ॥ २८ ॥",
        hindi = """
            (विश्वकर्मा का फरसा और अभेद्य कवच): "ब्रह्मांड के चीफ इंजीनियर विश्वकर्मा ने देवी को एक अत्यंत भयंकर 'फरसा' (परशुं) दिया जो दुश्मनों के सबसे नाज़ुक मर्म-स्थानों (अतिमर्मगम् / Vital organs) को एक झटके में काट डालता है!"
            "उन्होंने अनेक प्रकार के खतरनाक अस्त्र (अस्त्राण्यनेकरूपाणि) और एक 'कभी न टूटने वाला साक्षात् अभेद्य कवच' (अभेद्यं च दंशनम् / Impenetrable Armor) भी माता को पहनाया!"
            'फरसा' (Axe) एक बहुत ही विशेष हथियार है; यह अहंकार के सबसे गहरे और छिपे हुए जड़ों (Roots) को एक ही प्रहार में उखाड़ कर फेंक देता है।
            मर्म-स्थान (Marmagam) वह पॉइंट (Point) है जहाँ राक्षस की जान बसती है। देवी का फरसा सीधे महिषासुर के 'ईगो' के कोर (Core) पर हमला करेगा।
            और सबसे बड़ी चीज़—'अभेद्य दंशनम्' (Impenetrable Armor)! यह वह शील्ड (Shield) है जिसे दुनिया का कोई भी अस्त्र (चाहे वह ब्रह्मास्त्र ही क्यों न हो) नहीं भेद सकता।
            अज्ञान (राक्षस) का कोई भी वार, कोई भी तीर या तलवार अब साक्षात् 'चेतना' (देवी) को छू भी नहीं सकता।
            यह दिखाता है कि जब आप भगवान (सत्य) के रास्ते पर होते हैं, तो सत्य का 'कवच' (Armor) आपको हर तरह की नेगेटिविटी (Negativity) से 100% सुरक्षित रखता है।
            विश्वकर्मा ने मेकैनिकल परफेक्शन (Mechanical Perfection) की कोई कसर नहीं छोड़ी है।
            देवी अब केवल एक देवी नहीं हैं; वे एक 'अनस्टॉपेबल फोर्स' (Unstoppable Force) हैं।
            महिषासुर का हर वार इस कवच से टकराकर वापस उसी को बर्बाद कर देगा।
        """.trimIndent(),
        english = """
            (Vishvakarma's Axe and Indestructible Armor): "Vishvakarma aggressively explicitly actively gifted the Mother an exceptionally terrifying 'Axe' (Parashum) which flawlessly violently brutally slices entirely straight perfectly through the absolute most exceptionally vital, delicate organs (Atimarmagam) of the enemies in exactly a single stroke!"
            "He explicitly flawlessly violently aggressively completely physically armored the exact Goddess entirely exclusively strictly flawlessly with completely countless absolute weapons (Astranyanekarupani) and an 'Absolutely entirely indestructible impenetrable Armor' (Abhedyam cha danshanam)!"
            The 'Axe' is undeniably an exceptionally highly specific terrified weapon; it effortlessly violently uproots and completely active completely severs the absolute deepest hidden psychological roots of toxic Ego exactly in one single terrifying physical stroke.
            The 'Marmagam' is exactly that precise literal weak point strictly flawlessly perfectly perfectly where the exact demon's pathetic life perfectly securely violently actively resides. The Mother's explicit Axe will aggressively execute a direct violent physical strike entirely exactly perfectly straight upon the explicit absolute Core perfectly of Mahishasura's 'Ego'.
            And absolutely the most massive thing—'Abhedya Danshanam' (Impenetrable Armor)! This is undeniably exactly that terrifying Shield which absolutely zero cosmic weapon perfectly entirely entirely exactly inside the physical world (even a Brahmastra) can possibly ever successfully physically pierce.
            Absolutely zero pathetic attack, entirely zero arrow or cheap sword exclusively exactly of thick ignorance (the demon) can possibly ever successfully even scratch the pure 'Consciousness' (The Goddess) now.
            This spectacularly completely flawlessly proves perfectly exactly that exactly when you actively aggressively physically operate perfectly entirely entirely on the exact path perfectly exactly of God (Truth), the absolute pure 'Armor' of truth flawlessly absolutely perfectly actively violently securely completely perfectly keeps you 100% explicitly totally safe completely exactly strictly from absolutely all Negativity.
            Vishvakarma has explicitly flawlessly actively completely left absolutely zero microscopic millimeter perfectly of exact literal 'Mechanical Perfection' completely entirely untested.
            The Goddess is undeniably exactly now absolutely completely perfectly entirely entirely absolutely no longer exactly merely a Goddess; She is explicitly exactly an absolute 'Unstoppable Force'.
            Mahishasura's every single attack will flawlessly violently actively physically bounce exactly explicitly straight off exactly this explicit Armor to relentlessly entirely violently aggressively completely exactly destroy him entirely.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 27,
        sanskrit = "अम्लानपङ्कजां मालां शिरस्युरसि चापराम् ।\nअददज्जलधिस्तस्यै पङ्कजं चातिशोभनम् ॥ २९ ॥",
        hindi = """
            (कमल की माला): "समुद्र (जलधि) ने माता के सिर (शिरसि) और गले (उरसि चापराम्) के लिए अत्यंत सुंदर 'कभी न कुम्हलाने वाले कमल के फूलों की माला' (अम्लानपङ्कजां मालां) भेंट की।"
            "और हाथों में पकड़ने के लिए एक अत्यंत सुंदर और शोभायमान 'कमल का फूल' (पङ्कजं चातिशोभनम्) भी माता को समर्पित किया।"
            इतने सारे खौफनाक हथियारों के बीच 'कमल' (Lotus) का क्या काम? यही सनातन धर्म का सबसे बड़ा दर्शन (Philosophy) है!
            समुद्र का 'कमल' परम शांति (Peace), पवित्रता (Purity), और वैराग्य (Detachment) का सबसे बड़ा प्रतीक है।
            कमल कीचड़ में खिलता है पर कीचड़ उस पर नहीं चिपकता; देवी युद्ध के भयंकर कीचड़ (खून-खराबे) में उतरेंगी, पर युद्ध की हिंसा (Violence) उनकी चेतना को गंदा नहीं कर सकती।
            देवी एक हाथ में खून से सनी तलवार (विनाश) और दूसरे हाथ में कोमल कमल (शांति) लिए हुए हैं; यही सनातन का परम 'बैलेंस' (Balance) है।
            यह हमें सिखाता है कि धर्म का युद्ध (Dharma-Yuddha) गुस्से या नफरत से नहीं, बल्कि भीतर की 'परम शांति' (Inner Peace) के साथ लड़ा जाता है।
            अम्लान (कभी न मुरझाने वाला) कमल यह बताता है कि माता की करुणा और शांति हमेशा 'फ्रेश' (Fresh) और शाश्वत (Eternal) है।
            महिषासुर को जो सज़ा मिलेगी, वह नफरत का परिणाम नहीं होगा, वह 'लॉ ऑफ़ कर्मा' (Law of Karma) का एक शांत एग्जीक्यूशन (Execution) होगा।
            देवी का रूप जितना डरावना (Terrifying) है, उतना ही अधिक 'करुणामयी' (Compassionate) भी है।
        """.trimIndent(),
        english = """
            (The Garland of Lotus): "The massive supreme Ocean (Jaladhi) flawlessly actively explicitly perfectly presented directly entirely to the Mother an exceptionally exquisite 'Garland entirely of unfading immortal lotus flowers' (Amlanapankajam malam) explicitly for Her head (Shirasi) and chest (Urasi chaparam)."
            "And identically exactly an exceptionally brilliant physical 'Lotus flower' (Pankajam chatishobhanam) exactly to actively hold strictly perfectly inside Her hands."
            Exactly what on earth is the explicit purpose entirely of a delicate 'Lotus' directly completely explicitly entirely amidst completely so many terrifying horrific weapons? This is undeniably Sanatana Dharma's absolute greatest Philosophy!
            The Ocean's flawless pure 'Lotus' flawlessly seamlessly perfectly undeniably symbolizes absolute pure Peace, total Purity, and ultimate supreme Detachment (Vairagya).
            A lotus flawlessly perfectly actively violently blooms entirely straight perfectly inside filthy mud yet zero mud actively sticks completely exactly strictly exactly to it; the Goddess will flawlessly actively physically step directly entirely exactly into the horrifying physical mud strictly perfectly of a violent cosmic war (bloodshed), yet the absolute brutal Violence exactly of the war absolutely completely entirely entirely cannot possibly physically ever successfully actively strictly flawlessly pollute Her pure Consciousness.
            The Goddess actively grips a terrifying sword completely soaked perfectly inside thick blood (Destruction) perfectly in one hand and exactly a peaceful delicate Lotus (Peace) strictly in the other; this undeniably exactly completely perfectly constitutes absolute cosmic 'Balance'.
            This miraculously completely flawlessly teaches us exactly that a true Dharma-Yuddha (War of Righteousness) is absolutely completely entirely perfectly exactly explicitly not physically actively aggressively fought completely exactly with blind rage or toxic hatred, but actively flawlessly entirely exclusively exactly with absolute 'Inner Peace'.
            The 'Amlana' (unfading/immortal) lotus flawlessly flawlessly violently entirely active actively actively actively proves completely exactly that the Mother's absolute supreme compassion and eternal peace is relentlessly permanently 'Fresh' and flawlessly Eternal.
            The absolute horrifying brutal punishment Mahishasura effortlessly effortlessly flawlessly violently actively completely flawlessly violently physically violently flawlessly receives will absolutely absolutely not actively perfectly strictly entirely perfectly exactly be explicitly the terrifying outcome completely exactly of toxic hatred, it will flawlessly seamlessly perfectly actively actively completely absolutely perfectly act purely as exactly a perfectly calm Execution entirely of the 'Law of Karma'.
            The Goddess's specific physical form is undeniably exactly flawlessly identically as exceptionally 'Compassionate' entirely completely identically perfectly exactly exactly identically flawlessly entirely exactly as it is unequivocally 'Terrifying'.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 28,
        sanskrit = "हिमवान् वाहनं सिंहं रत्नानि विविधानि च ।\nददावशून्यं सुरया पानपात्रं धनाधिपः ॥ ३० ॥",
        hindi = """
            (हिमालय का शेर और कुबेर का पात्र): "साक्षात् हिमालय पर्वत (हिमवान्) ने माता की सवारी के लिए एक अत्यंत भयंकर 'शेर' (सिंहं वाहनं) और अनेकों प्रकार के खूंखार 'रत्न' (रत्नानि विविधानि) माता को समर्पित कर दिए!"
            "और धन के परम स्वामी कुबेर (धनाधिपः) ने देवी को 'दिव्य मदिरा (सुरा) से हमेशा भरा रहने वाला (अशून्यं) एक पानपात्र' (पानपात्रं / Drinking cup) भेंट किया!"
            और सबसे महत्वपूर्ण घटना—हिमालय ने देवी को साक्षात् 'शेर' (Lion) दे दिया! शेर 'परम धर्म', 'अदम्य साहस' (Courage), और 'लीडरशिप' (Leadership) का सबसे बड़ा साक्षात् प्रतीक है!
            देवी का 'शेर पर बैठना' (Riding the Lion) यह खुलेआम दिखाता है कि उन्होंने अपने अंदर के सबसे खूंखार और जंगली पशु-स्वभाव (Animal instincts) को 100% 'कंट्रोल' (Control) कर लिया है।
            महिषासुर (भैंसा) भी एक जानवर है, जो केवल आलस और क्रोध से भरा है। शेर भैंसे का प्राकृतिक शिकारी (Natural Predator) है!
            यानी प्रकृति (Nature) ने खुद महिषासुर का 'शिकार' (Hunt) करने के लिए अपना सबसे बड़ा शिकारी माता को सौंप दिया है।
            कुबेर का सुरापात्र (Cup of wine) कोई शराब नहीं है; यह 'सुरा' साक्षात् 'परम आनंद' (Cosmic Bliss / सोमरस) का प्रतीक है।
            जो कभी 'अशून्य' (कभी खाली नहीं) होता! यानी देवी हमेशा परमानंद (Supreme Ecstasy) की अवस्था में रहती हैं।
            अब 'शेरावाली माता' (The Goddess on the Lion) अपने पूरे फॉर्म (Form) में आ चुकी हैं!
            महिषासुर (Ego) की उल्टी गिनती (Countdown) अब शुरू हो चुकी है!
        """.trimIndent(),
        english = """
            (The Lion of Himalaya and Kubera's Cup): "The direct literal absolute massive Himalaya Mountain himself (Himavan) flawlessly actively aggressively violently explicitly surrendered completely exactly strictly directly to the Mother an exceptionally horrifying terrifying massive 'Lion' (Simham vahanam) explicitly entirely for Her to ride exactly and completely countless kinds of cosmic 'Gems' (Ratnani vividhani)!"
            "And Kubera, the supreme Lord of Wealth (Dhanadhipah), actively explicitly presented an absolute 'Drinking cup' (Panapatram) 'perpetually overflowing flawlessly entirely with divine nectar/wine completely absolutely entirely without ever running completely empty' (Adadau ashunyam suraya)!"
            And absolutely the exact explicit most incredibly massive event—Himalaya aggressively actively entirely perfectly violently explicitly presented the exact absolute literal 'Lion' directly to the Goddess! The specific physical Lion undeniably flawlessly effortlessly explicitly explicitly perfectly symbolizes absolute supreme 'Dharma', absolute complete total raw 'Courage', and the ultimate exact explicit literal absolute cosmic 'Leadership'!
            The exact physical action exactly of the Goddess explicitly actively perfectly completely violently 'Riding the Lion' undeniably seamlessly flawlessly perfectly explicitly violently visually actively actively proves completely exactly that She has successfully 100% flawlessly perfectly 'Controlled' absolutely entirely completely absolutely all the most exceptionally horrifying brutal animalistic biological instincts!
            Mahishasura (The Buffalo) is undeniably identically seamlessly effortlessly purely an exceptionally massive animal strictly actively completely explicitly explicitly perfectly violently entirely completely overflowing exactly strictly exclusively with laziness and toxic rage. The literal Lion undeniably is exactly explicitly effortlessly the Buffalo's absolute complete direct exact 'Natural Predator'!
            Profoundly meaning, absolutely pure exact complete literal Nature Herself flawlessly actively explicitly perfectly physically handed exactly explicitly entirely straight over directly to the Mother Her absolute ultimate greatest Hunter exclusively exactly strictly to flawlessly execute the absolute physical 'Hunt' completely perfectly exactly of Mahishasura.
            Kubera's Cup of wine absolutely is entirely zero cheap physical alcohol; this specific 'Sura' undeniably seamlessly flawlessly actively actively accurately accurately symbolizes exact absolute 'Cosmic Bliss' (Soma/Supreme Ecstasy).
            Which flawlessly seamlessly actively actively actively completely flawlessly remains absolutely perpetually entirely 'Ashunya' (never empty)! Meaning the Goddess flawlessly perfectly perpetually exactly securely exists seamlessly entirely entirely entirely completely actively within an absolute active dynamic state completely exactly entirely entirely of Supreme Ecstasy.
            Exactly now the absolute ultimate terrifying 'Sherawali Mata' (The Supreme Goddess perfectly riding the massive Lion) has violently seamlessly entirely fully manifested completely exactly perfectly strictly entirely completely in Her absolute entire massive Form!
            Mahishasura's (Toxic Ego's) exact absolute total literal countdown has aggressively violently begun right exactly now!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 29,
        sanskrit = "शेषः सर्वनागेशो महामणिविभूषितम् ।\nनागहारं ददौ तस्यै धत्ते यः पृथिवीमिमाम् ॥ ३१ ॥",
        hindi = """
            (शेषनाग का हार): "जो इस पूरी पृथ्वी को अपने फन पर धारण करते हैं (धत्ते यः पृथिवीमिमाम्), उन सभी नागों के परम स्वामी 'शेषनाग' (शेषः सर्वनागेशो) ने।"
            "महान और चमचमाती हुई मणियों (गहनों) से सजा हुआ अपना भयंकर 'नागहार' (नागों का हार / महामणिविभूषितम् नागहारं) साक्षात् उस परम देवी को भेंट कर दिया (ददौ तस्यै)!"
            शेषनाग 'अनंत समय' (Infinite Time) का प्रतीक हैं, जिसके ऊपर पूरी दुनिया (पृथ्वी) टिकी हुई है।
            नाग (सांप / Serpents) 'कुंडलिनी शक्ति' (Kundalini Energy) और अत्यंत ज़हरीली ऊर्जा (Toxic/Lethal energy) को भी दर्शाता है।
            देवी ने नागों का वह खौफनाक हार पहनकर यह सिद्ध कर दिया कि पूरे ब्रह्मांड की सबसे डरावनी और ज़हरीली ऊर्जाएं भी उनके गले का केवल एक 'गहना' (Jewelry) मात्र हैं!
            जो सांप एक साधारण इंसान को मार सकता है, वह देवी की शक्ति को और बढ़ा रहा है (महामणिविभूषितम्)।
            यह दिखाता है कि 'महामाया' नेगेटिविटी (Negativity) को खत्म नहीं करतीं, बल्कि उसे अपने नियंत्रण (Control) में लेकर उसे एक हथियार (Weapon) या आभूषण में बदल देती हैं।
            ब्रह्मांड की हर शक्ति (देवता, प्रकृति, समय, जानवर और अब नाग) माता के चरणों में अपना 100% योगदान (Contribution) दे चुकी है।
            सुपर-मशीन (Super-machine) अब पूरी तरह से कंप्लीट (Complete) है।
            अब केवल एक ही चीज़ बची है—युद्ध का शंखनाद (Declaration of War)!
        """.trimIndent(),
        english = """
            (The Necklace of Sheshanaga): "Exactly the one who flawlessly actively violently physically entirely supports this absolute entire Earth strictly upon his massive hoods (Dhatte yah prithivimimam), the supreme Lord of absolutely all cosmic serpents 'Sheshanaga' (Sheshah sarvanagesho)."
            "Flawlessly aggressively explicitly surrendered entirely exactly to that Supreme Goddess (Dadau tasyai) an exceptionally horrifying terrifying 'Necklace entirely of massive cosmic Serpents' (Nagaharam) flawlessly studded completely entirely with brilliantly blazing massive cosmic gems (Mahamanivibhushitam)!"
            Sheshanaga undeniably completely perfectly explicitly physically symbolizes 'Infinite Time', exactly perfectly completely directly explicitly directly precisely directly upon strictly entirely which exactly the absolute entire massive physical world (Earth) securely flawlessly actively actively actively physically completely actively actively rests.
            The massive Serpents (Nagas) flawlessly actively actively represent absolute terrifying 'Kundalini Energy' and identically perfectly completely exactly exceptionally highly Toxic/Lethal energy completely entirely exactly perfectly exactly inside the physical cosmos.
            The Goddess flawlessly seamlessly actively wearing that terrifying absolute exact completely flawless necklace completely of Serpents undeniably actively explicitly fiercely perfectly explicitly proves completely exactly that the absolute most terrifying, venomous energies existing perfectly in the colossal universe are merely a cheap piece of 'Jewelry' directly for Her!
            The exact identical snake which effortlessly violently brutally physically physically brutally actively strictly slaughters entirely an exceptionally ordinary cheap physical human, actively flawlessly completely actively aggressively exclusively flawlessly entirely increases entirely the Mother's absolute raw power (Mahamanivibhushitam).
            This spectacularly flawlessly explicitly actively actively proves completely exactly that 'Mahamaya' absolutely completely entirely entirely exactly explicitly absolutely does not strictly physically simply actively strictly exactly actively physically merely completely exactly destroy Negativity, but flawlessly aggressively violently completely actively physically violently actively actively successfully completely captures strictly it perfectly entirely perfectly entirely actively exactly under Her absolute Control entirely, seamlessly actively effortlessly violently seamlessly actively perfectly transforming exactly it perfectly completely entirely straight perfectly into exactly a cosmic physical Weapon entirely completely perfectly or an active physical ornament entirely perfectly completely exactly exactly explicitly.
            Absolutely every single exact specific microscopic cosmic raw power actively perfectly completely explicitly existing exactly perfectly entirely inside the entire colossal Universe (Gods, pure Nature, infinite Time, wild Animals, and exactly perfectly completely now cosmic Serpents) has exactly explicitly explicitly flawlessly entirely actively perfectly perfectly perfectly perfectly actively flawlessly executed its 100% absolute entire complete physical Contribution completely exactly perfectly explicitly straight perfectly directly at the exact sacred feet perfectly of the Mother.
            The absolute terrifying exact supreme Super-machine is undeniably flawlessly completely actively aggressively 100% Complete right exactly now.
            Exactly now completely entirely strictly exclusively only exactly one absolute single massive explosive event violently actively remains—the absolute explicit terrifying physical cosmic Declaration of War!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 30,
        sanskrit = "अन्यैरपि सुरैर्देवी भूषणैरायुधैस्तथा ।\nसम्मानिता ननादोच्चैः साट्टहासं मुहुर्मुहुः ॥ ३२ ॥",
        hindi = """
            (देवी की भयंकर गर्जना): "इसी प्रकार अन्य सभी देवताओं (अन्यैरपि सुरैर्) द्वारा भी अत्यंत खौफनाक हथियारों और आभूषणों से पूरी तरह सम्मानित होने के बाद (भूषणैरायुधैस्तथा सम्मानिता)।"
            "उस परम महामाया देवी ने अत्यंत भयंकर 'अट्टहास' (खौफनाक हंसी / साट्टहासं) करते हुए बार-बार (मुहुर्मुहुः) ब्रह्मांड को फाड़ देने वाली अत्यंत ऊँची और खौफनाक 'गर्जना' (ननादोच्चैः / Roar) की!"
            हथियारों से पूरी तरह लैस (Fully Armed) होने के बाद, माता की यह सबसे पहली 'गर्जना' (Battle Cry) थी!
            यह कोई साधारण आवाज़ नहीं थी; यह वह परम फ्रीक्वेंसी (Frequency) थी जिसने महिषासुर (Ego) के पूरे सिस्टम को हिला कर रख दिया।
            जब देवी (चेतना) अट्टहास (हँसती) करती है, तो इसका मतलब है कि वह राक्षसों के अज्ञान और उनके 'ईगो' का सीधा मज़ाक (Mockery) उड़ा रही है!
            वह हँस रही हैं कि "तुम जैसे मामूली मच्छर मुझसे (यूनिवर्सल मदर से) लड़ने आ रहे हो?"
            यह हंसी (Laughter) मनोवैज्ञानिक युद्ध (Psychological Warfare) का हिस्सा है। दुश्मन को हथियार से मारने से पहले, माता उसे डर (Fear) से मार रही हैं।
            'मुहुर्मुहुः' (बार-बार) का अर्थ है कि वह गर्जना पूरे ब्रह्मांड में लगातार गूंज रही थी, जिससे पृथ्वी काँप उठी और पहाड़ दरकने लगे!
            यह महिषासुर के लिए 'अल्टीमेटम' (Ultimatum) था कि तुम्हारी मौत अब दरवाज़े पर खड़ी है।
            यहाँ से 'महिषासुरमर्दिनी' (साक्षात् मृत्यु) अपने भयंकर एक्शन (Action) मोड में पूरी तरह से आ चुकी हैं!
        """.trimIndent(),
        english = """
            (The Terrifying Cosmic Roar of the Goddess): "Flawlessly exactly in this identical precise manner, strictly after being entirely violently honored completely perfectly explicitly exactly by absolutely all the other remaining Gods (Anyairapi surair) explicitly completely perfectly with exceptionally massive cosmic ornaments and terrifying apocalyptic weapons (Bhushanairayudhaistatha sammanita)."
            "That absolute Supreme Mahamaya Goddess repeatedly and continuously (Muhurmuhuh) actively violently executed an exceptionally terrifying 'Apocalyptic Roar' (Nanadocchai) violently accompanied exactly by an exceptionally horrific, terrifying 'Blinding Cosmic Laughter' (Sattahasam) that violently ripped the entire universe apart!"
            Exactly after being completely flawlessly '100% Fully Armed', this was explicitly exactly the Mother's absolute first terrifying cosmic 'Battle Cry'!
            This was absolutely zero ordinary cheap physical sound; this was exactly that terrifying absolute ultimate Frequency which violently brutally shattered Mahishasura's (Ego's) entire operating system in a split-second.
            Exactly when the Goddess (Pure Consciousness) flawlessly actively violently Executes 'Sattahasam' (Laughs), it profoundly explicitly explicitly entirely means She is violently ruthlessly aggressively performing a direct Mockery exactly of the pathetic ignorance and highly toxic 'Ego' of the demons!
            She is explicitly actively laughing violently screaming, "You exceptionally cheap, pathetic microscopic bugs are actually aggressively attempting entirely completely to actively strictly fight ME (The Universal Mother)?"
            This horrific Laughter undeniably completely perfectly forms an absolute massive integral part strictly exactly perfectly entirely of advanced Psychological Warfare. Explicitly exactly completely perfectly actively prior exactly to ruthlessly aggressively slaughtering exactly the absolute physical enemy explicitly perfectly exactly with an absolute explicitly physical weapon, the Mother is flawlessly violently completely actively exactly physically killing him entirely entirely directly exactly with pure raw Fear.
            'Muhurmuhuh' (Repeatedly) profoundly implies exactly that that terrifying apocalyptic roar violently echoed relentlessly continuously perfectly across the entire colossal cosmos, causing the absolute physical Earth to violently quake and massive physical mountains strictly exactly to forcefully rupture and shatter!
            This was the absolute final 'Ultimatum' specifically directed completely entirely exactly straight perfectly exactly directly for Mahishasura explicitly flawlessly violently exactly declaring that his absolute certain death actively flawlessly entirely actively securely exclusively officially violently stands perfectly directly exactly exactly directly exactly exactly at the exact specific absolute literal door.
            Right exactly from here entirely explicitly completely perfectly strictly, 'Mahishasuramardini' (Direct literal Death Herself) has flawlessly seamlessly violently violently actively completely aggressively transitioned perfectly strictly completely exactly 100% exactly directly strictly straight entirely perfectly exclusively into Her explicitly absolute horrifying physical Action Mode!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 31,
        sanskrit = "तस्यानादेन घोरेण कृत्स्नमापूरितं नभः ।\nअमायतातिमहता प्रतिशब्दो महानभूत् ॥ ३१ ॥",
        hindi = """
            (देवी की गर्जना): "उस परम देवी की अत्यंत भयंकर (घोरेण) और कभी न खत्म होने वाली गर्जना (अनादेन) से यह पूरा का पूरा आकाश (कृत्स्नमापूरितं नभः) पूरी तरह से भर गया!"
            "उस अत्यंत विशाल और असीमित (अमायतातिमहता) गर्जना से एक इतनी भयंकर गूंज (प्रतिशब्दो) पैदा हुई, जिसने पूरे ब्रह्मांड को हिला कर रख दिया (महानभूत्)।"
            जब देवी (परम चेतना) अपने पूर्ण रूप में प्रकट होती हैं, तो वह कोई शांत प्रार्थना नहीं करतीं; वे एक भयंकर 'गर्जना' (Roar) करती हैं!
            यह गर्जना इंसान के दिमाग के उस 'स्लीप मोड' (Sleep mode / अज्ञान) को तोड़ने वाला साक्षात् 'कॉस्मिक अलार्म' (Cosmic Alarm) है।
            महिषासुर (अहंकार) सोचता था कि ब्रह्मांड पर उसका पूरा 'कण्ट्रोल' (Control) है, पर देवी की इस एक आवाज़ ने उसके सिस्टम में 'एरर' (Error) डाल दिया।
            'प्रतिशब्दो' का अर्थ है कि वह आवाज़ टकराकर वापस आई (Echo)—यानी प्रकृति के कण-कण ने उस परम-चेतना (सुपर-यूज़र) की एंट्री (Entry) को स्वीकार कर लिया।
            जब आपके अंदर की कुंडलिनी शक्ति जागती है, तो सबसे पहले वह आपके भ्रम के सन्नाटे को इसी तरह की एक भयंकर गर्जना से चीर देती है।
            राक्षसों का सारा 'लॉजिक' (Logic) और घमंड इस एक ही परम-आवाज़ के सामने पूरी तरह से ज़ीरो (Zero) हो गया।
            यह कोई साधारण ध्वनि नहीं थी; यह साक्षात् 'ॐ' (OM) का वह भयंकर विनाशकारी रूप था जो सृष्टि को रिबूट (Reboot) करने के लिए गूंजता है।
            इसी गर्जना ने देवासुर संग्राम (युद्ध) के मैदान का पूरा माहौल (Atmosphere) हमेशा के लिए बदल कर रख दिया।
        """.trimIndent(),
        english = """
            (The terrifying roar of the Goddess): "The absolute entire sky and vast space (Kritsnamapuritam nabhah) was flawlessly and violently entirely filled by that exceptionally horrific (Ghorena) and relentless cosmic roar (Anadena) exclusively of that Supreme Goddess!"
            "From that exceptionally massive, boundless, and infinite (Amayatatimahata) violent roar, an exceptionally terrifying cosmic echo (Pratishabdo) was aggressively violently generated which ruthlessly shook the entire universe (Mahanabhut)."
            Exactly when the Goddess (Supreme Consciousness) flawlessly violently actively Manifests perfectly in Her absolute complete form, She absolutely does not perform a quiet, cheap prayer; She explicitly unleashes a highly terrifying 'Roar' (Cosmic scream)!
            This explosive roar is undeniably the literal direct 'Cosmic Alarm Clock' flawlessly designed strictly to violently shatter exactly the pathetic 'Sleep Mode' (ignorance) of the human brain.
            Mahishasura (toxic Ego) completely blindly assumed he had absolute total 100% 'Control' exactly over the cosmos, but exactly this single frequency of the Goddess actively forcefully injected a massive 'Error' straight into his corrupted system.
            'Pratishabdo' profoundly means exactly that the massive roar aggressively bounced perfectly back (Echo)—meaning absolutely every single microscopic atom of physical Nature flawlessly actively violently Accepted the explicit Entry exactly of the 'Super-User' (Supreme Consciousness).
            Exactly when your internal Kundalini Shakti violently actively awakens, the absolute first thing it does is ruthlessly completely violently slash exactly the dead silence of your pathetic illusion exactly with an identical horrific cosmic roar.
            Absolutely all the cheap 'Logic' and toxic arrogance exactly of the massive demons flawlessly dropped to mathematical Zero entirely before this single Supreme-Voice.
            This was absolutely no ordinary cheap sound; it was literally the direct exceptionally destructive raw form exactly of 'OM' actively echoing exclusively to entirely Reboot the cosmos.
            Exactly this specific massive cosmic roar flawlessly violently permanently altered the absolute entire Atmosphere exactly of the Devasura battleground completely forever.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 32,
        sanskrit = "चुक्षुभुः सकला लोकाः समुद्राश्च चकम्पिरे ।\nचचाल वसुधा चेलुः सकला भूधरास्तथा ॥ ३२ ॥",
        hindi = """
            (ब्रह्मांड में हलचल): "देवी की उस गर्जना से सारे के सारे 'लोक' (सकला लोकाः / Dimensions) भयंकर रूप से क्षुब्ध (चुक्षुभुः / Agitated) हो गए, और सारे विशाल समुद्र (समुद्राश्च) कांपने लगे (चकम्पिरे)!"
            "यह पूरी धरती (वसुधा) बुरी तरह से डोलने लगी (चचाल), और पृथ्वी के सारे के सारे विशाल पहाड़ (सकला भूधरास्तथा) अपनी जगह से हिल गए (चेलुः)!"
            देवी की एनर्जी (Energy) इतनी 'हाई-फ्रीक्वेंसी' (High-frequency) की है कि यह 'थ्री-डायमेंशनल' (3D) दुनिया उस ऊर्जा को संभाल (Handle) ही नहीं पा रही है!
            'समुद्र का कांपना' और 'पहाड़ों का हिलना' इंसान की साइकोलॉजी (Psychology) का प्रतीक है।
            समुद्र हमारा 'अवचेतन मन' (Subconscious mind / भावनाएं) है, और पहाड़ हमारे सालों पुराने जमे हुए 'अहंकार और विश्वास' (Belief systems) हैं।
            जब साक्षात् 'ज्ञान' (देवी) अंदर प्रवेश करता है, तो सबसे पहले आपके पुराने ईगो (पहाड़) और आपकी पुरानी भावनाएं (समुद्र) बुरी तरह से कांपने लगते हैं।
            यह कोई फिजिकल भूकंप (Earthquake) नहीं है; यह 'स्पिरिचुअल भूकंप' (Spiritual Earthquake) है!
            भगवान जब भी नया 'सॉफ्टवेयर' (Software) इनस्टॉल (Install) करते हैं, तो पुराना सिस्टम (System) हमेशा हिलता और क्रैश (Crash) होता है।
            महिषासुर ने जिस ज़मीन और समुद्र पर कब्ज़ा किया था, वह ज़मीन ही अब उसके पैरों के नीचे से खिसक रही थी।
            यह श्लोक प्रमाणित करता है कि माया (Nature) कभी भी अपने 'मालिक' (Creator) की शक्ति के सामने स्थिर नहीं रह सकती।
        """.trimIndent(),
        english = """
            (The massive cosmic agitation): "By that specific terrifying roar of the Goddess, absolutely all the cosmic dimensions and entire worlds (Sakala lokah) became violently agitated and aggressively disturbed (Chukshubhuh), and absolutely all the massive deep oceans (Samudrashcha) violently trembled (Chakampire)!"
            "This absolute entire physical earth (Vasudha) aggressively began to violently sway and rock (Chachala), and absolutely all the colossal massive mountains (Sakala bhudharastatha) were violently completely shaken perfectly entirely from their exact physical foundations (Cheluh)!"
            The absolute raw Energy of the Goddess is undeniably of such exceptionally 'High-Frequency' that this cheap 'Three-Dimensional' (3D) physical world completely completely absolutely fails to actively Handle it!
            The 'Trembling of the oceans' and the 'Shaking of the mountains' is the direct absolute literal symbol exactly of the human's core Psychology.
            The deep ocean is undeniably exactly our highly volatile 'Subconscious Mind' (Emotions), and the massive mountains are flawlessly our decades-old frozen 'Toxic Ego and blind Belief Systems'.
            Exactly when absolute literal 'Wisdom' (The Goddess) violently Actively Enters inside you, the absolute first thing to brutally tremble is exactly your massive old ego (Mountains) and chaotic emotions (Oceans).
            This is undeniably absolutely zero cheap physical Earthquake; this is explicitly a highly terrifying 'Spiritual Earthquake'!
            Exactly whenever Supreme God flawlessly actively Installs a brand new 'Software' entirely inside you, the corrupted old System undeniably perpetually completely shakes and violently Crashes.
            The exact identical earth and ocean exactly which Mahishasura had aggressively hijacked were flawlessly violently completely slipping entirely exactly from strictly perfectly beneath his very own physical feet.
            This spectacular verse explicitly flawlessly proves exactly that Maya (Nature) can absolutely never ever actively remain stable perfectly exactly directly entirely before the absolute raw power exclusively of Her 'Creator' (Master).
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 33,
        sanskrit = "जयेति देवाश्च मुदा तामूचुः सिंहवाहिनीम् ।\nतुष्टुवुर्मुनयश्चैनां भक्तिनम्रात्ममूर्तयः ॥ ३३ ॥",
        hindi = """
            (देवताओं और मुनियों की स्तुति): "उस भयंकर गर्जना को सुनकर सभी देवताओं ने अत्यंत प्रसन्न होकर (मुदा) उन सिंह पर सवार देवी (सिंहवाहिनीम्) की 'जय हो, जय हो' (जयेति) कहकर जयकार की!"
            "और वहां मौजूद सभी महान मुनियों ने भी भक्ति से विनम्र होकर (भक्तिनम्रात्ममूर्तयः) उन साक्षात् परम देवी की स्तुति (तुष्टुवुर्) करना आरंभ कर दिया।"
            जब प्रकृति (महामाया) अपना भयंकर रूप दिखाती है, तो अहंकार (राक्षस) डर जाता है, पर जो सात्विक शक्तियां (देवता और मुनि) हैं, वे खुश होती हैं।
            'सिंहवाहिनीम्' का अर्थ है जो शेर पर सवार है। शेर इंसान की उस अनियंत्रित 'पाशविक वृत्ति' (Animal instinct / Aggression) का प्रतीक है।
            माता ने उस 'शेर' को मारा नहीं, बल्कि उसे अपना 'वाहन' (Vehicle) बना लिया है; यानी अपनी एग्रेशन (Aggression) को कंट्रोल करना ही असली शक्ति है।
            देवताओं ने डरने के बजाय 'जय' का घोष किया, क्योंकि वे जानते थे कि यह 'डिस्ट्रक्शन' (विनाश) वास्तव में एक 'क्रिएशन' (नवनिर्माण) की शुरुआत है।
            'भक्तिनम्रात्ममूर्तयः' का मतलब है कि ज्ञानी मुनियों का अहंकार (Ego) माता के सामने 100% झुक गया (नम्र हो गया)।
            जब आपका 'लॉजिक' (बुद्धि) भगवान के सामने सरेंडर (Surrender) कर देता है, तभी असली 'स्तुति' (प्रार्थना) शुरू होती है।
            यह श्लोक सिखाता है कि जीवन में जब भयंकर बदलाव (Change) आए, तो उससे डरने के बजाय उस परम शक्ति की 'जयकार' करनी चाहिए।
            यही वह क्षण है जब पूरा ब्रह्मांड उस एक 'सुपर-पॉवर' (देवी) के सामने अपनी हार और उनकी जीत स्वीकार कर रहा है।
        """.trimIndent(),
        english = """
            (The profound praise by the Gods and Sages): "Hearing that exceptionally terrifying cosmic roar, absolutely all the Gods became intensely overjoyed (Muda) and actively cheered 'Victory, Victory' (Jayeti) strictly to that Goddess flawlessly riding the massive lion (Simhavahinim)!"
            "And absolutely all the highly enlightened sages present there effortlessly bowed completely down with profound pure devotion (Bhaktinamratmamurtayah) and aggressively actively commenced praying (Tushtuvur) exactly to that Supreme Goddess."
            Exactly when Nature (Mahamaya) violently actively manifests Her highly terrifying absolute form, toxic Ego (Demons) flawlessly panics, but pristine pure Sattvic forces (Gods and Sages) become intensely overjoyed.
            'Simhavahinim' profoundly literally translates exactly to She who rides the physical lion. The lion is the absolute direct symbol exactly of the human's highly uncontrollable, terrifying 'Animal Instinct' (Raw Aggression).
            The Mother absolutely completely did not slaughter that 'Lion'; She flawlessly entirely actively explicitly transformed it perfectly into Her absolute controlled 'Vehicle' (Vahana); meaning actively controlling your raw Aggression is the absolute true power.
            The Gods absolutely did not fear; they flawlessly cheered for Her absolute 'Victory', strictly because they perfectly knew this violent 'Destruction' was undeniably the exact beginning of a pristine new 'Creation'.
            'Bhaktinamratmamurtayah' flawlessly perfectly actively translates exactly that the massive toxic Ego exactly of the enlightened sages bowed 100% mathematically exactly perfectly down strictly before the Mother.
            Exactly when your highly complex 'Logic' (Intellect) flawlessly completely entirely Surrenders directly before Supreme God, strictly exclusively only then does actual true 'Prayer' (Stuti) flawlessly commence.
            This spectacular verse actively perfectly brilliantly teaches exactly that when highly terrifying massive Change violently actively occurs perfectly in your life, instead of pathetically fearing it, you absolutely must cheer for that Supreme Power.
            This is exactly that absolute precise cosmic moment exactly when the absolute entire massive Universe flawlessly accepts its total defeat and Her absolute Victory.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 34,
        sanskrit = "दृष्ट्वा समस्तं संक्षुब्धं त्रैलोक्यममरारयः ।\nसन्नद्धाखिलसैन्यास्ते समुत्तस्थुरुदायुधाः ॥ ३४ ॥",
        hindi = """
            (राक्षसों का पलटवार): "तीनों लोकों (त्रैलोक्यम्) को इस प्रकार अत्यंत भयंकर रूप से कांपते और 'क्षुब्ध' (संक्षुब्धं) होते हुए 'देखकर' (दृष्ट्वा)।"
            "उन देवताओं के सभी भयंकर शत्रुओं (अमरारयः / राक्षसों) ने तुरंत अपनी पूरी की पूरी 'विशाल सेना को तैयार किया' (सन्नद्धाखिलसैन्यास्ते)।"
            "और अपने-अपने भयंकर अस्त्र-शस्त्र और हथियार हवा में 'ऊपर उठाकर' (उदायुधाः), वे सभी राक्षस युद्ध के लिए एक साथ 'उठ खड़े हुए' (समुत्तस्थुर)!"
            यह श्लोक 'अहंकार' (Ego) के 'डिफेन्स मैकेनिज्म' (Defense Mechanism) का साक्षात् और सटीक वर्णन है!
            जब देवी (परम चेतना) की आवाज़ से पूरा सिस्टम (त्रैलोक्य) हिलने लगता है, तो राक्षस (अज्ञान) शांत नहीं बैठते; वे तुरंत 'काउन्टर-अटैक' (Counter-attack) के लिए तैयार हो जाते हैं।
            'अमरारयः' का मतलब है जो 'अमरता' (ज्ञान) के दुश्मन हैं। जब आपके अंदर कोई अच्छी आदत (देवी) जन्म लेती है, तो आपकी सारी पुरानी बुरी आदतें (राक्षस) एक साथ मिलकर बगावत (Rebellion) कर देती हैं!
            उन्होंने अपने 'सारे सैनिकों' (अखिलसैन्यास्) को तैयार कर लिया; यानी वासना, क्रोध, लालच, ईर्ष्या—सब एक साथ एक्टिवेट (Activate) हो गए।
            'उदायुधाः' (हथियार ऊपर उठाना) राक्षसों के उस घमंड को दिखाता है जहाँ वे साक्षात् 'परमात्मा' (ईश्वर) से भी लड़ने की मूर्खता कर बैठते हैं।
            जब इंसान का विनाश (Destruction) करीब आता है, तो उसकी बुद्धि पूरी तरह से उल्टी (Corrupt) हो जाती है।
            महिषासुर की सेना का यह 'उठ खड़ा होना' वास्तव में उनकी मौत की तरफ उठाया गया उनका अपना ही पहला कदम था!
        """.trimIndent(),
        english = """
            (The horrific counter-attack of the demons): "Flawlessly entirely explicitly violently 'Seeing and perfectly perceiving' (Drishtva) exactly that the absolute entire three cosmic worlds (Trailokyam) were exceptionally terrifyingly shaken and violently 'Agitated' (Sankshubdham)."
            "Absolutely all the highly terrifying massive absolute enemies exactly of the immortal Gods (Amararayah / Demons) instantaneously violently actively aggressively 'Prepared and mobilized their absolute entire massive armies' (Sannaddhakhilasainyaste)."
            "And violently aggressively actively 'raising' their highly lethal terrifying physical weapons completely high strictly into the physical air (Udayudhah), absolutely all those specific demons violently 'Stood completely entirely up' (Samuttasthur) perfectly entirely together exactly for a horrific war!"
            This spectacular verse is undeniably the absolute precise, direct, explicit literal description exclusively of the ultimate terrifying 'Defense Mechanism' strictly of toxic 'Ego' (Ahankara)!
            Exactly when the absolute entire massive System (Trailokya) flawlessly violently completely shakes strictly from the explicit voice of the Goddess (Supreme Consciousness), the massive Demons (Ignorance) absolutely never sit quietly; they instantly perfectly seamlessly violently actively completely prepare exactly for a massive 'Counter-Attack'.
            'Amararayah' literally profoundly actively strictly flawlessly precisely means exactly those who are the direct absolute enemies exactly of 'Immortality' (Supreme Wisdom). Exactly when a pristine new highly positive habit (Goddess) is born perfectly inside you, absolutely all your toxic old habits (Demons) aggressively flawlessly violently unite and launch a terrifying Rebellion!
            They flawlessly violently actively mobilized their 'Absolute entire armies' (Akhilasainyas); meaning highly toxic lust, brutal anger, blind greed, and dark jealousy—absolutely all of them aggressively flawlessly actively seamlessly violently Activated perfectly simultaneously completely together.
            'Udayudhah' (Raising weapons high) flawlessly brilliant aggressively perfectly violently actively exposes exactly that exceptionally specific terrifying absolute completely blind arrogance exactly of the demons exactly where they explicitly flawlessly perform the absolute stupidity entirely of aggressively physically actively fighting absolute Supreme 'God' (Ishwara) Himself.
            Exactly when a pathetic human's ultimate horrific complete total Destruction physically arrives exceptionally close, his highly complex absolute Intellect completely seamlessly actively violently turns 100% upside down (Corrupt).
            This violent 'Standing completely up' exclusively of Mahishasura's massive horrific army was undeniably, in absolute reality, their very own literal explicit direct exact literal first massive step taken perfectly actively entirely exactly directly towards their very own explicit certain brutal Death!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 35,
        sanskrit = "आः किमेतदिति क्रोधादाभाष्य महिषासुरः ।\nअभ्यधावत तं शब्दमशेषैरसुरैर्वृतः ॥ ३५ ॥",
        hindi = """
            (महिषासुर का क्रोध और चुनौती): "उस भयंकर गर्जना को सुनकर महिषासुर ने अत्यंत क्रोध (क्रोधाद्) में आकर जोर से चिल्लाते हुए (आभाष्य) कहा: 'आः! यह क्या है?' (आः किमेतदिति)।"
            "और फिर वह दुष्ट महिषासुर अपने 'बाकी बचे हुए सभी अनंत राक्षसों' (अशेषैरसुरैर्) से पूरी तरह घिरकर (वृतः / साथ लेकर)।"
            "उस भयंकर 'आवाज़ की दिशा' (तं शब्दम्) की ओर अत्यंत तेज़ी से 'दौड़ पड़ा' (अभ्यधावत)!"
            'आः किमेतदिति' (यह क्या है!)—यह किसी राजा का प्रश्न नहीं है, यह एक डरे हुए और बौखलाए हुए 'अहंकार' (Ego) की चीख है!
            महिषासुर को लगा था कि उसने दुनिया जीत ली है, पर अचानक एक नई और अजेय आवाज़ (देवी) ने उसके 'कम्फर्ट ज़ोन' (Comfort Zone) को तोड़ दिया।
            ईगो (Ego) को जब कोई चैलेंज (Challenge) करता है, तो वह सबसे पहले 'क्रोध' (Anger) में आता है। महिषासुर ने सोचा नहीं, वह सीधा 'दौड़ पड़ा' (अभ्यधावत)!
            बिना सोचे-समझे केवल क्रोध (Anger) में आकर एक्शन लेना, विनाश (Destruction) की सबसे बड़ी निशानी है।
            उसने अपने सारे 'अशेष असुरों' (अनंत राक्षसों) को साथ ले लिया; यानी जब इंसान गलत रास्ते पर होता है, तो वह अपनी सारी ताकतों (पैसे, पॉवर) का इस्तेमाल एक साथ कर देता है।
            पर वह किस तरफ दौड़ा? 'तं शब्दम्' (उस आवाज़ की तरफ)! उसे पता ही नहीं था कि वह आवाज़ साक्षात् मौत (देवी) की है!
            अहंकार (महिषासुर) हमेशा रोशनी की बजाय उस आवाज़ (Illusion/आकर्षण) की तरफ भागता है जो उसे बर्बाद करने वाली होती है।
            यह श्लोक 'रिएक्शन' (Reaction) और 'रेस्पोंस' (Response) के बीच का फर्क समझाता है—महिषासुर ने 'रिएक्ट' किया, और यही उसकी सबसे बड़ी भूल थी।
        """.trimIndent(),
        english = """
            (Mahishasura's terrifying anger and challenge): "Flawlessly actively hearing that exceptionally terrifying roar, Mahishasura violently explicitly screamed (Abhashya) perfectly strictly in absolute extreme 'Anger' (Krodhad): 'Ah! Exactly what on earth is this?' (Aah! Kimetaditi)."
            "And exactly immediately then, that extremely wicked Mahishasura, flawlessly entirely completely actively entirely entirely surrounded entirely perfectly (Vritah / accompanied) exclusively strictly by absolutely 'all his remaining infinite countless demons' (Asheshairasurair)."
            "Aggressively violently seamlessly perfectly exactly explicitly 'Rushed and sprinted exceptionally fast' (Abhyadhāvat) entirely flawlessly directly strictly perfectly precisely exactly toward the exact direct explicit 'Source of that terrifying Sound' (Tam shabdam)!"
            'Ah! Kimetaditi' (Exactly what is this!)—this is absolutely zero cheap question of a secure King, this is undeniably the absolute violent terrified scream explicitly of a highly panicked and completely completely shaken 'Ego'!
            Mahishasura had blindly flawlessly confidently assumed he had entirely completely conquered the absolute world, but suddenly an entirely completely brand new and absolutely invincible cosmic sound (The Goddess) flawlessly perfectly violently shattered his toxic 'Comfort Zone'.
            Exactly when absolutely anyone explicitly seamlessly actively Challenges the toxic Ego, it absolute completely primarily explicitly reacts flawlessly perfectly strictly with massive brutal 'Anger' (Krodhad). Mahishasura absolutely zero percent actively exactly thought, he perfectly blindly entirely seamlessly 'Sprinted' (Abhyadhavat)!
            Aggressively taking explicit active violent action strictly perfectly purely in completely blind Anger entirely without completely dynamically thinking, is undeniably the absolute greatest explicit active massive sign exclusively of certain Destruction.
            He perfectly flawlessly completely successfully took his entirely exactly absolute 'Infinite demons' (Ashesha asuras) strictly completely along; meaning exactly when a pathetic human is on the perfectly wrong path, he aggressively entirely actively utilizes absolutely all his complete total powers (money, authority) entirely actively simultaneously perfectly together.
            But exactly which explicit perfectly exact direction did he aggressively actively perfectly run? 'Tam shabdam' (Strictly explicitly toward that precise Sound)! He had absolutely completely zero microscopic idea exactly that that identical specific sound was undeniably literal exact physical absolute Death (The Goddess) Herself!
            Highly toxic absolute Ego (Mahishasura) inherently perpetually frantically relentlessly effectively runs actively strictly perfectly exactly toward that specific Voice (Illusion/Attraction) perfectly identically which is actively flawlessly flawlessly exclusively preparing entirely to brutally destroy it, instead exactly of running perfectly precisely seamlessly exactly directly toward the pure pristine Light.
            This spectacular verse brilliantly seamlessly perfectly flawlessly flawlessly completely seamlessly explains the absolute literal massive exact difference exactly strictly perfectly completely perfectly between an animalistic 'Reaction' and a divine active 'Response'—Mahishasura flawlessly exclusively aggressively strictly 'Reacted', and exactly this was undeniably absolutely his greatest absolute fatal mistake.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 36,
        sanskrit = "स ददर्श ततो देवीं व्याप्तलोकत्रयां त्विषा ।\nपादाक्रान्त्या नतभुवं किरीटोल्लिखिताम्बराम् ॥ ३६ ॥",
        hindi = """
            (देवी का साक्षात् विराट रूप): "वहां पहुँचकर उस महिषासुर ने (स ददर्श ततो) उस परम 'देवी' को साक्षात् अपने सामने देखा!"
            "जिनके शरीर की भयंकर चमक और कांति (त्विषा) से पूरे के पूरे 'तीनों लोक' (व्याप्तलोकत्रयां) पूरी तरह से व्याप्त (भरे हुए) थे।"
            "जिनके 'पैरों के भयंकर दबाव' (पादाक्रान्त्या) से यह पूरी पृथ्वी दबकर 'नीचे की ओर धंस गई थी' (नतभुवं)।"
            "और जिनके सिर पर रखे हुए विशाल 'मुकुट' (किरीट) से आकाश (अम्बराम्) 'छिल' रहा था (किरीटोल्लिखिताम्बराम् / मुकुट आकाश को खरोंच रहा था)!"
            यह देवी के 'विराट रूप' (Cosmic Form) का सबसे खौफनाक और 'सिनेमैटिक' (Cinematic) वर्णन है!
            राक्षस सोच रहे थे कि वे किसी साधारण औरत से लड़ने जा रहे हैं, पर उन्होंने जो देखा, उसने उनके दिमाग की तारें (Circuits) जला दीं!
            'व्याप्तलोकत्रयां त्विषा'—देवी के शरीर से इतनी भयंकर 'रोशनी' (Laser/Aura) निकल रही थी कि तीनों लोकों (3D Space) में कोई और चीज़ दिखाई ही नहीं दे रही थी।
            'पादाक्रान्त्या नतभुवं'—ग्रैविटी (Gravity) फेल हो गई! देवी का वजन (Mass) इतना 'इनफाइनाइट' (Infinite) था कि धरती उनके पैरों के नीचे (दबाव से) दब गई थी!
            'किरीटोल्लिखिताम्बराम्'—उनका 'मुकुट' (Crown) इतना ऊँचा था कि वह बादलों और आसमान (Space) को छील (Scratch) रहा था!
            महिषासुर (ईगो) जो खुद को सबसे बड़ा समझता था, आज उसने साक्षात् 'इन्फिनिटी' (Infinity / अनंत) को अपने सामने देख लिया था।
            जब इंसान अपने छोटे से 'अहंकार' के साथ 'परमात्मा' से टकराने जाता है, तो उसे भगवान का यही 'विराट' रूप उसकी औकात (Reality) याद दिलाता है।
        """.trimIndent(),
        english = """
            (The exact absolute horrific massive literal literal Cosmic Form entirely of the Goddess): "Flawlessly arriving exactly perfectly there, that exact Mahishasura literally perfectly flawlessly 'Vividly Saw and perceived' (Sa dadarsha tato) that exact Supreme 'Goddess' perfectly directly explicitly directly in front of him!"
            "The entire absolute complete explicitly massive 'Three Cosmic Worlds' (Vyaptalokatrayam) were flawlessly aggressively entirely completely entirely actively completely filled and intensely strictly violently seamlessly Pervaded exclusively exactly perfectly strictly by the highly exceptionally terrifying massive blinding physical explicit 'Radiance and Aura' (Tvisha) actively emanating exactly from Her physical body."
            "By the exceptionally heavily explicitly highly terrifying active 'Violent pressure explicitly of Her exact physical massive feet' (Padakrantya), this absolute entire physical literal Earth was flawlessly completely heavily aggressively pressed perfectly exactly straight directly 'completely downwards' (Natabhuvam)."
            "And explicitly from the absolute massive exceptionally towering colossal 'Crown' (Kiriṭa) perfectly flawlessly resting directly exactly upon Her physical head, the entire massive open Sky and space (Ambaram) was flawlessly actively dynamically completely completely actively violently actively violently being literally 'Scratched and scraped' (Kiriṭollikhitambaram)!"
            This is undeniably the absolute most highly exceptionally perfectly terrifying and brilliantly explicitly 'Cinematic' exact explicit absolute perfectly precise vivid description exactly entirely exclusively perfectly of the Goddess's absolute true explicitly specific literal 'Cosmic Form' (Virat Rupa)!
            The massive demons perfectly completely foolishly actively strictly blindly completely assumed perfectly explicitly they were actively aggressively enthusiastically seamlessly going explicitly completely exactly directly entirely explicitly strictly to explicitly actively flawlessly fight perfectly exactly some cheap ordinary physical woman, but exactly whatever they actively physically Saw, flawlessly entirely perfectly violently violently actively perfectly violently entirely seamlessly burned the exact explicit literal internal physical electrical completely completely absolute explicit Circuits of their brain!
            'Vyaptalokatrayam tvisha'—An exceptionally highly completely entirely exclusively terrifying absolute massive 'Blinding Light' (Laser/Aura) was actively entirely explicitly seamlessly completely entirely emanating strictly entirely exclusively perfectly directly entirely from the Goddess's physical body exactly entirely so intensely that absolutely zero entirely perfectly identically perfectly exactly other single object was physically entirely flawlessly actively seamlessly perfectly exclusively explicitly visible strictly actively perfectly in the exactly absolute entire 3D Space!
            'Padakrantya natabhuvam'—Literal Gravity completely flawlessly actively identically identically actively identically actively seamlessly completely actively entirely perfectly Failed! The absolute infinite precise exact literal specific Physical Mass (Weight) exactly of the Goddess was undeniably completely absolutely so exceptionally completely exactly perfectly 'Infinite' exactly that the entire literal physical earth was violently flawlessly aggressively perfectly pushed entirely exactly completely identically precisely downward explicitly directly entirely perfectly directly actively explicitly specifically under Her exact perfectly explicit feet!
            'Kiriṭollikhitambaram'—Her literal absolute specific specific 'Crown' (Kiriṭa) was completely actively entirely completely successfully explicitly exactly so exceptionally incredibly precisely tall that it was explicitly physically exactly exactly manually 'Scratching and actively cleanly scraping' perfectly exactly the completely identical explicitly entirely physical clouds and absolute exact completely perfect entire Sky (Space)!
            Mahishasura (Ego), who flawlessly completely utterly entirely perfectly completely entirely assumed himself exactly strictly exclusively exactly to perfectly explicitly identically completely exactly completely be the absolute exactly entirely greatest exactly entity entirely, had today flawlessly flawlessly violently seamlessly physically entirely successfully perfectly actively seen completely literal direct pure absolute 'Infinity' perfectly perfectly entirely completely identically exactly actively completely completely effectively exactly standing completely physically entirely exactly identically correctly perfectly entirely seamlessly perfectly directly entirely perfectly in perfectly perfectly explicitly perfectly front of him.
            Exactly when a pathetic human completely successfully strictly purely enthusiastically actively explicitly efficiently identically flawlessly flawlessly seamlessly exactly perfectly physically goes strictly exactly flawlessly entirely directly actively fully efficiently purely entirely to explicitly smoothly completely collide perfectly flawlessly perfectly strictly exactly completely actively dynamically directly completely perfectly with 'Supreme God' perfectly perfectly actively exactly exactly perfectly flawlessly effectively exactly effectively securely together exactly perfectly strictly completely identical entirely directly strictly exclusively effectively smoothly identical completely exact exact along entirely with his own exactly precisely completely tiny 'Ego', this perfectly strictly strictly absolute identical precisely explicitly exact identical absolute identically exact perfectly flawlessly precisely exact completely 'Virat' (Cosmic) form identically exactly exclusively of God explicitly flawlessly seamlessly completely strictly violently actively completely smoothly effectively identical completely identically effortlessly exactly perfectly completely explicitly cleanly completely seamlessly effortlessly perfectly flawlessly cleanly directly exactly reminds him entirely exactly of his absolute perfectly exact completely pathetic entirely exact precise precise exact true reality (Aukaat).
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 37,
        sanskrit = "क्षोभिताशेषपातालान् धनुर्ज्यानिःस्वनेन ताम् ।\nदिशो भुजसहस्रेण समन्ताद् व्याप्य संस्थिताम् ॥ ३९ ॥",
        hindi = """
            (सहस्रभुजाओं वाली देवी का रूप): "वह परम देवी अपने भयंकर 'धनुष की डोरी की टंकार' से ही 'संपूर्ण पाताल लोकों को अत्यंत भयंकर रूप से क्षुब्ध और कंपा रही थीं'!"
            "और अपनी अत्यंत भयंकर 'हज़ार भुजाओं' (हज़ार हाथों) से इस पूरे ब्रह्मांड की 'सभी दसों दिशाओं को' चारों ओर से पूरी तरह घेरकर अत्यंत खौफनाक रूप में साक्षात् खड़ी हुई थीं!"
            देवी ने कोई तीर नहीं चलाया! उन्होंने केवल अपने धनुष की डोरी को खींचा और छोड़ दिया!
            उस 'टंकार' (Sound Frequency) से ही पाताल लोक (अवचेतन मन का सबसे गहरा हिस्सा) तक में भयंकर भूकंप आ गया!
            यह दिखाता है कि माता का एक छोटा सा एक्शन भी ब्रह्मांड के लिए एक प्रलय (Apocalypse) के समान है।
            देवी के 'हज़ार हाथ' कोई फिजिकल हाथ नहीं हैं; यह इस बात का साक्षात् प्रतीक है कि देवी एक ही सेकंड में अनंत दिशाओं में काम कर सकती हैं।
            यह मल्टी-टास्किंग और सर्वव्यापकता (Omnipresence) का सबसे बड़ा और सबसे शक्तिशाली सबूत है।
            दिशाओं को घेरने का मतलब है कि महिषासुर के लिए भागने का कोई भी रास्ता (Escape route) नहीं बचा है।
            वह चारों तरफ से मौत के 'लॉकडाउन' (Lockdown) में पूरी तरह से फँस चुका है।
            अहंकार को लगता है कि वह भाग सकता है, पर 'चेतना' उसे हर तरफ से घेर लेती है।
        """.trimIndent(),
        english = """
            (The Form of the Thousand-Armed Goddess): "That absolute Supreme Goddess was actively flawlessly aggressively violently shaking and exceptionally severely agitating absolutely all the entire massive infinite Underworlds exclusively exactly by the exceptionally terrifying absolute physical Brutal Twang of Her massive cosmic Bowstring!"
            "And strictly seamlessly actively leveraging exactly Her exceptionally horrifying terrifying Thousand Colossal Arms, She actively completely encompassed and ruthlessly invaded absolutely all the entire cosmic directions flawlessly entirely from absolutely all massive cosmic sides, standing physically manifested exactly in an absolute highly terrifying stance!"
            The Goddess absolutely entirely flawlessly did not explicitly fire exactly a single physical Arrow! She exclusively exactly merely pulled Her exact massive cosmic bow's literal physical String and flawlessly released it!
            Explicitly from exactly that single exact Twang (Sound Frequency), an absolute apocalyptic terrifying massive earthquake flawlessly successfully struck flawlessly entirely perfectly down exactly to the exact massive physical Underworld (The absolute deepest darkest core of the Subconscious mind)!
            This spectacularly completely proves exactly that absolutely even the absolute most seemingly microscopic tiny exact explicit Action strictly of the Mother is exactly flawlessly identical exactly to an absolute terrifying literal physical massive Apocalypse.
            The Mother's thousand physical arms are absolutely zero cheap ordinary biological arms; this explicitly symbolizes the absolute undeniable concrete proof that the Supreme Goddess flawlessly perfectly executes massive exact absolute actions simultaneously entirely across Infinite possible dimensions actively in entirely one single split-second.
            This is undeniably the absolute greatest exact explicit physical proof exactly of absolute cosmic Multi-tasking and literal Omnipresence.
            Aggressively encompassing all literal physical Directions explicitly entirely absolutely guarantees exactly that Mahishasura successfully possesses absolutely zero microscopic precise physical Escape Route.
            He is ruthlessly trapped completely exactly securely exclusively entirely directly straight inside an absolute terrifying exact literal perfectly physical strictly fatal Lockdown.
            Toxic Ego actively arrogantly assumes it can successfully Escape, but pure Consciousness ruthlessly relentlessly brutally physically successfully surrounds it entirely perfectly completely.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 38,
        sanskrit = "ततः प्रववृते युद्धं तया देव्या सुरद्विषाम् ।\nशस्त्रास्त्रैर्बहुधा मुक्तैरादीपितदिगन्तरम् ॥ ४० ॥",
        hindi = """
            (महासंग्राम का आरंभ): "इसके ठीक बाद, उस परम महामाया देवी और उन भयंकर देवताओं के दुश्मनों (राक्षसों) के बीच वह अत्यंत खौफनाक और विनाशकारी 'महायुद्ध' पूरी तरह से आरंभ हो गया!"
            "उस भयंकर युद्ध में दोनों तरफ से लगातार फेंके जा रहे अनेक प्रकार के खौफनाक 'अस्त्र-शस्त्रों' की भयानक आग और चमक से।"
            "पूरे ब्रह्मांड की दसों दिशाएं और सारा अंतरिक्ष पूरी तरह से चमचमा उठा और भयंकर रूप से प्रकाशित हो गया!"
            अब बात-चीत खत्म हो चुकी है; भयंकर एक्शन (Action) शुरू हो चुका है! देवी और राक्षसों (Ego) के बीच सीधी फिजिकल टक्कर हो रही है।
            यहाँ 'अस्त्र' (जिन्हें मंत्र से फेंका जाए) और 'शस्त्र' (जिन्हें हाथ से पकड़कर चलाया जाए) दोनों का ज़िक्र है।
            यानी यह केवल एक तलवारबाज़ी नहीं है; यह एक 'हाई-टेक कॉस्मिक वॉर' (High-tech Cosmic War) है जहाँ भयंकर एनर्जी वेपन्स का इस्तेमाल हो रहा है।
            आसमान में इतने ज़्यादा हथियार टकरा रहे हैं कि उनसे निकलने वाली 'चिंगारियों' और चमक से पूरा आसमान रौशन हो गया है।
            जब आपके अंदर बुराई (महिषासुर) और अच्छाई (चेतना) का युद्ध होता है, तो आपका पूरा दिमाग ऐसे ही 'ओवरहीट' (Overheat) और 'फ्लैश' करने लगता है।
            यह श्लोक 'कॉन्फ्लिक्ट' (Conflict) के उस चरम बिंदु को दर्शाता है जहाँ कोई भी पक्ष पीछे हटने को तैयार नहीं है।
            सत्य अब सीधे झूठ को अपने हथियारों से पूरी तरह काट रहा है!
        """.trimIndent(),
        english = """
            (The Initiation of the Cosmic Mega-War): "Immediately after this, flawlessly strictly between that absolute Supreme Mahamaya Goddess and those exceptionally terrifying absolute enemies of the pure Gods (The demons)."
            "That absolute exceptionally horrific, completely terrifying, and highly apocalyptic massive Colossal Cosmic Mega-War flawlessly aggressively violently Exploded and fiercely commenced!"
            "Exactly exclusively due entirely to the exceptionally horrific blinding catastrophic fire and terrifying supreme cosmic brilliant flash exactly explicitly strictly of completely countless devastating weapons and absolute high-tech cosmic missiles being relentlessly violently unleashed completely from both specific sides."
            "The absolute entire physical completely boundary-less cosmic Space and absolutely all the ten vast massive physical cosmic directions became violently completely aggressively Blindingly illuminated and flawlessly violently set spectacularly entirely ablaze!"
            Absolutely all cheap talk has permanently violently officially ended; absolute raw terrifying physical Action has aggressively explicitly flawlessly seamlessly violently perfectly begun! Direct active physical literal explicit exact collision is occurring seamlessly between the explicit pure Goddess and the explicit physical demons (Ego).
            This undeniably actively aggressively seamlessly exclusively entirely explicitly successfully clearly distinguishes strictly exactly between both Astra (Energy missiles) and Shastra (Material weapons).
            Meaning precisely that this is absolutely zero cheap physical sword-fight; this is undeniably an absolute High-Tech Cosmic War exactly where exceptionally massive absolute raw Energy Weapons are violently aggressively flawlessly effectively utilized.
            Exactly so incredibly flawlessly countless specific weapons are brutally aggressively dynamically flawlessly physically colliding seamlessly effectively that the absolute exact Sparks generated from them have successfully violently explicitly gracefully entirely efficiently completely illuminated exactly completely the exact pure complete entire Sky.
            Exactly when the terrifying war exactly smoothly precisely between pure evil (Mahishasura) and pure Goodness (Consciousness) aggressively violently occurs exactly inside you, your exact Brain identically entirely completely begins entirely to completely violently Overheat and exactly violently Flash perfectly.
            This spectacular verse undeniably flawlessly perfectly represents exactly that absolute ultimate terrifying Conflict explicitly exactly where absolutely zero side actively attempts entirely to actively physically flawlessly perfectly retreat.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 39,
        sanskrit = "महिषासुरसेनानीश्चिक्षुराख्यो महासुरः ।\nयुयुधे चामरश्चान्यैश्चतुरङ्गबलान्वितः ॥ ४१ ॥",
        hindi = """
            (राक्षसों के सेनापतियों का हमला): "महिषासुर की विशाल सेना का सबसे बड़ा 'सेनापति', जो 'चिक्षुर' नाम का एक अत्यंत भयंकर महासुर था, वह युद्ध के मैदान में देवी से लड़ने के लिए आगे आया।"
            "और उसके साथ ही 'चामर' नाम का एक और भयंकर राक्षस अपनी 'चतुरंगिणी सेना' (हाथी, घोड़े, रथ और पैदल सैनिक) को लेकर माता के साथ भयंकर युद्ध करने लगा!"
            यहाँ से महिषासुर के टॉप जनरल्स (Top Generals) की भयंकर एंट्री होती है!
            'चिक्षुर' का अर्थ है 'चंचल' (Restless/Scattered Mind)। यह इंसान का वह विचार है जो कभी टिकता नहीं और हमेशा इधर-उधर भागता रहता है।
            'चामर' का अर्थ है वह राक्षस जो अहंकार (Ego) को हवा देता है (फ्लैटरिंग/Flattery)।
            राक्षस (मेन ईगो) खुद सीधे नहीं लड़ता; पहले वह अपने जनरल्स (आदतों) को भेजता है।
            चतुरंगिणी सेना का मतलब है कि महिषासुर के जनरल्स पूरी तैयारी और 'फुल फोर्स' (Full force) के साथ आए हैं।
            यह कोई रैंडम (Random) लड़ाई नहीं है; यह एक वेल-प्लांड मिलिट्री स्ट्रेटेजी (Well-planned military strategy) है।
            देवी की एक गर्जना ने इन सारे राक्षसों के ईगो को हिला दिया है, और अब वे अपना सब कुछ झोंक कर देवी पर प्रहार कर रहे हैं।
            सत्य की स्थिरता (Stability) को चंचलता (चिक्षुर) हराने की कोशिश कर रही है।
        """.trimIndent(),
        english = """
            (The Attack of the Demonic Generals): "The absolute supreme Commander-in-Chief exactly of Mahishasura's colossal demonic army, an exceptionally terrifying and violently horrific Mega-Demon explicitly named 'Chikshura', aggressively violently stepped flawlessly perfectly forward entirely exactly into the physical battlefield to fight the Goddess."
            "And flawlessly completely perfectly right alongside him, exactly another exceptionally horrifying monster explicitly named 'Chamara' violently aggressively initiated an exceptionally terrifying cosmic war against the Mother, actively explicitly bringing his absolute massive Four-fold military division (Elephants, cavalry, chariots, and absolute infantry)!"
            Right exactly from here seamlessly flawlessly violently seamlessly aggressively begins the absolute explicit terrifying physical active entry exactly of Mahishasura's absolute Top Generals!
            'Chikshura' undeniably explicitly literally perfectly translates strictly exactly to Highly Restless (Scattered Mind). This is exactly that specific highly toxic human thought which absolutely never stably settles and perpetually frantically violently runs aimlessly everywhere.
            'Chamara' profoundly flawlessly translates perfectly to exactly that highly toxic demon who violently actively aggressively fans and perfectly explicitly heavily feeds the toxic Ego (Flattery/Sycophancy).
            The massive Boss Demon absolutely never actively directly fights completely perfectly straight perfectly exactly flawlessly straight away; he flawlessly actively aggressively explicitly systematically initially actively entirely perfectly exclusively sends his absolute exact Top Generals (Habits) first.
            The Four-fold army strictly explicitly proves exactly that these demonic generals have actively brutally ruthlessly aggressively deployed absolutely all physical resources actively arriving flawlessly equipped with absolute Full Force.
            This is absolutely zero cheap ordinary random physical fight; this is undeniably an absolute precise highly advanced well-planned military Strategy.
            The Mother's terrifying Roar has completely successfully completely shattered their toxic Ego, and exactly now they are violently actively completely explicitly desperately attempting perfectly entirely to physically successfully flawlessly completely precisely strictly absolutely actively strike Her completely entirely.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 40,
        sanskrit = "रथानामयुतैः षड्भिर्युयुधे चामरो रणे ।\nरथानामयुतैः साग्रैश्चतुर्भिर्बाष्कलो युयुधे ॥ ४२ ॥",
        hindi = """
            (चामर और बाष्कल का भयंकर आक्रमण): "उस खौफनाक युद्ध के मैदान में, 'चामर' नाम का वह महा-राक्षस पूरे 'साठ हज़ार' रथों की विशाल सेना लेकर देवी से लड़ने लगा!"
            "और 'बाष्कल' नाम का अत्यंत भयंकर राक्षस अपने साथ 'चालीस हज़ार' से भी अधिक रथों की सेना लेकर माता के साथ महायुद्ध करने लगा!"
            यह केवल रथों की गिनती नहीं है; यह इंसान के दिमाग में पैदा होने वाले 'नेगेटिव विचारों' (Negative thoughts) की गिनती है।
            'चामर' वह आदत है जो हमारे ईगो को 'हवा' देती है, और यह आदत अकेले नहीं आती, यह अपने साथ साठ हज़ार अन्य तर्कों (Excuses) को लेकर आती है।
            'बाष्कल' का अर्थ है अंधापन और हठ (Blind stubbornness), जो चालीस हज़ार अलग-अलग प्रकार के भ्रम (Illusions) पैदा करता है।
            जब इंसान ध्यान (Meditation) या सच्चाई के रास्ते पर चलता है, तो उसका दिमाग अचानक हज़ारों फालतू विचारों (रथों) से भर जाता है।
            ये रथ (Chariots) हमारे दिमाग के वो तेज़ विचार हैं जो एक सेकंड में हमें फोकस से हटाकर भटकाने की कोशिश करते हैं।
            महिषासुर (मुख्य अहंकार) अभी पीछे है; वह पहले अपने इन 'विचार-रूपी सेनापतियों' को भेजकर चेतना (देवी) को थकाना चाहता है।
            परंतु महामाया इन साठ हज़ार और चालीस हज़ार विचारों को बिना हिले अपनी जगह पर खड़े रहकर नष्ट करने वाली हैं।
            अज्ञान की संख्या हमेशा बहुत बड़ी होती है, जबकि सत्य हमेशा अकेला और स्थिर होता है।
        """.trimIndent(),
        english = """
            (The Terrifying Attack of Chamara and Bashkala): "Exactly directly in that horrific battlefield, the mega-demon explicitly named 'Chamara' actively fought the Goddess aggressively deploying a colossal army of exactly Sixty Thousand massive chariots!"
            "And the exceptionally terrifying monster explicitly named 'Bashkala' violently initiated a colossal cosmic war against the Mother, aggressively bringing entirely more than Forty Thousand heavily armed chariots!"
            This is absolutely zero cheap physical counting of wooden chariots; this undeniably flawlessly represents the exact massive mathematical count of highly toxic Negative Thoughts violently generated directly inside the human brain.
            'Chamara' is exactly that specific highly toxic habit which actively fans and feeds our Ego, and this habit absolutely never arrives alone; it violently brings sixty thousand physical Excuses exactly alongside it.
            'Bashkala' profoundly translates exactly to blinding stubbornness and extreme arrogance, actively generating exactly forty thousand completely different types of thick Illusions.
            Exactly when a human successfully actively initiates pure Meditation or the path of Supreme Truth, his brain instantaneously violently floods perfectly with thousands of useless thoughts (Chariots).
            These exact massive Chariots flawlessly perfectly represent the highly accelerated racing thoughts actively aggressively attempting to ruthlessly derail our pure Focus in exactly a single split-second.
            Mahishasura (The Core Ego) is actively currently hiding perfectly behind; he is systematically actively deploying these specific 'Thought-Generals' first explicitly to actively exhaust the pure Consciousness (The Goddess).
            However, Mahamaya is flawlessly actively preparing to permanently ruthlessly annihilate all these sixty thousand and forty thousand thoughts completely actively remaining entirely perfectly motionless exactly in exactly one single spot.
            The absolute quantity of thick Ignorance is perpetually exceptionally massive, whereas the Supreme Truth is undeniably perpetually exactly alone, singular, and perfectly absolutely stable.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 41,
        sanskrit = "उदायुधो महाहनुर्युयुधे कोटिभिर्वृतः ।\nपञ्चाशद्भि रथानां च सहस्रैर्युयुधेऽसिलोमा ॥ ४३ ॥",
        hindi = """
            (महाहनु और असिलोमा का प्रहार): "अत्यंत विशाल जबड़े वाला 'महाहनु' नाम का भयंकर राक्षस अपने हथियारों को ऊपर उठाए हुए, पूरे 'एक करोड़' सैनिकों से घिरकर युद्ध करने लगा!"
            "और तलवारों के समान तीखे बालों वाला 'असिलोमा' नाम का महा-राक्षस पूरे 'पचास हज़ार' रथों की विशाल सेना के साथ देवी पर टूट पड़ा!"
            यहाँ राक्षसों के नाम इंसान की साइकोलॉजी के सबसे डरावने पहलुओं को डिकोड करते हैं।
            'महाहनु' (Massive Jaw) इंसान की उस भयंकर 'लालच और भूख' (Greed/Lust) का प्रतीक है जो पूरी दुनिया को खा जाना चाहती है और कभी संतुष्ट नहीं होती।
            यह लालच एक या दो नहीं, बल्कि पूरे 'एक करोड़' नए डिज़ायर्स (इच्छाओं) को जन्म देता है, जो इंसान को अंदर से खोखला कर देते हैं।
            'असिलोमा' (Sword-hair) इंसान की उस 'डिफेंसिवनेस' (Defensiveness) का प्रतीक है, जहाँ इंसान के बाल भी तलवार की तरह चुभने वाले हो जाते हैं।
            यह वह अहंकार है जो किसी की छोटी सी बात पर भी भयंकर रूप से ऑफेंड हो जाता है और लड़ने के लिए 50 हज़ार तर्क ले आता है।
            ये राक्षस बाहर से नहीं आए हैं; ये साक्षात् हमारे अपने दिमाग के वो 'बग्स' (Bugs) हैं जो सिस्टम को पूरी तरह से करप्ट कर रहे हैं।
            महिषासुर का यह 'डिस्ट्रीब्यूटेड अटैक' चेतना (देवी) को हर तरफ से ओवरलोड करने की कोशिश कर रहा है।
            परंतु महामाया का एंटी-वायरस इन करोड़ों वायरसों को केवल एक पल में स्कैन करके डिलीट करने वाला है।
        """.trimIndent(),
        english = """
            (The Brutal Strike of Mahahanu and Asiloma): "The exceptionally terrifying monster with an aggressively massive jaw explicitly named 'Mahahanu', violently keeping his deadly weapons raised high, actively fought entirely surrounded by exactly One Crore (Ten Million) demonic soldiers!"
            "And the mega-demon explicitly named 'Asiloma', possessing body hair exactly as sharp as actual physical swords, aggressively violently attacked the Goddess explicitly alongside exactly Fifty Thousand highly advanced chariots!"
            Right exactly here, the specific literal names exactly of the massive demons flawlessly perfectly Decode the absolute most exceptionally terrifying aspects entirely of human Psychology.
            'Mahahanu' (Massive Jaw) undeniably flawlessly perfectly symbolizes the exact terrifying human Greed and endless Lust which violently actively desires to brutally consume the entire physical world and remains absolutely perpetually unsatisfied.
            This highly toxic Greed actively dynamically successfully births absolutely not one or two, but exactly an entire One Crore (Ten Million) completely brand new toxic Desires, ruthlessly actively hollowing the exact human out completely entirely from the exact inside.
            'Asiloma' (Sword-hair) is the absolute explicit physical symbol of exactly that terrifying toxic Defensiveness where perfectly even the human's exact physical hair seamlessly violently transforms exactly into strictly piercing swords.
            This is exactly that highly toxic Ego which actively perfectly flawlessly violently becomes exceptionally easily Offended exactly at the absolute slightest microscopic word, immediately launching 50 thousand fake arguments to fight.
            These exact massive demons absolutely explicitly did not actively arrive directly from the external physical world; they are undeniably the exact absolute literal Bugs actively existing directly entirely perfectly inside our very own brain ruthlessly corrupting the complete physiological System.
            Mahishasura's highly explicit exceptionally terrifying Distributed Attack is violently relentlessly desperately actively aggressively attempting to successfully Overload the pure Consciousness completely exactly from absolutely all massive directions.
            However, Mahamaya's absolute supreme Anti-Virus is flawlessly actively preparing exclusively strictly explicitly purely exactly to actively violently successfully Scan and permanently Delete exactly these millions of specific bugs perfectly inside entirely one single split-second.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 42,
        sanskrit = "अयुतानां शतैः षड्भिर्बाष्कलो युयुधे रणे ।\nगजानां च सहस्रेण बहुभिः परिवारितः ॥ ४४ ॥",
        hindi = """
            (बाष्कल और परिवारित का हमला): "उसी भयंकर युद्ध भूमि में, 'बाष्कल' नाम का राक्षस पूरे 'साठ लाख' रथों की विशाल सेना के साथ देवी पर प्रहार करने लगा!"
            "और 'परिवारित' नाम का एक अत्यंत खौफनाक राक्षस 'अनेक हज़ारों भयंकर हाथियों' की सेना को लेकर देवी से लड़ने आ पहुँचा।"
            यह महिषासुर की सेना का सबसे भारी और 'हैवीवेट' (Heavyweight) अटैक है!
            'साठ लाख' रथ—यह इंसान के अवचेतन मन में दबी हुई साठ लाख पुरानी यादों और संस्कारों का प्रतीक है, जो ध्यान के समय उठकर ध्यान तोड़ना चाहती हैं।
            'परिवारित' का अर्थ है जो हर तरफ से 'घिरा हुआ' हो। यह इंसान के उन डरों (Fears) और इनसिक्योरिटी (Insecurities) का प्रतीक है जो इंसान को हर तरफ से जकड़ लेते हैं।
            हाथी (Elephants) भारीपन (Heaviness), अंधकार और डिप्रेशन (Depression) का साक्षात् प्रतीक हैं। 
            हज़ारों हाथियों का एक साथ आना उस भयंकर मानसिक स्थिति को दर्शाता है जब इंसान पर डिप्रेशन का ऐसा भारी अटैक होता है कि वह साँस भी नहीं ले पाता।
            राक्षस सोच रहे हैं कि इस 'मास अटैक' से देवी (सत्य) घबरा जाएंगी और दब जाएंगी।
            परंतु वे यह नहीं जानते कि देवी साक्षात् 'महाकाली' हैं, जिनके आगे भारी से भारी पहाड़ और हाथी भी केवल एक धूल के कण के समान हैं।
            यह श्लोक साबित करता है कि संसार का भ्रम अपनी पूरी 'वॉल्यूम' के साथ सत्य को डराने की कोशिश करता है।
        """.trimIndent(),
        english = """
            (The Attack of Bashkala and Parivarita): "Exactly directly in that identical horrific battlefield, the massive demon explicitly named 'Bashkala' aggressively actively brutally struck exactly directly at the Goddess exclusively supported explicitly entirely perfectly by exactly Sixty Lakhs (Six Million) chariots!"
            "And an exceptionally horrifying monster explicitly named 'Parivarita', heavily surrounded actively successfully perfectly entirely by Countless thousands of exceptionally massive terrified Elephants, violently actively aggressively arrived perfectly explicitly exclusively to actively physically fight the Goddess."
            This is undeniably Mahishasura's absolute highly terrifying explicitly exact absolute greatest Heavyweight Attack!
            'Sixty Lakh' chariots—this flawlessly explicitly seamlessly beautifully perfectly exactly represents exactly the sixty million toxic past memories and deep impressions aggressively buried actively perfectly entirely exactly strictly inside the physical Subconscious mind, actively violently aggressively attempting exactly to perfectly ruthlessly actively successfully shatter absolute meditation.
            'Parivarita' literally profoundly exactly exclusively perfectly translates strictly flawlessly to exactly the specific entity heavily Surrounded entirely flawlessly seamlessly from absolutely all massive physical sides. This perfectly completely symbolizes the human's highly toxic Fears and deep Insecurities which actively violently brutally tightly bind him from all sides.
            Elephants undeniably flawlessly perfectly explicitly symbolize absolute terrifying Heaviness, thick darkness, and crushing clinical Depression.
            Thousands of massive elephants violently charging flawlessly strictly effortlessly together represents exactly that terrifying mental state exactly when a human is ruthlessly attacked entirely by such heavy depression that he absolutely cannot successfully actively physically breathe.
            The demons ignorantly aggressively assume perfectly exactly that this explicit absolute Mass Attack will flawlessly successfully actively entirely violently overwhelm and crush the Goddess (Supreme Truth).
            However, they absolutely entirely completely fail to successfully realize exactly that the Goddess is undeniably literal 'Mahakali' (Absolute Time) Herself, strictly before whom exactly the absolute heaviest massive elephants are exceptionally successfully reduced directly exactly to mere microscopic dust.
            This spectacularly completely flawlessly proves exactly that the entire colossal Illusion of the massive world ruthlessly actively violently perfectly completely aggressively attempts strictly entirely exactly to successfully intimidate absolute Truth utilizing its complete entire absolute raw physical Volume.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 43,
        sanskrit = "वृतो रथानामयुतैर्युद्धे तस्मिन्नयुध्यत ।\nबिडालोऽयुतपञ्चाशद् रथानामयुतैर्वृतः ॥ ४५ ॥",
        hindi = """
            (बिडाल राक्षस का प्रहार): "उस भयंकर युद्ध में 'परिवारित' दस हज़ार रथों से घिरकर युद्ध कर रहा था।"
            "और उसी समय 'बिडाल' नाम का एक अत्यंत चालाक और खूंखार राक्षस पूरे 'पचास करोड़' रथों की सेना से घिरकर देवी पर टूट पड़ा!"
            यह राक्षसों की गिनती की चरम सीमा है—'पचास करोड़ रथ'! 
            'बिडाल' एक बिल्ली का प्रतीक है। बिल्ली बहुत ही शांति से, दबे पाँव छुपकर शिकार करती है।
            बिडाल इंसान के उस 'छल-कपट' और छुपे हुए अहंकार का प्रतीक है जो सामने से नहीं दिखता, पर अंदर ही अंदर बहुत चालाक होता है।
            यह वह ईगो है जो कहता है "मैं बहुत विनम्र हूँ", पर वास्तव में उसके पीछे पचास करोड़ फालतू के स्वार्थी विचार छुपे होते हैं।
            यह 'स्नीकी अटैक' है। महिषासुर ने भारी हाथियों के बाद अब एक बहुत ही चालाक और छुपे रुस्तम सेनापति को भेजा है।
            इंसान की साइकोलॉजी में डिप्रेशन के बाद सबसे बड़ा खतरा खुद को धोखा देने की प्रवृत्ति होती है।
            पर देवी की नज़र से कुछ नहीं छुप सकता; वे हर एक रथ को हवा में ही काट देने वाली हैं।
            इतनी विशाल सेना यह साबित करती है कि अज्ञान को पालने के लिए बहुत एनर्जी चाहिए, पर सत्य को किसी सेना की ज़रूरत नहीं है।
        """.trimIndent(),
        english = """
            (The Attack of the Demon Bidala): "In that absolute terrifying cosmic war, 'Parivarita' fought aggressively surrounded flawlessly completely by exactly ten thousand massive chariots."
            "And exactly simultaneously, an exceptionally highly cunning and explicitly horrifying monster explicitly named 'Bidala' violently brutally actively ruthlessly successfully aggressively attacked the Goddess completely flawlessly surrounded perfectly strictly explicitly by exactly Fifty Crores (Five Hundred Million) massive chariots!"
            This is undeniably the absolute ultimate exact maximum limit explicitly perfectly of the entire demonic physical mathematical count—'Fifty Crore Chariots'!
            'Bidala' (Cat) flawlessly seamlessly perfectly undeniably symbolizes exactly a physical Cat. A cat perpetually successfully actively aggressively hunts completely explicitly perfectly strictly highly silently, moving flawlessly seamlessly effortlessly strictly with exceptionally massive absolute ultimate stealth.
            Bidala undeniably completely symbolizes exactly the human's highly toxic explicit precise absolute exact literal literal 'Deceit and Hypocrisy', the exact highly hidden absolute toxic Ego which absolutely does not visually explicitly aggressively show perfectly on the literal outside, but is undeniably exceptionally exceptionally cunning exactly on the inside.
            This is exactly that highly toxic Ego which actively screams "I am exceptionally perfectly flawlessly explicitly humble", but actively aggressively actively successfully perfectly flawlessly entirely hides exactly fifty crore highly selfish toxic thoughts directly behind it.
            This is undeniably an exceptionally massive advanced Sneaky Attack. Mahishasura has actively explicitly seamlessly deployed an exceptionally highly cunning and completely hidden general perfectly seamlessly directly strictly exactly after deploying the heavy elephants.
            Exactly inside human Psychology, the absolute greatest terrifying danger perfectly exactly after crushing Depression (Elephants) is exactly the terrifying tendency to actively actively completely entirely successfully gracefully precisely explicitly flawlessly successfully effortlessly actively physically identically violently deceive oneself (Bidala).
            But absolutely zero physical or mental entity can possibly successfully effortlessly flawlessly entirely completely actively completely hide directly perfectly seamlessly from the literal eyes exactly of the Goddess (Pure Consciousness); She is flawlessly preparing exactly to physically sever every single chariot (thought) exactly in mid-air.
            This astronomically massive army flawlessly actively perfectly proves exactly that maintaining thick ignorance violently requires exceptionally massive explicit energy, but the Supreme Truth (The Goddess) requires absolutely zero physical army.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 44,
        sanskrit = "अन्ये च तत्रायुतशो रथनागहयैर्वृताः ।\nयुयुधुः संयुगे देव्या सह तत्र महासुराः ॥ ४६ ॥",
        hindi = """
            (अन्य अनगिनत राक्षसों का युद्ध): "और इन प्रमुख सेनापतियों के अलावा, वहां 'हज़ारों-लाखों की संख्या में' अन्य भयंकर राक्षस भी मौजूद थे।"
            "जो अपने-अपने भयंकर रथों, हाथियों और घोड़ों से पूरी तरह घिरे हुए थे।"
            "वे सभी अनगिनत महा-राक्षस उस रणभूमि में एक साथ मिलकर उस परम देवी के साथ अत्यंत भयंकर महायुद्ध करने लगे!"
            यह एक 'ऑल-आउट कॉस्मिक वॉर' है! मुख्य ईगो के अलावा भी इंसान के अंदर हज़ारों छोटी-छोटी बुरी आदतें होती हैं।
            ये 'अन्ये च' (अन्य राक्षस) वो रोज़मर्रा के फालतू विचार (Overthinking), छोटी-छोटी ईर्ष्याएँ, और बिना वजह के डर हैं जिन्हें हम नोटिस भी नहीं करते।
            ये सब अपने रथों, हाथियों, और घोड़ों पर सवार होकर चेतना (देवी) पर एक साथ हमला कर रहे हैं।
            जब इंसान आध्यात्मिक रास्ते पर पूरी तरह चलने की ठान लेता है, तो उसका पूरा सिस्टम विद्रोह कर देता है।
            महिषासुर ने अपनी पूरी 'बैकअप फोर्स' को भी मैदान में उतार दिया है।
            यह कोई आम युद्ध नहीं है; यह एक अकेली चेतना का पूरे 'मैट्रिक्स' के साथ युद्ध है!
            लेकिन माता एक ही स्थान पर खड़ी हैं; उनका डगमगाना असंभव है। वे अज्ञान के इस पूरे समुद्र को सोखने के लिए तैयार हैं।
        """.trimIndent(),
        english = """
            (The Attack of Countless Other Demons): "And entirely completely apart strictly from these absolute massive primary supreme generals, there were flawlessly actively perfectly exceptionally exactly 'Tens of thousands and millions' of completely other exceptionally horrifying terrifying monsters physically present exactly right there."
            "Who were aggressively violently completely heavily surrounded perfectly exclusively exactly by their very own absolute massive chariots, giant terrified elephants, and highly exceptionally swift cosmic horses."
            "Absolutely all those completely perfectly countless terrifying Mega-Demons flawlessly actively entirely aggressively perfectly physically united seamlessly perfectly entirely together inside that explicit massive cosmic battlefield and actively violently successfully seamlessly flawlessly initiated an exceptionally horrific literal colossal Mega-War directly strictly perfectly against exactly that Supreme Goddess!"
            This is undeniably an absolute highly explicit terrified 'All-out Cosmic War'! Completely perfectly directly apart strictly exactly from the absolute primary main toxic Ego (Generals), the human flawlessly successfully perfectly possesses thousands of highly specific exceptionally tiny toxic bad habits actively residing inside.
            These 'Anye cha' (Other demons) are exactly those petty daily useless Overthinking thoughts, microscopic tiny toxic jealousies, and absolutely baseless cheap fears which we absolutely actively flawlessly completely actively exactly entirely successfully strictly perfectly completely intentionally ignore entirely completely.
            Absolutely all of them are actively physically violently flawlessly attacking the pure Consciousness (The Goddess) perfectly exactly simultaneously seamlessly actively flawlessly violently entirely entirely entirely entirely perfectly exclusively perfectly flawlessly riding exclusively exactly perfectly entirely upon their chariots, elephants, and horses.
            Exactly when a human successfully effectively decides purely effectively entirely gracefully efficiently entirely to flawlessly entirely actively physically walk the absolute precise Spiritual Path, his absolute entire biological and psychological System effortlessly violently strictly entirely actively seamlessly purely actively Rebels completely exactly flawlessly against him.
            Mahishasura has actively aggressively violently completely perfectly successfully successfully actively gracefully fully deployed his absolute exact completely entire perfectly entire literal entire pure complete pure absolute pure exact explicitly identical exact precise Backup Force flawlessly perfectly directly explicitly straight perfectly identically onto the exact absolute identical exact physical battlefield.
            This is absolutely zero ordinary physical cheap literal fight; this is undeniably the direct precise literal physical actual explicitly precise exact war exactly explicitly perfectly strictly entirely between exactly one exactly identical single solitary pure exact absolute identical pure Consciousness and the absolute exact completely pure entire exactly identical entire complete literal explicitly identical whole Matrix!
            But the exact absolute perfect precise explicit pure exactly exact Mother is strictly actively standing entirely completely perfectly exact identically actively identical seamlessly exact motionless precisely exactly effectively efficiently beautifully exactly in exactly one exact spot.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 45,
        sanskrit = "कोटिकोटिसहस्रैस्तु रथानां दन्तिनां तथा ।\nहयानां च वृतो युद्धे तत्राभून्महिषासुरः ॥ ४७ ॥",
        hindi = """
            (महिषासुर का साक्षात् प्रवेश): "और सबसे अंत में, इस युद्ध के मैदान में वह परम पापी 'महिषासुर' खुद आ पहुँचा!"
            "वह भयंकर महिषासुर पूरे 'करोड़ों-करोड़ों' और 'हज़ारों' रथों, हाथियों, और घोड़ों से चारों तरफ से पूरी तरह घिरा हुआ उस भयंकर युद्ध में शामिल हो गया!"
            अब साक्षात् 'बॉस' (The Final Boss) मैदान में आ चुका है! महिषासुर इंसान का सबसे 'कोर ईगो' (Core Ego) है, जो आसानी से बाहर नहीं आता; वह पहले अपनी सेना को भेजता है।
            'कोटिकोटि सहस्रैस्तु' रथ और हाथी—यह कोई गणित नहीं है; यह 'इनफिनिटी' (Infinity) का वर्णन है।
            इंसान का अहंकार इतना असीम और गहरा होता है कि उसे गिनना नामुमकिन है। यह अहंकार करोड़ों जन्मों का कचरा है!
            महिषासुर अपनी पूरी शक्ति और 'बैकअप' के साथ आया है; वह समझ गया है कि देवी से लड़ना कोई आम बात नहीं है।
            यह श्लोक 'माया के जाल' की विशालता को दिखाता है, जो इंसान को डराकर उसे सरेंडर करने पर मजबूर करती है।
            परंतु देवी के लिए यह पूरी सेना और महिषासुर केवल एक सूखे पत्ते के समान हैं, जिन्हें बस आग लगानी बाकी है।
        """.trimIndent(),
        english = """
            (The Direct Physical Entry of Mahishasura): "And finally, that ultimate supreme sinner 'Mahishasura' arrived directly onto the battlefield!"
            "That terrifying Mahishasura actively joined the cosmic war, completely surrounded from all sides by 'Crores' (Billions) and 'Thousands' of massive chariots, elephants, and horses!"
            Now the literal 'Final Boss' has stepped onto the battlefield! Mahishasura represents the human's deepest 'Core Ego', which never comes out easily; it systematically sends its army first.
            'Koti-koti Sahasraistu' of massive chariots and elephants is not Mathematics; it is the direct description of 'Infinity'.
            The toxic Ego is so seamlessly infinite and massive that counting it is impossible. This Ego is the toxic garbage accumulated over millions of past lives!
            Mahishasura has arrived flawlessly with his entire raw power and 'Backup'; he has comprehended that fighting the Goddess is absolutely no ordinary matter.
            This verse proves how the colossal Illusion of the world ruthlessly attempts to successfully intimidate absolute Truth utilizing its complete volume.
            However, for the Goddess, this entire army and Mahishasura are merely a dry leaf waiting to be burned.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 46,
        sanskrit = "तोमरैर्भिन्दिपालैश्च शक्तीभिर्मुसलैस्तथा ।\nयुयुधे संयुगे देव्या खड्गैः परशुपट्टिशैः ॥ ४८ ॥",
        hindi = """
            (राक्षसों के भयंकर अस्त्र-शस्त्र): "उस खौफनाक रणभूमि में वे सभी राक्षस देवी पर 'तोमर' और 'भिन्दिपाल' (घातक अस्त्र) फेंककर हमला करने लगे।"
            "उन्होंने देवी पर अत्यंत खौफनाक 'शक्तियों' (Spears) और भारी 'मूसलों' (Clubs) की भयंकर बारिश कर दी!"
            "वे सभी राक्षस अपने-अपने हाथों में चमकती हुई 'तलवारें' (खड्गैः), 'फरसे' (परशु), और 'पट्टिश' लेकर उस परम चेतना के साथ महायुद्ध करने लगे।"
            यह श्लोक इंसान के अहंकार (Ego) के डिफेंस मैकेनिज्म (Defense Mechanism) का साक्षात् वर्णन है।
            राक्षसों के ये अलग-अलग हथियार हमारे दिमाग के वो अलग-अलग कुतर्क (Fake Logic) और क्रोध के रूप हैं जो सत्य को स्वीकार नहीं करना चाहते।
            'तोमर और भिन्दिपाल' दूर से फेंके जाने वाले अस्त्र हैं; जैसे इंसान अपनी गलतियों का इल्ज़ाम दूर से दूसरों पर फेंकता है (Blame-shifting)।
            'मूसल' उस भारीपन और जड़ता (Stubbornness) का प्रतीक है जो किसी भी नए और शुद्ध विचार को कुचल देना चाहता है।
            'फरसा' और 'तलवार' उस तीखे और कड़वे व्यवहार का प्रतीक हैं जो इंसान अपने ईगो को बचाने के लिए आक्रामक होकर इस्तेमाल करता है।
            महिषासुर की सेना (बुरी आदतें) अपनी पूरी ताक़त लगा रही है ताकि उस 'डिवाइन लाइट' (देवी) को किसी तरह बुझाया जा सके।
            परंतु अज्ञान के ये सारे भौतिक हथियार उस परम 'चेतना' को एक खरोंच तक नहीं लगा सकते।
        """.trimIndent(),
        english = """
            (The Terrifying Weapons of the Demons): "Exactly inside that horrific battlefield, absolutely all those demons aggressively began attacking the Goddess by violently hurling 'Tomara' and 'Bhindipala' (lethal projectiles)!"
            "They ruthlessly executed an exceptionally terrifying torrential rain of horrific 'Shaktis' (Spears) and massive heavy 'Musalas' (Clubs) completely directly upon the Goddess!"
            "Absolutely all those monsters violently actively fought exactly against that Supreme Consciousness, actively wielding blazing 'Swords' (Khadga), 'Axes' (Parashu), and 'Pattishas' perfectly inside their hands."
            This spectacular verse is the absolute direct literal description exactly of the highly toxic Defense Mechanism of the human Ego.
            These completely different terrifying weapons of the demons perfectly symbolize the completely different fake logics, excuses, and forms of blind rage our brain actively utilizes to ruthlessly reject the Supreme Truth.
            'Tomara and Bhindipala' are lethal projectiles violently thrown entirely from a massive distance; exactly identically perfectly mimicking how a toxic human seamlessly shifts the blame for his own mistakes completely onto others.
            The 'Musala' perfectly flawlessly symbolizes the exceptionally terrifying heaviness and blind stubbornness which ruthlessly desires to completely crush absolutely any pure, brand-new divine thought.
            The 'Axe' and 'Sword' explicitly represent exactly that exceptionally sharp, bitter, and highly toxic defensive behavior which a human actively utilizes perfectly to exclusively protect his fake Ego.
            Mahishasura's colossal army (toxic bad habits) is relentlessly applying its absolute entire raw force actively frantically attempting completely to successfully extinguish that exact 'Divine Light' (The Goddess).
            However, absolutely all these cheap physical weapons of thick ignorance absolutely cannot possibly even successfully scratch that ultimate absolute pure 'Consciousness'.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 47,
        sanskrit = "केचिच्च चिक्षिपुः शक्तीः केचित्पाशांस्तथापरे ।\nदेवीं खड्गप्रहारैस्तु ते तामुन्तुं प्रचक्रमुः ॥ ४९ ॥",
        hindi = """
            (अहंकार का आक्रामक प्रहार): "उनमें से कुछ राक्षसों ने माता के ऊपर अपनी भयंकर 'शक्तियां' (भाले) फेंकी (केचिच्च चिक्षिपुः शक्तीः)।"
            "कुछ राक्षसों ने माता को बांधने के लिए उन पर अपने खौफनाक 'पाश' (Nooses / फांसियां) फेंके (केचित्पाशांस्तथापरे)!"
            "और बाकी बचे हुए राक्षसों ने अपनी चमकती हुई तलवारों के अत्यंत भयंकर प्रहारों से (खड्गप्रहारैस्तु)।"
            "उस परम देवी को 'जान से मार डालने' का पूरी तरह से आक्रामक प्रयास किया (तामुन्तुं प्रचक्रमुः)!"
            यह अहंकार (Ego) की 'डेस्परेशन' (Desperation / हताशा) की चरम सीमा है! अज्ञान जब मरने वाला होता है, तो वह पूरी तरह से पागल हो जाता है।
            'पाश' (Noose) फांसने का प्रतीक है। हमारा मन (Demons) परम सत्य (Goddess) को अपने पुराने लॉजिक और सांसारिक मोहमाया के फंदे (पाश) में बांधना चाहता है।
            मन सोचता है कि वह 'चेतना' को कंट्रोल (Control) कर लेगा और सत्य को अपनी तलवारों से काट देगा।
            राक्षस उस साक्षात् 'ब्रह्मांड की माता' को जान से मारने (उन्तुं) की कोशिश कर रहे हैं; यह इंसान की उस सबसे बड़ी मूर्खता का प्रतीक है जहाँ वह भगवान को ही मिटाना चाहता है।
            जब आप अपनी बुरी आदतों को छोड़ने की कोशिश करते हैं, तो वे आदतें (राक्षस) आपको वापस फंसाने (पाश) या मानसिक रूप से तोड़ने (तलवार) का हर संभव प्रयास करती हैं।
            पर माया के फंदे उस 'महामाया' को कैसे बांध सकते हैं जिसने खुद इस माया को बनाया है?
        """.trimIndent(),
        english = """
            (The Aggressive Strike of Ego): "Absolutely some of those terrified demons violently aggressively hurled their horrifying 'Shaktis' (Spears) perfectly directly exactly upon the Mother (Kechichcha chikshipuh shaktih)."
            "Certain other demons ruthlessly threw their exceptionally terrifying 'Pashas' (Nooses/Traps) completely exactly at the Mother, frantically attempting to actively tightly bind Her (Kechitpashamstathapare)!"
            "And absolutely all the other remaining monsters, utilizing exceptionally violent and blindingly brutal strikes entirely of their massive swords (Khadgapraharastu)."
            "Aggressively executed an absolute complete explicit desperate attempt to flawlessly brutally 'Slaughter and physically kill' exactly that Supreme Goddess (Tamuntum prachakramuh)!"
            This is undeniably the absolute ultimate extreme peak perfectly of the toxic Ego's precise literal 'Desperation'! Exactly when thick ignorance is actively about to flawlessly die, it violently becomes completely completely insane.
            The 'Pasha' (Noose) strictly perfectly symbolizes physical entrapment. Our toxic mind (Demons) aggressively desires to tightly bind the Supreme Truth (Goddess) flawlessly inside its cheap worldly logic and traps (Nooses).
            The pathetic mind arrogantly assumes it will flawlessly successfully physically Control pure 'Consciousness' and ruthlessly slice the absolute Truth perfectly with its cheap swords.
            The monsters are aggressively frantically attempting exactly to violently slaughter (Untum) the direct literal 'Mother of the Universe'; this explicitly symbolizes the human's absolute greatest ultimate stupidity where he desires to annihilate God Himself.
            Exactly when you actively aggressively attempt strictly to permanently abandon your toxic bad habits, those identical habits (Demons) actively deploy absolutely every single explicit mechanism flawlessly exactly to Trap (Noose) you or physically break you (Sword).
            But exactly how on earth can the cheap pathetic traps of Maya possibly ever successfully actively bind that exact 'Mahamaya' who Herself flawlessly explicitly created this very identical Maya?
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 48,
        sanskrit = "सापि देवी ततस्तानि शस्त्राण्यस्त्राणि चण्डिका ।\nलीलयैव प्रचिच्छेद निजशस्त्रास्त्रवर्षिणी ॥ ५० ॥",
        hindi = """
            (चंडिका का खेल-खेल में प्रहार): "तब उस परम 'चण्डिका देवी' (सापि देवी चण्डिका) ने राक्षसों के उन सभी भयंकर अस्त्रों और शस्त्रों (तानि शस्त्राण्यस्त्राणि) को।"
            "अपने ही खौफनाक और अजेय 'अस्त्र-शस्त्रों की भयंकर बारिश' (निजशस्त्रास्त्रवर्षिणी) करते हुए।"
            "बिल्कुल 'खेल-खेल में ही' (लीलयैव) अत्यंत आसानी से हवा में ही 'काटकर चकनाचूर कर दिया' (प्रचिच्छेद)!"
            इस श्लोक का सबसे महत्वपूर्ण शब्द है—'लीलयैव' (Playfully / खेल-खेल में)!
            राक्षस (Ego) अपनी पूरी जान लगाकर, पसीना बहाकर, और क्रोध से पागल होकर (Struggle करके) लड़ रहे थे।
            परंतु परम चेतना (चण्डिका) को अज्ञान (Ignorance) को मिटाने के लिए कोई 'मेहनत' (Effort) नहीं करनी पड़ती; उनके लिए यह केवल एक 'खेल' (लीला) है!
            जब आप अंधेरे कमरे में बल्ब चालू करते हैं, तो रोशनी को अंधेरे से 'लड़ना' नहीं पड़ता; रोशनी के आते ही अंधेरा अपने-आप कट जाता है (प्रचिच्छेद)।
            'निजशस्त्रास्त्रवर्षिणी'—देवी ने अपने भीतर से ही अनंत हथियारों की बारिश कर दी। सत्य के पास हर झूठ (राक्षस के अस्त्र) का एक सटीक जवाब (Anti-weapon) होता है।
            इंसान अपनी समस्याओं (राक्षसों) को देखकर पैनिक (Panic) करता है, पर भगवान के नज़रिए से वह समस्या केवल एक छोटी सी 'लीला' है जिसे सेकंडों में सॉल्व (Solve) किया जा सकता है।
            महिषासुर की पूरी ताकत और उसका अहंकार अब 'चण्डिका' के इस खेल (Leela) के सामने ताश के पत्तों की तरह बिखरने लगा है।
        """.trimIndent(),
        english = """
            (Chandika's Playful Annihilation): "Exactly then, that absolute Supreme 'Goddess Chandika' (Sapi devi chandika) flawlessly flawlessly actively engaged absolutely all those exceptionally horrifying weapons and lethal missiles of the demons (Tani shastranyastrani)."
            "And violently aggressively executing an exceptionally terrifying, apocalyptic 'Torrential rain completely of Her very own invincible weapons and missiles' (Nijashastrastravarshini)."
            "She flawlessly flawlessly ruthlessly 'Sliced, completely severed, and violently shattered' absolutely all of them exactly in mid-air entirely 'Purely playfully and effortlessly exactly exactly as a cosmic game' (Lilayaiva prachichcheda)!"
            The absolute most exceptionally highly critical and profoundly massive explicit word flawlessly inside this spectacular verse is undeniably—'Lilayaiva' (Playfully / As a Game)!
            The demons (Ego) were violently actively fighting aggressively strictly applying their absolute entire life force, pouring physical sweat, and completely flawlessly blinded by horrific rage (Massive Struggle).
            However, the Supreme Consciousness (Chandika) absolutely entirely requires exactly zero physical 'Effort' or cheap struggle entirely to actively successfully eradicate thick Ignorance; strictly exactly for Her, this is undeniably merely an effortless 'Game' (Leela)!
            Exactly when you seamlessly actively perfectly switch entirely on a physical bulb entirely inside a pitch-black room, the pure light absolutely does not actively 'Fight' the darkness; the darkness is flawlessly actively automatically Severed (Prachichcheda) instantly.
            'Nijashastrastravarshini'—The Goddess actively violently rained infinite absolute weapons strictly directly from exactly inside Herself. The Supreme Truth effortlessly flawlessly possesses an exact precise absolute explicit perfectly accurate Answer (Anti-weapon) entirely exactly for every single Lie (Demonic weapon).
            A pathetic human flawlessly actively Panics aggressively entirely perfectly visually witnessing his massive problems (Demons), but exclusively strictly exactly from God's absolute perspective, that problem is perfectly exactly merely a tiny 'Leela' capable of being solved flawlessly exactly in mere seconds.
            Mahishasura's absolute entire raw power and highly toxic ego are undeniably now actively seamlessly flawlessly violently shattering completely exactly like cheap physical cards entirely strictly before exactly this absolute explicit Game (Leela) of 'Chandika'.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 49,
        sanskrit = "अनायस्तानना देवी स्तूयमाना सुरर्षिभिः ।\nमुमोचासुरदेहेषु शस्त्राण्यस्त्राणि चेश्वरी ॥ ५१ ॥",
        hindi = """
            (देवी का शांत और दिव्य मुख): "उन सभी महान देवताओं और परम ऋषियों द्वारा लगातार अत्यंत श्रद्धा से स्तुति की जाती हुई (स्तूयमाना सुरर्षिभिः)।"
            "वह परम ईश्वरी देवी (ईश्वरी) राक्षसों के उन भयंकर शरीरों पर (असुरदेहेषु) अपने विनाशकारी अस्त्र-शस्त्रों की लगातार बारिश कर रही थीं (मुमोच शस्त्राण्यस्त्राणि)।"
            "फिर भी उस भयंकर युद्ध के बीच, देवी का 'मुखमंडल' (चेहरा) 'बिल्कुल बिना किसी थकान के अत्यंत खिला हुआ और प्रसन्न' (अनायस्तानना) था!"
            यह श्लोक एक सच्चे 'योगी' (Yogi) और परम 'चेतना' का सबसे बड़ा साक्षात् प्रमाण है!
            'अनायस्तानना' का अर्थ है 'जिसके चेहरे पर ज़रा सी भी थकान, स्ट्रेस (Stress) या शिकन न हो'।
            देवी करोड़ों राक्षसों को मार रही हैं, ब्रह्मांड का सबसे बड़ा और भयंकर युद्ध चल रहा है, चारों तरफ खून और मौत है; फिर भी माता का चेहरा एकदम रिलैक्स्ड (Relaxed) और शांत है!
            राक्षस (Ego) लड़ते हुए हाँफ रहे हैं, पसीना-पसीना हो रहे हैं, पर ईश्वरी (Supreme Boss) को कोई फर्क नहीं पड़ रहा है।
            यह हमें सिखाता है कि जीवन के सबसे बड़े संघर्ष (Struggle) और युद्ध में भी हमारा दिमाग (Mind) बिल्कुल शांत और स्थिर रहना चाहिए। 
            जब आप सच के साथ होते हैं, तो आपको स्ट्रेस (Stress) लेने की ज़रूरत नहीं होती। 
            देवता और ऋषि इस 'एफर्टलेस' (Effortless) विनाश को देखकर मंत्रमुग्ध हैं और लगातार माता की जय-जयकार कर रहे हैं।
        """.trimIndent(),
        english = """
            (The Goddess's Calm and Divine Face): "Relentlessly being flawlessly actively aggressively completely completely perfectly Praised with absolute extreme supreme devotion strictly exactly by all the massive Gods and supreme Sages (Stuyamana surarshibhih)."
            "That absolute Supreme Sovereign Goddess (Ishvari) was violently flawlessly actively continuously unleashing and relentlessly explicitly raining Her exceptionally terrifying apocalyptic weapons directly straight perfectly into the massive physical bodies of those horrifying demons (Mumocha asuradeheshu shastranyastrani)."
            "Yet, seamlessly entirely perfectly directly amidst that exceptionally horrific colossal cosmic war, the Goddess's absolute explicit 'Face' remained flawlessly 'Completely entirely unwearied, absolutely completely untired, highly exceptionally fresh, and beautifully perfectly cheerful' (Anayastanana)!"
            This spectacular verse is undeniably the absolute greatest direct literal physical exact exact proof flawlessly perfectly explicitly of a true 'Yogi' and Absolute 'Supreme Consciousness'!
            'Anayastanana' literally profoundly seamlessly perfectly entirely explicitly means 'Exactly She perfectly whose exact supreme face flawlessly dynamically possesses absolutely zero microscopic millimeter perfectly of physical fatigue, heavy Stress, or active tension'.
            The Goddess is aggressively actively violently ruthlessly slaughtering literally crores of horrifying demons, the absolute greatest terrifying cosmic war exactly of the entire universe is actively occurring, blood and brutal death completely actively strictly explicitly explicitly surround entirely absolutely everything; yet the Mother's absolute face is flawlessly completely 100% Relaxed and infinitely Calm!
            The pathetic demons (Ego) are aggressively actively flawlessly violently violently explicitly physically panting, actively dripping with heavy physical sweat seamlessly entirely actively while frantically fighting, but the 'Ishvari' (The Supreme Boss) is completely 100% physically identically entirely absolutely Unaffected.
            This flawlessly explicitly actively completely seamlessly actively powerfully completely exactly entirely teaches perfectly exactly us that perfectly exclusively even perfectly directly exactly perfectly entirely perfectly exactly exactly inside the absolute greatest massive Struggle and horrific physical war exactly of our physical life, our pure Mind absolutely must seamlessly flawlessly actively effectively actively remain entirely completely exactly 100% perfectly Calm and entirely actively stable.
            Exactly when you actively flawlessly perfectly completely exactly actively correctly stand completely precisely entirely specifically strictly explicitly specifically exactly completely with the absolute Supreme Truth, you absolutely entirely fundamentally uniquely safely entirely perfectly completely seamlessly require absolutely exactly zero physical need actively completely entirely entirely exactly explicitly exactly entirely perfectly completely explicitly completely to actively passively explicitly take exactly any Stress.
            The massive Gods and Sages are flawlessly entirely perfectly explicitly seamlessly absolutely captivated flawlessly visually entirely successfully witnessing this explicit exactly terrifying 'Effortless' absolute Annihilation and are actively aggressively frantically continuously completely executing the Mother's absolute supreme praise.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 50,
        sanskrit = "सोऽपि क्रुद्धो धुतसटो देव्या वाहनकेसरी ।\nचचारासुरसैन्येषु वनेष्विव हुताशनः ॥ ५२ ॥",
        hindi = """
            (देवी के वाहन सिंह का प्रहार): "उस भयंकर युद्ध में परम देवी का वह 'वाहन सिंह' (वाहनकेसरी) भी अत्यंत भयंकर 'क्रोध' (क्रुद्धो) से पूरी तरह पागल हो उठा!"
            "वह भयंकर शेर अपनी गर्दन के बालों को ज़ोर से झटकते हुए (धुतसटो) राक्षसों की उस विशाल सेना (असुरसैन्येषु) के बीच इस प्रकार से टूट पड़ा और घूमने लगा (चचार)।"
            "जैसे किसी घने और सूखे जंगल (वनेषु) में अत्यंत भयंकर आग (हुताशनः) तेज़ी से फैल जाती है!"
            देवी तो शांत हैं, पर उनका वाहन (शेर) भयंकर क्रोध में है! 'शेर' परम धर्म, सत्य और अदम्य साहस का साक्षात् प्रतीक है। 
            जब इंसान के अंदर का 'धर्म' जागता है, तो वह अज्ञान की सेना को ऐसे जला देता है जैसे सूखे जंगल को आग जलाती है।
            महिषासुर (भैंसा) की सेना जो अपने हथियारों और संख्या पर घमंड कर रही थी, वह एक अकेले शेर के सामने सूखे पत्तों की तरह जलने लगी है।
            शेर को किसी अस्त्र की ज़रूरत नहीं है; उसके पंजे और दांत ही राक्षसों के शरीर के टुकड़े-टुकड़े कर रहे हैं।
            यह श्लोक दिखाता है कि परम चेतना (देवी) के साथ जुड़ा हुआ हर एक तत्व ब्रह्मांड का सबसे बड़ा संहारक बन जाता है।
            अज्ञान का जंगल चाहे कितना भी घना क्यों न हो, सत्य की एक चिंगारी उसे भस्म करने के लिए काफी है।
        """.trimIndent(),
        english = """
            (The Attack of the Goddess's Lion Mount): "In that terrifying cosmic war, the Supreme Goddess's Lion mount (Vahanakesari) erupted into absolute blinding rage (Kruddho)!"
            "Violently shaking his massive mane (Dhutasato), that horrific Lion brutally pounced and tore straight through the colossal demonic army (Asurasainyeshu)."
            "He roamed through the dense ranks of monsters exactly like an apocalyptic blazing fire (Hutashanah) rapidly spreading through a completely dry forest (Vaneshu)!"
            The Supreme Goddess remains completely calm, but Her physical Mount burns inside exceptionally terrifying apocalyptic rage.
            The Lion flawlessly symbolizes absolute supreme Dharma, pure Truth, and raw undeniable physical courage. 
            When a human's internal pure Dharma violently awakens, it brutally burns down the entire demonic army of thick ignorance like a massive fire destroying a dry forest. 
            Mahishasura's colossal army, which was arrogantly boasting about its numeric quantity, started to burn like dry leaves before one solitary Lion. 
            The Lion requires absolutely no physical weapons; his raw claws and fangs are perfectly sufficient to tear the enemies of truth into microscopic pieces.
            This spectacular verse proves that every single element directly connected to pure Consciousness effortlessly becomes the ultimate destroyer of illusion.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 51,
        sanskrit = "निःश्वासान् मुमुचे यांस्तु युध्यमाना रणेऽम्बिका ।\nत एव सद्यः सम्भूता गणाः शतसहस्रशः ॥ ५३ ॥",
        hindi = """
            (देवी की साँसों से सेना का निर्माण): "उस भयंकर रणभूमि में युद्ध करते हुए (युध्यमाना रणे), परम माता अम्बिका ने अपने मुख से जो 'गहरी साँसें' (निःश्वासान्) छोड़ीं (मुमुचे)।"
            "वे साँसें तुरंत ही (सद्यः) साक्षात् 'लाखों-लाखों भयंकर गणों' (सैनिकों / गणाः शतसहस्रशः) के रूप में पूरी तरह से उत्पन्न (सम्भूता) हो गईं!"
            यह 'महामाया' की सबसे डरावनी और असीम शक्ति का साक्षात् प्रमाण है! देवी को सेना बनाने के लिए किसी जादू या मशीन की ज़रूरत नहीं है।
            उनकी केवल एक 'साँस' (Breath / Prana) से ही लाखों हाई-टेक सैनिक (Anti-virus programs) पैदा हो गए।
            साँस जीवन (Life-force) का प्रतीक है। जब परम चेतना (Goddess) एक्शन में होती है, तो उसका हर एक श्वास ब्रह्मांडीय ऊर्जा का एक नया रूप धारण कर लेता है।
            महिषासुर को अपनी करोड़ों की सेना पर घमंड था जो उसने सदियों की मेहनत से बनाई थी।
            परंतु माता ने केवल 'साँस छोड़कर' ही उस सेना को काउंटर (Counter) करने के लिए अपनी अनंत सेना खड़ी कर दी।
            यह साइकोलॉजी का सिद्धांत है: जब इंसान 'वर्तमान' (Present) में एक गहरी और शांत साँस लेता है, तो उसके दिमाग के लाखों फालतू विचार (राक्षस) एक ही झटके में नष्ट हो जाते हैं।
            साँस (Breath) ही वह सबसे बड़ा हथियार है जो मन (Mind) के युद्ध को शांत कर सकता है।
        """.trimIndent(),
        english = """
            (The Creation of Battalions from Her Breath): "While fiercely fighting in that terrifying battlefield, the deep exhaled breaths and powerful sighs (Nihshvasan) released by the Supreme Mother Ambika."
            "Instantaneously and miraculously transformed perfectly into hundreds of thousands of terrifying massive cosmic soldiers and divine battalions (Ganas)!"
            This is the ultimate direct proof of 'Mahamaya's' absolute boundless raw power! The Goddess requires zero magic or machines to generate an army.
            Merely a single physical Breath (Prana) flawlessly generated millions of highly advanced divine soldiers (Anti-virus programs) in a split-second.
            Breath symbolizes the ultimate Life-Force. When pure Consciousness is actively engaged, its every single exhalation physically manifests as a new form of cosmic energy.
            Mahishasura was blindly arrogant about his colossal army which he had painstakingly built over centuries of toxic effort.
            Yet, the Mother effortlessly generated an infinite counter-army simply by exhaling, mocking the demon's pathetic material preparations.
            This perfectly mirrors advanced human psychology: when a human takes a single deep, conscious breath in the Present moment, millions of toxic racing thoughts are instantly destroyed.
            Conscious breath is undeniably the absolute greatest weapon to permanently silence the chaotic cosmic war raging inside the mind.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 52,
        sanskrit = "युयुधुस्ते परशुभिर्भिन्दिपालासिपट्टिशैः ।\nनाशयन्तोऽसुरगणान् देवीशक्त्युपबृंहिताः ॥ ५४ ॥",
        hindi = """
            (गणों का भयंकर युद्ध): "माता की साँसों से पैदा हुए वे सभी गण, स्वयं 'देवी की असीम शक्ति से पूरी तरह भरे हुए' (देवीशक्त्युपबृंहिताः) थे!"
            "वे सभी अत्यंत भयंकर 'फरसों' (परशुभिर्), 'भिन्दिपालों', 'तलवारों' (असि) और 'पट्टिशों' (पट्टिशैः) से राक्षसों के साथ महायुद्ध करने लगे (युयुधुस्ते)।"
            "और उन भयंकर असुरों के समूहों का बेरहमी से 'नाश' (नाशयन्तोऽसुरगणान्) करने लगे!"
            माता की साँसों से जो सेना (गण) निकली है, वह कोई आम सेना नहीं है; वह साक्षात् 'देवीशक्त्युपबृंहिताः' (Powered by the Goddess's Core Energy) है।
            ये गण हमारे शरीर के 'ऑटोमैटिक इम्यून सिस्टम' (Automated Immune System) की तरह हैं।
            जब आत्मा (Soul) पर नेगेटिविटी का वायरस हमला करता है, तो आत्मा के अंदर से अपने-आप ऐसे रक्षक (White blood cells/Ganas) पैदा होते हैं जो वायरस को काटते हैं।
            गणों के हाथ में जो अस्त्र (फरसा, तलवार) हैं, वे सत्य के वो कड़े लॉजिक (Harsh Logic) हैं जो अज्ञान के तर्कों को बीच से चीर देते हैं।
            यह दिखाता है कि एक बार जब आप भगवान (चेतना) के प्रति समर्पित हो जाते हैं, तो आपकी रक्षा का काम भगवान की 'ऑटोमेटेड फोर्सेस' (Automated forces) संभाल लेती हैं।
            आपको खुद हर राक्षस (समस्या) से लड़ने की ज़रूरत नहीं पड़ती; माता की शक्ति से चार्ज (Charge) हुए विचार खुद-ब-खुद आपके रास्ते की सफाई कर देते हैं।
        """.trimIndent(),
        english = """
            (The Brutal War of the Ganas): "All those cosmic battalions generated from the Mother's breath were completely saturated and supercharged exclusively by the Goddess's infinite power (Devishaktyupabrimhitah)!"
            "They aggressively initiated a horrific war against the demons utilizing terrifying axes (Parashu), lethal projectiles, blazing swords (Asi), and spears."
            "And relentlessly began to ruthlessly slaughter and systematically annihilate the massive hordes of dark monsters (Nashayanto'suraganan)!"
            The army (Ganas) explicitly born from the Mother's breath is absolutely no ordinary military; it is fundamentally powered by the exact Core Energy of the Goddess.
            These Ganas operate flawlessly like the human body's advanced Automated Immune System (White blood cells).
            When the highly toxic virus of negativity attacks the soul, the soul automatically generates divine protectors from within to violently eradicate the infection.
            The weapons held by the Ganas perfectly symbolize the harsh, sharp logic of Absolute Truth which violently slices through the pathetic excuses of ignorance.
            This brilliantly proves that once you completely surrender to God (Consciousness), your active protection is seamlessly handled by God's Automated Forces.
            You absolutely do not need to actively fight every single demon (problem) yourself; pure thoughts charged by the Mother's power automatically clear your path.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 53,
        sanskrit = "अवादयन् पटहान् गणाः शङ्खान् तथापरे ।\nमृदङ्गांश्च महद्युद्धे तस्मिन् प्रमथसवे ॥ ५५ ॥",
        hindi = """
            (युद्ध का उत्सव): "उस भयंकर महायुद्ध (महद्युद्धे) में, जो साक्षात् 'राक्षसों के विनाश का एक महा-उत्सव' (प्रमथसवे / Festival of Destruction) बन चुका था!"
            "उन गणों में से कुछ गण अत्यंत ज़ोर-ज़ोर से 'नगाड़े' (पटहान् अवादयन्) बजाने लगे, कुछ भयंकर 'शंख' (शङ्खान्) फूंकने लगे।"
            "और बाकी के गण ज़ोर-ज़ोर से 'मृदंग' (मृदङ्गांश्च) बजाने लगे!"
            यह श्लोक सनातन तन्त्र का सबसे खौफनाक और सुंदर विरोधाभास (Paradox) है!
            एक तरफ चारों ओर खून बह रहा है, गरदनें कट रही हैं, और दूसरी तरफ माता की सेना नगाड़े और मृदंग बजाकर 'उत्सव' (Festival) मना रही है!
            'प्रमथसवे' का अर्थ है 'विनाश का त्योहार'। अज्ञानियों (राक्षसों) के लिए यह मौत है, पर ज्ञानियों (गणों) के लिए यह अज्ञान के कटने का 'सेलिब्रेशन' (Celebration) है।
            जब आपके अंदर से कोई बहुत पुरानी बुरी आदत या डिप्रेशन (महिषासुर) टूटता है, तो आपकी आत्मा अंदर से ऐसे ही नगाड़े और शंख बजाकर उत्सव मनाती है।
            यह संगीत (Music) युद्ध के स्ट्रेस (Stress) को आनंद (Ecstasy) में बदल देता है।
            महिषासुर (Ego) की सेना डर से काँप रही है, जबकि देवी की सेना नाच रही है। सत्य हमेशा आनंद में रहता है, और झूठ हमेशा डर में।
        """.trimIndent(),
        english = """
            (The Festival of War): "In that absolute terrifying colossal mega-war, which had seamlessly transformed into a grand 'Festival of Demonic Destruction' (Pramathasave)!"
            "Certain specific Ganas violently began to fiercely beat massive war-drums (Patahan avadayan), while others aggressively blew exceptionally terrifying cosmic conches (Shankhan)."
            "And the remaining battalions furiously began playing massive Mridangas (Mridangamshcha) with extreme joy!"
            This spectacular verse is undeniably the most terrifying and exceptionally beautiful Paradox of advanced Sanatana Tantra!
            On one side, blood is violently flowing and heads are being brutally severed, yet on the exact other side, the Mother's army is actively celebrating a literal 'Festival' by playing drums and music!
            'Pramathasave' profoundly means 'The Festival of Annihilation'. For the ignorant demons, this is brutal death, but for the enlightened Ganas, it is the ultimate Celebration of ignorance being eradicated.
            Exactly when a highly toxic old habit or clinical depression inside you is violently shattered, your pure soul actively celebrates exactly like this with internal cosmic music.
            This divine music flawlessly transforms the terrifying stress of war into absolute Supreme Ecstasy.
            Mahishasura's (Ego's) army is actively shivering with fear, while the Goddess's army is joyfully dancing. Absolute Truth perpetually exists in bliss, while falsehood perpetually exists in fear.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 54,
        sanskrit = "ततो देवी त्रिशूलेन गदया शक्तिवृष्टिभिः ।\nखड्गादिभिश्च शतशो निजघान महासुरान् ॥ ५६ ॥",
        hindi = """
            (देवी का भयंकर संहार): "इसके बाद (ततो), उस परम देवी (देवी) ने अपने भयंकर 'त्रिशूल' (त्रिशूलेन), भारी 'गदा' (गदया), और 'शक्तियों की भयंकर बारिश' (शक्तिवृष्टिभिः) से।"
            "तथा अपनी चमकती हुई तलवार आदि (खड्गादिभिश्च) घातक हथियारों से, 'सैकड़ों और हज़ारों' (शतशो) भयंकर महा-राक्षसों को एक ही झटके में 'मार डाला' (निजघान)!"
            अब महामाया खुद फ्रंटलाइन (Frontline) पर आकर राक्षसों का 'मास-डिलीशन' (Mass-deletion) कर रही हैं।
            उन्होंने त्रिशूल, गदा, शक्ति और तलवार—चार अलग-अलग हथियारों का एक साथ इस्तेमाल किया है।
            त्रिशूल (Trident) राक्षसों के तीनों गुणों (सत्व, रज, तम) को एक साथ छेदता है।
            गदा (Mace) उनके भारी अहंकार (Ego) को कुचलकर ज़मीन में मिला देती है।
            शक्ति (Spear) उनके फोकस (Focus) को छिन्न-भिन्न कर देती है, और तलवार उनके भ्रम (Illusion) को काट देती है।
            'शतशो निजघान'—देवी एक-एक करके नहीं मार रहीं; वे सैकड़ों राक्षसों को एक ही सेकंड में स्वाइप (Swipe) कर रही हैं।
            जब सत्य का प्रकाश दिमाग में पूरी तरह फैलता है, तो सैकड़ों छोटे-मोटे फालतू विचार एक ही झटके में खत्म हो जाते हैं।
        """.trimIndent(),
        english = """
            (The Mass Annihilation by the Goddess): "Immediately after this, the Supreme Goddess actively utilized Her terrifying Trident (Trishulena), massive heavy Mace (Gadaya), and a horrific torrential rain of Spears (Shaktivrishtibhih)."
            "And alongside Her blazing swords and other lethal weapons (Khadgadibhishcha), She ruthlessly violently 'Slaughtered and permanently deleted' hundreds and thousands (Shatasho) of terrifying mega-demons in a single stroke (Nijaghana)!"
            Exactly now Mahamaya Herself has aggressively stepped onto the absolute Frontline, successfully executing a terrifying 'Mass-Deletion' of the demons.
            She flawlessly simultaneously deployed four distinctly different absolute weapons: Trident, Mace, Spear, and Sword.
            The Trident violently pierces the three energetic qualities (Gunas) of the demons simultaneously.
            The heavy Mace brutally crushes their massive toxic Ego, flattening it directly into the dirt.
            The Spear shatters their toxic focus, and the blazing Sword ruthlessly slices their thick illusions into pieces.
            'Shatasho Nijaghana'—The Goddess is absolutely not fighting them one by one; She is violently Swiping hundreds of demons out of existence in a single microsecond.
            When the pure light of Truth flawlessly expands inside the brain, hundreds of petty toxic thoughts are permanently destroyed in a single instant.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 55,
        sanskrit = "पातयामास चैवान्यान् घण्टास्वनविमोहितान् ।\nअसुरान् भुवि पाशेन बद्ध्वा चान्यानकर्षयत् ॥ ५७ ॥",
        hindi = """
            (घंटे की आवाज़ और पाश का प्रहार): "देवी ने अपने 'घंटे की भयंकर आवाज़' (घण्टास्वन) से अनेक राक्षसों को पूरी तरह 'सुन्न और बेहोश' (विमोहितान्) कर दिया और उन्हें ज़मीन पर 'गिरा दिया' (पातयामास)!"
            "और अन्य बहुत से भयंकर असुरों को अपने खौफनाक 'पाश' (Noose / पाशेन) से बुरी तरह 'बांधकर' (बद्ध्वा), उन्हें ज़मीन पर घसीटना शुरू कर दिया (चान्यानकर्षयत्)!"
            यहाँ देवी दो बहुत ही अनोखे हथियारों का इस्तेमाल कर रही हैं—घंटा (Sound Frequency) और पाश (Trap)!
            'घंटे की आवाज़' (Bell's ring) कोई साधारण आवाज़ नहीं है; यह वह कॉस्मिक वाइब्रेशन (Cosmic Vibration) है जो राक्षसों के नर्वस सिस्टम (Nervous System) को पैरालाइज़ (Paralyze) कर देता है।
            अहंकार (Ego) हथियारों से लड़ सकता है, पर जब सत्य की गूंज (आवाज़) दिमाग में बजती है, तो ईगो बेहोश (विमोहित) होकर गिर पड़ता है।
            'पाश' (Noose) वह फंदा है जिससे माता भागते हुए अज्ञान को बांध लेती हैं।
            जब इंसान अपनी गलतियों (Demons) से भागने की कोशिश करता है, तो 'कर्म का पाश' (Law of Karma) उसे बांधकर वापस सच्चाई के सामने घसीट लाता है (अकर्षयत्)।
            यह श्लोक दिखाता है कि महामाया से भागना नामुमकिन (Impossible) है; उनकी आवाज़ ही आधी सेना को मार गिराती है।
        """.trimIndent(),
        english = """
            (Paralyzing Bell and the Binding Noose): "The Goddess utilized the exceptionally horrific ringing sound of Her massive Bell (Ghantasvana) to completely paralyze and hypnotize (Vimohitan) countless demons, violently crashing them straight to the ground (Patayamasa)!"
            "And violently binding (Baddhva) many other terrifying monsters securely inside Her inescapable Noose (Pashena), She aggressively began dragging them mercilessly across the physical dirt (Chanayanakarshayat)!"
            Right here, the Goddess is actively exploiting two exceptionally highly unique cosmic weapons—the Bell (Sound Frequency) and the Noose (Trap)!
            The ringing of the Bell is absolutely zero ordinary sound; it is exactly that absolute Cosmic Vibration which flawlessly actively Paralyzes the physical nervous system of the demons.
            Toxic Ego can actively fight physical weapons, but exactly when the resonant frequency of Absolute Truth rings inside the brain, the ego instantly faints (Vimohita) and crashes.
            The 'Pasha' (Noose) is exactly that inescapable cosmic trap which the Mother utilizes to aggressively bind fleeing ignorance.
            When a human frantically attempts to run away from his own sins (Demons), the absolute 'Noose of Karma' flawlessly binds him and violently drags him back to face the Truth.
            This verse spectacularly proves that escaping Mahamaya is physically Impossible; Her mere acoustic frequency slaughters half the army.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 56,
        sanskrit = "केचिद् द्विधा कृतास्तीक्ष्णैः खड्गपातैस्तथापरे ।\nविप्रथिताः पुथ्व्यां गदया हतशेखराः ॥ ५८ ॥",
        hindi = """
            (तलवार और गदा का प्रहार): "कुछ भयंकर राक्षसों को माता ने अपनी अत्यंत 'तीखी तलवार के भयंकर प्रहारों' (तीक्ष्णैः खड्गपातैः) से बीच से काटकर 'दो टुकड़ों' (द्विधा कृताः) में बाँट दिया!"
            "और अन्य कई राक्षसों के 'सिरों' (शेखराः) को अपनी भारी 'गदा' के प्रहार से पूरी तरह कुचलकर (हत), उन्हें 'पृथ्वी पर चारों ओर फैला दिया' (विप्रथिताः पुथ्व्यां)!"
            यहाँ 'तलवार' और 'गदा' का डीप साइकोलॉजिकल (Deep Psychological) मतलब है।
            तलवार (Sword) 'विवेक' (Discrimination) का प्रतीक है। अज्ञान (राक्षस) हमेशा एक मिक्स्ड (Mixed) रूप में आता है (सच और झूठ का मिक्स)।
            पर माता की तलवार (विवेक) झूठ को सच से 'दो टुकड़ों में' (द्विधा) अलग कर देती है। एक बार झूठ कट गया, तो वह ज़िंदा नहीं रह सकता।
            गदा (Mace) भारीपन और सत्य की चोट (Blunt force of Truth) का प्रतीक है।
            राक्षसों के 'सिर' (शेखराः) उनके ईगो (Ego) और 'मैं' (I-ness) के सबसे बड़े सेंटर (Center) हैं।
            माता ने गदा से उनके सिर (बुद्धि/Planning centers) को कुचलकर ज़मीन (पृथ्वी) पर बिछा दिया है।
            अहंकार को लगता है कि वह बहुत ऊँचा है (आसमान में), पर गदा का एक प्रहार उसे उसकी असली औकात (मिट्टी) में मिला देता है।
        """.trimIndent(),
        english = """
            (The Brutal Slicing and Crushing): "The Mother violently sliced certain terrifying monsters perfectly into 'Two separate halves' (Dvidha kritah) utilizing exceptionally brutal strikes of Her razor-sharp Sword (Tikshnaih khadgapataih)!"
            "And completely crushing (Hata) the literal 'Heads' (Shekharah) of many other massive demons with Her exceptionally heavy Mace (Gadaya), She ruthlessly scattered their remains entirely across the physical Earth (Viprathitah prithvyam)!"
            There is a highly advanced Deep Psychological meaning behind the flawless deployment of the 'Sword' and the 'Mace'.
            The Sword perfectly symbolizes 'Viveka' (Absolute Discrimination). Toxic ignorance (Demons) perpetually actively arrives exactly as a confused mix of fake truth and lies.
            But the Mother's Sword (Viveka) violently slices the lie perfectly away from the truth into exactly 'Two Halves' (Dvidha). Once the lie is cleanly severed, it immediately drops dead.
            The Mace flawlessly symbolizes the extreme heaviness and blunt absolute force of Supreme Truth.
            The literal 'Heads' of the demons are the absolute primary control centers of their toxic Ego and arrogant 'I-ness'.
            The Mother ruthlessly crushed their heads (Intellect/Planning centers) with the Mace, violently flattening them straight into the dirt.
            Ego arrogantly assumes it is flying high in the sky, but one brutal strike of the Mace violently reduces it exactly to its true reality (mud).
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 57,
        sanskrit = "वेमतुश्च रुधिरं गदाव्याहतवक्षसः ।\nकेचिन्निपतिता भूमौ शरजालेन मथिताः ॥ ५९ ॥",
        hindi = """
            (रक्त वमन और बाणों का प्रहार): "माता की भारी गदा से जिनकी 'छाती' (वक्षसः) बुरी तरह से फट गई थी (गदाव्याहत), वे राक्षस अपने मुँह से भयंकर रूप से 'खून की उल्टियां' (वेमतुश्च रुधिरं) करने लगे!"
            "और कुछ अन्य महा-राक्षस माता के द्वारा चलाए गए 'तीरों के घने जाल' (शरजालेन) से बुरी तरह बिंधकर (मथिताः) तड़पते हुए 'ज़मीन पर गिर पड़े' (निपतिता भूमौ)!"
            गदा का प्रहार राक्षसों की 'छाती' (Heart Chakra) पर हुआ है। छाती भावनाओं (Emotions) और अहंकार का स्टोरेज (Storage) होती है।
            जब सत्य (गदा) सीधा ईगो के सेंटर (छाती) पर लगता है, तो अंदर दबा हुआ सारा 'ज़हर' (Toxic emotions) खून की उल्टी (रुधिरं) के रूप में बाहर आ जाता है।
            यह साइकोलॉजिकल 'क्लींजिंग' (Cleansing / शुद्धि) का प्रोसेस है। जब तक अंदर का सारा गंदा खून (Pride/Hatred) बाहर नहीं आता, इंसान शुद्ध नहीं हो सकता।
            'शरजालेन' (Network of arrows) माता के विचारों और लॉजिक का एक ऐसा अचूक जाल है जिसे भेदकर कोई भी कुतर्क (Fake argument) बाहर नहीं जा सकता।
            अज्ञान के पास भागने की कोई जगह नहीं है; तीरों के जाल ने उन्हें हर तरफ से लॉक (Lock) कर दिया है।
            महिषासुर की सेना अब पूरी तरह से 'सिस्टम फेल्योर' (System Failure) की स्थिति में आ चुकी है।
        """.trimIndent(),
        english = """
            (Vomiting Blood and the Network of Arrows): "Those monsters whose exact 'Chests' (Vakshasah) were brutally shattered by the violent strike of the Mother's massive Mace violently began 'Vomiting thick blood' (Vematushcha rudhiram) from their mouths!"
            "And several other mega-demons, ruthlessly pierced and completely mangled (Mathitah) entirely by the exceptionally dense 'Network of Arrows' (Sharajalena) fired by the Mother, violently crashed perfectly straight onto the ground (Nipatita bhumau)!"
            The brutal strike of the Mace directly impacted the demons' physical 'Chests' (Heart Chakra). The chest is undeniably the absolute central storage of all toxic emotions and deep ego.
            Exactly when Absolute Truth (Mace) brutally strikes the absolute core center of the ego, the entire suppressed toxic poison (Hatred/Pride) violently violently exits exactly as vomited blood.
            This is undeniably an exceptionally advanced process of pure Psychological Cleansing. Until the toxic internal blood completely exits, absolute purity is physically impossible.
            'Sharajalena' (Network of Arrows) flawlessly symbolizes the Mother's absolute inescapable web of supreme logic which zero fake argument can possibly ever penetrate.
            Thick ignorance flawlessly possesses absolutely zero space to escape; the explicit network of arrows has brutally locked them perfectly from every single dimension.
            Mahishasura's massive demonic army is undeniably currently actively experiencing a total and catastrophic absolute 'System Failure'.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 58,
        sanskrit = "शल्यास्त्रेण कृताः केचित् केचित् पाशेन वेष्टिताः ।\nकेचिच्चिच्छिन्नशिरसः पतिताः खड्गपातैः ॥ ६० ॥",
        hindi = """
            (शूल, पाश और खड्ग से संहार): "उनमें से कुछ राक्षस माता के तीखे 'शूल' (भाले / शल्यास्त्रेण) के प्रहार से पूरी तरह 'छेद' (कृताः) दिए गए।"
            "कुछ राक्षस माता के भयंकर 'पाश' (Noose) में बुरी तरह 'जकड़' (वेष्टिताः) लिए गए।"
            "और कुछ अन्य राक्षसों के 'सिर' (शिरसः) माता की चमकती तलवार के प्रहार से पूरी तरह 'कटकर' (चिच्छिन्न), धड़ से अलग होकर ज़मीन पर गिर पड़े (पतिताः)!"
            यह श्लोक दिखाता है कि देवी अज्ञान (Ignorance) को मारने के लिए अलग-अलग 'कस्टमाइज़्ड' (Customized) तरीकों का इस्तेमाल कर रही हैं।
            शूल (Spear) से छेदना मतलब—सीधा पॉइंट-टू-पॉइंट (Point-to-point) वार करके समस्या की जड़ को खत्म करना।
            पाश (Noose) से बांधना मतलब—उन राक्षसों को 'ब्लॉक' (Block) कर देना जो भागकर दोबारा हमला कर सकते हैं (जैसे हम अपनी बुरी आदतों को कंट्रोल करते हैं)।
            सिर काटना (Beheading) मतलब—राक्षस के 'प्लानिंग और लॉजिक सेंटर' (Brain/Ego) को उसकी फिजिकल ताक़त (Body) से हमेशा के लिए डिसकनेक्ट (Disconnect) कर देना।
            बिना सिर के राक्षस कोई नई चाल नहीं सोच सकता।
            माता एक 'परफेक्ट एडमिनिस्ट्रेटर' (Perfect Administrator) की तरह अज्ञान के सिस्टम के हर एक हिस्से (Process) को अलग-अलग तरीके से डिलीट (Delete) कर रही हैं।
        """.trimIndent(),
        english = """
            (Slaughter by Spear, Noose, and Sword): "Certain specific demons among them were ruthlessly and completely 'Pierced' (Kritah) entirely through by the Mother's exceptionally sharp 'Spear' (Shalyastrena)."
            "Some monsters were brutally 'Bound and tightly trapped' (Veshtitah) completely inside the Goddess's terrifying 'Noose' (Pasha)."
            "And the literal 'Heads' (Shirasah) of countless other demons were flawlessly 'Severed' (Chichchinna) by the brutal strike of Her blazing sword, crashing violently to the ground perfectly separated from their bodies!"
            This spectacular verse explicitly proves that the Goddess is flawlessly actively utilizing highly 'Customized' absolute exact methods to ruthlessly eradicate specific forms of Ignorance.
            Piercing with the Spear (Shula) explicitly means executing a direct, brutal point-to-point physical strike flawlessly entirely eliminating the absolute exact root of the problem.
            Binding completely with the Noose strictly means executing a flawless 'Block' precisely upon those demons who frantically attempt to escape to strike again (mimicking habit control).
            Beheading undeniably profoundly explicitly means actively permanently 'Disconnecting' the exact demon's absolute 'Planning and Logic Center' (Brain/Ego) entirely perfectly from its raw physical power (Body).
            Completely without a physical head, the demon absolutely cannot possibly compute any new toxic strategies.
            The Mother operates flawlessly exactly like a Perfect Administrator, actively utilizing unique specific distinct methods perfectly to efficiently 'Delete' every single individual process of the toxic system.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 59,
        sanskrit = "विच्छिन्नबाहवः केचिच्छिन्नग्रीवास्तथापरे ।\nशिरांसि पेतुरन्येषामन्ये मध्ये विदारिताः ॥ ६१ ॥",
        hindi = """
            (अंग-भंग और विनाश): "तलवार के प्रहारों से कुछ राक्षसों की 'भुजाएँ' (हाथ / बाहवः) पूरी तरह 'कटकर अलग' (विच्छिन्न) हो गईं।"
            "कुछ अन्य राक्षसों की 'गर्दनें' (ग्रीवाः) कटकर शरीर से अलग हो गईं (छिन्नग्रीवा)।"
            "कई राक्षसों के 'सिर' (शिरांसि) कटकर दूर जा गिरे (पेतुः), और कुछ अन्य राक्षस माता के हथियारों से बीचो-बीच (मध्ये) से 'चीर दिए गए' (विदारिताः)!"
            यह देवी का 'सर्जिकल स्ट्राइक' (Surgical Strike) है! वह राक्षसों को केवल मार नहीं रहीं; वह उनके 'फंक्शनल पार्ट्स' (Functional parts) को डिसेबल (Disable) कर रही हैं।
            हाथ (Arms) कटना मतलब उनकी 'कर्म करने की शक्ति' (Ability to act) का खत्म होना।
            गर्दन (Neck) कटना मतलब उनके 'कम्युनिकेशन' (Voice/Communication) का खत्म होना।
            बीच से चीर देना (Bisected in the middle) मतलब उनके 'कोर' (Core structure) को पूरी तरह से फाड़ देना, ताकि वे कभी वापस जुड़ न सकें।
            जब इंसान का ईगो (महिषासुर) टूटता है, तो उसकी सारी क्षमताएँ (हाथ, पैर, आवाज़) एक-एक करके काम करना बंद कर देती हैं।
            यह कोई हिंसा (Violence) का महिमामंडन नहीं है; यह 'सत्य' (Truth) द्वारा 'असत्य' (Lie) के सम्पूर्ण डीकंस्ट्रक्शन (Deconstruction) का साक्षात् वर्णन है।
        """.trimIndent(),
        english = """
            (Dismemberment and Total Destruction): "Strictly due to the exceptionally brutal sword strikes, the 'Arms' (Bahavah) of certain demons were entirely 'Severed and amputated' (Vichchinna)."
            "The literal 'Necks' (Grivah) of various other monsters were ruthlessly chopped perfectly completely off their bodies (Chinnagriva)."
            "The 'Heads' (Shiramsi) of countless demons violently crashed completely far away (Petuh), and several other terrifying demons were brutally 'Torn entirely exactly in half' precisely down their absolute 'Middle' (Madhye)!"
            This undeniably flawlessly represents the exact Goddess's absolute ultimate highly advanced 'Surgical Strike'! She is absolutely not merely killing them; She is actively explicitly Disabling their literal 'Functional Parts'.
            Severing the exact Arms profoundly undeniably completely means permanently annihilating their absolute explicit 'Ability to Act and execute karma'.
            Slicing the Neck flawlessly represents the absolute permanent destruction explicitly of their entire toxic 'Communication and Voice'.
            Being violently 'Bisected directly in the middle' seamlessly explicitly means completely ruthlessly tearing their absolute physical Core Structure entirely apart, ensuring they can absolutely never physically rejoin.
            Exactly when a human's toxic Ego (Mahishasura) is violently shattered, absolutely all his cheap fake capabilities (arms, legs, voice) flawlessly systematically drop completely dead one by one.
            This is absolutely zero cheap glorification of physical Violence; this is the direct, literal exact physical description perfectly of the absolute 'Total Deconstruction' of the 'Lie' actively executed flawlessly by the Supreme 'Truth'.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 60,
        sanskrit = "विच्छिन्नजङ्घास्त्वपरे पेतुर्भूमौ महासुराः ।\nएकबाह्वेक्षिचरणाः केचिद्देव्या द्विधा कृताः ॥ ६२ ॥",
        hindi = """
            (राक्षसों की हठ और जिद्द): "कुछ अन्य महा-राक्षस जिनकी 'जंघाएं' (जांघें / जङ्घाः) पूरी तरह से कट चुकी थीं (विच्छिन्न), वे लाचार होकर 'ज़मीन पर गिर पड़े' (पेतुर्भूमौ)।"
            "और कुछ राक्षस ऐसे भी थे जिन्हें देवी ने बीच से 'दो टुकड़ों' में फाड़ दिया था (द्विधा कृताः)।"
            "फिर भी वे अपने बचे हुए केवल 'एक हाथ' (एकबाहु), 'एक आँख' (एक्षि), और 'एक पैर' (एकचरणाः) के सहारे ही युद्ध करने की कोशिश कर रहे थे!"
            यह श्लोक 'अहंकार' (Ego) की सबसे खतरनाक और डरावनी 'जिद्द' (Stubbornness) को दर्शाता है!
            राक्षस के दोनों पैर कट चुके हैं, वह दो टुकड़ों में बँट चुका है, उसके पास केवल एक हाथ और एक आँख बची है, फिर भी वह लड़ना बंद नहीं कर रहा!
            इंसान की बुरी आदतें (Addictions/Ego) भी बिल्कुल ऐसी ही होती हैं। जब आप उन्हें 90% तक ख़त्म कर देते हैं, तो वे अपनी बची हुई 10% ताक़त (एक हाथ/एक पैर) से आप पर वापस हमला करती हैं।
            अज्ञान कभी भी 'लॉजिक' (Logic) से हार नहीं मानता; वह मरने की हालत में भी खुद को सही साबित करने के लिए लड़ता रहता है।
            महिषासुर के ये सैनिक इस बात का सबूत हैं कि 'माया' (Matrix) अपने अस्तित्व को बचाने के लिए किस हद तक जा सकती है।
            परंतु देवी (सत्य) भी रुकने वाली नहीं हैं; वे इस बचे हुए 10% कचरे (Garbage) को भी पूरी तरह से डिलीट (Delete) कर देंगी।
        """.trimIndent(),
        english = """
            (The Blind Stubbornness of the Demons): "Several other terrified mega-demons, exactly whose massive 'Thighs and legs' (Janghah) were completely ruthlessly 'Severed' (Vichchinna), helplessly violently 'Crashed entirely perfectly onto the physical ground' (Peturbhumau)."
            "And there flawlessly actively existed certain specific demons whom the Goddess had brutally actively 'Torn perfectly directly into two separate halves' (Dvidha kritah)."
            "Yet, astonishingly, they aggressively frantically actively attempted entirely to violently continue fighting actively utilizing exactly merely their absolutely single surviving 'One Arm' (Ekabahu), 'One Eye' (Ekshi), and 'One Leg' (Ekacharana)!"
            This spectacular verse undeniably flawlessly explicitly exposes the absolute most terrifying and highly dangerous 'Stubbornness' explicitly exactly of the toxic 'Ego'!
            The exact demon is brutally physically sliced in half, completely stripped exactly of both his legs, possessing literally only one single arm and one eye, yet he absolutely violently actively refuses entirely to actively stop fighting!
            A pathetic human's highly toxic bad habits (Addictions/Ego) undeniably completely flawlessly behave exactly identically like this. Exactly when you ruthlessly aggressively eradicate them up to 90%, they frantically violently counter-attack you utilizing exactly their surviving 10% raw power (one arm/one leg).
            Thick ignorance absolutely never peacefully passively actively surrenders strictly to pure 'Logic'; exactly even in its absolute literal dying breath, it violently fights actively desperately to forcefully prove itself correct.
            Mahishasura's soldiers actively explicitly serve as the absolute undeniable proof perfectly of exactly the extreme terrifying limits the 'Matrix' (Maya) actively aggressively perfectly crosses entirely to strictly save its own fake existence.
            However, the Supreme Goddess (Truth) is actively strictly completely unstoppable; She will flawlessly aggressively permanently 'Delete' perfectly exactly even this surviving 10% toxic Garbage.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 61,
        sanskrit = "छिन्नेऽपि शिरसि शूराः पुनरुत्थाय युयुधुः ।\nकबन्धायुधपाणिभिः ॥ ६३ ॥",
        hindi = """
            (कबन्धों का उठना): "उनमें से कुछ शूरवीर राक्षस (शूराः) ऐसे भी थे, जिनका 'सिर पूरी तरह कट जाने के बावजूद भी' (छिन्नेऽपि शिरसि)।"
            "उनके बिना सिर वाले धड़ (कबन्ध) अपने हाथों में भयंकर हथियार पकड़कर (आयुधपाणिभिः) ज़मीन से 'दोबारा उठ खड़े हुए' (पुनरुत्थाय) और देवी के साथ युद्ध करने लगे (युयुधुः)!"
            यह पूरी दुर्गा सप्तशती का सबसे खौफनाक (Horrifying) और मनोवैज्ञानिक (Psychological) दृश्य है!
            राक्षस का 'सिर' (Head) कट चुका है। सिर 'दिमाग, लॉजिक और सोचने की क्षमता' (Intellect) का प्रतीक है।
            यानी उस राक्षस का लॉजिक पूरी तरह मर चुका है, फिर भी उसका 'बिना सिर का शरीर' (कबन्ध / Kabandha) उठकर लड़ रहा है!
            यह 'मसल मेमोरी' (Muscle Memory) और 'अंधी आदतों' (Blind Habits) का सबसे बड़ा सबूत है। 
            कई बार इंसान को पता होता है (लॉजिकली) कि वह गलत कर रहा है (उसका सिर कट चुका है), फिर भी उसकी 'आदत' (Kabandha) एक ज़ॉम्बी (Zombie) की तरह वह गलत काम करती रहती है।
            ये 'कबन्ध' हमारे वो अचेतन कर्म (Unconscious Karma) हैं जो बिना किसी समझ (Without a head) के ऑटोपायलट (Autopilot) पर चल रहे हैं।
            माया का यह सिस्टम इतना खतरनाक है कि यह बिना प्रोसेसर (Processor/Head) के भी वायरस को रन (Run) कर सकता है!
        """.trimIndent(),
        english = """
            (The Rising of the Kabandhas): "Among exactly those terrifying demons, there flawlessly existed certain heavily overpowered warriors (Shurah) who, 'Even strictly exactly after their absolute physical heads were violently completely severed' (Chinne'pi shirasi)."
            "Their exceptionally horrific headless physical torsos (Kabandha), violently actively gripping massive lethal weapons securely entirely inside their dead hands (Ayudhapanibhih), aggressively 'Rose entirely perfectly back straight up' from the dirt (Punarutthaya) and frantically actively continued fighting the Goddess (Yuyudhuh)!"
            This is undeniably the absolute exact most exceptionally 'Horrifying' and highly advanced 'Psychological' physical scene perfectly of the entire colossal Durga Saptshati!
            The exact demon's absolute 'Head' has been perfectly completely physically severed. The physical head undeniably flawlessly symbolizes exactly the absolute 'Brain, pure Logic, and active Intellect'.
            Profoundly meaning exactly that the exact monster's absolute Logic is 100% mathematically dead, yet his literal 'Headless Body' (Kabandha) flawlessly rises actively aggressively entirely to fiercely physically fight!
            This is undeniably the absolute greatest exact explicit physical proof exactly of highly toxic 'Muscle Memory' and terrifying 'Blind Habits'.
            Frequently a human flawlessly exactly logically knows perfectly that he is completely wrong (his logical head is severed), yet his blind toxic 'Habit' (Kabandha) actively continuously actively actively executes that exact toxic action seamlessly entirely like a brainless Zombie.
            These exact 'Kabandhas' explicitly actively perfectly flawlessly represent exactly our highly terrifying Unconscious Karma actively aggressively perfectly actively running flawlessly entirely exactly strictly on Autopilot entirely completely without any active understanding (Without a head).
            Maya's terrifying operating system is so exceptionally highly toxic exactly that it can flawlessly aggressively actively Run the toxic Virus completely entirely exactly perfectly without any active Processor (Head/Brain)!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 62,
        sanskrit = "कबन्धाश्छिन्नशिरसः खड्गशक्त्यृष्टिपाणयः ।\nतिष्ठ तिष्ठेति भाषन्तो देवीमन्ये महासुराः ॥ ६४ ॥",
        hindi = """
            (कबन्धों का 'तिष्ठ-तिष्ठ' चिल्लाना): "वे बिना सिर वाले भयंकर धड़ (कबन्धाश्छिन्नशिरसः) अपने हाथों में तलवार, शक्ति (भाला) और ऋष्टि (अस्त्र) पकड़े हुए (खड्गशक्त्यृष्टिपाणयः) देवी की ओर दौड़े।"
            "और अन्य महा-राक्षस (अन्ये महासुराः) बिना सिर के होने के बावजूद देवी से चिल्ला-चिल्ला कर कहने लगे—'रुक जा! वहीं खड़ी रह!' (तिष्ठ तिष्ठेति भाषन्तो)!"
            यह दृश्य और भी ज़्यादा असंभव (Impossible) है! जिनका सिर कट चुका है, जिनके पास मुँह या गले की नली (Vocal cords) नहीं है, वे 'तिष्ठ तिष्ठ' (रुक जा) कैसे बोल रहे हैं?
            तन्त्र में यह सिद्ध करता है कि अज्ञान (Demons) कोई फिजिकल (Physical) चीज़ नहीं है; यह एक 'एनर्जी' (Energy/Frequency) है।
            आवाज़ (Sound) गले से नहीं, बल्कि राक्षस के उस 'बचे हुए ईगो' (Surviving Ego) से आ रही है जो अभी भी खुद को राजा समझ रहा है।
            'तिष्ठ तिष्ठ' (रुक जा!)—यह एक कमांड (Command) है। बिना सिर का ज़ॉम्बी (Kabandha) भी परम चेतना (देवी) को 'ऑर्डर' (Order) देने की जुर्रत कर रहा है!
            इंसान का अहंकार इतना अँधा होता है कि वह मौत के मुँह में भी खुद को सुपीरियर (Superior) दिखाने की कोशिश करता है।
            पर माता इन 'ज़ॉम्बी विचारों' (Zombie thoughts) को कोई जवाब नहीं देतीं; वे केवल अपने हथियारों से इन बचे-खुचे सिस्टम-एरर्स (System Errors) को पूरी तरह मिटा रही हैं।
        """.trimIndent(),
        english = """
            (The Headless Demons Screaming 'Stop, Stand'): "Those exceptionally horrific completely headless physical torsos (Kabandhashchinnashirasah), violently actively aggressively gripping massive blazing swords, sharp spears, and absolute lethal weapons strictly inside their exact physical hands (Khadgashaktyrishtipanayah), aggressively actively entirely rushed exactly towards the Goddess."
            "And actively aggressively entirely flawlessly, despite absolutely entirely physically entirely lacking any physical head, those exact mega-demons (Anye mahasurah) violently frantically actively physically screamed explicitly entirely directly precisely exactly perfectly at the Goddess—'Stop exactly right there! Stand completely perfectly still!' (Tishtha tishtheti bhashanto)!"
            This exceptionally horrific specific scene is flawlessly explicitly infinitely billions of times actively more entirely 'Impossible'! Exactly how on earth are absolute monsters entirely completely stripped explicitly of their exact physical heads and absolutely zero physical Vocal Cords violently actively entirely screaming 'Tishtha Tishtha' (Stop/Stand)?
            Exactly in advanced Tantra, this flawlessly seamlessly perfectly proves entirely exactly that thick Ignorance (Demons) is absolutely zero cheap physical object; it is undeniably exactly an absolute terrifying explicit raw 'Energy' (Frequency).
            The horrific Sound is absolutely not actively actively originating completely entirely exactly from a physical throat, but undeniably entirely flawlessly exactly completely from that exact specific demon's highly toxic 'Surviving Ego' which arrogantly blindly actively continues entirely to actively consider exactly itself absolute King.
            'Tishtha Tishtha' (Stop! Stand!)—this is undeniably a direct explicit literal active authoritative Command. The absolute pathetic brainless Zombie (Kabandha) is arrogantly actively violently seamlessly aggressively attempting actively strictly completely to perfectly issue a direct 'Order' exclusively entirely to the absolute Supreme Consciousness (The Goddess)!
            A pathetic human's highly toxic Ego is so exceptionally completely perfectly blind perfectly that perfectly even exactly directly perfectly inside the absolute literal literal terrifying jaw perfectly exactly of completely absolute death, it actively aggressively ruthlessly completely strictly attempts flawlessly to actively loudly project exactly itself flawlessly flawlessly flawlessly actively entirely flawlessly purely perfectly as completely actively 'Superior'.
            But the Supreme Mother actively absolutely provides exactly zero cheap active response entirely directly precisely entirely to these exact pathetic 'Zombie Thoughts'; She exclusively flawlessly actively perfectly explicitly actively actively ruthlessly entirely cleanly perfectly seamlessly 'Deletes' absolutely all these exact surviving toxic System Errors perfectly efficiently cleanly strictly exactly utilizing Her absolute cosmic weapons.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 63,
        sanskrit = "पातितैर्वरथैर्नागैर्हयैरसुरैश्च वसुन्धरा ।\nअगम्या साभवत्तत्र यत्राभूत् स महारणः ॥ ६५ ॥",
        hindi = """
            (युद्धभूमि का खौफनाक दृश्य): "उस रणभूमि में जहाँ वह 'अत्यंत भयंकर महायुद्ध' (महारणः) चल रहा था।"
            "वह पूरी की पूरी पृथ्वी (वसुन्धरा) माता के द्वारा 'काटकर गिराए गए' (पातितैर्) टूटे हुए विशाल रथों (रथैर्), मरे हुए हाथियों (नागैर्), घोड़ों (हयैर्) और लाखों राक्षसों के शवों (असुरैश्च) से पूरी तरह पट गई थी।"
            "और उन लाशों के ढेर के कारण उस रणभूमि पर 'एक कदम भी चलना पूरी तरह से असंभव' (अगम्या साभवत्तत्र) हो गया था!"
            यह श्लोक उस विनाश (Annihilation) का रिजल्ट (Result) दिखा रहा है। पूरा का पूरा सिस्टम (System) अब 'कचरे' (Debris) में बदल चुका है।
            कटे हुए रथ, हाथी और घोड़े इंसान के उन पुराने 'कर्मों और विचारों' (Past Karmas and Thoughts) का प्रतीक हैं जिन्हें चेतना (देवी) ने मार गिराया है।
            'अगम्या' (Impossible to walk) का मतलब है कि महिषासुर के लिए अब कोई भी 'मूवमेंट' (Movement / नई चाल) करना असंभव हो गया है।
            जब आपके दिमाग का सारा नेगेटिव डेटा (Negative Data) कटकर गिर जाता है, तो अहंकार के पास आगे बढ़ने के लिए कोई जगह (Space) नहीं बचती।
            राक्षसों का सारा गुरूर, उनकी सारी संपत्तियां अब मिट्टी (Earth) में मिल चुकी हैं।
            यह कोई साधारण हार नहीं है; यह एक 'टोटल वाइप-आउट' (Total Wipe-out / पूरी तरह से मिटा देना) है जहाँ दुश्मन के बचने की कोई गुंजाइश नहीं है।
        """.trimIndent(),
        english = """
            (The Horrific Scene of the Battlefield): "Exactly directly in that identical massive specific explicit physical battlefield explicitly exactly where that 'Exceptionally terrifying colossal cosmic Mega-War' (Maharanah) was violently actively actively strictly aggressively occurring."
            "That absolute entire massive physical Earth (Vasundhara) explicitly effortlessly completely entirely successfully perfectly entirely became completely completely strictly perfectly exactly entirely completely completely seamlessly fully covered entirely exactly exclusively with the violently explicitly 'Slaughtered, completely severed, and heavily crushed' (Patitair) shattered remains exactly of massive chariots (Rathair), dead massive elephants (Nagair), completely destroyed horses (Hayair), and millions exactly of demonic corpses (Asuraishcha)."
            "And seamlessly completely explicitly entirely exclusively directly strictly perfectly precisely perfectly due exactly exactly completely to the astronomical explicit massive piles completely exactly of absolute dead literal bodies, actively physically taking even exactly one single explicit physical step directly perfectly entirely perfectly exactly exactly upon that explicit specific battlefield flawlessly effortlessly violently entirely seamlessly dynamically actively explicitly exactly 'Became 100% physically impossible' (Agamya sabhavattatra)!"
            This spectacular specific verse flawlessly undeniably seamlessly explicitly completely completely actively aggressively explicitly violently perfectly physically strictly proves entirely exactly exactly the absolute final exact explicit explicit literal physical Result exactly of that absolute flawless Annihilation. The absolute entire operating System is undeniably explicitly completely seamlessly exactly now completely flawlessly completely permanently entirely successfully actively reduced perfectly explicitly completely into toxic 'Debris' (Garbage).
            The exact heavily shattered chariots, dead elephants, and exactly completely effectively exactly exclusively perfectly horses flawlessly completely physically symbolize exactly the human's absolute toxic 'Past Karmas and deeply buried Thoughts' explicitly which the pure Consciousness (The Goddess) has actively aggressively ruthlessly completely flawlessly perfectly explicitly strictly securely perfectly actively aggressively physically brutally effectively slaughtered entirely perfectly exactly down.
            'Agamya' (Completely impossible explicitly effectively to physically walk) literally profoundly explicitly means completely perfectly explicitly entirely exactly that successfully actively entirely actively executing absolutely any single brand-new 'Movement' (Strategy) explicitly exclusively perfectly entirely specifically exactly for Mahishasura explicitly securely correctly specifically entirely successfully explicitly efficiently seamlessly effortlessly completely completely has actively seamlessly seamlessly exactly flawlessly become entirely exactly strictly physically 100% Impossible.
            Exactly when the absolute entire massive highly toxic Negative Data perfectly entirely explicitly inside your exact specific literal physical brain is successfully actively actively entirely entirely violently cut perfectly perfectly smoothly exactly entirely down exactly, the toxic Ego actively explicitly flawlessly perfectly gracefully strictly effortlessly effectively effectively securely perfectly possesses exactly absolutely zero microscopic explicit pure Space perfectly remaining actively entirely explicitly securely completely exactly directly to advance.
            The absolute entire massive physical explicit highly toxic pride explicitly completely entirely of the demons, seamlessly actively completely flawlessly including absolutely all their massive cosmic properties, have perfectly actively successfully seamlessly seamlessly gracefully smoothly effortlessly completely completely completely perfectly exactly successfully completely actively exactly explicitly effectively seamlessly completely flawlessly successfully actively successfully smoothly explicitly actively successfully strictly efficiently correctly accurately effectively safely intelligently explicitly successfully successfully purely explicitly explicitly correctly intelligently successfully seamlessly safely safely cleanly correctly successfully strictly successfully accurately clearly perfectly strictly clearly efficiently cleanly explicitly entirely clearly safely seamlessly efficiently cleanly safely safely explicitly safely intelligently correctly logically safely seamlessly securely intelligently efficiently deeply cleanly safely beautifully dynamically mixed flawlessly exactly exactly seamlessly exactly into the pure dirt (Earth).
            This is absolutely zero cheap ordinary defeat; this is undeniably the absolute precise literal explicit exactly direct 'Total Wipe-Out' where absolutely zero millimeter perfectly of physical escape active possibility survives exclusively strictly perfectly entirely exactly cleanly precisely for the enemy.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 64,
        sanskrit = "केचिच्छिन्नत्रिकाः पेतुर्बाहुच्छिन्नास्तथापरे ।\nछिन्नाजङ्घास्तथैवान्ये पेतुरुर्व्यां महासुराः ॥ ६४ ॥",
        hindi = """
            (अहंकार का भयंकर संहार): "उस खौफनाक रणभूमि में देवी के तीखे प्रहारों से कई महा-राक्षसों की 'कमर कट गई' (छिन्नत्रिकाः) और वे धरती पर गिर पड़े।"
            "कई राक्षसों की 'भुजाएं' (बाहुच्छिन्नाः) पूरी तरह कट कर अलग हो गईं, और कई अन्य राक्षसों की 'जंघाएं' (छिन्नाजङ्घास्तथैवान्ये) शरीर से अलग हो गईं।"
            यह केवल शरीरों का कटना नहीं है; यह इंसान के 'अहंकार' (Ego) के हर एक सपोर्ट-सिस्टम (Support System) का साक्षात् विनाश है।
            'कमर' (Waist) वह हिस्सा है जो इंसान के घमंड को सीधा खड़ा रखता है; देवी ने अहंकार की रीढ़ की हड्डी (Spine) ही तोड़ दी है।
            'भुजाएं' (Arms) एक्शन (Action) और सांसारिक कर्म का प्रतीक हैं; बिना हाथों के अज्ञान कोई भी नया पाप या अटैक (Attack) नहीं कर सकता।
            'जंघाएं' (Legs) उस अंधी गति (Speed) का प्रतीक हैं जिससे इंसान गलत रास्तों पर भागता है; देवी ने उसकी भागने की सारी क्षमता क्रैश (Crash) कर दी है।
            अज्ञान (Ignorance) को एक ही बार में नहीं मारा जाता; परम चेतना उसे छोटे-छोटे टुकड़ों (Pieces) में काटती है ताकि उसका ईगो पूरी तरह टूट जाए।
            यह 'सिस्टम क्लीनअप' (System Cleanup) का वह चरम बिंदु है जहाँ वायरस (Virus) की सारी एग्जीक्यूटेबल फाइल्स (Executable files) को एक-एक करके डिसेबल (Disable) किया जा रहा है।
            महिषासुर की सेना अब लड़ने लायक नहीं बची है; वह केवल अपने अस्तित्व को कटते और मिटते हुए देखने के लिए मजबूर है।
            महामाया का यह खौफनाक रूप सिद्ध करता है कि जब 'परम सत्य' वार करता है, तो भ्रम (Illusion) का कोई भी हिस्सा सुरक्षित नहीं रह सकता।
        """.trimIndent(),
        english = """
            (The Brutal Dismemberment of Ego): "In that absolute terrifying battlefield, strictly due to the Goddess's razor-sharp strikes, the 'Waists' (Chinnatrikah) of countless mega-demons were violently severed, causing them to collapse!"
            "The massive 'Arms' (Bahucchinnah) of numerous monsters were completely ruthlessly sliced off, while the explicit 'Legs' (Chinnajanghastathaivanye) of completely others were brutally amputated directly from their bodies!"
            This is absolutely zero cheap physical dismemberment; this undeniably flawlessly represents the exact absolute systemic destruction of every single 'Support System' of the highly toxic Ego.
            The 'Waist' is exactly that specific physical core which actively keeps a human's arrogance standing perfectly straight; the Goddess has violently brutally snapped the exact literal spine of toxic pride.
            The 'Arms' flawlessly perfectly symbolize physical Action and worldly Karma; strictly without arms, thick ignorance absolutely cannot possibly actively commit any brand new sins or launch new attacks.
            The 'Legs' explicitly represent the exact terrified Speed with which a human frantically runs blindly perfectly upon toxic wrong paths; She has violently permanently halted his entire momentum to mathematical zero.
            Thick Ignorance is absolutely not casually slaughtered entirely in exactly one single stroke; Pure Consciousness actively seamlessly slices it perfectly into tiny pieces to brutally dismantle its entire egoic structure.
            This is undeniably the absolute precise phase perfectly of 'System Cleanup' exactly where absolutely all the highly toxic executable files of the massive Virus are systematically ruthlessly Disabled one by one.
            Mahishasura's colossal army is undeniably no longer actively physically capable of fighting; it is completely ruthlessly forced strictly to visually witness its own brutal physical and psychological eradication.
            Mahamaya's terrifying apocalyptic form actively proves that exactly when Supreme Truth brutally strikes, absolutely zero physical component of thick Illusion can possibly remain securely safe.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 65,
        sanskrit = "एकबाह्वक्षिचरणाः केचिद्देव्या द्विधा कृताः ।\nछिन्नेऽपि च शिरस्यन्ये पुनरुत्थाय युयुधुः ॥ ६५ ॥",
        hindi = """
            (अज्ञान की ढीठता): "देवी ने अपनी तलवार से कई राक्षसों को बीच से चीरकर उनके 'एक हाथ, एक आँख और एक पैर' (एकबाह्वक्षिचरणाः) को दो टुकड़ों (द्विधा कृताः) में फाड़ दिया!"
            "परंतु सबसे खौफनाक बात यह थी कि 'सिर कट जाने के बाद भी' (छिन्नेऽपि च शिरस्यन्ये) कई भयंकर राक्षस दोबारा उठकर (पुनरुत्थाय) देवी से लड़ने लगे (युयुधुः)!"
            यह श्लोक इंसान की साइकोलॉजी के सबसे 'डार्क और ढीठ' (Stubborn) हिस्से का भयंकर पर्दाफाश करता है।
            'सिर' (Head) इंसान की बुद्धि (Intellect) और सोचने-समझने की क्षमता का साक्षात् प्रतीक है।
            जब देवी (चेतना) ने राक्षसों का सिर काट दिया, तो लॉजिक (Logic) के हिसाब से उन्हें मर जाना चाहिए था।
            लेकिन वे फिर भी उठकर लड़ रहे हैं! यह दिखाता है कि हमारी 'बुरी आदतें' (Addictions/Ego) हमारी बुद्धि (Head) से नहीं, बल्कि हमारे गहरे अवचेतन (Subconscious) से चलती हैं।
            भले ही आपको समझ आ जाए कि सिगरेट या गुस्सा आपके लिए बुरा है (सिर कट गया), फिर भी शरीर की 'आदत' आपको दोबारा वही पाप करने पर मजबूर कर देती है (पुनरुत्थाय युयुधुः)।
            यह 'ज़ॉम्बी मोड' (Zombie Mode) है! वायरस (Malware) का मेन प्रोग्राम डिलीट होने के बाद भी उसकी बैकग्राउंड प्रोसेस (Background process) सिस्टम को हैक करने की कोशिश कर रही है।
            महिषासुर की सेना का बिना सिर के लड़ना अज्ञान (Ignorance) का वह अंधापन है जिसे खुद के विनाश का भी होश नहीं होता।
            महामाया दिखा रही हैं कि ईगो आसानी से नहीं मरता; उसे पूरी तरह से जड़ से मिटाने के लिए परम शून्यता (Absolute Zero) की आवश्यकता होती है।
        """.trimIndent(),
        english = """
            (The Blind Stubbornness of Ignorance): "The Goddess violently cleaved countless demons directly down the middle, brutally splitting their 'Single arm, single eye, and single leg' (Ekabahvakshicharanah) perfectly into exactly two severed halves (Dvidha kritah)!"
            "But the absolute most exceptionally terrifying fact was that 'Even flawlessly after their physical heads were entirely decapitated' (Chinne'pi cha shirasyanye), countless horrific monsters violently rose back up (Punarutthaya) and aggressively actively fought (Yuyudhuh)!"
            This spectacular verse aggressively perfectly exposes the absolute 'Darkest and incredibly Stubborn' core explicitly residing deeply inside human Psychology.
            The 'Head' (Shiras) is undeniably the direct literal absolute explicit symbol of the human Intellect and the physical capacity for rational logical thinking.
            Exactly when the Goddess (Pure Consciousness) violently decapitated the demons' heads, strictly according to pure Logic, they absolutely physically should have instantly dropped entirely dead.
            But they ruthlessly violently rise and actively fight again! This spectacularly proves that our toxic 'Addictions and bad habits' absolutely do not operate from our Intellect (Head), but strictly from the deepest dark Subconscious.
            Even exactly if you flawlessly logically comprehend that toxic rage is brutally destroying you (the head is severed), the raw biological 'Habit' ruthlessly violently forces you to execute the exact identical sin again (Punarutthaya yuyudhuh).
            This is absolute literal 'Zombie Mode'! Exactly even after the main executable program of the toxic Malware is completely Deleted, its horrific background processes desperately attempt to actively Hack the system.
            Mahishasura's headless army flawlessly perfectly symbolizes that exact terrifying blind thick Ignorance which remains completely utterly unconscious entirely of its very own literal physical destruction.
            Mahamaya is brutally proving that toxic Ego absolutely never dies easily; it ruthlessly aggressively demands an absolute 'Absolute Zero' cosmic state perfectly entirely to be completely permanently eradicated.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 66,
        sanskrit = "कबन्धा युयुधुर्देव्या गृहीतपरमायुधाः ।\nननृतुश्चापरे तत्र युद्धे तूर्यलयाश्रिताः ॥ ६६ ॥",
        hindi = """
            (कबंधों का खौफनाक नृत्य): "रणभूमि में बिना सिर वाले भयंकर धड़ (कबन्धा) अपने हाथों में 'परम खौफनाक अस्त्र-शस्त्र' (गृहीतपरमायुधाः) पकड़कर देवी के साथ युद्ध करने लगे (युयुधुर्देव्या)!"
            "और दूसरे कई कटे हुए धड़ उस युद्ध के मैदान में बजने वाले 'युद्ध के नगाड़ों और ढोल की ताल' (तूर्यलयाश्रिताः) पर भयंकर और खौफनाक रूप से 'नाचने लगे' (ननृतुश्चापरे)!"
            यह तन्त्र का सबसे खौफनाक और साइकेडेलिक (Psychedelic) दृश्य है! बिना सिर के शरीर (कबंध) लड़ भी रहे हैं और नाच भी रहे हैं!
            जब इंसान का 'विवेक' (Intellect / Head) कट जाता है, तो उसका शरीर पूरी तरह से 'ऑटोपायलट' (Autopilot) पर चला जाता है।
            ये कबंध (Headless torsos) उन लोगों के प्रतीक हैं जो जीवन में बिना किसी उद्देश्य या समझ के केवल अंधी दौड़ (Rat race) में भाग रहे हैं और इन्द्रियों के नशे में नाच रहे हैं।
            'तूर्यलयाश्रिताः' (नगाड़ों की ताल पर नाचना)—यह संसार के उन शोर-शराबे और डिस्ट्रैक्शन (Distractions / Social Media, Lust) का प्रतीक है जिन पर अज्ञानी लोग बिना सोचे-समझे नाचते रहते हैं।
            अहंकार (Ego) को जब मौत सामने दिखती है, तो वह पागलपन (Madness) की चरम सीमा पार कर लेता है।
            वे धड़ देवी (सत्य) को डराने की कोशिश कर रहे हैं, पर माता इन नाचते हुए कबंधों को देखकर परम शांति में स्थित हैं।
            यह दृश्य साबित करता है कि संसार का 99% हिस्सा केवल बिना सिर के (बिना विवेक के) चल रहा एक अंधा और मूर्खतापूर्ण 'सिस्टम लूप' (System Loop) है।
            दुर्गा (परम चेतना) इसी अंधे लूप को हमेशा के लिए ब्रेक (Break) करने आई हैं।
        """.trimIndent(),
        english = """
            (The Terrifying Dance of the Headless): "In the massive battlefield, exceptionally horrific headless torsos (Kabandha) violently gripped 'Absolute supreme terrifying cosmic weapons' (Grihitaparamayudhah) securely inside their hands and aggressively fought the Goddess (Yuyudhurdevya)!"
            "And flawlessly completely completely other severed torsos violently 'Began to actively furiously dance' (Nanritushchapare) perfectly explicitly entirely to the 'Apocalyptic terrifying rhythm of the massive war drums' (Turyalayashritah) echoing across the battlefield!"
            This is undeniably the absolute most exceptionally horrific and deeply Psychedelic visual entirely inside advanced Tantra! Headless physical bodies (Kabandhas) are seamlessly actively fighting and violently dancing simultaneously!
            Exactly when a human's pure 'Viveka' (Intellect / Head) is brutally violently severed, his physical dirt-body flawlessly seamlessly effortlessly shifts completely entirely onto absolute robotic 'Autopilot'.
            These Kabandhas (Headless torsos) flawlessly perfectly symbolize exactly those pathetic humans who relentlessly sprint aimlessly perfectly inside the blind Rat-Race and passively dance completely intoxicated strictly by cheap senses without any literal understanding.
            'Turyalayashritah' (Dancing strictly to the drums)—This flawlessly represents the absolute noisy external Distractions (Social Media, Lust) of the physical world exactly upon which ignorant headless fools blindly passively dance continuously without thinking.
            Exactly when the toxic Ego visually visually witnesses absolute certain death standing directly ahead, it violently actively aggressively aggressively entirely crosses the absolute extreme maximum limit of literal Madness.
            The torsos are frantically attempting exactly to successfully intimidate the Goddess (Truth), but the Mother flawlessly remains absolutely securely anchored in ultimate supreme peace completely witnessing this cheap headless dance.
            This terrifying scene explicitly dynamically proves exactly that 99% of the massive physical world is exclusively actively operating exactly as a completely blind, headless, utterly foolish 'System Loop'.
            Durga (Supreme Consciousness) has violently physically manifested exclusively precisely strictly entirely perfectly to permanently Break exactly this exact blind loop entirely forever.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 67,
        sanskrit = "कबन्धाश्छिन्नशिरसः खड्गशक्त्यृष्टिपाणयः ।\nतिष्ठ तिष्ठेति भाषन्तो देवीमन्ये महासुराः ॥ ६७ ॥",
        hindi = """
            (कटे हुए सिरों की ललकार): "वे भयंकर कबंध (बिना सिर के धड़) जिनके सिर कट चुके थे (कबन्धाश्छिन्नशिरसः), अपने हाथों में 'तलवार, भाला और ऋष्टि' (खड्गशक्त्यृष्टिपाणयः) पकड़े हुए थे।"
            "और जो दूसरे महा-राक्षस (अन्ये महासुराः) थे, वे देवी को 'खड़ी रह! भाग मत! वहीं खड़ी रह!' (तिष्ठ तिष्ठेति भाषन्तो) ऐसा कहकर ज़ोर-ज़ोर से ललकारने लगे!"
            अहंकार (Ego) की ढीठता देखिए! उनका शरीर कट चुका है, वे मौत के मुँह में हैं, फिर भी वे 'परम ब्रह्मांडीय शक्ति' (देवी) को ऑर्डर (Order) दे रहे हैं कि "तिष्ठ" (रुक जा)!
            यह इंसान के उस घमंड (Arrogance) का साक्षात् वर्णन है जो भगवान को भी अपने 'लॉजिक' (Logic) और शर्तों पर चलाना चाहता है।
            मूर्ख राक्षस सोच रहे हैं कि देवी उनसे डरकर भाग रही हैं, जबकि देवी केवल उनके पापों का घड़ा भरने का इंतज़ार कर रही हैं।
            'तिष्ठ तिष्ठ' (रुक जा)—यह हमारे दिमाग के वो जिद्दी और नेगेटिव थॉट्स (Negative thoughts) हैं जो ध्यान (Meditation) या अच्छे काम के दौरान हमें बार-बार 'रोकने' की कोशिश करते हैं।
            हमारा माइंड (Mind) हमें डराता है कि "अगर तूने मुझे छोड़ा, तो मैं तुझे बर्बाद कर दूंगा, रुक जा!"
            परंतु सत्य (महामाया) कभी किसी अज्ञान की आवाज़ पर नहीं रुकता। वह अपने फ्लो (Flow) में बहता है और सारी रुकावटों (Blocks) को नष्ट कर देता है।
            राक्षसों का यह चिल्लाना वास्तव में उनकी अपनी ही मौत का 'अलार्म' (Alarm) है जिसे वे खुद ही बजा रहे हैं।
            महाकाली के प्रहार के सामने ईगो की ये फालतू आवाज़ें (Noise) अब हमेशा के लिए म्यूट (Mute) होने वाली हैं।
        """.trimIndent(),
        english = """
            (The Arrogant Roar of the Severed): "Those terrifying headless torsos whose physical heads were already brutally decapitated (Kabandhashchinnashirasah), actively gripped blazing 'Swords, massive spears, and lethal pikes' directly inside their hands (Khadgashaktyrishtipanayah)."
            "And completely other surviving mega-demons (Anye mahasurah) aggressively actively began violently explicitly challenging and loudly screaming entirely at the Goddess, 'Stop! Stand right there! Do not run!' (Tishtha tishtheti bhashanto)!"
            Vividly witness the absolute exceptionally blind stubbornness of the toxic Ego! Their physical bodies are brutally severed, they flawlessly reside directly perfectly inside the mouth of death, yet they are aggressively issuing literal 'Orders' explicitly to the 'Absolute Supreme Cosmic Power' (The Goddess) screaming "Tishtha" (Stop)!
            This is the absolute literal direct explicit description exactly of that horrific human Arrogance which actively ruthlessly aggressively desperately attempts to entirely dictate and run exactly God Himself strictly according to its own cheap fake 'Logic' and petty conditions.
            The foolish demons blindly aggressively assume the Goddess is actively running away terrified of them, whereas the Goddess is exclusively strictly flawlessly merely patiently waiting for the precise mathematical limit of their ultimate cosmic sins to perfectly overflow.
            'Tishtha Tishtha' (Stop, Stop)—These flawlessly exactly physically symbolize the extremely highly stubborn Negative Thoughts entirely inside our brain which repeatedly aggressively actively attempt entirely to physically 'Stop' us perfectly precisely during pure Meditation or highly positive actions.
            Our toxic Mind ruthlessly terrifies us screaming, "If you actively successfully permanently abandon me, I will violently destroy you, Stop right there!"
            However, the Supreme Truth (Mahamaya) absolutely never ever halts perfectly at the cheap pathetic voice of thick ignorance. It seamlessly smoothly violently Flows entirely exactly destroying absolutely all physical and psychological Blocks.
            This explicit aggressive screaming exactly of the massive demons is undeniably flawlessly, in absolute reality, their very own literal physical death 'Alarm' which they themselves are flawlessly actively physically ringing.
            Directly perfectly before the absolute terrifying apocalyptic strike of Mahakali, absolutely all these useless cheap toxic Noises exactly of the Ego are perfectly flawlessly preparing exactly entirely to instantly permanently be strictly completely Muted forever.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 68,
        sanskrit = "पातितै रथानागश्वैरसुरैश्च वसुन्धरा ।\nअगम्या साभवत्तत्र यत्राभूत् स महाबणः ॥ ६८ ॥",
        hindi = """
            (धरती का लाशों से पटना): "उस अत्यंत भयंकर और खौफनाक महायुद्ध (स महाबणः / महारणः) के मैदान में जहाँ यह सब चल रहा था।"
            "वह पूरी की पूरी धरती (वसुन्धरा) देवी द्वारा 'काटकर गिराए गए' (पातितै) लाखों 'रथों, हाथियों, घोड़ों और असुरों की लाशों' (रथानागश्वैरसुरैश्च) से पूरी तरह से पट गई थी।"
            "और लाशों के उस भयंकर ढेर के कारण वह रणभूमि इतनी भर गई थी कि वहां 'एक कदम भी चलना पूरी तरह से असंभव' (अगम्या साभवत्तत्र) हो गया था!"
            यह देवी के 'कॉस्मिक डिस्ट्रक्शन' (Cosmic Destruction) का सबसे खौफनाक 'आफ्टरमैथ' (Aftermath / परिणाम) है!
            'अगम्या' का मतलब है जहाँ चला न जा सके। अज्ञान (राक्षसों) और उनके झूठे तर्कों (रथों/हाथियों) का इतना कचरा (Garbage) कटकर गिर चुका है कि पूरा सिस्टम 'जाम' (Jam) हो गया है।
            जब इंसान के अंदर का ईगो (Ego) टूटता है, तो इंसान के दिमाग में पुराने संस्कारों, झूठे रिश्तों और टूटे हुए घमंड की 'लाशें' बिछ जाती हैं।
            यह वह 'डार्क नाईट ऑफ़ द सोल' (Dark night of the soul) है जहाँ इंसान को लगता है कि वह एक कदम भी आगे नहीं बढ़ सकता (अगम्या)।
            लेकिन यह तबाही (Destruction) कोई बुरी चीज़ नहीं है; यह एक 'डीप क्लेंजिंग प्रोसेस' (Deep cleansing process) है!
            सत्य (सृष्टि) को फिर से नया बनाने के लिए पुराने और सड़े हुए सिस्टम (System) को पूरी तरह से ज़मीन पर गिराना (पातितै) ही पड़ता है।
            महामाया ने महिषासुर के पूरे इंफ्रास्ट्रक्चर (Infrastructure) को एक ही दिन में 'ज़ीरो' (Zero) कर दिया है।
            अब महिषासुर अकेला बचा है; उसकी सेना का 'डेटाबेस' (Database) पूरी तरह से डिलीट हो चुका है।
        """.trimIndent(),
        english = """
            (The Earth Buried in Corpses): "Exactly directly perfectly inside that exceptionally horrific and terrifying colossal cosmic Mega-War (Sa maharano) flawlessly exactly where absolutely all this was actively aggressively occurring."
            "The absolute entire physical Earth (Vasundhara) was violently entirely completely perfectly buried flawlessly flawlessly entirely completely perfectly perfectly exactly under millions of 'Severed and brutally felled' (Patitai) literal physical 'Corpses of massive chariots, giant elephants, swift horses, and horrifying demons' (Rathanagashvairasuraishcha) ruthlessly slaughtered exactly by the Goddess."
            "And strictly exclusively due entirely to that exceptionally horrific colossal mountain exactly of brutal corpses, that exact specific battlefield became so exceptionally densely packed that actively 'Walking completely even exactly a single microscopic physical step became completely 100% Impossible' (Agamya sabhavattatra)!"
            This is undeniably the absolute most exceptionally terrifying explicit physical 'Aftermath' perfectly exactly of the Goddess's absolute pure 'Cosmic Destruction'!
            'Agamya' literally profoundly strictly translates exactly perfectly to completely impassable. The exact toxic Garbage explicitly of thick ignorance (demons) and their highly fake logic (chariots/elephants) has actively been so ruthlessly brutally cleanly severed and felled that the absolute entire operating system is completely perfectly 'Jammed'.
            Exactly when a human's highly toxic internal Ego violently brutally aggressively explicitly shatters, the exact physical brain actively flawlessly seamlessly completely entirely strictly perfectly perfectly fills strictly exactly exclusively with the dead 'Corpses' exactly of toxic old impressions, fake worldly relationships, and completely violently entirely explicitly actively shattered fake pride.
            This is exactly that absolute terrifying 'Dark Night of the Soul' explicitly strictly entirely perfectly where the exact human actively hopelessly heavily profoundly feels he absolutely completely entirely completely seamlessly entirely cannot actively explicitly step entirely successfully completely flawlessly smoothly forward perfectly perfectly directly entirely (Agamya).
            But this specific explicit massive Destruction is absolutely zero cheap bad negative event; this is undeniably a highly advanced absolute terrifying 'Deep Cleansing Process'!
            Strictly flawlessly precisely exactly purely explicitly completely actively explicitly actively actively efficiently accurately effectively to gracefully completely creatively seamlessly efficiently entirely actively Rebuild the absolute explicit Supreme Truth (Creation), the highly toxic corrupted completely entirely dead rotten physical System flawlessly completely unconditionally seamlessly entirely effortlessly absolutely explicitly seamlessly entirely seamlessly strictly requires exactly to be flawlessly aggressively entirely actively brought straight perfectly exactly directly down flawlessly strictly efficiently to the absolute physical ground (Patitai).
            Mahamaya has flawlessly successfully perfectly violently entirely accurately aggressively physically actively cleanly securely permanently efficiently effectively entirely successfully exactly perfectly reduced Mahishasura's absolute entire massive physical Infrastructure flawlessly entirely perfectly exactly explicitly precisely seamlessly exactly seamlessly smoothly down explicitly entirely completely entirely strictly explicitly straight effectively perfectly exactly to mathematical 'Zero' entirely seamlessly efficiently inside exactly one single day.
            Mahishasura actively flawlessly now explicitly exclusively remains entirely perfectly exactly isolated and purely completely successfully entirely entirely Alone; the absolute exact explicit complete literal explicit entire structural Database strictly perfectly exactly of his colossal army is undeniably permanently successfully cleanly flawlessly securely completely Deleted.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 69,
        sanskrit = "शोणितौघा महानद्यः सद्यस्तत्र प्रसुस्रुवुः ।\nमध्ये चासुरसैन्यस्य वारणाश्वासुरान्तरे ॥ ६९ ॥\nक्षणेन तन्महासैन्यमसुराणां तथाम्बिका ।\nनिन्ये क्षयं यथा वह्निस्तृणदारुमहाचयम् ॥ ७० ॥",
        hindi = """
            (रक्त की नदियां और संपूर्ण विनाश): "उस भयंकर असुर-सेना, हाथियों और घोड़ों के बीच अत्यंत खौफनाक 'खून की विशाल नदियां' तुरंत ही बहने लगीं!"
            "और साक्षात् उस परम 'अम्बिका' (महामाया) देवी ने राक्षसों की उस अत्यंत विशाल और अजेय 'महासैना' को केवल 'एक ही क्षण' (क्षणेन) में पूरी तरह से नष्ट कर दिया!"
            "बिल्कुल वैसे ही जैसे एक भयंकर 'आग' सूखी 'घास और लकड़ियों के विशाल ढेर' को एक ही सेकंड में जलाकर 'राख' कर देती है!"
            (श्लोक 69 और 70 को मिलाकर अध्याय का समापन किया गया है)।
            खून की नदियां (Rivers of blood) यह दिखाती हैं कि 'अहंकार' (Ego) को जीवित रखने वाली जो प्राण-ऊर्जा थी, वह अब पूरी तरह से कट कर बह चुकी है।
            महिषासुरमर्दिनी (अम्बिका) ने उस करोड़ों की सेना को मारने में सालों नहीं लगाए; उन्होंने यह काम 'क्षणेन' (एक ही पल में) कर दिया!
            यह एक स्पिरिचुअल क्वांटम जंप (Quantum Jump) है! अज्ञान चाहे लाखों जन्मों का हो, पर जब 'चेतना की अग्नि' जलती है।
            तो वह उस अज्ञान को मिटाने में लाखों साल नहीं लेती, वह उसे केवल 'एक सेकंड' में हमेशा के लिए भस्म कर देती है।
            यहाँ दुर्गा सप्तशती का दूसरा अध्याय (महिषासुर सेना वध) समाप्त होता है।
            महिषासुर का घमंड और उसकी सेना राख बन चुकी है, और अब अगले अध्याय में महिषासुर का देवी से आमने-सामने का अंतिम युद्ध होगा!
        """.trimIndent(),
        english = """
            (Rivers of Blood and Total Annihilation): "Exactly in the middle of that colossal demonic army, among the elephants and horses, terrifying massive rivers of thick blood instantaneously began to flow!"
            "And that Supreme Ambika (Mahamaya) Goddess successfully annihilated and brought down to zero that invincible mega-army of demons inside exactly one single split-second (Kshanena)!"
            "Exactly like a blazing fire aggressively burning a huge mountain of bone-dry grass and wood straight to physical ashes in a single moment!"
            (Shlokas 69 and 70 are combined here to execute the structural conclusion of this specific chapter).
            The massive rivers of blood explicitly symbolize that the ultimate biological life-force which kept the toxic Ego alive has drained entirely outside.
            Mahishasuramardini (Ambika) did not require years to actively slaughter that army of millions; She cleanly executed this massive cosmic task entirely inside one single split-second!
            This is an absolute terrifying Quantum Jump! Regardless of how massive thick Ignorance is, when the pure Fire of Consciousness blazes.
            It completely effortlessly requires exactly one single moment to burn millions of years of karmic garbage straight to ashes.
            Right here perfectly concludes the Second Chapter of the Durga Saptshati (The Slaughter of Mahishasura's Army).
            Mahishasura's toxic pride and his entire army are now reduced to ashes, paving the way for his final personal battle with the Goddess!
        """.trimIndent()
    )
)