package com.sanatangyansagar.ui.screens.DurgaMaa

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

// 1. Data Model
data class KshamaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

// 2. Main Screen Composable
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchamaPrathnaScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFBF7))
    ) {
        // Search Bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                val shlokaNumber = query.toIntOrNull()
                // Validates if the number is between 1 and 10
                if (shlokaNumber != null && shlokaNumber in 1..10) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-10)") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            shape = RoundedCornerShape(12.dp),
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
            itemsIndexed(kshamaPrarthanaList) { _, shloka ->
                KshamaShlokaCard(shloka = shloka)
            }
        }
    }
}

// 3. Shloka Card Composable
@Composable
fun KshamaShlokaCard(shloka: KshamaShloka) {
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
            Text(text = shloka.hindi, fontSize = 14.sp, lineHeight = 22.sp)
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "English Meaning:",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = shloka.english, fontSize = 14.sp, lineHeight = 22.sp)
        }
    }
}

// 4. Data List (Exactly 10 Shlokas of Kshama Prarthana)
val kshamaPrarthanaList: List<KshamaShloka> = listOf(
    KshamaShloka(
        id = 1,
        sanskrit = "अपराधसहस्राणि क्रियन्तेऽहर्निशं मया । दासोऽयमिति मां मत्वा क्षमस्व परमेश्वरि ॥ १ ॥",
        hindi = """
            हे परमेश्वरी! मेरे द्वारा दिन-रात अनगिनत (हजारों) अपराध होते रहते हैं।
            मैं आपका ही सेवक हूँ, ऐसा मानकर मेरे उन अपराधों को कृपापूर्वक क्षमा करें।
            यह श्लोक भक्त की विनम्रता और अपनी सीमाओं को स्वीकार करने का प्रतीक है।
            माँ की ममता असीम है, वह अपने पुत्र के दोषों को भुलाकर उसे गले लगा लेती है।
            बिना अहंकार के अपनी गलतियों को मानना ही आध्यात्मिक उन्नति की पहली सीढ़ी है।
            यह प्रार्थना हमें सिखाती है कि ईश्वर के सामने सरल और सच्चा होना ही सबसे बड़ी पूजा है।
        """.trimIndent(),
        english = """
            O Supreme Goddess! Thousands of offenses are committed by me day and night.
            Knowing me to be Your humble servant, please forgive me for all my transgressions.
            This verse symbolizes the devotee's humility and the admission of human limitations.
            The Mother's compassion is boundless; She overlooks the faults of Her children.
            Admitting one's mistakes without ego is the primary step toward spiritual growth.
            This prayer teaches that being simple and honest before God is the highest form of worship.
        """.trimIndent()
    ),
    KshamaShloka(
        id = 2,
        sanskrit = "आवाहनं न जानामि न जानामि विसर्जनम् । पूजां चैव न जानामि क्षम्यतां परमेश्वरि ॥ २ ॥",
        hindi = """
            हे देवी! मैं न तो आपका आवाहन (बुलाना) जानता हूँ और न ही विसर्जन (विदा करना)।
            मैं आपकी पूजा करने की सही विधि और मन्त्रों के विज्ञान से भी पूरी तरह अनभिज्ञ हूँ।
            मुझसे जो भी त्रुटि हुई हो, हे परमेश्वरी! उसे अपनी करुणा से क्षमा कर दीजिए।
            यहाँ साधक यह स्वीकार करता है कि ईश्वर की महानता को सीमित विधियों में नहीं बाँधा जा सकता।
            सच्ची पूजा बाहरी क्रियाओं में नहीं, बल्कि हृदय के पवित्र भावों में छिपी होती है।
            यह श्लोक धार्मिक कट्टरता को छोड़कर केवल भक्ति और प्रेम पर जोर देने का संदेश देता है।
        """.trimIndent(),
        english = """
            O Goddess! I do not know how to invoke You, nor do I know the proper way to bid You farewell.
            I am entirely ignorant of the rituals and the science of mantras required to worship You.
            Please forgive any mistakes I have made, O Supreme Sovereign, with Your infinite mercy.
            Here, the seeker admits that the Divine's greatness cannot be bound by limited rituals.
            True worship lies not in external actions but in the pure feelings of the heart.
            This verse encourages letting go of rigid formalities in favor of pure devotion and love.
        """.trimIndent()
    ),
    KshamaShloka(
        id = 3,
        sanskrit = "मन्त्रहीनं क्रियाहीनं भक्तिहीनं सुरेश्वरि । यत्पूजितं मया देवि परिपूर्णं तदस्तु मे ॥ ३ ॥",
        hindi = """
            हे देवताओं की ईश्वरी! मेरी यह पूजा मन्त्रों, सही क्रियाओं और पर्याप्त भक्ति से रहित है।
            हे देवी! इन कमियों के बावजूद मैंने जो भी थोड़ा-बहुत किया है, उसे परिपूर्ण मानकर स्वीकार करें।
            साधक का विश्वास है कि माँ अपनी कृपा से उसकी अधूरी पूजा को भी पूर्णता प्रदान करती हैं।
            ईश्वर भाव के भूखे होते हैं, न कि मन्त्रों के सही उच्चारण या आडम्बरों के।
            यह श्लोक हमें आश्वस्त करता है कि निष्काम भाव से किया गया छोटा प्रयास भी व्यर्थ नहीं जाता।
            माँ का आशीर्वाद हमारी सभी कमियों और अयोग्यताओं को ढककर हमें पवित्र बना देता है।
        """.trimIndent(),
        english = """
            O Goddess of the Gods! My worship is devoid of mantras, proper rituals, and sufficient devotion.
            O Mother! Despite these shortcomings, please accept whatever I have done as complete and perfect.
            The seeker believes that the Mother’s grace grants perfection even to incomplete efforts.
            The Divine hungers for pure intent, not just perfect pronunciations or elaborate displays.
            This verse assures us that even a small, selfless effort toward God is never wasted.
            The Mother's blessing covers all our inadequacies and purifies our very existence.
        """.trimIndent()
    ),
    KshamaShloka(
        id = 4,
        sanskrit = "अपराधशतं कृत्वा जगदम्बेति चोच्चरेत् । यां गतिं समवाप्नोति न तां ब्रह्मादयः सुराः ॥ ४ ॥",
        hindi = """
            सैंकड़ों अपराध करने के बाद भी यदि कोई मनुष्य 'हे जगदम्बे' नाम का सच्चे हृदय से उच्चारण करता है,
            तो उसे वह परम गति प्राप्त होती है, जो ब्रह्मा आदि देवताओं के लिए भी अत्यंत दुर्लभ है।
            नाम की महिमा समस्त शास्त्रों और तपस्याओं के फल से कहीं अधिक बढ़कर मानी गई है।
            'जगदम्बा' शब्द में ब्रह्मांड की समस्त सुरक्षा और प्रेम समाया हुआ है।
            यह श्लोक ईश्वर के नाम की शक्ति और उनकी अहैतुकी कृपा (Unconditional grace) को दर्शाता है।
            भले ही हम कितने भी पापी हों, माँ की एक पुकार हमें सारे बंधनों से मुक्त करने के लिए पर्याप्त है।
        """.trimIndent(),
        english = """
            Even after committing hundreds of sins, if one utters the name 'Jagadamba' with a sincere heart,
            One attains a spiritual state that is rare even for great deities like Lord Brahma.
            The glory of the Divine Name is considered superior to the fruits of all scriptures and penance.
            The word 'Jagadamba' encapsulates all the protection and love of the entire universe.
            This verse highlights the power of God's name and Her unconditional, flowing grace.
            No matter our past, a single call to the Mother is enough to liberate us from all bondage.
        """.trimIndent()
    ),
    KshamaShloka(
        id = 5,
        sanskrit = "सापराघोऽस्मि शरणं प्राप्तस्त्वां जगदम्बिके । इदानीमनुकम्प्योऽहं यथेच्छसि तथा कुरु ॥ ५ ॥",
        hindi = """
            हे जगदम्बिके! मैं निश्चित रूप से अपराधी हूँ, परंतु अब मैं पूरी तरह आपकी शरण में आ गया हूँ।
            अब मैं आपकी दया का पात्र हूँ; आप मेरे साथ वैसा ही करें जैसा आपको उचित लगे।
            यह 'शरणागति' (Surrender) का उच्चतम शिखर है, जहाँ साधक अपना अहंकार त्याग देता है।
            जब हम अपनी मर्जी छोड़कर माँ की मर्जी पर चलते हैं, तब जीवन के सारे संघर्ष समाप्त हो जाते हैं।
            माँ को यह अधिकार देना कि 'जो चाहो वैसा करो', भक्त के परम विश्वास को प्रकट करता है।
            समर्पण ही वह जादुई कुंजी है जो ईश्वर के हृदय के द्वार को हमारे लिए तुरंत खोल देती है।
        """.trimIndent(),
        english = """
            O Jagadambika! I am certainly an offender, but now I have sought absolute refuge in You.
            I am now deserving of Your compassion; do with me whatever You deem right.
            This is the pinnacle of 'Sharanagati' (Surrender), where the seeker discards all ego.
            When we release our personal will and align with the Mother’s will, all life struggles end.
            Giving the Mother the authority to 'do as You wish' reveals the devotee's total trust.
            Surrender is the magical key that instantly flings open the doors to the Divine's heart.
        """.trimIndent()
    ),
    KshamaShloka(
        id = 6,
        sanskrit = "अज्ञानाद्विस्मृतेर्भ्रान्त्या यन्न्यूनमधिकं कृतम् । तत्सर्वं क्षम्यतां देवि प्रसीद परमेश्वरि ॥ ६ ॥",
        hindi = """
            अज्ञानवश, भूल से या किसी भ्रम के कारण पूजा में जो कुछ भी कम या अधिक (गलत) हो गया हो,
            हे देवी! उन सबको क्षमा कर दीजिए और हे परमेश्वरी! मुझ पर सदैव प्रसन्न रहिए।
            साधक स्वीकार करता है कि मानवीय बुद्धि सीमित है और उसमें गलती होने की संभावना सदैव रहती है।
            माँ हमारी गलतियों को नहीं, बल्कि हमारे हृदय की तड़प और सच्चाई को देखती हैं।
            'प्रसीद' का अर्थ है माँ की प्रसन्नता, जो जीवन के हर अंधेरे को मिटाकर प्रकाश भर देती है।
            यह प्रार्थना हमें चिंतामुक्त करती है कि हमारी छोटी गलतियां माँ के आशीर्वाद में बाधा नहीं बनेंगी।
        """.trimIndent(),
        english = """
            Whatever was done incorrectly—either too little or too much—due to ignorance, forgetfulness, or delusion,
            Please forgive it all, O Goddess, and O Parameshwari, be forever pleased with me.
            The seeker acknowledges that the human intellect is limited and prone to making mistakes.
            The Mother looks not at our technical errors but at the sincerity and longing of our heart.
            'Prasida' means Her divine pleasure, which eradicates all darkness and fills life with light.
            This prayer frees us from anxiety, ensuring that minor flaws won't block the Mother's blessings.
        """.trimIndent()
    ),
    KshamaShloka(
        id = 7,
        sanskrit = "कामेश्वरि जगन्मातः सच्चिदानन्दरूपिणि । गृहाणार्चामिमां प्रीत्या प्रसीद परमेश्वरि ॥ ७ ॥",
        hindi = """
            हे कामेश्वरी! हे जगत की माता! हे सत्य, चित्त और आनंद के स्वरूप वाली देवी!
            मेरी इस छोटी सी पूजा को प्रेमपूर्वक ग्रहण करें और हे परमेश्वरी! मुझ पर प्रसन्न हों।
            कामेश्वरी वह शक्ति है जो हमारी सात्विक इच्छाओं को पूर्ण कर हमें मोक्ष की ओर ले जाती है।
            माँ का स्वरूप केवल करुणा नहीं, बल्कि वह परम आनंद (Satchidananda) है जो स्थायी है।
            प्रेम (प्रीति) ही वह इकलौता धागा है जो भक्त को साक्षात् परमात्मा से जोड़ सकता है।
            जब माँ हमारी पूजा स्वीकार करती हैं, तो हमारा साधारण जीवन भी एक पवित्र यज्ञ बन जाता है।
        """.trimIndent(),
        english = """
            O Kameshwari! O Mother of the Universe! O Goddess of the form of Truth, Consciousness, and Bliss!
            Please accept this humble worship with love, and O Parameshwari, be pleased with me.
            Kameshwari is the power that fulfills our noble desires and guides us toward liberation.
            The Mother's nature is not just mercy, but that absolute, eternal bliss (Satchidananda).
            Love (Priti) is the only thread that can successfully bind a devotee to the Supreme Lord.
            When the Mother accepts our worship, our ordinary life transforms into a sacred sacrifice.
        """.trimIndent()
    ),
    KshamaShloka(
        id = 8,
        sanskrit = "गुह्यातिगुह्यगोप्त्री त्वं गृहाणास्मत्कृतं जपम् । सिद्धिर्भवतु मे देवि त्वत्प्रसादात्सुरेश्वरि ॥ ८ ॥",
        hindi = """
            हे माँ! आप अत्यंत गोपनीय रहस्यों की रक्षा करने वाली हैं, कृपया मेरे इस जप को स्वीकार करें।
            आपकी ही कृपा से मुझे मेरे कार्यों और साधना में पूर्ण सिद्धि प्राप्त हो, हे सुरेश्वरी!
            सच्ची साधना गुप्त होनी चाहिए, और माँ उस गुप्त ऊर्जा को सुरक्षित रखने वाली परम शक्ति हैं।
            बिना ईश्वर की कृपा (प्रसाद) के, केवल व्यक्तिगत प्रयास से सिद्धि मिलना असंभव है।
            यह श्लोक हमें अपनी आध्यात्मिक कमाई को माँ के चरणों में सुरक्षित रखने की प्रेरणा देता है।
            माँ का संरक्षण ही साधक को अहंकार और बाहरी बाधाओं से बचाकर लक्ष्य तक पहुँचाता है।
        """.trimIndent(),
        english = """
            O Mother! You are the protector of the most profound secrets; please accept the chanting I have performed.
            By Your grace alone, may I attain absolute perfection and success in my endeavors, O Sureshwari!
            True spiritual practice should be kept inward, and the Mother is the power that guards that energy.
            Without divine grace (Prasada), achieving true 'Siddhi' through self-effort alone is impossible.
            This verse inspires us to secure our spiritual gains by placing them at the Mother's lotus feet.
            Her protection shields the seeker from ego and external obstacles, leading them to the goal.
        """.trimIndent()
    ),
    KshamaShloka(
        id = 9,
        sanskrit = "यदक्षरं पदभ्रष्टं मात्राहीनं च यद्भवेत् । पूर्णं भवतु तत्सर्वं त्वत्प्रसादान्महेश्वरि ॥ ९ ॥",
        hindi = """
            पाठ के दौरान मुझसे जो भी अक्षर, पद या मात्रा का गलत उच्चारण हुआ हो या जो छूट गया हो,
            हे महेश्वरी! आपकी असीम कृपा से वह सब त्रुटिहीन और पूर्ण हो जाए।
            यह मन्त्रों की शक्ति के प्रति आदर और अपनी मानवीय अशुद्धि के प्रति जागरूकता को दर्शाता है।
            माँ का 'प्रसाद' वह पारस पत्थर है जो हमारी गलतियों के लोहे को भी सोने में बदल देता है।
            पूर्णता शब्दों में नहीं, बल्कि उस भाव में है जिसे माँ अपनी करुणा से पूर्ण करती हैं।
            यह श्लोक पाठ के अंत में अनजाने में हुई किसी भी भारी गलती के लिए क्षमा माँगने का दिव्य सूत्र है।
        """.trimIndent(),
        english = """
            Whatever letter, word, or vowel measure was mispronounced or omitted during the recitation,
            O Maheshwari, may all of that become flawless and complete by Your boundless grace.
            This reflects deep respect for the power of mantras and an awareness of human error.
            The Mother's 'Prasada' is the philosopher's stone that turns the iron of our mistakes into gold.
            Perfection lies not in the articulation but in the intent, which the Mother completes with Her mercy.
            This verse is a divine formula for seeking forgiveness for any accidental errors made during the path.
        """.trimIndent()
    ),
    KshamaShloka(
        id = 10,
        sanskrit = "अपराधफलं प्राप्य क्षीणानां भवसागरे । त्राही मां सर्वदुःखेभ्यः क्षमस्व परमेश्वरि ॥ १० ॥",
        hindi = """
            (समापन): अपने पापों और अपराधों का फल भोगते-भोगते मैं इस संसार सागर में अत्यंत थक और कमजोर गया हूँ।
            हे परमेश्वरी! मुझे सभी दुखों से बचाइए, मेरे अपराध क्षमा करें और मुझे अपनी शरण में ले लीजिए।
            यहाँ साधक संसार की असारता और कर्मों के चक्र से मुक्ति की अंतिम पुकार करता है।
            'त्राही माम्' (रक्षा करो) की पुकार भक्त के पूर्ण आत्म-समर्पण और माँ पर अटूट भरोसे का प्रमाण है।
            यह क्षमा प्रार्थना का समापन है, जो हृदय में शांति और माँ की सुरक्षा का गहरा बोध कराता है।
            माँ के चरणों में स्थान मिलना ही जीवन के सभी कष्टों और दुखों का एकमात्र और अंतिम समाधान है।
        """.trimIndent(),
        english = """
            (Conclusion): Suffering the consequences of my sins, I have become weak and weary in this ocean of existence.
            O Parameshwari, rescue me from all sorrows, forgive my offenses, and take me under Your shelter.
            Here, the seeker makes a final call for liberation from the cycle of karma and the world's vanity.
            The cry of 'Trahi Mam' (Protect me) is proof of the devotee's total self-surrender and trust.
            This concludes the prayer, leaving the heart with a deep sense of peace and the Mother’s protection.
            Finding a place at the Mother’s feet is the one and only final solution to all life's trials and tribulations.
        """.trimIndent()
    )
)