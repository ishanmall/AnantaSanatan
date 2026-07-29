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
data class KaivalyaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KaivalyaUpanishadScreen() {
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
                if (shlokaNumber != null && shlokaNumber in 1..26) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-26)") },
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
            itemsIndexed(kaivalyaShlokasList) { _, shloka ->
                KaivalyaShlokaCard(shloka)
            }
        }
    }
}

@Composable
fun KaivalyaShlokaCard(shloka: KaivalyaShloka) {
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


val kaivalyaShlokasList = listOf(
    KaivalyaShloka(
        id = 1,
        sanskrit = "अथाश्वलायनो भगवन्तं परमेष्ठिनमुपसमेत्योवाच । अधीहि भगवन् ब्रह्मविद्यां वरिष्ठां सदा सद्भिः सेव्यमानां निगूढाम् । ययाऽचिरात् सर्वपापं व्यपोह्य परात्परं पुरुषं याति विद्वान् ॥ १ ॥",
        hindi = """
            एक बार महर्षि आश्वलायन भगवान परमेष्ठी (ब्रह्मा जी) के पास गए और उनसे विनम्रतापूर्वक बोले।
            'हे भगवन्! कृपया मुझे उस सबसे श्रेष्ठ और गुप्त ब्रह्मविद्या का उपदेश प्रदान करें।'
            'वह विद्या जिसका सेवन (अभ्यास) हमेशा सज्जन और ज्ञानी पुरुषों द्वारा किया जाता है।'
            'जिस विद्या के प्रभाव से विद्वान पुरुष बहुत ही शीघ्र अपने सभी पापों और कर्मों को नष्ट कर देता है।'
            'और उस विद्या के माध्यम से वह उस परात्पर (श्रेष्ठ से भी श्रेष्ठ) परम पुरुष को प्राप्त कर लेता है।'
            यह कैवल्य उपनिषद का आरंभ है जो एक साधक की तीव्र मुमुक्षा (मोक्ष की इच्छा) को दर्शाता है।
            ब्रह्मा जी सृष्टि के रचयिता हैं, इसलिए उन्हें ज्ञान का सबसे प्रामाणिक स्रोत माना गया है।
            आश्वलायन यह स्पष्ट कर रहे हैं कि उन्हें संसार का कोई सुख नहीं, बल्कि सर्वोच्च सत्य चाहिए।
            पापों का नाश कोई भौतिक प्रक्रिया नहीं, बल्कि अज्ञान के अंधकार का हमेशा के लिए मिट जाना है।
            यह श्लोक गुरु के प्रति पूर्ण समर्पण और विद्या के प्रति अत्यंत सम्मान को स्थापित करता है।
        """.trimIndent(),
        english = """
            Once, Sage Ashvalayana approached Lord Paramesthi (Brahma) and spoke with deep humility.
            'O Venerable Sir! Please teach me that most excellent and profoundly hidden Brahmavidya.'
            'That supreme knowledge which is constantly sought after and practiced by the righteous.'
            'By which a wise man very quickly completely destroys all his sins and karmic bonds.'
            'And through which he directly attains the Supreme Person, who is greater than the greatest.'
            This is the beginning of Kaivalya Upanishad, showcasing a seeker's intense desire for Moksha.
            Lord Brahma is the creator, hence considered the most authentic source of cosmic wisdom.
            Ashvalayana makes it clear that he seeks no worldly joy, but only the absolute Truth.
            The destruction of sins is not a physical process but the permanent eradication of ignorance.
            This verse establishes total surrender to the Guru and absolute reverence for divine knowledge.
        """.trimIndent()
    ),
    KaivalyaShloka(
        id = 2,
        sanskrit = "तस्मै स होवाच पितामहश्च श्रद्धाभक्तिध्यानयोगादवैहि । न कर्मणा न प्रजया धनेन त्यागेनैके अमृतत्वमानशुः ॥ २ ॥",
        hindi = """
            तब सृष्टि के पितामह ब्रह्मा जी ने महर्षि आश्वलायन से अत्यंत प्रेमपूर्वक कहा।
            'तुम उस परब्रह्म को श्रद्धा, भक्ति और ध्यान-योग के माध्यम से जानने का प्रयास करो।'
            'सत्य को न तो केवल कर्मकाण्डों से पाया जा सकता है, न संतान से और न ही धन से।'
            'केवल और केवल पूर्ण त्याग (संन्यास) के द्वारा ही कुछ विरले लोगों ने अमृतत्व को प्राप्त किया है।'
            यह श्लोक मोक्ष के लिए आवश्यक साधनों और बाधाओं को बिल्कुल स्पष्ट कर देता है।
            श्रद्धा (विश्वास) नींव है, भक्ति (प्रेम) दीवारें हैं, और ध्यान (एकाग्रता) ज्ञान की छत है।
            धन और संतान सांसारिक जीवन को सुरक्षित कर सकते हैं, पर वे आत्मा को मुक्त नहीं कर सकते।
            त्याग का अर्थ दुनिया छोड़ना नहीं, बल्कि दुनिया से अपनी आसक्ति (Attachment) को छोड़ना है।
            अमृतत्व वह स्थिति है जहाँ मृत्यु का भय और अज्ञान हमेशा के लिए समाप्त हो जाता है।
            पितामह का यह उपदेश साधक को बाहरी कर्मों से हटाकर आंतरिक शुद्धि की ओर ले जाता है।
        """.trimIndent(),
        english = """
            Then the Grandfather of the universe, Lord Brahma, lovingly replied to Sage Ashvalayana.
            'Seek to know that Supreme Brahman through faith, devotion, and the yoga of meditation.'
            'Truth cannot be attained merely by rituals, nor by progeny, nor by the accumulation of wealth.'
            'Only through absolute renunciation (Tyaga) have a rare few attained true Immortality.'
            This verse completely clarifies the necessary tools and the obstacles on the path to Moksha.
            Faith is the foundation, devotion is the walls, and meditation is the roof of wisdom.
            Wealth and progeny may secure earthly life, but they can never liberate the soul.
            Renunciation does not mean abandoning the world, but dropping one's attachment to it.
            Immortality is that supreme state where the fear of death and ignorance ends forever.
            The Grandfather's teaching redirects the seeker from external actions to internal purity.
        """.trimIndent()
    ),
    KaivalyaShloka(
        id = 3,
        sanskrit = "परेण नाकं निहितं गुहायां विभ्राजते यद्यतयो विशन्ति । वेदान्तविज्ञानसुनिश्चितार्थाः संन्यासयोगाद् यतयः शुद्धसत्त्वाः ॥ ३ ॥",
        hindi = """
            वह परम सत्य स्वर्ग से भी परे है, जो हर प्राणी के हृदय रूपी गुफा में स्थित होकर चमक रहा है।
            उस परम प्रकाश में वे ही संन्यासी प्रवेश कर पाते हैं जिन्होंने इंद्रियों को जीत लिया है (यति)।
            वे यति जिन्होंने वेदान्त के विज्ञान से जीवन के परम लक्ष्य को पूरी तरह से सुनिश्चित कर लिया है।
            और जो संन्यास योग (पूर्ण त्याग) के अभ्यास से अपने अंतःकरण को अत्यंत शुद्ध (शुद्धसत्त्व) कर चुके हैं।
            यह श्लोक मुण्डक उपनिषद की गूंज है, जो वेदान्त और संन्यास के महत्व को एक साथ जोड़ता है।
            स्वर्ग कोई अंतिम मंजिल नहीं है; असली सत्य स्वर्ग के भी परे (परेण नाकं) स्थित है।
            हृदय की गुफा वह रहस्यमयी जगह है जहाँ ईश्वर और जीव का साक्षात् मिलन होता है।
            वेदान्त विज्ञान का अर्थ है उपनिषदों के महावाक्यों पर मनन करके सत्य का तार्किक अनुभव करना।
            जब चित्त पूरी तरह पारदर्शी हो जाता है, तभी उसमें परमात्मा का प्रकाश निर्बाध रूप से झलकता है।
            मुक्ति कोई संयोग नहीं है, यह एक सुनिश्चित और वैज्ञानिक आध्यात्मिक प्रक्रिया का अंतिम परिणाम है।
        """.trimIndent(),
        english = """
            That Supreme Truth is beyond heaven, shining brilliantly hidden in the cave of the heart.
            Into that supreme light, only those ascetics (Yatis) enter who have mastered their senses.
            Those Yatis who have firmly ascertained the ultimate goal of life through the science of Vedanta.
            And who have made their inner being completely pure (Shuddhasattva) through the yoga of renunciation.
            This verse echoes the Mundaka Upanishad, linking the importance of Vedanta and Sannyasa.
            Heaven is not the final destination; the real Truth exists far beyond heaven (Parena Nakam).
            The cave of the heart is the mystical space where God and the individual soul directly meet.
            The science of Vedanta means logically experiencing Truth by contemplating Upanishadic dictums.
            When the mind becomes completely transparent, the light of God reflects in it without obstruction.
            Liberation is no accident; it is the final result of a certain and scientific spiritual process.
        """.trimIndent()
    ),
    KaivalyaShloka(
        id = 4,
        sanskrit = "ते ब्रह्मलोकेषु परान्तकाले परामृताः परिमुच्यन्ति सर्वे । विविक्तदेशे च सुखासनस्थः शुचिः समग्रीवशिरःशरीरः ॥ ४ ॥",
        hindi = """
            वे सभी शुद्ध अंतःकरण वाले यति मृत्यु के अंतिम समय में उस परम ब्रह्मलोक को प्राप्त करते हैं।
            वे परमामृत (अविनाशी परमात्मा) के साथ एक होकर जन्म-मरण के चक्र से हमेशा के लिए मुक्त हो जाते हैं।
            अब ब्रह्मा जी ध्यान की विधि बताते हैं: साधक को किसी एकांत और शांत स्थान (विविक्त देश) पर जाना चाहिए।
            वहाँ उसे एक सुखदायक आसन (सुखासन) पर पवित्र होकर अत्यंत स्थिर भाव से बैठना चाहिए।
            उसे अपनी गर्दन, सिर और शरीर को बिल्कुल सीधा (एक सीध में) रखकर ध्यान मग्न होना चाहिए।
            मोक्ष प्राप्ति के लिए सैद्धांतिक ज्ञान के साथ-साथ प्रायोगिक ध्यान (Practical Meditation) बहुत जरूरी है।
            एकांत स्थान मन को बाहरी दुनिया के शोर और भटकाव से बचाने में बहुत मदद करता है।
            शरीर का सीधा होना रीढ़ की हड्डी (सुषुम्ना नाड़ी) में ऊर्जा के मुक्त प्रवाह को सुनिश्चित करता है।
            अंतिम समय (परान्तकाल) में मुक्ति का अर्थ है कि भौतिक शरीर के गिरते ही चेतना अनंत में मिल जाती है।
            यह श्लोक योग शास्त्र के मूलभूत नियमों को वेदान्त के दर्शन के साथ बहुत सुंदरता से मिलाता है।
        """.trimIndent(),
        english = """
            All those pure-hearted ascetics attain the supreme Brahmaloka at the final moment of death.
            Becoming one with the Supreme Immortal, they are liberated from the cycle of birth and death forever.
            Now Brahma explains the method of meditation: The seeker should go to a secluded, quiet place.
            There, he should sit in a comfortable posture (Sukhasana), completely pure and extremely steady.
            He should keep his neck, head, and body perfectly erect in a straight line, absorbed in meditation.
            For Moksha, practical meditation is absolutely essential along with theoretical knowledge.
            A secluded place helps immensely in protecting the mind from the noise and distractions of the world.
            An erect body ensures the free flow of spiritual energy through the spine (Sushumna Nadi).
            Liberation at the 'final moment' means consciousness merges into infinity as soon as the body falls.
            This verse beautifully blends the fundamental rules of Yoga with the philosophy of Vedanta.
        """.trimIndent()
    ),

    KaivalyaShloka(
        id = 5,
        sanskrit = "अत्याश्रमस्थः सकलेन्द्रियाणि निरुध्य भक्त्या स्वगुरुं प्रणम्य । हृत्पुण्डरीकं विरजं विशुद्धं विचिन्त्य मध्ये विशदं विशोकम् ॥ ५ ॥",
        hindi = """
            साधक को सन्यास (अत्याश्रम) की अवस्था में स्थित होकर अपनी सभी इंद्रियों को पूरी तरह वश में करना चाहिए।
            उसे अपनी संपूर्ण भक्ति और प्रेम के साथ अपने सद्गुरु को मानसिक या शारीरिक रूप से प्रणाम करना चाहिए।
            इसके बाद उसे अपने हृदय रूपी कमल (हृत्पुण्डरीक) का ध्यान करना चाहिए, जो अत्यंत निर्मल और विशुद्ध है।
            उस हृदय कमल के ठीक मध्य में उस परब्रह्म का चिंतन करना चाहिए जो प्रकाशमान और शोकरहित है।
            गुरु को प्रणाम करना अहंकार को तोड़ने और ज्ञान के प्रवाह को जोड़ने की सबसे महत्वपूर्ण चाबी है।
            इंद्रियों को वश में किए बिना किया गया ध्यान केवल एक मानसिक कल्पना बनकर रह जाता है।
            हृदय को यहाँ एक खिले हुए कमल के रूप में दर्शाया गया है, जो पवित्रता और आध्यात्मिक जाग्रति का प्रतीक है।
            ईश्वर कोई बाहरी व्यक्ति नहीं, बल्कि हमारे ही हृदय के केंद्र में बैठी हुई शोकरहित (विशोक) चेतना है।
            यह श्लोक ध्यान की आंतरिक प्रक्रिया को स्पष्ट करता है—बाहर से कटकर भीतर की ओर मुड़ना।
            जब हृदय निर्मल (विरज) होता है, तभी उसमें परमात्मा की छवि स्पष्ट और पूर्ण रूप से दिखाई देती है।
        """.trimIndent(),
        english = """
            Established in the state of renunciation (Atyashrama), the seeker must completely control all his senses.
            With utmost devotion and love, he should bow down mentally or physically to his true Guru.
            Thereafter, he should meditate on the lotus of his heart, which is totally immaculate and utterly pure.
            In the center of that lotus, he should contemplate the Supreme Brahman, who is luminous and free from sorrow.
            Bowing to the Guru is the most important key to breaking the ego and connecting to the flow of wisdom.
            Meditation done without controlling the senses remains merely a mental imagination.
            The heart is depicted here as a blooming lotus, symbolizing purity and deep spiritual awakening.
            God is not an external entity, but the sorrow-less (Vishoka) consciousness seated at the center of our heart.
            This verse clarifies the internal process of meditation—disconnecting from outside and turning inward.
            Only when the heart is immaculate (Viraja) does the image of the Divine appear clearly and completely in it.
        """.trimIndent()
    ),
    KaivalyaShloka(
        id = 6,
        sanskrit = "अचिन्त्यमव्यक्तमनन्तरूपं शिवं प्रशान्तं अमृतं ब्रह्मयोनिम् । तमादिमध्यान्तविहीनमेकं विभुं चिदानन्दमरूपमद्भुतम् ॥ ६ ॥",
        hindi = """
            वह परमात्मा मन के चिंतन से परे (अचिन्त्य), इंद्रियों से प्रकट न होने वाला (अव्यक्त) और अनंत रूपों वाला है।
            वह परम कल्याणकारी (शिव), पूर्णतः शांत, मरण-रहित (अमृत) और संपूर्ण सृष्टि का एकमात्र कारण (ब्रह्मयोनि) है।
            उसका न कोई आदि (शुरुआत) है, न कोई मध्य है और न ही उसका कोई अंत हो सकता है; वह केवल एक ही है।
            वह सर्वव्यापक (विभु), विशुद्ध चेतना और आनंद का स्वरूप (चिदानंद), निराकार (अरूप) और अत्यंत अद्भुत है।
            इस श्लोक में भगवान शिव (सगुण) को ही परब्रह्म (निर्गुण) के रूप में पूर्णता के साथ स्थापित किया गया है।
            अचिन्त्य होने का अर्थ है कि उसे हमारी सीमित बुद्धि कभी भी अपनी धारणाओं में नहीं बांध सकती।
            वह अरूप (बिना आकार का) होकर भी अनंत रूपों में इस ब्रह्मांड में हमारे सामने प्रकट हो रहा है।
            आदि-मध्य-अंत विहीन होने का अर्थ है कि वह समय की सीमाओं से पूरी तरह परे (Timeless) है।
            यह श्लोक ध्यान के लिए ईश्वर का एक अत्यंत विराट, शांत और रहस्यमयी खाका (Blueprint) प्रदान करता है।
            अद्भुत शब्द बताता है कि जब साधक उसे जानता है, तो वह आश्चर्य और परमानंद से पूरी तरह भर जाता है।
        """.trimIndent(),
        english = """
            That Supreme is beyond mental thought (Achintya), unmanifest to the senses (Avyakta), and of infinite forms.
            He is completely auspicious (Shiva), perfectly tranquil, immortal, and the sole source of creation (Brahmayoni).
            He has no beginning, no middle, and can have no end whatsoever; He is the absolute One.
            He is all-pervading (Vibhu), pure consciousness and bliss (Chidananda), formless (Arupa), and truly wonderful.
            In this verse, Lord Shiva (with attributes) is perfectly established as the Supreme Brahman (without attributes).
            Being Achintya means our limited intellect can never confine Him within its concepts.
            Despite being formless (Arupa), He is manifesting before us in infinite forms throughout this universe.
            Having no beginning, middle, or end means He is completely beyond the limitations of time (Timeless).
            This verse provides a tremendously vast, tranquil, and mystical blueprint of God for meditation.
            The word 'wonderful' (Adbhuta) shows that upon knowing Him, the seeker is filled with absolute awe and bliss.
        """.trimIndent()
    ),

    KaivalyaShloka(
        id = 7,
        sanskrit = "उमासहायं परमेश्वरं प्रभुं त्रिलोचनं नीलकण्ठं प्रशान्तम् । ध्यात्वा मुनिर्गच्छति भूतयोनिं समस्तसाक्षिं तमसः परस्तात् ॥ ७ ॥",
        hindi = """
            वह मुनि जो माता उमा (पार्वती) के साथ विराजमान परमेश्वर, सर्वसमर्थ प्रभु का गहराई से ध्यान करता है।
            उन प्रभु के तीन नेत्र हैं, उनका कंठ नीला है और वे अत्यंत शांत और सौम्य मुद्रा में स्थित हैं।
            इस प्रकार सगुण रूप का ध्यान करके वह मुनि उस परम तत्व (भूतयोनि) को प्राप्त कर लेता है जो सबका कारण है।
            वह परमात्मा जो संपूर्ण सृष्टि का साक्षी (दृष्टा) है और जो अज्ञान के अंधकार से पूरी तरह परे (तमसः परस्तात्) है।
            कैवल्य उपनिषद यहाँ सगुण भक्ति (रूप का ध्यान) को निर्गुण ज्ञान (निराकार की प्राप्ति) का साधन बताता है।
            उमासहायं का अर्थ है कि शिव (चेतना) और उमा (शक्ति/प्रकृति) कभी एक-दूसरे से अलग नहीं हैं।
            त्रिलोचन (तीन आँखें) भूत, वर्तमान और भविष्य को एक साथ देखने वाली ज्ञान-दृष्टि का प्रतीक है।
            नीलकंठ होना यह सिखाता है कि ईश्वर संसार के विष (दुख) को पीकर भी शांत और स्थिर रह सकता है।
            साक्षी भाव का अर्थ है संसार के नाटक को देखना पर उसमें उलझना नहीं, यही मोक्ष की स्थिति है।
            अंधकार के पार जाने का मतलब है अज्ञान की रात का खत्म होना और आत्मज्ञान के सूर्य का उदय होना।
        """.trimIndent(),
        english = """
            The sage who deeply meditates upon the Supreme Lord, the all-powerful Master accompanied by Mother Uma.
            That Lord who has three eyes, a blue neck, and is situated in an extremely peaceful and gentle state.
            By meditating on this manifested form, the sage attains the Supreme Principle (Bhutayoni), the cause of all.
            That Supreme Being who is the Witness of the entire creation and is entirely beyond the darkness of ignorance.
            Kaivalya Upanishad here presents devotion to the manifested form as a means to attain the formless Reality.
            'Umasahayam' signifies that Shiva (Consciousness) and Uma (Power/Nature) are never separate from each other.
            'Trilochana' (three eyes) symbolizes the vision of wisdom that sees past, present, and future simultaneously.
            Being 'Nilakantha' teaches that God can drink the poison (sorrow) of the world and still remain calm.
            The Witness state means observing the drama of the world without getting entangled; this is Moksha.
            Going beyond darkness implies the end of the night of ignorance and the rising of the sun of Self-knowledge.
        """.trimIndent()
    ),
    KaivalyaShloka(
        id = 8,
        sanskrit = "स ब्रह्मा स शिवः सेन्द्रः सोऽक्षरः परमः स्वराट् । स एव विष्णुः स प्राणः स कालोऽग्निः स चन्द्रमाः ॥ ८ ॥",
        hindi = """
            वही परम तत्व ब्रह्मा है, वही शिव है और वही देवताओं का राजा इंद्र भी है।
            वही अविनाशी (अक्षर) है, वही सबसे श्रेष्ठ है और वह स्वयं ही अपना स्वामी (स्वराट्) है।
            वही भगवान विष्णु है, वही जीवन देने वाला प्राण है, वही सब कुछ नष्ट करने वाला काल है।
            वही अग्नि है, और वही शीतलता प्रदान करने वाला चंद्रमा भी है; सब कुछ वही एक है।
            यह श्लोक हिंदू धर्म की सभी देवताओं की बहुलता को एक ही परम सत्य में समेट लेता है।
            ईश्वर के अलग-अलग नाम केवल उसके अलग-अलग कार्यों (रचना, पालन, संहार) के कारण हैं।
            स्वराट् का अर्थ है कि ईश्वर किसी बाहरी सत्ता के अधीन नहीं है, वह पूर्णतः स्वतंत्र है।
            जब साधक को यह अद्वैत ज्ञान हो जाता है, तो उसके लिए सभी धार्मिक मतभेद हमेशा के लिए खत्म हो जाते हैं।
            सृष्टि की हर ऊर्जा, चाहे वह जलाने वाली अग्नि हो या प्राणदायिनी वायु, उसी का एक रूप है।
            यह उपनिषद की 'एकमेवाद्वितीयम्' (वह एक ही है, दूसरा नहीं) की महान घोषणा है।
        """.trimIndent(),
        english = """
            That Supreme Principle alone is Brahma, He is Shiva, and He is also Indra, the king of gods.
            He is the Imperishable (Akshara), He is the Supreme, and He is His own absolute Master (Svarat).
            He Himself is Lord Vishnu, He is the life-giving Prana, and He is Time that destroys all.
            He is the Fire, and He is also the cooling Moon; absolutely everything is that One alone.
            This verse beautifully collapses the plurality of all Hindu deities into one single Supreme Truth.
            The different names of God are merely due to His different cosmic functions (creation, preservation, destruction).
            'Svarat' means God is not subject to any external authority; He is completely independent.
            When a seeker attains this non-dual knowledge, all religious differences vanish for him forever.
            Every energy in creation, whether it is burning fire or life-giving breath, is just a form of Him.
            This is the grand Upanishadic declaration of 'Ekam evadvitiyam' (He is One without a second).
        """.trimIndent()
    ),
    KaivalyaShloka(
        id = 9,
        sanskrit = "स एव सर्वं यद्भूतं यच्च भव्यं सनातनम् । ज्ञात्वा तं मृत्युमत्येति नान्यः पन्था विमुक्तये ॥ ९ ॥",
        hindi = """
            अतीत में जो कुछ भी उत्पन्न हुआ था और भविष्य में जो कुछ भी उत्पन्न होगा, वह सब वही है।
            वह परमात्मा ही एकमात्र सनातन (हमेशा रहने वाला) और अपरिवर्तनीय सत्य है।
            उस एक परब्रह्म को सही तरीके से जानकर ही मनुष्य मृत्यु के भय को पार कर सकता है।
            पूर्ण विमुक्ति (मोक्ष) प्राप्त करने के लिए इसके अलावा और कोई दूसरा मार्ग नहीं है।
            समय (भूत, वर्तमान, भविष्य) केवल हमारी बुद्धि का भ्रम है, ईश्वर समय की सीमाओं से बाहर है।
            संसार की हर वस्तु बदलती है और नष्ट होती है, पर वह सनातन तत्व हमेशा एक सा रहता है।
            मृत्यु को पार करने का अर्थ शारीरिक रूप से अमर होना नहीं, बल्कि आत्मा की अमरता का अनुभव करना है।
            केवल कर्मकाण्ड, दान या तीर्थयात्राएं मनुष्य को जीवन-मरण के चक्र से मुक्त नहीं कर सकतीं।
            सत्य का साक्षात् ज्ञान ही वह अकेली नाव है जो इस भवसागर से पार लगा सकती है।
            यह श्लोक श्वेताश्वतर उपनिषद की गूंज है, जो ज्ञान मार्ग की सर्वोच्चता को पूरी तरह स्थापित करता है।
        """.trimIndent(),
        english = """
            Whatever was born in the past and whatever will be born in the future, He is all of that.
            That Supreme Lord is the only eternal (Sanatana) and unchanging Truth in existence.
            Only by truly knowing that one Supreme Brahman can man cross over the fear of death.
            There is absolutely no other path available for attaining complete liberation (Moksha).
            Time (past, present, future) is merely an illusion of our intellect; God is outside the limits of time.
            Everything in the world changes and perishes, but that eternal Principle remains forever the same.
            Crossing death does not mean physical immortality, but experiencing the immortality of the Soul.
            Mere rituals, charity, or pilgrimages cannot free a person from the cycle of birth and death.
            The direct realization of Truth is the only boat that can cross this turbulent ocean of existence.
            This verse echoes the Svetashvatara Upanishad, firmly establishing the supremacy of the path of knowledge.
        """.trimIndent()
    ),
    KaivalyaShloka(
        id = 10,
        sanskrit = "सर्वभूतस्थमात्मानं सर्वभूतानि चात्मनि । सम्पश्यन् ब्रह्म परमं याति नान्येन हेतुना ॥ १० ॥",
        hindi = """
            जो साधक अपनी आत्मा को ब्रह्मांड के सभी छोटे-बड़े प्राणियों के भीतर समान रूप से देखता है।
            और जो संपूर्ण प्राणियों को और इस जगत को अपनी ही आत्मा के भीतर स्थित देखता है।
            इस प्रकार का समदर्शी विजन (Vision) रखने वाला ही उस परम ब्रह्म को प्राप्त करता है।
            ब्रह्म को प्राप्त करने का इसके अलावा और कोई दूसरा साधन या कारण बिल्कुल नहीं है।
            यह श्लोक भगवद्गीता के दर्शन का मूल आधार है—सबमें स्वयं को और स्वयं में सबको देखना।
            जब तक मन में 'मैं अलग हूँ और दुनिया अलग है' का भेद रहता है, तब तक मुक्ति असंभव है।
            अहंकार ही वह दीवार है जो हमें दूसरों से अलग करती है; ज्ञान इस दीवार को गिरा देता है।
            जब इंसान सबमें अपनी ही आत्मा को देखता है, तो वह किसी से घृणा या ईर्ष्या नहीं कर सकता।
            यही वह अंतिम आध्यात्मिक दृष्टि है जहाँ दया और प्रेम स्वाभाविक रूप से बहने लगते हैं।
            मुक्ति कोई स्थान नहीं है जहाँ जाना है, बल्कि यह देखने के नजरिए (Perspective) का पूर्ण बदलाव है।
        """.trimIndent(),
        english = """
            The seeker who sees his own Self equally residing in all great and small beings of the universe.
            And who clearly sees all beings and this entire world situated within his own Self.
            Only the one holding such an egalitarian vision attains that Supreme Brahman.
            There is absolutely no other means or cause whatsoever for attaining the Supreme.
            This verse is the foundational philosophy of the Bhagavad Gita—seeing oneself in all and all in oneself.
            As long as the mind holds the distinction 'I am separate and the world is separate', liberation is impossible.
            Ego is the wall that separates us from others; true spiritual wisdom demolishes this wall.
            When a person sees his own soul in everyone, he can no longer hate or envy anyone.
            This is the ultimate spiritual vision where compassion and love begin to flow completely naturally.
            Liberation is not a place to go, but a complete transformation of one's perspective of seeing.
        """.trimIndent()
    ),

    KaivalyaShloka(
        id = 11,
        sanskrit = "आत्मानमरणिं कृत्वा प्रणवं चोत्तराणिम् । ज्ञाननिर्मथनाभ्यासात् पाशं दहति पण्डितः ॥ ११ ॥",
        hindi = """
            साधक को अपनी जीवात्मा को नीचे की अरणि (आग जलाने वाली लकड़ी) बनाना चाहिए।
            और ॐ (प्रणव) रूपी मंत्र को ऊपर की अरणि बनाकर निरंतर घर्षण करना चाहिए।
            इस प्रकार ज्ञान रूपी मंथन (मथने की क्रिया) के लगातार अभ्यास के द्वारा।
            बुद्धिमान पंडित (विद्वान) अपने सभी अज्ञान रूपी पाशों (बंधनों) को जलाकर भस्म कर देता है।
            प्राचीन काल में दो लकड़ियों को रगड़कर आग पैदा की जाती थी, जिसे अरणि मंथन कहते थे।
            यहाँ शरीर और ॐ के बीच ध्यान का गहरा घर्षण (Concentration) आग पैदा करता है।
            यह आग कोई भौतिक आग नहीं, बल्कि ज्ञान की वह ज्योति है जो भ्रम को मिटाती है।
            'पाश' का अर्थ है वे मानसिक जंजीरें—काम, क्रोध, लोभ—जो हमें संसार से बाँधे रखती हैं।
            लगातार अभ्यास (Practice) के बिना ज्ञान का प्रकटीकरण असंभव है, केवल बातें काम नहीं आतीं।
            यह श्लोक ध्यान और मंत्र-जाप के विज्ञान को एक बहुत ही सुंदर और व्यावहारिक उपमा से समझाता है।
        """.trimIndent(),
        english = """
            The seeker should make his individual soul the lower Arani (the wood block used for making fire).
            And he should make the Pranava (OM) mantra the upper Arani to create continuous friction.
            Through the constant and diligent practice of this churning in the form of knowledge.
            The wise scholar completely burns down to ashes all his bonds (Pasha) of ignorance.
            In ancient times, fire was created by rubbing two pieces of wood, called Arani churning.
            Here, the deep friction (concentration) of meditation between the body and OM creates fire.
            This fire is not a physical flame, but the light of wisdom that destroys all illusions.
            'Pasha' means those mental chains—lust, anger, greed—that keep us bound to the world.
            Without continuous practice, the manifestation of knowledge is impossible; mere words do not work.
            This verse explains the science of meditation and mantra chanting with a very beautiful, practical metaphor.
        """.trimIndent()
    ),
    KaivalyaShloka(
        id = 12,
        sanskrit = "स एव मायापरिमोहितात्मा शरीरमास्थाय करोति सर्वम् । स्त्र्यन्नपानादिविचित्रभोगैः स एव जाग्रत्परितृप्तिमेति ॥ १२ ॥",
        hindi = """
            वह परब्रह्म ही अपनी माया (अज्ञान) से मोहित होकर जीवात्मा का रूप धारण कर लेता है।
            और यह भौतिक शरीर धारण करके संसार के सभी कर्मों और गतिविधियों को करने लगता है।
            जाग्रत अवस्था (जागते हुए) में वह स्त्री, अन्न, पान (पेय) आदि अनेक विचित्र भोगों का अनुभव करता है।
            और इन्हीं भौतिक सांसारिक सुखों को भोगकर वह परम तृप्ति का अनुभव करता है।
            ईश्वर और जीव में कोई अंतर नहीं है; जीव केवल वह ईश्वर है जो माया के प्रभाव में सो गया है।
            माया वह शक्ति है जो हमें हमारी अनंतता भुलवाकर एक छोटे से शरीर तक सीमित कर देती है।
            जागृत अवस्था में हमारी इंद्रियां बाहरी दुनिया की वस्तुओं से जुड़कर सुख की तलाश करती हैं।
            परंतु यह तृप्ति झूठी और अस्थायी होती है, क्योंकि यह बाहरी चीजों पर निर्भर करती है।
            यह श्लोक जीवात्मा की स्थिति और उसके सांसारिक भटकाव का सटीक मनोवैज्ञानिक वर्णन करता है।
            संसार का नाटक माया का ही एक जाल है जिसमें हम सब अनजाने में अभिनेता बन गए हैं।
        """.trimIndent(),
        english = """
            That Supreme Brahman Himself, being deluded by His own Maya (ignorance), takes the form of the individual soul.
            And having assumed this physical body, he begins to perform all actions and worldly activities.
            In the waking state (Jagrat), he experiences various diverse enjoyments like women, food, and drink.
            And by indulging in these physical, worldly pleasures, he experiences a sense of gratification.
            There is no real difference between God and soul; the soul is just God asleep under the influence of Maya.
            Maya is the power that makes us forget our infinity and limits us to a tiny physical body.
            In the waking state, our senses connect with the objects of the outer world searching for happiness.
            However, this gratification is false and temporary because it depends entirely on external things.
            This verse accurately describes the psychological condition of the soul and its worldly wandering.
            The drama of the world is a web of Maya in which we all have unknowingly become actors.
        """.trimIndent()
    ),
    KaivalyaShloka(
        id = 13,
        sanskrit = "स्वप्ने स जीवः सुखदुःखभोक्ता स्वमायया कल्पितजीवलोके । सुषुप्तिकाले सकले विलीने तमोऽभिभूतः सुखरूपमेति ॥ १३ ॥",
        hindi = """
            स्वप्न अवस्था में वह जीव अपनी ही माया (कल्पना) द्वारा रचे गए एक नए संसार में चला जाता है।
            उस काल्पनिक दुनिया में वह अपने बनाए हुए सुख और दुख का पूरा भोग करता है।
            जब गहरी नींद (सुषुप्ति) का समय आता है, तब यह सब कुछ (जाग्रत और स्वप्न) विलीन हो जाता है।
            उस समय जीव तमस (अज्ञान) से ढक जाता है और एक विशेष आनंद (सुखरूप) की अवस्था में पहुँचता है।
            स्वप्न में बाहरी दुनिया बंद हो जाती है, पर मन अपने अंदर ही एक नई दुनिया बना लेता है।
            हम सपनों में रोते और हंसते हैं, जो यह साबित करता है कि दुख-सुख केवल मन की उपज हैं।
            गहरी नींद में मन भी शांत हो जाता है और जीव अपने असली आनंदमय स्रोत के बहुत करीब होता है।
            परंतु सुषुप्ति में वह अज्ञान (तमस) में होता है, इसलिए वह उस आनंद को होशपूर्वक नहीं जान पाता।
            यह श्लोक मानव चेतना की तीन अवस्थाओं (जाग्रत, स्वप्न, सुषुप्ति) का वेदान्तिक विश्लेषण है।
            इन तीनों अवस्थाओं से गुजरने वाला जीव वास्तव में इन सबसे अलग एक 'साक्षी' मात्र है।
        """.trimIndent(),
        english = """
            In the dream state, the soul enters a new world entirely created by its own Maya (imagination).
            In that imaginary world, he fully experiences the joys and sorrows created by his own mind.
            When the time of deep sleep (Sushupti) comes, everything (waking and dream states) dissolves completely.
            At that time, the soul is enveloped by Tamas (ignorance) and attains a state of specific bliss.
            In dreams, the outer world is shut off, but the mind constructs a new world within itself.
            We cry and laugh in dreams, proving that sorrow and joy are merely products of the mind.
            In deep sleep, even the mind is stilled, and the soul is very close to its true blissful source.
            But in Sushupti he is in ignorance (Tamas), so he does not realize that bliss consciously.
            This verse is a Vedantic analysis of the three states of human consciousness (waking, dream, deep sleep).
            The soul passing through these three states is actually just a 'Witness' separate from them all.
        """.trimIndent()
    ),
    KaivalyaShloka(
        id = 14,
        sanskrit = "पुनश्च जन्मान्तरकर्मयोगात् स एव जीवः स्वपिति प्रबुद्धः । पुरत्रये क्रीडति यश्च जीवस्ततस्तु जातं सकलं विचित्रम् । आधारमानन्दमखण्डबोधं यस्मिँल्लयं याति पुरत्रयं च ॥ १४ ॥",
        hindi = """
            पूर्व जन्मों और पिछले दिनों के कर्मों के प्रभाव के कारण वह जीव गहरी नींद से पुनः जाग उठता है।
            यह वही जीव है जो इन तीन पुरों (जाग्रत, स्वप्न और सुषुप्ति अवस्थाओं) में लगातार क्रीड़ा (खेल) करता है।
            इसी जीव की चेतना से यह सारा का सारा विचित्र और विविधतापूर्ण संसार उत्पन्न हुआ है।
            वह परम आधार, जो पूर्ण आनंदमय है और जो अखंड (अविभाज्य) ज्ञान का साक्षात् स्वरूप है।
            उसी एक परब्रह्म के भीतर अंततः ये तीनों अवस्थाएं (पुरत्रय) पूरी तरह से लय (विलीन) हो जाती हैं।
            हम सुबह क्यों उठते हैं? क्योंकि हमारे अधूरे कर्म और इच्छाएं हमें सोने नहीं देते।
            संसार का यह चक्र एक खेल की तरह है, जिसे चेतना तीनों स्तरों पर खेल रही है।
            परंतु इन बदलती हुई अवस्थाओं के पीछे एक अपरिवर्तनीय आधार है—तुरीय अवस्था (Brahman)।
            जब ज्ञान का उदय होता है, तो यह जाग्रत, स्वप्न और सुषुप्ति का भ्रम उसी आधार में समा जाता है।
            यह श्लोक कर्म सिद्धांत और चेतना के अंतिम विश्राम स्थल का बहुत ही स्पष्ट वर्णन करता है।
        """.trimIndent(),
        english = """
            Due to the connection of karmas from past lives and past days, that same soul wakes up from sleep again.
            It is this very soul that continuously plays (sports) in these three cities (waking, dream, and deep sleep states).
            From the consciousness of this soul, this entire strange and diverse world has originated.
            That Supreme Foundation, which is purely blissful and is the direct embodiment of unbroken (indivisible) wisdom.
            It is within that one Supreme Brahman that these three states (the three cities) ultimately and completely dissolve.
            Why do we wake up in the morning? Because our unfulfilled karmas and desires do not let us sleep.
            This cycle of the world is like a game being played by consciousness across all three levels.
            But behind these ever-changing states lies an unchanging foundation—the Turiya state (Brahman).
            When true wisdom dawns, the illusion of waking, dream, and deep sleep merges into that very foundation.
            This verse provides a very clear description of the law of Karma and the ultimate resting place of consciousness.
        """.trimIndent()
    ),
    KaivalyaShloka(
        id = 15,
        sanskrit = "एतस्माज्जायते प्राणो मनः सर्वेन्द्रियाणि च । खं वायुर्ज्योतिरापः पृथिवी विश्वस्य धारिणी ॥ १५ ॥",
        hindi = """
            उसी एक परब्रह्म से प्राण (जीवन शक्ति), मन और शरीर की सभी इंद्रियां उत्पन्न होती हैं।
            उसी से आकाश (खं), वायु, अग्नि (ज्योति), जल और संपूर्ण विश्व को धारण करने वाली पृथ्वी पैदा होती है।
            यह श्लोक सृष्टि की उत्पत्ति के उस क्रम को बताता है जो अन्य उपनिषदों (जैसे मुण्डक) में भी आता है।
            हमारा शरीर, हमारी सोच और यह भौतिक दुनिया अलग-अलग नहीं हैं; वे एक ही स्रोत से निकले हैं।
            ईश्वर ने सृष्टि को बाहर से नहीं बनाया, बल्कि वह स्वयं ही इन तत्वों के रूप में प्रकट हुआ है।
            प्राण वह अदृश्य ऊर्जा है जो मन और इंद्रियों को बाहरी दुनिया से जोड़े रखती है।
            पंचभूत (आकाश, वायु, अग्नि, जल, पृथ्वी) ब्रह्मांड के निर्माणक खंड (Building blocks) हैं।
            पृथ्वी को 'विश्व की धारिणी' कहा गया है क्योंकि यही स्थूल जीवन का अंतिम आधार है।
            जब हम इस सत्य को जान लेते हैं, तो हमें प्रकृति का हर कण पवित्र और ईश्वरीय लगने लगता है।
            विज्ञान और अध्यात्म यहाँ आकर एक हो जाते हैं—सब कुछ एक ही ऊर्जा का रूपांतरण है।
        """.trimIndent(),
        english = """
            From that single Supreme Brahman are born the Prana (vital force), the mind, and all the senses.
            From Him are born space, air, fire, water, and the earth which supports the entire universe.
            This verse reveals the sequence of creation which is also found in other Upanishads (like Mundaka).
            Our body, our thoughts, and this physical world are not separate; they have emerged from the same source.
            God did not create the universe from the outside; He Himself manifested in the form of these elements.
            Prana is that invisible energy that connects the mind and senses to the external world.
            The five elements (space, air, fire, water, earth) are the building blocks of the cosmos.
            Earth is called the 'supporter of the universe' because it is the ultimate basis of gross life.
            When we realize this truth, every particle of nature begins to feel sacred and divine to us.
            Science and spirituality merge right here—everything is a transformation of one single Energy.
        """.trimIndent()
    ),
    KaivalyaShloka(
        id = 16,
        sanskrit = "यत्परं ब्रह्म सर्वात्मा विश्वस्यायतनं महत् । सूक्ष्मात्सूक्ष्मतरं नित्यं तत्त्वमेव त्वमेव तत् ॥ १६ ॥",
        hindi = """
            वह जो परम ब्रह्म है, जो समस्त प्राणियों की अंतरात्मा है और इस विशाल विश्व का महान आश्रय है।
            वह जो सूक्ष्म से भी अत्यधिक सूक्ष्म है और जो हमेशा (नित्य) रहने वाला है।
            वह परम सत्य 'तुम ही हो', और तुम वास्तव में 'वही परम सत्य हो'।
            यह वेदान्त का महावाक्य 'तत्त्वमसि' (Thou art That) है, जो गुरु शिष्य को सीधे अनुभव कराता है।
            हम स्वयं को एक छोटा और कमजोर शरीर मानते हैं, पर उपनिषद कहता है कि हम पूरे विश्व का आधार हैं।
            परमात्मा इतना सूक्ष्म है कि उसे किसी खुर्दबीन (Microscope) से नहीं देखा जा सकता, वह चेतना है।
            वह नित्य है यानी समय उसे नष्ट नहीं कर सकता, और वह सर्वात्मा है यानी कोई उससे अलग नहीं।
            जब यह वाक्य समझ में आता है, तब इंसान का सारा डर, हीन भावना और दुख खत्म हो जाता है।
            'तुम ही वह हो' यह कोई घमंड नहीं है, बल्कि अपनी असली ईश्वरीय पहचान को स्वीकार करना है।
            यह श्लोक कैवल्य उपनिषद का हृदय है जो जीवात्मा और परमात्मा की पूर्ण एकता की घोषणा करता है।
        """.trimIndent(),
        english = """
            That which is the Supreme Brahman, the inner soul of all beings, and the great abode of this vast universe.
            That which is subtler than the absolute subtlest and which is eternal (Nitya).
            That Supreme Truth 'You are', and indeed, You are 'That' Supreme Truth.
            This is the great Vedantic dictum 'Tat Tvam Asi' (Thou art That), which the Guru directly imparts to the disciple.
            We consider ourselves a small, weak body, but the Upanishad declares we are the foundation of the world.
            God is so subtle that He cannot be seen with any microscope; He is pure consciousness.
            He is eternal, meaning time cannot destroy Him, and He is the soul of all, meaning none is separate.
            When this sentence is truly understood, all of a person's fear, inferiority, and sorrow vanish.
            'You are That' is not a statement of ego, but the acceptance of one's true divine identity.
            This verse is the heart of the Kaivalya Upanishad, proclaiming the absolute unity of the soul and God.
        """.trimIndent()
    ),
    KaivalyaShloka(
        id = 17,
        sanskrit = "जाग्रत्स्वप्नसुषुप्त्यादिप्रपञ्चं यत्प्रकाशते । तद्ब्रह्माहमिति ज्ञात्वा सर्वबन्धैः प्रमुच्यते ॥ १७ ॥",
        hindi = """
            वह प्रकाश (चेतना) जो जाग्रत, स्वप्न और सुषुप्ति आदि सभी अवस्थाओं के प्रपंच को प्रकाशित करता है।
            'वह साक्षात् परब्रह्म मैं ही हूँ'—इस प्रकार का दृढ़ ज्ञान प्राप्त करके मनुष्य सभी बंधनों से मुक्त हो जाता है।
            जब हम जागते हैं, तो एक दुनिया है; जब सोते हैं, तो दूसरी दुनिया है; पर इन्हें देखने वाला कौन है?
            वह देखने वाला (साक्षी) न तो शरीर है और न मन, वह शुद्ध ब्रह्म है जो तीनों अवस्थाओं को रौशन कर रहा है।
            जैसे सिनेमा के पर्दे पर दृश्य बदलते हैं पर पीछे का पर्दा वही रहता है, वैसे ही हमारी आत्मा स्थिर है।
            हम दुखी होते हैं क्योंकि हम बदलते हुए दृश्यों (सुख-दुख) के साथ अपनी पहचान जोड़ लेते हैं।
            यह जानना कि 'मैं वह प्रकाश हूँ' ही अज्ञान की बेड़ियों को काटने वाली असली तलवार है।
            मुक्ति कोई कर्म का फल नहीं है, यह केवल अपने असली स्वरूप को 'जानने' (ज्ञात्वा) का परिणाम है।
            यह श्लोक आत्मज्ञान की विधि को बहुत सरल शब्दों में साधक के सामने रखता है।
            बंधनों से मुक्त होने का अर्थ है इस संसार में रहते हुए भी इसके दुखों से अप्रभावित (Untouched) रहना।
        """.trimIndent(),
        english = """
            That Light (consciousness) which illumines the phenomena of waking, dream, and deep sleep states.
            'I am indeed that Supreme Brahman'—by realizing this firmly, a person is freed from all bonds.
            When we are awake, there is one world; when asleep, another; but who is the observer of these?
            That observer (Witness) is neither the body nor the mind; it is pure Brahman illuminating all states.
            Just as scenes change on a cinema screen but the screen remains the same, our Soul is steady.
            We suffer because we falsely identify ourselves with the ever-changing scenes (joys and sorrows).
            Knowing that 'I am that Light' is the real sword that cuts the chains of ignorance.
            Liberation is not the fruit of action; it is simply the result of 'knowing' one's true nature.
            This verse presents the method of Self-realization to the seeker in very simple words.
            Being freed from bonds means remaining completely untouched by worldly sorrows while living in it.
        """.trimIndent()
    ),
    KaivalyaShloka(
        id = 18,
        sanskrit = "त्रिषु धामसु यद्भोग्यं भोक्ता भोगश्च यद्भवेत् । तेभ्यो विलक्षणः साक्षी चिन्मात्रोऽहं सदाशिवः ॥ १८ ॥",
        hindi = """
            उन तीनों अवस्थाओं (जाग्रत, स्वप्न, सुषुप्ति) में जो कुछ भी 'भोग्य' (भोगने की वस्तु) है।
            जो 'भोक्ता' (भोगने वाला जीव) है और जो 'भोग' (भोगने की क्रिया) है।
            मैं (आत्मा) इन तीनों से बिल्कुल अलग (विलक्षण), केवल सबको देखने वाला साक्षी हूँ।
            मैं शुद्ध चिन्मात्र (केवल चेतना) हूँ और मैं ही परम कल्याणकारी सदाशिव हूँ।
            संसार का हर अनुभव तीन चीजों से बनता है: अनुभव करने वाला, अनुभव की वस्तु और अनुभव की क्रिया।
            अज्ञानी मनुष्य इन तीनों में फँस जाता है और खुद को कर्ता और भोक्ता मान लेता है।
            ज्ञानी जानता है कि वह इन तीनों से पार एक स्वतंत्र और शांत देखने वाला (Witness) है।
            चिन्मात्र का अर्थ है कि आत्मा में कोई मिलावट नहीं है, वह सिर्फ और सिर्फ ज्ञान स्वरूप है।
            जब हम खुद को साक्षी मान लेते हैं, तो सुख और दुख हमारे मन को नहीं हिला सकते।
            'मैं सदाशिव हूँ'—यह घोषणा करती है कि हमारा असली स्वभाव परम मंगल और शांति से भरा हुआ है।
        """.trimIndent(),
        english = """
            In those three states (waking, dream, deep sleep), whatever constitutes the 'enjoyable' (object).
            Whoever is the 'enjoyer' (the soul), and whatever is the 'enjoyment' (the act of experiencing).
            I (the Self) am completely distinct from all these three; I am merely the Witness of them all.
            I am pure Consciousness (Chinmatra), and I alone am the eternally auspicious Sadashiva.
            Every worldly experience is made of three things: the experiencer, the object, and the experience.
            An ignorant man gets entangled in these three and considers himself the doer and the enjoyer.
            The wise man knows he is an independent and calm Observer beyond these three.
            Chinmatra means the soul has no impurities; it is purely and only of the nature of knowledge.
            When we identify ourselves as the Witness, worldly joys and sorrows cannot shake our minds.
            'I am Sadashiva'—this declares that our true nature is filled with absolute auspiciousness and peace.
        """.trimIndent()
    ),
    KaivalyaShloka(
        id = 19,
        sanskrit = "मय्येव सकलं जातं मयि सर्वं प्रतिष्ठितम् । मयि सर्वं लयं याति तद्ब्रह्माद्वयमस्म्यहम् ॥ १९ ॥",
        hindi = """
            यह सम्पूर्ण दृश्य जगत मुझमें (मेरी चेतना में) ही पैदा हुआ है और मुझसे ही विकसित है।
            यह सब कुछ मुझमें ही टिका हुआ है और मेरे ही आधार पर प्रतिष्ठित है।
            और अंत में यह सारा ब्रह्मांड मुझमें ही वापस लौटकर पूरी तरह विलीन हो जाता है।
            इसलिए वह अद्वितीय (जिसके समान दूसरा कोई नहीं) परब्रह्म मैं स्वयं ही हूँ।
            यह श्लोक आत्मज्ञानी के उस विराट अनुभव को बताता है जब वह ब्रह्मांड के साथ एक हो जाता है।
            जैसे समुद्र की लहरें समुद्र से ही उठती हैं, उसी में रहती हैं और उसी में गिर जाती हैं।
            वैसे ही यह दुनिया हमारी ही आत्मा का एक विस्तार है, बाहर कुछ भी नहीं है।
            यह कोई अहंकार की बात नहीं है, यह तो सत्य का सीधा और स्पष्ट दर्शन है।
            जब 'मैं' शरीर से उठकर 'ब्रह्म' बन जाता है, तो जन्म और मृत्यु के सवाल ही खत्म हो जाते हैं।
            अद्वय (Non-dual) का अर्थ है कि मेरे अलावा इस दुनिया में और कुछ भी सत्य नहीं है।
        """.trimIndent(),
        english = """
            This entire visible universe is born within Me (in my consciousness) and evolved from Me.
            Everything is entirely supported by Me and is firmly established upon My foundation.
            And finally, this entire cosmos returns and dissolves completely into Me alone.
            Therefore, I myself am that non-dual (without a second) Supreme Brahman.
            This verse expresses the vast experience of a realized soul when he becomes one with the universe.
            Just as ocean waves rise from the ocean, exist in it, and fall back into it.
            Similarly, this world is an extension of our own Soul; there is nothing 'outside'.
            This is not a statement of arrogance; it is the direct and clear vision of the absolute Truth.
            When 'I' rises from the body and becomes 'Brahman', questions of birth and death simply vanish.
            Non-dual (Advaya) means that apart from Me, nothing else in this world is truly real.
        """.trimIndent()
    ),
    KaivalyaShloka(
        id = 20,
        sanskrit = "अणोरणीयानहमेव तद्वन्महानहं विश्वमिदं विचित्रम् । पुरातनोऽहं पुरुषोऽहमीशो हिरण्मयोऽहं शिवरूपमस्मि ॥ २० ॥",
        hindi = """
            मैं ही सूक्ष्म से भी अत्यंत सूक्ष्म (अणु से भी छोटा) हूँ, और उसी प्रकार मैं ही सबसे महान (विराट) हूँ।
            यह जो अद्भुत और विचित्रताओं से भरा हुआ संपूर्ण विश्व है, वह वास्तव में मैं ही हूँ।
            मैं ही सबसे प्राचीन (पुरातन) हूँ, मैं ही परम पुरुष हूँ और मैं ही सबका स्वामी (ईश) हूँ।
            मैं हिरण्मय (सुवर्ण के समान प्रकाशमान) हूँ और मैं ही परम कल्याणकारी शिव-स्वरूप हूँ।
            जब आत्मा अपने असली रूप को जानती है, तो वह भौतिक आकारों की सीमाओं को तोड़ देती है।
            वह परमाणु के भीतर भी मौजूद है और आकाशगंगाओं से भी बड़ी है, क्योंकि वह 'आकार' नहीं है।
            दुनिया की सारी विचित्रताएं (पहाड़, नदियां, जीव) उसी एक आत्मा की कलाकारी हैं।
            पुरातन होने का अर्थ है कि समय मुझसे शुरू होता है, मैं समय से पहले भी मौजूद था।
            हिरण्मय होने का मतलब है कि आत्मा का प्रकाश कभी धुंधला नहीं पड़ता, वह शुद्ध ज्ञान है।
            'मैं ही शिव हूँ' (शिवोऽहम्)—यह बोध इंसान को संसार के हर दुख और भय से हमेशा के लिए आज़ाद कर देता है।
        """.trimIndent(),
        english = """
            I am indeed subtler than the subtlest (smaller than an atom), and similarly, I am the greatest of the great.
            This entire wonderful universe, filled with astonishing diversity, is in reality Me alone.
            I am the most ancient one, I am the Supreme Person, and I am the Lord of all.
            I am golden-hued (radiant like pure gold), and I am the embodiment of the auspicious Shiva.
            When the soul realizes its true nature, it shatters all limitations of physical forms.
            It exists within the atom and is larger than galaxies because it is not a 'form'.
            All the wonders of the world (mountains, rivers, beings) are the artistry of that one Soul.
            Being ancient means time begins from Me; I existed even before time came into being.
            Being golden means the light of the soul never dims; it is pure, unadulterated wisdom.
            'I am Shiva' (Shivoham)—this realization frees a person from every worldly sorrow and fear forever.
        """.trimIndent()
    ),
    KaivalyaShloka(
        id = 21,
        sanskrit = "अपाणिपादोऽहमचिन्त्यशक्तिः पश्याम्यचक्षुः स शृणोम्यकर्णः । अहं विजानामि विविक्तरूपो न चास्ति वेत्ता मम चित्सदाहम् ॥ २१ ॥",
        hindi = """
            मेरे हाथ और पैर नहीं हैं, फिर भी मेरी शक्ति अकल्पनीय और अचिन्त्य है (मैं सब कुछ कर सकता हूँ)।
            मैं बिना आँखों के भी सब कुछ देखता हूँ, और बिना कानों के भी सब कुछ स्पष्ट सुनता हूँ।
            मैं संसार की हर वस्तु और हर बात को पूरी तरह जानता हूँ, क्योंकि मेरा रूप सबसे विशिष्ट है।
            परंतु इस पूरे ब्रह्मांड में मुझे (मेरे असली स्वरूप को) जानने वाला दूसरा कोई नहीं है।
            मैं हमेशा और हर अवस्था में केवल शुद्ध चैतन्य (चित्/ज्ञान-स्वरूप) ही हूँ।
            ईश्वर को काम करने के लिए हमारी तरह भौतिक अंगों (हाथ, पैर, आँख) की आवश्यकता नहीं होती।
            उसकी चेतना इतनी व्यापक है कि वह हर कण की गति और हर मन के विचार को प्रत्यक्ष जानती है।
            हम भगवान को अपनी बुद्धि से नहीं जान सकते, क्योंकि हमारी बुद्धि खुद उसी की दी हुई है।
            'चित्सदाहम्' का अर्थ है कि आत्मा कभी बेहोश या अज्ञानी नहीं होती, वह हमेशा जाग्रत है।
            यह श्लोक आत्मा की निरपेक्ष (Absolute) और असीम क्षमता का अत्यंत सुंदर वर्णन करता है।
        """.trimIndent(),
        english = """
            I am without hands and feet, yet My power is unimaginable and unthinkable (I can do everything).
            I see everything clearly without eyes, and I hear everything perfectly without ears.
            I know every object and every detail of the world, for My form is the most distinct.
            But in this entire universe, there is no one else who truly knows Me (My real nature).
            I am always, and in every state, nothing but pure Consciousness (Chit).
            God does not need physical organs (hands, feet, eyes) like us to perform actions.
            His consciousness is so vast that it directly knows the movement of every atom and thought.
            We cannot know God with our intellect, because our intellect itself is given by Him.
            'Chitsadaham' means the soul is never unconscious or ignorant; it is eternally awake.
            This verse exquisitely describes the absolute, unconditioned, and limitless capacity of the Soul.
        """.trimIndent()
    ),
    KaivalyaShloka(
        id = 22,
        sanskrit = "वेदैरशेषैरहमेव वेद्यो वेदान्तकृद्वेदविदेव चाहम् । न पुण्यपापे मम नास्ति नाशो न जन्म देहेन्द्रियबुद्धिरस्ति ॥ २२ ॥",
        hindi = """
            संपूर्ण वेदों और शास्त्रों के द्वारा केवल मैं (परमात्मा) ही जानने योग्य (वेद्य) मुख्य लक्ष्य हूँ।
            मैं ही वेदान्त (उपनिषदों के ज्ञान) का रचयिता हूँ और मैं ही वेदों के असली अर्थ को जानने वाला हूँ।
            मेरे लिए न कोई पुण्य है और न ही कोई पाप है; मेरा कभी भी नाश (विनाश) नहीं हो सकता।
            मेरा कभी कोई जन्म नहीं होता, और मेरे पास यह भौतिक शरीर, इंद्रियां या बुद्धि भी नहीं है।
            धार्मिक ग्रंथ और मंत्र केवल उसी एक ईश्वर की ओर इशारा करते हैं, वे अंतिम मंजिल नहीं हैं।
            ज्ञान भी ईश्वर से आता है और उस ज्ञान को समझने वाली शक्ति भी ईश्वर ही है।
            पुण्य और पाप शरीर और मन के कर्म हैं; आत्मा इन दोनों से अछूती और पवित्र रहती है।
            जब जन्म ही नहीं हुआ, तो मृत्यु (नाश) का सवाल ही पैदा नहीं होता।
            हम खुद को शरीर और बुद्धि मानकर दुखी होते हैं, जबकि हमारी आत्मा इन सबसे मुक्त है।
            यह श्लोक अद्वैत दर्शन की चरम सीमा है, जहाँ साधक पूरी तरह भगवान के साथ एकाकार हो जाता है।
        """.trimIndent(),
        english = """
            By all the Vedas and scriptures entirely, I (the Supreme) alone am the ultimate goal to be known.
            I am the author of Vedanta (Upanishadic wisdom), and I alone am the true knower of the Vedas.
            For Me, there is neither merit (Punya) nor sin (Papa); I can never suffer destruction.
            I have no birth whatsoever, nor do I possess this physical body, senses, or intellect.
            Religious texts and mantras only point toward that one God; they are not the final destination.
            Knowledge comes from God, and the power to comprehend that knowledge is also God.
            Merit and sin are actions of the body and mind; the soul remains untouched and pure.
            When there is no birth at all, the question of death (destruction) simply does not arise.
            We suffer by identifying with the body and intellect, while our soul is completely free from them.
            This verse represents the zenith of Advaita philosophy, where the seeker is fully unified with God.
        """.trimIndent()
    ),
    KaivalyaShloka(
        id = 23,
        sanskrit = "न भूमिरापो न च वह्निरस्ति न चानिलो मेऽस्ति न चाम्बरं च । एवं विदित्वा परमात्मरूपं गुहाशयं निष्कलमद्वितीयम् ॥ २३ ॥",
        hindi = """
            मेरे लिए न तो यह पृथ्वी है, न जल है और न ही कोई अग्नि मेरे स्वरूप में मौजूद है।
            मेरे लिए न तो कोई वायु है और न ही यह विशाल आकाश मेरे अस्तित्व का हिस्सा है।
            (इस प्रकार गुरु कहते हैं): इस प्रकार जो साधक परमात्मा के इस असली स्वरूप को जान लेता है।
            वह जान लेता है कि परमात्मा हृदय की गुफा में छिपा हुआ है, वह निष्कल (बिना अंगों का) और अद्वितीय है।
            पंचभूत (तत्व) भौतिक दुनिया को बनाते हैं, पर आत्मा इन सभी तत्वों से पूरी तरह परे है।
            आत्मा को न तो मिट्टी काट सकती है, न जल गला सकता है और न ही आग जला सकती है।
            ईश्वर को ढूंढने के लिए अंतरिक्ष में नहीं, बल्कि अपने ही दिल (गुहा) में झांकना पड़ता है।
            अद्वितीय का अर्थ है कि उस परमात्मा के समान या उसके अलावा दूसरा कोई सत्य नहीं है।
            जब मनुष्य इस सत्य को समझता है, तो उसका भौतिक दुनिया से मोह हमेशा के लिए टूट जाता है।
            यह श्लोक जीवात्मा की पंचभूतों से मुक्ति और उसके शुद्ध चैतन्य रूप को स्थापित करता है।
        """.trimIndent(),
        english = """
            For Me, there is no earth, no water, nor is there any fire present in My true nature.
            For Me, there is no wind, nor is this vast ether (space) a part of My existence.
            (Thus the Guru says): The seeker who realizes this true and absolute nature of the Supreme Lord.
            He knows that the Lord is hidden in the cave of the heart, partless (Nishkala), and without a second.
            The five elements make up the physical world, but the soul is completely beyond all these elements.
            The soul can neither be cut by earth, dissolved by water, nor burned by fire.
            To find God, one must look not into outer space, but deep into one's own heart (Guha).
            'Without a second' means there is no truth equal to or other than that Supreme Lord.
            When a man understands this truth, his attachment to the physical world is broken forever.
            This verse establishes the soul's freedom from the elements and its identity as pure consciousness.
        """.trimIndent()
    ),
    KaivalyaShloka(
        id = 24,
        sanskrit = "समस्तसाक्षिं सदसद्विहीनं प्रयाति शुद्धं परमात्मरूपम् । यः शतरुद्रियमधीते सोऽग्निपूतो भवति स वायुपूतो भवति स आत्मापूतो भवति स सुरापानात् पूतो भवति स स्वर्णस्तेयात् पूतो भवति स ब्रह्महत्यात् पूतो भवति स कृत्याकृत्यात् पूतो भवति तस्मादविमुक्तमाश्रितो भवति अत्याश्रमी सर्वदा सकृद्वा जपेत् ॥ २४ ॥",
        hindi = """
            जो सबको देखने वाला साक्षी है और जो सत् (स्थूल) और असत् (सूक्ष्म) दोनों से रहित (परे) है।
            साधक उस परम शुद्ध परमात्म-रूप को प्राप्त कर लेता है। (अब उपनिषद के पाठ का फल बताया गया है)।
            जो व्यक्ति 'शतरुद्रिय' (रुद्राष्टाध्यायी/इस उपनिषद) का निरंतर पाठ और मनन करता है।
            वह अग्नि के समान पवित्र हो जाता है, वह वायु के समान निर्मल हो जाता है और उसकी आत्मा शुद्ध हो जाती है।
            वह शराब पीने जैसे महापाप से, सोना चुराने के पाप से और ब्रह्महत्या जैसे भयानक पाप से भी मुक्त हो जाता है।
            वह उन सभी पापों से पवित्र हो जाता है जो उसने किए हैं या जो भूलवश हो गए हैं (कृत्याकृत्य)।
            इसलिए उसे भगवान शिव (अविमुक्त) की शरण में जाना चाहिए। सन्यासी (अत्याश्रमी) को इसका हमेशा जाप करना चाहिए।
            यह श्लोक ज्ञान की उस अपार शक्ति को दिखाता है जो जीवन के सबसे बड़े पापों को भी राख कर सकती है।
            पाप शरीर और अज्ञान के स्तर पर होते हैं, जब आत्मा का बोध होता है तो सभी पाप मिट जाते हैं।
            शतरुद्रिय का पाठ मन को शुद्ध करने का एक शक्तिशाली उपकरण (Tool) है जो मोक्ष की ओर ले जाता है।
        """.trimIndent(),
        english = """
            He who is the Witness of all and is completely beyond both being (Sat) and non-being (Asat).
            The seeker attains that supremely pure form of the Paramatman. (Now the fruits of study are told).
            The person who constantly studies and contemplates the 'Satarudriya' (this Upanishadic wisdom).
            He becomes purified like fire, he becomes immaculate like the wind, and his soul becomes pure.
            He is purified from grave sins like drinking liquor, stealing gold, and even the heinous sin of killing a Brahmin.
            He becomes completely purified from all sins committed intentionally or unintentionally (Krityakritya).
            Therefore, he should take refuge in Lord Shiva (Avimukta). The ascetic should chant it always.
            This verse shows the immense power of wisdom that can turn even the greatest sins to ashes.
            Sins exist at the level of body and ignorance; when the soul is realized, all sins are obliterated.
            Chanting the Satarudriya is a powerful tool to purify the mind, leading directly to liberation.
        """.trimIndent()
    ),
    KaivalyaShloka(
        id = 25,
        sanskrit = "अनेन ज्ञानमाप्नोति संसारार्णवनाशनम् । तस्मादेवं विदित्वैनं कैवल्यं पदमश्नुते कैवल्यं पदमश्नुत इति ॥ २५ ॥",
        hindi = """
            इस उपनिषद के निरंतर पाठ और मनन से साधक उस परम ज्ञान को पूरी तरह प्राप्त कर लेता है।
            वह ज्ञान जो इस असीम और दुखदायी संसार रूपी महासागर (संसारार्णव) को हमेशा के लिए नष्ट कर देता है।
            इसलिए, इस प्रकार से (श्रद्धा और ध्यान के साथ) इस परम सत्य को गहराई से जानकर।
            साधक उस परम 'कैवल्य पद' (मोक्ष/अकेलेपन की पूर्णता) को निश्चित रूप से प्राप्त कर लेता है।
            'कैवल्य पदमश्नुते' (वह कैवल्य को प्राप्त करता है) का दो बार दोहराया जाना इस बात की पूर्ण निश्चितता को दर्शाता है।
            संसार एक ऐसा सागर है जहाँ इच्छाओं की लहरें इंसान को डुबोती रहती हैं, ज्ञान ही वह नाव है जो पार लगाती है।
            कैवल्य का अर्थ 'अकेला' होना है, पर यह कोई दुखी अकेलापन नहीं, बल्कि यह जानना है कि 'सिर्फ मैं ही हूँ'।
            जब दूसरा कोई है ही नहीं, तो डर कैसा? यही अद्वैत की सर्वोच्च और अंतिम स्थिति है।
            यह श्लोक और यह उपनिषद हमें हमारे असली घर का रास्ता दिखाता है जहाँ केवल परम शांति है।
            यहाँ आकर आश्वलायन की जिज्ञासा शांत होती है और यह महान उपदेश पूर्ण होता है। ॐ शांति।
        """.trimIndent(),
        english = """
            Through the continuous study and reflection of this Upanishad, the seeker attains that supreme wisdom.
            The wisdom that completely and permanently destroys this boundless, painful ocean of worldly existence (Samsara).
            Therefore, having known this Supreme Truth deeply in this manner (with faith and meditation).
            The seeker definitely attains that supreme state of 'Kaivalya' (Absolute Liberation/Perfection of Oneness).
            The repetition of 'Kaivalyam Padamashnute' (he attains Kaivalya) signifies the absolute certainty of this result.
            The world is an ocean where waves of desires drown a person; wisdom is the only boat that crosses it.
            Kaivalya means 'Aloneness', but not a sad loneliness; it is the realization that 'Only I exist'.
            When there is no 'other', how can there be fear? This is the highest and final state of Non-duality.
            This verse and this Upanishad show us the way back to our true home where there is only absolute peace.
            Here Ashvalayana's quest is fulfilled, and this great teaching is complete. OM Peace.
        """.trimIndent()
    ),
    KaivalyaShloka(
        id = 26,
        sanskrit = "ॐ भद्रं कर्णेभिः शृणुयाम देवाः । भद्रं पश्येमाक्षभिर्यजत्राः । स्थिरैरङ्गैस्तुष्टुवांसस्तनूभिः । व्यशेम देवहितं यदायुः ॥ ॐ शान्तिः शान्तिः शान्तिः ॥ २६ ॥",
        hindi = """
            (उपनिषद के अंत में वैदिक शांति पाठ): हे देवगण! हम अपने कानों से हमेशा भद्र (कल्याणकारी और शुभ) बातें ही सुनें।
            हे यज्ञ के रक्षक देवताओं! हम अपनी आँखों से हमेशा भद्र (पवित्र और शुभ) दृश्य ही देखें।
            हमारे शरीर के सभी अंग (हाथ, पैर आदि) पूरी तरह से स्थिर, स्वस्थ और मजबूत बने रहें।
            हम अपने स्वस्थ शरीर से आप देवताओं की स्तुति करते हुए, उस पूरी आयु को जिएँ जो ईश्वर ने हमारे लिए तय की है।
            हमारा पूरा जीवन एक यज्ञ की तरह पवित्र हो और ज्ञान की खोज में ही व्यतीत हो।
            यह शांति पाठ उपनिषद के अंत में इसलिए है ताकि प्राप्त किया गया ज्ञान स्थिर रह सके।
            स्वस्थ शरीर और शुद्ध इंद्रियों के बिना आध्यात्मिक जीवन जीना अत्यंत कठिन है।
            हम जो सुनते और देखते हैं, वही हमारा मन बनाता है, इसलिए इंद्रियों की पवित्रता मांगी गई है।
            'ॐ शान्तिः शान्तिः शान्तिः'—हमारे भीतर, हमारे आस-पास और पूरे ब्रह्मांड में पूर्ण शांति स्थापित हो।
            (यह आपके 'ब्रह्मांड' ऐप के लिए कैवल्य उपनिषद का अंतिम और पूर्ण समापन है)।
        """.trimIndent(),
        english = """
            (The Vedic Peace Chant at the end): O Gods! May we always hear only what is auspicious and good with our ears.
            O protectors of the sacrifices! May we always see only what is auspicious and pure with our eyes.
            May all the limbs and organs of our physical bodies remain completely steady, healthy, and strong.
            Praising the Gods with our healthy bodies, may we live the entire lifespan allotted to us by the Divine.
            May our whole life be sacred like a sacrifice and be spent solely in the pursuit of supreme wisdom.
            This peace chant is at the end of the Upanishad so that the acquired knowledge remains firmly established.
            Living a spiritual life is extremely difficult without a healthy body and purified senses.
            What we hear and see constructs our mind; hence the absolute purity of the senses is prayed for.
            'OM Peace, Peace, Peace'—May perfect peace be established within us, around us, and in the entire cosmos.
            (This marks the final and complete conclusion of the Kaivalya Upanishad for your 'Brahmanda' app).
        """.trimIndent()
    )
)