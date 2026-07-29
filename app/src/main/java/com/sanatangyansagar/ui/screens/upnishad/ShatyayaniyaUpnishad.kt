package com.sanatangyansagar.ui.screens.upnishad

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
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
data class ShatyayaniyaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShatyayaniyaUpanishadScreen() {
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
                // Scrolling dynamically to the matched shloka
                if (shlokaNumber != null && shlokaNumber in 1..shatyayaniyaShlokasList.size) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-24)") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { searchQuery = "" }) {
                        Icon(Icons.Default.Clear, contentDescription = "Clear Search")
                    }
                }
            },
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
            itemsIndexed(shatyayaniyaShlokasList) { _, shloka ->
                ShatyayaniyaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun ShatyayaniyaShlokaCard(shloka: ShatyayaniyaShloka) {
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

// Data List: Shlokas 1 to 10 of Shatyayaniya Upanishad
val shatyayaniyaShlokasList: List<ShatyayaniyaShloka> = listOf(
    ShatyayaniyaShloka(
        id = 1,
        sanskrit = "वेदान्तविज्ञानसुनिश्चितार्थाः संन्यासयोगाद् यतयः शुद्धसत्त्वाः ।\nते ब्रह्मलोकेषु परान्तकाले परामृताः परिमुच्यन्ति सर्वे ॥ १ ॥",
        hindi = """
            (संन्यास की सर्वोच्च घोषणा): जिन महान योगियों और संन्यासियों ने 'वेदांत' (उपनिषदों) के परम ज्ञान को गहराई से समझ लिया है, और जिनका मन उस सत्य पर पूरी तरह से निश्चित और अडिग हो चुका है (सुनिश्चितार्थाः)। 
            जिन्होंने सच्चे 'संन्यास योग' (सब कुछ त्याग देने की कला) के द्वारा अपने अंतःकरण (हृदय और मन) को 100% शुद्ध और पवित्र कर लिया है (शुद्धसत्त्वाः)। 
            ऐसे परम मुक्त संन्यासी इस भौतिक शरीर को छोड़ते समय (परान्तकाले), साक्षात् परब्रह्म (ब्रह्मलोक/ईश्वर की अवस्था) में हमेशा के लिए विलीन हो जाते हैं। 
            वे 'परामृताः' (परम अमर) बन जाते हैं और जन्म-मरण के इस भयानक और अंतहीन चक्र से पूरी तरह आज़ाद (परिमुच्यन्ति) हो जाते हैं। 
            शाट्यायनीय उपनिषद की यह पहली ही गर्जना स्पष्ट करती है कि मोक्ष केवल कर्मकांडों से नहीं मिलता; मोक्ष मिलता है वेदांत के उस कठोर ज्ञान से जो इंसान के अहंकार को काट देता है, और उस वैराग्य से जो दुनिया की हर चीज़ को राख के समान समझता है।
        """.trimIndent(),
        english = """
            (The supreme declaration of Renunciation): Those absolute great Yogis and Sannyasis who have profoundly and flawlessly completely realized the ultimate supreme wisdom of the 'Vedanta' (the Upanishads), and whose intellects are fiercely, permanently anchored in that Absolute Truth (Sunishchitarthah). 
            Those who have violently and completely purified their inner being (mind and heart) to exact 100% perfection strictly through the rigorous 'Yoga of Sannyasa' (the supreme art of absolute renunciation) (Shuddhasattvah). 
            Such ultimately liberated monks, exactly at the precise final moment of leaving this physical dirt-body (Parantakale), seamlessly and flawlessly merge entirely into the Supreme Brahman (the ultimate dimension of God). 
            They instantly become completely 'Paramritah' (absolutely immortal) and are violently, permanently liberated (Parimuchyanti) entirely from the terrifying, endless cycle of birth and death forever. 
            This opening roar of the Shatyayaniya Upanishad fiercely clarifies that Moksha is absolutely never attained purely through cheap empty rituals; Moksha is achieved strictly through that terrifying Vedantic wisdom that brutally slaughters the human ego, and that intense detachment which perceives every worldly object purely as worthless ash.
        """.trimIndent()
    ),
    ShatyayaniyaShloka(
        id = 2,
        sanskrit = "वाग्दण्डोऽथ मनोदण्डः कर्मदण्डस्तथैव च ।\nयस्यैते निहिता बुद्धौ त्रिदण्डीति स उच्यते ॥ २ ॥",
        hindi = """
            (सच्चा त्रिदंडी संन्यासी कौन है?): जो व्यक्ति अपनी 'वाणी' पर कठोर नियंत्रण रखता है (वाग्दण्ड), जो अपने भयंकर चंचल 'मन' को पूरी तरह अपने काबू में रखता है (मनोदण्ड), और जो अपने शरीर के 'कर्मों' (Physical Actions) पर पूर्ण संयम रखता है (कर्मदण्ड)। 
            जिस योगी ने इन तीनों प्रकार के 'दण्ड' (नियंत्रण/Control) को अपनी बुद्धि में पूरी तरह से स्थापित (निहिता बुद्धौ) कर लिया है, वास्तव में केवल उसी को सच्चा 'त्रिदण्डी संन्यासी' (Tri-dandi) कहा जाता है। 
            शाट्यायनीय उपनिषद बाहरी दिखावे पर सबसे भयानक प्रहार करता है! कुछ पाखंडी लोग अपने हाथ में लकड़ी के तीन डंडे (त्रिदण्ड) लेकर खुद को बहुत बड़ा संत समझते थे। 
            उपनिषद कहता है कि हाथ में पकड़ी हुई लकड़ी इंसान का घमंड और लालच नहीं तोड़ सकती। असली 'डंडा' वह है जो इंसान अपनी खुद की जीभ (झूठ/गाली रोकने के लिए), अपने विचारों (वासना रोकने के लिए) और अपने शरीर (पाप रोकने के लिए) पर मारता है। 
            जिसने इन तीन चीजों को जीत लिया, वह बिना किसी बाहरी वेष-भूषा के भी साक्षात् नारायण (भगवान) का रूप बन जाता है।
        """.trimIndent(),
        english = """
            (Who is the authentic Tridandi monk?): That absolute master who exercises terrifying, iron-clad control strictly over his 'Speech' (Vagdanda), who violently and completely subjugates his wildly restless 'Mind' (Manodanda), and who maintains perfect, flawless restraint over his bodily 'Actions' (Karmadanda). 
            That supreme Yogi who has flawlessly, permanently established exactly these three specific forms of 'Danda' (Staff of Control) entirely deep within his own intellect (Nihita buddhau), he, and strictly he alone, is genuinely called a true 'Tridandi Sannyasi' (The bearer of the three staffs). 
            The Shatyayaniya Upanishad launches the absolute most terrifying physical strike against empty external hypocrisy! Highly ignorant fake monks foolishly carried three physical wooden sticks (Tridanda) in their hands, arrogantly declaring themselves as great saints. 
            The Upanishad fiercely roars that a dead wooden stick in your hand can absolutely never crush your blinding ego or toxic greed. The real, authentic 'Staff' is exactly the one a human violently uses to relentlessly beat his own tongue (blocking lies), his own thoughts (crushing lust), and his own physical body (preventing sin). 
            Whoever completely conquers these three instantly becomes the exact, direct embodiment of Lord Narayana, completely regardless of any external physical robes.
        """.trimIndent()
    ),
    ShatyayaniyaShloka(
        id = 3,
        sanskrit = "न कर्माण्यत्यजन् योगी वेदान्तं श्रोतुमर्हति ।\nतस्मात्सर्वप्रयत्नेन त्यजेत्कर्म सवासनाम् ॥ ३ ॥",
        hindi = """
            (कर्मों के त्याग का कठोर नियम): जो व्यक्ति अपने सांसारिक कर्मों (धन कमाना, यश पाना, बाहरी अनुष्ठान) का पूरी तरह से त्याग नहीं करता, वह योगी 'वेदांत' (परम ज्ञान) को सुनने का अधिकारी भी नहीं है (न श्रोतुमर्हति)। 
            इसलिए, आत्मज्ञान चाहने वाले सच्चे साधक को चाहिए कि वह अपनी पूरी ताकत और भयंकर प्रयत्नों (सर्वप्रयत्नेन) से, अपनी वासनाओं और इच्छाओं (सवासनाम्) सहित सारे सकाम कर्मों को उखाड़ कर फेंक दे! 
            यह श्लोक सनातन धर्म का एक बहुत ही कड़क (Strict) नियम बताता है। जब तक आपके मन में यह इच्छा बची है कि "मुझे पैसा, प्रमोशन और दुनिया में इज्जत मिल जाए", तब तक आप चाहे कितने भी उपनिषद पढ़ लें, वह ज्ञान आपके अंदर नहीं टिकेगा। 
            एक भरा हुआ कप और ज्यादा चाय नहीं सोख सकता। उसी तरह वासनाओं (Desires) से भरा हुआ दिमाग भगवान के ज्ञान को कभी नहीं पकड़ सकता। 
            उपनिषद आदेश देता है कि अगर तुम्हें सच में मोक्ष चाहिए, तो दुनिया की आधी-अधूरी चीजों से चिपकना छोड़ो, और एक झटके में उस वासना को जड़ से उखाड़ दो।
        """.trimIndent(),
        english = """
            (The terrifyingly strict rule of abandoning actions): That individual who absolutely does not completely violently abandon his worldly, desire-driven actions (chasing money, superficial fame, and external rituals) is completely unfit and entirely lacks the authority even to 'hear' the supreme wisdom of Vedanta (Na shrotumarhati). 
            Therefore, a true seeker aggressively pursuing Self-realization must relentlessly, with his absolute total might and terrifying supreme effort (Sarvaprayatnena), ruthlessly uproot and completely abandon all self-centered actions along with all their deeply hidden toxic desires (Savasanam)! 
            This explosive verse lays down an exceptionally strict and unyielding law of Sanatana Dharma. As long as the toxic desire secretly remains in your mind screaming "I desperately want money, promotions, and cheap worldly respect," absolutely no matter how many heavy Upanishads you aggressively read, that pure wisdom will strictly never survive inside you. 
            A cup that is already entirely violently overflowing can absolutely not absorb a single drop of new tea. Similarly, a brain violently poisoned with worldly desires (Vasanas) can strictly never grasp the pure consciousness of God. 
            The Upanishad fiercely commands that if you genuinely desire ultimate Moksha, you must ruthlessly violently kick away your pathetic clinging to temporary worldly trash and entirely uproot that lust in one single terrifying stroke.
        """.trimIndent()
    ),
    ShatyayaniyaShloka(
        id = 4,
        sanskrit = "अतितीव्रविरक्तः सन् संन्यसेत् विधिपूर्वकम् ।\nआत्मानं च परं ब्रह्म ध्यायेदनन्यमानसः ॥ ४ ॥",
        hindi = """
            (तीव्र वैराग्य और संन्यास): जब किसी मनुष्य के हृदय में संसार के प्रति 'अति तीव्र' (भयंकर और चरम) वैराग्य (विरक्तः सन्) पैदा हो जाए—यानी जब उसे दुनिया का हर सुख जहर लगने लगे, 
            तभी उसे शास्त्रों के सही नियमों के अनुसार सब कुछ छोड़कर 'संन्यास' (संन्यसेत् विधिपूर्वकम्) ले लेना चाहिए। 
            संन्यास लेने के बाद उस योगी का एकमात्र काम यह होता है कि वह बिना किसी दूसरे विचार के, अपने मन को पूरी तरह एकाग्र करके (अनन्यमानसः), अपनी ही आत्मा को साक्षात् 'परम ब्रह्म' (भगवान) मानकर उसका दिन-रात ध्यान (ध्यायेत्) करे। 
            यहाँ 'अति तीव्र वैराग्य' शब्द बहुत महत्वपूर्ण है। श्मशान में जाकर या किसी के मरने पर जो वैराग्य आता है, वह दो दिन में खत्म हो जाता है; उपनिषद उसे वैराग्य नहीं मानता। 
            सच्चा वैराग्य एक भयंकर आग की तरह है जो इंसान के अंदर तब लगती है जब उसे यह समझ आ जाता है कि यह पूरा यूनिवर्स एक धोखा (Illusion) है। 
            और एक बार संन्यास लेने के बाद, उसे भगवान को किसी मंदिर में नहीं ढूँढना है, बल्कि अपनी ही आत्मा को साक्षात् ईश्वर मानकर उसी में डूब जाना है।
        """.trimIndent(),
        english = """
            (Intense detachment and Sannyasa): Exactly when an 'Ati Tivra' (exceptionally violent, extreme, and terrifying) state of Vairagya (utter detachment and dispassion) fiercely erupts in a human's heart—meaning when literally every worldly pleasure vividly appears as lethal toxic poison to him, 
            Only exactly then must he ruthlessly abandon absolutely everything and formally embrace 'Sannyasa' (absolute renunciation) strictly according to the flawless scriptural injunctions (Sannyaset vidhipurvakam). 
            After taking this massive leap, the absolute exclusive duty of that supreme Yogi is to intensely, relentlessly meditate (Dhyayet) strictly upon his own pure Soul directly as the absolute 'Supreme Brahman' (God), with a perfectly one-pointed mind entirely free from even a single distracting thought (Ananyamanasah). 
            The exact phrase 'Ati Tivra Vairagya' is explosively crucial here. The cheap, temporary detachment one feels at a funeral graveyard completely vaporizes in two days; the Upanishad absolutely rejects that as fake. 
            True authentic Vairagya is exactly like a terrifying blazing inner fire that violently erupts when a human profoundly realizes that this entire physical universe is a massive, pathetic cosmic Illusion. 
            And strictly post-renunciation, he must absolutely never search for God in external stone temples; he must ruthlessly dive inside and meditate entirely upon his own Soul as the absolute direct manifestation of God.
        """.trimIndent()
    ),
    ShatyayaniyaShloka(
        id = 5,
        sanskrit = "न निन्दां न स्तुतिं कुर्यान्न वन्देत् कञ्चिदेव हि ।\nभिक्षाटनं चरेन्नित्यं देहयात्रार्थमेव च ॥ ५ ॥",
        hindi = """
            (संन्यासी का कठोर आचरण): एक सच्चे संन्यासी को कभी भी किसी दूसरे इंसान की 'निंदा' (बुराई/Criticism) नहीं करनी चाहिए, और न ही किसी की 'स्तुति' (झूठी तारीफ/Flattery) करनी चाहिए। 
            उसे दुनिया में किसी को भी झुककर प्रणाम (न वन्देत् कञ्चिदेव हि) नहीं करना चाहिए (क्योंकि उसके लिए सब कुछ ब्रह्म है, न कोई बड़ा है न छोटा)। 
            उसे केवल अपने इस भौतिक शरीर को जिंदा रखने के लिए (देहयात्रार्थमेव च), बिना किसी लालच के, हर दिन भिक्षा (Bhiksha) मांगनी चाहिए और उसी पर गुजारा करना चाहिए। 
            यह श्लोक एक जीवनमुक्त इंसान के 'ईगो-लेस' (Ego-less / अहंकार रहित) जीवन का सबसे बड़ा नक्शा है। समाज में लोग दो ही काम करते हैं—या तो दूसरों की बुराई करते हैं (ईर्ष्या में) या चापलूसी करते हैं (स्वार्थ में)। 
            लेकिन संन्यासी इन दोनों बीमारियों से मुक्त होता है। वह किसी राजा या अमीर को प्रणाम नहीं करता, क्योंकि उसकी नज़र में राजा और भिखारी दोनों के अंदर एक ही भगवान है। 
            वह भिक्षा इसलिए नहीं मांगता कि वह गरीब है; वह भिक्षा इसलिए मांगता है ताकि उसका 'अहंकार' पूरी तरह से कुचला जा सके।
        """.trimIndent(),
        english = """
            (The terrifyingly strict conduct of a monk): A true supreme Sannyasi must absolutely never, ever engage in the 'Ninda' (toxic criticism/insulting) of any other human being, nor must he ever engage in 'Stuti' (cheap flattery/praise) of anyone. 
            He must completely and strictly refuse to bow down in physical reverence (Na vandet kanchideva hi) to absolutely anyone in this entire world (strictly because for him, everything is entirely Brahman; absolutely no one is superior or inferior). 
            He must relentlessly wander entirely and exclusively for daily alms (Bhiksha) strictly and solely for the absolute bare minimum maintenance of his physical dirt-body (Dehayatrarthameva cha), completely devoid of even a microscopic drop of greed. 
            This magnificent verse serves as the absolute ultimate blueprint for the flawlessly 'Ego-less' existence of a completely liberated master. Ignorant people in society blindly do exactly two things: they toxically criticize others (out of sheer jealousy) or they shamelessly flatter (out of cheap selfish gain). 
            The supreme monk is permanently flawlessly immune to both these terrifying diseases. He fiercely refuses to bow to any arrogant king or billionaire, because his divine vision strictly sees the exact identical God inside both the arrogant king and the starving beggar. 
            He absolutely does not beg because he is poor; he aggressively begs exclusively to ruthlessly and permanently crush his own human 'Ego' entirely to absolute ash.
        """.trimIndent()
    ),
    ShatyayaniyaShloka(
        id = 6,
        sanskrit = "सर्वाणि भूतानि पश्यन् भगवन्मयान्येव ।\nसुखदुःखेषु समः शान्तो निराशीर्गतमत्सरः ॥ ६ ॥",
        hindi = """
            (समभाव और शांति): उस महान संन्यासी को संसार के सभी छोटे-बड़े प्राणियों (सर्वाणि भूतानि) को साक्षात् 'भगवान का ही रूप' (भगवन्मयान्येव) मानकर देखना चाहिए। 
            उसे जीवन में आने वाले भयंकर दुखों और बड़े-बड़े सुखों में बिल्कुल 'समान' (समः / Balanced) रहना चाहिए। 
            उसे अंदर से पूरी तरह शांत (शान्तो), हर प्रकार की सांसारिक इच्छाओं और उम्मीदों से पूरी तरह मुक्त (निराशीः), और हर तरह की ईर्ष्या व जलन (गतमत्सरः) से आज़ाद होना चाहिए। 
            यह श्लोक 'समत्वं योग उच्यते' (गीता) का ही संन्यासी रूप है। जब कोई इंसान सब जगह केवल भगवान को देखने लगता है, तो वह किसी से नफरत कैसे कर सकता है? 
            अगर उसे आज बहुत स्वादिष्ट खाना मिला, तो वह उछलता नहीं है, और अगर आज उसे भूखा सोना पड़ा या किसी ने गाली दी, तो वह रोता नहीं है। सुख और दुख दोनों उसके लिए केवल 'मौसम' (Weather) की तरह हैं जो आते हैं और चले जाते हैं। 
            उसकी असली शांति किसी बाहरी चीज पर निर्भर नहीं करती, बल्कि वह शांति उसके अंदर से झरने की तरह बहती है।
        """.trimIndent(),
        english = """
            (Equanimity and absolute peace): That supreme monk must continuously and flawlessly perceive absolutely all living entities (Sarvani bhutani)—without a single exception—strictly and directly as the literal, explicit embodiments of the Supreme Lord Himself (Bhagavanmayanyeva). 
            He must remain flawlessly, terrifyingly 'Balanced' and entirely unaffected (Samah) directly amidst the most crushing miseries and the most exhilarating worldly pleasures alike. 
            He must be profoundly, internally absolutely tranquil (Shanto), entirely permanently liberated from absolutely all toxic worldly desires and psychological expectations (Nirashih), and violently freed from even a microscopic trace of jealousy and toxic envy (Gatamatsarah). 
            This phenomenal verse is strictly the Sannyasa equivalent of the Gita's supreme law of 'Samatvam' (Equanimity). Exactly when a human being flawlessly begins seeing absolutely nothing but God everywhere, how can he possibly ever generate hatred? 
            If he receives a lavish, delicious feast today, he absolutely does not jump in foolish joy, and if he is violently forced to sleep starving or is brutally insulted, he absolutely does not weep. Extreme pleasure and terrifying pain are strictly perceived purely as temporary 'Weather' conditions that meaninglessly come and go. 
            His absolute profound peace is strictly completely independent of all external physical circumstances; that infinite peace aggressively erupts exactly like a roaring waterfall entirely from within his own Soul.
        """.trimIndent()
    ),
    ShatyayaniyaShloka(
        id = 7,
        sanskrit = "न वर्णाश्रमधर्मांश्च न गणांश्च न मङ्गलम् ।\nसर्वं विसृज्य वै योगी स्वात्मन्येव वसेत् सदा ॥ ७ ॥",
        hindi = """
            (जाति और समाज के नियमों का त्याग): एक सच्चा योगी समाज द्वारा बनाए गए सभी 'वर्णों' (ब्राह्मण, क्षत्रिय आदि जातियों) और 'आश्रमों' (ब्रह्मचर्य, गृहस्थ आदि) के नियमों को पूरी तरह पीछे छोड़ देता है। 
            वह किसी समूह (गणांश्च) या समाज की झूठी परवाह नहीं करता, और दुनिया की नज़र में जो 'शुभ या मङ्गल' (Rituals/Good Omens) माना जाता है, उसे भी छोड़ देता है। 
            इन सब झूठे बंधनों और लेबल्स (Labels) को हमेशा के लिए त्याग कर (सर्वं विसृज्य), वह महान योगी 24 घंटे केवल और केवल अपनी 'आत्मा' (स्वात्मन्येव) के भीतर ही निवास (वसेत्) करता है। 
            शाट्यायनीय उपनिषद यहाँ जातिवाद (Casteism) और धार्मिक कर्मकांडों की धज्जियां उड़ा रहा है! जब तक इंसान खुद को 'मैं ब्राह्मण हूँ', 'मैं क्षत्रिय हूँ' या 'मैं बड़ा अफसर हूँ' मानता है, तब तक वह घमंड का गुलाम है। 
            ईश्वर की कोई जाति नहीं होती। जब योगी आत्मज्ञान पा लेता है, तो समाज के बनाए सारे नियम, शुभ-अशुभ के अंधविश्वास और झूठी इज्जत उसके लिए कूड़े के समान हो जाते हैं। 
            वह दुनिया के ड्रामे (Drama) से बाहर निकलकर अपनी चेतना के उस महल में जाकर बैठ जाता है, जहाँ से कभी कोई दुख उसे छू नहीं सकता।
        """.trimIndent(),
        english = """
            (The absolute rejection of caste and societal rules): A true supreme Yogi ruthlessly and entirely abandons absolutely all rigid rules of 'Varna' (caste divisions like Brahmin, Kshatriya, etc.) and 'Ashrama' (life stages) artificially fabricated by human society. 
            He completely ceases to care even slightly about pleasing any specific social group or mob (Ganamscha), and he aggressively discards all fake, empty rituals and blind superstitions regarding what the world considers 'Auspicious or Good Omens' (Mangalam). 
            Having violently, permanently discarded exactly all these fake, suffocating chains and hypocritical societal labels (Sarvam visrijya), that supreme master flawlessly and continuously resides (Vaset) purely and exclusively strictly within his own pure 'Soul' (Svatmanyeva) 24 hours a day. 
            The Shatyayaniya Upanishad fiercely violently shreds Casteism and entirely empty religious external rituals to absolute pieces right here! As long as a human blindly and arrogantly identifies as "I am a superior Brahmin" or "I am a rich officer," he remains a pathetic chained slave to toxic ego. 
            The Supreme God absolutely possesses no physical caste. Exactly when the master attains Self-realization, all man-made societal rules, completely blind superstitions of good/bad luck, and fake social prestige instantly become entirely equivalent to filthy garbage for him. 
            He ruthlessly exits the fake physical Drama of society and permanently seats himself fiercely in the indestructible fortress of his own pure Consciousness, where absolutely no worldly suffering can ever possibly touch him.
        """.trimIndent()
    ),
    ShatyayaniyaShloka(
        id = 8,
        sanskrit = "उन्मत्तबालवद्गच्छेत् सर्वत्रासङ्गमानसः ।\nअपमानं पुरस्कृत्य मानापमानयोः समः ॥ ८ ॥",
        hindi = """
            (परमहंस योगी का व्यवहार): वह सर्वोच्च योगी इस दुनिया में बिल्कुल एक 'पागल इंसान' (उन्मत्त) या एक छोटे और मासूम 'बच्चे' (बालवद्) की तरह स्वतंत्र होकर विचरण करता है। 
            उसका मन दुनिया की किसी भी वस्तु, व्यक्ति या स्थान में जरा सा भी फँसा (आसक्त) नहीं होता (सर्वत्रासङ्गमानसः)। 
            वह दुनिया वालों से मिलने वाले भारी 'अपमान' (Insult) को एक पुरस्कार (पुरस्कृत्य) की तरह खुशी-खुशी स्वीकार करता है, क्योंकि वह मान (इज्जत) और अपमान (बेइज्जती) दोनों में पूरी तरह से 'समान' (समः) रहता है। 
            यह श्लोक सनातन धर्म के सबसे गहरे मनोविज्ञान (Psychology) को उजागर करता है। दुनिया के सारे दुख 'इज्जत' (Ego/Respect) बचाने के चक्कर में पैदा होते हैं। 
            परमहंस योगी को पता है कि जो शरीर एक दिन मिट्टी बन जाएगा, उसकी क्या इज्जत और क्या बेइज्जती? अगर कोई उसे गाली देता है, तो उसका अहंकार टूटता है, इसीलिए वह अपमान को भगवान का 'प्रसाद' मानता है। 
            वह बच्चों की तरह आज़ाद और मस्त रहता है, क्योंकि उसने समाज की 'मुझे अच्छा दिखना है' वाली झूठी दौड़ को हमेशा के लिए लात मार दी है।
        """.trimIndent(),
        english = """
            (The terrifyingly liberating behavior of a Paramahamsa): That absolute supreme Yogi roams completely freely and wildly in this entire world exactly like a completely 'Madman' (Unmatta) or an entirely innocent, carefree 'Child' (Balavad). 
            His deeply purified mind remains fiercely and permanently absolutely unattached and utterly untangled (Sarvatrasangamanasah) from absolutely every single object, person, or physical place in existence. 
            He actively, joyously embraces massive public 'Insults' and heavy humiliation exactly as if receiving a supreme, grand Award (Puraskritya), strictly because he remains flawlessly and terrifyingly 'Equal and unaffected' (Samah) identically amidst massive public respect (Mana) and brutal degradation (Apamana). 
            This explosive verse violently exposes the absolute deepest, most supreme Psychology of Sanatana Dharma. Literally all worldly psychological suffering is entirely generated strictly through the pathetic obsession with defending one's fake 'Ego and Respect'. 
            The grand Paramahamsa master profoundly knows that defending the fake dignity of a dirt-body destined to instantly become ash is utter foolishness. When someone brutally insults him, it violently crushes the ego further; thus, he actually celebrates the insult as God's direct divine 'Prasad' (gift). 
            He remains permanently wildly free and intoxicated exactly like a small child, purely because he has violently kicked away and completely abandoned society's toxic, fake rat-race of "I must look good to others" forever.
        """.trimIndent()
    ),
    ShatyayaniyaShloka(
        id = 9,
        sanskrit = "हृत्पुण्डरीकमध्यस्थं वासुदेवं सनातनम् ।\nध्यायन् मुच्येत बन्धेभ्यो नात्र कार्या विचारणा ॥ ९ ॥",
        hindi = """
            (हृदय में वासुदेव का ध्यान): जो संन्यासी अपने हृदय रूपी पवित्र 'कमल' के बिल्कुल बीचों-बीच (हृत्पुण्डरीकमध्यस्थं) बैठे हुए साक्षात् सनातन और परमेश्वर 'भगवान वासुदेव' (नारायण/विष्णु) का निरंतर ध्यान करता है; 
            वह योगी संसार और कर्मों के सभी भयंकर बंधनों (बन्धेभ्यो) से निश्चित रूप से हमेशा के लिए मुक्त (मुच्येत) हो जाता है। इसमें जरा सा भी संदेह या विचार (नात्र कार्या विचारणा) करने की कोई आवश्यकता नहीं है! 
            शाट्यायनीय उपनिषद विशेष रूप से भगवान विष्णु (वासुदेव) की भक्ति और अद्वैत ज्ञान का बहुत ही सुंदर मिश्रण है। 
            यह श्लोक बताता है कि भगवान कहीं सातवें आसमान पर नहीं बैठे हैं। तुम्हारा अपना हृदय (Heart) ही वह असली मंदिर (कमल) है, जहाँ वह परम चेतना 'वासुदेव' के रूप में हमेशा धड़क रही है। 
            जब साधक बाहर की दुनिया से आंखें बंद करके अपने ही हृदय में उस परम शक्ति पर फोकस (Focus) करता है, तो उसके सारे पाप, अज्ञान और मौत का डर एक सेकंड में कट जाते हैं। यह कोई थ्योरी नहीं है, यह एक 100% गारंटीड (Guaranteed) विज्ञान है!
        """.trimIndent(),
        english = """
            (Meditation on Lord Vasudeva exactly within the heart): That supreme monk who relentlessly and fiercely meditates strictly upon the eternal, absolute Supreme Lord 'Vasudeva' (Narayana/Vishnu), who is permanently seated exactly in the very absolute center of the pure, sacred 'Lotus of his own Heart' (Hritpundarikamadhyastham); 
            That exact Yogi undeniably, completely, and permanently becomes entirely liberated (Muchyeta) directly from all terrifying, suffocating chains and worldly bondages (Bandhebhyo). There is absolutely zero room for even a microscopic drop of doubt or hesitation regarding this absolute truth (Natra karya vicharana)! 
            The Shatyayaniya Upanishad exceptionally and flawlessly executes an incredibly beautiful fusion strictly between the intense supreme devotion to Lord Vishnu (Vasudeva) and the terrifyingly sharp wisdom of non-dual Advaita. 
            This magnificent verse fiercely clarifies that God is absolutely not sitting on some imaginary clouds in the seventh heaven. Your very own physical Heart is undeniably the exact real Temple (Lotus), where that infinite pure consciousness is permanently aggressively pulsing explicitly as 'Vasudeva'. 
            Exactly when the seeker violently shuts his eyes to the external physical garbage and aggressively focuses entirely on that Supreme Energy within his own chest, absolutely all his sins, deep ignorance, and the terrifying fear of death are brutally slaughtered in a single split-second. This is absolutely no empty theory; it is a 100% Guaranteed cosmic spiritual science!
        """.trimIndent()
    ),
    ShatyayaniyaShloka(
        id = 10,
        sanskrit = "तमेव विद्वानमृत इह भवति नान्यः पन्था विद्यतेऽयनाय ।\nइत्युपनिषत् ॥ १० ॥",
        hindi = """
            (परम सत्य की प्राप्ति और उपनिषद का निष्कर्ष): केवल और केवल उस परम परमात्मा (आत्मतत्त्व) को गहराई से जान लेने (विद्वान) के बाद ही, मनुष्य इसी जन्म में, इसी धरती पर 'अमर' (अमृत इह भवति) हो जाता है। 
            संसार के जन्म-मरण के इस भयानक चक्र से बाहर निकलने के लिए (अयनाय), पूरी दुनिया में इसके अलावा और 'कोई दूसरा रास्ता मौजूद ही नहीं है' (नान्यः पन्था विद्यते)। यही इस महान उपनिषद का अंतिम रहस्य और निष्कर्ष है (इत्युपनिषत्)। 
            यह शाट्यायनीय उपनिषद के इन 10 श्लोकों का सबसे शक्तिशाली 'मास्टर-स्ट्रोक' है! सनातन धर्म साफ कहता है कि अमरता (Immortality) मरने के बाद स्वर्ग जाने का नाम नहीं है। 
            अमरता का मतलब है जीते जी (इह भवति) यह 100% जान लेना कि "मैं शरीर नहीं, बल्कि वह ऊर्जा हूँ जिसे कोई तलवार काट नहीं सकती।" 
            चाहे तुम कितने भी यज्ञ कर लो, कितने भी दान कर लो या कितने भी मंत्र पढ़ लो, जब तक तुम्हारे अंदर 'आत्मज्ञान' (Self-realization) का विस्फोट नहीं होगा, तब तक तुम्हारी मुक्ति असंभव है। ज्ञान ही एकमात्र चाबी है, कोई शॉर्टकट (Shortcut) नहीं है! ॐ शांति!
        """.trimIndent(),
        english = """
            (The ultimate realization and the conclusion of the Upanishad): Solely, entirely, and exclusively by profoundly realizing (Vidvan) exactly that Absolute Supreme Lord (The Pure Self), a human effortlessly and irreversibly becomes completely 'Immortal' exactly here and now in this very life (Amrita iha bhavati). 
            To successfully completely escape and cross beyond (Ayanaya) this terrifying, suffocating, endless cycle of birth and death, there is absolutely, undeniably 'No other path entirely existing' anywhere in this infinite cosmos (Nanyah pantha vidyate). This exactly is the supreme, absolute ultimate secret and final conclusion of this grand Upanishad (Ityupanishat). 
            This forms the absolute most explosive, violent 'Master-stroke' of these first 10 verses of the Shatyayaniya Upanishad! Sanatana Dharma fiercely and aggressively declares that ultimate Immortality is absolutely not a cheap ticket to a physical heaven after death. 
            Immortality profoundly means fully realizing exactly while actively living (Iha bhavati) with 100% terrifying conviction: "I am absolutely not this rotting physical flesh, but rather that pure indestructible cosmic energy which no physical sword can ever possibly scratch." 
            Absolutely no matter how many grand rituals you perform, how much massive charity you blindly donate, or how many heavy mantras you physically chant, unless the massive atomic explosion of direct 'Self-realization' occurs violently inside you, your liberation remains permanently impossible. Supreme Wisdom is the absolute only single key; there are strictly zero shortcuts! OM Peace!
        """.trimIndent()
    ),
    ShatyayaniyaShloka(
        id = 11,
        sanskrit = "ज्ञानशिखी ज्ञाननिष्ठो ज्ञानयज्ञोपवीतवान् ।\nशिखा ज्ञानमयी यस्य उपवीतं च तन्मयम् ॥ ११ ॥",
        hindi = """
            (ज्ञान ही असली शिखा और जनेऊ है): जो महान संन्यासी केवल 'ज्ञान' (Supreme Wisdom) को ही अपनी असली शिखा (सिर की चोटी) मानता है, जो 24 घंटे केवल आत्मज्ञान में ही पूरी तरह निष्ठावान (ज्ञाननिष्ठो) रहता है, 
            और जिसने केवल साक्षात् 'ज्ञान' को ही अपना सच्चा यज्ञोपवीत (जनेऊ/Sacred Thread) बना लिया है; वास्तव में वही सच्चा ब्राह्मण और संन्यासी है। 
            जिसकी शिखा (चोटी) पूरी तरह 'ज्ञानमयी' है, और जिसका जनेऊ भी पूरी तरह से ज्ञान का ही बना हुआ है, ऐसा योगी दुनिया के सभी बाहरी दिखावों से हमेशा के लिए आज़ाद हो जाता है। 
            शाट्यायनीय उपनिषद का यह श्लोक सनातन धर्म के खोखले कर्मकांडों पर एक भयंकर प्रहार है! लोग सिर पर बाल की चोटी रखकर और सूती धागा पहनकर खुद को बहुत पवित्र और बड़ा समझने लगते हैं। 
            परंतु ऋषि यहाँ गर्जना करते हैं कि अगर तुम्हारे अंदर काम, क्रोध और लालच भरा है, तो वह सूती धागा तुम्हें नरक से नहीं बचा सकता! 
            सच्चा संन्यासी वह है जो अपने अज्ञान को मुंडवा देता है, और अपनी आत्मा के अनुभव को धागे की तरह पहनता है। जब 'ज्ञान' ही तुम्हारा कवच बन जाए, तभी तुम सच्चे अर्थों में संन्यासी कहलाने के लायक हो।
        """.trimIndent(),
        english = """
            (Supreme Wisdom is the absolute true Tuft and Sacred Thread): That magnificent Sannyasi who fiercely recognizes strictly 'Jnana' (Supreme Spiritual Wisdom) alone as his authentic Shikha (tuft of hair), who remains permanently and flawlessly anchored exclusively in absolute Self-knowledge (Jnananistho) 24 hours a day, 
            and who has violently transformed raw 'Wisdom' itself directly into his absolute true Yajnopavita (Sacred Thread); he, and strictly he alone, is the true Brahmin and ultimate monk. 
            He whose exact tuft is explicitly made entirely of 'pure wisdom', and whose sacred thread is also strictly fabricated from that identical supreme realization, instantly becomes permanently liberated from all external religious hypocrisies. 
            This explosive verse of the Shatyayaniya Upanishad acts as a terrifying physical strike against entirely empty religious rituals! Highly ignorant people foolishly keep a tuft of hair and wear a cheap cotton thread, arrogantly declaring themselves as pure. 
            But the supreme sage fiercely roars that if your mind is heavily polluted with toxic lust, massive anger, and blinding greed, that pathetic cotton thread can absolutely never save you from hell! 
            The true master monk is exactly he who ruthlessly shaves off his own deep ignorance and wears the direct experience of his pure Soul exactly like an invisible cosmic thread. Only when 'Wisdom' aggressively becomes your ultimate armor do you truly deserve to be called a Sannyasi.
        """.trimIndent()
    ),
    ShatyayaniyaShloka(
        id = 12,
        sanskrit = "ब्राह्मण्यं सकलं तस्य इति ब्रह्मविदो विदुः ।\nतस्मात्सर्वप्रयत्नेन ज्ञानमेवाभ्यसेद्यतिः ॥ १२ ॥",
        hindi = """
            (सच्चा ब्राह्मणत्व केवल ज्ञान में है): ब्रह्म को जानने वाले महान और सिद्ध महापुरुषों (ब्रह्मविदो विदुः) का स्पष्ट रूप से यह मानना है कि सच्चे संन्यासी का 'ब्राह्मणत्व' (Brahmin-hood / पवित्रता) पूरी तरह से केवल और केवल उसके आत्मज्ञान में ही निवास करता है। 
            इसलिए, एक सच्चे यति (संन्यासी) को चाहिए कि वह अपनी पूरी शक्ति और भयंकर प्रयत्नों (सर्वप्रयत्नेन) से केवल और केवल 'ज्ञान' का ही निरंतर अभ्यास (ज्ञानमेवाभ्यसेद्यतिः) करे। 
            यह श्लोक जन्म के आधार पर चलने वाले जातिवाद (Caste by birth) के अहंकार को पूरी तरह से कुचल देता है। उपनिषद साफ कहता है कि कोई भी इंसान सिर्फ ब्राह्मण कुल में पैदा होने से या मंत्र रटने से 'ब्राह्मण' नहीं हो जाता। 
            असली ब्राह्मणत्व (Purity of Soul) बाजार में नहीं मिलता, यह तो इंसान की उस परम चेतना का नाम है जो दुनिया के हर मोह-माया को राख समझती है। 
            इसीलिए संन्यासी को आदेश दिया गया है कि वह दुनियादारी की फालतू बातों, गपशप और कर्मकांडों में अपना एक भी सेकंड बर्बाद न करे। 
            उसका एकमात्र लक्ष्य अपनी पूरी जान लगाकर (सर्वप्रयत्नेन) उस 'मैं कौन हूँ?' वाले ज्ञान की आग को 24 घंटे जलाए रखना है।
        """.trimIndent(),
        english = """
            (True Brahmin-hood exists strictly and exclusively in Supreme Wisdom): The absolute ultimate, enlightened masters who have flawlessly realized Brahman (Brahmavido viduh) explicitly and fiercely declare that the exact, complete 'Brahman-hood' (ultimate purity) of a true monk resides strictly, entirely, and exclusively purely within his profound Self-knowledge alone. 
            Therefore, a true Yati (renunciate monk) must relentlessly, with his absolute total might and terrifying supreme effort (Sarvaprayatnena), continuously and obsessively practice and cultivate absolutely nothing but pure 'Wisdom' (Jnanamevabhyasedyatih). 
            This spectacular verse violently completely crushes the arrogant, highly toxic ego of birth-based Casteism (Caste by birth). The Upanishad fiercely screams that absolutely no human being magically becomes a 'Brahmin' simply by being physically born into a specific family or blindly chanting recited mantras. 
            Authentic Brahmin-hood (Supreme Purity of the Soul) cannot be bought in a cheap market; it is the exact ultimate state of consciousness that flawlessly perceives all worldly attachments strictly as worthless ash. 
            Hence, the supreme monk is aggressively commanded absolutely never to waste even a single split-second on useless worldly gossip, fake politics, or empty religious rituals. 
            His absolute exclusive goal is to aggressively utilize every drop of his life-force (Sarvaprayatnena) to relentlessly keep the blazing fire of "Who Am I?" violently burning 24 hours a day.
        """.trimIndent()
    ),
    ShatyayaniyaShloka(
        id = 13,
        sanskrit = "अहिंसा सत्यमस्तेयं ब्रह्मचर्यापरिग्रहौ ।\nयमाः पञ्च यतीनां वै नियमाश्च तथा स्मृताः ॥ १३ ॥",
        hindi = """
            (संन्यासी के पाँच भयंकर महाव्रत): एक सच्चे संन्यासी (यति) के लिए महर्षियों ने ये पाँच सबसे महान और अनिवार्य व्रत (यमाः पञ्च) तय किए हैं: 
            १. अहिंसा (मन, वचन और कर्म से किसी को चोट न पहुंचाना), २. सत्य (कभी झूठ न बोलना), ३. अस्तेय (कभी चोरी या बेईमानी न करना), ४. ब्रह्मचर्य (वासना और कामुक विचारों का 100% त्याग), और ५. अपरिग्रह (कल के लिए कोई भी संपत्ति या पैसा इकट्ठा न करना)। 
            ये पाँच 'यम' (नियम) कोई साधारण नियम नहीं हैं; ये एक संन्यासी के जीवन की नींव हैं। अगर इनमें से एक भी नियम टूटता है, तो संन्यासी तुरंत भ्रष्ट हो जाता है। 
            दुनिया के लोग अपने भविष्य को सुरक्षित करने के लिए बैंक बैलेंस (Bank balance) बनाते हैं, लेकिन एक संन्यासी का 'अपरिग्रह' व्रत उसे कल के लिए एक मुट्ठी अनाज भी रखने से रोकता है! 
            उसे पूरी तरह से भगवान (ईश्वर) पर निर्भर रहना पड़ता है। यह कोई कमज़ोरी नहीं, बल्कि दुनिया की सबसे बड़ी 'हिम्मत' (Courage) है। 
            जब आपके पास बैंक में ज़ीरो (Zero) हो और मन में भगवान के प्रति 100% भरोसा हो, तभी आप इन पाँच महाव्रतों पर चल सकते हैं और साक्षात् नारायण का रूप बन सकते हैं।
        """.trimIndent(),
        english = """
            (The five terrifyingly strict supreme vows of a monk): The ancient supreme sages have ruthlessly mandated these exactly five absolute, non-negotiable great vows (Yamah pancha) strictly for a true Sannyasi (Yati): 
            1. Ahimsa (absolutely zero violence through mind, speech, or physical action), 2. Satya (unflinching absolute Truth), 3. Asteya (strictly zero stealing or manipulation), 4. Brahmacharya (100% absolute annihilation of all lust and sexual thoughts), and 5. Aparigraha (aggressively refusing to accumulate even a single coin or physical property for tomorrow). 
            These five 'Yamas' (Vows) are absolutely no ordinary rules; they are the exact foundational bedrock of a monk's entire existence. If even a microscopic fraction of a single rule is violently broken, the monk instantly becomes a corrupt hypocrite. 
            Ignorant worldly people blindly aggressively build massive bank balances simply to secure their fake future, but a monk's terrifying vow of 'Aparigraha' ruthlessly blocks him from storing even a single handful of cheap grain for tomorrow! 
            He must permanently, flawlessly remain 100% exclusively dependent strictly on God (The Supreme). This is absolutely not a weakness, but undeniably the absolute greatest, most terrifying 'Courage' in the universe. 
            Only exactly when you have an absolute Zero in your bank and a 100% flawless blazing trust in the Supreme Lord can you successfully execute these five massive vows and physically become the direct embodiment of Narayana.
        """.trimIndent()
    ),
    ShatyayaniyaShloka(
        id = 14,
        sanskrit = "आत्मानमराणिं कृत्वा प्रणवं चोत्तराणिम् ।\nध्याननिर्मथनाभ्यासात् देवं पश्येन्निगूढवत् ॥ १४ ॥",
        hindi = """
            (ध्यान का विज्ञान - आत्मा और ॐ): साधक को चाहिए कि वह अपनी खुद की 'आत्मा' (हृदय/मन) को नीचे वाली लकड़ी (अरणी) बनाए, और 'ॐ' (प्रणव) को ऊपर वाली लकड़ी बनाए। 
            जिस तरह प्राचीन काल में दो लकड़ियों को आपस में रगड़कर भयंकर आग पैदा की जाती थी, ठीक उसी तरह निरंतर 'ध्यान' (Meditation) के भयंकर रगड़ (निर्मथनाभ्यासात्) से अपने अंदर के अज्ञान को जला डालना चाहिए। 
            इस कठोर ध्यान और मंथन के द्वारा, योगी उस परमेश्वर (देवं) का साक्षात् दर्शन कर लेता है, जो उसके ही शरीर के भीतर एक गहरे रहस्य (निगूढवत्) की तरह छिपा हुआ था! 
            शाट्यायनीय उपनिषद यहाँ 'मेडिटेशन' (Meditation) का एक बहुत ही वैज्ञानिक (Scientific) और प्रैक्टिकल (Practical) तरीका बता रहा है। 
            भगवान कोई बाहर आसमान में बैठा व्यक्ति नहीं है जो तुम्हें पुकारने पर आ जाएगा। भगवान वह 'आग' (Fire) है जो तुम्हारे अंदर पहले से मौजूद है, लेकिन वह छिपी हुई है। 
            जब तुम एक जगह बैठकर ॐ (OM) के मंत्र को अपनी सांसों के साथ रगड़ते हो, तो तुम्हारे विचारों का घर्षण (Friction) पैदा होता है। और उसी भयंकर मंथन से एक दिन वह परम चेतना (Enlightenment) फटकर बाहर आती है!
        """.trimIndent(),
        english = """
            (The supreme science of Meditation - The Soul and OM): The supreme seeker must actively make his very own pure 'Soul' (Mind/Heart) exactly like the lower wooden block (Arani), and make the supreme cosmic sound 'OM' (Pranava) exactly like the upper wooden block. 
            Just exactly as in ancient times, terrified blazing fire was aggressively violently produced purely by continuously fiercely rubbing two pieces of wood together, similarly, strictly through the terrifyingly intense, relentless friction of deep 'Meditation' (Dhyananirmathanabhyasat), one must ruthlessly burn away his inner ignorance to ash. 
            Strictly through this rigorous, aggressive meditation and churning, the master Yogi successfully and directly visibly beholds the Supreme Lord (Devam), who was flawlessly entirely hidden strictly exactly like a profound, invisible secret (Nigudhavat) deep inside his very own physical body! 
            The Shatyayaniya Upanishad fiercely provides a highly exact 'Scientific' and intensely Practical method for supreme Meditation right here. 
            God is absolutely not some biological person sitting on a magical cloud waiting to be called. God is literally the absolute blazing 'Fire' of pure consciousness that is already permanently present deep inside you, but is entirely hidden. 
            Exactly when you sit flawlessly still and aggressively ruthlessly rub the supreme cosmic mantra OM with your raw breathing, massive psychological friction is generated. And strictly from that terrifying, explosive churning, exactly one day, that Supreme Enlightenment violently erupts outward!
        """.trimIndent()
    ),
    ShatyayaniyaShloka(
        id = 15,
        sanskrit = "अनपेक्षः शुचिर्दक्ष उदासीनो गतव्यथः ।\nसर्वारम्भपरित्यागी स संन्यासी स मे प्रियः ॥ १५ ॥",
        hindi = """
            (भगवान का सबसे प्रिय संन्यासी): जो संन्यासी इस दुनिया की किसी भी चीज़ या व्यक्ति से कोई उम्मीद या अपेक्षा नहीं रखता (अनपेक्षः), जो अंदर और बाहर दोनों जगह से पूरी तरह पवित्र है (शुचिर्दक्ष)। 
            जो दुनिया के सभी सांसारिक ड्रामों (Drama) से बिल्कुल उदासीन (तटस्थ/Neutral) रहता है, जिसके मन से हर प्रकार का दुख और चिंता हमेशा के लिए मिट चुकी है (गतव्यथः)। 
            और जिसने भविष्य के लिए कोई भी नया सकाम कर्म या प्रोजेक्ट शुरू करना (सर्वारम्भ) 100% त्याग दिया है (परित्यागी); वास्तव में वही सच्चा संन्यासी है, और केवल वही भगवान को सबसे ज्यादा प्यारा (स मे प्रियः) है! 
            यह श्लोक एक जीवनमुक्त योगी की पूरी साइकोलॉजी (Psychology) को स्कैन (Scan) कर देता है। इंसान दुखी क्यों होता है? क्योंकि वह लोगों से 'उम्मीद' (Expectations) रखता है। 
            परमहंस योगी को किसी से एक कप चाय की भी उम्मीद नहीं होती। उसे कोई फर्क नहीं पड़ता कि दुनिया में कौन प्रधानमंत्री बन रहा है या शेयर मार्केट कहाँ जा रहा है; वह पूरी तरह से 'उदासीन' (Neutral) है। 
            उसने दुनिया के सारे 'स्टार्टअप' (Startups) और भौतिक योजनाएं बंद कर दी हैं, क्योंकि उसका एकमात्र प्रोजेक्ट केवल अपने अहंकार को मारना और ईश्वर में लीन रहना है।
        """.trimIndent(),
        english = """
            (The absolute most beloved Sannyasi of God): That supreme monk who maintains strictly zero expectations or hopes (Anapekshah) from absolutely any object or person in this entire physical universe, who is flawlessly entirely pure exactly from both inside and outside (Shuchirdaksha). 
            Who permanently remains completely and profoundly 'Neutral' and terrifyingly indifferent (Udasino) to absolutely all toxic worldly dramas, and from whose mind every microscopic trace of sorrow, anxiety, and fear has been permanently erased (Gatavyathah). 
            And who has aggressively, ruthlessly, and 100% permanently completely abandoned (Parityagi) initiating any new worldly, desire-driven actions or future materialistic projects (Sarvarambha); he alone is undeniably the absolute true Sannyasi, and exactly he alone is supremely and infinitely beloved to the Lord (Sa me priyah)! 
            This magnificent verse flawlessly entirely scans the complete absolute Psychology of a Jivanmukta Yogi. Why exactly does a human suffer? Purely because he blindly holds pathetic 'Expectations' from fake people. 
            The grand Paramahamsa Yogi absolutely does not harbor the expectation of even a single cup of tea from anyone. He entirely cares exactly zero about who becomes the fake worldly Prime Minister or where the cheap stock market goes; he is flawlessly, terrifyingly 'Neutral'. 
            He has violently permanently shut down absolutely all physical worldly 'Startups' and cheap future plans, purely because his absolute only remaining project is to ruthlessly slaughter his own ego and remain permanently merged in God.
        """.trimIndent()
    ),
    ShatyayaniyaShloka(
        id = 16,
        sanskrit = "अलाभे न विषादी स्याल्लाभे चैव न हर्षयेत् ।\nप्राणयात्रिकमात्रः स्यान्मात्रासङ्गाद्विनिर्मुक्तः ॥ १६ ॥",
        hindi = """
            (भिक्षा और भोजन का कठोर नियम): अगर किसी दिन भिक्षा मांगने पर खाना न मिले (अलाभे), तो संन्यासी को अपने मन में जरा सा भी दुख या निराशा (न विषादी स्यात्) नहीं लानी चाहिए। 
            और अगर किसी दिन बहुत स्वादिष्ट और अच्छा भोजन (लाभे) मिल जाए, तो उसे पाकर खुशी से उछलना (न हर्षयेत्) भी नहीं चाहिए। 
            उसे भोजन केवल इसलिए करना चाहिए ताकि शरीर में प्राण (सांसें) टिके रहें (प्राणयात्रिकमात्रः), और उसे भोजन के 'स्वाद' (मात्रा/Sense objects) की आसक्ति से पूरी तरह मुक्त (विनिर्मुक्तः) होना चाहिए। 
            एक सच्चे योगी के लिए खाना केवल एक 'दवा' (Medicine) की तरह है जो शरीर रूपी मशीन को चलाने के लिए डाली जाती है। 
            हम लोग खाने के स्वाद (Taste) के गुलाम होते हैं; अगर पनीर अच्छा न बने तो हम गुस्सा हो जाते हैं। लेकिन संन्यासी अपनी जीभ (Tongue) को काट चुका होता है (वैराग्य से)। 
            वह सूखी रोटी और राजशाही पकवान, दोनों को बिल्कुल एक समान भाव से चबाता है। जब तक जीभ के स्वाद की गुलामी नहीं टूटती, तब तक इंसान भगवान का सच्चा रस नहीं चख सकता।
        """.trimIndent(),
        english = """
            (The terrifyingly strict rule of alms and food): If on any specific day, strictly entirely absolutely no food is received upon begging (Alabhe), the supreme monk must absolutely never allow even a microscopic fraction of sorrow, frustration, or depression (Na vishadi syat) to enter his pure mind. 
            And conversely, if on any day he violently receives an exceptionally delicious and lavish feast (Labhe), he must completely and strictly never jump in foolish joy or feel cheap physical excitement (Na harshayet). 
            He must relentlessly consume food strictly and exclusively solely for the absolute bare minimum maintenance of keeping the life-breath aggressively moving inside his physical dirt-body (Pranayatrikamatrah), and he must remain permanently and flawlessly completely liberated (Vinirmuktah) from the toxic, blinding attachment to the physical 'Taste' of sensory objects (Matrasanga). 
            For a true absolute Yogi, food is exactly and strictly purely a highly functional 'Medicine' forcefully injected merely to keep the biological physical machine running. 
            Ignorant humans are pathetic blind slaves entirely to the cheap 'Taste' of the tongue; if a dish is slightly flawed, they violently explode in anger. But the master monk has ruthlessly cut out his own tongue (via supreme detachment). 
            He flawlessly chews both a dry, rotting piece of stale bread and a lavish royal feast exactly with the absolute identical emotion. Until the pathetic slavery to physical taste is violently shattered, a human can absolutely never taste the supreme nectar of God.
        """.trimIndent()
    ),
    ShatyayaniyaShloka(
        id = 17,
        sanskrit = "निन्दां क्षमेत सततं न कञ्चिदवमानयेत् ।\nदेहमुद्दिश्य पशुवद्वैरं कुर्यान्न केनचित् ॥ १७ ॥",
        hindi = """
            (अपमान सहना और नफरत का त्याग): संन्यासी को चाहिए कि वह दुनिया वालों द्वारा की गई अपनी 'निंदा' और गालियों को हमेशा (सततं) पूरी शांति से क्षमा (क्षमेत) कर दे, और खुद कभी भी किसी भी इंसान का भूलकर भी अपमान (न कञ्चिदवमानयेत्) न करे। 
            केवल इस नाशवान शरीर (देहमुद्दिश्य) की सुख-सुविधा और इज्जत को बचाने के लिए, उसे जानवरों की तरह (पशुवत्) किसी भी इंसान से नफरत या दुश्मनी (वैरं) बिल्कुल नहीं करनी चाहिए। 
            उपनिषद का यह श्लोक इंसान को 'जानवर' से 'भगवान' बनने का रास्ता बताता है। जब एक कुत्ते को पत्थर मारा जाता है, तो वह पलट कर काटता है (यह पशुवृत्ति है)। 
            लेकिन जब एक परमहंस योगी को पत्थर या गाली मारी जाती है, तो वह मुस्कुरा कर आगे बढ़ जाता है। क्यों? क्योंकि वह जानता है कि गाली इस 'शरीर' को दी गई है, उसकी अमर 'आत्मा' को नहीं। 
            जो इंसान अपनी झूठी इज्जत (Ego) को बचाने के लिए लोगों से लड़ता और दुश्मनी पालता है, वह ज्ञान के रास्ते पर अभी नर्सरी क्लास (Nursery class) में भी नहीं पहुँचा है। 
            अहंकार को मारना ही संन्यास का सबसे बड़ा और सबसे भयंकर युद्ध है।
        """.trimIndent(),
        english = """
            (Enduring absolute humiliation and abandoning hatred): The supreme monk must relentlessly, flawlessly, and continuously (Satatam) peacefully completely forgive (Kshameta) all toxic criticism, brutal insults, and massive degradation hurled at him by the ignorant world, and he himself must absolutely never, ever even mistakenly insult or degrade (Na kanchidavamanayet) any other human being. 
            Exclusively merely to protect the cheap fake dignity and physical comfort of this highly perishable dirt-body (Dehamuddishya), he must absolutely completely never harbor violent hatred, enmity, or seek brutal revenge (Vairam) exactly like a mindless, reactive animal (Pashuvat) against absolutely anyone. 
            This magnificent verse of the Upanishad fiercely dictates the exact brutal path of violently transforming from a pathetic 'Animal' strictly into 'God'. When a mad dog is violently hit by a stone, it aggressively turns and bites back (this is raw animal instinct). 
            But exactly when a grand Paramahamsa Yogi is brutally pelted with stones or horrific insults, he simply flawlessly smiles and effortlessly walks away. Why? Because he profoundly knows the cheap insult only hit his rotting 'Physical Body', absolutely not his immortal 'Soul'. 
            That deeply ignorant human who blindly fights and harbors toxic enmity purely to defend his fake physical respect (Ego) hasn't even reached the nursery class of true spirituality. 
            Ruthlessly slaughtering one's own massive Ego is undeniably the absolute greatest and most terrifyingly violent war of Sannyasa.
        """.trimIndent()
    ),
    ShatyayaniyaShloka(
        id = 18,
        sanskrit = "नैकत्र वासं कुर्वीत भिक्षुर्ग्रामे रणेऽपि वा ।\nअनिकेतः स्थिरमतिर्मोक्षमेव परायणः ॥ १८ ॥",
        hindi = """
            (लगातार भ्रमण और अ-निकेत अवस्था): एक सच्चे संन्यासी (भिक्षु) को कभी भी किसी एक गाँव (ग्रामे) या एक ही जंगल/एकांत जगह (रणेऽपि वा) में लंबे समय तक अपना डेरा या घर (एकत्र वासं) नहीं बनाना चाहिए। 
            उसे 'अनिकेतः' (बिना घर का / Homeless) होकर लगातार घूमते रहना चाहिए, लेकिन उसकी बुद्धि और मन हमेशा भगवान में पूरी तरह स्थिर (स्थिरमतिः) रहने चाहिए। 
            उसका एकमात्र और सबसे बड़ा लक्ष्य केवल 'मोक्ष' (परम मुक्ति / मोक्षमेव परायणः) प्राप्त करना होना चाहिए। 
            यहाँ 'भ्रमण' (Wandering) का एक बहुत गहरा मनोवैज्ञानिक (Psychological) कारण है। इंसान जहाँ भी 4 दिन रुकता है, उसे उस जगह, उस बिस्तर और वहाँ के लोगों से 'मोह' (Attachment) हो जाता है। 
            इसलिए प्राचीन नियम था कि संन्यासी बारिश के मौसम (चातुर्मास) को छोड़कर, कभी भी एक जगह पर 3 दिन से ज्यादा नहीं रुकेगा। 
            वह बाहर से एक 'घुमक्कड़' (Homeless wanderer) की तरह दिखता है जिसे कोई नहीं जानता, लेकिन अंदर से वह पूरे ब्रह्मांड का राजा होता है क्योंकि उसका मन अपनी चेतना (आत्मा) रूपी सिंहासन पर बिल्कुल 'स्थिर' (Fixed) होकर बैठा होता है।
        """.trimIndent(),
        english = """
            (Continuous wandering and the Homeless state): A true supreme monk (Bhikshu) must absolutely completely never, ever establish a permanent residence or build a comfortable camp (Ekatra vasam) strictly in any single worldly village (Grame) or even in a single isolated deep forest (Rane'pi va) for a long period. 
            He must permanently and flawlessly remain completely 'Aniketah' (Absolutely Homeless/without a fixed abode), continuously fiercely wandering, yet his supreme intellect and pure mind must perpetually remain terrifyingly still and entirely fixed (Sthiramatih) strictly exclusively upon God. 
            His absolute exclusive, singular, and highest massive objective must strictly only be the aggressive attainment of 'Moksha' (Ultimate Supreme Liberation / Mokshameva parayanah). 
            There is a vastly profound, explosive Psychological reason exactly behind this aggressive rule of 'Continuous Wandering'. Wherever a human blindly stays comfortably for even 4 days, he instantly forms a toxic, suffocating 'Attachment' to that exact specific physical place, that comfortable bed, and those fake people. 
            Hence, the terrifying ancient law aggressively mandated that except for the brutal monsoon season (Chaturmasya), a true monk must absolutely never physically stay in one single place for more than 3 days. 
            From the outside, he vividly appears exactly like a pathetic 'Homeless wanderer' whom absolutely no one knows, but entirely from the inside, he is undeniably the absolute supreme King of the entire cosmos because his mind is permanently 'Fixed' exactly on the indestructible throne of his own pure Consciousness.
        """.trimIndent()
    ),
    ShatyayaniyaShloka(
        id = 19,
        sanskrit = "अस्थिस्थूणं स्नायुबद्धं मांसशोणितलेपनम् ।\nचर्मावनद्धं दुर्गन्धं पूर्णं मूत्रपुरीषयोः ॥ १९ ॥",
        hindi = """
            (शरीर की असली और घिनौनी सच्चाई): यह इंसान का शरीर क्या है? यह केवल 'हड्डियों' (अस्थि) के खंभों पर खड़ा एक ढांचा है, जिसे 'नसों' (स्नायु) के तारों से बांधा गया है। इस पर 'मांस' और 'खून' (मांसशोणित) का लेप (Plaster) लगाया गया है। 
            इसे बाहर से एक पतली सी 'चमड़ी' (चर्म) से ढक दिया गया है, लेकिन असल में यह शरीर भयानक 'दुर्गंध' (बदबू) से भरा हुआ है, और यह अंदर से केवल 'पेशाब और मल' (मूत्रपुरीषयोः / Urine and Feces) से ठसाठस भरा हुआ है! 
            शाट्यायनीय उपनिषद का यह श्लोक इंसान के अहंकार और शारीरिक सुंदरता (Physical Beauty) के घमंड पर एक सीधा 'न्यूक्लियर बम' (Nuclear Bomb) है! 
            हम लोग महंगे क्रीम (Creams), परफ्यूम और कपड़ों से इस शरीर को सजाकर बहुत घमंड करते हैं और दूसरों के शरीर से वासना (Lust) करते हैं। 
            लेकिन संन्यासी की एक्स-रे (X-Ray) जैसी नज़र इस चमड़ी के पीछे का सच देखती है—कि यह शरीर केवल एक चलती-फिरती 'मल-मूत्र की फैक्ट्री' (Toilet) है जो एक दिन सड़कर खाक हो जाएगी। 
            जब साधक रोज इस सच्चाई का ध्यान करता है, तो उसके मन से भयंकर 'कामवासना' (Lust) और शरीर का मोह हमेशा के लिए जड़ से खत्म हो जाता है। 
        """.trimIndent(),
        english = """
            (The absolute horrific and disgusting reality of the physical body): What exactly is this highly praised human body? It is strictly entirely nothing but a pathetic skeletal frame standing purely on pillars of raw 'Bones' (Asthi), violently tied together strictly by strings of 'Veins and Nerves' (Snayu). It is superficially plastered entirely with wet raw 'Flesh and Blood' (Mamsashonita). 
            It is completely artificially covered entirely from the outside purely by a microscopic thin layer of 'Skin' (Charma), but in absolute brutal reality, this physical body is entirely violently filled with terrifying 'Stench and foul odors' (Durgandham), and internally it is absolutely packed entirely strictly with raw 'Urine and Feces' (Mutrapurishayoh)! 
            This spectacular, explosive verse of the Shatyayaniya Upanishad acts exactly as a direct, terrifying 'Nuclear Bomb' violently dropped entirely upon the massive human ego and the pathetic blind obsession with fake 'Physical Beauty'! 
            Deeply ignorant humans blindly aggressively decorate this rotting dirt-body with highly expensive chemical creams, fake perfumes, and branded clothes, heavily acting arrogant and violently lusting exactly after other physical bodies. 
            But the supreme master monk's terrifying X-Ray vision flawlessly pierces this fake outer skin and explicitly sees the brutal naked truth—that this highly praised body is strictly nothing but a pathetic, walking, rotting 'Factory of Feces and Urine' that will inevitably violently decay into worthless ash. 
            Exactly when a supreme seeker relentlessly meditates strictly upon this brutal reality daily, his terrifying, toxic blinding 'Lust' and obsessive attachment to the physical dirt-body are permanently, violently slaughtered exactly from the deepest root forever.
        """.trimIndent()
    ),
    ShatyayaniyaShloka(
        id = 20,
        sanskrit = "जराशोकसमाविष्टं रोगायतनमातुरम् ।\nरजस्वलमनित्यं च भूतावासमिमं त्यजेत् ॥ २० ॥",
        hindi = """
            (शरीर का त्याग और वैराग्य): यह शरीर 'बुढ़ापे' (जरा) और भयंकर 'दुखों' (शोक) से पूरी तरह से घिरा हुआ है। यह दुनिया भर की 'बीमारियों' (रोग) का परमानेंट घर (आयतनम्) है और हमेशा बेचैन (आतुरम्) रहता है। 
            यह हमेशा मलिन और अशुद्ध (रजस्वलम्) रहता है, यह 100% 'अस्थायी' (अनित्यं / Temporary) है, और यह पंचभूतों (मिट्टी, पानी, आग आदि) का एक झूठा तंबू (भूतावासम्) है। 
            इसलिए, एक बुद्धिमान इंसान को इस शरीर से अपना मोह पूरी तरह से छोड़ देना चाहिए (इमं त्यजेत्)। 
            यह श्लोक श्लोक 19 का ही अगला कदम है। जब आप जान लेते हैं कि यह शरीर एक 'कचरे का डिब्बा' है, तो आप इससे चिपकना छोड़ देते हैं। 
            दुनिया की सबसे बड़ी बेवकूफी यह है कि इंसान सोचता है वह हमेशा जवान रहेगा, जबकि हकीकत यह है कि हर गुजरता हुआ दिन उसे मौत और भयानक बीमारियों के करीब ले जा रहा है। 
            उपनिषद यहाँ आपको डरा नहीं रहा है, बल्कि वह आपको 'जगा' रहा है (Waking you up)! वह कह रहा है कि इस टूटने वाले घर (शरीर) से मोह हटाओ और उस अजर-अमर 'आत्मा' (Soul) में अपना घर बनाओ जो कभी बूढ़ी नहीं होती और जिसे कोई बीमारी नहीं छू सकती।
        """.trimIndent(),
        english = """
            (The absolute rejection and renunciation of the physical body): This specific physical dirt-body is completely, terrifyingly enveloped and violently invaded permanently by horrific 'Old Age' (Jara) and crushing 'Sorrow and Grief' (Shoka). It is the absolute permanent breeding ground and permanent address strictly for terrifying 'Diseases' (Rogayatanam), and it permanently violently remains anxious and suffering (Aturam). 
            It is flawlessly permanently filthy, deeply impure (Rajasvalam), absolutely 100% strictly 'Temporary and Perishable' (Anityam), and it is nothing but a highly fake, temporary physical tent blindly constructed purely of the five raw physical elements (Bhutavasam). 
            Therefore, a supremely wise human being must aggressively, ruthlessly, and permanently entirely abandon and fiercely kick away absolutely all psychological attachment strictly to this physical trash (Imam tyajet). 
            This explosive verse flawlessly forms the exact terrifying next step strictly after Verse 19. Exactly when you profoundly realize that this physical body is undeniably a temporary 'Garbage Bin', you violently aggressively stop clinging to it. 
            The absolute greatest pathetic stupidity of humanity is blindly thinking they will permanently rigidly remain young forever, while the terrifying brutal reality is that absolutely every passing second aggressively violently drags them exactly closer to horrific diseases and guaranteed death. 
            The Upanishad is absolutely not attempting to invoke cheap fear here; it is aggressively violently 'Waking you up'! It fiercely commands you to ruthlessly detach entirely from this collapsing dirt-house (the body) and immediately flawlessly establish your permanent residence strictly in the immortal, indestructible 'Soul' that absolutely never ages and which absolutely no disease can ever possibly touch.
        """.trimIndent()
    ),
    ShatyayaniyaShloka(
        id = 21,
        sanskrit = "अहं ब्रह्मेति विज्ञायाहं ब्रह्मेति विनिश्चयः ।\nअहं ब्रह्मेति भावो यः स संन्यासी स मे प्रियः ॥ २१ ॥",
        hindi = """
            (अहं ब्रह्मास्मि - अद्वैत का सर्वोच्च ज्ञान): जिस योगी ने गहराई से यह जान लिया है (विज्ञाया) कि "मैं ही साक्षात् परब्रह्म हूँ" (अहं ब्रह्मास्मि); 
            जिसके मन में यह ज्ञान एक पत्थर की लकीर की तरह '100% निश्चित' (विनिश्चयः) हो चुका है कि "मैं ही ब्रह्म हूँ"; 
            और जो योगी 24 घंटे केवल इसी परम भाव (भावो यः) में डूबा रहता है कि "मैं यह छोटा सा शरीर नहीं, बल्कि साक्षात् वह अनंत ब्रह्म हूँ।" 
            वास्तव में वही इंसान असली 'संन्यासी' है, और साक्षात् भगवान नारायण कहते हैं कि ऐसा ज्ञानी मुझे सबसे ज्यादा प्रिय (स मे प्रियः) है! 
            शाट्यायनीय उपनिषद का यह श्लोक अद्वैत वेदांत का पूरा का पूरा सार (Summary) है! दुनिया के 99% लोग भगवान को आसमान में खोजते हैं और खुद को एक पापी या कमज़ोर इंसान मानते हैं। 
            लेकिन जो शेर (Lion) यह जान लेता है कि उसके अंदर धड़कने वाली चेतना और पूरे ब्रह्मांड को चलाने वाली चेतना दोनों 100% एक ही (One) हैं, वह साक्षात् भगवान बन जाता है। 
            जब इंसान का 'मैं' (Ego) मर जाता है, तो उसके अंदर केवल ईश्वर ही बचता है। यही सनातन धर्म का सबसे बड़ा और सबसे ऊंचा रहस्य है!
        """.trimIndent(),
        english = """
            (Aham Brahmasmi - The Absolute Supreme Realization of Advaita): That supreme Yogi who has flawlessly and profoundly directly realized (Vijnaya) with terrifying clarity exactly that "I Myself Am The Absolute Supreme Brahman" (Aham Brahmeti); 
            Whose supreme intellect has violently permanently firmly established exactly this as a 100% absolute, unbreakable, rock-solid conviction (Vinishchayah) that "I Am Brahman"; 
            And that exact grand master who flawlessly relentlessly remains permanently submerged 24 hours a day purely in this exact supreme state of absolute cosmic consciousness (Bhavo yah) screaming "I am absolutely not this tiny dirt-body, but undeniably the Infinite Absolute Brahman Himself." 
            He, and absolutely strictly he alone, is the genuine ultimate 'Sannyasi', and Lord Narayana Himself fiercely declares that exactly such an enlightened master is supremely and infinitely most beloved to Me (Sa me priyah)! 
            This spectacular, explosive verse of the Shatyayaniya Upanishad acts exactly as the absolute flawless, complete Summary of the entirety of Advaita Vedanta! 99% of heavily ignorant people globally blindly search for God on some imaginary clouds while pathetically considering themselves weak, filthy sinners. 
            But that supreme Lion who violently awakens to the terrifying reality that the exact specific consciousness violently beating deep inside his chest and the exact supreme consciousness aggressively running the infinite cosmos are exactly 100% Identically One, instantly literally physically becomes God. 
            Exactly when a human's fake 'I' (Ego) is violently slaughtered, absolutely nothing but God alone flawlessly remains inside. This is undeniably the absolute greatest, highest, and most terrifyingly profound secret of Sanatana Dharma!
        """.trimIndent()
    ),
    ShatyayaniyaShloka(
        id = 22,
        sanskrit = "आनन्दमब्रह्मणो रूपं तच्चाहमिति भावयेत् ।\nअखण्डैकरसं ब्रह्म तदेवाहमसंशयम् ॥ २२ ॥",
        hindi = """
            (मैं अखंड आनंद हूँ): संन्यासी को हमेशा इस बात का दृढ़ चिंतन (भावयेत्) करना चाहिए कि उस परम ब्रह्म (ईश्वर) का असली रूप केवल और केवल 'परम आनंद' (आनन्दमब्रह्मणो रूपं / Pure Bliss) है, और "वह आनंद स्वरूप साक्षात् मैं ही हूँ!" (तच्चाहम्)। 
            "वह परब्रह्म पूरी तरह से 'अखंड' (जिसे तोड़ा न जा सके) और 'एक रस' (जो कभी न बदले) है; और बिना किसी जरा से भी संदेह के (असंशयम्), मैं साक्षात् वही ब्रह्म हूँ (तदेवाहम)!" 
            यह श्लोक 'डिप्रेशन' (Depression) और दुखों को जड़ से खत्म करने का सबसे बड़ा ब्रह्मास्त्र है। इंसान दुखी क्यों है? क्योंकि वह खुशी (Bliss) को बाहर की चीजों में, पैसे में, या लोगों में ढूँढ रहा है। 
            उपनिषद कहता है कि तुम खुद 'आनंद की फैक्ट्री' (Factory of Bliss) हो! तुम्हारी आत्मा (Soul) का नेचर (Nature) ही खुशी है। जब तुम इस बात पर बिना किसी शक (असंशयम्) के यकीन कर लेते हो कि "मैं अखंड भगवान हूँ", तो दुनिया का कोई भी दुख तुम्हें छू तक नहीं सकता। 
            संन्यासी किसी जंगल में उदास होकर नहीं बैठा रहता; वह अंदर ही अंदर ब्रह्मांड के सबसे बड़े 'परमानंद' (Ecstasy) में नाच रहा होता है।
        """.trimIndent(),
        english = """
            (I Am the Unbroken Absolute Bliss): The supreme Sannyasi must relentlessly and fiercely continuously violently meditate and firmly cultivate the exact thought (Bhavayet) that the absolute true explicit nature of the Supreme Brahman (God) is strictly and exclusively purely 'Infinite Supreme Bliss' (Anandam Brahmano rupam), and "I Myself explicitly literally Am exactly that very same Supreme Bliss!" (Tachchaham). 
            "That Absolute Supreme Brahman is entirely flawlessly 'Akhanda' (Unbroken/Indivisible) and exactly 'Ekarasa' (One completely unchanging homogeneous essence); and completely without even a microscopic fraction of a single doubt (Asamshayam), I Myself completely Am exactly that very same Absolute Brahman (Tadevaham)!" 
            This terrifyingly explosive verse is the absolute ultimate 'Brahmastra' (supreme weapon) explicitly for permanently violently slaughtering entirely all 'Depression' and psychological suffering strictly from its deepest root. Why exactly is humanity suffering? Purely because they blindly desperately aggressively search for 'Bliss' strictly in cheap external temporary objects, raw money, or fake people. 
            The Upanishad fiercely roars that you literally physically are the absolute 'Factory of Bliss' yourself! The exact pure core nature (Nature) of your very own Soul is literal ecstasy. Exactly when you violently forcefully believe with absolute 100% zero doubt (Asamshayam) that "I Am the Unbroken God", absolutely zero worldly sorrow can ever possibly even slightly touch you. 
            The grand monk absolutely does not sit pathetically depressed in some dark isolated jungle; internally, he is continuously fiercely violently dancing exactly in the absolute most terrifying 'Ecstasy' of the infinite universe.
        """.trimIndent()
    ),
    ShatyayaniyaShloka(
        id = 23,
        sanskrit = "तद्विष्णोः परमं पदं सदा पश्यन्ति सूरयः ।\nदिवीव चक्षुराततम् ॥ २३ ॥",
        hindi = """
            (विष्णु का परम धाम): जो ज्ञानी और मुक्त महापुरुष (सूरयः) होते हैं, वे भगवान 'विष्णु' (सर्वव्यापी परमात्मा) के उस 'परम धाम' (परमं पदं / Supreme Abode) का हमेशा, हर पल (सदा) साक्षात् दर्शन करते रहते हैं (पश्यन्ति)। 
            वे उस परम सत्य को इतनी स्पष्टता से देखते हैं, जैसे आकाश में फैली हुई इंसान की साफ 'आंख' (दिवीव चक्षुराततम्) पूरे आसमान को बिना किसी रुकावट के साफ-साफ देखती है! 
            शाट्यायनीय उपनिषद, जो कि एक संन्यास उपनिषद है, अंत में भगवान विष्णु (नारायण) के परम स्वरूप पर जाकर टिक जाता है। 
            यहाँ 'विष्णु का परम धाम' कोई ऐसा ग्रह या जगह नहीं है जहाँ इंसान मरने के बाद हवाई जहाज से जाता है! 'परम धाम' का मतलब है चेतना (Consciousness) का वह सबसे ऊँचा स्तर (Level), जहाँ सब कुछ भगवान बन जाता है। 
            ज्ञानी महापुरुष आंखें खोलकर भी उसी परम सत्य को देखते हैं और आंखें बंद करके भी। जैसे खुली आंख आसमान को हर जगह देखती है, वैसे ही योगी की तीसरी आंख (Third Eye) विष्णु की ऊर्जा (Energy) को ब्रह्मांड के कण-कण में बहते हुए देखती है।
        """.trimIndent(),
        english = """
            (The Supreme Absolute Abode of Lord Vishnu): Those utterly enlightened, fully liberated grand masters and supreme sages (Surayah) flawlessly, continuously, and permanently (Sada) explicitly and directly vividly behold (Pashyanti) exactly that 'Absolute Supreme Abode' (Paramam Padam) strictly of Lord 'Vishnu' (the all-pervading Supreme God). 
            They explicitly intensely observe that Absolute Truth with such terrifyingly absolute flawless clarity, exactly as a completely pure, unclouded 'Physical Eye' (Chakshuratatam) effortlessly seamlessly expanded exactly across the vast clear sky (Diviva) visibly perceives the entire heavens absolutely without any obstruction! 
            The Shatyayaniya Upanishad, deeply being a massive Sannyasa Upanishad, ultimately flawlessly exactly anchors itself heavily right exactly at the supreme absolute form of Lord Vishnu (Narayana). 
            Here, the 'Supreme Abode of Vishnu' is absolutely undeniably not some cheap physical planet or geographical location where a human flies in an airplane strictly after physical death! The 'Paramam Padam' strictly means the absolute highest infinite ultimate dimension (Level) of pure Consciousness, where absolutely everything violently dissolves explicitly into God. 
            The supremely enlightened masters vividly see exactly that identical Absolute Truth continuously with their physical eyes wide open and exactly with their eyes violently shut. Exactly just as the wide-open eye completely clearly sees the physical sky literally everywhere, similarly, the grand Yogi's fiercely awakened Third Eye violently perceives the absolute raw Energy of Vishnu flawlessly permanently flowing entirely in every microscopic atom of the infinite cosmos.
        """.trimIndent()
    ),
    ShatyayaniyaShloka(
        id = 24,
        sanskrit = "तद्विप्रासो विपन्यवो जागृवांसः समिन्धते ।\nविष्णोर्यत्परमं पदम् । इत्युपनिषत् ॥ २४ ॥",
        hindi = """
            (ज्ञानी ही उस परम पद को प्रकाशित करते हैं / फलश्रुति): जो विद्वान, ज्ञानी और स्तुति करने वाले महान विप्र (विप्रासो विपन्यवो) हैं, जो आध्यात्मिक रूप से पूरी तरह 'जाग चुके' हैं (जागृवांसः / Awakened); 
            वे ही भगवान विष्णु के उस 'परम धाम' (विष्णोर्यत्परमं पदम्) को अपने हृदय में पूरी तरह से रोशन और प्रज्वलित (समिन्धते) कर पाते हैं। 
            यहीं पर यह महान ज्ञान पूरा होता है (इत्युपनिषत् / Thus ends the Upanishad)। 
            यह पूरे शाट्यायनीय उपनिषद का अंतिम और सबसे शक्तिशाली निष्कर्ष है। जो इंसान अज्ञान की नींद में सो रहा है और सिर्फ पैसे और कामवासना के सपने देख रहा है, वह कभी भगवान को नहीं पा सकता। 
            भगवान का वह परम रूप (विष्णु का परम पद) केवल उन लोगों के अंदर 'प्रकाशित' (Illuminate) होता है जो योग, ध्यान और वैराग्य के द्वारा अपनी चेतना को पूरी तरह से 'जगा' (Awaken) चुके हैं। 
            जैसे माचिस रगड़ने से आग पैदा होती है, वैसे ही लगातार ज्ञान के मंथन से जब इंसान का अहंकार राख हो जाता है, तब उसके दिल में साक्षात् भगवान विष्णु की वह ज्योति जल उठती है जो कभी नहीं बुझती। ॐ शांतिः शांतिः शांतिः!
        """.trimIndent(),
        english = """
            (Only the fully awakened masters illuminate that Supreme Abode / Phala-Shruti): Those exact exceptionally wise, supremely learned, and utterly devoted grand Vipras (Vipraso vipanyavo) who are flawlessly, entirely, and completely spiritually 'Fully Awakened' (Jagruvansah) from the dark slumber of ignorance; 
            They, and absolutely strictly they alone, successfully violently completely illuminate, fiercely ignite, and constantly keep blazing (Samindhate) exactly that 'Absolute Supreme Abode of Lord Vishnu' (Vishnoryatparamam padam) entirely permanently within their own pure hearts. 
            Right exactly here, this magnificent, absolute supreme cosmic wisdom flawlessly completely concludes (Ityupanishat / Thus ends the grand Upanishad). 
            This is undeniably the absolute final, explosive, and most powerfully terrifying conclusion of the entire Shatyayaniya Upanishad. That deeply ignorant human who is pathetically blindly snoring purely in the dark toxic sleep of ignorance, aggressively dreaming purely of cheap money and physical lust, can absolutely never possibly attain the Supreme Lord. 
            That absolute ultimate supreme form of God (Vishnu's Paramam Padam) is flawlessly exclusively violently 'Illuminated' and aggressively revealed strictly only deep inside those rare masters who have violently completely 'Awakened' their pure consciousness strictly through terrifying extreme Yoga, deep meditation, and absolute ruthless detachment. 
            Exactly just as violently striking a match aggressively instantly produces blazing fire, similarly, exactly when a human's massive ego is violently permanently reduced entirely to worthless ash strictly through the continuous terrifying churning of Supreme Wisdom, explicitly exactly then, that supreme infinite, immortal flame of Lord Vishnu violently erupts entirely in his pure heart, absolutely never ever to be extinguished again. OM Peace, Peace, Peace!
        """.trimIndent()
    )
)