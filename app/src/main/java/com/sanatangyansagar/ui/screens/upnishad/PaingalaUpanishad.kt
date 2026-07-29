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
data class PaingalaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaingalaUpanishadScreen() {
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
                if (shlokaNumber != null && shlokaNumber in 1..23) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-23)") },
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
            itemsIndexed(paingalaShlokasList) { _, shloka ->
                PaingalaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun PaingalaShlokaCard(shloka: PaingalaShloka) {
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

val paingalaShlokasList: List<PaingalaShloka> = listOf(
    PaingalaShloka(
        id = 1,
        sanskrit = "अथ हैनं पैङ्गल आदिपुरुषं याज्ञवल्क्यमुपसमेत्योवाच । भो याज्ञवल्क्य परमरहस्यं कैवल्यमनुब्रूहीति ॥ १ ॥",
        hindi = """
            (पैंगल उपनिषद का आरंभ): एक बार महर्षि पैंगल, आदिपुरुष (महान ज्ञानी) महर्षि याज्ञवल्क्य के पास अत्यंत विनीत भाव से गए (उपसमेत्योवाच)।
            उन्होंने हाथ जोड़कर पूछा: "हे भगवन् याज्ञवल्क्य! कृपया मुझे उस 'कैवल्य' (परम मोक्ष) का सबसे महान और परम रहस्य (परमरहस्यं) बताइए।"
            कैवल्य का अर्थ है—पूर्ण रूप से 'केवल' (अकेला/Non-dual) हो जाना, जहाँ इंसान को किसी और चीज़ (शरीर, पैसे, रिश्ते) की कोई जरूरत नहीं रहती।
            यह उपनिषद वेदान्त के सबसे महान गुरु (याज्ञवल्क्य) और एक सच्चे खोजी शिष्य (पैंगल) के बीच का सीधा संवाद है।
            संसार में हम कभी 'अकेले' नहीं रह सकते; हमें हमेशा मनोरंजन, बातचीत या सहारे की जरूरत होती है।
            पर जो इंसान दुनिया से थक चुका है, वह मोक्ष (कैवल्य) चाहता है, जहाँ वह अपनी ही आत्मा में 100% संतुष्ट रह सके।
            महर्षि याज्ञवल्क्य यहाँ उसे कोई मंत्र या पूजा नहीं बताते, बल्कि पूरे ब्रह्मांड के बनने और बिगड़ने का 'परम विज्ञान' (Science) समझाते हैं।
            शिष्य का सवाल यह नहीं है कि मैं अमीर कैसे बनूँ; उसका सवाल है कि मैं जन्म और मौत के इस भयानक जेल से हमेशा के लिए आज़ाद कैसे होऊँ?
            बिना इस तड़प (जिज्ञासा) के, किसी भी गुरु का ज्ञान शिष्य के दिल में नहीं उतर सकता।
            यहीं से अद्वैत वेदान्त का यह अत्यंत शक्तिशाली और रहस्यमयी दर्शन शुरू होता है।
        """.trimIndent(),
        english = """
            (The beginning of the Paingala Upanishad): Once, the great Sage Paingala approached the supreme sage Yajnavalkya (the Adipurusha) with extreme humility (Upasametyovacha).
            With folded hands, he asked: "O revered Lord Yajnavalkya! Please instruct me profoundly on the absolute supreme secret (Paramarahasyam) of 'Kaivalya' (Ultimate Liberation)."
            'Kaivalya' strictly means becoming absolutely 'Kevala' (Alone/Non-dual), where a human requires absolutely zero external things (body, money, relations) to be happy.
            This magnificent Upanishad is a direct, profound dialogue strictly between Vedanta's absolute greatest Guru (Yajnavalkya) and a genuine, burning seeker (Paingala).
            In this world, we can never truly remain 'Alone'; we constantly demand entertainment, conversation, or external emotional support.
            But the human who is totally exhausted by the world intensely desires Moksha (Kaivalya), where he remains 100% completely satisfied solely in his own Soul.
            Sage Yajnavalkya does not teach him cheap mantras or external rituals here, but explicitly explains the 'Supreme Science' of the creation and dissolution of the entire cosmos.
            The disciple's question is absolutely not how to become rich; his desperate question is how to become permanently free from this terrifying jail of birth and death.
            Completely without this intense, burning thirst (curiosity), absolutely no Guru's wisdom can ever enter a disciple's heart.
            Exactly from here begins this exceptionally powerful, highly mystical, and brilliant philosophy of Advaita Vedanta.
        """.trimIndent()
    ),
    PaingalaShloka(
        id = 2,
        sanskrit = "स होवाच याज्ञवल्क्यः । सदेव सोम्येदमग्र आसीत् । तदेकमद्वितीयं ब्रह्म ॥ २ ॥",
        hindi = """
            महर्षि याज्ञवल्क्य ने अत्यंत प्रेम से उत्तर दिया (स होवाच): "हे सौम्य (प्रिय शिष्य पैंगल)! यह संपूर्ण ब्रह्मांड उत्पन्न होने से पहले (अग्र आसीत्) केवल 'सत्' (Sat / Pure Existence) ही था।"
            "वह सत् और कुछ नहीं, बल्कि वह केवल 'एक' (Ekam) और 'अद्वितीय' (Advitiyam / जिसके जैसा दूसरा कोई नहीं) परम ब्रह्म ही है।"
            यहाँ याज्ञवल्क्य दुनिया की उत्पत्ति (Big Bang) से भी पहले की स्थिति का वर्णन कर रहे हैं।
            हम सोचते हैं कि दुनिया हमेशा से ऐसी ही थी, पर उपनिषद कहता है कि जब न ग्रह थे, न इंसान, न समय और न ही स्पेस (Space), तब क्या था?
            तब केवल एक 'सत्' (Existence) था। वह सत् कोई आकार या इंसान नहीं है; वह बस 'होने का अहसास' (Pure Being) है।
            वह 'एक' है (यानी दो भगवान नहीं हैं), और वह 'अद्वितीय' है (यानी उस भगवान के टुकड़े या हिस्से भी नहीं किए जा सकते)।
            जैसे सोने के गहने पिघलाने के बाद केवल 'सोना' ही बचता है, वैसे ही दुनिया के पिघलने के बाद केवल वह एक ब्रह्म बचता है।
            अज्ञान यह है कि हम सोचते हैं "मैं अलग हूँ और भगवान अलग है।"
            पर जब शुरुआत में केवल 'एक' ही था, तो हम कहाँ से आए? हम भी उसी एक ब्रह्म का ही रूप हैं।
            यह श्लोक अद्वैत दर्शन की वह सबसे मजबूत नींव (Foundation) है जिस पर इंसान के मोक्ष की इमारत खड़ी होती है।
        """.trimIndent(),
        english = """
            The great Sage Yajnavalkya answered with extreme affection (Sa hovacha): "O gentle disciple (Somya Paingala)! Before this entire visible cosmos was created (Agra asit), absolutely only 'Sat' (Pure Existence) existed."
            "That absolute 'Sat' is nothing else but strictly that 'One' (Ekam) and 'Non-dual' (Advitiyam / having no second or equal) Supreme Brahman alone."
            Here, Yajnavalkya is profoundly describing the absolute state that existed even long before the creation of the world (The Big Bang).
            We foolishly assume the world was always like this, but the Upanishad asks: when there were no planets, humans, time, or physical Space, what existed?
            Exactly then, absolutely only 'Sat' (Pure Existence) existed. That Sat is absolutely no physical form or human; it is simply 'Pure Being' (Consciousness).
            He is 'One' (meaning there are not two Gods), and He is 'Non-dual' (meaning that God absolutely cannot be divided into pieces or fractions).
            Just exactly as when golden ornaments are entirely melted down, absolutely only pure 'Gold' remains, similarly when the world dissolves, exclusively that one Brahman remains.
            Ignorance is falsely thinking that "I am completely separate and God is completely separate."
            But when in the absolute beginning there was strictly only 'One', where did we come from? We too are exactly the direct manifestation of that one Brahman.
            This phenomenal verse is the absolute strongest Foundation of Advaita philosophy upon which the majestic building of human Moksha firmly stands.
        """.trimIndent()
    ),
    PaingalaShloka(
        id = 3,
        sanskrit = "तस्य पञ्चकञ्चुकवत्यविद्या मूलाप्रकृतिर्लोहितशुक्लकृष्णा । तस्याः प्रतिबिम्बितं यत् स ईश्वरः ॥ ३ ॥",
        hindi = """
            (ईश्वर की उत्पत्ति कैसे हुई?): उस परब्रह्म में एक 'अविद्या' (मूल प्रकृति / Maya) प्रकट हुई, जो पाँच आवरणों (पञ्चकञ्चुक) वाली है और जो लाल, सफेद और काले रंग की है (लोहित-शुक्ल-कृष्णा)।
            जब उस अत्यंत शुद्ध परब्रह्म का 'प्रतिबिंब' (Reflection / परछाईं) उस मूल प्रकृति (माया) के शीशे पर पड़ा, तो वह प्रतिबिंब ही साक्षात् 'ईश्वर' (God/Creator) कहलाया।
            यह श्लोक वेदान्त का सबसे बड़ा 'माइंड-ब्लोइंग' (Mind-blowing) सीक्रेट है: ब्रह्म (Brahman) और ईश्वर (God) अलग-अलग हैं!
            ब्रह्म निर्गुण है (उसका कोई काम, रूप या इच्छा नहीं है); वह बस एक शुद्ध स्क्रीन (Screen) है।
            पर जब उस स्क्रीन पर 'माया' (प्रकृति) की फिल्म चलने लगती है, तो ब्रह्म का जो रूप प्रकृति को कंट्रोल करता है, उसे 'ईश्वर' कहते हैं।
            प्रकृति के तीन रंग हैं: लाल (रजोगुण/एक्टिविटी), सफेद (सत्त्वगुण/शांति), और काला (तमोगुण/अंधेरा)।
            ईश्वर वह है जो इस माया को अपने 100% कंट्रोल (Control) में रखता है; माया ईश्वर की दासी है।
            जैसे सूरज की परछाईं पानी में पड़ती है, पर सूरज पानी से गीला नहीं होता; वैसे ही ब्रह्म की परछाईं माया में पड़ती है और वह 'ईश्वर' बन जाता है।
            ईश्वर ही इस पूरी दुनिया को बनाता है, चलाता है और खत्म करता है; पर परब्रह्म इस सबसे पूरी तरह ऊपर और शांत रहता है।
            यह समझ इंसान को धार्मिक अंधविश्वासों से निकालकर साक्षात् 'ब्रह्मांडीय विज्ञान' (Cosmic Science) में ले जाती है।
        """.trimIndent(),
        english = """
            (How exactly did Ishvara manifest?): Within that Supreme Brahman, an 'Avidya' (Mula Prakriti / Maya) manifested, possessing exactly five limiting sheaths (Panchakanchuka) and colored red, white, and black (Lohita-shukla-krishna).
            When the brilliant 'Reflection' (Pratibimbitam) of that absolutely pure Brahman fell directly upon the mirror of that Mula Prakriti (Maya), that exact reflection became profoundly known as 'Ishvara' (God/The Creator).
            This spectacular verse is Vedanta's absolute greatest 'Mind-blowing' secret: Brahman (The Absolute) and Ishvara (The Creator God) are strictly different!
            Brahman is Nirguna (possessing zero attributes, actions, or desires); He is merely a pure, blank cosmic Screen.
            But when the vivid movie of 'Maya' (Nature) actively begins playing on that screen, the specific aspect of Brahman that flawlessly controls Prakriti is called 'Ishvara'.
            Prakriti has exactly three colors: Red (Rajoguna/Activity), White (Sattvaguna/Peace), and Black (Tamoguna/Darkness).
            Ishvara is He who keeps this Maya under His 100% absolute Control; Maya is strictly Ishvara's obedient maidservant.
            Exactly just as the sun's reflection falls flawlessly in water, yet the sun never gets wet; similarly, Brahman's reflection falls perfectly in Maya and becomes 'Ishvara'.
            Ishvara alone exclusively creates, sustains, and destroys this entire world; but the Supreme Brahman remains completely above all this, flawlessly tranquil forever.
            This profound understanding violently pulls a human out of blind religious superstitions directly into pure 'Cosmic Science'.
        """.trimIndent()
    ),
    PaingalaShloka(
        id = 4,
        sanskrit = "स ईश्वरः स्वाधीनमयावृत्तिः सन् सृष्टिस्थितिलयान् करोति । स एव जगत्कारणम् ॥ ४ ॥",
        hindi = """
            वह 'ईश्वर' (माया में प्रतिबिंबित ब्रह्म) अपनी उस माया (स्वाधीनमयावृत्तिः) को पूरी तरह से अपने अधीन (कंट्रोल में) रखकर।
            इस संपूर्ण ब्रह्मांड की 'सृष्टि' (Creation / रचना), 'स्थिति' (Sustainment / पालन), और 'लय' (Destruction / प्रलय) का महान कार्य करता है (करोति)।
            वह ईश्वर ही इस दिखाई देने वाले संपूर्ण 'जगत का एकमात्र मूल कारण' (जगत्कारणम्) है।
            जीव (हम इंसान) और ईश्वर में सबसे बड़ा फर्क क्या है? जीव माया (वासनाओं और अज्ञान) का गुलाम है, जबकि ईश्वर माया का 'मालिक' (Master) है।
            ईश्वर माया का इस्तेमाल दुनिया बनाने के लिए करता है, पर वह कभी माया के जाल में फँसता नहीं है; जैसे एक जादूगर अपने ही जादू से नहीं डरता।
            ब्रह्मा (बनाने वाला), विष्णु (चलाने वाला) और शिव (मिटाने वाला)—ये तीनों उसी एक 'ईश्वर' के तीन अलग-अलग डिपार्टमेंट (Departments) हैं।
            दुनिया किसी एक्सीडेंट (Accident) से या अपने-आप नहीं बनी है; इसके पीछे एक अत्यंत बुद्धिमान और सर्वशक्तिमान 'कारण' (Cause) है, जिसे ईश्वर कहते हैं।
            जैसे मिट्टी के बिना घड़ा नहीं बन सकता, वैसे ही ईश्वर के बिना यह दुनिया नहीं बन सकती; वही इस दुनिया का 'रॉ मटेरियल' (Raw Material) भी है और 'बनाने वाला' भी है।
            जब इंसान इस सच्चाई को समझ लेता है, तो वह दुनिया की छोटी-मोटी समस्याओं से डरना छोड़ देता है, क्योंकि उसे पता है कि इस खेल का कंट्रोलर (Controller) साक्षात् ईश्वर है।
            यही ईश्वर की वह महान सत्ता है जिसके आगे हर जीव को अपना अहंकार झुका देना चाहिए।
        """.trimIndent(),
        english = """
            That 'Ishvara' (Brahman flawlessly reflected in Maya), keeping His absolute Maya completely and entirely under His own strict Control (Svadhinamayavrittih).
            Effortlessly performs (Karoti) the magnificent cosmic tasks of 'Srishti' (Creation), 'Sthiti' (Sustenance), and 'Laya' (Absolute Destruction) of this entire massive universe.
            That Ishvara alone is unequivocally the sole, absolute root 'Cause of this entire visible World' (Jagatkaranam).
            What is the absolute greatest difference between a Jiva (us humans) and Ishvara? The Jiva is a pathetic slave to Maya (lust and ignorance), whereas Ishvara is the supreme 'Master' of Maya.
            Ishvara brilliantly utilizes Maya to consciously construct the world, but He absolutely never gets trapped in Maya's deceptive web; just as a master magician is never terrified by his own magic tricks.
            Brahma (Creator), Vishnu (Sustainer), and Shiva (Destroyer)—these three are simply three distinct functional 'Departments' of that exact same one 'Ishvara'.
            The world absolutely did not come into existence by a cheap cosmic Accident or on its own; directly behind it stands an exceptionally intelligent, omnipotent 'Cause', which is Ishvara.
            Just exactly as a pot simply cannot be formed without wet clay, this massive world cannot exist without Ishvara; He is both the 'Raw Material' and the actual 'Creator' of this world.
            When a human profoundly understands this absolute truth, he completely stops fearing trivial worldly problems, knowing flawlessly that the ultimate Controller of this game is God Himself.
            This is the absolute, majestic authority of Ishvara before which every single creature must ruthlessly bow down and shatter its ego.
        """.trimIndent()
    ),
    PaingalaShloka(
        id = 5,
        sanskrit = "तस्मादीश्वरात् तमोगुणाभिभूतावरणशक्तिविशिष्टात् विक्षेपशक्तिमदज्ञानमुत्पन्नम् । तदज्ञानप्रतिबिम्बितं यत् स जीवः ॥ ५ ॥",
        hindi = """
            (जीव / इंसान कैसे पैदा हुआ?): उस ईश्वर से, जब उसकी 'तमोगुण' (अज्ञान/अंधेरा) प्रधान 'आवरण शक्ति' (सत्य को ढँकने वाली शक्ति) एक्टिवेट (Activate) हुई।
            तो उससे एक भयंकर 'विक्षेप शक्ति' (भटकने वाली शक्ति / Projection) से युक्त 'अज्ञान' (Ignorance) की उत्पत्ति हुई (मुत्पन्नम्)।
            और जब उस अत्यंत मलिन 'अज्ञान' के शीशे पर उस शुद्ध परब्रह्म का प्रतिबिंब (Reflection) पड़ा, तो वही 'जीव' (Individual soul / इंसान) कहलाया!
            यह श्लोक अद्वैत वेदान्त का सबसे बड़ा धमाका (Explosion) है जो हमारी औकात (Reality) बताता है।
            ईश्वर माया (शुद्ध सत्वगुण) का प्रतिबिंब है, पर इंसान 'अज्ञान' (मलिन तमोगुण) का प्रतिबिंब है।
            आवरण शक्ति वह है जो हमारे असली रूप (मैं ब्रह्म हूँ) को पूरी तरह से ढँक (Cover) लेती है।
            और विक्षेप शक्ति वह है जो हमें एक झूठा रूप (मैं शरीर हूँ, मैं दुखी हूँ) दिखाती है।
            जैसे साफ पानी में सूरज की परछाईं बहुत साफ और शांत (ईश्वर) दिखती है; पर कीचड़ भरे और हिलते हुए पानी में सूरज की परछाईं गंदी और टूटी हुई (जीव) दिखती है।
            जीव (हम) वास्तव में वही सूरज (ब्रह्म) हैं, बस हम अज्ञान के 'गंदे और हिलते हुए पानी' में फँस गए हैं।
            जब इंसान योग और ध्यान के द्वारा इस 'अज्ञान के पानी' को साफ कर लेता है, तो वह 'जीव' से वापस 'ब्रह्म' बन जाता है।
        """.trimIndent(),
        english = """
            (How exactly was the Jiva / human born?): From that exact Ishvara, when His 'Avarana Shakti' (the terrifying power that completely veils the Truth), highly dominated by 'Tamoguna' (darkness), actively awakened.
            From that, a massive, terrifying 'Ignorance' (Ajnana) endowed perfectly with 'Vikshepa Shakti' (the brutal power of false projection and distraction) was aggressively produced (Mutpannum).
            And exactly when the brilliant Reflection (Pratibimbitam) of that pure Brahman fell heavily upon the filthy, dirty mirror of that 'Ignorance', that exact reflection became known as the 'Jiva' (Individual soul)!
            This phenomenal verse is Advaita Vedanta's absolute biggest Explosion, ruthlessly revealing our actual, brutal Reality.
            Ishvara is the direct reflection in pure Maya (Sattvaguna), but the human is merely a cheap reflection in completely filthy 'Ignorance' (Tamoguna).
            'Avarana Shakti' is that terrifying power that flawlessly completely Covers and hides our true, original nature ("I am Brahman").
            And 'Vikshepa Shakti' is that brutal power that violently projects a completely false identity onto us ("I am this physical body, I am deeply miserable").
            Just exactly as the sun's reflection in perfectly pristine, still water appears brilliant and calm (Ishvara); but the sun's reflection in shaking, filthy mud-water appears severely distorted, dirty, and broken (Jiva).
            The Jiva (we) are in absolute reality that exact same Sun (Brahman), we are simply hopelessly trapped in the 'dirty, violently shaking water' of thick ignorance.
            When a human flawlessly cleans this 'water of ignorance' strictly through deep Yoga and meditation, he instantly transforms from a pathetic 'Jiva' right back into the Supreme 'Brahman'.
        """.trimIndent()
    ),
    PaingalaShloka(
        id = 6,
        sanskrit = "स जीवः कर्तृत्वभोक्तृत्वाद्यभिमानवान् । जाग्रत्स्वप्नसुषुप्तिमूर्च्छादिष्ववस्थासु परिभ्रमन् ॥ ६ ॥",
        hindi = """
            (जीव की दुर्दशा): वह 'जीव' (इंसान) अज्ञान के कारण स्वयं को शरीर मानकर "मैं ही कर्ता (काम करने वाला) हूँ" और "मैं ही भोक्ता (सुख-दुख भोगने वाला) हूँ"—ऐसे भयंकर 'अभिमान' (Ego/घमंड) से भर जाता है।
            और उसी झूठे अहंकार के कारण वह जीव लगातार जाग्रत (जागना), स्वप्न (सपने देखना), सुषुप्ति (गहरी नींद) और मूर्च्छा (बेहोशी/मौत) आदि भयंकर अवस्थाओं में।
            एक भिखारी की तरह दर-दर भटकता और चक्कर काटता (परिभ्रमन् / Wandering) रहता है।
            यह श्लोक 'संसार' (Matrix) में फँसे हुए इंसान की सबसे दर्दनाक और सच्ची कहानी (Tragedy) है।
            आत्मा (ब्रह्म) कभी कोई काम नहीं करती, वह केवल शांत 'साक्षी' (Witness) है; पर जीव अज्ञान के कारण सोचता है कि "मैंने पैसे कमाए, मैंने घर बनाया" (कर्तृत्व)।
            और जब नुकसान होता है तो रोता है कि "मैं बर्बाद हो गया" (भोक्तृत्व)।
            यही 'मैं' (Ego) की बीमारी जीव को कभी चैन से बैठने नहीं देती; वह दिन में ऑफिस के झंझटों (जाग्रत) में पिसता है।
            रात को डरावने सपने (स्वप्न) देखता है, और मौत (मूर्च्छा) के बाद फिर से एक नए शरीर के लिए भटकने (परिभ्रमन्) लगता है।
            यह एक ऐसा 'लूप' (Endless loop) है जिसमें इंसान करोड़ों सालों से एक रोबोट (Robot) की तरह घूम रहा है।
            इस भयंकर लूप को तोड़ने का केवल एक ही तरीका है: यह जान लेना कि "मैं कर्ता नहीं, मैं असीम ब्रह्म हूँ।"
        """.trimIndent(),
        english = """
            (The tragic plight of the Jiva): That 'Jiva' (human), strictly due to thick ignorance, falsely identifying as the physical body, becomes intensely filled with the terrifying 'Abhimana' (Toxic Ego) of "I am the absolute Doer" (Kartritva) and "I am the Experiencer" (Bhoktritva).
            And entirely, strictly because of that utterly false, blinding ego, that helpless Jiva continuously and helplessly wanders and violently revolves (Paribhraman).
            Exactly like a pathetic beggar through the terrifying, endless states of waking (Jagrat), dreaming (Svapna), deep sleep (Sushupti), and swooning/death (Murcha).
            This magnificent verse is the absolute most heartbreaking, ruthlessly true Tragedy of a human helplessly trapped in 'Samsara' (The Matrix).
            The Soul (Brahman) absolutely never performs any action, it is merely a perfectly silent 'Witness'; but the ignorant Jiva foolishly thinks, "I proudly earned this money, I built this house" (Doership).
            And exactly when severe loss strikes, he violently cries, "I am completely ruined and destroyed" (Experiencership).
            This lethal disease of the 'I' (Ego) absolutely never lets the Jiva sit in peace; he is brutally crushed in office politics during the day (Waking).
            He suffers terrifying nightmares at night (Dreaming), and after death (Murcha), aggressively begins wandering (Paribhraman) helplessly seeking yet another new physical body.
            This is an exceptionally terrifying 'Endless Loop' in which the human has been blindly revolving exactly like a programmed Robot for millions of years.
            There is strictly only one absolute way to completely shatter this horrific loop: profoundly realizing that "I am absolutely not the doer, I am the infinite Brahman."
        """.trimIndent()
    ),
    PaingalaShloka(
        id = 7,
        sanskrit = "ततो विक्षेपशक्त्या पञ्चतन्मात्राणि । शब्दस्पर्शरूपरसगन्धा जायन्ते ॥ ७ ॥",
        hindi = """
            (ब्रह्मांड के पाँच भौतिक तत्वों का निर्माण): उसके बाद (ततो), ईश्वर की उस 'विक्षेप शक्ति' (Projecting Power / सृष्टि रचने वाली ऊर्जा) के द्वारा।
            सबसे पहले 'पञ्चतन्मात्राएं' (पाँच अत्यंत सूक्ष्म तत्व / Five Subtle Elements) पैदा (जायन्ते) होती हैं।
            ये पाँच तन्मात्राएं हैं: शब्द (Sound), स्पर्श (Touch), रूप (Form/Color), रस (Taste), और गंध (Smell)।
            (इन्हीं पाँच सूक्ष्म तन्मात्राओं से आगे चलकर आकाश, वायु, अग्नि, जल और पृथ्वी नाम के पाँच स्थूल / Solid तत्व बनेंगे)।
            यहाँ उपनिषद 'क्वांटम फिजिक्स' (Quantum Physics) से भी आगे का अत्यंत सूक्ष्म विज्ञान समझा रहा है।
            दुनिया सीधे ठोस ईंट और पत्थरों (पृथ्वी) के रूप में पैदा नहीं हुई थी; सबसे पहले केवल 'फ्रीक्वेंसी' (Frequencies / तन्मात्राएं) पैदा हुई थीं।
            'शब्द' से आकाश (Space) बना, 'स्पर्श' से हवा (Air) बनी, 'रूप' से आग (Fire) बनी, 'रस' से पानी (Water) बना, और 'गंध' से मिट्टी (Earth) बनी।
            ईश्वर की यह 'विक्षेप शक्ति' (Projection) बिल्कुल एक 3D प्रोजेक्टर (Projector) की तरह काम करती है, जो शून्य से एक पूरा का पूरा ब्रह्मांड खड़ा कर देती है।
            हमारी ज्ञानेंद्रियां (आँख, कान, नाक) केवल इन्हीं 5 'तन्मात्राओं' (Frequencies) को डिकोड (Decode) करती हैं, और हमारे दिमाग में 'दुनिया' का इल्यूजन (Illusion) बन जाता है।
            अगर इन पाँच तन्मात्राओं को हटा लिया जाए, तो यह पूरा ठोस ब्रह्मांड एक सेकंड में गायब होकर वापस 'ईश्वर' में लीन हो जाएगा।
        """.trimIndent(),
        english = """
            (The creation of the five physical elements of the cosmos): Thereafter (Tato), strictly through that exceptionally powerful 'Vikshepa Shakti' (Projecting Power / the cosmic energy of creation) of Ishvara.
            The absolute first things to be born and produced (Jayante) are the 'Pancha-Tanmatras' (The Five extremely Subtle Elements / Frequencies).
            These exact five Tanmatras are: Shabda (Sound), Sparsha (Touch), Rupa (Form/Color), Rasa (Taste), and Gandha (Smell).
            (It is strictly and entirely from these five subtle Tanmatras that the five Gross/Solid elements—Space, Air, Fire, Water, and Earth—are subsequently manufactured).
            Here, the Upanishad is profoundly explaining an exceptionally subtle science existing far beyond even modern 'Quantum Physics'.
            The world was absolutely not created directly in the form of solid bricks and heavy stones (Earth); initially, absolutely only pure 'Frequencies' (Tanmatras) were created.
            From 'Sound' came Space, from 'Touch' came Air, from 'Form' came Fire, from 'Taste' came Water, and exactly from 'Smell' came the solid Earth.
            This 'Vikshepa Shakti' (Projection) of Ishvara operates flawlessly, exactly like a hyper-advanced 3D Projector, aggressively projecting an entire colossal universe completely out of zero.
            Our physical sense organs (eyes, ears, nose) merely relentlessly Decode these exact 5 'Tanmatras' (Frequencies), instantly generating the highly realistic Illusion of the 'World' right inside our brain.
            If these exact five Tanmatras are completely withdrawn, this entire massive, solid universe will permanently vanish in a single split-second and merge flawlessly back into 'Ishvara'.
        """.trimIndent()
    ),
    PaingalaShloka(
        id = 8,
        sanskrit = "तेभ्यः पञ्चमहाभूतानि पञ्चीकरणक्रमेणोत्पद्यन्ते । तानि ब्रह्माण्डं तदन्तर्गतचतुर्दशभुवनानि तदन्तर्गतजीवान् देहांश्चाण्डजान् स्वेदजान् उद्भिज्जान् जरायुजान् ॥ ८ ॥",
        hindi = """
            (पञ्चीकरण और संसार की रचना): उन पाँच सूक्ष्म तन्मात्राओं से, 'पञ्चीकरण' (Panchikarana / 5 तत्वों को आपस में एक खास अनुपात में मिलाने की प्रक्रिया) के द्वारा।
            पाँच 'महाभूत' (पाँच स्थूल तत्व: पृथ्वी, जल, अग्नि, वायु, आकाश) उत्पन्न होते हैं।
            और फिर इन्हीं 5 महाभूतों से यह पूरा विशाल 'ब्रह्मांड' (Cosmic Egg) बनता है; और इसी ब्रह्मांड के अंदर मौजूद चौदह (14) भुवन (लोक / Worlds) बनते हैं।
            और उन्हीं 14 लोकों के अंदर रहने वाले अनगिनत जीव और उनके शरीर (देह) बनते हैं, जो चार प्रकार के होते हैं:
            1. अण्डज (अंडे से पैदा होने वाले - पक्षी/साँप), 2. स्वेदज (पसीने/गंदगी से पैदा होने वाले - कीड़े/मच्छर), 3. उद्भिज्ज (ज़मीन फाड़कर पैदा होने वाले - पेड़/पौधे), और 4. जरायुज (गर्भ/Placenta से पैदा होने वाले - इंसान/जानवर)।
            यह श्लोक 'कॉस्मोलॉजी' (Cosmology) और 'बायोलॉजी' (Biology) का सबसे बड़ा मास्टरपीस (Masterpiece) है।
            'पञ्चीकरण' वेदान्त का वह महान सिद्धांत है जो बताता है कि दुनिया की कोई भी चीज़ 100% शुद्ध (Pure) नहीं है; हर चीज़ में पाँचों तत्वों का एक मिक्सचर (Mixture/Formula) मौजूद है।
            इसी मिक्सचर से 14 लोक (7 ऊपर के स्वर्ग/धरती और 7 नीचे के पाताल) बनते हैं।
            और इन्हीं तत्वों से चार प्रकार के अलग-अलग 'डीएनए' (DNA/Reproduction system) वाले करोड़ों जीवों की प्रजातियां (Species) बनती हैं।
            यह साबित करता है कि चाहे इंसान हो या एक छोटा सा मच्छर, हम सब एक ही 'रॉ मटेरियल' (Raw Material / 5 महाभूत) से बनी हुई मशीनें हैं।
        """.trimIndent(),
        english = """
            (Panchikarana and the precise creation of the world): From those five extremely subtle Tanmatras, strictly through the highly complex process of 'Panchikarana' (the specific mathematical mixing of 5 elements in a precise ratio).
            The Five 'Mahabhutas' (Five Gross physical elements: Earth, Water, Fire, Air, Space) are violently and perfectly produced.
            And then, exclusively from these exact 5 Mahabhutas, this entire colossal 'Brahmanda' (Cosmic Egg / Universe) is manufactured; and completely within it, the Fourteen (14) Bhuvanas (Realms / Worlds) are perfectly formed.
            And residing entirely within those 14 worlds, countless millions of Jivas (Souls) and their physical bodies (Dehas) are created, which are strictly categorized into exactly four distinct types:
            1. Andaja (born directly from eggs - birds/snakes), 2. Svedaja (born strictly from sweat/moisture - insects/mosquitoes), 3. Udbhijja (born by violently piercing the earth - trees/plants), and 4. Jarayuja (born from the womb/placenta - humans/mammals).
            This extraordinary verse is the absolute greatest Masterpiece uniting ancient 'Cosmology' and advanced 'Biology'.
            'Panchikarana' is that supreme Vedantic principle revealing that absolutely nothing in this physical world is 100% Pure; everything is a highly specific, complex Mixture (Formula) of all five elements together.
            It is exactly from this complex mixture that the 14 realms (7 upper heavens/earth and 7 lower netherworlds) are meticulously constructed.
            And strictly from these very elements, millions of distinct species with exactly four completely different 'DNA' (Reproduction systems) are flawlessly manufactured.
            This undeniably proves that whether it is an arrogant human or a tiny, filthy mosquito, we are all absolutely nothing but biological machines manufactured entirely from the exact same 'Raw Material' (the 5 Mahabhutas).
        """.trimIndent()
    ),
    PaingalaShloka(
        id = 9,
        sanskrit = "अन्नमयादिपञ्चकोशैरन्तः प्रविष्टो जीवः । जाग्रत्स्वप्नसुषुप्तिमूर्च्छाख्याश्चतस्रोऽवस्थाः ॥ ९ ॥",
        hindi = """
            (जीव कैसे फँसता है): वह असीम आत्मा (जीव) इस भौतिक शरीर के 'अन्नमय' आदि पाँच अत्यंत घने कोषों (Pancha-koshas / Sheaths / परतों) के भीतर पूरी तरह से प्रवेश (प्रविष्टो / फँस) जाता है।
            (वे 5 कोष हैं: अन्नमय, प्राणमय, मनोमय, विज्ञानमय, और आनंदमय कोष)।
            इन पाँच परतों की जेल में फँसने के बाद, वह जीव मुख्य रूप से चार प्रकार की भयंकर अवस्थाओं (States) का निरंतर अनुभव करता है।
            वे चार अवस्थाएं हैं: 1. जाग्रत (जागना / Waking), 2. स्वप्न (सपने देखना / Dreaming), 3. सुषुप्ति (गहरी नींद / Deep Sleep), और 4. मूर्च्छा (बेहोशी या कोमा / Swooning)।
            उपनिषद यहाँ आत्मा की 'जेल' (Prison) का पूरा ब्लूप्रिंट (Blueprint) दे रहा है। आत्मा कभी सीधे शरीर में नहीं आती, वह 5 'कवर' (Covers) पहनती है।
            अन्नमय (भौतिक शरीर), प्राणमय (साँसें/ऊर्जा), मनोमय (इमोशन्स/Emotions), विज्ञानमय (बुद्धि), और आनंदमय (अज्ञान की शांति)।
            इन 5 भारी जैकेटों (Jackets) को पहनने के बाद आत्मा अपनी असली आज़ादी (Freedom) भूलकर एक लाचार 'इंसान' बन जाती है।
            और फिर उसे जीवन भर 4 अवस्थाओं में पीसा जाता है। जाग्रत में वह दुनिया के धक्के खाता है; स्वप्न में वह अपने ही ख्यालों से डरता है।
            सुषुप्ति में वह अज्ञान के अंधेरे में सोता है, और मूर्च्छा (मौत/बीमारी) में वह तड़प कर बेहोश हो जाता है।
            अध्यात्म (Spirituality) का पूरा मकसद इन 5 कोषों के 'कवर' को एक-एक करके उतार कर आत्मा को वापस आज़ाद (Liberate) करना ही है।
        """.trimIndent(),
        english = """
            (How exactly the Soul is trapped): That boundless, infinite Soul (Jiva) deeply enters and becomes helplessly trapped (Pravishto) entirely within the incredibly dense five sheaths/layers (Pancha-koshas) starting with the 'Annamaya'.
            (Those exact 5 tight sheaths are: Annamaya/food, Pranamaya/energy, Manomaya/mind, Vijnanamaya/intellect, and Anandamaya/bliss of ignorance).
            Violently imprisoned inside the inescapable jail of these five heavy layers, that helpless Jiva continuously and repeatedly experiences exactly four terrifying states (Avasthas).
            Those exact four states are: 1. Jagrat (Waking), 2. Svapna (Dreaming), 3. Sushupti (Deep, dreamless sleep), and 4. Murcha (Swooning, coma, or near-death).
            The Upanishad explicitly provides the complete, flawless Blueprint of the Soul's terrifying 'Prison' right here. The Soul never directly enters the body; it aggressively puts on 5 heavy 'Covers'.
            Annamaya (gross physical body), Pranamaya (vital breath/energy), Manomaya (chaotic emotions), Vijnanamaya (calculating intellect), and Anandamaya (the dark peace of ignorance).
            After wearing these 5 suffocating, heavy Jackets, the Soul completely forgets its absolute original Freedom and devolves into a pathetic, helpless 'Human'.
            And then he is brutally ground down in these 4 states for his entire life. In waking, he suffers the harsh blows of the world; in dreams, he is terrified by his own thoughts.
            In deep sleep, he slumbers in dark ignorance, and in Murcha (severe illness/death), he helplessly thrashes and loses consciousness entirely.
            The absolute sole purpose of all Spirituality is strictly to systematically peel off these 5 thick 'Covers' one by one and Liberate the pure Soul once again forever.
        """.trimIndent()
    ),
    PaingalaShloka(
        id = 10,
        sanskrit = "नेत्रकण्ठहृदयमस्तकेषु जाग्रदाद्यवस्थाः । तत्र तत्र स्थित्वा कर्मफलानि भुङ्क्ते ॥ १० ॥",
        hindi = """
            (चेतना का शरीर में निवास): मनुष्य की ये चारों अवस्थाएं (जाग्रत, स्वप्न, सुषुप्ति और मूर्च्छा) शरीर के चार अलग-अलग स्थानों पर मुख्य रूप से काम करती हैं।
            'जाग्रत' अवस्था (जागना) का मुख्य केंद्र मनुष्य के 'नेत्र' (आँखें / Eyes) हैं।
            'स्वप्न' अवस्था का मुख्य केंद्र 'कण्ठ' (गला / Throat) है; 'सुषुप्ति' (गहरी नींद) का मुख्य केंद्र 'हृदय' (Heart) है; और 'मूर्च्छा' (बेहोशी/ध्यान) का केंद्र 'मस्तक' (Brain / Crown) है।
            वह जीव (चेतना) इन अलग-अलग स्थानों (तत्र तत्र) पर स्थित (ठहर) कर ही अपने पुराने 'कर्मों के फलों' (सुख-दुख) को लगातार भोगता (भुङ्क्ते) रहता है।
            यह वेदान्त का एक अत्यंत गहरा 'न्यूरोसाइंस' (Neuroscience) है। जब हम जागते हैं, तो हमारी सारी एनर्जी (Energy) आँखों में आ जाती है, जिससे हम दुनिया देखते हैं।
            जब हम सपने देखते हैं, तो हमारी चेतना खिसक कर गले (विशुद्धि चक्र) में आ जाती है; इसीलिए सपनों में हम अजीबोगरीब आवाजें या बातें महसूस करते हैं।
            जब हम गहरी नींद में होते हैं, तो चेतना दिल (अनाहत चक्र) में छुप जाती है, जहाँ कोई विचार नहीं पहुँच पाता (पूर्ण शांति)।
            और मूर्च्छा (कोमा या गहरी समाधि) में चेतना सीधे मस्तक (सहस्रार) में सिकुड़ जाती है।
            उपनिषद बता रहा है कि जीव कभी 'आज़ाद' नहीं बैठता; वह शरीर के इन चार कमरों में लिफ्ट (Elevator) की तरह ऊपर-नीचे होता रहता है।
            और हर कमरे में उसे उसके कर्मों के हिसाब से नई फिल्म (दुख या सुख) दिखाई जाती है, जिसे उसे मजबूरी में भोगना (भुङ्क्ते) ही पड़ता है।
        """.trimIndent(),
        english = """
            (The exact residence of Consciousness in the body): These exact four states (waking, dreaming, deep sleep, and swooning) actively function primarily from four completely distinct physical locations in the body.
            The primary, absolute center for the 'Jagrat' state (Waking) is explicitly the human 'Eyes' (Netra).
            The main center for the 'Svapna' state (Dreaming) is the 'Throat' (Kantha); the absolute center for 'Sushupti' (Deep Sleep) is the 'Heart' (Hridaya); and the supreme center for 'Murcha' (Swooning/Samadhi) is the 'Head' (Brain / Mastaka).
            That helpless Jiva (Consciousness), actively shifting and halting specifically at these exact different locations (Tatra tatra), continuously and unavoidably suffers and enjoys (Bhunkte) the heavy 'Fruits of his past Karmas' (joy and sorrow).
            This is an exceptionally profound, highly advanced 'Neuroscience' of Vedanta. When we are fully awake, our entire vital Energy aggressively rushes to the eyes, allowing us to see the world.
            When we vividly dream, our consciousness physically slides down and anchors in the throat (Vishuddhi Chakra); exactly why we experience bizarre internal dialogues and voices in dreams.
            When we fall into extremely deep sleep, the consciousness hides securely inside the physical heart (Anahata), where absolutely no chaotic thought can reach (perfect peace).
            And in Murcha (Coma or extremely deep Samadhi), consciousness violently shrinks directly into the brain's crown (Sahasrara).
            The Upanishad fiercely reveals that the Jiva absolutely never sits 'Free'; it continuously moves up and down exactly like an active Elevator through these four distinct rooms of the body.
            And in every single room, depending strictly on his past karmas, he is forcefully shown a new Movie (joy or brutal pain) which he is helplessly forced to experience (Bhunkte).
        """.trimIndent()
    ),
    PaingalaShloka(
        id = 11,
        sanskrit = "घटीयन्त्रवदुद्भ्रान्तः संसारे परिभ्रमति । ततस्तद्वैराग्यमुत्पद्यते ॥ ११ ॥",
        hindi = """
            (जीव का संसार में चक्कर काटना): यह बेचारा जीव (मनुष्य) कुएँ से पानी निकालने वाले 'घटीयंत्र' (रहट / Persian Wheel / Water Wheel) के समान अत्यंत भ्रमित और बेचैन (उद्भ्रान्तः) रहता है।
            जिस प्रकार रहट के डिब्बे कुएँ में नीचे जाते हैं (जन्म लेते हैं), पानी से भरते हैं (कर्म भोगते हैं), ऊपर आते हैं, और फिर खाली होकर (मरकर) दोबारा नीचे गिर जाते हैं।
            ठीक उसी प्रकार, यह जीव भी इस भयानक संसार में बिना किसी अंत के बार-बार जन्म और मृत्यु के चक्कर काटता (परिभ्रमति / Wanders) रहता है।
            जब इंसान इस अंतहीन और पीड़ादायक लूप (Loop) को बहुत गहराई से समझ लेता है, तब (ततस्तद्) उसके भीतर संसार के प्रति अत्यंत तीव्र 'वैराग्य' (Detachment / मोह-भंग) उत्पन्न (उत्पद्यते) हो जाता है।
            यह श्लोक संसार के खोखलेपन (Futility) को दिखाने का सबसे शानदार और दर्दनाक उदाहरण (Metaphor) है: एक 'घटीयंत्र' (Water wheel)।
            हम सोचते हैं कि हम जीवन में बहुत 'प्रोग्रेस' (Progress) कर रहे हैं; पर असल में हम एक ऐसे पहिये पर बँधे हैं जो बस गोल-गोल घूम रहा है, आगे कहीं नहीं जा रहा!
            हम पैदा होते हैं, थोड़े पैसे कमाते हैं, बुढ़ापा आता है, हम मर जाते हैं; और फिर से एक नए शरीर (डिब्बे) में आकर वही मूर्खतापूर्ण रेस (Race) शुरू कर देते हैं।
            जब किसी बुद्धिमान इंसान को इस भयानक 'मैट्रिक्स' (Matrix) की सच्चाई समझ आती है, तो उसे दुनिया के सबसे बड़े महल या पैसे में भी कोई खुशी नहीं मिलती।
            वह तड़प उठता है कि "मुझे इस बेवकूफी भरे पहिये (Wheel of Samsara) से तुरंत नीचे उतरना है!"
            यही सच्ची तड़प असली 'वैराग्य' है; और बिना इस वैराग्य के, मोक्ष की यात्रा कभी शुरू ही नहीं हो सकती।
        """.trimIndent(),
        english = """
            (The endless revolving of the soul in the world): This helpless, pathetic Jiva (human being) remains exceptionally confused, exhausted, and bewildered (Udbhrantah), exactly resembling the buckets of a 'Ghati-yantra' (Persian Water Wheel).
            Just exactly as the buckets of the water-wheel plunge down into the deep well (take birth), fill with heavy water (suffer karmas), rise up, empty out (die), and are ruthlessly thrown violently back down again.
            In the precise same flawless manner, this ignorant Jiva also continuously and helplessly wanders and violently revolves (Paribhramati) endlessly in this terrifying world through the brutal cycle of repeated birth and death.
            When a human being profoundly and deeply comprehends this agonizing, endless terrifying Loop, exactly then (Tatastad) an exceptionally intense, burning 'Vairagya' (Absolute Detachment / Disillusionment) toward the world actively awakens (Utpadyate) within him.
            This magnificent verse provides the absolute greatest and most heartbreaking Metaphor exposing the total Futility of the world: a 'Ghati-yantra' (Water wheel).
            We arrogantly and falsely believe we are making massive 'Progress' in life; but in reality, we are hopelessly strapped to a massive wheel that is merely spinning violently in circles, going absolutely nowhere!
            We are born, we desperately earn some money, terrifying old age strikes, we violently die; and then we simply return in a brand-new body (bucket) to restart the exact same idiotic Race all over again.
            When a highly intelligent human finally realizes the brutal reality of this terrifying 'Matrix', he absolutely finds zero joy even in the world's greatest palace or massive wealth.
            He thrashes in extreme agony and loudly screams: "I desperately need to get off this idiotic, pointless wheel (Wheel of Samsara) right this exact second!"
            This burning, agonizing thirst is true 'Vairagya'; and completely without this intense detachment, the supreme journey to Moksha can absolutely never, ever begin.
        """.trimIndent()
    ),
    PaingalaShloka(
        id = 12,
        sanskrit = "ततो ज्ञानार्थं गुरुमुपसर्पति । तस्मै तत्त्वमसीति महावाक्यमुपदिशति ॥ १२ ॥",
        hindi = """
            (वैराग्य के बाद क्या होता है?): उस तीव्र वैराग्य (मोह-भंग) के उत्पन्न होने के बाद (ततो), वह साधक परम सत्य के 'ज्ञान' (ज्ञानार्थं) की प्राप्ति के लिए।
            किसी सच्चे और पूर्ण रूप से ज्ञानी 'गुरु' की शरण में অত্যন্ত विनम्रता के साथ जाता (उपसर्पति / Approaches) है।
            तब वह दयालु गुरु उस सच्चे शिष्य को संसार के सबसे महान और गुप्त रहस्य 'तत्त्वमसि' (Thou Art That / तुम वही परब्रह्म हो) नामक 'महावाक्य' का साक्षात् उपदेश (उपदिशति) देता है।
            अध्यात्म (Spirituality) में 'ऑर्डर' (Sequence) बहुत ही सख्त होता है: पहले दुख, फिर वैराग्य, फिर गुरु, और अंत में ज्ञान।
            जब तक आपको दुनिया में मज़ा आ रहा है, तब तक आप किसी गुरु के पास नहीं जाएंगे; आप केवल डिस्को (Disco) या मॉल (Mall) में जाएंगे।
            पर जब दुनिया आपको भयंकर लात मारती है और आपको समझ आता है कि यहाँ सब झूठे हैं, तभी आप एक सच्चे 'गुरु' को खोजते हैं।
            गुरु के पास जाकर उसे कोई मैजिक-ट्रिक (Magic trick) या पैसे कमाने का टोटका नहीं मिलता।
            गुरु सीधे उसके दिमाग पर वेदान्त का सबसे बड़ा परमाणु बम (Nuclear bomb) गिराता है: 'तत्त्वमसि'।
            गुरु कहता है: "तुम जो भगवान को आसमान में ढूँढ रहे हो और खुद को एक छोटा सा इंसान मानकर रो रहे हो, वो 'तत्' (ईश्वर) वास्तव में 'त्वम्' (तुम खुद) 'असि' (हो)!"
            यह एक वाक्य इंसान की सारी औकात, उसके सारे डर और उसके सारे अज्ञान को एक ही सेकंड में राख करने की ताकत रखता है।
        """.trimIndent(),
        english = """
            (What exactly happens strictly after Vairagya?): Immediately following the explosive awakening of that intense Vairagya (Disillusionment) (Tato), that sincere seeker, strictly for the ultimate purpose of attaining supreme 'Wisdom' of the Truth (Jnanartham).
            Approaches and completely surrenders (Upasarpati) with absolute extreme humility directly at the feet of a true, fully self-realized 'Guru'.
            Then, that highly compassionate Guru profoundly and directly instructs (Upadishati) that genuine disciple in the world's absolute greatest and most secret 'Mahavakya' (Grand Declaration) known precisely as 'Tat Tvam Asi' (Thou Art That / You are that Supreme Brahman).
            In deep Spirituality, the exact 'Sequence' (Order) is exceptionally strict and brutal: First intense suffering, then fiery Vairagya, then the true Guru, and ultimately Supreme Wisdom.
            As long as you are actively enjoying the cheap thrills of the world, you will absolutely never approach a Guru; you will exclusively run to a Disco or a shopping Mall.
            But when the brutal world violently kicks you in the teeth and you realize absolutely everyone here is fake, only exactly then do you desperately search for a true 'Guru'.
            Upon approaching the Guru, he is absolutely not handed a cheap Magic Trick or a scam to earn heavy money.
            The Guru flawlessly drops Vedanta's absolute biggest Nuclear Bomb directly onto his brain: 'Tat Tvam Asi'.
            The Guru fiercely declares: "That God you are foolishly searching for in the physical sky while crying pathetically thinking yourself to be a tiny, helpless human, that 'Tat' (Supreme Lord) is in absolute reality 'Tvam' (You Yourself) 'Asi' (Are)!"
            This single, monumental sentence possesses the terrifying, unimaginable power to completely burn a human's entire limited identity, absolutely all his fears, and his massive ignorance into mere ashes in a single split-second.
        """.trimIndent()
    ),
    PaingalaShloka(
        id = 13,
        sanskrit = "तत्पदवाच्यं सर्वज्ञत्वादिविशिष्टमीश्वरचैतन्यम् । त्वम्पदवाच्यमन्तःकरणविशिष्टं जीवचैतन्यम् ॥ १३ ॥",
        hindi = """
            (अब 'तत्त्वमसि' महावाक्य का अत्यंत गहरा वैज्ञानिक चीर-फाड़ / Operation):
            इस महावाक्य में जो 'तत्' (वह/That) पद (शब्द) है, वह उस परमेश्वर की चेतना (ईश्वरचैतन्यम्) को दर्शाता है जो 'सर्वज्ञत्व' (सब कुछ जानने वाला) और 'सर्वशक्तिमान' जैसी महान उपाधियों (विशिष्टं) से पूरी तरह युक्त है।
            तथा इस महावाक्य में जो 'त्वम्' (तुम/Thou) पद है, वह उस छोटे से इंसान की चेतना (जीवचैतन्यम्) को दर्शाता है जो 'अन्तःकरण' (मन, बुद्धि, अहंकार) जैसी अत्यंत छोटी और सीमित उपाधियों (विशिष्टं) में फँसी हुई है।
            यह श्लोक वेदान्त की जान (Heart) है। जब गुरु कहता है "तुम भगवान हो", तो शिष्य का दिमाग चकरा जाता है।
            शिष्य सोचता है: "मैं तो एक छोटा सा इंसान (त्वम्) हूँ, जो कल का भविष्य नहीं जानता और जो मच्छर के काटने से बीमार हो जाता है (अन्तःकरण-विशिष्ट)।"
            "और भगवान (तत्) तो वह है जिसने अरबों गैलेक्सी (Galaxies) बनाई हैं और जो सब कुछ जानता है (सर्वज्ञत्व)। तो मैं (त्वम्) भगवान (तत्) कैसे हो सकता हूँ?"
            गुरु शिष्य की इस शंका (Doubt) को बहुत ही प्यार से समझा रहा है।
            गुरु कहता है कि हाँ, बाहर से देखने पर तुम (जीव) और भगवान (ईश्वर) बिल्कुल अलग (Opposite) लगते हो।
            तुम्हारी पावर (Power) जीरो है और भगवान की पावर इन्फिनिटी (Infinity) है। पर यह फर्क केवल तुम्हारी बाहरी 'ड्रेस' (उपाधि / Coverings) का है, तुम्हारे असली 'तत्त्व' का नहीं।
            अगले श्लोक में इस महान पहेली (Puzzle) को हमेशा के लिए सुलझाया जाएगा।
        """.trimIndent(),
        english = """
            (Now the exceptionally deep scientific Operation / analysis of the Mahavakya 'Tat Tvam Asi'):
            In this colossal Mahavakya, the precise word 'Tat' (That) specifically denotes the Supreme Consciousness of God (Ishvarachaitanyam), which is fully endowed with and heavily characterized (Vishishtam) by magnificent, infinite attributes like 'Sarvajnatva' (Omniscience / All-knowingness) and Omnipotence.
            And the specific word 'Tvam' (Thou/You) in this Mahavakya explicitly denotes the highly limited Consciousness of the individual human (Jivachaitanyam), which is helplessly trapped and characterized (Vishishtam) entirely by tiny, restrictive limitations like the 'Antahkarana' (the petty mind, intellect, and toxic ego).
            This phenomenal verse is the absolute beating Heart of Vedanta. When the Guru loudly declares "You are God", the disciple's limited brain violently spins in utter confusion.
            The disciple logically thinks: "I am merely a tiny, helpless human (Tvam) who doesn't even know what will happen tomorrow, and who falls severely sick just from a cheap mosquito bite (Antahkarana-vishishta)."
            "And God (Tat) is the supreme being who effortlessly created billions of massive Galaxies and flawlessly knows absolutely everything (Sarvajnatva). So how on earth can I (Tvam) possibly be God (Tat)?"
            The Guru is now highly affectionately, perfectly dismantling this massive, terrifying Doubt (Puzzle) of the disciple.
            The Guru acknowledges: Yes, strictly looking from the outside, you (Jiva) and God (Ishvara) appear absolutely completely different (Opposites).
            Your personal Power is nearly Zero, and God's power is absolute Infinity. But this massive difference exists strictly only in your external 'Dress' (Upadhi / limitations/coverings), absolutely not in your actual, original 'Essence'.
            In the highly anticipated very next verse, this magnificent cosmic Puzzle will be permanently and flawlessly solved forever.
        """.trimIndent()
    ),
    PaingalaShloka(
        id = 14,
        sanskrit = "तयोर्विरुद्धधर्मांशं विहाय चैतन्यमात्रं यत् तत् असि इति लक्षण्या बोधयति ॥ १४ ॥",
        hindi = """
            (महावाक्य का परम रहस्य): उन दोनों (ईश्वर और जीव) के भीतर जो 'विरुद्ध धर्म' (Opposite qualities / उल्टे गुण) दिखाई देते हैं।
            (जैसे ईश्वर का सर्वज्ञ होना और जीव का अल्पज्ञ होना), उन सभी बाहरी उपाधियों (अंश) को पूरी तरह से 'विहाय' (त्याग कर / माइनस करके / Minus)।
            उन दोनों के अंदर जो केवल एक 'शुद्ध चैतन्य' (Pure Consciousness / चैतन्यमात्रं) कॉमन (Common) बचा है, "वास्तव में तुम 'वही' शुद्ध चेतना 'हो' (तत् असि)।"
            इस प्रकार गुरु 'लक्षणा वृत्ति' (Implied meaning / छिपे हुए अर्थ) के द्वारा शिष्य को परम ज्ञान का साक्षात् बोध (बोधयति) कराता है।
            यह वेदान्त का सबसे महान 'मैथमेटिक्स' (Mathematics / Equation) है—जहाँ जीव और ईश्वर को बराबर (Equal) किया गया है।
            एक उदाहरण से समझें: एक सोने का मुकुट (Crown / राजा का) है, और एक सोने की छोटी सी अंगूठी (Ring / भिखारी की) है।
            मुकुट का साइज, कीमत और डिज़ाइन (उपाधि) अंगूठी से बहुत बड़ा है; दोनों बिल्कुल 'विरुद्ध' (Opposite) लगते हैं।
            पर अगर हम दोनों के 'डिज़ाइन और आकार' (विरुद्ध धर्म) को पिघला कर हटा (विहाय) दें, तो मुकुट भी 100% 'सोना' है और अंगूठी भी 100% 'सोना' ही है!
            उसी तरह, ईश्वर की 'सर्वज्ञता' (मुकुट) और इंसान का 'अहंकार' (अंगूठी) दोनों झूठे आवरण (Covers) हैं।
            इन दोनों आवरणों को हटाते ही जो 'शुद्ध चेतना' (सोना) बचती है, वह दोनों में बिल्कुल एक (One) है; और वही तुम हो!
        """.trimIndent(),
        english = """
            (The ultimate supreme secret of the Mahavakya): Absolutely all the 'Viruddha Dharma' (highly Opposite qualities / contradictory traits) that vividly appear between those two (Ishvara and Jiva).
            (Such as God being totally Omniscient and the human being profoundly ignorant), by completely abandoning, eliminating, and Minusing (Vihaya) absolutely all those external limiting adjuncts (portions/Upadhis) from both.
            The absolute one and only 'Pure Consciousness' (Chaitanyamatram) that remains fundamentally Common inside both, "In absolute reality, you 'Are' strictly 'That' exact pure consciousness alone (Tat Asi)."
            In this flawless, highly precise manner, the Guru directly awakens and imparts the supreme realization (Bodhayati) to the disciple, strictly using the 'Lakshana Vritti' (the Implied, deeply hidden real meaning).
            This is undeniable Vedanta's absolute greatest 'Mathematics' (Equation)—where the tiny creature and the colossal God are proven mathematically Equal.
            Understand this flawlessly with a brilliant example: There is a massive solid gold Crown (belonging to a King), and a tiny, cheap gold Ring (belonging to a beggar).
            The sheer size, massive price, and complex design (Upadhi) of the crown are vastly greater than the ring; the two vividly appear completely 'Opposite' (Viruddha).
            But if we ruthlessly melt down and permanently eliminate (Vihaya) the 'design and shape' (opposite traits) of both, the crown is 100% pure 'Gold', and the ring is also 100% pure 'Gold' alone!
            Similarly, God's 'Omniscience' (Crown) and the human's petty 'Ego' (Ring) are both entirely false, temporary Covers (Upadhis).
            The exact split-second both these false covers are ruthlessly stripped away, the 'Pure Consciousness' (Gold) that remains is perfectly identical (One) in both; and that exact consciousness is precisely what You are!
        """.trimIndent()
    ),
    PaingalaShloka(
        id = 15,
        sanskrit = "श्रवणं मननं चैव निदिध्यासनमेव च । समाधिरिति चत्वारि साधनानि कृतानि चेत् ॥ १५ ॥",
        hindi = """
            (आत्मज्ञान पाने के 4 व्यावहारिक कदम): इस परम सत्य (कि मैं ब्रह्म हूँ) को गहराई से जानने और उसमें स्थित होने के लिए।
            साधक को ये चार महान साधनाएं (साधनानि) अत्यंत दृढ़ता के साथ संपन्न करनी (कृतानि चेत्) चाहिए।
            वे चार कदम हैं: 1. 'श्रवण' (सत्य को गुरु या शास्त्रों से ध्यानपूर्वक सुनना), 2. 'मनन' (सुने हुए ज्ञान पर गहराई से लॉजिकल विचार करना)।
            3. 'निदिध्यासन' (विचार किए हुए सत्य का निरंतर और अखंड ध्यान करना), और 4. 'समाधि' (अंततः उस सत्य में पूरी तरह से विलीन हो जाना)।
            यहाँ उपनिषद मोक्ष का एक अत्यंत स्पष्ट और साइंटिफिक (Scientific) सिलेबस (Syllabus) दे रहा है।
            'श्रवण' का मतलब केवल कानों से सुनना नहीं है; इसका मतलब है एक सच्चे गुरु से पूरी श्रद्धा के साथ यह बात रिसीव (Receive) करना कि "तुम ब्रह्म हो।"
            पर केवल सुनने से बात नहीं बनती (Blind faith नहीं चाहिए)। 'मनन' का मतलब है उस बात को अपने तर्क (Logic) और अक्ल की कसौटी पर कसना कि क्या मैं सच में ब्रह्म हूँ?
            जब सारे डाउट (Doubts) खत्म हो जाएं, तो 'निदिध्यासन' शुरू होता है; यानी जो सच मान लिया है, उसे 24 घंटे जीने का अभ्यास करना।
            और जब यह अभ्यास इतना गहरा हो जाए कि अभ्यास करने वाला 'अहंकार' ही मिट जाए, तो उसे 'समाधि' कहते हैं।
            इन 4 कदमों के बिना कोई भी इंसान केवल किताबें पढ़कर कभी भी मुक्त (Enlightened) नहीं हो सकता।
        """.trimIndent(),
        english = """
            (The 4 highly practical, exact steps to attain Self-knowledge): To profoundly realize and permanently establish oneself strictly in this Ultimate Truth (that I am Brahman).
            The sincere seeker must rigorously and flawlessly complete and perfectly accomplish (Kritani chet) these exact four magnificent Sadhanas (Spiritual practices).
            Those four strict steps are: 1. 'Shravana' (highly attentively hearing the Truth directly from a true Guru or scriptures), 2. 'Manana' (profoundly reflecting and logically analyzing the heard wisdom).
            3. 'Nididhyasana' (continuous, absolutely unbroken deep meditation strictly on that deeply analyzed Truth), and 4. 'Samadhi' (ultimately dissolving completely and flawlessly into that absolute Truth).
            Here, the Upanishad provides an exceptionally clear, highly Scientific exact 'Syllabus' (Roadmap) for attaining Moksha.
            'Shravana' absolutely does not mean merely hearing casually with physical ears; it means fully, with absolute supreme faith, Receiving the profound message from a true Guru that "You are Brahman."
            But merely hearing it is absolutely never enough (Blind faith is strictly prohibited). 'Manana' means violently testing that knowledge strictly on the harsh anvil of your own Logic and intellect to prove: Am I really Brahman?
            When absolutely all dark Doubts are permanently annihilated, 'Nididhyasana' officially begins; meaning, relentlessly practicing living that accepted Truth 24 hours a day without a break.
            And when this intense practice becomes so incredibly deep that the practicing 'Ego' itself completely dies, that exact zero-state is called 'Samadhi'.
            Completely without these strict 4 foundational steps, absolutely no human being can ever become truly Enlightened merely by casually reading religious books.
        """.trimIndent()
    ),
    PaingalaShloka(
        id = 16,
        sanskrit = "तदा स जीवन्मुक्तो भवति । प्रारब्धकर्मक्षयात् विदेहमुक्तिं प्राप्नोति ॥ १६ ॥",
        hindi = """
            (जीवन्मुक्त और विदेहमुक्ति की अवस्था): जब वह साधक इन चारों (श्रवण, मनन, निदिध्यासन, समाधि) को सफलतापूर्वक पूरा कर लेता है।
            तब (तदा) वह इसी संसार में और इसी भौतिक शरीर में रहते हुए ही 'जीवन्मुक्त' (जीते-जी पूरी तरह आज़ाद / Liberated while alive) हो (भवति) जाता है।
            और फिर अपने बचे हुए 'प्रारब्ध कर्मों' (Destiny) के पूरी तरह क्षीण (खत्म) हो जाने पर (यानी जब इस शरीर की उम्र पूरी हो जाती है)।
            वह जीवन्मुक्त पुरुष हमेशा के लिए 'विदेहमुक्ति' (शरीर के बिना पूर्ण मोक्ष / Liberation after death) को प्राप्त (प्राप्नोति) कर लेता है।
            सनातन धर्म (वेदान्त) का यह सबसे बड़ा गौरव (Pride) है कि वह 'मरने के बाद' वाले किसी स्वर्ग का झूठा वादा नहीं करता।
            मोक्ष 'इसी जीवन' में (Here and Now) मिलने वाली चीज़ है; जब अज्ञान कट गया, तो इंसान 'जीवन्मुक्त' बन जाता है।
            जीवन्मुक्त इंसान बाहर से ऑफिस भी जाता है और खाना भी खाता है, पर भीतर से वह असीम आकाश की तरह स्वतंत्र है; दुनिया का कोई दुख उसे छू नहीं सकता।
            परंतु ज्ञान होने के बाद भी उसका शरीर तुरंत गिर नहीं जाता; जिस 'प्रारब्ध' (पिछले कर्मों) के कारण यह शरीर बना था, वह पंखे (Fan) के मोमेंटम (Momentum) की तरह कुछ समय तक घूमता रहता है।
            जब वह मोमेंटम (बैटरी) पूरी तरह खत्म हो जाता है, तो शरीर गिर जाता है।
            शरीर के गिरने के बाद, उस ज्ञानी की चेतना ब्रह्मांड में इस तरह घुल जाती है (विदेहमुक्ति) कि वह फिर कभी किसी माँ के गर्भ (Womb) में वापस नहीं आता।
        """.trimIndent(),
        english = """
            (The supreme state of Jivanmukta and Videhamukti): Exactly when that sincere seeker successfully and flawlessly completes absolutely all four of these steps (Shravana, Manana, Nididhyasana, Samadhi).
            Then (Tada), strictly while still actively living in this very world and breathing perfectly within this exact physical body, he undeniably becomes a 'Jivanmukta' (Completely Liberated while fully alive) (Bhavati).
            And subsequently, exactly upon the total exhaustion and complete destruction (Kshayat) of his remaining 'Prarabdha Karmas' (Destiny) (meaning, exactly when the physical lifespan of this body runs out).
            That Jivanmukta sage flawlessly and permanently attains 'Videhamukti' (Absolute, supreme Liberation completely without a body / Liberation after death) forever (Prapnoti).
            This is the absolute greatest, unmatched Glory (Pride) of Sanatana Dharma (Vedanta), that it absolutely never makes cheap, false promises of some imaginary heaven 'after death'.
            Moksha is a profound, living reality flawlessly attained 'in this very life' (Here and Now); the exact split-second dark ignorance is sliced away, the human instantly becomes a 'Jivanmukta'.
            A Jivanmukta human externally goes to the office and eats food exactly like us, but deeply inside, he is as fiercely independent as the infinite sky; absolutely no worldly sorrow can even touch him.
            However, even after attaining absolute enlightenment, his physical body does not drop dead instantly; the 'Prarabdha' (past karmas) that manufactured this body continues to spin it for some time, exactly like the fading Momentum of an unplugged Fan.
            When that exact momentum (battery) completely, totally runs out, the physical body drops dead effortlessly.
            Immediately after the body falls, the consciousness of that supreme sage dissolves so perfectly into the infinite cosmos (Videhamukti) that he absolutely never, ever returns to any mother's dark Womb again.
        """.trimIndent()
    ),
    PaingalaShloka(
        id = 17,
        sanskrit = "यथा जलगते चन्द्रे कम्पमानेऽपि नाकाशस्थश्चन्द्रः कम्पते । तथा देहे कम्पमानेऽपि नात्मा कम्पते ॥ १७ ॥",
        hindi = """
            (आत्मा की अचलता का शानदार उदाहरण): जिस प्रकार पानी (जलगते) में दिखाई देने वाली चन्द्रमा (चन्द्रे) की परछाईं, पानी के हिलने पर बहुत अधिक कांपती और हिलती (कम्पमानेऽपि) है।
            परंतु पानी में परछाईं के हिलने से, असली आकाश (आकाशस्थः) में स्थित वह वास्तविक 'चंद्रमा' बिल्कुल भी नहीं कांपता (न कम्पते / हिलता नहीं है)।
            ठीक उसी प्रकार (तथा), इस भौतिक शरीर (देहे) के बीमारियों, बुढ़ापे या दुखों के कारण कांपने, हिलने या नष्ट होने (कम्पमानेऽपि) पर भी।
            वह परम 'आत्मा' (जो शरीर के भीतर परछाईं की तरह मौजूद है, पर वास्तव में असीम है) कभी भी रत्ती भर भी नहीं कांपती या दुखी होती (नात्मा कम्पते)।
            यह श्लोक अद्वैत दर्शन का सबसे प्यारा और आसानी से समझ में आने वाला (Visual) उदाहरण प्रस्तुत करता है।
            हम शरीर को ही आत्मा (मैं) मानकर हर बीमारी और दुख पर रोते हैं।
            यह बिल्कुल ऐसा है जैसे कोई मूर्ख पानी में हिलते हुए चाँद को देखकर रोए कि "हाय! चाँद टूट गया।"
            ज्ञानी जानता है कि पानी (शरीर/मन) केवल एक शीशा है। अगर शीशा हिल रहा है या टूट गया है, तो इसका मतलब यह नहीं कि आसमान का असली चाँद (आत्मा) भी टूट गया!
            जब शरीर में कैंसर का दर्द उठता है या बुढ़ापे से हाथ कांपते हैं, तो अज्ञानी कहता है "मैं कांप रहा हूँ।"
            पर जीवन्मुक्त योगी मुस्करा कर देखता है कि "केवल पानी (शरीर) हिल रहा है, मैं (असली चाँद/आत्मा) तो अपनी जगह बिल्कुल स्थिर और सुरक्षित हूँ।"
        """.trimIndent(),
        english = """
            (A brilliant example of the Soul's absolute immovability): Exactly just as the vivid reflection of the Moon (Chandre) perfectly visible in a body of water (Jalagate), shakes and violently trembles (Kampamanepi) when the water ripples.
            But simply because the cheap reflection is violently shaking in the water, the actual, real 'Moon' firmly situated high up in the vast sky (Akashasthah) absolutely does not shake or tremble even a millimeter (Na kampate).
            In the precise same flawless manner (Tatha), even when this gross physical body (Dehe) violently shakes, trembles, or decays (Kampamanepi) due to terrifying diseases, excruciating pain, or old age.
            That absolute supreme 'Soul' (Atma) (which is present like a reflection in the body but is actually infinite) absolutely never, ever shakes, trembles, or suffers even slightly (Natma kampate).
            This spectacular verse beautifully presents Advaita philosophy's absolute most beloved, flawless, and easily comprehensible Visual metaphor.
            We foolishly consider the fragile body as the Soul (I) and aggressively cry at every single minor disease and sorrow.
            This is exactly as pathetically stupid as an ignorant fool crying violently upon seeing the moon's reflection shaking in a puddle, screaming "Alas! The moon is shattered."
            The wise sage knows perfectly well that the water (body/mind) is merely a cheap mirror. If the mirror violently shakes or shatters completely, it absolutely does not mean the actual Moon in the sky (Soul) is shattered too!
            When the terrifying agony of cancer strikes the body or hands tremble with extreme old age, the ignorant fool cries "I am trembling."
            But the Jivanmukta Yogi just smiles and silently observes, "Only the physical water (body) is shaking; I (the real Moon/Soul) am perfectly still, flawlessly secure exactly in my place."
        """.trimIndent()
    ),
    PaingalaShloka(
        id = 18,
        sanskrit = "अहं ब्रह्मेति विज्ञानात् सर्वकर्मक्षयो भवेत् । तस्मात्सर्वप्रयत्नेन ब्रह्मज्ञानं समभ्यसेत् ॥ १८ ॥",
        hindi = """
            "मैं साक्षात् वही परम ब्रह्म हूँ" (अहं ब्रह्मेति)—इस परम विज्ञान (प्रत्यक्ष और गहरे अनुभव / विज्ञानात्) के प्राप्त होते ही।
            मनुष्य के करोड़ों जन्मों के संचित 'सभी प्रकार के कर्मों' (पाप और पुण्य दोनों) का पूरी तरह से नाश और क्षय (सर्वकर्मक्षयो) हो जाता है (भवेत्)।
            इसलिए (तस्मात्), मोक्ष चाहने वाले साधक को अपने पूरे बल और सभी संभव प्रयासों (सर्वप्रयत्नेन) के द्वारा।
            केवल और केवल इसी 'ब्रह्मज्ञान' (आत्मज्ञान) का ही अत्यंत दृढ़ता के साथ निरंतर अभ्यास (समभ्यसेत्) करना चाहिए।
            यह श्लोक 'कर्म के सिद्धांत' (Law of Karma) को काटने का दुनिया का इकलौता और सबसे शक्तिशाली हथियार बता रहा है।
            हम जीवन भर पूजा-पाठ, दान और तीर्थ इसलिए करते हैं ताकि हमारे पुराने पाप (कर्म) कट जाएं।
            पर उपनिषद कहता है कि एक छोटा सा पुण्य केवल एक छोटे से पाप को काट सकता है; पर कर्मों का पहाड़ तो बहुत बड़ा है!
            उसे काटने के लिए एक-एक पत्थर तोड़ने की जरूरत नहीं; "अहं ब्रह्मास्मि" (I am Brahman) वह 'डायनामाइट' (Dynamite) है जो कर्मों के पूरे पहाड़ को एक सेकंड में उड़ा देता है।
            जब इंसान को यह गहरा 'विज्ञान' (Experience) हो जाता है कि वह कर्म करने वाला शरीर है ही नहीं, तो सारे कर्म शून्य (Zero) हो जाते हैं।
            इसलिए बाकी सारे फालतू के धार्मिक कर्मकांडों को छोड़कर, अपनी पूरी ताकत (सर्वप्रयत्नेन) केवल अपने असली स्वरूप (ब्रह्म) को जानने में ही लगानी चाहिए।
        """.trimIndent(),
        english = """
            "I am undoubtedly and literally that exact Supreme Brahman" (Aham Brahmeti)—the exact split-second this supreme Vijnana (direct, profound, living experience / Vijnanat) is flawlessly attained.
            Absolutely 'All types of karmas' (both massive sins and high merits) accumulated relentlessly over millions of the human's past lifetimes undergo total, absolute destruction and complete annihilation (Sarvakarmakshayo) instantly (Bhavet).
            Therefore (Tasmat), a sincere seeker intensely desiring Moksha must aggressively, with his absolute full strength and all possible efforts (Sarvaprayatnena).
            Relentlessly and exceptionally firmly practice (Samabhyaset) and strive exclusively only for this exact 'Brahma-Jnana' (Supreme Self-knowledge) and absolutely nothing else.
            This magnificent verse explicitly reveals the world's absolute only and most terrifyingly powerful Weapon designed strictly to ruthlessly slash the unbeatable 'Law of Karma'.
            We spend our entire lives blindly performing complex rituals, heavy charity, and exhausting pilgrimages purely hoping our massive old sins (karmas) get erased.
            But the Upanishad fiercely declares that one tiny merit can strictly only erase one tiny sin; but the terrifying mountain of accumulated karma is unimaginably massive!
            To obliterate it, there is absolutely zero need to break it stone by stone; "Aham Brahmasmi" (I am Brahman) is that exact highly explosive 'Dynamite' that instantly blows up the entire karmic mountain in a single second.
            When a human gains the profound 'Vijnana' (Experience) that he is absolutely not the physical body performing actions, absolutely all karmas instantly drop to mathematical Zero.
            Therefore, completely abandoning absolutely all useless, empty religious rituals, one must aggressively channel his absolute full power (Sarvaprayatnena) exclusively into realizing his own true original nature (Brahman).
        """.trimIndent()
    ),
    PaingalaShloka(
        id = 19,
        sanskrit = "यत्र यत्र मृतो ज्ञानी येन केन प्रकारेण वा । तत्र तत्र स लीयेत घटे नष्टे यथाम्बरम् ॥ १९ ॥",
        hindi = """
            (ज्ञानी की मृत्यु कैसी होती है?): एक सच्चा आत्मज्ञानी पुरुष इस धरती पर चाहे जिस किसी भी जगह (यत्र यत्र) मरे (मृतो)।
            और चाहे वह 'किसी भी प्रकार से' (येन केन प्रकारेण वा / बीमारी से, एक्सीडेंट से, या शांति से) अपनी देह का त्याग करे।
            वह ज्ञानी मरने के बाद 'उसी जगह' (तत्र तत्र) साक्षात् उस परब्रह्म में पूरी तरह से लीन (विलीन/Merge) हो जाता है (स लीयेत)।
            बिल्कुल उसी प्रकार, जैसे एक मिट्टी के घड़े के जहाँ कहीं भी टूटकर नष्ट (नष्टे) होने पर, उसके अंदर का आकाश (घटाकाश) बिना कहीं गए 'उसी जगह' बाहर के विशाल आकाश (अम्बरम्) में मिलकर एक हो जाता है।
            यह श्लोक अज्ञानियों के उस बहुत बड़े भ्रम (Superstition) को तोड़ता है कि मोक्ष पाने के लिए काशी (बनारस) या हिमालय में ही मरना जरूरी है!
            उपनिषद कहता है कि ज्ञानी इंसान चाहे एक गंदी नाली के पास मरे, या किसी भयंकर एक्सीडेंट में मरे, उसकी मुक्ति की गारंटी (Guarantee) 100% पक्की है।
            क्योंकि आत्मा को मरने के बाद किसी 'स्वर्ग' या 'भगवान के घर' तक सफर (Travel) करके नहीं जाना पड़ता! भगवान तो हर जगह मौजूद (Omnipresent) है।
            जैसे ही घड़ा (शरीर) टूटता है, अंदर की खाली जगह (आत्मा) तुरंत वहीं के वहीं बाहर के आकाश (ईश्वर) में मिल जाती है।
            घड़े को चाहे आप मंदिर में तोड़ें या कचरे के ढेर पर, आकाश को कोई फर्क नहीं पड़ता; वह तुरंत एक हो जाता है।
            आत्मज्ञान का यह सबसे बड़ा फायदा है: यह इंसान को मौत की जगह, समय और तरीके के 'डर' से हमेशा के लिए आज़ाद कर देता है।
        """.trimIndent(),
        english = """
            (How exactly does an enlightened sage die?): A truly self-realized, enlightened sage, irrespective of absolutely whichever physical place (Yatra yatra) on this earth he happens to die (Mrito).
            And regardless of 'absolutely whichever terrifying or peaceful manner' (Yena kena prakarena va / by disease, brutal accident, or in his sleep) he leaves his physical body.
            Immediately after death, that supreme sage flawlessly and completely dissolves (Merges) directly into that Supreme Brahman exactly 'in that very same spot' (Tatra tatra) instantly (Sa liyeta).
            Exactly in the precise same flawless manner as when an earthen pot is smashed and completely destroyed (Nashte) anywhere, the empty space inside it (Ghatakasha) effortlessly and instantly merges into the vast, infinite outside sky (Ambaram) completely without traveling anywhere.
            This spectacular verse violently shatters the massive, blind Superstition of ignorant fools who falsely believe that dying strictly in Kashi (Varanasi) or the Himalayas is absolutely mandatory for attaining Moksha!
            The Upanishad fiercely declares that even if the sage dies near a filthy gutter, or in a horrific, brutal accident, the ironclad Guarantee of his ultimate liberation is 100% rock-solid.
            Strictly because after physical death, the Soul absolutely does not have to actively Travel to some distant 'Heaven' or 'God's house'! God is flawlessly Omnipresent (present everywhere).
            The exact split-second the pot (body) is violently smashed, the empty space inside (Soul) instantly and effortlessly merges flawlessly into the outside sky (God) right then and there.
            Whether you smash the pot inside a highly sacred temple or directly on a filthy garbage dump, the space simply doesn't care; it instantly becomes one.
            This is the absolute greatest benefit of true Self-knowledge: it permanently and flawlessly frees a human being from the terrifying 'Fear' of the place, time, and exact manner of his own death forever.
        """.trimIndent()
    ),
    PaingalaShloka(
        id = 20,
        sanskrit = "तमेवं विद्वानमृत इह भवति । इत्युपनिषत् । ॐ शान्तिः शान्तिः शान्तिः ॥ २० ॥",
        hindi = """
            (उपनिषद का परम निष्कर्ष): जो कोई भी सच्चा जिज्ञासु उस परब्रह्म को इस प्रकार यथार्थ रूप में 'जान' (विद्वान / साक्षात् अनुभव कर) लेता है।
            वह मनुष्य इसी धरती पर और 'इसी शरीर में रहते हुए' (इह) हमेशा के लिए 'अमर' (अमृत) हो जाता है (मृत्यु का भय हमेशा के लिए खत्म हो जाता है)।
            यहीं पर यह अत्यंत महान और पवित्र 'पैंगल उपनिषद' पूर्ण रूप से संपन्न (इत्युपनिषत्) होता है।
            ॐ शांतिः शांतिः शांतिः! (भगवान करे कि हमारे शरीर, मन और आत्मा में उस परब्रह्म की परम और अखंड शांति हमेशा के लिए स्थापित हो)।
            यह अंतिम श्लोक पूरे वेदान्त का सबसे बड़ा निचोड़ (Summary) है।
            मरने के बाद स्वर्ग में मिलने वाली अमरता एक कोरी कल्पना (Fiction) है; असली अमरता वह है जो आपको 'इह' (इसी जन्म में, अभी और यहीं) मिलती है।
            अमर होने का मतलब यह नहीं है कि आपका यह भौतिक शरीर कभी नहीं मरेगा (शरीर तो मिट्टी है, मरेगा ही)।
            अमर होने का असली मतलब है—आपके मन से मौत का 'डर' 100% जीरो (Zero) हो जाना।
            जिस दिन आप जान गए कि "मैं वह चेतना हूँ जिसे तलवार काट नहीं सकती और आग जला नहीं सकती", उसी दिन आप साक्षात् अमृत (Immortal) बन गए।
            पैंगल ऋषि और याज्ञवल्क्य का यह महान संवाद इंसान को उसके अपने ही भीतर छुपे उस अनंत ईश्वर से मिलवा कर इस योग-यात्रा को एक अत्यंत सुंदर और शांत अंजाम पर पहुँचाता है।
        """.trimIndent(),
        english = """
            (The Ultimate Conclusion of the Upanishad): Whosoever true, sincere seeker genuinely 'Knows' and profoundly experiences (Vidvan) that Supreme Brahman strictly in this exact, authentic manner.
            That human being becomes permanently and flawlessly 'Immortal' (Amrita) right here on this earth and 'strictly while living actively within this very physical body' (Iha) (the terrifying fear of death is annihilated forever).
            Right exactly here, this exceptionally magnificent, supreme, and highly sacred 'Paingala Upanishad' flawlessly achieves perfect, absolute completion (Ityupanishat).
            OM Peace, Peace, Peace! (May the supreme, unbroken, and infinite peace of that Supreme Brahman be permanently established in our physical body, restless mind, and immortal soul forever).
            This absolute final verse is the ultimate, greatest Summary of the entire philosophy of Vedanta.
            The cheap immortality promised in some imaginary heaven after physical death is pure Fiction; actual, true immortality is exclusively that which you attain 'Iha' (Right here and Right now, in this very lifetime).
            Becoming literally immortal absolutely does not mean your physical, fleshy body will never die (the body is merely dirt, it is absolutely guaranteed to die).
            The absolute true meaning of becoming immortal is—the terrifying 'Fear' of death dropping to exactly 100% Zero in your mind forever.
            The exact day you profoundly realize, "I am that pure Consciousness which absolutely no sword can cut and no fire can ever burn," that very day you flawlessly become literal Amrita (Immortal).
            This magnificent, explosive dialogue between Sage Paingala and Yajnavalkya flawlessly introduces the human to that infinite God hidden deeply within himself, bringing this supreme spiritual journey to an exceptionally beautiful and profoundly peaceful conclusion.
        """.trimIndent()
    ),
    // ... Continuing paingalaShlokasList from ID 20

    PaingalaShloka(
        id = 21,
        sanskrit = "बालोन्मत्तपिशाचवदेकाकी सञ्चरति । नीहारमिव जगदखिलं पश्यन् ब्रह्मानन्दे मग्नः ॥ २१ ॥",
        hindi = """
            (जीवन्मुक्त का व्यवहार): वह महान ज्ञानी पुरुष इस संसार में एक 'बच्चे' (बाल), 'पागल' (उन्मत्त) या किसी 'पिशाच' (भूत) के समान बिल्कुल अकेला (एकाकी) और बेफिक्र होकर घूमता (सञ्चरति) है।
            (इसका अर्थ यह नहीं कि वह सच में पागल है; बल्कि दुनिया की नज़रों में उसका व्यवहार ऐसा लगता है क्योंकि उसे दुनियावी नियमों की परवाह नहीं है)।
            वह इस संपूर्ण दिखाई देने वाले जगत (जगदखिलं) को केवल एक 'कोहरे' या धुंध (नीहारमिव) के समान झूठा और अस्थायी मानता है।
            और वह हमेशा उस असीम 'ब्रह्मानंद' (ईश्वर के परमानंद) में पूरी तरह से मग्न (डूबकर शांत) रहता है।
            एक बच्चे को न मान की चिंता होती है न अपमान की; वह हमेशा वर्तमान (Present) में जीता है।
            एक पागल को समाज के झूठे नियमों (Social conditioning) से कोई मतलब नहीं होता।
            और एक पिशाच (Ghost) की अपनी कोई भौतिक पहचान या लगाव नहीं होता।
            ज्ञानी का भी यही हाल है; उसका 'मैं' (Ego) मर चुका है, इसलिए वह दुनिया के बीच रहते हुए भी दुनिया का हिस्सा नहीं लगता।
            उसे अब कोई भी सांसारिक लालच या डर अपनी ओर खींच नहीं सकता।
            यही एक जीवन्मुक्त (Liberated) सिद्ध पुरुष का सबसे सच्चा और स्वाभाविक जीवन (Lifestyle) है।
        """.trimIndent(),
        english = """
            (The precise behavior of a Jivanmukta): That magnificent, enlightened sage wanders (Sancharati) completely alone (Ekaki) and utterly carefree in this world exactly like a 'Child' (Bala), a 'Madman' (Unmatta), or a wandering 'Ghost' (Pishachavat).
            (This absolutely does not mean he is clinically insane; rather, in the eyes of the ignorant world, his behavior appears bizarre purely because he cares nothing for societal rules).
            He flawlessly perceives this entire visible cosmos (Jagadakhilam) as merely a fleeting, temporary, and false 'Fog' or thick mist (Niharamiva).
            And he remains permanently, completely drowned and deeply absorbed (Magnah) strictly in the infinite 'Brahmananda' (the supreme bliss of God).
            A pure child has absolutely zero anxiety regarding worldly honor or harsh insults; he perpetually lives flawlessly in the Present moment.
            A so-called madman is completely, blissfully detached from the fake, hypocritical rules of social conditioning.
            And a ghost possesses absolutely zero physical identity, toxic ego, or worldly attachments.
            The realized sage is exactly the same; his 'Ego' is permanently dead, hence while living squarely in the world, he absolutely does not belong to it.
            Absolutely no worldly greed, lust, or terrifying fear can ever possibly drag him down again.
            This is the absolute truest, most natural, and supreme Lifestyle of a perfectly perfected, liberated (Jivanmukta) being.
        """.trimIndent()
    ),
    PaingalaShloka(
        id = 22,
        sanskrit = "नास्य विधिर्न निषेधो न धर्माधर्मौ न कुतश्चित्पापम् । सर्वदा मुक्त एव सः ॥ २२ ॥",
        hindi = """
            (ज्ञानी के लिए नियमों का अंत): उस परम आत्मज्ञानी पुरुष के लिए संसार का कोई भी 'विधि' (धार्मिक नियम / क्या करना चाहिए) लागू नहीं होता।
            और न ही उसके लिए कोई 'निषेध' (क्या नहीं करना चाहिए / पाबंदियां) शेष रहता है।
            उसके लिए अब कोई 'धर्म' (पुण्य) या 'अधर्म' (पाप) नहीं बचा है, और उसे किसी भी कर्म से कोई 'पाप' (पापम्) नहीं लग सकता।
            वह ज्ञानी पुरुष सभी प्रकार के बंधनों से 'सर्वदा' (हमेशा-हमेशा के लिए) पूर्ण रूप से 'मुक्त' (आज़ाद) ही है (मुक्त एव सः)।
            यह वेदान्त की सबसे बड़ी और क्रांतिकारी घोषणा (Revolutionary declaration) है।
            धार्मिक नियम, पूजा-पाठ, और पाप-पुण्य का डर केवल 'अज्ञानी' इंसानों के लिए है, ताकि वे समाज में सही तरीके से रहें।
            परंतु जब इंसान खुद साक्षात् 'ईश्वर' (ब्रह्म) बन चुका है, तो ईश्वर पर कौन से नियम लागू होंगे?
            जैसे जेल के नियम केवल कैदियों के लिए होते हैं, जेलर (Jailer) या राजा के लिए नहीं; वैसे ही दुनिया के नियम ज्ञानी पर काम नहीं करते।
            चूंकि ज्ञानी का 'अहंकार' (कर्तापन) मर चुका है, इसलिए उसके शरीर से होने वाले किसी भी काम का पाप या पुण्य उसे नहीं चिपकता।
            वह पूर्ण रूप से निर्भय और स्वतंत्र है; यही 'अद्वैत' का वह अजेय और परम शिखर है जहाँ कोई डर नहीं पहुँच सकता।
        """.trimIndent(),
        english = """
            (The absolute end of rules for the sage): For that supreme, enlightened sage, absolutely no 'Vidhi' (strict religious rules / what must be done) applies whatsoever.
            Nor is there absolutely any 'Nishedha' (strict prohibitions / what must absolutely not be done) left remaining for him at all.
            For him, there is absolutely no more 'Dharma' (merit) or 'Adharma' (demerit), and absolutely no 'Sin' (Papam) from any action can ever possibly touch him.
            That magnificent sage is absolutely, permanently, and 'Always' (Sarvada) unconditionally 'Liberated' and 100% completely free (Mukta eva sah).
            This is Advaita Vedanta's absolute greatest and most exceptionally Revolutionary declaration of complete spiritual freedom.
            Strict religious rules, rigid rituals, and the terrifying fear of sin and merit exist exclusively for 'ignorant' humans, strictly to keep them disciplined in society.
            But exactly when a human being has flawlessly and literally become 'God' (Brahman) Himself, what petty rules can possibly apply to God?
            Just as strict prison rules apply exclusively to pathetic inmates, absolutely never to the supreme King or Jailer; worldly rules utterly fail to bind the sage.
            Since the sage's 'Ego' (sense of doership) is completely and permanently dead, absolutely no sin or merit from his bodily actions ever clings to him.
            He is flawlessly fearless and absolutely independent; this is the invincible, supreme peak of 'Advaita' where absolutely no fear can ever reach.
        """.trimIndent()
    ),
    PaingalaShloka(
        id = 23,
        sanskrit = "य इदं पैङ्गलमुपनिषदं नित्यमधीते स शिखिज्ञानाग्निवर्णो भवति स सर्वपापेभ्यो मुक्तो भवति । स विदेहमुक्तिं प्राप्नोति इत्युपनिषत् । ॐ शान्तिः शान्तिः शान्तिः ॥ २३ ॥",
        hindi = """
            (फलश्रुति और समापन): जो भी मुमुक्षु साधक इस अत्यंत पवित्र 'पैंगल उपनिषद' (पैङ्गलमुपनिषदं) का प्रतिदिन निरंतर (नित्यं) अध्ययन (अधीते) और मनन करता है।
            वह साधक साक्षात् 'ज्ञान की अग्नि' (ज्ञानाग्निवर्णो) के समान अत्यंत प्रकाशमान और परम शुद्ध (शिखि / लपटों वाला) हो जाता है।
            वह मनुष्य अपने करोड़ों जन्मों के 'सभी प्रकार के भयंकर पापों' (सर्वपापेभ्यो) से हमेशा के लिए पूरी तरह 'मुक्त' (आज़ाद) हो जाता है।
            और वह अपने इस भौतिक शरीर को त्यागने के बाद उस परम और शाश्वत 'विदेहमुक्ति' (शरीर-रहित मोक्ष) को हमेशा के लिए प्राप्त (प्राप्नोति) कर लेता है।
            यहीं पर महर्षि याज्ञवल्क्य और पैंगल का यह महान संवाद और 'पैंगल उपनिषद' पूर्ण रूप से संपन्न (इत्युपनिषत्) होता है।
            ॐ शांतिः शांतिः शांतिः! (हमारे शरीर, मन और आत्मा में उस परब्रह्म की परम और अखंड शांति हमेशा के लिए स्थापित हो)।
            उपनिषद का 'अध्ययन' करने का मतलब केवल किताब को रटना नहीं है; इसका मतलब है "मैं ब्रह्म हूँ" इस ज्ञान को अपने जीवन में पूरी तरह उतारना।
            जो इंसान इस सत्य को जीता है, वह ज्ञान की एक धधकती हुई आग (Fire) बन जाता है, जिसमें अज्ञान का कोई कचरा टिक नहीं सकता।
            अब उसे स्वर्ग या नर्क का कोई डर नहीं है; वह शरीर के छूटते ही एक पानी की बूँद की तरह परब्रह्म के असीम समंदर में विलीन हो जाता है।
            यही सनातन धर्म की सबसे महान 'विदेहमुक्ति' है, जहाँ आत्मा हमेशा के लिए अपने परम घर को प्राप्त कर लेती है।
        """.trimIndent(),
        english = """
            (The Phala Shruti and Final Conclusion): Whosoever sincere seeker continuously and daily (Nityam) rigorously studies (Adhite) and profoundly contemplates this exceptionally sacred 'Paingala Upanishad' (Paingalamupanishadam).
            That specific seeker flawlessly becomes as incredibly radiant and supremely pure as the blazing, brilliant flames of the 'Fire of Wisdom' (Shikhijnanagnivarno bhavati).
            That human being becomes completely, permanently, and flawlessly 'Liberated' (Mukto bhavati) from absolutely 'all types of terrifying sins' (Sarvapapebhyo) of millions of past lifetimes forever.
            And immediately after finally shedding this gross physical body, he flawlessly and permanently attains (Prapnoti) that absolute supreme, eternal 'Videhamukti' (bodiless liberation) forever.
            Right exactly here, this magnificent, explosive dialogue between Sage Yajnavalkya and Paingala, and the 'Paingala Upanishad' perfectly achieves absolute completion (Ityupanishat).
            OM Peace, Peace, Peace! (May the supreme, infinite, and unbroken peace of that Supreme Brahman be permanently established within our physical body, restless mind, and immortal soul forever).
            'Studying' the Upanishad absolutely does not mean merely memorizing a physical book; it profoundly means actively downloading and Applying the truth "I am Brahman" entirely into your life.
            The human who actively lives this truth flawlessly becomes a blazing, roaring Fire of wisdom, within which absolutely no garbage of ignorance can ever possibly survive.
            He has absolutely zero fear of heaven or hell now; the exact second the body drops, he dissolves seamlessly into the infinite ocean of Brahman exactly like a tiny drop of water.
            This is Sanatana Dharma's absolute greatest 'Videhamukti', where the immortal Soul successfully and permanently attains its ultimate, absolute true home forever.
        """.trimIndent()
    )
)