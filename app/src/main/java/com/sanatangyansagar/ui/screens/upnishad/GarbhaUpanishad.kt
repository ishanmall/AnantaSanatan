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
data class GarbhaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GarbhaUpanishadScreen() {
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
                if (shlokaNumber != null && shlokaNumber in 1..25) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-25)") },
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
            itemsIndexed(garbhaShlokasList) { _, shloka ->
                GarbhaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun GarbhaShlokaCard(shloka: GarbhaShloka) {
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

val garbhaShlokasList: List<GarbhaShloka> = listOf(
    GarbhaShloka(
        id = 1,
        sanskrit = "पञ्चात्मकं पञ्चसु वर्तमानं षडाश्रयं षड्गुणयोगयुक्तम् । सप्तधातु त्रिमलं द्वियोनि चतुर्विधाहारमयं शरीरम् ॥ १ ॥",
        hindi = """
            यह मनुष्य का भौतिक शरीर मुख्य रूप से पाँच महान तत्वों (पृथ्वी, जल, अग्नि, वायु और आकाश) से बना हुआ है (पञ्चात्मकं)।
            यह शरीर इन पाँचों तत्वों के सूक्ष्म कार्यों (देखना, सुनना आदि) में ही निरंतर लगा रहता है।
            यह शरीर छह प्रकार के रसों (मीठा, खट्टा, खारा, तीखा, कड़वा, और कसैला) का आश्रय-स्थान (षडाश्रयं) है।
            यह शरीर प्रकृति के छह विशेष गुणों और अवस्थाओं (जन्म, अस्तित्व, वृद्धि, परिवर्तन, क्षय और नाश) से पूरी तरह युक्त है।
            इस शरीर का निर्माण सात प्रकार की धातुओं (रस, रक्त, मांस, मेद, हड्डी, मज्जा और वीर्य) से हुआ है।
            यह तीन प्रकार के मलों (वात, पित्त, कफ) को उत्पन्न करता है और यह माता-पिता की दो योनियों (बीज) के मिलन से बना है।
            और यह शरीर मुख्य रूप से चार प्रकार के भोजन (चबाने, चूसने, चाटने और पीने वाले) पर ही पूर्ण रूप से टिका हुआ है।
            यह उपनिषद की शुरुआत आयुर्वेद और मेडिकल साइंस (Medical Science) के सबसे सटीक शरीर-विज्ञान (Anatomy) से होती है।
            हमारे शरीर का एक-एक हिस्सा और उसका काम केवल भौतिक पदार्थों का एक केमिकल कॉम्बिनेशन (Chemical combination) मात्र है।
            ऋषियों ने हजारों साल पहले ही बता दिया था कि यह शरीर कोई भगवान नहीं, बल्कि तत्वों और भोजन से बनी एक 'मशीन' (Machine) है।
        """.trimIndent(),
        english = """
            This physical human body is fundamentally composed entirely of the five great elements (earth, water, fire, air, and ether) (Panchatmakam).
            It continuously operates and perpetually exists strictly within the subtle functions of these five basic elements.
            This body is the ultimate receptacle and dependent foundation (Shadashrayam) for exactly six distinct tastes (sweet, sour, salty, pungent, bitter, astringent).
            It is completely endowed with the six natural modifications of existence (birth, existence, growth, transformation, decay, and death).
            This body is perfectly constructed from exactly seven vital tissues or Dhatus (plasma, blood, muscle, fat, bone, marrow, and reproductive tissue).
            It naturally generates three specific impurities (Vata, Pitta, Kapha) and is born from the union of exactly two sources (male and female seeds).
            And this complex physical structure is sustained entirely by four specific types of consumed food (chewed, sucked, licked, and drunk).
            The Upanishad brilliantly opens with the most phenomenally accurate Anatomy from ancient Ayurveda and Medical Science.
            Every single component and function of our physical body is merely a highly complex Chemical Combination of raw material elements.
            Ancient sages declared thousands of years ago that this body is absolutely not God, but merely a biological 'Machine' built entirely from elements and food.
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 2,
        sanskrit = "पञ्चात्मकं इति कस्मात् ? पृथिव्यापस्तेजोवायुराकाशमिति । तस्मिन् पञ्चात्मके शरीरे का पृथिवी का आपः... ॥ २ ॥",
        hindi = """
            प्रश्न उठता है कि इस शरीर को 'पञ्चात्मक' (पाँच तत्वों वाला) क्यों कहा जाता है? उत्तर: क्योंकि यह पृथ्वी, जल, अग्नि, वायु और आकाश से बना है।
            तो फिर इस पाँच तत्वों वाले शरीर में पृथ्वी क्या है? जल क्या है? तेज (अग्नि) क्या है? और वायु व आकाश क्या हैं?
            शरीर में जो कुछ भी कठोर (Solid) और भारी हिस्सा है (हड्डियां, मांस, बाल), वह सब 'पृथ्वी' तत्व है।
            शरीर में जो कुछ भी तरल (Liquid) या बहने वाला है (खून, लार, पसीना), वह सब 'जल' तत्व है।
            शरीर में जो भी गर्मी (Heat), पाचन शक्ति और देखने की शक्ति है, वह सब 'अग्नि' तत्व का रूप है।
            शरीर में जो कुछ भी गति (Movement) करता है (साँस लेना, पलकें झपकाना), वह सब 'वायु' तत्व है।
            और शरीर के भीतर जो भी खाली जगह (Space/Cavity) है (जैसे पेट या फेफड़ों के अंदर की जगह), वह 'आकाश' तत्व है।
            उपनिषद यहाँ इंसान के शरीर का पूरा 'पोस्टमार्टम' (Postmortem) करके उसके एक-एक तत्व को स्पष्ट कर रहा है।
            हम जिसे 'मैं' (My body) कहते हैं, वह वास्तव में बाहर की मिट्टी, पानी और हवा का ही एक चलता-फिरता ढेर है।
            जब इंसान को इस वैज्ञानिक सच्चाई का बोध होता है, तो उसे अपने शरीर के रूप-रंग पर होने वाला घमंड हमेशा के लिए टूट जाता है।
        """.trimIndent(),
        english = """
            The profound question arises: Why exactly is this body called 'Panchatmakam' (made of five elements)? Answer: Because it is composed of earth, water, fire, air, and ether.
            So then, in this specific five-elemental physical body, what exactly is earth? What is water? What is fire, air, and space?
            Whatever is hard, dense, and solid in the body (such as bones, flesh, hair, and teeth) is strictly the 'Earth' element.
            Whatever is completely fluid and freely flowing in the body (such as blood, saliva, and sweat) is strictly the 'Water' element.
            Whatever generates heat, active digestive power, and the capacity of visual sight is strictly the 'Fire' element.
            Whatever performs movement and physical motion in the body (such as breathing and blinking) is strictly the 'Air' element.
            And whatever represents hollow space or empty cavities within the body (like the stomach or lungs) is strictly the 'Space' (Ether) element.
            The Upanishad is effectively performing a profound biological 'Postmortem' here, completely clarifying every single element of the human frame.
            What we arrogantly call 'I' or 'My body' is, in absolute reality, merely a walking, breathing pile of external dirt, water, and air.
            When a human deeply realizes this absolute scientific truth, all his toxic pride regarding his physical appearance shatters completely forever.
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 3,
        sanskrit = "तत्र पृथिवी धारणे, आपः पिण्डीकरणे, तेजः प्रकाशने, वायुर्गमने, आकाशमवकाशप्रदाने ॥ ३ ॥",
        hindi = """
            (अब इन पाँच तत्वों के कार्यों को समझाया जा रहा है): इस शरीर में 'पृथ्वी' तत्व का मुख्य कार्य शरीर के पूरे ढांचे को धारण करना (सहारा/Support देना) है।
            'जल' तत्व का मुख्य कार्य शरीर के सभी अलग-अलग हिस्सों को आपस में जोड़कर एक 'पिण्ड' (Solid mass / आकार) के रूप में बाँधना है।
            'तेज' (अग्नि) तत्व का मुख्य कार्य शरीर के भीतर पाचन करना और आँखों के माध्यम से दुनिया को प्रकाशित (दिखाना) करना है।
            'वायु' तत्व का मुख्य कार्य शरीर के अंगों को हिलाना-डुलाना और खून व साँसों का आवागमन (Movement) करना है।
            और 'आकाश' तत्व का मुख्य कार्य शरीर के सभी अंगों को फूलने और सिकुड़ने के लिए खाली जगह (अवकाश / Room) प्रदान करना है।
            यह एक अत्यंत सटीक 'बायोलॉजिकल' (Biological) और फिजियोलॉजिकल (Physiological) विवरण है।
            बिना पानी के मिट्टी भुरभुरी होकर गिर जाती है; इसीलिए शरीर को एक आकार (Shape) में जोड़े रखने के लिए 70% जल तत्व जरूरी है।
            बिना अग्नि (Metabolism) के शरीर ठंडा पड़कर मर जाएगा; और बिना आकाश (Space) के हमारा दिल धड़क ही नहीं सकता।
            ये पाँचों तत्व एक साथ मिलकर एक 'टीम' (Team) की तरह काम करते हैं, ताकि यह शरीर रूपी मशीन सुचारु रूप से चल सके।
            यह ज्ञान हमें यह सोचने पर मजबूर करता है कि अगर यह सब 'तत्व' कर रहे हैं, तो इसमें 'मेरा' क्या है?
        """.trimIndent(),
        english = """
            (Now the specific functions of these five elements are explained): In this physical body, the primary function of the 'Earth' element is strictly to support and solidly hold (Dharane) the entire framework.
            The primary function of the 'Water' element is strictly to bind and cohere all the separate parts of the body together into a single, unified mass (Pindikarane).
            The primary function of the 'Fire' (Tejas) element is strictly to digest food and vividly illuminate (reveal) the external world through the eyes.
            The primary function of the 'Air' element is strictly to perform all physical movements, enabling the circulation of blood and continuous breathing.
            And the primary function of the 'Space' element is strictly to provide necessary room and empty cavities (Avakasha) for internal organs to expand and function.
            This is an exceptionally precise and remarkably flawless 'Biological' and Physiological description of human mechanics.
            Without water, dry earth crumbles and falls apart; hence, the body desperately requires 70% water to maintain its coherent Shape.
            Without fire (Metabolism), the physical body turns instantly cold and dies; and without Space, our physical heart simply cannot beat.
            All these five distinct elements work flawlessly together as a perfectly synchronized 'Team' to keep this biological machine actively running.
            This profound wisdom forcefully compels us to deeply question: if raw physical elements are doing absolutely everything, what exactly is 'Mine' here?
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 4,
        sanskrit = "श्रोत्रे शब्दोपलब्धौ, त्वक् स्पर्शे, चक्षुषी रूपे, जिह्वा रसने, नासिका घ्राणे... ॥ ४ ॥",
        hindi = """
            (ज्ञानेंद्रियों और उनके विषयों का वर्णन): मनुष्य के कानों (श्रोत्र) का निर्माण 'शब्द' (Sound) को सुनने और ग्रहण करने के लिए हुआ है।
            त्वचा (Skin / त्वक्) का निर्माण बाहरी वस्तुओं के 'स्पर्श' (Touch) का अहसास करने के लिए हुआ है।
            आँखों (चक्षु) का निर्माण दुनिया के विभिन्न 'रूपों' (Forms/Colors) को देखने के लिए किया गया है।
            जीभ (जिह्वा) का निर्माण भोजन के 'रसों' (Tastes) को चखने और स्वाद लेने के लिए किया गया है।
            और नाक (नासिका) का निर्माण अलग-अलग प्रकार की गंध (Smell/घ्राण) को सूँघने के लिए हुआ है।
            यह हमारी पाँच 'ज्ञानेंद्रियां' (Sense organs of knowledge) हैं, जो बाहरी दुनिया से इन्फॉर्मेशन (Information) इकट्ठा करके हमारे दिमाग को भेजती हैं।
            इन पाँचों इंद्रियों का सीधा संबंध उन पाँच महाभूतों (तत्वों) से है जिनसे यह शरीर बना है।
            आकाश से कान बने, हवा से त्वचा, आग से आँखें, पानी से जीभ, और मिट्टी (पृथ्वी) से नाक बनी है।
            यह शरीर एक अत्यंत हाई-टेक 'सेंसर मशीन' (Sensor Machine) है जिसे आत्मा ने दुनिया का अनुभव लेने के लिए पहना हुआ है।
            परंतु अज्ञानी जीव इन सेंसर्स (Senses) का ही गुलाम बन जाता है और आत्मा (जो इनका मालिक है) को पूरी तरह भूल जाता है।
        """.trimIndent(),
        english = """
            (Description of the sense organs and their objects): The human ears (Shrotra) are perfectly designed and formed strictly to hear and grasp 'Sound' (Shabda).
            The skin (Tvak) is perfectly designed and completely formed strictly to feel and perceive the sensation of 'Touch' (Sparsha).
            The physical eyes (Chakshu) are designed and formed strictly to perceive and vividly see the various 'Forms and Colors' (Rupa) of the world.
            The tongue (Jihva) is perfectly formed strictly to taste and relish the various 'Flavors' (Rasas) of consumed food.
            And the nose (Nasika) is perfectly designed and formed strictly to smell and perceive different types of 'Odors' (Ghrana).
            These are our exact five 'Sense Organs of Knowledge' (Jnanendriyas) which relentlessly gather Information from the external world and send it to the brain.
            These five physical senses have a direct, flawless connection with the exact five gross elements from which this body is manufactured.
            Ears are born from Space, skin from Air, eyes from Fire, tongue from Water, and the nose is born from Earth.
            This physical body is an exceptionally high-tech 'Sensor Machine' actively worn by the immortal Soul strictly to experience the material world.
            But the ignorant creature pathetically becomes a helpless slave to these very Sensors, completely forgetting the pure Soul (who is their actual Master).
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 5,
        sanskrit = "षडाश्रयमिति कस्मात् ? मधुर-अम्ल-लवण-तिक्त-कटु-कषाय-रसान् विन्दतीति ॥ ५ ॥",
        hindi = """
            प्रश्न: इस शरीर को 'छह रसों का आश्रय' (षडाश्रयं) क्यों कहा जाता है? 
            उत्तर: क्योंकि यह भौतिक शरीर अपने भोजन के माध्यम से छह (6) प्रकार के स्वादों (रसों) का निरंतर अनुभव करता है।
            ये छह स्वाद हैं: 1. मधुर (मीठा / Sweet), 2. अम्ल (खट्टा / Sour), 3. लवण (नमकीन / Salty)।
            4. तिक्त (कड़वा / Bitter), 5. कटु (तीखा / Pungent), और 6. कषाय (कसैला / Astringent)।
            आयुर्वेद के अनुसार, हमारे शरीर का पूरा स्वास्थ्य (Health) इन्हीं छह रसों के सही 'बैलेंस' (Balance) पर निर्भर करता है।
            अगर हम केवल मीठा (मधुर) खाते हैं, तो शरीर में कफ (Kapha) और बीमारियां बढ़ जाती हैं।
            इन छह रसों से ही शरीर की सातों 'धातुएं' (खून, मांस, हड्डी आदि) बनती और पोषित होती हैं।
            इंसान की जीभ इन्हीं छह स्वादों के लालच में फँसी रहती है, और इसी लालच के कारण वह बार-बार जन्म लेता है।
            सच्चा योगी खाने को 'स्वाद' के लिए नहीं, बल्कि केवल इस शरीर रूपी मशीन के 'ईंधन' (Fuel) के रूप में ग्रहण करता है।
            शरीर को इन छह रसों से ऊपर उठाकर 'परमानंद' के रस में डुबो देना ही मोक्ष का मार्ग है।
        """.trimIndent(),
        english = """
            Question: Why exactly is this physical body called the 'Receptacle of six tastes' (Shadashrayam)?
            Answer: Because this physical body continuously experiences and absorbs exactly six (6) types of flavors (Rasas) strictly through its consumed food.
            These exact six distinct tastes are: 1. Madhura (Sweet), 2. Amla (Sour), 3. Lavana (Salty).
            4. Tikta (Bitter), 5. Katu (Pungent/Spicy), and 6. Kashaya (Astringent).
            According to the profound science of Ayurveda, the absolute complete Health of our physical body depends entirely on the perfect 'Balance' of these six tastes.
            If we obsessively consume only sweet (Madhura) things, Kapha (phlegm) and severe diseases aggressively increase in the body.
            It is strictly from these six exact tastes that the body's seven vital 'Dhatus' (blood, flesh, bones, etc.) are perfectly formed and nourished.
            The human tongue remains helplessly trapped in the fierce greed for these six flavors, and strictly due to this greed, a human takes repeated rebirths.
            A true Yogi consumes food absolutely not for its 'Taste', but strictly and purely as necessary 'Fuel' for this biological bodily machine.
            Elevating the body completely above these six physical tastes and drowning it directly in the divine taste of 'Supreme Bliss' is the ultimate path to Moksha.
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 6,
        sanskrit = "सप्तधातुकमिति कस्मात् ? रसाद्रक्तं रक्तान्मांसं मांसान्मेदः मेदसः स्नायुः स्नाय्वस्थि अस्थिनो मज्जा मज्जायाः शुक्रम् ॥ ६ ॥",
        hindi = """
            प्रश्न: इस शरीर को 'सप्त-धातुओं' (सात प्रकार के ऊतकों / Tissues) वाला क्यों कहा जाता है?
            उत्तर: क्योंकि हमारे खाए हुए भोजन से सबसे पहले 'रस' (Plasma) बनता है। उस रस से 'रक्त' (Blood/खून) बनता है।
            रक्त से 'मांस' (Muscles/पेशियां) बनता है; मांस से 'मेद' (Fat/चर्बी) बनती है; और मेद से 'स्नायु' (Nerves) या मांसपेशियां बनती हैं।
            उन स्नायुओं से 'अस्थि' (Bones/हड्डियां) बनती हैं; हड्डियों के भीतर 'मज्जा' (Bone Marrow) का निर्माण होता है।
            और अंततः, उस मज्जा से सबसे शुद्ध और अंतिम ऊर्जा 'शुक्र' (Semen / Reproductive fluid) का निर्माण होता है।
            यह श्लोक आयुर्वेद का सबसे महान और सटीक 'मेटाबॉलिज्म' (Metabolism) और पाचन तंत्र का विज्ञान है।
            हम जो रोटी खाते हैं, वह सीधे खून या ताकत नहीं बनती; उसे 7 अलग-अलग फिल्टर (Filters) से गुजरना पड़ता है।
            भोजन से लेकर 'शुक्र' (वीर्य/Semen) बनने तक की यह प्रक्रिया बहुत लंबी और ऊर्जा खर्च करने वाली होती है।
            इसीलिए योग में 'शुक्र' (Semen) को बचाने (ब्रह्मचर्य) पर सबसे ज्यादा जोर दिया गया है, क्योंकि यह पूरे शरीर का सबसे 'कंसन्ट्रेटेड' (Concentrated) निचोड़ है।
            जब यह 'शुक्र' शरीर से बाहर गिरता है, तो इंसान अपनी पूरी प्राण-ऊर्जा खो देता है; और जब यह ऊपर (दिमाग) चढ़ता है, तो इंसान ज्ञानी बन जाता है।
        """.trimIndent(),
        english = """
            Question: Why exactly is this body called the one possessing 'Seven Dhatus' (Seven vital tissues)?
            Answer: Because from our consumed food, 'Rasa' (Plasma/Chyle) is produced first. From that Rasa, 'Rakta' (Blood) is formed.
            From blood, 'Mamsa' (Muscles/flesh) is formed; from flesh, 'Meda' (Fat) is formed; and from fat, 'Snayu' (Nerves/tendons) are formed.
            From those nerves, 'Asthi' (Bones) are formed; deep inside the bones, 'Majja' (Bone Marrow) is meticulously formed.
            And ultimately, from that marrow, the absolute purest, final energy essence called 'Shukra' (Semen / Reproductive fluid) is flawlessly produced.
            This phenomenal verse is Ayurveda's absolute greatest, most accurate science of human 'Metabolism' and the profound digestive system.
            The bread we eat absolutely does not instantly become blood or strength; it must pass strictly through 7 highly complex physical Filters.
            This lengthy, exhausting biological process from raw food to the final formation of 'Shukra' consumes massive amounts of vital bodily energy.
            This is exactly why Yoga places the absolute highest emphasis on fiercely preserving 'Shukra' (Brahmacharya), as it is the most 'Concentrated' ultimate essence of the entire body.
            When this 'Shukra' is carelessly discharged out of the body, the human loses his entire life-force; and when it travels upwards (to the brain), he becomes an enlightened sage.
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 7,
        sanskrit = "शुक्रशोणितसंयोगादावर्तते गर्भः । ऋतौ सम्प्रयोगादेकरात्रोषितं कललं भवति ॥ ७ ॥",
        hindi = """
            (अब यहाँ से गर्भ-विज्ञान / Embryology शुरू होता है): पुरुष के 'शुक्र' (Sperm) और स्त्री के 'शोणित' (Ovum/रक्त) के आपस में मिलन (संयोग) से।
            माता के गर्भ (Womb) में एक नए जीवन (भ्रूण / Fetus) का निर्माण शुरू (आवर्तते) होता है।
            स्त्री के 'ऋतुकाल' (Fertile period) में स्त्री और पुरुष के शारीरिक मिलन (सम्प्रयोग) से गर्भ ठहरता है।
            मिलन के बाद पहली ही रात (एकरात्रोषितं) में वह शुक्र और शोणित मिलकर एक छोटे से 'कलल' (Nodule / जेली जैसा सूक्ष्म बिंदु) का रूप ले लेते हैं।
            यह श्लोक आज के 'आधुनिक विज्ञान' (Modern Medical Embryology) की बिल्कुल सटीक शुरुआत है।
            उपनिषद बता रहा है कि जीवन किसी जादू से नहीं, बल्कि नर और मादा के बीजों के मिलन (Fertilization) से होता है।
            'ऋतुकाल' का मतलब है वह सही समय जब स्त्री का शरीर गर्भ धारण करने के लिए पूरी तरह तैयार (Ovulation period) होता है।
            'कलल' (Kalala) आधुनिक विज्ञान के जाइगोट (Zygote) का ही संस्कृत नाम है; यह जीवन का सबसे पहला और सूक्ष्म भौतिक रूप है।
            यह दिखाता है कि हमारे ऋषियों के पास माइक्रोस्कोप (Microscope) न होने के बावजूद, अपनी ध्यान-दृष्टि से उन्हें गर्भ के अंदर की एक-एक चीज साफ दिखाई देती थी।
            यह आध्यात्मिक ग्रंथ हमें यह याद दिलाता है कि हम सब एक अत्यंत गंदे और चिपचिपे 'कलल' से ही पैदा हुए हैं, इसलिए शरीर पर घमंड करना व्यर्थ है।
        """.trimIndent(),
        english = """
            (Now the profound science of Embryology begins here): Strictly through the flawless union (Samyoga) of the male's 'Shukra' (Sperm) and the female's 'Shonita' (Ovum/blood).
            The highly complex formation of a new life (Garbha / Fetus) is officially initiated (Avartate) within the mother's womb.
            Conception successfully takes place exclusively through the physical union (Samprayoga) of male and female precisely during the woman's 'Ritu-kala' (Fertile/Ovulation period).
            Immediately on the very first night (Ekaratroshitam) following the union, the merged sperm and ovum instantly form a tiny 'Kalala' (a jelly-like microscopic Nodule).
            This phenomenal verse is the absolutely exact, flawless beginning matching completely with 'Modern Medical Embryology'.
            The Upanishad explicitly states that life does not begin by cheap magic, but strictly through the biological Fertilization of male and female seeds.
            'Ritu-kala' precisely means that exact biological window when the female body is perfectly ready to conceive (Ovulation period).
            'Kalala' is the exact ancient Sanskrit term for what modern science calls the Zygote; it is the absolute first, highly microscopic physical form of human life.
            This flawlessly proves that despite possessing no physical Microscopes, the ancient sages could clearly see every single detail inside the womb through their profound meditative vision.
            This spiritual text actively reminds us that we were all born purely from an extremely slimy, filthy 'Kalala', hence having toxic pride over the physical body is utterly useless.
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 8,
        sanskrit = "सप्तरात्रोषितं बुद्बुदं भवति । अर्धमासाभ्यन्तरेण पिण्डो भवति । मासाभ्यन्तरेण कठिनो भवति ॥ ८ ॥",
        hindi = """
            (गर्भ का विकास): गर्भ ठहरने के ठीक 'सात रातों' (सप्तरात्र) के बाद, वह कलल एक पानी के 'बुलबुले' (बुद्बुदं / Bubble / Vesicle) का आकार ले लेता है।
            लगभग पंद्रह दिनों (अर्धमास / आधा महीना) के बीतने पर, वह बुलबुला एक ठोस 'पिण्ड' (Solid mass) में बदल जाता है।
            और एक पूरा महीना (मासाभ्यन्तरेण) बीत जाने के बाद, वह पिण्ड और अधिक कड़ा (कठिनो) और स्पष्ट रूप वाला हो जाता है।
            (इस पहले महीने में भ्रूण का सिर / Head आकार लेने लगता है)।
            यह 'वीक-बाय-वीक' (Week-by-week) प्रेगनेंसी ट्रैकर (Pregnancy tracker) है, जिसे हजारों साल पहले ऋषियों ने लिख दिया था।
            सात दिन में बुलबुला (बुद्बुद) बनने का मतलब है कि वह 'सेल्स' (Cells) का गुच्छा (Blastocyst) अब गर्भाशय की दीवार से जुड़ चुका है।
            15 दिन में 'पिण्ड' (Solid mass) बनने का अर्थ है कि भ्रूण अब एक आकार लेने लगा है (Embryo stage)।
            और 1 महीने बाद जब वह 'कठिन' (Hard) होता है, तो आधुनिक विज्ञान भी कहता है कि पहले महीने के अंत तक बच्चे के सिर और धड़ की आकृति बनने लगती है।
            यह कोई कोरी कल्पना नहीं, बल्कि एक परफेक्ट बायोलॉजिकल ऑब्जर्वेशन (Biological Observation) है।
            उपनिषद हमें यह इसलिए पढ़ा रहा है ताकि हम समझें कि हमारा यह सुंदर शरीर असल में कीचड़ और खून के कितने घिनौने विकास-क्रम से होकर गुजरा है।
        """.trimIndent(),
        english = """
            (Development of the fetus): Exactly 'Seven nights' (Saptaratra) after successful conception, that microscopic nodule flawlessly takes the shape of a water 'Bubble' (Budbudam / Vesicle).
            Upon the completion of approximately fifteen days (Ardhamasa / half a month), that bubble transforms perfectly into a 'Pinda' (a Solid, fleshy mass).
            And after the exact completion of one full month (Masabhyantarena), that solid mass becomes significantly harder (Kathino) and takes a much clearer, distinct form.
            (During this absolute first month, the actual head of the embryo actively begins to form and take shape).
            This is an absolutely flawless, ancient 'Week-by-week' Pregnancy Tracker, written by the great sages thousands of years ago.
            Becoming a bubble (Budbuda) in exactly seven days profoundly indicates that the cluster of Cells (Blastocyst) has successfully implanted into the uterine wall.
            Becoming a 'Pinda' (Solid mass) in 15 days explicitly means the embryo has now started taking a recognizable physical shape (Embryo stage).
            And becoming 'Kathina' (Hard) after 1 month perfectly matches modern science, which states that by the first month's end, the baby's head and torso physically begin to form.
            This is absolutely not empty imagination, but an exceptionally perfect, highly precise Biological Observation.
            The Upanishad explicitly teaches us this purely so we realize exactly what a filthy, disgusting evolutionary process of blood and mud our 'beautiful' physical body has suffered through.
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 9,
        sanskrit = "मासद्वयेन शिरः सम्पद्यते । मासत्रयेण पादप्रदेशो भवति ॥ ९ ॥",
        hindi = """
            (दूसरे और तीसरे महीने का विकास): गर्भ में पूरे दो महीने (मासद्वयेन) बीत जाने पर, उस भ्रूण का 'सिर' (शिरः / Head) पूरी तरह से स्पष्ट रूप से बन (सम्पद्यते) जाता है।
            और पूरे तीन महीने (मासत्रयेण) का समय बीतने पर, उस गर्भस्थ शिशु के 'पैर और हाथ' (पादप्रदेशो) आदि अंग भी स्पष्ट रूप से बन जाते हैं।
            आधुनिक एम्ब्रियोलॉजी (Embryology) भी ठीक यही कहती है: दूसरे महीने (लगभग 8वें हफ्ते) के अंत तक बच्चे का सिर शरीर के बाकी हिस्सों के मुकाबले काफी बड़ा और स्पष्ट हो जाता है।
            तीसरे महीने (लगभग 12वें हफ्ते) तक बच्चे के हाथ और पैरों की उंगलियां (Limbs and digits) पूरी तरह से विकसित होकर अलग-अलग दिखाई देने लगती हैं।
            यह कोई तुक्का (Guess) नहीं है; यह एक अत्यंत सूक्ष्म ज्ञान है जो योगियों ने अपनी दिव्य दृष्टि से देखा था।
            हम शरीर को भगवान का दिया हुआ कोई जादुई खिलौना समझते हैं, पर यह एक 'बायोलॉजिकल फैक्ट्री' (Biological Factory) का उत्पाद (Product) है।
            जैसे एक कुम्हार मिट्टी से धीरे-धीरे बर्तन बनाता है, वैसे ही प्रकृति माता के गर्भ में खून और मांस से इंसान की आकृति गढ़ रही है।
            इन चरणों को पढ़कर साधक के मन में शरीर के प्रति जो 'मोह' (Attraction) है, वह खत्म होने लगता है (वैराग्य पैदा होता है)।
            क्योंकि जो शरीर खून, पानी और मांस के इस भद्दे तरीके से बना है, उससे सच्चा सुख कैसे मिल सकता है?
            यही कारण है कि ज्ञानियों ने इस शरीर को 'मल-मूत्र का थैला' कहकर इसका घमंड छोड़ने की सलाह दी है।
        """.trimIndent(),
        english = """
            (Development in the second and third months): Upon the exact completion of two full months (Masadvayena) in the womb, the 'Head' (Shirah) of that fetus is completely, distinctly, and clearly formed (Sampadyate).
            And upon the exact completion of three full months (Masatrayena), the 'Feet and Hands' (Padapradesho) and other lower limbs of the unborn child are also visibly and clearly formed.
            Modern Medical Embryology states exactly the identical fact: by the end of the second month (around week 8), the baby's head becomes distinctly prominent and significantly larger compared to the rest of its body.
            By the exact third month (around week 12), the baby's limbs, hands, and feet (Limbs and digits) are completely developed and distinctly visible.
            This is absolutely not a lucky Guess; it is an exceedingly highly precise, microscopic knowledge that the Yogis clearly saw through their profound divine vision.
            We foolishly consider the physical body as a magical toy gifted by God, but it is strictly a biological Product manufactured flawlessly in a 'Biological Factory'.
            Exactly just as a potter slowly shapes a pot from wet clay, Nature painstakingly sculpts the human form strictly from blood and raw flesh inside the mother's womb.
            By deeply reading these exact stages, the blinding 'Attraction' (Moha) the seeker has toward the physical body begins to shatter completely (generating true Vairagya).
            Because how can any true, lasting happiness possibly be derived from a body manufactured in such a filthy, gruesome manner from blood, water, and flesh?
            This is exactly why enlightened sages have ruthlessly called this body a mere 'Bag of urine and feces', strictly advising humans to immediately abandon their toxic physical pride.
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 10,
        sanskrit = "अथ चतुर्थे मासे जठरकटिप्रदेशो भवति । पञ्चमे मासे पृष्ठवंशो भवति । षष्ठे मासे मुखनासिकाक्षिश्रोत्राणि भवन्ति ॥ १० ॥",
        hindi = """
            (चौथे से छठे महीने का विकास): इसके बाद (अथ), चौथे महीने (चतुर्थे मासे) में भ्रूण का 'पेट' (जठर) और 'कमर' (कटि) का हिस्सा पूरी तरह से बन जाता है।
            पांचवें महीने (पञ्चमे मासे) में उस शिशु की 'रीढ़ की हड्डी' (पृष्ठवंशो / Spine) का निर्माण पूरी तरह से हो जाता है।
            और छठे महीने (षष्ठे मासे) में शिशु का 'मुँह, नाक, आँखें और कान' (मुख-नासिका-अक्षि-श्रोत्राणि) आदि सभी ज्ञानेंद्रियां स्पष्ट रूप से बन जाती हैं।
            यह श्लोक शरीर के अत्यंत महत्वपूर्ण अंगों (Organs) के विकास का सटीक 'टाइमलाइन' (Timeline) दे रहा है।
            चौथे महीने में पेट और कमर का बनना यह दर्शाता है कि अब बच्चा गर्भाशय में अपनी जगह बना रहा है।
            पांचवें महीने में रीढ़ की हड्डी (Spine) का पूरा होना बहुत बड़ी बात है, क्योंकि यही हड्डी पूरे नर्वस सिस्टम (Nervous System) का आधार है।
            और छठे महीने में प्रकृति बच्चे को दुनिया देखने और सुनने के लिए 'सेंसर्स' (Sensors - आँख, कान, नाक) फिट (Fit) कर देती है।
            इस छठे महीने तक बच्चा एक ऐसा पुतला बन चुका है जिसके सारे हार्डवेयर (Hardware) तैयार हैं, पर अभी 'चेतना' (Consciousness) का पूरा प्रवेश नहीं हुआ है।
            यह प्रकृति का सबसे बड़ा चमत्कार है कि कैसे बिना किसी बाहरी कारीगर के, माता के खाए हुए भोजन से इतना जटिल (Complex) शरीर बन रहा है।
            परंतु इस 'चमत्कार' के पीछे भी बच्चे के अपने पिछले जन्मों के 'कर्म' ही असली डिज़ाइनर (Designer) होते हैं।
        """.trimIndent(),
        english = """
            (Development from fourth to sixth month): Thereafter (Atha), perfectly in the fourth month (Chaturthe mase), the 'Stomach' (Jathara) and the 'Waist' (Kati) region of the fetus are completely formed.
            In the absolute fifth month (Panchame mase), the 'Spinal Cord' (Prishthavamsho / Spine) of that unborn child is flawlessly and fully constructed.
            And perfectly in the sixth month (Shashthe mase), the 'Mouth, Nose, Eyes, and Ears' (Mukha-nasika-akshi-shrotrani) and all primary sense organs of the baby are distinctly and clearly formed.
            This phenomenal verse actively provides a highly accurate, flawless 'Timeline' of the precise development of the body's most critical internal Organs.
            The formation of the stomach and waist in the fourth month clearly indicates that the baby is now actively establishing its solid physical presence in the womb.
            The completion of the Spinal Cord in the fifth month is a massive milestone, because this exact bone is the absolute fundamental foundation of the entire Nervous System.
            And strictly in the sixth month, Nature systematically fits all the essential 'Sensors' (eyes, ears, nose) onto the baby to prepare it to perceive the external world.
            By this sixth month, the baby has become a highly complex puppet whose entire physical Hardware is perfectly ready, but full 'Consciousness' has not yet completely entered.
            It is Nature's absolute greatest miracle how such an incredibly Complex physical body is being effortlessly manufactured purely from the mother's consumed food, entirely without any external carpenter.
            However, strictly hiding flawlessly behind this 'miracle', it is the unborn baby's very own 'Karmas' from past lives that act as the actual, true Designer of this body.
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 11,
        sanskrit = "सप्तमे मासे जीवेन संयुक्तो भवति । अष्टमे मासे सर्वसम्पूर्णो भवति ॥ ११ ॥",
        hindi = """
            (सातवें और आठवें महीने का रहस्य): सातवें महीने (सप्तमे मासे) में वह शरीर रूपी ढांचा 'जीव' (चेतना / Soul) के साथ पूरी तरह से जुड़ (संयुक्तो) जाता है (उसमें प्राणों का संचार हो जाता है)।
            और आठवें महीने (अष्टमे मासे) में वह गर्भस्थ शिशु अपने सभी अंगों और लक्षणों के साथ पूरी तरह से 'सम्पूर्ण' (सर्वसम्पूर्णो / Fully developed) हो जाता है।
            यह श्लोक 'मेडिकल साइंस' और 'अध्यात्म' के बीच का सबसे बड़ा रहस्य खोलता है।
            छठे महीने तक शरीर केवल मांस का एक पुतला था; पर सातवें महीने में उसमें 'आत्मा' (जीव) अपने पुराने कर्मों की 'हार्ड-डिस्क' (Hard disk) लेकर प्रवेश करती है।
            इसीलिए सातवें महीने के बाद बच्चा पेट में जोर-जोर से लात (Kick) मारना और हरकत करना शुरू कर देता है, क्योंकि अब वह 'ज़िंदा' (Conscious) हो चुका है।
            आठवें महीने में उसका सारा शारीरिक विकास पूरा हो जाता है; उसके सारे अंग (Organs) 100% काम करने लगते हैं।
            अब वह बच्चा दुनिया में आने के लिए पूरी तरह से तैयार (Ready) है।
            जीव (आत्मा) का शरीर में आना यह साबित करता है कि आत्मा शरीर से नहीं बनती; शरीर केवल एक 'गाड़ी' है जिसमें आत्मा सातवें महीने में आकर बैठती है।
            यह ज्ञान हमें यह समझाता है कि गर्भपात (Abortion) सातवें महीने के बाद एक साक्षात् जीव (मनुष्य) की हत्या के समान भयंकर कर्म है।
            यहाँ से उस जीव के दुखों और यादों (Memories) का सिलसिला शुरू होता है।
        """.trimIndent(),
        english = """
            (The secret of the seventh and eighth months): In the absolute seventh month (Saptame mase), that physical bodily framework becomes perfectly and completely united (Samyukto) with the 'Jiva' (Soul / Consciousness) (vital life-force heavily infuses it).
            And precisely in the eighth month (Ashtame mase), that unborn fetus becomes entirely 'Complete' (Sarvasampurno / Fully developed) with absolutely all its bodily organs and physical characteristics perfectly formed.
            This spectacular verse explicitly reveals the absolute greatest secret existing exactly between modern 'Medical Science' and deep 'Spirituality'.
            Until the sixth month, the body was merely a growing puppet of raw flesh; but perfectly in the seventh month, the 'Soul' (Jiva) aggressively enters it, carrying the heavy 'Hard-Disk' of its past karmas.
            This is exactly why, after the seventh month, the baby aggressively begins to Kick forcefully and move violently in the womb, strictly because it is now fully 'Conscious' and 'Alive'.
            In the eighth month, its entire physical development is 100% completely finished; absolutely all its internal Organs begin functioning perfectly.
            The unborn baby is now absolutely, 100% flawlessly Ready to be delivered into the external physical world.
            The direct entry of the Jiva (Soul) into the body flawlessly proves that the Soul is absolutely not created by the physical body; the body is merely a 'Vehicle' in which the Soul actively takes a seat in the seventh month.
            This profound wisdom strictly explains that severe late-term Abortion (after the seventh month) is a highly terrifying karma exactly equivalent to the brutal murder of a direct, living human being.
            Exactly from this moment onwards, the relentless chain of that Jiva's terrible sorrows and haunting Memories officially begins.
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 12,
        sanskrit = "पितुरेतोऽतिरेकात् पुमान् भवति । मातुः रेतोऽतिरेकात् स्त्रियो भवन्ति । उभयोर्बीजतुल्यत्वान्नपुंसको भवति ॥ १२ ॥",
        hindi = """
            (बच्चे का लिंग कैसे तय होता है?): गर्भाधान के समय यदि पिता के वीर्य (Sperm/Seed) की अधिकता (अतिरेकात्/प्रबलता) होती है, तो 'पुत्र' (लड़का / पुमान्) पैदा होता है।
            यदि माता के रज़ (Ovum/स्त्री-बीज) की अधिकता या प्रबलता होती है, तो 'पुत्री' (लड़की / स्त्रियो) पैदा होती है।
            और यदि माता और पिता दोनों के बीज बिल्कुल 'समान' (तुल्यत्वात् / Equal) मात्रा या ताकत में होते हैं, तो एक 'नपुंसक' (किन्नर / Transgender) बच्चे का जन्म होता है।
            यह श्लोक प्राचीन काल की जेनेटिक्स (Genetics) का एक बहुत ही शानदार नियम है।
            आज का विज्ञान X और Y क्रोमोसोम (Chromosomes) की बात करता है, पर उपनिषदों ने इसे पुरुष (शुक्र) और स्त्री (रज) ऊर्जा की 'प्रबलता' के रूप में समझाया था।
            जिसकी एनर्जी (Energy/बीज) ज्यादा हावी होगी, बच्चा उसी का जेंडर (Gender) ले लेगा।
            यदि दोनों की ऊर्जा बिल्कुल बराबर हो जाए (कोई भी हावी न हो पाए), तो प्रकृति संतुलन (Balance) कर देती है और एक थर्ड-जेंडर (Third gender) बच्चे का जन्म होता है।
            यह स्पष्ट करता है कि किन्नर होना कोई 'श्राप' (Curse) नहीं है, बल्कि यह एक विशुद्ध बायोलॉजिकल और जेनेटिक (Biological and Genetic) घटना है।
            प्रकृति अपना काम पूरी तरह से केमिकल और ऊर्जा के गणित (Mathematics) के हिसाब से करती है।
            इंसान को लगता है कि बेटा या बेटी उसके हाथ में है, पर यह सब इन दोनों बीजों के आपस में टकराने की ताकत (Force) पर निर्भर करता है।
        """.trimIndent(),
        english = """
            (How exactly is the baby's gender determined?): At the exact moment of conception, if there is a massive excess or absolute dominance (Atirekat) of the Father's seed (Sperm/Virya), a 'Son' (Male boy / Puman) is successfully born.
            If there is a massive excess or absolute dominance of the Mother's seed (Ovum/Raja), a 'Daughter' (Female girl / Striyo) is successfully born.
            And if the reproductive seeds of both the mother and the father are exactly and perfectly 'Equal' (Tulyatvat) in sheer volume and absolute strength, an 'Eunuch' (Transgender / Napumsako) child is born.
            This phenomenal verse explicitly lays down a highly brilliant, foundational rule of ancient Genetics.
            Modern science endlessly talks about X and Y Chromosomes, but the Upanishads profoundly explained this exact phenomenon strictly as the sheer 'Dominance' of the male (Shukra) or female (Raja) raw energy.
            Whosever specific Energy (Seed) is aggressively more dominant, the unborn baby will flawlessly and inevitably adopt that exact Gender.
            If the explosive energies of both perfectly equalize (where neither can physically dominate the other), Nature automatically balances it, resulting in the birth of a Third-gender child.
            This flawlessly clarifies that being a transgender is absolutely not a divine 'Curse'; it is an exceptionally pure, 100% biological and Genetic occurrence.
            Nature flawlessly performs its highly complex work strictly according to the brutal Mathematics of bodily chemicals and reproductive energies.
            A human foolishly thinks that having a son or daughter is in his control, but it strictly and entirely depends on the terrifying raw Force with which these two seeds aggressively collide.
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 13,
        sanskrit = "व्याकुलितमनसोऽन्धाः खञ्जाः कुब्जा वामना भवन्ति । अन्योन्यवायुसङ्घर्षाद्द्विधा बीजं भवति ततस्तौ यमलो भवतः ॥ १३ ॥",
        hindi = """
            (विकलांगता और जुड़वां बच्चे कैसे होते हैं?): गर्भाधान (Conception) के समय यदि माता-पिता का मन अत्यंत 'व्याकुल' (भयभीत, दुखी या डरा हुआ) हो, तो बच्चा अंधा, लंगड़ा (खञ्ज), कुबड़ा या बौना (वामन) पैदा होता है।
            और यदि गर्भाधान के समय वायु (Air/प्राण) के भयंकर आपसी 'संघर्ष' (टकराव) के कारण वह बीज 'दो हिस्सों' (द्विधा) में टूट कर बँट जाता है।
            तो उसी बीज के दो टुकड़े होने के कारण माता के गर्भ से 'जुड़वां' (Twins / यमलौ) बच्चों का जन्म होता है।
            यह श्लोक 'एपीजेनेटिक्स' (Epigenetics) और मानसिक अवस्था (Mental state) के प्रभाव का सबसे बड़ा वैज्ञानिक सबूत है।
            अगर माता-पिता शारीरिक संबंध बनाते समय डरे हुए, गुस्से में या बहुत तनाव (Stress) में हों, तो उनके शरीर के केमिकल्स (Hormones) बिगड़ जाते हैं।
            उस गंदी और तनावपूर्ण ऊर्जा के कारण बच्चे के अंग (Organs) ठीक से नहीं बन पाते और बच्चा विकलांग पैदा होता है।
            इसीलिए भारतीय संस्कृति में गर्भ-संस्कार (Garbha Sanskar) और एक पवित्र, शांत मन से संतान पैदा करने पर सबसे ज्यादा जोर दिया गया है।
            जुड़वां बच्चों (Twins) का कारण भी एकदम सटीक बताया गया है: जब 'वायु' (Internal air pressure) के कारण जाइगोट (Zygote/बीज) दो हिस्सों में टूट जाता है, तो Identical Twins पैदा होते हैं।
            ऋषियों का यह ऑब्जर्वेशन (Observation) आज की आधुनिक मेडिकल साइंस के 100% बराबर है!
            यह दिखाता है कि एक स्वस्थ बच्चा पैदा करने के लिए केवल शरीर नहीं, बल्कि 'मन' (Mind) का स्वस्थ होना सबसे ज्यादा जरूरी है।
        """.trimIndent(),
        english = """
            (How do disabilities and Twins occur?): At the exact time of conception, if the minds of the parents are highly 'Vyakula' (terrified, intensely distressed, or agitated), the child is born blind, lame (Khanja), hunchbacked, or as a dwarf (Vamana).
            And if, exactly during conception, strictly due to the violent internal 'Friction and Collision' of vital air (Vayu/Prana), that single seed brutally splits and divides into 'Two halves' (Dvidha).
            Then, entirely and strictly because of that one seed aggressively splitting into two, 'Twins' (Yamalau) are successfully born from the mother's womb.
            This spectacular verse is the absolute greatest scientific proof of 'Epigenetics' and the devastating impact of the parents' exact Mental State.
            If the parents are terrified, violently angry, or under massive Stress during physical intimacy, their internal bodily Chemicals (Hormones) are instantly and brutally corrupted.
            Strictly due to that highly toxic and stressful energy, the unborn baby's Organs completely fail to develop properly, resulting in severe physical disabilities.
            This is exactly why Indian culture places the absolute highest emphasis on 'Garbha Sanskar' and conceiving children purely with an exceptionally sacred, peaceful mind.
            The exact, flawless reason for Twins is also perfectly stated: when the internal Air Pressure aggressively forces the single Zygote (Seed) to violently split into two halves, Identical Twins are born.
            This mind-blowing Observation of the ancient sages is exactly, 100% mathematically equal to today's highly advanced modern Medical Science!
            It flawlessly proves that to successfully birth a highly healthy child, merely a healthy body is absolutely not enough; an exceptionally healthy 'Mind' is the absolute strictest necessity.
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 14,
        sanskrit = "पञ्चात्मकः समर्थः पञ्चात्मकतेजसा समिद्धरसः । नवमे मासे सर्वलक्षणसम्पूर्णो भवति ॥ १४ ॥",
        hindi = """
            (नौवें महीने की स्थिति): यह पाँच भौतिक तत्वों (पञ्चात्मक) से बना हुआ जीव अब शरीर को धारण करने में पूरी तरह 'समर्थ' (सक्षम / Capable) हो जाता है।
            उसकी माँ जो भी भोजन करती है, उस भोजन के रस से उत्पन्न होने वाली जठराग्नि (पञ्चात्मक तेज) के द्वारा उस शिशु का शरीर पूरी तरह से पुष्ट (समिद्धरसः / पोषित) हो जाता है।
            और 'नौवें महीने' (नवमे मासे) तक आते-आते, वह गर्भस्थ शिशु अपने सभी प्रकार के शारीरिक और मानसिक 'लक्षणों' (Traits) के साथ 100% 'सम्पूर्ण' (तैयार) हो जाता है।
            नौवें महीने में बच्चा केवल शरीर नहीं रहता; उसका दिमाग (Brain) पूरी तरह से काम करने लगता है और वह चीजों को महसूस कर सकता है।
            माता जो कुछ भी खाती है, वह 'नाल' (Umbilical cord) के माध्यम से पचकर (रस बनकर) सीधा बच्चे को ताकत और गर्मी (तेज) देता है।
            इसीलिए कहा जाता है कि माता का खाना केवल शरीर नहीं, बल्कि बच्चे के स्वभाव (लक्षणों) को भी बनाता है।
            'सर्वलक्षण सम्पूर्ण' का अर्थ है कि अब उसके हाथ, पैर, दिल, दिमाग और यहाँ तक कि उसकी भावनाएं (Emotions) भी पूरी तरह से बन चुकी हैं।
            अब प्रकृति ने अपना काम पूरा कर दिया है; मशीन (शरीर) 100% रेडी (Ready) है।
            परंतु इस तैयार शरीर के अंदर जो 'जीव' फँसा हुआ है, उसकी मानसिक पीड़ा (Mental agony) इस 9वें महीने में अपनी चरम सीमा पर होती है।
            अगले श्लोकों में उस जीव की उसी भयंकर पीड़ा और उसके विलाप (रोने) का वर्णन किया जाएगा।
        """.trimIndent(),
        english = """
            (The absolute state in the ninth month): This Jiva, entirely composed of the five gross material elements (Panchatmakah), now becomes flawlessly and fully 'Samartha' (Capable/strong enough) to hold and sustain the physical body.
            Through the intense digestive fire (Panchatmaka tejas) generated strictly from the essence of the food fiercely consumed by his mother, the baby's entire physical body becomes completely and perfectly nourished (Samiddharasah).
            And exactly upon reaching the 'Ninth Month' (Navame mase), that unborn fetus becomes 100% absolutely 'Complete' (Sampurna / ready) with all its physical and mental 'Traits and characteristics' (Sarvalakshana) perfectly formed.
            In the ninth month, the baby absolutely does not remain just a piece of flesh; its Brain begins functioning completely, and it can flawlessly feel and experience things.
            Absolutely whatever the mother eats, its essence is digested and forcefully sent straight through the Umbilical Cord, providing immense raw strength and heat (Tejas) directly to the baby.
            This is exactly why it is strictly declared that the mother's food absolutely does not merely build the body, but flawlessly constructs the baby's very nature and character (Lakshanas).
            'Sarvalakshana sampurna' profoundly means that now its hands, feet, physical heart, brain, and even its complex Emotions are 100% perfectly built and fully operational.
            Nature has now flawlessly completed its massive biological task; the physiological Machine (body) is 100% completely Ready.
            However, the precise mental agony (Torture) of the conscious 'Jiva' pathetically trapped inside this fully ready physical body reaches its absolute, terrifying peak strictly in this 9th month.
            The subsequent magnificent verses will vividly and heartbreakingly describe that creature's terrifying agony and its desperate, tragic wailing (crying).
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 15,
        sanskrit = "पूर्वाजातीः स्मरति कृताकृतं च कर्म शुभाशुभं विन्दति । नानायोनिसहस्राणि दृष्ट्वा चैव ततो मया ॥ १५ ॥",
        hindi = """
            (गर्भ में जीव की याददाश्त): उस नौवें महीने में, वह जीव अपने 'पिछले कई जन्मों' (पूर्वाजातीः) को पूरी तरह से याद करता है (स्मरति)।
            उसने पिछले जन्मों में जो भी शुभ (अच्छे) और अशुभ (बुरे) कर्म किए थे, और जो नहीं किए थे (कृताकृतं), उन सभी का उसे स्पष्ट अहसास (विन्दति) होने लगता है।
            (वह जीव सोचता है): "हे भगवान! मैंने इससे पहले भी 'हजारों अलग-अलग योनियों' (नानायोनि-सहस्राणि) में जन्म लेकर अनगिनत शरीरों को देखा (दृष्ट्वा) और भोगा है।"
            यह योग मनोविज्ञान (Yogic Psychology) का सबसे डरावना और होश उड़ा देने वाला सच है।
            गर्भ के अंदर फँसा हुआ बच्चा कोई बेवकूफ नहीं है; 9वें महीने में उसका 'अवचेतन मन' (Subconscious mind) पूरी तरह से जाग्रत (Awake) हो जाता है।
            चूंकि अभी बाहर की दुनिया की कोई मेमोरी (Memory) नहीं है, इसलिए उसके दिमाग में 'पिछले जन्मों' की फ़िल्में (Movies) 4K क्वालिटी (Quality) में चलने लगती हैं।
            उसे याद आता है कि "पिछली बार मैंने फलां आदमी को धोखा दिया था (अशुभ कर्म), और फलां दान किया था (शुभ कर्म)।"
            वह यह भी याद करता है कि वह कभी कुत्ता था, कभी कीड़ा था, और कभी राजा था (हजारों योनियां)।
            वह जीव उस उल्टे लटके हुए शरीर में घोर अंधेरे के बीच अपने कर्मों का सारा हिसाब (Account) याद करके भयंकर रूप से पछताता है।
            प्रकृति इंसान को पैदा होने से पहले यह सारी फिल्म इसलिए दिखाती है ताकि वह इस बार बाहर जाकर फिर से वही पुरानी गलतियां न दोहराए!
        """.trimIndent(),
        english = """
            (The strict memory of the soul in the womb): Exactly in that ninth month, that conscious Jiva vividly, flawlessly, and completely remembers (Smarati) absolutely all his 'Multiple past births' (Purvajatih).
            He vividly and terrifyingly realizes and experiences (Vindati) absolutely all the good (Shubha) and bad (Ashubha) karmas he had committed, and those he had failed to commit (Kritakritam), in his past lives.
            (The tortured soul reflects): "O God! Even prior to this, I have helplessly taken birth in 'Thousands of different, terrifying wombs' (Nanayoni-sahasrani) and personally seen (Drishtva) and suffered through countless physical bodies."
            This is undeniably the absolute most terrifying, mind-blowing truth of ancient Yogic Psychology.
            The trapped unborn child inside the dark womb is absolutely no fool; precisely in the 9th month, his massive 'Subconscious Mind' becomes 100% fully Awake and active.
            Strictly because there is absolutely zero fresh memory of the outside world yet, incredibly vivid Movies of his 'Past Lives' violently begin playing in his brain in perfect 4K Quality.
            He vividly remembers, "Last time I ruthlessly cheated that specific man (Bad karma), and gave that specific charity (Good karma)."
            He also terrifyingly remembers that he was once a dog, once a filthy worm, and once a rich king (Thousands of different wombs).
            Hanging violently upside down in pitch darkness, that soul remembers his entire massive karmic Account and suffers unimaginably horrific, agonizing regret.
            Nature ruthlessly forces the human to vividly watch this entire terrifying movie right before birth purely so he absolutely does not repeat those exact same horrific mistakes outside!
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 16,
        sanskrit = "आहारा विविधा भुक्ताः पीता नानाविधाः स्तनाः । जातोऽहं मृत एवाहं जन्म चैव पुनः पुनः ॥ १६ ॥",
        hindi = """
            (जीव का विलाप / रोना जारी है): "मैंने अपने पिछले करोड़ों जन्मों में अनेक प्रकार के (विविधा) कीड़े-मकोड़े और घासों का भोजन (आहार) खाया है।"
            "मैंने हजारों अलग-अलग माताओं (जानवर और इंसान) के 'स्तनों' (स्तनाः / Breasts) का दूध भी पिया है।"
            "मैं न जाने कितनी बार पैदा हुआ हूँ (जातोऽहं) और कितनी बार अत्यंत पीड़ा के साथ मरा हूँ (मृत एवाहं)।"
            "और यह जन्म और मृत्यु का भयानक और अंतहीन चक्र मेरे साथ 'बार-बार' (पुनः पुनः) घटित हो रहा है!"
            यह गर्भ में फँसे हुए जीव का सबसे दर्दनाक 'कन्फेशन' (Confession / स्वीकारोक्ति) है।
            जब इंसान को पिछले जन्म याद आते हैं, तो उसे लगता है कि जिसे वह आज 'सुख' मान रहा है (माँ का दूध या अच्छा खाना), वह तो वह पिछले करोड़ों जन्मों से सूअर और कुत्ते के रूप में भी करता आ रहा है!
            "मैंने हज़ारों माँओं का दूध पिया है"—यह वाक्य इंसान के सारे घमंड को तोड़ देता है। हमारी आत्मा कितनी पुरानी और कितनी बार भटक चुकी है!
            उसे मौत का वह भयंकर दर्द याद आता है जब शरीर से प्राण निकलते हैं; और उसे फिर से पैदा होने की पीड़ा (Birth trauma) भी याद आती है।
            वह तड़प कर सोचता है कि "यह मैं किस भयंकर लूप (Loop / चक्र) में फँस गया हूँ जहाँ बस पैदा होना है और मरना है?"
            यह श्लोक साबित करता है कि पुनर्जन्म (Rebirth) कोई थ्योरी (Theory) नहीं, बल्कि एक थका देने वाली भयंकर हकीकत (Reality) है जो हर जीव को झेलनी पड़ती है।
        """.trimIndent(),
        english = """
            (The wailing of the soul continues): "In my millions of past lifetimes, I have aggressively and helplessly consumed highly varied (Vividha) and filthy foods (Ahara) like insects and harsh grass."
            "I have helplessly drunk the breast milk from the 'Breasts' (Stanah) of literally thousands of completely different mothers (both animals and humans)."
            "I have been born (Jato'ham) countless millions of times, and I have violently and painfully died (Mrita evaham) exactly that many times."
            "And this terrifying, agonizing, and endless brutal cycle of birth and death continues to happen to me 'Again and again' (Punah punah)!"
            This is undeniably the absolute most heartbreaking and agonizing 'Confession' of a helpless, tortured soul trapped in the dark womb.
            When a human vividly remembers his past lives, he realizes perfectly that what he foolishly considers 'Pleasure' today (mother's milk or tasty food), he has already actively done as a filthy pig and dog for millions of past lives!
            "I have drunk the milk of thousands of mothers"—this single terrifying sentence completely shatters absolutely all human arrogance. How incredibly ancient and lost our Soul truly is!
            He vividly remembers that agonizing, terrifying pain of death when the breath is violently ripped from the body; and he fiercely remembers the horrific trauma of taking birth again.
            He thrashes in extreme agony thinking, "What incredibly terrifying, endless Loop have I gotten brutally trapped in, where I strictly only have to be born and die repeatedly?"
            This stunning verse flawlessly proves that Reincarnation (Rebirth) is absolutely not a cheap Theory, but an exhausting, horrific, and brutal Reality that every single creature is forced to suffer.
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 17,
        sanskrit = "अहो दुःखोदधौ मग्नः न पश्यामि प्रतिक्रियाम् । यन्मया परिजनस्यार्थे कृतं कर्म शुभाशुभम् ॥ १७ ॥",
        hindi = """
            (जीव का रोना): "अहो! (कितने दुःख की बात है!) मैं इस अत्यंत भयंकर 'दुखों के महासागर' (दुःखोदधौ) में पूरी तरह से डूब (मग्नः) चुका हूँ।"
            "और इस नर्क जैसी कैद (गर्भ) से बाहर निकलने का या इससे बचने का मुझे कोई भी 'उपाय' (प्रतिक्रियाम् / Solution) बिल्कुल दिखाई नहीं दे रहा है (न पश्यामि)।"
            "पिछले जन्मों में मैंने अपने 'परिवार वालों' और रिश्तेदारों (परिजनस्यार्थे) के भरण-पोषण के लिए जो भी अच्छे (शुभ) और बुरे (अशुभ / पाप) कर्म किए थे।"
            (उन सभी पापों का भयंकर फल आज मुझे इस अंधेरे और मल-मूत्र से भरे गर्भ में अकेला ही भुगतना पड़ रहा है!)।
            यह श्लोक इंसान के सबसे बड़े धोखे (Illusion) को बेनकाब (Expose) कर रहा है।
            हम जीवन भर अपनी पत्नी, बच्चों और रिश्तेदारों को खुश करने के लिए झूठ बोलते हैं, बेईमानी करते हैं और पाप (अशुभ कर्म) कमाते हैं।
            हम सोचते हैं कि हम अपने परिवार के लिए कर रहे हैं; पर जब कर्मों की सजा (सजा के रूप में गर्भ की पीड़ा) मिलती है, तो वहाँ कोई भी रिश्तेदार साथ नहीं होता।
            जीव रोता है कि "मैंने दूसरों (परिजन) के लिए चोरी की, पर आज इस नर्क (गंदे पानी और उलटे लटके रहने की पीड़ा) में मैं बिल्कुल 'अकेला' सड़ रहा हूँ।"
            यह एक अत्यंत कड़वा सच है कि कर्मों का बिल (Bill) केवल और केवल उसी व्यक्ति को चुकाना पड़ता है जिसने कर्म किया है; परिवार केवल पैसे का हिस्सेदार है, पापों का नहीं।
            गर्भ में फँसा बच्चा अपनी इस मूर्खता पर खून के आँसू रोता है कि वह झूठे रिश्तों के लिए अपने भगवान को भूल गया था।
        """.trimIndent(),
        english = """
            (The weeping of the soul): "Alas! (What unimaginable tragedy!) I am completely and helplessly drowned (Magnah) exactly in this terrifying, massive 'Ocean of Agonizing Sorrow' (Dukhodadhau)."
            "And I absolutely cannot see (Na pashyami) any possible 'Solution' or escape route (Pratikriyam) whatsoever to successfully get out of this hellish, terrifying physical prison (womb)."
            "In my past lives, absolutely all the good (Shubha) and horrific bad (Ashubha / Sinful) actions I forcefully committed strictly for the sake of fiercely providing for my 'Family and relatives' (Parijanasyarthe)."
            (Today, I am brutally forced to suffer the terrifying, agonizing fruits of all those dark sins completely alone right in this pitch-dark womb filled entirely with feces and urine!).
            This spectacular verse ruthlessly Exposes the absolute greatest, most pathetic Delusion (Illusion) of all human beings.
            We spend our entire lives telling filthy lies, aggressively cheating, and committing heavy sins (Bad karma) exclusively to please our wives, children, and greedy relatives.
            We foolishly think we are doing it nobly for our family; but when the terrifying punishment of karma (the horrific agony of the womb) arrives, absolutely no relative is ever there to share it.
            The tortured soul violently cries, "I ruthlessly stole for others (Family), but today I am rotting absolutely 'Alone' exactly in this terrifying hell (the agony of hanging upside down in dirty fluids)."
            It is an exceptionally bitter, harsh truth that the brutal Bill of karmas must be paid strictly and exclusively by the one who actually committed them; the family simply shares the cash, absolutely never the sins.
            The helpless baby trapped in the womb cries tears of blood over his absolute sheer stupidity that he entirely forgot his God strictly for the sake of cheap, fake worldly relationships.
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 18,
        sanskrit = "एकाकी तेन दह्येऽहं गतास्ते फलभागिनः । यदि योन्याः प्रमुञ्चामि साङ्ख्यं योगं समाश्रये ॥ १८ ॥",
        hindi = """
            (जीव का पश्चाताप और प्रतिज्ञा): "उन पाप कर्मों की भयंकर आग में आज मैं यहाँ गर्भ में बिल्कुल 'अकेला' (एकाकी) ही जल (दह्येऽहं) रहा हूँ।"
            "जिन रिश्तेदारों के लिए मैंने वो पाप किए थे, वे तो उन कर्मों के फलों (पैसों और सुखों) को भोगकर (फलभागिनः) कब के जा चुके हैं (गतास्ते / वे चले गए)।"
            (अब जीव भगवान से कसम खाता है): "हे ईश्वर! यदि किसी तरह मैं इस भयानक योनि (माता के गर्भ / योन्याः) की कैद से आज़ाद (प्रमुञ्चामि) हो जाऊँ।"
            "तो मैं बाहर जाते ही सबसे पहले 'सांख्य' (आत्मज्ञान) और 'योग' (ध्यान) के परम मार्ग का पूरी तरह से आश्रय (समाश्रये) लूँगा (मैं केवल आपकी भक्ति करूँगा)।"
            यह 'गर्भ-गीता' (Garbha Gita) का सबसे इमोशनल (Emotional) और आँखें खोलने वाला पल है।
            बच्चे को यह समझ आ गया है कि दुनिया में कोई किसी का सगा नहीं है; जिनके लिए उसने जान दी, वे मजे करके चले गए, और वह यहाँ उल्टा लटक कर नर्क भोग रहा है।
            इस भयंकर दर्द (Suffering) में वह भगवान से एक पक्की 'कसम' (Vow) खाता है कि "बस एक बार मुझे इस जेल से बाहर निकाल दो!"
            "मैं बाहर जाकर अपना समय टीवी, पैसे या फालतू दोस्तों में बर्बाद नहीं करूँगा; मैं अपना पूरा जीवन सांख्य (ज्ञान) और योग (मेडिटेशन) में लगाऊँगा।"
            दुनिया का हर इंसान जन्म लेने से ठीक पहले अपनी माँ के पेट में भगवान से यही 'वादा' करके बाहर आता है।
            पर अफसोस, बाहर आते ही माया उसे ऐसी थप्पड़ मारती है कि वह अपना यह सबसे बड़ा वादा भूल जाता है।
        """.trimIndent(),
        english = """
            (The soul's agonizing regret and solemn vow): "Today, I am burning (Dahye'ham) completely 'Alone' (Ekaki) in the terrifying, blazing fire of those horrific sinful past actions exactly inside this dark womb."
            "Those greedy relatives for whose sake I ruthlessly committed those severe sins, they have long since enjoyed the rich fruits (wealth and joy) of my actions (Phalabhaginah) and completely left (Gataste / they are gone)."
            (Now the desperate soul violently swears an oath to God): "O Supreme Lord! If by some miracle I am successfully freed and released (Pramunchami) from the horrifying, terrifying prison of this womb (Yonyah)."
            "The exact absolute first thing I will do upon getting out is take complete, unbroken refuge (Samashraye) strictly in the supreme path of 'Sankhya' (Self-knowledge) and 'Yoga' (Deep Meditation) (I will worship exclusively You)."
            This is undeniably the absolute most Emotional and eye-opening moment of the entire 'Garbha Gita' (Song of the Womb).
            The unborn child has profoundly realized that absolutely no one in the world truly belongs to anyone; those he died for enjoyed themselves and left, while he is brutally suffering hell hanging violently upside down here.
            In this unimaginably terrifying, horrific pain (Suffering), he frantically makes an ironclad 'Oath' (Vow) to God: "Just please get me out of this terrifying prison just this one single time!"
            "I will absolutely not go out and waste my precious time on TV, money, or useless fake friends; I will actively dedicate my entire life exclusively to Sankhya (Wisdom) and Yoga (Meditation)."
            Every single human being in the entire world comes out of his mother's stomach strictly making this exact same desperate 'Promise' to God right before taking birth.
            But tragically, the exact split-second he comes out, Maya slaps him so violently hard that he instantly and completely forgets this absolute greatest promise of his life.
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 19,
        sanskrit = "अशुभक्षयकर्तारं फलमुक्तिप्रदायकम् । यदि योन्याः प्रमुञ्चामि तं प्रपद्ये महेश्वरम् ॥ १९ ॥",
        hindi = """
            (जीव की प्रतिज्ञा जारी है): "जो भगवान मेरे सभी अशुभ (बुरे/पाप) कर्मों का पूरी तरह से नाश (क्षयकर्तारं) करने वाले हैं।"
            "और जो मेरी इस भयंकर पीड़ा को मिटाकर मुझे कर्मों के फलों से हमेशा के लिए मोक्ष (मुक्ति / फलमुक्ति) प्रदान (प्रदायकम्) करने वाले हैं।"
            "यदि मैं किसी भी तरह इस नर्क जैसी योनि (गर्भ) की भयानक कैद से बाहर निकल जाऊँ (प्रमुञ्चामि)।"
            "तो मैं साक्षात् उन परम कृपालु 'महेश्वर' (भगवान शिव / परमेश्वर) की ही पूरी तरह से शरण (प्रपद्ये) में चला जाऊँगा।"
            गर्भ में फँसा हुआ जीव अब एक बहुत ही गहरे 'सरेंडर' (Surrender / समर्पण) की अवस्था में आ चुका है।
            उसे पता है कि उसकी अपनी कोई ताकत उसे इस अंधेरे जेल से नहीं निकाल सकती; उसे केवल 'महेश्वर' (Highest God) की कृपा ही बचा सकती है।
            वह भगवान को 'अशुभक्षयकर्तारं' (पापों का नाश करने वाला) कह रहा है, क्योंकि उसे समझ आ गया है कि उसके दुख की जड़ उसके अपने ही पाप हैं।
            वह भगवान से कोई खिलौना या पैसा नहीं माँग रहा; वह 'फलमुक्ति' (कर्मों के चक्र से आज़ादी) माँग रहा है।
            यह श्लोक दिखाता है कि जब इंसान पर सबसे भयंकर संकट आता है (चाहे वह गर्भ हो या मौत), तो उसका अहंकार टूट जाता है और उसे असली भगवान याद आता है।
            हम सबने भी गर्भ में 9वें महीने में यही प्रार्थना की थी, पर जन्म लेते ही हम फिर से दुनिया के झूठे भगवानों (पैसे, पावर) की शरण में चले गए।
        """.trimIndent(),
        english = """
            (The soul's vow strictly continues): "That Supreme Lord who is the absolute, ultimate destroyer (Kshayakartaram) of absolutely all my horrific Ashubha (evil/sinful) past actions."
            "And who alone is the supreme bestower (Pradayakam) of permanent Moksha (absolute freedom from the terrible fruits of karma / Phalamukti) by completely erasing this excruciating agony."
            "If I can somehow miraculously escape and be completely released (Pramunchami) from the horrifying, terrifying prison of this hellish womb (Yoni)."
            "Then I will go completely and permanently straight into the absolute, flawless refuge (Prapadye) of strictly that supremely compassionate 'Maheshwara' (Lord Shiva / Supreme God) alone."
            The helpless, trapped soul in the dark womb has now flawlessly reached a state of exceptionally profound and absolute 'Surrender'.
            He knows perfectly well that absolutely zero personal strength of his own can ever get him out of this pitch-dark jail; exclusively only the pure grace of 'Maheshwara' (Highest God) can save him.
            He is desperately calling God 'Ashubhakshayakartaram' (the destroyer of sins) because he has deeply understood that the absolute root of his brutal suffering is his very own horrific sins.
            He is absolutely not begging God for a cheap toy or money; he is desperately begging for 'Phalamukti' (complete freedom from the vicious cycle of karmas).
            This phenomenal verse explicitly shows that when the absolute most terrifying crisis hits a human (whether in the womb or at death), his toxic ego shatters completely and he intensely remembers the real God.
            All of us meticulously made this exact same prayer in the 9th month strictly inside the womb, but the exact second we were born, we immediately took refuge in the fake gods (money, power) of the world again.
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 20,
        sanskrit = "यदि योन्याः प्रमुञ्चामि तं प्रपद्ये नारायणम् । देवं नारायणं देवं भगवन्तं जनार्दनम् ॥ २० ॥",
        hindi = """
            (जीव का विलाप और प्रार्थना जारी है): "यदि मैं इस भयंकर गर्भ (योनि) के घोर कष्टों से मुक्त हो जाऊँ (प्रमुञ्चामि)।"
            "तो मैं बाहर जाते ही साक्षात् उन परम रक्षक भगवान 'नारायण' (विष्णु) की पूर्ण रूप से शरण (प्रपद्ये) में चला जाऊँगा।"
            "मैं केवल उन परम देव (प्रकाशस्वरूप), सभी में निवास करने वाले 'नारायण', और सभी ঐश्वर्यों (Glories) से पूर्ण 'भगवान' की ही पूजा करूँगा।"
            "और मैं उन जनार्दन (दुष्टों का नाश करने वाले और भक्तों की रक्षा करने वाले विष्णु) को ही अपना सब कुछ मानूँगा।"
            उपनिषद यहाँ बहुत ही खूबसूरती से यह स्पष्ट कर रहा है कि 'महेश्वर' (शिव) और 'नारायण' (विष्णु) दोनों एक ही परम सत्य के दो नाम हैं।
            पिछले श्लोक में जीव ने महेश्वर की शरण माँगी थी, और यहाँ वह नारायण को पुकार रहा है; अद्वैत में इन दोनों में कोई भी भेद (Difference) नहीं है।
            'नारायण' का अर्थ है 'नर' (जीवों) का 'अयन' (आश्रय/घर); जीव कह रहा है कि "मेरा असली घर यह गंदा गर्भ नहीं है, मेरा घर तो आप (नारायण) हैं।"
            'जनार्दन' का अर्थ है जो जन्म-मरण के दुखों का नाश करता है। जीव भयंकर रूप से तड़प रहा है और पुकार रहा है कि "मुझे इस बार बचा लो, मैं बाहर जाकर केवल आपका नाम लूँगा।"
            यह इंसान की सबसे असली (Genuine) प्रार्थना है, क्योंकि इसमें कोई दिखावा नहीं है, केवल शुद्ध दर्द और तड़प है।
            अगर इंसान बाहर (दुनिया में) भी इसी तड़प और सच्चाई के साथ भगवान को पुकारे, तो उसे मोक्ष मिलने में एक सेकंड भी नहीं लगेगा।
        """.trimIndent(),
        english = """
            (The soul's wailing and desperate prayer continues): "If I can successfully be completely freed (Pramunchami) from the horrific, terrifying agonies of this dark womb (Yoni)."
            "Then the exact split-second I get out, I will take absolute, complete, and flawless refuge (Prapadye) strictly in the Supreme Protector, Lord 'Narayana' (Vishnu)."
            "I will exclusively worship only that Supreme Deity (Devam/Radiant one), the all-pervading 'Narayana', and that 'Bhagavan' who is completely filled with absolutely all divine Glories."
            "And I will consider strictly that 'Janardana' (the fierce destroyer of evil and the ultimate protector of devotees) as my absolute everything."
            The Upanishad is exceptionally beautifully clarifying here that 'Maheshwara' (Shiva) and 'Narayana' (Vishnu) are strictly just two different names for the exact same One Supreme Truth.
            In the previous verse, the soul frantically begged for the refuge of Maheshwara, and here he desperately calls out to Narayana; in Advaita, there is absolutely zero Difference between the two.
            'Narayana' literally means the 'Ayana' (Refuge/Home) of 'Nara' (all living beings); the soul is crying, "My real home is absolutely not this filthy womb, my true home is strictly You (Narayana)."
            'Janardana' explicitly means the one who annihilates the brutal sorrows of birth and death. The soul is thrashing in extreme agony and begging, "Please save me just this once, I will go out and strictly chant only Your name."
            This is undeniably a human being's absolute most 'Genuine' prayer, because there is absolutely zero hypocrisy in it, only pure, naked pain and burning desperation.
            If a human being calls out to God exactly with this exact same burning desperation and pure honesty even outside (in the world), it wouldn't take even a single second for him to attain absolute Moksha.
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 21,
        sanskrit = "अथ खलु गर्भो मासे दशमे सम्प्राप्ते प्रसूतिमारुतेन नुद्यमानो निःसरति । ततो यन्त्रपीडित इव बाण इव निःसरति ॥ २१ ॥",
        hindi = """
            (जन्म का भयंकर आघात / The Trauma of Birth): इसके बाद (अथ खलु), जब वह गर्भस्थ शिशु पूरे 'दसवें महीने' (मासे दशमे सम्प्राप्ते) में प्रवेश करता है।
            तो वह डिलीवरी (Delivery) के समय चलने वाली 'प्रसूति-मारुत' (जन्म देने वाली एक अत्यंत तीव्र और विशेष वायु) के द्वारा बहुत भयंकर रूप से धकेला (नुद्यमानो) जाता है और बाहर निकलता (निःसरति) है।
            उस समय उस जीव को ऐसा भयंकर दर्द होता है मानो उसे किसी बहुत बड़ी 'मशीन' (यंत्र) के बीच में रखकर क्रूरता से 'पीसा' (पीडित इव) जा रहा हो।
            और फिर वह माता के शरीर से एक तीर (बाण इव) की तरह भयंकर स्पीड (Speed) से बाहर की दुनिया में 'फेंका' (निःसरति) जाता है।
            यह श्लोक जन्म लेने की प्रक्रिया (Childbirth) का सबसे क्रूर और यथार्थ (Brutally realistic) वर्णन है।
            हम जन्म को एक 'खुशी' का मौका मानते हैं, पर उपनिषद कहता है कि जन्म लेना इंसान की जिंदगी का सबसे बड़ा 'ट्रॉमा' (Trauma/पीड़ा) है।
            'प्रसूति-मारुत' वह बायोलॉजिकल फोर्स (Biological force/Contractions) है जो बच्चे को योनि-मार्ग (Birth canal) से बाहर धकेलती है।
            जब बच्चा उस पतले से रास्ते से बाहर आता है, तो उसकी कोमल हड्डियों और शरीर पर इतना भयंकर दबाव (Pressure) पड़ता है जैसे उसे किसी 'मशीन में पीसा' जा रहा हो (यंत्र-पीडित)।
            इस असहनीय दर्द के कारण ही बच्चा बाहर आते ही सबसे पहले जोर-जोर से रोता (Cries) है।
            जन्म लेना कोई उत्सव नहीं है; यह तो एक दर्दनाक सजा है जो जीव को उसके पिछले कर्मों के कारण बार-बार भुगतनी पड़ती है।
        """.trimIndent(),
        english = """
            (The terrifying trauma and shock of Birth): Thereafter (Atha khalu), when that fully formed fetus perfectly and completely enters the full 'Tenth Month' (Mase dashame samprapte).
            He is violently, brutally, and mercilessly pushed and shoved down (Nudyamano) precisely by the 'Prasuti-maruta' (a highly specific, extremely intense biological wind/force of delivery) and begins to exit (Nihsarati).
            Exactly at that moment, that helpless soul suffers such horrific, agonizing pain exactly as if he were being cruelly and violently 'Crushed' completely inside a massive, grinding 'Machine' (Yantra-pidita iva).
            And then, exactly like a high-speed, violently shot 'Arrow' (Bana iva), he is brutally and aggressively 'Thrown out' (Nihsarati) of the mother's body directly into the external world.
            This phenomenal verse is undeniably the absolute most brutal, incredibly realistic, and terrifyingly accurate description of the actual process of Childbirth.
            We foolishly celebrate birth as an 'occasion of joy', but the Upanishad fiercely declares that taking birth is unequivocally a human being's absolute greatest 'Trauma' (Agonizing pain).
            'Prasuti-maruta' is that exact immense biological Force (violent uterine Contractions) that ruthlessly pushes the fragile baby entirely through the extremely tight birth canal.
            When the baby is forcefully squeezed through that incredibly narrow passage, its extremely fragile bones and body suffer such a terrifying, massive Pressure exactly as if being 'crushed in an iron machine' (Yantra-pidita).
            Strictly due to this completely unbearable, horrific agony, the absolute very first thing the baby does upon exiting is cry violently and loudly.
            Taking birth is absolutely no celebration; it is a terrifying, painful punishment that the creature is forced to brutally suffer repeatedly strictly due to its past dark karmas.
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 22,
        sanskrit = "जायमानो वैष्णव्या मायया संस्पृष्टः । तदा न किञ्चित्स्मरति न शुभाशुभं कर्म विन्दति ॥ २२ ॥",
        hindi = """
            (जन्म के तुरंत बाद की घटना / The Cosmic Memory Wipe): जैसे ही वह शिशु इस दुनिया में बाहर पैदा होता है (जायमानो)।
            वह तुरंत भगवान विष्णु की अत्यंत शक्तिशाली 'वैष्णवी माया' (Illusion/संसार का पर्दा) के द्वारा स्पर्श (संस्पृष्टः / Touch) कर लिया जाता है।
            उस भयंकर माया के टच (Touch) करते ही, वह बच्चा अपने पिछले जन्मों और गर्भ के वादों (Vows) के बारे में 'कुछ भी याद नहीं' रख पाता (तदा न किञ्चित् स्मरति)।
            और अब उसे अपने पिछले जन्मों के किसी भी अच्छे (शुभ) या बुरे (अशुभ) कर्म का बिल्कुल कोई भी भान या अहसास (विन्दति) नहीं रहता।
            यह श्लोक 'हम पिछले जन्मों को क्यों भूल जाते हैं?'—इस सबसे बड़े सवाल का सीधा जवाब देता है।
            गर्भ के अंदर बच्चे को सब कुछ याद था (श्लोक 15); पर बाहर आते ही 'वैष्णवी माया' उसे एक जोरदार थप्पड़ (Touch) मारती है।
            इस माया का टच (Touch) एक कॉस्मिक 'मेमोरी वाइप' (Cosmic Memory Wipe / Format) की तरह काम करता है, जो बच्चे की हार्ड डिस्क (Hard Disk) से पिछले जन्मों की सारी यादें तुरंत डिलीट (Delete) कर देता है।
            अगर उसे पुराने जन्म याद रहें, तो वह बच्चा पैदा होते ही 'संन्यासी' बन जाएगा और दुनिया (Matrix) का खेल ही रुक जाएगा।
            प्रकृति को अपना यह दुनिया का नाटक (Drama) चालू रखना है, इसलिए वह इंसान को 'भुलक्कड़' (Amnesiac) बनाकर ही दुनिया के स्टेज (Stage) पर भेजती है।
            हम सब उसी माया के मारे हुए भुलक्कड़ लोग हैं, जो भगवान से किए गए अपने सबसे बड़े वादे को भूलकर फिर से खिलौनों (पैसों) में उलझ गए हैं।
        """.trimIndent(),
        english = """
            (The terrifying event immediately after birth / The Cosmic Memory Wipe): The exact split-second that helpless child is born outside into this physical world (Jayamano).
            He is instantaneously, aggressively touched and struck (Samspirshtah) strictly by Lord Vishnu's incredibly terrifying and powerful 'Vaishnavi Maya' (the blinding veil of cosmic Illusion).
            The exact moment that horrific Maya strictly Touches him, that baby completely and permanently 'remembers absolutely nothing' (Tada na kinchit smarati) about his past lives or his desperate vows made in the womb.
            And now, he retains absolutely zero awareness, feeling, or realization (Vindati) of absolutely any of his good (Shubha) or horrific bad (Ashubha) karmas from his past millions of lives.
            This spectacular verse provides the absolute direct, perfect answer to humanity's greatest question: 'Why exactly do we forget our past lives?'
            Inside the dark womb, the baby remembered absolutely everything flawlessly (Verse 15); but the exact second he comes out, 'Vaishnavi Maya' violently slaps (Touches) him.
            The brutal Touch of this Maya acts exactly like a massive Cosmic 'Memory Wipe' (Total Format), instantly and permanently Deleting all past-life memories entirely from the baby's mental Hard Disk.
            If he clearly remembered his horrific past lives, the baby would instantly become a 'Sannyasi' upon birth, and the entire complex game of the world (Matrix) would permanently stop.
            Nature absolutely has to keep its grand worldly Drama running smoothly, which is exactly why she forces humans onto the world's Stage exclusively as complete 'Amnesiacs' (forgetful beings).
            We are all precisely those exact forgetful, pathetic people violently struck by that Maya, who completely forgot our absolute greatest promise to God and helplessly entangled ourselves in cheap toys (money) again.
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 23,
        sanskrit = "शरीरमिति कस्मात् ? अग्नयो ह्यत्र श्रियन्ते । ज्ञानाग्निर्दशनाग्निः कोष्ठाग्निरिति ॥ २३ ॥",
        hindi = """
            (अब शरीर के नाम का रहस्य): प्रश्न उठता है कि इस पुतले को 'शरीर' (Sharira) ही क्यों कहा जाता है?
            उत्तर: क्योंकि इसके भीतर मुख्य रूप से 'तीन प्रकार की अग्नियां' (अग्नयो) हमेशा आश्रय (श्रियन्ते / निवास) लिए रहती हैं।
            इन तीन महान अग्नियों के नाम हैं: 1. 'ज्ञानाग्नि' (ज्ञान की आग), 2. 'दर्शनाग्नि' (देखने की आग), और 3. 'कोष्ठाग्नि' (पेट/पाचन की आग)।
            संस्कृत में 'शरीर' शब्द 'शीर्यते' धातु से बना है, जिसका अर्थ है—जो हमेशा जलता रहे और धीरे-धीरे नष्ट होता रहे (That which decays)।
            यह हमारा शरीर किसी शांत बर्फ का टुकड़ा नहीं है; यह एक 'भट्टी' (Furnace) है जो 24 घंटे लगातार जल रही है।
            'ज्ञानाग्नि' हमारे दिमाग (Brain) में जल रही है जो विचारों को प्रोसेस (Process) करती है।
            'दर्शनाग्नि' हमारी आँखों में जल रही है जो बाहर की दुनिया के दृश्यों को जलाकर (Capture करके) अंदर भेजती है।
            और 'कोष्ठाग्नि' हमारे पेट में जल रही है जो हमारे खाए हुए भोजन को जलाकर (Digest करके) शरीर को ऊर्जा देती है।
            क्योंकि ये तीनों आग इस शरीर को लगातार अंदर से 'जला' रही हैं और इसे धीरे-धीरे मौत (Decay) की तरफ ले जा रही हैं।
            इसी जलने और धीरे-धीरे खत्म होने (Wear and tear) की प्रक्रिया के कारण ही इस भौतिक ढांचे का नाम 'शरीर' रखा गया है।
        """.trimIndent(),
        english = """
            (Now the profound secret behind the name of the body): The question naturally arises, why exactly is this physical puppet called a 'Sharira' (Body)?
            Answer: Strictly because exactly 'Three specific types of Fires' (Agnayo) perpetually take continuous refuge and actively reside (Shriyante) right within it.
            The exact names of these three magnificent internal fires are: 1. 'Jnanagni' (the fire of wisdom/intellect), 2. 'Darshanagni' (the fire of visual sight), and 3. 'Koshthagni' (the fire of the stomach/digestion).
            In Sanskrit, the word 'Sharira' is derived perfectly from the root 'Shiryate', which literally means—that which is continuously burning and constantly decaying (That which decays).
            This physical body of ours is absolutely not a quiet, cold piece of ice; it is a violently blazing 'Furnace' that is actively burning 24 hours a day without stopping.
            'Jnanagni' is constantly burning fiercely in our Brain, actively processing countless thoughts and complex data.
            'Darshanagni' is actively burning right in our physical eyes, aggressively burning (Capturing) the visual scenes of the outside world and sending them inside.
            And 'Koshthagni' is fiercely blazing exactly in our stomach, violently burning (Digesting) our consumed food to provide raw vital energy to the body.
            Strictly because these three intense fires are continuously 'Burning' this body from the inside out, slowly and steadily dragging it relentlessly toward inevitable death (Decay).
            Exactly due to this relentless, unstoppable process of continuous burning and gradual physical deterioration (Wear and tear), this gross physical framework is profoundly named 'Sharira'.
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 24,
        sanskrit = "तत्र कोष्ठाग्निर्नामाशितपीतलीढखादितं पचतीति । दर्शनाग्नि रूपं पश्यति । ज्ञानाग्निः शुभाशुभं कर्म विन्दति ॥ २४ ॥",
        hindi = """
            (उन तीनों अग्नियों का कार्य): उन तीनों में से, 'कोष्ठाग्नि' (पेट की आग / Digestive fire) वह है जो हमारे द्वारा खाए गए (आशित), पिए गए (पीत), चाटे गए (लीढ) और चबाए गए (खादितं) सभी प्रकार के भोजन को अच्छी तरह पचाती (पचतीति) है।
            'दर्शनाग्नि' (आँखों की आग) वह है जिसके द्वारा मनुष्य इस संसार के सभी प्रकार के 'रूपों' (रंग और आकार / रूपं) को स्पष्ट रूप से देखता है (पश्यति)।
            और सबसे महान 'ज्ञानाग्नि' (बुद्धि/ज्ञान की आग) वह है जो मनुष्य को उसके द्वारा किए गए सभी शुभ (अच्छे) और अशुभ (बुरे) कर्मों का साक्षात् अहसास (विन्दति / Experience) कराती है।
            यह श्लोक शरीर के विज्ञान (Physiology) को आध्यात्म (Spirituality) के साथ बहुत ही गहराई से जोड़ रहा है।
            पेट की आग (Metabolism) केवल खाना पचाने की मशीन है; वह यह नहीं सोचती कि खाना हलाल है या हराम।
            आँखों की आग (Vision) केवल कैमरा (Camera) है; वह दुनिया के अच्छे-बुरे दृश्य खींचकर दिमाग को भेज देती है।
            परंतु इंसान की असली अदालत (Court) उसके दिमाग में जलने वाली 'ज्ञानाग्नि' (Conscience / विवेक) है।
            यही वह आग है जो इंसान को अंदर से जलाती (Guilt देती) है जब वह कोई पाप (अशुभ) करता है, और यही आग उसे सुकून देती है जब वह कोई पुण्य (शुभ) करता है।
            जानवरों के पास केवल पेट और आँखों की आग होती है; पर इंसान के पास यह 'ज्ञानाग्नि' है जो उसे उसके कर्मों का बोध कराती है।
            यदि इंसान इस ज्ञानाग्नि का सही इस्तेमाल करके अपने सारे पापों को जला दे, तो वह मोक्ष पा सकता है।
        """.trimIndent(),
        english = """
            (The exact functions of those three fires): Among those three, the 'Koshthagni' (the fire of the stomach / Digestive fire) is precisely that which flawlessly and thoroughly digests (Pachatiti) absolutely all types of food that are eaten (Ashita), drunk (Pita), licked (Lidha), and chewed (Khaditam) by us.
            The 'Darshanagni' (the fire of the eyes) is exactly that through which a human being clearly and vividly sees (Pashyati) absolutely all 'Forms' (shapes and colors / Rupam) of this external world.
            And the absolute greatest 'Jnanagni' (the fire of intellect/wisdom) is that exact fire which flawlessly forces the human to directly realize and profoundly experience (Vindati) absolutely all the good (Shubha) and horrific bad (Ashubha) karmas committed by him.
            This magnificent verse exceptionally deeply connects human physical Biology (Physiology) directly with profound Spirituality.
            The stomach's fire (Metabolism) is merely a blind food-digesting machine; it absolutely does not think whether the consumed food is pure or sinful.
            The fire of the eyes (Vision) is merely a neutral physical Camera; it simply captures the world's good and evil scenes and blindly forwards them to the brain.
            But the absolute true, ultimate Court of a human being is strictly the 'Jnanagni' (Conscience / Discrimination) intensely burning right inside his brain.
            This is the exact specific fire that burns a human brutally from the inside (delivering immense Guilt) when he violently commits a sin (Ashubha), and this very same fire grants him profound peace when he performs a merit (Shubha).
            Animals exclusively possess only the fires of the stomach and eyes; but a human being is uniquely gifted with this 'Jnanagni' which grants him absolute awareness of his karmas.
            If a human flawlessly utilizes this Jnanagni properly to completely burn away all his sins, he can effortlessly attain supreme Moksha.
        """.trimIndent()
    ),
    GarbhaShloka(
        id = 25,
        sanskrit = "तत्र त्रीणि स्थानानि भवन्ति । हृदये दक्षिणाग्निः उदरे गार्हपत्यः मुखे आहवनीयः । आत्मा यजमानः... इत्युपनिषत् ॥ २५ ॥",
        hindi = """
            (शरीर एक यज्ञशाला है): इस शरीर रूपी यज्ञशाला में अग्नि के तीन परम पवित्र 'स्थान' (स्थानानि) होते हैं।
            मनुष्य के हृदय (Heart) में 'दक्षिणाग्नि' (यज्ञ की एक पवित्र आग) स्थित है; उसके पेट (उदरे) में 'गार्हपत्य' अग्नि स्थित है; और उसके मुँह (मुखे) में 'आहवनीय' अग्नि जल रही है।
            इस पूरे शारीरिक यज्ञ को करने वाला जो मुख्य 'यजमान' (मालिक / Host) है, वह साक्षात् यह 'आत्मा' ही है।
            इस प्रकार (यह जानते हुए कि शरीर एक पवित्र यज्ञ है) जो अपना जीवन बिताता है, वह मुक्त हो जाता है। यहीं पर 'गर्भ उपनिषद' पूर्ण रूप से संपन्न होता है (इत्युपनिषत्)।
            यह उपनिषद का अंतिम और सबसे मास्टर-स्ट्रोक (Masterstroke) श्लोक है, जो पूरे शरीर को एक 'पवित्र वेदी' (Sacrificial Altar) में बदल देता है।
            प्राचीन काल में ब्राह्मण लोग बाहर लकड़ियां जलाकर तीन तरह की आग (दक्षिणाग्नि, गार्हपत्य, आहवनीय) में आहुति (यज्ञ) देते थे।
            पर उपनिषद कहता है कि असली 'यज्ञ' तो 24 घंटे तुम्हारे अपने शरीर के अंदर ही चल रहा है!
            तुम्हारा पेट 'गार्हपत्य' है (जहाँ भोजन की आहुति डलती है), तुम्हारा मुँह 'आहवनीय' है (जहाँ से मंत्र और सच बोले जाते हैं), और हृदय 'दक्षिणाग्नि' है (जहाँ प्रेम की आग जलती है)।
            और सबसे बड़ी बात—इस पूरे यज्ञ का मालिक (यजमान) तुम्हारा अहंकार नहीं, बल्कि तुम्हारी 'आत्मा' है।
            जब इंसान इस सच्चाई को समझकर अपने हर कर्म (खाने, बोलने, सोचने) को 'भगवान का यज्ञ' मान लेता है, तो यह गंदा (मल-मूत्र का) शरीर भी एक पवित्र मंदिर बन जाता है। यहीं गर्भ उपनिषद का महान ज्ञान पूर्ण होता है।
        """.trimIndent(),
        english = """
            (The human body is exactly a sacrificial altar): Strictly within this bodily sacrificial altar, there are exactly three supremely sacred 'Locations' (Sthanani) for the holy fire.
            In the human's heart (Hridaye) is firmly situated the 'Dakshinagni' (a highly sacred sacrificial fire); in his stomach (Udare) is the 'Garhapatya' fire; and exactly in his mouth (Mukhe) burns the 'Ahavaniya' fire.
            The absolute main 'Yajamana' (Supreme Master / Host) who is actively performing this entire massive bodily sacrifice, is undeniably this pure 'Soul' (Atma) itself.
            Living one's entire life precisely in this manner (knowing flawlessly that the physical body is a supremely sacred Yajna) directly grants ultimate liberation. Right here, the 'Garbha Upanishad' achieves its flawless, absolute completion (Ityupanishat).
            This is the Upanishad's absolute final and ultimate Masterstroke verse, which flawlessly transforms the entire gross physical body directly into a supremely 'Sacred Altar' (Sacrificial Altar).
            In ancient times, Brahmins constantly burnt physical wood outside to violently offer sacrifices (Yajnas) into three specific types of fires (Dakshinagni, Garhapatya, Ahavaniya).
            But the Upanishad fiercely declares that the actual, true 'Yajna' is actively, continuously running 24 hours a day strictly right inside your very own body!
            Your stomach is the 'Garhapatya' (where the exact sacrifice of consumed food is offered), your mouth is the 'Ahavaniya' (from where sacred mantras and truth are spoken), and the heart is 'Dakshinagni' (where the pure fire of love burns).
            And most magnificently—the absolute Master (Yajamana) of this entire colossal Yajna is absolutely not your petty ego, but strictly your immortal 'Soul'.
            When a human profoundly understands this truth and treats absolutely every single action (eating, speaking, thinking) purely as 'God's Yajna', even this filthy (urine-feces) body instantly transforms into an incredibly sacred temple. Here, the magnificent wisdom of the Garbha Upanishad is perfected.
        """.trimIndent()
    )
)