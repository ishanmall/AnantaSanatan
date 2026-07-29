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
data class DakshinamurtiShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DakshinamurtiUpanishadScreen() {
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
                if (shlokaNumber != null && shlokaNumber in 1..20) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-20)") },
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
            itemsIndexed(dakshinamurtiShlokasList) { _, shloka ->
                DakshinamurtiShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun DakshinamurtiShlokaCard(shloka: DakshinamurtiShloka) {
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

val dakshinamurtiShlokasList: List<DakshinamurtiShloka> = listOf(
    DakshinamurtiShloka(
        id = 1,
        sanskrit = "ॐ शौनकादि महर्षयो मार्कण्डेयं पप्रच्छुः । केन त्वं चिरञ्जीवी केन वाऽनन्दमनुभवसीति ॥ १ ॥",
        hindi = """
            (दक्षिणामूर्ति उपनिषद का आरंभ): एक बार शौनक आदि महान ऋषियों ने महर्षि मार्कण्डेय के पास जाकर उनसे एक अत्यंत गहरा प्रश्न पूछा।
            "हे भगवन्! आप इस संसार में इतने 'चिरंजीवी' (अमर / लम्बे समय तक जीवित रहने वाले) कैसे बन गए हैं?"
            "और आप बिना किसी बाहरी वस्तु के हर समय उस परम 'आनंद' (परमानंद) का साक्षात् अनुभव (अनुभवसीति) कैसे करते रहते हैं?"
            महर्षि मार्कण्डेय वह महान ऋषि हैं जिन्होंने मृत्यु के देवता यमराज को भी भगवान शिव की भक्ति से हरा दिया था और अमरता पाई थी।
            ऋषियों का यह प्रश्न पूरी मानवता का सबसे बड़ा सवाल है: हम मौत से कैसे बचें और सच्चा सुख (आनंद) कैसे पाएं?
            दुनिया के लोग सुख पाने के लिए पैसे और रिश्तों के पीछे भागते हैं, पर वह सुख अस्थायी (Temporary) होता है।
            मार्कण्डेय ऋषि का आनंद किसी भौतिक चीज़ पर निर्भर नहीं था; वह उनके भीतर से उबल रहा था।
            इसलिए शौनक ऋषि उनसे उस परम रहस्य (Secret) को जानना चाहते हैं जिससे मौत का डर खत्म हो जाए।
            यह उपनिषद वेदान्त और तंत्र (Tantra) का एक अत्यंत शक्तिशाली मिलन है जो ज्ञान और भक्ति दोनों सिखाता है।
            यहीं से उस महान 'दक्षिणामूर्ति' तत्व का रहस्योद्घाटन शुरू होता है जो इंसान को हमेशा के लिए अमर और परमानंद से भर देता है।
        """.trimIndent(),
        english = """
            (The profound beginning of the Dakshinamurti Upanishad): Once, the great sages led by Shaunaka approached Sage Markandeya and asked him an exceptionally deep question.
            "O Supreme Lord! Exactly how have you become a 'Chiranjeevi' (immortal / one possessing an incredibly long lifespan) in this world?"
            "And how exactly do you continuously experience (Anubhavasiti) that absolute, supreme 'Ananda' (bliss) at all times completely without any external objects?"
            Sage Markandeya is that magnificent seer who literally defeated Yamaraja (the god of death) strictly through his supreme devotion to Lord Shiva and attained absolute immortality.
            This profound question of the sages is undeniably the absolute greatest inquiry of all humanity: How exactly do we escape death and attain true joy?
            Worldly people blindly chase cheap money and fake relationships to find joy, but that specific pleasure is strictly temporary and highly perishable.
            Sage Markandeya's supreme bliss absolutely did not depend on any physical object; it was violently boiling directly from within his own soul.
            Therefore, Sage Shaunaka desperately wishes to know that ultimate Secret which permanently annihilates the terrifying fear of death forever.
            This magnificent Upanishad is an exceptionally powerful fusion of Advaita Vedanta and sacred Tantra, flawlessly teaching both supreme wisdom and profound devotion.
            Exactly from here begins the spectacular revelation of the grand 'Dakshinamurti' principle that perfectly fills a human with absolute immortality and infinite bliss forever.
        """.trimIndent()
    ),
    DakshinamurtiShloka(
        id = 2,
        sanskrit = "स होवाच शिवतत्त्वज्ञानेनेति । तत् शिवतत्त्वं केन ज्ञायते । तदेव दक्षिणामुखेन शिवेनानुगृहीतेनेति ॥ २ ॥",
        hindi = """
            (अमरता का रहस्य): महर्षि मार्कण्डेय ने अत्यंत प्रेम से उत्तर दिया: "मैंने केवल और केवल 'शिव-तत्त्व' के परम ज्ञान (शिवतत्त्वज्ञानेन) के द्वारा ही इस अमरता और आनंद को प्राप्त किया है।"
            ऋषियों ने तुरंत पूछा: "हे भगवन्! वह परम रहस्यमयी 'शिव-तत्त्व' आखिर किस उपाय से जाना जा सकता है (केन ज्ञायते)?"
            मार्कण्डेय जी ने कहा: "वह परम तत्त्व केवल उस 'दक्षिणामुखी शिव' (दक्षिण दिशा की ओर मुख करके बैठे साक्षात् भगवान शिव) की विशेष कृपा और अनुग्रह (अनुगृहीतेनेति) से ही जाना जा सकता है।"
            यहाँ 'शिव-तत्त्व' का अर्थ कोई धार्मिक मूर्ति नहीं है; यह उस शुद्ध चेतना (Pure Consciousness) का नाम है जो कभी नहीं मरती।
            मार्कण्डेय जी स्पष्ट करते हैं कि मौत को हराने के लिए कोई संजीवनी बूटी नहीं पीनी पड़ती; अपनी असली 'आत्मा' (शिव) को जानना ही मौत को हराना है।
            पर वह आत्मा खुद-ब-खुद समझ में नहीं आती। उसे समझने के लिए एक 'परम गुरु' की आवश्यकता होती है।
            वह परम गुरु और कोई नहीं, बल्कि साक्षात् भगवान शिव हैं जो 'दक्षिणामूर्ति' (दक्षिण दिशा की ओर मुख किए हुए गुरु) के रूप में प्रकट होते हैं।
            'दक्षिण' दिशा मृत्यु (यमराज) की दिशा मानी जाती है। शिव जी मृत्यु की दिशा की ओर मुँह करके बैठते हैं, यह दिखाने के लिए कि उन्होंने मृत्यु को जीत लिया है।
            बिना उस 'दक्षिणामूर्ति' (सच्चे गुरु) की कृपा के, इंसान चाहे कितने भी वेद पढ़ ले, वह अज्ञान और मौत के जाल से नहीं बच सकता।
            अतः मोक्ष पाने का सबसे पहला नियम यह है: अपना सारा अहंकार छोड़कर उस 'आदि-गुरु' (First Teacher) के चरणों में गिर जाओ।
        """.trimIndent(),
        english = """
            (The absolute secret of immortality): Sage Markandeya answered with extreme affection: "I have successfully attained this immortality and bliss solely and exclusively through the supreme wisdom of the 'Shiva-Tattva' (Shivatattvajnanena)."
            The sages instantly asked: "O Lord! By what exact means can that exceptionally mystical 'Shiva-Tattva' be successfully known and realized (Kena jnayate)?"
            Sage Markandeya profoundly replied: "That supreme principle can be known exclusively through the special grace and absolute blessing (Anugrihiteneti) of that 'Dakshinamukhi Shiva' (Lord Shiva Himself sitting facing the South direction)."
            Here, 'Shiva-Tattva' absolutely does not mean a religious physical idol; it is the strict name of that Pure Consciousness which absolutely never dies.
            Sage Markandeya explicitly clarifies that to defeat death, you do not have to drink a magical physical herb; simply knowing your true 'Soul' (Shiva) is defeating death.
            But that Soul cannot be understood automatically on its own. To profoundly understand it, a 'Supreme Guru' is desperately required.
            That absolute supreme Guru is none other than Lord Shiva Himself, who flawlessly manifests precisely as 'Dakshinamurti' (the Guru facing the South).
            The 'South' direction is traditionally considered the exact direction of Death (Yamaraja). Lord Shiva boldly sits facing the direction of death strictly to prove He has totally conquered death.
            Completely without the grace of that 'Dakshinamurti' (true Guru), no matter how many Vedas a human reads, he cannot escape the web of ignorance and death.
            Therefore, the absolute first rule of attaining Moksha is: ruthlessly drop all your toxic ego and fall completely at the sacred feet of that 'Adi-Guru' (First Teacher).
        """.trimIndent()
    ),
    DakshinamurtiShloka(
        id = 3,
        sanskrit = "कः स दक्षिणामुखः । तस्य किं रूपम् । का वा तस्योपासना । को वा तस्य मन्त्र इति ॥ ३ ॥",
        hindi = """
            (ऋषियों की गहरी जिज्ञासा): शौनक आदि ऋषियों की प्यास और बढ़ गई और उन्होंने लगातार चार अत्यंत महत्त्वपूर्ण प्रश्न पूछे:
            १. "वह 'दक्षिणामुख' (दक्षिण दिशा की ओर मुख किए हुए गुरु / दक्षिणामूर्ति) वास्तव में कौन (कः) है?"
            २. "उन परम गुरु साक्षात् दक्षिणामूर्ति का वास्तविक 'स्वरूप' (रूपम् / Physical and Spiritual form) कैसा है?"
            ३. "उन महान ईश्वर की 'उपासना' (ध्यान और पूजा करने की सही विधि / उपासनो) क्या है?"
            ४. "और उनका वह सबसे गुप्त और परम शक्तिशाली 'मंत्र' (मन्त्र) कौन सा है जिसके द्वारा उन्हें प्रसन्न किया जा सके?"
            यह श्लोक एक सच्चे खोजी (Seeker) की अत्यंत तीव्र तड़प (Thirst) को दिखाता है जिसे 'मुमुक्षुत्व' कहते हैं।
            जब इंसान को पता चलता है कि मौत का इलाज एक 'गुरु' के पास है, तो वह उसे जानने के लिए पागल हो जाता है।
            ऋषि यहाँ कोई फालतू की दुनियावी बात नहीं पूछ रहे; वे सीधे 'टू द पॉइंट' (To the point) प्रश्न कर रहे हैं।
            वे जानना चाहते हैं कि भगवान का वह रूप (Form) कैसा है जिस पर ध्यान लगाया जाए, और वह 'पासवर्ड' (Mantra) क्या है जिससे यूनिवर्स (Universe) का सर्वर खुले।
            सनातन धर्म में 'मंत्र' केवल शब्द नहीं होते; वे साउंड-एनर्जी (Sound Energy) के अत्यंत पावरफुल कैप्सूल (Capsules) होते हैं जो सीधा नर्वस सिस्टम पर प्रहार करते हैं।
            अगले श्लोकों में महर्षि मार्कण्डेय दुनिया के सबसे बड़े और सबसे शक्तिशाली 'मेधा' (Intellect) बढ़ाने वाले मंत्र का रहस्य खोलेंगे।
        """.trimIndent(),
        english = """
            (The intense curiosity of the sages): The profound thirst of Sage Shaunaka and others grew intensely, and they rapidly asked exactly four highly crucial questions:
            1. "Who exactly (Kah) is that 'Dakshinamukha' (the supreme Guru sitting strictly facing the South direction / Dakshinamurti)?"
            2. "What exactly is the actual, true 'Svarupa' (Rupam / exact physical and spiritual form) of that Supreme Guru Dakshinamurti?"
            3. "What exactly is the precise 'Upasana' (the perfectly correct method of profound meditation and worship) of that magnificent Lord?"
            4. "And exactly what is His absolute most highly classified, supremely powerful 'Mantra' strictly through which He can be successfully pleased?"
            This phenomenal verse perfectly displays the exceptionally intense, burning Thirst of a genuine Seeker, profoundly known as 'Mumukshutva'.
            When a human finally realizes that the exact cure for death lies exclusively with a 'Guru', he violently goes mad to know Him.
            The sages are absolutely not asking any useless worldly questions here; they are asking exceptionally direct, 'To the point' cosmic questions.
            They desperately want to know the exact physical Form (Rupa) upon which to meditate, and exactly what the 'Password' (Mantra) is to hack the Universe's server.
            In Sanatana Dharma, 'Mantras' are absolutely not mere words; they are terrifyingly powerful Capsules of pure 'Sound Energy' that violently strike the nervous system.
            In the highly anticipated subsequent verses, Sage Markandeya will explicitly reveal the absolute greatest, most powerful mantra in the world designed strictly to explode the 'Medha' (Intellect).
        """.trimIndent()
    ),
    DakshinamurtiShloka(
        id = 4,
        sanskrit = "स होवाच मार्कण्डेयः । मेधादक्षिणामूर्तिमन्त्रस्य ब्रह्मा ऋषिः । गायत्री छन्दः । दक्षिणामूर्तिर्देवता । मन्त्रेण न्यासः ॥ ४ ॥",
        hindi = """
            (मंत्र का विज्ञान / तन्त्र शास्त्र): महर्षि मार्कण्डेय ने उत्तर दिया: "हे ऋषियों! अब मैं तुम्हें उस परम 'मेधा दक्षिणामूर्ति मंत्र' का विज्ञान बताता हूँ।"
            (मेधा का अर्थ है असीम और अचूक बुद्धि/Intellect, जो यह मंत्र प्रदान करता है)।
            "इस महामंत्र के जो 'ऋषि' (जिन्होंने इसे सबसे पहले खोजा और ब्रह्मांड से डाउनलोड किया) हैं, वे साक्षात् 'ब्रह्मा' जी हैं।"
            "इस मंत्र का 'छन्द' (Sound Meter / जिस विशेष लय में इसे गाया जाना चाहिए) वह परम पवित्र 'गायत्री' छन्द है।"
            "और इस मंत्र के साक्षात् 'देवता' (वह परम ऊर्जा जो इस मंत्र से प्रकट होती है) स्वयं भगवान 'दक्षिणामूर्ति' हैं।"
            "इस मंत्र के शब्दों के द्वारा ही साधक को अपने शरीर में 'न्यास' (मंत्र की ऊर्जा को शरीर के अलग-अलग अंगों में स्थापित करना) करना चाहिए।"
            यह श्लोक सनातन धर्म के 'मंत्र-विज्ञान' (Science of Mantras) का सबसे कड़ा और अचूक नियम बताता है।
            मंत्र कोई गाना (Song) नहीं है जिसे आप अपनी मर्जी से कैसे भी गा लें। हर मंत्र का एक फिक्स (Fixed) 'पासवर्ड' और 'सेटिंग' (Setting) होती है।
            'ऋषि' वह वैज्ञानिक (Scientist) है जिसने इस फ्रीक्वेंसी (Frequency) को खोजा। 'छन्द' वह रिदम (Rhythm) है जिससे यह काम करेगा, और 'देवता' वह पावर (Power) है जो प्रगट होगी।
            'न्यास' (Nyasa) तन्त्र का वह रहस्य है जहाँ साधक मंत्र के शब्दों को पढ़कर अपने शरीर के अंगों (जैसे सिर, दिल, हाथ) को छूता है।
            इससे उसका साधारण शरीर मंत्र की ऊर्जा से चार्ज (Charge) होकर एक 'ईश्वरीय शरीर' (Divine Body) में बदल जाता है, ताकि वह भगवान की भयंकर ऊर्जा को झेल सके।
        """.trimIndent(),
        english = """
            (The precise Science of Mantras / Tantra Shastra): Sage Markandeya profoundly answered: "O sages! Now I shall reveal to you the exact science of that supreme 'Medha Dakshinamurti Mantra'."
            (Medha literally translates to absolute, infinite, and infallible Intellect, which this specific mantra flawlessly grants).
            "The exact 'Rishi' (the original cosmic scientist who first discovered and downloaded it from the universe) of this Maha-mantra is Lord 'Brahma' Himself."
            "The specific 'Chhanda' (Sound Meter / the precise required rhythm to chant it) of this mantra is the exceptionally sacred 'Gayatri' meter."
            "And the exact 'Devata' (the direct supreme cosmic energy that actively manifests from this mantra) is Lord 'Dakshinamurti' Himself."
            "Strictly utilizing the exact syllables of this mantra, the seeker must flawlessly perform 'Nyasa' (actively establishing the mantra's raw energy directly into various body parts)."
            This spectacular verse explicitly reveals the absolute strictest and infallible rule of Sanatana Dharma's 'Science of Mantras' (Mantra-Vijnana).
            A mantra is absolutely not a cheap pop Song that you can casually sing however you please. Every single mantra has a strictly Fixed 'Password' and exact 'Setting'.
            The 'Rishi' is the precise Scientist who discovered this Frequency. 'Chhanda' is the exact Rhythm that triggers it, and 'Devata' is the raw Power that physically manifests.
            'Nyasa' is the highly classified secret of Tantra where the seeker actively touches his physical body parts (head, heart, hands) while violently chanting the mantra's syllables.
            This flawlessly Charges his ordinary physical body with cosmic energy, instantly transforming it into a 'Divine Body' purely so it can safely withstand the terrifying raw energy of God.
        """.trimIndent()
    ),
    DakshinamurtiShloka(
        id = 5,
        sanskrit = "ॐ नमो भगवते दक्षिणामूर्तये मह्यं मेधां प्रज्ञां प्रयच्छ स्वाहा । इति चतुर्विंशत्यक्षरो मन्त्रः ॥ ५ ॥",
        hindi = """
            (परम मेधा दक्षिणामूर्ति महामंत्र): "हे ऋषियों! वह सबसे महान और चमत्कारी मंत्र यह है:"
            "'ॐ नमो भगवते दक्षिणामूर्तये मह्यं मेधां प्रज्ञां प्रयच्छ स्वाहा'।"
            (अर्थ: ॐ, मैं उन परम भगवान दक्षिणामूर्ति को अत्यंत भक्ति से प्रणाम करता हूँ। हे प्रभु! कृपया मुझे परम 'मेधा' (धारण करने वाली असीम शक्ति) और 'प्रज्ञा' (परम आत्मज्ञान) तुरंत प्रदान करें, मैं इसके लिए अपना सब कुछ स्वाहा (आहुति) करता हूँ)।
            "यह चौबीस (24) अक्षरों वाला (चतुर्विंशत्यक्षरो) अत्यंत शक्तिशाली और ब्रह्मांडीय 'महामंत्र' (मन्त्रः) है।"
            यह मंत्र दुनिया का सबसे बड़ा 'ब्रेन-बूस्टर' (Brain-booster) और 'स्पिरिचुअल हैक' (Spiritual Hack) है।
            हम भगवान से पैसे, नौकरी या घर मांगते हैं, पर यह मंत्र सीधे उस चीज़ (बुद्धि/मेधा) की मांग करता है जिससे दुनिया की हर चीज़ हासिल की जा सकती है!
            'मेधा' वह बुद्धि है जो एक बार सुनी हुई बात को जन्म-जन्मांतर तक नहीं भूलती; और 'प्रज्ञा' वह गहरी समझ (Wisdom) है जो सच और झूठ (माया) के बीच का फर्क एक सेकंड में बता देती है।
            जिस इंसान के पास यह 'मेधा' और 'प्रज्ञा' आ गई, वह आइंस्टीन (Einstein) से भी करोड़ों गुना बड़ा जीनियस (Genius) बन जाता है, क्योंकि उसे ब्रह्मांड का सोर्स-कोड (Source code) पता चल जाता है।
            २४ अक्षरों वाला यह मंत्र साक्षात् गायत्री मंत्र के २४ अक्षरों के बराबर है; यह इंसान के दिमाग के सोए हुए सभी न्यूरॉन्स (Neurons) को भयंकर तेजी से एक्टिवेट (Activate) कर देता है।
            जो छात्र (Student) या साधक इस मंत्र का रोज़ जाप करता है, उसका दिमाग एक सुपर-कंप्यूटर (Super-computer) बन जाता है।
        """.trimIndent(),
        english = """
            (The supreme Medha Dakshinamurti Maha-Mantra): "O sages! That absolute greatest and highly miraculous supreme mantra is strictly this:"
            "'Om Namo Bhagavate Dakshinamurtaye Mahyam Medham Prajnam Prayaccha Svaha'."
            (Meaning: OM, I bow deeply with absolute supreme devotion to Lord Dakshinamurti. O Lord! Please instantly bestow upon me the ultimate 'Medha' (infinite retention power) and 'Prajna' (supreme Self-wisdom), I violently sacrifice absolutely everything for this).
            "This is an exceptionally terrifyingly powerful and colossal cosmic 'Maha-mantra' (Mantrah) consisting of exactly twenty-four (24) distinct syllables (Chaturvimshatyaksharo)."
            This precise mantra is undeniably the world's absolute greatest 'Brain-Booster' and ultimate 'Spiritual Hack'.
            We blindly beg God for cheap money, a mortal job, or a physical house, but this mantra aggressively demands exactly that one supreme tool (Intellect/Medha) strictly through which absolutely everything in the universe can be effortlessly acquired!
            'Medha' is that terrifying intellect which absolutely never forgets a single heard word even across millions of lifetimes; and 'Prajna' is that profound Wisdom that flawlessly distinguishes absolute Truth from fake Maya in a single split-second.
            The exact human who successfully attains this 'Medha' and 'Prajna' effortlessly becomes a Genius millions of times greater than Einstein, strictly because he perfectly learns the exact Source-Code of the entire universe.
            This 24-syllable mantra is perfectly, mathematically equivalent to the 24 syllables of the supreme Gayatri Mantra; it violently and aggressively Activates absolutely all the sleeping Neurons in the human brain.
            That specific Student or sincere seeker who chants this exact mantra daily finds his physical brain flawlessly transformed directly into a highly advanced Super-Computer.
        """.trimIndent()
    ),
    DakshinamurtiShloka(
        id = 6,
        sanskrit = "ध्यायेत् स्फटिकसन्निभं त्रिनयनं बोधं दधानं मुदा । दक्षिणबाहुना तदितरेणैवामृतं पुस्तकम् ॥ ६ ॥",
        hindi = """
            (दक्षिणामूर्ति का ध्यान / Dhyana Shloka): (मंत्र जपने से पहले भगवान का ध्यान इस प्रकार करना चाहिए):
            "साधक को उन भगवान का ध्यान (ध्यायेत्) करना चाहिए जिनका शरीर शुद्ध 'स्फटिक' (Crystal / अत्यंत साफ़ और सफेद) मणि के समान अत्यधिक चमकदार और प्रकाशमान (सन्निभं) है।"
            "जिनके तीन नेत्र (त्रिनयनं / सूर्य, चंद्र और अग्नि) हैं, और जो अत्यंत प्रसन्नता (मुदा) के साथ अपने सीधे (दाहिने) हाथ (दक्षिणबाहुना) में।"
            "परम 'ज्ञान मुद्रा' (बोधं / ज्ञान का प्रतीक) धारण किए हुए (दधानं) हैं। और जो अपने दूसरे (बाएं) हाथ से 'अमृत' (अविनाशी ज्ञान) से भरी हुई 'पुस्तक' (पुस्तकम् / वेद) धारण किए हुए हैं।"
            ध्यान (Meditation) का सबसे पहला नियम है एक 'फोकस पॉइंट' (Focus point) बनाना। हमारा चंचल दिमाग बिना किसी छवि (Image) के शून्य पर टिक नहीं सकता।
            इसलिए उपनिषद भगवान शिव का एक अत्यंत सुंदर और वैज्ञानिक (Scientific) रूप (Form) दे रहा है।
            'स्फटिक' (Crystal) का अर्थ है कि भगवान का मन और रूप 100% पारदर्शी (Transparent) और बेदाग है; उसमें कोई मिलावट (पाप) नहीं है।
            उनका 'तीसरा नेत्र' (Third eye) यह बताता है कि वे दुनिया को इन चमड़ी की आँखों से नहीं, बल्कि 'ज्ञान की आँख' से देखते हैं जहाँ कोई पर्दा नहीं है।
            दाहिने हाथ में 'ज्ञान मुद्रा' (अंगूठे और तर्जनी का मिलन) यह दर्शाती है कि जब इंसान का अहंकार (तर्जनी) भगवान (अंगूठे) से जुड़ जाता है, तो ज्ञान का सर्किट (Circuit) पूरा हो जाता है।
            और हाथ में 'पुस्तक' यह साबित करती है कि वेदों का सारा ज्ञान साक्षात् उनके हाथ में है; वे ब्रह्मांड के एकमात्र और सबसे बड़े 'वाइस-चांसलर' (Vice-Chancellor) हैं।
        """.trimIndent(),
        english = """
            (The profound meditation on Dakshinamurti / Dhyana Shloka): (Exactly before chanting the mantra, one must intensely meditate upon the Lord exactly in this manner):
            "The sincere seeker must deeply meditate (Dhyayet) upon that Lord whose physical body is exceptionally brilliantly radiant and fiercely glowing exactly like a pure 'Sphatika' (Crystal) jewel (Sannibham)."
            "Who flawlessly possesses exactly three eyes (Trinayanam / sun, moon, and fire), and who, with exceptionally immense joy (Muda), directly in His right hand (Dakshinabahuna)."
            "Flawlessly holds (Dadhanam) the supreme 'Jnana Mudra' (Bodham / the absolute symbol of cosmic wisdom). And who, exactly in His other (left) hand, gracefully holds a sacred 'Book' (Pustakam / Vedas) completely filled to the brim with 'Amrita' (immortal, indestructible wisdom)."
            The absolute first strict rule of deep Meditation is flawlessly establishing a razor-sharp 'Focus Point'. Our highly chaotic brain simply cannot anchor itself purely on empty zero completely without an Image.
            Therefore, the Upanishad brilliantly provides an exceptionally beautiful and highly Scientific Form (Rupa) of Lord Shiva.
            'Sphatika' (Crystal) profoundly means that God's absolute mind and form are 100% perfectly Transparent and spotless; containing absolutely zero adulteration (sin).
            His 'Third Eye' clearly proves that He absolutely does not observe the world with cheap skin-eyes, but strictly through the 'Eye of Wisdom' where absolutely no blinding veil exists.
            The 'Jnana Mudra' (the exact union of the thumb and index finger) perfectly symbolizes that when the human ego (index finger) flawlessly joins God (thumb), the ultimate Circuit of wisdom is instantly completed.
            And the 'Book' strictly in His hand definitively proves that the absolute entire knowledge of all Vedas rests directly in His hand; He is undeniably the cosmos's absolute only and greatest 'Vice-Chancellor'.
        """.trimIndent()
    ),
    DakshinamurtiShloka(
        id = 7,
        sanskrit = "मुद्रां भद्रार्थदात्रीं सपरशुहरिणं बाहुभिर्बाहुमन्तम् । बद्धोपापान्तभृङ्गं वटविटपसमीपे निषण्णं प्रसन्नम् ॥ ७ ॥",
        hindi = """
            (ध्यान श्लोक जारी है): "साधक को ध्यान करना चाहिए कि भगवान अपने बाकी हाथों (बाहुभिर्बाहुमन्तम्) में।"
            "सभी प्रकार के कल्याण और परम सुख (भद्रार्थ) को देने वाली (दात्रीं) 'मुद्रा' (वरद मुद्रा), तथा एक 'परशु' (कुल्हाड़ी) और एक 'हरिण' (हिरण) धारण किए हुए हैं।"
            "वे भगवान अपने एक पैर को मोड़कर (बद्ध) एक अत्यंत विशाल बरगद के पेड़ (वटविटप) के बिल्कुल समीप (समीपे) विराजमान (निषण्णं) हैं।"
            "और उनका चेहरा अत्यंत 'प्रसन्न' (प्रसन्नम् / शांत और खुशी से भरा हुआ) है, और उनके आसपास भंवरे (भृङ्गं) गूंज रहे हैं।"
            इस श्लोक में भगवान के अस्त्रों (Weapons) का बहुत ही गहरा 'साइकोलॉजिकल' (Psychological) अर्थ छिपा है।
            उनके हाथ में 'परशु' (कुल्हाड़ी) लकड़ी काटने के लिए नहीं है; यह वह कुल्हाड़ी है जो इंसान के जन्म-जन्मांतरों के 'अहंकार और अज्ञान' रूपी पेड़ को एक ही झटके में काट देती है।
            उनके हाथ में 'हिरण' (Deer) है। हिरण दुनिया का सबसे चंचल जानवर है, जो हमारे 'मन' (Monkey-mind) का साक्षात् प्रतीक है। हिरण का भगवान के हाथ में होने का अर्थ है कि भगवान ने उस चंचल मन को पूरी तरह से 'कंट्रोल' (Control) कर लिया है।
            'वट-वृक्ष' (बरगद का पेड़) साक्षात् इस अमर 'संसार' का प्रतीक है, जिसकी जड़ें बहुत गहरी हैं।
            भगवान उस पेड़ के नीचे (दुनिया के बीचोबीच) बैठे हैं, फिर भी उनका चेहरा अत्यंत 'प्रसन्न' (Stress-free) है।
            यह हमें सिखाता है कि भले ही तुम इस भयंकर दुनिया (बरगद के पेड़) के बीच बैठे हो, पर तुम्हारे चेहरे की 'प्रसन्नता' (शांति) कभी गायब नहीं होनी चाहिए।
        """.trimIndent(),
        english = """
            (The meditation Shloka continues): "The seeker must profoundly meditate that the Lord, directly in His other remaining hands (Bahubhirbahumantam)."
            "Flawlessly holds the 'Mudra' (Varada Mudra) that exclusively bestows (Datrim) absolutely all ultimate welfare and supreme cosmic joy (Bhadrartha), along with a sharp 'Parashu' (Axe) and a wild 'Harina' (Deer)."
            "That Supreme Lord sits perfectly majestically (Nishannam) with one leg elegantly folded (Baddha) directly adjacent (Samipe) to an exceptionally massive Banyan tree (Vatavitapa)."
            "And His divine face is exceptionally 'Prasannam' (supremely joyful, profoundly peaceful, and entirely stress-free), with buzzing bees (Bhringam) humming beautifully nearby."
            This spectacular verse conceals an exceptionally profound 'Psychological' meaning perfectly within the Lord's physical Weapons.
            The 'Parashu' (Axe) perfectly in His hand is absolutely not for chopping cheap wood; it is exactly that terrifying axe strictly designed to violently sever the massive tree of human 'Ego and Ignorance' in a single, brutal stroke.
            He holds a 'Deer' (Harina). The deer is undeniably the absolute most highly restless animal, precisely symbolizing our chaotic 'Monkey-mind'. The deer safely in God's hand explicitly proves that He has 100% flawlessly 'Controlled' that restless mind entirely.
            The 'Vata-Vriksha' (Banyan tree) is the direct, exact symbol of this immortal 'Samsara' (world), whose roots are exceptionally deep and terrifying.
            God sits perfectly under that tree (exactly right in the chaotic middle of the world), yet His face remains exceptionally 'Prasanna' (100% Stress-free).
            This brilliantly teaches us that even if you are actively sitting squarely in the middle of this terrifying world (Banyan tree), the profound 'Joy' (peace) of your face must absolutely never, ever vanish.
        """.trimIndent()
    ),
    DakshinamurtiShloka(
        id = 8,
        sanskrit = "अपस्मारोपरि श्रोणिं विन्यस्यैकमृजुं पदम् । शुककादिसमुनीन्द्राणां तत्त्वमस्यादिलक्षणम् ॥ ८ ॥",
        hindi = """
            (ध्यान का अंतिम चरण और अपस्मार): "वे भगवान अपने शरीर का भार (श्रोणिं) एक भयंकर राक्षस जिसका नाम 'अपस्मार' (अपस्मारोपरि) है, उसकी पीठ के बिल्कुल ऊपर रखे हुए (विन्यस्य) हैं।"
            "उनका एक पैर पूरी तरह से सीधा (ऋजुं) और स्थिर है।"
            "और वे भगवान शुकदेव और सनकादि (शुककादिसमुनीन्द्राणां) जैसे अत्यंत महान और ज्ञानी मुनियों (मुनीन्द्राणां) की सभा के बीचोबीच बैठकर।"
            "उन्हें अपने मौन और अपनी मुद्रा के द्वारा 'तत्त्वमसि' (Thou Art That / तुम ही ब्रह्म हो) आदि महावाक्यों का परम लक्ष्य (लक्षणम्) साक्षात् समझा रहे हैं।"
            इस श्लोक में जो 'अपस्मार' (Apasmara) नाम का राक्षस है, वह दुनिया का सबसे खतरनाक दानव है। 'अपस्मार' का असली मतलब है 'मिर्गी' (Epilepsy) या 'भूल जाना' (Forgetfulness / Ignorance)।
            यह वह दानव है जो हमें हमारी असली पहचान (कि मैं आत्मा हूँ) भुला देता है और हमें शरीर का गुलाम बना देता है।
            भगवान शिव ने उस 'अज्ञान रूपी राक्षस' को अपने पैर के नीचे बुरी तरह कुचल कर रखा हुआ है; जिसका मतलब है कि ज्ञान हमेशा अज्ञान की छाती पर पैर रखकर ही जीता है।
            उनके सामने शुकदेव और सनक जैसे वो ऋषि बैठे हैं जिनकी उम्र भगवान ब्रह्मा से भी ज्यादा है और जो जन्म से ही ज्ञानी हैं।
            पर वे बूढ़े और महान ऋषि भी भगवान 'दक्षिणामूर्ति' (जो 16 साल के एक अत्यंत युवा और सुंदर लड़के के रूप में बैठे हैं) के सामने हाथ जोड़कर एक छात्र (Student) की तरह बैठे हैं।
            यह दिखाता है कि ज्ञान में 'उम्र' (Age) की कोई औकात नहीं होती; जो भगवान (ज्ञान) है, वह हमेशा 'युवा' (जवान और फ्रेश) ही रहता है, और अज्ञान हमेशा बूढ़ा होता है।
        """.trimIndent(),
        english = """
            (The absolute final stage of meditation and Apasmara): "That Supreme Lord has flawlessly placed (Vinyasya) the heavy weight of His body (Shronim) directly squarely upon the back of a terrifying demon specifically named 'Apasmara' (Apasmaropari)."
            "His one specific leg rests perfectly straight (Rijum), flawlessly firm and completely immovable."
            "And that Lord sits precisely right in the absolute center of a massive assembly of exceptionally magnificent and highly enlightened supreme sages (Munindranam) like Shukadeva and Sanaka (Shukakadisamunindranam)."
            "Actively and profoundly explaining to them the absolute supreme target (Lakshanam) of the grand Mahavakyas like 'Tat Tvam Asi' (Thou Art That) strictly through His profound silence and divine hand gesture."
            The terrifying demon specifically named 'Apasmara' perfectly described in this verse is undeniably the world's absolute most highly dangerous monster. 'Apasmara' strictly means 'Epilepsy' or absolute 'Forgetfulness' (Dark Ignorance).
            This is exactly that specific demon who ruthlessly forces us to entirely forget our true identity (that I am the Soul) and makes us pathetic slaves to the body.
            Lord Shiva has violently and brutally crushed that 'Demon of Ignorance' directly under His heavy foot; perfectly symbolizing that Wisdom absolutely always violently triumphs strictly by stepping squarely on the chest of ignorance.
            Sitting directly before Him are magnificent sages like Shukadeva and Sanaka, whose biological age is vastly older than Lord Brahma and who are enlightened directly from birth.
            Yet those ancient, colossal sages sit perfectly with folded hands exactly like highly obedient Students strictly before Lord 'Dakshinamurti' (who sits flawlessly appearing as an exceptionally beautiful, 16-year-old young boy).
            This brilliantly proves that physical 'Age' possesses absolutely zero value in front of supreme wisdom; God (Wisdom) is perpetually and eternally 'Young' (fresh and blazing), while ignorance is permanently old and rotting.
        """.trimIndent()
    ),
    DakshinamurtiShloka(
        id = 9,
        sanskrit = "दक्षिणाभिमुखो देवः... कस्मादुच्यते दक्षिणामूर्तिरिति । अमूर्तित्वेन स्थितो यो ह्यनन्तैश्वर्यलक्षणः । दक्षिणामूर्तिरित्युक्तो ब्रह्मविद्भिर्महात्मभिः ॥ ९ ॥",
        hindi = """
            (दक्षिणामूर्ति नाम का असली रहस्य): ऋषियों ने पूछा: "हे मार्कण्डेय! उन परम देव को वास्तव में 'दक्षिणामूर्ति' क्यों कहा (कस्मादुच्यते) जाता है?"
            महर्षि ने एक अत्यंत गहरा और दार्शनिक उत्तर दिया: "वह परमात्मा जो वास्तव में 'अमूर्ति' (अमूर्तित्वेन / जिसका कोई भौतिक रूप या आकार न हो / Formless) होकर भी।"
            "अनंत ऐश्वर्य और असीम शक्तियों का साक्षात् प्रतीक (लक्षणः) बनकर सभी जीवों के भीतर स्थित (स्थितो) है।"
            "उसी परम निराकार तत्त्व को महान ब्रह्मज्ञानी (ब्रह्मविद्भिः) और महात्माओं (महात्मभिः) ने 'दक्षिणामूर्ति' कहकर पुकारा (इत्युक्तो) है।"
            'दक्षिणामूर्ति' शब्द का आम आदमी के लिए मतलब है: वह भगवान जो 'दक्षिण' दिशा की ओर मुँह (मूर्ति) करके बैठा है।
            पर वेदान्त में इसका एक बहुत ही 'माइंड-बेंडिंग' (Mind-bending) अर्थ है, जो यहाँ बताया गया है।
            'दक्षिण' (Dakshina) का संस्कृत में एक और अर्थ होता है: 'बुद्धिमान' (Intelligent / Capable) या 'कुशल' (Expert)।
            और 'अमूर्ति' (Amurti) का अर्थ है जिसका कोई शरीर या आकार न हो (Formless)।
            अर्थात, वह अत्यंत 'कुशल और परम बुद्धिमान' (दक्षिण) भगवान जो बिना किसी शरीर (अमूर्ति) के भी पूरे ब्रह्मांड को अत्यंत परफेक्ट (Perfect) तरीके से चला रहा है, वही 'दक्षिणामूर्ति' (दक्षिण + अमूर्ति) है!
            भगवान की असली पहचान कोई पत्थर की मूर्ति नहीं है; वह तो एक असीम 'सुपर-इंटेलिजेंस' (Super-Intelligence / दक्षिण) है जिसका कोई आकार (अमूर्ति) नहीं है।
        """.trimIndent(),
        english = """
            (The absolute true secret behind the name Dakshinamurti): The sages eagerly asked: "O Markandeya! Exactly why (Kasmaduchyate) is that Supreme Lord actually called 'Dakshinamurti'?"
            The great sage profoundly delivered an exceptionally deep, philosophical answer: "That Supreme Lord who, despite being fundamentally 'Amurti' (Amurtitvena / possessing absolutely zero physical form or shape / Formless)."
            "Flawlessly exists and sits firmly established (Sthito) exactly inside absolutely all living beings as the direct, ultimate symbol (Lakshanah) of infinite, absolute cosmic glory and supreme power."
            "That exact supreme, completely formless principle is profoundly called (Ityukto) 'Dakshinamurti' exclusively by the exceptionally great souls (Mahatmabhih) and ultimate knowers of Brahman (Brahmavidbhih)."
            For a common, ordinary man, the word 'Dakshinamurti' literally means: the Lord who sits physically facing His form (Murti) strictly towards the 'South' direction.
            But strictly in advanced Vedanta, it holds an exceptionally 'Mind-bending', highly classified meaning, explicitly revealed right here.
            In pure Sanskrit, 'Dakshina' has another incredibly profound meaning: 'Exceptionally Intelligent' (Capable) or 'Absolute Expert' (Daksh).
            And 'Amurti' strictly translates to that which possesses absolutely zero physical body, shape, or boundary (Formless).
            Meaning, that exceptionally 'Expert and Supreme Intelligence' (Dakshina) God who flawlessly and perfectly operates this entire colossal universe completely without any physical body (Amurti), He exactly is 'Dakshinamurti' (Dakshina + Amurti)!
            God's absolute true identity is undeniably not a cheap stone idol; He is strictly a boundless, infinite 'Super-Intelligence' (Dakshina) that possesses absolutely no physical form (Amurti) whatsoever.
        """.trimIndent()
    ),
    DakshinamurtiShloka(
        id = 10,
        sanskrit = "रहस्यं ज्ञानमुद्रायाः कथमित्यत्र कथ्यते । अङ्गुष्ठतर्जनीयोगो ज्ञानमुद्रेति कीर्त्यते ॥ १० ॥",
        hindi = """
            (ज्ञान मुद्रा का रहस्य): ऋषियों ने फिर पूछा: "हे भगवन्! भगवान शिव के हाथ में जो वह 'ज्ञान-मुद्रा' (ज्ञान का संकेत) है, उसका परम 'रहस्य' (Secret / रहस्यं) क्या है?"
            महर्षि मार्कण्डेय कहते हैं: "यहाँ मैं उस परम ज्ञान-मुद्रा का सबसे बड़ा रहस्य स्पष्ट रूप से बताता हूँ (कथ्यते)।"
            "मनुष्य के हाथ के 'अंगूठे' (अङ्गुष्ठ) और 'तर्जनी' (इंडेक्स फिंगर / तर्जनी) उंगली का जो आपस में 'योग' (योगो / मिलन / Touching) होता है।"
            "महान ज्ञानियों द्वारा केवल उसी परफेक्ट (Perfect) मिलन को ही साक्षात् 'ज्ञान-मुद्रा' (ज्ञानमुद्रेति) कहकर पुकारा जाता है (कीर्त्यते)।"
            भगवान शिव कोई भी काम बिना 'डीप साइंस' (Deep Science) के नहीं करते। इस मुद्रा में पूरा का पूरा 'अद्वैत वेदान्त' (Non-duality) छिपा है!
            हाथ की 5 उंगलियों में, जो 'अंगूठा' (Thumb) है, वह साक्षात् 'परमात्मा' (ईश्वर) का प्रतीक है (क्योंकि अंगूठे के बिना कोई उंगली काम नहीं कर सकती)।
            और जो 'तर्जनी' (Index finger / जिससे हम दूसरों को पॉइंट करते हैं) है, वह इंसान का घमंडी 'अहंकार' (Ego / जीवात्मा) है जो हमेशा अकड़कर खड़ा रहता है।
            बाकी की 3 उंगलियां (मध्यमा, अनामिका, कनिष्ठा) इंसान के तीन गुणों (सत्व, रज, तम) और तीन शरीरों (स्थूल, सूक्ष्म, कारण) की प्रतीक हैं।
            जब इंसान का 'अहंकार' (तर्जनी) उन तीनों गुणों की दुनिया से अलग होकर थोड़ा झुकता है और 'परमात्मा' (अंगूठे) के चरणों में आकर पूरी तरह जुड़ (योग) जाता है।
            तो उस समय जीवात्मा और परमात्मा के बीच कोई गैप (Gap) नहीं रहता; दोनों एक (सर्कल/Circle) हो जाते हैं! इसी 'एक होने' को ही 'ज्ञान-मुद्रा' और मोक्ष कहते हैं।
        """.trimIndent(),
        english = """
            (The supreme secret of the Jnana Mudra): The sages eagerly asked again: "O Supreme Lord! What exactly is the absolute, highly classified 'Secret' (Rahasya) of that precise 'Jnana-Mudra' (Gesture of Wisdom) physically held perfectly in Lord Shiva's hand?"
            Sage Markandeya profoundly replies: "Here, I explicitly and flawlessly reveal (Kathyate) the absolute greatest secret of that supreme Jnana-Mudra."
            "The exact, flawless 'Yoga' (Yogo / precise touching and perfect union) of the human hand's 'Thumb' (Angushtha) and the 'Index Finger' (Tarjani)."
            "That perfectly flawless union alone is profoundly and loudly declared (Kirtyate) exactly as the direct 'Jnana-Mudra' (Gesture of Absolute Wisdom) by the greatest enlightened sages."
            Lord Shiva absolutely never, ever does anything whatsoever without exceptionally 'Deep Science'. The absolute entirety of 'Advaita Vedanta' (Non-duality) is completely hidden strictly inside this tiny gesture!
            Among the exact 5 fingers of the hand, the 'Thumb' perfectly and flawlessly symbolizes the direct 'Paramatman' (Supreme God) (strictly because completely without the thumb, absolutely no other finger can possibly function).
            And the 'Index Finger' (with which we aggressively point at others) undeniably symbolizes the highly arrogant, toxic human 'Ego' (Jivatman) that perpetually stands stiff and proud.
            The remaining 3 fingers (middle, ring, little) perfectly symbolize the three human Gunas (Sattva, Rajas, Tamas) and the three specific physical/subtle bodies.
            Exactly when the human 'Ego' (index finger) completely detaches from the toxic world of those three Gunas, humbly bows down, and flawlessly connects (Yoga) entirely at the sacred feet of 'God' (Thumb).
            At that exact split-second, absolutely zero Gap remains left between the soul and God; both flawlessly become completely One (a perfect Circle)! This exact 'Becoming One' alone is called 'Jnana-Mudra' and absolute Moksha.
        """.trimIndent()
    ),
    DakshinamurtiShloka(
        id = 11,
        sanskrit = "किं पुस्तकम् । अव्याहतविद्याप्रतिपादकमिति ॥ ११ ॥",
        hindi = """
            (पुस्तक का रहस्य): ऋषियों ने अगला अत्यंत महत्वपूर्ण सवाल पूछा: "हे भगवन्! भगवान दक्षिणामूर्ति के हाथ में जो 'पुस्तक' (किं पुस्तकम् / Book) है, वह वास्तव में क्या है?"
            (भगवान को किताब की क्या जरूरत? वे तो स्वयं ज्ञान के सागर हैं!)
            महर्षि मार्कण्डेय ने तुरंत उत्तर दिया: "वह पुस्तक कोई सामान्य पन्नों की किताब नहीं है; वह साक्षात् उस 'अव्याहत-विद्या' (अखंड और बिना रुकावट वाले परम ज्ञान) को प्रतिपादित (स्थापित/सिद्ध) करने वाली है।"
            यहाँ 'अव्याहत विद्या' का अर्थ है वह ज्ञान जो कभी कट नहीं सकता (Unstoppable knowledge / Absolute Truth)।
            दुनिया की साइंस (Science) की किताबें आज कुछ कहती हैं और कल गलत साबित हो जाती हैं; यह 'व्याहत' (रुकने वाला) ज्ञान है।
            परन्तु भगवान के हाथ में जो वेदों (श्रुति) का 'ज्ञान' है, वह 'अव्याहत' है—यानी बिग बैंग (Big Bang) से लेकर ब्लैक होल (Black hole) तक, वह ज्ञान कभी नहीं बदलता।
            भगवान दक्षिणामूर्ति के हाथ में पुस्तक होने का यह मतलब है कि वेदों का सारा ज्ञान किसी इंसान ने नहीं लिखा है; वह ज्ञान सीधा भगवान के हाथों से उतरा है।
            भगवान को खुद उस किताब को 'पढ़ने' की जरूरत नहीं है; वह किताब भगवान के हाथ में एक 'प्रतीक' (Symbol) है जो शिष्यों को यह बताती है:
            "अगर तुम्हें सत्य जानना है, तो केवल उस 'अव्याहत विद्या' (वेदान्त) की शरण लो, दुनिया के झूठे और बदलने वाले तर्कों (Logic) की नहीं।"
            वह पुस्तक साक्षात् ब्रह्मविद्या (ब्रह्म को जानने वाली विद्या) का साक्षात भौतिक रूप है।
        """.trimIndent(),
        english = """
            (The absolute secret of the Book): The sages aggressively asked the next exceptionally crucial question: "O Supreme Lord! What exactly is that 'Book' (Kim pustakam) resting perfectly in the hands of Lord Dakshinamurti?"
            (What exact need does God possibly have for a physical book? He Himself is the infinite ocean of wisdom!)
            Sage Markandeya answered instantaneously: "That specific book is absolutely no ordinary book made of cheap paper pages; it is exactly that which actively establishes and physically proves (Pratipadakam) the direct 'Avyahata-Vidya' (Absolute, unstoppable, and unbroken Supreme Wisdom)."
            Here, 'Avyahata Vidya' profoundly translates precisely to that ultimate wisdom which can absolutely never be refuted or defeated (Unstoppable Knowledge / The Absolute Truth).
            The cheap Science books of this world fiercely declare something today and are brutally proven completely wrong tomorrow; this is heavily 'Vyahata' (stoppable/flawed) knowledge.
            But the absolute 'Wisdom' of the Vedas (Shruti) resting flawlessly in God's hand is 'Avyahata'—meaning, from the massive Big Bang exactly up to the final Black Hole, that absolute wisdom absolutely never, ever changes.
            Lord Dakshinamurti holding a physical book exactly means that the absolute entirety of Vedic knowledge was absolutely not written by any pathetic human; that wisdom directly descended straight from God's own hands.
            God Himself absolutely does not need to 'Read' that physical book; that book is strictly a powerful 'Symbol' securely in God's hand, fiercely declaring to the disciples:
            "If you desperately wish to know the absolute Truth, take ruthless refuge exclusively in that 'Avyahata Vidya' (Vedanta), absolutely never in the world's false, constantly changing, and cheap human Logic."
            That sacred book is literally the exact direct physical manifestation of 'Brahmavidya' (The ultimate science of knowing Brahman).
        """.trimIndent()
    ),
    DakshinamurtiShloka(
        id = 12,
        sanskrit = "का चाग्निः । जाग्रत्स्वप्नसुषुप्त्यादिदहनकारिणेति ॥ १२ ॥",
        hindi = """
            (अग्नि का रहस्य): ऋषियों ने फिर पूछा: "हे भगवन्! उन भगवान के हाथ में जो भयंकर 'अग्नि' (आग / का चाग्निः) है, उसका क्या रहस्य है?"
            महर्षि मार्कण्डेय ने उत्तर दिया: "वह अग्नि कोई खाना पकाने वाली आग नहीं है; वह साक्षात् ज्ञान की वह भयंकर अग्नि है जो मनुष्य की 'जाग्रत' (जागना), 'स्वप्न' (सपने देखना), और 'सुषुप्ति' (गहरी नींद) आदि सभी अज्ञानमयी अवस्थाओं को।"
            "पूरी तरह से जलाकर राख (दहनकारिणेति) कर देने वाली है।"
            भगवान शिव (नटराज या दक्षिणामूर्ति) के एक हाथ में हमेशा धधकती हुई आग (Fire) होती है। यह आग 'विनाश' (Destruction) का प्रतीक है।
            पर यह आग दुनिया को नहीं जलाती; यह आग इंसान के दिमाग में बैठे हुए उस 'तीनों अवस्थाओं' के भयंकर इल्यूजन (Illusion) को जलाती है।
            हम दिन भर जागते (जाग्रत) हैं और दुनिया के दुखों से रोते हैं; रात को सपने (स्वप्न) देखकर डरते हैं; और फिर गहरी नींद (सुषुप्ति) के अंधेरे में बेहोश हो जाते हैं।
            यह तीनों अवस्थाएं इंसान को एक रोबोट (Robot) की तरह अपनी जेल में रखती हैं।
            भगवान के हाथ की वह 'अग्नि' साक्षात् वह परम 'आत्मज्ञान' (Self-knowledge) है जो इस पूरे नाटक (Matrix) को एक ही झटके में भस्म कर देती है।
            जब वह आग इंसान के भीतर जलती है, तो ये तीनों अवस्थाएं कट जाती हैं, और इंसान 'तुरीय' (Turiya / चौथी और परम मुक्त अवस्था) में प्रवेश कर जाता है।
            वह अग्नि इस बात की गारंटी है कि भगवान का ज्ञान तुम्हारे सारे जन्म-जन्मांतरों के कचरे को राख करने की 100% ताकत रखता है।
        """.trimIndent(),
        english = """
            (The terrifying secret of the Fire): The sages excitedly asked again: "O Supreme Lord! What exactly is the deep secret behind that terrifying 'Agni' (Blazing Fire / Ka chagnih) perfectly held exactly in the Lord's hand?"
            Sage Markandeya profoundly answered: "That specific fire is absolutely no ordinary fire meant for cheap cooking; it is strictly that terrifying, blazing fire of ultimate wisdom which brutally attacks the human states of 'Jagrat' (Waking), 'Svapna' (Dreaming), and 'Sushupti' (Deep sleep)."
            "And ruthlessly, violently burns all these completely ignorant states directly to absolute ashes (Dahanakarineti)."
            Lord Shiva (Nataraja or Dakshinamurti) perpetually holds a violently blazing Fire perfectly in one of His hands. This intense fire is the absolute direct symbol of total 'Destruction'.
            But this specific fire absolutely does not burn the physical world; this terrifying fire brutally burns the horrific Illusion of those 'three states' firmly seated precisely in the human brain.
            We are awake (Jagrat) the entire day and violently cry over the world's brutal sorrows; we are terrified at night seeing horrific dreams (Svapna); and then we fall totally unconscious in the dark of deep sleep (Sushupti).
            These exact three states violently imprison the helpless human entirely in their dark jail exactly like a programmed Robot.
            That 'Fire' strictly in God's hand is literally that exact Supreme 'Self-knowledge' (Jnana) which violently burns this entire cheap worldly Drama (Matrix) to ashes in a single stroke.
            Exactly when that blazing fire violently ignites directly inside a human, these three states are brutally slashed away, and the human flawlessly enters 'Turiya' (the fourth and absolute supremely liberated state).
            That terrifying fire is the absolute ironclad guarantee that God's supreme wisdom possesses the 100% violent raw power to permanently reduce the heavy garbage of your millions of lifetimes directly to ashes.
        """.trimIndent()
    ),
    DakshinamurtiShloka(
        id = 13,
        sanskrit = "को वटः । महासंसाररूपेण तिष्ठतीति ॥ १३ ॥",
        hindi = """
            (बरगद के पेड़ का रहस्य): ऋषियों ने अत्यंत उत्सुकता से पूछा: "हे भगवन्! भगवान दक्षिणामूर्ति जिस 'वट' (बरगद के पेड़ / को वटः) के नीचे बैठे हैं, वह पेड़ वास्तव में क्या है?"
            महर्षि मार्कण्डेय ने उत्तर दिया: "वह बरगद का पेड़ साक्षात् इस 'महान संसार' (महासंसाररूपेण / इस पूरे ब्रह्मांड और जन्म-मरण के चक्र) का ही विशाल रूप धारण करके खड़ा (तिष्ठतीति) है।"
            हिंदू धर्म में 'वट वृक्ष' (Banyan tree) को संसार (World) का सबसे परफेक्ट (Perfect) और सटीक प्रतीक माना गया है (इसे भगवद्गीता में भी 'अश्वत्थ' कहा गया है)।
            बरगद के पेड़ की खासियत यह है कि उसकी शाखाओं (Branches) से ही नई जड़ें (Roots) निकलकर वापस ज़मीन में घुस जाती हैं।
            जिससे यह पता लगाना नामुमकिन हो जाता है कि इस पेड़ की 'असली शुरुआत' (Main root) कहाँ से हुई थी; यह लगातार बिना मरे फैलता ही जाता है।
            हमारा यह संसार (जन्म और मृत्यु का चक्र) भी बिल्कुल उसी बरगद के पेड़ की तरह है!
            कर्मों (शाखाओं) से नए शरीर (जड़ें) बनते हैं, और नए शरीरों से फिर नए कर्म बनते हैं; यह भयंकर लूप (Loop) कभी खत्म नहीं होता।
            भगवान शिव उस 'वट वृक्ष' (संसार) के बिल्कुल 'नीचे' (मूल / Root पर) बैठे हैं। इसका मतलब है कि भगवान ही इस पूरे संसार का 'बेस' (आधार) हैं।
            और यह भी संदेश है कि जब तक तुम इस संसार (पेड़) की शाखाओं में उलझे रहोगे, तुम भटकते रहोगे; मोक्ष पाने के लिए तुम्हें पेड़ की जड़ (ईश्वर) के पास शांति से आकर बैठना होगा।
        """.trimIndent(),
        english = """
            (The supreme secret of the Banyan Tree): The sages asked with extreme curiosity: "O Lord! What exactly is that massive 'Vata' (Banyan Tree / Ko vatah) strictly under which Lord Dakshinamurti sits so peacefully?"
            Sage Markandeya profoundly answered: "That specific Banyan tree stands firmly entirely assuming the direct, exceptionally massive form strictly of this 'Maha-Samsara' (Mahasamsararupena / this entire colossal universe and the terrifying cycle of birth and death) itself (Tishthatiti)."
            In Hinduism, the 'Vata Vriksha' (Banyan Tree) is profoundly considered the absolute most perfect, mathematically exact physical symbol of the entire Samsara (World) (it is also fiercely called 'Ashvattha' in the Bhagavad Gita).
            The absolute most terrifying characteristic of the Banyan tree is that brand-new physical Roots violently grow straight out of its own hanging Branches and ruthlessly plunge back into the ground again.
            Making it physically completely impossible to successfully locate exactly where the 'actual, real beginning' (Main root) of this massive tree actually started; it merely spreads endlessly, absolutely refusing to die.
            This terrifying Samsara of ours (the brutal, endless cycle of birth and death) is exactly, flawlessly identical strictly to that very Banyan tree!
            Karmas (branches) aggressively manufacture new physical bodies (roots), and those new bodies violently generate fresh karmas; this terrifying Loop absolutely never, ever ends.
            Lord Shiva sits perfectly exactly 'Under' (at the absolute Root of) that massive 'Vata Vriksha' (world). This flawlessly means that God alone is the absolute, ultimate 'Base' (Foundation) of this entire cosmos.
            And the brutal message is: Exactly as long as you remain hopelessly entangled in the chaotic branches of this Samsara (tree), you will wander violently; to attain Moksha, you absolutely must climb down and sit peacefully exactly at the Root (God) of the tree.
        """.trimIndent()
    ),
    DakshinamurtiShloka(
        id = 14,
        sanskrit = "कोऽपस्मारः । अविद्यारूपेण तिष्ठतीति ॥ १४ ॥",
        hindi = """
            (अपस्मार राक्षस का रहस्य): ऋषियों ने पूछा: "हे भगवन्! भगवान ने अपने पैर के नीचे जिस 'अपस्मार' (कोऽपस्मारः / भयंकर दानव) को कुचल कर रखा है, वह वास्तव में कौन है?"
            महर्षि मार्कण्डेय ने स्पष्ट उत्तर दिया: "वह अपस्मार दानव और कोई नहीं, बल्कि साक्षात् 'अविद्या' (अज्ञान / Ignorance) का ही भयंकर रूप धारण करके वहाँ पड़ा हुआ (तिष्ठतीति) है।"
            'अपस्मार' शब्द का मेडिकल (Medical) अर्थ 'मिर्गी की बीमारी' (Epilepsy) है, जहाँ इंसान अपने होश और अपनी पहचान (Identity) को पूरी तरह भूल जाता है और तड़पता है।
            आध्यात्मिक भाषा में, यह 'अविद्या' (अज्ञान) ही वह सबसे बड़ी मिर्गी की बीमारी है जिसने पूरी इंसानियत को अपना शिकार बना रखा है!
            हम सब अविद्या के शिकार हैं, क्योंकि हम अपनी असली पहचान (कि मैं अमर आत्मा हूँ) भूलकर इस मिट्टी के शरीर को 'मैं' मानकर दुख में तड़प रहे हैं।
            भगवान शिव (दक्षिणामूर्ति) ने उस 'अविद्या रूपी दानव' को मारा नहीं है, बल्कि उसे अपने पैर के नीचे 'दबा' कर रखा है।
            यह बहुत बड़ा सीक्रेट (Secret) है: अज्ञान (माया) को कभी पूरी तरह से मारा नहीं जा सकता, क्योंकि वह भी भगवान के खेल (Creation) का ही एक हिस्सा है।
            परंतु अज्ञान को हमेशा ज्ञान के भारी 'पैर' (कंट्रोल / Control) के नीचे दबा कर रखना पड़ता है।
            जब ज्ञान का पैर अज्ञान की छाती पर भारी पड़ता है, तो अज्ञान कभी इंसान पर हावी होकर उसे भटका नहीं सकता।
            यह श्लोक बताता है कि योग का असली मकसद राक्षसों को मारना नहीं, बल्कि अपनी 'अविद्या' (मूर्खता) को पूरी तरह से कंट्रोल (Control) करना है।
        """.trimIndent(),
        english = """
            (The terrifying secret of the Apasmara Demon): The sages aggressively asked: "O Lord! Who exactly is that terrifying 'Apasmara' (Ko'pasmarah / massive monster) that the Lord has brutally crushed directly under His heavy foot?"
            Sage Markandeya explicitly answered: "That terrifying Apasmara demon is absolutely none other than 'Avidya' (Dark Ignorance) itself, actively lying there directly assuming its most horrific physical form (Avidyarupena tishthatiti)."
            The literal Medical translation of the word 'Apasmara' is the terrifying disease of 'Epilepsy', exactly where a human completely loses his consciousness and identity, and thrashes violently in severe agony.
            In profound spiritual language, this exact 'Avidya' (Dark Ignorance) is undeniably the absolute biggest, most horrific disease of epilepsy that has violently victimized all of humanity!
            Absolutely all of us are pathetic victims of Avidya, strictly because, completely forgetting our true identity (that I am the immortal Soul), we falsely accept this dirt-body as 'I' and thrash violently in agonizing sorrow.
            Lord Shiva (Dakshinamurti) absolutely did not permanently kill that 'Demon of Avidya', but He has ruthlessly and brutally 'Pinned' it firmly directly under His heavy foot.
            This is an exceptionally colossal Secret: Ignorance (Maya) can absolutely never be 100% permanently killed, simply because it is also an essential, strict part of God's cosmic game (Creation).
            But Ignorance absolutely must always be brutally pinned down tightly directly under the heavy 'Foot' (Absolute Control) of supreme Wisdom.
            Exactly when the heavy foot of wisdom presses violently upon the chest of ignorance, ignorance can absolutely never overpower or maliciously mislead the human again.
            This phenomenal verse explicitly proves that the absolute true target of Yoga is not killing cheap physical monsters, but flawlessly and ruthlessly Controlling your very own 'Avidya' (stupidity).
        """.trimIndent()
    ),
    DakshinamurtiShloka(
        id = 15,
        sanskrit = "के च शुककादिसमुनीन्द्राः । स्वशिष्या इति ॥ १५ ॥",
        hindi = """
            (भगवान के शिष्यों का रहस्य): ऋषियों ने अपना अंतिम प्रश्न पूछा: "हे भगवन्! जो शुकदेव, सनक, सनन्दन आदि अत्यंत महान मुनींद्र (ऋषियों के भी राजा / के च शुककादिसमुनीन्द्राः) भगवान के सामने बैठे हैं, वे कौन हैं?"
            महर्षि मार्कण्डेय ने उत्तर दिया: "वे सभी महान और अति-प्राचीन ऋषि वास्तव में साक्षात् भगवान दक्षिणामूर्ति के 'अपने शिष्य' (स्वशिष्या / Personal Disciples) ही हैं।"
            यह श्लोक सुनने में बहुत साधारण लगता है, पर इसके पीछे का आध्यात्मिक विस्फोट (Spiritual explosion) बहुत बड़ा है!
            सनक, सनन्दन, सनातन और सनत्कुमार—ये चारों ब्रह्मा जी के 'मानस पुत्र' हैं (यानी ये सृष्टि के पहले दिन ही पैदा हो गए थे)।
            ये चारों ऋषि इतने ज्ञानी और इतने बूढ़े हैं कि खुद ब्रह्मा भी उनका सम्मान करते हैं।
            परंतु वे इतने बूढ़े (Ancient) और महान ऋषि एक 'सोलह साल के युवा लड़के' (दक्षिणामूर्ति) के सामने हाथ जोड़कर, ज़मीन पर एक छोटे से छात्र (Student) की तरह बैठे हैं!
            यह दृश्य यह साबित करता है कि आध्यात्म और वेदान्त में 'फिजिकल उम्र' (Physical Age) या 'सफेद बालों' की रत्ती भर भी कोई औकात (Value) नहीं है।
            भगवान (ज्ञान) हमेशा 'नया', 'ताजा' और 'युवा' (Young) होता है; और अज्ञान हमेशा पुराना और बूढ़ा होता है।
            चाहे आप दुनिया के सबसे बड़े प्रोफेसर (Professor) या 100 साल के बुजुर्ग ही क्यों न हों; 'परम सत्य' को जानने के लिए आपको अपना सारा घमंड छोड़कर।
            भगवान (सच्चे गुरु) के सामने एक बिल्कुल खाली और विनम्र 'शिष्य' (Student) बनकर ही बैठना पड़ता है; तभी ज्ञान का ट्रांसफर (Transfer) होता है।
        """.trimIndent(),
        english = """
            (The supreme secret of the Lord's disciples): The sages asked their absolute final question: "O Lord! Exactly who are those exceptionally magnificent, supreme kings of sages (Munindras / Ke cha shukakadisamunindrah) like Shukadeva, Sanaka, and Sanandana, sitting perfectly right in front of the Lord?"
            Sage Markandeya profoundly answered: "Absolutely all those colossal, highly ancient, and magnificent sages are, in absolute reality, the direct 'Personal Disciples' (Svashishya) of Lord Dakshinamurti Himself."
            This verse deceptively sounds highly ordinary, but the massive Spiritual Explosion completely hidden directly behind it is astronomically colossal!
            Sanaka, Sanandana, Sanatana, and Sanatkumara—these exact four are the direct 'Mind-born sons' of Lord Brahma (meaning, they were born exactly on the absolute first day of cosmic creation).
            These four specific sages are so incredibly ancient and unfathomably wise that even Lord Brahma Himself fiercely respects them.
            But those unimaginably ancient and magnificent sages are sitting perfectly completely on the ground exactly like tiny, obedient Students with folded hands strictly in front of a '16-year-old young boy' (Dakshinamurti)!
            This spectacular scene ruthlessly and flawlessly proves that in profound spirituality and strict Vedanta, 'Physical Age' or 'White Hair' possesses absolutely zero worth (Value) whatsoever.
            God (Supreme Wisdom) is perpetually 'New', perfectly 'Fresh', and eternally 'Young'; while ignorance is perpetually rotting, old, and stale.
            No matter if you are the world's absolute greatest Professor or a 100-year-old physical elder; to successfully know the 'Absolute Truth', you absolutely must ruthlessly abandon all your toxic pride.
            And you must sit exactly like a completely blank, highly humble 'Student' strictly before God (the True Guru); only, and strictly only then does the massive Transfer of supreme wisdom occur.
        """.trimIndent()
    ),
    DakshinamurtiShloka(
        id = 16,
        sanskrit = "मौनं च कीदृशम् । तत्त्वमस्यादिवाक्यानां बोधको मौनव्याख्यानम् ॥ १६ ॥",
        hindi = """
            (मौन व्याख्यान का परम रहस्य): ऋषियों ने पूछा: "हे भगवन्! भगवान दक्षिणामूर्ति जिस 'मौन' (चुप रहने / मौनं च कीदृशम्) का प्रयोग कर रहे हैं, वह मौन वास्तव में कैसा है और उसका क्या अर्थ है?"
            महर्षि मार्कण्डेय ने उत्तर दिया: "वह कोई साधारण चुप्पी नहीं है; भगवान का वह मौन (Mouna) ही उनका सबसे बड़ा 'व्याख्यान' (प्रवचन / Speech / मौनव्याख्यानम्) है!"
            "और उनका वह मौन ही उन बूढ़े ऋषियों को 'तत्त्वमसि' (तुम ही वह परब्रह्म हो) जैसे सबसे महान वाक्यों का सीधा और साक्षात् 'बोध' (अनुभव / बोधको) करा रहा है।"
            यह 'दक्षिणामूर्ति स्तोत्र' का सबसे वर्ल्ड-फेमस (World-famous) और सबसे रहस्यमयी कांसेप्ट (Concept) है: 'मौन व्याख्यान' (Silent Teaching)।
            हम सोचते हैं कि ज्ञान देने के लिए बहुत बड़ी-बड़ी किताबें पढ़नी पड़ती हैं और माइक (Mic) पर घंटों चिल्लाना पड़ता है।
            पर उपनिषद कहता है कि 'सत्य' (ब्रह्म) इतना बड़ा है कि दुनिया की कोई भी भाषा (शब्द) उसे समझा ही नहीं सकती! शब्द हमेशा छोटे पड़ जाते हैं।
            इसलिए जब आदि-गुरु दक्षिणामूर्ति कुछ बोलते नहीं, बल्कि पूर्ण 'सन्नाटे' (मौन) में बैठ जाते हैं; तो वह सन्नाटा ही उनका सबसे बड़ा 'भाषण' बन जाता है।
            शिष्य भगवान के उस परम शांत और असीम 'मौन' (Silence) के साथ अपने मन को ट्यून (Tune / Connect) कर लेते हैं।
            और बिना एक भी शब्द बोले, शिष्यों के दिमाग में 'तत्त्वमसि' (मैं ब्रह्म हूँ) का भयंकर ज्ञान किसी डेटा-ट्रांसफर (Data-transfer) की तरह 100% डाउनलोड (Download) हो जाता है!
            शब्द केवल दिमाग को भरते हैं, पर 'मौन' सीधे आत्मा में विस्फोट करता है।
        """.trimIndent(),
        english = """
            (The absolute supreme secret of Silent Teaching): The sages excitedly asked: "O Lord! What exactly is the true nature and profound meaning of that 'Mauna' (Absolute Silence / Maunam cha kidrisham) strictly being utilized by Lord Dakshinamurti?"
            Sage Markandeya profoundly answered: "That is absolutely no ordinary, cheap quietness; that absolute, profound Silence (Mauna) of the Lord is undeniably His absolute greatest 'Lecture' (Discourse / Speech / Maunavyakhyanam) itself!"
            "And that exact supreme Silence itself is flawlessly and directly causing the direct 'Bodha' (living realization/experience / Bodhako) of the absolute greatest Mahavakyas like 'Tat Tvam Asi' (Thou Art That) directly inside the brains of those ancient sages."
            This is undeniably the absolute most 'World-famous' and exceptionally highly mystical concept of the entire 'Dakshinamurti Stotram': 'Mauna Vyakhyana' (The Silent Teaching).
            We foolishly assume that to successfully impart supreme wisdom, one absolutely must aggressively read massive books and violently scream for hours on a physical Mic.
            But the Upanishad fiercely declares that the 'Truth' (Brahman) is so incredibly colossal that absolutely no human language (words) in the world can ever possibly explain it! Words perpetually fall pathetically short.
            Therefore, exactly when the Adi-Guru Dakshinamurti absolutely speaks nothing, but sits flawlessly in absolute, complete 'Stillness' (Silence); that exact silence instantly becomes His absolute greatest 'Speech'.
            The supreme disciples flawlessly 'Tune' (Connect) their highly receptive minds perfectly with that profoundly peaceful and infinite 'Silence' of the Lord.
            And completely without a single physical word ever being spoken, the terrifying, explosive wisdom of 'Tat Tvam Asi' (I am Brahman) is 100% flawlessly Downloaded directly into the disciples' brains exactly like an advanced Data-Transfer!
            Cheap words merely fill the limited brain, but absolute 'Silence' violently explodes directly inside the immortal Soul itself.
        """.trimIndent()
    ),
    DakshinamurtiShloka(
        id = 17,
        sanskrit = "मौनव्याख्यानप्रकटितपरब्रह्मतत्त्वं युवानं वर्षिष्ठांतेवसद्दृषिगणैरावृतं ब्रह्मनिष्ठैः... ॥ १७ ॥",
        hindi = """
            (दक्षिणामूर्ति स्तोत्र का प्रसिद्ध ध्यान): "मैं उन भगवान दक्षिणामूर्ति का ध्यान करता हूँ, जो अपने परम 'मौन रूपी व्याख्यान' (बिना बोले दिए गए उपदेश / मौनव्याख्यान) के द्वारा।"
            "उस अत्यंत गुप्त और परम 'परब्रह्मतत्त्व' (Supreme Brahman) को पूरी तरह से प्रकट (प्रकटित / Illuminate) कर रहे हैं।"
            "जो भगवान स्वयं अत्यंत 'युवा' (युवानं / 16 साल के जवान) हैं, परंतु जो अपने चारों ओर (आवृतं)।"
            "अत्यंत 'वृद्ध' (वर्षिष्ठां / बहुत बूढ़े) और साक्षात् 'ब्रह्म-निष्ठ' (ब्रह्म में पूरी तरह लीन) ऋषियों (ऋषिगणैः) के समूह से घिरे हुए बैठे हैं।"
            यह श्लोक सनातन धर्म के सबसे बड़े विरोधाभास (Paradox) और सबसे बड़े रहस्य को एक साथ दिखाता है!
            दुनिया का नियम है: गुरु हमेशा बूढ़ा (सफेद बालों वाला) होता है, और शिष्य हमेशा जवान (बच्चा) होता है।
            पर यहाँ भगवान दक्षिणामूर्ति ने इस नियम को उल्टा (Reverse) कर दिया है! गुरु (ईश्वर) 16 साल का फ्रेश (Fresh) और चमकता हुआ लड़का है, और शिष्य 10,000 साल के दाढ़ी वाले बूढ़े ऋषि हैं!
            यह दिखाता है कि 'ज्ञान' (सत्य) कभी बूढ़ा नहीं होता; सत्य हमेशा जवान, फ्रेश और शाश्वत (Eternal) है। अज्ञान और समय (Time) शरीर को बूढ़ा करते हैं, आत्मा को नहीं।
            जब वो बूढ़े ऋषि (जो पहले से ही बहुत बड़े ज्ञानी हैं) उस 'युवा' भगवान के मौन (Silence) को सुनते हैं, तो उनके अंदर का बचा-खुचा अज्ञान भी खत्म हो जाता है।
            मौन (सन्नाटा) दुनिया की सबसे लाउड (Loudest) और स्पष्ट भाषा है, बशर्ते (provided) आपका मन उसे सुनने के लिए 100% शांत हो।
        """.trimIndent(),
        english = """
            (The highly famous meditation of Dakshinamurti Stotram): "I intensely meditate upon that Supreme Lord Dakshinamurti, who, strictly through His supreme 'Silent Lecture' (Maunavyakhyana / teachings imparted completely without speaking a single word)."
            "Is flawlessly and perfectly Revealing (Prakatita / Illuminating) that exceptionally highly classified and supreme 'Parabrahmatattva' (The Absolute Truth of Supreme Brahman)."
            "That Lord Himself is exceptionally 'Young' (Yuvanam / a fresh 16-year-old boy), yet who sits completely surrounded (Avritam) on absolutely all sides."
            "By an exceptionally massive assembly of extremely 'Old' (Varshishtha / highly ancient) and completely 'Brahmanishtha' (fully absorbed strictly in Brahman) supreme sages (Rishiganaih)."
            This spectacular verse brilliantly displays Sanatana Dharma's absolute biggest Paradox and its absolute greatest, most explosive secret simultaneously!
            The strict rule of the physical world is: The Guru is absolutely always old (with white hair), and the disciple is absolutely always young (a child).
            But here, Lord Dakshinamurti has ruthlessly and flawlessly Reversed this exact rule entirely! The Guru (God) is a highly fresh, brilliantly glowing 16-year-old boy, and the disciples are 10,000-year-old ancient sages with massive white beards!
            This flawlessly proves that 'Wisdom' (The Absolute Truth) absolutely never, ever grows old; the Truth is permanently young, perfectly fresh, and strictly Eternal. Ignorance and Time merely age the dirt-body, absolutely never the immortal Soul.
            Exactly when those ancient sages (who are already exceptionally great knowers) carefully listen to the deep Silence of that 'Young' God, their remaining microscopic ignorance is permanently annihilated.
            Absolute Silence is undeniably the world's absolute Loudest and clearest language, provided your extremely restless mind is 100% perfectly calm enough to successfully hear it.
        """.trimIndent()
    ),
    DakshinamurtiShloka(
        id = 18,
        sanskrit = "आचार्येन्द्रं करकलितचिन्मुद्रमानन्दमूर्तिं स्वात्मारामं मुदितवदनं दक्षिणामूर्तिमीडे ॥ १८ ॥",
        hindi = """
            (ध्यान का पूर्ण समर्पण): "मैं उन सभी आचार्यों के भी परम आचार्य (आचार्येन्द्रं / Teachers of all teachers) की स्तुति करता हूँ।"
            "जिनके साक्षात् हाथ में (करकलित) वह परम पवित्र 'चिन्मुद्रा' (ज्ञान-मुद्रा) सुशोभित हो रही है।"
            "जो भगवान स्वयं ही साक्षात् 'आनंद की मूर्ति' (आनन्दमूर्तिं / Bliss incarnate) हैं।"
            "जो निरंतर केवल अपनी ही 'आत्मा में रमण' (स्वात्मारामं / अपनी ही चेतना में मगन) करने वाले हैं।"
            "और जिनका मुख-मंडल अत्यंत प्रसन्न और मुस्कराता हुआ (मुदितवदनं) है; ऐसे उन भगवान 'दक्षिणामूर्ति' की मैं बारम्बार स्तुति (ईडे / प्रार्थना) करता हूँ।"
            यह श्लोक एक सच्चे योगी (साधक) का अपने परम गुरु के चरणों में 100% फुल-सरेंडर (Full Surrender) है।
            जब इंसान हार मान लेता है कि मैं अपनी छोटी सी अक्ल (बुद्धि) से इस असीम भगवान को नहीं जान सकता, तब वह 'आचार्येन्द्र' (गुरुओं के गुरु) के आगे झुक जाता है।
            'स्वात्माराम' (आत्मा में रमण करना) का मतलब है कि भगवान को खुश होने के लिए किसी 'दूसरी' चीज़ (भक्तों, स्वर्ग, या पूजा) की कोई जरूरत नहीं है; वे अपने आप में 100% फुल (Full) और खुश हैं!
            और 'मुदितवदन' (प्रसन्न चेहरा) इस बात का सबसे बड़ा सुबूत (Proof) है कि जिसने अद्वैत (Non-duality) को जान लिया, उसके चेहरे से स्माइल (Smile) और शांति कभी नहीं जा सकती।
            चिंता (Stress) और उदासी केवल 'अज्ञानियों' का गहना है; जो साक्षात् आनंद की मूर्ति (आनन्दमूर्ति) है, वह केवल परमानंद (Bliss) ही बाँट सकता है।
            ध्यान में इसी प्रसन्न और असीम स्वरूप को देखने से साधक के अपने दुख भी तुरंत जलकर राख हो जाते हैं।
        """.trimIndent(),
        english = """
            (The absolute total surrender in meditation): "I deeply pray and fiercely praise the absolute supreme Teacher of all teachers (Acharyendram)."
            "In whose direct, sacred hand (Karakalita) that exceptionally supremely holy 'Chinmudra' (Jnana-Mudra) is brilliantly and flawlessly adorned."
            "That Supreme Lord who Himself is the exact, literal 'Embodiment of infinite Bliss' (Anandamurtim / Bliss incarnate)."
            "Who perpetually and endlessly 'Revels and rejoices exclusively strictly within His very own Soul' (Svatmaramam / entirely absorbed in His own consciousness)."
            "And whose divine facial expression is exceptionally joyful and brilliantly smiling (Muditavadanam); to exactly such Lord 'Dakshinamurti', I repeatedly and fiercely offer my supreme praises (Ide)."
            This phenomenal verse represents a true Yogi's (seeker's) absolute 100% 'Full Surrender' directly at the sacred feet of his Supreme Guru.
            Exactly when a human helplessly admits defeat, realizing he absolutely cannot comprehend this infinite God with his tiny, pathetic intellect, only then does he bow entirely before the 'Acharyendra' (Guru of Gurus).
            'Svatmarama' (reveling strictly in the Soul) profoundly means that God absolutely does not need any 'Second' thing whatsoever (devotees, heaven, or cheap worship) to be completely happy; He is 100% Full and ecstatic completely in Himself!
            And 'Muditavadana' (joyful, smiling face) is the absolute greatest definitive Proof that whosoever has flawlessly realized Advaita (Non-duality), the brilliant smile and infinite peace can absolutely never vanish from his face.
            Severe tension (Stress) and heavy sadness are exclusively the cheap ornaments of the 'ignorant'; He who is the literal embodiment of bliss (Anandamurti) can actively distribute exclusively pure Bliss.
            By vividly seeing this exact joyful and infinite form strictly in deep meditation, the sincere seeker's own terrifying sorrows also instantly burn violently to complete ashes.
        """.trimIndent()
    ),
    DakshinamurtiShloka(
        id = 19,
        sanskrit = "य इदं दक्षिणामूर्त्युपनिषदं नित्यमधीते स सर्वपापेभ्यो मुक्तो भवति । स सर्वान् कामानवाप्नोति ॥ १९ ॥",
        hindi = """
            (दक्षिणामूर्ति उपनिषद की फलश्रुति): "जो भी मुमुक्षु (मोक्ष की इच्छा रखने वाला) साधक इस अत्यंत गुप्त और परम पवित्र 'दक्षिणामूर्ति उपनिषद' (दक्षिणामूर्त्युपनिषदं) का प्रतिदिन निरंतर (नित्यं) पाठ और अध्ययन (अधीते) करता है।"
            "वह साधक निश्चित रूप से अपने करोड़ों जन्मों के संचित 'सभी प्रकार के भयंकर पापों' से हमेशा-हमेशा के लिए पूरी तरह 'मुक्त' (सर्वपापेभ्यो मुक्तो) हो जाता है (भवति)।"
            "और (न केवल मोक्ष), बल्कि वह साधक इस धरती पर रहते हुए अपनी 'सभी शुभ इच्छाओं और कामनाओं' (सर्वान् कामान्) को भी 100% प्राप्त (अवाप्नोति) कर लेता है।"
            सनातन धर्म (वेदान्त) का यह सबसे बड़ा बैलेंस (Balance) है: यह केवल मरने के बाद मिलने वाले 'मोक्ष' की बात नहीं करता, यह इसी जिंदगी में 'सफलता' (कामान्) की भी गारंटी देता है।
            पाप (Sins) क्या है? पाप वह भयंकर वायरस (Virus) है जो अज्ञान के अंधेरे में पैदा होता है।
            जब साधक दक्षिणामूर्ति (ज्ञान के सूर्य) का ध्यान करता है, तो ज्ञान की भयंकर आग में वो सारे पाप (वायरस) एक सेकंड में भस्म हो जाते हैं।
            और जब इंसान का मन पापों और टेंशन (Tension) से पूरी तरह साफ (Clear) हो जाता है, तो उसका दिमाग एक सुपर-कंप्यूटर (Super-computer) की तरह 100% फोकस (Focus) से काम करता है।
            उस फोकस के कारण, वह दुनिया में जो भी काम (पैसे कमाना, ज्ञान पाना) करता है, उसमें उसे 100% सफलता (काम-प्राप्ति) मिलती है।
            इसलिए इस उपनिषद का अध्ययन इंसान को अंदर से 'भगवान' (मुक्त) और बाहर से दुनिया का 'राजा' (सफल) दोनों एक साथ बना देता है।
        """.trimIndent(),
        english = """
            (The supreme Phala Shruti of Dakshinamurti Upanishad): "Whosoever sincere seeker (intensely desiring absolute Moksha) continuously and daily (Nityam) aggressively reads and profoundly studies (Adhite) this exceptionally highly classified and supremely sacred 'Dakshinamurti Upanishad'."
            "That specific seeker undoubtedly, certainly, and completely becomes flawlessly 'Liberated' and permanently freed forever (Mukto bhavati) from absolutely 'all terrifying sins' (Sarvapapebhyo) mercilessly accumulated over his millions of past lifetimes."
            "And (absolutely not just Moksha), but that magnificent seeker flawlessly and 100% successfully attains and fulfills (Avapnoti) absolutely 'all his auspicious worldly desires and wishes' (Sarvan kaman) right here while actively living on this earth."
            This is undeniably Sanatana Dharma's (Vedanta's) absolute greatest perfect Balance: it absolutely does not merely talk about some cheap 'Moksha' attained after physical death, it guarantees absolute 'Success' (Kaman) squarely in this very life!
            Exactly what is Sin? Sin is that terrifying toxic Virus that aggressively breeds exclusively in the pitch-darkness of deep ignorance.
            When the seeker profoundly meditates directly on Dakshinamurti (the blazing Sun of Wisdom), absolutely all those heavy sins (viruses) are violently burnt to absolute ashes in exactly one single second in that blazing fire of knowledge.
            And exactly when the human mind is flawlessly Cleaned and cleared entirely of all heavy sins and terrifying Tension, his brain actively functions exactly like a highly advanced Super-Computer with 100% razor-sharp Focus.
            Strictly due to that terrifying focus, whatever worldly action he actively performs (earning massive wealth, acquiring deep knowledge), he effortlessly achieves 100% absolute success (Kama-prapti) in it.
            Therefore, the profound study of this Upanishad flawlessly transforms the human directly into 'God' (Liberated) from the inside, and simultaneously into the undisputed 'King' (Highly Successful) of the physical world from the outside.
        """.trimIndent()
    ),
    DakshinamurtiShloka(
        id = 20,
        sanskrit = "स विदेहमुक्तिं प्राप्नोति स विदेहमुक्तिं प्राप्नोति इत्युपनिषत् । ॐ शान्तिः शान्तिः शान्तिः ॥ २० ॥",
        hindi = """
            (अंतिम समापन और परम मोक्ष): "इस प्रकार इस परम ज्ञान का जीवन भर अभ्यास करने के बाद, जब उस साधक के इस भौतिक शरीर का अंत होता है।"
            "तो वह साधक हमेशा के लिए उस परम 'विदेहमुक्ति' (शरीर-रहित पूर्ण मोक्ष / जन्म-मरण के चक्र से हमेशा के लिए आज़ादी) को प्राप्त कर लेता है (स विदेहमुक्तिं प्राप्नोति)।"
            (इस बात की 100% गारंटी और निश्चितता देने के लिए श्रुति इसे दोबारा दोहराती है): "हाँ! वह निश्चित रूप से विदेहमुक्ति को ही प्राप्त करता है!" (स विदेहमुक्तिं प्राप्नोति)।
            यहीं पर रहस्य और ज्ञान का यह अत्यंत महान खजाना 'दक्षिणामूर्ति उपनिषद' पूर्ण रूप से और अत्यंत शुभता के साथ संपन्न (इत्युपनिषत्) होता है।
            ॐ शांतिः शांतिः शांतिः! (भगवान करे कि हमारे शरीर, मन और असीम आत्मा में उस आदि-गुरु दक्षिणामूर्ति की परम और अखंड शांति हमेशा के लिए स्थापित हो)।
            'विदेहमुक्ति' (Videhamukti) का अर्थ कोई आत्महत्या करना या शरीर को नष्ट करना नहीं है!
            इसका असली अर्थ है कि जब इस शरीर की 'बैटरी' (प्रारब्ध कर्म) पूरी तरह से खत्म हो जाती है, तो आत्मा इस शरीर को छोड़कर किसी 'दूसरे' शरीर या योनि (कुत्ता, बिल्ली या इंसान) में वापस नहीं लौटती।
            वह आत्मा एक पानी की बूँद की तरह उस असीम और अनंत परब्रह्म (समंदर) में घुलकर हमेशा के लिए 'एक' हो जाती है।
            गुरु दक्षिणामूर्ति ने हमें उस 'मौन' (Silence) का रास्ता दिखाया है जो सारे शोर और सारे दुखों को खत्म कर देता है।
            जो इंसान इस ज्ञान को अपने दिल में 'सेव' (Save) कर लेता है, वह मृत्यु के डर को हैक (Hack) करके इसी जीवन में 100% अमर (Immortal) हो जाता है।
        """.trimIndent(),
        english = """
            (The Absolute Final Conclusion and Supreme Moksha): "Thus, exactly after relentlessly practicing this supreme cosmic wisdom for his entire life, precisely when the biological time of that seeker's gross physical body ultimately ends."
            "That magnificent seeker flawlessly and permanently attains that absolute supreme 'Videhamukti' (bodiless, ultimate absolute liberation / permanent freedom from the terrifying cycle of birth and death forever) (Sa videhamuktim prapnoti)."
            (Strictly to fiercely demonstrate absolute, flawless certainty and to provide a 100% Ironclad Guarantee, the Shruti violently repeats it twice): "Yes! He undoubtedly and certainly attains Videhamukti!" (Sa videhamuktim prapnoti).
            Right exactly here, this exceptionally highly mystical, sacred, and magnificent treasure of cosmic wisdom, the 'Dakshinamurti Upanishad', perfectly and auspiciously achieves absolute completion (Ityupanishat).
            OM Peace, Peace, Peace! (May the supreme, infinite, and unbroken peace of that Adi-Guru Dakshinamurti be permanently established within our physical body, restless mind, and immortal soul forever).
            'Videhamukti' absolutely does not mean committing cheap suicide or violently destroying the physical body!
            Its absolute true meaning is that exactly when the precise 'Battery' (Prarabdha Karma) of this specific physical body is 100% completely exhausted, the immortal Soul absolutely never, ever returns to any 'Other' physical body or womb (dog, cat, or human) again.
            That Soul, exactly like a tiny drop of water, effortlessly dissolves directly into that infinite, boundless Supreme Brahman (Ocean) and flawlessly becomes 'One' forever.
            Guru Dakshinamurti has profoundly shown us the exact, direct path of that 'Mauna' (Absolute Silence) which violently annihilates all worldly noise and absolutely all agonizing sorrows forever.
            That specific human who flawlessly 'Saves' this ultimate wisdom directly into his heart successfully Hacks the terrifying fear of death and effortlessly becomes 100% literally Immortal (Amrita) right in this very lifetime.
        """.trimIndent()
    )
)