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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

// Data Model
data class ParabrahmaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParabrahmaUpanishadScreen() {
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
                // Searchable range strictly set from 1 to 32
                if (shlokaNumber != null && shlokaNumber in 1..32) {
                    coroutineScope.launch {
                        val targetIndex = shlokaNumber - 1
                        if (targetIndex < parabrahmaShlokasList.size) {
                            listState.animateScrollToItem(targetIndex)
                        }
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-32)") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Search
            ),
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
            itemsIndexed(parabrahmaShlokasList) { _, shloka ->
                ParabrahmaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun ParabrahmaShlokaCard(shloka: ParabrahmaShloka) {
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
val parabrahmaShlokasList: List<ParabrahmaShloka> = listOf(
    ParabrahmaShloka(
        id = 1,
        sanskrit = "अथ हैनं महाशालः शौनकोऽङ्गिरसं भगवन्तं पिप्पलादं विधिवदुपसन्नः पप्रच्छ दिव्ये ब्रह्मपुरे के सम्प्रतिष्ठिता भवन्ति खलु ।",
        hindi = """
            (परब्रह्म उपनिषद का आरंभ): एक समय महान गृहस्थ शौनक ने महर्षि पिप्पलाद के पास विधिवत उपस्थित होकर अत्यंत विनम्रता से पूछा:
            "हे भगवन! इस दिव्य 'ब्रह्मपुर' (मानव शरीर रूपी पवित्र नगर) में वास्तव में कौन प्रतिष्ठित (विद्यमान) हैं?"
            यह उपनिषद शरीर को केवल हाड़-मांस का पुतला नहीं मानता, बल्कि इसे एक परम पवित्र 'दिव्य नगर' (Divine City) का दर्जा देता है।
            जिस प्रकार एक राजा अपने भव्य महल में निवास करता है, उसी प्रकार इस शरीर रूपी महल में कौन सा महान राजा विराजमान है?
            यह सवाल अध्यात्म की सबसे पहली और गहरी खोज है, जो इंसान की बाहरी दौड़ को रोककर उसे अपने भीतर झांकने पर मजबूर करता है।
            हम पूरी जिंदगी बाहर की दुनिया को जानने में लगा देते हैं, पर यह कभी नहीं सोचते कि हमारे अपने ही सीने में कौन धड़क रहा है।
            शौनक का यह प्रश्न उस सर्वोच्च सत्य की ओर इशारा करता है, जहाँ बाहर की दुनिया का शोर नहीं, बल्कि भीतर की शुद्ध चेतना का साम्राज्य है।
            यह श्लोक साबित करता है कि वेदान्त का ज्ञान केवल गुफाओं में रहने वाले संन्यासियों के लिए नहीं, बल्कि 'महाशाल' (गृहस्थों) के लिए भी उतना ही जरूरी है।
        """.trimIndent(),
        english = """
            (The magnificent beginning of Parabrahma Upanishad): Once, the great householder Shaunaka approached the venerable Sage Pippalada in the strictly prescribed manner and respectfully asked:
            "O Venerable One! Who exactly is firmly established and majestically residing in this divine city of Brahman (the human body)?"
            This phenomenal Upanishad absolutely refuses to view the human body as a mere cheap puppet of flesh and blood; it elevates it to an exceptionally sacred 'Divine City'.
            Just exactly as a magnificent king resides securely in his grand palace, exactly which supreme king is actively ruling from within this physical palace?
            This profound question is the absolute first and deepest quest of true spirituality, forcefully stopping a human's blind external race and compelling him to fiercely look within.
            We waste our entire pathetic lives aggressively trying to know the external world, but absolutely never pause to question who exactly is pulsating right inside our own chest.
            Shaunaka's brilliant question points directly toward that Ultimate Truth, where absolutely no external worldly noise exists, but exclusively the silent empire of pure consciousness reigns.
            This magnificent verse flawlessly proves that the supreme wisdom of Vedanta is absolutely not restricted to monks, but is equally vital for active householders living squarely in the world.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 2,
        sanskrit = "कथं सृज्यन्ते । क एष महिमा विभुः । क एषः । तस्मै स होवाच ।",
        hindi = """
            "ये सभी पदार्थ कैसे उत्पन्न होते हैं? यह सर्वव्यापी महान महिमा किसकी है? वह परम सत्ता (स्वामी) कौन है?"
            तब महर्षि पिप्पलाद ने शौनक को उत्तर देते हुए यह परम ज्ञान कहा।
            जिज्ञासा (Curiosity) ज्ञान की सबसे पहली सीढ़ी है। जब तक इंसान के मन में ब्रह्मांड के निर्माण को लेकर सवाल नहीं उठते, तब तक वह पशु के समान है।
            शौनक केवल यह नहीं पूछ रहे कि दुनिया कैसे बनी; वे पूछ रहे हैं कि इसे बनाने वाले का असली 'स्वरूप' और महिमा (Glory) क्या है।
            अज्ञानी इंसान दुनिया की चमक-दमक देखकर उसमें खो जाता है, पर एक बुद्धिमान साधक उस चमक के पीछे छिपे असली 'सूरज' (ईश्वर) को खोजना चाहता है।
            महर्षि पिप्पलाद का उत्तर कोई साधारण जवाब नहीं है, यह साक्षात् ब्रह्मविद्या का विस्फोट है जो शिष्य के सारे भ्रमों को एक ही बार में काट देगा।
            गुरु और शिष्य का यह संवाद सनातन धर्म की उस महान परंपरा को दर्शाता है जहाँ सवाल पूछने की पूरी आज़ादी है।
            सच्चा ज्ञान अंधविश्वास से नहीं, बल्कि सही गुरु से सही सवाल पूछने पर ही प्राप्त होता है।
        """.trimIndent(),
        english = """
            "How exactly are all these objects created? Whose all-pervading, supreme glory is this? Who exactly is that Supreme Reality?"
            To him, the great Sage Pippalada replied, imparting this supreme wisdom.
            Curiosity is undeniably the absolute first step of supreme knowledge. Until a human questions the cosmos's creation, his intellect remains dormant.
            Shaunaka is absolutely not merely asking how the physical world was made; he is profoundly questioning the actual 'Nature' and Glory of its Creator.
            An ignorant human becomes hopelessly lost seeing the cheap glitter of the world, but a highly wise seeker fiercely wants to discover the real 'Sun' (God) hidden behind that glitter.
            Sage Pippalada's reply is absolutely no ordinary answer; it is a massive explosion of Brahma-Vidya that will brutally sever all the disciple's illusions at once.
            This flawless dialogue between Guru and disciple spectacularily displays Sanatana Dharma's magnificent tradition where questioning is completely encouraged.
            True, absolute wisdom is absolutely never attained through blind faith, but strictly by asking the exact right questions to a genuine Guru.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 3,
        sanskrit = "एतत्सत्यं यत्प्रब्रवीमि ब्रह्मविद्यां वरिष्ठां देवेभ्यः प्राणेभ्यः । परब्रह्मपुरे विरजं निष्कलं शुभ्रमक्षरं विरजं विभाति ।",
        hindi = """
            "मैं जो कह रहा हूँ वह परम सत्य है। यह सबसे श्रेष्ठ 'ब्रह्मविद्या' है जो देवताओं और प्राणों को भी प्रकाशित करती है।
            उस परब्रह्म के नगर (हृदय) में वह परम शुद्ध, कलंक-रहित, शुभ्र और अविनाशी ब्रह्म ही चमकता है।"
            यहाँ ऋषि बहुत ही कड़े शब्दों में स्पष्ट करते हैं कि शरीर के अंदर कोई हाड़-मांस का खजाना नहीं, बल्कि वह चमकता हुआ परमेश्वर है।
            यह 'ब्रह्मविद्या' (ईश्वर को जानने का विज्ञान) दुनिया की किसी भी दूसरी विद्या (जैसे इंजीनियरिंग या मेडिसिन) से 'वरिष्ठां' (सबसे श्रेष्ठ) है।
            क्यों? क्योंकि बाकी सारी विद्याएं केवल इस भौतिक दुनिया में काम आती हैं और मौत के साथ खत्म हो जाती हैं।
            पर ब्रह्मविद्या इंसान को साक्षात् देवताओं (देवेभ्यः) से भी ऊपर उठा देती है और मौत के डर को हमेशा के लिए खत्म कर देती है।
            वह ब्रह्म 'निष्कलं' (बिना किसी दाग या दोष के) और 'शुभ्रम' (सफ़ेद/अत्यंत प्रकाशमान) है; वह हमारे पापों से कभी गंदा नहीं होता।
            हम चाहे जितने भी बुरे काम कर लें, हमारे हृदय में बैठा वह परमेश्वर हमेशा 100% शुद्ध और बेदाग ही रहता है।
        """.trimIndent(),
        english = """
            "What I actively speak is the absolute truth. This is the absolute most supreme 'Brahma-Vidya', superior even to the gods and vital breaths.
            Strictly within the city of the Supreme Brahman (the heart), shines that exceptionally pure, spotless, radiant, and indestructible Brahman alone."
            Here the sage explicitly and fiercely clarifies that inside the body lies absolutely no treasure of flesh and bone, but that brilliantly shining Supreme Lord.
            This 'Brahma-Vidya' (the science of knowing God) is profoundly 'Varishtham' (the absolute highest) compared to any other worldly science.
            Why exactly? Because absolutely all other sciences function exclusively in this physical world and violently die the moment physical death occurs.
            But Brahma-Vidya flawlessly elevates a human being infinitely higher than the very gods themselves and permanently annihilates the terrifying fear of death.
            That Brahman is 'Nishkalam' (entirely without any blemish or flaw) and 'Shubhram' (pure white/brilliantly radiant); He is absolutely never dirtied by our sins.
            No matter how many horrific sins we commit, that Supreme Lord seated right in our heart remains 100% permanently pure and utterly spotless forever.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 4,
        sanskrit = "स नियच्छति मधुकरराज इव । अकर्मस्वपुरस्थितः ।",
        hindi = """
            "जिस प्रकार मधुमक्खियों का राजा (रानी मक्खी) अन्य सभी मक्खियों को नियंत्रित करता है, उसी प्रकार वह परमात्मा।
            बिना कोई भी कर्म किए (अकर्म), अपने शरीर रूपी नगर (स्वपुर) में स्थित रहकर सभी इंद्रियों और प्राणों को नियंत्रित करता है।"
            भगवान कुछ भी 'करते' नहीं हैं; उनकी केवल उपस्थिति (Presence) मात्र से ही हमारे प्राण और इंद्रियां अपना-अपना काम करने लगते हैं।
            जैसे चुंबक (Magnet) लोहे को छूता नहीं है, पर उसकी मौजूदगी से ही लोहा खिंचने लगता है, वैसे ही आत्मा कुछ नहीं करती, पर उसके प्रकाश से शरीर चलता है।
            हम अज्ञानवश सोचते हैं कि "मैं" (मेरा अहंकार) इस शरीर को चला रहा हूँ; पर सच तो यह है कि 'अहंकार' भी केवल एक नौकर (मक्खी) है।
            असली 'मधुकरराज' (रानी मक्खी) वह आत्मा है जो चुपचाप बिना हिले-डुले सब कुछ कंट्रोल कर रही है।
            जब रानी मक्खी उड़ती है, तो सारी मक्खियाँ उसके पीछे उड़ जाती हैं; उसी तरह जब मृत्यु के समय आत्मा शरीर छोड़ती है, तो सारे प्राण (सांसें) और इंद्रियां शरीर छोड़कर निकल जाते हैं।
            यह श्लोक साबित करता है कि हम शरीर नहीं, बल्कि उस 'राजा' (चेतना) का ही स्वरूप हैं।
        """.trimIndent(),
        english = """
            "Just exactly as the king of bees flawlessly controls absolutely all other bees, in the exact same manner, that Supreme Lord.
            Entirely without performing absolutely any physical actions Himself (Akarma), strictly governs all the senses and vital breaths while peacefully residing in the city of the body."
            God absolutely does not 'do' anything; strictly by His mere Presence alone, our vital breaths and physical senses automatically begin performing their respective tasks.
            Exactly as a Magnet never physically touches iron yet its mere presence violently pulls it, identically the Soul does nothing, yet its pure light completely operates the body.
            Out of thick ignorance, we falsely assume that "I" (my toxic ego) am running this body; but the absolute truth is that the 'Ego' itself is merely a cheap servant (bee).
            The actual, real 'Madhukararaja' (Queen Bee) is that pure Soul silently controlling absolutely everything entirely without moving a single millimeter.
            When the queen bee flies, absolutely all other bees instantly fly behind her; similarly, when the Soul leaves the body at death, all vital breaths instantly depart.
            This spectacular verse perfectly proves that we are absolutely not this gross body, but strictly the direct embodiment of that majestic 'King' (Consciousness).
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 5,
        sanskrit = "कर्ममर्मज्ञाता कर्म करोति । कर्ममर्म ज्ञात्वा कर्म कुर्यात् ।",
        hindi = """
            "जो व्यक्ति कर्म के मर्म (गहरे रहस्य) को जानता है, वास्तव में वही सच्चा कर्म करता है।
            इसलिए मनुष्य को कर्म के परम रहस्य (निष्काम भाव और अनासक्ति) को भलीभांति जानकर ही कोई भी कार्य करना चाहिए।"
            अज्ञानी लोग फल की लालच में अंधे होकर कर्म करते हैं; पर ज्ञानी जानता है कि कर्म केवल एक नाटक है, असली सत्य तो भीतर की शांति है।
            कर्म का 'मर्म' (Secret) क्या है? मर्म यह है कि दुनिया का कोई भी कर्म (चाहे वह दान हो या पूजा) आपको मोक्ष नहीं दे सकता।
            कर्म केवल आपके मन को साफ करने (चित्त शुद्धि) के लिए हैं; मोक्ष तो केवल 'ज्ञान' से ही मिलता है।
            जब इंसान यह मर्म जान लेता है, तो वह ऑफिस का काम भी करता है और परिवार भी पालता है, पर उसके मन में कोई 'टेंशन' (Tension) नहीं होती।
            वह जानता है कि यह सब केवल 'माया का खेल' है, और वह खुद को उस खेल का 'साक्षी' (Witness) मानकर कर्म करता है।
            यही निष्काम कर्मयोग की चरम सीमा है, जहाँ इंसान दुनिया में रहते हुए भी दुनिया के कीचड़ (कर्म-बंधन) से कमल की तरह अछूता रहता है।
        """.trimIndent(),
        english = """
            "He who flawlessly knows the deep secret (essence) of action, truly and genuinely acts.
            Therefore, a human being must perform actions exclusively only after thoroughly understanding the supreme secret of selfless action and non-attachment."
            Ignorant people act blindly out of fierce greed for fruits; but the wise sage knows flawlessly that action is merely a drama, the absolute truth is inner peace.
            What exactly is the 'Marma' (Secret) of action? The supreme secret is that absolutely no action in the world (whether massive charity or worship) can ever grant you Moksha.
            Actions exclusively exist strictly to purify your mind; ultimate Moksha is attained entirely and exclusively through pure 'Wisdom' alone.
            When a human completely understands this profound secret, he actively does office work and intensely raises a family, yet his mind has absolutely zero 'Tension'.
            He flawlessly knows that absolutely all this is merely the 'Game of Maya', and he performs actions strictly viewing himself as a silent 'Witness' to the game.
            This is the absolute highest peak of Nishkama Karma Yoga, where a human active in the world remains 100% permanently untouched by karmic mud, exactly like a spotless lotus.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 6,
        sanskrit = "को जालं विक्षिपेदेको नैनमपकर्षत्यपकर्षति ।",
        hindi = """
            "वह एक परमात्मा ही माया रूपी इस विशाल जाल (संसार) को फेंकता (रचता) है।
            कोई अन्य इंसान या देवता उसे खींच या समेट नहीं सकता, केवल वही परमेश्वर इस सृष्टि को वापस अपने भीतर समेटता है।"
            दुनिया भगवान का बिछाया हुआ एक खेल (जाल) है; हम इस जाल को खुद नहीं काट सकते, हमें उसी भगवान की शरण में जाना होगा जिसने इसे बिछाया है।
            यह श्लोक 'सृष्टि' (Creation) और 'प्रलय' (Dissolution) दोनों का असली कंट्रोलर (Controller) केवल एक ही ईश्वर को मानता है।
            हम इंसान बहुत घमंड करते हैं कि हमने बड़ी-बड़ी बिल्डिंग्स और टेक्नोलॉजी बना ली है; पर यह सब उसी 'माया के जाल' का ही हिस्सा है।
            जब प्रलय का समय आता है, तो इंसान की सारी साइंस और टेक्नोलॉजी एक सेकंड में खत्म हो जाती है, क्योंकि असली रिमोट-कंट्रोल (Remote Control) उसी 'एक' के हाथ में है।
            जिसने यह जाल (माया) बिछाया है, केवल वही इंसान को इस जाल से बाहर (मोक्ष) निकाल सकता है।
            इसलिए ज्ञानी पुरुष इस दुनिया से लड़ने या इसे सुधारने की कोशिश नहीं करता; वह चुपचाप उस जाल बिछाने वाले मालिक से जुड़ जाता है और हमेशा के लिए आज़ाद हो जाता है।
        """.trimIndent(),
        english = """
            "That One Supreme Lord alone effortlessly casts (creates) this massive net of Maya (illusion / the world).
            Absolutely no other human or god can withdraw or dissolve it; He alone flawlessly withdraws this cosmic creation back strictly into Himself."
            The world is an exceptionally massive game (net) laid out by God; we absolutely cannot cut this net ourselves, we must surrender completely to the exact God who laid it.
            This phenomenal verse profoundly declares exactly One single Lord as the absolute, ultimate Controller of both 'Creation' and cosmic 'Dissolution'.
            We humans arrogantly boast that we have built massive skyscrapers and advanced technology; but all this is merely a tiny part of that exact same 'Net of Maya'.
            When the terrifying time of cosmic dissolution arrives, humanity's entire science vanishes in exactly one second, because the real Remote Control is strictly in His hands alone.
            He who flawlessly laid this terrifying net (Maya) is the absolute only one who can pull a human completely out of it (grant Moksha).
            Therefore, the wise sage absolutely never fights the world or foolishly tries to fix it; he silently connects directly to the Master of the net and becomes permanently free.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 7,
        sanskrit = "प्राणापानौ समाधाय ध्यात्वा तं परमेस्वरम् ।",
        hindi = """
            "साधक को अपने भीतर चलने वाले प्राण (अंदर आती हुई सांस) और अपान (बाहर जाती हुई सांस) को पूरी तरह से समान (शांत) करके।
            उस परमेश्वर का अत्यंत गहराई से ध्यान (Meditation) करना चाहिए।"
            सांसों का सीधा संबंध हमारे मन से है; जब तक सांसें तेज चलती हैं, मन दौड़ता रहता है। योग का पहला कदम सांसों को शांत करना है।
            प्राण और अपान को 'समाधाय' (समान करने) का अर्थ है साँसों का एक ऐसी लय (Rhythm) में आ जाना जहाँ न अंदर खींचने का जोर लगे और न बाहर धकेलने का।
            जब सांसें बिल्कुल एक बारीक धागे की तरह शांत हो जाती हैं, तो हमारा चंचल दिमाग (Mind) अपने-आप शून्य (Blank) हो जाता है।
            उसी सन्नाटे और खालीपन में ही उस 'परमेश्वर' का असली ध्यान लग सकता है।
            अशांत मन से आप केवल भगवान की मूर्ति के आगे भीख मांग सकते हैं, पर शांत सांसों से आप सीधा उस भगवान के 'सर्वर' (Server) से कनेक्ट (Connect) हो जाते हैं।
            यह श्लोक प्राणायाम (Pranayama) को ध्यान (Dhyana) की सबसे बड़ी सीढ़ी मानता है; साँसें ही मन को कंट्रोल करने का असली स्टीयरिंग व्हील (Steering wheel) हैं।
        """.trimIndent(),
        english = """
            "By completely balancing, unifying, and perfectly stilling the incoming (Prana) and outgoing (Apana) vital breaths.
            The seeker must profoundly and exceptionally deeply meditate upon that Supreme Lord."
            Breaths have an absolutely direct connection strictly to our mind; as long as breaths are rapid, the mind runs violently. The absolute first step of Yoga is stilling the breath.
            To 'Samadhaya' (perfectly balance) Prana and Apana profoundly means bringing the breath to such a flawless rhythm where there is zero effort to inhale or exhale.
            When the physical breaths become exceptionally calm exactly like a microscopic fine thread, our highly restless brain automatically becomes perfectly empty (Blank).
            It is strictly and exclusively in that profound silence and deep void that actual, true meditation on the 'Supreme Lord' occurs.
            With a chaotic mind, you can only pathetically beg before an idol; but with perfectly still breaths, you connect instantly directly to God's main Server.
            This spectacular verse declares Pranayama as the absolute greatest ladder to Dhyana; the breath itself is the actual Steering Wheel to flawlessly control the mind.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 8,
        sanskrit = "अन्तःशरीरे निहितो गुहायामज एको नित्यमस्य पृथिवी शरीरम् ।",
        hindi = """
            "वह अजन्मा (अज), अद्वितीय और नित्य परमात्मा इस भौतिक शरीर के भीतर हृदय रूपी गुफा में अत्यंत गहराई से स्थित है।
            यह संपूर्ण पृथ्वी (और ब्रह्मांड) ही उसका एक बहुत बड़ा शरीर है।"
            यहाँ बहुत ही सुंदर अद्वैत बताया गया है: भगवान छोटा बनकर तुम्हारे दिल में बैठा है, और वही बड़ा बनकर इस पूरे ब्रह्मांड के रूप में फैला हुआ है।
            हम अज्ञानवश भगवान को मंदिरों, मस्जिदों या आसमान में खोजते हैं, जबकि उपनिषद साफ कह रहा है कि वह 'अन्तःशरीरे' (तुम्हारे अपने ही शरीर के अंदर) है।
            वह परमात्मा 'अज' (कभी न पैदा होने वाला) है; इसलिए वह कभी मरेगा भी नहीं। तुम्हारी असली आत्मा वही परमात्मा है।
            और जिस 'पृथ्वी' पर हम घमंड करते हैं कि यह हमारी प्रॉपर्टी (Property) है, वह पृथ्वी तो उस अनंत भगवान का सिर्फ एक नाखून (या भौतिक शरीर) मात्र है!
            जब इंसान को यह अहसास होता है कि उसके दिल में धड़कने वाली चेतना और पूरे ब्रह्मांड को चलाने वाली शक्ति एक ही है, तो उसका सारा डर खत्म हो जाता है।
            अपने भीतर के ईश्वर (Micro) और ब्रह्मांड के ईश्वर (Macro) को एक जान लेना ही मोक्ष का परम सूत्र है।
        """.trimIndent(),
        english = """
            "That unborn (Aja), non-dual, and eternal Supreme Lord is exceptionally deeply hidden and firmly seated right inside the cave of the heart within this physical body.
            This entire colossal earth (and universe) itself is exactly His massive physical body."
            An exceptionally beautiful Advaita is revealed here: God sits flawlessly exactly inside your tiny heart, and that exact same God expands boundlessly as the entire vast cosmos.
            Out of thick ignorance, we blindly search for God in physical temples or the sky, while the Upanishad fiercely declares He is 'Antahsharire' (strictly inside your own body).
            That Supreme Lord is 'Aja' (absolutely never born); therefore, He will absolutely never die. Your actual, true Soul is exactly that Supreme Lord Himself.
            And this 'Earth' which we arrogantly claim as our petty property is merely a tiny fingernail (or gross physical body) of that infinite God!
            When a human profoundly realizes that the pure consciousness pulsating in his heart and the massive power operating the cosmos are identically one, all his fear permanently dies.
            Flawlessly knowing the God within (Micro) and the God of the cosmos (Macro) as exactly one and identical is the ultimate supreme formula for Moksha.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 9,
        sanskrit = "सशिखं वपनं कृत्वा बहिःसूत्रं त्यजेद्बुधः । यदक्षरं परं ब्रह्म तत्सूत्रमिति धारयेत् ॥",
        hindi = """
            (संन्यास और सच्चे यज्ञोपवीत का नियम): "एक बुद्धिमान साधक को चाहिए कि वह अपनी शिखा (चोटी) सहित बालों का मुंडन करा ले और बाहरी धागे (जनेऊ) का त्याग कर दे।
            और जो कभी नष्ट न होने वाला 'परम ब्रह्म' (Supreme Reality) है, केवल उसी को अपना सच्चा 'सूत्र' (जनेऊ) मानकर हृदय में धारण करे।"
            यह परब्रह्म उपनिषद का सबसे मुख्य संदेश है। बाहरी धागा (सूती जनेऊ) टूट सकता है या मैला हो सकता है; पर जो 'ब्रह्म-ज्ञान' रूपी जनेऊ है, वह कभी टूटता नहीं।
            हिन्दू धर्म में जनेऊ (यज्ञोपवीत) पहनना ब्रह्मचर्य और ज्ञान का प्रतीक है; पर उपनिषद कहता है कि धागा पहन लेना काफी नहीं है, वह तो केवल एक 'रिमाइंडर' (Reminder) है।
            असली जनेऊ (सूत्र) वह ज्ञान है कि "मैं साक्षात् ब्रह्म हूँ"। जब इंसान को यह ज्ञान हो जाता है, तो उसे धागे की कोई जरूरत नहीं रहती।
            'वपनं कृत्वा' (मुंडन कराना) का अर्थ केवल बाल काटना नहीं है, बल्कि अपने दिमाग से दुनिया भर के घमंड और विचारों को काट कर फेंक देना है।
            जब साधक अपने अहंकार को मुंडवा लेता है, तभी वह उस 'अक्षरं' (कभी न मिटने वाले) ब्रह्म को अपने भीतर धारण कर सकता है।
            यह श्लोक कर्मकांड (Rituals) से ऊपर उठकर ज्ञान मार्ग (Path of Wisdom) पर चलने का सबसे बड़ा आदेश है।
        """.trimIndent(),
        english = """
            (The supreme rule of Sannyasa and true sacred thread): "A highly wise seeker must completely shave his head including the tuft of hair, and entirely discard the external physical sacred thread.
            And strictly that indestructible 'Supreme Brahman' (Ultimate Reality), he must flawlessly wear exclusively that alone as his actual, true internal Thread."
            This is the absolute core message of Parabrahma Upanishad. The external cotton thread can easily break or get dirty; but the thread of 'Brahma-Jnana' absolutely never breaks.
            Wearing the Yajnopavita is merely a symbolic physical reminder of purity and wisdom; but the Upanishad fiercely declares that merely wearing a physical thread is absolutely not enough.
            The actual, real thread (Sutra) is the blazing wisdom that "I am exactly Brahman." When a human successfully attains this wisdom, he absolutely needs zero physical threads.
            'Vapanam kritva' (shaving the head) absolutely does not merely mean cutting physical hair; it profoundly means violently severing and throwing away all toxic worldly pride from the brain.
            Only exactly when the seeker completely shaves off his ego can he flawlessly wear that 'Aksharam' (indestructible) Brahman strictly within his heart.
            This phenomenal verse is the absolute greatest command to rise completely above cheap physical Rituals and strictly walk the supreme Path of Wisdom.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 10,
        sanskrit = "बहिःसूत्रं त्यजेद्विप्रो योगविज्ञानतत्परः । ब्रह्मभावमिदं सूत्रं धारयेद्यः स मुक्तिभाक् ॥",
        hindi = """
            "ध्यान-योग और आत्म-विज्ञान में गहराई से तत्पर रहने वाले ज्ञानी ब्राह्मण को बाहरी धागे का पूरी तरह से परित्याग कर देना चाहिए।
            जो व्यक्ति इस 'ब्रह्म-भाव' (कि मैं साक्षात् ब्रह्म हूँ) रूपी ज्ञान के सूत्र को धारण करता है, वास्तव में वही मोक्ष का सच्चा अधिकारी (मुक्तिभाक्) है।"
            जब इंसान ज्ञान के परम शिखर पर पहुँच जाता है, तो बाहरी कर्मकांड और दिखावे (Rituals) अपने-आप छूट जाते हैं। उसका मन ही उसका मंदिर बन जाता है।
            'योगविज्ञानतत्परः' का अर्थ है जो 24 घंटे केवल अपनी चेतना में डूबा रहता है। ऐसे इंसान के लिए धागा पहनना या न पहनना कोई मायने नहीं रखता।
            अगर एक अज्ञानी आदमी सोने का जनेऊ भी पहन ले, तो भी वह नरक (दुखों) में ही जियेगा, क्योंकि उसके अंदर 'ब्रह्मभाव' नहीं है।
            और अगर एक ज्ञानी बिना किसी धागे या कपड़ों के भी रहे, तो भी वह साक्षात् भगवान है, क्योंकि उसने 'मैं ब्रह्म हूँ' का असली सूत्र पहन रखा है।
            उपनिषद समाज के बनाए गए सारे दिखावटी नियमों (Social conditioning) को लात मारता है और केवल 'ज्ञान' को ही मुक्ति का एकमात्र रास्ता मानता है।
            मोक्ष किसी विशेष जाति या धागे से नहीं मिलता; मोक्ष केवल 'ब्रह्मभाव' (God-consciousness) से ही मिलता है।
        """.trimIndent(),
        english = """
            "A highly wise sage profoundly devoted strictly to Yoga and supreme Self-wisdom must completely and totally abandon the external physical thread.
            He who flawlessly wears this profound thread of 'Brahma-Bhava' (the conviction that I am Brahman) alone is truly and genuinely entitled to absolute Liberation."
            Exactly when a human successfully reaches the absolute peak of wisdom, external rituals and physical show-offs automatically drop away completely. His mind itself flawlessly becomes his supreme temple.
            'Yogavijnanatatparah' fiercely means one who remains drowned strictly in his own pure consciousness 24 hours a day. For such a master, wearing a physical thread is utterly meaningless.
            If an ignorant fool wears a physical sacred thread made of solid gold, he will still burn in hellish sorrows, strictly because he completely lacks 'Brahma-Bhava'.
            And if a supreme sage lives entirely without any threads or clothes, he is exactly God Himself, because he flawlessly wears the actual thread of "I am Brahman."
            The Upanishad brutally kicks away absolutely all fake, showy Social Conditioning and declares exclusively 'Wisdom' as the sole, ultimate path to Liberation.
            Moksha is absolutely not attained through any specific physical caste or cotton thread; Moksha is achieved strictly and exclusively through 'Brahma-Bhava' (God-consciousness) alone.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 11,
        sanskrit = "नाशुचित्वं न चोच्छिष्टं तस्य सूत्रस्य धारणात् ।",
        hindi = """
            "उस परम ज्ञान रूपी सूत्र (भीतरी जनेऊ) को धारण करने वाले व्यक्ति को कभी भी कोई अपवित्रता (अशुचित्वं), अशुद्धि या जूठापन (उच्छिष्टं) नहीं छू सकता।
            वह हमेशा-हमेशा के लिए परम पवित्र हो जाता है।"
            शारीरिक जनेऊ मल-मूत्र त्यागते समय, जन्म-मरण के सूतक लगने पर, या कुछ अशुद्ध खाने पर अपवित्र माना जाता है; पर ज्ञान की चमक को दुनिया की कोई गंदगी मैला नहीं कर सकती।
            हम शरीर को साबुन से धोकर पवित्र मानते हैं, पर शरीर अंदर से केवल मल-मूत्र की एक फैक्ट्री (Factory) है! भौतिक शरीर कभी 'पवित्र' हो ही नहीं सकता।
            असली पवित्रता शरीर की नहीं, बल्कि 'आत्मा' की होती है। आत्मा पर दुनिया का कोई कीचड़, कोई पाप या कोई सूतक कभी चिपक ही नहीं सकता।
            जिस दिन इंसान खुद को शरीर मानना छोड़कर 'ब्रह्म' मान लेता है, उसी सेकंड वह गंगाजल से भी करोड़ों गुना ज्यादा पवित्र हो जाता है।
            उसके लिए अब कोई छुआछूत, कोई अपवित्र जगह या कोई जूठा खाना मायने नहीं रखता; वह जहाँ खड़ा होता है, वह जगह तीर्थ बन जाती है।
            यह श्लोक इंसान को कर्मकांड के डरों (फलां चीज़ छूने से पाप लगेगा) से हमेशा के लिए आज़ाद कर देता है।
        """.trimIndent(),
        english = """
            "By actively wearing that supreme thread of ultimate wisdom (inner thread), absolutely no impurity (Ashuchitvam), defilement, or uncleanness (Ucchishtam) can ever possibly touch that person.
            He instantly becomes supremely and permanently pure forever."
            A physical thread is deemed severely impure during bodily functions or specific periods of mourning; but absolutely no physical dirt in the world can ever soil the brilliant radiance of true wisdom.
            We falsely consider the body pure after washing it with cheap soap, but internally the body is merely a horrific factory of filth! The physical body can absolutely never be 'pure'.
            Actual, true purity strictly belongs to the 'Soul', never the body. Absolutely no worldly mud, no horrific sin, and no defilement can ever possibly stick to the pure Soul.
            The exact split-second a human drops his physical body identity and claims his 'Brahman' nature, he instantly becomes millions of times purer than the sacred Ganges itself.
            For him, absolutely zero physical untouchability or impure food matters anymore; exactly wherever his feet touch, that exact physical spot instantly becomes a supreme pilgrimage site.
            This phenomenal verse permanently and flawlessly frees a human being from the terrifying, cheap fears of ritualistic impurities forever.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 12,
        sanskrit = "सूत्रमन्तर्गतं येषां ज्ञानयज्ञोपवीतिनाम् । ते वै सूसूत्रिणो लोके ते च यज्ञोपवीतिनः ॥",
        hindi = """
            "जिन ज्ञानी पुरुषों के बिल्कुल भीतर (हृदय में) ही यह ज्ञान रूपी यज्ञोपवीत (जनेऊ) हर समय विद्यमान है।
            इस संसार में वास्तव में केवल वही लोग सच्चे सूत्र को धारण करने वाले हैं, और सही मायने में केवल वही 'यज्ञोपवीती' कहलाने के योग्य हैं।"
            दिखावे के लिए गले में धागा पहन लेना बहुत आसान है, इसे तो कोई भी ढोंगी या मूर्ख पहन सकता है। पर हर सांस में खुद को 'ब्रह्म' महसूस करना (ज्ञान का जनेऊ) ही असली संन्यास है।
            उपनिषद यहाँ समाज के उन पाखंडियों (Hypocrites) पर करारा प्रहार कर रहा है जो बाहरी धागे का तो बहुत घमंड करते हैं, पर अंदर से लालच और नफरत से भरे हुए हैं।
            ईश्वर तुम्हारे गले का धागा नहीं देखता; ईश्वर तुम्हारे दिमाग (हृदय) का सॉफ्टवेयर (Software) देखता है।
            अगर तुम्हारे अंदर 'ज्ञान' (Self-realization) का सॉफ्टवेयर डाउनलोड (Download) हो चुका है, तो तुम ब्रह्मांड के सबसे महान ब्राह्मण हो।
            असली 'यज्ञ' (Sacrifice) आग में घी डालना नहीं है; असली यज्ञ अपने 'अहंकार' को ज्ञान की आग में जला देना है।
            और उस यज्ञ को करने वाला ही असली 'यज्ञोपवीती' है; बाकी सब केवल समाज का दिखावा (Drama) है।
        """.trimIndent(),
        english = """
            "Those supremely enlightened sages who securely possess this sacred thread of true knowledge actively and constantly strictly within themselves (in their hearts).
            In this entire world, they alone are in absolute reality the true wearers of the supreme thread, and they alone genuinely deserve to be called 'Yajnopavitis'."
            Casually wearing a physical thread around the neck for cheap display is exceptionally easy, even a massive hypocrite can wear it. But profoundly feeling oneself as 'Brahman' in every breath is actual true Sannyasa.
            The Upanishad fiercely strikes a brutal blow here against those toxic hypocrites who arrogantly boast about a cheap physical thread, yet remain internally stuffed with filthy greed and hatred.
            God absolutely does not look at the cheap cotton thread around your physical neck; God strictly examines the exact Software running inside your brain (heart).
            If the supreme software of 'Self-realization' is successfully Downloaded within you, you are undeniably the absolute greatest Brahmana in the entire cosmos.
            The actual, real 'Yajna' (Sacrifice) is absolutely not blindly pouring physical ghee into a fire; the real Yajna is ruthlessly burning your 'Ego' to absolute ashes in the blazing fire of wisdom.
            And he who flawlessly performs that exact internal sacrifice is the only true 'Yajnopaviti'; absolutely everything else is merely a cheap social Drama.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 13,
        sanskrit = "ज्ञानशिखिनो ज्ञाननिष्ठा ज्ञानयज्ञोपवीतिनः । ज्ञानमेव परं तेषां पवित्रं ज्ञानमुच्यते ॥",
        hindi = """
            "ज्ञान ही जिनकी शिखा (चोटी) है, जो हमेशा ज्ञान में ही पूरी तरह स्थित (निष्ठा) हैं, और ज्ञान ही जिनका एकमात्र जनेऊ है;
            उनके लिए केवल और केवल 'ज्ञान' ही सबसे श्रेष्ठ है, और ज्ञान को ही दुनिया का सबसे बड़ा पवित्र करने वाला तत्त्व कहा गया है।"
            पानी शरीर की गंदगी को साफ़ करता है, साबुन कीटाणुओं को मारता है; पर ज्ञान आत्मा से करोड़ों जन्मों के कर्मों का कचरा एक ही सेकंड में धो डालता है।
            दुनिया में 'ज्ञान' (कि मैं ब्रह्म हूँ) से बड़ा कोई सैनिटाइजर (Sanitizer) या गंगाजल नहीं है।
            जो योगी इस ज्ञान में 'निष्ठा' (Firmly established) रखता है, उसे पवित्र होने के लिए किसी नदी में नहाने या किसी मंदिर में जाने की कोई आवश्यकता नहीं है।
            उसकी शिखा (चोटी) भी ज्ञान है, उसका जनेऊ भी ज्ञान है, और उसका पूरा जीवन ही साक्षात् चलता-फिरता ज्ञान बन चुका है।
            अज्ञानी लोग पवित्रता को बाहरी चीजों (कपड़े, भोजन, नहाने) में खोजते हैं, पर उपनिषद डंके की चोट पर कहता है कि पवित्रता केवल एक 'विचार' (Thought) है।
            और दुनिया का सबसे पवित्र विचार केवल एक है: "अहं ब्रह्मास्मि" (मैं साक्षात् भगवान हूँ)।
        """.trimIndent(),
        english = """
            "Those whose tuft of hair is pure wisdom, who are flawlessly established and anchored strictly in wisdom, and whose absolute sacred thread is wisdom;
            For them, exclusively 'Wisdom' alone is supreme, and wisdom is profoundly declared as the world's absolute greatest purifying principle."
            Physical water cleans the physical dirt of the body, soap kills physical germs; but blazing wisdom ruthlessly washes away the massive toxic garbage of millions of past karmas in a single split-second.
            There is absolutely no greater Sanitizer or sacred Ganges water in the entire cosmos than pure 'Wisdom' (the realization that I am Brahman).
            The master Yogi who holds unbreakable 'Nishtha' (firm establishment) in this wisdom absolutely needs zero physical rivers or temples to become pure.
            His tuft is wisdom, his sacred thread is wisdom, and his entire existence has flawlessly transformed into living, walking, breathing wisdom incarnate.
            Ignorant fools blindly search for purity in external physical things (clothes, food, bathing), but the Upanishad fiercely declares that purity is strictly a profound 'Thought'.
            And the absolute single purest thought in the entire universe is strictly: "Aham Brahmasmi" (I am exactly God Himself).
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 14,
        sanskrit = "अग्नेरिव शिखा नान्या यस्य ज्ञानमयी शिखा । स शिखीत्युच्यते विद्वान्नेतरे केशधारिणः ॥",
        hindi = """
            "जिस प्रकार अग्नि की ज्वाला ही उसकी असली शिखा (चोटी) है, उसी प्रकार जिस ज्ञानी की शिखा पूरी तरह से 'ज्ञानमयी' (रोशनी से भरी) है।
            उसी विद्वान को वास्तव में सच्चा 'शिखी' (चोटी धारण करने वाला) कहा जाता है। केवल सिर पर लंबे बाल रखने वाले लोग असली शिखी नहीं होते।"
            उपनिषद यहाँ कर्मकांड के अंधेपन पर गहरी चोट कर रहा है। शरीर पर बाल बढ़ा लेना या सिर मुंडवा लेना कोई आध्यात्मिक उपलब्धि नहीं है!
            असली 'शिखा' (चोटी) का मतलब है चेतना की वह ज्वाला (Flame) जो हमेशा ऊपर की ओर उठती है, ठीक आग की लपटों की तरह।
            जब इंसान के दिमाग में आत्मज्ञान का विस्फोट होता है, तो उसके भीतर एक तेज रोशनी (ज्ञानमयी शिखा) जल उठती है जो सारे अज्ञान को भस्म कर देती है।
            जिसके भीतर यह आग जल रही है, केवल वही असली 'विद्वान' है; बाकी जो लोग केवल बालों की चोटी रखकर खुद को महान समझते हैं, वे केवल पाखंडी हैं।
            वेदान्त धर्म के नाम पर होने वाले हर बाहरी नाटक (Drama) को रिजेक्ट (Reject) करता है और इंसान का फोकस सीधे उसके 'दिमाग' (Mind) पर ले जाता है।
            बालों की चोटी कैंची से काटी जा सकती है, पर ज्ञान की चोटी को मौत भी नहीं काट सकती।
        """.trimIndent(),
        english = """
            "Just exactly as the brilliant flame of a fire is its actual, real tuft, identically similarly, the wise one whose tuft is purely 'Knowledge' (radiant with light).
            He alone is truly and properly declared a genuine 'Shikhi' (wearer of the tuft). Ignorant people merely growing long physical hair absolutely do not make one a true Shikhi."
            The Upanishad strikes a fierce, brutal blow here against the blind hypocrisy of empty rituals. Growing physical hair or shaving the head is absolutely zero spiritual achievement!
            The actual, real 'Shikha' (tuft) profoundly means that blazing Flame of consciousness that perpetually rises upwards, exactly like the furious flames of a fire.
            When the massive explosion of Self-knowledge occurs in a human's brain, a blinding light (the tuft of wisdom) ignites within him, brutally burning all dark ignorance to ashes.
            He inside whom this blazing fire burns is the absolute only true 'Scholar'; the rest who proudly boast merely of physical hair are nothing but cheap hypocrites.
            Vedanta ruthlessly Rejects absolutely every external physical Drama performed in the name of religion and forcefully shifts human focus directly to the 'Mind'.
            A physical tuft of hair can easily be cut with cheap scissors, but the supreme tuft of wisdom absolutely cannot be severed even by Death itself.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 15,
        sanskrit = "कर्मण्यधिकृता ये तु वैदिके ब्राह्मणादयः । तैर्विधार्यमिदं सूत्रं क्रियाङ्गं तद्धि वै स्मृतम् ॥",
        hindi = """
            "जो ब्राह्मण आदि लोग अभी केवल वैदिक कर्मकाण्डों (यज्ञ, पूजा-पाठ) में ही लगे हुए हैं और जिन्हें अभी तक आत्मज्ञान नहीं हुआ है।
            उन्हें ही यह बाहरी धागा (सूती जनेऊ) धारण करना चाहिए, क्योंकि इसे केवल बाहरी कर्मों का एक अंग (हिस्सा) माना गया है (ज्ञानियों के लिए यह जरूरी नहीं)।"
            शुरुआती स्तर पर (Primary class में) कर्मकांड, पूजा-पाठ और नियम बहुत जरूरी हैं ताकि इंसान का मन अनुशासित (Disciplined) हो सके।
            पर उपनिषद स्पष्ट कर रहा है कि ये बाहरी नियम केवल उन लोगों के लिए हैं जो अभी 'अज्ञानी' हैं और मोक्ष के रास्ते पर बस चलना शुरू कर रहे हैं।
            जब कोई इंसान ध्यान और वेदान्त के द्वारा साक्षात् ब्रह्मज्ञान (Ph.D) प्राप्त कर लेता है, तो ये सारे छोटे नियम अपने आप छूट जाते हैं।
            जैसे साइकिल सीखते समय 'ट्रेनिंग व्हील्स' (Training wheels) लगाए जाते हैं, पर जब बैलेंस (Balance) आ जाता है तो उन्हें निकाल दिया जाता है।
            उसी तरह बाहरी जनेऊ (सूत्र) केवल कर्मकांड के ट्रेनिंग व्हील्स हैं; ज्ञान हो जाने के बाद इनकी कोई आवश्यकता नहीं बचती।
            ज्ञानी पुरुष कर्मों (क्रिया) से ऊपर उठ चुका होता है, इसलिए उसे कर्मों के 'अंग' (जनेऊ) की भी कोई जरूरत नहीं होती।
        """.trimIndent(),
        english = """
            "Those Brahmanas and others who are still strictly engaged exclusively only in external Vedic rituals (Yajnas, basic worship) and have absolutely not attained Self-knowledge.
            They alone must wear this external physical thread, as it is profoundly considered merely an accessory for external actions (absolutely not necessary for the enlightened)."
            At the beginner level (Primary class), strict physical rituals, worship, and heavy rules are absolutely mandatory to successfully Discipline the highly chaotic human mind.
            But the Upanishad fiercely clarifies that these external rules exist exclusively for those who are still 'ignorant' and merely taking their first baby steps on the path of Moksha.
            Exactly when a human successfully attains direct Brahma-Jnana (Ph.D.) strictly through meditation and Vedanta, all these petty rules automatically drop away forever.
            Exactly as 'Training Wheels' are heavily utilized when first learning to ride a bicycle, but are ruthlessly removed the exact second flawless Balance is achieved.
            Similarly, the external physical thread is merely the training wheels of early rituals; immediately after absolute wisdom is attained, their utility drops entirely to zero.
            The enlightened sage has completely risen infinitely above all physical actions (Kriya), hence he absolutely requires zero accessories (thread) associated with those petty actions.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 16,
        sanskrit = "शिखा ज्ञानमयी यस्य उपवीतं च तन्मयम् । ब्राह्मण्यं सकलं तस्य इति ब्रह्मविदो विदुः ॥",
        hindi = """
            "जिस योगी की शिखा (चोटी) पूरी तरह से ज्ञानमयी है, और जिसका जनेऊ भी केवल ज्ञान का ही बना हुआ है।
            उसी का 'ब्राह्मणत्व' (Brahminhood) सबसे सच्चा और पूर्ण (सकलं) है; ऐसा साक्षात् ब्रह्म को जानने वाले महान ज्ञानी लोग मानते हैं।"
            ब्राह्मण वह नहीं है जो किसी विशेष जाति, गोत्र या परिवार में पैदा हुआ हो; ब्राह्मण की यह परिभाषा पूरी तरह से अज्ञानियों की बनाई हुई है।
            वेदान्त की डिक्शनरी (Dictionary) में 'ब्राह्मण' का मतलब केवल एक है: "ब्रह्म जानाति इति ब्राह्मणः" (जो साक्षात् 'ब्रह्म' को जान लेता है, वही ब्राह्मण है)।
            अगर कोई इंसान नीची से नीची जाति में भी पैदा हुआ हो, पर अगर उसके दिमाग में 'आत्मज्ञान' का विस्फोट हो चुका है, तो वह पूरे ब्रह्मांड का सबसे बड़ा ब्राह्मण है।
            और अगर कोई ऊँची जाति में पैदा होकर भी अज्ञानी और लालची है, तो वह ब्राह्मण कहलाने के लायक ही नहीं है।
            'सकलं' (पूर्ण) ब्राह्मणत्व कोई जन्म का अधिकार (Birthright) नहीं है; यह अपनी मेहनत, ध्यान और ज्ञान से हासिल की जाने वाली परम अवस्था (State of consciousness) है।
            यह श्लोक सनातन धर्म के सबसे बड़े और सबसे क्रांतिकारी रहस्यों में से एक है जो जन्म के आधार पर फैले हुए जातिवाद को जड़ से उखाड़ फेंकता है।
        """.trimIndent(),
        english = """
            "He whose tuft of hair is entirely and flawlessly made of pure wisdom, and whose sacred thread is identically composed strictly of wisdom alone.
            His 'Brahminhood' alone is the absolute truest and completely perfect (Sakalam); so fiercely declare the magnificent sages who directly know Brahman."
            A Brahmana is absolutely not one casually born into a specific physical caste, gotra, or family; that cheap definition is entirely manufactured by highly ignorant fools.
            In the supreme dictionary of Vedanta, 'Brahmana' strictly has only one absolute meaning: "Brahma janati iti Brahmanah" (He who directly knows 'Brahman' is a Brahmana).
            Even if a human is physically born in the absolute lowest possible caste, but the massive explosion of 'Self-knowledge' has occurred in his brain, he is undeniably the absolute greatest Brahmana in the entire cosmos.
            And if someone is born in the highest physical caste but remains deeply ignorant and fiercely greedy, he absolutely does not deserve to be called a Brahmana whatsoever.
            'Sakalam' (Perfect) Brahminhood is absolutely no cheap Birthright; it is an ultimate State of Consciousness that must be brutally earned strictly through intense meditation and absolute wisdom.
            This phenomenal verse is undeniably one of Sanatana Dharma's absolute greatest and most fiercely revolutionary secrets, ruthlessly uprooting the toxic illusion of birth-based casteism forever.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 17,
        sanskrit = "इदं यज्ञोपवीतं तु परमं यत्परायणम् । स विद्वान्यज्ञोपवीती स्यात्स यज्ञास्तद्विदां वरः ॥",
        hindi = """
            "ज्ञान का यह जनेऊ ही सबसे परम, सर्वोच्च और अंतिम आश्रय (परायणम्) है।
            जो विद्वान इस ज्ञान के जनेऊ को धारण करता है, वास्तव में वही सच्चा यज्ञोपवीती है, और वही ज्ञानियों में सबसे अधिक श्रेष्ठ (वरः) है।"
            जब इंसान भौतिक जनेऊ पहनता है, तो उसे उसे साफ रखने की, बदलने की और कर्मकांड करने की टेंशन (Tension) होती है।
            पर जब इंसान 'ज्ञान' (Self-realization) को ओढ़ लेता है, तो उसे किसी बाहरी सहारे की जरूरत नहीं रहती; वह ज्ञान ही उसका सबसे बड़ा और परमानेंट 'आश्रय' (Refuge) बन जाता है।
            दुनिया की हर चीज़—पैसा, रिश्ते, शरीर—एक दिन धोखा दे जाती है, पर यह 'आत्मज्ञान' कभी इंसान का साथ नहीं छोड़ता, यहाँ तक कि मौत के समय भी नहीं!
            इसलिए उपनिषद इसे 'परमं यत्परायणम्' (The Ultimate Refuge) कहता है।
            जो योगी इस ज्ञान में स्थापित हो चुका है, वह अब कोई आम इंसान नहीं रहा; वह साक्षात् चलता-फिरता मंदिर बन गया है।
            और दुनिया के जितने भी विद्वान या पंडित हैं, उन सबमें वह सबसे ऊँचा (वरः) है क्योंकि उसने शब्दों को नहीं, बल्कि 'सत्य' को जी लिया है।
        """.trimIndent(),
        english = """
            "This sacred thread of absolute wisdom alone is the absolute supreme, ultimate, and final refuge (Parayanam).
            That wise sage who flawlessly wears this supreme thread of knowledge is the true wearer, and he is undeniably the absolute highest (Varah) among the knowers of truth."
            When a human wears a cheap physical thread, he is constantly burdened with the heavy Tension of keeping it clean, replacing it, and fiercely performing blind rituals.
            But when a human completely wraps himself entirely in pure 'Wisdom' (Self-realization), he absolutely needs zero external support; that exact wisdom itself permanently becomes his absolute greatest 'Refuge'.
            Absolutely every physical thing in the world—heavy money, fake relationships, the fragile body—eventually betrays you one day, but this supreme 'Self-knowledge' absolutely never abandons a human, not even at the exact moment of physical death!
            Therefore, the Upanishad fiercely declares it as 'Paramam Yatparayanam' (The Ultimate Refuge).
            The master Yogi perfectly established in this supreme wisdom is absolutely no longer a common human; he has flawlessly transformed into a living, walking, breathing temple.
            And among absolutely all the intellectual scholars and priests in the entire world, he is undeniably the absolute highest (Varah) strictly because he has not merely memorized dead words, but has actively Lived the absolute 'Truth'.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 18,
        sanskrit = "एको देवः सर्वभूतेषु गूढः सर्वव्यापी सर्वभूतान्तरात्मा ।",
        hindi = """
            (परब्रह्म का असली स्वरूप): "वह एक, अद्वितीय परमात्मा ही इस संसार के सभी प्राणियों में अत्यंत गहराई से छिपा हुआ (गूढ) है।
            वह सर्वव्यापी (हर जगह मौजूद) है और सभी छोटे-बड़े जीवों की साक्षात् 'अंतरात्मा' (Inner Soul) है।"
            भगवान आसमान में बादलों के ऊपर नहीं रहता; वह आपके दिल की धड़कन के बिल्कुल पीछे छिपा हुआ (गूढ) वह गवाह (Witness) है जो सब देख रहा है।
            वह केवल इंसानों में नहीं, बल्कि चींटी, पेड़, जानवर और पत्थरों (सर्वभूतेषु) में भी उतनी ही पूर्णता से मौजूद है।
            हम अज्ञान के कारण सोचते हैं कि "मेरी आत्मा अलग है और तुम्हारी आत्मा अलग है"; पर उपनिषद कहता है कि चेतना केवल 'एक' (एको देवः) ही है!
            जैसे अलग-अलग 100 बल्ब (Bulbs) में बिजली केवल एक ही दौड़ रही होती है, वैसे ही दुनिया के 800 करोड़ इंसानों में 'जान' (आत्मा) केवल एक ही धड़क रही है।
            जब इंसान को यह 100% पक्का हो जाता है कि सामने वाले दुश्मन में भी वही 'एक भगवान' धड़क रहा है जो मेरे अंदर है, तो उसकी सारी नफरत और ईर्ष्या (Jealousy) हमेशा के लिए खत्म हो जाती है।
            यही अद्वैत की सबसे बड़ी शक्ति है जो इंसान को ब्रह्मांड के हर एक कण से जोड़कर उसे असीम (Limitless) बना देती है।
        """.trimIndent(),
        english = """
            (The absolute true nature of Parabrahma): "That one single, non-dual Supreme Lord is exceptionally deeply hidden (Gudha) strictly within all living beings in this world.
            He is entirely all-pervading (omnipresent) and is the direct, living 'Inner Soul' (Antaratma) of absolutely all minor and major creatures."
            God absolutely does not live floating above cheap physical clouds in the sky; He is the flawless Witness hiding perfectly (Gudha) right behind your exact heartbeat actively watching absolutely everything.
            He flawlessly exists not exclusively in humans, but equally and fully in a tiny ant, a silent tree, a wild animal, and dense stones (Sarvabhuteshu).
            Due to thick, blinding ignorance, we falsely assume that "My soul is separate and your soul is separate"; but the Upanishad fiercely declares that pure Consciousness is strictly 'One' (Eko devah)!
            Exactly as exactly one single electricity continuously flows through 100 completely different light Bulbs, identically exactly one single 'Life' (Soul) is fiercely pulsating within all 8 billion humans globally.
            When a human becomes 100% absolutely certain that the exact same 'One God' is pulsating right inside his deadly enemy as within himself, all his toxic hatred and violent Jealousy violently die forever.
            This is undeniably the absolute greatest power of Advaita, seamlessly connecting a human to every single microscopic atom of the cosmos and making him infinitely Limitless.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 19,
        sanskrit = "कर्माध्यक्षः सर्वभूताधिवासः साक्षी चेता केवलो निर्गुणश्च ॥",
        hindi = """
            "वह परमेश्वर सभी कर्मों का अध्यक्ष (Supervisor) है, सभी प्राणियों का एकमात्र निवास स्थान है, और सबका सच्चा साक्षी (Witness) है।
            वह शुद्ध चेतना (चेता), पूर्ण रूप से अकेला (केवल/अद्वितीय) और माया के तीनों गुणों (सत्व, रज, तम) से पूरी तरह परे (निर्गुण) है।"
            आप जो भी छुपकर करते हैं, वह भगवान की आँखों से नहीं छुप सकता, क्योंकि वह 'कर्माध्यक्ष' है। पर वह किसी को सजा देने वाला कोई क्रूर जज (Judge) नहीं है; वह केवल एक 'साक्षी' (CCTV कैमरे की तरह) है।
            हम जो कर्म करते हैं, उसका फल प्रकृति (प्रारब्ध) अपने-आप हमें दे देती है, भगवान उसमें कोई दखल (Interfere) नहीं देता।
            वह भगवान 'निर्गुण' है; यानी दुनिया की कोई भी अच्छाई या बुराई, कोई भी बीमारी या बुढ़ापा उसे नहीं छू सकता।
            और सबसे बड़ी बात, वह 'केवल' (Kevala) है; यानी दुनिया में उसके अलावा 'दूसरा' कुछ है ही नहीं! यह दुनिया भी उसी का रूप है।
            जब हम ध्यान में गहराई में जाते हैं, तो हमें भी उसी 'निर्गुण साक्षी' भाव में आना होता है; जहाँ हम दुनिया को देखते तो हैं, पर उसमें फँसते नहीं (Zero reaction)।
            यही साक्षात् ईश्वर बनने की प्रक्रिया है।
        """.trimIndent(),
        english = """
            "That Supreme Lord is the absolute ultimate supervisor of all actions, the grand dwelling place of absolutely all beings, and the flawless, true silent witness (Sakshi).
            He is pure consciousness (Cheta), completely absolute and non-dual (Kevala), and entirely beyond all three physical attributes of Maya (Nirguna)."
            Absolutely whatever horrific sin you commit in extreme secrecy can never possibly be hidden from God's eyes, because He is the supreme 'Karmadhyaksha'. But He is absolutely no cruel Judge dispensing brutal punishments; He strictly remains a flawless 'Witness' (exactly like a CCTV camera).
            Physical nature (Prarabdha) automatically dispenses the exact fruits of our actions; God absolutely never Interferes in that mechanical process.
            That Supreme Lord is 'Nirguna'; meaning absolutely no worldly goodness or evil, no severe disease or decaying old age can ever possibly touch Him.
            And most profoundly, He is 'Kevala'; meaning there is absolutely nothing 'Second' existing in the entire universe besides Him! This entire world is also strictly His very own manifestation.
            When we descend exceptionally deeply into meditation, we absolutely must adopt that exact same 'Nirguna Sakshi' (attributeless witness) state; where we vividly see the chaotic world but absolutely do not get trapped in it (Zero reaction).
            This is exactly the flawless, direct process of literally becoming God Himself.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 20,
        sanskrit = "ब्रह्मैवेदममृतं पुरस्ताद् ब्रह्म पश्चाद् ब्रह्म दक्षिणतश्चोत्तरेण । अधश्चोर्ध्वं च प्रसृतं ब्रह्मैवेदं विश्वमिदं वरिष्ठम् ॥",
        hindi = """
            (मुण्डक उपनिषद की गूंज): "यह जो कुछ भी हमें दिखाई दे रहा है, वह सब सामने, पीछे, दाईं और बाईं ओर केवल 'अमृत ब्रह्म' (अमर भगवान) ही है।
            नीचे और ऊपर भी केवल वही ब्रह्म फैला हुआ है। वास्तव में, यह संपूर्ण महान विश्व (ब्रह्मांड) साक्षात् वह परब्रह्म ही है!"
            जब ज्ञान की तीसरी आँख (Third Eye) पूरी तरह खुलती है, तो इंसान को दुनिया में इंसान, जानवर, पैसे या चीज़ें नहीं दिखतीं।
            उसे हर दिशा में, हर कण (Atom) में केवल साक्षात् भगवान ही भगवान मुस्कुराता हुआ दिखाई देता है।
            यही वेदान्त का सबसे बड़ा 'क्लाइमेक्स' (Climax) है: दुनिया झूठ नहीं है, बल्कि 'दुनिया ही ब्रह्म है'!
            हम अज्ञान के कारण सोने (Gold) से बने गहनों को 'कंगन' या 'हार' मानकर खुश होते हैं, पर ज्ञानी जानता है कि सब कुछ केवल 100% 'सोना' ही है।
            जब सब कुछ (विशुद्ध परब्रह्म) ही है, तो डरने के लिए कोई दूसरी चीज़ बची ही नहीं!
            जो योगी इस श्लोक को अपनी साँसों में उतार लेता है, वह मृत्यु के डर को हमेशा के लिए कुचलकर साक्षात् ब्रह्मांड का राजा बन जाता है।
        """.trimIndent(),
        english = """
            (The profound echo of Mundaka Upanishad): "Absolutely everything that vividly appears before us is strictly the 'Immortal Brahman' in the front, behind, to the right, and to the left.
            Directly below and high above, that exact same Brahman alone is boundlessly expanded. In absolute reality, this entire magnificent universe is strictly the Supreme Parabrahma Himself!"
            When the blazing Third Eye of absolute wisdom fully opens, a human absolutely stops seeing physical humans, animals, cheap money, or material objects in the world.
            He flawlessly and clearly sees exclusively God and God alone smiling brilliantly in absolutely every single direction and microscopic Atom.
            This is undeniably the absolute greatest 'Climax' of Vedanta: The world is not fake, rather 'The world itself is Brahman'!
            Out of thick ignorance, we falsely rejoice viewing gold ornaments as a 'bracelet' or 'necklace', but the wise sage knows flawlessly that absolutely everything is 100% 'Gold' alone.
            When absolutely everything is exactly that pure Supreme Brahman alone, zero 'second thing' remains left to ever possibly fear!
            The master Yogi who successfully downloads this phenomenal verse directly into his vital breaths ruthlessly crushes the terrifying fear of death forever and effortlessly transforms into the undisputed King of the cosmos.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 21,
        sanskrit = "चतुष्पाद् ब्रह्म तदेतद्धृदयपुण्डरीके प्रतिष्ठितम् । जाग्रत्स्वप्नसुषुप्तितुरीयावस्थासु विचरति ॥",
        hindi = """
            "वह परब्रह्म चार चरणों (अवस्थाओं) वाला है, और वह इसी शरीर के हृदय रूपी कमल (हृदयपुण्डरीके) में पूरी तरह से प्रतिष्ठित है।
            वही आत्मा जाग्रत (जागना), स्वप्न (सपने देखना), सुषुप्ति (गहरी नींद) और तुरीय (परम समाधि) इन चारों अवस्थाओं में विचरता (खेलता) है।"
            यहाँ उपनिषद स्पष्ट कर रहा है कि भगवान कहीं दूर नहीं, बल्कि हमारी अपनी ही 'चेतना' (Consciousness) के चार रूप हैं।
            जब हम जाग रहे होते हैं (जाग्रत), तो वही भगवान हमारी आँखों से दुनिया को देख रहा होता है।
            जब हम सो जाते हैं और सपने देखते हैं (स्वप्न), तो वही भगवान हमारे दिमाग के अंदर एक पूरी नई दुनिया (सपना) बना कर उसका अनुभव करता है।
            जब सपने भी बंद हो जाते हैं और हम गहरी नींद (सुषुप्ति) में होते हैं, तब भी वह भगवान एक 'शून्य' और शांति का अनुभव करता है।
            पर इन तीनों अवस्थाओं से ऊपर जो चौथी (तुरीय) अवस्था है, वही हमारा असली 'स्वभाव' है, जहाँ न दुनिया है, न सपने हैं, केवल शुद्ध प्रकाश है।
            जो योगी ध्यान के द्वारा उस 'तुरीय' अवस्था में पहुँच जाता है, वह जीते-जी साक्षात् परब्रह्म बन जाता है।
        """.trimIndent(),
        english = """
            "That Supreme Brahman profoundly possesses four quarters (states), and He is flawlessly and firmly established right inside the lotus of the heart (Hridayapundarike) of this very body.
            That exact same Soul actively traverses and plays flawlessly through all four states: Jagrat (waking), Svapna (dreaming), Sushupti (deep dreamless sleep), and Turiya (supreme Samadhi)."
            Here, the Upanishad fiercely clarifies that God is absolutely not far away, but is explicitly the four magnificent forms of our very own 'Consciousness'.
            When we are actively awake (Jagrat), that exact same God is flawlessly looking at the external world strictly through our physical eyes.
            When we fall asleep and vividly dream (Svapna), that exact same God miraculously creates an entire new world inside our brain and profoundly experiences it.
            When even dreams permanently cease and we plunge into deep sleep (Sushupti), even then that God actively experiences that profound 'Void' and heavy peace.
            But infinitely above all these three states is the fourth (Turiya) state, which is exactly our actual, real 'Original Nature', where neither the world nor dreams exist, exclusively pure Light remains.
            The master Yogi who successfully reaches that 'Turiya' state strictly through intense meditation effortlessly becomes exactly the Supreme Brahman while fully alive.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 22,
        sanskrit = "जाग्रति ब्रह्मा स्वप्ने विष्णुः सुषुप्तौ रुद्रस्तुरीयमक्षरं परं ब्रह्म ॥",
        hindi = """
            "जाग्रत अवस्था (जागते हुए) में वह चेतना साक्षात् 'ब्रह्मा' (सृष्टि कर्ता) का रूप है; स्वप्न अवस्था में वह 'विष्णु' (पालनकर्ता) है;
            सुषुप्ति (गहरी नींद) में वह 'रुद्र' (विनाशक) है; परंतु जो इन तीनों के पार 'तुरीय' (चौथी) अवस्था है, वही अविनाशी परम ब्रह्म है।"
            यह श्लोक सनातन धर्म के त्रिदेवों (ब्रह्मा, विष्णु, महेश) का सबसे बड़ा मनोवैज्ञानिक (Psychological) रहस्य खोलता है।
            ब्रह्मा कोई आसमान में बैठे देवता नहीं हैं; जब आप सुबह उठकर अपने दिन (विचारों) का निर्माण करते हैं, तो आपकी चेतना ही 'ब्रह्मा' है।
            जब आप उन विचारों को सपने (स्वप्न) या दिन भर में जीते हैं, तो आपकी चेतना ही 'विष्णु' (रखवाला) है।
            और जब रात को आप गहरी नींद में अपनी सारी दुनिया और विचारों को मिटा देते हैं (शून्य हो जाते हैं), तो आपकी वह चेतना ही 'रुद्र' (शिव) है।
            पर इन तीनों के पार, जो इन तीनों अवस्थाओं को 'देख' रहा है (गवाह), वही 'तुरीय' (अविनाशी परब्रह्म) है।
            जब साधक इन तीनों रूपों से उठकर उस 'तुरीय' (गवाह) में टिक जाता है, तो वह काल (समय) और मौत से हमेशा के लिए पार हो जाता है।
        """.trimIndent(),
        english = """
            "In the Jagrat (waking) state, that consciousness is directly 'Brahma' (the Creator); in the Svapna (dreaming) state, it is explicitly 'Vishnu' (the Preserver);
            In Sushupti (deep sleep), it is fiercely 'Rudra' (the Destroyer); however, that 'Turiya' (fourth) state existing infinitely beyond these three is exactly the indestructible Supreme Brahman."
            This spectacular verse brilliantly unlocks the absolute greatest Psychological secret of Sanatana Dharma's Holy Trinity (Brahma, Vishnu, Mahesh).
            Brahma is absolutely no physical deity sitting in the sky; exactly when you violently wake up and construct your entire day (thoughts), your consciousness itself is exactly 'Brahma'.
            When you actively live out those thoughts in dreams (Svapna) or throughout the physical day, your exact consciousness is 'Vishnu' (the preserver).
            And exactly when you completely annihilate your entire world and all thoughts in deep dreamless sleep at night (becoming void), that exact consciousness of yours is fiercely 'Rudra' (Shiva).
            But infinitely beyond these three, that which is flawlessly 'Watching' (Witnessing) all three states, that alone is 'Turiya' (the indestructible Supreme Brahman).
            When the seeker successfully rises above these three forms and firmly anchors in that 'Turiya' (Witness), he permanently crosses entirely beyond Time and terrifying Death forever.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 23,
        sanskrit = "तस्मादक्षरं परं ब्रह्म तदेव सूत्रमिति धारयेत् । यस्यैतत्सूत्रं विदितं स विप्रो वेदपारगः ॥",
        hindi = """
            "इसलिए (तस्मात्), उस कभी न मिटने वाले (अक्षरं) परम ब्रह्म को ही अपना सच्चा 'सूत्र' (जनेऊ/धागा) मानकर धारण करना चाहिए।
            जिस इंसान ने इस (ब्रह्म रूपी) सूत्र को अच्छी तरह से जान लिया है, वास्तव में वही सच्चा 'विप्र' (ब्राह्मण) है और वही सारे वेदों के पार जाने वाला (वेदपारगः) है।"
            यहाँ उपनिषद स्पष्ट रूप से बाहरी कर्मकांडों को खारिज करके केवल 'ज्ञान' को ही सर्वोपरि मान रहा है।
            सूती धागा (जनेऊ) टूटने पर इंसान उसे बदल देता है, पर जिसने "मैं ब्रह्म हूँ" का धागा अपने मन में पहन लिया है, उसे दुनिया की कोई कैंची काट नहीं सकती।
            'वेदपारगः' का मतलब है कि अब उसे कोई भी वेद, उपनिषद या किताब पढ़ने की कोई जरूरत नहीं है!
            क्योंकि सारे वेद जिस 'भगवान' की ओर इशारा कर रहे थे, उस भगवान को उसने खुद के अंदर 'जी' लिया है।
            जब आप मंजिल (Destination) पर पहुँच जाते हैं, तो आपको नक्शे (Map/वेदों) की जरूरत नहीं रहती।
            यही आत्मज्ञान की परम स्वतंत्रता है, जहाँ इंसान हर किताब और हर नियम से पूरी तरह आज़ाद हो जाता है।
        """.trimIndent(),
        english = """
            "Therefore (Tasmat), one must flawlessly wear exclusively that indestructible (Aksharam) Supreme Brahman alone as his actual, true 'Sutra' (sacred thread).
            That specific human who has profoundly and perfectly known this (Brahman-form) thread, he alone is in absolute reality a true 'Vipra' (Brahmana), and he alone has flawlessly crossed entirely beyond all the Vedas (Vedaparagah)."
            Here the Upanishad fiercely and explicitly rejects absolutely all external cheap rituals, declaring exclusively pure 'Wisdom' as the absolute highest.
            When a cotton thread breaks, a human frantically replaces it, but he who has flawlessly worn the thread of "I am Brahman" deeply in his mind, absolutely no scissors in the world can ever cut it.
            'Vedaparagah' profoundly means he absolutely no longer requires reading any Veda, Upanishad, or physical book whatsoever!
            Strictly because that exact 'God' towards whom all the Vedas were desperately pointing, he has directly 'Lived' Him completely within himself.
            Exactly when you successfully reach your final Destination, you absolutely no longer desperately need the physical Map (Vedas).
            This is the ultimate, absolute freedom of Self-knowledge, where a human becomes 100% flawlessly free from absolutely every book and rigid rule forever.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 24,
        sanskrit = "सर्वान्कामान्परित्यज्य अद्वैते तिष्ठति । तस्य ज्ञानमयी शिखा तस्य ज्ञानमयं सूत्रम् ॥",
        hindi = """
            "जो साधक अपने मन की सभी प्रकार की सांसारिक इच्छाओं और वासनाओं (सर्वान् कामान्) को पूरी तरह से त्याग कर (परित्यज्य) केवल 'अद्वैत' (ब्रह्म) में ही स्थित रहता है।
            उसी योगी की शिखा (चोटी) वास्तव में 'ज्ञानमयी' है, और उसी का जनेऊ (सूत्र) साक्षात् 'ज्ञानमय' है।"
            इच्छाएं (Desires) ही वह गोंद (Glue) है जो हमारी आत्मा को इस शरीर और दुनिया की जेल में चिपका कर रखती है।
            "मुझे पैसा चाहिए, मुझे इज्जत चाहिए, मुझे स्वर्ग चाहिए"—ये सारी इच्छाएं इंसान को भिखारी बना देती हैं।
            पर जब इंसान इन सारी वासनाओं को लात मार देता है (परित्यज्य) और यह जान लेता है कि "जब पूरी दुनिया मैं ही हूँ, तो मैं किस चीज़ की इच्छा करूँ?"
            तो वह इंसान तुरंत उस 'अद्वैत' (जहाँ कोई दूसरा है ही नहीं) अवस्था में हमेशा के लिए बैठ (तिष्ठति) जाता है।
            और ऐसे इंसान को दुनिया को दिखाने के लिए कोई बाहरी धागा या चोटी रखने की जरूरत नहीं है; उसका शुद्ध चरित्र और ज्ञान ही उसका सबसे बड़ा श्रृंगार है।
            यह श्लोक 'त्याग' (Renunciation) की सबसे ऊँची परिभाषा है—जहाँ चीजों को नहीं, बल्कि चीजों को 'चाहने' की इच्छा को ही मार दिया जाता है।
        """.trimIndent(),
        english = """
            "That magnificent seeker who violently and completely abandons (Parityajya) absolutely all types of worldly desires and deep lusts (Sarvan kaman) of his mind and remains perfectly established exclusively in 'Advaita' (Non-duality).
            The tuft (Shikha) of that exact Yogi alone is in absolute reality 'made of pure wisdom', and his sacred thread (Sutra) is exactly 'wisdom incarnate'."
            Desires are explicitly the toxic Glue that violently sticks our pure Soul strictly within the terrifying prison of this body and world.
            "I desperately need money, I need cheap respect, I strictly want heaven"—absolutely all these endless desires flawlessly reduce a human to a pathetic beggar.
            But the exact second a human ruthlessly kicks away (Parityajya) absolutely all these lusts and profoundly realizes, "When I myself am the entire world, exactly what on earth should I desire?"
            That human instantly and flawlessly sits (Tishthati) permanently in that 'Advaita' (where absolutely no second thing exists) state forever.
            And such a supreme master absolutely does not desperately need any external cotton thread or tuft of hair to show off to the world; his pure flawless character and supreme wisdom is his absolute greatest adornment.
            This phenomenal verse provides the absolute highest definition of true 'Renunciation'—where physical objects are not discarded, but the very toxic desire to 'want' them is brutally killed.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 25,
        sanskrit = "अशौचं च न तस्यास्ति न सूतकं कदाचन । यस्य ब्रह्ममयं सूत्रं यस्य ज्ञानमयी शिखा ॥",
        hindi = """
            "जिस योगी का जनेऊ (सूत्र) साक्षात् 'ब्रह्ममय' (ब्रह्म के ज्ञान से बना) है, और जिसकी चोटी (शिखा) ज्ञानमयी है।
            उस योगी के लिए इस दुनिया में कभी भी (कदाचन) कोई 'अशौच' (अपवित्रता) नहीं है, और न ही उसके लिए कोई 'सूतक' (जन्म-मरण का छुआछूत) होता है।"
            समाज में जब किसी के घर बच्चा पैदा होता है या कोई मर जाता है, तो उसे कुछ दिनों के लिए 'अपवित्र' (सूतक) मान लिया जाता है, वह पूजा नहीं कर सकता।
            पर वेदान्त कहता है कि यह सब केवल शरीर के स्तर का नाटक है! आत्मा न तो कभी पैदा होती है और न कभी मरती है।
            जिस योगी ने खुद को शरीर मानना ही छोड़ दिया है और जो साक्षात् 'आत्मा' बन चुका है, उस पर समाज का कोई भी सूतक या अपवित्रता का नियम लागू नहीं होता।
            वह योगी 24 घंटे, सातों दिन, सोते-जागते, खाते-पीते हर पल 100% परम पवित्र है।
            दुनिया की कोई भी गंदी से गंदी चीज़ उस योगी के ब्रह्मज्ञान को मैला नहीं कर सकती, ठीक वैसे ही जैसे सूरज की रोशनी गटर (Gutter) पर पड़ने से सूरज गंदा नहीं होता।
            यह श्लोक इंसान को समाज के बनाए गए झूठे डरों और छुआछूत के अंधविश्वासों से पूरी तरह आज़ाद कर देता है।
        """.trimIndent(),
        english = """
            "That supreme Yogi whose sacred thread (Sutra) is literally 'Brahmamayam' (entirely composed of the absolute wisdom of Brahman), and whose tuft is pure wisdom.
            For that specific Yogi, there is absolutely never, at any time whatsoever (Kadachana), any 'Ashaucha' (impurity), nor is there ever any 'Sutaka' (ritual defilement from birth or death) for him."
            In ignorant society, when a baby is born or someone dies, the family is falsely deemed 'impure' (Sutaka) for days and forbidden from strict worship.
            But Vedanta fiercely declares that all this is merely cheap drama strictly at the gross physical body level! The pure Soul is absolutely never born, nor does it ever die.
            The master Yogi who has permanently stopped falsely identifying with the perishable body and has seamlessly become the 'Soul', absolutely no cheap societal rule of Sutaka or impurity applies to him whatsoever.
            That magnificent Yogi is 100% supremely, flawlessly pure 24 hours a day, 7 days a week, sleeping or waking, eating or drinking.
            Absolutely no filthy object in the world can ever possibly soil that Yogi's blazing Brahma-Jnana, exactly just as blinding sunlight falling directly on a filthy Gutter absolutely never dirties the sun.
            This phenomenal verse violently and permanently frees a human being from all fake societal fears and blind superstitions of cheap untouchability forever.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 26,
        sanskrit = "संसारदुःखनाशार्थं ज्ञानसूत्रं धृतं मया । ब्रह्मैवाहमिति ज्ञात्वा स मुक्तो भवति ॥",
        hindi = """
            (ज्ञानी की उद्घोषणा): "इस भयंकर संसार के सभी प्रकार के दुखों (संसारदुःख) को हमेशा के लिए नाश करने के लिए (नाशार्थं) ही मैंने इस 'ज्ञान रूपी सूत्र' को धारण (धृतं मया) किया है।
            और यह सत्य यथार्थ रूप से जानकर (ज्ञात्वा) कि 'निश्चित रूप से मैं साक्षात् परब्रह्म ही हूँ' (ब्रह्मैवाहमिति), वह मनुष्य हमेशा के लिए पूरी तरह 'मुक्त' हो जाता है।"
            इंसान जनेऊ, ताबीज या धागे क्यों पहनता है? ताकि उसे दुखों, बीमारियों या दुश्मनों से बचाव मिल सके।
            पर उपनिषद कहता है कि दुनिया का कोई भी बाहरी धागा तुम्हें संसार के 'असली दुख' (जन्म, मरण और बुढ़ापे) से नहीं बचा सकता।
            संसार के दुखों को जड़ से काटने का केवल एक ही अजेय (Invincible) हथियार है, और वह है 'ज्ञान' का सूत्र।
            जिस इंसान ने अपने दिमाग में यह विचार (सॉफ्टवेयर) हमेशा के लिए फिट कर लिया है कि "मैं कोई कमजोर शरीर नहीं, मैं साक्षात् भगवान हूँ!"
            उस इंसान का सारा डर, डिप्रेशन और शोक उसी सेकंड राख बन जाता है; और वह तुरंत (जीते-जी ही) मोक्ष (Liberation) प्राप्त कर लेता है।
            मोक्ष मरने के बाद नहीं मिलता; मोक्ष तो "अहं ब्रह्मास्मि" के एक सेकंड के असली अहसास (ज्ञात्वा) का नाम है।
        """.trimIndent(),
        english = """
            (The profound declaration of the sage): "Strictly for the absolute permanent annihilation (Nashartham) of absolutely all the terrifying sorrows of this horrific world (Samsaraduhkha), I have deliberately worn (Dhritam maya) this supreme 'Thread of Wisdom'.
            And by flawlessly and profoundly realizing (Jnatva) the absolute truth that 'Undoubtedly I am exactly the Supreme Brahman Himself' (Brahmaivahamiti), that specific human instantly and permanently becomes completely 'Liberated'."
            Why exactly do ignorant humans desperately wear physical sacred threads or cheap amulets? Strictly to blindly protect themselves from petty sorrows, diseases, or deadly enemies.
            But the Upanishad fiercely declares that absolutely no external cotton thread in the world can ever possibly save you from the 'Real Sorrows' of the world (violent birth, decaying old age, and brutal death).
            There is strictly and exclusively only one Invincible weapon to violently sever the world's sorrows from their very root, and that is explicitly the supreme thread of 'Wisdom'.
            That exact human who has permanently and flawlessly locked this thought (software) directly into his brain that "I am absolutely not a weak, perishable body, I am exactly God Himself!"
            Absolutely all of that human's terrifying fear, severe depression, and agonizing sorrow turn to instant ashes in that very split-second; and he flawlessly attains immediate Moksha (Liberation) while fully alive.
            Moksha is absolutely not attained after physical death; Moksha is exactly the name of that one single split-second of genuine, flawless realization (Jnatva) of "Aham Brahmasmi."
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 27,
        sanskrit = "त्रिदण्डं कमण्डलुं सिकां त्यक्त्वा परमहंसो भवति । ज्ञानदण्डो धृतो येन स एकदण्डी मुनिः ॥",
        hindi = """
            "संन्यासी को अपने पास रखे बाहरी त्रिदण्ड (तीन लकड़ियों का डंडा), कमंडलु (पानी का बर्तन) और शिखा (सिकां/चोटी) को पूरी तरह से त्याग कर (त्यक्त्वा), सर्वोच्च 'परमहंस' अवस्था को प्राप्त करना चाहिए।
            जिस महान साधक ने केवल 'ज्ञान' रूपी दण्ड (डंडे) को ही अपने भीतर धारण किया हुआ है, वास्तव में वही सच्चा 'एकदण्डी मुनि' (परम संन्यासी) है।"
            यहाँ उपनिषद संन्यासियों (Monks) के दिखावे पर भी करारी चोट कर रहा है। कई साधु हाथ में डंडा और कमंडलु लेकर खुद को महान संन्यासी समझते हैं।
            पर वेदान्त कहता है कि अगर तुम्हारे हाथ में डंडा है, पर दिमाग में 'ज्ञान' नहीं है, तो तुम केवल एक पाखंडी (Hypocrite) हो!
            असली 'दण्ड' (लाठी) लकड़ी की नहीं होती; असली दण्ड 'ज्ञान' की वह लाठी है जिससे इंसान अपने अंदर के अहंकार (Ego) और वासनाओं को पीट-पीट कर मार डालता है।
            जिसने ज्ञान का वह दण्ड उठा लिया, उसे किसी बाहरी बर्तन या दिखावे की जरूरत नहीं; वह बिना कपड़ों के भी साक्षात् 'परमहंस' (Highest Swan) है।
            परमहंस वह महापुरुष है जो पानी और दूध को अलग कर सकता है, यानी जो इस झूठी दुनिया (पानी) को छोड़कर केवल असली ब्रह्म (दूध) को ही पीता (अनुभव करता) है।
            यह श्लोक सनातन धर्म को कर्मकांड से निकालकर शुद्ध अद्वैत (Pure Advaita) के शिखर पर ले जाकर खड़ा कर देता है।
        """.trimIndent(),
        english = """
            "The ascetic must completely and ruthlessly abandon (Tyaktva) the external Tridanda (staff of three wooden sticks), Kamandalu (water pot), and the physical tuft of hair (Sikam), and flawlessly attain the absolute supreme 'Paramahamsa' state.
            That magnificent seeker who has exclusively firmly held the supreme staff of pure 'Wisdom' right within himself, he alone is in absolute reality the true 'Ekadandi Muni' (Supreme Ascetic)."
            Here, the Upanishad fiercely strikes a brutal blow even against the cheap physical show-offs of traditional monks (Sannyasis). Many ignorant sadhus arrogantly consider themselves supreme monks simply by parading with a physical stick and water pot.
            But Vedanta ruthlessly declares that if you strictly hold a wooden stick in your physical hand but possess absolutely zero 'Wisdom' in your brain, you are merely a toxic Hypocrite!
            The actual, real 'Danda' (Staff) is absolutely not made of cheap wood; the real Danda is exactly that massive staff of pure 'Wisdom' strictly using which a human brutally beats his own toxic Ego and filthy lusts to absolute death.
            He who has successfully picked up that terrifying staff of wisdom absolutely needs zero external pots or cheap show-offs; even completely naked, he is exactly the direct 'Paramahamsa' (Highest Swan).
            A Paramahamsa is that magnificent sage who flawlessly separates water and milk, profoundly meaning he violently discards this fake world (water) and strictly drinks (experiences) exclusively the real Brahman (milk) alone.
            This phenomenal verse flawlessly pulls Sanatana Dharma entirely out of cheap rituals and firmly places it directly on the absolute highest peak of Pure Advaita.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 28,
        sanskrit = "न कर्मणा न प्रजया धनेन त्यागेनैके अमृतत्वमानशुः ।",
        hindi = """
            (कैवल्य/महानारायण उपनिषद की गूंज): "इस संसार में न तो बहुत सारे अच्छे कर्म (यज्ञ-दान) करने से (न कर्मणा), न ही बच्चों (संतान/प्रजा) को पैदा करने से (न प्रजया)।
            और न ही बहुत अधिक धन-दौलत (धनेन) इकट्ठी करने से कभी अमृतत्व (मोक्ष/अमरता) प्राप्त होता है।
            केवल और केवल 'त्याग' (त्यागेनैके) के द्वारा ही महान ज्ञानियों ने उस 'अमृतत्व' (मोक्ष) को प्राप्त किया है (आनशुः)।"
            यह श्लोक पूरी दुनिया के इंसानों की आँखें खोलने वाला सबसे बड़ा सच है! इंसान पूरी ज़िंदगी तीन ही चीज़ों के पीछे भागता है: कर्म (सफलता), परिवार (बच्चे), और पैसा (धन)।
            वह सोचता है कि इन तीनों से उसे शांति और अमरता मिलेगी। पर उपनिषद चीख-चीख कर कह रहा है कि इन तीनों से 'कभी नहीं' (न) मोक्ष मिलेगा!
            पैसा आपको हॉस्पिटल का बेड दे सकता है, पर मौत से नहीं बचा सकता; बच्चे आपकी चिता जला सकते हैं, पर आपको मोक्ष नहीं दे सकते।
            मोक्ष केवल 'त्याग' से मिलता है। और त्याग का मतलब जंगल भाग जाना नहीं है!
            त्याग का असली मतलब है अपने दिमाग से इस बात को हमेशा के लिए डिलीट (Delete) कर देना कि "यह पैसा, यह शरीर और यह परिवार 'मेरा' है।"
            जिस दिन इंसान के दिमाग से 'मेरा-पन' (Attachment) पूरी तरह निकल (त्याग) जाता है, उसी सेकंड वह मौत को हराकर साक्षात् 'अमर' (अमृतत्व) हो जाता है।
        """.trimIndent(),
        english = """
            (The profound echo of Kaivalya/Mahanarayana Upanishads): "In this entire world, absolutely neither by performing countless massive actions and grand rituals (Na karmana), nor by aggressively producing abundant progeny and children (Na prajaya).
            And absolutely never by aggressively hoarding massive mountains of vast wealth (Dhanena) is Amritatvam (Moksha/absolute Immortality) ever attained.
            Strictly, solely, and exclusively through absolute 'Tyaga' (Renunciation / Tyagenaike) alone have the magnificent wise sages flawlessly attained that 'Amritatvam' (Immortality) (Anashuh)."
            This spectacular verse is undeniably the absolute greatest eye-opening harsh truth for all humanity! A human being violently runs his entire pathetic life desperately chasing only exactly three things: Actions (Success), Family (Children), and Money (Wealth).
            He foolishly hallucinates that these three will effortlessly grant him supreme peace and immortality. But the Upanishad fiercely screams that Moksha is 'Absolutely Never' (Na) attained through these three!
            Money can successfully buy you a highly expensive Hospital bed, but can absolutely never save you from terrifying death; children can light your funeral pyre, but can absolutely never grant you Moksha.
            Moksha is attained exclusively through pure 'Tyaga' (Renunciation). And renunciation absolutely does not mean violently running away to a physical forest!
            True renunciation strictly means permanently Deleting the toxic illusion directly from your brain that "This money, this physical body, and this family are 'Mine'."
            The exact split-second all toxic 'Attachment' completely exits (Renunciation) a human's brain, he instantly defeats terrifying death and flawlessly becomes exactly 'Immortal' (Amritatvam).
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 29,
        sanskrit = "वेदान्तविज्ञानसुनिश्चितार्थाः संन्यासयोगाद्यतयः शुद्धसत्त्वाः । ते ब्रह्मलोकेषु परान्तकाले परामृतात्परिमुच्यन्ति सर्वे ॥",
        hindi = """
            "वे महान संन्यासी जिन्होंने वेदान्त के परम विज्ञान को गहराई से पढ़कर उसके असली 'अर्थ' (सत्य) को पूरी तरह से निश्चित (100% पक्का) कर लिया है (वेदान्तविज्ञानसुनिश्चितार्थाः)।
            और जिन्होंने संन्यास योग (त्याग और ध्यान) के द्वारा अपने मन (अंतःकरण) को पूरी तरह से शुद्ध (शुद्धसत्त्वाः) कर लिया है।
            वे सभी (सर्वे) महान साधक, इस शरीर के अंतिम समय (परान्तकाले / मृत्यु के बाद) में, सर्वोच्च 'ब्रह्मलोक' में स्थित होकर साक्षात् 'परम-अमृत' (परब्रह्म) में मिलकर हमेशा-हमेशा के लिए पूरी तरह 'मुक्त' (परिमुच्यन्ति) हो जाते हैं।"
            यह श्लोक अद्वैत वेदान्त का फाइनल सर्टिफिकेट (Final Certificate) है।
            मोक्ष पाने की केवल दो शर्तें (Conditions) हैं: 1. वेदान्त का विज्ञान (Clear understanding), और 2. शुद्ध मन (Pure mind)।
            अगर आपका दिमाग वेदान्त पढ़कर यह डाउट (Doubt) कर रहा है कि "क्या सच में मैं भगवान हूँ?", तो आपको मोक्ष नहीं मिलेगा। ज्ञान 100% 'सुनिश्चित' (Rock-solid) होना चाहिए!
            और वह ज्ञान केवल उसी दिमाग में टिकता है जो 'शुद्ध' है, जिसमें किसी के लिए कोई नफरत या वासना नहीं बची है।
            जब ऐसा शुद्ध ज्ञानी शरीर छोड़ता है (परान्तकाले), तो उसकी आत्मा कहीं भटकती नहीं है।
            वह सीधे उस परम ब्रह्म (ब्रह्मलोक) में इस तरह घुल जाती है जैसे पानी में पानी; और वह हमेशा के लिए जन्म-मरण की जेल से आज़ाद (परिमुच्यन्ति) हो जाता है।
        """.trimIndent(),
        english = """
            "Those magnificent ascetics who, having profoundly mastered the supreme science of Vedanta, have absolutely and 100% firmly ascertained its ultimate, actual 'Meaning' and truth (Vedantavijnanasunishchitarthah).
            And who, strictly through the Yoga of true Sannyasa (Renunciation and deep meditation), have flawlessly and completely purified their entire inner being (Shuddhasattvah).
            Absolutely all (Sarve) of those supreme seekers, exactly at the time of final departure (Parantakale / physical death), having flawlessly attained the supreme 'Brahmaloka', merge perfectly into the 'Supreme Immortal' (Parabrahman) and become permanently and completely 'Liberated' (Parimuchyanti) forever."
            This phenomenal verse is undeniably the absolute Final Certificate of Advaita Vedanta.
            There are strictly and exclusively only two mandatory Conditions to successfully attain Moksha: 1. The supreme Science of Vedanta (Crystal Clear Understanding), and 2. A flawlessly Pure Mind (Shuddha-sattva).
            If your highly restless brain reads Vedanta and still foolishly Doubts, "Am I actually genuinely God?", you will absolutely never attain Moksha. The wisdom must be 100% 'Sunishchita' (Rock-solid)!
            And that explosive wisdom securely stays strictly only in that physical brain which is completely 'Pure', harboring absolutely zero toxic hatred or filthy lusts.
            Exactly when such a supremely pure, enlightened sage sheds his physical body (Parantakale), his Soul absolutely never wanders helplessly.
            It seamlessly dissolves directly into that Supreme Brahman (Brahmaloka) exactly like pure water perfectly merging into water; and he becomes permanently liberated (Parimuchyanti) from the horrific prison of birth and death forever.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 30,
        sanskrit = "दह्रं विपाप्मं परमेश्मभूतं यत्पुण्डरीकं पुरमध्यसँस्थम् । तत्रापि दह्रं गगनं विशोकं तस्मिन्यदन्तस्तदुपासितव्यम् ॥",
        hindi = """
            (नारायण सूक्त / कैवल्य की गूंज): "इस शरीर रूपी नगर (पुर) के बिल्कुल बीच में जो अत्यंत सूक्ष्म (दह्रं), पापों से पूरी तरह रहित (विपाप्मं), और परमेश्वर का निवास स्थान रूपी हृदय-कमल (पुण्डरीकं) स्थित है।
            उस हृदय-कमल के भीतर भी जो अत्यंत सूक्ष्म और शोकरहित (विशोकं) 'आकाश' (गगनं) है; साधक को केवल और केवल उसी आकाश के बिल्कुल 'भीतर' (अन्तस्) स्थित उस परम तत्त्व की ही उपासना (उपासितव्यम् / ध्यान) करनी चाहिए।"
            यह श्लोक ध्यान (Meditation) का सबसे सटीक और एग्जैक्ट लोकेशन (Exact Location / GPS) दे रहा है कि भगवान को कहाँ खोजना है!
            हमें आँखें बंद करके पूरे ब्रह्मांड में नहीं घूमना है; हमें अपना सारा फोकस (Focus) केवल अपने सीने के बीच (हृदय) पर लाना है।
            उस हृदय को एक 'कमल' (पुण्डरीक) माना गया है, जो दुनिया के सारे कीचड़ (पापों) से अछूता (विपाप्मं) है।
            पर उस मांस के दिल (Heart) की पूजा नहीं करनी है! उस दिल के अंदर जो एक खाली 'स्पेस' (दह्रं गगनं / सूक्ष्म आकाश) है, जहाँ कोई टेंशन या दुख (विशोकं) नहीं है।
            उसी सन्नाटे (आकाश) के भी बिल्कुल 'भीतर' (अन्तस्) जो चेतना धड़क रही है, वही साक्षात् भगवान है; और उसी का हमें 24 घंटे ध्यान (उपासना) करना है।
            जो इंसान इस लोकेशन (भीतर के आकाश) को खोज लेता है, उसे बाहर के किसी भी तीर्थ (Temple) में जाने की जरूरत नहीं रहती; उसका अपना सीना ही दुनिया का सबसे बड़ा मंदिर बन जाता है।
        """.trimIndent(),
        english = """
            (The profound echo of Narayana Sukta / Kaivalya): "Strictly located exactly in the very center of this city of the body (Pura) is the exceptionally subtle (Dahram), completely sinless (Vipapmam) lotus of the heart (Pundarikam), the absolute supreme abode of the Lord.
            And directly strictly within that exact lotus of the heart is an exceptionally subtle, entirely sorrowless (Vishokam) 'Space' (Gaganam / Sky); the sincere seeker must relentlessly and exclusively meditate (Upasitavyam) strictly upon that Ultimate Principle existing precisely 'Inside' (Antas) that exact space alone."
            This spectacular verse provides the absolute most precise and Exact Location (GPS) specifically for deep Meditation detailing exactly where to aggressively search for God!
            We absolutely must not wildly wander the entire massive cosmos with closed eyes; we must fiercely bring our entire absolute Focus strictly to the exact center of our chest (Heart).
            That heart is profoundly considered a flawless 'Lotus' (Pundarika), which is 100% permanently untouched (Vipapmam) by all the filthy mud (sins) of the world.
            But we absolutely must not blindly worship that physical piece of meat (Heart)! Directly inside that physical heart is a profound empty 'Space' (Dahram gaganam), where absolutely zero tension or sorrow (Vishokam) can ever exist.
            And precisely exactly 'Inside' (Antas) that profound silence (Space), the pure consciousness that is fiercely pulsating is exactly God Himself; and we must rigorously meditate (Upasana) exclusively upon Him 24 hours a day.
            The specific human who successfully discovers this exact Location (the inner space) absolutely never needs to visit any external physical pilgrimage (Temple); his very own chest instantly transforms into the world's absolute greatest supreme temple.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 31,
        sanskrit = "सोऽहं हँसः परमहंसो भवति । तमेव विदित्वातिमृत्युमेति नान्यः पन्था विद्यतेऽयनाय ॥",
        hindi = """
            "जब साधक की हर सांस में 'सोऽहं' (वह ब्रह्म मैं ही हूँ) का अजपा जाप चलने लगता है, तो वह आत्मा रूपी हंस (हँसः) साक्षात् 'परमहंस' (सर्वोच्च अवस्था) बन जाता है।
            केवल और केवल उस एक परमात्मा को यथार्थ रूप में जानकर ही (तमेव विदित्वा) मनुष्य मृत्यु (जन्म-मरण) को पूरी तरह पार कर जाता है (अतिमृत्युमेति)।
            मोक्ष के परम लक्ष्य तक पहुँचने के लिए इस (आत्मज्ञान के) मार्ग के अलावा दुनिया में दूसरा कोई भी रास्ता (पन्था) बिल्कुल भी नहीं है (नान्यः पन्था विद्यते)।"
            यह श्लोक वेदान्त की सबसे बड़ी 'साधना' (प्रैक्टिस) और उसका 'रिजल्ट' दोनों एक साथ बता रहा है।
            'सोऽहं' का अर्थ है 'सः' (वह भगवान) और 'अहं' (मैं)। जब हम सांस अंदर लेते हैं तो 'सो' की आवाज़ आती है, और जब बाहर छोड़ते हैं तो 'हं' की।
            यानी हमारी सांसें खुद-ब-खुद 24 घंटे कह रही हैं: "मैं ही वह भगवान हूँ!" पर हम अज्ञान के कारण इसे सुन नहीं पाते।
            जब योगी ध्यान से इस 'सोऽहं' को सुन लेता है, तो वह एक साधारण इंसान से सीधा 'परमहंस' (भगवान का रूप) बन जाता है।
            और फिर श्वेताश्वतर उपनिषद की वह भयंकर गूंज दोहराई जाती है: मोक्ष पाने का कोई 'शॉर्टकट' (Shortcut) या दूसरा रास्ता (नान्यः पन्था) नहीं है!
            बिना इस 'ज्ञान' के तुम चाहे जितने जन्म पूजा कर लो, मौत तुम्हें मारती रहेगी। मौत को हराने की दुनिया में केवल एक ही दवा है: खुद को ब्रह्म जानना।
        """.trimIndent(),
        english = """
            "When the effortless, unchanted mantra of 'So'ham' (I am exactly that Brahman) continuously runs flawlessly in every single breath of the seeker, that swan of the soul (Hamsah) seamlessly transforms directly into the supreme 'Paramahamsa' (Absolute Highest State).
            Exclusively and strictly only by truly realizing and profoundly knowing Him alone (Tameva viditva), a human completely and flawlessly crosses entirely beyond terrifying Death (Atimrityumeti).
            To successfully reach the ultimate supreme goal of Moksha, there is absolutely zero 'Other Path' (Nanyah pantha) existing whatsoever anywhere in the world, besides this pure path of Self-knowledge (Nanyah pantha vidyate)."
            This phenomenal verse flawlessly reveals both Vedanta's absolute greatest 'Sadhana' (Practice) and its guaranteed 'Result' simultaneously.
            'So'ham' strictly translates to 'Sah' (That God) and 'Aham' (I). When we naturally inhale, the sound of 'So' is produced, and when we effortlessly exhale, 'Ham' is produced.
            Meaning, our physical breaths are automatically screaming 24 hours a day: "I myself am exactly that God!" but due to thick ignorance, we completely fail to hear it.
            When the master Yogi flawlessly hears this 'So'ham' strictly through deep meditation, he seamlessly transforms directly from an ordinary human into a supreme 'Paramahamsa' (God incarnate).
            And then the terrifying, roaring echo of the Shvetashvatara Upanishad is brutally repeated: There is absolutely no cheap 'Shortcut' or alternative path (Nanyah pantha) to Moksha!
            Completely without this absolute 'Wisdom', no matter how many countless lifetimes you blindly worship, terrifying Death will relentlessly slaughter you. There is strictly only one absolute medicine in the entire world to defeat death: Flawlessly knowing yourself as Brahman.
        """.trimIndent()
    ),
    ParabrahmaShloka(
        id = 32,
        sanskrit = "इत्युपनिषत् । ॐ शान्तिः शान्तिः शान्तिः ॥",
        hindi = """
            (परब्रह्म उपनिषद का परम समापन): "यहीं पर यह महान और अत्यंत पवित्र 'उपनिषद' (परम ज्ञान) पूर्ण रूप से संपन्न होता है (इत्युपनिषत्)।
            ॐ! शांतिः शांतिः शांतिः! (हमारे शरीर, मन और असीम आत्मा में उस परब्रह्म की परम और अखंड शांति हमेशा-हमेशा के लिए स्थापित हो)।"
            'उपनिषद' का असली अर्थ है गुरु के बिल्कुल पास (उप) और नीचे (नि) बैठकर उस असीम सत्य को अपने भीतर उतारना (षद्)।
            आज महर्षि पिप्पलाद ने शौनक को वह खजाना दे दिया है जिससे इंसान का सारा बाहरी भटकाव हमेशा के लिए खत्म हो जाता है।
            उन्होंने साबित कर दिया है कि असली जनेऊ सूत का नहीं, 'ज्ञान' का होता है; असली चोटी बालों की नहीं, 'चेतना' की होती है; और असली मंदिर कोई इमारत नहीं, इंसान का अपना 'हृदय' होता है।
            अंत में 'शांतिः' शब्द को 3 बार दोहराया जाता है। क्यों? ताकि हमारे तीन तरह के दुख—आधिभौतिक (दुनिया के दुख), आधिदैविक (प्रकृति/बीमारी के दुख), और आध्यात्मिक (मन के दुख)—हमेशा के लिए जड़ से मिट जाएँ।
            जब इंसान जान लेता है कि वह साक्षात् परम ब्रह्म है, तो उसके भीतर एक ऐसी भयंकर 'शांति' उतरती है, जिसे दुनिया का कोई भी तूफ़ान, कोई भी डिप्रेशन, यहाँ तक कि मौत भी हिला नहीं सकती।
            यही परब्रह्म उपनिषद का अल्टीमेट (Ultimate) वादा और वरदान है।
        """.trimIndent(),
        english = """
            (The Absolute Final Conclusion of Parabrahma Upanishad): "Right exactly here, this magnificent and exceptionally sacred 'Upanishad' (Supreme Wisdom) perfectly and auspiciously achieves absolute completion (Ityupanishat).
            OM! Peace, Peace, Peace! (May the supreme, infinite, and unbroken peace of that Supreme Brahman be permanently established within our physical body, restless mind, and immortal soul forever)."
            The absolute real meaning of 'Upanishad' is to sit exceptionally close (Upa) and humbly below (Ni) the true Guru, and flawlessly download that infinite Truth directly into oneself (Shad).
            Today, the great Sage Pippalada has profoundly handed Shaunaka that ultimate treasure exactly through which a human's blind, endless worldly wandering is permanently annihilated forever.
            He has flawlessly proven that the actual, true sacred thread is absolutely not made of cheap cotton, but of pure 'Wisdom'; the real tuft is not physical hair, but blazing 'Consciousness'; and the absolute real temple is not a physical building, but a human's very own 'Heart'.
            Ultimately, the sacred word 'Shantih' is violently and deliberately repeated exactly 3 times. Why exactly? Strictly to permanently and brutally uproot our three types of sorrows—Adhibhautika (worldly sorrows), Adhidaivika (natural/disease sorrows), and Adhyatmika (mental sorrows) forever.
            When a human profoundly realizes that he is exactly the Supreme Brahman Himself, an unimaginably terrifying 'Peace' relentlessly descends right into him, which absolutely no worldly storm, no severe depression, and not even Death itself can ever possibly shake.
            This is the ultimate, absolute, and flawless Promise and eternal Boon of the magnificent Parabrahma Upanishad.
        """.trimIndent()
    )
)