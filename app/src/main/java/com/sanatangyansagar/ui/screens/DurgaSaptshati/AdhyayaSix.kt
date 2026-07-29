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
fun AdhyayaSixScreen() {
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
                    val targetIndex = adhyayaSixShlokas.indexOfFirst { it.id == targetId }
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
            label = { Text("Search Shloka (1-24)") },
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
            itemsIndexed(adhyayaSixShlokas) { _, shloka ->
                SaptshatiCard(shloka = shloka)
            }
        }
    }
}

// Data List - Adhyaya 6 (Complete 1 to 24)
val adhyayaSixShlokas = listOf(
    SaptshatiShloka(
        id = 1,
        sanskrit = "ऋषिरुवाच ॥ १ ॥\nइत्यकर्ण्य वचो देव्याः स दूतोऽमर्षपूरितः ।\nसमाचष्ट समागत्य दैत्यराजाय विस्तरात् ॥ २ ॥",
        hindi = """
            (दूत की वापसी): "ऋषि मेधा ने कहा: देवी के चुनौतीपूर्ण वचनों को सुनकर वह दूत क्रोध से भर गया।"
            "वह तुरंत दैत्यराज शुम्भ के पास पहुँचा और उसने सारा हाल विस्तार से कह सुनाया।"
            "दूत के मन में 'अमर्ष' (क्रोध और जलन) था क्योंकि देवी ने अहंकार को ललकारा था।"
            "अहंकार का दूत (सुग्रीव) असल में हमारे दिमाग के 'रिएक्टिव' विचारों का प्रतीक है।"
            "जब सत्य हमें आईना दिखाता है, तो हमारे विचार गुस्से में प्रतिक्रिया (React) करते हैं।"
            "शुम्भ को सब कुछ 'विस्तरात्' (विस्तार से) बताना यह दर्शाता है कि अज्ञान अपनी हार नहीं छुपाता।"
            "वह अपनी चोट खाई हुई 'अना' (Ego) को और ज़्यादा भड़काने के लिए मिर्च-मसाला लगाता है।"
            "दूत की रिपोर्टिंग ने महल के शांत वातावरण को युद्ध की ज्वाला में बदल दिया था।"
            "यही वह क्षण है जब अहंकार अब 'डिप्लोमेसी' छोड़कर सीधे 'हिंसा' का रास्ता चुनता है।"
            "अज्ञान अब अपनी पूरी ताकत से उस शक्ति को कुचलने की योजना बनाने लगा है।"
        """.trimIndent(),
        english = """
            (The Messenger's Return): "The Sage Medha declared: Hearing the Goddess's challenging words, the messenger was filled with wrath."
            "He instantaneously returned to the Demon King Shumbha and narrated the entire sequence in detail."
            "The messenger's mind was flooded with 'Amarsha' (indignation) because Truth had challenged the Ego."
            "The messenger Sugriva represents the 'Reactive' thought patterns within our complex human psyche."
            "Whenever Absolute Truth mirrors our flaws, our immediate thoughts react with aggressive defensiveness."
            "Narrating everything 'Vistarath' (In detail) shows how ignorance feeds its own destructive narrative."
            "It amplifies the perceived insult to further agitate the already wounded toxic sense of pride."
            "The messenger's report successfully transformed the palace's atmosphere into a literal psychological war-zone."
            "This marks the exact transition where Arrogance abandons diplomacy for direct and raw violence."
            "Thick ignorance is now actively planning to utilize its maximum force to crush the Divine Power."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 2,
        sanskrit = "तस्य दूतस्य तद्वाक्यमाकर्ण्य दनुजेश्वरः ।\nसक्रोधः प्राह दैत्यानामधिपं धूम्रलोचनम् ॥ ३ ॥",
        hindi = """
            (धूम्रलोचन को आदेश): "दूत की बातें सुनकर दानवों का राजा शुम्भ भयंकर क्रोध से जल उठा।"
            "उसने तुरंत दैत्यों के सेनापति 'धूम्रलोचन' को बुलाया और उसे प्रलयंकारी आदेश दिया।"
            "धूम्रलोचन (Dhumralochana) का अर्थ है—वह जिसकी आँखों में 'धुआं' (Smoke) भरा हुआ हो।"
            "यह उस 'भ्रम' का प्रतीक है जो सच को देखने की क्षमता खो चुका है और केवल धुंध देखता है।"
            "शुम्भ का 'सक्रोध' होना यह बताता है कि अहंकार कभी भी शांत रहकर फैसला नहीं ले पाता।"
            "वह अपने सेनापति (मानसिक वृत्ति) को सत्य को मिटाने के लिए युद्ध के मैदान में भेज रहा है।"
            "अज्ञान हमेशा सबसे पहले अपने 'भ्रम' को भेजता है ताकि वह वास्तविकता को ढक सके।"
            "जब इंसान गुस्से में होता है, तो उसकी 'दृष्टि' धूम्रलोचन की तरह धुंधली और पक्षपाती हो जाती है।"
            "शुम्भ को लग रहा है कि एक सेनापति ही उस महाशक्ति को पकड़ने के लिए काफी होगा।"
            "यहीं से उस विनाशकारी यात्रा की शुरुआत होती है जो सीधे मौत के दरवाजे पर खुलती है।"
        """.trimIndent(),
        english = """
            (Command to Dhumralochana): "Listening to the messenger's report, Shumbha, the lord of demons, erupted in blazing rage."
            "He immediately summoned the demonic general 'Dhumralochana' and issued a catastrophic military order."
            "'Dhumralochana' literally translates to 'The Smoky-Eyed One' or one with clouded vision."
            "He perfectly symbolizes the 'Delusion' that has lost the capacity to perceive the Absolute Truth."
            "Shumbha being 'Sakrodhah' (Enraged) proves that the Ego is incapable of rational decision-making."
            "He is dispatching his commander (mental tendency) to the battlefield to annihilate the Light."
            "Ignorance perpetually sends its 'Illusion' first to attempt to veil the underlying Reality."
            "When a human is consumed by wrath, his internal vision becomes identically smoky and biased."
            "Shumbha deludes himself into thinking a single general is sufficient to capture Infinite Power."
            "This marks the initiation of a destructive journey that leads straight to the gates of death."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 3,
        sanskrit = "हे धूम्रलोचनाशु त्वं स्वसैन्यपरिवारितः ।\nतामानय बलाद्दुष्टां केशाकर्षणविह्वलाम् ॥ ४ ॥",
        hindi = """
            (अपमानजनक आज्ञा): "शुम्भ ने चिल्लाकर कहा: 'हे धूम्रलोचन! तू अभी अपनी सेना के साथ वहाँ जा'।"
            "'और उस दुष्ट स्त्री को उसके 'बाल पकड़कर' घसीटते हुए ज़बरदस्ती मेरे पास लेकर आ'।"
            "यह अहंकार का 'चरम पतन' है—जहाँ वह पवित्रता को 'अपमानित' करने का सपना देखता है।"
            "बाल पकड़ना (Kesha-karshana) मर्यादा और गरिमा को पूरी तरह कुचलने का क्रूर संकेत है।"
            "अहंकार को लगता है कि वह 'बलाद्' (ताकत) से सत्य को अपना गुलाम और खिलौना बना सकता है।"
            "शुम्भ देवी को 'दुष्टा' कह रहा है, जो यह साबित करता है कि अज्ञानी को सत्य हमेशा कड़वा ही लगता है।"
            "यह आदेश शुम्भ की मानसिक अस्थिरता और उसके गहरे डर को छिपाने का एक नाकाम तरीका है।"
            "जब इंसान अपनी सीमाएं भूलकर 'शक्ति' पर हाथ डालता है, तो उसका अंत सुनिश्चित हो जाता है।"
            "अज्ञान अब सुंदरता को 'भोगने' के लिए उसे शारीरिक चोट पहुँचाने की धमकी दे रहा है।"
            "धूम्रलोचन के लिए यह आदेश उसकी अपनी चिता सजाने के निमंत्रण के समान था।"
        """.trimIndent(),
        english = """
            (The Insulting Order): "Shumbha shouted: 'O Dhumralochana! Go there right now with your massive army'."
            "'And bring that wicked woman to me by Force, dragging Her by Her 'Hair' till She is broken'."
            "This represents the 'Absolute Fall' of arrogance—where it attempts to publicly Humiliate Purity."
            "Pulling the hair is a brutal symbol of crushing human dignity, integrity, and sacred honor."
            "Arrogance falsely believes that through 'Brute Force', it can enslave and objectify the Absolute Truth."
            "Calling the Goddess 'Wicked' proves that to a corrupted mind, Truth perpetually appears repulsive."
            "This command is a futile attempt by Shumbha to mask his mounting instability and internal fear."
            "The moment a human forgets their cosmic limits and attacks 'Shakti', their end is guaranteed."
            "Ignorance is now threatening to physically wound Beauty strictly to satisfy its hedonistic cravings."
            "For Dhumralochana, this specific order was equivalent to an invitation to light his own funeral pyre."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 4,
        sanskrit = "तत्परित्राणदः कश्चिद्यदि वोत्तिष्ठतेऽपरः ।\nस हन्तव्योऽमरो वापि यक्षो गन्धर्व एव वा ॥ ५ ॥",
        hindi = """
            (विरोधियों का संहार): "'यदि उसकी रक्षा के लिए कोई दूसरा देवता, यक्ष या गन्धर्व खड़ा हो जाए'।"
            "'तो उसे भी बिना किसी दया के तुरंत मौत के घाट उतार देना (स हन्तव्यो)'।"
            "अहंकार अब पूरी तरह से 'डिस्ट्रक्टिव मोड' (Destructive Mode) में आ चुका है।"
            "वह किसी भी ऐसी शक्ति को बर्दाश्त नहीं करना चाहता जो सत्य (देवी) का पक्ष ले।"
            "देवता और गन्धर्व हमारे अंदर के 'शुभ विचारों' और 'सृजनात्मकता' (Creativity) के प्रतीक हैं।"
            "अहंकार चाहता है कि इंसान के अंदर की हर अच्छी चीज़ को जड़ से खत्म कर दिया जाए।"
            "शुम्भ को लगता है कि उसकी साठ हज़ार की सेना के सामने ब्रह्मांड की कोई शक्ति नहीं टिकेगी।"
            "यह श्लोक उस 'आइसोलेशन' को दिखाता है जहाँ बुराई सबको डराकर अकेला कर देना चाहती है।"
            "परंतु वह मूर्ख नहीं जानता कि जो सबका आधार है, उसकी रक्षा के लिए किसी और की ज़रूरत नहीं।"
            "शुम्भ की यह धमकी वास्तव में उसकी अपनी चेतना के पूर्ण विनाश की गूँज है।"
        """.trimIndent(),
        english = """
            (Total Annihilation): "'If anyone else—be it a God, Yaksha, or Gandharva—rises for Her protection'."
            "'Then slaughter them instantaneously without an atom of mercy or hesitation'."
            "Arrogance has now successfully entered its absolute 'Total Destruction Mode' across the cosmos."
            "It refuses to tolerate any psychological force that aligns itself with the Absolute Truth (Goddess)."
            "Gods and Gandharvas symbolize our 'Auspicious Intentions' and internal 'Creativity' and joy."
            "Arrogance desires to permanently uproot and destroy every single positive trait within the human system."
            "Shumbha deludes himself into thinking his army can withstand every singular power in the universe."
            "This verse illustrates the tactic of 'Isolation' where evil attempts to frighten everyone into submission."
            "However, the fool ignores that the one who is the Foundation of all requires zero external support."
            "Shumbha's lethal threat is actually the echo of his own soul's impending and total annihilation."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 5,
        sanskrit = "ऋषिरुवाच ॥ ६ ॥\nतेनाज्ञप्तस्ततः सोऽपि दैत्यो धूम्रलोचनः ।\nययौ सैन्येन महता वृतः षष्ट्या सहस्रकैः ॥ ७ ॥",
        hindi = """
            (धूम्रलोचन का कूच): "महर्षि मेधा ने कहा: शुम्भ की आज्ञा पाकर वह दैत्य धूम्रलोचन तुरंत युद्ध के लिए निकला।"
            "वह अपने साथ 'साठ हज़ार' (षष्ट्या सहस्रकैः) असुरों की एक विशाल सेना लेकर हिमालय की ओर गया।"
            "साठ हज़ार की सेना हमारे दिमाग में चलने वाले उन हज़ारों 'भ्रमित विचारों' का प्रतीक है।"
            "धूम्रलोचन (धुआं) हमेशा 'संख्या' (Quantity) पर भरोसा करता है क्योंकि उसके पास 'क्वालिटी' नहीं है।"
            "जब इंसान के अंदर अज्ञान जागता है, तो वह हज़ारों कुतर्क लेकर सच्चाई पर हमला करता है।"
            "हिमालय की ओर जाना मतलब 'उच्च चेतना' (Higher Consciousness) को कुचलने का एक नाकाम प्रयास है।"
            "असुरों की यह भीड़ उस 'मानसिक शोर' की तरह है जो मन की शांति को पूरी तरह भंग करना चाहती है।"
            "शुम्भ के आदेश का पालन करना यह दिखाता है कि अज्ञान हमेशा अहंकार का अंधा गुलाम होता है।"
            "साठ हज़ार सैनिक उस 'नकारात्मक नेटवर्क' को दर्शाते हैं जो पूरे मन को धीरे-धीरे घेर लेता है।"
            "अब वह समय आ गया है जहाँ संख्या बल का सामना 'परम दिव्य शक्ति' से होने वाला है।"
        """.trimIndent(),
        english = """
            (The March of Ignorance): "The Sage Medha said: Receiving Shumbha's command, the demon Dhumralochana immediately marched."
            "He headed toward the Himalayas surrounded by a colossal army of 'Sixty Thousand' warriors."
            "The army of sixty thousand symbolizes the thousands of 'Confused Thoughts' swarming a human mind."
            "Dhumralochana (Smoke) perpetually relies on 'Quantity' because he lacks the 'Quality' of Truth."
            "When ignorance awakens within a human, it attacks with thousands of fallacies to overwhelm the Truth."
            "Marching toward the Himalayas represents a futile attempt to crush the state of Higher Consciousness."
            "This demonic crowd is like the 'Mental Noise' that desperately seeks to shatter absolute inner peace."
            "Following Shumbha's order proves that ignorance always operates as a pathetic slave to the central ego."
            "Sixty thousand soldiers illustrate the 'Negative Network' that has successfully surrounded the entire mind."
            "The hour has arrived where raw numbers will finally confront the absolute singular Divine Power."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 6,
        sanskrit = "स दृष्ट्वा तां ततो देवीं हिमवन्तं व्यवस्थिताम् ।\nजगादोच्चैः प्रयाहीति शुम्भनिशुम्भयोः अन्तिकम् ॥ ८ ॥",
        hindi = """
            (असुर की ललकार): "हिमालय पर विराजमान उस परम देवी को देखकर धूम्रलोचन ने अहंकार में दहाड़ लगाई।"
            "उसने ज़ोर से चिल्लाकर कहा—'अरे! तू अभी इसी वक्त शुम्भ और निशुम्भ के पास चल'।"
            "धूम्रलोचन की आँखों में धुआं भरा है, इसलिए उसे देवी का 'दिव्य प्रकाश' दिखाई नहीं दिया।"
            "अज्ञानी व्यक्ति साक्षात् प्रलय को सामने देखकर भी अपनी 'अकड़' (Arrogance) नहीं छोड़ पाता।"
            "चिल्लाना (Jagada-uchhaih) कमज़ोर मन की निशानी है जो शोर से अपनी ताकत साबित करना चाहता है।"
            "वह देवी को 'आदेश' दे रहा है, जो कि ब्रह्मांड का सबसे बड़ा मज़ाक (Cosmic Joke) है।"
            "अहंकार को लगता है कि उसकी आवाज़ की ऊँचाई सत्य के सामने उसे बड़ा बना सकती है।"
            "वह देवी को केवल एक 'पकड़ी जाने वाली वस्तु' समझ रहा है, जो किसी राजा की संपत्ति होनी चाहिए।"
            "यह श्लोक उस 'अंधे साहस' का प्रतीक है जो केवल और केवल गहरी मूर्खता से पैदा होता है।"
            "धूम्रलोचन ने अपनी पहली और आखिरी गलती कर दी है—उसने साक्षात् 'शक्ति' को ललकारा है।"
        """.trimIndent(),
        english = """
            (The Demon's Challenge): "Spotting the Supreme Goddess residing upon the Himalayas, Dhumralochana roared with extreme arrogance."
            "He shouted at the absolute peak of his voice—'Depart right this moment to Shumbha and Nishumbha'."
            "Dhumralochana has smoke in his eyes, which is why he failed to perceive the Divine Radiance."
            "An ignorant person does zero to abandon his 'Stiffness' even when facing absolute certain destruction."
            "Shouting loudly is a sign of a weak psychological state attempting to prove a fake dominance."
            "He is issuing a 'Command' to the Goddess, which is undeniably the greatest Cosmic Joke in existence."
            "Arrogance falsely believes that the volume of its voice can successfully force Absolute Truth to bow."
            "He perceives the Goddess as a mere 'Object to be Captured' who rightfully belongs to a palace."
            "This verse symbolizes that 'Blind Courage' which originates strictly from deep-seated intellectual stupidity."
            "Dhumralochana has successfully committed his final mistake—he has challenged the absolute Primal Power."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 7,
        sanskrit = "न चेत्प्रीत्या भवती मदभर्तारमुपैष्यति ।\nततो बलान्नयाम्येतां केशाकर्षणविह्वलाम् ॥ ९ ॥",
        hindi = """
            (हिंसा की धमकी): "'यदि तू प्रेमपूर्वक मेरे स्वामी शुम्भ के पास नहीं चलेगी (न चेत् प्रीत्या)'।"
            "'तो मैं तुझे यहाँ से 'बाल पकड़कर' घसीटते हुए और 'बलपूर्वक' उठा ले जाऊंगा'।"
            "धूम्रलोचन वही भाषा बोल रहा है जो उसके मालिक शुम्भ ने उसे रटाकर भेजी थी।"
            "यह दिखाता है कि अज्ञान के विचार (Thought) हमेशा केंद्रीय अहंकार (Ego) की ही नकल होते हैं।"
            "बुराई के लिए प्रेम का अर्थ केवल 'टोटल सरेंडर' और 'मानसिक गुलामी' (Slavery) स्वीकार करना होता है।"
            "ज़बरदस्ती ले जाने की धमकी देना इंसान की उस 'पाश्विक वृत्ति' (Animalistic Nature) को दर्शाता है।"
            "जब कोई तर्क काम नहीं आता, तो अज्ञान 'शारीरिक हिंसा' का सहारा लेने की कोशिश करता है।"
            "धूम्रलोचन को पूरा भरोसा है कि वह अपनी विशाल सेना के दम पर एक 'नारी' को डरा लेगा।"
            "वह यह भूल गया है कि वह उस माँ को धमकी दे रहा है जो एक पल में पूरे ब्रह्मांड को मिटा सकती है।"
            "यह अहंकार का वह 'विनाशकारी भ्रम' है जो उसे सीधी मौत के मुंह में धकेल रहा है।"
        """.trimIndent(),
        english = """
            (Threat of Violence): "'If You do zero go affectionately to my master Shumbha voluntarily right now'."
            "'Then I shall forcefully carry You away, dragging You by Your hair until You are shattered'."
            "Dhumralochana is repeating the exact linguistic patterns taught to him by his toxic master Shumbha."
            "This proves that the thoughts of ignorance are merely pathetic 'Copies' of the central human ego."
            "For evil, the word 'Love' strictly translates to 'Total Unconditional Slavery' and mental bondage."
            "Threatening to take Her by force reveals the absolute 'Animalistic Nature' inherent in a corrupted mind."
            "When all logical reasoning fails, thick ignorance desperately attempts to utilize 'Physical Violence' to succeed."
            "Dhumralochana is entirely confident that his massive army can successfully terrorize a 'Lone Woman'."
            "He has forgotten that he is threatening the Mother who can incinerate the cosmos in a split-second."
            "This represents the fatal 'Overconfidence' of arrogance that is driving it straight into the mouth of death."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 8,
        sanskrit = "देव्युवाच ॥ १० ॥\nदैत्येश्वरेण प्रहितो बली बलसमन्वितः ।\nयद्येवं बलवान् कश्चित्ततः किं करवाण्यहम् ॥ ११ ॥",
        hindi = """
            (देवी का व्यंग्य): "देवी ने बहुत ही शांति से कहा: 'अरे! तू तो दैत्यराज का भेजा हुआ अत्यंत शक्तिशाली योद्धा है'।"
            "'यदि तू वास्तव में इतना बलवान है और तेरे साथ इतनी बड़ी सेना है, तो फिर मैं 'अकेली' क्या करूँ?'"
            "देवी यहाँ फिर से 'विनम्रता' का अभिनय कर रही हैं, जिसे अज्ञानी कभी डिकोड नहीं कर पाएगा।"
            "वे धूम्रलोचन को यह महसूस करा रही हैं कि वह बहुत 'बड़ा' और 'अजेय' (Invincible) है।"
            "तन्त्र में इसे 'शत्रु का अहंकार बढ़ाना' कहते हैं, ताकि वह मानसिक रूप से 'असावधान' हो जाए।"
            "माता का यह कहना उस खौफनाक 'शांति' की तरह है जो प्रलय आने से ठीक पहले महसूस होती है।"
            "सत्य कभी भी मूर्ख से बहस नहीं करता, वह उसे उसकी ही मूर्खता में और गहरा डूबने देता है।"
            "धूम्रलोचन को लग रहा है कि देवी 'हार' मान रही हैं, जो कि उसकी ज़िंदगी की सबसे बड़ी गलतफहमी है।"
            "सत्य की 'नरमी' (Softness) ही अज्ञान के लिए सबसे घातक और खौफनाक जाल (Trap) साबित होगी।"
            "अब देवी वह प्रहार करने वाली हैं जो धूम्रलोचन के अस्तित्व के अणुओं को ही बिखेर देगा।"
        """.trimIndent(),
        english = """
            (The Divine Sarcasm): "The Goddess spoke with absolute calm: 'Oh! You are a powerful warrior sent by the Demon King'."
            "'If You are indeed so strong and possess such a massive army, then what can I, 'Alone', possibly do?'"
            "The Goddess is playing the role of 'Humility' once again, which ignorance can mathematically never decode."
            "She is making Dhumralochana feel exceptionally 'Large' and 'Invincible' in his own deluded mind."
            "In advanced Tantra, this is called 'Inflating the Enemy's Ego' to make them psychologically Careless."
            "Her calm response is like that terrifying 'Silence' that perpetually precedes a major cosmic apocalypse."
            "Truth never argues with a fool; it simply allows the fool to drown deeper in his own non-existent logic."
            "Dhumralochana deludes himself into thinking that the Goddess is 'Yielding', which is his final hallucination."
            "The 'Softness' of Absolute Truth is destined to prove as the most lethal and terrifying Trap for ignorance."
            "Now the Goddess is preparing to execute a strike that will scatter the very atoms of Dhumralochana's being."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 9,
        sanskrit = "ऋषिरुवाच ॥ १२ ॥\nइत्युक्तः सोऽभ्यधावत्तामसुरो धूम्रलोचनः ।\nहुङ्कारेणैव तं भस्म सा चकाराम्बिका तदा ॥ १३ ॥",
        hindi = """
            (हुंकार से वध): "ऋषि मेधा ने कहा: देवी के ऐसा कहते ही, वह असुर उन्हें पकड़ने के लिए पागलों की तरह दौड़ा।"
            "परंतु साक्षात् अम्बिका ने केवल एक भयंकर 'हुं' (Humkara) की ध्वनि की और वह असुर 'राख' हो गया!"
            "यह पूरी सप्तशती का सबसे 'मिरेकुलस' (Miraculous) और 'पावरफुल' क्षणों में से एक है।"
            "देवी ने न कोई तलवार चलाई, न कोई तीर—उन्होंने केवल अपनी 'आवाज़' (Sound Vibration) का उपयोग किया।"
            "'हुंकार' तन्त्र में वह 'अग्नि बीज' है जो किसी भी भौतिक पदार्थ को एक सेकंड में डी-मटेरियलाइज़ कर सकता है।"
            "धूम्रलोचन (भ्रम) का अंत केवल 'हुंकार' यानी चेतना की एक प्रचंड गर्जना से ही संभव है।"
            "जब इंसान 'मौन' होकर अपने अंदर की दिव्य ध्वनि सुनता है, तो उसका सारा अज्ञान राख बन जाता है।"
            "अहंकार की साठ हज़ार की सेना देखती रह गई और उनका लीडर केवल एक 'साँस' से 'डिलीट' हो गया।"
            "यह श्लोक सिद्ध करता है कि 'मैटर' (Matter) हमेशा 'माइंड' (Consciousness) के पूर्ण अधीन होता है।"
            "अज्ञान का सारा धुआं अब सत्य की प्रचंड अग्नि में हमेशा के लिए विलीन होकर शांत हो गया है।"
        """.trimIndent(),
        english = """
            (Vanquished by Sound): "The Sage said: The moment the Goddess finished speaking, the demon aggressively sprinted to capture Her."
            "However, Mother Ambika merely uttered a single terrifying sound of 'Hum' (Humkara), and he turned to 'Ashes'!"
            "This is undeniably one of the most 'Miraculous' and 'Powerful' moments in the entire text."
            "The Goddess utilized zero swords and zero arrows—She exclusively utilized the power of Her 'Sound Vibration'."
            "'Humkara' is the exact Fire Seed Mantra capable of De-materializing any physical object in a split-second."
            "The destruction of Dhumralochana (Delusion) is strictly possible only through the 'Roar of Consciousness'."
            "When a human attains 'Silence' and hears his internal divine sound, all thick ignorance turns to ashes."
            "The army of sixty thousand stood paralyzed as their leader was 'Deleted' by a mere vibration of air."
            "This specific verse proves that physical 'Matter' is perpetually the slave of Supreme 'Consciousness'."
            "The smoke of ignorance has now been permanently absorbed into the absolute and final fire of Truth."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 10,
        sanskrit = "अथ क्रुद्धं महासैन्यमसुराणां तथाम्बिका ।\nववर्ष सायकैस्तीक्ष्णैस्तथा शक्तिपरश्वधैः ॥ १४ ॥",
        hindi = """
            (सेना पर प्रहार): "अपने सेनापति को राख होते देखकर, राक्षसों की वह विशाल सेना भयंकर क्रोध में आ गई।"
            "तब माता अम्बिका ने उन पर तीखे बाणों, शक्तियों और फरसों (परश्वधैः) की मूसलाधार बारिश कर दी।"
            "जब अज्ञान का 'लीडर' मरता है, तो उसके पीछे के 'विचार' (सेना) अनियंत्रित और हिंसक हो जाते हैं।"
            "देवी अब केवल एक को नहीं, बल्कि अज्ञान के उस पूरे 'सिस्टम' (System) पर सीधा प्रहार कर रही हैं।"
            "बाण (Arrows) फोकस का प्रतीक हैं, और फरसा (Axe) बुराई की जड़ों को काटने का प्रतीक है।"
            "चेतना अब उन सभी हज़ारों नकारात्मक मनोवैज्ञानिक पैटर्न्स को एक साथ 'क्लीन' (Clean) कर रही है।"
            "राक्षसों का क्रोध उनकी लाचारी का सबूत है—वे समझ चुके हैं कि वे किसी अजेय शक्ति से लड़ रहे हैं।"
            "मूसलाधार बारिश की तरह अस्त्रों का गिरना यह बताता है कि सत्य का प्रहार 'अटूट' (Incessant) होता है।"
            "जब आध्यात्मिक शुद्धि (Cleansing) शुरू होती है, तो कोई भी छोटा विकार भी बच नहीं पाता है।"
            "अम्बिका अब रणभूमि में साक्षात् प्रलयंकारी अग्नि की तरह प्रचंड रूप में नाच रही हैं।"
        """.trimIndent(),
        english = """
            (Assault on the Army): "Seeing their commander reduced to ashes, that massive army of demons erupted in destructive wrath."
            "Then Mother Ambika unleashed a torrential rain of sharp 'Arrows', 'Spears', and 'Battle-axes' upon them."
            "Exactly when the 'Leader' of ignorance dies, the associated 'Thoughts' (the army) become chaotic and violent."
            "The Goddess is now attacking zero singular entity, but the entire underlying 'System' of thick ignorance."
            "Arrows symbolize absolute Focus, while the Battle-axe represents the power to Uproot the source of evil."
            "Consciousness is now simultaneously 'Cleaning' all those thousands of negative psychological patterns."
            "The wrath of the demons is the proof of their helplessness—they realize they face an invincible power."
            "The rain-like fall of weapons proves that the strike of Absolute Truth is perpetually 'Incessant' and unavoidable."
            "Once the process of spiritual 'Cleansing' initiates, mathematically zero mental distortions can survive Her gaze."
            "Ambika is now dancing in the battlefield like the absolute primary fire of a cosmic apocalypse."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 11,
        sanskrit = "ततः खड्गप्रहारैश्च छिन्नबाहुशिरोधराः ।\nतथान्ये च रणे मुक्ताः केशाकर्षणविह्वलाः ॥ १५ ॥",
        hindi = """
            (भयंकर वध): "देवी की तलवार के प्रहारों से उन असुरों की भुजाएं (बाहु) और मस्तक कट-कट कर गिरने लगे।"
            "कई राक्षसों के बाल पकड़कर माता ने उन्हें हवा में घुमाया और ज़मीन पर पटक कर मार डाला।"
            "यहाँ देवी वही 'केशाकर्षण' (बाल पकड़ना) वापस कर रही हैं जिसकी धमकी शुम्भ ने दी थी।"
            "यह 'लॉ ऑफ कर्मा' (Karmic Retribution) है—जो तुम दूसरों के साथ करोगे, वही तुम्हारे साथ होगा।"
            "भुजाओं का कटना मतलब इंसान की 'गलत काम करने की शक्ति' का पूरी तरह छिन जाना।"
            "सिर का कटना मतलब 'भ्रष्ट बुद्धि' और 'अहंकारी सोच' का हमेशा के लिए अंत हो जाना।"
            "रणभूमि अब अज्ञान के मलबे से भर चुकी थी, जहाँ एक-एक करके सारे मानसिक विकार मिटाए गए।"
            "देवी की तलवार (विवेक) इतनी तेज़ है कि वह भ्रम की सबसे गहरी परतों को भी एक पल में चीर देती है।"
            "अहंकार की सेना अब अपनी ही मौत के मंज़र को अपनी फटी आँखों से साक्षात् देख रही थी।"
            "सत्य का यह उग्र रूप अज्ञान को डराने के लिए नहीं, बल्कि उसे अज्ञान से 'आज़ाद' करने के लिए है।"
        """.trimIndent(),
        english = """
            (The Bloody Retribution): "By the strikes of the Goddess's sword, the 'Arms' and 'Heads' of demons were severed instantly."
            "Mother grabbed many monsters by their hair, swung them, and slammed them to their absolute death."
            "Here, the Goddess is returning the exact same 'Hair-pulling' that Shumbha had previously threatened."
            "This represents the absolute law of 'Karmic Retribution'—whatever You intend for others, You shall receive."
            "Severing the arms symbolizes the total loss of the 'Power to execute wrong and toxic actions'."
            "Severing the heads represents the permanent end of the 'Corrupted Thought Process' and toxic intelligence."
            "The battlefield was now filled with the debris of ignorance, where every distortion was being erased."
            "The Goddess's sword (Wisdom) is so exceptionally sharp that it pierces the deepest layers of delusion."
            "The army of arrogance was now witnessing its own brutal annihilation with its own terrified eyes."
            "This fierce format of Truth is intended zero to terrorize, but strictly to 'Liberate' the soul."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 12,
        sanskrit = "तथा परे च मथिताः शूलाग्रेण विदारिताः ।\nमुष्टिप्रहारैश्च परे पतिता धरणीतले ॥ १६ ॥",
        hindi = """
            (हाथों से संहार): "कई असुरों को माता ने अपने त्रिशूल की नोक (शूलाग्रेण) से चीर कर बीच से फाड़ दिया।"
            "बाकी बचे हुए राक्षसों को देवी ने अपने मुक्कों (Fists) के भयंकर प्रहार से ज़मीन पर सुला दिया।"
            "त्रिशूल की नोक 'पिन-पॉइंट एक्यूरेसी' (Precision) का प्रतीक है—हर बुराई का एक खास इलाज होता है।"
            "मुक्कों से मारना (Fist strikes) देवी के उस 'रा' (Raw) पराक्रम को दिखाता है जिसे अज्ञान सह नहीं सकता।"
            "जब शब्द और तर्क पूरी तरह खत्म हो जाते हैं, तो चेतना अपने 'डायरेक्ट एक्शन' (Direct Action) से काम लेती है।"
            "धरणीतले (धरती पर) गिरना अहंकार के पूर्ण और अंतिम 'पतन' (Fall) का सबसे बड़ा प्रतीक है।"
            "असुरों को कुचलना यह बताता है कि सत्य के सामने झूठ की हैसियत महज़ साधारण मिट्टी जैसी है।"
            "देवी के हाथ अब अज्ञान को पूरी तरह से 'मथ' (Churn) रहे थे, ताकि उसमें से सारी गंदगी निकल सके।"
            "हर मुक्का इंसान की एक 'पुरानी और ज़िद्दी बुरी आदत' को तोड़ने वाली एक गहरी चोट है।"
            "रणभूमि अब धीरे-धीरे नकारात्मक अशुद्धियों से पूरी तरह मुक्त और पवित्र होती जा रही थी।"
        """.trimIndent(),
        english = """
            (The Power of Fists): "The Mother ripped through many demons utilizing the sharp tip of Her sacred Trident."
            "The remaining monsters were ruthlessly slammed to the dirt by the terrifying force of Her Fists."
            "The tip of the Trident symbolizes 'Precision'—there is a specific divine remedy for every mental vice."
            "Striking with Fists showcases the 'Raw' and physical power of the Goddess which ignorance cannot withstand."
            "When words and logic are exhausted, Consciousness takes charge through its absolute 'Direct Action'."
            "Falling to the ground (Dharanitale) symbolizes the absolute total 'Fall' of human and cosmic arrogance."
            "Pulverizing the demons proves that before the Truth, lies hold zero value except that of common dirt."
            "The Goddess's hands were now 'Churning' through ignorance to extract all the deep-seated toxic impurities."
            "Every fist-strike represents a psychological blow destined to break an old and 'Stubborn Habit' forever."
            "The battlefield was gradually becoming free from all forms of psychological and cosmic impurities."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 13,
        sanskrit = "दन्तप्रहारैश्च परे चूर्णितास्ते महासुराः ।\nएवं ननाश तत्सैन्यमसुराणां तदम्बिका ॥ १७ ॥",
        hindi = """
            (दाँतों से पीसना): "देवी ने कई महा-असुरों को अपने दाँतों (Danta) से चबाकर पूरी तरह चूर्ण (Dust) कर दिया।"
            "इस प्रकार माता अम्बिका ने उस पूरी की पूरी साठ हज़ारी असुर सेना का नामो-निशान मिटा दिया।"
            "दाँतों से चबाना तन्त्र में 'काल' (Time) का प्रतीक है जो हर अशुद्ध चीज़ को पूरी तरह निगल जाता है।"
            "समय के दाँत इतने मज़बूत होते हैं कि वे बड़े से बड़े अज्ञान और ईगो को पीस कर रख देते हैं।"
            "अम्बिका का यह रूप 'संहार' (Annihilation) की उस स्टेज को दिखाता है जहाँ कुछ भी शेष नहीं बचता।"
            "'ननाश' (नष्ट होना)—अब वह हज़ारों की भीड़ पूरी तरह से शून्य (Zero) में विलीन हो चुकी थी।"
            "संख्या बल (Quantity) कभी भी अजेय चेतना (Quality) के सामने एक सेकंड भी टिक नहीं सका।"
            "अहंकार की पहली सुरक्षा दीवार (धूम्रलोचन और सेना) अब पूरी तरह से ज़मींदोज़ होकर ढह चुकी थी।"
            "यह श्लोक अज्ञान के पूर्ण 'क्लीन-अप' (Cleansing) की आधिकारिक घोषणा ब्रह्मांड में करता है।"
            "अब शुम्भ के पास यह खबर पहुँचने वाली है कि उसका 'धुआं' (भ्रम) अब राख बन चुका है।"
        """.trimIndent(),
        english = """
            (Pulverized by Time): "The Goddess chewed and pulverized several mega-demons into fine Dust utilizing Her teeth."
            "In this manner, Mother Ambika successfully erased every trace of that sixty-thousand-strong army."
            "Chewing with teeth symbolizes the absolute power of 'Time' which consumes everything that is impure."
            "The teeth of Time are so exceptionally strong that they pulverize even the most colossal arrogance."
            "This format of Ambika illustrates that stage of 'Annihilation' where absolutely nothing remains behind."
            "'Nanasha' (Perished)—The crowd of thousands has now been successfully reduced to mathematical zero."
            "The power of numbers could mathematically never stand against Invincible Consciousness for even a moment."
            "The first defensive wall of Arrogance has now completely collapsed into the deep abyss of history."
            "This verse formally announces the total 'Spiritual Cleansing' of ignorance from the cosmic battlefield."
            "Now the news is about to reach Shumbha that his 'Smoke' has been permanently extinguished."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 14,
        sanskrit = "ततः सिंहः समुत्पत्य गजकुम्भान्तरे स्थितः ।\nबाहुयुद्धेन तेनोच्चैश्चचार सुरशत्रुणा ॥ १८ ॥",
        hindi = """
            (सिंह का पराक्रम): "तभी माता का सिंह उछलकर एक विशाल हाथी के मस्तक (Forehead) पर जा बैठा।"
            "वहाँ बैठकर उस शेर ने देवताओं के शत्रुओं के साथ भयंकर बाहुयुद्ध (Wrestling) करना शुरू किया।"
            "सिंह 'धर्म' (Dharma) का प्रतीक है, जो हमेशा अज्ञान के 'सिर' पर हमला करता है।"
            "हाथी 'भारीपन' और 'तामसिकता' (Tamas) का प्रतीक है, जिसे धर्म अब कुचल रहा था।"
            "बाहुयुद्ध यह दिखाता है कि सत्य और असत्य के बीच का संघर्ष अत्यंत 'इन्टेन्स' और सीधा होता है।"
            "शेर का हाथी पर चढ़ना मतलब साहस का डर के ऊपर पूरी तरह हावी (Domination) हो जाना।"
            "जब इंसान के अंदर धर्म जागता है, तो वह बुराई के साथ कोई 'नेगोशिएशन' नहीं करता, सीधा प्रहार करता है।"
            "यह दृश्य ईगो के उन अंतिम अवशेषों को खत्म करने की प्रक्रिया है जो अभी भी संघर्ष कर रहे थे।"
            "सिंह का हर मूवमेंट अज्ञान के शरीर में भयंकर खौफ और मौत की थरथराहट पैदा कर रहा था।"
            "सत्य का वाहन अब रणभूमि का नया और एकमात्र अजेय राजा बनकर उभर रहा था।"
        """.trimIndent(),
        english = """
            (The Lion's Valor): "Then the Mother's Lion leaped and landed directly upon the forehead of a massive elephant."
            "Seated there, the Lion initiated a terrifying wrestling match with the enemies of the Gods."
            "The Lion symbolizes 'Dharma' (Righteousness), which perpetually attacks the 'Head' of ignorance."
            "The elephant represents 'Heaviness' and 'Tamas', which was now being pulverized by the Lion."
            "This wrestling shows that the conflict between Truth and Lies is exceptionally Intense and direct."
            "The Lion mounting the elephant signifies Courage achieving total Domination over internal fear."
            "When Dharma awakens within a human, it executes zero negotiation with evil, delivering direct strikes."
            "This scene represents the process of eradicating the final remnants of ego that still attempted to resist."
            "Every movement of the Lion generated terrifying vibrations of death within the body of ignorance."
            "The vehicle of Truth was now emerging as the new and singular invincible king of the battlefield."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 15,
        sanskrit = "युध्यमानौ ततस्तौ तु तस्मान्नागान्महीतलम् ।\nनिपेततुः सम्मरब्धौ प्रहारैरतिदारुणैः ॥ १९ ॥",
        hindi = """
            (ज़मीन पर गिरना): "वे दोनों (सिंह और असुर) लड़ते हुए हाथी के ऊपर से नीचे धरती (महीतलम्) पर गिर पड़े।"
            "नीचे गिरकर भी वे एक-दूसरे पर अत्यंत भयंकर और खौफनाक प्रहार (प्रहारैरतिदारुणैः) करते रहे।"
            "यह श्लोक उस महासंग्राम की चरम सीमा (Peak) को बहुत ही स्पष्टता से दर्शाता है।"
            "हाथी से नीचे गिरना मतलब अज्ञान का अपनी 'झूठी ऊँचाई' (False Height) से नीचे आ जाना।"
            "अहंकार हमेशा खुद को बड़ा समझता है, पर युद्ध उसे उसकी 'असली औकात' (ज़मीन) पर ले आता है।"
            "दारुण प्रहार (Severe strikes) यह बताते हैं कि बुरी आदतों को छोड़ने की प्रक्रिया बहुत दर्दनाक होती है।"
            "सच्चाई जब झूठ से टकराती है, तो वह उसे तब तक नहीं छोड़ती जब तक वह मिट्टी न बन जाए।"
            "ज़मीन पर होने वाला यह युद्ध 'ग्राउंड रियलिटी' (Ground Reality) का सामना करने के समान है।"
            "अब अज्ञान के पास भागने के लिए न कोई हाथी बचा था और न ही कोई ऊँचा स्थान।"
            "अहंकार अब पूरी तरह से घिर चुका था और अपनी अंतिम सांसें गिन रहा था।"
        """.trimIndent(),
        english = """
            (Falling to the Ground): "Both the Lion and the demon, locked in combat, fell from the elephant onto the Earth."
            "Even on the ground, they continued delivering exceptionally terrifying and severe physical blows."
            "This verse illustrates the absolute Peak of the cosmic struggle with total clarity."
            "Falling from the elephant symbolizes ignorance losing its 'False Height' and perceived superiority."
            "Arrogance perpetually views itself as elevated, but war drags it back to its 'Original Reality' (the ground)."
            "Severe strikes indicate that the process of shedding toxic habits is mathematically painful."
            "When Truth collides with Lies, it refuses to yield until the lie is reduced to common dirt."
            "This battle on the ground represents confronting the 'Hard Reality' of one's own internal state."
            "Ignorance was now left with zero escape routes, zero elephants, and zero high ground to hide."
            "Arrogance was now completely surrounded and was counting its absolute final breaths."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 16,
        sanskrit = "ततस्तु वेगात्खमुत्पत्य निपत्य च मृगारिणा ।\nकरप्रहारेण शिरश्चामरस्य पृथक्कृतम् ॥ २० ॥",
        hindi = """
            (असुर का वध): "तब उस सिंह (मृगारिणा) ने अत्यंत वेग से आकाश (खम्) की ओर एक लंबी छलांग लगाई।"
            "और फिर वापस नीचे गिरते हुए, उसने अपने पंजों के एक ही प्रहार से उस असुर का सिर काट दिया!"
            "यहाँ सिंह की छलांग 'उच्च दृष्टिकोण' (Higher Perspective) से वार करने का प्रतीक है।"
            "सिर का पृथक्कृत (अलग) होना मतलब 'मैं' और 'शरीर' के बीच के गलत जुड़ाव का टूटना।"
            "सिंह ने बिना किसी अस्त्र के, केवल अपने 'नखों' से बुराई के मस्तक को धड़ से अलग कर दिया।"
            "यह धर्म की वह 'स्वच्छ' विजय है जहाँ वह अज्ञान की सोच को ही जड़ से खत्म कर देता है।"
            "मृगारि (सिंह) यहाँ साक्षात् काल की भूमिका निभा रहा है जिसने अज्ञान को निगल लिया।"
            "जब साहस अपने चरम पर पहुँचता है, तो वह असंभव लगने वाले कार्यों को भी पल भर में कर देता है।"
            "इस वध के साथ ही असुर सेना का जो भी थोड़ा-बहुत साहस बचा था, वह भी खत्म हो गया।"
            "देवी के गण अब जय-जयकार करने लगे क्योंकि अज्ञान का एक और बड़ा खंभा गिर चुका था।"
        """.trimIndent(),
        english = """
            (The Decapitation): "Then the Lion (Mregarina) took a high-velocity leap toward the high sky (Kham)."
            "Crashing back down, he severed the demon's head with a single strike of his powerful paw!"
            "The Lion's leap symbolizes delivering a strike from a 'Higher Perspective' of consciousness."
            "The separation of the head represents breaking the toxic identification between the 'I' and the 'Body'."
            "The Lion utilized zero weapons, only his 'Claws', to separate the head of evil from its torso."
            "This is the 'Clean' victory of Dharma, where it eliminates the very source of ignorant thinking."
            "The Lion here acts as absolute Time (Kaala), which has successfully consumed the illusion."
            "When Courage reaches its absolute peak, it executes seemingly impossible tasks in a single moment."
            "With this slaughter, the remaining courage of the demonic army vanished into nothingness."
            "The Goddess's troops began to celebrate as another massive pillar of ignorance had fallen."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 17,
        sanskrit = "उग्रस्यश्च रणे देव्या शिलावृक्षादिभिर्हतः ।\nदन्तमुष्टितलैश्चैव करालश्च निपातितः ॥ २१ ॥",
        hindi = """
            (उदग्र और कराल का अंत): "देवी ने युद्ध में 'उदग्र' को शिलाओं (पत्थरों) और वृक्षों से मार डाला।"
            "तथा 'कराल' नामक राक्षस को अपने दाँतों, मुक्कों और थप्पड़ों के प्रहार से ज़मीन पर सुला दिया।"
            "शिला और वृक्ष (Stones/Trees) साक्षात् 'प्रकृति' (Nature) के उन तत्वों का प्रतीक हैं जो अज्ञान को तोड़ते हैं।"
            "उदग्र (घमंड) और कराल (क्रोध) को मारने के लिए देवी को किसी दिव्य अस्त्र की ज़रूरत नहीं पड़ी।"
            "यह दिखाता है कि प्रकृति अपने साधारण रूपों से ही बड़े-बड़े विकारों को कुचलने की ताकत रखती है।"
            "मुक्कों और थप्पड़ों का प्रयोग देवी के उस 'फिजिकल' और 'इंटिमेट' युद्ध को दर्शाता है।"
            "सत्य जब हमारे करीब आता है, तो वह थप्पड़ की तरह हमें हमारी गलतियों का अहसास कराता है।"
            "जब इंसान बहुत ज़्यादा अकड़ (उदग्र) दिखाता है, तो पत्थर (हकीकत) ही उसका सिर फोड़ देते हैं।"
            "कराल (भयानक गुस्सा) को देवी ने अपने हाथों से शांत कर दिया, जो 'कंट्रोल' का प्रतीक है।"
            "इन छोटे-बड़े राक्षसों का मरना मन की सफाई (Mental Detox) की पूरी प्रक्रिया है।"
        """.trimIndent(),
        english = """
            (The End of Arrogance and Wrath): "The Goddess killed 'Udagra' utilizing heavy stones and massive trees during the battle."
            "And She slammed 'Karala' to the ground using Her teeth, fists, and powerful slaps."
            "Stones and Trees symbolize the raw elements of 'Nature' that break down human ignorance."
            "To eliminate Udagra (Arrogance) and Karala (Wrath), the Mother required zero divine weaponry."
            "This proves that Nature holds the power to pulverize colossal vices using Her most basic forms."
            "Using fists and slaps highlights the 'Intimate' and physical nature of the psychological struggle."
            "When Truth approaches us, it often strikes like a slap to wake us from our deep slumber."
            "When a human displays excessive stiffness (Udagra), Stones (Reality) inevitably shatter his pride."
            "Karala (Horrific Wrath) was silenced by the Goddess's hands, symbolizing mastery and control."
            "The death of these minor demons represents the complete process of a thorough Mental Detox."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 18,
        sanskrit = "प्रादाच्च गदापातेन चूर्णयामास चोद्धतम् ।\nबाष्कलं भिन्दिपालेन बाणैस्ताम्रान्धकावपि ॥ २२ ॥",
        hindi = """
            (उद्धत, बाष्कल, ताम्र और अन्धक): "देवी ने अपनी गदा के प्रहार से 'उद्धत' को पीसकर चूर्ण (Dust) कर दिया।"
            "बाष्कल को भिन्दिपाल से और ताम्र तथा अन्धक को अपने बाणों से यमलोक पहुँचा दिया।"
            "उद्धत (उद्दंडता) को गदा से मारना मतलब भारी घमंड को 'चकनाचूर' (Pulverize) कर देना।"
            "ताम्र (लालच) और अन्धक (अंधापन) को तीरों से मारना 'सटीक ज्ञान' का प्रतीक है।"
            "ये चारों राक्षस इंसान के चरित्र के वे दोष हैं जो उसे कभी शांति से बैठने नहीं देते।"
            "देवी एक-एक करके हर एक 'साइकोलॉजिकल वायरस' का इलाज अपने अलग अस्त्रों से कर रही हैं।"
            "गदा की मार ठोस हकीकत है, और बाण की मार चुभने वाला कड़वा सच (Bittersweet Truth) है।"
            "अन्धक का मरना मतलब 'अंधे अज्ञान' का खत्म होना, जिसके बाद ही रोशनी (ज्ञान) आ सकती है।"
            "अब शुम्भ की सेना का लगभग हर बड़ा योद्धा काल के गाल में समा चुका था।"
            "चेतना अब पूरे साम्राज्य को इन ज़हरीले विचारों से मुक्त करने के अंतिम पड़ाव पर थी।"
        """.trimIndent(),
        english = """
            (Erasing the Vices): "The Goddess pulverized 'Uddhata' into fine dust utilizing the heavy force of Her mace."
            "She killed Bashkala with a missile and sent Tamra and Andhaka to death with Her arrows."
            "Killing Uddhata (Arrogance) with a mace symbolizes 'Pulverizing' solid and heavy pride."
            "Executing Tamra (Greed) and Andhaka (Blindness) with arrows represents 'Precise Wisdom'."
            "These four demons are character flaws that prevent a human from attaining internal peace."
            "The Goddess is systematically treating every 'Psychological Virus' utilizing specific divine tools."
            "The strike of the mace is solid reality, and the arrow is the piercing Bittersweet Truth."
            "The death of Andhaka implies the end of 'Blind Ignorance', which allows Light to enter the mind."
            "Almost every major warrior of Shumbha's army had now been swallowed by the mouth of Time."
            "Consciousness was now at the final stage of liberating the entire empire from toxic thoughts."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 19,
        sanskrit = "उग्रास्यमुग्रवीर्यं च तथैव च महाहनुम् ।\nत्रिनेत्रा च त्रिशूलेन जघान परमेश्वरी ॥ २३ ॥",
        hindi = """
            (त्रिशूल का प्रहार): "तीन नेत्रों वाली परमेश्वरी ने 'उग्रास्य', 'उग्रवीर्य' और 'महाहनु' को अपने त्रिशूल से मारा।"
            "त्रिशूल (Trident) सत्व, रज और तम—तीनों गुणों को कंट्रोल करने वाला परम अस्त्र है।"
            "उग्रास्य (कड़वे वचन), उग्रवीर्य (हिंसक काम) और महाहनु (बड़ा अहंकार) जैसे विकारों का यह अंत था।"
            "त्रिनेत्रा (तीन आँखों वाली) का अर्थ है वह 'जागृत बुद्धि' जो भूत, भविष्य और वर्तमान को देखती है।"
            "जब इंसान के अंदर तीसरी आँख (Viveka) खुलती है, तो ये भयंकर विचार खुद ही मर जाते हैं।"
            "त्रिशूल का प्रहार यह बताता है कि बुराई को 'तीनों लेवल' (Body, Mind, Soul) पर खत्म करना ज़रूरी है।"
            "परमेश्वरी का यह रूप साक्षात् 'कॉस्मिक जस्टिस' (Cosmic Justice) का प्रतीक है।"
            "अहंकार के ये खूंखार रूप अब त्रिशूल की अग्नि में जलकर पूरी तरह भस्म हो चुके थे।"
            "यह वध यह संदेश देता है कि जब ज्ञान जागता है, तो अज्ञान के लिए कोई जगह नहीं बचती।"
            "अब पूरी रणभूमि देवी के तेज़ से जगमगा रही थी और असुरों का साम्राज्य डूब रहा था।"
        """.trimIndent(),
        english = """
            (Death by Trident): "The three-eyed Goddess slaughtered 'Ugrasya', 'Ugravirya', and 'Mahahanu' with Her Trident."
            "The Trident is the supreme weapon that Controls the three Gunas—Sattva, Rajas, and Tamas."
            "This marked the absolute end of Bitter Speech (Ugrasya), Violent Action, and Massive Pride."
            "Trinetra (Three-eyed) symbolizes 'Awakened Intellect' that perceives Past, Present, and Future."
            "When the third eye of Wisdom opens within a human, these terrifying thoughts die automatically."
            "The strike of the Trident proves that evil must be eradicated on 'Three Levels' (Body, Mind, Spirit)."
            "This format of the Goddess is the absolute manifestation of 'Cosmic Justice' and order."
            "These fierce forms of arrogance were now incinerated in the fire of the divine Trident."
            "This slaughter teaches that once Wisdom awakens, zero space remains for thick ignorance."
            "The battlefield was now glowing with Her Radiance while the demonic empire was rapidly sinking."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 20,
        sanskrit = "बिडालस्यासिना कायात्पातयामास वै शिरः ।\nदुर्धरं दुर्मुखं चोभौ शरैर्निन्ये यमक्षयम् ॥ २४ ॥",
        hindi = """
            (अंतिम सफाई): "माता ने अपनी तलवार (असि) से 'बिडाल' का सिर काटकर उसके शरीर से अलग कर दिया।"
            "साथ ही 'दुर्धर' और 'दुर्मुख' दोनों को अपने अचूक बाणों से यमलोक (मृत्यु) पहुँचा दिया।"
            "बिडाल (बिल्ली जैसी चालाकी) इंसान के चरित्र का वह गुप्त दोष है जिसे तलवार (ज्ञान) ही काट सकती है।"
            "दुर्धर (बुरी आदतों का बोझ) और दुर्मुख (नकारात्मक वाणी) का अंत 'तीरों' यानी फोकस से हुआ।"
            "देवी अब सेना के उन 'अंतिम अवशेषों' को चुन-चुनकर खत्म कर रही हैं जो अभी भी छुपे थे।"
            "सत्य की तलवार जब चलती है, तो वह किसी भी तरह की 'चालाकी' या 'मुखौटे' को नहीं छोड़ती।"
            "यमक्षय (मौत का घर) पहुँचाना यह बताता है कि ये विचार अब कभी वापस नहीं लौटेंगे।"
            "पूरी सप्तशती में यह अध्याय 'क्विक रिस्पॉन्स' (Quick Response) और 'एक्शन' का बेहतरीन उदाहरण है।"
            "अब अज्ञान का जो साठ हज़ार का पहाड़ था, वह पूरी तरह से समतल होकर खत्म हो चुका था।"
            "माता अम्बिका ने अकेले ही उस पूरे अधर्म के सिस्टम को मिट्टी में मिला दिया था।"
        """.trimIndent(),
        english = """
            (The Final Clean-up): "The Mother severed the head of 'Bidala' using Her sword and separated it from his body."
            "She dispatched both 'Durdhara' and 'Durmukha' to the realm of Death using Her infallible arrows."
            "Bidala (Cunning like a cat) is that hidden character flaw which only the Sword of Wisdom can sever."
            "Durdhara (Toxic habits) and Durmukha (Foul speech) were ended by the 'Arrows' of intense Focus."
            "The Goddess is now meticulously eliminating the 'Final Remnants' of the army that were still hiding."
            "When the Sword of Truth strikes, it refuses to spare any form of 'Cunning' or deceptive mask."
            "Sending them to the Realm of Death implies that these toxic thoughts will mathematically never return."
            "In the entire text, this chapter is the finest example of 'Quick Response' and absolute 'Action'."
            "The mountain of sixty thousand demons had now been completely leveled and eradicated from existence."
            "Mother Ambika, alone, had successfully grounded the entire system of Adharma into the dirt."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 21,
        sanskrit = "एवं सङ्क्षीयमाणे तु स्वसैन्ये महिषासुरः ।\nमाहिषेण स्वरूपेण त्रासयामास तान् गणान् ॥ २५ ॥",
        hindi = """
            (महिषासुर का उदय): "अपनी सेना को इस प्रकार नष्ट होते देखकर अब स्वयं महिषासुर सामने आया।"
            "उसने अपने असली 'भैंसे' (Buffalo) के रूप में आकर देवी के गणों को डराना और मारना शुरू किया।"
            "यह अज्ञान का 'अंतिम हथियार' है—जब तर्क और सेना फेल हो जाती है, तो इंसान का 'पशु' बाहर आता है।"
            "महिषासुर वह 'जड़ता' (Inertia) है जो सत्य को स्वीकार करने के बजाय उसे कुचलना चाहती है।"
            "भैंसे का रूप इंसान के उस 'अंधे हठ' (Blind Stubbornness) को दर्शाता है जो किसी की नहीं सुनता।"
            "अहंकार अब अपने 'रॉ' (Raw) और सबसे बदसूरत रूप में चेतना के सामने खड़ा हो गया था।"
            "वह देवी के गणों (अच्छे विचारों) को 'त्रास' (Terror) दे रहा था ताकि वे डरकर भाग जाएं।"
            "जब हम अपनी बुराई के सबसे गहरे स्तर पर पहुँचते हैं, तो वह हमें बहुत डरावनी लगती है।"
            "परंतु यही वह बिंदु है जहाँ से 'महिषासुरमर्दिनी' (Slayer of Ego) का असली खेल शुरू होता है।"
            "अब अज्ञान और परम चेतना के बीच वह सीधा युद्ध होगा जो ब्रह्मांड का इतिहास बदल देगा।"
        """.trimIndent(),
        english = """
            (The Manifestation of the Buffalo): "Witnessing his army being destroyed, Mahishasura himself finally stepped onto the battlefield."
            "He assumed his true 'Buffalo' form and initiated terrorizing and slaughtering the Goddess's troops."
            "This is the 'Final Weapon' of ignorance—when logic and armies fail, the human's 'Animal' steps out."
            "Mahishasura represents that 'Inertia' which seeks to crush the Truth rather than accepting it."
            "The Buffalo form symbolizes the 'Blind Stubbornness' that refuses to listen to reason or wisdom."
            "Arrogance was now standing before Consciousness in its 'Raw' and absolute most ugly format."
            "He was inflicting 'Terror' upon the divine troops to force them into a state of psychological submission."
            "When we reach the deepest level of our internal vices, they appear exceptionally terrifying to us."
            "However, this is the exact point where the true play of 'Mahishasuramardini' officially commences."
            "A direct war between thick ignorance and Supreme Consciousness is now about to change cosmic history."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 22,
        sanskrit = "काँश्चित्तुण्डप्रहारेण खुरविक्षेपतस्तथान् ।\nलाङ्गूलताडितांश्चान्याञ्छृङ्गाभ्यां च विदारितान् ॥ २६ ॥",
        hindi = """
            (भैंसे का हमला): "महिषासुर ने अपने 'थूथन' (मुंह) से मार-मारकर कई योद्धाओं को ज़मीन पर पटक दिया।"
            "कुछ को उसने अपने भारी 'खुरों' (Hooves) से कुचला और अपनी 'पूंछ' के प्रहार से लहूलुहान कर दिया।"
            "और बाकी बचे हुए गणों को उसने अपनी नुकीली 'सींगों' (Horns) से चीर कर रख दिया।"
            "थूथन, खुर, पूंछ और सींग—ये ईगो के चार 'पाश्विक हथियार' (Brutal Weapons) हैं।"
            "थूथन गंदी और हिंसक भाषा का प्रतीक है, और खुर दूसरों को कुचलने वाले व्यवहार का।"
            "पूंछ वह 'रुतबा' और 'अतीत' है जिससे इंसान दूसरों पर धौंस जमाकर उन्हें चोट पहुँचाता है।"
            "सींग वह नुकीला 'घमंड' है जो दूसरों की भावनाओं को बिना किसी रहम के फाड़ देता है।"
            "अहंकार जब पागल होता है, तो वह अपने शरीर के हर हिस्से को हथियार बना लेता है।"
            "वह चाहता है कि उसके आस-पास की हर अच्छी चीज़ (गण) पूरी तरह से लहूलुहान और नष्ट हो जाए।"
            "यह उस 'अंधे अज्ञान' का प्रदर्शन है जो विनाश को ही अपनी सबसे बड़ी जीत मानता है।"
        """.trimIndent(),
        english = """
            (The Brutal Assault): "Mahishasura slammed many warriors to the ground utilizing the force of his heavy snout."
            "He crushed some with his massive hooves and battered others with the whipping strikes of his tail."
            "The remaining divine troops were ripped apart by his exceptionally sharp and lethal horns."
            "Snout, Hooves, Tail, and Horns—these are the four 'Brutal Weapons' of the unrefined human Ego."
            "The snout symbolizes foul and violent language, while hooves represent crushing behavioral patterns."
            "The tail is the 'Status' and 'Past' used by humans to intimidate and wound the dignity of others."
            "The horns represent that sharp 'Pride' which mercilessly tears through the emotions of innocent people."
            "When Arrogance goes insane, it transforms every part of its biological existence into a weapon."
            "It desires to see every good thing (virtues) around it completely bloodied and destroyed."
            "This is a demonstration of 'Blind Ignorance' that mistakes total destruction for a supreme victory."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 23,
        sanskrit = "वेगेन कांश्चिदपरान्नादेन भ्रमणेन च ।\nनिश्वासपवनेनान्यान्पातयामास भूतले ॥ २७ ॥",
        hindi = """
            (वेग और नाद): "उसने अपनी भयंकर 'रफ्तार' (Speed) और 'गर्जना' (Roar) से कई योद्धाओं के प्राण हर लिए।"
            "वह रणभूमि में पागलों की तरह 'गोल-गोल' घूमने लगा और अपनी 'सांसों की आंधी' से सबको उड़ा दिया।"
            "रफ्तार (Speed) बिना सोचे-समझे लिए गए उन गलत फैसलों का प्रतीक है जो दूसरों को रौंद देते हैं।"
            "गर्जना (Roar) वह चिल्लाना और डराना है जिससे इंसान अपनी झूठी ताकत को साबित करना चाहता है।"
            "गोल-गोल घूमना (Spinning) उस मानसिक 'कन्फ्यूजन' का प्रतीक है जो पूरे माहौल को अशांत कर देता है।"
            "सांसों की आंधी (Breath storm) वह 'नेगेटिव एनर्जी' है जो एक घमंडी इंसान हर पल छोड़ता रहता है।"
            "महिषासुर अब ब्रह्मांड की लय (Rhythm) को बिगाड़ने के लिए अपनी पूरी ताकत लगा रहा था।"
            "वह दिखाना चाहता था कि उसकी 'मौजूदगी' ही तबाही मचाने के लिए काफी है।"
            "जब ईगो मर रहा होता है, तो वह अपना सबसे खौफनाक 'तांडव' दुनिया को दिखाता है।"
            "परंतु वह नहीं जानता कि वह जिस 'हवा' से लड़ रहा है, वह साक्षात् 'प्राण-शक्ति' (देवी) है।"
        """.trimIndent(),
        english = """
            (Velocity and Vibration): "He killed many warriors utilizing his terrifying speed and his ear-shattering, demonic roar."
            "He began spinning rapidly like a maniac and blew everyone away with the storm of his breath."
            "Speed symbolizes those impulsive, wrong decisions that blindly crush the people around us."
            "The Roar represents the aggressive shouting used to project a fake sense of dominance and power."
            "Spinning illustrates that state of 'Mental Confusion' which disturbs the entire surrounding environment."
            "The storm of breath is the 'Negative Energy' radiated by an arrogant person at every single moment."
            "Mahishasura was aggressively attempting to disturb the cosmic rhythm with his maximum raw force."
            "He wanted to prove that his mere 'Presence' was sufficient to execute a total apocalypse."
            "When the Ego is in its final stages, it displays its most terrifying and chaotic dance to the world."
            "However, he ignores that the 'Air' he is fighting against is the absolute Primal Life-Force (Goddess)."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 24,
        sanskrit = "निपात्य प्रमथानीकमभ्यधावत सोऽसुरः ।\nसिंहं हन्तुं महादेव्याः कोपं चक्रे ततोऽम्बिका ॥ २८ ॥\n\n(इति श्रीमार्कण्डेयपुराणे सावर्णिके मन्वन्तरे देवीमाहात्म्ये धूम्रलोचनवधो नाम षष्ठोऽध्यायः ॥ ६ ॥)",
        hindi = """
            (देवी का क्रोध और समापन): "देवी की सेना को गिराने के बाद, वह असुर माता के 'सिंह' (शेर) को मारने के लिए उसकी ओर झपटा।"
            "अपने प्रिय वाहन और 'धर्म' के प्रतीक शेर पर हमला होते देख माता अम्बिका को अत्यंत भयंकर क्रोध आया।"
            "यह 'धर्म' और 'अधर्म' की सीधी टक्कर का वो क्षण है जहाँ अब कोई समझौता नहीं हो सकता।"
            "ईगो (महिषासुर) हमेशा 'साहस' (शेर) को मारना चाहता है ताकि इंसान फिर से कभी सर न उठा सके।"
            "माता का क्रोध (Wrath) कोई आम गुस्सा नहीं, बल्कि ब्रह्मांडीय संतुलन को ठीक करने वाली अग्नि है।"
            "यहीं पर श्री मार्कण्डेय पुराण में वर्णित दुर्गा सप्तशती का 'धूम्रलोचन-वध' नामक छठा अध्याय पूर्ण होता है।"
            "धूम्रलोचन (भ्रम) का वध हो चुका है और अब महिषासुर का अंतिम समय बिल्कुल करीब है।"
            "यह अध्याय हमें सिखाता है कि सत्य की एक 'हुंकार' ही हज़ारों भ्रमों को राख करने के लिए काफी है।"
            "अहंकार चाहे कितनी भी बड़ी सेना लेकर आए, वह चेतना के एक कण के सामने भी नहीं टिक सकता।"
            "अगले अध्याय में हम देखेंगे कि कैसे देवी अपने सबसे भयानक रूप 'काली' को प्रकट करती हैं।"
        """.trimIndent(),
        english = """
            (Ambika's Wrath and Conclusion): "Having dropped the divine army, the demon rushed toward the 'Lion' with the intent to kill it."
            "Seeing the assault on Her vehicle and the symbol of Dharma, Mother Ambika became apocalyptically enraged."
            "This is the precise moment of direct collision between Dharma and Adharma where negotiation is impossible."
            "Ego (Mahishasura) perpetually seeks to slaughter 'Courage' (Lion) so the human never rises again."
            "The Mother's wrath is zero ordinary anger; it is the cosmic fire destined to restore universal balance."
            "Right here formally concludes the Sixth Chapter of the text, named 'The Slaughter of Dhumralochana'."
            "Dhumralochana (Delusion) has been incinerated, and the final hour of Mahishasura is now at hand."
            "This chapter teaches us that a single 'Humkara' of Truth is sufficient to turn thousands of illusions to ashes."
            "Regardless of the size of the army arrogance brings, it cannot withstand a single spark of Consciousness."
            "In the next chapter, we shall witness the manifestation of the absolute most terrifying form—Goddess Kali."
        """.trimIndent()
    )
)