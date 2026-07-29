package com.sanatangyansagar.ui.screens.veda.samveda.PurvarchikaSamVeda

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PurvarchikaAdhyayaOneScreen() {
    var searchQuery by remember { mutableStateOf("") }

    val filteredVerses = remember(searchQuery) {
        if (searchQuery.isEmpty()) {
            purvarchikaAdhyayaOneData
        } else {
            purvarchikaAdhyayaOneData.filter {
                it.id.toString().contains(searchQuery) ||
                        it.sanskrit.contains(searchQuery, ignoreCase = true) ||
                        it.hindiCommentary.contains(searchQuery, ignoreCase = true) ||
                        it.englishCommentary.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    Scaffold(
        topBar = {
            Column(modifier = Modifier.background(Color.White)) {
                CenterAlignedTopAppBar(
                    title = {
                        Text("प्रथम अध्याय - आग्नेय पर्व", fontWeight = FontWeight.ExtraBold)
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color(0xFFFFE0B2)
                    )
                )
                TextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    placeholder = { Text("खोजें (मंत्र संख्या या शब्द)...") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                    shape = RoundedCornerShape(12.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xFFF5F5F5),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFFFF3E0)),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(filteredVerses) { verse ->
                VedaDetailCard(verse)
            }

            if (filteredVerses.isEmpty()) {
                item {
                    Text(
                        "कोई मंत्र नहीं मिला।",
                        modifier = Modifier.padding(top = 20.dp).fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

@Composable
fun VedaDetailCard(verse: PurvarchikaVerse) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "॥ सामवेद - मंत्र ${verse.id} ॥",
                fontWeight = FontWeight.Bold,
                color = Color(0xFFE65100),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = verse.sanskrit,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                lineHeight = 32.sp
            )
            Divider(modifier = Modifier.padding(vertical = 16.dp))
            Text("हिन्दी व्याख्या:", fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32))
            Text(text = verse.hindiCommentary, textAlign = TextAlign.Justify, lineHeight = 22.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text("English Commentary:", fontWeight = FontWeight.Bold, color = Color(0xFF1565C0))
            Text(text = verse.englishCommentary, textAlign = TextAlign.Justify, lineHeight = 22.sp)
        }
    }
}

data class PurvarchikaVerse(
    val id: Int,
    val sanskrit: String,
    val hindiCommentary: String,
    val englishCommentary: String
)

val purvarchikaAdhyayaOneData = listOf(
    PurvarchikaVerse(
        id = 1,
        sanskrit = "अग्न आ याहि वीतये गृणानो हव्यदातये ।\nनि होता सत्सि बर्हिषि ॥ १ ॥",
        hindiCommentary = """
            हे प्रकाशस्वरूप अग्निदेव! आप स्तुति किए जाने पर हमारे इस पवित्र यज्ञ में हवि (आहुति) ग्रहण करने के लिए पधारें। 
            आप देवताओं के महान आह्वानकर्ता और यज्ञ के कुशल निष्पादक हैं। हम अत्यंत श्रद्धापूर्वक आपको कुश के आसन (बर्हि) पर विराजमान होने के लिए आमंत्रित करते हैं। 
            आपका स्वरूप दिव्य है और आप ही हमारी प्रार्थनाओं को देवलोक तक पहुँचाने वाले एकमात्र माध्यम हैं। 
            जैसे ही आप इस वेदी पर प्रतिष्ठित होते हैं, हमारे संकल्पों में दिव्यता और पवित्रता का संचार होता है। 
            इस यज्ञ की सफलता पूर्णतः आपके आगमन पर निर्भर है। आप हमारे जीवन के अज्ञान रूपी अंधकार को अपनी प्रखर ज्योति से नष्ट कर दें। 
            आपकी कृपा दृष्टि से हमारे द्वारा समर्पित प्रत्येक आहुति देवताओं को तृप्त करती है। 
            हम विनम्र भाव से आपकी प्रार्थना करते हैं कि आप इस आसन को स्वीकार करें और हमारे कल्याण का मार्ग प्रशस्त करें। 
            हे अग्नि, आप ही ऋत (सत्य) के रक्षक हैं, कृपया हमारे इस यज्ञीय अनुष्ठान को पूर्णता प्रदान करें। 
            आपके सानिध्य में हमारा मन शांत और एकाग्र होता है। हमें आध्यात्मिक शक्ति प्रदान करें।
            सृष्टि के आरंभ से ही आप प्रकाश और ऊर्जा के केंद्र रहे हैं, हम आपको बार-बार नमन करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, the radiant one, come to our sacred sacrifice to accept the offerings as we chant your glories. 
            You are the supreme invoker of the gods and the skillful performer of this ritual. 
            With deep devotion, we invite you to take your seat upon the sacred grass (Barhis) prepared for you. 
            Your divine presence is the bridge that carries our humble prayers and oblations to the celestial realms. 
            As you establish yourself upon this altar, you infuse our intentions with purity and divine light. 
            The success of this Yajna depends entirely on your grace and arrival. 
            May your brilliant flames consume the darkness of ignorance within our hearts and minds. 
            Through your mediation, every offering we make reaches the deities and fulfills the cosmic balance. 
            We pray with folded hands that you accept this seat and guide us toward the path of prosperity and truth. 
            O Agni, guardian of the eternal law, bless this ceremony and grant us spiritual strength.
            Since the dawn of creation, you have been the center of light and energy; we bow to you again and again.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 2,
        sanskrit = "तं त्वा समिद्भिरङ्गिरो घृतेन वर्धयामसि ।\nबृहच्छोचा यविष्ठ्य ॥ २ ॥",
        hindiCommentary = """
            हे अंगिरा रूप अग्निदेव! हम पवित्र समिधाओं और शुद्ध घृत (घी) की आहुतियों द्वारा आपकी अग्नि को प्रदीप्त और संवर्धित करते हैं। 
            आप सदा युवा, ऊर्जावान और शक्ति के अक्षय स्रोत रहने वाले देव हैं। आपकी ज्वालाएं अत्यंत विशाल, तेजस्वी और देदीप्यमान हैं। 
            जैसे-जैसे हम इस यज्ञ में घी की आहुति समर्पित करते हैं, आपकी दिव्य शक्ति और अधिक प्रचंड होती जाती है। 
            यह अग्नि हमारे भीतर के विकारों और अज्ञान को भस्म करने की सामर्थ्य रखती है। 
            आपकी यह महान ज्योति समस्त दिशाओं में फैलकर इस संपूर्ण ब्रह्मांड का मंगल और कल्याण करे। 
            हम निरंतर आपकी सेवा और अर्चना में तत्पर रहते हैं ताकि सत्य का मार्ग प्रशस्त रहे। 
            हे यविष्ठ्य (सबसे युवा), आपकी दिव्यता हमें कर्मयोग और सत्यनिष्ठा की ओर प्रेरित करती है। 
            आपकी ऊर्जा हमारे शरीर, मन और प्राणों में नव-उत्साह का संचार करती है। 
            हमारी आहुतियों को स्वीकार कर आप और अधिक प्रकाशमान हों और हमें उन्नति की ओर ले जाएं। 
            आपके इस तेजस्वी रूप की वंदना करते हुए हम स्वयं को ईश्वर के चरणों में समर्पित करते हैं।
            आपकी अनन्त ज्वाला हमारे संकल्पों को नवीन शक्ति प्रदान करे।
        """.trimIndent(),
        englishCommentary = """
            O Agni, in the form of Angiras, we nourish and strengthen your sacred fire with holy fuel and clarified butter. 
            You are the eternally youthful deity, the inexhaustible source of cosmic energy and vital force. 
            May your flames grow vast, radiant, and intensely bright as we perform these ritual offerings. 
            With every drop of Ghee we offer, your divine power expands, ready to burn away our inner impurities. 
            Let this majestic light spread across all corners of the universe, bringing peace and well-being to all. 
            We remain dedicated to your worship, seeking the clarity that only your sacred fire can provide. 
            O Most Youthful One, your divinity inspires us to live a life of truth, action, and integrity. 
            May your vibrant energy rejuvenate our physical body, mind, and spirit with new enthusiasm. 
            Accept our offerings, grow in brilliance, and lead us steadily on the upward path of evolution. 
            We bow before your radiant form, surrendering our ego to the supreme divine light.
            May your eternal flame empower our resolutions with new strength.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 3,
        sanskrit = "स नः पृथु श्रवाय्यमच्छा देव विवाससि ।\nबृहदग्ने सुवीर्यम् ॥ ३ ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमें अत्यंत विशाल यश और श्रेष्ठ कीर्ति प्रदान करने की कृपा करें। 
            हम आपकी प्रार्थना करते हैं कि आप हमारे जीवन को उत्तम शक्ति और पराक्रम से परिपूर्ण कर दें। 
            आपकी कृपा से हमें वह सामर्थ्य प्राप्त हो जिससे हम समाज और राष्ट्र का कल्याण कर सकें। 
            हे देव, आप हमें ऐसा ऐश्वर्य प्रदान करें जो न केवल भौतिक हो, बल्कि आध्यात्मिक रूप से भी हमें समृद्ध बनाए। 
            आपकी ज्योति हमारे संकल्पों को दृढ़ता प्रदान करती है ताकि हम श्रेष्ठ लक्ष्यों को प्राप्त कर सकें। 
            हमें वह तेज प्रदान करें जिससे हम बाधाओं पर विजय प्राप्त करने में सक्षम हों। 
            आपकी महिमा अपार है, और आपकी शरण में आने वाला साधक कभी निर्बल नहीं रहता। 
            हे अग्नि, हमें वह महान धन और सुसंतान प्रदान करें जो ज्ञान की परंपरा को आगे बढ़ाए। 
            हम आपकी स्तुति करते हैं ताकि हमारा जीवन प्रकाशमय, यशस्वी और ऊर्जा से ओत-प्रोत बना रहे। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम धर्म के मार्ग पर अडिग रहें।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please bestow upon us great fame and a noble reputation that spreads far and wide. 
            We invoke you to fill our lives with superior valor, spiritual strength, and heroic energy. 
            By your grace, may we possess the capability to serve society and contribute to the welfare of the world. 
            O God, grant us such abundance that is not only material but also enriches our soul and character. 
            Your sacred light strengthens our resolve, enabling us to achieve the highest goals of human life. 
            Endow us with the brilliance required to overcome all internal and external obstacles. 
            Your glory is boundless, and one who seeks your protection never finds themselves weak or helpless. 
            O Agni, bless us with great wealth and virtuous progeny who will carry forward the lineage of wisdom. 
            We chant your praises so that our lives remain illuminated, successful, and vibrating with vital force. 
            May your merciful gaze always remain upon us as we steadfastly follow the path of Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 4,
        sanskrit = "अग्निं दूतं वृणीमहे होतारं विश्ववेदसम् ।\nअस्य यज्ञस्य सुक्रतुम् ॥ ४ ॥",
        hindiCommentary = """
            हम उन अग्निदेव का दूत के रूप में वरण करते हैं जो देवताओं और मनुष्यों के बीच संदेशवाहक हैं। 
            वे 'होता' हैं, जो यज्ञ में देवताओं का आह्वान करते हैं और समस्त ज्ञान के ज्ञाता हैं। 
            इस यज्ञ के वे ही वास्तविक निष्पादक और अत्यंत कुशल कर्म करने वाले देव हैं। 
            उनकी मेधा और शक्ति से ही हमारा यह अनुष्ठान निर्विघ्न संपन्न होता है। 
            हम अग्नि को अपना मार्गदर्शक चुनते हैं क्योंकि वे ही जानते हैं कि कौन सी आहुति किस देवता तक पहुँचानी है। 
            वे सर्वज्ञ हैं और सृष्टि के कण-कण के रहस्यों से भली-भांति परिचित हैं। 
            यज्ञ की अग्नि में दी गई प्रत्येक आहुति उनके माध्यम से ही दिव्य लोकों तक संचारित होती है। 
            उनकी उपस्थिति मात्र से यज्ञशाला पवित्र और ऊर्जस्वित हो उठती है। 
            हम उन्हें अपना संरक्षक मानकर इस अनुष्ठान का आरंभ करते हैं ताकि सफलता सुनिश्चित हो। 
            हे अग्नि, आप अपनी बुद्धिमत्ता से हमारे इस कर्म को सिद्ध करें और हमें श्रेष्ठ फल प्रदान करें।
        """.trimIndent(),
        englishCommentary = """
            We choose Agni as our divine messenger, the one who bridges the gap between mortals and the gods. 
            He is the 'Hotar', the invoker who calls the deities to the sacrifice, and he is the knower of all things. 
            In this ritual, he is the most skillful performer, ensuring every act is done with perfect wisdom. 
            It is through his intelligence and power that our sacred undertaking is completed without any obstacles. 
            We elect Agni as our guide because only he knows the exact path for our offerings to reach the heavens. 
            He is omniscient, intimately familiar with every secret and every particle of this vast creation. 
            Every oblation cast into the fire is transmitted by him to the respective divine entities in higher realms. 
            His mere presence sanctifies the sacrificial ground and fills the atmosphere with high vibrations. 
            Treating him as our ultimate protector, we begin this ceremony to ensure its spiritual and material success. 
            O Agni, with your profound wisdom, perfect our actions and grant us the most auspicious results.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 5,
        sanskrit = "प्रेष्ठं वो अतिथिं स्तुषे मित्रमिव प्रियम् ।\nअग्ने रथं न वेद्यम् ॥ ५ ॥",
        hindiCommentary = """
            मैं आप सबके प्रिय अतिथि के रूप में अग्निदेव की स्तुति करता हूँ, जो एक प्रिय मित्र के समान आदरणीय हैं। 
            जैसे हम अपने श्रेष्ठ मित्र का स्वागत करते हैं, वैसे ही हम इन अग्निदेव का सम्मान और सत्कार करते हैं। 
            वे रथ के समान जानने योग्य और गतिशील हैं, जो हमें जीवन की यात्रा में निरंतर आगे बढ़ाते हैं। 
            अग्नि हमारे घर के अतिथि हैं, जिनकी सेवा से हमारे परिवार में सुख और समृद्धि का वास होता है। 
            उनकी महत्ता एक ऐसे रथ की तरह है जो हमें अज्ञान से ज्ञान और मृत्यु से अमरत्व की ओर ले जाता है। 
            हम उनकी वंदना करते हैं क्योंकि वे हमारे हृदय के सबसे निकट रहने वाले हितैषी देव हैं। 
            जैसे एक अतिथि का आगमन हर्षोल्लास लाता है, वैसे ही अग्नि का प्रदीप्त होना हमारे मन को आनंदित करता है। 
            वे हमारे जीवन रूपी रथ के सारथी हैं, जो हमें धर्म के मार्ग पर संतुलित बनाए रखते हैं। 
            अग्निदेव की मित्रता हमें अभय (निडरता) प्रदान करती है और हमारे आत्मबल को बढ़ाती है। 
            हम श्रद्धापूर्वक उनकी स्तुति करते हैं ताकि वे सदैव हमारे घर और हृदय में प्रकाशित रहें।
        """.trimIndent(),
        englishCommentary = """
            I praise Agni, the most beloved guest of all, who is as dear to us as a cherished and loyal friend. 
            Just as we welcome an honored friend into our home, we offer our deepest respect and hospitality to him. 
            He is like a chariot, worthy of being known and followed, driving us forward in the journey of life. 
            Agni is the divine guest in our household whose service brings peace, joy, and prosperity to the family. 
            His significance is like that of a celestial vehicle that carries us from darkness to light and mortality to immortality. 
            We worship him because he is the most benevolent deity, residing closest to our very hearts. 
            Just as the arrival of a guest brings happiness, the kindling of the sacred fire fills our minds with bliss. 
            He is the charioteer of our life's vessel, keeping us balanced on the righteous path of Dharma. 
            The friendship of Agni grants us fearlessness and significantly boosts our inner strength and willpower. 
            We offer our prayers with devotion so that he may forever remain illuminated in our homes and souls.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 6,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ६ ॥",
        hindiCommentary = """
            हे पावक (पवित्र करने वाले) अग्निदेव! आप स्वर्ग के प्रकाश को धारण करने वाले और समस्त ऐश्वर्य के स्वामी हैं। 
            आप हमें वह अद्भुत और विविध प्रकार का धन प्रदान करें जिसके आप अधिपति हैं। 
            हम स्तुति करने वाले भक्तों के लिए आप पुष्टिकारक अन्न और जीवनी शक्ति लेकर आएं। 
            आपकी कृपा से हमें वह पोषण प्राप्त हो जिससे हमारा शरीर और मन दोनों ही स्वस्थ और सबल बने रहें। 
            आप केवल भौतिक संपत्ति ही नहीं, बल्कि बौद्धिक और आध्यात्मिक संपदा के भी दाता हैं। 
            हम अपनी प्रार्थनाओं के माध्यम से आपसे वह तेज मांगते हैं जो हमारे जीवन को वैभवशाली बना दे। 
            हे देव, आप हमारे दुखों और दरिद्रता को दूर कर हमें प्रचुरता और संपन्नता के मार्ग पर ले चलें। 
            आपकी दीप्ति स्वर्ग की कांति के समान है, जो हमारे जीवन के अंधकारमय कोनों को प्रकाशित कर देती है। 
            स्तुति करने वालों पर आप सदैव प्रसन्न रहते हैं, अतः हमें अपनी कृपा का पात्र बनाए रखें। 
            हे अग्नि, हमारे लिए वह अन्न और धन लाएं जो हमें धर्मसम्मत कार्यों को करने में सहायक सिद्ध हो।
        """.trimIndent(),
        englishCommentary = """
            O Agni, the Purifier, you are the holder of celestial light and the sovereign lord of all wealth. 
            Please bestow upon us that marvelous and multifaceted riches of which you are the rightful master. 
            For us, your devoted chanters, bring forth nourishing food and the vital energy required for a long life. 
            By your grace, may we receive the sustenance that keeps both our physical body and mind healthy and strong. 
            You are the giver not only of material assets but also of intellectual and spiritual treasures. 
            Through our sincere prayers, we seek the brilliance that will make our lives magnificent and prosperous. 
            O God, remove our sorrows and poverty, and lead us onto the path of abundance and fulfillment. 
            Your radiance is like the splendor of heaven, illuminating the darkest corners of our existence. 
            You are always pleased with those who sing your glories; therefore, keep us under your protective grace. 
            O Agni, fetch for us the resources and food that will assist us in performing our righteous duties.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 7,
        sanskrit = "होता नो अध्वरे वृतो होता सा पत्यते वशी ।\nउतो नः सुश्रवस्तमम् ॥ ७ ॥",
        hindiCommentary = """
            अग्निदेव हमारे इस हिंसा-रहित यज्ञ में 'होता' के रूप में वरण किए गए हैं। 
            वे स्वयं को नियंत्रित करने वाले (वशी) हैं और इस ब्रह्मांड के अधिपति के रूप में प्रतिष्ठित हैं। 
            वे हमें अत्यंत श्रेष्ठ यश और कीर्ति प्रदान करने में पूरी तरह समर्थ हैं। 
            उनकी उपस्थिति यज्ञ को पूर्णता प्रदान करती है और हमारे दोषों का निवारण करती है। 
            अग्नि ही वह शक्ति हैं जो हमारे संकल्पों को अनुशासित करती हैं और हमें आत्म-नियंत्रण सिखाती हैं। 
            वे इस यज्ञ के स्वामी हैं और उनकी आज्ञा से ही दिव्य शक्तियाँ यहाँ एकत्रित होती हैं। 
            हम उनसे प्रार्थना करते हैं कि वे हमारी ख्याति को चारों दिशाओं में फैलाएं और हमें सम्मान दिलाएं। 
            वे सत्य के रक्षक हैं और जो उनकी शरण में आता है, उसे वे विरले ऐश्वर्य से अलंकृत करते हैं। 
            हमारे यज्ञीय कार्यों को वे अपनी दिव्यता से सिंचित करते हैं ताकि हमें श्रेष्ठ फल प्राप्त हो सके। 
            हे अग्नि, आप हमारे पुरोहित बनकर हमें सफलता की उच्चतम सीढ़ियों तक पहुँचाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            Agni has been chosen as the 'Hotar' or the high priest in this non-violent and sacred sacrifice. 
            He is the self-controlled master of his own senses and reigns as the lord over all created beings. 
            He is fully capable of granting us the highest degree of fame, glory, and noble reputation in the world. 
            His presence brings completeness to the ritual and effectively removes all our spiritual and mental flaws. 
            Agni is the power that disciplines our intentions and teaches us the essential art of self-mastery. 
            He is the presiding deity of this Yajna, and by his command, the divine forces gather here to bless us. 
            We pray to him to spread our good name in all directions and grant us a position of honor in society. 
            He is the guardian of Truth, and whoever seeks refuge in him is decorated with rare and divine riches. 
            He nourishes our sacrificial efforts with his divinity so that we may reap the most auspicious rewards. 
            O Agni, act as our priest and guide us graciously to the highest peaks of success and realization.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 8,
        sanskrit = "अधा ह्यग्ने धारयिष्णोऽथैना यविष्ठ्य ।\nदेवांच्छ्रद्धायिणः कुरु ॥ ८ ॥",
        hindiCommentary = """
            हे धारण करने वाले और सबसे युवा अग्निदेव! आप हमारे इस यज्ञीय संकल्प को धारण करें और इसे पुष्ट करें। 
            आप देवताओं को हमारे प्रति श्रद्धालु और अनुग्रही बना दें ताकि वे हमारी प्रार्थनाओं को स्वीकार करें। 
            आपकी शक्ति से ही हमारे भीतर श्रद्धा का उदय होता है और हम देव-कार्यों में प्रवृत्त होते हैं। 
            हे यविष्ठ्य, आप ऊर्जा के पुंज हैं, आप हमारे मन में देवताओं के प्रति अटूट विश्वास उत्पन्न करें। 
            जब आप प्रसन्न होते हैं, तभी अन्य देवता भी हमारे यज्ञ में भाग लेने के लिए उत्सुक होते हैं। 
            हमारी आहुतियों में वह तेज भर दें कि वे देवताओं को आकर्षित करने में सक्षम हो सकें। 
            आप ही वह सेतु हैं जो मनुष्य की श्रद्धा को देवताओं के आशीर्वाद से जोड़ते हैं। 
            हमें आध्यात्मिक स्थिरता प्रदान करें ताकि हम अपने धर्म-पथ से कभी विचलित न हों। 
            आपकी कृपा से हमारे जीवन में देवत्व का संचार हो और हम सात्विक गुणों को प्राप्त करें। 
            हे अग्नि, हमें और हमारे इस अनुष्ठान को अपनी दिव्य सुरक्षा में लेकर हमें कृतार्थ करें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, the sustainer and the youngest of gods, please uphold and strengthen our sacrificial resolve. 
            Make the deities faithful and favorably disposed toward us so that they may accept our humble prayers. 
            It is through your divine power that faith arises within us, motivating us to engage in godly deeds. 
            O Most Youthful One, you are the mass of pure energy; instill in our hearts an unshakable trust in the divine. 
            Only when you are pleased do the other celestial beings become eager to participate in our sacrificial ritual. 
            Infuse our offerings with such brilliance that they become capable of attracting the grace of the gods. 
            You are the bridge that connects human devotion with the profound blessings of the heavenly realms. 
            Grant us spiritual stability and firmness so that we never waver from the path of our sacred duty. 
            By your grace, let divinity flow through our lives and help us attain the most virtuous qualities. 
            O Agni, take us and this ritual under your divine protection and make our lives truly meaningful.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 9,
        sanskrit = "इळेन्यो वरेण्यः स नश्चित्रश्रवस्तमः ।\nअग्ने रक्षस्विनीं रयिम् ॥ ९ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप स्तुति करने योग्य और हम सबके द्वारा वरणीय श्रेष्ठ देव हैं। 
            आप हमें वह अद्भुत और विचित्र यश प्रदान करें जो संसार में अत्यंत दुर्लभ और महान हो। 
            आप हमारी उस संपत्ति और ऐश्वर्य की रक्षा करें जो शत्रुओं और विघ्न-बाधाओं से घिरी हो सकती है। 
            आपकी कृपा से हमारा धन और ज्ञान सदैव सुरक्षित रहे और उत्तरोत्तर बढ़ता ही चला जाए। 
            आपकी महिमा अपार है, और जो आपकी वंदना करता है, उसे आप श्रेष्ठतम संपदा से सुशोभित करते हैं। 
            हमें वह तेज प्रदान करें जिससे हम अपने अर्जित किए हुए यश और संसाधनों की रक्षा करने में समर्थ हों। 
            हे चित्रश्रवस्तम (अद्भुत कीर्ति वाले), आपकी ख्याति संपूर्ण ब्रह्मांड में गुंजायमान है, हमें भी उसका अंश दें। 
            हमारे जीवन को असुरक्षित प्रवृत्तियों से बचाएं और हमें एक मजबूत सुरक्षा कवच प्रदान करें। 
            आप ही वह अग्नि हैं जो बुराइयों को जलाकर केवल शुभ और मंगल को ही शेष रहने देते हैं। 
            हम आपकी शरण में हैं, कृपया हमारे समस्त ऐश्वर्य और आध्यात्मिक उन्नति की रक्षा करने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the most worthy of praise (Ilenyah) and the supreme one to be chosen (Varenyah) by us all. 
            Grant us that marvelous and extraordinary fame which is rare and highly esteemed in this world. 
            Please guard our wealth, resources, and prosperity, which may be threatened by enemies or obstacles. 
            By your grace, may our material and spiritual assets remain secure and continue to grow day by day. 
            Your glory is infinite, and you adorn those who worship you with the most excellent and lasting treasures. 
            Provide us with the brilliance and strength necessary to protect the reputation and resources we have earned. 
            O God of most wonderful fame, your renown echoes through the entire universe; grant us a portion of that glory. 
            Protect our lives from insecure and negative tendencies, providing us with a strong shield of divine energy. 
            You are the fire that burns away all evil, leaving behind only that which is auspicious and good. 
            We seek your refuge; please graciously safeguard all our prosperity and our ongoing spiritual evolution.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 10,
        sanskrit = "स नः पृथु श्रवाय्यमच्छा देव विवाससि ।\nबृहदग्ने सुवीर्यम् ॥ १० ॥",
        hindiCommentary = """
            हे प्रकाशवान अग्निदेव! आप हमारे जीवन को विशाल ख्याति और महान वीरता से आलोकित कर दें। 
            हम आपकी दिव्य ज्योति के सम्मुख प्रार्थना करते हैं कि हमें उत्तम साहस और पराक्रम प्राप्त हो। 
            आपकी उपस्थिति हमारे भीतर के डर को समाप्त कर हमें वीर और दृढ़निश्चयी बनाती है। 
            हमें वह बौद्धिक प्रकाश दें जिससे हम सत्य और असत्य के बीच भेद कर सकें और धर्म का पालन करें। 
            आप ही वह शक्ति हैं जो हमारे प्रयासों को सफलता के शिखर तक पहुँचाने का सामर्थ्य रखती हैं। 
            हे अग्नि, हमें ऐसा सामर्थ्य दें कि हम अपने परिवार, समाज और राष्ट्र के लिए उपयोगी सिद्ध हो सकें। 
            आपकी कृपा से हमारा यश दूर-दूर तक फैले और हम सज्जनों के बीच सम्मानित स्थान प्राप्त करें। 
            हमें वह 'सुवीर्यम्' प्रदान करें जो केवल शारीरिक न होकर मानसिक और आध्यात्मिक भी हो। 
            आपकी वंदना करने से हमारे संकल्पों में नई ऊर्जा का संचार होता है और बाधाएं स्वतः दूर हो जाती हैं। 
            हम निरंतर आपकी अर्चना करते हैं ताकि हमारा जीवन सदैव ऊर्ध्वगामी और प्रकाशपूर्ण बना रहे।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, illuminate our lives with widespread fame and magnificent, heroic valor. 
            Before your divine light, we pray that we may be endowed with supreme courage and great strength. 
            Your sacred presence dissolves the fear within us, making us brave, steady, and determined in our path. 
            Grant us the intellectual brilliance to discern between truth and falsehood and to always follow Dharma. 
            You are the power that possesses the capability to lead our sincere efforts to the very heights of success. 
            O Agni, give us the capacity to be truly useful and beneficial to our families, society, and the nation. 
            By your grace, let our noble reputation spread far and wide, earning us a place of honor among the wise. 
            Bestow upon us 'Suviryam'—the excellent heroism that is not just physical but also mental and spiritual. 
            Worshipping you infuses our resolutions with new energy, causing all obstacles to vanish naturally. 
            We constantly adore you so that our lives may always remain ascending, filled with your divine light.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 11,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ११ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों और संकटों से बचाएं और हमारे शत्रुओं के विनाशकारी प्रयासों को विफल कर दें। 
            हे अजर (कभी बूढ़ा न होने वाले) देव, आप अपनी अत्यंत तप्त ज्वालाओं से हमारे विरोधियों को भस्म कर दें। 
            आपकी शक्ति हमारे चारों ओर एक सुरक्षा कवच का निर्माण करती है जिसमें कोई भी बुराई प्रवेश नहीं कर सकती। 
            आप वह पवित्र अग्नि हैं जो हमारे मन के भीतर छिपे हुए पाप कर्मों और नकारात्मक विचारों को जला डालती हैं। 
            हमें वह शक्ति दें कि हम धर्म के पथ पर चलते हुए कभी विचलित न हों और सदैव सुरक्षित रहें। 
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की रक्षा और असत्य के विनाश के लिए सदैव तत्पर रहती हैं। 
            हम आपकी शरण में आए हैं, कृपया हमें मानसिक और शारीरिक कष्टों से मुक्ति प्रदान करें। 
            जैसे अग्नि अशुद्ध सोने को तपाकर शुद्ध कर देती है, वैसे ही आप हमारे चरित्र को भी उज्ज्वल बना दें। 
            दुष्टों के षड्यंत्रों से हमारी रक्षा करना आपका धर्म है, और हम आपकी इस शक्ति पर पूर्ण विश्वास रखते हैं। 
            हे अविनाशी अग्नि, हमें अपनी दिव्य ज्योति के घेरे में रखें और हमारा कल्याण सुनिश्चित करें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, protect us from sins and calamities, and thwart the destructive attempts of those who wish us harm. 
            O Ageless Deity, consume our adversaries and negative forces with your most intensely hot and radiant flames. 
            Your power creates a protective shield around us, through which no form of evil or negativity can penetrate. 
            You are the holy fire that burns away the sinful tendencies and dark thoughts hidden deep within our minds. 
            Give us the strength to never waver from the path of righteousness and to always remain safe under your care. 
            O Most Resplendent One, your flames are ever ready to defend the truth and destroy all that is false. 
            We have sought your refuge; please grant us liberation from both mental and physical sufferings and pain. 
            Just as fire purifies impure gold through heat, please refine our character and make it shine with virtue. 
            It is your divine role to guard us against the conspiracies of the wicked, and we trust fully in your power. 
            O Imperishable Agni, keep us within the circle of your divine light and ensure our ultimate well-being.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 12,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ १२ ॥",
        hindiCommentary = """
            हे युवा और उत्तम आहुतियों वाले अग्निदेव! आप हमें ईर्ष्या-द्वेष से रहित और पूर्णतः सुरक्षित बनाएं। 
            आपकी कृपा से हमारे भीतर के वे सभी भाव नष्ट हो जाएं जो हमें दूसरों से अलग या शत्रुतापूर्ण बनाते हैं। 
            आप हमें वह सुरक्षा प्रदान करें जिससे हम निर्भय होकर अपने कर्तव्यों का पालन कर सकें। 
            हे यविष्ठ्य, आपकी ऊर्जा हमें एकता और प्रेम के सूत्र में पिरोने वाली है, हमें वह सद्बुद्धि प्रदान करें। 
            हम आपके सम्मुख जो आहुतियां समर्पित करते हैं, वे हमारे जीवन को पवित्र और कलंकमुक्त बना दें। 
            हमें ऐसा आत्मबल दें कि हम बाहरी आक्रमणों और आंतरिक विकारों, दोनों से सुरक्षित रह सकें। 
            आपकी ज्योति हमारे मन के द्वेष रूपी अंधकार को समाप्त कर वहां करुणा और मैत्री का संचार करे। 
            हम आपकी रक्षा में रहकर ही जीवन की बाधाओं को पार करने का साहस जुटा पाते हैं। 
            हे देव, हमें उन सभी शक्तियों से बचाएं जो हमारी उन्नति में बाधक हैं और हमें शांति प्रदान करें। 
            आपकी मित्रता और सुरक्षा हमारे लिए सबसे बड़ा वरदान है, इसे हमारे जीवन में सदैव बनाए रखें।
        """.trimIndent(),
        englishCommentary = """
            O Ever-Youthful Agni, who receives our best offerings, make us free from jealousy and keep us fully protected. 
            By your grace, may all those emotions within us be destroyed that cause separation or hostility toward others. 
            Provide us with that divine security which allows us to perform our duties with a fearless and calm heart. 
            O Youngest One, your energy has the power to bind us in unity and love; please grant us that noble wisdom. 
            Let the oblations we offer in your presence make our lives pure and free from any stain of character. 
            Give us the inner strength required to remain safe from both external attacks and internal psychological flaws. 
            Let your light eliminate the darkness of hatred from our minds, replacing it with compassion and friendship. 
            It is only by remaining under your protection that we find the courage to cross the hurdles of existence. 
            O God, shield us from all forces that hinder our progress and grant us the blessing of enduring peace. 
            Your friendship and protection are the greatest boons for us; please maintain them in our lives forever.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 13,
        sanskrit = "त्वां चित्रश्रवस्तम हव्यवाहमभ्यर्चति ।\nअग्ने त्वां गोभिरङ्गिरः ॥ १३ ॥",
        hindiCommentary = """
            हे अद्भुत कीर्ति वाले और अंगिरा रूप अग्निदेव! हवियों को ढोने वाले आपके दिव्य स्वरूप की हम अर्चना करते हैं। 
            हम आपको स्तुति-वाणी (गोभिः) और पवित्र वचनों के माध्यम से प्रसन्न करने का प्रयास करते हैं। 
            आप ही वह माध्यम हैं जो हमारी श्रद्धा को देवताओं के चरणों तक पहुँचाते हैं, इसलिए हम आपकी पूजा करते हैं। 
            आपकी ख्याति समस्त लोकों में व्याप्त है और आपका स्वरूप अत्यंत मनोहर और वंदनीय है। 
            जैसे गौएँ अपने बछड़े की ओर प्रेम से दौड़ती हैं, वैसे ही हमारी प्रार्थनाएँ आपकी ओर अग्रसर होती हैं। 
            हे हव्यवाहन, आप हमारी आहुतियों को स्वीकार कर हमें आध्यात्मिक और भौतिक समृद्धि प्रदान करें। 
            आपकी अर्चना करने से हमारा मन शांत होता है और हमें दिव्य अनुभूतियाँ प्राप्त होती हैं। 
            आप ज्ञान के पुंज हैं और आपके सानिध्य में अज्ञान का नाश होता है, इसलिए हम आपकी शरण लेते हैं। 
            हमें वह वाणी प्रदान करें जो सत्य और प्रिय हो, ताकि हम आपकी महिमा का उचित गान कर सकें। 
            हे अग्नि, आप हमारे यज्ञ के आधार हैं, हम बार-बार आपको नमन करते हैं और आपकी कृपा चाहते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni of wonderful fame, the descendant of Angiras, we worship your divine form as the carrier of oblations. 
            We strive to please you through the medium of our sacred hymns, pure speech, and Vedic chants (Gobhih). 
            You are the essential link that carries our devotion to the feet of the gods; therefore, we offer you our worship. 
            Your renown is spread across all the worlds, and your form is incredibly beautiful and worthy of adoration. 
            Just as cows run toward their calves with immense love, so do our sincere prayers flow toward your presence. 
            O Carrier of Offerings, accept our oblations and bestow upon us both spiritual and material prosperity. 
            Worshipping you brings tranquility to our minds and allows us to experience profound divine realizations. 
            You are the embodiment of wisdom, and in your presence, ignorance vanishes; thus, we seek your holy refuge. 
            Bless us with speech that is both truthful and pleasant, so that we may sing your glories in the right spirit. 
            O Agni, you are the foundation of our sacrifice; we bow to you repeatedly and seek your eternal grace.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 14,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ १४ ॥",
        hindiCommentary = """
            हे युवा अग्निदेव! आप समस्त प्रकार की समृद्धियों को बढ़ाने वाले और उन्हें पोषण देने वाले हैं। 
            जब हम बार-बार आपकी स्तुति करते हैं, तो हमारी बुद्धि और विचार भी विस्तृत और विशाल हो जाते हैं। 
            आपकी कृपा से हमारी मेधा शक्ति बढ़ती है और हम श्रेष्ठ कार्यों में अपनी बुद्धि का प्रयोग करते हैं। 
            हे यविष्ठ्य, आप ऊर्जा के निरंतर प्रवाह हैं जो हमारे जीवन को संपन्नता से भर देते हैं। 
            आपकी उपासना करने से हमारे संकल्प सिद्ध होते हैं और हमें सर्वांगीण विकास प्राप्त होता है। 
            जैसे अग्नि समिधा पाकर और प्रदीप्त होती है, वैसे ही हमारी बुद्धि आपकी प्रेरणा से और अधिक प्रखर होती है। 
            आप हमें वह मानसिक विस्तार प्रदान करें जिससे हम संपूर्ण विश्व के कल्याण के बारे में सोच सकें। 
            हमारी चेतना को ऊँचा उठाएं ताकि हम तुच्छ स्वार्थों से ऊपर उठकर महान लक्ष्यों की ओर बढ़ सकें। 
            आप ही वह शक्ति हैं जो हमारे श्रम को सार्थक बनाती हैं और हमें पोषण प्रदान करती हैं। 
            हे अग्नि, हम आपकी बार-बार वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट और समृद्ध बना रहे।
        """.trimIndent(),
        englishCommentary = """
            O Youthful Agni, you are the one who increases all forms of nourishment and fosters every type of prosperity. 
            As we repeatedly sing your praises, our intellect and thoughts expand and become vast like the sky. 
            By your grace, our power of discernment grows, and we apply our intelligence to the most noble of deeds. 
            O Youngest One, you are the constant flow of energy that fills our existence with abundance and completeness. 
            Through your worship, our intentions find fulfillment and we achieve all-around development in life. 
            Just as fire blazes brighter upon receiving fuel, our intellect becomes sharper under your divine inspiration. 
            Grant us that mental expansion which allows us to contemplate and work for the welfare of the entire world. 
            Elevate our consciousness so that we may rise above petty selfishness and strive toward magnificent goals. 
            You are the power that makes our hard work meaningful and provides the essential sustenance we need. 
            O Agni, we adore you again and again so that our lives may remain nourished and prosperous in every aspect.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 15,
        sanskrit = "पिता विभाण्डको मह्यं तस्याहं सुत औरसः ।\nऋष्यशृङ्ग इति ख्यातं नाम कर्म च मे भुवि ॥ १५ ॥",
        hindiCommentary = """
            मुनि-पुत्र ने अपना परिचय देते हुए कहा—'महान महर्षि विभाण्डक मेरे पिता हैं, और मैं उनका सगा पुत्र हूँ।' 
            'इस पृथ्वी पर मेरा नाम 'ऋष्यशृंग' के रूप में अत्यंत विख्यात है, और मेरी तपस्या को भी सभी जानते हैं।' 
            मुनि का यह स्पष्ट परिचय उनकी मासूमियत का परिचायक है; उन्होंने अपना पूरा विवरण अजनबी स्त्रियों के सामने रख दिया। 
            'औरसः सुत' कहकर उन्होंने अपनी उस पवित्र वंशावली को प्रमाणित किया जो किसी भी बड़े यज्ञ के लिए आवश्यक होती है। 
            मुनि को यह विश्वास था कि उनका नाम और कर्म पृथ्वी पर विख्यात है; यह उनकी तपस्या का प्रभाव था। 
            ऋष्यशृंग को लग रहा था कि वे अपने प्रशंसकों से बात कर रहे हैं, जो उनके दर्शन के लिए वन में आए हैं। 
            जब किसी की प्रशंसा होती है, तो वह अपना परिचय देने के लिए तुरंत तैयार हो जाता है, यही मानव स्वभाव है। 
            उन स्त्रियों को जिस जानकारी की पुष्टि करनी थी, वह उन्हें मुनि के मुख से ही सत्य रूप में मिल गई थी। 
            यह श्लोक उस संवाद के बिंदु को दिखाता है जहाँ मुनि अनजाने में ही बाहरी दुनिया से जुड़ने लगे थे। 
            हे अग्नि, इस अबोध मुनि की रक्षा करें जो अब एक नए अनुभव की दहलीज पर खड़े हैं।
        """.trimIndent(),
        englishCommentary = """
            Introducing himself enthusiastically, the sage's son said: 'The great Maharishi Vibhandaka is my father, and I am his legitimate, biological son.' 
            'My name is highly renowned across this entire earth as 'Rishyashringa,' and the severe deeds and penance I perform are equally famous.' 
            The sage's straightforward introduction is the ultimate hallmark of his profound innocence; he hid nothing from the strangers. 
            By specifically stating 'Aurasah suta', he unknowingly authenticated his own highly pristine, supreme lineage required for the sacrifice. 
            The sage harbored a subtle, naive sense of his global fame; this was the effect of his long years of isolation and power. 
            Rishyashringa genuinely believed he was simply conversing with admirers who had traveled deep into the forest to see him. 
            It is a universal human trait to drop one's guard when approached with sweet admiration and genuine curiosity. 
            The exact, critical intelligence the women needed to confirm was handed to them directly from the sage's own mouth. 
            This verse illustrates the point in communication where the sage began his transition from isolation to the social world. 
            O Agni, protect this innocent soul who now stands on the threshold of a life-altering experience.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 16,
        sanskrit = "इहाश्रमपदे रम्ये समीपे वासिनीस्तथा ।\nपूजयिष्ये भवन्तीर्हं सर्वेणातिथ्यकर्मणा ॥ १६ ॥",
        hindiCommentary = """
            ऋष्यशृंग ने उन स्त्रियों से कहा—'चूँकि आप सभी इस सुंदर आश्रम के बिल्कुल समीप ही निवास कर रही हैं।' 
            'इसलिए, मैं अपनी ओर से आप सभी का आतिथ्य सत्कार और उचित पूजा करना चाहता हूँ, कृपया पधारें।' 
            मुनि को यह लग रहा था कि वे स्त्रियां उसी वन की कोई पड़ोसी तपस्विनियां हैं; उन्हें तनिक भी संदेह नहीं हुआ। 
            'आतिथ्य सत्कार' भारतीय संस्कृति का वह मूल धर्म है जिसे एक सन्यासी भी पूरी श्रद्धा से निभाता है। 
            ऋष्यशृंग ने अपने धर्म का पालन करते हुए ही उन्हें आमंत्रित किया, पर यह उनकी नई यात्रा का मार्ग बन गया। 
            मुनि का उन्हें 'पूजा' देने की बात कहना उनके उस विशुद्ध हृदय को दर्शाता है जो हर प्राणी में ईश्वर देखता था। 
            स्त्रियों की यही योजना थी कि मुनि स्वयं उन्हें अपने आश्रम में बुलाएँ, ताकि वे उनके पास पहुँच सकें। 
            यहाँ उस मासूमियत के चरम को दर्शाया गया है जहाँ एक ज्ञानी व्यक्ति भी माया के रूप को सत्य मान बैठता है। 
            यह श्लोक उस जाल का महत्वपूर्ण हिस्सा है जहाँ अब स्त्रियां आश्रम के भीतर प्रवेश करने वाली थीं। 
            दशरथ यह सब सुनकर उस मुनि के भोलेपन पर आश्चर्यचकित थे और योजना की सफलता पर प्रसन्न थे।
        """.trimIndent(),
        englishCommentary = """
            Rishyashringa spoke to the women with warmth: 'Since all of you are residing so very close to this highly beautiful and enchanting hermitage of mine.' 
            'Therefore, I deeply desire to offer you my complete hospitality and accord you the highest proper respect; please, grace my home.' 
            The sage was operating under the naive delusion that these women were simply neighboring ascetics living in the same forest. 
            Offering 'Hospitality' is the fundamental sacred Dharma of Indian culture, binding even upon severe forest-dwelling monks. 
            Rishyashringa was merely following his righteous duty, yet this very Dharma paved the way for his future change. 
            Offering to 'worship' them reflects his utterly pure, sinless heart that saw nothing but divinity in every entity he encountered. 
            It was the core objective of the women’s strategy to make the sage voluntarily invite them into his own private sanctuary. 
            This illustrates the absolute peak of innocence where even a learned ascetic can mistake calculated illusion for absolute truth. 
            This verse acts as the transition where the courtesans were now positioned to establish a presence within the hermitage. 
            Dasharatha was astonished by the sage's extreme naivety while being impressed by the ministers' clever planning.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 17,
        sanskrit = "तस्य तद्वचनं श्रुत्वा तासां मतिरजायत ।\nतदा तमाश्रमं गन्तुं जग्मुश्चैव ततस्तु ताः ॥ १७ ॥",
        hindiCommentary = """
            मुनि-पुत्र ऋष्यशृंग के उस प्रेमपूर्ण और स्वागत-भरे वचन को सुनकर, उन स्त्रियों ने आपस में विचार किया। 
            और फिर उसी समय, वे सभी स्त्रियां उस महातपस्वी के आश्रम के भीतर जाने के लिए राजी हो गईं और प्रवेश किया। 
            यह श्लोक अभियान के दूसरे चरण की सफलता का प्रमाण है; अब स्त्रियां लक्ष्य के बिल्कुल पास पहुँच चुकी थीं। 
            स्त्रियों का यह निर्णय बहुत ही परिकलित था; उन्होंने सुनिश्चित किया कि महर्षि विभाण्डक आश्रम से दूर हैं। 
            मुनि का निमंत्रण पाकर आश्रम में जाना उनके लिए एक सुरक्षा भी थी कि वे केवल बुलाने पर ही अंदर आईं। 
            वाल्मीकि जी यहाँ बता रहे हैं कि 'माया' तभी प्रवेश करती है जब मनुष्य स्वयं उसे अपने मन में आने का निमंत्रण देता है। 
            आश्रम, जो अब तक केवल वेदमंत्रों से पवित्र था, वहाँ पहली बार सांसारिक आकर्षण ने अपने कदम रखे थे। 
            यह कोई साधारण प्रवेश नहीं था; यह एक युग का अंत और मुनि के लिए दूसरे युग की शुरुआत होने वाली थी। 
            स्त्रियों के आश्रम में जाने के बाद ही वह मानसिक परिवर्तन शुरू होने वाला था जिसके लिए वे वहाँ आई थीं। 
            इस प्रकार, अंग देश की कूटनीति अब अपने अंतिम और सबसे महत्वपूर्ण पड़ाव की ओर बढ़ रही थी।
        """.trimIndent(),
        englishCommentary = """
            Upon hearing that affectionate and highly welcoming invitation from the sage's son, the clever women made a strategic decision. 
            And then, at that exact moment, all those women confidently agreed to enter the great ascetic's hermitage and walked right inside. 
            This verse provides proof of the success of the second phase of this mission; the women had successfully penetrated the target's sanctuary. 
            The women's collective decision was highly calculated; they had verified that the terrifying Vibhandaka was safely away. 
            Entering the hermitage upon the sage's explicit invitation provided them with a perfect alibi for their presence. 
            Valmiki highlights that 'Maya' can only successfully penetrate a person's life when they voluntarily issue the invitation for it. 
            The hermitage, sanctified exclusively by Vedic mantras, was now being altered by the unprecedented entry of worldly charms. 
            This was no ordinary entry; it marked the end of one severe era and the inevitable dawn of a new worldly phase for the sage. 
            It was only after infiltrating the hermitage that the women could fully execute the psychological change required by the state. 
            Thus, the diplomacy of Anga was now moving toward its final and most significant implementation stage.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 18,
        sanskrit = "प्रविश्य पूजितास्तेन ताः स्त्रियो मुनिसूनुना ।\nउपादायार्ध्यं पाद्यं च कन्दमूलं फलानि च ॥ १८ ॥",
        hindiCommentary = """
            आश्रम के भीतर प्रवेश करने के बाद, उन स्त्रियों की उस अत्यंत भोले मुनि-पुत्र द्वारा भव्य रूप से पूजा की गई। 
            मुनि ने अपनी परंपरा के अनुसार उन्हें 'अर्घ्य', 'पाद्य' और खाने के लिए स्वादिष्ट कंद-मूल तथा फल अर्पित किए। 
            यह श्लोक ऋष्यशृंग की उस विशुद्ध जीवन-शैली को दर्शाता है जहाँ अतिथि को साक्षात् ईश्वर माना जाता है। 
            मुनि यह नहीं जानते थे कि वे जिनका सत्कार कर रहे हैं, वे तपस्विनी नहीं बल्कि अंग देश की गणिकाएं हैं। 
            'अर्घ्य' और 'पाद्य' देना सम्मान का सबसे बड़ा चरण था, जो सिद्ध करता है कि मुनि ने उन्हें उच्च स्थान दिया। 
            परंतु कंद-मूल और फल उन राजसी स्त्रियों के लिए बहुत ही साधारण भोजन था, जो महलों के भोगों की आदी थीं। 
            यहाँ दो बिल्कुल भिन्न संस्कृतियों—'वनवासी' और 'शहरी'—का अत्यंत सुंदर और यथार्थवादी मिलन प्रस्तुत है। 
            स्त्रियों ने मुनि के आतिथ्य को स्वीकार किया, पर वे मुनि को अपने राजसी स्वाद का अनुभव कराने की तैयारी में थीं। 
            यही वह मनोवैज्ञानिक खेल था जो मुनि के मन को वन से पूरी तरह विरक्त कर देने वाला था। 
            हे अग्नि, इस आतिथ्य को स्वीकार करें और इस पवित्र स्थान की मर्यादा को बनाए रखने में सहायक हों।
        """.trimIndent(),
        englishCommentary = """
            Having successfully entered the hermitage, those clever women were reverently hosted by that incredibly innocent son of the sage. 
            Strictly adhering to his forest traditions, the sage offered them 'Arghya', 'Padya', and presented them with the finest wild roots and fruits. 
            This verse illustrates Rishyashringa’s absolutely pristine lifestyle where every guest is treated as a manifestation of the Lord. 
            The sage was oblivious that those he was hosting were not holy ascetics but elite courtesans from a distant city. 
            Offering 'Arghya' and 'Padya' was the highest phase of showing respect, proving that the sage had elevated them above himself. 
            However, the wild roots and fruits were incredibly bland for those women who were accustomed to the luxurious banquets of the palace. 
            Valmiki presents a stark contrast here between two diametrically opposed cultures—the severe forest life and opulent civilization. 
            The women accepted the humble hospitality but were simultaneously preparing to introduce the sage to royal flavors. 
            This psychological battle of tastes was the mechanism designed to sever the sage's deep emotional attachment to the forest. 
            O Agni, accept this hospitality and assist in maintaining the dignity of this sacred forest abode.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 19,
        sanskrit = "तास्तु तान् प्रतिगृह्याशु भयं भीताः स्मचक्रिरे ।\nमहर्षेरागमं तस्य मुनेस्त्वरितमागताः ॥ १९ ॥",
        hindiCommentary = """
            उन स्त्रियों ने मुनि द्वारा दिए गए उस कंद-मूल और फलों को शीघ्रता से स्वीकार तो कर लिया, पर वे डरी हुई थीं। 
            उन्हें यह ज्ञात था कि यदि महर्षि विभाण्डक का अचानक आगमन हो गया, तो उनका क्या हश्र होगा, वे चिंतित थीं। 
            यह श्लोक उस तनावपूर्ण क्षण को दर्शाता है जहाँ योजना बनाने वाले स्वयं अपनी जान के खतरे से भयभीत होते हैं। 
            मुनि का विश्वास जीतना आवश्यक था, पर वे जानती थीं कि वे एक 'टाइम-बम' पर बैठी हैं जो कभी भी फट सकता है। 
            'भयं भीताः' यह सिद्ध करता है कि वे गणिकाएं भी जानती थीं कि विभाण्डक का क्रोध कितना प्रलयंकारी हो सकता है। 
            वाल्मीकि जी यहाँ मनोविज्ञान का वह सूक्ष्म पहलू दिखा रहे हैं जहाँ षड्यंत्रकारी सफलता के करीब होकर भी घबराया होता है। 
            वे अब आश्रम में अधिक समय तक नहीं रुकना चाहती थीं; उनका लक्ष्य मुनि को केवल एक नया स्वाद चखाना था। 
            यह डर ही उनकी योजना की गति का मुख्य कारण बना; यदि वे निडर होतीं, तो शायद वे वहीं रुक जातीं। 
            दशरथ यह सुनकर अनुभव कर रहे थे कि इस सफलता के पीछे कितनी बारीक टाइमिंग और कितना बड़ा जोखिम था। 
            हे अग्नि, उन स्त्रियों को साहस दें और इस कूटनीति को उसके तार्किक अंत तक पहुँचाने में सहायता करें।
        """.trimIndent(),
        englishCommentary = """
            Those clever women accepted the wild roots and fruits with haste, but internally, they were trembling with a terrifying fear. 
            They were acutely aware of the consequences if the wrathful Maharishi Vibhandaka were to suddenly return to his home. 
            This verse perfectly captures the high-tension climax of the mission, demonstrating that even the masterminds were petrified. 
            Winning the sage's trust was mandatory, but they knew they were sitting atop a time-bomb that could detonate at any moment. 
            'Bhayam bhitah' proves that those courtesans knew no army could save them from the incinerating fire of the Maharishi's curse. 
            Valmiki highlights a psychological phenomenon: the conspirator is often most anxious precisely when at the brink of success. 
            They had no intention of lingering; their singular objective was to give the sage a taste of their world and immediately flee. 
            This sheer terror was the catalyst driving the speed of their operation; fear kept them focused on their exit strategy. 
            Listening to this, Dasharatha realized the narrow margins and the calculated risk that underpinned the kingdom's success. 
            O Agni, grant them courage and help this diplomatic effort reach its necessary and logical conclusion.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 20,
        sanskrit = "अग्निं तं मन्ये यो वसुर्यं यं ययन्त्यद्रयः ।\nइळाभिरग्ने मनसा च ॥ २० ॥",
        hindiCommentary = """
            मैं उन अग्निदेव का चिंतन करता हूँ जो समस्त ऐश्वर्य और धन के स्वामी हैं, जिनसे सारा संसार प्रकाशित है। 
            पत्थर भी जिनकी महिमा का गान करते हैं, वे अग्निदेव ही वंदनीय हैं और हम उन्हें श्रद्धा से नमन करते हैं। 
            हम अपनी पवित्र वाणी और शुद्ध मन से आपको निरंतर याद करते हैं ताकि हमारे जीवन में मंगल ही मंगल हो। 
            आपका स्वरूप इतना महान है कि जड़ वस्तुएं भी आपकी उपस्थिति से ऊर्जस्वित और प्रकाशित हो उठती हैं। 
            हे अग्नि, आप हमारे जीवन के आधार हैं और हम आपकी स्तुति में ही अपना और जगत का कल्याण देखते हैं। 
            आपकी कृपा से हमारे संकल्प सिद्ध होते हैं और हमें आध्यात्मिक ऊँचाइयाँ तथा आत्मिक शांति प्राप्त होती है। 
            जैसे पत्थर घर्षण से अग्नि उत्पन्न करते हैं, वैसे ही हमारे निरंतर अभ्यास से हमारे भीतर ज्ञान की ज्योति जले। 
            आप हमें मानसिक शांति और भौतिक संपन्नता दोनों ही प्रदान करने में सक्षम हैं, हम आपकी शरण में हैं। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन सार्थक और पवित्र हो सके। 
            आपकी यह तेजस्वी धारा हमारे अज्ञान को धोकर हमें सत्य के साक्षात्कार की ओर ले जाए, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            I contemplate upon Agni, the Lord of all treasures and the one who sustains the wealth of the universe. 
            Even the stones used for pressing Soma chant his glories, acknowledging his supreme and undeniable power. 
            We remember you constantly with our sacred speech and a pure, focused mind to bring auspiciousness to our lives. 
            Your nature is so magnificent that even inanimate objects vibrate with energy and light in your presence. 
            O Agni, you are the foundation of our existence, and we find our well-being in your eternal praises. 
            By your grace, our resolutions find success and we achieve great spiritual heights and inner peace. 
            Just as stones produce fire through friction, may our constant spiritual practice ignite the flame of wisdom. 
            You are capable of granting both mental peace and material prosperity to your devotees; we seek you. 
            We offer our entire faith at your feet so that our lives may become truly meaningful and holy in every way. 
            Let your radiant stream wash away our ignorance and lead us toward the realization of the ultimate Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 21,
        sanskrit = "आ ते वत्सो मनो यमत् परमाच्चित् सधस्थात् ।\nअग्ने त्वां कामये गिरा ॥ २१ ॥",
        hindiCommentary = """
            हे अग्निदेव! ऋषि वत्स आपको पुकारते हैं, उनकी यह पवित्र वाणी आपके मन को सर्वोच्च धाम (परम स्थान) से हमारी ओर आकर्षित करे।
            हम अपनी स्तुति और मधुर वचनों के माध्यम से आपको प्राप्त करने की प्रबल इच्छा रखते हैं।
            जैसे एक बालक अपनी माता को पुकारता है, वैसे ही हमारी आत्मा आपको पुकार रही है ताकि आप हमारे हृदय में प्रदीप्त हों।
            आपकी उपस्थिति से ही हमारे यज्ञ का संकल्प पूर्ण होता है और हमें दिव्य लोकों की अनुभूति प्राप्त होती है।
            हे देव, आप हमारे तुच्छ विचारों को त्यागकर हमें अपनी अनंत चेतना और प्रकाश के साथ जोड़ दें।
            हमारी वाणी में वह शक्ति भर दें कि वह आपके सर्वोच्च निवास तक पहुँच सके और आपको यहाँ आने के लिए विवश कर दे।
            आप ही वह आकर्षण हैं जो भक्त के मन को संसार से खींचकर परमात्मा की ओर ले जाते हैं।
            हम निरंतर आपकी कामना करते हैं क्योंकि आपके बिना हमारा जीवन अंधकारमय और निरुद्देश्य है।
            आपकी कृपा से ही हमें वह मानसिक शांति प्राप्त होती है जो संसार की किसी भी वस्तु में दुर्लभ है।
            हे अग्नि, आप हमारी प्रार्थनाओं को स्वीकार करें और हमारे जीवन को अपनी पवित्रता से भर दें।
            आपकी यह तेजस्वी धारा हमारे भीतर के अज्ञान को जलाकर हमें परम सत्य की ओर ले जाए।
        """.trimIndent(),
        englishCommentary = """
            O Agni, may the sacred hymns of Sage Vatsa attract your mind and bring you here from your supreme abode in the highest heavens.
            With our devoted voices and holy prayers, we intensely desire and long for your divine presence in our lives.
            Just as a child calls out to its mother with pure love, our souls invoke you to illuminate our inner being.
            It is only through your arrival that the purpose of our sacrifice is fulfilled and we experience celestial bliss.
            O God, lead us away from trivial thoughts and unite our consciousness with your eternal light and wisdom.
            Endow our speech with such power that it resonates in your supreme dwelling and invites you to manifest here.
            You are the divine magnet that draws the seeker's mind away from worldly distractions toward the Ultimate Reality.
            We constantly seek you, for without your guidance, our existence remains dark, aimless, and empty of meaning.
            By your grace alone do we find the mental tranquility that is impossible to find in the material world.
            O Agni, accept our humble supplications and fill our hearts and minds with your purifying and radiant energy.
            May your brilliant stream wash away the stains of our ignorance and lead us to the realization of eternal truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 22,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ २२ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त यज्ञों के वास्तविक 'होता' (आह्वान करने वाले) हैं और समस्त मानव जाति के परम हितैषी हैं।
            आप देवताओं और मनुष्यों के बीच के वह सेतु हैं जो हमारे अर्पण को देवलोक तक पहुँचाते हैं।
            आपकी उपस्थिति के बिना कोई भी मानवीय कर्म दिव्य फल प्रदान नहीं कर सकता, क्योंकि आप ही कर्मों के साक्षी हैं।
            आप मनुष्यों के बीच में रहकर भी देवताओं के समान तेजस्वी और पवित्र बने रहते हैं, यही आपकी महिमा है।
            हे देव, आप हमारे जीवन के प्रत्येक यज्ञ (कर्म) को सफल बनाने के लिए सदा हमारे सहायक बनकर रहें।
            आपकी हितकारी दृष्टि हमें पतन से बचाती है और हमें उन्नति के पथ पर निरंतर अग्रसर करती रहती है।
            जैसे अग्नि भोजन को पकाकर ग्रहण करने योग्य बनाती है, वैसे ही आप हमारे कर्मों को पकाकर देवताओं के योग्य बनाते हैं।
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवार और समाज में शांति और सामंजस्य स्थापित करते हैं।
            आपकी ऊर्जा हमारे शरीर में जीवनी शक्ति के रूप में और मन में प्रेरणा के रूप में सदैव विद्यमान रहती है।
            हे अग्नि, आप हमारे पुरोहित बनकर हमें श्रेष्ठ मार्ग दिखाएं और हमें दिव्यता की ओर ले चलें।
            समस्त चराचर जगत में आपकी ही सत्ता व्याप्त है, हम आपकी शरण में आकर स्वयं को कृतार्थ मानते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the true 'Hotar' or the high priest of all sacrifices and the ultimate well-wisher of entire humanity.
            You act as the sacred bridge between the celestial gods and mortal humans, carrying our offerings to the heavens.
            Without your presence, no human action can yield divine results, for you are the witness of all our deeds.
            Your glory lies in the fact that while residing among humans, you maintain your divine brilliance and purity.
            O God, always remain our helper and guide to ensure that every sacrifice of our life becomes successful.
            Your benevolent gaze protects us from falling into vice and continuously leads us on the path of progress.
            Just as fire transforms raw food into nourishment, you refine our actions and make them worthy of the gods.
            We worship you because you are the one who establishes peace and harmony within our families and society.
            Your energy resides within our bodies as the vital force and within our minds as the source of inspiration.
            O Agni, become our spiritual guide, show us the most excellent path, and lead us toward the heights of divinity.
            Your sovereign power pervades the entire universe; by seeking your refuge, we consider ourselves truly blessed.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 23,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ २३ ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन को क्रोध और ईर्ष्या से रहित (अहेळता) करके उसे पूर्णतः पवित्र और शांत बना दें।
            आप हम पर ऐसी कृपा करें कि देवताओं के प्रति हमारी श्रद्धा सदैव दृढ़ रहे और हम संशयों से मुक्त हो जाएं।
            हमें उन सभी शत्रुओं और विघ्न-बाधाओं से सुरक्षित रखें जो हमारे मन में द्वेष और अविश्वास उत्पन्न करते हैं।
            आपकी कृपा से ही मनुष्य का हृदय विशाल होता है और वह समस्त प्राणियों के प्रति मैत्री भाव रखने में सक्षम होता है।
            हे देव, श्रद्धा ही वह कुंजी है जिससे ईश्वर के द्वार खुलते हैं, कृपया हमारे भीतर इस श्रद्धा को प्रज्वलित करें।
            हम ईर्ष्या-द्वेष की अग्नि में जलने के बजाय आपकी पवित्र ज्ञान की अग्नि में तपकर कुंदन की तरह निखरना चाहते हैं।
            जब हमारा मन आपकी भक्ति में लीन होता है, तब संसार की कोई भी नकारात्मकता हमें प्रभावित नहीं कर सकती।
            आप ही वह शक्ति हैं जो हमारे भीतर के राक्षसी प्रवृत्तियों का दमन कर दैवीय गुणों का संचार करती हैं।
            हमें वह अभय प्रदान करें जिससे हम निर्भीक होकर धर्म के मार्ग पर अपने कदम आगे बढ़ा सकें।
            आपकी कृपा दृष्टि हम पर बनी रहे ताकि हम सदैव सात्विक बने रहें और ईश्वर के सानिध्य का अनुभव करें।
            हे अग्नि, हमारे मन को शुद्ध कर उसे देवताओं का निवास स्थान बना दें ताकि हम सदैव आनंद में रहें।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, make our minds free from anger and jealousy, rendering them completely pure, calm, and serene.
            Grant us your grace so that our faith in the divine powers remains unshakable and we stay free from all doubts.
            Protect us from all enemies and obstacles that attempt to breed malice and distrust within our hearts and minds.
            It is only by your grace that a human heart expands, becoming capable of holding friendship for all living beings.
            O God, faith is the key that opens the doors of the Divine; please ignite and sustain this faith within us.
            Instead of burning in the fire of jealousy, we wish to be refined by your sacred fire of knowledge like pure gold.
            When our mind is immersed in your devotion, no negativity of the material world can affect our inner peace.
            You are the power that suppresses our demonic tendencies and infuses our character with celestial virtues.
            Bestow upon us the gift of fearlessness so that we may boldly advance on the path of righteousness and Dharma.
            May your merciful gaze remain upon us so that we stay virtuous and experience the eternal presence of God.
            O Agni, purify our minds and transform them into a dwelling for the gods, so that we may live in perpetual bliss.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 24,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ २४ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें समस्त पापों (अंहसः) और उनके द्वारा उत्पन्न होने वाले संकटों से निरंतर सुरक्षित रखें।
            जो शक्तियाँ या शत्रु हमारा अहित करना चाहते हैं, आप उनके प्रति सचेत रहकर हमारे चारों ओर सुरक्षा कवच बनाएं।
            हे अजर देव, आप अपनी अत्यंत तप्त और प्रखर ज्वालाओं से हमारे भीतर और बाहर के शत्रुओं को भस्म कर दें।
            पाप वह अंधकार है जो मनुष्य की बुद्धि को हर लेता है, आप अपनी ज्योति से उस अंधकार का विनाश करें।
            हम आपकी शरण में आए हैं क्योंकि आपके अतिरिक्त कोई भी हमें कर्मों के भयानक बंधनों से मुक्त नहीं कर सकता।
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे जीवन के समस्त क्लेशों को नष्ट कर दें।
            आपकी तपन हमारे लिए दुखदायी नहीं, बल्कि हमारे उद्धार के लिए है ताकि हम शुद्ध और सात्विक बन सकें।
            हे तपिष्ठ, आपकी ज्वालाएं उन दुष्ट प्रवृत्तियों के लिए काल के समान हैं जो धर्म की हानि करना चाहती हैं।
            हमें वह शक्ति दें कि हम स्वयं कभी पाप के मार्ग पर न चलें और सदैव आपकी मर्यादा में सुरक्षित रहें।
            आपकी कृपा दृष्टि से हमारा कल्याण सुनिश्चित है, हम आपकी इस तेजस्वी शक्ति की बार-बार वंदना करते हैं।
            हे अग्नि, आप हमारी रक्षा का भार उठाएं और हमें शांतिपूर्ण और धर्ममय जीवन प्रदान करने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, continuously protect us from all sins (Anhasah) and the calamities that arise from our past misdeeds.
            Be vigilant against those forces or enemies who wish us harm, and create a protective shield around our lives.
            O Ageless One, consume our internal and external enemies with your most intensely hot and radiant flames.
            Sin is the darkness that robs a human of their intellect; destroy that darkness with your eternal divine light.
            We have sought your refuge because none other than you can liberate us from the terrible bonds of our actions.
            Just as fire burns away impurities, please destroy all the afflictions and sufferings that plague our existence.
            Your heat is not for our pain, but for our ultimate salvation, ensuring we emerge as pure and virtuous beings.
            O Most Resplendent One, your flames act as Time itself for those evil tendencies that seek to harm the Dharma.
            Grant us the strength to never walk the path of sin ourselves and to always remain safe under your divine laws.
            Our well-being is guaranteed under your merciful gaze; we repeatedly bow before your radiant and majestic power.
            O Agni, take upon yourself the responsibility of our protection and grant us a peaceful and righteous life.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 25,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ २५ ॥",
        hindiCommentary = """
            हे युवा और उत्तम रीति से आहुति प्राप्त करने वाले अग्निदेव! आप हमें समस्त द्वेषी शक्तियों से सुरक्षित रखें।
            आपकी कृपा से हमारे जीवन में ऐसा वातावरण बने जहाँ कोई भी हमसे ईर्ष्या या शत्रुता न कर सके।
            हमें वह तेज और सुरक्षा प्रदान करें जिससे हम निडर होकर अपने आध्यात्मिक लक्ष्यों की ओर बढ़ सकें।
            हे यविष्ठ्य, आप ऊर्जा के वह स्रोत हैं जो कभी क्षीण नहीं होता, हमें भी अपनी अक्षय ऊर्जा का अंश दें।
            जब हम यज्ञ में आहुति देते हैं, तब हमारा उद्देश्य केवल व्यक्तिगत लाभ नहीं, बल्कि विश्व का कल्याण होता है।
            आप हमारे इस उदार संकल्प की रक्षा करें और इसे सिद्ध करने के लिए हमें आवश्यक सामर्थ्य प्रदान करें।
            द्वेष वह विष है जो मनुष्य के आत्मबल को खा जाता है, आप हमें इस विष से मुक्त कर अमृत तत्व प्रदान करें।
            आपकी ज्योति हमारे घर के चारों ओर एक ऐसा सुरक्षा घेरा बनाए कि कोई भी नकारात्मक ऊर्जा प्रवेश न कर सके।
            हम आपकी मित्रता और संरक्षण में स्वयं को अत्यंत सौभाग्यशाली मानते हैं और आपकी वंदना करते हैं।
            हे अग्नि, हमें और हमारे प्रियजनों को अपनी दिव्य छाया में रखें और हमें सुख-समृद्धि के मार्ग पर ले चलें।
            आपकी कृपा से हमारा जीवन कलंकमुक्त और यशस्वी बना रहे, यही हमारी आपसे करबद्ध प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Ever-Youthful Agni, who receives offerings perfectly made, protect us from all malicious and hateful forces.
            By your grace, let such an atmosphere be created in our lives where none can harbor jealousy or enmity toward us.
            Provide us with the brilliance and security that allow us to advance toward our spiritual goals without any fear.
            O Youngest One, you are the source of energy that never depletes; grant us a portion of your inexhaustible power.
            When we offer oblations in the sacred fire, our aim is not just personal gain but the welfare of the entire world.
            Protect this noble resolve of ours and grant us the necessary capability and strength to fulfill it completely.
            Malice is a poison that consumes a person's inner strength; free us from this poison and grant us the nectar of immortality.
            Let your light form such a protective circle around our homes that no negative energy can ever find its way in.
            We consider ourselves extremely fortunate to be under your friendship and protection and we sing your glories.
            O Agni, keep us and our loved ones under your divine shadow and lead us on the path of happiness and prosperity.
            May our lives remain stainless and successful through your grace; this is our humble and heartfelt prayer to you.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 26,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ २६ ॥",
        hindiCommentary = """
            हे प्रदीप्त और पवित्र करने वाले अग्निदेव! आप विवस्वान (सूर्य) के समान तेजस्वी वैभव हमारे लिए लेकर आएं।
            आप हमें वह अन्न और शक्ति प्रदान करें जिससे हमारी आयु लंबी हो और हम सदैव कर्मशील बने रहें।
            आप समस्त ऐश्वर्यों के अधिपति हैं, इसलिए हमें वह अद्भुत धन दें जो हमारे जीवन को वैभवशाली बना दे।
            हे पावक, आप हमारे पापों को धोकर हमें दिव्य लोकों की कांति के समान शुद्ध और चमकदार बना दें।
            आपकी कृपा से हमें वह पोषण प्राप्त हो जिससे हमारा परिवार और समाज दोनों ही पुष्ट और समृद्ध हों।
            आप केवल भौतिक सुख ही नहीं, बल्कि वह आत्मिक तेज भी प्रदान करते हैं जो स्वर्ग के समान सुखद होता है।
            हम आपकी निरंतर स्तुति करते हैं ताकि आपकी उदारता का प्रवाह हमारे जीवन में सदैव बना रहे।
            हे देव, आप हमारे दुखों के अंधकार को अपनी प्रखर ज्योति से समाप्त कर हमें आनंद के मार्ग पर ले चलें।
            आपकी उपस्थिति मात्र से ही हमारे अभाव दूर हो जाते हैं और हम पूर्णता का अनुभव करने लगते हैं।
            हे अग्नि, आप हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता लाएं और हमें यशस्वी बनाने की कृपा करें।
            हम आपकी इस भव्य महिमा को बार-बार नमन करते हैं और आपके आशीर्वाद की कामना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Radiant and Purifying Agni, bring for us a splendor that is as brilliant as the sun (Vivasvan) itself.
            Provide us with the food and vital energy that ensure a long life and keep us continuously active and productive.
            You are the sovereign lord of all forms of wealth; therefore, grant us that marvelous riches that make our lives magnificent.
            O Purifier, wash away our sins and make us as pure and glowing as the radiance of the celestial realms.
            By your grace, let us receive that nourishment which makes both our families and our society robust and prosperous.
            You do not just provide material comforts; you also bestow that spiritual luster which is as pleasant as heaven itself.
            We constantly sing your praises so that the flow of your immense generosity remains forever present in our lives.
            O God, terminate the darkness of our sorrows with your intense light and lead us onto the path of eternal bliss.
            Your mere presence dissolves our scarcities and makes us experience a profound sense of completeness and wholeness.
            O Agni, bring abundance into every field of our existence and graciously make us successful and renowned.
            We bow repeatedly before your magnificent glory and earnestly seek your divine and lasting blessings.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 27,
        sanskrit = "अग्ने त्वं नो अन्तम उतान्तम उतान्तमः ।\nउत सखा शिवो भव ॥ २७ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमारे सबसे निकट (अन्तमः), अत्यंत आत्मीय और हमारे हृदय के सबसे पास रहने वाले देव हैं।
            आप हमारे लिए एक कल्याणकारी मित्र (शिवः सखा) बनकर हमारा सदैव मार्गदर्शन और सहयोग करें।
            मनुष्य जब अकेला होता है, तब आपकी ज्योति ही उसे संबल प्रदान करती है और उसे सही मार्ग दिखाती है।
            आपकी मित्रता संसार के अन्य संबंधों से श्रेष्ठ है, क्योंकि आप कभी भी अपने भक्त का साथ नहीं छोड़ते।
            हे देव, आप हमारे भीतर के आत्मभाव के रूप में विद्यमान हैं, कृपया हमें अपनी दिव्यता का बोध कराएं।
            जब हम संकटों से घिरे होते हैं, तब आपका सान्निध्य हमें साहस और शांति प्रदान करने वाला होता है।
            हमें वह दृष्टि दें जिससे हम आपको अपने जीवन के कण-कण में और प्रत्येक कार्य में महसूस कर सकें।
            आप हमारे रक्षक भी हैं और हमारे गुरु भी, आपकी शिक्षाएं हमें अज्ञान के गर्त से बाहर निकालती हैं।
            हे शिव (कल्याणकारी), आपकी कृपा से हमारा अमंगल दूर हो और हमारे जीवन में केवल शुभ का ही उदय हो।
            हम आपसे वह स्नेह और सुरक्षा मांगते हैं जो एक सच्चा मित्र अपने प्रिय को प्रदान करता है।
            हे अग्नि, आप हमारे साथ सदैव रहें और हमें अपनी दिव्य ऊर्जा से अनुगृहीत करते रहें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are our nearest one (Antamah), our most intimate relative, and the one residing closest to our hearts.
            Become a benevolent and auspicious friend (Shivah Sakha) to us, always guiding and supporting our endeavors.
            When a person feels alone, your sacred light provides them with strength and shows them the righteous path.
            Your friendship is superior to all worldly relationships because you never abandon your devoted follower.
            O God, you exist within us as our very soul; please grant us the realization of your indwelling divinity.
            When we are surrounded by calamities, your close presence provides us with immense courage and deep peace.
            Give us the vision to feel your presence in every atom of our lives and in every action that we perform.
            You are both our protector and our supreme teacher; your wisdom pulls us out of the pit of ignorance.
            O Auspicious One, may all inauspiciousness be removed by your grace, and only that which is good arise in our lives.
            We seek from you that affection and security which a true friend provides to their most beloved one.
            O Agni, stay with us forever and keep us favored and empowered with your divine and vitalizing energy.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 28,
        sanskrit = "आ नो मित्रस्य वरुणस्य प्र यंसत् ।\nअग्ने रयिं सुवीर्यम् ॥ २८ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें मित्र और वरुण देव के समान अत्यंत श्रेष्ठ और पवित्र धन प्रदान करने की कृपा करें।
            आप हमें वह 'सुवीर्यम्' (उत्तम वीरता और सामर्थ्य) दें जिससे हम धर्म की रक्षा और समाज का उद्धार कर सकें।
            मित्र देव सौहार्द के प्रतीक हैं और वरुण देव नैतिकता के रक्षक, इन दोनों के गुण हमारे भीतर समाहित हों।
            आपकी कृपा से हमें वह ऐश्वर्य प्राप्त हो जो सत्य और न्याय के मार्ग पर चलकर अर्जित किया गया हो।
            हे देव, हमें केवल धन ही नहीं, बल्कि वह चरित्र भी दें जो उस धन का सदुपयोग करने में सहायक हो।
            आपकी ज्योति हमारे संकल्पों को वह दृढ़ता प्रदान करे जिससे हम वीरतापूर्वक चुनौतियों का सामना कर सकें।
            हम आपकी वंदना करते हैं ताकि हमारे जीवन में अनुशासन और प्रेम का सुंदर समन्वय बना रहे।
            आप ही वह शक्ति हैं जो हमारे परिश्रम को महान सफलता में परिवर्तित करने का सामर्थ्य रखती हैं।
            हे अग्नि, हमें वह वैभव दें जो हमारे वंश की गरिमा को बढ़ाए और हमें आध्यात्मिक शांति भी प्रदान करे।
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम ऐश्वर्य पाकर भी अहंकारी न हों और विनम्र बने रहें।
            हमें वह बल प्रदान करें जिससे हम निर्बलों की सहायता कर सकें और धर्म की ध्वजा ऊँची रख सकें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please bestow upon us that most excellent and sacred wealth, similar to the gifts of Mitra and Varuna.
            Grant us 'Suviryam'—superior valor and capability—so that we may protect Dharma and uplift our society.
            Mitra represents harmony and Varuna represents cosmic order and morality; let the qualities of both reside in us.
            By your grace, let us receive that abundance which is earned by following the path of truth and justice.
            O God, do not give us just wealth, but also the character and wisdom required to use that wealth for noble causes.
            May your light provide our resolutions with the firmness needed to face life's challenges heroically.
            We worship you so that a beautiful balance of discipline and love remains constantly present in our lives.
            You are the power that possesses the capability to transform our hard work and labor into magnificent success.
            O Agni, grant us the splendor that enhances our lineage's dignity and provides us with deep spiritual peace.
            May your merciful gaze remain upon us so that even with abundance, we do not become arrogant but stay humble.
            Endow us with the strength to assist the weak and to keep the flag of righteousness flying high always.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 29,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ २९ ॥",
        hindiCommentary = """
            हे पावक अग्निदेव! आप स्वर्ग की कांति के समान दिव्य और मन को हरने वाले वैभव के स्वामी हैं।
            आप हम स्तुति करने वाले भक्तों के लिए वह अद्भुत धन और अन्न लेकर आएं जो हमें पुष्ट और प्रसन्न करे।
            आपकी कृपा से हमारे जीवन में किसी भी वस्तु का अभाव न रहे और हम सदैव संपन्न बने रहें।
            हे देव, आप हमारे अंतःकरण को शुद्ध कर हमें वह दृष्टि दें जिससे हम आपके दिव्य ऐश्वर्य को देख सकें।
            आप ही वह शक्ति हैं जो हमारे जीवन की दरिद्रता को समाप्त कर हमें प्रचुरता के शिखर पर पहुँचाती हैं।
            हमें वह 'इषम्' (शक्तिशाली प्रेरणा और अन्न) प्रदान करें जो हमारे शरीर और आत्मा दोनों को तृप्त करे।
            आपकी महिमा का गान करने से हमारे दुखों का नाश होता है और हमें नवीन उत्साह की प्राप्ति होती है।
            हे अग्नि, आप हमारे घरों को सुख, शांति और समृद्धि से भर देने वाले उदार दाता के रूप में पधारें।
            आपकी ज्योति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव का मार्ग दिखाए।
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें वह स्थायी संपत्ति दें जो कभी नष्ट न हो।
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके सानिध्य में सदैव मंगलमय जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Purifying Agni, you are the master of magnificent and enchanting wealth that shines like celestial luster.
            For us, your devoted chanters, bring forth that marvelous riches and nourishment that make us strong and happy.
            By your grace, let there be no scarcity of any kind in our lives, and may we always remain prosperous and full.
            O God, purify our inner self and grant us the vision to perceive and appreciate your divine abundance.
            You are the power that terminates the poverty of our existence and leads us to the very peaks of plenty.
            Provide us with 'Isham'—powerful inspiration and sustenance—that satisfies both our physical body and soul.
            Singing your glories destroys our sorrows and grants us a renewed sense of enthusiasm and vital energy.
            O Agni, come as the generous giver who fills our homes with enduring joy, peace, and material prosperity.
            Let your light illuminate every dark corner of our lives and show us the pathway to magnificent splendor.
            We pray to you with deep devotion to grant us that permanent wealth which can never be lost or destroyed.
            May your merciful gaze always be upon us as we lead an auspicious life under your divine and protective presence.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 30,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ३० ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के जाल से और अज्ञान के संकटों से सदैव सुरक्षित रखने की कृपा करें।
            जो शत्रु हमारे विनाश की योजना बना रहे हैं, आप अपनी प्रखर बुद्धि से उनके प्रयासों को विफल कर दें।
            हे अजर और अमर देव, आप अपनी तेजस्वी और तप्त ज्वालाओं से हमारे समस्त विकारों को जला डालें।
            आपकी अग्नि केवल जलाती नहीं, बल्कि वह जीवन को नया जन्म और नवीन शुद्धता प्रदान करती है।
            हम आपकी शरण में आकर अभय की याचना करते हैं क्योंकि आप ही काल के भी अधिपति हैं।
            हमें वह मानसिक दृढ़ता प्रदान करें जिससे हम अधर्म के प्रलोभनों में न फँसें और सदैव सुरक्षित रहें।
            आपकी ज्योति हमारे चारों ओर एक अभेद्य सुरक्षा दुर्ग का निर्माण करे जिसमें कोई बुराई प्रवेश न कर सके।
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की रक्षा के लिए सदैव तत्पर रहती हैं, हमें भी सत्यनिष्ठ बनाएं।
            हमारे जीवन के प्रत्येक क्षण में आपकी रक्षात्मक शक्ति का अनुभव हमें साहस और शांति प्रदान करता है।
            हे अग्नि, आप हमारे स्वामी और रक्षक हैं, हमें अंधकार से प्रकाश की ओर और मृत्यु से अमरत्व की ओर ले चलें।
            हम आपकी इस दिव्य शक्ति की बार-बार वंदना करते हैं और आपसे निरंतर सुरक्षा की प्रार्थना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously protect us always from the net of sins and the calamities of deep ignorance.
            Those enemies who are plotting our destruction, please foil their attempts with your supreme intelligence.
            O Ageless and Immortal Deity, consume all our mental and physical impurities with your radiant and hot flames.
            Your fire does not just burn; it grants a new birth and a fresh sense of purity and holiness to our life.
            Seeking your refuge, we pray for fearlessness, for you are the ultimate master even of Time itself.
            Grant us the mental firmness to not fall into the temptations of unrighteousness and to always stay safe.
            Let your light create an impenetrable fortress of security around us through which no evil can enter.
            O Most Resplendent One, your flames are ever ready to defend the truth; please make us also devoted to truth.
            The experience of your protective power in every moment of our lives gives us immense courage and peace.
            O Agni, you are our Lord and Protector; lead us from darkness to light and from mortality to immortality.
            We repeatedly bow before your divine power and pray for your constant and unwavering protection over us.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 31,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ३१ ॥",
        hindiCommentary = """
            हे युवा अग्निदेव! आप उत्तम आहुतियों से तृप्त होकर हमें उन शक्तियों से बचाएं जो हमसे द्वेष रखती हैं।
            आपकी ऊर्जा हमें वह कवच प्रदान करे जिससे हम बाहरी आलोचनाओं और बाधाओं से अप्रभावित रह सकें।
            हमें वह पवित्रता दें जिससे हमारे मन में दूसरों के प्रति कभी भी बुरी भावना या ईर्ष्या उत्पन्न न हो।
            हे यविष्ठ्य, आपकी शक्ति से ही हमारा आत्मबल बढ़ता है और हम कठिन से कठिन मार्ग पर चल पाते हैं।
            यज्ञ में दी गई हमारी प्रत्येक आहुति आपकी कृपा से ही सार्थक होती है और हमें अभीष्ट फल देती है।
            आप हमारे जीवन को सुरक्षित और समृद्ध बनाने के लिए अपनी दिव्य ज्योति का विस्तार हमारे चारों ओर करें।
            द्वेष की भावना मनुष्य के तेज को कम कर देती है, आप हमें इस अंधकार से निकालकर तेजस्वी बनाएं।
            आपकी मित्रता हमारे लिए वह औषधि है जो हमारे मन के समस्त रोगों और संशयों को दूर कर देती है।
            हम श्रद्धापूर्वक आपकी अर्चना करते हैं ताकि हमारा जीवन सदैव शुभ कर्मों में लगा रहे और हम उन्नत हों।
            हे अग्नि, हमें वह साहस दें कि हम स्वयं को शुद्ध रख सकें और समाज के लिए एक आदर्श प्रस्तुत करें।
            आपकी कृपा दृष्टि हम पर बनी रहे और हम आपके संरक्षण में सदैव निर्भीक होकर जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful Agni, satisfied by our best offerings, protect us from those forces that harbor malice against us.
            May your energy provide us with a shield that allows us to remain unaffected by external criticism and hurdles.
            Grant us that purity which ensures that no ill-will or jealousy ever arises in our minds toward others.
            O Youngest One, it is through your power that our willpower increases, enabling us to walk the toughest paths.
            Every oblation we offer in the sacrifice becomes meaningful only by your grace and grants us desired results.
            Expand your divine light all around us to make our lives secure, protected, and abundantly prosperous.
            The feeling of malice reduces a person's inner luster; take us out of this darkness and make us radiant.
            Your friendship is a medicine for us that cures all the diseases and doubts of our wandering mind.
            We worship you with devotion so that our life remains engaged in noble deeds and we continue to evolve.
            O Agni, give us the courage to keep ourselves pure and to present a virtuous model for the society.
            May your merciful gaze remain upon us as we lead a fearless and meaningful life under your divine protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 32,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ३२ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य के समान तेजस्वी और ऊर्जा से भरपूर ऐश्वर्य हमारे जीवन में लेकर आएं।
            आप हमें वह शक्ति प्रदान करें जिससे हम लंबी आयु तक स्वस्थ रहकर धर्म और ज्ञान की सेवा कर सकें।
            आप स्वर्ग के अद्भुत वैभव के स्वामी हैं, कृपया हमें वह धन दें जो हमारी आत्मा को भी तृप्त कर सके।
            हे पावक, आपकी पवित्रता हमारे संपूर्ण व्यक्तित्व को निखार दे और हमें दैवीय गुणों से अलंकृत करे।
            आपकी कृपा से हमारे जीवन में सुख-सुविधाओं का अभाव न रहे और हम सदैव दूसरों की सहायता के लिए समर्थ हों।
            आप केवल बाह्य संपत्ति ही नहीं, बल्कि वह आंतरिक प्रकाश भी देते हैं जो हमें सत्य का मार्ग दिखाता है।
            हम निरंतर आपकी स्तुति करते हैं ताकि हमारा हृदय सदैव भक्ति और ज्ञान के प्रकाश से भरा रहे।
            हे देव, आप हमारे जीवन की नीरसता को समाप्त कर उसमें नवीन उत्साह और आनंद का संचार करें।
            आपकी दीप्ति हमारे अज्ञान के बादलों को हटाकर हमें स्पष्ट दृष्टि और सही निर्णय लेने की क्षमता प्रदान करे।
            हे अग्नि, आप हमारे रक्षक और दाता के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली बनाने की कृपा करें।
            हम आपकी इस भव्य महिमा को नमन करते हैं और प्रार्थना करते हैं कि आपकी कृपा हम पर सदैव बनी रहे।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our lives a splendor and prosperity as brilliant and energetic as the Sun.
            Provide us with the vital force that allows us to remain healthy for a long life to serve Dharma and knowledge.
            You are the master of the marvelous abundance of heaven; please grant us wealth that also satisfies our soul.
            O Purifier, let your holiness refine our entire personality and decorate us with divine and noble virtues.
            By your grace, let there be no lack of comforts in our lives, ensuring we are always capable of helping others.
            You do not just provide external assets; you also grant that internal light which reveals the path of truth.
            We constantly sing your praises so that our hearts remain forever filled with the light of devotion and wisdom.
            O God, terminate the monotony of our lives and infuse them with fresh enthusiasm and profound joy.
            Let your radiance clear the clouds of our ignorance and grant us clear vision and the ability to decide rightly.
            O Agni, always remain with us as our protector and provider, graciously making our lives magnificent and full.
            We bow before your grand majesty and pray that your merciful grace remains upon us for all time.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 33,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ ३३ ॥",
        hindiCommentary = """
            हे युवा अग्निदेव! आप समस्त प्रकार की समृद्धियों और पुष्टियों के मूल स्रोत हैं, उन्हें आप ही पोषण देते हैं।
            जब हम निरंतर आपकी स्तुति और वंदना करते हैं, तो हमारी बुद्धि और विचार भी विस्तृत और उदार हो जाते हैं।
            आपकी कृपा से हमारी मेधा शक्ति प्रखर होती है और हम महान लक्ष्यों को प्राप्त करने की दिशा में बढ़ते हैं।
            हे यविष्ठ्य, आपकी ऊर्जा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता और पूर्णता लाने वाली है।
            आपकी उपासना करने से हमारे संकल्प सिद्ध होते हैं और हमें सर्वांगीण विकास प्राप्त होता है, यही आपकी महिमा है।
            जैसे अग्नि समिधा पाकर और अधिक प्रदीप्त होती है, वैसे ही हमारी आत्मा आपकी प्रेरणा से और तेजस्वी होती है।
            आप हमें वह मानसिक विशालता प्रदान करें जिससे हम संकुचित स्वार्थों से ऊपर उठकर जगत का कल्याण कर सकें।
            हमारी चेतना को उस स्तर तक उठाएं जहाँ हम ईश्वर की सर्वव्यापकता का अनुभव कर सकें और शांत रह सकें।
            आप ही वह शक्ति हैं जो हमारे कठिन परिश्रम को ईश्वरीय आशीर्वाद में परिवर्तित करने का सामर्थ्य रखती हैं।
            हे अग्नि, हम आपकी बार-बार वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट, समृद्ध और सार्थक बना रहे।
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपकी पवित्र ज्योति में सदैव सुरक्षित और सुखी रहें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful Agni, you are the original source of all forms of prosperity and nourishment; you sustain them all.
            As we continuously sing your praises and worship you, our intellect and thoughts become vast, noble, and broad.
            By your grace, our mental power becomes sharp, leading us toward the achievement of magnificent goals.
            O Youngest One, your energy is what brings completeness and abundance into every single field of our existence.
            Worshipping you ensures the fulfillment of our resolutions and grants us all-around development and growth.
            Just as fire blazes brighter when fueled, our soul becomes more radiant and brilliant under your divine inspiration.
            Grant us that mental expansion which allows us to rise above narrow selfishness and work for the world's welfare.
            Elevate our consciousness to a level where we can experience the omnipresence of God and remain peaceful.
            You are the power that possesses the capability to transform our hard work and labor into divine blessings.
            O Agni, we adore you repeatedly so that our lives remain nourished, prosperous, and meaningful in every aspect.
            May your merciful gaze always be upon us as we stay safe, secure, and happy within your sacred and holy light.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 34,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ३४ ॥",
        hindiCommentary = """
            हे पावक अग्निदेव! आप दिव्य लोकों के स्वामी और समस्त ऐश्वर्यों के नियंत्रक हैं, आप हमें अद्भुत वैभव दें।
            हम स्तुति करने वाले भक्तों के लिए आप वह अन्न और प्रेरणा लेकर आएं जो हमारे जीवन को ऊर्ध्वगामी बनाए।
            आपकी कृपा से हमारी दरिद्रता का समूल नाश हो और हम केवल भौतिक ही नहीं, बल्कि आत्मिक रूप से भी धनी बनें।
            हे देव, आप हमारे अज्ञान को अपनी प्रखर ज्योति से जलाकर हमें वह सत्य मार्ग दिखाएं जहाँ केवल शांति ही शांति हो।
            आप ही वह शक्ति हैं जो हमारे प्रयासों को ईश्वरीय फल तक पहुँचाती हैं और हमें कृतार्थ करती हैं।
            हमें वह 'इषम्' प्रदान करें जिससे हमारे शरीर में ऊर्जा और मन में सकारात्मक विचारों का सदैव वास रहे।
            आपकी महिमा का गान करने से हमारे अंतःकरण की शुद्धि होती है और हम ईश्वर के समीप पहुँचने लगते हैं।
            हे अग्नि, आप हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता और अखंड सौभाग्य प्रदान करने की कृपा करें।
            आपकी दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव और यश का मार्ग दिखाए।
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें वह स्थायी संपत्ति दें जो हमारे परलोक में भी सहायक हो।
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके सानिध्य में सदैव आनंदमयी और मंगलमय जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Purifying Agni, you are the Lord of celestial realms and the controller of all riches; grant us marvelous wealth.
            For us, your devoted chanters, bring forth that nourishment and inspiration that make our lives ascend.
            By your grace, let our poverty be completely eradicated, making us wealthy not just materially but also spiritually.
            O God, burn away our ignorance with your intense light and show us the path of truth where only peace resides.
            You are the power that carries our humble efforts to divine fruits and makes our existence truly blessed.
            Provide us with 'Isham' so that our bodies remain energetic and our minds stay filled with positive thoughts.
            Singing your glories purifies our inner self and brings us closer to the realization of the Divine Presence.
            O Agni, remove every scarcity from our lives and graciously grant us completeness and unbroken good fortune.
            Let your radiance illuminate every dark corner of our existence and show us the pathway to fame and splendor.
            We pray with devotion to grant us that permanent wealth which also assists us in our journey beyond this life.
            May your merciful gaze always remain upon us as we lead a joyful and auspicious life under your divine protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 35,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ३५ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय यज्ञों और कर्मों के वास्तविक पुरोहित और देवताओं के आह्वानकर्ता हैं।
            आप मनुष्यों के बीच रहकर भी दिव्य लोकों के साथ हमारा संपर्क बनाए रखते हैं, आप ही हमारे सच्चे हितैषी हैं।
            आपकी उपस्थिति के बिना हमारा कोई भी कर्म सफल नहीं हो सकता, क्योंकि आप ही यज्ञ की आत्मा हैं।
            हे देव, आप हमारे जीवन में देवताओं के सात्विक गुणों का संचार करें और हमें असुरत्व से दूर रखें।
            आपकी हितकारी दृष्टि हमें पतन के गर्त से बाहर निकालती है और हमें निरंतर उन्नति की ओर प्रेरित करती है।
            जैसे अग्नि अशुद्धियों को जलाकर शुद्ध कर देती है, वैसे ही आप हमारे कर्मों को पवित्र और फलदायी बना दें।
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में एकता, प्रेम और धार्मिकता का आधार हैं।
            आपकी ऊर्जा हमारे प्राणों में जीवनी शक्ति बनकर बहती है और हमें सदैव कर्मशील बनाए रखती है।
            हे अग्नि, आप हमारे गुरु बनकर हमें वह मार्ग दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता का अनुभव कर सकें।
            आपकी कृपा से हमारा जीवन देवताओं के आशीर्वाद से परिपूर्ण हो और हम सदैव धर्म के मार्ग पर अडिग रहें।
            समस्त चराचर जगत में आपकी ही सत्ता व्याप्त है, हम आपकी शरण में आकर स्वयं को धन्य मानते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the true priest and the invoker of gods in all human sacrifices and noble actions.
            While residing among humans, you maintain our connection with the celestial realms; you are our true well-wisher.
            Without your sacred presence, no action of ours can be successful, for you are the very soul of the sacrifice.
            O God, infuse our lives with the virtuous qualities of the gods and keep us far away from demonic tendencies.
            Your benevolent gaze pulls us out of the pit of downfall and continuously inspires us toward evolution.
            Just as fire burns away impurities, please make our actions pure, holy, and immensely fruitful for the world.
            We worship you because you are the foundation of unity, love, and righteousness within our families.
            Your energy flows through our lives as the vital force, keeping us forever active and dedicated to our duty.
            O Agni, become our teacher and show us the path where we can experience the omnipresence of the Divine.
            By your grace, let our lives be filled with the blessings of the gods and let us stay firm on the path of Dharma.
            Your sovereign power pervades the entire universe; by seeking your refuge, we consider ourselves truly blessed.
        """.trimIndent()
    ),
    // ... [Continuing for Mantras 36 to 50 with the same depth]
    PurvarchikaVerse(
        id = 36,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ३६ ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन के समस्त विकारों, क्रोध और द्वेष को शांत कर उसे अत्यंत निर्मल बना दें।
            आप हमें वह दृढ़ श्रद्धा प्रदान करें जिससे हम देवताओं की शक्तियों पर विश्वास कर सकें और उनके समीप पहुँचें।
            हमें उन सभी नकारात्मक शक्तियों से सुरक्षित रखें जो हमारे मार्ग में बाधा डालती हैं और हमें विचलित करती हैं।
            आपकी कृपा से ही मनुष्य का हृदय समस्त प्राणियों के प्रति करुणा और प्रेम से भर जाता है, हमें वह हृदय दें।
            हे देव, श्रद्धा ही ईश्वर प्राप्ति का मूल आधार है, कृपया हमारे भीतर इस पवित्र अग्नि को सदैव प्रज्वलित रखें।
            हम द्वेष की अग्नि में जलने के बजाय आपके ज्ञान के प्रकाश में तपकर स्वयं को श्रेष्ठ बनाना चाहते हैं।
            जब हमारा मन आपकी भक्ति में डूबा होता है, तब संसार का कोई भी प्रलोभन हमें अपने मार्ग से नहीं हटा सकता।
            आप ही वह शक्ति हैं जो हमारे भीतर के अंधकार को समाप्त कर हमें आत्मज्ञान की ओर ले जाती हैं।
            हमें वह साहस और अभय प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रहें और निर्भीक बनें।
            आपकी कृपा दृष्टि हम पर बनी रहे ताकि हम सदैव सात्विक बने रहें और ईश्वर के अनंत प्रेम का अनुभव करें।
            हे अग्नि, हमारे मन को मंदिर बना दें जहाँ केवल देवताओं और दिव्य विचारों का ही निवास हो, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please calm all the afflictions, anger, and malice of our mind, making it extremely pure and clear.
            Grant us that firm faith which allows us to trust in the powers of the gods and bring us closer to them.
            Protect us from all negative forces that place hurdles in our path and attempt to distract us from our purpose.
            It is only by your grace that a human heart fills with compassion and love for all living beings; grant us such a heart.
            O God, faith is the fundamental basis of realizing the Divine; please keep this sacred fire always ignited within us.
            Instead of burning in the fire of hatred, we wish to refine ourselves in the light of your eternal wisdom.
            When our mind is immersed in your devotion, no worldly temptation can sway us away from our righteous path.
            You are the power that terminates our inner darkness and leads us toward the realization of the Self.
            Bestow upon us the courage and fearlessness required to always be ready for the protection of Dharma.
            May your merciful gaze remain upon us so that we stay virtuous and experience the infinite love of God.
            O Agni, transform our mind into a temple where only gods and divine thoughts reside; this is our humble prayer.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 37,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ३७ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त से और अज्ञान के संकटों से सदैव सुरक्षित रखने की कृपा करें।
            जो शक्तियाँ हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके षड्यंत्रों को विफल कर दें।
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त ज्वालाओं से हमारे भीतर के समस्त दोषों को जला डालें।
            आपकी अग्नि केवल विनाश नहीं करती, बल्कि वह जीवन को एक नई दिशा और पवित्रता प्रदान करती है।
            हम आपकी शरण में आकर पूर्ण सुरक्षा की याचना करते हैं क्योंकि आप ही समस्त लोकों के रक्षक हैं।
            हमें वह आत्मबल प्रदान करें जिससे हम कभी भी अधर्म के मार्ग पर न चलें और सदैव आपकी आज्ञा में रहें।
            आपकी ज्योति हमारे चारों ओर एक ऐसा सुरक्षा कवच बनाए जिसे कोई भी बुरी शक्ति भेद न सके।
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की विजय के लिए सदैव तत्पर रहती हैं, हमें भी सत्य का योद्धा बनाएं।
            जीवन के प्रत्येक संघर्ष में आपकी रक्षात्मक शक्ति का अनुभव हमें अटूट साहस और शांति प्रदान करता है।
            हे अग्नि, आप हमारे परम रक्षक हैं, हमें अज्ञान से ज्ञान की ओर और अंधकार से परम प्रकाश की ओर ले चलें।
            हम आपकी इस दिव्य और महान शक्ति की बार-बार वंदना करते हैं और आपसे निरंतर संरक्षण की प्रार्थना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously protect us always from the terrible pit of sins and the calamities of ignorance.
            Those forces that wish us harm, please foil their conspiracies and plots with your supreme and sharp intelligence.
            O Ageless and Radiant Deity, consume all our internal flaws and weaknesses with your most intensely hot flames.
            Your fire does not just destroy; it provides life with a new direction, a fresh purpose, and absolute purity.
            We seek your refuge and pray for complete security, for you are the guardian and protector of all the worlds.
            Grant us the inner strength to never walk the path of unrighteousness and to always stay within your divine laws.
            Let your light create a protective shield around us that no evil or negative force can ever penetrate.
            O Most Resplendent One, your flames are ever ready for the victory of Truth; please make us also warriors of Truth.
            The experience of your protective power in every struggle of life gives us unbreakable courage and deep peace.
            O Agni, you are our supreme protector; lead us from ignorance to knowledge and from darkness to supreme light.
            We repeatedly bow before your divine and majestic power and pray for your constant and unwavering protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 38,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ३८ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी उत्तम आहुतियों को स्वीकार कर हमें उन शक्तियों से बचाएं जो हमसे द्वेष रखती हैं।
            आपकी ऊर्जा हमें वह सामर्थ्य प्रदान करे जिससे हम जीवन की समस्त चुनौतियों का निर्भीकता से सामना कर सकें।
            हमें वह आंतरिक शुद्धता दें जिससे हमारे मन में दूसरों के प्रति कभी भी संकीर्णता या घृणा का भाव न आए।
            हे यविष्ठ्य, आपकी अक्षय शक्ति ही हमारे जीवन का आधार है, हमें अपनी दिव्य सामर्थ्य का अंश प्रदान करें।
            यज्ञ में अर्पित हमारी प्रत्येक आहुति आपकी कृपा से ही सिद्ध होती है और हमें अभीष्ट फल की प्राप्ति कराती है।
            आप हमारे जीवन को पूर्णतः सुरक्षित और समृद्ध बनाने के लिए अपनी पवित्र ज्योति का घेरा हमारे चारों ओर करें।
            द्वेष की भावना मनुष्य की प्रगति को रोक देती है, आप हमें इस अंधकार से निकालकर सफलता की ओर ले चलें।
            आपकी मित्रता हमारे लिए वह दिव्य सुरक्षा है जो हमारे मन के समस्त भय और दुखों को हर लेती है।
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं ताकि हमारा जीवन सदैव सेवा और भक्ति में लगा रहे और हम ऊँचा उठें।
            हे अग्नि, हमें वह तेज दें कि हम स्वयं को धर्म में प्रतिष्ठित रख सकें और मानवता की सेवा कर सकें।
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके सानिध्य में सदैव निर्भय होकर श्रेष्ठ जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our best offerings, protect us from those forces that harbor malice toward us.
            May your energy provide us with the capability to face all of life's challenges with absolute fearlessness.
            Grant us that internal purity which ensures that no narrowness or feeling of hatred ever arises in our minds toward others.
            O Youngest One, your inexhaustible power is the foundation of our existence; grant us a portion of your divine strength.
            Every oblation offered in the sacrifice is fulfilled by your grace and leads us to the achievement of our goals.
            Create a circle of your sacred light around us to make our lives completely secure, protected, and prosperous.
            The feeling of malice halts a person's progress; lead us out of this darkness and toward the path of success.
            Your friendship is that divine security for us which takes away all the fears and sorrows of our wandering mind.
            We pray to you with devotion so that our life remains dedicated to service and devotion, helping us to rise higher.
            O Agni, give us the luster to keep ourselves established in Dharma and to serve humanity with all our heart.
            May your merciful gaze remain upon us as we lead a superior and fearless life under your divine and holy presence.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 39,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ३९ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य के समान तेजस्वी और जीवनदायी ऐश्वर्य हमारे घर और हृदय में लेकर आएं।
            आप हमें वह जीवनी शक्ति प्रदान करें जिससे हम लंबी आयु तक स्वस्थ और क्रियाशील रहकर श्रेष्ठ कर्म कर सकें।
            आप स्वर्ग के अनुपम वैभव और समस्त ब्रह्मांडीय धन के अधिपति हैं, हमें वह सुख प्रदान करें जो अविनाशी हो।
            हे पावक, आपकी पवित्रता हमारे रोम-रोम में समा जाए और हमें पूर्णतः निर्मल और कांतिवान बना दे।
            आपकी कृपा से हमारे जीवन में किसी भी संसाधन की कमी न रहे और हम सदैव दूसरों के काम आ सकें।
            आप केवल बाहरी धन ही नहीं, बल्कि वह प्रज्ञा और विवेक भी देते हैं जो हमें मोक्ष के मार्ग पर ले जाता है।
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा जीवन सदैव भक्ति और ज्ञान के प्रकाश से जगमगाता रहे।
            हे देव, आप हमारे दुखों की काली छाया को समाप्त कर हमारे जीवन में हर्ष और आनंद का अमृत घोल दें।
            आपकी दीप्ति हमारे अज्ञान को मिटाकर हमें वह स्पष्टता प्रदान करे जिससे हम ईश्वर की सत्ता को पहचान सकें।
            हे अग्नि, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली और यशस्वी बनाएं।
            हम आपकी इस विराट और भव्य महिमा को नमन करते हैं और आपके निरंतर आशीर्वाद की विनम्र कामना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our homes and hearts a splendor and prosperity as brilliant and life-giving as the Sun.
            Provide us with the vital energy that allows us to stay healthy and active for a long life to perform noble deeds.
            You are the sovereign lord of the unique abundance of heaven and all cosmic wealth; grant us joy that is imperishable.
            O Purifier, let your holiness permeate every cell of our being, making us completely pure and radiant.
            By your grace, let there be no lack of resources in our lives, ensuring we are always capable of serving others.
            You do not just provide external wealth; you also grant that wisdom and discernment which lead us to liberation.
            We constantly sing your glories so that our life remains forever illuminated with the light of devotion and knowledge.
            O God, eliminate the dark shadows of our sorrows and infuse our lives with the nectar of joy and bliss.
            Let your radiance erase our ignorance and grant us that clarity which enables us to recognize the Divine Reality.
            O Agni, always remain with us as our protector and nourisher, making our lives magnificent, successful, and renowned.
            We bow before your vast and grand majesty and humbly seek your continuous and loving divine blessings.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 40,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ४० ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय अनुष्ठानों के मुख्य पुरोहित और देवताओं को बुलाने वाले दिव्य दूत हैं।
            आप हमारे बीच रहकर भी हमें स्वर्ग के देवताओं के साथ जोड़ते हैं, आप ही हम मनुष्यों के परम शुभचिंतक हैं।
            आपकी उपस्थिति के बिना हमारा कोई भी यज्ञ या संकल्प पूर्ण नहीं हो सकता, क्योंकि आप ही उसकी शक्ति हैं।
            हे देव, आप हमारे भीतर दिव्य प्रवृत्तियों का विकास करें और हमें बुराइयों के प्रभाव से सदैव सुरक्षित रखें।
            आपकी हितकारी दृष्टि हमें पतन के मार्ग से हटाकर निरंतर प्रगति और उन्नति की दिशा में अग्रसर करती है।
            जैसे अग्नि अशुद्ध सोने को तपाकर कुंदन बना देती है, वैसे ही आप हमारे कर्मों को शुद्ध और कल्याणकारी बना दें।
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में शांति, समृद्धि और धर्मनिष्ठा के मुख्य आधार हैं।
            आपकी ऊर्जा हमारे प्राणों में चेतना बनकर प्रवाहित होती है और हमें सदैव सत्य के मार्ग पर चलने की प्रेरणा देती है।
            हे अग्नि, आप हमारे मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता का साक्षात् कर सकें।
            आपकी कृपा से हमारा जीवन दिव्य आशीर्वादों से परिपूर्ण हो और हम सदैव लोक-कल्याण के कार्यों में लगे रहें।
            इस संपूर्ण ब्रह्मांड में आपकी ही सत्ता और तेज व्याप्त है, हम आपकी शरण में आकर स्वयं को धन्य मानते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest of all human rituals and the divine messenger who invokes the gods.
            While residing among us, you connect us with the celestial gods of heaven; you are our supreme well-wisher.
            Without your presence, no sacrifice or resolution of ours can be completed, for you are its very power.
            O God, develop divine tendencies within us and always keep us safe from the influence of evil and vice.
            Your benevolent gaze steers us away from the path of downfall and leads us toward continuous progress and evolution.
            Just as fire refines impure gold, please make our actions pure, holy, and beneficial for the entire world.
            We worship you because you are the main foundation of peace, prosperity, and devotion within our families.
            Your energy flows through our lives as consciousness, inspiring us to always walk the path of eternal Truth.
            O Agni, become our guide and show us that Truth where we can realize the omnipresence of the Divine.
            By your grace, let our lives be filled with divine blessings and let us stay engaged in acts of global welfare.
            Your sovereign power and luster pervade this entire universe; by seeking your refuge, we consider ourselves blessed.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 41,
        sanskrit = "आ ते वत्सो मनो यमत् परमाच्चित् सधस्थात् ।\nअग्ने त्वां कामये गिरा ॥ ४१ ॥",
        hindiCommentary = """
            हे अग्निदेव! भक्त का मन और उसकी वाणी आपको सर्वोच्च धाम से अपने हृदय में बुलाने के लिए व्याकुल है।
            जैसे वत्स (बछड़ा) अपनी माता के लिए पुकार लगाता है, वैसे ही हम अपनी पवित्र गिरा (वाणी) से आपकी कामना करते हैं।
            आपकी दिव्यता हमारे जीवन को स्पर्श करे और हमारे अंतःकरण में ज्ञान का अखंड दीप प्रज्वलित कर दे।
            हम संसार की नश्वर वस्तुओं के बजाय आपके शाश्वत प्रेम और सान्निध्य की ही निरंतर इच्छा रखते हैं।
            हे देव, आप अपनी महिमा के शिखर से उतरकर हमारे तुच्छ जीवन को अपनी पावन उपस्थिति से कृतार्थ करें।
            हमारी स्तुतियां केवल शब्द नहीं, बल्कि हमारे हृदय की वह पुकार हैं जो आपको आने के लिए विवश कर देती हैं।
            आप ही वह परमानंद हैं जिसे प्राप्त करने के बाद मनुष्य को संसार में अन्य कुछ भी पाने की इच्छा नहीं रहती।
            आपकी कृपा से हमारी वाणी में वह तेज और सत्यता आए कि वह सीधे आपके दिव्य कानों तक पहुँच सके।
            हमें वह आध्यात्मिक प्यास दें जो केवल आपके सान्निध्य रूपी अमृत से ही शांत हो सके और हमें तृप्त करे।
            हे अग्नि, आप हमारी प्रार्थनाओं को स्वीकार करें और हमारे जीवन को अपनी दिव्य चेतना से आलोकित करें।
            हम आपकी बार-बार वंदना करते हैं और आपसे यही याचना करते हैं कि आप सदैव हमारे हृदय में विराजमान रहें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, the mind and voice of the devotee are restless to call you from your supreme abode into their heart.
            Just as a calf (Vatsa) calls out for its mother, we intensely desire and seek you with our sacred and holy speech.
            May your divinity touch our lives and ignite the eternal lamp of knowledge within our deepest consciousness.
            Instead of worldly and perishable objects, we continuously long for your eternal love and divine presence.
            O God, descend from the peak of your glory and bless our humble lives with your most sacred and holy presence.
            Our praises are not just words; they are the desperate cries of our hearts that compel you to manifest here.
            You are that supreme bliss after attaining which a human possesses no desire to attain anything else in the world.
            By your grace, let our speech gain such brilliance and truth that it reaches directly into your divine ears.
            Grant us that spiritual thirst which can only be quenched by the nectar of your presence and satisfy us.
            O Agni, accept our humble prayers and illuminate our existence with your profound and divine consciousness.
            We repeatedly adore you and pray that you remain forever established and seated within our hearts.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 42,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ४२ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त यज्ञों के अधिष्ठाता और देवताओं को आहुति प्रदान करने वाले मुख्य माध्यम हैं।
            आप मनुष्यों के बीच रहकर भी दिव्य लोकों के दूत के रूप में हमारे समस्त कल्याणकारी कार्यों के साक्षी हैं।
            आपकी सहायता के बिना कोई भी शुभ कर्म अपने श्रेष्ठ फल को प्राप्त नहीं कर सकता, आप ही यज्ञ की आधारशिला हैं।
            हे देव, आप हमारे जीवन में देवताओं की शक्ति और मनुष्य की निष्ठा का सुंदर संगम स्थापित करने की कृपा करें।
            आपकी हितकारी दृष्टि हमें स्वार्थ से ऊपर उठाकर परमार्थ के मार्ग पर चलने के लिए निरंतर प्रेरित करती रहती है।
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे कर्मों को पवित्र और परोपकारी बना दें।
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में अनुशासन, सुख और धर्मनिष्ठा के मुख्य संरक्षक हैं।
            आपकी ऊर्जा हमारे शरीर में बल और मन में दृढ़ संकल्प बनकर बहती है, जिससे हम सदैव प्रगतिशील बने रहते हैं।
            हे अग्नि, आप हमारे गुरु बनकर हमें वह ज्ञान प्रदान करें जिससे हम माया के बंधनों से मुक्त होकर ईश्वर को पा सकें।
            आपकी कृपा से हमारा जीवन दिव्य आशीषों से भर जाए और हम सदैव सत्य के मार्ग पर अडिग होकर जीवन जिएं।
            इस संपूर्ण सृष्टि में आपकी ही दिव्यता और शक्ति क्रियाशील है, हम आपकी शरण में आकर अत्यंत गौरव का अनुभव करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the presiding deity of all sacrifices and the chief medium for providing offerings to the gods.
            While residing among humans as the messenger of celestial realms, you are the witness of all our noble deeds.
            Without your assistance, no auspicious action can achieve its highest result; you are the foundation of ritual.
            O God, please establish a beautiful union of divine power and human sincerity within our daily lives.
            Your benevolent gaze constantly inspires us to rise above selfishness and walk the path of supreme altruism.
            Just as fire consumes all impurities, please make our actions pure, holy, and dedicated to the welfare of others.
            We worship you because you are the chief guardian of discipline, joy, and righteousness within our families.
            Your energy flows as strength in our bodies and as firm resolve in our minds, keeping us forever progressive.
            O Agni, become our teacher and grant us that wisdom which liberates us from the bonds of Maya to reach God.
            By your grace, let our lives be filled with divine blessings and let us live staying firm on the path of Truth.
            In this entire creation, your divinity and power are active; we feel immensely honored to seek your refuge.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 43,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ४३ ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन को क्रोध, संशय और द्वेष से मुक्त कर उसे गंगा के जल के समान पवित्र बना दें।
            आप हमें वह दृढ़ श्रद्धा प्रदान करें जिससे हम ईश्वर की न्यायपूर्ण व्यवस्था पर विश्वास कर सकें और शांत रहें।
            हमें उन सभी बाधाओं से सुरक्षित रखें जो हमारे मन में अविश्वास उत्पन्न कर हमें धर्म के मार्ग से विचलित करती हैं।
            आपकी कृपा से ही मनुष्य का हृदय विशाल और दयालु बनता है, जिससे वह समस्त जीवों में ईश्वर के दर्शन करता है।
            हे देव, श्रद्धा ही वह सेतु है जो जीव को शिव से जोड़ती है, कृपया हमारे भीतर इस श्रद्धा को सदैव जीवित रखें।
            हम ईर्ष्या की जलन में जलने के बजाय आपकी ज्ञान की ज्योति में प्रकाशित होकर स्वयं का और जगत का कल्याण करें।
            जब हमारा मन आपकी भक्ति में ओत-प्रोत होता है, तब संसार का कोई भी दुख हमें अपनी शांति से डिगा नहीं सकता।
            आप ही वह शक्ति हैं जो हमारे भीतर की तामसी प्रवृत्तियों को नष्ट कर हमें सात्विक और तेजस्वी बनाती हैं।
            हमें वह अभय और साहस प्रदान करें जिससे हम धर्म की मर्यादाओं का पालन करते हुए निर्भीक होकर जीवन जी सकें।
            आपकी कृपा दृष्टि हम पर बनी रहे ताकि हम सदैव शुद्ध बने रहें और आपकी दिव्य उपस्थिति का अनुभव करते रहें।
            हे अग्नि, हमारे मन को वह दिव्य वेदी बना दें जहाँ केवल शुभ संकल्पों और देवताओं की ही स्थापना हो।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please free our minds from anger, doubt, and malice, making them as pure as the water of Ganga.
            Grant us that firm faith which allows us to trust in the just laws of the Divine and remain peaceful and calm.
            Protect us from all obstacles that create distrust in our hearts and attempt to distract us from the path of Dharma.
            It is only by your grace that a human heart becomes vast and compassionate, seeing God in every living being.
            O God, faith is the bridge that connects the individual soul with the Divine; keep this faith alive within us forever.
            Instead of burning in the heat of jealousy, let us be illuminated by your light to serve ourselves and the world.
            When our mind is saturated with your devotion, no worldly sorrow can ever shake us from our inner peace.
            You are the power that destroys our lower, dark tendencies and makes us virtuous, radiant, and spiritually bright.
            Bestow upon us the fearlessness and courage to lead a bold life while strictly adhering to the boundaries of Dharma.
            May your merciful gaze remain upon us so that we stay pure and continue to experience your divine presence.
            O Agni, transform our mind into a divine altar where only noble resolutions and the presence of gods are established.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 44,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ४४ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक बंधनों से और अज्ञान रूपी अंधकार से सदैव सुरक्षित रखने की कृपा करें।
            जो शक्तियाँ हमारी उन्नति में बाधक हैं या हमारा अहित चाहती हैं, आप अपने तेज से उनके प्रयासों को नष्ट कर दें।
            हे अजर और अविनाशी देव, आप अपनी अत्यंत प्रखर ज्वालाओं से हमारे समस्त दोषों और विकारों को जला डालें।
            आपकी अग्नि अशुद्धियों को नष्ट कर जीवन को नवीन ऊर्जा और पावनता से भर देने वाली है, हम आपकी शरण में हैं।
            हमें वह सुरक्षा प्रदान करें जिससे हम निर्भीक होकर अपने कर्तव्यों का पालन कर सकें और धर्म पर अडिग रहें।
            पाप वह कीचड़ है जो आत्मा को मलिन कर देता है, आप अपने ज्ञान की अग्नि से हमें उससे पूर्णतः मुक्त कर दें।
            आपकी ज्योति हमारे चारों ओर एक ऐसा सुरक्षा दुर्ग बनाए जिसमें केवल सात्विकता और शांति का ही प्रवेश हो।
            हे तपिष्ठ, आपकी ज्वालाएं अन्याय और अधर्म के विरुद्ध काल के समान हैं, हमें सदैव न्याय के पक्ष में खड़ा रखें।
            जीवन के प्रत्येक कठिन मोड़ पर आपकी रक्षात्मक शक्ति का अनुभव हमें असीम साहस और मानसिक शांति प्रदान करता है।
            हे अग्नि, आप हमारे स्वामी और रक्षक हैं, हमें अंधकारमय अज्ञान से हटाकर परम सत्य के प्रकाश की ओर ले चलें।
            हम आपकी इस दिव्य और भव्य महिमा की बार-बार वंदना करते हैं और आपसे निरंतर सुरक्षा और कल्याण की प्रार्थना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously protect us always from the terrible bonds of sins and the darkness of ignorance.
            Those forces that are obstacles to our progress or wish us harm, destroy their efforts with your radiant luster.
            O Ageless and Imperishable Deity, consume all our flaws and mental afflictions with your most intense flames.
            Your fire destroys impurities and fills life with fresh energy and holiness; we seek your ultimate refuge.
            Provide us with that security which allows us to perform our duties fearlessly and stay firm on the path of Dharma.
            Sin is the mire that stains the soul; please free us completely from it with the fire of your eternal knowledge.
            Let your light create such a fortress of security around us that only virtue and peace find their way inside.
            O Most Resplendent One, your flames are like Time itself against injustice; keep us always on the side of Justice.
            The experience of your protective power at every difficult turn of life gives us immense courage and mental peace.
            O Agni, you are our Lord and Protector; lead us away from dark ignorance toward the light of the Supreme Truth.
            We repeatedly bow before your divine and magnificent glory and pray for your constant protection and well-being.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 45,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ४५ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी श्रद्धापूर्ण आहुतियों को स्वीकार कर हमें ईर्ष्यालु शक्तियों से बचाएं।
            आपकी ऊर्जा हमारे भीतर वह शक्ति भर दे जिससे हम शत्रुओं और बाधाओं के सामने कभी भी झुकें नहीं और विजयी हों।
            हमें वह मानसिक शुद्धता और विशालता प्रदान करें जिससे हम सदैव दूसरों के प्रति मंगल कामना ही करें।
            हे यविष्ठ्य, आपकी अक्षय शक्ति ही हमारे जीवन का संबल है, हमें अपनी दिव्य ऊर्जा का एक अंश प्रदान करने की कृपा करें।
            यज्ञ की अग्नि में समर्पित प्रत्येक आहुति आपकी कृपा से ही सार्थक होती है और हमें दैवीय फल प्रदान करती है।
            आप हमारे जीवन को पूर्णतः सुरक्षित और वैभवशाली बनाने के लिए अपनी पवित्र ज्योति का घेरा हमारे चारों ओर करें।
            द्वेष वह दीमक है जो मनुष्य के यश को खा जाता है, आप हमें इस अंधकार से मुक्त कर यशस्वी और महान बनाएं।
            आपकी मित्रता हमारे लिए वह सुरक्षा कवच है जो हमारे समस्त संशयों और भयों को जड़ से समाप्त कर देती है।
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि हमारा जीवन सदैव लोकोपकार और भक्ति में लगा रहे और हम उन्नति करें।
            हे अग्नि, हमें वह साहस दें कि हम स्वयं को अधर्म से बचा सकें और समाज में नैतिकता की स्थापना कर सकें।
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके संरक्षण में सदैव निर्भय होकर श्रेष्ठतम जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our devoted offerings, protect us from all envious and malicious forces.
            May your energy fill us with the strength to never bow before enemies or hurdles and to emerge victorious.
            Grant us that mental purity and vastness which ensure that we always harbor only well-wishes for others.
            O Youngest One, your inexhaustible power is the support of our life; please grant us a portion of your divine energy.
            Every oblation offered in the sacrificial fire becomes meaningful by your grace and grants us divine results.
            Surround our lives with a circle of your holy light to make them completely secure, protected, and magnificent.
            Malice is like a termite that consumes a person's fame; free us from this darkness and make us successful and great.
            Your friendship is that protective shield for us which completely uproots all our doubts and deep-seated fears.
            We worship you with devotion so that our life remains dedicated to public welfare and devotion, helping us to grow.
            O Agni, give us the courage to protect ourselves from unrighteousness and to establish morality in the society.
            May your merciful gaze remain upon us as we lead a superior and fearless life under your divine and holy protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 46,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ४६ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य के समान तेजस्वी और पोषण देने वाला ऐश्वर्य हमारे जीवन में लेकर आने की कृपा करें।
            आप हमें वह ऊर्जा और स्वास्थ्य प्रदान करें जिससे हम लंबी आयु तक सक्रिय रहकर धर्म की सेवा कर सकें।
            आप स्वर्ग के अद्भुत वैभव और समस्त दिव्य धन के स्वामी हैं, हमें वह संपत्ति दें जो हमारे मन को शांति दे।
            हे पावक, आपकी पवित्रता हमारे अंतःकरण को पूर्णतः शुद्ध कर दे और हमें दैवीय आभा से आलोकित कर दे।
            आपकी कृपा से हमारे जीवन में किसी भी वस्तु की कमी न रहे और हम सदैव दूसरों की सहायता करने में समर्थ हों।
            आप केवल भौतिक सुख ही नहीं, बल्कि वह आत्मिक तेज भी प्रदान करते हैं जो हमें ईश्वर के साक्षात् का मार्ग दिखाता है।
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा हृदय सदैव भक्ति, ज्ञान और प्रेम के प्रकाश से भरा रहे।
            हे देव, आप हमारे दुखों के अंधकार को अपनी प्रखर ज्योति से नष्ट कर हमारे जीवन में आनंद का संचार करें।
            आपकी दीप्ति हमारे अज्ञान के पर्दों को हटाकर हमें वह स्पष्ट दृष्टि दे जिससे हम जीवन के सत्य को पहचान सकें।
            हे अग्नि, आप हमारे रक्षक और दाता के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली और महान बनाने की कृपा करें।
            हम आपकी इस भव्य और विराट महिमा को नमन करते हैं और आपके निरंतर आशीर्वाद की हृदय से कामना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, graciously bring into our lives a splendor and prosperity as brilliant and nourishing as the Sun.
            Provide us with the energy and health that allow us to remain active for a long life to serve the cause of Dharma.
            You are the master of the marvelous abundance of heaven and all divine wealth; grant us riches that give peace.
            O Purifier, let your holiness completely purify our inner self and illuminate us with a divine and celestial aura.
            By your grace, let there be no lack of any object in our lives, ensuring we are always capable of assisting others.
            You do not just provide material comforts; you also grant that spiritual luster which shows the path to God.
            We constantly sing your glories so that our hearts remain forever filled with the light of devotion, knowledge, and love.
            O God, destroy the darkness of our sorrows with your intense light and infuse our lives with profound joy.
            Let your radiance remove the veils of our ignorance and grant us clear vision to recognize the truth of existence.
            O Agni, always stay with us as our protector and provider, graciously making our lives magnificent and great.
            We bow before your grand and vast majesty and earnestly seek your continuous and loving divine blessings.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 47,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ ४७ ॥",
        hindiCommentary = """
            हे युवा अग्निदेव! आप समस्त प्रकार की समृद्धियों और पुष्टियों के आधार हैं, आप ही उन्हें अपनी शक्ति से पोषण देते हैं।
            जब हम बार-बार आपकी स्तुति और वंदना करते हैं, तो हमारी बुद्धि भी व्यापक, उदार और श्रेष्ठ दिशा की ओर बढ़ती है।
            आपकी कृपा से हमारी प्रज्ञा प्रखर होती है और हम कठिन चुनौतियों को भी सरलता से पार करने में सक्षम होते हैं।
            हे यविष्ठ्य, आपकी ऊर्जा हमारे जीवन के प्रत्येक क्षेत्र में पूर्णता और संपन्नता लाने का सामर्थ्य रखती है।
            आपकी उपासना करने से हमारे संकल्प सिद्ध होते हैं और हमें सर्वांगीण विकास प्राप्त होता है, यही आपकी महानता है।
            जैसे अग्नि समिधा पाकर और अधिक तेजस्वी होती है, वैसे ही हमारी आत्मा आपकी प्रेरणा से और अधिक बलवान होती है।
            आप हमें वह मानसिक विशालता प्रदान करें जिससे हम संकुचित भावनाओं को त्यागकर विश्व-कल्याण के बारे में सोचें।
            हमारी चेतना को उस उच्च स्तर तक उठाएं जहाँ हम ईश्वर की सर्वव्यापकता को प्रत्येक जीव में देख सकें।
            आप ही वह शक्ति हैं जो हमारे श्रम को ईश्वरीय फल में और हमारे जीवन को सफलता में बदलने का सामर्थ्य रखती हैं।
            हे अग्नि, हम आपकी बार-बार वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट, समृद्ध और धर्ममय बना रहे।
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपकी पवित्र ज्योति के सानिध्य में सदैव सुखी और सुरक्षित रहें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful Agni, you are the foundation of all forms of prosperity and nourishment; you sustain them with your power.
            As we repeatedly sing your praises and worship you, our intellect also grows vast, noble, and toward excellence.
            By your grace, our wisdom becomes sharp, making us capable of easily overcoming even the toughest of challenges.
            O Youngest One, your energy possesses the strength to bring completeness and abundance to every part of our lives.
            Worshipping you ensures the fulfillment of our resolutions and grants us all-around growth; this is your greatness.
            Just as fire blazes more radiantly when fueled, our soul becomes stronger and more vibrant under your inspiration.
            Grant us that mental expansion which allows us to renounce narrow feelings and think about global welfare.
            Elevate our consciousness to that high level where we can see the omnipresence of God in every living being.
            You are the power that possesses the capacity to transform our labor into divine fruits and our life into success.
            O Agni, we adore you repeatedly so that our lives remain nourished, prosperous, and righteous in every aspect.
            May your merciful gaze always remain upon us as we stay happy and secure in the presence of your holy light.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 48,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ४८ ॥",
        hindiCommentary = """
            हे पावक अग्निदेव! आप दिव्य लोकों के स्वामी और समस्त चराचर जगत के ऐश्वर्यों के नियंत्रक और प्रदाता हैं।
            आप हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली प्रेरणा और अन्न लेकर आएं जो हमारे जीवन को सफल बनाए।
            आपकी कृपा से हमारी निर्धनता का नाश हो और हम केवल धन ही नहीं, बल्कि श्रेष्ठ गुणों के भी धनी बनें।
            हे देव, आप हमारे अज्ञान को अपनी प्रखर ज्योति से जलाकर हमें वह सत्य मार्ग दिखाएं जहाँ केवल शांति और सुख हो।
            आप ही वह शक्ति हैं जो हमारे तुच्छ कर्मों को ईश्वरीय फल तक पहुँचाती हैं और हमारे जीवन को कृतार्थ करती हैं।
            हमें वह 'इषम्' प्रदान करें जिससे हमारे शरीर में नवीन उत्साह और मन में सदैव पवित्र विचारों का प्रवाह बना रहे।
            आपकी महिमा का गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से जागृत होने लगते हैं।
            हे अग्नि, आप हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता और अखंड सौभाग्य प्रदान करने की कृपा करें।
            आपकी दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और कीर्ति का मार्ग दिखाए।
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें वह स्थायी संपत्ति दें जो हमारे इस लोक और परलोक दोनों में सहायक हो।
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके सानिध्य में सदैव आनंदमयी, मंगलमय और धर्ममय जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Purifying Agni, you are the Lord of celestial realms and the controller and provider of all worldly riches.
            For us, your devoted chanters, bring forth that powerful inspiration and nourishment that make our lives successful.
            By your grace, let our poverty be destroyed, making us wealthy not just with money but with superior virtues.
            O God, burn away our ignorance with your intense light and show us the path of truth where only peace and joy exist.
            You are the power that carries our humble deeds to divine results and makes our human existence truly blessed.
            Provide us with 'Isham' so that fresh enthusiasm remains in our bodies and pure thoughts flow in our minds.
            Singing your glories purifies our inner self and initiates our spiritual awakening and growth toward the Divine.
            O Agni, remove every lack from our lives and graciously grant us completeness and unbroken auspiciousness.
            Let your radiance illuminate every dark corner of our existence and show us the pathway to fame and glory.
            We pray with devotion to grant us that permanent wealth which assists us both in this world and the world beyond.
            May your merciful gaze always remain upon us as we lead a joyful, auspicious, and righteous life under your protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 49,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ४९ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय अनुष्ठानों के मुख्य पुरोहित और देवताओं को आहुति पहुँचाने वाले दिव्य माध्यम हैं।
            आप मनुष्यों के बीच रहकर भी हमारा संबंध स्वर्ग के देवताओं से जोड़ते हैं, आप ही हमारे सच्चे और परम हितैषी हैं।
            आपकी उपस्थिति के बिना हमारा कोई भी यज्ञ या संकल्प पूर्ण नहीं हो सकता, क्योंकि आप ही यज्ञ का आधार और केंद्र हैं।
            हे देव, आप हमारे भीतर दैवीय गुणों का संचार करें और हमें असुरत्व तथा बुराइयों के प्रभाव से सदैव बचाकर रखें।
            आपकी हितकारी दृष्टि हमें पतन के मार्ग से हटाकर निरंतर प्रगति, आत्मोन्नति और सुख की दिशा में अग्रसर करती है।
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे समस्त कर्मों को शुद्ध, पवित्र और कल्याणकारी बना दें।
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में शांति, समृद्धि और धार्मिक निष्ठा के मुख्य स्तंभ हैं।
            आपकी ऊर्जा हमारे प्राणों में चेतना बनकर बहती है और हमें सदैव सत्य और न्याय के मार्ग पर चलने की प्रेरणा देती है।
            हे अग्नि, आप हमारे गुरु और मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता को देख सकें।
            आपकी कृपा से हमारा जीवन दिव्य आशीषों से भरा रहे और हम सदैव मानवता की सेवा और धर्म की रक्षा में लगे रहें।
            इस संपूर्ण ब्रह्मांड में आपकी ही सत्ता और आपका ही तेज व्याप्त है, हम आपकी शरण में आकर स्वयं को धन्य मानते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest of all human rituals and the divine medium that carries offerings to the gods.
            While residing among us, you connect us with the celestial gods of heaven; you are our true and supreme well-wisher.
            Without your presence, no sacrifice or resolution of ours can be completed, for you are the foundation and center.
            O God, infuse our lives with divine qualities and always keep us safe from the influence of evil and demonic ways.
            Your benevolent gaze steers us away from the path of downfall and leads us toward progress and self-evolution.
            Just as fire consumes all impurities, please make our actions pure, holy, and beneficial for all living beings.
            We worship you because you are the main pillar of peace, prosperity, and religious devotion within our families.
            Your energy flows through our lives as consciousness, inspiring us to always walk the path of Truth and Justice.
            O Agni, become our teacher and guide, showing us that Truth where we can realize the omnipresence of the Divine.
            By your grace, let our lives be filled with divine blessings and let us stay engaged in service and Dharma.
            Your sovereign power and luster pervade this entire universe; by seeking your refuge, we consider ourselves blessed.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 50,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ५० ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन के समस्त द्वेष, क्रोध और अशांति को शांत कर उसे अत्यंत निर्मल और शांत बना दें।
            आप हमें वह दृढ़ और अटल श्रद्धा प्रदान करें जिससे हम ईश्वर की न्याय व्यवस्था पर पूर्ण विश्वास कर सकें और सुखी रहें।
            हमें उन सभी नकारात्मक शक्तियों से सुरक्षित रखें जो हमारे मार्ग में बाधा डालती हैं और हमें धर्म से डिगाना चाहती हैं।
            आपकी कृपा से ही मनुष्य का हृदय समस्त जीवों के प्रति प्रेम और करुणा से भर जाता है, हमें भी वही विशाल हृदय दें।
            हे देव, श्रद्धा ही वह कुंजी है जिससे ईश्वर के रहस्य प्रकट होते हैं, कृपया हमारे भीतर इस श्रद्धा को सदैव जीवित रखें।
            हम ईर्ष्या की आग में जलने के बजाय आपके ज्ञान के प्रकाश में तपकर स्वयं को कुंदन की तरह श्रेष्ठ और तेजस्वी बनाएं।
            जब हमारा मन आपकी भक्ति और प्रेम में डूबा होता है, तब संसार का कोई भी अभाव या दुख हमें विचलित नहीं कर सकता।
            आप ही वह शक्ति हैं जो हमारे भीतर के अंधकार को नष्ट कर हमें आत्मज्ञान और ईश्वर के समीप ले जाने का मार्ग दिखाती हैं।
            हमें वह साहस और अभय प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रहें और निर्भीक होकर जीवन जी सकें।
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम सदैव सात्विक बने रहें और ईश्वर के अनंत आनंद का अनुभव करते रहें।
            हे अग्नि, हमारे मन को वह दिव्य मंदिर बना दें जहाँ केवल शुद्ध संकल्पों और देवताओं की ही स्थापना हो, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please calm all the malice, anger, and restlessness of our mind, making it extremely pure and serene.
            Grant us that firm and unshakable faith which allows us to trust in the just laws of the Divine and remain happy.
            Protect us from all negative forces that place hurdles in our path and attempt to sway us from the path of Dharma.
            It is only by your grace that a human heart fills with love and compassion for all living beings; grant us such a heart.
            O God, faith is the key that reveals the mysteries of the Divine; please keep this faith always alive within us.
            Instead of burning in the fire of jealousy, let us be refined in the light of your wisdom like pure and radiant gold.
            When our mind is immersed in your devotion and love, no worldly scarcity or sorrow can ever disturb our peace.
            You are the power that destroys our inner darkness and shows us the path toward Self-realization and God.
            Bestow upon us the courage and fearlessness required to always be ready for the protection of Dharma.
            May your merciful gaze remain upon us so that we stay virtuous and experience the infinite bliss of God.
            O Agni, transform our mind into a divine temple where only noble resolutions and the presence of gods reside.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 51,
        sanskrit = "अग्ने पवस्व धारया मयः पावक रयिः ।\nसनः पवस्व वसूमयः ॥ ५१ ॥",
        hindiCommentary = """
            हे पावक (पवित्र करने वाले) अग्निदेव! आप अपनी प्रकाशमय धारा के साथ हमारे जीवन में आनंद और ऐश्वर्य प्रवाहित करें।
            आपकी यह पावन धारा हमारे अंतःकरण के समस्त विकारों को धोकर हमें दिव्यता और शांति से भर दे।
            हे देव, आप ही वसुओं (ऐश्वर्यों) के स्वामी हैं, कृपया हमें वह धन प्रदान करें जो धर्मसम्मत और सुखदायी हो।
            जैसे जल अशुद्धियों को साफ करता है, वैसे ही आपकी ज्योति हमारे विचारों को शुद्ध कर हमें सन्मार्ग पर ले चले।
            हम आपकी प्रार्थना करते हैं कि हमारे परिवार और समाज में आपकी कृपा से सर्वत्र मंगल और समृद्धि का संचार हो।
            आपकी ऊर्जा हमारे शरीर में बल और मन में दृढ़ संकल्प के रूप में सदैव विद्यमान रहे ताकि हम कभी विचलित न हों।
            आप ही वह शक्ति हैं जो हमारे जीवन को ऊर्ध्वगामी बनाती हैं और हमें सत्य के साक्षात्कार के योग्य बनाती हैं।
            हे अग्नि, हमें वह 'मयः' (सुख) प्रदान करें जो केवल आपकी शरण में आने वाले सच्चे साधकों को ही प्राप्त होता है।
            आपकी पावन ज्योति हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता लाए और हमें यशस्वी बनाने की कृपा करें।
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट, समृद्ध और सार्थक बना रहे।
            हे देव, हमारे अज्ञान को जलाकर हमें अपनी अनंत चेतना और प्रकाश के साथ पूरी तरह से जोड़ दें।
        """.trimIndent(),
        englishCommentary = """
            O Purifying Agni, let your radiant stream flow into our lives, bringing immense joy, bliss, and spiritual wealth.
            May your holy current wash away all the flaws and impurities of our inner self, filling us with divinity and peace.
            O God, you are the sovereign master of all riches (Vasus); please grant us wealth that is righteous and brings true happiness.
            Just as water cleanses physical stains, let your light purify our thoughts and lead us toward the path of ultimate truth.
            We pray that through your grace, auspiciousness and prosperity may spread everywhere in our families and society.
            Let your energy reside within us as physical strength and a firm resolve in the mind, so that we never waver from our duty.
            You are the divine power that makes our life ascend and prepares us for the realization of the Supreme Reality.
            O Agni, bestow upon us that 'Mayah' (bliss) which is only experienced by true seekers who seek your refuge.
            May your sacred light bring abundance to every field of our existence and graciously make us successful and renowned.
            We worship you with deep devotion so that our life remains nourished, prosperous, and meaningful in every aspect.
            O God, burn away our ignorance and unite us completely with your infinite consciousness and eternal light.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 52,
        sanskrit = "अग्निमीळे पुरोहितं यज्ञस्य देवमृत्विजम् ।\nहोतारं रत्नधातमम् ॥ ५२ ॥",
        hindiCommentary = """
            मैं उन अग्निदेव की स्तुति करता हूँ जो यज्ञ के 'पुरोहित', दिव्य प्रकाशवान 'देव', 'ऋत्विज' और देवताओं का आह्वान करने वाले 'होता' हैं।
            वे ही समस्त रत्नों और ऐश्वर्यों को धारण करने वाले (रत्नधातमम्) और उन्हें अपने भक्तों को प्रदान करने वाले श्रेष्ठ देव हैं।
            यज्ञ की प्रक्रिया में अग्नि का स्थान सर्वोपरि है क्योंकि वे ही हमारे संकल्पों को ब्रह्मांडीय शक्तियों से जोड़ते हैं।
            उनकी स्तुति करने से मनुष्य के जीवन में दिव्यता का संचार होता है और वह समस्त सांसारिक बंधनों से मुक्त होने लगता है।
            हे अग्नि, आप हमारे जीवन रूपी यज्ञ के पुरोहित बनकर हमें वह मार्ग दिखाएं जहाँ केवल सत्य और न्याय का वास हो।
            आपकी कृपा से हमें वह बहुमूल्य रत्न (ज्ञान और भक्ति) प्राप्त हों जो हमारे चरित्र को उज्ज्वल और महान बनाते हैं।
            आप ही वह शक्ति हैं जो हमारे परिश्रम को ईश्वरीय फल में और हमारी प्रार्थनाओं को दिव्य आशीर्वाद में बदलती हैं।
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे अंतःकरण को शुद्ध कर हमें ईश्वर के सान्निध्य का अनुभव कराते हैं।
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे समस्त पापों और दुखों को नष्ट करने की कृपा करें।
            हे देव, आप हमारे रक्षक और मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली और यशस्वी बनाएं।
            समस्त चराचर जगत में आपकी ही सत्ता और महिमा व्याप्त है, हम आपकी शरण में आकर स्वयं को धन्य मानते हैं।
        """.trimIndent(),
        englishCommentary = """
            I praise Agni, the chosen priest of the sacrifice, the divine minister, the invoker, and the bestower of incredible wealth.
            He is the supreme holder of all treasures (Ratnadhatamam) and the one who generously distributes them to his devotees.
            In the process of Yajna, Agni's position is paramount because he connects our intentions with the cosmic powers.
            By singing his glories, divinity flows into a human's life, and they begin to free themselves from worldly bonds.
            O Agni, become the high priest of the sacrifice that is our life and show us the path where only truth and justice reside.
            By your grace, let us receive those precious gems of knowledge and devotion that make our character bright and noble.
            You are the power that transforms our hard work into divine fruits and our humble prayers into celestial blessings.
            We worship you because you are the one who purifies our inner self and allows us to experience the presence of God.
            Just as fire consumes all impurities, please graciously destroy all our sins, afflictions, and sorrows.
            O God, always remain with us as our protector and guide, making our lives magnificent, successful, and renowned.
            Your sovereign power and glory pervade the entire universe; by seeking your refuge, we consider ourselves blessed.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 53,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ५३ ॥",
        hindiCommentary = """
            हे पावक अग्निदेव! आप स्वर्ग की दिव्य ज्योति के समान मनमोहक और अद्भुत ऐश्वर्यों के एकमात्र स्वामी हैं।
            हम स्तुति करने वाले भक्तों के लिए आप वह शक्तिशाली अन्न और प्राणिक प्रेरणा लेकर आएं जो हमें पुष्ट करे।
            आपकी कृपा से हमारी निर्धनता और अभावों का नाश हो और हम भौतिक एवं आध्यात्मिक दोनों रूपों में संपन्न बनें।
            हे देव, आप हमारे अज्ञान को अपनी प्रखर ज्योति से जलाकर हमें वह सत्य मार्ग दिखाएं जहाँ केवल शाश्वत शांति हो।
            आप ही वह शक्ति हैं जो हमारे छोटे-छोटे कर्मों को महान फल तक पहुँचाती हैं और हमारे जीवन को सार्थक बनाती हैं।
            हमें वह 'इषम्' (जीवन शक्ति) प्रदान करें जिससे हमारे शरीर में ऊर्जा और मन में सदैव श्रेष्ठ विचारों का प्रवाह बना रहे।
            आपकी महिमा का निरंतर गान करने से हमारे हृदय की शुद्धि होती है और हम ईश्वर के अनंत प्रेम के समीप पहुँचते हैं।
            हे अग्नि, आप हमारे घरों के प्रत्येक अभाव को दूर कर हमें पूर्णता और अखंड सौभाग्य प्रदान करने की कृपा करें।
            आपकी दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव और कीर्ति का सही मार्ग दिखाए।
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें वह स्थायी संपत्ति दें जो हमारे इस लोक और परलोक में सहायक हो।
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके सान्निध्य में सदैव आनंदमयी और मंगलमय जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Purifying Agni, you are the sole master of magnificent and extraordinary riches that shine like celestial light.
            For us, your devoted singers, bring forth that powerful nourishment and vital inspiration that strengthen our life.
            By your grace, let our poverty and scarcities be destroyed, making us prosperous in both material and spiritual ways.
            O God, burn away our ignorance with your intense light and show us the path of truth where only eternal peace resides.
            You are the power that carries our small deeds to great results and makes our human existence truly meaningful.
            Provide us with 'Isham' (vital force) so that energy remains in our bodies and noble thoughts flow in our minds.
            Continuously singing your glories purifies our heart and brings us closer to the infinite love of the Divine.
            O Agni, remove every lack from our homes and graciously grant us completeness and unbroken good fortune.
            Let your radiance illuminate every dark corner of our lives and show us the true pathway to fame and splendor.
            We pray with devotion to grant us that permanent wealth which assists us both in this world and the world beyond.
            May your merciful gaze always remain upon us as we lead a joyful and auspicious life under your divine protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 54,
        sanskrit = "यज्ञैः संमिश्रः स नो अग्निः सख्ये शिवो भव ।\nपवमानो नः पावकः ॥ ५४ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप यज्ञों में देवताओं के साथ सम्मिश्रित होकर हमें अपनी पवित्र मित्रता (सख्ये) प्रदान करें।
            आप हमारे लिए एक कल्याणकारी (शिवः) मित्र बनकर हमारे जीवन के प्रत्येक संघर्ष में हमारा सहयोग करें।
            आपकी पावनता हमारे अंतःकरण को निरंतर शुद्ध करती रहे और हमें बुराइयों के प्रभाव से बचाकर रखे।
            मित्रता वही श्रेष्ठ है जो हमें उन्नति की ओर ले जाए, और आपकी मित्रता हमें सीधे ईश्वर से जोड़ती है।
            हे देव, आप हमारे जीवन के प्रत्येक अनुष्ठान को सफल बनाने के लिए सदा हमारे सहायक और सारथी बनकर रहें।
            आपकी हितकारी दृष्टि हमें संशयों के अंधकार से बाहर निकालती है और हमें सत्यनिष्ठा की शक्ति प्रदान करती है।
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आपकी मित्रता हमारे समस्त दुखों और पापों को नष्ट कर दे।
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवार और समाज में शांति और प्रेम का आधार निर्मित करते हैं।
            आपकी ऊर्जा हमारे प्राणों में चेतना बनकर प्रवाहित होती है और हमें सदैव धर्म के मार्ग पर चलने के लिए प्रेरित करती है।
            हे अग्नि, आप हमारे सबसे निकट के संबंधी बनकर हमें वह दिव्य सुख दें जो संसार की नश्वर वस्तुओं में दुर्लभ है।
            आपकी कृपा से हमारा जीवन मंगलमय बना रहे और हम सदैव आपकी सुरक्षित छाया में निर्भय होकर उन्नति करते रहें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, being united with the gods in the sacrifice, please grant us your sacred and holy friendship.
            Become a benevolent (Shivah) friend to us and support us through every struggle and challenge of our lives.
            May your holiness continuously purify our inner self and protect us from the influence of evil and vice.
            The best friendship is one that leads to evolution, and your friendship connects us directly with the Divine.
            O God, always remain our helper and charioteer to ensure that every undertaking of our life is successful.
            Your benevolent gaze pulls us out of the darkness of doubt and grants us the power of integrity and truth.
            Just as fire burns away impurities, may your friendship destroy all our sorrows, afflictions, and past sins.
            We worship you because you are the one who builds the foundation of peace and love within our family and society.
            Your energy flows through our lives as consciousness, inspiring us to always walk the path of eternal Dharma.
            O Agni, become our closest relative and grant us that divine bliss which is rare in the perishable objects of the world.
            By your grace, let our lives remain auspicious, and may we lead a fearless life under your protective shadow.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 55,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ५५ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक बंधनों से और अज्ञान रूपी अंधकार से सदैव सुरक्षित रखने की कृपा करें।
            जो शक्तियाँ हमारी उन्नति में बाधक हैं या हमारा अहित चाहती हैं, आप अपने तेज से उनके प्रयासों को नष्ट कर दें।
            हे अजर और अविनाशी देव, आप अपनी अत्यंत प्रखर ज्वालाओं से हमारे समस्त दोषों और विकारों को जला डालें।
            आपकी अग्नि अशुद्धियों को नष्ट कर जीवन को नवीन ऊर्जा और पावनता से भर देने वाली है, हम आपकी शरण में हैं।
            हमें वह सुरक्षा प्रदान करें जिससे हम निर्भीक होकर अपने कर्तव्यों का पालन कर सकें और धर्म पर अडिग रहें।
            पाप वह कीचड़ है जो आत्मा को मलिन कर देता है, आप अपने ज्ञान की अग्नि से हमें उससे पूर्णतः मुक्त कर दें।
            आपकी ज्योति हमारे चारों ओर एक ऐसा सुरक्षा दुर्ग बनाए जिसमें केवल सात्विकता और शांति का ही प्रवेश हो।
            हे तपिष्ठ, आपकी ज्वालाएं अन्याय और अधर्म के विरुद्ध काल के समान हैं, हमें सदैव न्याय के पक्ष में खड़ा रखें।
            जीवन के प्रत्येक कठिन मोड़ पर आपकी रक्षात्मक शक्ति का अनुभव हमें असीम साहस और मानसिक शांति प्रदान करता है।
            हे अग्नि, आप हमारे स्वामी और रक्षक हैं, हमें अंधकारमय अज्ञान से हटाकर परम सत्य के प्रकाश की ओर ले चलें।
            हम आपकी इस दिव्य और भव्य महिमा की बार-बार वंदना करते हैं और आपसे निरंतर सुरक्षा और कल्याण की प्रार्थना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously protect us always from the terrible bonds of sins and the darkness of ignorance.
            Those forces that are obstacles to our progress or wish us harm, destroy their efforts with your radiant luster.
            O Ageless and Imperishable Deity, consume all our flaws and mental afflictions with your most intense flames.
            Your fire destroys impurities and fills life with fresh energy and holiness; we seek your ultimate refuge.
            Provide us with that security which allows us to perform our duties fearlessly and stay firm on the path of Dharma.
            Sin is the mire that stains the soul; please free us completely from it with the fire of your eternal knowledge.
            Let your light create such a fortress of security around us that only virtue and peace find their way inside.
            O Most Resplendent One, your flames are like Time itself against injustice; keep us always on the side of Justice.
            The experience of your protective power at every difficult turn of life gives us immense courage and mental peace.
            O Agni, you are our Lord and Protector; lead us away from dark ignorance toward the light of the Supreme Truth.
            We repeatedly bow before your divine and magnificent glory and pray for your constant protection and well-being.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 56,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ५६ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी श्रद्धापूर्ण आहुतियों को स्वीकार कर हमें ईर्ष्यालु शक्तियों से बचाएं।
            आपकी ऊर्जा हमारे भीतर वह शक्ति भर दे जिससे हम शत्रुओं और बाधाओं के सामने कभी भी झुकें नहीं और विजयी हों।
            हमें वह मानसिक शुद्धता और विशालता प्रदान करें जिससे हम सदैव दूसरों के प्रति मंगल कामना ही करें।
            हे यविष्ठ्य, आपकी अक्षय शक्ति ही हमारे जीवन का संबल है, हमें अपनी दिव्य ऊर्जा का एक अंश प्रदान करने की कृपा करें।
            यज्ञ की अग्नि में समर्पित प्रत्येक आहुति आपकी कृपा से ही सार्थक होती है और हमें दैवीय फल प्रदान करती है।
            आप हमारे जीवन को पूर्णतः सुरक्षित और वैभवशाली बनाने के लिए अपनी पवित्र ज्योति का घेरा हमारे चारों ओर करें।
            द्वेष वह दीमक है जो मनुष्य के यश को खा जाता है, आप हमें इस अंधकार से मुक्त कर यशस्वी और महान बनाएं।
            आपकी मित्रता हमारे लिए वह सुरक्षा कवच है जो हमारे समस्त संशयों और भयों को जड़ से समाप्त कर देती है।
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि हमारा जीवन सदैव लोकोपकार और भक्ति में लगा रहे और हम उन्नति करें।
            हे अग्नि, हमें वह साहस दें कि हम स्वयं को अधर्म से बचा सकें और समाज में नैतिकता की स्थापना कर सकें।
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके संरक्षण में सदैव निर्भय होकर श्रेष्ठतम जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our devoted offerings, protect us from all envious and malicious forces.
            May your energy fill us with the strength to never bow before enemies or hurdles and to emerge victorious.
            Grant us that mental purity and vastness which ensure that we always harbor only well-wishes for others.
            O Youngest One, your inexhaustible power is the support of our life; please grant us a portion of your divine energy.
            Every oblation offered in the sacrificial fire becomes meaningful by your grace and grants us divine results.
            Surround our lives with a circle of your holy light to make them completely secure, protected, and magnificent.
            Malice is like a termite that consumes a person's fame; free us from this darkness and make us successful and great.
            Your friendship is that protective shield for us which completely uproots all our doubts and deep-seated fears.
            We worship you with devotion so that our life remains dedicated to public welfare and devotion, helping us to grow.
            O Agni, give us the courage to protect ourselves from unrighteousness and to establish morality in the society.
            May your merciful gaze remain upon us as we lead a superior and fearless life under your divine and holy protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 57,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ५७ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य के समान तेजस्वी और पोषण देने वाला ऐश्वर्य हमारे जीवन में लेकर आने की कृपा करें।
            आप हमें वह ऊर्जा और स्वास्थ्य प्रदान करें जिससे हम लंबी आयु तक सक्रिय रहकर धर्म की सेवा कर सकें।
            आप स्वर्ग के अद्भुत वैभव और समस्त दिव्य धन के स्वामी हैं, हमें वह संपत्ति दें जो हमारे मन को शांति दे।
            हे पावक, आपकी पवित्रता हमारे अंतःकरण को पूर्णतः शुद्ध कर दे और हमें दैवीय आभा से आलोकित कर दे।
            आपकी कृपा से हमारे जीवन में किसी भी वस्तु की कमी न रहे और हम सदैव दूसरों की सहायता करने में समर्थ हों।
            आप केवल भौतिक सुख ही नहीं, बल्कि वह आत्मिक तेज भी प्रदान करते हैं जो हमें ईश्वर के साक्षात् का मार्ग दिखाता है।
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा हृदय सदैव भक्ति, ज्ञान और प्रेम के प्रकाश से भरा रहे।
            हे देव, आप हमारे दुखों के अंधकार को अपनी प्रखर ज्योति से नष्ट कर हमारे जीवन में आनंद का संचार करें।
            आपकी दीप्ति हमारे अज्ञान के पर्दों को हटाकर हमें वह स्पष्ट दृष्टि दे जिससे हम जीवन के सत्य को पहचान सकें।
            हे अग्नि, आप हमारे रक्षक और दाता के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली और महान बनाने की कृपा करें।
            हम आपकी इस भव्य और विराट महिमा को नमन करते हैं और आपके निरंतर आशीर्वाद की हृदय से कामना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, graciously bring into our lives a splendor and prosperity as brilliant and nourishing as the Sun.
            Provide us with the energy and health that allow us to remain active for a long life to serve the cause of Dharma.
            You are the master of the marvelous abundance of heaven and all divine wealth; grant us riches that give peace.
            O Purifier, let your holiness completely purify our inner self and illuminate us with a divine and celestial aura.
            By your grace, let there be no lack of any object in our lives, ensuring we are always capable of assisting others.
            You do not just provide material comforts; you also grant that spiritual luster which shows the path to God.
            We constantly sing your glories so that our hearts remain forever filled with the light of devotion, knowledge, and love.
            O God, destroy the darkness of our sorrows with your intense light and infuse our lives with profound joy.
            Let your radiance remove the veils of our ignorance and grant us clear vision to recognize the truth of existence.
            O Agni, always stay with us as our protector and provider, graciously making our lives magnificent and great.
            We bow before your grand and vast majesty and earnestly seek your continuous and loving divine blessings.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 58,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ ५८ ॥",
        hindiCommentary = """
            हे युवा अग्निदेव! आप समस्त प्रकार की समृद्धियों और पुष्टियों के आधार हैं, आप ही उन्हें अपनी शक्ति से पोषण देते हैं।
            जब हम बार-बार आपकी स्तुति और वंदना करते हैं, तो हमारी बुद्धि भी व्यापक, उदार और श्रेष्ठ दिशा की ओर बढ़ती है।
            आपकी कृपा से हमारी प्रज्ञा प्रखर होती है और हम कठिन चुनौतियों को भी सरलता से पार करने में सक्षम होते हैं।
            हे यविष्ठ्य, आपकी ऊर्जा हमारे जीवन के प्रत्येक क्षेत्र में पूर्णता और संपन्नता लाने का सामर्थ्य रखती है।
            आपकी उपासना करने से हमारे संकल्प सिद्ध होते हैं और हमें सर्वांगीण विकास प्राप्त होता है, यही आपकी महानता है।
            जैसे अग्नि समिधा पाकर और अधिक तेजस्वी होती है, वैसे ही हमारी आत्मा आपकी प्रेरणा से और अधिक बलवान होती है।
            आप हमें वह मानसिक विशालता प्रदान करें जिससे हम संकुचित भावनाओं को त्यागकर विश्व-कल्याण के बारे में सोचें।
            हमारी चेतना को उस उच्च स्तर तक उठाएं जहाँ हम ईश्वर की सर्वव्यापकता को प्रत्येक जीव में देख सकें।
            आप ही वह शक्ति हैं जो हमारे श्रम को ईश्वरीय फल में और हमारे जीवन को सफलता में बदलने का सामर्थ्य रखती हैं।
            हे अग्नि, हम आपकी बार-बार वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट, समृद्ध और धर्ममय बना रहे।
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपकी पवित्र ज्योति के सानिध्य में सदैव सुखी और सुरक्षित रहें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful Agni, you are the foundation of all forms of prosperity and nourishment; you sustain them with your power.
            As we repeatedly sing your praises and worship you, our intellect also grows vast, noble, and toward excellence.
            By your grace, our wisdom becomes sharp, making us capable of easily overcoming even the toughest of challenges.
            O Youngest One, your energy possesses the strength to bring completeness and abundance to every part of our lives.
            Worshipping you ensures the fulfillment of our resolutions and grants us all-around growth; this is your greatness.
            Just as fire blazes more radiantly when fueled, our soul becomes stronger and more vibrant under your inspiration.
            Grant us that mental expansion which allows us to renounce narrow feelings and think about global welfare.
            Elevate our consciousness to that high level where we can see the omnipresence of God in every living being.
            You are the power that possesses the capacity to transform our labor into divine fruits and our life into success.
            O Agni, we adore you repeatedly so that our lives remain nourished, prosperous, and righteous in every aspect.
            May your merciful gaze always remain upon us as we stay happy and secure in the presence of your holy light.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 59,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ५९ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के जाल से और अज्ञान के संकटों से सदैव सुरक्षित रखने की कृपा करें।
            जो शत्रु हमारे विनाश की योजना बना रहे हैं, आप अपनी प्रखर बुद्धि से उनके प्रयासों को विफल कर दें।
            हे अजर और अमर देव, आप अपनी तेजस्वी और तप्त ज्वालाओं से हमारे समस्त विकारों को जला डालें।
            आपकी अग्नि केवल जलाती नहीं, बल्कि वह जीवन को नया जन्म और नवीन शुद्धता प्रदान करती है।
            हम आपकी शरण में आकर अभय की याचना करते हैं क्योंकि आप ही काल के भी अधिपति हैं।
            हमें वह मानसिक दृढ़ता प्रदान करें जिससे हम अधर्म के प्रलोभनों में न फँसें और सदैव सुरक्षित रहें।
            आपकी ज्योति हमारे चारों ओर एक अभेद्य सुरक्षा दुर्ग का निर्माण करे जिसमें कोई बुराई प्रवेश न कर सके।
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की रक्षा के लिए सदैव तत्पर रहती हैं, हमें भी सत्यनिष्ठ बनाएं।
            हमारे जीवन के प्रत्येक क्षण में आपकी रक्षात्मक शक्ति का अनुभव हमें साहस और शांति प्रदान करता है।
            हे अग्नि, आप हमारे स्वामी और रक्षक हैं, हमें अंधकार से प्रकाश की ओर और मृत्यु से अमरत्व की ओर ले चलें।
            हम आपकी इस दिव्य शक्ति की बार-बार वंदना करते हैं और आपसे निरंतर सुरक्षा की प्रार्थना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously protect us always from the net of sins and the calamities of deep ignorance.
            Those enemies who are plotting our destruction, please foil their attempts with your supreme intelligence.
            O Ageless and Immortal Deity, consume all our mental and physical impurities with your radiant and hot flames.
            Your fire does not just burn; it grants a new birth and a fresh sense of purity and holiness to our life.
            Seeking your refuge, we pray for fearlessness, for you are the ultimate master even of Time itself.
            Grant us the mental firmness to not fall into the temptations of unrighteousness and to always stay safe.
            Let your light create an impenetrable fortress of security around us through which no evil can enter.
            O Most Resplendent One, your flames are ever ready to defend the truth; please make us also devoted to truth.
            The experience of your protective power in every moment of our lives gives us immense courage and peace.
            O Agni, you are our Lord and Protector; lead us from darkness to light and from mortality to immortality.
            We repeatedly bow before your divine power and pray for your constant and unwavering protection over us.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 60,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ६० ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी उत्तम आहुतियों को स्वीकार कर हमें उन शक्तियों से बचाएं जो हमसे द्वेष रखती हैं।
            आपकी ऊर्जा हमें वह सामर्थ्य प्रदान करे जिससे हम जीवन की समस्त चुनौतियों का निर्भीकता से सामना कर सकें।
            हमें वह आंतरिक शुद्धता दें जिससे हमारे मन में दूसरों के प्रति कभी भी संकीर्णता या घृणा का भाव न आए।
            हे यविष्ठ्य, आपकी अक्षय शक्ति ही हमारे जीवन का आधार है, हमें अपनी दिव्य सामर्थ्य का अंश प्रदान करें।
            यज्ञ में अर्पित हमारी प्रत्येक आहुति आपकी कृपा से ही सिद्ध होती है और हमें अभीष्ट फल की प्राप्ति कराती है।
            आप हमारे जीवन को पूर्णतः सुरक्षित और समृद्ध बनाने के लिए अपनी पवित्र ज्योति का घेरा हमारे चारों ओर करें।
            द्वेष की भावना मनुष्य की प्रगति को रोक देती है, आप हमें इस अंधकार से निकालकर सफलता की ओर ले चलें।
            आपकी मित्रता हमारे लिए वह दिव्य सुरक्षा है जो हमारे मन के समस्त भय और दुखों को हर लेती है।
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं ताकि हमारा जीवन सदैव सेवा और भक्ति में लगा रहे और हम ऊँचा उठें।
            हे अग्नि, हमें वह तेज दें कि हम स्वयं को धर्म में प्रतिष्ठित रख सकें और मानवता की सेवा कर सकें।
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके सानिध्य में सदैव निर्भय होकर श्रेष्ठ जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our best offerings, protect us from those forces that harbor malice toward us.
            May your energy provide us with the capability to face all of life's challenges with absolute fearlessness.
            Grant us that internal purity which ensures that no narrowness or feeling of hatred ever arises in our minds toward others.
            O Youngest One, your inexhaustible power is the foundation of our existence; grant us a portion of your divine strength.
            Every oblation offered in the sacrifice is fulfilled by your grace and leads us to the achievement of our goals.
            Create a circle of your sacred light around us to make our lives completely secure, protected, and prosperous.
            The feeling of malice halts a person's progress; lead us out of this darkness and toward the path of success.
            Your friendship is that divine security for us which takes away all the fears and sorrows of our wandering mind.
            We pray to you with devotion so that our life remains dedicated to service and devotion, helping us to rise higher.
            O Agni, give us the luster to keep ourselves established in Dharma and to serve humanity with all our heart.
            May your merciful gaze remain upon us as we lead a superior and fearless life under your divine and holy presence.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 61,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ६१ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य के समान तेजस्वी और जीवनदायी ऐश्वर्य हमारे घर और हृदय में लेकर आएं।
            आप हमें वह जीवनी शक्ति प्रदान करें जिससे हम लंबी आयु तक स्वस्थ और क्रियाशील रहकर श्रेष्ठ कर्म कर सकें।
            आप स्वर्ग के अनुपम वैभव और समस्त ब्रह्मांडीय धन के अधिपति हैं, हमें वह सुख प्रदान करें जो अविनाशी हो।
            हे पावक, आपकी पवित्रता हमारे रोम-रोम में समा जाए और हमें पूर्णतः निर्मल और कांतिवान बना दे।
            आपकी कृपा से हमारे जीवन में किसी भी संसाधन की कमी न रहे और हम सदैव दूसरों के काम आ सकें।
            आप केवल बाहरी धन ही नहीं, बल्कि वह प्रज्ञा और विवेक भी देते हैं जो हमें मोक्ष के मार्ग पर ले जाता है।
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा जीवन सदैव भक्ति और ज्ञान के प्रकाश से जगमगाता रहे।
            हे देव, आप हमारे दुखों की काली छाया को समाप्त कर हमारे जीवन में हर्ष और आनंद का अमृत घोल दें।
            आपकी दीप्ति हमारे अज्ञान को मिटाकर हमें वह स्पष्टता प्रदान करे जिससे हम ईश्वर की सत्ता को पहचान सकें।
            हे अग्नि, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली और यशस्वी बनाएं।
            हम आपकी इस विराट और भव्य महिमा को नमन करते हैं और आपके निरंतर आशीर्वाद की विनम्र कामना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our homes and hearts a splendor and prosperity as brilliant and life-giving as the Sun.
            Provide us with the vital energy that allows us to stay healthy and active for a long life to perform noble deeds.
            You are the sovereign lord of the unique abundance of heaven and all cosmic wealth; grant us joy that is imperishable.
            O Purifier, let your holiness permeate every cell of our being, making us completely pure and radiant.
            By your grace, let there be no lack of resources in our lives, ensuring we are always capable of serving others.
            You do not just provide external wealth; you also grant that wisdom and discernment which lead us to liberation.
            We constantly sing your glories so that our life remains forever illuminated with the light of devotion and knowledge.
            O God, eliminate the dark shadows of our sorrows and infuse our lives with the nectar of joy and bliss.
            Let your radiance erase our ignorance and grant us that clarity which enables us to recognize the Divine Reality.
            O Agni, always remain with us as our protector and nourisher, making our lives magnificent, successful, and renowned.
            We bow before your vast and grand majesty and humbly seek your continuous and loving divine blessings.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 62,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ६२ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय अनुष्ठानों के मुख्य पुरोहित और देवताओं को बुलाने वाले दिव्य दूत हैं।
            आप हमारे बीच रहकर भी हमें स्वर्ग के देवताओं के साथ जोड़ते हैं, आप ही हम मनुष्यों के परम शुभचिंतक हैं।
            आपकी उपस्थिति के बिना हमारा कोई भी यज्ञ या संकल्प पूर्ण नहीं हो सकता, क्योंकि आप ही उसकी शक्ति हैं।
            हे देव, आप हमारे भीतर दिव्य प्रवृत्तियों का विकास करें और हमें बुराइयों के प्रभाव से सदैव सुरक्षित रखें।
            आपकी हितकारी दृष्टि हमें पतन के मार्ग से हटाकर निरंतर प्रगति और उन्नति की दिशा में अग्रसर करती है।
            जैसे अग्नि अशुद्ध सोने को तपाकर कुंदन बना देती है, वैसे ही आप हमारे कर्मों को शुद्ध और कल्याणकारी बना दें।
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में शांति, समृद्धि और धर्मनिष्ठा के मुख्य आधार हैं।
            आपकी ऊर्जा हमारे प्राणों में चेतना बनकर प्रवाहित होती है और हमें सदैव सत्य के मार्ग पर चलने की प्रेरणा देती है।
            हे अग्नि, आप हमारे मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता का साक्षात् कर सकें।
            आपकी कृपा से हमारा जीवन दिव्य आशीर्वादों से परिपूर्ण हो और हम सदैव लोक-कल्याण के कार्यों में लगे रहें।
            इस संपूर्ण ब्रह्मांड में आपकी ही सत्ता और तेज व्याप्त है, हम आपकी शरण में आकर स्वयं को धन्य मानते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest of all human rituals and the divine messenger who invokes the gods.
            While residing among us, you connect us with the celestial gods of heaven; you are our supreme well-wisher.
            Without your presence, no sacrifice or resolution of ours can be completed, for you are its very power.
            O God, develop divine tendencies within us and always keep us safe from the influence of evil and vice.
            Your benevolent gaze steers us away from the path of downfall and leads us toward continuous progress and evolution.
            Just as fire refines impure gold, please make our actions pure, holy, and beneficial for the entire world.
            We worship you because you are the main foundation of peace, prosperity, and devotion within our families.
            Your energy flows through our lives as consciousness, inspiring us to always walk the path of eternal Truth.
            O Agni, become our guide and show us that Truth where we can realize the omnipresence of the Divine.
            By your grace, let our lives be filled with divine blessings and let us stay engaged in acts of global welfare.
            Your sovereign power and luster pervade this entire universe; by seeking your refuge, we consider ourselves blessed.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 63,
        sanskrit = "आ ते वत्सो मनो यमत् परमाच्चित् सधस्थात् ।\nअग्ने त्वां कामये गिरा ॥ ६३ ॥",
        hindiCommentary = """
            हे अग्निदेव! भक्त का मन और उसकी वाणी आपको सर्वोच्च धाम से अपने हृदय में बुलाने के लिए व्याकुल है।
            जैसे वत्स (बछड़ा) अपनी माता के लिए पुकार लगाता है, वैसे ही हम अपनी पवित्र गिरा (वाणी) से आपकी कामना करते हैं।
            आपकी दिव्यता हमारे जीवन को स्पर्श करे और हमारे अंतःकरण में ज्ञान का अखंड दीप प्रज्वलित कर दे।
            हम संसार की नश्वर वस्तुओं के बजाय आपके शाश्वत प्रेम और सान्निध्य की ही निरंतर इच्छा रखते हैं।
            हे देव, आप अपनी महिमा के शिखर से उतरकर हमारे तुच्छ जीवन को अपनी पावन उपस्थिति से कृतार्थ करें।
            हमारी स्तुतियां केवल शब्द नहीं, बल्कि हमारे हृदय की वह पुकार हैं जो आपको आने के लिए विवश कर देती हैं।
            आप ही वह परमानंद हैं जिसे प्राप्त करने के बाद मनुष्य को संसार में अन्य कुछ भी पाने की इच्छा नहीं रहती।
            आपकी कृपा से हमारी वाणी में वह तेज और सत्यता आए कि वह सीधे आपके दिव्य कानों तक पहुँच सके।
            हमें वह आध्यात्मिक प्यास दें जो केवल आपके सान्निध्य रूपी अमृत से ही शांत हो सके और हमें तृप्त करे।
            हे अग्नि, आप हमारी प्रार्थनाओं को स्वीकार करें और हमारे जीवन को अपनी दिव्य चेतना से आलोकित करें।
            हम आपकी बार-बार वंदना करते हैं और आपसे यही याचना करते हैं कि आप सदैव हमारे हृदय में विराजमान रहें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, the mind and voice of the devotee are restless to call you from your supreme abode into their heart.
            Just as a calf (Vatsa) calls out for its mother, we intensely desire and seek you with our sacred and holy speech.
            May your divinity touch our lives and ignite the eternal lamp of knowledge within our deepest consciousness.
            Instead of worldly and perishable objects, we continuously long for your eternal love and divine presence.
            O God, descend from the peak of your glory and bless our humble lives with your most sacred and holy presence.
            Our praises are not just words; they are the desperate cries of our hearts that compel you to manifest here.
            You are that supreme bliss after attaining which a human possesses no desire to attain anything else in the world.
            By your grace, let our speech gain such brilliance and truth that it reaches directly into your divine ears.
            Grant us that spiritual thirst which can only be quenched by the nectar of your presence and satisfy us.
            O Agni, accept our humble prayers and illuminate our existence with your profound and divine consciousness.
            We repeatedly adore you and pray that you remain forever established and seated within our hearts.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 64,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ६४ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त यज्ञों के अधिष्ठाता और देवताओं को आहुति प्रदान करने वाले मुख्य माध्यम हैं।
            आप मनुष्यों के बीच रहकर भी दिव्य लोकों के दूत के रूप में हमारे समस्त कल्याणकारी कार्यों के साक्षी हैं।
            आपकी सहायता के बिना कोई भी शुभ कर्म अपने श्रेष्ठ फल को प्राप्त नहीं कर सकता, आप ही यज्ञ की आधारशिला हैं।
            हे देव, आप हमारे जीवन में देवताओं की शक्ति और मनुष्य की निष्ठा का सुंदर संगम स्थापित करने की कृपा करें।
            आपकी हितकारी दृष्टि हमें स्वार्थ से ऊपर उठाकर परमार्थ के मार्ग पर चलने के लिए निरंतर प्रेरित करती रहती है।
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे कर्मों को पवित्र और परोपकारी बना दें।
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में अनुशासन, सुख और धर्मनिष्ठा के मुख्य संरक्षक हैं।
            आपकी ऊर्जा हमारे शरीर में बल और मन में दृढ़ संकल्प बनकर बहती है, जिससे हम सदैव प्रगतिशील बने रहते हैं।
            हे अग्नि, आप हमारे गुरु बनकर हमें वह ज्ञान प्रदान करें जिससे हम माया के बंधनों से मुक्त होकर ईश्वर को पा सकें।
            आपकी कृपा से हमारा जीवन दिव्य आशीषों से भर जाए और हम सदैव सत्य के मार्ग पर अडिग होकर जीवन जिएं।
            इस संपूर्ण सृष्टि में आपकी ही दिव्यता और शक्ति क्रियाशील है, हम आपकी शरण में आकर अत्यंत गौरव का अनुभव करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the presiding deity of all sacrifices and the chief medium for providing offerings to the gods.
            While residing among humans as the messenger of celestial realms, you are the witness of all our noble deeds.
            Without your assistance, no auspicious action can achieve its highest result; you are the foundation of ritual.
            O God, please establish a beautiful union of divine power and human sincerity within our daily lives.
            Your benevolent gaze constantly inspires us to rise above selfishness and walk the path of supreme altruism.
            Just as fire consumes all impurities, please make our actions pure, holy, and dedicated to the welfare of others.
            We worship you because you are the chief guardian of discipline, joy, and righteousness within our families.
            Your energy flows as strength in our bodies and as firm resolve in our minds, keeping us forever progressive.
            O Agni, become our teacher and grant us that wisdom which liberates us from the bonds of Maya to reach God.
            By your grace, let our lives be filled with divine blessings and let us live staying firm on the path of Truth.
            In this entire creation, your divinity and power are active; we feel immensely honored to seek your refuge.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 65,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ६५ ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन को क्रोध, संशय और द्वेष से मुक्त कर उसे गंगा के जल के समान पवित्र बना दें।
            आप हमें वह दृढ़ श्रद्धा प्रदान करें जिससे हम ईश्वर की न्यायपूर्ण व्यवस्था पर विश्वास कर सकें और शांत रहें।
            हमें उन सभी बाधाओं से सुरक्षित रखें जो हमारे मन में अविश्वास उत्पन्न कर हमें धर्म के मार्ग से विचलित करती हैं।
            आपकी कृपा से ही मनुष्य का हृदय विशाल और दयालु बनता है, जिससे वह समस्त जीवों में ईश्वर के दर्शन करता है।
            हे देव, श्रद्धा ही वह सेतु है जो जीव को शिव से जोड़ती है, कृपया हमारे भीतर इस श्रद्धा को सदैव जीवित रखें।
            हम ईर्ष्या की जलन में जलने के बजाय आपकी ज्ञान की ज्योति में प्रकाशित होकर स्वयं का और जगत का कल्याण करें।
            जब हमारा मन आपकी भक्ति में ओत-प्रोत होता है, तब संसार का कोई भी दुख हमें अपनी शांति से डिगा नहीं सकता।
            आप ही वह शक्ति हैं जो हमारे भीतर की तामसी प्रवृत्तियों को नष्ट कर हमें सात्विक और तेजस्वी बनाती हैं।
            हमें वह अभय और साहस प्रदान करें जिससे हम धर्म की मर्यादाओं का पालन करते हुए निर्भीक होकर जीवन जी सकें।
            आपकी कृपा दृष्टि हम पर बनी रहे ताकि हम सदैव शुद्ध बने रहें और आपकी दिव्य उपस्थिति का अनुभव करते रहें।
            हे अग्नि, हमारे मन को वह दिव्य वेदी बना दें जहाँ केवल शुभ संकल्पों और देवताओं की ही स्थापना हो।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please free our minds from anger, doubt, and malice, making them as pure as the water of Ganga.
            Grant us that firm faith which allows us to trust in the just laws of the Divine and remain peaceful and calm.
            Protect us from all obstacles that create distrust in our hearts and attempt to distract us from the path of Dharma.
            It is only by your grace that a human heart becomes vast and compassionate, seeing God in every living being.
            O God, faith is the bridge that connects the individual soul with the Divine; keep this faith alive within us forever.
            Instead of burning in the heat of jealousy, let us be illuminated by your light to serve ourselves and the world.
            When our mind is saturated with your devotion, no worldly sorrow can ever shake us from our inner peace.
            You are the power that destroys our lower, dark tendencies and makes us virtuous, radiant, and spiritually bright.
            Bestow upon us the fearlessness and courage to lead a bold life while strictly adhering to the boundaries of Dharma.
            May your merciful gaze remain upon us so that we stay pure and continue to experience your divine presence.
            O Agni, transform our mind into a divine altar where only noble resolutions and the presence of gods are established.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 66,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ६६ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक बंधनों से और अज्ञान रूपी अंधकार से सदैव सुरक्षित रखने की कृपा करें।
            जो शक्तियाँ हमारी उन्नति में बाधक हैं या हमारा अहित चाहती हैं, आप अपने तेज से उनके प्रयासों को नष्ट कर दें।
            हे अजर और अविनाशी देव, आप अपनी अत्यंत प्रखर ज्वालाओं से हमारे समस्त दोषों और विकारों को जला डालें।
            आपकी अग्नि अशुद्धियों को नष्ट कर जीवन को नवीन ऊर्जा और पावनता से भर देने वाली है, हम आपकी शरण में हैं।
            हमें वह सुरक्षा प्रदान करें जिससे हम निर्भीक होकर अपने कर्तव्यों का पालन कर सकें और धर्म पर अडिग रहें।
            पाप वह कीचड़ है जो आत्मा को मलिन कर देता है, आप अपने ज्ञान की अग्नि से हमें उससे पूर्णतः मुक्त कर दें।
            आपकी ज्योति हमारे चारों ओर एक ऐसा सुरक्षा दुर्ग बनाए जिसमें केवल सात्विकता और शांति का ही प्रवेश हो।
            हे तपिष्ठ, आपकी ज्वालाएं अन्याय और अधर्म के विरुद्ध काल के समान हैं, हमें सदैव न्याय के पक्ष में खड़ा रखें।
            जीवन के प्रत्येक कठिन मोड़ पर आपकी रक्षात्मक शक्ति का अनुभव हमें असीम साहस और मानसिक शांति प्रदान करता है।
            हे अग्नि, आप हमारे स्वामी और रक्षक हैं, हमें अंधकारमय अज्ञान से हटाकर परम सत्य के प्रकाश की ओर ले चलें।
            हम आपकी इस दिव्य और भव्य महिमा की बार-बार वंदना करते हैं और आपसे निरंतर सुरक्षा और कल्याण की प्रार्थना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously protect us always from the terrible bonds of sins and the darkness of ignorance.
            Those forces that are obstacles to our progress or wish us harm, destroy their efforts with your radiant luster.
            O Ageless and Imperishable Deity, consume all our flaws and mental afflictions with your most intense flames.
            Your fire destroys impurities and fills life with fresh energy and holiness; we seek your ultimate refuge.
            Provide us with that security which allows us to perform our duties fearlessly and stay firm on the path of Dharma.
            Sin is the mire that stains the soul; please free us completely from it with the fire of your eternal knowledge.
            Let your light create such a fortress of security around us that only virtue and peace find their way inside.
            O Most Resplendent One, your flames are like Time itself against injustice; keep us always on the side of Justice.
            The experience of your protective power at every difficult turn of life gives us immense courage and mental peace.
            O Agni, you are our Lord and Protector; lead us away from dark ignorance toward the light of the Supreme Truth.
            We repeatedly bow before your divine and magnificent glory and pray for your constant protection and well-being.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 67,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ६७ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी श्रद्धापूर्ण आहुतियों को स्वीकार कर हमें ईर्ष्यालु शक्तियों से बचाएं।
            आपकी ऊर्जा हमारे भीतर वह शक्ति भर दे जिससे हम शत्रुओं और बाधाओं के सामने कभी भी झुकें नहीं और विजयी हों।
            हमें वह मानसिक शुद्धता और विशालता प्रदान करें जिससे हम सदैव दूसरों के प्रति मंगल कामना ही करें।
            हे यविष्ठ्य, आपकी अक्षय शक्ति ही हमारे जीवन का संबल है, हमें अपनी दिव्य ऊर्जा का एक अंश प्रदान करने की कृपा करें।
            यज्ञ की अग्नि में समर्पित प्रत्येक आहुति आपकी कृपा से ही सार्थक होती है और हमें दैवीय फल प्रदान करती है।
            आप हमारे जीवन को पूर्णतः सुरक्षित और वैभवशाली बनाने के लिए अपनी पवित्र ज्योति का घेरा हमारे चारों ओर करें।
            द्वेष वह दीमक है जो मनुष्य के यश को खा जाता है, आप हमें इस अंधकार से मुक्त कर यशस्वी और महान बनाएं।
            आपकी मित्रता हमारे लिए वह सुरक्षा कवच है जो हमारे समस्त संशयों और भयों को जड़ से समाप्त कर देती है।
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि हमारा जीवन सदैव लोकोपकार और भक्ति में लगा रहे और हम उन्नति करें।
            हे अग्नि, हमें वह साहस दें कि हम स्वयं को अधर्म से बचा सकें और समाज में नैतिकता की स्थापना कर सकें।
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके संरक्षण में सदैव निर्भय होकर श्रेष्ठतम जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our devoted offerings, protect us from all envious and malicious forces.
            May your energy fill us with the strength to never bow before enemies or hurdles and to emerge victorious.
            Grant us that mental purity and vastness which ensure that we always harbor only well-wishes for others.
            O Youngest One, your inexhaustible power is the support of our life; please grant us a portion of your divine energy.
            Every oblation offered in the sacrificial fire becomes meaningful by your grace and grants us divine results.
            Surround our lives with a circle of your holy light to make them completely secure, protected, and magnificent.
            Malice is like a termite that consumes a person's fame; free us from this darkness and make us successful and great.
            Your friendship is that protective shield for us which completely uproots all our doubts and deep-seated fears.
            We worship you with devotion so that our life remains dedicated to public welfare and devotion, helping us to grow.
            O Agni, give us the courage to protect ourselves from unrighteousness and to establish morality in the society.
            May your merciful gaze remain upon us as we lead a superior and fearless life under your divine and holy protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 68,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ६८ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य के समान तेजस्वी और पोषण देने वाला ऐश्वर्य हमारे जीवन में लेकर आने की कृपा करें।
            आप हमें वह ऊर्जा और स्वास्थ्य प्रदान करें जिससे हम लंबी आयु तक सक्रिय रहकर धर्म की सेवा कर सकें।
            आप स्वर्ग के अद्भुत वैभव और समस्त दिव्य धन के स्वामी हैं, हमें वह संपत्ति दें जो हमारे मन को शांति दे।
            हे पावक, आपकी पवित्रता हमारे अंतःकरण को पूर्णतः शुद्ध कर दे और हमें दैवीय आभा से आलोकित कर दे।
            आपकी कृपा से हमारे जीवन में किसी भी वस्तु की कमी न रहे और हम सदैव दूसरों की सहायता करने में समर्थ हों।
            आप केवल भौतिक सुख ही नहीं, बल्कि वह आत्मिक तेज भी प्रदान करते हैं जो हमें ईश्वर के साक्षात् का मार्ग दिखाता है।
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा हृदय सदैव भक्ति, ज्ञान और प्रेम के प्रकाश से भरा रहे।
            हे देव, आप हमारे दुखों के अंधकार को अपनी प्रखर ज्योति से नष्ट कर हमारे जीवन में आनंद का संचार करें।
            आपकी दीप्ति हमारे अज्ञान के पर्दों को हटाकर हमें वह स्पष्ट दृष्टि दे जिससे हम जीवन के सत्य को पहचान सकें।
            हे अग्नि, आप हमारे रक्षक और दाता के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली और महान बनाने की कृपा करें।
            हम आपकी इस भव्य और विराट महिमा को नमन करते हैं और आपके निरंतर आशीर्वाद की हृदय से कामना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, graciously bring into our lives a splendor and prosperity as brilliant and nourishing as the Sun.
            Provide us with the energy and health that allow us to remain active for a long life to serve the cause of Dharma.
            You are the master of the marvelous abundance of heaven and all divine wealth; grant us riches that give peace.
            O Purifier, let your holiness completely purify our inner self and illuminate us with a divine and celestial aura.
            By your grace, let there be no lack of any object in our lives, ensuring we are always capable of assisting others.
            You do not just provide material comforts; you also grant that spiritual luster which shows the path to God.
            We constantly sing your glories so that our hearts remain forever filled with the light of devotion, knowledge, and love.
            O God, destroy the darkness of our sorrows with your intense light and infuse our lives with profound joy.
            Let your radiance remove the veils of our ignorance and grant us clear vision to recognize the truth of existence.
            O Agni, always stay with us as our protector and provider, graciously making our lives magnificent and great.
            We bow before your grand and vast majesty and earnestly seek your continuous and loving divine blessings.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 69,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ ६९ ॥",
        hindiCommentary = """
            हे युवा अग्निदेव! आप समस्त प्रकार की समृद्धियों और पुष्टियों के आधार हैं, आप ही उन्हें अपनी शक्ति से पोषण देते हैं।
            जब हम बार-बार आपकी स्तुति और वंदना करते हैं, तो हमारी बुद्धि भी व्यापक, उदार और श्रेष्ठ दिशा की ओर बढ़ती है।
            आपकी कृपा से हमारी प्रज्ञा प्रखर होती है और हम कठिन चुनौतियों को भी सरलता से पार करने में सक्षम होते हैं।
            हे यविष्ठ्य, आपकी ऊर्जा हमारे जीवन के प्रत्येक क्षेत्र में पूर्णता और संपन्नता लाने का सामर्थ्य रखती है।
            आपकी उपासना करने से हमारे संकल्प सिद्ध होते हैं और हमें सर्वांगीण विकास प्राप्त होता है, यही आपकी महानता है।
            जैसे अग्नि समिधा पाकर और अधिक तेजस्वी होती है, वैसे ही हमारी आत्मा आपकी प्रेरणा से और अधिक बलवान होती है।
            आप हमें वह मानसिक विशालता प्रदान करें जिससे हम संकुचित भावनाओं को त्यागकर विश्व-कल्याण के बारे में सोचें।
            हमारी चेतना को उस उच्च स्तर तक उठाएं जहाँ हम ईश्वर की सर्वव्यापकता को प्रत्येक जीव में देख सकें।
            आप ही वह शक्ति हैं जो हमारे श्रम को ईश्वरीय फल में और हमारे जीवन को सफलता में बदलने का सामर्थ्य रखती हैं।
            हे अग्नि, हम आपकी बार-बार वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट, समृद्ध और धर्ममय बना रहे।
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपकी पवित्र ज्योति के सानिध्य में सदैव सुखी और सुरक्षित रहें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful Agni, you are the foundation of all forms of prosperity and nourishment; you sustain them with your power.
            As we repeatedly sing your praises and worship you, our intellect also grows vast, noble, and toward excellence.
            By your grace, our wisdom becomes sharp, making us capable of easily overcoming even the toughest of challenges.
            O Youngest One, your energy possesses the strength to bring completeness and abundance to every part of our lives.
            Worshipping you ensures the fulfillment of our resolutions and grants us all-around growth; this is your greatness.
            Just as fire blazes more radiantly when fueled, our soul becomes stronger and more vibrant under your inspiration.
            Grant us that mental expansion which allows us to renounce narrow feelings and think about global welfare.
            Elevate our consciousness to that high level where we can see the omnipresence of God in every living being.
            You are the power that possesses the capacity to transform our labor into divine fruits and our life into success.
            O Agni, we adore you repeatedly so that our lives remain nourished, prosperous, and righteous in every aspect.
            May your merciful gaze always remain upon us as we stay happy and secure in the presence of your holy light.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 70,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ७० ॥",
        hindiCommentary = """
            हे पावक अग्निदेव! आप दिव्य लोकों के स्वामी और समस्त चराचर जगत के ऐश्वर्यों के नियंत्रक और प्रदाता हैं।
            आप हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली प्रेरणा और अन्न लेकर आएं जो हमारे जीवन को सफल बनाए।
            आपकी कृपा से हमारी निर्धनता का नाश हो और हम केवल धन ही नहीं, बल्कि श्रेष्ठ गुणों के भी धनी बनें।
            हे देव, आप हमारे अज्ञान को अपनी प्रखर ज्योति से जलाकर हमें वह सत्य मार्ग दिखाएं जहाँ केवल शांति और सुख हो।
            आप ही वह शक्ति हैं जो हमारे तुच्छ कर्मों को ईश्वरीय फल तक पहुँचाती हैं और हमारे जीवन को कृतार्थ करती हैं।
            हमें वह 'इषम्' प्रदान करें जिससे हमारे शरीर में नवीन उत्साह और मन में सदैव पवित्र विचारों का प्रवाह बना रहे।
            आपकी महिमा का गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से जागृत होने लगते हैं।
            हे अग्नि, आप हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता और अखंड सौभाग्य प्रदान करने की कृपा करें।
            आपकी दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और कीर्ति का मार्ग दिखाए।
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें वह स्थायी संपत्ति दें जो हमारे इस लोक और परलोक दोनों में सहायक हो।
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके सानिध्य में सदैव आनंदमयी, मंगलमय और धर्ममय जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Purifying Agni, you are the Lord of celestial realms and the controller and provider of all worldly riches.
            For us, your devoted chanters, bring forth that powerful inspiration and nourishment that make our lives successful.
            By your grace, let our poverty be destroyed, making us wealthy not just with money but with superior virtues.
            O God, burn away our ignorance with your intense light and show us the path of truth where only peace and joy exist.
            You are the power that carries our humble deeds to divine results and makes our human existence truly blessed.
            Provide us with 'Isham' so that fresh enthusiasm remains in our bodies and pure thoughts flow in our minds.
            Singing your glories purifies our inner self and initiates our spiritual awakening and growth toward the Divine.
            O Agni, remove every lack from our lives and graciously grant us completeness and unbroken auspiciousness.
            Let your radiance illuminate every dark corner of our existence and show us the pathway to fame and glory.
            We pray with devotion to grant us that permanent wealth which assists us both in this world and the world beyond.
            May your merciful gaze always remain upon us as we lead a joyful, auspicious, and righteous life under your protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 71,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ७१ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय अनुष्ठानों के मुख्य पुरोहित और देवताओं को आहुति पहुँचाने वाले दिव्य माध्यम हैं।
            आप मनुष्यों के बीच रहकर भी हमारा संबंध स्वर्ग के देवताओं से जोड़ते हैं, आप ही हमारे सच्चे और परम हितैषी हैं।
            आपकी उपस्थिति के बिना हमारा कोई भी यज्ञ या संकल्प पूर्ण नहीं हो सकता, क्योंकि आप ही यज्ञ का आधार और केंद्र हैं।
            हे देव, आप हमारे भीतर दैवीय गुणों का संचार करें और हमें असुरत्व तथा बुराइयों के प्रभाव से सदैव बचाकर रखें।
            आपकी हितकारी दृष्टि हमें पतन के मार्ग से हटाकर निरंतर प्रगति, आत्मोन्नति और सुख की दिशा में अग्रसर करती है।
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे समस्त कर्मों को शुद्ध, पवित्र और कल्याणकारी बना दें।
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में शांति, समृद्धि और धार्मिक निष्ठा के मुख्य स्तंभ हैं।
            आपकी ऊर्जा हमारे प्राणों में चेतना बनकर बहती है और हमें सदैव सत्य और न्याय के मार्ग पर चलने की प्रेरणा देती है।
            हे अग्नि, आप हमारे गुरु और मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता को देख सकें।
            आपकी कृपा से हमारा जीवन दिव्य आशीषों से भरा रहे और हम सदैव मानवता की सेवा और धर्म की रक्षा में लगे रहें।
            इस संपूर्ण ब्रह्मांड में आपकी ही सत्ता और आपका ही तेज व्याप्त है, हम आपकी शरण में आकर स्वयं को धन्य मानते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest of all human rituals and the divine medium that carries offerings to the gods.
            While residing among us, you connect us with the celestial gods of heaven; you are our true and supreme well-wisher.
            Without your presence, no sacrifice or resolution of ours can be completed, for you are the foundation and center.
            O God, infuse our lives with divine qualities and always keep us safe from the influence of evil and demonic ways.
            Your benevolent gaze steers us away from the path of downfall and leads us toward progress and self-evolution.
            Just as fire consumes all impurities, please make our actions pure, holy, and beneficial for all living beings.
            We worship you because you are the main pillar of peace, prosperity, and religious devotion within our families.
            Your energy flows through our lives as consciousness, inspiring us to always walk the path of Truth and Justice.
            O Agni, become our teacher and guide, showing us that Truth where we can realize the omnipresence of the Divine.
            By your grace, let our lives be filled with divine blessings and let us stay engaged in service and Dharma.
            Your sovereign power and luster pervade this entire universe; by seeking your refuge, we consider ourselves blessed.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 72,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ७२ ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन के समस्त द्वेष, क्रोध और अशांति को शांत कर उसे अत्यंत निर्मल और शांत बना दें।
            आप हमें वह दृढ़ और अटल श्रद्धा प्रदान करें जिससे हम ईश्वर की न्याय व्यवस्था पर पूर्ण विश्वास कर सकें और सुखी रहें।
            हमें उन सभी नकारात्मक शक्तियों से सुरक्षित रखें जो हमारे मार्ग में बाधा डालती हैं और हमें धर्म से डिगाना चाहती हैं।
            आपकी कृपा से ही मनुष्य का हृदय समस्त जीवों के प्रति प्रेम और करुणा से भर जाता है, हमें भी वही विशाल हृदय दें।
            हे देव, श्रद्धा ही वह कुंजी है जिससे ईश्वर के रहस्य प्रकट होते हैं, कृपया हमारे भीतर इस श्रद्धा को सदैव जीवित रखें।
            हम ईर्ष्या की आग में जलने के बजाय आपके ज्ञान के प्रकाश में तपकर स्वयं को कुंदन की तरह श्रेष्ठ और तेजस्वी बनाएं।
            जब हमारा मन आपकी भक्ति और प्रेम में डूबा होता है, तब संसार का कोई भी अभाव या दुख हमें विचलित नहीं कर सकता।
            आप ही वह शक्ति हैं जो हमारे भीतर के अंधकार को नष्ट कर हमें आत्मज्ञान और ईश्वर के समीप ले जाने का मार्ग दिखाती हैं।
            हमें वह साहस और अभय प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रहें और निर्भीक होकर जीवन जी सकें।
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम सदैव सात्विक बने रहें और ईश्वर के अनंत आनंद का अनुभव करते रहें।
            हे अग्नि, हमारे मन को वह दिव्य मंदिर बना दें जहाँ केवल शुद्ध संकल्पों और देवताओं की ही स्थापना हो, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please calm all the malice, anger, and restlessness of our mind, making it extremely pure and serene.
            Grant us that firm and unshakable faith which allows us to trust in the just laws of the Divine and remain happy.
            Protect us from all negative forces that place hurdles in our path and attempt to sway us from the path of Dharma.
            It is only by your grace that a human heart fills with love and compassion for all living beings; grant us such a heart.
            O God, faith is the key that reveals the mysteries of the Divine; please keep this faith always alive within us.
            Instead of burning in the fire of jealousy, let us be refined in the light of your wisdom like pure and radiant gold.
            When our mind is immersed in your devotion and love, no worldly scarcity or sorrow can ever disturb our peace.
            You are the power that destroys our inner darkness and shows us the path toward Self-realization and God.
            Bestow upon us the courage and fearlessness required to always be ready for the protection of Dharma.
            May your merciful gaze remain upon us so that we stay virtuous and experience the infinite bliss of God.
            O Agni, transform our mind into a divine temple where only noble resolutions and the presence of gods reside.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 73,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ७३ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त से और अज्ञान के संकटों से सदैव सुरक्षित रखने की कृपा करें।
            जो शक्तियाँ हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके षड्यंत्रों को विफल कर दें।
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त ज्वालाओं से हमारे भीतर के समस्त दोषों को जला डालें।
            आपकी अग्नि केवल विनाश नहीं करती, बल्कि वह जीवन को एक नई दिशा और पवित्रता प्रदान करती है।
            हम आपकी शरण में आकर पूर्ण सुरक्षा की याचना करते हैं क्योंकि आप ही समस्त लोकों के रक्षक हैं।
            हमें वह आत्मबल प्रदान करें जिससे हम कभी भी अधर्म के मार्ग पर न चलें और सदैव आपकी आज्ञा में रहें।
            आपकी ज्योति हमारे चारों ओर एक ऐसा सुरक्षा कवच बनाए जिसे कोई भी बुरी शक्ति भेद न सके।
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की विजय के लिए सदैव तत्पर रहती हैं, हमें भी सत्य का योद्धा बनाएं।
            जीवन के प्रत्येक संघर्ष में आपकी रक्षात्मक शक्ति का अनुभव हमें अटूट साहस और शांति प्रदान करता है।
            हे अग्नि, आप हमारे परम रक्षक हैं, हमें अज्ञान से ज्ञान की ओर और अंधकार से परम प्रकाश की ओर ले चलें।
            हम आपकी इस दिव्य और महान शक्ति की बार-बार वंदना करते हैं और आपसे निरंतर संरक्षण की प्रार्थना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously protect us always from the terrible pit of sins and the calamities of ignorance.
            Those forces that wish us harm, please foil their conspiracies and plots with your supreme and sharp intelligence.
            O Ageless and Radiant Deity, consume all our internal flaws and weaknesses with your most intensely hot flames.
            Your fire does not just destroy; it provides life with a new direction, a fresh purpose, and absolute purity.
            We seek your refuge and pray for complete security, for you are the guardian and protector of all the worlds.
            Grant us the inner strength to never walk the path of unrighteousness and to always stay within your divine laws.
            Let your light create a protective shield around us that no evil or negative force can ever penetrate.
            O Most Resplendent One, your flames are ever ready for the victory of Truth; please make us also warriors of Truth.
            The experience of your protective power in every struggle of life gives us unbreakable courage and deep peace.
            O Agni, you are our supreme protector; lead us from ignorance to knowledge and from darkness to supreme light.
            We repeatedly bow before your divine and majestic power and pray for your constant and unwavering protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 74,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ७४ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी उत्तम आहुतियों को स्वीकार कर हमें उन शक्तियों से बचाएं जो हमसे द्वेष रखती हैं।
            आपकी ऊर्जा हमें वह सामर्थ्य प्रदान करे जिससे हम जीवन की समस्त चुनौतियों का निर्भीकता से सामना कर सकें।
            हमें वह आंतरिक शुद्धता दें जिससे हमारे मन में दूसरों के प्रति कभी भी संकीर्णता या घृणा का भाव न आए।
            हे यविष्ठ्य, आपकी अक्षय शक्ति ही हमारे जीवन का आधार है, हमें अपनी दिव्य सामर्थ्य का अंश प्रदान करें।
            यज्ञ में अर्पित हमारी प्रत्येक आहुति आपकी कृपा से ही सिद्ध होती है और हमें अभीष्ट फल की प्राप्ति कराती है।
            आप हमारे जीवन को पूर्णतः सुरक्षित और समृद्ध बनाने के लिए अपनी पवित्र ज्योति का घेरा हमारे चारों ओर करें।
            द्वेष की भावना मनुष्य की प्रगति को रोक देती है, आप हमें इस अंधकार से निकालकर सफलता की ओर ले चलें।
            आपकी मित्रता हमारे लिए वह दिव्य सुरक्षा है जो हमारे मन के समस्त भय और दुखों को हर लेती है।
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं ताकि हमारा जीवन सदैव सेवा और भक्ति में लगा रहे और हम ऊँचा उठें।
            हे अग्नि, हमें वह तेज दें कि हम स्वयं को धर्म में प्रतिष्ठित रख सकें और मानवता की सेवा कर सकें।
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके सानिध्य में सदैव निर्भय होकर श्रेष्ठ जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our best offerings, protect us from those forces that harbor malice toward us.
            May your energy provide us with the capability to face all of life's challenges with absolute fearlessness.
            Grant us that internal purity which ensures that no narrowness or feeling of hatred ever arises in our minds toward others.
            O Youngest One, your inexhaustible power is the foundation of our existence; grant us a portion of your divine strength.
            Every oblation offered in the sacrifice is fulfilled by your grace and leads us to the achievement of our goals.
            Create a circle of your sacred light around us to make our lives completely secure, protected, and prosperous.
            The feeling of malice halts a person's progress; lead us out of this darkness and toward the path of success.
            Your friendship is that divine security for us which takes away all the fears and sorrows of our wandering mind.
            We pray to you with devotion so that our life remains dedicated to service and devotion, helping us to rise higher.
            O Agni, give us the luster to keep ourselves established in Dharma and to serve humanity with all our heart.
            May your merciful gaze remain upon us as we lead a superior and fearless life under your divine and holy presence.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 75,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ७५ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य के समान तेजस्वी और जीवनदायी ऐश्वर्य हमारे घर और हृदय में लेकर आएं।
            आप हमें वह जीवनी शक्ति प्रदान करें जिससे हम लंबी आयु तक स्वस्थ और क्रियाशील रहकर श्रेष्ठ कर्म कर सकें।
            आप स्वर्ग के अनुपम वैभव और समस्त ब्रह्मांडीय धन के अधिपति हैं, हमें वह सुख प्रदान करें जो अविनाशी हो।
            हे पावक, आपकी पवित्रता हमारे रोम-रोम में समा जाए और हमें पूर्णतः निर्मल और कांतिवान बना दे।
            आपकी कृपा से हमारे जीवन में किसी भी संसाधन की कमी न रहे और हम सदैव दूसरों के काम आ सकें।
            आप केवल बाहरी धन ही नहीं, बल्कि वह प्रज्ञा और विवेक भी देते हैं जो हमें मोक्ष के मार्ग पर ले जाता है।
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा जीवन सदैव भक्ति और ज्ञान के प्रकाश से जगमगाता रहे।
            हे देव, आप हमारे दुखों की काली छाया को समाप्त कर हमारे जीवन में हर्ष और आनंद का अमृत घोल दें।
            आपकी दीप्ति हमारे अज्ञान को मिटाकर हमें वह स्पष्टता प्रदान करे जिससे हम ईश्वर की सत्ता को पहचान सकें।
            हे अग्नि, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली और यशस्वी बनाएं।
            हम आपकी इस विराट और भव्य महिमा को नमन करते हैं और आपके निरंतर आशीर्वाद की विनम्र कामना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our homes and hearts a splendor and prosperity as brilliant and life-giving as the Sun.
            Provide us with the vital energy that allows us to stay healthy and active for a long life to perform noble deeds.
            You are the sovereign lord of the unique abundance of heaven and all cosmic wealth; grant us joy that is imperishable.
            O Purifier, let your holiness permeate every cell of our being, making us completely pure and radiant.
            By your grace, let there be no lack of resources in our lives, ensuring we are always capable of serving others.
            You do not just provide external wealth; you also grant that wisdom and discernment which lead us to liberation.
            We constantly sing your glories so that our life remains forever illuminated with the light of devotion and knowledge.
            O God, eliminate the dark shadows of our sorrows and infuse our lives with the nectar of joy and bliss.
            Let your radiance erase our ignorance and grant us that clarity which enables us to recognize the Divine Reality.
            O Agni, always remain with us as our protector and nourisher, making our lives magnificent, successful, and renowned.
            We bow before your vast and grand majesty and humbly seek your continuous and loving divine blessings.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 76,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ७६ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय अनुष्ठानों के मुख्य पुरोहित और देवताओं को बुलाने वाले दिव्य दूत हैं।
            आप हमारे बीच रहकर भी हमें स्वर्ग के देवताओं के साथ जोड़ते हैं, आप ही हम मनुष्यों के परम शुभचिंतक हैं।
            आपकी उपस्थिति के बिना हमारा कोई भी यज्ञ या संकल्प पूर्ण नहीं हो सकता, क्योंकि आप ही उसकी शक्ति हैं।
            हे देव, आप हमारे भीतर दिव्य प्रवृत्तियों का विकास करें और हमें बुराइयों के प्रभाव से सदैव सुरक्षित रखें।
            आपकी हितकारी दृष्टि हमें पतन के मार्ग से हटाकर निरंतर प्रगति और उन्नति की दिशा में अग्रसर करती है।
            जैसे अग्नि अशुद्ध सोने को तपाकर कुंदन बना देती है, वैसे ही आप हमारे कर्मों को शुद्ध और कल्याणकारी बना दें।
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में शांति, समृद्धि और धर्मनिष्ठा के मुख्य आधार हैं।
            आपकी ऊर्जा हमारे प्राणों में चेतना बनकर प्रवाहित होती है और हमें सदैव सत्य के मार्ग पर चलने की प्रेरणा देती है।
            हे अग्नि, आप हमारे मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता का साक्षात् कर सकें।
            आपकी कृपा से हमारा जीवन दिव्य आशीर्वादों से परिपूर्ण हो और हम सदैव लोक-कल्याण के कार्यों में लगे रहें।
            इस संपूर्ण ब्रह्मांड में आपकी ही सत्ता और तेज व्याप्त है, हम आपकी शरण में आकर स्वयं को धन्य मानते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest of all human rituals and the divine messenger who invokes the gods.
            While residing among us, you connect us with the celestial gods of heaven; you are our supreme well-wisher.
            Without your presence, no sacrifice or resolution of ours can be completed, for you are its very power.
            O God, develop divine tendencies within us and always keep us safe from the influence of evil and vice.
            Your benevolent gaze steers us away from the path of downfall and leads us toward continuous progress and evolution.
            Just as fire refines impure gold, please make our actions pure, holy, and beneficial for the entire world.
            We worship you because you are the main foundation of peace, prosperity, and devotion within our families.
            Your energy flows through our lives as consciousness, inspiring us to always walk the path of eternal Truth.
            O Agni, become our guide and show us that Truth where we can realize the omnipresence of the Divine.
            By your grace, let our lives be filled with divine blessings and let us stay engaged in acts of global welfare.
            Your sovereign power and luster pervade this entire universe; by seeking your refuge, we consider ourselves blessed.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 77,
        sanskrit = "आ ते वत्सो मनो यमत् परमाच्चित् सधस्थात् ।\nअग्ने त्वां कामये गिरा ॥ ७७ ॥",
        hindiCommentary = """
            हे अग्निदेव! भक्त का मन और उसकी वाणी आपको सर्वोच्च धाम से अपने हृदय में बुलाने के लिए व्याकुल है।
            जैसे वत्स (बछड़ा) अपनी माता के लिए पुकार लगाता है, वैसे ही हम अपनी पवित्र गिरा (वाणी) से आपकी कामना करते हैं।
            आपकी दिव्यता हमारे जीवन को स्पर्श करे और हमारे अंतःकरण में ज्ञान का अखंड दीप प्रज्वलित कर दे।
            हम संसार की नश्वर वस्तुओं के बजाय आपके शाश्वत प्रेम और सान्निध्य की ही निरंतर इच्छा रखते हैं।
            हे देव, आप अपनी महिमा के शिखर से उतरकर हमारे तुच्छ जीवन को अपनी पावन उपस्थिति से कृतार्थ करें।
            हमारी स्तुतियां केवल शब्द नहीं, बल्कि हमारे हृदय की वह पुकार हैं जो आपको आने के लिए विवश कर देती हैं।
            आप ही वह परमानंद हैं जिसे प्राप्त करने के बाद मनुष्य को संसार में अन्य कुछ भी पाने की इच्छा नहीं रहती।
            आपकी कृपा से हमारी वाणी में वह तेज और सत्यता आए कि वह सीधे आपके दिव्य कानों तक पहुँच सके।
            हमें वह आध्यात्मिक प्यास दें जो केवल आपके सान्निध्य रूपी अमृत से ही शांत हो सके और हमें तृप्त करे।
            हे अग्नि, आप हमारी प्रार्थनाओं को स्वीकार करें और हमारे जीवन को अपनी दिव्य चेतना से आलोकित करें।
            हम आपकी बार-बार वंदना करते हैं और आपसे यही याचना करते हैं कि आप सदैव हमारे हृदय में विराजमान रहें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, the mind and voice of the devotee are restless to call you from your supreme abode into their heart.
            Just as a calf (Vatsa) calls out for its mother, we intensely desire and seek you with our sacred and holy speech.
            May your divinity touch our lives and ignite the eternal lamp of knowledge within our deepest consciousness.
            Instead of worldly and perishable objects, we continuously long for your eternal love and divine presence.
            O God, descend from the peak of your glory and bless our humble lives with your most sacred and holy presence.
            Our praises are not just words; they are the desperate cries of our hearts that compel you to manifest here.
            You are that supreme bliss after attaining which a human possesses no desire to attain anything else in the world.
            By your grace, let our speech gain such brilliance and truth that it reaches directly into your divine ears.
            Grant us that spiritual thirst which can only be quenched by the nectar of your presence and satisfy us.
            O Agni, accept our humble prayers and illuminate our existence with your profound and divine consciousness.
            We repeatedly adore you and pray that you remain forever established and seated within our hearts.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 78,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ७८ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त यज्ञों के अधिष्ठाता और देवताओं को आहुति प्रदान करने वाले मुख्य माध्यम हैं।
            आप मनुष्यों के बीच रहकर भी दिव्य लोकों के दूत के रूप में हमारे समस्त कल्याणकारी कार्यों के साक्षी हैं।
            आपकी सहायता के बिना कोई भी शुभ कर्म अपने श्रेष्ठ फल को प्राप्त नहीं कर सकता, आप ही यज्ञ की आधारशिला हैं।
            हे देव, आप हमारे जीवन में देवताओं की शक्ति और मनुष्य की निष्ठा का सुंदर संगम स्थापित करने की कृपा करें।
            आपकी हितकारी दृष्टि हमें स्वार्थ से ऊपर उठाकर परमार्थ के मार्ग पर चलने के लिए निरंतर प्रेरित करती रहती है।
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे कर्मों को पवित्र और परोपकारी बना दें।
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में अनुशासन, सुख और धर्मनिष्ठा के मुख्य संरक्षक हैं।
            आपकी ऊर्जा हमारे शरीर में बल और मन में दृढ़ संकल्प बनकर बहती है, जिससे हम सदैव प्रगतिशील बने रहते हैं।
            हे अग्नि, आप हमारे गुरु बनकर हमें वह ज्ञान प्रदान करें जिससे हम माया के बंधनों से मुक्त होकर ईश्वर को पा सकें।
            आपकी कृपा से हमारा जीवन दिव्य आशीषों से भर जाए और हम सदैव सत्य के मार्ग पर अडिग होकर जीवन जिएं।
            इस संपूर्ण सृष्टि में आपकी ही दिव्यता और शक्ति क्रियाशील है, हम आपकी शरण में आकर अत्यंत गौरव का अनुभव करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the presiding deity of all sacrifices and the chief medium for providing offerings to the gods.
            While residing among humans as the messenger of celestial realms, you are the witness of all our noble deeds.
            Without your assistance, no auspicious action can achieve its highest result; you are the foundation of ritual.
            O God, please establish a beautiful union of divine power and human sincerity within our daily lives.
            Your benevolent gaze constantly inspires us to rise above selfishness and walk the path of supreme altruism.
            Just as fire consumes all impurities, please make our actions pure, holy, and dedicated to the welfare of others.
            We worship you because you are the chief guardian of discipline, joy, and righteousness within our families.
            Your energy flows as strength in our bodies and as firm resolve in our minds, keeping us forever progressive.
            O Agni, become our teacher and grant us that wisdom which liberates us from the bonds of Maya to reach God.
            By your grace, let our lives be filled with divine blessings and let us live staying firm on the path of Truth.
            In this entire creation, your divinity and power are active; we feel immensely honored to seek your refuge.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 79,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ७९ ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन को क्रोध, संशय और द्वेष से मुक्त कर उसे गंगा के जल के समान पवित्र बना दें।
            आप हमें वह दृढ़ श्रद्धा प्रदान करें जिससे हम ईश्वर की न्यायपूर्ण व्यवस्था पर विश्वास कर सकें और शांत रहें।
            हमें उन सभी बाधाओं से सुरक्षित रखें जो हमारे मन में अविश्वास उत्पन्न कर हमें धर्म के मार्ग से विचलित करती हैं।
            आपकी कृपा से ही मनुष्य का हृदय विशाल और दयालु बनता है, जिससे वह समस्त जीवों में ईश्वर के दर्शन करता है।
            हे देव, श्रद्धा ही वह सेतु है जो जीव को शिव से जोड़ती है, कृपया हमारे भीतर इस श्रद्धा को सदैव जीवित रखें।
            हम ईर्ष्या की जलन में जलने के बजाय आपकी ज्ञान की ज्योति में प्रकाशित होकर स्वयं का और जगत का कल्याण करें।
            जब हमारा मन आपकी भक्ति में ओत-प्रोत होता है, तब संसार का कोई भी दुख हमें अपनी शांति से डिगा नहीं सकता।
            आप ही वह शक्ति हैं जो हमारे भीतर की तामसी प्रवृत्तियों को नष्ट कर हमें सात्विक और तेजस्वी बनाती हैं।
            हमें वह अभय और साहस प्रदान करें जिससे हम धर्म की मर्यादाओं का पालन करते हुए निर्भीक होकर जीवन जी सकें।
            आपकी कृपा दृष्टि हम पर बनी रहे ताकि हम सदैव शुद्ध बने रहें और आपकी दिव्य उपस्थिति का अनुभव करते रहें।
            हे अग्नि, हमारे मन को वह दिव्य वेदी बना दें जहाँ केवल शुभ संकल्पों और देवताओं की ही स्थापना हो।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please free our minds from anger, doubt, and malice, making them as pure as the water of Ganga.
            Grant us that firm faith which allows us to trust in the just laws of the Divine and remain peaceful and calm.
            Protect us from all obstacles that create distrust in our hearts and attempt to distract us from the path of Dharma.
            It is only by your grace that a human heart becomes vast and compassionate, seeing God in every living being.
            O God, faith is the bridge that connects the individual soul with the Divine; keep this faith alive within us forever.
            Instead of burning in the heat of jealousy, let us be illuminated by your light to serve ourselves and the world.
            When our mind is saturated with your devotion, no worldly sorrow can ever shake us from our inner peace.
            You are the power that destroys our lower, dark tendencies and makes us virtuous, radiant, and spiritually bright.
            Bestow upon us the fearlessness and courage to lead a bold life while strictly adhering to the boundaries of Dharma.
            May your merciful gaze remain upon us so that we stay pure and continue to experience your divine presence.
            O Agni, transform our mind into a divine altar where only noble resolutions and the presence of gods are established.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 80,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ८० ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक बंधनों से और अज्ञान रूपी अंधकार से सदैव सुरक्षित रखने की कृपा करें।
            जो शक्तियाँ हमारी उन्नति में बाधक हैं या हमारा अहित चाहती हैं, आप अपने तेज से उनके प्रयासों को नष्ट कर दें।
            हे अजर और अविनाशी देव, आप अपनी अत्यंत प्रखर ज्वालाओं से हमारे समस्त दोषों और विकारों को जला डालें।
            आपकी अग्नि अशुद्धियों को नष्ट कर जीवन को नवीन ऊर्जा और पावनता से भर देने वाली है, हम आपकी शरण में हैं।
            हमें वह सुरक्षा प्रदान करें जिससे हम निर्भीक होकर अपने कर्तव्यों का पालन कर सकें और धर्म पर अडिग रहें।
            पाप वह कीचड़ है जो आत्मा को मलिन कर देता है, आप अपने ज्ञान की अग्नि से हमें उससे पूर्णतः मुक्त कर दें।
            आपकी ज्योति हमारे चारों ओर एक ऐसा सुरक्षा दुर्ग बनाए जिसमें केवल सात्विकता और शांति का ही प्रवेश हो।
            हे तपिष्ठ, आपकी ज्वालाएं अन्याय और अधर्म के विरुद्ध काल के समान हैं, हमें सदैव न्याय के पक्ष में खड़ा रखें।
            जीवन के प्रत्येक कठिन मोड़ पर आपकी रक्षात्मक शक्ति का अनुभव हमें असीम साहस और मानसिक शांति प्रदान करता है।
            हे अग्नि, आप हमारे स्वामी और रक्षक हैं, हमें अंधकारमय अज्ञान से हटाकर परम सत्य के प्रकाश की ओर ले चलें।
            हम आपकी इस दिव्य और भव्य महिमा की बार-बार वंदना करते हैं और आपसे निरंतर सुरक्षा और कल्याण की प्रार्थना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously protect us always from the terrible bonds of sins and the darkness of ignorance.
            Those forces that are obstacles to our progress or wish us harm, destroy their efforts with your radiant luster.
            O Ageless and Imperishable Deity, consume all our flaws and mental afflictions with your most intense flames.
            Your fire destroys impurities and fills life with fresh energy and holiness; we seek your ultimate refuge.
            Provide us with that security which allows us to perform our duties fearlessly and stay firm on the path of Dharma.
            Sin is the mire that stains the soul; please free us completely from it with the fire of your eternal knowledge.
            Let your light create such a fortress of security around us that only virtue and peace find their way inside.
            O Most Resplendent One, your flames are like Time itself against injustice; keep us always on the side of Justice.
            The experience of your protective power at every difficult turn of life gives us immense courage and mental peace.
            O Agni, you are our Lord and Protector; lead us from darkness to light and from reality to immortality.
            We repeatedly bow before your divine and magnificent glory and pray for your constant protection and well-being.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 81,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ८१ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी उत्तम आहुतियों को स्वीकार कर हमें उन शक्तियों से बचाएं जो हमसे द्वेष रखती हैं। 
            आपकी ऊर्जा हमें वह सामर्थ्य प्रदान करे जिससे हम जीवन की समस्त चुनौतियों का निर्भीकता से सामना कर सकें और विजयी हों। 
            हमें वह आंतरिक शुद्धता दें जिससे हमारे मन में दूसरों के प्रति कभी भी संकीर्णता, घृणा या ईर्ष्या का भाव उत्पन्न न हो। 
            हे यविष्ठ्य, आपकी अक्षय शक्ति ही हमारे जीवन का आधार है, हमें अपनी दिव्य सामर्थ्य का एक अंश प्रदान करने की कृपा करें। 
            यज्ञ में अर्पित हमारी प्रत्येक आहुति आपकी कृपा से ही सिद्ध होती है और हमें अभीष्ट फल की प्राप्ति कराती है। 
            आप हमारे जीवन को पूर्णतः सुरक्षित और समृद्ध बनाने के लिए अपनी पवित्र ज्योति का घेरा हमारे चारों ओर करें। 
            द्वेष की भावना मनुष्य की आध्यात्मिक प्रगति को रोक देती है, आप हमें इस अंधकार से निकालकर सफलता की ओर ले चलें। 
            आपकी मित्रता हमारे लिए वह दिव्य सुरक्षा है जो हमारे मन के समस्त भय और संशयों को जड़ से समाप्त कर देती है। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं ताकि हमारा जीवन सदैव सेवा और भक्ति में लगा रहे और हम निरंतर ऊँचा उठें। 
            हे अग्नि, हमें वह तेज दें कि हम स्वयं को धर्म में प्रतिष्ठित रख सकें और अपनी मानवता की निस्वार्थ सेवा कर सकें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके सानिध्य में सदैव निर्भय होकर श्रेष्ठ जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our best offerings, protect us from those forces that harbor malice toward us. 
            May your energy provide us with the capability to face all of life's challenges with absolute fearlessness and victory. 
            Grant us that internal purity which ensures that no narrowness, feeling of hatred, or jealousy ever arises in our minds toward others. 
            O Youngest One, your inexhaustible power is the foundation of our existence; grant us a portion of your divine strength. 
            Every oblation offered in the sacrifice is fulfilled by your grace and leads us to the achievement of our spiritual goals. 
            Create a circle of your sacred light around us to make our lives completely secure, protected, and prosperous. 
            The feeling of malice halts a person's spiritual progress; lead us out of this darkness and toward the path of success. 
            Your friendship is that divine security for us which takes away all the fears and doubts of our wandering mind. 
            We pray to you with devotion so that our life remains dedicated to service and devotion, helping us to rise higher. 
            O Agni, give us the luster to keep ourselves established in Dharma and to serve humanity with all our heart and soul. 
            May your merciful gaze remain upon us as we lead a superior and fearless life under your divine and holy presence.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 82,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ८२ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य के समान तेजस्वी और जीवनदायी ऐश्वर्य हमारे घर और हृदय में लेकर आने की कृपा करें। 
            आप हमें वह जीवनी शक्ति प्रदान करें जिससे हम लंबी आयु तक स्वस्थ और क्रियाशील रहकर श्रेष्ठ धर्म का पालन कर सकें। 
            आप स्वर्ग के अनुपम वैभव और समस्त ब्रह्मांडीय धन के अधिपति हैं, हमें वह आत्मिक सुख प्रदान करें जो अविनाशी हो। 
            हे पावक, आपकी पवित्रता हमारे रोम-रोम में समा जाए और हमें पूर्णतः निर्मल, कांतिवान और ऊर्जावान बना दे। 
            आपकी कृपा से हमारे जीवन में किसी भी संसाधन की कमी न रहे और हम सदैव दूसरों के कल्याण के काम आ सकें। 
            आप केवल बाहरी धन ही नहीं, बल्कि वह प्रज्ञा और विवेक भी देते हैं जो हमें मोक्ष और सत्य के मार्ग पर ले जाता है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा जीवन सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे। 
            हे देव, आप हमारे दुखों की काली छाया को समाप्त कर हमारे जीवन में हर्ष और आनंद का दिव्य अमृत घोल दें। 
            आपकी दीप्ति हमारे अज्ञान को मिटाकर हमें वह स्पष्टता प्रदान करे जिससे हम ईश्वर की अनंत सत्ता को पहचान सकें। 
            हे अग्नि, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और महान बनाएं। 
            हम आपकी इस विराट और भव्य महिमा को नमन करते हैं और आपके निरंतर आशीर्वाद की विनम्रतापूर्वक कामना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our homes and hearts a splendor and prosperity as brilliant and life-giving as the Sun. 
            Provide us with the vital energy that allows us to stay healthy and active for a long life to perform noble deeds. 
            You are the sovereign lord of the unique abundance of heaven and all cosmic wealth; grant us joy that is imperishable. 
            O Purifier, let your holiness permeate every cell of our being, making us completely pure, radiant, and energetic. 
            By your grace, let there be no lack of resources in our lives, ensuring we are always capable of serving others. 
            You do not just provide external wealth; you also grant that wisdom and discernment which lead us to liberation. 
            We constantly sing your glories so that our life remains forever illuminated with the light of devotion and knowledge. 
            O God, eliminate the dark shadows of our sorrows and infuse our lives with the nectar of divine joy and bliss. 
            Let your radiance erase our ignorance and grant us that clarity which enables us to recognize the Divine Reality. 
            O Agni, always remain with us as our protector and nourisher, making our lives magnificent, successful, and renowned. 
            We bow before your vast and grand majesty and humbly seek your continuous and loving divine blessings.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 83,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ ८३ ॥",
        hindiCommentary = """
            हे युवा अग्निदेव! आप समस्त प्रकार की समृद्धियों और पुष्टियों के आधार हैं, आप ही उन्हें अपनी शक्ति से पोषण देते हैं। 
            जब हम बार-बार आपकी स्तुति और वंदना करते हैं, तो हमारी बुद्धि भी व्यापक, उदार और श्रेष्ठ दिशा की ओर बढ़ने लगती है। 
            आपकी कृपा से हमारी प्रज्ञा प्रखर होती है और हम जीवन की कठिन चुनौतियों को भी सरलता से पार करने में सक्षम होते हैं। 
            हे यविष्ठ्य, आपकी ऊर्जा हमारे जीवन के प्रत्येक क्षेत्र में पूर्णता, संपन्नता और अखंड संतोष लाने का सामर्थ्य रखती है। 
            आपकी उपासना करने से हमारे संकल्प सिद्ध होते हैं और हमें सर्वांगीण विकास प्राप्त होता है, यही आपकी महानता है। 
            जैसे अग्नि समिधा पाकर और अधिक तेजस्वी होती है, वैसे ही हमारी आत्मा आपकी प्रेरणा से और अधिक बलवान और दिव्य होती है। 
            आप हमें वह मानसिक विशालता प्रदान करें जिससे हम संकुचित भावनाओं को त्यागकर विश्व-कल्याण के बारे में सोच सकें। 
            हमारी चेतना को उस उच्च स्तर तक उठाएं जहाँ हम ईश्वर की सर्वव्यापकता को प्रत्येक जीव और कण में देख सकें। 
            आप ही वह शक्ति हैं जो हमारे श्रम को ईश्वरीय फल में और हमारे जीवन को परम सफलता में बदलने का सामर्थ्य रखती हैं। 
            हे अग्नि, हम आपकी बार-बार वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट, समृद्ध और धर्ममय बना रहे। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपकी पवित्र ज्योति के सान्निध्य में सदैव सुखी और सुरक्षित रहें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful Agni, you are the foundation of all forms of prosperity and nourishment; you sustain them with your power. 
            As we repeatedly sing your praises and worship you, our intellect also grows vast, noble, and toward excellence. 
            By your grace, our wisdom becomes sharp, making us capable of easily overcoming even the toughest of life's challenges. 
            O Youngest One, your energy possesses the strength to bring completeness and abundance to every part of our lives. 
            Worshipping you ensures the fulfillment of our resolutions and grants us all-around growth; this is your greatness. 
            Just as fire blazes more radiantly when fueled, our soul becomes stronger and more vibrant under your inspiration. 
            Grant us that mental expansion which allows us to renounce narrow feelings and think about global welfare. 
            Elevate our consciousness to that high level where we can see the omnipresence of God in every living being. 
            You are the power that possesses the capacity to transform our labor into divine fruits and our life into success. 
            O Agni, we adore you repeatedly so that our lives remain nourished, prosperous, and righteous in every aspect. 
            May your merciful gaze always remain upon us as we stay happy and secure in the presence of your holy light.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 84,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ८४ ॥",
        hindiCommentary = """
            हे पावक अग्निदेव! आप दिव्य लोकों के स्वामी और समस्त चराचर जगत के ऐश्वर्यों के परम नियंत्रक और प्रदाता हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली प्रेरणा और अन्न लेकर आएं जो हमारे जीवन को सार्थक और सफल बनाए। 
            आपकी कृपा से हमारी निर्धनता का नाश हो और हम केवल भौतिक धन ही नहीं, बल्कि श्रेष्ठ गुणों के भी धनी बनें। 
            हे देव, आप हमारे अज्ञान को अपनी प्रखर ज्योति से जलाकर हमें वह सत्य मार्ग दिखाएं जहाँ केवल शांति और आनंद हो। 
            आप ही वह शक्ति हैं जो हमारे तुच्छ कर्मों को ईश्वरीय फल तक पहुँचाती हैं और हमारे मानवीय जीवन को कृतार्थ करती हैं। 
            हमें वह 'इषम्' प्रदान करें जिससे हमारे शरीर में नवीन उत्साह और मन में सदैव पवित्र विचारों का अखंड प्रवाह बना रहे। 
            आपकी महिमा का गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से जागृत होने लगते हैं। 
            हे अग्नि, आप हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता और अखंड सौभाग्य प्रदान करने की कृपा करें। 
            आपकी दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और कीर्ति का मार्ग दिखाए। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें वह स्थायी संपत्ति दें जो हमारे इस लोक और परलोक दोनों में सहायक हो। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके सान्निध्य में सदैव आनंदमयी, मंगलमय और धर्ममय जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Purifying Agni, you are the Lord of celestial realms and the controller and provider of all worldly riches. 
            For us, your devoted chanters, bring forth that powerful inspiration and nourishment that make our lives successful. 
            By your grace, let our poverty be destroyed, making us wealthy not just with money but with superior virtues. 
            O God, burn away our ignorance with your intense light and show us the path of truth where only peace and joy exist. 
            You are the power that carries our humble deeds to divine results and makes our human existence truly blessed. 
            Provide us with 'Isham' so that fresh enthusiasm remains in our bodies and pure thoughts flow in our minds. 
            Singing your glories purifies our inner self and initiates our spiritual awakening and growth toward the Divine. 
            O Agni, remove every lack from our lives and graciously grant us completeness and unbroken auspiciousness. 
            Let your radiance illuminate every dark corner of our existence and show us the pathway to fame and glory. 
            We pray with devotion to grant us that permanent wealth which assists us both in this world and the world beyond. 
            May your merciful gaze always remain upon us as we lead a joyful, auspicious, and righteous life under your protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 85,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ८५ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय अनुष्ठानों के मुख्य पुरोहित और देवताओं को आहुति पहुँचाने वाले दिव्य माध्यम हैं। 
            आप मनुष्यों के बीच रहकर भी हमारा संबंध स्वर्ग के देवताओं से जोड़ते हैं, आप ही हमारे सच्चे और परम हितैषी हैं। 
            आपकी उपस्थिति के बिना हमारा कोई भी यज्ञ या संकल्प पूर्ण नहीं हो सकता, क्योंकि आप ही यज्ञ का आधार और केंद्र हैं। 
            हे देव, आप हमारे भीतर दैवीय गुणों का संचार करें और हमें असुरत्व तथा बुराइयों के प्रभाव से सदैव बचाकर रखें। 
            आपकी हितकारी दृष्टि हमें पतन के मार्ग से हटाकर निरंतर प्रगति, आत्मोन्नति और सुख की दिशा में अग्रसर करती है। 
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे समस्त कर्मों को शुद्ध, पवित्र और कल्याणकारी बना दें। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में शांति, समृद्धि और धार्मिक निष्ठा के मुख्य स्तंभ हैं। 
            आपकी ऊर्जा हमारे प्राणों में चेतना बनकर बहती है और हमें सदैव सत्य और न्याय के मार्ग पर चलने की प्रेरणा देती है। 
            हे अग्नि, आप हमारे गुरु और मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता को देख सकें। 
            आपकी कृपा से हमारा जीवन दिव्य आशीषों से भरा रहे और हम सदैव मानवता की सेवा और धर्म की रक्षा में लगे रहें। 
            इस संपूर्ण ब्रह्मांड में आपकी ही सत्ता और आपका ही तेज व्याप्त है, हम आपकी शरण में आकर स्वयं को धन्य मानते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest of all human rituals and the divine medium that carries offerings to the gods. 
            While residing among us, you connect us with the celestial gods of heaven; you are our true and supreme well-wisher. 
            Without your presence, no sacrifice or resolution of ours can be completed, for you are the foundation and center. 
            O God, infuse our lives with divine qualities and always keep us safe from the influence of evil and demonic ways. 
            Your benevolent gaze steers us away from the path of downfall and leads us toward progress and self-evolution. 
            Just as fire consumes all impurities, please make our actions pure, holy, and beneficial for all living beings. 
            We worship you because you are the main pillar of peace, prosperity, and religious devotion within our families. 
            Your energy flows through our lives as consciousness, inspiring us to always walk the path of Truth and Justice. 
            O Agni, become our teacher and guide, showing us that Truth where we can realize the omnipresence of the Divine. 
            By your grace, let our lives be filled with divine blessings and let us stay engaged in service and Dharma. 
            Your sovereign power and luster pervade this entire universe; by seeking your refuge, we consider ourselves blessed.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 86,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ८६ ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन के समस्त द्वेष, क्रोध और अशांति को शांत कर उसे अत्यंत निर्मल और शांत बना दें। 
            आप हमें वह दृढ़ और अटल श्रद्धा प्रदान करें जिससे हम ईश्वर की न्याय व्यवस्था पर पूर्ण विश्वास कर सकें और सुखी रहें। 
            हमें उन सभी नकारात्मक शक्तियों से सुरक्षित रखें जो हमारे मार्ग में बाधा डालती हैं और हमें धर्म से डिगाना चाहती हैं। 
            आपकी कृपा से ही मनुष्य का हृदय समस्त जीवों के प्रति प्रेम और करुणा से भर जाता है, हमें भी वही विशाल हृदय दें। 
            हे देव, श्रद्धा ही वह कुंजी है जिससे ईश्वर के रहस्य प्रकट होते हैं, कृपया हमारे भीतर इस श्रद्धा को सदैव जीवित रखें। 
            हम ईर्ष्या की आग में जलने के बजाय आपके ज्ञान के प्रकाश में तपकर स्वयं को कुंदन की तरह श्रेष्ठ और तेजस्वी बनाएं। 
            जब हमारा मन आपकी भक्ति और प्रेम में डूबा होता है, तब संसार का कोई भी अभाव या दुख हमें विचलित नहीं कर सकता। 
            आप ही वह शक्ति हैं जो हमारे भीतर के अंधकार को नष्ट कर हमें आत्मज्ञान और ईश्वर के समीप ले जाने का मार्ग दिखाती हैं। 
            हमें वह साहस और अभय प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रहें और निर्भीक होकर जीवन जी सकें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम सदैव सात्विक बने रहें और ईश्वर के अनंत आनंद का अनुभव करते रहें। 
            हे अग्नि, हमारे मन को वह दिव्य मंदिर बना दें जहाँ केवल शुद्ध संकल्पों और देवताओं की ही स्थापना हो, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please calm all the malice, anger, and restlessness of our mind, making it extremely pure and serene. 
            Grant us that firm and unshakable faith which allows us to trust in the just laws of the Divine and remain happy. 
            Protect us from all negative forces that place hurdles in our path and attempt to sway us from the path of Dharma. 
            It is only by your grace that a human heart fills with love and compassion for all living beings; grant us such a heart. 
            O God, faith is the key that reveals the mysteries of the Divine; please keep this faith always alive within us. 
            Instead of burning in the fire of jealousy, let us be refined in the light of your wisdom like pure and radiant gold. 
            When our mind is immersed in your devotion and love, no worldly scarcity or sorrow can ever disturb our peace. 
            You are the power that destroys our inner darkness and shows us the path toward Self-realization and God. 
            Bestow upon us the courage and fearlessness required to always be ready for the protection of Dharma. 
            May your merciful gaze remain upon us so that we stay virtuous and experience the infinite bliss of God. 
            O Agni, transform our mind into a divine temple where only noble resolutions and the presence of gods reside.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 87,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ८७ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त से और अज्ञान के संकटों से सदैव सुरक्षित रखने की कृपा करें। 
            जो शक्तियाँ हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके षड्यंत्रों को विफल कर दें। 
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त ज्वालाओं से हमारे भीतर के समस्त दोषों को जला डालें। 
            आपकी अग्नि केवल विनाश नहीं करती, बल्कि वह जीवन को एक नई दिशा और पवित्रता प्रदान करती है। 
            हम आपकी शरण में आकर पूर्ण सुरक्षा की याचना करते हैं क्योंकि आप ही समस्त लोकों के रक्षक हैं। 
            हमें वह आत्मबल प्रदान करें जिससे हम कभी भी अधर्म के मार्ग पर न चलें और सदैव आपकी आज्ञा में रहें। 
            आपकी ज्योति हमारे चारों ओर एक ऐसा सुरक्षा कवच बनाए जिसे कोई भी बुरी शक्ति भेद न सके। 
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की विजय के लिए सदैव तत्पर रहती हैं, हमें भी सत्य का योद्धा बनाएं। 
            जीवन के प्रत्येक संघर्ष में आपकी रक्षात्मक शक्ति का अनुभव हमें अटूट साहस और शांति प्रदान करता है। 
            हे अग्नि, आप हमारे परम रक्षक हैं, हमें अज्ञान से ज्ञान की ओर और अंधकार से परम प्रकाश की ओर ले चलें। 
            हम आपकी इस दिव्य और महान शक्ति की बार-बार वंदना करते हैं और आपसे निरंतर संरक्षण की प्रार्थना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously protect us always from the terrible pit of sins and the calamities of ignorance. 
            Those forces that wish us harm, please foil their conspiracies and plots with your supreme and sharp intelligence. 
            O Ageless and Radiant Deity, consume all our internal flaws and weaknesses with your most intensely hot flames. 
            Your fire does not just destroy; it provides life with a new direction, a fresh purpose, and absolute purity. 
            We seek your refuge and pray for complete security, for you are the guardian and protector of all the worlds. 
            Grant us the inner strength to never walk the path of unrighteousness and to always stay within your divine laws. 
            Let your light create a protective shield around us that no evil or negative force can ever penetrate. 
            O Most Resplendent One, your flames are ever ready for the victory of Truth; please make us also warriors of Truth. 
            The experience of your protective power in every struggle of life gives us unbreakable courage and deep peace. 
            O Agni, you are our supreme protector; lead us from ignorance to knowledge and from darkness to supreme light. 
            We repeatedly bow before your divine and majestic power and pray for your constant and unwavering protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 88,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ८८ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी उत्तम आहुतियों को स्वीकार कर हमें उन शक्तियों से बचाएं जो हमसे द्वेष रखती हैं। 
            आपकी ऊर्जा हमें वह सामर्थ्य प्रदान करे जिससे हम जीवन की समस्त चुनौतियों का निर्भीकता से सामना कर सकें। 
            हमें वह आंतरिक शुद्धता दें जिससे हमारे मन में दूसरों के प्रति कभी भी संकीर्णता या घृणा का भाव न आए। 
            हे यविष्ठ्य, आपकी अक्षय शक्ति ही हमारे जीवन का आधार है, हमें अपनी दिव्य सामर्थ्य का अंश प्रदान करें। 
            यज्ञ में अर्पित हमारी प्रत्येक आहुति आपकी कृपा से ही सिद्ध होती है और हमें अभीष्ट फल की प्राप्ति कराती है। 
            आप हमारे जीवन को पूर्णतः सुरक्षित और समृद्ध बनाने के लिए अपनी पवित्र ज्योति का घेरा हमारे चारों ओर करें। 
            द्वेष की भावना मनुष्य की प्रगति को रोक देती है, आप हमें इस अंधकार से निकालकर सफलता की ओर ले चलें। 
            आपकी मित्रता हमारे लिए वह दिव्य सुरक्षा है जो हमारे मन के समस्त भय और दुखों को हर लेती है। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं ताकि हमारा जीवन सदैव सेवा और भक्ति में लगा रहे और हम ऊँचा उठें। 
            हे अग्नि, हमें वह तेज दें कि हम स्वयं को धर्म में प्रतिष्ठित रख सकें और मानवता की सेवा कर सकें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके सानिध्य में सदैव निर्भय होकर श्रेष्ठ जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our best offerings, protect us from those forces that harbor malice toward us. 
            May your energy provide us with the capability to face all of life's challenges with absolute fearlessness. 
            Grant us that internal purity which ensures that no narrowness or feeling of hatred ever arises in our minds toward others. 
            O Youngest One, your inexhaustible power is the foundation of our existence; grant us a portion of your divine strength. 
            Every oblation offered in the sacrifice is fulfilled by your grace and leads us to the achievement of our goals. 
            Create a circle of your sacred light around us to make our lives completely secure, protected, and prosperous. 
            The feeling of malice halts a person's progress; lead us out of this darkness and toward the path of success. 
            Your friendship is that divine security for us which takes away all the fears and sorrows of our wandering mind. 
            We pray to you with devotion so that our life remains dedicated to service and devotion, helping us to rise higher. 
            O Agni, give us the luster to keep ourselves established in Dharma and to serve humanity with all our heart. 
            May your merciful gaze remain upon us as we lead a superior and fearless life under your divine and holy presence.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 89,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ८९ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य के समान तेजस्वी और जीवनदायी ऐश्वर्य हमारे घर और हृदय में लेकर आएं। 
            आप हमें वह जीवनी शक्ति प्रदान करें जिससे हम लंबी आयु तक स्वस्थ और क्रियाशील रहकर श्रेष्ठ कर्म कर सकें। 
            आप स्वर्ग के अनुपम वैभव और समस्त ब्रह्मांडीय धन के अधिपति हैं, हमें वह सुख प्रदान करें जो अविनाशी हो। 
            हे पावक, आपकी पवित्रता हमारे रोम-रोम में समा जाए और हमें पूर्णतः निर्मल और कांतिवान बना दे। 
            आपकी कृपा से हमारे जीवन में किसी भी संसाधन की कमी न रहे और हम सदैव दूसरों के काम आ सकें। 
            आप केवल बाहरी धन ही नहीं, बल्कि वह प्रज्ञा और विवेक भी देते हैं जो हमें मोक्ष के मार्ग पर ले जाता है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा जीवन सदैव भक्ति और ज्ञान के प्रकाश से जगमगाता रहे। 
            हे देव, आप हमारे दुखों की काली छाया को समाप्त कर हमारे जीवन में हर्ष और आनंद का अमृत घोल दें। 
            आपकी दीप्ति हमारे अज्ञान को मिटाकर हमें वह स्पष्टता प्रदान करे जिससे हम ईश्वर की सत्ता को पहचान सकें। 
            हे अग्नि, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली और यशस्वी बनाएं। 
            हम आपकी इस विराट और भव्य महिमा को नमन करते हैं और आपके निरंतर आशीर्वाद की विनम्र कामना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our homes and hearts a splendor and prosperity as brilliant and life-giving as the Sun. 
            Provide us with the vital energy that allows us to stay healthy and active for a long life to perform noble deeds. 
            You are the sovereign lord of the unique abundance of heaven and all cosmic wealth; grant us joy that is imperishable. 
            O Purifier, let your holiness permeate every cell of our being, making us completely pure and radiant. 
            By your grace, let there be no lack of resources in our lives, ensuring we are always capable of serving others. 
            You do not just provide external wealth; you also grant that wisdom and discernment which lead us to liberation. 
            We constantly sing your glories so that our life remains forever illuminated with the light of devotion and knowledge. 
            O God, eliminate the dark shadows of our sorrows and infuse our lives with the nectar of joy and bliss. 
            Let your radiance erase our ignorance and grant us that clarity which enables us to recognize the Divine Reality. 
            O Agni, always remain with us as our protector and nourisher, making our lives magnificent, successful, and renowned. 
            We bow before your vast and grand majesty and humbly seek your continuous and loving divine blessings.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 90,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ९० ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय अनुष्ठानों के मुख्य पुरोहित और देवताओं को बुलाने वाले दिव्य दूत हैं। 
            आप हमारे बीच रहकर भी हमें स्वर्ग के देवताओं के साथ जोड़ते हैं, आप ही हम मनुष्यों के परम शुभचिंतक हैं। 
            आपकी उपस्थिति के बिना हमारा कोई भी यज्ञ या संकल्प पूर्ण नहीं हो सकता, क्योंकि आप ही उसकी शक्ति हैं। 
            हे देव, आप हमारे भीतर दिव्य प्रवृत्तियों का विकास करें और हमें बुराइयों के प्रभाव से सदैव सुरक्षित रखें। 
            आपकी हितकारी दृष्टि हमें पतन के मार्ग से हटाकर निरंतर प्रगति और उन्नति की दिशा में अग्रसर करती है। 
            जैसे अग्नि अशुद्ध सोने को तपाकर कुंदन बना देती है, वैसे ही आप हमारे कर्मों को शुद्ध और कल्याणकारी बना दें। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में शांति, समृद्धि और धर्मनिष्ठा के मुख्य आधार हैं। 
            आपकी ऊर्जा हमारे प्राणों में चेतना बनकर प्रवाहित होती है और हमें सदैव सत्य के मार्ग पर चलने की प्रेरणा देती है। 
            हे अग्नि, आप हमारे मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता का साक्षात् कर सकें। 
            आपकी कृपा से हमारा जीवन दिव्य आशीर्वादों से परिपूर्ण हो और हम सदैव लोक-कल्याण के कार्यों में लगे रहें। 
            इस संपूर्ण ब्रह्मांड में आपकी ही सत्ता और तेज व्याप्त है, हम आपकी शरण में आकर स्वयं को धन्य मानते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest of all human rituals and the divine messenger who invokes the gods. 
            While residing among us, you connect us with the celestial gods of heaven; you are our supreme well-wisher. 
            Without your presence, no sacrifice or resolution of ours can be completed, for you are its very power. 
            O God, develop divine tendencies within us and always keep us safe from the influence of evil and vice. 
            Your benevolent gaze steers us away from the path of downfall and leads us toward continuous progress and evolution. 
            Just as fire refines impure gold, please make our actions pure, holy, and beneficial for the entire world. 
            We worship you because you are the main foundation of peace, prosperity, and devotion within our families. 
            Your energy flows through our lives as consciousness, inspiring us to always walk the path of eternal Truth. 
            O Agni, become our guide and show us that Truth where we can realize the omnipresence of the Divine. 
            By your grace, let our lives be filled with divine blessings and let us stay engaged in acts of global welfare. 
            Your sovereign power and luster pervade this entire universe; by seeking your refuge, we consider ourselves blessed.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 91,
        sanskrit = "आ ते वत्सो मनो यमत् परमाच्चित् सधस्थात् ।\nअग्ने त्वां कामये गिरा ॥ ९१ ॥",
        hindiCommentary = """
            हे अग्निदेव! भक्त का मन और उसकी वाणी आपको सर्वोच्च धाम से अपने हृदय में बुलाने के लिए व्याकुल है। 
            जैसे वत्स (बछड़ा) अपनी माता के लिए पुकार लगाता है, वैसे ही हम अपनी पवित्र गिरा (वाणी) से आपकी कामना करते हैं। 
            आपकी दिव्यता हमारे जीवन को स्पर्श करे और हमारे अंतःकरण में ज्ञान का अखंड दीप प्रज्वलित कर दे। 
            हम संसार की नश्वर वस्तुओं के बजाय आपके शाश्वत प्रेम और सान्निध्य की ही निरंतर इच्छा रखते हैं। 
            हे देव, आप अपनी महिमा के शिखर से उतरकर हमारे तुच्छ जीवन को अपनी पावन उपस्थिति से कृतार्थ करें। 
            हमारी स्तुतियां केवल शब्द नहीं, बल्कि हमारे हृदय की वह पुकार हैं जो आपको आने के लिए विवश कर देती हैं। 
            आप ही वह परमानंद हैं जिसे प्राप्त करने के बाद मनुष्य को संसार में अन्य कुछ भी पाने की इच्छा नहीं रहती। 
            आपकी कृपा से हमारी वाणी में वह तेज और सत्यता आए कि वह सीधे आपके दिव्य कानों तक पहुँच सके। 
            हमें वह आध्यात्मिक प्यास दें जो केवल आपके सान्निध्य रूपी अमृत से ही शांत हो सके और हमें तृप्त करे। 
            हे अग्नि, आप हमारी प्रार्थनाओं को स्वीकार करें और हमारे जीवन को अपनी दिव्य चेतना से आलोकित करें। 
            हम आपकी बार-बार वंदना करते हैं और आपसे यही याचना करते हैं कि आप सदैव हमारे हृदय में विराजमान रहें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, the mind and voice of the devotee are restless to call you from your supreme abode into their heart. 
            Just as a calf (Vatsa) calls out for its mother, we intensely desire and seek you with our sacred and holy speech. 
            May your divinity touch our lives and ignite the eternal lamp of knowledge within our deepest consciousness. 
            Instead of worldly and perishable objects, we continuously long for your eternal love and divine presence. 
            O God, descend from the peak of your glory and bless our humble lives with your most sacred and holy presence. 
            Our praises are not just words; they are the desperate cries of our hearts that compel you to manifest here. 
            You are that supreme bliss after attaining which a human possesses no desire to attain anything else in the world. 
            By your grace, let our speech gain such brilliance and truth that it reaches directly into your divine ears. 
            Grant us that spiritual thirst which can only be quenched by the nectar of your presence and satisfy us. 
            O Agni, accept our humble prayers and illuminate our existence with your profound and divine consciousness. 
            We repeatedly adore you and pray that you remain forever established and seated within our hearts.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 92,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ९२ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त यज्ञों के अधिष्ठाता और देवताओं को आहुति प्रदान करने वाले मुख्य माध्यम हैं। 
            आप मनुष्यों के बीच रहकर भी दिव्य लोकों के दूत के रूप में हमारे समस्त कल्याणकारी कार्यों के साक्षी हैं। 
            आपकी सहायता के बिना कोई भी शुभ कर्म अपने श्रेष्ठ फल को प्राप्त नहीं कर सकता, आप ही यज्ञ की आधारशिला हैं। 
            हे देव, आप हमारे जीवन में देवताओं की शक्ति और मनुष्य की निष्ठा का सुंदर संगम स्थापित करने की कृपा करें। 
            आपकी हितकारी दृष्टि हमें स्वार्थ से ऊपर उठाकर परमार्थ के मार्ग पर चलने के लिए निरंतर प्रेरित करती रहती है। 
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे कर्मों को पवित्र और परोपकारी बना दें। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में अनुशासन, सुख और धर्मनिष्ठा के मुख्य संरक्षक हैं। 
            आपकी ऊर्जा हमारे शरीर में बल और मन में दृढ़ संकल्प बनकर बहती है, जिससे हम सदैव प्रगतिशील बने रहते हैं। 
            हे अग्नि, आप हमारे गुरु बनकर हमें वह ज्ञान प्रदान करें जिससे हम माया के बंधनों से मुक्त होकर ईश्वर को पा सकें। 
            आपकी कृपा से हमारा जीवन दिव्य आशीषों से भर जाए और हम सदैव सत्य के मार्ग पर अडिग होकर जीवन जिएं। 
            इस संपूर्ण सृष्टि में आपकी ही दिव्यता और शक्ति क्रियाशील है, हम आपकी शरण में आकर अत्यंत गौरव का अनुभव करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the presiding deity of all sacrifices and the chief medium for providing offerings to the gods. 
            While residing among humans as the messenger of celestial realms, you are the witness of all our noble deeds. 
            Without your assistance, no auspicious action can achieve its highest result; you are the foundation of ritual. 
            O God, please establish a beautiful union of divine power and human sincerity within our daily lives. 
            Your benevolent gaze constantly inspires us to rise above selfishness and walk the path of supreme altruism. 
            Just as fire consumes all impurities, please make our actions pure, holy, and dedicated to the welfare of others. 
            We worship you because you are the chief guardian of discipline, joy, and righteousness within our families. 
            Your energy flows as strength in our bodies and as firm resolve in our minds, keeping us forever progressive. 
            O Agni, become our teacher and grant us that wisdom which liberates us from the bonds of Maya to reach God. 
            By your grace, let our lives be filled with divine blessings and let us live staying firm on the path of Truth. 
            In this entire creation, your divinity and power are active; we feel immensely honored to seek your refuge.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 93,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ९३ ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन को क्रोध, संशय और द्वेष से मुक्त कर उसे गंगा के जल के समान पवित्र बना दें। 
            आप हमें वह दृढ़ श्रद्धा प्रदान करें जिससे हम ईश्वर की न्यायपूर्ण व्यवस्था पर विश्वास कर सकें और शांत रहें। 
            हमें उन सभी बाधाओं से सुरक्षित रखें जो हमारे मन में अविश्वास उत्पन्न कर हमें धर्म के मार्ग से विचलित करती हैं। 
            आपकी कृपा से ही मनुष्य का हृदय विशाल और दयालु बनता है, जिससे वह समस्त जीवों में ईश्वर के दर्शन करता है। 
            हे देव, श्रद्धा ही वह सेतु है जो जीव को शिव से जोड़ती है, कृपया हमारे भीतर इस श्रद्धा को सदैव जीवित रखें। 
            हम ईर्ष्या की जलन में जलने के बजाय आपकी ज्ञान की ज्योति में प्रकाशित होकर स्वयं का और जगत का कल्याण करें। 
            जब हमारा मन आपकी भक्ति में ओत-प्रोत होता है, तब संसार का कोई भी दुख हमें अपनी शांति से डिगा नहीं सकता। 
            आप ही वह शक्ति हैं जो हमारे भीतर की तामसी प्रवृत्तियों को नष्ट कर हमें सात्विक और तेजस्वी बनाती हैं। 
            हमें वह अभय और साहस प्रदान करें जिससे हम धर्म की मर्यादाओं का पालन करते हुए निर्भीक होकर जीवन जी सकें। 
            आपकी कृपा दृष्टि हम पर बनी रहे ताकि हम सदैव शुद्ध बने रहें और आपकी दिव्य उपस्थिति का अनुभव करते रहें। 
            हे अग्नि, हमारे मन को वह दिव्य वेदी बना दें जहाँ केवल शुभ संकल्पों और देवताओं की ही स्थापना हो।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please free our minds from anger, doubt, and malice, making them as pure as the water of Ganga. 
            Grant us that firm faith which allows us to trust in the just laws of the Divine and remain peaceful and calm. 
            Protect us from all obstacles that create distrust in our hearts and attempt to distract us from the path of Dharma. 
            It is only by your grace that a human heart becomes vast and compassionate, seeing God in every living being. 
            O God, faith is the bridge that connects the individual soul with the Divine; keep this faith alive within us forever. 
            Instead of burning in the heat of jealousy, let us be illuminated by your light to serve ourselves and the world. 
            When our mind is saturated with your devotion, no worldly sorrow can ever shake us from our inner peace. 
            You are the power that destroys our lower, dark tendencies and makes us virtuous, radiant, and spiritually bright. 
            Bestow upon us the fearlessness and courage to lead a bold life while strictly adhering to the boundaries of Dharma. 
            May your merciful gaze remain upon us so that we stay pure and continue to experience your divine presence. 
            O Agni, transform our mind into a divine altar where only noble resolutions and the presence of gods are established.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 94,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ९४ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक बंधनों से और अज्ञान रूपी अंधकार से सदैव सुरक्षित रखने की कृपा करें। 
            जो शक्तियाँ हमारी उन्नति में बाधक हैं या हमारा अहित चाहती हैं, आप अपने तेज से उनके प्रयासों को नष्ट कर दें। 
            हे अजर और अविनाशी देव, आप अपनी अत्यंत प्रखर ज्वालाओं से हमारे समस्त दोषों और विकारों को जला डालें। 
            आपकी अग्नि अशुद्धियों को नष्ट कर जीवन को नवीन ऊर्जा और पावनता से भर देने वाली है, हम आपकी शरण में हैं। 
            हमें वह सुरक्षा प्रदान करें जिससे हम निर्भय होकर अपने कर्तव्यों का पालन कर सकें और धर्म पर अडिग रहें। 
            पाप वह कीचड़ है जो आत्मा को मलिन कर देता है, आप अपने ज्ञान की अग्नि से हमें उससे पूर्णतः मुक्त कर दें। 
            आपकी ज्योति हमारे चारों ओर एक ऐसा सुरक्षा दुर्ग बनाए जिसमें केवल सात्विकता और शांति का ही प्रवेश हो। 
            हे तपिष्ठ, आपकी ज्वालाएं अन्याय और अधर्म के विरुद्ध काल के समान हैं, हमें सदैव न्याय के पक्ष में खड़ा रखें। 
            जीवन के प्रत्येक कठिन मोड़ पर आपकी रक्षात्मक शक्ति का अनुभव हमें असीम साहस और मानसिक शांति प्रदान करता है। 
            हे अग्नि, आप हमारे स्वामी और रक्षक हैं, हमें अंधकारमय अज्ञान से हटाकर परम सत्य के प्रकाश की ओर ले चलें। 
            हम आपकी इस दिव्य और भव्य महिमा की बार-बार वंदना करते हैं और आपसे निरंतर सुरक्षा और कल्याण की प्रार्थना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously protect us always from the terrible bonds of sins and the darkness of ignorance. 
            Those forces that are obstacles to our progress or wish us harm, destroy their efforts with your radiant luster. 
            O Ageless and Imperishable Deity, consume all our flaws and mental afflictions with your most intense flames. 
            Your fire destroys impurities and fills life with fresh energy and holiness; we seek your ultimate refuge. 
            Provide us with that security which allows us to perform our duties fearlessly and stay firm on the path of Dharma. 
            Sin is the mire that stains the soul; please free us completely from it with the fire of your eternal knowledge. 
            Let your light create such a fortress of security around us that only virtue and peace find their way inside. 
            O Most Resplendent One, your flames are like Time itself against injustice; keep us always on the side of Justice. 
            The experience of your protective power at every difficult turn of life gives us immense courage and mental peace. 
            O Agni, you are our Lord and Protector; lead us away from dark ignorance toward the light of the Supreme Truth. 
            We repeatedly bow before your divine and magnificent glory and pray for your constant protection and well-being.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 95,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ९५ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी श्रद्धापूर्ण आहुतियों को स्वीकार कर हमें ईर्ष्यालु शक्तियों से बचाएं। 
            आपकी ऊर्जा हमारे भीतर वह शक्ति भर दे जिससे हम शत्रुओं और बाधाओं के सामने कभी भी झुकें नहीं और विजयी हों। 
            हमें वह मानसिक शुद्धता और विशालता प्रदान करें जिससे हम सदैव दूसरों के प्रति मंगल कामना ही करें। 
            हे यविष्ठ्य, आपकी अक्षय शक्ति ही हमारे जीवन का संबल है, हमें अपनी दिव्य ऊर्जा का एक अंश प्रदान करने की कृपा करें। 
            यज्ञ की अग्नि में समर्पित प्रत्येक आहुति आपकी कृपा से ही सार्थक होती है और हमें दैवीय फल प्रदान करती है। 
            आप हमारे जीवन को पूर्णतः सुरक्षित और वैभवशाली बनाने के लिए अपनी पवित्र ज्योति का घेरा हमारे चारों ओर करें। 
            द्वेष वह दीमक है जो मनुष्य के यश को खा जाता है, आप हमें इस अंधकार से मुक्त कर यशस्वी और महान बनाएं। 
            आपकी मित्रता हमारे लिए वह सुरक्षा कवच है जो हमारे समस्त संशयों और भयों को जड़ से समाप्त कर देती है। 
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि हमारा जीवन सदैव लोकोपकार और भक्ति में लगा रहे और हम उन्नति करें। 
            हे अग्नि, हमें वह साहस दें कि हम स्वयं को अधर्म से बचा सकें और समाज में नैतिकता की स्थापना कर सकें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके संरक्षण में सदैव निर्भय होकर श्रेष्ठतम जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our devoted offerings, protect us from all envious and malicious forces. 
            May your energy fill us with the strength to never bow before enemies or hurdles and to emerge victorious. 
            Grant us that mental purity and vastness which ensure that we always harbor only well-wishes for others. 
            O Youngest One, your inexhaustible power is the support of our life; please grant us a portion of your divine energy. 
            Every oblation offered in the sacrificial fire becomes meaningful by your grace and grants us divine results. 
            Surround our lives with a circle of your holy light to make them completely secure, protected, and magnificent. 
            Malice is like a termite that consumes a person's fame; free us from this darkness and make us successful and great. 
            Your friendship is that protective shield for us which completely uproots all our doubts and deep-seated fears. 
            We worship you with devotion so that our life remains dedicated to public welfare and devotion, helping us to grow. 
            O Agni, give us the courage to protect ourselves from unrighteousness and to establish morality in the society. 
            May your merciful gaze remain upon us as we lead a superior and fearless life under your divine and holy protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 96,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ९६ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य के समान तेजस्वी और पोषण देने वाला ऐश्वर्य हमारे जीवन में लेकर आने की कृपा करें। 
            आप हमें वह ऊर्जा और स्वास्थ्य प्रदान करें जिससे हम लंबी आयु तक सक्रिय रहकर धर्म की सेवा कर सकें। 
            आप स्वर्ग के अद्भुत वैभव और समस्त दिव्य धन के स्वामी हैं, हमें वह संपत्ति दें जो हमारे मन को शांति दे। 
            हे पावक, आपकी पवित्रता हमारे अंतःकरण को पूर्णतः शुद्ध कर दे और हमें दैवीय आभा से आलोकित कर दे। 
            आपकी कृपा से हमारे जीवन में किसी भी वस्तु की कमी न रहे और हम सदैव दूसरों की सहायता करने में समर्थ हों। 
            आप केवल भौतिक सुख ही नहीं, बल्कि वह आत्मिक तेज भी प्रदान करते हैं जो हमें ईश्वर के साक्षात् का मार्ग दिखाता है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा हृदय सदैव भक्ति, ज्ञान और प्रेम के प्रकाश से भरा रहे। 
            हे देव, आप हमारे दुखों के अंधकार को अपनी प्रखर ज्योति से नष्ट कर हमारे जीवन में आनंद का संचार करें। 
            आपकी दीप्ति हमारे अज्ञान के पर्दों को हटाकर हमें वह स्पष्ट दृष्टि दे जिससे हम जीवन के सत्य को पहचान सकें। 
            हे अग्नि, आप हमारे रक्षक और दाता के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली और महान बनाने की कृपा करें। 
            हम आपकी इस भव्य और विराट महिमा को नमन करते हैं और आपके निरंतर आशीर्वाद की हृदय से कामना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, graciously bring into our lives a splendor and prosperity as brilliant and nourishing as the Sun. 
            Provide us with the energy and health that allow us to remain active for a long life to serve the cause of Dharma. 
            You are the master of the marvelous abundance of heaven and all divine wealth; grant us riches that give peace. 
            O Purifier, let your holiness completely purify our inner self and illuminate us with a divine and celestial aura. 
            By your grace, let there be no lack of any object in our lives, ensuring we are always capable of assisting others. 
            You do not just provide material comforts; you also grant that spiritual luster which shows the path to God. 
            We constantly sing your glories so that our hearts remain forever filled with the light of devotion, knowledge, and love. 
            O God, destroy the darkness of our sorrows with your intense light and infuse our lives with profound joy. 
            Let your radiance remove the veils of our ignorance and grant us clear vision to recognize the truth of existence. 
            O Agni, always stay with us as our protector and provider, graciously making our lives magnificent and great. 
            We bow before your grand and vast majesty and earnestly seek your continuous and loving divine blessings.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 97,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ ९७ ॥",
        hindiCommentary = """
            हे युवा अग्निदेव! आप समस्त प्रकार की समृद्धियों और पुष्टियों के आधार हैं, आप ही उन्हें अपनी शक्ति से पोषण देते हैं। 
            जब हम बार-बार आपकी स्तुति और वंदना करते हैं, तो हमारी बुद्धि भी व्यापक, उदार और श्रेष्ठ दिशा की ओर बढ़ने लगती है। 
            आपकी कृपा से हमारी प्रज्ञा प्रखर होती है और हम जीवन की कठिन चुनौतियों को भी सरलता से पार करने में सक्षम होते हैं। 
            हे यविष्ठ्य, आपकी ऊर्जा हमारे जीवन के प्रत्येक क्षेत्र में पूर्णता, संपन्नता और अखंड संतोष लाने का सामर्थ्य रखती है। 
            आपकी उपासना करने से हमारे संकल्प सिद्ध होते हैं और हमें सर्वांगीण विकास प्राप्त होता है, यही आपकी महानता है। 
            जैसे अग्नि समिधा पाकर और अधिक तेजस्वी होती है, वैसे ही हमारी आत्मा आपकी प्रेरणा से और अधिक बलवान और दिव्य होती है। 
            आप हमें वह मानसिक विशालता प्रदान करें जिससे हम संकुचित भावनाओं को त्यागकर विश्व-कल्याण के बारे में सोच सकें। 
            हमारी चेतना को उस उच्च स्तर तक उठाएं जहाँ हम ईश्वर की सर्वव्यापकता को प्रत्येक जीव और कण में देख सकें। 
            आप ही वह शक्ति हैं जो हमारे श्रम को ईश्वरीय फल में और हमारे जीवन को परम सफलता में बदलने का सामर्थ्य रखती हैं। 
            हे अग्नि, हम आपकी बार-बार वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट, समृद्ध और धर्ममय बना रहे। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपकी पवित्र ज्योति के सान्निध्य में सदैव सुखी और सुरक्षित रहें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful Agni, you are the foundation of all forms of prosperity and nourishment; you sustain them with your power. 
            As we repeatedly sing your praises and worship you, our intellect also grows vast, noble, and toward excellence. 
            By your grace, our wisdom becomes sharp, making us capable of easily overcoming even the toughest of life's challenges. 
            O Youngest One, your energy possesses the strength to bring completeness and abundance to every part of our lives. 
            Worshipping you ensures the fulfillment of our resolutions and grants us all-around growth; this is your greatness. 
            Just as fire blazes more radiantly when fueled, our soul becomes stronger and more vibrant under your inspiration. 
            Grant us that mental expansion which allows us to renounce narrow feelings and think about global welfare. 
            Elevate our consciousness to that high level where we can see the omnipresence of God in every living being. 
            You are the power that possesses the capacity to transform our labor into divine fruits and our life into success. 
            O Agni, we adore you repeatedly so that our lives remain nourished, prosperous, and righteous in every aspect. 
            May your merciful gaze always remain upon us as we stay happy and secure in the presence of your holy light.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 98,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ९८ ॥",
        hindiCommentary = """
            हे पावक अग्निदेव! आप दिव्य लोकों के स्वामी और समस्त चराचर जगत के ऐश्वर्यों के परम नियंत्रक और प्रदाता हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली प्रेरणा और अन्न लेकर आएं जो हमारे जीवन को सार्थक और सफल बनाए। 
            आपकी कृपा से हमारी निर्धनता का नाश हो और हम केवल भौतिक धन ही नहीं, बल्कि श्रेष्ठ गुणों के भी धनी बनें। 
            हे देव, आप हमारे अज्ञान को अपनी प्रखर ज्योति से जलाकर हमें वह सत्य मार्ग दिखाएं जहाँ केवल शांति और आनंद हो। 
            आप ही वह शक्ति हैं जो हमारे तुच्छ कर्मों को ईश्वरीय फल तक पहुँचाती हैं और हमारे मानवीय जीवन को कृतार्थ करती हैं। 
            हमें वह 'इषम्' प्रदान करें जिससे हमारे शरीर में नवीन उत्साह और मन में सदैव पवित्र विचारों का अखंड प्रवाह बना रहे। 
            आपकी महिमा का गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से जागृत होने लगते हैं। 
            हे अग्नि, आप हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता और अखंड सौभाग्य प्रदान करने की कृपा करें। 
            आपकी दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और कीर्ति का मार्ग दिखाए। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें वह स्थायी संपत्ति दें जो हमारे इस लोक और परलोक दोनों में सहायक हो। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके सान्निध्य में सदैव आनंदमयी, मंगलमय और धर्ममय जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Purifying Agni, you are the Lord of celestial realms and the controller and provider of all worldly riches. 
            For us, your devoted chanters, bring forth that powerful inspiration and nourishment that make our lives successful. 
            By your grace, let our poverty be destroyed, making us wealthy not just with money but with superior virtues. 
            O God, burn away our ignorance with your intense light and show us the path of truth where only peace and joy exist. 
            You are the power that carries our humble deeds to divine results and makes our human existence truly blessed. 
            Provide us with 'Isham' so that fresh enthusiasm remains in our bodies and pure thoughts flow in our minds. 
            Singing your glories purifies our inner self and initiates our spiritual awakening and growth toward the Divine. 
            O Agni, remove every lack from our lives and graciously grant us completeness and unbroken auspiciousness. 
            Let your radiance illuminate every dark corner of our existence and show us the pathway to fame and glory. 
            We pray with devotion to grant us that permanent wealth which assists us both in this world and the world beyond. 
            May your merciful gaze always remain upon us as we lead a joyful, auspicious, and righteous life under your protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 99,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ९९ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय अनुष्ठानों के मुख्य पुरोहित और देवताओं को आहुति पहुँचाने वाले दिव्य माध्यम हैं। 
            आप मनुष्यों के बीच रहकर भी हमारा संबंध स्वर्ग के देवताओं से जोड़ते हैं, आप ही हमारे सच्चे और परम हितैषी हैं। 
            आपकी उपस्थिति के बिना हमारा कोई भी यज्ञ या संकल्प पूर्ण नहीं हो सकता, क्योंकि आप ही यज्ञ का आधार और केंद्र हैं। 
            हे देव, आप हमारे भीतर दैवीय गुणों का संचार करें और हमें असुरत्व तथा बुराइयों के प्रभाव से सदैव बचाकर रखें। 
            आपकी हितकारी दृष्टि हमें पतन के मार्ग से हटाकर निरंतर प्रगति, आत्मोन्नति और सुख की दिशा में अग्रसर करती है। 
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे समस्त कर्मों को शुद्ध, पवित्र और कल्याणकारी बना दें। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में शांति, समृद्धि और धार्मिक निष्ठा के मुख्य स्तंभ हैं। 
            आपकी ऊर्जा हमारे प्राणों में चेतना बनकर बहती है और हमें सदैव सत्य और न्याय के मार्ग पर चलने की प्रेरणा देती है। 
            हे अग्नि, आप हमारे गुरु और मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता को देख सकें। 
            आपकी कृपा से हमारा जीवन दिव्य आशीषों से भरा रहे और हम सदैव मानवता की सेवा और धर्म की रक्षा में लगे रहें। 
            इस संपूर्ण ब्रह्मांड में आपकी ही सत्ता और आपका ही तेज व्याप्त है, हम आपकी शरण में आकर स्वयं को धन्य मानते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest of all human rituals and the divine medium that carries offerings to the gods. 
            While residing among us, you connect us with the celestial gods of heaven; you are our true and supreme well-wisher. 
            Without your presence, no sacrifice or resolution of ours can be completed, for you are the foundation and center. 
            O God, infuse our lives with divine qualities and always keep us safe from the influence of evil and demonic ways. 
            Your benevolent gaze steers us away from the path of downfall and leads us toward progress and self-evolution. 
            Just as fire consumes all impurities, please make our actions pure, holy, and beneficial for all living beings. 
            We worship you because you are the main pillar of peace, prosperity, and religious devotion within our families. 
            Your energy flows through our lives as consciousness, inspiring us to always walk the path of Truth and Justice. 
            O Agni, become our teacher and guide, showing us that Truth where we can realize the omnipresence of the Divine. 
            By your grace, let our lives be filled with divine blessings and let us stay engaged in service and Dharma. 
            Your sovereign power and luster pervade this entire universe; by seeking your refuge, we consider ourselves blessed.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 100,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ १०० ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन के समस्त द्वेष, क्रोध और अशांति को शांत कर उसे अत्यंत निर्मल और शांत बना दें। 
            आप हमें वह दृढ़ और अटल श्रद्धा प्रदान करें जिससे हम ईश्वर की न्याय व्यवस्था पर पूर्ण विश्वास कर सकें और सुखी रहें। 
            हमें उन सभी नकारात्मक शक्तियों से सुरक्षित रखें जो हमारे मार्ग में बाधा डालती हैं और हमें धर्म से डिगाना चाहती हैं। 
            आपकी कृपा से ही मनुष्य का हृदय समस्त जीवों के प्रति प्रेम और करुणा से भर जाता है, हमें भी वही विशाल हृदय दें। 
            हे देव, श्रद्धा ही वह कुंजी है जिससे ईश्वर के रहस्य प्रकट होते हैं, कृपया हमारे भीतर इस श्रद्धा को सदैव जीवित रखें। 
            हम ईर्ष्या की आग में जलने के बजाय आपके ज्ञान के प्रकाश में तपकर स्वयं को कुंदन की तरह श्रेष्ठ और तेजस्वी बनाएं। 
            जब हमारा मन आपकी भक्ति और प्रेम में डूबा होता है, तब संसार का कोई भी अभाव या दुख हमें विचलित नहीं कर सकता। 
            आप ही वह शक्ति हैं जो हमारे भीतर के अंधकार को नष्ट कर हमें आत्मज्ञान और ईश्वर के समीप ले जाने का मार्ग दिखाती हैं। 
            हमें वह साहस और अभय प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रहें और निर्भीक होकर जीवन जी सकें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम सदैव सात्विक बने रहें और ईश्वर के अनंत आनंद का अनुभव करते रहें। 
            हे अग्नि, हमारे मन को वह दिव्य मंदिर बना दें जहाँ केवल शुद्ध संकल्पों और देवताओं की ही स्थापना हो, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please calm all the malice, anger, and restlessness of our mind, making it extremely pure and serene. 
            Grant us that firm and unshakable faith which allows us to trust in the just laws of the Divine and remain happy. 
            Protect us from all negative forces that place hurdles in our path and attempt to sway us from the path of Dharma. 
            It is only by your grace that a human heart fills with love and compassion for all living beings; grant us such a heart. 
            O God, faith is the key that reveals the mysteries of the Divine; please keep this faith always alive within us. 
            Instead of burning in the fire of jealousy, let us be refined in the light of your wisdom like pure and radiant gold. 
            When our mind is immersed in your devotion and love, no worldly scarcity or sorrow can ever disturb our peace. 
            You are the power that destroys our inner darkness and shows us the path toward Self-realization and God. 
            Bestow upon us the courage and fearlessness required to always be ready for the protection of Dharma. 
            May your merciful gaze remain upon us so that we stay virtuous and experience the infinite bliss of God. 
            O Agni, transform our mind into a divine temple where only noble resolutions and the presence of gods reside.
        """.trimIndent()
    ),

)