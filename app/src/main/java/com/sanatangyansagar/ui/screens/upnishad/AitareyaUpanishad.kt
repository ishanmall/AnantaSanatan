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
data class AitareyaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AitareyaUpanishadScreen() {
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
                // Isha Upanishad has 18 Shlokas
                if (shlokaNumber != null && shlokaNumber in 1..18) {
                    coroutineScope.launch {
                        // -1 because list indices start at 0
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-18)") },
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
            itemsIndexed(aitareyaShlokasList) { _, shloka ->
                AitareyaShlokaCard(shloka)
            }
        }
    }
}

@Composable
fun AitareyaShlokaCard(shloka: AitareyaShloka) {
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


// Data List of Aitareya Upanishad - First 15 Shlokas
val aitareyaShlokasList = listOf(
    AitareyaShloka(
        id = 1,
        sanskrit = "ॐ आत्मा वा इदमेक एवाग्र आसीन्नान्यत् किञ्चन मिषत् । स ईक्षत लोकान्नु सृजा इति ॥ १ ॥",
        hindi = """
            सृष्टि के आरंभ में केवल एक आत्मा (परमात्मा) ही विद्यमान थी। उसके अतिरिक्त हलचल करने वाला या आँख झपकाने वाला दूसरा कुछ भी नहीं था। 
            उस परमात्मा ने विचार किया (ईक्षण किया): "अब मैं लोकों (संसार) की रचना करूँ।"
            यह ऐतरेय उपनिषद का प्रारंभिक श्लोक है जो अद्वैत (एक ईश्वर) के सिद्धांत को स्थापित करता है। 
            सृष्टि से पहले न तो कोई पदार्थ था, न समय, और न ही कोई और जीव। 
            संपूर्ण ब्रह्मांड एक अंधी या यांत्रिक प्रक्रिया का परिणाम नहीं है, बल्कि यह उस परम चेतना के एक सचेत 'विचार' या 'इच्छा' (स ईक्षत) का परिणाम है।
        """.trimIndent(),
        english = """
            In the beginning, this universe was the Self (Atman) alone; there was no other thing whatsoever that winked or moved. 
            He (the Self) thought: "Let me now create the worlds."
            This opening verse of the Aitareya Upanishad establishes the absolute non-dualistic (Advaita) nature of the Supreme. 
            Before creation, there was no matter, no time, and no separate entity. 
            The universe is not the result of a blind, mechanical accident, but the manifestation of a conscious 'thought' or 'will' of the Supreme Consciousness.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 2,
        sanskrit = "स इमाँल्लोकानसृजत । अम्भो मरीचीर्मापोऽदोऽम्भः परेण दिवं द्यौः प्रतिष्ठाऽन्तरिक्षं मरीचयः पृथिवी मरो या अधस्तात्ता आपः ॥ २ ॥",
        hindi = """
            तब उस परमात्मा ने इन लोकों की रचना की: अम्भः (स्वर्ग से ऊपर का जलमय लोक), मरीचि (अंतरिक्ष लोक), मर (पृथ्वी लोक), और आपः (पाताल या पृथ्वी के नीचे का जलमय लोक)।
            स्वर्ग (द्युलोक) उस 'अम्भ' लोक का आधार है। अंतरिक्ष 'मरीचि' है, पृथ्वी 'मर' (मरणशील) है, और पृथ्वी के नीचे 'आपः' है।
            यहाँ सृष्टि के ब्रह्मांडीय विभाजन का वर्णन किया गया है। 
            परमात्मा ने सबसे पहले रहने के लिए 'स्थान' या 'आयाम' (Dimensions) बनाए। 
            यह श्लोक प्राचीन वैदिक ब्रह्मांड विज्ञान (Cosmology) को दर्शाता है, जहाँ पूरे ब्रह्मांड को चार मुख्य परतों में विभाजित किया गया है।
        """.trimIndent(),
        english = """
            He created these worlds: Ambhas (the cosmic waters above heaven), Marichi (the space/light rays), Mara (the mortal earth), and Apas (the waters below the earth).
            Heaven is the support of Ambhas. The intermediate space is Marichi. The earth is Mara. The realms below the earth are Apas.
            This verse vividly describes the cosmic division and architectural blueprint of the creation. 
            The Supreme first created the 'spaces' or 'dimensions' for life to exist. 
            It reflects ancient Vedic cosmology, categorizing the vast universe into four primary experiential realms.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 3,
        sanskrit = "स ईक्षतेमे नु लोका लोकपालान्नु सृजा इति । सोऽद्भ्य एव पुरुषं समुद्धृत्यामूर्च्छयत् ॥ ३ ॥",
        hindi = """
            लोकों की रचना करने के बाद, परमात्मा ने विचार किया: "ये लोक तो बन गए, अब मैं इन लोकों के रक्षकों (लोकपालों) की रचना करूँ।" 
            तब उसने जल (पंचतत्वों) में से ही एक पुरुष (हिरण्यगर्भ या ब्रह्मांडीय पुरुष) को निकाला और उसे एक आकार (मूर्ति) प्रदान किया।
            केवल एक घर (संसार) बना लेना काफी नहीं था; उसे चलाने के लिए प्रशासकों की आवश्यकता थी।
            इसलिए परमात्मा ने भौतिक तत्वों (जल) को इकट्ठा करके एक 'ब्रह्मांडीय पुरुष' का निर्माण किया। 
            यह ब्रह्मांडीय पुरुष कोई आम इंसान नहीं, बल्कि संपूर्ण जीव-जगत का ब्लूप्रिंट (आधार) है।
        """.trimIndent(),
        english = """
            He (the Self) thought: "Here are the worlds. Let me now create the guardians of these worlds." 
            From the very cosmic waters, He drew forth a Person (Purusha) and gave him a distinct shape.
            Merely creating a house (the universe) was not enough; it required administrators or guardians to function.
            Therefore, the Supreme gathered the material elements (waters) and sculpted a 'Cosmic Person'. 
            This Purusha is not an ordinary human, but the foundational blueprint or archetype for all conscious life.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 4,
        sanskrit = "तमभ्यतपत्तस्याभितप्तस्य मुखं निरभिद्यत यथाण्डं मुखाद्वाग्वाचोऽग्निर्नासिके निरभिद्येतां नासिकाभ्यां प्राणः प्राणाद्वायुरक्षिणी निरभिद्येतामक्षिभ्यां चक्षुश्चक्षुष आदित्यः कर्णौ निरभिद्येतां कर्णाभ्यां श्रोत्रं श्रोत्राद्दिशस्त्वङ् निरभिद्यत त्वचो लोमानि लोमभ्य ओषधिवनस्पतयो हृदयं निरभिद्यत हृदयान्मनो मनसश्चन्द्रमा नाभिर्निरभिद्यत नाभ्या अपानोऽपानान्मृत्युः शिश्नं निरभिद्यत शिश्नाद्रेतो रेतस आपः ॥ ४ ॥",
        hindi = """
            परमात्मा ने उस पुरुष पर तप (संकल्प) किया। तप के प्रभाव से उस पुरुष का मुख अंडे की तरह फूटा। मुख से वाणी और वाणी से अग्नि उत्पन्न हुई।
            उसकी नाक के छिद्र खुले, नाक से प्राण और प्राण से वायु उत्पन्न हुई। आँखें खुलीं, आँखों से दृष्टि और दृष्टि से सूर्य प्रकट हुए।
            कान खुले, कानों से श्रवण शक्ति और उससे दिशाएं प्रकट हुईं। त्वचा खुली, त्वचा से रोम (बाल) और रोम से औषधियां-वनस्पतियां उत्पन्न हुईं।
            हृदय खुला, हृदय से मन और मन से चंद्रमा प्रकट हुआ। नाभि खुली, नाभि से अपान वायु और उससे मृत्यु उत्पन्न हुई। 
            जननेन्द्रिय खुली, उससे वीर्य और वीर्य से जल देवता उत्पन्न हुए।
            यह श्लोक बहुत महत्वपूर्ण है क्योंकि यह सूक्ष्म ब्रह्मांड (Microcosm - हमारा शरीर) और विशाल ब्रह्मांड (Macrocosm - प्रकृति) के बीच का सीधा संबंध स्थापित करता है।
        """.trimIndent(),
        english = """
            He brooded over that Purusha. As he was thus brooded over, his mouth burst open like an egg. From the mouth proceeded speech, and from speech, Fire (Agni).
            His nostrils burst open; from the nostrils proceeded breath, and from breath, Air (Vayu). His eyes burst open; from the eyes proceeded sight, and from sight, the Sun (Aditya).
            His ears burst open; from ears came hearing, and from hearing, the Directions. His skin burst open; from skin came hairs, and from hairs, plants and trees.
            His heart burst open; from the heart came the mind, and from the mind, the Moon. His navel burst open; from navel came the out-breath, and from that, Death.
            His generative organ burst open; from it came seed, and from seed, Water.
            This vital verse establishes the deep interconnectedness of the microcosm (the human body) and the macrocosm (the universe), showing how universal forces map directly onto human faculties.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 5,
        sanskrit = "ता एता देवताः सृष्टा अस्मिन्महत्यर्णवे प्रापतन् । तमशनायापिपासाभ्यामन्ववार्जत् । ता एनमब्रुवन्नायतनं नः प्रजानीहि यस्मिन्प्रतिष्ठिता अन्नमदामेति ॥ ५ ॥",
        hindi = """
            रची गई वे सभी देवता (अग्नि, वायु, सूर्य आदि) इस विशाल ब्रह्मांडीय सागर (संसार) में आ गिरे। 
            परमात्मा ने उन्हें भूख और प्यास से जोड़ दिया। उन देवताओं ने परमात्मा से कहा: "हमारे रहने के लिए कोई निश्चित स्थान (आयतन) बनाइए, जहाँ रहकर हम भोजन कर सकें।"
            देवता ब्रह्मांड की शक्तियां हैं, लेकिन शरीर के बिना वे कार्य नहीं कर सकते।
            'भूख और प्यास' यह दर्शाती है कि सृष्टि में हर शक्ति को ऊर्जा (भोजन) की आवश्यकता होती है।
            इसलिए देवताओं ने एक भौतिक शरीर की मांग की जिसके माध्यम से वे दुनिया का अनुभव कर सकें।
        """.trimIndent(),
        english = """
            These deities, having been created, fell into this great cosmic ocean. 
            The Supreme subjected them to hunger and thirst. The deities said to Him: "Please ordain a specific abode for us, wherein established, we may eat our food."
            The deities represent cosmic forces, but without a physical medium, they cannot function or experience existence.
            'Hunger and thirst' symbolize the universal law that all created entities require continuous energy to sustain themselves.
            Thus, the cosmic forces demanded a biological form through which they could interact with the world.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 6,
        sanskrit = "ताभ्यो गामानयत्ता अब्रुवन्न वै नोऽयमलमिति । ताभ्योऽश्वमानयत्ता अब्रुवन्न वै नोऽयमलमिति ॥ ६ ॥",
        hindi = """
            परमात्मा ने उनके निवास के लिए एक गाय (का शरीर) लाकर दिया। देवताओं ने कहा: "यह हमारे लिए पर्याप्त नहीं है।" 
            फिर परमात्मा ने एक घोड़े (का शरीर) लाकर दिया। देवताओं ने फिर कहा: "यह भी हमारे लिए पर्याप्त नहीं है।"
            यहाँ विकास (Evolution) की एक बहुत ही प्रतीकात्मक कथा है। 
            देवताओं (चेतना की शक्तियों) को पशुओं के शरीर दिए गए, लेकिन जानवरों की चेतना और बुद्धि सीमित होती है। 
            जानवर केवल अपनी मूल प्रवृत्तियों (खाने, सोने) तक सीमित रहते हैं। वे उच्च आध्यात्मिक ज्ञान प्राप्त नहीं कर सकते, इसलिए देवताओं ने उन्हें अस्वीकार कर दिया।
        """.trimIndent(),
        english = """
            He brought a cow (its physical form) to them. They said: "This is indeed not sufficient for us." 
            He then brought a horse to them. They again said: "This is indeed not sufficient for us."
            This verse presents a highly symbolic story of biological and spiritual evolution. 
            The cosmic forces were offered animal bodies, but animals have a limited spectrum of consciousness. 
            Animals operate strictly on basic survival instincts and lack the profound intellect needed for Self-realization, which is why the gods rejected them.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 7,
        sanskrit = "ताभ्यः पुरुषमानयत्ता अब्रुवन् सुकृतं बतेति पुरुषो वाव सुकृतम् । ता अब्रवीद्यथायतनं प्रविशतेति ॥ ७ ॥",
        hindi = """
            अंत में, परमात्मा ने उनके सामने एक पुरुष (मनुष्य का शरीर) प्रस्तुत किया। उसे देखकर देवता खुशी से बोल उठे: "अहा! यह बहुत ही सुंदर रचना है।" (मनुष्य वास्तव में एक उत्तम रचना है)। 
            परमात्मा ने उनसे कहा: "अब तुम अपने-अपने उचित स्थानों में प्रवेश कर जाओ।"
            मानव शरीर को 'सुकृतम्' (उत्तम कृति या मास्टरपीस) कहा गया है। 
            केवल मनुष्य के पास ही वह विकसित मस्तिष्क, विवेक और चेतना है जो ब्रह्मांड की सभी शक्तियों को पूर्ण रूप से धारण कर सकती है।
            मनुष्य का शरीर ही वह एकमात्र साधन है जिससे मोक्ष (मुक्ति) प्राप्त किया जा सकता है।
        """.trimIndent(),
        english = """
            Finally, He brought a human form (Purusha) to them. Seeing it, they joyfully exclaimed: "Oh, well done! Man is indeed a masterpiece." 
            He (the Creator) said to them: "Enter into your respective abodes."
            The human body is unequivocally declared 'Sukritam' (a masterpiece or perfect creation). 
            Only the human form possesses the highly evolved nervous system, intellect, and self-awareness required to fully express cosmic powers.
            The human body is the supreme vehicle through which spiritual liberation (Moksha) can be achieved.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 8,
        sanskrit = "अग्निर्वाग्भूत्वा मुखं प्राविशद्वायुः प्राणो भूत्वा नासिके प्राविशदादित्यश्चक्षुर्भूत्वाऽक्षिणी प्राविशद्दिशः श्रोत्रं भूत्वा कर्णौ प्राविशन्नोषधिवनस्पतयो लोमानि भूत्वा त्वचं प्राविशंश्चन्द्रमा मनो भूत्वा हृदयं प्राविशन्मृत्युरपानो भूत्वा नाभिं प्राविशदापो रेतो भूत्वा शिश्नं प्राविशन् ॥ ८ ॥",
        hindi = """
            तब अग्नि देव वाणी (आवाज़) बनकर मुख में प्रवेश कर गए। वायु देव प्राण (श्वास) बनकर नाक में प्रवेश कर गए। 
            सूर्य देव दृष्टि बनकर आँखों में प्रवेश कर गए। दिशाएं सुनने की शक्ति बनकर कानों में प्रवेश कर गईं। 
            औषधियां और वनस्पतियां बाल बनकर त्वचा में प्रवेश कर गईं। चंद्रमा मन बनकर हृदय में प्रवेश कर गया। 
            मृत्यु अपान वायु (बाहर निकलने वाली सांस) बनकर नाभि में प्रवेश कर गई। और जल वीर्य बनकर जननेन्द्रिय में प्रवेश कर गया।
            यह श्लोक प्रमाणित करता है कि हमारे शरीर का संचालन ब्रह्मांडीय देवता ही कर रहे हैं। हम स्वतंत्र नहीं हैं, बल्कि प्रकृति की महान शक्तियों का एक लघु रूप हैं।
        """.trimIndent(),
        english = """
            Fire became speech and entered the mouth. Air became breath and entered the nostrils. 
            The Sun became sight and entered the eyes. The Directions became hearing and entered the ears. 
            Plants and trees became hairs and entered the skin. The Moon became the mind and entered the heart. 
            Death became the out-breath and entered the navel. Water became seed and entered the generative organ.
            This confirms that the cosmic deities literally operate our bodies. We are not isolated entities, but a perfect miniature replica of the vast universe, functioning through nature's forces.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 9,
        sanskrit = "तमशनायापिपासे अब्रूतामावाभ्यामभिप्रजानीहीति ते अब्रवीदेतास्वेव वां देवतास्वाभजाम्येतासु भागिन्यौ करोमीति । तस्माद्यस्यै कस्यै च देवतायै हविर्गृह्यते भागिन्यावेवास्यामशनायापिपासे भवतः ॥ ९ ॥",
        hindi = """
            तब भूख और प्यास ने परमात्मा से कहा: "हमारे लिए भी कोई स्थान निश्चित कीजिए।" 
            परमात्मा ने उनसे कहा: "मैं तुम्हें इन देवताओं के भीतर ही स्थान देता हूँ और तुम्हें इनका हिस्सेदार बनाता हूँ।" 
            यही कारण है कि जब भी किसी देवता को आहुति (भोजन/हवि) दी जाती है, तो उसमें भूख और प्यास को उनका हिस्सा स्वतः ही मिल जाता है।
            भूख और प्यास का कोई अपना अलग अंग नहीं होता, वे हर अंग और पूरी चेतना में व्याप्त रहते हैं। 
            यह एक दार्शनिक तथ्य है कि जब तक शरीर और इंद्रियां हैं, तब तक इच्छाएं, भूख और प्यास भी उनके साथ-साथ रहेंगी।
        """.trimIndent(),
        english = """
            Then Hunger and Thirst said to Him: "Please assign a place for us as well." 
            He told them: "I assign you a place right within these deities and make you co-sharers with them." 
            Therefore, to whatever deity an offering is made, hunger and thirst automatically become sharers in it.
            Hunger and thirst do not have isolated organs; they permeate the entire physical system. 
            This represents the philosophical truth that as long as physical senses and the body exist, fundamental desires and needs will perpetually accompany them.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 10,
        sanskrit = "स ईक्षतेमे नु लोकाश्च लोकपालाश्चान्नमेभ्यः सृजा इति ॥ १० ॥",
        hindi = """
            (शरीर और देवताओं के स्थापित होने के बाद) परमात्मा ने विचार किया: 
            "ये लोक (रहने की जगह) और लोकपाल (देवता और जीव) तो बन गए, अब मुझे इनके लिए अन्न (भोजन) की रचना करनी चाहिए।"
            जीवन की गाड़ी बिना ईंधन के नहीं चल सकती। शरीर और उसके अंदर बैठी शक्तियों को जीवित रहने के लिए बाहरी पोषण की आवश्यकता थी। 
            यह श्लोक सृष्टि के दूसरे चरण—भोजन और प्रकृति के निर्माण—की शुरुआत का प्रतीक है।
        """.trimIndent(),
        english = """
            (After the bodies and deities were established) The Creator thought: 
            "Here are the worlds and their guardians. Let me now create food for them."
            The machinery of life cannot run without fuel. The biological bodies and the cosmic forces residing within required external nourishment to survive. 
            This verse marks the initiation of the next phase of creation—the manifestation of sustenance and nature.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 11,
        sanskrit = "सोऽपोऽभ्यतपत्ताभ्योऽभितप्ताभ्यो मूर्तिरजायत । या वै सा मूर्तिरजायतान्नं वै तत् ॥ ११ ॥",
        hindi = """
            उस परमात्मा ने जल (पंच महाभूतों) पर तप (विचार/संकल्प) किया। उस तप के प्रभाव से जल से एक 'मूर्ति' (ठोस रूप) उत्पन्न हुई। 
            वह जो मूर्ति उत्पन्न हुई, वही वास्तव में अन्न (भोजन) है।
            यहाँ 'जल' से अर्थ केवल पानी नहीं, बल्कि सृष्टि के प्राथमिक मूल तत्व हैं। 
            विचार की ऊष्मा (तप) से ही तरल और गैसीय तत्वों ने ठोस आकार (वनस्पतियां, फल, अनाज) ले लिया।
            अन्न ही वह ठोस पदार्थ है जो जीवन को बनाए रखता है।
        """.trimIndent(),
        english = """
            He brooded over the waters (the primal elements). From the waters thus brooded over, a solid form (Murti) emerged. 
            That specific form which was born is, verily, food.
            Here, 'waters' refers to the primary, unformed elements of the universe. 
            Through the heat of conscious will (Tapas), the subtle elements condensed into solid, tangible matter (plants, grains, fruits). 
            Food is the crystallized physical matter that sustains biological life.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 12,
        sanskrit = "तदेनत्सृष्टं पराङ्त्यजिघांसत्तद्वाचाऽजिघृक्षत् तन्नाशक्नोद्वाचा ग्रहीतुम् । स यद्धैनद्वाचाऽग्रहैष्यदभिव्याहृत्य हैवान्नमत्रप्स्यत् ॥ १२ ॥",
        hindi = """
            वह अन्न उत्पन्न होते ही डरकर जीव से दूर भागने लगा। उस पुरुष (जीव) ने उसे अपनी वाणी (बोलकर) से पकड़ना चाहा, लेकिन वह उसे वाणी से नहीं पकड़ सका। 
            यदि वह अन्न को वाणी से पकड़ लेता, तो मनुष्य केवल अन्न का नाम लेकर (या उसके बारे में बात करके) ही तृप्त हो जाता (उसकी भूख मिट जाती)।
            यहाँ से एक बहुत ही रोचक प्रतीकात्मक कथा शुरू होती है जहाँ जीव अपनी अलग-अलग इंद्रियों से भोजन को ग्रहण करने का प्रयास करता है।
            हम केवल भोजन के बारे में बातें करके अपनी भूख नहीं मिटा सकते।
        """.trimIndent(),
        english = """
            That food, being created, tried to run away from him. The Person (Jiva) tried to grasp it with speech, but could not. 
            If he had grasped it with speech, a man would be completely satisfied merely by talking about food.
            This begins a highly fascinating, allegorical sequence where the human entity attempts to consume food using different senses.
            Obviously, we cannot satisfy our physical hunger simply by having a conversation about a meal.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 13,
        sanskrit = "तत्प्राणेनाजिघृक्षत् तन्नाशक्नोत्प्राणेन ग्रहीतुम् । स यद्धैनत्प्राणेनाग्रहैष्यदभिप्राण्य हैवान्नमत्रप्स्यत् ॥ १३ ॥",
        hindi = """
            फिर उसने उस अन्न को प्राण (नाक/सूँघकर) से पकड़ना चाहा, लेकिन वह उसे प्राण से नहीं पकड़ सका। 
            यदि वह अन्न को प्राण से पकड़ लेता, तो मनुष्य केवल अन्न को सूँघकर ही तृप्त हो जाता।
            भोजन की खुशबू हमें आकर्षित तो कर सकती है, लेकिन वह हमारे शरीर को पोषण नहीं दे सकती।
            सूँघने की शक्ति (प्राण/वायु) भोजन को पचाने का साधन नहीं है।
        """.trimIndent(),
        english = """
            He then tried to grasp it with his breath (sense of smell), but could not grasp it with breath. 
            If he had grasped it with breath, a man would be satisfied merely by smelling food.
            While the aroma of a delicious dish can stimulate the appetite, it cannot provide actual biological nourishment. 
            The olfactory sense (smell) is not the correct instrument for consumption.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 14,
        sanskrit = "तच्चक्षुषाऽजिघृक्षत् तन्नाशक्नोच्चक्षुषा ग्रहीतुम् । स यद्धैनच्चक्षुषाऽग्रहैष्यद्दृष्ट्वा हैवान्नमत्रप्स्यत् ॥ १४ ॥",
        hindi = """
            फिर उसने उस अन्न को आँखों (देखकर) से पकड़ना चाहा, लेकिन वह उसे आँखों से भी नहीं पकड़ सका। 
            यदि वह अन्न को आँखों से पकड़ लेता, तो मनुष्य केवल अन्न को देखकर ही तृप्त हो जाता।
            आँखें केवल भोजन के रूप और रंग का अनुभव कर सकती हैं। 
            हम एक शानदार दावत को देखकर खुश हो सकते हैं, लेकिन देखने मात्र से पेट नहीं भरता।
        """.trimIndent(),
        english = """
            He tried to grasp it with his eyes, but could not grasp it with sight. 
            If he had grasped it with his eyes, a man would be satisfied merely by looking at food.
            The eyes can only perceive the form, color, and aesthetic presentation of the food. 
            We may visually enjoy looking at a grand feast, but visual perception alone does not quench physiological hunger.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 15,
        sanskrit = "तच्छ्रोत्रेणाजिघृक्षत् तन्नाशक्नोच्छ्रोत्रेण ग्रहीतुम् । स यद्धैनच्छ्रोत्रेणाग्रहैष्यच्छ्रुत्वा हैवान्नमत्रप्स्यत् ॥ १५ ॥",
        hindi = """
            फिर उसने उस अन्न को कानों (सुनकर) से पकड़ना चाहा, लेकिन वह उसे कानों से भी नहीं पकड़ सका। 
            यदि वह अन्न को कानों से पकड़ लेता, तो मनुष्य केवल अन्न के बारे में सुनकर ही तृप्त हो जाता।
            कानों का काम केवल ध्वनि ग्रहण करना है। खाना पकने की आवाज़ सुनकर भूख मिटना असंभव है। 
            उपनिषद यहाँ बहुत तार्किक ढंग से बता रहा है कि हर इंद्रिय का अपना एक विशिष्ट कार्य होता है और वे एक-दूसरे का काम नहीं कर सकतीं।
        """.trimIndent(),
        english = """
            He tried to grasp it with his ears, but could not grasp it with hearing. 
            If he had grasped it with his ears, a man would be satisfied merely by hearing about food.
            The auditory sense is strictly limited to sound. Hearing the sizzling sound of cooking cannot nourish the body. 
            The Upanishad is logically demonstrating that every single sense organ has a highly specific, non-interchangeable function.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 16,
        sanskrit = "तन्त्वचाऽजिघृक्षत् तन्नाशक्नोत्त्वचा ग्रहीतुम् । स यद्धैनत्त्वचाऽग्रहैष्यत् स्पृष्ट्वा हैवान्नमत्रप्स्यत् ॥ १६ ॥",
        hindi = """
            फिर उसने उस अन्न को त्वचा (छूकर) से पकड़ना चाहा, लेकिन वह उसे त्वचा से भी नहीं पकड़ सका। 
            यदि वह अन्न को त्वचा से पकड़ लेता, तो मनुष्य केवल अन्न को स्पर्श करके ही तृप्त हो जाता।
            त्वचा का कार्य केवल स्पर्श (ठंडा, गरम, कठोर, मुलायम) का अनुभव करना है। 
            भोजन को केवल छू लेने से शरीर को ऊर्जा या पोषण प्राप्त नहीं होता।
        """.trimIndent(),
        english = """
            He tried to grasp it with his skin (touch), but could not grasp it with touch. 
            If he had grasped it with his skin, a man would be satisfied merely by touching food.
            The skin's function is purely tactile, meant to sense temperature and texture. 
            Simply making physical contact with food does not transfer nutritional energy into the body.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 17,
        sanskrit = "तन्मनसाऽजिघृक्षत् तन्नाशक्नोन्मनसा ग्रहीतुम् । स यद्धैनन्मनसाऽग्रहैष्यद्ध्यात्वा हैवान्नमत्रप्स्यत् ॥ १७ ॥",
        hindi = """
            फिर उसने उस अन्न को मन (विचार या कल्पना) से पकड़ना चाहा, लेकिन वह उसे मन से भी नहीं पकड़ सका। 
            यदि वह अन्न को मन से पकड़ लेता, तो मनुष्य केवल भोजन का विचार (ध्यान) करके ही तृप्त हो जाता।
            हम ख्यालों में कितने भी स्वादिष्ट व्यंजनों का आनंद ले लें, उससे हमारा शारीरिक पेट नहीं भरता। 
            मन सूक्ष्म है और भौतिक अन्न को ग्रहण नहीं कर सकता।
        """.trimIndent(),
        english = """
            He tried to grasp it with his mind, but could not grasp it with the mind. 
            If he had grasped it with his mind, a man would be satisfied merely by thinking about food.
            No matter how vividly we imagine a delicious meal, our physiological hunger remains unfulfilled. 
            The subtle mind cannot consume gross, physical matter.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 18,
        sanskrit = "तच्छिश्नेनाजिघृक्षत् तन्नाशक्नोच्छिश्नेन ग्रहीतुम् । स यद्धैनच्छिश्नेनाग्रहैष्यद्विसृज्य हैवान्नमत्रप्स्यत् ॥ १८ ॥",
        hindi = """
            फिर उसने उस अन्न को जननेन्द्रिय (प्रजनन अंग) से पकड़ना चाहा, लेकिन वह उसे उससे भी नहीं पकड़ सका। 
            यदि वह अन्न को उससे पकड़ लेता, तो मनुष्य केवल उत्सर्जन या त्याग करके ही तृप्त हो जाता।
            प्रजनन अंगों का कार्य रचना और उत्सर्जन है, ग्रहण करना नहीं। 
            इसलिए यह अंग भी जीवन रक्षक ऊर्जा (भोजन) को शरीर के भीतर नहीं ले जा सका।
        """.trimIndent(),
        english = """
            He tried to grasp it with the generative organ, but could not grasp it with that organ. 
            If he had grasped it thus, a man would be satisfied merely by emission.
            The reproductive and excretory organs are designed for creation and expulsion, not for ingestion. 
            Therefore, this faculty also failed to absorb the life-sustaining energy of food.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 19,
        sanskrit = "तदपानेनाजिघृक्षत् तदावयत् सैषोऽन्नस्य ग्रहो यद्वायुरन्नायुर्वा एष यद्वायुः ॥ १९ ॥",
        hindi = """
            अंततः, उसने उस अन्न को 'अपान वायु' (पाचन तंत्र/निगलने की क्रिया) से पकड़ना चाहा, और तब उसने उसे पकड़ लिया (ग्रहण कर लिया)। 
            यही अपान वायु अन्न को ग्रहण करने वाला (अन्न का ग्राहक) है। यह वायु ही अन्न के द्वारा जीवन को बनाए रखने वाला है।
            आठवें प्रयास में सफलता मिली! अपान वह शक्ति है जो भोजन को शरीर के अंदर खींचती है और पचाती है। 
            मुंह से लेकर पेट तक की यह पूरी प्रणाली ही वास्तव में भोजन ग्रहण करने का सही मार्ग है।
        """.trimIndent(),
        english = """
            Finally, he tried to grasp it with the 'Apana' breath (the downward digestive breath/swallowing action), and he successfully grasped it. 
            This Apana is the true receiver of food. It is this specific vital air that sustains life through the assimilation of food.
            Success on the eighth attempt! Apana is the vital force responsible for drawing food inward and digesting it. 
            The Upanishad brilliantly illustrates that only the digestive system is scientifically and spiritually designed to process nourishment.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 20,
        sanskrit = "स ईक्षत कथं न्विदं मदृते स्यादिति स ईक्षत कतरेण प्रपद्या इति । स ईक्षत यदि वाचाऽभिव्याहृतं यदि प्राणेनाभिप्राणितं यदि चक्षुषा दृष्टं यदि श्रोत्रेण श्रुतं यदि त्वचा स्पृष्टं यदि मनसा ध्यातं यद्यपानेनाभ्यपानितं यदि शिश्नेन विसृष्टमथ कोऽहमिति ॥ २० ॥",
        hindi = """
            तब उस परमात्मा ने विचार किया: "मेरे बिना यह शरीर और ये इंद्रियां कैसे अस्तित्व में रह सकती हैं?" 
            उसने सोचा: "मैं इस शरीर में किस मार्ग से प्रवेश करूँ?" 
            परमात्मा ने आगे विचार किया: "यदि वाणी बोलने का काम कर लेगी, प्राण सूँघ लेगा, आँखें देख लेंगी, कान सुन लेंगे, त्वचा स्पर्श कर लेगी, मन सोच लेगा, अपान पचा लेगा और जननेन्द्रिय अपना काम कर लेगी, तो फिर 'मैं' कौन हूँ? (मेरा क्या काम है?)"
            यह एक अत्यंत गहरा आत्म-मंथन है। यदि शरीर एक मशीन की तरह अपने आप चल रहा है, तो फिर आत्मा की क्या आवश्यकता है? 
            उत्तर यह है कि इंद्रियां केवल उपकरण हैं। उनके पीछे एक 'अनुभव करने वाला' (चेतना) होना चाहिए, जो इन सबका साक्षी हो।
        """.trimIndent(),
        english = """
            The Supreme Self then reflected: "How could all this exist without me?" 
            He pondered: "By which route should I enter this body?" 
            He further reasoned: "If speech is done by the tongue, smelling by breath, seeing by eyes, hearing by ears, touching by skin, thinking by mind, digesting by Apana, and emission by the generative organ, then who am I? (What is my purpose?)"
            This is a profound philosophical inquiry. If the body is just a self-sustaining biological machine, what is the role of the soul? 
            The conclusion is that the senses are mere mechanical instruments. There must be an underlying conscious 'Experiencer' witnessing all these activities.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 21,
        sanskrit = "स एतमेव सीमानं विदार्यैतया द्वारा प्रापद्यत । सैषा विदृतिर्नाम द्वास्तदेतन्नान्दनम् ॥ २१ ॥",
        hindi = """
            तब उस परमात्मा ने सिर के ऊपरी हिस्से (सीमान/कपाल) को चीरकर, उस द्वार से शरीर में प्रवेश किया। 
            इसे 'विदृति' (चीरा हुआ द्वार या ब्रह्मरंध्र) कहा जाता है। यह द्वार अत्यंत आनंद का स्थान (नान्दनम्) है।
            योग विज्ञान में इसे 'सहस्रार चक्र' या 'ब्रह्मरंध्र' (खोपड़ी का सबसे ऊपरी भाग) कहा जाता है। 
            परमात्मा इंद्रियों के मार्ग से नहीं, बल्कि सीधे चेतना के सर्वोच्च शिखर से शरीर में प्रविष्ट हुआ। 
            जब ध्यानी व्यक्ति अपनी चेतना को वापस इसी बिंदु पर ले जाता है, तो उसे परम आनंद (नान्दन) की प्राप्ति होती है।
        """.trimIndent(),
        english = """
            Then, piercing the top of the skull (the sagittal suture), the Supreme Self entered the body through that door. 
            This door is known as 'Vidriti' (the cleft or Brahmarandhra). It is the supreme dwelling place of joy (Nandanam).
            In yogic science, this is known as the 'Sahasrara Chakra' or the crown of the head. 
            The Supreme did not enter through the sensory organs, but through the highest peak of consciousness. 
            When a meditator elevates their awareness back to this exact point, they experience absolute, transcendental bliss.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 22,
        sanskrit = "तस्य त्रय आवसथास्त्रयः स्वप्ना अयमावसथोऽयमावसथोऽयमावसथ इति ॥ २२ ॥",
        hindi = """
            उस परमात्मा (आत्मा) के इस शरीर में तीन निवास स्थान (आवसथ) हैं, और तीन प्रकार की स्वप्न (चेतना की) अवस्थाएं हैं। 
            ये तीन स्थान हैं: (१) दाहिनी आँख (जाग्रत अवस्था में), (२) मन (स्वप्न अवस्था में), और (३) हृदय का आकाश (गहरी नींद या सुषुप्ति अवस्था में)।
            भले ही आत्मा पूरे शरीर में है, लेकिन यह इन तीन केंद्रों से अलग-अलग अवस्थाओं में दुनिया का अनुभव करती है। 
            जागते समय हम बाहरी दुनिया देखते हैं, सोते समय सपनों की दुनिया, और गहरी नींद में हम सब कुछ भूलकर अज्ञान (अंधकार) में रहते हैं। 
            उपनिषद इन्हें 'स्वप्न' कहता है क्योंकि परमसत्य (तुरीय अवस्था) के सामने ये तीनों अवस्थाएं एक भ्रम (सपने) के समान हैं।
        """.trimIndent(),
        english = """
            For that Self, there are three abodes within this body, and three states of dream (consciousness). 
            These three abodes are: (1) the right eye (during the waking state), (2) the inner mind (during the dream state), and (3) the cavity of the heart (during deep sleep).
            Although the soul permeates the entire body, it primarily operates from these three centers to experience different states of reality. 
            While awake, we perceive the external world; in dreams, the internal world; and in deep sleep, a state of blank ignorance. 
            The Upanishad remarkably calls all three states 'dreams' because, compared to absolute spiritual enlightenment (Turiya), even our waking life is merely an illusion.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 23,
        sanskrit = "स जातो भूतान्यभिव्यैख्यत् किमिहान्यं वावदिषदिति । स एतमेव पुरुषं ब्रह्म ततममपश्यदिदमदर्शमिती३ ॥ २३ ॥",
        hindi = """
            शरीर में प्रविष्ट होकर (जन्म लेकर), उस जीवात्मा ने सभी प्राणियों और पदार्थों को चारों ओर देखा, और सोचा: "यहाँ मैं अपने से अलग और किसे कहूँ?" (सब कुछ तो एक ही है)। 
            तब उसने इसी पुरुष (आत्मा) को सर्वव्यापी ब्रह्म के रूप में देखा और आश्चर्य से कहा: "अहा! मैंने इसे (इदम्) देख लिया (अदर्शम्)।"
            जब आत्मा शरीर में आती है, तो शुरुआत में उसे लगता है कि दुनिया अलग है और वह अलग है। 
            लेकिन जब ज्ञानोदय होता है, तो वह पहचान लेती है कि जो शक्ति उसके भीतर है, वही पूरे ब्रह्मांड में फैली हुई है (ब्रह्म ततमम्)। 
            यह ज्ञान की पराकाष्ठा है—"मैंने उस परम सत्य को देख लिया!"
        """.trimIndent(),
        english = """
            Having been born (entering the body), the soul looked around at all beings and things, reflecting: "What else is there here for me to speak of as different from me?" 
            Then, he clearly perceived this very Person (the Self) as the all-pervading Brahman, exclaiming in wonder: "Ah! I have seen This (Idam adarsham)!"
            When consciousness embodies itself, it initially suffers from the illusion of duality and separation. 
            However, upon spiritual awakening, it realizes that the exact same essence dwelling within it pervades the entire universe. 
            This is the triumphant declaration of ultimate enlightenment—"I have finally seen the absolute Truth!"
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 24,
        sanskrit = "तस्मादिदन्द्रो नामेदन्द्रो ह वै नाम तमिदन्द्रं सन्तमिन्द्र इत्याचक्षते परोक्षेण परोक्षप्रिया इव हि देवाः परोक्षप्रिया इव हि देवाः ॥ २४ ॥",
        hindi = """
            चूंकि उसने कहा "मैंने इसे देख लिया" (इदम् अदर्शम्), इसलिए उस परमात्मा का नाम 'इदन्द्र' (Idandra) पड़ गया। 
            वास्तव में उसका नाम 'इदन्द्र' ही है। लेकिन उस इदन्द्र को लोग रहस्यमयी ढंग से (परोक्ष रूप से) 'इन्द्र' (Indra) कहते हैं। 
            क्योंकि देवताओं को परोक्ष (रहस्य या छिपे हुए नाम) बहुत प्रिय हैं, हाँ, देवताओं को रहस्य बहुत प्रिय हैं। (यहाँ प्रथम अध्याय समाप्त होता है)।
            शास्त्र सत्य को सीधे-सीधे नहीं बताते, बल्कि प्रतीकों और कथाओं में छिपा कर रखते हैं। 
            'इन्द्र' केवल स्वर्ग का राजा नहीं है, बल्कि वह हमारे भीतर बैठी 'देखने वाली चेतना' का ही रहस्यमयी नाम है।
        """.trimIndent(),
        english = """
            Because he exclaimed "I have seen This" (Idam adarsham), He is rightfully called 'Idandra'. 
            Idandra is indeed His true name. However, even though He is Idandra, people call Him by the indirect, cryptic name 'Indra'. 
            This is because the gods are fond of the cryptic and mysterious, yes, the gods love what is concealed. (End of Chapter 1).
            Ancient scriptures rarely present profound truths plainly; they cloak them in allegories, metaphors, and secret names. 
            'Indra' is not just a mythological king of heaven; it is the esoteric name for the supreme witnessing consciousness within us all.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 25,
        sanskrit = "पुरुषे ह वा अयमादितो गर्भो भवति यदेतद्रेतः । तदेतत्सर्वेभ्योऽङ्गेभ्यस्तेजः सम्भूतमात्मन्येवात्मानं बिभर्ति तद्यदा स्त्रियां सिञ्चत्यथैनज्जनयति तदस्य प्रथमं जन्म ॥ २५ ॥",
        hindi = """
            (द्वितीय अध्याय प्रारंभ): मनुष्य (पुरुष) के भीतर सबसे पहले यह आत्मा एक गर्भ (बीज/वीर्य) के रूप में निवास करता है। 
            यह बीज शरीर के सभी अंगों से खींचा हुआ एक अर्क (तेज) है। पुरुष इस बीज को अपनी ही आत्मा के रूप में अपने भीतर धारण करता है। 
            जब वह इसे स्त्री के गर्भ में स्थापित (सिंचित) करता है, तो वह इसे जन्म देता है। यह जीवात्मा का 'प्रथम जन्म' है।
            यहाँ से उपनिषद मनुष्य के तीन जन्मों का वर्णन करता है। 
            प्रजनन केवल एक शारीरिक क्रिया नहीं है; यह एक आत्मा का पिता के शरीर से माता के शरीर में प्रवेश है।
        """.trimIndent(),
        english = """
            (Chapter 2 begins): In a human male, this soul initially exists as a germ/seed (semen). 
            This seed is the concentrated vigor and essence drawn from all the limbs of the body. The man carries this seed within himself as his own self. 
            When he places (implants) it into a woman, he causes it to be born. This is the 'First Birth' of the soul.
            Here, the Upanishad outlines the three successive births of a human being. 
            Procreation is viewed not merely as a biological function, but as the sacred transfer of a living soul from the father's essence into the mother's womb.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 26,
        sanskrit = "तत्स्त्रिया आत्मभूयं गच्छति यथा स्वमङ्गं तथा तस्मादेनां न हिनस्ति साऽस्यैतमात्मानमत्र गतं भावयति ॥ २६ ॥",
        hindi = """
            वह बीज स्त्री (माता) के शरीर का ही हिस्सा (आत्मभूयं) बन जाता है, बिल्कुल वैसे ही जैसे उसका अपना कोई अंग हो। 
            यही कारण है कि वह गर्भ माता को कोई नुकसान नहीं पहुँचाता (न हिनस्ति)। 
            तब माता अपने भीतर आए हुए पति के इस अंश (आत्मा) का पूरे प्रेम से पालन-पोषण करती है।
            प्रकृति की यह अद्भुत व्यवस्था है कि एक पराया बीज माँ के शरीर में जाकर उसी का हिस्सा बन जाता है। 
            माँ उसे बाहरी वस्तु मानकर खारिज नहीं करती, बल्कि अपना ही अंग समझकर उसे खून और पोषण देती है।
        """.trimIndent(),
        english = """
            That seed completely assimilates and becomes one with the woman's body, just like her own natural limb. 
            Because of this perfect assimilation, the growing embryo does not injure or harm her. 
            The mother then lovingly nourishes and protects this self of her husband that has entered within her.
            This highlights the miraculous biological and spiritual design of pregnancy. 
            The mother's immune system does not reject the foreign seed; instead, she embraces it as her own vital organ, providing it with complete nourishment.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 27,
        sanskrit = "सा भावयित्री भावयितव्या भवति । तं स्त्री गर्भं बिभर्ति सोऽग्र एव कुमारं जन्मनोऽग्रेऽधिभावयति स यत्कुमारं जन्मनोऽग्रेऽधिभावयत्यात्मानमेव तदधिभावयत्येषां लोकानां सन्तत्या एवं सन्तता हीमे लोकास्तदस्य द्वितीयं जन्म ॥ २७ ॥",
        hindi = """
            चूंकि वह (माता) उस गर्भ का पालन करती है, इसलिए समाज और परिवार द्वारा उस माता का भी पालन-पोषण (ध्यान) किया जाना चाहिए। 
            स्त्री उस गर्भ को धारण करती है। जन्म के बाद पिता उस शिशु का भरण-पोषण करता है। 
            पिता जो शिशु का पालन करता है, वह वास्तव में अपनी ही आत्मा (वंश) का विस्तार कर रहा होता है, ताकि इन लोकों की निरंतरता (संतति) बनी रहे। 
            माता के गर्भ से शिशु का बाहर आना ही जीवात्मा का 'द्वितीय जन्म' (दूसरा जन्म) है।
            यहाँ समाज के कर्तव्यों का भी वर्णन है। माता की देखभाल करना पूरे परिवार का धर्म है।
        """.trimIndent(),
        english = """
            Since she is the nourisher of the embryo, she herself must be deeply nourished and cared for by the family. 
            The woman bears the child in her womb. Upon birth, the father takes over the nourishment of the child. 
            By nurturing the child after birth, the father is essentially nurturing his own self for the continuation of these worlds and the human lineage. 
            The physical delivery of the baby from the mother's womb is considered the 'Second Birth' of the soul.
            This verse elegantly weaves spiritual philosophy with familial duties, emphasizing the sacred responsibility of caring for a pregnant mother.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 28,
        sanskrit = "सोऽस्यायमात्मा पुण्येभ्यः कर्मभ्यः प्रतिधीयते । अथास्यायमितर आत्मा कृतकृत्यो वयोगतः प्रैति स इतः प्रयन्नेव पुनर्जायते तदस्य तृतीयं जन्म ॥ २८ ॥",
        hindi = """
            वह पुत्र (जो पिता की ही आत्मा है) पिता के द्वारा धर्म और पुण्य कर्मों को आगे बढ़ाने के लिए प्रतिनिधि (Substitute) के रूप में नियुक्त किया जाता है। 
            तब पिता (जो दूसरा आत्मा है), अपने जीवन के सभी कर्तव्यों को पूरा करके (कृतकृत्य होकर) और वृद्ध होकर इस शरीर को त्याग देता है (मृत्यु को प्राप्त होता है)। 
            यहाँ से प्रस्थान करते ही वह अपने कर्मों के अनुसार एक नया शरीर धारण करता है (पुनर्जन्म)। यह जीवात्मा का 'तृतीय जन्म' (तीसरा जन्म) है।
            मनुष्य का जीवन केवल अपने लिए नहीं है; उसे अपनी अगली पीढ़ी को अच्छे संस्कार देकर जाना चाहिए। 
            मृत्यु कोई अंत नहीं है, यह केवल आत्मा का एक शरीर से दूसरे शरीर में स्थानांतरण (तीसरा जन्म) है।
        """.trimIndent(),
        english = """
            The son (who is the extension of the father's soul) is appointed as a substitute to perform righteous duties and good deeds in the world. 
            Then the father (the other self), having fulfilled all his life's duties and having reached old age, departs from this world. 
            Immediately upon departing from here, he is born again in a new body according to his karma. This reincarnation is his 'Third Birth'.
            Life is a continuum. A parent's duty is to prepare their child to uphold righteousness in their absence. 
            Death is not seen as an absolute end, but merely as a transition—the third stage in the perpetual journey of the soul.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 29,
        sanskrit = "तदुक्तमृषिणा—गर्भे नु सन्नन्वेषामवेदमहं देवानां जनिमानि विश्वा । शतं मा पुर आयसीररक्षन्नधः श्येनो जवसा निरदीयमिति । गर्भ एवैतच्छयानो वामदेव एवमुवाच ॥ २९ ॥",
        hindi = """
            इस विषय में ऋषि वामदेव ने कहा था: "जब मैं अपनी माता के गर्भ में ही था, तभी मैंने इन सभी देवताओं (शारीरिक और ब्रह्मांडीय शक्तियों) के जन्म के रहस्य को जान लिया था। 
            मुझे लोहे के सैकड़ों किलों (अज्ञान, कर्म और शरीरों के बंधनों) ने कैद कर रखा था, लेकिन मैं एक बाज़ (श्येन) पक्षी की तरह तेजी से उन पिंजरों को तोड़कर उड़ गया।"
            ऋषि वामदेव ने गर्भ में लेटे-लेटे ही यह घोषणा कर दी थी। 
            यह श्लोक बताता है कि आत्म-ज्ञान किसी भी अवस्था में हो सकता है। 
            'लोहे के सौ किले' हमारे पिछले जन्मों के कर्म और शारीरिक सीमाएं हैं। ज्ञान वह बाज़ है जो इन सारी बेड़ियों को एक झटके में तोड़कर आत्मा को आज़ाद कर देता है।
        """.trimIndent(),
        english = """
            Regarding this, the ancient sage Vamadeva declared: "Even while confined within my mother's womb, I fully realized all the births and secrets of these gods (cosmic forces). 
            A hundred iron citadels (the heavy chains of karma and physical bodies) guarded and imprisoned me, but like a swift hawk, I burst through them and soared into freedom."
            Sage Vamadeva made this profound declaration while still lying in the womb. 
            This extraordinary verse signifies that absolute spiritual awakening can happen at any time. 
            The 'hundred iron citadels' symbolize the stubborn conditioning and karmic bondage of countless past lives, which are instantly shattered by the supreme flight of wisdom.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 30,
        sanskrit = "स एवं विद्वानस्माच्छरीरभेदादूर्ध्व उत्क्रम्यामुष्मिन् स्वर्गे लोके सर्वान् कामानाप्त्वाऽमृतः समभवत् समभवत् ॥ ३० ॥",
        hindi = """
            इस महान सत्य को जानने वाले वे ऋषि वामदेव, इस भौतिक शरीर के नष्ट होने (भेद) पर, ऊपर की ओर उठकर (सांसारिक बंधनों से मुक्त होकर) उस परम स्वर्ग लोक (ब्रह्मलोक/मोक्ष) में पहुँच गए। 
            वहाँ उन्होंने अपनी सभी इच्छाओं की पूर्णता प्राप्त कर ली और वे हमेशा के लिए अमर हो गए, हाँ, वे सचमुच अमर हो गए! (यहाँ द्वितीय अध्याय समाप्त होता है)।
            जब अज्ञान का पर्दा हट जाता है, तो मृत्यु का भय खत्म हो जाता है। 
            शारीरिक मृत्यु ज्ञानी के लिए एक उत्सव है क्योंकि वह उसे शाश्वत परमानंद (अमृतत्व) में मिला देती है। 'समभवत्' का दो बार प्रयोग इस सत्य की निश्चितता को दर्शाता है।
        """.trimIndent(),
        english = """
            Knowing this supreme truth, Sage Vamadeva, upon the dissolution of his physical body, ascended upward (transcended worldly bondage) into the supreme heavenly realm (liberation). 
            There, having attained the absolute fulfillment of all desires, he became immortal, yes, he truly became immortal! (End of Chapter 2).
            When the veil of ignorance is destroyed, the illusion and fear of death completely vanish. 
            For an enlightened being, physical death is merely the final shedding of a limitation, leading to eternal bliss and immortality. The repetition of 'Samabhavat' strongly emphasizes the absolute certainty of this liberation.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 31,
        sanskrit = "कोऽयमात्मेति वयमुपास्महे कतरः स आत्मा । येन वा पश्यति येन वा शृणोति येन वा गन्धानाजिघ्रति येन वा वाचं व्याकरोति येन वा स्वादु चास्वादु च विजानाति ॥ ३१ ॥",
        hindi = """
            (तृतीय अध्याय प्रारंभ): हम जिस 'आत्मा' की उपासना करते हैं, वह आत्मा वास्तव में कौन है? 
            क्या वह आत्मा वह है जिसके द्वारा हम देखते हैं? या जिसके द्वारा हम सुनते हैं? या जिससे हम गंध सूँघते हैं? या जिससे हम शब्दों का उच्चारण करते हैं? या जिससे हम मीठे और कड़वे स्वाद का पता लगाते हैं?
            यह ऐतरेय उपनिषद का सबसे महत्वपूर्ण प्रश्न है। 
            साधक सोच रहा है कि क्या हमारी देखने, सुनने या चखने की शक्ति ही हमारी आत्मा है? 
            जवाब यह है कि ये सब तो केवल इंद्रियां (Tools) हैं। वह कौन सी मुख्य सत्ता है जो इन उपकरणों का इस्तेमाल कर रही है?
        """.trimIndent(),
        english = """
            (Chapter 3 begins): Who is this 'Self' (Atman) that we worship? Which one is that true Self? 
            Is it that by which we see forms? Or that by which we hear sounds? Or that by which we smell odors? Or that by which we articulate speech? Or that by which we distinguish sweet and bitter tastes?
            This is the core, climactic inquiry of the Aitareya Upanishad. 
            The seeker is investigating whether the sensory faculties of sight, hearing, or taste are themselves the soul. 
            The implication is that these are merely instruments or windows. Who is the actual Master sitting inside the house looking through these windows?
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 32,
        sanskrit = "यदेतद्धृदयं मनश्चैतत् । सञ्ज्ञानमाज्ञानं विज्ञानं प्रज्ञानं मेधा दृष्टिर्धृतिर्मतिर्मनीषा जूतिः स्मृतिः सङ्कल्पः क्रतुरसुः कामो वश इति । सर्वाण्येवैतानि प्रज्ञानस्य नामधेयानि भवन्ति ॥ ३२ ॥",
        hindi = """
            नहीं, इंद्रियां आत्मा नहीं हैं। यह जो हमारा हृदय और मन है, उसी के ये अनेक रूप हैं— 
            चेतना (संज्ञान), आज्ञा देने की शक्ति (आज्ञान), विशेष ज्ञान (विज्ञान), शुद्ध प्रज्ञा (प्रज्ञान), याद रखने की शक्ति (मेधा), दूरदर्शिता (दृष्टि), धैर्य (धृति), विचार (मति), मनन (मनीषा), आवेग (जूति), याददाश्त (स्मृति), संकल्प, इच्छाशक्ति (क्रतु), प्राण (असु), कामना और वश में करने की शक्ति (वश)। 
            ये सभी केवल एक ही 'प्रज्ञान' (Pure Consciousness / शुद्ध चेतना) के अलग-अलग नाम हैं।
            हम जीवन में जितने भी मानसिक या बौद्धिक कार्य करते हैं, वे सब अलग-अलग नहीं हैं। 
            वे एक ही 'चेतना' (प्रज्ञान) के अलग-अलग रूप हैं, जैसे एक ही बिजली से पंखा, बल्ब और हीटर चलते हैं।
        """.trimIndent(),
        english = """
            No, the senses are not the Self. That which is known as the heart and the mind— 
            consciousness (Sanjnana), perception/command (Ajnana), worldly knowledge (Vijnana), supreme wisdom (Prajnana), retentive power (Medha), insight (Drishti), steadfastness (Dhriti), thought (Mati), thoughtfulness (Manisha), impulse (Juti), memory (Smriti), conception (Sankalpa), purpose (Kratu), vitality (Asu), desire (Kama), and control (Vasha). 
            All of these are but various names and expressions of one single reality: 'Prajnana' (Pure Consciousness).
            Every intellectual, emotional, and cognitive function we experience is not an independent entity. 
            They are simply different manifestations of one underlying, unified Consciousness, much like different electrical appliances powered by the exact same electricity.
        """.trimIndent()
    ),
    AitareyaShloka(
        id = 33,
        sanskrit = "एष ब्रह्मैष इन्द्र एष प्रजापतिरेते सर्वे देवा इमानि च पञ्चमहाभूतानि पृथिवी वायुराकाश आपो ज्योतींषीत्येतानीमानि च क्षुद्रमिश्राणीव ... प्रज्ञानेत्रो लोकः प्रज्ञा प्रतिष्ठा प्रज्ञानं ब्रह्म ॥ स एतेन प्राज्ञेनाऽऽत्मनाऽस्माल्लोकादुत्क्रम्यामुष्मिन्स्वर्गे लोके सर्वान् कामानाप्त्वाऽमृतः समभवत् समभवत् ॥ ३३ ॥",
        hindi = """
            यही शुद्ध चेतना (प्रज्ञान) ही साक्षात् 'ब्रह्मा' है, यही 'इन्द्र' है, यही 'प्रजापति' है, और यही सभी देवता हैं। 
            ये पांचों महाभूत (पृथ्वी, जल, अग्नि, वायु, आकाश), छोटे-बड़े सभी जीव, जानवर, पक्षी और मनुष्य—सब इसी चेतना से उत्पन्न हैं। 
            यह संपूर्ण जगत चेतना द्वारा ही देखा और चलाया जाता है (प्रज्ञानेत्रो लोकः)। चेतना ही इस ब्रह्मांड का एकमात्र आधार (प्रतिष्ठा) है। 
            "प्रज्ञानं ब्रह्म" (चेतना ही परब्रह्म है)। 
            जो मनुष्य इस परम सत्य को जान लेता है, वह इस संसार से ऊपर उठकर परम स्वर्ग में सभी इच्छाओं से मुक्त होकर अमर हो जाता है, हाँ, वह अमर हो जाता है!
            "प्रज्ञानं ब्रह्म" ऋग्वेद का 'महावाक्य' (सबसे बड़ा सिद्धांत) है। 
            पूरा ब्रह्मांड मृत पदार्थ (Dead matter) से नहीं बना है, बल्कि यह एक जीती-जागती चेतना का खेल है। विज्ञान जिसे ऊर्जा कहता है, वेदांत उसे 'चेतना' कहता है।
        """.trimIndent(),
        english = """
            This Pure Consciousness is Brahma, It is Indra, It is Prajapati, and It is all the gods. 
            It is the five great elements (earth, water, fire, air, space), and all living beings—small and large, animals, birds, and humans. 
            The entire universe is guided by Consciousness, and Consciousness is its eye (Prajnanetro Lokah). Consciousness is the ultimate foundation of reality. 
            "Prajnanam Brahma" (Consciousness is the Supreme Brahman). 
            He who realizes this Absolute Truth, transcending this mortal world, ascends to the supreme heavenly realm, fulfills all desires, and becomes immortal, yes, immortal!
            "Prajnanam Brahma" is the Great Statement (Mahavakya) of the Rigveda. 
            The universe is not made of dead, mechanical matter; it is the dynamic dance of living, breathing Consciousness. What modern physics calls fundamental energy, Vedanta identifies as pure, self-aware Consciousness.
        """.trimIndent()
    )
)