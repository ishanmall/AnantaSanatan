package com.sanatangyansagar.ui.screens.veda.samveda.UttararchikaSamveda

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
import androidx.compose.ui.unit.dp
import com.sanatangyansagar.ui.screens.veda.samveda.PurvarchikaSamVeda.PurvarchikaVerse
import com.sanatangyansagar.ui.screens.veda.samveda.PurvarchikaSamVeda.VedaDetailCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UttararchikaAdhyayaFourScreen() {
    var searchQuery by remember { mutableStateOf("") }

    val filteredVerses = remember(searchQuery) {
        if (searchQuery.isEmpty()) {
            uttararchikaAdhyayaFourData
        } else {
            uttararchikaAdhyayaFourData.filter {
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
                        Text("उत्तरार्चिक - चतुर्थ अध्याय", fontWeight = FontWeight.ExtraBold)
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color(0xFFFFB74D)
                    )
                )
                TextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    placeholder = { Text("मंत्र या शब्द खोजें...") },
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
        }
    }
}

val uttararchikaAdhyayaFourData = listOf(
    PurvarchikaVerse(
        id = 1,
        sanskrit = "पवस्व वाचो अग्रियः सोम चित्तिभिः अर्णवः ।\nयोनिं कनिक्रदत् आसदः ॥ १ ॥",
        hindiCommentary = """
            हे सोमदेव! आप वाणी के अग्रणी और ज्ञान के अथाह समुद्र होकर अपनी दिव्य चेतनाओं के साथ पवित्र होकर प्रवाहित हों। 
            आप दिव्य ध्वनि करते हुए अपने शाश्वत यज्ञीय स्थान पर विराजमान हों, जो आपकी प्रचंड शक्ति और सर्वोच्चता का साक्षात् प्रतीक है। 
            यह मंत्र स्पष्ट करता है कि हमारी वाणी केवल शब्दों का समूह नहीं, बल्कि आत्मा के आनंद की गहरी अभिव्यक्ति होनी चाहिए। 
            जब सोम हमारी वाणी को प्रेरित करता है, तो मनुष्य सत्य बोलता है और उसके वचनों में ईश्वरीय तेज का संचार होने लगता है। 
            आपकी गर्जना हमारे भीतर के अज्ञान, आलस्य और तामसी प्रवृत्तियों को जगाकर हमें कर्म और साधना के मार्ग पर सक्रिय करती है। 
            जैसे समुद्र अनंत रत्नों को समेटे रहता है, वैसे ही आपका ज्ञान भी असीम है, जो हमें आध्यात्मिक समृद्धि और शांति प्रदान करता है। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आप ही हमारे अंतःकरण को शुद्ध कर उसे दिव्यता के निवास योग्य पवित्र स्थान बनाते हैं। 
            यज्ञ की पावन ऊर्जा में आपकी उपस्थिति हमारे सूक्ष्म संकल्पों को ब्रह्मांडीय सिद्धियों में बदलने का सामर्थ्य रखती है। 
            हे पवमान सोम, आप अपनी अनंत महिमा के साथ हमारे इस यज्ञ में प्रतिष्ठित हों और हमें परम ज्ञान का आशीर्वाद प्रदान करें। 
            आप ही वह अमृत हैं जो मृत्यु के भय को समाप्त कर साधक को अमरत्व और परमात्मा के परम पद की ओर सफलतापूर्वक ले जाते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Soma, flow in your purified state as the leader of speech and the ocean of wisdom, endowed with divine consciousness. 
            Seat yourself upon your eternal sacrificial source with a celestial roar, symbolizing your fierce power and ultimate supremacy. 
            This mantra clarifies that our speech should not be a mere collection of words but an expression of the soul's profound joy. 
            When Soma inspires our speech, a person utters Truth, and their words are infused with divine brilliance and cosmic power. 
            Your roar dispels the internal ignorance and lethargy, activating us firmly on the path of selfless action and spiritual practice. 
            Just as the ocean holds infinite gems, your knowledge is infinite and capable of granting us immense spiritual prosperity and peace. 
            We worship you with devotion as you are the one who purifies our inner self and makes it a fit dwelling for divinity. 
            Your presence in the sacred ritual possesses the capability to transform our subtle intentions into cosmic achievements. 
            O Pavamana Soma, reside in our sacrifice with your infinite glory and grant us the divine blessings of supreme knowledge. 
            You are the nectar that terminates the fear of death, leading the seeker successfully toward immortality and the state of the Divine.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 2,
        sanskrit = "अक्षण्वन्तः कर्णवन्तः सखायो मनोजवेषु असमा बभूवुः ।\nआदध्रास उपकक्षास उ त्वे ह्रदा इव स्त्रावा दृश्यन्ते ॥ २ ॥",
        hindiCommentary = """
            आँख और कान जैसी इंद्रियों के होने मात्र से सभी साधक ईश्वर के गूढ़ रहस्यों को समझने में एक समान नहीं होते हैं। 
            मन की गति और दिव्य सत्यों के साक्षात्कार के क्षेत्र में भक्तों की पात्रता उनकी आंतरिक साधना और हृदय की पवित्रता पर निर्भर करती है। 
            कुछ साधक केवल बाहरी ज्ञान की सतह तक ही पहुँच पाते हैं, जबकि कुछ गहरे सरोवर के समान परमात्मा के वास्तविक रहस्यों का दर्शन करते हैं। 
            यह मंत्र हमें सचेत करता है कि हम केवल भौतिक इंद्रियों पर गर्व न करें, बल्कि अपनी उस सूक्ष्म अंतर्दृष्टि को जाग्रत करें जो सत्य देख सके। 
            वास्तविक प्रज्ञा वही है जो इंद्रियों की सीमा को लांघकर उस अदृश्य सत्ता का अनुभव कर सके जो इस संपूर्ण चराचर जगत में व्याप्त है। 
            जैसे शांत सरोवर ही अपना तल दिखा पाता है, वैसे ही शांत और स्थिर मन ही परमात्मा की छवि को ग्रहण करने में पूर्णतः समर्थ होता है। 
            हे सोम, आप हमें वह दिव्य दृष्टि प्रदान करें जिससे हम संसार के भ्रामक मायाजाल को भेदकर आपके वास्तविक स्वरूप को पहचान सकें। 
            आपकी कृपा से ही हमारे भीतर वह पात्रता विकसित होती है जिससे हम दिव्य मंत्रों और शाश्वत सत्यों के साक्षात् द्रष्टा बन पाते हैं। 
            हमें वह मेधा शक्ति दें कि हम सांसारिक शोर में भी ईश्वर की पुकार सुनने के योग्य बनें और सदैव मानवता के कल्याण के मार्ग पर रहें। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन साधारण से असाधारण और पूरी तरह ईश्वरीय प्रकाश से दीप्तिमान हो।
        """.trimIndent(),
        englishCommentary = """
            Merely possessing eyes and ears does not make all seekers equal in understanding the deep mysteries of the Divine. 
            In the realms of mental speed and realization of truths, the eligibility of devotees depends on their inner practice and purity. 
            Some seekers only reach the superficial surface of knowledge, while others perceive the real mysteries of God like a deep lake. 
            This mantra warns us not to take pride in physical senses alone but to awaken that subtle insight which is capable of seeing the Truth. 
            True intellect is that which transcends the limits of the senses to experience the invisible authority pervading the entire universe. 
            Just as a lake shows its bottom only when still, a steady mind is the only vessel capable of reflecting the image of the Supreme Being. 
            O Soma, grant us that divine vision through which we can pierce the world's illusions and recognize your true, auspicious nature. 
            It is through your grace that the eligibility is developed within us to become direct seers of divine mantras and eternal truths. 
            Bestow upon us the intellect to hear the call of God amidst worldly noise and to stay firm on the path of global welfare. 
            We offer our entire faith at your divine feet so that our lives may transform from an ordinary existence into an extraordinary journey.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 3,
        sanskrit = "एतमु त्यं दश यन्तो मृजन्ति सप्त धीतीभिः ।\nअभि प्रियमधारयत् ॥ ३ ॥",
        hindiCommentary = """
            यह मंत्र साधक की दस इंद्रियों और सात प्रकार की प्रज्ञाओं द्वारा मन के शुद्धिकरण की सूक्ष्म प्रक्रिया का सुंदर चित्रण करता है। 
            पाँच ज्ञानेंद्रियाँ और पाँच कर्मेंद्रियाँ जब संयमित होती हैं, तभी वे आत्मा के रस को देवताओं के लिए पवित्र और दिव्य बनाती हैं। 
            सात प्रकार की बुद्धियाँ सोम को उस स्तर तक परिष्कृत करती हैं जहाँ वह 'प्रिय' तत्व यानी ईश्वर के दर्शन और मिलन के योग्य बनता है। 
            जब हमारी इंद्रियां और बुद्धि पूरी तरह एकाग्र होती हैं, तभी हम अपने हृदय में दिव्य आनंद को स्थायी रूप से धारण कर पाते हैं। 
            यह मंत्र हमें सिखाता है कि बाहरी कर्मकांड केवल आंतरिक पवित्रता को जाग्रत करने का एक सुंदर और सफल माध्यम मात्र हैं। 
            जैसे सोम छननी से छनकर स्वर्णिम हो जाता है, वैसे ही साधना से तपा हुआ मनुष्य संसार में सत्य और धर्म की दिव्य आभा बिखेरता है। 
            हे देव, आप हमारी समस्त वृत्तियों को पवित्र करें ताकि हम केवल उसी आनंद का पान करें जो शाश्वत, शुद्ध और परम कल्याणकारी है। 
            आपकी उपस्थिति हमारे जीवन के दुखों को हरने वाली वह पावन धारा है जो हमें आध्यात्मिक पूर्णता और शांति की ओर ले जाती है। 
            हम श्रद्धापूर्वक आपकी सेवा में तत्पर रहते हैं ताकि ज्ञान का यह दिव्य प्रवाह हमारे समाज और राष्ट्र को भी निरंतर आलोकित करे। 
            हे पवमान सोम, आप हमारे अंतःकरण के केंद्र में प्रतिष्ठित होकर हमें अज्ञान के समस्त बंधनों से सदा के लिए मुक्त कर देने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            This mantra depicts the subtle process of mind purification through the ten senses and seven types of wisdom or intellect. 
            When the five senses of perception and five of action are disciplined, they purify the soul's essence for the celestial gods. 
            The seven intellects refine the Soma to a level where it becomes worthy of perceiving the 'Beloved'—the Divine Being. 
            Only when our senses and intellect are completely focused can we permanently hold divine bliss within our spiritual heart. 
            This verse teaches us that external rituals are merely a beautiful medium to awaken the profound internal purity of the self. 
            Just as Soma becomes golden after filtration, a human being tempered by practice radiates the brilliance of Truth in the world. 
            O God, sanctify all our mental tendencies so that we may only partake in the bliss that is eternal, pure, and benevolent. 
            Your presence is the holy stream that removes the deep-seated sorrows of life and leads us toward ultimate spiritual perfection. 
            We remain dedicated to your service with devotion so that this divine flow of knowledge illuminates our society and nation constantly. 
            O Pavamana Soma, reside at the center of our inner self and liberate us forever from all the heavy shackles of ignorance.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 4,
        sanskrit = "पुनानः सोम धारया अपो वसानो अर्षसि ।\nआ रत्नधा योनिं ऋतस्य सीदसि ॥ ४ ॥",
        hindiCommentary = """
            पवित्र किया जाता हुआ सोम अपनी दिव्य धारा के साथ जल रूपी वस्त्रों को धारण कर अत्यंत वेगपूर्वक और गरिमा से प्रवाहित होता है। 
            आध्यात्मिक रत्नों और श्रेष्ठ गुणों को प्रदान करने वाला यह सोम 'ऋत' (ब्रह्मांडीय सत्य) के मूल स्थान पर जाकर गौरव से विराजमान होता है। 
            जल यहाँ जीवन की सृजनात्मक ऊर्जा का प्रतीक है, और सोम का उसमें मिलना शक्ति और शांति के अद्भुत समन्वय को साक्षात् दर्शाता है। 
            जैसे सोम ऋत के स्थान पर प्रतिष्ठित होता है, वैसे ही हमारे प्रत्येक संकल्प को भी सत्य, न्याय और धर्म के आधार पर स्थित होना चाहिए। 
            यह मंत्र हमें प्रेरित करता है कि हम अपने जीवन की यात्रा को दिव्यता से ओत-प्रोत करें ताकि हमारा गंतव्य परमात्मा का परम पद हो। 
            आपकी पावन यात्रा हमारे अंतःकरण को शुद्ध करती है और हमें वह 'रत्न' (विवेक) प्रदान करती है जो संसार की किसी भौतिक वस्तु में नहीं है। 
            जब हम आपकी शरण में होते हैं, तब ब्रह्मांड का गूढ़ सत्य हमारे हृदय में स्वतः ही प्रकाशित होने लगता है और हम पूर्णतः शांत हो जाते हैं। 
            आप ही वह शक्ति हैं जो हमारे जीवन के साधारण कर्मों को भी यज्ञीय पवित्रता प्रदान कर उन्हें मोक्ष और महान सफलता का साधन बना देती हैं। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी कृपा की धारा हमारे परिवार और समाज में सदैव अखंड सुख और दिव्य शांति लेकर आए। 
            हे पवमान सोम, आप हमारे शाश्वत मार्गदर्शक बनकर हमें सत्य के साक्षात्कार की ओर सफलतापूर्वक और निर्विघ्न ले जाने की महान कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            The purified Soma flows with its divine stream, appearing as if clothed in the waters as it rushes forward with immense speed. 
            This bestower of spiritual treasures and virtues proceeds to seat himself with great dignity upon the source of the cosmic Truth. 
            Water here is a symbol of the creative energy of life, and its union with Soma represents a marvelous harmony of power and peace. 
            Just as Soma is established at the seat of Truth (Rta), may every resolution of ours also be situated upon the foundations of righteousness. 
            This mantra inspires us to saturate our life's journey with divinity so that our ultimate destination is the supreme state of God. 
            Your holy journey purifies our inner self and endows us with that 'gem' of discernment which is found in no worldly object. 
            When we seek your refuge, the profound Truth of the universe begins to manifest within our hearts naturally, bringing total calm. 
            You are the power that grants sacrificial sanctity even to the ordinary acts of our lives, transforming them into means for liberation. 
            We worship you with devotion so that the stream of your grace brings unbroken happiness and divinity to our families and society. 
            O Pavamana Soma, become our eternal guide and graciously lead us toward the direct realization of Truth, successfully and without hurdle.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 5,
        sanskrit = "विददा यस्ते मयः स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ५ ॥",
        hindiCommentary = """
            हे पवमान सोम! आप आनंद के ज्ञाता हैं और उस दिव्य सुख को प्रदान करने वाले हैं जो केवल आपकी शरण और सान्निध्य में ही संभव है। 
            आप अद्भुत ऐश्वर्यों के स्वामी हैं, कृपया हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली प्रेरणा और पोषण लेकर आएं जो जीवन सफल बनाए। 
            आपकी कृपा से हमारी बुद्धि निरंतर पवित्र हो और हम केवल उन्हीं कार्यों में संलग्न रहें जो समाज और स्वयं के उत्थान के लिए कल्याणकारी हों। 
            जैसे अग्नि अशुद्धियों को नष्ट करती है, वैसे ही आपकी धारा हमारे मानसिक विकारों को धोकर हमें दिव्य शांति और स्पष्टता प्रदान करे। 
            हमें वह आध्यात्मिक संपदा प्रदान करें जो समय के साथ कभी क्षीण न हो, बल्कि निरंतर बढ़ती रहे और हमें ईश्वर के और भी समीप ले जाए। 
            आप ही वह महाशक्ति हैं जो हमारे तुच्छ कर्मों को ईश्वरीय फल तक पहुँचाने की सामर्थ्य रखती हैं और हमारे इस मानवीय जीवन को कृतार्थ करती हैं। 
            आपकी ज्योति हमारे अज्ञान के गहन अंधकार को चीरकर हमें सत्य के मार्ग पर चलने के लिए निरंतर साहस और आत्मबल प्रदान करने वाली है। 
            हम श्रद्धापूर्वक आपके सम्मुख नतमस्तक हैं ताकि आपकी उदारता की वर्षा हमारे घर और परिवार को सुख-समृद्धि से सदा के लिए भर देने वाली हो। 
            हे देव, आप हमारे रक्षक और पालनहार बनकर हमें सदैव सुरक्षित रखें और हमारे कल्याण का मार्ग अपनी दिव्य दृष्टि से निरंतर प्रशस्त करें। 
            इस संपूर्ण ब्रह्मांड में आपकी ही सत्ता और ओज व्याप्त है, हम आपकी शरण में आकर स्वयं को अत्यंत धन्य, सुरक्षित और कृतार्थ अनुभव करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Pavamana Soma, you are the knower of bliss and the provider of that celestial happiness which is only possible in your proximity. 
            You are the sovereign lord of marvelous riches; please bring forth powerful inspiration and nourishment for us, your devoted followers. 
            By your grace, let our intellect be purified so that we engage only in deeds that are beneficial for the upliftment of the self and society. 
            Just as fire destroys physical impurities, may your sacred stream wash away our mental afflictions and grant us profound divine peace. 
            Bestow upon us that spiritual wealth which does not perish with time but grows continuously, leading us closer to the realization of God. 
            You are the supreme power capable of carrying our humble actions to divine results and making our human existence truly meaningful. 
            May your light pierce through the dense darkness of our ignorance and provide us with constant courage and strength to walk the path of Truth. 
            We bow before you with devotion so that the rain of your generosity fills our homes and families with enduring happiness and prosperity. 
            O God, stay as our protector and nourisher, keeping us safe always and paving the way for our ultimate well-being and growth. 
            Your sovereign authority and vigor pervade this entire universe; by seeking your refuge, we feel immensely blessed and fulfilled.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 6,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ६ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें समस्त पापों के भयानक गर्त और अज्ञान के संकटों से निरंतर और पूर्णतः सुरक्षित रखने की अपनी महान कृपा करें। 
            जो भी नकारात्मक शक्तियाँ हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके समस्त षड्यंत्रों को विफल कर हमें अभय दान प्रदान करें। 
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त और पवित्र ज्वालाओं से हमारे भीतर के समस्त दोषों, विकारों और बुराइयों को जड़ से जला डालें। 
            आपकी अग्नि केवल विनाश नहीं करती, बल्कि वह जीवन को एक नई दिशा और पवित्रता प्रदान कर मनुष्य का नया आध्यात्मिक जन्म संपन्न करती है। 
            हम आपकी शरण में आकर सुरक्षा की याचना करते हैं क्योंकि आप ही समस्त लोकों के रक्षक और ब्रह्मांडीय न्याय के सर्वोच्च सजग प्रहरी हैं। 
            हमें वह आत्मबल प्रदान करें जिससे हम कभी भी अधर्म या असत्य के मार्ग पर न चलें और सदैव आपकी दिव्य आज्ञाओं का श्रद्धापूर्वक पालन करें। 
            आपकी ज्योति हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा कवच बनाए जिसे संसार की कोई भी आसुरी शक्ति कभी भेद न सके, यही हमारी प्रार्थना है। 
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की विजय के लिए सदैव तत्पर रहती हैं, हमें भी सत्य का एक सच्चा और निष्ठावान योद्धा बनाने की कृपा करें। 
            जीवन के प्रत्येक संघर्ष में आपकी रक्षात्मक शक्ति का अनुभव हमें अटूट साहस, मानसिक शांति, धैर्य और निरंतर प्रेरणा प्रदान करने वाला होता है। 
            हे अग्नि, आप हमारे परम रक्षक हैं, हमें अज्ञान के अंधकार से ज्ञान के प्रकाश की ओर और मृत्यु के भय से अमरत्व के दिव्य आनंद की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously and continuously protect us from the terrible pit of sins and the calamities arising from ignorance. 
            Those negative forces that wish us harm, please foil all their conspiracies with your supreme intelligence and grant us fearlessness. 
            O Ageless and Radiant Deity, consume all our internal flaws and mental afflictions from the root with your most intensely hot flames. 
            Your fire does not just destroy; it provides life with a new direction and absolute purity, leading toward a new spiritual birth for us. 
            We seek your refuge and pray for security, for you are the guardian of all worlds and the supreme sentinel of cosmic justice and order. 
            Grant us the inner strength and courage to never walk the path of unrighteousness and to always obey your divine and holy commands. 
            Let your light create an impenetrable shield of protection around us that no demonic force or negative thought can ever pierce through. 
            O Most Resplendent One, your flames are ever ready for the victory of Truth; please make us also true and loyal warriors of the Truth. 
            The experience of your protective power in every struggle and test of life gives us unbreakable courage and deep mental peace and calm. 
            O Agni, you are our supreme protector; lead us from the darkness of ignorance to light and from the fear of death to the bliss of immortality.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 7,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ७ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी उत्तम आहुतियों को स्वीकार कर हमें उन शक्तियों से बचाएं जो हमसे ईर्ष्या या द्वेष का भाव रखती हैं। 
            आपकी दिव्य ऊर्जा हमें वह अद्भुत सामर्थ्य प्रदान करे जिससे हम जीवन की समस्त चुनौतियों और विघ्नों का निर्भीकता से सामना कर विजयी हों। 
            हमें वह आंतरिक शुद्धता और मानसिक विशालता दें जिससे हमारे मन में दूसरों के प्रति कभी भी संकीर्णता या बुरी भावना उत्पन्न न होने पाए। 
            हे यविष्ठ्य, आपकी अक्षय शक्ति ही हमारे संपूर्ण जीवन का आधार है, हमें अपनी उस दिव्य सामर्थ्य का एक छोटा अंश प्रदान करने की कृपा करें। 
            यज्ञ की अग्नि में अर्पित हमारी प्रत्येक आहुति आपकी कृपा से ही सिद्ध होती है और हमें वह अभीष्ट फल प्रदान करती है जो परम कल्याणकारी हो। 
            आप हमारे जीवन को पूर्णतः सुरक्षित और समृद्ध बनाने के लिए अपनी पवित्र ज्योति का एक सुरक्षा घेरा हमारे और हमारे परिवार के चारों ओर रखें। 
            द्वेष की भावना मनुष्य की प्रगति को रोककर उसे अंधकार में ढकेल देती है, आप हमें इस अंधकार से निकालकर सफलता और प्रकाश की ओर ले चलें। 
            आपकी मित्रता हमारे लिए वह दिव्य सुरक्षा है जो हमारे मन के समस्त भयों, संशयों और दुखों को सदा के लिए जड़ से समाप्त कर हमें निर्भय बना देती है। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं ताकि हमारा जीवन सदैव निस्वार्थ सेवा और भक्ति में लगा रहे और हम निरंतर आत्मिक रूप से ऊँचा उठें। 
            हे अग्नि, हमें वह तेज दें कि हम स्वयं को धर्म में प्रतिष्ठित रख सकें और मानवता की सेवा करते हुए एक गौरवशाली और सार्थक जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our best offerings, protect us from those forces that harbor envy or malice toward our well-being. 
            May your divine energy provide us with that amazing capability to face all of life's challenges and hurdles with absolute fearlessness. 
            Grant us that internal purity and mental vastness which ensures that no narrowness, hatred, or ill-will ever arises in our minds toward others. 
            O Youngest One, your inexhaustible power is the foundation of our entire existence; grant us a portion of your divine strength and vigor. 
            Every oblation offered in the sacrificial fire is fulfilled by your grace and leads us to the achievement of goals meant for our ultimate welfare. 
            Create a continuous circle of your sacred and holy light around us and our families to make our lives completely secure and prosperous. 
            The feeling of malice halts a person's progress and pushes them into darkness; lead us out of this darkness and toward the path of success. 
            Your friendship is that divine security for us which uproots all the fears, doubts, and sorrows of our wandering mind forever and always. 
            We pray to you with devotion so that our life remains dedicated to service and devotion, helping us to rise spiritually and morally higher. 
            O Agni, give us the luster and vigor to keep ourselves established in Dharma and to lead a glorious life while serving entire humanity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 8,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ८ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य (विवस्वान) के समान तेजस्वी, प्रचंड और जीवनदायी ऐश्वर्य हमारे घर, परिवार और हृदय में लेकर आने की महान कृपा करें। 
            आप हमें वह जीवनी शक्ति और आरोग्य प्रदान करें जिससे हम लंबी आयु तक स्वस्थ और क्रियाशील रहकर श्रेष्ठ धर्म और मानवता के कर्म कर सकें। 
            आप स्वर्ग के अनुपम वैभव और समस्त ब्रह्मांडीय धन के सर्वोच्च अधिपति हैं, हमें वह सुख प्रदान करें जो अविनाशी हो और जो हमें आत्मिक शांति दे। 
            हे पावक, आपकी पवित्रता हमारे रोम-रोम में समा जाए और हमें पूर्णतः निर्मल, कांतिवान और आध्यात्मिक ऊर्जा से ओत-प्रोत बना देने की कृपा करे। 
            आपकी कृपा से हमारे जीवन में किसी भी संसाधन या अन्न की कमी न रहे और हम सदैव दूसरों की सहायता और सेवा करने के लिए पूर्णतः समर्थ रहें। 
            आप केवल बाहरी धन ही नहीं, बल्कि वह प्रज्ञा, विवेक और उच्चतर ज्ञान भी देते हैं जो हमें मोक्ष और परम सत्य के साक्षात्कार के मार्ग पर ले जाता है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा जीवन सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम सदैव आपकी शरण में रहें। 
            हे देव, आप हमारे दुखों की काली छाया को सदा के लिए समाप्त कर हमारे जीवन में हर्ष, आनंद और नवीन उत्साह का दिव्य अमृत निरंतर घोलते रहें। 
            आपकी दीप्ति हमारे अज्ञान के पर्दों को हटाकर हमें वह स्पष्टता प्रदान करे जिससे हम ईश्वर की अनंत सत्ता को पहचान सकें और सदा आंतरिक रूप से शांत रहें। 
            हे अग्नि, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और आध्यात्मिक रूप से पूर्ण बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our homes, families, and hearts a splendor and prosperity as brilliant, fierce, and life-giving as the Sun itself. 
            Provide us with the vital energy and health that allow us to stay healthy and active for a long life to perform noble deeds and serve Dharma. 
            You are the sovereign lord of the unique abundance of heaven and all cosmic wealth; grant us that joy which is imperishable and peaceful. 
            O Purifier, let your holiness permeate every cell of our being, making us completely pure, radiant, and overflowing with spiritual energy. 
            By your grace, let there be no lack of resources or food in our lives, ensuring we are always capable of serving and assisting others in need. 
            You do not just provide external wealth; you also grant that wisdom, discernment, and higher knowledge which lead us toward Truth and liberation. 
            We constantly sing your glories so that our life remains forever illuminated with the light of devotion and knowledge under your divine care. 
            O God, eliminate the dark shadows of our sorrows forever and infuse our lives with the nectar of divine joy, bliss, and renewed enthusiasm. 
            Let your radiance erase the veils of our ignorance and grant us that clarity which enables us to recognize the infinite Reality of the Divine. 
            O Agni, always remain with us as our protector and nourisher, making our lives magnificent, successful, and spiritually complete and whole.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 9,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ ९ ॥",
        hindiCommentary = """
            हे युवा और ऊर्जावान अग्निदेव! आप समस्त प्रकार की समृद्धियों और पुष्टियों के मूल आधार हैं, आप ही उन्हें अपनी दिव्य शक्ति से निरंतर पोषण देते हैं। 
            जब हम बार-बार आपकी स्तुति और वंदना करते हैं, तो हमारी बुद्धि और विचार भी आकाश की तरह अत्यंत विस्तृत, उदार और श्रेष्ठ दिशा की ओर बढ़ने लगते हैं। 
            आपकी असीम कृपा से हमारी मेधा शक्ति और प्रज्ञा प्रखर होती है और हम श्रेष्ठ कार्यों में अपनी बुद्धि का प्रयोग कर लोक-कल्याण के कार्यों में सफल होते हैं। 
            हे यविष्ठ्य, आपकी ऊर्जा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, पूर्णता, आरोग्यता और आत्म-संतोष लाने वाली है, हम आपकी इस शक्ति को नमन करते हैं। 
            आपकी उपासना करने से हमारे सभी नेक संकल्प सिद्ध होते हैं और हमें सर्वांगीण विकास प्राप्त होता है, यही आपकी दिव्यता की वास्तविक और महान महिमा है। 
            जैसे अग्नि समिधा पाकर और अधिक प्रदीप्त और तेजस्वी होती है, वैसे ही हमारी आत्मा आपकी प्रेरणा और सान्निध्य से और अधिक बलवान, पवित्र और ओजस्वी होती है। 
            आप हमें वह मानसिक विशालता प्रदान करें जिससे हम संकुचित स्वार्थों से ऊपर उठकर संपूर्ण विश्व के मंगल और कल्याण के बारे में सदैव सोच सकें। 
            हमारी चेतना को उस उच्च स्तर तक उठाएं जहाँ हम ईश्वर की सर्वव्यापकता का अनुभव कर सकें और प्रत्येक जीव में आपकी ही छवि के साक्षात् दर्शन कर सकें। 
            आप ही वह शक्ति हैं जो हमारे कठिन परिश्रम और ईमानदारी को ईश्वरीय आशीर्वाद में परिवर्तित करने का अद्भुत, अमोघ और तात्कालिक सामर्थ्य रखती हैं। 
            हे अग्नि, हम आपकी बार-बार वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट, समृद्ध, सार्थक, यशस्वी और पूर्णतः धर्ममय बना रहे, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Energetic Agni, you are the foundational source of all forms of prosperity and nourishment; you sustain them with your infinite power. 
            As we repeatedly sing your praises and worship you, our intellect and thoughts become vast like the sky, noble, and oriented toward excellence. 
            By your boundless grace, our mental power and wisdom become sharp, enabling us to use our intellect for noble deeds and global welfare. 
            O Youngest One, your energy is what brings completeness, abundance, and self-contentment into every single field of our existence and being. 
            Worshipping you ensures the fulfillment of all our noble resolutions and grants us all-around development; this is your true divine glory. 
            Just as fire blazes brighter when fueled with wood, our soul becomes stronger and more vibrant under your divine inspiration and proximity. 
            Grant us that mental expansion and generosity which allows us to rise above narrow selfishness and work for the welfare of the entire world. 
            Elevate our consciousness to that high level where we can experience the omnipresence of God and see your image in every living entity we meet. 
            You are the power that possesses the capability to transform our hard labor and honesty into divine blessings and magnificent successes. 
            O Agni, we adore you repeatedly so that our lives remain nourished, prosperous, meaningful, and completely righteous in every aspect.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 10,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ १० ॥",
        hindiCommentary = """
            हे पावक अग्निदेव! आप दिव्य लोकों के स्वामी और समस्त चराचर जगत के ऐश्वर्यों के परम नियंत्रक, अधिपति और अत्यंत उदार प्रदाता के रूप में प्रतिष्ठित हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली प्रेरणा, सात्विक अन्न, स्वास्थ्य और ऊर्जा लेकर आएं जो हमारे जीवन को सफल और ऊर्ध्वगामी बनाए। 
            आपकी असीम कृपा से हमारे जीवन की दरिद्रता और अभावों का नाश हो और हम केवल भौतिक धन ही नहीं, बल्कि श्रेष्ठ मानवीय और दैवीय गुणों के भी धनी बनें। 
            हे देव, आप हमारे अज्ञान को अपनी प्रखर ज्योति से जलाकर हमें वह सत्य मार्ग दिखाएं जहाँ केवल अखंड शांति, निस्वार्थ प्रेम और दिव्य आनंद का वास हो। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे तुच्छ और छोटे कर्मों को ईश्वरीय फल तक पहुँचाती हैं और हमारे इस मानवीय जीवन को कृतार्थ और सार्थक करती हैं। 
            हमें वह 'इषम्' (शक्तिशाली प्रेरणा) प्रदान करें जिससे हमारे शरीर में नवीन उत्साह और मन में सदैव पवित्र और ऊँचे विचारों का अखंड प्रवाह बना रहे। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत और ईश्वर के सान्निध्य के समीप होने लगते हैं। 
            हे अग्नि, आप हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, आरोग्यता और अखंड सौभाग्य प्रदान करने की महान कृपा करने का कष्ट करें। 
            आपकी दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश, कीर्ति और आत्मज्ञान का सही मार्ग निरंतर और सफलतापूर्वक दिखाती रहे। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें वह स्थायी संपत्ति दें जो हमारे इस लोक के साथ-साथ परलोक के मार्ग में भी परम सहायक और सुखद सिद्ध हो।
        """.trimIndent(),
        englishCommentary = """
            O Purifying Agni, you are the Lord of celestial realms and the supreme controller, master, and generous provider of all worldly riches and wealth. 
            For us, your devoted chanters, bring forth that powerful inspiration, virtuous nourishment, and energy that make our lives successful and ascending. 
            By your boundless grace, let our poverty and scarcities be destroyed, making us wealthy not just with money but with superior divine virtues. 
            O God, burn away our ignorance with your intense light and show us the path of truth where only unbroken peace, love, and joy reside. 
            You are the supreme power that carries our humble and small deeds to divine results and makes our human existence truly blessed and fulfilled. 
            Provide us with 'Isham'—powerful inspiration—so that fresh enthusiasm remains in our bodies and noble thoughts flow in our minds. 
            Singing your glories purifies our inner self and initiates our constant spiritual awakening and proximity to the realization of the Divine. 
            O Agni, remove every lack from our lives and graciously grant us completeness, health, and unbroken auspiciousness for our families and homes. 
            Let your radiance illuminate every dark corner of our existence and continuously show us the pathway to fame, splendor, and Self-knowledge. 
            We pray with devotion that you grant us that permanent wealth which assists us both in this world and in our spiritual journey beyond.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 11,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ११ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय यज्ञों, संकल्पों और अनुष्ठानों के मुख्य पुरोहित (होता) और देवताओं को आह्वान करने वाले दिव्य और पवित्र दूत हैं। 
            आप हम मनुष्यों के बीच रहकर भी हमारा अटूट संबंध स्वर्ग के देवताओं से जोड़ते हैं, आप ही वास्तव में हमारे सबसे सच्चे और परम हितैषी रक्षक देव हैं। 
            आपकी पावन उपस्थिति के बिना हमारा कोई भी यज्ञ, संकल्प या शुभ कर्म कभी पूर्ण नहीं हो सकता, क्योंकि आप ही यज्ञ की आत्मा, आधार और केंद्र हैं। 
            हे देव, आप हमारे भीतर दिव्य और सात्विक प्रवृत्तियों का विकास करें और हमें असुरत्व तथा बुराइयों के प्रभाव से सदैव सुरक्षित बचाकर रखने की कृपा करें। 
            आपकी हितकारी दृष्टि हमें पतन और अज्ञान के मार्ग से हटाकर निरंतर प्रगति, आत्मोन्नति, सुख और अखंड शांति की दिशा में सफलतापूर्वक अग्रसर करती है। 
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे समस्त शारीरिक और मानसिक कर्मों को शुद्ध, पवित्र, कल्याणकारी और फलदायी बना दें। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में एकता, प्रेम, सुख-शांति और धार्मिक निष्ठा के मुख्य स्तंभ और सर्वोच्च रक्षक देव के रूप में प्रतिष्ठित हैं। 
            आपकी दिव्य ऊर्जा हमारे प्राणों में चेतना बनकर निरंतर बहती है और हमें सदैव सत्य, न्याय और निस्वार्थ मानवता के मार्ग पर चलने की प्रेरणा प्रदान करती है। 
            हे अग्नि, आप हमारे सर्वोच्च गुरु और मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता का साक्षात् अनुभव करने में पूरी तरह सफल हों। 
            आपकी कृपा से हमारा जीवन दिव्य आशीर्वादों से भरा रहे और हम सदैव मानवता की निस्वार्थ सेवा और धर्म की रक्षा के पुनीत कार्यों में तन्मयता से लगे रहें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest (Hotar) of all human rituals and the divine and holy messenger who invokes the celestial gods to the sacrifice. 
            While residing among us mortals, you connect us with the gods of heaven; you are indeed our most sincere and supreme well-wishing deity. 
            Without your sacred presence, no sacrifice, resolution, or auspicious deed of ours can ever be completed, for you are its very soul and base. 
            O God, develop divine and virtuous tendencies within us and always keep us safely protected from the influence of evil and demonic ways. 
            Your benevolent gaze steers us away from the path of downfall and ignorance, leading us successfully toward progress, joy, and peace. 
            Just as fire consumes and destroys all impurities, please make all our physical and mental actions pure, holy, and beneficial for the world. 
            We worship you because you are the main pillar and protector of unity, love, happiness, and religious devotion within our families and homes. 
            Your divine energy flows through our lives as consciousness, perpetually inspiring us to walk the path of Truth, Justice, and Humanity. 
            O Agni, become our supreme teacher and guide, showing us that Truth where we can successfully experience the omnipresence of the Divine. 
            By your grace, let our lives be filled with divine blessings and let us stay engaged in the holy acts of selfless service and protection of Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 12,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ १२ ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन के समस्त द्वेष, क्रोध, अशांति और संशयों को शांत कर उसे अत्यंत निर्मल, पवित्र और शांत बना देने की महान कृपा करें। 
            आप हमें वह दृढ़, अटल और अडिग श्रद्धा प्रदान करें जिससे हम ईश्वर की न्यायपूर्ण व्यवस्था पर पूर्ण विश्वास कर सकें और सदैव एक सुखमय जीवन जिएं। 
            हमें उन सभी नकारात्मक शक्तियों और विचारों से सुरक्षित रखें जो हमारे मार्ग में बाधा डालती हैं और हमें धर्म के पथ से डिगाना और विचलित करना चाहती हैं। 
            आपकी कृपा से ही मनुष्य का हृदय समस्त जीवों के प्रति निस्वार्थ प्रेम और करुणा से भर जाता है, हमें भी वही विशाल और दयालु हृदय प्रदान करने का कष्ट करें। 
            हे देव, श्रद्धा ही वह दिव्य कुंजी है जिससे ईश्वर के रहस्य प्रकट होते हैं, कृपया हमारे भीतर इस श्रद्धा की ज्योति को सदैव अखंड और जीवित बनाए रखें। 
            हम ईर्ष्या की विनाशकारी आग में जलने के बजाय आपके ज्ञान के प्रकाश में तपकर स्वयं को कुंदन की तरह श्रेष्ठ, तेजस्वी और महान व्यक्तित्व वाला बनाएं। 
            जब हमारा मन आपकी अटूट भक्ति और प्रेम में डूबा होता है, तब संसार का कोई भी अभाव, दुख या पीड़ा हमें अपनी मानसिक शांति से विचलित नहीं कर सकती। 
            आप ही वह शक्ति हैं जो हमारे भीतर के अंधकार को नष्ट कर हमें आत्मज्ञान और ईश्वर के समीप ले जाने वाले वास्तविक मार्ग का साक्षात् दर्शन कराती हैं। 
            हमें वह साहस और अभय प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रहें और निर्भीक होकर एक आदर्श और गौरवशाली मानवीय जीवन व्यतीत करें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम सदैव सात्विक बने रहें और ईश्वर के अनंत आनंद और परम शांति का निरंतर अपने हृदय में अनुभव करते रहें।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please calm all the malice, anger, restlessness, and doubts of our mind, making it extremely pure, holy, and serene. 
            Graciously grant us that firm, unshakable, and steady faith which allows us to trust in the just laws of the Divine and lead a happy life. 
            Protect us from all negative forces and thoughts that place hurdles in our path and attempt to sway us from the path of Dharma. 
            It is only by your grace that a human heart fills with selfless love and compassion for all living beings; grant us such a vast heart. 
            O God, faith is the divine key that reveals the mysteries of the Divine; please keep the flame of this faith always alive and unbroken within us. 
            Instead of burning in the fire of jealousy, let us be refined in the light of your wisdom like pure, radiant, and great gold. 
            When our mind is immersed in your unshakable devotion and love, no worldly scarcity, sorrow, or pain can ever disturb our inner peace. 
            You are the power that destroys our internal darkness and shows us the actual path toward Self-realization and the proximity of God. 
            Bestow upon us the courage and fearlessness required to always be ready for the protection of Dharma and to lead a bold and ideal life. 
            May your merciful gaze remain upon us so that we stay virtuous and continue to experience the infinite bliss and supreme peace of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 13,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ १३ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त, अज्ञान के संकटों और अधर्म के प्रलोभनों से सदैव सुरक्षित रखने की अपनी असीम और महान कृपा हम पर निरंतर बनाए रखें। 
            जो भी नकारात्मक शक्तियाँ या शत्रु हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके समस्त षड्यंत्रों को विफल कर हमें पूर्ण सुरक्षा प्रदान करें। 
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त, पवित्र और प्रखर ज्वालाओं से हमारे भीतर के समस्त दोषों, विकारों और बुराइयों को जड़ से जला डालें। 
            आपकी अग्नि केवल विनाश नहीं करती, बल्कि वह जीवन को एक नई दिशा, नई ऊर्जा और पूर्ण पावनता प्रदान कर मनुष्य का नया आध्यात्मिक जन्म संपन्न करती है। 
            हम आपकी शरण में आकर पूर्ण सुरक्षा की याचना करते हैं क्योंकि आप ही समस्त लोकों के रक्षक, पालनहार और ब्रह्मांडीय न्याय के सर्वोच्च दिव्य प्रहरी हैं। 
            हमें वह आत्मबल और साहस प्रदान करें जिससे हम कभी भी अधर्म या असत्य के मार्ग पर न चलें और सदैव आपकी दिव्य आज्ञाओं का पालन करते रहें। 
            आपकी ज्योति हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा कवच बनाए जिसे संसार की कोई भी आसुरी शक्ति या नकारात्मक विचार कभी भी भेद न सके, यही प्रार्थना है। 
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की विजय और न्याय की स्थापना के लिए सदैव तत्पर रहती हैं, हमें भी सत्य का एक सच्चा और निष्ठावान योद्धा बनाएं। 
            जीवन के प्रत्येक संघर्ष और कठिन परीक्षा में आपकी रक्षात्मक शक्ति का अनुभव हमें अटूट साहस, मानसिक शांति, धैर्य और निरंतर प्रेरणा प्रदान करता है। 
            हे अग्नि, आप हमारे परम रक्षक हैं, हमें अज्ञान के अंधकार से ज्ञान के प्रकाश की ओर और मृत्यु के भय से अमरत्व के दिव्य आनंद की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously and continuously maintain your great protection over us from the terrible pit of sins and the calamities of ignorance. 
            Those negative forces or enemies that wish us harm, please foil all their conspiracies with your supreme intelligence and provide us with security. 
            O Ageless and Radiant Deity, consume all our internal flaws, mental afflictions, and evils from the root with your most intensely hot flames. 
            Your fire does not just destroy; it provides life with a new direction, fresh energy, and absolute purity, leading to a new spiritual birth. 
            We seek your refuge and pray for complete security, for you are the guardian of all worlds and the supreme sentinel of cosmic justice. 
            Grant us the inner strength and courage to never walk the path of unrighteousness or untruth and to always obey your divine commands. 
            Let your light create an impenetrable shield of protection around us that no demonic force or negative thought of the world can ever pierce through. 
            O Most Resplendent One, your flames are ever ready for the victory of Truth; please make us also true and loyal warriors of the Truth. 
            The experience of your protective power in every struggle and difficult test of life gives us unbreakable courage, mental peace, and patience. 
            O Agni, you are our supreme protector; lead us from the darkness of ignorance to light and from the fear of death to the bliss of immortality.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 14,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ १४ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी उत्तम और श्रद्धापूर्ण आहुतियों को स्वीकार कर हमें उन शक्तियों से बचाएं जो हमसे ईर्ष्या या द्वेष का भाव रखती हैं। 
            आपकी दिव्य ऊर्जा हमें वह अद्भुत सामर्थ्य प्रदान करे जिससे हम जीवन की समस्त चुनौतियों और विघ्नों का निर्भीकता से सामना कर सदैव विजयी हो सकें। 
            हमें वह आंतरिक शुद्धता और मानसिक विशालता दें जिससे हमारे मन में दूसरों के प्रति कभी भी संकीर्णता, घृणा या कोई भी बुरी भावना उत्पन्न न होने पाए। 
            हे यविष्ठ्य, आपकी अक्षय और आदि शक्ति ही हमारे संपूर्ण जीवन का आधार है, हमें अपनी उस दिव्य सामर्थ्य का एक छोटा अंश प्रदान करने की महान कृपा करें। 
            यज्ञ की अग्नि में अर्पित हमारी प्रत्येक आहुति आपकी कृपा से ही सिद्ध होती है और हमें वह अभीष्ट फल प्रदान करती है जो हमारे परम मंगल के लिए हो। 
            आप हमारे जीवन को पूर्णतः सुरक्षित और समृद्ध बनाने के लिए अपनी पवित्र ज्योति का एक सुरक्षा घेरा हमारे और हमारे परिवार के चारों ओर निरंतर बनाए रखें। 
            द्वेष की भावना मनुष्य की प्रगति को रोककर उसे अंधकार में ढकेल देती है, आप हमें इस अंधकार से निकालकर सफलता, सुख और प्रकाश की ओर ले चलें। 
            आपकी मित्रता हमारे लिए वह दिव्य सुरक्षा और औषधि है जो हमारे मन के समस्त भयों, संशयों और दुखों को सदा के लिए जड़ से समाप्त कर हमें निर्भय बना देती है। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं ताकि हमारा जीवन सदैव निस्वार्थ सेवा और भक्ति में लगा रहे और हम निरंतर आत्मिक रूप से ऊँचा और श्रेष्ठ उठें। 
            हे अग्नि, हमें वह तेज और ओज दें कि हम स्वयं को धर्म में प्रतिष्ठित रख सकें और मानवता की सेवा करते हुए एक गौरवशाली और सार्थक जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our best and devoted offerings, protect us from those forces that harbor envy or malice toward our well-being. 
            May your divine energy provide us with that amazing capability to face all of life's challenges and hurdles with absolute fearlessness and victory. 
            Grant us that internal purity and mental vastness which ensures that no narrowness, hatred, or ill-will ever arises in our minds toward others. 
            O Youngest One, your inexhaustible and primordial power is the foundation of our entire existence; grant us a portion of your divine strength. 
            Every oblation offered in the sacrificial fire is fulfilled by your grace and leads us to the achievement of goals meant for our ultimate welfare. 
            Create a continuous circle of your sacred and holy light around us and our families to make our lives completely secure and prosperous. 
            The feeling of malice halts a person's progress and pushes them into darkness; lead us out of this darkness and toward the path of success and light. 
            Your friendship is that divine security and medicine for us which uproots all the fears, doubts, and sorrows of our wandering mind forever. 
            We pray to you with devotion so that our life remains dedicated to selfless service and devotion, helping us to rise spiritually and morally higher. 
            O Agni, give us the luster and vigor to keep ourselves established in Dharma and to lead a glorious life while serving entire humanity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 15,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ १५ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य (विवस्वान) के समान तेजस्वी, प्रचंड और जीवनदायी ऐश्वर्य हमारे घर, परिवार और हृदय में लेकर आने की महान कृपा करने का कष्ट करें। 
            आप हमें वह जीवनी शक्ति, ऊर्जा और आरोग्य प्रदान करें जिससे हम लंबी आयु तक स्वस्थ और क्रियाशील रहकर श्रेष्ठ धर्म, ज्ञान और मानवता के कर्म कर सकें। 
            आप स्वर्ग के अनुपम वैभव और समस्त ब्रह्मांडीय धन के सर्वोच्च अधिपति हैं, हमें वह सुख प्रदान करें जो अविनाशी हो और जो हमें अखंड आत्मिक शांति दे। 
            हे पावक, आपकी पवित्रता हमारे रोम-रोम में समा जाए और हमें पूर्णतः निर्मल, कांतिवान और आध्यात्मिक ऊर्जा से ओत-प्रोत बना देने की असीम कृपा करे। 
            आपकी कृपा से हमारे जीवन में किसी भी संसाधन, सुख-सुविधा या अन्न की कमी न रहे और हम सदैव दूसरों की सहायता और सेवा करने के लिए पूर्णतः समर्थ रहें। 
            आप केवल बाहरी धन ही नहीं, बल्कि वह प्रज्ञा, विवेक और उच्चतर ज्ञान भी प्रदान करते हैं जो हमें मोक्ष और परम सत्य के साक्षात्कार के मार्ग पर ले जाता है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा जीवन सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम सदैव आपकी दिव्य शरण में रहें। 
            हे देव, आप हमारे दुखों की काली छाया को सदा के लिए समाप्त कर हमारे जीवन में हर्ष, आनंद और नवीन उत्साह का दिव्य अमृत निरंतर घोलते रहने की कृपा करें। 
            आपकी दीप्ति हमारे अज्ञान के पर्दों को हटाकर हमें वह स्पष्टता प्रदान करे जिससे हम ईश्वर की अनंत सत्ता को पहचान सकें और सदैव आंतरिक रूप से शांत रह सकें। 
            हे अग्नि, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी, धर्मनिष्ठ और आध्यात्मिक रूप से पूर्ण बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our homes, families, and hearts a splendor and prosperity as brilliant, fierce, and life-giving as the Sun itself. 
            Provide us with the vital energy and health that allow us to stay healthy and active for a long life to perform noble deeds and serve knowledge. 
            You are the sovereign lord of the unique abundance of heaven and all cosmic wealth; grant us that joy which is imperishable and peaceful. 
            O Purifier, let your holiness permeate every cell of our being, making us completely pure, radiant, and overflowing with spiritual energy. 
            By your grace, let there be no lack of resources or food in our lives, ensuring we are always capable of serving and assisting others in need. 
            You do not just provide external wealth; you also grant that wisdom, discernment, and higher knowledge which lead us toward Truth and liberation. 
            We constantly sing your glories so that our life remains forever illuminated with the light of devotion and knowledge under your divine care. 
            O God, eliminate the dark shadows of our sorrows forever and infuse our lives with the nectar of divine joy, bliss, and renewed enthusiasm. 
            Let your radiance erase the veils of our ignorance and grant us that clarity which enables us to recognize the infinite Reality of the Divine. 
            O Agni, always remain with us as our protector and nourisher, making our lives magnificent, successful, and spiritually complete.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 16,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ १६ ॥",
        hindiCommentary = """
            हे युवा और ऊर्जावान अग्निदेव! आप समस्त प्रकार की समृद्धियों और पुष्टियों के मूल आधार हैं, आप ही उन्हें अपनी दिव्य शक्ति से निरंतर पोषण और बल देते हैं। 
            जब हम बार-बार आपकी स्तुति और वंदना करते हैं, तो हमारी बुद्धि और विचार भी आकाश की तरह अत्यंत विस्तृत, उदार, तेजस्वी और श्रेष्ठ दिशा की ओर बढ़ने लगते हैं। 
            आपकी असीम कृपा से हमारी मेधा शक्ति और प्रज्ञा प्रखर होती है और हम श्रेष्ठ कार्यों में अपनी बुद्धि का प्रयोग कर लोक-कल्याण के पुनीत कार्यों में सफल होते हैं। 
            हे यविष्ठ्य, आपकी ऊर्जा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, पूर्णता, आरोग्यता और आत्म-संतोष लाने वाली है, हम आपकी इस विराट शक्ति को नमन करते हैं। 
            आपकी उपासना करने से हमारे सभी नेक संकल्प सिद्ध होते हैं और हमें सर्वांगीण विकास प्राप्त होता है, यही आपकी दिव्यता की वास्तविक और महान महिमा है। 
            जैसे अग्नि समिधा पाकर और अधिक प्रदीप्त और तेजस्वी होती है, वैसे ही हमारी आत्मा आपकी प्रेरणा और सान्निध्य से और अधिक बलवान, पवित्र और ओजस्वी होती है। 
            आप हमें वह मानसिक विशालता और उदारता प्रदान करें जिससे हम संकुचित स्वार्थों से ऊपर उठकर संपूर्ण विश्व के मंगल और कल्याण के बारे में सदैव सोच सकें। 
            हमारी चेतना को उस उच्च स्तर तक उठाएं जहाँ हम ईश्वर की सर्वव्यापकता का अनुभव कर सकें और प्रत्येक जीव में आपकी ही छवि के साक्षात् दर्शन कर सकें। 
            आप ही वह शक्ति हैं जो हमारे कठिन परिश्रम और ईमानदारी को ईश्वरीय आशीर्वाद में परिवर्तित करने का अद्भुत, अमोघ और तात्कालिक सामर्थ्य रखती हैं। 
            हे अग्नि, हम आपकी बार-बार वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट, समृद्ध, सार्थक, यशस्वी और पूर्णतः धर्ममय बना रहे, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Energetic Agni, you are the foundational source of all forms of prosperity and nourishment; you sustain them with your infinite power. 
            As we repeatedly sing your praises and worship you, our intellect and thoughts become vast like the sky, noble, and oriented toward excellence. 
            By your boundless grace, our mental power and wisdom become sharp, enabling us to use our intellect for noble deeds and global welfare. 
            O Youngest One, your energy is what brings completeness, abundance, and self-contentment into every single field of our existence and spiritual being. 
            Worshipping you ensures the fulfillment of all our noble resolutions and grants us all-around development; this is your true and magnificent divine glory. 
            Just as fire blazes brighter when fueled with wood, our soul becomes stronger and more vibrant under your divine inspiration and proximity. 
            Grant us that mental expansion and generosity which allows us to rise above narrow selfishness and work for the welfare of the entire world. 
            Elevate our consciousness to that high level where we can experience the omnipresence of God and see your image in every living entity we meet. 
            You are the power that possesses the capability to transform our hard labor and honesty into divine blessings and magnificent successes. 
            O Agni, we adore you repeatedly so that our lives remain nourished, prosperous, meaningful, and completely righteous in every aspect.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 17,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ १७ ॥",
        hindiCommentary = """
            हे पावक अग्निदेव! आप दिव्य लोकों के स्वामी और समस्त चराचर जगत के ऐश्वर्यों के परम नियंत्रक, अधिपति और अत्यंत उदार प्रदाता के रूप में प्रतिष्ठित हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली प्रेरणा, सात्विक अन्न, स्वास्थ्य और ऊर्जा लेकर आएं जो हमारे जीवन को सफल और ऊर्ध्वगामी बनाए। 
            आपकी असीम कृपा से हमारे जीवन की दरिद्रता और अभावों का नाश हो और हम केवल भौतिक धन ही नहीं, बल्कि श्रेष्ठ मानवीय और दैवीय गुणों के भी धनी बनें। 
            हे देव, आप हमारे अज्ञान को अपनी प्रखर ज्योति से जलाकर हमें वह सत्य मार्ग दिखाएं जहाँ केवल अखंड शांति, निस्वार्थ प्रेम और दिव्य आनंद का वास हो। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे तुच्छ और छोटे कर्मों को ईश्वरीय फल तक पहुँचाती हैं और हमारे इस मानवीय जीवन को कृतार्थ और सार्थक करती हैं। 
            हमें वह 'इषम्' (शक्तिशाली प्रेरणा) प्रदान करें जिससे हमारे शरीर में नवीन उत्साह और मन में सदैव पवित्र और ऊँचे विचारों का अखंड प्रवाह बना रहे। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत और ईश्वर के सान्निध्य के समीप होने लगते हैं। 
            हे अग्नि, आप हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, आरोग्यता और अखंड सौभाग्य प्रदान करने की महान कृपा करने का कष्ट करें। 
            आपकी दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश, कीर्ति और आत्मज्ञान का सही मार्ग निरंतर और सफलतापूर्वक दिखाती रहे। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें वह स्थायी संपत्ति दें जो हमारे इस लोक के साथ-साथ परलोक के मार्ग में भी परम सहायक और सुखद सिद्ध हो।
        """.trimIndent(),
        englishCommentary = """
            O Purifying Agni, you are the Lord of celestial realms and the supreme controller, master, and generous provider of all worldly riches and wealth. 
            For us, your devoted chanters, bring forth that powerful inspiration, virtuous nourishment, and energy that make our lives successful and ascending. 
            By your boundless grace, let our poverty and scarcities be destroyed, making us wealthy not just with money but with superior divine virtues. 
            O God, burn away our ignorance with your intense light and show us the path of truth where only unbroken peace, love, and joy reside. 
            You are the supreme power that carries our humble and small deeds to divine results and makes our human existence truly blessed and fulfilled. 
            Provide us with 'Isham'—powerful inspiration—so that fresh enthusiasm remains in our bodies and noble thoughts flow in our minds. 
            Singing your glories purifies our inner self and initiates our constant spiritual awakening and proximity to the realization of the Divine. 
            O Agni, remove every lack from our lives and graciously grant us completeness, health, and unbroken auspiciousness for our families and homes. 
            Let your radiance illuminate every dark corner of our existence and continuously show us the pathway to fame, splendor, and Self-knowledge. 
            We pray with devotion that you grant us that permanent wealth which assists us both in this world and in our spiritual journey beyond.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 18,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ १८ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय यज्ञों, संकल्पों और अनुष्ठानों के मुख्य पुरोहित (होता) और देवताओं को आह्वान करने वाले दिव्य और पवित्र दूत हैं। 
            आप हम मनुष्यों के बीच रहकर भी हमारा अटूट संबंध स्वर्ग के देवताओं से जोड़ते हैं, आप ही वास्तव में हमारे सबसे सच्चे और परम हितैषी रक्षक देव हैं। 
            आपकी पावन उपस्थिति के बिना हमारा कोई भी यज्ञ, संकल्प या शुभ कर्म कभी पूर्ण नहीं हो सकता, क्योंकि आप ही यज्ञ की आत्मा, आधार और केंद्र हैं। 
            हे देव, आप हमारे भीतर दिव्य और सात्विक प्रवृत्तियों का विकास करें और हमें असुरत्व तथा बुराइयों के प्रभाव से सदैव सुरक्षित बचाकर रखने की कृपा करें। 
            आपकी हितकारी दृष्टि हमें पतन और अज्ञान के मार्ग से हटाकर निरंतर प्रगति, आत्मोन्नति, सुख और अखंड शांति की दिशा में सफलतापूर्वक अग्रसर करती है। 
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे समस्त शारीरिक और मानसिक कर्मों को शुद्ध, पवित्र, कल्याणकारी और फलदायी बना दें। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में एकता, प्रेम, सुख-शांति और धार्मिक निष्ठा के मुख्य स्तंभ और सर्वोच्च रक्षक देव के रूप में प्रतिष्ठित हैं। 
            आपकी दिव्य ऊर्जा हमारे प्राणों में चेतना बनकर निरंतर बहती है और हमें सदैव सत्य, न्याय और निस्वार्थ मानवता के मार्ग पर चलने की प्रेरणा प्रदान करती है। 
            हे अग्नि, आप हमारे सर्वोच्च गुरु और मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता का साक्षात् अनुभव करने में पूरी तरह सफल हों। 
            आपकी कृपा से हमारा जीवन दिव्य आशीर्वादों से भरा रहे और हम सदैव मानवता की निस्वार्थ सेवा और धर्म की रक्षा के पुनीत कार्यों में तन्मयता से लगे रहें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest (Hotar) of all human rituals and the divine and holy messenger who invokes the celestial gods to the sacrifice. 
            While residing among us mortals, you connect us with the gods of heaven; you are indeed our most sincere and supreme well-wishing deity. 
            Without your sacred presence, no sacrifice, resolution, or auspicious deed of ours can ever be completed, for you are its very soul and base. 
            O God, develop divine and virtuous tendencies within us and always keep us safely protected from the influence of evil and demonic ways. 
            Your benevolent gaze steers us away from the path of downfall and ignorance, leading us successfully toward progress, joy, and peace. 
            Just as fire consumes and destroys all impurities, please make all our physical and mental actions pure, holy, and beneficial for the world. 
            We worship you because you are the main pillar and protector of unity, love, happiness, and religious devotion within our families and homes. 
            Your divine energy flows through our lives as consciousness, perpetually inspiring us to walk the path of Truth, Justice, and Humanity. 
            O Agni, become our supreme teacher and guide, showing us that Truth where we can successfully experience the omnipresence of the Divine. 
            By your grace, let our lives be filled with divine blessings and let us stay engaged in the holy acts of selfless service and protection of Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 19,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ १९ ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन के समस्त द्वेष, क्रोध, अशांति और संशयों को शांत कर उसे अत्यंत निर्मल, पवित्र और शांत बना देने की महान कृपा करें। 
            आप हमें वह दृढ़, अटल और अडिग श्रद्धा प्रदान करें जिससे हम ईश्वर की न्यायपूर्ण व्यवस्था पर पूर्ण विश्वास कर सकें और सदैव एक सुखमय जीवन जिएं। 
            हमें उन सभी नकारात्मक शक्तियों और विचारों से सुरक्षित रखें जो हमारे मार्ग में बाधा डालती हैं और हमें धर्म के पथ से डिगाना और विचलित करना चाहती हैं। 
            आपकी कृपा से ही मनुष्य का हृदय समस्त जीवों के प्रति निस्वार्थ प्रेम और करुणा से भर जाता है, हमें भी वही विशाल और दयालु हृदय प्रदान करने का कष्ट करें। 
            हे देव, श्रद्धा ही वह दिव्य कुंजी है जिससे ईश्वर के रहस्य प्रकट होते हैं, कृपया हमारे भीतर इस श्रद्धा की ज्योति को सदैव अखंड और जीवित बनाए रखें। 
            हम ईर्ष्या की विनाशकारी आग में जलने के बजाय आपके ज्ञान के प्रकाश में तपकर स्वयं को कुंदन की तरह श्रेष्ठ, तेजस्वी और महान व्यक्तित्व वाला बनाएं। 
            जब हमारा मन आपकी अटूट भक्ति और प्रेम में डूबा होता है, तब संसार का कोई भी अभाव, दुख या पीड़ा हमें अपनी मानसिक शांति से विचलित नहीं कर सकती। 
            आप ही वह शक्ति हैं जो हमारे भीतर के अंधकार को नष्ट कर हमें आत्मज्ञान और ईश्वर के समीप ले जाने वाले वास्तविक मार्ग का साक्षात् दर्शन कराती हैं। 
            हमें वह साहस और अभय प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रहें और निर्भीक होकर एक आदर्श और गौरवशाली मानवीय जीवन व्यतीत करें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम सदैव सात्विक बने रहें और ईश्वर के अनंत आनंद और परम शांति का निरंतर अपने हृदय में अनुभव करते रहें।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please calm all the malice, anger, restlessness, and doubts of our mind, making it extremely pure, holy, and serene. 
            Graciously grant us that firm, unshakable, and steady faith which allows us to trust in the just laws of the Divine and lead a happy life. 
            Protect us from all negative forces and thoughts that place hurdles in our path and attempt to sway us from the path of Dharma. 
            It is only by your grace that a human heart fills with selfless love and compassion for all living beings; grant us such a vast heart. 
            O God, faith is the divine key that reveals the mysteries of the Divine; please keep the flame of this faith always alive and unbroken within us. 
            Instead of burning in the fire of jealousy, let us be refined in the light of your wisdom like pure, radiant, and great gold. 
            When our mind is immersed in your unshakable devotion and love, no worldly scarcity, sorrow, or pain can ever disturb our inner peace. 
            You are the power that destroys our internal darkness and shows us the actual path toward Self-realization and the proximity of God. 
            Bestow upon us the courage and fearlessness required to always be ready for the protection of Dharma and to lead a bold and ideal life. 
            May your merciful gaze remain upon us so that we stay virtuous and continue to experience the infinite bliss and supreme peace of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 20,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ २० ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त, अज्ञान के संकटों और अधर्म के प्रलोभनों से सदैव सुरक्षित रखने की अपनी असीम और महान कृपा हम पर निरंतर बनाए रखें। 
            जो भी नकारात्मक शक्तियाँ या शत्रु हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके समस्त षड्यंत्रों को विफल कर हमें पूर्ण सुरक्षा प्रदान करें। 
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त, पवित्र और प्रखर ज्वालाओं से हमारे भीतर के समस्त दोषों, विकारों और बुराइयों को जड़ से जला डालें। 
            आपकी अग्नि केवल विनाश नहीं करती, बल्कि वह जीवन को एक नई दिशा, नई ऊर्जा और पूर्ण पावनता प्रदान कर मनुष्य का नया आध्यात्मिक जन्म संपन्न करती है। 
            हम आपकी शरण में आकर पूर्ण सुरक्षा की याचना करते हैं क्योंकि आप ही समस्त लोकों के रक्षक, पालनहार और ब्रह्मांडीय न्याय के सर्वोच्च दिव्य प्रहरी हैं। 
            हमें वह आत्मबल और साहस प्रदान करें जिससे हम कभी भी अधर्म या असत्य के मार्ग पर न चलें और सदैव आपकी दिव्य आज्ञाओं का पालन करते रहें। 
            आपकी ज्योति हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा कवच बनाए जिसे संसार की कोई भी आसुरी शक्ति या नकारात्मक विचार कभी भी भेद न सके, यही प्रार्थना है। 
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की विजय और न्याय की स्थापना के लिए सदैव तत्पर रहती हैं, हमें भी सत्य का एक सच्चा और निष्ठावान योद्धा बनाएं। 
            जीवन के प्रत्येक संघर्ष और कठिन परीक्षा में आपकी रक्षात्मक शक्ति का अनुभव हमें अटूट साहस, मानसिक शांति, धैर्य और निरंतर प्रेरणा प्रदान करता है। 
            हे अग्नि, आप हमारे परम रक्षक हैं, हमें अज्ञान के अंधकार से ज्ञान के प्रकाश की ओर और मृत्यु के भय से अमरत्व के दिव्य आनंद की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously and continuously maintain your great protection over us from the terrible pit of sins and the calamities of ignorance. 
            Those negative forces or enemies that wish us harm, please foil all their conspiracies with your supreme intelligence and provide us with security. 
            O Ageless and Radiant Deity, consume all our internal flaws, mental afflictions, and evils from the root with your most intensely hot flames. 
            Your fire does not just destroy; it provides life with a new direction, fresh energy, and absolute purity, leading to a new spiritual birth. 
            We seek your refuge and pray for complete security, for you are the guardian of all worlds and the supreme sentinel of cosmic justice. 
            Grant us the inner strength and courage to never walk the path of unrighteousness or untruth and to always obey your divine commands. 
            Let your light create an impenetrable shield of protection around us that no demonic force or negative thought of the world can ever pierce through. 
            O Most Resplendent One, your flames are ever ready for the victory of Truth; please make us also true and loyal warriors of the Truth. 
            The experience of your protective power in every struggle and difficult test of life gives us unbreakable courage, mental peace, and patience. 
            O Agni, you are our supreme protector; lead us from the darkness of ignorance to light and from the fear of death to the bliss of immortality.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 21,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ २१ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी उत्तम और श्रद्धापूर्ण आहुतियों को स्वीकार कर हमें उन शक्तियों से बचाएं जो हमसे ईर्ष्या या द्वेष का भाव रखती हैं। 
            आपकी दिव्य ऊर्जा हमें वह अद्भुत सामर्थ्य प्रदान करे जिससे हम जीवन की समस्त चुनौतियों और विघ्नों का निर्भीकता से सामना कर सदैव विजयी हो सकें। 
            हमें वह आंतरिक शुद्धता और मानसिक विशालता दें जिससे हमारे मन में दूसरों के प्रति कभी भी संकीर्णता, घृणा या कोई भी बुरी भावना उत्पन्न न होने पाए। 
            हे यविष्ठ्य, आपकी अक्षय और आदि शक्ति ही हमारे संपूर्ण जीवन का आधार है, हमें अपनी उस दिव्य सामर्थ्य का एक छोटा अंश प्रदान करने की महान कृपा करें। 
            यज्ञ की अग्नि में अर्पित हमारी प्रत्येक आहुति आपकी कृपा से ही सिद्ध होती है और हमें वह अभीष्ट फल प्रदान करती है जो हमारे परम मंगल के लिए हो। 
            आप हमारे जीवन को पूर्णतः सुरक्षित और समृद्ध बनाने के लिए अपनी पवित्र ज्योति का एक सुरक्षा घेरा हमारे और हमारे परिवार के चारों ओर निरंतर बनाए रखें। 
            द्वेष की भावना मनुष्य की प्रगति को रोककर उसे अंधकार में ढकेल देती है, आप हमें इस अंधकार से निकालकर सफलता, सुख और प्रकाश की ओर ले चलें। 
            आपकी मित्रता हमारे लिए वह दिव्य सुरक्षा और औषधि है जो हमारे मन के समस्त भयों, संशयों और दुखों को सदा के लिए जड़ से समाप्त कर हमें निर्भय बना देती है। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं ताकि हमारा जीवन सदैव निस्वार्थ सेवा और भक्ति में लगा रहे और हम निरंतर आत्मिक रूप से ऊँचा और श्रेष्ठ उठें। 
            हे अग्नि, हमें वह तेज और ओज दें कि हम स्वयं को धर्म में प्रतिष्ठित रख सकें और मानवता की सेवा करते हुए एक गौरवशाली और सार्थक जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our best and devoted offerings, protect us from those forces that harbor envy or malice toward our well-being. 
            May your divine energy provide us with that amazing capability to face all of life's challenges and hurdles with absolute fearlessness and victory. 
            Grant us that internal purity and mental vastness which ensures that no narrowness, hatred, or ill-will ever arises in our minds toward others. 
            O Youngest One, your inexhaustible and primordial power is the foundation of our entire existence; grant us a portion of your divine strength. 
            Every oblation offered in the sacrificial fire is fulfilled by your grace and leads us to the achievement of goals meant for our ultimate welfare. 
            Create a continuous circle of your sacred and holy light around us and our families to make our lives completely secure and prosperous. 
            The feeling of malice halts a person's progress and pushes them into darkness; lead us out of this darkness and toward the path of success and light. 
            Your friendship is that divine security and medicine for us which uproots all the fears, doubts, and sorrows of our wandering mind forever. 
            We pray to you with devotion so that our life remains dedicated to selfless service and devotion, helping us to rise spiritually and morally higher. 
            O Agni, give us the luster and vigor to keep ourselves established in Dharma and to lead a glorious life while serving entire humanity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 22,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ २२ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य (विवस्वान) के समान तेजस्वी, प्रचंड और जीवनदायी ऐश्वर्य हमारे घर, परिवार और हृदय में लेकर आने की महान कृपा करने का कष्ट करें। 
            आप हमें वह जीवनी शक्ति, ऊर्जा और आरोग्य प्रदान करें जिससे हम लंबी आयु तक स्वस्थ और क्रियाशील रहकर श्रेष्ठ धर्म, ज्ञान और मानवता के कर्म कर सकें। 
            आप स्वर्ग के अनुपम वैभव और समस्त ब्रह्मांडीय धन के सर्वोच्च अधिपति हैं, हमें वह सुख प्रदान करें जो अविनाशी हो और जो हमें अखंड आत्मिक शांति दे। 
            हे पावक, आपकी पवित्रता हमारे रोम-रोम में समा जाए और हमें पूर्णतः निर्मल, कांतिवान और आध्यात्मिक ऊर्जा से ओत-प्रोत बना देने की असीम कृपा करे। 
            आपकी कृपा से हमारे जीवन में किसी भी संसाधन, सुख-सुविधा या अन्न की कमी न रहे और हम सदैव दूसरों की सहायता और सेवा करने के लिए पूर्णतः समर्थ रहें। 
            आप केवल बाहरी धन ही नहीं, बल्कि वह प्रज्ञा, विवेक और उच्चतर ज्ञान भी प्रदान करते हैं जो हमें मोक्ष और परम सत्य के साक्षात्कार के मार्ग पर ले जाता है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा जीवन सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम सदैव आपकी दिव्य शरण में रहें। 
            हे देव, आप हमारे दुखों की काली छाया को सदा के लिए समाप्त कर हमारे जीवन में हर्ष, आनंद और नवीन उत्साह का दिव्य अमृत निरंतर घोलते रहने की कृपा करें। 
            आपकी दीप्ति हमारे अज्ञान के पर्दों को हटाकर हमें वह स्पष्टता प्रदान करे जिससे हम ईश्वर की अनंत सत्ता को पहचान सकें और सदैव आंतरिक रूप से शांत रह सकें। 
            हे अग्नि, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी, धर्मनिष्ठ और आध्यात्मिक रूप से पूर्ण बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our homes, families, and hearts a splendor and prosperity as brilliant, fierce, and life-giving as the Sun itself. 
            Provide us with the vital energy and health that allow us to stay healthy and active for a long life to perform noble deeds and serve knowledge. 
            You are the sovereign lord of the unique abundance of heaven and all cosmic wealth; grant us that joy which is imperishable and peaceful. 
            O Purifier, let your holiness permeate every cell of our being, making us completely pure, radiant, and overflowing with spiritual energy. 
            By your grace, let there be no lack of resources or food in our lives, ensuring we are always capable of serving and assisting others in need. 
            You do not just provide external wealth; you also grant that wisdom, discernment, and higher knowledge which lead us toward Truth and liberation. 
            We constantly sing your glories so that our life remains forever illuminated with the light of devotion and knowledge under your divine care. 
            O God, eliminate the dark shadows of our sorrows forever and infuse our lives with the nectar of divine joy, bliss, and renewed enthusiasm. 
            Let your radiance erase the veils of our ignorance and grant us that clarity which enables us to recognize the infinite Reality of the Divine. 
            O Agni, always remain with us as our protector and nourisher, making our lives magnificent, successful, and spiritually complete.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 23,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ २३ ॥",
        hindiCommentary = """
            हे युवा और ऊर्जावान अग्निदेव! आप समस्त प्रकार की समृद्धियों और पुष्टियों के मूल आधार हैं, आप ही उन्हें अपनी दिव्य शक्ति से निरंतर पोषण और बल देते हैं। 
            जब हम बार-बार आपकी स्तुति और वंदना करते हैं, तो हमारी बुद्धि और विचार भी आकाश की तरह अत्यंत विस्तृत, उदार, तेजस्वी और श्रेष्ठ दिशा की ओर बढ़ने लगते हैं। 
            आपकी असीम कृपा से हमारी मेधा शक्ति और प्रज्ञा प्रखर होती है और हम श्रेष्ठ कार्यों में अपनी बुद्धि का प्रयोग कर लोक-कल्याण के पुनीत कार्यों में सफल होते हैं। 
            हे यविष्ठ्य, आपकी ऊर्जा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, पूर्णता, आरोग्यता और आत्म-संतोष लाने वाली है, हम आपकी इस विराट शक्ति को नमन करते हैं। 
            आपकी उपासना करने से हमारे सभी नेक संकल्प सिद्ध होते हैं और हमें सर्वांगीण विकास प्राप्त होता है, यही आपकी दिव्यता की वास्तविक और महान महिमा है। 
            जैसे अग्नि समिधा पाकर और अधिक प्रदीप्त और तेजस्वी होती है, वैसे ही हमारी आत्मा आपकी प्रेरणा और सान्निध्य से और अधिक बलवान, पवित्र और ओजस्वी होती है। 
            आप हमें वह मानसिक विशालता और उदारता प्रदान करें जिससे हम संकुचित स्वार्थों से ऊपर उठकर संपूर्ण विश्व के मंगल और कल्याण के बारे में सदैव सोच सकें। 
            हमारी चेतना को उस उच्च स्तर तक उठाएं जहाँ हम ईश्वर की सर्वव्यापकता का अनुभव कर सकें और प्रत्येक जीव में आपकी ही छवि के साक्षात् दर्शन कर सकें। 
            आप ही वह शक्ति हैं जो हमारे कठिन परिश्रम और ईमानदारी को ईश्वरीय आशीर्वाद में परिवर्तित करने का अद्भुत, अमोघ और तात्कालिक सामर्थ्य रखती हैं। 
            हे अग्नि, हम आपकी बार-बार वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट, समृद्ध, सार्थक, यशस्वी और पूर्णतः धर्ममय बना रहे, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Energetic Agni, you are the foundational source of all forms of prosperity and nourishment; you sustain them with your infinite power. 
            As we repeatedly sing your praises and worship you, our intellect and thoughts become vast like the sky, noble, and oriented toward excellence. 
            By your boundless grace, our mental power and wisdom become sharp, enabling us to use our intellect for noble deeds and global welfare. 
            O Youngest One, your energy is what brings completeness, abundance, and self-contentment into every single field of our existence and spiritual being. 
            Worshipping you ensures the fulfillment of all our noble resolutions and grants us all-around development; this is your true and magnificent divine glory. 
            Just as fire blazes brighter when fueled with wood, our soul becomes stronger and more vibrant under your divine inspiration and proximity. 
            Grant us that mental expansion and generosity which allows us to rise above narrow selfishness and work for the welfare of the entire world. 
            Elevate our consciousness to that high level where we can experience the omnipresence of God and see your image in every living entity we meet. 
            You are the power that possesses the capability to transform our hard labor and honesty into divine blessings and magnificent successes. 
            O Agni, we adore you repeatedly so that our lives remain nourished, prosperous, meaningful, and completely righteous in every aspect.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 24,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ २४ ॥",
        hindiCommentary = """
            हे पावक अग्निदेव! आप दिव्य लोकों के स्वामी और समस्त चराचर जगत के ऐश्वर्यों के परम नियंत्रक, अधिपति और अत्यंत उदार प्रदाता के रूप में प्रतिष्ठित हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली प्रेरणा, सात्विक अन्न, स्वास्थ्य और ऊर्जा लेकर आएं जो हमारे जीवन को सफल और ऊर्ध्वगामी बनाए। 
            आपकी असीम कृपा से हमारे जीवन की दरिद्रता और अभावों का नाश हो और हम केवल भौतिक धन ही नहीं, बल्कि श्रेष्ठ मानवीय और दैवीय गुणों के भी धनी बनें। 
            हे देव, आप हमारे अज्ञान को अपनी प्रखर ज्योति से जलाकर हमें वह सत्य मार्ग दिखाएं जहाँ केवल अखंड शांति, निस्वार्थ प्रेम और दिव्य आनंद का वास हो। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे तुच्छ और छोटे कर्मों को ईश्वरीय फल तक पहुँचाती हैं और हमारे इस मानवीय जीवन को कृतार्थ और सार्थक करती हैं। 
            हमें वह 'इषम्' (शक्तिशाली प्रेरणा) प्रदान करें जिससे हमारे शरीर में नवीन उत्साह और मन में सदैव पवित्र और ऊँचे विचारों का अखंड प्रवाह बना रहे। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत और ईश्वर के सान्निध्य के समीप होने लगते हैं। 
            हे अग्नि, आप हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, आरोग्यता और अखंड सौभाग्य प्रदान करने की महान कृपा करने का कष्ट करें। 
            आपकी दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश, कीर्ति और आत्मज्ञान का सही मार्ग निरंतर और सफलतापूर्वक दिखाती रहे। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें वह स्थायी संपत्ति दें जो हमारे इस लोक के साथ-साथ परलोक के मार्ग में भी परम सहायक और सुखद सिद्ध हो।
        """.trimIndent(),
        englishCommentary = """
            O Purifying Agni, you are the Lord of celestial realms and the supreme controller, master, and generous provider of all worldly riches and wealth. 
            For us, your devoted chanters, bring forth that powerful inspiration, virtuous nourishment, and energy that make our lives successful and ascending. 
            By your boundless grace, let our poverty and scarcities be destroyed, making us wealthy not just with money but with superior divine virtues. 
            O God, burn away our ignorance with your intense light and show us the path of truth where only unbroken peace, love, and joy reside. 
            You are the supreme power that carries our humble and small deeds to divine results and makes our human existence truly blessed and fulfilled. 
            Provide us with 'Isham'—powerful inspiration—so that fresh enthusiasm remains in our bodies and noble thoughts flow in our minds. 
            Singing your glories purifies our inner self and initiates our constant spiritual awakening and proximity to the realization of the Divine. 
            O Agni, remove every lack from our lives and graciously grant us completeness, health, and unbroken auspiciousness for our families and homes. 
            Let your radiance illuminate every dark corner of our existence and continuously show us the pathway to fame, splendor, and Self-knowledge. 
            We pray with devotion that you grant us that permanent wealth which assists us both in this world and in our spiritual journey beyond.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 25,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ २५ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय यज्ञों, संकल्पों और अनुष्ठानों के मुख्य पुरोहित (होता) और देवताओं को आह्वान करने वाले दिव्य और पवित्र दूत हैं। 
            आप हम मनुष्यों के बीच रहकर भी हमारा अटूट संबंध स्वर्ग के देवताओं से जोड़ते हैं, आप ही वास्तव में हमारे सबसे सच्चे और परम हितैषी रक्षक देव हैं। 
            आपकी पावन उपस्थिति के बिना हमारा कोई भी यज्ञ, संकल्प या शुभ कर्म कभी पूर्ण नहीं हो सकता, क्योंकि आप ही यज्ञ की आत्मा, आधार और केंद्र हैं। 
            हे देव, आप हमारे भीतर दिव्य और सात्विक प्रवृत्तियों का विकास करें और हमें असुरत्व तथा बुराइयों के प्रभाव से सदैव सुरक्षित बचाकर रखने की कृपा करें। 
            आपकी हितकारी दृष्टि हमें पतन और अज्ञान के मार्ग से हटाकर निरंतर प्रगति, आत्मोन्नति, सुख और अखंड शांति की दिशा में सफलतापूर्वक अग्रसर करती है। 
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे समस्त शारीरिक और मानसिक कर्मों को शुद्ध, पवित्र, कल्याणकारी और फलदायी बना दें। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में एकता, प्रेम, सुख-शांति और धार्मिक निष्ठा के मुख्य स्तंभ और सर्वोच्च रक्षक देव के रूप में प्रतिष्ठित हैं। 
            आपकी दिव्य ऊर्जा हमारे प्राणों में चेतना बनकर निरंतर बहती है और हमें सदैव सत्य, न्याय और निस्वार्थ मानवता के मार्ग पर चलने की प्रेरणा प्रदान करती है। 
            हे अग्नि, आप हमारे सर्वोच्च गुरु और मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता का साक्षात् अनुभव करने में पूरी तरह सफल हों। 
            आपकी कृपा से हमारा जीवन दिव्य आशीर्वादों से भरा रहे और हम सदैव मानवता की निस्वार्थ सेवा और धर्म की रक्षा के पुनीत कार्यों में तन्मयता से लगे रहें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest (Hotar) of all human rituals and the divine and holy messenger who invokes the celestial gods to the sacrifice. 
            While residing among us mortals, you connect us with the gods of heaven; you are indeed our most sincere and supreme well-wishing deity. 
            Without your sacred presence, no sacrifice, resolution, or auspicious deed of ours can ever be completed, for you are its very soul and base. 
            O God, develop divine and virtuous tendencies within us and always keep us safely protected from the influence of evil and demonic ways. 
            Your benevolent gaze steers us away from the path of downfall and ignorance, leading us successfully toward progress, joy, and peace. 
            Just as fire consumes and destroys all impurities, please make all our physical and mental actions pure, holy, and beneficial for the world. 
            We worship you because you are the main pillar and protector of unity, love, happiness, and religious devotion within our families and homes. 
            Your divine energy flows through our lives as consciousness, perpetually inspiring us to walk the path of Truth, Justice, and Humanity. 
            O Agni, become our supreme teacher and guide, showing us that Truth where we can successfully experience the omnipresence of the Divine. 
            By your grace, let our lives be filled with divine blessings and let us stay engaged in the holy acts of selfless service and protection of Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 26,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ २६ ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन के समस्त द्वेष, क्रोध, अशांति और संशयों को शांत कर उसे अत्यंत निर्मल, पवित्र और शांत बना देने की महान कृपा करें। 
            आप हमें वह दृढ़, अटल और अडिग श्रद्धा प्रदान करें जिससे हम ईश्वर की न्यायपूर्ण व्यवस्था पर पूर्ण विश्वास कर सकें और सदैव एक सुखमय जीवन जिएं। 
            हमें उन सभी नकारात्मक शक्तियों और विचारों से सुरक्षित रखें जो हमारे मार्ग में बाधा डालती हैं और हमें धर्म के पथ से डिगाना और विचलित करना चाहती हैं। 
            आपकी कृपा से ही मनुष्य का हृदय समस्त जीवों के प्रति निस्वार्थ प्रेम और करुणा से भर जाता है, हमें भी वही विशाल और दयालु हृदय प्रदान करने का कष्ट करें। 
            हे देव, श्रद्धा ही वह दिव्य कुंजी है जिससे ईश्वर के रहस्य प्रकट होते हैं, कृपया हमारे भीतर इस श्रद्धा की ज्योति को सदैव अखंड और जीवित बनाए रखें। 
            हम ईर्ष्या की विनाशकारी आग में जलने के बजाय आपके ज्ञान के प्रकाश में तपकर स्वयं को कुंदन की तरह श्रेष्ठ, तेजस्वी और महान व्यक्तित्व वाला बनाएं। 
            जब हमारा मन आपकी अटूट भक्ति और प्रेम में डूबा होता है, तब संसार का कोई भी अभाव, दुख या पीड़ा हमें अपनी मानसिक शांति से विचलित नहीं कर सकती। 
            आप ही वह शक्ति हैं जो हमारे भीतर के अंधकार को नष्ट कर हमें आत्मज्ञान और ईश्वर के समीप ले जाने वाले वास्तविक मार्ग का साक्षात् दर्शन कराती हैं। 
            हमें वह साहस और अभय प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रहें और निर्भीक होकर एक आदर्श और गौरवशाली मानवीय जीवन व्यतीत करें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम सदैव सात्विक बने रहें और ईश्वर के अनंत आनंद और परम शांति का निरंतर अपने हृदय में अनुभव करते रहें।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please calm all the malice, anger, restlessness, and doubts of our mind, making it extremely pure, holy, and serene. 
            Graciously grant us that firm, unshakable, and steady faith which allows us to trust in the just laws of the Divine and lead a happy life. 
            Protect us from all negative forces and thoughts that place hurdles in our path and attempt to sway us from the path of Dharma. 
            It is only by your grace that a human heart fills with selfless love and compassion for all living beings; grant us such a vast heart. 
            O God, faith is the divine key that reveals the mysteries of the Divine; please keep the flame of this faith always alive and unbroken within us. 
            Instead of burning in the fire of jealousy, let us be refined in the light of your wisdom like pure, radiant, and great gold. 
            When our mind is immersed in your unshakable devotion and love, no worldly scarcity, sorrow, or pain can ever disturb our inner peace. 
            You are the power that destroys our internal darkness and shows us the actual path toward Self-realization and the proximity of God. 
            Bestow upon us the courage and fearlessness required to always be ready for the protection of Dharma and to lead a bold and ideal life. 
            May your merciful gaze remain upon us so that we stay virtuous and continue to experience the infinite bliss and supreme peace of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 27,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ २७ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त, अज्ञान के संकटों और अधर्म के प्रलोभनों से सदैव सुरक्षित रखने की अपनी असीम और महान कृपा हम पर निरंतर बनाए रखें। 
            जो भी नकारात्मक शक्तियाँ या शत्रु हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके समस्त षड्यंत्रों को विफल कर हमें पूर्ण सुरक्षा प्रदान करें। 
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त, पवित्र और प्रखर ज्वालाओं से हमारे भीतर के समस्त दोषों, विकारों और बुराइयों को जड़ से जला डालें। 
            आपकी अग्नि केवल विनाश नहीं करती, बल्कि वह जीवन को एक नई दिशा, नई ऊर्जा और पूर्ण पावनता प्रदान कर मनुष्य का नया आध्यात्मिक जन्म संपन्न करती है। 
            हम आपकी शरण में आकर पूर्ण सुरक्षा की याचना करते हैं क्योंकि आप ही समस्त लोकों के रक्षक, पालनहार और ब्रह्मांडीय न्याय के सर्वोच्च दिव्य प्रहरी हैं। 
            हमें वह आत्मबल और साहस प्रदान करें जिससे हम कभी भी अधर्म या असत्य के मार्ग पर न चलें और सदैव आपकी दिव्य आज्ञाओं का पालन करते रहें। 
            आपकी ज्योति हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा कवच बनाए जिसे संसार की कोई भी आसुरी शक्ति या नकारात्मक विचार कभी भी भेद न सके, यही प्रार्थना है। 
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की विजय और न्याय की स्थापना के लिए सदैव तत्पर रहती हैं, हमें भी सत्य का एक सच्चा और निष्ठावान योद्धा बनाएं। 
            जीवन के प्रत्येक संघर्ष और कठिन परीक्षा में आपकी रक्षात्मक शक्ति का अनुभव हमें अटूट साहस, मानसिक शांति, धैर्य और निरंतर प्रेरणा प्रदान करता है। 
            हे अग्नि, आप हमारे परम रक्षक हैं, हमें अज्ञान के अंधकार से ज्ञान के प्रकाश की ओर और मृत्यु के भय से अमरत्व के दिव्य आनंद की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously and continuously maintain your great protection over us from the terrible pit of sins and the calamities of ignorance. 
            Those negative forces or enemies that wish us harm, please foil all their conspiracies with your supreme intelligence and provide us with security. 
            O Ageless and Radiant Deity, consume all our internal flaws, mental afflictions, and evils from the root with your most intensely hot flames. 
            Your fire does not just destroy; it provides life with a new direction, fresh energy, and absolute purity, leading to a new spiritual birth. 
            We seek your refuge and pray for complete security, for you are the guardian of all worlds and the supreme sentinel of cosmic justice. 
            Grant us the inner strength and courage to never walk the path of unrighteousness or untruth and to always obey your divine commands. 
            Let your light create an impenetrable shield of protection around us that no demonic force or negative thought of the world can ever pierce through. 
            O Most Resplendent One, your flames are ever ready for the victory of Truth; please make us also true and loyal warriors of the Truth. 
            The experience of your protective power in every struggle and difficult test of life gives us unbreakable courage, mental peace, and patience. 
            O Agni, you are our supreme protector; lead us from the darkness of ignorance to light and from the fear of death to the bliss of immortality.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 28,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ २८ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी उत्तम और श्रद्धापूर्ण आहुतियों को स्वीकार कर हमें उन शक्तियों से बचाएं जो हमसे ईर्ष्या या द्वेष का भाव रखती हैं। 
            आपकी दिव्य ऊर्जा हमें वह अद्भुत सामर्थ्य प्रदान करे जिससे हम जीवन की समस्त चुनौतियों और विघ्नों का निर्भीकता से सामना कर सदैव विजयी हो सकें। 
            हमें वह आंतरिक शुद्धता और मानसिक विशालता दें जिससे हमारे मन में दूसरों के प्रति कभी भी संकीर्णता, घृणा या कोई भी बुरी भावना उत्पन्न न होने पाए। 
            हे यविष्ठ्य, आपकी अक्षय और आदि शक्ति ही हमारे संपूर्ण जीवन का आधार है, हमें अपनी उस दिव्य सामर्थ्य का एक छोटा अंश प्रदान करने की महान कृपा करें। 
            यज्ञ की अग्नि में अर्पित हमारी प्रत्येक आहुति आपकी कृपा से ही सिद्ध होती है और हमें वह अभीष्ट फल प्रदान करती है जो हमारे परम मंगल के लिए हो। 
            आप हमारे जीवन को पूर्णतः सुरक्षित और समृद्ध बनाने के लिए अपनी पवित्र ज्योति का एक सुरक्षा घेरा हमारे और हमारे परिवार के चारों ओर निरंतर बनाए रखें। 
            द्वेष की भावना मनुष्य की प्रगति को रोककर उसे अंधकार में ढकेल देती है, आप हमें इस अंधकार से निकालकर सफलता, सुख और प्रकाश की ओर ले चलें। 
            आपकी मित्रता हमारे लिए वह दिव्य सुरक्षा और औषधि है जो हमारे मन के समस्त भयों, संशयों और दुखों को सदा के लिए जड़ से समाप्त कर हमें निर्भय बना देती है। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं ताकि हमारा जीवन सदैव निस्वार्थ सेवा और भक्ति में लगा रहे और हम निरंतर आत्मिक रूप से ऊँचा और श्रेष्ठ उठें। 
            हे अग्नि, हमें वह तेज और ओज दें कि हम स्वयं को धर्म में प्रतिष्ठित रख सकें और मानवता की सेवा करते हुए एक गौरवशाली और सार्थक जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our best and devoted offerings, protect us from those forces that harbor envy or malice toward our well-being. 
            May your divine energy provide us with that amazing capability to face all of life's challenges and hurdles with absolute fearlessness and victory. 
            Grant us that internal purity and mental vastness which ensures that no narrowness, hatred, or ill-will ever arises in our minds toward others. 
            O Youngest One, your inexhaustible and primordial power is the foundation of our entire existence; grant us a portion of your divine strength. 
            Every oblation offered in the sacrificial fire is fulfilled by your grace and leads us to the achievement of goals meant for our ultimate welfare. 
            Create a continuous circle of your sacred and holy light around us and our families to make our lives completely secure and prosperous. 
            The feeling of malice halts a person's progress and pushes them into darkness; lead us out of this darkness and toward the path of success and light. 
            Your friendship is that divine security and medicine for us which uproots all the fears, doubts, and sorrows of our wandering mind forever. 
            We pray to you with devotion so that our life remains dedicated to selfless service and devotion, helping us to rise spiritually and morally higher. 
            O Agni, give us the luster and vigor to keep ourselves established in Dharma and to lead a glorious life while serving entire humanity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 29,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ २९ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य (विवस्वान) के समान तेजस्वी, प्रचंड और जीवनदायी ऐश्वर्य हमारे घर, परिवार और हृदय में लेकर आने की महान कृपा करने का कष्ट करें। 
            आप हमें वह जीवनी शक्ति, ऊर्जा और आरोग्य प्रदान करें जिससे हम लंबी आयु तक स्वस्थ और क्रियाशील रहकर श्रेष्ठ धर्म, ज्ञान और मानवता के कर्म कर सकें। 
            आप स्वर्ग के अनुपम वैभव और समस्त ब्रह्मांडीय धन के सर्वोच्च अधिपति हैं, हमें वह सुख प्रदान करें जो अविनाशी हो और जो हमें अखंड आत्मिक शांति दे। 
            हे पावक, आपकी पवित्रता हमारे रोम-रोम में समा जाए और हमें पूर्णतः निर्मल, कांतिवान और आध्यात्मिक ऊर्जा से ओत-प्रोत बना देने की असीम कृपा करे। 
            आपकी कृपा से हमारे जीवन में किसी भी संसाधन, सुख-सुविधा या अन्न की कमी न रहे और हम सदैव दूसरों की सहायता और सेवा करने के लिए पूर्णतः समर्थ रहें। 
            आप केवल बाहरी धन ही नहीं, बल्कि वह प्रज्ञा, विवेक और उच्चतर ज्ञान भी प्रदान करते हैं जो हमें मोक्ष और परम सत्य के साक्षात्कार के मार्ग पर ले जाता है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा जीवन सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम सदैव आपकी दिव्य शरण में रहें। 
            हे देव, आप हमारे दुखों की काली छाया को सदा के लिए समाप्त कर हमारे जीवन में हर्ष, आनंद और नवीन उत्साह का दिव्य अमृत निरंतर घोलते रहने की कृपा करें। 
            आपकी दीप्ति हमारे अज्ञान के पर्दों को हटाकर हमें वह स्पष्टता प्रदान करे जिससे हम ईश्वर की अनंत सत्ता को पहचान सकें और सदैव आंतरिक रूप से शांत रह सकें। 
            हे अग्नि, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी, धर्मनिष्ठ और आध्यात्मिक रूप से पूर्ण बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our homes, families, and hearts a splendor and prosperity as brilliant, fierce, and life-giving as the Sun itself. 
            Provide us with the vital energy and health that allow us to stay healthy and active for a long life to perform noble deeds and serve knowledge. 
            You are the sovereign lord of the unique abundance of heaven and all cosmic wealth; grant us that joy which is imperishable and peaceful. 
            O Purifier, let your holiness permeate every cell of our being, making us completely pure, radiant, and overflowing with spiritual energy. 
            By your grace, let there be no lack of resources or food in our lives, ensuring we are always capable of serving and assisting others in need. 
            You do not just provide external wealth; you also grant that wisdom, discernment, and higher knowledge which lead us toward Truth and liberation. 
            We constantly sing your glories so that our life remains forever illuminated with the light of devotion and knowledge under your divine care. 
            O God, eliminate the dark shadows of our sorrows forever and infuse our lives with the nectar of divine joy, bliss, and renewed enthusiasm. 
            Let your radiance erase the veils of our ignorance and grant us that clarity which enables us to recognize the infinite Reality of the Divine. 
            O Agni, always remain with us as our protector and nourisher, making our lives magnificent, successful, and spiritually complete.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 30,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ ३० ॥",
        hindiCommentary = """
            हे युवा और ऊर्जावान अग्निदेव! आप समस्त प्रकार की समृद्धियों और पुष्टियों के मूल आधार हैं, आप ही उन्हें अपनी दिव्य शक्ति से निरंतर पोषण और बल देते हैं। 
            जब हम बार-बार आपकी स्तुति और वंदना करते हैं, तो हमारी बुद्धि और विचार भी आकाश की तरह अत्यंत विस्तृत, उदार, तेजस्वी और श्रेष्ठ दिशा की ओर बढ़ने लगते हैं। 
            आपकी असीम कृपा से हमारी मेधा शक्ति और प्रज्ञा प्रखर होती है और हम श्रेष्ठ कार्यों में अपनी बुद्धि का प्रयोग कर लोक-कल्याण के पुनीत कार्यों में सफल होते हैं। 
            हे यविष्ठ्य, आपकी ऊर्जा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, पूर्णता, आरोग्यता और आत्म-संतोष लाने वाली है, हम आपकी इस विराट शक्ति को नमन करते हैं। 
            आपकी उपासना करने से हमारे सभी नेक संकल्प सिद्ध होते हैं और हमें सर्वांगीण विकास प्राप्त होता है, यही आपकी दिव्यता की वास्तविक और महान महिमा है। 
            जैसे अग्नि समिधा पाकर और अधिक प्रदीप्त और तेजस्वी होती है, वैसे ही हमारी आत्मा आपकी प्रेरणा और सान्निध्य से और अधिक बलवान, पवित्र और ओजस्वी होती है। 
            आप हमें वह मानसिक विशालता और उदारता प्रदान करें जिससे हम संकुचित स्वार्थों से ऊपर उठकर संपूर्ण विश्व के मंगल और कल्याण के बारे में सदैव सोच सकें। 
            हमारी चेतना को उस उच्च स्तर तक उठाएं जहाँ हम ईश्वर की सर्वव्यापकता का अनुभव कर सकें और प्रत्येक जीव में आपकी ही छवि के साक्षात् दर्शन कर सकें। 
            आप ही वह शक्ति हैं जो हमारे कठिन परिश्रम और ईमानदारी को ईश्वरीय आशीर्वाद में परिवर्तित करने का अद्भुत, अमोघ और तात्कालिक सामर्थ्य रखती हैं। 
            हे अग्नि, हम आपकी बार-बार वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट, समृद्ध, सार्थक, यशस्वी और पूर्णतः धर्ममय बना रहे, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Energetic Agni, you are the foundational source of all forms of prosperity and nourishment; you sustain them with your infinite power. 
            As we repeatedly sing your praises and worship you, our intellect and thoughts become vast like the sky, noble, and oriented toward excellence. 
            By your boundless grace, our mental power and wisdom become sharp, enabling us to use our intellect for noble deeds and global welfare. 
            O Youngest One, your energy is what brings completeness, abundance, and self-contentment into every single field of our existence and spiritual being. 
            Worshipping you ensures the fulfillment of all our noble resolutions and grants us all-around development; this is your true and magnificent divine glory. 
            Just as fire blazes brighter when fueled with wood, our soul becomes stronger and more vibrant under your divine inspiration and proximity. 
            Grant us that mental expansion and generosity which allows us to rise above narrow selfishness and work for the welfare of the entire world. 
            Elevate our consciousness to that high level where we can experience the omnipresence of God and see your image in every living entity we meet. 
            You are the power that possesses the capability to transform our hard labor and honesty into divine blessings and magnificent successes. 
            O Agni, we adore you repeatedly so that our lives remain nourished, prosperous, meaningful, and completely righteous in every aspect.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 31,
        sanskrit = "तं घेमित्था नमस्विन उप स्वराजमासते ।\nहोत्रभिरिन्द्रं वावृधुः ॥ ३१ ॥",
        hindiCommentary = """
            हे साधकों! जो इन्द्रदेव स्वयं के प्रकाश में प्रतिष्ठित (स्वराजम्) और पूर्णतः स्वतंत्र हैं, श्रद्धालु भक्त उनकी परम उपासना करते हैं। 
            वे 'होता' के पवित्र आह्वान और यज्ञीय आहुतियों के माध्यम से निरंतर प्रदीप्त होकर भक्तों के अंतःकरण में संवर्धित किए जाते हैं। 
            इन्द्र की यह 'स्वराज' अवस्था हमें आत्म-संयम, आत्म-निर्भरता और वास्तविक आत्म-बोध का महान आध्यात्मिक संदेश प्रदान करती है। 
            जब हम अपनी दसों इंद्रियों के स्वामी स्वयं बन जाते हैं, तब हम अपने भीतर इन्द्र के उस दिव्य और तेजस्वी स्वरूप का अनुभव कर सकते हैं। 
            यज्ञ की पावन अग्नि में समर्पित प्रत्येक सात्विक विचार इन्द्र के बल को बढ़ाता है, जो अंततः ब्रह्मांडीय संतुलन के रूप में हमारे ही कल्याण हेतु आता है। 
            हे देव, आप अपनी असीम महिमा के साथ हमारे जीवन के प्रत्येक कठिन कार्य में सहायक बनकर हमें पूर्ण सफलता की ओर सफलतापूर्वक ले जाएं। 
            आपकी निरंतर उपासना से हमारे मन के समस्त संशय और भय दूर होते हैं और हमें वह दिव्य स्पष्टता प्राप्त होती है जिससे हम सत्य को जान सकें। 
            हम श्रद्धापूर्वक आपके चरणों में नतमस्तक हैं ताकि आपकी न्यायपूर्ण और दयालु दृष्टि हमें सदैव धर्म और उन्नति के मार्ग पर अग्रसर रखे। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे सूक्ष्म संकल्पों को ब्रह्मांडीय सिद्धियों और भौतिक एवं आध्यात्मिक प्रचुरता में बदलने का सामर्थ्य रखती हैं। 
            हे इन्द्र, आप हमारे रक्षक और स्वामी बनकर हमें अज्ञान के अंधकार से निकालकर दिव्यता के सर्वोच्च प्रकाश की ओर सफलतापूर्वक ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O seekers, those filled with deep reverence sit before Lord Indra, who is self-radiant and established in his own sovereignty. 
            He is continuously increased and glorified through the sacred calls of the priests and the sincere sacrificial offerings of the followers. 
            This state of 'Svaraj' or self-sovereignty by Indra provides a great spiritual message of self-control and self-reliance to all of humanity. 
            When we become the true masters of our own senses, we can experience that divine and radiant aspect of Indra within our consciousness. 
            Every oblation offered in the sacrificial fire increases Indra's strength, which ultimately returns to us as cosmic balance and welfare. 
            O God, with your infinite majesty, become our helper in every daunting task of our life and lead us toward magnificent success. 
            Worshipping you consistently removes the doubts of our minds and grants us the divine clarity required to perceive the Eternal Truth. 
            We bow before you with devotion so that your just and merciful gaze continuously steers us toward the path of progress and evolution. 
            You are the ultimate power that possesses the capability to transform our subtle intentions into cosmic achievements and material plenty. 
            O Indra, stay with us as our protector and Lord; pull us out of the darkness of ignorance toward the highest light of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 32,
        sanskrit = "आ तू न इन्द्र मद्र्यग् घृवाणो वृषन् आ गहि ।\nमहाँ महीभिः ऊतिभिः ॥ ३२ ॥",
        hindiCommentary = """
            हे असीम शक्ति के स्वामी इन्द्रदेव! आप हमारी प्रार्थनाओं से प्रसन्न होकर हमारे प्रति दयालु भाव रखते हुए यहाँ कृपापूर्वक पधारें। 
            आप अपनी महान और अत्यंत विशाल रक्षात्मक शक्तियों के साथ हमारे जीवन के इस यज्ञ में सहायक और रक्षक बनकर साक्षात् आएं। 
            आपकी पावन उपस्थिति हमारे भीतर के सुप्त आत्मविश्वास को जागृत करती है और हमें कठिन परिस्थितियों से लड़ने का अद्भुत साहस प्रदान करती है। 
            जब आप हमारे पक्ष में खड़े होते हैं, तो संसार की कोई भी नकारात्मक शक्ति या मानसिक क्लेश हमें पराजित करने का साहस नहीं कर सकता। 
            हे देवराज, आप हमारे अज्ञान रूपी अंधकार को अपनी प्रखर ज्योति से मिटाकर हमारे जीवन में ज्ञान और विवेक का प्रकाश चारों ओर फैलाएं। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा सुरक्षा दुर्ग बनाती हैं जिसमें केवल सुख, शांति और पवित्रता का ही निरंतर वास होता है। 
            हम अपनी विनम्र पुकार से आपको बुलाते हैं ताकि आप हमारे जीवन के प्रत्येक सूक्ष्म अभाव को अपनी अनंत उदारता और वैभव से पूर्ण कर दें। 
            आप ही वह सर्वोच्च सत्ता हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें आध्यात्मिक उन्नति के पथ पर निरंतर आगे बढ़ाती हैं। 
            हे इन्द्र, आप अपनी दिव्य महिमा के साथ हमारे घर और हृदय में विराजें और हमें सदैव अपनी अजेय सुरक्षा की शीतल और पावन छाया में रखें। 
            आपकी कृपा दृष्टि से हमारा परम कल्याण सुनिश्चित है, हम आपकी इस भव्य और अजेय शक्ति की बार-बार श्रद्धापूर्वक वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, the master of infinite power, being pleased by our sincere prayers and harboring a kind intent, please manifest here. 
            Arrive in our lives as a helper and guardian, accompanied by your grand and immensely vast protective divine powers and assists. 
            Your sacred presence awakens the latent self-confidence within us and grants us the courage required to battle difficult situations. 
            When you stand on our side, no negative force of the world or any mental affliction can ever dare to defeat or disturb our peace. 
            O King of Gods, erase the darkness of our ignorance with your intense light and spread the radiance of wisdom and discernment in our lives. 
            Your protective energies build such an impenetrable fortress of security around us, within which only happiness and purity reside. 
            We invoke you with our humble cries so that you may fulfill every single scarcity of our existence with your infinite generosity. 
            You are the supreme authority that makes our hard work meaningful and continuously drives us forward on the path of growth. 
            O Indra, reside in our homes and hearts with your divine glory and keep us forever safe under the shadow of your protection. 
            Our ultimate well-being and auspiciousness are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 33,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ ३३ ॥",
        hindiCommentary = """
            समस्त स्तुतियां और प्रार्थनाएं समुद्र के समान विशाल और सर्वव्यापी इन्द्रदेव की महिमा को निरंतर बढ़ाती और संसार में प्रकाशित करती हैं। 
            वे दिव्य रथियों में सर्वश्रेष्ठ और समस्त विजयों के अधिपति हैं, जिनकी बार-बार अत्यंत श्रद्धा के साथ प्रशंसा और वंदना की जानी चाहिए। 
            इन्द्र की व्यापकता आकाश और समुद्र की तरह अनंत है, जिसमें संपूर्ण ब्रह्मांड की शक्तियाँ सुरक्षित और पूर्णतः समाहित रहती हैं। 
            वे हमारे जीवन रूपी रथ के सबसे कुशल सारथी हैं, जो हमें संसार की बाधाओं के बीच से सफलतापूर्वक और निर्विघ्न निकाल ले जाते हैं। 
            हे देव, आप अपनी प्रचंड शक्ति और अपार बुद्धिमत्ता से हमारे प्रत्येक प्रयास को सफलता के उच्चतम शिखर तक पहुँचाने की कृपा करें। 
            हमें वह आध्यात्मिक और भौतिक शक्ति प्रदान करें जिससे हम निर्बलों की सहायता कर सकें और धर्म की ध्वजा को सदैव ऊँचा रख सकें। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जाग्रत और पवित्र होने लगते हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी भी पराजित नहीं होता, क्योंकि स्वयं ब्रह्मांड का नायक उसका सहायक और मित्र बन जाता है। 
            आपकी दिव्य दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और सच्ची कीर्ति का मार्ग निरंतर दिखाए। 
            हे इन्द्र, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और सुखी बनाने की महान कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            All the hymns and prayers continuously increase and illuminate the glory of Lord Indra, who is as vast and all-encompassing as the ocean. 
            He is the foremost among divine charioteers and the Lord of all victories, worthy of being praised and glorified with deep devotion. 
            The expanse of Indra's presence is infinite like the sky and the sea, within which all cosmic powers are safely contained. 
            He is the most skillful charioteer of our life's vessel, guiding us expertly and safely through the various obstacles of the world. 
            O God, with your fierce power and immense wisdom, graciously lead our every effort to the absolute peak of success and excellence. 
            Bestow upon us both spiritual and material power so that we can assist the weak and keep the flag of righteousness flying high. 
            The continuous singing of your glories completely purifies our inner self and initiates our constant spiritual awakening and awareness. 
            A seeker who takes refuge in Lord Indra is never defeated, for the hero of the entire universe becomes their personal helper and friend. 
            Let your divine radiance illuminate every dark corner of our existence and show us the pathway to fame, splendor, and true glory. 
            O Indra, always remain with us as our protector and nourisher, graciously making our lives magnificent, successful, and truly happy.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 34,
        sanskrit = "एवा ह्यासि वीरयुरेतदस्मासु धेहि ।\nमहाँ हि शतक्रतो ॥ ३४ ॥",
        hindiCommentary = """
            हे शतक्रतो इन्द्र! आप वास्तव में वीरता और पराक्रम के प्रेमी हैं, कृपया हमारे भीतर भी वही अटूट वीरता और साहस स्थापित करें। 
            आप अत्यंत महान और तेजस्वी हैं, हमारे जीवन के श्रेष्ठ संकल्पों को दृढ़ता प्रदान करें ताकि हम धर्म की रक्षा के लिए सदैव तत्पर रहें। 
            सच्ची वीरता वह नहीं जो केवल बाह्य युद्ध में दिखे, बल्कि वह है जो हमें अपने विकारों और शत्रुओं पर विजय पाने की शक्ति प्रदान करती है। 
            आपकी कृपा से हमें वह ओज और तेज प्राप्त हो जिससे हम समाज में सत्य और न्याय का मार्ग प्रशस्त करने वाले योद्धा बन सकें। 
            हे देवराज, आप हमारे भीतर के प्रत्येक सूक्ष्म डर को समाप्त कर हमें पूर्णतः निर्भीक और आत्मविश्वासी बनाने की महान कृपा करें। 
            जब आप हमारे हृदय में साहस का बीज बोते हैं, तब संसार की कोई भी प्रतिकूल परिस्थिति हमें अपने मार्ग से विचलित नहीं कर सकती। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी महानता का एक अंश हमारे चरित्र में भी झलके और हम मानवता के लिए श्रेष्ठ बनें। 
            आप ही वह शक्ति हैं जो हमारे शिथिल मन में नवीन ऊर्जा का संचार कर हमें निरंतर कर्मयोग की ओर सफलतापूर्वक अग्रसर करती हैं। 
            हे इन्द्र, हमें वह आध्यात्मिक सामर्थ्य दें कि हम सांसारिक प्रलोभनों से ऊपर उठकर ईश्वर के वास्तविक और शाश्वत सत्य स्वरूप को पा सकें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके संरक्षण में सदैव निर्भय होकर एक गौरवशाली और सार्थक जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Shatakratu Indra, you are truly the lover of heroism and valor; please instill that same valor and unshakable courage within us. 
            You are exceedingly great and radiant; grant firmness to the noble resolutions of our lives so that we are always ready for the defense of Dharma. 
            True heroism is not just seen in physical external war, but in the power that enables us to conquer our own inner flaws and weaknesses. 
            By your grace, let us receive that vigor and luster which transform us into warriors who pave the way for Truth and Justice in society. 
            O King of Gods, graciously terminate every subtle fear within us and make us completely fearless, steady, and self-confident. 
            When you sow the seed of courage in our hearts, no adverse circumstance of the world can ever sway or disturb our peace of mind. 
            We worship you with devotion so that a fraction of your greatness reflects in our character and we become superior beings for humanity. 
            You are the power that infuses fresh energy into our lethargic minds, pushing us successfully toward the path of dedicated action. 
            O Indra, give us the spiritual capability to rise above worldly temptations and attain the true essence of the Divine and Eternal Truth. 
            May your merciful gaze always remain upon us as we lead a glorious and meaningful life successfully under your supreme divine protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 35,
        sanskrit = "तमिन्द्रं वाजयामसि महे वृत्राय हन्तवे ।\nस वृषा वृषभो बभूविथ ॥ ३५ ॥",
        hindiCommentary = """
            हम उन इन्द्रदेव को बल और सामर्थ्य प्रदान करने वाली स्तुतियां अर्पित करते हैं ताकि वे महान शत्रु वृत्रासुर का समूल वध कर सकें। 
            वे स्वयं असीम शक्ति के पुंज और श्रेष्ठ वीरों में भी सर्वश्रेष्ठ हैं, जो अधर्म का नाश करने के लिए सदैव दिव्य शस्त्र धारण किए रहते हैं। 
            भक्तों की श्रद्धापूर्ण प्रार्थनाएं इन्द्र के वज्र को और अधिक प्रखर बनाती हैं, जिससे वे संसार की समस्त बाधाओं को नष्ट करने में सक्षम होते हैं। 
            वृत्र केवल एक पौराणिक राक्षस नहीं, बल्कि हमारे मार्ग में आने वाला वह हर सूक्ष्म अवरोध है जो हमें सत्य की प्राप्ति से रोकता है। 
            हे देव, आप अपनी प्रचंड शक्ति से हमारे भीतर के अज्ञान और जड़ता का अंत कर हमारे जीवन में प्रकाश का मार्ग सदा के लिए खोलें। 
            आपकी विजय ही हमारी वास्तविक विजय है, और हम आपकी निरंतर जय-जयकार करते हुए स्वयं को आपके दिव्य कार्यों के लिए समर्पित करते हैं। 
            आपकी ऊर्जा हमारे शरीर में जीवनी शक्ति बनकर और मन में दृढ़ संकल्प बनकर बहती है, जिससे हम जीवन के युद्ध में कभी हार नहीं मानते। 
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि आप हमारे जीवन के प्रत्येक संघर्ष में हमें सफलता की ओर ले जाने वाले महान सहायक बनें। 
            इन्द्रदेव की अजेय शक्ति हमें यह विश्वास दिलाती है कि अंततः जीत सदैव धर्म और सत्य की ही होती है, चाहे शत्रु कितना भी प्रबल क्यों न हो। 
            हे इन्द्र, आप हमारे परम रक्षक हैं, हमें अपनी दिव्य ज्वाला में तपाकर शुद्ध करें और हमें दिव्यता के सर्वोच्च शिखर पर पहुँचाएँ।
        """.trimIndent(),
        englishCommentary = """
            We offer hymns that bestow strength and capability to Lord Indra so that he may completely slay the great and formidable enemy, Vritra. 
            He is himself the immense mass of infinite energy and the foremost among the great heroes, always armed to destroy unrighteousness. 
            The devoted prayers of his followers sharpen Indra's thunderbolt (Vajra), enabling him to effectively annihilate all the obstacles of the world. 
            Vritra is not just a demon but every single subtle barrier in our path that prevents us from attaining Truth and Self-growth. 
            O God, with your fierce power, end the ignorance and lethargy within us and open the pathway of supreme light in our lives forever. 
            Your victory is our true victory, and as we continuously hail your name, we dedicate ourselves to your divine and benevolent purposes. 
            Your energy flows within us as the vital force and as a firm resolution in the mind, ensuring we never give up in the battle of life. 
            We worship you with devotion so that you become our constant and great helper, leading us toward success and peace in every life struggle. 
            The invincible power of Lord Indra reassures us that victory ultimately belongs to Dharma and Truth, no matter how strong the foe. 
            O Indra, you are our ultimate protector; refine us in your divine flame and lead us to the supreme and holy heights of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 36,
        sanskrit = "आ तू नः सोम पवस्व सुवीर्यं पवस्व रयिम् ।\nपवस्व मयः ॥ ३६ ॥",
        hindiCommentary = """
            हे सोमदेव! आप हमारे लिए उत्तम वीरता (सुवीर्यं), श्रेष्ठ धन (रयिम्) और असीम सुख (मयः) प्रदान करने के लिए पवित्र होकर प्रवाहित हों। 
            आपकी यह पावन धारा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता और सामर्थ्य लाने वाली है, हम आपकी असीम कृपा की याचना करते हैं। 
            वीरता केवल युद्ध में नहीं, बल्कि जीवन की प्रतिकूलताओं में धर्म पर अडिग रहने के लिए भी आवश्यक है, कृपया हमें वह बल प्रदान करें। 
            हमें वह धन दें जो न्यायपूर्ण रीति से प्राप्त किया गया हो और जिसका उपयोग हम समाज के दीन-दुखियों की सेवा में गौरव के साथ कर सकें। 
            आपकी कृपा से प्राप्त होने वाला 'मयः' (सुख) वह शांति है जो बाहरी परिस्थितियों पर निर्भर नहीं करती, बल्कि हृदय के भीतर से आती है। 
            हे देव, आप हमारे अंतःकरण को शुद्ध कर हमें वह दृष्टि दें जिससे हम आपके दिव्य ऐश्वर्य को चराचर जगत के कण-कण में देख सकें। 
            आप ही वह शक्ति हैं जो हमारे जीवन की दरिद्रता और जड़ता को समाप्त कर हमें प्रचुरता और सक्रियता के शिखर पर पहुँचाती हैं। 
            आपकी महिमा का गान करने से हमारे दुखों का नाश होता है और हमें नवीन उत्साह और जीवनी शक्ति की निरंतर प्राप्ति होती रहती है। 
            हे सोम, आप हमारे स्वामी और रक्षक के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली और यशस्वी बनाने की महान कृपा करें। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन हर दृष्टि से सार्थक, पुष्ट और पूर्णतः ईश्वरमय बना रहे।
        """.trimIndent(),
        englishCommentary = """
            O Soma, flow in your purified state to bestow upon us superior valor (Suviryam), excellent wealth (Rayim), and infinite bliss (Mayah). 
            Your holy stream brings prosperity and capability into every single area of our lives; we humbly seek your boundless grace and favor. 
            Valor is required not only in war but also to stay firm on the path of Dharma amidst life's adversities; please grant us that strength. 
            Provide us with that wealth which is obtained through righteous means and which we can use for the service of the needy with pride. 
            The 'Mayah' (happiness) obtained by your grace is that inner peace which does not depend on external situations but arises from within. 
            O God, purify our inner self and grant us the vision to perceive your divine splendor in every particle of the moving and non-moving world. 
            You are the power that terminates the poverty and lethargy of our existence and leads us to the peaks of abundance and activity. 
            Singing your glories destroys our sorrows and grants us a renewed sense of enthusiasm and vital force for our spiritual journey. 
            O Soma, always stay with us as our protector and Lord, graciously making our lives magnificent, successful, and truly renowned. 
            We offer our entire faith at your divine feet so that our lives remain meaningful, nourished, and completely God-conscious in every way.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 37,
        sanskrit = "आ नो मित्रस्य वरुणस्य प्र यंसत् ।\nसोम रयिं सुवीर्यम् ॥ ३७ ॥",
        hindiCommentary = """
            हे सोमदेव! आप हमें मित्र और वरुण देव के समान अत्यंत श्रेष्ठ, पवित्र और मंगलकारी धन प्रदान करने की महान कृपा करें। 
            आप हमें वह 'सुवीर्यम्' (उत्तम वीरता और आध्यात्मिक सामर्थ्य) दें जिससे हम धर्म की रक्षा और समाज का उद्धार करने में सफल हो सकें। 
            मित्र देव ब्रह्मांडीय सौहार्द के प्रतीक हैं और वरुण देव नैतिकता के रक्षक हैं, इन दोनों के महान गुण हमारे चरित्र में समाहित हों। 
            आपकी असीम कृपा से हमें वह ऐश्वर्य प्राप्त हो जो पूर्णतः सत्य और न्याय के मार्ग पर चलकर अर्जित किया गया हो और जो सुखदायी हो। 
            हे देव, हमें केवल भौतिक धन ही नहीं, बल्कि वह प्रज्ञा और चरित्र भी दें जो उस धन का लोक-कल्याण में सदुपयोग करने में सहायक हो। 
            आपकी ज्योति हमारे संकल्पों को वह दृढ़ता प्रदान करे जिससे हम वीरतापूर्वक जीवन की चुनौतियों का सामना कर सकें और कभी न डगमगाएं। 
            हम आपकी निरंतर वंदना करते हैं ताकि हमारे जीवन में अनुशासन, प्रेम और दिव्यता का एक सुंदर और सफल समन्वय सदैव बना रहे। 
            आप ही वह शक्ति हैं जो हमारे कठिन परिश्रम और त्याग को महान सफलता और ईश्वरीय फल में परिवर्तित करने का सामर्थ्य रखती हैं। 
            हे सोम, हमें वह वैभव दें जो हमारे वंश की गरिमा को बढ़ाए और हमें वह आत्मिक शांति प्रदान करे जो संसार में अत्यंत दुर्लभ है। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम ऐश्वर्य पाकर भी अहंकारी न हों और विनम्र बने रहकर सदैव सेवा के मार्ग पर चलें।
        """.trimIndent(),
        englishCommentary = """
            O Soma, please bestow upon us that most excellent, sacred, and auspicious wealth, similar to the gifts of Mitra and Varuna. 
            Grant us 'Suviryam'—superior valor and spiritual capability—so that we may successfully protect Dharma and uplift our society. 
            Mitra represents cosmic harmony and Varuna represents morality; let the noble qualities of both reside within our character. 
            By your boundless grace, let us receive that abundance which is earned by following the path of truth and justice and which brings peace. 
            O God, do not give us just material wealth, but also the wisdom and character required to use that wealth for the welfare of all. 
            May your light provide our resolutions with the firmness needed to face life's challenges heroically without ever wavering. 
            We worship you continuously so that a beautiful balance of discipline, love, and divinity remains always present in our lives. 
            You are the power that possesses the capability to transform our hard labor and sacrifice into magnificent success and divine fruits. 
            O Soma, grant us the splendor that enhances our lineage's dignity and provides us with the inner peace that is rare in the world. 
            May your merciful gaze remain upon us so that even with abundance, we do not become arrogant but stay humble on the path of service.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 38,
        sanskrit = "पवमानो नः पावकः स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ३८ ॥",
        hindiCommentary = """
            हे पवमान और पावक सोमदेव! आप स्वर्ग की दिव्य कांति के समान अद्भुत और विविध प्रकार के ऐश्वर्यों के स्वामी हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह पुष्टिकारक अन्न और शक्तिशाली जीवनी शक्ति लेकर आएं जो हमारे जीवन को सफल बनाए। 
            आपकी कृपा से हमारे जीवन में किसी भी वस्तु का लेशमात्र भी अभाव न रहे और हम सदैव सुख, शांति और समृद्धि से संपन्न बने रहें। 
            हे देव, आप हमारे अंतःकरण के समस्त अंधकार और विकारों को शुद्ध कर हमें वह दिव्य दृष्टि दें जिससे हम परमात्मा के दर्शन कर सकें। 
            आप ही वह महाशक्ति हैं जो हमारे जीवन की दरिद्रता और अज्ञान को समाप्त कर हमें प्रचुरता और ज्ञान के सर्वोच्च शिखर पर पहुँचाती हैं। 
            हमें वह 'इषम्' (प्रेरणा और पोषण) प्रदान करें जो हमारे शरीर और आत्मा दोनों को पूर्णतः तृप्त कर हमें दिव्यता की ओर ले जाने वाला हो। 
            आपकी महिमा का निरंतर गान करने से हमारे दुखों का नाश होता है और हमें वह नवीन उत्साह प्राप्त होता है जो हमें कभी थकने नहीं देता। 
            हे सोम, आप हमारे घर और हृदय में एक उदार दाता के रूप में पधारें और हमें वह स्थायी संपत्ति दें जो समय के साथ कभी नष्ट न हो। 
            आपकी ज्योति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और ईश्वर की ओर ले जाने वाले मार्ग का दर्शन कराए। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें अपनी दिव्य छाया में रखें और हमारा मंगलमय जीवन सदैव आपकी मर्यादा में सुरक्षित रहे।
        """.trimIndent(),
        englishCommentary = """
            O Pavamana and Purifying Soma, you are the master of magnificent and extraordinary riches that shine like celestial luster. 
            For us, your devoted chanters, bring forth that powerful nourishment and vital energy that make our lives meaningful and successful. 
            By your grace, let there be no scarcity of any kind in our lives, and may we always remain prosperous, peaceful, and abundant. 
            O God, purify our inner self of all darkness and afflictions and grant us the divine vision to perceive the Presence of the Divine. 
            You are the supreme power that terminates the poverty and ignorance of our existence and leads us to the peaks of plenty and wisdom. 
            Provide us with 'Isham'—divine inspiration and sustenance—that satisfies both our physical body and soul and leads us toward divinity. 
            Singing your glories destroys our sorrows and grants us a renewed sense of enthusiasm that ensures we never grow weary of our duty. 
            O Soma, come into our homes and hearts as the generous giver and grant us that permanent wealth which never perishes with time. 
            Let your light illuminate every dark corner of our existence and continuously show us the pathway leading toward fame, splendor, and God. 
            We pray with devotion that you keep us under your divine shadow and that our auspicious life remains forever safe within your laws.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 39,
        sanskrit = "पुनानः सोम धारया अपो वसानो अर्षसि ।\nआ रत्नधा योनिं ऋतस्य सीदसि ॥ ३९ ॥",
        hindiCommentary = """
            पवित्र किया जाता हुआ यह सोम अपनी दिव्य धारा के साथ जल रूपी वस्त्रों को धारण कर वेगपूर्वक और पवित्रता से प्रवाहित हो रहा है। 
            रत्नों और श्रेष्ठ गुणों को धारण करने वाला यह सोम 'ऋत' (ब्रह्मांडीय सत्य) के मूल स्थान पर जाकर अत्यंत आदर के साथ विराजमान होता है। 
            सोम का जल के साथ मिलन जीवन की सृजनात्मक ऊर्जा और परम शांति के सुंदर एवं सफल समन्वय का साक्षात् आध्यात्मिक प्रतीक है। 
            जैसे सोम ऋत के स्थान पर बैठता है, वैसे ही हमारे संकल्प भी सत्य, मर्यादा और धर्म के आधार पर सदैव प्रतिष्ठित होने चाहिए। 
            हे देव, आप अपनी इस पावन यात्रा के माध्यम से हमारे अंतःकरण को शुद्ध कर उसे दैवीय आभा से पूरी तरह आलोकित और जाग्रत कर दें। 
            आपकी उपस्थिति हमारे जीवन के प्रत्येक यज्ञीय कर्म को सफल बनाती है और हमें समस्त देवताओं के आशीर्वाद का पात्र बनाती है। 
            हमें वह 'रत्न' (विवेक और प्रज्ञा) प्रदान करें जो हमारे जीवन की दिशा को अंधकार और बुराई से हटाकर प्रकाश की ओर स्थायी रूप से मोड़ दे। 
            जब हम आपकी शरण में होते हैं, तब ब्रह्मांड का परम और शाश्वत सत्य हमारे हृदय में स्वतः ही प्रकाशित होने लगता है और हम शांत हो जाते हैं। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी कृपा की धारा हमारे परिवार और समाज में सदैव सुख, शांति और दिव्य प्रकाश लाए। 
            हे पवमान सोम, आप हमारे रक्षक और शाश्वत मार्गदर्शक बनकर हमें मोक्ष और ईश्वर के परम पद तक सफलतापूर्वक पहुँचाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            The purified Soma flows with its divine stream, appearing as if clothed in waters (Apo Vasano) as it rushes forward sacredly. 
            This bestower of treasures and virtues proceeds to seat himself with great respect upon the primal source of cosmic Truth (Rta). 
            The merging of Soma with water symbolizes the beautiful harmony between the creative energy of life and profound cosmic peace. 
            Just as Soma sits at the source of Rta, may our resolutions also be established upon the foundations of Truth, morality, and Dharma. 
            O God, through this holy journey of yours, purify our inner self and illuminate it completely with your celestial radiance and awakening. 
            Your presence makes every sacrificial act of our lives successful and makes us worthy of the magnificent blessings of the celestial gods. 
            Bestow upon us those 'gems' of wisdom and discernment that shift our life's direction away from darkness and evil toward the light. 
            When we are in your refuge, the ultimate and eternal Truth of the universe begins to manifest within our hearts naturally and effortlessly. 
            We worship you with devotion so that the stream of your grace always brings happiness and peace to our families and society. 
            O Pavamana Soma, stay as our protector and eternal guide, and graciously lead us to liberation and the supreme state of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 40,
        sanskrit = "अक्षण्वन्तः कर्णवन्तः सखायो मनोजवेषु असमा बभूवुः ।\nआदध्रास उपकक्षास उ त्वे ह्रदा इव स्त्रावा दृश्यन्ते ॥ ४० ॥",
        hindiCommentary = """
            आँख और कान वाले मित्र (सखायो) भी मन की गति और दिव्य अनुभूतियों के क्षेत्र में एक समान (**असमा**) नहीं होते हैं, यही प्रकृति का सत्य है। 
            कुछ साधक केवल बाहरी सतह तक ही पहुँच पाते हैं, जबकि कुछ गहरे **सरोवर (ह्रदा)** के समान ईश्वर के गूढ़ रहस्यों का साक्षात् दर्शन करते हैं। 
            यह मंत्र आध्यात्मिक साधना की गहराई और साधकों की विभिन्न श्रेणियों के बीच के सूक्ष्म अंतर को अत्यंत स्पष्टता के साथ प्रकट करता है। 
            केवल शारीरिक इंद्रियों का होना पर्याप्त नहीं है; वास्तविक ज्ञान वही है जो हृदय की गहराई और मन की पूर्ण एकाग्रता से प्राप्त किया जाता है। 
            हे सोम, आप हमें वह अंतर्दृष्टि प्रदान करें जिससे हम बाहरी प्रपंचों से हटकर आपके वास्तविक और दिव्य स्वरूप को सहजता से पहचान सकें। 
            जैसे सरोवर शांत होने पर ही अपना तल दिखा पाता है, वैसे ही शांत मन ही परमात्मा की छवि को ग्रहण करने और उसे धारण करने में समर्थ होता है। 
            हम आपकी निरंतर उपासना करते हैं ताकि हमारे संशय दूर हों और हम ज्ञान के उस गहरे सरोवर में डुबकी लगाकर अपनी आत्मा को तृप्त कर सकें। 
            आपकी कृपा से ही हमारे भीतर वह पात्रता विकसित होती है जिससे हम दिव्य मंत्रों और शाश्वत सत्यों के साक्षात् द्रष्टा और अनुभवी बन पाते हैं। 
            इन्द्रदेव के सखा सोम, आप हमें वह मेधा और प्रज्ञा दें जो हमें संसार के कोलाहल में भी ईश्वर की पुकार सुनने के योग्य बनाए। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन साधारण से असाधारण, तेजस्वी और पूर्णतः दिव्य बन सके।
        """.trimIndent(),
        englishCommentary = """
            Friends (Sakhayo) who possess eyes and ears are not equal (**Asama**) in their mental speed and divine realizations; this is the law of nature. 
            Some seekers only reach the shallow edges, while others, like **deep lakes (Hrada)**, perceive the profound mysteries of the Divine. 
            This mantra clarifies the depth of spiritual practice and the subtle differences between various levels of seekers and their insights. 
            Possessing physical senses is not enough; true knowledge is that which is attained through the depth of the heart and mental focus. 
            O Soma, grant us that inner vision which allows us to look beyond external illusions and recognize your true celestial nature effortlessly. 
            Just as a lake shows its bottom only when still, a calm mind is the only vessel capable of reflecting the image of the Supreme. 
            We worship you continuously so that our doubts vanish and we may dive deep into that profound lake of ultimate wisdom to satisfy the soul. 
            It is through your grace that the eligibility is developed within us to become direct seers of divine mantras and eternal truths. 
            O Soma, companion of Indra, grant us that intellect and wisdom which make us capable of hearing God's call amidst the world's noise. 
            We offer our entire faith at your feet so that our lives may transform from ordinary existence into an extraordinary and divine journey.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 41,
        sanskrit = "यस्य ते द्युमतो मदा अच्छा विचेतसा ।\nसोम अर्षसि धारया ॥ ४१ ॥",
        hindiCommentary = """
            हे सोम! आपकी वह आनंददायक और मदहोश कर देने वाली धारा, जो विशेष ज्ञान (विचेतसा) से युक्त है, हमारे कल्याण हेतु प्रवाहित होती रहे। 
            आप स्वयं प्रकाशमान (द्युमतः) हैं, और आपकी धारा हमारे जीवन के अंधकारमय मार्गों को अपनी दिव्य ज्योति से सदैव के लिए आलोकित कर देने वाली है। 
            सोम का 'मद' कोई सांसारिक नशा नहीं, बल्कि वह आध्यात्मिक आह्लाद है जो आत्मा को परमात्मा के साथ एकरूप और अत्यंत शांत कर देता है। 
            आपकी यह उच्च चेतना हमें वह शक्ति प्रदान करती है जिससे हम जीवन की जटिलताओं को समझकर सत्य का सही मार्ग चुनने में समर्थ होते हैं। 
            हे देव, आप हमारे यज्ञ में अपनी मधुर धारा के साथ पधारें और हमारे संकल्पों को दिव्यता की मिठास और दृढ़ता से पूरी तरह भर देने की कृपा करें। 
            जब आपकी अपार कृपा का प्रवाह हमारे जीवन में आता है, तो समस्त दुःख और दरिद्रता कपूर की तरह उड़कर सदा के लिए समाप्त हो जाते हैं। 
            हमें वह विशेष बोध प्रदान करें जिससे हम संसार के क्षणभंगुर आकर्षणों के प्रति अनासक्त होकर सदैव आपके प्रति समर्पित और निष्ठावान रहें। 
            आप ही वह शक्ति हैं जो हमारे शिथिल पड़ते मन को ऊर्जावान बनाती हैं और हमें निरंतर आध्यात्मिक प्रगति के पथ पर सफलतापूर्वक गतिशील रखती हैं। 
            हम श्रद्धापूर्वक आपकी महिमा का गान करते हैं ताकि आपकी उदारता का अमृत प्रवाह हमारे घर और हृदय में सदैव निरंतर और अखंड बना रहे। 
            हे दिव्य सोम, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और ज्ञानवान बनाने की महान कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Soma, may your exhilarating and intoxicating stream, combined with special wisdom (Vichetasa), flow for our welfare and peace. 
            You are self-radiant (Dyumatah), and your current is destined to illuminate the dark pathways of our existence with its eternal light. 
            The exhilaration of Soma is not a worldly intoxication but that spiritual bliss which unifies the individual soul with the Supreme Being. 
            This consciousness of yours provides us with the power to understand life's complexities and choose the path of Truth successfully. 
            O God, manifest within our sacrifice with your sweet stream and fill our resolutions with the sweetness of divine grace and love. 
            When the flow of your grace enters our life, all sufferings and poverty evaporate and terminate forever like camphor in a flame. 
            Grant us that special awareness through which we remain detached from fleeting attractions and dedicated strictly to you. 
            You are the power that energizes our lethargic minds and keeps us constantly dynamic on the pathway of continuous progress. 
            We worship you with devotion so that the flow of your immense generosity remains forever present within our homes and hearts. 
            O Divine Soma, stay with us as our protector and nourisher, and graciously make our lives magnificent, successful, and full.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 42,
        sanskrit = "पवस्व वाजसातये पवस्व परि मंहिष्ठः ।\nपवस्व मयोभुवे ॥ ४२ ॥",
        hindiCommentary = """
            हे पवमान सोम! आप विजय प्राप्त करने (**वाजसातये**) और सामर्थ्य की वृद्धि के लिए अत्यंत पवित्र होकर यहाँ निरंतर प्रवाहित होने की कृपा करें। 
            आप दानियों में सर्वश्रेष्ठ और उदार (मंहिष्ठः) हैं, कृपया अपनी धारा से हमारे जीवन को सुखकारी और पूर्णतः आनंदमय (मयोभुवे) बनाने की कृपा करें। 
            यह मंत्र संघर्ष के समय ईश्वर से प्राप्त होने वाले उस बल का आह्वान है जो मनुष्य को पराजय के भय और मानसिक दुर्बलता से पूरी तरह मुक्त करता है। 
            सोम का प्रवाह हमारे संकल्पों को वह धार देता है जिससे हम अधर्म की जटिल जंजीरों को सफलतापूर्वक और दृढ़ता के साथ काट सकते हैं। 
            आपकी उदारता केवल भौतिक धन तक सीमित नहीं है, बल्कि वह आत्मज्ञान की उस परम निधि को भी हमें सहज और सुलभ रूप से प्रदान करती है। 
            जैसे पवित्र धारा कंकड़-पत्थरों को हटाकर अपना रास्ता बनाती है, वैसे ही आप हमारे जीवन मार्ग की समस्त बाधाओं और संशयों को जड़ से दूर करें। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी कृपा का अमृत हमारे अंतःकरण को सदैव नवीन, स्वच्छ, तेजस्वी और निरंतर ऊर्जस्वित रखे। 
            आप ही वह शक्ति हैं जो हमारे कठिन पुरुषार्थ को ईश्वरीय आशीर्वाद में बदलकर हमें समाज में यशस्वी और अत्यंत सम्मानित बनाने वाली हैं। 
            हमें वह आध्यात्मिक प्यास प्रदान करें जो केवल आपके सान्निध्य रूपी अमृत से ही शांत हो सके और हमें पूर्ण शांति और आत्म-तृप्ति प्रदान करे। 
            हे सोम, आप हमारे रक्षक और गुरु बनकर हमें जीवन की सफलता और दिव्यता के सर्वोच्च एवं पवित्र शिखर पर सफलतापूर्वक पहुँचाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Pavamana Soma, flow in your purified state for the attainment of victory (**Vajasataye**) and the expansion of strength and capability. 
            You are the most liberal and generous among givers (Manhishthah); graciously make our lives comfortable and blissful with your stream. 
            This mantra is an invocation of that divine force which liberates a human being from the fear of defeat during times of struggle. 
            The flow of Soma provides our resolutions with the edge required to successfully cut through the complex chains of unrighteousness. 
            Your generosity is not limited to material wealth; it also bestows upon us the ultimate treasure of Self-realization and peace. 
            Just as a sacred stream clears pebbles to make its way, may you clear all the obstacles and doubts from our life's spiritual pathway. 
            We worship you with devotion so that the nectar of your grace keeps our inner self forever refreshed, new, and energized. 
            You are the power that transforms our hard labor into divine blessings, making us successful and respected in society. 
            Grant us that spiritual thirst which can only be quenched by the nectar of your presence, leading us to absolute satisfaction. 
            O Soma, stay as our protector and guide, leading us to the highest and most sacred peaks of life's success and divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 43,
        sanskrit = "अग्नये ब्रह्म गायत विप्राय देवहूतमये ।\nस नः पर्षत् अति द्विषः ॥ ४३ ॥",
        hindiCommentary = """
            हे स्तोताओं! आप उन अग्निदेव के लिए पवित्र वेदमंत्रों (ब्रह्म) का गान करें, जो परम विद्वान (विप्र) हैं और देवताओं का आह्वान करने वाले दिव्य दूत हैं। 
            वे अग्निदेव हमें समस्त द्वेषी शत्रुओं और भीषण संकटों (द्विषः) से पार ले जाने की असीम शक्ति और दयालुता रखने वाले सर्वोच्च देव हैं। 
            अग्नि यहाँ न केवल भौतिक ज्वाला है, बल्कि वह ज्ञान की वह प्रचंड ऊर्जा है जो हमारे भीतर के अज्ञान और नकारात्मकता को समूल जला देती है। 
            जब हम अपनी वाणी को अग्नि की स्तुति में समर्पित करते हैं, तो हमारे विचार शुद्ध होते हैं और हम आध्यात्मिक ऊँचाइयों को सहज ही प्राप्त करते हैं। 
            हे देव, आप हमारे जीवन के संघर्षों में एक शक्तिशाली रक्षक बनकर प्रकट हों और हमें अधर्म के मार्ग से हटाकर धर्म के मार्ग पर ले चलें। 
            आपकी ज्योति हमारे संकल्पों को वह दृढ़ता प्रदान करती है जिससे हम संसार के द्वंद्वों में भी विचलित नहीं होते और सदैव शांत रहते हैं। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आप ही हमारे यज्ञ को देवताओं तक पहुँचाने वाले सबसे विश्वसनीय और पवित्र दूत के रूप में प्रतिष्ठित हैं। 
            यज्ञ की अग्नि में दी गई प्रत्येक आहुति आपके माध्यम से ही सार्थक होती है और हमें वह आत्मिक बल देती है जो विजय के लिए अनिवार्य है। 
            हमें वह विवेक और प्रज्ञा प्रदान करें जिससे हम सत्य को पहचान सकें और मानवता की सेवा में अपने जीवन को पूरी तरह समर्पित कर सकें। 
            हे अग्नि, आप हमारे रक्षक और गुरु बनकर हमें जीवन की जटिलताओं से उबारें और दिव्यता के सर्वोच्च एवं पवित्र शिखर पर सफलतापूर्वक पहुँचाएँ।
        """.trimIndent(),
        englishCommentary = """
            O chanters, sing the sacred Vedic hymns (Brahma) for Lord Agni, who is the wise seer (Vipra) and the invoker of the celestial gods. 
            May Agni carry us across all malicious enemies and daunting calamities (Dwishah) through his boundless strength and mercy. 
            Agni here is not just physical fire but the energy of knowledge that burns away the internal darkness and negativity from our lives. 
            When we dedicate our voice to the praise of Agni, our thoughts become purified, and we attain higher spiritual dimensions of existence. 
            O God, manifest in our struggles as a powerful guardian and steer us away from unrighteousness toward the path of Dharma. 
            Your light provides our resolutions with that firmness through which we remain unshaken and peaceful even amidst worldly dualities. 
            We worship you with devotion because you are the most reliable and sacred messenger who carries our sacrifice to the gods. 
            Every oblation offered in the sacrificial fire becomes meaningful only through you and grants us the spiritual force essential for victory. 
            Bestow upon us the wisdom and discernment to recognize Truth and to dedicate our lives to the selfless service of entire humanity. 
            O Agni, stay as our protector and teacher, rescue us from life's complexities, and lead us to the supreme and holy peaks of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 44,
        sanskrit = "य उग्रः सवनेष्वा तविषीं अधत् सुतः ।\nस इन्द्रो वृत्रहा बभूविथ ॥ ४४ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! आप वही उग्र और प्रचंड पराक्रमी देव हैं, जिन्होंने यज्ञों (**सवनेषु**) में सोमरस के पान से असीम बल और शक्ति धारण की है। 
            आप ही वह **वृत्रहा (वृत्रासुर के संहारक)** हैं, जिन्होंने अज्ञान और जड़ता के प्रतीकात्मक शत्रुओं का नाश कर जगत को प्रकाश और गति प्रदान की। 
            इन्द्र का बल सोम की शुद्धि और यज्ञ की पवित्रता पर आधारित है, जो हमें यह सिखाता है कि आध्यात्मिक शक्ति ही वास्तविक विजय का आधार है। 
            जब हम अपने भीतर के 'वृत्र' (काम, क्रोध और लोभ) को मारते हैं, तभी हमें इन्द्र जैसी अजेय ऊर्जा और शांति की प्राप्ति होती है। 
            हे देव, आप हमारे जीवन के युद्ध क्षेत्र में पधारें और हमारे संकल्पों को वह तेज दें कि हम बुराइयों के विरुद्ध अडिग रहकर खड़े हो सकें। 
            आपकी विजय ही ब्रह्मांड की व्यवस्था का आधार है, और आपकी प्रसन्नता से ही हमें वर्षा, अन्न और संपन्नता का सुखद वरदान मिलता है। 
            हम अपनी मधुर वाणी और निष्कपट हृदय से आपकी स्तुति करते हैं ताकि आप हमारे जीवन के समस्त अमंगलों को सदा के लिए जड़ से भस्म कर दें। 
            आप ही वह सर्वोच्च सत्ता हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें उन्नति के पथ पर निरंतर और सफलतापूर्वक आगे बढ़ाती हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल या असहाय नहीं रहता, क्योंकि उसे परमात्मा के प्रत्यक्ष सहयोग का दिव्य अनुभव होता है। 
            हे अजेय इन्द्र, आप हमारे परम रक्षक और गुरु बनकर हमें अज्ञान के गर्त से निकालकर दिव्यता के शाश्वत प्रकाश की ओर ले चलने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, you are that fierce and formidable deity who has assumed boundless strength by consuming Soma in the sacrificial sessions. 
            You are the Vritrahan (Slayer of Vritra), who destroyed the symbolic enemies of ignorance and stagnation to grant light and motion to the world. 
            Indra's power is rooted in the purification of Soma and the sanctity of the ritual, teaching us that spiritual strength is the true basis of victory. 
            When we slay the 'Vritra' within us (lust, anger, and greed), only then do we attain the invincible energy and peace characterized by Indra. 
            O God, manifest within the battlefield of our lives and grant our resolutions the brilliance needed to stand firm against all evils. 
            Your victory is the foundation of cosmic order, and it is through your satisfaction that we receive the blessings of rain, food, and prosperity. 
            We praise you with our sweet voices and sincere hearts so that you may completely burn away all inauspiciousness from our existence forever. 
            You are the supreme authority that makes our labor meaningful and continuously drives us forward on the path of growth and success. 
            A seeker who takes refuge in Lord Indra never remains weak or helpless, as they experience the divine support of the Almighty directly. 
            O unconquerable Indra, stay as our protector and teacher, pulling us out of the pit of ignorance toward the eternal light of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 45,
        sanskrit = "त्वामिद्धि हवामहे सातौ वाजस्य कारवः ।\nत्वां वृत्रेषु इन्द्र सत्पतिं नरस्त्वां काष्ठास्वर्वतः ॥ ४५ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! हम यज्ञ करने वाले साधक युद्ध में विजय और अजेय सामर्थ्य की प्राप्ति के लिए केवल आपको ही अत्यंत श्रद्धापूर्वक पुकारते हैं। 
            आप ही वह **'सत्पति' (सज्जनों के स्वामी)** हैं जो वृत्रासुर जैसे भयंकर और अज्ञानी शत्रुओं का नाश कर हमें धर्म की रक्षा का बल प्रदान करते हैं। 
            जीवन की कठिन परीक्षाओं और कर्मों के संग्राम में, पराक्रमी वीर योद्धा केवल आपकी ही दिव्य शक्ति और मार्गदर्शन का आह्वान करते हैं। 
            जैसे वेगवान और अनुशासित अश्व अपने लक्ष्य की ओर दौड़ते हैं, वैसे ही हमारे संकल्प आपकी कृपा से सफलता के सर्वोच्च शिखर की ओर बढ़ें। 
            आप ही वह महाशक्ति हैं जो हमारे जीवन के समस्त आंतरिक और बाह्य अवरोधों को दूर कर ज्ञान और संपन्नता के मार्ग को प्रशस्त करने वाली हैं। 
            हम पूर्ण निष्ठा के साथ आपकी शरण में आए हैं क्योंकि आपके दिव्य सहयोग के बिना वास्तविक विजय और मानसिक शांति प्राप्त करना असंभव है। 
            हे देवराज, आप अपनी अमोघ और प्रचंड शक्ति के साथ हमारे अंतःकरण में प्रदीप्त हों और हमें समस्त सांसारिक संशयों से स्थायी मुक्ति प्रदान करें। 
            आपकी प्रसन्नता से ही इस सृष्टि का चक्र व्यवस्थित रहता है और हमें वर्षा, पुष्टिकारक अन्न तथा उत्तम शारीरिक और मानसिक स्वास्थ्य प्राप्त होता है। 
            हम अपनी पवित्र और सत्यनिष्ठ वाणी से आपकी महिमा का गान करते हैं ताकि आपके सान्निध्य में हमारा जीवन सार्थक, यशस्वी और मंगलमय बने। 
            हे अजेय इन्द्र, आप हमारे परम रक्षक और गुरु बनकर हमें अज्ञान के अंधकार से निकालकर सत्य के शाश्वत प्रकाश की ओर ले चलने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, we the seekers performing the sacrifice invoke only you for obtaining victory and invincible capability in the battles of life. 
            You are the 'Satpati' (Lord of the righteous) who destroys formidable enemies like Vritra and empowers us to protect the Eternal Dharma. 
            In the trials of existence and the struggle of duties, mighty warriors call upon your divine strength and guidance for ultimate success. 
            Just as swift and disciplined horses race toward their target, may our resolutions advance toward the pinnacle of success through your grace. 
            You are the supreme power that removes all internal and external obstacles from our path and opens the gateway to wisdom and prosperity. 
            We seek your refuge with total dedication because without your divine assistance, attaining true victory and mental peace is impossible. 
            O King of Gods, ignite your infallible and fierce power within our consciousness and liberate us from all worldly doubts and anxieties. 
            Your satisfaction ensures the order of the cosmic cycle, granting us timely rain, nourishing food, and superior physical and mental health. 
            We sing your glories with our holy and truthful voices so that our lives become meaningful, successful, and auspicious in your presence. 
            O unconquerable Indra, stay as our supreme protector and teacher, and lead us from the darkness of ignorance to the eternal light of Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 46,
        sanskrit = "न त्वावाँ अन्यो दिव्यो न पार्थिवो न जातो न जनिष्यते ।\nअश्वयन्तो मघवन्निन्द्र वाजिनो गव्यन्तस्त्वा हवामहे ॥ ४६ ॥",
        hindiCommentary = """
            हे मघवन् इन्द्र! आपके समान शक्तिशाली और दयालु न तो कोई दिव्य लोक में है, न इस पृथ्वी पर, न कोई हुआ है और न कभी भविष्य में होगा। 
            आपकी महानता अद्वितीय और अतुलनीय है, आप समस्त ब्रह्मांडीय और सांसारिक शक्तियों के सर्वोच्च स्वामी और अजेय रक्षक के रूप में प्रतिष्ठित हैं। 
            हम शक्ति, विजय और प्रचुर संसाधनों (अश्व और गौओं) की कामना करते हुए आपको अपने इस पवित्र यज्ञ में अत्यंत आदर के साथ आमंत्रित करते हैं। 
            आप ही वह एकमात्र आदि शक्ति हैं जो हमारे जीवन में पूर्णता और प्रचुरता लाने का सामर्थ्य रखती हैं, हम पूर्ण श्रद्धा से आपकी शरण में हैं। 
            आपकी दिव्यता समस्त सीमाओं से परे है, और आप ही 'ऋत' (ब्रह्मांडीय सत्य) के मार्ग के सबसे बड़े संरक्षक और सजग प्रहरी के रूप में जाने जाते हैं। 
            जब हम आपका हृदय की गहराई से आह्वान करते हैं, तो हमारे भीतर एक नई ऊर्जा का संचार होता है जो हमें समस्त मानसिक विकारों पर विजय दिलाती है। 
            संसार की कोई भी बाधा आपके अजेय वज्र के सामने क्षण भर भी टिक नहीं सकती, कृपया आप हमारे मार्ग के समस्त कंटकों को सदा के लिए दूर करें। 
            हमें वह प्रज्ञा और साहस प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रह सकें और अपने जीवन के श्रेष्ठ और महान लक्ष्यों को प्राप्त करें। 
            आपकी कृपा दृष्टि से हमारा संपूर्ण कल्याण और आध्यात्मिक उत्थान सुनिश्चित है, हम आपकी इस भव्य शक्ति की बार-बार हृदय से वंदना करते हैं। 
            हे इन्द्र, आप हमारे परम स्वामी और रक्षक हैं, हमें अज्ञान से ज्ञान की ओर और विनाशकारी अंधकार से शाश्वत दिव्य प्रकाश की ओर सफलतापूर्वक ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Maghavan Indra, there is none as powerful and merciful as you in the heavens, nor on earth; none has existed, nor will ever exist. 
            Your greatness is unique and incomparable; you are the supreme master and invincible guardian of all cosmic and worldly powers. 
            Desiring strength, victory, and abundant resources (Horses and Cows), we invite you to this sacred sacrifice with the highest degree of respect. 
            You are the only primordial power capable of bringing completeness and plenty into our lives; we seek your divine refuge with absolute faith. 
            Your divinity transcends all possible boundaries, and you stand as the greatest protector and sentinel of the Cosmic Law (Rta). 
            When we invoke you from the depths of our hearts, a new surge of energy flows through us, granting us victory over all mental afflictions. 
            No obstacle in this world can withstand your invincible thunderbolt; please remove all the thorns from our life's pathway forever. 
            Grant us the wisdom and courage required to always be ready for the defense of Dharma and to achieve the noble and grand goals of our life. 
            Our complete well-being and spiritual evolution are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power. 
            O Indra, you are our supreme Lord and Protector; lead us away from dark ignorance toward the eternal and radiant light of the Divine.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 47,
        sanskrit = "आ तू नः सोम पवस्व सुवीर्यं पवस्व रयिम् ।\nपवस्व मयः ॥ ४७ ॥",
        hindiCommentary = """
            हे सोमदेव! आप हमारे लिए उत्तम वीरता (सुवीर्यं), श्रेष्ठ धन (रयिम्) और असीम सुख (मयः) प्रदान करने के लिए पवित्र होकर प्रवाहित हों। 
            आपकी यह पावन धारा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, आरोग्यता और सामर्थ्य लाने वाली है, हम आपकी असीम कृपा की याचना करते हैं। 
            वीरता केवल युद्ध में नहीं, बल्कि जीवन की प्रतिकूलताओं में धर्म पर अडिग रहने के लिए भी आवश्यक है, कृपया हमें वह बल प्रदान करें। 
            हमें वह धन दें जो न्यायपूर्ण रीति से प्राप्त किया गया हो और जिसका उपयोग हम समाज के दीन-दुखियों की सेवा में अत्यंत गौरव के साथ कर सकें। 
            आपकी कृपा से प्राप्त होने वाला सुख वह शांति है जो बाहरी परिस्थितियों पर निर्भर नहीं करती, बल्कि हृदय के भीतर से आती है। 
            हे देव, आप हमारे अंतःकरण को शुद्ध कर हमें वह दृष्टि दें जिससे हम आपके दिव्य ऐश्वर्य को चराचर जगत के कण-कण में देख सकें। 
            आप ही वह शक्ति हैं जो हमारे जीवन की दरिद्रता और जड़ता को समाप्त कर हमें प्रचुरता और सक्रियता के शिखर पर पहुँचाती हैं। 
            आपकी महिमा का गान करने से हमारे दुखों का नाश होता है और हमें नवीन उत्साह और जीवनी शक्ति की निरंतर प्राप्ति होती रहती है। 
            हे सोम, आप हमारे स्वामी और रक्षक के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली और यशस्वी बनाने की महान कृपा करें। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन हर दृष्टि से सार्थक, पुष्ट और पूर्णतः ईश्वरमय बना रहे।
        """.trimIndent(),
        englishCommentary = """
            O Soma, flow in your purified state to bestow upon us superior valor (Suviryam), excellent wealth (Rayim), and infinite bliss (Mayah). 
            Your holy stream brings prosperity and capability into every single area of our lives; we humbly seek your boundless grace and favor. 
            Valor is required not only in war but also to stay firm on the path of Dharma amidst life's adversities; please grant us that strength. 
            Provide us with that wealth which is obtained through righteous means and which we can use for the service of the needy with pride. 
            The happiness obtained by your grace is that inner peace which does not depend on external situations but arises from within the heart. 
            O God, purify our inner self and grant us the vision to perceive your divine splendor in every particle of the moving and non-moving world. 
            You are the power that terminates the poverty and lethargy of our existence and leads us to the peaks of abundance and activity. 
            Singing your glories destroys our sorrows and grants us a renewed sense of enthusiasm and vital force for our spiritual journey. 
            O Soma, always stay with us as our protector and Lord, graciously making our lives magnificent, successful, and truly renowned. 
            We offer our entire faith at your divine feet so that our lives remain meaningful, nourished, and completely God-conscious in every way.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 48,
        sanskrit = "आ नो मित्रस्य वरुणस्य प्र यंसत् ।\nसोम रयिं सुवीर्यम् ॥ ४८ ॥",
        hindiCommentary = """
            हे सोमदेव! आप हमें मित्र और वरुण देव के समान अत्यंत श्रेष्ठ, पवित्र और मंगलकारी धन प्रदान करने की महान कृपा करें। 
            आप हमें वह 'सुवीर्यम्' (उत्तम वीरता और आध्यात्मिक सामर्थ्य) दें जिससे हम धर्म की रक्षा और समाज का उद्धार करने में सफल हो सकें। 
            मित्र देव ब्रह्मांडीय सौहार्द के प्रतीक हैं और वरुण देव नैतिकता के रक्षक हैं, इन दोनों के महान गुण हमारे चरित्र में समाहित हों। 
            आपकी असीम कृपा से हमें वह ऐश्वर्य प्राप्त हो जो पूर्णतः सत्य और न्याय के मार्ग पर चलकर अर्जित किया गया हो और जो सुखदायी हो। 
            हे देव, हमें केवल भौतिक धन ही नहीं, बल्कि वह प्रज्ञा और चरित्र भी दें जो उस धन का लोक-कल्याण में सदुपयोग करने में सहायक हो। 
            आपकी ज्योति हमारे संकल्पों को वह दृढ़ता प्रदान करे जिससे हम वीरतापूर्वक जीवन की चुनौतियों का सामना कर सकें और कभी न डगमगाएं। 
            हम आपकी निरंतर वंदना करते हैं ताकि हमारे जीवन में अनुशासन, प्रेम और दिव्यता का एक सुंदर और सफल समन्वय सदैव बना रहे। 
            आप ही वह शक्ति हैं जो हमारे कठिन परिश्रम और त्याग को महान सफलता और ईश्वरीय फल में परिवर्तित करने का सामर्थ्य रखती हैं। 
            हे सोम, हमें वह वैभव दें जो हमारे वंश की गरिमा को बढ़ाए और हमें वह आत्मिक शांति प्रदान करे जो संसार में अत्यंत दुर्लभ है। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम ऐश्वर्य पाकर भी अहंकारी न हों और विनम्र बने रहकर सदैव सेवा के मार्ग पर चलें।
        """.trimIndent(),
        englishCommentary = """
            O Soma, please bestow upon us that most excellent, sacred, and auspicious wealth, similar to the gifts of Mitra and Varuna. 
            Grant us 'Suviryam'—superior valor and spiritual capability—so that we may successfully protect Dharma and uplift our society. 
            Mitra represents cosmic harmony and Varuna represents morality; let the noble qualities of both reside within our character. 
            By your boundless grace, let us receive that abundance which is earned by following the path of truth and justice and which brings peace. 
            O God, do not give us just material wealth, but also the wisdom and character required to use that wealth for the welfare of all. 
            May your light provide our resolutions with the firmness needed to face life's challenges heroically without ever wavering. 
            We worship you continuously so that a beautiful balance of discipline, love, and divinity remains always present in our lives. 
            You are the power that possesses the capability to transform our hard labor and sacrifice into magnificent success and divine fruits. 
            O Soma, grant us the splendor that enhances our lineage's dignity and provides us with the inner peace that is rare in the world. 
            May your merciful gaze remain upon us so that even with abundance, we do not become arrogant but stay humble on the path of service.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 49,
        sanskrit = "पवमानो नः पावकः स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ४९ ॥",
        hindiCommentary = """
            हे पवमान और पावक सोमदेव! आप स्वर्ग की दिव्य कांति के समान अद्भुत और विविध प्रकार के ऐश्वर्यों के परम स्वामी हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह पुष्टिकारक अन्न और शक्तिशाली जीवनी शक्ति लेकर आएं जो हमारे जीवन को सफल बनाए। 
            आपकी कृपा से हमारे जीवन में किसी भी वस्तु का लेशमात्र भी अभाव न रहे और हम सदैव सुख, शांति और समृद्धि से संपन्न बने रहें। 
            हे देव, आप हमारे अंतःकरण के समस्त अंधकार और विकारों को शुद्ध कर हमें वह दिव्य दृष्टि दें जिससे हम परमात्मा के दर्शन कर सकें। 
            आप ही वह महाशक्ति हैं जो हमारे जीवन की दरिद्रता और अज्ञान को समाप्त कर हमें प्रचुरता और ज्ञान के सर्वोच्च शिखर पर पहुँचाती हैं। 
            हमें वह 'इषम्' (प्रेरणा और पोषण) प्रदान करें जो हमारे शरीर और आत्मा दोनों को पूर्णतः तृप्त कर हमें दिव्यता की ओर ले जाने वाला हो। 
            आपकी महिमा का निरंतर गान करने से हमारे दुखों का नाश होता है और हमें वह नवीन उत्साह प्राप्त होता है जो हमें कभी थकने नहीं देता। 
            हे सोम, आप हमारे घर और हृदय में एक उदार दाता के रूप में पधारें और हमें वह स्थायी संपत्ति दें जो समय के साथ कभी नष्ट न हो। 
            आपकी ज्योति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और ईश्वर की ओर ले जाने वाले मार्ग का दर्शन कराए। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें अपनी दिव्य छाया में रखें और हमारा मंगलमय जीवन सदैव आपकी मर्यादा में सुरक्षित रहे।
        """.trimIndent(),
        englishCommentary = """
            O Pavamana and Purifying Soma, you are the master of magnificent and extraordinary riches that shine like celestial luster. 
            For us, your devoted chanters, bring forth that powerful nourishment and vital energy that make our lives meaningful and successful. 
            By your grace, let there be no scarcity of any kind in our lives, and may we always remain prosperous, peaceful, and abundant. 
            O God, purify our inner self of all darkness and afflictions and grant us the divine vision to perceive the Presence of the Divine. 
            You are the supreme power that terminates the poverty and ignorance of our existence and leads us to the peaks of plenty and wisdom. 
            Provide us with 'Isham'—divine inspiration and sustenance—that satisfies both our physical body and soul and leads us toward divinity. 
            Singing your glories destroys our sorrows and grants us a renewed sense of enthusiasm that ensures we never grow weary of our duty. 
            O Soma, come into our homes and hearts as the generous giver and grant us that permanent wealth which never perishes with time. 
            Let your light illuminate every dark corner of our existence and continuously show us the pathway leading toward fame, splendor, and God. 
            We pray with devotion that you keep us under your divine shadow and that our auspicious life remains forever safe within your laws.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 50,
        sanskrit = "पुनानः सोम धारया अपो वसानो अर्षसि ।\nआ रत्नधा योनिं ऋतस्य सीदसि ॥ ५० ॥",
        hindiCommentary = """
            पवित्र किया जाता हुआ यह सोम अपनी दिव्य धारा के साथ जल रूपी वस्त्रों को धारण कर वेगपूर्वक और पवित्रता से प्रवाहित हो रहा है। 
            रत्नों और श्रेष्ठ गुणों को धारण करने वाला यह सोम 'ऋत' (ब्रह्मांडीय सत्य) के मूल स्थान पर जाकर अत्यंत आदर के साथ विराजमान होता है। 
            सोम का जल के साथ मिलन जीवन की सृजनात्मक ऊर्जा और परम शांति के सुंदर समन्वय का साक्षात् आध्यात्मिक प्रतीक है। 
            जैसे सोम ऋत के स्थान पर बैठता है, वैसे ही हमारे संकल्प भी सत्य, मर्यादा और धर्म के आधार पर सदैव प्रतिष्ठित होने चाहिए। 
            हे देव, आप अपनी इस पावन यात्रा के माध्यम से हमारे अंतःकरण को शुद्ध कर उसे दैवीय आभा से पूरी तरह आलोकित और जाग्रत कर दें। 
            आपकी उपस्थिति हमारे जीवन के प्रत्येक यज्ञीय कर्म को सफल बनाती है और हमें समस्त देवताओं के आशीर्वाद का पात्र बनाती है। 
            हमें वह 'रत्न' (विवेक और प्रज्ञा) प्रदान करें जो हमारे जीवन की दिशा को अज्ञान से हटाकर प्रकाश की ओर स्थायी रूप से मोड़ दे। 
            जब हम आपकी शरण में होते हैं, तब ब्रह्मांड का परम और शाश्वत सत्य हमारे हृदय में स्वतः ही प्रकाशित होने लगता है और हम शांत हो जाते हैं। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी कृपा की धारा हमारे परिवार और समाज में सदैव सुख, शांति और दिव्य प्रकाश लाए। 
            हे पवमान सोम, आप हमारे रक्षक और शाश्वत मार्गदर्शक बनकर हमें मोक्ष और ईश्वर के परम पद तक पहुँचाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            The purified Soma flows with its divine stream, appearing as if clothed in waters (Apo Vasano) as it rushes forward sacredly. 
            This bestower of treasures and virtues proceeds to seat himself with great respect upon the primal source of cosmic Truth (Rta). 
            The merging of Soma with water symbolizes the beautiful harmony between the creative energy of life and profound cosmic peace. 
            Just as Soma sits at the source of Rta, may our resolutions also be established upon the foundations of Truth, morality, and Dharma. 
            O God, through this holy journey of yours, purify our inner self and illuminate it completely with your celestial radiance and awakening. 
            Your presence makes every sacrificial act of our lives successful and makes us worthy of the magnificent blessings of the celestial gods. 
            Bestow upon us those 'gems' of wisdom and discernment that shift our life's direction away from darkness and evil toward the light. 
            When we are in your refuge, the ultimate and eternal Truth of the universe begins to manifest within our hearts naturally and effortlessly. 
            We worship you with devotion so that the stream of your grace always brings happiness and peace to our families and society. 
            O Pavamana Soma, stay as our protector and eternal guide, and graciously lead us to liberation and the supreme state of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 51,
        sanskrit = "अक्षण्वन्तः कर्णवन्तः सखायो मनोजवेषु असमा बभूवुः ।\nआदध्रास उपकक्षास उ त्वे ह्रदा इव स्त्रावा दृश्यन्ते ॥ ५१ ॥",
        hindiCommentary = """
            आँख और कान वाले मित्र भी मन की गति और दिव्य अनुभूतियों के क्षेत्र में एक समान (**असमा**) नहीं होते हैं, यही प्रकृति का सत्य है। 
            कुछ साधक केवल बाहरी सतह तक ही पहुँच पाते हैं, जबकि कुछ गहरे **सरोवर (ह्रदा)** के समान ईश्वर के गूढ़ रहस्यों का साक्षात् दर्शन करते हैं। 
            यह मंत्र आध्यात्मिक साधना की गहराई और साधकों की विभिन्न श्रेणियों के बीच के सूक्ष्म अंतर को अत्यंत स्पष्टता के साथ प्रकट करता है। 
            केवल शारीरिक इंद्रियों का होना पर्याप्त नहीं है; वास्तविक ज्ञान वही है जो हृदय की गहराई और मन की पूर्ण एकाग्रता से प्राप्त किया जाता है। 
            हे सोम, आप हमें वह अंतर्दृष्टि प्रदान करें जिससे हम बाहरी प्रपंचों से हटकर आपके वास्तविक और दिव्य स्वरूप को पहचान सकें। 
            जैसे सरोवर शांत होने पर ही अपना तल दिखा पाता है, वैसे ही शांत मन ही परमात्मा की छवि को ग्रहण करने और उसे धारण करने में समर्थ होता है। 
            हम आपकी निरंतर उपासना करते हैं ताकि हमारे संशय दूर हों और हम ज्ञान के उस गहरे सरोवर में डुबकी लगाकर अपनी आत्मा को तृप्त कर सकें। 
            आपकी कृपा से ही हमारे भीतर वह पात्रता विकसित होती है जिससे हम दिव्य मंत्रों और शाश्वत सत्यों के साक्षात् द्रष्टा बन पाते हैं। 
            इन्द्रदेव के सखा सोम, आप हमें वह मेधा और प्रज्ञा दें जो हमें संसार के कोलाहल में भी ईश्वर की पुकार सुनने के योग्य बनाए। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन साधारण से असाधारण, तेजस्वी और पूर्णतः दिव्य बन सके।
        """.trimIndent(),
        englishCommentary = """
            Friends who possess eyes and ears are not equal (**Asama**) in their mental speed and divine realizations; this is the law of nature. 
            Some seekers only reach the shallow edges, while others, like **deep lakes (Hrada)**, perceive the profound mysteries of the Divine. 
            This mantra clarifies the depth of spiritual practice and the subtle differences between various levels of seekers and their insights. 
            Possessing physical senses is not enough; true knowledge is that which is attained through the depth of the heart and mental focus. 
            O Soma, grant us that inner vision which allows us to look beyond external illusions and recognize your true celestial nature effortlessly. 
            Just as a lake shows its bottom only when still, a calm mind is the only vessel capable of reflecting the image of the Supreme. 
            We worship you continuously so that our doubts vanish and we may dive deep into that profound lake of ultimate wisdom to satisfy the soul. 
            It is through your grace that the eligibility is developed within us to become direct seers of divine mantras and eternal truths. 
            O Soma, companion of Indra, grant us that intellect and wisdom which make us capable of hearing God's call amidst the world's noise. 
            We offer our entire faith at your feet so that our lives may transform from ordinary existence into an extraordinary and divine journey.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 52,
        sanskrit = "यस्य ते द्युमतो मदा अच्छा विचेतसा ।\nसोम अर्षसि धारया ॥ ५२ ॥",
        hindiCommentary = """
            हे सोम! आपकी वह आनंददायक और मदहोश कर देने वाली धारा, जो विशेष ज्ञान (विचेतसा) से युक्त है, हमारे कल्याण हेतु प्रवाहित होती रहे। 
            आप स्वयं प्रकाशमान (द्युमतः) हैं, और आपकी धारा हमारे जीवन के अंधकारमय मार्गों को अपनी दिव्य ज्योति से सदैव के लिए आलोकित करने वाली है। 
            सोम का 'मद' कोई सांसारिक नशा नहीं, बल्कि वह आध्यात्मिक आह्लाद है जो आत्मा को परमात्मा के साथ एकरूप और अत्यंत शांत कर देता है। 
            आपकी यह उच्च चेतना हमें वह शक्ति प्रदान करती है जिससे हम जीवन की जटिलताओं को समझकर सत्य का सही मार्ग चुनने में समर्थ होते हैं। 
            हे देव, आप हमारे यज्ञ में अपनी मधुर धारा के साथ पधारें और हमारे संकल्पों को दिव्यता की मिठास और दृढ़ता से पूरी तरह भर देने की कृपा करें। 
            जब आपकी अपार कृपा का प्रवाह हमारे जीवन में आता है, तो समस्त दुःख और दरिद्रता कपूर की तरह उड़कर सदा के लिए समाप्त हो जाते हैं। 
            हमें वह विशेष बोध प्रदान करें जिससे हम संसार के क्षणभंगुर आकर्षणों के प्रति अनासक्त होकर सदैव आपके प्रति समर्पित और निष्ठावान रहें। 
            आप ही वह शक्ति हैं जो हमारे शिथिल पड़ते मन को ऊर्जावान बनाती हैं और हमें निरंतर आध्यात्मिक प्रगति के पथ पर गतिशील रखती हैं। 
            हम श्रद्धापूर्वक आपकी महिमा का गान करते हैं ताकि आपकी उदारता का अमृत प्रवाह हमारे घर और हृदय में सदैव निरंतर और अखंड बना रहे। 
            हे दिव्य सोम, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और ज्ञानवान बनाने की महान कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Soma, may your exhilarating and intoxicating stream, combined with special wisdom (Vichetasa), flow for our welfare and peace. 
            You are self-radiant (Dyumatah), and your current is destined to illuminate the dark pathways of our existence with its eternal light. 
            The exhilaration of Soma is not a worldly intoxication but that spiritual bliss which unifies the individual soul with the Supreme Being. 
            This consciousness of yours provides us with the power to understand life's complexities and choose the path of Truth successfully. 
            O God, manifest within our sacrifice with your sweet stream and fill our resolutions with the sweetness of divine grace and love. 
            When the flow of your grace enters our life, all sufferings and poverty evaporate and terminate forever like camphor in a flame. 
            Grant us that special awareness through which we remain detached from fleeting attractions and dedicated strictly to you. 
            You are the power that energizes our lethargic minds and keeps us constantly dynamic on the pathway of continuous progress. 
            We worship you with devotion so that the flow of your immense generosity remains forever present within our homes and hearts. 
            O Divine Soma, stay with us as our protector and nourisher, and graciously make our lives magnificent, successful, and full.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 53,
        sanskrit = "पवस्व वाजसातये पवस्व परि मंहिष्ठः ।\nपवस्व मयोभुवे ॥ ५३ ॥",
        hindiCommentary = """
            हे पवमान सोम! आप विजय प्राप्त करने (**वाजसातये**) और सामर्थ्य की वृद्धि के लिए अत्यंत पवित्र होकर यहाँ निरंतर प्रवाहित होने की कृपा करें। 
            आप दानियों में सर्वश्रेष्ठ और उदार (मंहिष्ठः) हैं, कृपया अपनी धारा से हमारे जीवन को सुखकारी और पूर्णतः आनंदमय (मयोभुवे) बनाने की कृपा करें। 
            यह मंत्र संघर्ष के समय ईश्वर से प्राप्त होने वाले उस बल का आह्वान है जो मनुष्य को पराजय के भय और मानसिक दुर्बलता से पूरी तरह मुक्त करता है। 
            सोम का प्रवाह हमारे संकल्पों को वह धार देता है जिससे हम अधर्म की जटिल जंजीरों को सफलतापूर्वक और दृढ़ता के साथ काट सकते हैं। 
            आपकी उदारता केवल भौतिक धन तक सीमित नहीं है, बल्कि वह आत्मज्ञान की उस परम निधि को भी हमें सहज और सुलभ रूप से प्रदान करती है। 
            जैसे पवित्र धारा कंकड़-पत्थरों को हटाकर अपना रास्ता बनाती है, वैसे ही आप हमारे जीवन मार्ग की समस्त बाधाओं और संशयों को जड़ से दूर करें। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी कृपा का अमृत हमारे अंतःकरण को सदैव नवीन, स्वच्छ, तेजस्वी और निरंतर ऊर्जस्वित रखे। 
            आप ही वह शक्ति हैं जो हमारे कठिन पुरुषार्थ को ईश्वरीय आशीर्वाद में बदलकर हमें समाज में यशस्वी और अत्यंत सम्मानित बनाने वाली हैं। 
            हमें वह आध्यात्मिक प्यास प्रदान करें जो केवल आपके सान्निध्य रूपी अमृत से ही शांत हो सके और हमें पूर्ण शांति और आत्म-तृप्ति प्रदान करे। 
            हे सोम, आप हमारे रक्षक और गुरु बनकर हमें जीवन की सफलता और दिव्यता के सर्वोच्च एवं पवित्र शिखर पर सफलतापूर्वक पहुँचाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Pavamana Soma, flow in your purified state for the attainment of victory (**Vajasataye**) and the expansion of strength and capability. 
            You are the most liberal and generous among givers (Manhishthah); graciously make our lives comfortable and blissful with your stream. 
            This mantra is an invocation of that divine force which liberates a human being from the fear of defeat during times of struggle. 
            The flow of Soma provides our resolutions with the edge required to successfully cut through the complex chains of unrighteousness. 
            Your generosity is not limited to material wealth; it also bestows upon us the ultimate treasure of Self-realization and peace. 
            Just as a sacred stream clears pebbles to make its way, may you clear all the obstacles and doubts from our life's spiritual pathway. 
            We worship you with devotion so that the nectar of your grace keeps our inner self forever refreshed, new, and energized. 
            You are the power that transforms our hard labor into divine blessings, making us successful and respected in society. 
            Grant us that spiritual thirst which can only be quenched by the nectar of your presence, leading us to absolute satisfaction. 
            O Soma, stay as our protector and guide, leading us to the highest and most sacred peaks of life's success and divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 54,
        sanskrit = "अग्नये ब्रह्म गायत विप्राय देवहूतमये ।\nस नः पर्षत् अति द्विषः ॥ ५४ ॥",
        hindiCommentary = """
            हे स्तोताओं! आप उन अग्निदेव के लिए पवित्र वेदमंत्रों (ब्रह्म) का गान करें, जो परम विद्वान (विप्र) हैं और देवताओं का आह्वान करने वाले दिव्य दूत हैं। 
            वे अग्निदेव हमें समस्त द्वेषी शत्रुओं और भीषण संकटों (द्विषः) से पार ले जाने की असीम शक्ति और दयालुता रखने वाले सर्वोच्च देव हैं। 
            अग्नि यहाँ न केवल भौतिक ज्वाला है, बल्कि वह ज्ञान की वह प्रचंड ऊर्जा है जो हमारे भीतर के अज्ञान और नकारात्मकता को समूल जला देती है। 
            जब हम अपनी वाणी को अग्नि की स्तुति में समर्पित करते हैं, तो हमारे विचार शुद्ध होते हैं और हम आध्यात्मिक ऊँचाइयों को सहज ही प्राप्त करते हैं। 
            हे देव, आप हमारे जीवन के संघर्षों में एक शक्तिशाली रक्षक बनकर प्रकट हों और हमें अधर्म के मार्ग से हटाकर धर्म के मार्ग पर ले चलें। 
            आपकी ज्योति हमारे संकल्पों को वह दृढ़ता प्रदान करती है जिससे हम संसार के द्वंद्वों में भी विचलित नहीं होते और सदैव शांत रहते हैं। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आप ही हमारे यज्ञ को देवताओं तक पहुँचाने वाले सबसे विश्वसनीय और पवित्र दूत के रूप में प्रतिष्ठित हैं। 
            यज्ञ की अग्नि में दी गई प्रत्येक आहुति आपके माध्यम से ही सार्थक होती है और हमें वह आत्मिक बल देती है जो विजय के लिए अनिवार्य है। 
            हमें वह विवेक और प्रज्ञा प्रदान करें जिससे हम सत्य को पहचान सकें और मानवता की सेवा में अपने जीवन को पूरी तरह समर्पित कर सकें। 
            हे अग्नि, आप हमारे रक्षक और गुरु बनकर हमें जीवन की जटिलताओं से उबारें और दिव्यता के सर्वोच्च एवं पवित्र शिखर पर सफलतापूर्वक पहुँचाएँ।
        """.trimIndent(),
        englishCommentary = """
            O chanters, sing the sacred Vedic hymns (Brahma) for Lord Agni, who is the wise seer (Vipra) and the invoker of the celestial gods. 
            May Agni carry us across all malicious enemies and daunting calamities (Dwishah) through his boundless strength and mercy. 
            Agni here is not just physical fire but the energy of knowledge that burns away the internal darkness and negativity from our lives. 
            When we dedicate our voice to the praise of Agni, our thoughts become purified, and we attain higher spiritual dimensions of existence. 
            O God, manifest in our struggles as a powerful guardian and steer us away from unrighteousness toward the path of Dharma. 
            Your light provides our resolutions with that firmness through which we remain unshaken and peaceful even amidst worldly dualities. 
            We worship you with devotion because you are the most reliable and sacred messenger who carries our sacrifice to the gods. 
            Every oblation offered in the sacrificial fire becomes meaningful only through you and grants us the spiritual force essential for victory. 
            Bestow upon us the wisdom and discernment to recognize Truth and to dedicate our lives to the selfless service of entire humanity. 
            O Agni, stay as our protector and teacher, rescue us from life's complexities, and lead us to the supreme and holy peaks of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 55,
        sanskrit = "य उग्रः सवनेष्वा तविषीं अधत् सुतः ।\nस इन्द्रो वृत्रहा बभूविथ ॥ ५५ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! आप वही उग्र और प्रचंड पराक्रमी देव हैं, जिन्होंने यज्ञों (**सवनेषु**) में सोमरस के पान से असीम बल और शक्ति धारण की है। 
            आप ही वह **वृत्रहा (वृत्रासुर के संहारक)** हैं, जिन्होंने अज्ञान और जड़ता के प्रतीकात्मक शत्रुओं का नाश कर जगत को प्रकाश और गति प्रदान की। 
            इन्द्र का बल सोम की शुद्धि और यज्ञ की पवित्रता पर आधारित है, जो हमें यह सिखाता है कि आध्यात्मिक शक्ति ही वास्तविक विजय का एकमात्र आधार है। 
            जब हम अपने भीतर के 'वृत्र' (काम, क्रोध और लोभ) को मारते हैं, तभी हमें इन्द्र जैसी अजेय ऊर्जा और शांति की प्राप्ति होती है। 
            हे देव, आप हमारे जीवन के युद्ध क्षेत्र में पधारें और हमारे संकल्पों को वह तेज दें कि हम बुराइयों के विरुद्ध अडिग रहकर सफलतापूर्वक खड़े हो सकें। 
            आपकी विजय ही ब्रह्मांड की व्यवस्था का आधार है, और आपकी प्रसन्नता से ही हमें वर्षा, अन्न और संपन्नता का सुखद वरदान मिलता है। 
            हम अपनी मधुर वाणी और निष्कपट हृदय से आपकी निरंतर स्तुति करते हैं ताकि आप हमारे जीवन के समस्त अमंगलों को सदा के लिए जड़ से भस्म कर दें। 
            आप ही वह सर्वोच्च सत्ता हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें उन्नति के पथ पर निरंतर और सफलतापूर्वक आगे बढ़ाती हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल या असहाय नहीं रहता, क्योंकि उसे परमात्मा के प्रत्यक्ष सहयोग का दिव्य अनुभव होता है। 
            हे अजेय इन्द्र, आप हमारे परम रक्षक और गुरु बनकर हमें अज्ञान के गर्त से निकालकर दिव्यता के शाश्वत प्रकाश की ओर ले चलने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, you are that fierce and formidable deity who has assumed boundless strength by consuming Soma in the sacrificial sessions. 
            You are the Vritrahan (Slayer of Vritra), who destroyed the symbolic enemies of ignorance and stagnation to grant light and motion to the world. 
            Indra's power is rooted in the purification of Soma and the sanctity of the ritual, teaching us that spiritual strength is the true basis of victory. 
            When we slay the 'Vritra' within us (lust, anger, and greed), only then do we attain the invincible energy and peace characterized by Indra. 
            O God, manifest within the battlefield of our lives and grant our resolutions the brilliance needed to stand firm against all evils. 
            Your victory is the foundation of cosmic order, and it is through your satisfaction that we receive the blessings of rain, food, and prosperity. 
            We praise you with our sweet voices and sincere hearts so that you may completely burn away all inauspiciousness from our existence forever. 
            You are the supreme authority that makes our labor meaningful and continuously drives us forward on the path of growth and success. 
            A seeker who takes refuge in Lord Indra never remains weak or helpless, as they experience the divine support of the Almighty directly. 
            O unconquerable Indra, stay as our protector and teacher, pulling us out of the pit of ignorance toward the eternal light of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 56,
        sanskrit = "त्वामिद्धि हवामहे सातौ वाजस्य कारवः ।\nत्वां वृत्रेषु इन्द्र सत्पतिं नरस्त्वां काष्ठास्वर्वतः ॥ ५६ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! हम यज्ञ करने वाले साधक युद्ध में विजय और अजेय सामर्थ्य की प्राप्ति के लिए केवल आपको ही अत्यंत श्रद्धापूर्वक पुकारते हैं। 
            आप ही वह **'सत्पति' (सज्जनों के स्वामी)** हैं जो वृत्रासुर जैसे भयंकर शत्रुओं का नाश कर हमें धर्म की रक्षा का दिव्य बल प्रदान करते हैं। 
            जीवन की कठिन परीक्षाओं और कर्मों के संग्राम में, पराक्रमी वीर योद्धा केवल आपकी ही अजेय शक्ति और मार्गदर्शन का निरंतर आह्वान करते हैं। 
            जैसे वेगवान और अनुशासित अश्व अपने लक्ष्य की ओर दौड़ते हैं, वैसे ही हमारे संकल्प आपकी कृपा से सफलता के सर्वोच्च शिखर की ओर बढ़ें। 
            आप ही वह महाशक्ति हैं जो हमारे जीवन के समस्त आंतरिक और बाह्य अवरोधों को दूर कर ज्ञान और संपन्नता के मार्ग को प्रशस्त करने वाली हैं। 
            हम पूर्ण निष्ठा के साथ आपकी शरण में आए हैं क्योंकि आपके दिव्य सहयोग के बिना वास्तविक विजय और मानसिक शांति प्राप्त करना सर्वथा असंभव है। 
            हे देवराज, आप अपनी अमोघ और प्रचंड शक्ति के साथ हमारे अंतःकरण में प्रदीप्त हों और हमें समस्त सांसारिक संशयों से स्थायी मुक्ति प्रदान करें। 
            आपकी प्रसन्नता से ही इस सृष्टि का चक्र व्यवस्थित रहता है और हमें वर्षा, पुष्टिकारक अन्न तथा उत्तम शारीरिक और मानसिक स्वास्थ्य प्राप्त होता है। 
            हम अपनी पवित्र और सत्यनिष्ठ वाणी से आपकी महिमा का गान करते हैं ताकि आपके सान्निध्य में हमारा जीवन सार्थक, यशस्वी और मंगलमय बने। 
            हे अजेय इन्द्र, आप हमारे परम रक्षक और गुरु बनकर हमें अज्ञान के अंधकार से निकालकर सत्य के शाश्वत प्रकाश की ओर ले चलने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, we the seekers performing the sacrifice invoke only you for obtaining victory and invincible capability in the battles of life. 
            You are the 'Satpati' (Lord of the righteous) who destroys formidable enemies like Vritra and empowers us to protect the Eternal Dharma. 
            In the trials of existence and the struggle of duties, mighty warriors call upon your divine strength and guidance for ultimate success. 
            Just as swift and disciplined horses race toward their target, may our resolutions advance toward the pinnacle of success through your grace. 
            You are the supreme power that removes all internal and external obstacles from our path and opens the gateway to wisdom and prosperity. 
            We seek your refuge with total dedication because without your divine assistance, attaining true victory and mental peace is impossible. 
            O King of Gods, ignite your infallible and fierce power within our consciousness and liberate us from all worldly doubts and anxieties. 
            Your satisfaction ensures the order of the cosmic cycle, granting us timely rain, nourishing food, and superior physical and mental health. 
            We sing your glories with our holy and truthful voices so that our lives become meaningful, successful, and auspicious in your presence. 
            O unconquerable Indra, stay as our supreme protector and teacher, and lead us from the darkness of ignorance to the eternal light of Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 57,
        sanskrit = "न त्वावाँ अन्यो दिव्यो न पार्थिवो न जातो न जनिष्यते ।\nअश्वयन्तो मघवन्निन्द्र वाजिनो गव्यन्तस्त्वा हवामहे ॥ ५७ ॥",
        hindiCommentary = """
            हे मघवन् इन्द्र! आपके समान शक्तिशाली और दयालु न तो कोई दिव्य लोक में है, न इस पृथ्वी पर, न कोई हुआ है और न कभी भविष्य में होगा। 
            आपकी महानता अद्वितीय और अतुलनीय है, आप समस्त ब्रह्मांडीय और सांसारिक शक्तियों के सर्वोच्च स्वामी और अजेय रक्षक के रूप में प्रतिष्ठित हैं। 
            हम शक्ति, विजय और प्रचुर संसाधनों (अश्व और गौओं) की कामना करते हुए आपको अपने इस पवित्र यज्ञ में अत्यंत आदर के साथ आमंत्रित करते हैं। 
            आप ही वह एकमात्र आदि शक्ति हैं जो हमारे जीवन में पूर्णता और प्रचुरता लाने का सामर्थ्य रखती हैं, हम पूर्ण श्रद्धा से आपकी शरण में हैं। 
            आपकी दिव्यता समस्त सीमाओं से परे है, और आप ही 'ऋत' (ब्रह्मांडीय सत्य) के मार्ग के सबसे बड़े संरक्षक और सजग प्रहरी के रूप में जाने जाते हैं। 
            जब हम आपका हृदय की गहराई से आह्वान करते हैं, तो हमारे भीतर एक नई ऊर्जा का संचार होता है जो हमें समस्त मानसिक विकारों पर विजय दिलाती है। 
            संसार की कोई भी बाधा आपके अजेय वज्र के सामने क्षण भर भी टिक नहीं सकती, कृपया आप हमारे मार्ग के समस्त कंटकों को सदा के लिए दूर करें। 
            हमें वह प्रज्ञा और साहस प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रह सकें और अपने जीवन के श्रेष्ठ और महान लक्ष्यों को प्राप्त करें। 
            आपकी कृपा दृष्टि से हमारा संपूर्ण कल्याण और आध्यात्मिक उत्थान सुनिश्चित है, हम आपकी इस भव्य शक्ति की बार-बार हृदय से वंदना करते हैं। 
            हे इन्द्र, आप हमारे परम स्वामी और रक्षक हैं, हमें अज्ञान से ज्ञान की ओर और विनाशकारी अंधकार से शाश्वत दिव्य प्रकाश की ओर सफलतापूर्वक ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Maghavan Indra, there is none as powerful and merciful as you in the heavens, nor on earth; none has existed, nor will ever exist. 
            Your greatness is unique and incomparable; you are the supreme master and invincible guardian of all cosmic and worldly powers. 
            Desiring strength, victory, and abundant resources (Horses and Cows), we invite you to this sacred sacrifice with the highest degree of respect. 
            You are the only primordial power capable of bringing completeness and plenty into our lives; we seek your divine refuge with absolute faith. 
            Your divinity transcends all possible boundaries, and you stand as the greatest protector and sentinel of the Cosmic Law (Rta). 
            When we invoke you from the depths of our hearts, a new surge of energy flows through us, granting us victory over all mental afflictions. 
            No obstacle in this world can withstand your invincible thunderbolt; please remove all the thorns from our life's pathway forever. 
            Grant us the wisdom and courage required to always be ready for the defense of Dharma and to achieve the noble and grand goals of our life. 
            Our complete well-being and spiritual evolution are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power. 
            O Indra, you are our supreme Lord and Protector; lead us away from dark ignorance toward the eternal and radiant light of the Divine.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 58,
        sanskrit = "आ तू नः सोम पवस्व सुवीर्यं पवस्व रयिम् ।\nपवस्व मयः ॥ ५८ ॥",
        hindiCommentary = """
            हे सोमदेव! आप हमारे लिए उत्तम वीरता (सुवीर्यं), श्रेष्ठ धन (रयिम्) और असीम सुख (मयः) प्रदान करने के लिए पवित्र होकर प्रवाहित हों। 
            आपकी यह पावन धारा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, आरोग्यता और सामर्थ्य लाने वाली है, हम आपकी असीम कृपा की याचना करते हैं। 
            वीरता केवल युद्ध में नहीं, बल्कि जीवन की प्रतिकूलताओं में धर्म पर अडिग रहने के लिए भी परम आवश्यक है, कृपया हमें वह बल प्रदान करें। 
            हमें वह धन दें जो न्यायपूर्ण रीति से प्राप्त किया गया हो और जिसका उपयोग हम समाज के दीन-दुखियों की सेवा में अत्यंत गौरव के साथ कर सकें। 
            आपकी कृपा से प्राप्त होने वाला सुख वह आत्मिक शांति है जो बाहरी परिस्थितियों पर निर्भर नहीं करती, बल्कि हृदय के भीतर से आती है। 
            हे देव, आप हमारे अंतःकरण को शुद्ध कर हमें वह दृष्टि दें जिससे हम आपके दिव्य ऐश्वर्य को चराचर जगत के कण-कण में देख सकें। 
            आप ही वह शक्ति हैं जो हमारे जीवन की दरिद्रता और जड़ता को समाप्त कर हमें प्रचुरता और सक्रियता के शिखर पर पहुँचाती हैं। 
            आपकी महिमा का गान करने से हमारे दुखों का नाश होता है और हमें नवीन उत्साह और जीवनी शक्ति की निरंतर प्राप्ति होती रहती है। 
            हे सोम, आप हमारे स्वामी और रक्षक के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली और यशस्वी बनाने की महान कृपा करें। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन हर दृष्टि से सार्थक, पुष्ट और पूर्णतः ईश्वरमय बना रहे।
        """.trimIndent(),
        englishCommentary = """
            O Soma, flow in your purified state to bestow upon us superior valor (Suviryam), excellent wealth (Rayim), and infinite bliss (Mayah). 
            Your holy stream brings prosperity and capability into every single area of our lives; we humbly seek your boundless grace and favor. 
            Valor is required not only in war but also to stay firm on the path of Dharma amidst life's adversities; please grant us that strength. 
            Provide us with that wealth which is obtained through righteous means and which we can use for the service of the needy with pride. 
            The happiness obtained by your grace is that inner peace which does not depend on external situations but arises from within the heart. 
            O God, purify our inner self and grant us the vision to perceive your divine splendor in every particle of the moving and non-moving world. 
            You are the power that terminates the poverty and lethargy of our existence and leads us to the peaks of abundance and activity. 
            Singing your glories destroys our sorrows and grants us a renewed sense of enthusiasm and vital force for our spiritual journey. 
            O Soma, always stay with us as our protector and Lord, graciously making our lives magnificent, successful, and truly renowned. 
            We offer our entire faith at your divine feet so that our lives remain meaningful, nourished, and completely God-conscious in every way.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 59,
        sanskrit = "आ नो मित्रस्य वरुणस्य प्र यंसत् ।\nसोम रयिं सुवीर्यम् ॥ ५९ ॥",
        hindiCommentary = """
            हे सोमदेव! आप हमें मित्र और वरुण देव के समान अत्यंत श्रेष्ठ, पवित्र और मंगलकारी धन प्रदान करने की महान कृपा करें। 
            आप हमें वह 'सुवीर्यम्' (उत्तम वीरता और आध्यात्मिक सामर्थ्य) दें जिससे हम धर्म की रक्षा और समाज का उद्धार करने में सफल हो सकें। 
            मित्र देव ब्रह्मांडीय सौहार्द के प्रतीक हैं और वरुण देव नैतिकता के रक्षक हैं, इन दोनों के महान गुण हमारे चरित्र में समाहित हों। 
            आपकी असीम कृपा से हमें वह ऐश्वर्य प्राप्त हो जो पूर्णतः सत्य और न्याय के मार्ग पर चलकर अर्जित किया गया हो और जो सुखदायी हो। 
            हे देव, हमें केवल भौतिक धन ही नहीं, बल्कि वह प्रज्ञा और चरित्र भी दें जो उस धन का लोक-कल्याण में सदुपयोग करने में सहायक हो। 
            आपकी ज्योति हमारे संकल्पों को वह दृढ़ता प्रदान करे जिससे हम वीरतापूर्वक जीवन की चुनौतियों का सामना कर सकें और कभी न डगमगाएं। 
            हम आपकी निरंतर वंदना करते हैं ताकि हमारे जीवन में अनुशासन, प्रेम और दिव्यता का एक सुंदर और सफल समन्वय सदैव बना रहे। 
            आप ही वह शक्ति हैं जो हमारे कठिन परिश्रम और त्याग को महान सफलता और ईश्वरीय फल में परिवर्तित करने का सामर्थ्य रखती हैं। 
            हे सोम, हमें वह वैभव दें जो हमारे वंश की गरिमा को बढ़ाए और हमें वह आत्मिक शांति प्रदान करे जो संसार में अत्यंत दुर्लभ है। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम ऐश्वर्य पाकर भी अहंकारी न हों और विनम्र बने रहकर सदैव सेवा के मार्ग पर चलें।
        """.trimIndent(),
        englishCommentary = """
            O Soma, please bestow upon us that most excellent, sacred, and auspicious wealth, similar to the gifts of Mitra and Varuna. 
            Grant us 'Suviryam'—superior valor and spiritual capability—so that we may successfully protect Dharma and uplift our society. 
            Mitra represents cosmic harmony and Varuna represents morality; let the noble qualities of both reside within our character. 
            By your boundless grace, let us receive that abundance which is earned by following the path of truth and justice and which brings peace. 
            O God, do not give us just material wealth, but also the wisdom and character required to use that wealth for the welfare of all. 
            May your light provide our resolutions with the firmness needed to face life's challenges heroically without ever wavering. 
            We worship you continuously so that a beautiful balance of discipline, love, and divinity remains always present in our lives. 
            You are the power that possesses the capability to transform our hard labor and sacrifice into magnificent success and divine fruits. 
            O Soma, grant us the splendor that enhances our lineage's dignity and provides us with the inner peace that is rare in the world. 
            May your merciful gaze remain upon us so that even with abundance, we do not become arrogant but stay humble on the path of service.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 60,
        sanskrit = "पवमानो नः पावकः स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ६० ॥",
        hindiCommentary = """
            हे पवमान और पावक सोमदेव! आप स्वर्ग की दिव्य कांति के समान अद्भुत और विविध प्रकार के ऐश्वर्यों के स्वामी हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह पुष्टिकारक अन्न और शक्तिशाली जीवनी शक्ति लेकर आएं जो हमारे जीवन को सफल बनाए। 
            आपकी कृपा से हमारे जीवन में किसी भी वस्तु का लेशमात्र भी अभाव न रहे और हम सदैव सुख, शांति और समृद्धि से संपन्न बने रहें। 
            हे देव, आप हमारे अंतःकरण के समस्त अंधकार और विकारों को शुद्ध कर हमें वह दिव्य दृष्टि दें जिससे हम परमात्मा के दर्शन कर सकें। 
            आप ही वह महाशक्ति हैं जो हमारे जीवन की दरिद्रता और अज्ञान को समाप्त कर हमें प्रचुरता और ज्ञान के सर्वोच्च शिखर पर पहुँचाती हैं। 
            हमें वह 'इषम्' (प्रेरणा और पोषण) प्रदान करें जो हमारे शरीर और आत्मा दोनों को पूर्णतः तृप्त कर हमें दिव्यता की ओर ले जाने वाला हो। 
            आपकी महिमा का निरंतर गान करने से हमारे दुखों का नाश होता है और हमें वह नवीन उत्साह प्राप्त होता है जो हमें कभी थकने नहीं देता। 
            हे सोम, आप हमारे घर और हृदय में एक उदार दाता के रूप में पधारें और हमें वह स्थायी संपत्ति दें जो समय के साथ कभी नष्ट न हो। 
            आपकी ज्योति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और ईश्वर की ओर ले जाने वाले मार्ग का दर्शन कराए। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें अपनी दिव्य छाया में रखें और हमारा मंगलमय जीवन सदैव आपकी मर्यादा में सुरक्षित रहे।
        """.trimIndent(),
        englishCommentary = """
            O Pavamana and Purifying Soma, you are the master of magnificent and extraordinary riches that shine like celestial luster. 
            For us, your devoted chanters, bring forth that powerful nourishment and vital energy that make our lives meaningful and successful. 
            By your grace, let there be no scarcity of any kind in our lives, and may we always remain prosperous, peaceful, and abundant. 
            O God, purify our inner self of all darkness and afflictions and grant us the divine vision to perceive the Presence of the Divine. 
            You are the supreme power that terminates the poverty and ignorance of our existence and leads us to the peaks of plenty and wisdom. 
            Provide us with 'Isham'—divine inspiration and sustenance—that satisfies both our physical body and soul and leads us toward divinity. 
            Singing your glories destroys our sorrows and grants us a renewed sense of enthusiasm that ensures we never grow weary of our duty. 
            O Soma, come into our homes and hearts as the generous giver and grant us that permanent wealth which never perishes with time. 
            Let your light illuminate every dark corner of our existence and continuously show us the pathway leading toward fame, splendor, and God. 
            We pray with devotion that you keep us under your divine shadow and that our auspicious life remains forever safe within your laws.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 61,
        sanskrit = "एतमु त्यं दश यन्तो मृजन्ति सप्त धीतीभिः ।\nअभि प्रियमधारयत् ॥ ६१ ॥",
        hindiCommentary = """
            यह मंत्र साधक की **दस इंद्रियों** और सात प्रकार की प्रज्ञाओं द्वारा मन के शुद्धिकरण का सुंदर चित्रण प्रस्तुत करता है। 
            यहाँ 'दश' का अर्थ हमारी पाँच ज्ञानेंद्रियाँ और पाँच कर्मेंद्रियाँ हैं, जो चैतन्य को सही दिशा प्रदान करती हैं। 
            'सप्त धीति' का संकेत सात चेतना स्तरों या ऋषियों की ऊर्जा से है, जो सोम रूपी दिव्य रस को परिष्कृत करते हैं। 
            जब हमारी इंद्रियाँ और बुद्धि पूरी तरह संयमित होती हैं, तभी हम उस **'प्रिय' तत्व** यानी ईश्वर को हृदय में धारण कर पाते हैं। 
            यह शोधन प्रक्रिया हमें सिखाती है कि बाहरी कर्मकांड केवल आंतरिक पवित्रता को जाग्रत करने का एक माध्यम मात्र हैं। 
            जैसे सोम छननी से छनकर स्वर्णिम हो जाता है, वैसे ही साधना से तपा हुआ व्यक्तित्व संसार में अपनी सत्य की आभा बिखेरता है। 
            हे देव, आप हमारी समस्त वृत्तियों को पवित्र करें ताकि हम केवल उसी आनंद का पान करें जो शाश्वत और अविनाशी है। 
            आपकी उपस्थिति हमारे जीवन के मरुस्थल में शीतलता प्रदान करने वाली वह गंगा है जो समस्त संतापों का शमन कर देती है। 
            हम श्रद्धापूर्वक आपकी सेवा में तत्पर रहते हैं ताकि ज्ञान का यह दिव्य प्रवाह हमारे वंश और समाज को भी आलोकित करे। 
            हे पवमान सोम, आप हमारे अंतःकरण के केंद्र में प्रतिष्ठित होकर हमें अज्ञान के बंधनों से सदा के लिए मुक्त कर दें।
        """.trimIndent(),
        englishCommentary = """
            This mantra represents the beautiful depiction of the purification of the mind through the **ten senses** and seven types of wisdom. 
            The 'ten' refers to our five senses of perception and five senses of action, which direct our consciousness toward the Truth. 
            The 'seven wisdoms' indicate the seven levels of awareness or the energies of the seers that refine the divine essence of Soma. 
            Only when our senses and intellect are disciplined can we truly hold the **'Beloved' element**—the Divine—within our hearts. 
            This refining process teaches us that external rituals are merely a medium to awaken the profound purity residing within us. 
            Just as Soma becomes golden after passing through the filter, a personality tempered by practice radiates the brilliance of Truth. 
            O God, sanctify all our mental tendencies so that we may only drink from that bliss which is eternal and imperishable. 
            Your presence is the celestial river in the desert of our lives, cooling the heat of worldly afflictions and providing relief. 
            We remain dedicated to your service with devotion so that this divine flow of knowledge illuminates our lineage and society. 
            O Pavamana Soma, reside at the very center of our inner self and liberate us forever from the heavy shackles of ignorance.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 62,
        sanskrit = "पुनानः सोम धारया अपो वसानो अर्षसि ।\nआ रत्नधा योनिं ऋतस्य सीदसि ॥ ६२ ॥",
        hindiCommentary = """
            पवित्र किया जाता हुआ सोम अपनी दिव्य धारा के साथ **जल रूपी वस्त्रों** (अपो वसानो) को धारण कर वेगपूर्वक प्रवाहित होता है। 
            रत्नों और श्रेष्ठ गुणों को प्रदान करने वाला यह सोम **'ऋत' (ब्रह्मांडीय सत्य)** के मूल स्थान पर जाकर अत्यंत गरिमा से बैठता है। 
            जल यहाँ जीवन की सृजनात्मक ऊर्जा का प्रतीक है, और सोम का उसमें मिलना शक्ति और शांति के अद्भुत समन्वय को दर्शाता है। 
            जैसे सोम ऋत के स्थान पर प्रतिष्ठित होता है, वैसे ही हमारे प्रत्येक संकल्प को भी सत्य, धर्म और न्याय के आधार पर स्थित होना चाहिए। 
            यह मंत्र हमें प्रेरित करता है कि हम अपने जीवन की यात्रा को दिव्यता से ओत-प्रोत करें ताकि हमारा गंतव्य परमात्मा का परम पद हो। 
            आपकी पावन यात्रा हमारे अंतःकरण को शुद्ध करती है और हमें वह **'रत्न' (विवेक)** प्रदान करती है जो संसार में अप्राप्य है। 
            जब हम आपकी शरण में होते हैं, तब ब्रह्मांड का गूढ़ सत्य हमारे हृदय में स्वतः ही प्रकाशित होने लगता है और हम शांत हो जाते हैं। 
            आप ही वह शक्ति हैं जो हमारे जीवन के साधारण कर्मों को भी यज्ञीय पवित्रता प्रदान कर उन्हें मोक्ष का साधन बना देती हैं। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी कृपा की धारा हमारे परिवार और समाज में सदैव अखंड सुख और शांति लाए। 
            हे पवमान सोम, आप हमारे शाश्वत मार्गदर्शक बनकर हमें सत्य के साक्षात्कार की ओर सफलतापूर्वक और निर्विघ्न ले जाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            The purified Soma flows with its divine stream, appearing as if clothed in the **celestial waters** (Apo Vasano) as it rushes forward. 
            This bestower of treasures and virtues proceeds to seat himself with great dignity upon the source of the **Cosmic Truth (Rta)**. 
            Water here is a symbol of the creative energy of life, and its union with Soma represents a marvelous harmony of power and peace. 
            Just as Soma is established at the seat of Rta, may every resolution of ours also be situated upon the firm foundations of Truth. 
            This mantra inspires us to saturate our life's journey with divinity so that our ultimate destination is the supreme state of God. 
            Your holy journey purifies our inner self and endows us with that **'Gem' of discernment** which is otherwise unattainable in the world. 
            When we seek your refuge, the profound Truth of the universe begins to manifest within our hearts naturally, bringing total calm. 
            You are the power that grants sacrificial sanctity even to the ordinary acts of our lives, transforming them into means for liberation. 
            We worship you with devotion so that the stream of your grace brings unbroken happiness and peace to our families and society. 
            O Pavamana Soma, become our eternal guide and graciously lead us toward the direct realization of Truth, successfully.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 63,
        sanskrit = "अक्षण्वन्तः कर्णवन्तः सखायो मनोजवेषु असमा बभूवुः ।\nआदध्रास उपकक्षास उ त्वे ह्रदा इव स्त्रावा दृश्यन्ते ॥ ६३ ॥",
        hindiCommentary = """
            यह मंत्र स्पष्ट करता है कि आँखों और कानों जैसी इंद्रियों के होने मात्र से कोई भी साधक आध्यात्मिक गहराई नहीं पा सकता। 
            मन की गति और दिव्य सत्यों के दर्शन के क्षेत्र में सभी मित्र या साधक एक समान नहीं होते; उनकी पात्रता साधना पर निर्भर है। 
            कुछ लोग केवल सतही ज्ञान तक ही सीमित रह जाते हैं, जबकि कुछ **गहरे सरोवर (ह्रदा)** के समान ईश्वर के रहस्यों के साक्षात् द्रष्टा बनते हैं। 
            यह मंत्र हमें चेतावनी देता है कि हम बाहरी सूचनाओं के संग्रह को ही वास्तविक ज्ञान न समझ लें, बल्कि हृदय की गहराई में उतरें। 
            वास्तविक प्रज्ञा वही है जो इंद्रियों की सीमा को लांघकर उस अदृश्य सत्ता का अनुभव कर सके जो इस संपूर्ण चराचर जगत में व्याप्त है। 
            जैसे शांत सरोवर ही अपना तल दिखा पाता है, वैसे ही शांत और स्थिर मन ही परमात्मा की छवि को ग्रहण करने में पूर्णतः समर्थ होता है। 
            हे सोम, आप हमें वह दिव्य अंतर्दृष्टि प्रदान करें जिससे हम सांसारिक प्रपंचों के पीछे छिपे आपके वास्तविक स्वरूप को पहचान सकें। 
            आपकी कृपा से ही हमारे भीतर वह बोध विकसित होता है जो हमें सामान्य मनुष्यों की भीड़ से अलग कर ईश्वर का आत्मीय सखा बनाता है। 
            हमें वह मेधा दें कि हम वेदों के गूढ़ संगीत को केवल कानों से न सुनें, बल्कि अपनी आत्मा के प्रत्येक तार में उसे स्पंदित महसूस करें। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन भी उस गहरे सरोवर की भाँति निर्मल, पावन और शांत हो।
        """.trimIndent(),
        englishCommentary = """
            This mantra clarifies that merely possessing senses like eyes and ears does not grant a seeker profound spiritual depth. 
            In the realms of mental speed and the perception of divine truths, all seekers are not equal; it depends on their inner practice. 
            Some individuals remain limited to superficial knowledge, while others, like **deep lakes (Hrada)**, become direct seers of divine mysteries. 
            This verse warns us not to mistake the collection of external information for real wisdom, but to instead dive into the heart. 
            True intellect is that which can transcend the limits of the senses and experience that invisible existence pervading the universe. 
            Just as a calm lake alone can show its bottom, a steady mind is the only vessel capable of reflecting the image of the Supreme. 
            O Soma, grant us that divine insight through which we can recognize your true essence hidden behind the worldly illusions. 
            It is through your grace that the awareness develops within us which distinguishes us from the masses and makes us a friend of God. 
            Bestow upon us the wisdom to not just hear the profound music of the Vedas, but to feel it vibrating in every string of our soul. 
            We offer our entire faith at your divine feet so that our lives may become as pure, holy, and calm as that deep lake.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 64,
        sanskrit = "यस्य ते द्युमतो मदा अच्छा विचेतसा ।\nसोम अर्षसि धारया ॥ ६४ ॥",
        hindiCommentary = """
            हे सोम! आपकी वह **ज्योतिर्मय (द्युमतः)** और आनंददायक धारा, जो विशेष ज्ञान (**विचेतसा**) से युक्त है, निरंतर प्रवाहित हो। 
            आप स्वयं प्रकाश के पुंज हैं, और आपकी धारा हमारे जीवन के अंधकारमय और संशयपूर्ण मार्गों को अपनी ज्योति से आलोकित करती है। 
            सोम का मद कोई सांसारिक नशा नहीं, बल्कि वह **आध्यात्मिक परमानंद** है जो आत्मा को परमात्मा के साथ एकरूप और शांत कर देता है। 
            आपकी यह चेतना हमें वह शक्ति प्रदान करती है जिससे हम जीवन की जटिलताओं को समझकर सत्य का सही मार्ग चुनने में समर्थ होते हैं। 
            हे देव, आप हमारे यज्ञ में अपनी मधुर धारा के साथ पधारें और हमारे संकल्पों को दिव्यता की मिठास और दृढ़ता से पूरी तरह भर दें। 
            जब आपकी अपार कृपा का प्रवाह हमारे जीवन में प्रवेश करता है, तो समस्त दुःख, दरिद्रता और मानसिक व्याधियां सदा के लिए समाप्त हो जाती हैं। 
            हमें वह विशेष बोध प्रदान करें जिससे हम संसार के क्षणभंगुर आकर्षणों के प्रति अनासक्त होकर केवल ईश्वर के सत्य के प्रति समर्पित रहें। 
            आप ही वह महाशक्ति हैं जो हमारे शिथिल पड़ते मन को ऊर्जावान बनाती हैं और हमें निरंतर आध्यात्मिक प्रगति के पथ पर गतिशील रखती हैं। 
            हम श्रद्धापूर्वक आपकी महिमा का गान करते हैं ताकि आपकी उदारता का अमृत प्रवाह हमारे घर और हृदय में सदैव निरंतर बना रहे। 
            हे दिव्य सोम, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और आत्मज्ञान से पूर्ण बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Soma, may your **luminous (Dyumatah)** and intoxicating stream, endowed with special wisdom (**Vichetasa**), flow continuously. 
            You are the mass of light itself, and your current is destined to illuminate the dark and doubtful pathways of our existence with radiance. 
            The intoxication of Soma is not a worldly stupor but that **spiritual ecstasy** which unifies the individual soul with the Divine in silence. 
            This divine consciousness of yours provides us with the power to understand life's complexities and choose the path of Truth. 
            O God, manifest within our sacrifice with your sweet stream and fill our resolutions with the sweetness of divine grace and firm resolve. 
            When the flow of your immense grace enters our lives, all sufferings, poverty, and mental afflictions vanish and terminate forever. 
            Grant us that special awareness through which we remain detached from fleeting attractions and dedicated strictly to the eternal Truth. 
            You are the supreme power that energizes our lethargic minds and keeps us dynamic on the pathway of spiritual evolution and success. 
            We worship you with devotion so that the nectar-like flow of your immense generosity remains forever present within our homes and hearts. 
            O Divine Soma, stay with us as our protector and nourisher, and graciously make our lives magnificent, successful, and full of wisdom.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 65,
        sanskrit = "पवस्व वाजसातये पवस्व परि मंहिष्ठः ।\nपवस्व मयोभुवे ॥ ६५ ॥",
        hindiCommentary = """
            हे पवमान सोम! आप विजय प्राप्त करने (**वाजसातये**) और आंतरिक सामर्थ्य की वृद्धि के लिए अत्यंत पवित्र होकर यहाँ प्रवाहित हों। 
            आप दानियों में सर्वश्रेष्ठ और उदार हैं, कृपया अपनी पावन धारा से हमारे जीवन को सुखकारी और पूर्णतः आनंदमय बनाने की कृपा करें। 
            यह मंत्र संघर्ष के समय ईश्वर से प्राप्त होने वाले उस बल का आह्वान है जो मनुष्य को पराजय के भय और ग्लानि से मुक्त करता है। 
            सोम का प्रवाह हमारे संकल्पों को वह तेज और धार देता है जिससे हम अधर्म की जटिल जंजीरों को सफलतापूर्वक और दृढ़ता से काट सकते हैं। 
            आपकी उदारता केवल भौतिक धन तक सीमित नहीं है, बल्कि वह आत्मज्ञान की उस परम निधि को भी हमें सहज और सरल रूप से प्रदान करती है। 
            जैसे पवित्र धारा कंकड़-पत्थरों को हटाकर अपना रास्ता बनाती है, वैसे ही आप हमारे जीवन मार्ग की समस्त बाधाओं और संशयों को दूर करें। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी कृपा का अमृत हमारे अंतःकरण को सदैव नवीन, स्वच्छ, तेजस्वी और निरंतर ऊर्जस्वित रखे। 
            आप ही वह शक्ति हैं जो हमारे कठिन पुरुषार्थ को ईश्वरीय आशीर्वाद में बदलकर हमें समाज और राष्ट्र में यशस्वी और सम्मानित बनाती हैं। 
            हमें वह आध्यात्मिक प्यास प्रदान करें जो केवल आपके सान्निध्य रूपी अमृत से ही शांत हो सके और हमें पूर्ण शांति और आत्म-तृप्ति प्रदान करे। 
            हे सोम, आप हमारे रक्षक और गुरु बनकर हमें जीवन की सफलता और दिव्यता के सर्वोच्च एवं पवित्र शिखर पर सफलतापूर्वक पहुँचाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Pavamana Soma, flow in your purified state for the attainment of victory (**Vajasataye**) and the expansion of inner strength. 
            You are the most liberal among the givers; graciously make our lives comfortable and blissful with your holy and divine stream. 
            This mantra is an invocation of that divine force which liberates a human being from the fear and guilt of defeat during times of struggle. 
            The flow of Soma provides our resolutions with the edge required to successfully cut through the complex chains of unrighteousness. 
            Your generosity is not limited to material wealth; it also bestows upon us the ultimate treasure of Self-realization and eternal peace. 
            Just as a sacred stream clears pebbles to make its way, may you clear all the obstacles and doubts from our life's spiritual pathway. 
            We worship you with devotion so that the nectar of your grace keeps our inner self forever refreshed, new, radiant, and energized. 
            You are the power that transforms our hard labor into divine blessings, making us successful and respected within our community. 
            Grant us that spiritual thirst which can only be quenched by the nectar of your presence, leading us to absolute satisfaction and peace. 
            O Soma, stay as our protector and guide, leading us to the highest and most sacred peaks of life's success and supreme divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 66,
        sanskrit = "अग्नये ब्रह्म गायत विप्राय देवहूतमये ।\nस नः पर्षत् अति द्विषः ॥ ६६ ॥",
        hindiCommentary = """
            हे स्तोताओं! आप उन अग्निदेव के लिए पवित्र वेदमंत्रों का गान करें, जो परम विद्वान हैं और देवताओं का आह्वान करने वाले दिव्य दूत हैं। 
            वे अग्निदेव हमें समस्त द्वेषी शत्रुओं और भीषण संकटों से पार ले जाने की असीम शक्ति और दयालुता रखने वाले सर्वोच्च रक्षक देव हैं। 
            अग्नि यहाँ न केवल भौतिक ज्वाला है, बल्कि वह ज्ञान की वह प्रचंड ऊर्जा है जो हमारे भीतर के अज्ञान और नकारात्मकता को समूल जला देती है। 
            जब हम अपनी वाणी को अग्नि की स्तुति में समर्पित करते हैं, तो हमारे विचार शुद्ध होते हैं और हम आध्यात्मिक ऊँचाइयों को सहज ही प्राप्त करते हैं। 
            हे देव, आप हमारे जीवन के संघर्षों में एक शक्तिशाली रक्षक बनकर प्रकट हों और हमें अधर्म के मार्ग से हटाकर सदैव सत्य के मार्ग पर ले चलें। 
            आपकी ज्योति हमारे संकल्पों को वह दृढ़ता प्रदान करती है जिससे हम संसार के द्वंद्वों में भी विचलित नहीं होते और सदैव मानसिक रूप से शांत रहते हैं। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आप ही हमारे यज्ञ को देवताओं तक पहुँचाने वाले सबसे विश्वसनीय और पवित्र दिव्य सारथी हैं। 
            यज्ञ की अग्नि में दी गई प्रत्येक आहुति आपके माध्यम से ही सार्थक होती है और हमें वह आत्मिक बल देती है जो विजय और शांति के लिए अनिवार्य है। 
            हमें वह विवेक और प्रज्ञा प्रदान करें जिससे हम सत्य को पहचान सकें और मानवता की सेवा में अपने जीवन को पूरी तरह समर्पित कर सकें। 
            हे अग्नि, आप हमारे रक्षक और गुरु बनकर हमें जीवन की जटिलताओं से उबारें और दिव्यता के सर्वोच्च एवं पवित्रतम शिखर पर सफलतापूर्वक पहुँचाएँ।
        """.trimIndent(),
        englishCommentary = """
            O chanters, sing the sacred Vedic hymns for Lord Agni, who is the wise seer and the invoker of the celestial gods to the ritual. 
            May Agni carry us across all malicious enemies and daunting calamities through his boundless strength and mercy as our supreme guardian. 
            Agni here is not just physical fire but the fierce energy of knowledge that burns away the internal darkness and negativity from our lives. 
            When we dedicate our voice to the praise of Agni, our thoughts become purified, and we easily attain higher spiritual dimensions of existence. 
            O God, manifest in our struggles as a powerful protector and steer us away from unrighteousness toward the eternal and righteous path. 
            Your light provides our resolutions with that firmness through which we remain unshaken and peaceful even amidst worldly dualities. 
            We worship you with devotion because you are the most reliable and sacred messenger who carries our sacrifice directly to the gods. 
            Every oblation offered in the sacrificial fire becomes meaningful only through you and grants us the spiritual force essential for victory. 
            Bestow upon us the wisdom and discernment to recognize Truth and to dedicate our lives to the selfless service of entire humanity. 
            O Agni, stay as our protector and teacher, rescue us from life's complexities, and lead us to the supreme and holy peaks of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 67,
        sanskrit = "य उग्रः सवनेष्वा तविषीं अधत् सुतः ।\nस इन्द्रो वृत्रहा बभूविथ ॥ ६७ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! आप वही उग्र और प्रचंड पराक्रमी देव हैं, जिन्होंने यज्ञों में सोमरस के पान से असीम बल, ओज और अजेय शक्ति धारण की है। 
            आप ही वह **वृत्रहा (अज्ञान के संहारक)** हैं, जिन्होंने जड़ता के प्रतीकात्मक शत्रुओं का नाश कर संपूर्ण जगत को प्रकाश और गति प्रदान की। 
            इन्द्र का बल सोम की शुद्धि और यज्ञ की पवित्रता पर आधारित है, जो हमें यह सिखाता है कि आध्यात्मिक शक्ति ही वास्तविक विजय का एकमात्र आधार है। 
            जब हम अपने भीतर के 'वृत्र' यानी काम, क्रोध और लोभ जैसी आसुरी वृत्तियों को मारते हैं, तभी हमें इन्द्र जैसी अजेय ऊर्जा और शांति की प्राप्ति होती है। 
            हे देव, आप हमारे जीवन के युद्ध क्षेत्र में पधारें और हमारे संकल्पों को वह तेज दें कि हम समस्त बुराइयों के विरुद्ध अडिग रहकर खड़े हो सकें। 
            आपकी विजय ही ब्रह्मांड की व्यवस्था का मुख्य आधार है, और आपकी प्रसन्नता से ही हमें वर्षा, अन्न, संपन्नता और सुखद आरोग्य का वरदान मिलता है। 
            हम अपनी मधुर वाणी और निष्कपट हृदय से आपकी निरंतर स्तुति करते हैं ताकि आप हमारे जीवन के समस्त अमंगलों को सदा के लिए जड़ से भस्म कर दें। 
            आप ही वह सर्वोच्च सत्ता हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें उन्नति के पथ पर निरंतर और सफलतापूर्वक आगे बढ़ाती हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल या असहाय नहीं रहता, क्योंकि उसे परमात्मा के प्रत्यक्ष सहयोग और मार्गदर्शन का दिव्य अनुभव होता है। 
            हे अजेय इन्द्र, आप हमारे परम रक्षक और गुरु बनकर हमें अज्ञान के गर्त से निकालकर दिव्यता के शाश्वत और परम प्रकाश की ओर ले चलने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, you are that fierce and formidable deity who has assumed boundless strength and invincible power by consuming Soma in rituals. 
            You are the **Vritrahan (Slayer of Vritra)**, who destroyed the symbolic enemies of ignorance and stagnation to grant light and motion. 
            Indra's power is rooted in the purification of Soma and the sanctity of the ritual, teaching us that spiritual strength is the true basis of victory. 
            When we slay the 'Vritra' within us—demonic tendencies like lust, anger, and greed—only then do we attain the invincible energy of Indra. 
            O God, manifest within the battlefield of our lives and grant our resolutions the brilliance needed to stand firm against all prevalent evils. 
            Your victory is the foundation of cosmic order, and it is through your satisfaction that we receive the blessings of rain, food, and prosperity. 
            We praise you with our sweet voices and sincere hearts so that you may completely burn away all inauspiciousness from our existence forever. 
            You are the supreme authority that makes our labor meaningful and continuously drives us forward on the path of growth and success. 
            A seeker who takes refuge in Lord Indra never remains weak or helpless, as they experience the support and guidance of the Divine directly. 
            O unconquerable Indra, stay as our protector and teacher, pulling us out of the pit of ignorance toward the eternal light of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 68,
        sanskrit = "त्वं न इन्द्र ऋतयुरपां नेतः परिष्कृतः ।\nमहाँ महीभिः ऊतिभिः ॥ ६८ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! आप सत्य के अनन्य प्रेमी और समस्त जलों एवं ब्रह्मांडीय प्राण-शक्तियों के नियामक (नेतः) के रूप में संपूर्ण जगत में प्रतिष्ठित हैं। 
            आप पवित्रता से परिष्कृत होकर हमारे यज्ञ में अपनी महान और अत्यंत विस्तार वाली रक्षात्मक शक्तियों के साथ पधारने की महान कृपा करें। 
            सत्य का मार्ग ही जीवन का वास्तविक आधार है, और आप उस मार्ग के रक्षक बनकर हमें सदैव धर्म, मर्यादा और न्याय में पूरी तरह प्रतिष्ठित रखते हैं। 
            आपकी दिव्य उपस्थिति हमारे भीतर की प्राण ऊर्जा को शुद्ध करती है और हमें उच्चतर दिव्य चेतना के साथ एकरूप होने का अद्भुत सामर्थ्य प्रदान करती है। 
            जब आप अपनी अजेय शक्तियों के साथ हमारे सहायक बनते हैं, तो संसार की कोई भी प्रतिकूल शक्ति या शत्रु हमें भयभीत करने का साहस नहीं कर सकता। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा दुर्ग बनाती हैं जिसमें केवल सुख, अखंड शांति और पवित्रता का ही निरंतर वास होता है। 
            हम अपनी विनम्र और आर्त पुकार से आपको निरंतर पुकारते हैं ताकि आप हमारे जीवन के प्रत्येक सूक्ष्म अभाव को अपनी अनंत उदारता से पूर्ण कर दें। 
            आप ही वह सर्वोच्च सत्ता हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें आध्यात्मिक एवं भौतिक उन्नति के पथ पर निरंतर आगे बढ़ाती हैं। 
            हे इन्द्र, आप अपनी दिव्य महिमा के साथ हमारे घर और हृदय में विराजें और हमें सदैव अपनी अजेय सुरक्षा की शीतल और मंगलकारी छाया में रखें। 
            आपकी कृपा दृष्टि से हमारा परम कल्याण और अखंड सौभाग्य सुनिश्चित है, हम आपकी इस भव्य शक्ति की बार-बार श्रद्धा और प्रेम से वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, you are established as the lover of Truth and the leader and regulator of all waters and cosmic vital forces. 
            Being refined by purity, please manifest in our sacrifice along with your grand and immensely vast protective divine powers and assists. 
            The path of Truth is the actual foundation of life, and as its protector, you always keep us established in Dharma, morality, and justice. 
            Your sacred presence purifies the vital energy within us and grants us the amazing capability to unify with the higher divine consciousness. 
            When you become our helper with your invincible powers, no adverse force or enemy in the world can ever dare to intimidate or disturb us. 
            Your protective energies build such an impenetrable fortress of security around us, within which only happiness, peace, and purity reside. 
            We invoke you with our humble and sincere cries so that you may fulfill every subtle scarcity of our existence with your infinite generosity. 
            You are the supreme authority that makes our hard work meaningful and continuously drives us forward on the path of evolution and growth. 
            O Indra, reside in our homes and hearts with your divine glory and keep us forever safe under the cool and auspicious shadow of your protection. 
            Our ultimate well-being and unbroken good fortune are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 69,
        sanskrit = "तं वो दस्ममृतीषहं वसोर्मन्दानमन्धसः ।\nअभि वत्सं न मातरो गावो वर्धन्ति वृषभम् ॥ ६९ ॥",
        hindiCommentary = """
            हे श्रेष्ठ भक्तों! आप उन अद्भुत, तेजस्वी और शत्रुओं का दमन करने वाले इन्द्रदेव की स्तुति करें जो पवित्र सोमरस का पान कर आनंदित होते हैं। 
            वे हमें ऐश्वर्य और दिव्य धन प्रदान करने के लिए सदैव तत्पर रहते हैं, और उनकी महान महिमा भक्तों की श्रद्धापूर्ण वाणी से निरंतर बढ़ती और विस्तारित होती है। 
            जैसे माताएं और गौएँ अपने प्रिय बछड़े की ओर अगाध प्रेम और वात्सल्य भाव से दौड़ती हैं, वैसे ही हमारी स्तुतियां और हृदय की पुकार इन्द्र की ओर प्रवाहित होती हैं। 
            आपकी दिव्य उपस्थिति मात्र से हमारे मन की समस्त चंचलता, अशांति और संशय समाप्त होते हैं और हम एकाग्र होकर आपकी असीम सत्ता का अनुभव करते हैं। 
            हे शक्तिशाली इन्द्र, आप हमारे जीवन रूपी यज्ञ के मुख्य आधार हैं और हमारे संपूर्ण अस्तित्व को ऊर्जस्वित करने वाले परम तेजस्वी और अजेय देव हैं। 
            जैसे बछड़ा अपनी माता से पोषण, सुरक्षा और जीवन प्राप्त करता है, वैसे ही हम आपकी असीम कृपा से आध्यात्मिक शांति और भौतिक संपन्नता प्राप्त करते हैं। 
            आपकी उदारता की कोई सीमा नहीं है; आप अपने प्रत्येक शरणागत भक्त को वह सब कुछ प्रदान करते हैं जो उसके सर्वांगीण और श्रेष्ठ विकास के लिए आवश्यक है। 
            हम अपनी मधुर और सत्यनिष्ठ वाणी से आपको प्रसन्न करने का निरंतर प्रयास करते हैं ताकि आप हमारे जीवन के समस्त क्लेशों और दुखों का अंत कर सकें। 
            इन्द्रदेव की पावन शरण में आने वाला साधक कभी रिक्त या असहाय नहीं रहता, उसे ज्ञान के अखंड प्रकाश और अनंत वैभव का दुर्लभ वरदान प्राप्त होता है। 
            हे देवराज, आप हमारे हृदयों में अनन्य भक्ति और निष्कामता का संचार करें और हमें सदैव अपनी दिव्य छाया में सुरक्षित और सुखी रखने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O excellent devotees, praise the wonderful, radiant Lord Indra, the subduer of all foes, who rejoices in the consumption of the sacred Soma nectar. 
            He remains ever ready to bestow abundance and divine prosperity upon us, and his great glory is continuously expanded by our devoted hymns. 
            Just as mothers and cows run with profound love and maternal affection toward their beloved calf, our hymns and heartfelt cries flow toward Indra. 
            Your divine presence alone terminates all the restlessness, turmoil, and doubts of our minds, allowing us to experience your infinite existence with focus. 
            O Mighty Indra, you are the immovable foundation of the sacrifice of our lives and the supremely radiant and invincible deity who energizes us. 
            As a calf receives vital nourishment, protection, and life from its mother, we receive spiritual peace and material plenty through your divine grace. 
            There is no limit to your generosity; you bestow upon every surrendered devotee everything necessary for their holistic and superior development. 
            We strive to please you with our sweet and truthful voices so that you may bring a definitive end to all the afflictions and sorrows of our life. 
            A seeker who takes refuge in Lord Indra never remains empty or helpless; they are blessed with the light of knowledge and the gift of infinite splendor. 
            O King of Gods, infuse our hearts with exclusive devotion and selflessness, and keep us forever protected and happy under your divine shadow.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 70,
        sanskrit = "नृभिरतक्षितो वाजां अभि प्र गाहा मक्षूणी ।\nस सखा शिवो भव ॥ ७० ॥",
        hindiCommentary = """
            हे इन्द्रदेव! आप मनुष्यों, ऋषियों और विद्वानों द्वारा अपनी पवित्र और ओजस्वी स्तुतियों के माध्यम से निरंतर संवर्धित और प्रदीप्त किए जाने वाले महान देव हैं। 
            आप हमारे लिए शीघ्र ही वह अजेय शक्ति, प्रचुर अन्न, स्वास्थ्य और विजय लेकर आने की कृपा करें जो हमारे जीवन को प्रत्येक दृष्टि से पूर्णतः उन्नत बना सके। 
            आप हमारे लिए एक परम कल्याणकारी और अत्यंत आत्मीय मित्र (सखा) बनकर हमारे जीवन की इस दुर्गम और चुनौतीपूर्ण यात्रा को सुगम और सफल बनाएं। 
            आपकी यह दिव्य मित्रता संसार के सभी अस्थायी और स्वार्थी संबंधों से श्रेष्ठ है क्योंकि आप विपत्ति के समय कभी भी अपने भक्त का साथ नहीं छोड़ते। 
            हे देव, हमें वह अटूट आत्मबल और साहस प्रदान करें जिससे हम जीवन के भीषण संघर्षों में विजयी होकर समाज में एक गौरवपूर्ण स्थान प्राप्त कर सकें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हमारे घरों, परिवारों और समाज में संसाधनों और सुख-शांति का कभी भी लेशमात्र भी अभाव होने की स्थिति न आए। 
            जब आप हमारे सखा और मार्गदर्शक बनते हैं, तब संसार की कोई भी बड़ी बाधा हमारे आध्यात्मिक, मानसिक या भौतिक मार्ग में कभी भी रुकावट नहीं बन सकती। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आप ही हमारे कठिन परिश्रम, त्याग और पुरुषार्थ को ईश्वरीय फल और महान दिव्य सफलता में बदलने वाले देव हैं। 
            आपकी ऊर्जा हमारे प्राणों में उत्साह, अटूट आशा और उच्च चेतना बनकर बहती है, जो हमें सदैव श्रेष्ठ, पवित्र और परोपकारी कर्म करने के लिए निरंतर प्रेरित करती है। 
            हे इन्द्र, आप हमारे परम रक्षक और गुरु के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, ज्ञानी, यशस्वी, धर्मनिष्ठ और परोपकारी बनाने की असीम कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, you are the magnificent deity who is continuously increased and glorified through the powerful hymns of men, sages, and scholars. 
            Graciously bring to us very quickly that invincible power, abundant nourishment, health, and victory which will elevate our lives in every aspect. 
            Become a supremely benevolent and highly intimate friend to us, making this difficult and challenging journey of life smooth, easy, and successful. 
            Your divine friendship is superior to all temporary, fleeting, and selfish worldly relationships because you never abandon your devotee in distress. 
            O God, provide us with the unshakable inner strength and courage required to emerge victorious in life's fierce struggles and attain a dignified position. 
            May your merciful gaze remain upon us so that there is never even a trace of shortage of resources, joy, or peace within our homes and society. 
            When you become our companion and guide, no major obstacle of the world can ever block our spiritual, mental, or material progress and evolution. 
            We worship you with deep devotion, for it is you who transforms our hard labor, sacrifice, and efforts into divine results and magnificent successes. 
            Your energy flows through our being as enthusiasm, hope, and higher consciousness, perpetually inspiring us to perform noble and altruistic deeds. 
            O Indra, stay with us as our protector and teacher, graciously making us magnificent, knowledgeable, successful, and devoted to Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 71,
        sanskrit = "आ तू न इन्द्र वृत्रहन् अस्माकं अर्धमा गहि ।\nमहाँ महीभिः ऊतिभिः ॥ ७१ ॥",
        hindiCommentary = """
            हे वृत्रहन् (अज्ञान और समस्त बुराइयों का नाश करने वाले) इन्द्र! आप हमारे इस यज्ञीय स्थल और हमारे पक्ष में अपनी असीम दया और कृपा के साथ अवश्य पधारें। 
            आप अपनी महान और अत्यंत विशाल रक्षात्मक शक्तियों (महीभिः ऊतिभिः) के साथ हमारे जीवन के प्रत्येक संघर्ष में एक सजग सहायक और रक्षक बनकर आएं। 
            आपकी दिव्य उपस्थिति हमारे संकल्पों को वह फौलादी दृढ़ता और ईश्वरीय शक्ति प्रदान करती है जिससे हम जीवन की किसी भी कठिन परिस्थिति में कभी नहीं डगमगाते। 
            जब आप हमारे साथ होते हैं, तब हमें संसार की किसी भी असुर शक्ति, नकारात्मक ऊर्जा या बाधा से तनिक भी भयभीत होने की तनिक भी आवश्यकता नहीं है। 
            हे देवराज, आप हमारे भीतर के अज्ञान रूपी वृत्रासुर का समूल नाश कर हमारे मन में ज्ञान और विवेक की निर्मल और पवित्र गंगा प्रवाहित करने की महान कृपा करें। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा दुर्ग बनाती हैं जिसमें कोई भी बुराई, पाप, रोग या मानसिक विकार कभी भी प्रवेश नहीं कर सकता। 
            हम अपनी विनम्र और हृदयस्पर्शी प्रार्थनाओं से आपको निरंतर पुकारते हैं ताकि आप हमारे जीवन के अंधकार को अपनी दिव्य ज्योति से सदा के लिए मिटा सकें। 
            आप ही वह सर्वोच्च और आदि शक्ति हैं जो हमारे प्रत्येक परिश्रम को सार्थकता प्रदान करती हैं और हमें आध्यात्मिक एवं भौतिक उन्नति के पथ पर ले चलती हैं। 
            हे इन्द्र, आप अपनी अनंत उदारता और वैभव के साथ हमारे घर और हृदय में विराजें और हमें अपने मंगलकारी और दिव्य आशीषों से निरंतर कृतार्थ करें। 
            आपकी कृपा दृष्टि से हमारा संपूर्ण कल्याण, सुख और मंगल सुनिश्चित है, हम आपकी इस भव्य और अजेय शक्ति की बार-बार अत्यंत श्रद्धा से वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the slayer of Vritra (the forces of ignorance and evil), please do come graciously to our sacrificial ground and take our side. 
            Arrive in our lives as a vigilant helper and guardian along with your grand and immensely vast protective powers and divine assistances. 
            Your sacred presence provides our resolutions with that steel-like firmness and divine strength needed to remain unshaken in any situation. 
            When you are with us, there is absolutely no need for us to fear any demonic force, negative energy, or obstacle that the material world presents. 
            O King of Gods, graciously destroy the Vritra of ignorance within our hearts and let the pure and holy river of knowledge flow within our minds. 
            Your protective energies build such an impenetrable shield around us that no form of evil, sin, disease, or mental affliction can ever enter. 
            We invoke you with our humble and heartfelt supplications so that you may erase the darkness of our existence with your divine light forever. 
            You are the supreme and primordial power that makes our every effort meaningful and carries us forward on the path of evolution and growth. 
            O Indra, reside in our homes and hearts with your infinite generosity and splendor, and bless us with your most auspicious and divine favors. 
            Our complete well-being, happiness, and auspiciousness are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 72,
        sanskrit = "त्वं हि नः प्रमतिस्त्वं पिता त्वं माता शतक्रतो बभूविथ ।\nअधा ते सुम्नमीमहे ॥ ७२ ॥",
        hindiCommentary = """
            हे शतक्रतो इन्द्र! आप ही हमारी श्रेष्ठ बुद्धि और विवेक हैं, आप ही हमारे परम पिता और आप ही हमारी स्नेहमयी और करुणामयी माता के रूप में प्रतिष्ठित हैं। 
            आप ही हमारे संपूर्ण अस्तित्व के आधार और एकमात्र सच्चे हितैषी बनकर हमारे जीवन में प्रकट हुए हैं और निरंतर हमारा लालन-पालन और पोषण कर रहे हैं। 
            जैसे माता-पिता अपने अबोध बालक की हर प्रकार के ज्ञात और अज्ञात संकटों से रक्षा और पोषण करते हैं, वैसे ही आप हमारी सूक्ष्म और स्थूल देखभाल करते हैं। 
            हम आपसे वह 'सुम्नम्' (परम सुख और अखंड आत्मिक शांति) मांगते हैं जो केवल आपकी शरण में आने वाले सच्चे और निष्कपट भक्तों को ही प्राप्त होता है। 
            आपकी विलक्षण बुद्धिमत्ता हमें जीवन के कठिन और जटिल निर्णयों में सही दिशा दिखाती है और हमें अज्ञान के भ्रामक जाल से सफलतापूर्वक बाहर निकालती है। 
            हे देवराज, हमारे प्रति आपके वात्सल्य और स्नेह की कोई सीमा नहीं है, और हम एक समर्पित और श्रद्धालु संतान के रूप में आपकी पावन वंदना निरंतर करते हैं। 
            आपकी असीम कृपा से ही हमें वह मानसिक शांति और स्थिरता प्राप्त होती है जो संसार की किसी भी नश्वर और भौतिक वस्तु में अत्यंत दुर्लभ और अप्राप्य है। 
            हम अपनी संपूर्ण श्रद्धा, प्रेम और अडिग विश्वास आपके चरणों में अर्पित करते हैं ताकि आप हमें सदैव अपनी दिव्य छाया में पूर्णतः सुरक्षित रखें और सुखी रखें। 
            हे इन्द्र, आप हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता लाएं और हमें यशस्वी बनाने के साथ-साथ आत्मज्ञान के अखंड प्रकाश से भी आलोकित करने की कृपा करें। 
            आपकी यह तेजस्वी धारा हमारे भीतर के अज्ञान को समूल नष्ट कर हमें परम सत्य और परमात्मा के साक्षात्कार की ओर सफलतापूर्वक ले जाने की महान कृपा करे।
        """.trimIndent(),
        englishCommentary = """
            O Shatakratu Indra, you are established as our superior intellect and discernment, our supreme Father, and our most affectionate and merciful Mother. 
            You have manifested in our lives as the foundation of our entire existence and our only true well-wisher, continuously nurturing and nourishing us. 
            Just as parents protect and nourish their innocent child from all kinds of known and unknown dangers, you take care of our subtle and physical needs. 
            We seek from you that 'Sumnam' (supreme bliss and spiritual peace) which is only granted to true and sincere devotees seeking your holy refuge. 
            Your extraordinary intelligence shows us the right direction during life's complex decisions and pulls us out of the illusory web of ignorance. 
            O King of Gods, there is no limit to your maternal affection and love for us, and we worship you with the simple heart of a dedicated child. 
            By your boundless grace alone do we find the mental tranquility and stability that is extremely rare and unattainable in any perishable worldly object. 
            We offer our complete faith, love, and unwavering trust at your divine feet so that you may forever keep us fully safe within your shadow. 
            O Indra, bring abundance into every field of our existence and make us successful while illuminating us with the light of Self-realization. 
            May your radiant stream completely destroy the root of our ignorance and successfully lead us to the realization of the Supreme Truth and God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 73,
        sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ ७३ ॥",
        hindiCommentary = """
            हे श्रेष्ठ मार्ग दिखाने वाले इन्द्र! आप इस पवित्र सोमरस का पान करें जो आपको अत्यंत हर्ष, आनंद, तृप्ति और नवीन ऊर्जा प्रदान करने वाला है। 
            आपका यह आनंद समस्त प्रजाओं को तृप्त करने वाला है और आप स्वयं असीम शक्ति के पुंज के रूप में इस संपूर्ण ब्रह्मांड के कण-कण में प्रतिष्ठित हैं। 
            हम इस विशेष यज्ञीय अनुष्ठान में आपको प्रसन्न करने के लिए अपनी स्तुतियों और अपार श्रद्धा के साथ आपकी अनन्य सेवा, भक्ति और अर्चना करते हैं। 
            आपकी दिव्य ऊर्जा से ही यह संपूर्ण चराचर जगत और इसकी समस्त सूक्ष्म गतियाँ संचालित होती हैं, और सोम का पान कर आप और अधिक तेजस्वी हो जाते हैं। 
            हे देवराज, हमारे इस अनुष्ठान को अपनी पावन उपस्थिति से पवित्र करें और हमें वह आंतरिक बल दें कि हम सदैव सत्य, न्याय और धर्म की रक्षा कर सकें। 
            जैसे वर्षा की शीतल बूंदों से प्यासी धरती तृप्त होती है, वैसे ही आपकी कृपा से हमारे जीवन के समस्त अभाव, दुख और कष्ट सदा के लिए जड़ से दूर हो जाते हैं। 
            हम अत्यंत श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमारे जीवन को सुख, अखंड शांति और भौतिक एवं आध्यात्मिक समृद्धि से सदा के लिए परिपूर्ण कर दें। 
            आपकी यह दिव्य और अजेय शक्ति हमें संशय के अंधकार से बाहर निकालती है और हमें सत्यनिष्ठा तथा दृढ़ चरित्र की अद्भुत शक्ति और अटूट साहस प्रदान करती है। 
            हे इन्द्र, आप हमारे सबसे निकट के आत्मीय संबंधी बनकर हमें वह दिव्य सुख दें जो संसार की क्षणभंगुर और नश्वर वस्तुओं में सर्वथा दुर्लभ और कठिन है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा हृदय सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम सदैव परमात्मा के समीप रहें।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the leader on the most excellent path, please drink this holy Soma which grants you immense joy, exhilaration, satisfaction, and new energy. 
            Your bliss is that which satisfies and nourishes all living beings, and you are established in this universe as the source of infinite power. 
            In this special sacrificial ritual, we offer our exclusive service with hymns and deep faith to please and glorify your supreme divinity. 
            It is through your divine energy that this entire moving and non-moving universe is governed; by consuming Soma, you become more radiant. 
            O King of Gods, sanctify this ritual of ours with your holy presence and grant us the inner strength to always protect and serve Truth and Dharma. 
            Just as the thirsty earth is satisfied by cool raindrops, all the scarcities, sorrows, and afflictions of our lives vanish forever by your grace. 
            We bow before your feet with profound devotion so that you may fill our lives with happiness, unbroken peace, and holistic prosperity. 
            Your divine and invincible power pulls us out of the darkness of doubt and grants us the amazing strength of integrity and firm character. 
            O Indra, become our nearest and most intimate relative and bestow upon us that divine bliss which is totally rare in fleeting worldly things. 
            We constantly sing your glories so that our hearts remain forever illuminated with the light of devotion and knowledge near the Divine.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 74,
        sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ ७४ ॥",
        hindiCommentary = """
            हे दिव्य शक्तियों के ज्ञाता भक्तों! मैं उन इन्द्रदेव की स्तुति करता हूँ जो समस्त प्रजाओं के परम स्वामी और बलवानों में भी सर्वश्रेष्ठ वीर के रूप में प्रतिष्ठित हैं। 
            वे अनेक महान यज्ञों और अत्यंत प्राचीन एवं शक्तिशाली स्तुतियों के एकमात्र अधिकारी हैं, और उनकी शक्ति की सीमा का पार पाना किसी के लिए संभव नहीं। 
            इन्द्र ही वह सर्वोच्च सत्ता हैं जो ब्रह्मांड के न्याय, अनुशासन और संतुलन को बनाए रखने के लिए अपनी प्रचंड और अजेय शक्ति का निरंतर प्रयोग करते हैं। 
            उनकी महिमा का भक्तिपूर्वक गान करने से मनुष्य के भीतर के सुप्त साहस, वीरता और दिव्य ओज का जागरण होता है, जिससे वह जीवन के प्रत्येक क्षेत्र में विजयी बनता है। 
            हे देव, आप हमारे जीवन के प्रत्येक अंधकारमय पक्ष को दूर कर हमें वह तेज प्रदान करें जिससे हम समाज और राष्ट्र में गौरवपूर्ण और सम्मानित स्थान प्राप्त कर सकें। 
            आपकी कृपा से हमें वह ऐश्वर्य और धन प्राप्त हो जो पूर्णतः सत्य के मार्ग पर चलकर अर्जित किया गया हो और जो समस्त मानवता के लिए परम कल्याणकारी हो। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे अंतःकरण को शुद्ध कर हमें ईश्वर के वास्तविक सान्निध्य और अखंड आत्मिक शांति का दिव्य अनुभव कराते हैं। 
            आप ही वह पराशक्ति हैं जो हमारे द्वारा किए गए कठिन परिश्रम को ईश्वरीय फल में और हमारी आर्त प्रार्थनाओं को महान दिव्य आशीर्वादों में बदलने का सामर्थ्य रखती हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल या असहाय नहीं रहता, क्योंकि उसे आत्मज्ञान की प्रखरता और भौतिक संपन्नता दोनों का दुर्लभ वरदान मिलता है। 
            हे इन्द्र, आप हमारे रक्षक और शाश्वत मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें महान, यशस्वी, सुखी और धर्मनिष्ठ बनाने की असीम कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O devotees who know the divine powers, I praise Lord Indra, the supreme master of all subjects and the foremost among the strong. 
            He is the sole rightful recipient of many great sacrifices and ancient hymns, and no being can ever surpass the limit of his might. 
            Indra is the supreme authority who utilizes his fierce and invincible power to maintain the justice, discipline, and balance of the universe. 
            Singing his glories with devotion awakens the dormant courage, heroism, and vigor within a person, enabling them to emerge victorious in life. 
            O God, remove every dark aspect of our existence and bestow upon us that brilliance which allows us to attain a place of honor in society. 
            By your grace, let us receive that wealth which is earned strictly by following the path of Truth and which is beneficial for all of humanity. 
            We worship you because you are the one who purifies our inner self and allows us to experience the proximity of God and spiritual peace. 
            You are the supreme power that transforms our hard labor into divine results and our desperate prayers into magnificent celestial blessings. 
            A seeker who takes refuge in Lord Indra never remains weak or helpless; they are blessed with the sharpness of self-knowledge and abundance. 
            O Indra, stay with us as our protector and eternal guide, and graciously make us great, successful, renowned, and devoted to Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 75,
        sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ ७५ ॥",
        hindiCommentary = """
            हे मेरे श्रेष्ठ मित्रों और साधकों! आप उन इन्द्रदेव के लिए अत्यंत आनंददायक और भक्तिपूर्ण गीतों का गान करें जो अश्वों के स्वामी और सोम के परम पानकर्ता हैं। 
            आपकी मधुर वाणी से निकले हुए ये पवित्र भजन इन्द्र को प्रसन्न करते हैं और उन्हें हमारे इस यज्ञीय अनुष्ठान में साक्षात् पधारने के लिए सादर आमंत्रित करते हैं। 
            इन्द्रदेव की अजेय शक्ति का रहस्य सोम के श्रद्धापूर्ण पान और भक्तों की निष्कपट पुकार में छिपा है, जो उन्हें संपूर्ण ब्रह्मांड में अजेय और अजर बना देता है। 
            जब हम सामूहिक रूप से उनकी महिमा गाते हैं, तो हमारे चारों ओर एक अत्यंत सकारात्मक, ऊर्जावान और दिव्य वातावरण का निर्माण स्वतः ही होने लगता है। 
            हे देव, आप अपने तेजस्वी और वायु के समान तीव्र घोड़ों पर सवार होकर हमारे जीवन के कठिन संघर्षों में आएं और हमारे समस्त आंतरिक शत्रुओं का संहार करें। 
            हमें वह अटूट भक्ति और एकाग्रता प्रदान करें जिससे हम आपकी विराट और सर्वव्यापी सत्ता का अनुभव अपने भीतर कर सकें और सदैव मानसिक रूप से शांत रहें। 
            आपकी कृपा से हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, अखंड सौभाग्य और आध्यात्मिक श्रेष्ठता प्राप्त करने की दिव्य शक्ति और प्रेरणा मिले। 
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि हमारा जीवन सदैव लोक-कल्याण, परोपकार और सत्य की सेवा में लगा रहे और हम निरंतर आत्मोन्नति करें। 
            इन्द्रदेव की पवित्र मित्रता हमारे लिए वह अभेद्य सुरक्षा कवच है जो हमारे समस्त संशयों, भयों और दुखों को जड़ से समाप्त कर हमें पूर्णतः निर्भय बना देती है। 
            हे इन्द्र, आप हमारे परम स्वामी, रक्षक और गुरु हैं; हमें अज्ञान के अंधकार से निकालकर आत्मज्ञान के परम प्रकाश और परमात्मा के शाश्वत सत्य की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O my dear friends and fellow seekers, sing exhilarated and highly devoted songs for Lord Indra, the master of horses and the drinker of Soma. 
            These sacred hymns arising from your sweet voices delight Indra and invite him to manifest personally within our sacrificial ritual today. 
            The secret of Indra's invincible might lies in the devoted consumption of Soma and the sincere calls of his devotees, making him unsurpassed. 
            When we collectively sing his glories, an extremely positive, energetic, and divine atmosphere begins to manifest around us automatically. 
            O God, riding upon your radiant horses that are as swift as the wind, come into the difficult struggles of our life and destroy all our internal enemies. 
            Grant us that unshakable devotion and focus which enables us to experience your vast and omnipresent existence within us and remain calm. 
            By your grace, remove every lack from our lives and grant us the divine power and inspiration to attain completeness and spiritual excellence. 
            We worship you with devotion so that our life remains dedicated to public welfare, altruism, and the service of Truth, helping us grow inwardly. 
            The holy friendship of Lord Indra is that impenetrable shield for us which completely uproots all our doubts, fears, and sorrows, making us bold. 
            O Indra, you are our supreme Lord, Protector, and Teacher; lead us out of the darkness of ignorance toward the light of Self-realization and Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 76,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ ७६ ॥",
        hindiCommentary = """
            समस्त स्तुतियां और प्रार्थनाएं समुद्र के समान विशाल और सर्वव्यापी इन्द्रदेव की महिमा को निरंतर बढ़ाती और पूरे संसार में अत्यंत गौरव के साथ प्रकाशित करती हैं। 
            वे रथियों में श्रेष्ठ और समस्त विजयों के अधिपति हैं, जिनकी बार-बार अत्यंत श्रद्धा के साथ प्रशंसा और गौरवपूर्ण वंदना की जानी चाहिए। 
            इन्द्र की व्यापकता आकाश और समुद्र की तरह अनंत और अथाह है, जिसमें संपूर्ण ब्रह्मांड की शक्तियाँ सुरक्षित और पूर्णतः समाहित रहती हैं। 
            वे हमारे जीवन रूपी रथ के सबसे कुशल और दिव्य सारथी हैं, जो हमें संसार की समस्त बाधाओं के बीच से सफलतापूर्वक और निर्विघ्न निकाल ले जाते हैं। 
            हे देव, आप अपनी प्रचंड शक्ति और अपार बुद्धिमत्ता से हमारे प्रत्येक प्रयास को सफलता के उच्चतम और श्रेष्ठ शिखर तक पहुँचाने की महान कृपा करें। 
            हमें वह आध्यात्मिक और भौतिक शक्ति प्रदान करें जिससे हम निर्बलों की सहायता कर सकें और धर्म की ध्वजा को सदैव इस जगत में ऊँचा रख सकें। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की पूर्ण शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत, सचेत और पवित्र होने लगते हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी भी पराजित नहीं होता, क्योंकि स्वयं संपूर्ण ब्रह्मांड का नायक उसका सहायक, रक्षक और परम मित्र बन जाता है। 
            आपकी दिव्य दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और शाश्वत कीर्ति का सही मार्ग निरंतर दिखाए, यही हमारी विनम्र प्रार्थना है। 
            हे इन्द्र, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और आत्मिक रूप से सुखी बनाने की महान कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            All the hymns and prayers continuously increase and illuminate the glory of Lord Indra, who is as vast and all-encompassing as the ocean. 
            He is the foremost among divine charioteers and the Lord of all victories, worthy of being praised and glorified with deep devotion. 
            The expanse of Indra's presence is infinite and unfathomable like the sky and the sea, within which all cosmic powers are safely contained. 
            He is the most skillful and divine charioteer of our life's vessel, guiding us expertly and safely through the various obstacles of the world. 
            O God, with your fierce power and immense wisdom, graciously lead our every effort to the absolute peak of success and excellence. 
            Bestow upon us both spiritual and material power so that we can assist the weak and keep the flag of righteousness flying high in the world. 
            The continuous singing of your glories completely purifies our inner self and initiates our constant spiritual awakening and divine awareness. 
            A seeker who takes refuge in Lord Indra is never defeated, for the hero of the entire universe becomes their personal helper and friend. 
            Let your divine radiance illuminate every dark corner of our existence and show us the pathway to fame, splendor, and eternal glory. 
            O Indra, always remain with us as our protector and nourisher, graciously making our lives magnificent, successful, and truly happy.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 77,
        sanskrit = "एवा ह्यासि वीरयुरेतदस्मासु धेहि ।\nमहाँ हि शतक्रतो ॥ ७७ ॥",
        hindiCommentary = """
            हे शतक्रतो इन्द्र! आप वास्तव में वीरता, पराक्रम और आत्मबल के प्रेमी हैं, कृपया हमारे भीतर भी वही वीरता और अडिग साहस स्थापित करें। 
            आप अत्यंत महान और तेजस्वी हैं, हमारे जीवन के श्रेष्ठ संकल्पों को दृढ़ता प्रदान करें ताकि हम धर्म की रक्षा के लिए सदैव तत्पर रह सकें। 
            सच्ची वीरता वह नहीं जो केवल बाह्य युद्ध में दिखे, बल्कि वह है जो हमें अपने भीतर के विकारों और शत्रुओं पर विजय पाने की अद्भुत शक्ति प्रदान करती है। 
            आपकी कृपा से हमें वह ओज और तेज प्राप्त हो जिससे हम समाज में सत्य और न्याय का मार्ग प्रशस्त करने वाले निस्वार्थ योद्धा बन सकें। 
            हे देवराज, आप हमारे भीतर के प्रत्येक सूक्ष्म डर को समाप्त कर हमें पूर्णतः निर्भीक, शांत और आत्मविश्वासी बनाने की महान कृपा करें। 
            जब आप हमारे हृदय में साहस का दिव्य बीज बोते हैं, तब संसार की कोई भी प्रतिकूल परिस्थिति या अभाव हमें कभी विचलित नहीं कर सकता। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी महानता का एक अंश हमारे चरित्र में भी झलके और हम मानवता के लिए श्रेष्ठ बन सकें। 
            आप ही वह शक्ति हैं जो हमारे शिथिल और थके हुए मन में नवीन ऊर्जा का संचार कर हमें निरंतर कर्मयोग की ओर सफलतापूर्वक अग्रसर करती हैं। 
            हे इन्द्र, हमें वह आध्यात्मिक सामर्थ्य दें कि हम सांसारिक प्रलोभनों से ऊपर उठकर ईश्वर के वास्तविक और शाश्वत सत्य स्वरूप को पा सकें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके संरक्षण में सदैव निर्भय होकर एक गौरवशाली और सार्थक जीवन व्यतीत करने में सफल हों।
        """.trimIndent(),
        englishCommentary = """
            O Shatakratu Indra, you are truly the lover of heroism, valor, and inner strength; please instill that same valor and unshakable courage within us. 
            You are exceedingly great and radiant; grant firmness to the noble resolutions of our lives so that we are always ready for the defense of Dharma. 
            True heroism is not just seen in physical external war, but in the power that enables us to conquer our own inner flaws and hidden enemies. 
            By your grace, let us receive that vigor and luster which transform us into selfless warriors who pave the way for Truth and Justice in society. 
            O King of Gods, graciously terminate every subtle fear within us and make us completely fearless, calm, and self-confident. 
            When you sow the divine seed of courage in our hearts, no adverse circumstance or scarcity of the world can ever sway or disturb us. 
            We worship you with devotion so that a fraction of your greatness reflects in our character and we become superior beings for humanity. 
            You are the power that infuses fresh energy into our lethargic and tired minds, pushing us successfully toward the path of Karma Yoga. 
            O Indra, give us the spiritual capability to rise above worldly temptations and attain the true essence of the Divine and Eternal Truth. 
            May your merciful gaze always remain upon us as we lead a glorious and meaningful life successfully under your supreme divine protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 78,
        sanskrit = "तं घेमित्था नमस्विन उप स्वराजमासते ।\nहोत्रभिरिन्द्रं वावृधुः ॥ ७८ ॥",
        hindiCommentary = """
            हे भक्तों! जो इन्द्रदेव स्वयं प्रकाशित और अपने ही साम्राज्य में पूर्णतः प्रतिष्ठित हैं, भक्त उनकी परम उपासना और नमस्कार करते हैं। 
            वे 'होता' के पवित्र आह्वान और यज्ञीय आहुतियों के माध्यम से निरंतर प्रदीप्त और भक्तों के हृदयों में संवर्धित किए जाते हैं। 
            इन्द्र की यह 'स्वराज' अवस्था मनुष्य को आत्म-संयम, आत्म-बोध और वास्तविक आत्म-निर्भरता का महान आध्यात्मिक संदेश प्रदान करती है। 
            जब हम अपनी दसों इंद्रियों के स्वामी स्वयं बन जाते हैं, तब हम अपने भीतर इन्द्र के उस दिव्य और तेजस्वी स्वरूप का अनुभव कर सकते हैं। 
            यज्ञ की पवित्र अग्नि में दी गई प्रत्येक आहुति इन्द्र के बल को बढ़ाती है, जो अंततः ब्रह्मांडीय संतुलन के रूप में हमारे ही कल्याण के लिए आती है। 
            हे देव, आप अपनी असीम महिमा के साथ हमारे जीवन के प्रत्येक कठिन कार्य में सहायक बनकर हमें पूर्ण सफलता की ओर ले जाएं। 
            आपकी निरंतर उपासना से हमारे मन के समस्त संशय दूर होते हैं और हमें वह दिव्य स्पष्टता प्राप्त होती है जिससे हम सत्य को जान सकें। 
            हम श्रद्धापूर्वक आपके सम्मुख नतमस्तक हैं ताकि आपकी न्यायपूर्ण और दयालु दृष्टि हमें सदैव उन्नति के मार्ग पर अग्रसर रखे। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे सूक्ष्म संकल्पों को ब्रह्मांडीय सिद्धियों और भौतिक प्रचुरता में बदलने का सामर्थ्य रखती हैं। 
            हे इन्द्र, आप हमारे रक्षक और स्वामी बनकर हमें अज्ञान के अंधकार से निकालकर दिव्यता के सर्वोच्च प्रकाश की ओर सफलतापूर्वक ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O devotees, those who are filled with deep reverence sit before Lord Indra, who is self-radiant and established in his own sovereignty. 
            He is continuously increased and glorified through the sacred calls of the priests and the sincere sacrificial offerings of the followers. 
            This state of 'Svaraj' or self-sovereignty by Indra provides a great spiritual message of self-control and self-reliance to all of humanity. 
            When we become the true masters of our own senses, we can experience that divine and radiant aspect of Indra within our consciousness. 
            Every oblation offered in the sacrificial fire increases Indra's strength, which ultimately returns to us as cosmic balance and welfare. 
            O God, with your infinite majesty, become our helper in every daunting task of our life and lead us toward magnificent success. 
            Worshipping you consistently removes the doubts of our minds and grants us the divine clarity required to perceive the Eternal Truth. 
            We bow before you with devotion so that your just and merciful gaze continuously steers us toward the path of progress and evolution. 
            You are the ultimate power that possesses the capability to transform our subtle intentions into cosmic achievements and material plenty. 
            O Indra, stay with us as our protector and Lord; pull us out of the darkness of ignorance toward the highest light of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 79,
        sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ ७९ ॥",
        hindiCommentary = """
            हे श्रेष्ठ मार्ग दिखाने वाले इन्द्रदेव! आप इस पवित्र सोमरस का पान करें जो आपको अत्यंत हर्ष, आनंद और अजेय ऊर्जा प्रदान करने वाला है। 
            आपका यह आनंद समस्त प्रजाओं को तृप्त करने वाला है और आप स्वयं असीम शक्ति के पुंज के रूप में इस ब्रह्मांड में प्रतिष्ठित हैं। 
            हम इस विशेष यज्ञीय अनुष्ठान में आपको प्रसन्न करने के लिए अपनी स्तुतियों और श्रद्धा के साथ आपकी अनन्य सेवा और अर्चना करते हैं। 
            आपकी दिव्य ऊर्जा से ही यह संपूर्ण जगत और इसकी सूक्ष्म गतियाँ संचालित होती हैं, और सोम का पान कर आप और अधिक प्रदीप्त और तेजस्वी हो जाते हैं। 
            हे देवराज, हमारे इस अनुष्ठान को अपनी पावन उपस्थिति से पवित्र करें और हमें वह आंतरिक बल दें कि हम सदैव सत्य की रक्षा कर सकें। 
            जैसे वर्षा की बूंदों से प्यासी धरती तृप्त होती है, वैसे ही आपकी कृपा से हमारे जीवन के समस्त अभाव और कष्ट सदा के लिए दूर हो जाते हैं। 
            हम अत्यंत श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमारे जीवन को सुख, अखंड शांति और भौतिक समृद्धि से परिपूर्ण कर दें। 
            आपकी यह दिव्य और अजेय शक्ति हमें संशय के अंधकार से बाहर निकालती है और हमें सत्यनिष्ठा तथा दृढ़ चरित्र की अद्भुत शक्ति प्रदान करती है। 
            हे इन्द्र, आप हमारे सबसे निकट के आत्मीय संबंधी बनकर हमें वह दिव्य सुख दें जो संसार की क्षणभंगुर वस्तुओं में सर्वथा दुर्लभ है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा हृदय सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम ईश्वरमय रहें।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the guide on the most excellent path, please drink this holy Soma which grants you immense joy, exhilaration, and new energy. 
            Your bliss is that which satisfies and nourishes all living beings, and you are established in this universe as the source of infinite power. 
            In this special sacrificial session, we offer our exclusive service with hymns and deep faith to please and glorify your divinity. 
            It is through your divine energy that this entire universe and its movements are governed; by consuming Soma, you become more radiant. 
            O King of Gods, sanctify this ritual of ours with your holy presence and grant us the inner strength to always protect and serve Dharma. 
            Just as the thirsty earth is satisfied by raindrops, all the scarcities, sorrows, and afflictions of our lives vanish forever by your grace. 
            We bow before your feet with profound devotion so that you may fill our lives with happiness, unbroken peace, and material prosperity. 
            Your divine and invincible power pulls us out of the darkness of doubt and grants us the amazing strength of integrity and firm character. 
            O Indra, become our nearest and most intimate relative and bestow upon us that divine bliss which is rare in fleeting worldly things. 
            We constantly sing your glories so that our hearts remain forever illuminated with the light of devotion and knowledge near the Divine.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 80,
        sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ ८० ॥",
        hindiCommentary = """
            हे दिव्य शक्तियों के ज्ञाता! मैं उन इन्द्रदेव की स्तुति करता हूँ जो समस्त प्रजाओं के परम स्वामी और बलवानों में भी सर्वश्रेष्ठ वीर हैं। 
            वे अनेक महान यज्ञों और अत्यंत प्राचीन स्तुतियों के एकमात्र अधिकारी हैं, और उनकी शक्ति की सीमा का पार पाना किसी के लिए संभव नहीं। 
            इन्द्र ही वह सर्वोच्च सत्ता हैं जो ब्रह्मांड के न्याय, अनुशासन और संतुलन को बनाए रखने के लिए अपनी प्रचंड और अजेय शक्ति का प्रयोग करते हैं। 
            उनकी महिमा का भक्तिपूर्वक गान करने से मनुष्य के भीतर के सुप्त साहस, वीरता और ओज का जागरण होता है, जिससे वह जीवन में विजयी बनता है। 
            हे देव, आप हमारे जीवन के प्रत्येक अंधकारमय पक्ष को दूर कर हमें वह तेज प्रदान करें जिससे हम समाज में गौरवपूर्ण स्थान प्राप्त कर सकें। 
            आपकी कृपा से हमें वह ऐश्वर्य और धन प्राप्त हो जो पूर्णतः सत्य के मार्ग पर चलकर अर्जित किया गया हो और जो मानवता के लिए कल्याणकारी हो। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे अंतःकरण को शुद्ध कर हमें ईश्वर के वास्तविक सान्निध्य और आत्मिक शांति का अनुभव कराते हैं। 
            आप ही वह पराशक्ति हैं जो हमारे द्वारा किए गए कठिन परिश्रम को ईश्वरीय फल में और हमारी आर्त प्रार्थनाओं को दिव्य आशीर्वाद में बदलती हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल या असहाय नहीं रहता, क्योंकि उसे आत्मज्ञान की प्रखरता और भौतिक संपन्नता दोनों का वरदान मिलता है। 
            हे इन्द्र, आप हमारे रक्षक और शाश्वत मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें महान, यशस्वी और धर्मनिष्ठ बनाने की असीम कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O knower of divine powers, I praise Lord Indra, the supreme master of all subjects and the foremost among the strong. 
            He is the sole rightful recipient of many great sacrifices and ancient hymns, and no being can ever surpass the limit of his might. 
            Indra is the supreme authority who utilizes his fierce and invincible power to maintain the justice, discipline, and balance of the universe. 
            Singing his glories with devotion awakens the dormant courage, heroism, and vigor within a person, enabling them to emerge victorious in life. 
            O God, remove every dark aspect of our existence and bestow upon us that brilliance which allows us to attain a place of honor in society. 
            By your grace, let us receive that wealth which is earned strictly by following the path of Truth and which is beneficial for all of humanity. 
            We worship you because you are the one who purifies our inner self and allows us to experience the proximity of God and spiritual peace. 
            You are the supreme power that transforms our hard labor into divine results and our desperate prayers into magnificent celestial blessings. 
            A seeker who takes refuge in Lord Indra never remains weak or helpless; they are blessed with the sharpness of self-knowledge and abundance. 
            O Indra, stay with us as our protector and eternal guide, and graciously make us great, successful, renowned, and devoted to Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 81,
        sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ ८१ ॥",
        hindiCommentary = """
            हे मेरे श्रेष्ठ मित्रों! आप उन इन्द्रदेव के लिए अत्यंत आनंददायक और भक्तिपूर्ण गीतों का गान करें जो अश्वों के स्वामी और सोम के पानकर्ता हैं। 
            आपकी मधुर वाणी से निकले हुए ये पवित्र भजन इन्द्र को प्रसन्न करते हैं और उन्हें हमारे इस यज्ञीय अनुष्ठान में साक्षात् पधारने के लिए आमंत्रित करते हैं। 
            इन्द्रदेव की अजेय शक्ति का रहस्य सोम के श्रद्धापूर्ण पान और भक्तों की निष्कपट पुकार में छिपा है, जो उन्हें संपूर्ण ब्रह्मांड में अजेय बना देता है। 
            जब हम सामूहिक रूप से उनकी महिमा गाते हैं, तो हमारे चारों ओर एक अत्यंत सकारात्मक, ऊर्जावान और दिव्य वातावरण का निर्माण स्वतः ही होने लगता है। 
            हे देव, आप अपने तेजस्वी और वायु के समान तीव्र घोड़ों पर सवार होकर हमारे जीवन के कठिन संघर्षों में आएं और हमारे समस्त शत्रुओं का संहार करें। 
            हमें वह अटूट भक्ति और एकाग्रता प्रदान करें जिससे हम आपकी विराट और सर्वव्यापी सत्ता का अनुभव अपने भीतर कर सकें और सदैव मानसिक रूप से शांत रहें। 
            आपकी कृपा से हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, अखंड सौभाग्य और आध्यात्मिक श्रेष्ठता प्राप्त करने की दिव्य शक्ति और प्रेरणा मिले। 
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि हमारा जीवन सदैव लोक-कल्याण, परोपकार और सत्य की सेवा में लगा रहे और हम निरंतर आत्मोन्नति करें। 
            इन्द्रदेव की पवित्र मित्रता हमारे लिए वह अभेद्य सुरक्षा कवच है जो हमारे समस्त संशयों, भयों और दुखों को जड़ से समाप्त कर हमें निर्भय बना देती है। 
            हे इन्द्र, आप हमारे परम रक्षक और गुरु हैं; हमें अज्ञान के अंधकार से निकालकर आत्मज्ञान के परम प्रकाश और परमात्मा के शाश्वत सत्य की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O my dear friends, sing exhilarated and highly devoted songs for Lord Indra, the master of horses and the drinker of Soma. 
            These sacred hymns arising from your sweet voices delight Indra and invite him to manifest personally within our sacrificial ritual today. 
            The secret of Indra's invincible might lies in the devoted consumption of Soma and the sincere calls of his devotees, making him unsurpassed. 
            When we collectively sing his glories, an extremely positive, energetic, and divine atmosphere begins to manifest around us automatically. 
            O God, riding upon your radiant horses that are as swift as the wind, come into the difficult struggles of our life and destroy all our enemies. 
            Grant us that unshakable devotion and focus which enables us to experience your vast and omnipresent existence within us and remain calm. 
            By your grace, remove every lack from our lives and grant us the divine power and inspiration to attain completeness and spiritual excellence. 
            We worship you with devotion so that our life remains dedicated to public welfare, altruism, and the service of Truth, helping us grow inwardly. 
            The holy friendship of Lord Indra is that impenetrable shield for us which completely uproots all our doubts, fears, and sorrows, making us bold. 
            O Indra, you are our supreme Lord, Protector, and Teacher; lead us out of the darkness of ignorance toward the light of Self-realization and Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 82,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ ८२ ॥",
        hindiCommentary = """
            समस्त स्तुतियां समुद्र के समान विशाल और सर्वव्यापी इन्द्रदेव की महिमा को निरंतर बढ़ाती और पूरे संसार में अत्यंत गौरव के साथ प्रकाशित करती हैं। 
            वे रथियों में श्रेष्ठ और समस्त विजयों के अधिपति हैं, जिनकी बार-बार अत्यंत श्रद्धा के साथ प्रशंसा और गौरवपूर्ण वंदना की जानी चाहिए। 
            इन्द्र की व्यापकता आकाश और समुद्र की तरह अनंत और अथाह है, जिसमें संपूर्ण ब्रह्मांड की शक्तियाँ सुरक्षित और पूर्णतः समाहित रहती हैं। 
            वे हमारे जीवन रूपी रथ के सबसे कुशल और दिव्य सारथी हैं, जो हमें संसार की समस्त बाधाओं के बीच से सफलतापूर्वक और निर्विघ्न निकाल ले जाते हैं। 
            हे देव, आप अपनी प्रचंड शक्ति और अपार बुद्धिमत्ता से हमारे प्रत्येक प्रयास को सफलता के उच्चतम और श्रेष्ठ शिखर तक पहुँचाने की महान कृपा करें। 
            हमें वह आध्यात्मिक और भौतिक शक्ति प्रदान करें जिससे हम निर्बलों की सहायता कर सकें और धर्म की ध्वजा को सदैव इस जगत में ऊँचा रख सकें। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की पूर्ण शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत, सचेत और पवित्र होने लगते हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी भी पराजित नहीं होता, क्योंकि स्वयं संपूर्ण ब्रह्मांड का नायक उसका सहायक, रक्षक और परम मित्र बन जाता है। 
            आपकी दिव्य दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और शाश्वत कीर्ति का सही मार्ग निरंतर दिखाए, यही हमारी विनम्र प्रार्थना है। 
            हे इन्द्र, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और आत्मिक रूप से सुखी बनाने की महान कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            All the hymns and prayers continuously increase and illuminate the glory of Lord Indra, who is as vast and all-encompassing as the ocean. 
            He is the foremost among divine charioteers and the Lord of all victories, worthy of being praised and glorified with deep devotion. 
            The expanse of Indra's presence is infinite and unfathomable like the sky and the sea, within which all cosmic powers are safely contained. 
            He is the most skillful and divine charioteer of our life's vessel, guiding us expertly and safely through the various obstacles of the world. 
            O God, with your fierce power and immense wisdom, graciously lead our every effort to the absolute peak of success and excellence. 
            Bestow upon us both spiritual and material power so that we can assist the weak and keep the flag of righteousness flying high in the world. 
            The continuous singing of your glories completely purifies our inner self and initiates our constant spiritual awakening and divine awareness. 
            A seeker who takes refuge in Lord Indra is never defeated, for the hero of the entire universe becomes their personal helper and friend. 
            Let your divine radiance illuminate every dark corner of our existence and show us the pathway to fame, splendor, and eternal glory. 
            O Indra, always remain with us as our protector and nourisher, graciously making our lives magnificent, successful, and truly happy.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 83,
        sanskrit = "एवा ह्यासि वीरयुरेतदस्मासु धेहि ।\nमहाँ हि शतक्रतो ॥ ८३ ॥",
        hindiCommentary = """
            हे शतक्रतो इन्द्र! आप वास्तव में वीरता, पराक्रम और आत्मबल के प्रेमी हैं, कृपया हमारे भीतर भी वही वीरता और अडिग साहस स्थापित करें। 
            आप अत्यंत महान और तेजस्वी हैं, हमारे जीवन के श्रेष्ठ संकल्पों को दृढ़ता प्रदान करें ताकि हम धर्म की रक्षा के लिए सदैव तत्पर रह सकें। 
            सच्ची वीरता वह नहीं जो केवल बाह्य युद्ध में दिखे, बल्कि वह है जो हमें अपने भीतर के विकारों और शत्रुओं पर विजय पाने की अद्भुत शक्ति प्रदान करती है। 
            आपकी कृपा से हमें वह ओज और तेज प्राप्त हो जिससे हम समाज में सत्य और न्याय का मार्ग प्रशस्त करने वाले निस्वार्थ योद्धा बन सकें। 
            हे देवराज, आप हमारे भीतर के प्रत्येक सूक्ष्म डर को समाप्त कर हमें पूर्णतः निर्भीक, शांत और आत्मविश्वासी बनाने की महान कृपा करें। 
            जब आप हमारे हृदय में साहस का दिव्य बीज बोते हैं, तब संसार की कोई भी प्रतिकूल परिस्थिति या अभाव हमें कभी विचलित नहीं कर सकता। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी महानता का एक अंश हमारे चरित्र में भी झलके और हम मानवता के लिए श्रेष्ठ बन सकें। 
            आप ही वह शक्ति हैं जो हमारे शिथिल और थके हुए मन में नवीन ऊर्जा का संचार कर हमें निरंतर कर्मयोग की ओर सफलतापूर्वक अग्रसर करती हैं। 
            हे इन्द्र, हमें वह आध्यात्मिक सामर्थ्य दें कि हम सांसारिक प्रलोभनों से ऊपर उठकर ईश्वर के वास्तविक और शाश्वत सत्य स्वरूप को पा सकें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके संरक्षण में सदैव निर्भय होकर एक गौरवशाली और सार्थक जीवन व्यतीत करने में सफल हों।
        """.trimIndent(),
        englishCommentary = """
            O Shatakratu Indra, you are truly the lover of heroism, valor, and inner strength; please instill that same valor and unshakable courage within us. 
            You are exceedingly great and radiant; grant firmness to the noble resolutions of our lives so that we are always ready for the defense of Dharma. 
            True heroism is not just seen in physical external war, but in the power that enables us to conquer our own inner flaws and hidden enemies. 
            By your grace, let us receive that vigor and luster which transform us into selfless warriors who pave the way for Truth and Justice in society. 
            O King of Gods, graciously terminate every subtle fear within us and make us completely fearless, calm, and self-confident. 
            When you sow the divine seed of courage in our hearts, no adverse circumstance or scarcity of the world can ever sway or disturb us. 
            We worship you with devotion so that a fraction of your greatness reflects in our character and we become superior beings for humanity. 
            You are the power that infuses fresh energy into our lethargic and tired minds, pushing us successfully toward the path of Karma Yoga. 
            O Indra, give us the spiritual capability to rise above worldly temptations and attain the true essence of the Divine and Eternal Truth. 
            May your merciful gaze always remain upon us as we lead a glorious and meaningful life successfully under your supreme divine protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 84,
        sanskrit = "तं घेमित्था नमस्विन उप स्वराजमासते ।\nहोत्रभिरिन्द्रं वावृधुः ॥ ८४ ॥",
        hindiCommentary = """
            हे भक्तों! जो इन्द्रदेव स्वयं प्रकाशित और अपने ही साम्राज्य में पूर्णतः प्रतिष्ठित हैं, भक्त उनकी परम उपासना और नमस्कार करते हैं। 
            वे 'होता' के पवित्र आह्वान और यज्ञीय आहुतियों के माध्यम से निरंतर प्रदीप्त और भक्तों के हृदयों में संवर्धित किए जाते हैं। 
            इन्द्र की यह 'स्वराज' अवस्था मनुष्य को आत्म-संयम, आत्म-बोध और वास्तविक आत्म-निर्भरता का महान आध्यात्मिक संदेश प्रदान करती है। 
            जब हम अपनी दसों इंद्रियों के स्वामी स्वयं बन जाते हैं, तब हम अपने भीतर इन्द्र के उस दिव्य और तेजस्वी स्वरूप का अनुभव कर सकते हैं। 
            यज्ञ की पवित्र अग्नि में दी गई प्रत्येक आहुति इन्द्र के बल को बढ़ाती है, जो अंततः ब्रह्मांडीय संतुलन के रूप में हमारे ही कल्याण के लिए आती है। 
            हे देव, आप अपनी असीम महिमा के साथ हमारे जीवन के प्रत्येक कठिन कार्य में सहायक बनकर हमें पूर्ण सफलता की ओर ले जाएं। 
            आपकी निरंतर उपासना से हमारे मन के समस्त संशय दूर होते हैं और हमें वह दिव्य स्पष्टता प्राप्त होती है जिससे हम सत्य को जान सकें। 
            हम श्रद्धापूर्वक आपके सम्मुख नतमस्तक हैं ताकि आपकी न्यायपूर्ण और दयालु दृष्टि हमें सदैव उन्नति के मार्ग पर अग्रसर रखे। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे सूक्ष्म संकल्पों को ब्रह्मांडीय सिद्धियों और भौतिक प्रचुरता में बदलने का सामर्थ्य रखती हैं। 
            हे इन्द्र, आप हमारे रक्षक और स्वामी बनकर हमें अज्ञान के अंधकार से निकालकर दिव्यता के सर्वोच्च प्रकाश की ओर सफलतापूर्वक ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O devotees, those who are filled with deep reverence sit before Lord Indra, who is self-radiant and established in his own sovereignty. 
            He is continuously increased and glorified through the sacred calls of the priests and the sincere sacrificial offerings of the followers. 
            This state of 'Svaraj' or self-sovereignty by Indra provides a great spiritual message of self-control and self-reliance to all of humanity. 
            When we become the true masters of our own senses, we can experience that divine and radiant aspect of Indra within our consciousness. 
            Every oblation offered in the sacrificial fire increases Indra's strength, which ultimately returns to us as cosmic balance and welfare. 
            O God, with your infinite majesty, become our helper in every daunting task of our life and lead us toward magnificent success. 
            Worshipping you consistently removes the doubts of our minds and grants us the divine clarity required to perceive the Eternal Truth. 
            We bow before you with devotion so that your just and merciful gaze continuously steers us toward the path of progress and evolution. 
            You are the ultimate power that possesses the capability to transform our subtle intentions into cosmic achievements and material plenty. 
            O Indra, stay with us as our protector and Lord; pull us out of the darkness of ignorance toward the highest light of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 85,
        sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ ८५ ॥",
        hindiCommentary = """
            हे श्रेष्ठ मार्ग दिखाने वाले इन्द्रदेव! आप इस पवित्र सोमरस का पान करें जो आपको अत्यंत हर्ष, आनंद और अजेय ऊर्जा प्रदान करने वाला है। 
            आपका यह आनंद समस्त प्रजाओं को तृप्त करने वाला है और आप स्वयं असीम शक्ति के पुंज के रूप में इस ब्रह्मांड में प्रतिष्ठित हैं। 
            हम इस विशेष यज्ञीय अनुष्ठान में आपको प्रसन्न करने के लिए अपनी स्तुतियों और श्रद्धा के साथ आपकी अनन्य सेवा और अर्चना करते हैं। 
            आपकी दिव्य ऊर्जा से ही यह संपूर्ण जगत और इसकी सूक्ष्म गतियाँ संचालित होती हैं, और सोम का पान कर आप और अधिक प्रदीप्त और तेजस्वी हो जाते हैं। 
            हे देवराज, हमारे इस अनुष्ठान को अपनी पावन उपस्थिति से पवित्र करें और हमें वह आंतरिक बल दें कि हम सदैव सत्य की रक्षा कर सकें। 
            जैसे वर्षा की बूंदों से प्यासी धरती तृप्त होती है, वैसे ही आपकी कृपा से हमारे जीवन के समस्त अभाव और कष्ट सदा के लिए दूर हो जाते हैं। 
            हम अत्यंत श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमारे जीवन को सुख, अखंड शांति और भौतिक समृद्धि से परिपूर्ण कर दें। 
            आपकी यह दिव्य और अजेय शक्ति हमें संशय के अंधकार से बाहर निकालती है और हमें सत्यनिष्ठा तथा दृढ़ चरित्र की अद्भुत शक्ति प्रदान करती है। 
            हे इन्द्र, आप हमारे सबसे निकट के आत्मीय संबंधी बनकर हमें वह दिव्य सुख दें जो संसार की क्षणभंगुर वस्तुओं में सर्वथा दुर्लभ है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा हृदय सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम ईश्वरमय रहें।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the guide on the most excellent path, please drink this holy Soma which grants you immense joy, exhilaration, and new energy. 
            Your bliss is that which satisfies and nourishes all living beings, and you are established in this universe as the source of infinite power. 
            In this special sacrificial session, we offer our exclusive service with hymns and deep faith to please and glorify your divinity. 
            It is through your divine energy that this entire universe and its movements are governed; by consuming Soma, you become more radiant. 
            O King of Gods, sanctify this ritual of ours with your holy presence and grant us the inner strength to always protect and serve Dharma. 
            Just as the thirsty earth is satisfied by raindrops, all the scarcities, sorrows, and afflictions of our lives vanish forever by your grace. 
            We bow before your feet with profound devotion so that you may fill our lives with happiness, unbroken peace, and material prosperity. 
            Your divine and invincible power pulls us out of the darkness of doubt and grants us the amazing strength of integrity and firm character. 
            O Indra, become our nearest and most intimate relative and bestow upon us that divine bliss which is rare in fleeting worldly things. 
            We constantly sing your glories so that our hearts remain forever illuminated with the light of devotion and knowledge near the Divine.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 86,
        sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ ८६ ॥",
        hindiCommentary = """
            हे दिव्य शक्तियों के ज्ञाता! मैं उन इन्द्रदेव की स्तुति करता हूँ जो समस्त प्रजाओं के परम स्वामी और बलवानों में भी सर्वश्रेष्ठ वीर हैं। 
            वे अनेक महान यज्ञों और अत्यंत प्राचीन स्तुतियों के एकमात्र अधिकारी हैं, और उनकी शक्ति की सीमा का पार पाना किसी के लिए संभव नहीं। 
            इन्द्र ही वह सर्वोच्च सत्ता हैं जो ब्रह्मांड के न्याय, अनुशासन और संतुलन को बनाए रखने के लिए अपनी प्रचंड और अजेय शक्ति का प्रयोग करते हैं। 
            उनकी महिमा का भक्तिपूर्वक गान करने से मनुष्य के भीतर के सुप्त साहस, वीरता और ओज का जागरण होता है, जिससे वह जीवन में विजयी बनता है। 
            हे देव, आप हमारे जीवन के प्रत्येक अंधकारमय पक्ष को दूर कर हमें वह तेज प्रदान करें जिससे हम समाज में गौरवपूर्ण स्थान प्राप्त कर सकें। 
            आपकी कृपा से हमें वह ऐश्वर्य और धन प्राप्त हो जो पूर्णतः सत्य के मार्ग पर चलकर अर्जित किया गया हो और जो मानवता के लिए कल्याणकारी हो। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे अंतःकरण को शुद्ध कर हमें ईश्वर के वास्तविक सान्निध्य और आत्मिक शांति का अनुभव कराते हैं। 
            आप ही वह पराशक्ति हैं जो हमारे द्वारा किए गए कठिन परिश्रम को ईश्वरीय फल में और हमारी आर्त प्रार्थनाओं को दिव्य आशीर्वाद में बदलती हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल या असहाय नहीं रहता, क्योंकि उसे आत्मज्ञान की प्रखरता और भौतिक संपन्नता दोनों का वरदान मिलता है। 
            हे इन्द्र, आप हमारे रक्षक और शाश्वत मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें महान, यशस्वी और धर्मनिष्ठ बनाने की असीम कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O knower of divine powers, I praise Lord Indra, the supreme master of all subjects and the foremost among the strong. 
            He is the sole rightful recipient of many great sacrifices and ancient hymns, and no being can ever surpass the limit of his might. 
            Indra is the supreme authority who utilizes his fierce and invincible power to maintain the justice, discipline, and balance of the universe. 
            Singing his glories with devotion awakens the dormant courage, heroism, and vigor within a person, enabling them to emerge victorious in life. 
            O God, remove every dark aspect of our existence and bestow upon us that brilliance which allows us to attain a place of honor in society. 
            By your grace, let us receive that wealth which is earned strictly by following the path of Truth and which is beneficial for all of humanity. 
            We worship you because you are the one who purifies our inner self and allows us to experience the proximity of God and spiritual peace. 
            You are the supreme power that transforms our hard labor into divine results and our desperate prayers into magnificent celestial blessings. 
            A seeker who takes refuge in Lord Indra never remains weak or helpless; they are blessed with the sharpness of self-knowledge and abundance. 
            O Indra, stay with us as our protector and eternal guide, and graciously make us great, successful, renowned, and devoted to Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 87,
        sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ ८७ ॥",
        hindiCommentary = """
            हे मेरे श्रेष्ठ मित्रों! आप उन इन्द्रदेव के लिए अत्यंत आनंददायक और भक्तिपूर्ण गीतों का गान करें जो अश्वों के स्वामी और सोम के पानकर्ता हैं। 
            आपकी मधुर वाणी से निकले हुए ये पवित्र भजन इन्द्र को प्रसन्न करते हैं और उन्हें हमारे इस यज्ञीय अनुष्ठान में साक्षात् पधारने के लिए आमंत्रित करते हैं। 
            इन्द्रदेव की अजेय शक्ति का रहस्य सोम के श्रद्धापूर्ण पान और भक्तों की निष्कपट पुकार में छिपा है, जो उन्हें संपूर्ण ब्रह्मांड में अजेय बना देता है। 
            जब हम सामूहिक रूप से उनकी महिमा गाते हैं, तो हमारे चारों ओर एक अत्यंत सकारात्मक, ऊर्जावान और दिव्य वातावरण का निर्माण स्वतः ही होने लगता है। 
            हे देव, आप अपने तेजस्वी और वायु के समान तीव्र घोड़ों पर सवार होकर हमारे जीवन के कठिन संघर्षों में आएं और हमारे समस्त शत्रुओं का संहार करें। 
            हमें वह अटूट भक्ति और एकाग्रता प्रदान करें जिससे हम आपकी विराट और सर्वव्यापी सत्ता का अनुभव अपने भीतर कर सकें और सदैव मानसिक रूप से शांत रहें। 
            आपकी कृपा से हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, अखंड सौभाग्य और आध्यात्मिक श्रेष्ठता प्राप्त करने की दिव्य शक्ति और प्रेरणा मिले। 
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि हमारा जीवन सदैव लोक-कल्याण, परोपकार और सत्य की सेवा में लगा रहे और हम निरंतर आत्मोन्नति करें। 
            इन्द्रदेव की पवित्र मित्रता हमारे लिए वह अभेद्य सुरक्षा कवच है जो हमारे समस्त संशयों, भयों और दुखों को जड़ से समाप्त कर हमें निर्भय बना देती है। 
            हे इन्द्र, आप हमारे परम रक्षक और गुरु हैं; हमें अज्ञान के अंधकार से निकालकर आत्मज्ञान के परम प्रकाश और परमात्मा के शाश्वत सत्य की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O my dear friends, sing exhilarated and highly devoted songs for Lord Indra, the master of horses and the drinker of Soma. 
            These sacred hymns arising from your sweet voices delight Indra and invite him to manifest personally within our sacrificial ritual today. 
            The secret of Indra's invincible might lies in the devoted consumption of Soma and the sincere calls of his devotees, making him unsurpassed. 
            When we collectively sing his glories, an extremely positive, energetic, and divine atmosphere begins to manifest around us automatically. 
            O God, riding upon your radiant horses that are as swift as the wind, come into the difficult struggles of our life and destroy all our enemies. 
            Grant us that unshakable devotion and focus which enables us to experience your vast and omnipresent existence within us and remain calm. 
            By your grace, remove every lack from our lives and grant us the divine power and inspiration to attain completeness and spiritual excellence. 
            We worship you with devotion so that our life remains dedicated to public welfare, altruism, and the service of Truth, helping us grow inwardly. 
            The holy friendship of Lord Indra is that impenetrable shield for us which completely uproots all our doubts, fears, and sorrows, making us bold. 
            O Indra, you are our supreme Lord, Protector, and Teacher; lead us out of the darkness of ignorance toward the light of Self-realization and Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 88,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ ८८ ॥",
        hindiCommentary = """
            समस्त स्तुतियां समुद्र के समान विशाल और सर्वव्यापी इन्द्रदेव की महिमा को निरंतर बढ़ाती और पूरे संसार में अत्यंत गौरव के साथ प्रकाशित करती हैं। 
            वे रथियों में श्रेष्ठ और समस्त विजयों के अधिपति हैं, जिनकी बार-बार अत्यंत श्रद्धा के साथ प्रशंसा और गौरवपूर्ण वंदना की जानी चाहिए। 
            इन्द्र की व्यापकता आकाश और समुद्र की तरह अनंत और अथाह है, जिसमें संपूर्ण ब्रह्मांड की शक्तियाँ सुरक्षित और पूर्णतः समाहित रहती हैं। 
            वे हमारे जीवन रूपी रथ के सबसे कुशल और दिव्य सारथी हैं, जो हमें संसार की समस्त बाधाओं के बीच से सफलतापूर्वक और निर्विघ्न निकाल ले जाते हैं। 
            हे देव, आप अपनी प्रचंड शक्ति और अपार बुद्धिमत्ता से हमारे प्रत्येक प्रयास को सफलता के उच्चतम और श्रेष्ठ शिखर तक पहुँचाने की महान कृपा करें। 
            हमें वह आध्यात्मिक और भौतिक शक्ति प्रदान करें जिससे हम निर्बलों की सहायता कर सकें और धर्म की ध्वजा को सदैव इस जगत में ऊँचा रख सकें। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की पूर्ण शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत, सचेत और पवित्र होने लगते हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी भी पराजित नहीं होता, क्योंकि स्वयं संपूर्ण ब्रह्मांड का नायक उसका सहायक, रक्षक और परम मित्र बन जाता है। 
            आपकी दिव्य दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और शाश्वत कीर्ति का सही मार्ग निरंतर दिखाए, यही हमारी विनम्र प्रार्थना है। 
            हे इन्द्र, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और आत्मिक रूप से सुखी बनाने की महान कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            All the hymns and prayers continuously increase and illuminate the glory of Lord Indra, who is as vast and all-encompassing as the ocean. 
            He is the foremost among divine charioteers and the Lord of all victories, worthy of being praised and glorified with deep devotion. 
            The expanse of Indra's presence is infinite and unfathomable like the sky and the sea, within which all cosmic powers are safely contained. 
            He is the most skillful and divine charioteer of our life's vessel, guiding us expertly and safely through the various obstacles of the world. 
            O God, with your fierce power and immense wisdom, graciously lead our every effort to the absolute peak of success and excellence. 
            Bestow upon us both spiritual and material power so that we can assist the weak and keep the flag of righteousness flying high in the world. 
            The continuous singing of your glories completely purifies our inner self and initiates our constant spiritual awakening and divine awareness. 
            A seeker who takes refuge in Lord Indra is never defeated, for the hero of the entire universe becomes their personal helper and friend. 
            Let your divine radiance illuminate every dark corner of our existence and show us the pathway to fame, splendor, and eternal glory. 
            O Indra, always remain with us as our protector and nourisher, graciously making our lives magnificent, successful, and truly happy.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 89,
        sanskrit = "एवा ह्यासि वीरयुरेतदस्मासु धेहि ।\nमहाँ हि शतक्रतो ॥ ८९ ॥",
        hindiCommentary = """
            हे शतक्रतो इन्द्र! आप वास्तव में वीरता, पराक्रम और आत्मबल के प्रेमी हैं, कृपया हमारे भीतर भी वही वीरता और अडिग साहस स्थापित करें। 
            आप अत्यंत महान और तेजस्वी हैं, हमारे जीवन के श्रेष्ठ संकल्पों को दृढ़ता प्रदान करें ताकि हम धर्म की रक्षा के लिए सदैव तत्पर रह सकें। 
            सच्ची वीरता वह नहीं जो केवल बाह्य युद्ध में दिखे, बल्कि वह है जो हमें अपने भीतर के विकारों और शत्रुओं पर विजय पाने की अद्भुत शक्ति प्रदान करती है। 
            आपकी कृपा से हमें वह ओज और तेज प्राप्त हो जिससे हम समाज में सत्य और न्याय का मार्ग प्रशस्त करने वाले निस्वार्थ योद्धा बन सकें। 
            हे देवराज, आप हमारे भीतर के प्रत्येक सूक्ष्म डर को समाप्त कर हमें पूर्णतः निर्भीक, शांत और आत्मविश्वासी बनाने की महान कृपा करें। 
            जब आप हमारे हृदय में साहस का दिव्य बीज बोते हैं, तब संसार की कोई भी प्रतिकूल परिस्थिति या अभाव हमें कभी विचलित नहीं कर सकता। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी महानता का एक अंश हमारे चरित्र में भी झलके और हम मानवता के लिए श्रेष्ठ बन सकें। 
            आप ही वह शक्ति हैं जो हमारे शिथिल और थके हुए मन में नवीन ऊर्जा का संचार कर हमें निरंतर कर्मयोग की ओर सफलतापूर्वक अग्रसर करती हैं। 
            हे इन्द्र, हमें वह आध्यात्मिक सामर्थ्य दें कि हम सांसारिक प्रलोभनों से ऊपर उठकर ईश्वर के वास्तविक और शाश्वत सत्य स्वरूप को पा सकें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके संरक्षण में सदैव निर्भय होकर एक गौरवशाली और सार्थक जीवन व्यतीत करने में सफल हों।
        """.trimIndent(),
        englishCommentary = """
            O Shatakratu Indra, you are truly the lover of heroism, valor, and inner strength; please instill that same valor and unshakable courage within us. 
            You are exceedingly great and radiant; grant firmness to the noble resolutions of our lives so that we are always ready for the defense of Dharma. 
            True heroism is not just seen in physical external war, but in the power that enables us to conquer our own inner flaws and hidden enemies. 
            By your grace, let us receive that vigor and luster which transform us into selfless warriors who pave the way for Truth and Justice in society. 
            O King of Gods, graciously terminate every subtle fear within us and make us completely fearless, calm, and self-confident. 
            When you sow the divine seed of courage in our hearts, no adverse circumstance or scarcity of the world can ever sway or disturb us. 
            We worship you with devotion so that a fraction of your greatness reflects in our character and we become superior beings for humanity. 
            You are the power that infuses fresh energy into our lethargic and tired minds, pushing us successfully toward the path of Karma Yoga. 
            O Indra, give us the spiritual capability to rise above worldly temptations and attain the true essence of the Divine and Eternal Truth. 
            May your merciful gaze always remain upon us as we lead a glorious and meaningful life successfully under your supreme divine protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 90,
        sanskrit = "तं घेमित्था नमस्विन उप स्वराजमासते ।\nहोत्रभिरिन्द्रं वावृधुः ॥ ९० ॥",
        hindiCommentary = """
            हे भक्तों! जो इन्द्रदेव स्वयं प्रकाशित और अपने ही साम्राज्य में पूर्णतः प्रतिष्ठित हैं, भक्त उनकी परम उपासना और नमस्कार करते हैं। 
            वे 'होता' के पवित्र आह्वान और यज्ञीय आहुतियों के माध्यम से निरंतर प्रदीप्त और भक्तों के हृदयों में संवर्धित किए जाते हैं। 
            इन्द्र की यह 'स्वराज' अवस्था मनुष्य को आत्म-संयम, आत्म-बोध और वास्तविक आत्म-निर्भरता का महान आध्यात्मिक संदेश प्रदान करती है। 
            जब हम अपनी दसों इंद्रियों के स्वामी स्वयं बन जाते हैं, तब हम अपने भीतर इन्द्र के उस दिव्य और तेजस्वी स्वरूप का अनुभव कर सकते हैं। 
            यज्ञ की पवित्र अग्नि में दी गई प्रत्येक आहुति इन्द्र के बल को बढ़ाती है, जो अंततः ब्रह्मांडीय संतुलन के रूप में हमारे ही कल्याण के लिए आती है। 
            हे देव, आप अपनी असीम महिमा के साथ हमारे जीवन के प्रत्येक कठिन कार्य में सहायक बनकर हमें पूर्ण सफलता की ओर ले जाएं। 
            आपकी निरंतर उपासना से हमारे मन के समस्त संशय दूर होते हैं और हमें वह दिव्य स्पष्टता प्राप्त होती है जिससे हम सत्य को जान सकें। 
            हम श्रद्धापूर्वक आपके सम्मुख नतमस्तक हैं ताकि आपकी न्यायपूर्ण और दयालु दृष्टि हमें सदैव उन्नति के मार्ग पर अग्रसर रखे। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे सूक्ष्म संकल्पों को ब्रह्मांडीय सिद्धियों और भौतिक प्रचुरता में बदलने का सामर्थ्य रखती हैं। 
            हे इन्द्र, आप हमारे रक्षक और स्वामी बनकर हमें अज्ञान के अंधकार से निकालकर दिव्यता के सर्वोच्च प्रकाश की ओर सफलतापूर्वक ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O devotees, those who are filled with deep reverence sit before Lord Indra, who is self-radiant and established in his own sovereignty. 
            He is continuously increased and glorified through the sacred calls of the priests and the sincere sacrificial offerings of the followers. 
            This state of 'Svaraj' or self-sovereignty by Indra provides a great spiritual message of self-control and self-reliance to all of humanity. 
            When we become the true masters of our own senses, we can experience that divine and radiant aspect of Indra within our consciousness. 
            Every oblation offered in the sacrificial fire increases Indra's strength, which ultimately returns to us as cosmic balance and welfare. 
            O God, with your infinite majesty, become our helper in every daunting task of our life and lead us toward magnificent success. 
            Worshipping you consistently removes the doubts of our minds and grants us the divine clarity required to perceive the Eternal Truth. 
            We bow before you with devotion so that your just and merciful gaze continuously steers us toward the path of progress and evolution. 
            You are the ultimate power that possesses the capability to transform our subtle intentions into cosmic achievements and material plenty. 
            O Indra, stay with us as our protector and Lord; pull us out of the darkness of ignorance toward the highest light of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 91,
        sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ ९१ ॥",
        hindiCommentary = """
            हे श्रेष्ठ मार्ग दिखाने वाले इन्द्र! आप इस पवित्र सोमरस का पान करें जो आपको अत्यंत हर्ष, आनंद और नवीन ऊर्जा प्रदान करने वाला है। 
            आपका यह आनंद समस्त प्रजाओं को तृप्त करने वाला है और आप स्वयं असीम शक्ति के पुंज (वृषा) के रूप में इस संपूर्ण ब्रह्मांड में प्रतिष्ठित हैं। 
            हम इस विशेष यज्ञीय अनुष्ठान (सवन) में आपको प्रसन्न करने के लिए अपनी स्तुतियों और श्रद्धा के साथ आपकी अनन्य सेवा और अर्चना करते हैं। 
            आपकी दिव्य ऊर्जा से ही यह संपूर्ण जगत संचालित होता है, और सोम का पान कर आप और अधिक प्रदीप्त और तेजस्वी हो जाते हैं। 
            हे देवराज, हमारे इस अनुष्ठान को अपनी पावन उपस्थिति से पवित्र करें और हमें वह आंतरिक बल दें कि हम सदैव सत्य और धर्म की रक्षा कर सकें। 
            जैसे वर्षा की शीतल बूंदों से प्यासी धरती तृप्त होती है, वैसे ही आपकी कृपा से हमारे जीवन के समस्त अभाव और दुख सदा के लिए दूर हो जाते हैं। 
            हम अत्यंत श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमारे जीवन को सुख, अखंड शांति और भौतिक समृद्धि से परिपूर्ण कर दें। 
            आपकी यह दिव्य और अजेय शक्ति हमें संशय के अंधकार से बाहर निकालती है और हमें सत्यनिष्ठा तथा दृढ़ चरित्र की अद्भुत शक्ति और साहस प्रदान करती है। 
            हे इन्द्र, आप हमारे सबसे निकट के आत्मीय संबंधी बनकर हमें वह दिव्य सुख दें जो संसार की क्षणभंगुर और नश्वर वस्तुओं में सर्वथा दुर्लभ है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा हृदय सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम सदैव ईश्वर के समीप रहें।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the leader on the most excellent path, please drink this holy Soma which grants you immense joy, exhilaration, and new energy. 
            Your bliss is that which satisfies and nourishes all living beings, and you are established in this universe as the source of infinite power. 
            In this special sacrificial session (Savana), we offer our exclusive service with hymns and deep faith to please and glorify your divinity. 
            It is through your divine energy that this entire moving universe is governed; by consuming Soma, you become more radiant and luminous. 
            O King of Gods, sanctify this ritual of ours with your holy presence and grant us the inner strength to always protect and serve Dharma. 
            Just as the thirsty earth is satisfied by cool raindrops, all the scarcities and afflictions of our lives vanish forever by your grace. 
            We bow before your feet with profound devotion so that you may fill our lives with happiness, unbroken peace, and material prosperity. 
            Your divine and invincible power pulls us out of the darkness of doubt and grants us the amazing strength of integrity and firm character. 
            O Indra, become our nearest and most intimate relative and bestow upon us that divine bliss which is totally rare in fleeting worldly things. 
            We constantly sing your glories so that our hearts remain forever illuminated with the light of devotion and knowledge near the Divine.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 92,
        sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ ९२ ॥",
        hindiCommentary = """
            हे दिव्य शक्तियों के ज्ञाता भक्तों! मैं उन इन्द्रदेव की स्तुति करता हूँ जो समस्त प्रजाओं के परम स्वामी और बलवानों में भी सर्वश्रेष्ठ वीर हैं। 
            वे अनेक महान यज्ञों और अत्यंत प्राचीन एवं शक्तिशाली स्तुतियों के एकमात्र अधिकारी हैं, और उनकी शक्ति की सीमा का पार पाना किसी के लिए संभव नहीं। 
            इन्द्र ही वह सर्वोच्च सत्ता हैं जो ब्रह्मांड के न्याय, अनुशासन और संतुलन को बनाए रखने के लिए अपनी प्रचंड और अजेय शक्ति का निरंतर प्रयोग करते हैं। 
            उनकी महिमा का भक्तिपूर्वक गान करने से मनुष्य के भीतर के सुप्त साहस, वीरता और दिव्य ओज का जागरण होता है, जिससे वह जीवन में विजयी बनता है। 
            हे देव, आप हमारे जीवन के प्रत्येक अंधकारमय पक्ष को दूर कर हमें वह तेज प्रदान करें जिससे हम समाज और राष्ट्र में गौरवपूर्ण स्थान प्राप्त कर सकें। 
            आपकी कृपा से हमें वह ऐश्वर्य और धन प्राप्त हो जो पूर्णतः सत्य के मार्ग पर चलकर अर्जित किया गया हो और जो समस्त मानवता के लिए कल्याणकारी हो। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे अंतःकरण को शुद्ध कर हमें ईश्वर के वास्तविक सान्निध्य और अखंड आत्मिक शांति का अनुभव कराते हैं। 
            आप ही वह पराशक्ति हैं जो हमारे द्वारा किए गए कठिन परिश्रम को ईश्वरीय फल में और हमारी आर्त प्रार्थनाओं को दिव्य आशीर्वाद में बदलती हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल या असहाय नहीं रहता, क्योंकि उसे आत्मज्ञान की प्रखरता और भौतिक संपन्नता दोनों का वरदान मिलता है। 
            हे इन्द्र, आप हमारे रक्षक और शाश्वत मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें महान, यशस्वी और धर्मनिष्ठ बनाने की असीम कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O devotees who know the divine powers, I praise Lord Indra, the supreme master of all subjects and the foremost among the strong. 
            He is the sole rightful recipient of many great sacrifices and ancient hymns, and no being can ever surpass the limit of his might. 
            Indra is the supreme authority who utilizes his fierce and invincible power to maintain the justice, discipline, and balance of the universe. 
            Singing his glories with devotion awakens the dormant courage, heroism, and vigor within a person, enabling them to emerge victorious in life. 
            O God, remove every dark aspect of our existence and bestow upon us that brilliance which allows us to attain a place of honor in society. 
            By your grace, let us receive that wealth which is earned strictly by following the path of Truth and which is beneficial for all of humanity. 
            We worship you because you are the one who purifies our inner self and allows us to experience the proximity of God and spiritual peace. 
            You are the supreme power that transforms our hard labor into divine results and our desperate prayers into magnificent celestial blessings. 
            A seeker who takes refuge in Lord Indra never remains weak or helpless; they are blessed with the sharpness of self-knowledge and abundance. 
            O Indra, stay with us as our protector and eternal guide, and graciously make us great, successful, renowned, and devoted to Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 93,
        sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ ९३ ॥",
        hindiCommentary = """
            हे मेरे श्रेष्ठ मित्रों और साधकों! आप उन इन्द्रदेव के लिए अत्यंत आनंददायक और भक्तिपूर्ण गीतों का गान करें जो अश्वों के स्वामी और सोम के पानकर्ता हैं। 
            आपकी मधुर वाणी से निकले हुए ये पवित्र भजन इन्द्र को प्रसन्न करते हैं और उन्हें हमारे इस यज्ञीय अनुष्ठान में साक्षात् पधारने के लिए आमंत्रित करते हैं। 
            इन्द्रदेव की अजेय शक्ति का रहस्य सोम के श्रद्धापूर्ण पान और भक्तों की निष्कपट पुकार में छिपा है, जो उन्हें संपूर्ण ब्रह्मांड में अजेय बना देता है। 
            जब हम सामूहिक रूप से उनकी महिमा गाते हैं, तो हमारे चारों ओर एक अत्यंत सकारात्मक, ऊर्जावान और दिव्य वातावरण का निर्माण स्वतः ही होने लगता है। 
            हे देव, आप अपने तेजस्वी और वायु के समान तीव्र घोड़ों पर सवार होकर हमारे जीवन के कठिन संघर्षों में आएं और हमारे समस्त शत्रुओं का संहार करें। 
            हमें वह अटूट भक्ति और एकाग्रता प्रदान करें जिससे हम आपकी विराट और सर्वव्यापी सत्ता का अनुभव अपने भीतर कर सकें और सदैव मानसिक रूप से शांत रहें। 
            आपकी कृपा से हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, अखंड सौभाग्य और आध्यात्मिक श्रेष्ठता प्राप्त करने की दिव्य शक्ति और प्रेरणा मिले। 
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि हमारा जीवन सदैव लोक-कल्याण, परोपकार और सत्य की सेवा में लगा रहे और हम निरंतर आत्मोन्नति करें। 
            इन्द्रदेव की पवित्र मित्रता हमारे लिए वह अभेद्य सुरक्षा कवच है जो हमारे समस्त संशयों, भयों और दुखों को जड़ से समाप्त कर हमें निर्भय बना देती है। 
            हे इन्द्र, आप हमारे परम स्वामी, रक्षक और गुरु हैं; हमें अज्ञान के अंधकार से निकालकर आत्मज्ञान के परम प्रकाश और परमात्मा के शाश्वत सत्य की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O my dear friends and fellow seekers, sing exhilarated and highly devoted songs for Lord Indra, the master of horses and the drinker of Soma. 
            These sacred hymns arising from your sweet voices delight Indra and invite him to manifest personally within our sacrificial ritual today. 
            The secret of Indra's invincible might lies in the devoted consumption of Soma and the sincere calls of his devotees, making him unsurpassed. 
            When we collectively sing his glories, an extremely positive, energetic, and divine atmosphere begins to manifest around us automatically. 
            O God, riding upon your radiant horses that are as swift as the wind, come into the difficult struggles of our life and destroy all our internal enemies. 
            Grant us that unshakable devotion and focus which enables us to experience your vast and omnipresent existence within us and remain calm. 
            By your grace, remove every lack from our lives and grant us the divine power and inspiration to attain completeness and spiritual excellence. 
            We worship you with devotion so that our life remains dedicated to public welfare, altruism, and the service of Truth, helping us grow inwardly. 
            The holy friendship of Lord Indra is that impenetrable shield for us which completely uproots all our doubts, fears, and sorrows, making us bold. 
            O Indra, you are our supreme Lord, Protector, and Teacher; lead us out of the darkness of ignorance toward the light of Self-realization and Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 94,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ ९४ ॥",
        hindiCommentary = """
            समस्त स्तुतियां और प्रार्थनाएं समुद्र के समान विशाल और सर्वव्यापी इन्द्रदेव की महिमा को निरंतर बढ़ाती और पूरे संसार में अत्यंत गौरव के साथ प्रकाशित करती हैं। 
            वे रथियों में श्रेष्ठ और समस्त विजयों के अधिपति हैं, जिनकी बार-बार अत्यंत श्रद्धा के साथ प्रशंसा और गौरवपूर्ण वंदना की जानी चाहिए। 
            इन्द्र की व्यापकता आकाश और समुद्र की तरह अनंत और अथाह है, जिसमें संपूर्ण ब्रह्मांड की शक्तियाँ सुरक्षित और पूर्णतः समाहित रहती हैं। 
            वे हमारे जीवन रूपी रथ के सबसे कुशल और दिव्य सारथी हैं, जो हमें संसार की समस्त बाधाओं के बीच से सफलतापूर्वक और निर्विघ्न निकाल ले जाते हैं। 
            हे देव, आप अपनी प्रचंड शक्ति और अपार बुद्धिमत्ता से हमारे प्रत्येक प्रयास को सफलता के उच्चतम और श्रेष्ठ शिखर तक पहुँचाने की महान कृपा करें। 
            हमें वह आध्यात्मिक और भौतिक शक्ति प्रदान करें जिससे हम निर्बलों की सहायता कर सकें और धर्म की ध्वजा को सदैव इस जगत में ऊँचा रख सकें। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की पूर्ण शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत, सचेत और पवित्र होने लगते हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी भी पराजित नहीं होता, क्योंकि स्वयं संपूर्ण ब्रह्मांड का नायक उसका सहायक, रक्षक और परम मित्र बन जाता है। 
            आपकी दिव्य दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और शाश्वत कीर्ति का सही मार्ग निरंतर दिखाए, यही हमारी विनम्र प्रार्थना है। 
            हे इन्द्र, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और आत्मिक रूप से सुखी बनाने की महान कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            All the hymns and prayers continuously increase and illuminate the glory of Lord Indra, who is as vast and all-encompassing as the ocean. 
            He is the foremost among divine charioteers and the Lord of all victories, worthy of being praised and glorified with deep devotion. 
            The expanse of Indra's presence is infinite and unfathomable like the sky and the sea, within which all cosmic powers are safely contained. 
            He is the most skillful and divine charioteer of our life's vessel, guiding us expertly and safely through the various obstacles of the world. 
            O God, with your fierce power and immense wisdom, graciously lead our every effort to the absolute peak of success and excellence. 
            Bestow upon us both spiritual and material power so that we can assist the weak and keep the flag of righteousness flying high in the world. 
            The continuous singing of your glories completely purifies our inner self and initiates our constant spiritual awakening and divine awareness. 
            A seeker who takes refuge in Lord Indra is never defeated, for the hero of the entire universe becomes their personal helper and friend. 
            Let your divine radiance illuminate every dark corner of our existence and show us the pathway to fame, splendor, and eternal glory. 
            O Indra, always remain with us as our protector and nourisher, graciously making our lives magnificent, successful, and truly happy.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 95,
        sanskrit = "एवा ह्यासि वीरयुरेतदस्मासु धेहि ।\nमहाँ हि शतक्रतो ॥ ९५ ॥",
        hindiCommentary = """
            हे शतक्रतो इन्द्र! आप वास्तव में वीरता, पराक्रम और आत्मबल के प्रेमी हैं, कृपया हमारे भीतर भी वही वीरता और अडिग साहस स्थापित करें। 
            आप अत्यंत महान और तेजस्वी हैं, हमारे जीवन के श्रेष्ठ संकल्पों को दृढ़ता प्रदान करें ताकि हम धर्म की रक्षा के लिए सदैव तत्पर रह सकें। 
            सच्ची वीरता वह नहीं जो केवल बाह्य युद्ध में दिखे, बल्कि वह है जो हमें अपने भीतर के विकारों और शत्रुओं पर विजय पाने की अद्भुत शक्ति प्रदान करती है। 
            आपकी कृपा से हमें वह ओज और तेज प्राप्त हो जिससे हम समाज में सत्य और न्याय का मार्ग प्रशस्त करने वाले निस्वार्थ योद्धा बन सकें। 
            हे देवराज, आप हमारे भीतर के प्रत्येक सूक्ष्म डर को समाप्त कर हमें पूर्णतः निर्भीक, शांत और आत्मविश्वासी बनाने की महान कृपा करें। 
            जब आप हमारे हृदय में साहस का दिव्य बीज बोते हैं, तब संसार की कोई भी प्रतिकूल परिस्थिति या अभाव हमें कभी विचलित नहीं कर सकता। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी महानता का एक अंश हमारे चरित्र में भी झलके और हम मानवता के लिए श्रेष्ठ बन सकें। 
            आप ही वह शक्ति हैं जो हमारे शिथिल और थके हुए मन में नवीन ऊर्जा का संचार कर हमें निरंतर कर्मयोग की ओर सफलतापूर्वक अग्रसर करती हैं। 
            हे इन्द्र, हमें वह आध्यात्मिक सामर्थ्य दें कि हम सांसारिक प्रलोभनों से ऊपर उठकर ईश्वर के वास्तविक और शाश्वत सत्य स्वरूप को पा सकें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके संरक्षण में सदैव निर्भय होकर एक गौरवशाली और सार्थक जीवन व्यतीत करने में सफल हों।
        """.trimIndent(),
        englishCommentary = """
            O Shatakratu Indra, you are truly the lover of heroism, valor, and inner strength; please instill that same valor and unshakable courage within us. 
            You are exceedingly great and radiant; grant firmness to the noble resolutions of our lives so that we are always ready for the defense of Dharma. 
            True heroism is not just seen in physical external war, but in the power that enables us to conquer our own inner flaws and hidden enemies. 
            By your grace, let us receive that vigor and luster which transform us into selfless warriors who pave the way for Truth and Justice in society. 
            O King of Gods, graciously terminate every subtle fear within us and make us completely fearless, calm, and self-confident. 
            When you sow the divine seed of courage in our hearts, no adverse circumstance or scarcity of the world can ever sway or disturb us. 
            We worship you with devotion so that a fraction of your greatness reflects in our character and we become superior beings for humanity. 
            You are the power that infuses fresh energy into our lethargic and tired minds, pushing us successfully toward the path of Karma Yoga. 
            O Indra, give us the spiritual capability to rise above worldly temptations and attain the true essence of the Divine and Eternal Truth. 
            May your merciful gaze always remain upon us as we lead a glorious and meaningful life successfully under your supreme divine protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 96,
        sanskrit = "तं घेमित्था नमस्विन उप स्वराजमासते ।\nहोत्रभिरिन्द्रं वावृधुः ॥ ९६ ॥",
        hindiCommentary = """
            हे भक्तों! जो इन्द्रदेव स्वयं प्रकाशित और अपने ही साम्राज्य में पूर्णतः प्रतिष्ठित हैं, भक्त उनकी परम उपासना और नमस्कार करते हैं। 
            वे 'होता' के पवित्र आह्वान और यज्ञीय आहुतियों के माध्यम से निरंतर प्रदीप्त और भक्तों के हृदयों में संवर्धित किए जाते हैं। 
            इन्द्र की यह 'स्वराज' अवस्था मनुष्य को आत्म-संयम, आत्म-बोध और वास्तविक आत्म-निर्भरता का महान आध्यात्मिक संदेश प्रदान करती है। 
            जब हम अपनी दसों इंद्रियों के स्वामी स्वयं बन जाते हैं, तब हम अपने भीतर इन्द्र के उस दिव्य और तेजस्वी स्वरूप का अनुभव कर सकते हैं। 
            यज्ञ की पवित्र अग्नि में दी गई प्रत्येक आहुति इन्द्र के बल को बढ़ाती है, जो अंततः ब्रह्मांडीय संतुलन के रूप में हमारे ही कल्याण के लिए आती है। 
            हे देव, आप अपनी असीम महिमा के साथ हमारे जीवन के प्रत्येक कठिन कार्य में सहायक बनकर हमें पूर्ण सफलता की ओर ले जाएं। 
            आपकी निरंतर उपासना से हमारे मन के समस्त संशय दूर होते हैं और हमें वह दिव्य स्पष्टता प्राप्त होती है जिससे हम सत्य को जान सकें। 
            हम श्रद्धापूर्वक आपके सम्मुख नतमस्तक हैं ताकि आपकी न्यायपूर्ण और दयालु दृष्टि हमें सदैव उन्नति के मार्ग पर अग्रसर रखे। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे सूक्ष्म संकल्पों को ब्रह्मांडीय सिद्धियों और भौतिक प्रचुरता में बदलने का सामर्थ्य रखती हैं। 
            हे इन्द्र, आप हमारे रक्षक और स्वामी बनकर हमें अज्ञान के अंधकार से निकालकर दिव्यता के सर्वोच्च प्रकाश की ओर सफलतापूर्वक ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O devotees, those who are filled with deep reverence sit before Lord Indra, who is self-radiant and established in his own sovereignty. 
            He is continuously increased and glorified through the sacred calls of the priests and the sincere sacrificial offerings of the followers. 
            This state of 'Svaraj' or self-sovereignty by Indra provides a great spiritual message of self-control and self-reliance to all of humanity. 
            When we become the true masters of our own senses, we can experience that divine and radiant aspect of Indra within our consciousness. 
            Every oblation offered in the sacrificial fire increases Indra's strength, which ultimately returns to us as cosmic balance and welfare. 
            O God, with your infinite majesty, become our helper in every daunting task of our life and lead us toward magnificent success. 
            Worshipping you consistently removes the doubts of our minds and grants us the divine clarity required to perceive the Eternal Truth. 
            We bow before you with devotion so that your just and merciful gaze continuously steers us toward the path of progress and evolution. 
            You are the ultimate power that possesses the capability to transform our subtle intentions into cosmic achievements and material plenty. 
            O Indra, stay with us as our protector and Lord; pull us out of the darkness of ignorance toward the highest light of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 97,
        sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ ९७ ॥",
        hindiCommentary = """
            हे श्रेष्ठ मार्ग दिखाने वाले इन्द्रदेव! आप इस पवित्र सोमरस का पान करें जो आपको अत्यंत हर्ष, आनंद और अजेय ऊर्जा प्रदान करने वाला है। 
            आपका यह आनंद समस्त प्रजाओं को तृप्त करने वाला है और आप स्वयं असीम शक्ति के पुंज के रूप में इस ब्रह्मांड में प्रतिष्ठित हैं। 
            हम इस विशेष यज्ञीय अनुष्ठान में आपको प्रसन्न करने के लिए अपनी स्तुतियों और श्रद्धा के साथ आपकी अनन्य सेवा और अर्चना करते हैं। 
            आपकी दिव्य ऊर्जा से ही यह संपूर्ण जगत और इसकी सूक्ष्म गतियाँ संचालित होती हैं, और सोम का पान कर आप और अधिक प्रदीप्त और तेजस्वी हो जाते हैं। 
            हे देवराज, हमारे इस अनुष्ठान को अपनी पावन उपस्थिति से पवित्र करें और हमें वह आंतरिक बल दें कि हम सदैव सत्य की रक्षा कर सकें। 
            जैसे वर्षा की बूंदों से प्यासी धरती तृप्त होती है, वैसे ही आपकी कृपा से हमारे जीवन के समस्त अभाव और कष्ट सदा के लिए दूर हो जाते हैं। 
            हम अत्यंत श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमारे जीवन को सुख, अखंड शांति और भौतिक समृद्धि से परिपूर्ण कर दें। 
            आपकी यह दिव्य और अजेय शक्ति हमें संशय के अंधकार से बाहर निकालती है और हमें सत्यनिष्ठा तथा दृढ़ चरित्र की अद्भुत शक्ति प्रदान करती है। 
            हे इन्द्र, आप हमारे सबसे निकट के आत्मीय संबंधी बनकर हमें वह दिव्य सुख दें जो संसार की क्षणभंगुर वस्तुओं में सर्वथा दुर्लभ है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा हृदय सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम ईश्वरमय रहें।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the guide on the most excellent path, please drink this holy Soma which grants you immense joy, exhilaration, and new energy. 
            Your bliss is that which satisfies and nourishes all living beings, and you are established in this universe as the source of infinite power. 
            In this special sacrificial session, we offer our exclusive service with hymns and deep faith to please and glorify your divinity. 
            It is through your divine energy that this entire universe and its movements are governed; by consuming Soma, you become more radiant. 
            O King of Gods, sanctify this ritual of ours with your holy presence and grant us the inner strength to always protect and serve Dharma. 
            Just as the thirsty earth is satisfied by raindrops, all the scarcities, sorrows, and afflictions of our lives vanish forever by your grace. 
            We bow before your feet with profound devotion so that you may fill our lives with happiness, unbroken peace, and material prosperity. 
            Your divine and invincible power pulls us out of the darkness of doubt and grants us the amazing strength of integrity and firm character. 
            O Indra, become our nearest and most intimate relative and bestow upon us that divine bliss which is rare in fleeting worldly things. 
            We constantly sing your glories so that our hearts remain forever illuminated with the light of devotion and knowledge near the Divine.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 98,
        sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ ९८ ॥",
        hindiCommentary = """
            हे दिव्य शक्तियों के ज्ञाता! मैं उन इन्द्रदेव की स्तुति करता हूँ जो समस्त प्रजाओं के परम स्वामी और बलवानों में भी सर्वश्रेष्ठ वीर हैं। 
            वे अनेक महान यज्ञों और अत्यंत प्राचीन स्तुतियों के एकमात्र अधिकारी हैं, और उनकी शक्ति की सीमा का पार पाना किसी के लिए संभव नहीं। 
            इन्द्र ही वह सर्वोच्च सत्ता हैं जो ब्रह्मांड के न्याय, अनुशासन और संतुलन को बनाए रखने के लिए अपनी प्रचंड और अजेय शक्ति का प्रयोग करते हैं। 
            उनकी महिमा का भक्तिपूर्वक गान करने से मनुष्य के भीतर के सुप्त साहस, वीरता और ओज का जागरण होता है, जिससे वह जीवन में विजयी बनता है। 
            हे देव, आप हमारे जीवन के प्रत्येक अंधकारमय पक्ष को दूर कर हमें वह तेज प्रदान करें जिससे हम समाज में गौरवपूर्ण स्थान प्राप्त कर सकें। 
            आपकी कृपा से हमें वह ऐश्वर्य और धन प्राप्त हो जो पूर्णतः सत्य के मार्ग पर चलकर अर्जित किया गया हो और जो मानवता के लिए कल्याणकारी हो। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे अंतःकरण को शुद्ध कर हमें ईश्वर के वास्तविक सान्निध्य और आत्मिक शांति का अनुभव कराते हैं। 
            आप ही वह पराशक्ति हैं जो हमारे द्वारा किए गए कठिन परिश्रम को ईश्वरीय फल में और हमारी आर्त प्रार्थनाओं को दिव्य आशीर्वाद में बदलती हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल या असहाय नहीं रहता, क्योंकि उसे आत्मज्ञान की प्रखरता और भौतिक संपन्नता दोनों का वरदान मिलता है। 
            हे इन्द्र, आप हमारे रक्षक और शाश्वत मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें महान, यशस्वी और धर्मनिष्ठ बनाने की असीम कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O knower of divine powers, I praise Lord Indra, the supreme master of all subjects and the foremost among the strong. 
            He is the sole rightful recipient of many great sacrifices and ancient hymns, and no being can ever surpass the limit of his might. 
            Indra is the supreme authority who utilizes his fierce and invincible power to maintain the justice, discipline, and balance of the universe. 
            Singing his glories with devotion awakens the dormant courage, heroism, and vigor within a person, enabling them to emerge victorious in life. 
            O God, remove every dark aspect of our existence and bestow upon us that brilliance which allows us to attain a place of honor in society. 
            By your grace, let us receive that wealth which is earned strictly by following the path of Truth and which is beneficial for all of humanity. 
            We worship you because you are the one who purifies our inner self and allows us to experience the proximity of God and spiritual peace. 
            You are the supreme power that transforms our hard labor into divine results and our desperate prayers into magnificent celestial blessings. 
            A seeker who takes refuge in Lord Indra never remains weak or helpless; they are blessed with the sharpness of self-knowledge and abundance. 
            O Indra, stay with us as our protector and eternal guide, and graciously make us great, successful, renowned, and devoted to Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 99,
        sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ ९९ ॥",
        hindiCommentary = """
            हे मेरे श्रेष्ठ मित्रों! आप उन इन्द्रदेव के लिए अत्यंत आनंददायक और भक्तिपूर्ण गीतों का गान करें जो अश्वों के स्वामी और सोम के पानकर्ता हैं। 
            आपकी मधुर वाणी से निकले हुए ये पवित्र भजन इन्द्र को प्रसन्न करते हैं और उन्हें हमारे इस यज्ञीय अनुष्ठान में साक्षात् पधारने के लिए आमंत्रित करते हैं। 
            इन्द्रदेव की अजेय शक्ति का रहस्य सोम के श्रद्धापूर्ण पान और भक्तों की निष्कपट पुकार में छिपा है, जो उन्हें संपूर्ण ब्रह्मांड में अजेय बना देता है। 
            जब हम सामूहिक रूप से उनकी महिमा गाते हैं, तो हमारे चारों ओर एक अत्यंत सकारात्मक, ऊर्जावान और दिव्य वातावरण का निर्माण स्वतः ही होने लगता है। 
            हे देव, आप अपने तेजस्वी और वायु के समान तीव्र घोड़ों पर सवार होकर हमारे जीवन के कठिन संघर्षों में आएं और हमारे समस्त शत्रुओं का संहार करें। 
            हमें वह अटूट भक्ति और एकाग्रता प्रदान करें जिससे हम आपकी विराट और सर्वव्यापी सत्ता का अनुभव अपने भीतर कर सकें और सदैव मानसिक रूप से शांत रहें। 
            आपकी कृपा से हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, अखंड सौभाग्य और आध्यात्मिक श्रेष्ठता प्राप्त करने की दिव्य शक्ति और प्रेरणा मिले। 
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि हमारा जीवन सदैव लोक-कल्याण, परोपकार और सत्य की सेवा में लगा रहे और हम निरंतर आत्मोन्नति करें। 
            इन्द्रदेव की पवित्र मित्रता हमारे लिए वह अभेद्य सुरक्षा कवच है जो हमारे समस्त संशयों, भयों और दुखों को जड़ से समाप्त कर हमें निर्भय बना देती है। 
            हे इन्द्र, आप हमारे परम स्वामी, रक्षक और गुरु हैं; हमें अज्ञान के अंधकार से निकालकर आत्मज्ञान के परम प्रकाश और परमात्मा के शाश्वत सत्य की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O my dear friends, sing exhilarated and highly devoted songs for Lord Indra, the master of horses and the drinker of Soma. 
            These sacred hymns arising from your sweet voices delight Indra and invite him to manifest personally within our sacrificial ritual today. 
            The secret of Indra's invincible might lies in the devoted consumption of Soma and the sincere calls of his devotees, making him unsurpassed. 
            When we collectively sing his glories, an extremely positive, energetic, and divine atmosphere begins to manifest around us automatically. 
            O God, riding upon your radiant horses that are as swift as the wind, come into the difficult struggles of our life and destroy all our enemies. 
            Grant us that unshakable devotion and focus which enables us to experience your vast and omnipresent existence within us and remain calm. 
            By your grace, remove every lack from our lives and grant us the divine power and inspiration to attain completeness and spiritual excellence. 
            We worship you with devotion so that our life remains dedicated to public welfare, altruism, and the service of Truth, helping us grow inwardly. 
            The holy friendship of Lord Indra is that impenetrable shield for us which completely uproots all our doubts, fears, and sorrows, making us bold. 
            O Indra, you are our supreme Lord, Protector, and Teacher; lead us out of the darkness of ignorance toward the light of Self-realization and Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 100,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ १०० ॥",
        hindiCommentary = """
            समस्त स्तुतियां समुद्र के समान विशाल और सर्वव्यापी इन्द्रदेव की महिमा को निरंतर बढ़ाती और पूरे संसार में अत्यंत गौरव के साथ प्रकाशित करती हैं। 
            वे रथियों में श्रेष्ठ और समस्त विजयों के अधिपति हैं, जिनकी बार-बार अत्यंत श्रद्धा के साथ प्रशंसा और गौरवपूर्ण वंदना की जानी चाहिए। 
            इन्द्र की व्यापकता आकाश और समुद्र की तरह अनंत और अथाह है, जिसमें संपूर्ण ब्रह्मांड की शक्तियाँ सुरक्षित और पूर्णतः समाहित रहती हैं। 
            वे हमारे जीवन रूपी रथ के सबसे कुशल और दिव्य सारथी हैं, जो हमें संसार की समस्त बाधाओं के बीच से सफलतापूर्वक और निर्विघ्न निकाल ले जाते हैं। 
            हे देव, आप अपनी प्रचंड शक्ति और अपार बुद्धिमत्ता से हमारे प्रत्येक प्रयास को सफलता के उच्चतम और श्रेष्ठ शिखर तक पहुँचाने की महान कृपा करें। 
            हमें वह आध्यात्मिक और भौतिक शक्ति प्रदान करें जिससे हम निर्बलों की सहायता कर सकें और धर्म की ध्वजा को सदैव इस जगत में ऊँचा रख सकें। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की पूर्ण शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत, सचेत और पवित्र होने लगते हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी भी पराजित नहीं होता, क्योंकि स्वयं संपूर्ण ब्रह्मांड का नायक उसका सहायक, रक्षक और परम मित्र बन जाता है। 
            आपकी दिव्य दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और शाश्वत कीर्ति का सही मार्ग निरंतर दिखाए, यही हमारी विनम्र प्रार्थना है। 
            हे इन्द्र, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और आत्मिक रूप से सुखी बनाने की महान कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            All the hymns and prayers continuously increase and illuminate the glory of Lord Indra, who is as vast and all-encompassing as the ocean. 
            He is the foremost among divine charioteers and the Lord of all victories, worthy of being praised and glorified with deep devotion. 
            The expanse of Indra's presence is infinite and unfathomable like the sky and the sea, within which all cosmic powers are safely contained. 
            He is the most skillful and divine charioteer of our life's vessel, guiding us expertly and safely through the various obstacles of the world. 
            O God, with your fierce power and immense wisdom, graciously lead our every effort to the absolute peak of success and excellence. 
            Bestow upon us both spiritual and material power so that we can assist the weak and keep the flag of righteousness flying high in the world. 
            The continuous singing of your glories completely purifies our inner self and initiates our constant spiritual awakening and divine awareness. 
            A seeker who takes refuge in Lord Indra is never defeated, for the hero of the entire universe becomes their personal helper and friend. 
            Let your divine radiance illuminate every dark corner of our existence and show us the pathway to fame, splendor, and eternal glory. 
            O Indra, always remain with us as our protector and nourisher, graciously making our lives magnificent, successful, and truly happy.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 101,
        sanskrit = "पुनानः सोम धारया अपो वसानो अर्षसि ।\nआ रत्नधा योनिं ऋतस्य सीदसि ॥ १०१ ॥",
        hindiCommentary = """
            पवित्र किया जाता हुआ यह सोम अपनी दिव्य धारा के साथ जल रूपी वस्त्रों को धारण कर वेगपूर्वक प्रवाहित हो रहा है। 
            रत्नों और श्रेष्ठ गुणों को धारण करने वाला यह सोम 'ऋत' (ब्रह्मांडीय सत्य) के मूल स्थान पर जाकर विराजमान होता है। 
            सोम का जल के साथ मिलन जीवन की सृजनात्मक ऊर्जा और शांति के सुंदर समन्वय का प्रतीक है। 
            जैसे सोम ऋत के स्थान पर बैठता है, वैसे ही हमारे संकल्प भी सत्य और धर्म के आधार पर प्रतिष्ठित होने चाहिए। 
            हे देव, आप अपनी इस पावन यात्रा के माध्यम से हमारे अंतःकरण को शुद्ध कर उसे दैवीय आभा से पूरी तरह आलोकित कर दें। 
            आपकी उपस्थिति हमारे जीवन के प्रत्येक यज्ञीय कर्म को सफल बनाती है और हमें देवताओं के आशीर्वाद का पात्र बनाती है। 
            हमें वह 'रत्न' (विवेक और प्रज्ञा) प्रदान करें जो हमारे जीवन की दिशा को अंधकार से हटाकर प्रकाश की ओर मोड़ दे। 
            जब हम आपकी शरण में होते हैं, तब ब्रह्मांड का परम सत्य हमारे हृदय में स्वतः ही प्रकाशित होने लगता है। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी कृपा की धारा हमारे परिवार और समाज में सदैव सुख और शांति लाए। 
            हे पवमान सोम, आप हमारे रक्षक और शाश्वत मार्गदर्शक बनकर हमें मोक्ष और ईश्वर के परम पद तक पहुँचाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            The purified Soma flows with its divine stream, appearing as if clothed in waters (Apo Vasano) as it rushes forward. 
            This bestower of treasures and virtues (Ratnadha) proceeds to seat himself upon the primal source of cosmic Truth (Rta). 
            The merging of Soma with water symbolizes the beautiful harmony between the creative energy of life and profound peace. 
            Just as Soma sits at the source of Rta, may our resolutions also be established upon the foundations of Truth and Dharma. 
            O God, through this holy journey of yours, purify our inner self and illuminate it completely with your celestial radiance. 
            Your presence makes every sacrificial act of our lives successful and makes us worthy of the magnificent blessings of the gods. 
            Bestow upon us those 'gems' of wisdom and discernment that shift our life's direction away from darkness toward light. 
            When we are in your refuge, the ultimate Truth of the universe begins to manifest within our hearts naturally and effortlessly. 
            We worship you with devotion so that the stream of your grace always brings happiness and peace to our families and society. 
            O Pavamana Soma, stay as our protector and eternal guide, and graciously lead us to liberation and the supreme state of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 102,
        sanskrit = "अक्षण्वन्तः कर्णवन्तः सखायो मनोजवेषु असमा बभूवुः ।\nआदध्रास उपकक्षास उ त्वे ह्रदा इव स्त्रावा दृश्यन्ते ॥ १०२ ॥",
        hindiCommentary = """
            आँख और कान वाले मित्र (सखायो) भी मन की गति और दिव्य अनुभूतियों के क्षेत्र में एक समान (असमा) नहीं होते हैं। 
            कुछ साधक केवल बाहरी सतह तक ही पहुँच पाते हैं, जबकि कुछ गहरे सरोवर (ह्रदा) के समान ईश्वर के रहस्यों का दर्शन करते हैं। 
            यह मंत्र आध्यात्मिक साधना की गहराई और साधकों की विभिन्न श्रेणियों के बीच के सूक्ष्म अंतर को स्पष्ट करता है। 
            केवल शारीरिक इंद्रियों का होना पर्याप्त नहीं है; वास्तविक ज्ञान वही है जो हृदय की गहराई और मन की एकाग्रता से प्राप्त हो। 
            हे सोम, आप हमें वह अंतर्दृष्टि प्रदान करें जिससे हम बाहरी प्रपंचों से हटकर आपके वास्तविक और दिव्य स्वरूप को पहचान सकें। 
            जैसे सरोवर शांत होने पर ही अपना तल दिखाता है, वैसे ही शांत मन ही परमात्मा की छवि को ग्रहण करने में समर्थ होता है। 
            हम आपकी निरंतर उपासना करते हैं ताकि हमारे संशय दूर हों और हम ज्ञान के उस गहरे सरोवर में डुबकी लगा सकें। 
            आपकी कृपा से ही हमारे भीतर वह पात्रता विकसित होती है जिससे हम दिव्य मंत्रों और सत्यों के साक्षात् द्रष्टा बन पाते हैं। 
            इन्द्रदेव के सखा सोम, आप हमें वह मेधा और प्रज्ञा दें जो हमें संसार के शोर में भी ईश्वर की पुकार सुनने के योग्य बनाए। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन साधारण से असाधारण और दिव्य बन सके।
        """.trimIndent(),
        englishCommentary = """
            Friends (Sakhayo) who possess eyes and ears are not equal (Asama) in their mental speed and divine realizations. 
            Some seekers only reach the shallow edges, while others, like deep lakes (Hrada), perceive the profound mysteries of the Divine. 
            This mantra clarifies the depth of spiritual practice and the subtle differences between various levels of seekers and their insights. 
            Possessing physical senses is not enough; true knowledge is that which is attained through the depth of the heart and mental focus. 
            O Soma, grant us that inner vision which allows us to look beyond external illusions and recognize your true celestial nature. 
            Just as a lake shows its bottom only when still, a calm mind is the only vessel capable of reflecting the image of the Supreme. 
            We worship you continuously so that our doubts vanish and we may dive deep into that profound lake of ultimate wisdom. 
            It is through your grace that the eligibility is developed within us to become direct seers of divine mantras and eternal truths. 
            O Soma, companion of Indra, grant us that intellect and wisdom which make us capable of hearing God's call amidst the world's noise. 
            We offer our entire faith at your feet so that our lives may transform from ordinary existence into an extraordinary and divine journey.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 103,
        sanskrit = "यस्य ते द्युमतो मदा अच्छा विचेतसा ।\nसोम अर्षसि धारया ॥ १०३ ॥",
        hindiCommentary = """
            हे सोम! आपकी वह आनंददायक और मदहोश कर देने वाली धारा, जो विशेष ज्ञान से युक्त है, हमारे कल्याण के लिए प्रवाहित हो। 
            आप स्वयं प्रकाशमान हैं, और आपकी धारा हमारे जीवन के अंधकारमय मार्गों को अपनी ज्योति से आलोकित कर देने वाली है। 
            सोम का मद कोई सांसारिक नशा नहीं, बल्कि वह आध्यात्मिक आह्लाद है जो आत्मा को परमात्मा के साथ एकरूप कर देता है। 
            आपकी यह चेतना हमें वह शक्ति प्रदान करती है जिससे हम जीवन की जटिलताओं को समझकर सत्य का मार्ग चुनने में समर्थ होते हैं। 
            हे देव, आप हमारे यज्ञ में अपनी मधुर धारा के साथ पधारें और हमारे संकल्पों को दिव्यता की मिठास से पूरी तरह भर दें। 
            जब आपकी कृपा का प्रवाह हमारे जीवन में आता है, तो समस्त दुःख और दरिद्रता कपूर की तरह उड़कर सदा के लिए समाप्त हो जाते हैं। 
            हमें वह विशेष बोध प्रदान करें जिससे हम संसार के क्षणभंगुर आकर्षणों के प्रति अनासक्त होकर आपके प्रति समर्पित रहें। 
            आप ही वह शक्ति हैं जो हमारे शिथिल मन को ऊर्जावान बनाती हैं और हमें निरंतर प्रगति के पथ पर गतिशील रखती हैं। 
            हम श्रद्धापूर्वक आपकी महिमा का गान करते हैं ताकि आपकी उदारता का प्रवाह हमारे घर और हृदय में सदैव निरंतर बना रहे। 
            हे दिव्य सोम, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली और यशस्वी बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Soma, may your exhilarating and intoxicating stream, combined with special wisdom, flow for our welfare and peace. 
            You are self-radiant, and your current is destined to illuminate the dark pathways of our existence with its eternal light. 
            The exhilaration of Soma is not a worldly intoxication but that spiritual bliss which unifies the individual soul with the Supreme Being. 
            This consciousness of yours provides us with the power to understand life's complexities and choose the path of Truth successfully. 
            O God, manifest within our sacrifice with your sweet stream and fill our resolutions with the sweetness of divine grace and love. 
            When the flow of your grace enters our life, all sufferings and poverty evaporate and terminate forever like camphor in a flame. 
            Grant us that special awareness through which we remain detached from fleeting attractions and dedicated strictly to you. 
            You are the power that energizes our lethargic minds and keeps us constantly dynamic on the pathway of continuous progress. 
            We worship you with devotion so that the flow of your immense generosity remains forever present within our homes and hearts. 
            O Divine Soma, stay with us as our protector and nourisher, and graciously make our lives magnificent, successful, and full.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 104,
        sanskrit = "पवस्व वाजसातये पवस्व परि मंहिष्ठः ।\nपवस्व मयोभुवे ॥ १०४ ॥",
        hindiCommentary = """
            हे पवमान सोम! आप विजय प्राप्त करने (वाजसातये) और सामर्थ्य की वृद्धि के लिए अत्यंत पवित्र होकर यहाँ प्रवाहित हों। 
            आप दानियों में सर्वश्रेष्ठ और उदार (मंहिष्ठः) हैं, कृपया अपनी धारा से हमारे जीवन को सुखकारी और आनंदमय (मयोभुवे) बनाएं। 
            यह मंत्र संघर्ष के समय ईश्वर से प्राप्त होने वाले उस बल का आह्वान है जो मनुष्य को पराजय के भय से मुक्त करता है। 
            सोम का प्रवाह हमारे संकल्पों को वह धार देता है जिससे हम अधर्म की जटिल जंजीरों को सफलतापूर्वक काट सकते हैं। 
            आपकी उदारता केवल भौतिक धन तक सीमित नहीं है, बल्कि वह आत्मज्ञान की उस परम निधि को भी हमें प्रदान करती है। 
            जैसे पवित्र धारा कंकड़-पत्थरों को हटाकर रास्ता बनाती है, वैसे ही आप हमारे मार्ग की समस्त बाधाओं को दूर करें। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी कृपा का अमृत हमारे अंतःकरण को सदैव नवीन और ऊर्जस्वित रखे। 
            आप ही वह शक्ति हैं जो हमारे कठिन पुरुषार्थ को ईश्वरीय आशीर्वाद में बदलकर हमें समाज में यशस्वी बनाती हैं। 
            हमें वह आध्यात्मिक प्यास प्रदान करें जो केवल आपके सान्निध्य रूपी अमृत से ही शांत हो सके और हमें पूर्ण तृप्ति दे। 
            हे सोम, आप हमारे रक्षक और गुरु बनकर हमें जीवन की सफलता और दिव्यता के सर्वोच्च एवं पवित्र शिखर पर पहुँचाएँ।
        """.trimIndent(),
        englishCommentary = """
            O Pavamana Soma, flow in your purified state for the attainment of victory (Vajasataye) and the expansion of strength. 
            You are the most liberal and generous among givers (Manhishthah); graciously make our lives comfortable and blissful with your stream (Mayobhuve). 
            This mantra is an invocation of that divine force which liberates a human being from the fear of defeat during times of struggle. 
            The flow of Soma provides our resolutions with the edge required to successfully cut through the complex chains of unrighteousness. 
            Your generosity is not limited to material wealth; it also bestows upon us the ultimate treasure of Self-realization and peace. 
            Just as a sacred stream clears pebbles to make its way, may you clear all the obstacles from our life's spiritual pathway. 
            We worship you with devotion so that the nectar of your grace keeps our inner self forever refreshed, new, and energized. 
            You are the power that transforms our hard labor into divine blessings, making us successful and respected in society. 
            Grant us that spiritual thirst which can only be quenched by the nectar of your presence, leading us to absolute satisfaction. 
            O Soma, stay as our protector and guide, leading us to the highest and most sacred peaks of life's success and divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 105,
        sanskrit = "अग्नये ब्रह्म गायत विप्राय देवहूतमये ।\nस नः पर्षत् अति द्विषः ॥ १०५ ॥",
        hindiCommentary = """
            हे स्तोताओं! आप उन अग्निदेव के लिए पवित्र वेदमंत्रों (ब्रह्म) का गान करें, जो विद्वान (विप्र) हैं और देवताओं का आह्वान करने वाले हैं। 
            वे अग्निदेव हमें समस्त द्वेषी शत्रुओं और संकटों (द्विषः) से पार ले जाने की असीम शक्ति और दयालुता रखने वाले सर्वोच्च देव हैं। 
            अग्नि यहाँ न केवल भौतिक ज्वाला है, बल्कि वह ज्ञान की वह ऊर्जा है जो हमारे भीतर के अंधकार और नकारात्मकता को समूल जला देती है। 
            जब हम अपनी वाणी को अग्नि की स्तुति में समर्पित करते हैं, तो हमारे विचार शुद्ध होते हैं और हम आध्यात्मिक ऊँचाइयों को प्राप्त करते हैं। 
            हे देव, आप हमारे जीवन के संघर्षों में एक शक्तिशाली रक्षक बनकर प्रकट हों और हमें अधर्म के मार्ग से हटाकर धर्म के मार्ग पर ले चलें। 
            आपकी ज्योति हमारे संकल्पों को वह दृढ़ता प्रदान करती है जिससे हम संसार के द्वंद्वों में भी विचलित नहीं होते और सदैव शांत रहते हैं। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आप ही हमारे यज्ञ को देवताओं तक पहुँचाने वाले सबसे विश्वसनीय और पवित्र दूत हैं। 
            यज्ञ की अग्नि में दी गई प्रत्येक आहुति आपके माध्यम से ही सार्थक होती है और हमें वह आत्मिक बल देती है जो विजय के लिए अनिवार्य है। 
            हमें वह विवेक और प्रज्ञा प्रदान करें जिससे हम सत्य को पहचान सकें और मानवता की सेवा में अपने जीवन को पूरी तरह समर्पित कर सकें। 
            हे अग्नि, आप हमारे रक्षक और गुरु बनकर हमें जीवन की जटिलताओं से उबारें और दिव्यता के सर्वोच्च एवं पवित्र शिखर पर पहुँचाएँ।
        """.trimIndent(),
        englishCommentary = """
            O chanters, sing the sacred Vedic hymns (Brahma) for Lord Agni, who is the wise seer (Vipra) and the invoker of the celestial gods. 
            May Agni carry us across all malicious enemies and daunting calamities (Dwishah) through his boundless strength and mercy. 
            Agni here is not just physical fire but the energy of knowledge that burns away the internal darkness and negativity from our lives. 
            When we dedicate our voice to the praise of Agni, our thoughts become purified, and we attain higher spiritual dimensions of existence. 
            O God, manifest in our struggles as a powerful guardian and steer us away from unrighteousness toward the path of Dharma. 
            Your light provides our resolutions with that firmness through which we remain unshaken and peaceful even amidst worldly dualities. 
            We worship you with devotion because you are the most reliable and sacred messenger who carries our sacrifice to the gods. 
            Every oblation offered in the sacrificial fire becomes meaningful only through you and grants us the spiritual force essential for victory. 
            Bestow upon us the wisdom and discernment to recognize Truth and to dedicate our lives to the selfless service of entire humanity. 
            O Agni, stay as our protector and teacher, rescue us from life's complexities, and lead us to the supreme and holy peaks of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 106,
        sanskrit = "य उग्रः सवनेष्वा तविषीं अधत् सुतः ।\nस इन्द्रो वृत्रहा बभूविथ ॥ १०६ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! आप वही उग्र और प्रचंड पराक्रमी देव हैं, जिन्होंने यज्ञों (सवनेषु) में सोमरस के पान से असीम बल और शक्ति धारण की है। 
            आप ही वह वृत्रहा (वृत्रासुर के संहारक) हैं, जिन्होंने अज्ञान और जड़ता के प्रतीकात्मक शत्रुओं का नाश कर जगत को प्रकाश और गति प्रदान की। 
            इन्द्र का बल सोम की शुद्धि और यज्ञ की पवित्रता पर आधारित है, जो हमें यह सिखाता है कि आध्यात्मिक शक्ति ही वास्तविक विजय का आधार है। 
            जब हम अपने भीतर के 'वृत्र' (काम, क्रोध और लोभ) को मारते हैं, तभी हमें इन्द्र जैसी अजेय ऊर्जा और शांति की प्राप्ति होती है। 
            हे देव, आप हमारे जीवन के युद्ध क्षेत्र में पधारें और हमारे संकल्पों को वह तेज दें कि हम बुराइयों के विरुद्ध अडिग रहकर खड़े हो सकें। 
            आपकी विजय ही ब्रह्मांड की व्यवस्था का आधार है, और आपकी प्रसन्नता से ही हमें वर्षा, अन्न और संपन्नता का सुखद वरदान मिलता है। 
            हम अपनी मधुर वाणी और निष्कपट हृदय से आपकी स्तुति करते हैं ताकि आप हमारे जीवन के समस्त अमंगलों को सदा के लिए जड़ से भस्म कर दें। 
            आप ही वह सर्वोच्च सत्ता हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें उन्नति के पथ पर निरंतर और सफलतापूर्वक आगे बढ़ाती हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल या असहाय नहीं रहता, क्योंकि उसे परमात्मा के प्रत्यक्ष सहयोग का दिव्य अनुभव होता है। 
            हे अजेय इन्द्र, आप हमारे परम रक्षक और गुरु बनकर हमें अज्ञान के गर्त से निकालकर दिव्यता के शाश्वत प्रकाश की ओर ले चलने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, you are that fierce and formidable deity who has assumed boundless strength by consuming Soma in the sacrificial sessions (Savaneshu). 
            You are the Vritrahan (Slayer of Vritra), who destroyed the symbolic enemies of ignorance and stagnation to grant light and motion to the world. 
            Indra's power is rooted in the purification of Soma and the sanctity of the ritual, teaching us that spiritual strength is the true basis of victory. 
            When we slay the 'Vritra' within us (lust, anger, and greed), only then do we attain the invincible energy and peace characterized by Indra. 
            O God, manifest within the battlefield of our lives and grant our resolutions the brilliance needed to stand firm against all evils. 
            Your victory is the foundation of cosmic order, and it is through your satisfaction that we receive the blessings of rain, food, and prosperity. 
            We praise you with our sweet voices and sincere hearts so that you may completely burn away all inauspiciousness from our existence forever. 
            You are the supreme authority that makes our labor meaningful and continuously drives us forward on the path of growth and success. 
            A seeker who takes refuge in Lord Indra never remains weak or helpless, as they experience the divine support of the Almighty directly. 
            O unconquerable Indra, stay as our protector and teacher, pulling us out of the pit of ignorance toward the eternal light of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 107,
        sanskrit = "त्वामिद्धि हवामहे सातौ वाजस्य कारवः ।\nत्वां वृत्रेषु इन्द्र सत्पतिं नरस्त्वां काष्ठास्वर्वतः ॥ १०७ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! हम यज्ञ करने वाले साधक युद्ध में विजय और अजेय सामर्थ्य की प्राप्ति के लिए केवल आपको ही अत्यंत श्रद्धापूर्वक पुकारते हैं। 
            आप ही वह 'सत्पति' (सज्जनों के स्वामी) हैं जो वृत्रासुर जैसे भयंकर और अज्ञानी शत्रुओं का नाश कर हमें धर्म की रक्षा का बल प्रदान करते हैं। 
            जीवन की कठिन परीक्षाओं और कर्मों के संग्राम में, पराक्रमी वीर योद्धा केवल आपकी ही दिव्य शक्ति और मार्गदर्शन का आह्वान करते हैं। 
            जैसे वेगवान और अनुशासित अश्व अपने लक्ष्य की ओर दौड़ते हैं, वैसे ही हमारे संकल्प आपकी कृपा से सफलता के सर्वोच्च शिखर की ओर बढ़ें। 
            आप ही वह महाशक्ति हैं जो हमारे जीवन के समस्त आंतरिक और बाह्य अवरोधों को दूर कर ज्ञान और संपन्नता के मार्ग को प्रशस्त करने वाली हैं। 
            हम पूर्ण निष्ठा के साथ आपकी शरण में आए हैं क्योंकि आपके दिव्य सहयोग के बिना वास्तविक विजय और मानसिक शांति प्राप्त करना असंभव है। 
            हे देवराज, आप अपनी अमोघ और प्रचंड शक्ति के साथ हमारे अंतःकरण में प्रदीप्त हों और हमें समस्त सांसारिक संशयों से स्थायी मुक्ति प्रदान करें। 
            आपकी प्रसन्नता से ही इस सृष्टि का चक्र व्यवस्थित रहता है और हमें वर्षा, पुष्टिकारक अन्न तथा उत्तम शारीरिक और मानसिक स्वास्थ्य प्राप्त होता है। 
            हम अपनी पवित्र और सत्यनिष्ठ वाणी से आपकी महिमा का गान करते हैं ताकि आपके सान्निध्य में हमारा जीवन सार्थक, यशस्वी और मंगलमय बने। 
            हे अजेय इन्द्र, आप हमारे परम रक्षक और गुरु बनकर हमें अज्ञान के अंधकार से निकालकर सत्य के शाश्वत प्रकाश की ओर ले चलने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, we the seekers performing the sacrifice invoke only you for obtaining victory and invincible capability in the battles of life. 
            You are the 'Satpati' (Lord of the righteous) who destroys formidable enemies like Vritra and empowers us to protect the Eternal Dharma. 
            In the trials of existence and the struggle of duties, mighty warriors call upon your divine strength and guidance for ultimate success. 
            Just as swift and disciplined horses race toward their target, may our resolutions advance toward the pinnacle of success through your grace. 
            You are the supreme power that removes all internal and external obstacles from our path and opens the gateway to wisdom and prosperity. 
            We seek your refuge with total dedication because without your divine assistance, attaining true victory and mental peace is impossible. 
            O King of Gods, ignite your infallible and fierce power within our consciousness and liberate us from all worldly doubts and anxieties. 
            Your satisfaction ensures the order of the cosmic cycle, granting us timely rain, nourishing food, and superior physical and mental health. 
            We sing your glories with our holy and truthful voices so that our lives become meaningful, successful, and auspicious in your presence. 
            O unconquerable Indra, stay as our supreme protector and teacher, and lead us from the darkness of ignorance to the eternal light of Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 108,
        sanskrit = "अभित्वा शूर नोनुमो दुग्धा इव धेनवः ।\nईशानमस्य जगतः स्वर्दृशमीशानमिन्द्र तस्थुषः ॥ १०८ ॥",
        hindiCommentary = """
            हे वीर इन्द्रदेव! जैसे दुधारू गौएँ अपने प्रिय बछड़े की ओर अत्यंत प्रेमपूर्वक रंभाती हुई दौड़ती हैं, वैसे ही हम आपकी निरंतर और भक्तिपूर्ण स्तुति करते हैं। 
            आप इस संपूर्ण चराचर जगत के अद्वितीय अधिपति हैं, जो जड़ और चेतन दोनों प्रकार की सत्ताओं पर पूर्णतः न्यायपूर्वक शासन करने वाले महान देव हैं। 
            आपकी दिव्य और सर्वव्यापी दृष्टि स्वर्ग लोक तक व्याप्त है, और आप ही समस्त लोकों के वास्तविक रक्षक और परम नियन्ता के रूप में प्रतिष्ठित हैं। 
            हम आपकी हृदय से वंदना करते हैं क्योंकि आप ही हमारे जीवन के गहन अज्ञान रूपी अंधकार को दूर कर उसे ज्ञान और सत्य के प्रकाश से भरते हैं। 
            आपकी असीम कृपा से ही हमें वह आत्मिक सामर्थ्य प्राप्त होता है जिससे हम अपनी चंचल इंद्रियों और भटकते हुए मन पर पूर्ण नियंत्रण पा सकें। 
            जैसे गौ अपने अमृत तुल्य दूध से संसार का पोषण करती है, वैसे ही आप अपनी कृपा की वर्षा से अपने भक्तों का सर्वांगीण और दिव्य कल्याण करते हैं। 
            आपकी महिमा का गान करने से हमारे भीतर के सोए हुए साहस और वीरता का जागरण होता है, जो हमें कर्मक्षेत्र में अजेय योद्धा बनाकर विजयी बनाता है। 
            हे देवराज, आप हमारे हृदयों में भक्ति का ऐसा अखंड दीपक जलाएं जो अज्ञान की भीषण आँधियों में भी कभी न बुझे और हमें सदैव सही राह दिखाए। 
            हम श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमें आध्यात्मिक शांति, विवेक और भौतिक संपन्नता दोनों ही प्रचुर मात्रा में प्रदान करने की कृपा करें। 
            हे अजेय वीर, आप हमारे रक्षक बनकर हमें सदैव धर्म के मार्ग पर दृढ़ रहने और मानवता की सेवा करने की दिव्य शक्ति और प्रेरणा प्रदान करें।
        """.trimIndent(),
        englishCommentary = """
            O heroic Lord Indra, just as milch cows low affectionately toward their calves, we continuously and devotedly chant your divine praises. 
            You are the unique sovereign Lord of this entire universe, governing both the moving and the non-moving entities with absolute justice. 
            Your divine and all-pervading vision extends to the highest heavens, and you are established as the true protector and controller of all realms. 
            We worship you from our hearts because you are the deity who removes the deep darkness of ignorance and fills our lives with light and truth. 
            It is only through your boundless grace that we receive the spiritual strength required to gain total mastery over our restless senses and mind. 
            Just as a cow nourishes the world with its nectar-like milk, you nourish the well-being of your devotees with the constant showers of grace. 
            Singing your glories awakens the dormant courage and heroism within us, enabling us to emerge as invincible warriors in the field of action. 
            O King of Gods, ignite such an eternal lamp of devotion in our hearts that it never flickers in the storms of ignorance and always guides us. 
            We bow before your feet with profound faith so that you may grant us spiritual peace, discernment, and material prosperity in abundance. 
            O invincible hero, stay as our guardian and graciously provide us with the divine strength to remain firm on the path of Dharma and service.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 109,
        sanskrit = "न त्वावाँ अन्यो दिव्यो न पार्थिवो न जातो न जनिष्यते ।\nअश्वयन्तो मघवन्निन्द्र वाजिनो गव्यन्तस्त्वा हवामहे ॥ १०९ ॥",
        hindiCommentary = """
            हे मघवन् इन्द्र! आपके समान शक्तिशाली और दयालु न तो कोई दिव्य लोक में है, न इस पृथ्वी पर, न कोई हुआ है और न कभी भविष्य में होगा। 
            आपकी महानता अद्वितीय और अतुलनीय है, आप समस्त ब्रह्मांडीय और सांसारिक शक्तियों के सर्वोच्च स्वामी और अजेय रक्षक के रूप में प्रतिष्ठित हैं। 
            हम शक्ति, विजय और प्रचुर संसाधनों (अश्व और गौओं) की कामना करते हुए आपको अपने इस पवित्र यज्ञ में अत्यंत आदर के साथ आमंत्रित करते हैं। 
            आप ही वह एकमात्र आदि शक्ति हैं जो हमारे जीवन में पूर्णता और प्रचुरता लाने का सामर्थ्य रखती हैं, हम पूर्ण श्रद्धा से आपकी शरण में हैं। 
            आपकी दिव्यता समस्त सीमाओं से परे है, और आप ही 'ऋत' (ब्रह्मांडीय सत्य) के मार्ग के सबसे बड़े संरक्षक और सजग दिव्य प्रहरी के रूप में जाने जाते हैं। 
            जब हम आपका हृदय की गहराई से आह्वान करते हैं, तो हमारे भीतर एक नई ऊर्जा का संचार होता है जो हमें समस्त मानसिक विकारों पर विजय दिलाती है। 
            संसार की कोई भी बाधा आपके अजेय वज्र के सामने क्षण भर भी टिक नहीं सकती, कृपया आप हमारे मार्ग के समस्त कंटकों को सदा के लिए दूर करें। 
            हमें वह प्रज्ञा और साहस प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रह सकें और अपने जीवन के श्रेष्ठ और महान लक्ष्यों को प्राप्त करें। 
            आपकी कृपा दृष्टि से हमारा संपूर्ण कल्याण और आध्यात्मिक उत्थान सुनिश्चित है, हम आपकी इस भव्य शक्ति की बार-बार हृदय से वंदना करते हैं। 
            हे इन्द्र, आप हमारे परम स्वामी और रक्षक हैं, हमें अज्ञान से ज्ञान की ओर और विनाशकारी अंधकार से शाश्वत दिव्य प्रकाश की ओर सफलतापूर्वक ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Maghavan Indra, there is none as powerful and merciful as you in the heavens, nor on earth; none has existed, nor will ever exist. 
            Your greatness is unique and incomparable; you are the supreme master and invincible guardian of all cosmic and worldly powers. 
            Desiring strength, victory, and abundant resources (Horses and Cows), we invite you to this sacred sacrifice with the highest degree of respect. 
            You are the only primordial power capable of bringing completeness and plenty into our lives; we seek your divine refuge with absolute faith. 
            Your divinity transcends all possible boundaries, and you stand as the greatest protector and sentinel of the Cosmic Law (Rta). 
            When we invoke you from the depths of our hearts, a new surge of energy flows through us, granting us victory over all mental afflictions. 
            No obstacle in this world can withstand your invincible thunderbolt; please remove all the thorns from our life's pathway forever. 
            Grant us the wisdom and courage required to always be ready for the defense of Dharma and to achieve the noble and grand goals of our life. 
            Our complete well-being and spiritual evolution are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power. 
            O Indra, you are our supreme Lord and Protector; lead us away from dark ignorance toward the eternal and radiant light of the Divine.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 110,
        sanskrit = "आ तू नः सोम पवस्व सुवीर्यं पवस्व रयिम् ।\nपवस्व मयः ॥ ११० ॥",
        hindiCommentary = """
            हे सोमदेव! आप हमारे लिए उत्तम वीरता (सुवीर्यं), श्रेष्ठ ऐश्वर्य (रयिम्) और असीम सुख (मयः) प्रदान करने के लिए पवित्र होकर प्रवाहित हों। 
            आपकी यह पावन धारा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, आरोग्यता और सामर्थ्य लाने वाली है, हम आपकी असीम कृपा की याचना करते हैं। 
            वीरता केवल युद्ध में नहीं, बल्कि जीवन की प्रतिकूलताओं में धर्म पर अडिग रहने के लिए भी परम आवश्यक है, कृपया हमें वह बल प्रदान करें। 
            हमें वह धन दें जो न्यायपूर्ण रीति से प्राप्त किया गया हो और जिसका उपयोग हम समाज के दीन-दुखियों की सेवा में अत्यंत गौरव के साथ कर सकें। 
            आपकी कृपा से प्राप्त होने वाला सुख वह आत्मिक शांति है जो बाहरी परिस्थितियों पर निर्भर नहीं करती, बल्कि हृदय के भीतर से स्वतः आती है। 
            हे देव, आप हमारे अंतःकरण को शुद्ध कर हमें वह दिव्य दृष्टि दें जिससे हम आपके ऐश्वर्य को चराचर जगत के कण-कण में देख सकें। 
            आप ही वह शक्ति हैं जो हमारे जीवन की दरिद्रता और जड़ता को समाप्त कर हमें प्रचुरता और सक्रियता के सर्वोच्च शिखर पर पहुँचाती हैं। 
            आपकी महिमा का गान करने से हमारे दुखों का नाश होता है और हमें नवीन उत्साह और अटूट जीवनी शक्ति की निरंतर प्राप्ति होती रहती है। 
            हे सोम, आप हमारे स्वामी और रक्षक के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और महान बनाने की असीम कृपा करें। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन हर दृष्टि से सार्थक, पुष्ट और पूर्णतः ईश्वरमय बना रहे।
        """.trimIndent(),
        englishCommentary = """
            O Soma, flow in your purified state to bestow upon us superior valor (Suviryam), excellent wealth (Rayim), and infinite bliss (Mayah). 
            Your holy stream brings prosperity, health, and capability into every area of our lives; we humbly seek your boundless grace and favor. 
            Valor is required not only in war but also to stay firm on the path of Dharma amidst life's adversities; please grant us that strength. 
            Provide us with that wealth which is obtained through righteous means and which we can use for the service of the needy with pride. 
            The happiness obtained by your grace is that inner peace which does not depend on external situations but arises from within the heart. 
            O God, purify our inner self and grant us the vision to perceive your divine splendor in every particle of the moving and non-moving world. 
            You are the power that terminates the poverty and lethargy of our existence and leads us to the peaks of abundance and activity. 
            Singing your glories destroys our sorrows and grants us a renewed sense of enthusiasm and vital force for our spiritual journey. 
            O Soma, always stay with us as our protector and Lord, graciously making our lives magnificent, successful, and truly renowned. 
            We offer our entire faith at your divine feet so that our lives remain meaningful, nourished, and completely God-conscious in every way.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 111,
        sanskrit = "आ नो मित्रस्य वरुणस्य प्र यंसत् ।\nसोम रयिं सुवीर्यम् ॥ १११ ॥",
        hindiCommentary = """
            हे सोमदेव! आप हमें मित्र और वरुण देव के समान अत्यंत श्रेष्ठ, पवित्र और मंगलकारी ऐश्वर्य प्रदान करने की महान कृपा करें। 
            आप हमें वह 'सुवीर्यम्' (उत्तम वीरता और आध्यात्मिक सामर्थ्य) दें जिससे हम धर्म की रक्षा और समाज का उद्धार करने में पूरी तरह सफल हों। 
            मित्र देव ब्रह्मांडीय सौहार्द के प्रतीक हैं और वरुण देव नैतिकता के रक्षक हैं, इन दोनों के महान गुण हमारे चरित्र में समाहित हों। 
            आपकी असीम कृपा से हमें वह वैभव प्राप्त हो जो पूर्णतः सत्य और न्याय के मार्ग पर चलकर अर्जित किया गया हो और जो सुखदायी हो। 
            हे देव, हमें केवल भौतिक धन ही नहीं, बल्कि वह प्रज्ञा और चरित्र भी दें जो उस धन का लोक-कल्याण में सदुपयोग करने में सहायक हो। 
            आपकी ज्योति हमारे संकल्पों को वह दृढ़ता प्रदान करे जिससे हम वीरतापूर्वक जीवन की चुनौतियों का सामना कर सकें और कभी न डगमगाएं। 
            हम आपकी निरंतर वंदना करते हैं ताकि हमारे जीवन में अनुशासन, प्रेम और दिव्यता का एक सुंदर और सफल समन्वय सदैव बना रहे। 
            आप ही वह शक्ति हैं जो हमारे कठिन परिश्रम और त्याग को महान सफलता और ईश्वरीय फल में परिवर्तित करने का सामर्थ्य रखती हैं। 
            हे सोम, हमें वह वैभव दें जो हमारे कुल की गरिमा को बढ़ाए और हमें वह आत्मिक शांति प्रदान करे जो इस संसार में अत्यंत दुर्लभ है। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम ऐश्वर्य पाकर भी अहंकारी न हों और विनम्र बने रहकर सदैव सेवा के मार्ग पर चलें।
        """.trimIndent(),
        englishCommentary = """
            O Soma, please bestow upon us that most excellent, sacred, and auspicious wealth, similar to the gifts of Mitra and Varuna. 
            Grant us 'Suviryam'—superior valor and spiritual capability—so that we may successfully protect Dharma and uplift our society. 
            Mitra represents cosmic harmony and Varuna represents morality; let the noble qualities of both reside within our character. 
            By your boundless grace, let us receive that abundance which is earned by following the path of truth and justice and which brings peace. 
            O God, do not give us just material wealth, but also the wisdom and character required to use that wealth for the welfare of all. 
            May your light provide our resolutions with the firmness needed to face life's challenges heroically without ever wavering. 
            We worship you continuously so that a beautiful balance of discipline, love, and divinity remains always present in our lives. 
            You are the power that possesses the capability to transform our hard labor and sacrifice into magnificent success and divine fruits. 
            O Soma, grant us the splendor that enhances our lineage's dignity and provides us with the inner peace that is rare in the world. 
            May your merciful gaze remain upon us so that even with abundance, we do not become arrogant but stay humble on the path of service.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 112,
        sanskrit = "पवमानो नः पावकः स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ११२ ॥",
        hindiCommentary = """
            हे पवमान और पावक (पवित्र करने वाले) सोमदेव! आप स्वर्ग की दिव्य कांति के समान अद्भुत और विविध प्रकार के ऐश्वर्यों के परम स्वामी हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह पुष्टिकारक अन्न और शक्तिशाली जीवनी शक्ति लेकर आएं जो हमारे जीवन को सफल और दिव्य बनाए। 
            आपकी कृपा से हमारे जीवन में किसी भी वस्तु का लेशमात्र भी अभाव न रहे और हम सदैव सुख, शांति और समृद्धि से पूर्णतः संपन्न बने रहें। 
            हे देव, आप हमारे अंतःकरण के समस्त अंधकार और विकारों को शुद्ध कर हमें वह दिव्य दृष्टि दें जिससे हम परमात्मा के साक्षात् दर्शन कर सकें। 
            आप ही वह महाशक्ति हैं जो हमारे जीवन की दरिद्रता और अज्ञान को समाप्त कर हमें प्रचुरता और ज्ञान के सर्वोच्च शिखर पर पहुँचाती हैं। 
            हमें वह 'इषम्' (प्रेरणा और पोषण) प्रदान करें जो हमारे शरीर और आत्मा दोनों को पूर्णतः तृप्त कर हमें दिव्यता की ओर ले जाने वाला हो। 
            आपकी महिमा का निरंतर गान करने से हमारे दुखों का नाश होता है और हमें वह नवीन उत्साह प्राप्त होता है जो हमें कभी थकने नहीं देता। 
            हे सोम, आप हमारे घर और हृदय में एक उदार दाता के रूप में पधारें और हमें वह स्थायी संपत्ति दें जो समय के साथ कभी नष्ट न हो। 
            आपकी ज्योति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और ईश्वर की ओर ले जाने वाले मार्ग का दर्शन कराए। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें अपनी दिव्य छाया में रखें और हमारा मंगलमय जीवन सदैव आपकी मर्यादा में सुरक्षित रहे।
        """.trimIndent(),
        englishCommentary = """
            O Pavamana and Purifying Soma, you are the master of magnificent and extraordinary riches that shine like celestial luster. 
            For us, your devoted chanters, bring forth that powerful nourishment and vital energy that make our lives meaningful and successful. 
            By your grace, let there be no scarcity of any kind in our lives, and may we always remain prosperous, peaceful, and abundant. 
            O God, purify our inner self of all darkness and afflictions and grant us the divine vision to perceive the Presence of the Divine. 
            You are the supreme power that terminates the poverty and ignorance of our existence and leads us to the peaks of plenty and wisdom. 
            Provide us with 'Isham'—divine inspiration and sustenance—that satisfies both our physical body and soul and leads us toward divinity. 
            Singing your glories destroys our sorrows and grants us a renewed sense of enthusiasm that ensures we never grow weary of our duty. 
            O Soma, come into our homes and hearts as the generous giver and grant us that permanent wealth which never perishes with time. 
            Let your light illuminate every dark corner of our existence and continuously show us the pathway leading toward fame, splendor, and God. 
            We pray with devotion that you keep us under your divine shadow and that our auspicious life remains forever safe within your laws.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 113,
        sanskrit = "पुनानः सोम धारया अपो वसानो अर्षसि ।\nआ रत्नधा योनिं ऋतस्य सीदसि ॥ ११३ ॥",
        hindiCommentary = """
            पवित्र किया जाता हुआ यह सोम अपनी दिव्य धारा के साथ जल रूपी वस्त्रों को धारण कर (अपो वसानो) वेगपूर्वक और पवित्रता से प्रवाहित हो रहा है। 
            रत्नों और श्रेष्ठ गुणों को धारण करने वाला यह सोम 'ऋत' (ब्रह्मांडीय सत्य) के मूल स्थान पर जाकर अत्यंत आदर के साथ विराजमान होता है। 
            सोम का जल के साथ मिलन जीवन की सृजनात्मक ऊर्जा और परम शांति के सुंदर एवं सफल समन्वय का साक्षात् आध्यात्मिक प्रतीक है। 
            जैसे सोम ऋत के स्थान पर बैठता है, वैसे ही हमारे संकल्प भी सत्य, मर्यादा और धर्म के आधार पर सदैव प्रतिष्ठित होने चाहिए। 
            हे देव, आप अपनी इस पावन यात्रा के माध्यम से हमारे अंतःकरण को शुद्ध कर उसे दैवीय आभा से पूरी तरह आलोकित और जाग्रत कर दें। 
            आपकी उपस्थिति हमारे जीवन के प्रत्येक यज्ञीय कर्म को सफल बनाती है और हमें समस्त देवताओं के आशीर्वाद का पात्र बनाती है। 
            हमें वह 'रत्न' (विवेक और प्रज्ञा) प्रदान करें जो हमारे जीवन की दिशा को अंधकार और बुराई से हटाकर प्रकाश की ओर स्थायी रूप से मोड़ दे। 
            जब हम आपकी शरण में होते हैं, तब ब्रह्मांड का परम और शाश्वत सत्य हमारे हृदय में स्वतः ही प्रकाशित होने लगता है और हम शांत हो जाते हैं। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी कृपा की धारा हमारे परिवार और समाज में सदैव सुख, शांति और दिव्य प्रकाश लाए। 
            हे पवमान सोम, आप हमारे रक्षक और शाश्वत मार्गदर्शक बनकर हमें मोक्ष और ईश्वर के परम पद तक सफलतापूर्वक पहुँचाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            The purified Soma flows with its divine stream, appearing as if clothed in waters (Apo Vasano) as it rushes forward sacredly. 
            This bestower of treasures and virtues proceeds to seat himself with great respect upon the primal source of cosmic Truth (Rta). 
            The merging of Soma with water symbolizes the beautiful harmony between the creative energy of life and profound cosmic peace. 
            Just as Soma sits at the source of Rta, may our resolutions also be established upon the foundations of Truth, morality, and Dharma. 
            O God, through this holy journey of yours, purify our inner self and illuminate it completely with your celestial radiance and awakening. 
            Your presence makes every sacrificial act of our lives successful and makes us worthy of the magnificent blessings of the celestial gods. 
            Bestow upon us those 'gems' of wisdom and discernment that shift our life's direction away from darkness and evil toward the light. 
            When we are in your refuge, the ultimate and eternal Truth of the universe begins to manifest within our hearts naturally and effortlessly. 
            We worship you with devotion so that the stream of your grace always brings happiness and peace to our families and society. 
            O Pavamana Soma, stay as our protector and eternal guide, and graciously lead us to liberation and the supreme state of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 114,
        sanskrit = "अक्षण्वन्तः कर्णवन्तः सखायो मनोजवेषु असमा बभूवुः ।\nआदध्रास उपकक्षास उ त्वे ह्रदा इव स्त्रावा दृश्यन्ते ॥ ११४ ॥",
        hindiCommentary = """
            आँख और कान वाले मित्र (सखायो) भी मन की गति और दिव्य अनुभूतियों के क्षेत्र में एक समान (**असमा**) नहीं होते हैं, यही प्रकृति का सत्य है। 
            कुछ साधक केवल बाहरी सतह तक ही पहुँच पाते हैं, जबकि कुछ गहरे **सरोवर (ह्रदा)** के समान ईश्वर के गूढ़ रहस्यों का साक्षात् दर्शन करते हैं। 
            यह मंत्र आध्यात्मिक साधना की गहराई और साधकों की विभिन्न श्रेणियों के बीच के सूक्ष्म अंतर को अत्यंत स्पष्टता के साथ प्रकट करता है। 
            केवल शारीरिक इंद्रियों का होना पर्याप्त नहीं है; वास्तविक ज्ञान वही है जो हृदय की गहराई और मन की पूर्ण एकाग्रता से प्राप्त किया जाता है। 
            हे सोम, आप हमें वह अंतर्दृष्टि प्रदान करें जिससे हम बाहरी प्रपंचों से हटकर आपके वास्तविक और दिव्य स्वरूप को सहजता से पहचान सकें। 
            जैसे सरोवर शांत होने पर ही अपना तल दिखा पाता है, वैसे ही शांत मन ही परमात्मा की छवि को ग्रहण करने और उसे धारण करने में समर्थ होता है। 
            हम आपकी निरंतर उपासना करते हैं ताकि हमारे संशय दूर हों और हम ज्ञान के उस गहरे सरोवर में डुबकी लगाकर अपनी आत्मा को तृप्त कर सकें। 
            आपकी कृपा से ही हमारे भीतर वह पात्रता विकसित होती है जिससे हम दिव्य मंत्रों और शाश्वत सत्यों के साक्षात् द्रष्टा और अनुभवी बन पाते हैं। 
            इन्द्रदेव के सखा सोम, आप हमें वह मेधा और प्रज्ञा दें जो हमें संसार के कोलाहल में भी ईश्वर की पुकार सुनने के योग्य बनाए। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन साधारण से असाधारण, तेजस्वी और पूर्णतः दिव्य बन सके।
        """.trimIndent(),
        englishCommentary = """
            Friends (Sakhayo) who possess eyes and ears are not equal (**Asama**) in their mental speed and divine realizations; this is the law of nature. 
            Some seekers only reach the shallow edges, while others, like **deep lakes (Hrada)**, perceive the profound mysteries of the Divine. 
            This mantra clarifies the depth of spiritual practice and the subtle differences between various levels of seekers and their insights. 
            Possessing physical senses is not enough; true knowledge is that which is attained through the depth of the heart and mental focus. 
            O Soma, grant us that inner vision which allows us to look beyond external illusions and recognize your true celestial nature effortlessly. 
            Just as a lake shows its bottom only when still, a calm mind is the only vessel capable of reflecting the image of the Supreme. 
            We worship you continuously so that our doubts vanish and we may dive deep into that profound lake of ultimate wisdom to satisfy the soul. 
            It is through your grace that the eligibility is developed within us to become direct seers of divine mantras and eternal truths. 
            O Soma, companion of Indra, grant us that intellect and wisdom which make us capable of hearing God's call amidst the world's noise. 
            We offer our entire faith at your feet so that our lives may transform from ordinary existence into an extraordinary and divine journey.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 115,
        sanskrit = "यस्य ते द्युमतो मदा अच्छा विचेतसा ।\nसोम अर्षसि धारया ॥ ११५ ॥",
        hindiCommentary = """
            हे सोम! आपकी वह आनंददायक और मदहोश कर देने वाली धारा, जो विशेष ज्ञान (विचेतसा) से युक्त है, हमारे कल्याण हेतु प्रवाहित होती रहे। 
            आप स्वयं प्रकाशमान (द्युमतः) हैं, और आपकी धारा हमारे जीवन के अंधकारमय मार्गों को अपनी दिव्य ज्योति से सदैव के लिए आलोकित कर देने वाली है। 
            सोम का 'मद' कोई सांसारिक नशा नहीं, बल्कि वह आध्यात्मिक आह्लाद है जो आत्मा को परमात्मा के साथ एकरूप और अत्यंत शांत कर देता है। 
            आपकी यह उच्च चेतना हमें वह शक्ति प्रदान करती है जिससे हम जीवन की जटिलताओं को समझकर सत्य का सही मार्ग चुनने में समर्थ होते हैं। 
            हे देव, आप हमारे यज्ञ में अपनी मधुर धारा के साथ पधारें और हमारे संकल्पों को दिव्यता की मिठास और दृढ़ता से पूरी तरह भर देने की कृपा करें। 
            जब आपकी अपार कृपा का प्रवाह हमारे जीवन में आता है, तो समस्त दुःख और दरिद्रता कपूर की तरह उड़कर सदा के लिए समाप्त हो जाते हैं। 
            हमें वह विशेष बोध प्रदान करें जिससे हम संसार के क्षणभंगुर आकर्षणों के प्रति अनासक्त होकर सदैव आपके प्रति समर्पित और निष्ठावान रहें। 
            आप ही वह शक्ति हैं जो हमारे शिथिल पड़ते मन को ऊर्जावान बनाती हैं और हमें निरंतर आध्यात्मिक प्रगति के पथ पर सफलतापूर्वक गतिशील रखती हैं। 
            हम श्रद्धापूर्वक आपकी महिमा का गान करते हैं ताकि आपकी उदारता का अमृत प्रवाह हमारे घर और हृदय में सदैव निरंतर और अखंड बना रहे। 
            हे दिव्य सोम, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और ज्ञानवान बनाने की महान कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Soma, may your exhilarating and intoxicating stream, combined with special wisdom (Vichetasa), flow for our welfare and peace. 
            You are self-radiant (Dyumatah), and your current is destined to illuminate the dark pathways of our existence with its eternal light. 
            The exhilaration of Soma is not a worldly intoxication but that spiritual bliss which unifies the individual soul with the Supreme Being. 
            This consciousness of yours provides us with the power to understand life's complexities and choose the path of Truth successfully. 
            O God, manifest within our sacrifice with your sweet stream and fill our resolutions with the sweetness of divine grace and love. 
            When the flow of your grace enters our life, all sufferings and poverty evaporate and terminate forever like camphor in a flame. 
            Grant us that special awareness through which we remain detached from fleeting attractions and dedicated strictly to you. 
            You are the power that energizes our lethargic minds and keeps us constantly dynamic on the pathway of continuous progress. 
            We worship you with devotion so that the flow of your immense generosity remains forever present within our homes and hearts. 
            O Divine Soma, stay with us as our protector and nourisher, and graciously make our lives magnificent, successful, and full.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 116,
        sanskrit = "पवस्व वाजसातये पवस्व परि मंहिष्ठः ।\nपवस्व मयोभुवे ॥ ११६ ॥",
        hindiCommentary = """
            हे पवमान सोम! आप विजय प्राप्त करने (**वाजसातये**) और सामर्थ्य की वृद्धि के लिए अत्यंत पवित्र होकर यहाँ निरंतर प्रवाहित होने की कृपा करें। 
            आप दानियों में सर्वश्रेष्ठ और उदार (मंहिष्ठः) हैं, कृपया अपनी धारा से हमारे जीवन को सुखकारी और पूर्णतः आनंदमय (मयोभुवे) बनाने की कृपा करें। 
            यह मंत्र संघर्ष के समय ईश्वर से प्राप्त होने वाले उस बल का आह्वान है जो मनुष्य को पराजय के भय और मानसिक दुर्बलता से पूरी तरह मुक्त करता है। 
            सोम का प्रवाह हमारे संकल्पों को वह धार देता है जिससे हम अधर्म की जटिल जंजीरों को सफलतापूर्वक और दृढ़ता के साथ काट सकते हैं। 
            आपकी उदारता केवल भौतिक धन तक सीमित नहीं है, बल्कि वह आत्मज्ञान की उस परम निधि को भी हमें सहज और सुलभ रूप से प्रदान करती है। 
            जैसे पवित्र धारा कंकड़-पत्थरों को हटाकर अपना रास्ता बनाती है, वैसे ही आप हमारे जीवन मार्ग की समस्त बाधाओं और संशयों को जड़ से दूर करें। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी कृपा का अमृत हमारे अंतःकरण को सदैव नवीन, स्वच्छ, तेजस्वी और निरंतर ऊर्जस्वित रखे। 
            आप ही वह शक्ति हैं जो हमारे कठिन पुरुषार्थ को ईश्वरीय आशीर्वाद में बदलकर हमें समाज में यशस्वी और अत्यंत सम्मानित बनाने वाली हैं। 
            हमें वह आध्यात्मिक प्यास प्रदान करें जो केवल आपके सान्निध्य रूपी अमृत से ही शांत हो सके और हमें पूर्ण शांति और आत्म-तृप्ति प्रदान करे। 
            हे सोम, आप हमारे रक्षक और गुरु बनकर हमें जीवन की सफलता और दिव्यता के सर्वोच्च एवं पवित्र शिखर पर सफलतापूर्वक पहुँचाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Pavamana Soma, flow in your purified state for the attainment of victory (**Vajasataye**) and the expansion of strength and capability. 
            You are the most liberal and generous among givers (Manhishthah); graciously make our lives comfortable and blissful with your stream. 
            This mantra is an invocation of that divine force which liberates a human being from the fear of defeat during times of struggle. 
            The flow of Soma provides our resolutions with the edge required to successfully cut through the complex chains of unrighteousness. 
            Your generosity is not limited to material wealth; it also bestows upon us the ultimate treasure of Self-realization and peace. 
            Just as a sacred stream clears pebbles to make its way, may you clear all the obstacles and doubts from our life's spiritual pathway. 
            We worship you with devotion so that the nectar of your grace keeps our inner self forever refreshed, new, and energized. 
            You are the power that transforms our hard labor into divine blessings, making us successful and respected in society. 
            Grant us that spiritual thirst which can only be quenched by the nectar of your presence, leading us to absolute satisfaction. 
            O Soma, stay as our protector and guide, leading us to the highest and most sacred peaks of life's success and divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 117,
        sanskrit = "अग्नये ब्रह्म गायत विप्राय देवहूतमये ।\nस नः पर्षत् अति द्विषः ॥ ११७ ॥",
        hindiCommentary = """
            हे स्तोताओं! आप उन अग्निदेव के लिए पवित्र वेदमंत्रों (ब्रह्म) का गान करें, जो परम विद्वान (विप्र) हैं और देवताओं का आह्वान करने वाले दिव्य दूत हैं। 
            वे अग्निदेव हमें समस्त द्वेषी शत्रुओं और भीषण संकटों (द्विषः) से पार ले जाने की असीम शक्ति और दयालुता रखने वाले सर्वोच्च देव हैं। 
            अग्नि यहाँ न केवल भौतिक ज्वाला है, बल्कि वह ज्ञान की वह प्रचंड ऊर्जा है जो हमारे भीतर के अज्ञान और नकारात्मकता को समूल जला देती है। 
            जब हम अपनी वाणी को अग्नि की स्तुति में समर्पित करते हैं, तो हमारे विचार शुद्ध होते हैं और हम आध्यात्मिक ऊँचाइयों को सहज ही प्राप्त करते हैं। 
            हे देव, आप हमारे जीवन के संघर्षों में एक शक्तिशाली रक्षक बनकर प्रकट हों और हमें अधर्म के मार्ग से हटाकर धर्म के मार्ग पर ले चलें। 
            आपकी ज्योति हमारे संकल्पों को वह दृढ़ता प्रदान करती है जिससे हम संसार के द्वंद्वों में भी विचलित नहीं होते और सदैव शांत रहते हैं। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आप ही हमारे यज्ञ को देवताओं तक पहुँचाने वाले सबसे विश्वसनीय और पवित्र दूत के रूप में प्रतिष्ठित हैं। 
            यज्ञ की अग्नि में दी गई प्रत्येक आहुति आपके माध्यम से ही सार्थक होती है और हमें वह आत्मिक बल देती है जो विजय के लिए अनिवार्य है। 
            हमें वह विवेक और प्रज्ञा प्रदान करें जिससे हम सत्य को पहचान सकें और मानवता की सेवा में अपने जीवन को पूरी तरह समर्पित कर सकें। 
            हे अग्नि, आप हमारे रक्षक और गुरु बनकर हमें जीवन की जटिलताओं से उबारें और दिव्यता के सर्वोच्च एवं पवित्र शिखर पर सफलतापूर्वक पहुँचाएँ।
        """.trimIndent(),
        englishCommentary = """
            O chanters, sing the sacred Vedic hymns (Brahma) for Lord Agni, who is the wise seer (Vipra) and the invoker of the celestial gods. 
            May Agni carry us across all malicious enemies and daunting calamities (Dwishah) through his boundless strength and mercy. 
            Agni here is not just physical fire but the energy of knowledge that burns away the internal darkness and negativity from our lives. 
            When we dedicate our voice to the praise of Agni, our thoughts become purified, and we attain higher spiritual dimensions of existence. 
            O God, manifest in our struggles as a powerful guardian and steer us away from unrighteousness toward the path of Dharma. 
            Your light provides our resolutions with that firmness through which we remain unshaken and peaceful even amidst worldly dualities. 
            We worship you with devotion because you are the most reliable and sacred messenger who carries our sacrifice to the gods. 
            Every oblation offered in the sacrificial fire becomes meaningful only through you and grants us the spiritual force essential for victory. 
            Bestow upon us the wisdom and discernment to recognize Truth and to dedicate our lives to the selfless service of entire humanity. 
            O Agni, stay as our protector and teacher, rescue us from life's complexities, and lead us to the supreme and holy peaks of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 118,
        sanskrit = "य उग्रः सवनेष्वा तविषीं अधत् सुतः ।\nस इन्द्रो वृत्रहा बभूविथ ॥ ११८ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! आप वही उग्र और प्रचंड पराक्रमी देव हैं, जिन्होंने यज्ञों (**सवनेषु**) में सोमरस के पान से असीम बल और शक्ति धारण की है। 
            आप ही वह **वृत्रहा (वृत्रासुर के संहारक)** हैं, जिन्होंने अज्ञान और जड़ता के प्रतीकात्मक शत्रुओं का नाश कर संपूर्ण जगत को प्रकाश और गति प्रदान की। 
            इन्द्र का बल सोम की शुद्धि और यज्ञ की पवित्रता पर आधारित है, जो हमें यह सिखाता है कि आध्यात्मिक शक्ति ही वास्तविक विजय का एकमात्र आधार है। 
            जब हम अपने भीतर के 'वृत्र' (काम, क्रोध और लोभ) को मारते हैं, तभी हमें इन्द्र जैसी अजेय ऊर्जा और शांति की प्राप्ति होती है। 
            हे देव, आप हमारे जीवन के युद्ध क्षेत्र में पधारें और हमारे संकल्पों को वह तेज दें कि हम बुराइयों के विरुद्ध अडिग रहकर सफलतापूर्वक खड़े हो सकें। 
            आपकी विजय ही ब्रह्मांड की व्यवस्था का आधार है, और आपकी प्रसन्नता से ही हमें वर्षा, अन्न, आरोग्य और संपन्नता का सुखद वरदान मिलता है। 
            हम अपनी मधुर वाणी और निष्कपट हृदय से आपकी निरंतर स्तुति करते हैं ताकि आप हमारे जीवन के समस्त अमंगलों को सदा के लिए जड़ से भस्म कर दें। 
            आप ही वह सर्वोच्च सत्ता हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें उन्नति के पथ पर निरंतर और सफलतापूर्वक आगे बढ़ाती हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल या असहाय नहीं रहता, क्योंकि उसे परमात्मा के प्रत्यक्ष सहयोग का दिव्य अनुभव होता है। 
            हे अजेय इन्द्र, आप हमारे परम रक्षक और गुरु बनकर हमें अज्ञान के गर्त से निकालकर दिव्यता के शाश्वत प्रकाश की ओर ले चलने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, you are that fierce and formidable deity who has assumed boundless strength by consuming Soma in the sacrificial sessions. 
            You are the Vritrahan (Slayer of Vritra), who destroyed the symbolic enemies of ignorance and stagnation to grant light and motion to the world. 
            Indra's power is rooted in the purification of Soma and the sanctity of the ritual, teaching us that spiritual strength is the true basis of victory. 
            When we slay the 'Vritra' within us (lust, anger, and greed), only then do we attain the invincible energy and peace characterized by Indra. 
            O God, manifest within the battlefield of our lives and grant our resolutions the brilliance needed to stand firm against all evils. 
            Your victory is the foundation of cosmic order, and it is through your satisfaction that we receive the blessings of rain, food, and prosperity. 
            We praise you with our sweet voices and sincere hearts so that you may completely burn away all inauspiciousness from our existence forever. 
            You are the supreme authority that makes our labor meaningful and continuously drives us forward on the path of growth and success. 
            A seeker who takes refuge in Lord Indra never remains weak or helpless, as they experience the divine support of the Almighty directly. 
            O unconquerable Indra, stay as our protector and teacher, pulling us out of the pit of ignorance toward the eternal light of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 119,
        sanskrit = "त्वामिद्धि हवामहे सातौ वाजस्य कारवः ।\nत्वां वृत्रेषु इन्द्र सत्पतिं नरस्त्वां काष्ठास्वर्वतः ॥ ११९ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! हम यज्ञ करने वाले साधक युद्ध में विजय और अजेय सामर्थ्य की प्राप्ति के लिए केवल आपको ही अत्यंत श्रद्धापूर्वक पुकारते हैं। 
            आप ही वह **'सत्पति' (सज्जनों के स्वामी)** हैं जो वृत्रासुर जैसे भयंकर और अज्ञानी शत्रुओं का नाश कर हमें धर्म की रक्षा का बल प्रदान करते हैं। 
            जीवन की कठिन परीक्षाओं और कर्मों के संग्राम में, पराक्रमी वीर योद्धा केवल आपकी ही दिव्य शक्ति और मार्गदर्शन का आह्वान करते हैं। 
            जैसे वेगवान और अनुशासित अश्व अपने लक्ष्य की ओर दौड़ते हैं, वैसे ही हमारे संकल्प आपकी कृपा से सफलता के सर्वोच्च शिखर की ओर बढ़ें। 
            आप ही वह महाशक्ति हैं जो हमारे जीवन के समस्त आंतरिक और बाह्य अवरोधों को दूर कर ज्ञान और संपन्नता के मार्ग को प्रशस्त करने वाली हैं। 
            हम पूर्ण निष्ठा के साथ आपकी शरण में आए हैं क्योंकि आपके दिव्य सहयोग के बिना वास्तविक विजय और मानसिक शांति प्राप्त करना असंभव है। 
            हे देवराज, आप अपनी अमोघ और प्रचंड शक्ति के साथ हमारे अंतःकरण में प्रदीप्त हों और हमें समस्त सांसारिक संशयों से स्थायी मुक्ति प्रदान करें। 
            आपकी प्रसन्नता से ही इस सृष्टि का चक्र व्यवस्थित रहता है और हमें वर्षा, पुष्टिकारक अन्न तथा उत्तम शारीरिक और मानसिक स्वास्थ्य प्राप्त होता है। 
            हम अपनी पवित्र और सत्यनिष्ठ वाणी से आपकी महिमा का गान करते हैं ताकि आपके सान्निध्य में हमारा जीवन सार्थक, यशस्वी और मंगलमय बने। 
            हे अजेय इन्द्र, आप हमारे परम रक्षक और गुरु बनकर हमें अज्ञान के अंधकार से निकालकर सत्य के शाश्वत प्रकाश की ओर ले चलने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, we the seekers performing the sacrifice invoke only you for obtaining victory and invincible capability in the battles of life. 
            You are the 'Satpati' (Lord of the righteous) who destroys formidable enemies like Vritra and empowers us to protect the Eternal Dharma. 
            In the trials of existence and the struggle of duties, mighty warriors call upon your divine strength and guidance for ultimate success. 
            Just as swift and disciplined horses race toward their target, may our resolutions advance toward the pinnacle of success through your grace. 
            You are the supreme power that removes all internal and external obstacles from our path and opens the gateway to wisdom and prosperity. 
            We seek your refuge with total dedication because without your divine assistance, attaining true victory and mental peace is impossible. 
            O King of Gods, ignite your infallible and fierce power within our consciousness and liberate us from all worldly doubts and anxieties. 
            Your satisfaction ensures the order of the cosmic cycle, granting us timely rain, nourishing food, and superior physical and mental health. 
            We sing your glories with our holy and truthful voices so that our lives become meaningful, successful, and auspicious in your presence. 
            O unconquerable Indra, stay as our supreme protector and teacher, and lead us from the darkness of ignorance to the eternal light of Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 120,
        sanskrit = "न त्वावाँ अन्यो दिव्यो न पार्थिवो न जातो न जनिष्यते ।\nअश्वयन्तो मघवन्निन्द्र वाजिनो गव्यन्तस्त्वा हवामहे ॥ १२० ॥",
        hindiCommentary = """
            हे मघवन् इन्द्र! आपके समान शक्तिशाली और दयालु न तो कोई दिव्य लोक में है, न इस पृथ्वी पर, न कोई हुआ है और न कभी भविष्य में होगा। 
            आपकी महानता अद्वितीय और अतुलनीय है, आप समस्त ब्रह्मांडीय और सांसारिक शक्तियों के सर्वोच्च स्वामी और अजेय रक्षक के रूप में प्रतिष्ठित हैं। 
            हम शक्ति, विजय और प्रचुर संसाधनों (अश्व और गौओं) की कामना करते हुए आपको अपने इस पवित्र यज्ञ में अत्यंत आदर के साथ आमंत्रित करते हैं। 
            आप ही वह एकमात्र आदि शक्ति हैं जो हमारे जीवन में पूर्णता और प्रचुरता लाने का सामर्थ्य रखती हैं, हम पूर्ण श्रद्धा से आपकी शरण में हैं। 
            आपकी दिव्यता समस्त सीमाओं से परे है, और आप ही 'ऋत' (ब्रह्मांडीय सत्य) के मार्ग के सबसे बड़े संरक्षक और सजग प्रहरी के रूप में जाने जाते हैं। 
            जब हम आपका हृदय की गहराई से आह्वान करते हैं, तो हमारे भीतर एक नई ऊर्जा का संचार होता है जो हमें समस्त मानसिक विकारों पर विजय दिलाती है। 
            संसार की कोई भी बाधा आपके अजेय वज्र के सामने क्षण भर भी टिक नहीं सकती, कृपया आप हमारे मार्ग के समस्त कंटकों को सदा के लिए दूर करें। 
            हमें वह प्रज्ञा और साहस प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रह सकें और अपने जीवन के श्रेष्ठ और महान लक्ष्यों को प्राप्त करें। 
            आपकी कृपा दृष्टि से हमारा संपूर्ण कल्याण और आध्यात्मिक उत्थान सुनिश्चित है, हम आपकी इस भव्य शक्ति की बार-बार हृदय से वंदना करते हैं। 
            हे इन्द्र, आप हमारे परम स्वामी और रक्षक हैं, हमें अज्ञान से ज्ञान की ओर और विनाशकारी अंधकार से शाश्वत दिव्य प्रकाश की ओर सफलतापूर्वक ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Maghavan Indra, there is none as powerful and merciful as you in the heavens, nor on earth; none has existed, nor will ever exist. 
            Your greatness is unique and incomparable; you are the supreme master and invincible guardian of all cosmic and worldly powers. 
            Desiring strength, victory, and abundant resources (Horses and Cows), we invite you to this sacred sacrifice with the highest degree of respect. 
            You are the only primordial power capable of bringing completeness and plenty into our lives; we seek your divine refuge with absolute faith. 
            Your divinity transcends all possible boundaries, and you stand as the greatest protector and sentinel of the Cosmic Law (Rta). 
            When we invoke you from the depths of our hearts, a new surge of energy flows through us, granting us victory over all mental afflictions. 
            No obstacle in this world can withstand your invincible thunderbolt; please remove all the thorns from our life's pathway forever. 
            Grant us the wisdom and courage required to always be ready for the defense of Dharma and to achieve the noble and grand goals of our life. 
            Our complete well-being and spiritual evolution are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power. 
            O Indra, you are our supreme Lord and Protector; lead us away from dark ignorance toward the eternal and radiant light of the Divine.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 121,
        sanskrit = "आ तू नः सोम पवस्व सुवीर्यं पवस्व रयिम् ।\nपवस्व मयः ॥ १२१ ॥",
        hindiCommentary = """
            हे सोमदेव! आप हमारे लिए उत्तम वीरता (सुवीर्यं), श्रेष्ठ ऐश्वर्य और असीम सुख प्रदान करने के लिए पवित्र होकर यहाँ प्रवाहित हों। 
            आपकी यह पावन धारा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, आरोग्यता और सामर्थ्य लाने वाली है, हम आपकी असीम कृपा की याचना करते हैं। 
            वीरता केवल युद्ध में नहीं, बल्कि जीवन की प्रतिकूलताओं में धर्म पर अडिग रहने के लिए भी परम आवश्यक है, कृपया हमें वह आंतरिक बल दें। 
            हमें वह धन दें जो न्यायपूर्ण रीति से प्राप्त किया गया हो और जिसका उपयोग हम समाज के कल्याण के लिए गौरव के साथ कर सकें। 
            आपकी कृपा से प्राप्त होने वाला सुख वह आत्मिक शांति है जो बाहरी परिस्थितियों पर निर्भर नहीं करती, बल्कि हृदय के भीतर से स्वतः आती है। 
            हे देव, आप हमारे अंतःकरण को शुद्ध कर हमें वह दृष्टि दें जिससे हम आपके ऐश्वर्य को चराचर जगत के कण-कण में देख सकें। 
            आप ही वह शक्ति हैं जो हमारे जीवन की दरिद्रता और जड़ता को समाप्त कर हमें प्रचुरता और सक्रियता के सर्वोच्च शिखर पर पहुँचाती हैं। 
            आपकी महिमा का गान करने से हमारे दुखों का नाश होता है और हमें नवीन उत्साह और अटूट जीवनी शक्ति की निरंतर प्राप्ति होती रहती है। 
            हे सोम, आप हमारे स्वामी और रक्षक के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और महान बनाने की असीम कृपा करें। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन हर दृष्टि से सार्थक, पुष्ट और पूर्णतः ईश्वरीय चेतना से ओत-प्रोत बना रहे।
        """.trimIndent(),
        englishCommentary = """
            O Soma, flow in your purified state to bestow upon us superior valor (Suviryam), excellent wealth, and infinite bliss. 
            Your holy stream brings prosperity, health, and capability into every area of our lives; we humbly seek your boundless grace and favor. 
            Valor is required not only in war but also to stay firm on the path of Dharma amidst life's adversities; please grant us that inner strength. 
            Provide us with that wealth which is obtained through righteous means and which we can use for the welfare of society with pride. 
            The happiness obtained by your grace is that inner peace which does not depend on external situations but arises from within the heart. 
            O God, purify our inner self and grant us the vision to perceive your divine splendor in every particle of the moving and non-moving world. 
            You are the power that terminates the poverty and lethargy of our existence and leads us to the peaks of abundance and activity. 
            Singing your glories destroys our sorrows and grants us a renewed sense of enthusiasm and vital force for our spiritual journey. 
            O Soma, always stay with us as our protector and Lord, graciously making our lives magnificent, successful, and truly renowned. 
            We offer our entire faith at your divine feet so that our lives remain meaningful, nourished, and completely filled with God-consciousness.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 122,
        sanskrit = "पुनाति ते परिस्रुतं सोमं सूर्यस्य दुहिता ।\nवारेण शश्वता तना ॥ १२२ ॥",
        hindiCommentary = """
            सूर्य की पुत्री (श्रद्धा) आपके प्रवाहित होते हुए सोमरस को निरंतर और शाश्वत रूप से पवित्र और दिव्य बनाती है। 
            यह मंत्र श्रद्धा और सोम के गहन संबंध को दर्शाता है, जहाँ श्रद्धा के बिना किसी भी दिव्य तत्व का पूर्ण लाभ प्राप्त करना असंभव है। 
            जैसे सूर्य का प्रकाश अंधकार को नष्ट करता है, वैसे ही सोम और श्रद्धा का मिलन हमारे अंतःकरण के समस्त अज्ञान को भस्म कर देता है। 
            आपकी यह पवित्रता हमें वह ऊँचाई प्रदान करती है जहाँ हम सांसारिक दुखों से ऊपर उठकर शाश्वत परमानंद का अनुभव करने लगते हैं। 
            हे सोम, आप श्रद्धा रूपी छननी से छनकर हमारे हृदय के पात्र में प्रवेश करें और हमारे संपूर्ण व्यक्तित्व को दैवीय आभा से भर दें। 
            आपकी कृपा से हमारे विचार इतने शुद्ध हों कि वे देवताओं के सान्निध्य के योग्य बन सकें और हमें उच्चतर लोकों की ओर ले जाएं। 
            हम श्रद्धापूर्वक आपकी सेवा में तत्पर रहते हैं ताकि हमारे जीवन में ज्ञान, कर्म और भक्ति का सुंदर और सफल समन्वय बना रहे। 
            जैसे सोम ऋषियों को मंत्रों का दर्शन कराता है, वैसे ही आप हमें सत्य का दर्शन कराएं और हमारे मार्ग के समस्त संशयों को दूर करें। 
            आपकी यह ऊर्जा हमारे प्राणों में चेतना बनकर बहती है, जो हमें सदैव धर्म के मार्ग पर दृढ़तापूर्वक चलने की प्रेरणा और शक्ति देती है। 
            हे दिव्य सोम, आप सूर्य की पुत्री के माध्यम से पवित्र होकर हमारे जीवन में मंगलकारी सुख और अखंड सौभाग्य का संचार करने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            The daughter of the Sun (Faith/Shraddha) purifies your flowing Soma juice continuously and eternally with her divine power. 
            This mantra illustrates the profound connection between Faith and Soma, where it is impossible to gain the full benefit of divinity without devotion. 
            Just as the light of the Sun destroys darkness, the union of Soma and Faith consumes all the ignorance hidden within our inner self. 
            Your holiness grants us that elevation where we rise above worldly sufferings and begin to experience eternal and supreme bliss. 
            O Soma, passing through the filter of Faith, enter the vessel of our hearts and fill our entire personality with a celestial aura. 
            By your grace, let our thoughts become so pure that they are worthy of the company of gods and lead us toward the higher realms. 
            We remain dedicated to your service with devotion so that a beautiful harmony of knowledge, action, and devotion stays in our lives. 
            Just as Soma enables seers to perceive sacred mantras, enable us to perceive the Truth and remove all doubts from our life's path. 
            Your energy flows through our being as consciousness, perpetually inspiring and empowering us to walk firmly on the path of Dharma. 
            O Divine Soma, being purified through the daughter of the Sun, graciously infuse our lives with auspicious happiness and unbroken good fortune.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 123,
        sanskrit = "पवस्व देव आयुष्यक् पवस्व वसुवित्तमः ।\nअग्नेः सख्ये शिवो भव ॥ १२३ ॥",
        hindiCommentary = """
            हे दिव्य सोमदेव! आप आयु को बढ़ाने वाले होकर प्रवाहित हों और हमें समस्त ऐश्वर्यों को दिलाने वाले सर्वश्रेष्ठ स्वामी बनें। 
            आप अग्निदेव के साथ परम मित्रता रखते हैं, कृपया हमारे लिए भी एक कल्याणकारी और मंगलमय मित्र बनकर प्रकट हों। 
            आपकी पावन धारा हमारे शरीर को आरोग्य और दीर्घायु प्रदान करे ताकि हम लंबी अवधि तक ईश्वर और मानवता की सेवा कर सकें। 
            अग्नि और सोम का मिलन ऊर्जा और आनंद का मिलन है, जो हमारे जीवन में शक्ति और शांति का सुंदर संतुलन स्थापित करने वाला है। 
            हे देव, आप हमारे घरों में वह प्रचुर धन और संसाधन लेकर आएं जिनका उपयोग हम धर्म और परोपकार के कार्यों में गर्व के साथ कर सकें। 
            आपकी मित्रता हमें वह अभेद्य सुरक्षा कवच प्रदान करती है जिससे हम संसार के किसी भी संकट का सामना अत्यंत धैर्य और विश्वास के साथ करते हैं। 
            हमें वह आध्यात्मिक दृष्टि दें जिससे हम आपके दिव्य स्वरूप को प्रकृति के प्रत्येक कण में महसूस कर सकें और सदैव कृतज्ञ बने रहें। 
            जैसे आप यज्ञ की अग्नि को प्रदीप्त करते हैं, वैसे ही हमारे हृदय में ज्ञान की अग्नि को प्रज्वलित कर हमें अज्ञान से मुक्त कर दें। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी उदारता का अमृत प्रवाह हमारे जीवन और परिवार में सदैव निरंतर बहता रहे। 
            हे इन्द्र के प्रिय सोम, आप हमारे रक्षक और गुरु बनकर हमें वह विवेक दें जिससे हम सत्य को पहचान कर मोक्ष के अधिकारी बन सकें।
        """.trimIndent(),
        englishCommentary = """
            O Divine Soma, flow as the one who bestows longevity and become the supreme master who grants all riches and abundance. 
            You hold a profound friendship with Lord Agni; please manifest for us also as a benevolent and auspicious friend today. 
            May your holy stream provide health and a long life to our physical bodies so that we may serve God and humanity for a long time. 
            The union of Agni and Soma is the union of energy and bliss, establishing a beautiful balance of power and peace within our daily lives. 
            O God, bring into our homes that abundant wealth and resources which we can use for the works of Dharma and altruism with pride. 
            Your friendship grants us that impenetrable security through which we face any worldly crisis with extreme patience and faith. 
            Grant us that spiritual vision which enables us to feel your divine essence in every particle of nature and remain forever grateful. 
            Just as you kindle the sacrificial fire, kindle the fire of knowledge within our hearts to liberate us from the darkness of ignorance. 
            We worship you with devotion so that the flow of your immense generosity remains forever present in our lives and families. 
            O beloved Soma of Indra, stay as our guardian and teacher, granting us the discernment to recognize Truth and attain liberation.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 124,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ १२४ ॥",
        hindiCommentary = """
            हे युवा और ऊर्जावान अग्निदेव! आप समस्त प्रकार की समृद्धियों और पुष्टियों के मूल आधार हैं, आप ही उन्हें निरंतर पोषण देते हैं। 
            जब हम बार-बार आपकी स्तुति और वंदना करते हैं, तो हमारी बुद्धि और विचार भी आकाश की तरह अत्यंत विस्तृत और श्रेष्ठ दिशा की ओर बढ़ते हैं। 
            आपकी असीम कृपा से हमारी मेधा शक्ति और प्रज्ञा प्रखर होती है और हम श्रेष्ठ कार्यों में अपनी बुद्धि का प्रयोग कर लोक-कल्याण में सफल होते हैं। 
            हे यविष्ठ्य, आपकी ऊर्जा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, पूर्णता और आत्म-संतोष लाने वाली है, हम आपकी इस शक्ति को नमन करते हैं। 
            आपकी उपासना करने से हमारे सभी नेक संकल्प सिद्ध होते हैं और हमें सर्वांगीण विकास प्राप्त होता है, यही आपकी दिव्यता की वास्तविक महिमा है। 
            जैसे अग्नि समिधा पाकर और अधिक प्रदीप्त और तेजस्वी होती है, वैसे ही हमारी आत्मा आपकी प्रेरणा और सान्निध्य से और अधिक बलवान होती है। 
            आप हमें वह मानसिक विशालता और उदारता प्रदान करें जिससे हम संकुचित स्वार्थों से ऊपर उठकर संपूर्ण विश्व के मंगल के बारे में सोच सकें। 
            हमारी चेतना को उस उच्च स्तर तक उठाएं जहाँ हम ईश्वर की सर्वव्यापकता का अनुभव कर सकें और प्रत्येक जीव में आपकी ही छवि के दर्शन कर सकें। 
            आप ही वह शक्ति हैं जो हमारे कठिन परिश्रम और ईमानदारी को ईश्वरीय आशीर्वाद में परिवर्तित करने का अद्भुत और अमोघ सामर्थ्य रखती हैं। 
            हे अग्नि, हम आपकी बार-बार वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट, समृद्ध, सार्थक और पूर्णतः धर्ममय बना रहे, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Energetic Agni, you are the foundational source of all forms of prosperity and nourishment; you sustain them with your power. 
            As we repeatedly sing your praises and worship you, our intellect and thoughts become vast like the sky, noble, and oriented toward excellence. 
            By your boundless grace, our mental power and wisdom become sharp, enabling us to use our intellect for noble deeds and global welfare. 
            O Youngest One, your energy is what brings completeness, abundance, and self-contentment into every single field of our existence and being. 
            Worshipping you ensures the fulfillment of all our noble resolutions and grants us all-around development; this is your true divine glory. 
            Just as fire blazes brighter when fueled with wood, our soul becomes stronger and more vibrant under your divine inspiration and proximity. 
            Grant us that mental expansion and generosity which allows us to rise above narrow selfishness and work for the welfare of the entire world. 
            Elevate our consciousness to that high level where we can experience the omnipresence of God and see your image in every living entity we meet. 
            You are the power that possesses the capability to transform our hard labor and honesty into divine blessings and magnificent successes. 
            O Agni, we adore you repeatedly so that our lives remain nourished, prosperous, meaningful, and completely righteous in every aspect.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 125,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ १२५ ॥",
        hindiCommentary = """
            हे पावक अग्निदेव! आप दिव्य लोकों के स्वामी और समस्त चराचर जगत के ऐश्वर्यों के परम नियंत्रक और अत्यंत उदार प्रदाता के रूप में प्रतिष्ठित हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली प्रेरणा, सात्विक अन्न और ऊर्जा लेकर आएं जो हमारे जीवन को सफल और ऊर्ध्वगामी बनाए। 
            आपकी असीम कृपा से हमारे जीवन की दरिद्रता और अभावों का नाश हो और हम केवल भौतिक धन ही नहीं, बल्कि श्रेष्ठ मानवीय गुणों के भी धनी बनें। 
            हे देव, आप हमारे अज्ञान को अपनी प्रखर ज्योति से जलाकर हमें वह सत्य मार्ग दिखाएं जहाँ केवल अखंड शांति, प्रेम और दिव्य आनंद का वास हो। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे तुच्छ और छोटे कर्मों को ईश्वरीय फल तक पहुँचाती हैं और हमारे इस मानवीय जीवन को कृतार्थ करती हैं। 
            हमें वह शक्तिशाली प्रेरणा प्रदान करें जिससे हमारे शरीर में नवीन उत्साह और मन में सदैव पवित्र और ऊँचे विचारों का अखंड प्रवाह बना रहे। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत और ईश्वर के समीप होने लगते हैं। 
            हे अग्नि, आप हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, आरोग्यता और अखंड सौभाग्य प्रदान करने की महान कृपा करने का कष्ट करें। 
            आपकी दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश, कीर्ति और आत्मज्ञान का सही मार्ग निरंतर दिखाती रहे। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें वह स्थायी संपत्ति दें जो हमारे इस लोक के साथ-साथ परलोक के मार्ग में भी परम सहायक सिद्ध हो।
        """.trimIndent(),
        englishCommentary = """
            O Purifying Agni, you are the Lord of celestial realms and the supreme controller, master, and generous provider of all worldly riches. 
            For us, your devoted chanters, bring forth that powerful inspiration, virtuous nourishment, and energy that make our lives successful and ascending. 
            By your boundless grace, let our poverty and scarcities be destroyed, making us wealthy not just with money but with superior human virtues. 
            O God, burn away our ignorance with your intense light and show us the path of truth where only unbroken peace, love, and joy reside. 
            You are the supreme power that carries our humble and small deeds to divine results and makes our human existence truly blessed and fulfilled. 
            Provide us with powerful inspiration so that fresh enthusiasm remains in our bodies and noble thoughts flow consistently in our minds. 
            Singing your glories purifies our inner self and initiates our constant spiritual awakening and proximity to the realization of the Divine. 
            O Agni, remove every lack from our lives and graciously grant us completeness, health, and unbroken auspiciousness for our families. 
            Let your radiance illuminate every dark corner of our existence and continuously show us the pathway to fame, splendor, and Self-knowledge. 
            We pray with devotion that you grant us that permanent wealth which assists us both in this world and in our journey toward the world beyond.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 126,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ १२६ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय यज्ञों और अनुष्ठानों के मुख्य पुरोहित (होता) और देवताओं को बुलाने वाले दिव्य और पवित्र माध्यम हैं। 
            आप हम मनुष्यों के बीच रहकर भी हमारा अटूट संबंध स्वर्ग के देवताओं से जोड़ते हैं, आप ही वास्तव में हमारे सबसे सच्चे और परम हितैषी हैं। 
            आपकी पावन उपस्थिति के बिना हमारा कोई भी यज्ञ, संकल्प या शुभ कर्म कभी पूर्ण नहीं हो सकता, क्योंकि आप ही यज्ञ की आत्मा और आधार हैं। 
            हे देव, आप हमारे भीतर दिव्य और सात्विक प्रवृत्तियों का विकास करें और हमें असुरत्व तथा बुराइयों के प्रभाव से सदैव सुरक्षित बचाकर रखें। 
            आपकी हितकारी दृष्टि हमें पतन और अज्ञान के मार्ग से हटाकर निरंतर प्रगति, आत्मोन्नति और अखंड शांति की दिशा में सफलतापूर्वक अग्रसर करती है। 
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे समस्त शारीरिक और मानसिक कर्मों को शुद्ध, पवित्र और कल्याणकारी बना दें। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में एकता, प्रेम, सुख और धर्मनिष्ठा के मुख्य स्तंभ और सर्वोच्च रक्षक देव हैं। 
            आपकी दिव्य ऊर्जा हमारे प्राणों में चेतना बनकर निरंतर बहती है और हमें सदैव सत्य, न्याय और मानवता के मार्ग पर चलने की प्रेरणा देती है। 
            हे अग्नि, आप हमारे सर्वोच्च गुरु और मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता का साक्षात् अनुभव कर सकें। 
            आपकी कृपा से हमारा जीवन दिव्य आशीर्वादों से भरा रहे और हम सदैव मानवता की निस्वार्थ सेवा और धर्म की रक्षा के पुनीत कार्यों में लगे रहें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest of all human rituals and the divine and holy messenger who invokes the celestial gods to the sacrifice. 
            While residing among us mortals, you connect us with the gods of heaven; you are indeed our most sincere and supreme well-wishing deity. 
            Without your sacred presence, no sacrifice, resolution, or auspicious deed of ours can ever be completed, for you are its very soul. 
            O God, develop divine and virtuous tendencies within us and always keep us safely protected from the influence of evil and demonic ways. 
            Your benevolent gaze steers us away from the path of downfall and ignorance, leading us successfully toward progress, joy, and peace. 
            Just as fire consumes and destroys all impurities, please make all our physical and mental actions pure, holy, and beneficial for the world. 
            We worship you because you are the main pillar and protector of unity, love, happiness, and religious devotion within our families and homes. 
            Your divine energy flows through our lives as consciousness, perpetually inspiring us to walk the path of Truth, Justice, and Humanity. 
            O Agni, become our supreme teacher and guide, showing us that Truth where we can successfully experience the omnipresence of the Divine. 
            By your grace, let our lives be filled with divine blessings and let us stay engaged in the holy acts of selfless service and protection of Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 127,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ १२७ ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन के समस्त द्वेष, क्रोध, अशांति और संशयों को शांत कर उसे अत्यंत निर्मल, पवित्र और शांत बना देने की कृपा करें। 
            आप हमें वह दृढ़, अटल और अडिग श्रद्धा प्रदान करें जिससे हम ईश्वर की न्यायपूर्ण व्यवस्था पर पूर्ण विश्वास कर सकें और सदैव सुखी रहें। 
            हमें उन सभी नकारात्मक शक्तियों और विचारों से सुरक्षित रखें जो हमारे मार्ग में बाधा डालती हैं और हमें धर्म के पथ से डिगाना चाहती हैं। 
            आपकी कृपा से ही मनुष्य का हृदय समस्त जीवों के प्रति निस्वार्थ प्रेम और करुणा से भर जाता है, हमें भी वही विशाल हृदय प्रदान करने का कष्ट करें। 
            हे देव, श्रद्धा ही वह दिव्य कुंजी है जिससे ईश्वर के रहस्य प्रकट होते हैं, कृपया हमारे भीतर इस श्रद्धा की ज्योति को सदैव अखंड और जीवित रखें। 
            हम ईर्ष्या की विनाशकारी आग में जलने के बजाय आपके ज्ञान के प्रकाश में तपकर स्वयं को कुंदन की तरह श्रेष्ठ, तेजस्वी और महान व्यक्तित्व वाला बनाएं। 
            जब हमारा मन आपकी भक्ति और प्रेम में डूबा होता है, तब संसार का कोई भी अभाव, दुख या पीड़ा हमें अपनी शांति से विचलित नहीं कर सकती। 
            आप ही वह शक्ति हैं जो हमारे भीतर के अंधकार को नष्ट कर हमें आत्मज्ञान और ईश्वर के समीप ले जाने वाले वास्तविक मार्ग का दर्शन कराती हैं। 
            हमें वह साहस और अभय प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रहें और निर्भीक होकर एक आदर्श और गौरवशाली जीवन व्यतीत करें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम सदैव सात्विक बने रहें और ईश्वर के अनंत आनंद और परम शांति का निरंतर अनुभव करते रहें।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please calm all the malice, anger, restlessness, and doubts of our mind, making it extremely pure, holy, and serene. 
            Graciously grant us that firm, unshakable, and steady faith which allows us to trust in the just laws of the Divine and lead a happy life. 
            Protect us from all negative forces and thoughts that place hurdles in our path and attempt to sway us from the path of Dharma. 
            It is only by your grace that a human heart fills with selfless love and compassion for all living beings; grant us such a vast heart. 
            O God, faith is the divine key that reveals the mysteries of the Divine; please keep the flame of this faith always alive and unbroken within us. 
            Instead of burning in the destructive fire of jealousy, let us be refined in the light of your wisdom like pure, radiant, and great gold. 
            When our mind is immersed in your unshakable devotion and love, no worldly scarcity, sorrow, or pain can ever disturb our inner peace. 
            You are the power that destroys our internal darkness and shows us the actual path toward Self-realization and the proximity of God. 
            Bestow upon us the courage and fearlessness required to always be ready for the protection of Dharma and to lead a bold and ideal life. 
            May your merciful gaze remain upon us so that we stay virtuous and continue to experience the infinite bliss and supreme peace of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 128,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ १२८ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त और अज्ञान के संकटों से सदैव सुरक्षित रखने की अपनी महान कृपा हम पर निरंतर बनाए रखें। 
            जो भी नकारात्मक शक्तियाँ हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके समस्त षड्यंत्रों को विफल कर हमें सुरक्षा प्रदान करें। 
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त और पवित्र ज्वालाओं से हमारे भीतर के समस्त दोषों, विकारों और बुराइयों को जड़ से जला डालें। 
            आपकी अग्नि केवल विनाश नहीं करती, बल्कि वह जीवन को एक नई दिशा, नई ऊर्जा और पूर्ण पावनता प्रदान कर मनुष्य का नया आध्यात्मिक जन्म करती है। 
            हम आपकी शरण में आकर पूर्ण सुरक्षा की याचना करते हैं क्योंकि आप ही समस्त लोकों के रक्षक, पालनहार और ब्रह्मांडीय न्याय के सर्वोच्च प्रहरी हैं। 
            हमें वह आत्मबल और साहस प्रदान करें जिससे हम कभी भी अधर्म या असत्य के मार्ग पर न चलें और सदैव आपकी दिव्य आज्ञाओं का पालन करते रहें। 
            आपकी ज्योति हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा कवच बनाए जिसे संसार की कोई भी आसुरी शक्ति या विचार कभी भी भेद न सके, यही प्रार्थना है। 
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की विजय और न्याय की स्थापना के लिए सदैव तत्पर रहती हैं, हमें भी सत्य का एक सच्चा और निष्ठावान योद्धा बनाएं। 
            जीवन के प्रत्येक संघर्ष और कठिन परीक्षा में आपकी रक्षात्मक शक्ति का अनुभव हमें अटूट साहस, मानसिक शांति और निरंतर प्रेरणा प्रदान करता है। 
            हे अग्नि, आप हमारे परम रक्षक हैं, हमें अज्ञान के अंधकार से ज्ञान के प्रकाश की ओर और मृत्यु के भय से अमरत्व के दिव्य आनंद की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously and continuously maintain your great protection over us from the terrible pit of sins and the calamities of ignorance. 
            Those negative forces that wish us harm, please foil all their conspiracies with your supreme intelligence and provide us with security. 
            O Ageless and Radiant Deity, consume all our internal flaws, mental afflictions, and evils from the root with your most intensely hot flames. 
            Your fire does not just destroy; it provides life with a new direction, new energy, and absolute purity, leading to a new spiritual birth. 
            We seek your refuge and pray for complete security, for you are the guardian of all worlds and the supreme sentinel of cosmic justice. 
            Grant us the inner strength and courage to never walk the path of unrighteousness or untruth and to always obey your divine commands. 
            Let your light create an impenetrable shield of protection around us that no demonic force or thought of the world can ever pierce through. 
            O Most Resplendent One, your flames are ever ready for the victory of Truth; please make us also true and loyal warriors of the Truth. 
            The experience of your protective power in every struggle and difficult test of life gives us unbreakable courage and deep mental peace. 
            O Agni, you are our supreme protector; lead us from the darkness of ignorance to light and from the fear of death to the bliss of immortality.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 129,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ १२९ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी उत्तम और श्रद्धापूर्ण आहुतियों को स्वीकार कर हमें उन शक्तियों से बचाएं जो हमसे ईर्ष्या या द्वेष का भाव रखती हैं। 
            आपकी दिव्य ऊर्जा हमें वह अद्भुत सामर्थ्य प्रदान करे जिससे हम जीवन की समस्त चुनौतियों और विघ्नों का निर्भीकता से सामना कर सदैव विजयी हो सकें। 
            हमें वह आंतरिक शुद्धता और मानसिक विशालता दें जिससे हमारे मन में दूसरों के प्रति कभी भी संकीर्णता, घृणा या कोई भी बुरी भावना उत्पन्न न होने पाए। 
            हे यविष्ठ्य, आपकी अक्षय और आदि शक्ति ही हमारे संपूर्ण जीवन का आधार है, हमें अपनी उस दिव्य सामर्थ्य का एक छोटा अंश प्रदान करने की महान कृपा करें। 
            यज्ञ की अग्नि में अर्पित हमारी प्रत्येक आहुति आपकी कृपा से ही सिद्ध होती है और हमें वह अभीष्ट फल प्रदान करती है जो हमारे परम मंगल के लिए हो। 
            आप हमारे जीवन को पूर्णतः सुरक्षित और समृद्ध बनाने के लिए अपनी पवित्र ज्योति का एक सुरक्षा घेरा हमारे और हमारे परिवार के चारों ओर निरंतर बनाए रखें। 
            द्वेष की भावना मनुष्य की प्रगति को रोककर उसे अंधकार में ढकेल देती है, आप हमें इस अंधकार से निकालकर सफलता, सुख और प्रकाश की ओर ले चलें। 
            आपकी मित्रता हमारे लिए वह दिव्य सुरक्षा और औषधि है जो हमारे मन के समस्त भयों, संशयों और दुखों को सदा के लिए जड़ से समाप्त कर हमें निर्भय बना देती है। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं ताकि हमारा जीवन सदैव निस्वार्थ सेवा और भक्ति में लगा रहे और हम निरंतर आत्मिक रूप से ऊँचा और श्रेष्ठ उठें। 
            हे अग्नि, हमें वह तेज और ओज दें कि हम स्वयं को धर्म में प्रतिष्ठित रख सकें और मानवता की सेवा करते हुए एक गौरवशाली और सार्थक जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our best and devoted offerings, protect us from those forces that harbor envy or malice toward our well-being. 
            May your divine energy provide us with that amazing capability to face all of life's challenges and hurdles with absolute fearlessness and victory. 
            Grant us that internal purity and mental vastness which ensures that no narrowness, hatred, or ill-will ever arises in our minds toward others. 
            O Youngest One, your inexhaustible and primordial power is the foundation of our entire existence; grant us a portion of your divine strength. 
            Every oblation offered in the sacrificial fire is fulfilled by your grace and leads us to the achievement of goals meant for our ultimate welfare. 
            Create a continuous circle of your sacred and holy light around us and our families to make our lives completely secure and prosperous. 
            The feeling of malice halts a person's progress and pushes them into darkness; lead us out of this darkness and toward the path of success and light. 
            Your friendship is that divine security and medicine for us which uproots all the fears, doubts, and sorrows of our wandering mind forever. 
            We pray to you with devotion so that our life remains dedicated to selfless service and devotion, helping us to rise spiritually and morally higher. 
            O Agni, give us the luster and vigor to keep ourselves established in Dharma and to lead a glorious life while serving entire humanity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 130,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ १३० ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य (विवस्वान) के समान तेजस्वी, प्रचंड और जीवनदायी ऐश्वर्य हमारे घर, परिवार और हृदय में लेकर आने की महान कृपा करने का कष्ट करें। 
            आप हमें वह जीवनी शक्ति, ऊर्जा और आरोग्य प्रदान करें जिससे हम लंबी आयु तक स्वस्थ और क्रियाशील रहकर श्रेष्ठ धर्म, ज्ञान और मानवता के कर्म कर सकें। 
            आप स्वर्ग के अनुपम वैभव और समस्त ब्रह्मांडीय धन के सर्वोच्च अधिपति हैं, हमें वह सुख प्रदान करें जो अविनाशी हो और जो हमें अखंड आत्मिक शांति दे। 
            हे पावक, आपकी पवित्रता हमारे रोम-रोम में समा जाए और हमें पूर्णतः निर्मल, कांतिवान और आध्यात्मिक ऊर्जा से ओत-प्रोत बना देने की असीम कृपा करे। 
            आपकी कृपा से हमारे जीवन में किसी भी संसाधन, सुख-सुविधा या अन्न की कमी न रहे और हम सदैव दूसरों की सहायता और सेवा करने के लिए पूर्णतः समर्थ रहें। 
            आप केवल बाहरी धन ही नहीं, बल्कि वह प्रज्ञा, विवेक और उच्चतर ज्ञान भी प्रदान करते हैं जो हमें मोक्ष और परम सत्य के साक्षात्कार के मार्ग पर ले जाता है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा जीवन सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम सदैव आपकी दिव्य शरण में रहें। 
            हे देव, आप हमारे दुखों की काली छाया को सदा के लिए समाप्त कर हमारे जीवन में हर्ष, आनंद और नवीन उत्साह का दिव्य अमृत निरंतर घोलते रहने की कृपा करें। 
            आपकी दीप्ति हमारे अज्ञान के पर्दों को हटाकर हमें वह स्पष्टता प्रदान करे जिससे हम ईश्वर की अनंत सत्ता को पहचान सकें और सदैव आंतरिक रूप से शांत रह सकें। 
            हे अग्नि, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी, धर्मनिष्ठ और आध्यात्मिक रूप से पूर्ण बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our homes, families, and hearts a splendor and prosperity as brilliant, fierce, and life-giving as the Sun itself. 
            Provide us with the vital energy and health that allow us to stay healthy and active for a long life to perform noble deeds and serve knowledge. 
            You are the sovereign lord of the unique abundance of heaven and all cosmic wealth; grant us that joy which is imperishable and peaceful. 
            O Purifier, let your holiness permeate every cell of our being, making us completely pure, radiant, and overflowing with spiritual energy. 
            By your grace, let there be no lack of resources or food in our lives, ensuring we are always capable of serving and assisting others in need. 
            You do not just provide external wealth; you also grant that wisdom, discernment, and higher knowledge which lead us toward Truth and liberation. 
            We constantly sing your glories so that our life remains forever illuminated with the light of devotion and knowledge under your divine care. 
            O God, eliminate the dark shadows of our sorrows forever and infuse our lives with the nectar of divine joy, bliss, and renewed enthusiasm. 
            Let your radiance erase the veils of our ignorance and grant us that clarity which enables us to recognize the infinite Reality of the Divine. 
            O Agni, always remain with us as our protector and nourisher, making our lives magnificent, successful, and spiritually complete.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 131,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ १३१ ॥",
        hindiCommentary = """
            हे युवा और ऊर्जावान अग्निदेव! आप समस्त प्रकार की समृद्धियों और पुष्टियों के मूल आधार हैं, आप ही उन्हें अपनी दिव्य शक्ति से निरंतर पोषण और बल देते हैं। 
            जब हम बार-बार आपकी स्तुति और वंदना करते हैं, तो हमारी बुद्धि और विचार भी आकाश की तरह अत्यंत विस्तृत, उदार, तेजस्वी और श्रेष्ठ दिशा की ओर बढ़ने लगते हैं। 
            आपकी असीम कृपा से हमारी मेधा शक्ति और प्रज्ञा प्रखर होती है और हम श्रेष्ठ कार्यों में अपनी बुद्धि का प्रयोग कर लोक-कल्याण के पुनीत कार्यों में सफल होते हैं। 
            हे यविष्ठ्य, आपकी ऊर्जा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, पूर्णता, आरोग्यता और आत्म-संतोष लाने वाली है, हम आपकी इस विराट शक्ति को नमन करते हैं। 
            आपकी उपासना करने से हमारे सभी नेक संकल्प सिद्ध होते हैं और हमें सर्वांगीण विकास प्राप्त होता है, यही आपकी दिव्यता की वास्तविक और महान महिमा है। 
            जैसे अग्नि समिधा पाकर और अधिक प्रदीप्त और तेजस्वी होती है, वैसे ही हमारी आत्मा आपकी प्रेरणा और सान्निध्य से और अधिक बलवान, पवित्र और ओजस्वी होती है। 
            आप हमें वह मानसिक विशालता और उदारता प्रदान करें जिससे हम संकुचित स्वार्थों से ऊपर उठकर संपूर्ण विश्व के मंगल और कल्याण के बारे में सदैव सोच सकें। 
            हमारी चेतना को उस उच्च स्तर तक उठाएं जहाँ हम ईश्वर की सर्वव्यापकता का अनुभव कर सकें और प्रत्येक जीव में आपकी ही छवि के साक्षात् दर्शन कर सकें। 
            आप ही वह शक्ति हैं जो हमारे कठिन परिश्रम और ईमानदारी को ईश्वरीय आशीर्वाद में परिवर्तित करने का अद्भुत, अमोघ और तात्कालिक सामर्थ्य रखती हैं। 
            हे अग्नि, हम आपकी बार-बार वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट, समृद्ध, सार्थक, यशस्वी और पूर्णतः धर्ममय बना रहे, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Energetic Agni, you are the foundational source of all forms of prosperity and nourishment; you sustain them with your infinite power. 
            As we repeatedly sing your praises and worship you, our intellect and thoughts become vast like the sky, noble, and oriented toward excellence. 
            By your boundless grace, our mental power and wisdom become sharp, enabling us to use our intellect for noble deeds and global welfare. 
            O Youngest One, your energy is what brings completeness, abundance, and self-contentment into every single field of our existence and spiritual being. 
            Worshipping you ensures the fulfillment of all our noble resolutions and grants us all-around development; this is your true and magnificent divine glory. 
            Just as fire blazes brighter when fueled with wood, our soul becomes stronger and more vibrant under your divine inspiration and proximity. 
            Grant us that mental expansion and generosity which allows us to rise above narrow selfishness and work for the welfare of the entire world. 
            Elevate our consciousness to that high level where we can experience the omnipresence of God and see your image in every living entity we meet. 
            You are the power that possesses the capability to transform our hard labor and honesty into divine blessings and magnificent successes. 
            O Agni, we adore you repeatedly so that our lives remain nourished, prosperous, meaningful, and completely righteous in every aspect.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 132,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ १३२ ॥",
        hindiCommentary = """
            हे पावक अग्निदेव! आप दिव्य लोकों के स्वामी और समस्त चराचर जगत के ऐश्वर्यों के परम नियंत्रक, अधिपति और अत्यंत उदार प्रदाता के रूप में प्रतिष्ठित हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली प्रेरणा, सात्विक अन्न, स्वास्थ्य और ऊर्जा लेकर आएं जो हमारे जीवन को सफल और ऊर्ध्वगामी बनाए। 
            आपकी असीम कृपा से हमारे जीवन की दरिद्रता और अभावों का नाश हो और हम केवल भौतिक धन ही नहीं, बल्कि श्रेष्ठ मानवीय और दैवीय गुणों के भी धनी बनें। 
            हे देव, आप हमारे अज्ञान को अपनी प्रखर ज्योति से जलाकर हमें वह सत्य मार्ग दिखाएं जहाँ केवल अखंड शांति, निस्वार्थ प्रेम और दिव्य आनंद का वास हो। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे तुच्छ और छोटे कर्मों को ईश्वरीय फल तक पहुँचाती हैं और हमारे इस मानवीय जीवन को कृतार्थ और सार्थक करती हैं। 
            हमें वह शक्तिशाली प्रेरणा प्रदान करें जिससे हमारे शरीर में नवीन उत्साह और मन में सदैव पवित्र और ऊँचे विचारों का अखंड प्रवाह बना रहे। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत और ईश्वर के सान्निध्य के समीप होने लगते हैं। 
            हे अग्नि, आप हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, आरोग्यता और अखंड सौभाग्य प्रदान करने की महान कृपा करने का कष्ट करें। 
            आपकी दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश, कीर्ति और आत्मज्ञान का सही मार्ग निरंतर और सफलतापूर्वक दिखाती रहे। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें वह स्थायी संपत्ति दें जो हमारे इस लोक के साथ-साथ परलोक के मार्ग में भी परम सहायक और सुखद सिद्ध हो।
        """.trimIndent(),
        englishCommentary = """
            O Purifying Agni, you are the Lord of celestial realms and the supreme controller, master, and generous provider of all worldly riches and wealth. 
            For us, your devoted chanters, bring forth that powerful inspiration, virtuous nourishment, and energy that make our lives successful and ascending. 
            By your boundless grace, let our poverty and scarcities be destroyed, making us wealthy not just with money but with superior divine virtues. 
            O God, burn away our ignorance with your intense light and show us the path of truth where only unbroken peace, love, and joy reside. 
            You are the supreme power that carries our humble and small deeds to divine results and makes our human existence truly blessed and fulfilled. 
            Provide us with powerful inspiration so that fresh enthusiasm remains in our bodies and noble thoughts flow consistently in our minds. 
            Singing your glories purifies our inner self and initiates our constant spiritual awakening and proximity to the realization of the Divine. 
            O Agni, remove every lack from our lives and graciously grant us completeness, health, and unbroken auspiciousness for our families and homes. 
            Let your radiance illuminate every dark corner of our existence and continuously show us the pathway to fame, splendor, and Self-knowledge. 
            We pray with devotion that you grant us that permanent wealth which assists us both in this world and in our spiritual journey beyond.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 133,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ १३३ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय यज्ञों, संकल्पों और अनुष्ठानों के मुख्य पुरोहित (होता) और देवताओं को आह्वान करने वाले दिव्य और पवित्र दूत हैं। 
            आप हम मनुष्यों के बीच रहकर भी हमारा अटूट संबंध स्वर्ग के देवताओं से जोड़ते हैं, आप ही वास्तव में हमारे सबसे सच्चे और परम हितैषी रक्षक देव हैं। 
            आपकी पावन उपस्थिति के बिना हमारा कोई भी यज्ञ, संकल्प या शुभ कर्म कभी पूर्ण नहीं हो सकता, क्योंकि आप ही यज्ञ की आत्मा, आधार और केंद्र हैं। 
            हे देव, आप हमारे भीतर दिव्य और सात्विक प्रवृत्तियों का विकास करें और हमें असुरत्व तथा बुराइयों के प्रभाव से सदैव सुरक्षित बचाकर रखने की कृपा करें। 
            आपकी हितकारी दृष्टि हमें पतन और अज्ञान के मार्ग से हटाकर निरंतर प्रगति, आत्मोन्नति, सुख और अखंड शांति की दिशा में सफलतापूर्वक अग्रसर करती है। 
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे समस्त शारीरिक और मानसिक कर्मों को शुद्ध, पवित्र, कल्याणकारी और फलदायी बना दें। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में एकता, प्रेम, सुख-शांति और धार्मिक निष्ठा के मुख्य स्तंभ और सर्वोच्च रक्षक देव के रूप में प्रतिष्ठित हैं। 
            आपकी दिव्य ऊर्जा हमारे प्राणों में चेतना बनकर निरंतर बहती है और हमें सदैव सत्य, न्याय और निस्वार्थ मानवता के मार्ग पर चलने की प्रेरणा प्रदान करती है। 
            हे अग्नि, आप हमारे सर्वोच्च गुरु और मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता का साक्षात् अनुभव करने में पूरी तरह सफल हों। 
            आपकी कृपा से हमारा जीवन दिव्य आशीर्वादों से भरा रहे और हम सदैव मानवता की निस्वार्थ सेवा और धर्म की रक्षा के पुनीत कार्यों में तन्मयता से लगे रहें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest (Hotar) of all human rituals and the divine and holy messenger who invokes the celestial gods to the sacrifice. 
            While residing among us mortals, you connect us with the gods of heaven; you are indeed our most sincere and supreme well-wishing deity. 
            Without your sacred presence, no sacrifice, resolution, or auspicious deed of ours can ever be completed, for you are its very soul and base. 
            O God, develop divine and virtuous tendencies within us and always keep us safely protected from the influence of evil and demonic ways. 
            Your benevolent gaze steers us away from the path of downfall and ignorance, leading us successfully toward progress, joy, and peace. 
            Just as fire consumes and destroys all impurities, please make all our physical and mental actions pure, holy, and beneficial for the world. 
            We worship you because you are the main pillar and protector of unity, love, happiness, and religious devotion within our families and homes. 
            Your divine energy flows through our lives as consciousness, perpetually inspiring us to walk the path of Truth, Justice, and Humanity. 
            O Agni, become our supreme teacher and guide, showing us that Truth where we can successfully experience the omnipresence of the Divine. 
            By your grace, let our lives be filled with divine blessings and let us stay engaged in the holy acts of selfless service and protection of Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 134,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ १३४ ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन के समस्त द्वेष, क्रोध, अशांति और संशयों को शांत कर उसे अत्यंत निर्मल, पवित्र और शांत बना देने की महान कृपा करें। 
            आप हमें वह दृढ़, अटल और अडिग श्रद्धा प्रदान करें जिससे हम ईश्वर की न्यायपूर्ण व्यवस्था पर पूर्ण विश्वास कर सकें और सदैव एक सुखमय जीवन जिएं। 
            हमें उन सभी नकारात्मक शक्तियों और विचारों से सुरक्षित रखें जो हमारे मार्ग में बाधा डालती हैं और हमें धर्म के पथ से डिगाना और विचलित करना चाहती हैं। 
            आपकी कृपा से ही मनुष्य का हृदय समस्त जीवों के प्रति निस्वार्थ प्रेम और करुणा से भर जाता है, हमें भी वही विशाल और दयालु हृदय प्रदान करने का कष्ट करें। 
            हे देव, श्रद्धा ही वह दिव्य कुंजी है जिससे ईश्वर के रहस्य प्रकट होते हैं, कृपया हमारे भीतर इस श्रद्धा की ज्योति को सदैव अखंड और जीवित बनाए रखें। 
            हम ईर्ष्या की विनाशकारी आग में जलने के बजाय आपके ज्ञान के प्रकाश में तपकर स्वयं को कुंदन की तरह श्रेष्ठ, तेजस्वी और महान व्यक्तित्व वाला बनाएं। 
            जब हमारा मन आपकी अटूट भक्ति और प्रेम में डूबा होता है, तब संसार का कोई भी अभाव, दुख या पीड़ा हमें अपनी मानसिक शांति से विचलित नहीं कर सकती। 
            आप ही वह शक्ति हैं जो हमारे भीतर के अंधकार को नष्ट कर हमें आत्मज्ञान और ईश्वर के समीप ले जाने वाले वास्तविक मार्ग का साक्षात् दर्शन कराती हैं। 
            हमें वह साहस और अभय प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रहें और निर्भीक होकर एक आदर्श और गौरवशाली मानवीय जीवन व्यतीत करें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम सदैव सात्विक बने रहें और ईश्वर के अनंत आनंद और परम शांति का निरंतर अपने हृदय में अनुभव करते रहें।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please calm all the malice, anger, restlessness, and doubts of our mind, making it extremely pure, holy, and serene. 
            Graciously grant us that firm, unshakable, and steady faith which allows us to trust in the just laws of the Divine and lead a happy life. 
            Protect us from all negative forces and thoughts that place hurdles in our path and attempt to sway us from the path of Dharma. 
            It is only by your grace that a human heart fills with selfless love and compassion for all living beings; grant us such a vast heart. 
            O God, faith is the divine key that reveals the mysteries of the Divine; please keep the flame of this faith always alive and unbroken within us. 
            Instead of burning in the fire of jealousy, let us be refined in the light of your wisdom like pure, radiant, and great gold. 
            When our mind is immersed in your unshakable devotion and love, no worldly scarcity, sorrow, or pain can ever disturb our inner peace. 
            You are the power that destroys our internal darkness and shows us the actual path toward Self-realization and the proximity of God. 
            Bestow upon us the courage and fearlessness required to always be ready for the protection of Dharma and to lead a bold and ideal life. 
            May your merciful gaze remain upon us so that we stay virtuous and continue to experience the infinite bliss and supreme peace of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 135,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ १३५ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त, अज्ञान के संकटों और अधर्म के प्रलोभनों से सदैव सुरक्षित रखने की अपनी असीम और महान कृपा हम पर निरंतर बनाए रखें। 
            जो भी नकारात्मक शक्तियाँ या शत्रु हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके समस्त षड्यंत्रों को विफल कर हमें पूर्ण सुरक्षा प्रदान करें। 
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त, पवित्र और प्रखर ज्वालाओं से हमारे भीतर के समस्त दोषों, विकारों और बुराइयों को जड़ से जला डालें। 
            आपकी अग्नि केवल विनाश नहीं करती, बल्कि वह जीवन को एक नई दिशा, नई ऊर्जा और पूर्ण पावनता प्रदान कर मनुष्य का नया आध्यात्मिक जन्म संपन्न करती है। 
            हम आपकी शरण में आकर पूर्ण सुरक्षा की याचना करते हैं क्योंकि आप ही समस्त लोकों के रक्षक, पालनहार और ब्रह्मांडीय न्याय के सर्वोच्च दिव्य प्रहरी हैं। 
            हमें वह आत्मबल और साहस प्रदान करें जिससे हम कभी भी अधर्म या असत्य के मार्ग पर न चलें और सदैव आपकी दिव्य आज्ञाओं का पालन करते रहें। 
            आपकी ज्योति हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा कवच बनाए जिसे संसार की कोई भी आसुरी शक्ति या नकारात्मक विचार कभी भी भेद न सके, यही प्रार्थना है। 
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की विजय और न्याय की स्थापना के लिए सदैव तत्पर रहती हैं, हमें भी सत्य का एक सच्चा और निष्ठावान योद्धा बनाएं। 
            जीवन के प्रत्येक संघर्ष और कठिन परीक्षा में आपकी रक्षात्मक शक्ति का अनुभव हमें अटूट साहस, मानसिक शांति, धैर्य और निरंतर प्रेरणा प्रदान करता है। 
            हे अग्नि, आप हमारे परम रक्षक हैं, हमें अज्ञान के अंधकार से ज्ञान के प्रकाश की ओर और मृत्यु के भय से अमरत्व के दिव्य आनंद की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously and continuously maintain your great protection over us from the terrible pit of sins and the calamities of ignorance. 
            Those negative forces or enemies that wish us harm, please foil all their conspiracies with your supreme intelligence and provide us with security. 
            O Ageless and Radiant Deity, consume all our internal flaws, mental afflictions, and evils from the root with your most intensely hot flames. 
            Your fire does not just destroy; it provides life with a new direction, fresh energy, and absolute purity, leading to a new spiritual birth. 
            We seek your refuge and pray for complete security, for you are the guardian of all worlds and the supreme sentinel of cosmic justice. 
            Grant us the inner strength and courage to never walk the path of unrighteousness or untruth and to always obey your divine commands. 
            Let your light create an impenetrable shield of protection around us that no demonic force or negative thought of the world can ever pierce through. 
            O Most Resplendent One, your flames are ever ready for the victory of Truth; please make us also true and loyal warriors of the Truth. 
            The experience of your protective power in every struggle and difficult test of life gives us unbreakable courage, mental peace, and patience. 
            O Agni, you are our supreme protector; lead us from the darkness of ignorance to light and from the fear of death to the bliss of immortality.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 136,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ १३६ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी उत्तम और श्रद्धापूर्ण आहुतियों को स्वीकार कर हमें उन शक्तियों से बचाएं जो हमसे ईर्ष्या या द्वेष का भाव रखती हैं। 
            आपकी दिव्य ऊर्जा हमें वह अद्भुत सामर्थ्य प्रदान करे जिससे हम जीवन की समस्त चुनौतियों और विघ्नों का निर्भीकता से सामना कर सदैव विजयी हो सकें। 
            हमें वह आंतरिक शुद्धता और मानसिक विशालता दें जिससे हमारे मन में दूसरों के प्रति कभी भी संकीर्णता, घृणा या कोई भी बुरी भावना उत्पन्न न होने पाए। 
            हे यविष्ठ्य, आपकी अक्षय और आदि शक्ति ही हमारे संपूर्ण जीवन का आधार है, हमें अपनी उस दिव्य सामर्थ्य का एक छोटा अंश प्रदान करने की महान कृपा करें। 
            यज्ञ की अग्नि में अर्पित हमारी प्रत्येक आहुति आपकी कृपा से ही सिद्ध होती है और हमें वह अभीष्ट फल प्रदान करती है जो हमारे परम मंगल के लिए हो। 
            आप हमारे जीवन को पूर्णतः सुरक्षित और समृद्ध बनाने के लिए अपनी पवित्र ज्योति का एक सुरक्षा घेरा हमारे और हमारे परिवार के चारों ओर निरंतर बनाए रखें। 
            द्वेष की भावना मनुष्य की प्रगति को रोककर उसे अंधकार में ढकेल देती है, आप हमें इस अंधकार से निकालकर सफलता, सुख और प्रकाश की ओर ले चलें। 
            आपकी मित्रता हमारे लिए वह दिव्य सुरक्षा और औषधि है जो हमारे मन के समस्त भयों, संशयों और दुखों को सदा के लिए जड़ से समाप्त कर हमें निर्भय बना देती है। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं ताकि हमारा जीवन सदैव निस्वार्थ सेवा और भक्ति में लगा रहे और हम निरंतर आत्मिक रूप से ऊँचा और श्रेष्ठ उठें। 
            हे अग्नि, हमें वह तेज और ओज दें कि हम स्वयं को धर्म में प्रतिष्ठित रख सकें और मानवता की सेवा करते हुए एक गौरवशाली और सार्थक जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our best and devoted offerings, protect us from those forces that harbor envy or malice toward our well-being. 
            May your divine energy provide us with that amazing capability to face all of life's challenges and hurdles with absolute fearlessness and victory. 
            Grant us that internal purity and mental vastness which ensures that no narrowness, hatred, or ill-will ever arises in our minds toward others. 
            O Youngest One, your inexhaustible and primordial power is the foundation of our entire existence; grant us a portion of your divine strength. 
            Every oblation offered in the sacrificial fire is fulfilled by your grace and leads us to the achievement of goals meant for our ultimate welfare. 
            Create a continuous circle of your sacred and holy light around us and our families to make our lives completely secure and prosperous. 
            The feeling of malice halts a person's progress and pushes them into darkness; lead us out of this darkness and toward the path of success and light. 
            Your friendship is that divine security and medicine for us which uproots all the fears, doubts, and sorrows of our wandering mind forever. 
            We pray to you with devotion so that our life remains dedicated to selfless service and devotion, helping us to rise spiritually and morally higher. 
            O Agni, give us the luster and vigor to keep ourselves established in Dharma and to lead a glorious life while serving entire humanity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 137,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ १३७ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य (विवस्वान) के समान तेजस्वी, प्रचंड और जीवनदायी ऐश्वर्य हमारे घर, परिवार और हृदय में लेकर आने की महान कृपा करने का कष्ट करें। 
            आप हमें वह जीवनी शक्ति, ऊर्जा और आरोग्य प्रदान करें जिससे हम लंबी आयु तक स्वस्थ और क्रियाशील रहकर श्रेष्ठ धर्म, ज्ञान और मानवता के कर्म कर सकें। 
            आप स्वर्ग के अनुपम वैभव और समस्त ब्रह्मांडीय धन के सर्वोच्च अधिपति हैं, हमें वह सुख प्रदान करें जो अविनाशी हो और जो हमें अखंड आत्मिक शांति दे। 
            हे पावक, आपकी पवित्रता हमारे रोम-रोम में समा जाए और हमें पूर्णतः निर्मल, कांतिवान और आध्यात्मिक ऊर्जा से ओत-प्रोत बना देने की असीम कृपा करे। 
            आपकी कृपा से हमारे जीवन में किसी भी संसाधन, सुख-सुविधा या अन्न की कमी न रहे और हम सदैव दूसरों की सहायता और सेवा करने के लिए पूर्णतः समर्थ रहें। 
            आप केवल बाहरी धन ही नहीं, बल्कि वह प्रज्ञा, विवेक और उच्चतर ज्ञान भी प्रदान करते हैं जो हमें मोक्ष और परम सत्य के साक्षात्कार के मार्ग पर ले जाता है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा जीवन सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम सदैव आपकी दिव्य शरण में रहें। 
            हे देव, आप हमारे दुखों की काली छाया को सदा के लिए समाप्त कर हमारे जीवन में हर्ष, आनंद और नवीन उत्साह का दिव्य अमृत निरंतर घोलते रहने की कृपा करें। 
            आपकी दीप्ति हमारे अज्ञान के पर्दों को हटाकर हमें वह स्पष्टता प्रदान करे जिससे हम ईश्वर की अनंत सत्ता को पहचान सकें और सदैव आंतरिक रूप से शांत रह सकें। 
            हे अग्नि, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी, धर्मनिष्ठ और आध्यात्मिक रूप से पूर्ण बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our homes, families, and hearts a splendor and prosperity as brilliant, fierce, and life-giving as the Sun itself. 
            Provide us with the vital energy and health that allow us to stay healthy and active for a long life to perform noble deeds and serve knowledge. 
            You are the sovereign lord of the unique abundance of heaven and all cosmic wealth; grant us that joy which is imperishable and peaceful. 
            O Purifier, let your holiness permeate every cell of our being, making us completely pure, radiant, and overflowing with spiritual energy. 
            By your grace, let there be no lack of resources or food in our lives, ensuring we are always capable of serving and assisting others in need. 
            You do not just provide external wealth; you also grant that wisdom, discernment, and higher knowledge which lead us toward Truth and liberation. 
            We constantly sing your glories so that our life remains forever illuminated with the light of devotion and knowledge under your divine care. 
            O God, eliminate the dark shadows of our sorrows forever and infuse our lives with the nectar of divine joy, bliss, and renewed enthusiasm. 
            Let your radiance erase the veils of our ignorance and grant us that clarity which enables us to recognize the infinite Reality of the Divine. 
            O Agni, always remain with us as our protector and nourisher, making our lives magnificent, successful, and spiritually complete.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 138,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ १३८ ॥",
        hindiCommentary = """
            हे युवा और ऊर्जावान अग्निदेव! आप समस्त प्रकार की समृद्धियों और पुष्टियों के मूल आधार हैं, आप ही उन्हें अपनी दिव्य शक्ति से निरंतर पोषण और बल देते हैं। 
            जब हम बार-बार आपकी स्तुति और वंदना करते हैं, तो हमारी बुद्धि और विचार भी आकाश की तरह अत्यंत विस्तृत, उदार, तेजस्वी और श्रेष्ठ दिशा की ओर बढ़ने लगते हैं। 
            आपकी असीम कृपा से हमारी मेधा शक्ति और प्रज्ञा प्रखर होती है और हम श्रेष्ठ कार्यों में अपनी बुद्धि का प्रयोग कर लोक-कल्याण के पुनीत कार्यों में सफल होते हैं। 
            हे यविष्ठ्य, आपकी ऊर्जा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, पूर्णता, आरोग्यता और आत्म-संतोष लाने वाली है, हम आपकी इस विराट शक्ति को नमन करते हैं। 
            आपकी उपासना करने से हमारे सभी नेक संकल्प सिद्ध होते हैं और हमें सर्वांगीण विकास प्राप्त होता है, यही आपकी दिव्यता की वास्तविक और महान महिमा है। 
            जैसे अग्नि समिधा पाकर और अधिक प्रदीप्त और तेजस्वी होती है, वैसे ही हमारी आत्मा आपकी प्रेरणा और सान्निध्य से और अधिक बलवान, पवित्र और ओजस्वी होती है। 
            आप हमें वह मानसिक विशालता और उदारता प्रदान करें जिससे हम संकुचित स्वार्थों से ऊपर उठकर संपूर्ण विश्व के मंगल और कल्याण के बारे में सदैव सोच सकें। 
            हमारी चेतना को उस उच्च स्तर तक उठाएं जहाँ हम ईश्वर की सर्वव्यापकता का अनुभव कर सकें और प्रत्येक जीव में आपकी ही छवि के साक्षात् दर्शन कर सकें। 
            आप ही वह शक्ति हैं जो हमारे कठिन परिश्रम और ईमानदारी को ईश्वरीय आशीर्वाद में परिवर्तित करने का अद्भुत, अमोघ और तात्कालिक सामर्थ्य रखती हैं। 
            हे अग्नि, हम आपकी बार-बार वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट, समृद्ध, सार्थक, यशस्वी और पूर्णतः धर्ममय बना रहे, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Energetic Agni, you are the foundational source of all forms of prosperity and nourishment; you sustain them with your infinite power. 
            As we repeatedly sing your praises and worship you, our intellect and thoughts become vast like the sky, noble, and oriented toward excellence. 
            By your boundless grace, our mental power and wisdom become sharp, enabling us to use our intellect for noble deeds and global welfare. 
            O Youngest One, your energy is what brings completeness, abundance, and self-contentment into every single field of our existence and spiritual being. 
            Worshipping you ensures the fulfillment of all our noble resolutions and grants us all-around development; this is your true and magnificent divine glory. 
            Just as fire blazes brighter when fueled with wood, our soul becomes stronger and more vibrant under your divine inspiration and proximity. 
            Grant us that architecture and generosity which allows us to rise above narrow selfishness and work for the welfare of the entire world. 
            Elevate our consciousness to that high level where we can experience the omnipresence of God and see your image in every living entity we meet. 
            You are the power that possesses the capability to transform our hard labor and honesty into divine blessings and magnificent successes. 
            O Agni, we adore you repeatedly so that our lives remain nourished, prosperous, meaningful, and completely righteous in every aspect.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 139,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ १३९ ॥",
        hindiCommentary = """
            हे पावक अग्निदेव! आप दिव्य लोकों के स्वामी और समस्त चराचर जगत के ऐश्वर्यों के परम नियंत्रक, अधिपति और अत्यंत उदार प्रदाता के रूप में प्रतिष्ठित हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली प्रेरणा, सात्विक अन्न, स्वास्थ्य और ऊर्जा लेकर आएं जो हमारे जीवन को सफल और ऊर्ध्वगामी बनाए। 
            आपकी असीम कृपा से हमारे जीवन की दरिद्रता और अभावों का नाश हो और हम केवल भौतिक धन ही नहीं, बल्कि श्रेष्ठ मानवीय और दैवीय गुणों के भी धनी बनें। 
            हे देव, आप हमारे अज्ञान को अपनी प्रखर ज्योति से जलाकर हमें वह सत्य मार्ग दिखाएं जहाँ केवल अखंड शांति, निस्वार्थ प्रेम और दिव्य आनंद का वास हो। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे तुच्छ और छोटे कर्मों को ईश्वरीय फल तक पहुँचाती हैं और हमारे इस मानवीय जीवन को कृतार्थ और सार्थक करती हैं। 
            हमें वह शक्तिशाली प्रेरणा प्रदान करें जिससे हमारे शरीर में नवीन उत्साह और मन में सदैव पवित्र और ऊँचे विचारों का अखंड प्रवाह बना रहे। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत और ईश्वर के सान्निध्य के समीप होने लगते हैं। 
            हे अग्नि, आप हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, आरोग्यता और अखंड सौभाग्य प्रदान करने की महान कृपा करने का कष्ट करें। 
            आपकी दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश, कीर्ति और आत्मज्ञान का सही मार्ग निरंतर और सफलतापूर्वक दिखाती रहे। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें वह स्थायी संपत्ति दें जो हमारे इस लोक के साथ-साथ परलोक के मार्ग में भी परम सहायक और सुखद सिद्ध हो।
        """.trimIndent(),
        englishCommentary = """
            O Purifying Agni, you are the Lord of celestial realms and the supreme controller, master, and generous provider of all worldly riches and wealth. 
            For us, your devoted chanters, bring forth that powerful inspiration, virtuous nourishment, and energy that make our lives successful and ascending. 
            By your boundless grace, let our poverty and scarcities be destroyed, making us wealthy not just with money but with superior divine virtues. 
            O God, burn away our ignorance with your intense light and show us the path of truth where only unbroken peace, love, and joy reside. 
            You are the supreme power that carries our humble and small deeds to divine results and makes our human existence truly blessed and fulfilled. 
            Provide us with powerful inspiration so that fresh enthusiasm remains in our bodies and noble thoughts flow consistently in our minds. 
            Singing your glories purifies our inner self and initiates our constant spiritual awakening and proximity to the realization of the Divine. 
            O Agni, remove every lack from our lives and graciously grant us completeness, health, and unbroken auspiciousness for our families and homes. 
            Let your radiance illuminate every dark corner of our existence and continuously show us the pathway to fame, splendor, and Self-knowledge. 
            We pray with devotion that you grant us that permanent wealth which assists us both in this world and in our spiritual journey beyond.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 140,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ १४० ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय यज्ञों, संकल्पों और अनुष्ठानों के मुख्य पुरोहित (होता) और देवताओं को आह्वान करने वाले दिव्य और पवित्र दूत हैं। 
            आप हम मनुष्यों के बीच रहकर भी हमारा अटूट संबंध स्वर्ग के देवताओं से जोड़ते हैं, आप ही वास्तव में हमारे सबसे सच्चे और परम हितैषी रक्षक देव हैं। 
            आपकी पावन उपस्थिति के बिना हमारा कोई भी यज्ञ, संकल्प या शुभ कर्म कभी पूर्ण नहीं हो सकता, क्योंकि आप ही यज्ञ की आत्मा, आधार और केंद्र हैं। 
            हे देव, आप हमारे भीतर दिव्य और सात्विक प्रवृत्तियों का विकास करें और हमें असुरत्व तथा बुराइयों के प्रभाव से सदैव सुरक्षित बचाकर रखने की कृपा करें। 
            आपकी हितकारी दृष्टि हमें पतन और अज्ञान के मार्ग से हटाकर निरंतर प्रगति, आत्मोन्नति, सुख और अखंड शांति की दिशा में सफलतापूर्वक अग्रसर करती है। 
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे समस्त शारीरिक और मानसिक कर्मों को शुद्ध, पवित्र, कल्याणकारी और फलदायी बना दें। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में एकता, प्रेम, सुख-शांति और धार्मिक निष्ठा के मुख्य स्तंभ और सर्वोच्च रक्षक देव के रूप में प्रतिष्ठित हैं। 
            आपकी दिव्य ऊर्जा हमारे प्राणों में चेतना बनकर निरंतर बहती है और हमें सदैव सत्य, न्याय और निस्वार्थ मानवता के मार्ग पर चलने की प्रेरणा प्रदान करती है। 
            हे अग्नि, आप हमारे सर्वोच्च गुरु और मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता का साक्षात् अनुभव करने में पूरी तरह सफल हों। 
            आपकी कृपा से हमारा जीवन दिव्य आशीर्वादों से भरा रहे और हम सदैव मानवता की निस्वार्थ सेवा और धर्म की रक्षा के पुनीत कार्यों में तन्मयता से लगे रहें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest (Hotar) of all human rituals and the divine and holy messenger who invokes the celestial gods to the sacrifice. 
            While residing among us mortals, you connect us with the gods of heaven; you are indeed our most sincere and supreme well-wishing deity. 
            Without your sacred presence, no sacrifice, resolution, or auspicious deed of ours can ever be completed, for you are its very soul and base. 
            O God, develop divine and virtuous tendencies within us and always keep us safely protected from the influence of evil and demonic ways. 
            Your benevolent gaze steers us away from the path of downfall and ignorance, leading us successfully toward progress, joy, and peace. 
            Just as fire consumes and destroys all impurities, please make all our physical and mental actions pure, holy, and beneficial for the world. 
            We worship you because you are the main pillar and protector of unity, love, happiness, and religious devotion within our families and homes. 
            Your divine energy flows through our lives as consciousness, perpetually inspiring us to walk the path of Truth, Justice, and Humanity. 
            O Agni, become our supreme teacher and guide, showing us that Truth where we can successfully experience the omnipresence of the Divine. 
            By your grace, let our lives be filled with divine blessings and let us stay engaged in the holy acts of selfless service and protection of Dharma.
        """.trimIndent()
    )
)