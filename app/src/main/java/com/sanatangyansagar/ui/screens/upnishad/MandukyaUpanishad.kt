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
data class MandukyaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MandukyaUpanishadScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFBF7)) // Light traditional background
    ) {
        // Search Bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                // Attempt to parse the query into a number and scroll to it
                val shlokaNumber = query.toIntOrNull()
                if (shlokaNumber != null && shlokaNumber in 1..12) {
                    coroutineScope.launch {
                        // -1 because list indices start at 0
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-12)") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            shape = RoundedCornerShape(12.dp),
            // FIXED: Updated to OutlinedTextFieldDefaults for newer Material 3 versions
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        // Shloka List
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(mandukyaShlokasList) { _, shloka ->
                ShlokaCard(shloka)
            }
        }
    }
}

@Composable
fun ShlokaCard(shloka: MandukyaShloka) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Shloka ${shloka.id}",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(0xFFD84315) // Deep Orange
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Sanskrit Text
            Text(
                text = shloka.sanskrit,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(12.dp))

            // FIXED: Replaced deprecated Divider() with HorizontalDivider()
            HorizontalDivider()

            Spacer(modifier = Modifier.height(12.dp))

            // Hindi Explanation
            Text(
                text = "हिन्दी अर्थ:",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1565C0)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = shloka.hindi,
                fontSize = 15.sp,
                lineHeight = 22.sp
            )
            Spacer(modifier = Modifier.height(12.dp))

            // FIXED: Replaced deprecated Divider() with HorizontalDivider()
            HorizontalDivider()

            Spacer(modifier = Modifier.height(12.dp))

            // English Explanation
            Text(
                text = "English Meaning:",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = shloka.english,
                fontSize = 15.sp,
                lineHeight = 22.sp
            )
        }
    }
}

// Data List of 12 Shlokas
val mandukyaShlokasList = listOf(
    MandukyaShloka(
        id = 1,
        sanskrit = "ओमित्येतदक्षरमिदं सर्वं तस्योपव्याख्यानं भूतं भवद् भविष्यदिति सर्वमोङ्कार एव। यच्चान्यत् त्रिकालातीतं तदप्योङ्कार एव ॥ १ ॥",
        hindi = """
            यह पूरा ब्रह्मांड और कुछ नहीं बल्कि ॐ (ओम) है।
            यह अक्षर ही सब कुछ है जो अतीत में था, जो वर्तमान में है, और जो भविष्य में होगा।
            समय के तीनों कालों (भूत, भविष्य, वर्तमान) में जो कुछ भी मौजूद है, वह केवल ॐ है।
            और जो इन तीनों कालों से परे है, जो कालातीत है, वह भी ओम ही है।
            ओम केवल एक ध्वनि नहीं है, बल्कि यह परम सत्य का प्रतीक है।
            इस संपूर्ण सृष्टि की अभिव्यक्ति इसी ॐ से हुई है।
            मनुष्य को यह समझना चाहिए कि नाम और रूप से परे जो एक ही सत्य है, वह ॐ है।
            जब हम ओम का ध्यान करते हैं, तो हम उस परम तत्व के साथ जुड़ते हैं।
            यह उपनिषद हमें बताता है कि ओम को समझे बिना आत्म-ज्ञान संभव नहीं है।
            अतः सब कुछ ॐ का ही विस्तार मात्र है।
        """.trimIndent(),
        english = """
            The entire universe is nothing but the sacred syllable OM.
            This imperishable word is everything that has existed in the past, exists now, and will exist in the future.
            Whatever is bound by the three periods of time (past, present, and future) is truly OM.
            Furthermore, whatever transcends these three periods of time—the timeless reality—is also OM alone.
            OM is not just a sound; it is the ultimate symbol of the Supreme Absolute.
            The entire manifestation of creation springs forth from this sacred syllable.
            One must understand that beyond name and form, the only unchanging truth is OM.
            When we meditate upon OM, we align ourselves with the supreme consciousness.
            The Upanishad establishes that self-realization requires a profound understanding of OM.
            Therefore, all of existence is simply an extension and expression of OM.
        """.trimIndent()
    ),
    MandukyaShloka(
        id = 2,
        sanskrit = "सर्वं ह्येतद् ब्रह्मायमात्मा ब्रह्म सोऽयमात्मा चतुष्पात् ॥ २ ॥",
        hindi = """
            निश्चय ही यह सब कुछ जो हमें दिखाई देता है, वह ब्रह्म है।
            यह हमारी अपनी आत्मा (स्वयं का मूल स्वरूप) भी ब्रह्म ही है।
            यह आत्मा केवल शरीर या मन तक सीमित नहीं है, बल्कि यह परमसत्ता है।
            उपनिषद बताता है कि इस आत्मा के चार पाद (अवस्थाएं या चरण) होते हैं।
            यह चार पाद कोई भौतिक अंग नहीं हैं, बल्कि चेतना की अवस्थाएं हैं।
            इन चारों अवस्थाओं को समझे बिना हम आत्मा के असली स्वरूप को नहीं जान सकते।
            यह श्लोक 'अहं ब्रह्मास्मि' (मैं ब्रह्म हूं) के सिद्धांत को स्पष्ट करता है।
            जीव और ईश्वर में कोई मूल भेद नहीं है, दोनों एक ही सत्य हैं।
            जो बाहर व्याप्त है, वही हमारे भीतर आत्मा के रूप में स्थित है।
            इन्हीं चार अवस्थाओं के माध्यम से हम अज्ञान से ज्ञान की ओर बढ़ते हैं।
        """.trimIndent(),
        english = """
            Verily, all this that we perceive in the universe is Brahman (the Supreme Absolute).
            This Atman (the individual self or soul) is also Brahman.
            The self is not limited to the physical body or the mind; it is the ultimate reality.
            The Upanishad declares that this Atman has four quarters (states or aspects).
            These four quarters are not physical limbs, but distinct states of consciousness.
            Without understanding these four states, one cannot realize the true nature of the Self.
            This verse clearly establishes the core Vedantic principle: the Self and the Supreme are one.
            There is no fundamental difference between the individual and the universal consciousness.
            What pervades the entire cosmos is exactly what resides within us as the Atman.
            It is through exploring these four states that we move from ignorance to supreme wisdom.
        """.trimIndent()
    ),
    MandukyaShloka(
        id = 3,
        sanskrit = "जागरितस्थानो बहिष्प्रज्ञः सप्ताङ्ग एकोनविंशतिमुखः स्थूलभुग्वैश्वानरः प्रथमः पादः ॥ ३ ॥",
        hindi = """
            आत्मा का पहला पाद (अवस्था) 'वैश्वानर' है, जो जाग्रत अवस्था (जागने की स्थिति) है।
            इस अवस्था में चेतना बाहर की ओर उन्मुख होती है (बहिष्प्रज्ञ)।
            यह सात अंगों और उन्नीस मुखों वाला होता है, जिसके माध्यम से यह संसार का अनुभव करता है।
            सात अंग हैं: स्वर्ग, सूर्य, वायु, आकाश, जल, पृथ्वी और आहवनीय अग्नि।
            उन्नीस मुख हैं: पांच ज्ञानेन्द्रियां, पांच कर्मेन्द्रियां, पांच प्राण, और चार अंतःकरण (मन, बुद्धि, चित्त, अहंकार)।
            इस अवस्था में आत्मा स्थूल वस्तुओं (भौतिक संसार) का भोग करता है।
            हम सभी अपने दैनिक जीवन में इसी अवस्था में जीते हैं और कार्य करते हैं।
            इस स्थिति में जीव को लगता है कि यह बाहरी भौतिक संसार ही सत्य है।
            वैश्वानर का अर्थ है जो सभी मनुष्यों में सामान्य रूप से व्याप्त है।
            यह चेतना का सबसे निचला लेकिन सबसे सामान्य स्तर है।
        """.trimIndent(),
        english = """
            The first quarter (state) of the Atman is 'Vaishvanara', which is the waking state.
            In this state, consciousness is directed outwards towards the external world.
            It is described as having seven limbs and nineteen mouths to interact with the universe.
            The seven limbs are the heavens, sun, wind, space, water, earth, and the sacrificial fire.
            The nineteen mouths are the 5 senses of perception, 5 organs of action, 5 pranas, and the 4-fold mind.
            In this state, the self experiences and enjoys gross, physical objects.
            This is the state in which we live our daily lives, interact, and perform actions.
            Here, the individual falsely believes that the external material world is the only reality.
            'Vaishvanara' translates to the universal consciousness present in all human beings.
            It represents the most common, surface-level state of human experience.
        """.trimIndent()
    ),
    MandukyaShloka(
        id = 4,
        sanskrit = "स्वप्नस्थानोऽन्तःप्रज्ञः सप्ताङ्ग एकोनविंशतिमुखः प्रविविक्तभुक् तैजसो द्वितीयः पादः ॥ ४ ॥",
        hindi = """
            आत्मा का दूसरा पाद 'तैजस' है, जो स्वप्न अवस्था (सपने देखने की स्थिति) है।
            इस अवस्था में चेतना भीतर की ओर उन्मुख होती है (अन्तःप्रज्ञ)।
            जाग्रत अवस्था की तरह इसके भी सात अंग और उन्नीस मुख होते हैं, लेकिन वे मानसिक स्तर पर होते हैं।
            यहाँ जीव स्थूल वस्तुओं का नहीं, बल्कि सूक्ष्म (सूक्ष्म विचारों और स्मृतियों) का भोग करता है।
            स्वप्न में मनुष्य जाग्रत अवस्था में देखे गए दृश्यों के आधार पर अपनी एक नई दुनिया बनाता है।
            इस अवस्था में मन ही मुख्य कर्ता और भोक्ता होता है।
            तैजस का अर्थ है प्रकाशमान, क्योंकि इस अवस्था में आत्मा अपने स्वयं के प्रकाश (मन के प्रकाश) से सब कुछ देखती है।
            यहाँ बाहरी दुनिया का कोई संपर्क नहीं होता, इंद्रियां शांत होती हैं।
            फिर भी, यह अवस्था भी एक प्रकार का भ्रम ही है क्योंकि हम इसे वास्तविक मान लेते हैं।
            यह आत्मा की दूसरी सीढ़ी है जो भौतिक से सूक्ष्म की ओर जाती है।
        """.trimIndent(),
        english = """
            The second quarter of the Atman is 'Taijasa', which corresponds to the dream state.
            In this condition, consciousness is directed inwards rather than outwards.
            Like the waking state, it is conceptualized as having seven limbs and nineteen mouths, but purely mental.
            Here, the self experiences subtle objects made of thoughts, impressions, and memories.
            During a dream, the mind creates an entire world based on the impressions gathered while awake.
            The mind becomes the sole creator, actor, and experiencer in this state.
            'Taijasa' means the luminous one, as the self witnesses the dream world by its own internal light.
            The physical senses are shut down, and there is no contact with the external physical world.
            However, this state is also an illusion, as the dreamer believes the dream to be fully real.
            It marks the transition of the self from the gross, physical realm to the subtle, mental realm.
        """.trimIndent()
    ),
    MandukyaShloka(
        id = 5,
        sanskrit = "यत्र सुप्तो न कञ्चन कामं कामयते न कञ्चन स्वप्नं पश्यति तत् सुषुप्तम्। सुषुप्तस्थान एकीभूतः प्रज्ञानघन एवानन्दमयो ह्यानन्दभुक् चेतोमुखः प्राज्ञस्तृतीयः पादः ॥ ५ ॥",
        hindi = """
            आत्मा का तीसरा पाद 'प्राज्ञ' है, जो गहरी नींद (सुषुप्ति) की अवस्था है।
            यह वह अवस्था है जहाँ सोने वाला व्यक्ति किसी भी चीज़ की कामना नहीं करता।
            इस गहरी नींद में कोई स्वप्न भी दिखाई नहीं देता, मन पूरी तरह शांत हो जाता है।
            यहाँ चेतना एकीभूत हो जाती है, यानी जाग्रत और स्वप्न के सारे भेद मिट जाते हैं।
            इस अवस्था को 'प्रज्ञानघन' कहा गया है, जो ज्ञान का एक सघन पिंड है।
            यह अत्यंत आनंदमय स्थिति है, क्योंकि इसमें कोई मानसिक तनाव या द्वैत (दुविधा) नहीं होता।
            इस अवस्था में जीव परम आनंद का भोक्ता होता है, जो ईश्वर के आनंद के समान है।
            इसे 'चेतोमुख' कहा जाता है, क्योंकि यही अवस्था वापस जाग्रत और स्वप्न में लौटने का द्वार है।
            यह मन और बुद्धि के पूर्ण विश्राम का समय है।
            फिर भी, यह परम ज्ञान नहीं है क्योंकि इसमें अज्ञान का एक पर्दा बना रहता है।
        """.trimIndent(),
        english = """
            The third quarter of the Atman is 'Prajna', which is the state of deep, dreamless sleep.
            In this state, the sleeping person desires no object whatsoever.
            There are no dreams seen; the mind and senses withdraw completely into stillness.
            Here, all experiences become unified; the distinctions of the waking and dream worlds disappear.
            It is described as a mass of pure, undifferentiated consciousness or cognition.
            This state is full of bliss, entirely free from the agitations and anxieties of the mind.
            The self in this state experiences profound joy and is the enjoyer of this pure bliss.
            It is called the 'doorway' to consciousness, as it is the gateway back to dreaming and waking.
            It represents complete rest for the mind, body, and intellect.
            However, it is not ultimate enlightenment, because the veil of ignorance still temporarily covers the truth.
        """.trimIndent()
    ),
    MandukyaShloka(
        id = 6,
        sanskrit = "एष सर्वेश्वर एष सर्वज्ञ एषोऽन्तर्याम्येष योनिः सर्वस्य प्रभवाप्ययौ हि भूतानाम् ॥ ६ ॥",
        hindi = """
            यह तीसरी अवस्था (प्राज्ञ) का स्वामी ही सबके हृदय में स्थित ईश्वर है।
            यही सर्वेश्वर (सबका ईश्वर) है और यही सर्वज्ञ (सब कुछ जानने वाला) है।
            यह अंतर्यामी है, यानी सभी प्राणियों के भीतर रहकर उन्हें नियंत्रित और संचालित करता है।
            यही संपूर्ण सृष्टि की योनि (उद्गम या कारण) है।
            समस्त भौतिक और सूक्ष्म प्राणियों की उत्पत्ति इसी से होती है।
            और अंत में, संपूर्ण ब्रह्मांड और प्राणी इसी में विलीन (प्रलय) हो जाते हैं।
            गहरी नींद में जो शांति और एकात्मता हम अनुभव करते हैं, वह ईश्वर के बहुत करीब है।
            यह श्लोक स्पष्ट करता है कि ईश्वर आसमान में नहीं, बल्कि हमारी ही चेतना का मूल है।
            सृष्टि का चक्र - उत्पत्ति, स्थिति और विनाश - इसी तत्व के अधीन है।
            प्राज्ञ अवस्था उस परम कारण का प्रतीक है जहाँ से सब कुछ प्रकट होता है।
        """.trimIndent(),
        english = """
            The Lord of this third state (Prajna) is the supreme ruler of all.
            He is the omniscient one, knowing everything past, present, and future.
            He is the inner controller (Antaryami), guiding all beings from within their own hearts.
            He is the ultimate source, the womb from which the entire universe originates.
            From this pure consciousness, all physical and subtle beings are born.
            And unto this very consciousness, all beings eventually dissolve at the end of time.
            The peace we feel in deep sleep is a reflection of this divine, unifying presence.
            This verse reveals that God is not a distant figure, but the very root of our consciousness.
            The entire cosmic cycle of creation, preservation, and dissolution rests in this principle.
            Prajna represents the causal state of the universe from which all duality emerges.
        """.trimIndent()
    ),
    MandukyaShloka(
        id = 7,
        sanskrit = "नान्तःप्रज्ञं न बहिष्प्रज्ञं नोभयतःप्रज्ञं न प्रज्ञानघनं न प्रज्ञं नाप्रज्ञम्। अदृष्टमव्यवहार्यमग्राह्यमलक्षणमचिन्त्यमव्यपदेश्यमेकात्मप्रत्ययसारं प्रपञ्चोपशमं शान्तं शिवमद्वैतं चतुर्थं मन्यन्ते स आत्मा स विज्ञेयः ॥ ७ ॥",
        hindi = """
            यह आत्मा की चौथी अवस्था है जिसे 'तुरीय' कहा जाता है। यही परम सत्य है।
            यह न तो भीतर की ओर प्रज्ञा है (स्वप्न नहीं) और न बाहर की ओर (जाग्रत नहीं)।
            यह दोनों के बीच की स्थिति भी नहीं है, न ही यह प्रज्ञान का कोई घन (सुषुप्ति) है।
            इसे ज्ञान या अज्ञान के रूप में परिभाषित नहीं किया जा सकता।
            इसे आंखों से नहीं देखा जा सकता, यह किसी व्यवहार या व्यापार का विषय नहीं है।
            इसे इंद्रियों से नहीं पकड़ा जा सकता, इसका कोई चिह्न या लक्षण नहीं है।
            यह मन के सोचने का विषय नहीं है और न ही शब्दों में इसका वर्णन किया जा सकता है।
            यह केवल आत्म-अनुभव का सार है, जहाँ संसार का सारा प्रपंच शांत हो जाता है।
            यह परम शांत, कल्याणकारी (शिव) और अद्वैत (जहाँ दो नहीं, केवल एक है) है।
            यही असली आत्मा है और इसी को जानना मानव जीवन का एकमात्र लक्ष्य है।
        """.trimIndent(),
        english = """
            This is the fourth state of the Atman, known as 'Turiya'. It is the ultimate truth.
            It is not consciousness turned inward (like in dreams), nor outward (like waking).
            It is not a state between the two, nor is it a mass of unconsciousness (deep sleep).
            It cannot be defined simply as knowing or not knowing; it transcends intellect.
            It is unseen by the eyes, beyond any empirical dealings or transactions.
            It cannot be grasped by the senses, it has no features or identifying marks.
            It is unthinkable by the mind and cannot be adequately described by words.
            Its only proof is the direct, unified experience of the Self, where all worldly illusion ceases.
            It is entirely peaceful, supremely auspicious, and non-dual (without a second).
            This is the true Atman, the ultimate reality, and this alone is what must be realized.
        """.trimIndent()
    ),
    MandukyaShloka(
        id = 8,
        sanskrit = "सोऽयमात्माध्यक्षरमोङ्कारोऽधिमात्रं पादा मात्रा मात्राश्च पादा अकार उकारो मकार इति ॥ ८ ॥",
        hindi = """
            यह आत्मा, जिसके चार पादों की बात की गई है, अक्षर के दृष्टिकोण से ॐ (ओम) ही है।
            जब हम ओम का विश्लेषण करते हैं, तो आत्मा के चार पाद और ओम की मात्राएं एक ही सिद्ध होती हैं।
            आत्मा के जो पाद (अवस्थाएं) हैं, वही ओम की मात्राएं हैं।
            ओम में तीन मुख्य ध्वनियां या मात्राएं होती हैं: अ (A), उ (U), और म (M)।
            आत्मा की जाग्रत अवस्था ओम के 'अ' से संबंधित है।
            स्वप्न अवस्था ओम के 'उ' से जुड़ी हुई है।
            और गहरी नींद (सुषुप्ति) अवस्था ओम के 'म' से मेल खाती है।
            चौथी अवस्था (तुरीय) अमात्रा है, जो इन ध्वनियों के बाद का मौन है।
            इस प्रकार, ॐ का उच्चारण और ध्यान आत्मा की सभी अवस्थाओं का अनुभव करने का साधन है।
            यह श्लोक आत्मा और ॐ के बीच पूर्ण एकता को स्थापित करता है।
        """.trimIndent(),
        english = """
            This very Atman, which has been described in four quarters, is identically the syllable OM.
            When viewed from the perspective of syllables, the states of the self correspond to the letters of OM.
            The quarters of the Atman are exactly the measures (matras) of the sacred sound OM.
            The word OM is composed of three phonetic elements: A, U, and M.
            The waking state of the soul directly corresponds to the first letter, 'A'.
            The dream state of the soul perfectly aligns with the second letter, 'U'.
            The state of deep, dreamless sleep corresponds to the third letter, 'M'.
            The fourth state (Turiya) is the silence that follows the chanting of A-U-M.
            Therefore, chanting and meditating on OM is the direct path to experiencing all states of the Self.
            This verse beautifully unifies the psychological states of consciousness with the vibration of OM.
        """.trimIndent()
    ),
    MandukyaShloka(
        id = 9,
        sanskrit = "जागरितस्थानो वैश्वानरोऽकारः प्रथमा मात्राऽऽप्तेरादिमत्त्वाद्वाऽऽप्नोति ह वै सर्वान् कामानादिश्च भवति य एवं वेद ॥ ९ ॥",
        hindi = """
            जाग्रत अवस्था में रहने वाला 'वैश्वानर' ही ॐ की पहली मात्रा 'अ' (A) है।
            'अ' सभी ध्वनियों का आदि है और सभी में व्याप्त (व्यापक) है।
            उसी प्रकार, जाग्रत अवस्था हमारे सभी अनुभवों की शुरुआत है और सबसे अधिक व्यापक है।
            जो व्यक्ति इस रहस्य को जान लेता है कि वैश्वानर और 'अ' एक ही हैं, उसे महान फल मिलता है।
            ऐसा व्यक्ति अपनी सभी इच्छाओं को प्राप्त कर लेता है और जीवन में पूर्णता का अनुभव करता है।
            वह सबके लिए अग्रगण्य (सबसे आगे और मुख्य) बन जाता है।
            'अ' के उच्चारण से व्यक्ति बाह्य जगत के प्रति अपनी चेतना को जागृत करता है।
            यह श्लोक ध्यान की एक विशिष्ट विधि बताता है।
            साधक को जाग्रत अवस्था को ॐ के 'अ' अक्षर के साथ जोड़कर ध्यान करना चाहिए।
            ऐसा करने से साधक सांसारिक उपलब्धियों और सफलता को प्राप्त करता है।
        """.trimIndent(),
        english = """
            The waking state, known as Vaishvanara, corresponds precisely to 'A', the first letter of OM.
            The sound 'A' is the beginning of all vocal sounds and pervades all human speech.
            Similarly, the waking state is the starting point of our conscious experience and is all-pervading.
            He who understands the profound identity between the waking state and the sound 'A' gains great merit.
            Such an individual attains the fulfillment of all his desires and experiences completeness.
            He becomes foremost among people, achieving leadership and success.
            By meditating on 'A', one masters the external world and its gross manifestations.
            This verse provides a specific technique for meditation and contemplation.
            The seeker is advised to mentally merge the waking state experience with the chanting of 'A'.
            Through this practice, one achieves mastery over their waking, material life.
        """.trimIndent()
    ),
    MandukyaShloka(
        id = 10,
        sanskrit = "स्वप्नस्थानस्तैजस उकारो द्वितीया मात्रोत्कर्षादुभयत्वाद्वोत्कर्षति ह वै ज्ञानसन्ततिं समानश्च भवति नास्याब्रह्मवित् कुले भवति य एवं वेद ॥ १० ॥",
        hindi = """
            स्वप्न अवस्था में रहने वाला 'तैजस' ही ॐ की दूसरी मात्रा 'उ' (U) है।
            'उ' अक्षर 'अ' और 'म' के बीच में आता है और यह 'अ' से उच्च (उत्कर्ष) माना जाता है।
            उसी प्रकार, स्वप्न अवस्था जाग्रत और सुषुप्ति के बीच में है और भौतिक जगत से सूक्ष्म है।
            जो व्यक्ति इस समानता को जानकर ॐ के 'उ' का ध्यान करता है, उसका ज्ञान बढ़ता है।
            उसके भीतर ज्ञान की एक निरंतर धारा (सन्तति) प्रवाहित होने लगती है।
            वह सभी के प्रति समान भाव रखता है और समाज में सम्मानित होता है।
            सबसे बड़ी बात, इस रहस्य को जानने वाले के कुल (परिवार) में कोई भी ऐसा नहीं जन्म लेता जो ब्रह्म को न जानता हो।
            अर्थात्, उसका पूरा परिवार ज्ञान और आध्यात्मिकता से युक्त हो जाता है।
            'उ' का ध्यान मन के सूक्ष्म जगत को शुद्ध और संतुलित करता है।
            इस प्रकार साधक सपनों और विचारों की दुनिया पर नियंत्रण प्राप्त कर लेता है।
        """.trimIndent(),
        english = """
            The dream state, known as Taijasa, corresponds to 'U', the second letter of OM.
            The letter 'U' is intermediate, situated perfectly between 'A' and 'M', and is considered superior to 'A'.
            Similarly, the dream state lies between waking and deep sleep, dealing with a superior, subtle reality.
            He who meditates on 'U' knowing its connection to the dream state elevates his consciousness.
            Such a person continuously expands the flow of their knowledge and understanding.
            He becomes balanced, treating friend and foe alike, remaining equanimous in all situations.
            Most notably, in the family line of such a knower, no one will be born who is ignorant of Brahman.
            This means his spiritual legacy deeply influences his entire lineage.
            Meditating on 'U' purifies the subconscious mind and balances inner thoughts.
            Through this, the seeker gains mastery over the subtle, internal world of the mind.
        """.trimIndent()
    ),
    MandukyaShloka(
        id = 11,
        sanskrit = "सुषुप्तस्थानः प्राज्ञो मकारस्तृतीया मात्रा मितेरपीतेर्वा मिनोति ह वा इदं सर्वमपीतिश्च भवति य एवं वेद ॥ ११ ॥",
        hindi = """
            गहरी नींद (सुषुप्ति) की अवस्था में रहने वाला 'प्राज्ञ' ही ॐ की तीसरी मात्रा 'म' (M) है।
            'म' का अर्थ है मापना (मिति) या विलीन हो जाना (अपीति)।
            जब हम ॐ का उच्चारण करते हैं, तो 'अ' और 'उ' अंततः 'म' में ही विलीन हो जाते हैं।
            उसी तरह, गहरी नींद की अवस्था में जाग्रत और स्वप्न अवस्थाएं विलीन हो जाती हैं।
            जो व्यक्ति प्राज्ञ और 'म' की इस एकता को जान लेता है, वह सम्पूर्ण जगत को माप लेता है (अर्थात यथार्थ को जान लेता है)।
            वह सृष्टि के उत्पत्ति और विनाश के रहस्य को समझ जाता है।
            ऐसा ज्ञानी व्यक्ति मृत्यु या प्रलय के समय उसी परमात्मा में शांति से विलीन हो जाता है।
            'म' का ध्यान हमारे मन के सभी तनावों और अज्ञान को गहरे विश्राम में बदल देता है।
            यह साधक को आत्म-मूल्यांकन और ब्रह्मांड के मूल कारण को समझने की शक्ति देता है।
            इस ध्यान से व्यक्ति अपने अहंकार को पूर्ण रूप से शांत करना सीख जाता है।
        """.trimIndent(),
        english = """
            The deep sleep state, known as Prajna, perfectly aligns with 'M', the third letter of OM.
            The sound 'M' signifies measuring (miti) and absorption or merging (apiti).
            When chanting OM, the preceding sounds 'A' and 'U' ultimately dissolve and merge into the final 'M'.
            Likewise, in deep sleep, both the waking and dreaming states are completely absorbed and dissolved.
            He who realizes the profound identity between deep sleep and 'M' is able to measure the entire universe.
            This means they comprehend the true nature of reality, understanding the source of all things.
            Such a person effortlessly merges into the supreme reality at the end of their life cycle.
            Meditating on 'M' brings all mental turbulence into a state of profound, peaceful dissolution.
            It grants the seeker the capacity to deeply introspect and grasp the causal state of the cosmos.
            Through this practice, the ego is entirely subdued, finding ultimate rest.
        """.trimIndent()
    ),
    MandukyaShloka(
        id = 12,
        sanskrit = "अमात्रश्चतुर्थोऽव्यवहार्यः प्रपञ्चोपशमः शिवोऽद्वैत एवमोङ्कार आत्मैव संविशत्यात्मनाऽऽत्मानं य एवं वेद ॥ १२ ॥",
        hindi = """
            ॐ का चौथा पहलू 'अमात्रा' है, यानी जहाँ कोई ध्वनि नहीं, केवल मौन है।
            यही आत्मा की चौथी अवस्था 'तुरीय' है।
            यह किसी भी सांसारिक व्यवहार या विचार का विषय नहीं है।
            यहाँ संसार के सभी प्रपंच, द्वैत, दुख और अज्ञान पूरी तरह से समाप्त (उपशम) हो जाते हैं।
            यह अवस्था परम कल्याणकारी (शिव) है और अद्वैत (एकमात्र सत्य) है।
            इस प्रकार, संपूर्ण ॐ ही वास्तव में हमारी अपनी आत्मा है।
            जो व्यक्ति इस रहस्य को जान लेता है, वह अपने शुद्ध स्वरूप को पहचान लेता है।
            वह अपनी चेतना (आत्मा) के द्वारा ही परब्रह्म (परमात्मा) में प्रवेश कर जाता है।
            उसके लिए फिर जन्म-मृत्यु का कोई चक्र नहीं बचता, वह मुक्त हो जाता है।
            यही मांडूक्य उपनिषद का अंतिम लक्ष्य और ज्ञान का सर्वोच्च शिखर है।
        """.trimIndent(),
        english = """
            The fourth aspect of OM is 'Amatra', the soundless silence that follows the chanting.
            This corresponds directly to 'Turiya', the fourth and ultimate state of the Atman.
            It is beyond all empirical experience, worldly transactions, and dualistic thought.
            In this pure silence, the illusion of the material world and all suffering completely cease.
            It is supremely auspicious, entirely peaceful, and perfectly non-dual.
            Thus, it is proven that the syllable OM is, in absolute reality, the Atman itself.
            He who realizes this ultimate truth recognizes his own divine, unconditioned nature.
            Such a wise one merges his individual self into the Supreme Self, achieving absolute union.
            He transcends the cycle of birth and death, attaining final liberation (Moksha).
            This is the ultimate teaching of the Mandukya Upanishad, representing the pinnacle of spiritual wisdom.
        """.trimIndent()
    )
)