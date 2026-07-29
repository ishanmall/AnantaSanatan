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
fun ShuklaYajurvedaAdhyayaTwoScreen() {
    var searchQuery by remember { mutableStateOf("") }

    val filteredVerses = remember(searchQuery) {
        if (searchQuery.isEmpty()) {
            shuklaYajurAdhyayaTwoData
        } else {
            shuklaYajurAdhyayaTwoData.filter {
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
                        Text("द्वितीय अध्याय - दर्शपूर्णमास", fontWeight = FontWeight.ExtraBold)
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

val shuklaYajurAdhyayaTwoData = listOf(
    ShuklaYajurVerse(
        id = 1,
        sanskrit = "कृष्णोऽस्याखरेष्ठोऽग्नये त्वा जुष्टं प्रोक्षामि वेद्यै त्वा जुष्टं प्रोक्षामि बर्हिषे त्वा जुष्टं प्रोक्षामि सुवेण त्वा जुष्टं प्रोक्षामि ॥ १ ॥",
        hindiCommentary = """
            हे यज्ञीय काष्ठ (लकड़ी)! तू श्याम वर्ण का है और यज्ञ के पवित्र स्थान पर स्थित है। मैं तुझे अग्निदेव की प्रसन्नता के लिए जल से पवित्र करता हूँ।
            मैं तुझे यज्ञवेदी की सिद्धि के लिए पवित्र करता हूँ; मैं तुझे कुशा (बर्हिष) के लिए पवित्र करता हूँ और इस स्रुवा (यज्ञपात्र) के लिए शुद्ध करता हूँ।
            द्वितीय अध्याय का यह प्रथम मंत्र यज्ञ में प्रयुक्त होने वाली समिधाओं और उपकरणों की शुद्धि का अत्यंत महत्वपूर्ण विधान प्रस्तुत करता है।
            बाहरी शुद्धि केवल जल से होती है, परंतु मंत्रों के माध्यम से की गई 'प्रोक्षण' (छिड़काव) प्रक्रिया वस्तु को आध्यात्मिक रूप से जाग्रत कर देती है।
            काष्ठ (लकड़ी) जड़ है, लेकिन जब उसे देवों के निमित्त संस्कारित किया जाता है, तो वह दिव्यता को प्राप्त कर देवताओं का अंश बन जाती है।
            यह हमें सिखाता है कि जीवन में हम जो भी साधन उपयोग करें, उन्हें पहले पवित्र उद्देश्यों और शुद्ध भावनाओं से अवश्य संस्कारित करें।
            अग्नि, वेदी और कुशा—ये तीनों यज्ञ के मूल आधार हैं; इनकी प्रसन्नता का अर्थ है प्रकृति और ईश्वर के बीच पूर्ण सामंजस्य स्थापित होना।
            हे प्रभु! जिस प्रकार यह साधारण लकड़ी आपके लिए पवित्र की जा रही है, वैसे ही मेरे इस भौतिक शरीर और मन को भी अपने कार्यों के लिए पवित्र कर दें।
            जब साधन शुद्ध होते हैं, तभी साध्य (लक्ष्य) की प्राप्ति होती है; अशुद्ध साधनों से किए गए कार्य कभी भी स्थायी शांति या धर्म नहीं ला सकते।
            हम अपना प्रत्येक कर्म इसी प्रोक्षण के समान पवित्रता से आरंभ करें, ताकि हमारे जीवन का हर पल एक सफल और जाग्रत महायज्ञ बन सके।
        """.trimIndent(),
        englishCommentary = """
            O sacrificial wood! You are dark-hued and situated in the sacred place of sacrifice. I consecrate you with water for the pleasure of Agni.
            I purify you for the success of the sacrificial altar; I purify you for the sacred Kusha grass, and I purify you for this offering spoon (Sruva).
            The first mantra of the second chapter presents the highly important law of purifying the fuel and implements used in the sacrifice.
            External purification is done with water, but the process of 'Prokshana' (sprinkling) via mantras awakens the object spiritually.
            Wood is inanimate, but when it is consecrated for the gods, it attains divinity and becomes a direct part of the celestial beings.
            This teaches us that whatever resources we use in life, we must first consecrate them with holy purposes and pure intentions.
            Agni, the altar, and Kusha—these three are the foundation of sacrifice; pleasing them means establishing perfect harmony with nature and God.
            O Lord! Just as this ordinary wood is being purified for You, please purify my physical body and mind for Your divine tasks.
            Only when the means are pure can the goal be achieved; actions performed with impure means can never bring lasting peace or Dharma.
            Let us begin every action with the purity of this sprinkling, so that every moment of our life becomes a successful and awakened grand sacrifice.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 2,
        sanskrit = "अदित्या व्युन्दनमसि विष्णोः श्मश्रूणि।\nउर्वन्तरिक्षमन्वेमि ॥ २ ॥",
        hindiCommentary = """
            हे जल! तू माता अदिति (अखंड सत्ता) को भिगोने (आर्द्र करने) वाला है; तुम सर्वव्यापी विष्णु की दाढ़ी (श्मश्रु) के समान पवित्र कुशाओं को सींचने वाले हो।
            इन यज्ञीय उपकरणों को शुद्ध करने के पश्चात, अब मैं इस विशाल और उन्मुक्त अंतरिक्ष (स्वतंत्र चेतना) में निर्बाध रूप से विचरण करता हूँ।
            यहाँ जल को सृष्टि की माता अदिति से जोड़ा गया है, क्योंकि जल ही वह तत्व है जो पूरी पृथ्वी को जीवन और नमी प्रदान करता है।
            विष्णु के 'श्मश्रु' (दाढ़ी) का प्रतीकात्मक अर्थ कुशा घास से है, जो यज्ञ वेदी पर बिछाई जाती है और जिसमें विष्णु का ही अंश माना जाता है।
            जब हम प्रकृति के हर कण में ईश्वर का दर्शन करते हैं, तब हमारे भीतर का अहंकार पूरी तरह गल जाता है और हम असीम शांति पाते हैं।
            साधक जब अपने बाहरी और भीतरी उपकरणों को शुद्ध कर लेता है, तभी वह 'उरु अंतरिक्ष' अर्थात् मानसिक स्वतंत्रता और विशालता का अनुभव करता है।
            हे परमात्मा! हमारे मन को जल की तरह निर्मल बनाएं ताकि हम आपके विराट स्वरूप को अपनी आत्मा के भीतर स्पष्ट रूप से देख सकें।
            शुद्धि के बिना साधना संभव नहीं है; अशुद्ध मन में ईश्वर का वास उसी प्रकार नहीं हो सकता जैसे गंदे दर्पण में मुख दिखाई नहीं देता।
            यह मंत्र हमें संकीर्णताओं से उठकर एक ऐसे आध्यात्मिक आकाश में उड़ने की प्रेरणा देता है जहाँ केवल दिव्य आनंद और परम सत्य का वास है।
            हमारा जीवन इस कुशा और जल के समान हो जाए, जो समाज के संताप को हरे और सबमें ईश्वर की अखंड सत्ता का निरंतर अनुभव कराए।
        """.trimIndent(),
        englishCommentary = """
            O Water! You are the moistener of Mother Aditi (the Boundless Reality); you sprinkle the sacred Kusha grass, which resembles the beard of omnipresent Vishnu.
            After purifying these sacrificial implements, I now move freely and unhindered into the vast and open space (free consciousness).
            Here, water is linked to the Creator Mother Aditi, because water is the element that provides life and moisture to the entire earth.
            The symbolic meaning of Vishnu's 'beard' refers to the Kusha grass laid on the altar, which is considered a direct part of Vishnu Himself.
            When we see the Divine in every particle of nature, the ego within us completely melts away and we attain infinite, boundless peace.
            Only when the seeker purifies his external and internal tools does he experience 'Uru Antariksha'—absolute mental freedom and vastness.
            O Supreme Lord! Make our minds as pure as water so that we can clearly see Your magnificent form within our own souls.
            Spiritual practice is impossible without purity; God cannot reside in an impure mind just as a face cannot be seen in a dirty mirror.
            This mantra inspires us to rise above narrowness and fly into a spiritual sky where only divine bliss and ultimate truth reside.
            May our lives become like this Kusha and water, removing the sorrows of society and constantly making everyone experience God's unbroken reality.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 3,
        sanskrit = "प्रत्युष्टं रक्षः प्रत्युष्टा अरातयो निष्टप्तं रक्षो निष्टप्ता अरातयः।\nअग्नेस्तेजसा सूर्यस्य वर्चसा ॥ ३ ॥",
        hindiCommentary = """
            राक्षसी प्रवृत्तियों को पूरी तरह से तपा कर नष्ट कर दिया गया है; कृपणता और शत्रुता (अराति) के भावों को जलाकर भस्म कर दिया गया है।
            इन विघ्नकारी शक्तियों को मैंने अग्नि के प्रखर तेज और भगवान सूर्य के महान वर्चस्व (प्रकाश) से पूरी तरह समाप्त कर दिया है।
            यह मंत्र यज्ञ की वेदी को नकारात्मक शक्तियों से सुरक्षित करने का एक अत्यंत शक्तिशाली उद्घोष है।
            अग्नि और सूर्य दोनों ही प्रकाश और ऊर्जा के सबसे बड़े स्रोत हैं; जहाँ प्रकाश होता है, वहाँ अज्ञान या बुराई रूपी अंधकार टिक नहीं सकता।
            हमारे जीवन में 'राक्षस' कोई बाहरी जीव नहीं, बल्कि हमारे ही कुविचार, क्रोध और स्वार्थ हैं जो हमारे श्रेष्ठ कर्मों में बाधा डालते हैं।
            'अराति' वह संकीर्णता है जो हमें दान, परोपकार और प्रेम करने से रोकती है; इसे ज्ञान की ज्वाला में जलाना परम आवश्यक है।
            हे अग्निदेव! आप हमारे अंतःकरण में उठने वाले हर दूषित विचार को अपने तेज से जला दें और हमारे हृदय को सूर्य के समान निर्मल और प्रतापी बनाएं।
            जब साधक सूर्य और अग्नि की ऊर्जा से जुड़ जाता है, तो उसे संसार का कोई भी भय या चिंता कभी भी विचलित नहीं कर सकती।
            सच्चा यज्ञ वही है जहाँ भीतर और बाहर दोनों ओर पूरी पवित्रता हो; बिना आंतरिक शुद्धि के किया गया कर्म केवल एक दिखावा मात्र रह जाता है।
            हम ईश्वरीय तेज को धारण कर निर्भय बनें और समाज से अज्ञान और बुराइयों को मिटाने के लिए सदैव संकल्पित और तत्पर रहें।
        """.trimIndent(),
        englishCommentary = """
            Demonic tendencies have been completely scorched and destroyed; the feelings of miserliness and enmity (Arati) have been completely burnt to ashes.
            I have entirely eradicated these disruptive forces with the fierce brilliance of Agni and the great luminous power of the Sun God.
            This mantra is an extremely powerful declaration to secure the sacrificial altar from all kinds of negative and evil forces.
            Both Agni and the Sun are the greatest sources of light and energy; where there is light, the darkness of ignorance or evil cannot survive.
            In our lives, 'demons' are not external creatures, but our own bad thoughts, anger, and selfishness that obstruct our noble deeds.
            'Arati' is that narrow-mindedness which stops us from charity, benevolence, and love; burning it in the flame of knowledge is absolutely essential.
            O Agni! Burn every polluted thought arising in our conscience with your brilliance and make our hearts pure and glorious like the Sun.
            When a seeker connects with the energy of the Sun and Agni, no fear or worry of the world can ever disturb or shake them.
            True sacrifice is that where there is complete purity both inside and outside; an action done without internal purity remains a mere show.
            Let us bear the divine brilliance to become fearless, and remain constantly resolved and ready to eradicate ignorance and evils from society.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 4,
        sanskrit = "उरु वाताय।\nदेवस्य त्वा सवितुः प्रसवेऽश्विनोर्बाहुभ्यां पूष्णो हस्ताभ्यामाददे ॥ ४ ॥",
        hindiCommentary = """
            हे वायु देव! आप इस यज्ञ स्थल को अत्यंत विस्तृत (उरु) करें और यहाँ बिना किसी बाधा के निर्बाध रूप से प्रवाहित हों।
            सृष्टिकर्ता सविता देव की पावन प्रेरणा से, अश्विनीकुमारों की बलशाली भुजाओं से और पूषा देव के मजबूत हाथों से मैं इन यज्ञपात्रों को ग्रहण करता हूँ।
            यज्ञ में वायु का प्रवाह आवश्यक है, क्योंकि वायु के बिना न तो अग्नि प्रज्वलित हो सकती है और न ही मंत्रों की ध्वनि ब्रह्मांड में गूंज सकती है।
            विस्तार का अर्थ है कि हमारा मन संकीर्णताओं से मुक्त हो जाए और वायु की तरह उन्मुक्त होकर पूरी सृष्टि के कल्याण की कामना करे।
            साधक अहंकार त्याग कर यह मानता है कि वह अपने हाथों से नहीं, बल्कि देवताओं की दिव्य शक्तियों (अश्विनी और पूषा) के माध्यम से कार्य कर रहा है।
            सविता की प्रेरणा हमें यह याद दिलाती है कि हमारे हर शुभ विचार का मूल स्रोत वह परमपिता परमात्मा ही है, हम तो केवल निमित्त मात्र हैं।
            हे प्रभु! हमारे जीवन में विचारों का ऐसा स्वतंत्र और शुद्ध प्रवाह हो कि कोई भी कुंठा या दुराग्रह हमारे मन में कभी घर न कर सके।
            जब मनुष्य स्वयं को ईश्वरीय हाथों का उपकरण मान लेता है, तो उसके कर्म दोषरहित हो जाते हैं और उसे असीम शांति की प्राप्ति होती है।
            अश्विनीकुमारों से हम आरोग्य मांगते हैं और पूषा से पुष्टि; ताकि हम स्वस्थ शरीर से धर्म के मार्ग पर आजीवन चल सकें।
            हमारा जीवन इस यज्ञ के समान ऐसा पवित्र हो कि हम स्वयं के साथ-साथ संपूर्ण विश्व को ऊर्जा, स्वास्थ्य और ज्ञान प्रदान कर सकें।
        """.trimIndent(),
        englishCommentary = """
            O Wind God (Vayu)! Make this sacrificial place extremely vast (Uru) and flow here continuously without any obstruction.
            Impelled by the Divine Savitar, with the strong arms of the Ashvins, and with the firm hands of Pushan, I take these sacrificial vessels.
            The flow of wind is essential in a sacrifice, because without wind, neither can the fire ignite nor can the sound of mantras echo in the universe.
            Expansion means our mind should be free from narrowness and, unbound like the wind, wish for the absolute welfare of the entire creation.
            Abandoning ego, the seeker believes he is not working with his own hands, but through the divine powers of the gods (Ashvins and Pushan).
            Savitar's inspiration reminds us that the root source of every auspicious thought is the Supreme Father; we are mere instruments.
            O Lord! Let there be such a free and pure flow of thoughts in our lives that no frustration or prejudice can ever settle in our minds.
            When a human considers himself a tool in divine hands, his actions become flawless and he attains boundless, eternal peace.
            From the Ashvins we ask for health and from Pushan nourishment; so that with a healthy body, we can walk the path of Dharma lifelong.
            May our life be as sacred as this sacrifice, so we can provide energy, health, and profound knowledge to ourselves and the whole world.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 5,
        sanskrit = "इदमहं रक्षसो ग्रीवा अपि कृन्तामि।\nयवोऽसि यवयास्मद्वेषो यवयारातीः ॥ ५ ॥",
        hindiCommentary = """
            मैं (कुशा या खड्ग से) इस वेदी पर विघ्न डालने वाले राक्षस (बुराइयों) की गर्दन को अत्यंत दृढ़ता से काटता हूँ।
            हे जौ (यव)! तू अन्न का श्रेष्ठ रूप है; तू हमारे द्वेष (शत्रुता) को हमसे दूर कर दे, और हमारी अराति (कंजूसी और नकारात्मकता) का समूल नाश कर दे।
            यहाँ 'राक्षस की गर्दन काटना' एक प्रतीकात्मक क्रिया है; यह वास्तव में हमारे भीतर के अहंकार, लोभ और वासना रूपी असुरों का वध है।
            यज्ञ में प्रयुक्त होने वाला 'जौ' (यव) केवल धान्य नहीं है, बल्कि वह उन सभी प्रवृत्तियों को दूर ('यवय') करने का प्रतीक है जो धर्म के विरुद्ध हैं।
            मनुष्य का सबसे बड़ा शत्रु उसके बाहर नहीं, बल्कि उसका अपना द्वेष और संकीर्णता है, जो उसकी आध्यात्मिक और भौतिक प्रगति को रोक देता है।
            अन्न (जौ) को साक्षात् देव मानकर उससे प्रार्थना की गई है कि वह हमारे शरीर का पोषण करने के साथ-साथ हमारी आत्मा को भी निर्मल बनाए।
            हे परमात्मा! हमें वह साहस दें कि हम अपनी बुराइयों पर निर्दयता से प्रहार कर सकें और अपने जीवन को पूर्णतः दोषमुक्त बना सकें।
            जब तक मन से कंजूसी (अराति) नहीं जाती, तब तक मनुष्य कभी भी ईश्वर के प्रति पूर्ण समर्पण या समाज के लिए निस्वार्थ सेवा नहीं कर सकता।
            सच्चा यज्ञ वही है जो समाज से शत्रुता को मिटाकर प्रेम और सद्भाव के अंकुर बोए; जौ उसी वृद्धि और शांति का महान प्रतीक है।
            हम जो भी अन्न ग्रहण करें, वह हमारे भीतर सात्विक प्रवृत्तियों का संचार करे और हमें हमेशा श्रेष्ठ तथा न्यायपूर्ण कर्म करने की प्रेरणा दे।
        """.trimIndent(),
        englishCommentary = """
            I (with the Kusha or sword) firmly cut the neck of the demon (evils) that causes obstacles on this sacred altar.
            O Barley (Yava)! You are the excellent form of food; keep our malice (enmity) far away from us, and completely destroy our Arati (miserliness).
            Here, 'cutting the demon's neck' is a symbolic act; it is actually the slaying of the inner demons in the form of ego, greed, and lust.
            The 'barley' (Yava) used in the sacrifice is not just grain; it symbolizes warding off ('Yavaya') all tendencies that are against Dharma.
            A human's biggest enemy is not outside, but their own malice and narrow-mindedness, which halt their spiritual and material progress.
            Considering food (barley) as a direct deity, a prayer is made that while nourishing our body, it also makes our soul completely pure.
            O Supreme Lord! Give us the courage to ruthlessly strike down our own evils and make our lives entirely flawless and pure.
            As long as miserliness (Arati) does not leave the mind, a person can never fully surrender to God or perform selfless service for society.
            True sacrifice is that which erases enmity from society and sows the seeds of love; barley is the great symbol of that growth and peace.
            Whatever food we consume, may it infuse virtuous tendencies within us and constantly inspire us to perform noble and just deeds.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 6,
        sanskrit = "दिवे त्वाऽन्तरिक्षाय त्वा पृथिव्यै त्वा।\nशुन्धन्तां लोकाः पितृषदनाः पितृषदनमसि ॥ ६ ॥",
        hindiCommentary = """
            हे यज्ञपात्र! मैं तुम्हें स्वर्गलोक (द्युलोक) के लिए, मध्यलोक (अंतरिक्ष) के लिए और इस पृथ्वीलोक के कल्याण के लिए ग्रहण करता हूँ।
            पितरों (पूर्वजों) के निवास स्थान रूपी ये सभी लोक पूरी तरह से शुद्ध और पवित्र हों; हे वेदी, तू हमारे पितरों के बैठने का पावन स्थान है।
            यह मंत्र स्पष्ट करता है कि वैदिक यज्ञ केवल अपने स्वार्थ के लिए नहीं, बल्कि संपूर्ण त्रिलोकी (स्वर्ग, अंतरिक्ष, पृथ्वी) के संतुलन के लिए किया जाता है।
            हमारे कर्मों का प्रभाव केवल हम तक सीमित नहीं रहता; वे पूरे ब्रह्मांड और हमारे पूर्वजों की आत्माओं तक तरंगित होते हैं।
            पितरों का सम्मान और उनके लिए शुद्धि की कामना भारतीय संस्कृति का वह मूल आधार है जो हमें हमारी जड़ों और परंपराओं से जोड़े रखता है।
            जब हम अपने लोकों को शुद्ध करते हैं, तो हम वास्तव में अपने वातावरण और अपने मन के विचारों को मलिनता से मुक्त कर रहे होते हैं।
            हे प्रभु! हमारे कर्म ऐसे हों जो पृथ्वी पर शांति लाएं, अंतरिक्ष को स्वच्छ रखें और स्वर्ग के देवताओं को भी अत्यंत प्रसन्न करें।
            हम अपने पूर्वजों के ऋण को कभी न भूलें और अपने श्रेष्ठ आचरण से उनके नाम और कुल की कीर्ति को चारों दिशाओं में फैलाएं।
            यज्ञ की वेदी एक ऐसा मिलन बिंदु है जहाँ भूतकाल (पितर), वर्तमान (यजमान) और भविष्य (देवता) एक साथ आकर एकाकार हो जाते हैं।
            हमारा जीवन इस यज्ञवेदी के समान पावन बने, जहाँ आकर हर पीड़ित आत्मा को शांति और हर भटके हुए मन को सही दिशा प्राप्त हो सके।
        """.trimIndent(),
        englishCommentary = """
            O Sacrificial Vessel! I accept you for the welfare of Heaven (Dyuloka), the mid-space (Antariksha), and this Earth.
            May all these worlds, which are the dwelling places of the Ancestors (Pitris), be completely purified; O Altar, you are the holy seat of our Ancestors.
            This mantra clarifies that a Vedic sacrifice is not done for selfish reasons, but for the balance of the entire three worlds.
            The impact of our actions is not limited to us alone; they ripple through the entire universe and reach the souls of our ancestors.
            Respect for ancestors and praying for their purity is the core foundation of Indian culture that keeps us connected to our roots.
            When we purify our worlds, we are actually freeing our environment and the thoughts of our minds from all kinds of pollution.
            O Lord! May our actions be such that they bring peace to the earth, keep the space clean, and highly please the gods of heaven.
            Let us never forget the debt of our ancestors and, through our noble conduct, spread the glory of their name and lineage everywhere.
            The sacrificial altar is a meeting point where the past (ancestors), present (sacrificer), and future (gods) come together and unite.
            May our lives become as holy as this altar, where every suffering soul finds peace and every wandering mind finds the right direction.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 7,
        sanskrit = "उद्धन्मि रक्षः सम्पहन्मि रक्षोऽपहतोऽररुः पृथिव्यै।\nव्रजं गच्छ गोष्ठं त्वा पतयस्त्वा ससृजुः ॥ ७ ॥",
        hindiCommentary = """
            मैं विघ्न डालने वाले राक्षसों (बुराइयों) को खोदकर बाहर निकालता हूँ, मैं उन्हें पूरी तरह कुचल कर नष्ट करता हूँ; अराति (दानव) पृथ्वी से उखाड़ फेंका गया है।
            हे पवित्र मृदा (मिट्टी)! तू गोशाला (गौओं के बाड़े) को जा; देवताओं (रक्षकों) ने तुझे श्रेष्ठ निर्माण और यज्ञ के लिए उत्पन्न किया है।
            यज्ञवेदी बनाते समय मिट्टी खोदने की प्रक्रिया को यहाँ बुराइयों और अज्ञानता को जड़ से उखाड़ फेंकने का प्रतीक माना गया है।
            केवल ऊपरी सफाई पर्याप्त नहीं है; जब तक मन की गहराई में छिपे कुसंस्कारों को खोदकर नष्ट नहीं किया जाता, तब तक आत्मिक शांति संभव नहीं।
            राक्षस और अररु वे विचार हैं जो समाज में कलह और अशांति फैलाते हैं; सत्य और धर्म के साधक को उनका कठोरता से दमन करना चाहिए।
            मिट्टी को गोशाला जाने का आदेश देने का अर्थ है कि हमारा आधार (भूमि) गो-धन और सात्विक संपदा की वृद्धि करने वाला होना चाहिए।
            हे देव! हमें ऐसा फावड़ा (ज्ञान) दें जिससे हम अपने भीतर के अहंकार और ईर्ष्या को खोदकर हमेशा के लिए बाहर फेंक सकें।
            ईश्वर ने हमें और इस प्रकृति को केवल मंगलकारी कार्यों और प्रेम के विस्तार के लिए ही रचा है, विनाश के लिए नहीं।
            हम अपनी आधारभूत प्रवृत्तियों को इतना शुद्ध कर लें कि हमारे जीवन की वेदी पर देवत्व स्वयं आकर निवास करने लगे।
            हमारा संकल्प इतना वज्र के समान कठोर हो कि असत्य और अज्ञान की कोई भी शक्ति हमारे धर्म के मार्ग को कभी भी रोक न सके।
        """.trimIndent(),
        englishCommentary = """
            I dig out the obstructing demons (evils), I crush and completely destroy them; the Arati (demon) has been uprooted from the earth.
            O sacred soil! Go to the cow-pen; the gods (protectors) have created you for excellent construction and holy sacrifice.
            The process of digging the soil while making the altar is considered here as a symbol of uprooting evils and ignorance from the root.
            Superficial cleaning is not enough; until the bad impressions hidden deep in the mind are dug out, spiritual peace is impossible.
            Demons and Araru are thoughts that spread discord in society; a seeker of truth and Dharma must suppress them strictly.
            Ordering the soil to go to the cow-pen means our foundation (land) should be the promoter of cattle wealth and virtuous prosperity.
            O God! Give us such a shovel (of knowledge) that we can dig out our inner ego and jealousy and throw them out forever.
            God has created us and this nature solely for auspicious deeds and the expansion of pure love, not for destruction at all.
            Let us purify our foundational tendencies so much that divinity itself comes and resides permanently on the altar of our lives.
            May our resolve be as hard as a thunderbolt so that no power of untruth and ignorance can ever block our path of Dharma.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 8,
        sanskrit = "पृथिवि देवयजन्योषध्यास्ते मूलं मा हिंसिषम्।\nव्रजं गच्छ गोष्ठं त्वा पतयस्त्वा ससृजुः ॥ ८ ॥",
        hindiCommentary = """
            हे देवों के यज्ञ की आधाररूपा पृथ्वी! मिट्टी खोदते समय मैं तेरी औषधियों और वनस्पतियों के मूल (जड़) को कोई हानि न पहुँचाऊं।
            हे खोदी गई पावन मिट्टी! तू पशुओं के बाड़े (गोशाला) में जा; रक्षक देवों ने तुझे केवल श्रेष्ठ रचना और कल्याण के लिए ही उत्पन्न किया है।
            यह वैदिक काल का सबसे उत्तम पर्यावरण संरक्षण मंत्र है, जो सिखाता है कि अपनी आवश्यकता के लिए प्रकृति का विनाश कभी नहीं करना चाहिए।
            यज्ञ जैसे महान कर्म के लिए भी यदि हम भूमि खोदते हैं, तो हमें ध्यान रखना चाहिए कि पेड़-पौधों की जड़ें सुरक्षित रहें।
            वनस्पतियां ही पृथ्वी का प्राण हैं और जीवन का आधार हैं; उनके प्रति हमारी करुणा और संवेदनशीलता हमारे आध्यात्मिक स्तर को दर्शाती है।
            मिट्टी को गोशाला में भेजने का भाव यह है कि यज्ञ से बची हुई कोई भी वस्तु व्यर्थ न जाए, बल्कि वह कृषि और पशुपालन के काम आए।
            हे प्रभु! हमें वह विवेक दें कि हम विकास के नाम पर प्रकृति का अंधाधुंध दोहन न करें और पर्यावरण का हमेशा सम्मान करें।
            हमारा जीवन ऐसा हो जो दूसरों की जड़ों को काटे नहीं, बल्कि उन्हें मजबूत कर जीवन में आगे बढ़ने का अवसर और सहारा दे।
            पृथ्वी माता हमें सब कुछ देती है; हमारा भी यह परम कर्तव्य है कि हम उसकी हरियाली और उसकी जीवनदायिनी शक्ति की रक्षा करें।
            सच्चा धर्म केवल मंदिरों में नहीं है, बल्कि वह हमारे आसपास फैले वृक्षों, नदियों और पहाड़ों के प्रति हमारे प्रेम में भी निवास करता है।
        """.trimIndent(),
        englishCommentary = """
            O Earth, the foundation of divine sacrifice! While digging the soil, may I not harm the roots of your herbs and plants.
            O dug-up holy soil! Go to the cattle-pen; the protecting gods have created you solely for excellent creation and universal welfare.
            This is the finest environmental conservation mantra of the Vedic era, teaching that we must never destroy nature for our needs.
            Even when digging land for a great act like a sacrifice, we must be careful that the roots of trees and plants remain safe.
            Plants are the vital breath of the earth and the basis of life; our compassion towards them reflects our true spiritual level.
            Sending the soil to the cow-pen implies that nothing left over from the sacrifice should be wasted, but used for agriculture.
            O Lord! Grant us the wisdom not to blindly exploit nature in the name of development and to always respect the environment.
            May our life be such that it does not cut others' roots, but strengthens them and gives them an opportunity to grow.
            Mother Earth gives us everything; it is our supreme duty to protect her greenery and her immense life-giving power.
            True Dharma is not only in temples, but it also resides in our love for the trees, rivers, and mountains spread around us.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 9,
        sanskrit = "अपहतोऽररुः पृथिव्यै।\nदेव यजनि पृथिवि देवयजन्योषध्यास्ते मूलं मा हिंसिषम् ॥ ९ ॥",
        hindiCommentary = """
            (वेदी की दृढ़ता के लिए पुनरुक्ति) विघ्न डालने वाले दानव (अररु) को पृथ्वी से पूरी तरह उखाड़ फेंका गया है और नष्ट कर दिया गया है।
            हे देवों का यजन करने वाली पवित्र पृथ्वी! मैं खुदाई करते समय तेरी औषधियों और वनस्पतियों की जड़ों को कोई भी नुकसान न पहुँचाऊं।
            मंत्रों का बार-बार दुहराव यह सुनिश्चित करता है कि साधक के मन में पर्यावरण की रक्षा और बुराइयों के नाश का संकल्प अत्यंत गहरा हो जाए।
            अररु (स्वार्थ और अज्ञान) का नाश होने पर ही पृथ्वी 'देवयजनी' (देवताओं के यज्ञ के योग्य) बन पाती है; अशुद्ध स्थान पर देव नहीं आते।
            औषधियों की रक्षा का संकल्प हमें आयुर्वेद और जीवन रक्षा के प्रति वैदिक ऋषियों की महान और सूक्ष्म वैज्ञानिक दृष्टि का बोध कराता है।
            प्रकृति के साथ हिंसा करके कोई भी आध्यात्मिक अनुष्ठान कभी भी फलदायी नहीं हो सकता; अहिंसा ही परम धर्म है।
            हे परमात्मा! हमारे हाथों से कोई भी ऐसा कार्य न हो जो इस सुंदर प्रकृति को या इसके किसी भी जीव को थोड़ा सा भी कष्ट दे।
            हमें अपने भीतर छिपे उस अररु को मारना है जो हमें लालच में अंधा कर देता है और प्रकृति के विनाश के लिए प्रेरित करता है।
            पृथ्वी हमारी माता है, और माता की छाती पर आघात करना सबसे बड़ा पाप है; हमें इसके संसाधनों का उपयोग अत्यंत कृतज्ञता से करना चाहिए।
            हमारा हर कदम पर्यावरण के संरक्षण और विश्व में शांति तथा हरियाली फैलाने के एक महान यज्ञ का हिस्सा बने, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            (Repetition for altar firmness) The obstacle-creating demon (Araru) has been completely uprooted and destroyed from the earth.
            O sacred Earth where gods are worshipped! While digging, may I not cause any harm to the roots of your herbs and plants.
            The repeated chanting of mantras ensures that the resolve to protect the environment and destroy evils becomes deeply rooted.
            Only when Araru (selfishness) is destroyed does the earth become 'Devayajani' (fit for divine sacrifice); gods do not visit impure places.
            The resolve to protect herbs makes us realize the profound and subtle scientific vision of Vedic sages regarding Ayurveda.
            No spiritual ritual can ever be fruitful by committing violence against nature; Non-violence is indeed the supreme Dharma.
            O Supreme Lord! Let our hands not perform any act that causes even the slightest pain to this beautiful nature or its beings.
            We must kill that Araru hidden within us which blinds us with greed and inspires us to recklessly destroy the environment.
            Earth is our mother, and striking a mother's chest is the greatest sin; we must use her resources with immense gratitude.
            May every step of ours become part of a great sacrifice to conserve the environment and spread peace and greenery worldwide.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 10,
        sanskrit = "अन्तरितं रक्षोऽन्तरिता अरातयः।\nअदित्यास्त्वोपस्थे सादयामि ॥ १० ॥",
        hindiCommentary = """
            सभी राक्षसी शक्तियां (बाधाएं) दूर कर दी गई हैं; कृपणता, द्वेष और शत्रुता के सभी विचारों (अराति) को भी पूरी तरह से हटा दिया गया है।
            हे यज्ञपात्र (या मिट्टी)! अब मैं तुम्हें माता अदिति (अखंड और विशाल पृथ्वी) की पवित्र गोद में अत्यंत श्रद्धापूर्वक स्थापित करता हूँ।
            जब तक मन से नकारात्मक विचार और स्वार्थ दूर नहीं होते, तब तक हम किसी भी श्रेष्ठ वस्तु को ईश्वर के चरणों में अर्पित नहीं कर सकते।
            'अदिति की गोद' का अर्थ है पूर्ण सुरक्षा और वात्सल्य; यज्ञ की प्रत्येक आहुति उसी ब्रह्मांडीय माता को सौंप दी जाती है।
            अराति वह अज्ञान है जो हमें यह सोचने पर मजबूर करता है कि हम अलग हैं; जबकि अदिति हमें यह सिखाती है कि हम सब एक ही अखंड सत्ता का हिस्सा हैं।
            बाधाओं का हटना कोई चमत्कार नहीं है, बल्कि वह हमारे दृढ़ संकल्प और मंत्रों की पवित्र ध्वनि का ही प्रत्यक्ष परिणाम है।
            हे प्रभु! हमारे मन को ऐसा साफ कर दें कि उसमें ईर्ष्या या घृणा का एक भी दाग शेष न रहे और हम केवल आपके प्रेम में लीन रहें।
            जब हम प्रकृति की गोद में स्वयं को पूरी तरह समर्पित कर देते हैं, तो हमारी सारी चिंताएं स्वतः ही समाप्त हो जाती हैं और हमें परम शांति मिलती है।
            हम अपना जीवन ऐसे जिएं जैसे एक अबोध शिशु अपनी माता की गोद में निर्भय होकर सोता है, क्योंकि ईश्वर ही हमारा परम रक्षक है।
            यह मंत्र हमें सिखाता है कि आध्यात्मिक उन्नति के लिए मानसिक शांति और ईश्वर के प्रति अटूट विश्वास सबसे बड़ी और अनिवार्य आवश्यकता है।
        """.trimIndent(),
        englishCommentary = """
            All demonic forces (obstacles) have been removed; all thoughts of miserliness, malice, and enmity (Arati) have also been entirely cleared.
            O Sacrificial Vessel (or soil)! Now I place you with utmost devotion into the holy lap of Mother Aditi (the unbroken, vast Earth).
            Until negative thoughts and selfishness are removed from the mind, we cannot offer any noble thing at the feet of God.
            'Aditi's lap' means complete security and maternal love; every oblation of the sacrifice is handed over to that cosmic mother.
            Arati is that ignorance making us think we are separate; whereas Aditi teaches us that we are all part of one unbroken reality.
            The removal of obstacles is not a miracle, but it is the direct result of our firm resolve and the holy sound of the mantras.
            O Lord! Cleanse our minds so thoroughly that not a single stain of jealousy remains, and we stay completely absorbed in Your love.
            When we completely surrender ourselves into the lap of nature, all our worries automatically end and we attain supreme peace.
            Let us live our lives like an innocent infant sleeping fearlessly in its mother's lap, because God is our ultimate protector.
            This mantra teaches us that for spiritual progress, mental peace and unbroken faith in God are the greatest and most essential requirements.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 11,
        sanskrit = "भूताय त्वा नारातये स्वरभिविख्येषम् ।\nदृंहन्तां दुर्याः पृथिव्यामुर्वन्तरिक्षमन्वेमि पृथिव्यास्त्वा नाभौ सादयाम्यदित्या उपस्थेऽग्ने हव्यं रक्ष ॥ ११ ॥",
        hindiCommentary = """
            हे हवि! मैं तुम्हें संसार के कल्याण और सत्य की वृद्धि के लिए ग्रहण करता हूँ, न कि किसी अराति (कृपणता या शत्रुता) के लिए।
            मैं उस दिव्य और प्रकाशमय स्वर्ग (परम आनंद) का साक्षात् दर्शन करूँ और मेरे सभी श्रेष्ठ कर्म मुझे उसी ओर ले जाएं।
            पृथ्वी पर स्थित मेरे घर (दुर्याः) और मेरा यह यज्ञमंडप अत्यंत दृढ़ और सुरक्षित रहें, ताकि कोई भी नकारात्मक शक्ति यहाँ प्रवेश न कर सके।
            इस संकल्प के साथ, अब मैं उस विशाल और उन्मुक्त अंतरिक्ष (स्वतंत्र चेतना) में बिना किसी बाधा के निर्बाध रूप से विचरण करता हूँ।
            मैं तुम्हें इस पृथ्वी की नाभि (यज्ञवेदी रूपी केंद्र) पर और माता अदिति (अखंड सत्ता) की अत्यंत पवित्र गोद में स्थापित करता हूँ।
            हे अग्निदेव! आप इस हविष्य (अन्न और भावनाओं) की रक्षा करें ताकि यह अशुद्ध विचारों से बचकर केवल देवों को ही प्राप्त हो।
            यह मंत्र स्पष्ट करता है कि हमारे सभी साधन और संसाधन केवल 'भूत' (सृष्टि के कल्याण) के लिए होने चाहिए, विनाश के लिए नहीं।
            जब हम अपने हृदय को पृथ्वी की तरह विशाल और अदिति की तरह प्रेमपूर्ण बना लेते हैं, तभी ईश्वर हमारे भीतर अवतरित होता है।
            हम जो भी संपत्ति प्राप्त करें, वह हमारे घरों को दृढ़ करे और हमारे परिवार में शांति तथा धर्म की नींव को मजबूत बनाए।
            हमारा पूरा जीवन एक ऐसा सुरक्षित और पावन यज्ञ बन जाए, जिसकी रक्षा स्वयं अग्निदेव (ईश्वरीय प्रकाश) निरंतर करते रहें।
        """.trimIndent(),
        englishCommentary = """
            O Oblation! I accept you for the welfare of all beings and the growth of Truth, and never for any Arati (miserliness or enmity).
            May I directly and clearly behold that divine and luminous heaven (supreme bliss), and may all my noble deeds lead me there.
            May my homes (Duryah) and this sacrificial pavilion on earth remain extremely firm and secure, so no negative force can enter.
            With this resolve, I now move unhindered and freely into the vast and open space (the state of free, liberated consciousness).
            I place you upon the navel of the earth (the central sacrificial altar) and in the highly sacred lap of Mother Aditi (Boundless Reality).
            O Agni! Protect this oblation (food and emotions) so that it remains safe from impure thoughts and reaches only the divine beings.
            This mantra clarifies that all our means and resources should be solely for 'Bhuta' (welfare of creation), not for destruction.
            Only when we make our hearts as vast as the earth and as loving as Aditi does God truly descend and reside within us.
            Whatever wealth we acquire, may it make our homes firm and strengthen the foundation of peace and Dharma in our families.
            May our entire life become such a secure and holy sacrifice, continuously protected by Agni (the supreme divine light) Himself.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 12,
        sanskrit = "पवित्रे स्थो वैष्णव्यौ सवितुर्वः प्रसव उत्पुनाम्यच्छिद्रेण पवित्रेण सूर्यस्य रश्मिभिः ।\nदेविरापो अग्रेगुवो अग्रेपुवोऽग्र इममद्य यज्ञं नयताग्रे यज्ञपतिं सुधातुम् ॥ १२ ॥",
        hindiCommentary = """
            हे कुश के पवित्र दलो! तुम विष्णु (सर्वव्यापी ईश्वर) से संबंधित और अत्यंत पवित्र करने वाले हो।
            सृष्टिकर्ता सविता देव की पावन प्रेरणा से, सूर्य की किरणों के समान इस छिद्ररहित (पूर्ण) पवित्र कुशा से मैं इस जल को शुद्ध करता हूँ।
            हे दिव्य जल की देवियों! तुम सबसे आगे चलने वाली (अग्रेगुव) और सबसे पहले पवित्र करने वाली (अग्रेपुव) हो।
            आज हमारे इस यज्ञ को पूर्णता के शिखर पर ले चलो और यज्ञ के स्वामी (यजमान) को श्रेष्ठ सुख और कल्याण के मार्ग पर सबसे आगे रखो।
            यह मंत्र यज्ञ में प्रयुक्त जल की शुद्धि का विधान है; जल के बिना जीवन और अनुष्ठान दोनों ही असंभव हैं।
            सूर्य की किरणें और जल—ये दोनों ही पृथ्वी पर जीवन के मुख्य आधार हैं, अतः इन्हें साक्षात् दैवीय शक्ति मानकर पूजा गया है।
            छिद्ररहित पवित्र कुशा हमारे 'अखंड ध्यान' और 'एकाग्रता' का प्रतीक है; जब मन बिना भटके ईश्वर में लगता है, तभी आत्मशुद्धि होती है।
            हे प्रभु! जिस प्रकार जल हर अशुद्धि को धो देता है, वैसे ही हमारे अंतःकरण के सभी विकारों को धोकर हमें अत्यंत निर्मल बना दें।
            समाज में हमें जल की तरह अग्रणी बनना चाहिए, जो दूसरों का मार्ग प्रशस्त करे और सभी को बिना भेदभाव के जीवन दान दे।
            हम अपने श्रेष्ठ कर्मों के माध्यम से यश और आत्मज्ञान के उस शिखर पर पहुँचें जहाँ केवल ईश्वरीय आनंद का ही वास हो।
        """.trimIndent(),
        englishCommentary = """
            O sacred blades of Kusha! You belong to Vishnu (the omnipresent Lord) and possess the great power to purify everything.
            Impelled by the Creator Savitar, I purify this water with this flawless (whole) sacred Kusha, resembling the bright rays of the Sun.
            O Goddesses of divine waters! You are the foremost to move (Agreguva) and the very first to purify (Agrepuva) all things.
            Today, lead this sacrifice of ours to the peak of perfection and keep the master of the sacrifice at the forefront of happiness and welfare.
            This mantra details the purification of water used in the sacrifice; without water, both life and rituals are completely impossible.
            Sun rays and water—these two are the main foundations of life on earth, hence they are worshipped as direct divine forces.
            The flawless Kusha symbolizes our 'unbroken meditation' and 'concentration'; self-purification happens only when the mind focuses without wandering.
            O Lord! Just as water washes away every physical impurity, wash away all the afflictions of our inner self and make us perfectly pure.
            In society, we should become leaders like water, paving the way for others and giving life to everyone without any discrimination.
            Through our noble deeds, may we reach that peak of fame and self-knowledge where only divine bliss permanently resides.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 13,
        sanskrit = "युष्मानिन्द्रोऽवृणीत वृत्रतूर्ये यूयमिन्द्रमवृणीध्वं वृत्रतूर्ये प्रोक्षिता स्थ ।\nअग्नये त्वा जुष्टं प्रोक्षाम्यग्नीषोमाभ्यां त्वा जुष्टं प्रोक्षामि ॥ १३ ॥",
        hindiCommentary = """
            वृत्रासुर (अज्ञान और अंधकार के प्रतीक) के वध के समय शक्तिशाली इंद्र ने तुम (जल की शक्तियों) का वरण किया था।
            और तुम सबने भी उस महासंग्राम में इंद्र का चुनाव कर उनका पूर्ण साथ दिया था; अब तुम भली-भांति प्रोक्षित (पवित्र) हो चुकी हो।
            मैं तुम्हें (इस हवि को) अग्नि देव की प्रसन्नता के लिए पवित्र जल से सींचता हूँ।
            और मैं तुम्हें अग्नि तथा सोम दोनों देवताओं की पूर्ण तृप्ति और प्रसन्नता के लिए अत्यंत श्रद्धापूर्वक संस्कारित करता हूँ।
            अज्ञान (वृत्र) से लड़ने के लिए देवताओं (इंद्र) को भी प्रकृति की शुद्ध शक्तियों (जल) की आवश्यकता होती है; यह प्रकृति और देवत्व का अद्भुत मिलन है।
            जब हम बुराई से लड़ते हैं, तो हमारा संकल्प इंद्र के समान कठोर और हमारा आचरण जल के समान अत्यंत पवित्र होना चाहिए।
            अग्नि (ऊर्जा/तेज) और सोम (शांति/शीतलता) का संतुलन ही संसार का मूल है; हमारा हर कर्म इन दोनों शक्तियों को संतुष्ट करने वाला होना चाहिए।
            हे परमात्मा! हमारे भीतर भी सत्य के लिए लड़ने का ऐसा ही साहस उत्पन्न करें जिससे हम अपने भीतर के 'वृत्र' को जड़ से समाप्त कर सकें।
            हमारा जीवन केवल भोग के लिए नहीं, बल्कि उस अग्नि और सोम को प्रसन्न करने के लिए हो, जो पूरी सृष्टि को जीवन देते हैं।
            यह मंत्र हमें सिखाता है कि एकता और पवित्रता के बल पर संसार की किसी भी आसुरी शक्ति या बड़ी से बड़ी बाधा को आसानी से परास्त किया जा सकता है।
        """.trimIndent(),
        englishCommentary = """
            During the slaying of Vritra (symbol of ignorance and darkness), the mighty Indra chose you (the powers of water).
            And all of you too chose Indra and fully supported him in that great battle; now you have been thoroughly consecrated (purified).
            I sprinkle you (this oblation) with holy water for the absolute pleasure and satisfaction of Lord Agni.
            And I consecrate you with utmost devotion for the complete fulfillment and joy of both the deities, Agni and Soma.
            To fight ignorance (Vritra), even gods (Indra) require the pure forces of nature (water); this is an amazing union of nature and divinity.
            When we fight against evil, our resolve must be as tough as Indra, and our conduct as supremely pure as water.
            The balance of Agni (energy/brilliance) and Soma (peace/coolness) is the root of the world; every action of ours should satisfy both these forces.
            O Supreme Lord! Generate such courage within us to fight for Truth so that we can completely uproot the 'Vritra' hidden inside us.
            Our life should not be merely for consumption, but to please that Agni and Soma which grant life to the entire creation.
            This mantra teaches us that on the strength of unity and purity, any demonic force or immense obstacle in the world can be easily defeated.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 14,
        sanskrit = "दैव्याय कर्मणे शुन्धध्वं देवयज्यायै यद्वोऽशुद्धाः पराजघ्नुरिदं वस्तच्छुन्धामि ।\nशर्मासि ॥ १४ ॥",
        hindiCommentary = """
            हे यज्ञ के उपकरणो और हविष्य! तुम इस ईश्वरीय और दिव्य कर्म के लिए पूरी तरह से शुद्ध और पावन हो जाओ।
            देवताओं के यजन (पूजन) के लिए, यदि किसी अशुद्ध वस्तु, स्पर्श या विचार ने तुम्हें अपवित्र किया है, तो मैं उसे अब पूरी तरह शुद्ध करता हूँ।
            तू 'शर्म' (सुख, शांति और परम शरण) प्रदान करने वाला साक्षात् स्वरूप है।
            यज्ञ में केवल बाहरी वस्तुओं की नहीं, बल्कि साधक की मानसिक अवस्था की शुद्धि पर भी अत्यधिक बल दिया गया है।
            संसार में रहते हुए जाने-अनजाने में अनेक अशुद्धियां हमें और हमारे कर्मों को छू लेती हैं; मंत्रों की शक्ति उन सभी दोषों को मिटा देती है।
            ईश्वर को अर्पित किया जाने वाला प्रत्येक कर्म पूर्णतः निष्कलंक होना चाहिए, क्योंकि अशुद्ध भावना से किया गया कर्म कभी भी देवों तक नहीं पहुँचता।
            'शर्म' का अर्थ है वह आध्यात्मिक सुख जो किसी भी भौतिक सफलता से कहीं अधिक स्थायी, गहरा और आनंददायी होता है।
            हे प्रभु! हमारे मन में जमे हुए ईर्ष्या, क्रोध और स्वार्थ के मैल को अपनी कृपा के जल से पूरी तरह धोकर हमें निर्मल बना दें।
            हम जो भी अनुष्ठान या सेवा का कार्य करें, वह केवल दिखावा न हो, बल्कि उसमें हमारे हृदय की सच्ची पवित्रता और ईश्वर का प्रेम झलकता हो।
            यह मंत्र हमें हर नए कर्म को आरंभ करने से पहले अपने विचारों की समीक्षा करने और उन्हें ईश्वरीय स्तर तक उठाने की महान प्रेरणा देता है।
        """.trimIndent(),
        englishCommentary = """
            O sacrificial implements and oblations! Become completely pure and holy for this divine and Godly task.
            For the worship of the gods, if any impure object, touch, or thought has defiled you, I now purify you completely from it.
            You are the direct embodiment of 'Sharma' (giver of joy, profound peace, and ultimate refuge).
            In the sacrifice, immense emphasis is placed not just on the purity of external objects, but also on the mental state of the seeker.
            While living in the world, knowingly or unknowingly, many impurities touch us and our actions; the power of mantras erases all those flaws.
            Every action offered to God must be completely flawless, because an action done with impure feelings never reaches the divine beings.
            'Sharma' means that spiritual joy which is far more permanent, deep, and blissful than any material success in the world.
            O Lord! Completely wash away the dirt of jealousy, anger, and selfishness accumulated in our minds with the water of Your grace.
            Whatever ritual or service we perform, let it not be a mere show, but let it reflect the true purity of our heart and love for God.
            This mantra deeply inspires us to review our thoughts before starting any new deed and elevate them to a purely divine level.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 15,
        sanskrit = "अवधूतं रक्षोऽवधूता अरातयोऽदित्यास्त्वृगसि प्रति त्वाऽदितिर्वेत्तु ।\nधिषणासि पर्वती प्रति त्वाऽदितिर्वेत्तु ॥ १५ ॥",
        hindiCommentary = """
            विघ्न डालने वाले राक्षसों (बुराइयों) को पूरी तरह से झटक कर दूर कर दिया गया है; अराति (कृपणता और शत्रुता) भी दूर फेंक दी गई है।
            हे यज्ञपात्र! तू माता अदिति (अखंड पृथ्वी/ईश्वरीय सत्ता) की त्वचा (अंग) है; माता अदिति तुझे अत्यंत प्रेम और वात्सल्य के साथ स्वीकार करें।
            तू पर्वतों के समान अत्यंत दृढ़ और ज्ञानमयी 'धिषणा' (बुद्धि या आधार) है; माता अदिति तुझे अपनी शरण में ग्रहण करें।
            बुराइयों को 'अवधूत' (झटकना) करने का अर्थ है कि जैसे कपड़े से धूल झटकी जाती है, वैसे ही मन से नकारात्मक विचारों को तुरंत बाहर निकाल देना चाहिए।
            जब तक मन में शत्रुता (अराति) है, तब तक कोई भी आध्यात्मिक साधना ईश्वर (अदिति) तक नहीं पहुँच सकती।
            'धिषणा पर्वती' का अर्थ है वह बुद्धि जो पर्वत की तरह अटल हो; जब हमारा ज्ञान और संकल्प मजबूत होता है, तभी हम धर्म पर टिक पाते हैं।
            साधक मानता है कि यज्ञ के सभी उपकरण प्रकृति (अदिति) का ही हिस्सा हैं, और अंततः सब कुछ उसी अखंड सत्ता में समाहित होना है।
            हे परमात्मा! हमें ऐसा दृढ़ संकल्प दें कि संसार का कोई भी आकर्षण या भय हमारी बुद्धि (धिषणा) को सत्य के मार्ग से कभी भी डिगा न सके।
            हम प्रकृति के प्रति अत्यंत कृतज्ञ रहें, क्योंकि हमारा शरीर और हमारे सभी साधन उसी परम माता के अंश से ही निर्मित हुए हैं।
            हमारा जीवन भी पर्वत के समान विशाल और अचल बने, जो आंधियों में भी स्थिर रहे और दूसरों को हमेशा सुरक्षित आश्रय प्रदान करे।
        """.trimIndent(),
        englishCommentary = """
            The obstacle-creating demons (evils) have been thoroughly shaken off and cast away; Arati (miserliness and enmity) has also been thrown far away.
            O Sacrificial Vessel! You are the skin (part) of Mother Aditi (the unbroken Earth/Divine Reality); may Mother Aditi accept you with great love.
            You are 'Dhishana' (intellect or foundation), extremely firm and full of knowledge like the mountains; may Mother Aditi accept you in her refuge.
            'Shaking off' evils means that just as dust is dusted off clothes, negative thoughts must be immediately cast out from the mind.
            As long as there is enmity (Arati) in the mind, no spiritual practice can ever reach God (Aditi).
            'Dhishana Parvati' means that intellect which is unwavering like a mountain; only when our knowledge is strong can we stand firm on Dharma.
            The seeker believes all tools are part of Nature (Aditi), and ultimately everything must merge back into that Boundless Reality.
            O Supreme Lord! Grant us such firm resolve that no worldly attraction or fear can ever sway our intellect (Dhishana) from the path of Truth.
            Let us remain deeply grateful to Nature, because our bodies and all our resources are created solely from the parts of that Supreme Mother.
            May our life also become vast and immovable like a mountain, staying stable in storms and always providing safe refuge to others.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 16,
        sanskrit = "धिषणासि पार्वतेयी प्रति त्वाऽदितिर्वेत्तु ।\nदेवस्य त्वा सवितुः प्रसवेऽश्विनोर्बाहुभ्यां पूष्णो हस्ताभ्यामभिषुणोमि ॥ १६ ॥",
        hindiCommentary = """
            तू पर्वतों से उत्पन्न अत्यंत दृढ़ और ज्ञानमयी 'धिषणा' (पीसने वाला पत्थर/बुद्धि) है; माता अदिति तुझे अपने वात्सल्यपूर्ण आश्रय में स्वीकार करें।
            सृष्टिकर्ता सविता देव की पावन प्रेरणा से, अश्विनीकुमारों की बलशाली भुजाओं से और पूषा देव के मजबूत हाथों से मैं हवि को पीसता (तैयार करता) हूँ।
            यज्ञ में अन्न को पीसने वाले पत्थरों को 'धिषणा' (बुद्धि) कहा गया है; जिस प्रकार पत्थर अन्न को पीसकर योग्य बनाता है, वैसे ही बुद्धि हमारे विचारों को परिष्कृत करती है।
            कोई भी कर्म करते समय हमें अपनी व्यक्तिगत शक्ति पर अहंकार नहीं करना चाहिए; हमारे हाथों में देवताओं की ही शक्ति कार्य कर रही है।
            अश्विनीकुमार प्राण और आरोग्य के देव हैं, और पूषा पोषण के देव हैं; अतः हमारा कर्म भी समाज को आरोग्य और उत्तम पोषण देने वाला होना चाहिए।
            सविता की प्रेरणा यह दर्शाती है कि जब परमात्मा की इच्छा होती है, तभी हमारे हाथों से कोई भी श्रेष्ठ या कल्याणकारी कार्य संपन्न हो पाता है।
            हे देव! हमारी बुद्धि को पर्वतों की तरह अटल बनाएं ताकि हम सांसारिक कठिनाइयों में कभी भी विचलित न हों और धर्म पर डटे रहें।
            अपने भीतर के अहंकार और अज्ञान को उसी प्रकार पीस डालना चाहिए जिस प्रकार यह पत्थर हविष्य को पीसकर यज्ञ के लिए अत्यंत योग्य और मुलायम बना देता है।
            जब कर्म ईश्वर को समर्पित हो जाता है, तो साधारण पीसने का कार्य भी एक महान और पावन आध्यात्मिक अनुष्ठान में परिवर्तित हो जाता है।
            हम जो भी ज्ञान अर्जित करें, वह केवल हमारे लिए न हो, बल्कि उससे पूरे समाज और मानवता का सतत कल्याण और मार्गदर्शन हो।
        """.trimIndent(),
        englishCommentary = """
            You are 'Dhishana' (grinding stone/intellect) born of the mountains, extremely firm and wise; may Mother Aditi accept you in her affectionate refuge.
            Impelled by the Creator Savitar, with the strong arms of the Ashvins, and with the firm hands of Pushan, I grind (prepare) the oblation.
            The stones grinding the grain in the sacrifice are called 'Dhishana' (intellect); just as the stone grinds the grain making it fit, intellect refines our thoughts.
            While doing any deed, we should not have ego about our personal strength; it is actually the power of the gods working through our hands.
            The Ashvins are gods of vitality and health, and Pushan is the god of nourishment; hence our actions should provide health and nourishment to society.
            Savitar's inspiration shows that only when it is the Supreme Lord's will, can any noble or beneficial act be accomplished by our hands.
            O God! Make our intellect unwavering like the mountains so that we never get distracted in worldly difficulties and stand firm on Dharma.
            One must grind down their inner ego and ignorance just as this stone grinds the oblation, making it extremely fit and soft for the sacrifice.
            When an action is surrendered to God, even an ordinary task of grinding transforms entirely into a great and holy spiritual ritual.
            Whatever knowledge we acquire, let it not be just for us, but let it lead to the continuous welfare and guidance of the entire society and humanity.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 17,
        sanskrit = "अग्नेर्हव्यवाहनस्य धर्त्रमसि ।\nपवित्रे स्थो वैष्णव्यौ सवितुर्वः प्रसव उत्पुनाम्यच्छिद्रेण पवित्रेण सूर्यस्य रश्मिभिः ॥ १७ ॥",
        hindiCommentary = """
            हे यज्ञ के उपकरण (सूप या छाज)! तू देवों तक हवि ले जाने वाले अग्निदेव का आधार और उन्हें धारण करने वाला महान साधन है।
            हे कुशा के दलो! तुम विष्णु से संबंधित और पवित्र करने वाले हो; सविता देव की प्रेरणा से, छिद्ररहित कुशा और सूर्य की रश्मियों से मैं तुम्हें शुद्ध करता हूँ।
            यज्ञ में अन्न को फटकने (साफ करने) वाले सूप को यहाँ देवों के निमित्त अत्यंत महत्वपूर्ण माना गया है, क्योंकि वह अन्न से अशुद्धियों को अलग करता है।
            आध्यात्मिक जीवन में यह हमारी 'विवेक बुद्धि' का प्रतीक है, जो सत्य और असत्य, अच्छे और बुरे को एक-दूसरे से पूरी तरह अलग कर देती है।
            अग्नि हवि को स्वर्ग तक ले जाती है, परंतु अग्नि तक पहुँचने से पूर्व हवि को शुद्ध होना ही चाहिए; यह हमारी आंतरिक शुद्धि की प्रक्रिया है।
            विष्णु सर्वव्यापी हैं; जब हम कुशा से पवित्रीकरण करते हैं, तो हम वास्तव में स्वयं को उस असीम विष्णु की चेतना से जोड़ रहे होते हैं।
            हे प्रभु! हमारे मन में ऐसा तीक्ष्ण विवेक उत्पन्न करें कि हम अपने भीतर के दुर्गुणों को उसी प्रकार फटक कर बाहर कर दें जैसे सूप भूसी को कर देता है।
            सूर्य की किरणें जैसे संपूर्ण जगत के अंधकार को नष्ट कर देती हैं, वैसे ही आपका ईश्वरीय ज्ञान हमारे अज्ञान के पर्दों को हमेशा के लिए जला दे।
            हमारा जीवन ऐसा निर्मल हो जाए कि हमारा हर कर्म अग्निदेव के माध्यम से सीधे आपके श्रीचरणों में एक पावन आहुति बनकर स्वीकार हो।
            जो व्यक्ति स्वयं को छिद्ररहित (पूर्णतः एकाग्र) कर लेता है, वही ईश्वर की अनंत प्रेरणा और कृपा को प्राप्त करने का वास्तविक अधिकारी बनता है।
        """.trimIndent(),
        englishCommentary = """
            O sacrificial implement (winnowing basket)! You are the foundation and supporter of Agni, the carrier of oblations to the divine gods.
            O blades of Kusha! You belong to Vishnu and are purifiers; impelled by Savitar, I purify you with the flawless Kusha and the sun's bright rays.
            The winnowing basket that cleans the grain in the sacrifice is considered extremely important for the gods, as it separates impurities from the grain.
            In spiritual life, this is the symbol of our 'discriminating intellect', which completely separates truth from untruth, and good from bad.
            Agni carries the oblation to heaven, but before reaching Agni, the oblation must be pure; this represents our internal purification process.
            Vishnu is omnipresent; when we purify with Kusha, we are actually connecting ourselves directly with the consciousness of that infinite Vishnu.
            O Lord! Generate such sharp discrimination in our minds that we winnow out our inner flaws just as the basket throws out the husk.
            Just as the sun's rays destroy the darkness of the entire world, may Your divine knowledge burn away the veils of our ignorance forever.
            May our lives become so pure that every action of ours is accepted directly at Your holy feet as a sacred oblation through Lord Agni.
            The person who makes himself flawless (completely concentrated) becomes the true recipient capable of receiving God's infinite inspiration and grace.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 18,
        sanskrit = "देवो वः सविताोत्पुनात्वच्छिद्रेण पवित्रेण सूर्यस्य रश्मिभिः ।\nआप्यायन्तामाप ओषधयो मरुतां पृषतयः स्थ दिवं गच्छत ततो नो वृष्टिमेरयत ॥ १८ ॥",
        hindiCommentary = """
            सृष्टिकर्ता सविता देव तुम्हें छिद्ररहित पवित्र कुशा और सूर्य की अत्यंत उज्ज्वल किरणों से भली-भांति शुद्ध और पावन करें।
            हे जल और औषधियो! तुम पुष्ट होओ; हे फटके हुए अन्न के कणो! तुम मरुद्गणों (वायु देवों) की जल-बिंदुओं के समान हो।
            तुम यहाँ से स्वर्गलोक को जाओ और वहाँ पहुँचकर हमारे लिए, इस पृथ्वी और संपूर्ण मानवता के लिए प्रचुर मात्रा में वृष्टि (वर्षा) लाओ।
            यह मंत्र स्पष्ट करता है कि यज्ञ केवल देवताओं के लिए नहीं, बल्कि पृथ्वी पर वर्षा, अन्न और पर्यावरण के संपूर्ण संतुलन के लिए किया जाता है।
            जब हम पृथ्वी के शुद्ध संसाधनों को अग्नि के माध्यम से अंतरिक्ष में भेजते हैं, तो प्रकृति उसे कई गुना बढ़ाकर वर्षा के रूप में हमें लौटा देती है।
            यह 'पारस्परिक पोषण' का महान वैदिक सिद्धांत है: हम प्रकृति को पुष्ट करें, प्रकृति हमें पुष्ट करेगी ("देवान्भावयतानेन ते देवा भावयन्तु वः")।
            अन्न के कणों को वायु की बूंदें मानना इस बात का प्रतीक है कि हमारा छोटा सा प्रयास भी ब्रह्मांडीय शक्तियों में मिलकर एक विराट परिणाम ला सकता है।
            हे परमात्मा! हमारे समाज में ऐसा निःस्वार्थ त्याग और सेवा भाव उत्पन्न हो कि हमारा हर कार्य पूरे संसार के लिए एक सुखद वर्षा (वरदान) बन जाए।
            जैसे वर्षा सूखी धरती को नवजीवन देती है, वैसे ही आपका ज्ञान हमारे शुष्क हृदयों में भक्ति और प्रेम की नई कोंपलें निरंतर खिलाता रहे।
            हम जो भी ईश्वर को अर्पण करें, वह स्वार्थरहित हो, ताकि उसकी प्रतिध्वनि स्वर्ग तक जाए और सम्पूर्ण मानवता के सुख-शांति का कारण बने।
        """.trimIndent(),
        englishCommentary = """
            May the Creator Savitar thoroughly purify and sanctify you with the flawless sacred Kusha and the extremely bright rays of the sun.
            O Waters and Herbs! May you flourish; O winnowed grains of food! You are like the water drops of the Maruts (Wind Gods).
            Go from here to the heavenly realms, and having reached there, bring forth abundant rain for us, this earth, and all of humanity.
            This mantra clarifies that a sacrifice is not just for gods, but for rain, food, and the absolute balance of the environment on earth.
            When we send earth's pure resources into space via Agni, Nature multiplies them and returns them to us in the form of life-giving rain.
            This is the great Vedic principle of 'mutual nourishment': we nourish nature, and nature will nourish us ("Devanbhavayatanena...").
            Considering food grains as wind drops symbolizes that even our small effort, merging with cosmic forces, can bring a massive, great result.
            O Supreme Lord! Generate such selfless sacrifice and service in society that every action of ours becomes a joyful rain (blessing) for the world.
            Just as rain gives new life to dry earth, may Your knowledge continuously sprout new buds of devotion and pure love in our dry hearts.
            Whatever we offer to God, let it be selfless, so its echo reaches heaven and becomes the ultimate cause of happiness and peace for all humanity.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 19,
        sanskrit = "आयुषे प्राणाय व्यानायोदानाय ।\nप्रति त्वाऽदितिर्वेत्तु महतीनामसि स्रुवाणां पात्रे ॥ १९ ॥",
        hindiCommentary = """
            हे हवि! मैं तुम्हें अपनी आयु की वृद्धि के लिए, श्वास (प्राण) के लिए, संपूर्ण शरीर में व्याप्त वायु (व्यान) के लिए और ऊर्ध्व वायु (उदान) की पुष्टि के लिए अलग करता हूँ।
            माता अदिति (अखंड पृथ्वी/प्रकृति) तुझे अत्यंत प्रेम से अपनी शरण में स्वीकार करें; तू महान स्रुवाओं (यज्ञपात्रों) का श्रेष्ठ और मुख्य आधार है।
            मनुष्य का जीवन प्राणवायु पर ही निर्भर है; यज्ञ का एक मुख्य उद्देश्य पर्यावरण को शुद्ध कर प्राणवायु (ऑक्सीजन) को अत्यंत स्वच्छ और जीवनदायी बनाना है।
            प्राण, व्यान और उदान शरीर की प्रमुख ऊर्जाएं हैं; जब ये संतुलित होती हैं, तभी मनुष्य पूर्णतः स्वस्थ रहकर दीर्घायु को प्राप्त करता है।
            अदिति द्वारा हवि को स्वीकार करने का अर्थ है कि हमारा अन्न और कर्म प्रकृति के नियमों के सर्वथा अनुकूल होना चाहिए, विरुद्ध नहीं।
            हम जो भी भोजन करें या हवि दें, वह सात्विक हो ताकि वह हमारे शरीर की सभी शक्तियों को सही और उचित पोषण प्रदान कर सके।
            हे प्रभु! हमें ऐसा उत्तम स्वास्थ्य और ऊर्जा दें कि हम अपनी पूरी आयु धर्म और परोपकार के श्रेष्ठ कार्यों में ही व्यतीत करें।
            प्रकृति ही हमारी असली माता (अदिति) है, जब हम उसके प्रति सम्मान और कृतज्ञता दिखाते हैं, तो वह हमारी रक्षा अपने अंगों की तरह करती है।
            हमारा शरीर भी एक यज्ञपात्र है; इसमें केवल शुद्ध और सात्विक विचारों की ही आहुति पड़नी चाहिए ताकि आध्यात्मिक ऊर्जा का संचार हो।
            संसार की सभी महान शक्तियां आपस में जुड़ी हुई हैं; जब हम प्रकृति का पोषण करते हैं, तो प्रकृति स्वतः ही हमारे प्राणों की निरंतर रक्षा करती है।
        """.trimIndent(),
        englishCommentary = """
            O Oblation! I separate you for the increase of my life-span, for the vital breath (Prana), for the pervading breath (Vyana), and the upward breath (Udana).
            May Mother Aditi (the unbroken Earth/Nature) accept you in her refuge with immense love; you are the chief foundation of the great sacrificial spoons.
            Human life depends entirely on the vital breath; a main purpose of sacrifice is to purify the environment and make the air highly clean and life-giving.
            Prana, Vyana, and Udana are the major energies of the body; when they are balanced, only then does a person stay perfectly healthy and attain longevity.
            Aditi accepting the oblation means that our food and actions must be absolutely favorable to the laws of nature, never against them.
            Whatever food we eat or oblation we give, let it be pure (Sattvic) so that it can provide correct and proper nourishment to all bodily powers.
            O Lord! Grant us such excellent health and energy that we spend our entire life-span performing great deeds of Dharma and benevolence.
            Nature is our real mother (Aditi); when we show respect and gratitude towards her, she protects us exactly like her own limbs.
            Our body is also a sacrificial vessel; only pure and virtuous thoughts should be offered into it so that spiritual energy circulates continuously.
            All great forces of the world are interconnected; when we nourish nature, nature automatically and continuously protects our vital breaths.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 20,
        sanskrit = "अन्तरितं रक्षोऽन्तरिता अरातयोऽदित्यास्त्वृगसि ।\nअग्नेस्तेजसा सूर्यस्य वर्चसा ॥ २० ॥",
        hindiCommentary = """
            (विघ्ननाश का पुनः दृढ़ संकल्प) विघ्न डालने वाले राक्षसों को पूरी तरह से दूर कर दिया गया है; कंजूसी और शत्रुता के विचारों (अराति) को भी नष्ट कर दिया गया है।
            हे हवि! तू माता अदिति (अखंड सत्ता) की त्वचा (अंग) है। मैं अग्नि के अत्यंत प्रखर तेज और भगवान सूर्य के महान प्रकाश से इन बुराइयों को भस्म करता हूँ।
            आध्यात्मिक मार्ग पर विघ्नों का बार-बार आना स्वाभाविक है; इसलिए वैदिक ऋषियों ने बार-बार आत्म-सजगता और शुद्धि के इन मंत्रों का विधान किया है।
            अग्नि का तेज हमारे भीतर के संकल्प की दृढ़ता है, और सूर्य का प्रकाश हमारे ज्ञान और विवेक का साक्षात् प्रतीक है।
            जब साधक के पास ज्ञान और दृढ़ संकल्प दोनों होते हैं, तो संसार की कोई भी नकारात्मक शक्ति (राक्षस या अराति) उसे कभी भी हरा नहीं सकती।
            संसार के सभी पदार्थ प्रकृति (अदिति) के ही रूप हैं; उन्हें अशुद्ध विचारों से बचाकर रखना हमारा सबसे बड़ा और पहला परम कर्तव्य है।
            हे परमात्मा! हमारे मन में सूर्य के समान प्रकाश भर दें ताकि ईर्ष्या और अज्ञान का अंधकार हमारे आस-पास भी फटकने का साहस न करे।
            शत्रुता (अराति) मनुष्य को भीतर से खोखला कर देती है; आपका प्रेम ही वह अग्नि है जो इस शत्रुता को जलाकर राख कर सकती है।
            हम स्वयं को ईश्वरीय शक्तियों से पूरी तरह सुरक्षित महसूस करें और निर्भय होकर सत्य, न्याय और मानवता के मार्ग पर निरंतर आगे बढ़ते रहें।
            हमारा पूरा जीवन अग्नि की तरह ऊर्जावान और सूर्य की तरह सबको समान रूप से प्रकाश और जीवन देने वाला अत्यंत परोपकारी बन जाए।
        """.trimIndent(),
        englishCommentary = """
            (Firm resolution for destroying obstacles) Obstacle-creating demons have been completely removed; thoughts of miserliness and enmity (Arati) are also destroyed.
            O Oblation! You are the skin (part) of Mother Aditi (Boundless Reality). I burn these evils with the fierce brilliance of Agni and the great light of the Sun.
            The repeated arrival of obstacles is natural on the spiritual path; hence Vedic sages prescribed these mantras of self-awareness and purity repeatedly.
            The brilliance of Agni is the firmness of our inner resolve, and the light of the Sun is the direct symbol of our knowledge and discernment.
            When a seeker possesses both knowledge and firm resolution, no negative force (demon or Arati) of the world can ever defeat them.
            All materials of the world are forms of Nature (Aditi); protecting them from impure thoughts is our greatest and first supreme duty.
            O Supreme Lord! Fill our minds with light like the Sun so that the darkness of jealousy and ignorance never even dares to come near us.
            Enmity (Arati) hollows out a person from within; Your pure love is the only fire that can burn this enmity completely to ashes.
            Let us feel entirely secure with divine forces and move continuously forward on the path of truth, justice, and humanity fearlessly.
            May our entire life become energetic like Agni and highly benevolent like the Sun, giving light and life equally to absolutely everyone.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 21,
        sanskrit = "शर्मासि ।\nअदित्यास्त्वोपस्थे सादयामि ॥ २१ ॥",
        hindiCommentary = """
            हे यज्ञपात्र (या हवि)! तू सुख, शांति और परम शरण (शर्म) का साक्षात् स्वरूप है।
            मैं तुझे माता अदिति (अखंड और विशाल पृथ्वी/ईश्वरीय सत्ता) की अत्यंत पवित्र और वात्सल्यमयी गोद में आदरपूर्वक स्थापित करता हूँ।
            जब मनुष्य अपने सभी कर्मों और साधनों को ईश्वर की गोद में समर्पित कर देता है, तो उसे एक ऐसी शांति (शर्म) मिलती है जिसे संसार नहीं दे सकता।
            अदिति की गोद में बैठने का अर्थ है स्वयं को प्रकृति और परमात्मा के नियमों के सर्वथा अनुकूल बना लेना और सारे भयों से मुक्त हो जाना।
            भौतिक वस्तुएं तभी सुखदायी होती हैं जब उन्हें ईश्वरीय प्रसाद मानकर और अत्यंत पवित्र भावनाओं के साथ उपयोग में लाया जाता है।
            साधक का अहंकार यहाँ पूरी तरह से समाप्त हो जाता है; वह अनुभव करता है कि वह कुछ भी नहीं है, केवल एक शिशु है जो अपनी माता की शरण में है।
            हे प्रभु! हमें भी अपने चरणों की वह शीतल छाया प्रदान करें जहाँ संसार के सभी दुखों, चिंताओं और तनावों का पूर्णतः अंत हो जाता है।
            हमारा मन एक ऐसा पवित्र पात्र बन जाए जिसमें केवल आपके नाम और निस्वार्थ प्रेम की हवि ही हमेशा के लिए स्थापित हो।
            जो व्यक्ति प्रकृति का सम्मान करता है और अपनी जड़ों से जुड़ा रहता है, वह जीवन के हर तूफान में एक मजबूत वृक्ष की तरह स्थिर रहता है।
            हमारा जीवन दूसरों के लिए 'शर्म' (शरण और सुख) बन जाए, ताकि जो भी दुखी हृदय हमारे पास आए, वह शांत और आनंदित होकर ही लौटे।
        """.trimIndent(),
        englishCommentary = """
            O Sacrificial Vessel (or oblation)! You are the direct embodiment of joy, peace, and ultimate refuge (Sharma).
            I respectfully place you into the highly sacred and affectionate lap of Mother Aditi (the unbroken and vast Earth/Divine Reality).
            When a human surrenders all their actions and resources into the lap of God, they attain a peace (Sharma) that the world can never give.
            Sitting in Aditi's lap means aligning oneself completely with the laws of nature and the Supreme Soul, becoming free from all fears.
            Material objects become sources of joy only when they are used as divine grace and with extremely pure and holy feelings.
            The ego of the seeker ends completely here; they realize they are nothing, just an innocent infant in the ultimate refuge of their mother.
            O Lord! Grant us that cool shade of Your holy feet where all the sorrows, worries, and tensions of the world come to an absolute end.
            May our mind become such a pure vessel in which only the oblation of Your name and selfless love is permanently established forever.
            A person who respects nature and stays connected to their roots remains stable like a strong tree in every single storm of life.
            May our life become a 'Sharma' (refuge and joy) for others, so that any sorrowful heart that comes to us returns completely peaceful and blissful.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 22,
        sanskrit = "अग्नेर्वेपेन त्वा गृह्णामि मखस्य शिरोऽसि ।\nसम्पृच्यध्वमृतावरीरूर्मिणीर्मधुमत्तमाः ॥ २२ ॥",
        hindiCommentary = """
            (मंत्र की पुनरावृत्ति) हे हवि! मैं तुम्हें अग्नि के तीव्र तेज और कंपन (आध्यात्मिक प्रेरणा) के साथ ग्रहण करता हूँ; तुम इस महान यज्ञ के मस्तक हो।
            हे जल की पावन धाराओं! तुम सत्य (ऋत) से युक्त, लहरों वाली और अत्यंत मधुर हो; तुम सब एक साथ भली-भांति मिलकर इस अनुष्ठान को सफल बनाओ।
            अग्नि का कंपन उस आंतरिक उत्साह और ईश्वरीय प्रेरणा का प्रतीक है जो हमारे हर शुभ कर्म का मूल कारण और शक्ति होती है।
            हवि को यज्ञ का मस्तक मानने का अर्थ है कि हमारा कर्म सर्वोच्च गुणवत्ता वाला और पूर्णतः दोषरहित होना चाहिए, क्योंकि वह ईश्वर को अर्पित हो रहा है।
            विभिन्न जल-धाराओं का मिलना समाज के विभिन्न वर्गों की एकता और प्रेम का अत्यंत सुंदर और प्रत्यक्ष उदाहरण है।
            जब लोग सत्य (ऋत) के मार्ग पर चलकर मधुरता से एक-दूसरे से जुड़ते हैं, तो वह समाज किसी भी महायज्ञ से कम शक्तिशाली नहीं होता।
            हे परमात्मा! हमारे विचारों में अग्नि जैसा तेज और हमारे व्यवहार में जल जैसी अद्भुत शीतलता तथा सबको साथ लेकर चलने की क्षमता हो।
            हमारे संकल्प इतने ऊँचे हों कि वे हमारे जीवन रूपी यज्ञ के मुकुट बन जाएं और हमें हमेशा धर्म और न्याय की सही राह दिखाएं।
            मधुरता (मधुमत्तमा) के बिना कोई भी शक्ति या संगठन लंबे समय तक नहीं टिक सकता; प्रेम ही वह तत्व है जो सबको बांध कर रखता है।
            हम प्रार्थना करते हैं कि हमारे सम्मिलित और निष्काम प्रयासों से इस पृथ्वी पर स्वर्ग जैसी शांति और देवत्व का अवतरण हो।
        """.trimIndent(),
        englishCommentary = """
            (Repetition of mantra) O Oblation! I accept you with the intense brilliance and vibration (spiritual inspiration) of Agni; you are the head of this great sacrifice.
            O sacred streams of water! You are endowed with truth (Rta), wavy, and exceedingly sweet; all of you mingle well together to make this ritual successful.
            The vibration of Agni symbolizes that internal enthusiasm and divine inspiration which is the root cause and power of every noble deed.
            Considering the oblation as the head of the sacrifice means our action must be of the highest quality and flawless, as it is offered to God.
            The mingling of various water streams is an extremely beautiful and direct example of the unity and love among different sections of society.
            When people connect with each other sweetly while walking on the path of truth (Rta), that society is no less powerful than any grand sacrifice.
            O Supreme Lord! Let there be brilliance like Agni in our thoughts, and in our behavior, amazing coolness like water and the ability to unite everyone.
            May our resolutions be so high that they become the crown of our life's sacrifice and always show us the correct path of Dharma and justice.
            No power or organization can last long without sweetness (Madhumattama); pure love is the only element that binds absolutely everyone together.
            We pray that through our united and selfless efforts, heaven-like peace and divinity may directly descend upon this beautiful earth.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 23,
        sanskrit = "मखस्य शिरोऽसि ।\nसं त्वा सिञ्चामि यजुषा प्रजामैश्वर्यं च ॥ २३ ॥",
        hindiCommentary = """
            (मंत्र की पुनरावृत्ति) तू इस महान यज्ञ का मस्तक (शिर) है।
            मैं इन पवित्र यजुर्मंत्रों की शक्ति से तुझे भली-भांति सींचता हूँ, ताकि तू हमें उत्तम प्रजा (संतान/नागरिक) और महान ऐश्वर्य (समृद्धि) प्रदान कर सके।
            यह मंत्र स्पष्ट करता है कि वैदिक यज्ञ केवल संन्यासियों के लिए नहीं, बल्कि गृहस्थों के जीवन को समृद्ध और खुशहाल बनाने का भी एक मार्ग है।
            यज्ञ का शिर होने का अर्थ है कि हमारे सभी संकल्प और कार्य पूरी तरह से विवेकपूर्ण और बुद्धिमानी से भरे होने चाहिए।
            'सिंचन' का अर्थ है अपने मन और बुद्धि को ईश्वरीय ज्ञान से भिगोना; जैसे पौधे को जल सींचता है, वैसे ही मंत्र हमारी आत्मा को सींचते हैं।
            धर्म के मार्ग पर चलते हुए ऐश्वर्य और अच्छी संतान की कामना करना वैदिक दृष्टि में अत्यंत पवित्र और समाज के लिए आवश्यक माना गया है।
            हे प्रभु! हमारी बुद्धि को यजुर्वेद के पावन ज्ञान से ऐसा सींच दें कि उसमें कभी भी अज्ञान और अहंकार रूपी विषैले खरपतवार न उगने पाएं।
            हम जो भी धन या ऐश्वर्य प्राप्त करें, उसका उपयोग केवल अपने स्वार्थ के लिए नहीं, बल्कि पूरे समाज के उत्थान और मंगल के लिए हो।
            उत्तम प्रजा का अर्थ एक ऐसी नई पीढ़ी का निर्माण करना है जो सत्य, धर्म और न्याय के मार्ग पर चलकर राष्ट्र को परम वैभव तक ले जाए।
            हमारा जीवन इस यज्ञ के समान ऐसा उन्नत और विशाल हो कि हम आने वाली पीढ़ियों के लिए एक महान आदर्श और अत्यंत समृद्ध भविष्य छोड़ सकें।
        """.trimIndent(),
        englishCommentary = """
            (Repetition of mantra) You are the head (Murdha) of this great sacrifice.
            I thoroughly sprinkle (consecrate) you with the power of these holy Yajur mantras, so that you may grant us excellent progeny and great prosperity.
            This mantra clarifies that a Vedic sacrifice is not just for ascetics, but also a path to make the lives of householders highly prosperous and happy.
            Being the head of the sacrifice means that all our resolutions and actions must be completely filled with discernment and profound wisdom.
            'Sprinkling' means soaking our mind and intellect with divine knowledge; just as water irrigates a plant, mantras irrigate our human soul.
            Desiring wealth and good offspring while walking on the path of Dharma is considered extremely holy and essential for society in the Vedic vision.
            O Lord! Irrigate our intellect with the holy knowledge of Yajurveda so that poisonous weeds of ignorance and ego may never sprout within it.
            Whatever wealth or prosperity we acquire, let it be used not just for our selfishness, but for the upliftment and absolute welfare of the whole society.
            Excellent progeny means building a new generation that walks on the path of truth, Dharma, and justice, taking the nation to ultimate glory.
            May our life be as elevated and vast as this sacrifice, so we can leave behind a great ideal and an extremely prosperous future for coming generations.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 24,
        sanskrit = "घृतवतोर्मिणा मधुमता सम्प्रच्यध्वम् ।\nअपहतोऽररुः पृथिव्यै ॥ २४ ॥",
        hindiCommentary = """
            (मंत्र की पुनरावृत्ति) हे जल की धाराओं! तुम घृत (घी) के समान अत्यंत स्निग्ध और मधुरता से भरी हुई तरंगों के साथ एक-दूसरे में भली-भांति मिल जाओ।
            इस पवित्र पृथ्वी से अररु (विघ्नकर्ता दानव या नकारात्मक विचार) को पूरी तरह से नष्ट कर दिया गया है और बहुत दूर धकेल दिया गया है।
            जल और घी का यह संगम हमारे जीवन में कठोरता का त्याग कर कोमलता, प्रेम और पुष्टि अपनाने का एक अत्यंत सुंदर और महान संदेश है।
            जब समाज के विभिन्न लोग और समुदाय बिना किसी कटुता के आपस में प्रेम से मिलते हैं, तो वह समाज वास्तव में अत्यंत शक्तिशाली हो जाता है।
            अररु वह असुर है जो हमारे मन के भीतर ईर्ष्या, क्रोध और नफरत पैदा करता है; उसे अपने मन से बाहर निकालना ही सबसे सच्ची आध्यात्मिक विजय है।
            पृथ्वी हमारी कर्मभूमि है; यदि यह नकारात्मकताओं से मुक्त होगी, तभी हमारे सभी शुभ संकल्प और कार्य सफलतापूर्वक अपने फल को प्राप्त कर सकेंगे।
            हे परमात्मा! हमारे आपसी संबंधों में घी के समान स्निग्धता हो ताकि मनमुटाव का कोई भी घर्षण हमारे प्रेम के बंधन को कभी भी तोड़ न सके।
            विघ्नों का वास्तविक नाश बाहरी हथियारों से नहीं, बल्कि हमारे भीतर की एकता और पवित्र विचारों की शक्ति से ही संभव है।
            हम अपने कार्यस्थल और परिवार को ऐसा पवित्र बनाएं कि वहां बुराइयां प्रवेश करने का साहस ही न कर सकें और केवल सकारात्मक ऊर्जा का वास हो।
            मधुरता और निस्वार्थ प्रेम की धारा जब बहती है, तो वह सबसे कठोर और पाषाण हृदय को भी पिघलाकर ईश्वर की ओर मोड़ने की अद्भुत सामर्थ्य रखती है।
        """.trimIndent(),
        englishCommentary = """
            (Repetition of mantra) O streams of water! Mingle well with one another with waves that are as extremely smooth as Ghee and fully saturated with sweetness.
            The Araru (obstacle-creating demon or negative thoughts) has been completely destroyed and pushed far away from this holy earth.
            This confluence of water and Ghee is an extremely beautiful and great message to abandon harshness and adopt gentleness, love, and nourishment in life.
            When various people and communities of society meet each other with love and without bitterness, that society truly becomes incredibly powerful.
            Araru is the demon that creates envy, anger, and hatred within our minds; expelling him from our mind is the truest spiritual victory.
            The earth is our field of action; if it is free from negativities, only then can all our auspicious resolutions and actions successfully bear their fruits.
            O Supreme Lord! May our mutual relationships have the smoothness of Ghee so that no friction of disagreement can ever break our bond of pure love.
            The real destruction of obstacles is possible not by external weapons, but solely through our inner unity and the immense power of pure thoughts.
            Let us make our workplace and family so sacred that evils don't even dare to enter, and only positive energy continuously resides there.
            When the stream of sweetness and selfless love flows, it possesses the amazing capability to melt even the hardest stone heart and turn it towards God.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 25,
        sanskrit = "आपो देवीरग्रेपुवो अग्रेगुवोऽग्र इमामद्य यज्ञं नयताग्रे यज्ञपतिं सुधातुम् ।\nयुष्मानिन्द्रोऽवृणीत वृत्रतूर्ये यूयमिन्द्रमवृणीध्वं वृत्रतूर्ये प्रोक्षिता स्थ ॥ २५ ॥",
        hindiCommentary = """
            (मंत्र की पुनरावृत्ति) हे दिव्य जल की देवियों! तुम सबसे पहले पवित्र करने वाली और सबसे आगे चलने वाली हो; आज हमारे इस यज्ञ और यजमान को श्रेष्ठ स्थान पर ले चलो।
            वृत्रासुर के वध के समय इंद्र ने तुम्हारी शक्ति का वरण किया था, और तुमने भी इंद्र का पूरा साथ दिया था; अब तुम भली-भांति प्रोक्षित (पवित्र) हो चुकी हो।
            जल 'अग्रणी' है; यह जीवन को निरंतर आगे बढ़ाता है और सृष्टि की हर प्रकार की अशुद्धि को पल भर में धो डालने की क्षमता रखता है।
            वृत्र उस अज्ञान का प्रतीक है जो हमारी चेतना को ढके रहता है; जल रूपी दिव्य ज्ञान ही उस आवरण को पूरी तरह से नष्ट कर सकता है।
            देवता भी प्रकृति की शक्तियों के सहयोग के बिना विजय प्राप्त नहीं कर सकते; यह प्रकृति और ईश्वरीय शक्तियों के सामंजस्य का प्रमाण है।
            हे परमात्मा! हमारे जीवन की धारा भी जल की तरह स्वच्छ और पारदर्शी हो और हम समाज की बुराइयों से लड़ने में हमेशा सत्य का ही साथ दें।
            जैसे जल ऊंच-नीच का भेद किए बिना सभी को जीवन देता है, वैसे ही हमारा प्रेम और सेवा भाव भी सभी के लिए समान और पूरी तरह निष्काम हो।
            हम स्वयं को इस दिव्य जल (ज्ञान) से सींच कर अपनी आत्मा को अज्ञान के वृत्र से मुक्त करें और परम स्वतंत्र तथा सत्यनिष्ठ बनें।
            जल की बूंद-बूंद में छिपी वह असीम शक्ति हमारे भीतर भी ऐसे ही जागृत हो जो हमें जीवन के सर्वोच्च और पवित्र लक्ष्यों तक पहुँचा दे।
            बार-बार इन मंत्रों का पाठ हमारे मन में दृढ़ता लाता है कि हमें जीवन भर सत्य के संग्राम में इंद्र के समान एक निर्भीक योद्धा बने रहना है।
        """.trimIndent(),
        englishCommentary = """
            (Repetition of mantra) O Goddesses of divine waters! You are the first to purify and the foremost to lead; today, lead this sacrifice and master to the highest state.
            During the slaying of Vritra, Indra chose your power, and you too fully supported Indra; now you have been thoroughly consecrated (purified).
            Water is the 'leader'; it continuously moves life forward and possesses the ability to wash away every kind of impurity of creation in a moment.
            Vritra symbolizes that ignorance which covers our consciousness; only the divine knowledge resembling water can completely destroy that veil.
            Even gods cannot achieve victory without the cooperation of nature's forces; this proves the profound harmony between Nature and divine forces.
            O Supreme Lord! May the stream of our lives be as clean and transparent as water, and may we always side with Truth in fighting societal evils.
            Just as water gives life to all without discrimination of high and low, may our love and service be equal and completely selfless for everyone.
            Let us irrigate ourselves with this divine water (knowledge) to free our souls from the Vritra of ignorance, becoming perfectly free and truthful.
            May that infinite power hidden in every drop of water awaken within us, taking us directly to the highest and holiest goals of life.
            Repeated chanting of these mantras brings firmness to our minds that we must remain fearless warriors like Indra in the battle of Truth lifelong.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 26,
        sanskrit = "दृंहस्व मा ह्वाः ।\nमित्रस्य त्वा चक्षुषा प्रेक्षे ॥ २६ ॥",
        hindiCommentary = """
            (मंत्र की पुनरावृत्ति) हे हविष्य (या साधक)! तू अत्यंत दृढ़ रह, अपने सत्य स्वरूप से कभी भी विचलित मत हो और किसी भी स्थिति में कुटिलता मत अपना।
            मैं तुम्हें 'मित्र' (सूर्य या स्नेही देव) की अत्यंत स्नेहपूर्ण, करुणा से भरी और समतामयी दृष्टि से देखता हूँ, जिसमें कोई भेदभाव नहीं है।
            यह मंत्र जीवन में दृढ़ता (दृंहस्व) और सरलता का सबसे सुंदर पाठ पढ़ाता है; कठिनाइयों में भी हमें अपने सत्य के मार्ग से नहीं हटना चाहिए।
            कुटिलता मनुष्य के पतन का सबसे बड़ा कारण है; जो ईश्वर का भक्त है, उसका स्वभाव सदैव जल की तरह सीधा, पारदर्शी और निर्मल होता है।
            'मित्र की दृष्टि' का अर्थ है सारे संसार को प्रेम और मित्रता के भाव से देखना, किसी को भी अपना शत्रु न मानना (वसुधैव कुटुम्बकम्)।
            सूर्य जैसे सभी पर समान रूप से प्रकाश डालता है, वैसे ही हमारी दृष्टि में भी ऊंच-नीच, अमीर-गरीब का कोई भी अनुचित भेद नहीं होना चाहिए।
            हे प्रभु! हमें इतनी शक्ति दें कि हम अपने सिद्धांतों पर अडिग रहें, परंतु हमारा व्यवहार दूसरों के प्रति अत्यंत कोमल और मित्रवत ही रहे।
            ईश्वर भी हमें उसी प्रेमपूर्ण दृष्टि से निहारता है; अतः हमें अपने भीतर के भयों को त्यागकर पूर्णतः निर्भय और शांत हो जाना चाहिए।
            हमारा जीवन ऐसा हो कि जो भी हमारे संपर्क में आए, वह केवल शांति, सौहार्द और ईश्वरीय प्रेम का ही अत्यंत सुखद अनुभव करे।
            सच्चा योगी वही है जो बाहर से वज्र के समान दृढ़ होता है, परंतु जिसका हृदय दूसरों के दुख को देखकर फूल के समान अत्यंत कोमल हो जाता है।
        """.trimIndent(),
        englishCommentary = """
            (Repetition of mantra) O Sacrificial Offering (or seeker)! Be extremely firm, never deviate from your true nature, and do not adopt crookedness in any situation.
            I look upon you with the extremely affectionate, compassionate, and equitable gaze of 'Mitra' (the Sun or friendly God), free from any bias.
            This mantra teaches the most beautiful lesson of firmness (Drinhasva) and simplicity in life; even in hardships, we must not waver from the path of truth.
            Crookedness is the biggest cause of human downfall; the nature of God's devotee is always straight, transparent, and pure like water.
            The 'gaze of Mitra' means looking at the whole world with feelings of love and friendship, considering no one an enemy (Vasudhaiva Kutumbakam).
            Just as the Sun shines equally on all, our vision should also have no unfair discrimination of high-low or rich-poor at all.
            O Lord! Give us so much strength that we remain unshakable on our principles, yet our behavior towards others remains extremely gentle and friendly.
            God also gazes at us with that same loving vision; therefore, we should abandon our inner fears and become completely fearless and peaceful.
            May our lives be such that whoever comes in contact with us experiences only a highly pleasant feeling of peace, harmony, and divine love.
            A true Yogi is one who is firm like a thunderbolt from the outside, but whose heart becomes extremely soft like a flower upon seeing others' sorrows.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 27,
        sanskrit = "अग्नेर्हव्यवाहनस्य धर्त्रमसि ।\nपवित्रे स्थो वैष्णव्यौ सवितुर्वः प्रसव उत्पुनाम्यच्छिद्रेण पवित्रेण सूर्यस्य रश्मिभिः ॥ २७ ॥",
        hindiCommentary = """
            (मंत्र की पुनरावृत्ति) हे सूप (यज्ञ का उपकरण)! तू देवों तक हवि ले जाने वाले अग्निदेव का आधार और उन्हें धारण करने वाला महान साधन है।
            हे कुशा के दलो! तुम विष्णु से संबंधित और पवित्र करने वाले हो; सविता देव की प्रेरणा से, छिद्ररहित कुशा और सूर्य की रश्मियों से मैं तुम्हें शुद्ध करता हूँ।
            यज्ञ में अन्न को फटकने वाले सूप का यह मंत्र हमारी उस 'विवेक बुद्धि' का प्रतीक है, जो सत्य और असत्य, अच्छे और बुरे को एक-दूसरे से अलग कर देती है।
            अग्नि हवि को स्वर्ग तक ले जाती है, परंतु अग्नि तक पहुँचने से पूर्व हवि को शुद्ध होना ही चाहिए; यह हमारी आंतरिक शुद्धि की अनिवार्य प्रक्रिया है।
            विष्णु सर्वव्यापी हैं; जब हम कुशा से पवित्रीकरण करते हैं, तो हम वास्तव में स्वयं को उस असीम विष्णु की विराट चेतना से जोड़ रहे होते हैं।
            हे प्रभु! हमारे मन में ऐसा तीक्ष्ण विवेक उत्पन्न करें कि हम अपने भीतर के दुर्गुणों को उसी प्रकार फटक कर बाहर कर दें जैसे सूप भूसी को कर देता है।
            सूर्य की किरणें जैसे संपूर्ण जगत के अंधकार को नष्ट कर देती हैं, वैसे ही आपका ईश्वरीय ज्ञान हमारे अज्ञान के पर्दों को हमेशा के लिए जला दे।
            हमारा जीवन ऐसा निर्मल हो जाए कि हमारा हर कर्म अग्निदेव के माध्यम से सीधे आपके श्रीचरणों में एक पावन आहुति बनकर सहर्ष स्वीकार हो।
            जो व्यक्ति स्वयं को छिद्ररहित (पूर्णतः एकाग्र और निष्पाप) कर लेता है, वही ईश्वर की अनंत प्रेरणा और कृपा को प्राप्त करने का वास्तविक अधिकारी बनता है।
            यह मंत्र हमें याद दिलाता है कि केवल बाहरी कर्मकांड पर्याप्त नहीं हैं; जब तक भीतर का अन्न (विचार) साफ नहीं होता, तब तक यज्ञ अधूरा ही रहता है।
        """.trimIndent(),
        englishCommentary = """
            (Repetition of mantra) O winnowing basket! You are the foundation and supporter of Agni, the carrier of oblations to the divine gods.
            O blades of Kusha! You belong to Vishnu and are purifiers; impelled by Savitar, I purify you with the flawless Kusha and the sun's bright rays.
            This mantra of the basket that cleans the grain is the symbol of our 'discriminating intellect', which separates truth from untruth, and good from bad.
            Agni carries the oblation to heaven, but before reaching Agni, the oblation must be pure; this is our compulsory internal purification process.
            Vishnu is omnipresent; when we purify with Kusha, we are actually connecting ourselves directly with the vast consciousness of that infinite Vishnu.
            O Lord! Generate such sharp discrimination in our minds that we winnow out our inner flaws just as the basket throws out the husk.
            Just as the sun's rays destroy the darkness of the entire world, may Your divine knowledge burn away the veils of our ignorance forever.
            May our lives become so pure that every action of ours is joyfully accepted directly at Your holy feet as a sacred oblation through Lord Agni.
            The person who makes himself flawless (completely concentrated and sinless) becomes the true recipient capable of receiving God's infinite inspiration.
            This mantra reminds us that mere external rituals are not enough; until the inner grain (thoughts) is clean, the sacrifice remains completely incomplete.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 28,
        sanskrit = "देवो वः सविताोत्पुनात्वच्छिद्रेण पवित्रेण सूर्यस्य रश्मिभिः ।\nतासामुशिग्भिः प्र भराम्यग्निमृतेन सत्यमृतात्सत्यं प्र भवामि ॥ २८ ॥",
        hindiCommentary = """
            सृष्टिकर्ता सविता देव तुम्हें छिद्ररहित पवित्र कुशा और सूर्य की अत्यंत उज्ज्वल किरणों से भली-भांति शुद्ध और पावन करें।
            उन कामनाशील और शुद्ध शक्तियों के साथ मैं अग्नि को भली-भांति प्रज्वलित करता हूँ।
            मैं ऋत (सच्चाई के शाश्वत नियम) से सत्य को और सत्य से ऋत को उत्पन्न (स्थापित) करता हूँ।
            यह मंत्र ऋत (ब्रह्मांडीय नियम और सही कर्म) तथा सत्य (शाश्वत तत्व) के बीच के अटूट और अत्यंत गहरे संबंध को स्पष्टता से उद्घाटित करता है।
            सत्य केवल एक विचार या शब्द नहीं है; जब वह हमारे आचरण और कर्म में पूरी तरह से उतरता है, तो वह ऋत बन जाता है।
            सही आचरण (ऋत) ही अंततः हमें उस परम सत्य (ईश्वर) के साक्षात् दर्शन कराता है, जहाँ कोई भी भ्रम शेष नहीं रहता।
            सूर्य की किरणें और पवित्र कुशा इस बात का प्रतीक हैं कि हमारी चेतना में अज्ञान का अंधकार पूरी तरह मिट जाना चाहिए।
            हे परमात्मा! हमारा प्रत्येक कर्म सत्य पर आधारित हो और हमारे कर्मों के फलस्वरूप समाज में केवल सत्य की ही महान प्रतिष्ठा और विजय हो।
            सत्य और ऋत के पालन से ही यज्ञ (शुभ कर्म) सफल होता है और साधक को ईश्वरीय शक्तियों का पूर्ण और अमोघ आशीर्वाद प्राप्त होता है।
            हमारा पूरा जीवन सत्य से शुरू होकर सत्य पर ही समाप्त हो, ताकि हम ईश्वरीय व्यवस्था के एक श्रेष्ठ, शुद्ध और अभिन्न अंग बन सकें।
        """.trimIndent(),
        englishCommentary = """
            May the Creator Savitar thoroughly purify and sanctify you with the flawless sacred Kusha and the extremely bright rays of the sun.
            With those desirous and pure forces, I properly and brightly kindle the Agni.
            I manifest (establish) Truth from Rta (the eternal law of righteousness) and Rta from Truth.
            This mantra unveils the unbroken and extremely deep relationship between Rta (cosmic law/correct action) and Truth (eternal reality) with clarity.
            Truth is not just a thought or word; when it completely descends into our conduct and actions, it becomes Rta.
            Correct conduct (Rta) ultimately grants us the direct vision of that Supreme Truth (God), where absolutely no illusion remains.
            The sun's rays and the sacred Kusha symbolize that the darkness of ignorance in our consciousness must be completely erased.
            O Supreme Lord! May every action of ours be based on truth, and as a result of our deeds, may only truth be greatly established and victorious.
            Only by following Truth and Rta does a sacrifice (noble deed) succeed, and the seeker receives the full and infallible blessing of divine forces.
            May our entire life start with truth and end in truth, so that we can become an excellent, pure, and integral part of the divine cosmic order.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 29,
        sanskrit = "अग्ने व्रतपते व्रतं चरिष्यामि तच्छकेयं तन्मे राध्यताम् ।\nइदमहमनृतात्सत्यमुपैमि ॥ २९ ॥",
        hindiCommentary = """
            (सत्य के व्रत की पुनरावृत्ति) हे व्रतों के रक्षक अग्निदेव! मैं सत्य के मार्ग पर चलने का व्रत लेता हूँ; मुझे इसे पूरा करने की शक्ति दें और मेरा यह व्रत सफल हो।
            मैं इस दृढ़ संकल्प के माध्यम से असत्य (अज्ञान, बुराई और स्वार्थ) को पूरी तरह छोड़कर शाश्वत सत्य (ज्ञान और ईश्वरीय मार्ग) की ओर गमन करता हूँ।
            यह यजुर्वेद का सबसे शक्तिशाली और प्रसिद्ध मंत्र है, जो मनुष्य के भीतर के आत्म-परिवर्तन और नैतिक जागरण की तीव्र आकांक्षा को दर्शाता है।
            अग्नि को व्रतपति इसलिए कहा गया है क्योंकि अग्नि सर्वव्यापी साक्षी है और उसकी ज्योति हमें सदा हमारे पावन संकल्प की याद दिलाती रहती है।
            सत्य के मार्ग पर चलना अत्यंत कठिन है, इसलिए साधक ईश्वर से केवल प्रेरणा नहीं, बल्कि उस मार्ग पर आजीवन टिके रहने की शक्ति मांगता है।
            असत्य से सत्य की ओर जाने का अर्थ केवल झूठ बोलना छोड़ना नहीं है, बल्कि जीवन के हर क्षण में यथार्थ, न्याय और धर्म को अपनाना है।
            हम अज्ञान के अंधकार से निकलकर उस दिव्य प्रकाश की ओर जाना चाहते हैं जहाँ आत्मा का वास्तविक और शाश्वत स्वरूप प्रकट होता है।
            हे देव! जब भी मेरे कदम डगमगाएं, आप मेरी रक्षा करें और मुझे पुनः मेरे उच्च आदर्शों और सत्य के संकल्पों की ओर मोड़ दें।
            यही वह मंत्र है जो मनुष्य को पशु स्तर से उठाकर देवत्व की ओर ले जाता है, क्योंकि सत्य ही ईश्वर का साक्षात् और सबसे शुद्ध स्वरूप है।
            हमारा पूरा जीवन इसी व्रत का एक अखंड पालन बन जाए, जिससे अंत समय में हमें परम शांति और साक्षात् ईश्वर की प्राप्ति हो सके।
        """.trimIndent(),
        englishCommentary = """
            (Repetition of the vow of Truth) O Agni, Lord of Vows! I shall observe the vow of Truth; grant me the strength to fulfill it, and may my vow be successful.
            Through this firm resolve, I completely abandon untruth (ignorance, evil, and selfishness) and approach Eternal Truth (knowledge and God).
            This is the most powerful and famous mantra of the Yajurveda, showing humanity's intense desire for inner transformation and moral awakening.
            Agni is called the Lord of Vows because fire is the omnipresent witness, and its light constantly reminds us of our holy resolve.
            Walking the path of truth is very difficult, so the seeker asks God not just for inspiration, but for the strength to persist on that path lifelong.
            Moving from untruth to truth does not just mean stopping lies; it means adopting reality, justice, and Dharma in every moment of life.
            We wish to leave the darkness of ignorance and step into the divine light where the true, eternal nature of the soul is directly revealed.
            O God! Whenever my steps falter, protect me and turn me back toward my high ideals and firm resolutions of Truth.
            This is the mantra that elevates a person from an animalistic level to divinity, because Truth is the direct and purest form of God.
            May our entire life become an unbroken observance of this vow, so that in the end, we attain supreme peace and God Himself.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 30,
        sanskrit = "व्रतेन दीक्षामाप्नोति दीक्षयाऽऽप्नोति दक्षिणाम् ।\nदक्षिणा श्रद्धामाप्नोति श्रद्धया सत्यमाप्यते ॥ ३० ॥",
        hindiCommentary = """
            (सफलता और सत्य के सूत्र की पुनरावृत्ति) मनुष्य व्रत (सच्चे संकल्प) से दीक्षा प्राप्त करता है, और दीक्षा के कठोर पालन से उसे दक्षिणा (सफलता) प्राप्त होती है।
            उस सफलता से हृदय में गहरी श्रद्धा जाग्रत होती है, और जब श्रद्धा अटल हो जाती है, तभी मनुष्य परम सत्य का साक्षात् अनुभव कर पाता है।
            वैदिक परंपरा में यह मंत्र मनुष्य के पूर्ण आध्यात्मिक विकास का अचूक और वैज्ञानिक सूत्र है; संकल्प के बिना किसी भी यात्रा का आरंभ कभी संभव नहीं है।
            दीक्षा हमें एक निश्चित नियम और अनुशासन में बांधती है, जो हमारे बिखरे हुए मन को एकाग्र कर हमारी शक्तियों को एक सही दिशा देती है।
            कर्म का जो फल (दक्षिणा) हमें मिलता है, वह कोई भौतिक पुरस्कार नहीं, बल्कि हमारी आत्मिक उन्नति का वह संतोष है जो हमें निरंतर आगे बढ़ाता है।
            सफलता से उपजा हुआ विश्वास (श्रद्धा) हमें ईश्वर के न्याय पर पूर्ण भरोसा करना सिखाता है, जिससे जीवन के सभी संशय हमेशा के लिए मिट जाते हैं।
            सत्य कोई वस्तु नहीं है जिसे पाया जा सके; यह वह अवस्था है जहाँ पहुंचने पर साधक स्वयं सत्य स्वरूप (ब्रह्ममय) हो जाता है।
            हे देव! हमें संकल्प में दृढ़ता और कर्म में ऐसा अनुशासन दें कि हमारे भीतर की श्रद्धा कभी भी सांसारिक दुखों या लालच से डगमगाए नहीं।
            जब हम सत्य को प्राप्त कर लेते हैं, तब हमें ज्ञात होता है कि संसार की सभी भौतिक वस्तुएं उस परम आनंद के सामने अत्यंत तुच्छ और नश्वर हैं।
            हमारा यह व्रत अखंड रहे कि हम असत्य का त्याग कर सदैव सत्य का ही आचरण करेंगे, क्योंकि सत्य ही ईश्वर तक पहुँचने का एकमात्र मार्ग है।
        """.trimIndent(),
        englishCommentary = """
            (Repetition of the formula for success and Truth) By a vow (firm resolve), one obtains initiation; by strict initiation, one naturally obtains success (Dakshina).
            From that success, deep faith is awakened in the heart, and when faith becomes unwavering, one directly experiences the Supreme Truth.
            In the Vedic tradition, this mantra is the infallible and scientific formula for human spiritual development; without resolve, starting any journey is never possible.
            Initiation binds us in a certain rule and discipline, which concentrates our scattered mind and gives our powers a correct and focused direction.
            The fruit of action (Dakshina) we receive is not a material reward, but that satisfaction of our spiritual progress which pushes us continuously ahead.
            The trust (faith) born from success teaches us to fully rely on God's justice, eradicating all doubts of life forever and completely.
            Truth is not an object to be found; it is that state reaching which the seeker himself becomes the embodiment of Truth (Brahman).
            O God! Give us firmness in resolve and such discipline in action that the faith within us never wavers due to worldly sorrows or greed.
            When we attain Truth, we realize that all material things of the world are extremely trivial and perishable compared to that supreme bliss.
            May this vow of ours remain unbroken: that we shall abandon untruth and always practice Truth, for Truth is the only path to reach the Divine.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 31,
        sanskrit = "कस्त्वा युनक्ति स त्वा युनक्ति कस्मै त्वा युनक्ति तस्मै त्वा युनक्ति ।\nकर्मणे वां वेषाय वाम् ॥ ३१ ॥",
        hindiCommentary = """
            (ईश्वरीय समर्पण की पुनरावृत्ति) तुम्हें कौन (प्रजापति/ईश्वर) नियुक्त करता है? वह परमेश्वर ही तुम्हें नियुक्त करता है। वह तुम्हें किसलिए नियुक्त करता है? उसी (परम सुख) के लिए।
            मैं तुम दोनों (यज्ञ के उपकरणों या प्राण और अपान) को श्रेष्ठ कर्म की सिद्धि और यज्ञादि महान कार्यों के विस्तार के लिए नियुक्त करता हूँ।
            इस मंत्र में 'कः' शब्द का प्रयोग उस अव्यक्त ईश्वर के लिए किया गया है जो संपूर्ण सृष्टि का एकमात्र नियंता और सूत्रधार है।
            यह दर्शन कराता है कि संसार में जो भी कार्य हो रहा है, वह हमारी मर्जी से नहीं, बल्कि ईश्वरीय इच्छा और उसकी व्यापक व्यवस्था के अंतर्गत ही हो रहा है।
            हमारा कोई भी कर्म व्यक्तिगत नहीं है; जब हम उसे ईश्वर को समर्पित कर देते हैं, तो वह 'कस्मै' (ईश्वर के लिए) हो जाता है और पवित्र बन जाता है।
            प्राण और ऊर्जा का उपयोग केवल स्वार्थ के लिए नहीं, बल्कि समाज के मंगल और श्रेष्ठ आध्यात्मिक कर्मों के लिए ही होना चाहिए।
            यह प्रश्नोत्तर शैली साधक को यह याद दिलाती है कि उसके जीवन का मूल स्रोत और अंतिम लक्ष्य केवल और केवल परमात्मा ही है।
            हे प्रभु! हमें यह बोध सदा रहे कि हमारी सभी क्षमताएं आपकी ही दी हुई हैं और हमें उनका उपयोग आपके ही श्रेष्ठ कार्यों में करना है।
            कर्म की श्रेष्ठता इस बात में है कि वह बिना किसी अहंकार के किया जाए और उसका फल संपूर्ण सृष्टि के कल्याण के लिए हो।
            यह मंत्र हमें निमित्त मात्र बनकर कर्मयोग के उस उच्च शिखर पर पहुँचने की महान प्रेरणा देता है जहाँ केवल पूर्ण शांति का वास है।
        """.trimIndent(),
        englishCommentary = """
            (Repetition of divine surrender) Who (God) yokes you? That Supreme Lord yokes you. For what purpose does He yoke you? For Him (supreme bliss).
            I yoke both of you (sacrificial tools or Prana and Apana) for the accomplishment of noble deeds and the expansion of great sacrificial works.
            In this mantra, the word 'Kah' (Who) is used for the unmanifest God who is the sole controller and orchestrator of the entire creation.
            It philosophizes that whatever action is happening in the world is not by our will, but falls strictly under the divine will and His vast cosmic order.
            None of our actions are purely personal; when we surrender them to God, they become 'Kasmai' (for the sake of the Divine) and become holy.
            The use of vitality and energy should not be merely for selfish ends but for the welfare of society and high spiritual deeds.
            This question-and-answer style reminds the seeker that the root source and ultimate goal of their life is solely the Supreme.
            O Lord! Keep us always aware that all our capabilities are given by You, and we must use them strictly in Your excellent works.
            The greatness of an action lies in it being performed without ego, and its fruits being dedicated to universal welfare.
            This mantra deeply inspires us to become mere instruments and reach the peak of Karma Yoga where only complete peace resides.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 32,
        sanskrit = "प्रत्युष्टं रक्षः प्रत्युष्टा अरातयो निष्टप्तं रक्षो निष्टप्ता अरातयः ।\nअग्नेस्तेजसा सूर्यस्य वर्चसा ॥ ३२ ॥",
        hindiCommentary = """
            (नकारात्मकता के नाश की पुनरावृत्ति) राक्षसी प्रवृत्तियों को पूरी तरह से तपा कर नष्ट कर दिया गया है; कृपणता और शत्रुता के भावों को जलाकर भस्म कर दिया गया है।
            इन विघ्नकारी शक्तियों को मैंने अग्नि के प्रखर तेज और भगवान सूर्य के महान वर्चस्व (प्रकाश) से पूरी तरह समाप्त कर दिया है।
            अग्नि और सूर्य दोनों ही प्रकाश और ऊर्जा के सबसे बड़े स्रोत हैं; जहाँ सत्य का प्रकाश होता है, वहाँ अज्ञान या बुराई रूपी अंधकार टिक ही नहीं सकता।
            हमारे जीवन में 'राक्षस' कोई बाहरी जीव नहीं, बल्कि हमारे ही कुविचार, क्रोध और स्वार्थ हैं जो हमारे श्रेष्ठ कर्मों में हमेशा बाधा डालते हैं।
            'अराति' वह संकीर्णता है जो हमें दान, परोपकार और प्रेम करने से रोकती है; इसे ज्ञान की ज्वाला में जलाना परम आवश्यक है।
            हे अग्निदेव! आप हमारे अंतःकरण में उठने वाले हर दूषित विचार को अपने तेज से जला दें और हमारे हृदय को सूर्य के समान निर्मल बनाएं।
            जब साधक सूर्य और अग्नि की दिव्य ऊर्जा से जुड़ जाता है, तो उसे संसार का कोई भी भय या चिंता कभी भी विचलित नहीं कर सकती।
            सच्चा यज्ञ वही है जहाँ भीतर और बाहर दोनों ओर पूरी पवित्रता हो; बिना आंतरिक शुद्धि के किया गया कर्म केवल एक दिखावा मात्र रह जाता है।
            हम ईश्वरीय तेज को धारण कर पूर्णतः निर्भय बनें और समाज से अज्ञान तथा बुराइयों को मिटाने के लिए सदैव संकल्पित और तत्पर रहें।
            बार-बार इस मंत्र का उच्चारण हमें यह स्मरण कराता है कि हमें अपने भीतर की बुराइयों के प्रति हमेशा सतर्क और कठोर रहना चाहिए।
        """.trimIndent(),
        englishCommentary = """
            (Repetition of destroying negativity) Demonic tendencies have been completely scorched and destroyed; feelings of miserliness and enmity are burnt to ashes.
            I have entirely eradicated these disruptive forces with the fierce brilliance of Agni and the great luminous power of the Sun God.
            Both Agni and the Sun are the greatest sources of light and energy; where there is the light of truth, the darkness of ignorance cannot survive.
            In our lives, 'demons' are not external creatures, but our own bad thoughts, anger, and selfishness that always obstruct our noble deeds.
            'Arati' is that narrow-mindedness which stops us from charity, benevolence, and love; burning it in the flame of knowledge is absolutely essential.
            O Agni! Burn every polluted thought arising in our conscience with your brilliance and make our hearts as pure as the Sun.
            When a seeker connects with the divine energy of the Sun and Agni, no fear or worry of the world can ever disturb them.
            True sacrifice is that where there is complete purity both inside and outside; an action done without internal purity remains a mere show.
            Let us bear the divine brilliance to become completely fearless, and remain constantly resolved to eradicate ignorance and evils from society.
            Repeated chanting of this mantra reminds us that we must always remain alert and strict against the evils hiding within ourselves.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 33,
        sanskrit = "उरु वाताय ।\nदेवस्य त्वा सवितुः प्रसवेऽश्विनोर्बाहुभ्यां पूष्णो हस्ताभ्यामाददे ॥ ३३ ॥",
        hindiCommentary = """
            (विस्तार की पुनरावृत्ति) हे वायु देव! आप इस यज्ञ स्थल को अत्यंत विस्तृत (उरु) करें और यहाँ बिना किसी बाधा के निर्बाध रूप से प्रवाहित हों।
            सृष्टिकर्ता सविता देव की पावन प्रेरणा से, अश्विनीकुमारों की बलशाली भुजाओं से और पूषा देव के मजबूत हाथों से मैं इन यज्ञपात्रों को ग्रहण करता हूँ।
            विस्तार का अर्थ है कि हमारा मन संकीर्णताओं से पूरी तरह मुक्त हो जाए और वायु की तरह उन्मुक्त होकर पूरी सृष्टि के कल्याण की ही कामना करे।
            साधक अहंकार त्याग कर यह मानता है कि वह अपने हाथों से नहीं, बल्कि देवताओं की दिव्य शक्तियों के माध्यम से यह पावन कार्य कर रहा है।
            सविता की प्रेरणा हमें यह याद दिलाती है कि हमारे हर शुभ विचार का मूल स्रोत वह परमपिता परमात्मा ही है, हम तो केवल निमित्त मात्र हैं।
            हे प्रभु! हमारे जीवन में विचारों का ऐसा स्वतंत्र और शुद्ध प्रवाह हो कि कोई भी कुंठा या दुराग्रह हमारे मन में कभी घर न कर सके।
            जब मनुष्य स्वयं को ईश्वरीय हाथों का उपकरण मान लेता है, तो उसके कर्म दोषरहित हो जाते हैं और उसे असीम शांति की प्राप्ति होती है।
            अश्विनीकुमारों से हम आरोग्य मांगते हैं और पूषा से पुष्टि; ताकि हम स्वस्थ शरीर से धर्म के मार्ग पर आजीवन दृढ़ता से चल सकें।
            हमारा जीवन इस यज्ञ के समान ऐसा पवित्र हो कि हम स्वयं के साथ-साथ संपूर्ण विश्व को ऊर्जा, स्वास्थ्य और ज्ञान प्रदान कर सकें।
            अहंकार शून्यता ही वह परम अवस्था है जहाँ ईश्वर स्वयं मनुष्य के माध्यम से संसार में अपने महान कार्यों को रूप देते हैं।
        """.trimIndent(),
        englishCommentary = """
            (Repetition of expansion) O Wind God! Make this sacrificial place extremely vast (Uru) and flow here continuously without any obstruction.
            Impelled by the Divine Savitar, with the strong arms of the Ashvins, and with the firm hands of Pushan, I take these sacrificial vessels.
            Expansion means our mind should be completely free from narrowness and, unbound like the wind, wish solely for the absolute welfare of creation.
            Abandoning ego, the seeker believes he is not working with his own hands, but through the divine powers of the gods performing this holy task.
            Savitar's inspiration reminds us that the root source of every auspicious thought is the Supreme Father; we are mere instruments.
            O Lord! Let there be such a free and pure flow of thoughts in our lives that no frustration or prejudice can ever settle in our minds.
            When a human considers himself a tool in divine hands, his actions become flawless and he attains boundless, eternal peace.
            From the Ashvins we ask for health and from Pushan nourishment; so that with a healthy body, we can firmly walk the path of Dharma lifelong.
            May our life be as sacred as this sacrifice, so we can provide energy, health, and profound knowledge to ourselves and the whole world.
            Egolessness is that supreme state where God Himself gives shape to His great works in the world directly through the human being.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 34,
        sanskrit = "इदमहं रक्षसो ग्रीवा अपि कृन्तामि ।\nयवोऽसि यवयास्मद्वेषो यवयारातीः ॥ ३४ ॥\n(नोट: यह द्वितीय अध्याय का अन्तिम मन्त्र है।)",
        hindiCommentary = """
            मैं इस वेदी पर विघ्न डालने वाले राक्षस (बुराइयों) की गर्दन को अत्यंत दृढ़ता से काटता हूँ।
            हे जौ (यव)! तू अन्न का श्रेष्ठ रूप है; तू हमारे द्वेष (शत्रुता) को हमसे दूर कर दे, और हमारी अराति (कंजूसी और नकारात्मकता) का समूल नाश कर दे।
            द्वितीय अध्याय का यह अंतिम मंत्र बुराइयों के विरुद्ध एक अत्यंत कठोर और निर्णायक प्रहार के साथ इस यज्ञीय चरण का समापन करता है।
            यहाँ 'राक्षस की गर्दन काटना' एक प्रतीकात्मक क्रिया है; यह वास्तव में हमारे भीतर के अहंकार, लोभ और वासना रूपी असुरों का अंतिम वध है।
            यज्ञ में प्रयुक्त होने वाला 'जौ' (यव) केवल धान्य नहीं है, बल्कि वह उन सभी प्रवृत्तियों को दूर ('यवय') करने का प्रतीक है जो धर्म के विरुद्ध हैं।
            मनुष्य का सबसे बड़ा शत्रु उसके बाहर नहीं, बल्कि उसका अपना द्वेष और संकीर्णता है, जो उसकी आध्यात्मिक प्रगति को हमेशा रोक देता है।
            हे परमात्मा! हमें वह अदम्य साहस दें कि हम अपनी बुराइयों पर निर्दयता से प्रहार कर सकें और अपने जीवन को पूर्णतः दोषमुक्त बना सकें।
            जब तक मन से कंजूसी (अराति) नहीं जाती, तब तक मनुष्य कभी भी ईश्वर के प्रति पूर्ण समर्पण या समाज के लिए निस्वार्थ सेवा नहीं कर सकता।
            सच्चा यज्ञ वही है जो समाज से शत्रुता को मिटाकर प्रेम और सद्भाव के अंकुर बोए; जौ उसी वृद्धि, शांति और पवित्रता का महान प्रतीक है।
            इस मंत्र के साथ द्वितीय अध्याय पूर्ण होता है, जहाँ साधक बाहरी और भीतरी दोनों शत्रुओं का नाश कर परम शांति का अनुभव करता है। ॐ शान्तिः।
        """.trimIndent(),
        englishCommentary = """
            I firmly cut the neck of the demon (evils) that causes obstacles on this sacred altar.
            O Barley (Yava)! You are the excellent form of food; keep our malice (enmity) far away from us, and completely destroy our Arati (miserliness).
            This final mantra of the second chapter concludes this sacrificial phase with an extremely strict and decisive strike against all evils.
            Here, 'cutting the demon's neck' is a symbolic act; it is actually the final slaying of the inner demons in the form of ego, greed, and lust.
            The 'barley' (Yava) used in the sacrifice is not just grain; it symbolizes warding off ('Yavaya') all tendencies that are strictly against Dharma.
            A human's biggest enemy is not outside, but their own malice and narrow-mindedness, which always halts their spiritual progress.
            O Supreme Lord! Give us that indomitable courage so we can ruthlessly strike down our own evils and make our lives entirely flawless.
            As long as miserliness (Arati) does not leave the mind, a person can never fully surrender to God or perform selfless service for society.
            True sacrifice is that which erases enmity from society and sows the seeds of love; barley is the great symbol of that growth, peace, and purity.
            With this mantra, the second chapter is completed, where the seeker experiences supreme peace by destroying both external and internal enemies. Om Shanti.
        """.trimIndent()
    )
)