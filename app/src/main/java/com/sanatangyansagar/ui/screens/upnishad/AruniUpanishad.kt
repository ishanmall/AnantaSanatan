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
data class AruniShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AruniUpanishadScreen() {
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
                if (shlokaNumber != null && shlokaNumber in 1..7) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-7)") },
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
            itemsIndexed(aruniShlokasList) { _, shloka ->
                AruniShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun AruniShlokaCard(shloka: AruniShloka) {
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

val aruniShlokasList: List<AruniShloka> = listOf(
    AruniShloka(
        id = 1,
        sanskrit = "ॐ आरुणिः प्रजापतिमुपससाद । तं होवाच केन भगवन् कर्माण्यशेषतो विसृजानीति । स होवाच प्रजापतिः । पुत्रान् भ्रातॄन् बन्धून् कलत्राणि शिखां यज्ञोपवीतं यागं सूत्रं स्वाध्यायं च भूर्भुवःस्वर्लोकं त्यजेत् ॥ १ ॥",
        hindi = """
            (आरुणि उपनिषद का आरंभ): एक बार महर्षि आरुणि ने भगवान प्रजापति (ब्रह्मा जी) के पास जाकर अत्यंत विनीत भाव से पूछा।
            "हे भगवन्! मैं किस उपाय से इन सभी सांसारिक कर्मों और बंधनों को पूरी तरह से (अशेषतः) त्याग सकता हूँ?"
            भगवान प्रजापति ने उत्तर दिया: "हे आरुणि! पूर्ण संन्यास लेने के लिए तुम्हें अपने पुत्रों, भाइयों, मित्रों और सभी रिश्तेदारों का त्याग करना होगा।"
            "तुम्हें अपने सिर की शिखा (चोटी) और गले के पवित्र यज्ञोपवीत (जनेऊ) का भी पूरी तरह से त्याग कर देना चाहिए।"
            "तुम्हें सभी प्रकार के यज्ञों, धार्मिक कर्मकांडों और शास्त्रों के बाहरी नियमों को भी पूरी तरह छोड़ देना चाहिए।"
            यह उपनिषद सनातन धर्म में 'पूर्ण संन्यास' (Absolute Renunciation) का सबसे कड़ा और सीधा नियम बताता है।
            लोग सोचते हैं कि केवल घर छोड़ देना संन्यास है, पर यहाँ ब्रह्मा जी कह रहे हैं कि इंसान को अपनी 'धार्मिक पहचान' (शिखा, जनेऊ) भी छोड़नी पड़ती है।
            जब तक इंसान कर्मकांड और सामाजिक नियमों में फँसा है, तब तक उसका 'मैं' (Ego) ज़िंदा रहता है।
            मोक्ष पाने के लिए केवल बुरे कर्म ही नहीं, बल्कि 'अच्छे कर्म' और धार्मिक पाखंडों को भी कूड़े में फेंकना पड़ता है।
            यहीं से एक 'परमहंस' योगी की वह महान यात्रा शुरू होती है जो सीधा उसे परब्रह्म से मिला देती है।
        """.trimIndent(),
        english = """
            (The beginning of Aruni Upanishad): Once, the great Sage Aruni approached Lord Prajapati (Brahma) and asked with absolute humility.
            "O Supreme Lord! By what exact means can I completely and flawlessly renounce (Asheshatah) absolutely all these worldly karmas and heavy bonds?"
            Lord Prajapati profoundly answered: "O Aruni! To successfully take absolute Sannyasa, you must ruthlessly abandon your sons, brothers, friends, and all relatives."
            "You must violently cut off and completely discard the Shikha (tuft of hair) on your head and the sacred Yajnopavita (thread) around your neck."
            "You must absolutely abandon all types of grand Yajnas (sacrifices), religious rituals, and external rules of the scriptures forever."
            This magnificent Upanishad explicitly prescribes the absolute strictest and most direct rule of 'Absolute Renunciation' in Sanatana Dharma.
            People foolishly assume merely leaving a physical house is Sannyasa, but Brahma fiercely declares a human must ruthlessly drop his 'Religious Identity' too.
            Exactly as long as a human remains trapped in complex rituals and social rules, his toxic 'I' (Ego) remains actively alive.
            To successfully attain Moksha, one absolutely must throw not only bad karmas, but even 'good karmas' and religious hypocrisy directly into the garbage.
            Exactly from here begins that supreme, ultimate journey of a 'Paramahamsa' Yogi that flawlessly merges him directly with the Supreme Brahman.
        """.trimIndent()
    ),
    AruniShloka(
        id = 2,
        sanskrit = "दण्डमाच्छादनं कौपीनं परिग्रहेत् । शेषं विसृजेत् शेषं विसृजेदिति । भूर्भुवःसुवर्महर्जनस्तपःसत्यं च अतलवितलसुतलतलातलरसातलमहातलपाताल ब्रह्माण्डं च विसृजेत् ॥ २ ॥",
        hindi = """
            (संन्यासी का वेश): "संन्यास ग्रहण करने के बाद, साधक को केवल एक 'दण्ड' (लकड़ी का डंडा), शरीर ढकने के लिए एक कपड़ा, और एक लंगोट (कौपीन) ही धारण करना चाहिए।"
            "इन तीन चीजों के अलावा, जीवन की बाकी सभी वस्तुओं का उसे पूरी तरह से त्याग (शेषं विसृजेत्) कर देना चाहिए।"
            "उसे सातों ऊपर के लोकों (भूः, भुवः, स्वः, महः, जनः, तपः, सत्यम्) और सातों पाताल लोकों (अतल, वितल, सुतल, तलातल, रसातल, महातल, पाताल) का भी मानसिक त्याग कर देना चाहिए।"
            "यहाँ तक कि उसे इस पूरे 'ब्रह्मांड' (Cosmos) से ही अपनी सारी आसक्ति और मोह को खत्म कर देना चाहिए।"
            यह श्लोक एक सच्चे संन्यासी (Monk) का 'मिनिमलिस्टिक' (Minimalistic) और सबसे आज़ाद लाइफस्टाइल (Lifestyle) तय कर रहा है।
            अवधूत के पास केवल एक डंडा (जो उसके मन के कंट्रोल का प्रतीक है) और शरीर ढकने भर का कपड़ा होता है।
            सबसे बड़ी बात यह है कि उसे केवल दुनिया के पैसों का नहीं, बल्कि 'स्वर्ग' (स्वः) और 'सत्यलोक' (ब्रह्मा का घर) का भी लालच छोड़ना पड़ता है।
            जो इंसान स्वर्ग जाने के लालच में पूजा करता है, वह वास्तव में संन्यासी नहीं, बल्कि एक 'व्यापारी' (Businessman) है।
            जब योगी इस पूरे ब्रह्मांड को ही अपने दिमाग से 'विसर्जित' (Delete) कर देता है, तो उसे डराने या ललचाने के लिए कुछ नहीं बचता।
            और जहाँ कोई लालच नहीं है, केवल वहीं पर 'मोक्ष' का फूल खिलता है।
        """.trimIndent(),
        english = """
            (The exact attire of the Sannyasi): "Immediately after taking absolute Sannyasa, the seeker must exclusively hold only a 'Danda' (wooden staff), a piece of cloth to cover the body, and a loincloth (Kaupina)."
            "Completely apart from these three essential items, he must ruthlessly abandon and totally discard (Visrijet) absolutely everything else in life."
            "He must aggressively and mentally renounce absolutely all the seven upper worlds (Bhuh, Bhuvah, Svah, Mahah, Janah, Tapah, Satyam) and the seven netherworlds (Atala, Vitala, Sutala, Talatala, Rasatala, Mahatala, Patala)."
            "He must brutally and permanently annihilate all his blind attachments and deep infatuations entirely from this massive 'Brahmanda' (Cosmos) itself."
            This spectacular verse flawlessly establishes the exceptionally 'Minimalistic' and absolute most liberated Lifestyle of a true, master Sannyasi.
            The Avadhuta physically possesses strictly only a staff (the absolute symbol of his mind-control) and barely enough cloth to simply cover his physical body.
            The absolute greatest fact is that he must ruthlessly abandon not merely the greed for worldly money, but the intense greed for 'Heaven' (Svah) and 'Satyaloka' (Brahma's realm) too.
            That human who blindly worships God strictly out of intense greed to reach heaven is absolutely no Sannyasi, but merely a cheap 'Businessman'.
            Exactly when the master Yogi flawlessly 'Deletes' (Visrijet) this entire colossal universe completely from his brain, absolutely nothing remains to terrify or tempt him.
            And exactly where absolutely zero greed exists, strictly and exclusively only there does the supreme flower of 'Moksha' beautifully bloom.
        """.trimIndent()
    ),
    AruniShloka(
        id = 3,
        sanskrit = "अग्निमान्तरं कुर्यात् । लौकिकमग्निं विसृजेत् । यदहरेव विरजेत्तदहरेव प्रव्रजेत् । वनाद्वा गृहाद्वा ब्रह्मचर्यादेव प्रव्रजेत् ॥ ३ ॥",
        hindi = """
            (संन्यास का समय): "संन्यासी को चाहिए कि वह बाहरी आग (यज्ञ की लौकिक अग्नि) को पूरी तरह से बुझाकर और छोड़कर (विसृजेत्), उस अग्नि को अपने 'भीतर' (आन्तरं / जठराग्नि या ज्ञान की अग्नि) स्थापित कर ले।"
            "जिस दिन (यदहरेव) भी मनुष्य के हृदय में इस संसार के प्रति पूर्ण 'वैराग्य' (मोह-भंग) जाग्रत हो जाए।"
            "उसे ठीक उसी दिन (तदहरेव) बिना एक पल की भी देरी किए, सब कुछ छोड़कर संन्यास (प्रव्रजेत्) ले लेना चाहिए।"
            "चाहे वह वानप्रस्थ (जंगल) में हो, चाहे वह गृहस्थ (घर) में हो, और चाहे वह ब्रह्मचर्य (छात्र जीवन) में ही क्यों न हो; उसे तुरंत संन्यास ले लेना चाहिए।"
            यह जाबाल उपनिषद का वही क्रांतिकारी नियम है जिसे आरुणि उपनिषद भी डंके की चोट पर समर्थन दे रहा है।
            समाज कहता है कि 60 साल की उम्र के बाद ही रिटायरमेंट (Retirement) और संन्यास लेना चाहिए; पर उपनिषद इस बेवकूफी को खारिज करता है!
            मोक्ष कोई 'एज-लिमिट' (Age limit) का मोहताज नहीं है; यह एक 'अंडरस्टैंडिंग' (Understanding / समझ) का विस्फोट है।
            अगर आपको 20 साल की उम्र में ही यह 'वैराग्य' आ गया कि दुनिया की सारी सफलता और पैसे अंततः मौत में राख हो जाएंगे, तो उसी दिन दुनिया को छोड़ दो!
            और बाहरी यज्ञ (आग जलाना) एक नाटक है; असली 'अग्नि' तो वो ज्ञान की आग है जो इंसान के सीने में धधकनी चाहिए।
            उसी आंतरिक अग्नि में इंसान को अपने 'अहंकार' और 'वासनाओं' को ज़िंदा जला देना चाहिए।
        """.trimIndent(),
        english = """
            (The precise time for Sannyasa): "The Sannyasi must completely extinguish and discard all external physical fires (sacrificial worldly fires / Laukikamagnim), and flawlessly establish that exact fire directly 'Inside' (Antaram / the blazing fire of wisdom) himself."
            "On whatever exact day (Yadahareva) intense, burning 'Vairagya' (Dispassion / total disillusionment from the world) flawlessly arises in a human's heart."
            "On that very exact same day (Tadahareva), completely without delaying even for a single split-second, he must ruthlessly abandon absolutely everything and immediately take Sannyasa (Pravrajet)."
            "Whether he is actively in Vanaprastha (forest), whether in Grihastha (married life), or whether exactly in Brahmacharya (celibate student life); he must violently renounce the world instantly."
            This is exactly that highly revolutionary rule of the Jabala Upanishad which the Aruni Upanishad is aggressively and boldly supporting here.
            Society dictates one must take Retirement and Sannyasa strictly after 60 years of age; but the Upanishad ruthlessly rejects this profound stupidity!
            Moksha is absolutely no pathetic slave to an arbitrary 'Age Limit'; it is a violent, sudden explosion of supreme 'Understanding'.
            If at the young age of 20 you profoundly realize that all worldly success and money will burn to ashes in death, ruthlessly drop the world that exact day!
            And lighting external physical fires (Yajnas) is mere drama; the actual, true 'Fire' is strictly that blazing fire of wisdom that must violently burn directly in the human chest.
            It is exactly into that internal fire that the human must ruthlessly and brutally burn his toxic 'Ego' and filthy 'Lusts' alive to absolute ashes.
        """.trimIndent()
    ),
    AruniShloka(
        id = 4,
        sanskrit = "उपवीतं शिखां चैव छित्त्वा सन्न्यस्य तदनन्तरम् । ज्ञानमेवोपवीतं तस्य । यस्त्विमं ज्ञानोपवीतं वेत्ति स ब्राह्मणः ॥ ४ ॥",
        hindi = """
            (ज्ञान ही असली जनेऊ है): "संन्यासी को अपने गले का 'यज्ञोपवीत' (जनेऊ) और सिर की 'शिखा' (चोटी) को पूरी तरह से काटकर (छित्त्वा) और त्याग कर ही संन्यास लेना चाहिए।"
            "बाहरी सूत (धागे) का जनेऊ केवल कर्मकांडियों के लिए है; परंतु परमहंस संन्यासी के लिए उसका साक्षात् 'ज्ञान' (Wisdom) ही उसका असली जनेऊ (उपवीतं) है।"
            "जो महान साधक इस 'ज्ञान रूपी जनेऊ' (ज्ञानोपवीतं) को अपने हृदय में यथार्थ रूप में धारण करता है और उसे जानता (वेत्ति) है।"
            "वास्तव में दुनिया में केवल और केवल वही व्यक्ति सच्चा 'ब्राह्मण' (ब्रह्म को जानने वाला ज्ञानी) कहलाने के योग्य है।"
            यह श्लोक बाहरी धर्म (Religion) और आंतरिक अध्यात्म (Spirituality) का सबसे बड़ा फर्क साफ कर देता है।
            लोग गले में धागा पहनकर और माथे पर तिलक लगाकर खुद को बहुत बड़ा धार्मिक (Brahmin) मान लेते हैं।
            पर उपनिषद कहता है कि जब तक तुम्हारे अंदर 'अहंकार' और 'वासना' है, तुम्हारे बाहरी धागों की भगवान के सामने कोई कीमत (Value) नहीं है!
            असली 'जनेऊ' कोई फैक्ट्री में बना धागा नहीं है; असली जनेऊ वो 'आत्मज्ञान' है कि "मैं यह शरीर नहीं, बल्कि परम चेतना हूँ।"
            जो योगी इस ज्ञान को 24 घंटे अपने दिमाग में 'पहन' कर रखता है, वही दुनिया का सबसे पवित्र और सबसे बड़ा 'ब्राह्मण' है।
            अवधूत संन्यासी दुनिया के दिखावे को लात मार देता है, क्योंकि उसे किसी इंसान से 'सर्टिफिकेट' (Certificate) नहीं चाहिए।
        """.trimIndent(),
        english = """
            (Wisdom is the actual Sacred Thread): "The Sannyasi must aggressively and violently cut off (Chhittva) and throw away his 'Yajnopavita' (sacred thread) and 'Shikha' (tuft of hair) permanently exactly before taking Sannyasa."
            "The external physical thread made of cotton is strictly for ritualistic fools; but for the supreme Paramahamsa Sannyasi, his direct 'Jnana' (Wisdom) itself is undeniably his real, actual sacred thread (Upavitam)."
            "That magnificent seeker who flawlessly wears and profoundly knows (Vetti) this exact 'Sacred Thread of Wisdom' (Jnanopavitam) directly inside his pure heart."
            "In absolute reality, strictly and exclusively only that specific person is worthy of being called a true 'Brahmin' (the supreme knower of Brahman) in the entire world."
            This spectacular verse violently and completely clears the massive difference strictly between external Religion and profound internal Spirituality.
            Ignorant people falsely assume they become exceptionally religious (Brahmins) merely by wearing a cheap cotton thread and violently painting their foreheads with Tilak.
            But the Upanishad fiercely declares that exactly as long as toxic 'Ego' and 'Lust' actively burn inside you, your external threads possess absolutely zero Value before God!
            The actual 'Sacred Thread' is absolutely no cheap string manufactured in a factory; the real thread is that exact Self-knowledge that "I am not this body, I am supreme consciousness."
            That master Yogi who actively 'Wears' this explosive wisdom 24 hours a day in his brain is undeniably the world's absolute purest and greatest 'Brahmin'.
            The Avadhuta Sannyasi ruthlessly kicks away the world's cheap show-off, strictly because he desperately needs absolutely zero 'Certificates' from any human.
        """.trimIndent()
    ),
    AruniShloka(
        id = 5,
        sanskrit = "त्रिदण्डं कमण्डलुं सन्न्यस्य पात्रीं जलपवित्रं शिखां यज्ञोपवीतं इत्येतत्सर्वं भूः स्वाहेति अप्सु जुहुयात् । वाग्दण्डो मनोदण्डः कर्मदण्ड इति त्रिदण्डः । यस्यैते नियता बुद्धौ स त्रिदण्डीति चोच्यते ॥ ५ ॥",
        hindi = """
            (त्रिदंडी संन्यासी का असली अर्थ): "संन्यासी को अपने पास बांस के तीन डंडे (त्रिदण्डं) और एक कमण्डलु रखना चाहिए। अपने भिक्षापात्र, जल छानने का कपड़ा, शिखा और जनेऊ—इन सबको 'भूः स्वाहा' कहकर जल (अप्सु) में प्रवाहित (जुहुयात्) कर देना चाहिए।"
            "परंतु त्रिदंडी का असली अर्थ लकड़ी के डंडे उठाना नहीं है! असली 'त्रिदण्ड' (तीन डंडे) हैं: 1. 'वाग्दण्ड' (अपनी वाणी/बोलने पर पूरा कंट्रोल), 2. 'मनोदण्ड' (अपने चंचल मन पर पूर्ण कंट्रोल)।"
            "और 3. 'कर्मदण्ड' (अपने शरीर और शारीरिक कर्मों पर 100% कंट्रोल)। यही असली त्रिदण्ड है।"
            "जिस योगी की बुद्धि (बुद्धौ) में ये तीनों दण्ड (कंट्रोल के नियम) हमेशा के लिए 'नियत' (फिक्स / Fixed) हो गए हैं।"
            "दुनिया में केवल उसी महान ज्ञानी को साक्षात् 'त्रिदण्डी' (Tridandi / तीन डंडे धारण करने वाला) संन्यासी कहा जाता है (चोच्यते)।"
            हिन्दू धर्म में संन्यासियों का एक वर्ग 'त्रिदण्डी' कहलाता है जो हमेशा अपने हाथ में तीन लकड़ियां बाँधकर चलते हैं।
            पर आरुणि उपनिषद इस 'प्रथा' (Custom) का असली 'साइकोलॉजिकल मीनिंग' (Psychological meaning) खोलकर रख देता है!
            लकड़ी के डंडे तो कोई भी मूर्ख हाथ में पकड़ सकता है; पर क्या वह अपनी जुबान (गंदी बातें/झूठ), अपने शरीर (वासना), और अपने दिमाग (लालच) को डंडे से पीटकर कंट्रोल कर सकता है?
            जब तक आपका मन, वचन और कर्म (Mind, Speech, Action) आपके 100% कंट्रोल में नहीं हैं, आपके हाथ का डंडा एक मज़ाक है।
            जो योगी इन तीनों चीजों को अपनी बुद्धि की ताकत से 24 घंटे बाँध कर रखता है, वही दुनिया का सबसे सच्चा और पावरफुल 'त्रिदण्डी' है।
        """.trimIndent(),
        english = """
            (The true meaning of a Tridandi Sannyasi): "The Sannyasi must physically carry exactly three bamboo sticks (Tridandam) and a water pot (Kamandalu). His begging bowl, water-filter cloth, tuft of hair, and sacred thread—all these he must ruthlessly sacrifice directly into the water (Apsu) chanting 'Bhuh Svaha'."
            "But the absolute real meaning of Tridandi is absolutely not carrying cheap wooden sticks! The actual 'Tridanda' (Three Staffs) are strictly: 1. 'Vagdanda' (100% absolute control over one's speech), 2. 'Manodanda' (flawless control over the restless mind)."
            "And 3. 'Karmadanda' (100% absolute control over the physical body and actions). This alone is the authentic Tridanda."
            "That master Yogi in whose intellect (Buddhau) these exact three staffs (rules of absolute control) are permanently and flawlessly 'Fixed' (Niyata) forever."
            "Strictly and exclusively only that magnificent sage is profoundly called (Chochyate) a direct 'Tridandi' (Bearer of the three staffs) Sannyasi in the entire world."
            In Hinduism, a highly specific sect of monks is officially called 'Tridandi', who perpetually walk physically carrying exactly three wooden sticks tied together.
            But the Aruni Upanishad ruthlessly exposes the actual, profound 'Psychological Meaning' directly hidden behind this physical Custom!
            Absolutely any ignorant fool can easily hold cheap wooden sticks in his hand; but can he possibly beat and strictly control his tongue (lies/abuse), his body (lust), and his brain (greed) with a stick?
            Exactly as long as your Mind, Speech, and Action absolutely fail to be 100% strictly under your flawless control, your physical wooden staff is merely a pathetic joke.
            That master Yogi who aggressively binds and locks all these three strictly using the terrifying raw power of his intellect 24 hours a day, is undeniably the world's truest and most powerful 'Tridandi'.
        """.trimIndent()
    ),
    AruniShloka(
        id = 6,
        sanskrit = "कामक्रोधलोभमोहमदमात्सर्यानि त्यक्त्वा त्रिदण्डं कमण्डलुं सन्न्यस्य भूमौ शयीत । भैक्ष्येण प्राणयात्रां कुर्यात् । परमहंसपरिव्राजकः ॥ ६ ॥",
        hindi = """
            (परमहंस का व्यवहार): "उस संन्यासी को अपने हृदय से काम (वासना), क्रोध (गुस्सा), लोभ (लालच), मोह (लगाव), मद (घमंड), और मात्सर्य (ईर्ष्या / Jealousy) को पूरी तरह से त्याग (त्यक्त्वा) देना चाहिए।"
            "उसे अपने तीनों डंडे और कमण्डलु को भी अंततः छोड़कर (सन्न्यस्य), किसी मखमली गद्दे पर नहीं, बल्कि हमेशा 'ज़मीन पर सोना' (भूमौ शयीत) चाहिए।"
            "उसे अपनी प्राणयात्रा (ज़िंदगी का सफर) केवल और केवल 'भिक्षा' (भीख माँगकर मिले हुए भोजन / भैक्ष्येण) के द्वारा ही पूरी करनी चाहिए (पैसे इकट्ठे नहीं करने चाहिए)।"
            "और उसे दुनिया के किसी भी नियम में फँसे बिना एक 'परमहंस परिव्राजक' (Wandering monk) की तरह आज़ाद घूमना चाहिए।"
            यह श्लोक 'परमहंस' बनने की सबसे कठिन और 'हार्डकोर' (Hardcore) ट्रेनिंग है!
            काम, क्रोध, लोभ, मोह, मद, और मत्सर—ये इंसान के दिमाग के 6 सबसे बड़े 'वायरस' (Viruses) हैं।
            जब तक ये वायरस दिमाग में हैं, इंसान का सॉफ्टवेयर (Software) हमेशा करप्ट (Corrupt) और दुखी रहेगा।
            अवधूत योगी इन 6 वायरसों को एंटी-वायरस (ज्ञान) से पूरी तरह डिलीट कर देता है।
            ज़मीन पर सोने का मतलब है कि उसने शरीर के सुख (Comfort) की भूख को 100% मार दिया है; और भिक्षा माँगने का मतलब है कि उसने 'कल क्या खाऊँगा' (Insecurity) की टेंशन को भगवान के भरोसे छोड़ दिया है।
            जो इंसान इस लेवल (Level) का सरेंडर (Surrender) कर देता है, वही दुनिया का असली राजा (परमहंस) बनकर आज़ाद (परिव्राजक) घूमता है।
        """.trimIndent(),
        english = """
            (The precise behavior of the Paramahamsa): "That supreme Sannyasi must aggressively and permanently abandon (Tyaktva) Kama (Lust), Krodha (Violent anger), Lobha (Greed), Moha (Blind attachment), Mada (Toxic pride), and Matsarya (Jealousy) entirely from his pure heart."
            "Ultimately discarding even his three wooden staffs and water pot (Sannyasya), he must absolutely never sleep on a soft mattress, but must perpetually 'Sleep directly on the bare ground' (Bhumau shayita)."
            "He must ruthlessly conduct his Pranayatra (the journey of physical life) strictly and exclusively entirely by 'Bhiksha' (begging for simple food / Bhaikshyena) (he must never accumulate cheap money)."
            "And he must actively roam completely free exactly like a 'Paramahamsa Parivrajaka' (Supreme wandering monk) completely without getting trapped in any worldly rule."
            This spectacular verse provides the absolute most terrifying and 'Hardcore' brutal training strictly designed to become a flawless 'Paramahamsa'!
            Lust, anger, greed, attachment, pride, and jealousy—these are exactly the 6 absolute biggest, most highly destructive 'Viruses' of the human brain.
            Exactly as long as these heavy viruses exist in the brain, the human's software will permanently remain terribly Corrupt and profoundly miserable.
            The Avadhuta Yogi ruthlessly and permanently Deletes all these 6 toxic viruses completely using the Anti-virus (Supreme Wisdom).
            Sleeping directly on the bare ground flawlessly means he has 100% permanently killed the desperate hunger for bodily Comfort; and begging explicitly means he has dumped the massive tension of 'What will I eat tomorrow' (Insecurity) entirely onto God.
            That specific human who flawlessly executes this exact terrifying Level of total Surrender, alone roams absolutely free (Parivrajaka) directly exactly as the world's absolute real King (Paramahamsa).
        """.trimIndent()
    ),
    AruniShloka(
        id = 7,
        sanskrit = "अहमेव परं ब्रह्म य एवं वेद स मुक्तो भवति स मुक्तो भवति इत्युपनिषत् । ॐ शान्तिः शान्तिः शान्तिः ॥ ७ ॥",
        hindi = """
            (फलश्रुति और परम सत्य): "वह योगी अंत में केवल इसी परम सत्य में स्थित हो जाता है: 'मैं स्वयं ही वह साक्षात् परब्रह्म हूँ' (अहमेव परं ब्रह्म)।"
            "जो कोई भी मुमुक्षु साधक इस परम ज्ञान (संन्यास के असली विज्ञान) को यथार्थ रूप में 'जान' (वेद / अनुभव कर) लेता है।"
            "वह मनुष्य निश्चित रूप से सभी बंधनों और दुखों से हमेशा के लिए पूरी तरह 'मुक्त' हो जाता है (स मुक्तो भवति)।"
            (इस बात की 100% गारंटी देने के लिए श्रुति इसे दोबारा दोहराती है): "हाँ! वह निश्चित रूप से हमेशा के लिए मुक्त ही हो जाता है!" (स मुक्तो भवति)।
            यहीं पर यह अत्यंत महान और पवित्र 'आरुणि उपनिषद' पूर्ण रूप से संपन्न (इत्युपनिषत्) होता है। ॐ शांतिः शांतिः शांतिः!
            पूरी संन्यास यात्रा का 'द एंड' (The End) और फाइनल रिजल्ट (Final result) बस यही एक लाइन है: 'अहमेव परं ब्रह्म' (मैं ही ब्रह्म हूँ)।
            इतनी भयंकर तपस्या (घर छोड़ना, धागे तोड़ना, ज़मीन पर सोना) केवल इसलिए की गई थी ताकि इंसान के अंदर का 'छोटा मैं' (Small Ego) भूख से मर जाए।
            जब वो छोटा 'मैं' मर जाता है, तो अंदर से वह असीम और अनंत 'विराट मैं' (परब्रह्म) प्रकट हो जाता है।
            जब इंसान खुद ही 100% भगवान बन गया, तो न उसे मौत डरा सकती है और न ही दुनिया का कोई दुःख उसे रुला सकता है।
            यही सनातन धर्म की वह सबसे आख़िरी और परम आज़ादी (मोक्ष) है जहाँ इंसान एक रोते हुए जीव से उठकर पूरे ब्रह्मांड का राजा बन जाता है।
        """.trimIndent(),
        english = """
            (Phala Shruti and the Absolute Truth): "That master Yogi ultimately perfectly anchors exclusively exactly in this Absolute Supreme Truth: 'I myself alone am the direct Supreme Brahman' (Ahameva param brahma)."
            "Whosoever sincere seeker truly 'Knows' and flawlessly experiences (Veda) this ultimate supreme wisdom (the actual, real science of Sannyasa) in absolute reality."
            "That specific human being undoubtedly, certainly, and completely becomes flawlessly 'Liberated' and freed from absolutely all bonds and agonizing sorrows forever (Sa mukto bhavati)."
            (Strictly to passionately provide a 100% Ironclad Guarantee, the Shruti violently repeats it twice): "Yes! He undoubtedly and certainly becomes flawlessly liberated forever!" (Sa mukto bhavati).
            Right exactly here, this exceptionally magnificent, supreme, and profoundly sacred 'Aruni Upanishad' perfectly and auspiciously achieves absolute completion (Ityupanishat). OM Peace, Peace, Peace!
            The absolute 'The End' and the final, ultimate result of the entire terrifying journey of Sannyasa is strictly and exclusively this one single line: 'Ahameva param brahma' (I myself am Brahman).
            This terrifyingly harsh penance (abandoning the physical house, violently breaking threads, sleeping on bare dirt) was rigorously executed strictly only so that the human's 'Small I' (Tiny Ego) violently starves to death.
            Exactly when that pathetic small 'I' permanently dies, that boundless, infinite, and colossal 'Universal I' (Supreme Brahman) flawlessly physically manifests from within.
            Exactly when the human himself has flawlessly and literally become 100% God, absolutely no death can ever possibly terrify him, nor can any worldly sorrow ever possibly make him cry.
            This is undeniably Sanatana Dharma's absolute final and ultimate Freedom (Moksha) where a human violently rises from being a crying, pathetic creature to flawlessly becoming the undisputed King of the entire cosmos.
        """.trimIndent()
    )
)