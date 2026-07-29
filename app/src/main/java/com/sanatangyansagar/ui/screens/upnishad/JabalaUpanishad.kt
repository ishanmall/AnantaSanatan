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
data class JabalaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JabalaUpanishadScreen() {
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
                if (shlokaNumber != null && shlokaNumber in 1..6) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Khanda Number (1-6)") },
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
            itemsIndexed(jabalaShlokasList) { _, shloka ->
                JabalaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun JabalaShlokaCard(shloka: JabalaShloka) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Khanda ${shloka.id}",
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

val jabalaShlokasList: List<JabalaShloka> = listOf(
    JabalaShloka(
        id = 1,
        sanskrit = "बृहस्पतिरुवाच याज्ञवल्क्यम् । यदकुरुक्षेत्रं देवानां देवयजनं सर्वेषां भूतानां ब्रह्मसदनम् । अविमुक्तं वै कुरुक्षेत्रं देवानां देवयजनं सर्वेषां भूतानां ब्रह्मसदनम् ॥ १ ॥",
        hindi = """
            (जाबाल उपनिषद का आरंभ): एक बार देवगुरु बृहस्पति ने महर्षि याज्ञवल्क्य से पूछा: "वह परम पवित्र 'कुरुक्षेत्र' कौन सा है जो सभी देवताओं का पूजा-स्थल है और सभी प्राणियों के लिए ब्रह्म को प्राप्त करने का स्थान (ब्रह्मसदन) है?"
            महर्षि याज्ञवल्क्य ने उत्तर दिया: "हे बृहस्पति! साक्षात् वह 'अविमुक्त' (काशी/वाराणसी) क्षेत्र ही वह सच्चा कुरुक्षेत्र है जो देवताओं का पूजा-स्थल और मोक्ष का केंद्र है।"
            यहाँ 'कुरुक्षेत्र' का अर्थ महाभारत का कोई बाहरी युद्ध का मैदान नहीं है; योग विज्ञान में कुरुक्षेत्र शरीर के भीतर का वह स्थान है जहाँ ज्ञान और अज्ञान की भयंकर लड़ाई चलती है।
            'अविमुक्त' का अर्थ है वह स्थान जिसे भगवान शिव कभी नहीं छोड़ते (यानी हमारी दोनों भौंहों के बीच का आज्ञा चक्र / Third Eye)।
            जब इंसान का मन बाहरी दुनिया से हटकर 'आज्ञा चक्र' (अविमुक्त) में स्थिर हो जाता है, तो वह साक्षात् परमेश्वर के दरबार में पहुँच जाता है।
            वहाँ बैठकर किया गया हर एक छोटा सा ध्यान और कर्म देवताओं की सबसे बड़ी पूजा (देवयजनं) बन जाता है।
            चाहे दुनिया खत्म हो जाए, पर शरीर के इस 'अविमुक्त' क्षेत्र की शांति कभी नष्ट नहीं होती।
            यह श्लोक साबित करता है कि असली 'तीर्थ' या काशी ईंट और पत्थरों का शहर नहीं है; वह हमारे ही दिमाग का सबसे ऊपरी और पवित्र हिस्सा है।
            जो इंसान बाहर के मंदिरों को छोड़कर अपने भीतर के इस 'ब्रह्मसदन' में जाकर बैठता है, वह जीवन के सारे दुखों से मुक्त हो जाता है।
            यहीं से जाबाल उपनिषद की वह महान यात्रा शुरू होती है जो इंसान को सीधे संन्यास और मोक्ष के दर्शन कराती है।
        """.trimIndent(),
        english = """
            (The beginning of Jabala Upanishad): Once, Brihaspati, the preceptor of the gods, approached Sage Yajnavalkya and asked: "Which exactly is that supremely sacred 'Kurukshetra' that is the ultimate place of worship for the gods and the absolute abode of Brahman (Brahmasadanam) for all beings?"
            Sage Yajnavalkya profoundly answered: "O Brihaspati! That absolute 'Avimukta' (the holy city of Kashi/Varanasi) is indeed the true Kurukshetra, the ultimate worship ground of the gods and the direct center of Moksha."
            Here, 'Kurukshetra' absolutely does not mean the external, physical battlefield of the Mahabharata; in Yogic science, Kurukshetra is strictly that internal space where the fierce war between wisdom and ignorance actively rages.
            'Avimukta' literally translates to that exceptionally sacred space which Lord Shiva absolutely never abandons (meaning, the Ajna Chakra / Third Eye located strictly between our two eyebrows).
            When a human's restless mind completely withdraws from the external world and flawlessly anchors exactly in the 'Ajna Chakra' (Avimukta), he instantly reaches the direct court of the Supreme Lord.
            Absolutely every single act of meditation performed sitting exactly there instantly becomes the absolute highest worship of the gods (Devayajanam).
            Even if the physical world is utterly destroyed, the profound peace of this 'Avimukta' space strictly inside the body is absolutely never annihilated.
            This phenomenal verse flawlessly proves that the real 'Tirtha' or physical Kashi is absolutely not a city made of cheap bricks and stones; it is strictly the absolute highest, most sacred part of our own brain.
            That human who abandons external physical temples and seamlessly enters this 'Brahmasadanam' perfectly within himself becomes instantly freed from all worldly sorrows forever.
            Exactly from here begins the magnificent journey of the Jabala Upanishad that directly introduces a human to absolute renunciation and supreme Moksha.
        """.trimIndent()
    ),
    JabalaShloka(
        id = 2,
        sanskrit = "अत्रिरुवाच याज्ञवल्क्यम् । य एषोऽनन्तोऽव्यक्त आत्मा तं कथमहं विजानीयामिति । स होवाच याज्ञवल्क्यः । सोऽविमुक्ते उपास्यः । य एषोऽनन्तोऽव्यक्त आत्मा सोऽविमुक्ते प्रतिष्ठित इति ॥ २ ॥",
        hindi = """
            (आज्ञा चक्र का परम रहस्य): महर्षि अत्रि ने याज्ञवल्क्य से पूछा: "हे भगवन्! वह जो 'अनंत' (असीम) और 'अव्यक्त' (जो दिखाई न दे) परमात्मा है, उसे मैं अपने भीतर साक्षात् कैसे जान सकता हूँ (विजानीयाम्)?"
            महर्षि याज्ञवल्क्य ने उत्तर दिया: "उस अनंत और अव्यक्त परमात्मा की उपासना हमेशा उस 'अविमुक्त' (आज्ञा चक्र / भ्रूमध्य) क्षेत्र में ही करनी चाहिए।"
            "वह परम अनंत और निराकार आत्मा उसी अविमुक्त स्थान पर पूर्ण रूप से 'प्रतिष्ठित' (स्थापित/मौजूद) है।"
            (अत्रि ने फिर पूछा: वह अविमुक्त कहाँ है? याज्ञवल्क्य ने कहा: वह 'वरणा' और 'नासी' के बीच में है। वरणा यानी पापों को रोकने वाली, नासी यानी पापों का नाश करने वाली; शरीर में यह दोनों भौंहों और नाक का मिलन-बिंदु है)।
            यह श्लोक ध्यान योग (Meditation) का सबसे बड़ा 'लोकेशन-पिन' (Location PIN) है।
            हमेशा एक सवाल उठता है कि भगवान तो अनंत (Infinite) है, उसे शरीर के किस हिस्से में ढूँढा जाए?
            उपनिषद बिल्कुल 'सटीक' (Accurate) जवाब देता है: उस अव्यक्त भगवान का हेडक्वार्टर (Headquarter) तुम्हारी नाक के ऊपर और दोनों भौंहों के बीच में स्थित है।
            इस स्थान (Third Eye) पर अपनी चेतना को टिकाने से इंसान का अज्ञान (पाप) तुरंत नष्ट हो जाता है (नासी) और दुनिया की बुराइयां रुक (वरणा) जाती हैं।
            योगियों के लिए यह 'आज्ञा चक्र' कोई साधारण मांस का टुकड़ा नहीं है; यह वह 'स्टारगेट' (Stargate) है जहाँ से इंसान का मन सीधा यूनिवर्स (Universe) के असीम सर्वर से कनेक्ट (Connect) हो जाता है।
            जो इंसान दिन-रात अपने फोकस (Focus) को इसी 'अविमुक्त' पर टिकाकर रखता है, वह अनंत ईश्वर का साक्षात् दर्शन कर लेता है।
        """.trimIndent(),
        english = """
            (The supreme secret of the Ajna Chakra): Sage Atri asked Yajnavalkya: "O Lord! That Supreme Lord who is absolutely 'Ananta' (Infinite) and 'Avyakta' (Unmanifest/Invisible), exactly how can I directly know and realize Him (Vijaniyam) completely within myself?"
            Sage Yajnavalkya profoundly answered: "That infinite and completely unmanifest Supreme Lord must absolutely always be fiercely worshipped and intensely meditated upon strictly in that 'Avimukta' (Ajna Chakra / mid-eyebrow) region."
            "That absolute infinite, formless Supreme Soul is completely and flawlessly 'Pratishthita' (firmly established and seated) exclusively in that Avimukta space alone."
            (Atri asked again: Where exactly is this Avimukta? Yajnavalkya answered: It is strictly between the 'Varana' and 'Nasi'. Varana means that which fiercely blocks sins, Nasi means that which ruthlessly destroys sins; in the physical body, this is the exact junction of the eyebrows and the nose).
            This spectacular verse provides the absolute greatest and most precise 'Location PIN' for deep Meditation (Dhyana Yoga).
            A massive question constantly arises: Since God is entirely Infinite, in exactly which specific physical part of the body should He be searched for?
            The Upanishad fiercely provides the absolute 'Accurate' answer: The ultimate Headquarter of that invisible God is flawlessly located exactly above your nose and directly between your two eyebrows.
            By aggressively anchoring one's consciousness strictly on this specific spot (Third Eye), a human's thick ignorance (sin) is instantly destroyed (Nasi) and all worldly evils are violently blocked (Varana).
            For master Yogis, this 'Ajna Chakra' is absolutely no ordinary piece of raw flesh; it is the ultimate 'Stargate' from which the human mind connects instantly and flawlessly to the infinite Server of the Universe.
            That human who rigorously keeps his absolute Focus permanently anchored on this 'Avimukta' day and night undeniably attains the direct, living vision of the Infinite God.
        """.trimIndent()
    ),
    JabalaShloka(
        id = 3,
        sanskrit = "ब्रह्मचारिण ऊचुः । किं जप्येनामृतत्वमश्नुत इति । स होवाच याज्ञवल्क्यः । शतरुद्रियेणेति । एतानि ह वा अमृतस्य नामधेयानि । एतैर्ह वा अमृतो भवति ॥ ३ ॥",
        hindi = """
            (ब्रह्मचारियों का प्रश्न और शतरुद्रीय मंत्र): इसके बाद सभी ब्रह्मचारियों (शिष्यों) ने महर्षि याज्ञवल्क्य से एक साथ पूछा: "हे भगवन्! किस मंत्र का निरंतर जाप (जप्येन) करने से मनुष्य को परम अमरता (अमृतत्वम्) प्राप्त होती है?"
            महर्षि याज्ञवल्क्य ने उत्तर दिया: "महान 'शतरुद्रीय' (रुद्राष्टाध्यायी / भगवान शिव के परम मंत्रों) के जाप से इंसान अमर हो जाता है।"
            "यह जो शतरुद्रीय है (जिसमें 'ॐ नमः शिवाय' जैसे महान मंत्र आते हैं), ये वास्तव में साक्षात् 'अमृत' (Immortality) के ही अलग-अलग नाम हैं।"
            "केवल और केवल इन्हीं परम पवित्र मंत्रों का जाप और ध्यान करने से मनुष्य निश्चित रूप से अमर (अमृतो) हो जाता है (मृत्यु का डर खत्म हो जाता है)।"
            जाबाल उपनिषद यहाँ शिव-भक्ति और अद्वैत का बहुत ही सुंदर मिलन कर रहा है। 'अविमुक्त' (आज्ञा चक्र) भगवान शिव का स्थान है, और वहाँ शिव के ही मंत्र का ध्यान करना है।
            'शतरुद्रीय' यजुर्वेद का वह सबसे शक्तिशाली अध्याय है जिसमें भगवान रुद्र (शिव) को कण-कण में देखा गया है; यह मंत्र इंसान के अहंकार (Ego) को भस्म कर देता है।
            अमरता (अमृतत्वम्) का अर्थ यह नहीं है कि आपका यह मिट्टी का शरीर कभी नहीं मरेगा; शरीर तो मरेगा ही!
            अमरता का असली मतलब है आपके मन से 'मौत का खौफ' 100% जीरो (Zero) हो जाना।
            जब योगी इन मंत्रों (जैसे ॐ नमः शिवाय) के द्वारा अपनी चेतना को शिव (परमात्मा) में मिला देता है, तो वह जान जाता है कि "मैं वो चेतना हूँ जिसे कोई तलवार काट नहीं सकती।"
            इस ज्ञान और मंत्र के विस्फोट से इंसान इसी शरीर में रहते हुए साक्षात् भगवान का रूप बन जाता है।
        """.trimIndent(),
        english = """
            (The question of the celibates and the Satarudriya Mantra): After this, all the Brahmacharis (celibate disciples) collectively asked Sage Yajnavalkya: "O Supreme Lord! Strictly by continuously chanting (Japyena) which exact mantra does a human effortlessly attain absolute immortality (Amritatvam)?"
            Sage Yajnavalkya profoundly answered: "Strictly by intensely chanting the magnificent 'Satarudriya' (the supreme hymns of Lord Shiva from the Vedas), a human flawlessly becomes immortal."
            "This magnificent Satarudriya (which heavily encompasses supreme mantras like 'Om Namah Shivaya'), these are in absolute reality the direct, sacred names of 'Amrita' (Immortality) itself."
            "Solely and exclusively by relentlessly chanting and deeply meditating upon these exceptionally sacred mantras, a human being undoubtedly and certainly becomes permanently immortal (Amrito) (the terrifying fear of death is annihilated)."
            The Jabala Upanishad flawlessly executes an exceptionally beautiful fusion of supreme Shiva-devotion and pure Advaita right here. The 'Avimukta' (Ajna Chakra) is Lord Shiva's absolute domain, and there, one must strictly meditate purely on Shiva's mantra.
            'Satarudriya' is the absolute most terrifyingly powerful chapter of the Yajurveda where Lord Rudra (Shiva) is vividly seen in every single microscopic atom; this mantra brutally burns the human Ego to ashes.
            Immortality (Amritatvam) absolutely does not mean your physical dirt-body will never die; the body is absolutely guaranteed to die!
            The absolute true meaning of Immortality is the terrifying 'Fear of Death' dropping instantly to exactly 100% Zero from your mind forever.
            When the master Yogi completely merges his consciousness directly into Shiva (God) strictly through these supreme mantras (like Om Namah Shivaya), he flawlessly realizes: "I am that pure Consciousness which no physical sword can ever possibly cut."
            Strictly through the explosive power of this massive wisdom and mantra, the human flawlessly and literally becomes exactly the embodiment of God while still actively living in this very body.
        """.trimIndent()
    ),
    JabalaShloka(
        id = 4,
        sanskrit = "अथ हैनं जनको वैदेहो याज्ञवल्क्यमुपसमेत्योवाच । भगवन् संन्यासं ब्रूहीति । स होवाच याज्ञवल्क्यः । ब्रह्मचर्यं समाप्य गृही भवेत्... यदहरेव विरजेत्तदहरेव प्रव्रजेत् ॥ ४ ॥",
        hindi = """
            (संन्यास का सबसे बड़ा और क्रन्तिकारी नियम): विदेह-राज जनक ने महर्षि याज्ञवल्क्य के पास आकर पूछा: "हे भगवन्! कृपया मुझे सच्चे 'संन्यास' (Renunciation) का नियम और रहस्य बताइए।"
            महर्षि याज्ञवल्क्य ने कहा: "नियम तो यह है कि ब्रह्मचर्य पूरा करके इंसान को गृहस्थ (विवाहित जीवन) में प्रवेश करना चाहिए, फिर वानप्रस्थ लेना चाहिए और अंत में संन्यास लेना चाहिए।"
            "परंतु (सबसे बड़ा नियम यह है कि): जिस दिन (यदहरेव) भी इंसान के हृदय में संसार के प्रति सच्चा और भयंकर 'वैराग्य' (विरजेत् / मोह-भंग) उत्पन्न हो जाए।"
            "उसे ठीक उसी दिन (तदहरेव) बिना एक पल की भी देरी किए, सब कुछ छोड़कर संन्यास (प्रव्रजेत्) ग्रहण कर लेना चाहिए!" (चाहे वह ब्रह्मचारी हो या गृहस्थ)।
            यह जाबाल उपनिषद का सबसे 'रिवॉल्यूशनरी' (Revolutionary / बागी) श्लोक है, जिसने सनातन धर्म के सारे पारंपरिक नियमों (Traditional rules) को तोड़ दिया!
            समाज कहता है कि पहले पढ़ाई करो, फिर शादी करो, फिर बच्चे पालो, और जब बुड्ढे हो जाओ तब भगवान का नाम लो (संन्यास)।
            पर याज्ञवल्क्य डंके की चोट पर कहते हैं कि भगवान को पाने के लिए बालों के सफेद होने का इंतज़ार करना सबसे बड़ी मूर्खता है!
            मोक्ष कोई उम्र (Age) का मोहताज नहीं है; मोक्ष 'वैराग्य' (Detachment) का मोहताज है।
            अगर आपको 20 साल की उम्र में यह समझ आ गया कि "दुनिया का सारा पैसा और रिश्ते झूठ हैं, मुझे तो केवल भगवान चाहिए", तो उसी दिन सब छोड़कर संन्यास ले लो!
            सच्चा वैराग्य एक 'आग' की तरह है; जब यह आग सीने में भड़कती है, तो दुनिया की कोई भी ज़िम्मेदारी या सामाजिक नियम इंसान को बाँध कर नहीं रख सकता।
        """.trimIndent(),
        english = """
            (The absolute greatest and most revolutionary rule of Sannyasa): King Janaka of Videha approached Sage Yajnavalkya and asked: "O Lord! Please instruct me strictly on the exact rule and profound secret of true 'Sannyasa' (Absolute Renunciation)."
            Sage Yajnavalkya answered: "The traditional sequence is that after completing Brahmacharya (student life), a human must enter Grihastha (married life), then Vanaprastha (forest-dwelling), and ultimately take Sannyasa."
            "However (the absolute supreme rule is): On whatever exact day (Yadahareva) intense, burning, and terrifying 'Vairagya' (Virajet / Dispassion / complete detachment from the world) flawlessly arises in a human's heart."
            "On that very exact same day (Tadahareva), completely without delaying even for a single split-second, he must ruthlessly abandon absolutely everything and immediately take Sannyasa (Pravrajet)!" (Whether he is a celibate student or a married householder).
            This is undeniably the absolute most 'Revolutionary' and rebellious verse of the Jabala Upanishad, which violently shattered absolutely all traditional, rigid rules of Sanatana Dharma!
            Blind society dictates: first study, then aggressively marry, actively raise children, and only when you become a pathetic, useless old man should you take God's name (Sannyasa).
            But Yajnavalkya fiercely and boldly declares that foolishly waiting for your hair to turn white just to actively seek God is the absolute greatest human stupidity!
            Moksha is absolutely not a pathetic slave to physical 'Age'; Moksha is strictly and exclusively a slave to intense 'Vairagya' (Detachment).
            If at the young age of 20 you profoundly realize that "Absolutely all the money and relationships of the world are a massive lie, I desperately want only God," then ruthlessly drop absolutely everything that exact very day and take Sannyasa!
            True Vairagya is exactly like a terrifying, blazing 'Fire'; exactly when this massive fire violently erupts in the chest, absolutely no worldly responsibility or fake social rule can ever possibly bind that human anymore.
        """.trimIndent()
    ),
    JabalaShloka(
        id = 5,
        sanskrit = "अत्रिरुवाच याज्ञवल्क्यम् । अयज्ञोपवीती कथं ब्राह्मण इति । स होवाच याज्ञवल्क्यः । इदमेवाग्यं यज्ञोपवीतं य आत्मा । ... स परमहंसो नाम ॥ ५ ॥",
        hindi = """
            (सच्चा ब्राह्मण और यज्ञोपवीत): महर्षि अत्रि ने याज्ञवल्क्य से एक बहुत ही तीखा सवाल पूछा: "जो संन्यासी अपने गले में जनेऊ (यज्ञोपवीत / Sacred thread) नहीं पहनता, वह भला 'ब्राह्मण' (ज्ञानी) कैसे कहला सकता है?"
            महर्षि याज्ञवल्क्य ने अत्यंत कड़ाई से उत्तर दिया: "अरे अत्रि! यह जो शुद्ध 'आत्मा' (आत्मज्ञान) है, वही दुनिया का सबसे श्रेष्ठ और सच्चा 'यज्ञोपवीत' (इदमेवाग्यं यज्ञोपवीतं) है!"
            "संन्यासी अपने भौतिक जनेऊ और शिखा (चोटी) को काट कर ज्ञान की आग में होम कर देता है, क्योंकि उसे बाहरी दिखावे की कोई जरूरत नहीं है।"
            "जिसने अपनी आत्मा को जान लिया है, वही सच्चा ब्राह्मण है; और ऐसे ही महापुरुष को दुनिया में 'परमहंस' (Paramahamsa) कहा जाता है।"
            प्राचीन काल में कुछ अज्ञानी लोगों को लगता था कि गले में एक सूती धागा (जनेऊ) पहनने से और सिर पर चोटी रखने से वे 'पवित्र' और 'ब्राह्मण' हो गए हैं।
            याज्ञवल्क्य इस दिखावे (Show-off) और पाखंड की धज्जियां उड़ा देते हैं! वे कहते हैं कि कपड़े का धागा तो कोई भी पहन सकता है, पर क्या वह धागा इंसान के मन के लालच को मिटा सकता है?
            असली 'जनेऊ' बाहर नहीं होता, असली जनेऊ अंदर का 'ज्ञान' (Wisdom) है। जब इंसान को यह अहसास हो जाता है कि "मैं शरीर नहीं, आत्मा हूँ", तो वही उसका सबसे बड़ा श्रृंगार है।
            जो संन्यासी इस परम अवस्था को प्राप्त कर लेता है, वह किसी जाति या धर्म के बाहरी धागों का गुलाम नहीं रहता; वह इन सबसे ऊपर उठकर साक्षात् 'परमहंस' हो जाता है।
            परमहंस वह है जो समाज के बनाए हुए सारे झूठे लेबल्स (Labels) को कूड़ेदान में फेंक देता है और केवल नग्न सत्य (Naked Truth) में जीता है।
            यह श्लोक सनातन धर्म के जातिवाद और बाहरी कर्मकांडों पर एक बहुत ही भयंकर और सीधा प्रहार (Strike) है।
        """.trimIndent(),
        english = """
            (The true Brahmin and the Sacred Thread): Sage Atri asked Yajnavalkya a highly piercing question: "How on earth can a Sannyasi who absolutely does not wear the 'Yajnopavita' (Sacred thread) around his neck possibly be considered a true 'Brahmin' (wise sage)?"
            Sage Yajnavalkya answered with extreme strictness and absolute authority: "O Atri! This pure 'Soul' (Self-knowledge) itself is undeniably the world's absolute highest, most supreme, and truest 'Yajnopavita' (Idamevagyam Yajnopavitam)!"
            "A true Sannyasi ruthlessly cuts off his physical sacred cotton thread and his Shikha (tuft of hair) and violently sacrifices them entirely into the blazing fire of Wisdom, because he absolutely needs zero external show-off."
            "He who has flawlessly realized his own pure Soul is the absolute only true Brahmin; and exactly such a magnificent, great soul is profoundly called a 'Paramahamsa' in this world."
            In ancient times, highly ignorant people falsely and arrogantly believed that merely wearing a cheap cotton thread (Janeu) around their neck and keeping a tuft of hair magically made them 'pure' and 'Brahmins'.
            Yajnavalkya violently shreds this cheap Show-off and blind hypocrisy to absolute pieces! He fiercely declares that anyone can wear a cotton thread, but can that cheap thread possibly annihilate the intense greed burning in a human's mind?
            The actual, real 'Sacred Thread' is absolutely not external; the true thread is the internal 'Jnana' (Supreme Wisdom). When a human profoundly realizes "I am not the body, I am the Soul", that alone is his absolute greatest physical adornment.
            That supreme Sannyasi who successfully reaches this ultimate state absolutely never remains a pathetic slave to the external threads of any caste or religion; he rises infinitely above them all and flawlessly becomes a direct 'Paramahamsa'.
            A Paramahamsa is exactly he who ruthlessly throws absolutely all fake, hypocritical Labels created by society straight into the garbage bin and lives exclusively in the 'Naked Truth' alone.
            This phenomenal verse is an exceptionally terrifying, direct, and violent Strike against Casteism and all empty, external religious rituals in Sanatana Dharma.
        """.trimIndent()
    ),
    JabalaShloka(
        id = 6,
        sanskrit = "तत्र परमहंसा नाम संवर्तकारुणि-श्वेतकेतु-दुर्वास-ऋभु-निदाघ-दत्तात्रेय-शुक-वामदेव-हारितकप्रभृतयः । अव्यक्तलिङ्गा अव्यक्ताचारा अनुन्मत्ता उन्मत्तवदाचरन्तः... परमहंसो नामेति ॥ ६ ॥",
        hindi = """
            (परमहंस योगियों के साक्षात् लक्षण): "इस दुनिया में असली 'परमहंस' (महान संन्यासी) कौन हैं? वे हैं—संवर्तक, आरुणि, श्वेतकेतु, दुर्वासा, ऋभु, निदाघ, दत्तात्रेय, शुकदेव, वामदेव और हारितक आदि महान ऋषि।"
            "इन परमहंसों की कोई भी 'व्यक्त पहचान' (अव्यक्तलिङ्गा / कोई खास कपड़े या तिलक) नहीं होती; इनका आचरण (अव्यक्ताचारा) समाज के लोगों की समझ से बिल्कुल बाहर होता है।"
            "ये अंदर से पूरी तरह शांत और ज्ञान से भरे (अनुन्मत्ता) होते हैं, परंतु बाहर की दुनिया में ये बिल्कुल एक 'पागल इंसान' (उन्मत्तवत् / Madman) की तरह व्यवहार (आचरन्तः) करते हैं।"
            "ये महापुरुष सब कुछ त्याग कर केवल अपनी आत्मा (ब्रह्म) में ही 24 घंटे मस्त रहते हैं; इन्ही को वास्तव में सच्चा 'परमहंस' (परमहंसो नामेति) कहा जाता है।"
            यह जाबाल उपनिषद का सबसे अंतिम और सबसे 'क्रांतिकारी' (Rebellious) श्लोक है, जो एक जीवनमुक्त इंसान का असली हुलिया (Lifestyle) बताता है।
            दुनिया सोचती है कि संन्यासी वह है जो भगवा कपड़े पहने, बड़ी दाढ़ी रखे और मंदिर में बैठकर प्रवचन दे!
            पर उपनिषद कहता है कि दत्तात्रेय, दुर्वासा और शुकदेव जैसे 'असली' परमहंस कभी भी अपना 'ब्रैंडिंग' (Branding/दिखावा) नहीं करते। वे नंगे घूम सकते हैं, फटे कपड़ों में रह सकते हैं।
            वे दुनिया वालों को 'पागल' (उन्मत्त) लगते हैं, क्योंकि वे समाज के झूठे नियमों (पैसे कमाना, इज्जत पाना) को लात मार चुके होते हैं।
            वे कभी किसी को इम्प्रेस (Impress) करने की कोशिश नहीं करते; अगर कोई उन्हें गाली दे तो वे हँसते हैं, और कोई तारीफ करे तो भी वे हँसते हैं।
            उनका 'मैं' (Ego) 100% मर चुका है, और वे साक्षात् 'भगवान' बनकर इस धरती पर आज़ाद घूमते हैं। यहीं पर यह महान 'जाबाल उपनिषद' पूर्ण होता है! ॐ शांतिः!
        """.trimIndent(),
        english = """
            (The direct characteristics of Paramahamsa Yogis): "Who exactly are the real, authentic 'Paramahamsas' (Supreme Sannyasis) in this world? They are the magnificent sages like—Samvartaka, Aruni, Shvetaketu, Durvasa, Ribhu, Nidagha, Dattatreya, Shukadeva, Vamadeva, and Haritaka."
            "These ultimate Paramahamsas possess absolutely no 'visible external marks' (Avyaktalinga / no specific robes, beads, or tilaks); their exact conduct (Avyaktachara) lies completely, flawlessly beyond the petty understanding of worldly society."
            "They are completely, perfectly tranquil and profoundly filled with supreme wisdom entirely from the inside (Anunmatta), yet in the external world, they actively behave and act exactly like a completely 'Madman' (Unmattavat)."
            "These colossal great souls, having ruthlessly abandoned absolutely everything, remain completely intoxicated and fully absorbed exclusively in their own Soul (Brahman) 24 hours a day; they, and strictly they alone, are genuinely called true 'Paramahamsas' (Paramahamso nameti)."
            This is undeniably the absolute final and most fiercely 'Rebellious' verse of the Jabala Upanishad, explicitly revealing the true, raw Lifestyle of a fully Jivanmukta human.
            The ignorant world foolishly thinks a Sannyasi is someone who aggressively wears saffron robes, keeps a massive beard, and sits importantly in temples giving grand speeches!
            But the Upanishad fiercely declares that 'Real' Paramahamsas like Dattatreya, Durvasa, and Shukadeva absolutely never, ever do any cheap 'Branding' (Show-off). They might effortlessly roam completely naked or live happily in torn, dirty rags.
            They vividly appear absolutely 'Mad' (Unmatta) to worldly people, strictly because they have ruthlessly kicked away and brutally rejected all fake, hypocritical rules of society (like obsessively earning money or fiercely demanding respect).
            They absolutely never attempt to 'Impress' anyone; if someone aggressively hurls harsh insults at them, they simply laugh, and if someone showers them with grand praise, they still simply laugh.
            Their 'I' (Ego) is 100% permanently dead, and they casually roam completely free on this earth exactly as the direct, living embodiment of 'God' Himself. Right here, this exceptionally magnificent 'Jabala Upanishad' achieves absolute, flawless completion! OM Peace!
        """.trimIndent()
    )
)