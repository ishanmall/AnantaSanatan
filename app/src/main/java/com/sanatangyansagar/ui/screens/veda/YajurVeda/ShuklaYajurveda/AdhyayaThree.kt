package com.sanatangyansagar.ui.screens.veda.YajurVeda.ShuklaYajurveda

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShuklaYajurvedaAdhyayaThreeScreen() {
    var searchQuery by remember { mutableStateOf("") }

    val filteredVerses = remember(searchQuery) {
        if (searchQuery.isEmpty()) {
            shuklaYajurAdhyayaThreeData
        } else {
            shuklaYajurAdhyayaThreeData.filter {
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
                        Text("तृतीय अध्याय - अग्निहोत्र एवं चातुर्मास्य", fontWeight = FontWeight.ExtraBold)
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color(0xFFFFCC80) // Saffron/Orange tint for Yajurveda
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
                .background(Color(0xFFFFF8E1)),
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

val shuklaYajurAdhyayaThreeData = listOf(
    ShuklaYajurVerse(
        id = 1,
        sanskrit = "समिधाग्निं दुवस्यत घृतैर्बोधयतातिथिम् ।\nआस्मिन् हव्या जुहोतन ॥ १ ॥",
        hindiCommentary = """
            हे ऋत्विजों! समिधाओं (लकड़ियों) के द्वारा इस पवित्र अग्निदेव की भली-भांति परिचर्या (सेवा) करो।
            अपने शुद्ध घृत (घी) की आहुतियों से इस अग्नि रूपी महान अतिथि को जाग्रत और प्रज्वलित करो; और इस प्रज्वलित अग्नि में श्रेष्ठ हविष्य (अन्न) की आहुतियां प्रदान करो।
            यह मंत्र दैनिक अग्निहोत्र का मूल आधार है, जो हमें सिखाता है कि अग्नि केवल एक भौतिक तत्व नहीं, बल्कि हमारे घर का सबसे सम्मानित दिव्य अतिथि है।
            अतिथि देवो भव—भारतीय संस्कृति की यह महान परंपरा इसी वैदिक दर्शन से उत्पन्न हुई है, जहाँ हम देवों को भी अतिथि रूप में पूजते हैं।
            समिधा हमारे कर्म और पुरुषार्थ का प्रतीक है, और घी हमारे शुद्ध भावों और प्रेम का; दोनों के बिना आध्यात्मिक ज्योति कभी जाग्रत नहीं हो सकती।
            इस यज्ञ में अर्पित किया जाने वाला अन्न हमारे उस समर्पण को दर्शाता है जहाँ हम अपनी कमाई का श्रेष्ठ अंश ईश्वर और समाज को लौटाते हैं।
            हे परमात्मा! हमारे हृदय में भी ज्ञान रूपी अग्नि को उसी प्रकार प्रज्वलित करें जैसे वेदी पर यह पवित्र अग्नि प्रज्वलित होती है।
            हम जीवन में जो भी श्रेष्ठ कर्म करें, वह केवल आपके निमित्त हो, जिससे हमारे मन का हर अंधकार और स्वार्थ सदा के लिए भस्म हो जाए।
            जब हम अग्नि रूपी अतिथि का सम्मान करते हैं, तो हमारे घर में कभी भी ऊर्जा, स्वास्थ्य और अन्न की कोई कमी नहीं रहती।
            हमारा यह दैनिक अनुष्ठान हमारे भीतर एक ऐसा अनुशासन लाए जो हमें आलस्य से दूर रखकर हमेशा धर्म के मार्ग पर जाग्रत रखे।
        """.trimIndent(),
        englishCommentary = """
            O priests! Serve and attend to the holy Lord Agni with sacred fuel (Samidha).
            Awaken and kindle this great guest in the form of fire with your offerings of pure Ghee; and offer excellent oblations (food) into this blazing fire.
            This mantra is the foundational basis of the daily Agnihotra, teaching us that Agni is not just a physical element but the most honored divine guest of our home.
            'Atithi Devo Bhava' (The guest is God)—this great tradition of Indian culture originates from this Vedic philosophy where we worship gods as guests.
            The fuel symbolizes our action and effort, and Ghee our pure feelings and love; without both, the spiritual flame can never be awakened.
            The food offered in this sacrifice represents our absolute surrender, where we return the best part of our earnings to God and society.
            O Supreme Lord! Ignite the fire of true knowledge in our hearts exactly as this holy fire is ignited on the sacred altar.
            Whatever noble deeds we perform in life, let them be solely for You, so that all darkness and selfishness of our minds are burnt to ashes forever.
            When we honor the guest in the form of Agni, there is never any shortage of energy, health, and food in our homes.
            May this daily ritual bring such strict discipline within us that it keeps us far from laziness and always awake on the path of Dharma.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 2,
        sanskrit = "सुसमिद्धाय शोचिषे घृतं तीव्रं जुहोतन ।\nअग्नये जातवेदसे ॥ २ ॥",
        hindiCommentary = """
            अत्यंत उत्तम रूप से प्रज्वलित हुई और सर्वत्र प्रकाश फैलाने वाली इस पवित्र ज्वाला (अग्नि) में तीक्ष्ण और शुद्ध घृत (घी) की आहुति डालो।
            यह आहुति उस 'जातवेदा' अग्निदेव के लिए है जो उत्पन्न हुए सभी प्राणियों और पदार्थों को भली-भांति जानने वाले (सर्वज्ञ) हैं।
            'जातवेदा' का अर्थ है वह चेतना जो संसार के कण-कण में रची-बसी है और जिससे हमारा कोई भी कर्म या विचार कभी छिपा नहीं रह सकता।
            जब अग्नि भली-भांति प्रज्वलित हो, तभी आहुति देनी चाहिए; इसका आध्यात्मिक अर्थ है कि ईश्वर को समर्पण तभी फलीभूत होता है जब मन पूर्णतः एकाग्र और जाग्रत हो।
            तीव्र घृत (शुद्ध घी) हमारे उस निस्वार्थ और प्रगाढ़ प्रेम का प्रतीक है जो ईश्वर को अत्यंत प्रिय है और जो तुरंत ज्योति (ज्ञान) में बदल जाता है।
            यज्ञ में आधा-अधूरा जला हुआ अन्न प्रदूषण फैलाता है; वैसे ही बिना पूर्ण श्रद्धा के किया गया कर्म मन में केवल संशय और क्लेश ही उत्पन्न करता है।
            हे प्रभु! हमारी भक्ति भी इसी प्रज्वलित अग्नि के समान प्रखर हो, जिसमें किसी भी प्रकार के सांसारिक मोह या अज्ञान का धुआं न हो।
            आप जातवेदा हैं, आप हमारे मन की हर गहरी भावना को जानते हैं; अतः हम बिना किसी छल-कपट के केवल सत्य को ही आपके चरणों में अर्पित करते हैं।
            हमारा जीवन इस सुसमिद्ध (अच्छी तरह प्रज्वलित) अग्नि की तरह हो, जो स्वयं जलकर भी दूसरों को केवल उष्णता और प्रकाश ही प्रदान करे।
            हम जो भी ज्ञान प्राप्त करें, वह इतना प्रखर हो कि वह समाज के अंधविश्वासों और कुरीतियों को जलाकर एक स्वस्थ और जाग्रत राष्ट्र का निर्माण करे।
        """.trimIndent(),
        englishCommentary = """
            Offer pungent and extremely pure Ghee into this perfectly kindled and universally illuminating sacred flame.
            This oblation is specifically for that 'Jatavedas' Agni who is the omniscient knower of all created beings and all existing entities.
            'Jatavedas' means that consciousness which permeates every particle of the world, from which none of our actions or thoughts can ever remain hidden.
            Oblations should be offered only when the fire is well-kindled; spiritually, surrender to God is fruitful only when the mind is fully concentrated and awake.
            Pungent Ghee (pure clarified butter) symbolizes our selfless and intense love which is extremely dear to God and immediately turns into light.
            Half-burnt food in a sacrifice spreads pollution; similarly, an action done without full faith only creates doubts and afflictions in the mind.
            O Lord! May our devotion also be fierce like this blazing fire, containing absolutely no smoke of worldly attachment or ignorance.
            You are Jatavedas, You know every deep feeling of our minds; hence we offer only absolute truth at Your feet without any deceit or fraud.
            May our lives be like this well-kindled fire, which despite burning itself, provides only warmth, comfort, and radiant light to others.
            Whatever knowledge we acquire, let it be so intense that it burns the superstitions of society and builds a completely healthy and awakened nation.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 3,
        sanskrit = "तं त्वा समिद्भिर्अङ्गिरो घृतेन वर्धयामसि ।\nबृहच्छोचा यविष्ठ्य ॥ ३ ॥",
        hindiCommentary = """
            हे अंगिरा (प्राण रूपी) अग्निदेव! हम तुम्हें पवित्र समिधाओं और शुद्ध घृत की आहुतियों से निरंतर बढ़ाते और पुष्ट करते हैं।
            हे सदा युवा रहने वाले (यविष्ठ्य) देव! तुम अपने महान और विशाल प्रकाश (बृहच्छोचा) के साथ सर्वत्र अत्यंत प्रदीप्त हो उठो।
            अग्नि को 'अंगिरा' (अंगों का रस या प्राण) कहा गया है; यह इस बात का प्रतीक है कि अग्नि हमारे भौतिक शरीर में ऊष्मा और चेतना के रूप में निरंतर विद्यमान है।
            'यविष्ठ्य' का अर्थ है सबसे युवा; सत्य और आध्यात्मिक ऊर्जा कभी बूढ़ी नहीं होती, वह हमेशा नवीन और ऊर्जावान ही रहती है।
            जब हम शरीर रूपी अग्नि को उत्तम और सात्विक भोजन (घृत/समिधा) देते हैं, तभी हमारी प्राणशक्ति बढ़ती है और हम महान कार्य कर पाते हैं।
            बाहरी यज्ञ का विस्तार तभी सार्थक है जब हमारे अंतःकरण का प्रकाश (बृहच्छोचा) भी उतना ही विशाल और निष्कलंक हो जाए।
            हे परमात्मा! हमारे भीतर के उत्साह को कभी कम न होने दें, हम सदैव युवा अग्नि की तरह ऊर्जा से भरे रहें और धर्म के मार्ग पर अडिग चलें।
            जैसे-जैसे घृत पड़ने से अग्नि की लपटें ऊंची उठती हैं, वैसे-वैसे हमारी आत्मा का ज्ञान और विवेक भी निरंतर ऊर्ध्वगामी होता रहे।
            हम अपने श्रेष्ठ कर्मों से केवल अपना नहीं, बल्कि इस संपूर्ण समाज और राष्ट्र की ऊर्जा को बढ़ाएं और हर ओर यश का प्रकाश फैलाएं।
            संसार की कोई भी बाधा हमारे भीतर जल रही इस ईश्वरीय ज्योति को कभी बुझा न सके, यही हमारी आपसे सबसे बड़ी और सच्ची प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Angiras (vital breath) Agni! We continuously increase and nourish you with offerings of sacred fuel and extremely pure Ghee.
            O ever-youthful (Yavishthya) God! Blaze forth everywhere intensely with your great, vast, and magnificent light (Brihacchocha).
            Agni is called 'Angiras' (the essence of limbs or vital breath); this symbolizes that fire continuously exists in our physical body as heat and consciousness.
            'Yavishthya' means the youngest; truth and spiritual energy never grow old; they remain perpetually new, vibrant, and incredibly energetic.
            When we feed the fire of our body with excellent and pure (Sattvic) food, only then does our vitality increase and we achieve great deeds.
            The expansion of an external sacrifice is meaningful only when the light of our inner conscience also becomes equally vast and flawless.
            O Supreme Lord! Never let the enthusiasm within us diminish; may we always remain full of energy like a youthful fire and walk firmly on Dharma.
            Just as flames rise higher with the offering of Ghee, may the knowledge and discernment of our soul also continuously ascend upwards.
            Through our noble deeds, let us increase the energy not just of ourselves but of this entire society, spreading the radiant light of glory everywhere.
            May no worldly obstacle ever be able to extinguish this divine flame burning within us; this is our greatest and truest prayer to You.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 4,
        sanskrit = "उप त्वाग्ने हविष्मतीर्घृताचीर्यन्तु हर्यत ।\nजुषस्व समिधो मम ॥ ४ ॥",
        hindiCommentary = """
            हे सर्वप्रिय (हर्यत) अग्निदेव! हविष्य (अन्न) और प्रचुर घृत (घी) से युक्त हमारी ये पवित्र आहुतियां तुम्हारे समीप आसानी से पहुँचें।
            तुम हमारी इन अत्यंत श्रद्धापूर्वक अर्पित की गई समिधाओं (लकड़ियों) और भावनाओं को अत्यंत प्रसन्नता के साथ स्वीकार करो।
            ईश्वर 'हर्यत' (सबके द्वारा चाहने योग्य) है; क्योंकि दुनिया का हर प्राणी अंजाने में भी शांति, प्रकाश और आनंद (जो ईश्वर के ही रूप हैं) को ही खोजता है।
            आहुति का ईश्वर तक पहुँचना इस बात पर निर्भर करता है कि वह कितनी पवित्रता और निस्वार्थ प्रेम के साथ अर्पित की गई है।
            समिधा हमारे जीवन का वह समय और ऊर्जा है जिसे हम प्रतिदिन ईश्वर के ध्यान और समाज की सेवा में लगाते हैं।
            जब ईश्वर हमारी समिधा को स्वीकार करता है, तो वह हमारे साधारण जीवन को अपनी दिव्य ज्योति से भरकर उसे असाधारण बना देता है।
            हे प्रभु! हमारी यह प्रार्थना है कि हमारे हाथ कभी भी आपको कुछ अर्पित करने से पीछे न हटें; हम जो भी कमाएं, उसमें आपका हिस्सा सबसे पहले हो।
            जैसे अग्नि समिधा को जलाकर उसे अपने ही समान प्रकाशमान बना देती है, वैसे ही आप हमारे अस्तित्व को अपने प्रेम में विलीन कर लें।
            हमारा अहंकार इस वेदी पर पूरी तरह से भस्म हो जाए और हमारे भीतर केवल उस परम सत्ता के प्रति अखंड समर्पण का ही वास हो।
            यज्ञ का यह पावन कर्म हमें स्वार्थ से निकालकर परमार्थ की ओर ले जाए, जहाँ हम संपूर्ण विश्व को एक ही परिवार के रूप में देख सकें।
        """.trimIndent(),
        englishCommentary = """
            O universally beloved (Haryata) Agni! May these holy oblations of ours, rich in sacrificial food and abundant Ghee, reach near you effortlessly.
            Please accept these firewood sticks (Samidhas) and emotions, offered by us with the utmost devotion, with extreme joy and pleasure.
            God is 'Haryata' (desirable by all); because every creature in the world unknowingly seeks only peace, light, and bliss (which are forms of God).
            An oblation reaching God depends entirely on how much purity and selfless pure love it has been offered with.
            Samidha is that time and energy of our lives which we dedicate every single day to the meditation of God and the selfless service of society.
            When God accepts our Samidha, He fills our ordinary existence with His own divine light, making it truly extraordinary and majestic.
            O Lord! It is our prayer that our hands never hesitate to offer You something; whatever we earn, let Your share absolutely be the first in it.
            Just as fire burns the wood and makes it luminous like itself, please merge our entire existence seamlessly into Your divine love.
            May our ego be completely burnt to ashes on this sacred altar, and may only an unbroken surrender to that Supreme Reality reside within us.
            May this holy act of sacrifice pull us out of selfishness and lead us toward universal welfare, where we view the whole world as one single family.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 5,
        sanskrit = "भूर्भुवः स्वः ।\nद्यौरिव भूम्ना पृथिवीव वरिम्णा ।\nतस्यास्ते पृथिवि देवयजनि पृष्ठेऽग्निमन्नादमन्नाद्यायादधे ॥ ५ ॥",
        hindiCommentary = """
            ॐ भूर्भुवः स्वः—ये तीनों लोक (पृथ्वी, अंतरिक्ष, स्वर्ग) उस परमेश्वर के ही साक्षात् रूप हैं।
            आकाश के समान विशालता और पृथ्वी के समान चौड़ाई (विस्तार) से युक्त; हे देवों का यजन करने वाली पावन पृथ्वी! 
            तेरी पीठ पर मैं इस अन्न भक्षण करने वाले (अन्नाद) अग्निदेव को अन्न प्राप्ति और यज्ञ की पूर्ण सिद्धि के लिए स्थापित करता हूँ।
            'भूर्भुवः स्वः' का उच्चारण करते ही साधक अपनी चेतना को सीमित भौतिक शरीर से निकालकर संपूर्ण ब्रह्मांड के साथ जोड़ लेता है।
            आकाश और पृथ्वी की विशालता की प्रार्थना का अर्थ है कि हमारा हृदय और हमारा दृष्टिकोण भी संकीर्ण न रहकर ब्रह्मांड के समान असीम हो जाए।
            अग्नि को 'अन्नाद' कहा गया है क्योंकि वह सब कुछ पचाने की क्षमता रखती है; उसी प्रकार हमें भी जीवन के सुख-दुख को पचाने की मानसिक शक्ति चाहिए।
            पृथ्वी देवयजनी है; इसका प्रत्येक कोना पवित्र है, बशर्ते हमारे कर्म शुद्ध हों और हमारे भीतर ईश्वर के प्रति समर्पण का भाव हो।
            हे परमात्मा! हमें ऐसा सामर्थ्य दें कि हम कभी अन्न के अभाव में न रहें और हमारे द्वार पर आया कोई भी अतिथि कभी भूखा न लौटे।
            यज्ञवेदी पर अग्नि की स्थापना वास्तव में अपने अंतःकरण में उस ईश्वरीय ज्योति की स्थापना है जो अज्ञान को पूरी तरह से जला देती है।
            हम प्रकृति के प्रति सदैव कृतज्ञ रहें, क्योंकि इसी पृथ्वी की चौड़ी पीठ पर हम अपना जीवन जीते हैं और इसी पर अपने मोक्ष का मार्ग भी प्रशस्त करते हैं।
        """.trimIndent(),
        englishCommentary = """
            Om Bhur Bhuvah Svah—these three worlds (Earth, Space, Heaven) are the direct manifestations of the Supreme Lord Himself.
            Endowed with vastness like the sky and immense breadth (expansion) like the earth; O holy Earth where gods are worshipped!
            On your back, I establish this food-consuming (Annada) Agni for the attainment of food and the absolute perfection of this sacrifice.
            By chanting 'Bhur Bhuvah Svah', the seeker pulls his consciousness out of the limited physical body and connects it with the entire universe.
            Praying for the vastness of the sky and earth means our hearts and perspectives should not remain narrow but become boundless like the cosmos.
            Agni is called 'Annada' because it has the capacity to digest everything; similarly, we need the mental strength to digest life's joys and sorrows.
            The earth is Devayajani (fit for sacrifice); every corner is holy, provided our actions are pure and we possess a deep sense of surrender to God.
            O Supreme Lord! Give us the capability so we never face a shortage of food, and no guest who arrives at our door ever returns hungry.
            Establishing fire on the altar is actually establishing that divine light in our inner conscience which completely burns away all ignorance.
            Let us always remain grateful to Nature, because on this wide back of the earth we live our lives and also pave our pathway to ultimate liberation.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 6,
        sanskrit = "आयं गौः पृश्निरक्रमीदसदन्मातरं पुरः ।\nपितरं च प्रयन्त्स्वः ॥ ६ ॥",
        hindiCommentary = """
            यह रंग-बिरंगा (अनेक किरणों वाला) सूर्य रूपी वृषभ (गौ) उदित होकर आकाश में निरंतर आगे बढ़ रहा है।
            यह आगे बढ़कर अपनी माता (पृथ्वी या उषा) के समीप स्थापित हो रहा है, और ऊपर जाकर अपने पिता (आकाश) की ओर गमन कर रहा है।
            वेद में सूर्य को 'गौ' (किरणों वाला) कहा गया है; सूर्य का उदय होना सृष्टि में चेतना, प्रकाश और नवजीवन के संचार का सबसे बड़ा प्रतीक है।
            सूर्य का पृथ्वी (माता) और आकाश (पिता) के बीच विचरण करना प्रकृति के उस असीम संतुलन को दर्शाता है जिस पर पूरा ब्रह्मांड टिका हुआ है।
            यह मंत्र हमें सिखाता है कि जिस प्रकार सूर्य बिना रुके अपने कर्तव्य का पालन करता है, हमें भी अपने जीवन में आलस्य त्याग कर निरंतर आगे बढ़ना चाहिए।
            सूर्य की किरणें अंधकार का नाश करती हैं; उसी प्रकार ईश्वर का ध्यान हमारे मन के समस्त भयों, संशयों और अज्ञान को पल भर में नष्ट कर देता है।
            हे देव! हमारे जीवन में भी ज्ञान का ऐसा ही प्रखर सूर्य उदित हो जो हमारी अकर्मण्यता को समाप्त कर हमें एक महान और सक्रिय जीवन प्रदान करे।
            हम माता-पिता (पृथ्वी और आकाश) के ऋण को पहचानें और अपने आचरण से प्रकृति के इस सुंदर संतुलन को कभी भी बिगड़ने न दें।
            जैसे सूर्य की रोशनी सभी पर समान रूप से पड़ती है, वैसे ही हमारे प्रेम और करुणा के प्रकाश में किसी के भी प्रति कोई भी भेदभाव न हो।
            हमारा पूरा जीवन इस ब्रह्मांडीय यज्ञ का एक हिस्सा बने, जहाँ हम स्वयं को उस परम ज्योति से जोड़कर आत्मिक स्वतंत्रता (स्वः) को प्राप्त कर सकें।
        """.trimIndent(),
        englishCommentary = """
            This multi-colored (many-rayed) bull (Gau) in the form of the Sun has risen and is continuously moving forward in the vast sky.
            Moving ahead, it establishes itself near its mother (Earth or Dawn), and going upwards, it journeys toward its father (the Sky).
            In the Vedas, the Sun is called 'Gau' (one with rays); the rising of the sun is the greatest symbol of consciousness, light, and new life in creation.
            The Sun wandering between the Earth (Mother) and Sky (Father) illustrates that infinite balance of nature upon which the entire universe rests.
            This mantra teaches us that just as the Sun performs its duty without stopping, we too must abandon laziness and continuously move forward in life.
            The sun's rays destroy darkness; similarly, meditation on God destroys all fears, doubts, and ignorance of our minds in a mere moment.
            O God! Let such a fierce sun of knowledge rise in our lives too, ending our inactivity and granting us a highly active and great existence.
            Let us recognize the debt of our parents (Earth and Sky) and through our conduct, never let this beautiful balance of nature be disturbed at all.
            Just as the sun's light falls equally on everyone, similarly, there should be no discrimination against anyone in the light of our love and compassion.
            May our entire life become part of this cosmic sacrifice, where connecting ourselves to that Supreme Light, we attain true spiritual freedom (Svah).
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 7,
        sanskrit = "अन्तश्चरति रोचनास्य प्राणादपानती ।\nव्यख्यन्महिषो दिवम् ॥ ७ ॥",
        hindiCommentary = """
            यह प्रकाशमान (रोचना) सूर्य देव अपने महान तेज के साथ संपूर्ण ब्रह्मांड के भीतर (अन्तर) निरंतर विचरण करते हैं।
            वह अपनी शक्तियों से प्राण (भीतर जाने वाली) और अपान (बाहर आने वाली) वायु का संचार करते हैं, और उस महान (महिष) देव ने द्युलोक को प्रकाशित कर दिया है।
            सूर्य केवल बाहर प्रकाश नहीं देता; वह 'रोचना' बनकर हमारी आत्मा के भीतर भी आत्मप्रकाश और विवेक के रूप में निवास करता है।
            प्राण और अपान का उल्लेख यह स्पष्ट करता है कि सूर्य ही पृथ्वी पर श्वास और जीवन का मुख्य और एकमात्र भौतिक स्रोत है; उसके बिना जीवन असंभव है।
            महिष का अर्थ यहाँ शक्तिशाली और महान है; उस ईश्वरीय सत्ता का तेज इतना विशाल है कि स्वर्गलोक भी उसी के प्रकाश से चमकता है।
            जब साधक प्राणायाम करता है, तो वह वास्तव में अपने भीतर इसी सौर ऊर्जा (प्राणशक्ति) को संतुलित और अत्यंत जाग्रत कर रहा होता है।
            हे प्रभु! जिस प्रकार यह सूर्य बाहरी आकाश को आलोकित करता है, वैसे ही आपके ज्ञान का प्रकाश हमारे अंतःकरण के आकाश को पूरी तरह जगमगा दे।
            हम अपनी सांसों के महत्व को समझें; हमारा हर श्वास (प्राण) केवल ईश्वर के स्मरण में जाए और हर अपान से हमारे भीतर की बुराइयां बाहर निकलें।
            जब व्यक्ति भीतर से प्रकाशित हो जाता है, तो उसके चेहरे पर एक दिव्य तेज आ जाता है जो समाज में अंधकार में भटके लोगों को सही राह दिखाता है।
            हम उस परम महिमामयी ज्योति की शरण में जाएं जो न कभी अस्त होती है और न कभी मलिन, और जो हमें शाश्वत अमरत्व का अनुभव कराती है।
        """.trimIndent(),
        englishCommentary = """
            This luminous (Rochana) Sun God wanders continuously within (Antar) the entire universe with His immensely great and magnificent brilliance.
            Through His powers, He circulates the Prana (inhaling) and Apana (exhaling) breaths, and that Great (Mahisha) Lord has illuminated heaven itself.
            The Sun doesn't just give external light; becoming 'Rochana', it also resides within our soul as self-illumination and pure discernment.
            Mentioning Prana and Apana clarifies that the Sun is the main and sole physical source of breath and life on earth; without it, life is impossible.
            Mahisha here means powerful and great; the brilliance of that divine reality is so vast that even heaven shines solely by His radiant light.
            When a seeker practices Pranayama, they are actually balancing and highly awakening this very solar energy (vital force) within themselves.
            O Lord! Just as this Sun illuminates the external sky, may the light of Your knowledge completely brighten the entire sky of our inner conscience.
            Let us understand the value of our breaths; may every inhale go into remembering God, and with every exhale, may our inner evils be expelled.
            When a person becomes illuminated from within, a divine glow appears on their face that shows the correct path to people lost in darkness.
            Let us take refuge in that supremely glorious Light which never sets nor ever gets polluted, and which makes us experience eternal immortality.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 8,
        sanskrit = "त्रिंशद्धाम वि राजति वाक्पतङ्गाय धीयते ।\nप्रति वस्तोरह द्युभिः ॥ ८ ॥",
        hindiCommentary = """
            यह सूर्य देव दिन और रात के तीस धामों (मुहूर्तों या राशियों) को अपने महान प्रकाश से निरंतर प्रकाशित करते हैं।
            उस पक्षी के समान आकाश में उड़ने वाले (पतंग) सूर्य देव के लिए वेदों की पावन वाणी (स्तुति) अत्यंत आदर के साथ धारण की जाती है।
            वह सूर्यदेव अपनी उज्ज्वल किरणों (द्युभिः) के साथ प्रत्येक दिन (प्रति वस्तोः) संसार के सभी पदार्थों को स्पष्ट रूप से प्रकाशित करते हैं।
            तीस धाम का अर्थ है समय का विभाजन; ईश्वर ही समय (काल) का नियंता है और उसकी व्यवस्था से ही दिन, रात, महीने और ऋतुएं चक्रित होती हैं।
            पतंग का अर्थ है जो गमन करे; सूर्य का निरंतर चलना हमें सिखाता है कि जीवन में कभी रुकना नहीं चाहिए, क्योंकि ठहराव ही मृत्यु का लक्षण है।
            वाक् (वाणी/मंत्र) का सूर्य के लिए प्रयोग यह दर्शाता है कि हमारा शब्द और हमारा ज्ञान भी सूर्य के समान तेजस्वी और दूसरों का कल्याण करने वाला हो।
            हे परमात्मा! हमें समय का सही मूल्य समझने की बुद्धि दें ताकि हम अपने जीवन का एक भी बहुमूल्य क्षण प्रमाद या व्यर्थ के कार्यों में नष्ट न करें।
            जैसे सूर्य की रोशनी में सब कुछ स्पष्ट दिखाई देता है, वैसे ही आपके ज्ञान के प्रकाश में हमें सत्य और असत्य का स्पष्ट भेद हमेशा दिखाई दे।
            हम उस परम ज्योति की स्तुति करें जो हमारे बाहरी नेत्रों को ही नहीं, बल्कि हमारी आत्मा के चक्षुओं को भी पूरी तरह से खोल देती है।
            हमारा हर दिन एक नई आध्यात्मिक शुरुआत हो, और हम हर सुबह एक नई ऊर्जा के साथ सत्य के मार्ग पर चलने का दृढ़ संकल्प धारण करें।
        """.trimIndent(),
        englishCommentary = """
            This Sun God continuously illuminates the thirty realms (Muhurtas of day and night or zodiac signs) with His magnificently great light.
            For that Sun God who flies in the sky like a bird (Patanga), the holy words (praises) of the Vedas are offered and held with utmost respect.
            That Sun God clearly illuminates all the objects of the world every single day (Prati Vastoh) with His extremely bright and radiant rays.
            The thirty realms mean the division of time; God is the controller of time (Kala) and by His order alone do days, nights, and seasons revolve.
            Patanga means that which moves; the sun's continuous motion teaches us that we should never stop in life, because stagnation is a sign of death.
            Using 'Vak' (speech/mantras) for the Sun shows that our words and knowledge should also be brilliant like the Sun and highly beneficial to others.
            O Supreme Lord! Grant us the wisdom to understand the true value of time so we don't waste even a single precious moment in lethargy or vain tasks.
            Just as everything is clearly visible in sunlight, may the clear distinction between truth and untruth always be visible to us in Your light of knowledge.
            Let us praise that Supreme Light which opens not only our physical eyes but also completely opens the eyes of our innermost soul.
            May our every day be a new spiritual beginning, and every morning may we hold a firm resolve to walk the path of Truth with fresh energy.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 9,
        sanskrit = "अग्निर्ज्योतिर्ज्योतिरग्निः स्वाहा सूर्यो ज्योतिर्ज्योतिः सूर्यः स्वाहा ।\nअग्निर्वर्चो ज्योतिर्वर्चः स्वाहा सूर्यो वर्चो ज्योतिर्वर्चः स्वाहा ।\nज्योतिः सूर्यः सूर्यो ज्योतिः स्वाहा ॥ ९ ॥",
        hindiCommentary = """
            अग्नि ही ज्योति है और ज्योति ही साक्षात् अग्नि है; इसके लिए यह पावन आहुति (स्वाहा) समर्पित है। सूर्य ही ज्योति है और ज्योति ही सूर्य है, इसके लिए स्वाहा।
            अग्नि ही वर्चस्व (तेज) है और ज्योति ही तेज है, स्वाहा; सूर्य ही वर्चस्व है और ज्योति ही तेज है, इसके लिए स्वाहा। ज्योति ही सूर्य है और सूर्य ही ज्योति है, स्वाहा।
            अग्निहोत्र का यह सबसे प्रसिद्ध मंत्र है; इसमें अग्नि (पृथ्वी का प्रकाश) और सूर्य (आकाश का प्रकाश) को एक ही परम ज्योति का रूप माना गया है।
            यहाँ 'स्वाहा' का अर्थ केवल आहुति देना नहीं, बल्कि अपने भीतर के 'स्व' (अहंकार) को उस परम ज्योति में पूरी तरह से विलीन कर देना है।
            बार-बार 'ज्योति' शब्द का प्रयोग इस बात पर बल देता है कि साधक को अंधकार (अज्ञान) से निकलकर पूरी तरह प्रकाश (ज्ञान) की ओर जाना है।
            तेज (वर्चस्व) भौतिक शक्ति नहीं, बल्कि वह आध्यात्मिक आभा है जो सत्य के मार्ग पर चलने वाले व्यक्ति के चेहरे और चरित्र से स्वतः झलकती है।
            हे प्रभु! जिस प्रकार पृथ्वी की अग्नि और आकाश का सूर्य एक ही तत्व हैं, वैसे ही मेरी आत्मा और आपका स्वरूप भी एक ही है, मुझे इस अद्वैत का अनुभव कराएं।
            हम जो भी कर्म करें, वह सत्य की अग्नि में तपकर कुंदन बन जाए और हमारे जीवन में किसी भी प्रकार के संशय का अंधकार कभी शेष न रहे।
            यज्ञ की यह आहुति हमारे मन के समस्त भयों को समाप्त कर हमें उस परम शाश्वत प्रकाश में मिला दे जहाँ जन्म और मृत्यु का चक्र पूरी तरह टूट जाता है।
            हम प्रार्थना करते हैं कि हमारा अंतःकरण इतना पवित्र हो जाए कि ईश्वर की यह विराट ज्योति हमारे ही हृदय में हमेशा के लिए प्रज्वलित हो उठे।
        """.trimIndent(),
        englishCommentary = """
            Agni is light and light is directly Agni; to this, the holy oblation (Svaha) is dedicated. The Sun is light and light is the Sun, to this Svaha.
            Agni is brilliance (Varchas) and light is brilliance, Svaha; The Sun is brilliance and light is brilliance, Svaha. Light is the Sun and the Sun is light, Svaha.
            This is the most famous mantra of Agnihotra; here, Agni (light of earth) and the Sun (light of sky) are considered forms of the same Supreme Light.
            Here, 'Svaha' does not just mean offering an oblation, but completely merging one's inner 'Sva' (ego) entirely into that Supreme Divine Light.
            The repeated use of the word 'Light' emphasizes that the seeker must step out of darkness (ignorance) and move completely towards light (wisdom).
            Brilliance (Varchas) is not physical power, but that spiritual aura which automatically reflects from the face and character of one walking on Truth.
            O Lord! Just as earth's fire and the sky's sun are one element, my soul and Your form are also one; make me experience this profound non-duality.
            Whatever deed we perform, let it become pure gold by refining in the fire of truth, and let no darkness of doubt ever remain in our lives.
            May this sacrificial oblation end all our mental fears and merge us into that supreme eternal light where the cycle of birth and death completely breaks.
            We pray that our conscience becomes so incredibly pure that this vast, magnificent light of God is permanently ignited within our very own hearts.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 10,
        sanskrit = "सजूर्देवेन सवित्रा सजू रात्र्येन्द्रवत्या ।\nजुषाणो अग्निर्वेतु स्वाहा ॥ १० ॥",
        hindiCommentary = """
            सविता (सृष्टिकर्ता और प्रकाश के देव) के साथ मिलकर, और ऐश्वर्यशाली इंद्र (शक्ति) से युक्त रात्रि देवियों के साथ भली-भांति मिलकर...
            यह पवित्र अग्निदेव अत्यंत प्रसन्न (जुषाणः) होकर हमारी इस हवि को स्वीकार करें और इसे देवों तक पहुँचाएं, इसके लिए यह आहुति (स्वाहा) समर्पित है।
            इस सायं कालीन अग्निहोत्र मंत्र में दिन (सविता) और रात्रि दोनों की शक्तियों का एक साथ आह्वान किया गया है, जो काल (समय) की पूर्णता का प्रतीक है।
            सविता प्रेरणा देते हैं और रात्रि विश्राम देती है; दोनों ही ईश्वर की व्यवस्था हैं और दोनों का ही हमारे जीवन में समान रूप से आदर होना चाहिए।
            'इन्द्रवत्या रात्रि' का अर्थ है वह रात्रि जो अंधकारमयी न होकर तारों और चंद्रमा के प्रकाश (ऐश्वर्य) से युक्त और अत्यंत शांतिदायिनी हो।
            ईश्वर हमारी आहुति तभी स्वीकारता है जब वह 'जुषाणः' (प्रसन्न) हो; और ईश्वर तभी प्रसन्न होता है जब आहुति निस्वार्थ प्रेम और पवित्रता से दी गई हो।
            हे परमात्मा! हमारे दिन कर्मठता से भरे हों और हमारी रातें ईश्वरीय ध्यान और परम शांति से युक्त हों, यही हमारे जीवन का वास्तविक संतुलन है।
            हम दिन के प्रकाश में जो भी शुभ कर्म करें, रात्रि की शांति में उस कर्म का आत्मनिरीक्षण करें ताकि हमारा आध्यात्मिक विकास कभी रुके नहीं।
            जिस प्रकार अग्नि दिन और रात दोनों समय प्रज्वलित रहती है, वैसे ही हमारे हृदय में सत्य और धर्म की ज्योति कभी भी बुझनी नहीं चाहिए।
            हमारा पूरा जीवन आपके चरणों में एक अखंड 'स्वाहा' (समर्पण) बन जाए, जहाँ हमारा अपना कोई भी व्यक्तिगत स्वार्थ या इच्छा शेष न रहे।
        """.trimIndent(),
        englishCommentary = """
            United with the Creator God Savitar (Lord of light), and thoroughly united with the Goddesses of Night endowed with the prosperous Indra (power)...
            May this holy Agni, becoming highly pleased (Jushanah), accept our oblation and carry it to the gods; for this, the oblation (Svaha) is dedicated.
            In this evening Agnihotra mantra, the powers of both day (Savitar) and night are invoked together, which is the ultimate symbol of the completeness of time.
            Savitar provides inspiration and the night provides rest; both are God's profound arrangements and both must be equally respected in our lives.
            'Indravatya Ratri' means that night which is not darkly terrifying but endowed with the light (wealth) of stars and the moon, and is extremely peaceful.
            God accepts our oblation only when He is 'Jushanah' (pleased); and God is pleased only when the oblation is given with selfless love and absolute purity.
            O Supreme Lord! May our days be filled with diligent action and our nights with divine meditation and supreme peace; this is true life balance.
            Whatever auspicious deeds we do in the daylight, let us introspect on them in the peace of the night so our spiritual growth never stops.
            Just as the fire remains kindled during both day and night, similarly, the light of truth and Dharma in our hearts must absolutely never be extinguished.
            May our entire life become an unbroken 'Svaha' (surrender) at Your holy feet, where absolutely none of our personal selfishness or desires remain.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 11,
        sanskrit = "उपप्रयन्तो अध्वरं मन्त्रं वोचेमाग्नये ।\nआरे अस्मे च शृण्वते ॥ ११ ॥",
        hindiCommentary = """
            हम इस हिंसारहित (अध्वर) यज्ञ की ओर निरंतर आगे बढ़ते हुए अग्निदेव के लिए अत्यंत पवित्र मंत्रों का उच्चारण करें।
            वे अग्निदेव जो दूर (आरे) और समीप (अस्मे) सर्वत्र स्थित होकर हमारी प्रार्थनाओं को स्पष्ट और ध्यानपूर्वक सुनते हैं।
            यज्ञ को 'अध्वर' कहा गया है, जिसका अर्थ है जहाँ कोई हिंसा न हो; सच्चा यज्ञ वही है जो पूर्णतः प्रेम और अहिंसा पर आधारित हो।
            ईश्वर सर्वव्यापी है; हम चाहे कितनी भी दूर हों या पास, हमारी हर सच्ची पुकार उस परम सत्ता तक तुरंत पहुँच जाती है।
            मंत्रोच्चारण केवल शब्दों का खेल नहीं है, बल्कि यह हमारी आत्मा की उस अनंत परमात्मा के साथ एक सीधी और गहरी बातचीत है।
            हे प्रभु! हमारी वाणी में इतनी पवित्रता और सत्यता हो कि हमारे द्वारा बोला गया हर शब्द सीधे आपके श्रीचरणों में स्वीकार हो जाए।
            जब हम यज्ञ की ओर बढ़ते हैं, तो वास्तव में हम अपने अहंकार को पीछे छोड़कर अपनी आत्मा की परम शुद्धि की ओर कदम बढ़ाते हैं।
            हमारी प्रार्थना केवल हमारे लिए न हो, बल्कि इस पूरे ब्रह्मांड के सभी जीवों की शांति और मंगल कामना के लिए अत्यंत व्यापक हो।
            हम इस अग्निहोत्र के माध्यम से उस श्रवणशील (सुनने वाले) ईश्वर से जुड़ें जो हमारे बिना कहे भी हमारे हृदयों की हर व्यथा को जानता है।
            यह मंत्र हमें सिखाता है कि ईश्वर के दरबार में दूरी का कोई अर्थ नहीं है, केवल भक्त की सच्ची श्रद्धा और अखंड समर्पण ही मायने रखता है।
        """.trimIndent(),
        englishCommentary = """
            Continuously advancing toward this non-violent (Adhvara) sacrifice, let us chant extremely holy mantras for Lord Agni.
            That Agni who, being situated everywhere both far (Aare) and near (Asme), clearly and attentively hears all our prayers.
            The sacrifice is called 'Adhvara', which means where there is no violence; a true sacrifice is based entirely on pure love and non-violence.
            God is omnipresent; no matter how far or near we are, every true call of ours reaches that Supreme Reality instantly.
            Chanting mantras is not just a play of words, but it is a direct and deep conversation of our soul with the infinite Supreme Soul.
            O Lord! Let there be such purity and truth in our speech that every word spoken by us is directly accepted at Your holy feet.
            When we step towards the sacrifice, we actually leave our ego behind and step towards the ultimate purification of our own soul.
            Let our prayers not be just for us, but extremely vast for the peace and absolute welfare of all living beings in this entire universe.
            Through this Agnihotra, let us connect with that listening God who knows every pain of our hearts even without us saying it.
            This mantra teaches us that distance has no meaning in God's court; only the true faith and unbroken surrender of the devotee truly matter.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 12,
        sanskrit = "अस्य प्रत्नामनु द्युतं शुक्रं दुदुह्रे अह्रयः ।\nपयः सहस्रसामृषिम् ॥ १२ ॥",
        hindiCommentary = """
            इस अग्नि की उस सनातन (प्रत्न) और अत्यंत प्रकाशमयी दीप्ति (द्युत) का अनुसरण करते हुए, लज्जारहित (निर्भीक) साधकों ने...
            हजारों प्रकार के ऐश्वर्यों को देने वाले (सहस्रसाम्) और सर्वद्रष्टा (ऋषिम्) अग्निदेव से अत्यंत शुद्ध (शुक्र) रस (पयः) का दोहन किया है।
            सनातन दीप्ति का अर्थ है वह ईश्वरीय ज्ञान जो युगों-युगों से चला आ रहा है और जो कभी पुराना या मलिन नहीं होता।
            'लज्जारहित' (अह्रयः) का अर्थ यहाँ सांसारिक संकोच और भय से मुक्त होना है; सत्य के मार्ग पर चलने वाला साधक पूरी तरह निर्भीक होता है।
            ईश्वर से 'शुद्ध रस' का दोहन करने का अर्थ है अपनी भक्ति और यज्ञ के माध्यम से ईश्वर की कृपा और अनंत ज्ञान को प्राप्त करना।
            अग्निदेव साक्षात् 'ऋषि' (मंत्रद्रष्टा) हैं, वे हमारे जीवन के हर कर्म को देखते हैं और हमें सही मार्ग का निरंतर दर्शन कराते हैं।
            हे परमात्मा! हमें ऐसा निर्भीक साधक बनाएं कि संसार का कोई भी प्रलोभन या भय हमें आपके इस सनातन सत्य के मार्ग से कभी डिगा न सके।
            हम अपनी साधना से केवल भौतिक ऐश्वर्य नहीं, बल्कि वह पारलौकिक ज्ञान प्राप्त करें जो हमारी आत्मा को अमरत्व के आनंद से भर दे।
            यज्ञ का यह पवित्र कार्य मनुष्य को ईश्वर के निकट ले जाकर उसे ब्रह्मांड के अनंत खजाने (सहस्र ऐश्वर्य) का वास्तविक अधिकारी बना देता है।
            हमारा जीवन भी इस प्रज्वलित अग्नि की तरह तेजस्वी बने, जो समाज को ज्ञान का शुद्ध रस प्रदान कर उसकी सभी प्यास को शांत कर दे।
        """.trimIndent(),
        englishCommentary = """
            Following the eternal (Pratna) and extremely luminous brilliance (Dyut) of this Agni, the shameless (fearless) seekers have...
            Milked the extremely pure (Shukra) essence (Payah) from Agni, who grants thousands of bounties (Sahasrasam) and is the all-seeing seer (Rishim).
            Eternal brilliance means that divine knowledge which has been flowing for ages and which never becomes old or polluted.
            'Shameless' (Ahrayah) here means being free from worldly hesitation and fear; a seeker walking the path of truth is completely fearless.
            Milking the 'pure essence' from God means attaining God's grace and infinite knowledge through one's devotion and sacrifice.
            Lord Agni is a direct 'Rishi' (seer of mantras); He observes every action of our lives and continuously shows us the correct path.
            O Supreme Lord! Make us such fearless seekers that no worldly temptation or fear can ever sway us from this path of Your eternal truth.
            Through our spiritual practice, may we attain not just material wealth, but that transcendental knowledge which fills our soul with the bliss of immortality.
            This holy act of sacrifice takes a human close to God, making them the true inheritor of the universe's infinite treasure (thousand bounties).
            May our lives also become brilliant like this blazing fire, providing the pure essence of knowledge to society and quenching all its thirst.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 13,
        sanskrit = "अग्निर्मूर्धा दिवः ककुत्पतिः पृथिव्या अयम् ।\nअपाँ रेताँसि जिन्वति ॥ १३ ॥",
        hindiCommentary = """
            यह अग्निदेव स्वर्गलोक (द्युलोक) के मस्तक (मूर्धा) हैं और इस संपूर्ण पृथ्वीलोक के सर्वोच्च अधिपति (पति) तथा रक्षक हैं।
            यही अग्निदेव जलों (अंतरिक्ष के बादलों) के वीर्य (जल-कणों) को अत्यंत वेग से पुष्ट और तृप्त करते हैं, जिससे पृथ्वी पर जीवन संभव होता है।
            यह मंत्र अग्नि की उस ब्रह्मांडीय व्यापकता को दर्शाता है जो स्वर्ग, पृथ्वी और अंतरिक्ष (जल) तीनों लोकों में समान रूप से व्याप्त है।
            द्युलोक का मस्तक होने का अर्थ है कि अग्निदेव देवताओं में सर्वोच्च प्रकाश स्वरूप हैं और परम सत्य के साक्षात् प्रतिनिधि हैं।
            पृथ्वी का पति होने का अर्थ है कि पृथ्वी का सारा जीवन, हरियाली और ऊर्जा इसी अग्नि (सूर्य/उष्मा) की महान कृपा पर ही निर्भर है।
            अग्नि से ही बादल बनते हैं और बादलों से वर्षा होती है; यह अग्नि ही है जो जल को जीवनदायिनी शक्ति प्रदान कर पूरी सृष्टि को सींचती है।
            हे प्रभु! आप हमारे जीवन के भी अधिपति बनें; हमारे विचारों (स्वर्ग) और हमारे कर्मों (पृथ्वी) दोनों पर आपका ही सर्वोच्च नियंत्रण हो।
            जिस प्रकार अग्नि जल को पुष्ट कर संसार का कल्याण करती है, वैसे ही आपका ज्ञान हमारी भावनाओं को पुष्ट कर हमें परोपकारी बनाए।
            हम अपने अहंकार को त्याग कर यह स्वीकार करें कि हमारे शरीर और इस ब्रह्मांड का संचालन केवल और केवल इसी ईश्वरीय ऊर्जा से हो रहा है।
            हमारा जीवन अग्नि की तरह ऊर्ध्वगामी हो, जो हमेशा स्वर्ग की ओर (ईश्वर की ओर) उठता है और नीचे की ओर कभी भी पतन नहीं करता।
        """.trimIndent(),
        englishCommentary = """
            This Lord Agni is the head (Murdha) of the heavenly realm (Dyuloka) and the supreme master (Pati) and protector of this entire earth.
            It is this Agni who intensely nourishes and satisfies the seeds (water drops) of the waters (clouds in space), making life possible on earth.
            This mantra illustrates the cosmic omnipresence of Agni, which pervades equally across all three realms: Heaven, Earth, and Space (waters).
            Being the head of the heavenly realm means Agni is the highest form of light among gods and the direct representative of the Ultimate Truth.
            Being the master of the earth means all life, greenery, and energy on earth depend solely on the great grace of this fire (sun/heat).
            Clouds are formed from fire, and rain comes from clouds; it is Agni that provides life-giving power to water, irrigating the entire creation.
            O Lord! Become the master of our lives too; may You have supreme control over both our thoughts (heaven) and our actions (earth).
            Just as Agni nourishes water to benefit the world, may Your knowledge nourish our emotions and make us highly benevolent and kind.
            Let us abandon our ego and accept that our bodies and this universe are operated solely and exclusively by this divine energy.
            May our life be upward-moving like fire, which always rises towards heaven (towards God) and never ever falls downward into degradation.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 14,
        sanskrit = "भुवो यज्ञस्य रजसश्च नेता यत्रा नियुद्भिः सचसे शिवाभिः ।\nदिवि मूर्धानं दधिषे स्वर्षां जिह्वामग्ने चकृषे हव्यवाहम् ॥ १४ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप इस महान यज्ञ के और संपूर्ण लोकों (रजस) के प्रमुख मार्गदर्शक (नेता) हैं; जहाँ आप अपनी कल्याणकारी (शिवा) शक्तियों के साथ निवास करते हैं।
            आपने द्युलोक (स्वर्ग) में अपना अत्यंत प्रकाशमान मस्तक (सूर्य रूप में) धारण किया है, जो सब कुछ आलोकित करता है।
            और आपने स्वर्ग को प्राप्त कराने वाली अपनी पवित्र जिह्वा (ज्वाला) को देवों तक हवि पहुँचाने (हव्यवाह) का महान साधन बनाया है।
            यज्ञ का नेता होने का अर्थ है कि अग्निदेव ही हमारे सभी आध्यात्मिक कर्मों को सही दिशा देते हैं और उन्हें पूर्णता तक पहुँचाते हैं।
            ईश्वर की शक्तियां हमेशा 'शिवा' (कल्याणकारी) होती हैं; जब हम ईश्वर के मार्ग पर चलते हैं, तो हमारा कोई भी कर्म कभी भी अमंगलकारी नहीं हो सकता।
            सूर्य अग्नि का ही स्वर्गीय रूप है, जो ब्रह्मांड का मस्तक बनकर हमें यह सिखाता है कि सत्य का प्रकाश हमेशा सर्वोच्च स्थान पर ही रहता है।
            अग्नि की लपटें उसकी जिह्वा हैं, जो हमारे द्वारा दिए गए अन्न को भौतिक से आध्यात्मिक रूप में परिवर्तित कर स्वर्ग (देवों) तक ले जाती हैं।
            हे परमात्मा! हमारे जीवन का नेतृत्व भी आप स्वयं करें, ताकि हम अज्ञान के अंधकार (रजस) से निकलकर आपके दिव्य प्रकाश की ओर बढ़ सकें।
            हमारी जिह्वा (वाणी) भी अग्नि के समान पवित्र और कल्याणकारी हो, जो दूसरों तक सत्य और प्रेम का संदेश অত্যন্ত सफलतापूर्वक पहुँचाए।
            हम जो भी कर्म रूपी हवि दें, वह आपके श्रीचरणों में स्वीकार हो और हमें परम शांति तथा स्वर्गिक आनंद का सीधा अनुभव कराए।
        """.trimIndent(),
        englishCommentary = """
            O Agni! You are the supreme guide (Neta) of this great sacrifice and of all the worlds (Rajas); where You reside with Your benevolent (Shiva) powers.
            You have established Your highly radiant head in the heavenly realm (as the Sun), which brilliantly illuminates absolutely everything.
            And You have made Your holy tongue (flame), which bestows heaven, the great medium to carry oblations to the gods (Havyavaham).
            Being the leader of the sacrifice means Agni alone gives the correct direction to all our spiritual actions and brings them to perfection.
            God's powers are always 'Shiva' (benevolent); when we walk on God's path, none of our actions can ever be inauspicious or harmful.
            The Sun is the heavenly form of Agni, becoming the head of the universe to teach us that the light of truth always remains at the highest place.
            The flames of fire are its tongues, which transform the food we offer from a physical to a spiritual form, taking it to heaven (the gods).
            O Supreme Lord! Please lead our lives Yourself, so we can step out of the darkness of ignorance (Rajas) and move towards Your divine light.
            May our tongue (speech) also be pure and benevolent like fire, successfully delivering the message of truth and love to others.
            Whatever oblation of action we offer, may it be accepted at Your holy feet and make us directly experience supreme peace and heavenly bliss.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 15,
        sanskrit = "स बोधि सूरिर्मघवा वसुपते वसुदावन् ।\nयुयोध्यस्मद् द्वेषाँसि ॥ १५ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप अत्यंत ज्ञानी (सूरि), ऐश्वर्यवान (मघवा) और समस्त संपत्तियों के अधिपति (वसुपते) हैं; आप हमारे हृदयों में पूर्णतः जाग्रत (बोधि) हों।
            हे वसुदावन् (धन और ज्ञान देने वाले देव)! आप हमारे जीवन से सभी प्रकार के द्वेष (शत्रुता और दुर्भावनाओं) को अत्यंत दूर कर दें।
            यह मंत्र ईश्वर से भौतिक और आध्यात्मिक दोनों प्रकार की समृद्धियों की याचना करता है, क्योंकि ईश्वर ही 'वसुपति' (संपत्ति का स्वामी) है।
            मनुष्य का सबसे बड़ा धन उसका ज्ञान (सूरि होना) है; अज्ञान में पड़ा व्यक्ति चाहे कितना भी अमीर हो, वह भीतर से अत्यंत दरिद्र ही होता है।
            ईश्वर से 'जाग्रत' होने की प्रार्थना का अर्थ है कि हमारी आत्मा में जो सुप्त चेतना है, वह ईश्वरीय प्रकाश के स्पर्श से पूरी तरह जाग जाए।
            ईश्वर धन तो देता है, परंतु यदि मन में द्वेष (नफरत) हो, तो वह धन विनाश का कारण बन जाता है; इसलिए द्वेष को दूर करने की प्रार्थना सर्वोपरि है।
            हे प्रभु! हमारे हृदय से ईर्ष्या, क्रोध और स्वार्थ को इस प्रकार निकाल दें कि हम हर प्राणी में आपके ही पवित्र स्वरूप का साक्षात् दर्शन कर सकें।
            सच्चा मघवा (ऐश्वर्यवान) वह है जो अपने धन और ज्ञान का उपयोग दूसरों की भलाई और समाज के उत्थान के लिए निस्वार्थ भाव से करता है।
            जब मन से द्वेष मिट जाता है, तो सारा संसार मित्र बन जाता है और जीवन में किसी भी प्रकार का भय या असुरक्षा कभी शेष नहीं रहती।
            हमारा अंतःकरण ऐसा पावन बने कि आप स्वयं हमारे भीतर बैठकर हमारे सभी कर्मों का मार्गदर्शन करें और हमें मोक्ष के मार्ग पर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Agni! You are extremely wise (Suri), prosperous (Maghava), and the Lord of all wealth (Vasupate); fully awaken (Bodhi) within our hearts.
            O Vasudavan (Giver of wealth and knowledge)! Please completely remove all forms of malice (enmity and ill-will) from our lives.
            This mantra begs for both material and spiritual prosperity from God, because God alone is 'Vasupati' (the master of all wealth).
            A human's greatest wealth is their knowledge (being Suri); a person trapped in ignorance, no matter how rich, is extremely poor from within.
            Praying for God to 'awaken' means that the dormant consciousness in our soul should fully wake up by the touch of divine light.
            God grants wealth, but if there is malice (hatred) in the mind, that wealth becomes a cause of destruction; hence praying to remove malice is paramount.
            O Lord! Remove jealousy, anger, and selfishness from our hearts in such a way that we can directly see Your holy form in every living being.
            A true Maghava (prosperous one) is one who uses their wealth and knowledge selflessly for the betterment of others and the upliftment of society.
            When malice is erased from the mind, the whole world becomes a friend, and no fear or insecurity of any kind ever remains in life.
            May our conscience become so pure that You Yourself sit within us, guide all our actions, and lead us steadfastly on the path of liberation.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 16,
        sanskrit = "सजिगोर्तिं सजिगोर्तिं सुमत्यै ।\nअग्ने पत्नीवासाह्या देव देवान् ॥ १६ ॥",
        hindiCommentary = """
            (विशिष्ट यज्ञाहुति मंत्र) हे अग्निदेव! आप सदैव विजयी (सजिगोर्तिं) हैं; हम आपकी उत्तम बुद्धि (सुमति) और कृपा प्राप्त करने के लिए आपका आह्वान करते हैं।
            हे देव! आप अपनी अर्धांगिनी (पत्नी/स्वाहा) के साथ पधारें और अन्य सभी देवताओं को भी इस पावन यज्ञ में हमारे लिए आमंत्रित कर ले आएं।
            'सजिगोर्ति' का अर्थ है जो हमेशा बुराइयों और अज्ञान पर विजय प्राप्त करता है; ईश्वर की शक्ति अजेय है और उसके सान्निध्य में साधक भी विजयी होता है।
            यज्ञ में 'पत्नी' (स्वाहा/स्वाधा) का उल्लेख उस ब्रह्मांडीय संतुलन का प्रतीक है जहाँ पुरुष (शिव/चेतना) और प्रकृति (शक्ति/ऊर्जा) दोनों का एक साथ पूजन होता है।
            सुमति (उत्तम बुद्धि) की याचना सबसे बड़ी याचना है; क्योंकि यदि बुद्धि भ्रष्ट हो जाए, तो बड़े से बड़ा ऐश्वर्य भी पल भर में राख हो जाता है।
            ईश्वर स्वयं आकर अन्य देवों को लाते हैं, इसका अर्थ है कि जहाँ मुख्य ईश्वरीय सत्ता (परमात्मा) का वास होता है, वहाँ सभी शुभ शक्तियां स्वतः आ जाती हैं।
            हे परमात्मा! हमारे घर और अंतःकरण में हमेशा निवास करें, ताकि हमारा परिवार सदैव सुखी, सुरक्षित और धार्मिक विचारों से परिपूर्ण रहे।
            हम जो भी कर्म करें, वह सुमति से प्रेरित हो; हमारे निर्णय कभी भी क्रोध या लोभ के वशीभूत होकर न लिए जाएं।
            देवताओं के आने का अर्थ है हमारे जीवन में शांति, स्वास्थ्य, समृद्धि और ज्ञान रूपी ईश्वरीय सद्गुणों का स्थायी रूप से स्थापित हो जाना।
            हमारा यह यज्ञ केवल एक कर्मकांड न रहे, बल्कि हमारी आत्मा का परमात्मा के साथ पूर्ण और शाश्वत मिलन बन जाए, यही हमारी परम प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            (Special sacrificial oblation mantra) O Agni! You are always victorious (Sajigortim); we invoke You to attain Your excellent wisdom (Sumati) and grace.
            O God! Please arrive with Your consort (Patni/Svaha) and also invite and bring all the other gods to this holy sacrifice for us.
            'Sajigorti' means one who always conquers evils and ignorance; God's power is invincible, and in His proximity, the seeker also becomes victorious.
            Mentioning 'Patni' (Svaha/Svadha) in the sacrifice symbolizes the cosmic balance where both Purusha (Shiva/Consciousness) and Prakriti (Power/Energy) are worshipped together.
            Praying for Sumati (excellent wisdom) is the greatest prayer; because if the intellect is corrupted, even the greatest wealth turns to ashes in a moment.
            God coming Himself and bringing other gods means that where the main divine reality (Supreme Lord) resides, all auspicious forces arrive automatically.
            O Supreme Lord! Always reside in our homes and conscience, so that our family remains eternally happy, safe, and filled with righteous thoughts.
            Whatever action we do, let it be inspired by Sumati; let our decisions never be taken under the influence of intense anger or blinding greed.
            The arrival of the gods means the permanent establishment of divine virtues like peace, health, prosperity, and knowledge in our lives.
            May this sacrifice of ours not remain just a ritual, but become a complete and eternal union of our soul with the Supreme Soul; this is our ultimate prayer.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 17,
        sanskrit = "ये देवासो दिव्येकादश स्थ पृथिव्यामध्येकादश स्थ ।\nअप्सुक्षितो महिनैकादश स्थ ते देवासो यज्ञमिमं जुषध्वम् ॥ १७ ॥",
        hindiCommentary = """
            हे देवगण! जो ग्यारह देवता द्युलोक (स्वर्ग) में स्थित हैं, जो ग्यारह देवता इस पृथ्वीलोक पर विराजमान हैं...
            और जो ग्यारह देवता अपनी महिमा के साथ जलों (अंतरिक्ष) में निवास करते हैं; वे सभी तैंतीस (33) देवता हमारे इस पवित्र यज्ञ को सहर्ष स्वीकार करें।
            यह वेद का एक अत्यंत प्रसिद्ध मंत्र है जो 33 कोटि (प्रकार) के देवताओं का स्पष्ट और सुंदर वर्गीकरण प्रस्तुत करता है।
            कोटि का अर्थ यहाँ 'करोड़' नहीं, बल्कि 'श्रेणी' या 'प्रकार' है; ये 33 प्रकार की प्राकृतिक और ब्रह्मांडीय शक्तियां ही संपूर्ण सृष्टि का संचालन करती हैं।
            (ये 33 देव हैं: 8 वसु, 11 रुद्र, 12 आदित्य, 1 इंद्र और 1 प्रजापति)। इन सभी का तीनों लोकों में संतुलित होना ही ब्रह्मांड की स्थिरता का रहस्य है।
            जब हम सभी देवों का एक साथ आह्वान करते हैं, तो हम वास्तव में प्रकृति की संपूर्णता और उसके असीम संतुलन के प्रति अपना सम्मान व्यक्त करते हैं।
            हे परमेश्वर! ये सभी दिव्य शक्तियां हमारे जीवन में अनुकूल रहें; जल, पृथ्वी और आकाश की कोई भी शक्ति हमारे लिए कभी भी विनाशकारी न बने।
            हमारा कर्म इतना श्रेष्ठ और पावन हो कि स्वर्ग से लेकर पाताल तक की सभी ईश्वरीय शक्तियां हमारे इस यज्ञ (शुभ कार्य) से अत्यंत प्रसन्न हों।
            देवताओं के 'जुषध्वम्' (प्रसन्न होने) का अर्थ है हमारे पर्यावरण का शुद्ध होना और समाज में सुख-समृद्धि तथा शांति का निरंतर विकास होना।
            हम एक ऐसे एकाकार और समग्र जीवन को अपनाएं जहाँ हम संपूर्ण ब्रह्मांड को अपना ही एक वृहद और आत्मीय परिवार मानकर सबकी सेवा करें।
        """.trimIndent(),
        englishCommentary = """
            O Gods! The eleven deities who are situated in the heavenly realm (Dyuloka), the eleven deities who reside on this earth...
            And the eleven deities who dwell in the waters (mid-space) with their glory; may all those thirty-three (33) gods joyfully accept this holy sacrifice of ours.
            This is an extremely famous mantra of the Vedas presenting a clear and beautiful classification of the 33 Koti (types) of deities.
            'Koti' here does not mean 'crores' (ten millions) but 'categories' or 'types'; these 33 types of natural and cosmic forces operate the entire creation.
            (These 33 gods are: 8 Vasus, 11 Rudras, 12 Adityas, 1 Indra, and 1 Prajapati). The balance of all these across the three worlds is the secret of the universe's stability.
            When we invoke all gods together, we are actually expressing our deep respect for the completeness and infinite balance of nature.
            O Supreme Lord! May all these divine forces remain favorable in our lives; may no power of water, earth, or sky ever become destructive for us.
            May our actions be so noble and holy that all divine forces from heaven to earth are highly pleased with this sacrifice (auspicious work) of ours.
            The gods being 'Jushadhvam' (pleased) means our environment becoming pure and happiness, prosperity, and peace continuously developing in society.
            Let us adopt such a unified and holistic life where we consider the entire universe as our own large, intimate family and serve absolutely everyone.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 18,
        sanskrit = "आयुषः प्राण सन्तनु ।\nअपानं मे यच्छ व्यानं मे यच्छ चक्षुर्मे यच्छ श्रोत्रं मे यच्छ ॥ १८ ॥",
        hindiCommentary = """
            हे अग्निदेव (या परमेश्वर)! आप मेरी आयु (जीवन काल) के साथ मेरे प्राण (मुख्य श्वास) को निरंतर जोड़े रखें और उसका पूर्ण विस्तार करें।
            आप मुझे अपान वायु (मल-मूत्र विसर्जन की शक्ति) प्रदान करें, मुझे व्यान वायु (रक्त संचार की शक्ति) दें; मुझे श्रेष्ठ नेत्र-दृष्टि दें और मुझे उत्तम श्रवण-शक्ति प्रदान करें।
            यह मंत्र शारीरिक स्वास्थ्य और इंद्रियों की पूर्णता के लिए एक अत्यंत वैज्ञानिक और सटीक वैदिक प्रार्थना है।
            प्राण, अपान और व्यान—ये शरीर की तीन मुख्य ऊर्जाएं हैं; जब तक इनका प्रवाह संतुलित है, तब तक मनुष्य पूर्णतः निरोगी और शक्तिसंपन्न रहता है।
            चक्षु (आंख) और श्रोत्र (कान) ज्ञानेंद्रियां हैं; यदि देखने और सुनने की शक्ति क्षीण हो जाए, तो मनुष्य संसार का कोई भी ज्ञान प्राप्त नहीं कर सकता।
            ईश्वर से इन शक्तियों की याचना का अर्थ है कि हम अपने शरीर को एक पवित्र साधन मानें और उसे हमेशा ईश्वर के कार्य में ही लगाएं।
            हे प्रभु! मेरी आंखें केवल शुभ और पवित्र दृश्य ही देखें, और मेरे कान केवल सत्य, ज्ञान तथा आपके पावन यश का ही श्रवण करें।
            हमारी श्वास (प्राण) और हमारी आयु इतनी पुष्ट हो कि हम किसी पर भी बोझ बने बिना एक स्वतंत्र, स्वस्थ और गौरवशाली जीवन व्यतीत कर सकें।
            यह शरीर आपका ही दिया हुआ एक अमूल्य रथ है; इस रथ की सभी इंद्रियां रूपी घोड़े आपके नियंत्रण में हों ताकि वे हमें कभी भी कुमार्ग पर न ले जाएं।
            हमारा पूरा जीवन निरोग रहे और हम अपनी सभी शारीरिक शक्तियों का उपयोग केवल समाज की भलाई और धर्म की रक्षा के लिए ही करें।
        """.trimIndent(),
        englishCommentary = """
            O Agni (or Supreme Lord)! Continuously connect my Prana (main breath) with my life-span and fully expand and extend it.
            Grant me the Apana breath (power of excretion), grant me the Vyana breath (power of blood circulation); grant me excellent vision and grant me excellent hearing.
            This mantra is a highly scientific and precise Vedic prayer for absolute physical health and the perfection of the senses.
            Prana, Apana, and Vyana—these are the three main energies of the body; as long as their flow is balanced, a person remains perfectly disease-free and vigorous.
            Chakshu (eyes) and Shrotra (ears) are sensory organs; if the power to see and hear weakens, a person cannot acquire any knowledge of the world.
            Begging for these powers from God means we must consider our body a holy instrument and always use it strictly in God's service.
            O Lord! May my eyes see only auspicious and pure sights, and my ears hear only truth, knowledge, and Your holy glory.
            May our breath (Prana) and our life-span be so strong that without becoming a burden on anyone, we lead an independent, healthy, and glorious life.
            This body is an invaluable chariot given by You; may all the horses in the form of its senses be under Your control so they never take us on the wrong path.
            May our entire life remain disease-free, and may we use all our physical powers solely for the betterment of society and the protection of Dharma.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 19,
        sanskrit = "अग्निर्मे वाचि श्रितो वाग्घृदये हृदयं मयि अहममृते अमृतं ब्रह्मणि ॥ १९ ॥",
        hindiCommentary = """
            अग्निदेव (तेज और सत्य) मेरी वाणी में आश्रित हों (निवास करें); मेरी वह पावन वाणी मेरे हृदय में स्थिर और एकरूप रहे।
            मेरा वह शुद्ध हृदय मुझमें (आत्मा में) प्रतिष्ठित हो; मैं (मेरी आत्मा) उस परमानंद रूपी अमृत में स्थित होऊं, और वह अमृत साक्षात् परब्रह्म में प्रतिष्ठित हो।
            यह यजुर्वेद का एक अत्यंत आध्यात्मिक और योग-प्रधान मंत्र है, जो मनुष्य के बाहरी अस्तित्व को सीधे परब्रह्म से जोड़ता है।
            वाणी में अग्नि का अर्थ है कि हम जो भी बोलें, उसमें सत्य का तेज हो, वह प्रभावशाली हो और उसमें कोई भी असत्य या मलिनता न हो।
            वाणी का हृदय में होने का अर्थ है 'मनसा वाचा कर्मणा' की एकता—यानी जो हमारे दिल में है, वही हमारी जुबान पर हो; कोई भी पाखंड न हो।
            जब मन, वाणी और हृदय एक हो जाते हैं, तब मनुष्य की आत्मा (मैं) मृत्यु के भय से मुक्त होकर 'अमृत' (अमरत्व) की अवस्था को प्राप्त कर लेती है।
            हे परमात्मा! मेरे जीवन में ऐसा अद्वैत (एकता) लाएं कि मेरी हर सांस और मेरा हर शब्द केवल आपके ही परम स्वरूप (ब्रह्म) में विलीन हो जाए।
            हम संसार की नश्वर वस्तुओं में सुख न खोजें, बल्कि अपने भीतर स्थित उस अमृत की खोज करें जो हमें सीधा ईश्वर से मिला देता है।
            यह मंत्र मनुष्य को स्थूल शरीर से उठाकर सूक्ष्म ब्रह्मांडीय चेतना तक ले जाने की एक अत्यंत सुंदर और क्रमबद्ध आध्यात्मिक यात्रा है।
            हमारा अस्तित्व उस परब्रह्म में इस प्रकार समा जाए जैसे नदी समुद्र में मिलकर अपना नाम और रूप खोकर स्वयं विराट समुद्र ही बन जाती है।
        """.trimIndent(),
        englishCommentary = """
            May Agni (brilliance and truth) reside in my speech; may that holy speech be firmly established and unified in my heart.
            May that pure heart be established in me (the soul); may I (my soul) be established in the nectar of supreme bliss (Amrita), and that nectar be established in the Supreme Brahman.
            This is a highly spiritual and Yoga-centric mantra of the Yajurveda, which directly connects human's external existence to the Supreme Brahman.
            Agni in speech means that whatever we speak should have the brilliance of truth, be impactful, and completely free from untruth or impurity.
            Speech in the heart signifies the unity of 'mind, speech, and action'—meaning what is in our heart is exactly on our tongue; there should be no hypocrisy.
            When the mind, speech, and heart become one, the human soul ('I') becomes free from the fear of death and attains the state of 'Amrita' (immortality).
            O Supreme Lord! Bring such non-duality (unity) into my life that my every breath and every word merges solely into Your supreme form (Brahman).
            Let us not search for happiness in the perishable things of the world, but seek that nectar situated within us which merges us directly with God.
            This mantra is an extremely beautiful and sequential spiritual journey taking a human from the gross physical body to subtle cosmic consciousness.
            May our existence merge into that Supreme Brahman just as a river merging into the ocean loses its name and form, becoming the vast ocean itself.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 20,
        sanskrit = "सूर्य मे चक्षुषि श्रितश्चक्षुर्हृदये हृदयं मयि अहममृते अमृतं ब्रह्मणि ॥ २० ॥",
        hindiCommentary = """
            सूर्यदेव (ज्ञान और प्रकाश) मेरे चक्षुओं (नेत्रों) में आश्रित हों; मेरी वह दिव्य दृष्टि मेरे हृदय में पूरी तरह स्थिर और एकरूप रहे।
            मेरा वह शुद्ध हृदय मुझमें (आत्मा में) प्रतिष्ठित हो; मैं (मेरी आत्मा) उस परमानंद रूपी अमृत में स्थित होऊं, और वह अमृत साक्षात् परब्रह्म में प्रतिष्ठित हो।
            यह मंत्र पिछले मंत्र का ही विस्तार है, जहाँ वाणी के स्थान पर 'दृष्टि' (चक्षु) को परब्रह्म के साथ एकाकार करने की प्रार्थना की गई है।
            नेत्रों में सूर्य के होने का अर्थ है कि हम संसार को अज्ञान या वासना की दृष्टि से न देखें, बल्कि ज्ञान, विवेक और ईश्वरीय प्रकाश की दृष्टि से देखें।
            जब हमारी दृष्टि पवित्र होती है, तो उसका सीधा और गहरा प्रभाव हमारे हृदय पर पड़ता है, और हमारा हृदय सभी प्रकार के विकारों से मुक्त हो जाता है।
            आंखें मन का दर्पण हैं; यदि दृष्टि में सूर्य का तेज (पवित्रता) होगा, तो मन में कभी भी पाप या अंधकार प्रवेश ही नहीं कर सकेगा।
            हे प्रभु! मुझे वह 'सम्यक् दृष्टि' प्रदान करें जिससे मैं इस संपूर्ण सृष्टि में केवल आपके ही विराट और मंगलमय रूप के दर्शन कर सकूं।
            जब हम बाहर से भीतर की ओर यात्रा करते हैं (नेत्र -> हृदय -> आत्मा -> अमृत -> ब्रह्म), तो हमें पता चलता है कि ईश्वर हमसे अलग नहीं है।
            हमारा दृष्टिकोण इतना विशाल हो जाए कि हम किसी भी जीव से घृणा न करें, क्योंकि सबमें उसी एक परब्रह्म का ही पावन प्रकाश विद्यमान है।
            हम मृत्यु के भय को त्यागकर उस अमर अवस्था को प्राप्त करें जहाँ आत्मा अपने परम स्रोत (ब्रह्म) में मिलकर सदा के लिए पूर्ण और शांत हो जाती है।
        """.trimIndent(),
        englishCommentary = """
            May the Sun God (knowledge and light) reside in my eyes (Chakshu); may that divine vision be firmly established and unified in my heart.
            May that pure heart be established in me (the soul); may I (my soul) be established in the nectar of supreme bliss (Amrita), and that nectar be established in the Supreme Brahman.
            This mantra is an extension of the previous one, where instead of speech, a prayer is made to unify 'vision' (Chakshu) with the Supreme Brahman.
            The Sun in the eyes means we should not look at the world with the vision of ignorance or lust, but with the vision of knowledge, discernment, and divine light.
            When our vision is pure, it directly and deeply impacts our heart, and our heart becomes completely free from all kinds of afflictions.
            Eyes are the mirror of the mind; if there is the brilliance of the sun (purity) in the vision, sin or darkness can never ever enter the mind.
            O Lord! Grant me that 'perfect vision' through which I can see only Your magnificent and auspicious form in this entire creation.
            When we travel from outside to inside (Eyes -> Heart -> Soul -> Amrita -> Brahman), we realize that God is absolutely not separate from us.
            May our perspective become so vast that we do not hate any living being, because the holy light of that one Supreme Brahman exists in everyone.
            Abandoning the fear of death, may we attain that immortal state where the soul merges into its ultimate source (Brahman), becoming complete and peaceful forever.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 21,
        sanskrit = "प्राणो मे श्रोत्रे श्रितः श्रोत्रं हृदये हृदयं मयि अहममृते अमृतं ब्रह्मणि ॥ २१ ॥",
        hindiCommentary = """
            प्राणवायु (जीवन और चेतना) मेरे श्रोत्र (कानों) में आश्रित हो; मेरी वह श्रवण-शक्ति मेरे हृदय में पूरी तरह स्थिर और एकरूप रहे।
            मेरा वह शुद्ध हृदय मुझमें (आत्मा में) प्रतिष्ठित हो; मैं (मेरी आत्मा) उस परमानंद रूपी अमृत में स्थित होऊं, और वह अमृत साक्षात् परब्रह्म में प्रतिष्ठित हो।
            यह इस आध्यात्मिक श्रृंखला का तीसरा मंत्र है, जो हमारी 'श्रवण शक्ति' (सुनने की क्षमता) को परब्रह्म के साथ एकाकार करता है।
            कानों में प्राण के होने का अर्थ है कि हम जो कुछ भी सुनें, वह हमारे लिए जीवनदायी (सकारात्मक) हो; हम कभी भी निंदा, चुगली या बुरे वचन न सुनें।
            जब हम केवल श्रेष्ठ ज्ञान और ईश्वरीय गुणगान सुनते हैं, तो उसका सीधा असर हमारे हृदय पर होता है और हमारा अंतःकरण अत्यंत शांत हो जाता है।
            श्रवण ही ज्ञान प्राप्ति का सबसे पहला और मुख्य द्वार है (श्रुति); यदि कान पवित्र बातें सुनेंगे, तो आत्मा स्वतः ही परमात्मा की ओर खिंचने लगेगी।
            हे परमात्मा! मेरे कानों को ऐसा संस्कार दें कि वे सांसारिक शोर में भी केवल आपकी शांतिपूर्ण ध्वनि (अनाहत नाद) को ही सुन सकें।
            हमारा हृदय विचारों का केंद्र है; जब वाणी, दृष्टि और श्रवण तीनों शुद्ध होकर हृदय में मिलते हैं, तो हृदय साक्षात् देवालय (मंदिर) बन जाता है।
            यही वह अवस्था है जहाँ 'मैं' (अहंकार) पूरी तरह से मिट जाता है और केवल वह शाश्वत 'अमृत' शेष रह जाता है जो मृत्यु को भी जीत लेता है।
            हमारा पूरा अस्तित्व उस अनंत ब्रह्म में इस प्रकार लीन हो जाए कि हम केवल संसार में रहते हुए भी पूरी तरह से जीवनमुक्त (मोक्ष प्राप्त) अवस्था में जिएं।
        """.trimIndent(),
        englishCommentary = """
            May the vital breath (life and consciousness) reside in my ears (Shrotra); may that hearing power be firmly established and unified in my heart.
            May that pure heart be established in me (the soul); may I (my soul) be established in the nectar of supreme bliss (Amrita), and that nectar be established in the Supreme Brahman.
            This is the third mantra of this spiritual series, which unifies our 'hearing power' with the Supreme Brahman.
            Prana in the ears means whatever we hear should be life-giving (positive) to us; we should never listen to slander, gossip, or evil words.
            When we listen only to excellent knowledge and divine praises, it directly affects our heart, and our inner conscience becomes extremely peaceful.
            Hearing is the very first and main doorway to acquiring knowledge (Shruti); if ears hear holy things, the soul will automatically be drawn towards God.
            O Supreme Lord! Condition my ears in such a way that even amidst worldly noise, they can hear only Your peaceful sound (Anahata Nada).
            Our heart is the center of thoughts; when speech, vision, and hearing all become pure and meet in the heart, the heart becomes a direct temple of God.
            This is the very state where 'I' (ego) is completely erased, and only that eternal 'Amrita' remains which conquers even death itself.
            May our entire existence merge into that infinite Brahman in such a way that even while living in the world, we live completely in a liberated state (Moksha).
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 22,
        sanskrit = "दिक्पतिर्विशाम्पतिः ।\nअयं नो विश्वतोमुखाः पातु सर्वतः ॥ २२ ॥",
        hindiCommentary = """
            वे परमेश्वर जो समस्त दिशाओं के अधिपति (दिक्पति) हैं और जो संपूर्ण प्रजाओं (मनुष्यों और जीवों) के पालनहार (विशाम्पति) हैं।
            वे विश्वतोमुख (जिनका मुख हर दिशा में है, अर्थात् जो सर्वद्रष्टा और सर्वव्यापी हैं) परमात्मा हमारी सब ओर से (सर्वतः) रक्षा करें।
            यह एक अत्यंत सुंदर और शक्तिशाली रक्षा मंत्र है; जो ईश्वर को किसी एक दिशा या स्थान में सीमित नहीं करता, बल्कि उसे सर्वव्यापी मानता है।
            'विश्वतोमुख' का अर्थ है कि ईश्वर की दृष्टि से ब्रह्मांड का कोई भी कोना छिपा नहीं है; वह हर जगह उपस्थित रहकर हमारी हर गतिविधि को देखता है।
            जब हम यह अनुभव कर लेते हैं कि ईश्वर हर दिशा में मौजूद है, तो हमारे मन से अकेलेपन और असुरक्षा का हर भय हमेशा के लिए समाप्त हो जाता है।
            ईश्वर केवल दिशाओं का नहीं, बल्कि हमारी 'प्रजा' (परिवार और समाज) का भी स्वामी है; अतः हमें अपने सभी दायित्वों को उसी को सौंप देना चाहिए।
            हे प्रभु! आप हमारे जीवन के चारों ओर एक ऐसा अभेद्य सुरक्षा कवच बना दें जिसे संसार की कोई भी नकारात्मक शक्ति कभी भेद न सके।
            हम जिस दिशा में भी कदम बढ़ाएं, हमें केवल आपकी ही उपस्थिति का अनुभव हो और हम कभी भी कोई ऐसा कर्म न करें जो आपकी दृष्टि में अनुचित हो।
            यह सर्वव्यापी ईश्वरीय बोध हमें पाप करने से रोकता है, क्योंकि हम जानते हैं कि ईश्वर हर समय, हर दिशा से हमें देख रहा है।
            हम पूर्णतः निश्चिंत और निर्भय होकर धर्म के मार्ग पर चलें, क्योंकि जब समस्त दिशाओं का स्वामी हमारी रक्षा कर रहा है, तो हमारा कोई अहित कैसे कर सकता है?
        """.trimIndent(),
        englishCommentary = """
            That Supreme Lord who is the master of all directions (Dikpati) and the nourisher of all subjects (humans and living beings - Vishampati).
            May that Vishvatomukha (whose face is in every direction, i.e., who is all-seeing and omnipresent) Supreme Soul protect us from all sides (Sarvatah).
            This is an extremely beautiful and powerful protection mantra; it does not limit God to one direction or place, but considers Him completely omnipresent.
            'Vishvatomukha' means that no corner of the universe is hidden from God's vision; He is present everywhere and observes every single activity of ours.
            When we realize that God is present in every direction, every fear of loneliness and insecurity completely vanishes from our mind forever.
            God is not only the master of directions but also of our 'subjects' (family and society); hence we should surrender all our responsibilities to Him alone.
            O Lord! Please create such an impenetrable protective shield around our lives that no negative force of the world can ever pierce through.
            Whichever direction we step in, may we only experience Your presence, and may we never do any action that is inappropriate in Your eyes.
            This omnipresent divine awareness stops us from committing sins, because we know that God is watching us at all times, from every direction.
            Let us walk the path of Dharma completely relaxed and fearless, because when the master of all directions is protecting us, who can ever harm us?
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 23,
        sanskrit = "त्वमग्ने द्युभिस्त्वमाशुशुक्षणिस्त्वमद्भ्यस्त्वमश्मनस्परि ।\nत्वं वनेभ्यस्त्वमोषधीभ्यस्त्वं नृणां नृपते जायसे शुचिः ॥ २३ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप आकाश (द्युलोक) में सूर्य के तेज के रूप में उत्पन्न होते हैं; आप ही शीघ्रता से प्रज्वलित (आशुशुक्षणि) होने वाले हैं।
            आप जलों (बादलों/विद्युत) से उत्पन्न होते हैं, और आप ही पत्थरों (चकमक) के घर्षण से उत्पन्न होते हैं।
            आप ही वनों (अरणियों/लकड़ियों) से और आप ही औषधियों से प्रकट होते हैं; हे नृपति (मनुष्यों के स्वामी)! आप अत्यंत शुद्ध रूप में उत्पन्न होते हैं।
            यह मंत्र अग्नि की सर्वव्यापकता का अत्यंत वैज्ञानिक और दार्शनिक वर्णन है; अग्नि (ऊर्जा) प्रकृति के हर रूप में छिपी हुई है।
            आकाश में सूर्य, बादलों में बिजली, पत्थर में चिंगारी और लकड़ियों में छिपी ऊष्मा—ये सब एक ही ईश्वरीय ऊर्जा (अग्नि) के विभिन्न रूप हैं।
            'शुचि' का अर्थ है परम पवित्र; अग्नि चाहे जहाँ से भी उत्पन्न हो, वह हमेशा शुद्ध ही रहती है और जिस वस्तु को छूती है, उसे भी शुद्ध कर देती है।
            मनुष्यों का स्वामी (नृपति) कहने का अर्थ है कि हमारे शरीर की ऊष्मा (पाचन और प्राण) भी इसी अग्नि का अंश है, जिसके बिना हम जीवित नहीं रह सकते।
            हे परमात्मा! जिस प्रकार अग्नि हर वस्तु में छिपी रहकर भी पवित्र रहती है, वैसे ही हमारी आत्मा भी इस भौतिक शरीर में रहकर पूर्णतः पवित्र और अछूती रहे।
            हम संसार में कहीं भी रहें, किसी भी परिस्थिति में रहें, हमारे भीतर सत्य और ज्ञान की यह ईश्वरीय ज्योति हमेशा प्रज्वलित रहनी चाहिए।
            ईश्वर सर्वव्यापी ऊर्जा है, जो हमें बाहर से प्रकाश और भीतर से जीवन प्रदान करती है; हम उस परम शुचि (पवित्र) सत्ता को बारंबार नमन करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni! You are born in the sky (Dyuloka) as the brilliance of the sun; You are the one who is quickly kindled (Aashushukshani).
            You are born from the waters (clouds/lightning), and You alone are generated from the friction of stones (flint).
            You manifest from the forests (firewood) and from the herbs; O Nripati (Lord of humans)! You are born in an extremely pure (Shuchi) form.
            This mantra is a highly scientific and philosophical description of Agni's omnipresence; fire (energy) is hidden in every single form of nature.
            The sun in the sky, lightning in clouds, sparks in stones, and heat hidden in wood—these are all various forms of the same divine energy (Agni).
            'Shuchi' means supremely pure; no matter where fire is born from, it always remains pure and purifies whatever object it touches.
            Calling it the lord of humans (Nripati) means the heat of our body (digestion and vitality) is also a part of this Agni, without which we cannot survive.
            O Supreme Lord! Just as fire remains pure despite hiding in every object, may our soul remain completely pure and untouched while residing in this physical body.
            Wherever we live in the world, in whatever situation, this divine flame of truth and knowledge must always remain kindled within us.
            God is the omnipresent energy providing us light from the outside and life from within; we bow repeatedly to that supremely pure reality.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 24,
        sanskrit = "त्वमग्ने सुभृत उत्तमं वयस्तव स्पार्हे वर्ण आ सन्दृशि श्रियः ।\nत्वं वाजः प्रतरणो बृहन्नसि त्वं रयिर्बहुलो विश्वतस्पृथुः ॥ २४ ॥",
        hindiCommentary = """
            हे अग्निदेव! जब आप उत्तम रूप से पुष्ट (प्रज्वलित) होते हैं, तो आप उत्कृष्ट अन्न (आयु और ऊर्जा) प्रदान करने वाले होते हैं।
            आपके अत्यंत स्पृहणीय (आकर्षक और सुंदर) रूप और दर्शन में महान शोभा (श्री) और ऐश्वर्य का निरंतर वास है।
            आप ही वह महान बल (वाज) हैं जो हमें संसार के सभी दुखों और बाधाओं से पार (प्रतरण) ले जाते हैं।
            आप ही वह अत्यंत विशाल (बृहन्) और सब ओर फैला हुआ (विश्वतस्पृथुः) महान धन (रयि) हैं, जो हमें पूर्णतः समृद्ध बनाता है।
            यह मंत्र अग्नि को केवल एक भौतिक तत्व न मानकर उसे आयु, सौंदर्य, बल और परम धन (ज्ञान) के साक्षात् देवता के रूप में पूजता है।
            जब हम ईश्वर (अग्नि) का 'सुभृत' (अच्छी तरह पोषण/ध्यान) करते हैं, तो ईश्वर भी हमें उत्तम जीवन और ऊर्जा (वयस्) से भर देता है।
            ईश्वरीय प्रकाश का दर्शन ही सच्चा 'सौंदर्य' है; दुनिया की सारी भौतिक सुंदरता उसी परम सत्ता की एक छोटी सी झलक मात्र है।
            'प्रतरण' का अर्थ है तारने वाला; ईश्वर का बल ही वह नाव है जो हमें इस संसार रूपी भवसागर के दुखों से पार निकाल सकती है।
            सच्चा धन (रयि) सोना-चांदी नहीं, बल्कि वह सर्वव्यापी ज्ञान और आत्मबल है जो कभी कम नहीं होता और हर दिशा में फैलता है।
            हे प्रभु! हमें वह दिव्य धन प्रदान करें जिससे हमारा जीवन शोभायमान हो, हम बाधाओं को पार करें और समाज के लिए एक महान रक्षक बन सकें।
        """.trimIndent(),
        englishCommentary = """
            O Agni! When You are excellently nourished (kindled), You become the bestower of supreme food (life-span and energy).
            In Your highly desirable (attractive and beautiful) form and vision, great splendor (Shri) and prosperity continuously reside.
            You are that great strength (Vaja) which carries us across (Pratarana) all the sorrows and obstacles of the world.
            You are that extremely vast (Brihan) and all-pervading (Vishvatasprithuh) great wealth (Rayi), which makes us completely prosperous.
            This mantra worships Agni not just as a physical element, but as the direct deity of life-span, beauty, strength, and ultimate wealth (knowledge).
            When we 'excellently nourish' (Subhrita - meditate upon) God (Agni), God also fills us with an excellent life and energy (Vayas).
            The vision of divine light is the true 'beauty'; all the material beauty of the world is merely a small glimpse of that Supreme Reality.
            'Pratarana' means the savior; God's strength is the only boat that can carry us across the sorrows of this ocean-like world.
            True wealth (Rayi) is not gold or silver, but that omnipresent knowledge and inner strength which never diminishes and spreads in all directions.
            O Lord! Grant us that divine wealth which adorns our lives, helps us cross obstacles, and enables us to become a great protector for society.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 25,
        sanskrit = "त्वमग्ने द्युभिस्त्वमाशुशुक्षणिस्त्वमद्भ्यस्त्वमश्मनस्परि ।\nत्वं वनेभ्यस्त्वमोषधीभ्यस्त्वं नृणां नृपते जायसे शुचिः ॥ २५ ॥",
        hindiCommentary = """
            (अग्नि की सर्वव्यापकता का पुनः दृढ़ स्मरण) हे अग्निदेव! आप आकाश में सूर्य के तेज के रूप में उत्पन्न होते हैं; आप ही शीघ्रता से प्रज्वलित होने वाले हैं।
            आप जलों (बादलों) से उत्पन्न होते हैं, और आप ही पत्थरों के घर्षण से उत्पन्न होते हैं।
            आप ही वनों (लकड़ियों) से और आप ही औषधियों से प्रकट होते हैं; हे नृपति (मनुष्यों के स्वामी)! आप अत्यंत शुद्ध रूप में उत्पन्न होते हैं।
            वैदिक अनुष्ठानों में कुछ मंत्रों की पुनरावृत्ति इस बात पर बल देने के लिए होती है कि साधक इस सत्य को अपने मन में अत्यंत गहराई से उतार ले।
            ईश्वर किसी एक मंदिर, मूर्ति या स्थान तक सीमित नहीं है; वह आकाश से लेकर पाताल तक, और जल से लेकर पत्थर तक हर कण में विद्यमान है।
            यह सर्वव्यापकता का ज्ञान मनुष्य को अत्यंत विनम्र बनाता है, क्योंकि जब हर जगह ईश्वर है, तो हम किसी का भी अपमान या शोषण कैसे कर सकते हैं?
            अग्नि का 'शुचि' (पवित्र) होना यह दर्शाता है कि भौतिक संसार में रहते हुए भी ईश्वर माया और पाप से सर्वथा मुक्त और अछूता है।
            हे परमात्मा! जिस प्रकार आप पत्थर जैसे कठोर पदार्थ से भी प्रकाश के रूप में प्रकट हो जाते हैं, वैसे ही अज्ञानी हृदयों में भी ज्ञान का प्रकाश जगाएं।
            प्रकृति के कण-कण का सम्मान करना ही ईश्वर की सच्ची पूजा है; क्योंकि प्रकृति के हर रूप में वही एक परम सत्ता सांस ले रही है।
            हमारा मन इस परम सत्य को सदा याद रखे कि हमारे भीतर धड़कता हुआ प्राण (नृपति) भी उसी असीम और पवित्र ईश्वरीय अग्नि का ही एक छोटा सा अंश है।
        """.trimIndent(),
        englishCommentary = """
            (Re-affirmation of Agni's omnipresence) O Agni! You are born in the sky as the brilliance of the sun; You are the one quickly kindled.
            You are born from the waters (clouds), and You alone are generated from the friction of stones.
            You manifest from the forests (firewood) and from the herbs; O Nripati (Lord of humans)! You are born in an extremely pure (Shuchi) form.
            In Vedic rituals, the repetition of certain mantras is to emphasize that the seeker must absorb this truth extremely deeply into their mind.
            God is not limited to a single temple, idol, or place; He is present in every particle, from the sky to the underworld, and from water to stone.
            This knowledge of omnipresence makes a human extremely humble, because when God is everywhere, how can we insult or exploit anyone?
            Agni being 'Shuchi' (pure) shows that despite existing in the material world, God is completely free and untouched by illusion and sin.
            O Supreme Lord! Just as You manifest as light even from a hard substance like stone, please awaken the light of knowledge in ignorant hearts too.
            Respecting every particle of nature is the true worship of God; because in every form of nature, that same one Supreme Reality is breathing.
            May our mind always remember this ultimate truth that the life-breath (Nripati) beating within us is also a small part of that infinite, holy divine fire.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 26,
        sanskrit = "उप त्वाग्ने दिवेदिवे दोषावस्तर्धिया वयम् ।\nनमो भरन्त एमसि ॥ २६ ॥",
        hindiCommentary = """
            हे अंधकार को दूर करने वाले (दोषावस्तः) अग्निदेव! हम प्रतिदिन (दिवे-दिवे) दिन और रात अपनी शुद्ध बुद्धि और कर्मों के साथ आपके समीप आते हैं।
            हम अत्यंत श्रद्धापूर्वक आपको नमन (नमस्कार) करते हुए आपकी शरण में उपस्थित होते हैं, ताकि हमारा जीवन आपके प्रकाश से आलोकित रहे।
            यह अग्निहोत्र का एक अत्यंत प्राचीन और प्रसिद्ध मंत्र है, जो ईश्वर के प्रति हमारी निरंतर और दैनिक भक्ति (नित्य कर्म) को दर्शाता है।
            'दिवे-दिवे' (प्रतिदिन) का प्रयोग यह स्पष्ट करता है कि आध्यात्मिक साधना कोई एक दिन का कार्य नहीं है, बल्कि यह जीवन भर चलने वाली अखंड प्रक्रिया है।
            'दोषावस्तः' का अर्थ है वह जो अज्ञान और पाप रूपी रात्रि का नाश करता है; ईश्वर ही हमारे जीवन का वह एकमात्र सूर्य है जो हमें पापों से बचाता है।
            हम केवल खाली हाथ नहीं आते, बल्कि 'धिया' (शुद्ध बुद्धि और श्रेष्ठ विचारों) की भेंट लेकर ईश्वर के दरबार में नतमस्तक होते हैं।
            हे परमात्मा! हमारे मन की अस्थिरता को दूर करें ताकि हमारी प्रार्थना कभी खंडित न हो और हम हर दिन आपके और अधिक समीप पहुँच सकें।
            नमः (नमन) का अर्थ है 'न मम' (यह मेरा नहीं है); हम अपना सब कुछ आपके चरणों में समर्पित कर अहंकार को पूरी तरह त्याग देते हैं।
            जब साधक नित्य प्रति ईश्वर का स्मरण करता है, तो उसके भीतर का सारा अंधकार स्वतः ही समाप्त हो जाता है और उसे असीम शांति मिलती है।
            हमारा यह दैनिक यज्ञ हमें शारीरिक, मानसिक और आत्मिक रूप से इतना सबल बनाए कि संसार का कोई भी दुख हमें कभी विचलित न कर सके।
        """.trimIndent(),
        englishCommentary = """
            O Agni, dispeller of darkness (Doshavastah)! Day by day (Dive-dive), day and night, we approach You with our pure intellect and actions.
            We come bearing our utmost devotion and bowing (Namah) to Your refuge, so that our lives remain illuminated by Your light.
            This is an extremely ancient and famous Agnihotra mantra, illustrating our continuous and daily devotion (Nitya Karma) towards God.
            The use of 'Dive-dive' (every day) clarifies that spiritual practice is not a one-day task, but an unbroken, lifelong continuous process.
            'Doshavastah' means the one who destroys the night of ignorance and sin; God is the only sun in our lives that saves us from sins.
            We do not come empty-handed, but bow in God's court bringing the gift of 'Dhiya' (pure intellect and noble, excellent thoughts).
            O Supreme Lord! Remove the instability of our minds so our prayers are never broken and we reach closer to You every single day.
            Namah (bowing) means 'Na Mama' (this is not mine); we surrender everything at Your holy feet and completely abandon our ego.
            When a seeker remembers God daily, all their inner darkness automatically ends, and they attain infinite, profound mental peace.
            May this daily sacrifice make us so strong physically, mentally, and spiritually that no worldly sorrow can ever disturb us at all.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 27,
        sanskrit = "राजन्तमध्वराणां गोपामृतस्य दीदिविम् ।\nवर्धमानं स्वे दमे ॥ २७ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप सभी हिंसारहित (अध्वर) यज्ञों के प्रकाशमान और सर्वोच्च अधिपति (राजन्तम्) हैं, जो सत्य और धर्म का निरंतर शासन करते हैं।
            आप ऋत (सृष्टि के शाश्वत नियम और सत्य) के रक्षक (गोपाम्) हैं, और आप ही अपने प्रकाश (दीदिविम्) से संपूर्ण जगत को आलोकित करते हैं।
            आप अपने स्वयं के घर (स्वे दमे अर्थात् यज्ञवेदी या साधक के हृदय) में नित्य प्रति अत्यंत वृद्धि को प्राप्त होने वाले (वर्धमानम्) हैं।
            यज्ञों को 'अध्वर' कहना यह प्रमाणित करता है कि वैदिक अनुष्ठान मूलतः जीव-कल्याण और अहिंसा पर आधारित हैं, हिंसा पर नहीं।
            ईश्वर ही ऋत (ब्रह्मांडीय सत्य) का असली रक्षक है; जब मनुष्य सत्य के मार्ग पर चलता है, तो ईश्वर स्वयं उसकी रक्षा के लिए आगे आता है।
            ईश्वर का अपने 'घर' में बढ़ने का अर्थ है कि जब हम अपने अंतःकरण को शुद्ध कर लेते हैं, तो ईश्वर का प्रकाश हमारे भीतर दिन-प्रतिदिन बढ़ता जाता है।
            हे प्रभु! आप हमारे हृदय रूपी मंदिर में विराजमान हों और अपने दिव्य तेज से हमारे ज्ञान, प्रेम और पवित्रता में निरंतर वृद्धि करते रहें।
            सत्य की ज्योति कभी स्थिर नहीं रहती, यदि उसे भक्ति का घी मिलता रहे, तो वह लगातार बढ़ती (वर्धमान) ही रहती है और अज्ञान को भस्म कर देती है।
            हम अपने जीवन को ऐसा पवित्र यज्ञ बनाएं जहाँ किसी के भी प्रति कोई द्वेष या शत्रुता न हो, बल्कि केवल विश्व-कल्याण की कामना हो।
            यह मंत्र हमें सत्य का रक्षक बनने और ईश्वर को अपने भीतर स्थापित कर उसे निरंतर पोषित करने की अत्यंत महान और सुंदर प्रेरणा देता है।
        """.trimIndent(),
        englishCommentary = """
            O Agni! You are the radiant and supreme ruler (Rajantam) of all non-violent (Adhvara) sacrifices, continuously governing truth and Dharma.
            You are the protector (Gopam) of Rta (the eternal cosmic law and truth), and You alone illuminate the entire world with Your light (Didivim).
            You are the one who continuously grows and expands (Vardhamanam) in Your own home (Sve Dame, meaning the altar or the seeker's heart).
            Calling sacrifices 'Adhvara' proves that Vedic rituals are fundamentally based on the welfare of beings and non-violence, not on violence.
            God is the real protector of Rta (cosmic truth); when a human walks on the path of truth, God Himself steps forward to protect them.
            God growing in His 'home' means that when we purify our inner conscience, the light of God increases within us day by day.
            O Lord! Please reside in the temple of our hearts and continuously increase our knowledge, love, and purity with Your divine brilliance.
            The flame of truth never remains stagnant; if it receives the Ghee of devotion, it continuously grows (Vardhamana) and burns away ignorance.
            Let us make our life such a pure sacrifice where there is absolutely no malice or enmity towards anyone, but only the wish for global welfare.
            This mantra gives us the extremely great and beautiful inspiration to become protectors of truth and establish God within ourselves to nourish Him.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 28,
        sanskrit = "स नः पितेव सूनवेऽग्ने सूपायनो भव ।\nसचस्वा नः स्वस्तये ॥ २८ ॥",
        hindiCommentary = """
            हे अग्निदेव (परमेश्वर)! जिस प्रकार एक पिता अपने पुत्र के लिए अत्यंत सरलता से सुलभ (आसानी से प्राप्त होने वाला) होता है...
            उसी प्रकार आप भी हमारे लिए अत्यंत सुलभ (सूपायन) हों; और हमारे पूर्ण कल्याण (स्वस्ति) के लिए आप सदैव हमारे साथ-साथ रहें (सचस्वा)।
            यह मंत्र ईश्वर और भक्त के बीच अत्यंत आत्मीय, मधुर और पिता-पुत्र के निस्वार्थ प्रेमपूर्ण संबंध को अत्यंत सुंदरता से स्थापित करता है।
            ईश्वर कोई कठोर तानाशाह या डराने वाली सत्ता नहीं है, बल्कि वह एक करुणामयी पिता है जिसके पास बच्चा बिना किसी भय के कभी भी जा सकता है।
            'सूपायन' का अर्थ है जिसे आसानी से प्राप्त किया जा सके; सच्ची भक्ति और निर्मल हृदय से ईश्वर को प्राप्त करना अत्यंत सरल है, इसमें कोई जटिलता नहीं है।
            'स्वस्ति' का अर्थ है सर्वांगीण कल्याण—शारीरिक, मानसिक और आध्यात्मिक; ईश्वर का साथ ही मनुष्य के जीवन की सबसे बड़ी और सच्ची स्वस्ति है।
            हे प्रभु! हम संसार की भूलभुलैया में भटकते हुए अबोध बालक हैं; आप पिता बनकर हमारा हाथ थामें और हमें सही मार्ग दिखाएं।
            जैसे पिता अपने बच्चे के दोषों को क्षमा कर उसे गले लगाता है, वैसे ही आप हमारी अज्ञानता को क्षमा कर हमें अपने प्रेम की शरण में ले लें।
            जब ईश्वर हमारे साथ (सचस्वा) होता है, तो जीवन की कोई भी विपत्ति या संकट हमारा अहित नहीं कर सकता; हम पूर्णतः निर्भय हो जाते हैं।
            यह मंत्र हमें यह दृढ़ विश्वास दिलाता है कि ईश्वर की करुणा असीम है, और उसका आशीर्वाद हमारे जीवन को हमेशा सुख और शांति से भर देता है।
        """.trimIndent(),
        englishCommentary = """
            O Agni (Supreme Lord)! Just as a father is extremely accessible and easy to approach for his beloved son...
            In the exact same way, may You become extremely accessible (Supayana) to us; and please always stay with us (Sachasva) for our ultimate welfare (Svasti).
            This mantra beautifully establishes the extremely intimate, sweet, and selfless father-son loving relationship between God and the devotee.
            God is not a harsh dictator or a terrifying authority, but a compassionate father to whom a child can go at any time without any fear.
            'Supayana' means easily attainable; attaining God through true devotion and a pure heart is extremely simple; there is no complexity in it.
            'Svasti' means all-around welfare—physical, mental, and spiritual; the company of God is indeed the greatest and truest Svasti of human life.
            O Lord! We are innocent children wandering in the labyrinth of the world; please hold our hands as a father and show us the correct path.
            Just as a father forgives his child's faults and embraces him, please forgive our ignorance and take us into the pure refuge of Your love.
            When God is with us (Sachasva), no calamity or crisis in life can ever harm us; we become completely absolutely fearless.
            This mantra gives us the firm belief that God's compassion is infinite, and His blessing always fills our lives with happiness and profound peace.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 29,
        sanskrit = "अग्ने त्वं नो अन्तम उत त्राता शिवो भवा वरूथ्यः ।\nवसुरग्निर्वासुश्रवा अच्छा नक्षि द्युमत्तमं रयिं दाः ॥ २९ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमारे सबसे निकटतम (अन्तम) मित्र (या बंधु) बनें; आप ही हमारे परम रक्षक (त्राता) और कल्याणकारी (शिव) हों।
            आप हमारे लिए अत्यंत श्रेष्ठ आश्रयदाता (वरूथ्य) बनें; हे वसु (सबको बसाने वाले) और महान यश वाले (वासुश्रवा) देव! 
            आप हमारी ओर आएं और हमें वह धन (रयि) प्रदान करें जो सबसे अधिक प्रकाशमान (द्युमत्तम) और श्रेष्ठ हो।
            ईश्वर को 'अन्तम' (निकटतम) कहने का अर्थ है कि वह हमारी आत्मा से भी अधिक हमारे निकट है; वह हमारी हर सांस और हर विचार का साक्षी है।
            संसार के रक्षक धोखा दे सकते हैं, परंतु ईश्वर रूपी 'त्राता' हमेशा अपने भक्तों की रक्षा करता है और उनके जीवन को 'शिव' (कल्याणमय) बनाता है।
            प्रकाशमान धन (द्युमत्तम रयि) का अर्थ भौतिक सोना-चांदी नहीं, बल्कि वह असीम आत्मज्ञान और ईश्वरीय विवेक है जो कभी नष्ट नहीं होता।
            हे परमात्मा! हमारे जीवन के सभी भयों को दूर कर हमें अपनी वह मजबूत ढाल (वरूथ्य) प्रदान करें जिससे कोई भी बुराई हमें छू न सके।
            हम आपको केवल स्वर्ग में नहीं, बल्कि अपने ही अंतःकरण में खोजें, क्योंकि आप हमारे सबसे सच्चे और स्थायी मित्र हैं।
            वासुश्रवा (महान यश वाला) कहकर हम यह प्रार्थना करते हैं कि आपके सान्निध्य से हमारे जीवन में भी धर्म और यश की निरंतर वृद्धि हो।
            यह मंत्र हमें संसार के नश्वर आश्रयों को छोड़कर केवल और केवल उस एक शाश्वत ईश्वरीय आश्रय को अपनाने की महान प्रेरणा देता है।
        """.trimIndent(),
        englishCommentary = """
            O Agni! Become our closest and most intimate (Antama) friend; may You alone be our supreme protector (Trata) and purely benevolent (Shiva).
            May You become the most excellent provider of refuge (Varuthya) for us; O Vasu (dweller of all) and God of great glory (Vasushrava)!
            Please come towards us and grant us that wealth (Rayi) which is the most luminous (Dyumattama), excellent, and supreme.
            Calling God 'Antama' (closest) means that He is nearer to us than our own soul; He is the absolute witness of our every breath and thought.
            Worldly protectors may betray, but the 'Trata' in the form of God always protects His devotees and makes their lives 'Shiva' (benevolent).
            Luminous wealth (Dyumattama Rayi) does not mean physical gold and silver, but that infinite self-knowledge and divine discernment which never perishes.
            O Supreme Lord! Remove all fears of our lives and grant us Your strong shield (Varuthya) so that no evil can ever even touch us.
            Let us not search for You only in heaven, but right within our own conscience, because You are our truest and most permanent friend.
            By saying Vasushrava (of great glory), we pray that through Your proximity, Dharma and glory continuously increase in our lives too.
            This mantra gives us the great inspiration to abandon the perishable refuges of the world and adopt solely that one eternal divine refuge.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 30,
        sanskrit = "तं त्वा शोचिष्ठ दीदिवः सुम्नाय नूनमीमहे सखिभ्यः ।\nस नो बोधि श्रुधी हवमुरुष्या णो अघायतः समस्मात् ॥ ३० ॥",
        hindiCommentary = """
            हे अत्यंत प्रकाशमान (शोचिष्ठ) और सर्वत्र दीप्तिमान (दीदिवः) अग्निदेव! हम अपने और अपने मित्रों (सखिभ्यः) के सुख (सुम्नाय) के लिए आपकी स्तुति करते हैं।
            हम अभी (नूनम्) आपकी याचना करते हैं; हे देव! आप हमारे अंतःकरण में भली-भांति जाग्रत (बोधि) हों और हमारी इस पुकार (हवम्) को सुनें।
            और आप हमें उन सभी पापों, बुराइयों और पापियों (अघायतः) से पूरी तरह से बचाएं (उरुष्य) जो हमारा अहित करना चाहते हैं।
            यह मंत्र 'बहुजन हिताय' की भावना से भरा है, जहाँ साधक केवल अपने लिए नहीं, बल्कि अपने मित्रों और समाज के सुख (सुम्नाय) की भी प्रार्थना करता है।
            ईश्वर से 'जाग्रत' होने का आग्रह वास्तव में हमारी अपनी आत्मा को उस ईश्वरीय प्रकाश के प्रति जाग्रत और संवेदनशील करने की तीव्र पुकार है।
            अघायतः का अर्थ है पाप और नकारात्मकता; जब तक ईश्वर हमारी रक्षा नहीं करता, हम संसार की वासनाओं और बुराइयों से नहीं बच सकते।
            हे प्रभु! हमारी पुकार आपके कानों तक पहुँचे और आपका तेज हमारे जीवन के हर अंधकार को जलाकर हमें परम शांति प्रदान करे।
            हम जो भी सुख प्राप्त करें, उसे अपने मित्रों और परिजनों के साथ बांटें, क्योंकि स्वार्थ में लिप्त होकर पाया गया सुख वास्तव में दुख ही है।
            ईश्वर की स्तुति से हमारा मन इतना मजबूत हो जाए कि हम किसी भी अघ (पाप) के सम्मुख कभी घुटने न टेकें और हमेशा धर्म के मार्ग पर डटे रहें।
            आपकी ज्योति हमारे चारों ओर एक ऐसा सुरक्षा चक्र बना दे जिसमें प्रवेश करके हर शत्रु मित्र बन जाए और हर दुख सुख में परिवर्तित हो जाए।
        """.trimIndent(),
        englishCommentary = """
            O supremely luminous (Shochishtha) and universally radiant (Didivah) Agni! We praise You for the happiness (Sumnaya) of ourselves and our friends (Sakhibhyah).
            We implore You right now (Nunam); O God! Please fully awaken (Bodhi) in our inner conscience and listen to this call (Havam) of ours.
            And please protect (Urushya) us completely from all those sins, evils, and sinners (Aghayatah) who wish to cause us absolute harm.
            This mantra is filled with the spirit of 'welfare of many', where the seeker prays not just for himself, but for the happiness of his friends and society.
            Urging God to 'awaken' is actually an intense call to awaken and sensitize our own soul towards that supreme divine light.
            Aghayatah means sin and negativity; unless God protects us, we simply cannot escape the lusts and deep evils of the material world.
            O Lord! May our call reach Your ears, and may Your brilliance burn away every darkness of our lives, granting us supreme and ultimate peace.
            Whatever happiness we attain, let us share it with our friends and family, because happiness attained while engrossed in selfishness is actually sorrow.
            May our mind become so strong through God's praise that we never kneel before any Agha (sin) and always stand firm on the path of Dharma.
            May Your light create such a protective circle around us that upon entering it, every enemy becomes a friend and every sorrow turns into joy.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 31,
        sanskrit = "भूर्भुवः स्वः ।\nतयोस्ते पृथिवि देवयजनि पृष्ठेऽग्निमन्नादमन्नाद्यायादधे ॥ ३१ ॥",
        hindiCommentary = """
            (अग्नि की पुनः स्थापना का मंत्र) ॐ भूर्भुवः स्वः—पृथ्वी, अंतरिक्ष और स्वर्ग तीनों लोक ईश्वरीय सत्ता के ही साक्षात् रूप हैं।
            हे देवों का यजन करने वाली (देवयजनी) पवित्र पृथ्वी! मैं तेरी इसी विस्तृत और पावन पीठ पर इस अग्निदेव को स्थापित करता हूँ।
            मैं इन अन्नाद (अन्न को भक्षण कर उसे देवों तक पहुँचाने वाले) अग्निदेव को अन्न की प्रचुर प्राप्ति और यज्ञ की सफलता के लिए धारण करता हूँ।
            यह मंत्र (जो पहले भी आ चुका है) चातुर्मास्य यज्ञ के एक नए चरण की शुरुआत का प्रतीक है, जहाँ संकल्प को पुनः दोहराया जाता है।
            वैदिक कर्मकांड में पुनरावृत्ति का बहुत महत्त्व है; यह साधक के मन को भटकने से रोककर उसे अपने मूल उद्देश्य पर पूरी तरह केंद्रित करती है।
            पृथ्वी को 'देवयजनी' कहना यह सिद्ध करता है कि यह धरती केवल भोग की वस्तु नहीं है, बल्कि यह वह तपोभूमि है जहाँ श्रेष्ठ कर्म (यज्ञ) किए जाते हैं।
            हे परमात्मा! हमारे घर में अन्न का भंडार हमेशा भरा रहे ताकि हम देवताओं, अतिथियों और निर्धनों का उचित आदर-सत्कार कर सकें।
            जब हम पृथ्वी पर अग्नि स्थापित करते हैं, तो हम वास्तव में अपने जीवन के केंद्र में धर्म और सत्य को स्थापित कर रहे होते हैं।
            हम जो भी उपार्जन करें, वह अग्नि के समान पवित्र हो और हमारे सभी शारीरिक तथा आत्मिक पोषण (अन्नाद्य) का मुख्य कारण बने।
            हमारा यह संकल्प तीनों लोकों (भूर्भुवः स्वः) में गूंजे और हम प्रकृति के साथ पूर्ण सामंजस्य बनाते हुए एक अत्यंत शांतिपूर्ण जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            (Mantra for re-establishing Agni) Om Bhur Bhuvah Svah—Earth, Space, and Heaven, all three worlds are direct manifestations of the Divine Reality.
            O holy Earth where gods are worshipped (Devayajani)! I establish this Lord Agni upon Your very own vast and highly sacred back.
            I hold this Annada (food-consuming, who carries it to gods) Agni for the abundant attainment of food and the ultimate success of the sacrifice.
            This mantra (which appeared earlier) symbolizes the beginning of a new phase of the Chaturmasya sacrifice, where the resolve is firmly reiterated.
            Repetition holds great importance in Vedic rituals; it stops the seeker's mind from wandering and focuses it completely on its core purpose.
            Calling the earth 'Devayajani' proves that this land is not just an object of consumption, but it is the ascetic ground where noble deeds are performed.
            O Supreme Lord! May the food store in our homes always remain full so we can properly respect and host gods, guests, and the poor.
            When we establish Agni on earth, we are actually establishing Dharma and absolute truth at the very center of our human lives.
            Whatever we earn, let it be as pure as fire and become the main cause of all our physical and spiritual nourishment (Annadya).
            May this resolve of ours echo in all three worlds (Bhur Bhuvah Svah) and may we lead an extremely peaceful life, making perfect harmony with nature.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 32,
        sanskrit = "अयं ते योनिर्ऋत्वियो यतो जातो अरोचथाः ।\nतं जानन्नग्न आ रोहाथा नो वर्धया रयिम् ॥ ३२ ॥",
        hindiCommentary = """
            हे अग्निदेव! यह यज्ञवेदी (या अरणि) तुम्हारा ऋतु के अनुकूल (ऋत्विय) और स्वाभाविक उत्पत्ति स्थान (योनि) है।
            जहाँ से उत्पन्न होकर तुम अत्यंत प्रकाशमान (अरोचथाः) होते हो; हे देव! अपने उस वास्तविक स्थान को जानकर तुम इस पर आरूढ़ (आरोह) होओ।
            और यहाँ स्थापित होकर, तुम हमारे लिए हमारे श्रेष्ठ धन, ज्ञान और ऐश्वर्य (रयिम्) को निरंतर बढ़ाओ (वर्धया)।
            अग्नि का अपने स्थान (योनि) को जानना इस बात का प्रतीक है कि प्रत्येक ईश्वरीय शक्ति का एक निश्चित और प्राकृतिक क्रम होता है।
            आध्यात्मिक दृष्टि से, मानव हृदय ही ईश्वर के प्रकट होने का असली और सबसे पवित्र स्थान है; जब हृदय शुद्ध होता है, तो ईश्वर वहाँ प्रकाशित होता है।
            'अरोचथाः' का अर्थ है शोभा पाना; जब ईश्वर हमारे जीवन में आता है, तो हमारा पूरा अस्तित्व दिव्य ज्योति से जगमगा उठता है।
            हे प्रभु! आप हमारे अंतःकरण रूपी वेदी पर विराजमान हों और अपने तेज से हमारे जीवन के सभी अंधकार और संशयों को सदा के लिए मिटा दें।
            हम जो भी धन या ज्ञान प्राप्त करें, वह आपके आशीर्वाद से निरंतर बढ़ता रहे और कभी भी हमारे अहंकार या पतन का कारण न बने।
            जैसे अग्नि अपनी उत्पत्ति के बाद चारों दिशाओं में प्रकाश फैलाती है, वैसे ही हमारा ज्ञान समाज के हर कोने को अज्ञान से मुक्त करे।
            यह प्रार्थना हमें सिखाती है कि सच्ची समृद्धि (रयि) केवल बाहरी धन नहीं है, बल्कि ईश्वर का हमारे जीवन में स्थिर और जाग्रत रहना ही सबसे बड़ा धन है।
        """.trimIndent(),
        englishCommentary = """
            O Agni! This sacrificial altar (or Arani wood) is Your seasonally appropriate (Ritviya) and natural place of origin (Yoni).
            From where, being born, You become extremely luminous (Arochathah); O God! Knowing that true place of Yours, ascend (Aroha) upon it.
            And being established here, continuously increase (Vardhaya) our excellent wealth, deep knowledge, and prosperity (Rayim) for us.
            Agni knowing His place (Yoni) symbolizes that every divine power has a specific and perfectly natural cosmic order and rhythm.
            Spiritually, the human heart is the real and most sacred place for God to manifest; when the heart is pure, God shines radiantly there.
            'Arochathah' means to be adorned; when God enters our lives, our entire existence lights up brilliantly with divine, celestial light.
            O Lord! Please preside on the altar of our conscience and erase all darkness and doubts of our lives forever with Your great brilliance.
            Whatever wealth or knowledge we acquire, may it continuously grow with Your blessing and never become the cause of our ego or downfall.
            Just as fire spreads light in all directions after its birth, may our knowledge completely free every corner of society from deep ignorance.
            This prayer teaches us that true prosperity (Rayi) is not just external wealth, but God remaining stable and awake in our lives is the greatest wealth.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 33,
        sanskrit = "चिदसि तया देवतयाङ्गिरस्वद् ध्रुवा सीद ।\nपरि त्वा गिर्वणो गिर इमा भवन्तु विश्वतः ।\nवृद्धायुमनु वृद्धयो जुष्टा भवन्तु जुष्टयः ॥ ३३ ॥",
        hindiCommentary = """
            हे इष्टका (यज्ञ की ईंट)! तू 'चित्' (चैतन्य/ज्ञान स्वरूप) है; तू उस परम देवता की शक्ति से और अंगिरा ऋषियों के समान यहाँ अत्यंत दृढ़ता (ध्रुवा) से स्थापित हो जा।
            हे स्तुतियों द्वारा पूजनीय (गिर्वणः) अग्निदेव! हमारी ये सभी प्रार्थनाएं और वेदवाणियां (गिरः) आपको सब ओर (विश्वतः) से घेर लें (आप तक पहुँचें)।
            आपकी आयु (सत्ता) महान और अत्यंत वृद्ध है; आपकी उस महानता के अनुरूप ही हमारी ये सभी स्तुतियां (जुष्टयः) आपके लिए अत्यंत प्रिय और स्वीकार्य हों।
            यज्ञवेदी का निर्माण केवल मिट्टी और ईंटों से नहीं होता; प्रत्येक ईंट को 'चित्' (चेतना) मानकर उसे मंत्रों द्वारा सजीव और आध्यात्मिक बनाया जाता है।
            अंगिरा ऋषियों का संदर्भ यह दर्शाता है कि हम अपनी प्राचीन और पवित्र वैदिक परंपराओं के साथ पूरी दृढ़ता (ध्रुवा) से जुड़े हुए हैं।
            'गिर्वणः' का अर्थ है वह जो उत्तम वाणी और स्तुति से प्रसन्न होता है; ईश्वर हमारी भौतिक वस्तुओं से नहीं, बल्कि हमारे निर्मल भावों से प्रसन्न होता है।
            हे परमात्मा! हमारे शब्द इतने शुद्ध हों कि वे आपके चारों ओर एक माला की तरह सज जाएं और हमारी हर पुकार आप तक सीधे पहुँचे।
            आपकी महिमा अनंत है; यद्यपि हमारी स्तुतियां उस महानता के सामने बहुत छोटी हैं, फिर भी आप अपनी असीम करुणा से उन्हें स्वीकार करें।
            हम जीवन के हर निर्माण (चाहे वह घर हो या चरित्र) को इसी चेतना के साथ अत्यंत मजबूत और दृढ़ बनाएं कि वह धर्म की नींव पर टिका हो।
            यह मंत्र हमें निर्जीव वस्तुओं में भी ईश्वर की चेतना देखने और अपनी वाणी का उपयोग केवल परम सत्य की स्तुति के लिए करने की महान शिक्षा देता है।
        """.trimIndent(),
        englishCommentary = """
            O Ishtaka (sacrificial brick)! You are 'Chit' (embodiment of consciousness/knowledge); be established here with extreme firmness (Dhruva) by the power of that Supreme Deity and like the Angiras sages.
            O Agni, worshipped by praises (Girvanah)! May all these prayers and Vedic words (Girah) of ours surround You from all sides (reach You completely).
            Your life-span (existence) is great and immensely vast; corresponding to that greatness, may all these praises (Jushtayah) be extremely dear and acceptable to You.
            The sacrificial altar is not built merely with soil and bricks; every brick is considered 'Chit' (consciousness) and is made alive and spiritual through mantras.
            The reference to the Angiras sages shows that we are connected with our ancient and holy Vedic traditions with absolute firmness (Dhruva).
            'Girvanah' means one who is pleased by excellent speech and praise; God is pleased not by our material objects, but by our pure emotions.
            O Supreme Lord! May our words be so pure that they adorn You like a garland, and may every call of ours reach You directly and swiftly.
            Your glory is infinite; although our praises are very small before that greatness, yet out of Your boundless compassion, please accept them.
            Let us make every construction of life (whether a house or character) extremely strong with this consciousness, resting purely on the foundation of Dharma.
            This mantra gives us the great teaching of seeing God's consciousness even in inanimate objects and using our speech solely to praise the Ultimate Truth.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 34,
        sanskrit = "समिदसि सूर्यस्त्वा पुरस्तात् पातु कस्याश्चिदभिशस्त्याः ।\nसवितेन्द्रो बृहस्पतिर्वसवो रुद्रा आदित्या विश्वे देवाः ॥ ३४ ॥",
        hindiCommentary = """
            हे समिधा (यज्ञ की लकड़ी)! तू यज्ञ को प्रदीप्त करने वाली है; भगवान सूर्य पूर्व दिशा से तेरी रक्षा करें और तुझे किसी भी प्रकार के अभिशाप (अमङ्गल) से बचाएं।
            सविता देव, देवराज इंद्र, ज्ञान के देव बृहस्पति, आठों वसु, ग्यारह रुद्र, बारह आदित्य और समस्त विश्वेदेव (सभी देवता) मिलकर तेरी रक्षा करें।
            यह मंत्र यज्ञ की पवित्रता को बनाए रखने के लिए ब्रह्मांड की सभी महान शक्तियों का एक साथ शक्तिशाली आह्वान करता है।
            समिधा हमारे 'सत्कर्म' का प्रतीक है; जब हम कोई अच्छा काम शुरू करते हैं, तो अक्सर लोग ईर्ष्या या अभिशाप (अभिशस्ति) से उसे बिगाड़ना चाहते हैं।
            सूर्य देव पूर्व दिशा के स्वामी हैं, जहाँ से प्रकाश आता है; अतः प्रकाश से ही अज्ञान और अमंगल के अंधकार का नाश संभव है।
            वसु, रुद्र और आदित्य प्रकृति की विभिन्न शक्तियां हैं (जैसे अग्नि, वायु, जल आदि); इन सबका अनुकूल होना कार्य की सिद्धि के लिए अनिवार्य है।
            हे प्रभु! जब हम धर्म के मार्ग पर कोई कदम बढ़ाएं, तो हमें समाज की निंदा या किसी भी बुरे प्रभाव से पूरी तरह सुरक्षित रखें।
            हमारा संकल्प इतना मजबूत हो कि स्वर्ग और पृथ्वी की सभी ईश्वरीय शक्तियां हमारे उस शुभ कार्य में हमारी सहायता करने के लिए स्वतः आ जाएं।
            हम जो भी कर्म रूपी समिधा इस जीवन के यज्ञ में डालें, वह बिना किसी बाधा के प्रज्वलित होकर हमारे और समाज के लिए ज्ञान का महान प्रकाश बने।
            यह वैदिक प्रार्थना हमें यह विश्वास दिलाती है कि यदि हमारा उद्देश्य पवित्र है, तो संपूर्ण ब्रह्मांड हमारी रक्षा के लिए एक कवच बन जाता है।
        """.trimIndent(),
        englishCommentary = """
            O Samidha (sacrificial wood)! You are the igniter of the sacrifice; may Lord Surya protect you from the east and save you from any kind of curse (inauspiciousness).
            May God Savitar, Indra the king of gods, Brihaspati the god of wisdom, the eight Vasus, eleven Rudras, twelve Adityas, and all the Vishvedevas (all gods) together protect you.
            This mantra makes a powerful simultaneous invocation of all the great forces of the universe to absolutely maintain the purity of the sacrifice.
            Samidha symbolizes our 'noble deeds'; when we start a good work, people often want to ruin it out of jealousy or a curse (Abhishasti).
            The Sun God is the master of the east, from where light comes; thus, only through light is the destruction of the darkness of ignorance and evil possible.
            Vasus, Rudras, and Adityas are various powers of nature (like fire, wind, water); their favorability is compulsory for the success of the task.
            O Lord! When we take a step on the path of Dharma, keep us completely safe from the condemnation of society or any bad influence.
            May our resolve be so strong that all the divine forces of heaven and earth automatically arrive to assist us in that highly auspicious work.
            Whatever Samidha in the form of action we put into the sacrifice of this life, may it ignite without any obstacle and become a great light of knowledge.
            This Vedic prayer assures us that if our purpose is pure, the entire universe actually becomes an unbreakable shield to protect us.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 35,
        sanskrit = "अग्ने यं यज्ञमध्वरं विश्वतः परिभूरसि ।\nस इद्देवेषु गच्छति ॥ ३५ ॥",
        hindiCommentary = """
            हे अग्निदेव! जिस हिंसारहित (अध्वर) और अत्यंत पावन यज्ञ को आप सब ओर से (विश्वतः) व्याप्त कर लेते हैं (परिभूरसि)...
            निश्चित रूप से (इत्) केवल वही यज्ञ और वही आहुति स्वर्ग में देवताओं के पास सफलतापूर्वक पहुँचती है।
            यह मंत्र स्पष्ट करता है कि कोई भी कर्म या पूजा तब तक सफल नहीं होती जब तक उसमें अग्नि (ईश्वरीय प्रकाश और शुद्ध भावना) का पूर्ण समावेश न हो।
            यज्ञ को पुनः 'अध्वर' कहा गया है, जिसका अर्थ है कि ईश्वर तक केवल वही कर्म पहुँचता है जिसमें किसी भी जीव के प्रति हिंसा या द्वेष का रत्ती भर भी भाव न हो।
            'परिभूः' का अर्थ है सब ओर से घेर लेना; जब हमारा मन पूर्ण रूप से ईश्वर के ध्यान से घिर जाता है, तभी हमारी साधना परिपक्व होती है।
            अग्नि वह दिव्य डाकिया (दूत) है जो हमारे भौतिक अन्न को सूक्ष्म ऊर्जा में बदलकर ब्रह्मांडीय शक्तियों (देवों) तक ले जाता है।
            हे परमात्मा! हमारे जीवन का प्रत्येक कर्म ऐसा हो जिसे आप अपनी कृपा से चारों ओर से घेर लें और उसे पूरी तरह पवित्र कर दें।
            हम जो भी संकल्प लें, वह अधूरा न रहे; वह आपके आशीर्वाद के पंख लगाकर सीधे परमसत्ता के श्रीचरणों में अपनी पूर्णता को प्राप्त करे।
            बिना एकाग्रता और प्रेम के किए गए बड़े-बड़े अनुष्ठान भी व्यर्थ हैं; केवल वही सत्य है जिसे ईश्वरीय चेतना ने सब ओर से अपना लिया हो।
            हमारा हृदय इस अध्वर यज्ञ की तरह इतना निष्पाप हो जाए कि हमारी हर प्रार्थना सीधे आपके हृदय तक बिना किसी बाधा के पहुँच जाए।
        """.trimIndent(),
        englishCommentary = """
            O Agni! That non-violent (Adhvara) and extremely holy sacrifice which You encompass (Paribhurasi) from all sides (Vishvatah)...
            Certainly (It), only that sacrifice and that specific oblation successfully reaches the gods in heaven.
            This mantra clarifies that no action or worship is ever successful until it is fully imbued with Agni (divine light and pure emotion).
            The sacrifice is again called 'Adhvara', which means that only that action reaches God which has absolutely no trace of violence or malice towards any being.
            'Paribhuh' means to surround from all sides; only when our mind is completely surrounded by the meditation of God does our practice mature.
            Agni is that divine messenger (postman) who transforms our physical food into subtle energy and carries it to the cosmic forces (gods).
            O Supreme Lord! May every action of our life be such that You surround it from all sides with Your grace and make it completely pure.
            Whatever resolve we take, let it not remain incomplete; let it gain the wings of Your blessing and attain its perfection directly at the feet of the Supreme.
            Even grand rituals performed without concentration and love are vain; only that is truth which has been embraced by divine consciousness from all sides.
            May our heart become as sinless as this Adhvara sacrifice, so that every single prayer of ours reaches straight to Your heart without any hurdle.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 36,
        sanskrit = "त्वमग्ने गृहपतिस्त्वं होता नो अध्वरे ।\nत्वं पोता विश्ववेदाः ॥ ३६ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप ही हमारे इस घर के वास्तविक स्वामी (गृहपति) हैं; और हमारे इस हिंसारहित (अध्वर) यज्ञ में आप ही देवताओं का आह्वान करने वाले मुख्य पुरोहित (होता) हैं।
            आप ही हमें सभी पापों और बुराइयों से पवित्र करने वाले (पोता) हैं, और आप समस्त ब्रह्मांड के ज्ञान को जानने वाले (विश्ववेदाः) साक्षात् परमेश्वर हैं।
            वैदिक संस्कृति में घर का असली मुखिया मनुष्य नहीं, बल्कि अग्नि (ईश्वर) को माना गया है; मनुष्य केवल एक सेवक या ट्रस्टी के रूप में घर की देखभाल करता है।
            जब ईश्वर को 'गृहपति' मान लिया जाता है, तो घर में कभी भी कलह, अहंकार या स्वार्थ का निवास नहीं हो सकता; वहाँ केवल प्रेम और शांति रहती है।
            'होता' का अर्थ है जो देवताओं को बुलाता है; हमारी प्रार्थनाओं को देवताओं तक पहुँचाने की सामर्थ्य केवल शुद्ध मन (अग्नि) में ही होती है।
            'पोता' का अर्थ है शोधक (Purifier); जीवन में जाने-अनजाने में हुए पापों का प्रायश्चित्त और शुद्धि केवल ईश्वरीय ज्ञान के माध्यम से ही संभव है।
            हे प्रभु! हमारे परिवार के केंद्र में सदैव आप ही विराजमान रहें; हम जो भी निर्णय लें, वह आपकी इच्छा और धर्म के पूर्णतः अनुकूल हो।
            हम अज्ञानी हैं, परंतु आप 'विश्ववेदाः' (सर्वज्ञ) हैं; कृपया हमारे अज्ञान को दूर कर हमें सत्य और न्याय के मार्ग का दर्शन कराएं।
            हमारा यह शरीर भी एक घर है; इस शरीर रूपी घर के स्वामी भी आप ही बनें ताकि हमारी सभी इंद्रियां आपके नियंत्रण में रहकर शुभ कार्य करें।
            हम अपने अभिमान को त्याग कर केवल आपकी शरण में जिएं, क्योंकि जहाँ आप गृहपति होते हैं, वहाँ कभी भी कोई दुख या अमंगल प्रवेश नहीं कर सकता।
        """.trimIndent(),
        englishCommentary = """
            O Agni! You alone are the real master (Grihapati) of this house of ours; and in this non-violent (Adhvara) sacrifice, You are the chief priest (Hota) who invokes the gods.
            You alone are the one who purifies (Pota) us from all sins and evils, and You are the direct Supreme Lord who knows the knowledge of the entire universe (Vishvavedah).
            In Vedic culture, the real head of the house is not a human, but Agni (God); humans only look after the house as a servant or trustee.
            When God is accepted as 'Grihapati', discord, ego, or selfishness can never reside in the house; only pure love and peace remain there.
            'Hota' means the one who calls the gods; the capability to deliver our prayers to the gods lies solely in a pure mind (Agni).
            'Pota' means the Purifier; atonement and purification of sins committed knowingly or unknowingly in life are possible only through divine knowledge.
            O Lord! Please always remain seated at the very center of our family; whatever decisions we make, let them be completely aligned with Your will and Dharma.
            We are ignorant, but You are 'Vishvavedah' (omniscient); please remove our ignorance and show us the clear path of truth and justice.
            This body of ours is also a house; become the master of this body-house too, so all our senses remain under Your control and perform auspicious deeds.
            Let us abandon our pride and live only in Your refuge, because where You are the Grihapati, no sorrow or inauspiciousness can ever enter.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 37,
        sanskrit = "अग्ने शर्ध महते सौभगाय तव द्युम्नान्युत्तमानि सन्तु ।\nसं जास्पत्यं सुयममा कृणुष्व शत्रूयतामभितिष्ठ महांसि ॥ ३७ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें महान सौभाग्य और असीम सुख प्रदान करने के लिए अपना महान बल (शर्ध) प्रकट करें; आपके उत्तम तेज और ऐश्वर्य (द्युम्नानि) सर्वत्र व्याप्त हों।
            आप पति-पत्नी के इस पवित्र संबंध (जास्पत्यम्) को अत्यंत उत्तम नियमों से युक्त (सुयमम्) और अत्यंत सुदृढ़ बनाएं।
            और जो लोग हमसे शत्रुता का भाव रखते हैं (शत्रूयताम्), उनके समस्त अहंकार और बलों (महांसि) को आप अपने पैरों तले कुचल दें (अभितिष्ठ)।
            यह मंत्र गृहस्थ जीवन की सुख-शांति और पारिवारिक एकता के लिए एक अत्यंत शक्तिशाली और सुंदर वैदिक प्रार्थना है।
            ईश्वर से 'सौभाग्य' मांगने का अर्थ केवल धन मांगना नहीं है, बल्कि वह बल मांगना है जिससे हम अपने धर्म का सही प्रकार से पालन कर सकें।
            पति-पत्नी (जास्पत्य) का संबंध समाज की मूल इकाई है; यदि यह संबंध 'सुयम' (अनुशासन और प्रेम से युक्त) होगा, तभी एक श्रेष्ठ राष्ट्र का निर्माण हो सकेगा।
            शत्रुओं के बल को कुचलने की प्रार्थना किसी शारीरिक हिंसा के लिए नहीं, बल्कि उन नकारात्मक शक्तियों के दमन के लिए है जो परिवार को तोड़ना चाहती हैं।
            हे परमात्मा! हमारे घरों में आपसी प्रेम और विश्वास इतना गहरा हो कि कोई भी बाहरी संशय या क्रोध हमारे इस पवित्र बंधन को कभी भी कमजोर न कर सके।
            आपका दिव्य प्रकाश हमारे परिवार का मार्गदर्शन करे और हमारे भीतर छिपे काम, क्रोध और लोभ रूपी आंतरिक शत्रुओं का पूरी तरह से नाश कर दे।
            हमारा दांपत्य जीवन एक ऐसा तपोवन बने जहाँ हम साथ मिलकर आपकी भक्ति करें और अपने श्रेष्ठ कर्मों से इस समाज को प्रकाशित करें।
        """.trimIndent(),
        englishCommentary = """
            O Agni! Manifest Your great strength (Shardha) to grant us great good fortune and boundless happiness; may Your excellent brilliance and wealth (Dyumnani) pervade everywhere.
            Make this holy relationship between husband and wife (Jaspatyam) perfectly regulated (Suyamam) and extremely strong.
            And those who harbor feelings of enmity towards us (Shatruyatam), crush all their ego and powers (Mahansi) entirely under Your feet (Abhitishtha).
            This mantra is a highly powerful and beautiful Vedic prayer for the happiness, peace, and family unity of a householder's life.
            Asking God for 'good fortune' doesn't just mean asking for wealth, but asking for the strength by which we can properly follow our Dharma.
            The husband-wife (Jaspatya) relationship is the basic unit of society; only if this bond is 'Suyama' (filled with discipline and love), can a great nation be built.
            The prayer to crush the enemies' power is not for physical violence, but for the suppression of those negative forces that want to break the family.
            O Supreme Lord! May the mutual love and trust in our homes be so deep that no external doubt or anger can ever weaken this sacred bond.
            May Your divine light guide our family and completely destroy the internal enemies hidden within us in the form of lust, anger, and greed.
            May our married life become such an ascetic grove where we worship You together and illuminate this society through our excellent noble deeds.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 38,
        sanskrit = "समिद्धो अग्ने निहितावतो महां आ रोह स्वतरमा ।\nअग्ने पत्नीवासाह्या देव देवान् ॥ ३८ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमारी उत्तम समिधाओं और शुद्ध भावों से भली-भांति प्रज्वलित (समिद्धः) होकर और अत्यंत महान रूप धारण करके इस यज्ञवेदी पर भली-भांति आरूढ़ (आ रोह) हों।
            आप अपने स्वयं के और सबसे उत्कृष्ट स्थान (स्वतरमा) पर अत्यंत प्रसन्नता के साथ निवास करें, जहाँ आपको स्थापित किया गया है।
            हे देव! आप अपनी अर्धांगिनी (पत्नी/स्वाहा) के साथ यहाँ पधारें और अन्य सभी देवताओं को भी इस यज्ञ में हमारे लिए आमंत्रित कर ले आएं।
            वेदी पर अग्नि के आरोहण का अर्थ है साधक के हृदय में ईश्वरीय चेतना का पूर्ण रूप से स्थिर और जाग्रत हो जाना।
            'स्वतरमा' (अपने उत्तम स्थान) का तात्पर्य है कि ईश्वर का असली निवास कोई ईंट-पत्थर का मंदिर नहीं, बल्कि मनुष्य का अत्यंत शुद्ध और निर्मल अंतःकरण है।
            जब ईश्वर हमारे हृदय में पूरी तरह स्थापित हो जाता है, तो हमारा स्वरूप भी उसी महान अग्नि के समान अत्यंत तेजस्वी और दोषरहित हो जाता है।
            हे प्रभु! हमारे मन को इतना विशाल और पवित्र बना दें कि वह वास्तव में आपके बैठने योग्य एक योग्य और उत्तम सिंहासन बन सके।
            हमारा अहंकार पूरी तरह जल जाए और केवल आपकी वह दिव्य शक्ति शेष रहे जो हमारे हर कर्म को धर्म की दिशा में प्रेरित करती है।
            जिस प्रकार आप अन्य देवों को साथ लाते हैं, उसी प्रकार हमारे जीवन में भी सुख, शांति, स्वास्थ्य और ज्ञान जैसी सभी दैवीय संपदाएं एक साथ प्रवेश करें।
            हम आपकी इस पावन ज्योति की शरण में रहकर अपना पूरा जीवन एक अखंड यज्ञ के रूप में विश्व की भलाई के लिए पूरी तरह समर्पित कर दें।
        """.trimIndent(),
        englishCommentary = """
            O Agni! Being excellently kindled (Samiddhah) by our best firewood and pure feelings, and assuming an extremely great form, ascend (A roha) perfectly upon this sacrificial altar.
            Please reside with immense joy in Your own and most excellent place (Svatarama), where You have been firmly established.
            O God! Please arrive here with Your consort (Patni/Svaha) and also invite and bring all the other gods to this sacrifice for us.
            Agni ascending on the altar means the divine consciousness becoming completely stable and fully awakened in the seeker's heart.
            'Svatarama' (Your excellent place) implies that God's real residence is not a temple of bricks and stones, but the extremely pure and clean conscience of a human.
            When God is completely established in our heart, our nature also becomes extremely brilliant and flawless like that great fire.
            O Lord! Make our mind so vast and holy that it truly becomes a worthy and excellent throne fit for Your seating.
            May our ego burn away completely, leaving only Your divine power that inspires every action of ours in the pure direction of Dharma.
            Just as You bring other gods along, similarly, may all divine wealth like happiness, peace, health, and knowledge enter our lives together.
            Taking refuge in this holy light of Yours, let us completely dedicate our entire life as an unbroken sacrifice for the absolute welfare of the world.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 39,
        sanskrit = "वाचा त्वा होत्रा प्राणेनोद्गात्रा चक्षुषाध्वर्युणा मनसा ब्रह्माणा ।\nश्रोत्रेणाग्नीध्रा तैस्त्वा पञ्चभिर्देव्यैर्ऋत्विग्भिरुद्धरामि ॥ ३९ ॥",
        hindiCommentary = """
            हे अग्नि (परमात्मा)! मैं अपनी पवित्र वाणी रूपी 'होता' (आह्वान करने वाले ऋत्विज) से, और अपने प्राण रूपी 'उद्गाता' (सामगान करने वाले) से...
            अपने चक्षु (नेत्र) रूपी 'अध्वर्यु' (कर्मकांडी) से, और अपने निर्मल मन रूपी 'ब्रह्मा' (यज्ञ के सर्वोच्च निरीक्षक) से...
            तथा अपने कानों रूपी 'आग्नीध्र' (अग्नि प्रज्वलित करने वाले) से—इन पाँचों दिव्य ऋत्विजों (पुरोहितों) के द्वारा मैं तुम्हें अपने भीतर स्थापित करता हूँ (उद्धरामि)।
            यह यजुर्वेद का एक अत्यंत ही रहस्यमयी और आध्यात्मिक (Adhyatmic) मंत्र है, जो बाहरी कर्मकांड को पूरी तरह से आंतरिक योग में बदल देता है।
            यहाँ स्पष्ट किया गया है कि सच्चा यज्ञ बाहर नहीं, शरीर के भीतर चल रहा है; हमारी इंद्रियां और मन ही इस आत्म-यज्ञ के असली पुरोहित हैं।
            जब वाणी सत्य बोलती है, प्राण संयमित होता है, आंखें शुभ देखती हैं, कान शुद्ध सुनते हैं और मन ईश्वर में एकाग्र होता है—यही पूर्ण और सच्चा यज्ञ है।
            हे प्रभु! मेरा यह शरीर ही आपकी यज्ञशाला बन जाए और मेरी ये पाँचों ज्ञानेंद्रियां केवल आपकी ही सेवा में निरंतर लगी रहें।
            बाहरी धन से किया गया यज्ञ तो समाप्त हो जाता है, परंतु मन और इंद्रियों से किया गया यह आत्म-यज्ञ मनुष्य को सीधे मोक्ष तक ले जाता है।
            हम बाहरी दिखावे और कर्मकांडों के जाल से ऊपर उठकर इस वास्तविक और गहरे ईश्वरीय सत्य को पहचानने का प्रयास करें।
            हमारी हर सांस, हर दृष्टि और हर विचार आपके श्रीचरणों में एक पावन आहुति बन जाए, जिससे हम इसी जन्म में परमानंद को प्राप्त कर सकें।
        """.trimIndent(),
        englishCommentary = """
            O Agni (Supreme Lord)! With my holy speech as the 'Hota' (the invoking priest), and with my vital breath as the 'Udgata' (the singing priest)...
            With my eyes as the 'Adhvaryu' (the executive priest), and with my pure mind as the 'Brahma' (the supreme supervisor of the sacrifice)...
            And with my ears as the 'Agnidhra' (the fire-kindling priest)—through these five divine priests, I establish and elevate You within myself (Uddharami).
            This is an extremely mystical and spiritual (Adhyatmic) mantra of the Yajurveda, which completely transforms external rituals into internal Yoga.
            It is clarified here that the true sacrifice is not outside, but going on inside the body; our senses and mind are the real priests of this self-sacrifice.
            When speech speaks truth, breath is controlled, eyes see the auspicious, ears hear the pure, and the mind is focused on God—this is the complete and true sacrifice.
            O Lord! May this body of mine become Your sacrificial hall, and may these five senses of mine remain continuously engaged only in Your service.
            A sacrifice performed with external wealth comes to an end, but this self-sacrifice performed with the mind and senses leads a human directly to ultimate liberation.
            Let us rise above the web of external showoffs and rituals and try to recognize this real and deep divine truth.
            May our every breath, every glance, and every thought become a holy oblation at Your feet, so that we can attain supreme bliss in this very life.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 40,
        sanskrit = "उपप्रयन्तो अध्वरं मन्त्रं वोचेमाग्नये ।\nआरे अस्मे च शृण्वते ॥ ४० ॥",
        hindiCommentary = """
            (मंत्र 11 की पुनरावृत्ति - संकल्प की दृढ़ता के लिए) हम इस हिंसारहित (अध्वर) यज्ञ की ओर निरंतर आगे बढ़ते हुए अग्निदेव के लिए अत्यंत पवित्र मंत्रों का उच्चारण करें।
            वे अग्निदेव जो दूर (आरे) और समीप (अस्मे) सर्वत्र स्थित होकर हमारी प्रार्थनाओं को अत्यंत स्पष्ट और ध्यानपूर्वक सुनते हैं।
            वैदिक दर्शन में 'अध्वर' शब्द का प्रयोग बार-बार यह याद दिलाने के लिए किया जाता है कि धर्म के नाम पर किसी भी प्रकार की हिंसा पूर्णतः वर्जित है।
            ईश्वर सर्वव्यापी है, वह आकाश की ऊंचाइयों में भी है और हमारे हृदय की गहराइयों में भी; उससे हमारा कोई भी भाव कभी छिपा नहीं रह सकता।
            मंत्र केवल होठों से नहीं, बल्कि आत्मा की गहराई से निकलने चाहिए, तभी वे उस सर्वश्रवणशील (सब सुनने वाले) परमात्मा तक पहुँचते हैं।
            हे परमात्मा! हमारे मन की हर मलिनता को दूर करें ताकि हमारी यह नित्य प्रार्थना बिना किसी बाधा के आपके श्रीचरणों में स्वीकार हो।
            हम जीवन के इस महायज्ञ में आलस्य का त्याग कर निरंतर आगे बढ़ें और अपने श्रेष्ठ कर्मों से इस समाज को भी धर्म की ओर प्रेरित करें।
            संसार की दूरियां ईश्वर और भक्त के बीच कोई दीवार नहीं बना सकतीं; एक सच्ची पुकार ईश्वर को पल भर में पास ले आती है।
            हम अपने स्वार्थ से ऊपर उठें और अपनी प्रार्थनाओं में पूरे विश्व के कल्याण, शांति और आनंद की कामना को अनिवार्य रूप से शामिल करें।
            यह पुनरावृत्ति हमारे मन को ईश्वरीय सत्ता के प्रति पूर्णतः एकाग्र कर देती है, जिससे हमारा अंतःकरण परम शांति और आनंद से पूरी तरह भर जाता है।
        """.trimIndent(),
        englishCommentary = """
            (Repetition of Mantra 11 - for firmness of resolve) Continuously advancing toward this non-violent (Adhvara) sacrifice, let us chant extremely holy mantras for Lord Agni.
            That Agni who, being situated everywhere both far (Aare) and near (Asme), clearly and attentively hears all our prayers.
            In Vedic philosophy, the word 'Adhvara' is used repeatedly to remind us that any kind of violence in the name of Dharma is strictly prohibited.
            God is omnipresent, He is in the heights of the sky and also in the depths of our hearts; none of our feelings can ever remain hidden from Him.
            Mantras should not just come from the lips, but from the depth of the soul; only then do they reach that all-hearing Supreme Soul.
            O Supreme Lord! Remove every impurity of our mind so that this daily prayer of ours is accepted at Your holy feet without any obstacle.
            Let us abandon laziness in this grand sacrifice of life, move continuously forward, and inspire this society towards Dharma through our noble deeds.
            Worldly distances cannot build a wall between God and the devotee; one true call brings God near in just a mere moment.
            Let us rise above our selfishness and compulsorily include the wish for the welfare, peace, and joy of the entire world in our prayers.
            This repetition makes our mind completely concentrated towards the divine reality, filling our inner conscience entirely with supreme peace and bliss.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 41,
        sanskrit = "अग्निर्मूर्धा दिवः ककुत्पतिः पृथिव्या अयम् ।\nअपाँ रेताँसि जिन्वति ॥ ४१ ॥",
        hindiCommentary = """
            (मंत्र 13 की पुनरावृत्ति) यह अग्निदेव स्वर्गलोक (द्युलोक) के मस्तक (मूर्धा) हैं और इस संपूर्ण पृथ्वीलोक के सर्वोच्च अधिपति (पति) तथा रक्षक हैं।
            यही अग्निदेव जलों (अंतरिक्ष के बादलों) के वीर्य (जल-कणों) को अत्यंत वेग से पुष्ट और तृप्त करते हैं, जिससे पृथ्वी पर जीवन संभव होता है।
            ऋग्वेद और यजुर्वेद दोनों में पाया जाने वाला यह मंत्र ईश्वर की त्रिलोक-व्यापकता (आकाश, जल और पृथ्वी पर नियंत्रण) का परम उद्घोष है।
            ईश्वर ही वह सर्वोच्च शक्ति (मूर्धा) है जो सूर्य बनकर आकाश को आलोकित करता है और पृथ्वी का स्वामी बनकर उसका निरंतर पोषण करता है।
            अग्नि (ताप) के कारण ही जल वाष्प बनकर ऊपर जाता है और फिर वर्षा के रूप में बरस कर संपूर्ण सृष्टि को नवजीवन और हरियाली प्रदान करता है।
            हे प्रभु! जिस प्रकार अग्नि और जल मिलकर इस संसार की रचना करते हैं, वैसे ही आपका ज्ञान और प्रेम मिलकर हमारे अंतःकरण को अत्यंत सुंदर बना दे।
            हम अपने अहंकार को छोड़ें और यह सत्य स्वीकार करें कि हम जो भी अन्न ग्रहण करते हैं, वह आपकी ही इस अद्भुत ब्रह्मांडीय व्यवस्था का प्रसाद है।
            हमारा जीवन अग्नि की तरह ऊर्ध्वगामी और जल की तरह निर्मल तथा सबको समान रूप से जीवन देने वाला अत्यंत परोपकारी हो।
            प्रकृति के इन तत्वों (अग्नि, जल, पृथ्वी) का सम्मान करना ही ईश्वर की सबसे बड़ी पूजा है, क्योंकि इन्हीं में परमेश्वर का साक्षात् वास है।
            यह मंत्र हमें प्रकृति के साथ गहरा सामंजस्य स्थापित कर एक ऐसा जीवन जीने की प्रेरणा देता है जो विश्व के लिए पूर्णतः मंगलकारी हो।
        """.trimIndent(),
        englishCommentary = """
            (Repetition of Mantra 13) This Lord Agni is the head (Murdha) of the heavenly realm (Dyuloka) and the supreme master (Pati) and protector of this entire earth.
            It is this Agni who intensely nourishes and satisfies the seeds (water drops) of the waters (clouds in space), making life possible on earth.
            Found in both Rigveda and Yajurveda, this mantra is the ultimate declaration of God's omnipresence across the three worlds (control over sky, water, and earth).
            God is that supreme power (Murdha) who illuminates the sky becoming the sun, and continuously nourishes the earth becoming its master.
            Due to Agni (heat), water turns into vapor, goes up, and then rains down to provide new life and lush greenery to the entire creation.
            O Lord! Just as fire and water together create this world, may Your knowledge and love together make our inner conscience extremely beautiful.
            Let us abandon our ego and accept this truth that whatever food we consume is solely the grace of this amazing cosmic arrangement of Yours.
            May our life be upward-moving like fire, pure like water, and highly benevolent, giving life equally to absolutely everyone.
            Respecting these elements of nature (fire, water, earth) is the greatest worship of God, because the Supreme Lord resides directly within them.
            This mantra inspires us to establish deep harmony with nature and live a life that is completely auspicious and beneficial for the world.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 42,
        sanskrit = "सीद होतः स्व उ लोके चिकित्वान् सादया यज्ञं सुकृतस्य योनौ ।\nदेवान् आ विहि अदितिं सजोषाः ॥ ४२ ॥",
        hindiCommentary = """
            हे होता (देवताओं को बुलाने वाले अग्निदेव)! आप सब कुछ जानने वाले (चिकित्वान्) हैं; आप अपने इस स्वयं के उत्तम स्थान (यज्ञवेदी) पर भली-भांति विराजमान हों (सीद)।
            आप हमारे इस श्रेष्ठ यज्ञ को सुकृत (पुण्य और सत्य) के मूल स्थान पर अत्यंत दृढ़ता के साथ स्थापित करें, ताकि यह पूर्ण रूप से सफल हो।
            आप अत्यंत प्रसन्न (सजोषाः) होकर माता अदिति (अखंड प्रकृति) और अन्य सभी देवताओं को हमारी हवि ग्रहण करने के लिए यहाँ ले आएं।
            'चिकित्वान्' का अर्थ है सर्वज्ञ; ईश्वर से हमारा कोई भी विचार छिपा नहीं है, वह हमारे कर्मों और उसके पीछे की भावना को पूरी तरह से जानता है।
            यज्ञ को 'सुकृत की योनि' में स्थापित करने का अर्थ है कि हमारा हर कर्म धर्म, सत्य और पूर्ण ईमानदारी की मजबूत नींव पर ही टिका होना चाहिए।
            अदिति संपूर्ण अखंडता की प्रतीक हैं; यज्ञ का अंतिम लक्ष्य मनुष्य को इस खंडित संसार से निकालकर उस अखंड ईश्वरीय सत्ता में मिला देना है।
            हे परमात्मा! हमारे हृदय रूपी वेदी पर आप हमेशा के लिए विराजमान हो जाएं और हमारे सभी कर्मों को अपने परम ज्ञान से सही दिशा दिखाएं।
            जब ईश्वर हमारे कर्मों से प्रसन्न (सजोषाः) होता है, तभी हमारे जीवन में वास्तविक शांति, समृद्धि और देवत्व का साक्षात् अवतरण होता है।
            हम जो भी शुभ कार्य करें, वह केवल स्वार्थ के लिए न हो, बल्कि उसमें पूरी मानवता के कल्याण और प्रकृति के संरक्षण का महान भाव छिपा हो।
            यह मंत्र हमें अपने जीवन को पुण्यों का एक ऐसा पवित्र केंद्र बनाने की प्रेरणा देता है, जहाँ देवता भी स्वयं आकर निवास करना चाहें।
        """.trimIndent(),
        englishCommentary = """
            O Hota (Agni, the invoker of gods)! You are the knower of all things (Chikitvan); be perfectly seated (Sida) in this excellent place of Your own (the altar).
            Please establish this excellent sacrifice of ours with extreme firmness in the source place of Sukrita (merit and truth), so it succeeds completely.
            Being highly pleased (Sajoshah), please bring Mother Aditi (unbroken nature) and all other gods here to joyfully accept our oblations.
            'Chikitvan' means omniscient; no thought of ours is hidden from God; He completely knows our actions and the actual feelings behind them.
            Establishing the sacrifice in the 'source of Sukrita' means that every action of ours must strictly rest on the strong foundation of Dharma, truth, and honesty.
            Aditi is the symbol of absolute boundlessness; the ultimate goal of sacrifice is to pull a human from this fragmented world and merge them into that unbroken divine reality.
            O Supreme Lord! Reside forever on the altar of our hearts and show the correct direction to all our actions with Your supreme knowledge.
            Only when God is pleased (Sajoshah) with our actions does the direct descent of real peace, prosperity, and divinity occur in our lives.
            Whatever auspicious deed we do, let it not be just for selfishness, but let it hold the great feeling of humanity's welfare and nature's protection.
            This mantra inspires us to make our lives such a holy center of merits that even the gods themselves wish to come and reside there.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 43,
        sanskrit = "उप त्वाग्ने हविष्मतीर्घृताचीर्यन्तु हर्यत ।\nजुषस्व समिधो मम ॥ ४३ ॥",
        hindiCommentary = """
            (मंत्र 4 की पुनरावृत्ति) हे सर्वप्रिय (हर्यत) अग्निदेव! हविष्य (अन्न) और प्रचुर घृत (घी) से युक्त हमारी ये पवित्र आहुतियां तुम्हारे समीप आसानी से पहुँचें।
            तुम हमारी इन अत्यंत श्रद्धापूर्वक अर्पित की गई समिधाओं (लकड़ियों) और निर्मल भावनाओं को अत्यंत प्रसन्नता के साथ स्वीकार करो।
            वेदों में किसी भी मंत्र को बार-बार दोहराने का एक विशेष वैज्ञानिक और मनोवैज्ञानिक कारण होता है; यह मन को संसार से हटाकर एक बिंदु पर लाता है।
            ईश्वर 'हर्यत' है, क्योंकि प्रत्येक जीव, चाहे वह जाने या अनजाने में, केवल उसी असीम सुख और शांति को चाहता है जो ईश्वर का ही स्वरूप है।
            समिधा हमारे पुरुषार्थ का प्रतीक है और घी हमारे निस्वार्थ प्रेम का; इन दोनों के संगम से ही ईश्वर प्रसन्न होता है और हमारी प्रार्थना स्वीकार करता है।
            हे प्रभु! हम संसार की व्यर्थ की भागदौड़ में न उलझें, बल्कि अपने समय और ऊर्जा का श्रेष्ठ अंश (समिधा) प्रतिदिन आपके चरणों में अर्पित करें।
            हम जो भी कमाएं, उसका सबसे पहला और पवित्र हिस्सा आपके और समाज के दीन-दुखियों के कल्याण के निमित्त खुशी-खुशी निकाल दें।
            जैसे अग्नि समिधा को जलाकर उसे अपने ही समान प्रकाशमान बना देती है, वैसे ही आप हमारे तुच्छ अस्तित्व को अपने प्रेम में विलीन कर महान बना दें।
            हमारा अहंकार इस वेदी पर पूरी तरह से भस्म हो जाए और हमारे भीतर केवल उस परम सत्ता के प्रति अखंड समर्पण का ही वास हो।
            यज्ञ का यह पावन कर्म हमें संकुचित स्वार्थ से निकालकर परमार्थ की ओर ले जाए, जहाँ हम संपूर्ण विश्व को एक ही परिवार के रूप में देख सकें।
        """.trimIndent(),
        englishCommentary = """
            (Repetition of Mantra 4) O universally beloved (Haryata) Agni! May these holy oblations of ours, rich in sacrificial food and abundant Ghee, reach near you effortlessly.
            Please accept these firewood sticks (Samidhas) and pure emotions, offered by us with the utmost devotion, with extreme joy and pleasure.
            In the Vedas, repeating any mantra repeatedly has a specific scientific and psychological reason; it pulls the mind from the world to a single point.
            God is 'Haryata', because every living being, knowingly or unknowingly, desires only that boundless joy and peace which is the very form of God.
            Samidha symbolizes our effort and Ghee our selfless love; only through the confluence of these two is God pleased and accepts our prayer.
            O Lord! Let us not get entangled in the vain rat race of the world, but daily offer the best part of our time and energy (Samidha) at Your feet.
            Whatever we earn, let us happily set aside the first and holiest part of it for You and for the welfare of the poor and sorrowful in society.
            Just as fire burns the wood and makes it luminous like itself, please merge our trivial existence into Your love and make it truly great.
            May our ego be completely burnt to ashes on this sacred altar, and may only an unbroken surrender to that Supreme Reality reside within us.
            May this holy act of sacrifice pull us out of narrow selfishness and lead us toward universal welfare, where we view the whole world as one single family.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 44,
        sanskrit = "तवाहमग्ने सुदीतिभिः सुम्नेभिः स्याम शाश्वते ।\nमा त्वा इन्धाना एनसो माघशंसा ओशत ॥ ४४ ॥",
        hindiCommentary = """
            हे अग्निदेव! आपकी अत्यंत शुभ और प्रकाशमयी दीप्तियों (सुदीतिभिः) की कृपा से हम सदा (शाश्वत काल तक) सुख और आनंद (सुम्नेभिः) में निवास करें।
            हे देव! आपको प्रज्वलित करने वाले (आपकी उपासना करने वाले) हम भक्त कभी भी पाप (एनसः) से लिप्त न हों, और न ही कोई पापी (अघशंस) हम पर हावी हो।
            यह मंत्र ईश्वर से भौतिक सुख के साथ-साथ चारित्रिक पवित्रता (पापमुक्ति) का अत्यंत महत्वपूर्ण वरदान मांगता है।
            'शाश्वत सुख' संसार की वस्तुओं में नहीं मिल सकता, वह केवल ईश्वर की 'सुदीति' (ज्ञान के प्रकाश) में ही प्राप्त हो सकता है, जो कभी नष्ट नहीं होता।
            अग्नि को प्रज्वलित करने का अर्थ है अपने अंतःकरण में ईश्वरीय चेतना को जाग्रत करना; जो व्यक्ति ईश्वर से जुड़ जाता है, वह कभी पाप नहीं कर सकता।
            अघशंस वे नकारात्मक शक्तियां और विचार हैं जो हमें गलत मार्ग पर ले जाते हैं; साधक प्रार्थना करता है कि ये शक्तियां कभी उसे परास्त न कर सकें।
            हे प्रभु! हमारे मन को इतना दृढ़ बनाएं कि हम लालच या भय के कारण कभी भी धर्म का मार्ग छोड़कर अधर्म (पाप) की ओर न जाएं।
            आपकी ज्योति हमारे चारों ओर एक ऐसा सुरक्षा चक्र बना दे कि कोई भी बुराई या कुविचार हमारे आभामंडल में प्रवेश करने का साहस ही न कर सके।
            हम केवल अपने लिए सुख न मांगें, बल्कि पूरे समाज के लिए उस शाश्वत शांति की कामना करें जो निस्वार्थ सेवा और भक्ति से ही प्राप्त होती है।
            हमारा जीवन इस प्रज्वलित अग्नि के समान इतना निर्मल और ऊर्जावान हो जाए कि हमारे संपर्क में आने वाला हर व्यक्ति पापमुक्त और आनंदित हो उठे।
        """.trimIndent(),
        englishCommentary = """
            O Agni! By the grace of Your extremely auspicious and luminous brilliance (Suditibhih), may we reside in happiness and bliss (Sumnebhih) forever (eternally).
            O God! May we devotees who kindle You (who worship You) never be tainted by sin (Enasah), and may no sinner (Aghashansa) ever overpower us.
            This mantra asks for an extremely important boon of character purity (freedom from sin) along with material happiness from God.
            'Eternal happiness' cannot be found in worldly objects; it can only be attained in God's 'Suditi' (light of knowledge), which never perishes.
            Kindling Agni means awakening divine consciousness in one's inner self; a person who connects with God can never commit a sin.
            Aghashansa are those negative forces and thoughts that lead us on the wrong path; the seeker prays that these forces can never defeat him.
            O Lord! Make our minds so firm that we never leave the path of Dharma and turn towards unrighteousness (sin) out of greed or fear.
            May Your light create such a protective circle around us that no evil or bad thought even dares to enter our aura.
            Let us not ask for happiness just for ourselves, but wish for that eternal peace for the whole society which is attained only through selfless service.
            May our life become so pure and energetic like this blazing fire that every person who comes in contact with us becomes sinless and joyful.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 45,
        sanskrit = "त्वमग्ने द्युभिस्त्वमाशुशुक्षणिस्त्वमद्भ्यस्त्वमश्मनस्परि ।\nत्वं वनेभ्यस्त्वमोषधीभ्यस्त्वं नृणां नृपते जायसे शुचिः ॥ ४५ ॥",
        hindiCommentary = """
            (सर्वव्यापकता मंत्र की पुनरावृत्ति) हे अग्निदेव! आप आकाश में सूर्य के तेज के रूप में उत्पन्न होते हैं; आप ही शीघ्रता से प्रज्वलित होने वाले हैं।
            आप जलों (बादलों) से उत्पन्न होते हैं, और आप ही पत्थरों के घर्षण से उत्पन्न होते हैं।
            आप ही वनों (लकड़ियों) से और आप ही औषधियों से प्रकट होते हैं; हे नृपति (मनुष्यों के स्वामी)! आप अत्यंत शुद्ध रूप में उत्पन्न होते हैं।
            चातुर्मास्य यज्ञ के इस विशेष चरण में इस मंत्र का दोबारा उच्चारण इस बात को दृढ़ करता है कि प्रकृति के हर रूप में वही एक परमात्मा समाया हुआ है।
            ईश्वर केवल एक विशेष आकार या स्थान तक सीमित नहीं है; वह आकाश से लेकर पाताल तक, और जल से लेकर पत्थर तक हर कण में साक्षात् विद्यमान है।
            यह सर्वव्यापकता का ज्ञान मनुष्य के अहंकार को तोड़ता है, क्योंकि जब हर जगह ईश्वर है, तो हम स्वयं को किससे बड़ा मान सकते हैं?
            अग्नि का 'शुचि' (पवित्र) होना यह दर्शाता है कि भौतिक संसार और इसके प्रपंचों में रहते हुए भी ईश्वर माया और पाप से सर्वथा मुक्त और अछूता है।
            हे परमात्मा! जिस प्रकार आप पत्थर जैसे कठोर पदार्थ से भी प्रकाश के रूप में प्रकट हो जाते हैं, वैसे ही अज्ञानी और कठोर हृदयों में भी ज्ञान का प्रकाश जगाएं।
            प्रकृति के कण-कण का सम्मान करना ही ईश्वर की सच्ची और सबसे बड़ी पूजा है; क्योंकि प्रकृति के हर रूप में वही एक परम सत्ता सांस ले रही है।
            हमारा मन इस परम सत्य को सदा याद रखे कि हमारे भीतर धड़कता हुआ प्राण भी उसी असीम, विराट और पवित्र ईश्वरीय अग्नि का ही एक छोटा सा अंश है।
        """.trimIndent(),
        englishCommentary = """
            (Repetition of omnipresence mantra) O Agni! You are born in the sky as the brilliance of the sun; You are the one quickly kindled.
            You are born from the waters (clouds), and You alone are generated from the friction of stones.
            You manifest from the forests (firewood) and from the herbs; O Nripati (Lord of humans)! You are born in an extremely pure (Shuchi) form.
            The re-chanting of this mantra in this specific phase of Chaturmasya sacrifice firmly establishes that the same one Supreme Lord is imbued in every form of nature.
            God is not limited to a specific shape or place; He is directly present in every particle, from the sky to the underworld, and from water to stone.
            This knowledge of omnipresence breaks human ego, because when God is everywhere, who can we possibly consider ourselves superior to?
            Agni being 'Shuchi' (pure) shows that despite existing in the material world and its illusions, God is completely free and untouched by illusion and sin.
            O Supreme Lord! Just as You manifest as light even from a hard substance like stone, please awaken the light of knowledge in ignorant and hard hearts too.
            Respecting every particle of nature is the true and greatest worship of God; because in every form of nature, that same one Supreme Reality is breathing.
            May our mind always remember this ultimate truth that the life-breath beating within us is also a small part of that infinite, vast, and holy divine fire.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 46,
        sanskrit = "त्वमग्ने सुभृत उत्तमं वयस्तव स्पार्हे वर्ण आ सन्दृशि श्रियः ।\nत्वं वाजः प्रतरणो बृहन्नसि त्वं रयिर्बहुलो विश्वतस्पृथुः ॥ ४६ ॥",
        hindiCommentary = """
            (सौंदर्य और ऐश्वर्य मंत्र की पुनरावृत्ति) हे अग्निदेव! जब आप उत्तम रूप से पुष्ट (प्रज्वलित) होते हैं, तो आप उत्कृष्ट अन्न (आयु और ऊर्जा) प्रदान करने वाले होते हैं।
            आपके अत्यंत स्पृहणीय (आकर्षक) रूप और दर्शन में महान शोभा (श्री) और ऐश्वर्य का निरंतर वास है।
            आप ही वह महान बल (वाज) हैं जो हमें संसार के सभी दुखों और बाधाओं से पार (प्रतरण) ले जाते हैं।
            आप ही वह अत्यंत विशाल (बृहन्) और सब ओर फैला हुआ (विश्वतस्पृथुः) महान धन (रयि) हैं, जो हमें पूर्णतः समृद्ध बनाता है।
            जब हम ईश्वर (अग्नि) का 'सुभृत' (अच्छी तरह ध्यान और सत्कार) करते हैं, तो वह हमारी आध्यात्मिक और भौतिक दोनों ऊर्जाओं को अत्यंत बढ़ा देता है।
            ईश्वरीय प्रकाश का दर्शन ही सबसे सच्चा 'सौंदर्य' है; दुनिया की सारी भौतिक सुंदरता उसी परम सत्ता की एक छोटी सी और क्षणिक झलक मात्र है।
            'प्रतरण' का अर्थ है तारने वाला; ईश्वर का बल ही वह एकमात्र नाव है जो हमें इस संसार रूपी दुखों के भवसागर से सुरक्षित पार निकाल सकती है।
            सच्चा धन (रयि) केवल सोना-चांदी नहीं, बल्कि वह सर्वव्यापी ज्ञान और आत्मबल है जो कभी कम नहीं होता और हमारे चरित्र को महान बनाता है।
            हे प्रभु! हमें वह दिव्य धन और शांति प्रदान करें जिससे हमारा जीवन शोभायमान हो, हम बाधाओं को आसानी से पार करें और समाज के लिए एक महान रक्षक बन सकें।
            हम अपने जीवन को ईश्वर की स्तुति में ऐसा लीन कर दें कि हमारा अंतःकरण भी उसी अग्नि के समान शुद्ध, आकर्षक और सभी के लिए अत्यंत कल्याणकारी हो जाए।
        """.trimIndent(),
        englishCommentary = """
            (Repetition of beauty and wealth mantra) O Agni! When You are excellently nourished (kindled), You become the bestower of supreme food (life-span and energy).
            In Your highly desirable (attractive) form and vision, great splendor (Shri) and prosperity continuously reside.
            You are that great strength (Vaja) which carries us across (Pratarana) all the sorrows and obstacles of the world.
            You are that extremely vast (Brihan) and all-pervading (Vishvatasprithuh) great wealth (Rayi), which makes us completely prosperous.
            When we 'excellently nourish' (Subhrita - meditate and host well) God (Agni), He immensely increases both our spiritual and physical energies.
            The vision of divine light is the truest 'beauty'; all the material beauty of the world is merely a small and fleeting glimpse of that Supreme Reality.
            'Pratarana' means the savior; God's strength is the only boat that can safely carry us across this ocean of worldly sorrows.
            True wealth (Rayi) is not just gold or silver, but that omnipresent knowledge and inner strength which never diminishes and makes our character great.
            O Lord! Grant us that divine wealth and peace which adorns our lives, helps us easily cross obstacles, and enables us to become a great protector for society.
            Let us engross our lives so deeply in God's praise that our inner conscience also becomes pure, attractive, and extremely beneficial for all, just like that fire.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 47,
        sanskrit = "अग्निहोत्रं सायं जुहोति ।\nसूर्यं ज्योतिर्ज्योतिः सूर्यः स्वाहा ॥ ४७ ॥",
        hindiCommentary = """
            साधक को सायं काल (संध्या के समय) अग्निहोत्र (दैनिक हवन) का अनुष्ठान अत्यंत श्रद्धापूर्वक करना चाहिए।
            (आहुति मंत्र) सूर्य ही ज्योति है और ज्योति ही सूर्य है; इस परम ज्योति की प्रसन्नता के लिए यह पवित्र आहुति (स्वाहा) पूर्णतः समर्पित है।
            अग्निहोत्र वैदिक जीवनचर्या का सबसे महत्वपूर्ण और अनिवार्य हिस्सा है; यह दिन भर किए गए कर्मों की शुद्धि और प्रकृति के प्रति कृतज्ञता ज्ञापन है।
            सायं काल का समय दिन और रात का संधिकाल होता है; इस समय मन अत्यंत शांत होता है, जो ध्यान और ईश्वर से जुड़ने के लिए सबसे उत्तम है।
            यहाँ 'सूर्य' को अग्नि के रूप में ही पूजा जाता है, क्योंकि सूर्य के छिपने के बाद पृथ्वी पर प्रकाश और ऊष्मा का एकमात्र स्रोत अग्नि ही रह जाती है।
            'स्वाहा' का अर्थ है अपने 'स्व' (अहंकार) का पूर्णतः त्याग कर देना; जब हम आहुति देते हैं, तो हम यह भाव रखते हैं कि "यह मेरा नहीं है, सब ईश्वर का है"।
            हे परमात्मा! दिन भर के कार्यों में जो भी त्रुटियां या पाप मुझसे हुए हों, उन्हें इस सायं कालीन पवित्र अग्नि में भस्म कर मुझे पूरी तरह निर्मल कर दें।
            जैसे सूर्य की ज्योति सारे संसार का अंधकार मिटाती है, वैसे ही आपका यह ईश्वरीय ज्ञान मेरे मन के समस्त संशयों और अज्ञान को सदा के लिए मिटा दे।
            हमारा यह दैनिक नियम हमें जीवन में ऐसा अनुशासन दे कि हम कभी भी ईश्वर के स्मरण और परोपकार के मार्ग से विचलित न हों।
            हमारा हृदय ऐसा निर्मल हो जाए कि बाहरी सूर्य के ढलने पर भी हमारे भीतर बैठे ज्ञान और भक्ति के सूर्य का प्रकाश कभी भी कम न हो।
        """.trimIndent(),
        englishCommentary = """
            The seeker must perform the Agnihotra (daily fire ritual) with utmost devotion during the evening (twilight) time.
            (Oblation mantra) The Sun is light and light is the Sun; for the pleasure of this Supreme Light, this holy oblation (Svaha) is completely dedicated.
            Agnihotra is the most important and compulsory part of the Vedic lifestyle; it is the purification of deeds done all day and an expression of gratitude to nature.
            The evening time is the junction of day and night; at this time, the mind is extremely peaceful, which is best for meditation and connecting with God.
            Here 'Sun' is worshipped in the form of Agni, because after sunset, fire remains the only source of light and heat on earth.
            'Svaha' means the complete abandonment of one's 'Sva' (ego); when we offer an oblation, we hold the feeling that "This is not mine, everything is God's".
            O Supreme Lord! Whatever errors or sins I have committed in the day's tasks, burn them to ashes in this holy evening fire and make me completely pure.
            Just as the sun's light erases the darkness of the whole world, may this divine knowledge of Yours erase all doubts and ignorance of my mind forever.
            May this daily rule of ours give us such discipline in life that we never deviate from the path of remembering God and benevolence.
            May our heart become so pure that even when the external sun sets, the light of the sun of knowledge and devotion sitting inside us never diminishes.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 48,
        sanskrit = "अग्निहोत्रं प्रातर्जुहोति ।\nअग्निर्ज्योतिर्ज्योतिरग्निः स्वाहा ॥ ४८ ॥",
        hindiCommentary = """
            साधक को प्रातः काल (सुबह के समय) भी अग्निहोत्र (दैनिक हवन) का अनुष्ठान अत्यंत श्रद्धापूर्वक और नियम से करना चाहिए।
            (आहुति मंत्र) अग्नि ही ज्योति है और ज्योति ही साक्षात् अग्नि है; इस परम ज्योति की प्रसन्नता के लिए यह पावन आहुति (स्वाहा) पूर्णतः समर्पित है।
            सायं काल की तरह प्रातः काल का अग्निहोत्र भी नए दिन की शुरुआत को मंगलमय, ऊर्जावान और ईश्वरीय आशीर्वाद से युक्त बनाने के लिए किया जाता है।
            सुबह की पहली किरण के साथ अग्नि प्रज्वलित करने का अर्थ है कि हम अपने दिन की शुरुआत भौतिक कार्यों से नहीं, बल्कि ईश्वर के ध्यान से कर रहे हैं।
            'अग्नि ही ज्योति है'—यहाँ अग्नि ज्ञान, शक्ति और पवित्रता का प्रतीक है; हम प्रार्थना करते हैं कि हमारा पूरा दिन इसी ज्ञान और पवित्रता से भरा रहे।
            स्वाहा के द्वारा हम रात की आलस्य, तंद्रा और सभी बुरे स्वप्नों को अग्नि में भस्म कर एक नई और शुद्ध चेतना के साथ जागते हैं।
            हे प्रभु! जैसे यह अग्नि ऊपर की ओर उठती है, वैसे ही आज मेरे सभी विचार, संकल्प और कार्य केवल ऊर्ध्वगामी (सकारात्मक) ही हों, कभी पतन की ओर न जाएं।
            हम जो भी कर्म आज पूरे दिन में करें, वह केवल आपके लिए हो और उससे समाज के किसी भी प्राणी को कभी कोई दुख या कष्ट न पहुँचे।
            यह प्रात:कालीन यज्ञ हमारे घर के वातावरण को ऐसा शुद्ध और पवित्र कर दे कि हर श्वास के साथ हमारे भीतर केवल आरोग्य और शांति का ही संचार हो।
            हमारा जीवन इस अग्नि की तरह जाग्रत रहे, जो स्वयं जलकर भी अंधकार को नष्ट करती है और दूसरों को केवल प्रकाश और सही मार्ग ही दिखाती है।
        """.trimIndent(),
        englishCommentary = """
            The seeker must perform the Agnihotra (daily fire ritual) with utmost devotion and regularity during the morning time as well.
            (Oblation mantra) Agni is light and light is directly Agni; for the pleasure of this Supreme Light, this holy oblation (Svaha) is completely dedicated.
            Like the evening, the morning Agnihotra is also performed to make the beginning of the new day auspicious, energetic, and filled with divine blessings.
            Igniting the fire with the first ray of morning means that we are starting our day not with material tasks, but with the profound meditation of God.
            'Agni is light'—here Agni symbolizes knowledge, power, and purity; we pray that our entire day remains filled with this exact knowledge and purity.
            Through Svaha, we burn away the laziness, drowsiness, and all bad dreams of the night in the fire and wake up with a completely new and pure consciousness.
            O Lord! Just as this fire rises upwards, may all my thoughts, resolutions, and actions today be only upward-moving (positive), and never go towards downfall.
            Whatever deed we perform throughout the day today, let it be solely for You and let it never cause any sorrow or pain to any living being in society.
            May this morning sacrifice purify and sanctify our home's environment so much that with every breath, only health and supreme peace circulate within us.
            May our life remain awake like this fire, which despite burning itself destroys darkness and shows only light and the correct path to absolutely everyone.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 49,
        sanskrit = "उपप्रयन्तो अध्वरं मन्त्रं वोचेमाग्नये ।\nआरे अस्मे च शृण्वते ॥ ४९ ॥",
        hindiCommentary = """
            (यज्ञ के महत्व को दृढ़ करने हेतु पुनः आवृत्ति) हम इस हिंसारहित (अध्वर) यज्ञ की ओर निरंतर आगे बढ़ते हुए अग्निदेव के लिए अत्यंत पवित्र मंत्रों का उच्चारण करें।
            वे अग्निदेव जो दूर (आरे) और समीप (अस्मे) सर्वत्र स्थित होकर हमारी प्रार्थनाओं को अत्यंत स्पष्ट और ध्यानपूर्वक सुनते हैं।
            बार-बार 'अध्वर' (हिंसारहित) शब्द का आना इस बात का सबसे बड़ा प्रमाण है कि वेदों में यज्ञ का अर्थ पशुबलि या क्रूरता बिल्कुल भी नहीं है।
            यज्ञ वास्तव में निस्वार्थ त्याग, पर्यावरण की शुद्धि और समाज के कल्याण के लिए किया जाने वाला एक अत्यंत पवित्र और वैज्ञानिक अनुष्ठान है।
            ईश्वर हमारी हर प्रार्थना सुनता है, चाहे हम मंदिर में हों या एकांत में; इसलिए हमारी नीयत और भाव में पूरी तरह से सत्यता और निर्मलता होनी चाहिए।
            मंत्र केवल कर्मकांड के शब्द नहीं हैं; ये वे ध्वनियां हैं जो हमारे मन की आवृत्तियों (Frequency) को ब्रह्मांड की चेतना के साथ पूरी तरह जोड़ देती हैं।
            हे परमात्मा! हमारे कदम कभी भी अधर्म की ओर न बढ़ें; हम जीवन भर केवल श्रेष्ठ और परोपकारी कार्यों (अध्वर) की ओर ही निरंतर गमन करते रहें।
            हमारा मन इतना शांत और एकाग्र हो जाए कि हम अपने भीतर ही उस ईश्वर की पावन ध्वनि (अंतर्नाद) को स्पष्ट रूप से सुन सकें।
            हम जो कुछ भी ईश्वर को अर्पित करें, वह शुद्ध हो और उसमें 'मैं' या 'मेरा' का तनिक भी अहंकार शेष न हो; क्योंकि अहंकार ही सबसे बड़ी अशुद्धि है।
            यह वैदिक मंत्र हमें सत्य, अहिंसा और ईश्वरीय प्रेम के मार्ग पर अडिग रहने की अत्यंत महान और सुंदर प्रेरणा देता है।
        """.trimIndent(),
        englishCommentary = """
            (Repetition to affirm the importance of sacrifice) Continuously advancing toward this non-violent (Adhvara) sacrifice, let us chant extremely holy mantras for Lord Agni.
            That Agni who, being situated everywhere both far (Aare) and near (Asme), clearly and attentively hears all our prayers.
            The repeated occurrence of the word 'Adhvara' (non-violent) is the greatest proof that in the Vedas, sacrifice absolutely does not mean animal slaughter or cruelty.
            Yajna (sacrifice) is actually an extremely holy and scientific ritual performed for selfless surrender, environmental purification, and the welfare of society.
            God hears our every prayer, whether we are in a temple or in solitude; therefore, our intentions and feelings must have absolute truth and purity.
            Mantras are not just ritualistic words; they are those sounds that completely connect the frequencies of our mind with the vast consciousness of the universe.
            O Supreme Lord! May our steps never move towards unrighteousness; may we continuously walk only towards noble and benevolent deeds (Adhvara) lifelong.
            May our mind become so peaceful and concentrated that we can clearly hear the holy sound of that God (Antarnada) right within ourselves.
            Whatever we offer to God, let it be pure and let there not be the slightest ego of 'I' or 'Mine' left in it; because ego is the biggest impurity.
            This Vedic mantra gives us the extremely great and beautiful inspiration to remain unshakable on the path of truth, non-violence, and pure divine love.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 50,
        sanskrit = "अस्य प्रत्नामनु द्युतं शुक्रं दुदुह्रे अह्रयः ।\nपयः सहस्रसामृषिम् ॥ ५० ॥",
        hindiCommentary = """
            (सत्य की शाश्वतता का स्मरण) इस अग्नि की उस सनातन (प्रत्न) और अत्यंत प्रकाशमयी दीप्ति (द्युत) का अनुसरण करते हुए, लज्जारहित (निर्भीक) साधकों ने...
            हजारों प्रकार के ऐश्वर्यों को देने वाले (सहस्रसाम्) और सर्वद्रष्टा (ऋषिम्) अग्निदेव से अत्यंत शुद्ध (शुक्र) रस (पयः) का दोहन किया है।
            वेद यह स्पष्ट करते हैं कि जो ज्ञान प्राचीन काल में ऋषियों को प्राप्त था, वही ईश्वरीय ज्ञान आज भी हर उस साधक के लिए उपलब्ध है जो सत्यनिष्ठ है।
            ईश्वर की दीप्ति (प्रकाश) 'सनातन' है; दुनिया की सभ्यताएं और भौतिक वस्तुएं नष्ट हो सकती हैं, परंतु ईश्वर का सत्य कभी भी नहीं बदलता।
            अह्रयः (निर्भीक) होने का अर्थ है समाज के तानों या सांसारिक माया के भय से मुक्त होकर केवल सत्य और धर्म के मार्ग पर पूरी दृढ़ता से चलना।
            अग्नि से 'शुद्ध रस' का दोहन करना कोई भौतिक क्रिया नहीं है; यह अपनी आत्मा को परमात्मा के आनंद (ब्रह्मानंद) से पूरी तरह भर लेना है।
            हे प्रभु! हमें भी ऐसा ही निर्भीक साधक बनाएं कि हम बिना किसी भय के आपकी भक्ति करें और आपके उस अनंत ज्ञान-रस को प्राप्त कर सकें।
            ईश्वर 'सहस्रसाम्' है; उसके पास ऐश्वर्य की कोई कमी नहीं है, परंतु वह अपनी कृपा केवल उसी पर बरसाता है जिसका अंतःकरण पूरी तरह शुद्ध हो।
            हम भौतिक वस्तुओं के पीछे न भागें, बल्कि उस सर्वद्रष्टा (ऋषि) ईश्वर की शरण लें जो हमारे जीवन की सभी वास्तविक आवश्यकताओं को पूरा करता है।
            हमारा यह यज्ञ हमारे जीवन में एक ऐसी अमूल्य आध्यात्मिक संपत्ति भर दे जो हमें इस जन्म में और मृत्यु के पश्चात भी परम शांति और आनंद प्रदान करे।
        """.trimIndent(),
        englishCommentary = """
            (Remembrance of Truth's eternity) Following the eternal (Pratna) and extremely luminous brilliance (Dyut) of this Agni, the fearless (shameless) seekers have...
            Milked the extremely pure (Shukra) essence (Payah) from Agni, who grants thousands of bounties (Sahasrasam) and is the all-seeing seer (Rishim).
            The Vedas clarify that the knowledge attained by the sages in ancient times is still available today to every seeker who is truly dedicated to Truth.
            God's brilliance (light) is 'eternal'; world civilizations and material objects may perish, but the truth of God absolutely never changes.
            Being Ahrayah (fearless) means being free from the fear of society's taunts or worldly illusions, and walking the path of truth and Dharma with full firmness.
            Milking the 'pure essence' from Agni is not a physical act; it is completely filling one's own soul with the supreme bliss of God (Brahmananda).
            O Lord! Make us also such fearless seekers that we worship You without any fear and can attain that infinite essence of Your profound knowledge.
            God is 'Sahasrasam'; there is no shortage of wealth with Him, but He showers His grace only on the one whose inner conscience is completely pure.
            Let us not run after material objects, but take refuge in that all-seeing (Rishi) God who fulfills all the real and genuine necessities of our lives.
            May this sacrifice fill our lives with such an invaluable spiritual wealth that it grants us supreme peace and joy in this birth and even after death.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 51,
        sanskrit = "अक्षन्नमीमदन्त ह्यव प्रिया ऽ अधूषत ।\nअस्तोषत स्वभानवो विप्रा नविष्ठया मती योजा न्विन्द्र ते हरी ॥ ५१ ॥",
        hindiCommentary = """
            हमारे पितरों (पूर्वजों) ने यज्ञ में अर्पित हविष्य को भली-भांति खा लिया है (अक्षन्) और वे अत्यंत तृप्त व आनंदित (अमीमदन्त) हुए हैं।
            उन्होंने अपने प्रिय अन्नों को ग्रहण कर लिया है; अब स्वयं प्रकाशमान (स्वभानवः) और ज्ञानी विप्रों (ऋत्विजों) ने अपनी नवीन स्तुतियों (नविष्ठया मती) से ईश्वर का गान किया है।
            हे देवराज इंद्र! अब आप हमारे इस यज्ञ में पधारने के लिए अपने 'हरी' नामक दिव्य अश्वों (घोड़ों) को अपने रथ में जोतिए (योजा)।
            यह मंत्र पितृयज्ञ और देवयज्ञ के अद्भुत मिलन को दर्शाता है; जब हमारे पूर्वज तृप्त होते हैं, तभी देवताओं का वास्तविक आशीर्वाद हमें प्राप्त होता है।
            पितरों की तृप्ति का अर्थ है कि हमने अपने कुल, परंपरा और वृद्धों के प्रति अपने सभी नैतिक कर्तव्यों का सही ढंग से पालन किया है।
            विप्रों द्वारा 'नवीन स्तुति' गाने का अर्थ है कि धर्म कभी बासी नहीं होता; साधक का अनुभव हर दिन एक नया और ताज़ा आध्यात्मिक उल्लास लेकर आता है।
            इंद्र के अश्वों को जोतने का आह्वान वास्तव में हमारी अपनी इंद्रियों और ऊर्जा को श्रेष्ठ कार्यों (यज्ञ) की ओर मोड़ने का आध्यात्मिक संदेश है।
            हे परमात्मा! हमारे घर में हमेशा ऐसा सुसंस्कार रहे कि हमारे पितर शांत रहें और हमारे युवा अत्यंत ऊर्जावान तथा धर्मपरायण बनें।
            हम जो भी शुभ कार्य करें, उसमें हमें देवों का प्रत्यक्ष सहयोग मिले और हमारे जीवन का रथ कभी भी सन्मार्ग से न भटके।
            हमारा जीवन एक ऐसा उत्सव बन जाए जहाँ हम अतीत (पितरों) का सम्मान करें और भविष्य (नवीन स्तुति) का अत्यंत आनंद के साथ स्वागत करें।
        """.trimIndent(),
        englishCommentary = """
            Our ancestors (Pitris) have eaten (Akshan) the offered oblations and have become completely satisfied and rejoiced (Amimadanta).
            They have accepted their dear food; now the self-luminous (Svabhanavah) and wise priests (Vipras) have praised God with their newest hymns (Navishthaya mati).
            O Lord Indra! Now, to arrive at this sacrifice of ours, please yoke (Yoja) your divine horses named 'Hari' to your chariot.
            This mantra shows the amazing union of Pitriyajna (ancestor worship) and Devayajna (god worship); only when ancestors are satisfied do we get true divine blessings.
            The satisfaction of ancestors means that we have correctly fulfilled all our moral duties towards our lineage, tradition, and elders.
            The singing of 'newest hymns' by priests means Dharma never gets stale; the seeker's experience brings a fresh and new spiritual joy every single day.
            The invocation to yoke Indra's horses is actually a spiritual message to channel our own senses and energy towards excellent noble deeds.
            O Supreme Lord! May there always be such good values in our home that our ancestors remain at peace and our youth become highly energetic and righteous.
            Whatever auspicious deed we do, may we get the direct cooperation of the gods, and may the chariot of our life never wander from the right path.
            May our life become such a celebration where we respect the past (ancestors) and welcome the future (new hymns) with immense and profound joy.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 52,
        sanskrit = "त्वा वयं मघवन्वन्दिषीमहि ।\nप्र नूनं पूर्णवन्धुरः स्तुतो यासि वशाँ२ अनु योजा न्विन्द्र ते हरी ॥ ५२ ॥",
        hindiCommentary = """
            हे महान ऐश्वर्यशाली (मघवन्) इंद्रदेव! हम आपकी अत्यंत श्रद्धा और प्रेम के साथ वंदना (स्तुति) करते हैं।
            हमारे द्वारा स्तुति किए जाने पर, आप अपने पूर्ण रूप से भरे हुए (पूर्णवन्धुरः) रथ पर सवार होकर, अपनी इच्छा (वशान्) के अनुसार सर्वत्र गमन करें।
            हे इंद्र! आप हमारे इस यज्ञ में शीघ्र पधारने के लिए अपने 'हरी' नामक अश्वों को तुरंत अपने रथ में जोतिए।
            इंद्र केवल वर्षा या स्वर्ग के देव नहीं हैं, बल्कि वे हमारे भीतर की 'इंद्रिय-शक्ति' और 'आत्मबल' के साक्षात् प्रतीक हैं।
            'पूर्णवन्धुरः' (भरे हुए रथ) का अर्थ है कि ईश्वर का रथ हमेशा ऐश्वर्य, ज्ञान और कृपा से भरा होता है, उसमें कभी कोई कमी नहीं होती।
            जब साधक निष्काम भाव से ईश्वर की वंदना करता है, तो ईश्वर अपनी इच्छा (वशान्) से साधक के जीवन में प्रवेश कर उसे कृतार्थ कर देता है।
            हे प्रभु! हमारी स्तुति इतनी सच्ची और निर्मल हो कि आप हमारी पुकार सुनकर स्वयं हमारे अंतःकरण में विराजमान होने के लिए दौड़े चले आएं।
            हम अपनी सभी शक्तियों (इंद्रियों) को आपके नियंत्रण में सौंपते हैं; आप उन्हें अपने श्रेष्ठ कार्यों के लिए जहाँ चाहें, वहाँ जोत लें।
            जब ईश्वर का रथ जीवन में आता है, तो वह अपने साथ असीम समृद्धि, शांति और अजेय साहस लेकर आता है जिससे सभी दुख नष्ट हो जाते हैं।
            हमारा यह जीवनरूपी रथ भी हमेशा धर्म और न्याय के सद्गुणों से भरा रहे और हम आपकी इच्छा के अनुसार ही अपना संपूर्ण जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O immensely prosperous (Maghavan) Lord Indra! We worship and praise You with the utmost devotion and pure love.
            Being praised by us, riding on Your completely filled (Purnavandhurah) chariot, may You travel everywhere according to Your own free will (Vashan).
            O Indra! To arrive quickly at this sacrifice of ours, immediately yoke Your horses named 'Hari' to Your divine chariot.
            Indra is not just the god of rain or heaven, but the direct symbol of our inner 'sensory power' and profound 'soul-strength'.
            'Purnavandhurah' (filled chariot) means that God's chariot is always full of wealth, knowledge, and grace; it never lacks anything at all.
            When a seeker praises God selflessly, God enters the seeker's life by His own will (Vashan) and makes them completely fulfilled.
            O Lord! May our praise be so true and pure that hearing our call, You Yourself come running to reside in our inner conscience.
            We surrender all our powers (senses) to Your absolute control; please yoke them wherever You wish for Your own excellent, noble works.
            When God's chariot arrives in life, it brings boundless prosperity, peace, and invincible courage with it, destroying all sorrows forever.
            May this chariot of our life also always remain full of the virtues of Dharma and justice, and may we spend our entire life strictly according to Your will.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 53,
        sanskrit = "मनो न्वाह्वामहे नाराशंसेन स्तोमेन ।\nपितृणां च मन्मभिः ॥ ५३ ॥",
        hindiCommentary = """
            हम 'नाराशंस' (मनुष्यों द्वारा की जाने वाली श्रेष्ठ और पावन) स्तुतियों (स्तोमेन) के माध्यम से अपने 'मन' का पुनः आह्वान करते हैं।
            और हम अपने पवित्र पितरों (पूर्वजों) के ध्यान (मन्मभिः) और उनके शुभ कर्मों के स्मरण से अपने उस मन को पुनः जाग्रत और स्थिर करते हैं।
            यह मंत्र मानसिक एकाग्रता और चंचल मन को वश में करने का एक अत्यंत अद्भुत और प्राचीन मनोवैज्ञानिक (Psychological) सूत्र है।
            संसार के विभिन्न कार्यों और चिंताओं में उलझकर हमारा मन अक्सर भटक जाता है और अपनी आध्यात्मिक दिशा पूरी तरह भूल जाता है।
            मन को वापस बुलाने का सबसे अच्छा उपाय है—'नाराशंस स्तोम' (ईश्वर और महान पुरुषों की स्तुति) करना; अच्छे विचार ही मन को स्थिर करते हैं।
            पितरों के 'मन्म' (ध्यान) का अर्थ है अपने पूर्वजों के उन महान आदर्शों और संघर्षों को याद करना जिन्होंने हमें यह जीवन और धर्म सौंपा है।
            हे परमात्मा! हमारा चंचल मन जो अज्ञान के कारण विषयों की ओर भागता है, उसे अपनी स्तुति के पावन पाश से बांधकर पुनः अंतर्मुखी कर दें।
            जब हम अपने पूर्वजों की श्रेष्ठता को याद करते हैं, तो हमें भी कोई भी नीच या गलत कार्य करने में स्वाभाविक रूप से लज्जा और संकोच होता है।
            हमारा मन एक ऐसा शक्तिशाली साधन है जो अगर भटक जाए तो विनाश करता है, लेकिन अगर स्थिर हो जाए तो साक्षात् ईश्वर से मिला देता है।
            हम प्रार्थना करते हैं कि हमारा मन हमेशा हमारे नियंत्रण में रहे और वह केवल सत्य, शांति और विश्व-कल्याण के श्रेष्ठ विचारों में ही लगा रहे।
        """.trimIndent(),
        englishCommentary = """
            We call back our 'Mind' once again through the 'Narashamsa' (excellent and holy praises performed by men) stomas (hymns).
            And we completely reawaken and stabilize that mind of ours through the meditation (Manmabhih) and remembrance of the noble deeds of our holy ancestors (Pitris).
            This mantra is an extremely wonderful and ancient psychological formula for mental concentration and controlling a highly restless mind.
            Tangled in the various tasks and worries of the world, our mind often wanders off and completely forgets its true spiritual direction.
            The best way to call the mind back is doing 'Narashamsa Stoma' (praising God and great men); only good thoughts stabilize the mind.
            The 'Manma' (meditation) of the ancestors means remembering those great ideals and struggles of our forefathers who handed us this life and Dharma.
            O Supreme Lord! Our restless mind which runs towards worldly objects due to ignorance, tie it with the holy noose of Your praise and make it introverted again.
            When we remember the greatness of our ancestors, we naturally feel shame and hesitation in performing any low or completely wrong deed.
            Our mind is such a powerful tool that if it wanders it causes destruction, but if it becomes stable, it unites us directly with God.
            We pray that our mind always remains under our strict control and stays engaged solely in the excellent thoughts of truth, peace, and global welfare.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 54,
        sanskrit = "आ न ऽएतु मनः पुनः क्रत्वे दक्षाय जीवसे ।\nज्योक् च सूर्यं दृशे ॥ ५४ ॥",
        hindiCommentary = """
            हमारा वह भटका हुआ मन पुनः हमारे पास लौट आए, ताकि हम श्रेष्ठ कर्म (क्रतु) कर सकें और अत्यंत कुशल (दक्ष) बन सकें।
            वह मन हमें एक स्वस्थ और पूर्ण जीवन (जीवसे) जीने के लिए प्राप्त हो, और हम दीर्घकाल (ज्योक्) तक इस प्रकाशमान सूर्य को देखते रहें।
            इस मंत्र में मन की पूर्ण जाग्रति और जीवन की सफलता के बीच का गहरा वैज्ञानिक संबंध अत्यंत स्पष्ट रूप से समझाया गया है।
            बिना एकाग्र मन के मनुष्य कोई भी श्रेष्ठ कर्म (क्रतु) नहीं कर सकता; एक अस्थिर मन वाला व्यक्ति हमेशा अपनी कार्यकुशलता (दक्षता) खो देता है।
            मनुष्य वास्तव में तभी 'जीवित' (जीवसे) है जब उसका मन उसके वश में हो; मन के गुलाम व्यक्ति का जीवन एक मृत समान ही होता है।
            'सूर्य को दीर्घकाल तक देखना' केवल लंबी उम्र की कामना नहीं है, बल्कि यह प्रार्थना है कि हम ज्ञान और सत्य के प्रकाश में ही अपना पूरा जीवन जिएं।
            हे प्रभु! आप हमारे मन को ऐसा वशीभूत और शांत कर दें कि वह कभी भी किसी गलत दिशा या कुविचार की ओर आकर्षित न हो।
            जब मन लौट आता है (अर्थात् स्थिर हो जाता है), तो हमारे शरीर की सारी ऊर्जा लौट आती है और हम बड़े से बड़ा लक्ष्य आसानी से प्राप्त कर लेते हैं।
            हम अपने प्रत्येक कार्य में ऐसी निपुणता (दक्षता) प्राप्त करें जो समाज के लिए कल्याणकारी हो और ईश्वर को अत्यंत प्रिय हो।
            हमारा जीवन इस उदित होते सूर्य के समान अत्यंत उज्ज्वल, सक्रिय और ऊर्जावान बना रहे, यही इस वैदिक प्रार्थना का परम संदेश है।
        """.trimIndent(),
        englishCommentary = """
            May our wandering mind return to us once again, so that we can perform excellent deeds (Kratu) and become highly skilled (Daksha).
            May that mind be attained by us to live a healthy and complete life (Jivase), and may we continue to see this luminous sun for a long time (Jyok).
            In this mantra, the deep scientific relationship between the complete awakening of the mind and success in life is explained very clearly.
            Without a concentrated mind, a human cannot perform any noble deed (Kratu); a person with an unstable mind always loses their efficiency (Dakshata).
            A human is truly 'alive' (Jivase) only when their mind is under their control; the life of a person enslaved by the mind is exactly like the dead.
            'Seeing the sun for a long time' is not just a wish for longevity, but a prayer that we live our entire life strictly in the light of knowledge and truth.
            O Lord! Subdue and calm our mind in such a way that it is never attracted towards any wrong direction or evil thought at all.
            When the mind returns (i.e., becomes stable), all the energy of our body returns and we easily achieve even the greatest of goals.
            May we attain such perfection (Dakshata) in every single task of ours that is beneficial for society and extremely dear to the Supreme God.
            May our life remain supremely bright, active, and energetic exactly like this rising sun; this is the ultimate message of this Vedic prayer.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 55,
        sanskrit = "पुनर्नः पितरो मनो ददातु दैव्यो जनः ।\nजीवं व्रातं सचेमहि ॥ ५५ ॥",
        hindiCommentary = """
            हमारे श्रेष्ठ पितर (पूर्वज) और दिव्य गुणों से युक्त लोग (दैव्यो जनः) हमारे भटके हुए मन को हमें पुनः वापस प्रदान करें।
            ताकि हम उस एकाग्र और शुद्ध मन के साथ सजीव, ऊर्जावान और श्रेष्ठ कर्म करने वाले लोगों के समूह (जीवं व्रातम्) में भली-भांति सम्मिलित हो सकें।
            यह मंत्र इस बात पर बल देता है कि समाज और पूर्वजों का सत्संग मनुष्य के मानसिक स्वास्थ्य और उसकी दिशा को सुधारने में कितना महत्वपूर्ण है।
            जब हम बुरी संगति में पड़कर अपना मन खो बैठते हैं, तब महान पुरुषों के विचार (दैव्यो जन) ही हमें वापस सन्मार्ग पर लाते हैं।
            'जीवं व्रातम्' का अर्थ है वह समूह जो वास्तव में जाग्रत है, जो धर्म, परोपकार और विश्व-कल्याण के कार्यों में सक्रिय रूप से लगा हुआ है।
            हे परमात्मा! हमें ऐसा सौभाग्य दें कि हम हमेशा विद्वान, सत्यनिष्ठ और पवित्र आत्माओं की संगति में ही रहें ताकि हमारा मन मलिन न हो।
            जो व्यक्ति श्रेष्ठ जनों के समूह से कट जाता है, उसका मन अवसाद और भटकाव का शिकार हो जाता है; इसलिए उत्तम संगति (सत्संग) परम आवश्यक है।
            हमारे पूर्वजों का आशीर्वाद हमारे लिए एक ऐसा अदृश्य सुरक्षा कवच है जो हमारे मन को कभी भी निराशा के गहरे गर्त में डूबने नहीं देता।
            हम अपने मन को वापस पाकर उस असीम ऊर्जा को महसूस करें जो हमें राष्ट्र और मानवता की सेवा करने के लिए निरंतर प्रेरित करती है।
            हमारा जीवन मरे हुए (अकर्मण्य) लोगों के समान न हो, बल्कि हम जीवित (जीवं) और जीवंत होकर इस सुंदर सृष्टि के महान यज्ञ में अपना योगदान दें।
        """.trimIndent(),
        englishCommentary = """
            May our excellent ancestors (Pitris) and the people endowed with divine virtues (Daivyo Janah) restore and give back our wandering mind to us.
            So that with that concentrated and pure mind, we may perfectly join the group of living, energetic, and noble-acting people (Jivam Vratam).
            This mantra emphasizes how important the good company of society and ancestors is in improving a person's mental health and proper direction.
            When we lose our mind falling into bad company, it is only the thoughts of great men (Daivyo Jan) that bring us back to the right path.
            'Jivam Vratam' means that group which is truly awake, which is actively engaged in the tasks of Dharma, benevolence, and global welfare.
            O Supreme Lord! Grant us such good fortune that we always remain in the company of scholarly, truthful, and holy souls so our mind does not become impure.
            A person disconnected from the group of noble people falls prey to depression and wandering; therefore, excellent company (Satsang) is absolutely essential.
            The blessing of our ancestors is an invisible protective shield for us that never lets our mind sink into the deep pit of utter despair.
            Regaining our mind, let us feel that boundless energy which continuously inspires us to selflessly serve the nation and all of humanity.
            Let our lives not be like dead (inactive) people, but being alive (Jivam) and vibrant, let us highly contribute to the great sacrifice of this beautiful creation.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 56,
        sanskrit = "वय सोम व्रते तव मनस्तनूषु बिभ्रतः ।\nप्रजावन्तः सचेमहि ॥ ५६ ॥",
        hindiCommentary = """
            हे शांति और आनंद के देव (सोम)! आपके द्वारा स्थापित नियमों (व्रते) और धर्म का पालन करते हुए, हम अपने शरीरों (तनूषु) में अपने मन को एकाग्र करके धारण करें।
            हम उत्तम प्रजा (संतान और शिष्यों) से युक्त होकर सुखपूर्वक रहें और सत्य के मार्ग पर एक साथ मिलकर चलें (सचेमहि)।
            सोम का अर्थ है शीतलता, शांति और मानसिक तृप्ति; यह मंत्र मन की उस अवस्था को मांगता है जहाँ कोई भी तनाव या चंचलता शेष न रहे।
            'तनूषु मनः बिभ्रतः' का अर्थ है कि हमारा मन हमारे शरीर के भीतर (वर्तमान में) रहे; अक्सर शरीर यहाँ होता है और मन कहीं और भटक रहा होता है।
            जब मन वर्तमान क्षण में पूरी तरह एकाग्र होता है, तभी मनुष्य किसी भी नियम (व्रत) का या धर्म का सच्चा पालन कर सकता है।
            ईश्वर से 'प्रजावन्तः' होने की प्रार्थना केवल अपने स्वार्थ के लिए नहीं है, बल्कि एक ऐसी उत्तम पीढ़ी तैयार करने के लिए है जो भविष्य में धर्म की रक्षा करे।
            हे प्रभु! हमारे मन को सोम के समान इतना शीतल कर दें कि क्रोध की अग्नि हमारे भीतर के किसी भी श्रेष्ठ विचार को जला न सके।
            हम अपने नियमों और व्रतों पर इतनी दृढ़ता से टिके रहें कि संसार की कोई भी बाधा हमारे पारिवारिक और सामाजिक जीवन में अशांति न ला सके।
            जब मन और शरीर पूरी तरह एक हो जाते हैं, तब मनुष्य का संपूर्ण जीवन योगमय हो जाता है और उसे हर कर्म में ईश्वरीय आनंद की अनुभूति होती है।
            हमारा घर ऐसा तपोवन बने जहाँ माता-पिता, संतान और सभी सदस्य एक साथ मिलकर आनंदपूर्वक उस परम सत्ता की अखंड वंदना करें।
        """.trimIndent(),
        englishCommentary = """
            O God of peace and bliss (Soma)! Following the rules (Vrate) and Dharma established by You, may we hold our mind concentrated within our bodies (Tanushu).
            May we live happily, endowed with excellent progeny (children and disciples), and walk together unitedly (Sachemahi) on the path of truth.
            Soma means coolness, peace, and mental fulfillment; this mantra asks for that state of mind where absolutely no stress or restlessness remains.
            'Holding the mind in the body' means our mind should stay within our body (in the present); often the body is here and the mind is wandering elsewhere.
            Only when the mind is fully concentrated in the present moment can a human truly observe any rule (Vrata) or strictly follow Dharma.
            Praying to God to be 'Prajavantah' is not just for selfishness, but to prepare such an excellent generation that protects Dharma in the future.
            O Lord! Make our mind so cool like Soma that the fire of extreme anger can never burn any of the excellent thoughts residing within us.
            Let us stand so firmly on our rules and vows that no obstacle of the world can ever bring unrest into our family and social lives.
            When the mind and body become completely one, a human's entire life becomes Yogic, and they experience divine bliss in absolutely every action.
            May our home become such an ascetic grove where parents, children, and all members joyfully worship that Supreme Reality together as one.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 57,
        sanskrit = "एष ते रुद्र भागः सह स्वस्राम्बिकया तं जुषस्व स्वाहा ।\nएष ते रुद्र भागऽआखुस्ते पशुः ॥ ५७ ॥",
        hindiCommentary = """
            (त्र्यम्बक होम का आरंभ) हे रुद्र देव! यह हविष्य (भाग) आपके लिए और आपकी शक्तिस्वरूपा भगवती (बहन) 'अम्बिका' के लिए है; कृपया इसे सहर्ष स्वीकार करें, स्वाहा।
            हे रुद्र! यह आपका भाग है; और मूषक (आखु/चूहा) आपका पशु (अंश या वाहन) है।
            यहाँ से 'त्र्यम्बक होम' (रुद्रयज्ञ) का आरंभ होता है, जो प्रकृति की संहारक और कल्याणकारी शक्ति (शिव) की महान उपासना है।
            रुद्र का अर्थ है जो दुखों को नष्ट कर रुला दे या जो पापियों को दंड दे; और अम्बिका (माता/शक्ति) उसी शिव की वह ऊर्जा है जो जगत का पालन करती है।
            'चूहे' (आखु) को रुद्र का पशु कहने का अत्यंत गहरा प्रतीकात्मक अर्थ है; चूहा चोरी-छिपे सब कुछ कुतर देता है, जो हमारे भीतर के 'चोर' (काम, क्रोध, लालच) का प्रतीक है।
            रुद्र से प्रार्थना की गई है कि वे हमारे मन रूपी खेत में छुपे हुए इन चूहों (दुर्गुणों) पर नियंत्रण रखें ताकि वे हमारी आध्यात्मिक फसल (पुण्य) को नष्ट न कर सकें।
            हे परमात्मा! हम आपके उग्र (रुद्र) और सौम्य (अम्बिका) दोनों रूपों को नमन करते हैं, क्योंकि निर्माण और संहार दोनों ही आपकी पूर्ण व्यवस्था का हिस्सा हैं।
            हम जो आहुति (स्वाहा) दे रहे हैं, वह हमारे अहंकार की आहुति है; इसे स्वीकार कर आप हमें अपने परम ज्ञान और अभय की शरण में ले लें।
            जब हम ईश्वर को उसका भाग (सम्मान और समय) दे देते हैं, तो ईश्वर हमारे जीवन के उन सभी छोटे-बड़े शत्रुओं का शमन कर देता है जो हमें भीतर से खोखला कर रहे हैं।
            हमारा जीवन शिव और शक्ति के इस अद्वैत मिलन से ऐसा पूर्ण हो जाए कि हम संसार के हर जीव में उसी परम कल्याणकारी सत्ता के दर्शन करें।
        """.trimIndent(),
        englishCommentary = """
            (Beginning of Tryambaka Homa) O Lord Rudra! This oblation (portion) is for You and Your power-manifested goddess (sister) 'Ambika'; please accept it joyfully, Svaha.
            O Rudra! This is Your portion; and the mouse (Akhu) is Your animal (part or vehicle).
            From here begins the 'Tryambaka Homa' (Rudra sacrifice), which is the great worship of nature's destroying and benevolent power (Shiva).
            Rudra means the one who destroys sorrows making one weep, or who punishes sinners; and Ambika (Mother/Power) is that energy of Shiva that nourishes the world.
            Calling the 'mouse' (Akhu) Rudra's animal has a very deep symbolic meaning; a mouse secretly gnaws everything, symbolizing our inner 'thieves' (lust, anger, greed).
            A prayer is made to Rudra to control these mice (vices) hidden in the field of our mind so they do not destroy our spiritual harvest (merits).
            O Supreme Lord! We bow to both Your fierce (Rudra) and gentle (Ambika) forms, because both creation and destruction are parts of Your perfect order.
            The oblation (Svaha) we are giving is the oblation of our ego; accepting it, please take us into the ultimate refuge of Your supreme knowledge and fearlessness.
            When we give God His portion (respect and time), God subdues all those big and small enemies of our lives that are hollowing us from the inside.
            May our life become so fulfilled by this non-dual union of Shiva and Shakti that we see the vision of that supremely benevolent reality in every living being.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 58,
        sanskrit = "अव रुद्रमदीमह्यव देवं त्र्यम्बकम् ।\nयथा नो वस्यसस्करद्यथा नः श्रेयसस्करद्यथा नो व्यवसाययात् ॥ ५८ ॥",
        hindiCommentary = """
            हम उन रुद्र देव को, उन साक्षात् त्र्यम्बक (तीनों लोकों के पिता/तीनों कालों के ज्ञाता/त्रिनेत्रधारी) देव को हवि देकर पूर्णतः तृप्त और प्रसन्न कर चुके हैं।
            ताकि वे परमेश्वर हमें सबसे अधिक समृद्ध (वस्यसः) बनाएं, ताकि वे हमें परम कल्याण (श्रेयसः) प्रदान करें...
            और ताकि वे ईश्वर हमें हमारे धर्म के मार्ग पर और हमारे श्रेष्ठ कार्यों में अत्यंत दृढ़ता के साथ स्थिर (व्यवसाययात्) रखें।
            त्र्यम्बक का अर्थ है—तीन अम्बाओं (माताओं) वाला, या सूर्य, चंद्र और अग्नि रूपी तीन नेत्रों वाला वह परब्रह्म शिव जो संपूर्ण सृष्टि को देख रहा है।
            ईश्वर को 'तृप्त' करने का अर्थ उसे भोजन खिलाना नहीं है, बल्कि अपने निर्मल आचरण से उसकी ब्रह्मांडीय व्यवस्था के प्रति अपनी पूर्ण निष्ठा सिद्ध करना है।
            ईश्वर से यहाँ तीन चीजें मांगी गई हैं: वस्यस (भौतिक सुख/धन), श्रेयस (आध्यात्मिक मोक्ष), और व्यवसाय (कर्तव्य के प्रति अटूट निष्ठा)।
            हे त्र्यम्बक देव! हमारे जीवन को ऐसा संतुलित कर दें कि हम संसार के सभी सुख भोगते हुए भी अंततः मोक्ष (श्रेय) के मार्ग पर ही प्रशस्त हों।
            हमारा मन कभी भी कठिनाइयों से घबराकर अपने कर्त्तव्य (व्यवसाय) से पीछे न हटे; हमें वह असीम आत्मबल दें जो हर तूफान में चट्टान सा खड़ा रहे।
            जब ईश्वर प्रसन्न होता है, तो वह मनुष्य के भीतर बैठे अज्ञान के अंधकार को अपने तीसरे नेत्र (ज्ञान चक्षु) के प्रहार से हमेशा के लिए भस्म कर देता है।
            हम पूर्णतः निर्भय होकर इस संसार रूपी कर्मभूमि में कार्य करें, क्योंकि जब स्वयं त्रिलोकीनाथ हमारे रक्षक हैं, तो हमारा कोई भी पतन कैसे हो सकता है!
        """.trimIndent(),
        englishCommentary = """
            We have completely satisfied and pleased that Lord Rudra, that direct Tryambaka God (father of three worlds / knower of three times / three-eyed one) by offering oblations.
            So that the Supreme Lord may make us the most prosperous (Vasyasah), so that He may grant us ultimate welfare and liberation (Shreyasah)...
            And so that the Lord may firmly stabilize and establish (Vyavasayayat) us on the path of our Dharma and in our excellent noble deeds.
            Tryambaka means—the one with three Ambas (mothers), or that Supreme Brahman Shiva with three eyes as Sun, Moon, and Fire, who observes the entire creation.
            'Satisfying' God does not mean feeding Him food, but proving our complete loyalty to His cosmic order through our totally pure conduct.
            Three things are asked from God here: Vasyas (material joy/wealth), Shreyas (spiritual liberation), and Vyavasaya (unbreakable dedication to duty).
            O Lord Tryambaka! Balance our lives in such a way that even while enjoying all worldly joys, we ultimately advance strictly on the path of liberation (Shreya).
            May our mind never back down from its duty (Vyavasaya) fearing difficulties; grant us that boundless soul-strength which stands like a rock in every storm.
            When God is pleased, He burns the darkness of ignorance sitting inside the human to ashes forever with the strike of His third eye (eye of knowledge).
            Let us work completely fearlessly in this action-field of the world, because when the Lord of three worlds Himself is our protector, how can our downfall ever occur!
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 59,
        sanskrit = "भेषजमसि भेषजं गवेऽश्वाय पुरुषाय भेषजम् ।\nसुखं मेषाय मेष्यै ॥ ५९ ॥",
        hindiCommentary = """
            हे त्र्यम्बक होम की पावन भस्म (या हवि)! तू साक्षात् एक महान औषधि (भेषज) है; तू हमारी गौओं के लिए औषधि है, हमारे अश्वों के लिए औषधि है।
            तू हम सभी मनुष्यों (पुरुषाय) के रोगों का नाश करने वाली अमोघ औषधि है, और हमारे मेढ़ों (भेड़ों) और मेढ़ियों के लिए असीम सुख तथा आरोग्य देने वाली है।
            वैदिक धर्म की विशालता देखिए—यज्ञ की प्रार्थना में केवल मनुष्य ही नहीं, बल्कि प्रकृति के हर पशु-पक्षी के स्वास्थ्य और कल्याण की कामना की गई है।
            ईश्वर की कृपा ही संसार की सबसे बड़ी 'भेषज' (दवा) है; जब यह कृपा भस्म के रूप में प्राप्त होती है, तो यह शारीरिक और मानसिक दोनों प्रकार के रोगों को जड़ से उखाड़ देती है।
            पशुधन उस युग में सबसे बड़ी संपत्ति थी; गौएं और अश्व समाज की अर्थव्यवस्था और सुरक्षा के मुख्य आधार थे, अतः उनकी रक्षा राष्ट्र की रक्षा थी।
            हे प्रभु! आपका यह आशीर्वाद हमारे घर-आंगन के हर प्राणी, हर जीव-जंतु के जीवन में सुख, आरोग्य और पूर्ण शांति का संचार कर दे।
            हम जो भी अन्न ग्रहण करें या जो भी कार्य करें, वह हमारे शरीर के लिए रोगनाशक और हमारी आत्मा के लिए अत्यंत कल्याणकारी औषधि बन जाए।
            स्वार्थ से ऊपर उठकर जब मनुष्य संपूर्ण जीवजगत के सुख (सुखं मेषाय मेष्यै) की प्रार्थना करता है, तो उसका अंतःकरण साक्षात् देवतुल्य हो जाता है।
            रोग केवल शरीर के नहीं होते; लोभ, मोह और अहंकार मन के सबसे बड़े रोग हैं; ईश्वर का नाम ही वह परम औषधि है जो इन भयंकर रोगों को भी मिटा सकती है।
            हमारा यह यज्ञ प्रकृति के पर्यावरण को इतना शुद्ध कर दे कि यहाँ बहने वाली हवा का हर झोंका सभी प्राणियों के लिए एक अमृत संजीवनी बन जाए।
        """.trimIndent(),
        englishCommentary = """
            O holy ash (or oblation) of Tryambaka Homa! You are directly a great medicine (Bheshaja); you are medicine for our cows, medicine for our horses.
            You are the infallible medicine that destroys the diseases of all us humans (Purushaya), and you give boundless happiness and health to our rams and ewes.
            Behold the vastness of Vedic Dharma—the sacrificial prayer wishes for the health and welfare not just of humans, but of every single animal of nature.
            God's grace is the world's biggest 'Bheshaja' (medicine); when this grace is received as holy ash, it uproots both physical and mental diseases completely.
            Livestock was the greatest wealth in that era; cows and horses were the main basis of the economy and security, so protecting them was protecting the nation.
            O Lord! May this blessing of Yours infuse joy, perfect health, and absolute peace into the life of every creature and animal in our home's courtyard.
            Whatever food we consume or deed we do, may it become a disease-destroying medicine for our body and an extremely benevolent medicine for our soul.
            Rising above selfishness, when a human prays for the happiness of the entire animal world, their inner conscience becomes directly godlike.
            Diseases are not just physical; greed, attachment, and ego are the biggest diseases of the mind; God's name is the supreme medicine that eradicates these terrible diseases.
            May this sacrifice of ours purify nature's environment so much that every gust of wind blowing here becomes a nectar of life (Sanjeevani) for all beings.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 60,
        sanskrit = "त्र्यम्बकं यजामहे सुगन्धिं पुष्टिवर्धनम् ।\nउर्वारुकमिव बन्धनान्मृत्योर्मुक्षीय माऽमृतात् ॥ ६० ॥",
        hindiCommentary = """
            (महामृत्युंजय मंत्र) हम त्र्यम्बक (तीनों लोकों के पिता/तीनों कालों को देखने वाले परमेश्वर शिव) की अत्यंत श्रद्धापूर्वक पूजा (यजामहे) करते हैं।
            वे जो सुगन्धित (पुण्य और यश की सुगन्ध से युक्त) हैं और जो हमारे जीवन, शरीर तथा आत्मिक शक्तियों को निरंतर पुष्ट कर बढ़ाने वाले (पुष्टिवर्धनम्) हैं।
            जिस प्रकार एक पका हुआ खरबूजा (उर्वारुकमिव) अपनी बेल (बंधन) से अपने आप (बिना किसी कष्ट के) अलग हो जाता है...
            उसी प्रकार हे प्रभु! आप मुझे मृत्यु के कष्टदायक बंधनों से सहज ही मुक्त कर दें, परन्तु अमरता (अमृतात्/मोक्ष) से मुझे कभी भी अलग न करें।
            यह वेदों का सबसे चमत्कारी और जीवनदायी मंत्र है; यह केवल मृत्यु से बचने की नहीं, बल्कि 'अकाल मृत्यु' और 'जन्म-मरण के चक्र' से मुक्त होने की परम प्रार्थना है।
            'सुगन्धिं' का अर्थ है वह परमात्मा जिसका प्रेम और ज्ञान चारों दिशाओं में फूल की खुशबू की तरह बिना किसी भेदभाव के फैलता है।
            खरबूजे का उदाहरण अत्यंत वैज्ञानिक है; जब फल पक जाता है, तो वह जड़ से टूटकर स्वतंत्र हो जाता है; वैसे ही जब ज्ञान पक जाता है, तो आत्मा संसार के मोह से मुक्त हो जाती है।
            हे महादेव! मेरे जीवन को अपनी भक्ति से इतना परिपक्व (पका हुआ) कर दें कि अंत समय में शरीर छोड़ते हुए मुझे कोई भी दुख या सांसारिक आसक्ति न सताए।
            मृत्यु से मुक्ति का अर्थ अमर शरीर पाना नहीं है, बल्कि अपनी आत्मा के वास्तविक (अमर) स्वरूप को जान लेना है, जिसे कोई मृत्यु छू नहीं सकती।
            हम आपके श्रीचरणों में अपना जीवन समर्पित करते हैं; आप हमारी रक्षा करें और हमें अज्ञान के अंधकार से निकालकर मोक्ष के शाश्वत प्रकाश में स्थापित कर दें।
        """.trimIndent(),
        englishCommentary = """
            (Mahamrityunjaya Mantra) We worship (Yajamahe) with utmost devotion the Tryambaka (Father of the three worlds / the Supreme Lord Shiva who sees all three times).
            He who is fragrant (endowed with the fragrance of merit and glory) and who continuously nourishes and increases (Pushtivardhanam) our life, body, and spiritual powers.
            Just as a fully ripened melon (Urvarukamiva) detaches itself automatically (without any pain) from its vine (bondage)...
            In the exact same way, O Lord! Liberate me effortlessly from the painful bonds of death, but never separate me from immortality (Amritat/liberation).
            This is the most miraculous and life-giving mantra of the Vedas; it is a supreme prayer not just to escape death, but to be freed from 'untimely death' and the 'cycle of rebirth'.
            'Sugandhim' means that Supreme Soul whose pure love and knowledge spread in all directions like the fragrance of a flower without any discrimination.
            The melon example is highly scientific; when the fruit ripens, it breaks from the root and becomes free; similarly, when knowledge ripens, the soul is freed from worldly attachment.
            O Mahadeva! Make my life so mature (ripened) with Your devotion that at the final moment of leaving the body, no sorrow or worldly attachment torments me at all.
            Liberation from death does not mean getting an immortal physical body, but realizing the true (immortal) nature of one's soul, which no death can ever touch.
            We surrender our lives at Your holy feet; please protect us, pull us out of the darkness of ignorance, and establish us firmly in the eternal light of ultimate liberation.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 61,
        sanskrit = "त्र्यम्बकं यजामहे सुगन्धिं पतिवेदनम् ।\nउर्वारुकमिव बन्धनादितो मुक्षीय माऽमुतः ॥ ६१ ॥",
        hindiCommentary = """
            (कन्याओं/संसारियों के लिए महामृत्युंजय का विशेष स्वरूप) हम त्र्यम्बक (सर्वज्ञ शिव) की अत्यंत श्रद्धापूर्वक वंदना और पूजा (यजामहे) करते हैं।
            वे जो सुगन्धित (चारों ओर यश फैलाने वाले) हैं और जो सुयोग्य पति (या संसार के रक्षक) को प्राप्त कराने वाले (पतिवेदनम्) हैं।
            जिस प्रकार पका हुआ खरबूजा (उर्वारुकमिव) अपनी बेल (बंधन) से बिना किसी कष्ट के सरलता से टूटकर अलग हो जाता है...
            उसी प्रकार हे प्रभु! आप मुझे यहाँ (इतः) अर्थात् पिता के घर या संसार के बंधनों से तो मुक्त कर दें, परन्तु वहाँ (अमुतः) अर्थात् पति के घर या मोक्ष से मुझे कभी अलग न करें।
            यह मंत्र विशेष रूप से कन्या के विवाह संस्कार या उन सांसारिक साधकों के लिए है जो ईश्वर से उत्तम पारिवारिक जीवन (पति/आश्रय) की कामना करते हैं।
            'पति' का अर्थ केवल पति नहीं है, बल्कि वह 'पालक' या 'रक्षक' है जो जीवन को एक सही दिशा और सुरक्षा प्रदान करता है।
            बेल से अलग होने का अर्थ है कि जब कन्या विवाह योग्य हो जाए (परिपक्व हो जाए), तो वह बिना किसी दुख के पिता का घर छोड़कर एक नए जीवन की शुरुआत करे।
            हे त्र्यम्बक देव! हमारे जीवन में ऐसा उत्तम और सुगन्धित (पवित्र) संबंध स्थापित करें जो हमें संसार के सभी कष्टों से बचाकर पूर्ण सुरक्षा दे।
            हम पुरानी अज्ञानताओं और बंधनों से मुक्त होकर एक नए, जाग्रत और धर्मनिष्ठ जीवन में प्रवेश करें, जहाँ हमारा संबंध केवल सत्य से हो।
            ईश्वर की यह प्रार्थना दर्शाती है कि वैदिक धर्म में संन्यास के साथ-साथ एक स्वस्थ, सुखी और परिपक्व गृहस्थ जीवन को भी ईश्वर का ही महान आशीर्वाद माना गया है।
        """.trimIndent(),
        englishCommentary = """
            (Special form of Mahamrityunjaya for maidens/householders) We worship (Yajamahe) with utmost devotion the Tryambaka (omniscient Shiva).
            He who is fragrant (spreading glory everywhere) and who is the bestower of a worthy husband (or the protector of the world) (Pativedanam).
            Just as a fully ripened melon (Urvarukamiva) easily breaks away and separates from its vine (bondage) without any pain...
            Similarly, O Lord! Liberate me from here (Itah) i.e., from the father's house or worldly bonds, but never separate me from there (Amutah) i.e., the husband's house or ultimate liberation.
            This mantra is specially for a maiden's marriage sacrament or for those worldly seekers who desire an excellent family life (husband/refuge) from God.
            'Pati' does not just mean husband, but the 'nourisher' or 'protector' who provides correct direction and absolute security to life.
            Separating from the vine means that when a maiden becomes marriageable (mature), she leaves her father's house without sorrow to start a new life.
            O Lord Tryambaka! Establish such an excellent and fragrant (holy) relationship in our lives that protects us from all worldly pains and gives absolute security.
            May we be freed from old ignorances and bonds and enter a new, awakened, and righteous life, where our bond is solely with the Absolute Truth.
            This prayer to God shows that in Vedic Dharma, along with asceticism, a healthy, happy, and mature householder life is also considered a great blessing of God.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 62,
        sanskrit = "एतत्ते रुद्रावसं तेन परो मूजवतोऽतीहि ।\nअवततधन्वा पिनाकावसः कृत्तिवासाऽअहिंसन्नः शिवोऽतीहि ॥ ६२ ॥",
        hindiCommentary = """
            हे रुद्र देव! यह हविष्य रूपी पाथेय (यात्रा का भोजन/अवसम्) आपके लिए है; आप इसे ग्रहण करें और मूजवान् पर्वत (अत्यंत दूर के स्थान) के पार चले जाएं (परो अतीहि)।
            आप अपने धनुष (पिनाक) की डोरी को उतार कर (अवततधन्वा) उसे शांत रूप में धारण करें और अपने क्रोध को शांत करें।
            आप मृगछाला या बाघंबर (कृत्तिवासा) धारण किए हुए, हमारे लिए पूर्णतः अहिंसक (अहिंसन्) और अत्यंत कल्याणकारी (शिवः) होकर ही हमारे बीच से गमन करें।
            यज्ञ के अंत में जब रुद्र की उग्र शक्ति का कार्य पूरा हो जाता है, तो उनसे प्रार्थना की जाती है कि वे अपना क्रोधी रूप त्याग कर 'शिव' (कल्याणकारी) रूप धारण कर लें।
            'मूजवान् पर्वत' का अर्थ है वह दूरस्थ स्थान जहाँ पाप और अज्ञान रहते हैं; हम ईश्वर से प्रार्थना करते हैं कि वे हमारी बुराइयों को हमसे बहुत दूर लेकर चले जाएं।
            धनुष की डोरी उतारने का अर्थ है कि अब दण्ड देने का समय समाप्त हो गया है; अब केवल शांति, करुणा और क्षमा का समय है।
            हे महादेव! आपने अज्ञान को नष्ट करने के लिए जो भयानक रूप धारण किया था, अब उसे शांत करें और हमारे परिवार पर अपनी करुणा की अमृत वर्षा करें।
            ईश्वर का 'रुद्र' (रुलाने वाला) रूप केवल पापियों के लिए है, परंतु अपने सच्चे भक्तों के लिए वह हमेशा 'शिव' (मंगलमय) ही होता है।
            हम आपके उस परम शांत स्वरूप को नमन करते हैं, जो हमें कभी भी भयभीत नहीं करता बल्कि हमें अपने आलिंगन में लेकर पूर्ण सुरक्षा प्रदान करता है।
            हमारा यह यज्ञ इस प्रार्थना के साथ संपन्न हो रहा है कि इस सृष्टि का प्रत्येक कण आपके क्रोध से मुक्त होकर केवल आपके निस्वार्थ प्रेम और आनंद को ही अनुभव करे।
        """.trimIndent(),
        englishCommentary = """
            O Lord Rudra! This provision for the journey in the form of oblation (Avasam) is for You; accept it and go far beyond the Mujavan mountain (an extremely distant place).
            Unstring Your bow (Pinaka - Avatatadhanva), holding it in a completely peaceful state, and calm down Your fierce anger completely.
            Wearing the deer or tiger skin (Krittivasa), please move past us being completely non-violent (Ahinsan) and extremely benevolent (Shivah) towards us.
            At the end of the sacrifice, when the task of Rudra's fierce power is complete, He is prayed to abandon His angry form and assume the 'Shiva' (benevolent) form.
            'Mujavan mountain' means that distant place where sins and ignorance reside; we pray to God to take all our evils far, far away from us.
            Unstringing the bow means that the time for punishment is now over; now is the time solely for absolute peace, deep compassion, and forgiveness.
            O Mahadeva! The terrifying form You assumed to destroy ignorance, please calm it now and rain the nectar of Your compassion upon our family.
            God's 'Rudra' (one who makes weep) form is only for sinners, but for His true devotees, He is always only 'Shiva' (highly auspicious).
            We bow to that supremely peaceful form of Yours, which never makes us afraid but takes us into its embrace, providing complete and absolute security.
            This sacrifice of ours concludes with this prayer that every particle of this creation, free from Your anger, experiences only Your selfless love and supreme bliss.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 63,
        sanskrit = "त्र्यायुषं जमदग्नेः कश्यपस्य त्र्यायुषम् ।\nयद्देवेषु त्र्यायुषं तन्नोऽअस्तु त्र्यायुषम् ॥ ६३ ॥\n(नोट: यह तृतीय अध्याय का अन्तिम मन्त्र है।)",
        hindiCommentary = """
            (त्र्यायुष मंत्र - दीर्घायु की प्रार्थना) जो तीन गुनी (दीर्घ) आयु महर्षि जमदग्नि को प्राप्त हुई, और जो तीन गुनी महान आयु महर्षि कश्यप को प्राप्त हुई।
            और जो तीन गुनी (अमरत्व से युक्त) आयु स्वयं स्वर्ग के देवताओं (देवेषु) के पास विद्यमान है...
            वही तीन गुनी, महान और अत्यंत स्वस्थ आयु हम सबको भी प्राप्त हो (तन्नो अस्तु त्र्यायुषम्); हम भी धर्म का पालन करते हुए एक लंबी उम्र जिएं।
            यह तृतीय अध्याय का अंतिम मंत्र है जो यज्ञ की समाप्ति पर साधक को शारीरिक, मानसिक और आध्यात्मिक तीनों स्तरों पर एक लंबा और पूर्ण जीवन देने का महान आशीर्वाद है।
            महर्षि जमदग्नि तप और तेज के प्रतीक हैं, और कश्यप सृष्टि की निरंतरता के प्रतीक हैं; हम उन ऋषियों के समान ज्ञान से भरा हुआ लंबा जीवन मांगते हैं।
            'त्र्यायुष' का अर्थ केवल 100 वर्ष जीना नहीं है, बल्कि बचपन, युवावस्था और बुढ़ापा—इन तीनों कालों में पूर्णतः स्वस्थ, सक्रिय और ईश्वर की भक्ति में लीन रहना है।
            हम बिना किसी बीमारी, पराधीनता या लाचारी के अपना जीवन जिएं और अपनी अंतिम सांस तक अपने हाथों से समाज की सेवा करते रहें।
            हे परमात्मा! हमारी आयु केवल पंचांग के दिन न गिने, बल्कि वह हमारे द्वारा किए गए पुण्यों और परमार्थ के कार्यों से मापी जाए।
            जैसे देवताओं की आयु कभी क्षीण नहीं होती, वैसे ही हमारी आत्मा का वह ईश्वरीय ज्ञान कभी भी कम न हो और हम जीवन मुक्त अवस्था को प्राप्त करें।
            इस मंत्र के साथ तृतीय अध्याय के अग्निहोत्र और चातुर्मास्य अनुष्ठानों की पूर्णाहुति होती है, जहाँ साधक एक जाग्रत, दीर्घायु और देवतुल्य जीवन का संकल्प लेकर उठता है। ॐ शान्तिः शान्तिः शान्तिः।
        """.trimIndent(),
        englishCommentary = """
            (Tryayusha Mantra - Prayer for longevity) That threefold (long) life-span which was attained by the great sage Jamadagni, and that threefold great life attained by sage Kashyapa.
            And that threefold (endowed with immortality) life-span which exists continuously with the gods in heaven (Deveshu)...
            May that exact same threefold, great, and extremely healthy life-span be attained by all of us too (Tanno astu Tryayusham); may we too live a long life practicing Dharma.
            This is the final mantra of the third chapter, a great blessing at the end of the sacrifice giving the seeker a long and complete life on physical, mental, and spiritual levels.
            Sage Jamadagni is the symbol of penance and brilliance, and Kashyapa of creation's continuity; we ask for a long life filled with knowledge like those sages.
            'Tryayusha' doesn't just mean living 100 years, but remaining perfectly healthy, active, and absorbed in God's devotion across all three phases: childhood, youth, and old age.
            May we live our lives without any disease, dependence, or helplessness, and keep serving society with our own hands until our very last breath.
            O Supreme Lord! Let our age not just count calendar days, but let it be measured entirely by the merits and benevolent deeds performed by us.
            Just as the gods' life-span never diminishes, may the divine knowledge of our soul never lessen, and may we attain the deeply liberated state while living.
            With this mantra, the Agnihotra and Chaturmasya rituals of the third chapter come to a full conclusion, where the seeker rises with the firm resolve of an awakened, long, and godlike life. Om Shanti Shanti Shanti.
        """.trimIndent()
    )
)