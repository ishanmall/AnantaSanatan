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
data class AvadhutaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AvadhutaUpanishadScreen() {
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
                if (shlokaNumber != null && shlokaNumber in 1..9) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-9)") },
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
            itemsIndexed(avadhutaShlokasList) { _, shloka ->
                AvadhutaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun AvadhutaShlokaCard(shloka: AvadhutaShloka) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Shloka ${shloka.id}",
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

val avadhutaShlokasList: List<AvadhutaShloka> = listOf(
    AvadhutaShloka(
        id = 1,
        sanskrit = "सांकृतिर्भगवन्तमवधूतं दत्तात्रेयं पप्रच्छ भो भगवन् कः अवधूतः तस्य का स्थितिः किं लक्ष्म किं संसरणमिति । तं होवाच भगवान् दत्तात्रेयः ॥ १ ॥",
        hindi = """
            एक बार महर्षि सांकृति ने परम गुरु भगवान दत्तात्रेय के पास जाकर उनसे अत्यंत विनीत भाव से पूछा।
            "हे भगवन्! कृपया मुझे यह बताइए कि वास्तव में 'अवधूत' (Avadhuta) कौन होता है?"
            "उस अवधूत की वास्तविक 'स्थिति' (State) क्या होती है, और उसका इस संसार में आचरण (Behavior) कैसा होता है?"
            भगवान दत्तात्रेय, जो स्वयं अवधूतों के परम आदर्श हैं, उन्होंने अत्यंत करुणा के साथ उत्तर दिया।
            "हे सांकृति! अवधूत वह है जिसने प्रकृति और समाज के सभी झूठे आवरणों को पूरी तरह से उतार फेंका है।"
            "अवधूत शब्द में चार अक्षर हैं: 'अ', 'व', 'धू', और 'त', और इन चारों में ही उसका पूरा रहस्य छिपा है।"
            यह उपनिषद संन्यास और अद्वैत की सबसे ऊँची अवस्था का वर्णन करता है, जहाँ कोई सामाजिक नियम लागू नहीं होता।
            हम लोग समाज के नियमों, इज्जत और डर के गुलाम हैं; पर अवधूत इन सबसे पूरी तरह आज़ाद है।
            उसका मन हमेशा केवल उस एक 'परम सत्य' (ब्रह्म) में ही टिका रहता है, दुनिया के ड्रामे में नहीं।
            अगले श्लोकों में भगवान दत्तात्रेय 'अवधूत' शब्द के एक-एक अक्षर का अत्यंत गहरा वैज्ञानिक अर्थ समझाएंगे।
        """.trimIndent(),
        english = """
            Once, the great Sage Sankriti approached the Supreme Guru, Lord Dattatreya, and asked with absolute humility.
            "O Supreme Lord! Please profoundly instruct me, who exactly is an 'Avadhuta' in absolute reality?"
            "What exactly is the true 'State' (Condition) of that Avadhuta, and how precisely does he behave in this world?"
            Lord Dattatreya, who Himself is the absolute, ultimate manifestation of all Avadhutas, answered with supreme compassion.
            "O Sankriti! An Avadhuta is strictly he who has ruthlessly stripped off and thrown away all false covers of nature and society."
            "The word Avadhuta strictly contains four syllables: 'A', 'Va', 'Dhu', and 'Ta', completely concealing his ultimate secret."
            This magnificent Upanishad vividly describes the absolute highest peak of Sannyasa and Non-duality, where absolutely zero social rules apply.
            We ordinary humans are pathetic slaves to society's rigid rules, fake honor, and terrifying fears; but the Avadhuta is 100% free from all this.
            His supreme mind remains perpetually and flawlessly anchored strictly in that one 'Absolute Truth' (Brahman), never in the world's cheap drama.
            In the highly anticipated subsequent verses, Lord Dattatreya will flawlessly explain the profound scientific meaning of every single syllable of the word 'Avadhuta'.
        """.trimIndent()
    ),
    AvadhutaShloka(
        id = 2,
        sanskrit = "अक्षरत्वाद्वरेण्यत्वाद्धूतसंसारबन्धनात् । तत्त्वमस्यादिलक्ष्यत्वादवधूत इतीर्यते ॥ १ ॥ अक्षरत्वमकारार्थः... ॥ २ ॥",
        hindi = """
            "अवधूत शब्द का जो पहला अक्षर 'अ' (A) है, वह साक्षात् 'अक्षर' (अविनाशी / Imperishable) परब्रह्म का प्रतीक है।"
            "इसका अर्थ है कि अवधूत वह है जिसे उस अविनाशी ब्रह्म का 100% साक्षात् अनुभव (Experience) हो चुका है।"
            "वह सभी प्रकार के अज्ञान (Ignorance) और सांसारिक बंधनों से पूरी तरह मुक्त (आज़ाद) हो चुका है।"
            "वह हमेशा अपनी ही आत्मा (आत्मानंद) में मग्न रहता है, और दुनिया की कोई भी नाशवान चीज़ उसे लुभा नहीं सकती।"
            यहाँ 'अक्षर' का मतलब है वह सत्य जिसका कभी 'क्षय' (नाश) न हो; जैसे इंसान का शरीर मरता है, पर चेतना (Consciousness) नहीं।
            अवधूत ने जान लिया है कि वह यह मिट्टी का शरीर नहीं, बल्कि वह 'अक्षर' चेतना ही है।
            हम लोग 'नाशवान' (पैसे, रूप) के पीछे भागते हैं और अंत में रोते हैं, क्योंकि वे चीजें हमसे छिन जाती हैं।
            पर अवधूत ने उस चीज़ (अविनाशी भगवान) को पकड़ लिया है जो कभी खत्म नहीं होती, इसलिए वह कभी दुखी नहीं होता।
            यह अक्षर 'अ' इस बात की घोषणा है कि योगी अब इंसान नहीं रहा; वह साक्षात् 'अविनाशी' भगवान बन गया है।
            इसी ज्ञान के कारण, मौत का सबसे बड़ा डर भी उसके सामने घुटने टेक देता है।
        """.trimIndent(),
        english = """
            "The absolute first syllable 'A' of the word Avadhuta is the direct, flawless symbol of the 'Akshara' (Imperishable) Supreme Brahman."
            "This profoundly means that an Avadhuta is exactly he who has successfully attained the 100% direct, living Experience of that indestructible Brahman."
            "He has flawlessly become completely and permanently liberated (freed) from absolutely all ignorance and terrifying worldly bonds."
            "He remains perpetually drowned and fully absorbed in his very own Soul (Atmananda), and absolutely no perishable worldly object can ever tempt him."
            Here, 'Akshara' literally means that absolute Truth which absolutely never suffers 'Kshaya' (decay/death); exactly as the physical body dies, but pure Consciousness does not.
            The Avadhuta has flawlessly realized that he is absolutely not this dirt-body, but strictly that 'Akshara' consciousness itself.
            We ignorant fools blindly chase highly 'Perishable' things (money, beauty) and ultimately cry violently, simply because they are brutally snatched away from us.
            But the Avadhuta has flawlessly grasped exactly that one thing (Indestructible God) which absolutely never ends, hence he absolutely never experiences sorrow.
            This syllable 'A' is the terrifying, bold declaration that the Yogi is absolutely no longer a human; he has literally become the 'Imperishable' God Himself.
            Strictly due to this explosive wisdom, even the absolute greatest fear of death drops helplessly to its knees before him.
        """.trimIndent()
    ),
    AvadhutaShloka(
        id = 3,
        sanskrit = "वरेण्यत्वं वकारार्थः... ॥ ३ ॥",
        hindi = """
            "'अवधूत' शब्द का जो दूसरा अक्षर 'व' (Va) है, वह साक्षात् 'वरेण्य' (Varenya / सबसे श्रेष्ठ और पूजनीय) का परम प्रतीक है।"
            "इसका अर्थ है कि वह अवधूत सभी प्रकार के सांसारिक 'विकल्पों' (Vikalpas / विचारों और इच्छाओं) से पूरी तरह पार जा चुका है।"
            "वह इस पूरी सृष्टि में सबसे श्रेष्ठ (वरेण्य) स्थिति में पहुँच चुका है, जहाँ उसे कुछ भी पाना या छोड़ना बाकी नहीं है।"
            "वह दुनिया की सभी प्रकार की वासनाओं (Vasanas / गहरी इच्छाओं) को अपनी ज्ञान की आग में भस्म कर चुका है।"
            'वरेण्य' का मतलब है जिसकी पूजा देवता भी करते हों (जैसे गायत्री मंत्र में 'भर्गो देवस्य धीमहि वरेण्यं')।
            आम इंसान वासनाओं (Lust, Greed) का कीड़ा होता है; वह हमेशा कुछ न कुछ माँगता ही रहता है (विकल्प)।
            जब तक दिमाग में "मुझे यह चाहिए" का शोर (Vikalpa) है, तब तक इंसान भिखारी ही रहता है, चाहे वह राजा ही क्यों न हो।
            पर अवधूत ने अपने मन के इस भिखारी को हमेशा के लिए मार दिया है; उसकी सारी वासनाएं 100% जीरो (Zero) हो चुकी हैं।
            जब चाहत ही खत्म हो गई, तो वह इंसान 'वरेण्य' (Supreme) बन जाता है, क्योंकि अब वह दुनिया का नहीं, दुनिया उसकी गुलाम है।
            यह 'व' अक्षर इंसान के मन की पूरी 'क्लीनिंग' (Cleaning / सफाई) का साक्षात् प्रमाण है।
        """.trimIndent(),
        english = """
            "The precise second syllable 'Va' of the word Avadhuta is the direct, ultimate symbol of 'Varenya' (The Most Excellent and supremely worshipable)."
            "This explicitly means that the Avadhuta has completely and flawlessly transcended absolutely all worldly 'Vikalpas' (chaotic thoughts and endless desires)."
            "He has successfully reached the absolute highest, most supreme (Varenya) state in all of creation, where absolutely nothing remains for him to attain or reject."
            "He has violently and ruthlessly burnt absolutely all 'Vasanas' (deep-rooted worldly lusts and cravings) to mere ashes in the blazing fire of his wisdom."
            'Varenya' profoundly means that supreme being whom even the greatest gods worship (exactly as in the Gayatri Mantra 'Bhargo devasya dhimahi Varenyam').
            An ordinary human is a pathetic, filthy worm of Vasanas (Lust, Greed); he is perpetually demanding something or the other (Vikalpa).
            Exactly as long as the toxic noise of "I absolutely need this" (Vikalpa) exists in the brain, the human remains a pathetic beggar, even if he is physically a king.
            But the Avadhuta has permanently and violently killed this internal beggar forever; absolutely all his cravings have dropped to a flawless 100% Zero.
            When the very root of desire is permanently annihilated, that human instantly becomes 'Varenya' (Supreme), because he is no longer the world's slave; the world is his slave.
            This precise syllable 'Va' is the absolute, irrefutable proof of the complete and total 'Cleaning' (purification) of the human mind.
        """.trimIndent()
    ),
    AvadhutaShloka(
        id = 4,
        sanskrit = "धूतसंसारबन्धनं धूकारार्थः... ॥ ४ ॥",
        hindi = """
            "'अवधूत' शब्द का जो तीसरा अक्षर 'धू' (Dhu) है, वह साक्षात् 'धूत' (Dhuta / झाड़ देना या धो डालना) का परम प्रतीक है।"
            "इसका अर्थ है कि उस महान योगी ने अपने शरीर और आत्मा पर पड़े हुए 'अज्ञान के कचरे' को पूरी तरह से झाड़ (धो) कर फेंक दिया है।"
            "उसने समाज के सभी नियमों, कर्मों और वर्ण-आश्रम (जाति और उम्र के बंधनों) को अपने दिमाग से पूरी तरह 'धूत' (Wash away) कर दिया है।"
            "वह किसी भी नियम (Rule) का गुलाम नहीं है; वह हवा की तरह पूरी तरह से आज़ाद है।"
            हम सब बचपन से ही समाज की 'कंडीशनिंग' (Conditioning / झूठे नियमों) के भारी बोझ तले दबे होते हैं (कि यह करना है, वह नहीं करना है)।
            लोग क्या कहेंगे, धर्म क्या कहेगा—ये सारी बातें हमारे दिमाग पर 'धूल' (Dust) की तरह जमी होती हैं।
            अवधूत वह शेर है जो ज्ञान के पानी से इस पूरी की पूरी 'सामाजिक धूल' को एक ही बार में 'धो' (Dhu) डालता है!
            उसके लिए न कोई ब्राह्मण है, न शूद्र है, न हिंदू है, न मुस्लिम है; उसके लिए केवल 'चेतना' (Consciousness) ही सच है।
            वह नंगे घूम सकता है, राख मल सकता है, क्योंकि उसे किसी को इम्प्रेस (Impress) नहीं करना है।
            यह 'धू' अक्षर इंसान की उस परम आज़ादी (Ultimate Freedom) का प्रतीक है जहाँ समाज की कोई जंजीर उसे बाँध नहीं सकती।
        """.trimIndent(),
        english = """
            "The exact third syllable 'Dhu' of the word Avadhuta is the direct, supreme symbol of 'Dhuta' (aggressively shaken off or washed away)."
            "This profoundly means that the magnificent Yogi has completely, ruthlessly shaken off and washed away the heavy 'garbage of ignorance' covering his body and soul."
            "He has flawlessly and entirely 'Dhuta' (Washed away) absolutely all societal rules, heavy karmas, and Varna-Ashrama (rigid bonds of caste and life-stages) from his brain."
            "He is absolutely not a pathetic slave to any physical Rule whatsoever; he is completely and fiercely free exactly like the blowing wind."
            Absolutely all of us are brutally crushed under the heavy burden of society's toxic 'Conditioning' (fake rules) right from childhood (dictating what must be done and avoided).
            What will people say, what will religion dictate—all these toxic fears settle aggressively on our brain exactly like a thick layer of 'Dust'.
            The Avadhuta is that terrifying lion who brutally 'Washes' (Dhu) away this entire massive layer of 'social dust' in one single, violent stroke using the water of wisdom!
            For him, there is absolutely no Brahmin, no Shudra, no Hindu, no Muslim; for him, exclusively pure 'Consciousness' alone is the absolute truth.
            He can effortlessly roam completely naked or smear thick ash on his body, strictly because he absolutely does not have to 'Impress' anyone whatsoever.
            This exact syllable 'Dhu' is the absolute ultimate symbol of human's 'Ultimate Freedom', where absolutely no chain of society can ever possibly bind him.
        """.trimIndent()
    ),
    AvadhutaShloka(
        id = 5,
        sanskrit = "तत्त्वमस्यादिलक्ष्यत्वं तकारार्थः... ॥ ५ ॥",
        hindi = """
            "'अवधूत' शब्द का जो चौथा और अंतिम अक्षर 'त' (Ta) है, वह साक्षात् 'तत्त्वमसि' (Tat Tvam Asi / तुम ही वह परब्रह्म हो) महावाक्य का परम प्रतीक है।"
            "इसका अर्थ है कि उस योगी ने अज्ञान को धोने के बाद उस परम सत्य 'तत्' (ईश्वर) को अपने ही भीतर 'त्वम्' (स्वयं) के रूप में साक्षात् अनुभव कर लिया है।"
            "वह अहंकार (अहं) से पूरी तरह मुक्त होकर उस असीम और अनंत परमात्मा में 100% विलीन हो चुका है।"
            "अब उसके लिए दुनिया में कोई दूसरा (Duality) बचा ही नहीं है; वह खुद ही साक्षात् भगवान बन चुका है।"
            वेदान्त की पूरी यात्रा का 'द एंड' (The End) इसी 'तत्त्वमसि' (त) पर होता है।
            जब आपने 'अ' (अनुभव किया), 'व' (वासनाओं को छोड़ा), और 'धू' (समाज के नियमों को धो डाला), तो पीछे क्या बचा?
            पीछे केवल 'त' (वह भगवान) बचा! और वह भगवान आसमान में नहीं, बल्कि वह भगवान आप खुद ही बन गए!
            अद्वैत में 'मैं' (Ego) का मरना ही भगवान का पैदा होना है; जब इंसान का छोटा रूप मिटता है, तो वह पूरे ब्रह्मांड में फैल जाता है।
            यह 'त' अक्षर बताता है कि अवधूत कोई आम साधु नहीं है; वह चलता-फिरता शिव, चलता-फिरता नारायण है।
            इसी अक्षर के साथ 'अवधूत' शब्द का यह अत्यंत वैज्ञानिक और गहरा विच्छेदन (Decoding) पूरा होता है।
        """.trimIndent(),
        english = """
            "The exact fourth and absolute final syllable 'Ta' of the word Avadhuta is the direct, supreme symbol of the grand Mahavakya 'Tat Tvam Asi' (Thou Art That)."
            "This explicitly means that exactly after washing away all ignorance, the Yogi has directly, flawlessly experienced that Supreme Truth 'Tat' (God) as strictly his very own self 'Tvam'."
            "He has become completely, flawlessly liberated from the toxic ego (Aham) and is 100% permanently dissolved entirely into that infinite, boundless Supreme Lord."
            "Now, absolutely zero 'Second' (Duality) remains left for him in the entire world; he himself has literally and flawlessly become God."
            The absolute 'The End' of the entire magnificent journey of Vedanta flawlessly culminates strictly at this exact 'Tat Tvam Asi' (Ta).
            When you have successfully 'A' (Experienced), 'Va' (abandoned all lusts), and 'Dhu' (brutally washed away all social rules), what exactly remains behind?
            Exclusively 'Ta' (That God) remains left behind! And that God is absolutely not in the sky, you yourself have flawlessly become that exact God!
            In pure Advaita, the permanent death of the 'I' (Ego) is exactly the direct birth of God; when the tiny human form vanishes, it expands flawlessly across the entire cosmos.
            This syllable 'Ta' fiercely declares that the Avadhuta is absolutely no ordinary, cheap monk; he is a walking, breathing Shiva, a living Narayana.
            Exactly with this highly potent syllable, this exceptionally scientific and profound Decoding of the majestic word 'Avadhuta' flawlessly reaches its ultimate completion.
        """.trimIndent()
    ),
    AvadhutaShloka(
        id = 6,
        sanskrit = "न वर्णाश्रमचारोऽस्ति न शास्त्रनियमोऽस्ति च । स्वेच्छया विचरत्येव मुक्तो बालपिशाचवत् ॥ ६ ॥",
        hindi = """
            "वह अवधूत किसी भी विशेष 'वर्ण' (Varna / ब्राह्मण, क्षत्रिय आदि) और 'आश्रम' (Ashrama / ब्रह्मचर्य, संन्यास आदि) के बाहरी चिन्हों (कपड़ों) को धारण नहीं करता।"
            "वह समाज की नज़रों में एक पाखंडी या नियम तोड़ने वाला लग सकता है, क्योंकि वह शास्त्रों के बाहरी कर्मकांडों (Rituals) को बिल्कुल नहीं मानता।"
            "वह किसी मंदिर, मूर्ति या दिशा का गुलाम नहीं होता; वह दुनिया में जहाँ चाहे आज़ाद घूमता है।"
            "उसका असली 'आश्रम' उसकी अपनी शुद्ध आत्मा है, और उसका 'वर्ण' केवल उसकी अद्वैत चेतना है।"
            दुनिया हमेशा लोगों को कपड़ों (Dress) से जज (Judge) करती है; अगर भगवा पहना है तो साधु, और अगर सूट पहना है तो संसारी।
            पर दत्तात्रेय कहते हैं कि अवधूत इन कपड़ों के ड्रामे (Show-off) से बहुत ऊपर उठ चुका है; वह नंगा भी रह सकता है और रेशम भी पहन सकता है!
            उसे भगवान को खुश करने के लिए किसी यज्ञ (Yajna), जनेऊ या माला की कोई जरूरत नहीं है; क्योंकि वह खुद ही भगवान है।
            समाज के झूठे नियम (कि ऐसा मत करो, वैसा मत करो) उसके लिए बिल्कुल वैसे ही हैं जैसे शेर के लिए मकड़ी का जाला!
            वह अपनी ही आत्मा के आनंद में मस्त रहता है; अगर कोई उसे पत्थर मारे तो भी वह हंसता है, और कोई पूजा करे तो भी वह हंसता है।
            ऐसा जीवन जीना दुनिया का सबसे मुश्किल काम है, क्योंकि इसमें इंसान को अपना पूरा का पूरा 'ईगो' (Ego) मारना पड़ता है।
        """.trimIndent(),
        english = """
            "That supreme Avadhuta absolutely never wears the external marks or cheap clothes of any specific 'Varna' (Caste) or 'Ashrama' (Life-stage like Celibacy or Sannyasa)."
            "In the blind eyes of society, he might vividly appear exactly like a hypocrite or a wild rule-breaker, strictly because he completely rejects all external, physical rituals of the scriptures."
            "He is absolutely never a pathetic slave to any physical temple, stone idol, or specific direction; he actively roams completely free wherever he desires in the world."
            "His absolute true 'Ashrama' is strictly his very own pure Soul, and his exact 'Varna' is exclusively his pure Non-dual Consciousness."
            The ignorant world perpetually Judges people strictly by their physical Dress; if wearing saffron, a monk, and if wearing a suit, a worldly man.
            But Lord Dattatreya fiercely declares the Avadhuta has risen infinitely high above this cheap Drama (Show-off); he can effortlessly live completely naked or wear royal silk!
            He absolutely does not need any grand Yajna, sacred thread, or bead necklace to frantically please God; strictly because he himself is exactly God.
            Society's fake, hypocritical rules (dictating don't do this, don't do that) are exactly like a cheap spider's web to a terrifying, roaring lion for him!
            He remains completely intoxicated exclusively in the infinite bliss of his own soul; if someone throws stones at him, he merely laughs, and if someone worships him, he still merely laughs.
            Living exactly this specific lifestyle is undeniably the world's absolute hardest task, simply because it demands the human to violently and permanently kill his entire 'Ego'.
        """.trimIndent()
    ),
    AvadhutaShloka(
        id = 7,
        sanskrit = "यत्करोति स तन्नास्ति न पापं न च पुण्यकम् । दग्धाहङ्काररूपत्वात् न लिप्येत कदाचन ॥ ७ ॥",
        hindi = """
            "वह महान अवधूत इस दुनिया में चाहे जो कुछ भी 'कर्म' (Action) करे, वह कर्म उसे कभी बाँध (Bind) नहीं सकता।"
            "उसके द्वारा किया गया कोई भी काम न तो 'पाप' (Sin) होता है, और न ही वह कोई 'पुण्य' (Merit) होता है।"
            "क्योंकि पाप और पुण्य का हिसाब रखने वाला जो 'अहंकार' (Ego / कर्तापन) है, वह उसके अंदर पूरी तरह से जलकर राख हो चुका है।"
            "वह केवल एक खाली 'बांसुरी' (Flute) की तरह है, जिससे ब्रह्मांड की ऊर्जा अपने आप बह रही है; वह खुद कुछ नहीं कर रहा।"
            'कर्म का सिद्धांत' (Law of Karma) आम इंसानों के लिए एक बहुत बड़ी जेल (Jail) है; अगर तुम बुरा करोगे तो सजा मिलेगी, अच्छा करोगे तो इनाम मिलेगा।
            पर यह जेल केवल कैदियों (अज्ञानियों) के लिए है! अवधूत कोई कैदी नहीं है, वह तो इस ब्रह्मांड रूपी जेल का साक्षात् 'मालिक' (भगवान) बन चुका है।
            जब उसके अंदर यह भाव ही नहीं है कि "मैंने यह किया", तो कर्म का फल किसे मिलेगा? (बिना अकाउंट के बैंक पैसे कहाँ भेजेगा?)
            इसलिए अवधूत अगर किसी को मार भी दे, तो उसे पाप नहीं लगता; और अगर वह दुनिया को दान दे दे, तो उसे कोई पुण्य नहीं मिलता!
            वह अच्छे और बुरे (Duality) के इस छोटे से खेल से करोड़ों मील ऊपर उठ चुका है।
            यह अद्वैत का सबसे खूंखार (Fiercest) और परम सत्य है, जिसे केवल एक सच्चा योगी ही समझ सकता है, पाखंडी नहीं।
        """.trimIndent(),
        english = """
            "Absolutely whatever 'Karma' (Action) that magnificent Avadhuta performs in this world, that action can absolutely never, ever Bind him."
            "Any physical action actively performed by him is absolutely neither a 'Sin' (Papa) nor is it ever a 'Merit' (Punya)."
            "Strictly because the toxic 'Ego' (sense of Doership) that anxiously keeps the heavy account of sins and merits has been completely violently burnt to ashes inside him."
            "He is exactly like a completely empty 'Flute' through which the raw cosmic energy is flowing automatically; he himself is absolutely doing nothing."
            The 'Law of Karma' is an exceptionally massive, terrifying Jail explicitly for ordinary humans; if you do bad, you suffer brutal punishment, if good, you receive a reward.
            But this rigid jail is strictly for pathetic inmates (the ignorant)! The Avadhuta is absolutely no inmate, he has flawlessly become the direct 'Master' (God) of this cosmic jail.
            When the arrogant feeling of "I physically did this" absolutely does not exist inside him, exactly who will receive the fruit of karma? (Where will the Bank send money without an Account?)
            Therefore, even if the Avadhuta physically kills someone, absolutely zero sin touches him; and if he donates to the entire world, he acquires absolutely zero merit!
            He has flawlessly and permanently risen millions of miles infinitely above this cheap, petty game of good and evil (Duality).
            This is Advaita's absolute Fiercest, most terrifying, and supreme truth, which exclusively only a true, master Yogi can possibly comprehend, absolutely never a fake hypocrite.
        """.trimIndent()
    ),
    AvadhutaShloka(
        id = 8,
        sanskrit = "अहमेव जगत्सर्वं मयि सर्वं प्रतिष्ठितम् । मयि सर्वं प्रलीयेत तद्ब्रह्मास्म्यहमद्वयम् ॥ ८ ॥",
        hindi = """
            "वह अवधूत अत्यंत दृढ़ता के साथ केवल यही अनुभव करता है: 'मैं ही यह संपूर्ण ब्रह्मांड (अहमेव जगत्सर्वं) हूँ'।"
            "'इस पूरी दुनिया में मेरे (परमात्मा) अलावा कोई दूसरा इंसान, कोई दूसरी वस्तु या कोई दूसरा भगवान बिल्कुल भी मौजूद नहीं है'।"
            "वह अपने-आप में 100% पूर्ण (Complete) है; उसे अपनी ख़ुशी के लिए किसी बाहरी चीज़ या व्यक्ति की रत्ती भर भी आवश्यकता नहीं है।"
            "वह दुनिया की भीड़ में रहता है, फिर भी वह हमेशा 'अकेला' (अद्वैत) और परम शांत रहता है।"
            यह अवधूत का 'फाइनल डिक्लेरेशन' (Final Declaration) है। जब हम खुद को 6 फुट का शरीर मानते हैं, तो दुनिया हमसे बहुत बड़ी और डरावनी लगती है।
            पर जब ध्यान के विस्फोट से अवधूत का 'मैं' (Ego) टूटता है, तो उसकी चेतना (Consciousness) पूरे ब्रह्मांड में इस तरह फैल जाती है कि चाँद और सितारे भी उसके 'अंदर' आ जाते हैं!
            जब आप खुद ही पूरी दुनिया बन गए, तो आप किससे डरेंगे? क्या कोई अपने ही साये (Shadow) से लड़ता है?
            जब बाहर कुछ बचा ही नहीं, तो इंसान को 'परम शांति' मिल जाती है, जिसे मोक्ष कहते हैं।
            अवधूत की आँखों में अब कोई नफरत या लालच नहीं है; वह एक कुत्ते में भी खुद को देखता है और एक राजा में भी खुद को ही देखता है (समदृष्टि)।
            यह कोई कोरी फिलॉसफी (Philosophy) नहीं है; यह उस योगी का 'जीता-जागता अनुभव' (Living Experience) है जिसने माया के सारे परदे फाड़ दिए हैं।
        """.trimIndent(),
        english = """
            "That supreme Avadhuta exceptionally firmly and continuously experiences exclusively this: 'I myself alone am this entire massive universe' (Ahameva jagatsarvam)."
            "'In this entire colossal world, absolutely no second human, no second physical object, and absolutely no second God exists apart from Me (the Supreme Lord)'."
            "He is 100% perfectly and flawlessly Complete in himself; he requires absolutely zero external objects or persons whatsoever for his own supreme joy."
            "He actively lives exactly right in the chaotic physical crowd of the world, yet he permanently remains utterly 'Alone' (Advaita) and profoundly peaceful."
            This is the Avadhuta's absolute 'Final Declaration'. When we falsely consider ourselves a pathetic 6-foot body, the world vividly appears incredibly massive and terrifyingly dangerous.
            But exactly when the Avadhuta's 'Ego' violently shatters through the massive explosion of meditation, his Consciousness expands so flawlessly across the cosmos that even the moon and stars fall perfectly 'Inside' him!
            When you yourself have literally and flawlessly become the entire world, exactly whom will you fiercely fear? Does anyone ever violently fight his very own Shadow?
            When absolutely nothing remains left outside, the human effortlessly attains 'Absolute Peace', which is profoundly known exactly as Moksha.
            Absolutely zero hatred or toxic greed remains in the Avadhuta's eyes now; he clearly sees himself exactly in a street dog and identically sees himself in a rich king (Samadrishti).
            This is absolutely no empty, cheap Philosophy; this is the direct, 'Living Experience' of that master Yogi who has brutally torn apart all the heavy veils of Maya.
        """.trimIndent()
    ),
    AvadhutaShloka(
        id = 9,
        sanskrit = "य इदं अवधूतोपनिषदं अधीते स सर्वपापेभ्यो मुक्तो भवति... स विदेहमुक्तिं प्राप्नोति इत्युपनिषत् । ॐ शान्तिः शान्तिः शान्तिः ॥ ९ ॥",
        hindi = """
            "जो भी साधक इस अत्यंत गुप्त और परम पवित्र 'अवधूत उपनिषद' का सच्चे मन से पाठ करता है और इसे समझता है।"
            "वह निश्चित रूप से उस परम अवधूत (भगवान दत्तात्रेय) की साक्षात् कृपा का अधिकारी बन जाता है।"
            "उसके जन्म-जन्मांतरों के संचित सभी पाप और अज्ञान के भयंकर परदे एक ही झटके में कटकर गिर जाते हैं।"
            "और वह इस झूठे शरीर को छोड़ने के बाद उसी असीम, अनंत और परमानंद स्वरूप परब्रह्म में हमेशा के लिए विलीन (मोक्ष प्राप्त) हो जाता है।"
            यहाँ भगवान दत्तात्रेय अपने ही उपनिषद की '100% गारंटी' (Guarantee) दे रहे हैं।
            इस उपनिषद को केवल पढ़ना नहीं है; इसके चार अक्षरों (अ-व-धू-त) के गहरे अर्थ को अपने खून में उतारना (Apply करना) है।
            जब आप खुद को याद दिलाएंगे कि "मुझे वासनाओं को छोड़ना है (व) और समाज के झूठे नियमों की धूल को धोना है (धू)", तो आपका मन अपने आप शांत होने लगेगा।
            दुनिया के ड्रामे (Show-off) से आज़ाद होना ही असली अध्यात्म (Spirituality) है।
            जो इस अवधूत-ज्ञान को धारण करता है, उसे दुनिया का कोई भी दुख, बीमारी या मौत कभी डरा नहीं सकती; वह जीते-जी भगवान बन जाता है।
            यहीं पर भगवान दत्तात्रेय और सांकृति का यह महान और क्रांतिकारी संवाद 'अवधूत उपनिषद' पूर्ण रूप से संपन्न होता है। ॐ शांतिः!
        """.trimIndent(),
        english = """
            "Whosoever sincere seeker aggressively reads and profoundly understands this exceptionally highly classified and supremely sacred 'Avadhuta Upanishad' with a pure heart."
            "He undoubtedly, certainly, and flawlessly becomes the direct recipient of the absolute grace of that Supreme Avadhuta (Lord Dattatreya Himself)."
            "Absolutely all his accumulated heavy sins from millions of past lifetimes and the terrifying veils of thick ignorance violently shatter and fall away in a single stroke."
            "And exactly after completely shedding this false physical body, he dissolves seamlessly and permanently (attains Moksha) forever strictly into that infinite, boundless, and blissful Supreme Brahman."
            Here, Lord Dattatreya Himself is explicitly providing the absolute '100% Ironclad Guarantee' of His very own magnificent Upanishad.
            This Upanishad absolutely must not merely be casually read; the profound, deep meaning of its four syllables (A-Va-Dhu-Ta) must be violently Applied and downloaded strictly into your blood.
            When you relentlessly remind yourself, "I must absolutely abandon all lusts (Va) and ruthlessly wash away the toxic dust of society's fake rules (Dhu)", your mind will automatically become perfectly calm.
            Becoming 100% flawlessly and permanently free from the world's cheap Drama (Show-off) is exactly what actual, true Spirituality is.
            He who flawlessly actively wears this Avadhuta-wisdom can absolutely never be terrified by any worldly sorrow, severe disease, or horrific death; he effortlessly becomes God while fully alive.
            Right exactly here, this exceptionally magnificent and fiercely revolutionary dialogue between Lord Dattatreya and Sankriti, the 'Avadhuta Upanishad', flawlessly achieves perfect completion. OM Peace!
        """.trimIndent()
    )
)